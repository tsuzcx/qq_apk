package com.tencent.mobileqq.richstatus;

import PersonalState.BusiReqHead;
import PersonalState.ReqGetHotState;
import PersonalState.ReqGetSameStateList;
import PersonalState.stRishState;
import amsw;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import awhp;
import com.qq.taf.jce.JceStruct;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
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
    Object localObject1 = awhp.a();
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
    //   29: bipush 15
    //   31: invokevirtual 414	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   34: checkcast 416	baoy
    //   37: astore 13
    //   39: aload 13
    //   41: ifnonnull +1874 -> 1915
    //   44: iload 8
    //   46: istore 9
    //   48: iload 4
    //   50: bipush 7
    //   52: if_icmpne +152 -> 204
    //   55: iload 8
    //   57: ifeq +706 -> 763
    //   60: new 320	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   63: dup
    //   64: invokespecial 321	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   67: astore 13
    //   69: aload 13
    //   71: aload_2
    //   72: invokevirtual 419	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   75: invokestatic 424	bgau:b	([B)[B
    //   78: invokevirtual 425	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   81: checkcast 320	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   84: astore 13
    //   86: iload 8
    //   88: istore 9
    //   90: aload 13
    //   92: ifnull +90 -> 182
    //   95: iload 8
    //   97: istore 9
    //   99: aload 13
    //   101: getfield 428	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   104: invokevirtual 429	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   107: ifeq +75 -> 182
    //   110: aload 13
    //   112: getfield 428	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   115: invokevirtual 223	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   118: istore_3
    //   119: iload_3
    //   120: ifne +560 -> 680
    //   123: aload 13
    //   125: getfield 362	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   128: invokevirtual 432	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   131: invokevirtual 433	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   134: invokestatic 436	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   137: astore 13
    //   139: aload 13
    //   141: invokevirtual 439	java/nio/ByteBuffer:get	()B
    //   144: istore_3
    //   145: iload_3
    //   146: ifne +487 -> 633
    //   149: aload 15
    //   151: ldc_w 441
    //   154: aload 13
    //   156: invokevirtual 365	java/nio/ByteBuffer:array	()[B
    //   159: invokevirtual 445	android/os/Bundle:putByteArray	(Ljava/lang/String;[B)V
    //   162: aload 15
    //   164: ldc_w 447
    //   167: aload_1
    //   168: ldc_w 447
    //   171: iconst_0
    //   172: invokevirtual 398	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   175: invokevirtual 215	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   178: iload 8
    //   180: istore 9
    //   182: iload 9
    //   184: istore 8
    //   186: aload_0
    //   187: aload_1
    //   188: iload 4
    //   190: iload 8
    //   192: aload 15
    //   194: ldc_w 449
    //   197: invokevirtual 453	com/tencent/mobileqq/richstatus/StatusServlet:notifyObserver	(Landroid/content/Intent;IZLandroid/os/Bundle;Ljava/lang/Class;)V
    //   200: iload 8
    //   202: istore 9
    //   204: iload 4
    //   206: bipush 9
    //   208: if_icmpne +4367 -> 4575
    //   211: iload 9
    //   213: ifeq +977 -> 1190
    //   216: aload_2
    //   217: invokevirtual 419	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   220: arraylength
    //   221: iconst_4
    //   222: isub
    //   223: istore_3
    //   224: iload_3
    //   225: newarray byte
    //   227: astore 14
    //   229: aload 14
    //   231: iconst_0
    //   232: aload_2
    //   233: invokevirtual 419	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   236: iconst_4
    //   237: iload_3
    //   238: invokestatic 459	com/tencent/mobileqq/utils/httputils/PkgTools:copyData	([BI[BII)V
    //   241: new 127	com/tencent/pb/signature/SigActPb$RspBody
    //   244: dup
    //   245: invokespecial 460	com/tencent/pb/signature/SigActPb$RspBody:<init>	()V
    //   248: astore 13
    //   250: aload 13
    //   252: aload 14
    //   254: invokevirtual 461	com/tencent/pb/signature/SigActPb$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   257: pop
    //   258: aload 13
    //   260: getfield 462	com/tencent/pb/signature/SigActPb$RspBody:ret	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   263: invokevirtual 188	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   266: istore_3
    //   267: iload_3
    //   268: ifne +583 -> 851
    //   271: aload 13
    //   273: getfield 131	com/tencent/pb/signature/SigActPb$RspBody:auth_rsp	Lcom/tencent/pb/signature/SigActPb$SigauthRsp;
    //   276: getfield 465	com/tencent/pb/signature/SigActPb$SigauthRsp:result	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   279: invokevirtual 432	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   282: invokevirtual 433	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   285: invokestatic 436	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   288: astore 13
    //   290: aload 13
    //   292: invokevirtual 439	java/nio/ByteBuffer:get	()B
    //   295: istore_3
    //   296: iload_3
    //   297: ifne +494 -> 791
    //   300: aload 15
    //   302: ldc_w 441
    //   305: aload 13
    //   307: invokevirtual 365	java/nio/ByteBuffer:array	()[B
    //   310: invokevirtual 445	android/os/Bundle:putByteArray	(Ljava/lang/String;[B)V
    //   313: aload 15
    //   315: ldc_w 447
    //   318: aload_1
    //   319: ldc_w 447
    //   322: iconst_0
    //   323: invokevirtual 398	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   326: invokevirtual 215	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   329: iload 9
    //   331: istore 8
    //   333: iload 8
    //   335: istore 9
    //   337: aload_0
    //   338: aload_1
    //   339: iload 4
    //   341: iload 9
    //   343: aload 15
    //   345: ldc_w 449
    //   348: invokevirtual 453	com/tencent/mobileqq/richstatus/StatusServlet:notifyObserver	(Landroid/content/Intent;IZLandroid/os/Bundle;Ljava/lang/Class;)V
    //   351: iload 9
    //   353: istore 8
    //   355: iload 4
    //   357: iconst_4
    //   358: if_icmpne +975 -> 1333
    //   361: new 467	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory
    //   364: dup
    //   365: invokespecial 468	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:<init>	()V
    //   368: astore 13
    //   370: aload 13
    //   372: aload_1
    //   373: ldc_w 470
    //   376: iconst_0
    //   377: invokevirtual 398	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   380: putfield 473	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:startTime	I
    //   383: aload 13
    //   385: aload_1
    //   386: ldc_w 475
    //   389: ldc_w 476
    //   392: invokevirtual 398	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   395: putfield 479	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:endTime	I
    //   398: aload 13
    //   400: iconst_0
    //   401: putfield 483	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:isAddFromCard	Z
    //   404: aload 15
    //   406: ldc_w 485
    //   409: aload 13
    //   411: invokevirtual 489	android/os/Bundle:putSerializable	(Ljava/lang/String;Ljava/io/Serializable;)V
    //   414: aload_2
    //   415: invokevirtual 419	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   418: invokestatic 436	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   421: astore 14
    //   423: aload 14
    //   425: invokevirtual 492	java/nio/ByteBuffer:getInt	()I
    //   428: iconst_4
    //   429: isub
    //   430: newarray byte
    //   432: astore 16
    //   434: aload 14
    //   436: aload 16
    //   438: invokevirtual 494	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   441: pop
    //   442: new 320	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   445: dup
    //   446: invokespecial 321	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   449: aload 16
    //   451: invokevirtual 425	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   454: checkcast 320	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   457: getfield 362	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   460: invokevirtual 432	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   463: invokevirtual 433	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   466: invokestatic 436	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   469: astore 16
    //   471: aload 16
    //   473: invokevirtual 439	java/nio/ByteBuffer:get	()B
    //   476: pop
    //   477: aload 16
    //   479: invokevirtual 498	java/nio/ByteBuffer:getLong	()J
    //   482: lstore 11
    //   484: aload 16
    //   486: invokevirtual 439	java/nio/ByteBuffer:get	()B
    //   489: pop
    //   490: aload 16
    //   492: invokevirtual 492	java/nio/ByteBuffer:getInt	()I
    //   495: pop
    //   496: aload 16
    //   498: invokevirtual 492	java/nio/ByteBuffer:getInt	()I
    //   501: istore 5
    //   503: aload 16
    //   505: invokevirtual 492	java/nio/ByteBuffer:getInt	()I
    //   508: pop
    //   509: aload 16
    //   511: invokevirtual 439	java/nio/ByteBuffer:get	()B
    //   514: ifeq +702 -> 1216
    //   517: iconst_1
    //   518: istore 8
    //   520: aload 16
    //   522: invokevirtual 502	java/nio/ByteBuffer:getShort	()S
    //   525: istore 6
    //   527: aload 13
    //   529: new 58	java/util/ArrayList
    //   532: dup
    //   533: iload 6
    //   535: invokespecial 504	java/util/ArrayList:<init>	(I)V
    //   538: putfield 507	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:richStatus	Ljava/util/ArrayList;
    //   541: aload_0
    //   542: invokevirtual 408	com/tencent/mobileqq/richstatus/StatusServlet:getAppRuntime	()Lmqq/app/AppRuntime;
    //   545: checkcast 286	com/tencent/mobileqq/app/QQAppInterface
    //   548: astore 14
    //   550: iconst_0
    //   551: istore_3
    //   552: iload_3
    //   553: iload 6
    //   555: if_icmpge +998 -> 1553
    //   558: aload 16
    //   560: invokevirtual 502	java/nio/ByteBuffer:getShort	()S
    //   563: newarray byte
    //   565: astore 17
    //   567: aload 16
    //   569: aload 17
    //   571: invokevirtual 494	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   574: pop
    //   575: aload 16
    //   577: invokevirtual 502	java/nio/ByteBuffer:getShort	()S
    //   580: newarray byte
    //   582: astore 18
    //   584: aload 16
    //   586: aload 18
    //   588: invokevirtual 494	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   591: pop
    //   592: aload 16
    //   594: invokevirtual 492	java/nio/ByteBuffer:getInt	()I
    //   597: pop
    //   598: aload 16
    //   600: invokevirtual 492	java/nio/ByteBuffer:getInt	()I
    //   603: istore 7
    //   605: aload 16
    //   607: aload 16
    //   609: invokevirtual 510	java/nio/ByteBuffer:position	()I
    //   612: bipush 8
    //   614: iadd
    //   615: invokevirtual 513	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   618: pop
    //   619: iload 7
    //   621: iload 5
    //   623: if_icmple +599 -> 1222
    //   626: iload_3
    //   627: iconst_1
    //   628: iadd
    //   629: istore_3
    //   630: goto -78 -> 552
    //   633: aconst_null
    //   634: ldc_w 515
    //   637: ldc_w 517
    //   640: new 172	java/lang/StringBuilder
    //   643: dup
    //   644: invokespecial 173	java/lang/StringBuilder:<init>	()V
    //   647: ldc_w 519
    //   650: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   653: iload_3
    //   654: invokevirtual 191	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   657: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   660: aconst_null
    //   661: fconst_0
    //   662: invokestatic 524	bggk:a	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;F)V
    //   665: ldc_w 515
    //   668: ldc_w 517
    //   671: invokestatic 528	bggj:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   674: iconst_0
    //   675: istore 8
    //   677: goto -499 -> 178
    //   680: iconst_0
    //   681: istore 9
    //   683: aconst_null
    //   684: ldc_w 515
    //   687: ldc_w 530
    //   690: new 172	java/lang/StringBuilder
    //   693: dup
    //   694: invokespecial 173	java/lang/StringBuilder:<init>	()V
    //   697: ldc_w 519
    //   700: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   703: iload_3
    //   704: invokevirtual 191	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   707: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   710: aconst_null
    //   711: fconst_0
    //   712: invokestatic 524	bggk:a	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;F)V
    //   715: goto -533 -> 182
    //   718: astore 13
    //   720: invokestatic 168	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   723: ifeq +34 -> 757
    //   726: ldc_w 532
    //   729: iconst_2
    //   730: new 172	java/lang/StringBuilder
    //   733: dup
    //   734: invokespecial 173	java/lang/StringBuilder:<init>	()V
    //   737: ldc_w 534
    //   740: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   743: aload 13
    //   745: invokevirtual 537	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:getMessage	()Ljava/lang/String;
    //   748: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   751: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   754: invokestatic 203	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   757: iconst_0
    //   758: istore 9
    //   760: goto -578 -> 182
    //   763: aconst_null
    //   764: ldc_w 515
    //   767: ldc_w 539
    //   770: aload_2
    //   771: invokevirtual 542	com/tencent/qphone/base/remote/FromServiceMsg:getBusinessFailMsg	()Ljava/lang/String;
    //   774: aconst_null
    //   775: fconst_0
    //   776: invokestatic 524	bggk:a	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;F)V
    //   779: ldc_w 515
    //   782: ldc_w 539
    //   785: invokestatic 528	bggj:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   788: goto -602 -> 186
    //   791: iconst_0
    //   792: istore 8
    //   794: aload 15
    //   796: ldc_w 544
    //   799: iload_3
    //   800: invokevirtual 215	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   803: goto -470 -> 333
    //   806: astore 13
    //   808: invokestatic 168	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   811: ifeq +34 -> 845
    //   814: ldc_w 532
    //   817: iconst_2
    //   818: new 172	java/lang/StringBuilder
    //   821: dup
    //   822: invokespecial 173	java/lang/StringBuilder:<init>	()V
    //   825: ldc_w 534
    //   828: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   831: aload 13
    //   833: invokevirtual 545	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   836: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   839: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   842: invokestatic 203	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   845: iconst_0
    //   846: istore 9
    //   848: goto -511 -> 337
    //   851: aconst_null
    //   852: ldc_w 547
    //   855: ldc_w 549
    //   858: new 172	java/lang/StringBuilder
    //   861: dup
    //   862: invokespecial 173	java/lang/StringBuilder:<init>	()V
    //   865: ldc_w 519
    //   868: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   871: iload_3
    //   872: invokevirtual 191	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   875: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   878: aconst_null
    //   879: fconst_0
    //   880: invokestatic 524	bggk:a	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;F)V
    //   883: ldc_w 547
    //   886: iload_3
    //   887: invokestatic 551	bggj:a	(Ljava/lang/String;I)V
    //   890: aload 15
    //   892: ldc_w 553
    //   895: iload_3
    //   896: invokevirtual 215	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   899: iload_3
    //   900: ldc_w 554
    //   903: if_icmpne +22 -> 925
    //   906: aload 15
    //   908: ldc_w 556
    //   911: aload 13
    //   913: getfield 131	com/tencent/pb/signature/SigActPb$RspBody:auth_rsp	Lcom/tencent/pb/signature/SigActPb$SigauthRsp;
    //   916: getfield 557	com/tencent/pb/signature/SigActPb$SigauthRsp:url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   919: invokevirtual 233	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   922: invokevirtual 237	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   925: aload 13
    //   927: getfield 131	com/tencent/pb/signature/SigActPb$RspBody:auth_rsp	Lcom/tencent/pb/signature/SigActPb$SigauthRsp;
    //   930: getfield 560	com/tencent/pb/signature/SigActPb$SigauthRsp:authfailed_appid	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   933: invokevirtual 561	com/tencent/mobileqq/pb/PBInt32Field:has	()Z
    //   936: ifeq +22 -> 958
    //   939: aload 15
    //   941: ldc_w 563
    //   944: aload 13
    //   946: getfield 131	com/tencent/pb/signature/SigActPb$RspBody:auth_rsp	Lcom/tencent/pb/signature/SigActPb$SigauthRsp;
    //   949: getfield 560	com/tencent/pb/signature/SigActPb$SigauthRsp:authfailed_appid	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   952: invokevirtual 188	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   955: invokevirtual 215	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   958: aload 13
    //   960: getfield 131	com/tencent/pb/signature/SigActPb$RspBody:auth_rsp	Lcom/tencent/pb/signature/SigActPb$SigauthRsp;
    //   963: getfield 137	com/tencent/pb/signature/SigActPb$SigauthRsp:tips_info	Lcom/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo;
    //   966: invokevirtual 142	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo:has	()Z
    //   969: ifeq +215 -> 1184
    //   972: new 139	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo
    //   975: dup
    //   976: invokespecial 143	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo:<init>	()V
    //   979: astore 14
    //   981: aload 14
    //   983: aload 13
    //   985: getfield 131	com/tencent/pb/signature/SigActPb$RspBody:auth_rsp	Lcom/tencent/pb/signature/SigActPb$SigauthRsp;
    //   988: getfield 137	com/tencent/pb/signature/SigActPb$SigauthRsp:tips_info	Lcom/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo;
    //   991: invokevirtual 147	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   994: checkcast 139	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo
    //   997: invokevirtual 151	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo:toByteArray	()[B
    //   1000: invokevirtual 155	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1003: pop
    //   1004: aload 14
    //   1006: getfield 159	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo:valid	Lcom/tencent/mobileqq/pb/PBBoolField;
    //   1009: invokevirtual 163	com/tencent/mobileqq/pb/PBBoolField:get	()Z
    //   1012: istore 8
    //   1014: aload 15
    //   1016: ldc 204
    //   1018: iload 8
    //   1020: invokevirtual 210	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   1023: iload 8
    //   1025: ifeq +125 -> 1150
    //   1028: aload 15
    //   1030: ldc 217
    //   1032: aload 14
    //   1034: getfield 220	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo:type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1037: invokevirtual 223	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1040: invokevirtual 215	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1043: aload 15
    //   1045: ldc 225
    //   1047: aload 14
    //   1049: getfield 229	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo:title_wording	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1052: invokevirtual 233	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1055: invokevirtual 237	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1058: aload 15
    //   1060: ldc 239
    //   1062: aload 14
    //   1064: getfield 241	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo:wording	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1067: invokevirtual 233	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1070: invokevirtual 237	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1073: aload 15
    //   1075: ldc 243
    //   1077: aload 14
    //   1079: getfield 246	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo:right_btn_wording	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1082: invokevirtual 233	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1085: invokevirtual 237	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1088: aload 15
    //   1090: ldc 248
    //   1092: aload 14
    //   1094: getfield 251	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo:left_btn_wording	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1097: invokevirtual 233	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1100: invokevirtual 237	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1103: aload 15
    //   1105: ldc 253
    //   1107: aload 14
    //   1109: getfield 256	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo:vip_type	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1112: invokevirtual 233	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1115: invokevirtual 237	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1118: aload 15
    //   1120: ldc_w 258
    //   1123: aload 14
    //   1125: getfield 261	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo:vip_month	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1128: invokevirtual 223	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1131: invokevirtual 215	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1134: aload 15
    //   1136: ldc_w 263
    //   1139: aload 14
    //   1141: getfield 265	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo:url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1144: invokevirtual 233	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1147: invokevirtual 237	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1150: invokestatic 168	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1153: ifeq +31 -> 1184
    //   1156: ldc_w 267
    //   1159: iconst_2
    //   1160: new 172	java/lang/StringBuilder
    //   1163: dup
    //   1164: invokespecial 173	java/lang/StringBuilder:<init>	()V
    //   1167: ldc_w 565
    //   1170: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1173: aload 15
    //   1175: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1178: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1181: invokestatic 277	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1184: iconst_0
    //   1185: istore 8
    //   1187: goto -854 -> 333
    //   1190: aconst_null
    //   1191: ldc_w 547
    //   1194: ldc_w 567
    //   1197: aload_2
    //   1198: invokevirtual 542	com/tencent/qphone/base/remote/FromServiceMsg:getBusinessFailMsg	()Ljava/lang/String;
    //   1201: aconst_null
    //   1202: fconst_0
    //   1203: invokestatic 524	bggk:a	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;F)V
    //   1206: ldc_w 547
    //   1209: iconst_m1
    //   1210: invokestatic 551	bggj:a	(Ljava/lang/String;I)V
    //   1213: goto -876 -> 337
    //   1216: iconst_0
    //   1217: istore 8
    //   1219: goto -699 -> 520
    //   1222: aload 18
    //   1224: invokestatic 573	com/tencent/mobileqq/richstatus/RichStatus:parseStatus	([B)Lcom/tencent/mobileqq/richstatus/RichStatus;
    //   1227: astore 18
    //   1229: aload 18
    //   1231: iload 7
    //   1233: i2l
    //   1234: putfield 576	com/tencent/mobileqq/richstatus/RichStatus:time	J
    //   1237: aload 18
    //   1239: aload 17
    //   1241: putfield 579	com/tencent/mobileqq/richstatus/RichStatus:key	[B
    //   1244: aload 18
    //   1246: getfield 579	com/tencent/mobileqq/richstatus/RichStatus:key	[B
    //   1249: ifnull +20 -> 1269
    //   1252: aload 18
    //   1254: new 581	java/lang/String
    //   1257: dup
    //   1258: aload 18
    //   1260: getfield 579	com/tencent/mobileqq/richstatus/RichStatus:key	[B
    //   1263: invokespecial 584	java/lang/String:<init>	([B)V
    //   1266: putfield 588	com/tencent/mobileqq/richstatus/RichStatus:feedsId	Ljava/lang/String;
    //   1269: aload 13
    //   1271: getfield 507	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:richStatus	Ljava/util/ArrayList;
    //   1274: aload 18
    //   1276: invokevirtual 96	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1279: pop
    //   1280: goto -654 -> 626
    //   1283: astore 13
    //   1285: iconst_0
    //   1286: istore 9
    //   1288: aload 13
    //   1290: invokevirtual 591	java/lang/Exception:printStackTrace	()V
    //   1293: iload 9
    //   1295: istore 8
    //   1297: invokestatic 168	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1300: ifeq +19 -> 1319
    //   1303: ldc_w 532
    //   1306: iconst_2
    //   1307: aload 13
    //   1309: invokevirtual 545	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1312: invokestatic 594	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1315: iload 9
    //   1317: istore 8
    //   1319: aload_0
    //   1320: aload_1
    //   1321: iload 4
    //   1323: iload 8
    //   1325: aload 15
    //   1327: ldc_w 449
    //   1330: invokevirtual 453	com/tencent/mobileqq/richstatus/StatusServlet:notifyObserver	(Landroid/content/Intent;IZLandroid/os/Bundle;Ljava/lang/Class;)V
    //   1333: iload 4
    //   1335: bipush 8
    //   1337: if_icmpne +3235 -> 4572
    //   1340: iload 8
    //   1342: ifeq +3227 -> 4569
    //   1345: new 320	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   1348: dup
    //   1349: invokespecial 321	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   1352: astore 13
    //   1354: aload 13
    //   1356: aload_2
    //   1357: invokevirtual 419	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   1360: invokestatic 424	bgau:b	([B)[B
    //   1363: invokevirtual 425	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1366: checkcast 320	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   1369: astore 13
    //   1371: aload 13
    //   1373: ifnull +3193 -> 4566
    //   1376: aload 13
    //   1378: getfield 428	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1381: invokevirtual 429	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   1384: ifeq +3182 -> 4566
    //   1387: aload 13
    //   1389: getfield 428	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1392: invokevirtual 223	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1395: ifne +396 -> 1791
    //   1398: aload 13
    //   1400: getfield 362	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1403: invokevirtual 432	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1406: invokevirtual 433	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   1409: invokestatic 436	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   1412: invokevirtual 439	java/nio/ByteBuffer:get	()B
    //   1415: istore_3
    //   1416: iload_3
    //   1417: ifne +368 -> 1785
    //   1420: iconst_1
    //   1421: istore 8
    //   1423: aload_0
    //   1424: aload_1
    //   1425: iload 4
    //   1427: iload 8
    //   1429: aload 15
    //   1431: ldc_w 449
    //   1434: invokevirtual 453	com/tencent/mobileqq/richstatus/StatusServlet:notifyObserver	(Landroid/content/Intent;IZLandroid/os/Bundle;Ljava/lang/Class;)V
    //   1437: iload 4
    //   1439: iconst_1
    //   1440: if_icmpeq +9 -> 1449
    //   1443: iload 4
    //   1445: iconst_2
    //   1446: if_icmpne +106 -> 1552
    //   1449: aload_2
    //   1450: invokevirtual 419	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   1453: invokestatic 436	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   1456: astore_2
    //   1457: aload_2
    //   1458: invokevirtual 492	java/nio/ByteBuffer:getInt	()I
    //   1461: iconst_4
    //   1462: isub
    //   1463: newarray byte
    //   1465: astore 13
    //   1467: aload_2
    //   1468: aload 13
    //   1470: invokevirtual 494	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   1473: pop
    //   1474: new 320	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   1477: dup
    //   1478: invokespecial 321	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   1481: aload 13
    //   1483: invokevirtual 425	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1486: checkcast 320	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   1489: getfield 362	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1492: invokevirtual 432	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1495: invokevirtual 433	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   1498: invokestatic 436	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   1501: astore_2
    //   1502: aload_2
    //   1503: invokevirtual 439	java/nio/ByteBuffer:get	()B
    //   1506: istore_3
    //   1507: aload_2
    //   1508: invokevirtual 492	java/nio/ByteBuffer:getInt	()I
    //   1511: i2l
    //   1512: lstore 11
    //   1514: aload_2
    //   1515: invokevirtual 439	java/nio/ByteBuffer:get	()B
    //   1518: iconst_1
    //   1519: if_icmpne +323 -> 1842
    //   1522: iconst_1
    //   1523: istore 9
    //   1525: goto +3053 -> 4578
    //   1528: aload 15
    //   1530: ldc_w 314
    //   1533: iload 10
    //   1535: invokevirtual 210	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   1538: aload_0
    //   1539: aload_1
    //   1540: iload 4
    //   1542: iload 9
    //   1544: aload 15
    //   1546: ldc_w 449
    //   1549: invokevirtual 453	com/tencent/mobileqq/richstatus/StatusServlet:notifyObserver	(Landroid/content/Intent;IZLandroid/os/Bundle;Ljava/lang/Class;)V
    //   1552: return
    //   1553: aload 13
    //   1555: getfield 507	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:richStatus	Ljava/util/ArrayList;
    //   1558: invokevirtual 597	java/util/ArrayList:isEmpty	()Z
    //   1561: ifeq +88 -> 1649
    //   1564: aload 13
    //   1566: getfield 473	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:startTime	I
    //   1569: ifne +80 -> 1649
    //   1572: aload 13
    //   1574: getfield 479	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:endTime	I
    //   1577: ldc_w 476
    //   1580: if_icmpne +69 -> 1649
    //   1583: aload_0
    //   1584: invokevirtual 408	com/tencent/mobileqq/richstatus/StatusServlet:getAppRuntime	()Lmqq/app/AppRuntime;
    //   1587: bipush 51
    //   1589: invokevirtual 414	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   1592: checkcast 599	amsw
    //   1595: lload 11
    //   1597: invokestatic 603	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1600: invokevirtual 606	amsw:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   1603: astore 16
    //   1605: aload 16
    //   1607: ifnull +42 -> 1649
    //   1610: aload 16
    //   1612: invokevirtual 612	com/tencent/mobileqq/data/Card:getRichStatus	()Lcom/tencent/mobileqq/richstatus/RichStatus;
    //   1615: ifnull +34 -> 1649
    //   1618: aload 16
    //   1620: invokevirtual 612	com/tencent/mobileqq/data/Card:getRichStatus	()Lcom/tencent/mobileqq/richstatus/RichStatus;
    //   1623: invokevirtual 613	com/tencent/mobileqq/richstatus/RichStatus:isEmpty	()Z
    //   1626: ifne +23 -> 1649
    //   1629: aload 13
    //   1631: getfield 507	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:richStatus	Ljava/util/ArrayList;
    //   1634: aload 16
    //   1636: invokevirtual 612	com/tencent/mobileqq/data/Card:getRichStatus	()Lcom/tencent/mobileqq/richstatus/RichStatus;
    //   1639: invokevirtual 96	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1642: pop
    //   1643: aload 13
    //   1645: iconst_1
    //   1646: putfield 483	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:isAddFromCard	Z
    //   1649: aload 14
    //   1651: bipush 41
    //   1653: invokevirtual 617	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   1656: checkcast 619	com/tencent/mobileqq/app/SignatureHandler
    //   1659: astore 16
    //   1661: aload 13
    //   1663: getfield 507	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:richStatus	Ljava/util/ArrayList;
    //   1666: invokevirtual 67	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   1669: astore 17
    //   1671: aload 17
    //   1673: invokeinterface 73 1 0
    //   1678: ifeq +42 -> 1720
    //   1681: aload 17
    //   1683: invokeinterface 77 1 0
    //   1688: checkcast 569	com/tencent/mobileqq/richstatus/RichStatus
    //   1691: astore 18
    //   1693: aload 16
    //   1695: ifnull -24 -> 1671
    //   1698: aload 16
    //   1700: lload 11
    //   1702: invokestatic 603	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1705: aload 18
    //   1707: getfield 588	com/tencent/mobileqq/richstatus/RichStatus:feedsId	Ljava/lang/String;
    //   1710: sipush 255
    //   1713: iconst_1
    //   1714: invokevirtual 622	com/tencent/mobileqq/app/SignatureHandler:a	(Ljava/lang/String;Ljava/lang/String;IZ)V
    //   1717: goto -46 -> 1671
    //   1720: aload 13
    //   1722: iload 8
    //   1724: putfield 625	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:over	Z
    //   1727: aload 14
    //   1729: bipush 58
    //   1731: invokevirtual 626	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1734: checkcast 628	com/tencent/mobileqq/app/SignatureManager
    //   1737: astore 16
    //   1739: iload 9
    //   1741: istore 8
    //   1743: aload 16
    //   1745: ifnull -426 -> 1319
    //   1748: iload 9
    //   1750: istore 8
    //   1752: aload 14
    //   1754: invokevirtual 304	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1757: lload 11
    //   1759: invokestatic 632	java/lang/Long:toString	(J)Ljava/lang/String;
    //   1762: invokevirtual 635	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1765: ifeq -446 -> 1319
    //   1768: aload 16
    //   1770: aload 13
    //   1772: getfield 507	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:richStatus	Ljava/util/ArrayList;
    //   1775: invokevirtual 638	com/tencent/mobileqq/app/SignatureManager:a	(Ljava/util/List;)V
    //   1778: iload 9
    //   1780: istore 8
    //   1782: goto -463 -> 1319
    //   1785: iconst_0
    //   1786: istore 8
    //   1788: goto -365 -> 1423
    //   1791: iconst_0
    //   1792: istore 8
    //   1794: goto -371 -> 1423
    //   1797: astore 13
    //   1799: invokestatic 168	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1802: ifeq +34 -> 1836
    //   1805: ldc_w 532
    //   1808: iconst_2
    //   1809: new 172	java/lang/StringBuilder
    //   1812: dup
    //   1813: invokespecial 173	java/lang/StringBuilder:<init>	()V
    //   1816: ldc_w 534
    //   1819: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1822: aload 13
    //   1824: invokevirtual 537	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:getMessage	()Ljava/lang/String;
    //   1827: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1830: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1833: invokestatic 203	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1836: iconst_0
    //   1837: istore 8
    //   1839: goto -416 -> 1423
    //   1842: iconst_0
    //   1843: istore 9
    //   1845: goto +2733 -> 4578
    //   1848: iload 9
    //   1850: istore 10
    //   1852: iload 8
    //   1854: istore 9
    //   1856: iload 4
    //   1858: iconst_2
    //   1859: if_icmpne -331 -> 1528
    //   1862: aload_1
    //   1863: ldc_w 314
    //   1866: iconst_0
    //   1867: invokevirtual 642	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   1870: istore 10
    //   1872: iload 8
    //   1874: istore 9
    //   1876: goto -348 -> 1528
    //   1879: astore_2
    //   1880: iconst_0
    //   1881: istore 8
    //   1883: aload_2
    //   1884: invokevirtual 591	java/lang/Exception:printStackTrace	()V
    //   1887: iload 8
    //   1889: istore 9
    //   1891: invokestatic 168	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1894: ifeq -356 -> 1538
    //   1897: ldc_w 532
    //   1900: iconst_2
    //   1901: aload_2
    //   1902: invokevirtual 545	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1905: invokestatic 594	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1908: iload 8
    //   1910: istore 9
    //   1912: goto -374 -> 1538
    //   1915: iload 4
    //   1917: tableswitch	default:+51 -> 1968, 1:+66->1983, 2:+66->1983, 3:+791->2708, 4:+221->2138, 5:+904->2821, 6:+1320->3237, 7:+1797->3714, 8:+2497->4414, 9:+1974->3891
    //   1969: aload_1
    //   1970: iload 4
    //   1972: iload 8
    //   1974: aload 15
    //   1976: ldc_w 449
    //   1979: invokevirtual 453	com/tencent/mobileqq/richstatus/StatusServlet:notifyObserver	(Landroid/content/Intent;IZLandroid/os/Bundle;Ljava/lang/Class;)V
    //   1982: return
    //   1983: aload_2
    //   1984: invokevirtual 419	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   1987: invokestatic 436	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   1990: astore_2
    //   1991: aload_2
    //   1992: invokevirtual 492	java/nio/ByteBuffer:getInt	()I
    //   1995: iconst_4
    //   1996: isub
    //   1997: newarray byte
    //   1999: astore 13
    //   2001: aload_2
    //   2002: aload 13
    //   2004: invokevirtual 494	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   2007: pop
    //   2008: new 320	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   2011: dup
    //   2012: invokespecial 321	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   2015: aload 13
    //   2017: invokevirtual 425	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2020: checkcast 320	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   2023: getfield 362	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   2026: invokevirtual 432	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   2029: invokevirtual 433	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   2032: invokestatic 436	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   2035: astore_2
    //   2036: aload_2
    //   2037: invokevirtual 439	java/nio/ByteBuffer:get	()B
    //   2040: istore_3
    //   2041: aload_2
    //   2042: invokevirtual 492	java/nio/ByteBuffer:getInt	()I
    //   2045: i2l
    //   2046: lstore 11
    //   2048: aload_2
    //   2049: invokevirtual 439	java/nio/ByteBuffer:get	()B
    //   2052: iconst_1
    //   2053: if_icmpne +2561 -> 4614
    //   2056: iconst_1
    //   2057: istore 9
    //   2059: goto +2537 -> 4596
    //   2062: aload 15
    //   2064: ldc_w 314
    //   2067: iload 10
    //   2069: invokevirtual 210	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   2072: iload 9
    //   2074: istore 8
    //   2076: goto -108 -> 1968
    //   2079: iload 9
    //   2081: istore 10
    //   2083: iload 8
    //   2085: istore 9
    //   2087: iload 4
    //   2089: iconst_2
    //   2090: if_icmpne -28 -> 2062
    //   2093: aload_1
    //   2094: ldc_w 314
    //   2097: iconst_0
    //   2098: invokevirtual 642	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   2101: istore 10
    //   2103: iload 8
    //   2105: istore 9
    //   2107: goto -45 -> 2062
    //   2110: astore_2
    //   2111: aload_2
    //   2112: invokevirtual 591	java/lang/Exception:printStackTrace	()V
    //   2115: invokestatic 168	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2118: ifeq +14 -> 2132
    //   2121: ldc_w 532
    //   2124: iconst_2
    //   2125: aload_2
    //   2126: invokevirtual 545	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2129: invokestatic 594	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   2132: iconst_0
    //   2133: istore 8
    //   2135: goto -167 -> 1968
    //   2138: new 467	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory
    //   2141: dup
    //   2142: invokespecial 468	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:<init>	()V
    //   2145: astore 13
    //   2147: aload 13
    //   2149: aload_1
    //   2150: ldc_w 470
    //   2153: iconst_0
    //   2154: invokevirtual 398	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   2157: putfield 473	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:startTime	I
    //   2160: aload 13
    //   2162: aload_1
    //   2163: ldc_w 475
    //   2166: ldc_w 476
    //   2169: invokevirtual 398	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   2172: putfield 479	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:endTime	I
    //   2175: aload 13
    //   2177: iconst_0
    //   2178: putfield 483	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:isAddFromCard	Z
    //   2181: aload 15
    //   2183: ldc_w 485
    //   2186: aload 13
    //   2188: invokevirtual 489	android/os/Bundle:putSerializable	(Ljava/lang/String;Ljava/io/Serializable;)V
    //   2191: aload_2
    //   2192: invokevirtual 419	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   2195: invokestatic 436	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   2198: astore_2
    //   2199: aload_2
    //   2200: invokevirtual 492	java/nio/ByteBuffer:getInt	()I
    //   2203: iconst_4
    //   2204: isub
    //   2205: newarray byte
    //   2207: astore 14
    //   2209: aload_2
    //   2210: aload 14
    //   2212: invokevirtual 494	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   2215: pop
    //   2216: new 320	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   2219: dup
    //   2220: invokespecial 321	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   2223: aload 14
    //   2225: invokevirtual 425	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2228: checkcast 320	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   2231: getfield 362	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   2234: invokevirtual 432	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   2237: invokevirtual 433	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   2240: invokestatic 436	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   2243: astore 14
    //   2245: aload 14
    //   2247: invokevirtual 439	java/nio/ByteBuffer:get	()B
    //   2250: pop
    //   2251: aload 14
    //   2253: invokevirtual 498	java/nio/ByteBuffer:getLong	()J
    //   2256: lstore 11
    //   2258: aload 14
    //   2260: invokevirtual 439	java/nio/ByteBuffer:get	()B
    //   2263: pop
    //   2264: aload 14
    //   2266: invokevirtual 492	java/nio/ByteBuffer:getInt	()I
    //   2269: pop
    //   2270: aload 14
    //   2272: invokevirtual 492	java/nio/ByteBuffer:getInt	()I
    //   2275: istore 5
    //   2277: aload 14
    //   2279: invokevirtual 492	java/nio/ByteBuffer:getInt	()I
    //   2282: pop
    //   2283: aload 14
    //   2285: invokevirtual 439	java/nio/ByteBuffer:get	()B
    //   2288: ifeq +2339 -> 4627
    //   2291: iconst_1
    //   2292: istore 9
    //   2294: aload 14
    //   2296: invokevirtual 502	java/nio/ByteBuffer:getShort	()S
    //   2299: istore 6
    //   2301: aload 13
    //   2303: new 58	java/util/ArrayList
    //   2306: dup
    //   2307: iload 6
    //   2309: invokespecial 504	java/util/ArrayList:<init>	(I)V
    //   2312: putfield 507	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:richStatus	Ljava/util/ArrayList;
    //   2315: aload_0
    //   2316: invokevirtual 408	com/tencent/mobileqq/richstatus/StatusServlet:getAppRuntime	()Lmqq/app/AppRuntime;
    //   2319: checkcast 286	com/tencent/mobileqq/app/QQAppInterface
    //   2322: astore_2
    //   2323: iconst_0
    //   2324: istore_3
    //   2325: iload_3
    //   2326: iload 6
    //   2328: if_icmpge +163 -> 2491
    //   2331: aload 14
    //   2333: invokevirtual 502	java/nio/ByteBuffer:getShort	()S
    //   2336: newarray byte
    //   2338: astore 16
    //   2340: aload 14
    //   2342: aload 16
    //   2344: invokevirtual 494	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   2347: pop
    //   2348: aload 14
    //   2350: invokevirtual 502	java/nio/ByteBuffer:getShort	()S
    //   2353: newarray byte
    //   2355: astore 17
    //   2357: aload 14
    //   2359: aload 17
    //   2361: invokevirtual 494	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   2364: pop
    //   2365: aload 14
    //   2367: invokevirtual 492	java/nio/ByteBuffer:getInt	()I
    //   2370: pop
    //   2371: aload 14
    //   2373: invokevirtual 492	java/nio/ByteBuffer:getInt	()I
    //   2376: istore 7
    //   2378: aload 14
    //   2380: aload 14
    //   2382: invokevirtual 510	java/nio/ByteBuffer:position	()I
    //   2385: bipush 8
    //   2387: iadd
    //   2388: invokevirtual 513	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   2391: pop
    //   2392: iload 7
    //   2394: iload 5
    //   2396: if_icmple +6 -> 2402
    //   2399: goto +2221 -> 4620
    //   2402: aload 17
    //   2404: invokestatic 573	com/tencent/mobileqq/richstatus/RichStatus:parseStatus	([B)Lcom/tencent/mobileqq/richstatus/RichStatus;
    //   2407: astore 17
    //   2409: aload 17
    //   2411: iload 7
    //   2413: i2l
    //   2414: putfield 576	com/tencent/mobileqq/richstatus/RichStatus:time	J
    //   2417: aload 17
    //   2419: aload 16
    //   2421: putfield 579	com/tencent/mobileqq/richstatus/RichStatus:key	[B
    //   2424: aload 17
    //   2426: getfield 579	com/tencent/mobileqq/richstatus/RichStatus:key	[B
    //   2429: ifnull +20 -> 2449
    //   2432: aload 17
    //   2434: new 581	java/lang/String
    //   2437: dup
    //   2438: aload 17
    //   2440: getfield 579	com/tencent/mobileqq/richstatus/RichStatus:key	[B
    //   2443: invokespecial 584	java/lang/String:<init>	([B)V
    //   2446: putfield 588	com/tencent/mobileqq/richstatus/RichStatus:feedsId	Ljava/lang/String;
    //   2449: aload 13
    //   2451: getfield 507	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:richStatus	Ljava/util/ArrayList;
    //   2454: aload 17
    //   2456: invokevirtual 96	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2459: pop
    //   2460: goto +2160 -> 4620
    //   2463: astore_2
    //   2464: aload_2
    //   2465: invokevirtual 591	java/lang/Exception:printStackTrace	()V
    //   2468: invokestatic 168	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2471: ifeq +14 -> 2485
    //   2474: ldc_w 532
    //   2477: iconst_2
    //   2478: aload_2
    //   2479: invokevirtual 545	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2482: invokestatic 594	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   2485: iconst_0
    //   2486: istore 8
    //   2488: goto -520 -> 1968
    //   2491: aload 13
    //   2493: getfield 507	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:richStatus	Ljava/util/ArrayList;
    //   2496: invokevirtual 597	java/util/ArrayList:isEmpty	()Z
    //   2499: ifeq +88 -> 2587
    //   2502: aload 13
    //   2504: getfield 473	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:startTime	I
    //   2507: ifne +80 -> 2587
    //   2510: aload 13
    //   2512: getfield 479	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:endTime	I
    //   2515: ldc_w 476
    //   2518: if_icmpne +69 -> 2587
    //   2521: aload_0
    //   2522: invokevirtual 408	com/tencent/mobileqq/richstatus/StatusServlet:getAppRuntime	()Lmqq/app/AppRuntime;
    //   2525: bipush 51
    //   2527: invokevirtual 414	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   2530: checkcast 599	amsw
    //   2533: lload 11
    //   2535: invokestatic 603	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   2538: invokevirtual 606	amsw:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   2541: astore 14
    //   2543: aload 14
    //   2545: ifnull +42 -> 2587
    //   2548: aload 14
    //   2550: invokevirtual 612	com/tencent/mobileqq/data/Card:getRichStatus	()Lcom/tencent/mobileqq/richstatus/RichStatus;
    //   2553: ifnull +34 -> 2587
    //   2556: aload 14
    //   2558: invokevirtual 612	com/tencent/mobileqq/data/Card:getRichStatus	()Lcom/tencent/mobileqq/richstatus/RichStatus;
    //   2561: invokevirtual 613	com/tencent/mobileqq/richstatus/RichStatus:isEmpty	()Z
    //   2564: ifne +23 -> 2587
    //   2567: aload 13
    //   2569: getfield 507	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:richStatus	Ljava/util/ArrayList;
    //   2572: aload 14
    //   2574: invokevirtual 612	com/tencent/mobileqq/data/Card:getRichStatus	()Lcom/tencent/mobileqq/richstatus/RichStatus;
    //   2577: invokevirtual 96	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2580: pop
    //   2581: aload 13
    //   2583: iconst_1
    //   2584: putfield 483	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:isAddFromCard	Z
    //   2587: aload_2
    //   2588: bipush 41
    //   2590: invokevirtual 617	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   2593: checkcast 619	com/tencent/mobileqq/app/SignatureHandler
    //   2596: astore 14
    //   2598: aload 13
    //   2600: getfield 507	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:richStatus	Ljava/util/ArrayList;
    //   2603: invokevirtual 67	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   2606: astore 16
    //   2608: aload 16
    //   2610: invokeinterface 73 1 0
    //   2615: ifeq +42 -> 2657
    //   2618: aload 16
    //   2620: invokeinterface 77 1 0
    //   2625: checkcast 569	com/tencent/mobileqq/richstatus/RichStatus
    //   2628: astore 17
    //   2630: aload 14
    //   2632: ifnull -24 -> 2608
    //   2635: aload 14
    //   2637: lload 11
    //   2639: invokestatic 603	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   2642: aload 17
    //   2644: getfield 588	com/tencent/mobileqq/richstatus/RichStatus:feedsId	Ljava/lang/String;
    //   2647: sipush 255
    //   2650: iconst_1
    //   2651: invokevirtual 622	com/tencent/mobileqq/app/SignatureHandler:a	(Ljava/lang/String;Ljava/lang/String;IZ)V
    //   2654: goto -46 -> 2608
    //   2657: aload 13
    //   2659: iload 9
    //   2661: putfield 625	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:over	Z
    //   2664: aload_2
    //   2665: bipush 58
    //   2667: invokevirtual 626	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   2670: checkcast 628	com/tencent/mobileqq/app/SignatureManager
    //   2673: astore 14
    //   2675: aload 14
    //   2677: ifnull +28 -> 2705
    //   2680: aload_2
    //   2681: invokevirtual 304	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   2684: lload 11
    //   2686: invokestatic 632	java/lang/Long:toString	(J)Ljava/lang/String;
    //   2689: invokevirtual 635	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2692: ifeq +13 -> 2705
    //   2695: aload 14
    //   2697: aload 13
    //   2699: getfield 507	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:richStatus	Ljava/util/ArrayList;
    //   2702: invokevirtual 638	com/tencent/mobileqq/app/SignatureManager:a	(Ljava/util/List;)V
    //   2705: goto -737 -> 1968
    //   2708: aload 15
    //   2710: ldc_w 644
    //   2713: aload_1
    //   2714: ldc_w 644
    //   2717: iconst_1
    //   2718: invokevirtual 642	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   2721: invokevirtual 210	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   2724: aload 15
    //   2726: ldc_w 646
    //   2729: aload_1
    //   2730: ldc_w 646
    //   2733: iconst_m1
    //   2734: invokevirtual 398	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   2737: invokevirtual 215	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   2740: new 648	com/qq/jce/wup/UniPacket
    //   2743: dup
    //   2744: iconst_1
    //   2745: invokespecial 651	com/qq/jce/wup/UniPacket:<init>	(Z)V
    //   2748: astore 13
    //   2750: aload 13
    //   2752: ldc_w 653
    //   2755: invokevirtual 657	com/qq/jce/wup/UniPacket:setEncodeName	(Ljava/lang/String;)V
    //   2758: aload 13
    //   2760: aload_2
    //   2761: invokevirtual 419	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   2764: invokevirtual 660	com/qq/jce/wup/UniPacket:decode	([B)V
    //   2767: aload 13
    //   2769: ldc_w 662
    //   2772: new 664	PersonalState/RespGetSameStateList
    //   2775: dup
    //   2776: invokespecial 665	PersonalState/RespGetSameStateList:<init>	()V
    //   2779: invokevirtual 669	com/qq/jce/wup/UniPacket:getByClass	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   2782: checkcast 664	PersonalState/RespGetSameStateList
    //   2785: astore_2
    //   2786: aload_2
    //   2787: getfield 673	PersonalState/RespGetSameStateList:oHead	LPersonalState/BusiRespHead;
    //   2790: getfield 678	PersonalState/BusiRespHead:iReplyCode	I
    //   2793: ifne +15 -> 2808
    //   2796: aload 15
    //   2798: ldc_w 680
    //   2801: aload_2
    //   2802: invokevirtual 489	android/os/Bundle:putSerializable	(Ljava/lang/String;Ljava/io/Serializable;)V
    //   2805: goto -837 -> 1968
    //   2808: iconst_0
    //   2809: istore 8
    //   2811: goto -6 -> 2805
    //   2814: astore_2
    //   2815: iconst_0
    //   2816: istore 8
    //   2818: goto -850 -> 1968
    //   2821: iload 8
    //   2823: ifeq -855 -> 1968
    //   2826: new 320	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   2829: dup
    //   2830: invokespecial 321	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   2833: astore 13
    //   2835: aload 13
    //   2837: aload_2
    //   2838: invokevirtual 419	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   2841: invokestatic 424	bgau:b	([B)[B
    //   2844: invokevirtual 425	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2847: checkcast 320	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   2850: astore_2
    //   2851: aload_2
    //   2852: ifnull +368 -> 3220
    //   2855: aload_2
    //   2856: getfield 428	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2859: invokevirtual 429	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   2862: ifeq +358 -> 3220
    //   2865: aload_2
    //   2866: getfield 428	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2869: invokevirtual 223	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2872: istore_3
    //   2873: iload_3
    //   2874: ifne +331 -> 3205
    //   2877: aload_2
    //   2878: getfield 362	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   2881: invokevirtual 432	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   2884: invokevirtual 433	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   2887: invokestatic 436	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   2890: astore_2
    //   2891: aload_2
    //   2892: invokevirtual 439	java/nio/ByteBuffer:get	()B
    //   2895: istore_3
    //   2896: iload_3
    //   2897: ifne +239 -> 3136
    //   2900: aload_2
    //   2901: invokevirtual 502	java/nio/ByteBuffer:getShort	()S
    //   2904: istore 5
    //   2906: new 58	java/util/ArrayList
    //   2909: dup
    //   2910: invokespecial 59	java/util/ArrayList:<init>	()V
    //   2913: astore 13
    //   2915: iconst_0
    //   2916: istore_3
    //   2917: iload_3
    //   2918: iload 5
    //   2920: if_icmpge +90 -> 3010
    //   2923: aload_2
    //   2924: invokevirtual 502	java/nio/ByteBuffer:getShort	()S
    //   2927: newarray byte
    //   2929: astore 14
    //   2931: aload_2
    //   2932: aload 14
    //   2934: invokevirtual 494	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   2937: pop
    //   2938: aload 13
    //   2940: new 581	java/lang/String
    //   2943: dup
    //   2944: aload 14
    //   2946: invokespecial 584	java/lang/String:<init>	([B)V
    //   2949: invokevirtual 96	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2952: pop
    //   2953: iload_3
    //   2954: iconst_1
    //   2955: iadd
    //   2956: istore_3
    //   2957: goto -40 -> 2917
    //   2960: astore_2
    //   2961: aload_2
    //   2962: invokevirtual 681	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   2965: invokestatic 168	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2968: ifeq +33 -> 3001
    //   2971: ldc_w 532
    //   2974: iconst_2
    //   2975: new 172	java/lang/StringBuilder
    //   2978: dup
    //   2979: invokespecial 173	java/lang/StringBuilder:<init>	()V
    //   2982: ldc_w 534
    //   2985: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2988: aload_2
    //   2989: invokevirtual 537	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:getMessage	()Ljava/lang/String;
    //   2992: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2995: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2998: invokestatic 203	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3001: iconst_0
    //   3002: istore 8
    //   3004: aload 13
    //   3006: astore_2
    //   3007: goto -156 -> 2851
    //   3010: new 58	java/util/ArrayList
    //   3013: dup
    //   3014: invokespecial 59	java/util/ArrayList:<init>	()V
    //   3017: astore 14
    //   3019: new 58	java/util/ArrayList
    //   3022: dup
    //   3023: invokespecial 59	java/util/ArrayList:<init>	()V
    //   3026: astore 16
    //   3028: aload_2
    //   3029: invokevirtual 502	java/nio/ByteBuffer:getShort	()S
    //   3032: istore 6
    //   3034: iconst_0
    //   3035: istore_3
    //   3036: iload_3
    //   3037: iload 6
    //   3039: if_icmpge +53 -> 3092
    //   3042: aload_2
    //   3043: invokevirtual 502	java/nio/ByteBuffer:getShort	()S
    //   3046: newarray byte
    //   3048: astore 17
    //   3050: aload_2
    //   3051: aload 17
    //   3053: invokevirtual 494	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   3056: pop
    //   3057: aload 14
    //   3059: new 581	java/lang/String
    //   3062: dup
    //   3063: aload 17
    //   3065: invokespecial 584	java/lang/String:<init>	([B)V
    //   3068: invokevirtual 96	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   3071: pop
    //   3072: aload 16
    //   3074: aload_2
    //   3075: invokevirtual 492	java/nio/ByteBuffer:getInt	()I
    //   3078: invokestatic 686	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3081: invokevirtual 96	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   3084: pop
    //   3085: iload_3
    //   3086: iconst_1
    //   3087: iadd
    //   3088: istore_3
    //   3089: goto -53 -> 3036
    //   3092: iload 5
    //   3094: ifle +16 -> 3110
    //   3097: aload 15
    //   3099: ldc_w 688
    //   3102: aload 13
    //   3104: invokevirtual 692	android/os/Bundle:putStringArrayList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   3107: goto +1526 -> 4633
    //   3110: aload 15
    //   3112: ldc_w 688
    //   3115: aload 14
    //   3117: invokevirtual 692	android/os/Bundle:putStringArrayList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   3120: aload 15
    //   3122: ldc_w 694
    //   3125: aload 16
    //   3127: invokevirtual 697	android/os/Bundle:putIntegerArrayList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   3130: iconst_0
    //   3131: istore 8
    //   3133: goto +1500 -> 4633
    //   3136: iconst_0
    //   3137: istore 8
    //   3139: aload 15
    //   3141: ldc_w 699
    //   3144: iload_3
    //   3145: invokevirtual 215	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   3148: goto +1485 -> 4633
    //   3151: astore_2
    //   3152: invokestatic 168	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3155: ifeq +33 -> 3188
    //   3158: ldc_w 532
    //   3161: iconst_2
    //   3162: new 172	java/lang/StringBuilder
    //   3165: dup
    //   3166: invokespecial 173	java/lang/StringBuilder:<init>	()V
    //   3169: ldc_w 701
    //   3172: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3175: aload_2
    //   3176: invokevirtual 545	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   3179: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3182: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3185: invokestatic 594	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   3188: iconst_0
    //   3189: istore 8
    //   3191: aload 15
    //   3193: ldc_w 699
    //   3196: sipush -1002
    //   3199: invokevirtual 215	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   3202: goto +1431 -> 4633
    //   3205: iconst_0
    //   3206: istore 8
    //   3208: aload 15
    //   3210: ldc_w 699
    //   3213: iload_3
    //   3214: invokevirtual 215	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   3217: goto +1416 -> 4633
    //   3220: iconst_0
    //   3221: istore 8
    //   3223: aload 15
    //   3225: ldc_w 699
    //   3228: sipush -1001
    //   3231: invokevirtual 215	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   3234: goto +1399 -> 4633
    //   3237: new 648	com/qq/jce/wup/UniPacket
    //   3240: dup
    //   3241: iconst_1
    //   3242: invokespecial 651	com/qq/jce/wup/UniPacket:<init>	(Z)V
    //   3245: astore 14
    //   3247: aload 14
    //   3249: ldc_w 653
    //   3252: invokevirtual 657	com/qq/jce/wup/UniPacket:setEncodeName	(Ljava/lang/String;)V
    //   3255: aload 14
    //   3257: aload_2
    //   3258: invokevirtual 419	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   3261: invokevirtual 660	com/qq/jce/wup/UniPacket:decode	([B)V
    //   3264: aload 14
    //   3266: ldc_w 703
    //   3269: new 705	PersonalState/RespGetHotState
    //   3272: dup
    //   3273: invokespecial 706	PersonalState/RespGetHotState:<init>	()V
    //   3276: invokevirtual 669	com/qq/jce/wup/UniPacket:getByClass	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   3279: checkcast 705	PersonalState/RespGetHotState
    //   3282: astore 14
    //   3284: aload 14
    //   3286: getfield 707	PersonalState/RespGetHotState:oHead	LPersonalState/BusiRespHead;
    //   3289: getfield 678	PersonalState/BusiRespHead:iReplyCode	I
    //   3292: ifne +400 -> 3692
    //   3295: invokestatic 168	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3298: ifeq +159 -> 3457
    //   3301: new 172	java/lang/StringBuilder
    //   3304: dup
    //   3305: ldc_w 709
    //   3308: invokespecial 711	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3311: astore 16
    //   3313: aload 16
    //   3315: ldc_w 713
    //   3318: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3321: astore 17
    //   3323: aload 14
    //   3325: getfield 716	PersonalState/RespGetHotState:vHostRichSateList	Ljava/util/ArrayList;
    //   3328: ifnonnull +102 -> 3430
    //   3331: ldc_w 718
    //   3334: astore_2
    //   3335: aload 17
    //   3337: aload_2
    //   3338: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3341: ldc_w 720
    //   3344: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3347: pop
    //   3348: aload 14
    //   3350: getfield 716	PersonalState/RespGetHotState:vHostRichSateList	Ljava/util/ArrayList;
    //   3353: ifnull +92 -> 3445
    //   3356: aload 14
    //   3358: getfield 716	PersonalState/RespGetHotState:vHostRichSateList	Ljava/util/ArrayList;
    //   3361: invokevirtual 721	java/util/ArrayList:size	()I
    //   3364: ifle +81 -> 3445
    //   3367: aload 14
    //   3369: getfield 716	PersonalState/RespGetHotState:vHostRichSateList	Ljava/util/ArrayList;
    //   3372: invokevirtual 67	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   3375: astore_2
    //   3376: aload_2
    //   3377: invokeinterface 73 1 0
    //   3382: ifeq +63 -> 3445
    //   3385: aload_2
    //   3386: invokeinterface 77 1 0
    //   3391: checkcast 723	PersonalState/HotRishState
    //   3394: astore 17
    //   3396: aload 16
    //   3398: ldc_w 725
    //   3401: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3404: aload 17
    //   3406: getfield 728	PersonalState/HotRishState:iActId	I
    //   3409: invokevirtual 191	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3412: ldc_w 730
    //   3415: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3418: aload 17
    //   3420: getfield 733	PersonalState/HotRishState:iDataId	I
    //   3423: invokevirtual 191	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3426: pop
    //   3427: goto -51 -> 3376
    //   3430: aload 14
    //   3432: getfield 716	PersonalState/RespGetHotState:vHostRichSateList	Ljava/util/ArrayList;
    //   3435: invokevirtual 721	java/util/ArrayList:size	()I
    //   3438: invokestatic 686	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3441: astore_2
    //   3442: goto -107 -> 3335
    //   3445: ldc_w 735
    //   3448: iconst_2
    //   3449: aload 16
    //   3451: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3454: invokestatic 203	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3457: new 58	java/util/ArrayList
    //   3460: dup
    //   3461: bipush 6
    //   3463: invokespecial 504	java/util/ArrayList:<init>	(I)V
    //   3466: astore_2
    //   3467: aload 14
    //   3469: getfield 716	PersonalState/RespGetHotState:vHostRichSateList	Ljava/util/ArrayList;
    //   3472: ifnull +208 -> 3680
    //   3475: aload 14
    //   3477: getfield 716	PersonalState/RespGetHotState:vHostRichSateList	Ljava/util/ArrayList;
    //   3480: invokevirtual 721	java/util/ArrayList:size	()I
    //   3483: ifle +197 -> 3680
    //   3486: aload 13
    //   3488: ifnull +82 -> 3570
    //   3491: aload 13
    //   3493: invokevirtual 737	baoy:a	()Lcom/tencent/mobileqq/richstatus/RichStatus;
    //   3496: astore 16
    //   3498: aload 14
    //   3500: getfield 716	PersonalState/RespGetHotState:vHostRichSateList	Ljava/util/ArrayList;
    //   3503: invokevirtual 721	java/util/ArrayList:size	()I
    //   3506: iconst_1
    //   3507: isub
    //   3508: istore_3
    //   3509: iload_3
    //   3510: iflt +60 -> 3570
    //   3513: aload 14
    //   3515: getfield 716	PersonalState/RespGetHotState:vHostRichSateList	Ljava/util/ArrayList;
    //   3518: iload_3
    //   3519: invokevirtual 740	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   3522: checkcast 723	PersonalState/HotRishState
    //   3525: astore 17
    //   3527: aload 17
    //   3529: getfield 728	PersonalState/HotRishState:iActId	I
    //   3532: aload 16
    //   3534: getfield 743	com/tencent/mobileqq/richstatus/RichStatus:actionId	I
    //   3537: if_icmpne +26 -> 3563
    //   3540: aload 17
    //   3542: getfield 733	PersonalState/HotRishState:iDataId	I
    //   3545: aload 16
    //   3547: getfield 746	com/tencent/mobileqq/richstatus/RichStatus:dataId	I
    //   3550: if_icmpne +13 -> 3563
    //   3553: aload 14
    //   3555: getfield 716	PersonalState/RespGetHotState:vHostRichSateList	Ljava/util/ArrayList;
    //   3558: iload_3
    //   3559: invokevirtual 749	java/util/ArrayList:remove	(I)Ljava/lang/Object;
    //   3562: pop
    //   3563: iload_3
    //   3564: iconst_1
    //   3565: isub
    //   3566: istore_3
    //   3567: goto -58 -> 3509
    //   3570: iconst_0
    //   3571: istore_3
    //   3572: iload_3
    //   3573: bipush 6
    //   3575: if_icmpge +24 -> 3599
    //   3578: aload_2
    //   3579: aload 14
    //   3581: getfield 716	PersonalState/RespGetHotState:vHostRichSateList	Ljava/util/ArrayList;
    //   3584: iload_3
    //   3585: invokevirtual 740	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   3588: invokevirtual 96	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   3591: pop
    //   3592: iload_3
    //   3593: iconst_1
    //   3594: iadd
    //   3595: istore_3
    //   3596: goto -24 -> 3572
    //   3599: new 172	java/lang/StringBuilder
    //   3602: dup
    //   3603: invokespecial 173	java/lang/StringBuilder:<init>	()V
    //   3606: astore 14
    //   3608: aload_2
    //   3609: invokevirtual 67	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   3612: astore 16
    //   3614: aload 16
    //   3616: invokeinterface 73 1 0
    //   3621: ifeq +49 -> 3670
    //   3624: aload 16
    //   3626: invokeinterface 77 1 0
    //   3631: checkcast 723	PersonalState/HotRishState
    //   3634: astore 17
    //   3636: aload 14
    //   3638: aload 17
    //   3640: getfield 728	PersonalState/HotRishState:iActId	I
    //   3643: invokevirtual 191	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3646: ldc_w 730
    //   3649: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3652: aload 17
    //   3654: getfield 733	PersonalState/HotRishState:iDataId	I
    //   3657: invokevirtual 191	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3660: ldc_w 751
    //   3663: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3666: pop
    //   3667: goto -53 -> 3614
    //   3670: aload 13
    //   3672: aload 14
    //   3674: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3677: invokevirtual 753	baoy:a	(Ljava/lang/String;)V
    //   3680: aload 15
    //   3682: ldc_w 755
    //   3685: aload_2
    //   3686: invokevirtual 489	android/os/Bundle:putSerializable	(Ljava/lang/String;Ljava/io/Serializable;)V
    //   3689: goto -1721 -> 1968
    //   3692: invokestatic 168	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3695: ifeq +13 -> 3708
    //   3698: ldc_w 735
    //   3701: iconst_2
    //   3702: ldc_w 757
    //   3705: invokestatic 203	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3708: iconst_0
    //   3709: istore 8
    //   3711: goto -1743 -> 1968
    //   3714: iload 8
    //   3716: ifeq -1748 -> 1968
    //   3719: new 320	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   3722: dup
    //   3723: invokespecial 321	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   3726: astore 13
    //   3728: aload 13
    //   3730: aload_2
    //   3731: invokevirtual 419	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   3734: invokestatic 424	bgau:b	([B)[B
    //   3737: invokevirtual 425	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3740: checkcast 320	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   3743: astore_2
    //   3744: iload 8
    //   3746: istore 9
    //   3748: aload_2
    //   3749: ifnull +80 -> 3829
    //   3752: iload 8
    //   3754: istore 9
    //   3756: aload_2
    //   3757: getfield 428	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3760: invokevirtual 429	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   3763: ifeq +66 -> 3829
    //   3766: aload_2
    //   3767: getfield 428	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3770: invokevirtual 223	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3773: ifne +69 -> 3842
    //   3776: aload_2
    //   3777: getfield 362	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3780: invokevirtual 432	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   3783: invokevirtual 433	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   3786: invokestatic 436	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   3789: astore_2
    //   3790: aload_2
    //   3791: invokevirtual 439	java/nio/ByteBuffer:get	()B
    //   3794: ifne +42 -> 3836
    //   3797: aload 15
    //   3799: ldc_w 441
    //   3802: aload_2
    //   3803: invokevirtual 365	java/nio/ByteBuffer:array	()[B
    //   3806: invokevirtual 445	android/os/Bundle:putByteArray	(Ljava/lang/String;[B)V
    //   3809: aload 15
    //   3811: ldc_w 447
    //   3814: aload_1
    //   3815: ldc_w 447
    //   3818: iconst_0
    //   3819: invokevirtual 398	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   3822: invokevirtual 215	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   3825: iload 8
    //   3827: istore 9
    //   3829: iload 9
    //   3831: istore 8
    //   3833: goto -1865 -> 1968
    //   3836: iconst_0
    //   3837: istore 9
    //   3839: goto -10 -> 3829
    //   3842: iconst_0
    //   3843: istore 9
    //   3845: goto -16 -> 3829
    //   3848: astore_2
    //   3849: invokestatic 168	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3852: ifeq +33 -> 3885
    //   3855: ldc_w 532
    //   3858: iconst_2
    //   3859: new 172	java/lang/StringBuilder
    //   3862: dup
    //   3863: invokespecial 173	java/lang/StringBuilder:<init>	()V
    //   3866: ldc_w 534
    //   3869: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3872: aload_2
    //   3873: invokevirtual 537	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:getMessage	()Ljava/lang/String;
    //   3876: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3879: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3882: invokestatic 203	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3885: iconst_0
    //   3886: istore 9
    //   3888: goto -59 -> 3829
    //   3891: iload 8
    //   3893: ifeq -1925 -> 1968
    //   3896: aload_1
    //   3897: ldc_w 447
    //   3900: iconst_0
    //   3901: invokevirtual 398	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   3904: istore_3
    //   3905: aload_2
    //   3906: invokevirtual 419	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   3909: arraylength
    //   3910: iconst_4
    //   3911: isub
    //   3912: istore 5
    //   3914: iload 5
    //   3916: newarray byte
    //   3918: astore 13
    //   3920: aload 13
    //   3922: iconst_0
    //   3923: aload_2
    //   3924: invokevirtual 419	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   3927: iconst_4
    //   3928: iload 5
    //   3930: invokestatic 459	com/tencent/mobileqq/utils/httputils/PkgTools:copyData	([BI[BII)V
    //   3933: new 127	com/tencent/pb/signature/SigActPb$RspBody
    //   3936: dup
    //   3937: invokespecial 460	com/tencent/pb/signature/SigActPb$RspBody:<init>	()V
    //   3940: astore 16
    //   3942: aload 16
    //   3944: aload 13
    //   3946: invokevirtual 461	com/tencent/pb/signature/SigActPb$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3949: pop
    //   3950: aload 16
    //   3952: getfield 462	com/tencent/pb/signature/SigActPb$RspBody:ret	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   3955: invokevirtual 188	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   3958: istore 5
    //   3960: aload 16
    //   3962: getfield 760	com/tencent/pb/signature/SigActPb$RspBody:desc	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3965: invokevirtual 761	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   3968: ifeq +177 -> 4145
    //   3971: aload 16
    //   3973: getfield 760	com/tencent/pb/signature/SigActPb$RspBody:desc	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3976: invokevirtual 233	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   3979: astore_2
    //   3980: iload 5
    //   3982: ifne +241 -> 4223
    //   3985: aload_2
    //   3986: astore 13
    //   3988: aload 16
    //   3990: getfield 131	com/tencent/pb/signature/SigActPb$RspBody:auth_rsp	Lcom/tencent/pb/signature/SigActPb$SigauthRsp;
    //   3993: getfield 465	com/tencent/pb/signature/SigActPb$SigauthRsp:result	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3996: invokevirtual 432	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   3999: invokevirtual 433	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   4002: invokestatic 436	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   4005: astore 14
    //   4007: aload_2
    //   4008: astore 13
    //   4010: aload 14
    //   4012: invokevirtual 439	java/nio/ByteBuffer:get	()B
    //   4015: istore 5
    //   4017: iload 5
    //   4019: ifne +133 -> 4152
    //   4022: aload_2
    //   4023: astore 13
    //   4025: aload 15
    //   4027: ldc_w 441
    //   4030: aload 14
    //   4032: invokevirtual 365	java/nio/ByteBuffer:array	()[B
    //   4035: invokevirtual 445	android/os/Bundle:putByteArray	(Ljava/lang/String;[B)V
    //   4038: aload_2
    //   4039: astore 13
    //   4041: iload 8
    //   4043: istore 9
    //   4045: iload_3
    //   4046: iconst_1
    //   4047: if_icmpne +24 -> 4071
    //   4050: aload_2
    //   4051: astore 13
    //   4053: aload_0
    //   4054: aload 15
    //   4056: aload 16
    //   4058: ldc_w 763
    //   4061: invokespecial 765	com/tencent/mobileqq/richstatus/StatusServlet:a	(Landroid/os/Bundle;Lcom/tencent/pb/signature/SigActPb$RspBody;Ljava/lang/String;)V
    //   4064: iload 8
    //   4066: istore 9
    //   4068: aload_2
    //   4069: astore 13
    //   4071: iload 9
    //   4073: istore 8
    //   4075: aload 13
    //   4077: ifnull +13 -> 4090
    //   4080: aload 15
    //   4082: ldc_w 767
    //   4085: aload 13
    //   4087: invokevirtual 237	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   4090: aload 15
    //   4092: ldc_w 447
    //   4095: iload_3
    //   4096: invokevirtual 215	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   4099: invokestatic 770	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   4102: ifeq +534 -> 4636
    //   4105: ldc_w 267
    //   4108: iconst_1
    //   4109: ldc_w 772
    //   4112: iconst_3
    //   4113: anewarray 774	java/lang/Object
    //   4116: dup
    //   4117: iconst_0
    //   4118: iload 8
    //   4120: invokestatic 779	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   4123: aastore
    //   4124: dup
    //   4125: iconst_1
    //   4126: iload_3
    //   4127: invokestatic 686	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   4130: aastore
    //   4131: dup
    //   4132: iconst_2
    //   4133: aload 13
    //   4135: aastore
    //   4136: invokestatic 783	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   4139: invokestatic 277	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4142: goto +494 -> 4636
    //   4145: ldc_w 519
    //   4148: astore_2
    //   4149: goto -169 -> 3980
    //   4152: aload_2
    //   4153: astore 13
    //   4155: aload 15
    //   4157: ldc_w 544
    //   4160: iload 5
    //   4162: invokevirtual 215	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   4165: aload_2
    //   4166: astore 13
    //   4168: invokestatic 789	aqin:c	()Lcom/tencent/mobileqq/config/business/qvip/SSOErrorInfoMapConfig;
    //   4171: astore 17
    //   4173: aload_2
    //   4174: astore 13
    //   4176: aload_2
    //   4177: astore 14
    //   4179: aload_2
    //   4180: invokestatic 794	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4183: ifeq +456 -> 4639
    //   4186: aload_2
    //   4187: astore 13
    //   4189: aload 17
    //   4191: ldc_w 796
    //   4194: new 172	java/lang/StringBuilder
    //   4197: dup
    //   4198: invokespecial 173	java/lang/StringBuilder:<init>	()V
    //   4201: ldc_w 519
    //   4204: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4207: iload 5
    //   4209: invokevirtual 191	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4212: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4215: invokevirtual 802	com/tencent/mobileqq/config/business/qvip/SSOErrorInfoMapConfig:getErrorInfo	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   4218: astore 14
    //   4220: goto +419 -> 4639
    //   4223: iconst_0
    //   4224: istore 9
    //   4226: aload_2
    //   4227: astore 13
    //   4229: aload 15
    //   4231: ldc_w 553
    //   4234: iload 5
    //   4236: invokevirtual 215	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   4239: iload 5
    //   4241: ldc_w 554
    //   4244: if_icmpne +25 -> 4269
    //   4247: aload_2
    //   4248: astore 13
    //   4250: aload 15
    //   4252: ldc_w 556
    //   4255: aload 16
    //   4257: getfield 131	com/tencent/pb/signature/SigActPb$RspBody:auth_rsp	Lcom/tencent/pb/signature/SigActPb$SigauthRsp;
    //   4260: getfield 557	com/tencent/pb/signature/SigActPb$SigauthRsp:url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   4263: invokevirtual 233	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   4266: invokevirtual 237	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   4269: aload_2
    //   4270: astore 13
    //   4272: aload 16
    //   4274: getfield 131	com/tencent/pb/signature/SigActPb$RspBody:auth_rsp	Lcom/tencent/pb/signature/SigActPb$SigauthRsp;
    //   4277: getfield 560	com/tencent/pb/signature/SigActPb$SigauthRsp:authfailed_appid	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   4280: invokevirtual 561	com/tencent/mobileqq/pb/PBInt32Field:has	()Z
    //   4283: ifeq +25 -> 4308
    //   4286: aload_2
    //   4287: astore 13
    //   4289: aload 15
    //   4291: ldc_w 563
    //   4294: aload 16
    //   4296: getfield 131	com/tencent/pb/signature/SigActPb$RspBody:auth_rsp	Lcom/tencent/pb/signature/SigActPb$SigauthRsp;
    //   4299: getfield 560	com/tencent/pb/signature/SigActPb$SigauthRsp:authfailed_appid	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   4302: invokevirtual 188	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   4305: invokevirtual 215	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   4308: aload_2
    //   4309: astore 13
    //   4311: aload_0
    //   4312: aload 15
    //   4314: aload 16
    //   4316: ldc_w 804
    //   4319: invokespecial 765	com/tencent/mobileqq/richstatus/StatusServlet:a	(Landroid/os/Bundle;Lcom/tencent/pb/signature/SigActPb$RspBody;Ljava/lang/String;)V
    //   4322: aload_2
    //   4323: astore 13
    //   4325: goto -254 -> 4071
    //   4328: astore_2
    //   4329: invokestatic 168	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4332: ifeq +33 -> 4365
    //   4335: ldc_w 532
    //   4338: iconst_2
    //   4339: new 172	java/lang/StringBuilder
    //   4342: dup
    //   4343: invokespecial 173	java/lang/StringBuilder:<init>	()V
    //   4346: ldc_w 534
    //   4349: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4352: aload_2
    //   4353: invokevirtual 545	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   4356: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4359: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4362: invokestatic 203	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4365: iconst_0
    //   4366: istore 8
    //   4368: goto -293 -> 4075
    //   4371: astore_2
    //   4372: invokestatic 168	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4375: ifeq +33 -> 4408
    //   4378: ldc_w 532
    //   4381: iconst_2
    //   4382: new 172	java/lang/StringBuilder
    //   4385: dup
    //   4386: invokespecial 173	java/lang/StringBuilder:<init>	()V
    //   4389: ldc_w 534
    //   4392: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4395: aload_2
    //   4396: invokevirtual 545	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   4399: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4402: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4405: invokestatic 203	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4408: iconst_0
    //   4409: istore 8
    //   4411: goto -2443 -> 1968
    //   4414: iload 8
    //   4416: ifeq -2448 -> 1968
    //   4419: new 320	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   4422: dup
    //   4423: invokespecial 321	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   4426: astore 13
    //   4428: aload 13
    //   4430: aload_2
    //   4431: invokevirtual 419	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   4434: invokestatic 424	bgau:b	([B)[B
    //   4437: invokevirtual 425	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   4440: checkcast 320	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   4443: astore_2
    //   4444: iload 8
    //   4446: istore 9
    //   4448: aload_2
    //   4449: ifnull +55 -> 4504
    //   4452: iload 8
    //   4454: istore 9
    //   4456: aload_2
    //   4457: getfield 428	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4460: invokevirtual 429	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   4463: ifeq +41 -> 4504
    //   4466: aload_2
    //   4467: getfield 428	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4470: invokevirtual 223	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4473: ifne +44 -> 4517
    //   4476: aload_2
    //   4477: getfield 362	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   4480: invokevirtual 432	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   4483: invokevirtual 433	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   4486: invokestatic 436	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   4489: invokevirtual 439	java/nio/ByteBuffer:get	()B
    //   4492: istore_3
    //   4493: iload_3
    //   4494: ifne +17 -> 4511
    //   4497: iconst_1
    //   4498: istore 8
    //   4500: iload 8
    //   4502: istore 9
    //   4504: iload 9
    //   4506: istore 8
    //   4508: goto -2540 -> 1968
    //   4511: iconst_0
    //   4512: istore 8
    //   4514: goto -14 -> 4500
    //   4517: iconst_0
    //   4518: istore 9
    //   4520: goto -16 -> 4504
    //   4523: astore_2
    //   4524: invokestatic 168	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4527: ifeq +33 -> 4560
    //   4530: ldc_w 532
    //   4533: iconst_2
    //   4534: new 172	java/lang/StringBuilder
    //   4537: dup
    //   4538: invokespecial 173	java/lang/StringBuilder:<init>	()V
    //   4541: ldc_w 534
    //   4544: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4547: aload_2
    //   4548: invokevirtual 537	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:getMessage	()Ljava/lang/String;
    //   4551: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4554: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4557: invokestatic 203	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4560: iconst_0
    //   4561: istore 9
    //   4563: goto -59 -> 4504
    //   4566: goto -3143 -> 1423
    //   4569: goto -3146 -> 1423
    //   4572: goto -3135 -> 1437
    //   4575: goto -4224 -> 351
    //   4578: iload_3
    //   4579: ifeq -2731 -> 1848
    //   4582: iconst_0
    //   4583: istore 8
    //   4585: iload 9
    //   4587: istore 10
    //   4589: iload 8
    //   4591: istore 9
    //   4593: goto -3065 -> 1528
    //   4596: iload_3
    //   4597: ifeq -2518 -> 2079
    //   4600: iconst_0
    //   4601: istore 8
    //   4603: iload 9
    //   4605: istore 10
    //   4607: iload 8
    //   4609: istore 9
    //   4611: goto -2549 -> 2062
    //   4614: iconst_0
    //   4615: istore 9
    //   4617: goto -21 -> 4596
    //   4620: iload_3
    //   4621: iconst_1
    //   4622: iadd
    //   4623: istore_3
    //   4624: goto -2299 -> 2325
    //   4627: iconst_0
    //   4628: istore 9
    //   4630: goto -2336 -> 2294
    //   4633: goto -2665 -> 1968
    //   4636: goto -2668 -> 1968
    //   4639: iconst_0
    //   4640: istore 8
    //   4642: aload 14
    //   4644: astore_2
    //   4645: goto -607 -> 4038
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	4648	0	this	StatusServlet
    //   0	4648	1	paramIntent	Intent
    //   0	4648	2	paramFromServiceMsg	com.tencent.qphone.base.remote.FromServiceMsg
    //   118	4506	3	i	int
    //   8	2083	4	j	int
    //   501	3744	5	k	int
    //   525	2515	6	m	int
    //   603	1809	7	n	int
    //   14	4627	8	bool1	boolean
    //   46	4583	9	bool2	boolean
    //   1533	3073	10	bool3	boolean
    //   482	2203	11	l	long
    //   37	491	13	localObject1	Object
    //   718	26	13	localInvalidProtocolBufferMicroException1	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
    //   806	464	13	localException1	Exception
    //   1283	25	13	localException2	Exception
    //   1352	419	13	localObject2	Object
    //   1797	26	13	localInvalidProtocolBufferMicroException2	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
    //   1999	2430	13	localObject3	Object
    //   227	4416	14	localObject4	Object
    //   23	4290	15	localBundle	Bundle
    //   432	3883	16	localObject5	Object
    //   565	3625	17	localObject6	Object
    //   582	1124	18	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   69	86	718	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   99	119	718	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   123	145	718	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   149	178	718	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   633	674	718	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   683	715	718	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   216	267	806	java/lang/Exception
    //   271	296	806	java/lang/Exception
    //   300	329	806	java/lang/Exception
    //   794	803	806	java/lang/Exception
    //   851	899	806	java/lang/Exception
    //   906	925	806	java/lang/Exception
    //   925	958	806	java/lang/Exception
    //   958	1023	806	java/lang/Exception
    //   1028	1150	806	java/lang/Exception
    //   1150	1184	806	java/lang/Exception
    //   361	517	1283	java/lang/Exception
    //   520	550	1283	java/lang/Exception
    //   558	619	1283	java/lang/Exception
    //   1222	1269	1283	java/lang/Exception
    //   1269	1280	1283	java/lang/Exception
    //   1553	1605	1283	java/lang/Exception
    //   1610	1649	1283	java/lang/Exception
    //   1649	1671	1283	java/lang/Exception
    //   1671	1693	1283	java/lang/Exception
    //   1698	1717	1283	java/lang/Exception
    //   1720	1739	1283	java/lang/Exception
    //   1752	1778	1283	java/lang/Exception
    //   1354	1371	1797	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1376	1416	1797	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1449	1522	1879	java/lang/Exception
    //   1528	1538	1879	java/lang/Exception
    //   1862	1872	1879	java/lang/Exception
    //   1983	2056	2110	java/lang/Exception
    //   2062	2072	2110	java/lang/Exception
    //   2093	2103	2110	java/lang/Exception
    //   2138	2291	2463	java/lang/Exception
    //   2294	2323	2463	java/lang/Exception
    //   2331	2392	2463	java/lang/Exception
    //   2402	2449	2463	java/lang/Exception
    //   2449	2460	2463	java/lang/Exception
    //   2491	2543	2463	java/lang/Exception
    //   2548	2587	2463	java/lang/Exception
    //   2587	2608	2463	java/lang/Exception
    //   2608	2630	2463	java/lang/Exception
    //   2635	2654	2463	java/lang/Exception
    //   2657	2675	2463	java/lang/Exception
    //   2680	2705	2463	java/lang/Exception
    //   2708	2805	2814	java/lang/Exception
    //   2835	2851	2960	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   2877	2896	3151	java/lang/Exception
    //   2900	2915	3151	java/lang/Exception
    //   2923	2953	3151	java/lang/Exception
    //   3010	3034	3151	java/lang/Exception
    //   3042	3085	3151	java/lang/Exception
    //   3097	3107	3151	java/lang/Exception
    //   3110	3130	3151	java/lang/Exception
    //   3139	3148	3151	java/lang/Exception
    //   3728	3744	3848	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3756	3825	3848	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3988	4007	4328	java/lang/Exception
    //   4010	4017	4328	java/lang/Exception
    //   4025	4038	4328	java/lang/Exception
    //   4053	4064	4328	java/lang/Exception
    //   4155	4165	4328	java/lang/Exception
    //   4168	4173	4328	java/lang/Exception
    //   4179	4186	4328	java/lang/Exception
    //   4189	4220	4328	java/lang/Exception
    //   4229	4239	4328	java/lang/Exception
    //   4250	4269	4328	java/lang/Exception
    //   4272	4286	4328	java/lang/Exception
    //   4289	4308	4328	java/lang/Exception
    //   4311	4322	4328	java/lang/Exception
    //   3896	3980	4371	java/lang/Exception
    //   4080	4090	4371	java/lang/Exception
    //   4090	4142	4371	java/lang/Exception
    //   4329	4365	4371	java/lang/Exception
    //   4428	4444	4523	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   4456	4493	4523	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
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
      localObject1 = ((amsw)((AppInterface)localObject1).getManager(51)).b(((AppInterface)localObject1).getCurrentAccountUin());
      if (localObject1 != null) {
        if (((Card)localObject1).shGender != 0) {
          break;
        }
      }
      break;
    }
    label1052:
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
            break label1052;
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
      paramIntent.mqqver.set("8.4.8");
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