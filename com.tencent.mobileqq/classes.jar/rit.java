import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.AddFriendVerifyActivity;
import com.tencent.mobileqq.activity.AutoRemarkActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BabyQHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class rit
  extends FriendListObserver
{
  public rit(AddFriendVerifyActivity paramAddFriendVerifyActivity) {}
  
  public void onAddBatchPhoneFriend(boolean paramBoolean, ArrayList paramArrayList)
  {
    if (QLog.isColorLevel()) {
      if (paramArrayList == null) {
        break label199;
      }
    }
    label199:
    for (int i = paramArrayList.size();; i = -1)
    {
      QLog.d("AddFriendVerifyActivity", 2, "onAddBatchPhoneFriend success=" + paramBoolean + ", added count=" + i);
      if (paramBoolean)
      {
        if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) {
          this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
        }
        QQToast.a(this.a, 2, 2131434462, 0).b(this.a.getTitleBarHeight());
        Intent localIntent = new Intent();
        localIntent.putExtra("result", paramArrayList);
        this.a.setResult(-1, localIntent);
        this.a.finish();
        return;
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      }
      AddFriendVerifyActivity.b(this.a).clear();
      QQToast.a(this.a, 1, 2131434460, 0).b(this.a.getTitleBarHeight());
      this.a.setResult(0);
      this.a.finish();
      return;
    }
  }
  
  protected void onGetAutoInfo(boolean paramBoolean, String paramString1, String paramString2, int paramInt)
  {
    if (!TextUtils.equals(AddFriendVerifyActivity.a(this.a), paramString1)) {
      return;
    }
    if (paramBoolean)
    {
      if ((!AutoRemarkActivity.a(AddFriendVerifyActivity.b(this.a))) && (this.a.jdField_a_of_type_ComTencentMobileqqDataKplRoleInfo$WZRYUIinfo == null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("AddFriendVerifyActivity", 2, "onGetAutoInfo remark = " + paramString2);
        }
        this.a.b.setText(paramString2);
      }
      try
      {
        this.a.b.setSelection(this.a.b.getText().length());
        if (AppSetting.b) {
          AddFriendVerifyActivity.a(this.a).setContentDescription(this.a.getResources().getString(2131433493) + this.a.b.getText().toString());
        }
        AddFriendVerifyActivity.a(this.a, paramInt);
        this.a.jdField_a_of_type_AndroidWidgetTextView.setText(AutoRemarkActivity.a(this.a.app, AddFriendVerifyActivity.c(this.a)));
        return;
      }
      catch (IndexOutOfBoundsException paramString1)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("AddFriendVerifyActivity", 2, "onGetAutoInfo | IndexOutOfBoundsException");
          }
        }
      }
    }
    AddFriendVerifyActivity.a(this.a, 0);
    this.a.jdField_a_of_type_AndroidWidgetTextView.setText(AutoRemarkActivity.a(this.a.app, AddFriendVerifyActivity.c(this.a)));
  }
  
  protected void onInfoOpenId(boolean paramBoolean, String paramString1, String paramString2)
  {
    if ((paramBoolean) && (TextUtils.equals(paramString1, AddFriendVerifyActivity.a(this.a))) && (!TextUtils.isEmpty(paramString2)))
    {
      AddFriendVerifyActivity.b(this.a).setText(paramString2);
      if (AppSetting.b) {
        AddFriendVerifyActivity.b(this.a).setContentDescription(paramString2);
      }
    }
  }
  
  protected void onUpdateAddFriend(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString, Bundle paramBundle)
  {
    if (!TextUtils.equals(paramString, AddFriendVerifyActivity.a(this.a))) {}
    do
    {
      return;
      if (paramBoolean1)
      {
        if (paramBundle.getInt("friend_setting") == 3)
        {
          if (paramBoolean2)
          {
            this.a.a(this.a.jdField_a_of_type_AndroidWidgetEditText.getText().toString().trim(), paramBundle.getByteArray("sig"));
            return;
          }
          if ((paramBundle.getString("ErrorString") != null) && (!paramBundle.getString("ErrorString").trim().equals(""))) {}
          for (paramString = paramBundle.getString("ErrorString");; paramString = this.a.getString(2131434475))
          {
            QQToast.a(this.a, 1, paramString, 1).b(this.a.getTitleBarHeight());
            return;
          }
        }
        if (paramBundle.getInt("resultCode") == 0)
        {
          int i = paramBundle.getInt("friend_setting");
          if (paramBundle.getString("nick_name") == null) {}
          switch (i)
          {
          default: 
            if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null)
            {
              this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.cancel();
              this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
            }
            QQToast.a(this.a, 2, 2131434463, 0).b(this.a.getTitleBarHeight());
            this.a.a();
            return;
          case 0: 
          case 100: 
            if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null)
            {
              this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.cancel();
              this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
            }
            QQToast.a(this.a, 2, 2131435282, 0).b(this.a.getTitleBarHeight());
            if (Utils.b(paramString))
            {
              paramBundle = this.a.b.getText().toString();
              Object localObject = AddFriendVerifyActivity.b(this.a).getText().toString();
              if (TextUtils.isEmpty(paramBundle)) {
                paramBundle = (Bundle)localObject;
              }
              for (;;)
              {
                localObject = AIOUtils.a(new Intent(this.a, SplashActivity.class), null);
                ((Intent)localObject).putExtra("uin", paramString);
                ((Intent)localObject).putExtra("uintype", 0);
                ((Intent)localObject).putExtra("uinname", paramBundle);
                this.a.startActivity((Intent)localObject);
                ((BabyQHandler)this.a.app.a(53)).a(this.a.getIntent());
                return;
              }
            }
            this.a.a();
            return;
          }
          if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null)
          {
            this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.cancel();
            this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
          }
          QQToast.a(this.a, 2, 2131434463, 0).b(this.a.getTitleBarHeight());
          this.a.a();
          return;
        }
        if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null)
        {
          this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.cancel();
          this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
        }
        paramBundle = paramBundle.getString("ErrorString");
        if (QLog.isColorLevel()) {
          QLog.d("AddFriendVerifyActivity", 2, "add friend response error and ErroString = " + paramBundle);
        }
        paramString = paramBundle;
        if (TextUtils.isEmpty(paramBundle)) {
          paramString = this.a.getString(2131434460);
        }
        AddFriendVerifyActivity.a(this.a, paramString);
        return;
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.cancel();
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
      }
      AddFriendVerifyActivity.a(this.a, this.a.getString(2131434460));
    } while (!QLog.isColorLevel());
    QLog.d("AddFriendVerifyActivity", 2, "add friend response error and isSuccuss = NO");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rit
 * JD-Core Version:    0.7.0.1
 */