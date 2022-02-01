package com.tencent.mobileqq.msf.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.DeadObjectException;
import android.os.RemoteException;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.i;
import com.tencent.mobileqq.msf.sdk.MsfMessagePair;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.IMsfServiceCallbacker;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

class b
  extends Thread
{
  private static final String e = "MSF.S.AppProcessManager";
  private static final int f = 4;
  private static final int g = 4;
  private static final long h = 0L;
  private static final long[] i = { 20L, 60L, 100L };
  private static final String j = "sleep_by_ipc_block_time";
  private static final int l = 10;
  volatile Object a = new Object();
  volatile boolean b = false;
  volatile boolean c = true;
  int d = 0;
  private long k;
  
  b()
  {
    b();
  }
  
  private void a(MsfMessagePair paramMsfMessagePair, int paramInt1, int paramInt2, int paramInt3, IMsfServiceCallbacker paramIMsfServiceCallbacker)
  {
    if (paramMsfMessagePair.toServiceMsg == null)
    {
      if (paramInt1 == 0)
      {
        paramIMsfServiceCallbacker.onReceiveFirstPkgPushResp(paramMsfMessagePair.fromServiceMsg, paramInt1, paramInt2, paramInt3);
        return;
      }
      paramIMsfServiceCallbacker.onReceiveNextPkgPushResp(paramMsfMessagePair.fromServiceMsg.getRequestSsoSeq(), paramInt1, paramMsfMessagePair.fromServiceMsg.getWupBuffer());
      return;
    }
    if (paramInt1 == 0)
    {
      paramIMsfServiceCallbacker.onFirstPkgResp(paramMsfMessagePair.toServiceMsg, paramMsfMessagePair.fromServiceMsg, paramInt1, paramInt2, paramInt3);
      return;
    }
    paramIMsfServiceCallbacker.onNextPkgResp(paramMsfMessagePair.fromServiceMsg.getRequestSsoSeq(), paramInt1, paramMsfMessagePair.fromServiceMsg.getWupBuffer());
  }
  
  private void a(MsfMessagePair paramMsfMessagePair, int paramInt1, int paramInt2, IMsfServiceCallbacker paramIMsfServiceCallbacker)
  {
    int m = 0;
    while (m < 4) {
      try
      {
        a(paramMsfMessagePair, paramIMsfServiceCallbacker);
        if (m > 0) {
          h.a().a(true, "", c(paramMsfMessagePair), paramInt2, paramMsfMessagePair.fromServiceMsg.getServiceCmd(), this.k);
        }
        return;
      }
      catch (RemoteException localRemoteException)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("try asyncTransport fail with e = ");
          localStringBuilder.append(localRemoteException.getClass().getSimpleName());
          localStringBuilder.append(", msg = ");
          localStringBuilder.append(localRemoteException.getMessage());
          localStringBuilder.append(", ssoSeq = ");
          localStringBuilder.append(paramMsfMessagePair.fromServiceMsg.getRequestSsoSeq());
          localStringBuilder.append(", cmd = ");
          localStringBuilder.append(paramMsfMessagePair.fromServiceMsg.getServiceCmd());
          localStringBuilder.append(", time = ");
          localStringBuilder.append(m);
          localStringBuilder.append(", packageLength = ");
          localStringBuilder.append(paramInt1);
          QLog.d("MSF.S.AppProcessManager", 2, localStringBuilder.toString());
        }
        int n = m + 1;
        if (n == 4)
        {
          if (a(paramMsfMessagePair))
          {
            b(paramMsfMessagePair, paramInt1 / 2, paramInt2, paramIMsfServiceCallbacker);
            return;
          }
          throw localRemoteException;
        }
        m = n;
        if (n >= 2)
        {
          b(paramMsfMessagePair);
          m = n;
        }
      }
      catch (DeadObjectException paramMsfMessagePair)
      {
        throw paramMsfMessagePair;
      }
    }
  }
  
  private void a(MsfMessagePair paramMsfMessagePair, IMsfServiceCallbacker paramIMsfServiceCallbacker, String paramString)
  {
    if (paramIMsfServiceCallbacker == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("MSF.S.AppProcessManager", 2, "IMsfServiceCallback is null");
      }
    }
    else
    {
      if (!i.a().b())
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.S.AppProcessManager", 2, "transportToAppProcess, enableIPCDivideToTransport is false, so trans directly");
        }
        a(paramMsfMessagePair, paramIMsfServiceCallbacker);
        return;
      }
      int m = paramMsfMessagePair.fromServiceMsg.getWupBuffer().length;
      int n = f.a().b();
      if ((a(paramMsfMessagePair)) && (m > n)) {
        b(paramMsfMessagePair, n, m, paramIMsfServiceCallbacker);
      } else {
        a(paramMsfMessagePair, n, m, paramIMsfServiceCallbacker);
      }
      h.a().b();
    }
  }
  
  private boolean a(MsfMessagePair paramMsfMessagePair)
  {
    return (paramMsfMessagePair.fromServiceMsg.getRequestSsoSeq() != -1) && (!a(paramMsfMessagePair.fromServiceMsg.getServiceCmd()));
  }
  
  private boolean a(MsfMessagePair paramMsfMessagePair, int paramInt1, int paramInt2, int paramInt3, int paramInt4, IMsfServiceCallbacker paramIMsfServiceCallbacker)
  {
    int m = 0;
    for (;;)
    {
      if (m >= 4) {
        break label434;
      }
      try
      {
        boolean bool = QLog.isColorLevel();
        if (bool) {
          try
          {
            StringBuilder localStringBuilder1 = new StringBuilder();
            localStringBuilder1.append("send package, index = ");
            localStringBuilder1.append(paramInt1);
            localStringBuilder1.append(", ssoSeq = ");
            localStringBuilder1.append(paramMsfMessagePair.fromServiceMsg.getRequestSsoSeq());
            localStringBuilder1.append(", cmd = ");
            localStringBuilder1.append(paramMsfMessagePair.fromServiceMsg.getServiceCmd());
            localStringBuilder1.append(", divideTryTime = ");
            localStringBuilder1.append(paramInt4);
            localStringBuilder1.append(", packageLength = ");
            localStringBuilder1.append(paramInt2);
            QLog.d("MSF.S.AppProcessManager", 2, localStringBuilder1.toString());
          }
          catch (RemoteException localRemoteException1)
          {
            break label163;
          }
        }
        try
        {
          a(paramMsfMessagePair, paramInt1, paramInt2, paramInt3, paramIMsfServiceCallbacker);
          return true;
        }
        catch (RemoteException localRemoteException2) {}catch (DeadObjectException localDeadObjectException1)
        {
          paramIMsfServiceCallbacker = this;
        }
      }
      catch (RemoteException localRemoteException3)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("try syncTransport fail with e = ");
          localStringBuilder2.append(localRemoteException3.getClass().getSimpleName());
          localStringBuilder2.append(", msg");
          localStringBuilder2.append(localRemoteException3.getMessage());
          localStringBuilder2.append(", ssoSeq = ");
          localStringBuilder2.append(paramMsfMessagePair.fromServiceMsg.getRequestSsoSeq());
          localStringBuilder2.append(", cmd = ");
          localStringBuilder2.append(paramMsfMessagePair.fromServiceMsg.getServiceCmd());
          localStringBuilder2.append(", time = ");
          localStringBuilder2.append(m);
          localStringBuilder2.append(", divideTryTime = ");
          localStringBuilder2.append(paramInt4);
          localStringBuilder2.append(", packageLength = ");
          localStringBuilder2.append(paramInt2);
          QLog.d("MSF.S.AppProcessManager", 2, localStringBuilder2.toString());
        }
        m += 1;
        if (m == 4)
        {
          if (paramInt4 < 4) {
            return false;
          }
          h.a().a(false, localRemoteException3.getClass().getSimpleName(), c(paramMsfMessagePair), paramInt3, paramMsfMessagePair.fromServiceMsg.getServiceCmd(), this.k);
          throw localRemoteException3;
        }
        if (m >= 2) {
          b(paramMsfMessagePair);
        }
      }
      catch (DeadObjectException localDeadObjectException2)
      {
        label163:
        paramIMsfServiceCallbacker = this;
      }
    }
    h.a().a(false, localDeadObjectException2.getClass().getSimpleName(), c(paramMsfMessagePair), paramInt3, paramMsfMessagePair.fromServiceMsg.getServiceCmd(), paramIMsfServiceCallbacker.k);
    throw localDeadObjectException2;
    label434:
    return false;
  }
  
  private boolean a(String paramString)
  {
    return TextUtils.equals("cmd_pushSetConfig", paramString);
  }
  
  /* Error */
  private boolean a(String paramString, c paramc)
  {
    // Byte code:
    //   0: aload_2
    //   1: astore 13
    //   3: ldc 229
    //   5: astore 15
    //   7: iconst_0
    //   8: istore_3
    //   9: aload 13
    //   11: getfield 234	com/tencent/mobileqq/msf/service/c:i	Ljava/util/concurrent/ConcurrentLinkedQueue;
    //   14: invokevirtual 239	java/util/concurrent/ConcurrentLinkedQueue:isEmpty	()Z
    //   17: ifne +1817 -> 1834
    //   20: iload_3
    //   21: iconst_1
    //   22: iadd
    //   23: istore_3
    //   24: iload_3
    //   25: bipush 10
    //   27: if_icmpgt +1804 -> 1831
    //   30: aload 13
    //   32: getfield 234	com/tencent/mobileqq/msf/service/c:i	Ljava/util/concurrent/ConcurrentLinkedQueue;
    //   35: invokevirtual 243	java/util/concurrent/ConcurrentLinkedQueue:peek	()Ljava/lang/Object;
    //   38: checkcast 60	com/tencent/mobileqq/msf/sdk/MsfMessagePair
    //   41: astore 16
    //   43: aload 16
    //   45: ifnonnull +6 -> 51
    //   48: goto +1783 -> 1831
    //   51: aload_2
    //   52: invokevirtual 246	com/tencent/mobileqq/msf/service/c:c	()Lcom/tencent/qphone/base/remote/IMsfServiceCallbacker;
    //   55: astore 17
    //   57: aload 17
    //   59: ifnonnull +9 -> 68
    //   62: iconst_1
    //   63: istore 7
    //   65: goto +6 -> 71
    //   68: iconst_0
    //   69: istore 7
    //   71: aload_2
    //   72: invokevirtual 248	com/tencent/mobileqq/msf/service/c:b	()Ljava/lang/String;
    //   75: invokestatic 251	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   78: ifne +22 -> 100
    //   81: aload 16
    //   83: getfield 68	com/tencent/mobileqq/msf/sdk/MsfMessagePair:fromServiceMsg	Lcom/tencent/qphone/base/remote/FromServiceMsg;
    //   86: ldc 253
    //   88: invokevirtual 257	com/tencent/qphone/base/remote/FromServiceMsg:getAttribute	(Ljava/lang/String;)Ljava/lang/Object;
    //   91: ifnull +9 -> 100
    //   94: iconst_1
    //   95: istore 8
    //   97: goto +6 -> 103
    //   100: iconst_0
    //   101: istore 8
    //   103: iload 7
    //   105: ifeq +304 -> 409
    //   108: aload 16
    //   110: getfield 68	com/tencent/mobileqq/msf/sdk/MsfMessagePair:fromServiceMsg	Lcom/tencent/qphone/base/remote/FromServiceMsg;
    //   113: invokevirtual 117	com/tencent/qphone/base/remote/FromServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   116: astore 17
    //   118: getstatic 263	com/tencent/qphone/base/BaseConstants:CMD_NeedBootPushCmdHeads	[Ljava/lang/String;
    //   121: astore 14
    //   123: aload 14
    //   125: arraylength
    //   126: istore 5
    //   128: iconst_0
    //   129: istore 4
    //   131: iload 4
    //   133: iload 5
    //   135: if_icmpge +177 -> 312
    //   138: aload 14
    //   140: iload 4
    //   142: aaload
    //   143: astore 18
    //   145: aload 17
    //   147: ifnull +156 -> 303
    //   150: aload 17
    //   152: aload 18
    //   154: invokevirtual 268	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   157: ifeq +146 -> 303
    //   160: aload 13
    //   162: iconst_0
    //   163: putfield 270	com/tencent/mobileqq/msf/service/c:a	Z
    //   166: aload 13
    //   168: iconst_0
    //   169: putfield 271	com/tencent/mobileqq/msf/service/c:c	Z
    //   172: ldc_w 273
    //   175: aload 17
    //   177: invokevirtual 276	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   180: ifne +14 -> 194
    //   183: ldc_w 278
    //   186: aload 17
    //   188: invokevirtual 276	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   191: ifeq +106 -> 297
    //   194: new 130	java/lang/StringBuilder
    //   197: dup
    //   198: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   201: astore 18
    //   203: aload 18
    //   205: ldc_w 280
    //   208: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: pop
    //   212: aload 18
    //   214: aload 17
    //   216: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: pop
    //   220: aload 18
    //   222: ldc_w 282
    //   225: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: pop
    //   229: aload 18
    //   231: aload 16
    //   233: getfield 68	com/tencent/mobileqq/msf/sdk/MsfMessagePair:fromServiceMsg	Lcom/tencent/qphone/base/remote/FromServiceMsg;
    //   236: invokevirtual 285	com/tencent/qphone/base/remote/FromServiceMsg:getStringForLog	()Ljava/lang/String;
    //   239: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: pop
    //   243: aload 18
    //   245: ldc_w 287
    //   248: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: pop
    //   252: aload 16
    //   254: getfield 64	com/tencent/mobileqq/msf/sdk/MsfMessagePair:toServiceMsg	Lcom/tencent/qphone/base/remote/ToServiceMsg;
    //   257: ifnull +16 -> 273
    //   260: aload 16
    //   262: getfield 64	com/tencent/mobileqq/msf/sdk/MsfMessagePair:toServiceMsg	Lcom/tencent/qphone/base/remote/ToServiceMsg;
    //   265: invokevirtual 290	com/tencent/qphone/base/remote/ToServiceMsg:getStringForLog	()Ljava/lang/String;
    //   268: astore 14
    //   270: goto +8 -> 278
    //   273: ldc_w 292
    //   276: astore 14
    //   278: aload 18
    //   280: aload 14
    //   282: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: pop
    //   286: ldc 8
    //   288: iconst_1
    //   289: aload 18
    //   291: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   294: invokestatic 168	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   297: iconst_1
    //   298: istore 6
    //   300: goto +15 -> 315
    //   303: iload 4
    //   305: iconst_1
    //   306: iadd
    //   307: istore 4
    //   309: goto -178 -> 131
    //   312: iconst_0
    //   313: istore 6
    //   315: invokestatic 128	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   318: ifeq +81 -> 399
    //   321: new 130	java/lang/StringBuilder
    //   324: dup
    //   325: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   328: astore 14
    //   330: aload 14
    //   332: aload_1
    //   333: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   336: pop
    //   337: aload 14
    //   339: ldc_w 294
    //   342: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   345: pop
    //   346: aload 14
    //   348: aload 17
    //   350: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   353: pop
    //   354: aload 14
    //   356: ldc_w 296
    //   359: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   362: pop
    //   363: aload 14
    //   365: iload 6
    //   367: invokevirtual 299	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   370: pop
    //   371: aload 14
    //   373: ldc_w 301
    //   376: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   379: pop
    //   380: aload 14
    //   382: iload 8
    //   384: invokevirtual 299	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   387: pop
    //   388: ldc 8
    //   390: iconst_2
    //   391: aload 14
    //   393: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   396: invokestatic 168	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   399: iload 6
    //   401: istore 7
    //   403: iconst_1
    //   404: istore 6
    //   406: goto +681 -> 1087
    //   409: iload_3
    //   410: istore 4
    //   412: aload 13
    //   414: getfield 271	com/tencent/mobileqq/msf/service/c:c	Z
    //   417: iconst_1
    //   418: if_icmpne +107 -> 525
    //   421: aload 16
    //   423: getfield 68	com/tencent/mobileqq/msf/sdk/MsfMessagePair:fromServiceMsg	Lcom/tencent/qphone/base/remote/FromServiceMsg;
    //   426: invokevirtual 305	com/tencent/qphone/base/remote/FromServiceMsg:getMsfCommand	()Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   429: getstatic 311	com/tencent/mobileqq/msf/sdk/MsfCommand:setMsfConnStatus	Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   432: if_acmpeq +93 -> 525
    //   435: invokestatic 317	android/os/SystemClock:elapsedRealtime	()J
    //   438: aload 13
    //   440: getfield 319	com/tencent/mobileqq/msf/service/c:b	J
    //   443: lsub
    //   444: ldc2_w 320
    //   447: lcmp
    //   448: ifge +6 -> 454
    //   451: goto +1380 -> 1831
    //   454: aload 13
    //   456: iconst_0
    //   457: putfield 271	com/tencent/mobileqq/msf/service/c:c	Z
    //   460: invokestatic 128	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   463: ifeq +62 -> 525
    //   466: new 130	java/lang/StringBuilder
    //   469: dup
    //   470: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   473: astore 14
    //   475: aload 14
    //   477: ldc_w 323
    //   480: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   483: pop
    //   484: aload 14
    //   486: aload_1
    //   487: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   490: pop
    //   491: aload 14
    //   493: ldc_w 325
    //   496: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   499: pop
    //   500: aload 14
    //   502: aload 13
    //   504: getfield 270	com/tencent/mobileqq/msf/service/c:a	Z
    //   507: invokevirtual 299	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   510: pop
    //   511: ldc 8
    //   513: iconst_2
    //   514: aload 14
    //   516: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   519: invokestatic 168	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   522: goto +3 -> 525
    //   525: invokestatic 330	java/lang/System:currentTimeMillis	()J
    //   528: lstore 9
    //   530: aload 16
    //   532: getfield 64	com/tencent/mobileqq/msf/sdk/MsfMessagePair:toServiceMsg	Lcom/tencent/qphone/base/remote/ToServiceMsg;
    //   535: astore 14
    //   537: aload 14
    //   539: ifnonnull +226 -> 765
    //   542: aload_1
    //   543: ifnull +94 -> 637
    //   546: aload_1
    //   547: ldc_w 332
    //   550: invokevirtual 335	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   553: ifeq +84 -> 637
    //   556: aload 16
    //   558: getfield 68	com/tencent/mobileqq/msf/sdk/MsfMessagePair:fromServiceMsg	Lcom/tencent/qphone/base/remote/FromServiceMsg;
    //   561: ifnull +76 -> 637
    //   564: aload 16
    //   566: getfield 68	com/tencent/mobileqq/msf/sdk/MsfMessagePair:fromServiceMsg	Lcom/tencent/qphone/base/remote/FromServiceMsg;
    //   569: invokevirtual 117	com/tencent/qphone/base/remote/FromServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   572: ldc_w 337
    //   575: invokevirtual 340	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   578: ifeq +59 -> 637
    //   581: aload 16
    //   583: getfield 68	com/tencent/mobileqq/msf/sdk/MsfMessagePair:fromServiceMsg	Lcom/tencent/qphone/base/remote/FromServiceMsg;
    //   586: aload 15
    //   588: invokevirtual 257	com/tencent/qphone/base/remote/FromServiceMsg:getAttribute	(Ljava/lang/String;)Ljava/lang/Object;
    //   591: ifnonnull +46 -> 637
    //   594: aload 16
    //   596: getfield 68	com/tencent/mobileqq/msf/sdk/MsfMessagePair:fromServiceMsg	Lcom/tencent/qphone/base/remote/FromServiceMsg;
    //   599: astore 14
    //   601: invokestatic 330	java/lang/System:currentTimeMillis	()J
    //   604: lstore 11
    //   606: aload 14
    //   608: aload 15
    //   610: lload 11
    //   612: invokestatic 346	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   615: invokevirtual 350	com/tencent/qphone/base/remote/FromServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   618: pop
    //   619: goto +18 -> 637
    //   622: astore 14
    //   624: goto +10 -> 634
    //   627: astore 13
    //   629: goto +314 -> 943
    //   632: astore 14
    //   634: goto +339 -> 973
    //   637: new 130	java/lang/StringBuilder
    //   640: dup
    //   641: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   644: astore 13
    //   646: aload 13
    //   648: ldc_w 352
    //   651: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   654: pop
    //   655: aload 13
    //   657: aload_1
    //   658: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   661: pop
    //   662: aload 13
    //   664: ldc_w 354
    //   667: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   670: pop
    //   671: aload 13
    //   673: aload 16
    //   675: getfield 68	com/tencent/mobileqq/msf/sdk/MsfMessagePair:fromServiceMsg	Lcom/tencent/qphone/base/remote/FromServiceMsg;
    //   678: invokevirtual 357	com/tencent/qphone/base/remote/FromServiceMsg:getShortStringForLog	()Ljava/lang/String;
    //   681: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   684: pop
    //   685: aload 13
    //   687: ldc_w 359
    //   690: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   693: pop
    //   694: invokestatic 330	java/lang/System:currentTimeMillis	()J
    //   697: lstore 11
    //   699: aload 13
    //   701: lload 11
    //   703: lload 9
    //   705: lsub
    //   706: invokevirtual 362	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   709: pop
    //   710: aload 13
    //   712: ldc_w 364
    //   715: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   718: pop
    //   719: aload 13
    //   721: iload 8
    //   723: invokevirtual 299	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   726: pop
    //   727: aload 13
    //   729: ldc_w 366
    //   732: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   735: pop
    //   736: aload 13
    //   738: aload 16
    //   740: getfield 68	com/tencent/mobileqq/msf/sdk/MsfMessagePair:fromServiceMsg	Lcom/tencent/qphone/base/remote/FromServiceMsg;
    //   743: invokevirtual 84	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   746: arraylength
    //   747: invokevirtual 156	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   750: pop
    //   751: ldc 8
    //   753: iconst_1
    //   754: aload 13
    //   756: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   759: invokestatic 181	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   762: goto +148 -> 910
    //   765: new 130	java/lang/StringBuilder
    //   768: dup
    //   769: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   772: astore 13
    //   774: aload 13
    //   776: ldc_w 368
    //   779: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   782: pop
    //   783: aload 13
    //   785: aload_1
    //   786: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   789: pop
    //   790: aload 13
    //   792: ldc_w 354
    //   795: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   798: pop
    //   799: aload 13
    //   801: aload 16
    //   803: getfield 68	com/tencent/mobileqq/msf/sdk/MsfMessagePair:fromServiceMsg	Lcom/tencent/qphone/base/remote/FromServiceMsg;
    //   806: invokevirtual 357	com/tencent/qphone/base/remote/FromServiceMsg:getShortStringForLog	()Ljava/lang/String;
    //   809: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   812: pop
    //   813: aload 13
    //   815: ldc_w 370
    //   818: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   821: pop
    //   822: aload 13
    //   824: invokestatic 330	java/lang/System:currentTimeMillis	()J
    //   827: lload 9
    //   829: lsub
    //   830: invokevirtual 362	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   833: pop
    //   834: aload 13
    //   836: ldc_w 364
    //   839: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   842: pop
    //   843: aload 13
    //   845: iload 8
    //   847: invokevirtual 299	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   850: pop
    //   851: aload 13
    //   853: ldc_w 372
    //   856: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   859: pop
    //   860: aload 13
    //   862: aload 16
    //   864: getfield 64	com/tencent/mobileqq/msf/sdk/MsfMessagePair:toServiceMsg	Lcom/tencent/qphone/base/remote/ToServiceMsg;
    //   867: invokevirtual 373	com/tencent/qphone/base/remote/ToServiceMsg:getWupBuffer	()[B
    //   870: arraylength
    //   871: invokevirtual 156	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   874: pop
    //   875: aload 13
    //   877: ldc_w 366
    //   880: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   883: pop
    //   884: aload 13
    //   886: aload 16
    //   888: getfield 68	com/tencent/mobileqq/msf/sdk/MsfMessagePair:fromServiceMsg	Lcom/tencent/qphone/base/remote/FromServiceMsg;
    //   891: invokevirtual 84	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   894: arraylength
    //   895: invokevirtual 156	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   898: pop
    //   899: ldc 8
    //   901: iconst_1
    //   902: aload 13
    //   904: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   907: invokestatic 181	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   910: aload_0
    //   911: aload 16
    //   913: aload 17
    //   915: aload_1
    //   916: invokespecial 375	com/tencent/mobileqq/msf/service/b:a	(Lcom/tencent/mobileqq/msf/sdk/MsfMessagePair;Lcom/tencent/qphone/base/remote/IMsfServiceCallbacker;Ljava/lang/String;)V
    //   919: aload_2
    //   920: astore 13
    //   922: iconst_1
    //   923: istore 6
    //   925: iload 4
    //   927: istore_3
    //   928: goto +159 -> 1087
    //   931: astore 13
    //   933: goto +10 -> 943
    //   936: astore 14
    //   938: goto +32 -> 970
    //   941: astore 13
    //   943: ldc 8
    //   945: iconst_1
    //   946: aload 13
    //   948: invokevirtual 376	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   951: aload 13
    //   953: invokestatic 380	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   956: aload_2
    //   957: astore 13
    //   959: iconst_0
    //   960: istore 6
    //   962: iload 4
    //   964: istore_3
    //   965: goto +122 -> 1087
    //   968: astore 14
    //   970: aload_2
    //   971: astore 13
    //   973: aload 13
    //   975: aload 14
    //   977: iload 7
    //   979: invokevirtual 383	com/tencent/mobileqq/msf/service/c:a	(Ljava/lang/Exception;Z)V
    //   982: invokestatic 186	com/tencent/mobileqq/msf/core/i:a	()Lcom/tencent/mobileqq/msf/core/i;
    //   985: invokevirtual 385	com/tencent/mobileqq/msf/core/i:g	()Z
    //   988: istore 6
    //   990: iload 6
    //   992: ifne +10 -> 1002
    //   995: aload 13
    //   997: aload 17
    //   999: invokevirtual 388	com/tencent/mobileqq/msf/service/c:a	(Lcom/tencent/qphone/base/remote/IMsfServiceCallbacker;)V
    //   1002: new 130	java/lang/StringBuilder
    //   1005: dup
    //   1006: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   1009: astore 17
    //   1011: aload 17
    //   1013: ldc_w 390
    //   1016: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1019: pop
    //   1020: aload 17
    //   1022: aload_1
    //   1023: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1026: pop
    //   1027: aload 17
    //   1029: ldc_w 392
    //   1032: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1035: pop
    //   1036: aload 17
    //   1038: invokestatic 330	java/lang/System:currentTimeMillis	()J
    //   1041: lload 9
    //   1043: lsub
    //   1044: invokevirtual 362	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1047: pop
    //   1048: aload 17
    //   1050: ldc_w 394
    //   1053: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1056: pop
    //   1057: aload 17
    //   1059: iload 6
    //   1061: invokevirtual 299	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1064: pop
    //   1065: ldc 8
    //   1067: iconst_1
    //   1068: aload 17
    //   1070: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1073: aload 14
    //   1075: invokestatic 380	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1078: iconst_0
    //   1079: istore 6
    //   1081: iconst_1
    //   1082: istore 7
    //   1084: iload 4
    //   1086: istore_3
    //   1087: ldc_w 273
    //   1090: aload 16
    //   1092: getfield 68	com/tencent/mobileqq/msf/sdk/MsfMessagePair:fromServiceMsg	Lcom/tencent/qphone/base/remote/FromServiceMsg;
    //   1095: invokevirtual 117	com/tencent/qphone/base/remote/FromServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   1098: invokevirtual 276	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1101: ifne +20 -> 1121
    //   1104: ldc_w 278
    //   1107: aload 16
    //   1109: getfield 68	com/tencent/mobileqq/msf/sdk/MsfMessagePair:fromServiceMsg	Lcom/tencent/qphone/base/remote/FromServiceMsg;
    //   1112: invokevirtual 117	com/tencent/qphone/base/remote/FromServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   1115: invokevirtual 276	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1118: ifeq +80 -> 1198
    //   1121: new 130	java/lang/StringBuilder
    //   1124: dup
    //   1125: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   1128: astore 14
    //   1130: aload 14
    //   1132: ldc_w 280
    //   1135: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1138: pop
    //   1139: aload 14
    //   1141: aload 16
    //   1143: getfield 68	com/tencent/mobileqq/msf/sdk/MsfMessagePair:fromServiceMsg	Lcom/tencent/qphone/base/remote/FromServiceMsg;
    //   1146: invokevirtual 285	com/tencent/qphone/base/remote/FromServiceMsg:getStringForLog	()Ljava/lang/String;
    //   1149: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1152: pop
    //   1153: aload 14
    //   1155: ldc_w 396
    //   1158: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1161: pop
    //   1162: aload 14
    //   1164: iload 7
    //   1166: invokevirtual 299	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1169: pop
    //   1170: aload 14
    //   1172: ldc_w 398
    //   1175: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1178: pop
    //   1179: aload 14
    //   1181: iload 6
    //   1183: invokevirtual 299	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1186: pop
    //   1187: ldc 8
    //   1189: iconst_1
    //   1190: aload 14
    //   1192: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1195: invokestatic 168	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1198: iload 7
    //   1200: ifne +31 -> 1231
    //   1203: aload 13
    //   1205: getfield 234	com/tencent/mobileqq/msf/service/c:i	Ljava/util/concurrent/ConcurrentLinkedQueue;
    //   1208: invokevirtual 401	java/util/concurrent/ConcurrentLinkedQueue:poll	()Ljava/lang/Object;
    //   1211: pop
    //   1212: iload 8
    //   1214: ifeq +14 -> 1228
    //   1217: aload 13
    //   1219: iconst_3
    //   1220: aload 16
    //   1222: getfield 68	com/tencent/mobileqq/msf/sdk/MsfMessagePair:fromServiceMsg	Lcom/tencent/qphone/base/remote/FromServiceMsg;
    //   1225: invokevirtual 404	com/tencent/mobileqq/msf/service/c:a	(ILcom/tencent/qphone/base/remote/FromServiceMsg;)V
    //   1228: goto +600 -> 1828
    //   1231: invokestatic 128	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1234: ifeq +76 -> 1310
    //   1237: new 130	java/lang/StringBuilder
    //   1240: dup
    //   1241: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   1244: astore 14
    //   1246: aload 14
    //   1248: ldc_w 406
    //   1251: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1254: pop
    //   1255: aload 14
    //   1257: iload 8
    //   1259: invokevirtual 299	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1262: pop
    //   1263: aload 14
    //   1265: ldc_w 408
    //   1268: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1271: pop
    //   1272: aload 14
    //   1274: aload_1
    //   1275: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1278: pop
    //   1279: aload 14
    //   1281: ldc_w 410
    //   1284: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1287: pop
    //   1288: aload 14
    //   1290: aload 16
    //   1292: getfield 68	com/tencent/mobileqq/msf/sdk/MsfMessagePair:fromServiceMsg	Lcom/tencent/qphone/base/remote/FromServiceMsg;
    //   1295: invokevirtual 413	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1298: pop
    //   1299: ldc 8
    //   1301: iconst_2
    //   1302: aload 14
    //   1304: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1307: invokestatic 168	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1310: aload 16
    //   1312: getfield 68	com/tencent/mobileqq/msf/sdk/MsfMessagePair:fromServiceMsg	Lcom/tencent/qphone/base/remote/FromServiceMsg;
    //   1315: invokevirtual 117	com/tencent/qphone/base/remote/FromServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   1318: ldc_w 415
    //   1321: invokevirtual 340	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1324: ifeq +48 -> 1372
    //   1327: getstatic 420	com/tencent/mobileqq/msf/service/e:e	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   1330: invokevirtual 426	com/tencent/mobileqq/msf/core/MsfCore:getStatReporter	()Lcom/tencent/mobileqq/msf/core/c/j;
    //   1333: ifnull +39 -> 1372
    //   1336: getstatic 420	com/tencent/mobileqq/msf/service/e:e	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   1339: invokevirtual 426	com/tencent/mobileqq/msf/core/MsfCore:getStatReporter	()Lcom/tencent/mobileqq/msf/core/c/j;
    //   1342: ldc_w 428
    //   1345: iconst_1
    //   1346: lconst_0
    //   1347: lconst_0
    //   1348: aconst_null
    //   1349: iconst_1
    //   1350: iconst_0
    //   1351: invokevirtual 433	com/tencent/mobileqq/msf/core/c/j:a	(Ljava/lang/String;ZJJLjava/util/Map;ZZ)V
    //   1354: goto +18 -> 1372
    //   1357: invokestatic 128	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1360: ifeq +12 -> 1372
    //   1363: ldc 8
    //   1365: iconst_2
    //   1366: ldc_w 435
    //   1369: invokestatic 168	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1372: iload 8
    //   1374: ifeq +401 -> 1775
    //   1377: aload 13
    //   1379: iconst_0
    //   1380: aload 16
    //   1382: getfield 68	com/tencent/mobileqq/msf/sdk/MsfMessagePair:fromServiceMsg	Lcom/tencent/qphone/base/remote/FromServiceMsg;
    //   1385: invokevirtual 404	com/tencent/mobileqq/msf/service/c:a	(ILcom/tencent/qphone/base/remote/FromServiceMsg;)V
    //   1388: aload 13
    //   1390: aload 13
    //   1392: getfield 437	com/tencent/mobileqq/msf/service/c:d	J
    //   1395: lconst_1
    //   1396: ladd
    //   1397: putfield 437	com/tencent/mobileqq/msf/service/c:d	J
    //   1400: aload 13
    //   1402: getfield 437	com/tencent/mobileqq/msf/service/c:d	J
    //   1405: invokestatic 442	com/tencent/mobileqq/msf/core/a/a:aD	()I
    //   1408: i2l
    //   1409: lcmp
    //   1410: ifle +358 -> 1768
    //   1413: aload 13
    //   1415: getfield 234	com/tencent/mobileqq/msf/service/c:i	Ljava/util/concurrent/ConcurrentLinkedQueue;
    //   1418: invokevirtual 401	java/util/concurrent/ConcurrentLinkedQueue:poll	()Ljava/lang/Object;
    //   1421: checkcast 60	com/tencent/mobileqq/msf/sdk/MsfMessagePair
    //   1424: astore 14
    //   1426: new 444	java/util/HashMap
    //   1429: dup
    //   1430: invokespecial 445	java/util/HashMap:<init>	()V
    //   1433: astore 17
    //   1435: aload 17
    //   1437: invokestatic 448	com/tencent/mobileqq/msf/service/e:a	(Ljava/util/HashMap;)V
    //   1440: aload 17
    //   1442: ldc_w 450
    //   1445: aload 14
    //   1447: getfield 68	com/tencent/mobileqq/msf/sdk/MsfMessagePair:fromServiceMsg	Lcom/tencent/qphone/base/remote/FromServiceMsg;
    //   1450: invokevirtual 451	com/tencent/qphone/base/remote/FromServiceMsg:toString	()Ljava/lang/String;
    //   1453: invokevirtual 455	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1456: pop
    //   1457: aload 17
    //   1459: ldc_w 457
    //   1462: aload_1
    //   1463: invokevirtual 455	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1466: pop
    //   1467: aload 17
    //   1469: ldc_w 459
    //   1472: aload 14
    //   1474: getfield 68	com/tencent/mobileqq/msf/sdk/MsfMessagePair:fromServiceMsg	Lcom/tencent/qphone/base/remote/FromServiceMsg;
    //   1477: invokevirtual 462	com/tencent/qphone/base/remote/FromServiceMsg:getUin	()Ljava/lang/String;
    //   1480: invokevirtual 455	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1483: pop
    //   1484: aload 17
    //   1486: ldc_w 464
    //   1489: aload 14
    //   1491: getfield 68	com/tencent/mobileqq/msf/sdk/MsfMessagePair:fromServiceMsg	Lcom/tencent/qphone/base/remote/FromServiceMsg;
    //   1494: invokevirtual 467	com/tencent/qphone/base/remote/FromServiceMsg:getAppId	()I
    //   1497: invokestatic 470	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1500: invokevirtual 455	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1503: pop
    //   1504: aload 17
    //   1506: ldc_w 472
    //   1509: aload 13
    //   1511: getfield 234	com/tencent/mobileqq/msf/service/c:i	Ljava/util/concurrent/ConcurrentLinkedQueue;
    //   1514: invokevirtual 475	java/util/concurrent/ConcurrentLinkedQueue:size	()I
    //   1517: invokestatic 470	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1520: invokevirtual 455	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1523: pop
    //   1524: aload 17
    //   1526: ldc 21
    //   1528: aload_0
    //   1529: getfield 119	com/tencent/mobileqq/msf/service/b:k	J
    //   1532: invokestatic 478	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1535: invokevirtual 455	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1538: pop
    //   1539: aload 17
    //   1541: ldc_w 480
    //   1544: invokestatic 486	com/tencent/mobileqq/msf/service/MsfService:getCore	()Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   1547: invokevirtual 490	com/tencent/mobileqq/msf/core/MsfCore:getAccountCenter	()Lcom/tencent/mobileqq/msf/core/auth/b;
    //   1550: invokevirtual 494	com/tencent/mobileqq/msf/core/auth/b:i	()Ljava/lang/String;
    //   1553: invokevirtual 455	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1556: pop
    //   1557: new 130	java/lang/StringBuilder
    //   1560: dup
    //   1561: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   1564: astore 18
    //   1566: aload 18
    //   1568: ldc_w 496
    //   1571: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1574: pop
    //   1575: aload 18
    //   1577: invokestatic 442	com/tencent/mobileqq/msf/core/a/a:aD	()I
    //   1580: invokevirtual 156	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1583: pop
    //   1584: aload 18
    //   1586: ldc_w 498
    //   1589: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1592: pop
    //   1593: aload 18
    //   1595: aload 14
    //   1597: getfield 68	com/tencent/mobileqq/msf/sdk/MsfMessagePair:fromServiceMsg	Lcom/tencent/qphone/base/remote/FromServiceMsg;
    //   1600: invokevirtual 451	com/tencent/qphone/base/remote/FromServiceMsg:toString	()Ljava/lang/String;
    //   1603: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1606: pop
    //   1607: aload 18
    //   1609: ldc_w 500
    //   1612: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1615: pop
    //   1616: aload 18
    //   1618: aload_1
    //   1619: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1622: pop
    //   1623: aload 18
    //   1625: ldc_w 502
    //   1628: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1631: pop
    //   1632: aload 18
    //   1634: aload 13
    //   1636: getfield 234	com/tencent/mobileqq/msf/service/c:i	Ljava/util/concurrent/ConcurrentLinkedQueue;
    //   1639: invokevirtual 475	java/util/concurrent/ConcurrentLinkedQueue:size	()I
    //   1642: invokestatic 470	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1645: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1648: pop
    //   1649: ldc 8
    //   1651: iconst_1
    //   1652: aload 18
    //   1654: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1657: invokestatic 168	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1660: getstatic 420	com/tencent/mobileqq/msf/service/e:e	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   1663: invokevirtual 426	com/tencent/mobileqq/msf/core/MsfCore:getStatReporter	()Lcom/tencent/mobileqq/msf/core/c/j;
    //   1666: ifnull +41 -> 1707
    //   1669: getstatic 420	com/tencent/mobileqq/msf/service/e:e	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   1672: invokevirtual 426	com/tencent/mobileqq/msf/core/MsfCore:getStatReporter	()Lcom/tencent/mobileqq/msf/core/c/j;
    //   1675: ldc_w 504
    //   1678: iconst_0
    //   1679: lconst_0
    //   1680: lconst_0
    //   1681: aload 17
    //   1683: iconst_1
    //   1684: iconst_0
    //   1685: invokevirtual 433	com/tencent/mobileqq/msf/core/c/j:a	(Ljava/lang/String;ZJJLjava/util/Map;ZZ)V
    //   1688: getstatic 420	com/tencent/mobileqq/msf/service/e:e	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   1691: invokevirtual 426	com/tencent/mobileqq/msf/core/MsfCore:getStatReporter	()Lcom/tencent/mobileqq/msf/core/c/j;
    //   1694: ldc_w 506
    //   1697: iconst_0
    //   1698: lconst_0
    //   1699: lconst_0
    //   1700: aload 17
    //   1702: iconst_1
    //   1703: iconst_0
    //   1704: invokevirtual 433	com/tencent/mobileqq/msf/core/c/j:a	(Ljava/lang/String;ZJJLjava/util/Map;ZZ)V
    //   1707: aload 13
    //   1709: lconst_0
    //   1710: putfield 437	com/tencent/mobileqq/msf/service/c:d	J
    //   1713: aload 16
    //   1715: getfield 68	com/tencent/mobileqq/msf/sdk/MsfMessagePair:fromServiceMsg	Lcom/tencent/qphone/base/remote/FromServiceMsg;
    //   1718: ifnull +50 -> 1768
    //   1721: aload 16
    //   1723: getfield 68	com/tencent/mobileqq/msf/sdk/MsfMessagePair:fromServiceMsg	Lcom/tencent/qphone/base/remote/FromServiceMsg;
    //   1726: invokevirtual 117	com/tencent/qphone/base/remote/FromServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   1729: ifnull +39 -> 1768
    //   1732: aload 16
    //   1734: getfield 68	com/tencent/mobileqq/msf/sdk/MsfMessagePair:fromServiceMsg	Lcom/tencent/qphone/base/remote/FromServiceMsg;
    //   1737: invokevirtual 117	com/tencent/qphone/base/remote/FromServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   1740: ldc_w 337
    //   1743: invokevirtual 340	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1746: ifeq +22 -> 1768
    //   1749: invokestatic 511	com/tencent/mobileqq/msf/core/c/e:a	()Lcom/tencent/mobileqq/msf/core/c/e;
    //   1752: getstatic 516	com/tencent/mobileqq/msf/core/c/e$a:c	Lcom/tencent/mobileqq/msf/core/c/e$a;
    //   1755: aload 16
    //   1757: getfield 68	com/tencent/mobileqq/msf/sdk/MsfMessagePair:fromServiceMsg	Lcom/tencent/qphone/base/remote/FromServiceMsg;
    //   1760: invokevirtual 84	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   1763: bipush 14
    //   1765: invokevirtual 519	com/tencent/mobileqq/msf/core/c/e:a	(Lcom/tencent/mobileqq/msf/core/c/e$a;[BI)V
    //   1768: iconst_0
    //   1769: ireturn
    //   1770: astore 14
    //   1772: goto +17 -> 1789
    //   1775: aload 13
    //   1777: getfield 234	com/tencent/mobileqq/msf/service/c:i	Ljava/util/concurrent/ConcurrentLinkedQueue;
    //   1780: invokevirtual 401	java/util/concurrent/ConcurrentLinkedQueue:poll	()Ljava/lang/Object;
    //   1783: pop
    //   1784: goto +44 -> 1828
    //   1787: astore 14
    //   1789: new 130	java/lang/StringBuilder
    //   1792: dup
    //   1793: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   1796: astore 16
    //   1798: aload 16
    //   1800: ldc_w 521
    //   1803: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1806: pop
    //   1807: aload 16
    //   1809: iload 8
    //   1811: invokevirtual 299	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1814: pop
    //   1815: ldc 8
    //   1817: iconst_1
    //   1818: aload 16
    //   1820: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1823: aload 14
    //   1825: invokestatic 523	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1828: goto -1819 -> 9
    //   1831: goto +3 -> 1834
    //   1834: iload_3
    //   1835: bipush 10
    //   1837: if_icmple +5 -> 1842
    //   1840: iconst_1
    //   1841: ireturn
    //   1842: iconst_0
    //   1843: ireturn
    //   1844: astore 14
    //   1846: goto -489 -> 1357
    //   1849: astore 13
    //   1851: goto -908 -> 943
    //   1854: astore 14
    //   1856: goto -886 -> 970
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1859	0	this	b
    //   0	1859	1	paramString	String
    //   0	1859	2	paramc	c
    //   8	1830	3	m	int
    //   129	956	4	n	int
    //   126	10	5	i1	int
    //   298	884	6	bool1	boolean
    //   63	1136	7	bool2	boolean
    //   95	1715	8	bool3	boolean
    //   528	514	9	l1	long
    //   604	98	11	l2	long
    //   1	502	13	localc1	c
    //   627	1	13	localThrowable1	java.lang.Throwable
    //   644	277	13	localObject1	Object
    //   931	1	13	localThrowable2	java.lang.Throwable
    //   941	11	13	localThrowable3	java.lang.Throwable
    //   957	819	13	localc2	c
    //   1849	1	13	localThrowable4	java.lang.Throwable
    //   121	486	14	localObject2	Object
    //   622	1	14	localDeadObjectException1	DeadObjectException
    //   632	1	14	localDeadObjectException2	DeadObjectException
    //   936	1	14	localDeadObjectException3	DeadObjectException
    //   968	106	14	localDeadObjectException4	DeadObjectException
    //   1128	468	14	localObject3	Object
    //   1770	1	14	localException1	Exception
    //   1787	37	14	localException2	Exception
    //   1844	1	14	localException3	Exception
    //   1854	1	14	localDeadObjectException5	DeadObjectException
    //   5	604	15	str	String
    //   41	1778	16	localObject4	Object
    //   55	1646	17	localObject5	Object
    //   143	1510	18	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   606	619	622	android/os/DeadObjectException
    //   546	606	627	java/lang/Throwable
    //   546	606	632	android/os/DeadObjectException
    //   699	762	931	java/lang/Throwable
    //   765	910	931	java/lang/Throwable
    //   910	919	931	java/lang/Throwable
    //   699	762	936	android/os/DeadObjectException
    //   765	910	936	android/os/DeadObjectException
    //   910	919	936	android/os/DeadObjectException
    //   530	537	941	java/lang/Throwable
    //   530	537	968	android/os/DeadObjectException
    //   1377	1707	1770	java/lang/Exception
    //   1707	1768	1770	java/lang/Exception
    //   1775	1784	1787	java/lang/Exception
    //   1310	1354	1844	java/lang/Exception
    //   606	619	1849	java/lang/Throwable
    //   637	699	1849	java/lang/Throwable
    //   637	699	1854	android/os/DeadObjectException
  }
  
  private void b()
  {
    Object localObject = BaseApplication.getContext().getSharedPreferences("common_sp_for_msf", 0);
    this.k = ((SharedPreferences)localObject).getLong("sleep_by_ipc_block_time", 0L);
    if (this.k == 0L)
    {
      int i1 = i.length;
      int n = new Random().nextInt(i1);
      int m;
      if (n >= 0)
      {
        m = n;
        if (n < i1) {}
      }
      else
      {
        m = i1 - 1;
      }
      this.k = i[m];
      ((SharedPreferences)localObject).edit().putLong("sleep_by_ipc_block_time", this.k).apply();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("init, mSleepByIPCBlockTime = ");
        ((StringBuilder)localObject).append(this.k);
        QLog.d("MSF.S.AppProcessManager", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  private void b(MsfMessagePair paramMsfMessagePair)
  {
    if (i.a().c())
    {
      if (a(paramMsfMessagePair.fromServiceMsg.getServiceCmd())) {
        return;
      }
      paramMsfMessagePair = new StringBuilder();
      paramMsfMessagePair.append("sleep ");
      paramMsfMessagePair.append(this.k);
      paramMsfMessagePair.append(" ms by IPC block");
      QLog.d("MSF.S.AppProcessManager", 1, paramMsfMessagePair.toString());
      try
      {
        sleep(this.k);
        return;
      }
      catch (Exception paramMsfMessagePair)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.S.AppProcessManager", 2, "sleepByIPCBlock throws ex: ", paramMsfMessagePair);
        }
      }
    }
  }
  
  private void b(MsfMessagePair paramMsfMessagePair, int paramInt1, int paramInt2, IMsfServiceCallbacker paramIMsfServiceCallbacker)
  {
    Object localObject2;
    int m;
    Object localObject1;
    int i1;
    try
    {
      arrayOfByte = paramMsfMessagePair.fromServiceMsg.getWupBuffer();
      localObject2 = null;
      m = 0;
      n = 0;
    }
    catch (OutOfMemoryError paramIMsfServiceCallbacker)
    {
      byte[] arrayOfByte;
      int n;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("transportToAppProcess throw oom, cmd = ");
      ((StringBuilder)localObject1).append(paramMsfMessagePair.fromServiceMsg.getServiceCmd());
      QLog.e("MSF.S.AppProcessManager", 1, ((StringBuilder)localObject1).toString(), paramIMsfServiceCallbacker);
      h.a().a(false, paramIMsfServiceCallbacker.getClass().getSimpleName(), c(paramMsfMessagePair), paramInt2, paramMsfMessagePair.fromServiceMsg.getServiceCmd(), this.k);
      return;
    }
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (localObject2.length == i1) {}
    }
    else
    {
      localObject1 = new byte[i1];
    }
    System.arraycopy(arrayOfByte, m, localObject1, 0, i1);
    paramMsfMessagePair.fromServiceMsg.putWupBuffer((byte[])localObject1);
    if (a(paramMsfMessagePair, m, paramInt1, paramInt2, n, paramIMsfServiceCallbacker))
    {
      m += i1;
    }
    else
    {
      paramInt1 /= 2;
      n += 1;
    }
    label244:
    for (;;)
    {
      h.a().a(true, "", c(paramMsfMessagePair), paramInt2, paramMsfMessagePair.fromServiceMsg.getServiceCmd(), this.k);
      return;
      for (;;)
      {
        if (m >= paramInt2) {
          break label244;
        }
        if (m + paramInt1 <= paramInt2)
        {
          i1 = paramInt1;
          break;
        }
        i1 = paramInt2 - m;
        break;
        localObject2 = localObject1;
      }
    }
  }
  
  private int c(MsfMessagePair paramMsfMessagePair)
  {
    if (paramMsfMessagePair.toServiceMsg != null) {
      return paramMsfMessagePair.toServiceMsg.getWupBuffer().length;
    }
    return 0;
  }
  
  public void a()
  {
    synchronized (this.a)
    {
      this.c = true;
      this.b = false;
      this.a.notify();
      return;
    }
  }
  
  void a(MsfMessagePair paramMsfMessagePair, IMsfServiceCallbacker paramIMsfServiceCallbacker)
  {
    if (paramMsfMessagePair.toServiceMsg == null)
    {
      paramIMsfServiceCallbacker.onReceivePushResp(paramMsfMessagePair.fromServiceMsg);
      return;
    }
    paramIMsfServiceCallbacker.onResponse(paramMsfMessagePair.toServiceMsg, paramMsfMessagePair.fromServiceMsg);
  }
  
  public void run()
  {
    for (;;)
    {
      e.f.f = false;
      while (this.c)
      {
        this.c = false;
        this.d = 0;
        ??? = e.c.keySet().iterator();
        while (((Iterator)???).hasNext())
        {
          String str = (String)((Iterator)???).next();
          c localc = (c)e.c.get(str);
          if (localc != null)
          {
            if (a(str, localc)) {
              this.c = true;
            }
            this.d += localc.i.size();
          }
        }
      }
      this.b = true;
      synchronized (this.a)
      {
        boolean bool = this.b;
        if (bool) {
          try
          {
            if (this.d == 0) {
              this.a.wait(61440L);
            } else {
              this.a.wait(600L);
            }
            this.c = true;
          }
          catch (InterruptedException localInterruptedException)
          {
            localInterruptedException.printStackTrace();
          }
        }
      }
    }
    for (;;)
    {
      throw localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msf.service.b
 * JD-Core Version:    0.7.0.1
 */