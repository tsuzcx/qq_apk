import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.AccountDetail.view.AccountDetailGroupListContainer;
import com.tencent.biz.pubaccount.PaConfigAttr.PaConfigInfo;
import com.tencent.biz.pubaccount.PhotoWallViewForAccountDetail.PhotoWallCallback;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.qrcode.activity.ScannerActivity;
import com.tencent.biz.troopbar.ShareActionSheet;
import com.tencent.biz.troopbar.ShareActionSheet.Detail;
import com.tencent.mobileqq.activity.QQMapActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class kqv
  implements PhotoWallViewForAccountDetail.PhotoWallCallback
{
  public kqv(AccountDetailGroupListContainer paramAccountDetailGroupListContainer) {}
  
  public void a(PaConfigAttr.PaConfigInfo paramPaConfigInfo)
  {
    if (paramPaConfigInfo == null) {}
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
                    String str = paramPaConfigInfo.jdField_c_of_type_JavaLangString;
                    localObject = str;
                    if (str == null) {
                      localObject = "";
                    }
                    PublicAccountReportUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.a.jdField_a_of_type_JavaLangString, "0X8005A28", "0X8005A28", 0, 0, (String)localObject, "", "", "", false);
                    if (paramPaConfigInfo.a != 3) {
                      break label680;
                    }
                    if (paramPaConfigInfo.jdField_c_of_type_Int != 7) {
                      break;
                    }
                  } while ((TextUtils.isEmpty(paramPaConfigInfo.g)) || (TextUtils.isEmpty(paramPaConfigInfo.f)) || (TextUtils.isEmpty(paramPaConfigInfo.b)));
                  Object localObject = new Intent((Context)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), QQMapActivity.class);
                  ((Intent)localObject).putExtra("lat", paramPaConfigInfo.g);
                  ((Intent)localObject).putExtra("lon", paramPaConfigInfo.f);
                  ((Intent)localObject).putExtra("loc", paramPaConfigInfo.b);
                  ((BaseActivity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get()).startActivity((Intent)localObject);
                  return;
                  if (paramPaConfigInfo.jdField_c_of_type_Int != 8) {
                    break;
                  }
                  paramPaConfigInfo = paramPaConfigInfo.h;
                } while (TextUtils.isEmpty(paramPaConfigInfo));
                paramPaConfigInfo = paramPaConfigInfo.trim();
              } while (!Pattern.compile("[\\d-]+?").matcher(paramPaConfigInfo).matches());
              AccountDetailGroupListContainer.b(this.a, paramPaConfigInfo);
              return;
            } while (paramPaConfigInfo.jdField_c_of_type_Int == 13);
            if (paramPaConfigInfo.jdField_c_of_type_Int == 11)
            {
              paramPaConfigInfo = new Intent((Context)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), ScannerActivity.class);
              paramPaConfigInfo.putExtra("from", this.a.jdField_a_of_type_JavaLangRefWeakReference.getClass().getName());
              paramPaConfigInfo.putExtra("finishAfterSucc", true);
              ((BaseActivity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get()).startActivity(paramPaConfigInfo);
              return;
            }
          } while (paramPaConfigInfo.jdField_c_of_type_Int == 16);
          if (paramPaConfigInfo.jdField_c_of_type_Int == 20)
          {
            AccountDetailGroupListContainer.a(this.a);
            return;
          }
          if (paramPaConfigInfo.jdField_c_of_type_Int == 2)
          {
            ShareActionSheet.b((Activity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), new ShareActionSheet.Detail(this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name, this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.summary), 1, AccountDetailGroupListContainer.a(this.a));
            return;
          }
          if (paramPaConfigInfo.jdField_c_of_type_Int == 17)
          {
            ShareActionSheet.a((BaseActivity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), new ShareActionSheet.Detail(this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name, this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.summary), 1, AccountDetailGroupListContainer.a(this.a));
            return;
          }
          if (paramPaConfigInfo.jdField_c_of_type_Int == 19)
          {
            ShareActionSheet.a((BaseActivity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), new ShareActionSheet.Detail(this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name, this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.summary), 1, AccountDetailGroupListContainer.a(this.a), 9);
            return;
          }
          if (paramPaConfigInfo.jdField_c_of_type_Int == 18)
          {
            ShareActionSheet.a((BaseActivity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), new ShareActionSheet.Detail(this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name, this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.summary), 1, AccountDetailGroupListContainer.a(this.a), 10);
            return;
          }
        } while (paramPaConfigInfo.jdField_c_of_type_Int == 21);
        if (paramPaConfigInfo.jdField_c_of_type_Int == 22)
        {
          paramPaConfigInfo = paramPaConfigInfo.jdField_c_of_type_JavaLangString;
          AccountDetailGroupListContainer.c(this.a, paramPaConfigInfo);
          return;
        }
      } while (!QLog.isColorLevel());
      QLog.d("AccountDetailGroupListContainer", 2, "unhandled event_id: " + paramPaConfigInfo.jdField_c_of_type_Int);
      return;
    } while (paramPaConfigInfo.a != 1);
    paramPaConfigInfo = paramPaConfigInfo.jdField_c_of_type_JavaLangString;
    AccountDetailGroupListContainer.c(this.a, paramPaConfigInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kqv
 * JD-Core Version:    0.7.0.1
 */