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
    if (paramVPageSliderView == null) {
      return;
    }
    Object localObject = this.mDomObj.getState("index");
    if ((localObject instanceof Integer))
    {
      int i = ((Integer)localObject).intValue();
      if (i <= this.mDomObj.mDomChildren.size() - 1) {
        paramVPageSliderView.setStartItemIndex(Boolean.valueOf(false), i);
      }
    }
  }
  
  public void addEvent(String paramString)
  {
    int i = paramString.hashCode();
    if (i != -1361636432)
    {
      if ((i == 1628119233) && (paramString.equals("overScroll")))
      {
        i = 1;
        break label50;
      }
    }
    else if (paramString.equals("change"))
    {
      i = 0;
      break label50;
    }
    i = -1;
    label50:
    if (i != 0)
    {
      if (i != 1)
      {
        super.addEvent(paramString);
        return;
      }
      this.mAppendEvents.add(paramString);
      return;
    }
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
    if (!TextUtils.isEmpty(paramString))
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("index", ((VPageSliderView)getHostView()).getCurrentItem());
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      JSONArray localJSONArray = new JSONArray();
      localJSONArray.put(paramString);
      ViolaBridgeManager.getInstance().callbackJavascript(this.mInstance.getInstanceId(), "", "callback", localJSONArray, localJSONObject, true);
    }
  }
  
  public void initAdapter()
  {
    this.mAdapter = new VSliderAdapter(this.mChildren);
  }
  
  protected VPageSliderView initComponentHostView(@NonNull Context paramContext)
  {
    initAdapter();
    Object localObject;
    if (getDomObject().getAttributes().containsKey("direction")) {
      localObject = getDomObject().getAttributes().get("direction").toString();
    } else {
      localObject = "horizontal";
    }
    String str = "vertical";
    this.mIsHorizontal = ("vertical".equals(localObject) ^ true);
    VSliderAdapter localVSliderAdapter = this.mAdapter;
    if ("vertical".equals(localObject)) {
      localObject = str;
    } else {
      localObject = "horizontal";
    }
    paramContext = new VPageSliderView(paramContext, localVSliderAdapter, (String)localObject);
    paramContext.setClickable(true);
    paramContext.bindComponent(this);
    paramContext.setSliderListener(new VPageSlider.1(this));
    this.mHandler = new Handler();
    tryResumeState(paramContext);
    return paramContext;
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
    String str;
    try
    {
      localJSONObject.put("overX", FlexConvertUtils.px2dip(paramFloat));
      localJSONObject.put("overY", 0);
      localJSONObject.put("frame", getPositionInfoRelativeToParent(1));
    }
    catch (Exception localException)
    {
      str = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("overScrollFireEvent error :");
      localStringBuilder.append(localException.getMessage());
      ViolaLogUtils.e(str, localStringBuilder.toString());
    }
    JSONArray localJSONArray = new JSONArray();
    if (((VPageSliderView)getHostView()).getComponent().getDomObject() != null)
    {
      str = ((VPageSliderView)getHostView()).getComponent().getDomObject().getRef();
      if (str != null) {
        localJSONArray.put(str);
      }
    }
    localJSONArray.put("overScroll");
    fireEvent("overScroll", localJSONArray, localJSONObject);
  }
  
  @JSMethod(uiThread=true)
  public void prev(Boolean paramBoolean, String paramString)
  {
    toLastIndex(paramBoolean, paramString);
  }
  
  protected boolean resetAttr(String paramString)
  {
    if (!super.resetAttr(paramString))
    {
      int i = -1;
      int j = paramString.hashCode();
      if (j != -1992012396)
      {
        if (j != -1145509200)
        {
          if ((j == 100346066) && (paramString.equals("index"))) {
            i = 0;
          }
        }
        else if (paramString.equals("scrollEnable")) {
          i = 2;
        }
      }
      else if (paramString.equals("duration")) {
        i = 1;
      }
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2) {
            return false;
          }
          setScrollEnable(Boolean.valueOf(true));
          return true;
        }
        setDuration(250);
        return true;
      }
      setStartIndex(Boolean.valueOf(false), 0);
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
    if (paramInt != 250) {
      try
      {
        this.mCallbackTime = paramInt;
        Field localField = ViewPager.class.getDeclaredField("mScroller");
        localField.setAccessible(true);
        localObject = new PageSliderScroller(((VPageSliderView)getHostView()).getContext(), new AccelerateInterpolator());
        ((PageSliderScroller)localObject).setDuration(paramInt);
        localField.set(getHostView(), localObject);
        return;
      }
      catch (Exception localException)
      {
        Object localObject = TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setDuration error :");
        localStringBuilder.append(localException.getMessage());
        ViolaLogUtils.e((String)localObject, localStringBuilder.toString());
      }
    }
  }
  
  @JSMethod(uiThread=true)
  public void setIndex(JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject != null)
    {
      int i = paramJSONObject.optInt("index", 0);
      VPageSlider.OnJSSetIndexListener localOnJSSetIndexListener = this.onJSSetIndexListener;
      if (localOnJSSetIndexListener != null) {
        localOnJSSetIndexListener.onSetIndex(i);
      }
      boolean bool = paramJSONObject.optBoolean("animated", true);
      ((VPageSliderView)getHostView()).setCurrentItem(i, bool);
      callbackJs(paramString);
    }
  }
  
  @VComponentProp(name="interruptEnable")
  public void setInterruptEnable(Boolean paramBoolean)
  {
    if (getHostView() != null) {
      ((VPageSliderView)getHostView()).setInterruptEnable(paramBoolean);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.ui.component.VPageSlider
 * JD-Core Version:    0.7.0.1
 */