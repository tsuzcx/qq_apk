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

class nte
  implements oak
{
  nte(ntc paramntc) {}
  
  public void a(oag paramoag)
  {
    if (paramoag == null) {}
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
                    String str = paramoag.jdField_c_of_type_JavaLangString;
                    localObject = str;
                    if (str == null) {
                      localObject = "";
                    }
                    ocd.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.a.jdField_a_of_type_JavaLangString, "0X8005A28", "0X8005A28", 0, 0, (String)localObject, "", "", "", false);
                    if (paramoag.a != 3) {
                      break label680;
                    }
                    if (paramoag.jdField_c_of_type_Int != 7) {
                      break;
                    }
                  } while ((TextUtils.isEmpty(paramoag.g)) || (TextUtils.isEmpty(paramoag.f)) || (TextUtils.isEmpty(paramoag.b)));
                  Object localObject = new Intent((Context)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), QQMapActivity.class);
                  ((Intent)localObject).putExtra("lat", paramoag.g);
                  ((Intent)localObject).putExtra("lon", paramoag.f);
                  ((Intent)localObject).putExtra("loc", paramoag.b);
                  ((BaseActivity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get()).startActivity((Intent)localObject);
                  return;
                  if (paramoag.jdField_c_of_type_Int != 8) {
                    break;
                  }
                  paramoag = paramoag.h;
                } while (TextUtils.isEmpty(paramoag));
                paramoag = paramoag.trim();
              } while (!Pattern.compile("[\\d-]+?").matcher(paramoag).matches());
              ntc.b(this.a, paramoag);
              return;
            } while (paramoag.jdField_c_of_type_Int == 13);
            if (paramoag.jdField_c_of_type_Int == 11)
            {
              paramoag = new Intent((Context)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), ScannerActivity.class);
              paramoag.putExtra("from", this.a.jdField_a_of_type_JavaLangRefWeakReference.getClass().getName());
              paramoag.putExtra("finishAfterSucc", true);
              ((BaseActivity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get()).startActivity(paramoag);
              return;
            }
          } while (paramoag.jdField_c_of_type_Int == 16);
          if (paramoag.jdField_c_of_type_Int == 20)
          {
            ntc.a(this.a);
            return;
          }
          if (paramoag.jdField_c_of_type_Int == 2)
          {
            aavs.b((Activity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), new aavu(this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name, this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.summary), 1, ntc.a(this.a));
            return;
          }
          if (paramoag.jdField_c_of_type_Int == 17)
          {
            aavs.a((BaseActivity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), new aavu(this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name, this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.summary), 1, ntc.a(this.a));
            return;
          }
          if (paramoag.jdField_c_of_type_Int == 19)
          {
            aavs.a((BaseActivity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), new aavu(this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name, this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.summary), 1, ntc.a(this.a), 9);
            return;
          }
          if (paramoag.jdField_c_of_type_Int == 18)
          {
            aavs.a((BaseActivity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), new aavu(this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name, this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.summary), 1, ntc.a(this.a), 10);
            return;
          }
        } while (paramoag.jdField_c_of_type_Int == 21);
        if (paramoag.jdField_c_of_type_Int == 22)
        {
          paramoag = paramoag.jdField_c_of_type_JavaLangString;
          ntc.c(this.a, paramoag);
          return;
        }
      } while (!QLog.isColorLevel());
      QLog.d("AccountDetailGroupListContainer", 2, "unhandled event_id: " + paramoag.jdField_c_of_type_Int);
      return;
    } while (paramoag.a != 1);
    paramoag = paramoag.jdField_c_of_type_JavaLangString;
    ntc.c(this.a, paramoag);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nte
 * JD-Core Version:    0.7.0.1
 */