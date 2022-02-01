package com.tencent.mobileqq.utils.kapalaiadapter.sdcardmountinforutil;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.storage.StorageManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class SDCardMountInforUtil
  implements ISDCardMountInfor
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private final File jdField_a_of_type_JavaIoFile;
  public final String a;
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList;
  private final File jdField_b_of_type_JavaIoFile;
  private ArrayList<String> jdField_b_of_type_JavaUtilArrayList;
  
  /* Error */
  private void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 23	com/tencent/mobileqq/utils/kapalaiadapter/sdcardmountinforutil/SDCardMountInforUtil:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   4: invokevirtual 28	java/util/ArrayList:clear	()V
    //   7: new 30	java/io/BufferedReader
    //   10: dup
    //   11: new 32	java/io/FileReader
    //   14: dup
    //   15: aload_0
    //   16: getfield 34	com/tencent/mobileqq/utils/kapalaiadapter/sdcardmountinforutil/SDCardMountInforUtil:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   19: invokespecial 38	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   22: invokespecial 41	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   25: astore_2
    //   26: aload_2
    //   27: astore_1
    //   28: aload_2
    //   29: invokevirtual 45	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   32: astore_3
    //   33: aload_3
    //   34: ifnull +48 -> 82
    //   37: aload_2
    //   38: astore_1
    //   39: aload_3
    //   40: ldc 47
    //   42: invokevirtual 53	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   45: ifeq -19 -> 26
    //   48: aload_2
    //   49: astore_1
    //   50: aload_0
    //   51: getfield 23	com/tencent/mobileqq/utils/kapalaiadapter/sdcardmountinforutil/SDCardMountInforUtil:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   54: aload_3
    //   55: invokevirtual 57	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   58: pop
    //   59: goto -33 -> 26
    //   62: astore_3
    //   63: aload_2
    //   64: astore_1
    //   65: aload_3
    //   66: invokevirtual 60	java/lang/Exception:printStackTrace	()V
    //   69: aload_2
    //   70: ifnull +7 -> 77
    //   73: aload_2
    //   74: invokevirtual 63	java/io/BufferedReader:close	()V
    //   77: aload_0
    //   78: invokespecial 66	com/tencent/mobileqq/utils/kapalaiadapter/sdcardmountinforutil/SDCardMountInforUtil:d	()V
    //   81: return
    //   82: aload_2
    //   83: astore_1
    //   84: aload_0
    //   85: getfield 23	com/tencent/mobileqq/utils/kapalaiadapter/sdcardmountinforutil/SDCardMountInforUtil:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   88: invokevirtual 69	java/util/ArrayList:trimToSize	()V
    //   91: aload_2
    //   92: ifnull -15 -> 77
    //   95: aload_2
    //   96: invokevirtual 63	java/io/BufferedReader:close	()V
    //   99: goto -22 -> 77
    //   102: astore_1
    //   103: aload_1
    //   104: invokevirtual 60	java/lang/Exception:printStackTrace	()V
    //   107: goto -30 -> 77
    //   110: astore_1
    //   111: aload_1
    //   112: invokevirtual 60	java/lang/Exception:printStackTrace	()V
    //   115: goto -38 -> 77
    //   118: astore_2
    //   119: aconst_null
    //   120: astore_1
    //   121: aload_1
    //   122: ifnull +7 -> 129
    //   125: aload_1
    //   126: invokevirtual 63	java/io/BufferedReader:close	()V
    //   129: aload_2
    //   130: athrow
    //   131: astore_1
    //   132: aload_1
    //   133: invokevirtual 60	java/lang/Exception:printStackTrace	()V
    //   136: goto -7 -> 129
    //   139: astore_2
    //   140: goto -19 -> 121
    //   143: astore_3
    //   144: aconst_null
    //   145: astore_2
    //   146: goto -83 -> 63
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	149	0	this	SDCardMountInforUtil
    //   27	57	1	localBufferedReader1	java.io.BufferedReader
    //   102	2	1	localException1	Exception
    //   110	2	1	localException2	Exception
    //   120	6	1	localObject1	Object
    //   131	2	1	localException3	Exception
    //   25	71	2	localBufferedReader2	java.io.BufferedReader
    //   118	12	2	localObject2	Object
    //   139	1	2	localObject3	Object
    //   145	1	2	localObject4	Object
    //   32	23	3	str	String
    //   62	4	3	localException4	Exception
    //   143	1	3	localException5	Exception
    // Exception table:
    //   from	to	target	type
    //   28	33	62	java/lang/Exception
    //   39	48	62	java/lang/Exception
    //   50	59	62	java/lang/Exception
    //   84	91	62	java/lang/Exception
    //   95	99	102	java/lang/Exception
    //   73	77	110	java/lang/Exception
    //   7	26	118	finally
    //   125	129	131	java/lang/Exception
    //   28	33	139	finally
    //   39	48	139	finally
    //   50	59	139	finally
    //   65	69	139	finally
    //   84	91	139	finally
    //   7	26	143	java/lang/Exception
  }
  
  private void a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      c();
      return;
    case 0: 
      a();
      return;
    }
    b();
  }
  
  private boolean a(String paramString)
  {
    if (paramString == null) {}
    for (;;)
    {
      return false;
      paramString = new File(paramString);
      if ((!paramString.exists()) || (paramString.list() == null)) {
        break;
      }
      paramString = paramString.list();
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        String str = paramString[i];
        if (QLog.isColorLevel()) {
          QLog.i("kapalai", 2, "--------" + str);
        }
        i += 1;
      }
    }
    return true;
  }
  
  /* Error */
  private void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 23	com/tencent/mobileqq/utils/kapalaiadapter/sdcardmountinforutil/SDCardMountInforUtil:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   4: invokevirtual 28	java/util/ArrayList:clear	()V
    //   7: new 30	java/io/BufferedReader
    //   10: dup
    //   11: new 32	java/io/FileReader
    //   14: dup
    //   15: aload_0
    //   16: getfield 119	com/tencent/mobileqq/utils/kapalaiadapter/sdcardmountinforutil/SDCardMountInforUtil:jdField_b_of_type_JavaIoFile	Ljava/io/File;
    //   19: invokespecial 38	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   22: invokespecial 41	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   25: astore_2
    //   26: aload_2
    //   27: astore_1
    //   28: aload_2
    //   29: invokevirtual 45	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   32: astore_3
    //   33: aload_3
    //   34: ifnull +48 -> 82
    //   37: aload_2
    //   38: astore_1
    //   39: aload_3
    //   40: ldc 121
    //   42: invokevirtual 53	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   45: ifeq -19 -> 26
    //   48: aload_2
    //   49: astore_1
    //   50: aload_0
    //   51: getfield 23	com/tencent/mobileqq/utils/kapalaiadapter/sdcardmountinforutil/SDCardMountInforUtil:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   54: aload_3
    //   55: invokevirtual 57	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   58: pop
    //   59: goto -33 -> 26
    //   62: astore_3
    //   63: aload_2
    //   64: astore_1
    //   65: aload_3
    //   66: invokevirtual 60	java/lang/Exception:printStackTrace	()V
    //   69: aload_2
    //   70: ifnull +7 -> 77
    //   73: aload_2
    //   74: invokevirtual 63	java/io/BufferedReader:close	()V
    //   77: aload_0
    //   78: invokespecial 66	com/tencent/mobileqq/utils/kapalaiadapter/sdcardmountinforutil/SDCardMountInforUtil:d	()V
    //   81: return
    //   82: aload_2
    //   83: astore_1
    //   84: aload_0
    //   85: getfield 23	com/tencent/mobileqq/utils/kapalaiadapter/sdcardmountinforutil/SDCardMountInforUtil:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   88: invokevirtual 69	java/util/ArrayList:trimToSize	()V
    //   91: aload_2
    //   92: ifnull -15 -> 77
    //   95: aload_2
    //   96: invokevirtual 63	java/io/BufferedReader:close	()V
    //   99: goto -22 -> 77
    //   102: astore_1
    //   103: aload_1
    //   104: invokevirtual 60	java/lang/Exception:printStackTrace	()V
    //   107: goto -30 -> 77
    //   110: astore_1
    //   111: aload_1
    //   112: invokevirtual 60	java/lang/Exception:printStackTrace	()V
    //   115: goto -38 -> 77
    //   118: astore_2
    //   119: aconst_null
    //   120: astore_1
    //   121: aload_1
    //   122: ifnull +7 -> 129
    //   125: aload_1
    //   126: invokevirtual 63	java/io/BufferedReader:close	()V
    //   129: aload_2
    //   130: athrow
    //   131: astore_1
    //   132: aload_1
    //   133: invokevirtual 60	java/lang/Exception:printStackTrace	()V
    //   136: goto -7 -> 129
    //   139: astore_2
    //   140: goto -19 -> 121
    //   143: astore_3
    //   144: aconst_null
    //   145: astore_2
    //   146: goto -83 -> 63
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	149	0	this	SDCardMountInforUtil
    //   27	57	1	localBufferedReader1	java.io.BufferedReader
    //   102	2	1	localException1	Exception
    //   110	2	1	localException2	Exception
    //   120	6	1	localObject1	Object
    //   131	2	1	localException3	Exception
    //   25	71	2	localBufferedReader2	java.io.BufferedReader
    //   118	12	2	localObject2	Object
    //   139	1	2	localObject3	Object
    //   145	1	2	localObject4	Object
    //   32	23	3	str	String
    //   62	4	3	localException4	Exception
    //   143	1	3	localException5	Exception
    // Exception table:
    //   from	to	target	type
    //   28	33	62	java/lang/Exception
    //   39	48	62	java/lang/Exception
    //   50	59	62	java/lang/Exception
    //   84	91	62	java/lang/Exception
    //   95	99	102	java/lang/Exception
    //   73	77	110	java/lang/Exception
    //   7	26	118	finally
    //   125	129	131	java/lang/Exception
    //   28	33	139	finally
    //   39	48	139	finally
    //   50	59	139	finally
    //   65	69	139	finally
    //   84	91	139	finally
    //   7	26	143	java/lang/Exception
  }
  
  @TargetApi(9)
  private void c()
  {
    if (this.jdField_a_of_type_Int == 2)
    {
      this.jdField_b_of_type_JavaUtilArrayList.clear();
      Object localObject = (StorageManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("storage");
      try
      {
        localObject = (String[])localObject.getClass().getMethod("getVolumePaths", null).invoke(localObject, null);
        int i = 0;
        int j = localObject.length;
        while ((i < j) && (!a(localObject[i])))
        {
          this.jdField_b_of_type_JavaUtilArrayList.add(i, localObject[i]);
          i += 1;
        }
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  private void d()
  {
    this.jdField_b_of_type_JavaUtilArrayList.clear();
    int i = 0;
    int k;
    for (int j = 0; i < this.jdField_a_of_type_JavaUtilArrayList.size(); j = k)
    {
      k = j;
      if (this.jdField_a_of_type_JavaUtilArrayList.get(i) != null)
      {
        String[] arrayOfString = ((String)this.jdField_a_of_type_JavaUtilArrayList.get(i)).split(" ");
        k = j;
        if (arrayOfString != null)
        {
          k = j;
          if (!a(arrayOfString[2]))
          {
            this.jdField_b_of_type_JavaUtilArrayList.add(j, arrayOfString[2]);
            k = j + 1;
          }
        }
      }
      i += 1;
    }
    if (!this.jdField_b_of_type_JavaUtilArrayList.contains(this.jdField_a_of_type_JavaLangString)) {
      this.jdField_b_of_type_JavaUtilArrayList.add(j, this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.kapalaiadapter.sdcardmountinforutil.SDCardMountInforUtil
 * JD-Core Version:    0.7.0.1
 */