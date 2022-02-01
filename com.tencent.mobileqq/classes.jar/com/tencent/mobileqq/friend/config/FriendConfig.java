package com.tencent.mobileqq.friend.config;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
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
    if (a()) {}
    for (byte b = 1;; b = 0)
    {
      if (b != paramByte) {
        this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("fl_show_pc_icon", paramByte).apply();
      }
      return;
    }
  }
  
  public final boolean a()
  {
    if (this.jdField_a_of_type_Int == -1) {
      this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("fl_show_pc_icon", 0);
    }
    return this.jdField_a_of_type_Int == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.friend.config.FriendConfig
 * JD-Core Version:    0.7.0.1
 */