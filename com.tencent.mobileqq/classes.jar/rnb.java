import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.AddFriendVerifyActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.AntiFraudConfigFileUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qidian.QidianProfileCardActivity;
import java.util.ArrayList;
import mqq.util.WeakReference;

public class rnb
  extends FriendListObserver
{
  final WeakReference jdField_a_of_type_MqqUtilWeakReference;
  
  public rnb(AddFriendLogicActivity paramAddFriendLogicActivity1, AddFriendLogicActivity paramAddFriendLogicActivity2)
  {
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramAddFriendLogicActivity2);
  }
  
  protected void onQueryUinSafetyFlag(boolean paramBoolean, long paramLong, int paramInt1, int paramInt2)
  {
    AddFriendLogicActivity localAddFriendLogicActivity = (AddFriendLogicActivity)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if ((localAddFriendLogicActivity == null) || (!localAddFriendLogicActivity.isResume())) {}
    while ((AddFriendLogicActivity.c(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity) != 1) || (paramInt1 != 147) || (!String.valueOf(paramLong).equals(AddFriendLogicActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity)))) {
      return;
    }
    if ((!paramBoolean) || (paramInt2 == 0))
    {
      AddFriendLogicActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity);
      return;
    }
    AddFriendLogicActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity, paramInt2);
    AntiFraudConfigFileUtil.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity.app, "SecWarningCfg");
    try
    {
      AddFriendLogicActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity, DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity, 230, "", "", this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener, this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity.jdField_b_of_type_AndroidContentDialogInterface$OnClickListener));
      AddFriendLogicActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity);
      AddFriendLogicActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity).setOnDismissListener(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity.jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener);
      AddFriendLogicActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity).show();
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity.app, "P_CliOper", "Safe_AntiFraud", this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity.app.getCurrentAccountUin(), "AlertDialog", "Display", 0, AddFriendLogicActivity.d(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity), "", "", "", "");
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  protected void onUpdateAddFriendSetting(boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject = paramBundle.getString("uin");
    if (!AddFriendLogicActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity).equals(localObject)) {}
    int i;
    do
    {
      return;
      i = paramBundle.getInt("random_key");
    } while ((i != 0) && (i != AddFriendLogicActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity)));
    if ((AddFriendLogicActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity) != null) && (AddFriendLogicActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity).isShowing())) {
      AddFriendLogicActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity).dismiss();
    }
    if (paramBoolean)
    {
      i = paramBundle.getInt("friend_setting");
      ArrayList localArrayList = paramBundle.getStringArrayList("user_question");
      Boolean localBoolean = Boolean.valueOf(paramBundle.getBoolean("contact_bothway"));
      long l = paramBundle.getLong("query_friend_uin");
      try
      {
        paramBundle = Long.toString(l);
        if ((localBoolean.booleanValue()) && (i != 0))
        {
          if (AddFriendLogicActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity) == 3006) {
            this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity.getIntent().putExtra("sub_source_id", 2);
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity.a(i, localBoolean.booleanValue(), localArrayList, AddFriendVerifyActivity.class, AddFriendLogicActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity));
          return;
        }
      }
      catch (Exception paramBundle)
      {
        for (;;)
        {
          paramBundle = null;
        }
        switch (i)
        {
        default: 
          AddFriendLogicActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity, -1, "请求失败");
          QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity.app.getApplication(), 2131434471, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity.getTitleBarHeight());
          this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity.finish();
          return;
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity.a(i, localBoolean.booleanValue(), localArrayList, AddFriendVerifyActivity.class, AddFriendLogicActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity));
      return;
      AddFriendLogicActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity, -1, this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity.getString(2131434470));
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity.app.getApplication(), 2131434470, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity.getTitleBarHeight());
      this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity.finish();
      return;
      if (AddFriendLogicActivity.c(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity) == 1) {
        ThreadManager.post(new rnc(this, (String)localObject), 8, null, true);
      }
      while ((this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity.getIntent().getBooleanExtra("webim_qd_ext", false)) && (!TextUtils.isEmpty(paramBundle)))
      {
        paramBundle = new ProfileActivity.AllInOne(paramBundle, 1);
        localObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity, QidianProfileCardActivity.class);
        ((Intent)localObject).putExtra("AllInOne", paramBundle);
        ((Intent)localObject).addFlags(536870912);
        this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity.startActivity((Intent)localObject);
        this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity.setResult(-1);
        this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity.finish();
        return;
        if (AddFriendLogicActivity.c(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity) == 2) {
          ((PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity.app.getManager(10)).b();
        }
      }
      if ((!TextUtils.isEmpty(paramBundle)) && (!"0".equals(paramBundle)))
      {
        paramBundle = new ProfileActivity.AllInOne(paramBundle, 1);
        paramBundle.h = 115;
        localObject = ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity, paramBundle);
        ((Intent)localObject).putExtra("AllInOne", paramBundle);
        ((Intent)localObject).putExtra("src_name", AddFriendLogicActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity));
        ((Intent)localObject).putExtra("source_id", this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity.getIntent().getIntExtra("source_id", 3999));
        ((Intent)localObject).putExtra("extra", this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity.getIntent().getStringExtra("extra"));
        ((Intent)localObject).addFlags(536870912);
        ((Intent)localObject).addFlags(268435456);
        AddFriendLogicActivity.jdField_b_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity.startActivity((Intent)localObject);
        this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity.setResult(-1);
        this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity.finish();
        return;
      }
      AddFriendLogicActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity, -1, "对方已经是你的好友了");
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity.app.getApplication(), "对方已经是你的好友了", 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity.getTitleBarHeight());
      this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity.setResult(-1);
      this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity.finish();
      return;
    }
    AddFriendLogicActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity, -1, "请求失败");
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity.app.getApplication(), 2131434471, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity.getTitleBarHeight());
    this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rnb
 * JD-Core Version:    0.7.0.1
 */