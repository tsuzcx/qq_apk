import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyUploadAvatarActivity;
import com.tencent.mobileqq.troop.activity.TroopBarPublishActivity.Pic_list;
import com.tencent.mobileqq.troop.utils.TroopBarUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Hashtable;

public class lew
  extends Handler
{
  public lew(ReadInJoyUploadAvatarActivity paramReadInJoyUploadAvatarActivity, Looper paramLooper, String paramString)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    switch (paramMessage.what)
    {
    default: 
      localBundle.putString("msg", "上传失败");
      localBundle.putInt("retCode", 3);
      localIntent.putExtra("Bundle", localBundle);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyUploadAvatarActivity.setResult(-1, localIntent);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyUploadAvatarActivity.finish();
      return;
      paramMessage = (TroopBarPublishActivity.Pic_list)TroopBarUtils.a.get(this.jdField_a_of_type_JavaLangString);
      if (paramMessage != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d(ReadInJoyUploadAvatarActivity.jdField_a_of_type_JavaLangString, 2, "pic=" + paramMessage.url);
        }
        localBundle.putString("url", paramMessage.url);
      }
      localBundle.putInt("retCode", 0);
      localBundle.putString("msg", "上传成功");
      localIntent.putExtra("Bundle", localBundle);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyUploadAvatarActivity.setResult(-1, localIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lew
 * JD-Core Version:    0.7.0.1
 */