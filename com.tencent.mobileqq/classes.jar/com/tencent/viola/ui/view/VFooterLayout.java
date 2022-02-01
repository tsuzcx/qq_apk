package com.tencent.viola.ui.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.FrameLayout;
import com.tencent.viola.ui.component.VFooter;
import com.tencent.viola.ui.dom.DomObject;
import com.tencent.viola.ui.dom.style.FlexConvertUtils;
import com.tencent.viola.ui.view.refresh.listener.IFooterCallBack;
import java.lang.ref.WeakReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class VFooterLayout
  extends FrameLayout
  implements IVView<VFooter>, IFooterCallBack
{
  private VFooterLayout.OnFooterStateChangeListener listener;
  private JSONObject mFireEventJsonObject = new JSONObject();
  private boolean mIsRefreshStick = false;
  private boolean mShowing = true;
  private WeakReference<VFooter> mWeakReference;
  
  public VFooterLayout(@NonNull Context paramContext)
  {
    super(paramContext);
    paramContext = new JSONObject();
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(FlexConvertUtils.px2dip(getWidth()));
      localStringBuilder.append("dp");
      paramContext.put("width", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(FlexConvertUtils.px2dip(getHeight()));
      localStringBuilder.append("dp");
      paramContext.put("height", localStringBuilder.toString());
      this.mFireEventJsonObject.put("size", paramContext);
      return;
    }
    catch (JSONException paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public void bindComponent(VFooter paramVFooter)
  {
    this.mWeakReference = new WeakReference(paramVFooter);
  }
  
  public void destroy()
  {
    WeakReference localWeakReference = this.mWeakReference;
    if (localWeakReference != null)
    {
      localWeakReference.clear();
      this.mWeakReference = null;
    }
  }
  
  @Nullable
  public VFooter getComponent()
  {
    WeakReference localWeakReference = this.mWeakReference;
    if (localWeakReference != null) {
      return (VFooter)localWeakReference.get();
    }
    return null;
  }
  
  public int getFooterHeight()
  {
    return (int)getComponent().getDomObject().getLayoutHeight();
  }
  
  public boolean getRefreshStick()
  {
    return this.mIsRefreshStick;
  }
  
  public boolean isShowing()
  {
    return this.mShowing;
  }
  
  public void onFingerRelease()
  {
    VFooterLayout.OnFooterStateChangeListener localOnFooterStateChangeListener = this.listener;
    if (localOnFooterStateChangeListener != null) {
      localOnFooterStateChangeListener.onFooterFingerRelease();
    }
  }
  
  public void onFooterReachEnd()
  {
    VFooterLayout.OnFooterStateChangeListener localOnFooterStateChangeListener = this.listener;
    if (localOnFooterStateChangeListener != null) {
      localOnFooterStateChangeListener.onFooterReachEnd();
    }
  }
  
  public void onMove(int paramInt)
  {
    VFooterLayout.OnFooterStateChangeListener localOnFooterStateChangeListener = this.listener;
    if (localOnFooterStateChangeListener != null) {
      localOnFooterStateChangeListener.onFooterMove(paramInt);
    }
  }
  
  public void onReleaseToLoadMore()
  {
    JSONArray localJSONArray = new JSONArray();
    if (getComponent().getDomObject() != null)
    {
      String str = getComponent().getDomObject().getRef();
      if (str != null) {
        localJSONArray.put(str);
      }
    }
    localJSONArray.put("pulling");
    getComponent().footerFireEvent("pulling", localJSONArray, this.mFireEventJsonObject);
  }
  
  public void onStateFinish(boolean paramBoolean)
  {
    Object localObject = this.listener;
    if (localObject != null) {
      ((VFooterLayout.OnFooterStateChangeListener)localObject).onFooterFinish();
    }
    localObject = new JSONArray();
    if (getComponent().getDomObject() != null)
    {
      String str = getComponent().getDomObject().getRef();
      if (str != null) {
        ((JSONArray)localObject).put(str);
      }
    }
    ((JSONArray)localObject).put("idle");
    getComponent().footerFireEvent("idle", (JSONArray)localObject, this.mFireEventJsonObject);
  }
  
  public void onStateReady()
  {
    JSONArray localJSONArray = new JSONArray();
    if (getComponent().getDomObject() != null)
    {
      String str = getComponent().getDomObject().getRef();
      if (str != null) {
        localJSONArray.put(str);
      }
    }
    localJSONArray.put("idle");
    getComponent().footerFireEvent("idle", localJSONArray, this.mFireEventJsonObject);
  }
  
  public void onStateRefreshing()
  {
    JSONArray localJSONArray = new JSONArray();
    if (getComponent().getDomObject() != null)
    {
      String str = getComponent().getDomObject().getRef();
      if (str != null) {
        localJSONArray.put(str);
      }
    }
    localJSONArray.put("refresh");
    getComponent().footerFireEvent("refresh", localJSONArray, this.mFireEventJsonObject);
  }
  
  public void setListener(VFooterLayout.OnFooterStateChangeListener paramOnFooterStateChangeListener)
  {
    this.listener = paramOnFooterStateChangeListener;
  }
  
  public void setRefreshStick(boolean paramBoolean)
  {
    this.mIsRefreshStick = paramBoolean;
  }
  
  public void show(boolean paramBoolean)
  {
    if (paramBoolean == this.mShowing) {
      return;
    }
    this.mShowing = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.ui.view.VFooterLayout
 * JD-Core Version:    0.7.0.1
 */