package com.tencent.plato.sdk.render;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import com.tencent.plato.IPlatoManager.IRenderListener;
import com.tencent.plato.IPlatoRuntime;
import com.tencent.plato.IPlatoSurface;
import com.tencent.plato.core.IReadableMap;
import com.tencent.plato.core.utils.AssertUtil;
import com.tencent.plato.core.utils.PLog;
import com.tencent.plato.core.utils.TimeMonitorUtils;
import com.tencent.plato.core.utils.Tracker;
import com.tencent.plato.sdk.animation.PAnimation;
import com.tencent.plato.sdk.dom.EventCenter;
import com.tencent.plato.sdk.element.IElement.IProvider;
import com.tencent.plato.sdk.render.data.ElementItem;
import com.tencent.plato.sdk.utils.DeviceInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Render
  implements Handler.Callback
{
  public static final int MSG_SCROLLTO = 2;
  public static final int MSG_VIEW_UPDATES = 1;
  private static final String TAG = "Render";
  private IPView body;
  private final HashSet<Integer> mBlockList = new HashSet();
  private final EventCenter mEventCenter;
  private Handler mHandler = new Handler(Looper.getMainLooper(), this);
  private IPlatoSurface mPlatoSurface;
  private IPlatoManager.IRenderListener mRenderListener;
  private final IPlatoRuntime mRuntime;
  private final Map<Integer, IPView> mViews;
  private int pageId;
  
  public Render(IPlatoRuntime paramIPlatoRuntime, int paramInt, Map<String, IElement.IProvider> paramMap, IPlatoManager.IRenderListener paramIRenderListener)
  {
    this.mRuntime = paramIPlatoRuntime;
    this.pageId = paramInt;
    this.mRenderListener = paramIRenderListener;
    this.mEventCenter = ((EventCenter)this.mRuntime.getJSModule(EventCenter.class));
    this.mViews = new HashMap();
    PViewFactory.setProvider(paramMap);
  }
  
  private void doExecAnimation(final IPView paramIPView, List<PAnimation> paramList)
  {
    final View localView = paramIPView.getView();
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (PAnimation)paramList.next();
        ValueAnimator localValueAnimator = (ValueAnimator)((PAnimation)localObject).getAnimator();
        final String str = localValueAnimator.getValues()[0].getPropertyName();
        localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
        {
          public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
          {
            String str = str;
            int i = -1;
            switch (str.hashCode())
            {
            default: 
              switch (i)
              {
              }
              break;
            }
            do
            {
              return;
              if (!str.equals("left")) {
                break;
              }
              i = 0;
              break;
              if (!str.equals("top")) {
                break;
              }
              i = 1;
              break;
              if (!str.equals("width")) {
                break;
              }
              i = 2;
              break;
              if (!str.equals("height")) {
                break;
              }
              i = 3;
              break;
              if (!str.equals("opacity")) {
                break;
              }
              i = 4;
              break;
              if (!str.equals("rotateX")) {
                break;
              }
              i = 5;
              break;
              if (!str.equals("rotateY")) {
                break;
              }
              i = 6;
              break;
              if (!str.equals("rotateZ")) {
                break;
              }
              i = 7;
              break;
              if (!str.equals("rotate")) {
                break;
              }
              i = 8;
              break;
              if (!str.equals("scaleX")) {
                break;
              }
              i = 9;
              break;
              if (!str.equals("scaleY")) {
                break;
              }
              i = 10;
              break;
              if (!str.equals("scale")) {
                break;
              }
              i = 11;
              break;
              if (!str.equals("translateX")) {
                break;
              }
              i = 12;
              break;
              if (!str.equals("translateY")) {
                break;
              }
              i = 13;
              break;
              if (!str.equals("translateZ")) {
                break;
              }
              i = 14;
              break;
              if (!str.equals("backgroundColor")) {
                break;
              }
              i = 15;
              break;
              Render.this.setLayoutX(localView, ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue());
              return;
              Render.this.setLayoutY(localView, ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue());
              return;
              Render.this.setWidth(localView, ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
              return;
              Render.this.setHeight(localView, ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
              return;
              localView.setAlpha(((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue());
              return;
              localView.setRotationX(((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue());
              return;
              localView.setRotationY(((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue());
              return;
              localView.setRotation(((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue());
              return;
              localView.setScaleX(((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue());
              return;
              localView.setScaleY(((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue());
              return;
              localView.setScaleX(((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue());
              localView.setScaleY(((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue());
              return;
              localView.setTranslationX(((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue());
              return;
              localView.setTranslationY(((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue());
              return;
            } while (Build.VERSION.SDK_INT < 21);
            localView.setTranslationZ(((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue());
            return;
            localView.setBackgroundColor(((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
          }
        });
        localObject = ((PAnimation)localObject).getCallBack();
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          localValueAnimator.addListener(new Animator.AnimatorListener()
          {
            public void onAnimationCancel(Animator paramAnonymousAnimator) {}
            
            public void onAnimationEnd(Animator paramAnonymousAnimator)
            {
              if ((paramAnonymousAnimator instanceof ValueAnimator))
              {
                paramIPView.removeAnimator(str);
                Render.this.mEventCenter.fireEvent(paramIPView.getPageId(), paramIPView.getId(), this.val$callBack, null);
              }
            }
            
            public void onAnimationRepeat(Animator paramAnonymousAnimator) {}
            
            public void onAnimationStart(Animator paramAnonymousAnimator) {}
          });
        }
        paramIPView.addAnimator(str, localValueAnimator);
        localValueAnimator.start();
      }
    }
  }
  
  private void doPauseAnimation(IPView paramIPView, List<String> paramList)
  {
    if ((Build.VERSION.SDK_INT >= 19) && (paramList != null) && (paramList.size() > 0))
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (String)localIterator.next();
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = paramIPView.getAnimator((String)localObject);
          if ((localObject != null) && (paramList.size() > 0))
          {
            localObject = ((List)localObject).iterator();
            while (((Iterator)localObject).hasNext()) {
              ((Animator)((Iterator)localObject).next()).pause();
            }
          }
        }
      }
    }
  }
  
  private void doResumeAnimation(IPView paramIPView, List<String> paramList)
  {
    if ((Build.VERSION.SDK_INT >= 19) && (paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (String)paramList.next();
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = paramIPView.getAnimator((String)localObject);
          if ((localObject != null) && (((List)localObject).size() > 0))
          {
            localObject = ((List)localObject).iterator();
            while (((Iterator)localObject).hasNext()) {
              ((Animator)((Iterator)localObject).next()).resume();
            }
          }
        }
      }
    }
  }
  
  private void doStopAnimation(IPView paramIPView, List<String> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (String)paramList.next();
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = paramIPView.getAnimator((String)localObject);
          if ((localObject != null) && (((List)localObject).size() > 0))
          {
            localObject = ((List)localObject).iterator();
            while (((Iterator)localObject).hasNext()) {
              ((Animator)((Iterator)localObject).next()).end();
            }
          }
        }
      }
    }
  }
  
  private void removeChildRef(IPView paramIPView)
  {
    int j = paramIPView.getChildCount();
    int i = 0;
    while (i < j)
    {
      PLog.d("Render", " remove view: " + paramIPView.getChild(i).getId());
      this.mViews.remove(Integer.valueOf(paramIPView.getChild(i).getId()));
      removeChildRef(paramIPView.getChild(i));
      i += 1;
    }
  }
  
  private void scrollTo(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if (this.mViews.get(Integer.valueOf(paramInt1)) == null) {
      PLog.e("scrollTo error, ref:" + paramInt1 + " point to null");
    }
    View localView1;
    do
    {
      return;
      localView1 = ((IPView)this.mViews.get(Integer.valueOf(paramInt1))).getView();
    } while (localView1 == null);
    paramInt1 = Math.round(paramInt2 * DeviceInfo.perRemPx);
    int j = Math.round(paramInt3 * DeviceInfo.perRemPx);
    if ((localView1 instanceof PScrollView.PHScrollView))
    {
      if (paramBoolean)
      {
        ((PScrollView.PHScrollView)localView1).smoothScrollTo(paramInt1, j);
        return;
      }
      ((PScrollView.PHScrollView)localView1).scrollTo(paramInt1, j);
      return;
    }
    if ((localView1 instanceof PScrollView.PVScrollView))
    {
      if (paramBoolean)
      {
        ((ScrollView)((PScrollView.PVScrollView)localView1).getRefreshableView()).smoothScrollTo(paramInt1, j);
        return;
      }
      ((PScrollView.PVScrollView)localView1).scrollTo(paramInt1, j);
      return;
    }
    if ((localView1 instanceof PListView.PRealListView))
    {
      paramInt2 = 0;
      int i = 0;
      ListAdapter localListAdapter = ((ListView)((PListView.PRealListView)localView1).getRefreshableView()).getAdapter();
      paramInt1 = 0;
      int k = localListAdapter.getCount();
      for (;;)
      {
        paramInt3 = i;
        if (paramInt1 < k)
        {
          View localView2 = localListAdapter.getView(paramInt1, null, (ViewGroup)((PListView.PRealListView)localView1).getRefreshableView());
          localView2.measure(0, 0);
          paramInt2 += localView2.getMeasuredHeight();
          if (paramInt2 > j) {
            paramInt3 = paramInt1;
          }
        }
        else
        {
          ((ListView)((PListView.PRealListView)localView1).getRefreshableView()).setSelection(paramInt3 - 1);
          return;
        }
        paramInt1 += 1;
      }
    }
    localView1.scrollTo(paramInt1, j);
  }
  
  public void bindSurface(IPlatoSurface paramIPlatoSurface)
  {
    this.mPlatoSurface = paramIPlatoSurface;
  }
  
  protected void createTopView(ElementItem paramElementItem, int paramInt1, int paramInt2, int paramInt3)
  {
    IPView localIPView1 = (IPView)this.mViews.get(Integer.valueOf(paramInt2));
    IPView localIPView2 = PViewFactory.createView(this.mRuntime, localIPView1, paramElementItem);
    localIPView2.setPageId(this.pageId);
    if (paramElementItem.getEvents() != null) {
      localIPView2.attachEvent(paramElementItem.getEvents());
    }
    localIPView1.setTopView(localIPView2);
    this.mViews.put(Integer.valueOf(localIPView2.getId()), localIPView2);
  }
  
  protected void createView(ElementItem paramElementItem, int paramInt1, int paramInt2, int paramInt3)
  {
    IPView localIPView = (IPView)this.mViews.get(Integer.valueOf(paramInt2));
    localIPView = PViewFactory.createView(this.mRuntime, localIPView, paramElementItem);
    localIPView.setPageId(this.pageId);
    if (paramElementItem.getEvents() != null) {
      localIPView.attachEvent(paramElementItem.getEvents());
    }
    if ((paramElementItem.getTransfrom() != null) && (paramElementItem.getTransfrom().size() > 0)) {
      localIPView.attachTransform(paramElementItem.getTransfrom());
    }
    if (paramInt2 != -1) {
      if (this.mViews.get(Integer.valueOf(paramInt2)) != null) {
        ((IPView)this.mViews.get(Integer.valueOf(paramInt2))).addChild(localIPView, paramInt3);
      }
    }
    for (;;)
    {
      this.mViews.put(Integer.valueOf(localIPView.getId()), localIPView);
      return;
      PLog.d("Render", "parent is null : " + paramInt2);
      continue;
      this.body = localIPView;
      if (this.body != null)
      {
        this.mPlatoSurface.removeAllViews();
        this.mViews.clear();
      }
      this.mPlatoSurface.addView(this.body.getView());
    }
  }
  
  protected void doAnimation(int paramInt, Map<Integer, Object> paramMap)
  {
    IPView localIPView = (IPView)this.mViews.get(Integer.valueOf(paramInt));
    localIPView.getView();
    if ((paramMap != null) && (paramMap.size() > 0))
    {
      List localList = (List)paramMap.get(Integer.valueOf(1));
      if ((localList != null) && (localList.size() > 0)) {
        doExecAnimation(localIPView, localList);
      }
      localList = (List)paramMap.get(Integer.valueOf(2));
      if ((localList != null) && (localList.size() > 0)) {
        doPauseAnimation(localIPView, localList);
      }
      localList = (List)paramMap.get(Integer.valueOf(3));
      if ((localList != null) && (localList.size() > 0)) {
        doResumeAnimation(localIPView, localList);
      }
      paramMap = (List)paramMap.get(Integer.valueOf(4));
      if ((paramMap != null) && (paramMap.size() > 0)) {
        doStopAnimation(localIPView, paramMap);
      }
    }
  }
  
  protected void dumpTree(IPView paramIPView, String paramString)
  {
    PLog.d("Render", paramString + paramIPView.getId());
    int j = paramIPView.getChildCount();
    int i = 0;
    while (i < j)
    {
      dumpTree(paramIPView.getChild(i), paramString + "---");
      i += 1;
    }
  }
  
  public Handler getHandler()
  {
    return this.mHandler;
  }
  
  public IPlatoSurface getSurface()
  {
    return this.mPlatoSurface;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 1: 
      Tracker.trace("KeyTime", "====----------------------------- MSG_VIEW_UPDATES start");
      boolean bool = paramMessage.getData().getBoolean("fromMessage");
      String str = paramMessage.getData().getString("tag");
      if (!bool)
      {
        TimeMonitorUtils.getInstance().saveStepTime(str, "bridge_to_main_end", System.currentTimeMillis());
        TimeMonitorUtils.getInstance().saveStepTime(str, "render_start", System.currentTimeMillis());
      }
      paramMessage = ((ArrayList)paramMessage.obj).iterator();
      while (paramMessage.hasNext())
      {
        Object localObject = (RenderData)paramMessage.next();
        IPView localIPView;
        if (((RenderData)localObject).operation == RenderData.RenderOperation.OP_CREATE_VIEW)
        {
          PLog.d("Render", "OP_CREATE_VIEW " + ((RenderData)localObject).ref);
          if (((RenderData)localObject).blockRef < 0)
          {
            createView((ElementItem)((RenderData)localObject).obj, ((RenderData)localObject).ref, ((RenderData)localObject).parentRef, ((RenderData)localObject).index);
          }
          else
          {
            this.mBlockList.add(Integer.valueOf(((RenderData)localObject).blockRef));
            localIPView = (IPView)this.mViews.get(Integer.valueOf(((RenderData)localObject).blockRef));
            if ((localIPView instanceof PBlockView)) {
              ((PBlockView)localIPView).createBlockView((ElementItem)((RenderData)localObject).obj, ((RenderData)localObject).ref, ((RenderData)localObject).parentRef, ((RenderData)localObject).index);
            }
          }
        }
        else if (((RenderData)localObject).operation == RenderData.RenderOperation.OP_REMOVE_VIEW)
        {
          PLog.d("Render", "OP_REMOVE_VIEW " + ((RenderData)localObject).ref);
          removeView(((RenderData)localObject).ref);
        }
        else if (((RenderData)localObject).operation == RenderData.RenderOperation.OP_MOVE_VIEW)
        {
          PLog.d("Render", "OP_MOVE_VIEW " + ((RenderData)localObject).ref);
          if (((RenderData)localObject).blockRef < 0)
          {
            if (this.mViews.get(Integer.valueOf(((RenderData)localObject).ref)) != null) {
              moveView((ElementItem)((RenderData)localObject).obj, ((RenderData)localObject).ref, ((RenderData)localObject).parentRef, ((RenderData)localObject).index);
            } else {
              createView((ElementItem)((RenderData)localObject).obj, ((RenderData)localObject).ref, ((RenderData)localObject).parentRef, ((RenderData)localObject).index);
            }
          }
          else
          {
            localIPView = (IPView)this.mViews.get(Integer.valueOf(((RenderData)localObject).blockRef));
            if ((localIPView instanceof PBlockView)) {
              ((PBlockView)localIPView).moveBlockView(((RenderData)localObject).ref, ((RenderData)localObject).parentRef, ((RenderData)localObject).index, (ElementItem)((RenderData)localObject).obj);
            }
          }
        }
        else if (((RenderData)localObject).operation == RenderData.RenderOperation.OP_CREATE_TOP_VIEW)
        {
          PLog.d("Render", "OP_CREATE_TOP_VIEW " + ((RenderData)localObject).ref);
          if (((RenderData)localObject).blockRef < 0)
          {
            createTopView((ElementItem)((RenderData)localObject).obj, ((RenderData)localObject).ref, ((RenderData)localObject).parentRef, ((RenderData)localObject).index);
          }
          else
          {
            this.mBlockList.add(Integer.valueOf(((RenderData)localObject).blockRef));
            localIPView = (IPView)this.mViews.get(Integer.valueOf(((RenderData)localObject).blockRef));
            if ((localIPView instanceof PBlockView)) {
              ((PBlockView)localIPView).createBlockView((ElementItem)((RenderData)localObject).obj, ((RenderData)localObject).ref, ((RenderData)localObject).parentRef, ((RenderData)localObject).index);
            }
          }
        }
        else if (((RenderData)localObject).operation == RenderData.RenderOperation.OP_SET_STYLE)
        {
          if (((RenderData)localObject).blockRef < 0)
          {
            setStyle(((RenderData)localObject).ref, (IReadableMap)((RenderData)localObject).obj);
          }
          else
          {
            localIPView = (IPView)this.mViews.get(Integer.valueOf(((RenderData)localObject).blockRef));
            if ((localIPView instanceof PBlockView)) {
              ((PBlockView)localIPView).updateBlockStyles(((RenderData)localObject).ref, ((RenderData)localObject).obj);
            }
          }
        }
        else if (((RenderData)localObject).operation == RenderData.RenderOperation.OP_SET_EVENT)
        {
          if (((RenderData)localObject).blockRef < 0)
          {
            setEvents(((RenderData)localObject).ref, (List)((RenderData)localObject).obj);
          }
          else
          {
            localIPView = (IPView)this.mViews.get(Integer.valueOf(((RenderData)localObject).blockRef));
            if ((localIPView instanceof PBlockView)) {
              ((PBlockView)localIPView).addBlockEvent(((RenderData)localObject).ref, (List)((RenderData)localObject).obj);
            }
          }
        }
        else if (((RenderData)localObject).operation == RenderData.RenderOperation.OP_ANIMATION)
        {
          if (((RenderData)localObject).blockRef < 0) {
            doAnimation(((RenderData)localObject).ref, (Map)((RenderData)localObject).obj);
          }
        }
        else if (((RenderData)localObject).operation == RenderData.RenderOperation.OP_UPDATE_RECT)
        {
          updateRects((ArrayList)((RenderData)localObject).obj);
        }
        else if (((RenderData)localObject).operation == RenderData.RenderOperation.OP_UPDATE_BLOCK_FINISH)
        {
          localObject = (IPView)this.mViews.get(Integer.valueOf(((RenderData)localObject).ref));
          if ((localObject instanceof PBlockView)) {
            ((PBlockView)localObject).createBlockFinish();
          }
        }
      }
      if (!bool)
      {
        TimeMonitorUtils.getInstance().saveStepTime(str, "render_end", System.currentTimeMillis());
        if (this.mRenderListener != null) {
          this.mRenderListener.onRenderFinished(str);
        }
        TimeMonitorUtils.getInstance().printMonitorTime(str);
      }
      Tracker.trace("KeyTime", "====----------------------------- MSG_VIEW_UPDATES end");
    }
    for (;;)
    {
      return true;
      paramMessage = paramMessage.getData();
      scrollTo(paramMessage.getInt("ref"), paramMessage.getInt("x"), paramMessage.getInt("y"), paramMessage.getBoolean("animated", false));
    }
  }
  
  public boolean isSurfaceAttach()
  {
    return this.mPlatoSurface != null;
  }
  
  protected void moveView(ElementItem paramElementItem, int paramInt1, int paramInt2, int paramInt3)
  {
    PLog.i("Render", "moveView " + paramInt1 + "; index : " + paramInt3);
    IPView localIPView1 = (IPView)this.mViews.get(Integer.valueOf(paramInt1));
    if (localIPView1 != null) {}
    IPView localIPView2;
    for (boolean bool = true;; bool = false)
    {
      AssertUtil.Assert(bool);
      localIPView2 = localIPView1.getParent();
      if ((localIPView2 == null) || (localIPView2.getId() != paramInt2)) {
        break;
      }
      PLog.i("Render", "moveView [curParent != null && curParent.getId() == parentId ]  -- parentId : " + paramInt2);
      PLog.i("Render", "moveView  -- ref : " + paramInt1 + "; getLayoutX : " + paramElementItem.getLayoutX() + "; getLayoutY : " + paramElementItem.getLayoutY());
      localIPView1.updateRect((int)paramElementItem.getLayoutX(), (int)paramElementItem.getLayoutY(), (int)paramElementItem.getLayoutWidth(), (int)paramElementItem.getLayoutHeight());
      localIPView1.setStyles(paramElementItem.getUIStyles());
      localIPView1.attachEvent(paramElementItem.getEvents());
      return;
    }
    PLog.i("Render", "moveView  -- ref : " + paramInt1 + "; parentId : " + paramInt2);
    if (localIPView2 != null) {
      localIPView2.removeChild(localIPView1);
    }
    ((IPView)this.mViews.get(Integer.valueOf(paramInt2))).addChild(localIPView1, paramInt3);
    PLog.i("Render", "moveView  -- ref : " + paramInt1 + "; getLayoutX : " + paramElementItem.getLayoutX() + "; getLayoutY : " + paramElementItem.getLayoutY());
    localIPView1.updateRect((int)paramElementItem.getLayoutX(), (int)paramElementItem.getLayoutY(), (int)paramElementItem.getLayoutWidth(), (int)paramElementItem.getLayoutHeight());
  }
  
  protected void removeView(int paramInt)
  {
    PLog.i("Render", "removeView " + paramInt);
    Object localObject = (IPView)this.mViews.get(Integer.valueOf(paramInt));
    if (localObject == null)
    {
      localObject = this.mBlockList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        int i = ((Integer)((Iterator)localObject).next()).intValue();
        IPView localIPView = (IPView)this.mViews.get(Integer.valueOf(i));
        if (((localIPView instanceof PBlockView)) && (((PBlockView)localIPView).isBlockViewContainID(paramInt))) {
          ((PBlockView)localIPView).removeBlockView(paramInt);
        }
      }
    }
    if (((IPView)localObject).getParent() != null)
    {
      ((IPView)localObject).getParent().removeChild((IPView)localObject);
      this.mViews.remove(Integer.valueOf(paramInt));
      PLog.d("Render", " remove view: " + paramInt);
      return;
    }
    this.mPlatoSurface.removeView(((IPView)localObject).getView());
  }
  
  protected void setEvents(int paramInt, List<String> paramList)
  {
    ((IPView)this.mViews.get(Integer.valueOf(paramInt))).attachEvent(paramList);
  }
  
  public void setHeight(View paramView, int paramInt)
  {
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)paramView.getLayoutParams();
    localLayoutParams.height = paramInt;
    paramView.setLayoutParams(localLayoutParams);
  }
  
  public void setLayoutX(View paramView, float paramFloat)
  {
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)paramView.getLayoutParams();
    localLayoutParams.leftMargin = ((int)paramFloat);
    paramView.setLayoutParams(localLayoutParams);
  }
  
  public void setLayoutY(View paramView, float paramFloat)
  {
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)paramView.getLayoutParams();
    localLayoutParams.topMargin = ((int)paramFloat);
    paramView.setLayoutParams(localLayoutParams);
  }
  
  protected void setStyle(int paramInt, IReadableMap paramIReadableMap)
  {
    ((IPView)this.mViews.get(Integer.valueOf(paramInt))).setStyles(paramIReadableMap);
  }
  
  public void setWidth(View paramView, int paramInt)
  {
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)paramView.getLayoutParams();
    localLayoutParams.width = paramInt;
    paramView.setLayoutParams(localLayoutParams);
  }
  
  protected void updateRects(ArrayList<PRect> paramArrayList)
  {
    PLog.i("Render", "updateRects ");
    paramArrayList = paramArrayList.iterator();
    for (;;)
    {
      PRect localPRect;
      if (paramArrayList.hasNext())
      {
        localPRect = (PRect)paramArrayList.next();
        if (localPRect.blockRef >= 0) {
          break label119;
        }
        localIPView = (IPView)this.mViews.get(Integer.valueOf(localPRect.id));
        if (localIPView == null) {
          PLog.i("Render", "updateRects error [v == null] -- id : " + localPRect.id);
        }
      }
      else
      {
        return;
      }
      localIPView.updateRect(localPRect.left, localPRect.top, localPRect.width, localPRect.height);
      continue;
      label119:
      IPView localIPView = (IPView)this.mViews.get(Integer.valueOf(localPRect.blockRef));
      if ((localIPView instanceof PBlockView)) {
        ((PBlockView)localIPView).updateRects(localPRect.id, localPRect);
      }
    }
  }
  
  public boolean wasSurfaceMeasure()
  {
    return (this.mPlatoSurface != null) && (this.mPlatoSurface.wasMeasure());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.plato.sdk.render.Render
 * JD-Core Version:    0.7.0.1
 */