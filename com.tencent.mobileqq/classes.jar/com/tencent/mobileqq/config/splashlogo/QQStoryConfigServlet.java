package com.tencent.mobileqq.config.splashlogo;

import android.content.Intent;
import android.text.TextUtils;
import android.util.SparseIntArray;
import com.tencent.biz.qqstory.base.QQStoryHandler;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.boundaries.StoryDepends.ConfigServlet;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.ConfigSeq;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.ReqGetConfig;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.RespGetConfig;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;
import mqq.app.Packet;

public class QQStoryConfigServlet
  extends MSFServlet
{
  public static int[][] a;
  public static SparseIntArray b;
  
  static
  {
    Object localObject = { 2131492911, -127 };
    int[] arrayOfInt1 = { 2131492913, -150 };
    int[] arrayOfInt2 = { 2131492909, -220 };
    int[] arrayOfInt3 = { 2131492907, 152 };
    int[] arrayOfInt4 = { -1, 219 };
    a = new int[][] { localObject, { 2131492912, -128 }, arrayOfInt1, { 2131492908, -151 }, { 2131492910, -208 }, arrayOfInt2, arrayOfInt3, { 2131492920, 317 }, { 2131492922, 318 }, arrayOfInt4, { -1, 350 }, { -1, 356 }, { -1, 366 } };
    b = new SparseIntArray(a.length);
    localObject = a;
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      arrayOfInt1 = localObject[i];
      int k = arrayOfInt1[0];
      int m = arrayOfInt1[1];
      if (k != -1) {
        b.put(StoryApi.d(k), m);
      } else {
        b.put(m, m);
      }
      i += 1;
    }
    StoryDepends.ConfigServlet.a(b);
  }
  
  private void a(QQAppInterface paramQQAppInterface, Intent paramIntent, Packet paramPacket)
  {
    ConfigurationService.ReqGetConfig localReqGetConfig = new ConfigurationService.ReqGetConfig();
    String str = paramIntent.getStringExtra("key_uin");
    int k = b.size();
    paramIntent = new ArrayList(k);
    boolean bool = SharedPreUtils.Y(paramQQAppInterface.getApp(), "Q.qqstory.config.QQStoryConfigServlet");
    ArrayList localArrayList = new ArrayList(k);
    int i = 0;
    while (i < k)
    {
      int m = b.keyAt(i);
      Object localObject = StoryConfigManager.a(b.valueAt(i));
      ConfigurationService.ConfigSeq localConfigSeq = new ConfigurationService.ConfigSeq();
      localConfigSeq.type.set(m);
      int j;
      if (bool)
      {
        SharedPreUtils.d(paramQQAppInterface.getApp(), (String)localObject, str);
        j = 0;
      }
      else
      {
        j = SharedPreUtils.c(paramQQAppInterface.getApp(), (String)localObject, str);
      }
      localConfigSeq.version.set(j);
      paramIntent.add(localConfigSeq);
      localArrayList.add(Integer.valueOf(m));
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("addAllConfigs|send type: ");
        ((StringBuilder)localObject).append(m);
        QLog.d("Q.qqstory.config.QQStoryConfigServlet", 2, new Object[] { ((StringBuilder)localObject).toString(), " version: ", Integer.valueOf(j) });
      }
      i += 1;
    }
    if (bool) {
      SharedPreUtils.X(paramQQAppInterface.getApp(), "Q.qqstory.config.QQStoryConfigServlet");
    }
    if (QLog.isColorLevel())
    {
      i = localArrayList.size();
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("addAllConfigs|send length: ");
      paramQQAppInterface.append(i);
      QLog.d("Q.qqstory.config.QQStoryConfigServlet", 2, paramQQAppInterface.toString());
    }
    localReqGetConfig.setHasFlag(true);
    localReqGetConfig.seq_list.addAll(paramIntent);
    paramQQAppInterface = ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).getSosoInfo();
    SLog.b("Q.qqstory.config.QQStoryConfigServlet", "addAllConfigs");
    if (paramQQAppInterface == null)
    {
      SLog.b("Q.qqstory.config.QQStoryConfigServlet", "lbsInfo is null.");
    }
    else if (paramQQAppInterface.mLocation == null)
    {
      SLog.b("Q.qqstory.config.QQStoryConfigServlet", "lbsInfo.location is null.");
    }
    else if (TextUtils.isEmpty(paramQQAppInterface.mLocation.cityCode))
    {
      SLog.b("Q.qqstory.config.QQStoryConfigServlet", "lbsInfo.location.cityCode is null");
    }
    else
    {
      SLog.a("Q.qqstory.config.QQStoryConfigServlet", "adcode:%s", paramQQAppInterface.mLocation.cityCode);
      localReqGetConfig.adcode.set(Long.valueOf(paramQQAppInterface.mLocation.cityCode).longValue());
    }
    paramQQAppInterface = a(localReqGetConfig);
    if ((paramQQAppInterface != null) && (paramQQAppInterface.length > 0)) {
      paramPacket.putSendData(paramQQAppInterface);
    }
    paramPacket.setSSOCommand("ConfigurationService.ReqGetConfig");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    NewIntent localNewIntent = new NewIntent(paramQQAppInterface.getApp(), QQStoryConfigServlet.class);
    localNewIntent.putExtra("key_uin", paramString);
    localNewIntent.putExtra("k_req_occasion", 0);
    paramQQAppInterface.startServlet(localNewIntent);
  }
  
  private void a(ConfigurationService.RespGetConfig paramRespGetConfig, QQAppInterface paramQQAppInterface, Intent paramIntent, boolean paramBoolean)
  {
    Object localObject1 = paramRespGetConfig;
    int i;
    if ((paramBoolean) && (((ConfigurationService.RespGetConfig)localObject1).result.get() == 0) && (((ConfigurationService.RespGetConfig)localObject1).config_list != null) && (((ConfigurationService.RespGetConfig)localObject1).config_list.size() != 0))
    {
      long l1 = System.currentTimeMillis();
      j = ((ConfigurationService.RespGetConfig)localObject1).config_list.size();
      localObject1 = new ArrayList(b.size());
      i = 0;
      while (i < b.size())
      {
        ((List)localObject1).add(Integer.valueOf(b.keyAt(i)));
        i += 1;
      }
      Object localObject2 = (StoryConfigManager)SuperManager.a(10);
      i = 0;
      while (i < j)
      {
        ConfigurationService.Config localConfig = (ConfigurationService.Config)paramRespGetConfig.config_list.get(i);
        if (localConfig != null)
        {
          while (!localConfig.type.has()) {}
          int k = localConfig.type.get();
          ((List)localObject1).remove(Integer.valueOf(k));
          int m = b.get(k, k);
          SLog.a("Q.qqstory.config.QQStoryConfigServlet", "receiveAllConfigs|receive type: %d, localConfigId: %d, length: %d", Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(j));
          String str1 = paramIntent.getStringExtra("key_uin");
          String str2 = StoryConfigManager.a(m);
          int n = SharedPreUtils.c(paramQQAppInterface.getApp(), str2, str1);
          String str3 = ConfigServlet.a(localConfig, n, m);
          if (localConfig.content_list.size() > 0) {
            SLog.a("Q.qqstory.config.QQStoryConfigServlet", "%d --> %s", Integer.valueOf(m), (String)localConfig.content_list.get(0));
          }
          SLog.a("Q.qqstory.config.QQStoryConfigServlet", "%d ---> %s", Integer.valueOf(m), str3);
          paramBoolean = ((StoryConfigManager)localObject2).a(m, paramIntent, localConfig);
          if (paramBoolean) {
            SharedPreUtils.a(paramQQAppInterface.getApp(), str2, str1, localConfig.version.get());
          }
          SLog.b("Q.qqstory.config.QQStoryConfigServlet", "receiveAllConfigs|receive type: %d, localConfigId: %d, length: %d, localVersion:%d, newVersion: %d, handled: %b", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(j), Integer.valueOf(n), Integer.valueOf(localConfig.version.get()), Boolean.valueOf(paramBoolean) });
        }
        i += 1;
      }
      long l2 = System.currentTimeMillis();
      if (QLog.isColorLevel())
      {
        paramRespGetConfig = new StringBuilder();
        paramRespGetConfig.append("receiveAllConfigs|executeSpendTime: ");
        paramRespGetConfig.append(l2 - l1);
        QLog.w("Q.qqstory.config.QQStoryConfigServlet", 2, paramRespGetConfig.toString());
      }
      paramRespGetConfig = ((List)localObject1).iterator();
      while (paramRespGetConfig.hasNext())
      {
        paramIntent = (Integer)paramRespGetConfig.next();
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("receiveAllConfigs|noReceiveType: ");
          ((StringBuilder)localObject2).append(paramIntent);
          ((StringBuilder)localObject2).append(",length: ");
          ((StringBuilder)localObject2).append(((List)localObject1).size());
          QLog.w("Q.qqstory.config.QQStoryConfigServlet", 2, ((StringBuilder)localObject2).toString());
        }
        if (paramIntent.intValue() == 243) {
          ((QQStoryHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.QQSTORY_HANDLER)).notifyUI(1021, true, null);
        }
      }
      return;
    }
    int j = 0;
    if (!paramBoolean)
    {
      i = j;
      if (QLog.isColorLevel())
      {
        QLog.i("Q.qqstory.config.QQStoryConfigServlet", 2, "receiveAllConfigs|isSuccess == false");
        i = j;
      }
    }
    else if (paramRespGetConfig.result.get() != 0)
    {
      i = j;
      if (QLog.isColorLevel())
      {
        QLog.i("Q.qqstory.config.QQStoryConfigServlet", 2, "receiveAllConfigs|resultCode != 0");
        i = j;
      }
    }
    else if (paramRespGetConfig.config_list != null)
    {
      i = j;
      if (paramRespGetConfig.config_list.size() != 0) {}
    }
    else
    {
      i = j;
      if (QLog.isColorLevel())
      {
        QLog.i("Q.qqstory.config.QQStoryConfigServlet", 2, "receiveAllConfigs|config_list empty data");
        i = j;
      }
    }
    while (i < b.size())
    {
      if (QLog.isColorLevel())
      {
        paramRespGetConfig = new StringBuilder();
        paramRespGetConfig.append("receiveAllConfigs|failed type: ");
        paramRespGetConfig.append(b.keyAt(i));
        QLog.i("Q.qqstory.config.QQStoryConfigServlet", 2, paramRespGetConfig.toString());
      }
      i += 1;
    }
  }
  
  public static byte[] a(ConfigurationService.ReqGetConfig paramReqGetConfig)
  {
    paramReqGetConfig = paramReqGetConfig.toByteArray();
    long l = paramReqGetConfig.length;
    int i = (int)l;
    byte[] arrayOfByte = new byte[i + 4];
    PkgTools.dWord2Byte(arrayOfByte, 0, l + 4L);
    PkgTools.copyData(arrayOfByte, 4, paramReqGetConfig, i);
    return arrayOfByte;
  }
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte.length - 4;
    byte[] arrayOfByte = new byte[i];
    PkgTools.copyData(arrayOfByte, 0, paramArrayOfByte, 4, i);
    return arrayOfByte;
  }
  
  /* Error */
  public void onReceive(Intent paramIntent, com.tencent.qphone.base.remote.FromServiceMsg paramFromServiceMsg)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 451	com/tencent/mobileqq/config/splashlogo/QQStoryConfigServlet:getAppRuntime	()Lmqq/app/AppRuntime;
    //   4: checkcast 70	com/tencent/mobileqq/app/QQAppInterface
    //   7: astore 6
    //   9: aload_2
    //   10: invokevirtual 456	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   13: istore 5
    //   15: getstatic 31	com/tencent/mobileqq/config/splashlogo/QQStoryConfigServlet:b	Landroid/util/SparseIntArray;
    //   18: invokevirtual 65	android/util/SparseIntArray:size	()I
    //   21: ifne +10 -> 31
    //   24: aload_0
    //   25: aload_1
    //   26: iconst_0
    //   27: invokestatic 459	com/tencent/biz/qqstory/boundaries/StoryDepends$ConfigServlet:a	(Lmqq/app/MSFServlet;Landroid/content/Intent;Z)V
    //   30: return
    //   31: invokestatic 133	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   34: ifeq +89 -> 123
    //   37: getstatic 31	com/tencent/mobileqq/config/splashlogo/QQStoryConfigServlet:b	Landroid/util/SparseIntArray;
    //   40: invokevirtual 65	android/util/SparseIntArray:size	()I
    //   43: istore 4
    //   45: iconst_0
    //   46: istore_3
    //   47: iload_3
    //   48: getstatic 31	com/tencent/mobileqq/config/splashlogo/QQStoryConfigServlet:b	Landroid/util/SparseIntArray;
    //   51: invokevirtual 65	android/util/SparseIntArray:size	()I
    //   54: if_icmpge +69 -> 123
    //   57: new 135	java/lang/StringBuilder
    //   60: dup
    //   61: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   64: astore 7
    //   66: aload 7
    //   68: ldc_w 461
    //   71: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: pop
    //   75: aload 7
    //   77: getstatic 31	com/tencent/mobileqq/config/splashlogo/QQStoryConfigServlet:b	Landroid/util/SparseIntArray;
    //   80: iload_3
    //   81: invokevirtual 85	android/util/SparseIntArray:keyAt	(I)I
    //   84: invokevirtual 145	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   87: pop
    //   88: aload 7
    //   90: ldc_w 392
    //   93: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: pop
    //   97: aload 7
    //   99: iload 4
    //   101: invokevirtual 145	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   104: pop
    //   105: ldc 76
    //   107: iconst_2
    //   108: aload 7
    //   110: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   113: invokestatic 415	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   116: iload_3
    //   117: iconst_1
    //   118: iadd
    //   119: istore_3
    //   120: goto -73 -> 47
    //   123: aload_2
    //   124: invokevirtual 464	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   127: astore 7
    //   129: aload 7
    //   131: ifnull +116 -> 247
    //   134: aload 7
    //   136: arraylength
    //   137: iconst_4
    //   138: if_icmpge +6 -> 144
    //   141: goto +106 -> 247
    //   144: aload_2
    //   145: aload 7
    //   147: invokestatic 466	com/tencent/mobileqq/config/splashlogo/QQStoryConfigServlet:a	([B)[B
    //   150: invokevirtual 469	com/tencent/qphone/base/remote/FromServiceMsg:putWupBuffer	([B)V
    //   153: new 283	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig
    //   156: dup
    //   157: invokespecial 470	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:<init>	()V
    //   160: astore 7
    //   162: aload 7
    //   164: aload_2
    //   165: invokevirtual 464	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   168: invokevirtual 474	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   171: pop
    //   172: aload_0
    //   173: aload 7
    //   175: aload 6
    //   177: aload_1
    //   178: iload 5
    //   180: invokespecial 476	com/tencent/mobileqq/config/splashlogo/QQStoryConfigServlet:a	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig;Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Intent;Z)V
    //   183: aload_0
    //   184: aload_1
    //   185: iconst_1
    //   186: invokestatic 459	com/tencent/biz/qqstory/boundaries/StoryDepends$ConfigServlet:a	(Lmqq/app/MSFServlet;Landroid/content/Intent;Z)V
    //   189: return
    //   190: astore_2
    //   191: invokestatic 133	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   194: ifeq +42 -> 236
    //   197: new 135	java/lang/StringBuilder
    //   200: dup
    //   201: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   204: astore 6
    //   206: aload 6
    //   208: ldc_w 478
    //   211: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: pop
    //   215: aload 6
    //   217: aload_2
    //   218: invokevirtual 479	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:toString	()Ljava/lang/String;
    //   221: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: pop
    //   225: ldc 76
    //   227: iconst_2
    //   228: aload 6
    //   230: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   233: invokestatic 166	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   236: aload_2
    //   237: invokevirtual 482	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   240: aload_0
    //   241: aload_1
    //   242: iconst_0
    //   243: invokestatic 459	com/tencent/biz/qqstory/boundaries/StoryDepends$ConfigServlet:a	(Lmqq/app/MSFServlet;Landroid/content/Intent;Z)V
    //   246: return
    //   247: invokestatic 133	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   250: ifeq +12 -> 262
    //   253: ldc 76
    //   255: iconst_2
    //   256: ldc_w 484
    //   259: invokestatic 166	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   262: aload_0
    //   263: aload_1
    //   264: iconst_0
    //   265: invokestatic 459	com/tencent/biz/qqstory/boundaries/StoryDepends$ConfigServlet:a	(Lmqq/app/MSFServlet;Landroid/content/Intent;Z)V
    //   268: return
    //   269: astore_2
    //   270: goto -87 -> 183
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	273	0	this	QQStoryConfigServlet
    //   0	273	1	paramIntent	Intent
    //   0	273	2	paramFromServiceMsg	com.tencent.qphone.base.remote.FromServiceMsg
    //   46	74	3	i	int
    //   43	57	4	j	int
    //   13	166	5	bool	boolean
    //   7	222	6	localObject1	Object
    //   64	110	7	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   162	172	190	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   172	183	269	java/lang/Exception
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
    if (b.size() == 0) {
      return;
    }
    if (QLog.isColorLevel())
    {
      int j = b.size();
      int i = 0;
      while (i < b.size())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onSend. cmd: ");
        localStringBuilder.append(b.keyAt(i));
        localStringBuilder.append(",length: ");
        localStringBuilder.append(j);
        QLog.i("Q.qqstory.config.QQStoryConfigServlet", 2, localStringBuilder.toString());
        i += 1;
      }
    }
    a(localQQAppInterface, paramIntent, paramPacket);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.splashlogo.QQStoryConfigServlet
 * JD-Core Version:    0.7.0.1
 */