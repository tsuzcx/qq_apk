import android.os.Bundle;
import com.tencent.mobileqq.Doraemon.impl.commonModule.UserInfoModule;
import com.tencent.mobileqq.Doraemon.impl.commonModule.UserInfoModule.LoginInfo;
import com.tencent.mobileqq.Doraemon.impl.commonModule.UserLoginLogic;
import com.tencent.mobileqq.Doraemon.util.DoraemonUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.AuthorizeResponse;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.GetAuthApiListResponse;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

public class rew
  implements BusinessObserver
{
  public rew(UserLoginLogic paramUserLoginLogic, String paramString) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject = paramBundle.getString("ssoAccount");
    if (!this.jdField_a_of_type_JavaLangString.equals(localObject)) {
      return;
    }
    paramInt = paramBundle.getInt("code");
    if (paramBoolean)
    {
      localObject = new SdkAuthorize.GetAuthApiListResponse();
      try
      {
        paramBundle = (SdkAuthorize.GetAuthApiListResponse)((SdkAuthorize.GetAuthApiListResponse)localObject).mergeFrom(paramBundle.getByteArray("data"));
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
          QLog.d(UserLoginLogic.jdField_a_of_type_JavaLangString, 2, "parse auth info error: \n" + paramBundle.getMessage());
        }
        DoraemonUtil.a(this.jdField_a_of_type_ComTencentMobileqqDoraemonImplCommonModuleUserLoginLogic.jdField_a_of_type_ComTencentMobileqqDoraemonAPICallback, -1, "parse auth info error");
        return;
      }
      localObject = (SdkAuthorize.AuthorizeResponse)paramBundle.auth_response.get();
      if ((UserLoginLogic.a(this.jdField_a_of_type_ComTencentMobileqqDoraemonImplCommonModuleUserLoginLogic, paramBundle)) && (localObject != null) && (((SdkAuthorize.AuthorizeResponse)localObject).has()))
      {
        paramBundle = new UserInfoModule.LoginInfo();
        paramBundle.jdField_a_of_type_JavaLangString = ((SdkAuthorize.AuthorizeResponse)localObject).openid.get().toUpperCase();
        paramBundle.b = ((SdkAuthorize.AuthorizeResponse)localObject).access_token.get().toUpperCase();
        this.jdField_a_of_type_ComTencentMobileqqDoraemonImplCommonModuleUserLoginLogic.jdField_a_of_type_ComTencentMobileqqDoraemonImplCommonModuleUserInfoModule.a(paramBundle);
        DoraemonUtil.a(this.jdField_a_of_type_ComTencentMobileqqDoraemonImplCommonModuleUserLoginLogic.jdField_a_of_type_ComTencentMobileqqDoraemonAPICallback, paramBundle.a());
        return;
      }
      UserLoginLogic.a(this.jdField_a_of_type_ComTencentMobileqqDoraemonImplCommonModuleUserLoginLogic);
      return;
    }
    DoraemonUtil.a(this.jdField_a_of_type_ComTencentMobileqqDoraemonImplCommonModuleUserLoginLogic.jdField_a_of_type_ComTencentMobileqqDoraemonAPICallback, paramInt, "get auth info failure");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     rew
 * JD-Core Version:    0.7.0.1
 */