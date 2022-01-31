import android.os.Bundle;
import android.os.Message;
import com.tencent.biz.troop.TroopMemberApiService;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class sep
  extends ayvz
{
  sep(seo paramseo) {}
  
  public void handleMessage(Message paramMessage)
  {
    ayqm localayqm = (ayqm)paramMessage.obj;
    if ((localayqm == null) || ((localayqm.jdField_b_of_type_Int != 24) && (localayqm.jdField_b_of_type_Int != 32))) {}
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
                  } while ((localayqm.jdField_b_of_type_Int == 24) && (localayqm.c != 10));
                  switch (paramMessage.what)
                  {
                  case 1002: 
                  case 1004: 
                  default: 
                    return;
                  case 1001: 
                    paramMessage = (Bundle)this.a.jdField_a_of_type_JavaUtilHashMap.remove(Long.valueOf(localayqm.jdField_b_of_type_Long));
                  }
                } while ((paramMessage == null) || (paramMessage.getInt("is_showProgress_tips") != 1));
                this.a.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(23, paramMessage);
              } while (!QLog.isColorLevel());
              QLog.d("PAH5Manager", 2, "start" + localayqm.jdField_b_of_type_Long);
              return;
              paramMessage = (Bundle)this.a.b.remove(Long.valueOf(localayqm.jdField_b_of_type_Long));
              this.a.a(localayqm.jdField_b_of_type_Long);
              this.a.b(localayqm.jdField_b_of_type_Long);
            } while (paramMessage == null);
            if (localayqm.jdField_b_of_type_Int == 32)
            {
              new sfk();
              paramMessage.putLong("uniseq", localayqm.jdField_b_of_type_Long);
              paramMessage.putString("pic_server_id", sfk.a());
            }
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.d("PAH5Manager", 2, "finished" + localayqm.jdField_b_of_type_Long);
              }
              this.a.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(24, paramMessage);
              return;
              paramMessage.putLong("uniseq", localayqm.jdField_b_of_type_Long);
              paramMessage.putString("pic_server_id", localayqm.i);
            }
            paramMessage = (Bundle)this.a.b.remove(Long.valueOf(localayqm.jdField_b_of_type_Long));
            this.a.a(localayqm.jdField_b_of_type_Long);
            this.a.b(localayqm.jdField_b_of_type_Long);
          } while (paramMessage == null);
          if (QLog.isColorLevel()) {
            QLog.d("PAH5Manager", 2, "error" + localayqm.jdField_b_of_type_Long);
          }
          paramMessage.putLong("uniseq", localayqm.jdField_b_of_type_Long);
          paramMessage.putString("pic_server_id", "-1");
          this.a.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(24, paramMessage);
          return;
          paramMessage = (Bundle)this.a.jdField_a_of_type_JavaUtilHashMap.remove(Long.valueOf(localayqm.jdField_b_of_type_Long));
        } while ((paramMessage == null) || (paramMessage.getInt("is_showProgress_tips") != 1));
        this.a.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(25, paramMessage);
        return;
        this.a.b(localayqm.jdField_b_of_type_Long);
        paramMessage = (Bundle)this.a.b.remove(Long.valueOf(localayqm.jdField_b_of_type_Long));
      } while (paramMessage == null);
      if (localayqm.jdField_b_of_type_Int == 32) {
        paramMessage.putString("pic_local_id", new sfk().a(null));
      }
      this.a.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(26, paramMessage);
      return;
      this.a.b(localayqm.jdField_b_of_type_Long);
      paramMessage = (Bundle)this.a.b.remove(Long.valueOf(localayqm.jdField_b_of_type_Long));
    } while (paramMessage == null);
    paramMessage.putString("pic_local_id", "-1");
    this.a.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(26, paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     sep
 * JD-Core Version:    0.7.0.1
 */