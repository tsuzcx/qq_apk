import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.ui.AVLoadingDialogActivity;
import com.tencent.av.utils.GVideoUpdateUtil.OnGVideoUpdateListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.groupvideo.GroupVideoHelper;
import mqq.os.MqqHandler;

public final class ruv
  implements GVideoUpdateUtil.OnGVideoUpdateListener
{
  public ruv(int paramInt1, int paramInt2, QQAppInterface paramQQAppInterface, QCallFacade paramQCallFacade, long paramLong1, Intent paramIntent, long paramLong2, String paramString) {}
  
  public void a(Context paramContext, String paramString)
  {
    paramString = null;
    if ((this.jdField_a_of_type_Int == 0) && (this.jdField_b_of_type_Int == 3000)) {
      ThreadManager.post(new ruw(this), 5, null, true);
    }
    int i = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("MultiAVType", 0);
    String str;
    if (i != 2)
    {
      str = this.jdField_a_of_type_AndroidContentIntent.getComponent().getClassName();
      paramString = paramContext.getClass().getName();
      QLog.w("ChatActivityUtils", 1, "createOrEnterGroupAudio, className[" + str + "], contextName[" + paramString + "]");
    }
    for (;;)
    {
      if (i == 2) {
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(1, this.jdField_b_of_type_Long))
        {
          paramContext = new Intent("tencent.video.q2v.back2VideoRoom");
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().sendBroadcast(paramContext);
        }
      }
      for (;;)
      {
        if (this.jdField_a_of_type_Int == 0) {
          ThreadManager.getFileThreadHandler().post(new ruy(this));
        }
        return;
        GroupVideoHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramContext, this.jdField_a_of_type_AndroidContentIntent, 1);
        continue;
        if ((!TextUtils.isEmpty(str)) && (str.equals("com.tencent.av.ui.AVActivity")) && (((!TextUtils.isEmpty(paramString)) && (paramString.equals("com.tencent.mobileqq.qcall.QCallDetailActivity"))) || (paramString.equals("com.tencent.mobileqq.activity.selectmember.SelectMemberActivity")) || (paramString.equals("com.tencent.mobileqq.activity.SplashActivity")) || (paramString.equals("com.tencent.mobileqq.activity.recent.RecentT9SearchActivity"))))
        {
          paramString = new Intent(paramContext, AVLoadingDialogActivity.class);
          paramString.putExtra("avactivity_intent", this.jdField_a_of_type_AndroidContentIntent);
          paramString.addFlags(268435456);
          AudioHelper.b("发起音视频_start_AVLoadingDialogActivity");
          paramContext.startActivity(paramString);
        }
        else
        {
          AudioHelper.b("发起音视频_start_AVActivity");
          paramContext.startActivity(this.jdField_a_of_type_AndroidContentIntent);
        }
      }
      str = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ruv
 * JD-Core Version:    0.7.0.1
 */