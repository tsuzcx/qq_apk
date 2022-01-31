import android.os.Bundle;
import com.tencent.biz.pubaccount.AccountDetail.model.AccountDetailBaseInfoModel.1.1;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.SetFunctionFlagResponse;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;
import mqq.os.MqqHandler;

public final class nff
  implements BusinessObserver
{
  nff(QQAppInterface paramQQAppInterface, nmv paramnmv, int paramInt, String paramString) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountDetailBaseInfoModel", 2, "success:" + String.valueOf(paramBoolean));
    }
    PublicAccountHandler localPublicAccountHandler = (PublicAccountHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(11);
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
            this.jdField_a_of_type_Nmv.d = this.jdField_a_of_type_Int;
            paramBundle = null;
            localObject = (akdi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56);
            if (localObject != null) {
              paramBundle = ((akdi)localObject).a(this.jdField_a_of_type_JavaLangString);
            }
            if (paramBundle != null)
            {
              if (this.jdField_a_of_type_Nmv.e == 6)
              {
                if (this.jdField_a_of_type_Int == 1) {
                  paramBundle.mShowMsgFlag = this.jdField_a_of_type_Int;
                }
                ThreadManager.getSubThreadHandler().postDelayed(new AccountDetailBaseInfoModel.1.1(this, paramBundle), 10L);
                localPublicAccountHandler.notifyUI(109, true, this.jdField_a_of_type_Nmv);
                return;
              }
              if (this.jdField_a_of_type_Nmv.e != 3) {
                continue;
              }
              paramBundle.isSyncLbs = true;
              if (this.jdField_a_of_type_Nmv.d != 1) {
                break label315;
              }
              paramBoolean = true;
              paramBundle.isAgreeSyncLbs = paramBoolean;
              continue;
            }
          }
          else
          {
            localPublicAccountHandler.notifyUI(109, false, this.jdField_a_of_type_Nmv);
          }
        }
        else
        {
          localPublicAccountHandler.notifyUI(109, false, this.jdField_a_of_type_Nmv);
          return;
          localPublicAccountHandler.notifyUI(109, false, this.jdField_a_of_type_Nmv);
        }
        return;
      }
      catch (Exception paramBundle)
      {
        return;
      }
      label315:
      paramBoolean = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nff
 * JD-Core Version:    0.7.0.1
 */