import android.os.Bundle;
import android.os.Message;
import com.tencent.biz.pubaccount.util.PAH5Manager;
import com.tencent.biz.pubaccount.util.PublicAccountH5AbilityForPtt;
import com.tencent.biz.troop.TroopMemberApiService;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class mth
  extends TransProcessorHandler
{
  public mth(PAH5Manager paramPAH5Manager) {}
  
  public void handleMessage(Message paramMessage)
  {
    FileMsg localFileMsg = (FileMsg)paramMessage.obj;
    if ((localFileMsg == null) || ((localFileMsg.jdField_b_of_type_Int != 24) && (localFileMsg.jdField_b_of_type_Int != 32))) {}
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
                do
                {
                  do
                  {
                    return;
                  } while ((localFileMsg.jdField_b_of_type_Int == 24) && (localFileMsg.c != 10));
                  switch (paramMessage.what)
                  {
                  case 1002: 
                  case 1004: 
                  default: 
                    return;
                  case 1001: 
                    paramMessage = (Bundle)this.a.jdField_a_of_type_JavaUtilHashMap.remove(Long.valueOf(localFileMsg.jdField_b_of_type_Long));
                  }
                } while ((paramMessage == null) || (paramMessage.getInt("is_showProgress_tips") != 1));
                this.a.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(23, paramMessage);
              } while (!QLog.isColorLevel());
              QLog.d("PAH5Manager", 2, "start" + localFileMsg.jdField_b_of_type_Long);
              return;
              paramMessage = (Bundle)this.a.b.remove(Long.valueOf(localFileMsg.jdField_b_of_type_Long));
              this.a.a(localFileMsg.jdField_b_of_type_Long);
              this.a.b(localFileMsg.jdField_b_of_type_Long);
            } while (paramMessage == null);
            if (localFileMsg.jdField_b_of_type_Int == 32)
            {
              new PublicAccountH5AbilityForPtt();
              paramMessage.putLong("uniseq", localFileMsg.jdField_b_of_type_Long);
              paramMessage.putString("pic_server_id", PublicAccountH5AbilityForPtt.a());
            }
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.d("PAH5Manager", 2, "finished" + localFileMsg.jdField_b_of_type_Long);
              }
              this.a.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(24, paramMessage);
              return;
              paramMessage.putLong("uniseq", localFileMsg.jdField_b_of_type_Long);
              paramMessage.putString("pic_server_id", localFileMsg.i);
            }
            paramMessage = (Bundle)this.a.b.remove(Long.valueOf(localFileMsg.jdField_b_of_type_Long));
            this.a.a(localFileMsg.jdField_b_of_type_Long);
            this.a.b(localFileMsg.jdField_b_of_type_Long);
          } while (paramMessage == null);
          if (QLog.isColorLevel()) {
            QLog.d("PAH5Manager", 2, "error" + localFileMsg.jdField_b_of_type_Long);
          }
          paramMessage.putLong("uniseq", localFileMsg.jdField_b_of_type_Long);
          paramMessage.putString("pic_server_id", "-1");
          this.a.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(24, paramMessage);
          return;
          paramMessage = (Bundle)this.a.jdField_a_of_type_JavaUtilHashMap.remove(Long.valueOf(localFileMsg.jdField_b_of_type_Long));
        } while ((paramMessage == null) || (paramMessage.getInt("is_showProgress_tips") != 1));
        this.a.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(25, paramMessage);
        return;
        this.a.b(localFileMsg.jdField_b_of_type_Long);
        paramMessage = (Bundle)this.a.b.remove(Long.valueOf(localFileMsg.jdField_b_of_type_Long));
      } while (paramMessage == null);
      if (localFileMsg.jdField_b_of_type_Int == 32) {
        paramMessage.putString("pic_local_id", new PublicAccountH5AbilityForPtt().a(null));
      }
      this.a.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(26, paramMessage);
      return;
      this.a.b(localFileMsg.jdField_b_of_type_Long);
      paramMessage = (Bundle)this.a.b.remove(Long.valueOf(localFileMsg.jdField_b_of_type_Long));
    } while (paramMessage == null);
    paramMessage.putString("pic_local_id", "-1");
    this.a.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(26, paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mth
 * JD-Core Version:    0.7.0.1
 */