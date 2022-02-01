package com.tencent.qmsp.sdk.b;

import com.tencent.qmsp.sdk.c.f;
import com.tencent.qmsp.sdk.f.g;
import com.tencent.qmsp.sdk.f.k;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class d
{
  private static byte[][] a = { { 16, 99, -74, 82, 99, 26, 112, -8, 43, 100 }, { 8, 127, -87, 73, 34, 55, 118, -78, 113, 62, -29, 0, 102, 56, 120, -16, 53, 113, -89, 73, 44, 55, 114, -90, 101, 93, -128, 105, 11, 123, 34, -77, 117, 43, -13, 119, 39, 53, 115, -14, 50, 99, -13, 110, 26, 96, 55, -39, 44, 119, -106, 88, 58, 114 }, { 20, 96, -3, 68, 33, 44, 121 } };
  
  public static String a(int paramInt)
  {
    return k.a(a[paramInt]);
  }
  
  public static void a(b paramb)
  {
    String str = paramb.a;
    Object localObject1 = paramb.d;
    Object localObject3 = paramb.c;
    paramb = new c(paramb);
    try
    {
      localObject2 = (HttpURLConnection)new URL(str).openConnection();
      if (!(localObject2 instanceof HttpURLConnection)) {
        return;
      }
      ((HttpURLConnection)localObject2).setConnectTimeout(3000);
      ((HttpURLConnection)localObject2).setRequestProperty(a(0), a(1));
      localObject2 = ((HttpURLConnection)localObject2).getInputStream();
      byte[] arrayOfByte = a((InputStream)localObject2);
      localObject3 = new File((String)localObject3);
      if (!((File)localObject3).exists()) {
        ((File)localObject3).mkdir();
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localObject3);
      localStringBuilder.append(File.separator);
      localStringBuilder.append((String)localObject1);
      localObject1 = new FileOutputStream(new File(localStringBuilder.toString()));
      ((FileOutputStream)localObject1).write(arrayOfByte);
      ((FileOutputStream)localObject1).close();
      if (localObject2 != null) {
        ((InputStream)localObject2).close();
      }
      paramb.a = 0;
      localObject1 = a(2);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("dwl:");
      ((StringBuilder)localObject2).append(str);
      ((StringBuilder)localObject2).append("  ok");
      g.c((String)localObject1, 0, ((StringBuilder)localObject2).toString());
    }
    catch (Exception localException)
    {
      Object localObject2;
      label224:
      break label224;
    }
    paramb.a = 1;
    localObject1 = a(2);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("dwl:");
    ((StringBuilder)localObject2).append(str);
    ((StringBuilder)localObject2).append("  fail");
    g.c((String)localObject1, 0, ((StringBuilder)localObject2).toString());
    f.i().d().a(paramb);
  }
  
  public static byte[] a(InputStream paramInputStream)
  {
    byte[] arrayOfByte = new byte[1024];
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte);
      if (i == -1) {
        break;
      }
      localByteArrayOutputStream.write(arrayOfByte, 0, i);
    }
    localByteArrayOutputStream.close();
    return localByteArrayOutputStream.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qmsp.sdk.b.d
 * JD-Core Version:    0.7.0.1
 */