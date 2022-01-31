package oicq.wlogin_sdk.request;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import oicq.wlogin_sdk.a.g;
import oicq.wlogin_sdk.code2d.fetch_code;
import oicq.wlogin_sdk.code2d.fetch_code.QRCodeCustom;
import oicq.wlogin_sdk.devicelock.DevlockBase;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import oicq.wlogin_sdk.devicelock.DevlockRst;
import oicq.wlogin_sdk.devicelock.TLV_CommRsp;
import oicq.wlogin_sdk.report.Reporter;
import oicq.wlogin_sdk.report.report_t2;
import oicq.wlogin_sdk.sharemem.WloginLoginInfo;
import oicq.wlogin_sdk.sharemem.WloginSigInfo;
import oicq.wlogin_sdk.sharemem.WloginSimpleInfo;
import oicq.wlogin_sdk.tlv_type.RegTLV;
import oicq.wlogin_sdk.tlv_type.tlv_t;
import oicq.wlogin_sdk.tlv_type.tlv_t105;
import oicq.wlogin_sdk.tlv_type.tlv_t106;
import oicq.wlogin_sdk.tlv_type.tlv_t10c;
import oicq.wlogin_sdk.tlv_type.tlv_t145;
import oicq.wlogin_sdk.tlv_type.tlv_t150;
import oicq.wlogin_sdk.tlv_type.tlv_t165;
import oicq.wlogin_sdk.tlv_type.tlv_t16a;
import oicq.wlogin_sdk.tlv_type.tlv_t400;
import oicq.wlogin_sdk.tools.EcdhCrypt;
import oicq.wlogin_sdk.tools.ErrMsg;
import oicq.wlogin_sdk.tools.InternationMsg;
import oicq.wlogin_sdk.tools.InternationMsg.MSG_TYPE;
import oicq.wlogin_sdk.tools.MD5;
import oicq.wlogin_sdk.tools.RSACrypt;
import oicq.wlogin_sdk.tools.cryptor;
import oicq.wlogin_sdk.tools.util;

public class WtloginHelper
{
  static final Object GET_ST_WITHOUT_PASSWORD_LOCK = new Object();
  static final Object GET_TICKET_LOCK = new Object();
  static final Object __sync_top;
  static int __top = 0;
  private boolean isForLocal = false;
  private long mAysncSeq = 0L;
  private Context mContext = null;
  private t mG = new t(null);
  private Handler mHelperHandler = initHelperHandler();
  private WtloginListener mListener = null;
  private int mMainSigMap = 16724722;
  private int mMiscBitmap = 150470524;
  private long mOpenAppid = 715019303L;
  private oicq.wlogin_sdk.a.j mRegStatus = new oicq.wlogin_sdk.a.j();
  private int mSubSigMap = 66560;
  
  static
  {
    __sync_top = new Object();
  }
  
  public WtloginHelper(Context paramContext)
  {
    this.isForLocal = false;
    this.mContext = paramContext;
    this.mG.b(paramContext);
    RequestInit();
  }
  
  public WtloginHelper(Context paramContext, Object paramObject)
  {
    WtloginMsfListener.TicketMgr = paramObject;
    localInit(paramContext, this.isForLocal);
  }
  
  public WtloginHelper(Context paramContext, boolean paramBoolean)
  {
    localInit(paramContext, paramBoolean);
  }
  
  private void AsyncGenRSAKey()
  {
    if (this.isForLocal) {
      return;
    }
    new WtloginHelper.2(this, "Wtlogin_AsyncGenRSAKey").start();
  }
  
  private int CheckPictureAndGetSt(String paramString, byte[] paramArrayOfByte, WUserSigInfo paramWUserSigInfo, byte[][] paramArrayOfByte1, int paramInt)
  {
    if ((paramString == null) || (paramArrayOfByte == null) || (paramWUserSigInfo == null)) {
      return -1017;
    }
    if (paramInt == 0)
    {
      new WtloginHelper.HelperThread(this, this, this.mHelperHandler, paramString, paramArrayOfByte, paramWUserSigInfo, paramArrayOfByte1, "CheckPictureAndGetSt").RunReq(2);
      return -1001;
    }
    int i = 0;
    if (paramWUserSigInfo._seqence == 0L) {
      paramWUserSigInfo._seqence = this.mAysncSeq;
    }
    t localt = this.mG.a(paramWUserSigInfo._seqence);
    paramWUserSigInfo._seqence = localt.h;
    async_context localasync_context = t.b(paramWUserSigInfo._seqence);
    util.LOGI("user:" + paramString + " CheckPictureAndGetSt" + " Seq:" + localt.h + " ...", paramString);
    localt.g = paramString;
    localasync_context._last_err_msg = new ErrMsg();
    long l1;
    if (!util.check_uin_account(paramString).booleanValue())
    {
      long l2 = localt.b(paramString);
      l1 = l2;
      if (l2 != 0L)
      {
        i = 1;
        l1 = l2;
      }
    }
    for (;;)
    {
      if (i == 1)
      {
        localt.f = l1;
        paramWUserSigInfo.uin = (l1 + "");
      }
      int j = new n(localt).a(paramArrayOfByte, this.mMiscBitmap, this.mSubSigMap, localasync_context._sub_appid_list, paramWUserSigInfo);
      paramInt = j;
      if (j == 204) {
        paramInt = new p(localt).a(this.mMiscBitmap, this.mSubSigMap, localasync_context._sub_appid_list, paramWUserSigInfo);
      }
      if ((paramInt == 0) || (paramInt == 160)) {
        break;
      }
      paramWUserSigInfo = GetUserSigInfoTicket(paramWUserSigInfo, 128);
      paramArrayOfByte = paramWUserSigInfo;
      if (paramWUserSigInfo == null) {
        paramArrayOfByte = new Ticket();
      }
      t.aq.commit_t2(localt.f, localt.g, util.format_ret_code(paramInt), paramInt);
      if (paramInt != 0) {
        break label1399;
      }
      if ((paramArrayOfByte._sig != null) && (paramArrayOfByte._sig.length != 0)) {
        RequestReport(0, paramArrayOfByte._sig, paramArrayOfByte._sig_key, localt.f, localasync_context._appid);
      }
      label408:
      if ((localt.d != null) && (localt.d.get_bitmap() != 0))
      {
        this.mG.d = localt.d;
        RequestReportError(0, paramArrayOfByte._sig, paramArrayOfByte._sig_key, localt.f, localasync_context._appid, 1);
      }
      t.b();
      localt.i();
      util.LOGI("user:" + paramString + " CheckPictureAndGetSt" + " Seq:" + localt.h + " ret=" + paramInt, "" + localt.f);
      return paramInt;
      l1 = Long.parseLong(paramString);
      i = 1;
    }
    if (!util.check_uin_account(paramString).booleanValue())
    {
      l1 = localt.b(paramString);
      if (l1 == 0L) {
        break label1427;
      }
      i = 1;
    }
    label900:
    label1427:
    for (;;)
    {
      if ((localasync_context._msalt == 0L) && (i == 0))
      {
        paramInt = -1003;
        break;
        l1 = Long.parseLong(paramString);
        i = 1;
        continue;
      }
      localt.f = l1;
      paramWUserSigInfo.uin = (l1 + "");
      if (paramInt == 160) {
        break;
      }
      if ((paramWUserSigInfo._reserveData != null) && (paramWUserSigInfo._reserveData.length > 3))
      {
        localt.i = util.buf_to_int32(paramWUserSigInfo._reserveData, 0);
        util.LOGI("MSF SSO SEQ:" + localt.i, paramString);
      }
      for (;;)
      {
        paramArrayOfByte = localt.a(l1, localasync_context._appid);
        if (paramArrayOfByte == null) {
          break label874;
        }
        paramWUserSigInfo.get_clone(paramArrayOfByte);
        if ((localasync_context._sub_appid_list == null) || (paramArrayOfByte1 == null) || (localasync_context._sub_appid_list.length * 2 != paramArrayOfByte1.length)) {
          break;
        }
        paramInt = 0;
        while ((localasync_context._sub_appid_list != null) && (paramInt < localasync_context._sub_appid_list.length))
        {
          paramArrayOfByte = localt.a(l1, localasync_context._sub_appid_list[paramInt]);
          if (paramArrayOfByte != null)
          {
            paramArrayOfByte1[(paramInt * 2)] = ((byte[])paramArrayOfByte._userSt_Key.clone());
            paramArrayOfByte1[(paramInt * 2 + 1)] = ((byte[])paramArrayOfByte._userStSig.clone());
          }
          paramInt += 1;
        }
        localt.i = 0;
      }
      paramInt = 0;
      break;
      label874:
      Object localObject;
      if ((paramWUserSigInfo._in_ksid != null) && (paramWUserSigInfo._in_ksid.length > 0))
      {
        paramArrayOfByte = (byte[])paramWUserSigInfo._in_ksid.clone();
        if (localasync_context._tmp_pwd_type == 0) {
          break label1135;
        }
        localObject = new k(localt, this.mContext);
        ((k)localObject).g();
        paramInt = ((k)localObject).a(localasync_context._appid, localasync_context._sub_appid, localt.f, 0, t.af, localasync_context._tmp_pwd, null, this.mMiscBitmap, this.mSubSigMap, localasync_context._sub_appid_list, localasync_context._main_sigmap, localasync_context._sub_appid, t.y, 0, 0, 1, paramArrayOfByte, paramWUserSigInfo);
        i = paramInt;
        if (paramInt == 204) {
          i = new p(localt).a(this.mMiscBitmap, this.mSubSigMap, localasync_context._sub_appid_list, paramWUserSigInfo);
        }
        if (i != 0)
        {
          paramInt = i;
          if (i != 160) {
            break;
          }
        }
        if (!localasync_context.ifQQLoginInQim(t.ax)) {
          break label1263;
        }
      }
      label1263:
      for (l1 = localasync_context._uin;; l1 = localt.b(paramString))
      {
        paramWUserSigInfo.uin = (l1 + "");
        paramInt = i;
        if (i == 160) {
          break;
        }
        paramArrayOfByte = localt.a(l1, localasync_context._appid);
        if (paramArrayOfByte != null) {
          break label1274;
        }
        paramInt = -1004;
        break;
        paramArrayOfByte = t.ac;
        break label900;
        label1135:
        localObject = new byte[4];
        util.int64_to_buf32((byte[])localObject, 0, System.currentTimeMillis() / 1000L + t.ae);
        if (localasync_context._isSmslogin) {}
        for (paramInt = 3;; paramInt = 1)
        {
          k localk = new k(localt, this.mContext);
          localk.g();
          paramInt = localk.a(localasync_context._appid, localasync_context._sub_appid, localt.f, 0, t.af, (byte[])localObject, localasync_context._tmp_pwd, paramInt, this.mMiscBitmap, this.mSubSigMap, localasync_context._sub_appid_list, localasync_context._main_sigmap, localasync_context._sub_appid, t.y, 0, 0, 1, paramArrayOfByte, paramWUserSigInfo);
          break;
        }
      }
      label1274:
      paramWUserSigInfo.get_clone(paramArrayOfByte);
      if ((localasync_context._sub_appid_list != null) && (paramArrayOfByte1 != null) && (localasync_context._sub_appid_list.length * 2 == paramArrayOfByte1.length))
      {
        paramInt = 0;
        while ((localasync_context._sub_appid_list != null) && (paramInt < localasync_context._sub_appid_list.length))
        {
          paramArrayOfByte = localt.a(l1, localasync_context._sub_appid_list[paramInt]);
          if (paramArrayOfByte != null)
          {
            paramArrayOfByte1[(paramInt * 2)] = ((byte[])paramArrayOfByte._userSt_Key.clone());
            paramArrayOfByte1[(paramInt * 2 + 1)] = ((byte[])paramArrayOfByte._userStSig.clone());
          }
          paramInt += 1;
        }
      }
      paramInt = 0;
      break;
      label1399:
      RequestReportError(0, paramArrayOfByte._sig, paramArrayOfByte._sig_key, localt.f, localasync_context._appid, 0);
      break label408;
    }
  }
  
  private int CheckSMSAndGetSt(String paramString, byte[] paramArrayOfByte, WUserSigInfo paramWUserSigInfo, byte[][] paramArrayOfByte1, int paramInt)
  {
    if ((paramString == null) || (paramArrayOfByte == null) || (paramWUserSigInfo == null)) {
      return -1017;
    }
    if (paramInt == 0)
    {
      new WtloginHelper.HelperThread(this, this, this.mHelperHandler, paramString, paramArrayOfByte, paramWUserSigInfo, paramArrayOfByte1, "CheckSMSAndGetSt").RunReq(4);
      return -1001;
    }
    if (paramWUserSigInfo._seqence == 0L) {
      paramWUserSigInfo._seqence = this.mAysncSeq;
    }
    t localt = this.mG.a(paramWUserSigInfo._seqence);
    paramWUserSigInfo._seqence = localt.h;
    async_context localasync_context = t.b(paramWUserSigInfo._seqence);
    util.LOGI("user:" + paramString + " CheckSMSAndGetSt" + " Seq:" + localt.h + " ...", paramString);
    localt.g = paramString;
    localt.f = 0L;
    localasync_context._last_err_msg = new ErrMsg();
    if ((paramWUserSigInfo._reserveData != null) && (paramWUserSigInfo._reserveData.length > 3))
    {
      localt.i = util.buf_to_int32(paramWUserSigInfo._reserveData, 0);
      util.LOGI("MSF SSO SEQ:" + localt.i, paramString);
    }
    while (!util.check_uin_account(paramString).booleanValue())
    {
      l = localt.b(paramString);
      if (l != 0L) {
        break label777;
      }
      util.LOGI("user:" + paramString + " have not found uin record.", paramString);
      paramInt = -1003;
      paramWUserSigInfo = GetUserSigInfoTicket(paramWUserSigInfo, 128);
      paramArrayOfByte = paramWUserSigInfo;
      if (paramWUserSigInfo == null) {
        paramArrayOfByte = new Ticket();
      }
      t.aq.commit_t2(localt.f, localt.g, util.format_ret_code(paramInt), paramInt);
      if (paramInt != 0) {
        break label749;
      }
      if ((paramArrayOfByte._sig != null) && (paramArrayOfByte._sig.length != 0)) {
        RequestReport(0, paramArrayOfByte._sig, paramArrayOfByte._sig_key, localt.f, localasync_context._appid);
      }
      label374:
      if ((localt.d != null) && (localt.d.get_bitmap() != 0))
      {
        this.mG.d = localt.d;
        RequestReportError(0, paramArrayOfByte._sig, paramArrayOfByte._sig_key, localt.f, localasync_context._appid, 1);
      }
      t.b();
      localt.i();
      util.LOGI("user:" + paramString + " CheckSMSAndGetSt" + " Seq:" + localt.h + " ret=" + paramInt, "" + localt.f);
      return paramInt;
      localt.i = 0;
    }
    long l = Long.parseLong(paramString);
    label777:
    for (;;)
    {
      localt.f = l;
      paramWUserSigInfo.uin = (l + "");
      paramInt = new o(localt).a(paramArrayOfByte, this.mMiscBitmap, this.mSubSigMap, localasync_context._sub_appid_list, paramWUserSigInfo);
      if (paramInt != 0) {
        break;
      }
      paramArrayOfByte = localt.a(l, localasync_context._appid);
      if (paramArrayOfByte == null)
      {
        paramInt = -1004;
        break;
      }
      paramWUserSigInfo.get_clone(paramArrayOfByte);
      if ((localasync_context._sub_appid_list != null) && (paramArrayOfByte1 != null) && (localasync_context._sub_appid_list.length * 2 == paramArrayOfByte1.length))
      {
        paramInt = 0;
        while ((localasync_context._sub_appid_list != null) && (paramInt < localasync_context._sub_appid_list.length))
        {
          paramArrayOfByte = localt.a(l, localasync_context._sub_appid_list[paramInt]);
          if (paramArrayOfByte != null)
          {
            paramArrayOfByte1[(paramInt * 2)] = ((byte[])paramArrayOfByte._userSt_Key.clone());
            paramArrayOfByte1[(paramInt * 2 + 1)] = ((byte[])paramArrayOfByte._userStSig.clone());
          }
          paramInt += 1;
        }
      }
      paramInt = 0;
      break;
      label749:
      RequestReportError(0, paramArrayOfByte._sig, paramArrayOfByte._sig_key, localt.f, localasync_context._appid, 0);
      break label374;
    }
  }
  
  private int CheckSMSVerifyLoginAccount(long paramLong1, long paramLong2, String paramString, int paramInt1, long paramLong3, WUserSigInfo paramWUserSigInfo, int paramInt2)
  {
    oicq.wlogin_sdk.a.j.x = false;
    oicq.wlogin_sdk.a.j.y = 0L;
    if (((paramLong3 == -1L) && (paramString == null)) || (paramWUserSigInfo == null)) {
      return -1017;
    }
    if (paramInt2 == 0)
    {
      new WtloginHelper.HelperThread(this, this, this.mHelperHandler, paramLong1, paramLong2, paramString, paramInt1, paramLong3, paramWUserSigInfo, "CheckSMSVerifyLoginAccount").RunReq(12);
      return -1001;
    }
    Object localObject = this.mG.a(0L);
    paramWUserSigInfo._seqence = ((t)localObject).h;
    this.mAysncSeq = ((t)localObject).h;
    async_context localasync_context = t.b(((t)localObject).h);
    ((t)localObject).g = paramString;
    util.LOGI("user:" + paramString + " Seq:" + ((t)localObject).h + " CheckSMSVerifyLoginAccount ...", paramString);
    localasync_context._login_bitmap = paramWUserSigInfo._login_bitmap;
    localasync_context._last_err_msg = new ErrMsg();
    paramInt2 = new w((t)localObject).a(paramLong1, paramLong2, this.mMainSigMap, t.ac, paramString, this.mMiscBitmap, this.mSubSigMap, null, paramInt1, paramLong3, paramWUserSigInfo);
    paramInt1 = paramInt2;
    if (paramInt2 == 208) {
      paramInt1 = 0;
    }
    localObject = new StringBuilder().append("user:").append(((t)localObject).g).append(" Seq:").append(((t)localObject).h).append(" CheckSMSVerifyLoginAccount ret=");
    if (paramInt1 > 0) {}
    for (paramWUserSigInfo = Integer.toHexString(paramInt1);; paramWUserSigInfo = Integer.valueOf(paramInt1))
    {
      util.LOGI(paramWUserSigInfo, paramString);
      return paramInt1;
    }
  }
  
  private WloginSigInfo FindUserSig(long paramLong1, long paramLong2)
  {
    return this.mG.a(paramLong1, paramLong2);
  }
  
  private byte[] GetA1ByAccount(String paramString, long paramLong)
  {
    if (paramString == null) {
      return null;
    }
    long l1;
    Object localObject;
    if (!util.check_uin_account(paramString).booleanValue())
    {
      long l2 = this.mG.b(paramString);
      l1 = l2;
      if (l2 != 0L) {
        break label110;
      }
      localObject = null;
    }
    while ((localObject == null) || (localObject._en_A1 == null) || (localObject._en_A1.length <= 0))
    {
      util.LOGI("userAccount:" + paramString + " dwAppid:" + paramLong + " GetA1ByAccount is: null", paramString);
      return null;
      l1 = Long.parseLong(paramString);
      label110:
      WloginSigInfo localWloginSigInfo = this.mG.a(l1, paramLong);
      localObject = localWloginSigInfo;
      if (localWloginSigInfo == null) {
        localObject = localWloginSigInfo;
      }
    }
    util.LOGI("A1_INFO: userAccount:" + paramString + " dwAppid:" + paramLong + " GetA1ByAccount: " + MD5.getMD5String(localObject._en_A1), paramString);
    return (byte[])localObject._en_A1.clone();
  }
  
  private int GetA1WithA1(String paramString, long paramLong1, long paramLong2, int paramInt1, byte[] paramArrayOfByte1, long paramLong3, long paramLong4, long paramLong5, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, WUserSigInfo paramWUserSigInfo, WFastLoginInfo paramWFastLoginInfo, int paramInt2)
  {
    if ((paramString == null) || (paramArrayOfByte1 == null) || (paramArrayOfByte2 == null) || (paramArrayOfByte3 == null) || (paramWUserSigInfo == null) || (paramWFastLoginInfo == null)) {
      return -1017;
    }
    int i = paramInt1 | 0xC0;
    if (paramInt2 == 0)
    {
      new WtloginHelper.HelperThread(this, this, this.mHelperHandler, paramString, paramLong1, paramLong2, i, paramArrayOfByte1, paramLong3, paramLong4, paramLong5, paramArrayOfByte2, paramArrayOfByte3, paramWUserSigInfo, paramWFastLoginInfo, "GetA1WithA1").RunReq(6);
      return -1001;
    }
    t localt = this.mG.a(0L);
    paramWUserSigInfo._seqence = localt.h;
    Object localObject = t.b(localt.h);
    util.LOGI("wtlogin login with GetA1WithA1:" + paramString + " dwSrcAppid:" + paramLong1 + " dwMainSigMap:" + i + " dwSubSrcAppid:" + paramLong2 + " dstAppName:" + new String(paramArrayOfByte1) + " dwDstAppid:" + paramLong4 + " dwSubDstAppid:" + paramLong5 + " Seq:" + localt.h + " ...", paramString);
    paramInt1 = util.get_saved_network_type(this.mContext);
    t.D = util.get_network_type(this.mContext);
    if (paramInt1 != t.D)
    {
      util.set_net_retry_type(this.mContext, 0);
      util.save_network_type(this.mContext, t.D);
    }
    t.F = util.get_apn_string(this.mContext).getBytes();
    localt.g = paramString;
    localt.f = 0L;
    ((async_context)localObject)._sappid = paramLong1;
    ((async_context)localObject)._appid = paramLong1;
    ((async_context)localObject)._sub_appid = paramLong2;
    ((async_context)localObject)._main_sigmap = i;
    ((async_context)localObject)._last_err_msg = new ErrMsg();
    t.aq.add_t2(new report_t2("login", new String(t.C), System.currentTimeMillis(), paramLong4, paramLong5, null));
    long l1;
    if (!util.check_uin_account(paramString).booleanValue())
    {
      long l2 = localt.b(paramString);
      l1 = l2;
      if (l2 != 0L) {
        break label728;
      }
      util.LOGI("user:" + paramString + " have not found uin record.", paramString);
      paramInt1 = -1003;
      paramArrayOfByte3 = GetUserSigInfoTicket(paramWUserSigInfo, 128);
      paramArrayOfByte2 = paramArrayOfByte3;
      if (paramArrayOfByte3 == null) {
        paramArrayOfByte2 = new Ticket();
      }
      t.aq.commit_t2(localt.f, localt.g, util.format_ret_code(paramInt1), paramInt1);
      if (paramInt1 != 0) {
        break label938;
      }
      if ((paramArrayOfByte2._sig != null) && (paramArrayOfByte2._sig.length != 0)) {
        RequestReport(0, paramArrayOfByte2._sig, paramArrayOfByte2._sig_key, localt.f, paramLong1);
      }
    }
    for (;;)
    {
      if ((localt.d != null) && (localt.d.get_bitmap() != 0))
      {
        this.mG.d = localt.d;
        RequestReportError(0, paramArrayOfByte2._sig, paramArrayOfByte2._sig_key, localt.f, paramLong1, 1);
      }
      t.b();
      localt.i();
      util.LOGI("wtlogin login with GetA1WithA1:" + paramString + " dwSrcAppid:" + paramLong1 + " dwMainSigMap:" + i + " dwSubSrcAppid:" + paramLong2 + " dstAppName:" + new String(paramArrayOfByte1) + " dwDstAppid:" + paramLong4 + " dwSubDstAppid:" + paramLong5 + " Seq:" + localt.h + " ret=" + paramInt1, paramString);
      return paramInt1;
      l1 = Long.parseLong(paramString);
      label728:
      localt.f = l1;
      localt.k();
      localObject = GetA1ByAccount(paramString, paramLong1);
      byte[] arrayOfByte = GetNoPicSigByAccount(paramString, paramLong1);
      if ((localObject == null) || (localObject.length <= 0))
      {
        util.LOGI("user:" + paramString + " have no a1 or pic_sig.", paramString);
        paramInt1 = -1016;
        break;
      }
      util.LOGI("user:" + paramString + " login with A1 exchange A1.", paramString);
      paramInt2 = new l(localt).a(l1, paramLong1, paramLong2, 1, i, (byte[])localObject, arrayOfByte, this.mMiscBitmap, this.mSubSigMap, null, paramArrayOfByte1, paramLong3, paramLong4, paramLong5, paramArrayOfByte2, paramArrayOfByte3, paramWUserSigInfo);
      paramInt1 = paramInt2;
      if (paramInt2 != 0) {
        break;
      }
      paramArrayOfByte2 = localt.a(l1, paramLong1);
      if (paramArrayOfByte2 == null)
      {
        paramInt1 = -1004;
        break;
      }
      paramWUserSigInfo.get_clone(paramArrayOfByte2);
      paramWFastLoginInfo.get_clone(localt.j);
      paramInt1 = paramInt2;
      break;
      label938:
      RequestReportError(0, paramArrayOfByte2._sig, paramArrayOfByte2._sig_key, localt.f, paramLong1, 0);
    }
  }
  
  private int GetFastLoginInfo(byte[] paramArrayOfByte, async_context paramasync_context)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 3) || (paramasync_context == null)) {
      return -1017;
    }
    tlv_t106 localtlv_t106 = new tlv_t106();
    tlv_t10c localtlv_t10c = new tlv_t10c();
    tlv_t16a localtlv_t16a = new tlv_t16a();
    Object localObject = new tlv_t145();
    int i = paramArrayOfByte.length;
    if (localtlv_t106.get_tlv(paramArrayOfByte, 3, i) < 0)
    {
      util.LOGI("fast login info no tgtgt data", "");
      return -1017;
    }
    if (localtlv_t10c.get_tlv(paramArrayOfByte, 3, i) < 0)
    {
      util.LOGI("fast login info no gtkey data", "");
      return -1017;
    }
    if (localtlv_t16a.get_tlv(paramArrayOfByte, 3, i) < 0)
    {
      util.LOGI("fast login info no nopicsig data", "");
      return -1017;
    }
    if (((tlv_t145)localObject).get_tlv(paramArrayOfByte, 3, i) > 0)
    {
      paramArrayOfByte = ((tlv_t145)localObject).get_data();
      localObject = t.A;
      util.LOGD("new guid:" + util.buf_to_string(paramArrayOfByte) + " old guid:" + util.buf_to_string((byte[])localObject));
      if (!Arrays.equals(paramArrayOfByte, (byte[])localObject))
      {
        util.LOGI("fast login info guid not equal", "");
        util.saveGuidToFile(t.t, paramArrayOfByte);
        t.A = (byte[])paramArrayOfByte.clone();
        t.B = (byte[])paramArrayOfByte.clone();
      }
    }
    paramasync_context._tmp_pwd = oicq_request.b(localtlv_t106.get_data(), localtlv_t10c.get_data());
    paramasync_context._tmp_no_pic_sig = localtlv_t16a.get_data();
    return 0;
  }
  
  public static WFastLoginInfo GetFastLoginUrl(String paramString, long paramLong)
  {
    if (paramString != null) {
      try
      {
        if (paramString.length() != 0)
        {
          util.LOGI("packageName:" + paramString + " uin:" + paramLong, "");
          if (paramLong == 1689053018L) {}
          for (String str = "http://imgcache.qq.com/wtlogin" + "/test";; str = "http://imgcache.qq.com/wtlogin" + "/app")
          {
            paramString = paramString.split("\\.");
            int i = 0;
            while (i < paramString.length)
            {
              str = str + "/";
              str = str + paramString[i];
              i += 1;
            }
          }
          paramString = new WFastLoginInfo();
          paramString.iconUrl = (str + "/icon.png");
          paramString.adUrl = (str + "/ad_img.png");
          paramString.profileUrl = (str + "/profile.js");
          return paramString;
        }
      }
      catch (Exception paramString)
      {
        return null;
      }
    }
    return null;
  }
  
  private byte[] GetNoPicSigByAccount(String paramString, long paramLong)
  {
    if (paramString == null) {
      return null;
    }
    long l1;
    Object localObject;
    if (!util.check_uin_account(paramString).booleanValue())
    {
      long l2 = this.mG.b(paramString);
      l1 = l2;
      if (l2 != 0L) {
        break label110;
      }
      localObject = null;
    }
    while ((localObject == null) || (localObject._noPicSig == null) || (localObject._noPicSig.length <= 0))
    {
      util.LOGI("userAccount:" + paramString + " dwAppid:" + paramLong + " GetNoPicSigByAccount return: null", paramString);
      return null;
      l1 = Long.parseLong(paramString);
      label110:
      WloginSigInfo localWloginSigInfo = this.mG.a(l1, paramLong);
      localObject = localWloginSigInfo;
      if (localWloginSigInfo == null) {
        localObject = localWloginSigInfo;
      }
    }
    util.LOGI("userAccount:" + paramString + " dwAppid:" + paramLong + " GetNoPicSigByAccount return: not null", paramString);
    return (byte[])localObject._noPicSig.clone();
  }
  
  private int GetStWithPasswd(String paramString1, long paramLong1, int paramInt1, long paramLong2, long[] paramArrayOfLong, boolean paramBoolean1, String paramString2, WUserSigInfo paramWUserSigInfo, byte[][] paramArrayOfByte, boolean paramBoolean2, int paramInt2)
  {
    if ((paramString1 == null) || (paramWUserSigInfo == null)) {
      return -1017;
    }
    int j = paramInt1 | 0xC0;
    paramInt1 = this.mMiscBitmap;
    int i = paramInt1;
    if (t.ab) {
      i = paramInt1 | 0x2000000;
    }
    if (paramInt2 == 0)
    {
      new WtloginHelper.HelperThread(this, this, this.mHelperHandler, paramString1, paramLong1, j, paramLong2, paramArrayOfLong, paramBoolean1, paramString2, paramWUserSigInfo, paramArrayOfByte, paramBoolean2, "GetStWithPasswd").RunReq(0);
      return -1001;
    }
    paramInt1 = 1;
    t localt;
    async_context localasync_context;
    Object localObject;
    label515:
    long l1;
    if ((paramBoolean2) && (!oicq.wlogin_sdk.a.j.x))
    {
      if (paramWUserSigInfo._seqence == 0L) {
        paramWUserSigInfo._seqence = this.mAysncSeq;
      }
      localt = this.mG.a(paramWUserSigInfo._seqence);
      paramWUserSigInfo._seqence = localt.h;
      localasync_context = t.b(localt.h);
      util.LOGI("start GetStWithPasswd:user:" + paramString1 + " dwAppid:" + paramLong1 + " dwMainSigMap:0x" + Integer.toHexString(j) + " dwSubAppid:" + paramLong2 + " Seq:" + localt.h + " ...", paramString1);
      localasync_context._isSmslogin = paramBoolean2;
      localObject = paramString2;
      if (paramBoolean2)
      {
        localObject = paramString2;
        if (paramString2.length() == 0) {
          localObject = localasync_context._mpasswd;
        }
      }
      oicq.wlogin_sdk.a.j.x = false;
      oicq.wlogin_sdk.a.j.z = "";
      paramString2 = (String)localObject;
      if (localObject != null)
      {
        paramString2 = (String)localObject;
        if (((String)localObject).length() > 16) {
          paramString2 = ((String)localObject).substring(0, 16);
        }
      }
      paramInt2 = util.get_saved_network_type(this.mContext);
      t.D = util.get_network_type(this.mContext);
      if (paramInt2 != t.D)
      {
        util.set_net_retry_type(this.mContext, 0);
        util.save_network_type(this.mContext, t.D);
      }
      t.F = util.get_apn_string(this.mContext).getBytes();
      localt.g = paramString1;
      localt.f = 0L;
      localasync_context._sappid = paramLong1;
      localasync_context._appid = paramLong1;
      localasync_context._sub_appid_list = null;
      localasync_context._sub_appid = paramLong2;
      localasync_context._main_sigmap = j;
      localasync_context._login_bitmap = paramWUserSigInfo._login_bitmap;
      localasync_context._last_err_msg = new ErrMsg();
      if (paramArrayOfLong != null) {
        localasync_context._sub_appid_list = ((long[])paramArrayOfLong.clone());
      }
      if ((paramWUserSigInfo._reserveData == null) || (paramWUserSigInfo._reserveData.length <= 3)) {
        break label949;
      }
      localt.i = util.buf_to_int32(paramWUserSigInfo._reserveData, 0);
      util.LOGI("MSF SSO SEQ:" + localt.i, paramString1);
      t.aq.add_t2(new report_t2("login", new String(t.C), System.currentTimeMillis(), paramLong1, paramLong2, paramArrayOfLong));
      if (util.check_uin_account(paramString1).booleanValue()) {
        break label987;
      }
      if (!localasync_context.ifQQLoginInQim(t.ax)) {
        break label958;
      }
      paramInt1 = 0;
      l1 = 0L;
      label577:
      if ((paramString2 == null) || (paramString2.length() <= 0)) {
        break label1019;
      }
      if (!paramBoolean1) {
        break label1006;
      }
    }
    long l2;
    for (;;)
    {
      try
      {
        localasync_context._tmp_pwd = ((byte[])paramString2.getBytes("ISO-8859-1").clone());
        localasync_context._tmp_pwd_type = 0;
        l2 = l1;
        if (paramInt1 != 0) {
          break label2068;
        }
        if (paramString1.length() <= util.MAX_NAME_LEN) {
          break label1219;
        }
        paramInt1 = -1008;
      }
      catch (Exception paramArrayOfLong)
      {
        label644:
        label743:
        paramInt1 = -1013;
        label949:
        label958:
        label987:
        continue;
      }
      paramString2 = GetUserSigInfoTicket(paramWUserSigInfo, 128);
      paramArrayOfLong = paramString2;
      if (paramString2 == null) {
        paramArrayOfLong = new Ticket();
      }
      t.aq.commit_t2(localt.f, localt.g, util.format_ret_code(paramInt1), paramInt1);
      if (paramInt1 != 0) {
        break label2024;
      }
      if ((paramArrayOfLong._sig != null) && (paramArrayOfLong._sig.length != 0)) {
        RequestReport(0, paramArrayOfLong._sig, paramArrayOfLong._sig_key, localt.f, localasync_context._appid);
      }
      if ((localt.d != null) && (localt.d.get_bitmap() != 0))
      {
        this.mG.d = localt.d;
        RequestReportError(0, paramArrayOfLong._sig, paramArrayOfLong._sig_key, localt.f, localasync_context._appid, 1);
      }
      t.b();
      localt.i();
      util.LOGI("end GetStWithPasswd:user:" + paramString1 + " dwAppid:" + paramLong1 + " dwMainSigMap:0x" + Integer.toHexString(j) + " dwSubAppid:" + paramLong2 + " Seq:" + localt.h + " ret=" + paramInt1, "" + localt.f);
      return paramInt1;
      localt = this.mG.a(0L);
      paramWUserSigInfo._seqence = localt.h;
      this.mAysncSeq = localt.h;
      break;
      localt.i = 0;
      break label515;
      l2 = localt.b(paramString1);
      l1 = l2;
      if (l2 != 0L) {
        break label577;
      }
      paramInt1 = 0;
      l1 = l2;
      break label577;
      l1 = Long.parseLong(paramString1);
      break label577;
      label1006:
      localasync_context._tmp_pwd = MD5.toMD5Byte(paramString2);
      continue;
      label1019:
      if ((paramWUserSigInfo._fastLoginBuf != null) && (paramWUserSigInfo._fastLoginBuf.length > 0))
      {
        util.LOGI("GetFastLoginInfo ...", paramString1);
        if (GetFastLoginInfo(paramWUserSigInfo._fastLoginBuf, localasync_context) < 0)
        {
          util.LOGI("GetFastLoginInfo failed", paramString1);
          paramInt1 = -1017;
          continue;
        }
        if (!paramString1.matches("([0-9]{5,10})@qq\\.com")) {
          break label2075;
        }
        l1 = Long.valueOf(paramString1.replaceAll("([0-9]{5,10})@qq\\.com", "$1")).longValue();
        paramInt1 = 1;
        localt.a(paramString1, Long.valueOf(l1));
      }
    }
    label2068:
    label2075:
    for (;;)
    {
      if ((localasync_context._tmp_pwd == null) || (localasync_context._tmp_pwd.length < 16))
      {
        paramInt1 = -1016;
        break label644;
        if ((oicq.wlogin_sdk.code2d.d.q != null) && (oicq.wlogin_sdk.code2d.d.q.length > 0))
        {
          localasync_context._tmp_pwd = oicq.wlogin_sdk.code2d.d.q;
          localasync_context._tmp_no_pic_sig = oicq.wlogin_sdk.code2d.d.r;
          oicq.wlogin_sdk.code2d.d.q = null;
          oicq.wlogin_sdk.code2d.d.r = null;
          continue;
        }
        localasync_context._tmp_pwd = GetA1ByAccount(paramString1, paramLong1);
        localasync_context._tmp_no_pic_sig = GetNoPicSigByAccount(paramString1, paramLong1);
        continue;
      }
      localasync_context._tmp_pwd_type = 1;
      l2 = l1;
      break;
      label1219:
      paramInt2 = new s(localt).a(paramLong1, paramLong2, 1, j, paramString1.getBytes(), t.y, 0, 0, 1, i, this.mSubSigMap, paramArrayOfLong, paramWUserSigInfo);
      paramInt1 = paramInt2;
      if (paramInt2 != 0) {
        break label644;
      }
      if (localasync_context._msalt != 0L) {}
      for (l1 = 0L;; l1 = l2)
      {
        if (oicq.wlogin_sdk.a.j.y != 0L)
        {
          localasync_context._msalt = oicq.wlogin_sdk.a.j.y;
          oicq.wlogin_sdk.a.j.y = 0L;
        }
        localt.f = l1;
        paramWUserSigInfo.uin = ("" + l1);
        if ((paramWUserSigInfo._in_ksid != null) && (paramWUserSigInfo._in_ksid.length > 0)) {}
        for (paramString2 = (byte[])paramWUserSigInfo._in_ksid.clone();; paramString2 = t.ac)
        {
          if (localasync_context._tmp_pwd_type == 0) {
            break label1734;
          }
          util.LOGI("user:" + paramString1 + " login with saved A1.", "" + localt.f);
          localObject = new k(localt, this.mContext);
          ((k)localObject).g();
          paramInt1 = ((k)localObject).a(paramLong1, paramLong2, localt.f, 0, t.af, localasync_context._tmp_pwd, localasync_context._tmp_no_pic_sig, i, this.mSubSigMap, paramArrayOfLong, j, paramLong2, t.y, 0, 0, 1, paramString2, paramWUserSigInfo);
          paramInt2 = paramInt1;
          if (paramInt1 == 204) {
            paramInt2 = new p(localt).a(i, this.mSubSigMap, paramArrayOfLong, paramWUserSigInfo);
          }
          if (paramInt2 != 0)
          {
            paramInt1 = paramInt2;
            if (paramInt2 != 160) {
              break;
            }
          }
          l2 = l1;
          if (l1 == 0L)
          {
            l2 = localasync_context._uin;
            localt.f = l2;
            paramWUserSigInfo.uin = ("" + l2);
          }
          paramInt1 = paramInt2;
          if (paramInt2 == 160) {
            break;
          }
          paramString2 = localt.a(l2, paramLong1);
          if (paramString2 != null) {
            break label1894;
          }
          util.LOGI("get_siginfo failed, AppID: " + paramLong1, "" + localt.f);
          paramInt1 = -1004;
          break;
          if (localasync_context.ifQQLoginInQim(t.ax)) {}
          for (l1 = localasync_context._uin;; l1 = localt.b(paramString1))
          {
            l2 = l1;
            if (l1 != 0L) {
              break label2068;
            }
            paramInt1 = -1003;
            break;
          }
        }
        label1734:
        util.LOGI("user:" + paramString1 + " login with input password.", "" + localt.f);
        localObject = new byte[4];
        util.int64_to_buf32((byte[])localObject, 0, System.currentTimeMillis() / 1000L + t.ae);
        if (paramBoolean2) {}
        for (paramInt1 = 3;; paramInt1 = 1)
        {
          k localk = new k(localt, this.mContext);
          localk.g();
          paramInt1 = localk.a(paramLong1, paramLong2, localt.f, 0, t.af, (byte[])localObject, localasync_context._tmp_pwd, paramInt1, i, this.mSubSigMap, paramArrayOfLong, j, paramLong2, t.y, 0, 0, 1, paramString2, paramWUserSigInfo);
          break;
        }
        label1894:
        paramWUserSigInfo.get_clone(paramString2);
        paramInt1 = paramInt2;
        if (paramArrayOfLong == null) {
          break;
        }
        paramInt1 = paramInt2;
        if (paramArrayOfByte == null) {
          break;
        }
        paramInt1 = paramInt2;
        if (paramArrayOfLong.length * 2 != paramArrayOfByte.length) {
          break;
        }
        i = 0;
        for (;;)
        {
          paramInt1 = paramInt2;
          if (paramArrayOfLong == null) {
            break;
          }
          paramInt1 = paramInt2;
          if (i >= paramArrayOfLong.length) {
            break;
          }
          paramString2 = localt.a(l2, paramArrayOfLong[i]);
          if (paramString2 != null)
          {
            paramArrayOfByte[(i * 2)] = ((byte[])paramString2._userSt_Key.clone());
            paramArrayOfByte[(i * 2 + 1)] = ((byte[])paramString2._userStSig.clone());
          }
          i += 1;
        }
        label2024:
        if ((paramInt1 == 2) || (paramInt1 == 160)) {
          break label743;
        }
        RequestReportError(0, paramArrayOfLong._sig, paramArrayOfLong._sig_key, localt.f, localasync_context._appid, 0);
        break label743;
      }
    }
  }
  
  private int GetStWithoutPasswd(String paramString, long paramLong1, long paramLong2, long paramLong3, int paramInt1, long paramLong4, long[] paramArrayOfLong, WUserSigInfo paramWUserSigInfo, byte[][] paramArrayOfByte1, byte[][] paramArrayOfByte2, int paramInt2, WtTicketPromise paramWtTicketPromise)
  {
    if ((paramString == null) || (paramWUserSigInfo == null)) {
      return -1017;
    }
    paramInt1 |= 0xC0;
    int i = paramInt1;
    if (2L == paramLong4) {
      i = paramInt1 & 0xFDFFFFFF;
    }
    if (paramInt2 == 0)
    {
      new WtloginHelper.HelperThread(this, this, this.mHelperHandler, paramWtTicketPromise, paramString, paramLong1, paramLong2, paramLong3, i, paramLong4, paramArrayOfLong, paramWUserSigInfo, paramArrayOfByte1, paramArrayOfByte2, "GetStWithoutPasswd").RunReq(5);
      return -1001;
    }
    t localt = this.mG.a(0L);
    paramWUserSigInfo._seqence = localt.h;
    async_context localasync_context = t.b(localt.h);
    Object localObject = new StringBuilder().append("start GetStWithoutPasswd: dwSrcAppid:").append(paramLong1).append(" dwDstAppid:").append(paramLong2).append(" dwDstAppPri:").append(paramLong3).append(" dwMainSigMap:0x").append(Integer.toHexString(i)).append(" dwSubDstAppid:").append(paramLong4).append(" Seq:").append(localt.h).append("|");
    label417:
    long l1;
    if (paramWtTicketPromise != null)
    {
      paramWtTicketPromise = "1";
      util.LOGI(paramWtTicketPromise, paramString);
      paramInt1 = util.get_saved_network_type(this.mContext);
      t.D = util.get_network_type(this.mContext);
      if (paramInt1 != t.D)
      {
        util.set_net_retry_type(this.mContext, 0);
        util.save_network_type(this.mContext, t.D);
      }
      t.F = util.get_apn_string(this.mContext).getBytes();
      localt.g = paramString;
      localt.f = 0L;
      localasync_context._sappid = paramLong1;
      localasync_context._appid = paramLong2;
      localasync_context._sub_appid = paramLong4;
      localasync_context._main_sigmap = i;
      localasync_context._last_err_msg = new ErrMsg();
      if (paramArrayOfLong != null) {
        localasync_context._sub_appid_list = ((long[])paramArrayOfLong.clone());
      }
      if ((paramWUserSigInfo._reserveData == null) || (paramWUserSigInfo._reserveData.length <= 3)) {
        break label818;
      }
      localt.i = util.buf_to_int32(paramWUserSigInfo._reserveData, 0);
      util.LOGI("MSF SSO SEQ:" + localt.i, paramString);
      t.aq.add_t2(new report_t2("exchg", new String(t.C), System.currentTimeMillis(), paramLong2, paramLong4, paramArrayOfLong));
      if (util.check_uin_account(paramString).booleanValue()) {
        break label827;
      }
      long l2 = localt.b(paramString);
      l1 = l2;
      if (l2 != 0L) {
        break label833;
      }
      util.LOGI("user:" + paramString + " have not found uin record.", paramString);
      paramInt1 = -1003;
    }
    label515:
    label1926:
    for (;;)
    {
      paramWUserSigInfo = GetUserSigInfoTicket(paramWUserSigInfo, 128);
      paramArrayOfLong = paramWUserSigInfo;
      if (paramWUserSigInfo == null) {
        paramArrayOfLong = new Ticket();
      }
      t.aq.commit_t2(localt.f, localt.g, util.format_ret_code(paramInt1), paramInt1);
      if (paramInt1 == 0) {
        if ((paramArrayOfLong._sig != null) && (paramArrayOfLong._sig.length != 0)) {
          RequestReport(0, paramArrayOfLong._sig, paramArrayOfLong._sig_key, localt.f, localasync_context._appid);
        }
      }
      for (;;)
      {
        if ((localt.d != null) && (localt.d.get_bitmap() != 0))
        {
          this.mG.d = localt.d;
          RequestReportError(0, paramArrayOfLong._sig, paramArrayOfLong._sig_key, localt.f, localasync_context._appid, 1);
        }
        t.b();
        localt.i();
        util.LOGI("end GetStWithoutPasswd:user:" + paramString + " dwSrcAppid:" + paramLong1 + " dwDstAppid:" + paramLong2 + " dwDstAppPri:" + paramLong3 + " dwMainSigMap:0x" + Integer.toHexString(i) + " dwSubDstAppid:" + paramLong4 + " Seq:" + localt.h + " ret=" + paramInt1, "" + localt.f);
        return paramInt1;
        paramWtTicketPromise = "0";
        break;
        label818:
        localt.i = 0;
        break label417;
        label827:
        l1 = Long.parseLong(paramString);
        label833:
        localt.f = l1;
        paramWUserSigInfo.uin = ("" + l1);
        if ((paramArrayOfByte2 != null) && (paramArrayOfByte2.length == 4) && (paramArrayOfByte2[0] != null) && (paramArrayOfByte2[0].length == 1) && (paramArrayOfByte2[0][0] == 1))
        {
          util.LOGI("user:" + paramString + " exchange A2 from A2/D2/KEY.", "" + localt.f);
          if ((paramArrayOfByte2[1] == null) || (paramArrayOfByte2[1].length == 0) || (paramArrayOfByte2[2] == null) || (paramArrayOfByte2[2].length == 0) || (paramArrayOfByte2[3] == null) || (paramArrayOfByte2[3].length == 0))
          {
            paramInt1 = -1004;
            break label515;
          }
          localt.b = MD5.toMD5Byte(paramArrayOfByte2[3]);
          paramInt1 = new m(localt).a(l1, paramLong2, paramLong4, 1, i, paramArrayOfByte2[1], this.mMiscBitmap, this.mSubSigMap, paramArrayOfLong, paramArrayOfByte2[2], paramWUserSigInfo);
        }
        for (;;)
        {
          if (paramInt1 != 0) {
            break label1926;
          }
          paramArrayOfByte2 = localt.a(l1, paramLong2);
          if (paramArrayOfByte2 != null) {
            break label1791;
          }
          paramInt1 = -1004;
          break;
          if ((paramArrayOfByte2 != null) && (paramArrayOfByte2.length == 3) && (paramArrayOfByte2[0] != null) && (paramArrayOfByte2[0].length == 1) && (paramArrayOfByte2[0][0] == 2))
          {
            util.LOGI("user:" + paramString + " exchange A2 from A2/A2KEY.", "" + localt.f);
            if ((paramArrayOfByte2[1] == null) || (paramArrayOfByte2[1].length == 0) || (paramArrayOfByte2[2] == null) || (paramArrayOfByte2[2].length == 0))
            {
              paramInt1 = -1004;
              break;
            }
            localt.b = paramArrayOfByte2[2];
            paramInt1 = new m(localt).a(l1, paramLong2, paramLong4, 1, i, paramArrayOfByte2[1], this.mMiscBitmap, this.mSubSigMap, paramArrayOfLong, null, paramWUserSigInfo);
            continue;
          }
          localt.k();
          paramWtTicketPromise = GetA1ByAccount(String.valueOf(localt.f), paramLong1);
          localObject = GetNoPicSigByAccount(String.valueOf(localt.f), paramLong1);
          if ((paramWtTicketPromise != null) && (paramWtTicketPromise.length > 0) && (localObject != null) && (localObject.length > 0))
          {
            util.LOGI("user:" + paramString + " exchange A2 from A1.", "" + localt.f);
            localasync_context._tmp_pwd = paramWtTicketPromise;
            localasync_context._tmp_no_pic_sig = ((byte[])localObject);
            if ((paramWUserSigInfo._in_ksid != null) && (paramWUserSigInfo._in_ksid.length > 0)) {}
            for (paramArrayOfByte2 = (byte[])paramWUserSigInfo._in_ksid.clone();; paramArrayOfByte2 = t.ac)
            {
              z localz = new z(localt, this.mContext);
              WloginSigInfo localWloginSigInfo = FindUserSig(l1, paramLong1);
              if (localWloginSigInfo != null) {
                localz.a(localWloginSigInfo);
              }
              paramInt2 = this.mMiscBitmap;
              paramInt1 = paramInt2;
              if (t.ab) {
                paramInt1 = paramInt2 | 0x2000000;
              }
              paramInt2 = localz.a(paramLong2, 1, localt.f, 0, t.af, paramWtTicketPromise, (byte[])localObject, paramInt1, this.mSubSigMap, paramArrayOfLong, i, paramLong4, 1, t.y, 0, 0, 1, paramArrayOfByte2, paramLong1, paramWUserSigInfo);
              paramInt1 = paramInt2;
              if (paramInt2 == 204) {
                paramInt1 = new p(localt).a(this.mMiscBitmap, this.mSubSigMap, paramArrayOfLong, paramWUserSigInfo);
              }
              break;
            }
          }
          util.LOGI("user:" + paramString + " exchange A2 from A2.", "" + localt.f);
          paramArrayOfByte2 = localt.a(l1, paramLong1);
          if ((paramArrayOfByte2 == null) || (paramArrayOfByte2._TGT == null) || (paramArrayOfByte2._TGT.length == 0) || (paramArrayOfByte2.iSExpireA2(t.f())))
          {
            paramInt1 = -1004;
            break;
          }
          util.LOGI("user:" + paramString + " exchange A2 from A2 without Priority.", "" + localt.f);
          printTicket(paramArrayOfByte2);
          localt.b = paramArrayOfByte2._TGTKey;
          paramInt1 = new m(localt).a(l1, paramLong2, paramLong4, 1, i, paramArrayOfByte2._TGT, this.mMiscBitmap, this.mSubSigMap, paramArrayOfLong, null, paramWUserSigInfo);
        }
        label1791:
        paramWUserSigInfo.get_clone(paramArrayOfByte2);
        if ((paramArrayOfLong == null) || (paramArrayOfByte1 == null) || (paramArrayOfLong.length * 2 != paramArrayOfByte1.length)) {
          break label1926;
        }
        paramInt2 = 0;
        while (paramInt2 < paramArrayOfLong.length)
        {
          paramArrayOfByte2 = localt.a(l1, paramArrayOfLong[paramInt2]);
          if (paramArrayOfByte2 != null)
          {
            paramArrayOfByte1[(paramInt2 * 2)] = ((byte[])paramArrayOfByte2._userSt_Key.clone());
            paramArrayOfByte1[(paramInt2 * 2 + 1)] = ((byte[])paramArrayOfByte2._userStSig.clone());
          }
          paramInt2 += 1;
        }
        RequestReportError(0, paramArrayOfLong._sig, paramArrayOfLong._sig_key, localt.f, localasync_context._appid, 0);
      }
    }
  }
  
  private int GetStWithoutPasswd(String paramString, long paramLong1, long paramLong2, long paramLong3, int paramInt, WUserSigInfo paramWUserSigInfo, WtTicketPromise paramWtTicketPromise)
  {
    return GetStWithoutPasswd(paramString, paramLong1, paramLong2, -1L, paramInt, paramLong3, null, paramWUserSigInfo, (byte[][])null, (byte[][])null, 0, paramWtTicketPromise);
  }
  
  public static byte[] GetTicketSig(WUserSigInfo paramWUserSigInfo, int paramInt)
  {
    paramWUserSigInfo = GetUserSigInfoTicket(paramWUserSigInfo, paramInt);
    if (paramWUserSigInfo != null) {
      return paramWUserSigInfo._sig;
    }
    return new byte[0];
  }
  
  public static byte[] GetTicketSigKey(WUserSigInfo paramWUserSigInfo, int paramInt)
  {
    if ((paramInt != 64) && (paramInt != 262144) && (paramInt != 128) && (paramInt != 16384) && (paramInt != 32768) && (paramInt != 16777216)) {
      throw null;
    }
    paramWUserSigInfo = GetUserSigInfoTicket(paramWUserSigInfo, paramInt);
    if (paramWUserSigInfo != null) {
      return paramWUserSigInfo._sig_key;
    }
    return new byte[0];
  }
  
  public static Ticket GetUserSigInfoTicket(WUserSigInfo paramWUserSigInfo, int paramInt)
  {
    if (paramInt == 4194304) {
      return new Ticket(4194304, WloginSigInfo._LHSig, null, t.f(), 0L);
    }
    if (paramInt == 67108864) {
      return new Ticket(67108864, WloginSigInfo._QRPUSHSig, null, t.f(), 0L);
    }
    if (paramWUserSigInfo == null)
    {
      util.LOGI("GetUserSigInfoTicket userInfo is null " + Integer.toHexString(paramInt), "");
      return null;
    }
    if (paramWUserSigInfo._tickets == null)
    {
      util.LOGI("GetUserSigInfoTicket tickets is null " + Integer.toHexString(paramInt), paramWUserSigInfo.uin);
      return null;
    }
    if (paramWUserSigInfo._tickets != null)
    {
      int i = 0;
      while (i < paramWUserSigInfo._tickets.size())
      {
        Ticket localTicket = (Ticket)paramWUserSigInfo._tickets.get(i);
        if (localTicket._type == paramInt)
        {
          util.LOGI("GetUserSigInfoTicket type:0x" + Integer.toHexString(paramInt) + " sig:" + util.buf_len(localTicket._sig) + " key:" + util.buf_len(localTicket._sig_key) + " create time:" + localTicket._create_time + " expire time:" + localTicket._expire_time, "");
          util.LOGI(localTicket.getContent(), paramWUserSigInfo.uin);
          return localTicket;
        }
        i += 1;
      }
    }
    util.LOGI("GetUserSigInfoTicket type null: 0x" + Integer.toHexString(paramInt), "");
    return null;
  }
  
  private void OnDeviceLockRequest(String paramString, long paramLong1, long paramLong2, TransReqContext paramTransReqContext, WUserSigInfo paramWUserSigInfo, int paramInt)
  {
    DevlockRst localDevlockRst = DevlockBase.rst;
    localDevlockRst.commRsp = new TLV_CommRsp();
    DevlockInfo localDevlockInfo = new DevlockInfo();
    ErrMsg localErrMsg = new ErrMsg(0, "", "", "");
    if (paramInt != 0)
    {
      util.LOGI("OnDeviceLockRequest ret:" + paramInt, paramString);
      localErrMsg.setMessage(util.get_error_msg(paramInt));
      localErrMsg.setTitle(InternationMsg.a(InternationMsg.MSG_TYPE.MSG_5));
    }
    int i;
    label626:
    int j;
    switch (paramTransReqContext.get_subcmd())
    {
    case 6: 
    case 9: 
    case 10: 
    case 11: 
    default: 
      return;
    case 5: 
      i = paramInt;
      if (paramInt == 0)
      {
        paramInt = new oicq.wlogin_sdk.devicelock.a().parse_rsp(paramTransReqContext.get_body());
        util.LOGI("CheckDevLockStatus ret:" + paramInt, paramString);
        i = paramInt;
        if (paramInt != -1009)
        {
          tlvCommRsp2ErrMsg(localDevlockRst.commRsp, localErrMsg);
          if ((localDevlockRst.devSetupInfo != null) && (localDevlockRst.devSetupInfo.get_data_len() > 0))
          {
            localDevlockInfo.DevSetup = localDevlockRst.devSetupInfo.a;
            localDevlockInfo.AllowSet = localDevlockRst.devSetupInfo.b;
            if ((localDevlockRst.devGuideInfo == null) || (localDevlockRst.devGuideInfo.get_data_len() <= 0)) {
              break label626;
            }
          }
        }
      }
      for (localDevlockInfo.ProtectIntro = new String(localDevlockRst.devGuideInfo.a);; localDevlockInfo.ProtectIntro = new String(localDevlockRst.devSetupInfo.d))
      {
        localDevlockInfo.WarningInfo = new String(localDevlockRst.devSetupInfo.g);
        localDevlockInfo.WarningTitle = new String(localDevlockRst.devSetupInfo.e);
        localDevlockInfo.WarningMsg = new String(localDevlockRst.devSetupInfo.f);
        localDevlockInfo.WarningInfoType = localDevlockRst.devSetupInfo.c;
        if ((localDevlockRst.mbMobileInfo != null) && (localDevlockRst.mbMobileInfo.get_data_len() > 0))
        {
          localDevlockInfo.CountryCode = new String(localDevlockRst.mbMobileInfo.a);
          localDevlockInfo.Mobile = new String(localDevlockRst.mbMobileInfo.b);
          localDevlockInfo.MbItemSmsCodeStatus = localDevlockRst.mbMobileInfo.c;
          localDevlockInfo.AvailableMsgCount = localDevlockRst.mbMobileInfo.d;
          localDevlockInfo.TimeLimit = localDevlockRst.mbMobileInfo.e;
        }
        if ((localDevlockRst.mbGuideInfo != null) && (localDevlockRst.mbGuideInfo.get_data_len() > 0))
        {
          localDevlockInfo.MbGuideType = localDevlockRst.mbGuideInfo.c;
          localDevlockInfo.MbGuideInfoType = localDevlockRst.mbGuideInfo.d;
          localDevlockInfo.MbGuideInfo = new String(localDevlockRst.mbGuideInfo.b);
          localDevlockInfo.MbGuideMsg = new String(localDevlockRst.mbGuideInfo.a);
        }
        i = paramInt;
        if (localDevlockRst.transferInfo != null)
        {
          i = paramInt;
          if (localDevlockRst.transferInfo.get_data_len() > 0)
          {
            localDevlockInfo.TransferInfo = localDevlockRst.transferInfo.get_data();
            i = paramInt;
          }
        }
        if (this.mListener == null) {
          break;
        }
        this.mListener.OnCheckDevLockStatus(paramWUserSigInfo, localDevlockInfo, i, localErrMsg);
        return;
      }
    case 12: 
      i = paramInt;
      if (paramInt == 0)
      {
        j = new oicq.wlogin_sdk.devicelock.b().parse_rsp(paramTransReqContext.get_body());
        util.LOGI("CloseDevLock ret:" + j, paramString);
        i = j;
        if (j != -1009) {
          tlvCommRsp2ErrMsg(localDevlockRst.commRsp, localErrMsg);
        }
      }
      break;
    }
    for (;;)
    {
      try
      {
        if (!util.check_uin_account(paramString).booleanValue())
        {
          paramLong2 = this.mG.b(paramString);
          this.mG.b(paramLong2, paramLong1);
          paramInt = 0;
          i = j;
          if (paramInt < paramWUserSigInfo._tickets.size())
          {
            if (((Ticket)paramWUserSigInfo._tickets.get(paramInt))._type != 33554432) {
              break label1093;
            }
            paramWUserSigInfo._tickets.remove(paramInt);
            break label1093;
          }
        }
        else
        {
          paramLong2 = Long.parseLong(paramString);
          continue;
        }
        if (this.mListener == null) {
          break;
        }
      }
      catch (Exception paramString)
      {
        util.printException(paramString);
        i = j;
      }
      this.mListener.OnCloseDevLock(paramWUserSigInfo, i, localErrMsg);
      return;
      i = paramInt;
      if (paramInt == 0)
      {
        paramInt = new oicq.wlogin_sdk.devicelock.d().parse_rsp(paramTransReqContext.get_body());
        util.LOGI("AskDevLockSms ret:" + paramInt, paramString);
        i = paramInt;
        if (paramInt != -1009)
        {
          tlvCommRsp2ErrMsg(localDevlockRst.commRsp, localErrMsg);
          i = paramInt;
          if (localDevlockRst.smsInfo != null)
          {
            localDevlockInfo.AvailableMsgCount = localDevlockRst.smsInfo.a;
            localDevlockInfo.TimeLimit = localDevlockRst.smsInfo.b;
            i = paramInt;
          }
        }
      }
      if (this.mListener == null) {
        break;
      }
      this.mListener.OnAskDevLockSms(paramWUserSigInfo, localDevlockInfo, i, localErrMsg);
      return;
      i = paramInt;
      if (paramInt == 0)
      {
        paramInt = new oicq.wlogin_sdk.devicelock.f().parse_rsp(paramTransReqContext.get_body());
        util.LOGI("CheckDevLockSms ret:" + paramInt, paramString);
        i = paramInt;
        if (paramInt != -1009)
        {
          tlvCommRsp2ErrMsg(localDevlockRst.commRsp, localErrMsg);
          i = paramInt;
        }
      }
      if (this.mListener == null) {
        break;
      }
      this.mListener.OnCheckDevLockSms(paramWUserSigInfo, i, localErrMsg);
      return;
      label1093:
      paramInt += 1;
    }
  }
  
  private void OnRequestCode2d(String paramString, long paramLong1, long paramLong2, TransReqContext paramTransReqContext, WUserSigInfo paramWUserSigInfo, int paramInt)
  {
    if (this.mListener == null)
    {
      util.LOGI("OnRequestCode2d mListener is null", paramString);
      return;
    }
    oicq.wlogin_sdk.code2d.d locald = oicq.wlogin_sdk.code2d.c._status;
    if (paramInt != 0) {
      util.LOGI("OnRequestCode2d ret:" + paramInt, paramString);
    }
    oicq.wlogin_sdk.code2d.b localb;
    switch (paramTransReqContext.get_subcmd())
    {
    default: 
      util.LOGW("OnRequestName unhandle cmd", "", paramString);
      this.mListener.OnException(new ErrMsg(), 9, paramWUserSigInfo);
      return;
    case 19: 
      if (paramInt != 0)
      {
        this.mListener.OnVerifyCode(paramString, locald.d, locald.c, locald.e, paramWUserSigInfo, locald.f, paramInt);
        return;
      }
      locald.b = new oicq.wlogin_sdk.code2d.f().a(paramTransReqContext.get_body());
      util.LOGI("VerifyCode ret:" + locald.b, paramString);
      if ((locald.b == 0) && (locald.g != null) && (locald.g.length > 0)) {
        this.mG.a(locald.a, paramLong1, locald.g);
      }
      this.mListener.OnVerifyCode(paramString, locald.d, locald.c, locald.e, paramWUserSigInfo, locald.f, locald.b);
      return;
    case 20: 
      if (paramInt != 0)
      {
        this.mListener.OnCloseCode(paramString, locald.d, locald.c, paramWUserSigInfo, locald.f, paramInt);
        return;
      }
      localb = new oicq.wlogin_sdk.code2d.b();
      if (paramWUserSigInfo == null) {
        paramWUserSigInfo = new WUserSigInfo();
      }
      break;
    }
    for (;;)
    {
      locald.b = localb.a(paramTransReqContext.get_body(), paramLong1, t.t, paramWUserSigInfo.loginTLVMap);
      util.LOGI("CloseCode ret:" + locald.b, paramString);
      oicq.wlogin_sdk.code2d.d.t = false;
      this.mListener.OnCloseCode(paramString, locald.d, locald.c, paramWUserSigInfo, locald.f, locald.b);
      return;
      if (paramInt == 0) {
        paramInt = new fetch_code().get_response(paramTransReqContext.get_body());
      }
      for (;;)
      {
        util.LOGI("FetchCodeSig ret:" + locald.b, paramString);
        this.mListener.OnFetchCodeSig(locald.j, locald.k, locald.l, paramWUserSigInfo, locald.f, paramInt);
        return;
        if (paramInt == 0)
        {
          paramInt = new oicq.wlogin_sdk.code2d.e().a(paramTransReqContext.get_body());
          util.LOGI("QueryCodeResult ret:" + locald.b, paramString);
        }
        for (;;)
        {
          this.mListener.OnQueryCodeResult(locald.a, locald.e, locald.c, paramWUserSigInfo, locald.f, paramInt);
          return;
        }
      }
    }
  }
  
  private void OnRequestRegister(String paramString, long paramLong1, long paramLong2, TransReqContext paramTransReqContext, WUserSigInfo paramWUserSigInfo, int paramInt)
  {
    if (this.mListener == null) {}
    String str;
    oicq.wlogin_sdk.a.j localj;
    label1513:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            do
                            {
                              do
                              {
                                do
                                {
                                  do
                                  {
                                    do
                                    {
                                      do
                                      {
                                        do
                                        {
                                          do
                                          {
                                            do
                                            {
                                              do
                                              {
                                                return;
                                                str = InternationMsg.a(InternationMsg.MSG_TYPE.MSG_3);
                                                if (paramInt == 0) {
                                                  break;
                                                }
                                              } while (this.mListener == null);
                                              this.mListener.OnRegError(paramWUserSigInfo, paramInt, str.getBytes());
                                              return;
                                              localj = this.mRegStatus;
                                              switch (paramTransReqContext.get_subcmd())
                                              {
                                              default: 
                                                util.LOGW("OnRequestRegister unhandle cmd:" + paramTransReqContext.get_subcmd(), "", paramString);
                                              }
                                            } while (this.mListener == null);
                                            this.mListener.OnRegError(paramWUserSigInfo, -1010, str.getBytes());
                                            return;
                                            paramInt = oicq.wlogin_sdk.a.c.a(paramTransReqContext.get_body(), localj);
                                            if (paramInt == 0) {
                                              break;
                                            }
                                          } while (this.mListener == null);
                                          this.mListener.OnRegError(paramWUserSigInfo, paramInt, str.getBytes());
                                          return;
                                          util.LOGI("reg cmd:" + paramTransReqContext.get_subcmd() + " ret:" + localj.d, "");
                                          if (localj.d != 0) {
                                            break;
                                          }
                                        } while (this.mListener == null);
                                        this.mListener.OnRegCheckDownloadMsg(paramWUserSigInfo, localj.m, localj.n);
                                        return;
                                        if (localj.d != 2) {
                                          break;
                                        }
                                      } while (this.mListener == null);
                                      this.mListener.OnRegCheckUploadMsg(paramWUserSigInfo, new String(localj.q));
                                      return;
                                      if (localj.d != 3) {
                                        break;
                                      }
                                    } while (this.mListener == null);
                                    this.mListener.OnRegCheckValidUrl(paramWUserSigInfo, localj.r);
                                    return;
                                    if ((localj.d == 6) || (localj.d == 44))
                                    {
                                      if (this.mListener != null) {
                                        this.mListener.OnRegCheckWebSig(paramWUserSigInfo, new String(localj.r), new String(localj.f));
                                      }
                                      localj.r = new byte[0];
                                      return;
                                    }
                                    if (localj.d != 51) {
                                      break;
                                    }
                                  } while (this.mListener == null);
                                  this.mListener.OnGuaranteeCheckValidUrl(paramWUserSigInfo, localj.r);
                                  return;
                                  util.LOGW("OnRequestRegister 0xa return code:", String.valueOf(localj.d), paramString);
                                } while (this.mListener == null);
                                this.mListener.OnRegError(paramWUserSigInfo, localj.d, localj.f);
                                return;
                                paramInt = oicq.wlogin_sdk.a.c.a(3, paramTransReqContext.get_body(), localj);
                                if (paramInt == 0) {
                                  break;
                                }
                              } while (this.mListener == null);
                              this.mListener.OnRegError(paramWUserSigInfo, paramInt, str.getBytes());
                              return;
                              util.LOGI("reg cmd:" + paramTransReqContext.get_subcmd() + " ret:" + localj.d, "");
                              if ((localj.d == 0) || (localj.d == 4) || (localj.d == 31) || (localj.d == 118))
                              {
                                if (localj.d == 0)
                                {
                                  paramWUserSigInfo.regTLVMap = localj.B;
                                  localj.B = new HashMap();
                                }
                                this.mListener.OnRegQueryClientSentMsgStatus(paramWUserSigInfo, localj.d, localj.s, localj.t, new String(localj.f));
                                return;
                              }
                              if (localj.d != 3) {
                                break;
                              }
                            } while (this.mListener == null);
                            this.mListener.OnRegCheckValidUrl(paramWUserSigInfo, localj.r);
                            return;
                            util.LOGW("OnRequestRegister 0x3 return code:", String.valueOf(localj.d), paramString);
                          } while (this.mListener == null);
                          this.mListener.OnRegError(paramWUserSigInfo, localj.d, localj.f);
                          return;
                          paramInt = oicq.wlogin_sdk.a.c.a(paramTransReqContext.get_body(), localj);
                          if (paramInt == 0) {
                            break;
                          }
                        } while (this.mListener == null);
                        this.mListener.OnRegError(paramWUserSigInfo, paramInt, str.getBytes());
                        return;
                        util.LOGI("reg cmd:" + paramTransReqContext.get_subcmd() + " ret:" + localj.d, "");
                        if (localj.d != 0) {
                          break;
                        }
                      } while (this.mListener == null);
                      this.mListener.OnRegRequestServerResendMsg(paramWUserSigInfo, localj.d, localj.s, localj.t);
                      return;
                      if (localj.d != 3) {
                        break;
                      }
                    } while (this.mListener == null);
                    this.mListener.OnRegCheckValidUrl(paramWUserSigInfo, localj.r);
                    return;
                    if (localj.d != 5) {
                      break;
                    }
                  } while (this.mListener == null);
                  this.mListener.OnRegRequestServerResendMsg(paramWUserSigInfo, localj.d, localj.s, localj.t);
                  return;
                  util.LOGW("OnRequestRegister 0x4 return code:", String.valueOf(localj.d), paramString);
                } while (this.mListener == null);
                this.mListener.OnRegError(paramWUserSigInfo, localj.d, localj.f);
                return;
                paramInt = oicq.wlogin_sdk.a.c.b(paramTransReqContext.get_body(), localj);
                if (paramInt == 0) {
                  break;
                }
              } while (this.mListener == null);
              this.mListener.OnRegError(paramWUserSigInfo, paramInt, str.getBytes());
              return;
              paramWUserSigInfo.regTLVMap = localj.B;
              localj.B = new HashMap();
              util.LOGI("reg cmd:" + paramTransReqContext.get_subcmd() + " ret:" + localj.d, "");
            } while (this.mListener == null);
            this.mListener.OnRegSubmitMsgChk(paramWUserSigInfo, localj.d, localj.f);
            return;
            paramInt = oicq.wlogin_sdk.a.c.c(paramTransReqContext.get_body(), localj);
            if (paramInt == 0) {
              break;
            }
          } while (this.mListener == null);
          this.mListener.OnRegError(paramWUserSigInfo, paramInt, str.getBytes());
          return;
          paramWUserSigInfo.regTLVMap = localj.B;
          localj.B = new HashMap();
          util.LOGI("reg cmd:" + paramTransReqContext.get_subcmd() + " ret:" + localj.d, "");
        } while (this.mListener == null);
        if ((localj.b != null) && (localj.b.indexOf("-") > 0))
        {
          paramInt = localj.b.indexOf("-");
          paramString = localj.b.substring(0, paramInt);
          if (!paramString.equals("86")) {
            break label1513;
          }
        }
        for (localj.b = localj.b.substring(paramInt + 1);; localj.b = ("00" + paramString + localj.b.substring(paramInt + 1)))
        {
          if ((localj.b != null) && (localj.b.length() != 0))
          {
            this.mG.d(localj.b);
            this.mG.a(localj.b, Long.valueOf(localj.u));
          }
          util.LOGI("reg userAccount: " + localj.b, localj.u + "");
          if ((oicq.wlogin_sdk.a.j.z.length() <= 0) || (!oicq.wlogin_sdk.a.j.x)) {
            break;
          }
          this.mListener.OnRegGetSMSVerifyLoginAccount(paramWUserSigInfo, localj.d, localj.u, localj.v, localj.w, localj.f);
          return;
        }
        this.mListener.OnRegGetAccount(paramWUserSigInfo, localj.d, localj.u, localj.v, localj.w, localj.f);
        return;
        paramInt = oicq.wlogin_sdk.a.c.d(paramTransReqContext.get_body(), localj);
        if (paramInt == 0) {
          break;
        }
      } while (this.mListener == null);
      this.mListener.OnRegError(paramWUserSigInfo, paramInt, str.getBytes());
      return;
      util.LOGI("reg cmd:" + paramTransReqContext.get_subcmd() + " ret:" + localj.d, "");
    } while (this.mListener == null);
    this.mListener.OnRegQueryAccount(paramWUserSigInfo, localj.d, localj.f);
    return;
    paramInt = oicq.wlogin_sdk.a.c.e(paramTransReqContext.get_body(), localj);
    if ((paramInt != 0) && (this.mListener != null)) {
      this.mListener.OnRegError(paramWUserSigInfo, paramInt, str.getBytes());
    }
    util.LOGI("reg cmd:" + paramTransReqContext.get_subcmd() + " ret:" + localj.d, "");
    this.mListener.OnQuickRegisterCheckAccount(paramWUserSigInfo, localj.d, localj.f);
    return;
    paramInt = oicq.wlogin_sdk.a.c.f(paramTransReqContext.get_body(), localj);
    if ((paramInt != 0) && (this.mListener != null)) {
      this.mListener.OnRegError(paramWUserSigInfo, paramInt, str.getBytes());
    }
    util.LOGI("reg cmd:" + paramTransReqContext.get_subcmd() + " ret:" + localj.d, "");
    paramWUserSigInfo.regTLVMap = localj.B;
    localj.B = new HashMap();
    this.mListener.OnQuickRegisterGetAccount(paramWUserSigInfo, localj.d, localj.f);
    return;
    util.LOGI("reg cmd:" + paramTransReqContext.get_subcmd());
    this.mListener.onModifyQIMPassword(paramWUserSigInfo, paramTransReqContext.get_subcmd(), paramTransReqContext.get_body());
  }
  
  private int RefreshPictureData(String paramString, WUserSigInfo paramWUserSigInfo, int paramInt)
  {
    int i = 0;
    if ((paramString == null) || (paramWUserSigInfo == null)) {
      return -1017;
    }
    if (paramInt == 0)
    {
      new WtloginHelper.HelperThread(this, this, this.mHelperHandler, paramString, paramWUserSigInfo, "RefreshPictureData").RunReq(1);
      return -1001;
    }
    if (paramWUserSigInfo._seqence == 0L) {
      paramWUserSigInfo._seqence = this.mAysncSeq;
    }
    t localt = this.mG.a(paramWUserSigInfo._seqence);
    paramWUserSigInfo._seqence = localt.h;
    async_context localasync_context = t.b(localt.h);
    util.LOGI("user:" + paramString + " Seq:" + localt.h + " RefreshPictureData ...", "" + paramString);
    localt.g = paramString;
    localasync_context._last_err_msg = new ErrMsg();
    long l;
    if (!util.check_uin_account(paramString).booleanValue())
    {
      l = localt.b(paramString);
      if (l == 0L) {
        break label326;
      }
      paramInt = 1;
    }
    for (;;)
    {
      if (paramInt == 1) {
        localt.f = l;
      }
      paramInt = new q(localt).a(this.mMiscBitmap, this.mSubSigMap, localasync_context._sub_appid_list, paramWUserSigInfo);
      if (paramInt == 2) {
        paramInt = i;
      }
      for (;;)
      {
        util.LOGI("user:" + paramString + " Seq:" + localt.h + " RefreshPictureData ret=" + paramInt, "" + paramString);
        return paramInt;
        l = Long.parseLong(paramString);
        paramInt = 1;
        break;
      }
      label326:
      paramInt = 0;
    }
  }
  
  private int RefreshSMSData(String paramString, long paramLong, WUserSigInfo paramWUserSigInfo, int paramInt)
  {
    int i = 0;
    if ((paramString == null) || (paramWUserSigInfo == null)) {
      return -1017;
    }
    if (paramInt == 0)
    {
      new WtloginHelper.HelperThread(this, this, this.mHelperHandler, paramString, paramLong, paramWUserSigInfo, "RefreshSMSData").RunReq(3);
      return -1001;
    }
    if (paramWUserSigInfo._seqence == 0L) {
      paramWUserSigInfo._seqence = this.mAysncSeq;
    }
    t localt = this.mG.a(paramWUserSigInfo._seqence);
    paramWUserSigInfo._seqence = localt.h;
    async_context localasync_context = t.b(localt.h);
    util.LOGI("user:" + paramString + " smsAppid:" + paramLong + " Seq:" + localt.h + " RefreshSMSData ...", "" + paramString);
    localt.g = paramString;
    localasync_context._last_err_msg = new ErrMsg();
    long l;
    if (!util.check_uin_account(paramString).booleanValue())
    {
      l = localt.b(paramString);
      if (l == 0L) {
        break label366;
      }
      paramInt = 1;
    }
    for (;;)
    {
      if (paramInt == 1) {
        localt.f = l;
      }
      paramInt = new r(localt).a(paramLong, this.mMiscBitmap, this.mSubSigMap, localasync_context._sub_appid_list, paramWUserSigInfo);
      if (paramInt == 160) {
        paramInt = i;
      }
      for (;;)
      {
        util.LOGI("user:" + paramString + " smsAppid:" + paramLong + " Seq:" + localt.h + " RefreshSMSData ret=" + paramInt, "" + paramString);
        return paramInt;
        l = Long.parseLong(paramString);
        paramInt = 1;
        break;
      }
      label366:
      paramInt = 0;
    }
  }
  
  private int RefreshSMSVerifyLoginCode(String paramString, WUserSigInfo paramWUserSigInfo, int paramInt)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return -1017;
    }
    if (paramInt == 0)
    {
      new WtloginHelper.HelperThread(this, this, this.mHelperHandler, paramString, paramWUserSigInfo, "RefreshSMSVerifyLoginCode").RunReq(14);
      return -1001;
    }
    if (paramWUserSigInfo._seqence == 0L) {
      paramWUserSigInfo._seqence = this.mAysncSeq;
    }
    Object localObject = this.mG.a(paramWUserSigInfo._seqence);
    paramWUserSigInfo._seqence = ((t)localObject).h;
    async_context localasync_context = t.b(((t)localObject).h);
    util.LOGI("user:" + paramString + " Seq:" + ((t)localObject).h + " RefreshSMSVerifyLoginCode ...", paramString);
    ((t)localObject).g = paramString;
    localasync_context._last_err_msg = new ErrMsg();
    paramInt = new x((t)localObject).a(this.mMiscBitmap, this.mSubSigMap, null, paramWUserSigInfo);
    localObject = new StringBuilder().append("user:").append(((t)localObject).g).append(" Seq:").append(((t)localObject).h).append(" RefreshSMSVerifyLoginCode ret=");
    if (paramInt > 0) {}
    for (paramWUserSigInfo = Integer.toHexString(paramInt);; paramWUserSigInfo = Integer.valueOf(paramInt))
    {
      util.LOGI(paramWUserSigInfo, paramString);
      return paramInt;
    }
  }
  
  private int RegSubmitMobile(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, WUserSigInfo paramWUserSigInfo)
  {
    if ((paramArrayOfByte2 == null) || (paramArrayOfByte2.length <= 0) || (paramArrayOfByte4 == null)) {
      return -1017;
    }
    if (paramArrayOfByte1 == null) {
      paramArrayOfByte1 = new byte[0];
    }
    for (;;)
    {
      byte[] arrayOfByte = t.E;
      long l1 = 0L;
      Object localObject1 = new byte[0];
      Object localObject2 = GetLastLoginInfo();
      paramArrayOfByte3 = (byte[])localObject1;
      if (localObject2 != null)
      {
        long l2 = ((WloginLastLoginInfo)localObject2).mUin;
        localObject2 = GetLocalTicket(((WloginLastLoginInfo)localObject2).mAccount, paramLong1, 64);
        l1 = l2;
        paramArrayOfByte3 = (byte[])localObject1;
        if (localObject2 != null)
        {
          l1 = l2;
          paramArrayOfByte3 = (byte[])localObject1;
          if (((Ticket)localObject2)._sig != null)
          {
            paramArrayOfByte3 = ((Ticket)localObject2)._sig;
            l1 = l2;
          }
        }
      }
      util.LOGI("has uin? " + l1 + ", a2: " + paramArrayOfByte3.length);
      util.LOGI("RegSubmitMobile mobile ..." + new String(paramArrayOfByte2) + " appname: " + new String(arrayOfByte) + "...", "");
      this.mRegStatus.c = new String(paramArrayOfByte2);
      localObject1 = new oicq.wlogin_sdk.a.h();
      localObject2 = new TransReqContext();
      oicq.wlogin_sdk.a.j localj = this.mRegStatus;
      localj.k = paramArrayOfByte2;
      localj.g = paramLong1;
      localj.h = paramLong2;
      ((TransReqContext)localObject2).set_register_req();
      ((TransReqContext)localObject2).set_subcmd(((oicq.wlogin_sdk.a.h)localObject1).a());
      ((TransReqContext)localObject2)._body = ((oicq.wlogin_sdk.a.h)localObject1).a(paramArrayOfByte2, arrayOfByte, paramArrayOfByte4, paramInt1, paramInt2, paramInt3, paramLong1, paramLong2, null, util.generateGuid(this.mContext), util.get_IMSI(this.mContext), t.ac, l1, paramArrayOfByte3, GetGuid(), paramArrayOfByte1, paramWUserSigInfo.extraRegTLVMap);
      return RequestTransport(0, 1, null, 0L, oicq.wlogin_sdk.a.j.i, (TransReqContext)localObject2, paramWUserSigInfo);
    }
  }
  
  private void RequestInit()
  {
    try
    {
      t.d();
      ShareKeyInit();
      AsyncGenRSAKey();
      return;
    }
    finally {}
  }
  
  private int RequestReport(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, long paramLong1, long paramLong2)
  {
    if (paramInt == 0)
    {
      new WtloginHelper.HelperThread(this, this, this.mHelperHandler, paramArrayOfByte1, paramArrayOfByte2, paramLong1, paramLong2, "RequestReport").RunReq(7);
      return -1001;
    }
    t localt = this.mG.a(0L);
    localt.f = paramLong1;
    util.LOGI("user:" + paramLong1 + " appid:" + paramLong2 + " Seq:" + localt.h + " RequestReport...", "" + paramLong1);
    paramInt = new aa(localt).a(paramLong1, null, paramArrayOfByte1, paramArrayOfByte2, paramLong2, new WUserSigInfo());
    localt.j();
    util.LOGI("user:" + paramLong1 + " appid:" + paramLong2 + " Seq:" + localt.h + " RequestReport ret=" + paramInt, "" + paramLong1);
    return paramInt;
  }
  
  private int RequestReportError(int paramInt1, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, long paramLong1, long paramLong2, int paramInt2)
  {
    if (paramInt1 == 0)
    {
      new WtloginHelper.HelperThread(this, this, this.mHelperHandler, paramArrayOfByte1, paramArrayOfByte2, paramLong1, paramLong2, paramInt2, "RequestReportError").RunReq(8);
      return -1001;
    }
    t localt = this.mG.a(0L);
    localt.d = this.mG.d;
    localt.f = paramLong1;
    util.LOGI("user:" + paramLong1 + " appid:" + paramLong2 + " Seq:" + localt.h + " RequestReportError...", "" + paramLong1);
    paramInt1 = new v(localt).a(paramLong1, null, paramArrayOfByte1, paramArrayOfByte2, paramLong2, paramInt2);
    util.LOGI("user:" + paramLong1 + " appid:" + paramLong2 + " Seq:" + localt.h + " RequestReportError ret=" + paramInt1, "" + paramLong1);
    return paramInt1;
  }
  
  public static void SetWatchQQLicense(WUserSigInfo paramWUserSigInfo, byte[] paramArrayOfByte)
  {
    setExtraProductLoginTlvValue(paramWUserSigInfo, 1322, paramArrayOfByte);
    setExtraRegTlvValue(paramWUserSigInfo, 38, paramArrayOfByte);
  }
  
  private int ShareKeyInit()
  {
    util.LOGI("start ShareKeyInit", "");
    EcdhCrypt localEcdhCrypt = new EcdhCrypt(this.mContext);
    if (this.isForLocal) {
      return localEcdhCrypt.initShareKeyByDefault();
    }
    int i = localEcdhCrypt.initShareKey();
    util.LOGI("end ShareKeyInit", "");
    this.mG.n = localEcdhCrypt.get_c_pub_key();
    this.mG.p = localEcdhCrypt.get_g_share_key();
    return i;
  }
  
  private int VerifySMSVerifyLoginCode(String paramString1, String paramString2, WUserSigInfo paramWUserSigInfo, int paramInt)
  {
    if ((paramString1 == null) || (paramString1.length() == 0) || (paramString2 == null) || (paramString2.length() == 0)) {
      return -1017;
    }
    if (paramInt == 0)
    {
      new WtloginHelper.HelperThread(this, this, this.mHelperHandler, paramString1, paramString2, paramWUserSigInfo, "VerifySMSVerifyLoginCode").RunReq(13);
      return -1001;
    }
    if (paramWUserSigInfo._seqence == 0L) {
      paramWUserSigInfo._seqence = this.mAysncSeq;
    }
    t localt = this.mG.a(paramWUserSigInfo._seqence);
    paramWUserSigInfo._seqence = localt.h;
    async_context localasync_context = t.b(localt.h);
    util.LOGI("user:" + localt.g + " code:" + paramString2 + " Seq:" + localt.h + " VerifySMSVerifyLoginCode ...", paramString1);
    localt.g = paramString1;
    localasync_context._last_err_msg = new ErrMsg();
    localasync_context._mpasswd = util.get_mpasswd();
    paramInt = new y(localt).a(paramString2, this.mMiscBitmap, this.mSubSigMap, null, paramWUserSigInfo);
    paramWUserSigInfo = new StringBuilder().append("user:").append(paramString1).append(" code:").append(paramString2).append(" Seq:").append(localt.h).append(" VerifySMSVerifyLoginAccount ret=");
    if (paramInt > 0) {}
    for (paramString2 = Integer.toHexString(paramInt);; paramString2 = Integer.valueOf(paramInt))
    {
      util.LOGI(paramString2, paramString1);
      return paramInt;
    }
  }
  
  public static void customizeLogDir(String paramString)
  {
    t.aw = paramString;
    util.LOGI("set log dir " + paramString, "");
  }
  
  public static byte[] getLoginResultData(WUserSigInfo paramWUserSigInfo, int paramInt)
  {
    paramWUserSigInfo = (tlv_t)paramWUserSigInfo.loginResultTLVMap.get(new Integer(paramInt));
    if (paramWUserSigInfo != null) {
      return paramWUserSigInfo.get_data();
    }
    return null;
  }
  
  public static String getLoginResultField(WUserSigInfo paramWUserSigInfo)
  {
    Object localObject = (tlv_t)paramWUserSigInfo.loginResultTLVMap.get(new Integer(1320));
    if (localObject != null)
    {
      localObject = new String(((tlv_t)localObject).get_data());
      util.LOGI("getLoginResultField get str " + (String)localObject, paramWUserSigInfo.uin);
      return localObject;
    }
    util.LOGI("getLoginResultField get null", paramWUserSigInfo.uin);
    return "";
  }
  
  public static String getLoginResultField_S(WUserSigInfo paramWUserSigInfo)
  {
    Object localObject = (tlv_t)paramWUserSigInfo.loginResultTLVMap.get(new Integer(1328));
    if (localObject != null)
    {
      localObject = new String(((tlv_t)localObject).get_data());
      util.LOGI("getLoginResultField2 get str " + (String)localObject, paramWUserSigInfo.uin);
      return localObject;
    }
    util.LOGI("getLoginResultField2 get null", paramWUserSigInfo.uin);
    return "";
  }
  
  public static byte[] getLoginTlvValue(WUserSigInfo paramWUserSigInfo, int paramInt)
  {
    Integer localInteger = new Integer(paramInt);
    paramWUserSigInfo = (tlv_t)paramWUserSigInfo.loginTLVMap.get(localInteger);
    if (paramWUserSigInfo != null) {
      return paramWUserSigInfo.get_data();
    }
    return null;
  }
  
  public static byte[] getRegTlvValue(WUserSigInfo paramWUserSigInfo, int paramInt)
  {
    Integer localInteger = new Integer(paramInt);
    paramWUserSigInfo = (tlv_t)paramWUserSigInfo.regTLVMap.get(localInteger);
    if (paramWUserSigInfo != null) {
      return paramWUserSigInfo.get_data();
    }
    return null;
  }
  
  private int getStWithPtSig(String paramString1, String paramString2, WtloginHelper.QuickLoginParam paramQuickLoginParam)
  {
    return getStWithPtSig(paramString1, paramString2, paramQuickLoginParam, 0);
  }
  
  private int getStWithPtSig(String paramString1, String paramString2, WtloginHelper.QuickLoginParam paramQuickLoginParam, int paramInt)
  {
    return 0;
  }
  
  private int getStWithQQSig(String paramString, WtloginHelper.QuickLoginParam paramQuickLoginParam)
  {
    return getStWithQQSig(paramString, paramQuickLoginParam, 0);
  }
  
  private int getStWithQQSig(String paramString, WtloginHelper.QuickLoginParam paramQuickLoginParam, int paramInt)
  {
    return 0;
  }
  
  private int getStWithQrSig(String paramString, long paramLong1, long paramLong2, int paramInt1, WUserSigInfo paramWUserSigInfo, int paramInt2)
  {
    if ((paramString == null) || (paramWUserSigInfo == null)) {
      return -1017;
    }
    int i = paramInt1 | 0xC0;
    if (paramInt2 == 0)
    {
      new WtloginHelper.HelperThread(this, this, this.mHelperHandler, paramString, paramLong1, i, paramLong2, paramWUserSigInfo, "getStWithQrSig").RunReq(17);
      return -1001;
    }
    paramInt2 = 0;
    t localt = this.mG.a(0L);
    paramWUserSigInfo._seqence = localt.h;
    this.mAysncSeq = localt.h;
    oicq.wlogin_sdk.a.j.z = "";
    async_context localasync_context = t.b(localt.h);
    util.LOGI("start getStWithQrSig:user:" + paramString + " appid:" + paramLong1 + " sigMap:0x" + Integer.toHexString(i) + " subAppid:" + paramLong2 + " Seq:" + localt.h, paramString);
    paramInt1 = util.get_saved_network_type(this.mContext);
    t.D = util.get_network_type(this.mContext);
    if (paramInt1 != t.D)
    {
      util.set_net_retry_type(this.mContext, 0);
      util.save_network_type(this.mContext, t.D);
    }
    t.F = util.get_apn_string(this.mContext).getBytes();
    if (!util.check_uin_account(paramString).booleanValue())
    {
      util.LOGI("userAccount " + paramString + " isn't valid", "");
      return -1017;
    }
    long l = Long.parseLong(paramString);
    paramWUserSigInfo.uin = paramString;
    localt.g = paramString;
    localt.f = l;
    localasync_context._sappid = paramLong1;
    localasync_context._appid = paramLong1;
    localasync_context._sub_appid_list = null;
    localasync_context._sub_appid = paramLong2;
    localasync_context._main_sigmap = i;
    localasync_context._login_bitmap = paramWUserSigInfo._login_bitmap;
    localasync_context._last_err_msg = new ErrMsg();
    label528:
    label572:
    Object localObject;
    if ((paramWUserSigInfo._reserveData != null) && (paramWUserSigInfo._reserveData.length > 3))
    {
      localt.i = util.buf_to_int32(paramWUserSigInfo._reserveData, 0);
      util.LOGI("MSF SSO SEQ:" + localt.i, paramString);
      t.aq.add_t2(new report_t2("login", new String(t.C), System.currentTimeMillis(), paramLong1, paramLong2, null));
      if ((oicq.wlogin_sdk.code2d.d.q != null) && (oicq.wlogin_sdk.code2d.d.q.length > 0))
      {
        localasync_context._tmp_pwd = oicq.wlogin_sdk.code2d.d.q;
        localasync_context._tmp_no_pic_sig = oicq.wlogin_sdk.code2d.d.r;
        if ((localasync_context._tmp_no_pic_sig == null) || (localasync_context._tmp_no_pic_sig.length == 0)) {
          break label854;
        }
        util.LOGI("no pic sig length " + localasync_context._tmp_no_pic_sig.length, paramString);
        localasync_context.tgtQR = oicq.wlogin_sdk.code2d.d.s;
        oicq.wlogin_sdk.code2d.d.q = null;
        oicq.wlogin_sdk.code2d.d.r = null;
        oicq.wlogin_sdk.code2d.d.s = null;
      }
      if ((localasync_context._tmp_pwd != null) && (localasync_context._tmp_pwd.length >= 16)) {
        break label864;
      }
      paramInt2 = -1016;
      localObject = GetUserSigInfoTicket(paramWUserSigInfo, 128);
      paramWUserSigInfo = (WUserSigInfo)localObject;
      if (localObject == null) {
        paramWUserSigInfo = new Ticket();
      }
      t.aq.commit_t2(localt.f, localt.g, util.format_ret_code(paramInt2), paramInt2);
      if (paramInt2 != 0) {
        break label1108;
      }
      if ((paramWUserSigInfo._sig != null) && (paramWUserSigInfo._sig.length != 0)) {
        RequestReport(0, paramWUserSigInfo._sig, paramWUserSigInfo._sig_key, localt.f, localasync_context._appid);
      }
    }
    for (;;)
    {
      if ((localt.d != null) && (localt.d.get_bitmap() != 0))
      {
        this.mG.d = localt.d;
        RequestReportError(0, paramWUserSigInfo._sig, paramWUserSigInfo._sig_key, localt.f, localasync_context._appid, 1);
      }
      t.b();
      localt.i();
      util.LOGI("end getStWithQrSig user:" + paramString + " appid:" + paramLong1 + " sigMap:0x" + Integer.toHexString(i) + " subAppid:" + paramLong2 + " Seq:" + localt.h + " ret=" + paramInt2, "" + localt.f);
      return paramInt2;
      localt.i = 0;
      break;
      label854:
      util.LOGI("no pic sig length is 0", paramString);
      break label528;
      label864:
      localasync_context._tmp_pwd_type = 1;
      if ((paramWUserSigInfo._in_ksid != null) && (paramWUserSigInfo._in_ksid.length > 0)) {}
      for (localObject = (byte[])paramWUserSigInfo._in_ksid.clone();; localObject = t.ac)
      {
        if (localasync_context._tmp_pwd_type != 0)
        {
          util.LOGI("user:" + paramString + " login with qrsig", paramString);
          k localk = new k(localt, this.mContext);
          localk.g();
          paramInt2 = localk.a(paramLong1, paramLong2, localt.f, 0, t.af, localasync_context._tmp_pwd, localasync_context._tmp_no_pic_sig, this.mMiscBitmap, this.mSubSigMap, null, i, paramLong2, t.y, 0, 0, 1, (byte[])localObject, paramWUserSigInfo);
        }
        paramInt1 = paramInt2;
        if (paramInt2 == 204) {
          paramInt1 = new p(localt).a(this.mMiscBitmap, this.mSubSigMap, null, paramWUserSigInfo);
        }
        if (paramInt1 != 0)
        {
          paramInt2 = paramInt1;
          if (paramInt1 != 160) {
            break;
          }
        }
        localObject = localt.a(l, paramLong1);
        if (localObject != null) {
          break label1094;
        }
        paramInt2 = -1004;
        break;
      }
      label1094:
      paramWUserSigInfo.get_clone((WloginSigInfo)localObject);
      paramInt2 = paramInt1;
      break label572;
      label1108:
      if ((paramInt2 != 2) && (paramInt2 != 160)) {
        RequestReportError(0, paramWUserSigInfo._sig, paramWUserSigInfo._sig_key, localt.f, localasync_context._appid, 0);
      }
    }
  }
  
  private Handler initHelperHandler()
  {
    try
    {
      if (Looper.myLooper() != Looper.getMainLooper()) {
        return null;
      }
      Handler localHandler = new Handler();
      return localHandler;
    }
    catch (Throwable localThrowable) {}
    return null;
  }
  
  private int isPskeyExpired(int paramInt1, String[] paramArrayOfString, Ticket paramTicket, long paramLong, int paramInt2)
  {
    String str2;
    int i;
    int m;
    int j;
    label119:
    String str1;
    if ((paramInt1 == 1048576) && (paramArrayOfString != null) && (paramArrayOfString.length > 0))
    {
      paramInt1 = 0;
      int n = paramArrayOfString.length;
      int k = 0;
      for (;;)
      {
        if (k < n)
        {
          str2 = paramArrayOfString[k];
          if (str2 == null) {
            break label550;
          }
          if (str2.length() == 0)
          {
            k += 1;
          }
          else
          {
            i = str2.indexOf('(');
            m = str2.indexOf(')');
            if ((i != 0) || (m <= 0)) {
              break label553;
            }
            j = Integer.valueOf(str2.substring(i + 1, m)).intValue();
            if ((0x100000 & j) > 0)
            {
              i = 1;
              if ((j & 0x8000000) <= 0) {
                break label420;
              }
              j = 1;
              label131:
              str1 = str2.substring(m + 1);
              m = i;
              i = j;
            }
          }
        }
      }
    }
    for (;;)
    {
      StringBuilder localStringBuilder = new StringBuilder().append("isPskeyExpired domain ").append(str1).append(" req_pskey:");
      Object localObject;
      if (m != 0)
      {
        localObject = "1";
        label186:
        localStringBuilder = localStringBuilder.append((String)localObject).append(" req_pt4t:");
        if (i == 0) {
          break label434;
        }
        localObject = "1";
        label211:
        util.LOGI((String)localObject, "");
        if ((m == 0) || ((paramTicket._pskey_map.get(str1) != null) && (!Ticket.isPskeyExpired(((Long)paramTicket._pskey_expire.get(str1)).longValue())))) {
          break label442;
        }
        j = 1;
        label271:
        if ((i == 0) || ((paramTicket._pt4token_map.get(str1) != null) && (!Ticket.isPskeyExpired(((Long)paramTicket._pt4token_expire.get(str1)).longValue())))) {
          break label448;
        }
        i = 1;
        label316:
        if ((j == 0) && (i == 0)) {
          break label550;
        }
        paramArrayOfString[paramInt1] = str2;
        localObject = new StringBuilder().append("PskeyExpired:").append(str1).append("pskey:");
        if (j == 0) {
          break label454;
        }
        str1 = "1";
        label367:
        localObject = ((StringBuilder)localObject).append(str1).append(",pt4t:");
        if (i == 0) {
          break label462;
        }
      }
      label420:
      label434:
      label442:
      label448:
      label454:
      label462:
      for (str1 = "1";; str1 = "0")
      {
        util.LOGI(str1, "");
        paramInt1 += 1;
        break;
        i = 0;
        break label119;
        j = 0;
        break label131;
        localObject = "0";
        break label186;
        localObject = "0";
        break label211;
        j = 0;
        break label271;
        i = 0;
        break label316;
        str1 = "0";
        break label367;
      }
      i = paramInt1;
      if (paramInt1 == 0) {
        return 3;
      }
      while (i < paramArrayOfString.length)
      {
        util.LOGI("isPskeyExpired domain " + paramArrayOfString[i] + " cleared", "");
        paramArrayOfString[i] = null;
        i += 1;
      }
      if (paramInt2 == 1) {
        return 1;
      }
      RefreshMemorySig();
      return 2;
      return 0;
      label550:
      break;
      label553:
      str1 = str2;
      i = 0;
      m = 1;
    }
  }
  
  private void localInit(Context paramContext, boolean paramBoolean)
  {
    this.isForLocal = paramBoolean;
    try
    {
      this.mContext = paramContext.getApplicationContext();
      this.mG.b(paramContext);
      RequestInit();
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        this.mContext = paramContext;
        util.printThrowable(localThrowable, "");
      }
    }
  }
  
  private Handler newHelperHandler()
  {
    try
    {
      if (Looper.myLooper() == null) {
        return null;
      }
      Handler localHandler = new Handler();
      return localHandler;
    }
    catch (Throwable localThrowable) {}
    return null;
  }
  
  private void printTicket(WloginSigInfo paramWloginSigInfo)
  {
    util.LOGI("a1 " + paramWloginSigInfo._en_A1.length);
    util.LOGI("a2 " + paramWloginSigInfo._TGT.length);
    util.LOGI("skey " + paramWloginSigInfo._sKey.length);
    util.LOGI("pskey " + paramWloginSigInfo._psKey.length);
    util.LOGI("superkey " + paramWloginSigInfo._superKey.length);
    util.LOGI("d2 " + paramWloginSigInfo._D2.length);
    util.LOGI("d2key " + paramWloginSigInfo._D2Key.length);
  }
  
  public static void setCustomerGuid(Context paramContext, byte[] paramArrayOfByte)
  {
    util.LOGI("set customer guid " + util.buf_to_string(paramArrayOfByte), "");
    t.ak = paramArrayOfByte;
    util.saveGuidToFile(paramContext, paramArrayOfByte);
  }
  
  public static void setExtraLoginTlvValue(WUserSigInfo paramWUserSigInfo, int paramInt, byte[] paramArrayOfByte)
  {
    Integer localInteger = new Integer(paramInt);
    tlv_t localtlv_t = new tlv_t(paramInt);
    localtlv_t.set_data(paramArrayOfByte, paramArrayOfByte.length);
    paramWUserSigInfo.extraLoginTLVMap.put(localInteger, localtlv_t);
    int i = paramArrayOfByte[0];
    util.LOGI("setExtraLoginTlvValue tag:" + paramInt + " value[0]: " + (i & 0xFF), paramWUserSigInfo.uin);
  }
  
  private static void setExtraProductLoginTlvValue(WUserSigInfo paramWUserSigInfo, int paramInt, byte[] paramArrayOfByte)
  {
    tlv_t localtlv_t = new tlv_t(paramInt);
    localtlv_t.set_data(paramArrayOfByte, paramArrayOfByte.length);
    paramWUserSigInfo._loginExtraProductTLVMap.put(Integer.valueOf(paramInt), localtlv_t);
    int i = paramArrayOfByte[0];
    util.LOGI("setExtraProductLoginTlvValue tag:" + paramInt + " value[0]: " + (i & 0xFF), paramWUserSigInfo.uin);
  }
  
  public static void setExtraRegTlvValue(WUserSigInfo paramWUserSigInfo, int paramInt, byte[] paramArrayOfByte)
  {
    Integer localInteger = new Integer(paramInt);
    RegTLV localRegTLV = new RegTLV(paramInt);
    localRegTLV.set_data(paramArrayOfByte, paramArrayOfByte.length);
    paramWUserSigInfo.extraRegTLVMap.put(localInteger, localRegTLV);
  }
  
  @Deprecated
  public static void setExtraRegTlvValueWatchQQLicense(WUserSigInfo paramWUserSigInfo, byte[] paramArrayOfByte)
  {
    setExtraRegTlvValue(paramWUserSigInfo, 38, paramArrayOfByte);
  }
  
  public static void setLoadEncryptSo(boolean paramBoolean)
  {
    util.loadEncryptSo = paramBoolean;
  }
  
  public static void setLoadSoFlg(boolean paramBoolean)
  {
    t.av = paramBoolean;
  }
  
  public static void setProductType(int paramInt)
  {
    t.ax = paramInt;
  }
  
  public static void setRegisterFlg(int paramInt)
  {
    t.aj |= paramInt;
  }
  
  public static void setSecTransInfo(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    t.ay = paramString1;
    t.az = paramString2;
    t.aA = paramInt;
    t.aB = paramString3;
  }
  
  private void tlvCommRsp2ErrMsg(TLV_CommRsp paramTLV_CommRsp, ErrMsg paramErrMsg)
  {
    if ((paramTLV_CommRsp == null) || (paramTLV_CommRsp.get_data_len() == 0)) {
      return;
    }
    paramErrMsg.setType(paramTLV_CommRsp.ErrInfoType);
    paramErrMsg.setOtherinfo(new String(paramTLV_CommRsp.ErrInfo));
    paramErrMsg.setTitle(new String(paramTLV_CommRsp.ErrTitle));
    paramErrMsg.setMessage(new String(paramTLV_CommRsp.ErrMsg));
  }
  
  public int AskDevLockSms(String paramString, long paramLong1, long paramLong2, WUserSigInfo paramWUserSigInfo)
  {
    if (paramString == null) {
      return -1017;
    }
    Object localObject = new WloginSimpleInfo();
    if (!GetBasicUserInfo(paramString, (WloginSimpleInfo)localObject).booleanValue()) {
      return -1003;
    }
    long l = ((WloginSimpleInfo)localObject)._uin;
    util.LOGI("AskDevLockSms ...", paramString);
    localObject = new oicq.wlogin_sdk.devicelock.d();
    TransReqContext localTransReqContext = new TransReqContext();
    localTransReqContext.set_devlock_req();
    localTransReqContext.set_subcmd(((oicq.wlogin_sdk.devicelock.d)localObject).get_msgType());
    localTransReqContext._body = ((oicq.wlogin_sdk.devicelock.d)localObject).a(l, paramLong1, paramLong2);
    if ((localTransReqContext._body == null) || (localTransReqContext._body.length == 0)) {
      return -1017;
    }
    return RequestTransport(0, 1, paramString, paramLong1, ((oicq.wlogin_sdk.devicelock.d)localObject).Role, localTransReqContext, paramWUserSigInfo);
  }
  
  public void CancelRequest()
  {
    this.mG.s = 1;
  }
  
  public int CheckDevLockSms(String paramString1, long paramLong1, long paramLong2, String paramString2, byte[] paramArrayOfByte, WUserSigInfo paramWUserSigInfo)
  {
    if (paramString1 == null) {
      return -1017;
    }
    Object localObject1 = new WloginSimpleInfo();
    if (!GetBasicUserInfo(paramString1, (WloginSimpleInfo)localObject1).booleanValue()) {
      return -1003;
    }
    long l = ((WloginSimpleInfo)localObject1)._uin;
    Object localObject2 = FindUserSig(l, paramLong1);
    if (localObject2 == null) {
      return -1004;
    }
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0)) {
      DevlockBase.rst.setSppKey(paramArrayOfByte);
    }
    util.LOGI("CheckDevLockSms ...", paramString1);
    oicq.wlogin_sdk.devicelock.f localf = new oicq.wlogin_sdk.devicelock.f();
    TransReqContext localTransReqContext = new TransReqContext();
    localObject1 = Build.VERSION.RELEASE;
    paramArrayOfByte = (byte[])localObject1;
    if (localObject1 == null) {
      paramArrayOfByte = "";
    }
    localTransReqContext.set_devlock_req();
    localTransReqContext.set_subcmd(localf.get_msgType());
    localTransReqContext.setSTEncryptMethod();
    localTransReqContext.setWtST((WloginSigInfo)localObject2);
    localObject1 = ((WloginSigInfo)localObject2)._TGT;
    localObject2 = t.A;
    byte[] arrayOfByte1 = t.E;
    byte[] arrayOfByte2 = "6.0.0.2425".getBytes();
    byte[] arrayOfByte3 = "android".getBytes();
    paramArrayOfByte = paramArrayOfByte.getBytes();
    if (paramString2 == null) {}
    for (paramString2 = null;; paramString2 = paramString2.getBytes())
    {
      localTransReqContext._body = localf.a(l, paramLong1, paramLong2, (byte[])localObject1, (byte[])localObject2, arrayOfByte1, arrayOfByte2, arrayOfByte3, paramArrayOfByte, paramString2);
      if ((localTransReqContext._body != null) && (localTransReqContext._body.length != 0)) {
        break;
      }
      return -1017;
    }
    return RequestTransport(0, 1, paramString1, paramLong1, localf.Role, localTransReqContext, paramWUserSigInfo);
  }
  
  public int CheckDevLockStatus(String paramString, long paramLong1, long paramLong2, WUserSigInfo paramWUserSigInfo)
  {
    if (paramString == null) {
      return -1017;
    }
    Object localObject = new WloginSimpleInfo();
    if (!GetBasicUserInfo(paramString, (WloginSimpleInfo)localObject).booleanValue()) {
      return -1003;
    }
    long l = ((WloginSimpleInfo)localObject)._uin;
    localObject = FindUserSig(l, paramLong1);
    if (localObject == null) {
      return -1004;
    }
    util.LOGI("CheckDevLockStatus ...", paramString);
    DevlockBase.rst = new DevlockRst();
    oicq.wlogin_sdk.devicelock.a locala = new oicq.wlogin_sdk.devicelock.a();
    TransReqContext localTransReqContext = new TransReqContext();
    localTransReqContext.set_devlock_req();
    localTransReqContext.set_subcmd(locala.get_msgType());
    localTransReqContext.setSTEncryptMethod();
    localTransReqContext.setWtST((WloginSigInfo)localObject);
    localTransReqContext._body = locala.a(l, paramLong1, paramLong2, ((WloginSigInfo)localObject)._TGT, t.A, t.E, "6.0.0.2425".getBytes(), t.K, t.J);
    if ((localTransReqContext._body == null) || (localTransReqContext._body.length == 0)) {
      return -1017;
    }
    return RequestTransport(0, 1, paramString, paramLong1, locala.Role, localTransReqContext, paramWUserSigInfo);
  }
  
  public int CheckPictureAndGetSt(String paramString, byte[] paramArrayOfByte, WUserSigInfo paramWUserSigInfo)
  {
    n.K = false;
    return CheckPictureAndGetSt(paramString, paramArrayOfByte, paramWUserSigInfo, (byte[][])null, 0);
  }
  
  public int CheckPictureAndGetSt(String paramString, byte[] paramArrayOfByte, WUserSigInfo paramWUserSigInfo, byte[][] paramArrayOfByte1)
  {
    n.K = false;
    return CheckPictureAndGetSt(paramString, paramArrayOfByte, paramWUserSigInfo, paramArrayOfByte1, 0);
  }
  
  public int CheckSMSAndGetSt(String paramString, byte[] paramArrayOfByte, WUserSigInfo paramWUserSigInfo)
  {
    return CheckSMSAndGetSt(paramString, paramArrayOfByte, paramWUserSigInfo, (byte[][])null, 0);
  }
  
  public int CheckSMSAndGetSt(String paramString, byte[] paramArrayOfByte, WUserSigInfo paramWUserSigInfo, byte[][] paramArrayOfByte1)
  {
    return CheckSMSAndGetSt(paramString, paramArrayOfByte, paramWUserSigInfo, paramArrayOfByte1, 0);
  }
  
  public int CheckSMSVerifyLoginAccount(long paramLong1, long paramLong2, int paramInt, long paramLong3, WUserSigInfo paramWUserSigInfo)
  {
    return CheckSMSVerifyLoginAccount(paramLong1, paramLong2, null, paramInt, paramLong3, paramWUserSigInfo, 0);
  }
  
  public int CheckSMSVerifyLoginAccount(long paramLong1, long paramLong2, String paramString, WUserSigInfo paramWUserSigInfo)
  {
    return CheckSMSVerifyLoginAccount(paramLong1, paramLong2, paramString, 1, -1L, paramWUserSigInfo, 0);
  }
  
  public int CheckWebsigAndGetSt(String paramString1, String paramString2, WUserSigInfo paramWUserSigInfo)
  {
    n.K = true;
    return CheckPictureAndGetSt(paramString1, paramString2.getBytes(), paramWUserSigInfo, (byte[][])null, 0);
  }
  
  public int CheckWebsigAndGetSt(String paramString1, String paramString2, WUserSigInfo paramWUserSigInfo, byte[][] paramArrayOfByte)
  {
    n.K = true;
    return CheckPictureAndGetSt(paramString1, paramString2.getBytes(), paramWUserSigInfo, paramArrayOfByte, 0);
  }
  
  public void ClearPSkey(String paramString, long paramLong)
  {
    util.LOGI("user:" + paramString + " appid:" + paramLong + " ClearPSkey ...", paramString);
    if ((paramString == null) || (paramString.length() <= 0)) {
      return;
    }
    int i = 1;
    for (;;)
    {
      try
      {
        if (!util.check_uin_account(paramString).booleanValue())
        {
          long l2 = this.mG.b(paramString);
          l1 = l2;
          if (l2 == 0L)
          {
            i = 0;
            l1 = l2;
          }
          if (i != 0) {
            this.mG.d(l1, paramLong);
          }
          return;
        }
      }
      finally {}
      long l1 = Long.parseLong(paramString);
    }
  }
  
  /* Error */
  public Boolean ClearUserLoginData(String paramString, long paramLong)
  {
    // Byte code:
    //   0: new 137	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   7: ldc 140
    //   9: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12: aload_1
    //   13: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: ldc_w 1503
    //   19: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: lload_2
    //   23: invokevirtual 151	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   26: ldc_w 1990
    //   29: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   35: aload_1
    //   36: invokestatic 163	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   39: aload_1
    //   40: ifnull +10 -> 50
    //   43: aload_1
    //   44: invokevirtual 627	java/lang/String:length	()I
    //   47: ifgt +8 -> 55
    //   50: iconst_1
    //   51: invokestatic 1993	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   54: areturn
    //   55: aload_0
    //   56: monitorenter
    //   57: aload_1
    //   58: invokestatic 180	oicq/wlogin_sdk/tools/util:check_uin_account	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   61: invokevirtual 186	java/lang/Boolean:booleanValue	()Z
    //   64: ifne +72 -> 136
    //   67: aload_0
    //   68: getfield 49	oicq/wlogin_sdk/request/WtloginHelper:mG	Loicq/wlogin_sdk/request/t;
    //   71: aload_1
    //   72: invokevirtual 189	oicq/wlogin_sdk/request/t:b	(Ljava/lang/String;)J
    //   75: lstore 5
    //   77: lload 5
    //   79: lconst_0
    //   80: lcmp
    //   81: ifne +41 -> 122
    //   84: iconst_0
    //   85: istore 4
    //   87: iload 4
    //   89: iconst_1
    //   90: if_icmpne +13 -> 103
    //   93: aload_0
    //   94: getfield 49	oicq/wlogin_sdk/request/WtloginHelper:mG	Loicq/wlogin_sdk/request/t;
    //   97: lload 5
    //   99: lload_2
    //   100: invokevirtual 1995	oicq/wlogin_sdk/request/t:e	(JJ)V
    //   103: aload_0
    //   104: monitorexit
    //   105: iconst_0
    //   106: newarray byte
    //   108: putstatic 857	oicq/wlogin_sdk/sharemem/WloginSigInfo:_QRPUSHSig	[B
    //   111: iconst_0
    //   112: newarray byte
    //   114: putstatic 850	oicq/wlogin_sdk/sharemem/WloginSigInfo:_LHSig	[B
    //   117: iconst_1
    //   118: invokestatic 1993	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   121: areturn
    //   122: aload_0
    //   123: getfield 49	oicq/wlogin_sdk/request/WtloginHelper:mG	Loicq/wlogin_sdk/request/t;
    //   126: aload_1
    //   127: invokevirtual 1334	oicq/wlogin_sdk/request/t:d	(Ljava/lang/String;)V
    //   130: iconst_1
    //   131: istore 4
    //   133: goto -46 -> 87
    //   136: aload_1
    //   137: invokestatic 279	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   140: lstore 5
    //   142: iconst_1
    //   143: istore 4
    //   145: goto -58 -> 87
    //   148: astore_1
    //   149: aload_0
    //   150: monitorexit
    //   151: aload_1
    //   152: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	153	0	this	WtloginHelper
    //   0	153	1	paramString	String
    //   0	153	2	paramLong	long
    //   85	59	4	i	int
    //   75	66	5	l	long
    // Exception table:
    //   from	to	target	type
    //   57	77	148	finally
    //   93	103	148	finally
    //   103	105	148	finally
    //   122	130	148	finally
    //   136	142	148	finally
    //   149	151	148	finally
  }
  
  public int CloseCode(String paramString, long paramLong, byte[] paramArrayOfByte, int paramInt, List<byte[]> paramList, WUserSigInfo paramWUserSigInfo)
  {
    Object localObject = new WloginSimpleInfo();
    if (!GetBasicUserInfo(paramString, (WloginSimpleInfo)localObject).booleanValue()) {
      return -1003;
    }
    long l = ((WloginSimpleInfo)localObject)._uin;
    this.mG.k();
    localObject = FindUserSig(l, paramLong);
    if (localObject == null) {
      return -1004;
    }
    util.LOGI("user:" + paramString + " CloseCode ...", paramString);
    oicq.wlogin_sdk.code2d.b localb = new oicq.wlogin_sdk.code2d.b();
    TransReqContext localTransReqContext = new TransReqContext();
    localTransReqContext.set_code2d_func_req();
    localTransReqContext.set_subcmd(localb.get_cmd());
    localTransReqContext.setSTEncryptMethod();
    localTransReqContext.setWtST((WloginSigInfo)localObject);
    localTransReqContext._body = localb.a(l, paramLong, 1L, paramArrayOfByte, ((WloginSigInfo)localObject)._TGT, t.A, paramInt, paramList, ((WloginSigInfo)localObject)._en_A1, ((WloginSigInfo)localObject)._noPicSig, this.mMiscBitmap, 0L);
    return RequestTransport(0, 1, paramString, paramLong, localb._role, localTransReqContext, paramWUserSigInfo);
  }
  
  public int CloseDevLock(String paramString, long paramLong1, long paramLong2, WUserSigInfo paramWUserSigInfo)
  {
    if (paramString == null) {
      return -1017;
    }
    Object localObject = new WloginSimpleInfo();
    if (!GetBasicUserInfo(paramString, (WloginSimpleInfo)localObject).booleanValue()) {
      return -1003;
    }
    long l = ((WloginSimpleInfo)localObject)._uin;
    WloginSigInfo localWloginSigInfo = FindUserSig(l, paramLong1);
    if (localWloginSigInfo == null) {
      return -1004;
    }
    util.LOGI("CloseDevLock ...", paramString);
    oicq.wlogin_sdk.devicelock.b localb = new oicq.wlogin_sdk.devicelock.b();
    TransReqContext localTransReqContext = new TransReqContext();
    String str = Build.VERSION.RELEASE;
    localObject = str;
    if (str == null) {
      localObject = "";
    }
    localTransReqContext.set_devlock_req();
    localTransReqContext.set_subcmd(localb.get_msgType());
    localTransReqContext.setSTEncryptMethod();
    localTransReqContext.setWtST(localWloginSigInfo);
    localTransReqContext._body = localb.a(l, paramLong1, paramLong2, localWloginSigInfo._TGT, t.A, t.E, "6.0.0.2425".getBytes(), "android".getBytes(), ((String)localObject).getBytes());
    if ((localTransReqContext._body == null) || (localTransReqContext._body.length == 0)) {
      return -1017;
    }
    return RequestTransport(0, 1, paramString, paramLong1, localb.Role, localTransReqContext, paramWUserSigInfo);
  }
  
  public int FetchCodeSig(long paramLong1, long paramLong2, fetch_code.QRCodeCustom paramQRCodeCustom, WUserSigInfo paramWUserSigInfo)
  {
    util.LOGI(" FetchCodeSig ...", "");
    fetch_code localfetch_code = new fetch_code();
    TransReqContext localTransReqContext = new TransReqContext();
    localTransReqContext.set_code2d_func_req();
    localTransReqContext.set_subcmd(localfetch_code.get_cmd());
    long l = this.mMiscBitmap;
    byte[] arrayOfByte = WloginSigInfo._QRPUSHSig;
    localTransReqContext._body = localfetch_code.get_request(0L, paramLong1, paramLong2, new byte[0], paramQRCodeCustom, l, 0L, arrayOfByte);
    return RequestTransport(0, 1, null, paramLong1, localfetch_code._role, localTransReqContext, paramWUserSigInfo);
  }
  
  public int GetA1WithA1(String paramString, long paramLong1, long paramLong2, byte[] paramArrayOfByte1, long paramLong3, long paramLong4, long paramLong5, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, WUserSigInfo paramWUserSigInfo, WFastLoginInfo paramWFastLoginInfo)
  {
    return GetA1WithA1(paramString, paramLong1, paramLong2, this.mMainSigMap, paramArrayOfByte1, paramLong3, paramLong4, paramLong5, paramArrayOfByte2, paramArrayOfByte3, paramWUserSigInfo, paramWFastLoginInfo, 0);
  }
  
  public byte[] GetA2A2KeyBuf(String paramString, long paramLong)
  {
    Ticket localTicket = GetLocalTicket(paramString, paramLong, 64);
    if ((localTicket == null) || (localTicket._sig == null) || (localTicket._sig.length <= 0) || (localTicket._sig_key == null) || (localTicket._sig_key.length <= 0)) {}
    while ((t.B == null) || (t.B.length <= 0)) {
      return null;
    }
    byte[] arrayOfByte = new byte[paramString.getBytes().length + 2 + 8 + 2 + localTicket._sig.length + 2 + localTicket._sig_key.length];
    util.int16_to_buf(arrayOfByte, 0, paramString.getBytes().length);
    System.arraycopy(paramString.getBytes(), 0, arrayOfByte, 2, paramString.getBytes().length);
    int i = paramString.getBytes().length + 2;
    util.int64_to_buf(arrayOfByte, i, paramLong);
    i += 8;
    util.int16_to_buf(arrayOfByte, i, localTicket._sig.length);
    i += 2;
    System.arraycopy(localTicket._sig, 0, arrayOfByte, i, localTicket._sig.length);
    i += localTicket._sig.length;
    util.int16_to_buf(arrayOfByte, i, localTicket._sig_key.length);
    i += 2;
    System.arraycopy(localTicket._sig_key, 0, arrayOfByte, i, localTicket._sig_key.length);
    i = localTicket._sig_key.length;
    return cryptor.encrypt(arrayOfByte, 0, arrayOfByte.length, t.B);
  }
  
  public List<WloginLoginInfo> GetAllLoginInfo()
  {
    return this.mG.l();
  }
  
  public long GetAppidFromUrl(String paramString)
  {
    if (paramString == null) {
      return -1L;
    }
    int i = paramString.indexOf("f=");
    if ((i == -1) || (i + 2 >= paramString.length())) {
      return -1L;
    }
    i += 2;
    String str = "";
    for (;;)
    {
      if ((i >= paramString.length()) || (paramString.charAt(i) == '&')) {}
      try
      {
        long l = Long.parseLong(str);
        return l;
      }
      catch (Exception paramString) {}
      str = str + paramString.charAt(i);
      i += 1;
    }
    return -1L;
  }
  
  public Boolean GetBasicUserInfo(String paramString, WloginSimpleInfo paramWloginSimpleInfo)
  {
    boolean bool = true;
    if (paramString == null) {
      return Boolean.valueOf(false);
    }
    long l;
    int i;
    if (!util.check_uin_account(paramString).booleanValue())
    {
      l = this.mG.b(paramString);
      if (l != 0L) {
        break label173;
      }
      i = 0;
    }
    for (;;)
    {
      int j = i;
      if (i == 1)
      {
        paramString = this.mG.d(l);
        if (paramString == null) {
          j = 0;
        }
      }
      else
      {
        label66:
        if (j != 1) {
          break label167;
        }
      }
      for (;;)
      {
        return Boolean.valueOf(bool);
        l = Long.parseLong(paramString);
        i = 1;
        break;
        paramWloginSimpleInfo.setUin(paramString._uin);
        paramWloginSimpleInfo.setFace(paramString._face);
        paramWloginSimpleInfo.setGender(paramString._gender);
        paramWloginSimpleInfo.setNick(paramString._nick);
        paramWloginSimpleInfo.setAge(paramString._age);
        paramWloginSimpleInfo.setImgType(paramString._img_type);
        paramWloginSimpleInfo.setImgFormat(paramString._img_format);
        paramWloginSimpleInfo.setImgUrl(paramString._img_url);
        paramWloginSimpleInfo.setMainDisplayName(paramString.mainDisplayName);
        j = i;
        break label66;
        label167:
        bool = false;
      }
      label173:
      i = 1;
    }
  }
  
  public Boolean GetBasicUserInfoForQQLoginInQimOnly(WUserSigInfo paramWUserSigInfo, WloginSimpleInfo paramWloginSimpleInfo)
  {
    boolean bool = true;
    long l = Long.parseLong(paramWUserSigInfo.uin);
    paramWUserSigInfo = this.mG.d(l);
    int i;
    if (paramWUserSigInfo == null)
    {
      i = 0;
      if (i != 1) {
        break label116;
      }
    }
    for (;;)
    {
      return Boolean.valueOf(bool);
      paramWloginSimpleInfo.setUin(paramWUserSigInfo._uin);
      paramWloginSimpleInfo.setFace(paramWUserSigInfo._face);
      paramWloginSimpleInfo.setGender(paramWUserSigInfo._gender);
      paramWloginSimpleInfo.setNick(paramWUserSigInfo._nick);
      paramWloginSimpleInfo.setAge(paramWUserSigInfo._age);
      paramWloginSimpleInfo.setImgType(paramWUserSigInfo._img_type);
      paramWloginSimpleInfo.setImgFormat(paramWUserSigInfo._img_format);
      paramWloginSimpleInfo.setImgUrl(paramWUserSigInfo._img_url);
      paramWloginSimpleInfo.setMainDisplayName(paramWUserSigInfo.mainDisplayName);
      i = 1;
      break;
      label116:
      bool = false;
    }
  }
  
  public DevlockInfo GetDevLockInfo(String paramString)
  {
    return GetDevLockInfo(paramString, 0L);
  }
  
  public DevlockInfo GetDevLockInfo(String paramString, long paramLong)
  {
    long l = paramLong;
    if (paramLong <= 0L) {
      l = this.mAysncSeq;
    }
    return t.b(l)._devlock_info;
  }
  
  public byte[] GetGuid()
  {
    byte[] arrayOfByte2 = t.a(this.mContext);
    if (arrayOfByte2 != null) {
      return arrayOfByte2;
    }
    byte[] arrayOfByte1 = arrayOfByte2;
    if (t.A != null)
    {
      arrayOfByte1 = arrayOfByte2;
      if (t.A.length > 0)
      {
        arrayOfByte1 = new byte[t.A.length];
        System.arraycopy(t.A, 0, arrayOfByte1, 0, t.A.length);
      }
    }
    util.LOGI("get guid " + util.buf_to_string(arrayOfByte1), "");
    return arrayOfByte1;
  }
  
  public WloginLastLoginInfo GetLastLoginInfo()
  {
    Object localObject = this.mG.l();
    if (localObject == null) {}
    label124:
    label125:
    for (;;)
    {
      return null;
      Iterator localIterator = ((List)localObject).iterator();
      localObject = null;
      while (localIterator.hasNext())
      {
        WloginLoginInfo localWloginLoginInfo = (WloginLoginInfo)localIterator.next();
        if (localObject == null)
        {
          localObject = localWloginLoginInfo;
        }
        else
        {
          if (localWloginLoginInfo.mCreateTime <= ((WloginLoginInfo)localObject).mCreateTime) {
            break label124;
          }
          localObject = localWloginLoginInfo;
        }
      }
      for (;;)
      {
        break;
        if (localObject == null) {
          break label125;
        }
        if ((((WloginLoginInfo)localObject).mAccount != null) && (((WloginLoginInfo)localObject).mAccount.length() > 0)) {
          return new WloginLastLoginInfo(((WloginLoginInfo)localObject).mAccount, ((WloginLoginInfo)localObject).mUin);
        }
        return new WloginLastLoginInfo(String.valueOf(((WloginLoginInfo)localObject).mUin), ((WloginLoginInfo)localObject).mUin);
      }
    }
  }
  
  public WUserSigInfo GetLocalSig(String paramString, long paramLong)
  {
    if (paramString == null)
    {
      util.LOGI("userAccount null", "");
      return null;
    }
    for (;;)
    {
      try
      {
        if (!util.check_uin_account(paramString).booleanValue())
        {
          l = this.mG.b(paramString);
          if (l == 0L) {
            break;
          }
          localWloginSigInfo = this.mG.a(l, paramLong);
          if (localWloginSigInfo == null) {
            continue;
          }
          localWUserSigInfo = new WUserSigInfo();
        }
      }
      catch (Exception localException1)
      {
        long l;
        WloginSigInfo localWloginSigInfo;
        WUserSigInfo localWUserSigInfo = null;
        util.printException(localException1, paramString);
        continue;
        localWUserSigInfo = null;
        continue;
      }
      try
      {
        localWUserSigInfo.uin = paramString;
        localWUserSigInfo.get_clone(localWloginSigInfo);
        util.LOGI("skey in sigInfo " + util.getMaskBytes(localWloginSigInfo._sKey, 2, 2), paramString);
        return localWUserSigInfo;
      }
      catch (Exception localException2)
      {
        continue;
      }
      l = Long.parseLong(paramString);
    }
  }
  
  public Ticket GetLocalTicket(String paramString, long paramLong, int paramInt)
  {
    util.LOGI("GetLocalTicket appid " + paramLong + " type 0x" + String.format("%x", new Object[] { Integer.valueOf(paramInt) }), paramString);
    if (paramString == null)
    {
      util.LOGI("userAccount null", "");
      return null;
    }
    return GetUserSigInfoTicket(GetLocalSig(paramString, paramLong), paramInt);
  }
  
  public int GetOpenKeyWithoutPasswd(String paramString, long paramLong1, long paramLong2, int paramInt, WUserSigInfo paramWUserSigInfo)
  {
    return GetStWithoutPasswd(paramString, paramLong1, this.mOpenAppid, -1L, paramInt, paramLong2, null, paramWUserSigInfo, (byte[][])null, (byte[][])null, 0, null);
  }
  
  public byte[] GetPictureData(String paramString)
  {
    return GetPictureData(paramString, 0L);
  }
  
  public byte[] GetPictureData(String paramString, long paramLong)
  {
    long l = paramLong;
    if (paramLong <= 0L) {
      l = this.mAysncSeq;
    }
    return t.b(l)._t105.get_pic();
  }
  
  @Deprecated
  public byte[] GetPicturePrompt(String paramString)
  {
    return GetPicturePrompt(paramString, 0L);
  }
  
  @Deprecated
  public byte[] GetPicturePrompt(String paramString, long paramLong)
  {
    long l = paramLong;
    if (paramLong <= 0L) {
      l = this.mAysncSeq;
    }
    return t.b(l)._t165.get_data();
  }
  
  public String GetPicturePromptValue(String paramString)
  {
    return GetPicturePromptValue(paramString, 0L);
  }
  
  public String GetPicturePromptValue(String paramString, long paramLong)
  {
    paramString = GetPicturePrompt(paramString, paramLong);
    int k;
    int j;
    int i;
    if ((paramString != null) && (paramString.length > 3))
    {
      k = util.buf_to_int32(paramString, 0);
      j = 4;
      i = 0;
    }
    for (;;)
    {
      if ((i >= k) || (paramString.length < j + 1)) {}
      int m;
      String str1;
      do
      {
        do
        {
          do
          {
            return "";
            m = util.buf_to_int8(paramString, j);
            j += 1;
          } while (paramString.length < j + m);
          str1 = new String(paramString, j, m);
          m = j + m;
        } while (paramString.length < m + 2);
        j = util.buf_to_int32(paramString, m);
        m += 4;
      } while (paramString.length < m + j);
      String str2 = new String(paramString, m, j);
      if (str1.equals("pic_reason")) {
        return str2;
      }
      i += 1;
      j += m;
    }
  }
  
  public Ticket GetPskey(String paramString, long paramLong, String[] arg4, WtTicketPromise paramWtTicketPromise)
  {
    Bundle localBundle = new Bundle();
    localBundle.putStringArray("domains", ???);
    String str = "";
    int i = 0;
    while (i < ???.length)
    {
      str = str + ???[i] + ",";
      i += 1;
    }
    synchronized (GET_TICKET_LOCK)
    {
      util.LOGI("GetPskey appid " + paramLong + " domains " + str, paramString);
      paramString = GetTicket(paramString, paramLong, 1048576, paramWtTicketPromise, localBundle);
      return paramString;
    }
  }
  
  public Ticket GetSkey(String paramString, long paramLong, WtTicketPromise paramWtTicketPromise)
  {
    synchronized (GET_TICKET_LOCK)
    {
      paramString = GetTicket(paramString, paramLong, 4096, paramWtTicketPromise, null);
      return paramString;
    }
  }
  
  public int GetStViaSMSVerifyLogin(String paramString, long paramLong1, long paramLong2, int paramInt, WUserSigInfo paramWUserSigInfo)
  {
    util.LOGI("user:" + paramString + " GetStViaSMSVerifyLogin ...", paramString);
    if (oicq.wlogin_sdk.a.j.x) {}
    for (String str = oicq.wlogin_sdk.a.j.z;; str = "") {
      return GetStWithPasswd(paramString, paramLong1, paramInt, paramLong2, null, false, str, paramWUserSigInfo, (byte[][])null, true, 0);
    }
  }
  
  public int GetStViaSMSVerifyLogin(String paramString, long paramLong1, long paramLong2, long[] paramArrayOfLong, int paramInt, WUserSigInfo paramWUserSigInfo)
  {
    byte[][] arrayOfByte = (byte[][])null;
    if ((paramArrayOfLong != null) && (paramArrayOfLong.length > 0))
    {
      int i = paramArrayOfLong.length;
      arrayOfByte = (byte[][])Array.newInstance(Byte.TYPE, new int[] { i, 0 });
    }
    for (;;)
    {
      util.LOGI("user:" + paramString + " GetStViaSMSVerifyLogin ...", paramString);
      if (oicq.wlogin_sdk.a.j.x) {}
      for (String str = oicq.wlogin_sdk.a.j.z;; str = "") {
        return GetStWithPasswd(paramString, paramLong1, paramInt, paramLong2, paramArrayOfLong, false, str, paramWUserSigInfo, arrayOfByte, true, 0);
      }
    }
  }
  
  public int GetStWithPasswd(String paramString1, long paramLong1, int paramInt, long paramLong2, long[] paramArrayOfLong, boolean paramBoolean, String paramString2, WUserSigInfo paramWUserSigInfo, byte[][] paramArrayOfByte)
  {
    return GetStWithPasswd(paramString1, paramLong1, paramInt, paramLong2, paramArrayOfLong, paramBoolean, paramString2, paramWUserSigInfo, paramArrayOfByte, false, 0);
  }
  
  public int GetStWithPasswd(String paramString1, long paramLong1, long paramLong2, int paramInt, String paramString2, WUserSigInfo paramWUserSigInfo)
  {
    return GetStWithPasswd(paramString1, paramLong1, paramInt, paramLong2, null, false, paramString2, paramWUserSigInfo, (byte[][])null, false, 0);
  }
  
  @Deprecated
  public int GetStWithPasswd(String paramString1, long paramLong, String paramString2, WUserSigInfo paramWUserSigInfo)
  {
    return GetStWithPasswd(paramString1, paramLong, this.mMainSigMap, 1L, null, false, paramString2, paramWUserSigInfo, (byte[][])null, false, 0);
  }
  
  public int GetStWithPasswdMd5(String paramString1, long paramLong1, long paramLong2, int paramInt, String paramString2, WUserSigInfo paramWUserSigInfo)
  {
    return GetStWithPasswd(paramString1, paramLong1, paramInt, paramLong2, null, true, paramString2, paramWUserSigInfo, (byte[][])null, false, 0);
  }
  
  @Deprecated
  public int GetStWithPasswdMd5(String paramString1, long paramLong, String paramString2, WUserSigInfo paramWUserSigInfo)
  {
    return GetStWithPasswd(paramString1, paramLong, this.mMainSigMap, 1L, null, true, paramString2, paramWUserSigInfo, (byte[][])null, false, 0);
  }
  
  public int GetStWithoutPasswd(String paramString, long paramLong1, long paramLong2, long paramLong3, int paramInt, long paramLong4, long[] paramArrayOfLong, WUserSigInfo paramWUserSigInfo, byte[][] paramArrayOfByte1, byte[][] paramArrayOfByte2)
  {
    return GetStWithoutPasswd(paramString, paramLong1, paramLong2, paramLong3, paramInt, paramLong4, paramArrayOfLong, paramWUserSigInfo, paramArrayOfByte1, paramArrayOfByte2, 0, null);
  }
  
  public int GetStWithoutPasswd(String paramString, long paramLong1, long paramLong2, long paramLong3, int paramInt, WUserSigInfo paramWUserSigInfo)
  {
    return GetStWithoutPasswd(paramString, paramLong1, paramLong2, -1L, paramInt, paramLong3, null, paramWUserSigInfo, (byte[][])null, (byte[][])null, 0, null);
  }
  
  public int GetStWithoutPasswd(String paramString, long paramLong1, long paramLong2, long paramLong3, int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, WUserSigInfo paramWUserSigInfo)
  {
    byte[][] arrayOfByte = new byte[4][];
    arrayOfByte[0] = new byte[1];
    arrayOfByte[0][0] = 1;
    arrayOfByte[1] = paramArrayOfByte1;
    arrayOfByte[2] = paramArrayOfByte2;
    arrayOfByte[3] = paramArrayOfByte3;
    return GetStWithoutPasswd(paramString, paramLong1, paramLong2, -1L, paramInt, paramLong3, null, paramWUserSigInfo, (byte[][])null, arrayOfByte, 0, null);
  }
  
  @Deprecated
  public int GetStWithoutPasswd(String paramString, long paramLong1, long paramLong2, WUserSigInfo paramWUserSigInfo)
  {
    return GetStWithoutPasswd(paramString, paramLong1, paramLong2, -1L, this.mMainSigMap, 1L, null, paramWUserSigInfo, (byte[][])null, (byte[][])null, 0, null);
  }
  
  public int GetStWithoutPasswd(byte[] paramArrayOfByte, long paramLong, int paramInt, WUserSigInfo paramWUserSigInfo)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {
      return -1017;
    }
    Object localObject = cryptor.decrypt(paramArrayOfByte, 0, paramArrayOfByte.length, t.B);
    if ((localObject == null) || (localObject.length <= 0)) {
      return -1017;
    }
    if (2 > localObject.length) {
      return -1017;
    }
    int i = util.buf_to_int16((byte[])localObject, 0);
    if ((i <= 0) || (i + 2 > localObject.length)) {
      return -1017;
    }
    paramArrayOfByte = new String((byte[])localObject, 2, i);
    i += 2;
    if (i + 8 > localObject.length) {
      return -1017;
    }
    long l = util.buf_to_int64((byte[])localObject, i);
    int j = i + 8;
    if (j + 2 > localObject.length) {
      return -1017;
    }
    i = util.buf_to_int16((byte[])localObject, j);
    j += 2;
    if ((i <= 0) || (j + i > localObject.length)) {
      return -1017;
    }
    byte[] arrayOfByte1 = new byte[i];
    System.arraycopy(localObject, j, arrayOfByte1, 0, arrayOfByte1.length);
    j += i;
    if (j + 2 > localObject.length) {
      return -1017;
    }
    i = util.buf_to_int16((byte[])localObject, j);
    j += 2;
    if ((i <= 0) || (j + i > localObject.length)) {
      return -1017;
    }
    byte[] arrayOfByte2 = new byte[i];
    System.arraycopy(localObject, j, arrayOfByte2, 0, arrayOfByte2.length);
    localObject = new byte[3][];
    localObject[0] = new byte[1];
    localObject[0][0] = 2;
    localObject[1] = arrayOfByte1;
    localObject[2] = arrayOfByte2;
    return GetStWithoutPasswd(paramArrayOfByte, l, paramLong, -1L, paramInt, 1L, null, paramWUserSigInfo, (byte[][])null, (byte[][])localObject, 0, null);
  }
  
  public Ticket GetTicket(String paramString, long paramLong, int paramInt, WtTicketPromise paramWtTicketPromise, Bundle paramBundle)
  {
    Object localObject2 = new StringBuilder().append("GetTicket ").append(paramString).append(", ").append(paramLong).append(" sig ").append(Integer.toHexString(paramInt)).append(" ");
    if (paramBundle == null) {}
    int j;
    Object localObject3;
    for (Object localObject1 = "null";; localObject1 = Integer.valueOf(paramBundle.size()))
    {
      util.LOGI(localObject1, "");
      localObject1 = null;
      j = 2;
      localObject2 = GetLocalSig(paramString, paramLong);
      if (localObject2 != null) {
        break label227;
      }
      if (j != 1) {
        break;
      }
      localObject3 = localObject1;
      label103:
      if (!IsNeedLoginWithPasswd(paramString, paramLong).booleanValue()) {
        break label517;
      }
      paramBundle = new ErrMsg();
      paramBundle.setType(-1004);
      if (paramWtTicketPromise != null) {
        paramWtTicketPromise.Failed(paramBundle);
      }
      util.LOGI("get null for sigType:0x" + Integer.toHexString(paramInt), paramString);
      localObject1 = null;
      label177:
      return localObject1;
    }
    RefreshMemorySig();
    int i = j - 1;
    localObject2 = localObject1;
    for (;;)
    {
      localObject1 = localObject2;
      j = i;
      if (i > 0) {
        break;
      }
      localObject3 = localObject2;
      break label103;
      label227:
      Ticket localTicket = GetUserSigInfoTicket((WUserSigInfo)localObject2, paramInt);
      if ((localTicket == null) || (localTicket._sig == null) || (localTicket._sig.length == 0))
      {
        localObject3 = localObject1;
        if (j == 1) {
          break label103;
        }
        RefreshMemorySig();
        i = j - 1;
        localObject2 = localObject1;
        continue;
      }
      long l = t.f();
      localObject2 = localObject1;
      if (paramBundle != null)
      {
        localObject2 = localObject1;
        if (paramInt == 1048576) {
          localObject2 = paramBundle.getStringArray("domains");
        }
      }
      i = isPskeyExpired(paramInt, (String[])localObject2, localTicket, l, j);
      localObject3 = localObject2;
      if (i == 1) {
        break label103;
      }
      if (i == 2)
      {
        i = j - 1;
      }
      else
      {
        localObject1 = localTicket;
        if (i == 3) {
          break label177;
        }
        util.LOGI("GetTicket sigType:0x" + Integer.toHexString(paramInt) + " expires in " + (localTicket._expire_time - l) / 60L / 60L + "h", "");
        if (paramInt == 4096)
        {
          localObject1 = localTicket;
          if (true != Ticket.isSkeyExpired(localTicket._expire_time)) {
            break label177;
          }
          localObject3 = localObject2;
          if (j == 1) {
            break label103;
          }
          RefreshMemorySig();
          i = j - 1;
          continue;
        }
        localObject1 = localTicket;
        if (l < localTicket._expire_time) {
          break label177;
        }
        localObject3 = localObject2;
        if (j == 1) {
          break label103;
        }
        RefreshMemorySig();
        i = j - 1;
      }
    }
    label517:
    localObject1 = new WUserSigInfo();
    if (paramBundle != null) {}
    for (i = paramBundle.getInt("subappid", 1);; i = 1)
    {
      if (localObject3 != null)
      {
        j = 0;
        int k = Math.min(20, localObject3.length);
        while (j < k)
        {
          localObject2 = localObject3[j];
          if ((localObject2 != null) && (((String)localObject2).length() > 0)) {
            ((WUserSigInfo)localObject1)._domains.add(localObject2);
          }
          j += 1;
        }
      }
      GetStWithoutPasswd(paramString, paramLong, paramLong, i, paramInt, (WUserSigInfo)localObject1, new WtloginHelper.1(this, paramWtTicketPromise, paramString, paramLong, paramInt, paramBundle));
      break;
    }
  }
  
  public long GetTimeDifference()
  {
    return t.ad;
  }
  
  public Boolean IsNeedLoginWithPasswd(String paramString, long paramLong)
  {
    boolean bool = false;
    int i = 1;
    if (paramString == null) {
      return Boolean.valueOf(true);
    }
    for (;;)
    {
      try
      {
        long l1;
        if (!util.check_uin_account(paramString).booleanValue())
        {
          long l2 = this.mG.b(paramString);
          l1 = l2;
          if (l2 == 0L)
          {
            bool = true;
            util.LOGI("NeedLoginWithPasswd:" + bool + " appid:" + paramLong + " flag=" + i, paramString);
            return Boolean.valueOf(bool);
          }
        }
        else
        {
          l1 = Long.parseLong(paramString);
        }
        WloginSigInfo localWloginSigInfo = this.mG.a(l1, paramLong);
        if ((localWloginSigInfo != null) && (localWloginSigInfo._en_A1 != null) && (localWloginSigInfo._en_A1.length != 0) && (localWloginSigInfo._noPicSig != null) && (localWloginSigInfo._noPicSig.length != 0))
        {
          i = 2;
          continue;
        }
        if ((localWloginSigInfo == null) || (localWloginSigInfo._TGT == null) || (localWloginSigInfo._TGT.length == 0) || (localWloginSigInfo.iSExpireA2(t.f()))) {
          break label215;
        }
        i = 0;
      }
      finally {}
      continue;
      label215:
      bool = true;
      i = 3;
    }
  }
  
  public Boolean IsUserHaveA1(String paramString, long paramLong)
  {
    if (paramString == null) {
      return Boolean.valueOf(false);
    }
    long l1;
    Object localObject;
    if (!util.check_uin_account(paramString).booleanValue())
    {
      long l2 = this.mG.b(paramString);
      l1 = l2;
      if (l2 != 0L) {
        break label116;
      }
      localObject = null;
    }
    while ((localObject == null) || (localObject._en_A1 == null) || (localObject._en_A1.length <= 0))
    {
      util.LOGI("userAccount:" + paramString + " dwAppid:" + paramLong + " IsUserHaveA1 return: null", paramString);
      return Boolean.valueOf(false);
      l1 = Long.parseLong(paramString);
      label116:
      WloginSigInfo localWloginSigInfo = this.mG.a(l1, paramLong);
      localObject = localWloginSigInfo;
      if (localWloginSigInfo == null) {
        localObject = localWloginSigInfo;
      }
    }
    util.LOGI("userAccount:" + paramString + " dwAppid:" + paramLong + " IsUserHaveA1 return: not null", paramString);
    return Boolean.valueOf(true);
  }
  
  public boolean IsWtLoginUrl(String paramString)
  {
    if (paramString == null) {}
    do
    {
      int i;
      do
      {
        return false;
        i = paramString.indexOf("?k=");
      } while ((i == -1) || (i + 3 + 32 > paramString.length()));
      i += 3;
      paramString = paramString.substring(i, i + 32);
    } while (util.base64_decode_url(paramString.getBytes(), paramString.length()) == null);
    return true;
  }
  
  public byte[] PickupQRCode(String paramString)
  {
    if (paramString == null) {}
    while (!paramString.matches(".*[?&]k=([^&$]+).*")) {
      return null;
    }
    paramString = paramString.replaceAll(".*[?&]k=([^&$]+).*", "$1");
    return util.base64_decode_url(paramString.getBytes(), paramString.length());
  }
  
  public Intent PrepareQloginIntent(long paramLong1, long paramLong2, String paramString)
  {
    Object localObject1 = "com.tencent.mobileqq";
    boolean bool1 = util.isMQQExist(this.mContext);
    boolean bool2 = util.isPackageExist(this.mContext, "com.tencent.minihd.qq");
    if (!bool1)
    {
      if (bool2) {
        localObject1 = "com.tencent.minihd.qq";
      }
    }
    else
    {
      Object localObject3 = util.get_rsa_pubkey(this.mContext);
      Object localObject2;
      if (localObject3 != null)
      {
        localObject2 = localObject3;
        if (localObject3.length != 0) {}
      }
      else
      {
        localObject2 = util.string_to_buf("30818902818100daaa2a418b271f3dfcf8f0a9120326d47f07618593d8d71d61a4fe987cc47740e491105bf8e68bd479bf51dfe19d3b06e12017df6d87a0f43bb82b57f59bd4220f2a3d8d68904a6ddb51197989e6e82512d8d8fa6c41b755a8ca962595d3e1e1be7ea01677249be4794cd7c6682d611c1bd81f0a16231fb83517515b94d13e5d0203010001");
      }
      localObject3 = new Intent();
      ((Intent)localObject3).setClassName((String)localObject1, "com.tencent.open.agent.AgentActivity");
      localObject1 = new Bundle();
      ((Bundle)localObject1).putLong("dstSsoVer", 1L);
      ((Bundle)localObject1).putLong("dstAppid", paramLong1);
      ((Bundle)localObject1).putLong("subDstAppid", paramLong2);
      ((Bundle)localObject1).putByteArray("dstAppVer", paramString.getBytes());
      ((Bundle)localObject1).putByteArray("publickey", (byte[])localObject2);
      ((Intent)localObject3).putExtra("key_params", (Bundle)localObject1);
      ((Intent)localObject3).putExtra("key_action", "action_quick_login");
      return localObject3;
    }
    return null;
  }
  
  public Intent PrepareQloginResult(String paramString, long paramLong1, long paramLong2, int paramInt, WFastLoginInfo paramWFastLoginInfo)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("quicklogin_uin", paramString);
    paramString = (byte[])paramWFastLoginInfo._outA1.clone();
    if ((paramString != null) && (paramString.length > 0)) {
      localIntent.putExtra("quicklogin_buff", new RSACrypt(this.mContext).EncryptData(util.get_cp_pubkey(this.mContext, paramLong1, paramLong2), paramString));
    }
    localIntent.putExtra("quicklogin_ret", paramInt);
    localIntent.putExtra("user_json", paramWFastLoginInfo.userJson);
    return localIntent;
  }
  
  public Intent PrepareSilenceLoginIntent(long paramLong1, long paramLong2, String paramString)
  {
    Object localObject2 = util.get_rsa_pubkey(this.mContext);
    Object localObject1;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (localObject2.length != 0) {}
    }
    else
    {
      localObject1 = util.string_to_buf("30818902818100daaa2a418b271f3dfcf8f0a9120326d47f07618593d8d71d61a4fe987cc47740e491105bf8e68bd479bf51dfe19d3b06e12017df6d87a0f43bb82b57f59bd4220f2a3d8d68904a6ddb51197989e6e82512d8d8fa6c41b755a8ca962595d3e1e1be7ea01677249be4794cd7c6682d611c1bd81f0a16231fb83517515b94d13e5d0203010001");
    }
    localObject2 = new Intent();
    Bundle localBundle = new Bundle();
    localBundle.putLong("dstSsoVer", 1L);
    localBundle.putLong("dstAppid", paramLong1);
    localBundle.putLong("subDstAppid", paramLong2);
    localBundle.putByteArray("dstAppVer", paramString.getBytes());
    localBundle.putByteArray("publickey", (byte[])localObject1);
    ((Intent)localObject2).putExtra("key_params", localBundle);
    ((Intent)localObject2).putExtra("key_action", "action_quick_login");
    return localObject2;
  }
  
  public int QueryCodeResult(long paramLong, WUserSigInfo paramWUserSigInfo)
  {
    util.LOGI(" QueryCodeResult ...", "");
    oicq.wlogin_sdk.code2d.e locale = new oicq.wlogin_sdk.code2d.e();
    TransReqContext localTransReqContext = new TransReqContext();
    localTransReqContext.set_code2d_func_req();
    localTransReqContext.set_subcmd(locale.get_cmd());
    util.LOGI("qrsig " + util.buf_to_string(oicq.wlogin_sdk.code2d.d.i));
    localTransReqContext._body = locale.a(0L, paramLong, oicq.wlogin_sdk.code2d.d.i, new byte[0]);
    return RequestTransport(0, 1, null, paramLong, locale._role, localTransReqContext, paramWUserSigInfo);
  }
  
  public void RefreshMemorySig()
  {
    this.mG.k();
  }
  
  public int RefreshPictureData(String paramString, WUserSigInfo paramWUserSigInfo)
  {
    WUserSigInfo localWUserSigInfo = paramWUserSigInfo;
    if (paramWUserSigInfo == null) {
      localWUserSigInfo = new WUserSigInfo();
    }
    return RefreshPictureData(paramString, localWUserSigInfo, 0);
  }
  
  public int RefreshSMSData(String paramString, long paramLong, WUserSigInfo paramWUserSigInfo)
  {
    if (paramWUserSigInfo == null) {
      paramWUserSigInfo = new WUserSigInfo();
    }
    for (;;)
    {
      return RefreshSMSData(paramString, paramLong, paramWUserSigInfo, 0);
    }
  }
  
  public int RefreshSMSVerifyLoginCode(String paramString, WUserSigInfo paramWUserSigInfo)
  {
    return RefreshSMSVerifyLoginCode(paramString, paramWUserSigInfo, 0);
  }
  
  public int RegGetAccount(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, byte[] paramArrayOfByte5, int paramInt, WUserSigInfo paramWUserSigInfo)
  {
    if ((paramArrayOfByte3 == null) || (paramArrayOfByte3.length <= 0)) {
      return -1017;
    }
    util.LOGI("RegGetAccount ...", "");
    oicq.wlogin_sdk.a.d locald = new oicq.wlogin_sdk.a.d();
    TransReqContext localTransReqContext = new TransReqContext();
    oicq.wlogin_sdk.a.j localj = this.mRegStatus;
    if (paramArrayOfByte1 != null) {}
    for (localj.j = ((byte[])paramArrayOfByte1.clone());; localj.j = new byte[0])
    {
      if ((paramInt == 4) || (paramInt == 5)) {
        localj.b = "";
      }
      oicq.wlogin_sdk.a.j.x = false;
      oicq.wlogin_sdk.a.j.y = 0L;
      localTransReqContext.set_register_req();
      localTransReqContext.set_subcmd(locald.a());
      localTransReqContext._body = locald.a(localj.e, paramArrayOfByte1, paramArrayOfByte3, paramArrayOfByte4, paramInt, localj.b.getBytes(), paramArrayOfByte2, false, GetGuid(), 0L, t.E, paramArrayOfByte5, t.z, paramWUserSigInfo.extraRegTLVMap);
      return RequestTransport(0, 1, null, 0L, oicq.wlogin_sdk.a.j.i, localTransReqContext, paramWUserSigInfo);
    }
  }
  
  public int RegGetSMSVerifyLoginAccount(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, WUserSigInfo paramWUserSigInfo)
  {
    util.LOGI("RegGetSMSVerifyLoginAccount ...", "");
    oicq.wlogin_sdk.a.d locald = new oicq.wlogin_sdk.a.d();
    TransReqContext localTransReqContext = new TransReqContext();
    oicq.wlogin_sdk.a.j localj = this.mRegStatus;
    if (paramArrayOfByte1 != null) {}
    for (localj.j = ((byte[])paramArrayOfByte1.clone());; localj.j = new byte[0])
    {
      oicq.wlogin_sdk.a.j.x = true;
      oicq.wlogin_sdk.a.j.z = util.get_mpasswd();
      localTransReqContext.set_register_req();
      localTransReqContext.set_subcmd(locald.a());
      localTransReqContext._body = locald.a(localj.e, paramArrayOfByte1, oicq.wlogin_sdk.a.j.z.getBytes(), paramArrayOfByte3, 1, localj.b.getBytes(), paramArrayOfByte2, true, GetGuid(), localj.h, t.E, paramArrayOfByte4, t.z, paramWUserSigInfo.extraRegTLVMap);
      return RequestTransport(0, 1, null, 0L, oicq.wlogin_sdk.a.j.i, localTransReqContext, paramWUserSigInfo);
    }
  }
  
  public int RegQueryAccount(int paramInt, byte[] paramArrayOfByte, long paramLong, WUserSigInfo paramWUserSigInfo)
  {
    byte[] arrayOfByte = paramArrayOfByte;
    if (paramArrayOfByte == null) {
      arrayOfByte = new byte[0];
    }
    util.LOGI("RegQueryAccount ...", "");
    this.mRegStatus = new oicq.wlogin_sdk.a.j();
    this.mRegStatus.b = new String(arrayOfByte);
    paramArrayOfByte = new oicq.wlogin_sdk.a.e();
    TransReqContext localTransReqContext = new TransReqContext();
    oicq.wlogin_sdk.a.j localj = this.mRegStatus;
    localTransReqContext.set_register_req();
    localTransReqContext.set_subcmd(paramArrayOfByte.a());
    localTransReqContext._body = paramArrayOfByte.a(paramInt, arrayOfByte, paramLong);
    return RequestTransport(0, 1, null, 0L, oicq.wlogin_sdk.a.j.i, localTransReqContext, paramWUserSigInfo);
  }
  
  public int RegQueryClientSentMsgStatus(WUserSigInfo paramWUserSigInfo)
  {
    util.LOGI("RegQueryClientSentMsgStatus ...", "");
    oicq.wlogin_sdk.a.f localf = new oicq.wlogin_sdk.a.f();
    TransReqContext localTransReqContext = new TransReqContext();
    oicq.wlogin_sdk.a.j localj = this.mRegStatus;
    localTransReqContext.set_register_req();
    localTransReqContext.set_subcmd(localf.a());
    localTransReqContext._body = localf.b(localj.e, this.mRegStatus.p);
    return RequestTransport(0, 1, null, 0L, oicq.wlogin_sdk.a.j.i, localTransReqContext, paramWUserSigInfo);
  }
  
  public int RegRequestServerResendMsg(WUserSigInfo paramWUserSigInfo)
  {
    util.LOGI("RegRequestServerResendMsg ...", "");
    g localg = new g();
    TransReqContext localTransReqContext = new TransReqContext();
    oicq.wlogin_sdk.a.j localj = this.mRegStatus;
    localTransReqContext.set_register_req();
    localTransReqContext.set_subcmd(localg.a());
    localTransReqContext._body = localg.b(localj.e, null);
    return RequestTransport(0, 1, null, 0L, oicq.wlogin_sdk.a.j.i, localTransReqContext, paramWUserSigInfo);
  }
  
  public int RegSubmitMobile(String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, WUserSigInfo paramWUserSigInfo)
  {
    if (paramString == null) {}
    for (paramString = new byte[0];; paramString = paramString.getBytes()) {
      return RegSubmitMobile(paramString, paramArrayOfByte1, null, paramArrayOfByte2, paramInt1, paramInt2, paramInt3, paramLong1, paramLong2, paramWUserSigInfo);
    }
  }
  
  public int RegSubmitMobile(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, WUserSigInfo paramWUserSigInfo)
  {
    return RegSubmitMobile(null, paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3, paramInt1, paramInt2, paramInt3, paramLong1, paramLong2, paramWUserSigInfo);
  }
  
  public int RegSubmitMsgChk(byte[] paramArrayOfByte, WUserSigInfo paramWUserSigInfo)
  {
    if (paramArrayOfByte == null) {
      return -1017;
    }
    util.LOGI("RegSubmitMsgChk ...", "");
    oicq.wlogin_sdk.a.i locali = new oicq.wlogin_sdk.a.i();
    TransReqContext localTransReqContext = new TransReqContext();
    oicq.wlogin_sdk.a.j localj = this.mRegStatus;
    localTransReqContext.set_register_req();
    localTransReqContext.set_subcmd(locali.a());
    localTransReqContext._body = locali.b(localj.e, paramArrayOfByte);
    return RequestTransport(0, 1, null, 0L, oicq.wlogin_sdk.a.j.i, localTransReqContext, paramWUserSigInfo);
  }
  
  public int RequestTransport(int paramInt1, int paramInt2, String paramString, long paramLong1, long paramLong2, TransReqContext paramTransReqContext, WUserSigInfo paramWUserSigInfo)
  {
    if (paramInt1 == 0)
    {
      new WtloginHelper.HelperThread(this, this, this.mHelperHandler, paramInt2, paramString, paramLong1, paramLong2, paramTransReqContext, paramWUserSigInfo, "RequestTransport").RunReq(9);
      return -1001;
    }
    t localt = this.mG.a(0L);
    util.LOGI("encrypt:" + paramInt2 + " appid:" + paramLong1 + " role:" + paramLong2 + " Seq:" + localt.h + "subcmd=" + paramTransReqContext._subcmd + " RequestTransport...", paramString);
    localt.g = paramString;
    if (paramInt2 != 0) {
      if (paramString == null)
      {
        localt.m = 0;
        paramInt1 = new aa(localt).a(0L, paramTransReqContext, null, null, paramLong1, paramLong2, paramWUserSigInfo);
      }
    }
    for (;;)
    {
      localt.j();
      util.LOGI("encrypt:" + paramInt2 + " appid:" + paramLong1 + " role:" + paramLong2 + " Seq:" + localt.h + "subcmd=" + paramTransReqContext._subcmd + " RequestTransport ret=" + paramInt1, paramString);
      return paramInt1;
      WloginSimpleInfo localWloginSimpleInfo = new WloginSimpleInfo();
      if ((paramString == null) || (!GetBasicUserInfo(paramString, localWloginSimpleInfo).booleanValue()))
      {
        paramInt1 = -1003;
      }
      else
      {
        WloginSigInfo localWloginSigInfo = localt.a(localWloginSimpleInfo._uin, paramLong1);
        if (localWloginSigInfo == null)
        {
          paramInt1 = -1004;
        }
        else
        {
          localt.f = localWloginSimpleInfo._uin;
          paramInt1 = new aa(localt).a(localWloginSimpleInfo._uin, paramTransReqContext, localWloginSigInfo._userStSig, localWloginSigInfo._userSt_Key, paramLong1, paramLong2, paramWUserSigInfo);
          continue;
          localt.f = 0L;
          paramInt1 = new aa(localt).a(localt.f, paramTransReqContext, null, null, paramLong1, paramLong2, paramWUserSigInfo);
        }
      }
    }
  }
  
  public int RequestTransportMsf(int paramInt1, int paramInt2, String paramString, long paramLong1, long paramLong2, TransReqContext paramTransReqContext)
  {
    if (paramInt1 == 0)
    {
      new WtloginHelper.HelperThread(this, this, this.mHelperHandler, paramInt2, paramString, paramLong1, paramLong2, paramTransReqContext, "RequestTransportMsf").RunReq(10);
      return -1001;
    }
    t localt = this.mG.a(0L);
    util.LOGI("user:" + paramString + " encrypt:" + paramInt2 + " appid:" + paramLong1 + " role:" + paramLong2 + " Seq:" + localt.h + " RequestTransportMsf...", paramString);
    localt.g = paramString;
    Object localObject1;
    if (paramInt2 != 0)
    {
      localObject1 = new WloginSimpleInfo();
      if ((paramString == null) || (!GetBasicUserInfo(paramString, (WloginSimpleInfo)localObject1).booleanValue())) {
        paramInt1 = -1003;
      }
    }
    for (;;)
    {
      localt.j();
      util.LOGI("user:" + paramString + " encrypt:" + paramInt2 + " appid:" + paramLong1 + " role:" + paramLong2 + " Seq:" + localt.h + " RequestTransportMsf ret=" + paramInt1, paramString);
      return paramInt1;
      Object localObject2 = localt.a(((WloginSimpleInfo)localObject1)._uin, paramLong1);
      if (localObject2 == null)
      {
        paramInt1 = -1004;
      }
      else
      {
        localt.f = ((WloginSimpleInfo)localObject1)._uin;
        paramInt1 = new aa(localt).a(((WloginSimpleInfo)localObject1)._uin, paramTransReqContext, ((WloginSigInfo)localObject2)._userStSig, ((WloginSigInfo)localObject2)._userSt_Key, ((WloginSigInfo)localObject2)._TGT, paramLong1, paramLong2, new WUserSigInfo());
        continue;
        if ((util.check_uin_account(paramString).booleanValue()) && (Long.parseLong(paramString) == 0L))
        {
          localt.f = 0L;
          localObject1 = new aa(localt);
          localObject2 = new WUserSigInfo();
          paramInt1 = ((aa)localObject1).a(0L, paramTransReqContext, null, null, new byte[0], paramLong1, paramLong2, (WUserSigInfo)localObject2);
        }
        else
        {
          localObject1 = new WloginSimpleInfo();
          if ((paramString == null) || (!GetBasicUserInfo(paramString, (WloginSimpleInfo)localObject1).booleanValue()))
          {
            paramInt1 = -1003;
          }
          else
          {
            localObject2 = localt.a(((WloginSimpleInfo)localObject1)._uin, paramLong1);
            if (localObject2 == null)
            {
              paramInt1 = -1004;
            }
            else
            {
              localt.f = ((WloginSimpleInfo)localObject1)._uin;
              paramInt1 = new aa(localt).a(((WloginSimpleInfo)localObject1)._uin, paramTransReqContext, null, null, ((WloginSigInfo)localObject2)._TGT, paramLong1, paramLong2, new WUserSigInfo());
            }
          }
        }
      }
    }
  }
  
  public WUserSigInfo ResolveQloginIntentReserved(Intent paramIntent)
  {
    if (paramIntent == null) {
      return null;
    }
    if (paramIntent.getExtras().getInt("quicklogin_ret") != 0)
    {
      util.LOGI("ResolveQloginIntentReserved quicklogin_ret is null", "");
      return null;
    }
    String str = paramIntent.getExtras().getString("quicklogin_uin");
    paramIntent = paramIntent.getExtras().getByteArray("quicklogin_buff");
    if ((str == null) || (paramIntent == null))
    {
      util.LOGI("ResolveQloginIntentReserved uin or buff is null", "");
      return null;
    }
    WUserSigInfo localWUserSigInfo = new WUserSigInfo();
    localWUserSigInfo._fastLoginBuf = new RSACrypt(this.mContext).DecryptData(null, paramIntent);
    if (localWUserSigInfo._fastLoginBuf == null)
    {
      util.LOGI("rsa decrypt failed", "");
      return null;
    }
    localWUserSigInfo.uin = str;
    return localWUserSigInfo;
  }
  
  public void SetAppClientVersion(int paramInt)
  {
    t.w = paramInt;
  }
  
  public void SetCanWebVerify(int paramInt)
  {
    k.K = paramInt;
  }
  
  public void SetDevlockMobileType(int paramInt)
  {
    r.K = paramInt;
  }
  
  public void SetImgType(int paramInt)
  {
    t.x = paramInt;
    this.mMiscBitmap |= 0x80;
  }
  
  public WtloginListener SetListener(WtloginListener paramWtloginListener)
  {
    WtloginListener localWtloginListener = this.mListener;
    this.mListener = paramWtloginListener;
    return localWtloginListener;
  }
  
  public void SetLocalId(int paramInt)
  {
    t.u = paramInt;
  }
  
  public void SetMsfTransportFlag(int paramInt)
  {
    this.mG.k = paramInt;
    if (paramInt != 0)
    {
      t.af = new byte[4];
      t.ae = 0L;
      this.mG.l = 45000;
    }
  }
  
  public int SetNeedForPayToken(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    if ((paramString1 != null) && (paramString1.length() > 0))
    {
      k.L = paramString1.getBytes();
      if (paramArrayOfByte != null) {
        k.N = paramArrayOfByte;
      }
      if (paramString2 != null)
      {
        paramString1 = paramString2;
        if (paramString2.length() != 0) {}
      }
      else
      {
        paramString1 = util.getChannelId(this.mContext, null);
      }
      k.M = paramString1.getBytes();
      if ((paramString1 == null) || (paramString1.length() == 0)) {
        return -2;
      }
    }
    else
    {
      return -1;
    }
    return 0;
  }
  
  public void SetPicType(int paramInt)
  {
    t.y = paramInt;
  }
  
  public void SetRegDevLockFlag(int paramInt)
  {
    t.z = paramInt;
  }
  
  public void SetSigMap(int paramInt)
  {
    this.mMainSigMap = (paramInt | 0xC0);
  }
  
  public void SetTestHost(int paramInt, String paramString)
  {
    oicq_request.a(paramInt, paramString);
  }
  
  public void SetTimeOut(int paramInt)
  {
    this.mG.l = paramInt;
  }
  
  public void SetUinDeviceToken(boolean paramBoolean)
  {
    t.ab = paramBoolean;
  }
  
  public int VerifyCode(String paramString, long paramLong, boolean paramBoolean, byte[] paramArrayOfByte, int[] paramArrayOfInt, int paramInt, WUserSigInfo paramWUserSigInfo)
  {
    Object localObject1 = new WloginSimpleInfo();
    if (!GetBasicUserInfo(paramString, (WloginSimpleInfo)localObject1).booleanValue()) {
      return -1003;
    }
    long l = ((WloginSimpleInfo)localObject1)._uin;
    WloginSigInfo localWloginSigInfo = FindUserSig(l, paramLong);
    if (localWloginSigInfo == null) {
      return -1004;
    }
    Object localObject3 = new tlv_t400();
    Object localObject2 = new byte[0];
    localObject1 = localObject2;
    if (localWloginSigInfo._G != null)
    {
      localObject1 = localObject2;
      if (localWloginSigInfo._G.length > 0)
      {
        localObject1 = localObject2;
        if (localWloginSigInfo._dpwd != null)
        {
          localObject1 = localObject2;
          if (localWloginSigInfo._dpwd.length > 0)
          {
            localObject1 = localObject2;
            if (localWloginSigInfo._randseed != null)
            {
              localObject1 = localObject2;
              if (localWloginSigInfo._randseed.length > 0)
              {
                ((tlv_t400)localObject3).get_tlv_400(localWloginSigInfo._G, l, t.A, localWloginSigInfo._dpwd, paramLong, 1L, localWloginSigInfo._randseed);
                localObject1 = ((tlv_t400)localObject3).get_data();
              }
            }
          }
        }
      }
    }
    util.LOGI("user:" + paramString + " VerifyCode ...", paramString);
    localObject2 = new oicq.wlogin_sdk.code2d.f();
    localObject3 = new TransReqContext();
    ((TransReqContext)localObject3).set_code2d_func_req();
    ((TransReqContext)localObject3).set_subcmd(((oicq.wlogin_sdk.code2d.f)localObject2).get_cmd());
    ((TransReqContext)localObject3).setSTEncryptMethod();
    ((TransReqContext)localObject3).setWtST(localWloginSigInfo);
    ((TransReqContext)localObject3)._body = ((oicq.wlogin_sdk.code2d.f)localObject2).a(l, paramLong, paramBoolean, paramArrayOfByte, paramArrayOfInt, localWloginSigInfo._TGT, t.A, t.E, paramInt, (byte[])localObject1);
    return RequestTransport(0, 1, paramString, paramLong, ((oicq.wlogin_sdk.code2d.f)localObject2)._role, (TransReqContext)localObject3, paramWUserSigInfo);
  }
  
  public int VerifySMSVerifyLoginCode(String paramString1, String paramString2, WUserSigInfo paramWUserSigInfo)
  {
    return VerifySMSVerifyLoginCode(paramString1, paramString2, paramWUserSigInfo, 0);
  }
  
  public int cancelCode(String paramString, long paramLong, byte[] paramArrayOfByte, WUserSigInfo paramWUserSigInfo)
  {
    Object localObject = new WloginSimpleInfo();
    if (!GetBasicUserInfo(paramString, (WloginSimpleInfo)localObject).booleanValue()) {
      return -1003;
    }
    long l = ((WloginSimpleInfo)localObject)._uin;
    this.mG.k();
    localObject = FindUserSig(l, paramLong);
    if (localObject == null) {
      return -1004;
    }
    util.LOGI("user:" + paramString + " CancelCode ...", paramString);
    oicq.wlogin_sdk.code2d.a locala = new oicq.wlogin_sdk.code2d.a();
    TransReqContext localTransReqContext = new TransReqContext();
    localTransReqContext.set_code2d_func_req();
    localTransReqContext.set_subcmd(locala.get_cmd());
    localTransReqContext.setSTEncryptMethod();
    localTransReqContext.setWtST((WloginSigInfo)localObject);
    localTransReqContext._body = locala.a(l, paramLong, paramArrayOfByte, ((WloginSigInfo)localObject)._TGT);
    return RequestTransport(0, 1, paramString, paramLong, locala._role, localTransReqContext, paramWUserSigInfo);
  }
  
  public boolean getHasPassword(long paramLong)
  {
    String str = this.mG.e(paramLong);
    util.LOGI("getHasPasswd ..." + String.valueOf(str), "" + paramLong);
    if (str == null) {}
    UinInfo localUinInfo;
    do
    {
      return true;
      localUinInfo = this.mG.c(str);
    } while (localUinInfo == null);
    boolean bool = localUinInfo.getHasPassword();
    util.LOGI("getHasPasswd userAccount: " + str + ", uin: " + paramLong + " hasPasswd: " + bool, "");
    return bool;
  }
  
  public int getStWithQrSig(String paramString, long paramLong1, long paramLong2, int paramInt, WUserSigInfo paramWUserSigInfo)
  {
    return getStWithQrSig(paramString, paramLong1, paramLong2, paramInt, paramWUserSigInfo, 0);
  }
  
  public String getUserAccountFromQuickLoginResultData(Intent paramIntent)
  {
    return "";
  }
  
  public String getUserInputFromQuickLoginResultData(Intent paramIntent)
  {
    return "";
  }
  
  public int modifyQIMPassword(int paramInt, byte[] paramArrayOfByte, WUserSigInfo paramWUserSigInfo)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {
      return -1017;
    }
    util.LOGI("modifyQIMPassword : cmd=" + paramInt);
    TransReqContext localTransReqContext = new TransReqContext();
    localTransReqContext.set_register_req();
    localTransReqContext.set_subcmd(paramInt);
    localTransReqContext._body = paramArrayOfByte;
    int i = 6084;
    if (paramInt == 1749) {
      i = 5063;
    }
    return RequestTransport(0, 1, null, 16L, i, localTransReqContext, paramWUserSigInfo);
  }
  
  public int onQuickLoginActivityResultData(WtloginHelper.QuickLoginParam paramQuickLoginParam, Intent paramIntent)
  {
    return 0;
  }
  
  public int quickLogin(Activity paramActivity, long paramLong1, long paramLong2, String paramString, WtloginHelper.QuickLoginParam paramQuickLoginParam)
  {
    util.LOGI("quickLogin start " + System.currentTimeMillis(), "");
    return 0;
  }
  
  public int quickLoginByWeChat(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, WtloginHelper.QuickLoginParam paramQuickLoginParam, int paramInt)
  {
    if (paramInt == 0)
    {
      new WtloginHelper.HelperThread(this, this, this.mHelperHandler, "", paramArrayOfByte1, paramArrayOfByte2, paramQuickLoginParam, "quickLoginByWeChat").RunReq(18);
      return -1001;
    }
    WUserSigInfo localWUserSigInfo = paramQuickLoginParam.userSigInfo;
    t localt = this.mG.a(0L);
    localt.g = paramQuickLoginParam.userAccount;
    localWUserSigInfo._seqence = localt.h;
    this.mAysncSeq = localt.h;
    async_context localasync_context = t.b(localt.h);
    util.LOGI("quickLoginByWeChat seq:" + localt.h, "");
    localasync_context._last_err_msg = new ErrMsg();
    paramQuickLoginParam.sigMap |= 0xC0;
    localasync_context._mpasswd = util.get_mpasswd();
    localasync_context._msalt = util.constructSalt();
    localasync_context._sappid = paramQuickLoginParam.appid;
    localasync_context._appid = paramQuickLoginParam.appid;
    localasync_context._sub_appid = paramQuickLoginParam.subAppid;
    localasync_context._main_sigmap = paramQuickLoginParam.sigMap;
    localasync_context._sub_appid_list = paramQuickLoginParam.dstSubAppidList;
    paramInt = new u(localt).a(paramArrayOfByte1, paramArrayOfByte2, localWUserSigInfo);
    if (paramInt != 0)
    {
      util.LOGI("quickLoginByWeChat seq " + localt.h + " ret " + paramInt);
      return paramInt;
    }
    localasync_context._tmp_pwd = MD5.toMD5Byte(localasync_context._mpasswd.getBytes());
    paramArrayOfByte1 = new k(localt, this.mContext);
    paramArrayOfByte1.g();
    int i = paramArrayOfByte1.a(paramQuickLoginParam.appid, paramQuickLoginParam.subAppid, localt.f, 0, t.af, util.getRequestInitTime(), localasync_context._tmp_pwd, 4, this.mMiscBitmap, this.mSubSigMap, paramQuickLoginParam.dstSubAppidList, paramQuickLoginParam.sigMap, paramQuickLoginParam.subAppid, t.y, 0, 0, 1, t.ac, localWUserSigInfo);
    paramInt = i;
    if (i == 204)
    {
      util.LOGI("quickLoginByWeChat seq:" + localt.h + " ret:SEC_GUID", "");
      paramInt = new p(localt).a(this.mMiscBitmap, this.mSubSigMap, paramQuickLoginParam.dstSubAppidList, localWUserSigInfo);
    }
    if (paramInt != 0)
    {
      util.LOGI("quickLoginByWeChat seq:" + localt.h + " ret:" + paramInt, "");
      return paramInt;
    }
    paramArrayOfByte1 = localt.a(localt.f, paramQuickLoginParam.appid);
    if (paramArrayOfByte1 == null)
    {
      util.LOGI("quickLoginByWeChat WloginSigInfo is null", "");
      return -1004;
    }
    localWUserSigInfo.get_clone(paramArrayOfByte1);
    paramArrayOfByte2 = GetUserSigInfoTicket(localWUserSigInfo, 128);
    paramArrayOfByte1 = paramArrayOfByte2;
    if (paramArrayOfByte2 == null) {
      paramArrayOfByte1 = new Ticket();
    }
    t.aq.commit_t2(localt.f, localt.g, util.format_ret_code(paramInt), paramInt);
    if (paramInt == 0) {
      if ((paramArrayOfByte1._sig != null) && (paramArrayOfByte1._sig.length != 0)) {
        RequestReport(0, paramArrayOfByte1._sig, paramArrayOfByte1._sig_key, localt.f, localasync_context._appid);
      }
    }
    for (;;)
    {
      if ((localt.d != null) && (localt.d.get_bitmap() != 0))
      {
        this.mG.d = localt.d;
        RequestReportError(0, paramArrayOfByte1._sig, paramArrayOfByte1._sig_key, localt.f, localasync_context._appid, 1);
      }
      t.b();
      localt.i();
      util.LOGI("quickLoginByWeChat seq:" + localt.h + " ret " + paramInt, "");
      return paramInt;
      if ((paramInt != 2) && (paramInt != 160)) {
        RequestReportError(0, paramArrayOfByte1._sig, paramArrayOfByte1._sig_key, localt.f, localasync_context._appid, 0);
      }
    }
  }
  
  public int quickRegisterCheckAccount(long paramLong1, long paramLong2, int paramInt1, int paramInt2, byte[] paramArrayOfByte, WUserSigInfo paramWUserSigInfo)
  {
    if ((paramArrayOfByte == null) || (paramWUserSigInfo == null)) {
      return -1017;
    }
    util.LOGI("quickRegisterCheckAccount " + paramLong1 + " appid " + paramLong2, "" + paramLong1);
    Ticket localTicket = GetLocalTicket("" + paramLong1, paramLong2, 64);
    if (localTicket == null)
    {
      util.LOGI("quickRegisterCheckAccount no key", "" + paramLong1);
      return -1004;
    }
    if ((localTicket._sig == null) || (localTicket._sig.length == 0))
    {
      util.LOGI("quickRegisterCheckAccount no key", "" + paramLong1);
      return -1004;
    }
    if ((localTicket._sig_key == null) || (localTicket._sig_key.length == 0))
    {
      util.LOGI("quickRegisterCheckAccount no key", "" + paramLong1);
      return -1004;
    }
    oicq.wlogin_sdk.a.a locala = new oicq.wlogin_sdk.a.a();
    TransReqContext localTransReqContext = new TransReqContext();
    this.mRegStatus.l = localTicket._sig_key;
    Object localObject = this.mRegStatus;
    ((oicq.wlogin_sdk.a.j)localObject).g = paramLong2;
    ((oicq.wlogin_sdk.a.j)localObject).h = paramInt2;
    localTransReqContext.set_register_req();
    localTransReqContext.set_subcmd(locala.a());
    localObject = FindUserSig(paramLong1, paramLong2);
    localTransReqContext.setSTEncryptMethod();
    localTransReqContext.setWtST((WloginSigInfo)localObject);
    localTransReqContext._body = locala.a(paramLong1, (int)paramLong2, (byte)8, localTicket._sig, localTicket._sig_key, (byte)paramInt1, GetGuid(), paramInt2, t.E, paramArrayOfByte, util.generateGuid(this.mContext), util.get_IMSI(this.mContext));
    if (localTransReqContext._body == null)
    {
      util.LOGI("req_con._body is null", "" + paramLong1);
      return -1017;
    }
    return RequestTransport(0, 1, null, 0L, oicq.wlogin_sdk.a.j.i, localTransReqContext, paramWUserSigInfo);
  }
  
  public int quickRegisterGetAccount(long paramLong1, long paramLong2, int paramInt1, int paramInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, String paramString, WUserSigInfo paramWUserSigInfo)
  {
    if ((paramArrayOfByte2 == null) || (paramArrayOfByte1 == null) || (paramString == null) || (paramWUserSigInfo == null)) {
      return -1017;
    }
    if (6 > paramString.length()) {
      return -1017;
    }
    util.LOGI("quickRegisterGetAccount " + paramLong1 + " appid " + paramLong2, "" + paramLong1);
    Ticket localTicket = GetLocalTicket("" + paramLong1, paramLong2, 64);
    if (localTicket == null)
    {
      util.LOGI("quickRegisterCheckAccount " + paramLong1 + " appid " + paramLong2 + " no key", "" + paramLong1);
      return -1004;
    }
    if ((localTicket._sig == null) || (localTicket._sig.length == 0))
    {
      util.LOGI("quickRegisterCheckAccount no key", "" + paramLong1);
      return -1004;
    }
    if ((localTicket._sig_key == null) || (localTicket._sig_key.length == 0))
    {
      util.LOGI("quickRegisterCheckAccount no key", "" + paramLong1);
      return -1004;
    }
    oicq.wlogin_sdk.a.b localb = new oicq.wlogin_sdk.a.b();
    TransReqContext localTransReqContext = new TransReqContext();
    this.mRegStatus.l = localTicket._sig_key;
    Object localObject = this.mRegStatus;
    ((oicq.wlogin_sdk.a.j)localObject).g = paramLong2;
    ((oicq.wlogin_sdk.a.j)localObject).h = paramInt2;
    localTransReqContext.set_register_req();
    localTransReqContext.set_subcmd(localb.a());
    localObject = FindUserSig(paramLong1, paramLong2);
    localTransReqContext.setSTEncryptMethod();
    localTransReqContext.setWtST((WloginSigInfo)localObject);
    localTransReqContext._body = localb.a(paramLong1, (int)paramLong2, (byte)8, localTicket._sig, localTicket._sig_key, (byte)paramInt1, paramArrayOfByte2, GetGuid(), paramInt2, t.E, paramArrayOfByte1, util.generateGuid(this.mContext), util.get_IMSI(this.mContext), paramString.getBytes(), this.mRegStatus.e);
    if (localTransReqContext._body == null)
    {
      util.LOGI("req_con._body is null", "" + paramLong1);
      return -1017;
    }
    return RequestTransport(0, 1, null, 0L, oicq.wlogin_sdk.a.j.i, localTransReqContext, paramWUserSigInfo);
  }
  
  public void setBabyQFlg(boolean paramBoolean)
  {
    t.ai = paramBoolean;
  }
  
  public void setCallSource(int paramInt)
  {
    t.ah = paramInt;
  }
  
  public void setForQCall()
  {
    t.au = true;
    WtloginMsfListener.CLIENT_CLASSNAME = "com.tencent.lightalk.msf.core.auth.WtProvider";
  }
  
  public void setHasPassword(long paramLong, boolean paramBoolean)
  {
    String str = this.mG.e(paramLong);
    util.LOGI("setHasPasswd ..." + String.valueOf(str), "");
    if (str == null) {
      return;
    }
    this.mG.a(str, Long.valueOf(paramLong), paramBoolean);
    util.LOGI("setHasPasswd userAccount: " + str + ", uin: " + paramLong + " hasPassword:" + paramBoolean, "");
  }
  
  public void setMsgType(int paramInt1, int paramInt2, int paramInt3)
  {
    oicq.wlogin_sdk.devicelock.DevlockBase.a.a = paramInt1;
    oicq.wlogin_sdk.devicelock.DevlockBase.a.b = paramInt2;
    oicq.wlogin_sdk.devicelock.DevlockBase.a.c = paramInt3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.WtloginHelper
 * JD-Core Version:    0.7.0.1
 */