import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class lbu
{
  public static String a;
  static volatile lbu jdField_a_of_type_Lbu;
  private Map<String, lez> jdField_a_of_type_JavaUtilMap = new HashMap();
  private lez jdField_a_of_type_Lez = new lez();
  
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
  
  public static lbu a()
  {
    if (jdField_a_of_type_Lbu == null) {}
    try
    {
      if (jdField_a_of_type_Lbu == null) {
        jdField_a_of_type_Lbu = new lbu();
      }
      return jdField_a_of_type_Lbu;
    }
    finally {}
  }
  
  public static boolean a(lez paramlez)
  {
    boolean bool = true;
    if (paramlez == null) {}
    do
    {
      do
      {
        return false;
        if (paramlez.j != -1)
        {
          if ((paramlez.j != 3000) && (paramlez.j != 1)) {}
          for (;;)
          {
            return bool;
            bool = false;
          }
        }
        if (paramlez.F == 0) {
          break;
        }
      } while ((paramlez.F != 3) && (paramlez.F != 100) && (paramlez.F != 4));
      return true;
      if (paramlez.J) {
        return true;
      }
    } while (!paramlez.V);
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
        lez locallez = (lez)this.jdField_a_of_type_JavaUtilMap.get(localObject2);
        int j = i;
        if (!locallez.f()) {
          j = i + 1;
        }
        i = j;
        if (QLog.isColorLevel())
        {
          String str = jdField_a_of_type_JavaLangString;
          localObject2 = new StringBuilder().append("getAliveSessionCount, count[").append(j).append("], key[").append((String)localObject2).append("], main[");
          boolean bool;
          if (locallez == this.jdField_a_of_type_Lez)
          {
            bool = true;
            QLog.w(str, 1, bool + "], session[" + locallez + "]");
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
  
  public lez a()
  {
    try
    {
      lez locallez = this.jdField_a_of_type_Lez;
      return locallez;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public lez a(String paramString)
  {
    Object localObject2;
    for (Object localObject1 = null;; localObject1 = localObject2) {
      try
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
        if (localIterator.hasNext())
        {
          localObject2 = (String)localIterator.next();
          localObject2 = (lez)this.jdField_a_of_type_JavaUtilMap.get(localObject2);
          if ((localObject2 != null) && (((lez)localObject2).d != null) && (((lez)localObject2).d.equals(paramString)))
          {
            if (localObject1 != null)
            {
              boolean bool = a((lez)localObject2);
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
  
  public lez a(String paramString, boolean paramBoolean)
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
          locallez = null;
          return locallez;
        }
        if (this.jdField_a_of_type_JavaUtilMap.get(paramString) != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "createSession already exist sessionId : " + paramString);
          }
          locallez = (lez)this.jdField_a_of_type_JavaUtilMap.get(paramString);
          continue;
        }
        if (this.jdField_a_of_type_JavaUtilMap.isEmpty())
        {
          locallez = this.jdField_a_of_type_Lez;
          this.jdField_a_of_type_JavaUtilMap.put(paramString, locallez);
          locallez.a("createSession", paramString);
          QLog.w(jdField_a_of_type_JavaLangString, 1, "createSession, sessionId[" + paramString + "], TAG[" + locallez.jdField_a_of_type_JavaLangString + "]");
          if ((this.jdField_a_of_type_JavaUtilMap.size() != 1) && (!paramBoolean)) {
            break label213;
          }
          a(paramString, 2);
          continue;
        }
        lez locallez = new lez();
      }
      finally {}
      continue;
      label213:
      a(paramString, 1);
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    for (;;)
    {
      try
      {
        if (!this.jdField_a_of_type_JavaUtilMap.containsKey(paramString)) {
          break label236;
        }
        Object localObject = (lez)this.jdField_a_of_type_JavaUtilMap.get(paramString);
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
          j = ((lez)localObject).c;
          if (((lez)localObject).c != paramInt)
          {
            if (paramInt == 2) {
              this.jdField_a_of_type_Lez = ((lez)localObject);
            }
            ((lez)localObject).c = paramInt;
            i = 0;
            continue;
          }
          if ((paramInt != 2) || (this.jdField_a_of_type_Lez == localObject)) {
            break label231;
          }
          this.jdField_a_of_type_Lez = ((lez)localObject);
          i = 2;
          continue;
        }
        paramString = paramInt + "], step[" + i;
        continue;
        i = 0;
      }
      finally {}
      label231:
      continue;
      label236:
      int i = 0;
      int j = -1;
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
    //   5: invokevirtual 202	lbu:a	()I
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
    //   0	28	0	this	lbu
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
    lez locallez;
    try
    {
      bool = this.jdField_a_of_type_JavaUtilMap.containsKey(paramString);
      QLog.w(jdField_a_of_type_JavaLangString, 1, "removeSession, sessionId[" + paramString + "], size[" + this.jdField_a_of_type_JavaUtilMap.size() + "], contains[" + bool + "], seq[" + paramLong + "]");
      if (bool)
      {
        locallez = (lez)this.jdField_a_of_type_JavaUtilMap.remove(paramString);
        if (this.jdField_a_of_type_JavaUtilMap.size() == 1)
        {
          Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
          while (localIterator.hasNext()) {
            b((String)localIterator.next());
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
      if (this.jdField_a_of_type_Lez == locallez)
      {
        this.jdField_a_of_type_Lez = new lez();
        QLog.i(jdField_a_of_type_JavaLangString, 1, "removeSession, active is cur need remove one. id[" + paramString + "]");
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
    //   2: invokestatic 123	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +38 -> 43
    //   8: getstatic 16	lbu:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   11: iconst_2
    //   12: new 52	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   19: ldc 229
    //   21: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_1
    //   25: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: ldc 231
    //   30: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: aload_2
    //   34: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: invokestatic 164	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   43: aload_0
    //   44: getfield 30	lbu:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   47: aload_1
    //   48: invokeinterface 189 2 0
    //   53: ifne +24 -> 77
    //   56: invokestatic 123	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   59: ifeq +12 -> 71
    //   62: getstatic 16	lbu:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   65: iconst_2
    //   66: ldc 233
    //   68: invokestatic 164	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   71: iconst_0
    //   72: istore_3
    //   73: aload_0
    //   74: monitorexit
    //   75: iload_3
    //   76: ireturn
    //   77: aload_0
    //   78: getfield 30	lbu:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   81: aload_1
    //   82: invokeinterface 115 2 0
    //   87: checkcast 22	lez
    //   90: astore 4
    //   92: aload 4
    //   94: ldc 235
    //   96: aload_2
    //   97: invokevirtual 175	lez:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   100: aload_0
    //   101: getfield 30	lbu:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   104: aload_1
    //   105: invokeinterface 217 2 0
    //   110: pop
    //   111: aload_0
    //   112: getfield 30	lbu:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   115: aload_2
    //   116: aload 4
    //   118: invokeinterface 170 3 0
    //   123: pop
    //   124: iconst_1
    //   125: istore_3
    //   126: goto -53 -> 73
    //   129: astore_1
    //   130: aload_0
    //   131: monitorexit
    //   132: aload_1
    //   133: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	134	0	this	lbu
    //   0	134	1	paramString1	String
    //   0	134	2	paramString2	String
    //   72	54	3	bool	boolean
    //   90	27	4	locallez	lez
    // Exception table:
    //   from	to	target	type
    //   2	43	129	finally
    //   43	71	129	finally
    //   77	124	129	finally
  }
  
  public lez b(String paramString)
  {
    Object localObject2;
    for (Object localObject1 = null;; localObject1 = localObject2) {
      try
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
        if (localIterator.hasNext())
        {
          localObject2 = (String)localIterator.next();
          localObject2 = (lez)this.jdField_a_of_type_JavaUtilMap.get(localObject2);
          if ((localObject2 != null) && (TextUtils.equals(paramString, ((lez)localObject2).d)))
          {
            if ((localObject1 == null) && (!((lez)localObject2).J)) {
              continue;
            }
            if (a((lez)localObject2))
            {
              boolean bool = ((lez)localObject2).J;
              if (!bool) {
                continue;
              }
            }
          }
          localObject2 = localObject1;
        }
        else
        {
          return localObject1;
        }
      }
      finally {}
    }
  }
  
  /* Error */
  public boolean b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 30	lbu:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   6: invokeinterface 95 1 0
    //   11: invokeinterface 101 1 0
    //   16: astore_2
    //   17: aload_2
    //   18: invokeinterface 107 1 0
    //   23: ifeq +40 -> 63
    //   26: aload_2
    //   27: invokeinterface 111 1 0
    //   32: checkcast 42	java/lang/String
    //   35: astore_3
    //   36: aload_0
    //   37: getfield 30	lbu:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   40: aload_3
    //   41: invokeinterface 115 2 0
    //   46: checkcast 22	lez
    //   49: invokevirtual 118	lez:f	()Z
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
    //   0	73	0	this	lbu
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
    //   2: invokestatic 123	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +43 -> 48
    //   8: getstatic 16	lbu:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   11: iconst_2
    //   12: new 52	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   19: ldc 241
    //   21: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_1
    //   25: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: ldc 139
    //   30: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: new 243	java/lang/Throwable
    //   39: dup
    //   40: ldc 245
    //   42: invokespecial 248	java/lang/Throwable:<init>	(Ljava/lang/String;)V
    //   45: invokestatic 251	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   48: aload_0
    //   49: getfield 30	lbu:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   52: aload_1
    //   53: invokeinterface 189 2 0
    //   58: ifeq +15 -> 73
    //   61: aload_0
    //   62: aload_1
    //   63: iconst_2
    //   64: invokevirtual 186	lbu:a	(Ljava/lang/String;I)V
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
    //   0	83	0	this	lbu
    //   0	83	1	paramString	String
    //   68	7	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	48	78	finally
    //   48	67	78	finally
  }
  
  public lez c(String paramString)
  {
    try
    {
      if ((!this.jdField_a_of_type_JavaUtilMap.containsKey(paramString)) && (QLog.isColorLevel())) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "getSession not exist sessionId : " + paramString);
      }
      paramString = (lez)this.jdField_a_of_type_JavaUtilMap.get(paramString);
      return paramString;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lbu
 * JD-Core Version:    0.7.0.1
 */