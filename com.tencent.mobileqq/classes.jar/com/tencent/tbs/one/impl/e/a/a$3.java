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
    Object localObject = locala.b;
    String str3 = locala.c;
    String str1 = locala.d;
    String str2 = locala.e;
    f.a("[%s] {%s} Receiving component information response: [%d] %s", new Object[] { str3, str2, Integer.valueOf(paramInt), paramMap });
    if ((paramInt == 200) && (paramInputStream != null)) {
      try
      {
        paramMap = c.a(paramInputStream, "utf-8");
        try
        {
          paramInputStream = new JSONObject(paramMap);
          f.a("[%s] {%s} Receiving component information data %s", new Object[] { str3, str2, paramInputStream });
          paramInt = paramInputStream.optInt("CODE", -1);
          if (paramInt != 0)
          {
            paramMap = paramInputStream.optString("MSG");
            paramInputStream = new StringBuilder("Failed to request component ");
            paramInputStream.append(str2);
            paramInputStream.append(" information, url: ");
            paramInputStream.append(str1);
            paramInputStream.append(", response code: ");
            paramInputStream.append(paramInt);
            paramInputStream.append(", message: ");
            paramInputStream.append(paramMap);
            locala.a(219, paramInputStream.toString(), null);
            return;
          }
          paramInt = paramInputStream.optInt("TYPE");
          if (paramInt == 1) {
            TBSOneManager.getInstance((Context)localObject, locala.c).loadComponentAsync("extension", null);
          }
          locala.l = paramInt;
          locala.m = paramInputStream.optString("MD5");
          locala.n = paramInputStream.optLong("BYTE");
          locala.k = paramInputStream;
          paramMap = paramInputStream.optString("URL");
          f.a("[%s] {%s} Downloading component from %s", new Object[] { locala.c, locala.e, paramMap });
          if (locala.d()) {
            h.a(1015, locala.e);
          } else {
            h.a(1005, locala.e);
          }
          locala.i = new com.tencent.tbs.one.impl.d.a(locala.b, paramMap);
          if (!locala.c()) {
            locala.i.g = true;
          }
          locala.i.f = new a.5(locala, paramMap, i);
          locala.i.a(new a.6(locala));
          return;
        }
        catch (JSONException paramInputStream)
        {
          localObject = new StringBuilder("Failed to parse component ");
          ((StringBuilder)localObject).append(str2);
          ((StringBuilder)localObject).append(" information ");
          ((StringBuilder)localObject).append(paramMap);
          ((StringBuilder)localObject).append(", url: ");
          ((StringBuilder)localObject).append(str1);
          locala.a(218, ((StringBuilder)localObject).toString(), paramInputStream);
          return;
        }
        paramMap = new StringBuilder("Invalid component information stream, url: ");
      }
      catch (IOException paramMap)
      {
        paramInputStream = new StringBuilder("Failed to read component ");
        paramInputStream.append(str2);
        paramInputStream.append(" information, url: ");
        paramInputStream.append(str1);
        locala.a(217, paramInputStream.toString(), paramMap);
        return;
      }
    }
    paramMap.append(str1);
    paramMap.append(", statusCode: ");
    paramMap.append(paramInt);
    locala.a(216, paramMap.toString(), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tbs.one.impl.e.a.a.3
 * JD-Core Version:    0.7.0.1
 */