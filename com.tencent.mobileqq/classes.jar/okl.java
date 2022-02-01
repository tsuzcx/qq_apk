import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyUploadAvatarFragment;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyUploadAvatarFragment.3;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class okl
  implements bfpo
{
  public okl(ReadInJoyUploadAvatarFragment.3 param3) {}
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(ReadInJoyUploadAvatarFragment.a, 2, "uploadImage->onResult");
    }
    if (paramJSONObject != null)
    {
      paramInt = paramJSONObject.optInt("retcode");
      if (paramJSONObject.optJSONObject("result") != null) {}
      for (paramJSONObject = paramJSONObject.optJSONObject("result").optString("url");; paramJSONObject = null)
      {
        paramBundle = new Message();
        if ((paramInt == 0) && (!TextUtils.isEmpty(paramJSONObject)))
        {
          paramBundle.what = 1003;
          paramBundle.obj = paramJSONObject;
        }
        this.a.a.sendMessage(paramBundle);
        return;
      }
    }
    this.a.a.sendMessage(new Message());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     okl
 * JD-Core Version:    0.7.0.1
 */