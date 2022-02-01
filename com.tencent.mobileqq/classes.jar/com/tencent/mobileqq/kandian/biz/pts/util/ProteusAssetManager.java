package com.tencent.mobileqq.kandian.biz.pts.util;

import android.content.Context;
import android.content.res.AssetManager;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ProteusAssetManager
{
  private static final String[] a = new String[0];
  private Map<String, String[]> b = new HashMap();
  
  public ProteusAssetManager(Context paramContext, String paramString)
  {
    a(paramContext, paramString);
  }
  
  private void a(Context paramContext, String paramString)
  {
    b(paramContext, paramString);
  }
  
  private boolean a(String paramString)
  {
    return (paramString == null) || (paramString.endsWith(".geojson")) || (paramString.equals("manifest"));
  }
  
  private void b(Context paramContext, String paramString)
  {
    try
    {
      String[] arrayOfString = paramContext.getAssets().list(paramString);
      if (arrayOfString != null)
      {
        this.b.put(paramString, arrayOfString);
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          String str = arrayOfString[i];
          if (!a(str))
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(paramString);
            localStringBuilder.append("/");
            localStringBuilder.append(str);
            b(paramContext, localStringBuilder.toString());
          }
          i += 1;
        }
      }
      return;
    }
    catch (IOException paramContext)
    {
      QLog.e("Q.readinjoy.proteus", 1, "addFolderChild", paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.util.ProteusAssetManager
 * JD-Core Version:    0.7.0.1
 */