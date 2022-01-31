import android.os.Bundle;
import com.tencent.mobileqq.Doraemon.impl.commonModule.UserInfoModule;
import com.tencent.mobileqq.Doraemon.impl.commonModule.UserInfoModule.LoginInfo;
import com.tencent.mobileqq.Doraemon.impl.commonModule.UserLoginLogic;
import com.tencent.mobileqq.Doraemon.util.DoraemonUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.AuthorizeResponse;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

public class rjs
  implements BusinessObserver
{
  public rjs(UserLoginLogic paramUserLoginLogic, String paramString) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject = paramBundle.getString("ssoAccount");
    if (QLog.isColorLevel()) {
      QLog.d(UserLoginLogic.jdField_a_of_type_JavaLangString, 2, "-->doAuthorize-onReceive, ssoAccount: " + (String)localObject + " | uin: " + this.jdField_a_of_type_JavaLangString);
    }
    if (!this.jdField_a_of_type_JavaLangString.equals(localObject)) {
      return;
    }
    paramInt = paramBundle.getInt("code");
    if (paramBoolean)
    {
      localObject = new SdkAuthorize.AuthorizeResponse();
      try
      {
        paramBundle = (SdkAuthorize.AuthorizeResponse)((SdkAuthorize.AuthorizeResponse)localObject).mergeFrom(paramBundle.getByteArray("data"));
        paramInt = paramBundle.ret.get();
        localObject = paramBundle.msg.get();
        if (paramInt != 0)
        {
          DoraemonUtil.a(this.jdField_a_of_type_ComTencentMobileqqDoraemonImplCommonModuleUserLoginLogic.jdField_a_of_type_ComTencentMobileqqDoraemonAPICallback, paramInt, (String)localObject);
          return;
        }
      }
      catch (Exception paramBundle)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d(UserLoginLogic.jdField_a_of_type_JavaLangString, 2, "parse do auth result error: \n" + paramBundle.getMessage());
        }
        DoraemonUtil.a(this.jdField_a_of_type_ComTencentMobileqqDoraemonImplCommonModuleUserLoginLogic.jdField_a_of_type_ComTencentMobileqqDoraemonAPICallback, -2, "parse do auth result error");
        return;
      }
      localObject = new UserInfoModule.LoginInfo();
      ((UserInfoModule.LoginInfo)localObject).jdField_a_of_type_JavaLangString = paramBundle.openid.get().toUpperCase();
      ((UserInfoModule.LoginInfo)localObject).b = paramBundle.access_token.get().toUpperCase();
      this.jdField_a_of_type_ComTencentMobileqqDoraemonImplCommonModuleUserLoginLogic.jdField_a_of_type_ComTencentMobileqqDoraemonImplCommonModuleUserInfoModule.a((UserInfoModule.LoginInfo)localObject);
      DoraemonUtil.a(this.jdField_a_of_type_ComTencentMobileqqDoraemonImplCommonModuleUserLoginLogic.jdField_a_of_type_ComTencentMobileqqDoraemonAPICallback, ((UserInfoModule.LoginInfo)localObject).a());
      return;
    }
    DoraemonUtil.a(this.jdField_a_of_type_ComTencentMobileqqDoraemonImplCommonModuleUserLoginLogic.jdField_a_of_type_ComTencentMobileqqDoraemonAPICallback, paramInt, "do auth error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     rjs
 * JD-Core Version:    0.7.0.1
 */