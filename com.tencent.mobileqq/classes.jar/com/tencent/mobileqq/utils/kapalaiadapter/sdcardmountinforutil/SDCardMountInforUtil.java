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
    //   34: ifnull +28 -> 62
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
    //   62: aload_2
    //   63: astore_1
    //   64: aload_0
    //   65: getfield 23	com/tencent/mobileqq/utils/kapalaiadapter/sdcardmountinforutil/SDCardMountInforUtil:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   68: invokevirtual 60	java/util/ArrayList:trimToSize	()V
    //   71: aload_2
    //   72: invokevirtual 63	java/io/BufferedReader:close	()V
    //   75: goto +38 -> 113
    //   78: astore_3
    //   79: goto +12 -> 91
    //   82: astore_1
    //   83: aconst_null
    //   84: astore_2
    //   85: goto +38 -> 123
    //   88: astore_3
    //   89: aconst_null
    //   90: astore_2
    //   91: aload_2
    //   92: astore_1
    //   93: aload_3
    //   94: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   97: aload_2
    //   98: ifnull +15 -> 113
    //   101: aload_2
    //   102: invokevirtual 63	java/io/BufferedReader:close	()V
    //   105: goto +8 -> 113
    //   108: astore_1
    //   109: aload_1
    //   110: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   113: aload_0
    //   114: invokespecial 69	com/tencent/mobileqq/utils/kapalaiadapter/sdcardmountinforutil/SDCardMountInforUtil:d	()V
    //   117: return
    //   118: astore_3
    //   119: aload_1
    //   120: astore_2
    //   121: aload_3
    //   122: astore_1
    //   123: aload_2
    //   124: ifnull +15 -> 139
    //   127: aload_2
    //   128: invokevirtual 63	java/io/BufferedReader:close	()V
    //   131: goto +8 -> 139
    //   134: astore_2
    //   135: aload_2
    //   136: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   139: goto +5 -> 144
    //   142: aload_1
    //   143: athrow
    //   144: goto -2 -> 142
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	147	0	this	SDCardMountInforUtil
    //   27	37	1	localObject1	Object
    //   82	1	1	localObject2	Object
    //   92	1	1	localObject3	Object
    //   108	12	1	localException1	Exception
    //   122	21	1	localObject4	Object
    //   25	103	2	localObject5	Object
    //   134	2	2	localException2	Exception
    //   32	23	3	str	String
    //   78	1	3	localException3	Exception
    //   88	6	3	localException4	Exception
    //   118	4	3	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   28	33	78	java/lang/Exception
    //   39	48	78	java/lang/Exception
    //   50	59	78	java/lang/Exception
    //   64	71	78	java/lang/Exception
    //   7	26	82	finally
    //   7	26	88	java/lang/Exception
    //   71	75	108	java/lang/Exception
    //   101	105	108	java/lang/Exception
    //   28	33	118	finally
    //   39	48	118	finally
    //   50	59	118	finally
    //   64	71	118	finally
    //   93	97	118	finally
    //   127	131	134	java/lang/Exception
  }
  
  private void a(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        c();
        return;
      }
      b();
      return;
    }
    a();
  }
  
  private boolean a(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    paramString = new File(paramString);
    if ((paramString.exists()) && (paramString.list() != null))
    {
      paramString = paramString.list();
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        String str = paramString[i];
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("--------");
          localStringBuilder.append(str);
          QLog.i("kapalai", 2, localStringBuilder.toString());
        }
        i += 1;
      }
      return false;
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
    //   34: ifnull +28 -> 62
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
    //   62: aload_2
    //   63: astore_1
    //   64: aload_0
    //   65: getfield 23	com/tencent/mobileqq/utils/kapalaiadapter/sdcardmountinforutil/SDCardMountInforUtil:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   68: invokevirtual 60	java/util/ArrayList:trimToSize	()V
    //   71: aload_2
    //   72: invokevirtual 63	java/io/BufferedReader:close	()V
    //   75: goto +38 -> 113
    //   78: astore_3
    //   79: goto +12 -> 91
    //   82: astore_1
    //   83: aconst_null
    //   84: astore_2
    //   85: goto +38 -> 123
    //   88: astore_3
    //   89: aconst_null
    //   90: astore_2
    //   91: aload_2
    //   92: astore_1
    //   93: aload_3
    //   94: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   97: aload_2
    //   98: ifnull +15 -> 113
    //   101: aload_2
    //   102: invokevirtual 63	java/io/BufferedReader:close	()V
    //   105: goto +8 -> 113
    //   108: astore_1
    //   109: aload_1
    //   110: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   113: aload_0
    //   114: invokespecial 69	com/tencent/mobileqq/utils/kapalaiadapter/sdcardmountinforutil/SDCardMountInforUtil:d	()V
    //   117: return
    //   118: astore_3
    //   119: aload_1
    //   120: astore_2
    //   121: aload_3
    //   122: astore_1
    //   123: aload_2
    //   124: ifnull +15 -> 139
    //   127: aload_2
    //   128: invokevirtual 63	java/io/BufferedReader:close	()V
    //   131: goto +8 -> 139
    //   134: astore_2
    //   135: aload_2
    //   136: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   139: goto +5 -> 144
    //   142: aload_1
    //   143: athrow
    //   144: goto -2 -> 142
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	147	0	this	SDCardMountInforUtil
    //   27	37	1	localObject1	Object
    //   82	1	1	localObject2	Object
    //   92	1	1	localObject3	Object
    //   108	12	1	localException1	Exception
    //   122	21	1	localObject4	Object
    //   25	103	2	localObject5	Object
    //   134	2	2	localException2	Exception
    //   32	23	3	str	String
    //   78	1	3	localException3	Exception
    //   88	6	3	localException4	Exception
    //   118	4	3	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   28	33	78	java/lang/Exception
    //   39	48	78	java/lang/Exception
    //   50	59	78	java/lang/Exception
    //   64	71	78	java/lang/Exception
    //   7	26	82	finally
    //   7	26	88	java/lang/Exception
    //   71	75	108	java/lang/Exception
    //   101	105	108	java/lang/Exception
    //   28	33	118	finally
    //   39	48	118	finally
    //   50	59	118	finally
    //   64	71	118	finally
    //   93	97	118	finally
    //   127	131	134	java/lang/Exception
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.kapalaiadapter.sdcardmountinforutil.SDCardMountInforUtil
 * JD-Core Version:    0.7.0.1
 */