package com.tencent.mobileqq.richstatus;

import PersonalState.BusiReqHead;
import PersonalState.ReqGetHotState;
import PersonalState.ReqGetSameStateList;
import PersonalState.stRishState;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import anvk;
import axnr;
import com.qq.taf.jce.JceStruct;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
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
    SosoInterface.reqRawLbsData(60000L, StatusServlet.class.getSimpleName());
    Object localObject1 = axnr.a();
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
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
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
    //   1: ldc_w 295
    //   4: iconst_0
    //   5: invokevirtual 398	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   8: istore 4
    //   10: aload_2
    //   11: invokevirtual 403	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   14: istore 8
    //   16: new 206	android/os/Bundle
    //   19: dup
    //   20: invokespecial 404	android/os/Bundle:<init>	()V
    //   23: astore 15
    //   25: aload_0
    //   26: invokevirtual 408	com/tencent/mobileqq/richstatus/StatusServlet:getAppRuntime	()Lmqq/app/AppRuntime;
    //   29: getstatic 413	com/tencent/mobileqq/app/QQManagerFactory:STATUS_MANAGER	I
    //   32: invokevirtual 419	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   35: checkcast 421	bbvn
    //   38: astore 13
    //   40: aload 13
    //   42: ifnonnull +1877 -> 1919
    //   45: iload 8
    //   47: istore 9
    //   49: iload 4
    //   51: bipush 7
    //   53: if_icmpne +152 -> 205
    //   56: iload 8
    //   58: ifeq +706 -> 764
    //   61: new 320	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   64: dup
    //   65: invokespecial 321	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   68: astore 13
    //   70: aload 13
    //   72: aload_2
    //   73: invokevirtual 424	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   76: invokestatic 429	bhjl:b	([B)[B
    //   79: invokevirtual 430	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   82: checkcast 320	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   85: astore 13
    //   87: iload 8
    //   89: istore 9
    //   91: aload 13
    //   93: ifnull +90 -> 183
    //   96: iload 8
    //   98: istore 9
    //   100: aload 13
    //   102: getfield 433	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   105: invokevirtual 434	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   108: ifeq +75 -> 183
    //   111: aload 13
    //   113: getfield 433	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   116: invokevirtual 223	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   119: istore_3
    //   120: iload_3
    //   121: ifne +560 -> 681
    //   124: aload 13
    //   126: getfield 362	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   129: invokevirtual 437	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   132: invokevirtual 438	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   135: invokestatic 441	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   138: astore 13
    //   140: aload 13
    //   142: invokevirtual 444	java/nio/ByteBuffer:get	()B
    //   145: istore_3
    //   146: iload_3
    //   147: ifne +487 -> 634
    //   150: aload 15
    //   152: ldc_w 446
    //   155: aload 13
    //   157: invokevirtual 365	java/nio/ByteBuffer:array	()[B
    //   160: invokevirtual 450	android/os/Bundle:putByteArray	(Ljava/lang/String;[B)V
    //   163: aload 15
    //   165: ldc_w 452
    //   168: aload_1
    //   169: ldc_w 452
    //   172: iconst_0
    //   173: invokevirtual 398	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   176: invokevirtual 215	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   179: iload 8
    //   181: istore 9
    //   183: iload 9
    //   185: istore 8
    //   187: aload_0
    //   188: aload_1
    //   189: iload 4
    //   191: iload 8
    //   193: aload 15
    //   195: ldc_w 454
    //   198: invokevirtual 458	com/tencent/mobileqq/richstatus/StatusServlet:notifyObserver	(Landroid/content/Intent;IZLandroid/os/Bundle;Ljava/lang/Class;)V
    //   201: iload 8
    //   203: istore 9
    //   205: iload 4
    //   207: bipush 9
    //   209: if_icmpne +4373 -> 4582
    //   212: iload 9
    //   214: ifeq +977 -> 1191
    //   217: aload_2
    //   218: invokevirtual 424	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
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
    //   234: invokevirtual 424	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   237: iconst_4
    //   238: iload_3
    //   239: invokestatic 464	com/tencent/mobileqq/utils/httputils/PkgTools:copyData	([BI[BII)V
    //   242: new 127	com/tencent/pb/signature/SigActPb$RspBody
    //   245: dup
    //   246: invokespecial 465	com/tencent/pb/signature/SigActPb$RspBody:<init>	()V
    //   249: astore 13
    //   251: aload 13
    //   253: aload 14
    //   255: invokevirtual 466	com/tencent/pb/signature/SigActPb$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   258: pop
    //   259: aload 13
    //   261: getfield 467	com/tencent/pb/signature/SigActPb$RspBody:ret	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   264: invokevirtual 188	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   267: istore_3
    //   268: iload_3
    //   269: ifne +583 -> 852
    //   272: aload 13
    //   274: getfield 131	com/tencent/pb/signature/SigActPb$RspBody:auth_rsp	Lcom/tencent/pb/signature/SigActPb$SigauthRsp;
    //   277: getfield 470	com/tencent/pb/signature/SigActPb$SigauthRsp:result	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   280: invokevirtual 437	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   283: invokevirtual 438	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   286: invokestatic 441	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   289: astore 13
    //   291: aload 13
    //   293: invokevirtual 444	java/nio/ByteBuffer:get	()B
    //   296: istore_3
    //   297: iload_3
    //   298: ifne +494 -> 792
    //   301: aload 15
    //   303: ldc_w 446
    //   306: aload 13
    //   308: invokevirtual 365	java/nio/ByteBuffer:array	()[B
    //   311: invokevirtual 450	android/os/Bundle:putByteArray	(Ljava/lang/String;[B)V
    //   314: aload 15
    //   316: ldc_w 452
    //   319: aload_1
    //   320: ldc_w 452
    //   323: iconst_0
    //   324: invokevirtual 398	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   327: invokevirtual 215	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   330: iload 9
    //   332: istore 8
    //   334: iload 8
    //   336: istore 9
    //   338: aload_0
    //   339: aload_1
    //   340: iload 4
    //   342: iload 9
    //   344: aload 15
    //   346: ldc_w 454
    //   349: invokevirtual 458	com/tencent/mobileqq/richstatus/StatusServlet:notifyObserver	(Landroid/content/Intent;IZLandroid/os/Bundle;Ljava/lang/Class;)V
    //   352: iload 9
    //   354: istore 8
    //   356: iload 4
    //   358: iconst_4
    //   359: if_icmpne +975 -> 1334
    //   362: new 472	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory
    //   365: dup
    //   366: invokespecial 473	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:<init>	()V
    //   369: astore 13
    //   371: aload 13
    //   373: aload_1
    //   374: ldc_w 475
    //   377: iconst_0
    //   378: invokevirtual 398	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   381: putfield 478	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:startTime	I
    //   384: aload 13
    //   386: aload_1
    //   387: ldc_w 480
    //   390: ldc_w 481
    //   393: invokevirtual 398	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   396: putfield 484	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:endTime	I
    //   399: aload 13
    //   401: iconst_0
    //   402: putfield 488	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:isAddFromCard	Z
    //   405: aload 15
    //   407: ldc_w 490
    //   410: aload 13
    //   412: invokevirtual 494	android/os/Bundle:putSerializable	(Ljava/lang/String;Ljava/io/Serializable;)V
    //   415: aload_2
    //   416: invokevirtual 424	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   419: invokestatic 441	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   422: astore 14
    //   424: aload 14
    //   426: invokevirtual 497	java/nio/ByteBuffer:getInt	()I
    //   429: iconst_4
    //   430: isub
    //   431: newarray byte
    //   433: astore 16
    //   435: aload 14
    //   437: aload 16
    //   439: invokevirtual 499	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   442: pop
    //   443: new 320	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   446: dup
    //   447: invokespecial 321	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   450: aload 16
    //   452: invokevirtual 430	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   455: checkcast 320	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   458: getfield 362	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   461: invokevirtual 437	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   464: invokevirtual 438	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   467: invokestatic 441	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   470: astore 16
    //   472: aload 16
    //   474: invokevirtual 444	java/nio/ByteBuffer:get	()B
    //   477: pop
    //   478: aload 16
    //   480: invokevirtual 503	java/nio/ByteBuffer:getLong	()J
    //   483: lstore 11
    //   485: aload 16
    //   487: invokevirtual 444	java/nio/ByteBuffer:get	()B
    //   490: pop
    //   491: aload 16
    //   493: invokevirtual 497	java/nio/ByteBuffer:getInt	()I
    //   496: pop
    //   497: aload 16
    //   499: invokevirtual 497	java/nio/ByteBuffer:getInt	()I
    //   502: istore 5
    //   504: aload 16
    //   506: invokevirtual 497	java/nio/ByteBuffer:getInt	()I
    //   509: pop
    //   510: aload 16
    //   512: invokevirtual 444	java/nio/ByteBuffer:get	()B
    //   515: ifeq +702 -> 1217
    //   518: iconst_1
    //   519: istore 8
    //   521: aload 16
    //   523: invokevirtual 507	java/nio/ByteBuffer:getShort	()S
    //   526: istore 6
    //   528: aload 13
    //   530: new 58	java/util/ArrayList
    //   533: dup
    //   534: iload 6
    //   536: invokespecial 509	java/util/ArrayList:<init>	(I)V
    //   539: putfield 512	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:richStatus	Ljava/util/ArrayList;
    //   542: aload_0
    //   543: invokevirtual 408	com/tencent/mobileqq/richstatus/StatusServlet:getAppRuntime	()Lmqq/app/AppRuntime;
    //   546: checkcast 286	com/tencent/mobileqq/app/QQAppInterface
    //   549: astore 14
    //   551: iconst_0
    //   552: istore_3
    //   553: iload_3
    //   554: iload 6
    //   556: if_icmpge +998 -> 1554
    //   559: aload 16
    //   561: invokevirtual 507	java/nio/ByteBuffer:getShort	()S
    //   564: newarray byte
    //   566: astore 17
    //   568: aload 16
    //   570: aload 17
    //   572: invokevirtual 499	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   575: pop
    //   576: aload 16
    //   578: invokevirtual 507	java/nio/ByteBuffer:getShort	()S
    //   581: newarray byte
    //   583: astore 18
    //   585: aload 16
    //   587: aload 18
    //   589: invokevirtual 499	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   592: pop
    //   593: aload 16
    //   595: invokevirtual 497	java/nio/ByteBuffer:getInt	()I
    //   598: pop
    //   599: aload 16
    //   601: invokevirtual 497	java/nio/ByteBuffer:getInt	()I
    //   604: istore 7
    //   606: aload 16
    //   608: aload 16
    //   610: invokevirtual 515	java/nio/ByteBuffer:position	()I
    //   613: bipush 8
    //   615: iadd
    //   616: invokevirtual 518	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   619: pop
    //   620: iload 7
    //   622: iload 5
    //   624: if_icmple +599 -> 1223
    //   627: iload_3
    //   628: iconst_1
    //   629: iadd
    //   630: istore_3
    //   631: goto -78 -> 553
    //   634: aconst_null
    //   635: ldc_w 520
    //   638: ldc_w 522
    //   641: new 172	java/lang/StringBuilder
    //   644: dup
    //   645: invokespecial 173	java/lang/StringBuilder:<init>	()V
    //   648: ldc_w 524
    //   651: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   654: iload_3
    //   655: invokevirtual 191	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   658: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   661: aconst_null
    //   662: fconst_0
    //   663: invokestatic 529	bhpe:a	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;F)V
    //   666: ldc_w 520
    //   669: ldc_w 522
    //   672: invokestatic 533	bhpd:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   675: iconst_0
    //   676: istore 8
    //   678: goto -499 -> 179
    //   681: iconst_0
    //   682: istore 9
    //   684: aconst_null
    //   685: ldc_w 520
    //   688: ldc_w 535
    //   691: new 172	java/lang/StringBuilder
    //   694: dup
    //   695: invokespecial 173	java/lang/StringBuilder:<init>	()V
    //   698: ldc_w 524
    //   701: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   704: iload_3
    //   705: invokevirtual 191	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   708: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   711: aconst_null
    //   712: fconst_0
    //   713: invokestatic 529	bhpe:a	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;F)V
    //   716: goto -533 -> 183
    //   719: astore 13
    //   721: invokestatic 168	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   724: ifeq +34 -> 758
    //   727: ldc_w 537
    //   730: iconst_2
    //   731: new 172	java/lang/StringBuilder
    //   734: dup
    //   735: invokespecial 173	java/lang/StringBuilder:<init>	()V
    //   738: ldc_w 539
    //   741: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   744: aload 13
    //   746: invokevirtual 542	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:getMessage	()Ljava/lang/String;
    //   749: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   752: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   755: invokestatic 203	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   758: iconst_0
    //   759: istore 9
    //   761: goto -578 -> 183
    //   764: aconst_null
    //   765: ldc_w 520
    //   768: ldc_w 544
    //   771: aload_2
    //   772: invokevirtual 547	com/tencent/qphone/base/remote/FromServiceMsg:getBusinessFailMsg	()Ljava/lang/String;
    //   775: aconst_null
    //   776: fconst_0
    //   777: invokestatic 529	bhpe:a	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;F)V
    //   780: ldc_w 520
    //   783: ldc_w 544
    //   786: invokestatic 533	bhpd:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   789: goto -602 -> 187
    //   792: iconst_0
    //   793: istore 8
    //   795: aload 15
    //   797: ldc_w 549
    //   800: iload_3
    //   801: invokevirtual 215	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   804: goto -470 -> 334
    //   807: astore 13
    //   809: invokestatic 168	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   812: ifeq +34 -> 846
    //   815: ldc_w 537
    //   818: iconst_2
    //   819: new 172	java/lang/StringBuilder
    //   822: dup
    //   823: invokespecial 173	java/lang/StringBuilder:<init>	()V
    //   826: ldc_w 539
    //   829: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   832: aload 13
    //   834: invokevirtual 550	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   837: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   840: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   843: invokestatic 203	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   846: iconst_0
    //   847: istore 9
    //   849: goto -511 -> 338
    //   852: aconst_null
    //   853: ldc_w 552
    //   856: ldc_w 554
    //   859: new 172	java/lang/StringBuilder
    //   862: dup
    //   863: invokespecial 173	java/lang/StringBuilder:<init>	()V
    //   866: ldc_w 524
    //   869: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   872: iload_3
    //   873: invokevirtual 191	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   876: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   879: aconst_null
    //   880: fconst_0
    //   881: invokestatic 529	bhpe:a	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;F)V
    //   884: ldc_w 552
    //   887: iload_3
    //   888: invokestatic 556	bhpd:a	(Ljava/lang/String;I)V
    //   891: aload 15
    //   893: ldc_w 558
    //   896: iload_3
    //   897: invokevirtual 215	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   900: iload_3
    //   901: ldc_w 559
    //   904: if_icmpne +22 -> 926
    //   907: aload 15
    //   909: ldc_w 561
    //   912: aload 13
    //   914: getfield 131	com/tencent/pb/signature/SigActPb$RspBody:auth_rsp	Lcom/tencent/pb/signature/SigActPb$SigauthRsp;
    //   917: getfield 562	com/tencent/pb/signature/SigActPb$SigauthRsp:url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   920: invokevirtual 233	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   923: invokevirtual 237	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   926: aload 13
    //   928: getfield 131	com/tencent/pb/signature/SigActPb$RspBody:auth_rsp	Lcom/tencent/pb/signature/SigActPb$SigauthRsp;
    //   931: getfield 565	com/tencent/pb/signature/SigActPb$SigauthRsp:authfailed_appid	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   934: invokevirtual 566	com/tencent/mobileqq/pb/PBInt32Field:has	()Z
    //   937: ifeq +22 -> 959
    //   940: aload 15
    //   942: ldc_w 568
    //   945: aload 13
    //   947: getfield 131	com/tencent/pb/signature/SigActPb$RspBody:auth_rsp	Lcom/tencent/pb/signature/SigActPb$SigauthRsp;
    //   950: getfield 565	com/tencent/pb/signature/SigActPb$SigauthRsp:authfailed_appid	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   953: invokevirtual 188	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   956: invokevirtual 215	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   959: aload 13
    //   961: getfield 131	com/tencent/pb/signature/SigActPb$RspBody:auth_rsp	Lcom/tencent/pb/signature/SigActPb$SigauthRsp;
    //   964: getfield 137	com/tencent/pb/signature/SigActPb$SigauthRsp:tips_info	Lcom/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo;
    //   967: invokevirtual 142	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo:has	()Z
    //   970: ifeq +215 -> 1185
    //   973: new 139	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo
    //   976: dup
    //   977: invokespecial 143	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo:<init>	()V
    //   980: astore 14
    //   982: aload 14
    //   984: aload 13
    //   986: getfield 131	com/tencent/pb/signature/SigActPb$RspBody:auth_rsp	Lcom/tencent/pb/signature/SigActPb$SigauthRsp;
    //   989: getfield 137	com/tencent/pb/signature/SigActPb$SigauthRsp:tips_info	Lcom/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo;
    //   992: invokevirtual 147	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   995: checkcast 139	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo
    //   998: invokevirtual 151	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo:toByteArray	()[B
    //   1001: invokevirtual 155	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1004: pop
    //   1005: aload 14
    //   1007: getfield 159	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo:valid	Lcom/tencent/mobileqq/pb/PBBoolField;
    //   1010: invokevirtual 163	com/tencent/mobileqq/pb/PBBoolField:get	()Z
    //   1013: istore 8
    //   1015: aload 15
    //   1017: ldc 204
    //   1019: iload 8
    //   1021: invokevirtual 210	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   1024: iload 8
    //   1026: ifeq +125 -> 1151
    //   1029: aload 15
    //   1031: ldc 217
    //   1033: aload 14
    //   1035: getfield 220	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo:type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1038: invokevirtual 223	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1041: invokevirtual 215	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1044: aload 15
    //   1046: ldc 225
    //   1048: aload 14
    //   1050: getfield 229	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo:title_wording	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1053: invokevirtual 233	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1056: invokevirtual 237	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1059: aload 15
    //   1061: ldc 239
    //   1063: aload 14
    //   1065: getfield 241	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo:wording	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1068: invokevirtual 233	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1071: invokevirtual 237	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1074: aload 15
    //   1076: ldc 243
    //   1078: aload 14
    //   1080: getfield 246	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo:right_btn_wording	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1083: invokevirtual 233	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1086: invokevirtual 237	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1089: aload 15
    //   1091: ldc 248
    //   1093: aload 14
    //   1095: getfield 251	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo:left_btn_wording	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1098: invokevirtual 233	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1101: invokevirtual 237	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1104: aload 15
    //   1106: ldc 253
    //   1108: aload 14
    //   1110: getfield 256	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo:vip_type	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1113: invokevirtual 233	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1116: invokevirtual 237	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1119: aload 15
    //   1121: ldc_w 258
    //   1124: aload 14
    //   1126: getfield 261	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo:vip_month	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1129: invokevirtual 223	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1132: invokevirtual 215	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1135: aload 15
    //   1137: ldc_w 263
    //   1140: aload 14
    //   1142: getfield 265	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo:url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1145: invokevirtual 233	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1148: invokevirtual 237	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1151: invokestatic 168	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1154: ifeq +31 -> 1185
    //   1157: ldc_w 267
    //   1160: iconst_2
    //   1161: new 172	java/lang/StringBuilder
    //   1164: dup
    //   1165: invokespecial 173	java/lang/StringBuilder:<init>	()V
    //   1168: ldc_w 570
    //   1171: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1174: aload 15
    //   1176: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1179: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1182: invokestatic 277	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1185: iconst_0
    //   1186: istore 8
    //   1188: goto -854 -> 334
    //   1191: aconst_null
    //   1192: ldc_w 552
    //   1195: ldc_w 572
    //   1198: aload_2
    //   1199: invokevirtual 547	com/tencent/qphone/base/remote/FromServiceMsg:getBusinessFailMsg	()Ljava/lang/String;
    //   1202: aconst_null
    //   1203: fconst_0
    //   1204: invokestatic 529	bhpe:a	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;F)V
    //   1207: ldc_w 552
    //   1210: iconst_m1
    //   1211: invokestatic 556	bhpd:a	(Ljava/lang/String;I)V
    //   1214: goto -876 -> 338
    //   1217: iconst_0
    //   1218: istore 8
    //   1220: goto -699 -> 521
    //   1223: aload 18
    //   1225: invokestatic 578	com/tencent/mobileqq/richstatus/RichStatus:parseStatus	([B)Lcom/tencent/mobileqq/richstatus/RichStatus;
    //   1228: astore 18
    //   1230: aload 18
    //   1232: iload 7
    //   1234: i2l
    //   1235: putfield 581	com/tencent/mobileqq/richstatus/RichStatus:time	J
    //   1238: aload 18
    //   1240: aload 17
    //   1242: putfield 584	com/tencent/mobileqq/richstatus/RichStatus:key	[B
    //   1245: aload 18
    //   1247: getfield 584	com/tencent/mobileqq/richstatus/RichStatus:key	[B
    //   1250: ifnull +20 -> 1270
    //   1253: aload 18
    //   1255: new 586	java/lang/String
    //   1258: dup
    //   1259: aload 18
    //   1261: getfield 584	com/tencent/mobileqq/richstatus/RichStatus:key	[B
    //   1264: invokespecial 589	java/lang/String:<init>	([B)V
    //   1267: putfield 593	com/tencent/mobileqq/richstatus/RichStatus:feedsId	Ljava/lang/String;
    //   1270: aload 13
    //   1272: getfield 512	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:richStatus	Ljava/util/ArrayList;
    //   1275: aload 18
    //   1277: invokevirtual 96	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1280: pop
    //   1281: goto -654 -> 627
    //   1284: astore 13
    //   1286: iconst_0
    //   1287: istore 9
    //   1289: aload 13
    //   1291: invokevirtual 596	java/lang/Exception:printStackTrace	()V
    //   1294: iload 9
    //   1296: istore 8
    //   1298: invokestatic 168	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1301: ifeq +19 -> 1320
    //   1304: ldc_w 537
    //   1307: iconst_2
    //   1308: aload 13
    //   1310: invokevirtual 550	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1313: invokestatic 599	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1316: iload 9
    //   1318: istore 8
    //   1320: aload_0
    //   1321: aload_1
    //   1322: iload 4
    //   1324: iload 8
    //   1326: aload 15
    //   1328: ldc_w 454
    //   1331: invokevirtual 458	com/tencent/mobileqq/richstatus/StatusServlet:notifyObserver	(Landroid/content/Intent;IZLandroid/os/Bundle;Ljava/lang/Class;)V
    //   1334: iload 4
    //   1336: bipush 8
    //   1338: if_icmpne +3241 -> 4579
    //   1341: iload 8
    //   1343: ifeq +3233 -> 4576
    //   1346: new 320	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   1349: dup
    //   1350: invokespecial 321	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   1353: astore 13
    //   1355: aload 13
    //   1357: aload_2
    //   1358: invokevirtual 424	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   1361: invokestatic 429	bhjl:b	([B)[B
    //   1364: invokevirtual 430	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1367: checkcast 320	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   1370: astore 13
    //   1372: aload 13
    //   1374: ifnull +3199 -> 4573
    //   1377: aload 13
    //   1379: getfield 433	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1382: invokevirtual 434	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   1385: ifeq +3188 -> 4573
    //   1388: aload 13
    //   1390: getfield 433	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1393: invokevirtual 223	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1396: ifne +399 -> 1795
    //   1399: aload 13
    //   1401: getfield 362	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1404: invokevirtual 437	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1407: invokevirtual 438	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   1410: invokestatic 441	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   1413: invokevirtual 444	java/nio/ByteBuffer:get	()B
    //   1416: istore_3
    //   1417: iload_3
    //   1418: ifne +371 -> 1789
    //   1421: iconst_1
    //   1422: istore 8
    //   1424: aload_0
    //   1425: aload_1
    //   1426: iload 4
    //   1428: iload 8
    //   1430: aload 15
    //   1432: ldc_w 454
    //   1435: invokevirtual 458	com/tencent/mobileqq/richstatus/StatusServlet:notifyObserver	(Landroid/content/Intent;IZLandroid/os/Bundle;Ljava/lang/Class;)V
    //   1438: iload 4
    //   1440: iconst_1
    //   1441: if_icmpeq +9 -> 1450
    //   1444: iload 4
    //   1446: iconst_2
    //   1447: if_icmpne +106 -> 1553
    //   1450: aload_2
    //   1451: invokevirtual 424	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   1454: invokestatic 441	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   1457: astore_2
    //   1458: aload_2
    //   1459: invokevirtual 497	java/nio/ByteBuffer:getInt	()I
    //   1462: iconst_4
    //   1463: isub
    //   1464: newarray byte
    //   1466: astore 13
    //   1468: aload_2
    //   1469: aload 13
    //   1471: invokevirtual 499	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   1474: pop
    //   1475: new 320	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   1478: dup
    //   1479: invokespecial 321	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   1482: aload 13
    //   1484: invokevirtual 430	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1487: checkcast 320	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   1490: getfield 362	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1493: invokevirtual 437	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1496: invokevirtual 438	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   1499: invokestatic 441	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   1502: astore_2
    //   1503: aload_2
    //   1504: invokevirtual 444	java/nio/ByteBuffer:get	()B
    //   1507: istore_3
    //   1508: aload_2
    //   1509: invokevirtual 497	java/nio/ByteBuffer:getInt	()I
    //   1512: i2l
    //   1513: lstore 11
    //   1515: aload_2
    //   1516: invokevirtual 444	java/nio/ByteBuffer:get	()B
    //   1519: iconst_1
    //   1520: if_icmpne +326 -> 1846
    //   1523: iconst_1
    //   1524: istore 9
    //   1526: goto +3059 -> 4585
    //   1529: aload 15
    //   1531: ldc_w 314
    //   1534: iload 10
    //   1536: invokevirtual 210	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   1539: aload_0
    //   1540: aload_1
    //   1541: iload 4
    //   1543: iload 9
    //   1545: aload 15
    //   1547: ldc_w 454
    //   1550: invokevirtual 458	com/tencent/mobileqq/richstatus/StatusServlet:notifyObserver	(Landroid/content/Intent;IZLandroid/os/Bundle;Ljava/lang/Class;)V
    //   1553: return
    //   1554: aload 13
    //   1556: getfield 512	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:richStatus	Ljava/util/ArrayList;
    //   1559: invokevirtual 602	java/util/ArrayList:isEmpty	()Z
    //   1562: ifeq +89 -> 1651
    //   1565: aload 13
    //   1567: getfield 478	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:startTime	I
    //   1570: ifne +81 -> 1651
    //   1573: aload 13
    //   1575: getfield 484	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:endTime	I
    //   1578: ldc_w 481
    //   1581: if_icmpne +70 -> 1651
    //   1584: aload_0
    //   1585: invokevirtual 408	com/tencent/mobileqq/richstatus/StatusServlet:getAppRuntime	()Lmqq/app/AppRuntime;
    //   1588: getstatic 605	com/tencent/mobileqq/app/QQManagerFactory:FRIENDS_MANAGER	I
    //   1591: invokevirtual 419	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   1594: checkcast 607	anvk
    //   1597: lload 11
    //   1599: invokestatic 611	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1602: invokevirtual 614	anvk:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   1605: astore 16
    //   1607: aload 16
    //   1609: ifnull +42 -> 1651
    //   1612: aload 16
    //   1614: invokevirtual 620	com/tencent/mobileqq/data/Card:getRichStatus	()Lcom/tencent/mobileqq/richstatus/RichStatus;
    //   1617: ifnull +34 -> 1651
    //   1620: aload 16
    //   1622: invokevirtual 620	com/tencent/mobileqq/data/Card:getRichStatus	()Lcom/tencent/mobileqq/richstatus/RichStatus;
    //   1625: invokevirtual 621	com/tencent/mobileqq/richstatus/RichStatus:isEmpty	()Z
    //   1628: ifne +23 -> 1651
    //   1631: aload 13
    //   1633: getfield 512	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:richStatus	Ljava/util/ArrayList;
    //   1636: aload 16
    //   1638: invokevirtual 620	com/tencent/mobileqq/data/Card:getRichStatus	()Lcom/tencent/mobileqq/richstatus/RichStatus;
    //   1641: invokevirtual 96	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1644: pop
    //   1645: aload 13
    //   1647: iconst_1
    //   1648: putfield 488	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:isAddFromCard	Z
    //   1651: aload 14
    //   1653: getstatic 626	com/tencent/mobileqq/app/BusinessHandlerFactory:SIGNATURE_HANDLER	I
    //   1656: invokevirtual 630	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   1659: checkcast 632	com/tencent/mobileqq/app/SignatureHandler
    //   1662: astore 16
    //   1664: aload 13
    //   1666: getfield 512	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:richStatus	Ljava/util/ArrayList;
    //   1669: invokevirtual 67	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   1672: astore 17
    //   1674: aload 17
    //   1676: invokeinterface 73 1 0
    //   1681: ifeq +42 -> 1723
    //   1684: aload 17
    //   1686: invokeinterface 77 1 0
    //   1691: checkcast 574	com/tencent/mobileqq/richstatus/RichStatus
    //   1694: astore 18
    //   1696: aload 16
    //   1698: ifnull -24 -> 1674
    //   1701: aload 16
    //   1703: lload 11
    //   1705: invokestatic 611	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1708: aload 18
    //   1710: getfield 593	com/tencent/mobileqq/richstatus/RichStatus:feedsId	Ljava/lang/String;
    //   1713: sipush 255
    //   1716: iconst_1
    //   1717: invokevirtual 635	com/tencent/mobileqq/app/SignatureHandler:a	(Ljava/lang/String;Ljava/lang/String;IZ)V
    //   1720: goto -46 -> 1674
    //   1723: aload 13
    //   1725: iload 8
    //   1727: putfield 638	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:over	Z
    //   1730: aload 14
    //   1732: getstatic 641	com/tencent/mobileqq/app/QQManagerFactory:SIGNATURE_MANAGER	I
    //   1735: invokevirtual 642	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1738: checkcast 644	com/tencent/mobileqq/app/SignatureManager
    //   1741: astore 16
    //   1743: iload 9
    //   1745: istore 8
    //   1747: aload 16
    //   1749: ifnull -429 -> 1320
    //   1752: iload 9
    //   1754: istore 8
    //   1756: aload 14
    //   1758: invokevirtual 304	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1761: lload 11
    //   1763: invokestatic 648	java/lang/Long:toString	(J)Ljava/lang/String;
    //   1766: invokevirtual 651	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1769: ifeq -449 -> 1320
    //   1772: aload 16
    //   1774: aload 13
    //   1776: getfield 512	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:richStatus	Ljava/util/ArrayList;
    //   1779: invokevirtual 654	com/tencent/mobileqq/app/SignatureManager:a	(Ljava/util/List;)V
    //   1782: iload 9
    //   1784: istore 8
    //   1786: goto -466 -> 1320
    //   1789: iconst_0
    //   1790: istore 8
    //   1792: goto -368 -> 1424
    //   1795: iconst_0
    //   1796: istore 8
    //   1798: goto -374 -> 1424
    //   1801: astore 13
    //   1803: invokestatic 168	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1806: ifeq +34 -> 1840
    //   1809: ldc_w 537
    //   1812: iconst_2
    //   1813: new 172	java/lang/StringBuilder
    //   1816: dup
    //   1817: invokespecial 173	java/lang/StringBuilder:<init>	()V
    //   1820: ldc_w 539
    //   1823: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1826: aload 13
    //   1828: invokevirtual 542	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:getMessage	()Ljava/lang/String;
    //   1831: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1834: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1837: invokestatic 203	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1840: iconst_0
    //   1841: istore 8
    //   1843: goto -419 -> 1424
    //   1846: iconst_0
    //   1847: istore 9
    //   1849: goto +2736 -> 4585
    //   1852: iload 9
    //   1854: istore 10
    //   1856: iload 8
    //   1858: istore 9
    //   1860: iload 4
    //   1862: iconst_2
    //   1863: if_icmpne -334 -> 1529
    //   1866: aload_1
    //   1867: ldc_w 314
    //   1870: iconst_0
    //   1871: invokevirtual 658	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   1874: istore 10
    //   1876: iload 8
    //   1878: istore 9
    //   1880: goto -351 -> 1529
    //   1883: astore_2
    //   1884: iconst_0
    //   1885: istore 8
    //   1887: aload_2
    //   1888: invokevirtual 596	java/lang/Exception:printStackTrace	()V
    //   1891: iload 8
    //   1893: istore 9
    //   1895: invokestatic 168	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1898: ifeq -359 -> 1539
    //   1901: ldc_w 537
    //   1904: iconst_2
    //   1905: aload_2
    //   1906: invokevirtual 550	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1909: invokestatic 599	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1912: iload 8
    //   1914: istore 9
    //   1916: goto -377 -> 1539
    //   1919: iload 4
    //   1921: tableswitch	default:+51 -> 1972, 1:+66->1987, 2:+66->1987, 3:+794->2715, 4:+221->2142, 5:+907->2828, 6:+1323->3244, 7:+1800->3721, 8:+2500->4421, 9:+1977->3898
    //   1973: aload_1
    //   1974: iload 4
    //   1976: iload 8
    //   1978: aload 15
    //   1980: ldc_w 454
    //   1983: invokevirtual 458	com/tencent/mobileqq/richstatus/StatusServlet:notifyObserver	(Landroid/content/Intent;IZLandroid/os/Bundle;Ljava/lang/Class;)V
    //   1986: return
    //   1987: aload_2
    //   1988: invokevirtual 424	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   1991: invokestatic 441	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   1994: astore_2
    //   1995: aload_2
    //   1996: invokevirtual 497	java/nio/ByteBuffer:getInt	()I
    //   1999: iconst_4
    //   2000: isub
    //   2001: newarray byte
    //   2003: astore 13
    //   2005: aload_2
    //   2006: aload 13
    //   2008: invokevirtual 499	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   2011: pop
    //   2012: new 320	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   2015: dup
    //   2016: invokespecial 321	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   2019: aload 13
    //   2021: invokevirtual 430	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2024: checkcast 320	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   2027: getfield 362	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   2030: invokevirtual 437	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   2033: invokevirtual 438	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   2036: invokestatic 441	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   2039: astore_2
    //   2040: aload_2
    //   2041: invokevirtual 444	java/nio/ByteBuffer:get	()B
    //   2044: istore_3
    //   2045: aload_2
    //   2046: invokevirtual 497	java/nio/ByteBuffer:getInt	()I
    //   2049: i2l
    //   2050: lstore 11
    //   2052: aload_2
    //   2053: invokevirtual 444	java/nio/ByteBuffer:get	()B
    //   2056: iconst_1
    //   2057: if_icmpne +2564 -> 4621
    //   2060: iconst_1
    //   2061: istore 9
    //   2063: goto +2540 -> 4603
    //   2066: aload 15
    //   2068: ldc_w 314
    //   2071: iload 10
    //   2073: invokevirtual 210	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
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
    //   2098: ldc_w 314
    //   2101: iconst_0
    //   2102: invokevirtual 658	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   2105: istore 10
    //   2107: iload 8
    //   2109: istore 9
    //   2111: goto -45 -> 2066
    //   2114: astore_2
    //   2115: aload_2
    //   2116: invokevirtual 596	java/lang/Exception:printStackTrace	()V
    //   2119: invokestatic 168	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2122: ifeq +14 -> 2136
    //   2125: ldc_w 537
    //   2128: iconst_2
    //   2129: aload_2
    //   2130: invokevirtual 550	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2133: invokestatic 599	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   2136: iconst_0
    //   2137: istore 8
    //   2139: goto -167 -> 1972
    //   2142: new 472	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory
    //   2145: dup
    //   2146: invokespecial 473	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:<init>	()V
    //   2149: astore 13
    //   2151: aload 13
    //   2153: aload_1
    //   2154: ldc_w 475
    //   2157: iconst_0
    //   2158: invokevirtual 398	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   2161: putfield 478	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:startTime	I
    //   2164: aload 13
    //   2166: aload_1
    //   2167: ldc_w 480
    //   2170: ldc_w 481
    //   2173: invokevirtual 398	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   2176: putfield 484	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:endTime	I
    //   2179: aload 13
    //   2181: iconst_0
    //   2182: putfield 488	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:isAddFromCard	Z
    //   2185: aload 15
    //   2187: ldc_w 490
    //   2190: aload 13
    //   2192: invokevirtual 494	android/os/Bundle:putSerializable	(Ljava/lang/String;Ljava/io/Serializable;)V
    //   2195: aload_2
    //   2196: invokevirtual 424	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   2199: invokestatic 441	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   2202: astore_2
    //   2203: aload_2
    //   2204: invokevirtual 497	java/nio/ByteBuffer:getInt	()I
    //   2207: iconst_4
    //   2208: isub
    //   2209: newarray byte
    //   2211: astore 14
    //   2213: aload_2
    //   2214: aload 14
    //   2216: invokevirtual 499	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   2219: pop
    //   2220: new 320	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   2223: dup
    //   2224: invokespecial 321	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   2227: aload 14
    //   2229: invokevirtual 430	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2232: checkcast 320	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   2235: getfield 362	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   2238: invokevirtual 437	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   2241: invokevirtual 438	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   2244: invokestatic 441	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   2247: astore 14
    //   2249: aload 14
    //   2251: invokevirtual 444	java/nio/ByteBuffer:get	()B
    //   2254: pop
    //   2255: aload 14
    //   2257: invokevirtual 503	java/nio/ByteBuffer:getLong	()J
    //   2260: lstore 11
    //   2262: aload 14
    //   2264: invokevirtual 444	java/nio/ByteBuffer:get	()B
    //   2267: pop
    //   2268: aload 14
    //   2270: invokevirtual 497	java/nio/ByteBuffer:getInt	()I
    //   2273: pop
    //   2274: aload 14
    //   2276: invokevirtual 497	java/nio/ByteBuffer:getInt	()I
    //   2279: istore 5
    //   2281: aload 14
    //   2283: invokevirtual 497	java/nio/ByteBuffer:getInt	()I
    //   2286: pop
    //   2287: aload 14
    //   2289: invokevirtual 444	java/nio/ByteBuffer:get	()B
    //   2292: ifeq +2342 -> 4634
    //   2295: iconst_1
    //   2296: istore 9
    //   2298: aload 14
    //   2300: invokevirtual 507	java/nio/ByteBuffer:getShort	()S
    //   2303: istore 6
    //   2305: aload 13
    //   2307: new 58	java/util/ArrayList
    //   2310: dup
    //   2311: iload 6
    //   2313: invokespecial 509	java/util/ArrayList:<init>	(I)V
    //   2316: putfield 512	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:richStatus	Ljava/util/ArrayList;
    //   2319: aload_0
    //   2320: invokevirtual 408	com/tencent/mobileqq/richstatus/StatusServlet:getAppRuntime	()Lmqq/app/AppRuntime;
    //   2323: checkcast 286	com/tencent/mobileqq/app/QQAppInterface
    //   2326: astore_2
    //   2327: iconst_0
    //   2328: istore_3
    //   2329: iload_3
    //   2330: iload 6
    //   2332: if_icmpge +163 -> 2495
    //   2335: aload 14
    //   2337: invokevirtual 507	java/nio/ByteBuffer:getShort	()S
    //   2340: newarray byte
    //   2342: astore 16
    //   2344: aload 14
    //   2346: aload 16
    //   2348: invokevirtual 499	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   2351: pop
    //   2352: aload 14
    //   2354: invokevirtual 507	java/nio/ByteBuffer:getShort	()S
    //   2357: newarray byte
    //   2359: astore 17
    //   2361: aload 14
    //   2363: aload 17
    //   2365: invokevirtual 499	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   2368: pop
    //   2369: aload 14
    //   2371: invokevirtual 497	java/nio/ByteBuffer:getInt	()I
    //   2374: pop
    //   2375: aload 14
    //   2377: invokevirtual 497	java/nio/ByteBuffer:getInt	()I
    //   2380: istore 7
    //   2382: aload 14
    //   2384: aload 14
    //   2386: invokevirtual 515	java/nio/ByteBuffer:position	()I
    //   2389: bipush 8
    //   2391: iadd
    //   2392: invokevirtual 518	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   2395: pop
    //   2396: iload 7
    //   2398: iload 5
    //   2400: if_icmple +6 -> 2406
    //   2403: goto +2224 -> 4627
    //   2406: aload 17
    //   2408: invokestatic 578	com/tencent/mobileqq/richstatus/RichStatus:parseStatus	([B)Lcom/tencent/mobileqq/richstatus/RichStatus;
    //   2411: astore 17
    //   2413: aload 17
    //   2415: iload 7
    //   2417: i2l
    //   2418: putfield 581	com/tencent/mobileqq/richstatus/RichStatus:time	J
    //   2421: aload 17
    //   2423: aload 16
    //   2425: putfield 584	com/tencent/mobileqq/richstatus/RichStatus:key	[B
    //   2428: aload 17
    //   2430: getfield 584	com/tencent/mobileqq/richstatus/RichStatus:key	[B
    //   2433: ifnull +20 -> 2453
    //   2436: aload 17
    //   2438: new 586	java/lang/String
    //   2441: dup
    //   2442: aload 17
    //   2444: getfield 584	com/tencent/mobileqq/richstatus/RichStatus:key	[B
    //   2447: invokespecial 589	java/lang/String:<init>	([B)V
    //   2450: putfield 593	com/tencent/mobileqq/richstatus/RichStatus:feedsId	Ljava/lang/String;
    //   2453: aload 13
    //   2455: getfield 512	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:richStatus	Ljava/util/ArrayList;
    //   2458: aload 17
    //   2460: invokevirtual 96	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2463: pop
    //   2464: goto +2163 -> 4627
    //   2467: astore_2
    //   2468: aload_2
    //   2469: invokevirtual 596	java/lang/Exception:printStackTrace	()V
    //   2472: invokestatic 168	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2475: ifeq +14 -> 2489
    //   2478: ldc_w 537
    //   2481: iconst_2
    //   2482: aload_2
    //   2483: invokevirtual 550	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2486: invokestatic 599	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   2489: iconst_0
    //   2490: istore 8
    //   2492: goto -520 -> 1972
    //   2495: aload 13
    //   2497: getfield 512	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:richStatus	Ljava/util/ArrayList;
    //   2500: invokevirtual 602	java/util/ArrayList:isEmpty	()Z
    //   2503: ifeq +89 -> 2592
    //   2506: aload 13
    //   2508: getfield 478	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:startTime	I
    //   2511: ifne +81 -> 2592
    //   2514: aload 13
    //   2516: getfield 484	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:endTime	I
    //   2519: ldc_w 481
    //   2522: if_icmpne +70 -> 2592
    //   2525: aload_0
    //   2526: invokevirtual 408	com/tencent/mobileqq/richstatus/StatusServlet:getAppRuntime	()Lmqq/app/AppRuntime;
    //   2529: getstatic 605	com/tencent/mobileqq/app/QQManagerFactory:FRIENDS_MANAGER	I
    //   2532: invokevirtual 419	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   2535: checkcast 607	anvk
    //   2538: lload 11
    //   2540: invokestatic 611	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   2543: invokevirtual 614	anvk:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   2546: astore 14
    //   2548: aload 14
    //   2550: ifnull +42 -> 2592
    //   2553: aload 14
    //   2555: invokevirtual 620	com/tencent/mobileqq/data/Card:getRichStatus	()Lcom/tencent/mobileqq/richstatus/RichStatus;
    //   2558: ifnull +34 -> 2592
    //   2561: aload 14
    //   2563: invokevirtual 620	com/tencent/mobileqq/data/Card:getRichStatus	()Lcom/tencent/mobileqq/richstatus/RichStatus;
    //   2566: invokevirtual 621	com/tencent/mobileqq/richstatus/RichStatus:isEmpty	()Z
    //   2569: ifne +23 -> 2592
    //   2572: aload 13
    //   2574: getfield 512	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:richStatus	Ljava/util/ArrayList;
    //   2577: aload 14
    //   2579: invokevirtual 620	com/tencent/mobileqq/data/Card:getRichStatus	()Lcom/tencent/mobileqq/richstatus/RichStatus;
    //   2582: invokevirtual 96	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2585: pop
    //   2586: aload 13
    //   2588: iconst_1
    //   2589: putfield 488	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:isAddFromCard	Z
    //   2592: aload_2
    //   2593: getstatic 626	com/tencent/mobileqq/app/BusinessHandlerFactory:SIGNATURE_HANDLER	I
    //   2596: invokevirtual 630	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   2599: checkcast 632	com/tencent/mobileqq/app/SignatureHandler
    //   2602: astore 14
    //   2604: aload 13
    //   2606: getfield 512	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:richStatus	Ljava/util/ArrayList;
    //   2609: invokevirtual 67	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   2612: astore 16
    //   2614: aload 16
    //   2616: invokeinterface 73 1 0
    //   2621: ifeq +42 -> 2663
    //   2624: aload 16
    //   2626: invokeinterface 77 1 0
    //   2631: checkcast 574	com/tencent/mobileqq/richstatus/RichStatus
    //   2634: astore 17
    //   2636: aload 14
    //   2638: ifnull -24 -> 2614
    //   2641: aload 14
    //   2643: lload 11
    //   2645: invokestatic 611	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   2648: aload 17
    //   2650: getfield 593	com/tencent/mobileqq/richstatus/RichStatus:feedsId	Ljava/lang/String;
    //   2653: sipush 255
    //   2656: iconst_1
    //   2657: invokevirtual 635	com/tencent/mobileqq/app/SignatureHandler:a	(Ljava/lang/String;Ljava/lang/String;IZ)V
    //   2660: goto -46 -> 2614
    //   2663: aload 13
    //   2665: iload 9
    //   2667: putfield 638	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:over	Z
    //   2670: aload_2
    //   2671: getstatic 641	com/tencent/mobileqq/app/QQManagerFactory:SIGNATURE_MANAGER	I
    //   2674: invokevirtual 642	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   2677: checkcast 644	com/tencent/mobileqq/app/SignatureManager
    //   2680: astore 14
    //   2682: aload 14
    //   2684: ifnull +28 -> 2712
    //   2687: aload_2
    //   2688: invokevirtual 304	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   2691: lload 11
    //   2693: invokestatic 648	java/lang/Long:toString	(J)Ljava/lang/String;
    //   2696: invokevirtual 651	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2699: ifeq +13 -> 2712
    //   2702: aload 14
    //   2704: aload 13
    //   2706: getfield 512	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:richStatus	Ljava/util/ArrayList;
    //   2709: invokevirtual 654	com/tencent/mobileqq/app/SignatureManager:a	(Ljava/util/List;)V
    //   2712: goto -740 -> 1972
    //   2715: aload 15
    //   2717: ldc_w 660
    //   2720: aload_1
    //   2721: ldc_w 660
    //   2724: iconst_1
    //   2725: invokevirtual 658	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   2728: invokevirtual 210	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   2731: aload 15
    //   2733: ldc_w 662
    //   2736: aload_1
    //   2737: ldc_w 662
    //   2740: iconst_m1
    //   2741: invokevirtual 398	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   2744: invokevirtual 215	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   2747: new 664	com/qq/jce/wup/UniPacket
    //   2750: dup
    //   2751: iconst_1
    //   2752: invokespecial 667	com/qq/jce/wup/UniPacket:<init>	(Z)V
    //   2755: astore 13
    //   2757: aload 13
    //   2759: ldc_w 669
    //   2762: invokevirtual 673	com/qq/jce/wup/UniPacket:setEncodeName	(Ljava/lang/String;)V
    //   2765: aload 13
    //   2767: aload_2
    //   2768: invokevirtual 424	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   2771: invokevirtual 676	com/qq/jce/wup/UniPacket:decode	([B)V
    //   2774: aload 13
    //   2776: ldc_w 678
    //   2779: new 680	PersonalState/RespGetSameStateList
    //   2782: dup
    //   2783: invokespecial 681	PersonalState/RespGetSameStateList:<init>	()V
    //   2786: invokevirtual 685	com/qq/jce/wup/UniPacket:getByClass	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   2789: checkcast 680	PersonalState/RespGetSameStateList
    //   2792: astore_2
    //   2793: aload_2
    //   2794: getfield 689	PersonalState/RespGetSameStateList:oHead	LPersonalState/BusiRespHead;
    //   2797: getfield 694	PersonalState/BusiRespHead:iReplyCode	I
    //   2800: ifne +15 -> 2815
    //   2803: aload 15
    //   2805: ldc_w 696
    //   2808: aload_2
    //   2809: invokevirtual 494	android/os/Bundle:putSerializable	(Ljava/lang/String;Ljava/io/Serializable;)V
    //   2812: goto -840 -> 1972
    //   2815: iconst_0
    //   2816: istore 8
    //   2818: goto -6 -> 2812
    //   2821: astore_2
    //   2822: iconst_0
    //   2823: istore 8
    //   2825: goto -853 -> 1972
    //   2828: iload 8
    //   2830: ifeq -858 -> 1972
    //   2833: new 320	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   2836: dup
    //   2837: invokespecial 321	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   2840: astore 13
    //   2842: aload 13
    //   2844: aload_2
    //   2845: invokevirtual 424	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   2848: invokestatic 429	bhjl:b	([B)[B
    //   2851: invokevirtual 430	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2854: checkcast 320	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   2857: astore_2
    //   2858: aload_2
    //   2859: ifnull +368 -> 3227
    //   2862: aload_2
    //   2863: getfield 433	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2866: invokevirtual 434	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   2869: ifeq +358 -> 3227
    //   2872: aload_2
    //   2873: getfield 433	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2876: invokevirtual 223	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2879: istore_3
    //   2880: iload_3
    //   2881: ifne +331 -> 3212
    //   2884: aload_2
    //   2885: getfield 362	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   2888: invokevirtual 437	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   2891: invokevirtual 438	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   2894: invokestatic 441	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   2897: astore_2
    //   2898: aload_2
    //   2899: invokevirtual 444	java/nio/ByteBuffer:get	()B
    //   2902: istore_3
    //   2903: iload_3
    //   2904: ifne +239 -> 3143
    //   2907: aload_2
    //   2908: invokevirtual 507	java/nio/ByteBuffer:getShort	()S
    //   2911: istore 5
    //   2913: new 58	java/util/ArrayList
    //   2916: dup
    //   2917: invokespecial 59	java/util/ArrayList:<init>	()V
    //   2920: astore 13
    //   2922: iconst_0
    //   2923: istore_3
    //   2924: iload_3
    //   2925: iload 5
    //   2927: if_icmpge +90 -> 3017
    //   2930: aload_2
    //   2931: invokevirtual 507	java/nio/ByteBuffer:getShort	()S
    //   2934: newarray byte
    //   2936: astore 14
    //   2938: aload_2
    //   2939: aload 14
    //   2941: invokevirtual 499	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   2944: pop
    //   2945: aload 13
    //   2947: new 586	java/lang/String
    //   2950: dup
    //   2951: aload 14
    //   2953: invokespecial 589	java/lang/String:<init>	([B)V
    //   2956: invokevirtual 96	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2959: pop
    //   2960: iload_3
    //   2961: iconst_1
    //   2962: iadd
    //   2963: istore_3
    //   2964: goto -40 -> 2924
    //   2967: astore_2
    //   2968: aload_2
    //   2969: invokevirtual 697	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   2972: invokestatic 168	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2975: ifeq +33 -> 3008
    //   2978: ldc_w 537
    //   2981: iconst_2
    //   2982: new 172	java/lang/StringBuilder
    //   2985: dup
    //   2986: invokespecial 173	java/lang/StringBuilder:<init>	()V
    //   2989: ldc_w 539
    //   2992: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2995: aload_2
    //   2996: invokevirtual 542	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:getMessage	()Ljava/lang/String;
    //   2999: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3002: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3005: invokestatic 203	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3008: iconst_0
    //   3009: istore 8
    //   3011: aload 13
    //   3013: astore_2
    //   3014: goto -156 -> 2858
    //   3017: new 58	java/util/ArrayList
    //   3020: dup
    //   3021: invokespecial 59	java/util/ArrayList:<init>	()V
    //   3024: astore 14
    //   3026: new 58	java/util/ArrayList
    //   3029: dup
    //   3030: invokespecial 59	java/util/ArrayList:<init>	()V
    //   3033: astore 16
    //   3035: aload_2
    //   3036: invokevirtual 507	java/nio/ByteBuffer:getShort	()S
    //   3039: istore 6
    //   3041: iconst_0
    //   3042: istore_3
    //   3043: iload_3
    //   3044: iload 6
    //   3046: if_icmpge +53 -> 3099
    //   3049: aload_2
    //   3050: invokevirtual 507	java/nio/ByteBuffer:getShort	()S
    //   3053: newarray byte
    //   3055: astore 17
    //   3057: aload_2
    //   3058: aload 17
    //   3060: invokevirtual 499	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   3063: pop
    //   3064: aload 14
    //   3066: new 586	java/lang/String
    //   3069: dup
    //   3070: aload 17
    //   3072: invokespecial 589	java/lang/String:<init>	([B)V
    //   3075: invokevirtual 96	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   3078: pop
    //   3079: aload 16
    //   3081: aload_2
    //   3082: invokevirtual 497	java/nio/ByteBuffer:getInt	()I
    //   3085: invokestatic 702	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3088: invokevirtual 96	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   3091: pop
    //   3092: iload_3
    //   3093: iconst_1
    //   3094: iadd
    //   3095: istore_3
    //   3096: goto -53 -> 3043
    //   3099: iload 5
    //   3101: ifle +16 -> 3117
    //   3104: aload 15
    //   3106: ldc_w 704
    //   3109: aload 13
    //   3111: invokevirtual 708	android/os/Bundle:putStringArrayList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   3114: goto +1526 -> 4640
    //   3117: aload 15
    //   3119: ldc_w 704
    //   3122: aload 14
    //   3124: invokevirtual 708	android/os/Bundle:putStringArrayList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   3127: aload 15
    //   3129: ldc_w 710
    //   3132: aload 16
    //   3134: invokevirtual 713	android/os/Bundle:putIntegerArrayList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   3137: iconst_0
    //   3138: istore 8
    //   3140: goto +1500 -> 4640
    //   3143: iconst_0
    //   3144: istore 8
    //   3146: aload 15
    //   3148: ldc_w 715
    //   3151: iload_3
    //   3152: invokevirtual 215	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   3155: goto +1485 -> 4640
    //   3158: astore_2
    //   3159: invokestatic 168	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3162: ifeq +33 -> 3195
    //   3165: ldc_w 537
    //   3168: iconst_2
    //   3169: new 172	java/lang/StringBuilder
    //   3172: dup
    //   3173: invokespecial 173	java/lang/StringBuilder:<init>	()V
    //   3176: ldc_w 717
    //   3179: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3182: aload_2
    //   3183: invokevirtual 550	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   3186: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3189: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3192: invokestatic 599	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   3195: iconst_0
    //   3196: istore 8
    //   3198: aload 15
    //   3200: ldc_w 715
    //   3203: sipush -1002
    //   3206: invokevirtual 215	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   3209: goto +1431 -> 4640
    //   3212: iconst_0
    //   3213: istore 8
    //   3215: aload 15
    //   3217: ldc_w 715
    //   3220: iload_3
    //   3221: invokevirtual 215	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   3224: goto +1416 -> 4640
    //   3227: iconst_0
    //   3228: istore 8
    //   3230: aload 15
    //   3232: ldc_w 715
    //   3235: sipush -1001
    //   3238: invokevirtual 215	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   3241: goto +1399 -> 4640
    //   3244: new 664	com/qq/jce/wup/UniPacket
    //   3247: dup
    //   3248: iconst_1
    //   3249: invokespecial 667	com/qq/jce/wup/UniPacket:<init>	(Z)V
    //   3252: astore 14
    //   3254: aload 14
    //   3256: ldc_w 669
    //   3259: invokevirtual 673	com/qq/jce/wup/UniPacket:setEncodeName	(Ljava/lang/String;)V
    //   3262: aload 14
    //   3264: aload_2
    //   3265: invokevirtual 424	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   3268: invokevirtual 676	com/qq/jce/wup/UniPacket:decode	([B)V
    //   3271: aload 14
    //   3273: ldc_w 719
    //   3276: new 721	PersonalState/RespGetHotState
    //   3279: dup
    //   3280: invokespecial 722	PersonalState/RespGetHotState:<init>	()V
    //   3283: invokevirtual 685	com/qq/jce/wup/UniPacket:getByClass	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   3286: checkcast 721	PersonalState/RespGetHotState
    //   3289: astore 14
    //   3291: aload 14
    //   3293: getfield 723	PersonalState/RespGetHotState:oHead	LPersonalState/BusiRespHead;
    //   3296: getfield 694	PersonalState/BusiRespHead:iReplyCode	I
    //   3299: ifne +400 -> 3699
    //   3302: invokestatic 168	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3305: ifeq +159 -> 3464
    //   3308: new 172	java/lang/StringBuilder
    //   3311: dup
    //   3312: ldc_w 725
    //   3315: invokespecial 727	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3318: astore 16
    //   3320: aload 16
    //   3322: ldc_w 729
    //   3325: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3328: astore 17
    //   3330: aload 14
    //   3332: getfield 732	PersonalState/RespGetHotState:vHostRichSateList	Ljava/util/ArrayList;
    //   3335: ifnonnull +102 -> 3437
    //   3338: ldc_w 734
    //   3341: astore_2
    //   3342: aload 17
    //   3344: aload_2
    //   3345: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3348: ldc_w 736
    //   3351: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3354: pop
    //   3355: aload 14
    //   3357: getfield 732	PersonalState/RespGetHotState:vHostRichSateList	Ljava/util/ArrayList;
    //   3360: ifnull +92 -> 3452
    //   3363: aload 14
    //   3365: getfield 732	PersonalState/RespGetHotState:vHostRichSateList	Ljava/util/ArrayList;
    //   3368: invokevirtual 737	java/util/ArrayList:size	()I
    //   3371: ifle +81 -> 3452
    //   3374: aload 14
    //   3376: getfield 732	PersonalState/RespGetHotState:vHostRichSateList	Ljava/util/ArrayList;
    //   3379: invokevirtual 67	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   3382: astore_2
    //   3383: aload_2
    //   3384: invokeinterface 73 1 0
    //   3389: ifeq +63 -> 3452
    //   3392: aload_2
    //   3393: invokeinterface 77 1 0
    //   3398: checkcast 739	PersonalState/HotRishState
    //   3401: astore 17
    //   3403: aload 16
    //   3405: ldc_w 741
    //   3408: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3411: aload 17
    //   3413: getfield 744	PersonalState/HotRishState:iActId	I
    //   3416: invokevirtual 191	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3419: ldc_w 746
    //   3422: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3425: aload 17
    //   3427: getfield 749	PersonalState/HotRishState:iDataId	I
    //   3430: invokevirtual 191	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3433: pop
    //   3434: goto -51 -> 3383
    //   3437: aload 14
    //   3439: getfield 732	PersonalState/RespGetHotState:vHostRichSateList	Ljava/util/ArrayList;
    //   3442: invokevirtual 737	java/util/ArrayList:size	()I
    //   3445: invokestatic 702	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3448: astore_2
    //   3449: goto -107 -> 3342
    //   3452: ldc_w 751
    //   3455: iconst_2
    //   3456: aload 16
    //   3458: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3461: invokestatic 203	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3464: new 58	java/util/ArrayList
    //   3467: dup
    //   3468: bipush 6
    //   3470: invokespecial 509	java/util/ArrayList:<init>	(I)V
    //   3473: astore_2
    //   3474: aload 14
    //   3476: getfield 732	PersonalState/RespGetHotState:vHostRichSateList	Ljava/util/ArrayList;
    //   3479: ifnull +208 -> 3687
    //   3482: aload 14
    //   3484: getfield 732	PersonalState/RespGetHotState:vHostRichSateList	Ljava/util/ArrayList;
    //   3487: invokevirtual 737	java/util/ArrayList:size	()I
    //   3490: ifle +197 -> 3687
    //   3493: aload 13
    //   3495: ifnull +82 -> 3577
    //   3498: aload 13
    //   3500: invokevirtual 753	bbvn:a	()Lcom/tencent/mobileqq/richstatus/RichStatus;
    //   3503: astore 16
    //   3505: aload 14
    //   3507: getfield 732	PersonalState/RespGetHotState:vHostRichSateList	Ljava/util/ArrayList;
    //   3510: invokevirtual 737	java/util/ArrayList:size	()I
    //   3513: iconst_1
    //   3514: isub
    //   3515: istore_3
    //   3516: iload_3
    //   3517: iflt +60 -> 3577
    //   3520: aload 14
    //   3522: getfield 732	PersonalState/RespGetHotState:vHostRichSateList	Ljava/util/ArrayList;
    //   3525: iload_3
    //   3526: invokevirtual 756	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   3529: checkcast 739	PersonalState/HotRishState
    //   3532: astore 17
    //   3534: aload 17
    //   3536: getfield 744	PersonalState/HotRishState:iActId	I
    //   3539: aload 16
    //   3541: getfield 759	com/tencent/mobileqq/richstatus/RichStatus:actionId	I
    //   3544: if_icmpne +26 -> 3570
    //   3547: aload 17
    //   3549: getfield 749	PersonalState/HotRishState:iDataId	I
    //   3552: aload 16
    //   3554: getfield 762	com/tencent/mobileqq/richstatus/RichStatus:dataId	I
    //   3557: if_icmpne +13 -> 3570
    //   3560: aload 14
    //   3562: getfield 732	PersonalState/RespGetHotState:vHostRichSateList	Ljava/util/ArrayList;
    //   3565: iload_3
    //   3566: invokevirtual 765	java/util/ArrayList:remove	(I)Ljava/lang/Object;
    //   3569: pop
    //   3570: iload_3
    //   3571: iconst_1
    //   3572: isub
    //   3573: istore_3
    //   3574: goto -58 -> 3516
    //   3577: iconst_0
    //   3578: istore_3
    //   3579: iload_3
    //   3580: bipush 6
    //   3582: if_icmpge +24 -> 3606
    //   3585: aload_2
    //   3586: aload 14
    //   3588: getfield 732	PersonalState/RespGetHotState:vHostRichSateList	Ljava/util/ArrayList;
    //   3591: iload_3
    //   3592: invokevirtual 756	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   3595: invokevirtual 96	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   3598: pop
    //   3599: iload_3
    //   3600: iconst_1
    //   3601: iadd
    //   3602: istore_3
    //   3603: goto -24 -> 3579
    //   3606: new 172	java/lang/StringBuilder
    //   3609: dup
    //   3610: invokespecial 173	java/lang/StringBuilder:<init>	()V
    //   3613: astore 14
    //   3615: aload_2
    //   3616: invokevirtual 67	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   3619: astore 16
    //   3621: aload 16
    //   3623: invokeinterface 73 1 0
    //   3628: ifeq +49 -> 3677
    //   3631: aload 16
    //   3633: invokeinterface 77 1 0
    //   3638: checkcast 739	PersonalState/HotRishState
    //   3641: astore 17
    //   3643: aload 14
    //   3645: aload 17
    //   3647: getfield 744	PersonalState/HotRishState:iActId	I
    //   3650: invokevirtual 191	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3653: ldc_w 746
    //   3656: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3659: aload 17
    //   3661: getfield 749	PersonalState/HotRishState:iDataId	I
    //   3664: invokevirtual 191	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3667: ldc_w 767
    //   3670: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3673: pop
    //   3674: goto -53 -> 3621
    //   3677: aload 13
    //   3679: aload 14
    //   3681: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3684: invokevirtual 769	bbvn:a	(Ljava/lang/String;)V
    //   3687: aload 15
    //   3689: ldc_w 771
    //   3692: aload_2
    //   3693: invokevirtual 494	android/os/Bundle:putSerializable	(Ljava/lang/String;Ljava/io/Serializable;)V
    //   3696: goto -1724 -> 1972
    //   3699: invokestatic 168	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3702: ifeq +13 -> 3715
    //   3705: ldc_w 751
    //   3708: iconst_2
    //   3709: ldc_w 773
    //   3712: invokestatic 203	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3715: iconst_0
    //   3716: istore 8
    //   3718: goto -1746 -> 1972
    //   3721: iload 8
    //   3723: ifeq -1751 -> 1972
    //   3726: new 320	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   3729: dup
    //   3730: invokespecial 321	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   3733: astore 13
    //   3735: aload 13
    //   3737: aload_2
    //   3738: invokevirtual 424	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   3741: invokestatic 429	bhjl:b	([B)[B
    //   3744: invokevirtual 430	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3747: checkcast 320	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   3750: astore_2
    //   3751: iload 8
    //   3753: istore 9
    //   3755: aload_2
    //   3756: ifnull +80 -> 3836
    //   3759: iload 8
    //   3761: istore 9
    //   3763: aload_2
    //   3764: getfield 433	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3767: invokevirtual 434	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   3770: ifeq +66 -> 3836
    //   3773: aload_2
    //   3774: getfield 433	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3777: invokevirtual 223	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3780: ifne +69 -> 3849
    //   3783: aload_2
    //   3784: getfield 362	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3787: invokevirtual 437	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   3790: invokevirtual 438	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   3793: invokestatic 441	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   3796: astore_2
    //   3797: aload_2
    //   3798: invokevirtual 444	java/nio/ByteBuffer:get	()B
    //   3801: ifne +42 -> 3843
    //   3804: aload 15
    //   3806: ldc_w 446
    //   3809: aload_2
    //   3810: invokevirtual 365	java/nio/ByteBuffer:array	()[B
    //   3813: invokevirtual 450	android/os/Bundle:putByteArray	(Ljava/lang/String;[B)V
    //   3816: aload 15
    //   3818: ldc_w 452
    //   3821: aload_1
    //   3822: ldc_w 452
    //   3825: iconst_0
    //   3826: invokevirtual 398	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   3829: invokevirtual 215	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   3832: iload 8
    //   3834: istore 9
    //   3836: iload 9
    //   3838: istore 8
    //   3840: goto -1868 -> 1972
    //   3843: iconst_0
    //   3844: istore 9
    //   3846: goto -10 -> 3836
    //   3849: iconst_0
    //   3850: istore 9
    //   3852: goto -16 -> 3836
    //   3855: astore_2
    //   3856: invokestatic 168	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3859: ifeq +33 -> 3892
    //   3862: ldc_w 537
    //   3865: iconst_2
    //   3866: new 172	java/lang/StringBuilder
    //   3869: dup
    //   3870: invokespecial 173	java/lang/StringBuilder:<init>	()V
    //   3873: ldc_w 539
    //   3876: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3879: aload_2
    //   3880: invokevirtual 542	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:getMessage	()Ljava/lang/String;
    //   3883: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3886: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3889: invokestatic 203	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3892: iconst_0
    //   3893: istore 9
    //   3895: goto -59 -> 3836
    //   3898: iload 8
    //   3900: ifeq -1928 -> 1972
    //   3903: aload_1
    //   3904: ldc_w 452
    //   3907: iconst_0
    //   3908: invokevirtual 398	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   3911: istore_3
    //   3912: aload_2
    //   3913: invokevirtual 424	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   3916: arraylength
    //   3917: iconst_4
    //   3918: isub
    //   3919: istore 5
    //   3921: iload 5
    //   3923: newarray byte
    //   3925: astore 13
    //   3927: aload 13
    //   3929: iconst_0
    //   3930: aload_2
    //   3931: invokevirtual 424	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   3934: iconst_4
    //   3935: iload 5
    //   3937: invokestatic 464	com/tencent/mobileqq/utils/httputils/PkgTools:copyData	([BI[BII)V
    //   3940: new 127	com/tencent/pb/signature/SigActPb$RspBody
    //   3943: dup
    //   3944: invokespecial 465	com/tencent/pb/signature/SigActPb$RspBody:<init>	()V
    //   3947: astore 16
    //   3949: aload 16
    //   3951: aload 13
    //   3953: invokevirtual 466	com/tencent/pb/signature/SigActPb$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3956: pop
    //   3957: aload 16
    //   3959: getfield 467	com/tencent/pb/signature/SigActPb$RspBody:ret	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   3962: invokevirtual 188	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   3965: istore 5
    //   3967: aload 16
    //   3969: getfield 776	com/tencent/pb/signature/SigActPb$RspBody:desc	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3972: invokevirtual 777	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   3975: ifeq +177 -> 4152
    //   3978: aload 16
    //   3980: getfield 776	com/tencent/pb/signature/SigActPb$RspBody:desc	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3983: invokevirtual 233	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   3986: astore_2
    //   3987: iload 5
    //   3989: ifne +241 -> 4230
    //   3992: aload_2
    //   3993: astore 13
    //   3995: aload 16
    //   3997: getfield 131	com/tencent/pb/signature/SigActPb$RspBody:auth_rsp	Lcom/tencent/pb/signature/SigActPb$SigauthRsp;
    //   4000: getfield 470	com/tencent/pb/signature/SigActPb$SigauthRsp:result	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   4003: invokevirtual 437	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   4006: invokevirtual 438	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   4009: invokestatic 441	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   4012: astore 14
    //   4014: aload_2
    //   4015: astore 13
    //   4017: aload 14
    //   4019: invokevirtual 444	java/nio/ByteBuffer:get	()B
    //   4022: istore 5
    //   4024: iload 5
    //   4026: ifne +133 -> 4159
    //   4029: aload_2
    //   4030: astore 13
    //   4032: aload 15
    //   4034: ldc_w 446
    //   4037: aload 14
    //   4039: invokevirtual 365	java/nio/ByteBuffer:array	()[B
    //   4042: invokevirtual 450	android/os/Bundle:putByteArray	(Ljava/lang/String;[B)V
    //   4045: aload_2
    //   4046: astore 13
    //   4048: iload 8
    //   4050: istore 9
    //   4052: iload_3
    //   4053: iconst_1
    //   4054: if_icmpne +24 -> 4078
    //   4057: aload_2
    //   4058: astore 13
    //   4060: aload_0
    //   4061: aload 15
    //   4063: aload 16
    //   4065: ldc_w 779
    //   4068: invokespecial 781	com/tencent/mobileqq/richstatus/StatusServlet:a	(Landroid/os/Bundle;Lcom/tencent/pb/signature/SigActPb$RspBody;Ljava/lang/String;)V
    //   4071: iload 8
    //   4073: istore 9
    //   4075: aload_2
    //   4076: astore 13
    //   4078: iload 9
    //   4080: istore 8
    //   4082: aload 13
    //   4084: ifnull +13 -> 4097
    //   4087: aload 15
    //   4089: ldc_w 783
    //   4092: aload 13
    //   4094: invokevirtual 237	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   4097: aload 15
    //   4099: ldc_w 452
    //   4102: iload_3
    //   4103: invokevirtual 215	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   4106: invokestatic 786	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   4109: ifeq +534 -> 4643
    //   4112: ldc_w 267
    //   4115: iconst_1
    //   4116: ldc_w 788
    //   4119: iconst_3
    //   4120: anewarray 790	java/lang/Object
    //   4123: dup
    //   4124: iconst_0
    //   4125: iload 8
    //   4127: invokestatic 795	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   4130: aastore
    //   4131: dup
    //   4132: iconst_1
    //   4133: iload_3
    //   4134: invokestatic 702	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   4137: aastore
    //   4138: dup
    //   4139: iconst_2
    //   4140: aload 13
    //   4142: aastore
    //   4143: invokestatic 799	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   4146: invokestatic 277	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4149: goto +494 -> 4643
    //   4152: ldc_w 524
    //   4155: astore_2
    //   4156: goto -169 -> 3987
    //   4159: aload_2
    //   4160: astore 13
    //   4162: aload 15
    //   4164: ldc_w 549
    //   4167: iload 5
    //   4169: invokevirtual 215	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   4172: aload_2
    //   4173: astore 13
    //   4175: invokestatic 805	arly:c	()Lcom/tencent/mobileqq/config/business/qvip/SSOErrorInfoMapConfig;
    //   4178: astore 17
    //   4180: aload_2
    //   4181: astore 13
    //   4183: aload_2
    //   4184: astore 14
    //   4186: aload_2
    //   4187: invokestatic 810	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4190: ifeq +456 -> 4646
    //   4193: aload_2
    //   4194: astore 13
    //   4196: aload 17
    //   4198: ldc_w 812
    //   4201: new 172	java/lang/StringBuilder
    //   4204: dup
    //   4205: invokespecial 173	java/lang/StringBuilder:<init>	()V
    //   4208: ldc_w 524
    //   4211: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4214: iload 5
    //   4216: invokevirtual 191	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4219: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4222: invokevirtual 818	com/tencent/mobileqq/config/business/qvip/SSOErrorInfoMapConfig:getErrorInfo	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   4225: astore 14
    //   4227: goto +419 -> 4646
    //   4230: iconst_0
    //   4231: istore 9
    //   4233: aload_2
    //   4234: astore 13
    //   4236: aload 15
    //   4238: ldc_w 558
    //   4241: iload 5
    //   4243: invokevirtual 215	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   4246: iload 5
    //   4248: ldc_w 559
    //   4251: if_icmpne +25 -> 4276
    //   4254: aload_2
    //   4255: astore 13
    //   4257: aload 15
    //   4259: ldc_w 561
    //   4262: aload 16
    //   4264: getfield 131	com/tencent/pb/signature/SigActPb$RspBody:auth_rsp	Lcom/tencent/pb/signature/SigActPb$SigauthRsp;
    //   4267: getfield 562	com/tencent/pb/signature/SigActPb$SigauthRsp:url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   4270: invokevirtual 233	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   4273: invokevirtual 237	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   4276: aload_2
    //   4277: astore 13
    //   4279: aload 16
    //   4281: getfield 131	com/tencent/pb/signature/SigActPb$RspBody:auth_rsp	Lcom/tencent/pb/signature/SigActPb$SigauthRsp;
    //   4284: getfield 565	com/tencent/pb/signature/SigActPb$SigauthRsp:authfailed_appid	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   4287: invokevirtual 566	com/tencent/mobileqq/pb/PBInt32Field:has	()Z
    //   4290: ifeq +25 -> 4315
    //   4293: aload_2
    //   4294: astore 13
    //   4296: aload 15
    //   4298: ldc_w 568
    //   4301: aload 16
    //   4303: getfield 131	com/tencent/pb/signature/SigActPb$RspBody:auth_rsp	Lcom/tencent/pb/signature/SigActPb$SigauthRsp;
    //   4306: getfield 565	com/tencent/pb/signature/SigActPb$SigauthRsp:authfailed_appid	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   4309: invokevirtual 188	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   4312: invokevirtual 215	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   4315: aload_2
    //   4316: astore 13
    //   4318: aload_0
    //   4319: aload 15
    //   4321: aload 16
    //   4323: ldc_w 820
    //   4326: invokespecial 781	com/tencent/mobileqq/richstatus/StatusServlet:a	(Landroid/os/Bundle;Lcom/tencent/pb/signature/SigActPb$RspBody;Ljava/lang/String;)V
    //   4329: aload_2
    //   4330: astore 13
    //   4332: goto -254 -> 4078
    //   4335: astore_2
    //   4336: invokestatic 168	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4339: ifeq +33 -> 4372
    //   4342: ldc_w 537
    //   4345: iconst_2
    //   4346: new 172	java/lang/StringBuilder
    //   4349: dup
    //   4350: invokespecial 173	java/lang/StringBuilder:<init>	()V
    //   4353: ldc_w 539
    //   4356: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4359: aload_2
    //   4360: invokevirtual 550	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   4363: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4366: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4369: invokestatic 203	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4372: iconst_0
    //   4373: istore 8
    //   4375: goto -293 -> 4082
    //   4378: astore_2
    //   4379: invokestatic 168	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4382: ifeq +33 -> 4415
    //   4385: ldc_w 537
    //   4388: iconst_2
    //   4389: new 172	java/lang/StringBuilder
    //   4392: dup
    //   4393: invokespecial 173	java/lang/StringBuilder:<init>	()V
    //   4396: ldc_w 539
    //   4399: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4402: aload_2
    //   4403: invokevirtual 550	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   4406: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4409: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4412: invokestatic 203	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4415: iconst_0
    //   4416: istore 8
    //   4418: goto -2446 -> 1972
    //   4421: iload 8
    //   4423: ifeq -2451 -> 1972
    //   4426: new 320	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   4429: dup
    //   4430: invokespecial 321	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   4433: astore 13
    //   4435: aload 13
    //   4437: aload_2
    //   4438: invokevirtual 424	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   4441: invokestatic 429	bhjl:b	([B)[B
    //   4444: invokevirtual 430	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   4447: checkcast 320	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   4450: astore_2
    //   4451: iload 8
    //   4453: istore 9
    //   4455: aload_2
    //   4456: ifnull +55 -> 4511
    //   4459: iload 8
    //   4461: istore 9
    //   4463: aload_2
    //   4464: getfield 433	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4467: invokevirtual 434	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   4470: ifeq +41 -> 4511
    //   4473: aload_2
    //   4474: getfield 433	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4477: invokevirtual 223	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4480: ifne +44 -> 4524
    //   4483: aload_2
    //   4484: getfield 362	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   4487: invokevirtual 437	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   4490: invokevirtual 438	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   4493: invokestatic 441	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   4496: invokevirtual 444	java/nio/ByteBuffer:get	()B
    //   4499: istore_3
    //   4500: iload_3
    //   4501: ifne +17 -> 4518
    //   4504: iconst_1
    //   4505: istore 8
    //   4507: iload 8
    //   4509: istore 9
    //   4511: iload 9
    //   4513: istore 8
    //   4515: goto -2543 -> 1972
    //   4518: iconst_0
    //   4519: istore 8
    //   4521: goto -14 -> 4507
    //   4524: iconst_0
    //   4525: istore 9
    //   4527: goto -16 -> 4511
    //   4530: astore_2
    //   4531: invokestatic 168	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4534: ifeq +33 -> 4567
    //   4537: ldc_w 537
    //   4540: iconst_2
    //   4541: new 172	java/lang/StringBuilder
    //   4544: dup
    //   4545: invokespecial 173	java/lang/StringBuilder:<init>	()V
    //   4548: ldc_w 539
    //   4551: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4554: aload_2
    //   4555: invokevirtual 542	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:getMessage	()Ljava/lang/String;
    //   4558: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4561: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4564: invokestatic 203	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4567: iconst_0
    //   4568: istore 9
    //   4570: goto -59 -> 4511
    //   4573: goto -3149 -> 1424
    //   4576: goto -3152 -> 1424
    //   4579: goto -3141 -> 1438
    //   4582: goto -4230 -> 352
    //   4585: iload_3
    //   4586: ifeq -2734 -> 1852
    //   4589: iconst_0
    //   4590: istore 8
    //   4592: iload 9
    //   4594: istore 10
    //   4596: iload 8
    //   4598: istore 9
    //   4600: goto -3071 -> 1529
    //   4603: iload_3
    //   4604: ifeq -2521 -> 2083
    //   4607: iconst_0
    //   4608: istore 8
    //   4610: iload 9
    //   4612: istore 10
    //   4614: iload 8
    //   4616: istore 9
    //   4618: goto -2552 -> 2066
    //   4621: iconst_0
    //   4622: istore 9
    //   4624: goto -21 -> 4603
    //   4627: iload_3
    //   4628: iconst_1
    //   4629: iadd
    //   4630: istore_3
    //   4631: goto -2302 -> 2329
    //   4634: iconst_0
    //   4635: istore 9
    //   4637: goto -2339 -> 2298
    //   4640: goto -2668 -> 1972
    //   4643: goto -2671 -> 1972
    //   4646: iconst_0
    //   4647: istore 8
    //   4649: aload 14
    //   4651: astore_2
    //   4652: goto -607 -> 4045
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	4655	0	this	StatusServlet
    //   0	4655	1	paramIntent	Intent
    //   0	4655	2	paramFromServiceMsg	com.tencent.qphone.base.remote.FromServiceMsg
    //   119	4512	3	i	int
    //   8	2087	4	j	int
    //   502	3750	5	k	int
    //   526	2521	6	m	int
    //   604	1812	7	n	int
    //   14	4634	8	bool1	boolean
    //   47	4589	9	bool2	boolean
    //   1534	3079	10	bool3	boolean
    //   483	2209	11	l	long
    //   38	491	13	localObject1	Object
    //   719	26	13	localInvalidProtocolBufferMicroException1	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
    //   807	464	13	localException1	Exception
    //   1284	25	13	localException2	Exception
    //   1353	422	13	localObject2	Object
    //   1801	26	13	localInvalidProtocolBufferMicroException2	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
    //   2003	2433	13	localObject3	Object
    //   228	4422	14	localObject4	Object
    //   23	4297	15	localBundle	Bundle
    //   433	3889	16	localObject5	Object
    //   566	3631	17	localObject6	Object
    //   583	1126	18	localObject7	Object
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
    //   1029	1151	807	java/lang/Exception
    //   1151	1185	807	java/lang/Exception
    //   362	518	1284	java/lang/Exception
    //   521	551	1284	java/lang/Exception
    //   559	620	1284	java/lang/Exception
    //   1223	1270	1284	java/lang/Exception
    //   1270	1281	1284	java/lang/Exception
    //   1554	1607	1284	java/lang/Exception
    //   1612	1651	1284	java/lang/Exception
    //   1651	1674	1284	java/lang/Exception
    //   1674	1696	1284	java/lang/Exception
    //   1701	1720	1284	java/lang/Exception
    //   1723	1743	1284	java/lang/Exception
    //   1756	1782	1284	java/lang/Exception
    //   1355	1372	1801	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1377	1417	1801	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1450	1523	1883	java/lang/Exception
    //   1529	1539	1883	java/lang/Exception
    //   1866	1876	1883	java/lang/Exception
    //   1987	2060	2114	java/lang/Exception
    //   2066	2076	2114	java/lang/Exception
    //   2097	2107	2114	java/lang/Exception
    //   2142	2295	2467	java/lang/Exception
    //   2298	2327	2467	java/lang/Exception
    //   2335	2396	2467	java/lang/Exception
    //   2406	2453	2467	java/lang/Exception
    //   2453	2464	2467	java/lang/Exception
    //   2495	2548	2467	java/lang/Exception
    //   2553	2592	2467	java/lang/Exception
    //   2592	2614	2467	java/lang/Exception
    //   2614	2636	2467	java/lang/Exception
    //   2641	2660	2467	java/lang/Exception
    //   2663	2682	2467	java/lang/Exception
    //   2687	2712	2467	java/lang/Exception
    //   2715	2812	2821	java/lang/Exception
    //   2842	2858	2967	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   2884	2903	3158	java/lang/Exception
    //   2907	2922	3158	java/lang/Exception
    //   2930	2960	3158	java/lang/Exception
    //   3017	3041	3158	java/lang/Exception
    //   3049	3092	3158	java/lang/Exception
    //   3104	3114	3158	java/lang/Exception
    //   3117	3137	3158	java/lang/Exception
    //   3146	3155	3158	java/lang/Exception
    //   3735	3751	3855	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3763	3832	3855	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3995	4014	4335	java/lang/Exception
    //   4017	4024	4335	java/lang/Exception
    //   4032	4045	4335	java/lang/Exception
    //   4060	4071	4335	java/lang/Exception
    //   4162	4172	4335	java/lang/Exception
    //   4175	4180	4335	java/lang/Exception
    //   4186	4193	4335	java/lang/Exception
    //   4196	4227	4335	java/lang/Exception
    //   4236	4246	4335	java/lang/Exception
    //   4257	4276	4335	java/lang/Exception
    //   4279	4293	4335	java/lang/Exception
    //   4296	4315	4335	java/lang/Exception
    //   4318	4329	4335	java/lang/Exception
    //   3903	3987	4378	java/lang/Exception
    //   4087	4097	4378	java/lang/Exception
    //   4097	4149	4378	java/lang/Exception
    //   4336	4372	4378	java/lang/Exception
    //   4435	4451	4530	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   4463	4500	4530	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
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
      localObject1 = ((anvk)((AppInterface)localObject1).getManager(QQManagerFactory.FRIENDS_MANAGER)).b(((AppInterface)localObject1).getCurrentAccountUin());
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
      paramIntent.mqqver.set("8.4.10");
      paramIntent.osver.set(DeviceInfoUtil.getDeviceOSVersion());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.StatusServlet
 * JD-Core Version:    0.7.0.1
 */