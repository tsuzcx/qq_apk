package com.tencent.mobileqq.phonecontact.util;

import android.content.res.Resources;
import android.widget.ImageView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;

public class PhoneContactUtils
{
  public static String a(byte[] paramArrayOfByte, String paramString)
  {
    Object localObject = paramString;
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length == 0) {
        return paramString;
      }
      localObject = paramString.getBytes();
      int j = localObject.length;
      paramString = a(paramArrayOfByte);
      paramArrayOfByte = a((byte[])localObject);
      int i = 0;
      while (i < j)
      {
        paramString[i] = ((byte)(paramArrayOfByte[i] ^ paramString[i]));
        i += 1;
      }
      j = paramString.length - 1;
      i = j;
      while (i >= 0)
      {
        if (paramString[i] != 0) {
          break label89;
        }
        i -= 1;
      }
      i = 0;
      label89:
      paramArrayOfByte = paramString;
      if (i != j)
      {
        i += 1;
        paramArrayOfByte = new byte[i];
        System.arraycopy(paramString, 0, paramArrayOfByte, 0, i);
      }
      localObject = new String(a(paramArrayOfByte));
    }
    return localObject;
  }
  
  public static void a(AppInterface paramAppInterface, Resources paramResources, ImageView paramImageView)
  {
    if ((paramAppInterface != null) && (paramResources != null) && (paramImageView != null))
    {
      ThreadManager.excute(new PhoneContactUtils.1(paramResources, paramAppInterface, paramImageView), 16, null, true);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("IMCore.PhoneContact.PhoneContactUtils", 2, String.format("loadIconAsync [%s, %s, %s]", new Object[] { paramAppInterface, paramResources, paramImageView }));
    }
  }
  
  private static byte[] a(byte[] paramArrayOfByte)
  {
    int k = paramArrayOfByte.length - 1;
    int j = 0;
    while (k > j * 2)
    {
      int i = paramArrayOfByte[j];
      int m = k - j;
      paramArrayOfByte[j] = paramArrayOfByte[m];
      paramArrayOfByte[m] = i;
      j += 1;
    }
    return paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.phonecontact.util.PhoneContactUtils
 * JD-Core Version:    0.7.0.1
 */