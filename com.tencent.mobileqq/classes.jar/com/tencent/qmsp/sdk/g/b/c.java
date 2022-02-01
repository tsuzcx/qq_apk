package com.tencent.qmsp.sdk.g.b;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.qmsp.sdk.base.IVendorCallback;
import com.tencent.qmsp.sdk.base.b;
import com.tencent.qmsp.sdk.base.f;
import java.security.MessageDigest;

public class c
  implements b
{
  private Context a;
  private IVendorCallback b;
  private String c = null;
  private boolean d = false;
  
  private String a(String paramString)
  {
    try
    {
      if (TextUtils.isEmpty(paramString)) {
        return "";
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("0x1008611");
      localStringBuilder.append(paramString);
      localStringBuilder.append("0xdzfdweiwu");
      paramString = b(localStringBuilder.toString());
      return paramString;
    }
    catch (Exception paramString) {}
    return "";
  }
  
  private String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    try
    {
      byte[] arrayOfByte = MessageDigest.getInstance("MD5").digest(paramString.getBytes());
      int j = arrayOfByte.length;
      int i = 0;
      paramString = "";
      while (i < j)
      {
        Object localObject2 = Integer.toHexString(arrayOfByte[i] & 0xFF);
        Object localObject1 = localObject2;
        if (((String)localObject2).length() == 1)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("0");
          ((StringBuilder)localObject1).append((String)localObject2);
          localObject1 = ((StringBuilder)localObject1).toString();
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramString);
        ((StringBuilder)localObject2).append((String)localObject1);
        paramString = ((StringBuilder)localObject2).toString();
        i += 1;
      }
      return paramString;
    }
    catch (Exception paramString) {}
    return "";
  }
  
  public String a()
  {
    return this.c;
  }
  
  public void a(Context paramContext, IVendorCallback paramIVendorCallback)
  {
    this.a = paramContext;
    this.b = paramIVendorCallback;
  }
  
  public String b()
  {
    return a(f.a(this.a));
  }
  
  public void c()
  {
    new Thread(new c.a(this)).start();
  }
  
  public boolean d()
  {
    return false;
  }
  
  public boolean e()
  {
    return false;
  }
  
  public void f() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qmsp.sdk.g.b.c
 * JD-Core Version:    0.7.0.1
 */