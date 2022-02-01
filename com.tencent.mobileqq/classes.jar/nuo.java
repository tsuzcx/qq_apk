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

class nuo
  implements obv
{
  nuo(num paramnum) {}
  
  public void a(obr paramobr)
  {
    if (paramobr == null) {}
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
                    String str = paramobr.jdField_c_of_type_JavaLangString;
                    localObject = str;
                    if (str == null) {
                      localObject = "";
                    }
                    odq.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.a.jdField_a_of_type_JavaLangString, "0X8005A28", "0X8005A28", 0, 0, (String)localObject, "", "", "", false);
                    if (paramobr.a != 3) {
                      break label680;
                    }
                    if (paramobr.jdField_c_of_type_Int != 7) {
                      break;
                    }
                  } while ((TextUtils.isEmpty(paramobr.g)) || (TextUtils.isEmpty(paramobr.f)) || (TextUtils.isEmpty(paramobr.b)));
                  Object localObject = new Intent((Context)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), QQMapActivity.class);
                  ((Intent)localObject).putExtra("lat", paramobr.g);
                  ((Intent)localObject).putExtra("lon", paramobr.f);
                  ((Intent)localObject).putExtra("loc", paramobr.b);
                  ((BaseActivity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get()).startActivity((Intent)localObject);
                  return;
                  if (paramobr.jdField_c_of_type_Int != 8) {
                    break;
                  }
                  paramobr = paramobr.h;
                } while (TextUtils.isEmpty(paramobr));
                paramobr = paramobr.trim();
              } while (!Pattern.compile("[\\d-]+?").matcher(paramobr).matches());
              num.b(this.a, paramobr);
              return;
            } while (paramobr.jdField_c_of_type_Int == 13);
            if (paramobr.jdField_c_of_type_Int == 11)
            {
              paramobr = new Intent((Context)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), ScannerActivity.class);
              paramobr.putExtra("from", this.a.jdField_a_of_type_JavaLangRefWeakReference.getClass().getName());
              paramobr.putExtra("finishAfterSucc", true);
              ((BaseActivity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get()).startActivity(paramobr);
              return;
            }
          } while (paramobr.jdField_c_of_type_Int == 16);
          if (paramobr.jdField_c_of_type_Int == 20)
          {
            num.a(this.a);
            return;
          }
          if (paramobr.jdField_c_of_type_Int == 2)
          {
            zsf.b((Activity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), new zsh(this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name, this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.summary), 1, num.a(this.a));
            return;
          }
          if (paramobr.jdField_c_of_type_Int == 17)
          {
            zsf.a((BaseActivity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), new zsh(this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name, this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.summary), 1, num.a(this.a));
            return;
          }
          if (paramobr.jdField_c_of_type_Int == 19)
          {
            zsf.a((BaseActivity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), new zsh(this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name, this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.summary), 1, num.a(this.a), 9);
            return;
          }
          if (paramobr.jdField_c_of_type_Int == 18)
          {
            zsf.a((BaseActivity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), new zsh(this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name, this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.summary), 1, num.a(this.a), 10);
            return;
          }
        } while (paramobr.jdField_c_of_type_Int == 21);
        if (paramobr.jdField_c_of_type_Int == 22)
        {
          paramobr = paramobr.jdField_c_of_type_JavaLangString;
          num.c(this.a, paramobr);
          return;
        }
      } while (!QLog.isColorLevel());
      QLog.d("AccountDetailGroupListContainer", 2, "unhandled event_id: " + paramobr.jdField_c_of_type_Int);
      return;
    } while (paramobr.a != 1);
    paramobr = paramobr.jdField_c_of_type_JavaLangString;
    num.c(this.a, paramobr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nuo
 * JD-Core Version:    0.7.0.1
 */