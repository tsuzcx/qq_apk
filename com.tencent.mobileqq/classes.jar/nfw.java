import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.qrcode.activity.ScannerActivity;
import com.tencent.mobileqq.activity.QQMapActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class nfw
  implements nmz
{
  nfw(nfu paramnfu) {}
  
  public void a(nmv paramnmv)
  {
    if (paramnmv == null) {}
    label680:
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
                    String str = paramnmv.jdField_c_of_type_JavaLangString;
                    localObject = str;
                    if (str == null) {
                      localObject = "";
                    }
                    noo.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.a.jdField_a_of_type_JavaLangString, "0X8005A28", "0X8005A28", 0, 0, (String)localObject, "", "", "", false);
                    if (paramnmv.a != 3) {
                      break label680;
                    }
                    if (paramnmv.jdField_c_of_type_Int != 7) {
                      break;
                    }
                  } while ((TextUtils.isEmpty(paramnmv.g)) || (TextUtils.isEmpty(paramnmv.f)) || (TextUtils.isEmpty(paramnmv.b)));
                  Object localObject = new Intent((Context)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), QQMapActivity.class);
                  ((Intent)localObject).putExtra("lat", paramnmv.g);
                  ((Intent)localObject).putExtra("lon", paramnmv.f);
                  ((Intent)localObject).putExtra("loc", paramnmv.b);
                  ((BaseActivity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get()).startActivity((Intent)localObject);
                  return;
                  if (paramnmv.jdField_c_of_type_Int != 8) {
                    break;
                  }
                  paramnmv = paramnmv.h;
                } while (TextUtils.isEmpty(paramnmv));
                paramnmv = paramnmv.trim();
              } while (!Pattern.compile("[\\d-]+?").matcher(paramnmv).matches());
              nfu.b(this.a, paramnmv);
              return;
            } while (paramnmv.jdField_c_of_type_Int == 13);
            if (paramnmv.jdField_c_of_type_Int == 11)
            {
              paramnmv = new Intent((Context)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), ScannerActivity.class);
              paramnmv.putExtra("from", this.a.jdField_a_of_type_JavaLangRefWeakReference.getClass().getName());
              paramnmv.putExtra("finishAfterSucc", true);
              ((BaseActivity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get()).startActivity(paramnmv);
              return;
            }
          } while (paramnmv.jdField_c_of_type_Int == 16);
          if (paramnmv.jdField_c_of_type_Int == 20)
          {
            nfu.a(this.a);
            return;
          }
          if (paramnmv.jdField_c_of_type_Int == 2)
          {
            xbl.b((Activity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), new xbn(this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name, this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.summary), 1, nfu.a(this.a));
            return;
          }
          if (paramnmv.jdField_c_of_type_Int == 17)
          {
            xbl.a((BaseActivity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), new xbn(this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name, this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.summary), 1, nfu.a(this.a));
            return;
          }
          if (paramnmv.jdField_c_of_type_Int == 19)
          {
            xbl.a((BaseActivity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), new xbn(this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name, this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.summary), 1, nfu.a(this.a), 9);
            return;
          }
          if (paramnmv.jdField_c_of_type_Int == 18)
          {
            xbl.a((BaseActivity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), new xbn(this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name, this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.summary), 1, nfu.a(this.a), 10);
            return;
          }
        } while (paramnmv.jdField_c_of_type_Int == 21);
        if (paramnmv.jdField_c_of_type_Int == 22)
        {
          paramnmv = paramnmv.jdField_c_of_type_JavaLangString;
          nfu.c(this.a, paramnmv);
          return;
        }
      } while (!QLog.isColorLevel());
      QLog.d("AccountDetailGroupListContainer", 2, "unhandled event_id: " + paramnmv.jdField_c_of_type_Int);
      return;
    } while (paramnmv.a != 1);
    paramnmv = paramnmv.jdField_c_of_type_JavaLangString;
    nfu.c(this.a, paramnmv);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nfw
 * JD-Core Version:    0.7.0.1
 */