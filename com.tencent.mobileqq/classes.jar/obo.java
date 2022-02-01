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

class obo
  implements ojm
{
  obo(obm paramobm) {}
  
  public void a(oji paramoji)
  {
    if (paramoji == null) {}
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
                    String str = paramoji.jdField_c_of_type_JavaLangString;
                    localObject = str;
                    if (str == null) {
                      localObject = "";
                    }
                    olh.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.a.jdField_a_of_type_JavaLangString, "0X8005A28", "0X8005A28", 0, 0, (String)localObject, "", "", "", false);
                    if (paramoji.a != 3) {
                      break label680;
                    }
                    if (paramoji.jdField_c_of_type_Int != 7) {
                      break;
                    }
                  } while ((TextUtils.isEmpty(paramoji.g)) || (TextUtils.isEmpty(paramoji.f)) || (TextUtils.isEmpty(paramoji.b)));
                  Object localObject = new Intent((Context)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), QQMapActivity.class);
                  ((Intent)localObject).putExtra("lat", paramoji.g);
                  ((Intent)localObject).putExtra("lon", paramoji.f);
                  ((Intent)localObject).putExtra("loc", paramoji.b);
                  ((BaseActivity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get()).startActivity((Intent)localObject);
                  return;
                  if (paramoji.jdField_c_of_type_Int != 8) {
                    break;
                  }
                  paramoji = paramoji.h;
                } while (TextUtils.isEmpty(paramoji));
                paramoji = paramoji.trim();
              } while (!Pattern.compile("[\\d-]+?").matcher(paramoji).matches());
              obm.b(this.a, paramoji);
              return;
            } while (paramoji.jdField_c_of_type_Int == 13);
            if (paramoji.jdField_c_of_type_Int == 11)
            {
              paramoji = new Intent((Context)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), ScannerActivity.class);
              paramoji.putExtra("from", this.a.jdField_a_of_type_JavaLangRefWeakReference.getClass().getName());
              paramoji.putExtra("finishAfterSucc", true);
              ((BaseActivity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get()).startActivity(paramoji);
              return;
            }
          } while (paramoji.jdField_c_of_type_Int == 16);
          if (paramoji.jdField_c_of_type_Int == 20)
          {
            obm.a(this.a);
            return;
          }
          if (paramoji.jdField_c_of_type_Int == 2)
          {
            aahr.b((Activity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), new aaht(this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name, this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.summary), 1, obm.a(this.a));
            return;
          }
          if (paramoji.jdField_c_of_type_Int == 17)
          {
            aahr.a((BaseActivity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), new aaht(this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name, this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.summary), 1, obm.a(this.a));
            return;
          }
          if (paramoji.jdField_c_of_type_Int == 19)
          {
            aahr.a((BaseActivity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), new aaht(this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name, this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.summary), 1, obm.a(this.a), 9);
            return;
          }
          if (paramoji.jdField_c_of_type_Int == 18)
          {
            aahr.a((BaseActivity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), new aaht(this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name, this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.summary), 1, obm.a(this.a), 10);
            return;
          }
        } while (paramoji.jdField_c_of_type_Int == 21);
        if (paramoji.jdField_c_of_type_Int == 22)
        {
          paramoji = paramoji.jdField_c_of_type_JavaLangString;
          obm.c(this.a, paramoji);
          return;
        }
      } while (!QLog.isColorLevel());
      QLog.d("AccountDetailGroupListContainer", 2, "unhandled event_id: " + paramoji.jdField_c_of_type_Int);
      return;
    } while (paramoji.a != 1);
    paramoji = paramoji.jdField_c_of_type_JavaLangString;
    obm.c(this.a, paramoji);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     obo
 * JD-Core Version:    0.7.0.1
 */