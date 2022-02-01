package com.tencent.pts.ui.vnode;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.pts.bridge.PTSJSBridge;
import com.tencent.pts.core.PTSAppInstance;
import com.tencent.pts.core.PTSAppInstance.PTSLiteAppInstance;
import com.tencent.pts.core.lite.PTSLiteItemViewManager;
import com.tencent.pts.ui.PTSNodeAttribute;
import com.tencent.pts.ui.PTSNodeFactory;
import com.tencent.pts.ui.PTSNodeInfo;
import com.tencent.pts.ui.PTSNodeStyle;
import com.tencent.pts.ui.view.IView;
import com.tencent.pts.utils.PTSLog;
import com.tencent.pts.utils.PTSNodeVirtualUtil;
import com.tencent.pts.utils.PTSReportUtil;
import com.tencent.pts.utils.PTSTimeCostUtil;
import com.tencent.pts.utils.PTSValueConvertUtil;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public abstract class PTSNodeVirtual<T extends View>
{
  protected final String TAG = getClass().getSimpleName();
  private int backgroundColor = 16777215;
  private PTSAppInstance mAppInstance;
  protected List<PTSNodeVirtual> mChildren;
  private PTSNodeInfo mNodeInfo;
  private PTSNodeVirtual mParent;
  private T mView;
  private String mViewID;
  private ColorDrawable normalDrawable;
  private View.OnClickListener onClickListener;
  private int[] padding = new int[4];
  private ColorDrawable pressDrawable;
  private Integer ptsOnPressBackgroundColor;
  private Integer ptsOnPressColor;
  private String ptsOnPressSrc;
  private boolean reusable = true;
  private StateListDrawable stateListDrawable;
  
  protected PTSNodeVirtual(PTSAppInstance paramPTSAppInstance)
  {
    if (paramPTSAppInstance == null) {
      return;
    }
    this.mAppInstance = paramPTSAppInstance;
    View localView = initView(paramPTSAppInstance.getContext());
    paramPTSAppInstance = localView;
    if (localView == null) {
      paramPTSAppInstance = initView();
    }
    this.mView = paramPTSAppInstance;
  }
  
  private void bindAttributes(PTSNodeAttribute paramPTSNodeAttribute)
  {
    paramPTSNodeAttribute = paramPTSNodeAttribute.entrySet().iterator();
    while (paramPTSNodeAttribute.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramPTSNodeAttribute.next();
      setAttributes((String)localEntry.getKey(), localEntry.getValue());
    }
  }
  
  private void bindExposeEvent() {}
  
  private void bindExtra(PTSNodeInfo paramPTSNodeInfo)
  {
    if (paramPTSNodeInfo != null) {
      setContent(paramPTSNodeInfo.getContent());
    }
  }
  
  private void bindStyle(PTSNodeStyle paramPTSNodeStyle)
  {
    paramPTSNodeStyle = paramPTSNodeStyle.entrySet().iterator();
    while (paramPTSNodeStyle.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramPTSNodeStyle.next();
      setStyle((String)localEntry.getKey(), localEntry.getValue());
    }
  }
  
  private void bindTapEvent()
  {
    PTSLog.i(this.TAG, "[bindTapEvent]");
    if (this.onClickListener == null) {
      this.onClickListener = new PTSNodeVirtual.1(this);
    }
    getView().setOnClickListener(this.onClickListener);
  }
  
  private void handleTapEvent()
  {
    Object localObject6 = getNodeInfo();
    if (localObject6 == null)
    {
      PTSLog.i(this.TAG, "[handleTapEvent], nodeInfo is null.");
      return;
    }
    Object localObject1 = ((PTSNodeInfo)localObject6).getUniqueID();
    for (;;)
    {
      try
      {
        int j = Integer.parseInt((String)localObject1);
        Object localObject5 = ((PTSNodeInfo)localObject6).getAttributes().getAttributeID();
        localObject4 = ((PTSNodeInfo)localObject6).getEventInfo();
        if ((localObject4 == null) || (((HashMap)localObject4).size() <= 0)) {
          break label343;
        }
        int i = ((HashMap)localObject4).size();
        localObject1 = new String[i];
        localObject3 = new String[i];
        i = 0;
        Iterator localIterator = ((HashMap)localObject4).entrySet().iterator();
        if (!localIterator.hasNext()) {
          break label340;
        }
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        localObject1[i] = ((String)localEntry.getKey());
        localObject3[i] = ((String)localEntry.getValue());
        i += 1;
        continue;
        if (this.mAppInstance.isJsAppInstance())
        {
          localObject4 = ((PTSNodeInfo)localObject6).getAttributes().getEventBindTap();
          localObject6 = this.mAppInstance.getJsBridge();
          if (localObject6 != null) {
            ((PTSJSBridge)localObject6).callJSEventFunction((String)localObject4, j, "tap", (String)localObject5, (String[])localObject1, (String[])localObject3, null, null, this.mAppInstance);
          }
        }
        else if (this.mAppInstance.isLiteAppInstance())
        {
          localObject1 = ((PTSNodeInfo)localObject6).getAttributes().getEventPtsOnTap();
          localObject3 = ((PTSAppInstance.PTSLiteAppInstance)this.mAppInstance).getLiteEventListener();
          localObject5 = ((PTSAppInstance.PTSLiteAppInstance)this.mAppInstance).getLiteItemViewManager();
          if (localObject5 != null)
          {
            ((PTSLiteItemViewManager)localObject5).triggerLiteEvent(1, (String)localObject1, (HashMap)localObject4, getView());
            return;
          }
          if (localObject3 != null)
          {
            ((PTSAppInstance.PTSLiteAppInstance)this.mAppInstance).triggerLiteEvent(1, (String)localObject1, (HashMap)localObject4, getView(), this.mAppInstance.getPtsComposer());
            return;
          }
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        localObject3 = this.TAG;
        Object localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("[handleTapEvent], e = ");
        ((StringBuilder)localObject4).append(localNumberFormatException);
        PTSLog.e((String)localObject3, ((StringBuilder)localObject4).toString());
      }
      return;
      label340:
      continue;
      label343:
      Object localObject2 = null;
      Object localObject3 = localObject2;
    }
  }
  
  private T initView()
  {
    Object localObject1 = PTSNodeFactory.getNodeViewConstructor(getClass());
    Object localObject2;
    if (localObject1 == null)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[initView] no viewConstructor, className = ");
      ((StringBuilder)localObject2).append(getClass().getName());
      localObject2 = ((StringBuilder)localObject2).toString();
      PTSLog.e(this.TAG, (String)localObject2);
      if (PTSLog.isDebug()) {
        throw new IllegalArgumentException((String)localObject2);
      }
    }
    try
    {
      localObject1 = (View)((Constructor)localObject1).newInstance(new Object[] { this });
      return localObject1;
    }
    catch (Exception localException)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[initView] exception, className = ");
      ((StringBuilder)localObject2).append(getClass().getName());
      ((StringBuilder)localObject2).append(", e = ");
      ((StringBuilder)localObject2).append(localException);
      ((StringBuilder)localObject2).append(", stackTraceString = ");
      ((StringBuilder)localObject2).append(Log.getStackTraceString(localException));
      String str1 = ((StringBuilder)localObject2).toString();
      PTSLog.e(this.TAG, str1);
      PTSReportUtil.reportEvent(this.TAG, str1, 1);
      if (PTSLog.isDebug()) {
        throw new IllegalArgumentException(str1);
      }
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[initView] invocationTargetException, className = ");
      ((StringBuilder)localObject2).append(getClass().getName());
      ((StringBuilder)localObject2).append(", e = ");
      ((StringBuilder)localObject2).append(localInvocationTargetException);
      ((StringBuilder)localObject2).append(", stackTraceString = ");
      ((StringBuilder)localObject2).append(Log.getStackTraceString(localInvocationTargetException));
      String str2 = ((StringBuilder)localObject2).toString();
      PTSReportUtil.reportEvent(this.TAG, str2, 1);
      PTSLog.e(this.TAG, str2);
      if (!PTSLog.isDebug()) {
        return null;
      }
      throw new IllegalArgumentException(str2);
    }
  }
  
  private final void reset()
  {
    View localView = getView();
    this.backgroundColor = 16777215;
    if (!isContainer()) {
      this.padding = new int[] { 0, 0, 0, 0 };
    }
    setViewID("");
    if (localView.hasOnClickListeners()) {
      localView.setOnClickListener(null);
    }
    this.ptsOnPressSrc = null;
    this.ptsOnPressColor = null;
    this.ptsOnPressBackgroundColor = null;
    resetAll();
  }
  
  private void setAttributes(String paramString, Object paramObject)
  {
    if (!setAttribute(paramString, paramObject)) {
      setEventListener(paramString);
    }
  }
  
  private void setEventListener(String paramString)
  {
    if ((!"bindtap".equalsIgnoreCase(paramString)) && (!"pts:on-tap".equalsIgnoreCase(paramString)))
    {
      if ("pts:on-exposure".equalsIgnoreCase(paramString)) {
        bindExposeEvent();
      }
    }
    else {
      bindTapEvent();
    }
  }
  
  private void updatePtsOnPressBackgroundColor()
  {
    Integer localInteger = getPtsOnPressBackgroundColor();
    if (localInteger == null) {
      return;
    }
    if (this.stateListDrawable == null)
    {
      this.stateListDrawable = new StateListDrawable();
      this.normalDrawable = new ColorDrawable(getBackgroundColor());
      this.pressDrawable = new ColorDrawable(localInteger.intValue());
      StateListDrawable localStateListDrawable = this.stateListDrawable;
      ColorDrawable localColorDrawable = this.pressDrawable;
      localStateListDrawable.addState(new int[] { 16842919 }, localColorDrawable);
      localStateListDrawable = this.stateListDrawable;
      localColorDrawable = this.normalDrawable;
      localStateListDrawable.addState(new int[0], localColorDrawable);
    }
    this.normalDrawable.setColor(getBackgroundColor());
    this.pressDrawable.setColor(localInteger.intValue());
    getView().setBackgroundDrawable(this.stateListDrawable);
  }
  
  public void addChild(PTSNodeVirtual paramPTSNodeVirtual)
  {
    if ((!isLeafNode()) && ((this.mView instanceof ViewGroup)))
    {
      if (this.mChildren == null) {
        this.mChildren = new ArrayList();
      }
      if (paramPTSNodeVirtual == null)
      {
        PTSLog.e(this.TAG, "[addChild], the child is null.");
        return;
      }
      this.mChildren.add(paramPTSNodeVirtual);
      paramPTSNodeVirtual.setParent(this);
      ((ViewGroup)this.mView).addView(paramPTSNodeVirtual.getView());
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[addChild] failed, can not add child for leaf node, or mView is not ViewGroup, nodeInfo = \n");
    paramPTSNodeVirtual = this.mNodeInfo;
    if (paramPTSNodeVirtual != null) {
      paramPTSNodeVirtual = paramPTSNodeVirtual.toString();
    } else {
      paramPTSNodeVirtual = "";
    }
    localStringBuilder.append(paramPTSNodeVirtual);
    paramPTSNodeVirtual = localStringBuilder.toString();
    PTSLog.e(this.TAG, paramPTSNodeVirtual);
    if (!PTSLog.isDebug()) {
      return;
    }
    throw new IllegalArgumentException(paramPTSNodeVirtual);
  }
  
  public void applyLayout()
  {
    ViewGroup.LayoutParams localLayoutParams;
    if (this.mView.getLayoutParams() != null) {
      localLayoutParams = this.mView.getLayoutParams();
    } else {
      localLayoutParams = null;
    }
    Object localObject;
    if (localLayoutParams == null)
    {
      localObject = new ViewGroup.MarginLayoutParams(getWidth(), getHeight());
      ((ViewGroup.MarginLayoutParams)localObject).setMargins(getLeft(), getTop(), 0, 0);
    }
    else
    {
      localLayoutParams.width = getWidth();
      localLayoutParams.height = getHeight();
      localObject = localLayoutParams;
      if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams))
      {
        ((ViewGroup.MarginLayoutParams)localLayoutParams).setMargins(getLeft(), getTop(), 0, 0);
        localObject = localLayoutParams;
      }
    }
    getView().setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  public final void bindNodeInfo(PTSNodeInfo paramPTSNodeInfo)
  {
    if (paramPTSNodeInfo != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[bindNodeInfo]-");
      localStringBuilder.append(paramPTSNodeInfo.getUniqueID());
      PTSTimeCostUtil.start(localStringBuilder.toString());
      reset();
      this.mNodeInfo = paramPTSNodeInfo;
      bindStyle(paramPTSNodeInfo.getStyle());
      bindAttributes(paramPTSNodeInfo.getAttributes());
      bindExtra(paramPTSNodeInfo);
      if ((getView() instanceof IView)) {
        ((IView)getView()).onBindNodeInfo(paramPTSNodeInfo);
      }
      PTSNodeVirtualUtil.onBindNodeInfoFinished(paramPTSNodeInfo.getUniqueID(), getView(), paramPTSNodeInfo.getContent(), paramPTSNodeInfo.getStyle(), paramPTSNodeInfo.getAttributes());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[bindNodeInfo]-");
      localStringBuilder.append(paramPTSNodeInfo.getUniqueID());
      PTSTimeCostUtil.end(localStringBuilder.toString());
    }
  }
  
  public PTSAppInstance getAppInstance()
  {
    return this.mAppInstance;
  }
  
  public int getBackgroundColor()
  {
    return this.backgroundColor;
  }
  
  public List<PTSNodeVirtual> getChildren()
  {
    List localList = this.mChildren;
    if (localList == null) {
      return new ArrayList();
    }
    return new ArrayList(localList);
  }
  
  public Context getContext()
  {
    return this.mAppInstance.getContext();
  }
  
  public int getHeight()
  {
    return this.mNodeInfo.getStyle().getHeight();
  }
  
  public int getLeft()
  {
    return this.mNodeInfo.getStyle().getLeft();
  }
  
  public int getMeasuredHeight()
  {
    return this.mView.getMeasuredHeight();
  }
  
  public int getMeasuredWidth()
  {
    return this.mView.getMeasuredWidth();
  }
  
  public PTSNodeInfo getNodeInfo()
  {
    return this.mNodeInfo;
  }
  
  public PTSNodeVirtual getParent()
  {
    return this.mParent;
  }
  
  public Integer getPtsOnPressBackgroundColor()
  {
    return this.ptsOnPressBackgroundColor;
  }
  
  public Integer getPtsOnPressColor()
  {
    return this.ptsOnPressColor;
  }
  
  public String getPtsOnPressSrc()
  {
    return this.ptsOnPressSrc;
  }
  
  public boolean getReusable()
  {
    return this.reusable;
  }
  
  public int getTop()
  {
    return this.mNodeInfo.getStyle().getTop();
  }
  
  public T getView()
  {
    return this.mView;
  }
  
  public String getViewID()
  {
    if (TextUtils.isEmpty(this.mViewID)) {
      return "";
    }
    return this.mViewID;
  }
  
  public int getVisibility()
  {
    return this.mView.getVisibility();
  }
  
  public int getWidth()
  {
    return this.mNodeInfo.getStyle().getWidth();
  }
  
  public void hideNode()
  {
    this.mView.setVisibility(8);
  }
  
  protected T initView(Context paramContext)
  {
    return null;
  }
  
  public boolean isContainer()
  {
    return getView() instanceof ViewGroup;
  }
  
  public boolean isLeafNode()
  {
    return isContainer() ^ true;
  }
  
  public boolean isVisible()
  {
    return getVisibility() == 0;
  }
  
  public void onParseValueFinished()
  {
    View localView = getView();
    localView.setBackgroundColor(this.backgroundColor);
    int[] arrayOfInt = this.padding;
    localView.setPadding(arrayOfInt[0], arrayOfInt[1], arrayOfInt[2], arrayOfInt[3]);
    updatePtsOnPressBackgroundColor();
  }
  
  public void removeChild(PTSNodeVirtual paramPTSNodeVirtual)
  {
    if ((!isLeafNode()) && ((this.mView instanceof ViewGroup)))
    {
      localObject = this.mChildren;
      if (localObject != null)
      {
        if (paramPTSNodeVirtual == null) {
          return;
        }
        ((List)localObject).remove(paramPTSNodeVirtual);
        paramPTSNodeVirtual.setParent(null);
        ((ViewGroup)this.mView).removeView(paramPTSNodeVirtual.getView());
      }
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[remove] failed, can not remove child for leaf node, or mView is not ViewGroup, nodeInfo = \n");
    paramPTSNodeVirtual = this.mNodeInfo;
    if (paramPTSNodeVirtual != null) {
      paramPTSNodeVirtual = paramPTSNodeVirtual.toString();
    } else {
      paramPTSNodeVirtual = "";
    }
    ((StringBuilder)localObject).append(paramPTSNodeVirtual);
    paramPTSNodeVirtual = ((StringBuilder)localObject).toString();
    PTSLog.e(this.TAG, paramPTSNodeVirtual);
    if (!PTSLog.isDebug()) {
      return;
    }
    throw new IllegalArgumentException(paramPTSNodeVirtual);
  }
  
  protected void resetAll() {}
  
  protected boolean setAttribute(String paramString, Object paramObject)
  {
    if ("viewID".equalsIgnoreCase(paramString))
    {
      this.mViewID = PTSValueConvertUtil.getString(paramObject);
      return true;
    }
    if ("pts:on-pressed-color".equalsIgnoreCase(paramString))
    {
      this.ptsOnPressColor = Integer.valueOf(PTSValueConvertUtil.getColor(paramObject));
      return true;
    }
    if ("pts:on-pressed-background-color".equalsIgnoreCase(paramString))
    {
      this.ptsOnPressBackgroundColor = Integer.valueOf(PTSValueConvertUtil.getColor(paramObject));
      return true;
    }
    if ("pts:on-pressed-src".equalsIgnoreCase(paramString))
    {
      this.ptsOnPressSrc = PTSValueConvertUtil.getString(paramObject);
      return true;
    }
    return false;
  }
  
  protected boolean setContent(String paramString)
  {
    return false;
  }
  
  public void setPTSAppInstance(PTSAppInstance paramPTSAppInstance)
  {
    if (paramPTSAppInstance != null) {
      this.mAppInstance = paramPTSAppInstance;
    }
  }
  
  protected void setParent(PTSNodeVirtual paramPTSNodeVirtual)
  {
    this.mParent = paramPTSNodeVirtual;
  }
  
  public void setReusable(boolean paramBoolean)
  {
    this.reusable = paramBoolean;
  }
  
  protected boolean setStyle(String paramString, Object paramObject)
  {
    if ("background-color".equalsIgnoreCase(paramString))
    {
      this.backgroundColor = PTSValueConvertUtil.getColor(paramObject);
      return true;
    }
    if ("padding".equalsIgnoreCase(paramString))
    {
      if (isContainer()) {
        return false;
      }
      this.padding = this.mNodeInfo.getStyle().getPadding();
      return true;
    }
    return false;
  }
  
  public void setViewID(String paramString)
  {
    this.mViewID = paramString;
  }
  
  public void showNode()
  {
    this.mView.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pts.ui.vnode.PTSNodeVirtual
 * JD-Core Version:    0.7.0.1
 */