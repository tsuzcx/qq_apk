package com.tencent.tgpa.vendorpd.a;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class e
{
  public static boolean a(String paramString1, String paramString2, JSONArray paramJSONArray)
  {
    boolean bool = false;
    c localc = new c(paramString1);
    localc.a();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    for (;;)
    {
      if (i >= paramJSONArray.length()) {
        break label218;
      }
      try
      {
        Object localObject = paramJSONArray.getJSONObject(i);
        String str1 = ((JSONObject)localObject).getString("pkg");
        localObject = ((JSONObject)localObject).getString("md5");
        String str2 = localc.a(str1, (String)localObject);
        localc.b(str1, (String)localObject);
        if ((str2 != null) && (!str2.equals(paramString2))) {
          return true;
        }
        if ((str2 != null) && (str2.equals(paramString2))) {
          localArrayList.add(Integer.valueOf(i));
        }
        if (str2 == null) {
          g.b("SVR_PD: the predownload file is not dowloaded. filename: " + str1 + " , game: " + paramString1);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
          g.c("SVR_PD: the predownload file info is not correct, delete it, index: " + i + " , game: " + paramString1);
          localArrayList.add(Integer.valueOf(i));
        }
      }
      i += 1;
    }
    label218:
    if (localArrayList.size() == paramJSONArray.length()) {
      bool = true;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.tgpa.vendorpd.a.e
 * JD-Core Version:    0.7.0.1
 */