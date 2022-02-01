import android.os.Bundle;
import com.tencent.biz.pubaccount.AccountDetail.model.AccountDetailBaseInfoModel.1.1;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.SetFunctionFlagResponse;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;
import mqq.os.MqqHandler;

public final class oax
  implements BusinessObserver
{
  oax(QQAppInterface paramQQAppInterface, oji paramoji, int paramInt, String paramString) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountDetailBaseInfoModel", 2, "success:" + String.valueOf(paramBoolean));
    }
    PublicAccountHandler localPublicAccountHandler = (PublicAccountHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.HANDLER_PUBLIC_ACCOUNT);
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        paramBundle = paramBundle.getByteArray("data");
        if (paramBundle != null)
        {
          Object localObject = new mobileqq_mp.SetFunctionFlagResponse();
          ((mobileqq_mp.SetFunctionFlagResponse)localObject).mergeFrom(paramBundle);
          if (((mobileqq_mp.RetInfo)((mobileqq_mp.SetFunctionFlagResponse)localObject).ret_info.get()).ret_code.get() == 0)
          {
            ((mobileqq_mp.RetInfo)((mobileqq_mp.SetFunctionFlagResponse)localObject).ret_info.get()).ret_code.get();
            if (QLog.isColorLevel()) {
              QLog.d("AccountDetailBaseInfoModel", 2, "sendSetFunctionFlagRequest success");
            }
            this.jdField_a_of_type_Oji.d = this.jdField_a_of_type_Int;
            paramBundle = null;
            localObject = (aoan)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER);
            if (localObject != null) {
              paramBundle = ((aoan)localObject).a(this.jdField_a_of_type_JavaLangString);
            }
            if (paramBundle != null)
            {
              if (this.jdField_a_of_type_Oji.e == 6)
              {
                if (this.jdField_a_of_type_Int == 1) {
                  paramBundle.mShowMsgFlag = this.jdField_a_of_type_Int;
                }
                ThreadManager.getSubThreadHandler().postDelayed(new AccountDetailBaseInfoModel.1.1(this, paramBundle), 10L);
                localPublicAccountHandler.notifyUI(109, true, this.jdField_a_of_type_Oji);
                return;
              }
              if (this.jdField_a_of_type_Oji.e != 3) {
                continue;
              }
              paramBundle.isSyncLbs = true;
              if (this.jdField_a_of_type_Oji.d != 1) {
                break label317;
              }
              paramBoolean = true;
              paramBundle.isAgreeSyncLbs = paramBoolean;
              continue;
            }
          }
          else
          {
            localPublicAccountHandler.notifyUI(109, false, this.jdField_a_of_type_Oji);
          }
        }
        else
        {
          localPublicAccountHandler.notifyUI(109, false, this.jdField_a_of_type_Oji);
          return;
          localPublicAccountHandler.notifyUI(109, false, this.jdField_a_of_type_Oji);
        }
        return;
      }
      catch (Exception paramBundle)
      {
        return;
      }
      label317:
      paramBoolean = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oax
 * JD-Core Version:    0.7.0.1
 */