package com.tencent.mobileqq.shortvideo.filter;

import android.text.TextUtils;
import com.tencent.av.video.effect.core.EffectTexture;
import com.tencent.av.video.effect.filter.FilterRender;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.shortvideo.resource.AVFilterResource;
import com.tencent.mobileqq.shortvideo.resource.Resources;
import com.tencent.sveffects.SLog;
import com.tencent.sveffects.SdkContext;

public class QQAVFilter
  extends QQBaseFilter
{
  private FilterRender a;
  private int e = 0;
  private int f = 0;
  
  public QQAVFilter(int paramInt, QQFilterRenderManager paramQQFilterRenderManager)
  {
    super(paramInt, paramQQFilterRenderManager);
  }
  
  private String a(String paramString, FilterDesc paramFilterDesc)
  {
    String str2 = "";
    String str1 = str2;
    if (paramFilterDesc != null)
    {
      str1 = str2;
      if (paramFilterDesc.e.equals("EMPTY")) {
        str1 = null;
      }
      if (paramFilterDesc.e.equals("MANHUA")) {
        str1 = paramString + "COMIC";
      }
      if (paramFilterDesc.e.equals("SHENGXIA")) {
        str1 = paramString + "GESE";
      }
      if (paramFilterDesc.e.equals("NUANYANG")) {
        str1 = paramString + "BRIGHTFIRE";
      }
      if (paramFilterDesc.e.equals("YUEGUANG")) {
        str1 = paramString + "SKYLINE";
      }
      if (paramFilterDesc.e.equals("QIANGWEI")) {
        str1 = paramString + "G1";
      }
      if (paramFilterDesc.e.equals("YOULAN")) {
        str1 = paramString + "ORCHID";
      }
      if (paramFilterDesc.e.equals("SHENGDAE")) {
        str1 = paramString + "SHENGDAI";
      }
      if (paramFilterDesc.e.equals("BOHE")) {
        str1 = paramString + "AMARO";
      }
      if (paramFilterDesc.e.equals("LANGMAN")) {
        str1 = paramString + "FENBI";
      }
      if (paramFilterDesc.e.equals("VSCOG3")) {
        str1 = paramString + "VSCOG3";
      }
      if (paramFilterDesc.e.equals("VUEF1")) {
        str1 = paramString + "VUEF1";
      }
      if (paramFilterDesc.e.equals("VSCOC1")) {
        str1 = paramString + "VSCOC1";
      }
      if (paramFilterDesc.e.equals("FOODIEYU5")) {
        str1 = paramString + "FOODIEYU5";
      }
      if (paramFilterDesc.e.equals("FOODIECH1")) {
        str1 = paramString + "FOODIECH1";
      }
      if (paramFilterDesc.e.equals("ANALOGFILM04")) {
        str1 = paramString + "ANALOGFILM04";
      }
      if (paramFilterDesc.e.equals("INSLARK")) {
        str1 = paramString + "INSLARK";
      }
      if (paramFilterDesc.e.equals("BEAUTYCAM")) {
        str1 = paramString + "BEAUTYCAM";
      }
      if (paramFilterDesc.e.equals("ANALOGFILM02")) {
        str1 = paramString + "ANALOGFILM02";
      }
      if (paramFilterDesc.e.equals("BLACKWHITE")) {
        str1 = paramString + "BLACKWHITE";
      }
      if (paramFilterDesc.e.equals("B612HONGRUN")) {
        str1 = paramString + "B612HONGRUN";
      }
      if (paramFilterDesc.e.equals("INSTASIZETOKYO")) {
        str1 = paramString + "INSTASIZETOKYO";
      }
      if (paramFilterDesc.e.equals("MEITUJIAOPIAN")) {
        str1 = paramString + "MEITUJIAOPIAN";
      }
      if (paramFilterDesc.e.equals("MEIYANHUAYAN")) {
        str1 = paramString + "MEIYANHUAYAN";
      }
      if (paramFilterDesc.e.equals("VUELANMEIZHIYE")) {
        str1 = paramString + "VUELANMEIZHIYE";
      }
      if (paramFilterDesc.e.equals("HEAVYFELLING")) {
        str1 = paramString + "HEAVYFELLING";
      }
      if (paramFilterDesc.e.equals("ANHONG")) {
        str1 = paramString + "ANHONG";
      }
      if (paramFilterDesc.e.equals("BOPU")) {
        str1 = paramString + "BOPU";
      }
      if (paramFilterDesc.e.equals("KLEINBLUE")) {
        str1 = paramString + "KLEINBLUE";
      }
      if (paramFilterDesc.e.equals("PURPLEORANGE")) {
        str1 = paramString + "PURPLEORANGE";
      }
      if (paramFilterDesc.e.equals("TEATIME")) {
        str1 = paramString + "TEATIME";
      }
      if (paramFilterDesc.e.equals("FOREST")) {
        str1 = paramString + "FOREST";
      }
      if (paramFilterDesc.e.equals("NORGE")) {
        str1 = paramString + "NORGE";
      }
      if (paramFilterDesc.e.equals("SANTORINI")) {
        str1 = paramString + "SANTORINI";
      }
      if (paramFilterDesc.e.equals("SHIFTER")) {
        str1 = paramString + "SHIFTER";
      }
      if (paramFilterDesc.e.equals("BLACKNOISE")) {
        str1 = paramString + "BLACKNOISE";
      }
      if (paramFilterDesc.e.equals("STRONG")) {
        str1 = paramString + "STRONG";
      }
      if (paramFilterDesc.e.equals("DELICIOUS")) {
        str1 = paramString + "DELICIOUS";
      }
      if (paramFilterDesc.e.equals("WHITETEA")) {
        str1 = paramString + "WHITETEA";
      }
      if (paramFilterDesc.e.equals("SALIS")) {
        str1 = paramString + "SALIS";
      }
      if (paramFilterDesc.e.equals("CLEANCOLD")) {
        str1 = paramString + "CLEANCOLD";
      }
      if (paramFilterDesc.e.equals("FILM")) {
        str1 = paramString + "FILM";
      }
      if (paramFilterDesc.e.equals("MACAROON")) {
        str1 = paramString + "MACAROON";
      }
      if (paramFilterDesc.e.equals("GRASS")) {
        str1 = paramString + "GRASS";
      }
    }
    return str1;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoEffectFilterFilterRender != null)
    {
      this.jdField_a_of_type_ComTencentAvVideoEffectFilterFilterRender.destroy();
      this.jdField_a_of_type_ComTencentAvVideoEffectFilterFilterRender = null;
      SLog.c("avFilterRender", "destroyNewFilter");
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoEffectFilterFilterRender != null) {
      return this.jdField_a_of_type_ComTencentAvVideoEffectFilterFilterRender.getFilterType();
    }
    return 0;
  }
  
  public void a(FilterDesc paramFilterDesc)
  {
    String str3 = SdkContext.a().a().a().a();
    String str1 = "";
    if (paramFilterDesc != null) {
      str1 = paramFilterDesc.b(str3);
    }
    String str2 = str1;
    if (TextUtils.isEmpty(str1)) {
      str2 = a(str3, paramFilterDesc);
    }
    if (this.jdField_a_of_type_ComTencentAvVideoEffectFilterFilterRender == null) {
      this.jdField_a_of_type_ComTencentAvVideoEffectFilterFilterRender = new FilterRender(SdkContext.a().a());
    }
    this.jdField_a_of_type_ComTencentAvVideoEffectFilterFilterRender.setFilterPath(str2);
    if (!TextUtils.isEmpty(str2))
    {
      SLog.c("avFilterRender", "setNewSdkFilterID path:" + str2);
      return;
    }
    SLog.c("avFilterRender", "set empty path~~");
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if ((this.f != paramInt1) || (this.f != paramInt2)) {
      a();
    }
    if (this.jdField_a_of_type_ComTencentAvVideoEffectFilterFilterRender == null) {
      this.jdField_a_of_type_ComTencentAvVideoEffectFilterFilterRender = new FilterRender(SdkContext.a().a());
    }
    a(a().a(0));
    SLog.c("avFilterRender", "AVFILTER onSurfaceChange");
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoEffectFilterFilterRender != null) {
      a();
    }
    if (this.jdField_a_of_type_ComTencentAvVideoEffectFilterFilterRender == null)
    {
      this.jdField_a_of_type_ComTencentAvVideoEffectFilterFilterRender = new FilterRender(SdkContext.a().a());
      this.e = a().f();
      this.f = a().g();
      this.jdField_a_of_type_ComTencentAvVideoEffectFilterFilterRender.preProcess(this.e, this.f);
    }
  }
  
  public void e()
  {
    a();
    SLog.c("avFilterRender", "AVFILTER onSurfaceDestroy");
  }
  
  public boolean f_()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoEffectFilterFilterRender == null) {}
    while (this.jdField_a_of_type_ComTencentAvVideoEffectFilterFilterRender.getFilterType() == -1) {
      return false;
    }
    return true;
  }
  
  public void h()
  {
    boolean bool = false;
    if (this.jdField_a_of_type_ComTencentAvVideoEffectFilterFilterRender == null)
    {
      this.jdField_a_of_type_ComTencentAvVideoEffectFilterFilterRender = new FilterRender(SdkContext.a().a());
      a(a().a(0));
    }
    this.e = a().f();
    this.f = a().g();
    this.b = this.jdField_a_of_type_ComTencentAvVideoEffectFilterFilterRender.process(this.jdField_a_of_type_Int, -1, this.e, this.f).getTextureId();
    if (this.jdField_a_of_type_ComTencentAvVideoEffectFilterFilterRender.getFilterType() != -1) {
      bool = true;
    }
    QQFilterLogManager.a("QQAvFilter", bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.filter.QQAVFilter
 * JD-Core Version:    0.7.0.1
 */