package com.tencent.mobileqq.statistics;

import awsd;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;

public class UnifiedMonitor$StackGetterJob
  implements Runnable
{
  private int jdField_a_of_type_Int;
  private final String jdField_a_of_type_JavaLangString = "android.support.v4.";
  private StringBuilder jdField_a_of_type_JavaLangStringBuilder = new StringBuilder(1024);
  private Thread jdField_a_of_type_JavaLangThread;
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList;
  private final String[] jdField_a_of_type_ArrayOfJavaLangString = { "java.", "android.", "com.android.", "dalvik.", "com.google", "libcore.", "sun.", "com.qihoo360.", "com.lbe." };
  private int b;
  private int c;
  private final int d;
  
  public UnifiedMonitor$StackGetterJob(UnifiedMonitor paramUnifiedMonitor, int paramInt, Thread paramThread)
  {
    this.jdField_d_of_type_Int = 10;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_b_of_type_Int = UnifiedMonitor.a(paramUnifiedMonitor)[paramInt].jdField_a_of_type_Int;
    if (UnifiedMonitor.a(paramUnifiedMonitor)[paramInt].jdField_d_of_type_Int > UnifiedMonitor.a(paramUnifiedMonitor)[paramInt].jdField_a_of_type_Int) {}
    for (int i = UnifiedMonitor.a(paramUnifiedMonitor)[paramInt].jdField_d_of_type_Int - UnifiedMonitor.a(paramUnifiedMonitor)[paramInt].jdField_a_of_type_Int;; i = UnifiedMonitor.a(paramUnifiedMonitor)[paramInt].jdField_d_of_type_Int)
    {
      this.c = i;
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(UnifiedMonitor.a(paramUnifiedMonitor)[paramInt].c);
      this.jdField_a_of_type_JavaLangThread = paramThread;
      return;
    }
  }
  
  private String a(boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        localObject = this.jdField_a_of_type_JavaLangThread.getStackTrace();
        if (localObject == null) {
          return null;
        }
        if (!paramBoolean) {
          break label271;
        }
        return Arrays.toString((Object[])localObject);
      }
      catch (Throwable localThrowable)
      {
        Object localObject;
        String str;
        String[] arrayOfString;
        int m;
        if (!QLog.isColorLevel()) {
          break label264;
        }
        QLog.d("UnifiedMonitor", 2, "", localThrowable);
      }
      if (k < localObject.length)
      {
        str = localObject[k].toString();
        arrayOfString = this.jdField_a_of_type_ArrayOfJavaLangString;
        m = arrayOfString.length;
        j = 0;
        if (j < m)
        {
          if (!str.startsWith(arrayOfString[j])) {
            break label297;
          }
          if (!str.startsWith("android.support.v4.")) {
            break label292;
          }
          j = 0;
          break label279;
        }
      }
      else
      {
        if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
        {
          this.jdField_a_of_type_JavaLangStringBuilder.setLength(0);
          j = UnifiedMonitor.a(this.this$0)[this.jdField_a_of_type_Int].i;
          i = this.jdField_a_of_type_JavaUtilArrayList.size() - 1 - j;
          if ((i >= 0) && (i > this.jdField_a_of_type_JavaUtilArrayList.size() - 1 - j - UnifiedMonitor.a(this.this$0)[this.jdField_a_of_type_Int].c))
          {
            this.jdField_a_of_type_JavaLangStringBuilder.append((String)this.jdField_a_of_type_JavaUtilArrayList.get(i)).append(",");
            i -= 1;
            continue;
            this.jdField_a_of_type_JavaUtilArrayList.add(str);
            break label315;
          }
          if (this.jdField_a_of_type_JavaLangStringBuilder.length() > 0)
          {
            localObject = this.jdField_a_of_type_JavaLangStringBuilder.toString();
            return localObject;
          }
          return null;
        }
        label264:
        return null;
      }
      int j = 0;
      break label279;
      label271:
      int k = 0;
      int i = 0;
      continue;
      for (;;)
      {
        label279:
        if (j == 0) {
          break label304;
        }
        j = i;
        if (i == 0) {
          break label315;
        }
        break;
        label292:
        j = 1;
      }
      label297:
      j += 1;
      continue;
      label304:
      j = i;
      if (i == 0)
      {
        j = 1;
        continue;
        label315:
        k += 1;
        i = j;
      }
    }
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: new 158	java/util/Random
    //   3: dup
    //   4: invokespecial 159	java/util/Random:<init>	()V
    //   7: astore 5
    //   9: aload_0
    //   10: getfield 23	com/tencent/mobileqq/statistics/UnifiedMonitor$StackGetterJob:this$0	Lcom/tencent/mobileqq/statistics/UnifiedMonitor;
    //   13: invokestatic 68	com/tencent/mobileqq/statistics/UnifiedMonitor:a	(Lcom/tencent/mobileqq/statistics/UnifiedMonitor;)[Lawsd;
    //   16: aload_0
    //   17: getfield 63	com/tencent/mobileqq/statistics/UnifiedMonitor$StackGetterJob:jdField_a_of_type_Int	I
    //   20: aaload
    //   21: getfield 162	awsd:g	I
    //   24: aload_0
    //   25: getfield 23	com/tencent/mobileqq/statistics/UnifiedMonitor$StackGetterJob:this$0	Lcom/tencent/mobileqq/statistics/UnifiedMonitor;
    //   28: invokestatic 68	com/tencent/mobileqq/statistics/UnifiedMonitor:a	(Lcom/tencent/mobileqq/statistics/UnifiedMonitor;)[Lawsd;
    //   31: aload_0
    //   32: getfield 63	com/tencent/mobileqq/statistics/UnifiedMonitor$StackGetterJob:jdField_a_of_type_Int	I
    //   35: aaload
    //   36: getfield 163	awsd:jdField_b_of_type_Int	I
    //   39: if_icmplt +15 -> 54
    //   42: aload_0
    //   43: getfield 23	com/tencent/mobileqq/statistics/UnifiedMonitor$StackGetterJob:this$0	Lcom/tencent/mobileqq/statistics/UnifiedMonitor;
    //   46: aload_0
    //   47: getfield 63	com/tencent/mobileqq/statistics/UnifiedMonitor$StackGetterJob:jdField_a_of_type_Int	I
    //   50: invokestatic 166	com/tencent/mobileqq/statistics/UnifiedMonitor:a	(Lcom/tencent/mobileqq/statistics/UnifiedMonitor;I)V
    //   53: return
    //   54: aload_0
    //   55: getfield 23	com/tencent/mobileqq/statistics/UnifiedMonitor$StackGetterJob:this$0	Lcom/tencent/mobileqq/statistics/UnifiedMonitor;
    //   58: invokestatic 68	com/tencent/mobileqq/statistics/UnifiedMonitor:a	(Lcom/tencent/mobileqq/statistics/UnifiedMonitor;)[Lawsd;
    //   61: aload_0
    //   62: getfield 63	com/tencent/mobileqq/statistics/UnifiedMonitor$StackGetterJob:jdField_a_of_type_Int	I
    //   65: aaload
    //   66: getfield 169	awsd:jdField_b_of_type_Long	J
    //   69: lconst_0
    //   70: lcmp
    //   71: ifne +19 -> 90
    //   74: aload_0
    //   75: getfield 73	com/tencent/mobileqq/statistics/UnifiedMonitor$StackGetterJob:jdField_b_of_type_Int	I
    //   78: i2l
    //   79: invokestatic 173	java/lang/Thread:sleep	(J)V
    //   82: goto -73 -> 9
    //   85: astore 6
    //   87: goto -78 -> 9
    //   90: aload_0
    //   91: getfield 23	com/tencent/mobileqq/statistics/UnifiedMonitor$StackGetterJob:this$0	Lcom/tencent/mobileqq/statistics/UnifiedMonitor;
    //   94: invokestatic 68	com/tencent/mobileqq/statistics/UnifiedMonitor:a	(Lcom/tencent/mobileqq/statistics/UnifiedMonitor;)[Lawsd;
    //   97: aload_0
    //   98: getfield 63	com/tencent/mobileqq/statistics/UnifiedMonitor$StackGetterJob:jdField_a_of_type_Int	I
    //   101: aaload
    //   102: getfield 169	awsd:jdField_b_of_type_Long	J
    //   105: lstore_1
    //   106: lload_1
    //   107: lconst_0
    //   108: lcmp
    //   109: ifne +19 -> 128
    //   112: aload_0
    //   113: getfield 73	com/tencent/mobileqq/statistics/UnifiedMonitor$StackGetterJob:jdField_b_of_type_Int	I
    //   116: i2l
    //   117: invokestatic 173	java/lang/Thread:sleep	(J)V
    //   120: goto -111 -> 9
    //   123: astore 6
    //   125: goto -116 -> 9
    //   128: invokestatic 179	android/os/SystemClock:uptimeMillis	()J
    //   131: aload_0
    //   132: getfield 23	com/tencent/mobileqq/statistics/UnifiedMonitor$StackGetterJob:this$0	Lcom/tencent/mobileqq/statistics/UnifiedMonitor;
    //   135: invokestatic 68	com/tencent/mobileqq/statistics/UnifiedMonitor:a	(Lcom/tencent/mobileqq/statistics/UnifiedMonitor;)[Lawsd;
    //   138: aload_0
    //   139: getfield 63	com/tencent/mobileqq/statistics/UnifiedMonitor$StackGetterJob:jdField_a_of_type_Int	I
    //   142: aaload
    //   143: getfield 169	awsd:jdField_b_of_type_Long	J
    //   146: lsub
    //   147: aload_0
    //   148: getfield 23	com/tencent/mobileqq/statistics/UnifiedMonitor$StackGetterJob:this$0	Lcom/tencent/mobileqq/statistics/UnifiedMonitor;
    //   151: invokestatic 68	com/tencent/mobileqq/statistics/UnifiedMonitor:a	(Lcom/tencent/mobileqq/statistics/UnifiedMonitor;)[Lawsd;
    //   154: aload_0
    //   155: getfield 63	com/tencent/mobileqq/statistics/UnifiedMonitor$StackGetterJob:jdField_a_of_type_Int	I
    //   158: aaload
    //   159: getfield 71	awsd:jdField_a_of_type_Int	I
    //   162: i2l
    //   163: lsub
    //   164: lstore_3
    //   165: lload_3
    //   166: ldc2_w 180
    //   169: lcmp
    //   170: ifge +10 -> 180
    //   173: lload_3
    //   174: lneg
    //   175: lstore_3
    //   176: lload_3
    //   177: invokestatic 173	java/lang/Thread:sleep	(J)V
    //   180: lload_1
    //   181: aload_0
    //   182: getfield 23	com/tencent/mobileqq/statistics/UnifiedMonitor$StackGetterJob:this$0	Lcom/tencent/mobileqq/statistics/UnifiedMonitor;
    //   185: invokestatic 68	com/tencent/mobileqq/statistics/UnifiedMonitor:a	(Lcom/tencent/mobileqq/statistics/UnifiedMonitor;)[Lawsd;
    //   188: aload_0
    //   189: getfield 63	com/tencent/mobileqq/statistics/UnifiedMonitor$StackGetterJob:jdField_a_of_type_Int	I
    //   192: aaload
    //   193: getfield 169	awsd:jdField_b_of_type_Long	J
    //   196: lcmp
    //   197: ifne -188 -> 9
    //   200: aload_0
    //   201: getfield 23	com/tencent/mobileqq/statistics/UnifiedMonitor$StackGetterJob:this$0	Lcom/tencent/mobileqq/statistics/UnifiedMonitor;
    //   204: invokestatic 68	com/tencent/mobileqq/statistics/UnifiedMonitor:a	(Lcom/tencent/mobileqq/statistics/UnifiedMonitor;)[Lawsd;
    //   207: aload_0
    //   208: getfield 63	com/tencent/mobileqq/statistics/UnifiedMonitor$StackGetterJob:jdField_a_of_type_Int	I
    //   211: aaload
    //   212: aload_0
    //   213: getfield 23	com/tencent/mobileqq/statistics/UnifiedMonitor$StackGetterJob:this$0	Lcom/tencent/mobileqq/statistics/UnifiedMonitor;
    //   216: aload_0
    //   217: getfield 63	com/tencent/mobileqq/statistics/UnifiedMonitor$StackGetterJob:jdField_a_of_type_Int	I
    //   220: iconst_0
    //   221: invokevirtual 185	com/tencent/mobileqq/statistics/UnifiedMonitor:whetherReportThisTime	(IZ)Z
    //   224: putfield 188	awsd:jdField_b_of_type_Boolean	Z
    //   227: aload_0
    //   228: getfield 63	com/tencent/mobileqq/statistics/UnifiedMonitor$StackGetterJob:jdField_a_of_type_Int	I
    //   231: ifeq +30 -> 261
    //   234: aload_0
    //   235: getfield 63	com/tencent/mobileqq/statistics/UnifiedMonitor$StackGetterJob:jdField_a_of_type_Int	I
    //   238: bipush 10
    //   240: if_icmpeq +21 -> 261
    //   243: aload_0
    //   244: getfield 63	com/tencent/mobileqq/statistics/UnifiedMonitor$StackGetterJob:jdField_a_of_type_Int	I
    //   247: bipush 14
    //   249: if_icmpeq +12 -> 261
    //   252: aload_0
    //   253: getfield 63	com/tencent/mobileqq/statistics/UnifiedMonitor$StackGetterJob:jdField_a_of_type_Int	I
    //   256: bipush 19
    //   258: if_icmpne +151 -> 409
    //   261: invokestatic 146	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   264: ifeq +145 -> 409
    //   267: ldc2_w 189
    //   270: invokestatic 173	java/lang/Thread:sleep	(J)V
    //   273: lload_1
    //   274: aload_0
    //   275: getfield 23	com/tencent/mobileqq/statistics/UnifiedMonitor$StackGetterJob:this$0	Lcom/tencent/mobileqq/statistics/UnifiedMonitor;
    //   278: invokestatic 68	com/tencent/mobileqq/statistics/UnifiedMonitor:a	(Lcom/tencent/mobileqq/statistics/UnifiedMonitor;)[Lawsd;
    //   281: aload_0
    //   282: getfield 63	com/tencent/mobileqq/statistics/UnifiedMonitor$StackGetterJob:jdField_a_of_type_Int	I
    //   285: aaload
    //   286: getfield 169	awsd:jdField_b_of_type_Long	J
    //   289: lcmp
    //   290: ifne +80 -> 370
    //   293: aload_0
    //   294: iconst_1
    //   295: invokespecial 192	com/tencent/mobileqq/statistics/UnifiedMonitor$StackGetterJob:a	(Z)Ljava/lang/String;
    //   298: astore 6
    //   300: ldc 148
    //   302: iconst_2
    //   303: aload 6
    //   305: invokestatic 196	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   308: aload_0
    //   309: getfield 23	com/tencent/mobileqq/statistics/UnifiedMonitor$StackGetterJob:this$0	Lcom/tencent/mobileqq/statistics/UnifiedMonitor;
    //   312: invokestatic 68	com/tencent/mobileqq/statistics/UnifiedMonitor:a	(Lcom/tencent/mobileqq/statistics/UnifiedMonitor;)[Lawsd;
    //   315: aload_0
    //   316: getfield 63	com/tencent/mobileqq/statistics/UnifiedMonitor$StackGetterJob:jdField_a_of_type_Int	I
    //   319: aaload
    //   320: aload 6
    //   322: putfield 197	awsd:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   325: aload_0
    //   326: getfield 23	com/tencent/mobileqq/statistics/UnifiedMonitor$StackGetterJob:this$0	Lcom/tencent/mobileqq/statistics/UnifiedMonitor;
    //   329: invokestatic 200	com/tencent/mobileqq/statistics/UnifiedMonitor:a	(Lcom/tencent/mobileqq/statistics/UnifiedMonitor;)Landroid/os/Handler;
    //   332: iconst_2
    //   333: invokestatic 206	android/os/Message:obtain	(Landroid/os/Handler;I)Landroid/os/Message;
    //   336: astore 6
    //   338: aload 6
    //   340: aload_0
    //   341: getfield 63	com/tencent/mobileqq/statistics/UnifiedMonitor$StackGetterJob:jdField_a_of_type_Int	I
    //   344: putfield 209	android/os/Message:arg1	I
    //   347: aload_0
    //   348: getfield 23	com/tencent/mobileqq/statistics/UnifiedMonitor$StackGetterJob:this$0	Lcom/tencent/mobileqq/statistics/UnifiedMonitor;
    //   351: invokestatic 200	com/tencent/mobileqq/statistics/UnifiedMonitor:a	(Lcom/tencent/mobileqq/statistics/UnifiedMonitor;)Landroid/os/Handler;
    //   354: aload 6
    //   356: invokestatic 179	android/os/SystemClock:uptimeMillis	()J
    //   359: lneg
    //   360: lload_1
    //   361: ladd
    //   362: ldc2_w 210
    //   365: ladd
    //   366: invokevirtual 217	android/os/Handler:sendMessageDelayed	(Landroid/os/Message;J)Z
    //   369: pop
    //   370: lload_1
    //   371: aload_0
    //   372: getfield 23	com/tencent/mobileqq/statistics/UnifiedMonitor$StackGetterJob:this$0	Lcom/tencent/mobileqq/statistics/UnifiedMonitor;
    //   375: invokestatic 68	com/tencent/mobileqq/statistics/UnifiedMonitor:a	(Lcom/tencent/mobileqq/statistics/UnifiedMonitor;)[Lawsd;
    //   378: aload_0
    //   379: getfield 63	com/tencent/mobileqq/statistics/UnifiedMonitor$StackGetterJob:jdField_a_of_type_Int	I
    //   382: aaload
    //   383: getfield 169	awsd:jdField_b_of_type_Long	J
    //   386: lcmp
    //   387: ifne -378 -> 9
    //   390: aload_0
    //   391: getfield 23	com/tencent/mobileqq/statistics/UnifiedMonitor$StackGetterJob:this$0	Lcom/tencent/mobileqq/statistics/UnifiedMonitor;
    //   394: invokestatic 68	com/tencent/mobileqq/statistics/UnifiedMonitor:a	(Lcom/tencent/mobileqq/statistics/UnifiedMonitor;)[Lawsd;
    //   397: aload_0
    //   398: getfield 63	com/tencent/mobileqq/statistics/UnifiedMonitor$StackGetterJob:jdField_a_of_type_Int	I
    //   401: aaload
    //   402: lconst_0
    //   403: putfield 169	awsd:jdField_b_of_type_Long	J
    //   406: goto -397 -> 9
    //   409: aload_0
    //   410: getfield 23	com/tencent/mobileqq/statistics/UnifiedMonitor$StackGetterJob:this$0	Lcom/tencent/mobileqq/statistics/UnifiedMonitor;
    //   413: invokestatic 68	com/tencent/mobileqq/statistics/UnifiedMonitor:a	(Lcom/tencent/mobileqq/statistics/UnifiedMonitor;)[Lawsd;
    //   416: aload_0
    //   417: getfield 63	com/tencent/mobileqq/statistics/UnifiedMonitor$StackGetterJob:jdField_a_of_type_Int	I
    //   420: aaload
    //   421: getfield 188	awsd:jdField_b_of_type_Boolean	Z
    //   424: ifeq -54 -> 370
    //   427: aload 5
    //   429: aload_0
    //   430: getfield 76	com/tencent/mobileqq/statistics/UnifiedMonitor$StackGetterJob:c	I
    //   433: invokevirtual 221	java/util/Random:nextInt	(I)I
    //   436: i2l
    //   437: lstore_3
    //   438: lload_3
    //   439: invokestatic 173	java/lang/Thread:sleep	(J)V
    //   442: lload_1
    //   443: aload_0
    //   444: getfield 23	com/tencent/mobileqq/statistics/UnifiedMonitor$StackGetterJob:this$0	Lcom/tencent/mobileqq/statistics/UnifiedMonitor;
    //   447: invokestatic 68	com/tencent/mobileqq/statistics/UnifiedMonitor:a	(Lcom/tencent/mobileqq/statistics/UnifiedMonitor;)[Lawsd;
    //   450: aload_0
    //   451: getfield 63	com/tencent/mobileqq/statistics/UnifiedMonitor$StackGetterJob:jdField_a_of_type_Int	I
    //   454: aaload
    //   455: getfield 169	awsd:jdField_b_of_type_Long	J
    //   458: lcmp
    //   459: ifne -89 -> 370
    //   462: aload_0
    //   463: getfield 23	com/tencent/mobileqq/statistics/UnifiedMonitor$StackGetterJob:this$0	Lcom/tencent/mobileqq/statistics/UnifiedMonitor;
    //   466: invokestatic 68	com/tencent/mobileqq/statistics/UnifiedMonitor:a	(Lcom/tencent/mobileqq/statistics/UnifiedMonitor;)[Lawsd;
    //   469: aload_0
    //   470: getfield 63	com/tencent/mobileqq/statistics/UnifiedMonitor$StackGetterJob:jdField_a_of_type_Int	I
    //   473: aaload
    //   474: getfield 223	awsd:jdField_d_of_type_Boolean	Z
    //   477: ifeq +57 -> 534
    //   480: ldc 148
    //   482: iconst_1
    //   483: new 30	java/lang/StringBuilder
    //   486: dup
    //   487: invokespecial 224	java/lang/StringBuilder:<init>	()V
    //   490: aload_0
    //   491: getfield 84	com/tencent/mobileqq/statistics/UnifiedMonitor$StackGetterJob:jdField_a_of_type_JavaLangThread	Ljava/lang/Thread;
    //   494: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   497: ldc 229
    //   499: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   502: aload_0
    //   503: iconst_1
    //   504: invokespecial 192	com/tencent/mobileqq/statistics/UnifiedMonitor$StackGetterJob:a	(Z)Ljava/lang/String;
    //   507: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   510: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   513: invokestatic 232	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   516: aload_0
    //   517: getfield 23	com/tencent/mobileqq/statistics/UnifiedMonitor$StackGetterJob:this$0	Lcom/tencent/mobileqq/statistics/UnifiedMonitor;
    //   520: aload_0
    //   521: getfield 63	com/tencent/mobileqq/statistics/UnifiedMonitor$StackGetterJob:jdField_a_of_type_Int	I
    //   524: aload_0
    //   525: getfield 84	com/tencent/mobileqq/statistics/UnifiedMonitor$StackGetterJob:jdField_a_of_type_JavaLangThread	Ljava/lang/Thread;
    //   528: invokevirtual 235	com/tencent/mobileqq/statistics/UnifiedMonitor:a	(ILjava/lang/Thread;)V
    //   531: goto -161 -> 370
    //   534: aload_0
    //   535: getfield 23	com/tencent/mobileqq/statistics/UnifiedMonitor$StackGetterJob:this$0	Lcom/tencent/mobileqq/statistics/UnifiedMonitor;
    //   538: invokestatic 68	com/tencent/mobileqq/statistics/UnifiedMonitor:a	(Lcom/tencent/mobileqq/statistics/UnifiedMonitor;)[Lawsd;
    //   541: aload_0
    //   542: getfield 63	com/tencent/mobileqq/statistics/UnifiedMonitor$StackGetterJob:jdField_a_of_type_Int	I
    //   545: aaload
    //   546: aload_0
    //   547: iconst_1
    //   548: invokespecial 192	com/tencent/mobileqq/statistics/UnifiedMonitor$StackGetterJob:a	(Z)Ljava/lang/String;
    //   551: putfield 197	awsd:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   554: goto -184 -> 370
    //   557: astore 6
    //   559: goto -550 -> 9
    //   562: astore 6
    //   564: goto -555 -> 9
    //   567: astore 6
    //   569: goto -560 -> 9
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	572	0	this	StackGetterJob
    //   105	338	1	l1	long
    //   164	275	3	l2	long
    //   7	421	5	localRandom	java.util.Random
    //   85	1	6	localInterruptedException1	java.lang.InterruptedException
    //   123	1	6	localInterruptedException2	java.lang.InterruptedException
    //   298	57	6	localObject	Object
    //   557	1	6	localInterruptedException3	java.lang.InterruptedException
    //   562	1	6	localInterruptedException4	java.lang.InterruptedException
    //   567	1	6	localInterruptedException5	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   74	82	85	java/lang/InterruptedException
    //   112	120	123	java/lang/InterruptedException
    //   176	180	557	java/lang/InterruptedException
    //   267	273	562	java/lang/InterruptedException
    //   438	442	567	java/lang/InterruptedException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.UnifiedMonitor.StackGetterJob
 * JD-Core Version:    0.7.0.1
 */