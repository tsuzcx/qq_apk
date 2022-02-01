package cooperation.qzone;

import aici;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.Base64;
import android.view.Window;
import aslo;
import assw;
import assy;
import bhdj;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
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
  
  public static void enterAio(FragmentActivity paramFragmentActivity, String paramString1, String paramString2)
  {
    if (paramFragmentActivity == null) {
      return;
    }
    Intent localIntent = new Intent(paramFragmentActivity, ChatActivity.class);
    localIntent.putExtra("uin", paramString1);
    localIntent.putExtra("uinname", paramString2);
    localIntent.putExtra("entrance", 23);
    localIntent.putExtra("uintype", 1045);
    localIntent.putExtra("key_limitchat_enter_type", aici.b);
    localIntent.putExtras(new Bundle());
    paramFragmentActivity.startActivity(localIntent);
    paramFragmentActivity.finish();
  }
  
  public static void showCampusVerifyDialog(FragmentActivity paramFragmentActivity, boolean paramBoolean, int paramInt, String paramString1, String paramString2)
  {
    if ((paramFragmentActivity == null) || (!paramFragmentActivity.isResume()))
    {
      QLog.d("QZoneNavigateToQQTransparentFragment", 1, "showCampusVerifyDialog() activity is null or is not onResume() just return");
      return;
    }
    QQCustomDialog localQQCustomDialog = bhdj.a(paramFragmentActivity, 230);
    localQQCustomDialog.setOnDismissListener(new QZoneNavigateToQQTransparentFragment.2(paramFragmentActivity));
    localQQCustomDialog.setMessage(paramFragmentActivity.getString(2131698524)).setNegativeButton(paramFragmentActivity.getString(2131698522), new QZoneNavigateToQQTransparentFragment.4()).setPositiveButton(paramFragmentActivity.getString(2131698523), new QZoneNavigateToQQTransparentFragment.3(paramBoolean, paramFragmentActivity, paramInt, paramString1, paramString2)).show();
  }
  
  private static void showMatchCountDialog(FragmentActivity paramFragmentActivity)
  {
    if ((paramFragmentActivity == null) || (!paramFragmentActivity.isResume()))
    {
      QLog.d("QZoneNavigateToQQTransparentFragment", 1, "showMatchCountDialog() activity is null or is not onResume() just return");
      return;
    }
    QQCustomDialog localQQCustomDialog = bhdj.a(paramFragmentActivity, 230);
    localQQCustomDialog.setOnDismissListener(new QZoneNavigateToQQTransparentFragment.5(paramFragmentActivity));
    localQQCustomDialog.setMessage(paramFragmentActivity.getString(2131698526)).setPositiveButton(paramFragmentActivity.getString(2131698525), new QZoneNavigateToQQTransparentFragment.6()).show();
  }
  
  private static void showToast(FragmentActivity paramFragmentActivity, String paramString)
  {
    if ((paramFragmentActivity == null) || (!paramFragmentActivity.isResume()))
    {
      QLog.d("QZoneNavigateToQQTransparentFragment", 1, "showToast() activity is null or is not onResume() just return");
      return;
    }
    QQToast.a(paramFragmentActivity, paramString, 0).b(paramFragmentActivity.getTitleBarHeight());
    ThreadManager.getUIHandler().postDelayed(new QZoneNavigateToQQTransparentFragment.7(paramFragmentActivity), 0L);
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
    paramBundle = getActivity();
    if (paramBundle != null) {
      paramBundle.getWindow().setBackgroundDrawable(new ColorDrawable(0));
    }
  }
  
  public boolean onBackEvent()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity != null) {
      localFragmentActivity.finish();
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
    String str2 = null;
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity != null) {}
    String str1;
    for (Object localObject = localFragmentActivity.getIntent();; str1 = null)
    {
      Bundle localBundle;
      if (localObject != null)
      {
        localBundle = ((Intent)localObject).getExtras();
        if (localBundle != null) {}
      }
      else
      {
        return;
      }
      int i = localBundle.getInt("request_code");
      switch (i)
      {
      default: 
        QZLog.i("QZoneNavigateToQQTransparentFragment", "parseIntent: wrong code " + i);
        return;
      }
      long l = localBundle.getLong("uin");
      String str3 = localBundle.getString("nickname");
      String str4 = localBundle.getString("extend_friend_campus_aio_code");
      QZLog.i("QZoneNavigateToQQTransparentFragment", "parseIntent: " + l + " " + str3 + " " + str4);
      localObject = str2;
      if (!TextUtils.isEmpty(str4)) {}
      try
      {
        localObject = Base64.decode(str4, 0);
        assy.a(localFragmentActivity.app).a(localFragmentActivity.app, String.valueOf(l), str3, (byte[])localObject, 1, new QZoneNavigateToQQTransparentFragment.1(this, localFragmentActivity));
        localObject = localBundle.getString("extend_friend_campus_algorithm_id");
        str2 = localBundle.getString("extend_friend_campus_current_tab", aslo.a);
        assw.a().a(1, String.valueOf(l), "", "0", (String)localObject, str2);
        return;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          QLog.d("QZoneNavigateToQQTransparentFragment", 2, "[open limit chat] parse strKuolieCampusAIOKey error! " + str4, localThrowable);
          str1 = str2;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.QZoneNavigateToQQTransparentFragment
 * JD-Core Version:    0.7.0.1
 */