import android.content.Context;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.mp.mobileqq_mp.FollowResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

final class syj
  implements BusinessObserver
{
  syj(alzr paramalzr, String paramString, boolean paramBoolean, Context paramContext, AppInterface paramAppInterface, int paramInt) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountUtil", 2, "success:" + String.valueOf(paramBoolean));
    }
    if (!paramBoolean)
    {
      if (this.jdField_a_of_type_Alzr != null) {
        this.jdField_a_of_type_Alzr.onUpdate(101, false, this.jdField_a_of_type_JavaLangString);
      }
      if (this.jdField_a_of_type_Boolean) {
        syb.a(this.jdField_a_of_type_AndroidContentContext, 2131695729);
      }
    }
    label366:
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
                if (!paramBoolean) {
                  break label404;
                }
                try
                {
                  paramBundle = paramBundle.getByteArray("data");
                  if (paramBundle == null) {
                    break label366;
                  }
                  mobileqq_mp.FollowResponse localFollowResponse = new mobileqq_mp.FollowResponse();
                  localFollowResponse.mergeFrom(paramBundle);
                  paramInt = ((mobileqq_mp.RetInfo)localFollowResponse.ret_info.get()).ret_code.get();
                  if (QLog.isColorLevel()) {
                    QLog.d("PublicAccountUtil", 2, "followUin, retCode=" + paramInt);
                  }
                  if (paramInt != 0) {
                    break;
                  }
                  if (this.jdField_a_of_type_Alzr != null) {
                    this.jdField_a_of_type_Alzr.onUpdate(101, true, this.jdField_a_of_type_JavaLangString);
                  }
                  syb.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
                  return;
                }
                catch (Exception paramBundle)
                {
                  if (this.jdField_a_of_type_Alzr != null) {
                    this.jdField_a_of_type_Alzr.onUpdate(101, false, this.jdField_a_of_type_JavaLangString);
                  }
                }
              } while (!this.jdField_a_of_type_Boolean);
              syb.a(this.jdField_a_of_type_AndroidContentContext, 2131695729);
              return;
              if (paramInt != 58) {
                break;
              }
              if (this.jdField_a_of_type_Alzr != null) {
                this.jdField_a_of_type_Alzr.onUpdate(101, false, this.jdField_a_of_type_JavaLangString);
              }
            } while (!this.jdField_a_of_type_Boolean);
            syb.a(this.jdField_a_of_type_AndroidContentContext, 2131695726);
            return;
            if (paramInt != 65) {
              break;
            }
            if (this.jdField_a_of_type_Alzr != null) {
              this.jdField_a_of_type_Alzr.onUpdate(101, false, this.jdField_a_of_type_JavaLangString);
            }
          } while (!this.jdField_a_of_type_Boolean);
          syb.a(this.jdField_a_of_type_AndroidContentContext, 2131695699);
          return;
          if (this.jdField_a_of_type_Alzr != null) {
            this.jdField_a_of_type_Alzr.onUpdate(101, false, this.jdField_a_of_type_JavaLangString);
          }
        } while (!this.jdField_a_of_type_Boolean);
        syb.a(this.jdField_a_of_type_AndroidContentContext, 2131695729);
        return;
        if (this.jdField_a_of_type_Alzr != null) {
          this.jdField_a_of_type_Alzr.onUpdate(101, false, this.jdField_a_of_type_JavaLangString);
        }
      } while (!this.jdField_a_of_type_Boolean);
      syb.a(this.jdField_a_of_type_AndroidContentContext, 2131695729);
      return;
      if (this.jdField_a_of_type_Alzr != null) {
        this.jdField_a_of_type_Alzr.onUpdate(101, false, this.jdField_a_of_type_JavaLangString);
      }
    } while (!this.jdField_a_of_type_Boolean);
    label404:
    syb.a(this.jdField_a_of_type_AndroidContentContext, 2131695729);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     syj
 * JD-Core Version:    0.7.0.1
 */