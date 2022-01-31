package com.tencent.qqmini.sdk.core.widget.media;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import bghn;
import bgho;
import com.tencent.qqmini.sdk.core.widget.CoverView;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public class CoverVideoView
  extends CoverView
{
  private MiniAppVideoPlayer a;
  
  public CoverVideoView(Context paramContext)
  {
    super(paramContext);
    this.a = new MiniAppVideoPlayer(paramContext);
    paramContext = new FrameLayout.LayoutParams(-1, -1);
    addView(this.a, paramContext);
  }
  
  public void a()
  {
    this.a.f();
  }
  
  public void a(String paramString, int paramInt)
  {
    this.a.a(paramString, paramInt);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    this.a.b(paramJSONObject);
  }
  
  public boolean a(int paramInt)
  {
    return this.a.a(paramInt);
  }
  
  public void b()
  {
    this.a.g();
  }
  
  public void b(JSONObject paramJSONObject)
  {
    this.a.c(paramJSONObject);
  }
  
  public boolean b()
  {
    if (!this.a.c())
    {
      this.a.a();
      return true;
    }
    return false;
  }
  
  public void c()
  {
    this.a.c();
  }
  
  public boolean c()
  {
    if (this.a.c())
    {
      this.a.a();
      return true;
    }
    return false;
  }
  
  public void d()
  {
    this.a.d();
  }
  
  public boolean d()
  {
    return this.a.a();
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
  
  public void setMiniAppContext(bgho parambgho)
  {
    this.a.b = new WeakReference(parambgho);
  }
  
  public void setPageWebviewId(int paramInt)
  {
    this.a.jdField_a_of_type_Int = paramInt;
  }
  
  public void setServiceWebview(bghn parambghn)
  {
    this.a.jdField_a_of_type_Bghn = parambghn;
  }
  
  public void setVideoPath(String paramString)
  {
    this.a.setVideoPath(paramString);
  }
  
  public void setVideoPlayerId(int paramInt)
  {
    this.a.jdField_a_of_type_Long = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.widget.media.CoverVideoView
 * JD-Core Version:    0.7.0.1
 */