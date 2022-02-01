package com.tencent.mobileqq.config.business.avatar;

import android.text.TextUtils;
import com.tencent.mobileqq.config.IQStorageSafable;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/config/business/avatar/DynamicAvatarConfBean$DynamicAvatarConfig;", "Lcom/tencent/mobileqq/config/IQStorageSafable;", "", "()V", "isSupportDynamicAvatar", "", "()Z", "setSupportDynamicAvatar", "(Z)V", "onParse", "", "fileOrRes", "toString", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class DynamicAvatarConfBean$DynamicAvatarConfig
  implements IQStorageSafable<String>
{
  public static final DynamicAvatarConfBean.DynamicAvatarConfig.Companion a;
  private boolean a;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqConfigBusinessAvatarDynamicAvatarConfBean$DynamicAvatarConfig$Companion = new DynamicAvatarConfBean.DynamicAvatarConfig.Companion(null);
  }
  
  public DynamicAvatarConfBean$DynamicAvatarConfig()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(@Nullable String paramString)
  {
    if (TextUtils.isEmpty((CharSequence)paramString))
    {
      QLog.e("DynamicAvatarConfBean", 1, "dynamic avatar config content is empty");
      return;
    }
    try
    {
      this.jdField_a_of_type_Boolean = new JSONObject(paramString).optBoolean("is_support_dynamic_avatar", true);
      QLog.i("DynamicAvatarConfBean", 2, "dynamic avatar config parse ok, isSupportDynamicAvatar is " + this.jdField_a_of_type_Boolean);
      return;
    }
    catch (JSONException paramString)
    {
      QLog.e("DynamicAvatarConfBean", 1, "dynamic avatar config parse exception", (Throwable)paramString);
    }
  }
  
  public final boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  @NotNull
  public String toString()
  {
    return "isSupportDynamicAvatar is " + this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.avatar.DynamicAvatarConfBean.DynamicAvatarConfig
 * JD-Core Version:    0.7.0.1
 */