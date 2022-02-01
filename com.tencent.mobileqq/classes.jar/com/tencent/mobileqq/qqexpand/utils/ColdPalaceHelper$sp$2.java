package com.tencent.mobileqq.qqexpand.utils;

import android.content.SharedPreferences;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.SharedPreUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "invoke"}, k=3, mv={1, 1, 16})
final class ColdPalaceHelper$sp$2
  extends Lambda
  implements Function0<SharedPreferences>
{
  ColdPalaceHelper$sp$2(ColdPalaceHelper paramColdPalaceHelper)
  {
    super(0);
  }
  
  public final SharedPreferences invoke()
  {
    return SharedPreUtils.a(this.this$0.a().getCurrentAccountUin(), "file_extend_cold_palace_");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.utils.ColdPalaceHelper.sp.2
 * JD-Core Version:    0.7.0.1
 */