package com.tencent.mobileqq.qqgamepub.web;

import android.text.TextUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.mobileqq.qqgamepub.utils.GamePubAccountHelper;

public class QQGameReportLogic
{
  public void a()
  {
    GamePubAccountHelper.d(GamePubAccountHelper.a()).h("769").e("1").f("160").d("76925").c("207553").a(4, "20").a();
  }
  
  public void a(int paramInt)
  {
    GamePubAccountHelper.d(GamePubAccountHelper.a()).h("769").e("1").f("160").d("76902").c("205838").a(4, "8").a(paramInt).a();
  }
  
  public void a(String paramString)
  {
    GamePubAccountHelper.d(GamePubAccountHelper.a()).h("769").e("1").f("160").d("76901").c("205031").a(2, paramString).a(4, "20").a();
  }
  
  public void a(String paramString1, String paramString2)
  {
    GamePubAccountHelper.d(GamePubAccountHelper.a()).h("769").e("1").f("160").d("76901").b(paramString1).c("205030").a(2, paramString2).a(4, "8").a();
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    WadlReportBuilder localWadlReportBuilder = GamePubAccountHelper.d(GamePubAccountHelper.a());
    localWadlReportBuilder.h("770").e("1").f("160").d("77002").c("207021").a(4, "8").a(24, "1").a();
    if (!paramBoolean)
    {
      String str = paramString;
      if (TextUtils.isEmpty(paramString)) {
        str = "";
      }
      localWadlReportBuilder.a(2, str).a(3, "3");
    }
    else if (!TextUtils.isEmpty(paramString))
    {
      localWadlReportBuilder.a(2, paramString);
      localWadlReportBuilder.a(3, "1");
    }
    else
    {
      localWadlReportBuilder.a(3, "2");
    }
    localWadlReportBuilder.a();
  }
  
  public void b()
  {
    GamePubAccountHelper.d(GamePubAccountHelper.a()).h("769").e("1").f("160").d("76925").c("207552").a(4, "8").a();
  }
  
  public void b(String paramString1, String paramString2)
  {
    GamePubAccountHelper.d(GamePubAccountHelper.a()).h("769").e("1").f("160").d("76901").c("205037").a(2, paramString2).a(3, "1").a(4, "20").b(paramString1).a();
  }
  
  public void c()
  {
    GamePubAccountHelper.d(GamePubAccountHelper.a()).h("769").e("1").f("160").d("76901").c("205036").a(4, "20").a();
  }
  
  public void c(String paramString1, String paramString2)
  {
    GamePubAccountHelper.d(GamePubAccountHelper.a()).h("769").e("1").f("160").d("76901").c("205037").a(2, paramString2).a(3, "2").a(4, "20").b(paramString1).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.web.QQGameReportLogic
 * JD-Core Version:    0.7.0.1
 */