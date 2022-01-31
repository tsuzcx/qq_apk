import android.content.Intent;
import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyUploadAvatarActivity;
import com.tencent.qphone.base.util.QLog;

public class nlz
  implements pwp
{
  public nlz(ReadInJoyUploadAvatarActivity paramReadInJoyUploadAvatarActivity) {}
  
  public void a() {}
  
  public void a(float paramFloat) {}
  
  public void a(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    QLog.d(ReadInJoyUploadAvatarActivity.a, 1, "onFileTransferFinished,retCode:" + paramInt + "  fileUrl:" + paramString1 + "  fileMd5:" + paramString2 + "  uuid:" + paramString3);
    paramString3 = this.a.getIntent();
    Bundle localBundle = new Bundle();
    switch (paramInt)
    {
    default: 
      paramString1 = "";
      paramString2 = "";
      paramInt = 3;
    }
    for (;;)
    {
      localBundle.putInt("retCode", paramInt);
      localBundle.putString("msg", paramString2);
      localBundle.putString("url", paramString1);
      paramString3.putExtra("Bundle", localBundle);
      this.a.setResult(-1, paramString3);
      this.a.finish();
      return;
      paramInt = 0;
      paramString2 = ajjy.a(2131647323);
      continue;
      paramString2 = ajjy.a(2131647328);
      paramString1 = "";
      paramInt = 2;
      continue;
      paramString2 = ajjy.a(2131647258);
      paramString1 = "";
      paramInt = 2;
      continue;
      paramString2 = ajjy.a(2131647053);
      paramString1 = "";
      paramInt = 3;
      continue;
      paramString2 = ajjy.a(2131647020);
      paramString1 = "";
      paramInt = 3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nlz
 * JD-Core Version:    0.7.0.1
 */