import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyUploadAvatarActivity;

public class oal
  extends Handler
{
  public oal(ReadInJoyUploadAvatarActivity paramReadInJoyUploadAvatarActivity, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    Intent localIntent = this.a.getIntent();
    Bundle localBundle = new Bundle();
    switch (paramMessage.what)
    {
    default: 
      localBundle.putString("msg", alud.a(2131713418));
      localBundle.putInt("retCode", 3);
      localIntent.putExtra("Bundle", localBundle);
      this.a.setResult(-1, localIntent);
    }
    for (;;)
    {
      this.a.finish();
      return;
      localBundle.putString("url", (String)paramMessage.obj);
      localBundle.putInt("retCode", 0);
      localBundle.putString("msg", alud.a(2131713477));
      localIntent.putExtra("Bundle", localBundle);
      this.a.setResult(-1, localIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     oal
 * JD-Core Version:    0.7.0.1
 */