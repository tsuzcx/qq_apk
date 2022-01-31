import android.os.Bundle;
import android.os.Message;
import com.tencent.biz.troop.TroopMemberApiService;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class sem
  extends aywb
{
  sem(sel paramsel) {}
  
  public void handleMessage(Message paramMessage)
  {
    ayqo localayqo = (ayqo)paramMessage.obj;
    if ((localayqo == null) || ((localayqo.jdField_b_of_type_Int != 24) && (localayqo.jdField_b_of_type_Int != 32))) {}
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
                  } while ((localayqo.jdField_b_of_type_Int == 24) && (localayqo.c != 10));
                  switch (paramMessage.what)
                  {
                  case 1002: 
                  case 1004: 
                  default: 
                    return;
                  case 1001: 
                    paramMessage = (Bundle)this.a.jdField_a_of_type_JavaUtilHashMap.remove(Long.valueOf(localayqo.jdField_b_of_type_Long));
                  }
                } while ((paramMessage == null) || (paramMessage.getInt("is_showProgress_tips") != 1));
                this.a.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(23, paramMessage);
              } while (!QLog.isColorLevel());
              QLog.d("PAH5Manager", 2, "start" + localayqo.jdField_b_of_type_Long);
              return;
              paramMessage = (Bundle)this.a.b.remove(Long.valueOf(localayqo.jdField_b_of_type_Long));
              this.a.a(localayqo.jdField_b_of_type_Long);
              this.a.b(localayqo.jdField_b_of_type_Long);
            } while (paramMessage == null);
            if (localayqo.jdField_b_of_type_Int == 32)
            {
              new sfh();
              paramMessage.putLong("uniseq", localayqo.jdField_b_of_type_Long);
              paramMessage.putString("pic_server_id", sfh.a());
            }
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.d("PAH5Manager", 2, "finished" + localayqo.jdField_b_of_type_Long);
              }
              this.a.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(24, paramMessage);
              return;
              paramMessage.putLong("uniseq", localayqo.jdField_b_of_type_Long);
              paramMessage.putString("pic_server_id", localayqo.i);
            }
            paramMessage = (Bundle)this.a.b.remove(Long.valueOf(localayqo.jdField_b_of_type_Long));
            this.a.a(localayqo.jdField_b_of_type_Long);
            this.a.b(localayqo.jdField_b_of_type_Long);
          } while (paramMessage == null);
          if (QLog.isColorLevel()) {
            QLog.d("PAH5Manager", 2, "error" + localayqo.jdField_b_of_type_Long);
          }
          paramMessage.putLong("uniseq", localayqo.jdField_b_of_type_Long);
          paramMessage.putString("pic_server_id", "-1");
          this.a.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(24, paramMessage);
          return;
          paramMessage = (Bundle)this.a.jdField_a_of_type_JavaUtilHashMap.remove(Long.valueOf(localayqo.jdField_b_of_type_Long));
        } while ((paramMessage == null) || (paramMessage.getInt("is_showProgress_tips") != 1));
        this.a.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(25, paramMessage);
        return;
        this.a.b(localayqo.jdField_b_of_type_Long);
        paramMessage = (Bundle)this.a.b.remove(Long.valueOf(localayqo.jdField_b_of_type_Long));
      } while (paramMessage == null);
      if (localayqo.jdField_b_of_type_Int == 32) {
        paramMessage.putString("pic_local_id", new sfh().a(null));
      }
      this.a.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(26, paramMessage);
      return;
      this.a.b(localayqo.jdField_b_of_type_Long);
      paramMessage = (Bundle)this.a.b.remove(Long.valueOf(localayqo.jdField_b_of_type_Long));
    } while (paramMessage == null);
    paramMessage.putString("pic_local_id", "-1");
    this.a.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(26, paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     sem
 * JD-Core Version:    0.7.0.1
 */