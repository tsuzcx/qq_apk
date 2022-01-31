import android.os.Bundle;
import android.os.Message;
import com.tencent.biz.troop.TroopMemberApiService;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class rrx
  extends axvs
{
  rrx(rrw paramrrw) {}
  
  public void handleMessage(Message paramMessage)
  {
    axqf localaxqf = (axqf)paramMessage.obj;
    if ((localaxqf == null) || ((localaxqf.jdField_b_of_type_Int != 24) && (localaxqf.jdField_b_of_type_Int != 32))) {}
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
                  } while ((localaxqf.jdField_b_of_type_Int == 24) && (localaxqf.c != 10));
                  switch (paramMessage.what)
                  {
                  case 1002: 
                  case 1004: 
                  default: 
                    return;
                  case 1001: 
                    paramMessage = (Bundle)this.a.jdField_a_of_type_JavaUtilHashMap.remove(Long.valueOf(localaxqf.jdField_b_of_type_Long));
                  }
                } while ((paramMessage == null) || (paramMessage.getInt("is_showProgress_tips") != 1));
                this.a.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(23, paramMessage);
              } while (!QLog.isColorLevel());
              QLog.d("PAH5Manager", 2, "start" + localaxqf.jdField_b_of_type_Long);
              return;
              paramMessage = (Bundle)this.a.b.remove(Long.valueOf(localaxqf.jdField_b_of_type_Long));
              this.a.a(localaxqf.jdField_b_of_type_Long);
              this.a.b(localaxqf.jdField_b_of_type_Long);
            } while (paramMessage == null);
            if (localaxqf.jdField_b_of_type_Int == 32)
            {
              new rss();
              paramMessage.putLong("uniseq", localaxqf.jdField_b_of_type_Long);
              paramMessage.putString("pic_server_id", rss.a());
            }
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.d("PAH5Manager", 2, "finished" + localaxqf.jdField_b_of_type_Long);
              }
              this.a.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(24, paramMessage);
              return;
              paramMessage.putLong("uniseq", localaxqf.jdField_b_of_type_Long);
              paramMessage.putString("pic_server_id", localaxqf.i);
            }
            paramMessage = (Bundle)this.a.b.remove(Long.valueOf(localaxqf.jdField_b_of_type_Long));
            this.a.a(localaxqf.jdField_b_of_type_Long);
            this.a.b(localaxqf.jdField_b_of_type_Long);
          } while (paramMessage == null);
          if (QLog.isColorLevel()) {
            QLog.d("PAH5Manager", 2, "error" + localaxqf.jdField_b_of_type_Long);
          }
          paramMessage.putLong("uniseq", localaxqf.jdField_b_of_type_Long);
          paramMessage.putString("pic_server_id", "-1");
          this.a.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(24, paramMessage);
          return;
          paramMessage = (Bundle)this.a.jdField_a_of_type_JavaUtilHashMap.remove(Long.valueOf(localaxqf.jdField_b_of_type_Long));
        } while ((paramMessage == null) || (paramMessage.getInt("is_showProgress_tips") != 1));
        this.a.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(25, paramMessage);
        return;
        this.a.b(localaxqf.jdField_b_of_type_Long);
        paramMessage = (Bundle)this.a.b.remove(Long.valueOf(localaxqf.jdField_b_of_type_Long));
      } while (paramMessage == null);
      if (localaxqf.jdField_b_of_type_Int == 32) {
        paramMessage.putString("pic_local_id", new rss().a(null));
      }
      this.a.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(26, paramMessage);
      return;
      this.a.b(localaxqf.jdField_b_of_type_Long);
      paramMessage = (Bundle)this.a.b.remove(Long.valueOf(localaxqf.jdField_b_of_type_Long));
    } while (paramMessage == null);
    paramMessage.putString("pic_local_id", "-1");
    this.a.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(26, paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rrx
 * JD-Core Version:    0.7.0.1
 */