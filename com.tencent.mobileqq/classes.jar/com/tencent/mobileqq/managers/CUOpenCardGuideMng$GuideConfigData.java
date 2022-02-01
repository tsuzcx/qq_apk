package com.tencent.mobileqq.managers;

import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class CUOpenCardGuideMng$GuideConfigData
{
  public final String a;
  public final ArrayList<Integer> b;
  public boolean c = false;
  public String d;
  public boolean e;
  public CUOpenCardGuideMng.GuideEntry[] f;
  public long g;
  
  public CUOpenCardGuideMng$GuideConfigData(String paramString)
  {
    this.a = paramString;
    this.d = "";
    this.e = false;
    this.f = new CUOpenCardGuideMng.GuideEntry[6];
    int i = 0;
    for (;;)
    {
      paramString = this.f;
      if (i >= paramString.length) {
        break;
      }
      paramString[i] = null;
      i += 1;
    }
    this.g = 0L;
    this.b = DeviceInfoUtil.R();
    ThreadManager.post(new CUOpenCardGuideMng.GuideConfigData.1(this), 5, null, false);
  }
  
  public void a()
  {
    if (this.c) {
      return;
    }
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ChinaUnicomPhoneCard");
    localStringBuilder.append(this.a);
    a(localBaseApplicationImpl.getSharedPreferences(localStringBuilder.toString(), 4).getString("config_content", ""));
    if (QLog.isColorLevel()) {
      QLog.i("CUOpenCardGuideMng", 2, "init");
    }
  }
  
  /* Error */
  public void a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: iconst_1
    //   2: putfield 24	com/tencent/mobileqq/managers/CUOpenCardGuideMng$GuideConfigData:c	Z
    //   5: aload_0
    //   6: invokestatic 113	android/os/SystemClock:elapsedRealtime	()J
    //   9: putfield 38	com/tencent/mobileqq/managers/CUOpenCardGuideMng$GuideConfigData:g	J
    //   12: aload_0
    //   13: getfield 30	com/tencent/mobileqq/managers/CUOpenCardGuideMng$GuideConfigData:d	Ljava/lang/String;
    //   16: astore 5
    //   18: aload 5
    //   20: ifnull +27 -> 47
    //   23: aload 5
    //   25: aload_1
    //   26: invokevirtual 119	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   29: ifeq +18 -> 47
    //   32: invokestatic 97	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   35: ifeq +11 -> 46
    //   38: ldc 99
    //   40: iconst_2
    //   41: ldc 121
    //   43: invokestatic 105	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   46: return
    //   47: aload_1
    //   48: invokestatic 127	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   51: istore 4
    //   53: iconst_0
    //   54: istore_3
    //   55: iconst_0
    //   56: istore_2
    //   57: iload 4
    //   59: ifeq +51 -> 110
    //   62: aload_0
    //   63: iconst_0
    //   64: putfield 32	com/tencent/mobileqq/managers/CUOpenCardGuideMng$GuideConfigData:e	Z
    //   67: aload_0
    //   68: getfield 36	com/tencent/mobileqq/managers/CUOpenCardGuideMng$GuideConfigData:f	[Lcom/tencent/mobileqq/managers/CUOpenCardGuideMng$GuideEntry;
    //   71: astore_1
    //   72: iload_2
    //   73: aload_1
    //   74: arraylength
    //   75: if_icmpge +14 -> 89
    //   78: aload_1
    //   79: iload_2
    //   80: aconst_null
    //   81: aastore
    //   82: iload_2
    //   83: iconst_1
    //   84: iadd
    //   85: istore_2
    //   86: goto -19 -> 67
    //   89: aload_0
    //   90: ldc 28
    //   92: putfield 30	com/tencent/mobileqq/managers/CUOpenCardGuideMng$GuideConfigData:d	Ljava/lang/String;
    //   95: invokestatic 97	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   98: ifeq +11 -> 109
    //   101: ldc 99
    //   103: iconst_2
    //   104: ldc 129
    //   106: invokestatic 105	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   109: return
    //   110: aload_0
    //   111: monitorenter
    //   112: new 131	org/json/JSONObject
    //   115: dup
    //   116: aload_1
    //   117: invokespecial 133	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   120: astore 5
    //   122: aload 5
    //   124: ldc 135
    //   126: invokevirtual 139	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   129: ifeq +268 -> 397
    //   132: aload_0
    //   133: aload 5
    //   135: ldc 135
    //   137: invokevirtual 142	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   140: putfield 32	com/tencent/mobileqq/managers/CUOpenCardGuideMng$GuideConfigData:e	Z
    //   143: goto +254 -> 397
    //   146: iload_2
    //   147: aload_0
    //   148: getfield 36	com/tencent/mobileqq/managers/CUOpenCardGuideMng$GuideConfigData:f	[Lcom/tencent/mobileqq/managers/CUOpenCardGuideMng$GuideEntry;
    //   151: arraylength
    //   152: if_icmpge +56 -> 208
    //   155: iload_2
    //   156: getstatic 147	com/tencent/mobileqq/managers/CUOpenCardGuideMng:a	[Ljava/lang/String;
    //   159: arraylength
    //   160: if_icmpge +48 -> 208
    //   163: aload 5
    //   165: getstatic 147	com/tencent/mobileqq/managers/CUOpenCardGuideMng:a	[Ljava/lang/String;
    //   168: iload_2
    //   169: aaload
    //   170: invokevirtual 139	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   173: ifeq +25 -> 198
    //   176: aload_0
    //   177: getfield 36	com/tencent/mobileqq/managers/CUOpenCardGuideMng$GuideConfigData:f	[Lcom/tencent/mobileqq/managers/CUOpenCardGuideMng$GuideEntry;
    //   180: iload_2
    //   181: aload 5
    //   183: getstatic 147	com/tencent/mobileqq/managers/CUOpenCardGuideMng:a	[Ljava/lang/String;
    //   186: iload_2
    //   187: aaload
    //   188: invokevirtual 151	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   191: invokestatic 154	com/tencent/mobileqq/managers/CUOpenCardGuideMng$GuideEntry:a	(Lorg/json/JSONObject;)Lcom/tencent/mobileqq/managers/CUOpenCardGuideMng$GuideEntry;
    //   194: aastore
    //   195: goto +207 -> 402
    //   198: aload_0
    //   199: getfield 36	com/tencent/mobileqq/managers/CUOpenCardGuideMng$GuideConfigData:f	[Lcom/tencent/mobileqq/managers/CUOpenCardGuideMng$GuideEntry;
    //   202: iload_2
    //   203: aconst_null
    //   204: aastore
    //   205: goto +197 -> 402
    //   208: aload_0
    //   209: aload_1
    //   210: putfield 30	com/tencent/mobileqq/managers/CUOpenCardGuideMng$GuideConfigData:d	Ljava/lang/String;
    //   213: invokestatic 97	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   216: ifeq +168 -> 384
    //   219: new 66	java/lang/StringBuilder
    //   222: dup
    //   223: sipush 300
    //   226: invokespecial 157	java/lang/StringBuilder:<init>	(I)V
    //   229: astore 5
    //   231: aload 5
    //   233: ldc 159
    //   235: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: pop
    //   239: aload 5
    //   241: ldc 161
    //   243: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: pop
    //   247: aload 5
    //   249: ldc 163
    //   251: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: pop
    //   255: aload 5
    //   257: aload_1
    //   258: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: pop
    //   262: aload 5
    //   264: ldc 161
    //   266: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: pop
    //   270: aload 5
    //   272: ldc 165
    //   274: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: pop
    //   278: aload 5
    //   280: aload_0
    //   281: getfield 32	com/tencent/mobileqq/managers/CUOpenCardGuideMng$GuideConfigData:e	Z
    //   284: invokevirtual 168	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   287: pop
    //   288: aload 5
    //   290: ldc 161
    //   292: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: pop
    //   296: iload_3
    //   297: istore_2
    //   298: iload_2
    //   299: aload_0
    //   300: getfield 36	com/tencent/mobileqq/managers/CUOpenCardGuideMng$GuideConfigData:f	[Lcom/tencent/mobileqq/managers/CUOpenCardGuideMng$GuideEntry;
    //   303: arraylength
    //   304: if_icmpge +57 -> 361
    //   307: iload_2
    //   308: getstatic 147	com/tencent/mobileqq/managers/CUOpenCardGuideMng:a	[Ljava/lang/String;
    //   311: arraylength
    //   312: if_icmpge +49 -> 361
    //   315: aload 5
    //   317: getstatic 147	com/tencent/mobileqq/managers/CUOpenCardGuideMng:a	[Ljava/lang/String;
    //   320: iload_2
    //   321: aaload
    //   322: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: pop
    //   326: aload 5
    //   328: ldc 170
    //   330: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: pop
    //   334: aload 5
    //   336: aload_0
    //   337: getfield 36	com/tencent/mobileqq/managers/CUOpenCardGuideMng$GuideConfigData:f	[Lcom/tencent/mobileqq/managers/CUOpenCardGuideMng$GuideEntry;
    //   340: iload_2
    //   341: aaload
    //   342: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   345: pop
    //   346: aload 5
    //   348: ldc 161
    //   350: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   353: pop
    //   354: iload_2
    //   355: iconst_1
    //   356: iadd
    //   357: istore_2
    //   358: goto -60 -> 298
    //   361: ldc 99
    //   363: iconst_2
    //   364: aload 5
    //   366: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   369: invokestatic 105	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   372: goto +12 -> 384
    //   375: astore_1
    //   376: goto +11 -> 387
    //   379: astore_1
    //   380: aload_1
    //   381: invokevirtual 176	java/lang/Exception:printStackTrace	()V
    //   384: aload_0
    //   385: monitorexit
    //   386: return
    //   387: aload_0
    //   388: monitorexit
    //   389: goto +5 -> 394
    //   392: aload_1
    //   393: athrow
    //   394: goto -2 -> 392
    //   397: iconst_0
    //   398: istore_2
    //   399: goto -253 -> 146
    //   402: iload_2
    //   403: iconst_1
    //   404: iadd
    //   405: istore_2
    //   406: goto -260 -> 146
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	409	0	this	GuideConfigData
    //   0	409	1	paramString	String
    //   56	350	2	i	int
    //   54	243	3	j	int
    //   51	7	4	bool	boolean
    //   16	349	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   112	143	375	finally
    //   146	195	375	finally
    //   198	205	375	finally
    //   208	296	375	finally
    //   298	354	375	finally
    //   361	372	375	finally
    //   380	384	375	finally
    //   384	386	375	finally
    //   387	389	375	finally
    //   112	143	379	java/lang/Exception
    //   146	195	379	java/lang/Exception
    //   198	205	379	java/lang/Exception
    //   208	296	379	java/lang/Exception
    //   298	354	379	java/lang/Exception
    //   361	372	379	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.managers.CUOpenCardGuideMng.GuideConfigData
 * JD-Core Version:    0.7.0.1
 */