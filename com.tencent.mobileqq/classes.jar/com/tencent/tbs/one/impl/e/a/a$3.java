package com.tencent.tbs.one.impl.e.a;

import android.content.Context;
import com.tencent.tbs.one.TBSOneManager;
import com.tencent.tbs.one.impl.a.c;
import com.tencent.tbs.one.impl.a.f;
import com.tencent.tbs.one.impl.common.h;
import com.tencent.tbs.one.impl.d.a.a;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

final class a$3
  implements a.a
{
  a$3(a parama, int paramInt) {}
  
  public final void a(int paramInt, Map<String, List<String>> paramMap, InputStream paramInputStream)
  {
    a locala = this.b;
    int i = this.a;
    Context localContext = locala.b;
    String str3 = locala.c;
    String str1 = locala.d;
    String str2 = locala.e;
    f.a("[%s] {%s} Receiving component information response: [%d] %s", new Object[] { str3, str2, Integer.valueOf(paramInt), paramMap });
    if ((paramInt != 200) || (paramInputStream == null))
    {
      locala.a(216, "Invalid component information stream, url: " + str1 + ", statusCode: " + paramInt, null);
      return;
    }
    try
    {
      paramMap = c.a(paramInputStream, "utf-8");
      paramInt = paramInputStream.optInt("TYPE");
    }
    catch (IOException paramMap)
    {
      try
      {
        paramInputStream = new JSONObject(paramMap);
        f.a("[%s] {%s} Receiving component information data %s", new Object[] { str3, str2, paramInputStream });
        paramInt = paramInputStream.optInt("CODE", -1);
        if (paramInt == 0) {
          break label315;
        }
        paramMap = paramInputStream.optString("MSG");
        locala.a(219, "Failed to request component " + str2 + " information, url: " + str1 + ", response code: " + paramInt + ", message: " + paramMap, null);
        return;
      }
      catch (JSONException paramInputStream)
      {
        locala.a(218, "Failed to parse component " + str2 + " information " + paramMap + ", url: " + str1, paramInputStream);
        return;
      }
      paramMap = paramMap;
      locala.a(217, "Failed to read component " + str2 + " information, url: " + str1, paramMap);
      return;
    }
    label315:
    if (paramInt == 1) {
      TBSOneManager.getInstance(localContext, locala.c).loadComponentAsync("extension", null);
    }
    locala.l = paramInt;
    locala.m = paramInputStream.optString("MD5");
    locala.n = paramInputStream.optLong("BYTE");
    locala.k = paramInputStream;
    paramMap = paramInputStream.optString("URL");
    f.a("[%s] {%s} Downloading component from %s", new Object[] { locala.c, locala.e, paramMap });
    if (locala.d()) {
      h.a(1015, locala.e);
    }
    for (;;)
    {
      locala.i = new com.tencent.tbs.one.impl.d.a(locala.b, paramMap);
      if (!locala.c()) {
        locala.i.g = true;
      }
      locala.i.f = new a.5(locala, paramMap, i);
      locala.i.a(new a.6(locala));
      return;
      h.a(1005, locala.e);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tbs.one.impl.e.a.a.3
 * JD-Core Version:    0.7.0.1
 */