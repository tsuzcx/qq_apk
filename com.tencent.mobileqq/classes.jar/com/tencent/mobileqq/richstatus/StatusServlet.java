package com.tencent.mobileqq.richstatus;

import PersonalState.BusiReqHead;
import PersonalState.ReqGetHotState;
import PersonalState.ReqGetSameStateList;
import PersonalState.stRishState;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.nearby.api.ILbsUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.pb.signature.SigActPb.Platform;
import com.tencent.pb.signature.SigActPb.ReqBody;
import com.tencent.pb.signature.SigActPb.RspBody;
import com.tencent.pb.signature.SigActPb.SigauthReq;
import com.tencent.pb.signature.SigActPb.SigauthRsp;
import com.tencent.pb.signature.SigActPb.SigauthRsp.TipsInfo;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;
import mqq.app.Packet;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class StatusServlet
  extends MSFServlet
{
  private void a(Bundle paramBundle, SigActPb.RspBody paramRspBody, String paramString)
  {
    if (paramRspBody.auth_rsp.tips_info.has())
    {
      SigActPb.SigauthRsp.TipsInfo localTipsInfo = new SigActPb.SigauthRsp.TipsInfo();
      localTipsInfo.mergeFrom(((SigActPb.SigauthRsp.TipsInfo)paramRspBody.auth_rsp.tips_info.get()).toByteArray());
      boolean bool = localTipsInfo.valid.get();
      if (QLog.isColorLevel())
      {
        paramRspBody = new StringBuilder();
        paramRspBody.append("CMD_RICH_STATUS_AUTH ret = ");
        paramRspBody.append(localTipsInfo.ret.get());
        paramRspBody.append(" valid = ");
        paramRspBody.append(bool);
        QLog.d("Signature", 2, paramRspBody.toString());
      }
      paramBundle.putBoolean("valid", bool);
      if (bool)
      {
        paramBundle.putInt("ret", localTipsInfo.ret.get());
        paramBundle.putInt("type", localTipsInfo.type.get());
        paramBundle.putString("titleWording", localTipsInfo.title_wording.get());
        paramBundle.putString("wording", localTipsInfo.wording.get());
        paramBundle.putString("rightBtnWording", localTipsInfo.right_btn_wording.get());
        paramBundle.putString("leftBtnWording", localTipsInfo.left_btn_wording.get());
        paramBundle.putString("vipType", localTipsInfo.vip_type.get());
        paramBundle.putInt("vipMonth", localTipsInfo.vip_month.get());
        paramBundle.putString("url", localTipsInfo.url.get());
      }
      if (QLog.isColorLevel())
      {
        paramRspBody = new StringBuilder();
        paramRspBody.append("CMD_RICH_STATUS_AUTH parseSigAuthTipsInfo ");
        paramRspBody.append(paramString);
        paramRspBody.append(" data=");
        paramRspBody.append(paramBundle);
        QLog.i("StatusServlet", 2, paramRspBody.toString());
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.richstatus.shuo", 2, "getSyncShuoShuo");
    }
    NewIntent localNewIntent = new NewIntent(paramQQAppInterface.getApp(), StatusServlet.class);
    localNewIntent.putExtra("k_cmd", 1);
    localNewIntent.putExtra("k_uin", paramQQAppInterface.getCurrentAccountUin());
    paramQQAppInterface.startServlet(localNewIntent);
  }
  
  static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    NewIntent localNewIntent = new NewIntent(paramQQAppInterface.getApp(), StatusServlet.class);
    localNewIntent.putExtra("k_cmd", 2);
    localNewIntent.putExtra("k_uin", paramQQAppInterface.getCurrentAccountUin());
    localNewIntent.putExtra("k_sync_ss", paramBoolean);
    paramQQAppInterface.startServlet(localNewIntent);
  }
  
  private byte[] a(List<byte[]> paramList, byte paramByte)
  {
    Object localObject1 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(1359);
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(0);
    Object localObject2 = paramList.iterator();
    int i = 7;
    byte[] arrayOfByte;
    while (((Iterator)localObject2).hasNext())
    {
      arrayOfByte = (byte[])((Iterator)localObject2).next();
      if (arrayOfByte != null) {
        i = i + 2 + arrayOfByte.length + 4;
      }
    }
    localObject2 = ByteBuffer.allocate(i);
    ((ByteBuffer)localObject2).putInt(0);
    ((ByteBuffer)localObject2).put(paramByte);
    ((ByteBuffer)localObject2).putShort((short)paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      arrayOfByte = (byte[])paramList.next();
      if (arrayOfByte != null)
      {
        ((ByteBuffer)localObject2).putShort((short)arrayOfByte.length);
        ((ByteBuffer)localObject2).put(arrayOfByte);
        ((ByteBuffer)localObject2).putInt(0);
      }
    }
    ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject2).array()));
    paramList = ((oidb_sso.OIDBSSOPkg)localObject1).toByteArray();
    localObject1 = ByteBuffer.allocate(paramList.length + 4);
    ((ByteBuffer)localObject1).putInt(paramList.length + 4);
    ((ByteBuffer)localObject1).put(paramList);
    return ((ByteBuffer)localObject1).array();
  }
  
  private byte[] a(byte[] paramArrayOfByte)
  {
    Object localObject = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_command.set(1295);
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_service_type.set(29);
    ByteBuffer localByteBuffer = ByteBuffer.allocate(paramArrayOfByte.length + 2);
    localByteBuffer.put((byte)0).put((byte)paramArrayOfByte.length).put(paramArrayOfByte);
    ((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.set(ByteStringMicro.copyFrom(localByteBuffer.array()));
    paramArrayOfByte = ((oidb_sso.OIDBSSOPkg)localObject).toByteArray();
    localObject = ByteBuffer.allocate(paramArrayOfByte.length + 4);
    ((ByteBuffer)localObject).putInt(paramArrayOfByte.length + 4);
    ((ByteBuffer)localObject).put(paramArrayOfByte);
    return ((ByteBuffer)localObject).array();
  }
  
  static PersonalState.LBSInfo b(QQAppInterface paramQQAppInterface)
  {
    ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).reqRawLbsData(60000L, StatusServlet.class.getSimpleName());
    Object localObject1 = ((ILbsUtils)QRoute.api(ILbsUtils.class)).getRawLbsInfo();
    if (localObject1 != null)
    {
      paramQQAppInterface = ((NearbyGroup.LBSInfo)localObject1).stGps;
      paramQQAppInterface = new PersonalState.GPS(paramQQAppInterface.iLat, paramQQAppInterface.iLon, paramQQAppInterface.iAlt, paramQQAppInterface.eType);
      ArrayList localArrayList = new ArrayList();
      Object localObject2 = ((NearbyGroup.LBSInfo)localObject1).vWifis.iterator();
      Object localObject3;
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (NearbyGroup.Wifi)((Iterator)localObject2).next();
        localArrayList.add(new PersonalState.Wifi(((NearbyGroup.Wifi)localObject3).lMac, ((NearbyGroup.Wifi)localObject3).shRssi));
      }
      localObject2 = new ArrayList();
      localObject1 = ((NearbyGroup.LBSInfo)localObject1).vCells.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (NearbyGroup.Cell)((Iterator)localObject1).next();
        ((ArrayList)localObject2).add(new PersonalState.Cell(((NearbyGroup.Cell)localObject3).shMcc, ((NearbyGroup.Cell)localObject3).shMnc, ((NearbyGroup.Cell)localObject3).iLac, ((NearbyGroup.Cell)localObject3).iCellId, ((NearbyGroup.Cell)localObject3).shRssi));
      }
      return new PersonalState.LBSInfo(paramQQAppInterface, localArrayList, (ArrayList)localObject2);
    }
    return null;
  }
  
  byte[] a(long paramLong, int paramInt1, int paramInt2)
  {
    Object localObject = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_command.set(1343);
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_service_type.set(2);
    ByteBuffer localByteBuffer = ByteBuffer.allocate(27);
    localByteBuffer.putLong(paramLong).put((byte)2).putInt(paramInt1).putInt(paramInt2).putInt(0).putInt(0).putShort((short)6);
    ((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.set(ByteStringMicro.copyFrom(localByteBuffer.array()));
    localObject = ((oidb_sso.OIDBSSOPkg)localObject).toByteArray();
    localByteBuffer = ByteBuffer.allocate(localObject.length + 4);
    localByteBuffer.putInt(localObject.length + 4);
    localByteBuffer.put((byte[])localObject);
    return localByteBuffer.array();
  }
  
  byte[] a(boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    Object localObject = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_command.set(1301);
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_service_type.set(2);
    ByteBuffer localByteBuffer = ByteBuffer.allocate(11);
    localByteBuffer.put((byte)2).putInt(293615363).put((byte)paramBoolean1);
    localByteBuffer.put((byte)paramBoolean2).putInt((int)paramLong);
    ((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.set(ByteStringMicro.copyFrom(localByteBuffer.array()));
    localObject = ((oidb_sso.OIDBSSOPkg)localObject).toByteArray();
    localByteBuffer = ByteBuffer.allocate(localObject.length + 4);
    localByteBuffer.putInt(localObject.length + 4);
    localByteBuffer.put((byte[])localObject);
    return localByteBuffer.array();
  }
  
  /* Error */
  public void onReceive(Intent paramIntent, com.tencent.qphone.base.remote.FromServiceMsg paramFromServiceMsg)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 183
    //   3: iconst_0
    //   4: invokevirtual 406	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   7: istore 4
    //   9: iload 4
    //   11: istore_3
    //   12: aload_2
    //   13: invokevirtual 411	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   16: istore 10
    //   18: new 94	android/os/Bundle
    //   21: dup
    //   22: invokespecial 412	android/os/Bundle:<init>	()V
    //   25: astore 17
    //   27: aload_0
    //   28: invokevirtual 416	com/tencent/mobileqq/richstatus/StatusServlet:getAppRuntime	()Lmqq/app/AppRuntime;
    //   31: getstatic 421	com/tencent/mobileqq/app/QQManagerFactory:STATUS_MANAGER	I
    //   34: invokevirtual 427	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   37: checkcast 429	com/tencent/mobileqq/richstatus/StatusManager
    //   40: astore 18
    //   42: aload 18
    //   44: ifnonnull +2334 -> 2378
    //   47: iload_3
    //   48: bipush 7
    //   50: if_icmpne +338 -> 388
    //   53: iload 10
    //   55: ifeq +288 -> 343
    //   58: new 208	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   61: dup
    //   62: invokespecial 209	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   65: astore 18
    //   67: aload 18
    //   69: aload_2
    //   70: invokevirtual 432	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   73: invokestatic 436	com/tencent/mobileqq/utils/WupUtil:b	([B)[B
    //   76: invokevirtual 437	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   79: checkcast 208	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   82: astore 18
    //   84: iload 10
    //   86: istore 11
    //   88: aload 18
    //   90: ifnull +282 -> 372
    //   93: iload 10
    //   95: istore 11
    //   97: aload 18
    //   99: getfield 440	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   102: invokevirtual 441	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   105: ifeq +267 -> 372
    //   108: aload 18
    //   110: getfield 440	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   113: invokevirtual 111	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   116: istore 4
    //   118: iload 4
    //   120: ifne +122 -> 242
    //   123: aload 18
    //   125: getfield 262	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   128: invokevirtual 444	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   131: invokevirtual 445	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   134: invokestatic 448	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   137: astore 18
    //   139: aload 18
    //   141: invokevirtual 451	java/nio/ByteBuffer:get	()B
    //   144: istore 4
    //   146: iload 4
    //   148: ifne +39 -> 187
    //   151: aload 17
    //   153: ldc_w 453
    //   156: aload 18
    //   158: invokevirtual 265	java/nio/ByteBuffer:array	()[B
    //   161: invokevirtual 457	android/os/Bundle:putByteArray	(Ljava/lang/String;[B)V
    //   164: aload 17
    //   166: ldc_w 459
    //   169: aload_1
    //   170: ldc_w 459
    //   173: iconst_0
    //   174: invokevirtual 406	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   177: invokevirtual 103	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   180: iload 10
    //   182: istore 11
    //   184: goto +188 -> 372
    //   187: new 57	java/lang/StringBuilder
    //   190: dup
    //   191: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   194: astore 18
    //   196: aload 18
    //   198: ldc_w 461
    //   201: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: pop
    //   205: aload 18
    //   207: iload 4
    //   209: invokevirtual 76	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   212: pop
    //   213: aconst_null
    //   214: ldc_w 463
    //   217: ldc_w 465
    //   220: aload 18
    //   222: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   225: aconst_null
    //   226: fconst_0
    //   227: invokestatic 470	com/tencent/mobileqq/vas/VasMonitorHandler:a	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;F)V
    //   230: ldc_w 463
    //   233: ldc_w 465
    //   236: invokestatic 474	com/tencent/mobileqq/vas/util/VasMonitorDT:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   239: goto +98 -> 337
    //   242: new 57	java/lang/StringBuilder
    //   245: dup
    //   246: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   249: astore 18
    //   251: aload 18
    //   253: ldc_w 461
    //   256: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: pop
    //   260: aload 18
    //   262: iload 4
    //   264: invokevirtual 76	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   267: pop
    //   268: aconst_null
    //   269: ldc_w 463
    //   272: ldc_w 476
    //   275: aload 18
    //   277: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   280: aconst_null
    //   281: fconst_0
    //   282: invokestatic 470	com/tencent/mobileqq/vas/VasMonitorHandler:a	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;F)V
    //   285: goto +52 -> 337
    //   288: astore 18
    //   290: invokestatic 55	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   293: ifeq +44 -> 337
    //   296: new 57	java/lang/StringBuilder
    //   299: dup
    //   300: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   303: astore 19
    //   305: aload 19
    //   307: ldc_w 478
    //   310: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: pop
    //   314: aload 19
    //   316: aload 18
    //   318: invokevirtual 481	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:getMessage	()Ljava/lang/String;
    //   321: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   324: pop
    //   325: ldc_w 483
    //   328: iconst_2
    //   329: aload 19
    //   331: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   334: invokestatic 91	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   337: iconst_0
    //   338: istore 11
    //   340: goto +32 -> 372
    //   343: aconst_null
    //   344: ldc_w 463
    //   347: ldc_w 485
    //   350: aload_2
    //   351: invokevirtual 488	com/tencent/qphone/base/remote/FromServiceMsg:getBusinessFailMsg	()Ljava/lang/String;
    //   354: aconst_null
    //   355: fconst_0
    //   356: invokestatic 470	com/tencent/mobileqq/vas/VasMonitorHandler:a	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;F)V
    //   359: ldc_w 463
    //   362: ldc_w 485
    //   365: invokestatic 474	com/tencent/mobileqq/vas/util/VasMonitorDT:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   368: iload 10
    //   370: istore 11
    //   372: aload_0
    //   373: aload_1
    //   374: iload_3
    //   375: iload 11
    //   377: aload 17
    //   379: ldc_w 490
    //   382: invokevirtual 494	com/tencent/mobileqq/richstatus/StatusServlet:notifyObserver	(Landroid/content/Intent;IZLandroid/os/Bundle;Ljava/lang/Class;)V
    //   385: goto +7 -> 392
    //   388: iload 10
    //   390: istore 11
    //   392: ldc_w 478
    //   395: astore 18
    //   397: iload 11
    //   399: istore 10
    //   401: iload_3
    //   402: bipush 9
    //   404: if_icmpne +599 -> 1003
    //   407: iload 11
    //   409: ifeq +554 -> 963
    //   412: aload_2
    //   413: invokevirtual 432	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   416: arraylength
    //   417: iconst_4
    //   418: isub
    //   419: istore 4
    //   421: iload 4
    //   423: newarray byte
    //   425: astore 20
    //   427: aload 20
    //   429: iconst_0
    //   430: aload_2
    //   431: invokevirtual 432	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   434: iconst_4
    //   435: iload 4
    //   437: invokestatic 500	com/tencent/mobileqq/utils/httputils/PkgTools:copyData	([BI[BII)V
    //   440: new 13	com/tencent/pb/signature/SigActPb$RspBody
    //   443: dup
    //   444: invokespecial 501	com/tencent/pb/signature/SigActPb$RspBody:<init>	()V
    //   447: astore 19
    //   449: aload 19
    //   451: aload 20
    //   453: invokevirtual 502	com/tencent/pb/signature/SigActPb$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   456: pop
    //   457: aload 19
    //   459: getfield 503	com/tencent/pb/signature/SigActPb$RspBody:ret	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   462: invokevirtual 73	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   465: istore 4
    //   467: iload 4
    //   469: ifne +79 -> 548
    //   472: aload 19
    //   474: getfield 17	com/tencent/pb/signature/SigActPb$RspBody:auth_rsp	Lcom/tencent/pb/signature/SigActPb$SigauthRsp;
    //   477: getfield 506	com/tencent/pb/signature/SigActPb$SigauthRsp:result	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   480: invokevirtual 444	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   483: invokevirtual 445	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   486: invokestatic 448	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   489: astore 19
    //   491: aload 19
    //   493: invokevirtual 451	java/nio/ByteBuffer:get	()B
    //   496: istore 4
    //   498: iload 4
    //   500: ifne +35 -> 535
    //   503: aload 17
    //   505: ldc_w 453
    //   508: aload 19
    //   510: invokevirtual 265	java/nio/ByteBuffer:array	()[B
    //   513: invokevirtual 457	android/os/Bundle:putByteArray	(Ljava/lang/String;[B)V
    //   516: aload 17
    //   518: ldc_w 459
    //   521: aload_1
    //   522: ldc_w 459
    //   525: iconst_0
    //   526: invokevirtual 406	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   529: invokevirtual 103	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   532: goto +454 -> 986
    //   535: aload 17
    //   537: ldc_w 508
    //   540: iload 4
    //   542: invokevirtual 103	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   545: goto +357 -> 902
    //   548: new 57	java/lang/StringBuilder
    //   551: dup
    //   552: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   555: astore 20
    //   557: aload 20
    //   559: ldc_w 461
    //   562: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   565: pop
    //   566: aload 20
    //   568: iload 4
    //   570: invokevirtual 76	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   573: pop
    //   574: aconst_null
    //   575: ldc_w 510
    //   578: ldc_w 512
    //   581: aload 20
    //   583: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   586: aconst_null
    //   587: fconst_0
    //   588: invokestatic 470	com/tencent/mobileqq/vas/VasMonitorHandler:a	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;F)V
    //   591: ldc_w 510
    //   594: iload 4
    //   596: invokestatic 514	com/tencent/mobileqq/vas/util/VasMonitorDT:a	(Ljava/lang/String;I)V
    //   599: aload 17
    //   601: ldc_w 516
    //   604: iload 4
    //   606: invokevirtual 103	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   609: iload 4
    //   611: ldc_w 517
    //   614: if_icmpne +22 -> 636
    //   617: aload 17
    //   619: ldc_w 519
    //   622: aload 19
    //   624: getfield 17	com/tencent/pb/signature/SigActPb$RspBody:auth_rsp	Lcom/tencent/pb/signature/SigActPb$SigauthRsp;
    //   627: getfield 520	com/tencent/pb/signature/SigActPb$SigauthRsp:url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   630: invokevirtual 121	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   633: invokevirtual 125	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   636: aload 19
    //   638: getfield 17	com/tencent/pb/signature/SigActPb$RspBody:auth_rsp	Lcom/tencent/pb/signature/SigActPb$SigauthRsp;
    //   641: getfield 523	com/tencent/pb/signature/SigActPb$SigauthRsp:authfailed_appid	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   644: invokevirtual 524	com/tencent/mobileqq/pb/PBInt32Field:has	()Z
    //   647: ifeq +22 -> 669
    //   650: aload 17
    //   652: ldc_w 526
    //   655: aload 19
    //   657: getfield 17	com/tencent/pb/signature/SigActPb$RspBody:auth_rsp	Lcom/tencent/pb/signature/SigActPb$SigauthRsp;
    //   660: getfield 523	com/tencent/pb/signature/SigActPb$SigauthRsp:authfailed_appid	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   663: invokevirtual 73	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   666: invokevirtual 103	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   669: aload 19
    //   671: getfield 17	com/tencent/pb/signature/SigActPb$RspBody:auth_rsp	Lcom/tencent/pb/signature/SigActPb$SigauthRsp;
    //   674: getfield 23	com/tencent/pb/signature/SigActPb$SigauthRsp:tips_info	Lcom/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo;
    //   677: invokevirtual 29	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo:has	()Z
    //   680: ifeq +222 -> 902
    //   683: new 25	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo
    //   686: dup
    //   687: invokespecial 30	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo:<init>	()V
    //   690: astore 20
    //   692: aload 20
    //   694: aload 19
    //   696: getfield 17	com/tencent/pb/signature/SigActPb$RspBody:auth_rsp	Lcom/tencent/pb/signature/SigActPb$SigauthRsp;
    //   699: getfield 23	com/tencent/pb/signature/SigActPb$SigauthRsp:tips_info	Lcom/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo;
    //   702: invokevirtual 34	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   705: checkcast 25	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo
    //   708: invokevirtual 38	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo:toByteArray	()[B
    //   711: invokevirtual 42	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   714: pop
    //   715: aload 20
    //   717: getfield 46	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo:valid	Lcom/tencent/mobileqq/pb/PBBoolField;
    //   720: invokevirtual 50	com/tencent/mobileqq/pb/PBBoolField:get	()Z
    //   723: istore 10
    //   725: aload 17
    //   727: ldc 92
    //   729: iload 10
    //   731: invokevirtual 98	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   734: iload 10
    //   736: ifeq +123 -> 859
    //   739: aload 17
    //   741: ldc 105
    //   743: aload 20
    //   745: getfield 108	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo:type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   748: invokevirtual 111	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   751: invokevirtual 103	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   754: aload 17
    //   756: ldc 113
    //   758: aload 20
    //   760: getfield 117	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo:title_wording	Lcom/tencent/mobileqq/pb/PBStringField;
    //   763: invokevirtual 121	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   766: invokevirtual 125	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   769: aload 17
    //   771: ldc 127
    //   773: aload 20
    //   775: getfield 129	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo:wording	Lcom/tencent/mobileqq/pb/PBStringField;
    //   778: invokevirtual 121	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   781: invokevirtual 125	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   784: aload 17
    //   786: ldc 131
    //   788: aload 20
    //   790: getfield 134	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo:right_btn_wording	Lcom/tencent/mobileqq/pb/PBStringField;
    //   793: invokevirtual 121	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   796: invokevirtual 125	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   799: aload 17
    //   801: ldc 136
    //   803: aload 20
    //   805: getfield 139	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo:left_btn_wording	Lcom/tencent/mobileqq/pb/PBStringField;
    //   808: invokevirtual 121	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   811: invokevirtual 125	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   814: aload 17
    //   816: ldc 141
    //   818: aload 20
    //   820: getfield 144	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo:vip_type	Lcom/tencent/mobileqq/pb/PBStringField;
    //   823: invokevirtual 121	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   826: invokevirtual 125	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   829: aload 17
    //   831: ldc 146
    //   833: aload 20
    //   835: getfield 149	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo:vip_month	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   838: invokevirtual 111	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   841: invokevirtual 103	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   844: aload 17
    //   846: ldc 151
    //   848: aload 20
    //   850: getfield 153	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo:url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   853: invokevirtual 121	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   856: invokevirtual 125	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   859: invokestatic 55	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   862: ifeq +40 -> 902
    //   865: new 57	java/lang/StringBuilder
    //   868: dup
    //   869: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   872: astore 19
    //   874: aload 19
    //   876: ldc_w 528
    //   879: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   882: pop
    //   883: aload 19
    //   885: aload 17
    //   887: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   890: pop
    //   891: ldc 162
    //   893: iconst_2
    //   894: aload 19
    //   896: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   899: invokestatic 165	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   902: iconst_0
    //   903: istore 11
    //   905: goto +81 -> 986
    //   908: astore 19
    //   910: invokestatic 55	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   913: ifeq +44 -> 957
    //   916: new 57	java/lang/StringBuilder
    //   919: dup
    //   920: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   923: astore 20
    //   925: aload 20
    //   927: ldc_w 478
    //   930: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   933: pop
    //   934: aload 20
    //   936: aload 19
    //   938: invokevirtual 529	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   941: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   944: pop
    //   945: ldc_w 483
    //   948: iconst_2
    //   949: aload 20
    //   951: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   954: invokestatic 91	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   957: iconst_0
    //   958: istore 10
    //   960: goto +30 -> 990
    //   963: aconst_null
    //   964: ldc_w 510
    //   967: ldc_w 531
    //   970: aload_2
    //   971: invokevirtual 488	com/tencent/qphone/base/remote/FromServiceMsg:getBusinessFailMsg	()Ljava/lang/String;
    //   974: aconst_null
    //   975: fconst_0
    //   976: invokestatic 470	com/tencent/mobileqq/vas/VasMonitorHandler:a	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;F)V
    //   979: ldc_w 510
    //   982: iconst_m1
    //   983: invokestatic 514	com/tencent/mobileqq/vas/util/VasMonitorDT:a	(Ljava/lang/String;I)V
    //   986: iload 11
    //   988: istore 10
    //   990: aload_0
    //   991: aload_1
    //   992: iload_3
    //   993: iload 10
    //   995: aload 17
    //   997: ldc_w 490
    //   1000: invokevirtual 494	com/tencent/mobileqq/richstatus/StatusServlet:notifyObserver	(Landroid/content/Intent;IZLandroid/os/Bundle;Ljava/lang/Class;)V
    //   1003: iload_3
    //   1004: iconst_4
    //   1005: if_icmpne +1008 -> 2013
    //   1008: aload 18
    //   1010: astore 20
    //   1012: iload_3
    //   1013: istore 4
    //   1015: aload 17
    //   1017: astore 19
    //   1019: new 533	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory
    //   1022: dup
    //   1023: invokespecial 534	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:<init>	()V
    //   1026: astore 23
    //   1028: aload 18
    //   1030: astore 20
    //   1032: iload_3
    //   1033: istore 4
    //   1035: aload 17
    //   1037: astore 19
    //   1039: aload 23
    //   1041: aload_1
    //   1042: ldc_w 536
    //   1045: iconst_0
    //   1046: invokevirtual 406	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   1049: putfield 539	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:startTime	I
    //   1052: aload 18
    //   1054: astore 20
    //   1056: iload_3
    //   1057: istore 4
    //   1059: aload 17
    //   1061: astore 19
    //   1063: aload 23
    //   1065: aload_1
    //   1066: ldc_w 541
    //   1069: ldc_w 542
    //   1072: invokevirtual 406	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   1075: putfield 545	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:endTime	I
    //   1078: aload 18
    //   1080: astore 20
    //   1082: iload_3
    //   1083: istore 4
    //   1085: aload 17
    //   1087: astore 19
    //   1089: aload 23
    //   1091: iconst_0
    //   1092: putfield 549	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:isAddFromCard	Z
    //   1095: aload 18
    //   1097: astore 20
    //   1099: iload_3
    //   1100: istore 4
    //   1102: aload 17
    //   1104: astore 19
    //   1106: aload 17
    //   1108: ldc_w 551
    //   1111: aload 23
    //   1113: invokevirtual 555	android/os/Bundle:putSerializable	(Ljava/lang/String;Ljava/io/Serializable;)V
    //   1116: aload 18
    //   1118: astore 20
    //   1120: iload_3
    //   1121: istore 4
    //   1123: aload 17
    //   1125: astore 19
    //   1127: aload_2
    //   1128: invokevirtual 432	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   1131: invokestatic 448	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   1134: astore 21
    //   1136: aload 18
    //   1138: astore 20
    //   1140: iload_3
    //   1141: istore 4
    //   1143: aload 17
    //   1145: astore 19
    //   1147: aload 21
    //   1149: invokevirtual 558	java/nio/ByteBuffer:getInt	()I
    //   1152: iconst_4
    //   1153: isub
    //   1154: newarray byte
    //   1156: astore 22
    //   1158: aload 18
    //   1160: astore 20
    //   1162: iload_3
    //   1163: istore 4
    //   1165: aload 17
    //   1167: astore 19
    //   1169: aload 21
    //   1171: aload 22
    //   1173: invokevirtual 560	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   1176: pop
    //   1177: aload 18
    //   1179: astore 20
    //   1181: iload_3
    //   1182: istore 4
    //   1184: aload 17
    //   1186: astore 19
    //   1188: new 208	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   1191: dup
    //   1192: invokespecial 209	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   1195: aload 22
    //   1197: invokevirtual 437	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1200: checkcast 208	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   1203: getfield 262	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1206: invokevirtual 444	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1209: invokevirtual 445	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   1212: invokestatic 448	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   1215: astore 21
    //   1217: aload 18
    //   1219: astore 20
    //   1221: iload_3
    //   1222: istore 4
    //   1224: aload 17
    //   1226: astore 19
    //   1228: aload 21
    //   1230: invokevirtual 451	java/nio/ByteBuffer:get	()B
    //   1233: pop
    //   1234: aload 18
    //   1236: astore 20
    //   1238: iload_3
    //   1239: istore 4
    //   1241: aload 17
    //   1243: astore 19
    //   1245: aload 21
    //   1247: invokevirtual 564	java/nio/ByteBuffer:getLong	()J
    //   1250: lstore 13
    //   1252: aload 18
    //   1254: astore 20
    //   1256: iload_3
    //   1257: istore 4
    //   1259: aload 17
    //   1261: astore 19
    //   1263: aload 21
    //   1265: invokevirtual 451	java/nio/ByteBuffer:get	()B
    //   1268: pop
    //   1269: aload 18
    //   1271: astore 20
    //   1273: iload_3
    //   1274: istore 4
    //   1276: aload 17
    //   1278: astore 19
    //   1280: aload 21
    //   1282: invokevirtual 558	java/nio/ByteBuffer:getInt	()I
    //   1285: pop
    //   1286: aload 18
    //   1288: astore 20
    //   1290: iload_3
    //   1291: istore 4
    //   1293: aload 17
    //   1295: astore 19
    //   1297: aload 21
    //   1299: invokevirtual 558	java/nio/ByteBuffer:getInt	()I
    //   1302: istore 7
    //   1304: aload 18
    //   1306: astore 20
    //   1308: iload_3
    //   1309: istore 4
    //   1311: aload 17
    //   1313: astore 19
    //   1315: aload 21
    //   1317: invokevirtual 558	java/nio/ByteBuffer:getInt	()I
    //   1320: pop
    //   1321: aload 18
    //   1323: astore 20
    //   1325: iload_3
    //   1326: istore 4
    //   1328: aload 17
    //   1330: astore 19
    //   1332: aload 21
    //   1334: invokevirtual 451	java/nio/ByteBuffer:get	()B
    //   1337: ifeq +3898 -> 5235
    //   1340: iconst_1
    //   1341: istore 11
    //   1343: goto +3 -> 1346
    //   1346: aload 18
    //   1348: astore 20
    //   1350: iload_3
    //   1351: istore 4
    //   1353: aload 17
    //   1355: astore 19
    //   1357: aload 21
    //   1359: invokevirtual 568	java/nio/ByteBuffer:getShort	()S
    //   1362: istore 5
    //   1364: aload 18
    //   1366: astore 20
    //   1368: iload_3
    //   1369: istore 4
    //   1371: aload 17
    //   1373: astore 19
    //   1375: aload 23
    //   1377: new 334	java/util/ArrayList
    //   1380: dup
    //   1381: iload 5
    //   1383: invokespecial 570	java/util/ArrayList:<init>	(I)V
    //   1386: putfield 573	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:richStatus	Ljava/util/ArrayList;
    //   1389: aload 18
    //   1391: astore 20
    //   1393: iload_3
    //   1394: istore 4
    //   1396: aload 17
    //   1398: astore 19
    //   1400: aload_0
    //   1401: invokevirtual 416	com/tencent/mobileqq/richstatus/StatusServlet:getAppRuntime	()Lmqq/app/AppRuntime;
    //   1404: checkcast 174	com/tencent/mobileqq/app/QQAppInterface
    //   1407: astore 24
    //   1409: iconst_0
    //   1410: istore 6
    //   1412: iload 6
    //   1414: iload 5
    //   1416: if_icmpge +224 -> 1640
    //   1419: aload 18
    //   1421: astore 20
    //   1423: iload_3
    //   1424: istore 4
    //   1426: aload 17
    //   1428: astore 19
    //   1430: aload 21
    //   1432: invokevirtual 568	java/nio/ByteBuffer:getShort	()S
    //   1435: newarray byte
    //   1437: astore 22
    //   1439: aload 18
    //   1441: astore 20
    //   1443: iload_3
    //   1444: istore 4
    //   1446: aload 17
    //   1448: astore 19
    //   1450: aload 21
    //   1452: aload 22
    //   1454: invokevirtual 560	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   1457: pop
    //   1458: aload 18
    //   1460: astore 20
    //   1462: iload_3
    //   1463: istore 4
    //   1465: aload 17
    //   1467: astore 19
    //   1469: aload 21
    //   1471: invokevirtual 568	java/nio/ByteBuffer:getShort	()S
    //   1474: newarray byte
    //   1476: astore 25
    //   1478: aload 18
    //   1480: astore 20
    //   1482: iload_3
    //   1483: istore 4
    //   1485: aload 17
    //   1487: astore 19
    //   1489: aload 21
    //   1491: aload 25
    //   1493: invokevirtual 560	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   1496: pop
    //   1497: aload 18
    //   1499: astore 20
    //   1501: iload_3
    //   1502: istore 4
    //   1504: aload 17
    //   1506: astore 19
    //   1508: aload 21
    //   1510: invokevirtual 558	java/nio/ByteBuffer:getInt	()I
    //   1513: pop
    //   1514: aload 18
    //   1516: astore 20
    //   1518: iload_3
    //   1519: istore 4
    //   1521: aload 17
    //   1523: astore 19
    //   1525: aload 21
    //   1527: invokevirtual 558	java/nio/ByteBuffer:getInt	()I
    //   1530: istore 8
    //   1532: aload 18
    //   1534: astore 20
    //   1536: iload_3
    //   1537: istore 4
    //   1539: aload 17
    //   1541: astore 19
    //   1543: aload 21
    //   1545: invokevirtual 576	java/nio/ByteBuffer:position	()I
    //   1548: istore 9
    //   1550: aload 18
    //   1552: astore 19
    //   1554: aload 21
    //   1556: iload 9
    //   1558: bipush 8
    //   1560: iadd
    //   1561: invokevirtual 579	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   1564: pop
    //   1565: iload 8
    //   1567: iload 7
    //   1569: if_icmple +6 -> 1575
    //   1572: goto +3669 -> 5241
    //   1575: aload 25
    //   1577: invokestatic 585	com/tencent/mobileqq/richstatus/RichStatus:parseStatus	([B)Lcom/tencent/mobileqq/richstatus/RichStatus;
    //   1580: astore 20
    //   1582: iload 8
    //   1584: i2l
    //   1585: lstore 15
    //   1587: aload 20
    //   1589: lload 15
    //   1591: putfield 588	com/tencent/mobileqq/richstatus/RichStatus:time	J
    //   1594: aload 20
    //   1596: aload 22
    //   1598: putfield 591	com/tencent/mobileqq/richstatus/RichStatus:key	[B
    //   1601: aload 20
    //   1603: getfield 591	com/tencent/mobileqq/richstatus/RichStatus:key	[B
    //   1606: ifnull +20 -> 1626
    //   1609: aload 20
    //   1611: new 593	java/lang/String
    //   1614: dup
    //   1615: aload 20
    //   1617: getfield 591	com/tencent/mobileqq/richstatus/RichStatus:key	[B
    //   1620: invokespecial 596	java/lang/String:<init>	([B)V
    //   1623: putfield 600	com/tencent/mobileqq/richstatus/RichStatus:feedsId	Ljava/lang/String;
    //   1626: aload 23
    //   1628: getfield 573	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:richStatus	Ljava/util/ArrayList;
    //   1631: aload 20
    //   1633: invokevirtual 359	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1636: pop
    //   1637: goto +3604 -> 5241
    //   1640: iload 10
    //   1642: istore 12
    //   1644: aload 18
    //   1646: astore 21
    //   1648: iload_3
    //   1649: istore 5
    //   1651: aload 17
    //   1653: astore 22
    //   1655: aload 23
    //   1657: getfield 573	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:richStatus	Ljava/util/ArrayList;
    //   1660: invokevirtual 603	java/util/ArrayList:isEmpty	()Z
    //   1663: ifeq +90 -> 1753
    //   1666: aload 23
    //   1668: getfield 539	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:startTime	I
    //   1671: ifne +82 -> 1753
    //   1674: aload 23
    //   1676: getfield 545	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:endTime	I
    //   1679: ldc_w 542
    //   1682: if_icmpne +71 -> 1753
    //   1685: aload_0
    //   1686: invokevirtual 416	com/tencent/mobileqq/richstatus/StatusServlet:getAppRuntime	()Lmqq/app/AppRuntime;
    //   1689: getstatic 606	com/tencent/mobileqq/app/QQManagerFactory:FRIENDS_MANAGER	I
    //   1692: invokevirtual 427	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   1695: checkcast 608	com/tencent/mobileqq/app/FriendsManager
    //   1698: lload 13
    //   1700: invokestatic 612	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1703: invokevirtual 616	com/tencent/mobileqq/app/FriendsManager:f	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   1706: astore 19
    //   1708: aload 19
    //   1710: ifnull +43 -> 1753
    //   1713: getstatic 622	com/tencent/mobileqq/profilecard/bussiness/personalitysign/utils/RichStatusUtils:Companion	Lcom/tencent/mobileqq/profilecard/bussiness/personalitysign/utils/RichStatusUtils$Companion;
    //   1716: aload 19
    //   1718: invokevirtual 628	com/tencent/mobileqq/profilecard/bussiness/personalitysign/utils/RichStatusUtils$Companion:getRichStatus	(Lcom/tencent/mobileqq/data/Card;)Lcom/tencent/mobileqq/richstatus/RichStatus;
    //   1721: astore 19
    //   1723: aload 19
    //   1725: ifnull +28 -> 1753
    //   1728: aload 19
    //   1730: invokevirtual 629	com/tencent/mobileqq/richstatus/RichStatus:isEmpty	()Z
    //   1733: ifne +20 -> 1753
    //   1736: aload 23
    //   1738: getfield 573	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:richStatus	Ljava/util/ArrayList;
    //   1741: aload 19
    //   1743: invokevirtual 359	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1746: pop
    //   1747: aload 23
    //   1749: iconst_1
    //   1750: putfield 549	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:isAddFromCard	Z
    //   1753: aload 24
    //   1755: getstatic 634	com/tencent/mobileqq/app/BusinessHandlerFactory:SIGNATURE_HANDLER	Ljava/lang/String;
    //   1758: invokevirtual 638	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(Ljava/lang/String;)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   1761: checkcast 640	com/tencent/mobileqq/app/SignatureHandler
    //   1764: astore 19
    //   1766: aload 23
    //   1768: getfield 573	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:richStatus	Ljava/util/ArrayList;
    //   1771: invokevirtual 340	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   1774: astore 20
    //   1776: aload 20
    //   1778: invokeinterface 230 1 0
    //   1783: ifeq +42 -> 1825
    //   1786: aload 20
    //   1788: invokeinterface 234 1 0
    //   1793: checkcast 581	com/tencent/mobileqq/richstatus/RichStatus
    //   1796: astore 25
    //   1798: aload 19
    //   1800: ifnull -24 -> 1776
    //   1803: aload 19
    //   1805: lload 13
    //   1807: invokestatic 612	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1810: aload 25
    //   1812: getfield 600	com/tencent/mobileqq/richstatus/RichStatus:feedsId	Ljava/lang/String;
    //   1815: sipush 255
    //   1818: iconst_1
    //   1819: invokevirtual 643	com/tencent/mobileqq/app/SignatureHandler:a	(Ljava/lang/String;Ljava/lang/String;IZ)V
    //   1822: goto -46 -> 1776
    //   1825: aload 23
    //   1827: iload 11
    //   1829: putfield 646	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:over	Z
    //   1832: aload 24
    //   1834: getstatic 649	com/tencent/mobileqq/app/QQManagerFactory:SIGNATURE_MANAGER	I
    //   1837: invokevirtual 650	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1840: checkcast 652	com/tencent/mobileqq/app/SignatureManager
    //   1843: astore 25
    //   1845: iload 12
    //   1847: istore 10
    //   1849: iload 5
    //   1851: istore 4
    //   1853: aload 21
    //   1855: astore 20
    //   1857: aload 22
    //   1859: astore 19
    //   1861: aload 25
    //   1863: ifnull +130 -> 1993
    //   1866: iload 12
    //   1868: istore 10
    //   1870: iload 5
    //   1872: istore 4
    //   1874: aload 21
    //   1876: astore 20
    //   1878: aload 22
    //   1880: astore 19
    //   1882: aload 24
    //   1884: invokevirtual 192	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1887: lload 13
    //   1889: invokestatic 656	java/lang/Long:toString	(J)Ljava/lang/String;
    //   1892: invokevirtual 659	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1895: ifeq +98 -> 1993
    //   1898: aload 25
    //   1900: aload 23
    //   1902: getfield 573	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:richStatus	Ljava/util/ArrayList;
    //   1905: invokevirtual 662	com/tencent/mobileqq/app/SignatureManager:a	(Ljava/util/List;)V
    //   1908: iload 12
    //   1910: istore 10
    //   1912: iload 5
    //   1914: istore 4
    //   1916: aload 21
    //   1918: astore 20
    //   1920: aload 22
    //   1922: astore 19
    //   1924: goto +69 -> 1993
    //   1927: aload 17
    //   1929: astore 19
    //   1931: aload 18
    //   1933: astore 17
    //   1935: astore 18
    //   1937: iload_3
    //   1938: istore 4
    //   1940: goto +23 -> 1963
    //   1943: astore 18
    //   1945: aload 20
    //   1947: astore 17
    //   1949: aload 19
    //   1951: astore 20
    //   1953: iload 4
    //   1955: istore_3
    //   1956: aload 20
    //   1958: astore 19
    //   1960: iload_3
    //   1961: istore 4
    //   1963: aload 18
    //   1965: invokevirtual 665	java/lang/Exception:printStackTrace	()V
    //   1968: invokestatic 55	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1971: ifeq +15 -> 1986
    //   1974: ldc_w 483
    //   1977: iconst_2
    //   1978: aload 18
    //   1980: invokevirtual 529	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1983: invokestatic 668	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1986: iconst_0
    //   1987: istore 10
    //   1989: aload 17
    //   1991: astore 20
    //   1993: aload_0
    //   1994: aload_1
    //   1995: iload 4
    //   1997: iload 10
    //   1999: aload 19
    //   2001: ldc_w 490
    //   2004: invokevirtual 494	com/tencent/mobileqq/richstatus/StatusServlet:notifyObserver	(Landroid/content/Intent;IZLandroid/os/Bundle;Ljava/lang/Class;)V
    //   2007: iload 4
    //   2009: istore_3
    //   2010: goto +12 -> 2022
    //   2013: ldc_w 478
    //   2016: astore 20
    //   2018: aload 17
    //   2020: astore 19
    //   2022: iload 10
    //   2024: istore 11
    //   2026: iload_3
    //   2027: bipush 8
    //   2029: if_icmpne +167 -> 2196
    //   2032: iload 10
    //   2034: istore 11
    //   2036: iload 10
    //   2038: ifeq +145 -> 2183
    //   2041: new 208	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   2044: dup
    //   2045: invokespecial 209	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   2048: astore 17
    //   2050: aload 17
    //   2052: aload_2
    //   2053: invokevirtual 432	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   2056: invokestatic 436	com/tencent/mobileqq/utils/WupUtil:b	([B)[B
    //   2059: invokevirtual 437	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2062: checkcast 208	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   2065: astore 17
    //   2067: iload 10
    //   2069: istore 11
    //   2071: aload 17
    //   2073: ifnull +110 -> 2183
    //   2076: iload 10
    //   2078: istore 11
    //   2080: aload 17
    //   2082: getfield 440	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2085: invokevirtual 441	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   2088: ifeq +95 -> 2183
    //   2091: aload 17
    //   2093: getfield 440	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2096: invokevirtual 111	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2099: ifne +81 -> 2180
    //   2102: aload 17
    //   2104: getfield 262	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   2107: invokevirtual 444	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   2110: invokevirtual 445	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   2113: invokestatic 448	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   2116: invokevirtual 451	java/nio/ByteBuffer:get	()B
    //   2119: istore 4
    //   2121: iload 4
    //   2123: ifne +57 -> 2180
    //   2126: iconst_1
    //   2127: istore 11
    //   2129: goto +54 -> 2183
    //   2132: astore 17
    //   2134: invokestatic 55	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2137: ifeq +43 -> 2180
    //   2140: new 57	java/lang/StringBuilder
    //   2143: dup
    //   2144: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   2147: astore 18
    //   2149: aload 18
    //   2151: aload 20
    //   2153: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2156: pop
    //   2157: aload 18
    //   2159: aload 17
    //   2161: invokevirtual 481	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:getMessage	()Ljava/lang/String;
    //   2164: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2167: pop
    //   2168: ldc_w 483
    //   2171: iconst_2
    //   2172: aload 18
    //   2174: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2177: invokestatic 91	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2180: iconst_0
    //   2181: istore 11
    //   2183: aload_0
    //   2184: aload_1
    //   2185: iload_3
    //   2186: iload 11
    //   2188: aload 19
    //   2190: ldc_w 490
    //   2193: invokevirtual 494	com/tencent/mobileqq/richstatus/StatusServlet:notifyObserver	(Landroid/content/Intent;IZLandroid/os/Bundle;Ljava/lang/Class;)V
    //   2196: iload_3
    //   2197: iconst_1
    //   2198: if_icmpeq +8 -> 2206
    //   2201: iload_3
    //   2202: iconst_2
    //   2203: if_icmpne +174 -> 2377
    //   2206: aload_2
    //   2207: invokevirtual 432	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   2210: invokestatic 448	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   2213: astore_2
    //   2214: aload_2
    //   2215: invokevirtual 558	java/nio/ByteBuffer:getInt	()I
    //   2218: iconst_4
    //   2219: isub
    //   2220: newarray byte
    //   2222: astore 17
    //   2224: aload_2
    //   2225: aload 17
    //   2227: invokevirtual 560	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   2230: pop
    //   2231: new 208	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   2234: dup
    //   2235: invokespecial 209	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   2238: aload 17
    //   2240: invokevirtual 437	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2243: checkcast 208	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   2246: getfield 262	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   2249: invokevirtual 444	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   2252: invokevirtual 445	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   2255: invokestatic 448	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   2258: astore_2
    //   2259: aload_2
    //   2260: invokevirtual 451	java/nio/ByteBuffer:get	()B
    //   2263: istore 4
    //   2265: aload_2
    //   2266: invokevirtual 558	java/nio/ByteBuffer:getInt	()I
    //   2269: pop
    //   2270: aload_2
    //   2271: invokevirtual 451	java/nio/ByteBuffer:get	()B
    //   2274: istore 5
    //   2276: iload 5
    //   2278: iconst_1
    //   2279: if_icmpne +9 -> 2288
    //   2282: iconst_1
    //   2283: istore 10
    //   2285: goto +6 -> 2291
    //   2288: iconst_0
    //   2289: istore 10
    //   2291: iload 4
    //   2293: ifeq +9 -> 2302
    //   2296: iconst_0
    //   2297: istore 11
    //   2299: goto +24 -> 2323
    //   2302: iload_3
    //   2303: iconst_2
    //   2304: if_icmpne +19 -> 2323
    //   2307: aload_1
    //   2308: ldc 202
    //   2310: iconst_0
    //   2311: invokevirtual 672	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   2314: istore 10
    //   2316: goto +7 -> 2323
    //   2319: astore_2
    //   2320: goto +20 -> 2340
    //   2323: aload 19
    //   2325: ldc 202
    //   2327: iload 10
    //   2329: invokevirtual 98	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   2332: goto +32 -> 2364
    //   2335: astore_2
    //   2336: goto +4 -> 2340
    //   2339: astore_2
    //   2340: aload_2
    //   2341: invokevirtual 665	java/lang/Exception:printStackTrace	()V
    //   2344: invokestatic 55	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2347: ifeq +14 -> 2361
    //   2350: ldc_w 483
    //   2353: iconst_2
    //   2354: aload_2
    //   2355: invokevirtual 529	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2358: invokestatic 668	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   2361: iconst_0
    //   2362: istore 11
    //   2364: aload_0
    //   2365: aload_1
    //   2366: iload_3
    //   2367: iload 11
    //   2369: aload 19
    //   2371: ldc_w 490
    //   2374: invokevirtual 494	com/tencent/mobileqq/richstatus/StatusServlet:notifyObserver	(Landroid/content/Intent;IZLandroid/os/Bundle;Ljava/lang/Class;)V
    //   2377: return
    //   2378: iload_3
    //   2379: tableswitch	default:+49 -> 2428, 1:+2656->5035, 2:+2656->5035, 3:+2541->4920, 4:+1870->4249, 5:+1426->3805, 6:+921->3300, 7:+731->3110, 8:+583->2962, 9:+52->2431
    //   2429: lconst_1
    //   2430: <illegal opcode>
    //   2431: iload 10
    //   2433: ifeq +526 -> 2959
    //   2436: aload_1
    //   2437: ldc_w 459
    //   2440: iconst_0
    //   2441: invokevirtual 406	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   2444: istore 4
    //   2446: aload_2
    //   2447: invokevirtual 432	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   2450: arraylength
    //   2451: iconst_4
    //   2452: isub
    //   2453: istore 5
    //   2455: iload 5
    //   2457: newarray byte
    //   2459: astore 18
    //   2461: aload 18
    //   2463: iconst_0
    //   2464: aload_2
    //   2465: invokevirtual 432	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   2468: iconst_4
    //   2469: iload 5
    //   2471: invokestatic 500	com/tencent/mobileqq/utils/httputils/PkgTools:copyData	([BI[BII)V
    //   2474: new 13	com/tencent/pb/signature/SigActPb$RspBody
    //   2477: dup
    //   2478: invokespecial 501	com/tencent/pb/signature/SigActPb$RspBody:<init>	()V
    //   2481: astore 19
    //   2483: aload 19
    //   2485: aload 18
    //   2487: invokevirtual 502	com/tencent/pb/signature/SigActPb$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2490: pop
    //   2491: aload 19
    //   2493: getfield 503	com/tencent/pb/signature/SigActPb$RspBody:ret	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   2496: invokevirtual 73	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   2499: istore 5
    //   2501: aload 19
    //   2503: getfield 675	com/tencent/pb/signature/SigActPb$RspBody:desc	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2506: invokevirtual 676	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   2509: ifeq +15 -> 2524
    //   2512: aload 19
    //   2514: getfield 675	com/tencent/pb/signature/SigActPb$RspBody:desc	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2517: invokevirtual 121	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2520: astore_2
    //   2521: goto +7 -> 2528
    //   2524: ldc_w 461
    //   2527: astore_2
    //   2528: iload 5
    //   2530: ifne +158 -> 2688
    //   2533: aload 19
    //   2535: getfield 17	com/tencent/pb/signature/SigActPb$RspBody:auth_rsp	Lcom/tencent/pb/signature/SigActPb$SigauthRsp;
    //   2538: getfield 506	com/tencent/pb/signature/SigActPb$SigauthRsp:result	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   2541: invokevirtual 444	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   2544: invokevirtual 445	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   2547: invokestatic 448	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   2550: astore 18
    //   2552: aload 18
    //   2554: invokevirtual 451	java/nio/ByteBuffer:get	()B
    //   2557: istore 5
    //   2559: iload 5
    //   2561: ifne +19 -> 2580
    //   2564: aload 17
    //   2566: ldc_w 453
    //   2569: aload 18
    //   2571: invokevirtual 265	java/nio/ByteBuffer:array	()[B
    //   2574: invokevirtual 457	android/os/Bundle:putByteArray	(Ljava/lang/String;[B)V
    //   2577: goto +75 -> 2652
    //   2580: aload 17
    //   2582: ldc_w 508
    //   2585: iload 5
    //   2587: invokevirtual 103	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   2590: invokestatic 682	com/tencent/mobileqq/vas/config/business/qvip/SSOErrorInfoMapProcessor:e	()Lcom/tencent/mobileqq/vas/config/business/qvip/SSOErrorInfoMapConfig;
    //   2593: astore 20
    //   2595: aload_2
    //   2596: astore 18
    //   2598: aload_2
    //   2599: invokestatic 687	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2602: ifeq +44 -> 2646
    //   2605: new 57	java/lang/StringBuilder
    //   2608: dup
    //   2609: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   2612: astore 18
    //   2614: aload 18
    //   2616: ldc_w 461
    //   2619: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2622: pop
    //   2623: aload 18
    //   2625: iload 5
    //   2627: invokevirtual 76	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2630: pop
    //   2631: aload 20
    //   2633: ldc_w 689
    //   2636: aload 18
    //   2638: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2641: invokevirtual 695	com/tencent/mobileqq/vas/config/business/qvip/SSOErrorInfoMapConfig:getErrorInfo	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   2644: astore 18
    //   2646: aload 18
    //   2648: astore_2
    //   2649: iconst_0
    //   2650: istore 10
    //   2652: iload 4
    //   2654: iconst_1
    //   2655: if_icmpne +25 -> 2680
    //   2658: aload_0
    //   2659: aload 17
    //   2661: aload 19
    //   2663: ldc_w 697
    //   2666: invokespecial 699	com/tencent/mobileqq/richstatus/StatusServlet:a	(Landroid/os/Bundle;Lcom/tencent/pb/signature/SigActPb$RspBody;Ljava/lang/String;)V
    //   2669: goto +168 -> 2837
    //   2672: astore 19
    //   2674: goto +3 -> 2677
    //   2677: goto +104 -> 2781
    //   2680: goto +157 -> 2837
    //   2683: astore 18
    //   2685: goto +92 -> 2777
    //   2688: aload 17
    //   2690: ldc_w 516
    //   2693: iload 5
    //   2695: invokevirtual 103	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   2698: iload 5
    //   2700: ldc_w 517
    //   2703: if_icmpne +22 -> 2725
    //   2706: aload 17
    //   2708: ldc_w 519
    //   2711: aload 19
    //   2713: getfield 17	com/tencent/pb/signature/SigActPb$RspBody:auth_rsp	Lcom/tencent/pb/signature/SigActPb$SigauthRsp;
    //   2716: getfield 520	com/tencent/pb/signature/SigActPb$SigauthRsp:url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2719: invokevirtual 121	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2722: invokevirtual 125	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   2725: aload 19
    //   2727: getfield 17	com/tencent/pb/signature/SigActPb$RspBody:auth_rsp	Lcom/tencent/pb/signature/SigActPb$SigauthRsp;
    //   2730: getfield 523	com/tencent/pb/signature/SigActPb$SigauthRsp:authfailed_appid	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   2733: invokevirtual 524	com/tencent/mobileqq/pb/PBInt32Field:has	()Z
    //   2736: ifeq +22 -> 2758
    //   2739: aload 17
    //   2741: ldc_w 526
    //   2744: aload 19
    //   2746: getfield 17	com/tencent/pb/signature/SigActPb$RspBody:auth_rsp	Lcom/tencent/pb/signature/SigActPb$SigauthRsp;
    //   2749: getfield 523	com/tencent/pb/signature/SigActPb$SigauthRsp:authfailed_appid	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   2752: invokevirtual 73	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   2755: invokevirtual 103	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   2758: aload_0
    //   2759: aload 17
    //   2761: aload 19
    //   2763: ldc_w 701
    //   2766: invokespecial 699	com/tencent/mobileqq/richstatus/StatusServlet:a	(Landroid/os/Bundle;Lcom/tencent/pb/signature/SigActPb$RspBody;Ljava/lang/String;)V
    //   2769: aload_2
    //   2770: astore 18
    //   2772: goto +2495 -> 5267
    //   2775: astore 18
    //   2777: aload 18
    //   2779: astore 19
    //   2781: aload_2
    //   2782: astore 18
    //   2784: invokestatic 55	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2787: ifeq +2480 -> 5267
    //   2790: new 57	java/lang/StringBuilder
    //   2793: dup
    //   2794: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   2797: astore 18
    //   2799: aload 18
    //   2801: ldc_w 478
    //   2804: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2807: pop
    //   2808: aload 18
    //   2810: aload 19
    //   2812: invokevirtual 529	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2815: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2818: pop
    //   2819: ldc_w 483
    //   2822: iconst_2
    //   2823: aload 18
    //   2825: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2828: invokestatic 91	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2831: aload_2
    //   2832: astore 18
    //   2834: goto +2433 -> 5267
    //   2837: aload_2
    //   2838: ifnull +12 -> 2850
    //   2841: aload 17
    //   2843: ldc_w 703
    //   2846: aload_2
    //   2847: invokevirtual 125	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   2850: aload 17
    //   2852: ldc_w 459
    //   2855: iload 4
    //   2857: invokevirtual 103	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   2860: invokestatic 706	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   2863: ifeq +39 -> 2902
    //   2866: ldc 162
    //   2868: iconst_1
    //   2869: ldc_w 708
    //   2872: iconst_3
    //   2873: anewarray 710	java/lang/Object
    //   2876: dup
    //   2877: iconst_0
    //   2878: iload 10
    //   2880: invokestatic 715	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   2883: aastore
    //   2884: dup
    //   2885: iconst_1
    //   2886: iload 4
    //   2888: invokestatic 720	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2891: aastore
    //   2892: dup
    //   2893: iconst_2
    //   2894: aload_2
    //   2895: aastore
    //   2896: invokestatic 724	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   2899: invokestatic 165	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2902: goto +2312 -> 5214
    //   2905: astore_2
    //   2906: goto +4 -> 2910
    //   2909: astore_2
    //   2910: invokestatic 55	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2913: ifeq +889 -> 3802
    //   2916: new 57	java/lang/StringBuilder
    //   2919: dup
    //   2920: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   2923: astore 18
    //   2925: aload 18
    //   2927: ldc_w 478
    //   2930: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2933: pop
    //   2934: aload 18
    //   2936: aload_2
    //   2937: invokevirtual 529	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2940: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2943: pop
    //   2944: ldc_w 483
    //   2947: iconst_2
    //   2948: aload 18
    //   2950: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2953: invokestatic 91	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2956: goto +846 -> 3802
    //   2959: goto -531 -> 2428
    //   2962: iload 10
    //   2964: ifeq -536 -> 2428
    //   2967: new 208	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   2970: dup
    //   2971: invokespecial 209	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   2974: astore 18
    //   2976: aload 18
    //   2978: aload_2
    //   2979: invokevirtual 432	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   2982: invokestatic 436	com/tencent/mobileqq/utils/WupUtil:b	([B)[B
    //   2985: invokevirtual 437	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2988: checkcast 208	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   2991: astore_2
    //   2992: aload_2
    //   2993: ifnull +64 -> 3057
    //   2996: aload_2
    //   2997: getfield 440	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3000: invokevirtual 441	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   3003: ifeq +54 -> 3057
    //   3006: aload_2
    //   3007: getfield 440	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3010: invokevirtual 111	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3013: ifne +38 -> 3051
    //   3016: aload_2
    //   3017: getfield 262	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3020: invokevirtual 444	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   3023: invokevirtual 445	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   3026: invokestatic 448	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   3029: invokevirtual 451	java/nio/ByteBuffer:get	()B
    //   3032: istore 4
    //   3034: iload 4
    //   3036: ifne +9 -> 3045
    //   3039: iconst_1
    //   3040: istore 10
    //   3042: goto +6 -> 3048
    //   3045: iconst_0
    //   3046: istore 10
    //   3048: goto +196 -> 3244
    //   3051: iconst_0
    //   3052: istore 10
    //   3054: goto +190 -> 3244
    //   3057: goto +187 -> 3244
    //   3060: astore_2
    //   3061: invokestatic 55	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3064: ifeq +230 -> 3294
    //   3067: new 57	java/lang/StringBuilder
    //   3070: dup
    //   3071: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   3074: astore 18
    //   3076: aload 18
    //   3078: ldc_w 478
    //   3081: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3084: pop
    //   3085: aload 18
    //   3087: aload_2
    //   3088: invokevirtual 481	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:getMessage	()Ljava/lang/String;
    //   3091: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3094: pop
    //   3095: ldc_w 483
    //   3098: iconst_2
    //   3099: aload 18
    //   3101: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3104: invokestatic 91	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3107: goto +187 -> 3294
    //   3110: iload 10
    //   3112: ifeq -684 -> 2428
    //   3115: new 208	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   3118: dup
    //   3119: invokespecial 209	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   3122: astore 18
    //   3124: aload 18
    //   3126: aload_2
    //   3127: invokevirtual 432	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   3130: invokestatic 436	com/tencent/mobileqq/utils/WupUtil:b	([B)[B
    //   3133: invokevirtual 437	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3136: checkcast 208	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   3139: astore_2
    //   3140: iload 10
    //   3142: istore 11
    //   3144: aload_2
    //   3145: ifnull +95 -> 3240
    //   3148: iload 10
    //   3150: istore 11
    //   3152: aload_2
    //   3153: getfield 440	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3156: invokevirtual 441	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   3159: ifeq +81 -> 3240
    //   3162: aload_2
    //   3163: getfield 440	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3166: invokevirtual 111	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3169: ifne +65 -> 3234
    //   3172: aload_2
    //   3173: getfield 262	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3176: invokevirtual 444	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   3179: invokevirtual 445	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   3182: invokestatic 448	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   3185: astore_2
    //   3186: aload_2
    //   3187: invokevirtual 451	java/nio/ByteBuffer:get	()B
    //   3190: ifne +38 -> 3228
    //   3193: aload 17
    //   3195: ldc_w 453
    //   3198: aload_2
    //   3199: invokevirtual 265	java/nio/ByteBuffer:array	()[B
    //   3202: invokevirtual 457	android/os/Bundle:putByteArray	(Ljava/lang/String;[B)V
    //   3205: aload 17
    //   3207: ldc_w 459
    //   3210: aload_1
    //   3211: ldc_w 459
    //   3214: iconst_0
    //   3215: invokevirtual 406	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   3218: invokevirtual 103	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   3221: iload 10
    //   3223: istore 11
    //   3225: goto +15 -> 3240
    //   3228: iconst_0
    //   3229: istore 11
    //   3231: goto +9 -> 3240
    //   3234: iconst_0
    //   3235: istore 10
    //   3237: goto +7 -> 3244
    //   3240: iload 11
    //   3242: istore 10
    //   3244: goto +53 -> 3297
    //   3247: astore_2
    //   3248: invokestatic 55	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3251: ifeq +43 -> 3294
    //   3254: new 57	java/lang/StringBuilder
    //   3257: dup
    //   3258: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   3261: astore 18
    //   3263: aload 18
    //   3265: ldc_w 478
    //   3268: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3271: pop
    //   3272: aload 18
    //   3274: aload_2
    //   3275: invokevirtual 481	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:getMessage	()Ljava/lang/String;
    //   3278: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3281: pop
    //   3282: ldc_w 483
    //   3285: iconst_2
    //   3286: aload 18
    //   3288: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3291: invokestatic 91	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3294: iconst_0
    //   3295: istore 10
    //   3297: goto +1917 -> 5214
    //   3300: new 726	com/qq/jce/wup/UniPacket
    //   3303: dup
    //   3304: iconst_1
    //   3305: invokespecial 729	com/qq/jce/wup/UniPacket:<init>	(Z)V
    //   3308: astore 19
    //   3310: aload 19
    //   3312: ldc_w 731
    //   3315: invokevirtual 735	com/qq/jce/wup/UniPacket:setEncodeName	(Ljava/lang/String;)V
    //   3318: aload 19
    //   3320: aload_2
    //   3321: invokevirtual 432	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   3324: invokevirtual 738	com/qq/jce/wup/UniPacket:decode	([B)V
    //   3327: aload 19
    //   3329: ldc_w 740
    //   3332: new 742	PersonalState/RespGetHotState
    //   3335: dup
    //   3336: invokespecial 743	PersonalState/RespGetHotState:<init>	()V
    //   3339: invokevirtual 747	com/qq/jce/wup/UniPacket:getByClass	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   3342: checkcast 742	PersonalState/RespGetHotState
    //   3345: astore 19
    //   3347: aload 19
    //   3349: getfield 751	PersonalState/RespGetHotState:oHead	LPersonalState/BusiRespHead;
    //   3352: getfield 756	PersonalState/BusiRespHead:iReplyCode	I
    //   3355: ifne +431 -> 3786
    //   3358: invokestatic 55	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3361: ifeq +170 -> 3531
    //   3364: new 57	java/lang/StringBuilder
    //   3367: dup
    //   3368: ldc_w 758
    //   3371: invokespecial 760	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3374: astore 20
    //   3376: aload 20
    //   3378: ldc_w 762
    //   3381: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3384: pop
    //   3385: aload 19
    //   3387: getfield 765	PersonalState/RespGetHotState:vHostRichSateList	Ljava/util/ArrayList;
    //   3390: ifnonnull +10 -> 3400
    //   3393: ldc_w 767
    //   3396: astore_2
    //   3397: goto +15 -> 3412
    //   3400: aload 19
    //   3402: getfield 765	PersonalState/RespGetHotState:vHostRichSateList	Ljava/util/ArrayList;
    //   3405: invokevirtual 768	java/util/ArrayList:size	()I
    //   3408: invokestatic 720	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3411: astore_2
    //   3412: aload 20
    //   3414: aload_2
    //   3415: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3418: pop
    //   3419: aload 20
    //   3421: ldc_w 770
    //   3424: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3427: pop
    //   3428: aload 19
    //   3430: getfield 765	PersonalState/RespGetHotState:vHostRichSateList	Ljava/util/ArrayList;
    //   3433: ifnull +86 -> 3519
    //   3436: aload 19
    //   3438: getfield 765	PersonalState/RespGetHotState:vHostRichSateList	Ljava/util/ArrayList;
    //   3441: invokevirtual 768	java/util/ArrayList:size	()I
    //   3444: ifle +75 -> 3519
    //   3447: aload 19
    //   3449: getfield 765	PersonalState/RespGetHotState:vHostRichSateList	Ljava/util/ArrayList;
    //   3452: invokevirtual 340	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   3455: astore_2
    //   3456: aload_2
    //   3457: invokeinterface 230 1 0
    //   3462: ifeq +57 -> 3519
    //   3465: aload_2
    //   3466: invokeinterface 234 1 0
    //   3471: checkcast 772	PersonalState/HotRishState
    //   3474: astore 21
    //   3476: aload 20
    //   3478: ldc_w 774
    //   3481: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3484: pop
    //   3485: aload 20
    //   3487: aload 21
    //   3489: getfield 777	PersonalState/HotRishState:iActId	I
    //   3492: invokevirtual 76	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3495: pop
    //   3496: aload 20
    //   3498: ldc_w 779
    //   3501: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3504: pop
    //   3505: aload 20
    //   3507: aload 21
    //   3509: getfield 782	PersonalState/HotRishState:iDataId	I
    //   3512: invokevirtual 76	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3515: pop
    //   3516: goto -60 -> 3456
    //   3519: ldc_w 784
    //   3522: iconst_2
    //   3523: aload 20
    //   3525: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3528: invokestatic 91	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3531: new 334	java/util/ArrayList
    //   3534: dup
    //   3535: bipush 6
    //   3537: invokespecial 570	java/util/ArrayList:<init>	(I)V
    //   3540: astore_2
    //   3541: aload 19
    //   3543: getfield 765	PersonalState/RespGetHotState:vHostRichSateList	Ljava/util/ArrayList;
    //   3546: ifnull +228 -> 3774
    //   3549: aload 19
    //   3551: getfield 765	PersonalState/RespGetHotState:vHostRichSateList	Ljava/util/ArrayList;
    //   3554: invokevirtual 768	java/util/ArrayList:size	()I
    //   3557: ifle +217 -> 3774
    //   3560: aload 18
    //   3562: ifnull +88 -> 3650
    //   3565: aload 18
    //   3567: invokevirtual 788	com/tencent/mobileqq/richstatus/StatusManager:c	()Lcom/tencent/mobileqq/richstatus/RichStatus;
    //   3570: astore 20
    //   3572: aload 19
    //   3574: getfield 765	PersonalState/RespGetHotState:vHostRichSateList	Ljava/util/ArrayList;
    //   3577: invokevirtual 768	java/util/ArrayList:size	()I
    //   3580: iconst_1
    //   3581: isub
    //   3582: istore 4
    //   3584: iload 4
    //   3586: iflt +64 -> 3650
    //   3589: aload 19
    //   3591: getfield 765	PersonalState/RespGetHotState:vHostRichSateList	Ljava/util/ArrayList;
    //   3594: iload 4
    //   3596: invokevirtual 791	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   3599: checkcast 772	PersonalState/HotRishState
    //   3602: astore 21
    //   3604: aload 21
    //   3606: getfield 777	PersonalState/HotRishState:iActId	I
    //   3609: aload 20
    //   3611: getfield 794	com/tencent/mobileqq/richstatus/RichStatus:actionId	I
    //   3614: if_icmpne +27 -> 3641
    //   3617: aload 21
    //   3619: getfield 782	PersonalState/HotRishState:iDataId	I
    //   3622: aload 20
    //   3624: getfield 797	com/tencent/mobileqq/richstatus/RichStatus:dataId	I
    //   3627: if_icmpne +14 -> 3641
    //   3630: aload 19
    //   3632: getfield 765	PersonalState/RespGetHotState:vHostRichSateList	Ljava/util/ArrayList;
    //   3635: iload 4
    //   3637: invokevirtual 800	java/util/ArrayList:remove	(I)Ljava/lang/Object;
    //   3640: pop
    //   3641: iload 4
    //   3643: iconst_1
    //   3644: isub
    //   3645: istore 4
    //   3647: goto -63 -> 3584
    //   3650: iconst_0
    //   3651: istore 4
    //   3653: iload 4
    //   3655: bipush 6
    //   3657: if_icmpge +27 -> 3684
    //   3660: aload_2
    //   3661: aload 19
    //   3663: getfield 765	PersonalState/RespGetHotState:vHostRichSateList	Ljava/util/ArrayList;
    //   3666: iload 4
    //   3668: invokevirtual 791	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   3671: invokevirtual 359	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   3674: pop
    //   3675: iload 4
    //   3677: iconst_1
    //   3678: iadd
    //   3679: istore 4
    //   3681: goto -28 -> 3653
    //   3684: new 57	java/lang/StringBuilder
    //   3687: dup
    //   3688: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   3691: astore 19
    //   3693: aload_2
    //   3694: invokevirtual 340	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   3697: astore 20
    //   3699: aload 20
    //   3701: invokeinterface 230 1 0
    //   3706: ifeq +58 -> 3764
    //   3709: aload 20
    //   3711: invokeinterface 234 1 0
    //   3716: checkcast 772	PersonalState/HotRishState
    //   3719: astore 21
    //   3721: aload 19
    //   3723: aload 21
    //   3725: getfield 777	PersonalState/HotRishState:iActId	I
    //   3728: invokevirtual 76	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3731: pop
    //   3732: aload 19
    //   3734: ldc_w 779
    //   3737: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3740: pop
    //   3741: aload 19
    //   3743: aload 21
    //   3745: getfield 782	PersonalState/HotRishState:iDataId	I
    //   3748: invokevirtual 76	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3751: pop
    //   3752: aload 19
    //   3754: ldc_w 802
    //   3757: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3760: pop
    //   3761: goto -62 -> 3699
    //   3764: aload 18
    //   3766: aload 19
    //   3768: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3771: invokevirtual 804	com/tencent/mobileqq/richstatus/StatusManager:a	(Ljava/lang/String;)V
    //   3774: aload 17
    //   3776: ldc_w 806
    //   3779: aload_2
    //   3780: invokevirtual 555	android/os/Bundle:putSerializable	(Ljava/lang/String;Ljava/io/Serializable;)V
    //   3783: goto -1355 -> 2428
    //   3786: invokestatic 55	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3789: ifeq +13 -> 3802
    //   3792: ldc_w 784
    //   3795: iconst_2
    //   3796: ldc_w 808
    //   3799: invokestatic 91	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3802: goto +1227 -> 5029
    //   3805: iload 10
    //   3807: ifeq -1379 -> 2428
    //   3810: new 208	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   3813: dup
    //   3814: invokespecial 209	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   3817: astore 18
    //   3819: aload 18
    //   3821: aload_2
    //   3822: invokevirtual 432	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   3825: invokestatic 436	com/tencent/mobileqq/utils/WupUtil:b	([B)[B
    //   3828: invokevirtual 437	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3831: checkcast 208	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   3834: astore_2
    //   3835: goto +60 -> 3895
    //   3838: astore_2
    //   3839: aload_2
    //   3840: invokevirtual 809	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   3843: invokestatic 55	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3846: ifeq +43 -> 3889
    //   3849: new 57	java/lang/StringBuilder
    //   3852: dup
    //   3853: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   3856: astore 19
    //   3858: aload 19
    //   3860: ldc_w 478
    //   3863: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3866: pop
    //   3867: aload 19
    //   3869: aload_2
    //   3870: invokevirtual 481	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:getMessage	()Ljava/lang/String;
    //   3873: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3876: pop
    //   3877: ldc_w 483
    //   3880: iconst_2
    //   3881: aload 19
    //   3883: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3886: invokestatic 91	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3889: iconst_0
    //   3890: istore 10
    //   3892: aload 18
    //   3894: astore_2
    //   3895: aload_2
    //   3896: ifnull +339 -> 4235
    //   3899: aload_2
    //   3900: getfield 440	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3903: invokevirtual 441	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   3906: ifeq +329 -> 4235
    //   3909: aload_2
    //   3910: getfield 440	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3913: invokevirtual 111	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3916: istore 4
    //   3918: iload 4
    //   3920: ifne +299 -> 4219
    //   3923: aload_2
    //   3924: getfield 262	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3927: invokevirtual 444	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   3930: invokevirtual 445	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   3933: invokestatic 448	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   3936: astore_2
    //   3937: aload_2
    //   3938: invokevirtual 451	java/nio/ByteBuffer:get	()B
    //   3941: istore 4
    //   3943: iload 4
    //   3945: ifne +197 -> 4142
    //   3948: aload_2
    //   3949: invokevirtual 568	java/nio/ByteBuffer:getShort	()S
    //   3952: istore 5
    //   3954: new 334	java/util/ArrayList
    //   3957: dup
    //   3958: invokespecial 335	java/util/ArrayList:<init>	()V
    //   3961: astore 18
    //   3963: iconst_0
    //   3964: istore 4
    //   3966: iload 4
    //   3968: iload 5
    //   3970: if_icmpge +42 -> 4012
    //   3973: aload_2
    //   3974: invokevirtual 568	java/nio/ByteBuffer:getShort	()S
    //   3977: newarray byte
    //   3979: astore 19
    //   3981: aload_2
    //   3982: aload 19
    //   3984: invokevirtual 560	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   3987: pop
    //   3988: aload 18
    //   3990: new 593	java/lang/String
    //   3993: dup
    //   3994: aload 19
    //   3996: invokespecial 596	java/lang/String:<init>	([B)V
    //   3999: invokevirtual 359	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   4002: pop
    //   4003: iload 4
    //   4005: iconst_1
    //   4006: iadd
    //   4007: istore 4
    //   4009: goto -43 -> 3966
    //   4012: new 334	java/util/ArrayList
    //   4015: dup
    //   4016: invokespecial 335	java/util/ArrayList:<init>	()V
    //   4019: astore 19
    //   4021: new 334	java/util/ArrayList
    //   4024: dup
    //   4025: invokespecial 335	java/util/ArrayList:<init>	()V
    //   4028: astore 20
    //   4030: aload_2
    //   4031: invokevirtual 568	java/nio/ByteBuffer:getShort	()S
    //   4034: istore 6
    //   4036: iconst_0
    //   4037: istore 4
    //   4039: iload 4
    //   4041: iload 6
    //   4043: if_icmpge +55 -> 4098
    //   4046: aload_2
    //   4047: invokevirtual 568	java/nio/ByteBuffer:getShort	()S
    //   4050: newarray byte
    //   4052: astore 21
    //   4054: aload_2
    //   4055: aload 21
    //   4057: invokevirtual 560	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   4060: pop
    //   4061: aload 19
    //   4063: new 593	java/lang/String
    //   4066: dup
    //   4067: aload 21
    //   4069: invokespecial 596	java/lang/String:<init>	([B)V
    //   4072: invokevirtual 359	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   4075: pop
    //   4076: aload 20
    //   4078: aload_2
    //   4079: invokevirtual 558	java/nio/ByteBuffer:getInt	()I
    //   4082: invokestatic 720	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   4085: invokevirtual 359	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   4088: pop
    //   4089: iload 4
    //   4091: iconst_1
    //   4092: iadd
    //   4093: istore 4
    //   4095: goto -56 -> 4039
    //   4098: iload 5
    //   4100: ifle +16 -> 4116
    //   4103: aload 17
    //   4105: ldc_w 811
    //   4108: aload 18
    //   4110: invokevirtual 815	android/os/Bundle:putStringArrayList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   4113: goto +1163 -> 5276
    //   4116: aload 17
    //   4118: ldc_w 811
    //   4121: aload 19
    //   4123: invokevirtual 815	android/os/Bundle:putStringArrayList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   4126: aload 17
    //   4128: ldc_w 817
    //   4131: aload 20
    //   4133: invokevirtual 820	android/os/Bundle:putIntegerArrayList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   4136: iconst_0
    //   4137: istore 10
    //   4139: goto +1137 -> 5276
    //   4142: aload 17
    //   4144: ldc_w 822
    //   4147: iload 4
    //   4149: invokevirtual 103	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   4152: iconst_0
    //   4153: istore 10
    //   4155: goto -911 -> 3244
    //   4158: astore_2
    //   4159: invokestatic 55	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4162: ifeq +43 -> 4205
    //   4165: new 57	java/lang/StringBuilder
    //   4168: dup
    //   4169: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   4172: astore 18
    //   4174: aload 18
    //   4176: ldc_w 824
    //   4179: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4182: pop
    //   4183: aload 18
    //   4185: aload_2
    //   4186: invokevirtual 529	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   4189: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4192: pop
    //   4193: ldc_w 483
    //   4196: iconst_2
    //   4197: aload 18
    //   4199: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4202: invokestatic 668	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   4205: aload 17
    //   4207: ldc_w 822
    //   4210: sipush -1002
    //   4213: invokevirtual 103	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   4216: goto +13 -> 4229
    //   4219: aload 17
    //   4221: ldc_w 822
    //   4224: iload 4
    //   4226: invokevirtual 103	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   4229: iconst_0
    //   4230: istore 10
    //   4232: goto -988 -> 3244
    //   4235: aload 17
    //   4237: ldc_w 822
    //   4240: sipush -1001
    //   4243: invokevirtual 103	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   4246: goto -952 -> 3294
    //   4249: iload_3
    //   4250: istore 4
    //   4252: new 533	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory
    //   4255: dup
    //   4256: invokespecial 534	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:<init>	()V
    //   4259: astore 18
    //   4261: iload_3
    //   4262: istore 4
    //   4264: aload 18
    //   4266: aload_1
    //   4267: ldc_w 536
    //   4270: iconst_0
    //   4271: invokevirtual 406	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   4274: putfield 539	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:startTime	I
    //   4277: iload_3
    //   4278: istore 4
    //   4280: aload 18
    //   4282: aload_1
    //   4283: ldc_w 541
    //   4286: ldc_w 542
    //   4289: invokevirtual 406	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   4292: putfield 545	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:endTime	I
    //   4295: iload_3
    //   4296: istore 4
    //   4298: aload 18
    //   4300: iconst_0
    //   4301: putfield 549	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:isAddFromCard	Z
    //   4304: iload_3
    //   4305: istore 4
    //   4307: aload 17
    //   4309: ldc_w 551
    //   4312: aload 18
    //   4314: invokevirtual 555	android/os/Bundle:putSerializable	(Ljava/lang/String;Ljava/io/Serializable;)V
    //   4317: iload_3
    //   4318: istore 4
    //   4320: aload_2
    //   4321: invokevirtual 432	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   4324: invokestatic 448	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   4327: astore_2
    //   4328: iload_3
    //   4329: istore 4
    //   4331: aload_2
    //   4332: invokevirtual 558	java/nio/ByteBuffer:getInt	()I
    //   4335: iconst_4
    //   4336: isub
    //   4337: newarray byte
    //   4339: astore 19
    //   4341: iload_3
    //   4342: istore 4
    //   4344: aload_2
    //   4345: aload 19
    //   4347: invokevirtual 560	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   4350: pop
    //   4351: iload_3
    //   4352: istore 4
    //   4354: new 208	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   4357: dup
    //   4358: invokespecial 209	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   4361: aload 19
    //   4363: invokevirtual 437	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   4366: checkcast 208	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   4369: getfield 262	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   4372: invokevirtual 444	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   4375: invokevirtual 445	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   4378: invokestatic 448	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   4381: astore 19
    //   4383: iload_3
    //   4384: istore 4
    //   4386: aload 19
    //   4388: invokevirtual 451	java/nio/ByteBuffer:get	()B
    //   4391: pop
    //   4392: iload_3
    //   4393: istore 4
    //   4395: aload 19
    //   4397: invokevirtual 564	java/nio/ByteBuffer:getLong	()J
    //   4400: lstore 13
    //   4402: iload_3
    //   4403: istore 4
    //   4405: aload 19
    //   4407: invokevirtual 451	java/nio/ByteBuffer:get	()B
    //   4410: pop
    //   4411: iload_3
    //   4412: istore 4
    //   4414: aload 19
    //   4416: invokevirtual 558	java/nio/ByteBuffer:getInt	()I
    //   4419: pop
    //   4420: iload_3
    //   4421: istore 4
    //   4423: aload 19
    //   4425: invokevirtual 558	java/nio/ByteBuffer:getInt	()I
    //   4428: istore 7
    //   4430: iload_3
    //   4431: istore 4
    //   4433: aload 19
    //   4435: invokevirtual 558	java/nio/ByteBuffer:getInt	()I
    //   4438: pop
    //   4439: iload_3
    //   4440: istore 4
    //   4442: aload 19
    //   4444: invokevirtual 451	java/nio/ByteBuffer:get	()B
    //   4447: ifeq +832 -> 5279
    //   4450: iconst_1
    //   4451: istore 11
    //   4453: goto +3 -> 4456
    //   4456: iload_3
    //   4457: istore 4
    //   4459: aload 19
    //   4461: invokevirtual 568	java/nio/ByteBuffer:getShort	()S
    //   4464: istore 5
    //   4466: iload_3
    //   4467: istore 4
    //   4469: aload 18
    //   4471: new 334	java/util/ArrayList
    //   4474: dup
    //   4475: iload 5
    //   4477: invokespecial 570	java/util/ArrayList:<init>	(I)V
    //   4480: putfield 573	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:richStatus	Ljava/util/ArrayList;
    //   4483: iload_3
    //   4484: istore 4
    //   4486: aload_0
    //   4487: invokevirtual 416	com/tencent/mobileqq/richstatus/StatusServlet:getAppRuntime	()Lmqq/app/AppRuntime;
    //   4490: checkcast 174	com/tencent/mobileqq/app/QQAppInterface
    //   4493: astore_2
    //   4494: iconst_0
    //   4495: istore 6
    //   4497: iload 6
    //   4499: iload 5
    //   4501: if_icmpge +160 -> 4661
    //   4504: iload_3
    //   4505: istore 4
    //   4507: aload 19
    //   4509: invokevirtual 568	java/nio/ByteBuffer:getShort	()S
    //   4512: newarray byte
    //   4514: astore 20
    //   4516: iload_3
    //   4517: istore 4
    //   4519: aload 19
    //   4521: aload 20
    //   4523: invokevirtual 560	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   4526: pop
    //   4527: iload_3
    //   4528: istore 4
    //   4530: aload 19
    //   4532: invokevirtual 568	java/nio/ByteBuffer:getShort	()S
    //   4535: newarray byte
    //   4537: astore 21
    //   4539: iload_3
    //   4540: istore 4
    //   4542: aload 19
    //   4544: aload 21
    //   4546: invokevirtual 560	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   4549: pop
    //   4550: iload_3
    //   4551: istore 4
    //   4553: aload 19
    //   4555: invokevirtual 558	java/nio/ByteBuffer:getInt	()I
    //   4558: pop
    //   4559: iload_3
    //   4560: istore 4
    //   4562: aload 19
    //   4564: invokevirtual 558	java/nio/ByteBuffer:getInt	()I
    //   4567: istore 8
    //   4569: iload_3
    //   4570: istore 4
    //   4572: aload 19
    //   4574: invokevirtual 576	java/nio/ByteBuffer:position	()I
    //   4577: istore 9
    //   4579: aload 19
    //   4581: iload 9
    //   4583: bipush 8
    //   4585: iadd
    //   4586: invokevirtual 579	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   4589: pop
    //   4590: iload 8
    //   4592: iload 7
    //   4594: if_icmple +6 -> 4600
    //   4597: goto +688 -> 5285
    //   4600: aload 21
    //   4602: invokestatic 585	com/tencent/mobileqq/richstatus/RichStatus:parseStatus	([B)Lcom/tencent/mobileqq/richstatus/RichStatus;
    //   4605: astore 21
    //   4607: aload 21
    //   4609: iload 8
    //   4611: i2l
    //   4612: putfield 588	com/tencent/mobileqq/richstatus/RichStatus:time	J
    //   4615: aload 21
    //   4617: aload 20
    //   4619: putfield 591	com/tencent/mobileqq/richstatus/RichStatus:key	[B
    //   4622: aload 21
    //   4624: getfield 591	com/tencent/mobileqq/richstatus/RichStatus:key	[B
    //   4627: ifnull +20 -> 4647
    //   4630: aload 21
    //   4632: new 593	java/lang/String
    //   4635: dup
    //   4636: aload 21
    //   4638: getfield 591	com/tencent/mobileqq/richstatus/RichStatus:key	[B
    //   4641: invokespecial 596	java/lang/String:<init>	([B)V
    //   4644: putfield 600	com/tencent/mobileqq/richstatus/RichStatus:feedsId	Ljava/lang/String;
    //   4647: aload 18
    //   4649: getfield 573	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:richStatus	Ljava/util/ArrayList;
    //   4652: aload 21
    //   4654: invokevirtual 359	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   4657: pop
    //   4658: goto +627 -> 5285
    //   4661: aload 18
    //   4663: getfield 573	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:richStatus	Ljava/util/ArrayList;
    //   4666: invokevirtual 603	java/util/ArrayList:isEmpty	()Z
    //   4669: ifeq +90 -> 4759
    //   4672: aload 18
    //   4674: getfield 539	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:startTime	I
    //   4677: ifne +82 -> 4759
    //   4680: aload 18
    //   4682: getfield 545	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:endTime	I
    //   4685: ldc_w 542
    //   4688: if_icmpne +71 -> 4759
    //   4691: aload_0
    //   4692: invokevirtual 416	com/tencent/mobileqq/richstatus/StatusServlet:getAppRuntime	()Lmqq/app/AppRuntime;
    //   4695: getstatic 606	com/tencent/mobileqq/app/QQManagerFactory:FRIENDS_MANAGER	I
    //   4698: invokevirtual 427	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   4701: checkcast 608	com/tencent/mobileqq/app/FriendsManager
    //   4704: lload 13
    //   4706: invokestatic 612	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   4709: invokevirtual 616	com/tencent/mobileqq/app/FriendsManager:f	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   4712: astore 19
    //   4714: aload 19
    //   4716: ifnull +43 -> 4759
    //   4719: getstatic 622	com/tencent/mobileqq/profilecard/bussiness/personalitysign/utils/RichStatusUtils:Companion	Lcom/tencent/mobileqq/profilecard/bussiness/personalitysign/utils/RichStatusUtils$Companion;
    //   4722: aload 19
    //   4724: invokevirtual 628	com/tencent/mobileqq/profilecard/bussiness/personalitysign/utils/RichStatusUtils$Companion:getRichStatus	(Lcom/tencent/mobileqq/data/Card;)Lcom/tencent/mobileqq/richstatus/RichStatus;
    //   4727: astore 19
    //   4729: aload 19
    //   4731: ifnull +28 -> 4759
    //   4734: aload 19
    //   4736: invokevirtual 629	com/tencent/mobileqq/richstatus/RichStatus:isEmpty	()Z
    //   4739: ifne +20 -> 4759
    //   4742: aload 18
    //   4744: getfield 573	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:richStatus	Ljava/util/ArrayList;
    //   4747: aload 19
    //   4749: invokevirtual 359	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   4752: pop
    //   4753: aload 18
    //   4755: iconst_1
    //   4756: putfield 549	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:isAddFromCard	Z
    //   4759: aload_2
    //   4760: getstatic 634	com/tencent/mobileqq/app/BusinessHandlerFactory:SIGNATURE_HANDLER	Ljava/lang/String;
    //   4763: invokevirtual 638	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(Ljava/lang/String;)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   4766: checkcast 640	com/tencent/mobileqq/app/SignatureHandler
    //   4769: astore 19
    //   4771: aload 18
    //   4773: getfield 573	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:richStatus	Ljava/util/ArrayList;
    //   4776: invokevirtual 340	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   4779: astore 20
    //   4781: aload 20
    //   4783: invokeinterface 230 1 0
    //   4788: ifeq +42 -> 4830
    //   4791: aload 20
    //   4793: invokeinterface 234 1 0
    //   4798: checkcast 581	com/tencent/mobileqq/richstatus/RichStatus
    //   4801: astore 21
    //   4803: aload 19
    //   4805: ifnull -24 -> 4781
    //   4808: aload 19
    //   4810: lload 13
    //   4812: invokestatic 612	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   4815: aload 21
    //   4817: getfield 600	com/tencent/mobileqq/richstatus/RichStatus:feedsId	Ljava/lang/String;
    //   4820: sipush 255
    //   4823: iconst_1
    //   4824: invokevirtual 643	com/tencent/mobileqq/app/SignatureHandler:a	(Ljava/lang/String;Ljava/lang/String;IZ)V
    //   4827: goto -46 -> 4781
    //   4830: aload 18
    //   4832: iload 11
    //   4834: putfield 646	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:over	Z
    //   4837: aload_2
    //   4838: getstatic 649	com/tencent/mobileqq/app/QQManagerFactory:SIGNATURE_MANAGER	I
    //   4841: invokevirtual 650	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   4844: checkcast 652	com/tencent/mobileqq/app/SignatureManager
    //   4847: astore 19
    //   4849: aload 19
    //   4851: ifnull +28 -> 4879
    //   4854: aload_2
    //   4855: invokevirtual 192	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   4858: lload 13
    //   4860: invokestatic 656	java/lang/Long:toString	(J)Ljava/lang/String;
    //   4863: invokevirtual 659	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4866: ifeq +13 -> 4879
    //   4869: aload 19
    //   4871: aload 18
    //   4873: getfield 573	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:richStatus	Ljava/util/ArrayList;
    //   4876: invokevirtual 662	com/tencent/mobileqq/app/SignatureManager:a	(Ljava/util/List;)V
    //   4879: goto +335 -> 5214
    //   4882: astore_2
    //   4883: goto +7 -> 4890
    //   4886: astore_2
    //   4887: iload 4
    //   4889: istore_3
    //   4890: aload_2
    //   4891: invokevirtual 665	java/lang/Exception:printStackTrace	()V
    //   4894: iload_3
    //   4895: istore 4
    //   4897: invokestatic 55	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4900: ifeq +126 -> 5026
    //   4903: ldc_w 483
    //   4906: iconst_2
    //   4907: aload_2
    //   4908: invokevirtual 529	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   4911: invokestatic 668	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   4914: iload_3
    //   4915: istore 4
    //   4917: goto +109 -> 5026
    //   4920: aload 17
    //   4922: ldc_w 826
    //   4925: aload_1
    //   4926: ldc_w 826
    //   4929: iconst_1
    //   4930: invokevirtual 672	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   4933: invokevirtual 98	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   4936: aload 17
    //   4938: ldc_w 828
    //   4941: aload_1
    //   4942: ldc_w 828
    //   4945: iconst_m1
    //   4946: invokevirtual 406	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   4949: invokevirtual 103	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   4952: new 726	com/qq/jce/wup/UniPacket
    //   4955: dup
    //   4956: iconst_1
    //   4957: invokespecial 729	com/qq/jce/wup/UniPacket:<init>	(Z)V
    //   4960: astore 18
    //   4962: aload 18
    //   4964: ldc_w 731
    //   4967: invokevirtual 735	com/qq/jce/wup/UniPacket:setEncodeName	(Ljava/lang/String;)V
    //   4970: aload 18
    //   4972: aload_2
    //   4973: invokevirtual 432	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   4976: invokevirtual 738	com/qq/jce/wup/UniPacket:decode	([B)V
    //   4979: aload 18
    //   4981: ldc_w 830
    //   4984: new 832	PersonalState/RespGetSameStateList
    //   4987: dup
    //   4988: invokespecial 833	PersonalState/RespGetSameStateList:<init>	()V
    //   4991: invokevirtual 747	com/qq/jce/wup/UniPacket:getByClass	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   4994: checkcast 832	PersonalState/RespGetSameStateList
    //   4997: astore_2
    //   4998: aload_2
    //   4999: getfield 834	PersonalState/RespGetSameStateList:oHead	LPersonalState/BusiRespHead;
    //   5002: getfield 756	PersonalState/BusiRespHead:iReplyCode	I
    //   5005: ifne +15 -> 5020
    //   5008: aload 17
    //   5010: ldc_w 836
    //   5013: aload_2
    //   5014: invokevirtual 555	android/os/Bundle:putSerializable	(Ljava/lang/String;Ljava/io/Serializable;)V
    //   5017: goto +6 -> 5023
    //   5020: iconst_0
    //   5021: istore 10
    //   5023: goto +191 -> 5214
    //   5026: iload 4
    //   5028: istore_3
    //   5029: iconst_0
    //   5030: istore 10
    //   5032: goto +182 -> 5214
    //   5035: iload 10
    //   5037: istore 11
    //   5039: aload_2
    //   5040: invokevirtual 432	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   5043: invokestatic 448	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   5046: astore_2
    //   5047: aload_2
    //   5048: invokevirtual 558	java/nio/ByteBuffer:getInt	()I
    //   5051: iconst_4
    //   5052: isub
    //   5053: newarray byte
    //   5055: astore 18
    //   5057: aload_2
    //   5058: aload 18
    //   5060: invokevirtual 560	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   5063: pop
    //   5064: new 208	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   5067: dup
    //   5068: invokespecial 209	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   5071: aload 18
    //   5073: invokevirtual 437	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   5076: checkcast 208	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   5079: getfield 262	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   5082: invokevirtual 444	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   5085: invokevirtual 445	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   5088: invokestatic 448	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   5091: astore_2
    //   5092: aload_2
    //   5093: invokevirtual 451	java/nio/ByteBuffer:get	()B
    //   5096: istore 5
    //   5098: aload_2
    //   5099: invokevirtual 558	java/nio/ByteBuffer:getInt	()I
    //   5102: pop
    //   5103: aload_2
    //   5104: invokevirtual 451	java/nio/ByteBuffer:get	()B
    //   5107: istore 6
    //   5109: iconst_1
    //   5110: istore 10
    //   5112: iload 6
    //   5114: iconst_1
    //   5115: if_icmpne +6 -> 5121
    //   5118: goto +6 -> 5124
    //   5121: iconst_0
    //   5122: istore 10
    //   5124: iload 5
    //   5126: ifeq +17 -> 5143
    //   5129: iconst_0
    //   5130: istore 11
    //   5132: iload 10
    //   5134: istore 12
    //   5136: iload 11
    //   5138: istore 10
    //   5140: goto +24 -> 5164
    //   5143: iload_3
    //   5144: iconst_2
    //   5145: if_icmpne +149 -> 5294
    //   5148: aload_1
    //   5149: ldc 202
    //   5151: iconst_0
    //   5152: invokevirtual 672	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   5155: istore 12
    //   5157: iload 11
    //   5159: istore 10
    //   5161: goto +3 -> 5164
    //   5164: iload 4
    //   5166: istore_3
    //   5167: aload 17
    //   5169: ldc 202
    //   5171: iload 12
    //   5173: invokevirtual 98	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   5176: goto +38 -> 5214
    //   5179: astore_2
    //   5180: goto +4 -> 5184
    //   5183: astore_2
    //   5184: aload_2
    //   5185: invokevirtual 665	java/lang/Exception:printStackTrace	()V
    //   5188: iload 4
    //   5190: istore_3
    //   5191: invokestatic 55	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5194: ifeq -165 -> 5029
    //   5197: ldc_w 483
    //   5200: iconst_2
    //   5201: aload_2
    //   5202: invokevirtual 529	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   5205: invokestatic 668	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   5208: iload 4
    //   5210: istore_3
    //   5211: goto -182 -> 5029
    //   5214: aload_0
    //   5215: aload_1
    //   5216: iload_3
    //   5217: iload 10
    //   5219: aload 17
    //   5221: ldc_w 490
    //   5224: invokevirtual 494	com/tencent/mobileqq/richstatus/StatusServlet:notifyObserver	(Landroid/content/Intent;IZLandroid/os/Bundle;Ljava/lang/Class;)V
    //   5227: return
    //   5228: astore_2
    //   5229: iload_3
    //   5230: istore 4
    //   5232: goto -206 -> 5026
    //   5235: iconst_0
    //   5236: istore 11
    //   5238: goto -3892 -> 1346
    //   5241: iload 6
    //   5243: iconst_1
    //   5244: iadd
    //   5245: istore 6
    //   5247: aload 19
    //   5249: astore 18
    //   5251: goto -3839 -> 1412
    //   5254: astore 18
    //   5256: aload 17
    //   5258: astore 20
    //   5260: aload 19
    //   5262: astore 17
    //   5264: goto -3308 -> 1956
    //   5267: iconst_0
    //   5268: istore 10
    //   5270: aload 18
    //   5272: astore_2
    //   5273: goto -2436 -> 2837
    //   5276: goto -1121 -> 4155
    //   5279: iconst_0
    //   5280: istore 11
    //   5282: goto -826 -> 4456
    //   5285: iload 6
    //   5287: iconst_1
    //   5288: iadd
    //   5289: istore 6
    //   5291: goto -794 -> 4497
    //   5294: iload 10
    //   5296: istore 12
    //   5298: iload 11
    //   5300: istore 10
    //   5302: goto -138 -> 5164
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	5305	0	this	StatusServlet
    //   0	5305	1	paramIntent	Intent
    //   0	5305	2	paramFromServiceMsg	com.tencent.qphone.base.remote.FromServiceMsg
    //   11	5219	3	i	int
    //   7	5224	4	j	int
    //   1362	3763	5	k	int
    //   1410	3880	6	m	int
    //   1302	3293	7	n	int
    //   1530	3080	8	i1	int
    //   1548	3038	9	i2	int
    //   16	5285	10	bool1	boolean
    //   86	5213	11	bool2	boolean
    //   1642	3655	12	bool3	boolean
    //   1250	3609	13	l1	long
    //   1585	5	15	l2	long
    //   25	2078	17	localObject1	Object
    //   2132	28	17	localInvalidProtocolBufferMicroException1	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
    //   2222	3041	17	localObject2	Object
    //   40	236	18	localObject3	Object
    //   288	29	18	localInvalidProtocolBufferMicroException2	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
    //   395	1537	18	str	String
    //   1935	1	18	localException1	Exception
    //   1943	36	18	localException2	Exception
    //   2147	500	18	localObject4	Object
    //   2683	1	18	localException3	Exception
    //   2770	1	18	localFromServiceMsg	com.tencent.qphone.base.remote.FromServiceMsg
    //   2775	3	18	localException4	Exception
    //   2782	2468	18	localObject5	Object
    //   5254	17	18	localException5	Exception
    //   303	592	19	localObject6	Object
    //   908	29	19	localException6	Exception
    //   1017	1645	19	localObject7	Object
    //   2672	90	19	localException7	Exception
    //   2779	2482	19	localObject8	Object
    //   425	4834	20	localObject9	Object
    //   1134	3682	21	localObject10	Object
    //   1156	765	22	localObject11	Object
    //   1026	875	23	localRspGetHistory	StatusServlet.RspGetHistory
    //   1407	476	24	localQQAppInterface	QQAppInterface
    //   1476	423	25	localObject12	Object
    // Exception table:
    //   from	to	target	type
    //   67	84	288	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   97	118	288	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   123	146	288	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   151	180	288	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   187	239	288	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   242	285	288	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   412	467	908	java/lang/Exception
    //   472	498	908	java/lang/Exception
    //   503	532	908	java/lang/Exception
    //   535	545	908	java/lang/Exception
    //   548	609	908	java/lang/Exception
    //   617	636	908	java/lang/Exception
    //   636	669	908	java/lang/Exception
    //   669	734	908	java/lang/Exception
    //   739	859	908	java/lang/Exception
    //   859	902	908	java/lang/Exception
    //   1587	1626	1927	java/lang/Exception
    //   1626	1637	1927	java/lang/Exception
    //   1655	1708	1927	java/lang/Exception
    //   1713	1723	1927	java/lang/Exception
    //   1728	1753	1927	java/lang/Exception
    //   1753	1776	1927	java/lang/Exception
    //   1776	1798	1927	java/lang/Exception
    //   1803	1822	1927	java/lang/Exception
    //   1825	1845	1927	java/lang/Exception
    //   1882	1908	1927	java/lang/Exception
    //   1019	1028	1943	java/lang/Exception
    //   1039	1052	1943	java/lang/Exception
    //   1063	1078	1943	java/lang/Exception
    //   1089	1095	1943	java/lang/Exception
    //   1106	1116	1943	java/lang/Exception
    //   1127	1136	1943	java/lang/Exception
    //   1147	1158	1943	java/lang/Exception
    //   1169	1177	1943	java/lang/Exception
    //   1188	1217	1943	java/lang/Exception
    //   1228	1234	1943	java/lang/Exception
    //   1245	1252	1943	java/lang/Exception
    //   1263	1269	1943	java/lang/Exception
    //   1280	1286	1943	java/lang/Exception
    //   1297	1304	1943	java/lang/Exception
    //   1315	1321	1943	java/lang/Exception
    //   1332	1340	1943	java/lang/Exception
    //   1357	1364	1943	java/lang/Exception
    //   1375	1389	1943	java/lang/Exception
    //   1400	1409	1943	java/lang/Exception
    //   1430	1439	1943	java/lang/Exception
    //   1450	1458	1943	java/lang/Exception
    //   1469	1478	1943	java/lang/Exception
    //   1489	1497	1943	java/lang/Exception
    //   1508	1514	1943	java/lang/Exception
    //   1525	1532	1943	java/lang/Exception
    //   1543	1550	1943	java/lang/Exception
    //   2050	2067	2132	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   2080	2121	2132	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   2307	2316	2319	java/lang/Exception
    //   2323	2332	2335	java/lang/Exception
    //   2206	2276	2339	java/lang/Exception
    //   2658	2669	2672	java/lang/Exception
    //   2533	2559	2683	java/lang/Exception
    //   2564	2577	2683	java/lang/Exception
    //   2580	2595	2683	java/lang/Exception
    //   2598	2646	2683	java/lang/Exception
    //   2688	2698	2775	java/lang/Exception
    //   2706	2725	2775	java/lang/Exception
    //   2725	2758	2775	java/lang/Exception
    //   2758	2769	2775	java/lang/Exception
    //   2784	2831	2905	java/lang/Exception
    //   2841	2850	2905	java/lang/Exception
    //   2850	2902	2905	java/lang/Exception
    //   2436	2521	2909	java/lang/Exception
    //   2976	2992	3060	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   2996	3034	3060	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3124	3140	3247	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3152	3221	3247	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3819	3835	3838	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3923	3943	4158	java/lang/Exception
    //   3948	3963	4158	java/lang/Exception
    //   3973	4003	4158	java/lang/Exception
    //   4012	4036	4158	java/lang/Exception
    //   4046	4089	4158	java/lang/Exception
    //   4103	4113	4158	java/lang/Exception
    //   4116	4136	4158	java/lang/Exception
    //   4142	4152	4158	java/lang/Exception
    //   4579	4590	4882	java/lang/Exception
    //   4600	4647	4882	java/lang/Exception
    //   4647	4658	4882	java/lang/Exception
    //   4661	4714	4882	java/lang/Exception
    //   4719	4729	4882	java/lang/Exception
    //   4734	4759	4882	java/lang/Exception
    //   4759	4781	4882	java/lang/Exception
    //   4781	4803	4882	java/lang/Exception
    //   4808	4827	4882	java/lang/Exception
    //   4830	4849	4882	java/lang/Exception
    //   4854	4879	4882	java/lang/Exception
    //   4252	4261	4886	java/lang/Exception
    //   4264	4277	4886	java/lang/Exception
    //   4280	4295	4886	java/lang/Exception
    //   4298	4304	4886	java/lang/Exception
    //   4307	4317	4886	java/lang/Exception
    //   4320	4328	4886	java/lang/Exception
    //   4331	4341	4886	java/lang/Exception
    //   4344	4351	4886	java/lang/Exception
    //   4354	4383	4886	java/lang/Exception
    //   4386	4392	4886	java/lang/Exception
    //   4395	4402	4886	java/lang/Exception
    //   4405	4411	4886	java/lang/Exception
    //   4414	4420	4886	java/lang/Exception
    //   4423	4430	4886	java/lang/Exception
    //   4433	4439	4886	java/lang/Exception
    //   4442	4450	4886	java/lang/Exception
    //   4459	4466	4886	java/lang/Exception
    //   4469	4483	4886	java/lang/Exception
    //   4486	4494	4886	java/lang/Exception
    //   4507	4516	4886	java/lang/Exception
    //   4519	4527	4886	java/lang/Exception
    //   4530	4539	4886	java/lang/Exception
    //   4542	4550	4886	java/lang/Exception
    //   4553	4559	4886	java/lang/Exception
    //   4562	4569	4886	java/lang/Exception
    //   4572	4579	4886	java/lang/Exception
    //   5148	5157	5179	java/lang/Exception
    //   5167	5176	5179	java/lang/Exception
    //   5039	5109	5183	java/lang/Exception
    //   4920	5017	5228	java/lang/Exception
    //   1554	1565	5254	java/lang/Exception
    //   1575	1582	5254	java/lang/Exception
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    Object localObject2 = (AppInterface)getAppRuntime();
    int i = paramIntent.getIntExtra("k_cmd", 0);
    Object localObject1 = "Signature.auth";
    boolean bool = true;
    int j;
    Object localObject3;
    switch (i)
    {
    default: 
      paramIntent = null;
      break;
    case 9: 
      i = paramIntent.getIntExtra("k_tpl_id", 0);
      j = paramIntent.getIntExtra("k_font_id", 0);
      int k = paramIntent.getIntExtra("k_sign_len", 2);
      localObject3 = paramIntent.getByteArrayExtra("k_sign_data");
      int m = paramIntent.getIntExtra("k_source", 0);
      paramIntent = new SigActPb.Platform();
      paramIntent.platform.set(109L);
      paramIntent.mqqver.set("8.8.17");
      paramIntent.osver.set(DeviceInfoUtil.g());
      SigActPb.SigauthReq localSigauthReq = new SigActPb.SigauthReq();
      localSigauthReq.uin_disable.set(Long.parseLong(((AppInterface)localObject2).getCurrentAccountUin()));
      localSigauthReq.itemid.set(i);
      localSigauthReq.fontid.set(j);
      localSigauthReq.data.set(ByteStringMicro.copyFrom((byte[])localObject3));
      localSigauthReq.len.set(k);
      localObject2 = new SigActPb.ReqBody();
      ((SigActPb.ReqBody)localObject2).cmd.set(2);
      ((SigActPb.ReqBody)localObject2).plf.set(paramIntent);
      ((SigActPb.ReqBody)localObject2).auth_req.set(localSigauthReq);
      ((SigActPb.ReqBody)localObject2).seq.set(System.currentTimeMillis());
      ((SigActPb.ReqBody)localObject2).source.set(m);
      paramIntent = ((SigActPb.ReqBody)localObject2).toByteArray();
      localObject2 = new byte[paramIntent.length + 4];
      PkgTools.dWord2Byte((byte[])localObject2, 0, paramIntent.length + 4);
      PkgTools.copyData((byte[])localObject2, 4, paramIntent, paramIntent.length);
      paramPacket.putSendData((byte[])localObject2);
      paramIntent = (Intent)localObject1;
      if (QLog.isColorLevel())
      {
        QLog.d("StatusServlet", 2, "Signature.auth");
        paramIntent = (Intent)localObject1;
      }
      break;
    case 8: 
      paramIntent = new oidb_sso.OIDBSSOPkg();
      paramIntent.uint32_command.set(1296);
      paramIntent.uint32_service_type.set(0);
      paramIntent.bytes_bodybuffer.set(ByteStringMicro.EMPTY);
      paramIntent = paramIntent.toByteArray();
      localObject1 = ByteBuffer.allocate(paramIntent.length + 4);
      ((ByteBuffer)localObject1).putInt(paramIntent.length + 4);
      ((ByteBuffer)localObject1).put(paramIntent);
      paramPacket.putSendData(((ByteBuffer)localObject1).array());
      if (QLog.isColorLevel()) {
        QLog.d("StatusServlet", 2, "clearRichStatus...");
      }
      paramIntent = "OidbSvc.0x510_0";
      break;
    case 7: 
      paramPacket.putSendData(a(paramIntent.getByteArrayExtra("k_data")));
      paramIntent = "OidbSvc.0x50f_29";
      break;
    case 6: 
      paramIntent = new ReqGetHotState();
      paramIntent.oHead = new BusiReqHead();
      paramPacket.setServantName("PersonalStateSvc");
      paramPacket.setFuncName("ReqGetHotState");
      paramPacket.addRequestPacket("ReqGetHotState", paramIntent);
      if (QLog.isColorLevel()) {
        QLog.d("get_hot_rich_status", 2, "StatusServlet.onSend()");
      }
      paramIntent = "PersonalStateSvc.ReqGetHotState";
      break;
    case 5: 
      localObject2 = paramIntent.getStringArrayListExtra("k_status_key");
      localObject1 = new ArrayList();
      if (localObject2 != null)
      {
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((List)localObject1).add(((String)((Iterator)localObject2).next()).getBytes());
        }
      }
      paramPacket.putSendData(a((List)localObject1, (byte)paramIntent.getIntExtra("k_status_flag", 1)));
      paramIntent = "OidbSvc.0x54f_0";
      break;
    case 4: 
      localObject1 = paramIntent.getStringExtra("k_uin");
      i = paramIntent.getIntExtra("k_end_time", 2147483647);
      j = paramIntent.getIntExtra("k_start_time", 0);
      paramPacket.putSendData(a(Long.parseLong((String)localObject1), Integer.valueOf(j).intValue(), Integer.valueOf(i).intValue()));
      paramIntent = "OidbSvc.0x53f_2";
      break;
    case 3: 
      localObject1 = new ReqGetSameStateList();
      ((ReqGetSameStateList)localObject1).oHead = new BusiReqHead();
      ((ReqGetSameStateList)localObject1).vCookie = paramIntent.getByteArrayExtra("k_cookie");
      if (((ReqGetSameStateList)localObject1).vCookie == null) {
        ((ReqGetSameStateList)localObject1).vCookie = new byte[0];
      }
      localObject3 = new RichStatus("");
      ((RichStatus)localObject3).actionText = "foo";
      ((RichStatus)localObject3).actionId = paramIntent.getIntExtra("k_action", 0);
      ((RichStatus)localObject3).dataText = "foo";
      ((RichStatus)localObject3).dataId = paramIntent.getIntExtra("k_data", 0);
      ((ReqGetSameStateList)localObject1).oSelfRishState = new stRishState(((RichStatus)localObject3).encode(), 0L);
      localObject2 = ((FriendsManager)((AppInterface)localObject2).getManager(QQManagerFactory.FRIENDS_MANAGER)).f(((AppInterface)localObject2).getCurrentAccountUin());
      if (localObject2 != null)
      {
        if (((Card)localObject2).shGender == 0)
        {
          i = 0;
          break label875;
        }
        if (((Card)localObject2).shGender == 1)
        {
          i = 1;
          break label875;
        }
      }
      i = 2;
      ((ReqGetSameStateList)localObject1).eSelfSex = i;
      ((ReqGetSameStateList)localObject1).iPageSize = 50;
      ((ReqGetSameStateList)localObject1).oLbsInfo = b(null);
      ((ReqGetSameStateList)localObject1).eFetchSex = paramIntent.getIntExtra("k_fetch_sex", -1);
      paramIntent = paramIntent.getStringExtra("k_uin");
      if (!TextUtils.isEmpty(paramIntent)) {
        try
        {
          ((ReqGetSameStateList)localObject1).lFriendUin = Long.parseLong(paramIntent);
        }
        catch (Exception paramIntent)
        {
          paramIntent.printStackTrace();
        }
      }
      paramPacket.setServantName("PersonalStateSvc");
      paramPacket.setFuncName("ReqGetSameStateList");
      paramPacket.addRequestPacket("ReqGetSameStateList", (JceStruct)localObject1);
      paramIntent = "PersonalStateSvc.ReqGetSameStateList";
      break;
    case 2: 
      paramPacket.setTimeout(10000L);
    case 1: 
      label875:
      localObject1 = paramIntent.getStringExtra("k_uin");
      if (i != 2) {
        bool = false;
      }
      paramPacket.putSendData(a(bool, paramIntent.getBooleanExtra("k_sync_ss", false), Long.parseLong((String)localObject1)));
      paramIntent = "OidbSvc.0x515_2";
    }
    if (paramIntent != null) {
      paramPacket.setSSOCommand(paramIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.StatusServlet
 * JD-Core Version:    0.7.0.1
 */