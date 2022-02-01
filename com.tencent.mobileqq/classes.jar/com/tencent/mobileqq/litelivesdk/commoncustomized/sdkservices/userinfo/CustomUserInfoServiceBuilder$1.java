package com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.userinfo;

import android.content.Context;
import com.tencent.ilivesdk.userinfoservice_interface.UserInfoServiceAdapter;
import com.tencent.ilivesdk.userinfoservice_interface.UserInfoServiceInterface;
import com.tencent.ilivesdk.userinfoservice_interface.UserInfoServiceInterface.OnBatchQueryUserInfosCallback;
import com.tencent.ilivesdk.userinfoservice_interface.UserInfoServiceInterface.OnQueryUserInfoCallback;
import com.tencent.ilivesdk.userinfoservice_interface.model.UserInfo;
import java.util.List;

class CustomUserInfoServiceBuilder$1
  implements UserInfoServiceInterface
{
  CustomUserInfoServiceBuilder$1(CustomUserInfoServiceBuilder paramCustomUserInfoServiceBuilder) {}
  
  public void batchQueryUserInfos(List<Long> paramList, long paramLong, UserInfoServiceInterface.OnBatchQueryUserInfosCallback paramOnBatchQueryUserInfosCallback) {}
  
  public void batchQueryUserInfos(List<Long> paramList, UserInfoServiceInterface.OnBatchQueryUserInfosCallback paramOnBatchQueryUserInfosCallback) {}
  
  public void clearEventOutput() {}
  
  public UserInfo getSelfInfo()
  {
    return null;
  }
  
  public void init(UserInfoServiceAdapter paramUserInfoServiceAdapter) {}
  
  public void onCreate(Context paramContext) {}
  
  public void onDestroy() {}
  
  public void queryUserInfo(long paramLong1, long paramLong2, UserInfoServiceInterface.OnQueryUserInfoCallback paramOnQueryUserInfoCallback) {}
  
  public void queryUserInfo(long paramLong, UserInfoServiceInterface.OnQueryUserInfoCallback paramOnQueryUserInfoCallback) {}
  
  public void setSelfInfo(UserInfo paramUserInfo) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.userinfo.CustomUserInfoServiceBuilder.1
 * JD-Core Version:    0.7.0.1
 */