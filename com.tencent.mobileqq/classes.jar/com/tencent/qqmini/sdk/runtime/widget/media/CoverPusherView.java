package com.tencent.qqmini.sdk.runtime.widget.media;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import bgok;
import com.tencent.qqmini.sdk.core.widget.CoverView;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public class CoverPusherView
  extends CoverView
{
  private MiniAppLivePusher a;
  
  public CoverPusherView(@NonNull Context paramContext)
  {
    super(paramContext);
    this.a = new MiniAppLivePusher(paramContext);
    paramContext = new FrameLayout.LayoutParams(-1, -1);
    addView(this.a, paramContext);
  }
  
  public void a(bgok parambgok, JSONObject paramJSONObject)
  {
    this.a.a(parambgok, paramJSONObject);
  }
  
  public void a(String paramString, bgok parambgok, JSONObject paramJSONObject)
  {
    this.a.a(paramString, parambgok, paramJSONObject);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    this.a.a(paramJSONObject);
  }
  
  public void setAtyRef(WeakReference<Activity> paramWeakReference)
  {
    this.a.setAtyRef(paramWeakReference);
  }
  
  public void setData(String paramString)
  {
    this.a.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void setLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    super.setLayoutParams(paramLayoutParams);
  }
  
  public void setLivePusherId(int paramInt)
  {
    this.a.jdField_a_of_type_Long = paramInt;
  }
  
  public void setPageWebviewId(int paramInt)
  {
    this.a.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.widget.media.CoverPusherView
 * JD-Core Version:    0.7.0.1
 */