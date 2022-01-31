import android.content.Context;
import android.os.Bundle;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.PublicAccountObserver;
import com.tencent.mobileqq.mp.mobileqq_mp.FollowResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

public final class mvd
  implements BusinessObserver
{
  public mvd(PublicAccountObserver paramPublicAccountObserver, String paramString, Context paramContext, AppInterface paramAppInterface) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountUtil", 2, "success:" + String.valueOf(paramBoolean));
    }
    if (!paramBoolean)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver.onUpdate(101, false, this.jdField_a_of_type_JavaLangString);
      }
      PublicAccountUtil.a(this.jdField_a_of_type_AndroidContentContext, 2131430016);
      return;
    }
    try
    {
      paramBundle = paramBundle.getByteArray("data");
      if (paramBundle == null) {
        break label360;
      }
      mobileqq_mp.FollowResponse localFollowResponse = new mobileqq_mp.FollowResponse();
      localFollowResponse.mergeFrom(paramBundle);
      paramInt = ((mobileqq_mp.RetInfo)localFollowResponse.ret_info.get()).ret_code.get();
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountUtil", 2, "followUin2, retCode=" + paramInt + ", uin=" + this.jdField_a_of_type_JavaLangString + ", errInfo=" + ((mobileqq_mp.RetInfo)localFollowResponse.ret_info.get()).err_info.get());
      }
      if (paramInt == 0)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver != null) {
          this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver.onUpdate(101, true, this.jdField_a_of_type_JavaLangString);
        }
        PublicAccountUtil.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString);
        return;
      }
    }
    catch (Exception paramBundle)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver.onUpdate(101, false, this.jdField_a_of_type_JavaLangString);
      }
      PublicAccountUtil.a(this.jdField_a_of_type_AndroidContentContext, 2131430016);
      return;
    }
    if (paramInt == 58)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver.onUpdate(101, false, this.jdField_a_of_type_JavaLangString);
      }
      PublicAccountUtil.a(this.jdField_a_of_type_AndroidContentContext, 2131430024);
      return;
    }
    if (paramInt == 65)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver.onUpdate(101, false, this.jdField_a_of_type_JavaLangString);
      }
      PublicAccountUtil.a(this.jdField_a_of_type_AndroidContentContext, 2131430025);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver.onUpdate(101, false, this.jdField_a_of_type_JavaLangString);
    }
    PublicAccountUtil.a(this.jdField_a_of_type_AndroidContentContext, 2131430016);
    return;
    label360:
    if (this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver.onUpdate(101, false, this.jdField_a_of_type_JavaLangString);
    }
    PublicAccountUtil.a(this.jdField_a_of_type_AndroidContentContext, 2131430016);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mvd
 * JD-Core Version:    0.7.0.1
 */