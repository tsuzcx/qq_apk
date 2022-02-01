package com.tencent.viola.ui.component;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.ui.baseComponent.VComponentContainer;
import com.tencent.viola.ui.dom.DomObject;
import com.tencent.viola.ui.dom.style.FlexConvertUtils;
import com.tencent.viola.ui.view.VFrameLayout;
import com.tencent.viola.utils.ColorParseUtils;
import com.tencent.viola.utils.ViolaLogUtils;
import com.tencent.viola.utils.ViolaUtils;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class VDiv
  extends VComponentContainer<VFrameLayout>
{
  public static final String TAG = "VDiv";
  private boolean mHasSetHighlightColor = false;
  private int mHighlightColor = 0;
  
  public VDiv(ViolaInstance paramViolaInstance, DomObject paramDomObject, VComponentContainer paramVComponentContainer)
  {
    super(paramViolaInstance, paramDomObject, paramVComponentContainer);
  }
  
  private JSONObject divFireBaseInfo()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("frame", getFrameInfo());
      return localJSONObject;
    }
    catch (Exception localException)
    {
      ViolaLogUtils.e("VDiv", "fivFireBaseInfo error :" + localException.getMessage());
    }
    return localJSONObject;
  }
  
  public void destroy()
  {
    super.destroy();
    if (getHostView() != null) {
      ((VFrameLayout)getHostView()).onDestroy();
    }
  }
  
  public void divFireTouchEvent(String paramString, float paramFloat1, float paramFloat2)
  {
    if (!this.mAppendEvents.contains(paramString)) {
      return;
    }
    JSONObject localJSONObject = divFireBaseInfo();
    try
    {
      float f1 = getInstance().getMatchWindowsX();
      float f2 = getInstance().getMatchWindowsY();
      localJSONObject.put("pageX", FlexConvertUtils.px2dip(paramFloat1 - f1) + "dp");
      localJSONObject.put("pageY", FlexConvertUtils.px2dip(paramFloat2 - f2) + "dp");
      fireEvent(paramString, getFireEventArgs(paramString), localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ViolaLogUtils.e("VDiv", "divFireTouchEvent error :" + localException.getMessage());
      }
    }
  }
  
  public void firePanEvent(String paramString, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONArray localJSONArray = new JSONArray();
    JSONObject localJSONObject2 = getPositionInfoRelativeToRoot(0);
    JSONObject localJSONObject3 = new JSONObject();
    JSONObject localJSONObject4 = new JSONObject();
    JSONObject localJSONObject5 = new JSONObject();
    try
    {
      localJSONObject1.put("viewFrame", localJSONObject2);
      localJSONObject1.put("frame", localJSONObject2);
      localJSONObject1.put("state", paramString);
      localJSONObject3.put("x", FlexConvertUtils.px2dip(paramFloat1) + "dp");
      localJSONObject3.put("y", FlexConvertUtils.px2dip(paramFloat2) + "dp");
      localJSONObject1.put("translation", localJSONObject3);
      localJSONObject4.put("x", FlexConvertUtils.px2dip(paramFloat3) + "dp");
      localJSONObject4.put("y", FlexConvertUtils.px2dip(paramFloat4) + "dp");
      localJSONObject1.put("location", localJSONObject4);
      localJSONObject5.put("x", paramFloat5);
      localJSONObject5.put("y", paramFloat6);
      localJSONObject1.put("velocity", localJSONObject5);
      paramString = this.mDomObj.getRef();
      if (!TextUtils.isEmpty(paramString)) {
        localJSONArray.put(paramString);
      }
      localJSONArray.put("pan");
      ViolaLogUtils.d("VDiv", "firePanEvent callData :" + localJSONArray.toString() + ", dom type = " + getDomObject().getType() + " , data " + localJSONObject1.toString());
      fireEvent("pan", localJSONArray, localJSONObject1);
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ViolaLogUtils.e("VDiv", "firePanEvent error:" + paramString.getMessage());
      }
    }
  }
  
  protected VFrameLayout initComponentHostView(@NonNull Context paramContext)
  {
    paramContext = new VFrameLayout(paramContext);
    paramContext.bindComponent(this);
    return paramContext;
  }
  
  public boolean isContainTargetEvent(String paramString)
  {
    return this.mAppendEvents.contains(paramString);
  }
  
  public void setBackgroundDrawable()
  {
    if (!this.mHasSetHighlightColor) {
      super.setBackgroundDrawable();
    }
    while (getHostView() == null) {
      return;
    }
    StateListDrawable localStateListDrawable = new StateListDrawable();
    Object localObject = new ColorDrawable(this.mHighlightColor);
    localStateListDrawable.addState(new int[] { 16842919 }, (Drawable)localObject);
    if (this.mBackgroundDrawable != null)
    {
      localObject = this.mBackgroundDrawable;
      localStateListDrawable.addState(new int[0], (Drawable)localObject);
    }
    if (Build.VERSION.SDK_INT >= 16) {
      ((VFrameLayout)getHostView()).setBackground(localStateListDrawable);
    }
    for (;;)
    {
      ((VFrameLayout)getHostView()).setClickable(true);
      return;
      ((VFrameLayout)getHostView()).setBackgroundDrawable(localStateListDrawable);
    }
  }
  
  public boolean setProperty(String paramString, Object paramObject)
  {
    String str = ViolaUtils.getString(paramObject, null);
    int i;
    if (str != null)
    {
      i = -1;
      switch (paramString.hashCode())
      {
      }
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        return super.setProperty(paramString, paramObject);
        if (paramString.equals("highlightBackgroundColor")) {
          i = 0;
        }
        break;
      }
    }
    this.mHasSetHighlightColor = true;
    this.mHighlightColor = ColorParseUtils.parseColor(str);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.ui.component.VDiv
 * JD-Core Version:    0.7.0.1
 */