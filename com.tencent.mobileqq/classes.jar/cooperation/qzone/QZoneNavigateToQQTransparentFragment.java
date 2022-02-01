package cooperation.qzone;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.view.Window;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.extendfriend.utils.ExtendFriendReport;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.qqexpand.chat.IExpandMsgSendHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.QZLog;
import mqq.os.MqqHandler;

public class QZoneNavigateToQQTransparentFragment
  extends PublicBaseFragment
{
  public static final String EXTRA_KEY_EXTEND_FRIEND_CAMPUS_AIO_CODE = "extend_friend_campus_aio_code";
  public static final String EXTRA_KEY_EXTEND_FRIEND_CAMPUS_ALGORITHM_ID = "extend_friend_campus_algorithm_id";
  public static final String EXTRA_KEY_EXTEND_FRIEND_CAMPUS_CURRENT_TAB = "extend_friend_campus_current_tab";
  public static final String EXTRA_KEY_NICKNAME = "nickname";
  public static final String EXTRA_KEY_REQUEST_CODE = "request_code";
  public static final String EXTRA_KEY_UIN = "uin";
  public static final int REQUEST_CODE_LAUNCH_CAMPUS_AIO_CHAT = 1;
  private static final String TAG = "QZoneNavigateToQQTransparentFragment";
  private boolean mHasParsedIntent;
  
  public static void enterAio(BaseActivity paramBaseActivity, String paramString1, String paramString2)
  {
    if (paramBaseActivity == null) {
      return;
    }
    Intent localIntent = new Intent(paramBaseActivity, ChatActivity.class);
    localIntent.putExtra("uin", paramString1);
    localIntent.putExtra("uinname", paramString2);
    localIntent.putExtra("entrance", 23);
    localIntent.putExtra("uintype", 1045);
    localIntent.putExtra("key_limitchat_enter_type", 1);
    localIntent.putExtras(new Bundle());
    paramBaseActivity.startActivity(localIntent);
    paramBaseActivity.finish();
  }
  
  public static void showCampusVerifyDialog(BaseActivity paramBaseActivity, boolean paramBoolean, int paramInt, String paramString1, String paramString2)
  {
    if ((paramBaseActivity != null) && (paramBaseActivity.isResume()))
    {
      QQCustomDialog localQQCustomDialog = DialogUtil.a(paramBaseActivity, 230);
      localQQCustomDialog.setOnDismissListener(new QZoneNavigateToQQTransparentFragment.2(paramBaseActivity));
      localQQCustomDialog.setMessage(paramBaseActivity.getString(2131698892)).setNegativeButton(paramBaseActivity.getString(2131698890), new QZoneNavigateToQQTransparentFragment.4()).setPositiveButton(paramBaseActivity.getString(2131698891), new QZoneNavigateToQQTransparentFragment.3(paramBoolean, paramBaseActivity, paramInt, paramString1, paramString2)).show();
      return;
    }
    QLog.d("QZoneNavigateToQQTransparentFragment", 1, "showCampusVerifyDialog() activity is null or is not onResume() just return");
  }
  
  private static void showMatchCountDialog(BaseActivity paramBaseActivity)
  {
    if ((paramBaseActivity != null) && (paramBaseActivity.isResume()))
    {
      QQCustomDialog localQQCustomDialog = DialogUtil.a(paramBaseActivity, 230);
      localQQCustomDialog.setOnDismissListener(new QZoneNavigateToQQTransparentFragment.5(paramBaseActivity));
      localQQCustomDialog.setMessage(paramBaseActivity.getString(2131698894)).setPositiveButton(paramBaseActivity.getString(2131698893), new QZoneNavigateToQQTransparentFragment.6()).show();
      return;
    }
    QLog.d("QZoneNavigateToQQTransparentFragment", 1, "showMatchCountDialog() activity is null or is not onResume() just return");
  }
  
  private static void showToast(BaseActivity paramBaseActivity, String paramString)
  {
    if ((paramBaseActivity != null) && (paramBaseActivity.isResume()))
    {
      QQToast.a(paramBaseActivity, paramString, 0).b(paramBaseActivity.getTitleBarHeight());
      ThreadManager.getUIHandler().postDelayed(new QZoneNavigateToQQTransparentFragment.7(paramBaseActivity), 0L);
      return;
    }
    QLog.d("QZoneNavigateToQQTransparentFragment", 1, "showToast() activity is null or is not onResume() just return");
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    paramActivity.requestWindowFeature(1);
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean needStatusTrans()
  {
    return true;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    paramBundle = getBaseActivity();
    if (paramBundle != null) {
      paramBundle.getWindow().setBackgroundDrawable(new ColorDrawable(0));
    }
  }
  
  public boolean onBackEvent()
  {
    BaseActivity localBaseActivity = getBaseActivity();
    if (localBaseActivity != null) {
      localBaseActivity.finish();
    }
    return super.onBackEvent();
  }
  
  public void onResume()
  {
    super.onResume();
    if (!this.mHasParsedIntent)
    {
      this.mHasParsedIntent = true;
      parseIntent();
    }
  }
  
  protected void parseIntent()
  {
    BaseActivity localBaseActivity = getBaseActivity();
    String str2 = null;
    Object localObject;
    if (localBaseActivity != null) {
      localObject = localBaseActivity.getIntent();
    } else {
      localObject = null;
    }
    if (localObject != null)
    {
      Bundle localBundle = ((Intent)localObject).getExtras();
      if (localBundle == null) {
        return;
      }
      int i = localBundle.getInt("request_code");
      if (i != 1)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("parseIntent: wrong code ");
        ((StringBuilder)localObject).append(i);
        QZLog.i("QZoneNavigateToQQTransparentFragment", ((StringBuilder)localObject).toString());
        return;
      }
      long l = localBundle.getLong("uin");
      String str3 = localBundle.getString("nickname");
      String str4 = localBundle.getString("extend_friend_campus_aio_code");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("parseIntent: ");
      ((StringBuilder)localObject).append(l);
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(str3);
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(str4);
      QZLog.i("QZoneNavigateToQQTransparentFragment", ((StringBuilder)localObject).toString());
      localObject = str2;
      if (!TextUtils.isEmpty(str4)) {
        try
        {
          localObject = Base64.decode(str4, 0);
        }
        catch (Throwable localThrowable)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("[open limit chat] parse strKuolieCampusAIOKey error! ");
          localStringBuilder.append(str4);
          QLog.d("QZoneNavigateToQQTransparentFragment", 2, localStringBuilder.toString(), localThrowable);
          str1 = str2;
        }
      }
      ((IExpandMsgSendHelper)QRoute.api(IExpandMsgSendHelper.class)).sendMsgDirectly(localBaseActivity.app, String.valueOf(l), str3, str1, 1, new QZoneNavigateToQQTransparentFragment.1(this, localBaseActivity));
      String str1 = localBundle.getString("extend_friend_campus_algorithm_id");
      str2 = localBundle.getString("extend_friend_campus_current_tab", "推荐");
      ExtendFriendReport.a().a(1, String.valueOf(l), "", "0", str1, str2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.QZoneNavigateToQQTransparentFragment
 * JD-Core Version:    0.7.0.1
 */