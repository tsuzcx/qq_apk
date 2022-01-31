package com.tencent.mobileqq.richstatus;

import PersonalState.BusiReqHead;
import PersonalState.ReqGetHotState;
import PersonalState.ReqGetSameStateList;
import PersonalState.stRishState;
import android.content.Intent;
import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
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
import com.tencent.pb.signature.SigActPb.SigauthReq;
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
    SosoInterface.a(60000L, StatusServlet.class.getSimpleName());
    Object localObject1 = SosoInterface.a();
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
  
  private byte[] a(List paramList, byte paramByte)
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
        break label154;
      }
    }
    label154:
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
    //   1: ldc 148
    //   3: iconst_0
    //   4: invokevirtual 258	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   7: istore 5
    //   9: aload_2
    //   10: invokevirtual 263	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   13: istore 8
    //   15: new 265	android/os/Bundle
    //   18: dup
    //   19: invokespecial 266	android/os/Bundle:<init>	()V
    //   22: astore 14
    //   24: aload_0
    //   25: invokevirtual 270	com/tencent/mobileqq/richstatus/StatusServlet:getAppRuntime	()Lmqq/app/AppRuntime;
    //   28: bipush 14
    //   30: invokevirtual 276	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   33: checkcast 278	com/tencent/mobileqq/richstatus/StatusManager
    //   36: astore 13
    //   38: aload 13
    //   40: ifnonnull +1814 -> 1854
    //   43: iload 8
    //   45: istore 9
    //   47: iload 5
    //   49: bipush 7
    //   51: if_icmpne +152 -> 203
    //   54: iload 8
    //   56: ifeq +697 -> 753
    //   59: new 173	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   62: dup
    //   63: invokespecial 174	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   66: astore 13
    //   68: aload 13
    //   70: aload_2
    //   71: invokevirtual 281	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   74: invokestatic 286	com/tencent/mobileqq/utils/WupUtil:b	([B)[B
    //   77: invokevirtual 290	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   80: checkcast 173	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   83: astore 13
    //   85: iload 8
    //   87: istore 9
    //   89: aload 13
    //   91: ifnull +90 -> 181
    //   94: iload 8
    //   96: istore 9
    //   98: aload 13
    //   100: getfield 293	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   103: invokevirtual 296	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   106: ifeq +75 -> 181
    //   109: aload 13
    //   111: getfield 293	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   114: invokevirtual 299	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   117: istore_3
    //   118: iload_3
    //   119: ifne +551 -> 670
    //   122: aload 13
    //   124: getfield 220	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   127: invokevirtual 302	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   130: invokevirtual 303	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   133: invokestatic 306	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   136: astore 13
    //   138: aload 13
    //   140: invokevirtual 309	java/nio/ByteBuffer:get	()B
    //   143: istore_3
    //   144: iload_3
    //   145: ifne +487 -> 632
    //   148: aload 14
    //   150: ldc_w 311
    //   153: aload 13
    //   155: invokevirtual 224	java/nio/ByteBuffer:array	()[B
    //   158: invokevirtual 315	android/os/Bundle:putByteArray	(Ljava/lang/String;[B)V
    //   161: aload 14
    //   163: ldc_w 317
    //   166: aload_1
    //   167: ldc_w 317
    //   170: iconst_0
    //   171: invokevirtual 258	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   174: invokevirtual 320	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   177: iload 8
    //   179: istore 9
    //   181: iload 9
    //   183: istore 8
    //   185: aload_0
    //   186: aload_1
    //   187: iload 5
    //   189: iload 8
    //   191: aload 14
    //   193: ldc_w 322
    //   196: invokevirtual 326	com/tencent/mobileqq/richstatus/StatusServlet:notifyObserver	(Landroid/content/Intent;IZLandroid/os/Bundle;Ljava/lang/Class;)V
    //   199: iload 8
    //   201: istore 9
    //   203: iload 5
    //   205: bipush 9
    //   207: if_icmpne +4204 -> 4411
    //   210: iload 9
    //   212: ifeq +926 -> 1138
    //   215: aload_2
    //   216: invokevirtual 281	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   219: arraylength
    //   220: iconst_4
    //   221: isub
    //   222: istore_3
    //   223: iload_3
    //   224: newarray byte
    //   226: astore 15
    //   228: aload 15
    //   230: iconst_0
    //   231: aload_2
    //   232: invokevirtual 281	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   235: iconst_4
    //   236: iload_3
    //   237: invokestatic 331	com/tencent/mobileqq/utils/httputils/PkgTools:a	([BI[BII)V
    //   240: new 333	com/tencent/pb/signature/SigActPb$RspBody
    //   243: dup
    //   244: invokespecial 334	com/tencent/pb/signature/SigActPb$RspBody:<init>	()V
    //   247: astore 13
    //   249: aload 13
    //   251: aload 15
    //   253: invokevirtual 335	com/tencent/pb/signature/SigActPb$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   256: pop
    //   257: aload 13
    //   259: getfield 339	com/tencent/pb/signature/SigActPb$RspBody:ret	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   262: invokevirtual 342	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   265: istore_3
    //   266: iload_3
    //   267: ifne +565 -> 832
    //   270: aload 13
    //   272: getfield 346	com/tencent/pb/signature/SigActPb$RspBody:auth_rsp	Lcom/tencent/pb/signature/SigActPb$SigauthRsp;
    //   275: getfield 351	com/tencent/pb/signature/SigActPb$SigauthRsp:result	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   278: invokevirtual 302	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   281: invokevirtual 303	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   284: invokestatic 306	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   287: astore 13
    //   289: aload 13
    //   291: invokevirtual 309	java/nio/ByteBuffer:get	()B
    //   294: istore_3
    //   295: iload_3
    //   296: ifne +476 -> 772
    //   299: aload 14
    //   301: ldc_w 311
    //   304: aload 13
    //   306: invokevirtual 224	java/nio/ByteBuffer:array	()[B
    //   309: invokevirtual 315	android/os/Bundle:putByteArray	(Ljava/lang/String;[B)V
    //   312: aload 14
    //   314: ldc_w 317
    //   317: aload_1
    //   318: ldc_w 317
    //   321: iconst_0
    //   322: invokevirtual 258	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   325: invokevirtual 320	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   328: iload 9
    //   330: istore 8
    //   332: iload 8
    //   334: istore 9
    //   336: aload_0
    //   337: aload_1
    //   338: iload 5
    //   340: iload 9
    //   342: aload 14
    //   344: ldc_w 322
    //   347: invokevirtual 326	com/tencent/mobileqq/richstatus/StatusServlet:notifyObserver	(Landroid/content/Intent;IZLandroid/os/Bundle;Ljava/lang/Class;)V
    //   350: iload 9
    //   352: istore 8
    //   354: iload 5
    //   356: iconst_4
    //   357: if_icmpne +917 -> 1274
    //   360: new 353	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory
    //   363: dup
    //   364: invokespecial 354	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:<init>	()V
    //   367: astore 13
    //   369: aload 13
    //   371: aload_1
    //   372: ldc_w 356
    //   375: iconst_0
    //   376: invokevirtual 258	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   379: putfield 359	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:startTime	I
    //   382: aload 13
    //   384: aload_1
    //   385: ldc_w 361
    //   388: ldc_w 362
    //   391: invokevirtual 258	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   394: putfield 365	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:endTime	I
    //   397: aload 13
    //   399: iconst_0
    //   400: putfield 369	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:isAddFromCard	Z
    //   403: aload 14
    //   405: ldc_w 371
    //   408: aload 13
    //   410: invokevirtual 375	android/os/Bundle:putSerializable	(Ljava/lang/String;Ljava/io/Serializable;)V
    //   413: aload_2
    //   414: invokevirtual 281	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   417: invokestatic 306	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   420: astore 15
    //   422: aload 15
    //   424: invokevirtual 378	java/nio/ByteBuffer:getInt	()I
    //   427: iconst_4
    //   428: isub
    //   429: newarray byte
    //   431: astore 16
    //   433: aload 15
    //   435: aload 16
    //   437: invokevirtual 380	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   440: pop
    //   441: new 173	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   444: dup
    //   445: invokespecial 174	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   448: aload 16
    //   450: invokevirtual 290	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   453: checkcast 173	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   456: getfield 220	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   459: invokevirtual 302	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   462: invokevirtual 303	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   465: invokestatic 306	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   468: astore 16
    //   470: aload 16
    //   472: invokevirtual 309	java/nio/ByteBuffer:get	()B
    //   475: pop
    //   476: aload 16
    //   478: invokevirtual 384	java/nio/ByteBuffer:getLong	()J
    //   481: lstore 11
    //   483: aload 16
    //   485: invokevirtual 309	java/nio/ByteBuffer:get	()B
    //   488: pop
    //   489: aload 16
    //   491: invokevirtual 378	java/nio/ByteBuffer:getInt	()I
    //   494: pop
    //   495: aload 16
    //   497: invokevirtual 378	java/nio/ByteBuffer:getInt	()I
    //   500: istore 4
    //   502: aload 16
    //   504: invokevirtual 378	java/nio/ByteBuffer:getInt	()I
    //   507: pop
    //   508: aload 16
    //   510: invokevirtual 309	java/nio/ByteBuffer:get	()B
    //   513: ifeq +644 -> 1157
    //   516: iconst_1
    //   517: istore 8
    //   519: aload 16
    //   521: invokevirtual 388	java/nio/ByteBuffer:getShort	()S
    //   524: istore 6
    //   526: aload 13
    //   528: new 55	java/util/ArrayList
    //   531: dup
    //   532: iload 6
    //   534: invokespecial 390	java/util/ArrayList:<init>	(I)V
    //   537: putfield 393	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:richStatus	Ljava/util/ArrayList;
    //   540: aload_0
    //   541: invokevirtual 270	com/tencent/mobileqq/richstatus/StatusServlet:getAppRuntime	()Lmqq/app/AppRuntime;
    //   544: checkcast 139	com/tencent/mobileqq/app/QQAppInterface
    //   547: astore 15
    //   549: iconst_0
    //   550: istore_3
    //   551: iload_3
    //   552: iload 6
    //   554: if_icmpge +939 -> 1493
    //   557: aload 16
    //   559: invokevirtual 388	java/nio/ByteBuffer:getShort	()S
    //   562: newarray byte
    //   564: astore 17
    //   566: aload 16
    //   568: aload 17
    //   570: invokevirtual 380	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   573: pop
    //   574: aload 16
    //   576: invokevirtual 388	java/nio/ByteBuffer:getShort	()S
    //   579: newarray byte
    //   581: astore 18
    //   583: aload 16
    //   585: aload 18
    //   587: invokevirtual 380	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   590: pop
    //   591: aload 16
    //   593: invokevirtual 378	java/nio/ByteBuffer:getInt	()I
    //   596: pop
    //   597: aload 16
    //   599: invokevirtual 378	java/nio/ByteBuffer:getInt	()I
    //   602: istore 7
    //   604: aload 16
    //   606: aload 16
    //   608: invokevirtual 396	java/nio/ByteBuffer:position	()I
    //   611: bipush 8
    //   613: iadd
    //   614: invokevirtual 399	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   617: pop
    //   618: iload 7
    //   620: iload 4
    //   622: if_icmple +541 -> 1163
    //   625: iload_3
    //   626: iconst_1
    //   627: iadd
    //   628: istore_3
    //   629: goto -78 -> 551
    //   632: aconst_null
    //   633: ldc_w 401
    //   636: ldc_w 403
    //   639: new 405	java/lang/StringBuilder
    //   642: dup
    //   643: invokespecial 406	java/lang/StringBuilder:<init>	()V
    //   646: ldc_w 408
    //   649: invokevirtual 412	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   652: iload_3
    //   653: invokevirtual 415	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   656: invokevirtual 418	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   659: aconst_null
    //   660: fconst_0
    //   661: invokestatic 423	com/tencent/mobileqq/vas/VasMonitorHandler:a	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;F)V
    //   664: iconst_0
    //   665: istore 8
    //   667: goto -490 -> 177
    //   670: iconst_0
    //   671: istore 9
    //   673: aconst_null
    //   674: ldc_w 401
    //   677: ldc_w 425
    //   680: new 405	java/lang/StringBuilder
    //   683: dup
    //   684: invokespecial 406	java/lang/StringBuilder:<init>	()V
    //   687: ldc_w 408
    //   690: invokevirtual 412	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   693: iload_3
    //   694: invokevirtual 415	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   697: invokevirtual 418	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   700: aconst_null
    //   701: fconst_0
    //   702: invokestatic 423	com/tencent/mobileqq/vas/VasMonitorHandler:a	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;F)V
    //   705: goto -524 -> 181
    //   708: astore 13
    //   710: invokestatic 127	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   713: ifeq +34 -> 747
    //   716: ldc_w 427
    //   719: iconst_2
    //   720: new 405	java/lang/StringBuilder
    //   723: dup
    //   724: invokespecial 406	java/lang/StringBuilder:<init>	()V
    //   727: ldc_w 429
    //   730: invokevirtual 412	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   733: aload 13
    //   735: invokevirtual 432	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:getMessage	()Ljava/lang/String;
    //   738: invokevirtual 412	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   741: invokevirtual 418	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   744: invokestatic 135	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   747: iconst_0
    //   748: istore 9
    //   750: goto -569 -> 181
    //   753: aconst_null
    //   754: ldc_w 401
    //   757: ldc_w 434
    //   760: aload_2
    //   761: invokevirtual 437	com/tencent/qphone/base/remote/FromServiceMsg:getBusinessFailMsg	()Ljava/lang/String;
    //   764: aconst_null
    //   765: fconst_0
    //   766: invokestatic 423	com/tencent/mobileqq/vas/VasMonitorHandler:a	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;F)V
    //   769: goto -584 -> 185
    //   772: iconst_0
    //   773: istore 8
    //   775: aload 14
    //   777: ldc_w 439
    //   780: iload_3
    //   781: invokevirtual 320	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   784: goto -452 -> 332
    //   787: astore 13
    //   789: invokestatic 127	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   792: ifeq +34 -> 826
    //   795: ldc_w 427
    //   798: iconst_2
    //   799: new 405	java/lang/StringBuilder
    //   802: dup
    //   803: invokespecial 406	java/lang/StringBuilder:<init>	()V
    //   806: ldc_w 429
    //   809: invokevirtual 412	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   812: aload 13
    //   814: invokevirtual 440	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   817: invokevirtual 412	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   820: invokevirtual 418	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   823: invokestatic 135	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   826: iconst_0
    //   827: istore 9
    //   829: goto -493 -> 336
    //   832: aconst_null
    //   833: ldc_w 442
    //   836: ldc_w 444
    //   839: new 405	java/lang/StringBuilder
    //   842: dup
    //   843: invokespecial 406	java/lang/StringBuilder:<init>	()V
    //   846: ldc_w 408
    //   849: invokevirtual 412	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   852: iload_3
    //   853: invokevirtual 415	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   856: invokevirtual 418	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   859: aconst_null
    //   860: fconst_0
    //   861: invokestatic 423	com/tencent/mobileqq/vas/VasMonitorHandler:a	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;F)V
    //   864: aload 14
    //   866: ldc_w 446
    //   869: iload_3
    //   870: invokevirtual 320	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   873: iload_3
    //   874: ldc_w 447
    //   877: if_icmpne +22 -> 899
    //   880: aload 14
    //   882: ldc_w 449
    //   885: aload 13
    //   887: getfield 346	com/tencent/pb/signature/SigActPb$RspBody:auth_rsp	Lcom/tencent/pb/signature/SigActPb$SigauthRsp;
    //   890: getfield 453	com/tencent/pb/signature/SigActPb$SigauthRsp:url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   893: invokevirtual 457	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   896: invokevirtual 461	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   899: aload 13
    //   901: getfield 346	com/tencent/pb/signature/SigActPb$RspBody:auth_rsp	Lcom/tencent/pb/signature/SigActPb$SigauthRsp;
    //   904: getfield 465	com/tencent/pb/signature/SigActPb$SigauthRsp:tips_info	Lcom/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo;
    //   907: invokevirtual 468	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo:has	()Z
    //   910: ifeq +222 -> 1132
    //   913: new 467	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo
    //   916: dup
    //   917: invokespecial 469	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo:<init>	()V
    //   920: astore 15
    //   922: aload 15
    //   924: aload 13
    //   926: getfield 346	com/tencent/pb/signature/SigActPb$RspBody:auth_rsp	Lcom/tencent/pb/signature/SigActPb$SigauthRsp;
    //   929: getfield 465	com/tencent/pb/signature/SigActPb$SigauthRsp:tips_info	Lcom/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo;
    //   932: invokevirtual 472	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   935: checkcast 467	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo
    //   938: invokevirtual 473	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo:toByteArray	()[B
    //   941: invokevirtual 474	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   944: pop
    //   945: aload 15
    //   947: getfield 478	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo:valid	Lcom/tencent/mobileqq/pb/PBBoolField;
    //   950: invokevirtual 482	com/tencent/mobileqq/pb/PBBoolField:get	()Z
    //   953: istore 8
    //   955: aload 14
    //   957: ldc_w 483
    //   960: iload 8
    //   962: invokevirtual 487	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   965: iload 8
    //   967: ifeq +131 -> 1098
    //   970: aload 14
    //   972: ldc_w 489
    //   975: aload 15
    //   977: getfield 491	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo:type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   980: invokevirtual 299	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   983: invokevirtual 320	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   986: aload 14
    //   988: ldc_w 493
    //   991: aload 15
    //   993: getfield 496	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo:title_wording	Lcom/tencent/mobileqq/pb/PBStringField;
    //   996: invokevirtual 457	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   999: invokevirtual 461	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1002: aload 14
    //   1004: ldc_w 498
    //   1007: aload 15
    //   1009: getfield 500	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo:wording	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1012: invokevirtual 457	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1015: invokevirtual 461	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1018: aload 14
    //   1020: ldc_w 502
    //   1023: aload 15
    //   1025: getfield 505	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo:right_btn_wording	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1028: invokevirtual 457	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1031: invokevirtual 461	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1034: aload 14
    //   1036: ldc_w 507
    //   1039: aload 15
    //   1041: getfield 510	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo:left_btn_wording	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1044: invokevirtual 457	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1047: invokevirtual 461	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1050: aload 14
    //   1052: ldc_w 512
    //   1055: aload 15
    //   1057: getfield 515	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo:vip_type	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1060: invokevirtual 457	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1063: invokevirtual 461	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1066: aload 14
    //   1068: ldc_w 517
    //   1071: aload 15
    //   1073: getfield 520	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo:vip_month	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1076: invokevirtual 299	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1079: invokevirtual 320	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1082: aload 14
    //   1084: ldc_w 521
    //   1087: aload 15
    //   1089: getfield 522	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo:url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1092: invokevirtual 457	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1095: invokevirtual 461	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1098: invokestatic 127	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1101: ifeq +31 -> 1132
    //   1104: ldc_w 524
    //   1107: iconst_2
    //   1108: new 405	java/lang/StringBuilder
    //   1111: dup
    //   1112: invokespecial 406	java/lang/StringBuilder:<init>	()V
    //   1115: ldc_w 526
    //   1118: invokevirtual 412	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1121: aload 14
    //   1123: invokevirtual 529	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1126: invokevirtual 418	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1129: invokestatic 532	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1132: iconst_0
    //   1133: istore 8
    //   1135: goto -803 -> 332
    //   1138: aconst_null
    //   1139: ldc_w 442
    //   1142: ldc_w 534
    //   1145: aload_2
    //   1146: invokevirtual 437	com/tencent/qphone/base/remote/FromServiceMsg:getBusinessFailMsg	()Ljava/lang/String;
    //   1149: aconst_null
    //   1150: fconst_0
    //   1151: invokestatic 423	com/tencent/mobileqq/vas/VasMonitorHandler:a	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;F)V
    //   1154: goto -818 -> 336
    //   1157: iconst_0
    //   1158: istore 8
    //   1160: goto -641 -> 519
    //   1163: aload 18
    //   1165: invokestatic 540	com/tencent/mobileqq/richstatus/RichStatus:parseStatus	([B)Lcom/tencent/mobileqq/richstatus/RichStatus;
    //   1168: astore 18
    //   1170: aload 18
    //   1172: iload 7
    //   1174: i2l
    //   1175: putfield 543	com/tencent/mobileqq/richstatus/RichStatus:time	J
    //   1178: aload 18
    //   1180: aload 17
    //   1182: putfield 546	com/tencent/mobileqq/richstatus/RichStatus:key	[B
    //   1185: aload 18
    //   1187: getfield 546	com/tencent/mobileqq/richstatus/RichStatus:key	[B
    //   1190: ifnull +20 -> 1210
    //   1193: aload 18
    //   1195: new 548	java/lang/String
    //   1198: dup
    //   1199: aload 18
    //   1201: getfield 546	com/tencent/mobileqq/richstatus/RichStatus:key	[B
    //   1204: invokespecial 551	java/lang/String:<init>	([B)V
    //   1207: putfield 555	com/tencent/mobileqq/richstatus/RichStatus:feedsId	Ljava/lang/String;
    //   1210: aload 13
    //   1212: getfield 393	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:richStatus	Ljava/util/ArrayList;
    //   1215: aload 18
    //   1217: invokevirtual 93	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1220: pop
    //   1221: goto -596 -> 625
    //   1224: astore 13
    //   1226: iconst_0
    //   1227: istore 9
    //   1229: aload 13
    //   1231: invokevirtual 558	java/lang/Exception:printStackTrace	()V
    //   1234: iload 9
    //   1236: istore 8
    //   1238: invokestatic 127	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1241: ifeq +19 -> 1260
    //   1244: ldc_w 427
    //   1247: iconst_2
    //   1248: aload 13
    //   1250: invokevirtual 440	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1253: invokestatic 561	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1256: iload 9
    //   1258: istore 8
    //   1260: aload_0
    //   1261: aload_1
    //   1262: iload 5
    //   1264: iload 8
    //   1266: aload 14
    //   1268: ldc_w 322
    //   1271: invokevirtual 326	com/tencent/mobileqq/richstatus/StatusServlet:notifyObserver	(Landroid/content/Intent;IZLandroid/os/Bundle;Ljava/lang/Class;)V
    //   1274: iload 5
    //   1276: bipush 8
    //   1278: if_icmpne +3130 -> 4408
    //   1281: iload 8
    //   1283: ifeq +3122 -> 4405
    //   1286: new 173	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   1289: dup
    //   1290: invokespecial 174	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   1293: astore 13
    //   1295: aload 13
    //   1297: aload_2
    //   1298: invokevirtual 281	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   1301: invokestatic 286	com/tencent/mobileqq/utils/WupUtil:b	([B)[B
    //   1304: invokevirtual 290	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1307: checkcast 173	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   1310: astore 13
    //   1312: aload 13
    //   1314: ifnull +3088 -> 4402
    //   1317: aload 13
    //   1319: getfield 293	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1322: invokevirtual 296	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   1325: ifeq +3077 -> 4402
    //   1328: aload 13
    //   1330: getfield 293	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1333: invokevirtual 299	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1336: ifne +395 -> 1731
    //   1339: aload 13
    //   1341: getfield 220	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1344: invokevirtual 302	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1347: invokevirtual 303	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   1350: invokestatic 306	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   1353: invokevirtual 309	java/nio/ByteBuffer:get	()B
    //   1356: istore_3
    //   1357: iload_3
    //   1358: ifne +367 -> 1725
    //   1361: iconst_1
    //   1362: istore 8
    //   1364: aload_0
    //   1365: aload_1
    //   1366: iload 5
    //   1368: iload 8
    //   1370: aload 14
    //   1372: ldc_w 322
    //   1375: invokevirtual 326	com/tencent/mobileqq/richstatus/StatusServlet:notifyObserver	(Landroid/content/Intent;IZLandroid/os/Bundle;Ljava/lang/Class;)V
    //   1378: iload 5
    //   1380: iconst_1
    //   1381: if_icmpeq +9 -> 1390
    //   1384: iload 5
    //   1386: iconst_2
    //   1387: if_icmpne +105 -> 1492
    //   1390: aload_2
    //   1391: invokevirtual 281	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   1394: invokestatic 306	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   1397: astore_2
    //   1398: aload_2
    //   1399: invokevirtual 378	java/nio/ByteBuffer:getInt	()I
    //   1402: iconst_4
    //   1403: isub
    //   1404: newarray byte
    //   1406: astore 13
    //   1408: aload_2
    //   1409: aload 13
    //   1411: invokevirtual 380	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   1414: pop
    //   1415: new 173	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   1418: dup
    //   1419: invokespecial 174	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   1422: aload 13
    //   1424: invokevirtual 290	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1427: checkcast 173	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   1430: getfield 220	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1433: invokevirtual 302	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1436: invokevirtual 303	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   1439: invokestatic 306	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   1442: astore_2
    //   1443: aload_2
    //   1444: invokevirtual 309	java/nio/ByteBuffer:get	()B
    //   1447: istore_3
    //   1448: aload_2
    //   1449: invokevirtual 378	java/nio/ByteBuffer:getInt	()I
    //   1452: i2l
    //   1453: lstore 11
    //   1455: aload_2
    //   1456: invokevirtual 309	java/nio/ByteBuffer:get	()B
    //   1459: iconst_1
    //   1460: if_icmpne +322 -> 1782
    //   1463: iconst_1
    //   1464: istore 9
    //   1466: goto +2948 -> 4414
    //   1469: aload 14
    //   1471: ldc 167
    //   1473: iload 10
    //   1475: invokevirtual 487	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   1478: aload_0
    //   1479: aload_1
    //   1480: iload 5
    //   1482: iload 9
    //   1484: aload 14
    //   1486: ldc_w 322
    //   1489: invokevirtual 326	com/tencent/mobileqq/richstatus/StatusServlet:notifyObserver	(Landroid/content/Intent;IZLandroid/os/Bundle;Ljava/lang/Class;)V
    //   1492: return
    //   1493: aload 13
    //   1495: getfield 393	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:richStatus	Ljava/util/ArrayList;
    //   1498: invokevirtual 564	java/util/ArrayList:isEmpty	()Z
    //   1501: ifeq +88 -> 1589
    //   1504: aload 13
    //   1506: getfield 359	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:startTime	I
    //   1509: ifne +80 -> 1589
    //   1512: aload 13
    //   1514: getfield 365	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:endTime	I
    //   1517: ldc_w 362
    //   1520: if_icmpne +69 -> 1589
    //   1523: aload_0
    //   1524: invokevirtual 270	com/tencent/mobileqq/richstatus/StatusServlet:getAppRuntime	()Lmqq/app/AppRuntime;
    //   1527: bipush 50
    //   1529: invokevirtual 276	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   1532: checkcast 566	com/tencent/mobileqq/app/FriendsManager
    //   1535: lload 11
    //   1537: invokestatic 570	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1540: invokevirtual 573	com/tencent/mobileqq/app/FriendsManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   1543: astore 16
    //   1545: aload 16
    //   1547: ifnull +42 -> 1589
    //   1550: aload 16
    //   1552: invokevirtual 579	com/tencent/mobileqq/data/Card:getRichStatus	()Lcom/tencent/mobileqq/richstatus/RichStatus;
    //   1555: ifnull +34 -> 1589
    //   1558: aload 16
    //   1560: invokevirtual 579	com/tencent/mobileqq/data/Card:getRichStatus	()Lcom/tencent/mobileqq/richstatus/RichStatus;
    //   1563: invokevirtual 580	com/tencent/mobileqq/richstatus/RichStatus:isEmpty	()Z
    //   1566: ifne +23 -> 1589
    //   1569: aload 13
    //   1571: getfield 393	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:richStatus	Ljava/util/ArrayList;
    //   1574: aload 16
    //   1576: invokevirtual 579	com/tencent/mobileqq/data/Card:getRichStatus	()Lcom/tencent/mobileqq/richstatus/RichStatus;
    //   1579: invokevirtual 93	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1582: pop
    //   1583: aload 13
    //   1585: iconst_1
    //   1586: putfield 369	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:isAddFromCard	Z
    //   1589: aload 15
    //   1591: bipush 41
    //   1593: invokevirtual 583	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   1596: checkcast 585	com/tencent/mobileqq/app/SignatureHandler
    //   1599: astore 16
    //   1601: aload 13
    //   1603: getfield 393	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:richStatus	Ljava/util/ArrayList;
    //   1606: invokevirtual 64	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   1609: astore 17
    //   1611: aload 17
    //   1613: invokeinterface 70 1 0
    //   1618: ifeq +42 -> 1660
    //   1621: aload 17
    //   1623: invokeinterface 74 1 0
    //   1628: checkcast 536	com/tencent/mobileqq/richstatus/RichStatus
    //   1631: astore 18
    //   1633: aload 16
    //   1635: ifnull -24 -> 1611
    //   1638: aload 16
    //   1640: lload 11
    //   1642: invokestatic 570	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1645: aload 18
    //   1647: getfield 555	com/tencent/mobileqq/richstatus/RichStatus:feedsId	Ljava/lang/String;
    //   1650: sipush 255
    //   1653: iconst_1
    //   1654: invokevirtual 588	com/tencent/mobileqq/app/SignatureHandler:a	(Ljava/lang/String;Ljava/lang/String;IZ)V
    //   1657: goto -46 -> 1611
    //   1660: aload 13
    //   1662: iload 8
    //   1664: putfield 591	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:over	Z
    //   1667: aload 15
    //   1669: bipush 57
    //   1671: invokevirtual 592	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1674: checkcast 594	com/tencent/mobileqq/app/SignatureManager
    //   1677: astore 16
    //   1679: iload 9
    //   1681: istore 8
    //   1683: aload 16
    //   1685: ifnull -425 -> 1260
    //   1688: iload 9
    //   1690: istore 8
    //   1692: aload 15
    //   1694: invokevirtual 157	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1697: lload 11
    //   1699: invokestatic 598	java/lang/Long:toString	(J)Ljava/lang/String;
    //   1702: invokevirtual 601	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1705: ifeq -445 -> 1260
    //   1708: aload 16
    //   1710: aload 13
    //   1712: getfield 393	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:richStatus	Ljava/util/ArrayList;
    //   1715: invokevirtual 604	com/tencent/mobileqq/app/SignatureManager:a	(Ljava/util/List;)V
    //   1718: iload 9
    //   1720: istore 8
    //   1722: goto -462 -> 1260
    //   1725: iconst_0
    //   1726: istore 8
    //   1728: goto -364 -> 1364
    //   1731: iconst_0
    //   1732: istore 8
    //   1734: goto -370 -> 1364
    //   1737: astore 13
    //   1739: invokestatic 127	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1742: ifeq +34 -> 1776
    //   1745: ldc_w 427
    //   1748: iconst_2
    //   1749: new 405	java/lang/StringBuilder
    //   1752: dup
    //   1753: invokespecial 406	java/lang/StringBuilder:<init>	()V
    //   1756: ldc_w 429
    //   1759: invokevirtual 412	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1762: aload 13
    //   1764: invokevirtual 432	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:getMessage	()Ljava/lang/String;
    //   1767: invokevirtual 412	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1770: invokevirtual 418	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1773: invokestatic 135	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1776: iconst_0
    //   1777: istore 8
    //   1779: goto -415 -> 1364
    //   1782: iconst_0
    //   1783: istore 9
    //   1785: goto +2629 -> 4414
    //   1788: iload 9
    //   1790: istore 10
    //   1792: iload 8
    //   1794: istore 9
    //   1796: iload 5
    //   1798: iconst_2
    //   1799: if_icmpne -330 -> 1469
    //   1802: aload_1
    //   1803: ldc 167
    //   1805: iconst_0
    //   1806: invokevirtual 608	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   1809: istore 10
    //   1811: iload 8
    //   1813: istore 9
    //   1815: goto -346 -> 1469
    //   1818: astore_2
    //   1819: iconst_0
    //   1820: istore 8
    //   1822: aload_2
    //   1823: invokevirtual 558	java/lang/Exception:printStackTrace	()V
    //   1826: iload 8
    //   1828: istore 9
    //   1830: invokestatic 127	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1833: ifeq -355 -> 1478
    //   1836: ldc_w 427
    //   1839: iconst_2
    //   1840: aload_2
    //   1841: invokevirtual 440	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1844: invokestatic 561	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1847: iload 8
    //   1849: istore 9
    //   1851: goto -373 -> 1478
    //   1854: iload 5
    //   1856: tableswitch	default:+52 -> 1908, 1:+67->1923, 2:+67->1923, 3:+790->2646, 4:+220->2076, 5:+903->2759, 6:+1269->3125, 7:+1746->3602, 8:+2394->4250, 9:+1923->3779
    //   1909: aload_1
    //   1910: iload 5
    //   1912: iload 8
    //   1914: aload 14
    //   1916: ldc_w 322
    //   1919: invokevirtual 326	com/tencent/mobileqq/richstatus/StatusServlet:notifyObserver	(Landroid/content/Intent;IZLandroid/os/Bundle;Ljava/lang/Class;)V
    //   1922: return
    //   1923: aload_2
    //   1924: invokevirtual 281	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   1927: invokestatic 306	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   1930: astore_2
    //   1931: aload_2
    //   1932: invokevirtual 378	java/nio/ByteBuffer:getInt	()I
    //   1935: iconst_4
    //   1936: isub
    //   1937: newarray byte
    //   1939: astore 13
    //   1941: aload_2
    //   1942: aload 13
    //   1944: invokevirtual 380	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   1947: pop
    //   1948: new 173	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   1951: dup
    //   1952: invokespecial 174	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   1955: aload 13
    //   1957: invokevirtual 290	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1960: checkcast 173	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   1963: getfield 220	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1966: invokevirtual 302	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1969: invokevirtual 303	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   1972: invokestatic 306	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   1975: astore_2
    //   1976: aload_2
    //   1977: invokevirtual 309	java/nio/ByteBuffer:get	()B
    //   1980: istore_3
    //   1981: aload_2
    //   1982: invokevirtual 378	java/nio/ByteBuffer:getInt	()I
    //   1985: i2l
    //   1986: lstore 11
    //   1988: aload_2
    //   1989: invokevirtual 309	java/nio/ByteBuffer:get	()B
    //   1992: iconst_1
    //   1993: if_icmpne +2457 -> 4450
    //   1996: iconst_1
    //   1997: istore 9
    //   1999: goto +2433 -> 4432
    //   2002: aload 14
    //   2004: ldc 167
    //   2006: iload 10
    //   2008: invokevirtual 487	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   2011: iload 9
    //   2013: istore 8
    //   2015: goto -107 -> 1908
    //   2018: iload 9
    //   2020: istore 10
    //   2022: iload 8
    //   2024: istore 9
    //   2026: iload 5
    //   2028: iconst_2
    //   2029: if_icmpne -27 -> 2002
    //   2032: aload_1
    //   2033: ldc 167
    //   2035: iconst_0
    //   2036: invokevirtual 608	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   2039: istore 10
    //   2041: iload 8
    //   2043: istore 9
    //   2045: goto -43 -> 2002
    //   2048: astore_2
    //   2049: aload_2
    //   2050: invokevirtual 558	java/lang/Exception:printStackTrace	()V
    //   2053: invokestatic 127	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2056: ifeq +14 -> 2070
    //   2059: ldc_w 427
    //   2062: iconst_2
    //   2063: aload_2
    //   2064: invokevirtual 440	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2067: invokestatic 561	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   2070: iconst_0
    //   2071: istore 8
    //   2073: goto -165 -> 1908
    //   2076: new 353	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory
    //   2079: dup
    //   2080: invokespecial 354	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:<init>	()V
    //   2083: astore 13
    //   2085: aload 13
    //   2087: aload_1
    //   2088: ldc_w 356
    //   2091: iconst_0
    //   2092: invokevirtual 258	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   2095: putfield 359	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:startTime	I
    //   2098: aload 13
    //   2100: aload_1
    //   2101: ldc_w 361
    //   2104: ldc_w 362
    //   2107: invokevirtual 258	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   2110: putfield 365	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:endTime	I
    //   2113: aload 13
    //   2115: iconst_0
    //   2116: putfield 369	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:isAddFromCard	Z
    //   2119: aload 14
    //   2121: ldc_w 371
    //   2124: aload 13
    //   2126: invokevirtual 375	android/os/Bundle:putSerializable	(Ljava/lang/String;Ljava/io/Serializable;)V
    //   2129: aload_2
    //   2130: invokevirtual 281	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   2133: invokestatic 306	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   2136: astore_2
    //   2137: aload_2
    //   2138: invokevirtual 378	java/nio/ByteBuffer:getInt	()I
    //   2141: iconst_4
    //   2142: isub
    //   2143: newarray byte
    //   2145: astore 15
    //   2147: aload_2
    //   2148: aload 15
    //   2150: invokevirtual 380	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   2153: pop
    //   2154: new 173	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   2157: dup
    //   2158: invokespecial 174	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   2161: aload 15
    //   2163: invokevirtual 290	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2166: checkcast 173	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   2169: getfield 220	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   2172: invokevirtual 302	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   2175: invokevirtual 303	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   2178: invokestatic 306	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   2181: astore 15
    //   2183: aload 15
    //   2185: invokevirtual 309	java/nio/ByteBuffer:get	()B
    //   2188: pop
    //   2189: aload 15
    //   2191: invokevirtual 384	java/nio/ByteBuffer:getLong	()J
    //   2194: lstore 11
    //   2196: aload 15
    //   2198: invokevirtual 309	java/nio/ByteBuffer:get	()B
    //   2201: pop
    //   2202: aload 15
    //   2204: invokevirtual 378	java/nio/ByteBuffer:getInt	()I
    //   2207: pop
    //   2208: aload 15
    //   2210: invokevirtual 378	java/nio/ByteBuffer:getInt	()I
    //   2213: istore 4
    //   2215: aload 15
    //   2217: invokevirtual 378	java/nio/ByteBuffer:getInt	()I
    //   2220: pop
    //   2221: aload 15
    //   2223: invokevirtual 309	java/nio/ByteBuffer:get	()B
    //   2226: ifeq +2237 -> 4463
    //   2229: iconst_1
    //   2230: istore 9
    //   2232: aload 15
    //   2234: invokevirtual 388	java/nio/ByteBuffer:getShort	()S
    //   2237: istore 6
    //   2239: aload 13
    //   2241: new 55	java/util/ArrayList
    //   2244: dup
    //   2245: iload 6
    //   2247: invokespecial 390	java/util/ArrayList:<init>	(I)V
    //   2250: putfield 393	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:richStatus	Ljava/util/ArrayList;
    //   2253: aload_0
    //   2254: invokevirtual 270	com/tencent/mobileqq/richstatus/StatusServlet:getAppRuntime	()Lmqq/app/AppRuntime;
    //   2257: checkcast 139	com/tencent/mobileqq/app/QQAppInterface
    //   2260: astore_2
    //   2261: iconst_0
    //   2262: istore_3
    //   2263: iload_3
    //   2264: iload 6
    //   2266: if_icmpge +163 -> 2429
    //   2269: aload 15
    //   2271: invokevirtual 388	java/nio/ByteBuffer:getShort	()S
    //   2274: newarray byte
    //   2276: astore 16
    //   2278: aload 15
    //   2280: aload 16
    //   2282: invokevirtual 380	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   2285: pop
    //   2286: aload 15
    //   2288: invokevirtual 388	java/nio/ByteBuffer:getShort	()S
    //   2291: newarray byte
    //   2293: astore 17
    //   2295: aload 15
    //   2297: aload 17
    //   2299: invokevirtual 380	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   2302: pop
    //   2303: aload 15
    //   2305: invokevirtual 378	java/nio/ByteBuffer:getInt	()I
    //   2308: pop
    //   2309: aload 15
    //   2311: invokevirtual 378	java/nio/ByteBuffer:getInt	()I
    //   2314: istore 7
    //   2316: aload 15
    //   2318: aload 15
    //   2320: invokevirtual 396	java/nio/ByteBuffer:position	()I
    //   2323: bipush 8
    //   2325: iadd
    //   2326: invokevirtual 399	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   2329: pop
    //   2330: iload 7
    //   2332: iload 4
    //   2334: if_icmple +6 -> 2340
    //   2337: goto +2119 -> 4456
    //   2340: aload 17
    //   2342: invokestatic 540	com/tencent/mobileqq/richstatus/RichStatus:parseStatus	([B)Lcom/tencent/mobileqq/richstatus/RichStatus;
    //   2345: astore 17
    //   2347: aload 17
    //   2349: iload 7
    //   2351: i2l
    //   2352: putfield 543	com/tencent/mobileqq/richstatus/RichStatus:time	J
    //   2355: aload 17
    //   2357: aload 16
    //   2359: putfield 546	com/tencent/mobileqq/richstatus/RichStatus:key	[B
    //   2362: aload 17
    //   2364: getfield 546	com/tencent/mobileqq/richstatus/RichStatus:key	[B
    //   2367: ifnull +20 -> 2387
    //   2370: aload 17
    //   2372: new 548	java/lang/String
    //   2375: dup
    //   2376: aload 17
    //   2378: getfield 546	com/tencent/mobileqq/richstatus/RichStatus:key	[B
    //   2381: invokespecial 551	java/lang/String:<init>	([B)V
    //   2384: putfield 555	com/tencent/mobileqq/richstatus/RichStatus:feedsId	Ljava/lang/String;
    //   2387: aload 13
    //   2389: getfield 393	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:richStatus	Ljava/util/ArrayList;
    //   2392: aload 17
    //   2394: invokevirtual 93	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2397: pop
    //   2398: goto +2058 -> 4456
    //   2401: astore_2
    //   2402: aload_2
    //   2403: invokevirtual 558	java/lang/Exception:printStackTrace	()V
    //   2406: invokestatic 127	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2409: ifeq +14 -> 2423
    //   2412: ldc_w 427
    //   2415: iconst_2
    //   2416: aload_2
    //   2417: invokevirtual 440	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2420: invokestatic 561	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   2423: iconst_0
    //   2424: istore 8
    //   2426: goto -518 -> 1908
    //   2429: aload 13
    //   2431: getfield 393	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:richStatus	Ljava/util/ArrayList;
    //   2434: invokevirtual 564	java/util/ArrayList:isEmpty	()Z
    //   2437: ifeq +88 -> 2525
    //   2440: aload 13
    //   2442: getfield 359	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:startTime	I
    //   2445: ifne +80 -> 2525
    //   2448: aload 13
    //   2450: getfield 365	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:endTime	I
    //   2453: ldc_w 362
    //   2456: if_icmpne +69 -> 2525
    //   2459: aload_0
    //   2460: invokevirtual 270	com/tencent/mobileqq/richstatus/StatusServlet:getAppRuntime	()Lmqq/app/AppRuntime;
    //   2463: bipush 50
    //   2465: invokevirtual 276	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   2468: checkcast 566	com/tencent/mobileqq/app/FriendsManager
    //   2471: lload 11
    //   2473: invokestatic 570	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   2476: invokevirtual 573	com/tencent/mobileqq/app/FriendsManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   2479: astore 15
    //   2481: aload 15
    //   2483: ifnull +42 -> 2525
    //   2486: aload 15
    //   2488: invokevirtual 579	com/tencent/mobileqq/data/Card:getRichStatus	()Lcom/tencent/mobileqq/richstatus/RichStatus;
    //   2491: ifnull +34 -> 2525
    //   2494: aload 15
    //   2496: invokevirtual 579	com/tencent/mobileqq/data/Card:getRichStatus	()Lcom/tencent/mobileqq/richstatus/RichStatus;
    //   2499: invokevirtual 580	com/tencent/mobileqq/richstatus/RichStatus:isEmpty	()Z
    //   2502: ifne +23 -> 2525
    //   2505: aload 13
    //   2507: getfield 393	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:richStatus	Ljava/util/ArrayList;
    //   2510: aload 15
    //   2512: invokevirtual 579	com/tencent/mobileqq/data/Card:getRichStatus	()Lcom/tencent/mobileqq/richstatus/RichStatus;
    //   2515: invokevirtual 93	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2518: pop
    //   2519: aload 13
    //   2521: iconst_1
    //   2522: putfield 369	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:isAddFromCard	Z
    //   2525: aload_2
    //   2526: bipush 41
    //   2528: invokevirtual 583	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   2531: checkcast 585	com/tencent/mobileqq/app/SignatureHandler
    //   2534: astore 15
    //   2536: aload 13
    //   2538: getfield 393	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:richStatus	Ljava/util/ArrayList;
    //   2541: invokevirtual 64	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   2544: astore 16
    //   2546: aload 16
    //   2548: invokeinterface 70 1 0
    //   2553: ifeq +42 -> 2595
    //   2556: aload 16
    //   2558: invokeinterface 74 1 0
    //   2563: checkcast 536	com/tencent/mobileqq/richstatus/RichStatus
    //   2566: astore 17
    //   2568: aload 15
    //   2570: ifnull -24 -> 2546
    //   2573: aload 15
    //   2575: lload 11
    //   2577: invokestatic 570	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   2580: aload 17
    //   2582: getfield 555	com/tencent/mobileqq/richstatus/RichStatus:feedsId	Ljava/lang/String;
    //   2585: sipush 255
    //   2588: iconst_1
    //   2589: invokevirtual 588	com/tencent/mobileqq/app/SignatureHandler:a	(Ljava/lang/String;Ljava/lang/String;IZ)V
    //   2592: goto -46 -> 2546
    //   2595: aload 13
    //   2597: iload 9
    //   2599: putfield 591	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:over	Z
    //   2602: aload_2
    //   2603: bipush 57
    //   2605: invokevirtual 592	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   2608: checkcast 594	com/tencent/mobileqq/app/SignatureManager
    //   2611: astore 15
    //   2613: aload 15
    //   2615: ifnull +28 -> 2643
    //   2618: aload_2
    //   2619: invokevirtual 157	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   2622: lload 11
    //   2624: invokestatic 598	java/lang/Long:toString	(J)Ljava/lang/String;
    //   2627: invokevirtual 601	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2630: ifeq +13 -> 2643
    //   2633: aload 15
    //   2635: aload 13
    //   2637: getfield 393	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:richStatus	Ljava/util/ArrayList;
    //   2640: invokevirtual 604	com/tencent/mobileqq/app/SignatureManager:a	(Ljava/util/List;)V
    //   2643: goto -735 -> 1908
    //   2646: aload 14
    //   2648: ldc_w 610
    //   2651: aload_1
    //   2652: ldc_w 610
    //   2655: iconst_1
    //   2656: invokevirtual 608	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   2659: invokevirtual 487	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   2662: aload 14
    //   2664: ldc_w 612
    //   2667: aload_1
    //   2668: ldc_w 612
    //   2671: iconst_m1
    //   2672: invokevirtual 258	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   2675: invokevirtual 320	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   2678: new 614	com/qq/jce/wup/UniPacket
    //   2681: dup
    //   2682: iconst_1
    //   2683: invokespecial 617	com/qq/jce/wup/UniPacket:<init>	(Z)V
    //   2686: astore 13
    //   2688: aload 13
    //   2690: ldc_w 619
    //   2693: invokevirtual 623	com/qq/jce/wup/UniPacket:setEncodeName	(Ljava/lang/String;)V
    //   2696: aload 13
    //   2698: aload_2
    //   2699: invokevirtual 281	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   2702: invokevirtual 626	com/qq/jce/wup/UniPacket:decode	([B)V
    //   2705: aload 13
    //   2707: ldc_w 628
    //   2710: new 630	PersonalState/RespGetSameStateList
    //   2713: dup
    //   2714: invokespecial 631	PersonalState/RespGetSameStateList:<init>	()V
    //   2717: invokevirtual 635	com/qq/jce/wup/UniPacket:getByClass	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   2720: checkcast 630	PersonalState/RespGetSameStateList
    //   2723: astore_2
    //   2724: aload_2
    //   2725: getfield 639	PersonalState/RespGetSameStateList:oHead	LPersonalState/BusiRespHead;
    //   2728: getfield 644	PersonalState/BusiRespHead:iReplyCode	I
    //   2731: ifne +15 -> 2746
    //   2734: aload 14
    //   2736: ldc_w 646
    //   2739: aload_2
    //   2740: invokevirtual 375	android/os/Bundle:putSerializable	(Ljava/lang/String;Ljava/io/Serializable;)V
    //   2743: goto -835 -> 1908
    //   2746: iconst_0
    //   2747: istore 8
    //   2749: goto -6 -> 2743
    //   2752: astore_2
    //   2753: iconst_0
    //   2754: istore 8
    //   2756: goto -848 -> 1908
    //   2759: iload 8
    //   2761: ifeq -853 -> 1908
    //   2764: new 173	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   2767: dup
    //   2768: invokespecial 174	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   2771: astore 13
    //   2773: aload 13
    //   2775: aload_2
    //   2776: invokevirtual 281	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   2779: invokestatic 286	com/tencent/mobileqq/utils/WupUtil:b	([B)[B
    //   2782: invokevirtual 290	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2785: checkcast 173	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   2788: astore_2
    //   2789: aload_2
    //   2790: ifnull +318 -> 3108
    //   2793: aload_2
    //   2794: getfield 293	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2797: invokevirtual 296	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   2800: ifeq +308 -> 3108
    //   2803: aload_2
    //   2804: getfield 293	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2807: invokevirtual 299	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2810: istore_3
    //   2811: iload_3
    //   2812: ifne +281 -> 3093
    //   2815: aload_2
    //   2816: getfield 220	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   2819: invokevirtual 302	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   2822: invokevirtual 303	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   2825: invokestatic 306	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   2828: astore 15
    //   2830: aload 15
    //   2832: invokevirtual 309	java/nio/ByteBuffer:get	()B
    //   2835: istore_3
    //   2836: iload_3
    //   2837: ifne +187 -> 3024
    //   2840: aload 15
    //   2842: invokevirtual 388	java/nio/ByteBuffer:getShort	()S
    //   2845: istore 6
    //   2847: iconst_0
    //   2848: istore_3
    //   2849: aconst_null
    //   2850: astore_2
    //   2851: iload_3
    //   2852: iload 6
    //   2854: if_icmpge +75 -> 2929
    //   2857: aload 15
    //   2859: invokevirtual 388	java/nio/ByteBuffer:getShort	()S
    //   2862: newarray byte
    //   2864: astore_2
    //   2865: aload 15
    //   2867: aload_2
    //   2868: invokevirtual 380	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   2871: pop
    //   2872: iload_3
    //   2873: iconst_1
    //   2874: iadd
    //   2875: istore_3
    //   2876: goto -25 -> 2851
    //   2879: astore_2
    //   2880: aload_2
    //   2881: invokevirtual 647	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   2884: invokestatic 127	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2887: ifeq +33 -> 2920
    //   2890: ldc_w 427
    //   2893: iconst_2
    //   2894: new 405	java/lang/StringBuilder
    //   2897: dup
    //   2898: invokespecial 406	java/lang/StringBuilder:<init>	()V
    //   2901: ldc_w 429
    //   2904: invokevirtual 412	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2907: aload_2
    //   2908: invokevirtual 432	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:getMessage	()Ljava/lang/String;
    //   2911: invokevirtual 412	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2914: invokevirtual 418	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2917: invokestatic 135	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2920: iconst_0
    //   2921: istore 8
    //   2923: aload 13
    //   2925: astore_2
    //   2926: goto -137 -> 2789
    //   2929: aload 15
    //   2931: invokevirtual 388	java/nio/ByteBuffer:getShort	()S
    //   2934: istore 7
    //   2936: aconst_null
    //   2937: astore 13
    //   2939: iconst_0
    //   2940: istore 4
    //   2942: iconst_0
    //   2943: istore_3
    //   2944: iload_3
    //   2945: iload 7
    //   2947: if_icmpge +34 -> 2981
    //   2950: aload 15
    //   2952: invokevirtual 388	java/nio/ByteBuffer:getShort	()S
    //   2955: newarray byte
    //   2957: astore 13
    //   2959: aload 15
    //   2961: aload 13
    //   2963: invokevirtual 380	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   2966: pop
    //   2967: aload 15
    //   2969: invokevirtual 378	java/nio/ByteBuffer:getInt	()I
    //   2972: istore 4
    //   2974: iload_3
    //   2975: iconst_1
    //   2976: iadd
    //   2977: istore_3
    //   2978: goto -34 -> 2944
    //   2981: iload 6
    //   2983: ifle +15 -> 2998
    //   2986: aload 14
    //   2988: ldc_w 649
    //   2991: aload_2
    //   2992: invokevirtual 315	android/os/Bundle:putByteArray	(Ljava/lang/String;[B)V
    //   2995: goto +1474 -> 4469
    //   2998: aload 14
    //   3000: ldc_w 649
    //   3003: aload 13
    //   3005: invokevirtual 315	android/os/Bundle:putByteArray	(Ljava/lang/String;[B)V
    //   3008: aload 14
    //   3010: ldc_w 651
    //   3013: iload 4
    //   3015: invokevirtual 320	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   3018: iconst_0
    //   3019: istore 8
    //   3021: goto +1448 -> 4469
    //   3024: iconst_0
    //   3025: istore 8
    //   3027: aload 14
    //   3029: ldc_w 651
    //   3032: iload_3
    //   3033: invokevirtual 320	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   3036: goto +1433 -> 4469
    //   3039: astore_2
    //   3040: invokestatic 127	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3043: ifeq +33 -> 3076
    //   3046: ldc_w 427
    //   3049: iconst_2
    //   3050: new 405	java/lang/StringBuilder
    //   3053: dup
    //   3054: invokespecial 406	java/lang/StringBuilder:<init>	()V
    //   3057: ldc_w 653
    //   3060: invokevirtual 412	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3063: aload_2
    //   3064: invokevirtual 440	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   3067: invokevirtual 412	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3070: invokevirtual 418	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3073: invokestatic 561	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   3076: iconst_0
    //   3077: istore 8
    //   3079: aload 14
    //   3081: ldc_w 651
    //   3084: sipush -1002
    //   3087: invokevirtual 320	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   3090: goto +1379 -> 4469
    //   3093: iconst_0
    //   3094: istore 8
    //   3096: aload 14
    //   3098: ldc_w 651
    //   3101: iload_3
    //   3102: invokevirtual 320	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   3105: goto +1364 -> 4469
    //   3108: iconst_0
    //   3109: istore 8
    //   3111: aload 14
    //   3113: ldc_w 651
    //   3116: sipush -1001
    //   3119: invokevirtual 320	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   3122: goto +1347 -> 4469
    //   3125: new 614	com/qq/jce/wup/UniPacket
    //   3128: dup
    //   3129: iconst_1
    //   3130: invokespecial 617	com/qq/jce/wup/UniPacket:<init>	(Z)V
    //   3133: astore 15
    //   3135: aload 15
    //   3137: ldc_w 619
    //   3140: invokevirtual 623	com/qq/jce/wup/UniPacket:setEncodeName	(Ljava/lang/String;)V
    //   3143: aload 15
    //   3145: aload_2
    //   3146: invokevirtual 281	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   3149: invokevirtual 626	com/qq/jce/wup/UniPacket:decode	([B)V
    //   3152: aload 15
    //   3154: ldc_w 655
    //   3157: new 657	PersonalState/RespGetHotState
    //   3160: dup
    //   3161: invokespecial 658	PersonalState/RespGetHotState:<init>	()V
    //   3164: invokevirtual 635	com/qq/jce/wup/UniPacket:getByClass	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   3167: checkcast 657	PersonalState/RespGetHotState
    //   3170: astore 15
    //   3172: aload 15
    //   3174: getfield 659	PersonalState/RespGetHotState:oHead	LPersonalState/BusiRespHead;
    //   3177: getfield 644	PersonalState/BusiRespHead:iReplyCode	I
    //   3180: ifne +400 -> 3580
    //   3183: invokestatic 127	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3186: ifeq +159 -> 3345
    //   3189: new 405	java/lang/StringBuilder
    //   3192: dup
    //   3193: ldc_w 661
    //   3196: invokespecial 663	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3199: astore 16
    //   3201: aload 16
    //   3203: ldc_w 665
    //   3206: invokevirtual 412	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3209: astore 17
    //   3211: aload 15
    //   3213: getfield 668	PersonalState/RespGetHotState:vHostRichSateList	Ljava/util/ArrayList;
    //   3216: ifnonnull +102 -> 3318
    //   3219: ldc_w 670
    //   3222: astore_2
    //   3223: aload 17
    //   3225: aload_2
    //   3226: invokevirtual 529	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3229: ldc_w 672
    //   3232: invokevirtual 412	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3235: pop
    //   3236: aload 15
    //   3238: getfield 668	PersonalState/RespGetHotState:vHostRichSateList	Ljava/util/ArrayList;
    //   3241: ifnull +92 -> 3333
    //   3244: aload 15
    //   3246: getfield 668	PersonalState/RespGetHotState:vHostRichSateList	Ljava/util/ArrayList;
    //   3249: invokevirtual 673	java/util/ArrayList:size	()I
    //   3252: ifle +81 -> 3333
    //   3255: aload 15
    //   3257: getfield 668	PersonalState/RespGetHotState:vHostRichSateList	Ljava/util/ArrayList;
    //   3260: invokevirtual 64	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   3263: astore_2
    //   3264: aload_2
    //   3265: invokeinterface 70 1 0
    //   3270: ifeq +63 -> 3333
    //   3273: aload_2
    //   3274: invokeinterface 74 1 0
    //   3279: checkcast 675	PersonalState/HotRishState
    //   3282: astore 17
    //   3284: aload 16
    //   3286: ldc_w 677
    //   3289: invokevirtual 412	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3292: aload 17
    //   3294: getfield 680	PersonalState/HotRishState:iActId	I
    //   3297: invokevirtual 415	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3300: ldc_w 682
    //   3303: invokevirtual 412	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3306: aload 17
    //   3308: getfield 685	PersonalState/HotRishState:iDataId	I
    //   3311: invokevirtual 415	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3314: pop
    //   3315: goto -51 -> 3264
    //   3318: aload 15
    //   3320: getfield 668	PersonalState/RespGetHotState:vHostRichSateList	Ljava/util/ArrayList;
    //   3323: invokevirtual 673	java/util/ArrayList:size	()I
    //   3326: invokestatic 690	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3329: astore_2
    //   3330: goto -107 -> 3223
    //   3333: ldc_w 692
    //   3336: iconst_2
    //   3337: aload 16
    //   3339: invokevirtual 418	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3342: invokestatic 135	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3345: new 55	java/util/ArrayList
    //   3348: dup
    //   3349: bipush 6
    //   3351: invokespecial 390	java/util/ArrayList:<init>	(I)V
    //   3354: astore_2
    //   3355: aload 15
    //   3357: getfield 668	PersonalState/RespGetHotState:vHostRichSateList	Ljava/util/ArrayList;
    //   3360: ifnull +208 -> 3568
    //   3363: aload 15
    //   3365: getfield 668	PersonalState/RespGetHotState:vHostRichSateList	Ljava/util/ArrayList;
    //   3368: invokevirtual 673	java/util/ArrayList:size	()I
    //   3371: ifle +197 -> 3568
    //   3374: aload 13
    //   3376: ifnull +82 -> 3458
    //   3379: aload 13
    //   3381: invokevirtual 694	com/tencent/mobileqq/richstatus/StatusManager:a	()Lcom/tencent/mobileqq/richstatus/RichStatus;
    //   3384: astore 16
    //   3386: aload 15
    //   3388: getfield 668	PersonalState/RespGetHotState:vHostRichSateList	Ljava/util/ArrayList;
    //   3391: invokevirtual 673	java/util/ArrayList:size	()I
    //   3394: iconst_1
    //   3395: isub
    //   3396: istore_3
    //   3397: iload_3
    //   3398: iflt +60 -> 3458
    //   3401: aload 15
    //   3403: getfield 668	PersonalState/RespGetHotState:vHostRichSateList	Ljava/util/ArrayList;
    //   3406: iload_3
    //   3407: invokevirtual 697	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   3410: checkcast 675	PersonalState/HotRishState
    //   3413: astore 17
    //   3415: aload 17
    //   3417: getfield 680	PersonalState/HotRishState:iActId	I
    //   3420: aload 16
    //   3422: getfield 700	com/tencent/mobileqq/richstatus/RichStatus:actionId	I
    //   3425: if_icmpne +26 -> 3451
    //   3428: aload 17
    //   3430: getfield 685	PersonalState/HotRishState:iDataId	I
    //   3433: aload 16
    //   3435: getfield 703	com/tencent/mobileqq/richstatus/RichStatus:dataId	I
    //   3438: if_icmpne +13 -> 3451
    //   3441: aload 15
    //   3443: getfield 668	PersonalState/RespGetHotState:vHostRichSateList	Ljava/util/ArrayList;
    //   3446: iload_3
    //   3447: invokevirtual 706	java/util/ArrayList:remove	(I)Ljava/lang/Object;
    //   3450: pop
    //   3451: iload_3
    //   3452: iconst_1
    //   3453: isub
    //   3454: istore_3
    //   3455: goto -58 -> 3397
    //   3458: iconst_0
    //   3459: istore_3
    //   3460: iload_3
    //   3461: bipush 6
    //   3463: if_icmpge +24 -> 3487
    //   3466: aload_2
    //   3467: aload 15
    //   3469: getfield 668	PersonalState/RespGetHotState:vHostRichSateList	Ljava/util/ArrayList;
    //   3472: iload_3
    //   3473: invokevirtual 697	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   3476: invokevirtual 93	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   3479: pop
    //   3480: iload_3
    //   3481: iconst_1
    //   3482: iadd
    //   3483: istore_3
    //   3484: goto -24 -> 3460
    //   3487: new 405	java/lang/StringBuilder
    //   3490: dup
    //   3491: invokespecial 406	java/lang/StringBuilder:<init>	()V
    //   3494: astore 15
    //   3496: aload_2
    //   3497: invokevirtual 64	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   3500: astore 16
    //   3502: aload 16
    //   3504: invokeinterface 70 1 0
    //   3509: ifeq +49 -> 3558
    //   3512: aload 16
    //   3514: invokeinterface 74 1 0
    //   3519: checkcast 675	PersonalState/HotRishState
    //   3522: astore 17
    //   3524: aload 15
    //   3526: aload 17
    //   3528: getfield 680	PersonalState/HotRishState:iActId	I
    //   3531: invokevirtual 415	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3534: ldc_w 682
    //   3537: invokevirtual 412	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3540: aload 17
    //   3542: getfield 685	PersonalState/HotRishState:iDataId	I
    //   3545: invokevirtual 415	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3548: ldc_w 708
    //   3551: invokevirtual 412	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3554: pop
    //   3555: goto -53 -> 3502
    //   3558: aload 13
    //   3560: aload 15
    //   3562: invokevirtual 418	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3565: invokevirtual 710	com/tencent/mobileqq/richstatus/StatusManager:a	(Ljava/lang/String;)V
    //   3568: aload 14
    //   3570: ldc_w 712
    //   3573: aload_2
    //   3574: invokevirtual 375	android/os/Bundle:putSerializable	(Ljava/lang/String;Ljava/io/Serializable;)V
    //   3577: goto -1669 -> 1908
    //   3580: invokestatic 127	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3583: ifeq +13 -> 3596
    //   3586: ldc_w 692
    //   3589: iconst_2
    //   3590: ldc_w 714
    //   3593: invokestatic 135	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3596: iconst_0
    //   3597: istore 8
    //   3599: goto -1691 -> 1908
    //   3602: iload 8
    //   3604: ifeq -1696 -> 1908
    //   3607: new 173	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   3610: dup
    //   3611: invokespecial 174	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   3614: astore 13
    //   3616: aload 13
    //   3618: aload_2
    //   3619: invokevirtual 281	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   3622: invokestatic 286	com/tencent/mobileqq/utils/WupUtil:b	([B)[B
    //   3625: invokevirtual 290	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3628: checkcast 173	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   3631: astore_2
    //   3632: iload 8
    //   3634: istore 9
    //   3636: aload_2
    //   3637: ifnull +80 -> 3717
    //   3640: iload 8
    //   3642: istore 9
    //   3644: aload_2
    //   3645: getfield 293	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3648: invokevirtual 296	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   3651: ifeq +66 -> 3717
    //   3654: aload_2
    //   3655: getfield 293	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3658: invokevirtual 299	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3661: ifne +69 -> 3730
    //   3664: aload_2
    //   3665: getfield 220	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3668: invokevirtual 302	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   3671: invokevirtual 303	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   3674: invokestatic 306	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   3677: astore_2
    //   3678: aload_2
    //   3679: invokevirtual 309	java/nio/ByteBuffer:get	()B
    //   3682: ifne +42 -> 3724
    //   3685: aload 14
    //   3687: ldc_w 311
    //   3690: aload_2
    //   3691: invokevirtual 224	java/nio/ByteBuffer:array	()[B
    //   3694: invokevirtual 315	android/os/Bundle:putByteArray	(Ljava/lang/String;[B)V
    //   3697: aload 14
    //   3699: ldc_w 317
    //   3702: aload_1
    //   3703: ldc_w 317
    //   3706: iconst_0
    //   3707: invokevirtual 258	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   3710: invokevirtual 320	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   3713: iload 8
    //   3715: istore 9
    //   3717: iload 9
    //   3719: istore 8
    //   3721: goto -1813 -> 1908
    //   3724: iconst_0
    //   3725: istore 9
    //   3727: goto -10 -> 3717
    //   3730: iconst_0
    //   3731: istore 9
    //   3733: goto -16 -> 3717
    //   3736: astore_2
    //   3737: invokestatic 127	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3740: ifeq +33 -> 3773
    //   3743: ldc_w 427
    //   3746: iconst_2
    //   3747: new 405	java/lang/StringBuilder
    //   3750: dup
    //   3751: invokespecial 406	java/lang/StringBuilder:<init>	()V
    //   3754: ldc_w 429
    //   3757: invokevirtual 412	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3760: aload_2
    //   3761: invokevirtual 432	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:getMessage	()Ljava/lang/String;
    //   3764: invokevirtual 412	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3767: invokevirtual 418	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3770: invokestatic 135	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3773: iconst_0
    //   3774: istore 9
    //   3776: goto -59 -> 3717
    //   3779: iload 8
    //   3781: ifeq -1873 -> 1908
    //   3784: aload_2
    //   3785: invokevirtual 281	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   3788: arraylength
    //   3789: iconst_4
    //   3790: isub
    //   3791: istore_3
    //   3792: iload_3
    //   3793: newarray byte
    //   3795: astore 13
    //   3797: aload 13
    //   3799: iconst_0
    //   3800: aload_2
    //   3801: invokevirtual 281	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   3804: iconst_4
    //   3805: iload_3
    //   3806: invokestatic 331	com/tencent/mobileqq/utils/httputils/PkgTools:a	([BI[BII)V
    //   3809: new 333	com/tencent/pb/signature/SigActPb$RspBody
    //   3812: dup
    //   3813: invokespecial 334	com/tencent/pb/signature/SigActPb$RspBody:<init>	()V
    //   3816: astore_2
    //   3817: aload_2
    //   3818: aload 13
    //   3820: invokevirtual 335	com/tencent/pb/signature/SigActPb$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3823: pop
    //   3824: aload_2
    //   3825: getfield 339	com/tencent/pb/signature/SigActPb$RspBody:ret	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   3828: invokevirtual 342	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   3831: istore_3
    //   3832: iload_3
    //   3833: ifne +75 -> 3908
    //   3836: aload_2
    //   3837: getfield 346	com/tencent/pb/signature/SigActPb$RspBody:auth_rsp	Lcom/tencent/pb/signature/SigActPb$SigauthRsp;
    //   3840: getfield 351	com/tencent/pb/signature/SigActPb$SigauthRsp:result	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3843: invokevirtual 302	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   3846: invokevirtual 303	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   3849: invokestatic 306	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   3852: astore_2
    //   3853: aload_2
    //   3854: invokevirtual 309	java/nio/ByteBuffer:get	()B
    //   3857: istore_3
    //   3858: iload_3
    //   3859: ifne +34 -> 3893
    //   3862: aload 14
    //   3864: ldc_w 311
    //   3867: aload_2
    //   3868: invokevirtual 224	java/nio/ByteBuffer:array	()[B
    //   3871: invokevirtual 315	android/os/Bundle:putByteArray	(Ljava/lang/String;[B)V
    //   3874: aload 14
    //   3876: ldc_w 317
    //   3879: aload_1
    //   3880: ldc_w 317
    //   3883: iconst_0
    //   3884: invokevirtual 258	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   3887: invokevirtual 320	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   3890: goto +582 -> 4472
    //   3893: aload 14
    //   3895: ldc_w 439
    //   3898: iload_3
    //   3899: invokevirtual 320	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   3902: iconst_0
    //   3903: istore 8
    //   3905: goto +567 -> 4472
    //   3908: iconst_0
    //   3909: istore 9
    //   3911: aload 14
    //   3913: ldc_w 446
    //   3916: iload_3
    //   3917: invokevirtual 320	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   3920: iload_3
    //   3921: ldc_w 447
    //   3924: if_icmpne +21 -> 3945
    //   3927: aload 14
    //   3929: ldc_w 449
    //   3932: aload_2
    //   3933: getfield 346	com/tencent/pb/signature/SigActPb$RspBody:auth_rsp	Lcom/tencent/pb/signature/SigActPb$SigauthRsp;
    //   3936: getfield 453	com/tencent/pb/signature/SigActPb$SigauthRsp:url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3939: invokevirtual 457	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   3942: invokevirtual 461	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   3945: iload 9
    //   3947: istore 8
    //   3949: aload_2
    //   3950: getfield 346	com/tencent/pb/signature/SigActPb$RspBody:auth_rsp	Lcom/tencent/pb/signature/SigActPb$SigauthRsp;
    //   3953: getfield 465	com/tencent/pb/signature/SigActPb$SigauthRsp:tips_info	Lcom/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo;
    //   3956: invokevirtual 468	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo:has	()Z
    //   3959: ifeq +513 -> 4472
    //   3962: new 467	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo
    //   3965: dup
    //   3966: invokespecial 469	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo:<init>	()V
    //   3969: astore 13
    //   3971: aload 13
    //   3973: aload_2
    //   3974: getfield 346	com/tencent/pb/signature/SigActPb$RspBody:auth_rsp	Lcom/tencent/pb/signature/SigActPb$SigauthRsp;
    //   3977: getfield 465	com/tencent/pb/signature/SigActPb$SigauthRsp:tips_info	Lcom/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo;
    //   3980: invokevirtual 472	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3983: checkcast 467	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo
    //   3986: invokevirtual 473	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo:toByteArray	()[B
    //   3989: invokevirtual 474	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3992: pop
    //   3993: aload 13
    //   3995: getfield 478	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo:valid	Lcom/tencent/mobileqq/pb/PBBoolField;
    //   3998: invokevirtual 482	com/tencent/mobileqq/pb/PBBoolField:get	()Z
    //   4001: istore 8
    //   4003: aload 14
    //   4005: ldc_w 483
    //   4008: iload 8
    //   4010: invokevirtual 487	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   4013: iload 8
    //   4015: ifeq +147 -> 4162
    //   4018: aload 14
    //   4020: ldc_w 715
    //   4023: aload 13
    //   4025: getfield 716	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo:ret	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   4028: invokevirtual 342	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   4031: invokevirtual 320	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   4034: aload 14
    //   4036: ldc_w 489
    //   4039: aload 13
    //   4041: getfield 491	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo:type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4044: invokevirtual 299	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4047: invokevirtual 320	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   4050: aload 14
    //   4052: ldc_w 493
    //   4055: aload 13
    //   4057: getfield 496	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo:title_wording	Lcom/tencent/mobileqq/pb/PBStringField;
    //   4060: invokevirtual 457	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   4063: invokevirtual 461	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   4066: aload 14
    //   4068: ldc_w 498
    //   4071: aload 13
    //   4073: getfield 500	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo:wording	Lcom/tencent/mobileqq/pb/PBStringField;
    //   4076: invokevirtual 457	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   4079: invokevirtual 461	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   4082: aload 14
    //   4084: ldc_w 502
    //   4087: aload 13
    //   4089: getfield 505	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo:right_btn_wording	Lcom/tencent/mobileqq/pb/PBStringField;
    //   4092: invokevirtual 457	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   4095: invokevirtual 461	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   4098: aload 14
    //   4100: ldc_w 507
    //   4103: aload 13
    //   4105: getfield 510	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo:left_btn_wording	Lcom/tencent/mobileqq/pb/PBStringField;
    //   4108: invokevirtual 457	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   4111: invokevirtual 461	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   4114: aload 14
    //   4116: ldc_w 512
    //   4119: aload 13
    //   4121: getfield 515	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo:vip_type	Lcom/tencent/mobileqq/pb/PBStringField;
    //   4124: invokevirtual 457	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   4127: invokevirtual 461	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   4130: aload 14
    //   4132: ldc_w 517
    //   4135: aload 13
    //   4137: getfield 520	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo:vip_month	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4140: invokevirtual 299	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4143: invokevirtual 320	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   4146: aload 14
    //   4148: ldc_w 521
    //   4151: aload 13
    //   4153: getfield 522	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo:url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   4156: invokevirtual 457	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   4159: invokevirtual 461	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   4162: iload 9
    //   4164: istore 8
    //   4166: invokestatic 127	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4169: ifeq +303 -> 4472
    //   4172: ldc_w 524
    //   4175: iconst_2
    //   4176: new 405	java/lang/StringBuilder
    //   4179: dup
    //   4180: invokespecial 406	java/lang/StringBuilder:<init>	()V
    //   4183: ldc_w 526
    //   4186: invokevirtual 412	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4189: aload 14
    //   4191: invokevirtual 529	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4194: invokevirtual 418	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4197: invokestatic 532	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4200: iload 9
    //   4202: istore 8
    //   4204: goto +268 -> 4472
    //   4207: astore_2
    //   4208: invokestatic 127	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4211: ifeq +33 -> 4244
    //   4214: ldc_w 427
    //   4217: iconst_2
    //   4218: new 405	java/lang/StringBuilder
    //   4221: dup
    //   4222: invokespecial 406	java/lang/StringBuilder:<init>	()V
    //   4225: ldc_w 429
    //   4228: invokevirtual 412	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4231: aload_2
    //   4232: invokevirtual 440	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   4235: invokevirtual 412	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4238: invokevirtual 418	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4241: invokestatic 135	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4244: iconst_0
    //   4245: istore 8
    //   4247: goto -2339 -> 1908
    //   4250: iload 8
    //   4252: ifeq -2344 -> 1908
    //   4255: new 173	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   4258: dup
    //   4259: invokespecial 174	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   4262: astore 13
    //   4264: aload 13
    //   4266: aload_2
    //   4267: invokevirtual 281	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   4270: invokestatic 286	com/tencent/mobileqq/utils/WupUtil:b	([B)[B
    //   4273: invokevirtual 290	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   4276: checkcast 173	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   4279: astore_2
    //   4280: iload 8
    //   4282: istore 9
    //   4284: aload_2
    //   4285: ifnull +55 -> 4340
    //   4288: iload 8
    //   4290: istore 9
    //   4292: aload_2
    //   4293: getfield 293	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4296: invokevirtual 296	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   4299: ifeq +41 -> 4340
    //   4302: aload_2
    //   4303: getfield 293	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4306: invokevirtual 299	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4309: ifne +44 -> 4353
    //   4312: aload_2
    //   4313: getfield 220	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   4316: invokevirtual 302	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   4319: invokevirtual 303	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   4322: invokestatic 306	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   4325: invokevirtual 309	java/nio/ByteBuffer:get	()B
    //   4328: istore_3
    //   4329: iload_3
    //   4330: ifne +17 -> 4347
    //   4333: iconst_1
    //   4334: istore 8
    //   4336: iload 8
    //   4338: istore 9
    //   4340: iload 9
    //   4342: istore 8
    //   4344: goto -2436 -> 1908
    //   4347: iconst_0
    //   4348: istore 8
    //   4350: goto -14 -> 4336
    //   4353: iconst_0
    //   4354: istore 9
    //   4356: goto -16 -> 4340
    //   4359: astore_2
    //   4360: invokestatic 127	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4363: ifeq +33 -> 4396
    //   4366: ldc_w 427
    //   4369: iconst_2
    //   4370: new 405	java/lang/StringBuilder
    //   4373: dup
    //   4374: invokespecial 406	java/lang/StringBuilder:<init>	()V
    //   4377: ldc_w 429
    //   4380: invokevirtual 412	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4383: aload_2
    //   4384: invokevirtual 432	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:getMessage	()Ljava/lang/String;
    //   4387: invokevirtual 412	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4390: invokevirtual 418	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4393: invokestatic 135	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4396: iconst_0
    //   4397: istore 9
    //   4399: goto -59 -> 4340
    //   4402: goto -3038 -> 1364
    //   4405: goto -3041 -> 1364
    //   4408: goto -3030 -> 1378
    //   4411: goto -4061 -> 350
    //   4414: iload_3
    //   4415: ifeq -2627 -> 1788
    //   4418: iconst_0
    //   4419: istore 8
    //   4421: iload 9
    //   4423: istore 10
    //   4425: iload 8
    //   4427: istore 9
    //   4429: goto -2960 -> 1469
    //   4432: iload_3
    //   4433: ifeq -2415 -> 2018
    //   4436: iconst_0
    //   4437: istore 8
    //   4439: iload 9
    //   4441: istore 10
    //   4443: iload 8
    //   4445: istore 9
    //   4447: goto -2445 -> 2002
    //   4450: iconst_0
    //   4451: istore 9
    //   4453: goto -21 -> 4432
    //   4456: iload_3
    //   4457: iconst_1
    //   4458: iadd
    //   4459: istore_3
    //   4460: goto -2197 -> 2263
    //   4463: iconst_0
    //   4464: istore 9
    //   4466: goto -2234 -> 2232
    //   4469: goto -2561 -> 1908
    //   4472: goto -2564 -> 1908
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	4475	0	this	StatusServlet
    //   0	4475	1	paramIntent	Intent
    //   0	4475	2	paramFromServiceMsg	com.tencent.qphone.base.remote.FromServiceMsg
    //   117	4343	3	i	int
    //   500	2514	4	j	int
    //   7	2023	5	k	int
    //   524	2458	6	m	int
    //   602	2346	7	n	int
    //   13	4431	8	bool1	boolean
    //   45	4420	9	bool2	boolean
    //   1473	2969	10	bool3	boolean
    //   481	2142	11	l	long
    //   36	491	13	localObject1	Object
    //   708	26	13	localInvalidProtocolBufferMicroException1	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
    //   787	424	13	localException1	Exception
    //   1224	25	13	localException2	Exception
    //   1293	418	13	localObject2	Object
    //   1737	26	13	localInvalidProtocolBufferMicroException2	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
    //   1939	2326	13	localObject3	Object
    //   22	4168	14	localBundle	android.os.Bundle
    //   226	3335	15	localObject4	Object
    //   431	3082	16	localObject5	Object
    //   564	2977	17	localObject6	Object
    //   581	1065	18	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   68	85	708	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   98	118	708	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   122	144	708	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   148	177	708	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   632	664	708	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   673	705	708	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   215	266	787	java/lang/Exception
    //   270	295	787	java/lang/Exception
    //   299	328	787	java/lang/Exception
    //   775	784	787	java/lang/Exception
    //   832	873	787	java/lang/Exception
    //   880	899	787	java/lang/Exception
    //   899	965	787	java/lang/Exception
    //   970	1098	787	java/lang/Exception
    //   1098	1132	787	java/lang/Exception
    //   360	516	1224	java/lang/Exception
    //   519	549	1224	java/lang/Exception
    //   557	618	1224	java/lang/Exception
    //   1163	1210	1224	java/lang/Exception
    //   1210	1221	1224	java/lang/Exception
    //   1493	1545	1224	java/lang/Exception
    //   1550	1589	1224	java/lang/Exception
    //   1589	1611	1224	java/lang/Exception
    //   1611	1633	1224	java/lang/Exception
    //   1638	1657	1224	java/lang/Exception
    //   1660	1679	1224	java/lang/Exception
    //   1692	1718	1224	java/lang/Exception
    //   1295	1312	1737	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1317	1357	1737	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1390	1463	1818	java/lang/Exception
    //   1469	1478	1818	java/lang/Exception
    //   1802	1811	1818	java/lang/Exception
    //   1923	1996	2048	java/lang/Exception
    //   2002	2011	2048	java/lang/Exception
    //   2032	2041	2048	java/lang/Exception
    //   2076	2229	2401	java/lang/Exception
    //   2232	2261	2401	java/lang/Exception
    //   2269	2330	2401	java/lang/Exception
    //   2340	2387	2401	java/lang/Exception
    //   2387	2398	2401	java/lang/Exception
    //   2429	2481	2401	java/lang/Exception
    //   2486	2525	2401	java/lang/Exception
    //   2525	2546	2401	java/lang/Exception
    //   2546	2568	2401	java/lang/Exception
    //   2573	2592	2401	java/lang/Exception
    //   2595	2613	2401	java/lang/Exception
    //   2618	2643	2401	java/lang/Exception
    //   2646	2743	2752	java/lang/Exception
    //   2773	2789	2879	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   2815	2836	3039	java/lang/Exception
    //   2840	2847	3039	java/lang/Exception
    //   2857	2872	3039	java/lang/Exception
    //   2929	2936	3039	java/lang/Exception
    //   2950	2974	3039	java/lang/Exception
    //   2986	2995	3039	java/lang/Exception
    //   2998	3018	3039	java/lang/Exception
    //   3027	3036	3039	java/lang/Exception
    //   3616	3632	3736	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3644	3713	3736	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3784	3832	4207	java/lang/Exception
    //   3836	3858	4207	java/lang/Exception
    //   3862	3890	4207	java/lang/Exception
    //   3893	3902	4207	java/lang/Exception
    //   3911	3920	4207	java/lang/Exception
    //   3927	3945	4207	java/lang/Exception
    //   3949	4013	4207	java/lang/Exception
    //   4018	4162	4207	java/lang/Exception
    //   4166	4200	4207	java/lang/Exception
    //   4264	4280	4359	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   4292	4329	4359	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    int i = 0;
    Object localObject1 = (AppInterface)getAppRuntime();
    int j = paramIntent.getIntExtra("k_cmd", 0);
    Object localObject2;
    Object localObject3;
    switch (j)
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
        if (j == 2) {}
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
      localObject1 = ((FriendsManager)((AppInterface)localObject1).getManager(50)).a(((AppInterface)localObject1).getCurrentAccountUin());
      if (localObject1 != null) {
        if (((Card)localObject1).shGender != 0) {
          break;
        }
      }
      break;
    }
    for (;;)
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
            break label974;
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
      localObject1 = "OidbSvc.0x54f_0";
      localObject2 = paramIntent.getByteArrayExtra("k_status_key");
      i = paramIntent.getIntExtra("k_status_flag", 1);
      paramIntent = new ArrayList();
      paramIntent.add(localObject2);
      paramPacket.putSendData(a(paramIntent, (byte)i));
      paramIntent = (Intent)localObject1;
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
      j = paramIntent.getIntExtra("k_sign_len", 2);
      localObject3 = paramIntent.getByteArrayExtra("k_sign_data");
      paramIntent = new SigActPb.Platform();
      paramIntent.platform.set(109L);
      paramIntent.mqqver.set("7.6.3");
      paramIntent.osver.set(DeviceInfoUtil.f());
      localObject2 = new SigActPb.SigauthReq();
      ((SigActPb.SigauthReq)localObject2).uin_disable.set(Long.parseLong(((AppInterface)localObject1).getCurrentAccountUin()));
      ((SigActPb.SigauthReq)localObject2).itemid.set(i);
      ((SigActPb.SigauthReq)localObject2).data.set(ByteStringMicro.copyFrom((byte[])localObject3));
      ((SigActPb.SigauthReq)localObject2).len.set(j);
      localObject1 = new SigActPb.ReqBody();
      ((SigActPb.ReqBody)localObject1).cmd.set(2);
      ((SigActPb.ReqBody)localObject1).plf.set(paramIntent);
      ((SigActPb.ReqBody)localObject1).auth_req.set((MessageMicro)localObject2);
      ((SigActPb.ReqBody)localObject1).seq.set(System.currentTimeMillis());
      paramIntent = ((SigActPb.ReqBody)localObject1).toByteArray();
      localObject1 = new byte[paramIntent.length + 4];
      PkgTools.a((byte[])localObject1, 0, paramIntent.length + 4);
      PkgTools.a((byte[])localObject1, 4, paramIntent, paramIntent.length);
      paramPacket.putSendData((byte[])localObject1);
      if (QLog.isColorLevel())
      {
        QLog.d("StatusServlet", 2, "Signature.auth");
        paramIntent = "Signature.auth";
        break;
      }
      paramIntent = "Signature.auth";
      break;
      label974:
      i = 2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.StatusServlet
 * JD-Core Version:    0.7.0.1
 */