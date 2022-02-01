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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("fivFireBaseInfo error :");
      localStringBuilder.append(localException.getMessage());
      ViolaLogUtils.e("VDiv", localStringBuilder.toString());
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
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append(FlexConvertUtils.px2dip(paramFloat1 - f1));
      localStringBuilder1.append("dp");
      localJSONObject.put("pageX", localStringBuilder1.toString());
      localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append(FlexConvertUtils.px2dip(paramFloat2 - f2));
      localStringBuilder1.append("dp");
      localJSONObject.put("pageY", localStringBuilder1.toString());
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("divFireTouchEvent error :");
      localStringBuilder2.append(localException.getMessage());
      ViolaLogUtils.e("VDiv", localStringBuilder2.toString());
    }
    fireEvent(paramString, getFireEventArgs(paramString), localJSONObject);
  }
  
  public void firePanEvent(String paramString, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONArray localJSONArray = new JSONArray();
    JSONObject localJSONObject4 = getPositionInfoRelativeToRoot(0);
    JSONObject localJSONObject3 = new JSONObject();
    Object localObject = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    try
    {
      localJSONObject1.put("viewFrame", localJSONObject4);
      localJSONObject1.put("frame", localJSONObject4);
      localJSONObject1.put("state", paramString);
      paramString = new StringBuilder();
      paramString.append(FlexConvertUtils.px2dip(paramFloat1));
      paramString.append("dp");
      localJSONObject3.put("x", paramString.toString());
      paramString = new StringBuilder();
      paramString.append(FlexConvertUtils.px2dip(paramFloat2));
      paramString.append("dp");
      localJSONObject3.put("y", paramString.toString());
      localJSONObject1.put("translation", localJSONObject3);
      paramString = new StringBuilder();
      paramString.append(FlexConvertUtils.px2dip(paramFloat3));
      paramString.append("dp");
      ((JSONObject)localObject).put("x", paramString.toString());
      paramString = new StringBuilder();
      paramString.append(FlexConvertUtils.px2dip(paramFloat4));
      paramString.append("dp");
      ((JSONObject)localObject).put("y", paramString.toString());
      localJSONObject1.put("location", localObject);
      localJSONObject2.put("x", paramFloat5);
      localJSONObject2.put("y", paramFloat6);
      localJSONObject1.put("velocity", localJSONObject2);
      paramString = this.mDomObj.getRef();
      if (!TextUtils.isEmpty(paramString)) {
        localJSONArray.put(paramString);
      }
    }
    catch (Exception paramString)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("firePanEvent error:");
      ((StringBuilder)localObject).append(paramString.getMessage());
      ViolaLogUtils.e("VDiv", ((StringBuilder)localObject).toString());
    }
    localObject = "pan";
    if (isContainTargetEvent("pan")) {
      paramString = "pan";
    } else {
      paramString = "androidPan";
    }
    localJSONArray.put(paramString);
    paramString = new StringBuilder();
    paramString.append("firePanEvent callData :");
    paramString.append(localJSONArray.toString());
    paramString.append(", dom type = ");
    paramString.append(getDomObject().getType());
    paramString.append(" , data ");
    paramString.append(localJSONObject1.toString());
    ViolaLogUtils.d("VDiv", paramString.toString());
    if (isContainTargetEvent("pan")) {
      paramString = (String)localObject;
    } else {
      paramString = "androidPan";
    }
    fireEvent(paramString, localJSONArray, localJSONObject1);
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
    if (!this.mHasSetHighlightColor)
    {
      super.setBackgroundDrawable();
      return;
    }
    if (getHostView() != null)
    {
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
      } else {
        ((VFrameLayout)getHostView()).setBackgroundDrawable(localStateListDrawable);
      }
      ((VFrameLayout)getHostView()).setClickable(true);
    }
  }
  
  public boolean setProperty(String paramString, Object paramObject)
  {
    String str = ViolaUtils.getString(paramObject, null);
    if (str != null)
    {
      int i = -1;
      if ((paramString.hashCode() == 1126933377) && (paramString.equals("highlightBackgroundColor"))) {
        i = 0;
      }
      if (i == 0)
      {
        this.mHasSetHighlightColor = true;
        this.mHighlightColor = ColorParseUtils.parseColor(str);
        return true;
      }
    }
    return super.setProperty(paramString, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.ui.component.VDiv
 * JD-Core Version:    0.7.0.1
 */