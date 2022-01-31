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
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.ConfigSeq;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.ReqGetConfig;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.RespGetConfig;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
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
  public static SparseIntArray a;
  public static int[][] a;
  
  static
  {
    Object localObject1 = { 2131689493, -208 };
    jdField_a_of_type_Array2dOfInt = new int[][] { { 2131689489, -127 }, { 2131689490, -128 }, { 2131689491, -150 }, { 2131689492, -151 }, localObject1, { 2131689494, -220 }, { 2131689495, 152 }, { 2131689496, 317 }, { 2131689497, 318 }, { -1, 219 } };
    jdField_a_of_type_AndroidUtilSparseIntArray = new SparseIntArray(jdField_a_of_type_Array2dOfInt.length);
    localObject1 = jdField_a_of_type_Array2dOfInt;
    int j = localObject1.length;
    int i = 0;
    if (i < j)
    {
      Object localObject2 = localObject1[i];
      int k = localObject2[0];
      int m = localObject2[1];
      if (k != -1) {
        jdField_a_of_type_AndroidUtilSparseIntArray.put(StoryApi.a(k), m);
      }
      for (;;)
      {
        i += 1;
        break;
        jdField_a_of_type_AndroidUtilSparseIntArray.put(m, m);
      }
    }
    StoryDepends.ConfigServlet.a(jdField_a_of_type_AndroidUtilSparseIntArray);
  }
  
  private void a(QQAppInterface paramQQAppInterface, Intent paramIntent, Packet paramPacket)
  {
    ConfigurationService.ReqGetConfig localReqGetConfig = new ConfigurationService.ReqGetConfig();
    Object localObject = paramIntent.getStringExtra("key_uin");
    int k = jdField_a_of_type_AndroidUtilSparseIntArray.size();
    paramIntent = new ArrayList(k);
    boolean bool = SharedPreUtils.b(paramQQAppInterface.getApp(), "QQStoryConfigServlet");
    ArrayList localArrayList = new ArrayList(k);
    int i = 0;
    if (i < k)
    {
      int m = jdField_a_of_type_AndroidUtilSparseIntArray.keyAt(i);
      String str = StoryConfigManager.a(jdField_a_of_type_AndroidUtilSparseIntArray.valueAt(i));
      ConfigurationService.ConfigSeq localConfigSeq = new ConfigurationService.ConfigSeq();
      localConfigSeq.type.set(m);
      int j = 0;
      if (bool) {
        SharedPreUtils.b(paramQQAppInterface.getApp(), str, (String)localObject);
      }
      for (;;)
      {
        localConfigSeq.version.set(j);
        paramIntent.add(localConfigSeq);
        localArrayList.add(Integer.valueOf(m));
        if (QLog.isColorLevel()) {
          QLog.d("QQStoryConfigServlet", 2, new Object[] { "addAllConfigs|send type: " + m, " version: ", Integer.valueOf(j) });
        }
        i += 1;
        break;
        j = SharedPreUtils.a(paramQQAppInterface.getApp(), str, (String)localObject);
      }
    }
    if (bool) {
      SharedPreUtils.g(paramQQAppInterface.getApp(), "QQStoryConfigServlet");
    }
    if (QLog.isColorLevel())
    {
      i = localArrayList.size();
      paramQQAppInterface = localArrayList.iterator();
      while (paramQQAppInterface.hasNext())
      {
        localObject = (Integer)paramQQAppInterface.next();
        QLog.d("QQStoryConfigServlet", 2, "addAllConfigs|send type: " + localObject + ",length: " + i);
      }
    }
    localReqGetConfig.setHasFlag(true);
    localReqGetConfig.seq_list.addAll(paramIntent);
    paramQQAppInterface = SosoInterface.b();
    SLog.b("QQStoryConfigServlet", "addAllConfigs");
    if (paramQQAppInterface == null) {
      SLog.b("QQStoryConfigServlet", "lbsInfo is null.");
    }
    for (;;)
    {
      paramQQAppInterface = a(localReqGetConfig);
      if ((paramQQAppInterface != null) && (paramQQAppInterface.length > 0)) {
        paramPacket.putSendData(paramQQAppInterface);
      }
      paramPacket.setSSOCommand("ConfigurationService.ReqGetConfig");
      return;
      if (paramQQAppInterface.a == null)
      {
        SLog.b("QQStoryConfigServlet", "lbsInfo.location is null.");
      }
      else if (TextUtils.isEmpty(paramQQAppInterface.a.f))
      {
        SLog.b("QQStoryConfigServlet", "lbsInfo.location.cityCode is null");
      }
      else
      {
        SLog.a("QQStoryConfigServlet", "adcode:%s", paramQQAppInterface.a.f);
        localReqGetConfig.adcode.set(Long.valueOf(paramQQAppInterface.a.f).longValue());
      }
    }
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
    if ((!paramBoolean) || (paramRespGetConfig.result.get() != 0) || (paramRespGetConfig.config_list == null) || (paramRespGetConfig.config_list.size() == 0))
    {
      if (!paramBoolean) {
        if (QLog.isColorLevel()) {
          QLog.i("QQStoryConfigServlet", 2, "receiveAllConfigs|isSuccess == false");
        }
      }
      for (;;)
      {
        i = 0;
        while (i < jdField_a_of_type_AndroidUtilSparseIntArray.size())
        {
          if (QLog.isColorLevel()) {
            QLog.i("QQStoryConfigServlet", 2, "receiveAllConfigs|failed type: " + jdField_a_of_type_AndroidUtilSparseIntArray.keyAt(i));
          }
          i += 1;
        }
        if (paramRespGetConfig.result.get() != 0)
        {
          if (QLog.isColorLevel()) {
            QLog.i("QQStoryConfigServlet", 2, "receiveAllConfigs|resultCode != 0");
          }
        }
        else if (((paramRespGetConfig.config_list == null) || (paramRespGetConfig.config_list.size() == 0)) && (QLog.isColorLevel())) {
          QLog.i("QQStoryConfigServlet", 2, "receiveAllConfigs|config_list empty data");
        }
      }
    }
    long l1 = System.currentTimeMillis();
    int j = paramRespGetConfig.config_list.size();
    ArrayList localArrayList = new ArrayList(jdField_a_of_type_AndroidUtilSparseIntArray.size());
    int i = 0;
    while (i < jdField_a_of_type_AndroidUtilSparseIntArray.size())
    {
      localArrayList.add(Integer.valueOf(jdField_a_of_type_AndroidUtilSparseIntArray.keyAt(i)));
      i += 1;
    }
    StoryConfigManager localStoryConfigManager = (StoryConfigManager)SuperManager.a(10);
    i = 0;
    if (i < j)
    {
      ConfigurationService.Config localConfig = (ConfigurationService.Config)paramRespGetConfig.config_list.get(i);
      if (localConfig == null) {}
      for (;;)
      {
        i += 1;
        break;
        if (localConfig.type.has())
        {
          int k = localConfig.type.get();
          localArrayList.remove(Integer.valueOf(k));
          int m = jdField_a_of_type_AndroidUtilSparseIntArray.get(k, k);
          SLog.a("QQStoryConfigServlet", "receiveAllConfigs|receive type: %d, localConfigId: %d, length: %d", Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(j));
          String str1 = paramIntent.getStringExtra("key_uin");
          String str2 = StoryConfigManager.a(m);
          int n = SharedPreUtils.a(paramQQAppInterface.getApp(), str2, str1);
          String str3 = ConfigServlet.a(localConfig, n, m);
          if (localConfig.content_list.size() > 0) {
            SLog.a("QQStoryConfigServlet", "%d --> %s", Integer.valueOf(m), (String)localConfig.content_list.get(0));
          }
          SLog.a("QQStoryConfigServlet", "%d ---> %s", Integer.valueOf(m), str3);
          paramBoolean = localStoryConfigManager.a(m, paramIntent, localConfig);
          if (paramBoolean) {
            SharedPreUtils.a(paramQQAppInterface.getApp(), str2, str1, localConfig.version.get());
          }
          SLog.b("QQStoryConfigServlet", "receiveAllConfigs|receive type: %d, localConfigId: %d, length: %d, localVersion:%d, newVersion: %d, handled: %b", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(j), Integer.valueOf(n), Integer.valueOf(localConfig.version.get()), Boolean.valueOf(paramBoolean) });
        }
      }
    }
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.w("QQStoryConfigServlet", 2, "receiveAllConfigs|executeSpendTime: " + (l2 - l1));
    }
    paramRespGetConfig = localArrayList.iterator();
    while (paramRespGetConfig.hasNext())
    {
      paramIntent = (Integer)paramRespGetConfig.next();
      if (QLog.isColorLevel()) {
        QLog.w("QQStoryConfigServlet", 2, "receiveAllConfigs|noReceiveType: " + paramIntent + ",length: " + localArrayList.size());
      }
      switch (paramIntent.intValue())
      {
      default: 
        break;
      case 243: 
        ((QQStoryHandler)paramQQAppInterface.a(98)).a(1021, true, null);
      }
    }
  }
  
  public static byte[] a(ConfigurationService.ReqGetConfig paramReqGetConfig)
  {
    paramReqGetConfig = paramReqGetConfig.toByteArray();
    long l = paramReqGetConfig.length;
    byte[] arrayOfByte = new byte[(int)l + 4];
    PkgTools.a(arrayOfByte, 0, 4L + l);
    PkgTools.a(arrayOfByte, 4, paramReqGetConfig, (int)l);
    return arrayOfByte;
  }
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte.length - 4;
    byte[] arrayOfByte = new byte[i];
    PkgTools.a(arrayOfByte, 0, paramArrayOfByte, 4, i);
    return arrayOfByte;
  }
  
  /* Error */
  public void onReceive(Intent paramIntent, com.tencent.qphone.base.remote.FromServiceMsg paramFromServiceMsg)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 430	com/tencent/mobileqq/config/splashlogo/QQStoryConfigServlet:getAppRuntime	()Lmqq/app/AppRuntime;
    //   4: checkcast 68	com/tencent/mobileqq/app/QQAppInterface
    //   7: astore 6
    //   9: aload_2
    //   10: invokevirtual 435	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   13: istore 5
    //   15: getstatic 30	com/tencent/mobileqq/config/splashlogo/QQStoryConfigServlet:jdField_a_of_type_AndroidUtilSparseIntArray	Landroid/util/SparseIntArray;
    //   18: invokevirtual 63	android/util/SparseIntArray:size	()I
    //   21: ifne +10 -> 31
    //   24: aload_0
    //   25: aload_1
    //   26: iconst_0
    //   27: invokestatic 438	com/tencent/biz/qqstory/boundaries/StoryDepends$ConfigServlet:a	(Lmqq/app/MSFServlet;Landroid/content/Intent;Z)V
    //   30: return
    //   31: invokestatic 127	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   34: ifeq +72 -> 106
    //   37: getstatic 30	com/tencent/mobileqq/config/splashlogo/QQStoryConfigServlet:jdField_a_of_type_AndroidUtilSparseIntArray	Landroid/util/SparseIntArray;
    //   40: invokevirtual 63	android/util/SparseIntArray:size	()I
    //   43: istore 4
    //   45: iconst_0
    //   46: istore_3
    //   47: iload_3
    //   48: getstatic 30	com/tencent/mobileqq/config/splashlogo/QQStoryConfigServlet:jdField_a_of_type_AndroidUtilSparseIntArray	Landroid/util/SparseIntArray;
    //   51: invokevirtual 63	android/util/SparseIntArray:size	()I
    //   54: if_icmpge +52 -> 106
    //   57: ldc 74
    //   59: iconst_2
    //   60: new 131	java/lang/StringBuilder
    //   63: dup
    //   64: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   67: ldc_w 440
    //   70: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: getstatic 30	com/tencent/mobileqq/config/splashlogo/QQStoryConfigServlet:jdField_a_of_type_AndroidUtilSparseIntArray	Landroid/util/SparseIntArray;
    //   76: iload_3
    //   77: invokevirtual 83	android/util/SparseIntArray:keyAt	(I)I
    //   80: invokevirtual 141	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   83: ldc 177
    //   85: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: iload 4
    //   90: invokevirtual 141	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   93: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   96: invokestatic 304	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   99: iload_3
    //   100: iconst_1
    //   101: iadd
    //   102: istore_3
    //   103: goto -56 -> 47
    //   106: aload_2
    //   107: invokevirtual 443	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   110: astore 7
    //   112: aload 7
    //   114: ifnull +10 -> 124
    //   117: aload 7
    //   119: arraylength
    //   120: iconst_4
    //   121: if_icmpge +25 -> 146
    //   124: invokestatic 127	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   127: ifeq +12 -> 139
    //   130: ldc 74
    //   132: iconst_2
    //   133: ldc_w 445
    //   136: invokestatic 180	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   139: aload_0
    //   140: aload_1
    //   141: iconst_0
    //   142: invokestatic 438	com/tencent/biz/qqstory/boundaries/StoryDepends$ConfigServlet:a	(Lmqq/app/MSFServlet;Landroid/content/Intent;Z)V
    //   145: return
    //   146: aload_2
    //   147: aload 7
    //   149: invokestatic 447	com/tencent/mobileqq/config/splashlogo/QQStoryConfigServlet:a	([B)[B
    //   152: invokevirtual 450	com/tencent/qphone/base/remote/FromServiceMsg:putWupBuffer	([B)V
    //   155: new 289	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig
    //   158: dup
    //   159: invokespecial 451	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:<init>	()V
    //   162: astore 7
    //   164: aload 7
    //   166: aload_2
    //   167: invokevirtual 443	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   170: invokevirtual 455	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   173: pop
    //   174: aload_0
    //   175: aload 7
    //   177: aload 6
    //   179: aload_1
    //   180: iload 5
    //   182: invokespecial 457	com/tencent/mobileqq/config/splashlogo/QQStoryConfigServlet:a	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig;Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Intent;Z)V
    //   185: aload_0
    //   186: aload_1
    //   187: iconst_1
    //   188: invokestatic 438	com/tencent/biz/qqstory/boundaries/StoryDepends$ConfigServlet:a	(Lmqq/app/MSFServlet;Landroid/content/Intent;Z)V
    //   191: return
    //   192: astore_2
    //   193: invokestatic 127	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   196: ifeq +32 -> 228
    //   199: ldc 74
    //   201: iconst_2
    //   202: new 131	java/lang/StringBuilder
    //   205: dup
    //   206: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   209: ldc_w 459
    //   212: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: aload_2
    //   216: invokevirtual 460	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:toString	()Ljava/lang/String;
    //   219: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   225: invokestatic 180	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   228: aload_2
    //   229: invokevirtual 463	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   232: aload_0
    //   233: aload_1
    //   234: iconst_0
    //   235: invokestatic 438	com/tencent/biz/qqstory/boundaries/StoryDepends$ConfigServlet:a	(Lmqq/app/MSFServlet;Landroid/content/Intent;Z)V
    //   238: return
    //   239: astore_2
    //   240: goto -55 -> 185
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	243	0	this	QQStoryConfigServlet
    //   0	243	1	paramIntent	Intent
    //   0	243	2	paramFromServiceMsg	com.tencent.qphone.base.remote.FromServiceMsg
    //   46	57	3	i	int
    //   43	46	4	j	int
    //   13	168	5	bool	boolean
    //   7	171	6	localQQAppInterface	QQAppInterface
    //   110	66	7	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   164	174	192	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   174	185	239	java/lang/Exception
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
    if (jdField_a_of_type_AndroidUtilSparseIntArray.size() == 0) {
      return;
    }
    if (QLog.isColorLevel())
    {
      int j = jdField_a_of_type_AndroidUtilSparseIntArray.size();
      int i = 0;
      while (i < jdField_a_of_type_AndroidUtilSparseIntArray.size())
      {
        QLog.i("QQStoryConfigServlet", 2, "onSend. cmd: " + jdField_a_of_type_AndroidUtilSparseIntArray.keyAt(i) + ",length: " + j);
        i += 1;
      }
    }
    a(localQQAppInterface, paramIntent, paramPacket);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.splashlogo.QQStoryConfigServlet
 * JD-Core Version:    0.7.0.1
 */