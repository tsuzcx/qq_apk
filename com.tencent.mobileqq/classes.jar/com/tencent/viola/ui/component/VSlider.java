package com.tencent.viola.ui.component;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.viola.annotation.VComponentProp;
import com.tencent.viola.core.ViolaDomManager;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.core.ViolaSDKManager;
import com.tencent.viola.ui.adapter.VLoopAbleSliderAdapter;
import com.tencent.viola.ui.baseComponent.VComponent;
import com.tencent.viola.ui.baseComponent.VComponentContainer;
import com.tencent.viola.ui.dom.Attr;
import com.tencent.viola.ui.dom.DomObject;
import com.tencent.viola.ui.view.VSliderView;
import com.tencent.viola.utils.ViolaLogUtils;
import com.tencent.viola.utils.ViolaUtils;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class VSlider
  extends VComponentContainer<VSliderView>
  implements Runnable
{
  private static final String CELL_SCALE = "cellScale";
  private static final String CELL_WIDTH = "cellWidth";
  private static final String LOOP_DISABLE = "loopDisable";
  public static final String TAG = "VSlider";
  private VLoopAbleSliderAdapter mAdapter;
  private Handler mBatchHandler;
  private boolean mIsNotify = false;
  
  public VSlider(ViolaInstance paramViolaInstance, DomObject paramDomObject, VComponentContainer paramVComponentContainer)
  {
    super(paramViolaInstance, paramDomObject, paramVComponentContainer);
  }
  
  private void changeIndicatorIndex(int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    Object localObject;
    try
    {
      localJSONObject.put("index", paramInt);
    }
    catch (Exception localException)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("change error :");
      ((StringBuilder)localObject).append(localException.getMessage());
      ViolaLogUtils.e("VSlider", ((StringBuilder)localObject).toString());
    }
    JSONArray localJSONArray = new JSONArray();
    if (getDomObject() != null)
    {
      localObject = getDomObject().getRef();
      if (localObject != null) {
        localJSONArray.put(localObject);
      }
    }
    localJSONArray.put("change");
    sliderFireEvent("change", localJSONArray, localJSONObject);
  }
  
  private void detectScrollable(VSliderView paramVSliderView)
  {
    if (paramVSliderView != null)
    {
      if (getChildCount() <= 1)
      {
        paramVSliderView.setScrollable(false);
        return;
      }
      paramVSliderView.setScrollable(true);
    }
  }
  
  private void fireAppear(int paramInt)
  {
    VComponent localVComponent = getChild(paramInt);
    if ((localVComponent instanceof VCell)) {
      ((VCell)localVComponent).appearFireEvent();
    }
  }
  
  private boolean loopDisable()
  {
    return (this.mDomObj != null) && (ViolaUtils.getBoolean(this.mDomObj.getAttributes().get("loopDisable")));
  }
  
  private void notifyDataChange()
  {
    VLoopAbleSliderAdapter localVLoopAbleSliderAdapter = this.mAdapter;
    if (localVLoopAbleSliderAdapter != null)
    {
      this.mIsNotify = true;
      localVLoopAbleSliderAdapter.notifyDataSetChanged();
      this.mIsNotify = false;
    }
  }
  
  private void setCellScale(Object paramObject, VSliderView paramVSliderView)
  {
    if (paramVSliderView == null) {
      return;
    }
    float f = ViolaUtils.getFloat(paramObject, Float.valueOf(1.0F));
    paramVSliderView.setPageTransformer(false, new VSlider.ScaleTransformer(this, f));
    this.mAdapter.setMinScale(f);
  }
  
  private void setCellWidth(Object paramObject)
  {
    if (paramObject != null)
    {
      if (getHostView() == null) {
        return;
      }
      ((VSliderView)getHostView()).setClipChildren(false);
      paramObject = (ViewGroup)((VSliderView)getHostView()).getParent();
      if (paramObject != null) {
        paramObject.setClipChildren(false);
      } else {
        ViolaLogUtils.d("VSlider", "patent is null");
      }
      paramObject = ((VSliderView)getHostView()).getLayoutParams();
      if ((paramObject instanceof FrameLayout.LayoutParams)) {
        ((FrameLayout.LayoutParams)paramObject).gravity = 1;
      }
      this.mAdapter.setCellExactlyWidth(paramObject.width);
    }
  }
  
  private void tryResumeState(VSliderView paramVSliderView)
  {
    if (paramVSliderView == null) {
      return;
    }
    if (this.mDomObj != null)
    {
      if (this.mDomObj.getDomChildCount() <= 1) {
        return;
      }
      Object localObject = this.mDomObj.getState("index");
      if ((localObject instanceof Integer))
      {
        int i = ((Integer)localObject).intValue();
        if ((i <= this.mDomObj.mDomChildren.size() - 1) && (i >= 0))
        {
          paramVSliderView.setStartIndexWithNoAnimate(i);
          changeIndicatorIndex(i);
          paramVSliderView = new StringBuilder();
          paramVSliderView.append("resumeState, index: ");
          paramVSliderView.append(i);
          ViolaLogUtils.d("VSlider", paramVSliderView.toString());
          return;
        }
        paramVSliderView.setStartIndexWithNoAnimate(0);
        return;
      }
      paramVSliderView.setStartIndexWithNoAnimate(0);
    }
  }
  
  public void addChild(VComponent paramVComponent, int paramInt)
  {
    super.addChild(paramVComponent, paramInt);
    detectScrollable((VSliderView)getHostView());
    notifyDataChange();
  }
  
  public void addEvent(String paramString)
  {
    int i;
    if ((paramString.hashCode() == -1361636432) && (paramString.equals("change"))) {
      i = 0;
    } else {
      i = -1;
    }
    if (i != 0)
    {
      super.addEvent(paramString);
      return;
    }
    this.mAppendEvents.add(paramString);
  }
  
  public void addSubView(View paramView, int paramInt) {}
  
  public void bindData()
  {
    if (!isLazy())
    {
      updateStyle(this.mDomObj.getStyle(), false);
      updateAttrs(this.mDomObj.getAttributes());
      updateExtra(this.mDomObj.getExtra());
      if (!ViolaUtils.isBindDataOpmOpen())
      {
        setBackgroundDrawable();
        checkClipChild();
      }
      checkDisAppearEventFromDomobject();
      updateLifeCycle("mounted");
    }
  }
  
  public void destroy()
  {
    super.destroy();
    this.mAdapter = null;
    if (getHostView() != null) {
      ((VSliderView)getHostView()).destroy();
    }
    Handler localHandler = this.mBatchHandler;
    if (localHandler != null) {
      localHandler.removeCallbacks(this);
    }
  }
  
  public void initAdapter()
  {
    this.mAdapter = new VLoopAbleSliderAdapter(this.mChildren, ViolaSDKManager.getInstance().getDomManager().getDomContext(this.mInstance.getInstanceId()), loopDisable());
  }
  
  protected VSliderView initComponentHostView(@NonNull Context paramContext)
  {
    initAdapter();
    paramContext = new VSliderView(paramContext, this.mAdapter);
    this.mAdapter.setSliderView(paramContext);
    paramContext.setClickable(true);
    paramContext.bindComponent(this);
    paramContext.setSliderListener(new VSlider.1(this));
    tryResumeState(paramContext);
    if (getDomObject().getAttributes().containsKey("cellScale")) {
      setCellScale(getDomObject().getAttributes().get("cellScale"), paramContext);
    }
    detectScrollable(paramContext);
    this.mBatchHandler = new Handler(Looper.getMainLooper());
    return paramContext;
  }
  
  public boolean isReuse()
  {
    return false;
  }
  
  public void notifyWhenChange(String paramString, DomObject paramDomObject)
  {
    if (loopDisable()) {
      return;
    }
    if ((paramDomObject != null) && (!"cell".equals(paramDomObject.getType())))
    {
      Handler localHandler = this.mBatchHandler;
      if (localHandler != null)
      {
        localHandler.removeCallbacks(this);
        this.mBatchHandler.postDelayed(this, 16L);
      }
    }
    super.notifyWhenChange(paramString, paramDomObject);
  }
  
  public void onActivityPause()
  {
    super.onActivityPause();
    if (getHostView() != null) {
      ((VSliderView)getHostView()).stopPlay();
    }
  }
  
  public void onActivityResume()
  {
    super.onActivityResume();
    if (getHostView() != null) {
      ((VSliderView)getHostView()).startPlay();
    }
  }
  
  public void remove(VComponent paramVComponent, boolean paramBoolean)
  {
    super.remove(paramVComponent, paramBoolean);
    detectScrollable((VSliderView)getHostView());
    notifyDataChange();
  }
  
  public void run()
  {
    notifyDataChange();
  }
  
  @VComponentProp(name="autoEnable")
  public void setAutoEnable(Boolean paramBoolean)
  {
    ((VSliderView)getHostView()).setIsAutoMode(paramBoolean.booleanValue());
  }
  
  @VComponentProp(initToHostView=true, name="index", nativeReturnMethod="getCurrentIndex")
  public void setIndex(int paramInt)
  {
    ((VSliderView)getHostView()).setStartItemIndex(paramInt);
  }
  
  @VComponentProp(name="interval")
  public void setInterval(int paramInt)
  {
    ((VSliderView)getHostView()).setTimeInterval(paramInt);
  }
  
  public boolean setProperty(String paramString, Object paramObject)
  {
    int i;
    if ((paramString.hashCode() == 1622491524) && (paramString.equals("cellWidth"))) {
      i = 0;
    } else {
      i = -1;
    }
    if (i != 0) {
      return super.setProperty(paramString, paramObject);
    }
    setCellWidth(paramObject);
    return true;
  }
  
  public void sliderFireEvent(String paramString, JSONArray paramJSONArray, JSONObject paramJSONObject)
  {
    fireEvent(paramString, paramJSONArray, paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.ui.component.VSlider
 * JD-Core Version:    0.7.0.1
 */