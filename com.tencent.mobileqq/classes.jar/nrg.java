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

class nrg
  implements nyp
{
  nrg(nre paramnre) {}
  
  public void a(nyl paramnyl)
  {
    if (paramnyl == null) {}
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
                    String str = paramnyl.jdField_c_of_type_JavaLangString;
                    localObject = str;
                    if (str == null) {
                      localObject = "";
                    }
                    oat.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.a.jdField_a_of_type_JavaLangString, "0X8005A28", "0X8005A28", 0, 0, (String)localObject, "", "", "", false);
                    if (paramnyl.a != 3) {
                      break label680;
                    }
                    if (paramnyl.jdField_c_of_type_Int != 7) {
                      break;
                    }
                  } while ((TextUtils.isEmpty(paramnyl.g)) || (TextUtils.isEmpty(paramnyl.f)) || (TextUtils.isEmpty(paramnyl.b)));
                  Object localObject = new Intent((Context)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), QQMapActivity.class);
                  ((Intent)localObject).putExtra("lat", paramnyl.g);
                  ((Intent)localObject).putExtra("lon", paramnyl.f);
                  ((Intent)localObject).putExtra("loc", paramnyl.b);
                  ((BaseActivity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get()).startActivity((Intent)localObject);
                  return;
                  if (paramnyl.jdField_c_of_type_Int != 8) {
                    break;
                  }
                  paramnyl = paramnyl.h;
                } while (TextUtils.isEmpty(paramnyl));
                paramnyl = paramnyl.trim();
              } while (!Pattern.compile("[\\d-]+?").matcher(paramnyl).matches());
              nre.b(this.a, paramnyl);
              return;
            } while (paramnyl.jdField_c_of_type_Int == 13);
            if (paramnyl.jdField_c_of_type_Int == 11)
            {
              paramnyl = new Intent((Context)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), ScannerActivity.class);
              paramnyl.putExtra("from", this.a.jdField_a_of_type_JavaLangRefWeakReference.getClass().getName());
              paramnyl.putExtra("finishAfterSucc", true);
              ((BaseActivity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get()).startActivity(paramnyl);
              return;
            }
          } while (paramnyl.jdField_c_of_type_Int == 16);
          if (paramnyl.jdField_c_of_type_Int == 20)
          {
            nre.a(this.a);
            return;
          }
          if (paramnyl.jdField_c_of_type_Int == 2)
          {
            aarp.b((Activity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), new aarr(this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name, this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.summary), 1, nre.a(this.a));
            return;
          }
          if (paramnyl.jdField_c_of_type_Int == 17)
          {
            aarp.a((BaseActivity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), new aarr(this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name, this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.summary), 1, nre.a(this.a));
            return;
          }
          if (paramnyl.jdField_c_of_type_Int == 19)
          {
            aarp.a((BaseActivity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), new aarr(this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name, this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.summary), 1, nre.a(this.a), 9);
            return;
          }
          if (paramnyl.jdField_c_of_type_Int == 18)
          {
            aarp.a((BaseActivity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), new aarr(this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name, this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.summary), 1, nre.a(this.a), 10);
            return;
          }
        } while (paramnyl.jdField_c_of_type_Int == 21);
        if (paramnyl.jdField_c_of_type_Int == 22)
        {
          paramnyl = paramnyl.jdField_c_of_type_JavaLangString;
          nre.c(this.a, paramnyl);
          return;
        }
      } while (!QLog.isColorLevel());
      QLog.d("AccountDetailGroupListContainer", 2, "unhandled event_id: " + paramnyl.jdField_c_of_type_Int);
      return;
    } while (paramnyl.a != 1);
    paramnyl = paramnyl.jdField_c_of_type_JavaLangString;
    nre.c(this.a, paramnyl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nrg
 * JD-Core Version:    0.7.0.1
 */