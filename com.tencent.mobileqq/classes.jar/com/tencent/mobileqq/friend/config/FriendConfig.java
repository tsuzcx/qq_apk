package com.tencent.mobileqq.friend.config;

import android.content.Context;
import android.content.SharedPreferences;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/friend/config/FriendConfig;", "", "app", "Lmqq/app/AppRuntime;", "(Lmqq/app/AppRuntime;)V", "showPCIconFlag", "", "sp", "Landroid/content/SharedPreferences;", "isShowPCIcon", "", "updateShowPCIcon", "", "flag", "", "Companion", "IMCore_release"}, k=1, mv={1, 1, 16})
public final class FriendConfig
{
  public static final FriendConfig.Companion a;
  private int jdField_a_of_type_Int = -1;
  private final SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private final AppRuntime jdField_a_of_type_MqqAppAppRuntime;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqFriendConfigFriendConfig$Companion = new FriendConfig.Companion(null);
  }
  
  public FriendConfig(@NotNull AppRuntime paramAppRuntime)
  {
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    paramAppRuntime = paramAppRuntime.getApplicationContext().getSharedPreferences(paramAppRuntime.getCurrentAccountUin(), 0);
    Intrinsics.checkExpressionValueIsNotNull(paramAppRuntime, "app.applicationContext.g…in, Context.MODE_PRIVATE)");
    this.jdField_a_of_type_AndroidContentSharedPreferences = paramAppRuntime;
  }
  
  public final void a(byte paramByte)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:322)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final boolean a()
  {
    int i = this.jdField_a_of_type_Int;
    boolean bool = false;
    if (i == -1) {
      this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("fl_show_pc_icon", 0);
    }
    if (this.jdField_a_of_type_Int == 1) {
      bool = true;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.friend.config.FriendConfig
 * JD-Core Version:    0.7.0.1
 */