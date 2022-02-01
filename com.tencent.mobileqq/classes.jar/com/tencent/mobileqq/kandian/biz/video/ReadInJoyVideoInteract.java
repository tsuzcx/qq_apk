package com.tencent.mobileqq.kandian.biz.video;

import android.app.PendingIntent;
import android.app.PendingIntent.CanceledException;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.recent.bannerprocessor.BBannerHelper;
import com.tencent.mobileqq.activity.recent.bannerprocessor.BBannerHelper.IBannerInteract;
import com.tencent.mobileqq.activity.recent.bannerprocessor.BBannerHelper.MessageToShowBanner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsLoadDelegate;
import com.tencent.mobileqq.kandian.glue.video.report.VideoR5;
import com.tencent.mobileqq.kandian.glue.video.report.VideoR5.Builder;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class ReadInJoyVideoInteract
  implements BBannerHelper.IBannerInteract
{
  @NonNull
  private final PendingIntent jdField_a_of_type_AndroidAppPendingIntent;
  @Nullable
  private BBannerHelper.MessageToShowBanner jdField_a_of_type_ComTencentMobileqqActivityRecentBannerprocessorBBannerHelper$MessageToShowBanner;
  String jdField_a_of_type_JavaLangString;
  @NonNull
  private final WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  boolean jdField_a_of_type_Boolean;
  String b;
  String c;
  String d;
  
  public ReadInJoyVideoInteract(@NonNull PendingIntent paramPendingIntent, @NonNull QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidAppPendingIntent = paramPendingIntent;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.d = paramString4;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Intent paramIntent, PendingIntent paramPendingIntent, String paramString1, String paramString2)
  {
    int i = paramIntent.getIntExtra("banner_iconIdx", -1);
    if ((paramPendingIntent != null) && (i >= 0) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      String str1 = paramIntent.getStringExtra("banner_readinjoy_puin");
      String str2 = paramIntent.getStringExtra("banner_readinjoy_vid");
      String str3 = paramIntent.getStringExtra("banner_readinjoy_md5");
      paramIntent = new ReadInJoyVideoInteract(paramPendingIntent, paramQQAppInterface, str1, paramIntent.getStringExtra("banner_readinjoy_article_id"), str2, str3, paramIntent.getBooleanExtra("banner_readinjoy_is_weishi_mode", false));
      paramQQAppInterface = BBannerHelper.a(paramQQAppInterface, i, paramString1, paramString2, paramIntent);
      paramIntent.a();
      paramIntent.a(paramQQAppInterface);
      return;
    }
    paramQQAppInterface = new StringBuilder();
    paramQQAppInterface.append("invalid intent extra from ReadinjoyVideo, ");
    paramQQAppInterface.append(paramString1);
    paramQQAppInterface.append(" / ");
    paramQQAppInterface.append(paramString2);
    paramQQAppInterface.append(" / ");
    paramQQAppInterface.append(paramPendingIntent);
    paramQQAppInterface.append(" / ");
    paramQQAppInterface.append(i);
    QLog.e("ReadInjoyVideoInteract", 1, paramQQAppInterface.toString());
  }
  
  private void a(String paramString)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)
    {
      VideoR5.Builder localBuilder = new VideoR5.Builder(this.d, this.jdField_a_of_type_JavaLangString, this.c, this.b);
      localBuilder.j(this.b);
      IPublicAccountReportUtils localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
      AppInterface localAppInterface = (AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      String str2 = this.jdField_a_of_type_JavaLangString;
      String str1;
      if (this.jdField_a_of_type_Boolean) {
        str1 = "1";
      } else {
        str1 = "0";
      }
      localIPublicAccountReportUtils.publicAccountReportClickEvent(localAppInterface, str2, paramString, paramString, 0, 0, str1, "", "", localBuilder.a().a(), false);
    }
  }
  
  public void a()
  {
    a("0X80097F8");
  }
  
  public void a(@Nullable BBannerHelper.MessageToShowBanner paramMessageToShowBanner)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerprocessorBBannerHelper$MessageToShowBanner = paramMessageToShowBanner;
  }
  
  public boolean isNeedAutoCloseWhenAccountChange()
  {
    return true;
  }
  
  public void onClose()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerprocessorBBannerHelper$MessageToShowBanner == null) {
      return;
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localQQAppInterface == null) {
      return;
    }
    BBannerHelper.a(localQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerprocessorBBannerHelper$MessageToShowBanner);
    VideoFeedsLoadDelegate.a(this.jdField_a_of_type_AndroidAppPendingIntent);
    a("0X80097FA");
  }
  
  public void onEnter()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerprocessorBBannerHelper$MessageToShowBanner == null) {
      return;
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localQQAppInterface == null) {
      return;
    }
    try
    {
      this.jdField_a_of_type_AndroidAppPendingIntent.send();
    }
    catch (PendingIntent.CanceledException localCanceledException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("send pending intent fail with ");
      localStringBuilder.append(this.jdField_a_of_type_AndroidAppPendingIntent);
      localStringBuilder.append("\r\n");
      localStringBuilder.append(localCanceledException);
      QLog.e("ReadInjoyVideoInteract", 1, localStringBuilder.toString());
    }
    BBannerHelper.a(localQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerprocessorBBannerHelper$MessageToShowBanner);
    a("0X80097F9");
  }
  
  public void onOverride() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.ReadInJoyVideoInteract
 * JD-Core Version:    0.7.0.1
 */