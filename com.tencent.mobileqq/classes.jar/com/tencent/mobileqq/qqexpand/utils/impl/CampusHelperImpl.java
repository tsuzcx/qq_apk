package com.tencent.mobileqq.qqexpand.utils.impl;

import android.app.Activity;
import com.tencent.mobileqq.qqexpand.utils.CampusHelper;
import com.tencent.mobileqq.qqexpand.utils.ICampusHelper;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/qqexpand/utils/impl/CampusHelperImpl;", "Lcom/tencent/mobileqq/qqexpand/utils/ICampusHelper;", "()V", "jumpToSchoolCertificateWebPage", "", "activity", "Landroid/app/Activity;", "idx", "", "schoolName", "", "schoolID", "jumpToSchoolFillInWebPage", "serverSuggestSchoolName", "qqexpand_impl_release"}, k=1, mv={1, 1, 16})
public final class CampusHelperImpl
  implements ICampusHelper
{
  public void jumpToSchoolCertificateWebPage(@Nullable Activity paramActivity, int paramInt, @Nullable String paramString1, @Nullable String paramString2)
  {
    CampusHelper.a(paramActivity, paramInt, paramString1, paramString2);
  }
  
  public void jumpToSchoolFillInWebPage(@Nullable Activity paramActivity, @Nullable String paramString)
  {
    CampusHelper.a(paramActivity, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.utils.impl.CampusHelperImpl
 * JD-Core Version:    0.7.0.1
 */