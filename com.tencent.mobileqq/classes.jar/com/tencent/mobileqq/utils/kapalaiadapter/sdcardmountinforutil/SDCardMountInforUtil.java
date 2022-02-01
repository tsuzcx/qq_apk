package com.tencent.mobileqq.utils.kapalaiadapter.sdcardmountinforutil;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Environment;
import android.os.storage.StorageManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class SDCardMountInforUtil
  implements ISDCardMountInfor
{
  public static final String a = Environment.getExternalStorageDirectory().getAbsolutePath();
  private static final File e;
  private static final File f;
  private int b;
  private ArrayList<String> c;
  private ArrayList<String> d;
  private Context g;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Environment.getRootDirectory().getAbsoluteFile());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("etc");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("vold.conf");
    e = new File(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(Environment.getRootDirectory().getAbsoluteFile());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("etc");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("vold.fstab");
    f = new File(localStringBuilder.toString());
  }
  
  /* Error */
  private void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 80	com/tencent/mobileqq/utils/kapalaiadapter/sdcardmountinforutil/SDCardMountInforUtil:c	Ljava/util/ArrayList;
    //   4: invokevirtual 85	java/util/ArrayList:clear	()V
    //   7: new 87	java/io/BufferedReader
    //   10: dup
    //   11: new 89	java/io/FileReader
    //   14: dup
    //   15: getstatic 68	com/tencent/mobileqq/utils/kapalaiadapter/sdcardmountinforutil/SDCardMountInforUtil:e	Ljava/io/File;
    //   18: invokespecial 92	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   21: invokespecial 95	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   24: astore_2
    //   25: aload_2
    //   26: astore_1
    //   27: aload_2
    //   28: invokevirtual 98	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   31: astore_3
    //   32: aload_3
    //   33: ifnull +28 -> 61
    //   36: aload_2
    //   37: astore_1
    //   38: aload_3
    //   39: ldc 100
    //   41: invokevirtual 106	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   44: ifeq -19 -> 25
    //   47: aload_2
    //   48: astore_1
    //   49: aload_0
    //   50: getfield 80	com/tencent/mobileqq/utils/kapalaiadapter/sdcardmountinforutil/SDCardMountInforUtil:c	Ljava/util/ArrayList;
    //   53: aload_3
    //   54: invokevirtual 110	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   57: pop
    //   58: goto -33 -> 25
    //   61: aload_2
    //   62: astore_1
    //   63: aload_0
    //   64: getfield 80	com/tencent/mobileqq/utils/kapalaiadapter/sdcardmountinforutil/SDCardMountInforUtil:c	Ljava/util/ArrayList;
    //   67: invokevirtual 113	java/util/ArrayList:trimToSize	()V
    //   70: aload_2
    //   71: invokevirtual 116	java/io/BufferedReader:close	()V
    //   74: goto +38 -> 112
    //   77: astore_3
    //   78: goto +12 -> 90
    //   81: astore_1
    //   82: aconst_null
    //   83: astore_2
    //   84: goto +38 -> 122
    //   87: astore_3
    //   88: aconst_null
    //   89: astore_2
    //   90: aload_2
    //   91: astore_1
    //   92: aload_3
    //   93: invokevirtual 119	java/lang/Exception:printStackTrace	()V
    //   96: aload_2
    //   97: ifnull +15 -> 112
    //   100: aload_2
    //   101: invokevirtual 116	java/io/BufferedReader:close	()V
    //   104: goto +8 -> 112
    //   107: astore_1
    //   108: aload_1
    //   109: invokevirtual 119	java/lang/Exception:printStackTrace	()V
    //   112: aload_0
    //   113: invokespecial 121	com/tencent/mobileqq/utils/kapalaiadapter/sdcardmountinforutil/SDCardMountInforUtil:d	()V
    //   116: return
    //   117: astore_3
    //   118: aload_1
    //   119: astore_2
    //   120: aload_3
    //   121: astore_1
    //   122: aload_2
    //   123: ifnull +15 -> 138
    //   126: aload_2
    //   127: invokevirtual 116	java/io/BufferedReader:close	()V
    //   130: goto +8 -> 138
    //   133: astore_2
    //   134: aload_2
    //   135: invokevirtual 119	java/lang/Exception:printStackTrace	()V
    //   138: goto +5 -> 143
    //   141: aload_1
    //   142: athrow
    //   143: goto -2 -> 141
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	146	0	this	SDCardMountInforUtil
    //   26	37	1	localObject1	Object
    //   81	1	1	localObject2	Object
    //   91	1	1	localObject3	Object
    //   107	12	1	localException1	Exception
    //   121	21	1	localObject4	Object
    //   24	103	2	localObject5	Object
    //   133	2	2	localException2	Exception
    //   31	23	3	str	String
    //   77	1	3	localException3	Exception
    //   87	6	3	localException4	Exception
    //   117	4	3	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   27	32	77	java/lang/Exception
    //   38	47	77	java/lang/Exception
    //   49	58	77	java/lang/Exception
    //   63	70	77	java/lang/Exception
    //   7	25	81	finally
    //   7	25	87	java/lang/Exception
    //   70	74	107	java/lang/Exception
    //   100	104	107	java/lang/Exception
    //   27	32	117	finally
    //   38	47	117	finally
    //   49	58	117	finally
    //   63	70	117	finally
    //   92	96	117	finally
    //   126	130	133	java/lang/Exception
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
    //   1: getfield 80	com/tencent/mobileqq/utils/kapalaiadapter/sdcardmountinforutil/SDCardMountInforUtil:c	Ljava/util/ArrayList;
    //   4: invokevirtual 85	java/util/ArrayList:clear	()V
    //   7: new 87	java/io/BufferedReader
    //   10: dup
    //   11: new 89	java/io/FileReader
    //   14: dup
    //   15: getstatic 72	com/tencent/mobileqq/utils/kapalaiadapter/sdcardmountinforutil/SDCardMountInforUtil:f	Ljava/io/File;
    //   18: invokespecial 92	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   21: invokespecial 95	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   24: astore_2
    //   25: aload_2
    //   26: astore_1
    //   27: aload_2
    //   28: invokevirtual 98	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   31: astore_3
    //   32: aload_3
    //   33: ifnull +28 -> 61
    //   36: aload_2
    //   37: astore_1
    //   38: aload_3
    //   39: ldc 154
    //   41: invokevirtual 106	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   44: ifeq -19 -> 25
    //   47: aload_2
    //   48: astore_1
    //   49: aload_0
    //   50: getfield 80	com/tencent/mobileqq/utils/kapalaiadapter/sdcardmountinforutil/SDCardMountInforUtil:c	Ljava/util/ArrayList;
    //   53: aload_3
    //   54: invokevirtual 110	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   57: pop
    //   58: goto -33 -> 25
    //   61: aload_2
    //   62: astore_1
    //   63: aload_0
    //   64: getfield 80	com/tencent/mobileqq/utils/kapalaiadapter/sdcardmountinforutil/SDCardMountInforUtil:c	Ljava/util/ArrayList;
    //   67: invokevirtual 113	java/util/ArrayList:trimToSize	()V
    //   70: aload_2
    //   71: invokevirtual 116	java/io/BufferedReader:close	()V
    //   74: goto +38 -> 112
    //   77: astore_3
    //   78: goto +12 -> 90
    //   81: astore_1
    //   82: aconst_null
    //   83: astore_2
    //   84: goto +38 -> 122
    //   87: astore_3
    //   88: aconst_null
    //   89: astore_2
    //   90: aload_2
    //   91: astore_1
    //   92: aload_3
    //   93: invokevirtual 119	java/lang/Exception:printStackTrace	()V
    //   96: aload_2
    //   97: ifnull +15 -> 112
    //   100: aload_2
    //   101: invokevirtual 116	java/io/BufferedReader:close	()V
    //   104: goto +8 -> 112
    //   107: astore_1
    //   108: aload_1
    //   109: invokevirtual 119	java/lang/Exception:printStackTrace	()V
    //   112: aload_0
    //   113: invokespecial 121	com/tencent/mobileqq/utils/kapalaiadapter/sdcardmountinforutil/SDCardMountInforUtil:d	()V
    //   116: return
    //   117: astore_3
    //   118: aload_1
    //   119: astore_2
    //   120: aload_3
    //   121: astore_1
    //   122: aload_2
    //   123: ifnull +15 -> 138
    //   126: aload_2
    //   127: invokevirtual 116	java/io/BufferedReader:close	()V
    //   130: goto +8 -> 138
    //   133: astore_2
    //   134: aload_2
    //   135: invokevirtual 119	java/lang/Exception:printStackTrace	()V
    //   138: goto +5 -> 143
    //   141: aload_1
    //   142: athrow
    //   143: goto -2 -> 141
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	146	0	this	SDCardMountInforUtil
    //   26	37	1	localObject1	Object
    //   81	1	1	localObject2	Object
    //   91	1	1	localObject3	Object
    //   107	12	1	localException1	Exception
    //   121	21	1	localObject4	Object
    //   24	103	2	localObject5	Object
    //   133	2	2	localException2	Exception
    //   31	23	3	str	String
    //   77	1	3	localException3	Exception
    //   87	6	3	localException4	Exception
    //   117	4	3	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   27	32	77	java/lang/Exception
    //   38	47	77	java/lang/Exception
    //   49	58	77	java/lang/Exception
    //   63	70	77	java/lang/Exception
    //   7	25	81	finally
    //   7	25	87	java/lang/Exception
    //   70	74	107	java/lang/Exception
    //   100	104	107	java/lang/Exception
    //   27	32	117	finally
    //   38	47	117	finally
    //   49	58	117	finally
    //   63	70	117	finally
    //   92	96	117	finally
    //   126	130	133	java/lang/Exception
  }
  
  @TargetApi(9)
  private void c()
  {
    if (this.b == 2)
    {
      this.d.clear();
      Object localObject = (StorageManager)this.g.getSystemService("storage");
      try
      {
        localObject = (String[])localObject.getClass().getMethod("getVolumePaths", null).invoke(localObject, null);
        int i = 0;
        int j = localObject.length;
        while ((i < j) && (!a(localObject[i])))
        {
          this.d.add(i, localObject[i]);
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
    this.d.clear();
    int i = 0;
    int k;
    for (int j = 0; i < this.c.size(); j = k)
    {
      k = j;
      if (this.c.get(i) != null)
      {
        String[] arrayOfString = ((String)this.c.get(i)).split(" ");
        k = j;
        if (arrayOfString != null)
        {
          k = j;
          if (!a(arrayOfString[2]))
          {
            this.d.add(j, arrayOfString[2]);
            k = j + 1;
          }
        }
      }
      i += 1;
    }
    if (!this.d.contains(a)) {
      this.d.add(j, a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.kapalaiadapter.sdcardmountinforutil.SDCardMountInforUtil
 * JD-Core Version:    0.7.0.1
 */