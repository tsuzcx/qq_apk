import android.content.Context;
import android.os.Bundle;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.UnFollowResponse;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.transfile.StructLongMessageDownloadProcessor;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

final class syk
  implements BusinessObserver
{
  syk(alzr paramalzr, String paramString, boolean paramBoolean, Context paramContext, Object paramObject, QQAppInterface paramQQAppInterface) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountUtil", 2, "success:" + String.valueOf(paramBoolean));
    }
    if (!paramBoolean)
    {
      if (this.jdField_a_of_type_Alzr != null) {
        this.jdField_a_of_type_Alzr.onUpdate(102, false, this.jdField_a_of_type_JavaLangString);
      }
      if (this.jdField_a_of_type_Boolean) {
        syb.a(this.jdField_a_of_type_AndroidContentContext, 2131695729);
      }
    }
    label220:
    label374:
    do
    {
      do
      {
        do
        {
          return;
          if (!paramBoolean) {
            break label412;
          }
          for (;;)
          {
            try
            {
              paramBundle = paramBundle.getByteArray("data");
              if (paramBundle == null) {
                break label374;
              }
              mobileqq_mp.UnFollowResponse localUnFollowResponse = new mobileqq_mp.UnFollowResponse();
              localUnFollowResponse.mergeFrom(paramBundle);
              if (((mobileqq_mp.RetInfo)localUnFollowResponse.ret_info.get()).ret_code.get() != 0) {
                break label336;
              }
              if (this.jdField_a_of_type_JavaLangObject == null) {
                break label220;
              }
              paramBundle = (PublicAccountHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(11);
              if (paramBundle != null) {
                paramBundle.a(this.jdField_a_of_type_JavaLangObject);
              }
              if (this.jdField_a_of_type_Alzr == null) {
                break;
              }
              this.jdField_a_of_type_Alzr.onUpdate(102, true, this.jdField_a_of_type_JavaLangString);
              return;
            }
            catch (Exception paramBundle)
            {
              if (this.jdField_a_of_type_Alzr != null) {
                this.jdField_a_of_type_Alzr.onUpdate(102, false, this.jdField_a_of_type_JavaLangString);
              }
            }
            if (!this.jdField_a_of_type_Boolean) {
              break;
            }
            syb.a(this.jdField_a_of_type_AndroidContentContext, 2131695729);
            return;
            paramBundle = (alzl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56);
            paramBundle.b(this.jdField_a_of_type_JavaLangString);
            paramBundle.a(this.jdField_a_of_type_JavaLangString);
            StructLongMessageDownloadProcessor.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString);
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_JavaLangString, 1008);
            suv.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBundle.a());
            ssp.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString);
            paramBundle = (ntw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(88);
            if (paramBundle != null) {
              paramBundle.a(this.jdField_a_of_type_JavaLangString, "unfollow");
            }
          }
          if (this.jdField_a_of_type_Alzr != null) {
            this.jdField_a_of_type_Alzr.onUpdate(102, false, this.jdField_a_of_type_JavaLangString);
          }
        } while (!this.jdField_a_of_type_Boolean);
        syb.a(this.jdField_a_of_type_AndroidContentContext, 2131695729);
        return;
        if (this.jdField_a_of_type_Alzr != null) {
          this.jdField_a_of_type_Alzr.onUpdate(102, false, this.jdField_a_of_type_JavaLangString);
        }
      } while (!this.jdField_a_of_type_Boolean);
      syb.a(this.jdField_a_of_type_AndroidContentContext, 2131695729);
      return;
      if (this.jdField_a_of_type_Alzr != null) {
        this.jdField_a_of_type_Alzr.onUpdate(102, false, this.jdField_a_of_type_JavaLangString);
      }
    } while (!this.jdField_a_of_type_Boolean);
    label336:
    syb.a(this.jdField_a_of_type_AndroidContentContext, 2131695729);
    label412:
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     syk
 * JD-Core Version:    0.7.0.1
 */