package com.tencent.mobileqq.troop.data;

import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;

class TroopFeedsDataManager$2
  implements Runnable
{
  TroopFeedsDataManager$2(TroopFeedsDataManager paramTroopFeedsDataManager, List paramList, int paramInt) {}
  
  public void run()
  {
    Object localObject2 = (TicketManager)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2);
    Object localObject1 = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    String str = ((TicketManager)localObject2).getSkey(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    localObject2 = new Bundle();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(this.this$0.jdField_a_of_type_JavaLangLong);
    ((Bundle)localObject2).putString("qid", localStringBuilder.toString());
    ((Bundle)localObject2).putString("fnum", "1");
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(TroopUtils.a(str));
    ((Bundle)localObject2).putString("bkn", localStringBuilder.toString());
    ((Bundle)localObject2).putString("fids", this.this$0.a(this.jdField_a_of_type_JavaUtilList));
    ((Bundle)localObject2).putString("ver", "8.7.0");
    ((Bundle)localObject2).putString("src", "1");
    ((Bundle)localObject2).putString("platform", "android");
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("uin=o");
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append(";skey=");
    localStringBuilder.append(str);
    ((Bundle)localObject2).putString("Cookie", localStringBuilder.toString());
    localObject1 = new HashMap();
    ((HashMap)localObject1).put("BUNDLE", localObject2);
    this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication();
    ((HashMap)localObject1).put("CONTEXT", MobileQQ.getContext());
    new HttpWebCgiAsyncTask("https://web.qun.qq.com/cgi-bin/notice/get_data_new", "GET", this.this$0.jdField_a_of_type_ComTencentMobileqqTroopUtilsHttpWebCgiAsyncTask$Callback, this.jdField_a_of_type_Int, null, true).execute(new HashMap[] { localObject1 });
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("get feed from server start: ");
      ((StringBuilder)localObject1).append(System.currentTimeMillis());
      QLog.d("TroopFeedsDataManager", 2, ((StringBuilder)localObject1).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopFeedsDataManager.2
 * JD-Core Version:    0.7.0.1
 */