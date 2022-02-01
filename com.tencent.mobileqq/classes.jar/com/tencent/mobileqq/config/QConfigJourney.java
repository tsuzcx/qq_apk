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
  private static volatile QConfigJourney c;
  public volatile boolean a = false;
  public volatile boolean b = false;
  private SharedPreferences d;
  private Set<QConfigJourney.Entry> e = new HashSet(20);
  private Map<String, SharedPreferences> f = new HashMap(20);
  private Map<String, SharedPreferences.Editor> g = new HashMap(20);
  private String h;
  private final ReadWriteLock i = new ReentrantReadWriteLock();
  private final Object j = new Object();
  
  private QConfigJourney.Entry a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = paramString.split("-");
    if (paramString.length != 3) {
      return null;
    }
    try
    {
      int k = Integer.valueOf(paramString[0]).intValue();
      if (k >= 0)
      {
        if (k > 2) {
          return null;
        }
        if (TextUtils.isEmpty(paramString[1])) {
          return null;
        }
        String str = paramString[1];
        long l = Long.valueOf(paramString[2]).longValue();
        return new QConfigJourney.Entry(k, str, l, null);
      }
      return null;
    }
    catch (NumberFormatException paramString) {}
    return null;
  }
  
  public static QConfigJourney a()
  {
    if (c == null) {
      try
      {
        if (c == null) {
          c = new QConfigJourney();
        }
      }
      finally {}
    }
    return c;
  }
  
  private void a(QConfigJourney.Entry paramEntry)
  {
    if (paramEntry.a != 0) {
      return;
    }
    try
    {
      int k = Integer.valueOf(paramEntry.b).intValue();
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("conf_");
      ((StringBuilder)localObject1).append(paramEntry.c);
      ((StringBuilder)localObject1).append("_sharepref");
      localObject1 = ((StringBuilder)localObject1).toString();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("conf_");
      ((StringBuilder)localObject2).append(paramEntry.c);
      ((StringBuilder)localObject2).append("_content_sharepref");
      localObject2 = ((StringBuilder)localObject2).toString();
      Object localObject3 = b((String)localObject1);
      Object localObject4 = b((String)localObject2);
      boolean bool3 = false;
      boolean bool1 = false;
      boolean bool2 = bool3;
      if (localObject3 != null)
      {
        bool2 = bool3;
        if (localObject4 != null)
        {
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append(k);
          ((StringBuilder)localObject4).append("_ids");
          localObject4 = ((SharedPreferences)localObject3).getStringSet(((StringBuilder)localObject4).toString(), null);
          int m = ((SharedPreferences)localObject3).getInt(paramEntry.b, -1);
          bool2 = bool3;
          if (localObject4 != null)
          {
            bool2 = bool3;
            if (!((Set)localObject4).isEmpty())
            {
              localObject2 = c((String)localObject2);
              if (localObject2 != null)
              {
                localObject3 = ((Set)localObject4).iterator();
                while (((Iterator)localObject3).hasNext())
                {
                  localObject4 = (String)((Iterator)localObject3).next();
                  StringBuilder localStringBuilder = new StringBuilder();
                  localStringBuilder.append(k);
                  localStringBuilder.append("_");
                  localStringBuilder.append((String)localObject4);
                  ((SharedPreferences.Editor)localObject2).remove(localStringBuilder.toString());
                }
              }
              localObject1 = c((String)localObject1);
              if (localObject1 != null)
              {
                ((SharedPreferences.Editor)localObject1).remove(paramEntry.b);
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append(k);
                ((StringBuilder)localObject2).append("_ids");
                ((SharedPreferences.Editor)localObject1).remove(((StringBuilder)localObject2).toString());
                bool1 = true;
              }
              bool2 = bool1;
              if (bool1)
              {
                bool2 = bool1;
                if (m != -1)
                {
                  localObject1 = c("q_journey_safe_mode_deleted_confs_pref");
                  bool2 = bool1;
                  if (localObject1 != null)
                  {
                    long l = System.currentTimeMillis();
                    ((SharedPreferences.Editor)localObject1).putLong(paramEntry.b, l);
                    localObject2 = new StringBuilder();
                    ((StringBuilder)localObject2).append(k);
                    ((StringBuilder)localObject2).append("_version");
                    ((SharedPreferences.Editor)localObject1).putInt(((StringBuilder)localObject2).toString(), m);
                    bool2 = bool1;
                  }
                }
              }
            }
          }
        }
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("deleteSpConf, entry=");
        ((StringBuilder)localObject1).append(paramEntry);
        ((StringBuilder)localObject1).append(", success=");
        ((StringBuilder)localObject1).append(bool2);
        QLog.d("QConfigJourney", 2, ((StringBuilder)localObject1).toString());
      }
      return;
    }
    catch (NumberFormatException paramEntry) {}
  }
  
  private void a(QConfigJourney.Entry paramEntry, SharedPreferences.Editor paramEditor)
  {
    if (paramEntry.a != 2) {
      return;
    }
    Object localObject2 = e();
    boolean bool3 = false;
    boolean bool1 = false;
    Object localObject1 = null;
    boolean bool2 = bool3;
    String str;
    if (localObject2 != null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramEntry.a);
      ((StringBuilder)localObject1).append("-");
      ((StringBuilder)localObject1).append(paramEntry.b);
      ((StringBuilder)localObject1).append("-");
      ((StringBuilder)localObject1).append(paramEntry.c);
      str = ((StringBuilder)localObject1).toString();
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
      label144:
      break label144;
    }
    bool2 = bool1;
    localObject1 = localObject2;
    if (bool1)
    {
      localObject1 = c("q_journey_safe_mode_deleted_files_pref");
      if (localObject1 != null) {
        ((SharedPreferences.Editor)localObject1).putString(str, (String)localObject2);
      }
      paramEditor.remove(str);
      localObject1 = localObject2;
      bool2 = bool1;
    }
    if (QLog.isColorLevel())
    {
      paramEditor = new StringBuilder();
      paramEditor.append("deleteStorage, entry=");
      paramEditor.append(paramEntry);
      paramEditor.append(", path=");
      paramEditor.append((String)localObject1);
      paramEditor.append(", success=");
      paramEditor.append(bool2);
      QLog.d("QConfigJourney", 2, paramEditor.toString());
    }
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
          int k = 0;
          while (k < arrayOfString.length)
          {
            if (!a(new File(paramFile, arrayOfString[k]))) {
              return false;
            }
            k += 1;
          }
        }
      }
      return paramFile.delete();
    }
    return true;
  }
  
  private SharedPreferences b(String paramString)
  {
    SharedPreferences localSharedPreferences2 = (SharedPreferences)this.f.get(paramString);
    SharedPreferences localSharedPreferences1 = localSharedPreferences2;
    if (localSharedPreferences2 == null)
    {
      localSharedPreferences2 = MobileQQ.sMobileQQ.getSharedPreferences(paramString, 0);
      localSharedPreferences1 = localSharedPreferences2;
      if (localSharedPreferences2 != null)
      {
        this.f.put(paramString, localSharedPreferences2);
        localSharedPreferences1 = localSharedPreferences2;
      }
    }
    return localSharedPreferences1;
  }
  
  private void b(QConfigJourney.Entry paramEntry)
  {
    if (paramEntry.a != 1) {
      return;
    }
    try
    {
      k = Integer.valueOf(paramEntry.b).intValue();
      if (this.h == null) {
        b();
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(this.h);
      ((StringBuilder)localObject1).append(File.separator);
      ((StringBuilder)localObject1).append("qstore");
      ((StringBuilder)localObject1).append(File.separator);
      ((StringBuilder)localObject1).append(paramEntry.c);
      ((StringBuilder)localObject1).append(File.separator);
      ((StringBuilder)localObject1).append("conf");
      ((StringBuilder)localObject1).append(File.separator);
      ((StringBuilder)localObject1).append(k);
      localObject1 = ((StringBuilder)localObject1).toString();
      localObject2 = new File((String)localObject1);
      bool1 = false;
    }
    catch (NumberFormatException paramEntry)
    {
      int k;
      Object localObject1;
      Object localObject2;
      boolean bool1;
      boolean bool2;
      label154:
      Object localObject3;
      int m;
      long l;
      return;
    }
    try
    {
      bool2 = a((File)localObject2);
      bool1 = bool2;
    }
    catch (Exception localException)
    {
      break label154;
    }
    if (bool1)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("conf_");
      ((StringBuilder)localObject2).append(paramEntry.c);
      ((StringBuilder)localObject2).append("_sharepref");
      localObject3 = ((StringBuilder)localObject2).toString();
      localObject2 = b((String)localObject3);
      if (localObject2 != null)
      {
        localObject3 = c((String)localObject3);
        m = ((SharedPreferences)localObject2).getInt(paramEntry.b, -1);
        if ((m != -1) && (localObject3 != null))
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(paramEntry.b);
          ((StringBuilder)localObject2).append("_");
          ((StringBuilder)localObject2).append(m);
          ((StringBuilder)localObject2).append("_defualt");
          ((SharedPreferences.Editor)localObject3).remove(((StringBuilder)localObject2).toString());
        }
        if (localObject3 != null) {
          ((SharedPreferences.Editor)localObject3).remove(paramEntry.b);
        }
        localObject2 = c("q_journey_safe_mode_deleted_confs_pref");
        if (localObject2 != null)
        {
          l = System.currentTimeMillis();
          ((SharedPreferences.Editor)localObject2).putLong(paramEntry.b, l);
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(k);
          ((StringBuilder)localObject3).append("_version");
          ((SharedPreferences.Editor)localObject2).putInt(((StringBuilder)localObject3).toString(), m);
        }
      }
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("deleteFileConf, entry=");
      ((StringBuilder)localObject2).append(paramEntry);
      ((StringBuilder)localObject2).append(", path=");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(", success=");
      ((StringBuilder)localObject2).append(bool1);
      QLog.d("QConfigJourney", 2, ((StringBuilder)localObject2).toString());
    }
  }
  
  private SharedPreferences.Editor c(String paramString)
  {
    Object localObject = (SharedPreferences.Editor)this.g.get(paramString);
    if (localObject == null)
    {
      localObject = b(paramString);
      if (localObject != null)
      {
        localObject = ((SharedPreferences)localObject).edit();
        this.g.put(paramString, localObject);
        return localObject;
      }
      return null;
    }
    return localObject;
  }
  
  private SharedPreferences e()
  {
    if (this.d == null) {
      this.d = MobileQQ.sMobileQQ.getSharedPreferences("q_journey_safe_mode_pref", 0);
    }
    return this.d;
  }
  
  void a(int paramInt, long paramLong, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  void a(String arg1, String paramString2, String paramString3)
  {
    if ((this.a) && (!TextUtils.isEmpty(???)) && (!TextUtils.isEmpty(paramString3))) {}
    try
    {
      paramString2 = new QConfigJourney.Entry(2, ???, Long.valueOf(paramString2).longValue(), paramString3);
      synchronized (this.j)
      {
        this.e.add(paramString2);
      }
    }
    catch (NumberFormatException ???)
    {
      label67:
      break label67;
    }
    if (this.b) {
      a(true);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.a = false;
    }
    synchronized (this.j)
    {
      int k = this.e.size();
      Object localObject3 = new HashSet(this.e);
      this.e.clear();
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append("makeAJourney, size=");
        ((StringBuilder)???).append(k);
        ((StringBuilder)???).append(", fate=");
        ((StringBuilder)???).append(paramBoolean);
        QLog.d("QConfigJourney", 2, ((StringBuilder)???).toString());
      }
      if (!((Set)localObject3).isEmpty())
      {
        Object localObject4 = e();
        if (localObject4 != null)
        {
          SharedPreferences.Editor localEditor = ((SharedPreferences)localObject4).edit();
          Set localSet = ((SharedPreferences)localObject4).getStringSet("safe_scoop", new HashSet());
          if (paramBoolean) {
            ??? = "fate_log_tag";
          } else {
            ??? = String.valueOf(System.currentTimeMillis() / 1000L);
          }
          HashSet localHashSet = new HashSet(k);
          if (paramBoolean)
          {
            localObject4 = ((SharedPreferences)localObject4).getStringSet((String)???, null);
            if ((localObject4 != null) && (!((Set)localObject4).isEmpty())) {
              localHashSet.addAll((Collection)localObject4);
            }
          }
          localObject3 = ((Set)localObject3).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = (QConfigJourney.Entry)((Iterator)localObject3).next();
            Object localObject5 = new StringBuilder();
            ((StringBuilder)localObject5).append(((QConfigJourney.Entry)localObject4).a);
            ((StringBuilder)localObject5).append("-");
            ((StringBuilder)localObject5).append(((QConfigJourney.Entry)localObject4).b);
            ((StringBuilder)localObject5).append("-");
            ((StringBuilder)localObject5).append(((QConfigJourney.Entry)localObject4).c);
            localObject5 = ((StringBuilder)localObject5).toString();
            if (((QConfigJourney.Entry)localObject4).a == 2) {
              localEditor.putString((String)localObject5, ((QConfigJourney.Entry)localObject4).d);
            }
            localHashSet.add(localObject5);
          }
          localSet.add(???);
          localEditor.putStringSet((String)???, localHashSet);
          localEditor.putStringSet("safe_scoop", localSet);
          localEditor.commit();
        }
      }
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  boolean a(int paramInt1, int paramInt2)
  {
    SharedPreferences localSharedPreferences = b("q_journey_safe_mode_deleted_confs_pref");
    if (localSharedPreferences == null) {
      return false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("_version");
    int k = localSharedPreferences.getInt(localStringBuilder.toString(), -1);
    if (k == -1) {
      return false;
    }
    if (k != paramInt2) {
      return false;
    }
    long l = localSharedPreferences.getLong(String.valueOf(paramInt1), -1L);
    if (l == -1L) {
      return false;
    }
    return l + 10800000L > System.currentTimeMillis();
  }
  
  public void b()
  {
    if (MobileQQ.sMobileQQ != null)
    {
      localObject2 = MobileQQ.sMobileQQ.getFilesDir();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = MobileQQ.sMobileQQ.getCacheDir();
      }
      if (localObject1 != null)
      {
        localObject1 = ((File)localObject1).getParent();
        break label40;
      }
    }
    Object localObject1 = null;
    label40:
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = localObject1;
      if (MobileQQ.sMobileQQ != null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(File.separator);
        ((StringBuilder)localObject1).append("data");
        ((StringBuilder)localObject1).append(File.separator);
        ((StringBuilder)localObject1).append("data");
        ((StringBuilder)localObject1).append(File.separator);
        ((StringBuilder)localObject1).append(MobileQQ.sMobileQQ.getPackageName());
        localObject2 = ((StringBuilder)localObject1).toString();
      }
    }
    this.h = ((String)localObject2);
  }
  
  /* Error */
  boolean b(String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 65	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifne +158 -> 162
    //   7: aload_3
    //   8: invokestatic 65	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11: ifne +151 -> 162
    //   14: aload_2
    //   15: invokestatic 88	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   18: invokevirtual 92	java/lang/Long:longValue	()J
    //   21: lstore 4
    //   23: aload_0
    //   24: ldc 233
    //   26: invokespecial 133	com/tencent/mobileqq/config/QConfigJourney:b	(Ljava/lang/String;)Landroid/content/SharedPreferences;
    //   29: astore_2
    //   30: new 109	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   37: astore 7
    //   39: aload 7
    //   41: ldc_w 382
    //   44: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: pop
    //   48: aload 7
    //   50: aload_1
    //   51: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: pop
    //   55: aload 7
    //   57: ldc 67
    //   59: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: pop
    //   63: aload 7
    //   65: lload 4
    //   67: invokevirtual 122	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   70: pop
    //   71: aload 7
    //   73: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   76: astore 7
    //   78: aload_0
    //   79: getfield 54	com/tencent/mobileqq/config/QConfigJourney:i	Ljava/util/concurrent/locks/ReadWriteLock;
    //   82: invokeinterface 388 1 0
    //   87: invokeinterface 393 1 0
    //   92: aconst_null
    //   93: astore_1
    //   94: aload_2
    //   95: aload 7
    //   97: aconst_null
    //   98: invokeinterface 223 3 0
    //   103: astore 7
    //   105: aload_0
    //   106: getfield 54	com/tencent/mobileqq/config/QConfigJourney:i	Ljava/util/concurrent/locks/ReadWriteLock;
    //   109: astore_2
    //   110: aload 7
    //   112: astore_1
    //   113: aload_2
    //   114: invokeinterface 388 1 0
    //   119: invokeinterface 396 1 0
    //   124: goto +28 -> 152
    //   127: astore_1
    //   128: aload_0
    //   129: getfield 54	com/tencent/mobileqq/config/QConfigJourney:i	Ljava/util/concurrent/locks/ReadWriteLock;
    //   132: invokeinterface 388 1 0
    //   137: invokeinterface 396 1 0
    //   142: aload_1
    //   143: athrow
    //   144: aload_0
    //   145: getfield 54	com/tencent/mobileqq/config/QConfigJourney:i	Ljava/util/concurrent/locks/ReadWriteLock;
    //   148: astore_2
    //   149: goto -36 -> 113
    //   152: aload_3
    //   153: aload_1
    //   154: invokestatic 400	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   157: istore 6
    //   159: iload 6
    //   161: ireturn
    //   162: iconst_0
    //   163: ireturn
    //   164: astore_1
    //   165: iconst_0
    //   166: ireturn
    //   167: astore_2
    //   168: goto -24 -> 144
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	171	0	this	QConfigJourney
    //   0	171	1	paramString1	String
    //   0	171	2	paramString2	String
    //   0	171	3	paramString3	String
    //   21	45	4	l	long
    //   157	3	6	bool	boolean
    //   37	74	7	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   94	105	127	finally
    //   14	92	164	java/lang/NumberFormatException
    //   105	110	164	java/lang/NumberFormatException
    //   113	124	164	java/lang/NumberFormatException
    //   128	144	164	java/lang/NumberFormatException
    //   144	149	164	java/lang/NumberFormatException
    //   152	159	164	java/lang/NumberFormatException
    //   94	105	167	java/lang/Exception
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QConfigJourney", 2, "clearFakeJourney");
    }
    this.b = false;
    Object localObject = e();
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
  void c(String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 65	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifne +170 -> 174
    //   7: aload_3
    //   8: invokestatic 65	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11: ifne +163 -> 174
    //   14: aload_2
    //   15: invokestatic 88	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   18: invokevirtual 92	java/lang/Long:longValue	()J
    //   21: lstore 4
    //   23: aload_0
    //   24: ldc 233
    //   26: invokespecial 133	com/tencent/mobileqq/config/QConfigJourney:b	(Ljava/lang/String;)Landroid/content/SharedPreferences;
    //   29: astore_2
    //   30: aload_2
    //   31: ifnull +143 -> 174
    //   34: new 109	java/lang/StringBuilder
    //   37: dup
    //   38: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   41: astore 6
    //   43: aload 6
    //   45: ldc_w 382
    //   48: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: pop
    //   52: aload 6
    //   54: aload_1
    //   55: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: pop
    //   59: aload 6
    //   61: ldc 67
    //   63: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: pop
    //   67: aload 6
    //   69: lload 4
    //   71: invokevirtual 122	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   74: pop
    //   75: aload 6
    //   77: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   80: astore_1
    //   81: aload_3
    //   82: aload_2
    //   83: aload_1
    //   84: aconst_null
    //   85: invokeinterface 223 3 0
    //   90: invokestatic 400	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   93: ifeq +81 -> 174
    //   96: aload_2
    //   97: invokeinterface 296 1 0
    //   102: astore_2
    //   103: aload_0
    //   104: getfield 54	com/tencent/mobileqq/config/QConfigJourney:i	Ljava/util/concurrent/locks/ReadWriteLock;
    //   107: invokeinterface 410 1 0
    //   112: invokeinterface 393 1 0
    //   117: aload_2
    //   118: aload_1
    //   119: invokeinterface 176 2 0
    //   124: pop
    //   125: aload_2
    //   126: invokeinterface 352 1 0
    //   131: pop
    //   132: aload_0
    //   133: getfield 54	com/tencent/mobileqq/config/QConfigJourney:i	Ljava/util/concurrent/locks/ReadWriteLock;
    //   136: astore_1
    //   137: aload_1
    //   138: invokeinterface 410 1 0
    //   143: invokeinterface 396 1 0
    //   148: return
    //   149: astore_1
    //   150: aload_0
    //   151: getfield 54	com/tencent/mobileqq/config/QConfigJourney:i	Ljava/util/concurrent/locks/ReadWriteLock;
    //   154: invokeinterface 410 1 0
    //   159: invokeinterface 396 1 0
    //   164: aload_1
    //   165: athrow
    //   166: aload_0
    //   167: getfield 54	com/tencent/mobileqq/config/QConfigJourney:i	Ljava/util/concurrent/locks/ReadWriteLock;
    //   170: astore_1
    //   171: goto -34 -> 137
    //   174: return
    //   175: astore_1
    //   176: return
    //   177: astore_1
    //   178: goto -12 -> 166
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	181	0	this	QConfigJourney
    //   0	181	1	paramString1	String
    //   0	181	2	paramString2	String
    //   0	181	3	paramString3	String
    //   21	49	4	l	long
    //   41	35	6	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   117	132	149	finally
    //   14	30	175	java/lang/NumberFormatException
    //   34	117	175	java/lang/NumberFormatException
    //   132	137	175	java/lang/NumberFormatException
    //   137	148	175	java/lang/NumberFormatException
    //   150	166	175	java/lang/NumberFormatException
    //   166	171	175	java/lang/NumberFormatException
    //   117	132	177	java/lang/Exception
  }
  
  public void d()
  {
    Object localObject1 = e();
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel()) {
      localStringBuilder = new StringBuilder("clear operation");
    } else {
      localStringBuilder = null;
    }
    if (localObject1 != null)
    {
      Object localObject2 = ((SharedPreferences)localObject1).getStringSet("safe_scoop", new HashSet());
      SharedPreferences.Editor localEditor = ((SharedPreferences)localObject1).edit();
      if (localStringBuilder != null)
      {
        localStringBuilder.append(", scoops size=");
        localStringBuilder.append(((Set)localObject2).size());
      }
      Iterator localIterator = ((Set)localObject2).iterator();
      while (localIterator.hasNext())
      {
        Object localObject3 = (String)localIterator.next();
        if (!TextUtils.isEmpty((CharSequence)localObject3))
        {
          Object localObject4 = ((SharedPreferences)localObject1).getStringSet((String)localObject3, new HashSet());
          localObject3 = new HashSet(((Set)localObject4).size());
          localObject4 = ((Set)localObject4).iterator();
          while (((Iterator)localObject4).hasNext())
          {
            QConfigJourney.Entry localEntry = a((String)((Iterator)localObject4).next());
            if (localEntry != null) {
              ((Set)localObject3).add(localEntry);
            }
          }
          localObject3 = ((Set)localObject3).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = (QConfigJourney.Entry)((Iterator)localObject3).next();
            if (((QConfigJourney.Entry)localObject4).a == 0) {
              a((QConfigJourney.Entry)localObject4);
            } else if (((QConfigJourney.Entry)localObject4).a == 1) {
              b((QConfigJourney.Entry)localObject4);
            } else {
              a((QConfigJourney.Entry)localObject4, localEditor);
            }
          }
        }
      }
      localObject1 = this.g.values().iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((SharedPreferences.Editor)((Iterator)localObject1).next()).commit();
      }
      this.f.clear();
      this.g.clear();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.QConfigJourney
 * JD-Core Version:    0.7.0.1
 */