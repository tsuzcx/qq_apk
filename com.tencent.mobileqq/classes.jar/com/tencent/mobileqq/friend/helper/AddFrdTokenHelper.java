package com.tencent.mobileqq.friend.helper;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

public class AddFrdTokenHelper
{
  static final String jdField_a_of_type_JavaLangString = "AddFrdTokenHelper";
  private final ConcurrentHashMap<String, byte[]> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(5);
  
  public void a(String paramString, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length == 0) {
        return;
      }
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      try
      {
        paramString = String.format("%s_%s_%s", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, paramArrayOfByte);
        if (QLog.isColorLevel())
        {
          QLog.i(jdField_a_of_type_JavaLangString, 2, String.format("cacheToken key: %s, token_len: %s", new Object[] { paramString, Integer.valueOf(paramArrayOfByte.length) }));
          return;
        }
      }
      catch (Throwable paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public byte[] a(String paramString, int paramInt1, int paramInt2)
  {
    int i = 0;
    try
    {
      String str3 = String.format("%s_%s_%s", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      paramString = (byte[])this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str3);
      String str1 = paramString;
      try
      {
        if (!QLog.isColorLevel()) {
          break label118;
        }
        str1 = jdField_a_of_type_JavaLangString;
        if (paramString == null) {
          paramInt1 = i;
        } else {
          paramInt1 = paramString.length;
        }
        QLog.i(str1, 2, String.format("getCachedToken key: %s, token: %s", new Object[] { str3, Integer.valueOf(paramInt1) }));
        return paramString;
      }
      catch (Throwable localThrowable1) {}
      localThrowable2.printStackTrace();
    }
    catch (Throwable localThrowable2)
    {
      paramString = null;
    }
    String str2 = paramString;
    label118:
    return str2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.friend.helper.AddFrdTokenHelper
 * JD-Core Version:    0.7.0.1
 */