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
import com.tencent.mobileqq.nearby.LbsUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
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
    Object localObject1 = LbsUtils.a();
    paramQQAppInterface = null;
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
      paramQQAppInterface = new PersonalState.LBSInfo(paramQQAppInterface, localArrayList, (ArrayList)localObject2);
    }
    return paramQQAppInterface;
  }
  
  private void a(Bundle paramBundle, SigActPb.RspBody paramRspBody, String paramString)
  {
    if (paramRspBody.auth_rsp.tips_info.has())
    {
      SigActPb.SigauthRsp.TipsInfo localTipsInfo = new SigActPb.SigauthRsp.TipsInfo();
      localTipsInfo.mergeFrom(((SigActPb.SigauthRsp.TipsInfo)paramRspBody.auth_rsp.tips_info.get()).toByteArray());
      boolean bool = localTipsInfo.valid.get();
      if (QLog.isColorLevel()) {
        QLog.d("Signature", 2, "CMD_RICH_STATUS_AUTH ret = " + localTipsInfo.ret.get() + " valid = " + bool);
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
      if (QLog.isColorLevel()) {
        QLog.i("StatusServlet", 2, "CMD_RICH_STATUS_AUTH parseSigAuthTipsInfo " + paramString + " data=" + paramBundle);
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
    if (((Iterator)localObject2).hasNext())
    {
      arrayOfByte = (byte[])((Iterator)localObject2).next();
      if (arrayOfByte == null) {
        break label227;
      }
      i = arrayOfByte.length + (i + 2) + 4;
    }
    label227:
    for (;;)
    {
      break;
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
    int j = 1;
    Object localObject = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_command.set(1301);
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_service_type.set(2);
    ByteBuffer localByteBuffer1 = ByteBuffer.allocate(11);
    ByteBuffer localByteBuffer2 = localByteBuffer1.put((byte)2).putInt(293615363);
    if (paramBoolean1)
    {
      i = 1;
      localByteBuffer2.put((byte)i);
      if (!paramBoolean2) {
        break label155;
      }
    }
    label155:
    for (int i = j;; i = 0)
    {
      localByteBuffer1.put((byte)i).putInt((int)paramLong);
      ((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.set(ByteStringMicro.copyFrom(localByteBuffer1.array()));
      localObject = ((oidb_sso.OIDBSSOPkg)localObject).toByteArray();
      localByteBuffer1 = ByteBuffer.allocate(localObject.length + 4);
      localByteBuffer1.putInt(localObject.length + 4);
      localByteBuffer1.put((byte[])localObject);
      return localByteBuffer1.array();
      i = 0;
      break;
    }
  }
  
  /* Error */
  public void onReceive(Intent paramIntent, com.tencent.qphone.base.remote.FromServiceMsg paramFromServiceMsg)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc_w 301
    //   4: iconst_0
    //   5: invokevirtual 404	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   8: istore 4
    //   10: aload_2
    //   11: invokevirtual 409	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   14: istore 8
    //   16: new 212	android/os/Bundle
    //   19: dup
    //   20: invokespecial 410	android/os/Bundle:<init>	()V
    //   23: astore 15
    //   25: aload_0
    //   26: invokevirtual 414	com/tencent/mobileqq/richstatus/StatusServlet:getAppRuntime	()Lmqq/app/AppRuntime;
    //   29: getstatic 419	com/tencent/mobileqq/app/QQManagerFactory:STATUS_MANAGER	I
    //   32: invokevirtual 425	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   35: checkcast 427	com/tencent/mobileqq/richstatus/StatusManager
    //   38: astore 13
    //   40: aload 13
    //   42: ifnonnull +1879 -> 1921
    //   45: iload 8
    //   47: istore 9
    //   49: iload 4
    //   51: bipush 7
    //   53: if_icmpne +152 -> 205
    //   56: iload 8
    //   58: ifeq +706 -> 764
    //   61: new 326	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   64: dup
    //   65: invokespecial 327	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   68: astore 13
    //   70: aload 13
    //   72: aload_2
    //   73: invokevirtual 430	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   76: invokestatic 435	com/tencent/mobileqq/utils/WupUtil:b	([B)[B
    //   79: invokevirtual 436	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   82: checkcast 326	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   85: astore 13
    //   87: iload 8
    //   89: istore 9
    //   91: aload 13
    //   93: ifnull +90 -> 183
    //   96: iload 8
    //   98: istore 9
    //   100: aload 13
    //   102: getfield 439	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   105: invokevirtual 440	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   108: ifeq +75 -> 183
    //   111: aload 13
    //   113: getfield 439	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   116: invokevirtual 229	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   119: istore_3
    //   120: iload_3
    //   121: ifne +560 -> 681
    //   124: aload 13
    //   126: getfield 368	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   129: invokevirtual 443	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   132: invokevirtual 444	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   135: invokestatic 447	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   138: astore 13
    //   140: aload 13
    //   142: invokevirtual 450	java/nio/ByteBuffer:get	()B
    //   145: istore_3
    //   146: iload_3
    //   147: ifne +487 -> 634
    //   150: aload 15
    //   152: ldc_w 452
    //   155: aload 13
    //   157: invokevirtual 371	java/nio/ByteBuffer:array	()[B
    //   160: invokevirtual 456	android/os/Bundle:putByteArray	(Ljava/lang/String;[B)V
    //   163: aload 15
    //   165: ldc_w 458
    //   168: aload_1
    //   169: ldc_w 458
    //   172: iconst_0
    //   173: invokevirtual 404	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   176: invokevirtual 221	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   179: iload 8
    //   181: istore 9
    //   183: iload 9
    //   185: istore 8
    //   187: aload_0
    //   188: aload_1
    //   189: iload 4
    //   191: iload 8
    //   193: aload 15
    //   195: ldc_w 460
    //   198: invokevirtual 464	com/tencent/mobileqq/richstatus/StatusServlet:notifyObserver	(Landroid/content/Intent;IZLandroid/os/Bundle;Ljava/lang/Class;)V
    //   201: iload 8
    //   203: istore 9
    //   205: iload 4
    //   207: bipush 9
    //   209: if_icmpne +4374 -> 4583
    //   212: iload 9
    //   214: ifeq +978 -> 1192
    //   217: aload_2
    //   218: invokevirtual 430	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   221: arraylength
    //   222: iconst_4
    //   223: isub
    //   224: istore_3
    //   225: iload_3
    //   226: newarray byte
    //   228: astore 14
    //   230: aload 14
    //   232: iconst_0
    //   233: aload_2
    //   234: invokevirtual 430	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   237: iconst_4
    //   238: iload_3
    //   239: invokestatic 470	com/tencent/mobileqq/utils/httputils/PkgTools:copyData	([BI[BII)V
    //   242: new 133	com/tencent/pb/signature/SigActPb$RspBody
    //   245: dup
    //   246: invokespecial 471	com/tencent/pb/signature/SigActPb$RspBody:<init>	()V
    //   249: astore 13
    //   251: aload 13
    //   253: aload 14
    //   255: invokevirtual 472	com/tencent/pb/signature/SigActPb$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   258: pop
    //   259: aload 13
    //   261: getfield 473	com/tencent/pb/signature/SigActPb$RspBody:ret	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   264: invokevirtual 194	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   267: istore_3
    //   268: iload_3
    //   269: ifne +583 -> 852
    //   272: aload 13
    //   274: getfield 137	com/tencent/pb/signature/SigActPb$RspBody:auth_rsp	Lcom/tencent/pb/signature/SigActPb$SigauthRsp;
    //   277: getfield 476	com/tencent/pb/signature/SigActPb$SigauthRsp:result	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   280: invokevirtual 443	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   283: invokevirtual 444	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   286: invokestatic 447	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   289: astore 13
    //   291: aload 13
    //   293: invokevirtual 450	java/nio/ByteBuffer:get	()B
    //   296: istore_3
    //   297: iload_3
    //   298: ifne +494 -> 792
    //   301: aload 15
    //   303: ldc_w 452
    //   306: aload 13
    //   308: invokevirtual 371	java/nio/ByteBuffer:array	()[B
    //   311: invokevirtual 456	android/os/Bundle:putByteArray	(Ljava/lang/String;[B)V
    //   314: aload 15
    //   316: ldc_w 458
    //   319: aload_1
    //   320: ldc_w 458
    //   323: iconst_0
    //   324: invokevirtual 404	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   327: invokevirtual 221	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   330: iload 9
    //   332: istore 8
    //   334: iload 8
    //   336: istore 9
    //   338: aload_0
    //   339: aload_1
    //   340: iload 4
    //   342: iload 9
    //   344: aload 15
    //   346: ldc_w 460
    //   349: invokevirtual 464	com/tencent/mobileqq/richstatus/StatusServlet:notifyObserver	(Landroid/content/Intent;IZLandroid/os/Bundle;Ljava/lang/Class;)V
    //   352: iload 9
    //   354: istore 8
    //   356: iload 4
    //   358: iconst_4
    //   359: if_icmpne +976 -> 1335
    //   362: new 478	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory
    //   365: dup
    //   366: invokespecial 479	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:<init>	()V
    //   369: astore 13
    //   371: aload 13
    //   373: aload_1
    //   374: ldc_w 481
    //   377: iconst_0
    //   378: invokevirtual 404	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   381: putfield 484	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:startTime	I
    //   384: aload 13
    //   386: aload_1
    //   387: ldc_w 486
    //   390: ldc_w 487
    //   393: invokevirtual 404	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   396: putfield 490	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:endTime	I
    //   399: aload 13
    //   401: iconst_0
    //   402: putfield 494	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:isAddFromCard	Z
    //   405: aload 15
    //   407: ldc_w 496
    //   410: aload 13
    //   412: invokevirtual 500	android/os/Bundle:putSerializable	(Ljava/lang/String;Ljava/io/Serializable;)V
    //   415: aload_2
    //   416: invokevirtual 430	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   419: invokestatic 447	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   422: astore 14
    //   424: aload 14
    //   426: invokevirtual 503	java/nio/ByteBuffer:getInt	()I
    //   429: iconst_4
    //   430: isub
    //   431: newarray byte
    //   433: astore 16
    //   435: aload 14
    //   437: aload 16
    //   439: invokevirtual 505	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   442: pop
    //   443: new 326	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   446: dup
    //   447: invokespecial 327	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   450: aload 16
    //   452: invokevirtual 436	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   455: checkcast 326	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   458: getfield 368	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   461: invokevirtual 443	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   464: invokevirtual 444	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   467: invokestatic 447	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   470: astore 16
    //   472: aload 16
    //   474: invokevirtual 450	java/nio/ByteBuffer:get	()B
    //   477: pop
    //   478: aload 16
    //   480: invokevirtual 509	java/nio/ByteBuffer:getLong	()J
    //   483: lstore 11
    //   485: aload 16
    //   487: invokevirtual 450	java/nio/ByteBuffer:get	()B
    //   490: pop
    //   491: aload 16
    //   493: invokevirtual 503	java/nio/ByteBuffer:getInt	()I
    //   496: pop
    //   497: aload 16
    //   499: invokevirtual 503	java/nio/ByteBuffer:getInt	()I
    //   502: istore 5
    //   504: aload 16
    //   506: invokevirtual 503	java/nio/ByteBuffer:getInt	()I
    //   509: pop
    //   510: aload 16
    //   512: invokevirtual 450	java/nio/ByteBuffer:get	()B
    //   515: ifeq +703 -> 1218
    //   518: iconst_1
    //   519: istore 8
    //   521: aload 16
    //   523: invokevirtual 513	java/nio/ByteBuffer:getShort	()S
    //   526: istore 6
    //   528: aload 13
    //   530: new 64	java/util/ArrayList
    //   533: dup
    //   534: iload 6
    //   536: invokespecial 515	java/util/ArrayList:<init>	(I)V
    //   539: putfield 518	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:richStatus	Ljava/util/ArrayList;
    //   542: aload_0
    //   543: invokevirtual 414	com/tencent/mobileqq/richstatus/StatusServlet:getAppRuntime	()Lmqq/app/AppRuntime;
    //   546: checkcast 292	com/tencent/mobileqq/app/QQAppInterface
    //   549: astore 14
    //   551: iconst_0
    //   552: istore_3
    //   553: iload_3
    //   554: iload 6
    //   556: if_icmpge +999 -> 1555
    //   559: aload 16
    //   561: invokevirtual 513	java/nio/ByteBuffer:getShort	()S
    //   564: newarray byte
    //   566: astore 17
    //   568: aload 16
    //   570: aload 17
    //   572: invokevirtual 505	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   575: pop
    //   576: aload 16
    //   578: invokevirtual 513	java/nio/ByteBuffer:getShort	()S
    //   581: newarray byte
    //   583: astore 18
    //   585: aload 16
    //   587: aload 18
    //   589: invokevirtual 505	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   592: pop
    //   593: aload 16
    //   595: invokevirtual 503	java/nio/ByteBuffer:getInt	()I
    //   598: pop
    //   599: aload 16
    //   601: invokevirtual 503	java/nio/ByteBuffer:getInt	()I
    //   604: istore 7
    //   606: aload 16
    //   608: aload 16
    //   610: invokevirtual 521	java/nio/ByteBuffer:position	()I
    //   613: bipush 8
    //   615: iadd
    //   616: invokevirtual 524	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   619: pop
    //   620: iload 7
    //   622: iload 5
    //   624: if_icmple +600 -> 1224
    //   627: iload_3
    //   628: iconst_1
    //   629: iadd
    //   630: istore_3
    //   631: goto -78 -> 553
    //   634: aconst_null
    //   635: ldc_w 526
    //   638: ldc_w 528
    //   641: new 178	java/lang/StringBuilder
    //   644: dup
    //   645: invokespecial 179	java/lang/StringBuilder:<init>	()V
    //   648: ldc_w 530
    //   651: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   654: iload_3
    //   655: invokevirtual 197	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   658: invokevirtual 205	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   661: aconst_null
    //   662: fconst_0
    //   663: invokestatic 535	com/tencent/mobileqq/vas/VasMonitorHandler:a	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;F)V
    //   666: ldc_w 526
    //   669: ldc_w 528
    //   672: invokestatic 539	com/tencent/mobileqq/vas/VasMonitorDT:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   675: iconst_0
    //   676: istore 8
    //   678: goto -499 -> 179
    //   681: iconst_0
    //   682: istore 9
    //   684: aconst_null
    //   685: ldc_w 526
    //   688: ldc_w 541
    //   691: new 178	java/lang/StringBuilder
    //   694: dup
    //   695: invokespecial 179	java/lang/StringBuilder:<init>	()V
    //   698: ldc_w 530
    //   701: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   704: iload_3
    //   705: invokevirtual 197	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   708: invokevirtual 205	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   711: aconst_null
    //   712: fconst_0
    //   713: invokestatic 535	com/tencent/mobileqq/vas/VasMonitorHandler:a	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;F)V
    //   716: goto -533 -> 183
    //   719: astore 13
    //   721: invokestatic 174	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   724: ifeq +34 -> 758
    //   727: ldc_w 543
    //   730: iconst_2
    //   731: new 178	java/lang/StringBuilder
    //   734: dup
    //   735: invokespecial 179	java/lang/StringBuilder:<init>	()V
    //   738: ldc_w 545
    //   741: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   744: aload 13
    //   746: invokevirtual 548	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:getMessage	()Ljava/lang/String;
    //   749: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   752: invokevirtual 205	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   755: invokestatic 209	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   758: iconst_0
    //   759: istore 9
    //   761: goto -578 -> 183
    //   764: aconst_null
    //   765: ldc_w 526
    //   768: ldc_w 550
    //   771: aload_2
    //   772: invokevirtual 553	com/tencent/qphone/base/remote/FromServiceMsg:getBusinessFailMsg	()Ljava/lang/String;
    //   775: aconst_null
    //   776: fconst_0
    //   777: invokestatic 535	com/tencent/mobileqq/vas/VasMonitorHandler:a	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;F)V
    //   780: ldc_w 526
    //   783: ldc_w 550
    //   786: invokestatic 539	com/tencent/mobileqq/vas/VasMonitorDT:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   789: goto -602 -> 187
    //   792: iconst_0
    //   793: istore 8
    //   795: aload 15
    //   797: ldc_w 555
    //   800: iload_3
    //   801: invokevirtual 221	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   804: goto -470 -> 334
    //   807: astore 13
    //   809: invokestatic 174	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   812: ifeq +34 -> 846
    //   815: ldc_w 543
    //   818: iconst_2
    //   819: new 178	java/lang/StringBuilder
    //   822: dup
    //   823: invokespecial 179	java/lang/StringBuilder:<init>	()V
    //   826: ldc_w 545
    //   829: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   832: aload 13
    //   834: invokevirtual 556	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   837: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   840: invokevirtual 205	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   843: invokestatic 209	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   846: iconst_0
    //   847: istore 9
    //   849: goto -511 -> 338
    //   852: aconst_null
    //   853: ldc_w 558
    //   856: ldc_w 560
    //   859: new 178	java/lang/StringBuilder
    //   862: dup
    //   863: invokespecial 179	java/lang/StringBuilder:<init>	()V
    //   866: ldc_w 530
    //   869: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   872: iload_3
    //   873: invokevirtual 197	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   876: invokevirtual 205	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   879: aconst_null
    //   880: fconst_0
    //   881: invokestatic 535	com/tencent/mobileqq/vas/VasMonitorHandler:a	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;F)V
    //   884: ldc_w 558
    //   887: iload_3
    //   888: invokestatic 562	com/tencent/mobileqq/vas/VasMonitorDT:a	(Ljava/lang/String;I)V
    //   891: aload 15
    //   893: ldc_w 564
    //   896: iload_3
    //   897: invokevirtual 221	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   900: iload_3
    //   901: ldc_w 565
    //   904: if_icmpne +22 -> 926
    //   907: aload 15
    //   909: ldc_w 567
    //   912: aload 13
    //   914: getfield 137	com/tencent/pb/signature/SigActPb$RspBody:auth_rsp	Lcom/tencent/pb/signature/SigActPb$SigauthRsp;
    //   917: getfield 568	com/tencent/pb/signature/SigActPb$SigauthRsp:url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   920: invokevirtual 239	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   923: invokevirtual 243	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   926: aload 13
    //   928: getfield 137	com/tencent/pb/signature/SigActPb$RspBody:auth_rsp	Lcom/tencent/pb/signature/SigActPb$SigauthRsp;
    //   931: getfield 571	com/tencent/pb/signature/SigActPb$SigauthRsp:authfailed_appid	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   934: invokevirtual 572	com/tencent/mobileqq/pb/PBInt32Field:has	()Z
    //   937: ifeq +22 -> 959
    //   940: aload 15
    //   942: ldc_w 574
    //   945: aload 13
    //   947: getfield 137	com/tencent/pb/signature/SigActPb$RspBody:auth_rsp	Lcom/tencent/pb/signature/SigActPb$SigauthRsp;
    //   950: getfield 571	com/tencent/pb/signature/SigActPb$SigauthRsp:authfailed_appid	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   953: invokevirtual 194	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   956: invokevirtual 221	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   959: aload 13
    //   961: getfield 137	com/tencent/pb/signature/SigActPb$RspBody:auth_rsp	Lcom/tencent/pb/signature/SigActPb$SigauthRsp;
    //   964: getfield 143	com/tencent/pb/signature/SigActPb$SigauthRsp:tips_info	Lcom/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo;
    //   967: invokevirtual 148	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo:has	()Z
    //   970: ifeq +216 -> 1186
    //   973: new 145	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo
    //   976: dup
    //   977: invokespecial 149	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo:<init>	()V
    //   980: astore 14
    //   982: aload 14
    //   984: aload 13
    //   986: getfield 137	com/tencent/pb/signature/SigActPb$RspBody:auth_rsp	Lcom/tencent/pb/signature/SigActPb$SigauthRsp;
    //   989: getfield 143	com/tencent/pb/signature/SigActPb$SigauthRsp:tips_info	Lcom/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo;
    //   992: invokevirtual 153	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   995: checkcast 145	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo
    //   998: invokevirtual 157	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo:toByteArray	()[B
    //   1001: invokevirtual 161	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1004: pop
    //   1005: aload 14
    //   1007: getfield 165	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo:valid	Lcom/tencent/mobileqq/pb/PBBoolField;
    //   1010: invokevirtual 169	com/tencent/mobileqq/pb/PBBoolField:get	()Z
    //   1013: istore 8
    //   1015: aload 15
    //   1017: ldc 210
    //   1019: iload 8
    //   1021: invokevirtual 216	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   1024: iload 8
    //   1026: ifeq +126 -> 1152
    //   1029: aload 15
    //   1031: ldc 223
    //   1033: aload 14
    //   1035: getfield 226	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo:type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1038: invokevirtual 229	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1041: invokevirtual 221	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1044: aload 15
    //   1046: ldc 231
    //   1048: aload 14
    //   1050: getfield 235	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo:title_wording	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1053: invokevirtual 239	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1056: invokevirtual 243	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1059: aload 15
    //   1061: ldc 245
    //   1063: aload 14
    //   1065: getfield 247	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo:wording	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1068: invokevirtual 239	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1071: invokevirtual 243	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1074: aload 15
    //   1076: ldc 249
    //   1078: aload 14
    //   1080: getfield 252	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo:right_btn_wording	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1083: invokevirtual 239	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1086: invokevirtual 243	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1089: aload 15
    //   1091: ldc 254
    //   1093: aload 14
    //   1095: getfield 257	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo:left_btn_wording	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1098: invokevirtual 239	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1101: invokevirtual 243	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1104: aload 15
    //   1106: ldc_w 259
    //   1109: aload 14
    //   1111: getfield 262	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo:vip_type	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1114: invokevirtual 239	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1117: invokevirtual 243	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1120: aload 15
    //   1122: ldc_w 264
    //   1125: aload 14
    //   1127: getfield 267	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo:vip_month	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1130: invokevirtual 229	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1133: invokevirtual 221	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1136: aload 15
    //   1138: ldc_w 269
    //   1141: aload 14
    //   1143: getfield 271	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo:url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1146: invokevirtual 239	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1149: invokevirtual 243	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1152: invokestatic 174	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1155: ifeq +31 -> 1186
    //   1158: ldc_w 273
    //   1161: iconst_2
    //   1162: new 178	java/lang/StringBuilder
    //   1165: dup
    //   1166: invokespecial 179	java/lang/StringBuilder:<init>	()V
    //   1169: ldc_w 576
    //   1172: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1175: aload 15
    //   1177: invokevirtual 280	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1180: invokevirtual 205	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1183: invokestatic 283	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1186: iconst_0
    //   1187: istore 8
    //   1189: goto -855 -> 334
    //   1192: aconst_null
    //   1193: ldc_w 558
    //   1196: ldc_w 578
    //   1199: aload_2
    //   1200: invokevirtual 553	com/tencent/qphone/base/remote/FromServiceMsg:getBusinessFailMsg	()Ljava/lang/String;
    //   1203: aconst_null
    //   1204: fconst_0
    //   1205: invokestatic 535	com/tencent/mobileqq/vas/VasMonitorHandler:a	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;F)V
    //   1208: ldc_w 558
    //   1211: iconst_m1
    //   1212: invokestatic 562	com/tencent/mobileqq/vas/VasMonitorDT:a	(Ljava/lang/String;I)V
    //   1215: goto -877 -> 338
    //   1218: iconst_0
    //   1219: istore 8
    //   1221: goto -700 -> 521
    //   1224: aload 18
    //   1226: invokestatic 584	com/tencent/mobileqq/richstatus/RichStatus:parseStatus	([B)Lcom/tencent/mobileqq/richstatus/RichStatus;
    //   1229: astore 18
    //   1231: aload 18
    //   1233: iload 7
    //   1235: i2l
    //   1236: putfield 587	com/tencent/mobileqq/richstatus/RichStatus:time	J
    //   1239: aload 18
    //   1241: aload 17
    //   1243: putfield 590	com/tencent/mobileqq/richstatus/RichStatus:key	[B
    //   1246: aload 18
    //   1248: getfield 590	com/tencent/mobileqq/richstatus/RichStatus:key	[B
    //   1251: ifnull +20 -> 1271
    //   1254: aload 18
    //   1256: new 592	java/lang/String
    //   1259: dup
    //   1260: aload 18
    //   1262: getfield 590	com/tencent/mobileqq/richstatus/RichStatus:key	[B
    //   1265: invokespecial 595	java/lang/String:<init>	([B)V
    //   1268: putfield 599	com/tencent/mobileqq/richstatus/RichStatus:feedsId	Ljava/lang/String;
    //   1271: aload 13
    //   1273: getfield 518	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:richStatus	Ljava/util/ArrayList;
    //   1276: aload 18
    //   1278: invokevirtual 102	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1281: pop
    //   1282: goto -655 -> 627
    //   1285: astore 13
    //   1287: iconst_0
    //   1288: istore 9
    //   1290: aload 13
    //   1292: invokevirtual 602	java/lang/Exception:printStackTrace	()V
    //   1295: iload 9
    //   1297: istore 8
    //   1299: invokestatic 174	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1302: ifeq +19 -> 1321
    //   1305: ldc_w 543
    //   1308: iconst_2
    //   1309: aload 13
    //   1311: invokevirtual 556	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1314: invokestatic 605	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1317: iload 9
    //   1319: istore 8
    //   1321: aload_0
    //   1322: aload_1
    //   1323: iload 4
    //   1325: iload 8
    //   1327: aload 15
    //   1329: ldc_w 460
    //   1332: invokevirtual 464	com/tencent/mobileqq/richstatus/StatusServlet:notifyObserver	(Landroid/content/Intent;IZLandroid/os/Bundle;Ljava/lang/Class;)V
    //   1335: iload 4
    //   1337: bipush 8
    //   1339: if_icmpne +3241 -> 4580
    //   1342: iload 8
    //   1344: ifeq +3233 -> 4577
    //   1347: new 326	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   1350: dup
    //   1351: invokespecial 327	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   1354: astore 13
    //   1356: aload 13
    //   1358: aload_2
    //   1359: invokevirtual 430	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   1362: invokestatic 435	com/tencent/mobileqq/utils/WupUtil:b	([B)[B
    //   1365: invokevirtual 436	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1368: checkcast 326	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   1371: astore 13
    //   1373: aload 13
    //   1375: ifnull +3199 -> 4574
    //   1378: aload 13
    //   1380: getfield 439	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1383: invokevirtual 440	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   1386: ifeq +3188 -> 4574
    //   1389: aload 13
    //   1391: getfield 439	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1394: invokevirtual 229	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1397: ifne +400 -> 1797
    //   1400: aload 13
    //   1402: getfield 368	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1405: invokevirtual 443	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1408: invokevirtual 444	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   1411: invokestatic 447	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   1414: invokevirtual 450	java/nio/ByteBuffer:get	()B
    //   1417: istore_3
    //   1418: iload_3
    //   1419: ifne +372 -> 1791
    //   1422: iconst_1
    //   1423: istore 8
    //   1425: aload_0
    //   1426: aload_1
    //   1427: iload 4
    //   1429: iload 8
    //   1431: aload 15
    //   1433: ldc_w 460
    //   1436: invokevirtual 464	com/tencent/mobileqq/richstatus/StatusServlet:notifyObserver	(Landroid/content/Intent;IZLandroid/os/Bundle;Ljava/lang/Class;)V
    //   1439: iload 4
    //   1441: iconst_1
    //   1442: if_icmpeq +9 -> 1451
    //   1445: iload 4
    //   1447: iconst_2
    //   1448: if_icmpne +106 -> 1554
    //   1451: aload_2
    //   1452: invokevirtual 430	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   1455: invokestatic 447	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   1458: astore_2
    //   1459: aload_2
    //   1460: invokevirtual 503	java/nio/ByteBuffer:getInt	()I
    //   1463: iconst_4
    //   1464: isub
    //   1465: newarray byte
    //   1467: astore 13
    //   1469: aload_2
    //   1470: aload 13
    //   1472: invokevirtual 505	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   1475: pop
    //   1476: new 326	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   1479: dup
    //   1480: invokespecial 327	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   1483: aload 13
    //   1485: invokevirtual 436	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1488: checkcast 326	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   1491: getfield 368	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1494: invokevirtual 443	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1497: invokevirtual 444	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   1500: invokestatic 447	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   1503: astore_2
    //   1504: aload_2
    //   1505: invokevirtual 450	java/nio/ByteBuffer:get	()B
    //   1508: istore_3
    //   1509: aload_2
    //   1510: invokevirtual 503	java/nio/ByteBuffer:getInt	()I
    //   1513: i2l
    //   1514: lstore 11
    //   1516: aload_2
    //   1517: invokevirtual 450	java/nio/ByteBuffer:get	()B
    //   1520: iconst_1
    //   1521: if_icmpne +327 -> 1848
    //   1524: iconst_1
    //   1525: istore 9
    //   1527: goto +3059 -> 4586
    //   1530: aload 15
    //   1532: ldc_w 320
    //   1535: iload 10
    //   1537: invokevirtual 216	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   1540: aload_0
    //   1541: aload_1
    //   1542: iload 4
    //   1544: iload 9
    //   1546: aload 15
    //   1548: ldc_w 460
    //   1551: invokevirtual 464	com/tencent/mobileqq/richstatus/StatusServlet:notifyObserver	(Landroid/content/Intent;IZLandroid/os/Bundle;Ljava/lang/Class;)V
    //   1554: return
    //   1555: aload 13
    //   1557: getfield 518	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:richStatus	Ljava/util/ArrayList;
    //   1560: invokevirtual 608	java/util/ArrayList:isEmpty	()Z
    //   1563: ifeq +90 -> 1653
    //   1566: aload 13
    //   1568: getfield 484	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:startTime	I
    //   1571: ifne +82 -> 1653
    //   1574: aload 13
    //   1576: getfield 490	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:endTime	I
    //   1579: ldc_w 487
    //   1582: if_icmpne +71 -> 1653
    //   1585: aload_0
    //   1586: invokevirtual 414	com/tencent/mobileqq/richstatus/StatusServlet:getAppRuntime	()Lmqq/app/AppRuntime;
    //   1589: getstatic 611	com/tencent/mobileqq/app/QQManagerFactory:FRIENDS_MANAGER	I
    //   1592: invokevirtual 425	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   1595: checkcast 613	com/tencent/mobileqq/app/FriendsManager
    //   1598: lload 11
    //   1600: invokestatic 617	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1603: invokevirtual 620	com/tencent/mobileqq/app/FriendsManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   1606: astore 16
    //   1608: aload 16
    //   1610: ifnull +43 -> 1653
    //   1613: getstatic 626	com/tencent/mobileqq/profilecard/bussiness/personalitysign/utils/RichStatusUtils:Companion	Lcom/tencent/mobileqq/profilecard/bussiness/personalitysign/utils/RichStatusUtils$Companion;
    //   1616: aload 16
    //   1618: invokevirtual 632	com/tencent/mobileqq/profilecard/bussiness/personalitysign/utils/RichStatusUtils$Companion:getRichStatus	(Lcom/tencent/mobileqq/data/Card;)Lcom/tencent/mobileqq/richstatus/RichStatus;
    //   1621: astore 16
    //   1623: aload 16
    //   1625: ifnull +28 -> 1653
    //   1628: aload 16
    //   1630: invokevirtual 633	com/tencent/mobileqq/richstatus/RichStatus:isEmpty	()Z
    //   1633: ifne +20 -> 1653
    //   1636: aload 13
    //   1638: getfield 518	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:richStatus	Ljava/util/ArrayList;
    //   1641: aload 16
    //   1643: invokevirtual 102	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1646: pop
    //   1647: aload 13
    //   1649: iconst_1
    //   1650: putfield 494	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:isAddFromCard	Z
    //   1653: aload 14
    //   1655: getstatic 638	com/tencent/mobileqq/app/BusinessHandlerFactory:SIGNATURE_HANDLER	Ljava/lang/String;
    //   1658: invokevirtual 642	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(Ljava/lang/String;)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   1661: checkcast 644	com/tencent/mobileqq/app/SignatureHandler
    //   1664: astore 16
    //   1666: aload 13
    //   1668: getfield 518	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:richStatus	Ljava/util/ArrayList;
    //   1671: invokevirtual 73	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   1674: astore 17
    //   1676: aload 17
    //   1678: invokeinterface 79 1 0
    //   1683: ifeq +42 -> 1725
    //   1686: aload 17
    //   1688: invokeinterface 83 1 0
    //   1693: checkcast 580	com/tencent/mobileqq/richstatus/RichStatus
    //   1696: astore 18
    //   1698: aload 16
    //   1700: ifnull -24 -> 1676
    //   1703: aload 16
    //   1705: lload 11
    //   1707: invokestatic 617	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1710: aload 18
    //   1712: getfield 599	com/tencent/mobileqq/richstatus/RichStatus:feedsId	Ljava/lang/String;
    //   1715: sipush 255
    //   1718: iconst_1
    //   1719: invokevirtual 647	com/tencent/mobileqq/app/SignatureHandler:a	(Ljava/lang/String;Ljava/lang/String;IZ)V
    //   1722: goto -46 -> 1676
    //   1725: aload 13
    //   1727: iload 8
    //   1729: putfield 650	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:over	Z
    //   1732: aload 14
    //   1734: getstatic 653	com/tencent/mobileqq/app/QQManagerFactory:SIGNATURE_MANAGER	I
    //   1737: invokevirtual 654	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1740: checkcast 656	com/tencent/mobileqq/app/SignatureManager
    //   1743: astore 16
    //   1745: iload 9
    //   1747: istore 8
    //   1749: aload 16
    //   1751: ifnull -430 -> 1321
    //   1754: iload 9
    //   1756: istore 8
    //   1758: aload 14
    //   1760: invokevirtual 310	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1763: lload 11
    //   1765: invokestatic 660	java/lang/Long:toString	(J)Ljava/lang/String;
    //   1768: invokevirtual 663	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1771: ifeq -450 -> 1321
    //   1774: aload 16
    //   1776: aload 13
    //   1778: getfield 518	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:richStatus	Ljava/util/ArrayList;
    //   1781: invokevirtual 666	com/tencent/mobileqq/app/SignatureManager:a	(Ljava/util/List;)V
    //   1784: iload 9
    //   1786: istore 8
    //   1788: goto -467 -> 1321
    //   1791: iconst_0
    //   1792: istore 8
    //   1794: goto -369 -> 1425
    //   1797: iconst_0
    //   1798: istore 8
    //   1800: goto -375 -> 1425
    //   1803: astore 13
    //   1805: invokestatic 174	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1808: ifeq +34 -> 1842
    //   1811: ldc_w 543
    //   1814: iconst_2
    //   1815: new 178	java/lang/StringBuilder
    //   1818: dup
    //   1819: invokespecial 179	java/lang/StringBuilder:<init>	()V
    //   1822: ldc_w 545
    //   1825: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1828: aload 13
    //   1830: invokevirtual 548	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:getMessage	()Ljava/lang/String;
    //   1833: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1836: invokevirtual 205	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1839: invokestatic 209	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1842: iconst_0
    //   1843: istore 8
    //   1845: goto -420 -> 1425
    //   1848: iconst_0
    //   1849: istore 9
    //   1851: goto +2735 -> 4586
    //   1854: iload 9
    //   1856: istore 10
    //   1858: iload 8
    //   1860: istore 9
    //   1862: iload 4
    //   1864: iconst_2
    //   1865: if_icmpne -335 -> 1530
    //   1868: aload_1
    //   1869: ldc_w 320
    //   1872: iconst_0
    //   1873: invokevirtual 670	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   1876: istore 10
    //   1878: iload 8
    //   1880: istore 9
    //   1882: goto -352 -> 1530
    //   1885: astore_2
    //   1886: iconst_0
    //   1887: istore 8
    //   1889: aload_2
    //   1890: invokevirtual 602	java/lang/Exception:printStackTrace	()V
    //   1893: iload 8
    //   1895: istore 9
    //   1897: invokestatic 174	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1900: ifeq -360 -> 1540
    //   1903: ldc_w 543
    //   1906: iconst_2
    //   1907: aload_2
    //   1908: invokevirtual 556	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1911: invokestatic 605	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1914: iload 8
    //   1916: istore 9
    //   1918: goto -378 -> 1540
    //   1921: iload 4
    //   1923: tableswitch	default:+49 -> 1972, 1:+64->1987, 2:+64->1987, 3:+793->2716, 4:+219->2142, 5:+906->2829, 6:+1322->3245, 7:+1799->3722, 8:+2499->4422, 9:+1976->3899
    //   1973: aload_1
    //   1974: iload 4
    //   1976: iload 8
    //   1978: aload 15
    //   1980: ldc_w 460
    //   1983: invokevirtual 464	com/tencent/mobileqq/richstatus/StatusServlet:notifyObserver	(Landroid/content/Intent;IZLandroid/os/Bundle;Ljava/lang/Class;)V
    //   1986: return
    //   1987: aload_2
    //   1988: invokevirtual 430	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   1991: invokestatic 447	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   1994: astore_2
    //   1995: aload_2
    //   1996: invokevirtual 503	java/nio/ByteBuffer:getInt	()I
    //   1999: iconst_4
    //   2000: isub
    //   2001: newarray byte
    //   2003: astore 13
    //   2005: aload_2
    //   2006: aload 13
    //   2008: invokevirtual 505	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   2011: pop
    //   2012: new 326	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   2015: dup
    //   2016: invokespecial 327	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   2019: aload 13
    //   2021: invokevirtual 436	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2024: checkcast 326	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   2027: getfield 368	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   2030: invokevirtual 443	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   2033: invokevirtual 444	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   2036: invokestatic 447	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   2039: astore_2
    //   2040: aload_2
    //   2041: invokevirtual 450	java/nio/ByteBuffer:get	()B
    //   2044: istore_3
    //   2045: aload_2
    //   2046: invokevirtual 503	java/nio/ByteBuffer:getInt	()I
    //   2049: i2l
    //   2050: lstore 11
    //   2052: aload_2
    //   2053: invokevirtual 450	java/nio/ByteBuffer:get	()B
    //   2056: iconst_1
    //   2057: if_icmpne +2565 -> 4622
    //   2060: iconst_1
    //   2061: istore 9
    //   2063: goto +2541 -> 4604
    //   2066: aload 15
    //   2068: ldc_w 320
    //   2071: iload 10
    //   2073: invokevirtual 216	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   2076: iload 9
    //   2078: istore 8
    //   2080: goto -108 -> 1972
    //   2083: iload 9
    //   2085: istore 10
    //   2087: iload 8
    //   2089: istore 9
    //   2091: iload 4
    //   2093: iconst_2
    //   2094: if_icmpne -28 -> 2066
    //   2097: aload_1
    //   2098: ldc_w 320
    //   2101: iconst_0
    //   2102: invokevirtual 670	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   2105: istore 10
    //   2107: iload 8
    //   2109: istore 9
    //   2111: goto -45 -> 2066
    //   2114: astore_2
    //   2115: aload_2
    //   2116: invokevirtual 602	java/lang/Exception:printStackTrace	()V
    //   2119: invokestatic 174	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2122: ifeq +14 -> 2136
    //   2125: ldc_w 543
    //   2128: iconst_2
    //   2129: aload_2
    //   2130: invokevirtual 556	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2133: invokestatic 605	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   2136: iconst_0
    //   2137: istore 8
    //   2139: goto -167 -> 1972
    //   2142: new 478	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory
    //   2145: dup
    //   2146: invokespecial 479	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:<init>	()V
    //   2149: astore 13
    //   2151: aload 13
    //   2153: aload_1
    //   2154: ldc_w 481
    //   2157: iconst_0
    //   2158: invokevirtual 404	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   2161: putfield 484	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:startTime	I
    //   2164: aload 13
    //   2166: aload_1
    //   2167: ldc_w 486
    //   2170: ldc_w 487
    //   2173: invokevirtual 404	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   2176: putfield 490	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:endTime	I
    //   2179: aload 13
    //   2181: iconst_0
    //   2182: putfield 494	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:isAddFromCard	Z
    //   2185: aload 15
    //   2187: ldc_w 496
    //   2190: aload 13
    //   2192: invokevirtual 500	android/os/Bundle:putSerializable	(Ljava/lang/String;Ljava/io/Serializable;)V
    //   2195: aload_2
    //   2196: invokevirtual 430	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   2199: invokestatic 447	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   2202: astore_2
    //   2203: aload_2
    //   2204: invokevirtual 503	java/nio/ByteBuffer:getInt	()I
    //   2207: iconst_4
    //   2208: isub
    //   2209: newarray byte
    //   2211: astore 14
    //   2213: aload_2
    //   2214: aload 14
    //   2216: invokevirtual 505	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   2219: pop
    //   2220: new 326	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   2223: dup
    //   2224: invokespecial 327	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   2227: aload 14
    //   2229: invokevirtual 436	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2232: checkcast 326	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   2235: getfield 368	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   2238: invokevirtual 443	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   2241: invokevirtual 444	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   2244: invokestatic 447	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   2247: astore 14
    //   2249: aload 14
    //   2251: invokevirtual 450	java/nio/ByteBuffer:get	()B
    //   2254: pop
    //   2255: aload 14
    //   2257: invokevirtual 509	java/nio/ByteBuffer:getLong	()J
    //   2260: lstore 11
    //   2262: aload 14
    //   2264: invokevirtual 450	java/nio/ByteBuffer:get	()B
    //   2267: pop
    //   2268: aload 14
    //   2270: invokevirtual 503	java/nio/ByteBuffer:getInt	()I
    //   2273: pop
    //   2274: aload 14
    //   2276: invokevirtual 503	java/nio/ByteBuffer:getInt	()I
    //   2279: istore 5
    //   2281: aload 14
    //   2283: invokevirtual 503	java/nio/ByteBuffer:getInt	()I
    //   2286: pop
    //   2287: aload 14
    //   2289: invokevirtual 450	java/nio/ByteBuffer:get	()B
    //   2292: ifeq +2343 -> 4635
    //   2295: iconst_1
    //   2296: istore 9
    //   2298: aload 14
    //   2300: invokevirtual 513	java/nio/ByteBuffer:getShort	()S
    //   2303: istore 6
    //   2305: aload 13
    //   2307: new 64	java/util/ArrayList
    //   2310: dup
    //   2311: iload 6
    //   2313: invokespecial 515	java/util/ArrayList:<init>	(I)V
    //   2316: putfield 518	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:richStatus	Ljava/util/ArrayList;
    //   2319: aload_0
    //   2320: invokevirtual 414	com/tencent/mobileqq/richstatus/StatusServlet:getAppRuntime	()Lmqq/app/AppRuntime;
    //   2323: checkcast 292	com/tencent/mobileqq/app/QQAppInterface
    //   2326: astore_2
    //   2327: iconst_0
    //   2328: istore_3
    //   2329: iload_3
    //   2330: iload 6
    //   2332: if_icmpge +163 -> 2495
    //   2335: aload 14
    //   2337: invokevirtual 513	java/nio/ByteBuffer:getShort	()S
    //   2340: newarray byte
    //   2342: astore 16
    //   2344: aload 14
    //   2346: aload 16
    //   2348: invokevirtual 505	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   2351: pop
    //   2352: aload 14
    //   2354: invokevirtual 513	java/nio/ByteBuffer:getShort	()S
    //   2357: newarray byte
    //   2359: astore 17
    //   2361: aload 14
    //   2363: aload 17
    //   2365: invokevirtual 505	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   2368: pop
    //   2369: aload 14
    //   2371: invokevirtual 503	java/nio/ByteBuffer:getInt	()I
    //   2374: pop
    //   2375: aload 14
    //   2377: invokevirtual 503	java/nio/ByteBuffer:getInt	()I
    //   2380: istore 7
    //   2382: aload 14
    //   2384: aload 14
    //   2386: invokevirtual 521	java/nio/ByteBuffer:position	()I
    //   2389: bipush 8
    //   2391: iadd
    //   2392: invokevirtual 524	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   2395: pop
    //   2396: iload 7
    //   2398: iload 5
    //   2400: if_icmple +6 -> 2406
    //   2403: goto +2225 -> 4628
    //   2406: aload 17
    //   2408: invokestatic 584	com/tencent/mobileqq/richstatus/RichStatus:parseStatus	([B)Lcom/tencent/mobileqq/richstatus/RichStatus;
    //   2411: astore 17
    //   2413: aload 17
    //   2415: iload 7
    //   2417: i2l
    //   2418: putfield 587	com/tencent/mobileqq/richstatus/RichStatus:time	J
    //   2421: aload 17
    //   2423: aload 16
    //   2425: putfield 590	com/tencent/mobileqq/richstatus/RichStatus:key	[B
    //   2428: aload 17
    //   2430: getfield 590	com/tencent/mobileqq/richstatus/RichStatus:key	[B
    //   2433: ifnull +20 -> 2453
    //   2436: aload 17
    //   2438: new 592	java/lang/String
    //   2441: dup
    //   2442: aload 17
    //   2444: getfield 590	com/tencent/mobileqq/richstatus/RichStatus:key	[B
    //   2447: invokespecial 595	java/lang/String:<init>	([B)V
    //   2450: putfield 599	com/tencent/mobileqq/richstatus/RichStatus:feedsId	Ljava/lang/String;
    //   2453: aload 13
    //   2455: getfield 518	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:richStatus	Ljava/util/ArrayList;
    //   2458: aload 17
    //   2460: invokevirtual 102	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2463: pop
    //   2464: goto +2164 -> 4628
    //   2467: astore_2
    //   2468: aload_2
    //   2469: invokevirtual 602	java/lang/Exception:printStackTrace	()V
    //   2472: invokestatic 174	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2475: ifeq +14 -> 2489
    //   2478: ldc_w 543
    //   2481: iconst_2
    //   2482: aload_2
    //   2483: invokevirtual 556	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2486: invokestatic 605	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   2489: iconst_0
    //   2490: istore 8
    //   2492: goto -520 -> 1972
    //   2495: aload 13
    //   2497: getfield 518	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:richStatus	Ljava/util/ArrayList;
    //   2500: invokevirtual 608	java/util/ArrayList:isEmpty	()Z
    //   2503: ifeq +90 -> 2593
    //   2506: aload 13
    //   2508: getfield 484	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:startTime	I
    //   2511: ifne +82 -> 2593
    //   2514: aload 13
    //   2516: getfield 490	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:endTime	I
    //   2519: ldc_w 487
    //   2522: if_icmpne +71 -> 2593
    //   2525: aload_0
    //   2526: invokevirtual 414	com/tencent/mobileqq/richstatus/StatusServlet:getAppRuntime	()Lmqq/app/AppRuntime;
    //   2529: getstatic 611	com/tencent/mobileqq/app/QQManagerFactory:FRIENDS_MANAGER	I
    //   2532: invokevirtual 425	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   2535: checkcast 613	com/tencent/mobileqq/app/FriendsManager
    //   2538: lload 11
    //   2540: invokestatic 617	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   2543: invokevirtual 620	com/tencent/mobileqq/app/FriendsManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   2546: astore 14
    //   2548: aload 14
    //   2550: ifnull +43 -> 2593
    //   2553: getstatic 626	com/tencent/mobileqq/profilecard/bussiness/personalitysign/utils/RichStatusUtils:Companion	Lcom/tencent/mobileqq/profilecard/bussiness/personalitysign/utils/RichStatusUtils$Companion;
    //   2556: aload 14
    //   2558: invokevirtual 632	com/tencent/mobileqq/profilecard/bussiness/personalitysign/utils/RichStatusUtils$Companion:getRichStatus	(Lcom/tencent/mobileqq/data/Card;)Lcom/tencent/mobileqq/richstatus/RichStatus;
    //   2561: astore 14
    //   2563: aload 14
    //   2565: ifnull +28 -> 2593
    //   2568: aload 14
    //   2570: invokevirtual 633	com/tencent/mobileqq/richstatus/RichStatus:isEmpty	()Z
    //   2573: ifne +20 -> 2593
    //   2576: aload 13
    //   2578: getfield 518	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:richStatus	Ljava/util/ArrayList;
    //   2581: aload 14
    //   2583: invokevirtual 102	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2586: pop
    //   2587: aload 13
    //   2589: iconst_1
    //   2590: putfield 494	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:isAddFromCard	Z
    //   2593: aload_2
    //   2594: getstatic 638	com/tencent/mobileqq/app/BusinessHandlerFactory:SIGNATURE_HANDLER	Ljava/lang/String;
    //   2597: invokevirtual 642	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(Ljava/lang/String;)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   2600: checkcast 644	com/tencent/mobileqq/app/SignatureHandler
    //   2603: astore 14
    //   2605: aload 13
    //   2607: getfield 518	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:richStatus	Ljava/util/ArrayList;
    //   2610: invokevirtual 73	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   2613: astore 16
    //   2615: aload 16
    //   2617: invokeinterface 79 1 0
    //   2622: ifeq +42 -> 2664
    //   2625: aload 16
    //   2627: invokeinterface 83 1 0
    //   2632: checkcast 580	com/tencent/mobileqq/richstatus/RichStatus
    //   2635: astore 17
    //   2637: aload 14
    //   2639: ifnull -24 -> 2615
    //   2642: aload 14
    //   2644: lload 11
    //   2646: invokestatic 617	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   2649: aload 17
    //   2651: getfield 599	com/tencent/mobileqq/richstatus/RichStatus:feedsId	Ljava/lang/String;
    //   2654: sipush 255
    //   2657: iconst_1
    //   2658: invokevirtual 647	com/tencent/mobileqq/app/SignatureHandler:a	(Ljava/lang/String;Ljava/lang/String;IZ)V
    //   2661: goto -46 -> 2615
    //   2664: aload 13
    //   2666: iload 9
    //   2668: putfield 650	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:over	Z
    //   2671: aload_2
    //   2672: getstatic 653	com/tencent/mobileqq/app/QQManagerFactory:SIGNATURE_MANAGER	I
    //   2675: invokevirtual 654	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   2678: checkcast 656	com/tencent/mobileqq/app/SignatureManager
    //   2681: astore 14
    //   2683: aload 14
    //   2685: ifnull +28 -> 2713
    //   2688: aload_2
    //   2689: invokevirtual 310	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   2692: lload 11
    //   2694: invokestatic 660	java/lang/Long:toString	(J)Ljava/lang/String;
    //   2697: invokevirtual 663	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2700: ifeq +13 -> 2713
    //   2703: aload 14
    //   2705: aload 13
    //   2707: getfield 518	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:richStatus	Ljava/util/ArrayList;
    //   2710: invokevirtual 666	com/tencent/mobileqq/app/SignatureManager:a	(Ljava/util/List;)V
    //   2713: goto -741 -> 1972
    //   2716: aload 15
    //   2718: ldc_w 672
    //   2721: aload_1
    //   2722: ldc_w 672
    //   2725: iconst_1
    //   2726: invokevirtual 670	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   2729: invokevirtual 216	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   2732: aload 15
    //   2734: ldc_w 674
    //   2737: aload_1
    //   2738: ldc_w 674
    //   2741: iconst_m1
    //   2742: invokevirtual 404	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   2745: invokevirtual 221	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   2748: new 676	com/qq/jce/wup/UniPacket
    //   2751: dup
    //   2752: iconst_1
    //   2753: invokespecial 679	com/qq/jce/wup/UniPacket:<init>	(Z)V
    //   2756: astore 13
    //   2758: aload 13
    //   2760: ldc_w 681
    //   2763: invokevirtual 685	com/qq/jce/wup/UniPacket:setEncodeName	(Ljava/lang/String;)V
    //   2766: aload 13
    //   2768: aload_2
    //   2769: invokevirtual 430	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   2772: invokevirtual 688	com/qq/jce/wup/UniPacket:decode	([B)V
    //   2775: aload 13
    //   2777: ldc_w 690
    //   2780: new 692	PersonalState/RespGetSameStateList
    //   2783: dup
    //   2784: invokespecial 693	PersonalState/RespGetSameStateList:<init>	()V
    //   2787: invokevirtual 697	com/qq/jce/wup/UniPacket:getByClass	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   2790: checkcast 692	PersonalState/RespGetSameStateList
    //   2793: astore_2
    //   2794: aload_2
    //   2795: getfield 701	PersonalState/RespGetSameStateList:oHead	LPersonalState/BusiRespHead;
    //   2798: getfield 706	PersonalState/BusiRespHead:iReplyCode	I
    //   2801: ifne +15 -> 2816
    //   2804: aload 15
    //   2806: ldc_w 708
    //   2809: aload_2
    //   2810: invokevirtual 500	android/os/Bundle:putSerializable	(Ljava/lang/String;Ljava/io/Serializable;)V
    //   2813: goto -841 -> 1972
    //   2816: iconst_0
    //   2817: istore 8
    //   2819: goto -6 -> 2813
    //   2822: astore_2
    //   2823: iconst_0
    //   2824: istore 8
    //   2826: goto -854 -> 1972
    //   2829: iload 8
    //   2831: ifeq -859 -> 1972
    //   2834: new 326	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   2837: dup
    //   2838: invokespecial 327	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   2841: astore 13
    //   2843: aload 13
    //   2845: aload_2
    //   2846: invokevirtual 430	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   2849: invokestatic 435	com/tencent/mobileqq/utils/WupUtil:b	([B)[B
    //   2852: invokevirtual 436	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2855: checkcast 326	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   2858: astore_2
    //   2859: aload_2
    //   2860: ifnull +368 -> 3228
    //   2863: aload_2
    //   2864: getfield 439	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2867: invokevirtual 440	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   2870: ifeq +358 -> 3228
    //   2873: aload_2
    //   2874: getfield 439	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2877: invokevirtual 229	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2880: istore_3
    //   2881: iload_3
    //   2882: ifne +331 -> 3213
    //   2885: aload_2
    //   2886: getfield 368	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   2889: invokevirtual 443	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   2892: invokevirtual 444	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   2895: invokestatic 447	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   2898: astore_2
    //   2899: aload_2
    //   2900: invokevirtual 450	java/nio/ByteBuffer:get	()B
    //   2903: istore_3
    //   2904: iload_3
    //   2905: ifne +239 -> 3144
    //   2908: aload_2
    //   2909: invokevirtual 513	java/nio/ByteBuffer:getShort	()S
    //   2912: istore 5
    //   2914: new 64	java/util/ArrayList
    //   2917: dup
    //   2918: invokespecial 65	java/util/ArrayList:<init>	()V
    //   2921: astore 13
    //   2923: iconst_0
    //   2924: istore_3
    //   2925: iload_3
    //   2926: iload 5
    //   2928: if_icmpge +90 -> 3018
    //   2931: aload_2
    //   2932: invokevirtual 513	java/nio/ByteBuffer:getShort	()S
    //   2935: newarray byte
    //   2937: astore 14
    //   2939: aload_2
    //   2940: aload 14
    //   2942: invokevirtual 505	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   2945: pop
    //   2946: aload 13
    //   2948: new 592	java/lang/String
    //   2951: dup
    //   2952: aload 14
    //   2954: invokespecial 595	java/lang/String:<init>	([B)V
    //   2957: invokevirtual 102	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2960: pop
    //   2961: iload_3
    //   2962: iconst_1
    //   2963: iadd
    //   2964: istore_3
    //   2965: goto -40 -> 2925
    //   2968: astore_2
    //   2969: aload_2
    //   2970: invokevirtual 709	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   2973: invokestatic 174	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2976: ifeq +33 -> 3009
    //   2979: ldc_w 543
    //   2982: iconst_2
    //   2983: new 178	java/lang/StringBuilder
    //   2986: dup
    //   2987: invokespecial 179	java/lang/StringBuilder:<init>	()V
    //   2990: ldc_w 545
    //   2993: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2996: aload_2
    //   2997: invokevirtual 548	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:getMessage	()Ljava/lang/String;
    //   3000: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3003: invokevirtual 205	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3006: invokestatic 209	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3009: iconst_0
    //   3010: istore 8
    //   3012: aload 13
    //   3014: astore_2
    //   3015: goto -156 -> 2859
    //   3018: new 64	java/util/ArrayList
    //   3021: dup
    //   3022: invokespecial 65	java/util/ArrayList:<init>	()V
    //   3025: astore 14
    //   3027: new 64	java/util/ArrayList
    //   3030: dup
    //   3031: invokespecial 65	java/util/ArrayList:<init>	()V
    //   3034: astore 16
    //   3036: aload_2
    //   3037: invokevirtual 513	java/nio/ByteBuffer:getShort	()S
    //   3040: istore 6
    //   3042: iconst_0
    //   3043: istore_3
    //   3044: iload_3
    //   3045: iload 6
    //   3047: if_icmpge +53 -> 3100
    //   3050: aload_2
    //   3051: invokevirtual 513	java/nio/ByteBuffer:getShort	()S
    //   3054: newarray byte
    //   3056: astore 17
    //   3058: aload_2
    //   3059: aload 17
    //   3061: invokevirtual 505	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   3064: pop
    //   3065: aload 14
    //   3067: new 592	java/lang/String
    //   3070: dup
    //   3071: aload 17
    //   3073: invokespecial 595	java/lang/String:<init>	([B)V
    //   3076: invokevirtual 102	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   3079: pop
    //   3080: aload 16
    //   3082: aload_2
    //   3083: invokevirtual 503	java/nio/ByteBuffer:getInt	()I
    //   3086: invokestatic 714	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3089: invokevirtual 102	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   3092: pop
    //   3093: iload_3
    //   3094: iconst_1
    //   3095: iadd
    //   3096: istore_3
    //   3097: goto -53 -> 3044
    //   3100: iload 5
    //   3102: ifle +16 -> 3118
    //   3105: aload 15
    //   3107: ldc_w 716
    //   3110: aload 13
    //   3112: invokevirtual 720	android/os/Bundle:putStringArrayList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   3115: goto +1526 -> 4641
    //   3118: aload 15
    //   3120: ldc_w 716
    //   3123: aload 14
    //   3125: invokevirtual 720	android/os/Bundle:putStringArrayList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   3128: aload 15
    //   3130: ldc_w 722
    //   3133: aload 16
    //   3135: invokevirtual 725	android/os/Bundle:putIntegerArrayList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   3138: iconst_0
    //   3139: istore 8
    //   3141: goto +1500 -> 4641
    //   3144: iconst_0
    //   3145: istore 8
    //   3147: aload 15
    //   3149: ldc_w 727
    //   3152: iload_3
    //   3153: invokevirtual 221	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   3156: goto +1485 -> 4641
    //   3159: astore_2
    //   3160: invokestatic 174	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3163: ifeq +33 -> 3196
    //   3166: ldc_w 543
    //   3169: iconst_2
    //   3170: new 178	java/lang/StringBuilder
    //   3173: dup
    //   3174: invokespecial 179	java/lang/StringBuilder:<init>	()V
    //   3177: ldc_w 729
    //   3180: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3183: aload_2
    //   3184: invokevirtual 556	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   3187: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3190: invokevirtual 205	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3193: invokestatic 605	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   3196: iconst_0
    //   3197: istore 8
    //   3199: aload 15
    //   3201: ldc_w 727
    //   3204: sipush -1002
    //   3207: invokevirtual 221	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   3210: goto +1431 -> 4641
    //   3213: iconst_0
    //   3214: istore 8
    //   3216: aload 15
    //   3218: ldc_w 727
    //   3221: iload_3
    //   3222: invokevirtual 221	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   3225: goto +1416 -> 4641
    //   3228: iconst_0
    //   3229: istore 8
    //   3231: aload 15
    //   3233: ldc_w 727
    //   3236: sipush -1001
    //   3239: invokevirtual 221	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   3242: goto +1399 -> 4641
    //   3245: new 676	com/qq/jce/wup/UniPacket
    //   3248: dup
    //   3249: iconst_1
    //   3250: invokespecial 679	com/qq/jce/wup/UniPacket:<init>	(Z)V
    //   3253: astore 14
    //   3255: aload 14
    //   3257: ldc_w 681
    //   3260: invokevirtual 685	com/qq/jce/wup/UniPacket:setEncodeName	(Ljava/lang/String;)V
    //   3263: aload 14
    //   3265: aload_2
    //   3266: invokevirtual 430	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   3269: invokevirtual 688	com/qq/jce/wup/UniPacket:decode	([B)V
    //   3272: aload 14
    //   3274: ldc_w 731
    //   3277: new 733	PersonalState/RespGetHotState
    //   3280: dup
    //   3281: invokespecial 734	PersonalState/RespGetHotState:<init>	()V
    //   3284: invokevirtual 697	com/qq/jce/wup/UniPacket:getByClass	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   3287: checkcast 733	PersonalState/RespGetHotState
    //   3290: astore 14
    //   3292: aload 14
    //   3294: getfield 735	PersonalState/RespGetHotState:oHead	LPersonalState/BusiRespHead;
    //   3297: getfield 706	PersonalState/BusiRespHead:iReplyCode	I
    //   3300: ifne +400 -> 3700
    //   3303: invokestatic 174	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3306: ifeq +159 -> 3465
    //   3309: new 178	java/lang/StringBuilder
    //   3312: dup
    //   3313: ldc_w 737
    //   3316: invokespecial 739	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3319: astore 16
    //   3321: aload 16
    //   3323: ldc_w 741
    //   3326: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3329: astore 17
    //   3331: aload 14
    //   3333: getfield 744	PersonalState/RespGetHotState:vHostRichSateList	Ljava/util/ArrayList;
    //   3336: ifnonnull +102 -> 3438
    //   3339: ldc_w 746
    //   3342: astore_2
    //   3343: aload 17
    //   3345: aload_2
    //   3346: invokevirtual 280	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3349: ldc_w 748
    //   3352: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3355: pop
    //   3356: aload 14
    //   3358: getfield 744	PersonalState/RespGetHotState:vHostRichSateList	Ljava/util/ArrayList;
    //   3361: ifnull +92 -> 3453
    //   3364: aload 14
    //   3366: getfield 744	PersonalState/RespGetHotState:vHostRichSateList	Ljava/util/ArrayList;
    //   3369: invokevirtual 749	java/util/ArrayList:size	()I
    //   3372: ifle +81 -> 3453
    //   3375: aload 14
    //   3377: getfield 744	PersonalState/RespGetHotState:vHostRichSateList	Ljava/util/ArrayList;
    //   3380: invokevirtual 73	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   3383: astore_2
    //   3384: aload_2
    //   3385: invokeinterface 79 1 0
    //   3390: ifeq +63 -> 3453
    //   3393: aload_2
    //   3394: invokeinterface 83 1 0
    //   3399: checkcast 751	PersonalState/HotRishState
    //   3402: astore 17
    //   3404: aload 16
    //   3406: ldc_w 753
    //   3409: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3412: aload 17
    //   3414: getfield 756	PersonalState/HotRishState:iActId	I
    //   3417: invokevirtual 197	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3420: ldc_w 758
    //   3423: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3426: aload 17
    //   3428: getfield 761	PersonalState/HotRishState:iDataId	I
    //   3431: invokevirtual 197	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3434: pop
    //   3435: goto -51 -> 3384
    //   3438: aload 14
    //   3440: getfield 744	PersonalState/RespGetHotState:vHostRichSateList	Ljava/util/ArrayList;
    //   3443: invokevirtual 749	java/util/ArrayList:size	()I
    //   3446: invokestatic 714	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3449: astore_2
    //   3450: goto -107 -> 3343
    //   3453: ldc_w 763
    //   3456: iconst_2
    //   3457: aload 16
    //   3459: invokevirtual 205	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3462: invokestatic 209	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3465: new 64	java/util/ArrayList
    //   3468: dup
    //   3469: bipush 6
    //   3471: invokespecial 515	java/util/ArrayList:<init>	(I)V
    //   3474: astore_2
    //   3475: aload 14
    //   3477: getfield 744	PersonalState/RespGetHotState:vHostRichSateList	Ljava/util/ArrayList;
    //   3480: ifnull +208 -> 3688
    //   3483: aload 14
    //   3485: getfield 744	PersonalState/RespGetHotState:vHostRichSateList	Ljava/util/ArrayList;
    //   3488: invokevirtual 749	java/util/ArrayList:size	()I
    //   3491: ifle +197 -> 3688
    //   3494: aload 13
    //   3496: ifnull +82 -> 3578
    //   3499: aload 13
    //   3501: invokevirtual 766	com/tencent/mobileqq/richstatus/StatusManager:a	()Lcom/tencent/mobileqq/richstatus/RichStatus;
    //   3504: astore 16
    //   3506: aload 14
    //   3508: getfield 744	PersonalState/RespGetHotState:vHostRichSateList	Ljava/util/ArrayList;
    //   3511: invokevirtual 749	java/util/ArrayList:size	()I
    //   3514: iconst_1
    //   3515: isub
    //   3516: istore_3
    //   3517: iload_3
    //   3518: iflt +60 -> 3578
    //   3521: aload 14
    //   3523: getfield 744	PersonalState/RespGetHotState:vHostRichSateList	Ljava/util/ArrayList;
    //   3526: iload_3
    //   3527: invokevirtual 769	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   3530: checkcast 751	PersonalState/HotRishState
    //   3533: astore 17
    //   3535: aload 17
    //   3537: getfield 756	PersonalState/HotRishState:iActId	I
    //   3540: aload 16
    //   3542: getfield 772	com/tencent/mobileqq/richstatus/RichStatus:actionId	I
    //   3545: if_icmpne +26 -> 3571
    //   3548: aload 17
    //   3550: getfield 761	PersonalState/HotRishState:iDataId	I
    //   3553: aload 16
    //   3555: getfield 775	com/tencent/mobileqq/richstatus/RichStatus:dataId	I
    //   3558: if_icmpne +13 -> 3571
    //   3561: aload 14
    //   3563: getfield 744	PersonalState/RespGetHotState:vHostRichSateList	Ljava/util/ArrayList;
    //   3566: iload_3
    //   3567: invokevirtual 778	java/util/ArrayList:remove	(I)Ljava/lang/Object;
    //   3570: pop
    //   3571: iload_3
    //   3572: iconst_1
    //   3573: isub
    //   3574: istore_3
    //   3575: goto -58 -> 3517
    //   3578: iconst_0
    //   3579: istore_3
    //   3580: iload_3
    //   3581: bipush 6
    //   3583: if_icmpge +24 -> 3607
    //   3586: aload_2
    //   3587: aload 14
    //   3589: getfield 744	PersonalState/RespGetHotState:vHostRichSateList	Ljava/util/ArrayList;
    //   3592: iload_3
    //   3593: invokevirtual 769	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   3596: invokevirtual 102	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   3599: pop
    //   3600: iload_3
    //   3601: iconst_1
    //   3602: iadd
    //   3603: istore_3
    //   3604: goto -24 -> 3580
    //   3607: new 178	java/lang/StringBuilder
    //   3610: dup
    //   3611: invokespecial 179	java/lang/StringBuilder:<init>	()V
    //   3614: astore 14
    //   3616: aload_2
    //   3617: invokevirtual 73	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   3620: astore 16
    //   3622: aload 16
    //   3624: invokeinterface 79 1 0
    //   3629: ifeq +49 -> 3678
    //   3632: aload 16
    //   3634: invokeinterface 83 1 0
    //   3639: checkcast 751	PersonalState/HotRishState
    //   3642: astore 17
    //   3644: aload 14
    //   3646: aload 17
    //   3648: getfield 756	PersonalState/HotRishState:iActId	I
    //   3651: invokevirtual 197	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3654: ldc_w 758
    //   3657: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3660: aload 17
    //   3662: getfield 761	PersonalState/HotRishState:iDataId	I
    //   3665: invokevirtual 197	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3668: ldc_w 780
    //   3671: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3674: pop
    //   3675: goto -53 -> 3622
    //   3678: aload 13
    //   3680: aload 14
    //   3682: invokevirtual 205	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3685: invokevirtual 782	com/tencent/mobileqq/richstatus/StatusManager:a	(Ljava/lang/String;)V
    //   3688: aload 15
    //   3690: ldc_w 784
    //   3693: aload_2
    //   3694: invokevirtual 500	android/os/Bundle:putSerializable	(Ljava/lang/String;Ljava/io/Serializable;)V
    //   3697: goto -1725 -> 1972
    //   3700: invokestatic 174	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3703: ifeq +13 -> 3716
    //   3706: ldc_w 763
    //   3709: iconst_2
    //   3710: ldc_w 786
    //   3713: invokestatic 209	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3716: iconst_0
    //   3717: istore 8
    //   3719: goto -1747 -> 1972
    //   3722: iload 8
    //   3724: ifeq -1752 -> 1972
    //   3727: new 326	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   3730: dup
    //   3731: invokespecial 327	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   3734: astore 13
    //   3736: aload 13
    //   3738: aload_2
    //   3739: invokevirtual 430	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   3742: invokestatic 435	com/tencent/mobileqq/utils/WupUtil:b	([B)[B
    //   3745: invokevirtual 436	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3748: checkcast 326	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   3751: astore_2
    //   3752: iload 8
    //   3754: istore 9
    //   3756: aload_2
    //   3757: ifnull +80 -> 3837
    //   3760: iload 8
    //   3762: istore 9
    //   3764: aload_2
    //   3765: getfield 439	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3768: invokevirtual 440	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   3771: ifeq +66 -> 3837
    //   3774: aload_2
    //   3775: getfield 439	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3778: invokevirtual 229	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3781: ifne +69 -> 3850
    //   3784: aload_2
    //   3785: getfield 368	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3788: invokevirtual 443	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   3791: invokevirtual 444	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   3794: invokestatic 447	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   3797: astore_2
    //   3798: aload_2
    //   3799: invokevirtual 450	java/nio/ByteBuffer:get	()B
    //   3802: ifne +42 -> 3844
    //   3805: aload 15
    //   3807: ldc_w 452
    //   3810: aload_2
    //   3811: invokevirtual 371	java/nio/ByteBuffer:array	()[B
    //   3814: invokevirtual 456	android/os/Bundle:putByteArray	(Ljava/lang/String;[B)V
    //   3817: aload 15
    //   3819: ldc_w 458
    //   3822: aload_1
    //   3823: ldc_w 458
    //   3826: iconst_0
    //   3827: invokevirtual 404	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   3830: invokevirtual 221	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   3833: iload 8
    //   3835: istore 9
    //   3837: iload 9
    //   3839: istore 8
    //   3841: goto -1869 -> 1972
    //   3844: iconst_0
    //   3845: istore 9
    //   3847: goto -10 -> 3837
    //   3850: iconst_0
    //   3851: istore 9
    //   3853: goto -16 -> 3837
    //   3856: astore_2
    //   3857: invokestatic 174	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3860: ifeq +33 -> 3893
    //   3863: ldc_w 543
    //   3866: iconst_2
    //   3867: new 178	java/lang/StringBuilder
    //   3870: dup
    //   3871: invokespecial 179	java/lang/StringBuilder:<init>	()V
    //   3874: ldc_w 545
    //   3877: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3880: aload_2
    //   3881: invokevirtual 548	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:getMessage	()Ljava/lang/String;
    //   3884: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3887: invokevirtual 205	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3890: invokestatic 209	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3893: iconst_0
    //   3894: istore 9
    //   3896: goto -59 -> 3837
    //   3899: iload 8
    //   3901: ifeq -1929 -> 1972
    //   3904: aload_1
    //   3905: ldc_w 458
    //   3908: iconst_0
    //   3909: invokevirtual 404	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   3912: istore_3
    //   3913: aload_2
    //   3914: invokevirtual 430	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   3917: arraylength
    //   3918: iconst_4
    //   3919: isub
    //   3920: istore 5
    //   3922: iload 5
    //   3924: newarray byte
    //   3926: astore 13
    //   3928: aload 13
    //   3930: iconst_0
    //   3931: aload_2
    //   3932: invokevirtual 430	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   3935: iconst_4
    //   3936: iload 5
    //   3938: invokestatic 470	com/tencent/mobileqq/utils/httputils/PkgTools:copyData	([BI[BII)V
    //   3941: new 133	com/tencent/pb/signature/SigActPb$RspBody
    //   3944: dup
    //   3945: invokespecial 471	com/tencent/pb/signature/SigActPb$RspBody:<init>	()V
    //   3948: astore 16
    //   3950: aload 16
    //   3952: aload 13
    //   3954: invokevirtual 472	com/tencent/pb/signature/SigActPb$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3957: pop
    //   3958: aload 16
    //   3960: getfield 473	com/tencent/pb/signature/SigActPb$RspBody:ret	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   3963: invokevirtual 194	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   3966: istore 5
    //   3968: aload 16
    //   3970: getfield 789	com/tencent/pb/signature/SigActPb$RspBody:desc	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3973: invokevirtual 790	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   3976: ifeq +177 -> 4153
    //   3979: aload 16
    //   3981: getfield 789	com/tencent/pb/signature/SigActPb$RspBody:desc	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3984: invokevirtual 239	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   3987: astore_2
    //   3988: iload 5
    //   3990: ifne +241 -> 4231
    //   3993: aload_2
    //   3994: astore 13
    //   3996: aload 16
    //   3998: getfield 137	com/tencent/pb/signature/SigActPb$RspBody:auth_rsp	Lcom/tencent/pb/signature/SigActPb$SigauthRsp;
    //   4001: getfield 476	com/tencent/pb/signature/SigActPb$SigauthRsp:result	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   4004: invokevirtual 443	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   4007: invokevirtual 444	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   4010: invokestatic 447	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   4013: astore 14
    //   4015: aload_2
    //   4016: astore 13
    //   4018: aload 14
    //   4020: invokevirtual 450	java/nio/ByteBuffer:get	()B
    //   4023: istore 5
    //   4025: iload 5
    //   4027: ifne +133 -> 4160
    //   4030: aload_2
    //   4031: astore 13
    //   4033: aload 15
    //   4035: ldc_w 452
    //   4038: aload 14
    //   4040: invokevirtual 371	java/nio/ByteBuffer:array	()[B
    //   4043: invokevirtual 456	android/os/Bundle:putByteArray	(Ljava/lang/String;[B)V
    //   4046: aload_2
    //   4047: astore 13
    //   4049: iload 8
    //   4051: istore 9
    //   4053: iload_3
    //   4054: iconst_1
    //   4055: if_icmpne +24 -> 4079
    //   4058: aload_2
    //   4059: astore 13
    //   4061: aload_0
    //   4062: aload 15
    //   4064: aload 16
    //   4066: ldc_w 792
    //   4069: invokespecial 794	com/tencent/mobileqq/richstatus/StatusServlet:a	(Landroid/os/Bundle;Lcom/tencent/pb/signature/SigActPb$RspBody;Ljava/lang/String;)V
    //   4072: iload 8
    //   4074: istore 9
    //   4076: aload_2
    //   4077: astore 13
    //   4079: iload 9
    //   4081: istore 8
    //   4083: aload 13
    //   4085: ifnull +13 -> 4098
    //   4088: aload 15
    //   4090: ldc_w 796
    //   4093: aload 13
    //   4095: invokevirtual 243	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   4098: aload 15
    //   4100: ldc_w 458
    //   4103: iload_3
    //   4104: invokevirtual 221	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   4107: invokestatic 799	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   4110: ifeq +534 -> 4644
    //   4113: ldc_w 273
    //   4116: iconst_1
    //   4117: ldc_w 801
    //   4120: iconst_3
    //   4121: anewarray 803	java/lang/Object
    //   4124: dup
    //   4125: iconst_0
    //   4126: iload 8
    //   4128: invokestatic 808	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   4131: aastore
    //   4132: dup
    //   4133: iconst_1
    //   4134: iload_3
    //   4135: invokestatic 714	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   4138: aastore
    //   4139: dup
    //   4140: iconst_2
    //   4141: aload 13
    //   4143: aastore
    //   4144: invokestatic 812	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   4147: invokestatic 283	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4150: goto +494 -> 4644
    //   4153: ldc_w 530
    //   4156: astore_2
    //   4157: goto -169 -> 3988
    //   4160: aload_2
    //   4161: astore 13
    //   4163: aload 15
    //   4165: ldc_w 555
    //   4168: iload 5
    //   4170: invokevirtual 221	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   4173: aload_2
    //   4174: astore 13
    //   4176: invokestatic 818	com/tencent/mobileqq/config/business/qvip/SSOErrorInfoMapProcessor:c	()Lcom/tencent/mobileqq/config/business/qvip/SSOErrorInfoMapConfig;
    //   4179: astore 17
    //   4181: aload_2
    //   4182: astore 13
    //   4184: aload_2
    //   4185: astore 14
    //   4187: aload_2
    //   4188: invokestatic 823	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4191: ifeq +456 -> 4647
    //   4194: aload_2
    //   4195: astore 13
    //   4197: aload 17
    //   4199: ldc_w 825
    //   4202: new 178	java/lang/StringBuilder
    //   4205: dup
    //   4206: invokespecial 179	java/lang/StringBuilder:<init>	()V
    //   4209: ldc_w 530
    //   4212: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4215: iload 5
    //   4217: invokevirtual 197	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4220: invokevirtual 205	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4223: invokevirtual 831	com/tencent/mobileqq/config/business/qvip/SSOErrorInfoMapConfig:getErrorInfo	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   4226: astore 14
    //   4228: goto +419 -> 4647
    //   4231: iconst_0
    //   4232: istore 9
    //   4234: aload_2
    //   4235: astore 13
    //   4237: aload 15
    //   4239: ldc_w 564
    //   4242: iload 5
    //   4244: invokevirtual 221	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   4247: iload 5
    //   4249: ldc_w 565
    //   4252: if_icmpne +25 -> 4277
    //   4255: aload_2
    //   4256: astore 13
    //   4258: aload 15
    //   4260: ldc_w 567
    //   4263: aload 16
    //   4265: getfield 137	com/tencent/pb/signature/SigActPb$RspBody:auth_rsp	Lcom/tencent/pb/signature/SigActPb$SigauthRsp;
    //   4268: getfield 568	com/tencent/pb/signature/SigActPb$SigauthRsp:url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   4271: invokevirtual 239	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   4274: invokevirtual 243	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   4277: aload_2
    //   4278: astore 13
    //   4280: aload 16
    //   4282: getfield 137	com/tencent/pb/signature/SigActPb$RspBody:auth_rsp	Lcom/tencent/pb/signature/SigActPb$SigauthRsp;
    //   4285: getfield 571	com/tencent/pb/signature/SigActPb$SigauthRsp:authfailed_appid	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   4288: invokevirtual 572	com/tencent/mobileqq/pb/PBInt32Field:has	()Z
    //   4291: ifeq +25 -> 4316
    //   4294: aload_2
    //   4295: astore 13
    //   4297: aload 15
    //   4299: ldc_w 574
    //   4302: aload 16
    //   4304: getfield 137	com/tencent/pb/signature/SigActPb$RspBody:auth_rsp	Lcom/tencent/pb/signature/SigActPb$SigauthRsp;
    //   4307: getfield 571	com/tencent/pb/signature/SigActPb$SigauthRsp:authfailed_appid	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   4310: invokevirtual 194	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   4313: invokevirtual 221	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   4316: aload_2
    //   4317: astore 13
    //   4319: aload_0
    //   4320: aload 15
    //   4322: aload 16
    //   4324: ldc_w 833
    //   4327: invokespecial 794	com/tencent/mobileqq/richstatus/StatusServlet:a	(Landroid/os/Bundle;Lcom/tencent/pb/signature/SigActPb$RspBody;Ljava/lang/String;)V
    //   4330: aload_2
    //   4331: astore 13
    //   4333: goto -254 -> 4079
    //   4336: astore_2
    //   4337: invokestatic 174	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4340: ifeq +33 -> 4373
    //   4343: ldc_w 543
    //   4346: iconst_2
    //   4347: new 178	java/lang/StringBuilder
    //   4350: dup
    //   4351: invokespecial 179	java/lang/StringBuilder:<init>	()V
    //   4354: ldc_w 545
    //   4357: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4360: aload_2
    //   4361: invokevirtual 556	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   4364: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4367: invokevirtual 205	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4370: invokestatic 209	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4373: iconst_0
    //   4374: istore 8
    //   4376: goto -293 -> 4083
    //   4379: astore_2
    //   4380: invokestatic 174	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4383: ifeq +33 -> 4416
    //   4386: ldc_w 543
    //   4389: iconst_2
    //   4390: new 178	java/lang/StringBuilder
    //   4393: dup
    //   4394: invokespecial 179	java/lang/StringBuilder:<init>	()V
    //   4397: ldc_w 545
    //   4400: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4403: aload_2
    //   4404: invokevirtual 556	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   4407: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4410: invokevirtual 205	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4413: invokestatic 209	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4416: iconst_0
    //   4417: istore 8
    //   4419: goto -2447 -> 1972
    //   4422: iload 8
    //   4424: ifeq -2452 -> 1972
    //   4427: new 326	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   4430: dup
    //   4431: invokespecial 327	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   4434: astore 13
    //   4436: aload 13
    //   4438: aload_2
    //   4439: invokevirtual 430	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   4442: invokestatic 435	com/tencent/mobileqq/utils/WupUtil:b	([B)[B
    //   4445: invokevirtual 436	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   4448: checkcast 326	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   4451: astore_2
    //   4452: iload 8
    //   4454: istore 9
    //   4456: aload_2
    //   4457: ifnull +55 -> 4512
    //   4460: iload 8
    //   4462: istore 9
    //   4464: aload_2
    //   4465: getfield 439	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4468: invokevirtual 440	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   4471: ifeq +41 -> 4512
    //   4474: aload_2
    //   4475: getfield 439	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4478: invokevirtual 229	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4481: ifne +44 -> 4525
    //   4484: aload_2
    //   4485: getfield 368	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   4488: invokevirtual 443	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   4491: invokevirtual 444	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   4494: invokestatic 447	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   4497: invokevirtual 450	java/nio/ByteBuffer:get	()B
    //   4500: istore_3
    //   4501: iload_3
    //   4502: ifne +17 -> 4519
    //   4505: iconst_1
    //   4506: istore 8
    //   4508: iload 8
    //   4510: istore 9
    //   4512: iload 9
    //   4514: istore 8
    //   4516: goto -2544 -> 1972
    //   4519: iconst_0
    //   4520: istore 8
    //   4522: goto -14 -> 4508
    //   4525: iconst_0
    //   4526: istore 9
    //   4528: goto -16 -> 4512
    //   4531: astore_2
    //   4532: invokestatic 174	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4535: ifeq +33 -> 4568
    //   4538: ldc_w 543
    //   4541: iconst_2
    //   4542: new 178	java/lang/StringBuilder
    //   4545: dup
    //   4546: invokespecial 179	java/lang/StringBuilder:<init>	()V
    //   4549: ldc_w 545
    //   4552: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4555: aload_2
    //   4556: invokevirtual 548	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:getMessage	()Ljava/lang/String;
    //   4559: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4562: invokevirtual 205	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4565: invokestatic 209	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4568: iconst_0
    //   4569: istore 9
    //   4571: goto -59 -> 4512
    //   4574: goto -3149 -> 1425
    //   4577: goto -3152 -> 1425
    //   4580: goto -3141 -> 1439
    //   4583: goto -4231 -> 352
    //   4586: iload_3
    //   4587: ifeq -2733 -> 1854
    //   4590: iconst_0
    //   4591: istore 8
    //   4593: iload 9
    //   4595: istore 10
    //   4597: iload 8
    //   4599: istore 9
    //   4601: goto -3071 -> 1530
    //   4604: iload_3
    //   4605: ifeq -2522 -> 2083
    //   4608: iconst_0
    //   4609: istore 8
    //   4611: iload 9
    //   4613: istore 10
    //   4615: iload 8
    //   4617: istore 9
    //   4619: goto -2553 -> 2066
    //   4622: iconst_0
    //   4623: istore 9
    //   4625: goto -21 -> 4604
    //   4628: iload_3
    //   4629: iconst_1
    //   4630: iadd
    //   4631: istore_3
    //   4632: goto -2303 -> 2329
    //   4635: iconst_0
    //   4636: istore 9
    //   4638: goto -2340 -> 2298
    //   4641: goto -2669 -> 1972
    //   4644: goto -2672 -> 1972
    //   4647: iconst_0
    //   4648: istore 8
    //   4650: aload 14
    //   4652: astore_2
    //   4653: goto -607 -> 4046
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	4656	0	this	StatusServlet
    //   0	4656	1	paramIntent	Intent
    //   0	4656	2	paramFromServiceMsg	com.tencent.qphone.base.remote.FromServiceMsg
    //   119	4513	3	i	int
    //   8	2087	4	j	int
    //   502	3751	5	k	int
    //   526	2522	6	m	int
    //   604	1812	7	n	int
    //   14	4635	8	bool1	boolean
    //   47	4590	9	bool2	boolean
    //   1535	3079	10	bool3	boolean
    //   483	2210	11	l	long
    //   38	491	13	localObject1	Object
    //   719	26	13	localInvalidProtocolBufferMicroException1	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
    //   807	465	13	localException1	Exception
    //   1285	25	13	localException2	Exception
    //   1354	423	13	localObject2	Object
    //   1803	26	13	localInvalidProtocolBufferMicroException2	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
    //   2003	2434	13	localObject3	Object
    //   228	4423	14	localObject4	Object
    //   23	4298	15	localBundle	Bundle
    //   433	3890	16	localObject5	Object
    //   566	3632	17	localObject6	Object
    //   583	1128	18	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   70	87	719	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   100	120	719	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   124	146	719	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   150	179	719	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   634	675	719	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   684	716	719	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   217	268	807	java/lang/Exception
    //   272	297	807	java/lang/Exception
    //   301	330	807	java/lang/Exception
    //   795	804	807	java/lang/Exception
    //   852	900	807	java/lang/Exception
    //   907	926	807	java/lang/Exception
    //   926	959	807	java/lang/Exception
    //   959	1024	807	java/lang/Exception
    //   1029	1152	807	java/lang/Exception
    //   1152	1186	807	java/lang/Exception
    //   362	518	1285	java/lang/Exception
    //   521	551	1285	java/lang/Exception
    //   559	620	1285	java/lang/Exception
    //   1224	1271	1285	java/lang/Exception
    //   1271	1282	1285	java/lang/Exception
    //   1555	1608	1285	java/lang/Exception
    //   1613	1623	1285	java/lang/Exception
    //   1628	1653	1285	java/lang/Exception
    //   1653	1676	1285	java/lang/Exception
    //   1676	1698	1285	java/lang/Exception
    //   1703	1722	1285	java/lang/Exception
    //   1725	1745	1285	java/lang/Exception
    //   1758	1784	1285	java/lang/Exception
    //   1356	1373	1803	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1378	1418	1803	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1451	1524	1885	java/lang/Exception
    //   1530	1540	1885	java/lang/Exception
    //   1868	1878	1885	java/lang/Exception
    //   1987	2060	2114	java/lang/Exception
    //   2066	2076	2114	java/lang/Exception
    //   2097	2107	2114	java/lang/Exception
    //   2142	2295	2467	java/lang/Exception
    //   2298	2327	2467	java/lang/Exception
    //   2335	2396	2467	java/lang/Exception
    //   2406	2453	2467	java/lang/Exception
    //   2453	2464	2467	java/lang/Exception
    //   2495	2548	2467	java/lang/Exception
    //   2553	2563	2467	java/lang/Exception
    //   2568	2593	2467	java/lang/Exception
    //   2593	2615	2467	java/lang/Exception
    //   2615	2637	2467	java/lang/Exception
    //   2642	2661	2467	java/lang/Exception
    //   2664	2683	2467	java/lang/Exception
    //   2688	2713	2467	java/lang/Exception
    //   2716	2813	2822	java/lang/Exception
    //   2843	2859	2968	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   2885	2904	3159	java/lang/Exception
    //   2908	2923	3159	java/lang/Exception
    //   2931	2961	3159	java/lang/Exception
    //   3018	3042	3159	java/lang/Exception
    //   3050	3093	3159	java/lang/Exception
    //   3105	3115	3159	java/lang/Exception
    //   3118	3138	3159	java/lang/Exception
    //   3147	3156	3159	java/lang/Exception
    //   3736	3752	3856	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3764	3833	3856	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3996	4015	4336	java/lang/Exception
    //   4018	4025	4336	java/lang/Exception
    //   4033	4046	4336	java/lang/Exception
    //   4061	4072	4336	java/lang/Exception
    //   4163	4173	4336	java/lang/Exception
    //   4176	4181	4336	java/lang/Exception
    //   4187	4194	4336	java/lang/Exception
    //   4197	4228	4336	java/lang/Exception
    //   4237	4247	4336	java/lang/Exception
    //   4258	4277	4336	java/lang/Exception
    //   4280	4294	4336	java/lang/Exception
    //   4297	4316	4336	java/lang/Exception
    //   4319	4330	4336	java/lang/Exception
    //   3904	3988	4379	java/lang/Exception
    //   4088	4098	4379	java/lang/Exception
    //   4098	4150	4379	java/lang/Exception
    //   4337	4373	4379	java/lang/Exception
    //   4436	4452	4531	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   4464	4501	4531	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    Object localObject1 = (AppInterface)getAppRuntime();
    int i = paramIntent.getIntExtra("k_cmd", 0);
    Object localObject2;
    int j;
    Object localObject3;
    switch (i)
    {
    default: 
      paramIntent = null;
    case 2: 
    case 1: 
    case 4: 
      for (;;)
      {
        if (paramIntent != null) {
          paramPacket.setSSOCommand(paramIntent);
        }
        return;
        paramPacket.setTimeout(10000L);
        localObject1 = paramIntent.getStringExtra("k_uin");
        if (i == 2) {}
        for (boolean bool = true;; bool = false)
        {
          paramPacket.putSendData(a(bool, paramIntent.getBooleanExtra("k_sync_ss", false), Long.parseLong((String)localObject1)));
          paramIntent = "OidbSvc.0x515_2";
          break;
        }
        localObject1 = "OidbSvc.0x53f_2";
        localObject2 = paramIntent.getStringExtra("k_uin");
        i = paramIntent.getIntExtra("k_end_time", 2147483647);
        j = paramIntent.getIntExtra("k_start_time", 0);
        paramPacket.putSendData(a(Long.parseLong((String)localObject2), Integer.valueOf(j).intValue(), Integer.valueOf(i).intValue()));
        paramIntent = (Intent)localObject1;
      }
    case 3: 
      localObject2 = new ReqGetSameStateList();
      ((ReqGetSameStateList)localObject2).oHead = new BusiReqHead();
      ((ReqGetSameStateList)localObject2).vCookie = paramIntent.getByteArrayExtra("k_cookie");
      if (((ReqGetSameStateList)localObject2).vCookie == null) {
        ((ReqGetSameStateList)localObject2).vCookie = new byte[0];
      }
      localObject3 = new RichStatus("");
      ((RichStatus)localObject3).actionText = "foo";
      ((RichStatus)localObject3).actionId = paramIntent.getIntExtra("k_action", 0);
      ((RichStatus)localObject3).dataText = "foo";
      ((RichStatus)localObject3).dataId = paramIntent.getIntExtra("k_data", 0);
      ((ReqGetSameStateList)localObject2).oSelfRishState = new stRishState(((RichStatus)localObject3).encode(), 0L);
      localObject1 = ((FriendsManager)((AppInterface)localObject1).getManager(QQManagerFactory.FRIENDS_MANAGER)).a(((AppInterface)localObject1).getCurrentAccountUin());
      if (localObject1 != null) {
        if (((Card)localObject1).shGender != 0) {
          break;
        }
      }
      break;
    }
    label1053:
    for (i = 0;; i = 2)
    {
      for (;;)
      {
        ((ReqGetSameStateList)localObject2).eSelfSex = i;
        ((ReqGetSameStateList)localObject2).iPageSize = 50;
        ((ReqGetSameStateList)localObject2).oLbsInfo = a(null);
        ((ReqGetSameStateList)localObject2).eFetchSex = paramIntent.getIntExtra("k_fetch_sex", -1);
        paramIntent = paramIntent.getStringExtra("k_uin");
        if (!TextUtils.isEmpty(paramIntent)) {}
        try
        {
          ((ReqGetSameStateList)localObject2).lFriendUin = Long.parseLong(paramIntent);
          paramPacket.setServantName("PersonalStateSvc");
          paramPacket.setFuncName("ReqGetSameStateList");
          paramPacket.addRequestPacket("ReqGetSameStateList", (JceStruct)localObject2);
          paramIntent = "PersonalStateSvc.ReqGetSameStateList";
          break;
          if (((Card)localObject1).shGender != 1) {
            break label1053;
          }
          i = 1;
        }
        catch (Exception paramIntent)
        {
          for (;;)
          {
            paramIntent.printStackTrace();
          }
        }
      }
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
      localObject1 = "PersonalStateSvc.ReqGetHotState";
      paramIntent = new ReqGetHotState();
      paramIntent.oHead = new BusiReqHead();
      paramPacket.setServantName("PersonalStateSvc");
      paramPacket.setFuncName("ReqGetHotState");
      paramPacket.addRequestPacket("ReqGetHotState", paramIntent);
      paramIntent = (Intent)localObject1;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("get_hot_rich_status", 2, "StatusServlet.onSend()");
      paramIntent = (Intent)localObject1;
      break;
      localObject1 = "OidbSvc.0x50f_29";
      paramPacket.putSendData(a(paramIntent.getByteArrayExtra("k_data")));
      paramIntent = (Intent)localObject1;
      break;
      localObject1 = "OidbSvc.0x510_0";
      paramIntent = new oidb_sso.OIDBSSOPkg();
      paramIntent.uint32_command.set(1296);
      paramIntent.uint32_service_type.set(0);
      paramIntent.bytes_bodybuffer.set(ByteStringMicro.EMPTY);
      paramIntent = paramIntent.toByteArray();
      localObject2 = ByteBuffer.allocate(paramIntent.length + 4);
      ((ByteBuffer)localObject2).putInt(paramIntent.length + 4);
      ((ByteBuffer)localObject2).put(paramIntent);
      paramPacket.putSendData(((ByteBuffer)localObject2).array());
      paramIntent = (Intent)localObject1;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("StatusServlet", 2, "clearRichStatus...");
      paramIntent = (Intent)localObject1;
      break;
      i = paramIntent.getIntExtra("k_tpl_id", 0);
      j = paramIntent.getIntExtra("k_font_id", 0);
      int k = paramIntent.getIntExtra("k_sign_len", 2);
      localObject2 = paramIntent.getByteArrayExtra("k_sign_data");
      int m = paramIntent.getIntExtra("k_source", 0);
      paramIntent = new SigActPb.Platform();
      paramIntent.platform.set(109L);
      paramIntent.mqqver.set("8.5.5");
      paramIntent.osver.set(DeviceInfoUtil.e());
      localObject3 = new SigActPb.SigauthReq();
      ((SigActPb.SigauthReq)localObject3).uin_disable.set(Long.parseLong(((AppInterface)localObject1).getCurrentAccountUin()));
      ((SigActPb.SigauthReq)localObject3).itemid.set(i);
      ((SigActPb.SigauthReq)localObject3).fontid.set(j);
      ((SigActPb.SigauthReq)localObject3).data.set(ByteStringMicro.copyFrom((byte[])localObject2));
      ((SigActPb.SigauthReq)localObject3).len.set(k);
      localObject1 = new SigActPb.ReqBody();
      ((SigActPb.ReqBody)localObject1).cmd.set(2);
      ((SigActPb.ReqBody)localObject1).plf.set(paramIntent);
      ((SigActPb.ReqBody)localObject1).auth_req.set((MessageMicro)localObject3);
      ((SigActPb.ReqBody)localObject1).seq.set(System.currentTimeMillis());
      ((SigActPb.ReqBody)localObject1).source.set(m);
      paramIntent = ((SigActPb.ReqBody)localObject1).toByteArray();
      localObject1 = new byte[paramIntent.length + 4];
      PkgTools.DWord2Byte((byte[])localObject1, 0, paramIntent.length + 4);
      PkgTools.copyData((byte[])localObject1, 4, paramIntent, paramIntent.length);
      paramPacket.putSendData((byte[])localObject1);
      if (QLog.isColorLevel())
      {
        QLog.d("StatusServlet", 2, "Signature.auth");
        paramIntent = "Signature.auth";
        break;
      }
      paramIntent = "Signature.auth";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.StatusServlet
 * JD-Core Version:    0.7.0.1
 */