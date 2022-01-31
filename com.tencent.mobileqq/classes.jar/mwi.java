import android.content.Context;
import android.os.Bundle;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.PublicAccountObserver;
import com.tencent.mobileqq.mp.mobileqq_mp.FollowResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

public final class mwi
  implements BusinessObserver
{
  public mwi(PublicAccountObserver paramPublicAccountObserver, String paramString, boolean paramBoolean, Context paramContext, AppInterface paramAppInterface, int paramInt) {}
  
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
      if (this.jdField_a_of_type_Boolean) {
        PublicAccountUtil.a(this.jdField_a_of_type_AndroidContentContext, 2131430033);
      }
    }
    label366:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                if (!paramBoolean) {
                  break label404;
                }
                try
                {
                  paramBundle = paramBundle.getByteArray("data");
                  if (paramBundle == null) {
                    break label366;
                  }
                  mobileqq_mp.FollowResponse localFollowResponse = new mobileqq_mp.FollowResponse();
                  localFollowResponse.mergeFrom(paramBundle);
                  paramInt = ((mobileqq_mp.RetInfo)localFollowResponse.ret_info.get()).ret_code.get();
                  if (QLog.isColorLevel()) {
                    QLog.d("PublicAccountUtil", 2, "followUin, retCode=" + paramInt);
                  }
                  if (paramInt != 0) {
                    break;
                  }
                  if (this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver != null) {
                    this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver.onUpdate(101, true, this.jdField_a_of_type_JavaLangString);
                  }
                  PublicAccountUtil.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
                  return;
                }
                catch (Exception paramBundle)
                {
                  if (this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver != null) {
                    this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver.onUpdate(101, false, this.jdField_a_of_type_JavaLangString);
                  }
                }
              } while (!this.jdField_a_of_type_Boolean);
              PublicAccountUtil.a(this.jdField_a_of_type_AndroidContentContext, 2131430033);
              return;
              if (paramInt != 58) {
                break;
              }
              if (this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver != null) {
                this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver.onUpdate(101, false, this.jdField_a_of_type_JavaLangString);
              }
            } while (!this.jdField_a_of_type_Boolean);
            PublicAccountUtil.a(this.jdField_a_of_type_AndroidContentContext, 2131430041);
            return;
            if (paramInt != 65) {
              break;
            }
            if (this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver != null) {
              this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver.onUpdate(101, false, this.jdField_a_of_type_JavaLangString);
            }
          } while (!this.jdField_a_of_type_Boolean);
          PublicAccountUtil.a(this.jdField_a_of_type_AndroidContentContext, 2131430042);
          return;
          if (this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver != null) {
            this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver.onUpdate(101, false, this.jdField_a_of_type_JavaLangString);
          }
        } while (!this.jdField_a_of_type_Boolean);
        PublicAccountUtil.a(this.jdField_a_of_type_AndroidContentContext, 2131430033);
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver != null) {
          this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver.onUpdate(101, false, this.jdField_a_of_type_JavaLangString);
        }
      } while (!this.jdField_a_of_type_Boolean);
      PublicAccountUtil.a(this.jdField_a_of_type_AndroidContentContext, 2131430033);
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver.onUpdate(101, false, this.jdField_a_of_type_JavaLangString);
      }
    } while (!this.jdField_a_of_type_Boolean);
    label404:
    PublicAccountUtil.a(this.jdField_a_of_type_AndroidContentContext, 2131430033);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mwi
 * JD-Core Version:    0.7.0.1
 */