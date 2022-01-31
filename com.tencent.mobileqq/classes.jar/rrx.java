import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.ugc.KandianVideoUploadService;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseListViewGroup;
import com.tencent.qphone.base.util.QLog;

public class rrx
  implements rpz
{
  public rrx(ReadInJoyBaseListViewGroup paramReadInJoyBaseListViewGroup) {}
  
  public void a(Bundle paramBundle)
  {
    String str = paramBundle.getString("mTaskID");
    ReadInJoyBaseListViewGroup.a(this.a, str);
    qod.b(paramBundle);
  }
  
  public void a(String paramString, Bundle paramBundle)
  {
    paramString = this.a.a();
    Intent localIntent;
    if ((paramBundle != null) && (paramString != null))
    {
      localIntent = new Intent();
      localIntent.putExtras(paramBundle);
      localIntent.setClass(paramString, KandianVideoUploadService.class);
    }
    try
    {
      paramString.startService(localIntent);
      return;
    }
    catch (Throwable paramString)
    {
      QLog.d("KandianVideoUpload", 1, "Kandian retryFail", paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rrx
 * JD-Core Version:    0.7.0.1
 */