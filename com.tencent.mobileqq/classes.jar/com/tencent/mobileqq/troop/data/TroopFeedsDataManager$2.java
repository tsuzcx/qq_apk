package com.tencent.mobileqq.troop.data;

import android.os.Bundle;
import bbnl;
import bcgn;
import bclo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;

public class TroopFeedsDataManager$2
  implements Runnable
{
  public TroopFeedsDataManager$2(bbnl parambbnl, List paramList, int paramInt) {}
  
  public void run()
  {
    Object localObject2 = (TicketManager)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2);
    Object localObject1 = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    String str = ((TicketManager)localObject2).getSkey(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    localObject2 = new Bundle();
    ((Bundle)localObject2).putString("qid", "" + this.this$0.jdField_a_of_type_JavaLangLong);
    ((Bundle)localObject2).putString("fnum", "1");
    ((Bundle)localObject2).putString("bkn", "" + bclo.b(str));
    ((Bundle)localObject2).putString("fids", this.this$0.a(this.jdField_a_of_type_JavaUtilList));
    ((Bundle)localObject2).putString("ver", "8.3.3");
    ((Bundle)localObject2).putString("src", "1");
    ((Bundle)localObject2).putString("platform", "android");
    ((Bundle)localObject2).putString("Cookie", "uin=o" + (String)localObject1 + ";skey=" + str);
    localObject1 = new HashMap();
    ((HashMap)localObject1).put("BUNDLE", localObject2);
    this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication();
    ((HashMap)localObject1).put("CONTEXT", MobileQQ.getContext());
    new bcgn("https://web.qun.qq.com/cgi-bin/notice/get_data_new", "GET", this.this$0.jdField_a_of_type_Bcgo, this.jdField_a_of_type_Int, null, true).execute(new HashMap[] { localObject1 });
    if (QLog.isColorLevel()) {
      QLog.d("TroopFeedsDataManager", 2, "get feed from server start: " + System.currentTimeMillis());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopFeedsDataManager.2
 * JD-Core Version:    0.7.0.1
 */