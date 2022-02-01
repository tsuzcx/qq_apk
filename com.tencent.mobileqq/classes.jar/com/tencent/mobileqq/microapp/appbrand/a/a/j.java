package com.tencent.mobileqq.microapp.appbrand.a.a;

import com.tencent.mobileqq.microapp.sdk.MiniAppController;
import com.tencent.mobileqq.microapp.webview.BaseAppBrandWebview;
import java.util.HashSet;
import java.util.Set;

public final class j
  extends a
{
  private Set b = new HashSet();
  
  public j()
  {
    this.b.add("requestPayment");
    this.b.add("getLocation");
    this.b.add("openLocation");
    this.b.add("chooseLocation");
    this.b.add("chooseVideo");
    this.b.add("saveVideoToPhotosAlbum");
    this.b.add("chooseImage");
    this.b.add("previewImage");
    this.b.add("getImageInfo");
    this.b.add("saveImageToPhotosAlbum");
    this.b.add("openSetting");
    this.b.add("getSetting");
    this.b.add("scanCode");
  }
  
  public String a(String paramString1, String paramString2, BaseAppBrandWebview paramBaseAppBrandWebview, int paramInt)
  {
    return MiniAppController.getInstance().handleNativeRequest(this.a.a.d, this.a.a.a, paramString1, paramString2, paramBaseAppBrandWebview, paramInt);
  }
  
  public Set a()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.appbrand.a.a.j
 * JD-Core Version:    0.7.0.1
 */