package com.tencent.mobileqq.jsp;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

class MediaApiPlugin$5
  implements Runnable
{
  MediaApiPlugin$5(MediaApiPlugin paramMediaApiPlugin, String paramString1, String paramString2, AtomicBoolean paramAtomicBoolean) {}
  
  public void run()
  {
    JSONObject localJSONObject = new JSONObject();
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    Object localObject2 = null;
    Object localObject1 = localObject2;
    try
    {
      if (this.a.startsWith("data:"))
      {
        int i = this.a.indexOf(',');
        localObject1 = localObject2;
        if (i > 0) {
          localObject1 = Base64Util.decode(this.a.substring(i), 0);
        }
      }
      if (localObject1 != null) {
        localObject1 = this.this$0.a((byte[])localObject1);
      }
    }
    catch (IOException localIOException)
    {
      break label173;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      break label146;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      label108:
      label119:
      break label119;
    }
    try
    {
      localJSONObject.put("retCode", 0);
      localJSONObject.put("msg", localBaseApplication.getString(2131915880));
      localJSONObject.put("imageID", localObject1);
    }
    catch (JSONException localJSONException)
    {
      break label108;
    }
    break label197;
    throw new IllegalArgumentException();
    localJSONObject.put("retCode", -1);
    localJSONObject.put("msg", localBaseApplication.getString(2131915881));
    break label197;
    label146:
    localJSONObject.put("retCode", 2);
    localJSONObject.put("msg", localBaseApplication.getString(2131915877));
    break label197;
    label173:
    localJSONObject.put("retCode", 1);
    localJSONObject.put("msg", localBaseApplication.getString(2131915879));
    label197:
    if ((!TextUtils.isEmpty(this.b)) && (this.c.compareAndSet(false, true)))
    {
      this.this$0.callJs(this.b, new String[] { localJSONObject.toString() });
      return;
    }
    this.this$0.callJs4OpenApiIfNeeded("saveImage", 0, localJSONObject.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.MediaApiPlugin.5
 * JD-Core Version:    0.7.0.1
 */