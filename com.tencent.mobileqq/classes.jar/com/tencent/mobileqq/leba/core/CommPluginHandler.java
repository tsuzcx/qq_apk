package com.tencent.mobileqq.leba.core;

import android.content.SharedPreferences;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.leba.ILebaHelperService;
import com.tencent.mobileqq.leba.pb.PluginConfig.BatchGetResourceReq;
import com.tencent.mobileqq.leba.pb.PluginConfig.BatchGetResourceResp;
import com.tencent.mobileqq.leba.pb.PluginConfig.GetResourceReq;
import com.tencent.mobileqq.leba.pb.PluginConfig.GetResourceResp;
import com.tencent.mobileqq.leba.pb.UserDynamicPlugin.ReqGetUserDynamicPlugin;
import com.tencent.mobileqq.leba.pb.UserDynamicPlugin.ReqSetUserDynamicPlugin;
import com.tencent.mobileqq.leba.pb.UserDynamicPlugin.RspSetUserDynamicPlugin;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppSetting;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.BatchSetSettingReqBody;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.BatchSetSettingRspBody;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.RspBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.UdcUinData;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class CommPluginHandler
  extends BusinessHandler
{
  private AppInterface a;
  protected boolean a;
  
  public CommPluginHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
  }
  
  public LebaHelper a(AppInterface paramAppInterface, String paramString)
  {
    if (paramAppInterface == null)
    {
      QLog.e("CommPluginHandler", 1, "getLebaHelper isEmpty appInterface = null");
      return null;
    }
    paramAppInterface = ((ILebaHelperService)paramAppInterface.getRuntimeService(ILebaHelperService.class, "")).getLebaHelper();
    if (paramAppInterface == null)
    {
      QLog.e("CommPluginHandler", 1, "getLebaHelper isEmpty method = " + paramString);
      return null;
    }
    return (LebaHelper)paramAppInterface;
  }
  
  public void a()
  {
    Object localObject = a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "getAllPluginList");
    if (localObject == null) {}
    boolean bool;
    do
    {
      return;
      localObject = ((LebaHelper)localObject).a();
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(localObject);
      a(localArrayList);
      b();
      bool = LebaUtil.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
      QLog.i("CommPluginHandler", 1, "getAllPluginList isNeedReqHasClosedFlag" + bool);
    } while (!bool);
    a(true);
  }
  
  /* Error */
  public void a(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 9
    //   3: iconst_0
    //   4: istore_3
    //   5: iconst_0
    //   6: istore 6
    //   8: iconst_0
    //   9: istore 5
    //   11: new 43	java/lang/StringBuilder
    //   14: dup
    //   15: ldc 101
    //   17: invokespecial 104	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   20: astore 10
    //   22: aload_1
    //   23: ifnull +7 -> 30
    //   26: aload_2
    //   27: ifnonnull +57 -> 84
    //   30: aload 10
    //   32: ldc 106
    //   34: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: pop
    //   38: aload 10
    //   40: ldc 108
    //   42: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: iload 5
    //   47: invokevirtual 90	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   50: pop
    //   51: ldc 110
    //   53: iconst_1
    //   54: aload 10
    //   56: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: invokestatic 93	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   62: aload_0
    //   63: aload_0
    //   64: getfield 15	com/tencent/mobileqq/leba/core/CommPluginHandler:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   67: ldc 112
    //   69: invokevirtual 62	com/tencent/mobileqq/leba/core/CommPluginHandler:a	(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;)Lcom/tencent/mobileqq/leba/core/LebaHelper;
    //   72: astore_1
    //   73: aload_1
    //   74: ifnull +9 -> 83
    //   77: aload_1
    //   78: iload 5
    //   80: invokevirtual 113	com/tencent/mobileqq/leba/core/LebaHelper:a	(Z)V
    //   83: return
    //   84: aload_1
    //   85: invokevirtual 119	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   88: ifne +28 -> 116
    //   91: aload 10
    //   93: aload_1
    //   94: invokevirtual 123	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   97: invokevirtual 126	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   100: ldc 128
    //   102: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: aload_1
    //   106: invokevirtual 131	com/tencent/qphone/base/remote/FromServiceMsg:getRequestSsoSeq	()I
    //   109: invokevirtual 126	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   112: pop
    //   113: goto -75 -> 38
    //   116: new 133	com/tencent/mobileqq/leba/pb/UserDynamicPlugin$RspGetUserDynamicPlugin
    //   119: dup
    //   120: invokespecial 134	com/tencent/mobileqq/leba/pb/UserDynamicPlugin$RspGetUserDynamicPlugin:<init>	()V
    //   123: astore_1
    //   124: aload_1
    //   125: aload_2
    //   126: checkcast 136	[B
    //   129: checkcast 136	[B
    //   132: invokevirtual 140	com/tencent/mobileqq/leba/pb/UserDynamicPlugin$RspGetUserDynamicPlugin:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   135: checkcast 133	com/tencent/mobileqq/leba/pb/UserDynamicPlugin$RspGetUserDynamicPlugin
    //   138: astore_2
    //   139: aload_2
    //   140: getfield 144	com/tencent/mobileqq/leba/pb/UserDynamicPlugin$RspGetUserDynamicPlugin:ret	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   143: invokevirtual 149	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   146: ifeq +180 -> 326
    //   149: aload_2
    //   150: getfield 144	com/tencent/mobileqq/leba/pb/UserDynamicPlugin$RspGetUserDynamicPlugin:ret	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   153: invokevirtual 152	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   156: invokestatic 158	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   159: astore_1
    //   160: aload_1
    //   161: ifnull +123 -> 284
    //   164: aload_1
    //   165: invokevirtual 161	java/lang/Integer:intValue	()I
    //   168: istore 4
    //   170: iload 4
    //   172: ifne +112 -> 284
    //   175: lconst_0
    //   176: lstore 7
    //   178: aload 9
    //   180: astore_1
    //   181: aload_2
    //   182: getfield 165	com/tencent/mobileqq/leba/pb/UserDynamicPlugin$RspGetUserDynamicPlugin:plugin_id	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   185: invokevirtual 168	com/tencent/mobileqq/pb/PBRepeatField:has	()Z
    //   188: ifeq +11 -> 199
    //   191: aload_2
    //   192: getfield 165	com/tencent/mobileqq/leba/pb/UserDynamicPlugin$RspGetUserDynamicPlugin:plugin_id	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   195: invokevirtual 171	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   198: astore_1
    //   199: aload_2
    //   200: getfield 174	com/tencent/mobileqq/leba/pb/UserDynamicPlugin$RspGetUserDynamicPlugin:last_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   203: invokevirtual 149	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   206: ifeq +13 -> 219
    //   209: aload_2
    //   210: getfield 174	com/tencent/mobileqq/leba/pb/UserDynamicPlugin$RspGetUserDynamicPlugin:last_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   213: invokevirtual 152	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   216: i2l
    //   217: lstore 7
    //   219: aload_2
    //   220: getfield 177	com/tencent/mobileqq/leba/pb/UserDynamicPlugin$RspGetUserDynamicPlugin:plugin_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   223: invokevirtual 149	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   226: ifeq +11 -> 237
    //   229: aload_2
    //   230: getfield 177	com/tencent/mobileqq/leba/pb/UserDynamicPlugin$RspGetUserDynamicPlugin:plugin_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   233: invokevirtual 152	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   236: istore_3
    //   237: aload_0
    //   238: aload_1
    //   239: lload 7
    //   241: iload_3
    //   242: aload 10
    //   244: invokevirtual 180	com/tencent/mobileqq/leba/core/CommPluginHandler:a	(Ljava/util/List;JILjava/lang/StringBuilder;)V
    //   247: aload 10
    //   249: ldc 182
    //   251: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: aload_1
    //   255: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   258: ldc 187
    //   260: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: lload 7
    //   265: invokevirtual 190	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   268: ldc 192
    //   270: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: iload_3
    //   274: invokevirtual 126	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   277: pop
    //   278: iconst_1
    //   279: istore 5
    //   281: goto -243 -> 38
    //   284: aload 10
    //   286: ldc 194
    //   288: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: aload_1
    //   292: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   295: pop
    //   296: iconst_0
    //   297: istore 5
    //   299: goto -18 -> 281
    //   302: astore_1
    //   303: iload 6
    //   305: istore 5
    //   307: ldc 110
    //   309: iconst_1
    //   310: ldc 112
    //   312: aload_1
    //   313: invokestatic 197	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   316: goto -278 -> 38
    //   319: astore_1
    //   320: iconst_1
    //   321: istore 5
    //   323: goto -16 -> 307
    //   326: aconst_null
    //   327: astore_1
    //   328: goto -168 -> 160
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	331	0	this	CommPluginHandler
    //   0	331	1	paramFromServiceMsg	FromServiceMsg
    //   0	331	2	paramObject	Object
    //   4	270	3	i	int
    //   168	3	4	j	int
    //   9	313	5	bool1	boolean
    //   6	298	6	bool2	boolean
    //   176	88	7	l	long
    //   1	178	9	localObject	Object
    //   20	265	10	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   124	160	302	java/lang/Exception
    //   164	170	302	java/lang/Exception
    //   284	296	302	java/lang/Exception
    //   181	199	319	java/lang/Exception
    //   199	219	319	java/lang/Exception
    //   219	237	319	java/lang/Exception
    //   237	278	319	java/lang/Exception
  }
  
  protected void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CommPluginHandler", 2, "handleBatchGetPluginList");
    }
    LebaHelper localLebaHelper = a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "handleBatchGetPluginList");
    Object localObject = "";
    boolean bool2;
    int i;
    label92:
    boolean bool1;
    if ((paramToServiceMsg != null) && (paramFromServiceMsg != null) && (paramObject != null))
    {
      bool2 = true;
      if (bool2) {
        paramToServiceMsg = new PluginConfig.BatchGetResourceResp();
      }
    }
    else
    {
      try
      {
        paramObject = (PluginConfig.BatchGetResourceResp)paramToServiceMsg.mergeFrom((byte[])paramObject);
        if (!paramObject.errcode.has()) {
          break label408;
        }
        i = paramObject.errcode.get();
        if (i != 0) {
          break label414;
        }
        bool1 = true;
        label100:
        paramFromServiceMsg = (FromServiceMsg)localObject;
        try
        {
          if (!paramObject.errmsg.has()) {
            break label420;
          }
          paramFromServiceMsg = (FromServiceMsg)localObject;
          paramToServiceMsg = paramObject.errmsg.get();
          label124:
          if (!bool1) {
            break label459;
          }
          paramFromServiceMsg = paramToServiceMsg;
          if (!paramObject.resp_list.has()) {
            break label474;
          }
          paramFromServiceMsg = paramToServiceMsg;
          paramObject = paramObject.resp_list.get();
          label151:
          if (paramObject == null) {
            break label426;
          }
          paramFromServiceMsg = paramToServiceMsg;
          if (paramObject.isEmpty()) {
            break label426;
          }
          paramFromServiceMsg = paramToServiceMsg;
          paramObject = paramObject.iterator();
          for (;;)
          {
            paramFromServiceMsg = paramToServiceMsg;
            if (!paramObject.hasNext()) {
              break;
            }
            paramFromServiceMsg = paramToServiceMsg;
            localObject = (PluginConfig.GetResourceResp)paramObject.next();
            if (localObject != null)
            {
              paramFromServiceMsg = paramToServiceMsg;
              if (((PluginConfig.GetResourceResp)localObject).plugin_type.get() != 4000)
              {
                paramFromServiceMsg = paramToServiceMsg;
                if (((PluginConfig.GetResourceResp)localObject).plugin_type.get() != 4026) {}
              }
              else if (localLebaHelper != null)
              {
                paramFromServiceMsg = paramToServiceMsg;
                localLebaHelper.a(true, (PluginConfig.GetResourceResp)localObject);
              }
            }
          }
          QLog.d("CommPluginHandler", 1, "handleBatchGetPluginList exp:" + paramFromServiceMsg.toString());
        }
        catch (Exception paramObject)
        {
          paramToServiceMsg = paramFromServiceMsg;
          paramFromServiceMsg = paramObject;
        }
      }
      catch (Exception paramFromServiceMsg)
      {
        for (;;)
        {
          i = -1;
          paramToServiceMsg = "";
        }
      }
      bool1 = false;
    }
    label408:
    label414:
    label420:
    label426:
    label459:
    label474:
    label479:
    for (;;)
    {
      if ((bool1) && (bool2)) {}
      for (boolean bool3 = true;; bool3 = false)
      {
        if ((!bool3) && (localLebaHelper != null)) {
          localLebaHelper.a(false, null);
        }
        QLog.d("CommPluginHandler", 1, new Object[] { "handleBatchGetPluginList finalResult:", Boolean.valueOf(bool3), ",ssoSuc=", Boolean.valueOf(bool2), ",busiSuc=", Boolean.valueOf(bool1), ",busiErrCode=", Integer.valueOf(i), ",errMsg=", paramToServiceMsg });
        return;
        bool2 = false;
        break;
        i = -1;
        break label92;
        bool1 = false;
        break label100;
        paramToServiceMsg = "";
        break label124;
        bool1 = false;
        paramFromServiceMsg = paramToServiceMsg;
        QLog.d("CommPluginHandler", 1, "handleBatchGetPluginList respInfoList is null");
        break label479;
      }
      break label479;
      i = -1;
      bool1 = false;
      paramToServiceMsg = (ToServiceMsg)localObject;
      continue;
      paramObject = null;
      break label151;
    }
  }
  
  public void a(ArrayList<BusinessInfoCheckUpdate.AppSetting> paramArrayList)
  {
    if (paramArrayList == null) {
      return;
    }
    BusinessInfoCheckUpdate.BatchSetSettingReqBody localBatchSetSettingReqBody = new BusinessInfoCheckUpdate.BatchSetSettingReqBody();
    StringBuilder localStringBuilder = new StringBuilder("batchClosePlugin ");
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface == null) {
      localStringBuilder.append(",app == null");
    }
    for (;;)
    {
      localBatchSetSettingReqBody.uiClientPlatID.set(109);
      localBatchSetSettingReqBody.sClientVer.set("8.5.5.5105");
      localBatchSetSettingReqBody.rptSetting.addAll(paramArrayList);
      paramArrayList = createToServiceMsg("RedTouchSvc.BatchSetSetting");
      paramArrayList.putWupBuffer(localBatchSetSettingReqBody.toByteArray());
      sendPbReq(paramArrayList);
      QLog.i("leba_study", 1, localStringBuilder.toString());
      return;
      String str = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin();
      try
      {
        localBatchSetSettingReqBody.uiUin.set(Long.parseLong(str));
      }
      catch (Exception localException)
      {
        QLog.e("CommPluginHandler", 1, localException, new Object[0]);
      }
    }
  }
  
  protected void a(List<PluginConfig.GetResourceReq> paramList)
  {
    QLog.i("CommPluginHandler", 1, "batchGetPluginList");
    if ((paramList == null) || (paramList.isEmpty()))
    {
      QLog.i("CommPluginHandler", 1, "batchGetPluginList return for req_list is empty");
      return;
    }
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), "PluginConfig.dynamic_plugin");
    PluginConfig.BatchGetResourceReq localBatchGetResourceReq = new PluginConfig.BatchGetResourceReq();
    localBatchGetResourceReq.req_list.set(paramList);
    localToServiceMsg.putWupBuffer(localBatchGetResourceReq.toByteArray());
    localToServiceMsg.extraData.putString("uin", this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
    sendPbReq(localToServiceMsg);
  }
  
  public void a(List<Integer> paramList, long paramLong, int paramInt)
  {
    String str = "";
    Object localObject = new StringBuilder("setPluginUserSort data= ").append(paramList).append(",time=").append(paramLong).append(",type=").append(paramInt);
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface == null) {
      ((StringBuilder)localObject).append(" app == null");
    }
    for (;;)
    {
      QLog.i("leba_sort", 1, ((StringBuilder)localObject).toString());
      localObject = new ToServiceMsg("mobileqq.service", str, "DynamicPluginSvc.SetList");
      UserDynamicPlugin.ReqSetUserDynamicPlugin localReqSetUserDynamicPlugin = new UserDynamicPlugin.ReqSetUserDynamicPlugin();
      localReqSetUserDynamicPlugin.plugin_id.set(paramList);
      localReqSetUserDynamicPlugin.last_time.set((int)paramLong);
      localReqSetUserDynamicPlugin.plugin_type.set(paramInt);
      ((ToServiceMsg)localObject).putWupBuffer(localReqSetUserDynamicPlugin.toByteArray());
      ((ToServiceMsg)localObject).extraData.putString("uin", str);
      sendPbReq((ToServiceMsg)localObject);
      return;
      str = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin();
    }
  }
  
  public void a(List<Integer> paramList, long paramLong, int paramInt, StringBuilder paramStringBuilder)
  {
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface == null) {
      paramStringBuilder.append(" app == null");
    }
    long l;
    do
    {
      return;
      l = LebaUtil.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramInt);
      paramStringBuilder.append(" localTime = ").append(l);
      if (paramLong >= l)
      {
        SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getPreferences();
        Object localObject = paramList;
        if (paramList == null) {
          localObject = new ArrayList();
        }
        LebaUtil.a(localSharedPreferences, (List)localObject, Long.valueOf(paramLong), paramInt);
        paramStringBuilder.append(" saveUserSortInfo");
        return;
      }
      paramList = LebaUtil.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramInt);
    } while ((paramList == null) || (paramList.isEmpty()));
    a(paramList, l, paramInt);
    paramStringBuilder.append(" setPluginUserSort, localSort = ").append(paramList);
  }
  
  public void a(boolean paramBoolean)
  {
    long l1 = 0L;
    Object localObject1 = new StringBuilder("setHasClosePluginFlag hasClose").append(paramBoolean);
    Object localObject2;
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface == null)
    {
      ((StringBuilder)localObject1).append(" app == null");
      QLog.i("leba_study", 1, ((StringBuilder)localObject1).toString());
      localObject1 = new oidb_sso.OIDBSSOPkg();
      ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(1279);
      ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(9);
      localObject2 = ByteBuffer.allocate(13);
      if (!paramBoolean) {
        break label206;
      }
    }
    label206:
    for (short s = 1;; s = 0)
    {
      for (;;)
      {
        ((ByteBuffer)localObject2).putInt(Utils.a(l1)).put((byte)0).putShort((short)1).putShort((short)-23054).putShort((short)2).putShort(s);
        ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject2).array()));
        localObject2 = createToServiceMsg("OidbSvc.0x4ff_42482");
        ((ToServiceMsg)localObject2).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
        ((ToServiceMsg)localObject2).setTimeout(30000L);
        sendPbReq((ToServiceMsg)localObject2);
        return;
        try
        {
          long l2 = Long.parseLong(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
          l1 = l2;
        }
        catch (Exception localException)
        {
          QLog.i("leba_study", 1, "setHasClosePluginFlag", localException);
        }
      }
      break;
    }
  }
  
  public boolean a(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool = false;
    StringBuilder localStringBuilder = new StringBuilder("handleSetPluginUserSort ");
    if ((paramFromServiceMsg == null) || (paramObject == null)) {
      localStringBuilder.append("res == null || data == null");
    }
    for (;;)
    {
      localStringBuilder.append(", isSuc=").append(bool);
      QLog.i("leba_sort", 1, localStringBuilder.toString());
      return bool;
      if (!paramFromServiceMsg.isSuccess()) {
        localStringBuilder.append(paramFromServiceMsg.getResultCode()).append("|").append(paramFromServiceMsg.getRequestSsoSeq());
      } else {
        for (paramFromServiceMsg = new UserDynamicPlugin.RspSetUserDynamicPlugin();; paramFromServiceMsg = null)
        {
          try
          {
            paramFromServiceMsg = (UserDynamicPlugin.RspSetUserDynamicPlugin)paramFromServiceMsg.mergeFrom((byte[])paramObject);
            if (!paramFromServiceMsg.ret.has()) {
              continue;
            }
            paramFromServiceMsg = Integer.valueOf(paramFromServiceMsg.ret.get());
            if ((paramFromServiceMsg != null) && (paramFromServiceMsg.intValue() == 0))
            {
              bool = true;
            }
            else
            {
              localStringBuilder.append("ret = ").append(paramFromServiceMsg);
              bool = false;
            }
          }
          catch (Exception paramFromServiceMsg)
          {
            QLog.i("leba_sort", 1, "handleGetPluginUserSort", paramFromServiceMsg);
          }
          break;
        }
      }
    }
  }
  
  public void b()
  {
    Object localObject2 = new StringBuilder("getPluginUserSort");
    Object localObject1 = (IStudyModeManager)QRoute.api(IStudyModeManager.class);
    boolean bool;
    int i;
    if (localObject1 != null)
    {
      bool = ((IStudyModeManager)localObject1).getStudyModeSwitch();
      if (!bool) {
        break label170;
      }
      i = 4026;
      label41:
      localObject1 = "";
      ((StringBuilder)localObject2).append(",pluginType = ").append(i);
      if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) {
        break label177;
      }
      ((StringBuilder)localObject2).append(",app == null");
    }
    for (;;)
    {
      QLog.i("leba_sort", 1, ((StringBuilder)localObject2).toString());
      localObject2 = new ToServiceMsg("mobileqq.service", (String)localObject1, "DynamicPluginSvc.GetList");
      UserDynamicPlugin.ReqGetUserDynamicPlugin localReqGetUserDynamicPlugin = new UserDynamicPlugin.ReqGetUserDynamicPlugin();
      localReqGetUserDynamicPlugin.platform.set(2);
      localReqGetUserDynamicPlugin.plugin_type.set(i);
      ((ToServiceMsg)localObject2).putWupBuffer(localReqGetUserDynamicPlugin.toByteArray());
      ((ToServiceMsg)localObject2).extraData.putString("uin", (String)localObject1);
      sendPbReq((ToServiceMsg)localObject2);
      return;
      ((StringBuilder)localObject2).append(",studyModeManager == null");
      bool = false;
      break;
      label170:
      i = 4000;
      break label41;
      label177:
      localObject1 = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin();
    }
  }
  
  public boolean b(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    StringBuilder localStringBuilder = new StringBuilder("handleGetHasClosePluginFlag ");
    if ((paramFromServiceMsg == null) || (paramObject == null))
    {
      localStringBuilder.append("res == null || data == null");
      QLog.i("leba_study", 1, localStringBuilder.toString());
      return false;
    }
    localStringBuilder.append("resCode = ").append(paramFromServiceMsg.getResultCode()).append(",resSso = ").append(paramFromServiceMsg.getRequestSsoSeq());
    if (!paramFromServiceMsg.isSuccess())
    {
      localStringBuilder.append("|res failed");
      QLog.i("leba_study", 1, localStringBuilder.toString());
      return false;
    }
    for (;;)
    {
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
        if (paramFromServiceMsg.uint32_result.get() == 0)
        {
          i = 1;
          paramObject = paramFromServiceMsg.str_error_msg.get();
          localStringBuilder.append(",ssoResult = ").append(paramFromServiceMsg.uint32_result.get()).append(",resError = ").append(paramObject);
          if ((i == 0) || (!paramFromServiceMsg.bytes_bodybuffer.has()) || (paramFromServiceMsg.bytes_bodybuffer.get() == null))
          {
            localStringBuilder.append(",sso failed");
            QLog.i("leba_study", 1, localStringBuilder.toString());
            return false;
          }
          paramObject = new oidb_0x5eb.RspBody();
          paramObject.mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
          if (paramObject.rpt_msg_uin_data.size() <= 0)
          {
            localStringBuilder.append(",sso failed rpt_msg_uin_data erroe");
            QLog.i("leba_study", 1, localStringBuilder.toString());
            return false;
          }
          if (this.jdField_a_of_type_ComTencentCommonAppAppInterface == null)
          {
            localStringBuilder.append(",sso failed app == null");
            QLog.i("leba_study", 1, localStringBuilder.toString());
            return false;
          }
          i = ((oidb_0x5eb.UdcUinData)paramObject.rpt_msg_uin_data.get(0)).uint32_has_close_leba_youth_mode_plugin.get();
          localStringBuilder.append(",sso success");
          localStringBuilder.append(",flag=").append(i);
          boolean bool1;
          if (i == 1)
          {
            bool1 = true;
            paramFromServiceMsg = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
            if (bool1)
            {
              i = 2;
              LebaUtil.b(paramFromServiceMsg, i);
              boolean bool2 = LebaUtil.a(LebaUtil.d(this.jdField_a_of_type_ComTencentCommonAppAppInterface));
              localStringBuilder.append(",hasClose=").append(bool1).append(",isStudyModel=").append(bool2);
              if ((!bool1) && (bool2))
              {
                paramFromServiceMsg = a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "handleGetHasClosePluginFlag");
                if (paramFromServiceMsg != null) {
                  paramFromServiceMsg.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
                }
              }
              QLog.i("leba_study", 1, localStringBuilder.toString());
              return true;
            }
          }
          else
          {
            bool1 = false;
            continue;
          }
          i = 1;
          continue;
        }
        int i = 0;
      }
      catch (Exception paramFromServiceMsg)
      {
        QLog.i("leba_study", 1, "handleGetPluginUserSort", paramFromServiceMsg);
        return false;
      }
    }
  }
  
  public void c()
  {
    Object localObject = new oidb_0x5eb.ReqBody();
    String str = "";
    StringBuilder localStringBuilder = new StringBuilder("getHasClosePluginFlag");
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface == null) {
      localStringBuilder.append(" app == null");
    }
    for (;;)
    {
      ((oidb_0x5eb.ReqBody)localObject).uint32_has_close_leba_youth_mode_plugin.set(1);
      QLog.i("leba_study", 1, localStringBuilder.toString());
      localObject = makeOIDBPkg("OidbSvc.0x5eb_42482", 1515, 22, ((oidb_0x5eb.ReqBody)localObject).toByteArray());
      ((ToServiceMsg)localObject).addAttribute("uin", str);
      sendPbReq((ToServiceMsg)localObject);
      return;
      str = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin();
      try
      {
        long l = Long.parseLong(str);
        ((oidb_0x5eb.ReqBody)localObject).rpt_uint64_uins.add(Long.valueOf(l));
      }
      catch (Exception localException)
      {
        QLog.i("leba_study", 1, "getHasClosePluginFlag", localException);
      }
    }
  }
  
  public boolean c(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    StringBuilder localStringBuilder = new StringBuilder("handleSetHasClosePluginFlag ");
    if ((paramFromServiceMsg == null) || (paramObject == null))
    {
      localStringBuilder.append("res == null || data == null");
      QLog.i("leba_study", 1, localStringBuilder.toString());
      return false;
    }
    localStringBuilder.append(",resCode = ").append(paramFromServiceMsg.getResultCode()).append(",resSso = ").append(paramFromServiceMsg.getRequestSsoSeq());
    if (!paramFromServiceMsg.isSuccess())
    {
      localStringBuilder.append(",res failed");
      QLog.i("leba_study", 1, localStringBuilder.toString());
      return false;
    }
    for (;;)
    {
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
        if (paramFromServiceMsg.uint32_result.get() == 0)
        {
          i = 1;
          paramObject = paramFromServiceMsg.str_error_msg.get();
          localStringBuilder.append("ssoResult = ").append(paramFromServiceMsg.uint32_result.get()).append(",resError = ").append(paramObject);
          if ((i == 0) || (!paramFromServiceMsg.bytes_bodybuffer.has()) || (paramFromServiceMsg.bytes_bodybuffer.get() == null))
          {
            localStringBuilder.append(",sso failed");
            QLog.i("leba_study", 1, localStringBuilder.toString());
            return false;
          }
          LebaUtil.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, false);
          localStringBuilder.append(",sso success");
          QLog.i("leba_study", 1, localStringBuilder.toString());
          return true;
        }
      }
      catch (Exception paramFromServiceMsg)
      {
        QLog.i("leba_study", 1, "handleSetHasClosePluginFlag", paramFromServiceMsg);
        return false;
      }
      int i = 0;
    }
  }
  
  public boolean d(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    StringBuilder localStringBuilder = new StringBuilder("handleBatchClosePlugin ");
    if ((paramFromServiceMsg == null) || (paramObject == null))
    {
      localStringBuilder.append("res == null || data == null");
      QLog.i("leba_study", 1, localStringBuilder.toString());
      return false;
    }
    localStringBuilder.append(",resCode = ").append(paramFromServiceMsg.getResultCode());
    if (!paramFromServiceMsg.isSuccess())
    {
      localStringBuilder.append(",res failed");
      QLog.i("leba_study", 1, localStringBuilder.toString());
      return false;
    }
    try
    {
      paramFromServiceMsg = (BusinessInfoCheckUpdate.BatchSetSettingRspBody)new BusinessInfoCheckUpdate.BatchSetSettingRspBody().mergeFrom((byte[])paramObject);
      int i = paramFromServiceMsg.iResult.get();
      paramFromServiceMsg = paramFromServiceMsg.sErrMsg.get();
      localStringBuilder.append(",resultCode = ").append(i).append(",resError = ").append(paramFromServiceMsg);
      if (i != 0)
      {
        localStringBuilder.append(",rspBody failed");
        QLog.i("leba_study", 1, localStringBuilder.toString());
        return false;
      }
      paramFromServiceMsg = a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "handleBatchClosePlugin");
      if (paramFromServiceMsg != null) {
        paramFromServiceMsg.c(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
      }
      localStringBuilder.append(",rspBody success");
      QLog.i("leba_study", 1, localStringBuilder.toString());
      return true;
    }
    catch (Exception paramFromServiceMsg)
    {
      QLog.i("leba_study", 1, "handleBatchClosePlugin", paramFromServiceMsg);
    }
    return false;
  }
  
  public Set<String> getCommandList()
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("PluginConfig.dynamic_plugin");
      this.allowCmdSet.add("DynamicPluginSvc.GetList");
      this.allowCmdSet.add("DynamicPluginSvc.SetList");
      this.allowCmdSet.add("OidbSvc.0x5eb_42482");
      this.allowCmdSet.add("OidbSvc.0x4ff_42482");
      this.allowCmdSet.add("RedTouchSvc.BatchSetSetting");
    }
    return this.allowCmdSet;
  }
  
  public Class<? extends BusinessObserver> observerClass()
  {
    return null;
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_Boolean = true;
    super.onDestroy();
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null) || (msgCmdFilter(paramFromServiceMsg.getServiceCmd()))) {
      QLog.d("CommPluginHandler", 1, "req or res is null");
    }
    String str;
    do
    {
      return;
      str = paramFromServiceMsg.getServiceCmd();
      if ("PluginConfig.dynamic_plugin".equals(str))
      {
        a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("DynamicPluginSvc.GetList".equals(str))
      {
        a(paramFromServiceMsg, paramObject);
        return;
      }
      if ("DynamicPluginSvc.SetList".equals(str))
      {
        a(paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x5eb_42482".equals(str))
      {
        b(paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x4ff_42482".equals(str))
      {
        c(paramFromServiceMsg, paramObject);
        return;
      }
    } while (!"RedTouchSvc.BatchSetSetting".equals(str));
    d(paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.core.CommPluginHandler
 * JD-Core Version:    0.7.0.1
 */