import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.avgame.gameroom.video.AVGameNetWorkQualityManager;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity;
import com.tencent.qphone.base.util.QLog;

public class nml
  implements aojw
{
  public nml(AVGameNetWorkQualityManager paramAVGameNetWorkQualityManager, Context paramContext, String paramString) {}
  
  public void a(boolean paramBoolean, long paramLong1, long paramLong2, long paramLong3) {}
  
  public void a(boolean paramBoolean, String paramString)
  {
    QLog.d("AVGameNetWorkQualityManager", 1, "getShareLinkCallback isSuccess: " + paramBoolean + " shareUrl: " + paramString);
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString)))
    {
      Activity localActivity = (Activity)this.jdField_a_of_type_AndroidContentContext;
      StringBuilder localStringBuilder = new StringBuilder("https://act.qzone.qq.com/vip/meteor/blockly/p/4861x6970f?env=uat");
      Intent localIntent = new Intent(localActivity, QQTranslucentBrowserActivity.class);
      localIntent.putExtra("isTransparentTitle", true);
      localIntent.putExtra("hide_more_button", true);
      localIntent.putExtra("avgame_share_link", paramString);
      localIntent.putExtra("avgame_share_name", this.jdField_a_of_type_JavaLangString);
      localIntent.putExtra("url", localStringBuilder.toString());
      localIntent.putExtra("big_brother_source_key", "biz_src_jc_av_game");
      localActivity.startActivity(localIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nml
 * JD-Core Version:    0.7.0.1
 */