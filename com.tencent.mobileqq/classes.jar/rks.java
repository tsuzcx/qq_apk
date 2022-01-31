import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.subaccount.datamanager.SubAccountManager;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.remote.SimpleAccount;
import java.util.HashMap;

public class rks
  implements Runnable
{
  public rks(AccountManageActivity paramAccountManageActivity, String paramString1, SimpleAccount paramSimpleAccount, String paramString2, TextView paramTextView, ImageView paramImageView) {}
  
  public void run()
  {
    boolean bool = true;
    for (;;)
    {
      try
      {
        Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.app.a(1, this.jdField_a_of_type_JavaLangString, (byte)3, 0);
        Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.app.a((String)localObject1);
        if (localBitmap == null)
        {
          if ((!AccountManageActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity).containsKey(this.jdField_a_of_type_JavaLangString)) || (AccountManageActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity).get(this.jdField_a_of_type_JavaLangString) == null))
          {
            localObject1 = FaceDrawable.a(this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.app, this.jdField_a_of_type_JavaLangString, (byte)3);
            String str2 = ContactUtils.j(this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.app, this.jdField_a_of_type_JavaLangString);
            localObject2 = (SubAccountManager)this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.app.getManager(60);
            if (localObject2 == null) {
              break label337;
            }
            localObject2 = ((SubAccountManager)localObject2).a(this.jdField_a_of_type_JavaLangString);
            String str1;
            if (!this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount.isLogined())
            {
              str1 = str2;
              if (localObject2 != null)
              {
                str1 = str2;
                if (((SubAccountInfo)localObject2).subuin != null)
                {
                  str1 = str2;
                  if (!((SubAccountInfo)localObject2).subuin.equalsIgnoreCase(this.jdField_a_of_type_JavaLangString)) {}
                }
              }
            }
            else if (!TextUtils.isEmpty(str2))
            {
              str1 = str2;
              if (!str2.equals(this.jdField_a_of_type_JavaLangString)) {}
            }
            else
            {
              str1 = ContactUtils.k(this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.app, this.jdField_a_of_type_JavaLangString);
            }
            if ((!TextUtils.isEmpty(str1)) && (!this.b.equals(str1))) {
              this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.runOnUiThread(new rkt(this, bool, str1, localBitmap, (Drawable)localObject1));
            }
          }
          else
          {
            localBitmap = (Bitmap)AccountManageActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity).get(this.jdField_a_of_type_JavaLangString);
            FaceDrawable.a(this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.app, this.jdField_a_of_type_JavaLangString, (byte)3);
            localObject1 = null;
            continue;
          }
        }
        else
        {
          AccountManageActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity).put(this.jdField_a_of_type_JavaLangString, localBitmap);
          localObject1 = null;
          continue;
        }
        bool = false;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
      continue;
      label337:
      Object localObject2 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rks
 * JD-Core Version:    0.7.0.1
 */