package com.tencent.mobileqq.extendfriend.utils;

import android.content.SharedPreferences;
import arom;
import bfyz;
import com.tencent.mobileqq.app.QQAppInterface;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "invoke"}, k=3, mv={1, 1, 16})
public final class ColdPalaceHelper$sp$2
  extends Lambda
  implements Function0<SharedPreferences>
{
  public ColdPalaceHelper$sp$2(arom paramarom)
  {
    super(0);
  }
  
  public final SharedPreferences invoke()
  {
    return bfyz.a(this.this$0.a().getCurrentAccountUin(), "file_extend_cold_palace_");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.utils.ColdPalaceHelper.sp.2
 * JD-Core Version:    0.7.0.1
 */