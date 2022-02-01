package com.tencent.mobileqq.portal;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.biz.ProtoServlet;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.DeviceInfo;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.PageReqInfo;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.ReportConfig;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.ReqGetConfigByPage;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.ReqReportConfig;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Screen;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.WupUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.zip.InflaterInputStream;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.app.Packet;
import tencent.im.cs.cmd0x6ff.subcmd0x501.ReqBody;
import tencent.im.cs.cmd0x6ff.subcmd0x501.SubCmd0x501ReqBody;
import tencent.im.new_year_2021.FestivalPack.NewYearEvePackReq;
import tencent.im.new_year_2021.FestivalPack.PkgReq;
import tencent.im.new_year_2021.Pack2021.Pack;
import tencent.im.new_year_2021.Unisso.UniSsoServerReq;
import tencent.im.new_year_2021.Unisso.UniSsoServerReqComm;
import tencent.im.new_year_ranking.PackRanking.PkgReq;
import tencent.im.new_year_ranking.PackRanking.QueryRankingReq;
import tencent.im.new_year_report.PackReport.PkgReq;
import tencent.im.new_year_report.PackReport.Report;
import tencent.im.new_year_report.PackReport.ReportElem;
import tencent.im.new_year_report.PackShareReport.PkgHead;
import tencent.im.new_year_report.PackShareReport.PkgReq;
import tencent.im.new_year_report.PackShareReport.ReportShareReq;

public class RedPacketServlet
  extends ProtoServlet
{
  private static int a = 0;
  
  private int a(PBUInt32Field paramPBUInt32Field)
  {
    if (paramPBUInt32Field.has()) {
      return paramPBUInt32Field.get();
    }
    return 0;
  }
  
  private Long a(PBUInt64Field paramPBUInt64Field)
  {
    if (paramPBUInt64Field.has()) {
      return Long.valueOf(paramPBUInt64Field.get());
    }
    return Long.valueOf(0L);
  }
  
  private String a(PBStringField paramPBStringField)
  {
    if (paramPBStringField.has()) {
      return paramPBStringField.get();
    }
    return "";
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    if ((paramInt6 < 2) || (!NetworkUtil.g(BaseApplicationImpl.sApplication))) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("RedPacketServlet", 2, "reportConfig, " + paramInt1 + ", " + paramInt2 + ", " + paramInt3 + ", " + paramInt4 + ", " + paramInt5);
    }
    NewIntent localNewIntent = new NewIntent(getAppRuntime().getApplication(), RedPacketServlet.class);
    localNewIntent.putExtra("k_cmd", 4);
    localNewIntent.putExtra("k_type", paramInt1);
    localNewIntent.putExtra("k_version", paramInt2);
    localNewIntent.putExtra("k_id", paramInt3);
    localNewIntent.putExtra("k_opt", paramInt4);
    localNewIntent.putExtra("k_code", paramInt5);
    getAppRuntime().startServlet(localNewIntent);
  }
  
  public static void a(AppRuntime paramAppRuntime, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RedPacketServlet", 2, "requestShuaYiShuaRedPacket, promotionId = " + paramInt1 + "，continuousBrushCount = " + paramInt2);
    }
    NewIntent localNewIntent = new NewIntent(paramAppRuntime.getApplication(), RedPacketServlet.class);
    localNewIntent.putExtra("k_cmd", 1);
    localNewIntent.putExtra("k_id", paramInt1);
    localNewIntent.putExtra("k_condition", paramInt2);
    localNewIntent.putExtra("k_uin", paramAppRuntime.getAccount());
    paramAppRuntime.startServlet(localNewIntent);
  }
  
  public static void a(AppRuntime paramAppRuntime, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RedPacketServlet", 2, "requestResult, reqType " + paramInt3 + ", reqNumber " + paramInt2);
    }
    NewIntent localNewIntent = new NewIntent(paramAppRuntime.getApplication(), RedPacketServlet.class);
    localNewIntent.putExtra("k_cmd", 8);
    localNewIntent.putExtra("k_uin", paramAppRuntime.getAccount());
    localNewIntent.putExtra("k_type", paramInt1);
    localNewIntent.putExtra("k_count", paramInt2);
    localNewIntent.putExtra("key_seq", paramInt4);
    localNewIntent.putExtra("k_r_type", paramInt3);
    paramAppRuntime.startServlet(localNewIntent);
  }
  
  private static void a(AppRuntime paramAppRuntime, int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RedPacketServlet", 2, "getConfig, " + paramInt1 + ", " + paramInt2 + ", " + paramInt3 + ", " + paramArrayOfByte1 + ", " + paramArrayOfByte2);
    }
    NewIntent localNewIntent = new NewIntent(paramAppRuntime.getApplication(), RedPacketServlet.class);
    localNewIntent.putExtra("k_cmd", 2);
    localNewIntent.putExtra("k_offset", paramInt2);
    localNewIntent.putExtra("k_id", paramInt3);
    localNewIntent.putExtra("k_version", paramInt1);
    localNewIntent.putExtra("k_cookie", paramArrayOfByte1);
    localNewIntent.putExtra("k_buff", paramArrayOfByte2);
    if (paramInt2 != 0) {}
    for (boolean bool = true;; bool = false)
    {
      localNewIntent.putExtra("k_new_page", bool);
      paramAppRuntime.startServlet(localNewIntent);
      return;
    }
  }
  
  public static void a(AppRuntime paramAppRuntime, int paramInt, ArrayList<RedPacketServlet.BrashReportItem> paramArrayList, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RedPacketServlet", 2, "reportBrashCount, " + paramBundle);
    }
    NewIntent localNewIntent = new NewIntent(paramAppRuntime.getApplication(), RedPacketServlet.class);
    localNewIntent.putExtra("k_cmd", 7);
    localNewIntent.putExtra("k_id", paramInt);
    localNewIntent.putExtra("k_uin", paramAppRuntime.getAccount());
    localNewIntent.putExtra("k_b_ing", paramBoolean);
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("k_b_list", paramArrayList);
    localBundle.putAll(paramBundle);
    localNewIntent.putExtras(localBundle);
    paramAppRuntime.startServlet(localNewIntent);
  }
  
  private void a(Pack2021.Pack paramPack, Bundle paramBundle)
  {
    int i = a(paramPack.state);
    int j = a(paramPack.money);
    int k = a(paramPack.type);
    int m = a(paramPack.promotion_id);
    int n = a(paramPack.business_id);
    int i1 = a(paramPack.ctime);
    int i2 = a(paramPack.mtime);
    Long localLong1 = a(paramPack.uin);
    Long localLong2 = a(paramPack.send_uin);
    String str1;
    if (paramPack.pack_id.has())
    {
      str1 = paramPack.pack_id.get().toStringUtf8();
      if (!paramPack.signature.has()) {
        break label709;
      }
    }
    label709:
    for (String str2 = paramPack.signature.get().toStringUtf8();; str2 = "")
    {
      String str3 = a(paramPack.req_id);
      String str4 = a(paramPack.url);
      String str5 = a(paramPack.wishing);
      String str6 = a(paramPack.order);
      String str7 = a(paramPack.business_name);
      String str8 = a(paramPack.business_logo);
      String str9 = a(paramPack.business_video);
      String str10 = a(paramPack.business_cover);
      String str11 = a(paramPack.business_video_cover);
      paramPack = a(paramPack.business_name_pic);
      paramBundle.putInt("key_promotion_id", m);
      paramBundle.putInt("k_state", i);
      paramBundle.putInt("key_award_type", k);
      paramBundle.putInt("k_money", j);
      paramBundle.putInt("key_business_id", n);
      paramBundle.putInt("k_c_time", i1);
      paramBundle.putInt("key_mtime", i2);
      paramBundle.putLong("k_uin", localLong1.longValue());
      paramBundle.putLong("key_send_uin", localLong2.longValue());
      paramBundle.putString("k_pack_id", str1);
      paramBundle.putString("key_url", str4);
      paramBundle.putString("key_req_id", str3);
      paramBundle.putString("key_order", str6);
      paramBundle.putString("key_signature", str2);
      paramBundle.putString("key_wishing", str5);
      paramBundle.putString("key_business_name", str7);
      paramBundle.putString("key_business_video", str9);
      paramBundle.putString("key_business_cover", str10);
      paramBundle.putString("key_business_logo", str8);
      paramBundle.putString("key_business_video_cover", str11);
      paramBundle.putString("key_business_name_pic", paramPack);
      if (QLog.isColorLevel()) {
        QLog.d("RedPacketServlet", 2, new Object[] { "parsePackData pack_id = " + str1 + "\nbusiness_id = " + n + "\nstate = " + i + "\nmoney = " + j + "\nmtime = " + i2 + "\nawardType = " + k + "\nwishing = " + str5 + "\norder = " + str6 + "\nsignature = " + str2 + "\nreq_id = " + str3 + "\npromotion_id = " + m + "\nsend_uin = " + localLong2 + "\nuin = " + localLong1 + "\nctime = " + i1 + "\npackUrl = " + str4 + "\nbusiness_name = " + str7 + "\nbusiness_logo = " + str8 + "\nbusiness_cover = " + str10 + "\nbusiness_video = " + str9 + "\nbusiness_video_cover = " + str11 + "\n", "business_name_pic = " + paramPack });
      }
      return;
      str1 = "";
      break;
    }
  }
  
  private byte[] a(byte[] paramArrayOfByte)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    try
    {
      paramArrayOfByte = new InflaterInputStream(new ByteArrayInputStream(paramArrayOfByte));
      byte[] arrayOfByte = new byte[256];
      for (;;)
      {
        int i = paramArrayOfByte.read(arrayOfByte);
        if (-1 == i) {
          break;
        }
        localByteArrayOutputStream.write(arrayOfByte, 0, i);
      }
      paramArrayOfByte = localByteArrayOutputStream.toByteArray();
    }
    catch (Throwable paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      return null;
    }
    return paramArrayOfByte;
  }
  
  /* Error */
  public void onReceive(Intent paramIntent, com.tencent.qphone.base.remote.FromServiceMsg paramFromServiceMsg)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 94	com/tencent/mobileqq/portal/RedPacketServlet:getAppRuntime	()Lmqq/app/AppRuntime;
    //   4: checkcast 421	com/tencent/mobileqq/app/QQAppInterface
    //   7: astore 15
    //   9: aload 15
    //   11: ifnonnull +4 -> 15
    //   14: return
    //   15: aload_1
    //   16: ldc 105
    //   18: iconst_m1
    //   19: invokevirtual 427	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   22: istore 6
    //   24: invokestatic 65	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   27: ifeq +30 -> 57
    //   30: ldc 67
    //   32: iconst_2
    //   33: new 69	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   40: ldc_w 429
    //   43: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: iload 6
    //   48: invokevirtual 79	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   51: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: invokestatic 88	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   57: aload_1
    //   58: ldc_w 431
    //   61: iconst_0
    //   62: invokevirtual 427	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   65: istore 7
    //   67: aload_2
    //   68: invokevirtual 436	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   71: istore 10
    //   73: invokestatic 65	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   76: ifeq +30 -> 106
    //   79: ldc 67
    //   81: iconst_2
    //   82: new 69	java/lang/StringBuilder
    //   85: dup
    //   86: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   89: ldc_w 438
    //   92: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: iload 10
    //   97: invokevirtual 441	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   100: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   103: invokestatic 88	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   106: ldc2_w 442
    //   109: lstore 11
    //   111: iload 10
    //   113: ifeq +2365 -> 2478
    //   116: aload_2
    //   117: invokevirtual 446	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   120: invokestatic 451	com/tencent/mobileqq/utils/WupUtil:b	([B)[B
    //   123: astore 13
    //   125: iload 6
    //   127: tableswitch	default:+53 -> 180, 1:+114->241, 2:+510->637, 3:+53->180, 4:+1266->1393, 5:+53->180, 6:+53->180, 7:+1285->1412, 8:+1325->1452, 9:+1305->1432, 10:+2095->2222
    //   181: astore_2
    //   182: ldc2_w 442
    //   185: lstore 11
    //   187: iload 10
    //   189: istore 9
    //   191: iload 9
    //   193: ifne +2325 -> 2518
    //   196: iload 7
    //   198: iconst_2
    //   199: if_icmpge +2319 -> 2518
    //   202: aload_1
    //   203: ldc_w 431
    //   206: iload 7
    //   208: iconst_1
    //   209: iadd
    //   210: invokevirtual 452	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   213: pop
    //   214: iload 6
    //   216: bipush 7
    //   218: if_icmpne +2288 -> 2506
    //   221: invokestatic 458	com/tencent/mobileqq/app/ThreadManager:getSubThreadHandler	()Lmqq/os/MqqHandler;
    //   224: new 460	com/tencent/mobileqq/portal/RedPacketServlet$1
    //   227: dup
    //   228: aload_0
    //   229: aload_1
    //   230: invokespecial 463	com/tencent/mobileqq/portal/RedPacketServlet$1:<init>	(Lcom/tencent/mobileqq/portal/RedPacketServlet;Landroid/content/Intent;)V
    //   233: ldc2_w 464
    //   236: invokevirtual 471	mqq/os/MqqHandler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   239: pop
    //   240: return
    //   241: new 176	android/os/Bundle
    //   244: dup
    //   245: invokespecial 177	android/os/Bundle:<init>	()V
    //   248: astore_2
    //   249: new 473	tencent/im/new_year_2021/Unisso$UniSsoServerRsp
    //   252: dup
    //   253: invokespecial 474	tencent/im/new_year_2021/Unisso$UniSsoServerRsp:<init>	()V
    //   256: astore 14
    //   258: aload 14
    //   260: aload 13
    //   262: invokevirtual 478	tencent/im/new_year_2021/Unisso$UniSsoServerRsp:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   265: pop
    //   266: aload 14
    //   268: getfield 482	tencent/im/new_year_2021/Unisso$UniSsoServerRsp:ret	Lcom/tencent/mobileqq/pb/PBInt64Field;
    //   271: invokevirtual 485	com/tencent/mobileqq/pb/PBInt64Field:has	()Z
    //   274: ifeq +2393 -> 2667
    //   277: aload 14
    //   279: getfield 482	tencent/im/new_year_2021/Unisso$UniSsoServerRsp:ret	Lcom/tencent/mobileqq/pb/PBInt64Field;
    //   282: invokevirtual 486	com/tencent/mobileqq/pb/PBInt64Field:get	()J
    //   285: lstore 11
    //   287: aload 14
    //   289: getfield 489	tencent/im/new_year_2021/Unisso$UniSsoServerRsp:errmsg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   292: invokevirtual 42	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   295: ifeq +2380 -> 2675
    //   298: aload 14
    //   300: getfield 489	tencent/im/new_year_2021/Unisso$UniSsoServerRsp:errmsg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   303: invokevirtual 45	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   306: astore 13
    //   308: invokestatic 65	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   311: ifeq +41 -> 352
    //   314: ldc 67
    //   316: iconst_2
    //   317: new 69	java/lang/StringBuilder
    //   320: dup
    //   321: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   324: ldc_w 491
    //   327: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: lload 11
    //   332: invokevirtual 494	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   335: ldc_w 496
    //   338: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: aload 13
    //   343: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   349: invokestatic 88	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   352: lload 11
    //   354: lconst_0
    //   355: lcmp
    //   356: ifne +236 -> 592
    //   359: new 498	tencent/im/new_year_2021/FestivalPack$PkgResp
    //   362: dup
    //   363: invokespecial 499	tencent/im/new_year_2021/FestivalPack$PkgResp:<init>	()V
    //   366: astore 13
    //   368: aload 13
    //   370: aload 14
    //   372: getfield 502	tencent/im/new_year_2021/Unisso$UniSsoServerRsp:rspdata	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   375: invokevirtual 239	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   378: invokevirtual 503	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   381: invokevirtual 504	tencent/im/new_year_2021/FestivalPack$PkgResp:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   384: pop
    //   385: aload 13
    //   387: getfield 508	tencent/im/new_year_2021/FestivalPack$PkgResp:get_eve_pack	Ltencent/im/new_year_2021/FestivalPack$NewYearEvePackResp;
    //   390: invokevirtual 513	tencent/im/new_year_2021/FestivalPack$NewYearEvePackResp:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   393: checkcast 510	tencent/im/new_year_2021/FestivalPack$NewYearEvePackResp
    //   396: astore 13
    //   398: aload 13
    //   400: getfield 517	tencent/im/new_year_2021/FestivalPack$NewYearEvePackResp:pack	Ltencent/im/new_year_2021/Pack2021$Pack;
    //   403: invokevirtual 518	tencent/im/new_year_2021/Pack2021$Pack:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   406: checkcast 196	tencent/im/new_year_2021/Pack2021$Pack
    //   409: astore 14
    //   411: aload 13
    //   413: getfield 521	tencent/im/new_year_2021/FestivalPack$NewYearEvePackResp:interval	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   416: invokevirtual 21	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   419: ifeq +2263 -> 2682
    //   422: aload 13
    //   424: getfield 521	tencent/im/new_year_2021/FestivalPack$NewYearEvePackResp:interval	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   427: invokevirtual 25	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   430: istore_3
    //   431: aload 15
    //   433: getstatic 526	com/tencent/mobileqq/app/QQManagerFactory:SPRING_FESTIVAL_ENTRY_MANAGER	I
    //   436: invokevirtual 530	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   439: checkcast 532	com/tencent/mobileqq/activity/springfestival/entry/SpringFestivalEntryManager
    //   442: astore 15
    //   444: aload 15
    //   446: invokeinterface 537 1 0
    //   451: astore 16
    //   453: iload_3
    //   454: ifle +16 -> 470
    //   457: aload 16
    //   459: iload_3
    //   460: putfield 542	com/tencent/mobileqq/activity/springfestival/entry/model/UserData:grabReqInterval	I
    //   463: aload 15
    //   465: invokeinterface 544 1 0
    //   470: invokestatic 65	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   473: ifeq +43 -> 516
    //   476: ldc 67
    //   478: iconst_2
    //   479: new 69	java/lang/StringBuilder
    //   482: dup
    //   483: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   486: ldc_w 546
    //   489: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   492: aload 16
    //   494: getfield 542	com/tencent/mobileqq/activity/springfestival/entry/model/UserData:grabReqInterval	I
    //   497: invokevirtual 79	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   500: ldc_w 548
    //   503: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   506: iload_3
    //   507: invokevirtual 79	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   510: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   513: invokestatic 88	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   516: aload 13
    //   518: getfield 551	tencent/im/new_year_2021/FestivalPack$NewYearEvePackResp:share_forbidden	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   521: invokevirtual 21	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   524: ifeq +2163 -> 2687
    //   527: aload 13
    //   529: getfield 551	tencent/im/new_year_2021/FestivalPack$NewYearEvePackResp:share_forbidden	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   532: invokevirtual 25	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   535: istore_3
    //   536: aload 16
    //   538: iload_3
    //   539: invokevirtual 555	com/tencent/mobileqq/activity/springfestival/entry/model/UserData:setShareForbidden	(I)V
    //   542: invokestatic 65	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   545: ifeq +33 -> 578
    //   548: ldc 67
    //   550: iconst_2
    //   551: new 69	java/lang/StringBuilder
    //   554: dup
    //   555: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   558: ldc_w 557
    //   561: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   564: aload 16
    //   566: invokevirtual 560	com/tencent/mobileqq/activity/springfestival/entry/model/UserData:getShareForbidden	()I
    //   569: invokevirtual 79	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   572: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   575: invokestatic 88	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   578: aload_0
    //   579: aload 14
    //   581: aload_2
    //   582: invokespecial 562	com/tencent/mobileqq/portal/RedPacketServlet:a	(Ltencent/im/new_year_2021/Pack2021$Pack;Landroid/os/Bundle;)V
    //   585: iload 10
    //   587: istore 9
    //   589: goto +2075 -> 2664
    //   592: iconst_1
    //   593: istore 9
    //   595: aload_2
    //   596: ldc 111
    //   598: iconst_m1
    //   599: invokevirtual 286	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   602: aload_2
    //   603: ldc_w 290
    //   606: iconst_m1
    //   607: invokevirtual 286	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   610: goto +2054 -> 2664
    //   613: astore 13
    //   615: invokestatic 65	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   618: ifeq +13 -> 631
    //   621: ldc 67
    //   623: iconst_2
    //   624: ldc 47
    //   626: aload 13
    //   628: invokestatic 565	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   631: iconst_0
    //   632: istore 9
    //   634: goto -443 -> 191
    //   637: aload 15
    //   639: getstatic 568	com/tencent/mobileqq/app/QQManagerFactory:MGR_PORTAL	I
    //   642: invokevirtual 530	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   645: checkcast 570	com/tencent/mobileqq/portal/PortalManager
    //   648: astore 15
    //   650: new 572	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfigByPage
    //   653: dup
    //   654: invokespecial 573	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfigByPage:<init>	()V
    //   657: astore 16
    //   659: aload 16
    //   661: aload 13
    //   663: invokevirtual 574	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfigByPage:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   666: pop
    //   667: aload 16
    //   669: getfield 578	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfigByPage:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   672: invokevirtual 581	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   675: istore_3
    //   676: new 176	android/os/Bundle
    //   679: dup
    //   680: invokespecial 177	android/os/Bundle:<init>	()V
    //   683: astore_2
    //   684: iload_3
    //   685: ifeq +34 -> 719
    //   688: iconst_0
    //   689: istore 9
    //   691: aload 15
    //   693: invokevirtual 583	com/tencent/mobileqq/portal/PortalManager:b	()V
    //   696: aload_2
    //   697: ldc 119
    //   699: iconst_3
    //   700: invokevirtual 286	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   703: aload_0
    //   704: sipush 1004
    //   707: iconst_0
    //   708: iconst_0
    //   709: iconst_1
    //   710: iload_3
    //   711: iload 7
    //   713: invokespecial 585	com/tencent/mobileqq/portal/RedPacketServlet:a	(IIIIII)V
    //   716: goto +1976 -> 2692
    //   719: aload 16
    //   721: getfield 586	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfigByPage:type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   724: invokevirtual 25	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   727: sipush 1004
    //   730: if_icmpeq +22 -> 752
    //   733: aload_0
    //   734: sipush 1004
    //   737: iconst_0
    //   738: iconst_0
    //   739: iconst_1
    //   740: iconst_3
    //   741: iload 7
    //   743: invokespecial 585	com/tencent/mobileqq/portal/RedPacketServlet:a	(IIIIII)V
    //   746: iconst_0
    //   747: istore 9
    //   749: goto +1943 -> 2692
    //   752: aload_1
    //   753: ldc 113
    //   755: iconst_m1
    //   756: invokevirtual 427	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   759: istore_3
    //   760: aload 16
    //   762: getfield 590	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfigByPage:page_info	Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$PageRespInfo;
    //   765: invokevirtual 593	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$PageRespInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   768: checkcast 592	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$PageRespInfo
    //   771: getfield 596	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$PageRespInfo:version	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   774: invokevirtual 25	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   777: istore 4
    //   779: aload 16
    //   781: getfield 590	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfigByPage:page_info	Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$PageRespInfo;
    //   784: invokevirtual 593	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$PageRespInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   787: checkcast 592	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$PageRespInfo
    //   790: getfield 599	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$PageRespInfo:task_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   793: invokevirtual 25	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   796: istore 5
    //   798: aload_1
    //   799: ldc 157
    //   801: iconst_0
    //   802: invokevirtual 427	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   805: istore 8
    //   807: invokestatic 65	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   810: ifeq +1890 -> 2700
    //   813: ldc 67
    //   815: iconst_1
    //   816: new 69	java/lang/StringBuilder
    //   819: dup
    //   820: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   823: ldc_w 601
    //   826: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   829: iload 8
    //   831: invokevirtual 79	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   834: ldc 81
    //   836: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   839: iload_3
    //   840: invokevirtual 79	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   843: ldc 81
    //   845: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   848: iload 4
    //   850: invokevirtual 79	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   853: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   856: invokestatic 88	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   859: goto +1841 -> 2700
    //   862: aload 15
    //   864: invokevirtual 583	com/tencent/mobileqq/portal/PortalManager:b	()V
    //   867: aload_2
    //   868: ldc 119
    //   870: iconst_3
    //   871: invokevirtual 286	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   874: aload 16
    //   876: getfield 590	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfigByPage:page_info	Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$PageRespInfo;
    //   879: invokevirtual 593	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$PageRespInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   882: checkcast 592	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$PageRespInfo
    //   885: astore 17
    //   887: aload_1
    //   888: ldc 164
    //   890: invokevirtual 605	android/content/Intent:getByteArrayExtra	(Ljava/lang/String;)[B
    //   893: astore 13
    //   895: aload 16
    //   897: getfield 608	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfigByPage:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   900: invokevirtual 239	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   903: invokevirtual 503	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   906: astore 14
    //   908: aload 13
    //   910: ifnull +1825 -> 2735
    //   913: aload 13
    //   915: arraylength
    //   916: istore_3
    //   917: new 610	org/apache/http/util/ByteArrayBuffer
    //   920: dup
    //   921: iload_3
    //   922: aload 14
    //   924: arraylength
    //   925: iadd
    //   926: invokespecial 612	org/apache/http/util/ByteArrayBuffer:<init>	(I)V
    //   929: astore 18
    //   931: aload 13
    //   933: ifnull +14 -> 947
    //   936: aload 18
    //   938: aload 13
    //   940: iconst_0
    //   941: aload 13
    //   943: arraylength
    //   944: invokevirtual 614	org/apache/http/util/ByteArrayBuffer:append	([BII)V
    //   947: aload 18
    //   949: aload 14
    //   951: iconst_0
    //   952: aload 14
    //   954: arraylength
    //   955: invokevirtual 614	org/apache/http/util/ByteArrayBuffer:append	([BII)V
    //   958: aload 18
    //   960: invokevirtual 617	org/apache/http/util/ByteArrayBuffer:buffer	()[B
    //   963: astore 14
    //   965: aload 17
    //   967: getfield 620	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$PageRespInfo:next_offset	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   970: invokevirtual 581	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   973: istore_3
    //   974: iload_3
    //   975: iconst_m1
    //   976: if_icmpne +353 -> 1329
    //   979: aload 17
    //   981: getfield 623	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$PageRespInfo:md5	Lcom/tencent/mobileqq/pb/PBStringField;
    //   984: invokevirtual 45	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   987: astore 13
    //   989: aload 14
    //   991: invokestatic 628	com/tencent/mobileqq/portal/PortalUtils:a	([B)Ljava/lang/String;
    //   994: astore 18
    //   996: aload 17
    //   998: getfield 631	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$PageRespInfo:total_size	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1001: invokevirtual 25	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1004: istore_3
    //   1005: invokestatic 65	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1008: ifeq +49 -> 1057
    //   1011: ldc 67
    //   1013: iconst_1
    //   1014: new 69	java/lang/StringBuilder
    //   1017: dup
    //   1018: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   1021: ldc_w 601
    //   1024: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1027: iload_3
    //   1028: invokevirtual 79	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1031: ldc 81
    //   1033: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1036: aload 13
    //   1038: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1041: ldc 81
    //   1043: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1046: aload 18
    //   1048: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1051: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1054: invokestatic 88	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1057: iload 10
    //   1059: istore 9
    //   1061: iload_3
    //   1062: ifeq +1630 -> 2692
    //   1065: aload 18
    //   1067: aload 13
    //   1069: invokestatic 637	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   1072: ifeq +220 -> 1292
    //   1075: aload 14
    //   1077: astore 13
    //   1079: aload 17
    //   1081: getfield 640	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$PageRespInfo:compress	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1084: invokevirtual 25	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1087: iconst_1
    //   1088: if_icmpne +11 -> 1099
    //   1091: aload_0
    //   1092: aload 14
    //   1094: invokespecial 642	com/tencent/mobileqq/portal/RedPacketServlet:a	([B)[B
    //   1097: astore 13
    //   1099: aload 13
    //   1101: ifnonnull +39 -> 1140
    //   1104: aload_0
    //   1105: sipush 1004
    //   1108: iload 4
    //   1110: aload 16
    //   1112: getfield 590	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfigByPage:page_info	Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$PageRespInfo;
    //   1115: invokevirtual 593	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$PageRespInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1118: checkcast 592	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$PageRespInfo
    //   1121: getfield 599	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$PageRespInfo:task_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1124: invokevirtual 25	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1127: iconst_1
    //   1128: iconst_4
    //   1129: iconst_2
    //   1130: invokespecial 585	com/tencent/mobileqq/portal/RedPacketServlet:a	(IIIIII)V
    //   1133: iload 10
    //   1135: istore 9
    //   1137: goto +1555 -> 2692
    //   1140: aconst_null
    //   1141: astore 14
    //   1143: aload 16
    //   1145: getfield 646	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfigByPage:delay_time	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   1148: invokevirtual 649	com/tencent/mobileqq/pb/PBRepeatField:has	()Z
    //   1151: ifeq +16 -> 1167
    //   1154: aload 16
    //   1156: getfield 646	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfigByPage:delay_time	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   1159: invokevirtual 652	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   1162: checkcast 654	java/util/ArrayList
    //   1165: astore 14
    //   1167: new 656	java/lang/String
    //   1170: dup
    //   1171: aload 13
    //   1173: ldc_w 658
    //   1176: invokespecial 661	java/lang/String:<init>	([BLjava/lang/String;)V
    //   1179: iload 4
    //   1181: iload 5
    //   1183: aload 14
    //   1185: invokestatic 664	com/tencent/mobileqq/portal/PortalManager:a	(Ljava/lang/String;IILjava/util/ArrayList;)Lcom/tencent/mobileqq/portal/PortalManager$RedPacketConfig;
    //   1188: astore 13
    //   1190: aload 13
    //   1192: ifnonnull +39 -> 1231
    //   1195: aload_0
    //   1196: sipush 1004
    //   1199: iload 4
    //   1201: aload 16
    //   1203: getfield 590	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfigByPage:page_info	Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$PageRespInfo;
    //   1206: invokevirtual 593	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$PageRespInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1209: checkcast 592	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$PageRespInfo
    //   1212: getfield 599	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$PageRespInfo:task_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1215: invokevirtual 25	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1218: iconst_1
    //   1219: iconst_5
    //   1220: iload 7
    //   1222: invokespecial 585	com/tencent/mobileqq/portal/RedPacketServlet:a	(IIIIII)V
    //   1225: iconst_0
    //   1226: istore 9
    //   1228: goto +1464 -> 2692
    //   1231: aload_0
    //   1232: sipush 1004
    //   1235: iload 4
    //   1237: aload 16
    //   1239: getfield 590	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfigByPage:page_info	Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$PageRespInfo;
    //   1242: invokevirtual 593	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$PageRespInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1245: checkcast 592	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$PageRespInfo
    //   1248: getfield 599	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$PageRespInfo:task_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1251: invokevirtual 25	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1254: iconst_1
    //   1255: iconst_0
    //   1256: iconst_2
    //   1257: invokespecial 585	com/tencent/mobileqq/portal/RedPacketServlet:a	(IIIIII)V
    //   1260: aload 15
    //   1262: aload 13
    //   1264: invokevirtual 667	com/tencent/mobileqq/portal/PortalManager:a	(Lcom/tencent/mobileqq/portal/PortalManager$RedPacketConfig;)Lcom/tencent/mobileqq/portal/PortalManager$RedPacketConfig;
    //   1267: astore 13
    //   1269: aload_2
    //   1270: ldc 119
    //   1272: iconst_4
    //   1273: invokevirtual 286	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1276: aload_2
    //   1277: ldc_w 669
    //   1280: aload 13
    //   1282: invokevirtual 183	android/os/Bundle:putSerializable	(Ljava/lang/String;Ljava/io/Serializable;)V
    //   1285: iload 10
    //   1287: istore 9
    //   1289: goto +1403 -> 2692
    //   1292: iconst_0
    //   1293: istore 9
    //   1295: aload_0
    //   1296: sipush 1004
    //   1299: iload 4
    //   1301: aload 16
    //   1303: getfield 590	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfigByPage:page_info	Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$PageRespInfo;
    //   1306: invokevirtual 593	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$PageRespInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1309: checkcast 592	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$PageRespInfo
    //   1312: getfield 599	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$PageRespInfo:task_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1315: invokevirtual 25	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1318: iconst_1
    //   1319: bipush 6
    //   1321: iload 7
    //   1323: invokespecial 585	com/tencent/mobileqq/portal/RedPacketServlet:a	(IIIIII)V
    //   1326: goto +1366 -> 2692
    //   1329: iload_3
    //   1330: ifeq +1410 -> 2740
    //   1333: aload_0
    //   1334: invokevirtual 94	com/tencent/mobileqq/portal/RedPacketServlet:getAppRuntime	()Lmqq/app/AppRuntime;
    //   1337: iload 4
    //   1339: aload 17
    //   1341: getfield 620	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$PageRespInfo:next_offset	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1344: invokevirtual 581	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1347: aload 17
    //   1349: getfield 599	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$PageRespInfo:task_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1352: invokevirtual 25	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1355: aload 17
    //   1357: getfield 672	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$PageRespInfo:cookies	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1360: invokevirtual 239	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1363: invokevirtual 503	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   1366: aload 14
    //   1368: invokestatic 674	com/tencent/mobileqq/portal/RedPacketServlet:a	(Lmqq/app/AppRuntime;III[B[B)V
    //   1371: return
    //   1372: aload 15
    //   1374: aconst_null
    //   1375: invokevirtual 667	com/tencent/mobileqq/portal/PortalManager:a	(Lcom/tencent/mobileqq/portal/PortalManager$RedPacketConfig;)Lcom/tencent/mobileqq/portal/PortalManager$RedPacketConfig;
    //   1378: pop
    //   1379: aload_2
    //   1380: ldc 119
    //   1382: iconst_2
    //   1383: invokevirtual 286	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1386: iload 10
    //   1388: istore 9
    //   1390: goto +1302 -> 2692
    //   1393: iconst_1
    //   1394: istore 9
    //   1396: new 176	android/os/Bundle
    //   1399: dup
    //   1400: invokespecial 177	android/os/Bundle:<init>	()V
    //   1403: astore_2
    //   1404: ldc2_w 442
    //   1407: lstore 11
    //   1409: goto -1218 -> 191
    //   1412: new 176	android/os/Bundle
    //   1415: dup
    //   1416: invokespecial 177	android/os/Bundle:<init>	()V
    //   1419: astore_2
    //   1420: ldc2_w 442
    //   1423: lstore 11
    //   1425: iload 10
    //   1427: istore 9
    //   1429: goto -1238 -> 191
    //   1432: new 176	android/os/Bundle
    //   1435: dup
    //   1436: invokespecial 177	android/os/Bundle:<init>	()V
    //   1439: astore_2
    //   1440: ldc2_w 442
    //   1443: lstore 11
    //   1445: iload 10
    //   1447: istore 9
    //   1449: goto -1258 -> 191
    //   1452: new 176	android/os/Bundle
    //   1455: dup
    //   1456: invokespecial 177	android/os/Bundle:<init>	()V
    //   1459: astore_2
    //   1460: new 473	tencent/im/new_year_2021/Unisso$UniSsoServerRsp
    //   1463: dup
    //   1464: invokespecial 474	tencent/im/new_year_2021/Unisso$UniSsoServerRsp:<init>	()V
    //   1467: astore 14
    //   1469: aload 14
    //   1471: aload 13
    //   1473: invokevirtual 478	tencent/im/new_year_2021/Unisso$UniSsoServerRsp:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1476: pop
    //   1477: new 676	tencent/im/new_year_ranking/PackRanking$PkgResp
    //   1480: dup
    //   1481: invokespecial 677	tencent/im/new_year_ranking/PackRanking$PkgResp:<init>	()V
    //   1484: astore 16
    //   1486: aload 16
    //   1488: aload 14
    //   1490: getfield 502	tencent/im/new_year_2021/Unisso$UniSsoServerRsp:rspdata	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1493: invokevirtual 239	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1496: invokevirtual 503	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   1499: invokevirtual 678	tencent/im/new_year_ranking/PackRanking$PkgResp:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1502: pop
    //   1503: aload 16
    //   1505: getfield 681	tencent/im/new_year_ranking/PackRanking$PkgResp:retcode	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1508: invokevirtual 25	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1511: istore_3
    //   1512: aload_2
    //   1513: ldc 119
    //   1515: iload_3
    //   1516: invokevirtual 286	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1519: aload_2
    //   1520: ldc 147
    //   1522: aload_1
    //   1523: ldc 147
    //   1525: iconst_m1
    //   1526: invokevirtual 427	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   1529: invokevirtual 286	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1532: aload_2
    //   1533: ldc 149
    //   1535: aload_1
    //   1536: ldc 149
    //   1538: iconst_m1
    //   1539: invokevirtual 427	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   1542: invokevirtual 286	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1545: iload_3
    //   1546: ifne +1106 -> 2652
    //   1549: aconst_null
    //   1550: astore 14
    //   1552: aconst_null
    //   1553: astore 13
    //   1555: aload 16
    //   1557: getfield 685	tencent/im/new_year_ranking/PackRanking$PkgResp:query_ranking	Ltencent/im/new_year_ranking/PackRanking$QueryRankingResp;
    //   1560: invokevirtual 688	tencent/im/new_year_ranking/PackRanking$QueryRankingResp:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1563: checkcast 687	tencent/im/new_year_ranking/PackRanking$QueryRankingResp
    //   1566: astore 16
    //   1568: aload 16
    //   1570: getfield 692	tencent/im/new_year_ranking/PackRanking$QueryRankingResp:rank_swipe	Ltencent/im/new_year_ranking/PackRanking$RankingInfo;
    //   1573: invokevirtual 695	tencent/im/new_year_ranking/PackRanking$RankingInfo:has	()Z
    //   1576: ifeq +16 -> 1592
    //   1579: aload 16
    //   1581: getfield 692	tencent/im/new_year_ranking/PackRanking$QueryRankingResp:rank_swipe	Ltencent/im/new_year_ranking/PackRanking$RankingInfo;
    //   1584: invokevirtual 696	tencent/im/new_year_ranking/PackRanking$RankingInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1587: checkcast 694	tencent/im/new_year_ranking/PackRanking$RankingInfo
    //   1590: astore 14
    //   1592: aload 16
    //   1594: getfield 699	tencent/im/new_year_ranking/PackRanking$QueryRankingResp:rank_combo	Ltencent/im/new_year_ranking/PackRanking$RankingInfo;
    //   1597: invokevirtual 695	tencent/im/new_year_ranking/PackRanking$RankingInfo:has	()Z
    //   1600: ifeq +16 -> 1616
    //   1603: aload 16
    //   1605: getfield 699	tencent/im/new_year_ranking/PackRanking$QueryRankingResp:rank_combo	Ltencent/im/new_year_ranking/PackRanking$RankingInfo;
    //   1608: invokevirtual 696	tencent/im/new_year_ranking/PackRanking$RankingInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1611: checkcast 694	tencent/im/new_year_ranking/PackRanking$RankingInfo
    //   1614: astore 13
    //   1616: new 701	org/json/JSONObject
    //   1619: dup
    //   1620: invokespecial 702	org/json/JSONObject:<init>	()V
    //   1623: astore 16
    //   1625: aload 16
    //   1627: ldc_w 704
    //   1630: iload_3
    //   1631: invokevirtual 708	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1634: pop
    //   1635: aload_0
    //   1636: invokevirtual 94	com/tencent/mobileqq/portal/RedPacketServlet:getAppRuntime	()Lmqq/app/AppRuntime;
    //   1639: invokevirtual 135	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   1642: astore 17
    //   1644: aload 14
    //   1646: ifnull +275 -> 1921
    //   1649: new 701	org/json/JSONObject
    //   1652: dup
    //   1653: invokespecial 702	org/json/JSONObject:<init>	()V
    //   1656: astore 18
    //   1658: aload 18
    //   1660: ldc_w 710
    //   1663: aload 17
    //   1665: aload 14
    //   1667: getfield 711	tencent/im/new_year_ranking/PackRanking$RankingInfo:uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1670: invokevirtual 32	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   1673: invokestatic 714	com/tencent/mobileqq/portal/PortalUtils:a	(Ljava/lang/String;J)Ljava/lang/String;
    //   1676: invokevirtual 717	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1679: pop
    //   1680: aload 18
    //   1682: ldc_w 719
    //   1685: aload 14
    //   1687: getfield 721	tencent/im/new_year_ranking/PackRanking$RankingInfo:ranking	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1690: invokevirtual 25	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1693: invokevirtual 708	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1696: pop
    //   1697: aload 18
    //   1699: ldc_w 723
    //   1702: aload 14
    //   1704: getfield 725	tencent/im/new_year_ranking/PackRanking$RankingInfo:count	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1707: invokevirtual 25	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1710: invokevirtual 708	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1713: pop
    //   1714: aload 18
    //   1716: ldc_w 727
    //   1719: aload 15
    //   1721: invokevirtual 730	com/tencent/mobileqq/app/QQAppInterface:getCurrentNickname	()Ljava/lang/String;
    //   1724: invokevirtual 717	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1727: pop
    //   1728: aload 16
    //   1730: ldc_w 732
    //   1733: aload 18
    //   1735: invokevirtual 717	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1738: pop
    //   1739: aload 14
    //   1741: getfield 736	tencent/im/new_year_ranking/PackRanking$RankingInfo:elems	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   1744: invokevirtual 739	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   1747: ifeq +174 -> 1921
    //   1750: aload 14
    //   1752: getfield 736	tencent/im/new_year_ranking/PackRanking$RankingInfo:elems	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   1755: invokevirtual 740	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   1758: astore 18
    //   1760: aload 18
    //   1762: invokeinterface 745 1 0
    //   1767: ifle +154 -> 1921
    //   1770: new 747	org/json/JSONArray
    //   1773: dup
    //   1774: invokespecial 748	org/json/JSONArray:<init>	()V
    //   1777: astore 14
    //   1779: aload 18
    //   1781: invokeinterface 752 1 0
    //   1786: astore 18
    //   1788: iconst_0
    //   1789: istore_3
    //   1790: aload 18
    //   1792: invokeinterface 757 1 0
    //   1797: ifeq +113 -> 1910
    //   1800: aload 18
    //   1802: invokeinterface 761 1 0
    //   1807: checkcast 763	tencent/im/new_year_ranking/PackRanking$RankingElem
    //   1810: astore 19
    //   1812: iload_3
    //   1813: iconst_1
    //   1814: iadd
    //   1815: istore_3
    //   1816: new 701	org/json/JSONObject
    //   1819: dup
    //   1820: invokespecial 702	org/json/JSONObject:<init>	()V
    //   1823: astore 20
    //   1825: aload 20
    //   1827: ldc_w 710
    //   1830: aload 17
    //   1832: aload 19
    //   1834: getfield 764	tencent/im/new_year_ranking/PackRanking$RankingElem:uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1837: invokevirtual 32	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   1840: invokestatic 714	com/tencent/mobileqq/portal/PortalUtils:a	(Ljava/lang/String;J)Ljava/lang/String;
    //   1843: invokevirtual 717	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1846: pop
    //   1847: aload 20
    //   1849: ldc_w 719
    //   1852: iload_3
    //   1853: invokevirtual 708	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1856: pop
    //   1857: aload 20
    //   1859: ldc_w 723
    //   1862: aload 19
    //   1864: getfield 765	tencent/im/new_year_ranking/PackRanking$RankingElem:count	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1867: invokevirtual 25	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1870: invokevirtual 708	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1873: pop
    //   1874: aload 20
    //   1876: ldc_w 727
    //   1879: aload 15
    //   1881: aload 19
    //   1883: getfield 764	tencent/im/new_year_ranking/PackRanking$RankingElem:uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1886: invokevirtual 32	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   1889: invokestatic 768	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1892: invokestatic 774	com/tencent/mobileqq/utils/ContactUtils:j	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)Ljava/lang/String;
    //   1895: invokevirtual 717	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1898: pop
    //   1899: aload 14
    //   1901: aload 20
    //   1903: invokevirtual 777	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   1906: pop
    //   1907: goto -117 -> 1790
    //   1910: aload 16
    //   1912: ldc_w 779
    //   1915: aload 14
    //   1917: invokevirtual 717	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1920: pop
    //   1921: aload 13
    //   1923: ifnull +275 -> 2198
    //   1926: new 701	org/json/JSONObject
    //   1929: dup
    //   1930: invokespecial 702	org/json/JSONObject:<init>	()V
    //   1933: astore 14
    //   1935: aload 14
    //   1937: ldc_w 710
    //   1940: aload 17
    //   1942: aload 13
    //   1944: getfield 711	tencent/im/new_year_ranking/PackRanking$RankingInfo:uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1947: invokevirtual 32	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   1950: invokestatic 714	com/tencent/mobileqq/portal/PortalUtils:a	(Ljava/lang/String;J)Ljava/lang/String;
    //   1953: invokevirtual 717	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1956: pop
    //   1957: aload 14
    //   1959: ldc_w 719
    //   1962: aload 13
    //   1964: getfield 721	tencent/im/new_year_ranking/PackRanking$RankingInfo:ranking	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1967: invokevirtual 25	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1970: invokevirtual 708	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1973: pop
    //   1974: aload 14
    //   1976: ldc_w 723
    //   1979: aload 13
    //   1981: getfield 725	tencent/im/new_year_ranking/PackRanking$RankingInfo:count	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1984: invokevirtual 25	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1987: invokevirtual 708	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1990: pop
    //   1991: aload 14
    //   1993: ldc_w 727
    //   1996: aload 15
    //   1998: invokevirtual 730	com/tencent/mobileqq/app/QQAppInterface:getCurrentNickname	()Ljava/lang/String;
    //   2001: invokevirtual 717	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2004: pop
    //   2005: aload 16
    //   2007: ldc_w 781
    //   2010: aload 14
    //   2012: invokevirtual 717	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2015: pop
    //   2016: aload 13
    //   2018: getfield 736	tencent/im/new_year_ranking/PackRanking$RankingInfo:elems	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   2021: invokevirtual 739	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   2024: ifeq +174 -> 2198
    //   2027: aload 13
    //   2029: getfield 736	tencent/im/new_year_ranking/PackRanking$RankingInfo:elems	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   2032: invokevirtual 740	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   2035: astore 14
    //   2037: aload 14
    //   2039: invokeinterface 745 1 0
    //   2044: ifle +154 -> 2198
    //   2047: new 747	org/json/JSONArray
    //   2050: dup
    //   2051: invokespecial 748	org/json/JSONArray:<init>	()V
    //   2054: astore 13
    //   2056: aload 14
    //   2058: invokeinterface 752 1 0
    //   2063: astore 14
    //   2065: iconst_0
    //   2066: istore_3
    //   2067: aload 14
    //   2069: invokeinterface 757 1 0
    //   2074: ifeq +113 -> 2187
    //   2077: aload 14
    //   2079: invokeinterface 761 1 0
    //   2084: checkcast 763	tencent/im/new_year_ranking/PackRanking$RankingElem
    //   2087: astore 18
    //   2089: iload_3
    //   2090: iconst_1
    //   2091: iadd
    //   2092: istore_3
    //   2093: new 701	org/json/JSONObject
    //   2096: dup
    //   2097: invokespecial 702	org/json/JSONObject:<init>	()V
    //   2100: astore 19
    //   2102: aload 19
    //   2104: ldc_w 710
    //   2107: aload 17
    //   2109: aload 18
    //   2111: getfield 764	tencent/im/new_year_ranking/PackRanking$RankingElem:uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   2114: invokevirtual 32	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   2117: invokestatic 714	com/tencent/mobileqq/portal/PortalUtils:a	(Ljava/lang/String;J)Ljava/lang/String;
    //   2120: invokevirtual 717	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2123: pop
    //   2124: aload 19
    //   2126: ldc_w 719
    //   2129: iload_3
    //   2130: invokevirtual 708	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   2133: pop
    //   2134: aload 19
    //   2136: ldc_w 723
    //   2139: aload 18
    //   2141: getfield 765	tencent/im/new_year_ranking/PackRanking$RankingElem:count	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2144: invokevirtual 25	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2147: invokevirtual 708	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   2150: pop
    //   2151: aload 19
    //   2153: ldc_w 727
    //   2156: aload 15
    //   2158: aload 18
    //   2160: getfield 764	tencent/im/new_year_ranking/PackRanking$RankingElem:uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   2163: invokevirtual 32	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   2166: invokestatic 768	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   2169: invokestatic 774	com/tencent/mobileqq/utils/ContactUtils:j	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)Ljava/lang/String;
    //   2172: invokevirtual 717	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2175: pop
    //   2176: aload 13
    //   2178: aload 19
    //   2180: invokevirtual 777	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   2183: pop
    //   2184: goto -117 -> 2067
    //   2187: aload 16
    //   2189: ldc_w 783
    //   2192: aload 13
    //   2194: invokevirtual 717	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2197: pop
    //   2198: aload_2
    //   2199: ldc_w 785
    //   2202: aload 16
    //   2204: invokevirtual 786	org/json/JSONObject:toString	()Ljava/lang/String;
    //   2207: invokevirtual 313	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   2210: ldc2_w 442
    //   2213: lstore 11
    //   2215: iload 10
    //   2217: istore 9
    //   2219: goto -2028 -> 191
    //   2222: new 176	android/os/Bundle
    //   2225: dup
    //   2226: invokespecial 177	android/os/Bundle:<init>	()V
    //   2229: astore 13
    //   2231: aload_1
    //   2232: ldc 115
    //   2234: iconst_m1
    //   2235: invokevirtual 427	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   2238: istore 8
    //   2240: iconst_m1
    //   2241: istore 4
    //   2243: iload 4
    //   2245: istore_3
    //   2246: new 788	tencent/im/cs/cmd0x6ff/subcmd0x501$RspBody
    //   2249: dup
    //   2250: invokespecial 789	tencent/im/cs/cmd0x6ff/subcmd0x501$RspBody:<init>	()V
    //   2253: astore 14
    //   2255: iload 4
    //   2257: istore_3
    //   2258: aload_2
    //   2259: invokevirtual 446	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   2262: invokestatic 795	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   2265: astore_2
    //   2266: iload 4
    //   2268: istore_3
    //   2269: aload_2
    //   2270: invokevirtual 798	java/nio/ByteBuffer:getInt	()I
    //   2273: iconst_4
    //   2274: isub
    //   2275: newarray byte
    //   2277: astore 16
    //   2279: iload 4
    //   2281: istore_3
    //   2282: aload_2
    //   2283: aload 16
    //   2285: invokevirtual 800	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   2288: pop
    //   2289: iload 4
    //   2291: istore_3
    //   2292: aload 14
    //   2294: aload 16
    //   2296: invokevirtual 801	tencent/im/cs/cmd0x6ff/subcmd0x501$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2299: pop
    //   2300: iload 4
    //   2302: istore_3
    //   2303: aload 14
    //   2305: getfield 805	tencent/im/cs/cmd0x6ff/subcmd0x501$RspBody:msg_subcmd_0x501_rsp_body	Ltencent/im/cs/cmd0x6ff/subcmd0x501$SubCmd0x501Rspbody;
    //   2308: invokevirtual 808	tencent/im/cs/cmd0x6ff/subcmd0x501$SubCmd0x501Rspbody:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2311: checkcast 807	tencent/im/cs/cmd0x6ff/subcmd0x501$SubCmd0x501Rspbody
    //   2314: astore_2
    //   2315: iload 4
    //   2317: istore_3
    //   2318: aload_2
    //   2319: getfield 811	tencent/im/cs/cmd0x6ff/subcmd0x501$SubCmd0x501Rspbody:uint32_share_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2322: invokevirtual 25	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2325: istore 4
    //   2327: iload 4
    //   2329: istore_3
    //   2330: aload_2
    //   2331: getfield 814	tencent/im/cs/cmd0x6ff/subcmd0x501$SubCmd0x501Rspbody:uint32_share_channel	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2334: invokevirtual 25	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2337: istore 5
    //   2339: iload 5
    //   2341: istore_3
    //   2342: iload 4
    //   2344: istore 5
    //   2346: iload_3
    //   2347: istore 4
    //   2349: aload 15
    //   2351: getstatic 568	com/tencent/mobileqq/app/QQManagerFactory:MGR_PORTAL	I
    //   2354: invokevirtual 530	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   2357: checkcast 570	com/tencent/mobileqq/portal/PortalManager
    //   2360: astore_2
    //   2361: aload_2
    //   2362: ifnull +11 -> 2373
    //   2365: aload_2
    //   2366: iload 8
    //   2368: iload 5
    //   2370: invokevirtual 817	com/tencent/mobileqq/portal/PortalManager:a	(II)V
    //   2373: aload 13
    //   2375: ldc_w 819
    //   2378: iload 5
    //   2380: invokevirtual 286	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   2383: aload 13
    //   2385: ldc_w 821
    //   2388: iload 4
    //   2390: invokevirtual 286	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   2393: invokestatic 65	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2396: ifeq +241 -> 2637
    //   2399: ldc 67
    //   2401: iconst_2
    //   2402: new 69	java/lang/StringBuilder
    //   2405: dup
    //   2406: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   2409: ldc_w 823
    //   2412: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2415: iload 5
    //   2417: invokevirtual 79	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2420: ldc_w 825
    //   2423: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2426: iload 4
    //   2428: invokevirtual 79	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2431: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2434: invokestatic 828	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2437: aload 13
    //   2439: astore_2
    //   2440: ldc2_w 442
    //   2443: lstore 11
    //   2445: iload 10
    //   2447: istore 9
    //   2449: goto -2258 -> 191
    //   2452: astore_2
    //   2453: invokestatic 65	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2456: ifeq +13 -> 2469
    //   2459: ldc 67
    //   2461: iconst_2
    //   2462: aload_2
    //   2463: invokevirtual 831	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2466: invokestatic 88	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2469: iconst_0
    //   2470: istore 4
    //   2472: iload_3
    //   2473: istore 5
    //   2475: goto -126 -> 2349
    //   2478: iload 6
    //   2480: iconst_2
    //   2481: if_icmpne +16 -> 2497
    //   2484: aload_0
    //   2485: sipush 1004
    //   2488: iconst_0
    //   2489: iconst_0
    //   2490: iconst_1
    //   2491: iconst_1
    //   2492: iload 7
    //   2494: invokespecial 585	com/tencent/mobileqq/portal/RedPacketServlet:a	(IIIIII)V
    //   2497: aconst_null
    //   2498: astore_2
    //   2499: iload 10
    //   2501: istore 9
    //   2503: goto -2312 -> 191
    //   2506: aload_0
    //   2507: invokevirtual 94	com/tencent/mobileqq/portal/RedPacketServlet:getAppRuntime	()Lmqq/app/AppRuntime;
    //   2510: aload_1
    //   2511: checkcast 90	mqq/app/NewIntent
    //   2514: invokevirtual 123	mqq/app/AppRuntime:startServlet	(Lmqq/app/NewIntent;)V
    //   2517: return
    //   2518: aload_2
    //   2519: astore 13
    //   2521: aload_2
    //   2522: ifnonnull +12 -> 2534
    //   2525: new 176	android/os/Bundle
    //   2528: dup
    //   2529: invokespecial 177	android/os/Bundle:<init>	()V
    //   2532: astore 13
    //   2534: iload 6
    //   2536: iconst_1
    //   2537: if_icmpne +13 -> 2550
    //   2540: aload 13
    //   2542: ldc_w 833
    //   2545: lload 11
    //   2547: invokevirtual 305	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   2550: invokestatic 65	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2553: ifeq +30 -> 2583
    //   2556: ldc 67
    //   2558: iconst_2
    //   2559: new 69	java/lang/StringBuilder
    //   2562: dup
    //   2563: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   2566: ldc_w 835
    //   2569: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2572: aload 13
    //   2574: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2577: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2580: invokestatic 88	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2583: aload_0
    //   2584: aload_1
    //   2585: iload 6
    //   2587: iload 9
    //   2589: aload 13
    //   2591: ldc_w 837
    //   2594: invokevirtual 841	com/tencent/mobileqq/portal/RedPacketServlet:notifyObserver	(Landroid/content/Intent;IZLandroid/os/Bundle;Ljava/lang/Class;)V
    //   2597: return
    //   2598: astore 13
    //   2600: ldc2_w 442
    //   2603: lstore 11
    //   2605: aconst_null
    //   2606: astore_2
    //   2607: goto -1992 -> 615
    //   2610: astore 13
    //   2612: ldc2_w 442
    //   2615: lstore 11
    //   2617: goto -2002 -> 615
    //   2620: astore 14
    //   2622: aload 13
    //   2624: astore_2
    //   2625: ldc2_w 442
    //   2628: lstore 11
    //   2630: aload 14
    //   2632: astore 13
    //   2634: goto -2019 -> 615
    //   2637: aload 13
    //   2639: astore_2
    //   2640: ldc2_w 442
    //   2643: lstore 11
    //   2645: iload 10
    //   2647: istore 9
    //   2649: goto -2458 -> 191
    //   2652: ldc2_w 442
    //   2655: lstore 11
    //   2657: iload 10
    //   2659: istore 9
    //   2661: goto -2470 -> 191
    //   2664: goto -2473 -> 191
    //   2667: ldc2_w 842
    //   2670: lstore 11
    //   2672: goto -2385 -> 287
    //   2675: ldc 47
    //   2677: astore 13
    //   2679: goto -2371 -> 308
    //   2682: iconst_0
    //   2683: istore_3
    //   2684: goto -2253 -> 431
    //   2687: iconst_m1
    //   2688: istore_3
    //   2689: goto -2153 -> 536
    //   2692: ldc2_w 442
    //   2695: lstore 11
    //   2697: goto -2506 -> 191
    //   2700: iload 8
    //   2702: ifne +9 -> 2711
    //   2705: iload_3
    //   2706: iload 4
    //   2708: if_icmpne -1846 -> 862
    //   2711: iload 8
    //   2713: ifeq -1341 -> 1372
    //   2716: iload_3
    //   2717: iload 4
    //   2719: if_icmpne -1347 -> 1372
    //   2722: goto -1860 -> 862
    //   2725: astore 13
    //   2727: ldc2_w 442
    //   2730: lstore 11
    //   2732: goto -2117 -> 615
    //   2735: iconst_0
    //   2736: istore_3
    //   2737: goto -1820 -> 917
    //   2740: iconst_0
    //   2741: istore 9
    //   2743: goto -51 -> 2692
    //   2746: astore 13
    //   2748: ldc2_w 442
    //   2751: lstore 11
    //   2753: goto -2138 -> 615
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2756	0	this	RedPacketServlet
    //   0	2756	1	paramIntent	Intent
    //   0	2756	2	paramFromServiceMsg	com.tencent.qphone.base.remote.FromServiceMsg
    //   430	2307	3	i	int
    //   777	1943	4	j	int
    //   796	1678	5	k	int
    //   22	2564	6	m	int
    //   65	2428	7	n	int
    //   805	1907	8	i1	int
    //   189	2553	9	bool1	boolean
    //   71	2587	10	bool2	boolean
    //   109	2643	11	l	long
    //   123	405	13	localObject1	Object
    //   613	49	13	localThrowable1	Throwable
    //   893	1697	13	localObject2	Object
    //   2598	1	13	localThrowable2	Throwable
    //   2610	13	13	localThrowable3	Throwable
    //   2632	46	13	localObject3	Object
    //   2725	1	13	localThrowable4	Throwable
    //   2746	1	13	localThrowable5	Throwable
    //   256	2048	14	localObject4	Object
    //   2620	11	14	localThrowable6	Throwable
    //   7	2343	15	localObject5	Object
    //   451	1844	16	localObject6	Object
    //   885	1223	17	localObject7	Object
    //   929	1230	18	localObject8	Object
    //   1810	369	19	localObject9	Object
    //   1823	79	20	localJSONObject	org.json.JSONObject
    // Exception table:
    //   from	to	target	type
    //   287	308	613	java/lang/Throwable
    //   308	352	613	java/lang/Throwable
    //   359	431	613	java/lang/Throwable
    //   431	453	613	java/lang/Throwable
    //   457	470	613	java/lang/Throwable
    //   470	516	613	java/lang/Throwable
    //   516	536	613	java/lang/Throwable
    //   536	578	613	java/lang/Throwable
    //   578	585	613	java/lang/Throwable
    //   595	610	613	java/lang/Throwable
    //   2246	2255	2452	java/lang/Exception
    //   2258	2266	2452	java/lang/Exception
    //   2269	2279	2452	java/lang/Exception
    //   2282	2289	2452	java/lang/Exception
    //   2292	2300	2452	java/lang/Exception
    //   2303	2315	2452	java/lang/Exception
    //   2318	2327	2452	java/lang/Exception
    //   2330	2339	2452	java/lang/Exception
    //   241	249	2598	java/lang/Throwable
    //   637	684	2598	java/lang/Throwable
    //   1396	1404	2598	java/lang/Throwable
    //   1412	1420	2598	java/lang/Throwable
    //   1432	1440	2598	java/lang/Throwable
    //   1452	1460	2598	java/lang/Throwable
    //   2222	2231	2598	java/lang/Throwable
    //   249	287	2610	java/lang/Throwable
    //   2231	2240	2620	java/lang/Throwable
    //   2246	2255	2620	java/lang/Throwable
    //   2258	2266	2620	java/lang/Throwable
    //   2269	2279	2620	java/lang/Throwable
    //   2282	2289	2620	java/lang/Throwable
    //   2292	2300	2620	java/lang/Throwable
    //   2303	2315	2620	java/lang/Throwable
    //   2318	2327	2620	java/lang/Throwable
    //   2330	2339	2620	java/lang/Throwable
    //   2349	2361	2620	java/lang/Throwable
    //   2365	2373	2620	java/lang/Throwable
    //   2373	2437	2620	java/lang/Throwable
    //   2453	2469	2620	java/lang/Throwable
    //   691	716	2725	java/lang/Throwable
    //   719	746	2725	java/lang/Throwable
    //   752	859	2725	java/lang/Throwable
    //   862	908	2725	java/lang/Throwable
    //   913	917	2725	java/lang/Throwable
    //   917	931	2725	java/lang/Throwable
    //   936	947	2725	java/lang/Throwable
    //   947	974	2725	java/lang/Throwable
    //   979	1057	2725	java/lang/Throwable
    //   1065	1075	2725	java/lang/Throwable
    //   1079	1099	2725	java/lang/Throwable
    //   1104	1133	2725	java/lang/Throwable
    //   1143	1167	2725	java/lang/Throwable
    //   1167	1190	2725	java/lang/Throwable
    //   1195	1225	2725	java/lang/Throwable
    //   1231	1285	2725	java/lang/Throwable
    //   1295	1326	2725	java/lang/Throwable
    //   1333	1371	2725	java/lang/Throwable
    //   1372	1386	2725	java/lang/Throwable
    //   1460	1545	2746	java/lang/Throwable
    //   1555	1568	2746	java/lang/Throwable
    //   1568	1592	2746	java/lang/Throwable
    //   1592	1616	2746	java/lang/Throwable
    //   1616	1644	2746	java/lang/Throwable
    //   1649	1788	2746	java/lang/Throwable
    //   1790	1812	2746	java/lang/Throwable
    //   1816	1907	2746	java/lang/Throwable
    //   1910	1921	2746	java/lang/Throwable
    //   1926	2065	2746	java/lang/Throwable
    //   2067	2089	2746	java/lang/Throwable
    //   2093	2184	2746	java/lang/Throwable
    //   2187	2198	2746	java/lang/Throwable
    //   2198	2210	2746	java/lang/Throwable
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    int i = paramIntent.getIntExtra("k_cmd", -1);
    int j = paramIntent.getIntExtra("k_retry", 0);
    boolean bool = paramIntent.getBooleanExtra("k_new_page", false);
    Object localObject3 = null;
    Object localObject4 = null;
    Object localObject1;
    Object localObject2;
    if ((j == 0) || (bool))
    {
      localObject1 = localObject4;
      localObject2 = localObject3;
      switch (i)
      {
      default: 
        localObject2 = localObject3;
        localObject1 = localObject4;
      case 3: 
      case 5: 
      case 6: 
        localObject3 = localObject1;
        localObject4 = localObject2;
        if (localObject2 != null)
        {
          localObject3 = localObject1;
          localObject4 = localObject2;
          if (!bool)
          {
            paramIntent.putExtra("k_sso_id", (String)localObject2);
            paramIntent.putExtra("k_sso_data", (byte[])localObject1);
            localObject4 = localObject2;
            localObject3 = localObject1;
          }
        }
        break;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RedPacketServlet", 2, "onSend, " + i + ", " + j + ", " + bool + ", " + (String)localObject4 + ", " + localObject3);
      }
      if ((localObject4 != null) && (localObject3 != null))
      {
        paramPacket.setSSOCommand((String)localObject4);
        paramPacket.putSendData((byte[])localObject3);
      }
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              localObject1 = new Unisso.UniSsoServerReq();
              localObject2 = new FestivalPack.PkgReq();
              k = paramIntent.getIntExtra("k_condition", 0);
              int m = paramIntent.getIntExtra("k_id", 0);
              if (QLog.isColorLevel()) {
                QLog.d("RedPacketServlet", 2, "onSend CMD_RESULT promotionID = " + m + ",condition = " + k);
              }
              localObject3 = new FestivalPack.NewYearEvePackReq();
              ((FestivalPack.NewYearEvePackReq)localObject3).promotion_id.set(m);
              ((FestivalPack.NewYearEvePackReq)localObject3).action.set(1);
              ((FestivalPack.NewYearEvePackReq)localObject3).condition.set(k);
              ((FestivalPack.PkgReq)localObject2).cmdtype.set(1);
              ((FestivalPack.PkgReq)localObject2).from_id.set(1);
              ((FestivalPack.PkgReq)localObject2).get_eve_pack.set((MessageMicro)localObject3);
              localObject3 = new Unisso.UniSsoServerReqComm();
              ((Unisso.UniSsoServerReqComm)localObject3).mqqver.set("8.5.5");
              ((Unisso.UniSsoServerReqComm)localObject3).platform.set(109L);
              ((Unisso.UniSsoServerReqComm)localObject3).osver.set(Build.VERSION.RELEASE);
              ((Unisso.UniSsoServerReq)localObject1).comm.set((MessageMicro)localObject3);
              ((Unisso.UniSsoServerReq)localObject1).reqdata.set(ByteStringMicro.copyFrom(((FestivalPack.PkgReq)localObject2).toByteArray()));
              localObject1 = WupUtil.a(((Unisso.UniSsoServerReq)localObject1).toByteArray());
              localObject2 = "NY2021Lottery.shua";
              paramIntent.putExtra("k_retry", 2);
              break;
              k = paramIntent.getIntExtra("k_id", 0);
              m = paramIntent.getIntExtra("k_offset", 0);
              int n = paramIntent.getIntExtra("k_version", 0);
              localObject2 = paramIntent.getByteArrayExtra("k_cookie");
              localObject1 = new ConfigurationService.ReqGetConfigByPage();
              localObject3 = new ConfigurationService.PageReqInfo();
              ((ConfigurationService.PageReqInfo)localObject3).task_id.set(k);
              ((ConfigurationService.PageReqInfo)localObject3).offset.set(m);
              ((ConfigurationService.PageReqInfo)localObject3).version.set(n);
              if (localObject2 != null) {
                ((ConfigurationService.PageReqInfo)localObject3).cookies.set(ByteStringMicro.copyFrom((byte[])localObject2));
              }
              ((ConfigurationService.ReqGetConfigByPage)localObject1).page_info.set((MessageMicro)localObject3);
              localObject2 = new ConfigurationService.DeviceInfo();
              localObject3 = new ConfigurationService.Screen();
              ((ConfigurationService.Screen)localObject3).setHasFlag(true);
              ((ConfigurationService.Screen)localObject3).model.set("");
              ((ConfigurationService.Screen)localObject3).width.set((int)DeviceInfoUtil.g());
              ((ConfigurationService.Screen)localObject3).height.set((int)DeviceInfoUtil.h());
              ((ConfigurationService.Screen)localObject3).dpi.set(DeviceInfoUtil.e());
              ((ConfigurationService.Screen)localObject3).multi_touch.set(DeviceInfoUtil.c());
              ((ConfigurationService.DeviceInfo)localObject2).setHasFlag(true);
              ((ConfigurationService.DeviceInfo)localObject2).screen = ((ConfigurationService.Screen)localObject3);
              ((ConfigurationService.ReqGetConfigByPage)localObject1).device_info.set((MessageMicro)localObject2);
              ((ConfigurationService.ReqGetConfigByPage)localObject1).type.set(1004);
              localObject1 = WupUtil.a(((ConfigurationService.ReqGetConfigByPage)localObject1).toByteArray());
              localObject2 = "ConfigurationService.ReqGetConfigByPage";
              break;
              localObject1 = new ConfigurationService.ReqReportConfig();
              localObject2 = new ConfigurationService.ReportConfig();
              ((ConfigurationService.ReportConfig)localObject2).type.set(paramIntent.getIntExtra("k_type", -1));
              ((ConfigurationService.ReportConfig)localObject2).task_id.set(paramIntent.getIntExtra("k_id", -1));
              ((ConfigurationService.ReportConfig)localObject2).version.set(paramIntent.getIntExtra("k_version", -1));
              ((ConfigurationService.ReportConfig)localObject2).report_type.set(paramIntent.getIntExtra("k_opt", -1));
              ((ConfigurationService.ReportConfig)localObject2).result.set(paramIntent.getIntExtra("k_code", -1));
              ((ConfigurationService.ReqReportConfig)localObject1).config_list.add((MessageMicro)localObject2);
              localObject2 = "ConfigurationService.ReqReportConfig";
              localObject1 = WupUtil.a(((ConfigurationService.ReqReportConfig)localObject1).toByteArray());
              paramIntent.putExtra("k_retry", 2);
              break;
              localObject1 = new Unisso.UniSsoServerReq();
              localObject2 = new PackReport.PkgReq();
              ((PackReport.PkgReq)localObject2).promotion_id.set(paramIntent.getIntExtra("k_id", -1));
              ((PackReport.PkgReq)localObject2).uin.set(Long.valueOf(paramIntent.getStringExtra("k_uin")).longValue());
              l2 = paramIntent.getLongExtra("key_seq", -1L);
              l1 = l2;
              if (l2 == -1L)
              {
                l1 = NetConnInfoCenter.getServerTimeMillis();
                paramIntent.putExtra("key_seq", l1);
              }
              ((PackReport.PkgReq)localObject2).seq.set(l1);
              localObject3 = paramIntent.getExtras();
            } while (localObject3 == null);
            localObject6 = (ArrayList)((Bundle)localObject3).getSerializable("k_b_list");
          } while (localObject6 == null);
          localObject4 = new ArrayList();
          localObject5 = new PackReport.Report();
          Object localObject6 = ((ArrayList)localObject6).iterator();
          while (((Iterator)localObject6).hasNext())
          {
            RedPacketServlet.BrashReportItem localBrashReportItem = (RedPacketServlet.BrashReportItem)((Iterator)localObject6).next();
            PackReport.ReportElem localReportElem = new PackReport.ReportElem();
            localReportElem.count.set(localBrashReportItem.count);
            localReportElem.timestamp.set(localBrashReportItem.time);
            ((PackReport.Report)localObject5).elems.add(localReportElem);
          }
          localObject6 = ((PackReport.Report)localObject5).id;
          if (paramIntent.getBooleanExtra("k_b_ing", false)) {}
          for (l1 = 200L;; l1 = 100L)
          {
            ((PBUInt64Field)localObject6).set(l1);
            ((ArrayList)localObject4).add(localObject5);
            if (((Bundle)localObject3).containsKey("k_e_ctr"))
            {
              localObject5 = new PackReport.Report();
              ((PackReport.Report)localObject5).id.set(300L);
              localObject6 = new PackReport.ReportElem();
              ((PackReport.ReportElem)localObject6).count.set(((Bundle)localObject3).getInt("k_e_ctr"));
              ((PackReport.ReportElem)localObject6).timestamp.set(((Bundle)localObject3).getLong("k_s_time"));
              ((PackReport.Report)localObject5).elems.add((MessageMicro)localObject6);
              ((ArrayList)localObject4).add(localObject5);
              if (QLog.isColorLevel()) {
                QLog.d("RedPacketServlet", 2, "onSend, report EMPTY_COUNTER , elem.count = " + ((PackReport.ReportElem)localObject6).count.get());
              }
            }
            if (((Bundle)localObject3).containsKey("k_h_ctr"))
            {
              localObject5 = new PackReport.Report();
              ((PackReport.Report)localObject5).id.set(400L);
              localObject6 = new PackReport.ReportElem();
              ((PackReport.ReportElem)localObject6).count.set(((Bundle)localObject3).getInt("k_h_ctr"));
              ((PackReport.ReportElem)localObject6).timestamp.set(((Bundle)localObject3).getLong("k_s_time"));
              ((PackReport.Report)localObject5).elems.add((MessageMicro)localObject6);
              ((ArrayList)localObject4).add(localObject5);
              if (QLog.isColorLevel()) {
                QLog.d("RedPacketServlet", 2, "onSend, report HIT_COUNTER , elem.count = " + ((PackReport.ReportElem)localObject6).count.get());
              }
            }
            if (((Bundle)localObject3).containsKey("k_c_ctr"))
            {
              localObject5 = new PackReport.Report();
              ((PackReport.Report)localObject5).id.set(500L);
              localObject6 = new PackReport.ReportElem();
              ((PackReport.ReportElem)localObject6).count.set(((Bundle)localObject3).getInt("k_c_ctr"));
              ((PackReport.ReportElem)localObject6).timestamp.set(((Bundle)localObject3).getLong("k_s_time"));
              ((PackReport.Report)localObject5).elems.add((MessageMicro)localObject6);
              ((ArrayList)localObject4).add(localObject5);
              if (QLog.isColorLevel()) {
                QLog.d("RedPacketServlet", 2, "onSend, report reportContinuous , elem.count = " + ((PackReport.ReportElem)localObject6).count.get());
              }
            }
            ((PackReport.PkgReq)localObject2).report.set((List)localObject4);
            ((Unisso.UniSsoServerReq)localObject1).reqdata.set(ByteStringMicro.copyFrom(((PackReport.PkgReq)localObject2).toByteArray()));
            localObject1 = WupUtil.a(((Unisso.UniSsoServerReq)localObject1).toByteArray());
            localObject2 = "NewYearReport.pack_report";
            paramIntent.putExtra("k_retry", 2);
            break;
          }
          localObject1 = new Unisso.UniSsoServerReq();
          localObject2 = new PackRanking.PkgReq();
          ((PackRanking.PkgReq)localObject2).uin.set(Long.valueOf(paramIntent.getStringExtra("k_uin")).longValue());
          ((PackRanking.PkgReq)localObject2).cmdtype.set(1);
          localObject3 = new PackRanking.QueryRankingReq();
          int k = paramIntent.getIntExtra("k_type", 3);
          ((PackRanking.QueryRankingReq)localObject3).flag.set(k);
          k = paramIntent.getIntExtra("k_count", 200);
          ((PackRanking.QueryRankingReq)localObject3).num.set(k);
          ((PackRanking.PkgReq)localObject2).query_ranking.set((MessageMicro)localObject3);
          ((Unisso.UniSsoServerReq)localObject1).reqdata.set(ByteStringMicro.copyFrom(((PackRanking.PkgReq)localObject2).toByteArray()));
          localObject1 = WupUtil.a(((Unisso.UniSsoServerReq)localObject1).toByteArray());
          localObject2 = "NewYearReport.pack_ranking";
          paramIntent.putExtra("k_retry", 2);
          break;
          localObject1 = paramIntent.getExtras();
        } while (localObject1 == null);
        localObject2 = new Unisso.UniSsoServerReq();
        localObject3 = new PackShareReport.PkgReq();
        localObject4 = new PackShareReport.PkgHead();
        ((PackShareReport.PkgHead)localObject4).cmdtype.set(1);
        ((PackShareReport.PkgHead)localObject4).uin.set(Long.valueOf(paramIntent.getStringExtra("k_uin")).longValue());
        long l2 = paramIntent.getLongExtra("key_seq", -1L);
        long l1 = l2;
        if (l2 == -1L)
        {
          l1 = NetConnInfoCenter.getServerTimeMillis();
          paramIntent.putExtra("key_seq", l1);
        }
        ((PackShareReport.PkgHead)localObject4).seq.set(l1);
        Object localObject5 = new PackShareReport.ReportShareReq();
        ((PackShareReport.ReportShareReq)localObject5).promotion_id.set(((Bundle)localObject1).getInt("k_id", -1));
        ((PackShareReport.ReportShareReq)localObject5).share_channel.set(((Bundle)localObject1).getInt("k_s_channel", -1));
        ((PackShareReport.ReportShareReq)localObject5).share_type.set(((Bundle)localObject1).getInt("k_s_type", -1));
        ((PackShareReport.ReportShareReq)localObject5).swipe_count.set(((Bundle)localObject1).getInt("key_totalcnt", -1));
        ((PackShareReport.ReportShareReq)localObject5).combo_count.set(((Bundle)localObject1).getInt("key_combocnt", -1));
        ((PackShareReport.ReportShareReq)localObject5).win_money_count.set(((Bundle)localObject1).getInt("k_money", -1));
        ((PackShareReport.ReportShareReq)localObject5).win_goods_count.set(((Bundle)localObject1).getInt("key_goodscnt", -1));
        ((PackShareReport.ReportShareReq)localObject5).share_error.set(((Bundle)localObject1).getInt("key_errorCode", -1));
        ((PackShareReport.PkgReq)localObject3).report_share.set((MessageMicro)localObject5);
        ((PackShareReport.PkgReq)localObject3).head.set((MessageMicro)localObject4);
        ((Unisso.UniSsoServerReq)localObject2).reqdata.set(ByteStringMicro.copyFrom(((PackShareReport.PkgReq)localObject3).toByteArray()));
        localObject1 = WupUtil.a(((Unisso.UniSsoServerReq)localObject2).toByteArray());
        localObject2 = "NewYearReport.pack_share";
        paramIntent.putExtra("k_retry", 2);
        break;
      } while (paramIntent.getExtras() == null);
      localObject1 = new subcmd0x501.SubCmd0x501ReqBody();
      ((subcmd0x501.SubCmd0x501ReqBody)localObject1).uint64_uin.set(Long.valueOf(paramIntent.getStringExtra("k_uin")).longValue());
      ((subcmd0x501.SubCmd0x501ReqBody)localObject1).uint32_idc_id.set(0);
      ((subcmd0x501.SubCmd0x501ReqBody)localObject1).uint32_appid.set(16);
      ((subcmd0x501.SubCmd0x501ReqBody)localObject1).uint32_login_sig_type.set(1);
      ((subcmd0x501.SubCmd0x501ReqBody)localObject1).uint32_request_flag.set(4);
      localObject2 = new subcmd0x501.ReqBody();
      ((subcmd0x501.ReqBody)localObject2).msg_subcmd_0x501_req_body.set((MessageMicro)localObject1);
      localObject1 = WupUtil.a(((subcmd0x501.ReqBody)localObject2).toByteArray());
      localObject2 = "HttpConn.0x6ff_501";
      paramIntent.putExtra("k_retry", 2);
      break;
      localObject4 = paramIntent.getStringExtra("k_sso_id");
      localObject3 = paramIntent.getByteArrayExtra("k_sso_data");
      paramIntent.putExtra("k_new_page", false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.portal.RedPacketServlet
 * JD-Core Version:    0.7.0.1
 */