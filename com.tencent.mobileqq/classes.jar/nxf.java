import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyUploadAvatarActivity;

public class nxf
  extends Handler
{
  public nxf(ReadInJoyUploadAvatarActivity paramReadInJoyUploadAvatarActivity, Looper paramLooper)
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
      localBundle.putString("msg", ajya.a(2131713034));
      localBundle.putInt("retCode", 3);
      localIntent.putExtra("Bundle", localBundle);
      this.a.setResult(-1, localIntent);
    }
    for (;;)
    {
      if (!localIntent.getBooleanExtra("finish", false))
      {
        localIntent.setClassName("com.tencent.mobileqq", PublicAccountBrowser.class.getName());
        localIntent.addFlags(603979776);
        this.a.startActivity(localIntent);
      }
      this.a.finish();
      return;
      localBundle.putString("url", (String)paramMessage.obj);
      localBundle.putInt("retCode", 0);
      localBundle.putString("msg", ajya.a(2131713093));
      localIntent.putExtra("Bundle", localBundle);
      this.a.setResult(-1, localIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nxf
 * JD-Core Version:    0.7.0.1
 */