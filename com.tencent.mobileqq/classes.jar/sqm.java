import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.troop.TroopMemberApiService;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.BDHCommonUploadProcessor;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.TransferRequest;
import java.util.HashMap;
import mqq.manager.Manager;

public class sqm
  implements Manager
{
  public static int a;
  public static int b;
  TroopMemberApiService jdField_a_of_type_ComTencentBizTroopTroopMemberApiService;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  HashMap<Long, Bundle> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private boolean jdField_a_of_type_Boolean = true;
  HashMap<Long, Bundle> b;
  
  static
  {
    jdField_b_of_type_Int = 1;
  }
  
  public sqm(QQAppInterface paramQQAppInterface)
  {
    this.jdField_b_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private void a(int paramInt) {}
  
  public void a(TroopMemberApiService paramTroopMemberApiService)
  {
    if (this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService == null) {
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService = paramTroopMemberApiService;
    }
  }
  
  public void a(String paramString, Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    if ((TextUtils.isEmpty(paramString)) || (!zeb.b(paramString))) {}
    for (;;)
    {
      sqn localsqn = new sqn(this);
      TransferRequest localTransferRequest = new TransferRequest();
      localTransferRequest.mUpCallBack = new sqo(this);
      TransFileController localTransFileController = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController();
      localsqn.addFilter(new Class[] { BDHCommonUploadProcessor.class });
      localTransFileController.addHandle(localsqn);
      localTransferRequest.mLocalPath = paramString;
      localTransferRequest.mIsUp = true;
      localTransferRequest.mFileType = 24;
      localTransferRequest.mCommandId = 54;
      localTransferRequest.mSelfUin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin();
      localTransferRequest.mPeerUin = "0";
      localTransferRequest.mUniseq = (System.currentTimeMillis() + (Math.random() * 10000.0D));
      localTransFileController.transferAsync(localTransferRequest);
      this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(localTransferRequest.mUniseq), paramBundle);
      this.jdField_b_of_type_JavaUtilHashMap.put(Long.valueOf(localTransferRequest.mUniseq), paramBundle);
      return;
      a(jdField_a_of_type_Int);
    }
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService != null) {
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sqm
 * JD-Core Version:    0.7.0.1
 */