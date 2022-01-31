package com.tencent.qqmini.sdk.runtime.widget.media;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import bgls;
import bgok;
import com.tencent.qqmini.sdk.core.widget.CoverView;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public class CoverLiveView
  extends CoverView
{
  private MiniAppLivePlayer a;
  
  public CoverLiveView(@NonNull Context paramContext)
  {
    super(paramContext);
    this.a = new MiniAppLivePlayer(paramContext);
    paramContext = new FrameLayout.LayoutParams(-1, -1);
    addView(this.a, paramContext);
  }
  
  private boolean a(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((!b()) && (this.a.a(paramLayoutParams.width, paramLayoutParams.height)))
    {
      long l = System.currentTimeMillis() - this.a.b;
      if (l < 1000L)
      {
        Log.w("CoverView", "setLayoutParams: wrong set size " + l, new Throwable());
        return true;
      }
    }
    return false;
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
  
  public boolean b()
  {
    return this.a.a();
  }
  
  public void setAtyRef(WeakReference<Activity> paramWeakReference)
  {
    this.a.setAtyRef(paramWeakReference);
  }
  
  public void setBaseRuntime(bgls parambgls)
  {
    this.a.jdField_a_of_type_Bgls = parambgls;
  }
  
  public void setData(String paramString)
  {
    this.a.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void setLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if (a(paramLayoutParams)) {
      return;
    }
    super.setLayoutParams(paramLayoutParams);
  }
  
  public void setLivePlayerId(int paramInt)
  {
    this.a.jdField_a_of_type_Long = paramInt;
  }
  
  public void setPageWebviewId(int paramInt)
  {
    this.a.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.widget.media.CoverLiveView
 * JD-Core Version:    0.7.0.1
 */