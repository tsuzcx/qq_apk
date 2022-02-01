package com.tencent.mobileqq.config;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import mqq.app.MobileQQ;

public class QConfigJourney
{
  private static volatile QConfigJourney jdField_a_of_type_ComTencentMobileqqConfigQConfigJourney = null;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private String jdField_a_of_type_JavaLangString;
  private Map<String, SharedPreferences> jdField_a_of_type_JavaUtilMap = new HashMap(20);
  private Set<QConfigJourney.Entry> jdField_a_of_type_JavaUtilSet = new HashSet(20);
  private final ReadWriteLock jdField_a_of_type_JavaUtilConcurrentLocksReadWriteLock = new ReentrantReadWriteLock();
  public volatile boolean a;
  private Map<String, SharedPreferences.Editor> b;
  public volatile boolean b;
  
  private QConfigJourney()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_b_of_type_JavaUtilMap = new HashMap(20);
  }
  
  private SharedPreferences.Editor a(String paramString)
  {
    SharedPreferences.Editor localEditor = (SharedPreferences.Editor)this.jdField_b_of_type_JavaUtilMap.get(paramString);
    Object localObject = localEditor;
    if (localEditor == null)
    {
      localObject = a(paramString);
      if (localObject != null)
      {
        localObject = ((SharedPreferences)localObject).edit();
        this.jdField_b_of_type_JavaUtilMap.put(paramString, localObject);
      }
    }
    else
    {
      return localObject;
    }
    return null;
  }
  
  private SharedPreferences a()
  {
    if (this.jdField_a_of_type_AndroidContentSharedPreferences == null) {
      this.jdField_a_of_type_AndroidContentSharedPreferences = MobileQQ.sMobileQQ.getSharedPreferences("q_journey_safe_mode_pref", 0);
    }
    return this.jdField_a_of_type_AndroidContentSharedPreferences;
  }
  
  private SharedPreferences a(String paramString)
  {
    SharedPreferences localSharedPreferences2 = (SharedPreferences)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    SharedPreferences localSharedPreferences1 = localSharedPreferences2;
    if (localSharedPreferences2 == null)
    {
      localSharedPreferences2 = MobileQQ.sMobileQQ.getSharedPreferences(paramString, 0);
      localSharedPreferences1 = localSharedPreferences2;
      if (localSharedPreferences2 != null)
      {
        this.jdField_a_of_type_JavaUtilMap.put(paramString, localSharedPreferences2);
        localSharedPreferences1 = localSharedPreferences2;
      }
    }
    return localSharedPreferences1;
  }
  
  private QConfigJourney.Entry a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return null;
      paramString = paramString.split("-");
      if (paramString.length != 3) {
        continue;
      }
      try
      {
        int i = Integer.valueOf(paramString[0]).intValue();
        if ((i < 0) || (i > 2) || (TextUtils.isEmpty(paramString[1]))) {
          continue;
        }
        String str = paramString[1];
        try
        {
          long l = Long.valueOf(paramString[2]).longValue();
          return new QConfigJourney.Entry(i, str, l, null);
        }
        catch (NumberFormatException paramString)
        {
          return null;
        }
        return null;
      }
      catch (NumberFormatException paramString) {}
    }
  }
  
  public static QConfigJourney a()
  {
    if (jdField_a_of_type_ComTencentMobileqqConfigQConfigJourney == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqConfigQConfigJourney == null) {
        jdField_a_of_type_ComTencentMobileqqConfigQConfigJourney = new QConfigJourney();
      }
      return jdField_a_of_type_ComTencentMobileqqConfigQConfigJourney;
    }
    finally {}
  }
  
  private void a(QConfigJourney.Entry paramEntry)
  {
    if (paramEntry.jdField_a_of_type_Int != 0) {
      return;
    }
    for (;;)
    {
      try
      {
        int i = Integer.valueOf(paramEntry.jdField_a_of_type_JavaLangString).intValue();
        Object localObject1 = "conf_" + paramEntry.jdField_a_of_type_Long + "_sharepref";
        Object localObject2 = "conf_" + paramEntry.jdField_a_of_type_Long + "_content_sharepref";
        Object localObject3 = a((String)localObject1);
        Object localObject4 = a((String)localObject2);
        if ((localObject3 == null) || (localObject4 == null)) {
          break label430;
        }
        localObject4 = ((SharedPreferences)localObject3).getStringSet(i + "_ids", null);
        int j = ((SharedPreferences)localObject3).getInt(paramEntry.jdField_a_of_type_JavaLangString, -1);
        if ((localObject4 == null) || (((Set)localObject4).isEmpty())) {
          break label430;
        }
        localObject2 = a((String)localObject2);
        if (localObject2 != null)
        {
          localObject3 = ((Set)localObject4).iterator();
          if (((Iterator)localObject3).hasNext())
          {
            localObject4 = (String)((Iterator)localObject3).next();
            ((SharedPreferences.Editor)localObject2).remove(i + "_" + (String)localObject4);
            continue;
          }
        }
        localObject1 = a((String)localObject1);
        if (localObject1 != null)
        {
          ((SharedPreferences.Editor)localObject1).remove(paramEntry.jdField_a_of_type_JavaLangString);
          ((SharedPreferences.Editor)localObject1).remove(i + "_ids");
          bool1 = true;
          bool2 = bool1;
          if (bool1)
          {
            bool2 = bool1;
            if (j != -1)
            {
              localObject1 = a("q_journey_safe_mode_deleted_confs_pref");
              bool2 = bool1;
              if (localObject1 != null)
              {
                long l = System.currentTimeMillis();
                ((SharedPreferences.Editor)localObject1).putLong(paramEntry.jdField_a_of_type_JavaLangString, l);
                ((SharedPreferences.Editor)localObject1).putInt(i + "_version", j);
                bool2 = bool1;
              }
            }
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("QConfigJourney", 2, "deleteSpConf, entry=" + paramEntry + ", success=" + bool2);
          return;
        }
      }
      catch (NumberFormatException paramEntry)
      {
        return;
      }
      boolean bool1 = false;
      continue;
      label430:
      boolean bool2 = false;
    }
  }
  
  private void a(QConfigJourney.Entry paramEntry, SharedPreferences.Editor paramEditor)
  {
    Object localObject1 = null;
    if (paramEntry.jdField_a_of_type_Int != 2) {}
    boolean bool2;
    label125:
    do
    {
      return;
      Object localObject2 = a();
      boolean bool3 = false;
      boolean bool1 = false;
      bool2 = bool3;
      String str;
      if (localObject2 != null)
      {
        str = paramEntry.jdField_a_of_type_Int + "-" + paramEntry.jdField_a_of_type_JavaLangString + "-" + paramEntry.jdField_a_of_type_Long;
        localObject2 = ((SharedPreferences)localObject2).getString(str, null);
        bool2 = bool3;
        localObject1 = localObject2;
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = new File((String)localObject2);
        }
      }
      try
      {
        bool2 = a((File)localObject1);
        bool1 = bool2;
      }
      catch (Exception localException)
      {
        break label125;
      }
      bool2 = bool1;
      localObject1 = localObject2;
      if (bool1)
      {
        localObject1 = a("q_journey_safe_mode_deleted_files_pref");
        if (localObject1 != null) {
          ((SharedPreferences.Editor)localObject1).putString(str, (String)localObject2);
        }
        paramEditor.remove(str);
        localObject1 = localObject2;
        bool2 = bool1;
      }
    } while (!QLog.isColorLevel());
    QLog.d("QConfigJourney", 2, "deleteStorage, entry=" + paramEntry + ", path=" + (String)localObject1 + ", success=" + bool2);
  }
  
  private boolean a(File paramFile)
  {
    if (paramFile.exists())
    {
      if (paramFile.isDirectory())
      {
        String[] arrayOfString = paramFile.list();
        if (arrayOfString != null)
        {
          int i = 0;
          while (i < arrayOfString.length)
          {
            if (!a(new File(paramFile, arrayOfString[i]))) {
              return false;
            }
            i += 1;
          }
        }
      }
      return paramFile.delete();
    }
    return true;
  }
  
  private void b(QConfigJourney.Entry paramEntry)
  {
    if (paramEntry.jdField_a_of_type_Int != 1) {}
    for (;;)
    {
      return;
      try
      {
        int i = Integer.valueOf(paramEntry.jdField_a_of_type_JavaLangString).intValue();
        if (this.jdField_a_of_type_JavaLangString == null) {
          a();
        }
        String str = this.jdField_a_of_type_JavaLangString + File.separator + "qstore" + File.separator + paramEntry.jdField_a_of_type_Long + File.separator + "conf" + File.separator + i;
        Object localObject1 = new File(str);
        boolean bool1 = false;
        try
        {
          boolean bool2 = a((File)localObject1);
          bool1 = bool2;
        }
        catch (Exception localException)
        {
          label123:
          Object localObject2;
          int j;
          long l;
          break label123;
        }
        if (bool1)
        {
          localObject2 = "conf_" + paramEntry.jdField_a_of_type_Long + "_sharepref";
          localObject1 = a((String)localObject2);
          if (localObject1 != null)
          {
            localObject2 = a((String)localObject2);
            j = ((SharedPreferences)localObject1).getInt(paramEntry.jdField_a_of_type_JavaLangString, -1);
            if ((j != -1) && (localObject2 != null)) {
              ((SharedPreferences.Editor)localObject2).remove(paramEntry.jdField_a_of_type_JavaLangString + "_" + j + "_defualt");
            }
            if (localObject2 != null) {
              ((SharedPreferences.Editor)localObject2).remove(paramEntry.jdField_a_of_type_JavaLangString);
            }
            localObject1 = a("q_journey_safe_mode_deleted_confs_pref");
            if (localObject1 != null)
            {
              l = System.currentTimeMillis();
              ((SharedPreferences.Editor)localObject1).putLong(paramEntry.jdField_a_of_type_JavaLangString, l);
              ((SharedPreferences.Editor)localObject1).putInt(i + "_version", j);
            }
          }
        }
        if (QLog.isColorLevel())
        {
          QLog.d("QConfigJourney", 2, "deleteFileConf, entry=" + paramEntry + ", path=" + str + ", success=" + bool1);
          return;
        }
      }
      catch (NumberFormatException paramEntry) {}
    }
  }
  
  public void a()
  {
    Object localObject3 = null;
    Object localObject1 = localObject3;
    if (MobileQQ.sMobileQQ != null)
    {
      localObject1 = MobileQQ.sMobileQQ.getFilesDir();
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = MobileQQ.sMobileQQ.getCacheDir();
      }
      localObject1 = localObject3;
      if (localObject2 != null) {
        localObject1 = ((File)localObject2).getParent();
      }
    }
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = localObject1;
      if (MobileQQ.sMobileQQ != null) {
        localObject2 = File.separator + "data" + File.separator + "data" + File.separator + MobileQQ.sMobileQQ.getPackageName();
      }
    }
    this.jdField_a_of_type_JavaLangString = ((String)localObject2);
  }
  
  void a(int paramInt, long paramLong, boolean paramBoolean)
  {
    int i;
    if (this.jdField_a_of_type_Boolean)
    {
      if (!paramBoolean) {
        break label69;
      }
      i = 1;
    }
    for (;;)
    {
      QConfigJourney.Entry localEntry = new QConfigJourney.Entry(i, String.valueOf(paramInt), paramLong, null);
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        this.jdField_a_of_type_JavaUtilSet.add(localEntry);
        if (this.jdField_b_of_type_Boolean) {
          a(true);
        }
        return;
        label69:
        i = 0;
      }
    }
  }
  
  void a(String arg1, String paramString2, String paramString3)
  {
    if ((this.jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(???)) && (!TextUtils.isEmpty(paramString3))) {}
    for (;;)
    {
      try
      {
        paramString2 = new QConfigJourney.Entry(2, ???, Long.valueOf(paramString2).longValue(), paramString3);
      }
      catch (NumberFormatException ???)
      {
        continue;
      }
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        this.jdField_a_of_type_JavaUtilSet.add(paramString2);
        if (this.jdField_b_of_type_Boolean) {
          a(true);
        }
        return;
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.jdField_a_of_type_Boolean = false;
    }
    Set localSet;
    HashSet localHashSet;
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        int i = this.jdField_a_of_type_JavaUtilSet.size();
        Object localObject3 = new HashSet(this.jdField_a_of_type_JavaUtilSet);
        this.jdField_a_of_type_JavaUtilSet.clear();
        if (QLog.isColorLevel()) {
          QLog.d("QConfigJourney", 2, "makeAJourney, size=" + i + ", fate=" + paramBoolean);
        }
        if (((Set)localObject3).isEmpty()) {
          return;
        }
        Object localObject4 = a();
        if (localObject4 == null) {
          return;
        }
        SharedPreferences.Editor localEditor = ((SharedPreferences)localObject4).edit();
        localSet = ((SharedPreferences)localObject4).getStringSet("safe_scoop", new HashSet());
        if (paramBoolean)
        {
          ??? = "fate_log_tag";
          localHashSet = new HashSet(i);
          if (paramBoolean)
          {
            localObject4 = ((SharedPreferences)localObject4).getStringSet((String)???, null);
            if ((localObject4 != null) && (!((Set)localObject4).isEmpty())) {
              localHashSet.addAll((Collection)localObject4);
            }
          }
          localObject3 = ((Set)localObject3).iterator();
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
          localObject4 = (QConfigJourney.Entry)((Iterator)localObject3).next();
          String str = ((QConfigJourney.Entry)localObject4).jdField_a_of_type_Int + "-" + ((QConfigJourney.Entry)localObject4).jdField_a_of_type_JavaLangString + "-" + ((QConfigJourney.Entry)localObject4).jdField_a_of_type_Long;
          if (((QConfigJourney.Entry)localObject4).jdField_a_of_type_Int == 2) {
            localEditor.putString(str, ((QConfigJourney.Entry)localObject4).b);
          }
          localHashSet.add(str);
        }
      }
      ??? = String.valueOf(System.currentTimeMillis() / 1000L);
    }
    localSet.add(???);
    localObject2.putStringSet((String)???, localHashSet);
    localObject2.putStringSet("safe_scoop", localSet);
    localObject2.commit();
  }
  
  boolean a(int paramInt1, int paramInt2)
  {
    SharedPreferences localSharedPreferences = a("q_journey_safe_mode_deleted_confs_pref");
    if (localSharedPreferences == null) {}
    long l;
    do
    {
      int i;
      do
      {
        return false;
        i = localSharedPreferences.getInt(paramInt1 + "_version", -1);
      } while ((i == -1) || (i != paramInt2));
      l = localSharedPreferences.getLong(String.valueOf(paramInt1), -1L);
    } while ((l == -1L) || (l + 10800000L <= System.currentTimeMillis()));
    return true;
  }
  
  /* Error */
  boolean a(String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aload_1
    //   4: invokestatic 96	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7: ifne +138 -> 145
    //   10: aload_3
    //   11: invokestatic 96	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   14: ifne +131 -> 145
    //   17: aload_2
    //   18: invokestatic 119	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   21: invokevirtual 123	java/lang/Long:longValue	()J
    //   24: lstore 4
    //   26: aload_0
    //   27: ldc 254
    //   29: invokespecial 62	com/tencent/mobileqq/config/QConfigJourney:a	(Ljava/lang/String;)Landroid/content/SharedPreferences;
    //   32: astore_2
    //   33: new 138	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   40: ldc_w 367
    //   43: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: aload_1
    //   47: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: ldc 98
    //   52: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: lload 4
    //   57: invokevirtual 151	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   60: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: astore_1
    //   64: aload_0
    //   65: getfield 48	com/tencent/mobileqq/config/QConfigJourney:jdField_a_of_type_JavaUtilConcurrentLocksReadWriteLock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   68: invokeinterface 373 1 0
    //   73: invokeinterface 378 1 0
    //   78: aload_2
    //   79: aload_1
    //   80: aconst_null
    //   81: invokeinterface 244 3 0
    //   86: astore_1
    //   87: aload_0
    //   88: getfield 48	com/tencent/mobileqq/config/QConfigJourney:jdField_a_of_type_JavaUtilConcurrentLocksReadWriteLock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   91: invokeinterface 373 1 0
    //   96: invokeinterface 381 1 0
    //   101: aload_3
    //   102: aload_1
    //   103: invokestatic 385	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   106: ireturn
    //   107: astore_1
    //   108: aload_0
    //   109: getfield 48	com/tencent/mobileqq/config/QConfigJourney:jdField_a_of_type_JavaUtilConcurrentLocksReadWriteLock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   112: invokeinterface 373 1 0
    //   117: invokeinterface 381 1 0
    //   122: aload 6
    //   124: astore_1
    //   125: goto -24 -> 101
    //   128: astore_1
    //   129: aload_0
    //   130: getfield 48	com/tencent/mobileqq/config/QConfigJourney:jdField_a_of_type_JavaUtilConcurrentLocksReadWriteLock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   133: invokeinterface 373 1 0
    //   138: invokeinterface 381 1 0
    //   143: aload_1
    //   144: athrow
    //   145: iconst_0
    //   146: ireturn
    //   147: astore_1
    //   148: iconst_0
    //   149: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	150	0	this	QConfigJourney
    //   0	150	1	paramString1	String
    //   0	150	2	paramString2	String
    //   0	150	3	paramString3	String
    //   24	32	4	l	long
    //   1	122	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   78	87	107	java/lang/Exception
    //   78	87	128	finally
    //   17	78	147	java/lang/NumberFormatException
    //   87	101	147	java/lang/NumberFormatException
    //   101	107	147	java/lang/NumberFormatException
    //   108	122	147	java/lang/NumberFormatException
    //   129	145	147	java/lang/NumberFormatException
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QConfigJourney", 2, "clearFakeJourney");
    }
    this.jdField_b_of_type_Boolean = false;
    Object localObject = a();
    if (localObject != null)
    {
      Set localSet = ((SharedPreferences)localObject).getStringSet("safe_scoop", new HashSet());
      if (localSet.contains("fate_log_tag"))
      {
        localSet.remove("fate_log_tag");
        localObject = ((SharedPreferences)localObject).edit();
        ((SharedPreferences.Editor)localObject).remove("fate_log_tag");
        ((SharedPreferences.Editor)localObject).putStringSet("safe_scoop", localSet);
        ((SharedPreferences.Editor)localObject).commit();
      }
    }
  }
  
  /* Error */
  void b(String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 96	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifne +160 -> 164
    //   7: aload_3
    //   8: invokestatic 96	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11: ifne +153 -> 164
    //   14: aload_2
    //   15: invokestatic 119	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   18: invokevirtual 123	java/lang/Long:longValue	()J
    //   21: lstore 4
    //   23: aload_0
    //   24: ldc 254
    //   26: invokespecial 62	com/tencent/mobileqq/config/QConfigJourney:a	(Ljava/lang/String;)Landroid/content/SharedPreferences;
    //   29: astore_2
    //   30: aload_2
    //   31: ifnull +133 -> 164
    //   34: new 138	java/lang/StringBuilder
    //   37: dup
    //   38: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   41: ldc_w 367
    //   44: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: aload_1
    //   48: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: ldc 98
    //   53: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: lload 4
    //   58: invokevirtual 151	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   61: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   64: astore_1
    //   65: aload_3
    //   66: aload_2
    //   67: aload_1
    //   68: aconst_null
    //   69: invokeinterface 244 3 0
    //   74: invokestatic 385	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   77: ifeq +87 -> 164
    //   80: aload_2
    //   81: invokeinterface 68 1 0
    //   86: astore_2
    //   87: aload_0
    //   88: getfield 48	com/tencent/mobileqq/config/QConfigJourney:jdField_a_of_type_JavaUtilConcurrentLocksReadWriteLock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   91: invokeinterface 395 1 0
    //   96: invokeinterface 378 1 0
    //   101: aload_2
    //   102: aload_1
    //   103: invokeinterface 197 2 0
    //   108: pop
    //   109: aload_2
    //   110: invokeinterface 355 1 0
    //   115: pop
    //   116: aload_0
    //   117: getfield 48	com/tencent/mobileqq/config/QConfigJourney:jdField_a_of_type_JavaUtilConcurrentLocksReadWriteLock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   120: invokeinterface 395 1 0
    //   125: invokeinterface 381 1 0
    //   130: return
    //   131: astore_1
    //   132: aload_0
    //   133: getfield 48	com/tencent/mobileqq/config/QConfigJourney:jdField_a_of_type_JavaUtilConcurrentLocksReadWriteLock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   136: invokeinterface 395 1 0
    //   141: invokeinterface 381 1 0
    //   146: return
    //   147: astore_1
    //   148: aload_0
    //   149: getfield 48	com/tencent/mobileqq/config/QConfigJourney:jdField_a_of_type_JavaUtilConcurrentLocksReadWriteLock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   152: invokeinterface 395 1 0
    //   157: invokeinterface 381 1 0
    //   162: aload_1
    //   163: athrow
    //   164: return
    //   165: astore_1
    //   166: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	167	0	this	QConfigJourney
    //   0	167	1	paramString1	String
    //   0	167	2	paramString2	String
    //   0	167	3	paramString3	String
    //   21	36	4	l	long
    // Exception table:
    //   from	to	target	type
    //   101	116	131	java/lang/Exception
    //   101	116	147	finally
    //   14	30	165	java/lang/NumberFormatException
    //   34	101	165	java/lang/NumberFormatException
    //   116	130	165	java/lang/NumberFormatException
    //   132	146	165	java/lang/NumberFormatException
    //   148	164	165	java/lang/NumberFormatException
  }
  
  public void c()
  {
    Object localObject1 = a();
    StringBuilder localStringBuilder;
    Object localObject2;
    SharedPreferences.Editor localEditor;
    Iterator localIterator;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder("clear operation");
      if (localObject1 != null)
      {
        localObject2 = ((SharedPreferences)localObject1).getStringSet("safe_scoop", new HashSet());
        localEditor = ((SharedPreferences)localObject1).edit();
        if (localStringBuilder != null) {
          localStringBuilder.append(", scoops size=").append(((Set)localObject2).size());
        }
        localIterator = ((Set)localObject2).iterator();
      }
    }
    else
    {
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label279;
        }
        Object localObject3 = (String)localIterator.next();
        if (!TextUtils.isEmpty((CharSequence)localObject3))
        {
          Object localObject4 = ((SharedPreferences)localObject1).getStringSet((String)localObject3, new HashSet());
          localObject3 = new HashSet(((Set)localObject4).size());
          localObject4 = ((Set)localObject4).iterator();
          for (;;)
          {
            if (((Iterator)localObject4).hasNext())
            {
              QConfigJourney.Entry localEntry = a((String)((Iterator)localObject4).next());
              if (localEntry != null)
              {
                ((Set)localObject3).add(localEntry);
                continue;
                localStringBuilder = null;
                break;
              }
            }
          }
          localObject3 = ((Set)localObject3).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = (QConfigJourney.Entry)((Iterator)localObject3).next();
            if (((QConfigJourney.Entry)localObject4).jdField_a_of_type_Int == 0) {
              a((QConfigJourney.Entry)localObject4);
            } else if (((QConfigJourney.Entry)localObject4).jdField_a_of_type_Int == 1) {
              b((QConfigJourney.Entry)localObject4);
            } else {
              a((QConfigJourney.Entry)localObject4, localEditor);
            }
          }
        }
      }
      label279:
      localObject1 = this.jdField_b_of_type_JavaUtilMap.values().iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((SharedPreferences.Editor)((Iterator)localObject1).next()).commit();
      }
      this.jdField_a_of_type_JavaUtilMap.clear();
      this.jdField_b_of_type_JavaUtilMap.clear();
      localObject1 = ((Set)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          localEditor.remove((String)localObject2);
        }
      }
      localEditor.remove("safe_scoop");
      localEditor.commit();
    }
    if (QLog.isColorLevel()) {
      QLog.d("QConfigJourney", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.QConfigJourney
 * JD-Core Version:    0.7.0.1
 */