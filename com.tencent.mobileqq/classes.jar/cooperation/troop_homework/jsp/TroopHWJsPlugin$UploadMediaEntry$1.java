package cooperation.troop_homework.jsp;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.troop_homework.TroopHomeworkHelper.UploadCallback;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

class TroopHWJsPlugin$UploadMediaEntry$1
  implements TroopHomeworkHelper.UploadCallback
{
  TroopHWJsPlugin$UploadMediaEntry$1(TroopHWJsPlugin.UploadMediaEntry paramUploadMediaEntry) {}
  
  public void a(int paramInt)
  {
    JSONObject localJSONObject = this.a.k.a(this.a.a.c, this.a.c, this.a.i, "uploading", "", 0);
    for (;;)
    {
      float f2;
      try
      {
        int i = this.a.i;
        f1 = 1.0F;
        if (i == 2)
        {
          f2 = paramInt / 100.0F * 0.85F + 0.1F;
          if (f2 <= 1.0F) {
            break label221;
          }
        }
        else
        {
          f1 = paramInt / 100.0F;
        }
        localJSONObject.put("progress", f1);
        if (QLog.isDevelopLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("id = ");
          localStringBuilder.append(this.a.c);
          localStringBuilder.append(" progress = ");
          localStringBuilder.append(paramInt);
          localStringBuilder.append(" realProgress = ");
          localStringBuilder.append(f1);
          QLog.d("TroopHWJsPlugin", 4, localStringBuilder.toString());
        }
        this.a.k.callJs(this.a.a.a, new String[] { localJSONObject.toString() });
        this.a.f = true;
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
      label221:
      float f1 = f2;
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onComplete id = ");
      ((StringBuilder)localObject).append(this.a.c);
      ((StringBuilder)localObject).append(" url = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("TroopHWJsPlugin", 2, ((StringBuilder)localObject).toString());
    }
    int i;
    if (this.a.i == 0) {
      i = 11;
    } else {
      i = 0;
    }
    if (this.a.i == 2) {
      localObject = "uploading";
    } else {
      localObject = "uploaded";
    }
    Object localObject = this.a.k.a(this.a.a.c, this.a.c, this.a.i, (String)localObject, paramString, i);
    this.a.e = paramString;
    try
    {
      ((JSONObject)localObject).put("result", 0);
      i = this.a.i;
      if (2 == i)
      {
        ((JSONObject)localObject).put("progress", 0.949999988079071D);
      }
      else if (this.a.i == 1)
      {
        ((JSONObject)localObject).put("progress", 1.0D);
        ((JSONObject)localObject).put("size", "[0,400,694,1000]");
      }
      else if (this.a.i == 0)
      {
        ((JSONObject)localObject).put("progress", 1.0D);
      }
      if (this.a.i != 2) {
        this.a.k.callJs(this.a.a.a, new String[] { ((JSONObject)localObject).toString() });
      }
      paramString = this.a;
      paramString.f = false;
      if (paramString.h.get()) {
        return;
      }
      if (this.a.i == 2)
      {
        paramString = new TroopHWJsPlugin.UploadMediaEntry.1.1(this);
        localObject = this.a.k;
        TroopHWJsPlugin.UploadMediaEntry localUploadMediaEntry = this.a;
        ThreadManager.postImmediately(new TroopHWJsPlugin.UploadVideoThumbJob((TroopHWJsPlugin)localObject, localUploadMediaEntry, paramString, TroopHWJsPlugin.b(localUploadMediaEntry.k)), null, false);
      }
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void b(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("upload failed! errorCode = ");
    ((StringBuilder)localObject).append(paramInt);
    QLog.d("TroopHWJsPlugin", 1, ((StringBuilder)localObject).toString());
    localObject = this.a;
    ((TroopHWJsPlugin.UploadMediaEntry)localObject).f = false;
    localObject = ((TroopHWJsPlugin.UploadMediaEntry)localObject).k.a(this.a.a.c, this.a.c, this.a.i, "uploaded", "", 0);
    try
    {
      ((JSONObject)localObject).put("result", paramInt);
    }
    catch (Exception localException)
    {
      QLog.e("TroopHWJsPlugin", 1, "upload error!", localException);
    }
    this.a.k.callJs(this.a.a.a, new String[] { ((JSONObject)localObject).toString() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.troop_homework.jsp.TroopHWJsPlugin.UploadMediaEntry.1
 * JD-Core Version:    0.7.0.1
 */