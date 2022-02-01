import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyUploadAvatarFragment;

public class okk
  extends Handler
{
  public okk(ReadInJoyUploadAvatarFragment paramReadInJoyUploadAvatarFragment, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    FragmentActivity localFragmentActivity = this.a.getActivity();
    if (localFragmentActivity == null) {
      return;
    }
    Intent localIntent = localFragmentActivity.getIntent();
    Bundle localBundle = new Bundle();
    switch (paramMessage.what)
    {
    default: 
      localBundle.putString("msg", anni.a(2131711797));
      localBundle.putInt("retCode", 3);
      localIntent.putExtra("Bundle", localBundle);
      localFragmentActivity.setResult(-1, localIntent);
    }
    for (;;)
    {
      localFragmentActivity.finish();
      return;
      localBundle.putString("url", (String)paramMessage.obj);
      localBundle.putInt("retCode", 0);
      localBundle.putString("msg", anni.a(2131711856));
      localIntent.putExtra("Bundle", localBundle);
      localFragmentActivity.setResult(-1, localIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     okk
 * JD-Core Version:    0.7.0.1
 */