package com.tencent.mobileqq.microapp.appbrand.a.a;

import android.text.TextUtils;
import com.tencent.mobileqq.microapp.appbrand.utils.b;
import com.tencent.mobileqq.microapp.webview.BaseAppBrandWebview;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class k
  implements f.a
{
  k(f paramf, String paramString1, BaseAppBrandWebview paramBaseAppBrandWebview, String paramString2, int paramInt) {}
  
  public String a()
  {
    Object localObject = b.a().d(this.a);
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return f.a(this.e, this.b, this.c, null, "no such file or directory, open " + this.a, this.d);
    }
    if (!new File((String)localObject).isDirectory()) {
      return f.a(this.e, this.b, this.c, null, "not a directory " + this.a, this.d);
    }
    File[] arrayOfFile = new File((String)localObject).listFiles();
    localObject = new JSONObject();
    JSONArray localJSONArray = new JSONArray();
    if (arrayOfFile != null)
    {
      int j = arrayOfFile.length;
      int i = 0;
      while (i < j)
      {
        File localFile = arrayOfFile[i];
        if (localFile != null) {
          localJSONArray.put(localFile.getName());
        }
        i += 1;
      }
    }
    try
    {
      ((JSONObject)localObject).put("files", localJSONArray);
      label202:
      return f.a(this.e, this.b, this.c, (JSONObject)localObject, this.d);
    }
    catch (JSONException localJSONException)
    {
      break label202;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.appbrand.a.a.k
 * JD-Core Version:    0.7.0.1
 */