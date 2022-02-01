package com.tencent.mobileqq.qqexpand.utils;

import android.app.Activity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/qqexpand/utils/ICampusHelper;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "jumpToSchoolCertificateWebPage", "", "activity", "Landroid/app/Activity;", "idx", "", "schoolName", "", "schoolID", "jumpToSchoolFillInWebPage", "serverSuggestSchoolName", "Companion", "qqexpand-api_release"}, k=1, mv={1, 1, 16})
public abstract interface ICampusHelper
  extends QRouteApi
{
  public static final int CERTIFICATE_BY_FRIEND = 1;
  public static final int CERTIFICATE_BY_STUDENTID = 2;
  public static final int CERTIFICATE_UNKNOWN = -1;
  public static final ICampusHelper.Companion Companion = ICampusHelper.Companion.a;
  
  public abstract void jumpToSchoolCertificateWebPage(@Nullable Activity paramActivity, int paramInt, @Nullable String paramString1, @Nullable String paramString2);
  
  public abstract void jumpToSchoolFillInWebPage(@Nullable Activity paramActivity, @Nullable String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.utils.ICampusHelper
 * JD-Core Version:    0.7.0.1
 */