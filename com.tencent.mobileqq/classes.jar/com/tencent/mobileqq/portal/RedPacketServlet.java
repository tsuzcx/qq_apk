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
  private static int a;
  
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
    if (paramInt6 >= 2)
    {
      if (!NetworkUtil.isNetworkAvailable(BaseApplicationImpl.sApplication)) {
        return;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("reportConfig, ");
        ((StringBuilder)localObject).append(paramInt1);
        ((StringBuilder)localObject).append(", ");
        ((StringBuilder)localObject).append(paramInt2);
        ((StringBuilder)localObject).append(", ");
        ((StringBuilder)localObject).append(paramInt3);
        ((StringBuilder)localObject).append(", ");
        ((StringBuilder)localObject).append(paramInt4);
        ((StringBuilder)localObject).append(", ");
        ((StringBuilder)localObject).append(paramInt5);
        QLog.d("RedPacketServlet", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = new NewIntent(getAppRuntime().getApplication(), RedPacketServlet.class);
      ((NewIntent)localObject).putExtra("k_cmd", 4);
      ((NewIntent)localObject).putExtra("k_type", paramInt1);
      ((NewIntent)localObject).putExtra("k_version", paramInt2);
      ((NewIntent)localObject).putExtra("k_id", paramInt3);
      ((NewIntent)localObject).putExtra("k_opt", paramInt4);
      ((NewIntent)localObject).putExtra("k_code", paramInt5);
      getAppRuntime().startServlet((NewIntent)localObject);
    }
  }
  
  public static void a(AppRuntime paramAppRuntime, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("requestShuaYiShuaRedPacket, promotionId = ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append("，continuousBrushCount = ");
      ((StringBuilder)localObject).append(paramInt2);
      QLog.d("RedPacketServlet", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new NewIntent(paramAppRuntime.getApplication(), RedPacketServlet.class);
    ((NewIntent)localObject).putExtra("k_cmd", 1);
    ((NewIntent)localObject).putExtra("k_id", paramInt1);
    ((NewIntent)localObject).putExtra("k_condition", paramInt2);
    ((NewIntent)localObject).putExtra("k_uin", paramAppRuntime.getAccount());
    paramAppRuntime.startServlet((NewIntent)localObject);
  }
  
  public static void a(AppRuntime paramAppRuntime, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("requestResult, reqType ");
      ((StringBuilder)localObject).append(paramInt3);
      ((StringBuilder)localObject).append(", reqNumber ");
      ((StringBuilder)localObject).append(paramInt2);
      QLog.d("RedPacketServlet", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new NewIntent(paramAppRuntime.getApplication(), RedPacketServlet.class);
    ((NewIntent)localObject).putExtra("k_cmd", 8);
    ((NewIntent)localObject).putExtra("k_uin", paramAppRuntime.getAccount());
    ((NewIntent)localObject).putExtra("k_type", paramInt1);
    ((NewIntent)localObject).putExtra("k_count", paramInt2);
    ((NewIntent)localObject).putExtra("key_seq", paramInt4);
    ((NewIntent)localObject).putExtra("k_r_type", paramInt3);
    paramAppRuntime.startServlet((NewIntent)localObject);
  }
  
  private static void a(AppRuntime paramAppRuntime, int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getConfig, ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(", ");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(", ");
      ((StringBuilder)localObject).append(paramInt3);
      ((StringBuilder)localObject).append(", ");
      ((StringBuilder)localObject).append(paramArrayOfByte1);
      ((StringBuilder)localObject).append(", ");
      ((StringBuilder)localObject).append(paramArrayOfByte2);
      QLog.d("RedPacketServlet", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new NewIntent(paramAppRuntime.getApplication(), RedPacketServlet.class);
    ((NewIntent)localObject).putExtra("k_cmd", 2);
    ((NewIntent)localObject).putExtra("k_offset", paramInt2);
    ((NewIntent)localObject).putExtra("k_id", paramInt3);
    ((NewIntent)localObject).putExtra("k_version", paramInt1);
    ((NewIntent)localObject).putExtra("k_cookie", paramArrayOfByte1);
    ((NewIntent)localObject).putExtra("k_buff", paramArrayOfByte2);
    boolean bool;
    if (paramInt2 != 0) {
      bool = true;
    } else {
      bool = false;
    }
    ((NewIntent)localObject).putExtra("k_new_page", bool);
    paramAppRuntime.startServlet((NewIntent)localObject);
  }
  
  public static void a(AppRuntime paramAppRuntime, int paramInt, ArrayList<RedPacketServlet.BrashReportItem> paramArrayList, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reportBrashCount, ");
      ((StringBuilder)localObject).append(paramBundle);
      QLog.d("RedPacketServlet", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new NewIntent(paramAppRuntime.getApplication(), RedPacketServlet.class);
    ((NewIntent)localObject).putExtra("k_cmd", 7);
    ((NewIntent)localObject).putExtra("k_id", paramInt);
    ((NewIntent)localObject).putExtra("k_uin", paramAppRuntime.getAccount());
    ((NewIntent)localObject).putExtra("k_b_ing", paramBoolean);
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("k_b_list", paramArrayList);
    localBundle.putAll(paramBundle);
    ((NewIntent)localObject).putExtras(localBundle);
    paramAppRuntime.startServlet((NewIntent)localObject);
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
    boolean bool = paramPack.pack_id.has();
    String str1 = "";
    Object localObject;
    if (bool) {
      localObject = paramPack.pack_id.get().toStringUtf8();
    } else {
      localObject = "";
    }
    if (paramPack.signature.has()) {
      str1 = paramPack.signature.get().toStringUtf8();
    }
    String str2 = a(paramPack.req_id);
    String str3 = a(paramPack.url);
    String str4 = a(paramPack.wishing);
    String str5 = a(paramPack.order);
    String str6 = a(paramPack.business_name);
    String str7 = a(paramPack.business_logo);
    String str8 = a(paramPack.business_video);
    String str9 = a(paramPack.business_cover);
    String str10 = a(paramPack.business_video_cover);
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
    paramBundle.putString("k_pack_id", (String)localObject);
    paramBundle.putString("key_url", str3);
    paramBundle.putString("key_req_id", str2);
    paramBundle.putString("key_order", str5);
    paramBundle.putString("key_signature", str1);
    paramBundle.putString("key_wishing", str4);
    paramBundle.putString("key_business_name", str6);
    paramBundle.putString("key_business_video", str8);
    paramBundle.putString("key_business_cover", str9);
    paramBundle.putString("key_business_logo", str7);
    paramBundle.putString("key_business_video_cover", str10);
    paramBundle.putString("key_business_name_pic", paramPack);
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("parsePackData pack_id = ");
      paramBundle.append((String)localObject);
      paramBundle.append("\nbusiness_id = ");
      paramBundle.append(n);
      paramBundle.append("\nstate = ");
      paramBundle.append(i);
      paramBundle.append("\nmoney = ");
      paramBundle.append(j);
      paramBundle.append("\nmtime = ");
      paramBundle.append(i2);
      paramBundle.append("\nawardType = ");
      paramBundle.append(k);
      paramBundle.append("\nwishing = ");
      paramBundle.append(str4);
      paramBundle.append("\norder = ");
      paramBundle.append(str5);
      paramBundle.append("\nsignature = ");
      paramBundle.append(str1);
      paramBundle.append("\nreq_id = ");
      paramBundle.append(str2);
      paramBundle.append("\npromotion_id = ");
      paramBundle.append(m);
      paramBundle.append("\nsend_uin = ");
      paramBundle.append(localLong2);
      paramBundle.append("\nuin = ");
      paramBundle.append(localLong1);
      paramBundle.append("\nctime = ");
      paramBundle.append(i1);
      paramBundle.append("\npackUrl = ");
      paramBundle.append(str3);
      paramBundle.append("\nbusiness_name = ");
      paramBundle.append(str6);
      paramBundle.append("\nbusiness_logo = ");
      paramBundle.append(str7);
      paramBundle.append("\nbusiness_cover = ");
      paramBundle.append(str9);
      paramBundle.append("\nbusiness_video = ");
      paramBundle.append(str8);
      paramBundle.append("\nbusiness_video_cover = ");
      paramBundle.append(str10);
      paramBundle.append("\n");
      paramBundle = paramBundle.toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("business_name_pic = ");
      ((StringBuilder)localObject).append(paramPack);
      QLog.d("RedPacketServlet", 2, new Object[] { paramBundle, ((StringBuilder)localObject).toString() });
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
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return null;
  }
  
  /* Error */
  public void onReceive(Intent paramIntent, com.tencent.qphone.base.remote.FromServiceMsg paramFromServiceMsg)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 92	com/tencent/mobileqq/portal/RedPacketServlet:getAppRuntime	()Lmqq/app/AppRuntime;
    //   4: checkcast 419	com/tencent/mobileqq/app/QQAppInterface
    //   7: astore 19
    //   9: aload 19
    //   11: ifnonnull +4 -> 15
    //   14: return
    //   15: iconst_m1
    //   16: istore 5
    //   18: aload_1
    //   19: ldc 103
    //   21: iconst_m1
    //   22: invokevirtual 425	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   25: istore 4
    //   27: invokestatic 63	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   30: ifeq +40 -> 70
    //   33: new 65	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   40: astore 16
    //   42: aload 16
    //   44: ldc_w 427
    //   47: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: pop
    //   51: aload 16
    //   53: iload 4
    //   55: invokevirtual 75	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   58: pop
    //   59: ldc 79
    //   61: iconst_2
    //   62: aload 16
    //   64: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: invokestatic 86	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   70: aload_1
    //   71: ldc_w 429
    //   74: iconst_0
    //   75: invokevirtual 425	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   78: istore 7
    //   80: aload_2
    //   81: invokevirtual 434	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   84: istore 10
    //   86: invokestatic 63	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   89: ifeq +40 -> 129
    //   92: new 65	java/lang/StringBuilder
    //   95: dup
    //   96: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   99: astore 16
    //   101: aload 16
    //   103: ldc_w 436
    //   106: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: pop
    //   110: aload 16
    //   112: iload 10
    //   114: invokevirtual 439	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   117: pop
    //   118: ldc 79
    //   120: iconst_2
    //   121: aload 16
    //   123: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   126: invokestatic 86	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   129: ldc2_w 440
    //   132: lstore 12
    //   134: iload 10
    //   136: ifeq +2560 -> 2696
    //   139: aload_2
    //   140: invokevirtual 444	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   143: invokestatic 449	com/tencent/mobileqq/utils/WupUtil:b	([B)[B
    //   146: astore 16
    //   148: iload 4
    //   150: iconst_1
    //   151: if_icmpeq +2047 -> 2198
    //   154: iload 10
    //   156: istore 9
    //   158: iload 4
    //   160: iconst_2
    //   161: if_icmpeq +1194 -> 1355
    //   164: iload 4
    //   166: iconst_4
    //   167: if_icmpeq +1155 -> 1322
    //   170: iload 4
    //   172: tableswitch	default:+32 -> 204, 7:+1139->1311, 8:+324->496, 9:+298->470, 10:+41->213
    //   205: astore_2
    //   206: ldc 79
    //   208: astore 16
    //   210: goto +2432 -> 2642
    //   213: new 174	android/os/Bundle
    //   216: dup
    //   217: invokespecial 175	android/os/Bundle:<init>	()V
    //   220: astore 16
    //   222: aload_1
    //   223: ldc 113
    //   225: iconst_m1
    //   226: invokevirtual 425	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   229: istore 8
    //   231: iload 5
    //   233: istore_3
    //   234: new 451	tencent/im/cs/cmd0x6ff/subcmd0x501$RspBody
    //   237: dup
    //   238: invokespecial 452	tencent/im/cs/cmd0x6ff/subcmd0x501$RspBody:<init>	()V
    //   241: astore 17
    //   243: iload 5
    //   245: istore_3
    //   246: aload_2
    //   247: invokevirtual 444	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   250: invokestatic 458	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   253: astore_2
    //   254: iload 5
    //   256: istore_3
    //   257: aload_2
    //   258: invokevirtual 461	java/nio/ByteBuffer:getInt	()I
    //   261: iconst_4
    //   262: isub
    //   263: newarray byte
    //   265: astore 18
    //   267: iload 5
    //   269: istore_3
    //   270: aload_2
    //   271: aload 18
    //   273: invokevirtual 463	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   276: pop
    //   277: iload 5
    //   279: istore_3
    //   280: aload 17
    //   282: aload 18
    //   284: invokevirtual 467	tencent/im/cs/cmd0x6ff/subcmd0x501$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   287: pop
    //   288: iload 5
    //   290: istore_3
    //   291: aload 17
    //   293: getfield 471	tencent/im/cs/cmd0x6ff/subcmd0x501$RspBody:msg_subcmd_0x501_rsp_body	Ltencent/im/cs/cmd0x6ff/subcmd0x501$SubCmd0x501Rspbody;
    //   296: invokevirtual 476	tencent/im/cs/cmd0x6ff/subcmd0x501$SubCmd0x501Rspbody:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   299: checkcast 473	tencent/im/cs/cmd0x6ff/subcmd0x501$SubCmd0x501Rspbody
    //   302: astore_2
    //   303: iload 5
    //   305: istore_3
    //   306: aload_2
    //   307: getfield 479	tencent/im/cs/cmd0x6ff/subcmd0x501$SubCmd0x501Rspbody:uint32_share_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   310: invokevirtual 23	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   313: istore 5
    //   315: iload 5
    //   317: istore_3
    //   318: aload_2
    //   319: getfield 482	tencent/im/cs/cmd0x6ff/subcmd0x501$SubCmd0x501Rspbody:uint32_share_channel	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   322: invokevirtual 23	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   325: istore 6
    //   327: iload 5
    //   329: istore_3
    //   330: iload 6
    //   332: istore 5
    //   334: goto +23 -> 357
    //   337: astore_2
    //   338: invokestatic 63	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   341: ifeq +2540 -> 2881
    //   344: ldc 79
    //   346: iconst_2
    //   347: aload_2
    //   348: invokevirtual 485	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   351: invokestatic 86	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   354: goto +2527 -> 2881
    //   357: aload 19
    //   359: getstatic 490	com/tencent/mobileqq/app/QQManagerFactory:MGR_PORTAL	I
    //   362: invokevirtual 494	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   365: checkcast 496	com/tencent/mobileqq/portal/PortalManager
    //   368: astore_2
    //   369: aload_2
    //   370: ifnull +10 -> 380
    //   373: aload_2
    //   374: iload 8
    //   376: iload_3
    //   377: invokevirtual 499	com/tencent/mobileqq/portal/PortalManager:a	(II)V
    //   380: aload 16
    //   382: ldc_w 501
    //   385: iload_3
    //   386: invokevirtual 284	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   389: aload 16
    //   391: ldc_w 503
    //   394: iload 5
    //   396: invokevirtual 284	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   399: invokestatic 63	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   402: ifeq +50 -> 452
    //   405: new 65	java/lang/StringBuilder
    //   408: dup
    //   409: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   412: astore_2
    //   413: aload_2
    //   414: ldc_w 505
    //   417: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   420: pop
    //   421: aload_2
    //   422: iload_3
    //   423: invokevirtual 75	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   426: pop
    //   427: aload_2
    //   428: ldc_w 507
    //   431: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: pop
    //   435: aload_2
    //   436: iload 5
    //   438: invokevirtual 75	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   441: pop
    //   442: ldc 79
    //   444: iconst_2
    //   445: aload_2
    //   446: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   449: invokestatic 510	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   452: aload 16
    //   454: astore_2
    //   455: goto +23 -> 478
    //   458: astore 17
    //   460: aload 16
    //   462: astore_2
    //   463: aload 17
    //   465: astore 16
    //   467: goto +18 -> 485
    //   470: new 174	android/os/Bundle
    //   473: dup
    //   474: invokespecial 175	android/os/Bundle:<init>	()V
    //   477: astore_2
    //   478: goto -272 -> 206
    //   481: astore 16
    //   483: aconst_null
    //   484: astore_2
    //   485: ldc 79
    //   487: astore 17
    //   489: ldc 45
    //   491: astore 18
    //   493: goto +2174 -> 2667
    //   496: new 174	android/os/Bundle
    //   499: dup
    //   500: invokespecial 175	android/os/Bundle:<init>	()V
    //   503: astore_2
    //   504: new 512	tencent/im/new_year_2021/Unisso$UniSsoServerRsp
    //   507: dup
    //   508: invokespecial 513	tencent/im/new_year_2021/Unisso$UniSsoServerRsp:<init>	()V
    //   511: astore 17
    //   513: aload 17
    //   515: aload 16
    //   517: invokevirtual 514	tencent/im/new_year_2021/Unisso$UniSsoServerRsp:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   520: pop
    //   521: new 516	tencent/im/new_year_ranking/PackRanking$PkgResp
    //   524: dup
    //   525: invokespecial 517	tencent/im/new_year_ranking/PackRanking$PkgResp:<init>	()V
    //   528: astore 16
    //   530: aload 16
    //   532: aload 17
    //   534: getfield 520	tencent/im/new_year_2021/Unisso$UniSsoServerRsp:rspdata	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   537: invokevirtual 237	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   540: invokevirtual 521	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   543: invokevirtual 522	tencent/im/new_year_ranking/PackRanking$PkgResp:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   546: pop
    //   547: aload 16
    //   549: getfield 525	tencent/im/new_year_ranking/PackRanking$PkgResp:retcode	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   552: invokevirtual 23	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   555: istore_3
    //   556: aload_2
    //   557: ldc 117
    //   559: iload_3
    //   560: invokevirtual 284	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   563: aload_2
    //   564: ldc 145
    //   566: aload_1
    //   567: ldc 145
    //   569: iconst_m1
    //   570: invokevirtual 425	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   573: invokevirtual 284	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   576: aload_2
    //   577: ldc 147
    //   579: aload_1
    //   580: ldc 147
    //   582: iconst_m1
    //   583: invokevirtual 425	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   586: invokevirtual 284	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   589: iload_3
    //   590: ifne +698 -> 1288
    //   593: aload 16
    //   595: getfield 529	tencent/im/new_year_ranking/PackRanking$PkgResp:query_ranking	Ltencent/im/new_year_ranking/PackRanking$QueryRankingResp;
    //   598: invokevirtual 532	tencent/im/new_year_ranking/PackRanking$QueryRankingResp:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   601: checkcast 531	tencent/im/new_year_ranking/PackRanking$QueryRankingResp
    //   604: astore 16
    //   606: aload 16
    //   608: getfield 536	tencent/im/new_year_ranking/PackRanking$QueryRankingResp:rank_swipe	Ltencent/im/new_year_ranking/PackRanking$RankingInfo;
    //   611: invokevirtual 539	tencent/im/new_year_ranking/PackRanking$RankingInfo:has	()Z
    //   614: istore 10
    //   616: iload 10
    //   618: ifeq +24 -> 642
    //   621: aload 16
    //   623: getfield 536	tencent/im/new_year_ranking/PackRanking$QueryRankingResp:rank_swipe	Ltencent/im/new_year_ranking/PackRanking$RankingInfo;
    //   626: invokevirtual 540	tencent/im/new_year_ranking/PackRanking$RankingInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   629: checkcast 538	tencent/im/new_year_ranking/PackRanking$RankingInfo
    //   632: astore 17
    //   634: goto +11 -> 645
    //   637: astore 16
    //   639: goto -172 -> 467
    //   642: aconst_null
    //   643: astore 17
    //   645: aload 16
    //   647: getfield 543	tencent/im/new_year_ranking/PackRanking$QueryRankingResp:rank_combo	Ltencent/im/new_year_ranking/PackRanking$RankingInfo;
    //   650: invokevirtual 539	tencent/im/new_year_ranking/PackRanking$RankingInfo:has	()Z
    //   653: istore 10
    //   655: iload 10
    //   657: ifeq +19 -> 676
    //   660: aload 16
    //   662: getfield 543	tencent/im/new_year_ranking/PackRanking$QueryRankingResp:rank_combo	Ltencent/im/new_year_ranking/PackRanking$RankingInfo;
    //   665: invokevirtual 540	tencent/im/new_year_ranking/PackRanking$RankingInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   668: checkcast 538	tencent/im/new_year_ranking/PackRanking$RankingInfo
    //   671: astore 16
    //   673: goto +6 -> 679
    //   676: aconst_null
    //   677: astore 16
    //   679: new 545	org/json/JSONObject
    //   682: dup
    //   683: invokespecial 546	org/json/JSONObject:<init>	()V
    //   686: astore 18
    //   688: aload 18
    //   690: ldc_w 548
    //   693: iload_3
    //   694: invokevirtual 552	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   697: pop
    //   698: aload_0
    //   699: invokevirtual 92	com/tencent/mobileqq/portal/RedPacketServlet:getAppRuntime	()Lmqq/app/AppRuntime;
    //   702: invokevirtual 133	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   705: astore 20
    //   707: aload 17
    //   709: ifnull +2188 -> 2897
    //   712: new 545	org/json/JSONObject
    //   715: dup
    //   716: invokespecial 546	org/json/JSONObject:<init>	()V
    //   719: astore 21
    //   721: aload 17
    //   723: getfield 553	tencent/im/new_year_ranking/PackRanking$RankingInfo:uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   726: astore 22
    //   728: aload 21
    //   730: ldc_w 555
    //   733: aload 20
    //   735: aload 22
    //   737: invokevirtual 30	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   740: invokestatic 560	com/tencent/mobileqq/portal/PortalUtils:a	(Ljava/lang/String;J)Ljava/lang/String;
    //   743: invokevirtual 563	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   746: pop
    //   747: aload 21
    //   749: ldc_w 565
    //   752: aload 17
    //   754: getfield 567	tencent/im/new_year_ranking/PackRanking$RankingInfo:ranking	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   757: invokevirtual 23	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   760: invokevirtual 552	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   763: pop
    //   764: aload 21
    //   766: ldc_w 569
    //   769: aload 17
    //   771: getfield 571	tencent/im/new_year_ranking/PackRanking$RankingInfo:count	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   774: invokevirtual 23	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   777: invokevirtual 552	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   780: pop
    //   781: aload 21
    //   783: ldc_w 573
    //   786: aload 19
    //   788: invokevirtual 576	com/tencent/mobileqq/app/QQAppInterface:getCurrentNickname	()Ljava/lang/String;
    //   791: invokevirtual 563	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   794: pop
    //   795: aload 18
    //   797: ldc_w 578
    //   800: aload 21
    //   802: invokevirtual 563	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   805: pop
    //   806: aload 17
    //   808: getfield 582	tencent/im/new_year_ranking/PackRanking$RankingInfo:elems	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   811: invokevirtual 585	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   814: ifeq +177 -> 991
    //   817: aload 17
    //   819: getfield 582	tencent/im/new_year_ranking/PackRanking$RankingInfo:elems	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   822: invokevirtual 588	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   825: astore 17
    //   827: aload 17
    //   829: invokeinterface 593 1 0
    //   834: ifle +157 -> 991
    //   837: new 595	org/json/JSONArray
    //   840: dup
    //   841: invokespecial 596	org/json/JSONArray:<init>	()V
    //   844: astore 21
    //   846: aload 17
    //   848: invokeinterface 600 1 0
    //   853: astore 17
    //   855: iconst_0
    //   856: istore_3
    //   857: aload 17
    //   859: invokeinterface 605 1 0
    //   864: ifeq +113 -> 977
    //   867: aload 17
    //   869: invokeinterface 609 1 0
    //   874: checkcast 611	tencent/im/new_year_ranking/PackRanking$RankingElem
    //   877: astore 22
    //   879: iload_3
    //   880: iconst_1
    //   881: iadd
    //   882: istore_3
    //   883: new 545	org/json/JSONObject
    //   886: dup
    //   887: invokespecial 546	org/json/JSONObject:<init>	()V
    //   890: astore 23
    //   892: aload 23
    //   894: ldc_w 555
    //   897: aload 20
    //   899: aload 22
    //   901: getfield 612	tencent/im/new_year_ranking/PackRanking$RankingElem:uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   904: invokevirtual 30	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   907: invokestatic 560	com/tencent/mobileqq/portal/PortalUtils:a	(Ljava/lang/String;J)Ljava/lang/String;
    //   910: invokevirtual 563	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   913: pop
    //   914: aload 23
    //   916: ldc_w 565
    //   919: iload_3
    //   920: invokevirtual 552	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   923: pop
    //   924: aload 23
    //   926: ldc_w 569
    //   929: aload 22
    //   931: getfield 613	tencent/im/new_year_ranking/PackRanking$RankingElem:count	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   934: invokevirtual 23	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   937: invokevirtual 552	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   940: pop
    //   941: aload 23
    //   943: ldc_w 573
    //   946: aload 19
    //   948: aload 22
    //   950: getfield 612	tencent/im/new_year_ranking/PackRanking$RankingElem:uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   953: invokevirtual 30	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   956: invokestatic 618	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   959: invokestatic 623	com/tencent/mobileqq/utils/ContactUtils:d	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)Ljava/lang/String;
    //   962: invokevirtual 563	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   965: pop
    //   966: aload 21
    //   968: aload 23
    //   970: invokevirtual 626	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   973: pop
    //   974: goto -117 -> 857
    //   977: aload 18
    //   979: ldc_w 628
    //   982: aload 21
    //   984: invokevirtual 563	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   987: pop
    //   988: goto +3 -> 991
    //   991: aload 16
    //   993: ifnull +275 -> 1268
    //   996: new 545	org/json/JSONObject
    //   999: dup
    //   1000: invokespecial 546	org/json/JSONObject:<init>	()V
    //   1003: astore 17
    //   1005: aload 17
    //   1007: ldc_w 555
    //   1010: aload 20
    //   1012: aload 16
    //   1014: getfield 553	tencent/im/new_year_ranking/PackRanking$RankingInfo:uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1017: invokevirtual 30	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   1020: invokestatic 560	com/tencent/mobileqq/portal/PortalUtils:a	(Ljava/lang/String;J)Ljava/lang/String;
    //   1023: invokevirtual 563	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1026: pop
    //   1027: aload 17
    //   1029: ldc_w 565
    //   1032: aload 16
    //   1034: getfield 567	tencent/im/new_year_ranking/PackRanking$RankingInfo:ranking	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1037: invokevirtual 23	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1040: invokevirtual 552	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1043: pop
    //   1044: aload 17
    //   1046: ldc_w 569
    //   1049: aload 16
    //   1051: getfield 571	tencent/im/new_year_ranking/PackRanking$RankingInfo:count	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1054: invokevirtual 23	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1057: invokevirtual 552	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1060: pop
    //   1061: aload 17
    //   1063: ldc_w 573
    //   1066: aload 19
    //   1068: invokevirtual 576	com/tencent/mobileqq/app/QQAppInterface:getCurrentNickname	()Ljava/lang/String;
    //   1071: invokevirtual 563	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1074: pop
    //   1075: aload 18
    //   1077: ldc_w 630
    //   1080: aload 17
    //   1082: invokevirtual 563	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1085: pop
    //   1086: aload 16
    //   1088: getfield 582	tencent/im/new_year_ranking/PackRanking$RankingInfo:elems	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   1091: invokevirtual 585	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   1094: ifeq +174 -> 1268
    //   1097: aload 16
    //   1099: getfield 582	tencent/im/new_year_ranking/PackRanking$RankingInfo:elems	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   1102: invokevirtual 588	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   1105: astore 17
    //   1107: aload 17
    //   1109: invokeinterface 593 1 0
    //   1114: ifle +154 -> 1268
    //   1117: new 595	org/json/JSONArray
    //   1120: dup
    //   1121: invokespecial 596	org/json/JSONArray:<init>	()V
    //   1124: astore 16
    //   1126: aload 17
    //   1128: invokeinterface 600 1 0
    //   1133: astore 17
    //   1135: iconst_0
    //   1136: istore_3
    //   1137: aload 17
    //   1139: invokeinterface 605 1 0
    //   1144: ifeq +113 -> 1257
    //   1147: aload 17
    //   1149: invokeinterface 609 1 0
    //   1154: checkcast 611	tencent/im/new_year_ranking/PackRanking$RankingElem
    //   1157: astore 21
    //   1159: iload_3
    //   1160: iconst_1
    //   1161: iadd
    //   1162: istore_3
    //   1163: new 545	org/json/JSONObject
    //   1166: dup
    //   1167: invokespecial 546	org/json/JSONObject:<init>	()V
    //   1170: astore 22
    //   1172: aload 22
    //   1174: ldc_w 555
    //   1177: aload 20
    //   1179: aload 21
    //   1181: getfield 612	tencent/im/new_year_ranking/PackRanking$RankingElem:uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1184: invokevirtual 30	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   1187: invokestatic 560	com/tencent/mobileqq/portal/PortalUtils:a	(Ljava/lang/String;J)Ljava/lang/String;
    //   1190: invokevirtual 563	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1193: pop
    //   1194: aload 22
    //   1196: ldc_w 565
    //   1199: iload_3
    //   1200: invokevirtual 552	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1203: pop
    //   1204: aload 22
    //   1206: ldc_w 569
    //   1209: aload 21
    //   1211: getfield 613	tencent/im/new_year_ranking/PackRanking$RankingElem:count	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1214: invokevirtual 23	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1217: invokevirtual 552	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1220: pop
    //   1221: aload 22
    //   1223: ldc_w 573
    //   1226: aload 19
    //   1228: aload 21
    //   1230: getfield 612	tencent/im/new_year_ranking/PackRanking$RankingElem:uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1233: invokevirtual 30	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   1236: invokestatic 618	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1239: invokestatic 623	com/tencent/mobileqq/utils/ContactUtils:d	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)Ljava/lang/String;
    //   1242: invokevirtual 563	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1245: pop
    //   1246: aload 16
    //   1248: aload 22
    //   1250: invokevirtual 626	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   1253: pop
    //   1254: goto -117 -> 1137
    //   1257: aload 18
    //   1259: ldc_w 632
    //   1262: aload 16
    //   1264: invokevirtual 563	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1267: pop
    //   1268: aload_2
    //   1269: ldc_w 634
    //   1272: aload 18
    //   1274: invokevirtual 635	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1277: invokevirtual 311	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1280: goto +8 -> 1288
    //   1283: astore 16
    //   1285: goto +155 -> 1440
    //   1288: goto +45 -> 1333
    //   1291: astore 16
    //   1293: goto +7 -> 1300
    //   1296: astore 16
    //   1298: aconst_null
    //   1299: astore_2
    //   1300: ldc 79
    //   1302: astore 17
    //   1304: ldc 45
    //   1306: astore 18
    //   1308: goto +1359 -> 2667
    //   1311: new 174	android/os/Bundle
    //   1314: dup
    //   1315: invokespecial 175	android/os/Bundle:<init>	()V
    //   1318: astore_2
    //   1319: goto +14 -> 1333
    //   1322: new 174	android/os/Bundle
    //   1325: dup
    //   1326: invokespecial 175	android/os/Bundle:<init>	()V
    //   1329: astore_2
    //   1330: iconst_1
    //   1331: istore 9
    //   1333: ldc 79
    //   1335: astore 16
    //   1337: goto +1305 -> 2642
    //   1340: astore 16
    //   1342: ldc 45
    //   1344: astore 18
    //   1346: ldc 79
    //   1348: astore 17
    //   1350: aconst_null
    //   1351: astore_2
    //   1352: goto +1315 -> 2667
    //   1355: ldc 79
    //   1357: astore 17
    //   1359: aload 19
    //   1361: getstatic 490	com/tencent/mobileqq/app/QQManagerFactory:MGR_PORTAL	I
    //   1364: invokevirtual 494	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1367: checkcast 496	com/tencent/mobileqq/portal/PortalManager
    //   1370: astore 19
    //   1372: new 637	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfigByPage
    //   1375: dup
    //   1376: invokespecial 638	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfigByPage:<init>	()V
    //   1379: astore 20
    //   1381: aload 20
    //   1383: aload 16
    //   1385: invokevirtual 639	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfigByPage:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1388: pop
    //   1389: aload 20
    //   1391: getfield 643	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfigByPage:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1394: invokevirtual 646	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1397: istore_3
    //   1398: new 174	android/os/Bundle
    //   1401: dup
    //   1402: invokespecial 175	android/os/Bundle:<init>	()V
    //   1405: astore_2
    //   1406: iload_3
    //   1407: ifeq +44 -> 1451
    //   1410: aload 19
    //   1412: invokevirtual 648	com/tencent/mobileqq/portal/PortalManager:d	()V
    //   1415: aload_2
    //   1416: ldc 117
    //   1418: iconst_3
    //   1419: invokevirtual 284	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1422: aload_0
    //   1423: sipush 1004
    //   1426: iconst_0
    //   1427: iconst_0
    //   1428: iconst_1
    //   1429: iload_3
    //   1430: iload 7
    //   1432: invokespecial 650	com/tencent/mobileqq/portal/RedPacketServlet:a	(IIIIII)V
    //   1435: goto +49 -> 1484
    //   1438: astore 16
    //   1440: ldc 45
    //   1442: astore 18
    //   1444: ldc 79
    //   1446: astore 17
    //   1448: goto +1219 -> 2667
    //   1451: ldc 45
    //   1453: astore 18
    //   1455: aload 20
    //   1457: getfield 651	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfigByPage:type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1460: invokevirtual 23	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1463: istore_3
    //   1464: iload_3
    //   1465: sipush 1004
    //   1468: if_icmpeq +27 -> 1495
    //   1471: aload_0
    //   1472: sipush 1004
    //   1475: iconst_0
    //   1476: iconst_0
    //   1477: iconst_1
    //   1478: iconst_3
    //   1479: iload 7
    //   1481: invokespecial 650	com/tencent/mobileqq/portal/RedPacketServlet:a	(IIIIII)V
    //   1484: iconst_0
    //   1485: istore 9
    //   1487: goto +685 -> 2172
    //   1490: astore 16
    //   1492: goto -52 -> 1440
    //   1495: aload_1
    //   1496: ldc 111
    //   1498: iconst_m1
    //   1499: invokevirtual 425	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   1502: istore_3
    //   1503: aload 20
    //   1505: getfield 655	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfigByPage:page_info	Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$PageRespInfo;
    //   1508: invokevirtual 658	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$PageRespInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1511: checkcast 657	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$PageRespInfo
    //   1514: getfield 661	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$PageRespInfo:version	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1517: invokevirtual 23	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1520: istore 5
    //   1522: aload 20
    //   1524: getfield 655	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfigByPage:page_info	Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$PageRespInfo;
    //   1527: invokevirtual 658	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$PageRespInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1530: checkcast 657	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$PageRespInfo
    //   1533: getfield 664	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$PageRespInfo:task_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1536: invokevirtual 23	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1539: istore 6
    //   1541: aload_1
    //   1542: ldc 155
    //   1544: iconst_0
    //   1545: invokevirtual 425	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   1548: istore 8
    //   1550: invokestatic 63	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1553: istore 11
    //   1555: iload 11
    //   1557: ifeq +1348 -> 2905
    //   1560: new 65	java/lang/StringBuilder
    //   1563: dup
    //   1564: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   1567: astore 16
    //   1569: aload 16
    //   1571: ldc_w 666
    //   1574: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1577: pop
    //   1578: aload 16
    //   1580: iload 8
    //   1582: invokevirtual 75	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1585: pop
    //   1586: aload 16
    //   1588: ldc 77
    //   1590: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1593: pop
    //   1594: aload 16
    //   1596: iload_3
    //   1597: invokevirtual 75	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1600: pop
    //   1601: aload 16
    //   1603: ldc 77
    //   1605: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1608: pop
    //   1609: aload 16
    //   1611: iload 5
    //   1613: invokevirtual 75	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1616: pop
    //   1617: aload 16
    //   1619: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1622: astore 16
    //   1624: aload 17
    //   1626: iconst_1
    //   1627: aload 16
    //   1629: invokestatic 86	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1632: goto +1273 -> 2905
    //   1635: aload 19
    //   1637: invokevirtual 648	com/tencent/mobileqq/portal/PortalManager:d	()V
    //   1640: aload_2
    //   1641: ldc 117
    //   1643: iconst_3
    //   1644: invokevirtual 284	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1647: aload 20
    //   1649: getfield 655	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfigByPage:page_info	Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$PageRespInfo;
    //   1652: invokevirtual 658	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$PageRespInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1655: checkcast 657	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$PageRespInfo
    //   1658: astore 17
    //   1660: aload_1
    //   1661: ldc 162
    //   1663: invokevirtual 670	android/content/Intent:getByteArrayExtra	(Ljava/lang/String;)[B
    //   1666: astore 16
    //   1668: aload 20
    //   1670: getfield 673	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfigByPage:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1673: invokevirtual 237	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1676: invokevirtual 521	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   1679: astore 21
    //   1681: aload 16
    //   1683: ifnull +1247 -> 2930
    //   1686: aload 16
    //   1688: arraylength
    //   1689: istore_3
    //   1690: goto +3 -> 1693
    //   1693: new 675	org/apache/http/util/ByteArrayBuffer
    //   1696: dup
    //   1697: iload_3
    //   1698: aload 21
    //   1700: arraylength
    //   1701: iadd
    //   1702: invokespecial 678	org/apache/http/util/ByteArrayBuffer:<init>	(I)V
    //   1705: astore 22
    //   1707: aload 16
    //   1709: ifnull +1226 -> 2935
    //   1712: aload 22
    //   1714: aload 16
    //   1716: iconst_0
    //   1717: aload 16
    //   1719: arraylength
    //   1720: invokevirtual 680	org/apache/http/util/ByteArrayBuffer:append	([BII)V
    //   1723: goto +3 -> 1726
    //   1726: aload 22
    //   1728: aload 21
    //   1730: iconst_0
    //   1731: aload 21
    //   1733: arraylength
    //   1734: invokevirtual 680	org/apache/http/util/ByteArrayBuffer:append	([BII)V
    //   1737: aload 22
    //   1739: invokevirtual 683	org/apache/http/util/ByteArrayBuffer:buffer	()[B
    //   1742: astore 16
    //   1744: aload 17
    //   1746: getfield 686	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$PageRespInfo:next_offset	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1749: invokevirtual 646	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1752: istore_3
    //   1753: iload_3
    //   1754: iconst_m1
    //   1755: if_icmpne +360 -> 2115
    //   1758: aload 17
    //   1760: getfield 689	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$PageRespInfo:md5	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1763: invokevirtual 43	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1766: astore 21
    //   1768: aload 16
    //   1770: invokestatic 692	com/tencent/mobileqq/portal/PortalUtils:a	([B)Ljava/lang/String;
    //   1773: astore 22
    //   1775: aload 17
    //   1777: getfield 695	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$PageRespInfo:total_size	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1780: invokevirtual 23	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1783: istore_3
    //   1784: invokestatic 63	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1787: ifeq +1151 -> 2938
    //   1790: new 65	java/lang/StringBuilder
    //   1793: dup
    //   1794: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   1797: astore 23
    //   1799: aload 23
    //   1801: ldc_w 666
    //   1804: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1807: pop
    //   1808: aload 23
    //   1810: iload_3
    //   1811: invokevirtual 75	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1814: pop
    //   1815: aload 23
    //   1817: ldc 77
    //   1819: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1822: pop
    //   1823: aload 23
    //   1825: aload 21
    //   1827: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1830: pop
    //   1831: aload 23
    //   1833: ldc 77
    //   1835: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1838: pop
    //   1839: aload 23
    //   1841: aload 22
    //   1843: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1846: pop
    //   1847: ldc 79
    //   1849: iconst_1
    //   1850: aload 23
    //   1852: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1855: invokestatic 86	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1858: goto +1080 -> 2938
    //   1861: aload 22
    //   1863: aload 21
    //   1865: invokestatic 701	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   1868: ifeq +213 -> 2081
    //   1871: aload 17
    //   1873: getfield 704	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$PageRespInfo:compress	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1876: invokevirtual 23	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1879: istore_3
    //   1880: iload_3
    //   1881: iconst_1
    //   1882: if_icmpne +1063 -> 2945
    //   1885: aload_0
    //   1886: aload 16
    //   1888: invokespecial 706	com/tencent/mobileqq/portal/RedPacketServlet:a	([B)[B
    //   1891: astore 16
    //   1893: goto +3 -> 1896
    //   1896: aload 16
    //   1898: ifnonnull +35 -> 1933
    //   1901: aload_0
    //   1902: sipush 1004
    //   1905: iload 5
    //   1907: aload 20
    //   1909: getfield 655	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfigByPage:page_info	Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$PageRespInfo;
    //   1912: invokevirtual 658	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$PageRespInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1915: checkcast 657	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$PageRespInfo
    //   1918: getfield 664	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$PageRespInfo:task_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1921: invokevirtual 23	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1924: iconst_1
    //   1925: iconst_4
    //   1926: iconst_2
    //   1927: invokespecial 650	com/tencent/mobileqq/portal/RedPacketServlet:a	(IIIIII)V
    //   1930: goto +1024 -> 2954
    //   1933: iconst_0
    //   1934: istore 9
    //   1936: aload 20
    //   1938: getfield 710	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfigByPage:delay_time	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   1941: invokevirtual 713	com/tencent/mobileqq/pb/PBRepeatField:has	()Z
    //   1944: ifeq +1004 -> 2948
    //   1947: aload 20
    //   1949: getfield 710	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfigByPage:delay_time	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   1952: invokevirtual 714	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   1955: checkcast 716	java/util/ArrayList
    //   1958: astore 17
    //   1960: goto +3 -> 1963
    //   1963: new 615	java/lang/String
    //   1966: dup
    //   1967: aload 16
    //   1969: ldc_w 718
    //   1972: invokespecial 721	java/lang/String:<init>	([BLjava/lang/String;)V
    //   1975: iload 5
    //   1977: iload 6
    //   1979: aload 17
    //   1981: invokestatic 724	com/tencent/mobileqq/portal/PortalManager:a	(Ljava/lang/String;IILjava/util/ArrayList;)Lcom/tencent/mobileqq/portal/PortalManager$RedPacketConfig;
    //   1984: astore 16
    //   1986: aload 16
    //   1988: ifnonnull +36 -> 2024
    //   1991: aload_0
    //   1992: sipush 1004
    //   1995: iload 5
    //   1997: aload 20
    //   1999: getfield 655	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfigByPage:page_info	Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$PageRespInfo;
    //   2002: invokevirtual 658	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$PageRespInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2005: checkcast 657	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$PageRespInfo
    //   2008: getfield 664	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$PageRespInfo:task_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2011: invokevirtual 23	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2014: iconst_1
    //   2015: iconst_5
    //   2016: iload 7
    //   2018: invokespecial 650	com/tencent/mobileqq/portal/RedPacketServlet:a	(IIIIII)V
    //   2021: goto +943 -> 2964
    //   2024: aload_0
    //   2025: sipush 1004
    //   2028: iload 5
    //   2030: aload 20
    //   2032: getfield 655	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfigByPage:page_info	Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$PageRespInfo;
    //   2035: invokevirtual 658	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$PageRespInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2038: checkcast 657	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$PageRespInfo
    //   2041: getfield 664	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$PageRespInfo:task_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2044: invokevirtual 23	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2047: iconst_1
    //   2048: iconst_0
    //   2049: iconst_2
    //   2050: invokespecial 650	com/tencent/mobileqq/portal/RedPacketServlet:a	(IIIIII)V
    //   2053: aload 19
    //   2055: aload 16
    //   2057: invokevirtual 727	com/tencent/mobileqq/portal/PortalManager:a	(Lcom/tencent/mobileqq/portal/PortalManager$RedPacketConfig;)Lcom/tencent/mobileqq/portal/PortalManager$RedPacketConfig;
    //   2060: astore 16
    //   2062: aload_2
    //   2063: ldc 117
    //   2065: iconst_4
    //   2066: invokevirtual 284	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   2069: aload_2
    //   2070: ldc_w 729
    //   2073: aload 16
    //   2075: invokevirtual 181	android/os/Bundle:putSerializable	(Ljava/lang/String;Ljava/io/Serializable;)V
    //   2078: goto +876 -> 2954
    //   2081: aload_0
    //   2082: sipush 1004
    //   2085: iload 5
    //   2087: aload 20
    //   2089: getfield 655	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfigByPage:page_info	Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$PageRespInfo;
    //   2092: invokevirtual 658	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$PageRespInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2095: checkcast 657	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$PageRespInfo
    //   2098: getfield 664	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$PageRespInfo:task_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2101: invokevirtual 23	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2104: iconst_1
    //   2105: bipush 6
    //   2107: iload 7
    //   2109: invokespecial 650	com/tencent/mobileqq/portal/RedPacketServlet:a	(IIIIII)V
    //   2112: goto +849 -> 2961
    //   2115: iload_3
    //   2116: ifeq +845 -> 2961
    //   2119: aload_0
    //   2120: invokevirtual 92	com/tencent/mobileqq/portal/RedPacketServlet:getAppRuntime	()Lmqq/app/AppRuntime;
    //   2123: iload 5
    //   2125: aload 17
    //   2127: getfield 686	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$PageRespInfo:next_offset	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   2130: invokevirtual 646	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   2133: aload 17
    //   2135: getfield 664	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$PageRespInfo:task_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2138: invokevirtual 23	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2141: aload 17
    //   2143: getfield 732	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$PageRespInfo:cookies	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   2146: invokevirtual 237	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   2149: invokevirtual 521	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   2152: aload 16
    //   2154: invokestatic 734	com/tencent/mobileqq/portal/RedPacketServlet:a	(Lmqq/app/AppRuntime;III[B[B)V
    //   2157: return
    //   2158: aload 19
    //   2160: aconst_null
    //   2161: invokevirtual 727	com/tencent/mobileqq/portal/PortalManager:a	(Lcom/tencent/mobileqq/portal/PortalManager$RedPacketConfig;)Lcom/tencent/mobileqq/portal/PortalManager$RedPacketConfig;
    //   2164: pop
    //   2165: aload_2
    //   2166: ldc 117
    //   2168: iconst_2
    //   2169: invokevirtual 284	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   2172: ldc 79
    //   2174: astore 16
    //   2176: goto +466 -> 2642
    //   2179: astore 16
    //   2181: goto +5 -> 2186
    //   2184: astore 16
    //   2186: ldc 79
    //   2188: astore 17
    //   2190: goto +477 -> 2667
    //   2193: astore 16
    //   2195: goto +462 -> 2657
    //   2198: iload 10
    //   2200: istore 9
    //   2202: ldc 79
    //   2204: astore 17
    //   2206: ldc 45
    //   2208: astore 18
    //   2210: new 174	android/os/Bundle
    //   2213: dup
    //   2214: invokespecial 175	android/os/Bundle:<init>	()V
    //   2217: astore_2
    //   2218: new 512	tencent/im/new_year_2021/Unisso$UniSsoServerRsp
    //   2221: dup
    //   2222: invokespecial 513	tencent/im/new_year_2021/Unisso$UniSsoServerRsp:<init>	()V
    //   2225: astore 20
    //   2227: aload 20
    //   2229: aload 16
    //   2231: invokevirtual 514	tencent/im/new_year_2021/Unisso$UniSsoServerRsp:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2234: pop
    //   2235: aload 20
    //   2237: getfield 738	tencent/im/new_year_2021/Unisso$UniSsoServerRsp:ret	Lcom/tencent/mobileqq/pb/PBInt64Field;
    //   2240: invokevirtual 741	com/tencent/mobileqq/pb/PBInt64Field:has	()Z
    //   2243: ifeq +20 -> 2263
    //   2246: aload 20
    //   2248: getfield 738	tencent/im/new_year_2021/Unisso$UniSsoServerRsp:ret	Lcom/tencent/mobileqq/pb/PBInt64Field;
    //   2251: invokevirtual 742	com/tencent/mobileqq/pb/PBInt64Field:get	()J
    //   2254: lstore 14
    //   2256: lload 14
    //   2258: lstore 12
    //   2260: goto +8 -> 2268
    //   2263: ldc2_w 743
    //   2266: lstore 12
    //   2268: aload 20
    //   2270: getfield 747	tencent/im/new_year_2021/Unisso$UniSsoServerRsp:errmsg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2273: invokevirtual 40	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   2276: ifeq +696 -> 2972
    //   2279: aload 20
    //   2281: getfield 747	tencent/im/new_year_2021/Unisso$UniSsoServerRsp:errmsg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2284: invokevirtual 43	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2287: astore 16
    //   2289: goto +3 -> 2292
    //   2292: invokestatic 63	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2295: ifeq +57 -> 2352
    //   2298: new 65	java/lang/StringBuilder
    //   2301: dup
    //   2302: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   2305: astore 21
    //   2307: aload 21
    //   2309: ldc_w 749
    //   2312: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2315: pop
    //   2316: aload 21
    //   2318: lload 12
    //   2320: invokevirtual 752	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2323: pop
    //   2324: aload 21
    //   2326: ldc_w 754
    //   2329: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2332: pop
    //   2333: aload 21
    //   2335: aload 16
    //   2337: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2340: pop
    //   2341: aload 17
    //   2343: iconst_2
    //   2344: aload 21
    //   2346: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2349: invokestatic 86	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2352: lload 12
    //   2354: lconst_0
    //   2355: lcmp
    //   2356: ifne +264 -> 2620
    //   2359: new 756	tencent/im/new_year_2021/FestivalPack$PkgResp
    //   2362: dup
    //   2363: invokespecial 757	tencent/im/new_year_2021/FestivalPack$PkgResp:<init>	()V
    //   2366: astore 16
    //   2368: aload 16
    //   2370: aload 20
    //   2372: getfield 520	tencent/im/new_year_2021/Unisso$UniSsoServerRsp:rspdata	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   2375: invokevirtual 237	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   2378: invokevirtual 521	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   2381: invokevirtual 758	tencent/im/new_year_2021/FestivalPack$PkgResp:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2384: pop
    //   2385: aload 16
    //   2387: getfield 762	tencent/im/new_year_2021/FestivalPack$PkgResp:get_eve_pack	Ltencent/im/new_year_2021/FestivalPack$NewYearEvePackResp;
    //   2390: invokevirtual 765	tencent/im/new_year_2021/FestivalPack$NewYearEvePackResp:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2393: checkcast 764	tencent/im/new_year_2021/FestivalPack$NewYearEvePackResp
    //   2396: astore 20
    //   2398: aload 20
    //   2400: getfield 769	tencent/im/new_year_2021/FestivalPack$NewYearEvePackResp:pack	Ltencent/im/new_year_2021/Pack2021$Pack;
    //   2403: invokevirtual 770	tencent/im/new_year_2021/Pack2021$Pack:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2406: checkcast 194	tencent/im/new_year_2021/Pack2021$Pack
    //   2409: astore 16
    //   2411: aload 20
    //   2413: getfield 773	tencent/im/new_year_2021/FestivalPack$NewYearEvePackResp:interval	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2416: invokevirtual 19	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   2419: ifeq +560 -> 2979
    //   2422: aload 20
    //   2424: getfield 773	tencent/im/new_year_2021/FestivalPack$NewYearEvePackResp:interval	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2427: invokevirtual 23	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2430: istore_3
    //   2431: goto +3 -> 2434
    //   2434: aload 19
    //   2436: getstatic 776	com/tencent/mobileqq/app/QQManagerFactory:SPRING_FESTIVAL_ENTRY_MANAGER	I
    //   2439: invokevirtual 494	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   2442: checkcast 778	com/tencent/mobileqq/activity/springfestival/entry/SpringFestivalEntryManager
    //   2445: astore 21
    //   2447: aload 21
    //   2449: invokeinterface 783 1 0
    //   2454: astore 19
    //   2456: iload_3
    //   2457: ifle +16 -> 2473
    //   2460: aload 19
    //   2462: iload_3
    //   2463: putfield 788	com/tencent/mobileqq/activity/springfestival/entry/model/UserData:grabReqInterval	I
    //   2466: aload 21
    //   2468: invokeinterface 790 1 0
    //   2473: invokestatic 63	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2476: ifeq +59 -> 2535
    //   2479: new 65	java/lang/StringBuilder
    //   2482: dup
    //   2483: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   2486: astore 21
    //   2488: aload 21
    //   2490: ldc_w 792
    //   2493: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2496: pop
    //   2497: aload 21
    //   2499: aload 19
    //   2501: getfield 788	com/tencent/mobileqq/activity/springfestival/entry/model/UserData:grabReqInterval	I
    //   2504: invokevirtual 75	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2507: pop
    //   2508: aload 21
    //   2510: ldc_w 794
    //   2513: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2516: pop
    //   2517: aload 21
    //   2519: iload_3
    //   2520: invokevirtual 75	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2523: pop
    //   2524: aload 17
    //   2526: iconst_2
    //   2527: aload 21
    //   2529: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2532: invokestatic 86	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2535: aload 20
    //   2537: getfield 797	tencent/im/new_year_2021/FestivalPack$NewYearEvePackResp:share_forbidden	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2540: invokevirtual 19	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   2543: ifeq +441 -> 2984
    //   2546: aload 20
    //   2548: getfield 797	tencent/im/new_year_2021/FestivalPack$NewYearEvePackResp:share_forbidden	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2551: invokevirtual 23	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2554: istore_3
    //   2555: goto +3 -> 2558
    //   2558: aload 19
    //   2560: iload_3
    //   2561: invokevirtual 800	com/tencent/mobileqq/activity/springfestival/entry/model/UserData:setShareForbidden	(I)V
    //   2564: invokestatic 63	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2567: ifeq +43 -> 2610
    //   2570: new 65	java/lang/StringBuilder
    //   2573: dup
    //   2574: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   2577: astore 20
    //   2579: aload 20
    //   2581: ldc_w 802
    //   2584: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2587: pop
    //   2588: aload 20
    //   2590: aload 19
    //   2592: invokevirtual 805	com/tencent/mobileqq/activity/springfestival/entry/model/UserData:getShareForbidden	()I
    //   2595: invokevirtual 75	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2598: pop
    //   2599: aload 17
    //   2601: iconst_2
    //   2602: aload 20
    //   2604: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2607: invokestatic 86	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2610: aload_0
    //   2611: aload 16
    //   2613: aload_2
    //   2614: invokespecial 807	com/tencent/mobileqq/portal/RedPacketServlet:a	(Ltencent/im/new_year_2021/Pack2021$Pack;Landroid/os/Bundle;)V
    //   2617: goto +21 -> 2638
    //   2620: aload_2
    //   2621: ldc 109
    //   2623: iconst_m1
    //   2624: invokevirtual 284	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   2627: aload_2
    //   2628: ldc_w 288
    //   2631: iconst_m1
    //   2632: invokevirtual 284	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   2635: iconst_1
    //   2636: istore 9
    //   2638: aload 17
    //   2640: astore 16
    //   2642: goto +51 -> 2693
    //   2645: astore 16
    //   2647: goto +20 -> 2667
    //   2650: astore 16
    //   2652: goto +15 -> 2667
    //   2655: astore 16
    //   2657: ldc 79
    //   2659: astore 17
    //   2661: ldc 45
    //   2663: astore 18
    //   2665: aconst_null
    //   2666: astore_2
    //   2667: invokestatic 63	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2670: ifeq +16 -> 2686
    //   2673: aload 17
    //   2675: iconst_2
    //   2676: aload 18
    //   2678: aload 16
    //   2680: invokestatic 810	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2683: goto +3 -> 2686
    //   2686: iconst_0
    //   2687: istore 9
    //   2689: aload 17
    //   2691: astore 16
    //   2693: goto +40 -> 2733
    //   2696: ldc 79
    //   2698: astore 16
    //   2700: iload 4
    //   2702: iconst_2
    //   2703: if_icmpne +19 -> 2722
    //   2706: aload_0
    //   2707: sipush 1004
    //   2710: iconst_0
    //   2711: iconst_0
    //   2712: iconst_1
    //   2713: iconst_1
    //   2714: iload 7
    //   2716: invokespecial 650	com/tencent/mobileqq/portal/RedPacketServlet:a	(IIIIII)V
    //   2719: goto +3 -> 2722
    //   2722: aconst_null
    //   2723: astore_2
    //   2724: ldc2_w 440
    //   2727: lstore 12
    //   2729: iload 10
    //   2731: istore 9
    //   2733: iload 9
    //   2735: ifne +60 -> 2795
    //   2738: iload 7
    //   2740: iconst_2
    //   2741: if_icmpge +54 -> 2795
    //   2744: aload_1
    //   2745: ldc_w 429
    //   2748: iload 7
    //   2750: iconst_1
    //   2751: iadd
    //   2752: invokevirtual 811	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   2755: pop
    //   2756: iload 4
    //   2758: bipush 7
    //   2760: if_icmpne +23 -> 2783
    //   2763: invokestatic 817	com/tencent/mobileqq/app/ThreadManager:getSubThreadHandler	()Lmqq/os/MqqHandler;
    //   2766: new 819	com/tencent/mobileqq/portal/RedPacketServlet$1
    //   2769: dup
    //   2770: aload_0
    //   2771: aload_1
    //   2772: invokespecial 822	com/tencent/mobileqq/portal/RedPacketServlet$1:<init>	(Lcom/tencent/mobileqq/portal/RedPacketServlet;Landroid/content/Intent;)V
    //   2775: ldc2_w 823
    //   2778: invokevirtual 830	mqq/os/MqqHandler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   2781: pop
    //   2782: return
    //   2783: aload_0
    //   2784: invokevirtual 92	com/tencent/mobileqq/portal/RedPacketServlet:getAppRuntime	()Lmqq/app/AppRuntime;
    //   2787: aload_1
    //   2788: checkcast 88	mqq/app/NewIntent
    //   2791: invokevirtual 121	mqq/app/AppRuntime:startServlet	(Lmqq/app/NewIntent;)V
    //   2794: return
    //   2795: aload_2
    //   2796: ifnonnull +14 -> 2810
    //   2799: new 174	android/os/Bundle
    //   2802: dup
    //   2803: invokespecial 175	android/os/Bundle:<init>	()V
    //   2806: astore_2
    //   2807: goto +3 -> 2810
    //   2810: iload 4
    //   2812: iconst_1
    //   2813: if_icmpne +12 -> 2825
    //   2816: aload_2
    //   2817: ldc_w 832
    //   2820: lload 12
    //   2822: invokevirtual 303	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   2825: invokestatic 63	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2828: ifeq +39 -> 2867
    //   2831: new 65	java/lang/StringBuilder
    //   2834: dup
    //   2835: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   2838: astore 17
    //   2840: aload 17
    //   2842: ldc_w 834
    //   2845: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2848: pop
    //   2849: aload 17
    //   2851: aload_2
    //   2852: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2855: pop
    //   2856: aload 16
    //   2858: iconst_2
    //   2859: aload 17
    //   2861: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2864: invokestatic 86	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2867: aload_0
    //   2868: aload_1
    //   2869: iload 4
    //   2871: iload 9
    //   2873: aload_2
    //   2874: ldc_w 836
    //   2877: invokevirtual 840	com/tencent/mobileqq/portal/RedPacketServlet:notifyObserver	(Landroid/content/Intent;IZLandroid/os/Bundle;Ljava/lang/Class;)V
    //   2880: return
    //   2881: iconst_0
    //   2882: istore 5
    //   2884: goto -2527 -> 357
    //   2887: astore 16
    //   2889: goto +5 -> 2894
    //   2892: astore 16
    //   2894: goto -1594 -> 1300
    //   2897: goto -1906 -> 991
    //   2900: astore 16
    //   2902: goto -716 -> 2186
    //   2905: iload 8
    //   2907: ifne +9 -> 2916
    //   2910: iload_3
    //   2911: iload 5
    //   2913: if_icmpne -1278 -> 1635
    //   2916: iload 8
    //   2918: ifeq -760 -> 2158
    //   2921: iload_3
    //   2922: iload 5
    //   2924: if_icmpne -766 -> 2158
    //   2927: goto -1292 -> 1635
    //   2930: iconst_0
    //   2931: istore_3
    //   2932: goto -1239 -> 1693
    //   2935: goto -1209 -> 1726
    //   2938: iload_3
    //   2939: ifne -1078 -> 1861
    //   2942: goto +12 -> 2954
    //   2945: goto -1049 -> 1896
    //   2948: aconst_null
    //   2949: astore 17
    //   2951: goto -988 -> 1963
    //   2954: iload 10
    //   2956: istore 9
    //   2958: goto +6 -> 2964
    //   2961: iconst_0
    //   2962: istore 9
    //   2964: goto -792 -> 2172
    //   2967: astore 16
    //   2969: goto -67 -> 2902
    //   2972: aload 18
    //   2974: astore 16
    //   2976: goto -684 -> 2292
    //   2979: iconst_0
    //   2980: istore_3
    //   2981: goto -547 -> 2434
    //   2984: iconst_m1
    //   2985: istore_3
    //   2986: goto -428 -> 2558
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2989	0	this	RedPacketServlet
    //   0	2989	1	paramIntent	Intent
    //   0	2989	2	paramFromServiceMsg	com.tencent.qphone.base.remote.FromServiceMsg
    //   233	2753	3	i	int
    //   25	2845	4	j	int
    //   16	2909	5	k	int
    //   325	1653	6	m	int
    //   78	2674	7	n	int
    //   229	2688	8	i1	int
    //   156	2807	9	bool1	boolean
    //   84	2871	10	bool2	boolean
    //   1553	3	11	bool3	boolean
    //   132	2689	12	l1	long
    //   2254	3	14	l2	long
    //   40	426	16	localObject1	Object
    //   481	35	16	localThrowable1	Throwable
    //   528	94	16	localObject2	Object
    //   637	24	16	localThrowable2	Throwable
    //   671	592	16	localObject3	Object
    //   1283	1	16	localThrowable3	Throwable
    //   1291	1	16	localThrowable4	Throwable
    //   1296	1	16	localThrowable5	Throwable
    //   1335	1	16	str	String
    //   1340	44	16	localThrowable6	Throwable
    //   1438	1	16	localThrowable7	Throwable
    //   1490	1	16	localThrowable8	Throwable
    //   1567	608	16	localObject4	Object
    //   2179	1	16	localThrowable9	Throwable
    //   2184	1	16	localThrowable10	Throwable
    //   2193	37	16	localThrowable11	Throwable
    //   2287	354	16	localObject5	Object
    //   2645	1	16	localThrowable12	Throwable
    //   2650	1	16	localThrowable13	Throwable
    //   2655	24	16	localThrowable14	Throwable
    //   2691	166	16	localObject6	Object
    //   2887	1	16	localThrowable15	Throwable
    //   2892	1	16	localThrowable16	Throwable
    //   2900	1	16	localThrowable17	Throwable
    //   2967	1	16	localThrowable18	Throwable
    //   2974	1	16	localObject7	Object
    //   241	51	17	localRspBody	tencent.im.cs.cmd0x6ff.subcmd0x501.RspBody
    //   458	6	17	localThrowable19	Throwable
    //   487	2463	17	localObject8	Object
    //   265	2708	18	localObject9	Object
    //   7	2584	19	localObject10	Object
    //   705	1898	20	localObject11	Object
    //   719	1809	21	localObject12	Object
    //   726	1136	22	localObject13	Object
    //   890	961	23	localObject14	Object
    // Exception table:
    //   from	to	target	type
    //   234	243	337	java/lang/Exception
    //   246	254	337	java/lang/Exception
    //   257	267	337	java/lang/Exception
    //   270	277	337	java/lang/Exception
    //   280	288	337	java/lang/Exception
    //   291	303	337	java/lang/Exception
    //   306	315	337	java/lang/Exception
    //   318	327	337	java/lang/Exception
    //   222	231	458	java/lang/Throwable
    //   234	243	458	java/lang/Throwable
    //   246	254	458	java/lang/Throwable
    //   257	267	458	java/lang/Throwable
    //   270	277	458	java/lang/Throwable
    //   280	288	458	java/lang/Throwable
    //   291	303	458	java/lang/Throwable
    //   306	315	458	java/lang/Throwable
    //   318	327	458	java/lang/Throwable
    //   338	354	458	java/lang/Throwable
    //   357	369	458	java/lang/Throwable
    //   373	380	458	java/lang/Throwable
    //   380	452	458	java/lang/Throwable
    //   213	222	481	java/lang/Throwable
    //   470	478	481	java/lang/Throwable
    //   621	634	637	java/lang/Throwable
    //   660	673	637	java/lang/Throwable
    //   728	855	1283	java/lang/Throwable
    //   857	879	1283	java/lang/Throwable
    //   883	974	1283	java/lang/Throwable
    //   977	988	1283	java/lang/Throwable
    //   996	1135	1283	java/lang/Throwable
    //   1137	1159	1283	java/lang/Throwable
    //   1163	1254	1283	java/lang/Throwable
    //   1257	1268	1283	java/lang/Throwable
    //   1268	1280	1283	java/lang/Throwable
    //   504	589	1291	java/lang/Throwable
    //   593	616	1291	java/lang/Throwable
    //   645	655	1291	java/lang/Throwable
    //   679	707	1291	java/lang/Throwable
    //   496	504	1296	java/lang/Throwable
    //   1311	1319	1340	java/lang/Throwable
    //   1322	1330	1340	java/lang/Throwable
    //   1410	1422	1438	java/lang/Throwable
    //   1422	1435	1490	java/lang/Throwable
    //   1471	1484	1490	java/lang/Throwable
    //   1885	1893	2179	java/lang/Throwable
    //   1901	1930	2179	java/lang/Throwable
    //   1936	1960	2179	java/lang/Throwable
    //   1963	1986	2179	java/lang/Throwable
    //   1991	2021	2179	java/lang/Throwable
    //   2024	2078	2179	java/lang/Throwable
    //   2081	2112	2179	java/lang/Throwable
    //   2119	2157	2179	java/lang/Throwable
    //   2158	2172	2179	java/lang/Throwable
    //   1455	1464	2184	java/lang/Throwable
    //   1495	1555	2184	java/lang/Throwable
    //   1359	1406	2193	java/lang/Throwable
    //   2268	2289	2645	java/lang/Throwable
    //   2292	2352	2645	java/lang/Throwable
    //   2359	2431	2645	java/lang/Throwable
    //   2434	2456	2645	java/lang/Throwable
    //   2460	2473	2645	java/lang/Throwable
    //   2473	2535	2645	java/lang/Throwable
    //   2535	2555	2645	java/lang/Throwable
    //   2558	2610	2645	java/lang/Throwable
    //   2610	2617	2645	java/lang/Throwable
    //   2620	2635	2645	java/lang/Throwable
    //   2218	2256	2650	java/lang/Throwable
    //   2210	2218	2655	java/lang/Throwable
    //   721	728	2887	java/lang/Throwable
    //   712	721	2892	java/lang/Throwable
    //   1560	1624	2900	java/lang/Throwable
    //   1624	1632	2967	java/lang/Throwable
    //   1635	1681	2967	java/lang/Throwable
    //   1686	1690	2967	java/lang/Throwable
    //   1693	1707	2967	java/lang/Throwable
    //   1712	1723	2967	java/lang/Throwable
    //   1726	1753	2967	java/lang/Throwable
    //   1758	1858	2967	java/lang/Throwable
    //   1861	1880	2967	java/lang/Throwable
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    int k = paramIntent.getIntExtra("k_cmd", -1);
    int i = paramIntent.getIntExtra("k_retry", 0);
    boolean bool = paramIntent.getBooleanExtra("k_new_page", false);
    Object localObject3;
    Object localObject4;
    int j;
    if ((i != 0) && (!bool))
    {
      localObject3 = paramIntent.getStringExtra("k_sso_id");
      localObject4 = paramIntent.getByteArrayExtra("k_sso_data");
      paramIntent.putExtra("k_new_page", false);
      j = i;
    }
    else
    {
      Object localObject1;
      Object localObject2;
      if (k != 1) {
        if (k != 2) {
          if (k != 4)
          {
            switch (k)
            {
            default: 
              localObject1 = null;
              localObject2 = null;
              break;
            case 10: 
              if (paramIntent.getExtras() == null) {
                return;
              }
              localObject1 = new subcmd0x501.SubCmd0x501ReqBody();
              ((subcmd0x501.SubCmd0x501ReqBody)localObject1).uint64_uin.set(Long.valueOf(paramIntent.getStringExtra("k_uin")).longValue());
              ((subcmd0x501.SubCmd0x501ReqBody)localObject1).uint32_idc_id.set(0);
              ((subcmd0x501.SubCmd0x501ReqBody)localObject1).uint32_appid.set(16);
              ((subcmd0x501.SubCmd0x501ReqBody)localObject1).uint32_login_sig_type.set(1);
              ((subcmd0x501.SubCmd0x501ReqBody)localObject1).uint32_request_flag.set(4);
              localObject2 = new subcmd0x501.ReqBody();
              ((subcmd0x501.ReqBody)localObject2).msg_subcmd_0x501_req_body.set((MessageMicro)localObject1);
              localObject2 = WupUtil.a(((subcmd0x501.ReqBody)localObject2).toByteArray());
              paramIntent.putExtra("k_retry", 2);
              localObject1 = "HttpConn.0x6ff_501";
              break;
            case 9: 
              localObject1 = paramIntent.getExtras();
              if (localObject1 == null) {
                return;
              }
              localObject2 = new Unisso.UniSsoServerReq();
              localObject3 = new PackShareReport.PkgReq();
              localObject4 = new PackShareReport.PkgHead();
              ((PackShareReport.PkgHead)localObject4).cmdtype.set(1);
              ((PackShareReport.PkgHead)localObject4).uin.set(Long.valueOf(paramIntent.getStringExtra("k_uin")).longValue());
              l1 = paramIntent.getLongExtra("key_seq", -1L);
              if (l1 == -1L)
              {
                l1 = NetConnInfoCenter.getServerTimeMillis();
                paramIntent.putExtra("key_seq", l1);
              }
              ((PackShareReport.PkgHead)localObject4).seq.set(l1);
              localObject5 = new PackShareReport.ReportShareReq();
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
              localObject2 = WupUtil.a(((Unisso.UniSsoServerReq)localObject2).toByteArray());
              paramIntent.putExtra("k_retry", 2);
              localObject1 = "NewYearReport.pack_share";
              break;
            case 8: 
              localObject1 = new Unisso.UniSsoServerReq();
              localObject2 = new PackRanking.PkgReq();
              ((PackRanking.PkgReq)localObject2).uin.set(Long.valueOf(paramIntent.getStringExtra("k_uin")).longValue());
              ((PackRanking.PkgReq)localObject2).cmdtype.set(1);
              localObject3 = new PackRanking.QueryRankingReq();
              j = paramIntent.getIntExtra("k_type", 3);
              ((PackRanking.QueryRankingReq)localObject3).flag.set(j);
              j = paramIntent.getIntExtra("k_count", 200);
              ((PackRanking.QueryRankingReq)localObject3).num.set(j);
              ((PackRanking.PkgReq)localObject2).query_ranking.set((MessageMicro)localObject3);
              ((Unisso.UniSsoServerReq)localObject1).reqdata.set(ByteStringMicro.copyFrom(((PackRanking.PkgReq)localObject2).toByteArray()));
              localObject2 = WupUtil.a(((Unisso.UniSsoServerReq)localObject1).toByteArray());
              paramIntent.putExtra("k_retry", 2);
              localObject1 = "NewYearReport.pack_ranking";
              break;
            }
            localObject2 = new Unisso.UniSsoServerReq();
            localObject3 = new PackReport.PkgReq();
            ((PackReport.PkgReq)localObject3).promotion_id.set(paramIntent.getIntExtra("k_id", -1));
            ((PackReport.PkgReq)localObject3).uin.set(Long.valueOf(paramIntent.getStringExtra("k_uin")).longValue());
            long l2 = paramIntent.getLongExtra("key_seq", -1L);
            long l1 = l2;
            if (l2 == -1L)
            {
              l1 = NetConnInfoCenter.getServerTimeMillis();
              paramIntent.putExtra("key_seq", l1);
            }
            ((PackReport.PkgReq)localObject3).seq.set(l1);
            Object localObject5 = paramIntent.getExtras();
            if (localObject5 == null) {
              return;
            }
            localObject1 = (ArrayList)((Bundle)localObject5).getSerializable("k_b_list");
            if (localObject1 == null) {
              return;
            }
            localObject4 = new ArrayList();
            Object localObject6 = new PackReport.Report();
            localObject1 = ((ArrayList)localObject1).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              RedPacketServlet.BrashReportItem localBrashReportItem = (RedPacketServlet.BrashReportItem)((Iterator)localObject1).next();
              PackReport.ReportElem localReportElem = new PackReport.ReportElem();
              localReportElem.count.set(localBrashReportItem.count);
              localReportElem.timestamp.set(localBrashReportItem.time);
              ((PackReport.Report)localObject6).elems.add(localReportElem);
            }
            localObject1 = ((PackReport.Report)localObject6).id;
            if (paramIntent.getBooleanExtra("k_b_ing", false)) {
              l1 = 200L;
            } else {
              l1 = 100L;
            }
            ((PBUInt64Field)localObject1).set(l1);
            ((ArrayList)localObject4).add(localObject6);
            if (((Bundle)localObject5).containsKey("k_e_ctr"))
            {
              localObject6 = new PackReport.Report();
              ((PackReport.Report)localObject6).id.set(300L);
              localObject1 = new PackReport.ReportElem();
              ((PackReport.ReportElem)localObject1).count.set(((Bundle)localObject5).getInt("k_e_ctr"));
              ((PackReport.ReportElem)localObject1).timestamp.set(((Bundle)localObject5).getLong("k_s_time"));
              ((PackReport.Report)localObject6).elems.add((MessageMicro)localObject1);
              ((ArrayList)localObject4).add(localObject6);
              if (QLog.isColorLevel())
              {
                localObject6 = new StringBuilder();
                ((StringBuilder)localObject6).append("onSend, report EMPTY_COUNTER , elem.count = ");
                ((StringBuilder)localObject6).append(((PackReport.ReportElem)localObject1).count.get());
                QLog.d("RedPacketServlet", 2, ((StringBuilder)localObject6).toString());
              }
            }
            if (((Bundle)localObject5).containsKey("k_h_ctr"))
            {
              localObject6 = new PackReport.Report();
              ((PackReport.Report)localObject6).id.set(400L);
              localObject1 = new PackReport.ReportElem();
              ((PackReport.ReportElem)localObject1).count.set(((Bundle)localObject5).getInt("k_h_ctr"));
              ((PackReport.ReportElem)localObject1).timestamp.set(((Bundle)localObject5).getLong("k_s_time"));
              ((PackReport.Report)localObject6).elems.add((MessageMicro)localObject1);
              ((ArrayList)localObject4).add(localObject6);
              if (QLog.isColorLevel())
              {
                localObject6 = new StringBuilder();
                ((StringBuilder)localObject6).append("onSend, report HIT_COUNTER , elem.count = ");
                ((StringBuilder)localObject6).append(((PackReport.ReportElem)localObject1).count.get());
                QLog.d("RedPacketServlet", 2, ((StringBuilder)localObject6).toString());
              }
            }
            if (((Bundle)localObject5).containsKey("k_c_ctr"))
            {
              localObject6 = new PackReport.Report();
              ((PackReport.Report)localObject6).id.set(500L);
              localObject1 = new PackReport.ReportElem();
              ((PackReport.ReportElem)localObject1).count.set(((Bundle)localObject5).getInt("k_c_ctr"));
              ((PackReport.ReportElem)localObject1).timestamp.set(((Bundle)localObject5).getLong("k_s_time"));
              ((PackReport.Report)localObject6).elems.add((MessageMicro)localObject1);
              ((ArrayList)localObject4).add(localObject6);
              if (QLog.isColorLevel())
              {
                localObject5 = new StringBuilder();
                ((StringBuilder)localObject5).append("onSend, report reportContinuous , elem.count = ");
                ((StringBuilder)localObject5).append(((PackReport.ReportElem)localObject1).count.get());
                QLog.d("RedPacketServlet", 2, ((StringBuilder)localObject5).toString());
              }
            }
            ((PackReport.PkgReq)localObject3).report.set((List)localObject4);
            ((Unisso.UniSsoServerReq)localObject2).reqdata.set(ByteStringMicro.copyFrom(((PackReport.PkgReq)localObject3).toByteArray()));
            localObject1 = WupUtil.a(((Unisso.UniSsoServerReq)localObject2).toByteArray());
            paramIntent.putExtra("k_retry", 2);
            localObject2 = "NewYearReport.pack_report";
          }
          else
          {
            localObject1 = new ConfigurationService.ReqReportConfig();
            localObject2 = new ConfigurationService.ReportConfig();
            ((ConfigurationService.ReportConfig)localObject2).type.set(paramIntent.getIntExtra("k_type", -1));
            ((ConfigurationService.ReportConfig)localObject2).task_id.set(paramIntent.getIntExtra("k_id", -1));
            ((ConfigurationService.ReportConfig)localObject2).version.set(paramIntent.getIntExtra("k_version", -1));
            ((ConfigurationService.ReportConfig)localObject2).report_type.set(paramIntent.getIntExtra("k_opt", -1));
            ((ConfigurationService.ReportConfig)localObject2).result.set(paramIntent.getIntExtra("k_code", -1));
            ((ConfigurationService.ReqReportConfig)localObject1).config_list.add((MessageMicro)localObject2);
            localObject1 = WupUtil.a(((ConfigurationService.ReqReportConfig)localObject1).toByteArray());
            paramIntent.putExtra("k_retry", 2);
            localObject2 = "ConfigurationService.ReqReportConfig";
          }
        }
      }
      for (;;)
      {
        localObject3 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
        break;
        j = paramIntent.getIntExtra("k_id", 0);
        int m = paramIntent.getIntExtra("k_offset", 0);
        int n = paramIntent.getIntExtra("k_version", 0);
        localObject2 = paramIntent.getByteArrayExtra("k_cookie");
        localObject1 = new ConfigurationService.ReqGetConfigByPage();
        localObject3 = new ConfigurationService.PageReqInfo();
        ((ConfigurationService.PageReqInfo)localObject3).task_id.set(j);
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
        ((ConfigurationService.Screen)localObject3).width.set((int)DeviceInfoUtil.B());
        ((ConfigurationService.Screen)localObject3).height.set((int)DeviceInfoUtil.C());
        ((ConfigurationService.Screen)localObject3).dpi.set(DeviceInfoUtil.J());
        ((ConfigurationService.Screen)localObject3).multi_touch.set(DeviceInfoUtil.K());
        ((ConfigurationService.DeviceInfo)localObject2).setHasFlag(true);
        ((ConfigurationService.DeviceInfo)localObject2).screen = ((ConfigurationService.Screen)localObject3);
        ((ConfigurationService.ReqGetConfigByPage)localObject1).device_info.set((MessageMicro)localObject2);
        ((ConfigurationService.ReqGetConfigByPage)localObject1).type.set(1004);
        localObject1 = WupUtil.a(((ConfigurationService.ReqGetConfigByPage)localObject1).toByteArray());
        localObject2 = "ConfigurationService.ReqGetConfigByPage";
        continue;
        localObject1 = new Unisso.UniSsoServerReq();
        localObject2 = new FestivalPack.PkgReq();
        j = paramIntent.getIntExtra("k_condition", 0);
        m = paramIntent.getIntExtra("k_id", 0);
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("onSend CMD_RESULT promotionID = ");
          ((StringBuilder)localObject3).append(m);
          ((StringBuilder)localObject3).append(",condition = ");
          ((StringBuilder)localObject3).append(j);
          QLog.d("RedPacketServlet", 2, ((StringBuilder)localObject3).toString());
        }
        localObject3 = new FestivalPack.NewYearEvePackReq();
        ((FestivalPack.NewYearEvePackReq)localObject3).promotion_id.set(m);
        ((FestivalPack.NewYearEvePackReq)localObject3).action.set(1);
        ((FestivalPack.NewYearEvePackReq)localObject3).condition.set(j);
        ((FestivalPack.PkgReq)localObject2).cmdtype.set(1);
        ((FestivalPack.PkgReq)localObject2).from_id.set(1);
        ((FestivalPack.PkgReq)localObject2).get_eve_pack.set((MessageMicro)localObject3);
        localObject3 = new Unisso.UniSsoServerReqComm();
        ((Unisso.UniSsoServerReqComm)localObject3).mqqver.set("8.8.17");
        ((Unisso.UniSsoServerReqComm)localObject3).platform.set(109L);
        ((Unisso.UniSsoServerReqComm)localObject3).osver.set(Build.VERSION.RELEASE);
        ((Unisso.UniSsoServerReq)localObject1).comm.set((MessageMicro)localObject3);
        ((Unisso.UniSsoServerReq)localObject1).reqdata.set(ByteStringMicro.copyFrom(((FestivalPack.PkgReq)localObject2).toByteArray()));
        localObject1 = WupUtil.a(((Unisso.UniSsoServerReq)localObject1).toByteArray());
        paramIntent.putExtra("k_retry", 2);
        localObject2 = "NY2021Lottery.shua";
      }
      localObject3 = localObject1;
      localObject4 = localObject2;
      j = i;
      if (localObject1 != null)
      {
        localObject3 = localObject1;
        localObject4 = localObject2;
        j = i;
        if (!bool)
        {
          paramIntent.putExtra("k_sso_id", (String)localObject1);
          paramIntent.putExtra("k_sso_data", (byte[])localObject2);
          j = i;
          localObject4 = localObject2;
          localObject3 = localObject1;
        }
      }
    }
    if (QLog.isColorLevel())
    {
      paramIntent = new StringBuilder();
      paramIntent.append("onSend, ");
      paramIntent.append(k);
      paramIntent.append(", ");
      paramIntent.append(j);
      paramIntent.append(", ");
      paramIntent.append(bool);
      paramIntent.append(", ");
      paramIntent.append((String)localObject3);
      paramIntent.append(", ");
      paramIntent.append(localObject4);
      QLog.d("RedPacketServlet", 2, paramIntent.toString());
    }
    if ((localObject3 != null) && (localObject4 != null))
    {
      paramPacket.setSSOCommand((String)localObject3);
      paramPacket.putSendData((byte[])localObject4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.portal.RedPacketServlet
 * JD-Core Version:    0.7.0.1
 */