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

class nft
  implements nmw
{
  nft(nfr paramnfr) {}
  
  public void a(nms paramnms)
  {
    if (paramnms == null) {}
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
                    String str = paramnms.jdField_c_of_type_JavaLangString;
                    localObject = str;
                    if (str == null) {
                      localObject = "";
                    }
                    nol.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.a.jdField_a_of_type_JavaLangString, "0X8005A28", "0X8005A28", 0, 0, (String)localObject, "", "", "", false);
                    if (paramnms.a != 3) {
                      break label680;
                    }
                    if (paramnms.jdField_c_of_type_Int != 7) {
                      break;
                    }
                  } while ((TextUtils.isEmpty(paramnms.g)) || (TextUtils.isEmpty(paramnms.f)) || (TextUtils.isEmpty(paramnms.b)));
                  Object localObject = new Intent((Context)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), QQMapActivity.class);
                  ((Intent)localObject).putExtra("lat", paramnms.g);
                  ((Intent)localObject).putExtra("lon", paramnms.f);
                  ((Intent)localObject).putExtra("loc", paramnms.b);
                  ((BaseActivity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get()).startActivity((Intent)localObject);
                  return;
                  if (paramnms.jdField_c_of_type_Int != 8) {
                    break;
                  }
                  paramnms = paramnms.h;
                } while (TextUtils.isEmpty(paramnms));
                paramnms = paramnms.trim();
              } while (!Pattern.compile("[\\d-]+?").matcher(paramnms).matches());
              nfr.b(this.a, paramnms);
              return;
            } while (paramnms.jdField_c_of_type_Int == 13);
            if (paramnms.jdField_c_of_type_Int == 11)
            {
              paramnms = new Intent((Context)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), ScannerActivity.class);
              paramnms.putExtra("from", this.a.jdField_a_of_type_JavaLangRefWeakReference.getClass().getName());
              paramnms.putExtra("finishAfterSucc", true);
              ((BaseActivity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get()).startActivity(paramnms);
              return;
            }
          } while (paramnms.jdField_c_of_type_Int == 16);
          if (paramnms.jdField_c_of_type_Int == 20)
          {
            nfr.a(this.a);
            return;
          }
          if (paramnms.jdField_c_of_type_Int == 2)
          {
            xbi.b((Activity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), new xbk(this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name, this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.summary), 1, nfr.a(this.a));
            return;
          }
          if (paramnms.jdField_c_of_type_Int == 17)
          {
            xbi.a((BaseActivity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), new xbk(this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name, this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.summary), 1, nfr.a(this.a));
            return;
          }
          if (paramnms.jdField_c_of_type_Int == 19)
          {
            xbi.a((BaseActivity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), new xbk(this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name, this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.summary), 1, nfr.a(this.a), 9);
            return;
          }
          if (paramnms.jdField_c_of_type_Int == 18)
          {
            xbi.a((BaseActivity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), new xbk(this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name, this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.summary), 1, nfr.a(this.a), 10);
            return;
          }
        } while (paramnms.jdField_c_of_type_Int == 21);
        if (paramnms.jdField_c_of_type_Int == 22)
        {
          paramnms = paramnms.jdField_c_of_type_JavaLangString;
          nfr.c(this.a, paramnms);
          return;
        }
      } while (!QLog.isColorLevel());
      QLog.d("AccountDetailGroupListContainer", 2, "unhandled event_id: " + paramnms.jdField_c_of_type_Int);
      return;
    } while (paramnms.a != 1);
    paramnms = paramnms.jdField_c_of_type_JavaLangString;
    nfr.c(this.a, paramnms);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nft
 * JD-Core Version:    0.7.0.1
 */