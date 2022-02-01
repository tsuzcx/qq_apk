package com.tencent.qmsp.sdk.d;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.qmsp.sdk.a.c;
import com.tencent.qmsp.sdk.app.QmspSDK;
import com.tencent.qmsp.sdk.f.g;
import com.tencent.qmsp.sdk.f.k;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class b
{
  private List<d.b> a = new ArrayList();
  private SharedPreferences b = null;
  
  public b()
  {
    Context localContext = QmspSDK.getContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(com.tencent.qmsp.sdk.c.b.a);
    localStringBuilder.append(a(d.b));
    this.b = localContext.getSharedPreferences(localStringBuilder.toString(), 0);
  }
  
  private String a(String paramString1, String paramString2, String paramString3)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!paramString1.equals("1")))
    {
      if (paramString1.equals("2"))
      {
        paramString1 = QmspSDK.getContext().getExternalFilesDir(null);
      }
      else
      {
        paramString1 = "";
        break label57;
      }
    }
    else {
      paramString1 = QmspSDK.getContext().getFilesDir();
    }
    paramString1 = paramString1.getParent();
    label57:
    Object localObject = paramString1;
    if (!paramString1.endsWith(File.separator))
    {
      localObject = paramString1;
      if (!paramString2.startsWith(File.separator))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString1);
        ((StringBuilder)localObject).append(File.separator);
        localObject = ((StringBuilder)localObject).toString();
      }
    }
    paramString1 = new StringBuilder();
    paramString1.append((String)localObject);
    paramString1.append(paramString2);
    paramString1 = paramString1.toString();
    if (paramString2.endsWith(File.separator))
    {
      paramString2 = new StringBuilder();
    }
    else
    {
      paramString2 = new StringBuilder();
      paramString2.append(paramString1);
      paramString1 = File.separator;
    }
    paramString2.append(paramString1);
    paramString2.append(paramString3);
    return paramString2.toString();
  }
  
  private String a(byte[] paramArrayOfByte)
  {
    return k.a(paramArrayOfByte);
  }
  
  private boolean a(String paramString, long paramLong1, long paramLong2)
  {
    boolean bool5 = false;
    boolean bool6 = false;
    boolean bool4 = false;
    boolean bool3 = bool6;
    if (paramString != null)
    {
      if (!paramString.equals("android")) {
        return false;
      }
      boolean bool1 = paramLong1 < 0L;
      bool3 = bool6;
      if (!bool1)
      {
        boolean bool2 = paramLong2 < 0L;
        if (bool2) {
          return false;
        }
        long l = Build.VERSION.SDK_INT;
        if ((!bool1) && (!bool2)) {
          return true;
        }
        if ((!bool1) && (bool2))
        {
          bool3 = bool4;
          if (l <= paramLong2) {
            bool3 = true;
          }
          return bool3;
        }
        if ((bool1) && (!bool2))
        {
          bool3 = bool5;
          if (l >= paramLong1) {
            bool3 = true;
          }
          return bool3;
        }
        bool3 = bool6;
        if (bool1)
        {
          bool3 = bool6;
          if (bool2)
          {
            bool3 = bool6;
            if (l >= paramLong1)
            {
              bool3 = bool6;
              if (l <= paramLong2) {
                bool3 = true;
              }
            }
          }
        }
      }
    }
    return bool3;
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    boolean bool2 = false;
    boolean bool1;
    boolean bool3;
    String str;
    if (paramString1 != null)
    {
      if (paramString2 == null) {
        return false;
      }
      paramString1 = paramString1.replace(" ", "");
      paramString2 = paramString2.replace(" ", "");
      bool1 = paramString1.equals("*");
      bool3 = paramString2.equals("*");
      if ((bool1) && (bool3)) {
        return true;
      }
      str = c.c();
      if (TextUtils.isEmpty(str)) {
        return false;
      }
      if ((!bool1) || (bool3)) {}
    }
    try
    {
      if (b(str, paramString2) > 0) {
        break label170;
      }
      return true;
    }
    catch (Exception paramString1)
    {
      int i;
      label164:
      label170:
      break label164;
    }
    if ((!bool1) && (bool3))
    {
      if (b(str, paramString1) >= 0) {
        return true;
      }
    }
    else
    {
      if ((!bool1) && (!bool3))
      {
        bool1 = bool2;
        if (b(str, paramString2) <= 0)
        {
          i = b(str, paramString1);
          bool1 = bool2;
          if (i >= 0) {
            bool1 = true;
          }
        }
        return bool1;
        paramString1.printStackTrace();
      }
      return false;
      return false;
    }
    return false;
  }
  
  private int b(String paramString1, String paramString2)
  {
    paramString1 = paramString1.split("\\.");
    paramString2 = paramString2.split("\\.");
    int i;
    if (paramString1.length < paramString2.length) {
      i = paramString1.length;
    } else {
      i = paramString2.length;
    }
    int j = 0;
    while (j < i)
    {
      int k = Integer.parseInt(paramString1[j]);
      int m = Integer.parseInt(paramString2[j]);
      if (k > m) {
        return 1;
      }
      if (k < m) {
        return -1;
      }
      j += 1;
    }
    return 0;
  }
  
  private String b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(com.tencent.qmsp.sdk.a.b.c());
    localStringBuilder.append(a(d.a));
    return localStringBuilder.toString();
  }
  
  private boolean b(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    Object localObject = paramString.replace(" ", "");
    if (((String)localObject).equals("*")) {
      return true;
    }
    paramString = Build.CPU_ABI;
    localObject = ((String)localObject).split(",");
    if (localObject == null) {
      return false;
    }
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      if (paramString.contains(localObject[i])) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  private boolean c(String paramString)
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      paramString = new JSONObject(paramString);
      paramString.getLong(a(d.g[0]));
      paramString.getBoolean(a(d.g[1]));
      paramString = paramString.getJSONArray(a(d.g[2]));
      int i = 0;
      while (i < paramString.length())
      {
        d.b localb = new d.b();
        Object localObject = paramString.getJSONObject(i);
        localb.a = ((JSONObject)localObject).getLong(a(d.g[3]));
        localb.b = ((JSONObject)localObject).getLong(a(d.g[4]));
        ((JSONObject)localObject).getLong(a(d.g[7]));
        localb.c = ((JSONObject)localObject).getString(a(d.g[5]));
        localb.d = ((JSONObject)localObject).getString(a(d.g[6]));
        localb.e = ((JSONObject)localObject).getString(a(d.g[8]));
        localb.f = ((JSONObject)localObject).getLong(a(d.g[15]));
        localb.g = ((JSONObject)localObject).getLong(a(d.g[16]));
        localb.j = ((JSONObject)localObject).getString(a(d.g[18]));
        localb.h = ((JSONObject)localObject).getString(a(d.g[10]));
        localb.i = ((JSONObject)localObject).getString(a(d.g[11]));
        localb.k = ((JSONObject)localObject).getString(a(d.g[9]));
        localb.m = a(localb.k, localb.f, localb.g);
        localb.n = b(localb.j);
        localb.l = a(localb.h, localb.i);
        if (((JSONObject)localObject).has(a(d.g[20]))) {
          localb.u = ((JSONObject)localObject).getInt(a(d.g[20]));
        }
        localObject = ((JSONObject)localObject).getJSONArray(a(d.g[12]));
        int j = 0;
        while (j < ((JSONArray)localObject).length())
        {
          JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(j);
          d.a locala = new d.a();
          localJSONObject.getLong(a(d.g[7]));
          locala.d = localJSONObject.getString(a(d.g[13]));
          locala.e = localJSONObject.getString(a(d.g[14]));
          locala.a = localJSONObject.getString(a(d.g[5]));
          locala.f = a(locala.d, locala.e, locala.a);
          locala.b = localJSONObject.getString(a(d.g[6]));
          locala.h = localJSONObject.getLong(a(d.g[17]));
          if (localJSONObject.has(a(d.g[19]))) {
            locala.i = localJSONObject.getString(a(d.g[19]));
          }
          localb.o.add(locala);
          j += 1;
        }
        localArrayList.add(localb);
        i += 1;
      }
      this.a = localArrayList;
      return true;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      g.a("Qp.QPUpdate", 1, "[SFU] parsing config error");
    }
    return false;
  }
  
  public List<d.b> a()
  {
    return this.a;
  }
  
  public List<d.b> a(long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    if ((a(b())) && (!this.a.isEmpty()))
    {
      int i = 0;
      while (i < this.a.size())
      {
        d.b localb = (d.b)this.a.get(i);
        if (localb.b == paramLong)
        {
          int j = 0;
          d.a locala;
          while (j < localb.o.size())
          {
            locala = (d.a)localb.o.get(j);
            locala.g = this.b.getString(locala.f, "");
            j += 1;
          }
          j = 0;
          while (j < localb.q.size())
          {
            locala = (d.a)localb.q.get(j);
            locala.g = this.b.getString(locala.f, "");
            j += 1;
          }
          j = 0;
          while (j < localb.p.size())
          {
            locala = (d.a)localb.p.get(j);
            locala.g = this.b.getString(locala.f, "");
            j += 1;
          }
          localArrayList.add(localb);
        }
        i += 1;
      }
    }
    return localArrayList;
  }
  
  public boolean a(String paramString)
  {
    byte[] arrayOfByte = e.a(new File(paramString), null);
    if (arrayOfByte != null) {
      return c(new String(arrayOfByte));
    }
    g.a("Qp.QPUpdate", 1, String.format("[SFU] invalid sig of config: %s", new Object[] { paramString }));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qmsp.sdk.d.b
 * JD-Core Version:    0.7.0.1
 */