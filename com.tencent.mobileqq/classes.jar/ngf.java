import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.biz.qqstory.newshare.callback.StoryShareCallback;
import com.tencent.biz.qqstory.newshare.model.ShareSinaData;
import com.tencent.mobileqq.app.ThreadManager;
import java.io.File;
import mqq.os.MqqHandler;

public final class ngf
  implements Runnable
{
  public ngf(ShareSinaData paramShareSinaData, ApplicationInfo paramApplicationInfo, Context paramContext, StoryShareCallback paramStoryShareCallback) {}
  
  public void run()
  {
    Intent localIntent = new Intent("android.intent.action.SEND");
    localIntent.setFlags(268435456);
    localIntent.setType("image/*");
    localIntent.putExtra("android.intent.extra.TEXT", this.jdField_a_of_type_ComTencentBizQqstoryNewshareModelShareSinaData.a + this.jdField_a_of_type_ComTencentBizQqstoryNewshareModelShareSinaData.c);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQqstoryNewshareModelShareSinaData.d)) {
      localIntent.putExtra("android.intent.extra.STREAM", Uri.fromFile(new File(this.jdField_a_of_type_ComTencentBizQqstoryNewshareModelShareSinaData.d)));
    }
    localIntent.setPackage(this.jdField_a_of_type_AndroidContentPmApplicationInfo.packageName);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    ThreadManager.getUIHandler().post(new ngg(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ngf
 * JD-Core Version:    0.7.0.1
 */