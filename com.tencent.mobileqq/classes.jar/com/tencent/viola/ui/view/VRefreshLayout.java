package com.tencent.viola.ui.view;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.FrameLayout;
import com.tencent.viola.ui.component.VRefresh;
import com.tencent.viola.ui.dom.DomObject;
import com.tencent.viola.ui.dom.style.FlexConvertUtils;
import com.tencent.viola.ui.view.refresh.RefreshMoveOberver;
import com.tencent.viola.ui.view.refresh.VRefreshViewGroup;
import com.tencent.viola.ui.view.refresh.listener.IHeaderCallBack;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class VRefreshLayout
  extends FrameLayout
  implements IVView<VRefresh>, IHeaderCallBack
{
  public static String TAG = "VRefreshLayout";
  private List<VRefreshLayout.OnHeaderStateChangeListener> headerStateChangeListeners;
  public int mComponentType = 1;
  private JSONObject mFireEventJsonObject = new JSONObject();
  private Handler mHandler;
  private boolean mIsRefreshStick = false;
  private VRefreshLayout.onRefreshStateChangeListener mOnRefreshStateChangeListener;
  private RefreshMoveOberver mRefreshMoveOberver;
  private Runnable mRunnable;
  private WeakReference<VRefresh> mWeakReference;
  
  public VRefreshLayout(@NonNull Context paramContext)
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
    }
    catch (JSONException paramContext)
    {
      paramContext.printStackTrace();
    }
    this.mHandler = new Handler(getContext().getMainLooper());
    this.mRunnable = new VRefreshLayout.1(this);
    this.mRefreshMoveOberver = new VRefreshLayout.2(this);
  }
  
  public void addOnHeaderStateChangeListener(VRefreshLayout.OnHeaderStateChangeListener paramOnHeaderStateChangeListener)
  {
    if (paramOnHeaderStateChangeListener == null) {
      return;
    }
    if (this.headerStateChangeListeners == null) {
      this.headerStateChangeListeners = new ArrayList();
    }
    if (this.headerStateChangeListeners.contains(paramOnHeaderStateChangeListener)) {
      return;
    }
    this.headerStateChangeListeners.add(paramOnHeaderStateChangeListener);
  }
  
  public void bindComponent(VRefresh paramVRefresh)
  {
    this.mWeakReference = new WeakReference(paramVRefresh);
  }
  
  public void destroy()
  {
    Object localObject = this.mWeakReference;
    if (localObject != null)
    {
      ((WeakReference)localObject).clear();
      this.mWeakReference = null;
    }
    localObject = this.mHandler;
    if (localObject != null) {
      ((Handler)localObject).removeCallbacks(this.mRunnable);
    }
    this.mOnRefreshStateChangeListener = null;
  }
  
  @Nullable
  public VRefresh getComponent()
  {
    WeakReference localWeakReference = this.mWeakReference;
    if (localWeakReference != null) {
      return (VRefresh)localWeakReference.get();
    }
    return null;
  }
  
  public int getComponentType()
  {
    return this.mComponentType;
  }
  
  public int getHeaderHeight()
  {
    if (getComponent() != null) {
      return (int)getComponent().getDomObject().getLayoutHeight();
    }
    return 0;
  }
  
  public int getHeaderWidth()
  {
    if (getComponent() != null) {
      return (int)getComponent().getDomObject().getLayoutWidth();
    }
    return 0;
  }
  
  public RefreshMoveOberver getRefreshMoveOberver()
  {
    return this.mRefreshMoveOberver;
  }
  
  public boolean getRefreshStick()
  {
    return this.mIsRefreshStick;
  }
  
  public void notifyShowUpdate(int paramInt)
  {
    if ((getParent() instanceof VRefreshViewGroup))
    {
      VRefreshViewGroup localVRefreshViewGroup = (VRefreshViewGroup)getParent();
      boolean bool = true;
      if (paramInt != 1) {
        bool = false;
      }
      localVRefreshViewGroup.updateRefreshShow(bool);
    }
  }
  
  public void notifyVisiableChangeOnScreen(boolean paramBoolean)
  {
    if (getComponentType() == 2)
    {
      JSONArray localJSONArray = new JSONArray();
      if ((getComponent() != null) && (getComponent().getDomObject() != null))
      {
        String str = getComponent().getDomObject().getRef();
        if (str != null) {
          localJSONArray.put(str);
        }
        str = "appear";
        if (paramBoolean) {
          localJSONArray.put("appear");
        } else {
          localJSONArray.put("disappear");
        }
        VRefresh localVRefresh = getComponent();
        if (!paramBoolean) {
          str = "disappear";
        }
        localVRefresh.refreshFireEvent(str, localJSONArray, this.mFireEventJsonObject);
      }
    }
  }
  
  public void onFingerRelease()
  {
    Object localObject = this.headerStateChangeListeners;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((VRefreshLayout.OnHeaderStateChangeListener)((Iterator)localObject).next()).onHeaderFingerRelease();
      }
    }
  }
  
  public void onStateFinish(boolean paramBoolean)
  {
    this.mHandler.postDelayed(this.mRunnable, 500L);
  }
  
  public void onStateNormal()
  {
    this.mHandler.removeCallbacks(this.mRunnable);
    Object localObject = this.mOnRefreshStateChangeListener;
    if (localObject != null) {
      ((VRefreshLayout.onRefreshStateChangeListener)localObject).onStateIdel();
    }
    localObject = new JSONArray();
    if ((getComponent() != null) && (getComponent().getDomObject() != null))
    {
      String str = getComponent().getDomObject().getRef();
      if (str != null) {
        ((JSONArray)localObject).put(str);
      }
      ((JSONArray)localObject).put("idle");
      getComponent().refreshFireEvent("idle", (JSONArray)localObject, this.mFireEventJsonObject);
    }
  }
  
  public void onStateReady()
  {
    Object localObject = this.mOnRefreshStateChangeListener;
    if (localObject != null) {
      ((VRefreshLayout.onRefreshStateChangeListener)localObject).onStatePulling();
    }
    localObject = new JSONArray();
    if ((getComponent() != null) && (getComponent().getDomObject() != null))
    {
      String str = getComponent().getDomObject().getRef();
      if (str != null) {
        ((JSONArray)localObject).put(str);
      }
      ((JSONArray)localObject).put("pulling");
      getComponent().refreshFireEvent("pulling", (JSONArray)localObject, this.mFireEventJsonObject);
    }
  }
  
  public void onStateRefreshing()
  {
    this.mHandler.removeCallbacks(this.mRunnable);
    Object localObject = this.mOnRefreshStateChangeListener;
    if (localObject != null) {
      ((VRefreshLayout.onRefreshStateChangeListener)localObject).onStateRefreshing();
    }
    localObject = new JSONArray();
    if ((getComponent() != null) && (getComponent().getDomObject() != null))
    {
      String str = getComponent().getDomObject().getRef();
      if (str != null) {
        ((JSONArray)localObject).put(str);
      }
      ((JSONArray)localObject).put("refresh");
      getComponent().refreshFireEvent("refresh", (JSONArray)localObject, this.mFireEventJsonObject);
    }
  }
  
  public void onStickRefreshing()
  {
    Object localObject = this.headerStateChangeListeners;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((VRefreshLayout.OnHeaderStateChangeListener)((Iterator)localObject).next()).onStickRefreshing();
      }
    }
  }
  
  public void setRefreshStick(boolean paramBoolean)
  {
    this.mIsRefreshStick = paramBoolean;
  }
  
  public void setStateFinish(boolean paramBoolean, String paramString)
  {
    VRefreshLayout.onRefreshStateChangeListener localonRefreshStateChangeListener = this.mOnRefreshStateChangeListener;
    if (localonRefreshStateChangeListener != null) {
      localonRefreshStateChangeListener.onStateFinish(paramBoolean, paramString);
    }
  }
  
  public void setonRefreshStateChangeListener(VRefreshLayout.onRefreshStateChangeListener paramonRefreshStateChangeListener)
  {
    this.mOnRefreshStateChangeListener = paramonRefreshStateChangeListener;
  }
  
  public void show()
  {
    setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.ui.view.VRefreshLayout
 * JD-Core Version:    0.7.0.1
 */