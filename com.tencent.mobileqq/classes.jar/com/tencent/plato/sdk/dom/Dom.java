package com.tencent.plato.sdk.dom;

import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import com.tencent.plato.IPlatoManager.IRenderListener;
import com.tencent.plato.IPlatoRuntime;
import com.tencent.plato.IPlatoSurface;
import com.tencent.plato.core.IReadableArray;
import com.tencent.plato.core.IReadableMap;
import com.tencent.plato.core.utils.AssertUtil;
import com.tencent.plato.core.utils.PLog;
import com.tencent.plato.core.utils.TimeMonitorUtils;
import com.tencent.plato.core.utils.Tracker;
import com.tencent.plato.layout.LayoutEngine;
import com.tencent.plato.sdk.animation.PKeyFrame;
import com.tencent.plato.sdk.element.IElement;
import com.tencent.plato.sdk.element.IElement.IProvider;
import com.tencent.plato.sdk.element.IProperty;
import com.tencent.plato.sdk.element.PDivElement;
import com.tencent.plato.sdk.render.PRect;
import com.tencent.plato.sdk.render.Render;
import com.tencent.plato.sdk.render.RenderData;
import com.tencent.plato.sdk.render.RenderData.RenderOperation;
import com.tencent.plato.sdk.render.data.ElementItem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import org.json.JSONObject;

public class Dom
  implements IDom
{
  private static final String TAG = "Dom";
  public final int MSG_UPDATE_FINISH = 1;
  private IElement body;
  private Handler bridgeHandler;
  private final HashSet<Integer> mBlockList = new HashSet();
  private final Map<String, IElement.IProvider> mElementProviders;
  private final Map<Integer, IElement> mElements = new HashMap();
  private HashSet<Integer> mElementsInTree = new HashSet();
  private Map<String, PKeyFrame> mKeyFrames = new HashMap();
  private final LayoutEngine mLayoutEngine;
  private final HashSet<Integer> mNotCalculateList = new HashSet();
  private Map<Integer, PRect> mOldTreePos = new HashMap();
  private final Render mRender;
  private final Handler mRenderHandler;
  private IPlatoManager.IRenderListener mRenderListener;
  private Set<Integer> needUpdates = new HashSet();
  private HashSet<Integer> removeList = new HashSet();
  
  public Dom(IPlatoRuntime paramIPlatoRuntime, int paramInt, Map<String, IElement.IProvider> paramMap, Handler paramHandler, IPlatoManager.IRenderListener paramIRenderListener)
  {
    this.mElementProviders = paramMap;
    this.mRenderListener = paramIRenderListener;
    this.mLayoutEngine = new LayoutEngine();
    this.mRender = new Render(paramIPlatoRuntime, paramInt, paramMap, paramIRenderListener);
    this.mRenderHandler = this.mRender.getHandler();
    if (paramHandler != null) {
      this.bridgeHandler = new Handler(paramHandler.getLooper(), new Handler.Callback()
      {
        public boolean handleMessage(Message paramAnonymousMessage)
        {
          if (paramAnonymousMessage.what == 1)
          {
            Dom.this.preUpdate(true);
            return true;
          }
          return false;
        }
      });
    }
  }
  
  private void addNodeInTree(IElement paramIElement)
  {
    PLog.d("Dom", "addNodeInTree :" + paramIElement.getElementId());
    this.mElementsInTree.add(Integer.valueOf(paramIElement.getElementId()));
    int i = 0;
    while (i < paramIElement.getChildCount())
    {
      addNodeInTree(paramIElement.getChildAt(i));
      i += 1;
    }
  }
  
  private void diffVisit(IElement paramIElement, int paramInt)
  {
    int i;
    if (this.mOldTreePos.containsKey(Integer.valueOf(paramIElement.getElementId())))
    {
      localObject = (PRect)this.mOldTreePos.get(Integer.valueOf(paramIElement.getElementId()));
      if ((((PRect)localObject).left != (int)paramIElement.getLayoutX()) || (((PRect)localObject).top != (int)paramIElement.getLayoutY()) || (((PRect)localObject).width != (int)paramIElement.getLayoutWidth()) || (((PRect)localObject).height != (int)paramIElement.getLayoutHeight()))
      {
        this.needUpdates.add(Integer.valueOf(paramIElement.getElementId()));
        this.mOldTreePos.put(Integer.valueOf(paramIElement.getElementId()), new PRect(paramIElement.getElementId(), paramInt, (int)paramIElement.getLayoutX(), (int)paramIElement.getLayoutY(), (int)paramIElement.getLayoutWidth(), (int)paramIElement.getLayoutHeight()));
      }
      i = 0;
      label186:
      if (i >= paramIElement.getChildCount()) {
        return;
      }
      if ((!paramIElement.isDisplayNone()) || (paramIElement.isNotCalculate())) {
        break label304;
      }
    }
    for (;;)
    {
      i += 1;
      break label186;
      this.needUpdates.add(Integer.valueOf(paramIElement.getElementId()));
      this.mOldTreePos.put(Integer.valueOf(paramIElement.getElementId()), new PRect(paramIElement.getElementId(), paramInt, (int)paramIElement.getLayoutX(), (int)paramIElement.getLayoutY(), (int)paramIElement.getLayoutWidth(), (int)paramIElement.getLayoutHeight()));
      break;
      label304:
      if (paramInt < 0) {
        break label323;
      }
      diffVisit(paramIElement.getChildAt(i), paramInt);
    }
    label323:
    Object localObject = paramIElement.getChildAt(i);
    if (paramIElement.isBlockType()) {}
    for (int j = paramIElement.getElementId();; j = -1)
    {
      diffVisit((IElement)localObject, j);
      break;
    }
  }
  
  private void removeNodeFromTree(IElement paramIElement)
  {
    PLog.d("Dom", "removeNodeFromTree :" + paramIElement.getElementId() + "; node count : " + paramIElement.getChildCount());
    int i = 0;
    while (i < paramIElement.getChildCount())
    {
      removeNodeFromTree(paramIElement.getChildAt(i));
      i += 1;
    }
    this.mElementsInTree.remove(Integer.valueOf(paramIElement.getElementId()));
    this.mElements.remove(Integer.valueOf(paramIElement.getElementId()));
    if (paramIElement.isBlockType()) {
      this.mBlockList.remove(Integer.valueOf(paramIElement.getElementId()));
    }
    if (paramIElement.isNotCalculate()) {
      this.mNotCalculateList.remove(Integer.valueOf(paramIElement.getElementId()));
    }
    if (paramIElement.getElementId() == 714) {
      PLog.d("Dom", "removeNodeFromTree 714");
    }
    if ((paramIElement.getState() & 0x1) != 0)
    {
      PLog.d("Dom", "remove the created node " + paramIElement.getElementId());
      return;
    }
    this.removeList.add(Integer.valueOf(paramIElement.getElementId()));
    PLog.d("Dom", "remove id: " + paramIElement.getElementId());
  }
  
  public void addElement(IPlatoRuntime paramIPlatoRuntime, IReadableMap paramIReadableMap, int paramInt1, int paramInt2)
  {
    paramIPlatoRuntime = createBodyImpl(paramIPlatoRuntime, paramIReadableMap, isElementInTree(paramInt1));
    int i = paramInt2;
    IElement localIElement = (IElement)this.mElements.get(Integer.valueOf(paramInt1));
    if ((localIElement != null) && ((localIElement instanceof PDivElement)))
    {
      paramInt1 = i;
      if (i == -1) {
        paramInt1 = localIElement.getChildCount();
      }
      paramIPlatoRuntime.setIndex(paramInt2);
      localIElement.addChildAt(paramIPlatoRuntime, paramInt1);
      if (isElementInTree(localIElement.getElementId())) {
        addNodeInTree(paramIPlatoRuntime);
      }
      if (paramIReadableMap.has("id"))
      {
        paramIReadableMap = paramIReadableMap.getString("id", null);
        this.mElements.put(Integer.valueOf(Integer.parseInt(paramIReadableMap)), paramIPlatoRuntime);
        return;
      }
      PLog.w("Dom", "addElement without element_id [" + paramIReadableMap + "]");
      return;
    }
    PLog.e("Dom", "addElement error. [readableMap:" + paramIReadableMap + ", parentRefId:" + paramInt1 + ", index:" + paramInt2 + "]");
  }
  
  public void addElementById(int paramInt1, int paramInt2, int paramInt3)
  {
    IElement localIElement1 = (IElement)this.mElements.get(Integer.valueOf(paramInt2));
    if (localIElement1 != null)
    {
      IElement localIElement2 = localIElement1.getParent();
      if ((localIElement2 != null) && (localIElement2.indexOf(localIElement1) != -1)) {
        localIElement2.removeChildAt(localIElement2.indexOf(localIElement1));
      }
      localIElement2 = (IElement)this.mElements.get(Integer.valueOf(paramInt1));
      paramInt2 = paramInt3;
      if ((localIElement2 != null) && ((localIElement2 instanceof PDivElement)))
      {
        int i = paramInt2;
        if (paramInt2 == -1) {
          i = localIElement2.getChildCount();
        }
        localIElement1.setIndex(paramInt3);
        localIElement2.addChildAt(localIElement1, i);
        if (isElementInTree(paramInt1)) {
          addNodeInTree(localIElement1);
        }
        if (this.removeList.contains(Integer.valueOf(localIElement1.getElementId())))
        {
          localIElement1.setState(2);
          this.removeList.remove(Integer.valueOf(localIElement1.getElementId()));
          return;
        }
        localIElement1.setState(1);
        return;
      }
      PLog.e("Dom", "addElementById error [targetParent != null && targetParent instanceof PDivElement]");
      return;
    }
    PLog.e("Dom", "addElementById error. [parentRefId:" + paramInt1 + ", refId:" + paramInt2 + ", index:" + paramInt3 + "]");
  }
  
  public void addEvent(int paramInt, String paramString)
  {
    IElement localIElement = (IElement)this.mElements.get(Integer.valueOf(paramInt));
    if (localIElement != null)
    {
      localIElement.addEvent(paramString);
      return;
    }
    PLog.e("Dom", "addEvent error. refId:" + paramInt + " point to null");
  }
  
  public void addKeyFrame(IReadableMap paramIReadableMap)
  {
    PLog.i("Dom", "addKeyFrame map:" + paramIReadableMap.toString());
    if (this.mKeyFrames == null) {
      this.mKeyFrames = new HashMap();
    }
    paramIReadableMap = new PKeyFrame(paramIReadableMap);
    this.mKeyFrames.put(paramIReadableMap.getName(), paramIReadableMap);
  }
  
  public void addKeyFrame(String paramString)
  {
    if (this.mKeyFrames == null) {
      this.mKeyFrames = new HashMap();
    }
    paramString = new PKeyFrame(paramString);
    this.mKeyFrames.put(paramString.getName(), paramString);
  }
  
  public void bindSurface(IPlatoSurface paramIPlatoSurface)
  {
    if (!this.mRender.isSurfaceAttach()) {}
    for (boolean bool = true;; bool = false)
    {
      AssertUtil.Assert(bool, "already attach!");
      paramIPlatoSurface.attachRender(this);
      this.mRender.bindSurface(paramIPlatoSurface);
      return;
    }
  }
  
  protected void checkModify(ArrayList<RenderData> paramArrayList, IElement paramIElement1, int paramInt1, IElement paramIElement2, int paramInt2)
  {
    Object localObject1;
    Object localObject2;
    int j;
    int i;
    if ((paramIElement1.getState() & 0x1) != 0) {
      if (!this.removeList.contains(Integer.valueOf(paramIElement1.getElementId())))
      {
        localObject1 = paramIElement1.retrieveData(false);
        if (paramIElement1.isNotCalculate())
        {
          localObject2 = RenderData.RenderOperation.OP_CREATE_TOP_VIEW;
          j = paramIElement1.getElementId();
          if (paramIElement2 == null)
          {
            i = -1;
            paramArrayList.add(new RenderData((RenderData.RenderOperation)localObject2, localObject1, j, paramInt1, i, paramInt2));
            this.mOldTreePos.put(Integer.valueOf(((ElementItem)localObject1).getElementId()), new PRect(((ElementItem)localObject1).getElementId(), paramInt1, (int)((ElementItem)localObject1).getLayoutX(), (int)((ElementItem)localObject1).getLayoutY(), (int)((ElementItem)localObject1).getLayoutWidth(), (int)((ElementItem)localObject1).getLayoutHeight()));
            label147:
            j = paramIElement1.getChildCount();
            i = 0;
            paramInt2 = 0;
            label161:
            if (paramInt2 >= j) {
              break label788;
            }
            if ((!paramIElement1.isDisplayNone()) || (paramIElement1.isNotCalculate())) {
              break label667;
            }
          }
        }
      }
    }
    for (;;)
    {
      paramInt2 += 1;
      break label161;
      i = paramIElement2.getElementId();
      break;
      localObject2 = RenderData.RenderOperation.OP_CREATE_VIEW;
      j = paramIElement1.getElementId();
      if (paramIElement2 == null) {}
      for (i = -1;; i = paramIElement2.getElementId())
      {
        paramArrayList.add(new RenderData((RenderData.RenderOperation)localObject2, localObject1, j, paramInt1, i, paramInt2));
        break;
      }
      AssertUtil.Assert(false);
      break label147;
      if ((paramIElement1.getState() & 0x2) != 0)
      {
        if (!this.removeList.contains(Integer.valueOf(paramIElement1.getElementId())))
        {
          localObject1 = paramIElement1.retrieveData(false);
          if (!paramIElement1.isNotCalculate())
          {
            localObject2 = RenderData.RenderOperation.OP_MOVE_VIEW;
            j = paramIElement1.getElementId();
            if (paramIElement2 == null) {}
            for (i = -1;; i = paramIElement2.getElementId())
            {
              paramArrayList.add(new RenderData((RenderData.RenderOperation)localObject2, localObject1, j, paramInt1, i, paramInt2));
              this.mOldTreePos.put(Integer.valueOf(((ElementItem)localObject1).getElementId()), new PRect(((ElementItem)localObject1).getElementId(), paramInt1, (int)((ElementItem)localObject1).getLayoutX(), (int)((ElementItem)localObject1).getLayoutY(), (int)((ElementItem)localObject1).getLayoutWidth(), (int)((ElementItem)localObject1).getLayoutHeight()));
              break;
            }
          }
          PLog.e("Dom", "!!!!! not support move");
          break label147;
        }
        AssertUtil.Assert(false);
        break label147;
      }
      if ((paramIElement1.getState() & 0x4) != 0)
      {
        localObject1 = RenderData.RenderOperation.OP_SET_STYLE;
        localObject2 = paramIElement1.getUIStyles();
        j = paramIElement1.getElementId();
        if (paramIElement2 == null)
        {
          i = -1;
          label494:
          paramArrayList.add(new RenderData((RenderData.RenderOperation)localObject1, localObject2, j, paramInt1, i, paramInt2));
        }
      }
      else if ((paramIElement1.getState() & 0x8) != 0)
      {
        localObject1 = RenderData.RenderOperation.OP_SET_EVENT;
        localObject2 = paramIElement1.getEvents();
        j = paramIElement1.getElementId();
        if (paramIElement2 != null) {
          break label655;
        }
      }
      label655:
      for (i = -1;; i = paramIElement2.getElementId())
      {
        paramArrayList.add(new RenderData((RenderData.RenderOperation)localObject1, localObject2, j, paramInt1, i, paramInt2));
        paramIElement1.generateTransitionAnimations();
        if ((paramIElement1.getState() & 0x10) == 0) {
          break;
        }
        paramArrayList.add(new RenderData(RenderData.RenderOperation.OP_ANIMATION, paramIElement1.getOperateAnimations(), paramIElement1.getElementId(), paramInt1, paramIElement1.getParent().getElementId(), paramInt2));
        break;
        i = paramIElement2.getElementId();
        break label494;
      }
      label667:
      if (paramIElement1.isBlockType())
      {
        if (paramInt1 == -1) {}
        for (boolean bool = true;; bool = false)
        {
          AssertUtil.Assert(bool, " blockRef is not -1");
          checkModify(paramArrayList, paramIElement1.getChildAt(paramInt2), paramIElement1.getElementId(), paramIElement1, paramInt2);
          break;
        }
      }
      if (paramIElement1.getChildAt(paramInt2).isNotCalculate())
      {
        checkModify(paramArrayList, paramIElement1.getChildAt(paramInt2), paramInt1, paramIElement1, i);
        i += 1;
      }
      else
      {
        checkModify(paramArrayList, paramIElement1.getChildAt(paramInt2), paramInt1, paramIElement1, paramInt2 - i);
      }
    }
    label788:
    paramIElement1.setState(0);
  }
  
  public void createBody(IPlatoRuntime paramIPlatoRuntime, IReadableMap paramIReadableMap)
  {
    Tracker.trace("KeyTime", "====----------------------------- createBody start");
    this.mElementsInTree.clear();
    if (this.body == null)
    {
      this.body = createBodyImpl(paramIPlatoRuntime, paramIReadableMap, this.mElements, true);
      this.mElements.put(Integer.valueOf(0), this.body);
    }
    for (;;)
    {
      this.body.setState(1);
      if (this.mRenderListener != null) {
        this.mRenderListener.onCreateDomFinish();
      }
      Tracker.trace("KeyTime", "====----------------------------- createBody end");
      return;
      this.body = null;
      this.mElements.clear();
      this.mOldTreePos.clear();
      this.body = createBodyImpl(paramIPlatoRuntime, paramIReadableMap, this.mElements, true);
      this.mElements.put(Integer.valueOf(0), this.body);
    }
  }
  
  public IElement createBodyImpl(IPlatoRuntime paramIPlatoRuntime, IReadableMap paramIReadableMap, Map<Integer, IElement> paramMap, boolean paramBoolean)
  {
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.offer(new Pair(null, paramIReadableMap));
    Object localObject1 = null;
    label133:
    label205:
    label503:
    String str;
    for (;;)
    {
      if (!localLinkedList.isEmpty())
      {
        Object localObject3 = (Pair)localLinkedList.poll();
        paramIReadableMap = null;
        Object localObject2 = ((IReadableMap)((Pair)localObject3).second).getString("type", null);
        IElement.IProvider localIProvider = (IElement.IProvider)this.mElementProviders.get(localObject2);
        int i = ((IReadableMap)((Pair)localObject3).second).getInt("id", 0);
        if (localIProvider != null)
        {
          paramIReadableMap = localIProvider.createElement(this.mLayoutEngine, i);
          paramIReadableMap.setDom(this);
          if ((paramMap != null) && (paramIReadableMap != null) && (paramIReadableMap.getElementId() != -1))
          {
            paramMap.put(Integer.valueOf(paramIReadableMap.getElementId()), paramIReadableMap);
            if (paramBoolean) {
              this.mElementsInTree.add(Integer.valueOf(paramIReadableMap.getElementId()));
            }
          }
          if (paramIReadableMap == null) {
            continue;
          }
          if (((Pair)localObject3).first != null) {
            break label503;
          }
          localObject2 = paramIReadableMap;
          if (paramIReadableMap.isBlockType()) {
            this.mBlockList.add(Integer.valueOf(i));
          }
          if (paramIReadableMap.isNotCalculate()) {
            this.mNotCalculateList.add(Integer.valueOf(i));
          }
          if (!this.removeList.contains(Integer.valueOf(paramIReadableMap.getElementId()))) {
            break label537;
          }
          paramIReadableMap.setState(2);
          this.removeList.remove(Integer.valueOf(paramIReadableMap.getElementId()));
          localObject1 = ((IReadableMap)((Pair)localObject3).second).getReadableMap("attributes");
          if (localObject1 == null) {}
        }
        try
        {
          paramIReadableMap.getProperty().setProperty(paramIPlatoRuntime, (IReadableMap)localObject1);
          if (((IReadableMap)((Pair)localObject3).second).has("event")) {
            paramIReadableMap.addEventArray(((IReadableMap)((Pair)localObject3).second).getReadableArray("event"));
          }
          localObject1 = localObject2;
          if (((IReadableMap)((Pair)localObject3).second).has("children"))
          {
            localObject3 = ((IReadableMap)((Pair)localObject3).second).getReadableArray("children");
            if (localObject3 != null)
            {
              i = ((IReadableArray)localObject3).length();
              int j = 0;
              for (;;)
              {
                localObject1 = localObject2;
                if (j >= i) {
                  break;
                }
                localLinkedList.offer(new Pair(paramIReadableMap, ((IReadableArray)localObject3).getReadableMap(j)));
                j += 1;
              }
              PLog.e("Dom", "!!!!!! unsupport tag: " + (String)localObject2);
              break label133;
              ((IElement)((Pair)localObject3).first).addChildAt(paramIReadableMap, ((IElement)((Pair)localObject3).first).getChildCount());
              localObject2 = localObject1;
              break label205;
              label537:
              paramIReadableMap.setState(1);
            }
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            str = "createBodyImpl error. " + Log.getStackTraceString(localException);
            if (paramIPlatoRuntime != null) {
              paramIPlatoRuntime.onPlatoException(str);
            }
            PLog.e("Dom", str);
            continue;
            i = 0;
          }
        }
      }
    }
    return str;
  }
  
  public IElement createBodyImpl(IPlatoRuntime paramIPlatoRuntime, IReadableMap paramIReadableMap, boolean paramBoolean)
  {
    return createBodyImpl(paramIPlatoRuntime, paramIReadableMap, this.mElements, paramBoolean);
  }
  
  public void createElement(IPlatoRuntime paramIPlatoRuntime, IReadableMap paramIReadableMap)
  {
    paramIPlatoRuntime = createBodyImpl(paramIPlatoRuntime, paramIReadableMap, false);
    if (paramIReadableMap.has("id"))
    {
      int i = Integer.parseInt(paramIReadableMap.getString("id", null));
      this.mElements.put(Integer.valueOf(i), paramIPlatoRuntime);
      if ((i == 0) && (this.body == null)) {
        this.body = paramIPlatoRuntime;
      }
      return;
    }
    PLog.w("Dom", "createElement without element_id [" + paramIReadableMap + "]");
  }
  
  public void destroy()
  {
    this.mLayoutEngine.destroy();
  }
  
  public JSONObject dumpNodeInfo()
  {
    return this.body.dumpNode(null);
  }
  
  protected void dumpTree(IElement paramIElement, String paramString)
  {
    PLog.d("Dom", paramString + paramIElement.getElementId());
    int j = paramIElement.getChildCount();
    int i = 0;
    while (i < j)
    {
      dumpTree(paramIElement.getChildAt(i), paramString + "xxxx");
      i += 1;
    }
  }
  
  public Map<String, PKeyFrame> getKeyFrames()
  {
    return this.mKeyFrames;
  }
  
  public boolean isElementInTree(int paramInt)
  {
    return this.mElementsInTree.contains(Integer.valueOf(paramInt));
  }
  
  public void moveElement(int paramInt1, int paramInt2, int paramInt3)
  {
    IElement localIElement1 = (IElement)this.mElements.get(Integer.valueOf(paramInt1));
    if (localIElement1 != null)
    {
      IElement localIElement2 = localIElement1.getParent();
      if ((localIElement2 != null) && (localIElement2.indexOf(localIElement1) != -1)) {
        localIElement2.removeChildAt(localIElement2.indexOf(localIElement1));
      }
      localIElement2 = (IElement)this.mElements.get(Integer.valueOf(paramInt2));
      paramInt1 = paramInt3;
      if ((localIElement2 != null) && ((localIElement2 instanceof PDivElement)))
      {
        paramInt2 = paramInt1;
        if (paramInt1 == -1) {
          paramInt2 = localIElement2.getChildCount();
        }
        localIElement1.setIndex(paramInt3);
        localIElement2.addChildAt(localIElement1, paramInt2);
      }
      for (;;)
      {
        localIElement1.setState(2);
        return;
        PLog.e("Dom", "moveElement error [targetParent != null && targetParent instanceof PDivElement]");
      }
    }
    PLog.e("Dom", "moveElement error. targetRefId:" + paramInt1 + " point to null");
  }
  
  public void pause(int paramInt, String paramString)
  {
    IElement localIElement = (IElement)this.mElements.get(Integer.valueOf(paramInt));
    if (localIElement == null)
    {
      PLog.e("Dom", "pause keyframe error. refId:" + paramInt + " point to null");
      return;
    }
    if (this.mKeyFrames.get(paramString) == null)
    {
      PLog.e("Dom", "pause keyframe error. refId:" + paramInt + " no registered keyframe:" + paramString);
      return;
    }
    localIElement.pauseAnimation(paramString);
  }
  
  public void play(int paramInt, String paramString1, String paramString2)
  {
    IElement localIElement = (IElement)this.mElements.get(Integer.valueOf(paramInt));
    if (localIElement == null)
    {
      PLog.e("Dom", "play keyframe error. refId:" + paramInt + " point to null");
      return;
    }
    if (this.mKeyFrames.get(paramString1) == null)
    {
      PLog.e("Dom", "play keyframe error. refId:" + paramInt + " no registered keyframe:" + paramString1);
      return;
    }
    localIElement.playAnimation(paramString1, paramString2);
  }
  
  public void preUpdate(boolean paramBoolean)
  {
    if ((this.body == null) || (!this.mRender.wasSurfaceMeasure())) {
      return;
    }
    Tracker.trace("KeyTime", "====----------------------------- preUpdate start");
    if (!paramBoolean) {
      TimeMonitorUtils.getInstance().saveStepTime("layout_start", System.currentTimeMillis());
    }
    Object localObject1 = new ArrayList();
    int i = this.mRender.getSurface().getWidthMeasureSpec();
    int j = this.mRender.getSurface().getHeightMeasureSpec();
    this.mLayoutEngine.setWindow(750.0F, i, j);
    this.body.calculateLayout(i, j);
    Object localObject2 = this.mNotCalculateList.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (Integer)((Iterator)localObject2).next();
      i = (int)((IElement)this.mElements.get(localObject3)).getParent().getLayoutWidth();
      j = (int)((IElement)this.mElements.get(localObject3)).getParent().getLayoutHeight();
      ((IElement)this.mElements.get(localObject3)).calculateLayout(i, (0.0F / 0.0F));
    }
    if (!paramBoolean) {
      TimeMonitorUtils.getInstance().saveStepTime("layout_end", System.currentTimeMillis());
    }
    Tracker.trace("KeyTime", "====----------------------------- calculateLayout end");
    if (!paramBoolean) {
      TimeMonitorUtils.getInstance().saveStepTime("op_start", System.currentTimeMillis());
    }
    checkModify((ArrayList)localObject1, this.body, -1, null, 0);
    localObject2 = this.removeList.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (Integer)((Iterator)localObject2).next();
      if (!isElementInTree(((Integer)localObject3).intValue()))
      {
        PLog.d("Dom", "OP_REMOVE_VIEW " + localObject3);
        ((ArrayList)localObject1).add(new RenderData(RenderData.RenderOperation.OP_REMOVE_VIEW, null, ((Integer)localObject3).intValue(), -1, 0, 0));
      }
      else
      {
        PLog.d("Dom", " !!!!!!!!!!!!!! " + localObject3);
      }
    }
    this.removeList.clear();
    this.needUpdates.clear();
    diffVisit(this.body, -1);
    localObject2 = new ArrayList();
    Object localObject3 = this.needUpdates.iterator();
    while (((Iterator)localObject3).hasNext())
    {
      Integer localInteger = (Integer)((Iterator)localObject3).next();
      ((ArrayList)localObject2).add(new PRect((PRect)this.mOldTreePos.get(localInteger)));
    }
    if (((ArrayList)localObject2).size() > 0) {
      ((ArrayList)localObject1).add(new RenderData(RenderData.RenderOperation.OP_UPDATE_RECT, localObject2, 0, -1, 0, 0));
    }
    localObject2 = this.mBlockList.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (Integer)((Iterator)localObject2).next();
      ((ArrayList)localObject1).add(new RenderData(RenderData.RenderOperation.OP_UPDATE_BLOCK_FINISH, null, ((Integer)localObject3).intValue(), -1, 0, 0));
    }
    if (!paramBoolean) {
      TimeMonitorUtils.getInstance().saveStepTime("op_end", System.currentTimeMillis());
    }
    if (((ArrayList)localObject1).size() > 0)
    {
      localObject2 = this.mRenderHandler.obtainMessage();
      ((Message)localObject2).what = 1;
      ((Message)localObject2).obj = localObject1;
      localObject1 = new Bundle();
      ((Bundle)localObject1).putBoolean("fromMessage", paramBoolean);
      ((Bundle)localObject1).putString("tag", TimeMonitorUtils.getInstance().getMonitorName());
      ((Message)localObject2).setData((Bundle)localObject1);
      this.mRenderHandler.sendMessage((Message)localObject2);
      if (!paramBoolean) {
        TimeMonitorUtils.getInstance().saveStepTime("bridge_to_main_start", System.currentTimeMillis());
      }
    }
    Tracker.trace("KeyTime", "====----------------------------- preUpdate end");
  }
  
  public void printLayout(IElement paramIElement)
  {
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.offer(new Pair(paramIElement, Integer.valueOf(0)));
    while (!localLinkedList.isEmpty())
    {
      paramIElement = (Pair)localLinkedList.poll();
      PLog.d("Layout", ((Integer)paramIElement.second).intValue() + " " + ((IElement)paramIElement.first).getClass().getSimpleName() + ":[" + ((IElement)paramIElement.first).getLayoutX() + ", " + ((IElement)paramIElement.first).getLayoutY() + ", " + ((IElement)paramIElement.first).getLayoutWidth() + ", " + ((IElement)paramIElement.first).getLayoutHeight() + "]");
      if (((IElement)paramIElement.first).getChildCount() > 0)
      {
        int i = 0;
        while (i < ((IElement)paramIElement.first).getChildCount())
        {
          localLinkedList.offer(new Pair(((IElement)paramIElement.first).getChildAt(i), Integer.valueOf(((Integer)paramIElement.second).intValue() + 1)));
          i += 1;
        }
      }
    }
  }
  
  public void refreshSurface()
  {
    if (this.bridgeHandler != null) {
      this.bridgeHandler.sendEmptyMessage(1);
    }
  }
  
  public void removeAttr(int paramInt, String paramString)
  {
    IElement localIElement = (IElement)this.mElements.get(Integer.valueOf(paramInt));
    if (localIElement != null) {
      try
      {
        localIElement.removeAttr(paramString);
        localIElement.setState(4);
        return;
      }
      catch (Exception paramString)
      {
        PLog.e("Dom", "removeAttr error. " + Log.getStackTraceString(paramString));
        return;
      }
    }
    PLog.e("Dom", "removeAttr error. refId:" + paramInt + " point to null");
  }
  
  public void removeElement(int paramInt)
  {
    IElement localIElement1 = (IElement)this.mElements.get(Integer.valueOf(paramInt));
    if (localIElement1 != null)
    {
      IElement localIElement2 = localIElement1.getParent();
      if (localIElement2 != null)
      {
        paramInt = localIElement2.indexOf(localIElement1);
        if (paramInt != -1)
        {
          localIElement2.removeChildAt(paramInt);
          if (isElementInTree(localIElement1.getElementId())) {
            removeNodeFromTree(localIElement1);
          }
        }
        return;
      }
      PLog.e("Dom", "removeElement error. refId:" + paramInt + "its parent point to null");
      return;
    }
    PLog.e("Dom", "removeElement error. refId:" + paramInt + " point to null");
  }
  
  public void removeEvent(int paramInt, String paramString)
  {
    IElement localIElement = (IElement)this.mElements.get(Integer.valueOf(paramInt));
    if (localIElement != null)
    {
      localIElement.removeEvent(paramString);
      return;
    }
    PLog.e("Dom", "addEvent error. refId:" + paramInt + " point to null");
  }
  
  public void resume(int paramInt, String paramString)
  {
    IElement localIElement = (IElement)this.mElements.get(Integer.valueOf(paramInt));
    if (localIElement == null)
    {
      PLog.e("Dom", "resume keyframe error. refId:" + paramInt + " point to null");
      return;
    }
    if (this.mKeyFrames.get(paramString) == null)
    {
      PLog.e("Dom", "resume keyframe error. refId:" + paramInt + " no registered keyframe:" + paramString);
      return;
    }
    localIElement.resumeAnimation(paramString);
  }
  
  public void scrollTo(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    PLog.d("Dom", "dom -- scrollTo -- ref : " + paramInt1 + "; x : " + paramInt2 + "; y : " + paramInt3 + "; animated : " + paramBoolean);
    Message localMessage = Message.obtain();
    localMessage.what = 2;
    Bundle localBundle = new Bundle();
    localBundle.putInt("ref", paramInt1);
    localBundle.putInt("x", paramInt2);
    localBundle.putInt("y", paramInt3);
    localBundle.putBoolean("animated", paramBoolean);
    localMessage.setData(localBundle);
    this.mRenderHandler.sendMessage(localMessage);
  }
  
  public void setAttr(IPlatoRuntime paramIPlatoRuntime, int paramInt, IReadableMap paramIReadableMap)
  {
    IElement localIElement = (IElement)this.mElements.get(Integer.valueOf(paramInt));
    if (localIElement != null) {
      try
      {
        localIElement.getProperty().setProperty(paramIPlatoRuntime, paramIReadableMap);
        return;
      }
      catch (Exception paramIReadableMap)
      {
        paramIReadableMap = "setAttr error. " + Log.getStackTraceString(paramIReadableMap);
        if (paramIPlatoRuntime != null) {
          paramIPlatoRuntime.onPlatoException(paramIReadableMap);
        }
        PLog.e("Dom", paramIReadableMap);
        return;
      }
    }
    PLog.e("Dom", "setAttr error. refId:" + paramInt + " point to null");
  }
  
  public void setStyles(IPlatoRuntime paramIPlatoRuntime, int paramInt, IReadableMap paramIReadableMap)
  {
    IElement localIElement = (IElement)this.mElements.get(Integer.valueOf(paramInt));
    if (localIElement != null) {
      try
      {
        localIElement.getProperty().setStyle(paramIPlatoRuntime, paramIReadableMap);
        return;
      }
      catch (Exception paramIReadableMap)
      {
        paramIReadableMap = "setStyles error. " + Log.getStackTraceString(paramIReadableMap);
        if (paramIPlatoRuntime != null) {
          paramIPlatoRuntime.onPlatoException(paramIReadableMap);
        }
        PLog.e("Dom", paramIReadableMap);
        return;
      }
    }
    PLog.e("Dom", "setStyles error. refId:" + paramInt + " point to null");
  }
  
  public void stop(int paramInt, String paramString)
  {
    IElement localIElement = (IElement)this.mElements.get(Integer.valueOf(paramInt));
    if (localIElement == null)
    {
      PLog.e("Dom", "stop keyframe error. refId:" + paramInt + " point to null");
      return;
    }
    if (this.mKeyFrames.get(paramString) == null)
    {
      PLog.e("Dom", "stop keyframe error. refId:" + paramInt + " no registered keyframe:" + paramString);
      return;
    }
    localIElement.stopAnimation(paramString);
  }
  
  public void updateFinish()
  {
    if (this.bridgeHandler.getLooper() == Looper.myLooper())
    {
      preUpdate(false);
      return;
    }
    this.bridgeHandler.sendEmptyMessage(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.plato.sdk.dom.Dom
 * JD-Core Version:    0.7.0.1
 */