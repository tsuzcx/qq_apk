import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyUploadAvatarFragment;
import com.tencent.qphone.base.util.QLog;

public class onf
  implements rrm
{
  public onf(ReadInJoyUploadAvatarFragment paramReadInJoyUploadAvatarFragment) {}
  
  public void a() {}
  
  public void a(float paramFloat) {}
  
  public void a(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    QLog.d(ReadInJoyUploadAvatarFragment.a, 1, "onFileTransferFinished,retCode:" + paramInt + "  fileUrl:" + paramString1 + "  fileMd5:" + paramString2 + "  uuid:" + paramString3);
    paramString3 = this.a.getActivity();
    if (paramString3 == null)
    {
      QLog.e(ReadInJoyUploadAvatarFragment.a, 1, "onFileTransferFinished activity = null");
      return;
    }
    Bundle localBundle = new Bundle();
    switch (paramInt)
    {
    default: 
      QLog.e(ReadInJoyUploadAvatarFragment.a, 1, "onFileTransferFinished no handler, retCode=" + paramInt);
      paramString1 = "";
      paramString2 = "";
      paramInt = 3;
    }
    for (;;)
    {
      localBundle.putInt("retCode", paramInt);
      localBundle.putString("msg", paramString2);
      localBundle.putString("url", paramString1);
      paramString1 = paramString3.getIntent();
      paramString1.putExtra("Bundle", localBundle);
      paramString3.setResult(-1, paramString1);
      paramString3.finish();
      return;
      paramInt = 0;
      paramString2 = amtj.a(2131712226);
      continue;
      paramString2 = amtj.a(2131712231);
      paramString1 = "";
      paramInt = 2;
      continue;
      paramString2 = amtj.a(2131712161);
      paramString1 = "";
      paramInt = 2;
      continue;
      paramString2 = amtj.a(2131711956);
      paramString1 = "";
      paramInt = 3;
      continue;
      paramString2 = amtj.a(2131711923);
      paramString1 = "";
      paramInt = 3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     onf
 * JD-Core Version:    0.7.0.1
 */