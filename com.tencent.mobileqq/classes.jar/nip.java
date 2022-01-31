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

class nip
  implements nps
{
  nip(nin paramnin) {}
  
  public void a(npo paramnpo)
  {
    if (paramnpo == null) {}
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
                    String str = paramnpo.jdField_c_of_type_JavaLangString;
                    localObject = str;
                    if (str == null) {
                      localObject = "";
                    }
                    nrt.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.a.jdField_a_of_type_JavaLangString, "0X8005A28", "0X8005A28", 0, 0, (String)localObject, "", "", "", false);
                    if (paramnpo.a != 3) {
                      break label680;
                    }
                    if (paramnpo.jdField_c_of_type_Int != 7) {
                      break;
                    }
                  } while ((TextUtils.isEmpty(paramnpo.g)) || (TextUtils.isEmpty(paramnpo.f)) || (TextUtils.isEmpty(paramnpo.b)));
                  Object localObject = new Intent((Context)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), QQMapActivity.class);
                  ((Intent)localObject).putExtra("lat", paramnpo.g);
                  ((Intent)localObject).putExtra("lon", paramnpo.f);
                  ((Intent)localObject).putExtra("loc", paramnpo.b);
                  ((BaseActivity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get()).startActivity((Intent)localObject);
                  return;
                  if (paramnpo.jdField_c_of_type_Int != 8) {
                    break;
                  }
                  paramnpo = paramnpo.h;
                } while (TextUtils.isEmpty(paramnpo));
                paramnpo = paramnpo.trim();
              } while (!Pattern.compile("[\\d-]+?").matcher(paramnpo).matches());
              nin.b(this.a, paramnpo);
              return;
            } while (paramnpo.jdField_c_of_type_Int == 13);
            if (paramnpo.jdField_c_of_type_Int == 11)
            {
              paramnpo = new Intent((Context)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), ScannerActivity.class);
              paramnpo.putExtra("from", this.a.jdField_a_of_type_JavaLangRefWeakReference.getClass().getName());
              paramnpo.putExtra("finishAfterSucc", true);
              ((BaseActivity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get()).startActivity(paramnpo);
              return;
            }
          } while (paramnpo.jdField_c_of_type_Int == 16);
          if (paramnpo.jdField_c_of_type_Int == 20)
          {
            nin.a(this.a);
            return;
          }
          if (paramnpo.jdField_c_of_type_Int == 2)
          {
            yqb.b((Activity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), new yqd(this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name, this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.summary), 1, nin.a(this.a));
            return;
          }
          if (paramnpo.jdField_c_of_type_Int == 17)
          {
            yqb.a((BaseActivity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), new yqd(this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name, this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.summary), 1, nin.a(this.a));
            return;
          }
          if (paramnpo.jdField_c_of_type_Int == 19)
          {
            yqb.a((BaseActivity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), new yqd(this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name, this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.summary), 1, nin.a(this.a), 9);
            return;
          }
          if (paramnpo.jdField_c_of_type_Int == 18)
          {
            yqb.a((BaseActivity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), new yqd(this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name, this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.summary), 1, nin.a(this.a), 10);
            return;
          }
        } while (paramnpo.jdField_c_of_type_Int == 21);
        if (paramnpo.jdField_c_of_type_Int == 22)
        {
          paramnpo = paramnpo.jdField_c_of_type_JavaLangString;
          nin.c(this.a, paramnpo);
          return;
        }
      } while (!QLog.isColorLevel());
      QLog.d("AccountDetailGroupListContainer", 2, "unhandled event_id: " + paramnpo.jdField_c_of_type_Int);
      return;
    } while (paramnpo.a != 1);
    paramnpo = paramnpo.jdField_c_of_type_JavaLangString;
    nin.c(this.a, paramnpo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     nip
 * JD-Core Version:    0.7.0.1
 */