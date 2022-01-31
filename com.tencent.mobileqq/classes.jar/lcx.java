import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class lcx
{
  public static String a;
  static volatile lcx jdField_a_of_type_Lcx;
  private Map<String, lga> jdField_a_of_type_JavaUtilMap = new HashMap();
  private lga jdField_a_of_type_Lga = new lga();
  
  static
  {
    jdField_a_of_type_JavaLangString = "AvSessionMgr";
  }
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    case 1011: 
    default: 
      return 3;
    case 3000: 
      return 2;
    }
    return 1;
  }
  
  public static String a(int paramInt, String paramString, int... paramVarArgs)
  {
    String str = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      str = paramString;
      if (paramString.startsWith("+")) {
        str = paramString.substring(1);
      }
    }
    str = String.valueOf(paramInt) + "-" + str;
    paramString = str;
    if (paramInt == 1)
    {
      paramString = str;
      if (paramVarArgs != null)
      {
        paramString = str;
        if (paramVarArgs.length == 1) {
          paramString = str + "-" + paramVarArgs[0];
        }
      }
    }
    return paramString;
  }
  
  public static lcx a()
  {
    if (jdField_a_of_type_Lcx == null) {}
    try
    {
      if (jdField_a_of_type_Lcx == null) {
        jdField_a_of_type_Lcx = new lcx();
      }
      return jdField_a_of_type_Lcx;
    }
    finally {}
  }
  
  public static boolean a(lga paramlga)
  {
    boolean bool = true;
    if (paramlga == null) {}
    do
    {
      do
      {
        return false;
        if (paramlga.i != -1)
        {
          if ((paramlga.i != 3000) && (paramlga.i != 1)) {}
          for (;;)
          {
            return bool;
            bool = false;
          }
        }
        if (paramlga.E == 0) {
          break;
        }
      } while ((paramlga.E != 3) && (paramlga.E != 100) && (paramlga.E != 4));
      return true;
      if (paramlga.I) {
        return true;
      }
    } while (!paramlga.T);
    return false;
  }
  
  public int a()
  {
    int i;
    for (;;)
    {
      try
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
        i = 0;
        if (!localIterator.hasNext()) {
          break;
        }
        Object localObject2 = (String)localIterator.next();
        lga locallga = (lga)this.jdField_a_of_type_JavaUtilMap.get(localObject2);
        int j = i;
        if (!locallga.d()) {
          j = i + 1;
        }
        i = j;
        if (QLog.isColorLevel())
        {
          String str = jdField_a_of_type_JavaLangString;
          localObject2 = new StringBuilder().append("getAliveSessionCount, count[").append(j).append("], key[").append((String)localObject2).append("], main[");
          boolean bool;
          if (locallga == this.jdField_a_of_type_Lga)
          {
            bool = true;
            QLog.w(str, 1, bool + "], session[" + locallga + "]");
            i = j;
          }
          else
          {
            bool = false;
          }
        }
      }
      finally {}
    }
    return i;
  }
  
  public lga a()
  {
    try
    {
      lga locallga = this.jdField_a_of_type_Lga;
      return locallga;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public lga a(String paramString)
  {
    Object localObject2;
    for (Object localObject1 = null;; localObject1 = localObject2) {
      try
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
        if (localIterator.hasNext())
        {
          localObject2 = (String)localIterator.next();
          localObject2 = (lga)this.jdField_a_of_type_JavaUtilMap.get(localObject2);
          if ((localObject2 != null) && (((lga)localObject2).d != null) && (((lga)localObject2).d.equals(paramString)))
          {
            if (localObject1 != null)
            {
              boolean bool = a((lga)localObject2);
              if (bool) {}
            }
          }
          else {
            localObject2 = localObject1;
          }
        }
        else
        {
          return localObject1;
        }
      }
      finally {}
    }
  }
  
  public lga a(String paramString, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(paramString))
        {
          if (QLog.isColorLevel()) {
            QLog.e(jdField_a_of_type_JavaLangString, 2, "createSession with null sessionId ");
          }
          locallga = null;
          return locallga;
        }
        if (this.jdField_a_of_type_JavaUtilMap.get(paramString) != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "createSession already exist sessionId : " + paramString);
          }
          locallga = (lga)this.jdField_a_of_type_JavaUtilMap.get(paramString);
          continue;
        }
        if (this.jdField_a_of_type_JavaUtilMap.isEmpty())
        {
          locallga = this.jdField_a_of_type_Lga;
          this.jdField_a_of_type_JavaUtilMap.put(paramString, locallga);
          locallga.jdField_c_of_type_JavaLangString = paramString;
          QLog.w(jdField_a_of_type_JavaLangString, 1, "createSession, sessionId[" + paramString + "], TAG[" + locallga.jdField_a_of_type_JavaLangString + "]");
          if ((this.jdField_a_of_type_JavaUtilMap.size() != 1) && (!paramBoolean)) {
            break label211;
          }
          a(paramString, 2);
          continue;
        }
        lga locallga = new lga();
      }
      finally {}
      continue;
      label211:
      a(paramString, 1);
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString))
        {
          Object localObject = (lga)this.jdField_a_of_type_JavaUtilMap.get(paramString);
          if (localObject == null)
          {
            i = 1;
            j = -1;
            if ((QLog.isColorLevel()) || (j != paramInt) || (i != 0))
            {
              localObject = jdField_a_of_type_JavaLangString;
              StringBuilder localStringBuilder = new StringBuilder().append("setSessionStatus, sessionId[").append(paramString).append("], status[");
              if (i != 0) {
                continue;
              }
              paramString = j + "->" + paramInt;
              QLog.w((String)localObject, 1, paramString + "]");
            }
          }
          else
          {
            j = ((lga)localObject).jdField_c_of_type_Int;
            if (((lga)localObject).jdField_c_of_type_Int == paramInt) {
              break label212;
            }
            if (paramInt == 2) {
              this.jdField_a_of_type_Lga = ((lga)localObject);
            }
            ((lga)localObject).jdField_c_of_type_Int = paramInt;
            break label212;
          }
          paramString = paramInt + "], step[" + i;
          continue;
        }
        i = 0;
      }
      finally {}
      int j = -1;
      continue;
      label212:
      int i = 0;
    }
  }
  
  /* Error */
  public boolean a()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: invokevirtual 197	lcx:a	()I
    //   8: istore_1
    //   9: iload_1
    //   10: iconst_1
    //   11: if_icmple +7 -> 18
    //   14: aload_0
    //   15: monitorexit
    //   16: iload_2
    //   17: ireturn
    //   18: iconst_0
    //   19: istore_2
    //   20: goto -6 -> 14
    //   23: astore_3
    //   24: aload_0
    //   25: monitorexit
    //   26: aload_3
    //   27: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	28	0	this	lcx
    //   8	4	1	i	int
    //   1	19	2	bool	boolean
    //   23	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	9	23	finally
  }
  
  public boolean a(long paramLong, String paramString)
  {
    boolean bool;
    try
    {
      bool = this.jdField_a_of_type_JavaUtilMap.containsKey(paramString);
      QLog.w(jdField_a_of_type_JavaLangString, 1, "removeSession, sessionId[" + paramString + "], size[" + this.jdField_a_of_type_JavaUtilMap.size() + "], contains[" + bool + "], seq[" + paramLong + "]");
      if (bool)
      {
        this.jdField_a_of_type_JavaUtilMap.remove(paramString);
        if (this.jdField_a_of_type_JavaUtilMap.size() == 1)
        {
          paramString = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
          while (paramString.hasNext()) {
            b((String)paramString.next());
          }
        }
      }
      else
      {
        bool = false;
      }
    }
    finally {}
    for (;;)
    {
      return bool;
      if (this.jdField_a_of_type_JavaUtilMap.size() == 0) {
        this.jdField_a_of_type_Lga = new lga();
      }
      bool = true;
    }
  }
  
  public boolean a(String paramString)
  {
    try
    {
      boolean bool = this.jdField_a_of_type_JavaUtilMap.containsKey(paramString);
      return bool;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  /* Error */
  @java.lang.Deprecated
  public boolean a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +38 -> 43
    //   8: getstatic 16	lcx:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   11: iconst_2
    //   12: new 52	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   19: ldc 219
    //   21: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_1
    //   25: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: ldc 221
    //   30: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: aload_2
    //   34: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: invokestatic 162	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   43: aload_0
    //   44: getfield 30	lcx:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   47: aload_1
    //   48: invokeinterface 185 2 0
    //   53: ifne +24 -> 77
    //   56: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   59: ifeq +12 -> 71
    //   62: getstatic 16	lcx:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   65: iconst_2
    //   66: ldc 223
    //   68: invokestatic 162	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   71: iconst_0
    //   72: istore_3
    //   73: aload_0
    //   74: monitorexit
    //   75: iload_3
    //   76: ireturn
    //   77: aload_0
    //   78: getfield 30	lcx:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   81: aload_1
    //   82: invokeinterface 114 2 0
    //   87: checkcast 22	lga
    //   90: astore 4
    //   92: aload 4
    //   94: aload_2
    //   95: putfield 171	lga:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   98: aload_0
    //   99: getfield 30	lcx:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   102: aload_1
    //   103: invokeinterface 212 2 0
    //   108: pop
    //   109: aload_0
    //   110: getfield 30	lcx:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   113: aload_2
    //   114: aload 4
    //   116: invokeinterface 168 3 0
    //   121: pop
    //   122: iconst_1
    //   123: istore_3
    //   124: goto -51 -> 73
    //   127: astore_1
    //   128: aload_0
    //   129: monitorexit
    //   130: aload_1
    //   131: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	132	0	this	lcx
    //   0	132	1	paramString1	String
    //   0	132	2	paramString2	String
    //   72	52	3	bool	boolean
    //   90	25	4	locallga	lga
    // Exception table:
    //   from	to	target	type
    //   2	43	127	finally
    //   43	71	127	finally
    //   77	122	127	finally
  }
  
  public lga b(String paramString)
  {
    try
    {
      if ((!this.jdField_a_of_type_JavaUtilMap.containsKey(paramString)) && (QLog.isColorLevel())) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "getSession not exist sessionId : " + paramString);
      }
      paramString = (lga)this.jdField_a_of_type_JavaUtilMap.get(paramString);
      return paramString;
    }
    finally {}
  }
  
  /* Error */
  public boolean b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 30	lcx:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   6: invokeinterface 94 1 0
    //   11: invokeinterface 100 1 0
    //   16: astore_2
    //   17: aload_2
    //   18: invokeinterface 106 1 0
    //   23: ifeq +40 -> 63
    //   26: aload_2
    //   27: invokeinterface 110 1 0
    //   32: checkcast 42	java/lang/String
    //   35: astore_3
    //   36: aload_0
    //   37: getfield 30	lcx:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   40: aload_3
    //   41: invokeinterface 114 2 0
    //   46: checkcast 22	lga
    //   49: invokevirtual 117	lga:d	()Z
    //   52: istore_1
    //   53: iload_1
    //   54: ifne -37 -> 17
    //   57: iconst_0
    //   58: istore_1
    //   59: aload_0
    //   60: monitorexit
    //   61: iload_1
    //   62: ireturn
    //   63: iconst_1
    //   64: istore_1
    //   65: goto -6 -> 59
    //   68: astore_2
    //   69: aload_0
    //   70: monitorexit
    //   71: aload_2
    //   72: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	this	lcx
    //   52	13	1	bool	boolean
    //   16	11	2	localIterator	Iterator
    //   68	4	2	localObject	Object
    //   35	6	3	str	String
    // Exception table:
    //   from	to	target	type
    //   2	17	68	finally
    //   17	53	68	finally
  }
  
  /* Error */
  public boolean b(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +43 -> 48
    //   8: getstatic 16	lcx:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   11: iconst_2
    //   12: new 52	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   19: ldc 228
    //   21: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_1
    //   25: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: ldc 138
    //   30: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: new 230	java/lang/Throwable
    //   39: dup
    //   40: ldc 232
    //   42: invokespecial 235	java/lang/Throwable:<init>	(Ljava/lang/String;)V
    //   45: invokestatic 238	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   48: aload_0
    //   49: getfield 30	lcx:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   52: aload_1
    //   53: invokeinterface 185 2 0
    //   58: ifeq +15 -> 73
    //   61: aload_0
    //   62: aload_1
    //   63: iconst_2
    //   64: invokevirtual 182	lcx:a	(Ljava/lang/String;I)V
    //   67: iconst_1
    //   68: istore_2
    //   69: aload_0
    //   70: monitorexit
    //   71: iload_2
    //   72: ireturn
    //   73: iconst_0
    //   74: istore_2
    //   75: goto -6 -> 69
    //   78: astore_1
    //   79: aload_0
    //   80: monitorexit
    //   81: aload_1
    //   82: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	83	0	this	lcx
    //   0	83	1	paramString	String
    //   68	7	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	48	78	finally
    //   48	67	78	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lcx
 * JD-Core Version:    0.7.0.1
 */