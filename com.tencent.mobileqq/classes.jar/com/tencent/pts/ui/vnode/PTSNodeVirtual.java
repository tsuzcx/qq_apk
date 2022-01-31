package com.tencent.pts.ui.vnode;

import android.content.Context;
import android.os.Trace;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.pts.core.PTSAppInstance;
import com.tencent.pts.ui.PTSNodeAttribute;
import com.tencent.pts.ui.PTSNodeInfo;
import com.tencent.pts.ui.PTSNodeStyle;
import com.tencent.pts.ui.view.IView;
import com.tencent.pts.utils.PTSLog;
import com.tencent.pts.utils.PTSTimeCostUtil;
import com.tencent.pts.utils.PTSValueConvertUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public abstract class PTSNodeVirtual<T extends View>
{
  protected final String TAG = getClass().getSimpleName();
  private PTSAppInstance mAppInstance;
  private List<PTSNodeVirtual> mChildren;
  private PTSNodeInfo mNodeInfo;
  private PTSNodeVirtual mParent;
  private T mView;
  private String mViewID;
  
  public PTSNodeVirtual(PTSAppInstance paramPTSAppInstance)
  {
    this.mAppInstance = paramPTSAppInstance;
    this.mView = initView();
  }
  
  private void applyLayout()
  {
    ViewGroup.LayoutParams localLayoutParams = null;
    if (this.mView.getLayoutParams() != null) {
      localLayoutParams = this.mView.getLayoutParams();
    }
    Object localObject;
    if (localLayoutParams == null)
    {
      localObject = new FrameLayout.LayoutParams(getWidth(), getHeight());
      ((FrameLayout.LayoutParams)localObject).setMargins(getLeft(), getTop(), 0, 0);
    }
    for (;;)
    {
      getView().setLayoutParams((ViewGroup.LayoutParams)localObject);
      return;
      localLayoutParams.width = getWidth();
      localLayoutParams.height = getHeight();
      localObject = localLayoutParams;
      if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams))
      {
        ((ViewGroup.MarginLayoutParams)localLayoutParams).setMargins(getLeft(), getTop(), 0, 0);
        localObject = localLayoutParams;
      }
    }
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
  
  private void bindStyle(PTSNodeStyle paramPTSNodeStyle)
  {
    paramPTSNodeStyle = paramPTSNodeStyle.entrySet().iterator();
    while (paramPTSNodeStyle.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramPTSNodeStyle.next();
      setStyle((String)localEntry.getKey(), localEntry.getValue());
    }
  }
  
  private void bindTapEvent(Object paramObject)
  {
    PTSLog.i(this.TAG, "[bindTapEvent], statement = " + paramObject);
    getView().setOnClickListener(new PTSNodeVirtual.1(this, paramObject));
  }
  
  private int getHeight()
  {
    return this.mNodeInfo.getStyle().getHeight();
  }
  
  private int getLeft()
  {
    return this.mNodeInfo.getStyle().getLeft();
  }
  
  private int getTop()
  {
    return this.mNodeInfo.getStyle().getTop();
  }
  
  private int getWidth()
  {
    return this.mNodeInfo.getStyle().getWidth();
  }
  
  private void setAttributes(String paramString, Object paramObject)
  {
    if (!setAttribute(paramString, paramObject)) {
      setEventListener(paramString, paramObject);
    }
  }
  
  private void setParent(PTSNodeVirtual paramPTSNodeVirtual)
  {
    this.mParent = paramPTSNodeVirtual;
  }
  
  public void addChild(PTSNodeVirtual paramPTSNodeVirtual)
  {
    if ((isLeafNode()) || (!(this.mView instanceof ViewGroup))) {
      throw new IllegalStateException("can not add child for leaf node, or mView is not ViewGroup, nodeInfo = \n" + this.mNodeInfo.toString());
    }
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
  }
  
  protected void bindExtra(PTSNodeInfo paramPTSNodeInfo) {}
  
  public final void bindNodeInfo(PTSNodeInfo paramPTSNodeInfo)
  {
    if (paramPTSNodeInfo != null)
    {
      Trace.beginSection("[bindNodeInfo]-" + paramPTSNodeInfo.getNodeType());
      PTSTimeCostUtil.start("[bindNodeInfo]-" + paramPTSNodeInfo.getUniqueID());
      reset();
      this.mNodeInfo = paramPTSNodeInfo;
      bindStyle(paramPTSNodeInfo.getStyle());
      bindAttributes(paramPTSNodeInfo.getAttributes());
      bindExtra(paramPTSNodeInfo);
      applyLayout();
      if ((getView() instanceof IView)) {
        ((IView)getView()).onBindNodeInfo(paramPTSNodeInfo);
      }
      PTSTimeCostUtil.end("[bindNodeInfo]-" + paramPTSNodeInfo.getUniqueID());
      Trace.endSection();
    }
  }
  
  public PTSAppInstance getAppInstance()
  {
    return this.mAppInstance;
  }
  
  public List<PTSNodeVirtual> getChildren()
  {
    if (this.mChildren == null) {
      return new ArrayList();
    }
    return new ArrayList(this.mChildren);
  }
  
  public Context getContext()
  {
    return this.mAppInstance.getActivity();
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
  
  public void hideNode()
  {
    this.mView.setVisibility(8);
  }
  
  public abstract T initView();
  
  public boolean isContainer()
  {
    return this instanceof PTSNodeContainer;
  }
  
  public boolean isLeafNode()
  {
    return !isContainer();
  }
  
  public boolean isVisible()
  {
    return getVisibility() == 0;
  }
  
  public void removeChild(PTSNodeVirtual paramPTSNodeVirtual)
  {
    if ((isLeafNode()) || (!(this.mView instanceof ViewGroup))) {
      throw new IllegalStateException("can not remove child for leaf node, or mView is not ViewGroup.");
    }
    if ((this.mChildren == null) || (paramPTSNodeVirtual == null)) {
      return;
    }
    this.mChildren.remove(paramPTSNodeVirtual);
    paramPTSNodeVirtual.setParent(null);
    ((ViewGroup)this.mView).removeView(paramPTSNodeVirtual.getView());
  }
  
  public final void reset()
  {
    View localView = getView();
    localView.setBackgroundColor(0);
    if (!isContainer()) {
      localView.setPadding(0, 0, 0, 0);
    }
    setViewID("");
    if (localView.hasOnClickListeners()) {
      localView.setOnClickListener(null);
    }
    resetAll();
  }
  
  public abstract void resetAll();
  
  protected boolean setAttribute(String paramString, Object paramObject)
  {
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        return false;
        if (paramString.equals("viewID")) {
          i = 0;
        }
        break;
      }
    }
    this.mViewID = PTSValueConvertUtil.getString(paramObject);
    return true;
  }
  
  protected boolean setEventListener(String paramString, Object paramObject)
  {
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        return false;
        if (paramString.equals("bindtap")) {
          i = 0;
        }
        break;
      }
    }
    bindTapEvent(paramObject);
    return true;
  }
  
  public void setPTSAppInstance(PTSAppInstance paramPTSAppInstance)
  {
    if (paramPTSAppInstance != null) {
      this.mAppInstance = paramPTSAppInstance;
    }
  }
  
  protected boolean setStyle(String paramString, Object paramObject)
  {
    View localView = getView();
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        return false;
        if (paramString.equals("background-color"))
        {
          i = 0;
          continue;
          if (paramString.equals("padding")) {
            i = 1;
          }
        }
        break;
      }
    }
    localView.setBackgroundColor(PTSValueConvertUtil.getColor(paramObject));
    return true;
    if (isContainer()) {
      return false;
    }
    paramString = this.mNodeInfo.getStyle().getPadding();
    localView.setPadding(paramString[0], paramString[1], paramString[2], paramString[3]);
    return true;
  }
  
  public void setViewID(String paramString)
  {
    this.mViewID = paramString;
  }
  
  public void showNode()
  {
    this.mView.setVisibility(0);
  }
  
  public void update() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.pts.ui.vnode.PTSNodeVirtual
 * JD-Core Version:    0.7.0.1
 */