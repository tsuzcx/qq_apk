package com.tencent.mobileqq.jsp;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

class MediaApiPlugin$3
  implements Runnable
{
  MediaApiPlugin$3(MediaApiPlugin paramMediaApiPlugin, String paramString1, String paramString2, AtomicBoolean paramAtomicBoolean) {}
  
  public void run()
  {
    JSONObject localJSONObject = new JSONObject();
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    try
    {
      try
      {
        localObject = FileUtils.readFile(this.a);
        localObject = this.this$0.a((byte[])localObject);
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        label61:
        Object localObject = MediaApiPlugin.d;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("saveImage: ");
        localStringBuilder.append(QLog.getStackTraceString(localOutOfMemoryError));
        QLog.e((String)localObject, 2, localStringBuilder.toString());
      }
    }
    catch (IOException localIOException)
    {
      break label133;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      label109:
      break label109;
    }
    try
    {
      localJSONObject.put("retCode", 0);
      localJSONObject.put("msg", localBaseApplication.getString(2131915880));
      localJSONObject.put("imageID", localObject);
    }
    catch (JSONException localJSONException)
    {
      break label61;
    }
    break label154;
    localJSONObject.put("retCode", 2);
    localJSONObject.put("msg", localOutOfMemoryError.getString(2131915877));
    break label154;
    label133:
    localJSONObject.put("retCode", 1);
    localJSONObject.put("msg", localOutOfMemoryError.getString(2131915879));
    label154:
    if ((!TextUtils.isEmpty(this.b)) && (this.c.compareAndSet(false, true)))
    {
      this.this$0.callJs(this.b, new String[] { localJSONObject.toString() });
      return;
    }
    this.this$0.callJs4OpenApiIfNeeded("saveImage", 0, localJSONObject.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.MediaApiPlugin.3
 * JD-Core Version:    0.7.0.1
 */