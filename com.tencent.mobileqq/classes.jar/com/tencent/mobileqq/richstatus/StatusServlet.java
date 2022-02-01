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
  static PersonalState.LBSInfo a(QQAppInterface paramQQAppInterface)
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
    //   1: ldc_w 302
    //   4: iconst_0
    //   5: invokevirtual 405	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   8: istore 4
    //   10: iload 4
    //   12: istore_3
    //   13: aload_2
    //   14: invokevirtual 410	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   17: istore 10
    //   19: new 213	android/os/Bundle
    //   22: dup
    //   23: invokespecial 411	android/os/Bundle:<init>	()V
    //   26: astore 17
    //   28: aload_0
    //   29: invokevirtual 415	com/tencent/mobileqq/richstatus/StatusServlet:getAppRuntime	()Lmqq/app/AppRuntime;
    //   32: getstatic 420	com/tencent/mobileqq/app/QQManagerFactory:STATUS_MANAGER	I
    //   35: invokevirtual 426	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   38: checkcast 428	com/tencent/mobileqq/richstatus/StatusManager
    //   41: astore 18
    //   43: aload 18
    //   45: ifnonnull +2340 -> 2385
    //   48: iload_3
    //   49: bipush 7
    //   51: if_icmpne +338 -> 389
    //   54: iload 10
    //   56: ifeq +288 -> 344
    //   59: new 327	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   62: dup
    //   63: invokespecial 328	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   66: astore 18
    //   68: aload 18
    //   70: aload_2
    //   71: invokevirtual 431	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   74: invokestatic 436	com/tencent/mobileqq/utils/WupUtil:b	([B)[B
    //   77: invokevirtual 437	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   80: checkcast 327	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   83: astore 18
    //   85: iload 10
    //   87: istore 11
    //   89: aload 18
    //   91: ifnull +282 -> 373
    //   94: iload 10
    //   96: istore 11
    //   98: aload 18
    //   100: getfield 440	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   103: invokevirtual 441	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   106: ifeq +267 -> 373
    //   109: aload 18
    //   111: getfield 440	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   114: invokevirtual 230	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   117: istore 4
    //   119: iload 4
    //   121: ifne +122 -> 243
    //   124: aload 18
    //   126: getfield 369	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   129: invokevirtual 444	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   132: invokevirtual 445	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   135: invokestatic 448	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   138: astore 18
    //   140: aload 18
    //   142: invokevirtual 451	java/nio/ByteBuffer:get	()B
    //   145: istore 4
    //   147: iload 4
    //   149: ifne +39 -> 188
    //   152: aload 17
    //   154: ldc_w 453
    //   157: aload 18
    //   159: invokevirtual 372	java/nio/ByteBuffer:array	()[B
    //   162: invokevirtual 457	android/os/Bundle:putByteArray	(Ljava/lang/String;[B)V
    //   165: aload 17
    //   167: ldc_w 459
    //   170: aload_1
    //   171: ldc_w 459
    //   174: iconst_0
    //   175: invokevirtual 405	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   178: invokevirtual 222	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   181: iload 10
    //   183: istore 11
    //   185: goto +188 -> 373
    //   188: new 177	java/lang/StringBuilder
    //   191: dup
    //   192: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   195: astore 18
    //   197: aload 18
    //   199: ldc_w 461
    //   202: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: pop
    //   206: aload 18
    //   208: iload 4
    //   210: invokevirtual 196	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   213: pop
    //   214: aconst_null
    //   215: ldc_w 463
    //   218: ldc_w 465
    //   221: aload 18
    //   223: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   226: aconst_null
    //   227: fconst_0
    //   228: invokestatic 470	com/tencent/mobileqq/vas/VasMonitorHandler:a	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;F)V
    //   231: ldc_w 463
    //   234: ldc_w 465
    //   237: invokestatic 474	com/tencent/mobileqq/vas/util/VasMonitorDT:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   240: goto +98 -> 338
    //   243: new 177	java/lang/StringBuilder
    //   246: dup
    //   247: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   250: astore 18
    //   252: aload 18
    //   254: ldc_w 461
    //   257: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: pop
    //   261: aload 18
    //   263: iload 4
    //   265: invokevirtual 196	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   268: pop
    //   269: aconst_null
    //   270: ldc_w 463
    //   273: ldc_w 476
    //   276: aload 18
    //   278: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   281: aconst_null
    //   282: fconst_0
    //   283: invokestatic 470	com/tencent/mobileqq/vas/VasMonitorHandler:a	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;F)V
    //   286: goto +52 -> 338
    //   289: astore 18
    //   291: invokestatic 175	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   294: ifeq +44 -> 338
    //   297: new 177	java/lang/StringBuilder
    //   300: dup
    //   301: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   304: astore 19
    //   306: aload 19
    //   308: ldc_w 478
    //   311: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: pop
    //   315: aload 19
    //   317: aload 18
    //   319: invokevirtual 481	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:getMessage	()Ljava/lang/String;
    //   322: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: pop
    //   326: ldc_w 483
    //   329: iconst_2
    //   330: aload 19
    //   332: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   335: invokestatic 210	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   338: iconst_0
    //   339: istore 11
    //   341: goto +32 -> 373
    //   344: aconst_null
    //   345: ldc_w 463
    //   348: ldc_w 485
    //   351: aload_2
    //   352: invokevirtual 488	com/tencent/qphone/base/remote/FromServiceMsg:getBusinessFailMsg	()Ljava/lang/String;
    //   355: aconst_null
    //   356: fconst_0
    //   357: invokestatic 470	com/tencent/mobileqq/vas/VasMonitorHandler:a	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;F)V
    //   360: ldc_w 463
    //   363: ldc_w 485
    //   366: invokestatic 474	com/tencent/mobileqq/vas/util/VasMonitorDT:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   369: iload 10
    //   371: istore 11
    //   373: aload_0
    //   374: aload_1
    //   375: iload_3
    //   376: iload 11
    //   378: aload 17
    //   380: ldc_w 490
    //   383: invokevirtual 494	com/tencent/mobileqq/richstatus/StatusServlet:notifyObserver	(Landroid/content/Intent;IZLandroid/os/Bundle;Ljava/lang/Class;)V
    //   386: goto +7 -> 393
    //   389: iload 10
    //   391: istore 11
    //   393: ldc_w 478
    //   396: astore 18
    //   398: iload 11
    //   400: istore 10
    //   402: iload_3
    //   403: bipush 9
    //   405: if_icmpne +603 -> 1008
    //   408: iload 11
    //   410: ifeq +558 -> 968
    //   413: aload_2
    //   414: invokevirtual 431	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   417: arraylength
    //   418: iconst_4
    //   419: isub
    //   420: istore 4
    //   422: iload 4
    //   424: newarray byte
    //   426: astore 20
    //   428: aload 20
    //   430: iconst_0
    //   431: aload_2
    //   432: invokevirtual 431	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   435: iconst_4
    //   436: iload 4
    //   438: invokestatic 500	com/tencent/mobileqq/utils/httputils/PkgTools:copyData	([BI[BII)V
    //   441: new 134	com/tencent/pb/signature/SigActPb$RspBody
    //   444: dup
    //   445: invokespecial 501	com/tencent/pb/signature/SigActPb$RspBody:<init>	()V
    //   448: astore 19
    //   450: aload 19
    //   452: aload 20
    //   454: invokevirtual 502	com/tencent/pb/signature/SigActPb$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   457: pop
    //   458: aload 19
    //   460: getfield 503	com/tencent/pb/signature/SigActPb$RspBody:ret	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   463: invokevirtual 193	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   466: istore 4
    //   468: iload 4
    //   470: ifne +79 -> 549
    //   473: aload 19
    //   475: getfield 138	com/tencent/pb/signature/SigActPb$RspBody:auth_rsp	Lcom/tencent/pb/signature/SigActPb$SigauthRsp;
    //   478: getfield 506	com/tencent/pb/signature/SigActPb$SigauthRsp:result	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   481: invokevirtual 444	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   484: invokevirtual 445	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   487: invokestatic 448	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   490: astore 19
    //   492: aload 19
    //   494: invokevirtual 451	java/nio/ByteBuffer:get	()B
    //   497: istore 4
    //   499: iload 4
    //   501: ifne +35 -> 536
    //   504: aload 17
    //   506: ldc_w 453
    //   509: aload 19
    //   511: invokevirtual 372	java/nio/ByteBuffer:array	()[B
    //   514: invokevirtual 457	android/os/Bundle:putByteArray	(Ljava/lang/String;[B)V
    //   517: aload 17
    //   519: ldc_w 459
    //   522: aload_1
    //   523: ldc_w 459
    //   526: iconst_0
    //   527: invokevirtual 405	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   530: invokevirtual 222	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   533: goto +458 -> 991
    //   536: aload 17
    //   538: ldc_w 508
    //   541: iload 4
    //   543: invokevirtual 222	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   546: goto +361 -> 907
    //   549: new 177	java/lang/StringBuilder
    //   552: dup
    //   553: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   556: astore 20
    //   558: aload 20
    //   560: ldc_w 461
    //   563: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   566: pop
    //   567: aload 20
    //   569: iload 4
    //   571: invokevirtual 196	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   574: pop
    //   575: aconst_null
    //   576: ldc_w 510
    //   579: ldc_w 512
    //   582: aload 20
    //   584: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   587: aconst_null
    //   588: fconst_0
    //   589: invokestatic 470	com/tencent/mobileqq/vas/VasMonitorHandler:a	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;F)V
    //   592: ldc_w 510
    //   595: iload 4
    //   597: invokestatic 514	com/tencent/mobileqq/vas/util/VasMonitorDT:a	(Ljava/lang/String;I)V
    //   600: aload 17
    //   602: ldc_w 516
    //   605: iload 4
    //   607: invokevirtual 222	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   610: iload 4
    //   612: ldc_w 517
    //   615: if_icmpne +22 -> 637
    //   618: aload 17
    //   620: ldc_w 519
    //   623: aload 19
    //   625: getfield 138	com/tencent/pb/signature/SigActPb$RspBody:auth_rsp	Lcom/tencent/pb/signature/SigActPb$SigauthRsp;
    //   628: getfield 520	com/tencent/pb/signature/SigActPb$SigauthRsp:url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   631: invokevirtual 240	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   634: invokevirtual 244	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   637: aload 19
    //   639: getfield 138	com/tencent/pb/signature/SigActPb$RspBody:auth_rsp	Lcom/tencent/pb/signature/SigActPb$SigauthRsp;
    //   642: getfield 523	com/tencent/pb/signature/SigActPb$SigauthRsp:authfailed_appid	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   645: invokevirtual 524	com/tencent/mobileqq/pb/PBInt32Field:has	()Z
    //   648: ifeq +22 -> 670
    //   651: aload 17
    //   653: ldc_w 526
    //   656: aload 19
    //   658: getfield 138	com/tencent/pb/signature/SigActPb$RspBody:auth_rsp	Lcom/tencent/pb/signature/SigActPb$SigauthRsp;
    //   661: getfield 523	com/tencent/pb/signature/SigActPb$SigauthRsp:authfailed_appid	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   664: invokevirtual 193	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   667: invokevirtual 222	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   670: aload 19
    //   672: getfield 138	com/tencent/pb/signature/SigActPb$RspBody:auth_rsp	Lcom/tencent/pb/signature/SigActPb$SigauthRsp;
    //   675: getfield 144	com/tencent/pb/signature/SigActPb$SigauthRsp:tips_info	Lcom/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo;
    //   678: invokevirtual 149	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo:has	()Z
    //   681: ifeq +226 -> 907
    //   684: new 146	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo
    //   687: dup
    //   688: invokespecial 150	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo:<init>	()V
    //   691: astore 20
    //   693: aload 20
    //   695: aload 19
    //   697: getfield 138	com/tencent/pb/signature/SigActPb$RspBody:auth_rsp	Lcom/tencent/pb/signature/SigActPb$SigauthRsp;
    //   700: getfield 144	com/tencent/pb/signature/SigActPb$SigauthRsp:tips_info	Lcom/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo;
    //   703: invokevirtual 154	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   706: checkcast 146	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo
    //   709: invokevirtual 158	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo:toByteArray	()[B
    //   712: invokevirtual 162	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   715: pop
    //   716: aload 20
    //   718: getfield 166	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo:valid	Lcom/tencent/mobileqq/pb/PBBoolField;
    //   721: invokevirtual 170	com/tencent/mobileqq/pb/PBBoolField:get	()Z
    //   724: istore 10
    //   726: aload 17
    //   728: ldc 211
    //   730: iload 10
    //   732: invokevirtual 217	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   735: iload 10
    //   737: ifeq +126 -> 863
    //   740: aload 17
    //   742: ldc 224
    //   744: aload 20
    //   746: getfield 227	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo:type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   749: invokevirtual 230	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   752: invokevirtual 222	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   755: aload 17
    //   757: ldc 232
    //   759: aload 20
    //   761: getfield 236	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo:title_wording	Lcom/tencent/mobileqq/pb/PBStringField;
    //   764: invokevirtual 240	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   767: invokevirtual 244	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   770: aload 17
    //   772: ldc 246
    //   774: aload 20
    //   776: getfield 248	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo:wording	Lcom/tencent/mobileqq/pb/PBStringField;
    //   779: invokevirtual 240	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   782: invokevirtual 244	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   785: aload 17
    //   787: ldc 250
    //   789: aload 20
    //   791: getfield 253	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo:right_btn_wording	Lcom/tencent/mobileqq/pb/PBStringField;
    //   794: invokevirtual 240	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   797: invokevirtual 244	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   800: aload 17
    //   802: ldc 255
    //   804: aload 20
    //   806: getfield 258	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo:left_btn_wording	Lcom/tencent/mobileqq/pb/PBStringField;
    //   809: invokevirtual 240	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   812: invokevirtual 244	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   815: aload 17
    //   817: ldc_w 260
    //   820: aload 20
    //   822: getfield 263	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo:vip_type	Lcom/tencent/mobileqq/pb/PBStringField;
    //   825: invokevirtual 240	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   828: invokevirtual 244	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   831: aload 17
    //   833: ldc_w 265
    //   836: aload 20
    //   838: getfield 268	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo:vip_month	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   841: invokevirtual 230	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   844: invokevirtual 222	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   847: aload 17
    //   849: ldc_w 270
    //   852: aload 20
    //   854: getfield 272	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo:url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   857: invokevirtual 240	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   860: invokevirtual 244	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   863: invokestatic 175	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   866: ifeq +41 -> 907
    //   869: new 177	java/lang/StringBuilder
    //   872: dup
    //   873: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   876: astore 19
    //   878: aload 19
    //   880: ldc_w 528
    //   883: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   886: pop
    //   887: aload 19
    //   889: aload 17
    //   891: invokevirtual 279	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   894: pop
    //   895: ldc_w 281
    //   898: iconst_2
    //   899: aload 19
    //   901: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   904: invokestatic 284	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   907: iconst_0
    //   908: istore 11
    //   910: goto +81 -> 991
    //   913: astore 19
    //   915: invokestatic 175	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   918: ifeq +44 -> 962
    //   921: new 177	java/lang/StringBuilder
    //   924: dup
    //   925: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   928: astore 20
    //   930: aload 20
    //   932: ldc_w 478
    //   935: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   938: pop
    //   939: aload 20
    //   941: aload 19
    //   943: invokevirtual 529	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   946: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   949: pop
    //   950: ldc_w 483
    //   953: iconst_2
    //   954: aload 20
    //   956: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   959: invokestatic 210	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   962: iconst_0
    //   963: istore 10
    //   965: goto +30 -> 995
    //   968: aconst_null
    //   969: ldc_w 510
    //   972: ldc_w 531
    //   975: aload_2
    //   976: invokevirtual 488	com/tencent/qphone/base/remote/FromServiceMsg:getBusinessFailMsg	()Ljava/lang/String;
    //   979: aconst_null
    //   980: fconst_0
    //   981: invokestatic 470	com/tencent/mobileqq/vas/VasMonitorHandler:a	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;F)V
    //   984: ldc_w 510
    //   987: iconst_m1
    //   988: invokestatic 514	com/tencent/mobileqq/vas/util/VasMonitorDT:a	(Ljava/lang/String;I)V
    //   991: iload 11
    //   993: istore 10
    //   995: aload_0
    //   996: aload_1
    //   997: iload_3
    //   998: iload 10
    //   1000: aload 17
    //   1002: ldc_w 490
    //   1005: invokevirtual 494	com/tencent/mobileqq/richstatus/StatusServlet:notifyObserver	(Landroid/content/Intent;IZLandroid/os/Bundle;Ljava/lang/Class;)V
    //   1008: iload_3
    //   1009: iconst_4
    //   1010: if_icmpne +1008 -> 2018
    //   1013: aload 18
    //   1015: astore 20
    //   1017: iload_3
    //   1018: istore 4
    //   1020: aload 17
    //   1022: astore 19
    //   1024: new 533	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory
    //   1027: dup
    //   1028: invokespecial 534	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:<init>	()V
    //   1031: astore 23
    //   1033: aload 18
    //   1035: astore 20
    //   1037: iload_3
    //   1038: istore 4
    //   1040: aload 17
    //   1042: astore 19
    //   1044: aload 23
    //   1046: aload_1
    //   1047: ldc_w 536
    //   1050: iconst_0
    //   1051: invokevirtual 405	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   1054: putfield 539	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:startTime	I
    //   1057: aload 18
    //   1059: astore 20
    //   1061: iload_3
    //   1062: istore 4
    //   1064: aload 17
    //   1066: astore 19
    //   1068: aload 23
    //   1070: aload_1
    //   1071: ldc_w 541
    //   1074: ldc_w 542
    //   1077: invokevirtual 405	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   1080: putfield 545	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:endTime	I
    //   1083: aload 18
    //   1085: astore 20
    //   1087: iload_3
    //   1088: istore 4
    //   1090: aload 17
    //   1092: astore 19
    //   1094: aload 23
    //   1096: iconst_0
    //   1097: putfield 549	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:isAddFromCard	Z
    //   1100: aload 18
    //   1102: astore 20
    //   1104: iload_3
    //   1105: istore 4
    //   1107: aload 17
    //   1109: astore 19
    //   1111: aload 17
    //   1113: ldc_w 551
    //   1116: aload 23
    //   1118: invokevirtual 555	android/os/Bundle:putSerializable	(Ljava/lang/String;Ljava/io/Serializable;)V
    //   1121: aload 18
    //   1123: astore 20
    //   1125: iload_3
    //   1126: istore 4
    //   1128: aload 17
    //   1130: astore 19
    //   1132: aload_2
    //   1133: invokevirtual 431	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   1136: invokestatic 448	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   1139: astore 21
    //   1141: aload 18
    //   1143: astore 20
    //   1145: iload_3
    //   1146: istore 4
    //   1148: aload 17
    //   1150: astore 19
    //   1152: aload 21
    //   1154: invokevirtual 558	java/nio/ByteBuffer:getInt	()I
    //   1157: iconst_4
    //   1158: isub
    //   1159: newarray byte
    //   1161: astore 22
    //   1163: aload 18
    //   1165: astore 20
    //   1167: iload_3
    //   1168: istore 4
    //   1170: aload 17
    //   1172: astore 19
    //   1174: aload 21
    //   1176: aload 22
    //   1178: invokevirtual 560	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   1181: pop
    //   1182: aload 18
    //   1184: astore 20
    //   1186: iload_3
    //   1187: istore 4
    //   1189: aload 17
    //   1191: astore 19
    //   1193: new 327	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   1196: dup
    //   1197: invokespecial 328	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   1200: aload 22
    //   1202: invokevirtual 437	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1205: checkcast 327	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   1208: getfield 369	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1211: invokevirtual 444	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1214: invokevirtual 445	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   1217: invokestatic 448	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   1220: astore 21
    //   1222: aload 18
    //   1224: astore 20
    //   1226: iload_3
    //   1227: istore 4
    //   1229: aload 17
    //   1231: astore 19
    //   1233: aload 21
    //   1235: invokevirtual 451	java/nio/ByteBuffer:get	()B
    //   1238: pop
    //   1239: aload 18
    //   1241: astore 20
    //   1243: iload_3
    //   1244: istore 4
    //   1246: aload 17
    //   1248: astore 19
    //   1250: aload 21
    //   1252: invokevirtual 564	java/nio/ByteBuffer:getLong	()J
    //   1255: lstore 13
    //   1257: aload 18
    //   1259: astore 20
    //   1261: iload_3
    //   1262: istore 4
    //   1264: aload 17
    //   1266: astore 19
    //   1268: aload 21
    //   1270: invokevirtual 451	java/nio/ByteBuffer:get	()B
    //   1273: pop
    //   1274: aload 18
    //   1276: astore 20
    //   1278: iload_3
    //   1279: istore 4
    //   1281: aload 17
    //   1283: astore 19
    //   1285: aload 21
    //   1287: invokevirtual 558	java/nio/ByteBuffer:getInt	()I
    //   1290: pop
    //   1291: aload 18
    //   1293: astore 20
    //   1295: iload_3
    //   1296: istore 4
    //   1298: aload 17
    //   1300: astore 19
    //   1302: aload 21
    //   1304: invokevirtual 558	java/nio/ByteBuffer:getInt	()I
    //   1307: istore 7
    //   1309: aload 18
    //   1311: astore 20
    //   1313: iload_3
    //   1314: istore 4
    //   1316: aload 17
    //   1318: astore 19
    //   1320: aload 21
    //   1322: invokevirtual 558	java/nio/ByteBuffer:getInt	()I
    //   1325: pop
    //   1326: aload 18
    //   1328: astore 20
    //   1330: iload_3
    //   1331: istore 4
    //   1333: aload 17
    //   1335: astore 19
    //   1337: aload 21
    //   1339: invokevirtual 451	java/nio/ByteBuffer:get	()B
    //   1342: ifeq +3904 -> 5246
    //   1345: iconst_1
    //   1346: istore 11
    //   1348: goto +3 -> 1351
    //   1351: aload 18
    //   1353: astore 20
    //   1355: iload_3
    //   1356: istore 4
    //   1358: aload 17
    //   1360: astore 19
    //   1362: aload 21
    //   1364: invokevirtual 568	java/nio/ByteBuffer:getShort	()S
    //   1367: istore 5
    //   1369: aload 18
    //   1371: astore 20
    //   1373: iload_3
    //   1374: istore 4
    //   1376: aload 17
    //   1378: astore 19
    //   1380: aload 23
    //   1382: new 65	java/util/ArrayList
    //   1385: dup
    //   1386: iload 5
    //   1388: invokespecial 570	java/util/ArrayList:<init>	(I)V
    //   1391: putfield 573	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:richStatus	Ljava/util/ArrayList;
    //   1394: aload 18
    //   1396: astore 20
    //   1398: iload_3
    //   1399: istore 4
    //   1401: aload 17
    //   1403: astore 19
    //   1405: aload_0
    //   1406: invokevirtual 415	com/tencent/mobileqq/richstatus/StatusServlet:getAppRuntime	()Lmqq/app/AppRuntime;
    //   1409: checkcast 293	com/tencent/mobileqq/app/QQAppInterface
    //   1412: astore 24
    //   1414: iconst_0
    //   1415: istore 6
    //   1417: iload 6
    //   1419: iload 5
    //   1421: if_icmpge +224 -> 1645
    //   1424: aload 18
    //   1426: astore 20
    //   1428: iload_3
    //   1429: istore 4
    //   1431: aload 17
    //   1433: astore 19
    //   1435: aload 21
    //   1437: invokevirtual 568	java/nio/ByteBuffer:getShort	()S
    //   1440: newarray byte
    //   1442: astore 22
    //   1444: aload 18
    //   1446: astore 20
    //   1448: iload_3
    //   1449: istore 4
    //   1451: aload 17
    //   1453: astore 19
    //   1455: aload 21
    //   1457: aload 22
    //   1459: invokevirtual 560	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   1462: pop
    //   1463: aload 18
    //   1465: astore 20
    //   1467: iload_3
    //   1468: istore 4
    //   1470: aload 17
    //   1472: astore 19
    //   1474: aload 21
    //   1476: invokevirtual 568	java/nio/ByteBuffer:getShort	()S
    //   1479: newarray byte
    //   1481: astore 25
    //   1483: aload 18
    //   1485: astore 20
    //   1487: iload_3
    //   1488: istore 4
    //   1490: aload 17
    //   1492: astore 19
    //   1494: aload 21
    //   1496: aload 25
    //   1498: invokevirtual 560	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   1501: pop
    //   1502: aload 18
    //   1504: astore 20
    //   1506: iload_3
    //   1507: istore 4
    //   1509: aload 17
    //   1511: astore 19
    //   1513: aload 21
    //   1515: invokevirtual 558	java/nio/ByteBuffer:getInt	()I
    //   1518: pop
    //   1519: aload 18
    //   1521: astore 20
    //   1523: iload_3
    //   1524: istore 4
    //   1526: aload 17
    //   1528: astore 19
    //   1530: aload 21
    //   1532: invokevirtual 558	java/nio/ByteBuffer:getInt	()I
    //   1535: istore 8
    //   1537: aload 18
    //   1539: astore 20
    //   1541: iload_3
    //   1542: istore 4
    //   1544: aload 17
    //   1546: astore 19
    //   1548: aload 21
    //   1550: invokevirtual 576	java/nio/ByteBuffer:position	()I
    //   1553: istore 9
    //   1555: aload 18
    //   1557: astore 19
    //   1559: aload 21
    //   1561: iload 9
    //   1563: bipush 8
    //   1565: iadd
    //   1566: invokevirtual 579	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   1569: pop
    //   1570: iload 8
    //   1572: iload 7
    //   1574: if_icmple +6 -> 1580
    //   1577: goto +3675 -> 5252
    //   1580: aload 25
    //   1582: invokestatic 585	com/tencent/mobileqq/richstatus/RichStatus:parseStatus	([B)Lcom/tencent/mobileqq/richstatus/RichStatus;
    //   1585: astore 20
    //   1587: iload 8
    //   1589: i2l
    //   1590: lstore 15
    //   1592: aload 20
    //   1594: lload 15
    //   1596: putfield 588	com/tencent/mobileqq/richstatus/RichStatus:time	J
    //   1599: aload 20
    //   1601: aload 22
    //   1603: putfield 591	com/tencent/mobileqq/richstatus/RichStatus:key	[B
    //   1606: aload 20
    //   1608: getfield 591	com/tencent/mobileqq/richstatus/RichStatus:key	[B
    //   1611: ifnull +20 -> 1631
    //   1614: aload 20
    //   1616: new 593	java/lang/String
    //   1619: dup
    //   1620: aload 20
    //   1622: getfield 591	com/tencent/mobileqq/richstatus/RichStatus:key	[B
    //   1625: invokespecial 596	java/lang/String:<init>	([B)V
    //   1628: putfield 600	com/tencent/mobileqq/richstatus/RichStatus:feedsId	Ljava/lang/String;
    //   1631: aload 23
    //   1633: getfield 573	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:richStatus	Ljava/util/ArrayList;
    //   1636: aload 20
    //   1638: invokevirtual 103	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1641: pop
    //   1642: goto +3610 -> 5252
    //   1645: iload 10
    //   1647: istore 12
    //   1649: aload 18
    //   1651: astore 21
    //   1653: iload_3
    //   1654: istore 5
    //   1656: aload 17
    //   1658: astore 22
    //   1660: aload 23
    //   1662: getfield 573	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:richStatus	Ljava/util/ArrayList;
    //   1665: invokevirtual 603	java/util/ArrayList:isEmpty	()Z
    //   1668: ifeq +90 -> 1758
    //   1671: aload 23
    //   1673: getfield 539	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:startTime	I
    //   1676: ifne +82 -> 1758
    //   1679: aload 23
    //   1681: getfield 545	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:endTime	I
    //   1684: ldc_w 542
    //   1687: if_icmpne +71 -> 1758
    //   1690: aload_0
    //   1691: invokevirtual 415	com/tencent/mobileqq/richstatus/StatusServlet:getAppRuntime	()Lmqq/app/AppRuntime;
    //   1694: getstatic 606	com/tencent/mobileqq/app/QQManagerFactory:FRIENDS_MANAGER	I
    //   1697: invokevirtual 426	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   1700: checkcast 608	com/tencent/mobileqq/app/FriendsManager
    //   1703: lload 13
    //   1705: invokestatic 612	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1708: invokevirtual 615	com/tencent/mobileqq/app/FriendsManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   1711: astore 19
    //   1713: aload 19
    //   1715: ifnull +43 -> 1758
    //   1718: getstatic 621	com/tencent/mobileqq/profilecard/bussiness/personalitysign/utils/RichStatusUtils:Companion	Lcom/tencent/mobileqq/profilecard/bussiness/personalitysign/utils/RichStatusUtils$Companion;
    //   1721: aload 19
    //   1723: invokevirtual 627	com/tencent/mobileqq/profilecard/bussiness/personalitysign/utils/RichStatusUtils$Companion:getRichStatus	(Lcom/tencent/mobileqq/data/Card;)Lcom/tencent/mobileqq/richstatus/RichStatus;
    //   1726: astore 19
    //   1728: aload 19
    //   1730: ifnull +28 -> 1758
    //   1733: aload 19
    //   1735: invokevirtual 628	com/tencent/mobileqq/richstatus/RichStatus:isEmpty	()Z
    //   1738: ifne +20 -> 1758
    //   1741: aload 23
    //   1743: getfield 573	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:richStatus	Ljava/util/ArrayList;
    //   1746: aload 19
    //   1748: invokevirtual 103	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1751: pop
    //   1752: aload 23
    //   1754: iconst_1
    //   1755: putfield 549	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:isAddFromCard	Z
    //   1758: aload 24
    //   1760: getstatic 633	com/tencent/mobileqq/app/BusinessHandlerFactory:SIGNATURE_HANDLER	Ljava/lang/String;
    //   1763: invokevirtual 637	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(Ljava/lang/String;)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   1766: checkcast 639	com/tencent/mobileqq/app/SignatureHandler
    //   1769: astore 19
    //   1771: aload 23
    //   1773: getfield 573	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:richStatus	Ljava/util/ArrayList;
    //   1776: invokevirtual 74	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   1779: astore 20
    //   1781: aload 20
    //   1783: invokeinterface 80 1 0
    //   1788: ifeq +42 -> 1830
    //   1791: aload 20
    //   1793: invokeinterface 84 1 0
    //   1798: checkcast 581	com/tencent/mobileqq/richstatus/RichStatus
    //   1801: astore 25
    //   1803: aload 19
    //   1805: ifnull -24 -> 1781
    //   1808: aload 19
    //   1810: lload 13
    //   1812: invokestatic 612	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1815: aload 25
    //   1817: getfield 600	com/tencent/mobileqq/richstatus/RichStatus:feedsId	Ljava/lang/String;
    //   1820: sipush 255
    //   1823: iconst_1
    //   1824: invokevirtual 642	com/tencent/mobileqq/app/SignatureHandler:a	(Ljava/lang/String;Ljava/lang/String;IZ)V
    //   1827: goto -46 -> 1781
    //   1830: aload 23
    //   1832: iload 11
    //   1834: putfield 645	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:over	Z
    //   1837: aload 24
    //   1839: getstatic 648	com/tencent/mobileqq/app/QQManagerFactory:SIGNATURE_MANAGER	I
    //   1842: invokevirtual 649	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1845: checkcast 651	com/tencent/mobileqq/app/SignatureManager
    //   1848: astore 25
    //   1850: iload 12
    //   1852: istore 10
    //   1854: iload 5
    //   1856: istore 4
    //   1858: aload 21
    //   1860: astore 20
    //   1862: aload 22
    //   1864: astore 19
    //   1866: aload 25
    //   1868: ifnull +130 -> 1998
    //   1871: iload 12
    //   1873: istore 10
    //   1875: iload 5
    //   1877: istore 4
    //   1879: aload 21
    //   1881: astore 20
    //   1883: aload 22
    //   1885: astore 19
    //   1887: aload 24
    //   1889: invokevirtual 311	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1892: lload 13
    //   1894: invokestatic 655	java/lang/Long:toString	(J)Ljava/lang/String;
    //   1897: invokevirtual 658	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1900: ifeq +98 -> 1998
    //   1903: aload 25
    //   1905: aload 23
    //   1907: getfield 573	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:richStatus	Ljava/util/ArrayList;
    //   1910: invokevirtual 661	com/tencent/mobileqq/app/SignatureManager:a	(Ljava/util/List;)V
    //   1913: iload 12
    //   1915: istore 10
    //   1917: iload 5
    //   1919: istore 4
    //   1921: aload 21
    //   1923: astore 20
    //   1925: aload 22
    //   1927: astore 19
    //   1929: goto +69 -> 1998
    //   1932: aload 17
    //   1934: astore 19
    //   1936: aload 18
    //   1938: astore 17
    //   1940: astore 18
    //   1942: iload_3
    //   1943: istore 4
    //   1945: goto +23 -> 1968
    //   1948: astore 18
    //   1950: aload 20
    //   1952: astore 17
    //   1954: aload 19
    //   1956: astore 20
    //   1958: iload 4
    //   1960: istore_3
    //   1961: aload 20
    //   1963: astore 19
    //   1965: iload_3
    //   1966: istore 4
    //   1968: aload 18
    //   1970: invokevirtual 664	java/lang/Exception:printStackTrace	()V
    //   1973: invokestatic 175	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1976: ifeq +15 -> 1991
    //   1979: ldc_w 483
    //   1982: iconst_2
    //   1983: aload 18
    //   1985: invokevirtual 529	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1988: invokestatic 667	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1991: iconst_0
    //   1992: istore 10
    //   1994: aload 17
    //   1996: astore 20
    //   1998: aload_0
    //   1999: aload_1
    //   2000: iload 4
    //   2002: iload 10
    //   2004: aload 19
    //   2006: ldc_w 490
    //   2009: invokevirtual 494	com/tencent/mobileqq/richstatus/StatusServlet:notifyObserver	(Landroid/content/Intent;IZLandroid/os/Bundle;Ljava/lang/Class;)V
    //   2012: iload 4
    //   2014: istore_3
    //   2015: goto +12 -> 2027
    //   2018: ldc_w 478
    //   2021: astore 20
    //   2023: aload 17
    //   2025: astore 19
    //   2027: iload 10
    //   2029: istore 11
    //   2031: iload_3
    //   2032: bipush 8
    //   2034: if_icmpne +167 -> 2201
    //   2037: iload 10
    //   2039: istore 11
    //   2041: iload 10
    //   2043: ifeq +145 -> 2188
    //   2046: new 327	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   2049: dup
    //   2050: invokespecial 328	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   2053: astore 17
    //   2055: aload 17
    //   2057: aload_2
    //   2058: invokevirtual 431	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   2061: invokestatic 436	com/tencent/mobileqq/utils/WupUtil:b	([B)[B
    //   2064: invokevirtual 437	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2067: checkcast 327	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   2070: astore 17
    //   2072: iload 10
    //   2074: istore 11
    //   2076: aload 17
    //   2078: ifnull +110 -> 2188
    //   2081: iload 10
    //   2083: istore 11
    //   2085: aload 17
    //   2087: getfield 440	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2090: invokevirtual 441	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   2093: ifeq +95 -> 2188
    //   2096: aload 17
    //   2098: getfield 440	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2101: invokevirtual 230	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2104: ifne +81 -> 2185
    //   2107: aload 17
    //   2109: getfield 369	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   2112: invokevirtual 444	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   2115: invokevirtual 445	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   2118: invokestatic 448	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   2121: invokevirtual 451	java/nio/ByteBuffer:get	()B
    //   2124: istore 4
    //   2126: iload 4
    //   2128: ifne +57 -> 2185
    //   2131: iconst_1
    //   2132: istore 11
    //   2134: goto +54 -> 2188
    //   2137: astore 17
    //   2139: invokestatic 175	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2142: ifeq +43 -> 2185
    //   2145: new 177	java/lang/StringBuilder
    //   2148: dup
    //   2149: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   2152: astore 18
    //   2154: aload 18
    //   2156: aload 20
    //   2158: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2161: pop
    //   2162: aload 18
    //   2164: aload 17
    //   2166: invokevirtual 481	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:getMessage	()Ljava/lang/String;
    //   2169: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2172: pop
    //   2173: ldc_w 483
    //   2176: iconst_2
    //   2177: aload 18
    //   2179: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2182: invokestatic 210	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2185: iconst_0
    //   2186: istore 11
    //   2188: aload_0
    //   2189: aload_1
    //   2190: iload_3
    //   2191: iload 11
    //   2193: aload 19
    //   2195: ldc_w 490
    //   2198: invokevirtual 494	com/tencent/mobileqq/richstatus/StatusServlet:notifyObserver	(Landroid/content/Intent;IZLandroid/os/Bundle;Ljava/lang/Class;)V
    //   2201: iload_3
    //   2202: iconst_1
    //   2203: if_icmpeq +8 -> 2211
    //   2206: iload_3
    //   2207: iconst_2
    //   2208: if_icmpne +176 -> 2384
    //   2211: aload_2
    //   2212: invokevirtual 431	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   2215: invokestatic 448	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   2218: astore_2
    //   2219: aload_2
    //   2220: invokevirtual 558	java/nio/ByteBuffer:getInt	()I
    //   2223: iconst_4
    //   2224: isub
    //   2225: newarray byte
    //   2227: astore 17
    //   2229: aload_2
    //   2230: aload 17
    //   2232: invokevirtual 560	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   2235: pop
    //   2236: new 327	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   2239: dup
    //   2240: invokespecial 328	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   2243: aload 17
    //   2245: invokevirtual 437	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2248: checkcast 327	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   2251: getfield 369	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   2254: invokevirtual 444	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   2257: invokevirtual 445	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   2260: invokestatic 448	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   2263: astore_2
    //   2264: aload_2
    //   2265: invokevirtual 451	java/nio/ByteBuffer:get	()B
    //   2268: istore 4
    //   2270: aload_2
    //   2271: invokevirtual 558	java/nio/ByteBuffer:getInt	()I
    //   2274: pop
    //   2275: aload_2
    //   2276: invokevirtual 451	java/nio/ByteBuffer:get	()B
    //   2279: istore 5
    //   2281: iload 5
    //   2283: iconst_1
    //   2284: if_icmpne +9 -> 2293
    //   2287: iconst_1
    //   2288: istore 10
    //   2290: goto +6 -> 2296
    //   2293: iconst_0
    //   2294: istore 10
    //   2296: iload 4
    //   2298: ifeq +9 -> 2307
    //   2301: iconst_0
    //   2302: istore 11
    //   2304: goto +25 -> 2329
    //   2307: iload_3
    //   2308: iconst_2
    //   2309: if_icmpne +20 -> 2329
    //   2312: aload_1
    //   2313: ldc_w 321
    //   2316: iconst_0
    //   2317: invokevirtual 671	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   2320: istore 10
    //   2322: goto +7 -> 2329
    //   2325: astore_2
    //   2326: goto +21 -> 2347
    //   2329: aload 19
    //   2331: ldc_w 321
    //   2334: iload 10
    //   2336: invokevirtual 217	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   2339: goto +32 -> 2371
    //   2342: astore_2
    //   2343: goto +4 -> 2347
    //   2346: astore_2
    //   2347: aload_2
    //   2348: invokevirtual 664	java/lang/Exception:printStackTrace	()V
    //   2351: invokestatic 175	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2354: ifeq +14 -> 2368
    //   2357: ldc_w 483
    //   2360: iconst_2
    //   2361: aload_2
    //   2362: invokevirtual 529	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2365: invokestatic 667	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   2368: iconst_0
    //   2369: istore 11
    //   2371: aload_0
    //   2372: aload_1
    //   2373: iload_3
    //   2374: iload 11
    //   2376: aload 19
    //   2378: ldc_w 490
    //   2381: invokevirtual 494	com/tencent/mobileqq/richstatus/StatusServlet:notifyObserver	(Landroid/content/Intent;IZLandroid/os/Bundle;Ljava/lang/Class;)V
    //   2384: return
    //   2385: iload_3
    //   2386: tableswitch	default:+50 -> 2436, 1:+2658->5044, 2:+2658->5044, 3:+2543->4929, 4:+1872->4258, 5:+1428->3814, 6:+923->3309, 7:+733->3119, 8:+585->2971, 9:+53->2439
    //   2437: lconst_1
    //   2438: <illegal opcode>
    //   2439: iload 10
    //   2441: ifeq +527 -> 2968
    //   2444: aload_1
    //   2445: ldc_w 459
    //   2448: iconst_0
    //   2449: invokevirtual 405	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   2452: istore 4
    //   2454: aload_2
    //   2455: invokevirtual 431	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   2458: arraylength
    //   2459: iconst_4
    //   2460: isub
    //   2461: istore 5
    //   2463: iload 5
    //   2465: newarray byte
    //   2467: astore 18
    //   2469: aload 18
    //   2471: iconst_0
    //   2472: aload_2
    //   2473: invokevirtual 431	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   2476: iconst_4
    //   2477: iload 5
    //   2479: invokestatic 500	com/tencent/mobileqq/utils/httputils/PkgTools:copyData	([BI[BII)V
    //   2482: new 134	com/tencent/pb/signature/SigActPb$RspBody
    //   2485: dup
    //   2486: invokespecial 501	com/tencent/pb/signature/SigActPb$RspBody:<init>	()V
    //   2489: astore 19
    //   2491: aload 19
    //   2493: aload 18
    //   2495: invokevirtual 502	com/tencent/pb/signature/SigActPb$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2498: pop
    //   2499: aload 19
    //   2501: getfield 503	com/tencent/pb/signature/SigActPb$RspBody:ret	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   2504: invokevirtual 193	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   2507: istore 5
    //   2509: aload 19
    //   2511: getfield 674	com/tencent/pb/signature/SigActPb$RspBody:desc	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2514: invokevirtual 675	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   2517: ifeq +15 -> 2532
    //   2520: aload 19
    //   2522: getfield 674	com/tencent/pb/signature/SigActPb$RspBody:desc	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2525: invokevirtual 240	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2528: astore_2
    //   2529: goto +7 -> 2536
    //   2532: ldc_w 461
    //   2535: astore_2
    //   2536: iload 5
    //   2538: ifne +158 -> 2696
    //   2541: aload 19
    //   2543: getfield 138	com/tencent/pb/signature/SigActPb$RspBody:auth_rsp	Lcom/tencent/pb/signature/SigActPb$SigauthRsp;
    //   2546: getfield 506	com/tencent/pb/signature/SigActPb$SigauthRsp:result	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   2549: invokevirtual 444	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   2552: invokevirtual 445	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   2555: invokestatic 448	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   2558: astore 18
    //   2560: aload 18
    //   2562: invokevirtual 451	java/nio/ByteBuffer:get	()B
    //   2565: istore 5
    //   2567: iload 5
    //   2569: ifne +19 -> 2588
    //   2572: aload 17
    //   2574: ldc_w 453
    //   2577: aload 18
    //   2579: invokevirtual 372	java/nio/ByteBuffer:array	()[B
    //   2582: invokevirtual 457	android/os/Bundle:putByteArray	(Ljava/lang/String;[B)V
    //   2585: goto +75 -> 2660
    //   2588: aload 17
    //   2590: ldc_w 508
    //   2593: iload 5
    //   2595: invokevirtual 222	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   2598: invokestatic 681	com/tencent/mobileqq/vas/config/business/qvip/SSOErrorInfoMapProcessor:c	()Lcom/tencent/mobileqq/vas/config/business/qvip/SSOErrorInfoMapConfig;
    //   2601: astore 20
    //   2603: aload_2
    //   2604: astore 18
    //   2606: aload_2
    //   2607: invokestatic 686	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2610: ifeq +44 -> 2654
    //   2613: new 177	java/lang/StringBuilder
    //   2616: dup
    //   2617: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   2620: astore 18
    //   2622: aload 18
    //   2624: ldc_w 461
    //   2627: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2630: pop
    //   2631: aload 18
    //   2633: iload 5
    //   2635: invokevirtual 196	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2638: pop
    //   2639: aload 20
    //   2641: ldc_w 688
    //   2644: aload 18
    //   2646: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2649: invokevirtual 694	com/tencent/mobileqq/vas/config/business/qvip/SSOErrorInfoMapConfig:getErrorInfo	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   2652: astore 18
    //   2654: aload 18
    //   2656: astore_2
    //   2657: iconst_0
    //   2658: istore 10
    //   2660: iload 4
    //   2662: iconst_1
    //   2663: if_icmpne +25 -> 2688
    //   2666: aload_0
    //   2667: aload 17
    //   2669: aload 19
    //   2671: ldc_w 696
    //   2674: invokespecial 698	com/tencent/mobileqq/richstatus/StatusServlet:a	(Landroid/os/Bundle;Lcom/tencent/pb/signature/SigActPb$RspBody;Ljava/lang/String;)V
    //   2677: goto +168 -> 2845
    //   2680: astore 19
    //   2682: goto +3 -> 2685
    //   2685: goto +104 -> 2789
    //   2688: goto +157 -> 2845
    //   2691: astore 18
    //   2693: goto +92 -> 2785
    //   2696: aload 17
    //   2698: ldc_w 516
    //   2701: iload 5
    //   2703: invokevirtual 222	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   2706: iload 5
    //   2708: ldc_w 517
    //   2711: if_icmpne +22 -> 2733
    //   2714: aload 17
    //   2716: ldc_w 519
    //   2719: aload 19
    //   2721: getfield 138	com/tencent/pb/signature/SigActPb$RspBody:auth_rsp	Lcom/tencent/pb/signature/SigActPb$SigauthRsp;
    //   2724: getfield 520	com/tencent/pb/signature/SigActPb$SigauthRsp:url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2727: invokevirtual 240	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2730: invokevirtual 244	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   2733: aload 19
    //   2735: getfield 138	com/tencent/pb/signature/SigActPb$RspBody:auth_rsp	Lcom/tencent/pb/signature/SigActPb$SigauthRsp;
    //   2738: getfield 523	com/tencent/pb/signature/SigActPb$SigauthRsp:authfailed_appid	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   2741: invokevirtual 524	com/tencent/mobileqq/pb/PBInt32Field:has	()Z
    //   2744: ifeq +22 -> 2766
    //   2747: aload 17
    //   2749: ldc_w 526
    //   2752: aload 19
    //   2754: getfield 138	com/tencent/pb/signature/SigActPb$RspBody:auth_rsp	Lcom/tencent/pb/signature/SigActPb$SigauthRsp;
    //   2757: getfield 523	com/tencent/pb/signature/SigActPb$SigauthRsp:authfailed_appid	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   2760: invokevirtual 193	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   2763: invokevirtual 222	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   2766: aload_0
    //   2767: aload 17
    //   2769: aload 19
    //   2771: ldc_w 700
    //   2774: invokespecial 698	com/tencent/mobileqq/richstatus/StatusServlet:a	(Landroid/os/Bundle;Lcom/tencent/pb/signature/SigActPb$RspBody;Ljava/lang/String;)V
    //   2777: aload_2
    //   2778: astore 18
    //   2780: goto +2498 -> 5278
    //   2783: astore 18
    //   2785: aload 18
    //   2787: astore 19
    //   2789: aload_2
    //   2790: astore 18
    //   2792: invokestatic 175	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2795: ifeq +2483 -> 5278
    //   2798: new 177	java/lang/StringBuilder
    //   2801: dup
    //   2802: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   2805: astore 18
    //   2807: aload 18
    //   2809: ldc_w 478
    //   2812: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2815: pop
    //   2816: aload 18
    //   2818: aload 19
    //   2820: invokevirtual 529	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2823: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2826: pop
    //   2827: ldc_w 483
    //   2830: iconst_2
    //   2831: aload 18
    //   2833: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2836: invokestatic 210	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2839: aload_2
    //   2840: astore 18
    //   2842: goto +2436 -> 5278
    //   2845: aload_2
    //   2846: ifnull +12 -> 2858
    //   2849: aload 17
    //   2851: ldc_w 702
    //   2854: aload_2
    //   2855: invokevirtual 244	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   2858: aload 17
    //   2860: ldc_w 459
    //   2863: iload 4
    //   2865: invokevirtual 222	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   2868: invokestatic 705	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   2871: ifeq +40 -> 2911
    //   2874: ldc_w 281
    //   2877: iconst_1
    //   2878: ldc_w 707
    //   2881: iconst_3
    //   2882: anewarray 709	java/lang/Object
    //   2885: dup
    //   2886: iconst_0
    //   2887: iload 10
    //   2889: invokestatic 714	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   2892: aastore
    //   2893: dup
    //   2894: iconst_1
    //   2895: iload 4
    //   2897: invokestatic 719	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2900: aastore
    //   2901: dup
    //   2902: iconst_2
    //   2903: aload_2
    //   2904: aastore
    //   2905: invokestatic 723	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   2908: invokestatic 284	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2911: goto +2314 -> 5225
    //   2914: astore_2
    //   2915: goto +4 -> 2919
    //   2918: astore_2
    //   2919: invokestatic 175	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2922: ifeq +889 -> 3811
    //   2925: new 177	java/lang/StringBuilder
    //   2928: dup
    //   2929: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   2932: astore 18
    //   2934: aload 18
    //   2936: ldc_w 478
    //   2939: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2942: pop
    //   2943: aload 18
    //   2945: aload_2
    //   2946: invokevirtual 529	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2949: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2952: pop
    //   2953: ldc_w 483
    //   2956: iconst_2
    //   2957: aload 18
    //   2959: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2962: invokestatic 210	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2965: goto +846 -> 3811
    //   2968: goto -532 -> 2436
    //   2971: iload 10
    //   2973: ifeq -537 -> 2436
    //   2976: new 327	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   2979: dup
    //   2980: invokespecial 328	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   2983: astore 18
    //   2985: aload 18
    //   2987: aload_2
    //   2988: invokevirtual 431	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   2991: invokestatic 436	com/tencent/mobileqq/utils/WupUtil:b	([B)[B
    //   2994: invokevirtual 437	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2997: checkcast 327	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   3000: astore_2
    //   3001: aload_2
    //   3002: ifnull +64 -> 3066
    //   3005: aload_2
    //   3006: getfield 440	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3009: invokevirtual 441	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   3012: ifeq +54 -> 3066
    //   3015: aload_2
    //   3016: getfield 440	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3019: invokevirtual 230	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3022: ifne +38 -> 3060
    //   3025: aload_2
    //   3026: getfield 369	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3029: invokevirtual 444	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   3032: invokevirtual 445	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   3035: invokestatic 448	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   3038: invokevirtual 451	java/nio/ByteBuffer:get	()B
    //   3041: istore 4
    //   3043: iload 4
    //   3045: ifne +9 -> 3054
    //   3048: iconst_1
    //   3049: istore 10
    //   3051: goto +6 -> 3057
    //   3054: iconst_0
    //   3055: istore 10
    //   3057: goto +196 -> 3253
    //   3060: iconst_0
    //   3061: istore 10
    //   3063: goto +190 -> 3253
    //   3066: goto +187 -> 3253
    //   3069: astore_2
    //   3070: invokestatic 175	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3073: ifeq +230 -> 3303
    //   3076: new 177	java/lang/StringBuilder
    //   3079: dup
    //   3080: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   3083: astore 18
    //   3085: aload 18
    //   3087: ldc_w 478
    //   3090: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3093: pop
    //   3094: aload 18
    //   3096: aload_2
    //   3097: invokevirtual 481	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:getMessage	()Ljava/lang/String;
    //   3100: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3103: pop
    //   3104: ldc_w 483
    //   3107: iconst_2
    //   3108: aload 18
    //   3110: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3113: invokestatic 210	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3116: goto +187 -> 3303
    //   3119: iload 10
    //   3121: ifeq -685 -> 2436
    //   3124: new 327	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   3127: dup
    //   3128: invokespecial 328	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   3131: astore 18
    //   3133: aload 18
    //   3135: aload_2
    //   3136: invokevirtual 431	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   3139: invokestatic 436	com/tencent/mobileqq/utils/WupUtil:b	([B)[B
    //   3142: invokevirtual 437	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3145: checkcast 327	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   3148: astore_2
    //   3149: iload 10
    //   3151: istore 11
    //   3153: aload_2
    //   3154: ifnull +95 -> 3249
    //   3157: iload 10
    //   3159: istore 11
    //   3161: aload_2
    //   3162: getfield 440	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3165: invokevirtual 441	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   3168: ifeq +81 -> 3249
    //   3171: aload_2
    //   3172: getfield 440	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3175: invokevirtual 230	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3178: ifne +65 -> 3243
    //   3181: aload_2
    //   3182: getfield 369	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3185: invokevirtual 444	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   3188: invokevirtual 445	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   3191: invokestatic 448	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   3194: astore_2
    //   3195: aload_2
    //   3196: invokevirtual 451	java/nio/ByteBuffer:get	()B
    //   3199: ifne +38 -> 3237
    //   3202: aload 17
    //   3204: ldc_w 453
    //   3207: aload_2
    //   3208: invokevirtual 372	java/nio/ByteBuffer:array	()[B
    //   3211: invokevirtual 457	android/os/Bundle:putByteArray	(Ljava/lang/String;[B)V
    //   3214: aload 17
    //   3216: ldc_w 459
    //   3219: aload_1
    //   3220: ldc_w 459
    //   3223: iconst_0
    //   3224: invokevirtual 405	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   3227: invokevirtual 222	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   3230: iload 10
    //   3232: istore 11
    //   3234: goto +15 -> 3249
    //   3237: iconst_0
    //   3238: istore 11
    //   3240: goto +9 -> 3249
    //   3243: iconst_0
    //   3244: istore 10
    //   3246: goto +7 -> 3253
    //   3249: iload 11
    //   3251: istore 10
    //   3253: goto +53 -> 3306
    //   3256: astore_2
    //   3257: invokestatic 175	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3260: ifeq +43 -> 3303
    //   3263: new 177	java/lang/StringBuilder
    //   3266: dup
    //   3267: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   3270: astore 18
    //   3272: aload 18
    //   3274: ldc_w 478
    //   3277: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3280: pop
    //   3281: aload 18
    //   3283: aload_2
    //   3284: invokevirtual 481	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:getMessage	()Ljava/lang/String;
    //   3287: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3290: pop
    //   3291: ldc_w 483
    //   3294: iconst_2
    //   3295: aload 18
    //   3297: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3300: invokestatic 210	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3303: iconst_0
    //   3304: istore 10
    //   3306: goto +1919 -> 5225
    //   3309: new 725	com/qq/jce/wup/UniPacket
    //   3312: dup
    //   3313: iconst_1
    //   3314: invokespecial 728	com/qq/jce/wup/UniPacket:<init>	(Z)V
    //   3317: astore 19
    //   3319: aload 19
    //   3321: ldc_w 730
    //   3324: invokevirtual 734	com/qq/jce/wup/UniPacket:setEncodeName	(Ljava/lang/String;)V
    //   3327: aload 19
    //   3329: aload_2
    //   3330: invokevirtual 431	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   3333: invokevirtual 737	com/qq/jce/wup/UniPacket:decode	([B)V
    //   3336: aload 19
    //   3338: ldc_w 739
    //   3341: new 741	PersonalState/RespGetHotState
    //   3344: dup
    //   3345: invokespecial 742	PersonalState/RespGetHotState:<init>	()V
    //   3348: invokevirtual 746	com/qq/jce/wup/UniPacket:getByClass	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   3351: checkcast 741	PersonalState/RespGetHotState
    //   3354: astore 19
    //   3356: aload 19
    //   3358: getfield 750	PersonalState/RespGetHotState:oHead	LPersonalState/BusiRespHead;
    //   3361: getfield 755	PersonalState/BusiRespHead:iReplyCode	I
    //   3364: ifne +431 -> 3795
    //   3367: invokestatic 175	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3370: ifeq +170 -> 3540
    //   3373: new 177	java/lang/StringBuilder
    //   3376: dup
    //   3377: ldc_w 757
    //   3380: invokespecial 759	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3383: astore 20
    //   3385: aload 20
    //   3387: ldc_w 761
    //   3390: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3393: pop
    //   3394: aload 19
    //   3396: getfield 764	PersonalState/RespGetHotState:vHostRichSateList	Ljava/util/ArrayList;
    //   3399: ifnonnull +10 -> 3409
    //   3402: ldc_w 766
    //   3405: astore_2
    //   3406: goto +15 -> 3421
    //   3409: aload 19
    //   3411: getfield 764	PersonalState/RespGetHotState:vHostRichSateList	Ljava/util/ArrayList;
    //   3414: invokevirtual 767	java/util/ArrayList:size	()I
    //   3417: invokestatic 719	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3420: astore_2
    //   3421: aload 20
    //   3423: aload_2
    //   3424: invokevirtual 279	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3427: pop
    //   3428: aload 20
    //   3430: ldc_w 769
    //   3433: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3436: pop
    //   3437: aload 19
    //   3439: getfield 764	PersonalState/RespGetHotState:vHostRichSateList	Ljava/util/ArrayList;
    //   3442: ifnull +86 -> 3528
    //   3445: aload 19
    //   3447: getfield 764	PersonalState/RespGetHotState:vHostRichSateList	Ljava/util/ArrayList;
    //   3450: invokevirtual 767	java/util/ArrayList:size	()I
    //   3453: ifle +75 -> 3528
    //   3456: aload 19
    //   3458: getfield 764	PersonalState/RespGetHotState:vHostRichSateList	Ljava/util/ArrayList;
    //   3461: invokevirtual 74	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   3464: astore_2
    //   3465: aload_2
    //   3466: invokeinterface 80 1 0
    //   3471: ifeq +57 -> 3528
    //   3474: aload_2
    //   3475: invokeinterface 84 1 0
    //   3480: checkcast 771	PersonalState/HotRishState
    //   3483: astore 21
    //   3485: aload 20
    //   3487: ldc_w 773
    //   3490: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3493: pop
    //   3494: aload 20
    //   3496: aload 21
    //   3498: getfield 776	PersonalState/HotRishState:iActId	I
    //   3501: invokevirtual 196	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3504: pop
    //   3505: aload 20
    //   3507: ldc_w 778
    //   3510: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3513: pop
    //   3514: aload 20
    //   3516: aload 21
    //   3518: getfield 781	PersonalState/HotRishState:iDataId	I
    //   3521: invokevirtual 196	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3524: pop
    //   3525: goto -60 -> 3465
    //   3528: ldc_w 783
    //   3531: iconst_2
    //   3532: aload 20
    //   3534: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3537: invokestatic 210	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3540: new 65	java/util/ArrayList
    //   3543: dup
    //   3544: bipush 6
    //   3546: invokespecial 570	java/util/ArrayList:<init>	(I)V
    //   3549: astore_2
    //   3550: aload 19
    //   3552: getfield 764	PersonalState/RespGetHotState:vHostRichSateList	Ljava/util/ArrayList;
    //   3555: ifnull +228 -> 3783
    //   3558: aload 19
    //   3560: getfield 764	PersonalState/RespGetHotState:vHostRichSateList	Ljava/util/ArrayList;
    //   3563: invokevirtual 767	java/util/ArrayList:size	()I
    //   3566: ifle +217 -> 3783
    //   3569: aload 18
    //   3571: ifnull +88 -> 3659
    //   3574: aload 18
    //   3576: invokevirtual 786	com/tencent/mobileqq/richstatus/StatusManager:a	()Lcom/tencent/mobileqq/richstatus/RichStatus;
    //   3579: astore 20
    //   3581: aload 19
    //   3583: getfield 764	PersonalState/RespGetHotState:vHostRichSateList	Ljava/util/ArrayList;
    //   3586: invokevirtual 767	java/util/ArrayList:size	()I
    //   3589: iconst_1
    //   3590: isub
    //   3591: istore 4
    //   3593: iload 4
    //   3595: iflt +64 -> 3659
    //   3598: aload 19
    //   3600: getfield 764	PersonalState/RespGetHotState:vHostRichSateList	Ljava/util/ArrayList;
    //   3603: iload 4
    //   3605: invokevirtual 789	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   3608: checkcast 771	PersonalState/HotRishState
    //   3611: astore 21
    //   3613: aload 21
    //   3615: getfield 776	PersonalState/HotRishState:iActId	I
    //   3618: aload 20
    //   3620: getfield 792	com/tencent/mobileqq/richstatus/RichStatus:actionId	I
    //   3623: if_icmpne +27 -> 3650
    //   3626: aload 21
    //   3628: getfield 781	PersonalState/HotRishState:iDataId	I
    //   3631: aload 20
    //   3633: getfield 795	com/tencent/mobileqq/richstatus/RichStatus:dataId	I
    //   3636: if_icmpne +14 -> 3650
    //   3639: aload 19
    //   3641: getfield 764	PersonalState/RespGetHotState:vHostRichSateList	Ljava/util/ArrayList;
    //   3644: iload 4
    //   3646: invokevirtual 798	java/util/ArrayList:remove	(I)Ljava/lang/Object;
    //   3649: pop
    //   3650: iload 4
    //   3652: iconst_1
    //   3653: isub
    //   3654: istore 4
    //   3656: goto -63 -> 3593
    //   3659: iconst_0
    //   3660: istore 4
    //   3662: iload 4
    //   3664: bipush 6
    //   3666: if_icmpge +27 -> 3693
    //   3669: aload_2
    //   3670: aload 19
    //   3672: getfield 764	PersonalState/RespGetHotState:vHostRichSateList	Ljava/util/ArrayList;
    //   3675: iload 4
    //   3677: invokevirtual 789	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   3680: invokevirtual 103	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   3683: pop
    //   3684: iload 4
    //   3686: iconst_1
    //   3687: iadd
    //   3688: istore 4
    //   3690: goto -28 -> 3662
    //   3693: new 177	java/lang/StringBuilder
    //   3696: dup
    //   3697: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   3700: astore 19
    //   3702: aload_2
    //   3703: invokevirtual 74	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   3706: astore 20
    //   3708: aload 20
    //   3710: invokeinterface 80 1 0
    //   3715: ifeq +58 -> 3773
    //   3718: aload 20
    //   3720: invokeinterface 84 1 0
    //   3725: checkcast 771	PersonalState/HotRishState
    //   3728: astore 21
    //   3730: aload 19
    //   3732: aload 21
    //   3734: getfield 776	PersonalState/HotRishState:iActId	I
    //   3737: invokevirtual 196	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3740: pop
    //   3741: aload 19
    //   3743: ldc_w 778
    //   3746: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3749: pop
    //   3750: aload 19
    //   3752: aload 21
    //   3754: getfield 781	PersonalState/HotRishState:iDataId	I
    //   3757: invokevirtual 196	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3760: pop
    //   3761: aload 19
    //   3763: ldc_w 800
    //   3766: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3769: pop
    //   3770: goto -62 -> 3708
    //   3773: aload 18
    //   3775: aload 19
    //   3777: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3780: invokevirtual 802	com/tencent/mobileqq/richstatus/StatusManager:a	(Ljava/lang/String;)V
    //   3783: aload 17
    //   3785: ldc_w 804
    //   3788: aload_2
    //   3789: invokevirtual 555	android/os/Bundle:putSerializable	(Ljava/lang/String;Ljava/io/Serializable;)V
    //   3792: goto -1356 -> 2436
    //   3795: invokestatic 175	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3798: ifeq +13 -> 3811
    //   3801: ldc_w 783
    //   3804: iconst_2
    //   3805: ldc_w 806
    //   3808: invokestatic 210	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3811: goto +1227 -> 5038
    //   3814: iload 10
    //   3816: ifeq -1380 -> 2436
    //   3819: new 327	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   3822: dup
    //   3823: invokespecial 328	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   3826: astore 18
    //   3828: aload 18
    //   3830: aload_2
    //   3831: invokevirtual 431	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   3834: invokestatic 436	com/tencent/mobileqq/utils/WupUtil:b	([B)[B
    //   3837: invokevirtual 437	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3840: checkcast 327	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   3843: astore_2
    //   3844: goto +60 -> 3904
    //   3847: astore_2
    //   3848: aload_2
    //   3849: invokevirtual 807	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   3852: invokestatic 175	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3855: ifeq +43 -> 3898
    //   3858: new 177	java/lang/StringBuilder
    //   3861: dup
    //   3862: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   3865: astore 19
    //   3867: aload 19
    //   3869: ldc_w 478
    //   3872: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3875: pop
    //   3876: aload 19
    //   3878: aload_2
    //   3879: invokevirtual 481	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:getMessage	()Ljava/lang/String;
    //   3882: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3885: pop
    //   3886: ldc_w 483
    //   3889: iconst_2
    //   3890: aload 19
    //   3892: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3895: invokestatic 210	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3898: iconst_0
    //   3899: istore 10
    //   3901: aload 18
    //   3903: astore_2
    //   3904: aload_2
    //   3905: ifnull +339 -> 4244
    //   3908: aload_2
    //   3909: getfield 440	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3912: invokevirtual 441	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   3915: ifeq +329 -> 4244
    //   3918: aload_2
    //   3919: getfield 440	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3922: invokevirtual 230	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3925: istore 4
    //   3927: iload 4
    //   3929: ifne +299 -> 4228
    //   3932: aload_2
    //   3933: getfield 369	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3936: invokevirtual 444	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   3939: invokevirtual 445	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   3942: invokestatic 448	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   3945: astore_2
    //   3946: aload_2
    //   3947: invokevirtual 451	java/nio/ByteBuffer:get	()B
    //   3950: istore 4
    //   3952: iload 4
    //   3954: ifne +197 -> 4151
    //   3957: aload_2
    //   3958: invokevirtual 568	java/nio/ByteBuffer:getShort	()S
    //   3961: istore 5
    //   3963: new 65	java/util/ArrayList
    //   3966: dup
    //   3967: invokespecial 66	java/util/ArrayList:<init>	()V
    //   3970: astore 18
    //   3972: iconst_0
    //   3973: istore 4
    //   3975: iload 4
    //   3977: iload 5
    //   3979: if_icmpge +42 -> 4021
    //   3982: aload_2
    //   3983: invokevirtual 568	java/nio/ByteBuffer:getShort	()S
    //   3986: newarray byte
    //   3988: astore 19
    //   3990: aload_2
    //   3991: aload 19
    //   3993: invokevirtual 560	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   3996: pop
    //   3997: aload 18
    //   3999: new 593	java/lang/String
    //   4002: dup
    //   4003: aload 19
    //   4005: invokespecial 596	java/lang/String:<init>	([B)V
    //   4008: invokevirtual 103	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   4011: pop
    //   4012: iload 4
    //   4014: iconst_1
    //   4015: iadd
    //   4016: istore 4
    //   4018: goto -43 -> 3975
    //   4021: new 65	java/util/ArrayList
    //   4024: dup
    //   4025: invokespecial 66	java/util/ArrayList:<init>	()V
    //   4028: astore 19
    //   4030: new 65	java/util/ArrayList
    //   4033: dup
    //   4034: invokespecial 66	java/util/ArrayList:<init>	()V
    //   4037: astore 20
    //   4039: aload_2
    //   4040: invokevirtual 568	java/nio/ByteBuffer:getShort	()S
    //   4043: istore 6
    //   4045: iconst_0
    //   4046: istore 4
    //   4048: iload 4
    //   4050: iload 6
    //   4052: if_icmpge +55 -> 4107
    //   4055: aload_2
    //   4056: invokevirtual 568	java/nio/ByteBuffer:getShort	()S
    //   4059: newarray byte
    //   4061: astore 21
    //   4063: aload_2
    //   4064: aload 21
    //   4066: invokevirtual 560	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   4069: pop
    //   4070: aload 19
    //   4072: new 593	java/lang/String
    //   4075: dup
    //   4076: aload 21
    //   4078: invokespecial 596	java/lang/String:<init>	([B)V
    //   4081: invokevirtual 103	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   4084: pop
    //   4085: aload 20
    //   4087: aload_2
    //   4088: invokevirtual 558	java/nio/ByteBuffer:getInt	()I
    //   4091: invokestatic 719	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   4094: invokevirtual 103	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   4097: pop
    //   4098: iload 4
    //   4100: iconst_1
    //   4101: iadd
    //   4102: istore 4
    //   4104: goto -56 -> 4048
    //   4107: iload 5
    //   4109: ifle +16 -> 4125
    //   4112: aload 17
    //   4114: ldc_w 809
    //   4117: aload 18
    //   4119: invokevirtual 813	android/os/Bundle:putStringArrayList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   4122: goto +1165 -> 5287
    //   4125: aload 17
    //   4127: ldc_w 809
    //   4130: aload 19
    //   4132: invokevirtual 813	android/os/Bundle:putStringArrayList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   4135: aload 17
    //   4137: ldc_w 815
    //   4140: aload 20
    //   4142: invokevirtual 818	android/os/Bundle:putIntegerArrayList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   4145: iconst_0
    //   4146: istore 10
    //   4148: goto +1139 -> 5287
    //   4151: aload 17
    //   4153: ldc_w 820
    //   4156: iload 4
    //   4158: invokevirtual 222	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   4161: iconst_0
    //   4162: istore 10
    //   4164: goto -911 -> 3253
    //   4167: astore_2
    //   4168: invokestatic 175	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4171: ifeq +43 -> 4214
    //   4174: new 177	java/lang/StringBuilder
    //   4177: dup
    //   4178: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   4181: astore 18
    //   4183: aload 18
    //   4185: ldc_w 822
    //   4188: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4191: pop
    //   4192: aload 18
    //   4194: aload_2
    //   4195: invokevirtual 529	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   4198: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4201: pop
    //   4202: ldc_w 483
    //   4205: iconst_2
    //   4206: aload 18
    //   4208: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4211: invokestatic 667	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   4214: aload 17
    //   4216: ldc_w 820
    //   4219: sipush -1002
    //   4222: invokevirtual 222	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   4225: goto +13 -> 4238
    //   4228: aload 17
    //   4230: ldc_w 820
    //   4233: iload 4
    //   4235: invokevirtual 222	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   4238: iconst_0
    //   4239: istore 10
    //   4241: goto -988 -> 3253
    //   4244: aload 17
    //   4246: ldc_w 820
    //   4249: sipush -1001
    //   4252: invokevirtual 222	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   4255: goto -952 -> 3303
    //   4258: iload_3
    //   4259: istore 4
    //   4261: new 533	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory
    //   4264: dup
    //   4265: invokespecial 534	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:<init>	()V
    //   4268: astore 18
    //   4270: iload_3
    //   4271: istore 4
    //   4273: aload 18
    //   4275: aload_1
    //   4276: ldc_w 536
    //   4279: iconst_0
    //   4280: invokevirtual 405	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   4283: putfield 539	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:startTime	I
    //   4286: iload_3
    //   4287: istore 4
    //   4289: aload 18
    //   4291: aload_1
    //   4292: ldc_w 541
    //   4295: ldc_w 542
    //   4298: invokevirtual 405	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   4301: putfield 545	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:endTime	I
    //   4304: iload_3
    //   4305: istore 4
    //   4307: aload 18
    //   4309: iconst_0
    //   4310: putfield 549	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:isAddFromCard	Z
    //   4313: iload_3
    //   4314: istore 4
    //   4316: aload 17
    //   4318: ldc_w 551
    //   4321: aload 18
    //   4323: invokevirtual 555	android/os/Bundle:putSerializable	(Ljava/lang/String;Ljava/io/Serializable;)V
    //   4326: iload_3
    //   4327: istore 4
    //   4329: aload_2
    //   4330: invokevirtual 431	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   4333: invokestatic 448	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   4336: astore_2
    //   4337: iload_3
    //   4338: istore 4
    //   4340: aload_2
    //   4341: invokevirtual 558	java/nio/ByteBuffer:getInt	()I
    //   4344: iconst_4
    //   4345: isub
    //   4346: newarray byte
    //   4348: astore 19
    //   4350: iload_3
    //   4351: istore 4
    //   4353: aload_2
    //   4354: aload 19
    //   4356: invokevirtual 560	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   4359: pop
    //   4360: iload_3
    //   4361: istore 4
    //   4363: new 327	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   4366: dup
    //   4367: invokespecial 328	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   4370: aload 19
    //   4372: invokevirtual 437	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   4375: checkcast 327	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   4378: getfield 369	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   4381: invokevirtual 444	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   4384: invokevirtual 445	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   4387: invokestatic 448	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   4390: astore 19
    //   4392: iload_3
    //   4393: istore 4
    //   4395: aload 19
    //   4397: invokevirtual 451	java/nio/ByteBuffer:get	()B
    //   4400: pop
    //   4401: iload_3
    //   4402: istore 4
    //   4404: aload 19
    //   4406: invokevirtual 564	java/nio/ByteBuffer:getLong	()J
    //   4409: lstore 13
    //   4411: iload_3
    //   4412: istore 4
    //   4414: aload 19
    //   4416: invokevirtual 451	java/nio/ByteBuffer:get	()B
    //   4419: pop
    //   4420: iload_3
    //   4421: istore 4
    //   4423: aload 19
    //   4425: invokevirtual 558	java/nio/ByteBuffer:getInt	()I
    //   4428: pop
    //   4429: iload_3
    //   4430: istore 4
    //   4432: aload 19
    //   4434: invokevirtual 558	java/nio/ByteBuffer:getInt	()I
    //   4437: istore 7
    //   4439: iload_3
    //   4440: istore 4
    //   4442: aload 19
    //   4444: invokevirtual 558	java/nio/ByteBuffer:getInt	()I
    //   4447: pop
    //   4448: iload_3
    //   4449: istore 4
    //   4451: aload 19
    //   4453: invokevirtual 451	java/nio/ByteBuffer:get	()B
    //   4456: ifeq +834 -> 5290
    //   4459: iconst_1
    //   4460: istore 11
    //   4462: goto +3 -> 4465
    //   4465: iload_3
    //   4466: istore 4
    //   4468: aload 19
    //   4470: invokevirtual 568	java/nio/ByteBuffer:getShort	()S
    //   4473: istore 5
    //   4475: iload_3
    //   4476: istore 4
    //   4478: aload 18
    //   4480: new 65	java/util/ArrayList
    //   4483: dup
    //   4484: iload 5
    //   4486: invokespecial 570	java/util/ArrayList:<init>	(I)V
    //   4489: putfield 573	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:richStatus	Ljava/util/ArrayList;
    //   4492: iload_3
    //   4493: istore 4
    //   4495: aload_0
    //   4496: invokevirtual 415	com/tencent/mobileqq/richstatus/StatusServlet:getAppRuntime	()Lmqq/app/AppRuntime;
    //   4499: checkcast 293	com/tencent/mobileqq/app/QQAppInterface
    //   4502: astore_2
    //   4503: iconst_0
    //   4504: istore 6
    //   4506: iload 6
    //   4508: iload 5
    //   4510: if_icmpge +160 -> 4670
    //   4513: iload_3
    //   4514: istore 4
    //   4516: aload 19
    //   4518: invokevirtual 568	java/nio/ByteBuffer:getShort	()S
    //   4521: newarray byte
    //   4523: astore 20
    //   4525: iload_3
    //   4526: istore 4
    //   4528: aload 19
    //   4530: aload 20
    //   4532: invokevirtual 560	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   4535: pop
    //   4536: iload_3
    //   4537: istore 4
    //   4539: aload 19
    //   4541: invokevirtual 568	java/nio/ByteBuffer:getShort	()S
    //   4544: newarray byte
    //   4546: astore 21
    //   4548: iload_3
    //   4549: istore 4
    //   4551: aload 19
    //   4553: aload 21
    //   4555: invokevirtual 560	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   4558: pop
    //   4559: iload_3
    //   4560: istore 4
    //   4562: aload 19
    //   4564: invokevirtual 558	java/nio/ByteBuffer:getInt	()I
    //   4567: pop
    //   4568: iload_3
    //   4569: istore 4
    //   4571: aload 19
    //   4573: invokevirtual 558	java/nio/ByteBuffer:getInt	()I
    //   4576: istore 8
    //   4578: iload_3
    //   4579: istore 4
    //   4581: aload 19
    //   4583: invokevirtual 576	java/nio/ByteBuffer:position	()I
    //   4586: istore 9
    //   4588: aload 19
    //   4590: iload 9
    //   4592: bipush 8
    //   4594: iadd
    //   4595: invokevirtual 579	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   4598: pop
    //   4599: iload 8
    //   4601: iload 7
    //   4603: if_icmple +6 -> 4609
    //   4606: goto +690 -> 5296
    //   4609: aload 21
    //   4611: invokestatic 585	com/tencent/mobileqq/richstatus/RichStatus:parseStatus	([B)Lcom/tencent/mobileqq/richstatus/RichStatus;
    //   4614: astore 21
    //   4616: aload 21
    //   4618: iload 8
    //   4620: i2l
    //   4621: putfield 588	com/tencent/mobileqq/richstatus/RichStatus:time	J
    //   4624: aload 21
    //   4626: aload 20
    //   4628: putfield 591	com/tencent/mobileqq/richstatus/RichStatus:key	[B
    //   4631: aload 21
    //   4633: getfield 591	com/tencent/mobileqq/richstatus/RichStatus:key	[B
    //   4636: ifnull +20 -> 4656
    //   4639: aload 21
    //   4641: new 593	java/lang/String
    //   4644: dup
    //   4645: aload 21
    //   4647: getfield 591	com/tencent/mobileqq/richstatus/RichStatus:key	[B
    //   4650: invokespecial 596	java/lang/String:<init>	([B)V
    //   4653: putfield 600	com/tencent/mobileqq/richstatus/RichStatus:feedsId	Ljava/lang/String;
    //   4656: aload 18
    //   4658: getfield 573	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:richStatus	Ljava/util/ArrayList;
    //   4661: aload 21
    //   4663: invokevirtual 103	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   4666: pop
    //   4667: goto +629 -> 5296
    //   4670: aload 18
    //   4672: getfield 573	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:richStatus	Ljava/util/ArrayList;
    //   4675: invokevirtual 603	java/util/ArrayList:isEmpty	()Z
    //   4678: ifeq +90 -> 4768
    //   4681: aload 18
    //   4683: getfield 539	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:startTime	I
    //   4686: ifne +82 -> 4768
    //   4689: aload 18
    //   4691: getfield 545	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:endTime	I
    //   4694: ldc_w 542
    //   4697: if_icmpne +71 -> 4768
    //   4700: aload_0
    //   4701: invokevirtual 415	com/tencent/mobileqq/richstatus/StatusServlet:getAppRuntime	()Lmqq/app/AppRuntime;
    //   4704: getstatic 606	com/tencent/mobileqq/app/QQManagerFactory:FRIENDS_MANAGER	I
    //   4707: invokevirtual 426	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   4710: checkcast 608	com/tencent/mobileqq/app/FriendsManager
    //   4713: lload 13
    //   4715: invokestatic 612	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   4718: invokevirtual 615	com/tencent/mobileqq/app/FriendsManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   4721: astore 19
    //   4723: aload 19
    //   4725: ifnull +43 -> 4768
    //   4728: getstatic 621	com/tencent/mobileqq/profilecard/bussiness/personalitysign/utils/RichStatusUtils:Companion	Lcom/tencent/mobileqq/profilecard/bussiness/personalitysign/utils/RichStatusUtils$Companion;
    //   4731: aload 19
    //   4733: invokevirtual 627	com/tencent/mobileqq/profilecard/bussiness/personalitysign/utils/RichStatusUtils$Companion:getRichStatus	(Lcom/tencent/mobileqq/data/Card;)Lcom/tencent/mobileqq/richstatus/RichStatus;
    //   4736: astore 19
    //   4738: aload 19
    //   4740: ifnull +28 -> 4768
    //   4743: aload 19
    //   4745: invokevirtual 628	com/tencent/mobileqq/richstatus/RichStatus:isEmpty	()Z
    //   4748: ifne +20 -> 4768
    //   4751: aload 18
    //   4753: getfield 573	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:richStatus	Ljava/util/ArrayList;
    //   4756: aload 19
    //   4758: invokevirtual 103	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   4761: pop
    //   4762: aload 18
    //   4764: iconst_1
    //   4765: putfield 549	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:isAddFromCard	Z
    //   4768: aload_2
    //   4769: getstatic 633	com/tencent/mobileqq/app/BusinessHandlerFactory:SIGNATURE_HANDLER	Ljava/lang/String;
    //   4772: invokevirtual 637	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(Ljava/lang/String;)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   4775: checkcast 639	com/tencent/mobileqq/app/SignatureHandler
    //   4778: astore 19
    //   4780: aload 18
    //   4782: getfield 573	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:richStatus	Ljava/util/ArrayList;
    //   4785: invokevirtual 74	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   4788: astore 20
    //   4790: aload 20
    //   4792: invokeinterface 80 1 0
    //   4797: ifeq +42 -> 4839
    //   4800: aload 20
    //   4802: invokeinterface 84 1 0
    //   4807: checkcast 581	com/tencent/mobileqq/richstatus/RichStatus
    //   4810: astore 21
    //   4812: aload 19
    //   4814: ifnull -24 -> 4790
    //   4817: aload 19
    //   4819: lload 13
    //   4821: invokestatic 612	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   4824: aload 21
    //   4826: getfield 600	com/tencent/mobileqq/richstatus/RichStatus:feedsId	Ljava/lang/String;
    //   4829: sipush 255
    //   4832: iconst_1
    //   4833: invokevirtual 642	com/tencent/mobileqq/app/SignatureHandler:a	(Ljava/lang/String;Ljava/lang/String;IZ)V
    //   4836: goto -46 -> 4790
    //   4839: aload 18
    //   4841: iload 11
    //   4843: putfield 645	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:over	Z
    //   4846: aload_2
    //   4847: getstatic 648	com/tencent/mobileqq/app/QQManagerFactory:SIGNATURE_MANAGER	I
    //   4850: invokevirtual 649	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   4853: checkcast 651	com/tencent/mobileqq/app/SignatureManager
    //   4856: astore 19
    //   4858: aload 19
    //   4860: ifnull +28 -> 4888
    //   4863: aload_2
    //   4864: invokevirtual 311	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   4867: lload 13
    //   4869: invokestatic 655	java/lang/Long:toString	(J)Ljava/lang/String;
    //   4872: invokevirtual 658	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4875: ifeq +13 -> 4888
    //   4878: aload 19
    //   4880: aload 18
    //   4882: getfield 573	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:richStatus	Ljava/util/ArrayList;
    //   4885: invokevirtual 661	com/tencent/mobileqq/app/SignatureManager:a	(Ljava/util/List;)V
    //   4888: goto +337 -> 5225
    //   4891: astore_2
    //   4892: goto +7 -> 4899
    //   4895: astore_2
    //   4896: iload 4
    //   4898: istore_3
    //   4899: aload_2
    //   4900: invokevirtual 664	java/lang/Exception:printStackTrace	()V
    //   4903: iload_3
    //   4904: istore 4
    //   4906: invokestatic 175	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4909: ifeq +126 -> 5035
    //   4912: ldc_w 483
    //   4915: iconst_2
    //   4916: aload_2
    //   4917: invokevirtual 529	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   4920: invokestatic 667	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   4923: iload_3
    //   4924: istore 4
    //   4926: goto +109 -> 5035
    //   4929: aload 17
    //   4931: ldc_w 824
    //   4934: aload_1
    //   4935: ldc_w 824
    //   4938: iconst_1
    //   4939: invokevirtual 671	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   4942: invokevirtual 217	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   4945: aload 17
    //   4947: ldc_w 826
    //   4950: aload_1
    //   4951: ldc_w 826
    //   4954: iconst_m1
    //   4955: invokevirtual 405	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   4958: invokevirtual 222	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   4961: new 725	com/qq/jce/wup/UniPacket
    //   4964: dup
    //   4965: iconst_1
    //   4966: invokespecial 728	com/qq/jce/wup/UniPacket:<init>	(Z)V
    //   4969: astore 18
    //   4971: aload 18
    //   4973: ldc_w 730
    //   4976: invokevirtual 734	com/qq/jce/wup/UniPacket:setEncodeName	(Ljava/lang/String;)V
    //   4979: aload 18
    //   4981: aload_2
    //   4982: invokevirtual 431	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   4985: invokevirtual 737	com/qq/jce/wup/UniPacket:decode	([B)V
    //   4988: aload 18
    //   4990: ldc_w 828
    //   4993: new 830	PersonalState/RespGetSameStateList
    //   4996: dup
    //   4997: invokespecial 831	PersonalState/RespGetSameStateList:<init>	()V
    //   5000: invokevirtual 746	com/qq/jce/wup/UniPacket:getByClass	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   5003: checkcast 830	PersonalState/RespGetSameStateList
    //   5006: astore_2
    //   5007: aload_2
    //   5008: getfield 832	PersonalState/RespGetSameStateList:oHead	LPersonalState/BusiRespHead;
    //   5011: getfield 755	PersonalState/BusiRespHead:iReplyCode	I
    //   5014: ifne +15 -> 5029
    //   5017: aload 17
    //   5019: ldc_w 834
    //   5022: aload_2
    //   5023: invokevirtual 555	android/os/Bundle:putSerializable	(Ljava/lang/String;Ljava/io/Serializable;)V
    //   5026: goto +6 -> 5032
    //   5029: iconst_0
    //   5030: istore 10
    //   5032: goto +193 -> 5225
    //   5035: iload 4
    //   5037: istore_3
    //   5038: iconst_0
    //   5039: istore 10
    //   5041: goto +184 -> 5225
    //   5044: iload 10
    //   5046: istore 11
    //   5048: aload_2
    //   5049: invokevirtual 431	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   5052: invokestatic 448	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   5055: astore_2
    //   5056: aload_2
    //   5057: invokevirtual 558	java/nio/ByteBuffer:getInt	()I
    //   5060: iconst_4
    //   5061: isub
    //   5062: newarray byte
    //   5064: astore 18
    //   5066: aload_2
    //   5067: aload 18
    //   5069: invokevirtual 560	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   5072: pop
    //   5073: new 327	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   5076: dup
    //   5077: invokespecial 328	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   5080: aload 18
    //   5082: invokevirtual 437	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   5085: checkcast 327	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   5088: getfield 369	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   5091: invokevirtual 444	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   5094: invokevirtual 445	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   5097: invokestatic 448	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   5100: astore_2
    //   5101: aload_2
    //   5102: invokevirtual 451	java/nio/ByteBuffer:get	()B
    //   5105: istore 5
    //   5107: aload_2
    //   5108: invokevirtual 558	java/nio/ByteBuffer:getInt	()I
    //   5111: pop
    //   5112: aload_2
    //   5113: invokevirtual 451	java/nio/ByteBuffer:get	()B
    //   5116: istore 6
    //   5118: iconst_1
    //   5119: istore 10
    //   5121: iload 6
    //   5123: iconst_1
    //   5124: if_icmpne +6 -> 5130
    //   5127: goto +6 -> 5133
    //   5130: iconst_0
    //   5131: istore 10
    //   5133: iload 5
    //   5135: ifeq +17 -> 5152
    //   5138: iconst_0
    //   5139: istore 11
    //   5141: iload 10
    //   5143: istore 12
    //   5145: iload 11
    //   5147: istore 10
    //   5149: goto +25 -> 5174
    //   5152: iload_3
    //   5153: iconst_2
    //   5154: if_icmpne +151 -> 5305
    //   5157: aload_1
    //   5158: ldc_w 321
    //   5161: iconst_0
    //   5162: invokevirtual 671	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   5165: istore 12
    //   5167: iload 11
    //   5169: istore 10
    //   5171: goto +3 -> 5174
    //   5174: iload 4
    //   5176: istore_3
    //   5177: aload 17
    //   5179: ldc_w 321
    //   5182: iload 12
    //   5184: invokevirtual 217	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   5187: goto +38 -> 5225
    //   5190: astore_2
    //   5191: goto +4 -> 5195
    //   5194: astore_2
    //   5195: aload_2
    //   5196: invokevirtual 664	java/lang/Exception:printStackTrace	()V
    //   5199: iload 4
    //   5201: istore_3
    //   5202: invokestatic 175	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5205: ifeq -167 -> 5038
    //   5208: ldc_w 483
    //   5211: iconst_2
    //   5212: aload_2
    //   5213: invokevirtual 529	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   5216: invokestatic 667	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   5219: iload 4
    //   5221: istore_3
    //   5222: goto -184 -> 5038
    //   5225: aload_0
    //   5226: aload_1
    //   5227: iload_3
    //   5228: iload 10
    //   5230: aload 17
    //   5232: ldc_w 490
    //   5235: invokevirtual 494	com/tencent/mobileqq/richstatus/StatusServlet:notifyObserver	(Landroid/content/Intent;IZLandroid/os/Bundle;Ljava/lang/Class;)V
    //   5238: return
    //   5239: astore_2
    //   5240: iload_3
    //   5241: istore 4
    //   5243: goto -208 -> 5035
    //   5246: iconst_0
    //   5247: istore 11
    //   5249: goto -3898 -> 1351
    //   5252: iload 6
    //   5254: iconst_1
    //   5255: iadd
    //   5256: istore 6
    //   5258: aload 19
    //   5260: astore 18
    //   5262: goto -3845 -> 1417
    //   5265: astore 18
    //   5267: aload 17
    //   5269: astore 20
    //   5271: aload 19
    //   5273: astore 17
    //   5275: goto -3314 -> 1961
    //   5278: iconst_0
    //   5279: istore 10
    //   5281: aload 18
    //   5283: astore_2
    //   5284: goto -2439 -> 2845
    //   5287: goto -1123 -> 4164
    //   5290: iconst_0
    //   5291: istore 11
    //   5293: goto -828 -> 4465
    //   5296: iload 6
    //   5298: iconst_1
    //   5299: iadd
    //   5300: istore 6
    //   5302: goto -796 -> 4506
    //   5305: iload 10
    //   5307: istore 12
    //   5309: iload 11
    //   5311: istore 10
    //   5313: goto -139 -> 5174
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	5316	0	this	StatusServlet
    //   0	5316	1	paramIntent	Intent
    //   0	5316	2	paramFromServiceMsg	com.tencent.qphone.base.remote.FromServiceMsg
    //   12	5229	3	i	int
    //   8	5234	4	j	int
    //   1367	3767	5	k	int
    //   1415	3886	6	m	int
    //   1307	3297	7	n	int
    //   1535	3084	8	i1	int
    //   1553	3042	9	i2	int
    //   17	5295	10	bool1	boolean
    //   87	5223	11	bool2	boolean
    //   1647	3661	12	bool3	boolean
    //   1255	3613	13	l1	long
    //   1590	5	15	l2	long
    //   26	2082	17	localObject1	Object
    //   2137	28	17	localInvalidProtocolBufferMicroException1	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
    //   2227	3047	17	localObject2	Object
    //   41	236	18	localObject3	Object
    //   289	29	18	localInvalidProtocolBufferMicroException2	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
    //   396	1541	18	str	String
    //   1940	1	18	localException1	Exception
    //   1948	36	18	localException2	Exception
    //   2152	503	18	localObject4	Object
    //   2691	1	18	localException3	Exception
    //   2778	1	18	localFromServiceMsg	com.tencent.qphone.base.remote.FromServiceMsg
    //   2783	3	18	localException4	Exception
    //   2790	2471	18	localObject5	Object
    //   5265	17	18	localException5	Exception
    //   304	596	19	localObject6	Object
    //   913	29	19	localException6	Exception
    //   1022	1648	19	localObject7	Object
    //   2680	90	19	localException7	Exception
    //   2787	2485	19	localObject8	Object
    //   426	4844	20	localObject9	Object
    //   1139	3686	21	localObject10	Object
    //   1161	765	22	localObject11	Object
    //   1031	875	23	localRspGetHistory	StatusServlet.RspGetHistory
    //   1412	476	24	localQQAppInterface	QQAppInterface
    //   1481	423	25	localObject12	Object
    // Exception table:
    //   from	to	target	type
    //   68	85	289	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   98	119	289	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   124	147	289	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   152	181	289	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   188	240	289	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   243	286	289	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   413	468	913	java/lang/Exception
    //   473	499	913	java/lang/Exception
    //   504	533	913	java/lang/Exception
    //   536	546	913	java/lang/Exception
    //   549	610	913	java/lang/Exception
    //   618	637	913	java/lang/Exception
    //   637	670	913	java/lang/Exception
    //   670	735	913	java/lang/Exception
    //   740	863	913	java/lang/Exception
    //   863	907	913	java/lang/Exception
    //   1592	1631	1932	java/lang/Exception
    //   1631	1642	1932	java/lang/Exception
    //   1660	1713	1932	java/lang/Exception
    //   1718	1728	1932	java/lang/Exception
    //   1733	1758	1932	java/lang/Exception
    //   1758	1781	1932	java/lang/Exception
    //   1781	1803	1932	java/lang/Exception
    //   1808	1827	1932	java/lang/Exception
    //   1830	1850	1932	java/lang/Exception
    //   1887	1913	1932	java/lang/Exception
    //   1024	1033	1948	java/lang/Exception
    //   1044	1057	1948	java/lang/Exception
    //   1068	1083	1948	java/lang/Exception
    //   1094	1100	1948	java/lang/Exception
    //   1111	1121	1948	java/lang/Exception
    //   1132	1141	1948	java/lang/Exception
    //   1152	1163	1948	java/lang/Exception
    //   1174	1182	1948	java/lang/Exception
    //   1193	1222	1948	java/lang/Exception
    //   1233	1239	1948	java/lang/Exception
    //   1250	1257	1948	java/lang/Exception
    //   1268	1274	1948	java/lang/Exception
    //   1285	1291	1948	java/lang/Exception
    //   1302	1309	1948	java/lang/Exception
    //   1320	1326	1948	java/lang/Exception
    //   1337	1345	1948	java/lang/Exception
    //   1362	1369	1948	java/lang/Exception
    //   1380	1394	1948	java/lang/Exception
    //   1405	1414	1948	java/lang/Exception
    //   1435	1444	1948	java/lang/Exception
    //   1455	1463	1948	java/lang/Exception
    //   1474	1483	1948	java/lang/Exception
    //   1494	1502	1948	java/lang/Exception
    //   1513	1519	1948	java/lang/Exception
    //   1530	1537	1948	java/lang/Exception
    //   1548	1555	1948	java/lang/Exception
    //   2055	2072	2137	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   2085	2126	2137	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   2312	2322	2325	java/lang/Exception
    //   2329	2339	2342	java/lang/Exception
    //   2211	2281	2346	java/lang/Exception
    //   2666	2677	2680	java/lang/Exception
    //   2541	2567	2691	java/lang/Exception
    //   2572	2585	2691	java/lang/Exception
    //   2588	2603	2691	java/lang/Exception
    //   2606	2654	2691	java/lang/Exception
    //   2696	2706	2783	java/lang/Exception
    //   2714	2733	2783	java/lang/Exception
    //   2733	2766	2783	java/lang/Exception
    //   2766	2777	2783	java/lang/Exception
    //   2792	2839	2914	java/lang/Exception
    //   2849	2858	2914	java/lang/Exception
    //   2858	2911	2914	java/lang/Exception
    //   2444	2529	2918	java/lang/Exception
    //   2985	3001	3069	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3005	3043	3069	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3133	3149	3256	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3161	3230	3256	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3828	3844	3847	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3932	3952	4167	java/lang/Exception
    //   3957	3972	4167	java/lang/Exception
    //   3982	4012	4167	java/lang/Exception
    //   4021	4045	4167	java/lang/Exception
    //   4055	4098	4167	java/lang/Exception
    //   4112	4122	4167	java/lang/Exception
    //   4125	4145	4167	java/lang/Exception
    //   4151	4161	4167	java/lang/Exception
    //   4588	4599	4891	java/lang/Exception
    //   4609	4656	4891	java/lang/Exception
    //   4656	4667	4891	java/lang/Exception
    //   4670	4723	4891	java/lang/Exception
    //   4728	4738	4891	java/lang/Exception
    //   4743	4768	4891	java/lang/Exception
    //   4768	4790	4891	java/lang/Exception
    //   4790	4812	4891	java/lang/Exception
    //   4817	4836	4891	java/lang/Exception
    //   4839	4858	4891	java/lang/Exception
    //   4863	4888	4891	java/lang/Exception
    //   4261	4270	4895	java/lang/Exception
    //   4273	4286	4895	java/lang/Exception
    //   4289	4304	4895	java/lang/Exception
    //   4307	4313	4895	java/lang/Exception
    //   4316	4326	4895	java/lang/Exception
    //   4329	4337	4895	java/lang/Exception
    //   4340	4350	4895	java/lang/Exception
    //   4353	4360	4895	java/lang/Exception
    //   4363	4392	4895	java/lang/Exception
    //   4395	4401	4895	java/lang/Exception
    //   4404	4411	4895	java/lang/Exception
    //   4414	4420	4895	java/lang/Exception
    //   4423	4429	4895	java/lang/Exception
    //   4432	4439	4895	java/lang/Exception
    //   4442	4448	4895	java/lang/Exception
    //   4451	4459	4895	java/lang/Exception
    //   4468	4475	4895	java/lang/Exception
    //   4478	4492	4895	java/lang/Exception
    //   4495	4503	4895	java/lang/Exception
    //   4516	4525	4895	java/lang/Exception
    //   4528	4536	4895	java/lang/Exception
    //   4539	4548	4895	java/lang/Exception
    //   4551	4559	4895	java/lang/Exception
    //   4562	4568	4895	java/lang/Exception
    //   4571	4578	4895	java/lang/Exception
    //   4581	4588	4895	java/lang/Exception
    //   5157	5167	5190	java/lang/Exception
    //   5177	5187	5190	java/lang/Exception
    //   5048	5118	5194	java/lang/Exception
    //   4929	5026	5239	java/lang/Exception
    //   1559	1570	5265	java/lang/Exception
    //   1580	1587	5265	java/lang/Exception
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
      paramIntent.mqqver.set("8.7.0");
      paramIntent.osver.set(DeviceInfoUtil.e());
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
      localObject2 = ((FriendsManager)((AppInterface)localObject2).getManager(QQManagerFactory.FRIENDS_MANAGER)).a(((AppInterface)localObject2).getCurrentAccountUin());
      if (localObject2 != null)
      {
        if (((Card)localObject2).shGender == 0)
        {
          i = 0;
          break label878;
        }
        if (((Card)localObject2).shGender == 1)
        {
          i = 1;
          break label878;
        }
      }
      i = 2;
      ((ReqGetSameStateList)localObject1).eSelfSex = i;
      ((ReqGetSameStateList)localObject1).iPageSize = 50;
      ((ReqGetSameStateList)localObject1).oLbsInfo = a(null);
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
      label878:
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.StatusServlet
 * JD-Core Version:    0.7.0.1
 */