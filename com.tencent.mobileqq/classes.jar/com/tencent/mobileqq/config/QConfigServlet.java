package com.tencent.mobileqq.config;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.injectimpl.OldServletInjectorImpl;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.ConfigSeq;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.ReqGetConfig;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.RespGetConfig;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.TabRule;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class QConfigServlet
  extends MSFServlet
{
  public static String a;
  protected static boolean b;
  protected static boolean c;
  protected static boolean d;
  protected static int e;
  protected static boolean f;
  protected static int g;
  protected static boolean h;
  protected static int i;
  protected static boolean j;
  protected static boolean k;
  @ConfigInject(configPath="/Foundation/QQCommon/src/main/resources/Inject_config_old_servlet.yml", version=1)
  public static ArrayList<Class<? extends IOldServletInjector>> l;
  private static final String m;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(QConfigServlet.class.getSimpleName());
    localStringBuilder.append(".CORE");
    m = localStringBuilder.toString();
    a = "";
    e = 0;
    g = 0;
    i = 0;
    l = new ArrayList();
    l.add(OldServletInjectorImpl.class);
    l.add(OldServletInjectorImpl.class);
  }
  
  private void a(Intent paramIntent, ConfigurationService.ReqGetConfig paramReqGetConfig, List<ConfigurationService.ConfigSeq> paramList, List<Integer> paramList1, List<Integer> paramList2)
  {
    int[] arrayOfInt = new int[paramList1.size()];
    int n = 0;
    while (n < paramList1.size())
    {
      arrayOfInt[n] = ((Integer)paramList1.get(n)).intValue();
      n += 1;
    }
    a().a(getAppRuntime(), paramIntent, paramReqGetConfig, arrayOfInt, paramList, paramList2, a);
    if ((QLog.isColorLevel()) && (paramList1.size() > 0))
    {
      paramIntent = new StringBuilder();
      paramIntent.append("old config send, len=");
      paramIntent.append(paramList1.size());
      paramIntent.append(", type:");
      paramIntent = new StringBuilder(paramIntent.toString());
      paramReqGetConfig = paramList1.iterator();
      while (paramReqGetConfig.hasNext())
      {
        paramIntent.append((Integer)paramReqGetConfig.next());
        paramIntent.append(",");
      }
      QLog.d(m, 2, paramIntent.toString());
    }
  }
  
  private void a(Intent paramIntent, ConfigurationService.RespGetConfig paramRespGetConfig, int[] paramArrayOfInt, List<Integer> paramList)
  {
    int i2 = paramRespGetConfig.config_list.size();
    int n = 0;
    while (n < i2)
    {
      ConfigurationService.Config localConfig = (ConfigurationService.Config)paramRespGetConfig.config_list.get(n);
      if (localConfig != null)
      {
        int i3;
        do
        {
          while (!localConfig.type.has()) {}
          i3 = localConfig.type.get();
        } while (!QConfigManager.b().c(i3));
        paramList.remove(Integer.valueOf(i3));
        int i4 = localConfig.version.get();
        if (QLog.isColorLevel())
        {
          IQConfigProcessor localIQConfigProcessor = QConfigManager.b().a(i3);
          if (localIQConfigProcessor == null)
          {
            QLog.d(m, 2, new Object[] { "onReceive, type=", Integer.valueOf(i3), ", processor==null" });
          }
          else
          {
            String str = m;
            int i5 = QConfigManager.b().a(i3, a);
            int i1;
            if (localIQConfigProcessor.isNeedCompressed()) {
              i1 = localConfig.msg_content_list.size();
            } else {
              i1 = localConfig.content_list.size();
            }
            QLog.d(str, 2, new Object[] { "onReceive, type=", Integer.valueOf(i3), ", oldVersion=", Integer.valueOf(i5), ", newVersion=", Integer.valueOf(i4), ", contentSize=", Integer.valueOf(i1) });
          }
        }
        QConfigManager.b().a(i3, i4, localConfig, a);
        g += 1;
      }
      n += 1;
    }
    a().a(getAppRuntime(), paramRespGetConfig, paramList, paramIntent, paramArrayOfInt, true);
    h = true;
  }
  
  private void a(HandlerThread paramHandlerThread)
  {
    if (Build.VERSION.SDK_INT >= 18)
    {
      paramHandlerThread.quitSafely();
      return;
    }
    paramHandlerThread.quit();
  }
  
  private void a(ConfigurationService.RespGetConfig paramRespGetConfig, List<Integer> paramList, int paramInt)
  {
    List localList = paramRespGetConfig.next_req_types.get();
    if ((localList != null) && (localList.size() != 0))
    {
      int[] arrayOfInt = new int[localList.size()];
      int i2 = localList.size();
      int i1 = 0;
      int n = 0;
      while (n < i2)
      {
        int i3 = ((Integer)localList.get(n)).intValue();
        arrayOfInt[n] = i3;
        if (paramList.size() > 0) {
          paramList.remove(Integer.valueOf(i3));
        }
        n += 1;
      }
      paramList = new StringBuilder();
      paramList.append("onReceive page req, next config type: ");
      i2 = arrayOfInt.length;
      n = i1;
      while (n < i2)
      {
        paramList.append(arrayOfInt[n]);
        paramList.append(",");
        n += 1;
      }
      QLog.d(m, 1, paramList.toString());
      if (paramRespGetConfig.cookies.has()) {
        paramRespGetConfig = paramRespGetConfig.cookies.get().toByteArray();
      } else {
        paramRespGetConfig = null;
      }
      QConfigManager.a(arrayOfInt, a, paramRespGetConfig, paramInt + 1);
      k = true;
      return;
    }
    QLog.d(m, 2, "onReceive page req, no data for next req");
  }
  
  private void a(ArrayList<QConReqExtraInfo> paramArrayList, List<ConfigurationService.ConfigSeq> paramList, List<Integer> paramList1, List<Integer> paramList2)
  {
    Iterator localIterator = paramArrayList.iterator();
    QConReqExtraInfo localQConReqExtraInfo;
    Object localObject;
    while (localIterator.hasNext())
    {
      localQConReqExtraInfo = (QConReqExtraInfo)localIterator.next();
      if (!QConfigManager.b().c(localQConReqExtraInfo.a))
      {
        paramList1.add(Integer.valueOf(localQConReqExtraInfo.a));
      }
      else
      {
        localObject = new ConfigurationService.ConfigSeq();
        ((ConfigurationService.ConfigSeq)localObject).type.set(localQConReqExtraInfo.a);
      }
    }
    for (;;)
    {
      try
      {
        IQConfigProcessor localIQConfigProcessor = QConfigManager.b().a(localQConReqExtraInfo.a);
        if (localIQConfigProcessor == null) {
          break;
        }
        int n = localIQConfigProcessor.onSend(QConfigManager.b().a(localQConReqExtraInfo.a, a));
        boolean bool = QConfigManager.b().a(getAppRuntime(), localQConReqExtraInfo.a);
        if ((bool) || (localQConReqExtraInfo.b))
        {
          QConfigManager.b().a(localQConReqExtraInfo.a, 0);
          n = 0;
        }
        if (QLog.isColorLevel())
        {
          String str = m;
          int i1 = localQConReqExtraInfo.a;
          if (!bool) {
            break label381;
          }
          paramArrayList = ", ResetVersion!";
          QLog.d(str, 2, new Object[] { "new config send, type=", Integer.valueOf(i1), ", version=", Integer.valueOf(n), paramArrayList });
        }
        ((ConfigurationService.ConfigSeq)localObject).version.set(n);
        if (localIQConfigProcessor.isNeedCompressed()) {
          ((ConfigurationService.ConfigSeq)localObject).compress.set(1);
        }
        paramArrayList = new ConfigurationService.TabRule();
        paramArrayList.experiment_id.set(localIQConfigProcessor.tabExperimentId());
        paramArrayList.group_id.set(localIQConfigProcessor.tabGroupId());
        ((ConfigurationService.ConfigSeq)localObject).tab_rule.set(paramArrayList);
        paramList.add(localObject);
        paramList2.add(Integer.valueOf(localQConReqExtraInfo.a));
      }
      catch (Exception paramArrayList)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("exception ");
        ((StringBuilder)localObject).append(localQConReqExtraInfo.a);
        QLog.d("QConfigManager", 1, ((StringBuilder)localObject).toString(), paramArrayList);
      }
      break;
      return;
      label381:
      paramArrayList = "";
    }
  }
  
  private void a(List<Integer> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QConfigServlet no receive, len=");
    localStringBuilder.append(paramList.size());
    localStringBuilder.append(", type: ");
    localStringBuilder = new StringBuilder(localStringBuilder.toString());
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      int n = ((Integer)localIterator.next()).intValue();
      if (QLog.isColorLevel())
      {
        localStringBuilder.append(n);
        localStringBuilder.append(",");
      }
      if (QConfigManager.b().c(n))
      {
        QConfigManager.b().b(n, a);
        i += 1;
      }
    }
    if ((QLog.isColorLevel()) && (paramList.size() > 0)) {
      QLog.w(m, 2, localStringBuilder.toString());
    }
    a().a(getAppRuntime(), paramList);
    j = true;
  }
  
  private boolean a(Intent paramIntent, ConfigurationService.RespGetConfig paramRespGetConfig, int[] paramArrayOfInt, boolean paramBoolean)
  {
    if ((paramBoolean) && (paramRespGetConfig.result.get() == 0) && (paramRespGetConfig.config_list.size() != 0)) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d(m, 2, new Object[] { "onReceive fail: success=", Boolean.valueOf(paramBoolean), ", resultCode=", Integer.valueOf(paramRespGetConfig.result.get()), "config_list_size=", Integer.valueOf(paramRespGetConfig.config_list.size()) });
    }
    int i2 = paramArrayOfInt.length;
    int i1 = 0;
    while (i1 < i2)
    {
      int n = paramArrayOfInt[i1];
      if (QConfigManager.b().c(n))
      {
        IQConfigProcessor localIQConfigProcessor = QConfigManager.b().a(n);
        if (localIQConfigProcessor != null)
        {
          if (paramRespGetConfig.result.get() != 0) {
            n = -2;
          } else if (!paramBoolean) {
            n = -1;
          } else {
            n = 0;
          }
          if (n != 0)
          {
            localIQConfigProcessor.onReqFailed(n);
            e += 1;
          }
        }
      }
      i1 += 1;
    }
    a().a(getAppRuntime(), paramRespGetConfig, paramIntent, paramArrayOfInt, paramBoolean);
    f = true;
    return true;
  }
  
  public IOldServletInjector a()
  {
    if (l.size() != 0) {
      try
      {
        IOldServletInjector localIOldServletInjector = (IOldServletInjector)((Class)l.get(0)).newInstance();
        return localIOldServletInjector;
      }
      catch (InstantiationException localInstantiationException)
      {
        localInstantiationException.printStackTrace();
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        localIllegalAccessException.printStackTrace();
      }
    } else {
      QLog.i(m, 2, "getOldServletInjector. mOldServletInjectors.size() = 0");
    }
    return new BaseOldServletInjector();
  }
  
  /* Error */
  protected void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg, HandlerThread paramHandlerThread)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 108	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +604 -> 609
    //   8: getstatic 51	com/tencent/mobileqq/config/QConfigServlet:m	Ljava/lang/String;
    //   11: iconst_2
    //   12: iconst_2
    //   13: anewarray 189	java/lang/Object
    //   16: dup
    //   17: iconst_0
    //   18: ldc_w 415
    //   21: aastore
    //   22: dup
    //   23: iconst_1
    //   24: aload_1
    //   25: aastore
    //   26: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   29: goto +580 -> 609
    //   32: aload_1
    //   33: ldc_w 417
    //   36: invokevirtual 423	android/content/Intent:getParcelableArrayListExtra	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   39: astore 9
    //   41: aload 9
    //   43: ifnull +543 -> 586
    //   46: aload 9
    //   48: invokevirtual 426	java/util/ArrayList:isEmpty	()Z
    //   51: ifeq +6 -> 57
    //   54: goto +532 -> 586
    //   57: aload 9
    //   59: invokestatic 431	com/tencent/mobileqq/config/QConfigHelper:a	(Ljava/util/ArrayList;)[I
    //   62: astore 12
    //   64: aload_2
    //   65: invokevirtual 436	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   68: astore 9
    //   70: aload 9
    //   72: ifnull +474 -> 546
    //   75: aload 9
    //   77: arraylength
    //   78: iconst_4
    //   79: if_icmpge +6 -> 85
    //   82: goto +464 -> 546
    //   85: aload_2
    //   86: aload 9
    //   88: invokestatic 439	com/tencent/mobileqq/config/QConfigHelper:b	([B)[B
    //   91: invokevirtual 443	com/tencent/qphone/base/remote/FromServiceMsg:putWupBuffer	([B)V
    //   94: aload_0
    //   95: invokevirtual 446	com/tencent/mobileqq/config/QConfigServlet:b	()Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig;
    //   98: astore 11
    //   100: aload 11
    //   102: aload_2
    //   103: invokevirtual 436	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   106: invokevirtual 450	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   109: pop
    //   110: invokestatic 108	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   113: ifeq +34 -> 147
    //   116: getstatic 51	com/tencent/mobileqq/config/QConfigServlet:m	Ljava/lang/String;
    //   119: iconst_2
    //   120: iconst_2
    //   121: anewarray 189	java/lang/Object
    //   124: dup
    //   125: iconst_0
    //   126: ldc_w 452
    //   129: aastore
    //   130: dup
    //   131: iconst_1
    //   132: aload 11
    //   134: getfield 148	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:config_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   137: invokevirtual 151	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   140: invokestatic 179	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   143: aastore
    //   144: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   147: aload 10
    //   149: astore 9
    //   151: aload 11
    //   153: getfield 455	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:cookies_new	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   156: invokevirtual 259	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   159: ifeq +16 -> 175
    //   162: aload 11
    //   164: getfield 455	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:cookies_new	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   167: invokevirtual 262	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   170: invokevirtual 268	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   173: astore 9
    //   175: aload 9
    //   177: ifnull +31 -> 208
    //   180: invokestatic 108	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   183: ifeq +13 -> 196
    //   186: getstatic 51	com/tencent/mobileqq/config/QConfigServlet:m	Ljava/lang/String;
    //   189: iconst_2
    //   190: ldc_w 457
    //   193: invokestatic 139	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   196: invokestatic 172	com/tencent/mobileqq/config/QConfigManager:b	()Lcom/tencent/mobileqq/config/QConfigManager;
    //   199: getstatic 55	com/tencent/mobileqq/config/QConfigServlet:a	Ljava/lang/String;
    //   202: aload 9
    //   204: invokevirtual 460	com/tencent/mobileqq/config/QConfigManager:a	(Ljava/lang/String;[B)Z
    //   207: pop
    //   208: aload_0
    //   209: invokevirtual 93	com/tencent/mobileqq/config/QConfigServlet:a	()Lcom/tencent/mobileqq/config/IOldServletInjector;
    //   212: aload 11
    //   214: invokeinterface 463 2 0
    //   219: iconst_1
    //   220: putstatic 465	com/tencent/mobileqq/config/QConfigServlet:d	Z
    //   223: aload_0
    //   224: aload_1
    //   225: aload 11
    //   227: aload 12
    //   229: aload_2
    //   230: invokevirtual 468	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   233: invokespecial 470	com/tencent/mobileqq/config/QConfigServlet:a	(Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig;[IZ)Z
    //   236: istore 6
    //   238: iload 6
    //   240: ifeq +11 -> 251
    //   243: aload_0
    //   244: aload_3
    //   245: invokespecial 472	com/tencent/mobileqq/config/QConfigServlet:a	(Landroid/os/HandlerThread;)V
    //   248: aload_0
    //   249: monitorexit
    //   250: return
    //   251: invokestatic 478	java/lang/System:currentTimeMillis	()J
    //   254: lstore 7
    //   256: new 63	java/util/ArrayList
    //   259: dup
    //   260: aload 12
    //   262: arraylength
    //   263: invokespecial 480	java/util/ArrayList:<init>	(I)V
    //   266: astore_2
    //   267: aload 12
    //   269: arraylength
    //   270: istore 5
    //   272: iconst_0
    //   273: istore 4
    //   275: iload 4
    //   277: iload 5
    //   279: if_icmpge +27 -> 306
    //   282: aload_2
    //   283: aload 12
    //   285: iload 4
    //   287: iaload
    //   288: invokestatic 179	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   291: invokeinterface 285 2 0
    //   296: pop
    //   297: iload 4
    //   299: iconst_1
    //   300: iadd
    //   301: istore 4
    //   303: goto -28 -> 275
    //   306: aload_0
    //   307: aload_1
    //   308: aload 11
    //   310: aload 12
    //   312: aload_2
    //   313: invokespecial 482	com/tencent/mobileqq/config/QConfigServlet:a	(Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig;[ILjava/util/List;)V
    //   316: invokestatic 108	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   319: ifeq +49 -> 368
    //   322: getstatic 51	com/tencent/mobileqq/config/QConfigServlet:m	Ljava/lang/String;
    //   325: astore 9
    //   327: new 31	java/lang/StringBuilder
    //   330: dup
    //   331: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   334: astore 10
    //   336: aload 10
    //   338: ldc_w 484
    //   341: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   344: pop
    //   345: aload 10
    //   347: invokestatic 478	java/lang/System:currentTimeMillis	()J
    //   350: lload 7
    //   352: lsub
    //   353: invokevirtual 487	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   356: pop
    //   357: aload 9
    //   359: iconst_2
    //   360: aload 10
    //   362: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   365: invokestatic 361	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   368: aload_1
    //   369: ldc_w 489
    //   372: iconst_0
    //   373: invokevirtual 493	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   376: istore 6
    //   378: iload 6
    //   380: ifeq +242 -> 622
    //   383: aload_1
    //   384: ldc_w 495
    //   387: iconst_0
    //   388: invokevirtual 499	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   391: istore 4
    //   393: goto +3 -> 396
    //   396: iload 6
    //   398: ifeq +43 -> 441
    //   401: getstatic 51	com/tencent/mobileqq/config/QConfigServlet:m	Ljava/lang/String;
    //   404: iconst_2
    //   405: iconst_2
    //   406: anewarray 189	java/lang/Object
    //   409: dup
    //   410: iconst_0
    //   411: ldc_w 501
    //   414: aastore
    //   415: dup
    //   416: iconst_1
    //   417: iload 4
    //   419: invokestatic 179	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   422: aastore
    //   423: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   426: iload 4
    //   428: iconst_3
    //   429: if_icmpge +12 -> 441
    //   432: aload_0
    //   433: aload 11
    //   435: aload_2
    //   436: iload 4
    //   438: invokespecial 503	com/tencent/mobileqq/config/QConfigServlet:a	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig;Ljava/util/List;I)V
    //   441: aload_0
    //   442: aload_2
    //   443: invokespecial 505	com/tencent/mobileqq/config/QConfigServlet:a	(Ljava/util/List;)V
    //   446: aload_0
    //   447: aload_3
    //   448: invokespecial 472	com/tencent/mobileqq/config/QConfigServlet:a	(Landroid/os/HandlerThread;)V
    //   451: goto +28 -> 479
    //   454: astore_1
    //   455: goto +27 -> 482
    //   458: astore_1
    //   459: invokestatic 108	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   462: ifeq -16 -> 446
    //   465: getstatic 51	com/tencent/mobileqq/config/QConfigServlet:m	Ljava/lang/String;
    //   468: iconst_2
    //   469: aload_1
    //   470: invokevirtual 506	java/lang/Exception:toString	()Ljava/lang/String;
    //   473: invokestatic 361	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   476: goto -30 -> 446
    //   479: aload_0
    //   480: monitorexit
    //   481: return
    //   482: aload_0
    //   483: aload_3
    //   484: invokespecial 472	com/tencent/mobileqq/config/QConfigServlet:a	(Landroid/os/HandlerThread;)V
    //   487: aload_1
    //   488: athrow
    //   489: astore_1
    //   490: invokestatic 108	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   493: ifeq +45 -> 538
    //   496: getstatic 51	com/tencent/mobileqq/config/QConfigServlet:m	Ljava/lang/String;
    //   499: astore_2
    //   500: new 31	java/lang/StringBuilder
    //   503: dup
    //   504: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   507: astore 9
    //   509: aload 9
    //   511: ldc_w 508
    //   514: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   517: pop
    //   518: aload 9
    //   520: aload_1
    //   521: invokevirtual 509	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:toString	()Ljava/lang/String;
    //   524: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   527: pop
    //   528: aload_2
    //   529: iconst_2
    //   530: aload 9
    //   532: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   535: invokestatic 139	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   538: aload_0
    //   539: aload_3
    //   540: invokespecial 472	com/tencent/mobileqq/config/QConfigServlet:a	(Landroid/os/HandlerThread;)V
    //   543: aload_0
    //   544: monitorexit
    //   545: return
    //   546: invokestatic 108	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   549: ifeq +13 -> 562
    //   552: getstatic 51	com/tencent/mobileqq/config/QConfigServlet:m	Ljava/lang/String;
    //   555: iconst_2
    //   556: ldc_w 511
    //   559: invokestatic 139	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   562: aload_0
    //   563: invokevirtual 93	com/tencent/mobileqq/config/QConfigServlet:a	()Lcom/tencent/mobileqq/config/IOldServletInjector;
    //   566: aload 12
    //   568: aload_2
    //   569: invokeinterface 514 3 0
    //   574: iconst_1
    //   575: putstatic 516	com/tencent/mobileqq/config/QConfigServlet:c	Z
    //   578: aload_0
    //   579: aload_3
    //   580: invokespecial 472	com/tencent/mobileqq/config/QConfigServlet:a	(Landroid/os/HandlerThread;)V
    //   583: aload_0
    //   584: monitorexit
    //   585: return
    //   586: iconst_1
    //   587: putstatic 517	com/tencent/mobileqq/config/QConfigServlet:b	Z
    //   590: aload_0
    //   591: aload_3
    //   592: invokespecial 472	com/tencent/mobileqq/config/QConfigServlet:a	(Landroid/os/HandlerThread;)V
    //   595: aload_0
    //   596: monitorexit
    //   597: return
    //   598: astore_1
    //   599: aload_0
    //   600: monitorexit
    //   601: goto +5 -> 606
    //   604: aload_1
    //   605: athrow
    //   606: goto -2 -> 604
    //   609: aconst_null
    //   610: astore 10
    //   612: aload_1
    //   613: ifnonnull -581 -> 32
    //   616: aconst_null
    //   617: astore 9
    //   619: goto -578 -> 41
    //   622: iconst_0
    //   623: istore 4
    //   625: goto -229 -> 396
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	628	0	this	QConfigServlet
    //   0	628	1	paramIntent	Intent
    //   0	628	2	paramFromServiceMsg	FromServiceMsg
    //   0	628	3	paramHandlerThread	HandlerThread
    //   273	351	4	n	int
    //   270	10	5	i1	int
    //   236	161	6	bool	boolean
    //   254	97	7	l1	long
    //   39	579	9	localObject	Object
    //   147	464	10	localStringBuilder	StringBuilder
    //   98	336	11	localRespGetConfig	ConfigurationService.RespGetConfig
    //   62	505	12	arrayOfInt	int[]
    // Exception table:
    //   from	to	target	type
    //   223	238	454	finally
    //   251	272	454	finally
    //   282	297	454	finally
    //   306	368	454	finally
    //   368	378	454	finally
    //   383	393	454	finally
    //   401	426	454	finally
    //   432	441	454	finally
    //   441	446	454	finally
    //   459	476	454	finally
    //   223	238	458	java/lang/Exception
    //   251	272	458	java/lang/Exception
    //   282	297	458	java/lang/Exception
    //   306	368	458	java/lang/Exception
    //   368	378	458	java/lang/Exception
    //   383	393	458	java/lang/Exception
    //   401	426	458	java/lang/Exception
    //   432	441	458	java/lang/Exception
    //   441	446	458	java/lang/Exception
    //   100	110	489	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   2	29	598	finally
    //   32	41	598	finally
    //   46	54	598	finally
    //   57	70	598	finally
    //   75	82	598	finally
    //   85	100	598	finally
    //   100	110	598	finally
    //   110	147	598	finally
    //   151	175	598	finally
    //   180	196	598	finally
    //   196	208	598	finally
    //   208	223	598	finally
    //   243	248	598	finally
    //   446	451	598	finally
    //   482	489	598	finally
    //   490	538	598	finally
    //   538	543	598	finally
    //   546	562	598	finally
    //   562	583	598	finally
    //   586	595	598	finally
  }
  
  public ConfigurationService.RespGetConfig b()
  {
    return new ConfigurationService.RespGetConfig();
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    HandlerThread localHandlerThread = ThreadManager.newFreeHandlerThread("QConfigServlet", -2);
    localHandlerThread.start();
    new Handler(localHandlerThread.getLooper()).post(new QConfigServlet.1(this, paramIntent, paramFromServiceMsg, localHandlerThread));
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.QConfigServlet
 * JD-Core Version:    0.7.0.1
 */