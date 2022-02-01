package com.tencent.viola.ui.component;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.animation.AccelerateInterpolator;
import com.tencent.viola.annotation.JSMethod;
import com.tencent.viola.annotation.VComponentProp;
import com.tencent.viola.bridge.ViolaBridgeManager;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.core.ViolaSDKManager;
import com.tencent.viola.ui.adapter.VSliderAdapter;
import com.tencent.viola.ui.baseComponent.VComponentContainer;
import com.tencent.viola.ui.dom.Attr;
import com.tencent.viola.ui.dom.DomObject;
import com.tencent.viola.ui.dom.style.FlexConvertUtils;
import com.tencent.viola.ui.view.PageSliderScroller;
import com.tencent.viola.ui.view.VPageSliderView;
import com.tencent.viola.utils.ViolaLogUtils;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class VPageSlider
  extends VComponentContainer<VPageSliderView>
{
  public static String TAG = "VPageSlider";
  private VSliderAdapter mAdapter;
  private int mCallbackTime = 250;
  private Handler mHandler;
  private boolean mIsHorizontal = true;
  private VPageSlider.OnJSSetIndexListener onJSSetIndexListener;
  
  public VPageSlider(ViolaInstance paramViolaInstance, DomObject paramDomObject, VComponentContainer paramVComponentContainer)
  {
    super(paramViolaInstance, paramDomObject, paramVComponentContainer);
  }
  
  private void callbackJs(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.mHandler.postDelayed(new VPageSlider.3(this, paramString), this.mCallbackTime);
    }
  }
  
  private void tryResumeState(VPageSliderView paramVPageSliderView)
  {
    if (paramVPageSliderView == null) {}
    int i;
    do
    {
      Object localObject;
      do
      {
        return;
        localObject = this.mDomObj.getState("index");
      } while (!(localObject instanceof Integer));
      i = ((Integer)localObject).intValue();
    } while (i > this.mDomObj.mDomChildren.size() - 1);
    paramVPageSliderView.setStartItemIndex(Boolean.valueOf(false), i);
  }
  
  public void addEvent(String paramString)
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
        super.addEvent(paramString);
        return;
        if (paramString.equals("change"))
        {
          i = 0;
          continue;
          if (paramString.equals("overScroll")) {
            i = 1;
          }
        }
        break;
      }
    }
    this.mAppendEvents.add(paramString);
    return;
    this.mAppendEvents.add(paramString);
  }
  
  public void destroy()
  {
    super.destroy();
    this.mAdapter = null;
    if (getHostView() != null) {
      ((VPageSliderView)getHostView()).destroy();
    }
  }
  
  @JSMethod(uiThread=true)
  public void exchange(int paramInt1, int paramInt2)
  {
    ((VPageSliderView)getHostView()).changeTwoPage(paramInt1, paramInt2);
  }
  
  @JSMethod(uiThread=true)
  public void getIndex(String paramString)
  {
    JSONObject localJSONObject;
    if (!TextUtils.isEmpty(paramString)) {
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("index", ((VPageSliderView)getHostView()).getCurrentItem());
      JSONArray localJSONArray = new JSONArray();
      localJSONArray.put(paramString);
      ViolaBridgeManager.getInstance().callbackJavascript(this.mInstance.getInstanceId(), "", "callback", localJSONArray, localJSONObject, true);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public void initAdapter()
  {
    this.mAdapter = new VSliderAdapter(this.mChildren);
  }
  
  protected VPageSliderView initComponentHostView(@NonNull Context paramContext)
  {
    initAdapter();
    String str = "horizontal";
    if (getDomObject().getAttributes().containsKey("direction")) {
      str = getDomObject().getAttributes().get("direction").toString();
    }
    boolean bool;
    VSliderAdapter localVSliderAdapter;
    if ("vertical".equals(str))
    {
      bool = false;
      this.mIsHorizontal = bool;
      localVSliderAdapter = this.mAdapter;
      if (!"vertical".equals(str)) {
        break label129;
      }
    }
    label129:
    for (str = "vertical";; str = "horizontal")
    {
      paramContext = new VPageSliderView(paramContext, localVSliderAdapter, str);
      paramContext.setClickable(true);
      paramContext.bindComponent(this);
      paramContext.setSliderListener(new VPageSlider.1(this));
      this.mHandler = new Handler();
      tryResumeState(paramContext);
      return paramContext;
      bool = true;
      break;
    }
  }
  
  public boolean isPageSliderHorizontal()
  {
    return this.mIsHorizontal;
  }
  
  @JSMethod(uiThread=true)
  public void next(Boolean paramBoolean, String paramString)
  {
    toNextIndex(paramBoolean, paramString);
  }
  
  public void notifyChange()
  {
    try
    {
      if ((getHostView() instanceof VPageSliderView)) {
        ViolaSDKManager.getInstance().postOnUiThread(new VPageSlider.2(this));
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void overScrollFireEvent(float paramFloat)
  {
    if (!this.mAppendEvents.contains("overScroll")) {
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("overX", FlexConvertUtils.px2dip(paramFloat));
      localJSONObject.put("overY", 0);
      localJSONObject.put("frame", getPositionInfoRelativeToParent(1));
      JSONArray localJSONArray = new JSONArray();
      if (((VPageSliderView)getHostView()).getComponent().getDomObject() != null)
      {
        String str = ((VPageSliderView)getHostView()).getComponent().getDomObject().getRef();
        if (str != null) {
          localJSONArray.put(str);
        }
      }
      localJSONArray.put("overScroll");
      fireEvent("overScroll", localJSONArray, localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ViolaLogUtils.e(TAG, "overScrollFireEvent error :" + localException.getMessage());
      }
    }
  }
  
  @JSMethod(uiThread=true)
  public void prev(Boolean paramBoolean, String paramString)
  {
    toLastIndex(paramBoolean, paramString);
  }
  
  public boolean resetAttr(String paramString)
  {
    if (!super.resetAttr(paramString))
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
          if (paramString.equals("index"))
          {
            i = 0;
            continue;
            if (paramString.equals("duration"))
            {
              i = 1;
              continue;
              if (paramString.equals("scrollEnable")) {
                i = 2;
              }
            }
          }
          break;
        }
      }
      setStartIndex(Boolean.valueOf(false), 0);
      return true;
      setDuration(250);
      return true;
      setScrollEnable(Boolean.valueOf(true));
      return true;
    }
    return false;
  }
  
  @VComponentProp(name="bouncesEnable")
  public void setBouncesEnable(Boolean paramBoolean)
  {
    if (getHostView() != null) {
      ((VPageSliderView)getHostView()).setBouncesEnable(paramBoolean);
    }
  }
  
  @VComponentProp(name="duration")
  public void setDuration(int paramInt)
  {
    if (paramInt != 250) {}
    try
    {
      this.mCallbackTime = paramInt;
      Field localField = ViewPager.class.getDeclaredField("mScroller");
      localField.setAccessible(true);
      PageSliderScroller localPageSliderScroller = new PageSliderScroller(((VPageSliderView)getHostView()).getContext(), new AccelerateInterpolator());
      localPageSliderScroller.setDuration(paramInt);
      localField.set(getHostView(), localPageSliderScroller);
      return;
    }
    catch (Exception localException)
    {
      ViolaLogUtils.e(TAG, "setDuration error :" + localException.getMessage());
    }
  }
  
  @JSMethod(uiThread=true)
  public void setIndex(JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject != null)
    {
      int i = paramJSONObject.optInt("index", 0);
      if (this.onJSSetIndexListener != null) {
        this.onJSSetIndexListener.onSetIndex(i);
      }
      boolean bool = paramJSONObject.optBoolean("animated", true);
      ((VPageSliderView)getHostView()).setCurrentItem(i, bool);
      callbackJs(paramString);
    }
  }
  
  public void setOnJSSetIndexListener(VPageSlider.OnJSSetIndexListener paramOnJSSetIndexListener)
  {
    this.onJSSetIndexListener = paramOnJSSetIndexListener;
  }
  
  @VComponentProp(name="scrollEnable")
  public void setScrollEnable(Boolean paramBoolean)
  {
    if (getHostView() != null) {
      ((VPageSliderView)getHostView()).setScrollEnable(paramBoolean.booleanValue());
    }
  }
  
  @VComponentProp(name="index")
  public void setStartIndex(int paramInt)
  {
    if (getHostView() != null) {
      ((VPageSliderView)getHostView()).setStartItemIndex(Boolean.valueOf(false), paramInt);
    }
  }
  
  public void setStartIndex(Boolean paramBoolean, int paramInt)
  {
    if (getHostView() != null) {
      ((VPageSliderView)getHostView()).setStartItemIndex(paramBoolean, paramInt);
    }
  }
  
  @JSMethod(uiThread=true)
  public void toLastIndex(Boolean paramBoolean, String paramString)
  {
    ((VPageSliderView)getHostView()).toLastIndex(paramBoolean.booleanValue());
    callbackJs(paramString);
  }
  
  @JSMethod(uiThread=true)
  public void toNextIndex(Boolean paramBoolean, String paramString)
  {
    ((VPageSliderView)getHostView()).toNextIndex(paramBoolean.booleanValue());
    callbackJs(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.ui.component.VPageSlider
 * JD-Core Version:    0.7.0.1
 */