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

class muv
  implements nby
{
  muv(mut parammut) {}
  
  public void a(nbu paramnbu)
  {
    if (paramnbu == null) {}
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
                    String str = paramnbu.jdField_c_of_type_JavaLangString;
                    localObject = str;
                    if (str == null) {
                      localObject = "";
                    }
                    ndn.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.a.jdField_a_of_type_JavaLangString, "0X8005A28", "0X8005A28", 0, 0, (String)localObject, "", "", "", false);
                    if (paramnbu.a != 3) {
                      break label680;
                    }
                    if (paramnbu.jdField_c_of_type_Int != 7) {
                      break;
                    }
                  } while ((TextUtils.isEmpty(paramnbu.g)) || (TextUtils.isEmpty(paramnbu.f)) || (TextUtils.isEmpty(paramnbu.b)));
                  Object localObject = new Intent((Context)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), QQMapActivity.class);
                  ((Intent)localObject).putExtra("lat", paramnbu.g);
                  ((Intent)localObject).putExtra("lon", paramnbu.f);
                  ((Intent)localObject).putExtra("loc", paramnbu.b);
                  ((BaseActivity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get()).startActivity((Intent)localObject);
                  return;
                  if (paramnbu.jdField_c_of_type_Int != 8) {
                    break;
                  }
                  paramnbu = paramnbu.h;
                } while (TextUtils.isEmpty(paramnbu));
                paramnbu = paramnbu.trim();
              } while (!Pattern.compile("[\\d-]+?").matcher(paramnbu).matches());
              mut.b(this.a, paramnbu);
              return;
            } while (paramnbu.jdField_c_of_type_Int == 13);
            if (paramnbu.jdField_c_of_type_Int == 11)
            {
              paramnbu = new Intent((Context)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), ScannerActivity.class);
              paramnbu.putExtra("from", this.a.jdField_a_of_type_JavaLangRefWeakReference.getClass().getName());
              paramnbu.putExtra("finishAfterSucc", true);
              ((BaseActivity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get()).startActivity(paramnbu);
              return;
            }
          } while (paramnbu.jdField_c_of_type_Int == 16);
          if (paramnbu.jdField_c_of_type_Int == 20)
          {
            mut.a(this.a);
            return;
          }
          if (paramnbu.jdField_c_of_type_Int == 2)
          {
            wmi.b((Activity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), new wmk(this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name, this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.summary), 1, mut.a(this.a));
            return;
          }
          if (paramnbu.jdField_c_of_type_Int == 17)
          {
            wmi.a((BaseActivity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), new wmk(this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name, this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.summary), 1, mut.a(this.a));
            return;
          }
          if (paramnbu.jdField_c_of_type_Int == 19)
          {
            wmi.a((BaseActivity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), new wmk(this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name, this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.summary), 1, mut.a(this.a), 9);
            return;
          }
          if (paramnbu.jdField_c_of_type_Int == 18)
          {
            wmi.a((BaseActivity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), new wmk(this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name, this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.summary), 1, mut.a(this.a), 10);
            return;
          }
        } while (paramnbu.jdField_c_of_type_Int == 21);
        if (paramnbu.jdField_c_of_type_Int == 22)
        {
          paramnbu = paramnbu.jdField_c_of_type_JavaLangString;
          mut.c(this.a, paramnbu);
          return;
        }
      } while (!QLog.isColorLevel());
      QLog.d("AccountDetailGroupListContainer", 2, "unhandled event_id: " + paramnbu.jdField_c_of_type_Int);
      return;
    } while (paramnbu.a != 1);
    paramnbu = paramnbu.jdField_c_of_type_JavaLangString;
    mut.c(this.a, paramnbu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     muv
 * JD-Core Version:    0.7.0.1
 */