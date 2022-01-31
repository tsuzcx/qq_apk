import android.content.Context;
import android.os.Bundle;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.PublicAccountObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.UnFollowResponse;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.transfile.StructLongMessageDownloadProcessor;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

public final class mwj
  implements BusinessObserver
{
  public mwj(PublicAccountObserver paramPublicAccountObserver, String paramString, boolean paramBoolean, Context paramContext, Object paramObject, QQAppInterface paramQQAppInterface) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountUtil", 2, "success:" + String.valueOf(paramBoolean));
    }
    if (!paramBoolean)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver.onUpdate(102, false, this.jdField_a_of_type_JavaLangString);
      }
      if (this.jdField_a_of_type_Boolean) {
        PublicAccountUtil.a(this.jdField_a_of_type_AndroidContentContext, 2131430033);
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
              if (this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver == null) {
                break;
              }
              this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver.onUpdate(102, true, this.jdField_a_of_type_JavaLangString);
              return;
            }
            catch (Exception paramBundle)
            {
              if (this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver != null) {
                this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver.onUpdate(102, false, this.jdField_a_of_type_JavaLangString);
              }
            }
            if (!this.jdField_a_of_type_Boolean) {
              break;
            }
            PublicAccountUtil.a(this.jdField_a_of_type_AndroidContentContext, 2131430033);
            return;
            paramBundle = (PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(55);
            paramBundle.b(this.jdField_a_of_type_JavaLangString);
            paramBundle.a(this.jdField_a_of_type_JavaLangString);
            StructLongMessageDownloadProcessor.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString);
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_JavaLangString, 1008);
            TroopBarAssistantManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBundle.a());
            ServiceAccountFolderManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString);
            paramBundle = (EcShopAssistantManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(87);
            if (paramBundle != null) {
              paramBundle.a(this.jdField_a_of_type_JavaLangString, "unfollow");
            }
          }
          if (this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver != null) {
            this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver.onUpdate(102, false, this.jdField_a_of_type_JavaLangString);
          }
        } while (!this.jdField_a_of_type_Boolean);
        PublicAccountUtil.a(this.jdField_a_of_type_AndroidContentContext, 2131430033);
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver != null) {
          this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver.onUpdate(102, false, this.jdField_a_of_type_JavaLangString);
        }
      } while (!this.jdField_a_of_type_Boolean);
      PublicAccountUtil.a(this.jdField_a_of_type_AndroidContentContext, 2131430033);
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver.onUpdate(102, false, this.jdField_a_of_type_JavaLangString);
      }
    } while (!this.jdField_a_of_type_Boolean);
    label336:
    PublicAccountUtil.a(this.jdField_a_of_type_AndroidContentContext, 2131430033);
    label412:
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mwj
 * JD-Core Version:    0.7.0.1
 */