package com.tencent.mobileqq.relationx.addFrd;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

public class AddFrdTokenHelper
{
  static final String jdField_a_of_type_JavaLangString = AddFrdTokenHelper.class.getSimpleName();
  private final ConcurrentHashMap<String, byte[]> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(5);
  
  public void a(String paramString, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {}
    for (;;)
    {
      return;
      if (!TextUtils.isEmpty(paramString)) {
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
  }
  
  /* Error */
  public byte[] a(String paramString, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: ldc 40
    //   2: iconst_3
    //   3: anewarray 4	java/lang/Object
    //   6: dup
    //   7: iconst_0
    //   8: aload_1
    //   9: aastore
    //   10: dup
    //   11: iconst_1
    //   12: iload_2
    //   13: invokestatic 46	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   16: aastore
    //   17: dup
    //   18: iconst_2
    //   19: iload_3
    //   20: invokestatic 46	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   23: aastore
    //   24: invokestatic 52	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   27: astore 4
    //   29: aload_0
    //   30: getfield 29	com/tencent/mobileqq/relationx/addFrd/AddFrdTokenHelper:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   33: aload 4
    //   35: invokevirtual 76	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   38: checkcast 78	[B
    //   41: astore_1
    //   42: invokestatic 62	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   45: ifeq +65 -> 110
    //   48: getstatic 18	com/tencent/mobileqq/relationx/addFrd/AddFrdTokenHelper:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   51: astore 5
    //   53: aload_1
    //   54: ifnonnull +34 -> 88
    //   57: iconst_0
    //   58: istore_2
    //   59: aload 5
    //   61: iconst_2
    //   62: ldc 80
    //   64: iconst_2
    //   65: anewarray 4	java/lang/Object
    //   68: dup
    //   69: iconst_0
    //   70: aload 4
    //   72: aastore
    //   73: dup
    //   74: iconst_1
    //   75: iload_2
    //   76: invokestatic 46	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   79: aastore
    //   80: invokestatic 52	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   83: invokestatic 68	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   86: aload_1
    //   87: areturn
    //   88: aload_1
    //   89: arraylength
    //   90: istore_2
    //   91: goto -32 -> 59
    //   94: astore 4
    //   96: aconst_null
    //   97: astore_1
    //   98: aload 4
    //   100: invokevirtual 71	java/lang/Throwable:printStackTrace	()V
    //   103: aload_1
    //   104: areturn
    //   105: astore 4
    //   107: goto -9 -> 98
    //   110: aload_1
    //   111: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	112	0	this	AddFrdTokenHelper
    //   0	112	1	paramString	String
    //   0	112	2	paramInt1	int
    //   0	112	3	paramInt2	int
    //   27	44	4	str1	String
    //   94	5	4	localThrowable1	Throwable
    //   105	1	4	localThrowable2	Throwable
    //   51	9	5	str2	String
    // Exception table:
    //   from	to	target	type
    //   0	42	94	java/lang/Throwable
    //   42	53	105	java/lang/Throwable
    //   59	86	105	java/lang/Throwable
    //   88	91	105	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.relationx.addFrd.AddFrdTokenHelper
 * JD-Core Version:    0.7.0.1
 */