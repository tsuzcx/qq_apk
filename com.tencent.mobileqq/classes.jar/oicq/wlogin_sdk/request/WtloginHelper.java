package oicq.wlogin_sdk.request;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.secprotocol.ByteData;
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
import oicq.wlogin_sdk.devicelock.i;
import oicq.wlogin_sdk.listener.QimeiListener;
import oicq.wlogin_sdk.listener.ReportListener;
import oicq.wlogin_sdk.report.Reporter;
import oicq.wlogin_sdk.report.report_t2;
import oicq.wlogin_sdk.sharemem.WloginLoginInfo;
import oicq.wlogin_sdk.sharemem.WloginSigInfo;
import oicq.wlogin_sdk.sharemem.WloginSimpleInfo;
import oicq.wlogin_sdk.tlv_type.RegTLV;
import oicq.wlogin_sdk.tlv_type.tlv_t;
import oicq.wlogin_sdk.tlv_type.tlv_t104;
import oicq.wlogin_sdk.tlv_type.tlv_t105;
import oicq.wlogin_sdk.tlv_type.tlv_t106;
import oicq.wlogin_sdk.tlv_type.tlv_t10c;
import oicq.wlogin_sdk.tlv_type.tlv_t145;
import oicq.wlogin_sdk.tlv_type.tlv_t150;
import oicq.wlogin_sdk.tlv_type.tlv_t165;
import oicq.wlogin_sdk.tlv_type.tlv_t16a;
import oicq.wlogin_sdk.tlv_type.tlv_t400;
import oicq.wlogin_sdk.tlv_type.tlv_t546;
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
  static final Object __sync_top = new Object();
  static int __top;
  private boolean isForLocal = false;
  private long mAysncSeq = 0L;
  private Context mContext = null;
  private t mG = new t(null);
  private Handler mHelperHandler = initHelperHandler();
  private WtloginListener mListener = null;
  private int mMainSigMap = 16724722;
  private int mMiscBitmap = 150470524;
  private long mOpenAppid = 715019303L;
  private oicq.wlogin_sdk.a.k mRegStatus = new oicq.wlogin_sdk.a.k();
  private int mSubSigMap = 66560;
  
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
    if ((paramString != null) && (paramArrayOfByte != null) && (paramWUserSigInfo != null))
    {
      if (paramInt == 0)
      {
        new WtloginHelper.HelperThread(this, this, this.mHelperHandler, paramString, paramArrayOfByte, paramWUserSigInfo, paramArrayOfByte1, "CheckPictureAndGetSt").RunReq(2);
        return -1001;
      }
      if (paramWUserSigInfo._seqence == 0L) {
        paramWUserSigInfo._seqence = this.mAysncSeq;
      }
      t localt = this.mG.a(paramWUserSigInfo._seqence);
      paramWUserSigInfo._seqence = localt.h;
      async_context localasync_context = t.b(paramWUserSigInfo._seqence);
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("user:");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(" CheckPictureAndGetSt Seq:");
      ((StringBuilder)localObject1).append(localt.h);
      ((StringBuilder)localObject1).append(" ...");
      util.LOGI(((StringBuilder)localObject1).toString(), paramString);
      localt.g = paramString;
      localasync_context._last_err_msg = new ErrMsg();
      long l1;
      if (!util.check_uin_account(paramString).booleanValue())
      {
        l1 = localt.b(paramString);
        if (l1 == 0L)
        {
          paramInt = 0;
          break label217;
        }
      }
      else
      {
        l1 = Long.parseLong(paramString);
      }
      paramInt = 1;
      label217:
      if (paramInt == 1)
      {
        localt.f = l1;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(l1);
        ((StringBuilder)localObject1).append("");
        paramWUserSigInfo.uin = ((StringBuilder)localObject1).toString();
      }
      if ((t.an == null) || (t.an.length == 0))
      {
        oicq.wlogin_sdk.pow.b.b(localasync_context._t546.get_data());
        util.LOGI("syncCalcPow", "");
      }
      localObject1 = new n(localt);
      int j = this.mMiscBitmap;
      int k = this.mSubSigMap;
      Object localObject2 = localasync_context._sub_appid_list;
      int i = paramInt;
      j = ((n)localObject1).a(paramArrayOfByte, j, k, (long[])localObject2, paramWUserSigInfo);
      paramInt = j;
      if (j == 204) {
        paramInt = new p(localt).a(this.mMiscBitmap, this.mSubSigMap, localasync_context._sub_appid_list, paramWUserSigInfo);
      }
      long l2;
      if ((paramInt == 0) || (paramInt == 160))
      {
        if (!util.check_uin_account(paramString).booleanValue())
        {
          l1 = localt.b(paramString);
          l2 = l1;
          if (l1 == 0L) {
            break label445;
          }
        }
        else
        {
          l1 = Long.parseLong(paramString);
        }
        i = 1;
        l2 = l1;
        label445:
        if ((localasync_context._msalt == 0L) && (i == 0))
        {
          paramInt = -1003;
        }
        else
        {
          localt.f = l2;
          paramArrayOfByte = new StringBuilder();
          paramArrayOfByte.append(l2);
          paramArrayOfByte.append("");
          paramWUserSigInfo.uin = paramArrayOfByte.toString();
          if (paramInt == 160) {}
        }
      }
      else
      {
        if ((paramWUserSigInfo._reserveData != null) && (paramWUserSigInfo._reserveData.length > 3))
        {
          localt.i = util.buf_to_int32(paramWUserSigInfo._reserveData, 0);
          paramArrayOfByte = new StringBuilder();
          paramArrayOfByte.append("MSF SSO SEQ:");
          paramArrayOfByte.append(localt.i);
          util.LOGI(paramArrayOfByte.toString(), paramString);
        }
        else
        {
          localt.i = 0;
        }
        paramArrayOfByte = localt.a(l2, localasync_context._appid);
        if (paramArrayOfByte != null)
        {
          paramWUserSigInfo.get_clone(paramArrayOfByte);
          if ((localasync_context._sub_appid_list != null) && (paramArrayOfByte1 != null) && (localasync_context._sub_appid_list.length * 2 == paramArrayOfByte1.length))
          {
            paramInt = 0;
            while ((localasync_context._sub_appid_list != null) && (paramInt < localasync_context._sub_appid_list.length))
            {
              paramArrayOfByte = localt.a(l2, localasync_context._sub_appid_list[paramInt]);
              if (paramArrayOfByte != null)
              {
                i = paramInt * 2;
                paramArrayOfByte1[i] = ((byte[])paramArrayOfByte._userSt_Key.clone());
                paramArrayOfByte1[(i + 1)] = ((byte[])paramArrayOfByte._userStSig.clone());
              }
              paramInt += 1;
            }
          }
        }
        for (;;)
        {
          paramInt = 0;
          break;
          if ((paramWUserSigInfo._in_ksid != null) && (paramWUserSigInfo._in_ksid.length > 0)) {
            paramArrayOfByte = (byte[])paramWUserSigInfo._in_ksid.clone();
          } else {
            paramArrayOfByte = t.ad;
          }
          if (localasync_context._tmp_pwd_type != 0)
          {
            localObject1 = new k(localt, this.mContext);
            ((k)localObject1).g();
            paramInt = ((k)localObject1).a(localasync_context._appid, localasync_context._sub_appid, localt.f, 0, t.ag, localasync_context._tmp_pwd, null, this.mMiscBitmap, this.mSubSigMap, localasync_context._sub_appid_list, localasync_context._main_sigmap, localasync_context._sub_appid, t.z, 0, 0, 1, paramArrayOfByte, paramWUserSigInfo);
          }
          else
          {
            localObject2 = new byte[4];
            util.int64_to_buf32((byte[])localObject2, 0, System.currentTimeMillis() / 1000L + t.af);
            if (localasync_context._isSmslogin) {
              paramInt = 3;
            } else {
              paramInt = 1;
            }
            k localk = new k(localt, this.mContext);
            localk.g();
            l1 = localasync_context._appid;
            l2 = localasync_context._sub_appid;
            long l3 = localt.f;
            byte[] arrayOfByte = t.ag;
            localObject1 = localasync_context;
            paramInt = localk.a(l1, l2, l3, 0, arrayOfByte, (byte[])localObject2, ((async_context)localObject1)._tmp_pwd, paramInt, this.mMiscBitmap, this.mSubSigMap, ((async_context)localObject1)._sub_appid_list, ((async_context)localObject1)._main_sigmap, ((async_context)localObject1)._sub_appid, t.z, 0, 0, 1, paramArrayOfByte, paramWUserSigInfo);
          }
          paramArrayOfByte = localasync_context;
          i = paramInt;
          if (paramInt == 204) {
            i = new p(localt).a(this.mMiscBitmap, this.mSubSigMap, paramArrayOfByte._sub_appid_list, paramWUserSigInfo);
          }
          if ((i == 0) || (i == 160))
          {
            if (paramArrayOfByte.ifQQLoginInQim(t.aA)) {
              l1 = paramArrayOfByte._uin;
            } else {
              l1 = localt.b(paramString);
            }
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(l1);
            ((StringBuilder)localObject1).append("");
            paramWUserSigInfo.uin = ((StringBuilder)localObject1).toString();
            if (i != 160) {}
          }
          else
          {
            paramInt = i;
            break;
          }
          localObject1 = localt.a(l1, paramArrayOfByte._appid);
          if (localObject1 == null)
          {
            paramInt = -1004;
          }
          else
          {
            paramWUserSigInfo.get_clone((WloginSigInfo)localObject1);
            if ((paramArrayOfByte._sub_appid_list == null) || (paramArrayOfByte1 == null) || (paramArrayOfByte._sub_appid_list.length * 2 != paramArrayOfByte1.length)) {
              continue;
            }
            paramInt = 0;
            while ((paramArrayOfByte._sub_appid_list != null) && (paramInt < paramArrayOfByte._sub_appid_list.length))
            {
              localObject1 = localt.a(l1, paramArrayOfByte._sub_appid_list[paramInt]);
              if (localObject1 != null)
              {
                i = paramInt * 2;
                paramArrayOfByte1[i] = ((byte[])((WloginSigInfo)localObject1)._userSt_Key.clone());
                paramArrayOfByte1[(i + 1)] = ((byte[])((WloginSigInfo)localObject1)._userStSig.clone());
              }
              paramInt += 1;
            }
          }
        }
      }
      paramWUserSigInfo = GetUserSigInfoTicket(paramWUserSigInfo, 128);
      paramArrayOfByte = paramWUserSigInfo;
      if (paramWUserSigInfo == null) {
        paramArrayOfByte = new Ticket();
      }
      t.at.commit_t2(localt.f, localt.g, util.format_ret_code(paramInt), paramInt);
      if (paramInt == 0)
      {
        if ((paramArrayOfByte._sig != null) && (paramArrayOfByte._sig.length != 0)) {
          RequestReport(0, paramArrayOfByte._sig, paramArrayOfByte._sig_key, localt.f, localasync_context._appid);
        }
      }
      else
      {
        paramWUserSigInfo = paramArrayOfByte;
        RequestReportError(0, paramWUserSigInfo._sig, paramWUserSigInfo._sig_key, localt.f, localasync_context._appid, 0);
      }
      if ((localt.d != null) && (localt.d.get_bitmap() != 0))
      {
        this.mG.d = localt.d;
        RequestReportError(0, paramArrayOfByte._sig, paramArrayOfByte._sig_key, localt.f, localasync_context._appid, 1);
      }
      oicq.wlogin_sdk.report.c.a();
      t.b();
      localt.i();
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("user:");
      paramArrayOfByte.append(paramString);
      paramArrayOfByte.append(" CheckPictureAndGetSt Seq:");
      paramArrayOfByte.append(localt.h);
      paramArrayOfByte.append(" ret=");
      paramArrayOfByte.append(paramInt);
      paramString = paramArrayOfByte.toString();
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("");
      paramArrayOfByte.append(localt.f);
      util.LOGI(paramString, paramArrayOfByte.toString());
      return paramInt;
    }
    return -1017;
  }
  
  private int CheckSMSAndGetSt(String paramString, byte[] paramArrayOfByte1, WUserSigInfo paramWUserSigInfo, byte[][] paramArrayOfByte, byte[] paramArrayOfByte2, int paramInt)
  {
    if ((paramString != null) && (paramArrayOfByte1 != null) && (paramWUserSigInfo != null))
    {
      if (paramInt == 0)
      {
        new WtloginHelper.HelperThread(this, this, this.mHelperHandler, paramString, paramArrayOfByte1, paramWUserSigInfo, paramArrayOfByte, paramArrayOfByte2, "CheckSMSAndGetSt").RunReq(4);
        return -1001;
      }
      if (paramWUserSigInfo._seqence == 0L) {
        paramWUserSigInfo._seqence = this.mAysncSeq;
      }
      t localt = this.mG.a(paramWUserSigInfo._seqence);
      paramWUserSigInfo._seqence = localt.h;
      async_context localasync_context = t.b(paramWUserSigInfo._seqence);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(util.LOG_TAG_GATEWAY_LOGIN_NEW_DOV);
      localStringBuilder.append("user:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" CheckSMSAndGetSt Seq:");
      localStringBuilder.append(localt.h);
      localStringBuilder.append("_msalt");
      localStringBuilder.append(Long.toHexString(localasync_context._msalt));
      localStringBuilder.append(" ...");
      util.LOGI(localStringBuilder.toString(), paramString);
      localt.g = paramString;
      localt.f = 0L;
      localasync_context._last_err_msg = new ErrMsg();
      if ((paramWUserSigInfo._reserveData != null) && (paramWUserSigInfo._reserveData.length > 3))
      {
        localt.i = util.buf_to_int32(paramWUserSigInfo._reserveData, 0);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("MSF SSO SEQ:");
        localStringBuilder.append(localt.i);
        util.LOGI(localStringBuilder.toString(), paramString);
      }
      else
      {
        localt.i = 0;
      }
      if (isGateWay(paramWUserSigInfo)) {
        return checkSMSAndGetStForGateWay(localt, localasync_context, paramString, paramArrayOfByte1, paramWUserSigInfo, paramArrayOfByte2);
      }
      long l1;
      if (!util.check_uin_account(paramString).booleanValue())
      {
        long l2 = localt.b(paramString);
        l1 = l2;
        if (l2 == 0L)
        {
          paramArrayOfByte1 = new StringBuilder();
          paramArrayOfByte1.append("user:");
          paramArrayOfByte1.append(paramString);
          paramArrayOfByte1.append(" have not found uin record.");
          util.LOGI(paramArrayOfByte1.toString(), paramString);
          paramInt = -1003;
          break label725;
        }
      }
      else
      {
        l1 = Long.parseLong(paramString);
      }
      localt.f = l1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(l1);
      localStringBuilder.append("");
      paramWUserSigInfo.uin = localStringBuilder.toString();
      int i = new o(localt).a(paramArrayOfByte1, this.mMiscBitmap, this.mSubSigMap, localasync_context._sub_appid_list, paramWUserSigInfo, paramArrayOfByte2);
      paramArrayOfByte1 = new StringBuilder();
      paramArrayOfByte1.append(util.LOG_TAG_GATEWAY_LOGIN_NEW_DOV);
      paramArrayOfByte1.append("user:");
      paramArrayOfByte1.append(paramString);
      paramArrayOfByte1.append("ret");
      paramArrayOfByte1.append(i);
      paramArrayOfByte1.append(",uin:");
      paramArrayOfByte1.append(l1);
      paramArrayOfByte1.append("CheckSMSAndGetSt extraData:");
      if (paramArrayOfByte2 != null) {
        paramInt = paramArrayOfByte2.length;
      } else {
        paramInt = 0;
      }
      paramArrayOfByte1.append(paramInt);
      util.LOGI(paramArrayOfByte1.toString(), "");
      if (i != 0)
      {
        paramInt = i;
      }
      else
      {
        paramArrayOfByte1 = localt.a(l1, localasync_context._appid);
        if (paramArrayOfByte1 == null)
        {
          paramInt = -1004;
        }
        else
        {
          paramWUserSigInfo.get_clone(paramArrayOfByte1);
          if ((localasync_context._sub_appid_list != null) && (paramArrayOfByte != null) && (localasync_context._sub_appid_list.length * 2 == paramArrayOfByte.length))
          {
            paramInt = 0;
            while ((localasync_context._sub_appid_list != null) && (paramInt < localasync_context._sub_appid_list.length))
            {
              paramArrayOfByte1 = localt.a(l1, localasync_context._sub_appid_list[paramInt]);
              if (paramArrayOfByte1 != null)
              {
                i = paramInt * 2;
                paramArrayOfByte[i] = ((byte[])paramArrayOfByte1._userSt_Key.clone());
                paramArrayOfByte[(i + 1)] = ((byte[])paramArrayOfByte1._userStSig.clone());
              }
              paramInt += 1;
            }
          }
          paramInt = 0;
        }
      }
      label725:
      paramWUserSigInfo = GetUserSigInfoTicket(paramWUserSigInfo, 128);
      paramArrayOfByte1 = paramWUserSigInfo;
      if (paramWUserSigInfo == null) {
        paramArrayOfByte1 = new Ticket();
      }
      t.at.commit_t2(localt.f, localt.g, util.format_ret_code(paramInt), paramInt);
      if (paramInt == 0)
      {
        if ((paramArrayOfByte1._sig != null) && (paramArrayOfByte1._sig.length != 0)) {
          RequestReport(0, paramArrayOfByte1._sig, paramArrayOfByte1._sig_key, localt.f, localasync_context._appid);
        }
      }
      else {
        RequestReportError(0, paramArrayOfByte1._sig, paramArrayOfByte1._sig_key, localt.f, localasync_context._appid, 0);
      }
      if ((localt.d != null) && (localt.d.get_bitmap() != 0))
      {
        this.mG.d = localt.d;
        RequestReportError(0, paramArrayOfByte1._sig, paramArrayOfByte1._sig_key, localt.f, localasync_context._appid, 1);
      }
      t.b();
      localt.i();
      paramArrayOfByte1 = new StringBuilder();
      paramArrayOfByte1.append("user:");
      paramArrayOfByte1.append(paramString);
      paramArrayOfByte1.append(" CheckSMSAndGetSt Seq:");
      paramArrayOfByte1.append(localt.h);
      paramArrayOfByte1.append(" ret=");
      paramArrayOfByte1.append(paramInt);
      paramString = paramArrayOfByte1.toString();
      paramArrayOfByte1 = new StringBuilder();
      paramArrayOfByte1.append("");
      paramArrayOfByte1.append(localt.f);
      util.LOGI(paramString, paramArrayOfByte1.toString());
      return paramInt;
    }
    return -1017;
  }
  
  private int CheckSMSVerifyLoginAccount(long paramLong1, long paramLong2, String paramString, int paramInt1, long paramLong3, WUserSigInfo paramWUserSigInfo, int paramInt2)
  {
    int i = 0;
    oicq.wlogin_sdk.a.k.y = false;
    oicq.wlogin_sdk.a.k.z = 0L;
    if (((paramLong3 == -1L) && (paramString == null)) || (paramWUserSigInfo == null)) {
      return -1017;
    }
    if (paramInt2 == 0)
    {
      new WtloginHelper.HelperThread(this, this, this.mHelperHandler, paramLong1, paramLong2, paramString, paramInt1, paramLong3, paramWUserSigInfo, "CheckSMSVerifyLoginAccount").RunReq(12);
      return -1001;
    }
    t localt = this.mG.a(0L);
    paramWUserSigInfo._seqence = localt.h;
    this.mAysncSeq = localt.h;
    Object localObject = t.b(localt.h);
    localt.g = paramString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("user:");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" Seq:");
    localStringBuilder.append(localt.h);
    localStringBuilder.append(" CheckSMSVerifyLoginAccount ...");
    util.LOGI(localStringBuilder.toString(), paramString);
    ((async_context)localObject)._login_bitmap = paramWUserSigInfo._login_bitmap;
    ((async_context)localObject)._last_err_msg = new ErrMsg();
    paramInt1 = new x(localt).a(paramLong1, paramLong2, this.mMainSigMap, t.ad, paramString, this.mMiscBitmap, this.mSubSigMap, null, paramInt1, paramLong3, paramWUserSigInfo);
    if (paramInt1 == 208) {
      paramInt1 = i;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("user:");
    ((StringBuilder)localObject).append(localt.g);
    ((StringBuilder)localObject).append(" Seq:");
    ((StringBuilder)localObject).append(localt.h);
    ((StringBuilder)localObject).append(" CheckSMSVerifyLoginAccount ret=");
    if (paramInt1 > 0) {
      paramWUserSigInfo = Integer.toHexString(paramInt1);
    } else {
      paramWUserSigInfo = Integer.valueOf(paramInt1);
    }
    ((StringBuilder)localObject).append(paramWUserSigInfo);
    util.LOGI(((StringBuilder)localObject).toString(), paramString);
    return paramInt1;
  }
  
  private WloginSigInfo FindUserSig(long paramLong1, long paramLong2)
  {
    return this.mG.a(paramLong1, paramLong2);
  }
  
  private int GetA1WithA1(String paramString, long paramLong1, long paramLong2, int paramInt1, byte[] paramArrayOfByte1, long paramLong3, long paramLong4, long paramLong5, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, WUserSigInfo paramWUserSigInfo, WFastLoginInfo paramWFastLoginInfo, int paramInt2)
  {
    if ((paramString != null) && (paramArrayOfByte1 != null) && (paramArrayOfByte2 != null) && (paramArrayOfByte3 != null) && (paramWUserSigInfo != null) && (paramWFastLoginInfo != null))
    {
      int i = paramInt1 | 0xC0;
      if (paramInt2 == 0)
      {
        new WtloginHelper.HelperThread(this, this, this.mHelperHandler, paramString, paramLong1, paramLong2, i, paramArrayOfByte1, paramLong3, paramLong4, paramLong5, paramArrayOfByte2, paramArrayOfByte3, paramWUserSigInfo, paramWFastLoginInfo, "GetA1WithA1").RunReq(6);
        return -1001;
      }
      t localt = this.mG.a(0L);
      paramWUserSigInfo._seqence = localt.h;
      Object localObject1 = t.b(localt.h);
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("wtlogin login with GetA1WithA1:");
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append(" dwSrcAppid:");
      ((StringBuilder)localObject2).append(paramLong1);
      ((StringBuilder)localObject2).append(" dwMainSigMap:");
      ((StringBuilder)localObject2).append(i);
      ((StringBuilder)localObject2).append(" dwSubSrcAppid:");
      ((StringBuilder)localObject2).append(paramLong2);
      ((StringBuilder)localObject2).append(" dstAppName:");
      ((StringBuilder)localObject2).append(new String(paramArrayOfByte1));
      ((StringBuilder)localObject2).append(" dwDstAppid:");
      ((StringBuilder)localObject2).append(paramLong4);
      ((StringBuilder)localObject2).append(" dwSubDstAppid:");
      ((StringBuilder)localObject2).append(paramLong5);
      ((StringBuilder)localObject2).append(" Seq:");
      ((StringBuilder)localObject2).append(localt.h);
      ((StringBuilder)localObject2).append(" ...");
      util.LOGI(((StringBuilder)localObject2).toString(), paramString);
      paramInt1 = util.get_saved_network_type(this.mContext);
      t.E = util.get_network_type(this.mContext);
      if (paramInt1 != t.E)
      {
        util.set_net_retry_type(this.mContext, 0);
        util.save_network_type(this.mContext, t.E);
      }
      t.G = util.get_apn_string(this.mContext).getBytes();
      localt.g = paramString;
      localt.f = 0L;
      ((async_context)localObject1)._sappid = paramLong1;
      ((async_context)localObject1)._appid = paramLong1;
      ((async_context)localObject1)._sub_appid = paramLong2;
      ((async_context)localObject1)._main_sigmap = i;
      ((async_context)localObject1)._last_err_msg = new ErrMsg();
      t.at.add_t2(new report_t2("login", new String(t.D), System.currentTimeMillis(), paramLong4, paramLong5, null));
      long l1;
      if (!util.check_uin_account(paramString).booleanValue())
      {
        long l2 = localt.b(paramString);
        l1 = l2;
        if (l2 == 0L)
        {
          paramArrayOfByte2 = new StringBuilder();
          paramArrayOfByte2.append("user:");
          paramArrayOfByte2.append(paramString);
          paramArrayOfByte2.append(" have not found uin record.");
          util.LOGI(paramArrayOfByte2.toString(), paramString);
          paramInt1 = -1003;
          break label756;
        }
      }
      else
      {
        l1 = Long.parseLong(paramString);
      }
      localt.f = l1;
      localt.k();
      localObject2 = getA1AndNopicSigByAccount(paramString, paramLong1);
      localObject1 = ((WtloginHelper.A1AndNopicSig)localObject2).a1;
      localObject2 = ((WtloginHelper.A1AndNopicSig)localObject2).noPicSig;
      if ((localObject1 != null) && (localObject1.length > 0))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("user:");
        localStringBuilder.append(paramString);
        localStringBuilder.append(" login with A1 exchange A1.");
        util.LOGI(localStringBuilder.toString(), paramString);
        paramInt1 = new l(localt).a(l1, paramLong1, paramLong2, 1, i, (byte[])localObject1, (byte[])localObject2, this.mMiscBitmap, this.mSubSigMap, null, paramArrayOfByte1, paramLong3, paramLong4, paramLong5, paramArrayOfByte2, paramArrayOfByte3, paramWUserSigInfo);
        if (paramInt1 == 0)
        {
          paramArrayOfByte2 = localt.a(l1, paramLong1);
          if (paramArrayOfByte2 == null)
          {
            paramInt1 = -1004;
          }
          else
          {
            paramWUserSigInfo.get_clone(paramArrayOfByte2);
            paramWFastLoginInfo.get_clone(localt.j);
          }
        }
      }
      else
      {
        paramArrayOfByte2 = new StringBuilder();
        paramArrayOfByte2.append("user:");
        paramArrayOfByte2.append(paramString);
        paramArrayOfByte2.append(" have no a1 or pic_sig.");
        util.LOGI(paramArrayOfByte2.toString(), paramString);
        paramInt1 = -1016;
      }
      label756:
      paramArrayOfByte3 = GetUserSigInfoTicket(paramWUserSigInfo, 128);
      paramArrayOfByte2 = paramArrayOfByte3;
      if (paramArrayOfByte3 == null) {
        paramArrayOfByte2 = new Ticket();
      }
      t.at.commit_t2(localt.f, localt.g, util.format_ret_code(paramInt1), paramInt1);
      if (paramInt1 == 0)
      {
        if ((paramArrayOfByte2._sig != null) && (paramArrayOfByte2._sig.length != 0)) {
          RequestReport(0, paramArrayOfByte2._sig, paramArrayOfByte2._sig_key, localt.f, paramLong1);
        }
      }
      else {
        RequestReportError(0, paramArrayOfByte2._sig, paramArrayOfByte2._sig_key, localt.f, paramLong1, 0);
      }
      paramArrayOfByte3 = paramArrayOfByte2;
      paramArrayOfByte2 = localt;
      if ((paramArrayOfByte2.d != null) && (paramArrayOfByte2.d.get_bitmap() != 0))
      {
        this.mG.d = paramArrayOfByte2.d;
        RequestReportError(0, paramArrayOfByte3._sig, paramArrayOfByte3._sig_key, paramArrayOfByte2.f, paramLong1, 1);
      }
      t.b();
      paramArrayOfByte2.i();
      paramArrayOfByte3 = new StringBuilder();
      paramArrayOfByte3.append("wtlogin login with GetA1WithA1:");
      paramArrayOfByte3.append(paramString);
      paramArrayOfByte3.append(" dwSrcAppid:");
      paramArrayOfByte3.append(paramLong1);
      paramArrayOfByte3.append(" dwMainSigMap:");
      paramArrayOfByte3.append(i);
      paramArrayOfByte3.append(" dwSubSrcAppid:");
      paramArrayOfByte3.append(paramLong2);
      paramArrayOfByte3.append(" dstAppName:");
      paramArrayOfByte3.append(new String(paramArrayOfByte1));
      paramArrayOfByte3.append(" dwDstAppid:");
      paramArrayOfByte3.append(paramLong4);
      paramArrayOfByte3.append(" dwSubDstAppid:");
      paramArrayOfByte3.append(paramLong5);
      paramArrayOfByte3.append(" Seq:");
      paramArrayOfByte3.append(paramArrayOfByte2.h);
      paramArrayOfByte3.append(" ret=");
      paramArrayOfByte3.append(paramInt1);
      util.LOGI(paramArrayOfByte3.toString(), paramString);
      return paramInt1;
    }
    return -1017;
  }
  
  private int GetFastLoginInfo(byte[] paramArrayOfByte, async_context paramasync_context)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 3))
    {
      if (paramasync_context == null) {
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
        localObject = t.B;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("new guid:");
        localStringBuilder.append(util.buf_to_string(paramArrayOfByte));
        localStringBuilder.append(" old guid:");
        localStringBuilder.append(util.buf_to_string((byte[])localObject));
        util.LOGD(localStringBuilder.toString());
        if (!Arrays.equals(paramArrayOfByte, (byte[])localObject))
        {
          util.LOGI("fast login info guid not equal", "");
          util.saveGuidToFile(t.u, paramArrayOfByte);
          t.B = (byte[])paramArrayOfByte.clone();
          t.C = (byte[])paramArrayOfByte.clone();
        }
      }
      paramasync_context._tmp_pwd = oicq_request.b(localtlv_t106.get_data(), localtlv_t10c.get_data());
      paramasync_context._tmp_no_pic_sig = localtlv_t16a.get_data();
      return 0;
    }
    return -1017;
  }
  
  public static WFastLoginInfo GetFastLoginUrl(String paramString, long paramLong)
  {
    if (paramString != null) {}
    try
    {
      if (paramString.length() == 0) {
        return null;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("packageName:");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" uin:");
      ((StringBuilder)localObject).append(paramLong);
      util.LOGI(((StringBuilder)localObject).toString(), "");
      if (paramLong == 1689053018L)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("https://imgcache.qq.com/wtlogin");
        ((StringBuilder)localObject).append("/test");
        localObject = ((StringBuilder)localObject).toString();
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("https://imgcache.qq.com/wtlogin");
        ((StringBuilder)localObject).append("/app");
        localObject = ((StringBuilder)localObject).toString();
      }
      paramString = paramString.split("\\.");
      int i = 0;
      while (i < paramString.length)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject);
        localStringBuilder.append("/");
        localObject = localStringBuilder.toString();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(paramString[i]);
        localObject = localStringBuilder.toString();
        i += 1;
      }
      paramString = new WFastLoginInfo();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("/icon.png");
      paramString.iconUrl = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("/ad_img.png");
      paramString.adUrl = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("/profile.js");
      paramString.profileUrl = localStringBuilder.toString();
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
    return null;
  }
  
  private int GetStWithPasswd(String paramString1, long paramLong1, int paramInt1, long paramLong2, long[] paramArrayOfLong, boolean paramBoolean1, String paramString2, WUserSigInfo paramWUserSigInfo, byte[][] paramArrayOfByte, boolean paramBoolean2, int paramInt2)
  {
    int j;
    int i;
    Object localObject1;
    Object localObject2;
    WtloginHelper localWtloginHelper;
    Object localObject3;
    StringBuilder localStringBuilder;
    long l1;
    long l2;
    if ((paramString1 != null) && (paramWUserSigInfo != null))
    {
      j = paramInt1 | 0xC0;
      i = this.mMiscBitmap;
      paramInt1 = i;
      if (t.ac) {
        paramInt1 = i | 0x2000000;
      }
      if (paramInt2 == 0)
      {
        new WtloginHelper.HelperThread(this, this, this.mHelperHandler, paramString1, paramLong1, j, paramLong2, paramArrayOfLong, paramBoolean1, paramString2, paramWUserSigInfo, paramArrayOfByte, paramBoolean2, "GetStWithPasswd").RunReq(0);
        return -1001;
      }
      if ((paramBoolean2) && (!oicq.wlogin_sdk.a.k.y))
      {
        if (paramWUserSigInfo._seqence == 0L) {
          paramWUserSigInfo._seqence = this.mAysncSeq;
        }
        localObject1 = this.mG.a(paramWUserSigInfo._seqence);
        paramWUserSigInfo._seqence = ((t)localObject1).h;
      }
      else
      {
        localObject1 = this;
        localObject2 = ((WtloginHelper)localObject1).mG.a(0L);
        paramWUserSigInfo._seqence = ((t)localObject2).h;
        ((WtloginHelper)localObject1).mAysncSeq = ((t)localObject2).h;
        localObject1 = localObject2;
      }
      paramInt2 = paramInt1;
      localWtloginHelper = this;
      localObject2 = t.b(((t)localObject1).h);
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("start GetStWithPasswd:user:");
      ((StringBuilder)localObject3).append(paramString1);
      ((StringBuilder)localObject3).append(" dwAppid:");
      ((StringBuilder)localObject3).append(paramLong1);
      ((StringBuilder)localObject3).append(" dwMainSigMap:0x");
      ((StringBuilder)localObject3).append(Integer.toHexString(j));
      ((StringBuilder)localObject3).append(" dwSubAppid:");
      ((StringBuilder)localObject3).append(paramLong2);
      ((StringBuilder)localObject3).append(" Seq:");
      ((StringBuilder)localObject3).append(((t)localObject1).h);
      ((StringBuilder)localObject3).append(" ...");
      util.LOGI(((StringBuilder)localObject3).toString(), paramString1);
      localStringBuilder = new StringBuilder("GetStWithPasswd");
      ((async_context)localObject2)._isSmslogin = paramBoolean2;
      if ((paramBoolean2) && (paramString2.length() == 0)) {
        paramString2 = ((async_context)localObject2)._mpasswd;
      }
      oicq.wlogin_sdk.a.k.y = false;
      oicq.wlogin_sdk.a.k.A = "";
      localObject3 = paramString2;
      if (paramString2 != null)
      {
        localObject3 = paramString2;
        if (paramString2.length() > 16) {
          localObject3 = paramString2.substring(0, 16);
        }
      }
      paramInt1 = util.get_saved_network_type(localWtloginHelper.mContext);
      t.E = util.get_network_type(localWtloginHelper.mContext);
      if (paramInt1 != t.E)
      {
        util.set_net_retry_type(localWtloginHelper.mContext, 0);
        util.save_network_type(localWtloginHelper.mContext, t.E);
      }
      t.G = util.get_apn_string(localWtloginHelper.mContext).getBytes();
      ((t)localObject1).g = paramString1;
      ((t)localObject1).f = 0L;
      ((async_context)localObject2)._sappid = paramLong1;
      ((async_context)localObject2)._appid = paramLong1;
      ((async_context)localObject2)._sub_appid_list = null;
      ((async_context)localObject2)._sub_appid = paramLong2;
      ((async_context)localObject2)._main_sigmap = j;
      ((async_context)localObject2)._login_bitmap = paramWUserSigInfo._login_bitmap;
      ((async_context)localObject2)._last_err_msg = new ErrMsg();
      if (paramArrayOfLong != null) {
        ((async_context)localObject2)._sub_appid_list = ((long[])paramArrayOfLong.clone());
      }
      if ((paramWUserSigInfo._reserveData != null) && (paramWUserSigInfo._reserveData.length > 3))
      {
        ((t)localObject1).i = util.buf_to_int32(paramWUserSigInfo._reserveData, 0);
        paramString2 = new StringBuilder();
        paramString2.append("MSF SSO SEQ:");
        paramString2.append(((t)localObject1).i);
        util.LOGI(paramString2.toString(), paramString1);
      }
      else
      {
        ((t)localObject1).i = 0;
      }
      t.at.add_t2(new report_t2("login", new String(t.D), System.currentTimeMillis(), paramLong1, paramLong2, paramArrayOfLong));
      if (!util.check_uin_account(paramString1).booleanValue())
      {
        if (((async_context)localObject2).ifQQLoginInQim(t.aA))
        {
          localStringBuilder.append(",ifQQLoginInQim found = 0");
          l1 = 0L;
          paramInt1 = 0;
          break label779;
        }
        if ((!localWtloginHelper.isGateWay(paramWUserSigInfo)) && (paramWUserSigInfo.businessType != 3))
        {
          l2 = ((t)localObject1).b(paramString1);
          l1 = l2;
          if (l2 != 0L) {
            break label776;
          }
          l1 = l2;
        }
        else
        {
          localStringBuilder.append(",isGateWay found = 0");
          l1 = 0L;
        }
        paramInt1 = 0;
        break label779;
      }
      else
      {
        l1 = Long.parseLong(paramString1);
      }
      label776:
      paramInt1 = 1;
      label779:
      if ((localObject3 != null) && (((String)localObject3).length() > 0) && (!paramBoolean1)) {}
    }
    try
    {
      ((async_context)localObject2)._tmp_pwd = ((byte[])((String)localObject3).getBytes("ISO-8859-1").clone());
    }
    catch (Exception paramArrayOfLong)
    {
      label819:
      break label819;
    }
    paramInt1 = -1013;
    break label897;
    ((async_context)localObject2)._tmp_pwd = MD5.toMD5Byte((String)localObject3);
    ((async_context)localObject2)._tmp_pwd_type = 0;
    break label1041;
    if ((paramWUserSigInfo._fastLoginBuf != null) && (paramWUserSigInfo._fastLoginBuf.length > 0))
    {
      util.LOGI("GetFastLoginInfo ...", paramString1);
      if (localWtloginHelper.GetFastLoginInfo(paramWUserSigInfo._fastLoginBuf, (async_context)localObject2) < 0)
      {
        util.LOGI("GetFastLoginInfo failed", paramString1);
        paramInt1 = -1017;
      }
    }
    label897:
    label1041:
    for (;;)
    {
      break;
      if (paramString1.matches("([0-9]{5,10})@qq\\.com"))
      {
        l1 = Long.valueOf(paramString1.replaceAll("([0-9]{5,10})@qq\\.com", "$1")).longValue();
        ((t)localObject1).a(paramString1, Long.valueOf(l1));
        paramInt1 = 1;
        break label1013;
        if ((oicq.wlogin_sdk.code2d.d.q != null) && (oicq.wlogin_sdk.code2d.d.q.length > 0))
        {
          ((async_context)localObject2)._tmp_pwd = oicq.wlogin_sdk.code2d.d.q;
          ((async_context)localObject2)._tmp_no_pic_sig = oicq.wlogin_sdk.code2d.d.r;
          oicq.wlogin_sdk.code2d.d.q = null;
          oicq.wlogin_sdk.code2d.d.r = null;
        }
        else
        {
          paramString2 = getA1AndNopicSigByAccount(paramString1, paramLong1);
          ((async_context)localObject2)._tmp_pwd = paramString2.a1;
          ((async_context)localObject2)._tmp_no_pic_sig = paramString2.noPicSig;
        }
      }
      label1013:
      if ((((async_context)localObject2)._tmp_pwd != null) && (((async_context)localObject2)._tmp_pwd.length >= 16))
      {
        ((async_context)localObject2)._tmp_pwd_type = 1;
        if (paramInt1 == 0)
        {
          if (paramString1.length() > util.MAX_NAME_LEN)
          {
            paramInt1 = -1008;
            continue;
          }
          paramInt1 = new s((t)localObject1).a(paramLong1, paramLong2, 1, j, paramString1.getBytes(), t.z, 0, 0, 1, paramInt2, localWtloginHelper.mSubSigMap, paramArrayOfLong, paramWUserSigInfo);
          if (paramInt1 != 0) {
            continue;
          }
          if (((async_context)localObject2)._msalt != 0L)
          {
            localStringBuilder.append(",Name2Salt uin = 0");
            l1 = 0L;
          }
          else
          {
            if (((async_context)localObject2).ifQQLoginInQim(t.aA)) {
              l1 = ((async_context)localObject2)._uin;
            } else {
              l1 = ((t)localObject1).b(paramString1);
            }
            if (l1 == 0L)
            {
              paramInt1 = -1003;
              continue;
            }
            localStringBuilder.append(",Name2Uin uin =");
            localStringBuilder.append(l1);
          }
        }
        if (oicq.wlogin_sdk.a.k.z != 0L)
        {
          ((async_context)localObject2)._msalt = oicq.wlogin_sdk.a.k.z;
          oicq.wlogin_sdk.a.k.z = 0L;
        }
        ((t)localObject1).f = l1;
        paramString2 = new StringBuilder();
        localObject3 = "";
        paramString2.append((String)localObject3);
        paramString2.append(l1);
        paramWUserSigInfo.uin = paramString2.toString();
        localStringBuilder.append(",thisG uin =");
        localStringBuilder.append(l1);
        if ((paramWUserSigInfo._in_ksid != null) && (paramWUserSigInfo._in_ksid.length > 0)) {
          paramString2 = (byte[])paramWUserSigInfo._in_ksid.clone();
        } else {
          paramString2 = t.ad;
        }
        Object localObject4;
        Object localObject5;
        if (((async_context)localObject2)._tmp_pwd_type != 0)
        {
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("user:");
          ((StringBuilder)localObject4).append(paramString1);
          ((StringBuilder)localObject4).append(" login with saved A1.");
          localObject4 = ((StringBuilder)localObject4).toString();
          localObject5 = new StringBuilder();
          ((StringBuilder)localObject5).append((String)localObject3);
          ((StringBuilder)localObject5).append(((t)localObject1).f);
          util.LOGI((String)localObject4, ((StringBuilder)localObject5).toString());
          localObject4 = new k((t)localObject1, localWtloginHelper.mContext);
          ((k)localObject4).g();
          paramInt1 = ((k)localObject4).a(paramLong1, paramLong2, ((t)localObject1).f, 0, t.ag, ((async_context)localObject2)._tmp_pwd, ((async_context)localObject2)._tmp_no_pic_sig, paramInt2, localWtloginHelper.mSubSigMap, paramArrayOfLong, j, paramLong2, t.z, 0, 0, 1, paramString2, paramWUserSigInfo);
        }
        else
        {
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("user:");
          ((StringBuilder)localObject4).append(paramString1);
          ((StringBuilder)localObject4).append(" login with input password.");
          localObject4 = ((StringBuilder)localObject4).toString();
          localObject5 = new StringBuilder();
          ((StringBuilder)localObject5).append((String)localObject3);
          ((StringBuilder)localObject5).append(((t)localObject1).f);
          util.LOGI((String)localObject4, ((StringBuilder)localObject5).toString());
          localObject4 = new byte[4];
          util.int64_to_buf32((byte[])localObject4, 0, System.currentTimeMillis() / 1000L + t.af);
          if (paramBoolean2) {
            paramInt1 = 3;
          } else {
            paramInt1 = 1;
          }
          localObject5 = new k((t)localObject1, localWtloginHelper.mContext);
          ((k)localObject5).g();
          paramInt1 = ((k)localObject5).a(paramLong1, paramLong2, ((t)localObject1).f, 0, t.ag, (byte[])localObject4, ((async_context)localObject2)._tmp_pwd, paramInt1, paramInt2, localWtloginHelper.mSubSigMap, paramArrayOfLong, j, paramLong2, t.z, 0, 0, 1, paramString2, paramWUserSigInfo);
        }
        if (paramInt1 == 204) {
          paramInt1 = new p((t)localObject1).a(paramInt2, localWtloginHelper.mSubSigMap, paramArrayOfLong, paramWUserSigInfo);
        }
        if ((paramInt1 == 0) || (paramInt1 == 160))
        {
          do
          {
            do
            {
              if (l1 == 0L)
              {
                l1 = ((async_context)localObject2)._uin;
                ((t)localObject1).f = l1;
                paramString2 = new StringBuilder();
                paramString2.append((String)localObject3);
                paramString2.append(l1);
                paramWUserSigInfo.uin = paramString2.toString();
                localStringBuilder.append(",uin == 0 reset ");
                localStringBuilder.append(l1);
              }
            } while (paramInt1 == 160);
            util.LOGI(localStringBuilder.toString());
            paramString2 = ((t)localObject1).a(l1, paramLong1);
            if (paramString2 == null)
            {
              paramArrayOfLong = new StringBuilder();
              paramArrayOfLong.append("get_siginfo failed, AppID: ");
              paramArrayOfLong.append(paramLong1);
              paramArrayOfLong = paramArrayOfLong.toString();
              paramString2 = new StringBuilder();
              paramString2.append((String)localObject3);
              paramString2.append(((t)localObject1).f);
              util.LOGI(paramArrayOfLong, paramString2.toString());
              paramInt1 = -1004;
              break;
            }
            paramWUserSigInfo.get_clone(paramString2);
          } while ((paramArrayOfLong == null) || (paramArrayOfByte == null));
          if (paramArrayOfLong.length * 2 == paramArrayOfByte.length)
          {
            paramInt2 = 0;
            while ((paramArrayOfLong != null) && (paramInt2 < paramArrayOfLong.length))
            {
              paramString2 = ((t)localObject1).a(l1, paramArrayOfLong[paramInt2]);
              if (paramString2 != null)
              {
                i = paramInt2 * 2;
                paramArrayOfByte[i] = ((byte[])paramString2._userSt_Key.clone());
                paramArrayOfByte[(i + 1)] = ((byte[])paramString2._userStSig.clone());
              }
              paramInt2 += 1;
            }
          }
        }
      }
      else
      {
        paramInt1 = -1016;
      }
    }
    paramArrayOfLong = GetUserSigInfoTicket(paramWUserSigInfo, 128);
    paramWUserSigInfo = paramArrayOfLong;
    if (paramArrayOfLong == null) {
      paramWUserSigInfo = new Ticket();
    }
    t.at.commit_t2(((t)localObject1).f, ((t)localObject1).g, util.format_ret_code(paramInt1), paramInt1);
    if (paramInt1 == 0)
    {
      if ((paramWUserSigInfo._sig != null) && (paramWUserSigInfo._sig.length != 0))
      {
        RequestReport(0, paramWUserSigInfo._sig, paramWUserSigInfo._sig_key, ((t)localObject1).f, ((async_context)localObject2)._appid);
      }
      else
      {
        paramString2 = (String)localObject2;
        paramArrayOfLong = (long[])localObject1;
        break label2224;
      }
    }
    else
    {
      paramArrayOfLong = (long[])localObject1;
      if ((paramInt1 != 2) && (paramInt1 != 160))
      {
        paramArrayOfByte = paramWUserSigInfo._sig;
        localObject1 = paramWUserSigInfo._sig_key;
        l1 = paramArrayOfLong.f;
        paramString2 = (String)localObject2;
        l2 = paramString2._appid;
        RequestReportError(0, paramArrayOfByte, (byte[])localObject1, l1, l2, 0);
        break label2224;
      }
    }
    paramString2 = (String)localObject2;
    paramArrayOfLong = (long[])localObject1;
    label2224:
    if ((paramArrayOfLong.d != null) && (paramArrayOfLong.d.get_bitmap() != 0))
    {
      this.mG.d = paramArrayOfLong.d;
      RequestReportError(0, paramWUserSigInfo._sig, paramWUserSigInfo._sig_key, paramArrayOfLong.f, paramString2._appid, 1);
    }
    oicq.wlogin_sdk.report.c.a();
    t.b();
    paramArrayOfLong.i();
    paramString2 = new StringBuilder();
    paramString2.append("end GetStWithPasswd:user:");
    paramString2.append(paramString1);
    paramString2.append(" dwAppid:");
    paramString2.append(paramLong1);
    paramString2.append(" dwMainSigMap:0x");
    paramString2.append(Integer.toHexString(j));
    paramString2.append(" dwSubAppid:");
    paramString2.append(paramLong2);
    paramString2.append(" Seq:");
    paramString2.append(paramArrayOfLong.h);
    paramString2.append(" ret=");
    paramString2.append(paramInt1);
    paramString1 = paramString2.toString();
    paramString2 = new StringBuilder();
    paramString2.append("");
    paramString2.append(paramArrayOfLong.f);
    util.LOGI(paramString1, paramString2.toString());
    return paramInt1;
    return -1017;
  }
  
  private int GetStWithoutPasswd(String paramString, long paramLong1, long paramLong2, long paramLong3, int paramInt1, long paramLong4, long[] paramArrayOfLong, WUserSigInfo paramWUserSigInfo, byte[][] paramArrayOfByte1, byte[][] paramArrayOfByte2, int paramInt2, WtTicketPromise paramWtTicketPromise)
  {
    if ((paramString != null) && (paramWUserSigInfo != null))
    {
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
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("start GetStWithoutPasswd: dwSrcAppid:");
      ((StringBuilder)localObject1).append(paramLong1);
      ((StringBuilder)localObject1).append(" dwDstAppid:");
      ((StringBuilder)localObject1).append(paramLong2);
      ((StringBuilder)localObject1).append(" dwDstAppPri:");
      ((StringBuilder)localObject1).append(paramLong3);
      ((StringBuilder)localObject1).append(" dwMainSigMap:0x");
      ((StringBuilder)localObject1).append(Integer.toHexString(i));
      ((StringBuilder)localObject1).append(" dwSubDstAppid:");
      ((StringBuilder)localObject1).append(paramLong4);
      ((StringBuilder)localObject1).append(" Seq:");
      ((StringBuilder)localObject1).append(localt.h);
      ((StringBuilder)localObject1).append("|");
      if (paramWtTicketPromise != null) {
        paramWtTicketPromise = "1";
      } else {
        paramWtTicketPromise = "0";
      }
      ((StringBuilder)localObject1).append(paramWtTicketPromise);
      ((StringBuilder)localObject1).append(" at ");
      ((StringBuilder)localObject1).append(t.m());
      util.LOGI(((StringBuilder)localObject1).toString(), paramString);
      paramInt1 = util.get_saved_network_type(this.mContext);
      t.E = util.get_network_type(this.mContext);
      if (paramInt1 != t.E)
      {
        util.set_net_retry_type(this.mContext, 0);
        util.save_network_type(this.mContext, t.E);
      }
      t.G = util.get_apn_string(this.mContext).getBytes();
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
      if ((paramWUserSigInfo._reserveData != null) && (paramWUserSigInfo._reserveData.length > 3))
      {
        localt.i = util.buf_to_int32(paramWUserSigInfo._reserveData, 0);
        paramWtTicketPromise = new StringBuilder();
        paramWtTicketPromise.append("MSF SSO SEQ:");
        paramWtTicketPromise.append(localt.i);
        util.LOGI(paramWtTicketPromise.toString(), paramString);
      }
      else
      {
        localt.i = 0;
      }
      localObject1 = t.at;
      Object localObject2 = new String(t.D);
      long l1 = System.currentTimeMillis();
      paramWtTicketPromise = localasync_context;
      ((Reporter)localObject1).add_t2(new report_t2("exchg", (String)localObject2, l1, paramLong2, paramLong4, paramArrayOfLong));
      long l2;
      if (!util.check_uin_account(paramString).booleanValue())
      {
        l2 = localt.b(paramString);
        l1 = l2;
        if (l2 == 0L)
        {
          paramArrayOfLong = new StringBuilder();
          paramArrayOfLong.append("user:");
          paramArrayOfLong.append(paramString);
          paramArrayOfLong.append(" have not found uin record.");
          util.LOGI(paramArrayOfLong.toString(), paramString);
          paramInt1 = -1003;
          break label1887;
        }
      }
      else
      {
        l1 = Long.parseLong(paramString);
      }
      localt.f = l1;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("");
      ((StringBuilder)localObject1).append(l1);
      paramWUserSigInfo.uin = ((StringBuilder)localObject1).toString();
      if ((paramArrayOfByte2 != null) && (paramArrayOfByte2.length == 4) && (paramArrayOfByte2[0] != null) && (paramArrayOfByte2[0].length == 1) && (paramArrayOfByte2[0][0] == 1))
      {
        paramWtTicketPromise = new StringBuilder();
        paramWtTicketPromise.append("user:");
        paramWtTicketPromise.append(paramString);
        paramWtTicketPromise.append(" exchange A2 from A2/D2/KEY.");
        paramWtTicketPromise = paramWtTicketPromise.toString();
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("");
        ((StringBuilder)localObject1).append(localt.f);
        util.LOGI(paramWtTicketPromise, ((StringBuilder)localObject1).toString());
        if ((paramArrayOfByte2[1] != null) && (paramArrayOfByte2[1].length != 0) && (paramArrayOfByte2[2] != null) && (paramArrayOfByte2[2].length != 0) && (paramArrayOfByte2[3] != null) && (paramArrayOfByte2[3].length != 0))
        {
          localt.b = MD5.toMD5Byte(paramArrayOfByte2[3]);
          paramInt1 = new m(localt).a(l1, paramLong2, paramLong4, 1, i, paramArrayOfByte2[1], this.mMiscBitmap, this.mSubSigMap, paramArrayOfLong, paramArrayOfByte2[2], paramWUserSigInfo);
          paramArrayOfByte2 = paramArrayOfLong;
        }
        else
        {
          break label1882;
        }
      }
      else
      {
        if ((paramArrayOfByte2 != null) && (paramArrayOfByte2.length == 3)) {
          if ((paramArrayOfByte2[0] != null) && (paramArrayOfByte2[0].length == 1) && (paramArrayOfByte2[0][0] == 2))
          {
            paramWtTicketPromise = new StringBuilder();
            paramWtTicketPromise.append("user:");
            paramWtTicketPromise.append(paramString);
            paramWtTicketPromise.append(" exchange A2 from A2/A2KEY.");
            paramWtTicketPromise = paramWtTicketPromise.toString();
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("");
            ((StringBuilder)localObject1).append(localt.f);
            util.LOGI(paramWtTicketPromise, ((StringBuilder)localObject1).toString());
            if ((paramArrayOfByte2[1] != null) && (paramArrayOfByte2[1].length != 0) && (paramArrayOfByte2[2] != null) && (paramArrayOfByte2[2].length != 0))
            {
              localt.b = paramArrayOfByte2[2];
              paramInt1 = new m(localt).a(l1, paramLong2, paramLong4, 1, i, paramArrayOfByte2[1], this.mMiscBitmap, this.mSubSigMap, paramArrayOfLong, null, paramWUserSigInfo);
              paramArrayOfByte2 = paramArrayOfLong;
              break label1741;
            }
          }
        }
        do
        {
          break label1882;
          localt.k();
          paramArrayOfByte2 = getA1AndNopicSigByAccount(String.valueOf(localt.f), paramLong1);
          localObject1 = paramArrayOfByte2.a1;
          localObject2 = paramArrayOfByte2.noPicSig;
          if ((localObject1 != null) && (localObject1.length > 0) && (localObject2 != null) && (localObject2.length > 0))
          {
            paramArrayOfByte2 = new StringBuilder();
            paramArrayOfByte2.append("user:");
            paramArrayOfByte2.append(paramString);
            paramArrayOfByte2.append(" exchange A2 from A1.");
            paramArrayOfByte2 = paramArrayOfByte2.toString();
            Object localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("");
            ((StringBuilder)localObject3).append(localt.f);
            util.LOGI(paramArrayOfByte2, ((StringBuilder)localObject3).toString());
            paramWtTicketPromise._tmp_pwd = ((byte[])localObject1);
            paramWtTicketPromise._tmp_no_pic_sig = ((byte[])localObject2);
            if ((paramWUserSigInfo._in_ksid != null) && (paramWUserSigInfo._in_ksid.length > 0)) {
              paramArrayOfByte2 = (byte[])paramWUserSigInfo._in_ksid.clone();
            } else {
              paramArrayOfByte2 = t.ad;
            }
            paramWtTicketPromise = new aa(localt, this.mContext);
            localObject3 = FindUserSig(l1, paramLong1);
            if (localObject3 != null) {
              paramWtTicketPromise.a((WloginSigInfo)localObject3);
            }
            paramInt2 = this.mMiscBitmap;
            paramInt1 = paramInt2;
            if (t.ac) {
              paramInt1 = paramInt2 | 0x2000000;
            }
            paramInt1 = paramWtTicketPromise.a(paramLong2, 1, localt.f, 0, t.ag, (byte[])localObject1, (byte[])localObject2, paramInt1, this.mSubSigMap, paramArrayOfLong, i, paramLong4, 1, t.z, 0, 0, 1, paramArrayOfByte2, paramLong1, paramWUserSigInfo);
            if (paramInt1 == 204) {
              paramInt1 = new p(localt).a(this.mMiscBitmap, this.mSubSigMap, paramArrayOfLong, paramWUserSigInfo);
            }
            paramArrayOfByte2 = paramArrayOfLong;
            break;
          }
          l2 = l1;
          paramArrayOfByte2 = new StringBuilder();
          paramArrayOfByte2.append("user:");
          paramArrayOfByte2.append(paramString);
          paramArrayOfByte2.append(" exchange A2 from A2.");
          paramArrayOfByte2 = paramArrayOfByte2.toString();
          paramWtTicketPromise = new StringBuilder();
          paramWtTicketPromise.append("");
          paramWtTicketPromise.append(localt.f);
          util.LOGI(paramArrayOfByte2, paramWtTicketPromise.toString());
          paramArrayOfByte2 = localt.a(l2, paramLong1);
        } while ((paramArrayOfByte2 == null) || (paramArrayOfByte2._TGT == null) || (paramArrayOfByte2._TGT.length == 0) || (paramArrayOfByte2.iSExpireA2(t.f())));
        paramWtTicketPromise = new StringBuilder();
        paramWtTicketPromise.append("user:");
        paramWtTicketPromise.append(paramString);
        paramWtTicketPromise.append(" exchange A2 from A2 without Priority.");
        paramWtTicketPromise = paramWtTicketPromise.toString();
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("");
        ((StringBuilder)localObject1).append(localt.f);
        util.LOGI(paramWtTicketPromise, ((StringBuilder)localObject1).toString());
        printTicket(paramArrayOfByte2);
        localt.b = paramArrayOfByte2._TGTKey;
        paramWtTicketPromise = new m(localt);
        localObject1 = paramArrayOfByte2._TGT;
        paramInt1 = this.mMiscBitmap;
        paramInt2 = this.mSubSigMap;
        paramArrayOfByte2 = paramArrayOfLong;
        paramInt1 = paramWtTicketPromise.a(l2, paramLong2, paramLong4, 1, i, (byte[])localObject1, paramInt1, paramInt2, paramArrayOfLong, null, paramWUserSigInfo);
      }
      label1741:
      if (paramInt1 == 0)
      {
        paramWtTicketPromise = localt.a(l1, paramLong2);
        if (paramWtTicketPromise == null) {
          break label1882;
        }
        paramWUserSigInfo.get_clone(paramWtTicketPromise);
        if ((paramArrayOfByte2 != null) && (paramArrayOfByte1 != null) && (paramArrayOfByte2.length * 2 == paramArrayOfByte1.length))
        {
          paramInt2 = 0;
          while (paramInt2 < paramArrayOfByte2.length)
          {
            paramArrayOfByte2 = localt.a(l1, paramArrayOfByte2[paramInt2]);
            if (paramArrayOfByte2 != null)
            {
              int j = paramInt2 * 2;
              paramArrayOfByte1[j] = ((byte[])paramArrayOfByte2._userSt_Key.clone());
              paramArrayOfByte1[(j + 1)] = ((byte[])paramArrayOfByte2._userStSig.clone());
            }
            paramInt2 += 1;
            paramArrayOfByte2 = paramArrayOfLong;
          }
        }
      }
      break label1887;
      label1882:
      paramInt1 = -1004;
      label1887:
      paramWUserSigInfo = GetUserSigInfoTicket(paramWUserSigInfo, 128);
      paramArrayOfLong = paramWUserSigInfo;
      if (paramWUserSigInfo == null) {
        paramArrayOfLong = new Ticket();
      }
      t.at.commit_t2(localt.f, localt.g, util.format_ret_code(paramInt1), paramInt1);
      if (paramInt1 == 0)
      {
        if ((paramArrayOfLong._sig != null) && (paramArrayOfLong._sig.length != 0)) {
          RequestReport(0, paramArrayOfLong._sig, paramArrayOfLong._sig_key, localt.f, localasync_context._appid);
        }
      }
      else {
        RequestReportError(0, paramArrayOfLong._sig, paramArrayOfLong._sig_key, localt.f, localasync_context._appid, 0);
      }
      if ((localt.d != null) && (localt.d.get_bitmap() != 0))
      {
        this.mG.d = localt.d;
        RequestReportError(0, paramArrayOfLong._sig, paramArrayOfLong._sig_key, localt.f, localasync_context._appid, 1);
      }
      oicq.wlogin_sdk.report.c.a();
      t.b();
      localt.i();
      paramArrayOfLong = new StringBuilder();
      paramArrayOfLong.append("end GetStWithoutPasswd:user:");
      paramArrayOfLong.append(paramString);
      paramArrayOfLong.append(" dwSrcAppid:");
      paramArrayOfLong.append(paramLong1);
      paramArrayOfLong.append(" dwDstAppid:");
      paramArrayOfLong.append(paramLong2);
      paramArrayOfLong.append(" dwDstAppPri:");
      paramArrayOfLong.append(paramLong3);
      paramArrayOfLong.append(" dwMainSigMap:0x");
      paramArrayOfLong.append(Integer.toHexString(i));
      paramArrayOfLong.append(" dwSubDstAppid:");
      paramArrayOfLong.append(paramLong4);
      paramArrayOfLong.append(" Seq:");
      paramArrayOfLong.append(localt.h);
      paramArrayOfLong.append(" ret=");
      paramArrayOfLong.append(paramInt1);
      paramString = paramArrayOfLong.toString();
      paramArrayOfLong = new StringBuilder();
      paramArrayOfLong.append("");
      paramArrayOfLong.append(localt.f);
      util.LOGI(paramString, paramArrayOfLong.toString());
      return paramInt1;
    }
    return -1017;
  }
  
  private int GetStWithoutPasswd(String paramString, long paramLong1, long paramLong2, long paramLong3, int paramInt, WUserSigInfo paramWUserSigInfo, WtTicketPromise paramWtTicketPromise)
  {
    byte[][] arrayOfByte = (byte[][])null;
    return GetStWithoutPasswd(paramString, paramLong1, paramLong2, -1L, paramInt, paramLong3, null, paramWUserSigInfo, arrayOfByte, arrayOfByte, 0, paramWtTicketPromise);
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
      paramWUserSigInfo = new StringBuilder();
      paramWUserSigInfo.append("GetUserSigInfoTicket userInfo is null ");
      paramWUserSigInfo.append(Integer.toHexString(paramInt));
      util.LOGI(paramWUserSigInfo.toString(), "");
      return null;
    }
    Object localObject;
    if (paramWUserSigInfo._tickets == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("GetUserSigInfoTicket tickets is null ");
      ((StringBuilder)localObject).append(Integer.toHexString(paramInt));
      util.LOGI(((StringBuilder)localObject).toString(), paramWUserSigInfo.uin);
      return null;
    }
    if (paramWUserSigInfo._tickets != null)
    {
      int i = 0;
      while (i < paramWUserSigInfo._tickets.size())
      {
        localObject = (Ticket)paramWUserSigInfo._tickets.get(i);
        if (((Ticket)localObject)._type == paramInt)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("GetUserSigInfoTicket type:0x");
          localStringBuilder.append(Integer.toHexString(paramInt));
          localStringBuilder.append(" sig:");
          localStringBuilder.append(util.buf_len(((Ticket)localObject)._sig));
          localStringBuilder.append(" key:");
          localStringBuilder.append(util.buf_len(((Ticket)localObject)._sig_key));
          localStringBuilder.append(" create time:");
          localStringBuilder.append(((Ticket)localObject)._create_time);
          localStringBuilder.append(" expire time:");
          localStringBuilder.append(((Ticket)localObject)._expire_time);
          util.LOGI(localStringBuilder.toString(), "");
          util.LOGI(((Ticket)localObject).getContent(), paramWUserSigInfo.uin);
          return localObject;
        }
        i += 1;
      }
    }
    paramWUserSigInfo = new StringBuilder();
    paramWUserSigInfo.append("GetUserSigInfoTicket type null: 0x");
    paramWUserSigInfo.append(Integer.toHexString(paramInt));
    util.LOGI(paramWUserSigInfo.toString(), "");
    return null;
  }
  
  private void OnDeviceLockRequest(String paramString, long paramLong1, long paramLong2, TransReqContext paramTransReqContext, WUserSigInfo paramWUserSigInfo, int paramInt)
  {
    DevlockRst localDevlockRst = DevlockBase.rst;
    localDevlockRst.commRsp = new TLV_CommRsp();
    DevlockInfo localDevlockInfo = new DevlockInfo();
    ErrMsg localErrMsg = new ErrMsg(0, 0, "", "", "");
    if (paramInt != 0)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("OnDeviceLockRequest ret:");
      localStringBuilder.append(paramInt);
      util.LOGI(localStringBuilder.toString(), paramString);
      localErrMsg.setMessage(util.get_error_msg(paramInt));
      localErrMsg.setTitle(InternationMsg.a(InternationMsg.MSG_TYPE.MSG_5));
    }
    int i = paramTransReqContext.get_subcmd();
    if (i != 5)
    {
      if (i != 12)
      {
        if (i != 7)
        {
          if (i != 8) {
            return;
          }
          i = paramInt;
          if (paramInt == 0)
          {
            paramInt = new oicq.wlogin_sdk.devicelock.f().parse_rsp(paramTransReqContext.get_body());
            paramTransReqContext = new StringBuilder();
            paramTransReqContext.append("CheckDevLockSms ret:");
            paramTransReqContext.append(paramInt);
            util.LOGI(paramTransReqContext.toString(), paramString);
            i = paramInt;
            if (paramInt != -1009)
            {
              tlvCommRsp2ErrMsg(localDevlockRst.commRsp, localErrMsg);
              i = paramInt;
            }
          }
          paramString = this.mListener;
          if (paramString != null) {
            paramString.OnCheckDevLockSms(paramWUserSigInfo, i, localErrMsg);
          }
        }
        else
        {
          i = paramInt;
          if (paramInt == 0)
          {
            paramInt = new oicq.wlogin_sdk.devicelock.d().parse_rsp(paramTransReqContext.get_body());
            paramTransReqContext = new StringBuilder();
            paramTransReqContext.append("AskDevLockSms ret:");
            paramTransReqContext.append(paramInt);
            util.LOGI(paramTransReqContext.toString(), paramString);
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
          paramString = this.mListener;
          if (paramString != null) {
            paramString.OnAskDevLockSms(paramWUserSigInfo, localDevlockInfo, i, localErrMsg);
          }
        }
      }
      else
      {
        i = paramInt;
        if (paramInt == 0)
        {
          int j = new oicq.wlogin_sdk.devicelock.b().parse_rsp(paramTransReqContext.get_body());
          paramTransReqContext = new StringBuilder();
          paramTransReqContext.append("CloseDevLock ret:");
          paramTransReqContext.append(j);
          util.LOGI(paramTransReqContext.toString(), paramString);
          i = j;
          if (j != -1009)
          {
            tlvCommRsp2ErrMsg(localDevlockRst.commRsp, localErrMsg);
            try
            {
              if (!util.check_uin_account(paramString).booleanValue()) {
                paramLong2 = this.mG.b(paramString);
              } else {
                paramLong2 = Long.parseLong(paramString);
              }
              this.mG.b(paramLong2, paramLong1);
              paramInt = 0;
              for (;;)
              {
                i = j;
                if (paramInt >= paramWUserSigInfo._tickets.size()) {
                  break;
                }
                if (((Ticket)paramWUserSigInfo._tickets.get(paramInt))._type == 33554432) {
                  paramWUserSigInfo._tickets.remove(paramInt);
                }
                paramInt += 1;
              }
              paramString = this.mListener;
            }
            catch (Exception paramString)
            {
              util.printException(paramString);
              i = j;
            }
          }
        }
        if (paramString != null) {
          paramString.OnCloseDevLock(paramWUserSigInfo, i, localErrMsg);
        }
      }
    }
    else
    {
      i = paramInt;
      if (paramInt == 0)
      {
        paramInt = new oicq.wlogin_sdk.devicelock.a().parse_rsp(paramTransReqContext.get_body());
        paramTransReqContext = new StringBuilder();
        paramTransReqContext.append("CheckDevLockStatus ret:");
        paramTransReqContext.append(paramInt);
        util.LOGI(paramTransReqContext.toString(), paramString);
        i = paramInt;
        if (paramInt != -1009)
        {
          tlvCommRsp2ErrMsg(localDevlockRst.commRsp, localErrMsg);
          if ((localDevlockRst.devSetupInfo != null) && (localDevlockRst.devSetupInfo.get_data_len() > 0))
          {
            localDevlockInfo.DevSetup = localDevlockRst.devSetupInfo.a;
            localDevlockInfo.AllowSet = localDevlockRst.devSetupInfo.b;
            if ((localDevlockRst.devGuideInfo != null) && (localDevlockRst.devGuideInfo.get_data_len() > 0)) {
              localDevlockInfo.ProtectIntro = new String(localDevlockRst.devGuideInfo.a);
            } else {
              localDevlockInfo.ProtectIntro = new String(localDevlockRst.devSetupInfo.d);
            }
            localDevlockInfo.WarningInfo = new String(localDevlockRst.devSetupInfo.g);
            localDevlockInfo.WarningTitle = new String(localDevlockRst.devSetupInfo.e);
            localDevlockInfo.WarningMsg = new String(localDevlockRst.devSetupInfo.f);
            localDevlockInfo.WarningInfoType = localDevlockRst.devSetupInfo.c;
          }
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
        }
      }
      paramString = this.mListener;
      if (paramString != null) {
        paramString.OnCheckDevLockStatus(paramWUserSigInfo, localDevlockInfo, i, localErrMsg);
      }
    }
  }
  
  private void OnRequestCode2d(String paramString, long paramLong1, long paramLong2, TransReqContext paramTransReqContext, WUserSigInfo paramWUserSigInfo, int paramInt)
  {
    int i = paramInt;
    if (this.mListener == null)
    {
      util.LOGI("OnRequestCode2d mListener is null", paramString);
      return;
    }
    oicq.wlogin_sdk.code2d.d locald = oicq.wlogin_sdk.code2d.c._status;
    Object localObject;
    if (i != 0)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("OnRequestCode2d ret:");
      ((StringBuilder)localObject).append(i);
      util.LOGI(((StringBuilder)localObject).toString(), paramString);
    }
    int j = paramTransReqContext.get_subcmd();
    if (j != 49)
    {
      switch (j)
      {
      default: 
        util.LOGW("OnRequestName unhandle cmd", "", paramString);
        this.mListener.OnException(new ErrMsg(), 9, paramWUserSigInfo);
        return;
      case 20: 
        if (i != 0)
        {
          this.mListener.OnCloseCode(paramString, locald.d, locald.c, paramWUserSigInfo, locald.f, paramInt);
          return;
        }
        localObject = new oicq.wlogin_sdk.code2d.b();
        if (paramWUserSigInfo == null) {
          paramWUserSigInfo = new WUserSigInfo();
        }
        locald.b = ((oicq.wlogin_sdk.code2d.b)localObject).a(paramTransReqContext.get_body(), paramLong1, t.u, paramWUserSigInfo.loginTLVMap);
        paramTransReqContext = new StringBuilder();
        paramTransReqContext.append("CloseCode ret:");
        paramTransReqContext.append(locald.b);
        util.LOGI(paramTransReqContext.toString(), paramString);
        oicq.wlogin_sdk.code2d.d.t = false;
        this.mListener.OnCloseCode(paramString, locald.d, locald.c, paramWUserSigInfo, locald.f, locald.b);
        return;
      case 19: 
        if (i != 0)
        {
          this.mListener.OnVerifyCode(paramString, locald.d, locald.c, locald.e, paramWUserSigInfo, locald.f, paramInt);
          return;
        }
        locald.b = new oicq.wlogin_sdk.code2d.f().a(paramTransReqContext.get_body());
        paramTransReqContext = new StringBuilder();
        paramTransReqContext.append("VerifyCode ret:");
        paramTransReqContext.append(locald.b);
        util.LOGI(paramTransReqContext.toString(), paramString);
        if ((locald.b == 0) && (locald.g != null) && (locald.g.length > 0)) {
          this.mG.a(locald.a, paramLong1, locald.g);
        }
        this.mListener.OnVerifyCode(paramString, locald.d, locald.c, locald.e, paramWUserSigInfo, locald.f, locald.b);
        return;
      }
      paramInt = i;
      if (i == 0)
      {
        paramInt = new oicq.wlogin_sdk.code2d.e().a(paramTransReqContext.get_body());
        paramTransReqContext = new StringBuilder();
        paramTransReqContext.append("QueryCodeResult ret:");
        paramTransReqContext.append(locald.b);
        util.LOGI(paramTransReqContext.toString(), paramString);
      }
      this.mListener.OnQueryCodeResult(locald.a, locald.e, locald.c, paramWUserSigInfo, locald.f, paramInt);
      return;
    }
    paramInt = i;
    if (i == 0) {
      paramInt = new fetch_code().get_response(paramTransReqContext.get_body());
    }
    paramTransReqContext = new StringBuilder();
    paramTransReqContext.append("FetchCodeSig ret:");
    paramTransReqContext.append(locald.b);
    util.LOGI(paramTransReqContext.toString(), paramString);
    this.mListener.OnFetchCodeSig(locald.j, locald.k, locald.l, paramWUserSigInfo, locald.f, paramInt);
  }
  
  private void OnRequestRegister(String paramString, long paramLong1, long paramLong2, TransReqContext paramTransReqContext, WUserSigInfo paramWUserSigInfo, int paramInt)
  {
    if (this.mListener == null) {
      return;
    }
    Object localObject2 = InternationMsg.a(InternationMsg.MSG_TYPE.MSG_3);
    if (paramInt != 0)
    {
      paramString = this.mListener;
      if (paramString != null) {
        paramString.OnRegError(paramWUserSigInfo, paramInt, ((String)localObject2).getBytes());
      }
      return;
    }
    Object localObject1 = this.mRegStatus;
    paramInt = paramTransReqContext.get_subcmd();
    if (paramInt != 3)
    {
      if (paramInt != 4)
      {
        if (paramInt != 5)
        {
          if (paramInt != 6)
          {
            if (paramInt != 7)
            {
              if (paramInt != 10)
              {
                if ((paramInt != 1749) && (paramInt != 2170) && (paramInt != 2172))
                {
                  if (paramInt != 16)
                  {
                    if (paramInt != 17)
                    {
                      localObject1 = new StringBuilder();
                      ((StringBuilder)localObject1).append("OnRequestRegister unhandle cmd:");
                      ((StringBuilder)localObject1).append(paramTransReqContext.get_subcmd());
                      util.LOGW(((StringBuilder)localObject1).toString(), "", paramString);
                      paramString = this.mListener;
                      if (paramString != null) {
                        paramString.OnRegError(paramWUserSigInfo, -1010, ((String)localObject2).getBytes());
                      }
                    }
                    else
                    {
                      paramInt = oicq.wlogin_sdk.a.c.f(paramTransReqContext.get_body(), (oicq.wlogin_sdk.a.k)localObject1);
                      if (paramInt != 0)
                      {
                        paramString = this.mListener;
                        if (paramString != null) {
                          paramString.OnRegError(paramWUserSigInfo, paramInt, ((String)localObject2).getBytes());
                        }
                      }
                      paramString = new StringBuilder();
                      paramString.append("reg cmd:");
                      paramString.append(paramTransReqContext.get_subcmd());
                      paramString.append(" ret:");
                      paramString.append(((oicq.wlogin_sdk.a.k)localObject1).d);
                      util.LOGI(paramString.toString(), "");
                      paramWUserSigInfo.regTLVMap = ((oicq.wlogin_sdk.a.k)localObject1).C;
                      ((oicq.wlogin_sdk.a.k)localObject1).C = new HashMap();
                      this.mListener.OnQuickRegisterGetAccount(paramWUserSigInfo, ((oicq.wlogin_sdk.a.k)localObject1).d, ((oicq.wlogin_sdk.a.k)localObject1).f);
                    }
                  }
                  else
                  {
                    paramInt = oicq.wlogin_sdk.a.c.e(paramTransReqContext.get_body(), (oicq.wlogin_sdk.a.k)localObject1);
                    if (paramInt != 0)
                    {
                      paramString = this.mListener;
                      if (paramString != null) {
                        paramString.OnRegError(paramWUserSigInfo, paramInt, ((String)localObject2).getBytes());
                      }
                    }
                    paramString = new StringBuilder();
                    paramString.append("reg cmd:");
                    paramString.append(paramTransReqContext.get_subcmd());
                    paramString.append(" ret:");
                    paramString.append(((oicq.wlogin_sdk.a.k)localObject1).d);
                    util.LOGI(paramString.toString(), "");
                    this.mListener.OnQuickRegisterCheckAccount(paramWUserSigInfo, ((oicq.wlogin_sdk.a.k)localObject1).d, ((oicq.wlogin_sdk.a.k)localObject1).f);
                  }
                }
                else
                {
                  paramString = new StringBuilder();
                  paramString.append("reg cmd:");
                  paramString.append(paramTransReqContext.get_subcmd());
                  util.LOGI(paramString.toString());
                  this.mListener.onModifyQIMPassword(paramWUserSigInfo, paramTransReqContext.get_subcmd(), paramTransReqContext.get_body());
                }
              }
              else
              {
                paramInt = oicq.wlogin_sdk.a.c.a(paramTransReqContext.get_body(), (oicq.wlogin_sdk.a.k)localObject1);
                if (paramInt != 0)
                {
                  paramString = this.mListener;
                  if (paramString != null) {
                    paramString.OnRegError(paramWUserSigInfo, paramInt, ((String)localObject2).getBytes());
                  }
                  return;
                }
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("reg cmd:");
                ((StringBuilder)localObject2).append(paramTransReqContext.get_subcmd());
                ((StringBuilder)localObject2).append(" ret:");
                ((StringBuilder)localObject2).append(((oicq.wlogin_sdk.a.k)localObject1).d);
                util.LOGI(((StringBuilder)localObject2).toString(), "");
                if (((oicq.wlogin_sdk.a.k)localObject1).d == 0)
                {
                  paramString = this.mListener;
                  if (paramString != null) {
                    paramString.OnRegCheckDownloadMsg(paramWUserSigInfo, ((oicq.wlogin_sdk.a.k)localObject1).m, ((oicq.wlogin_sdk.a.k)localObject1).n);
                  }
                }
                else if (((oicq.wlogin_sdk.a.k)localObject1).d == 2)
                {
                  paramString = this.mListener;
                  if (paramString != null) {
                    paramString.OnRegCheckUploadMsg(paramWUserSigInfo, new String(((oicq.wlogin_sdk.a.k)localObject1).q));
                  }
                }
                else if (((oicq.wlogin_sdk.a.k)localObject1).d == 3)
                {
                  paramString = this.mListener;
                  if (paramString != null) {
                    paramString.OnRegCheckValidUrl(paramWUserSigInfo, ((oicq.wlogin_sdk.a.k)localObject1).r);
                  }
                }
                else if ((((oicq.wlogin_sdk.a.k)localObject1).d != 6) && (((oicq.wlogin_sdk.a.k)localObject1).d != 44))
                {
                  if (((oicq.wlogin_sdk.a.k)localObject1).d == 51)
                  {
                    paramString = this.mListener;
                    if (paramString != null) {
                      paramString.OnGuaranteeCheckValidUrl(paramWUserSigInfo, ((oicq.wlogin_sdk.a.k)localObject1).r);
                    }
                  }
                  else if (((oicq.wlogin_sdk.a.k)localObject1).d == 58)
                  {
                    paramString = this.mListener;
                    if (paramString != null) {
                      paramString.OnRegCheckIframe(paramWUserSigInfo, ((oicq.wlogin_sdk.a.k)localObject1).r, null);
                    }
                  }
                  else if (((oicq.wlogin_sdk.a.k)localObject1).d == 59)
                  {
                    paramString = new StringBuilder();
                    paramString.append("OnRegCheckError REG_CHECK_ERROR_FACE regSig= ");
                    paramString.append(util.printByte(((oicq.wlogin_sdk.a.k)localObject1).s));
                    util.LOGW(paramString.toString(), "");
                    paramString = this.mListener;
                    if (paramString != null) {
                      paramString.OnRegError(paramWUserSigInfo, 59, ((oicq.wlogin_sdk.a.k)localObject1).s);
                    }
                  }
                  else
                  {
                    util.LOGW("OnRequestRegister 0xa return code:", String.valueOf(((oicq.wlogin_sdk.a.k)localObject1).d), paramString);
                    paramString = this.mListener;
                    if (paramString != null) {
                      paramString.OnRegError(paramWUserSigInfo, ((oicq.wlogin_sdk.a.k)localObject1).d, ((oicq.wlogin_sdk.a.k)localObject1).f);
                    }
                  }
                }
                else
                {
                  paramString = this.mListener;
                  if (paramString != null) {
                    paramString.OnRegCheckWebSig(paramWUserSigInfo, new String(((oicq.wlogin_sdk.a.k)localObject1).r), new String(((oicq.wlogin_sdk.a.k)localObject1).f));
                  }
                  ((oicq.wlogin_sdk.a.k)localObject1).r = new byte[0];
                }
              }
            }
            else
            {
              paramInt = oicq.wlogin_sdk.a.c.d(paramTransReqContext.get_body(), (oicq.wlogin_sdk.a.k)localObject1);
              if (paramInt != 0)
              {
                paramString = this.mListener;
                if (paramString != null) {
                  paramString.OnRegError(paramWUserSigInfo, paramInt, ((String)localObject2).getBytes());
                }
                return;
              }
              paramString = new StringBuilder();
              paramString.append("reg cmd:");
              paramString.append(paramTransReqContext.get_subcmd());
              paramString.append(" ret:");
              paramString.append(((oicq.wlogin_sdk.a.k)localObject1).d);
              util.LOGI(paramString.toString(), "");
              paramString = this.mListener;
              if (paramString != null) {
                paramString.OnRegQueryAccount(paramWUserSigInfo, ((oicq.wlogin_sdk.a.k)localObject1).d, ((oicq.wlogin_sdk.a.k)localObject1).f);
              }
            }
          }
          else
          {
            paramInt = oicq.wlogin_sdk.a.c.c(paramTransReqContext.get_body(), (oicq.wlogin_sdk.a.k)localObject1);
            if (paramInt != 0)
            {
              paramString = this.mListener;
              if (paramString != null) {
                paramString.OnRegError(paramWUserSigInfo, paramInt, ((String)localObject2).getBytes());
              }
            }
            else
            {
              paramWUserSigInfo.regTLVMap = ((oicq.wlogin_sdk.a.k)localObject1).C;
              ((oicq.wlogin_sdk.a.k)localObject1).C = new HashMap();
              paramString = new StringBuilder();
              paramString.append("reg cmd:");
              paramString.append(paramTransReqContext.get_subcmd());
              paramString.append(" ret:");
              paramString.append(((oicq.wlogin_sdk.a.k)localObject1).d);
              util.LOGI(paramString.toString(), "");
              if (this.mListener != null)
              {
                if ((((oicq.wlogin_sdk.a.k)localObject1).b != null) && (((oicq.wlogin_sdk.a.k)localObject1).b.indexOf("-") > 0))
                {
                  paramInt = ((oicq.wlogin_sdk.a.k)localObject1).b.indexOf("-");
                  paramString = ((oicq.wlogin_sdk.a.k)localObject1).b.substring(0, paramInt);
                  if (paramString.equals("86"))
                  {
                    ((oicq.wlogin_sdk.a.k)localObject1).b = ((oicq.wlogin_sdk.a.k)localObject1).b.substring(paramInt + 1);
                  }
                  else
                  {
                    paramTransReqContext = new StringBuilder();
                    paramTransReqContext.append("00");
                    paramTransReqContext.append(paramString);
                    paramTransReqContext.append(((oicq.wlogin_sdk.a.k)localObject1).b.substring(paramInt + 1));
                    ((oicq.wlogin_sdk.a.k)localObject1).b = paramTransReqContext.toString();
                  }
                }
                if ((((oicq.wlogin_sdk.a.k)localObject1).b != null) && (((oicq.wlogin_sdk.a.k)localObject1).b.length() != 0))
                {
                  this.mG.d(((oicq.wlogin_sdk.a.k)localObject1).b);
                  this.mG.a(((oicq.wlogin_sdk.a.k)localObject1).b, Long.valueOf(((oicq.wlogin_sdk.a.k)localObject1).v));
                }
                paramString = new StringBuilder();
                paramString.append("reg userAccount: ");
                paramString.append(((oicq.wlogin_sdk.a.k)localObject1).b);
                paramString = paramString.toString();
                paramTransReqContext = new StringBuilder();
                paramTransReqContext.append(((oicq.wlogin_sdk.a.k)localObject1).v);
                paramTransReqContext.append("");
                util.LOGI(paramString, paramTransReqContext.toString());
                if ((oicq.wlogin_sdk.a.k.A.length() > 0) && (oicq.wlogin_sdk.a.k.y))
                {
                  this.mListener.OnRegGetSMSVerifyLoginAccount(paramWUserSigInfo, ((oicq.wlogin_sdk.a.k)localObject1).d, ((oicq.wlogin_sdk.a.k)localObject1).v, ((oicq.wlogin_sdk.a.k)localObject1).w, ((oicq.wlogin_sdk.a.k)localObject1).x, ((oicq.wlogin_sdk.a.k)localObject1).f);
                  return;
                }
                this.mListener.OnRegGetAccount(paramWUserSigInfo, ((oicq.wlogin_sdk.a.k)localObject1).d, ((oicq.wlogin_sdk.a.k)localObject1).v, ((oicq.wlogin_sdk.a.k)localObject1).w, ((oicq.wlogin_sdk.a.k)localObject1).x, ((oicq.wlogin_sdk.a.k)localObject1).f);
              }
            }
          }
        }
        else
        {
          paramInt = oicq.wlogin_sdk.a.c.b(paramTransReqContext.get_body(), (oicq.wlogin_sdk.a.k)localObject1);
          if (paramInt != 0)
          {
            paramString = this.mListener;
            if (paramString != null) {
              paramString.OnRegError(paramWUserSigInfo, paramInt, ((String)localObject2).getBytes());
            }
          }
          else
          {
            paramWUserSigInfo.regTLVMap = ((oicq.wlogin_sdk.a.k)localObject1).C;
            ((oicq.wlogin_sdk.a.k)localObject1).C = new HashMap();
            paramString = new StringBuilder();
            paramString.append("reg cmd:");
            paramString.append(paramTransReqContext.get_subcmd());
            paramString.append(" ret:");
            paramString.append(((oicq.wlogin_sdk.a.k)localObject1).d);
            util.LOGI(paramString.toString(), "");
            paramString = this.mListener;
            if (paramString != null) {
              paramString.OnRegSubmitMsgChk(paramWUserSigInfo, ((oicq.wlogin_sdk.a.k)localObject1).d, ((oicq.wlogin_sdk.a.k)localObject1).f);
            }
          }
        }
      }
      else
      {
        paramInt = oicq.wlogin_sdk.a.c.a(paramTransReqContext.get_body(), (oicq.wlogin_sdk.a.k)localObject1);
        if (paramInt != 0)
        {
          paramString = this.mListener;
          if (paramString != null) {
            paramString.OnRegError(paramWUserSigInfo, paramInt, ((String)localObject2).getBytes());
          }
        }
        else
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("reg cmd:");
          ((StringBuilder)localObject2).append(paramTransReqContext.get_subcmd());
          ((StringBuilder)localObject2).append(" ret:");
          ((StringBuilder)localObject2).append(((oicq.wlogin_sdk.a.k)localObject1).d);
          util.LOGI(((StringBuilder)localObject2).toString(), "");
          if (((oicq.wlogin_sdk.a.k)localObject1).d == 0)
          {
            paramString = this.mListener;
            if (paramString != null) {
              paramString.OnRegRequestServerResendMsg(paramWUserSigInfo, ((oicq.wlogin_sdk.a.k)localObject1).d, ((oicq.wlogin_sdk.a.k)localObject1).t, ((oicq.wlogin_sdk.a.k)localObject1).u);
            }
          }
          else if (((oicq.wlogin_sdk.a.k)localObject1).d == 3)
          {
            paramString = this.mListener;
            if (paramString != null) {
              paramString.OnRegCheckValidUrl(paramWUserSigInfo, ((oicq.wlogin_sdk.a.k)localObject1).r);
            }
          }
          else if (((oicq.wlogin_sdk.a.k)localObject1).d == 5)
          {
            paramString = this.mListener;
            if (paramString != null) {
              paramString.OnRegRequestServerResendMsg(paramWUserSigInfo, ((oicq.wlogin_sdk.a.k)localObject1).d, ((oicq.wlogin_sdk.a.k)localObject1).t, ((oicq.wlogin_sdk.a.k)localObject1).u);
            }
          }
          else
          {
            util.LOGW("OnRequestRegister 0x4 return code:", String.valueOf(((oicq.wlogin_sdk.a.k)localObject1).d), paramString);
            paramString = this.mListener;
            if (paramString != null) {
              paramString.OnRegError(paramWUserSigInfo, ((oicq.wlogin_sdk.a.k)localObject1).d, ((oicq.wlogin_sdk.a.k)localObject1).f);
            }
          }
        }
      }
    }
    else
    {
      paramInt = oicq.wlogin_sdk.a.c.a(3, paramTransReqContext.get_body(), (oicq.wlogin_sdk.a.k)localObject1);
      if (paramInt != 0)
      {
        paramString = this.mListener;
        if (paramString != null) {
          paramString.OnRegError(paramWUserSigInfo, paramInt, ((String)localObject2).getBytes());
        }
      }
      else
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("reg cmd:");
        ((StringBuilder)localObject2).append(paramTransReqContext.get_subcmd());
        ((StringBuilder)localObject2).append(" ret:");
        ((StringBuilder)localObject2).append(((oicq.wlogin_sdk.a.k)localObject1).d);
        util.LOGI(((StringBuilder)localObject2).toString(), "");
        if ((((oicq.wlogin_sdk.a.k)localObject1).d != 0) && (((oicq.wlogin_sdk.a.k)localObject1).d != 4) && (((oicq.wlogin_sdk.a.k)localObject1).d != 31) && (((oicq.wlogin_sdk.a.k)localObject1).d != 118))
        {
          if (((oicq.wlogin_sdk.a.k)localObject1).d == 3)
          {
            paramString = this.mListener;
            if (paramString != null) {
              paramString.OnRegCheckValidUrl(paramWUserSigInfo, ((oicq.wlogin_sdk.a.k)localObject1).r);
            }
          }
          else
          {
            util.LOGW("OnRequestRegister 0x3 return code:", String.valueOf(((oicq.wlogin_sdk.a.k)localObject1).d), paramString);
            paramString = this.mListener;
            if (paramString != null) {
              paramString.OnRegError(paramWUserSigInfo, ((oicq.wlogin_sdk.a.k)localObject1).d, ((oicq.wlogin_sdk.a.k)localObject1).f);
            }
          }
        }
        else
        {
          if (((oicq.wlogin_sdk.a.k)localObject1).d == 0)
          {
            paramWUserSigInfo.regTLVMap = ((oicq.wlogin_sdk.a.k)localObject1).C;
            ((oicq.wlogin_sdk.a.k)localObject1).C = new HashMap();
          }
          this.mListener.OnRegQueryClientSentMsgStatus(paramWUserSigInfo, ((oicq.wlogin_sdk.a.k)localObject1).d, ((oicq.wlogin_sdk.a.k)localObject1).t, ((oicq.wlogin_sdk.a.k)localObject1).u, new String(((oicq.wlogin_sdk.a.k)localObject1).f));
        }
      }
    }
  }
  
  private int RefreshPictureData(String paramString, WUserSigInfo paramWUserSigInfo, int paramInt)
  {
    if ((paramString != null) && (paramWUserSigInfo != null))
    {
      if (paramInt == 0)
      {
        new WtloginHelper.HelperThread(this, this, this.mHelperHandler, paramString, paramWUserSigInfo, "RefreshPictureData").RunReq(1);
        return -1001;
      }
      if (paramWUserSigInfo._seqence == 0L) {
        paramWUserSigInfo._seqence = this.mAysncSeq;
      }
      Object localObject1 = this.mG.a(paramWUserSigInfo._seqence);
      paramWUserSigInfo._seqence = ((t)localObject1).h;
      async_context localasync_context = t.b(((t)localObject1).h);
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("user:");
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append(" Seq:");
      ((StringBuilder)localObject2).append(((t)localObject1).h);
      ((StringBuilder)localObject2).append(" RefreshPictureData ...");
      localObject2 = ((StringBuilder)localObject2).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(paramString);
      util.LOGI((String)localObject2, localStringBuilder.toString());
      ((t)localObject1).g = paramString;
      localasync_context._last_err_msg = new ErrMsg();
      long l;
      if (!util.check_uin_account(paramString).booleanValue())
      {
        l = ((t)localObject1).b(paramString);
        if (l == 0L)
        {
          paramInt = 0;
          break label243;
        }
      }
      else
      {
        l = Long.parseLong(paramString);
      }
      paramInt = 1;
      label243:
      if (paramInt == 1) {
        ((t)localObject1).f = l;
      }
      int i = new q((t)localObject1).a(this.mMiscBitmap, this.mSubSigMap, localasync_context._sub_appid_list, paramWUserSigInfo);
      paramInt = i;
      if (i == 2) {
        paramInt = 0;
      }
      paramWUserSigInfo = new StringBuilder();
      paramWUserSigInfo.append("user:");
      paramWUserSigInfo.append(paramString);
      paramWUserSigInfo.append(" Seq:");
      paramWUserSigInfo.append(((t)localObject1).h);
      paramWUserSigInfo.append(" RefreshPictureData ret=");
      paramWUserSigInfo.append(paramInt);
      paramWUserSigInfo = paramWUserSigInfo.toString();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("");
      ((StringBuilder)localObject1).append(paramString);
      util.LOGI(paramWUserSigInfo, ((StringBuilder)localObject1).toString());
      return paramInt;
    }
    return -1017;
  }
  
  private int RefreshSMSData(String paramString, long paramLong, WUserSigInfo paramWUserSigInfo, byte[] paramArrayOfByte, int paramInt)
  {
    if ((paramString != null) && (paramWUserSigInfo != null))
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(util.LOG_TAG_GATEWAY_LOGIN_NEW_DOV);
      ((StringBuilder)localObject1).append("RefreshSMSData _seqence:");
      ((StringBuilder)localObject1).append(paramWUserSigInfo._seqence);
      ((StringBuilder)localObject1).append(" mAysncSeq:");
      ((StringBuilder)localObject1).append(this.mAysncSeq);
      util.LOGI(((StringBuilder)localObject1).toString(), "");
      if (paramInt == 0)
      {
        new WtloginHelper.HelperThread(this, this, this.mHelperHandler, paramString, paramLong, paramWUserSigInfo, paramArrayOfByte, "RefreshSMSData").RunReq(3);
        return -1001;
      }
      if (paramWUserSigInfo._seqence == 0L) {
        paramWUserSigInfo._seqence = this.mAysncSeq;
      }
      localObject1 = this.mG.a(paramWUserSigInfo._seqence);
      paramWUserSigInfo._seqence = ((t)localObject1).h;
      async_context localasync_context = t.b(((t)localObject1).h);
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(util.LOG_TAG_GATEWAY_LOGIN_NEW_DOV);
      ((StringBuilder)localObject2).append("RefreshSMSData user:");
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append(" smsAppid:");
      ((StringBuilder)localObject2).append(paramLong);
      ((StringBuilder)localObject2).append(" Seq:");
      ((StringBuilder)localObject2).append(((t)localObject1).h);
      ((StringBuilder)localObject2).append(" RefreshSMSData ...");
      localObject2 = ((StringBuilder)localObject2).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(paramString);
      util.LOGI((String)localObject2, localStringBuilder.toString());
      ((t)localObject1).g = paramString;
      localasync_context._last_err_msg = new ErrMsg();
      long l;
      if (!util.check_uin_account(paramString).booleanValue())
      {
        l = ((t)localObject1).b(paramString);
        if (l == 0L)
        {
          paramInt = 0;
          break label348;
        }
      }
      else
      {
        l = Long.parseLong(paramString);
      }
      paramInt = 1;
      label348:
      if (paramInt == 1) {
        ((t)localObject1).f = l;
      }
      int i = new r((t)localObject1).a(paramLong, this.mMiscBitmap, this.mSubSigMap, localasync_context._sub_appid_list, paramWUserSigInfo, paramArrayOfByte);
      paramInt = i;
      if (i == 160) {
        paramInt = 0;
      }
      paramWUserSigInfo = new StringBuilder();
      paramWUserSigInfo.append("user:");
      paramWUserSigInfo.append(paramString);
      paramWUserSigInfo.append(" smsAppid:");
      paramWUserSigInfo.append(paramLong);
      paramWUserSigInfo.append(" Seq:");
      paramWUserSigInfo.append(((t)localObject1).h);
      paramWUserSigInfo.append(" RefreshSMSData ret=");
      paramWUserSigInfo.append(paramInt);
      paramWUserSigInfo = paramWUserSigInfo.toString();
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("");
      paramArrayOfByte.append(paramString);
      util.LOGI(paramWUserSigInfo, paramArrayOfByte.toString());
      return paramInt;
    }
    return -1017;
  }
  
  private int RefreshSMSVerifyLoginCode(String paramString, WUserSigInfo paramWUserSigInfo, int paramInt)
  {
    if ((paramString != null) && (paramString.length() != 0))
    {
      if (paramInt == 0)
      {
        new WtloginHelper.HelperThread(this, this, this.mHelperHandler, paramString, paramWUserSigInfo, "RefreshSMSVerifyLoginCode").RunReq(14);
        return -1001;
      }
      if (paramWUserSigInfo._seqence == 0L) {
        paramWUserSigInfo._seqence = this.mAysncSeq;
      }
      t localt = this.mG.a(paramWUserSigInfo._seqence);
      paramWUserSigInfo._seqence = localt.h;
      Object localObject = t.b(localt.h);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("user:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" Seq:");
      localStringBuilder.append(localt.h);
      localStringBuilder.append(" RefreshSMSVerifyLoginCode ...");
      util.LOGI(localStringBuilder.toString(), paramString);
      localt.g = paramString;
      ((async_context)localObject)._last_err_msg = new ErrMsg();
      paramInt = new y(localt).a(this.mMiscBitmap, this.mSubSigMap, null, paramWUserSigInfo);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("user:");
      ((StringBuilder)localObject).append(localt.g);
      ((StringBuilder)localObject).append(" Seq:");
      ((StringBuilder)localObject).append(localt.h);
      ((StringBuilder)localObject).append(" RefreshSMSVerifyLoginCode ret=");
      if (paramInt > 0) {
        paramWUserSigInfo = Integer.toHexString(paramInt);
      } else {
        paramWUserSigInfo = Integer.valueOf(paramInt);
      }
      ((StringBuilder)localObject).append(paramWUserSigInfo);
      util.LOGI(((StringBuilder)localObject).toString(), paramString);
      return paramInt;
    }
    return -1017;
  }
  
  private int RegSubmitMobile(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, WUserSigInfo paramWUserSigInfo, Map<String, Object> paramMap)
  {
    if ((paramArrayOfByte2 != null) && (paramArrayOfByte2.length > 0) && (paramArrayOfByte4 != null))
    {
      if (paramArrayOfByte1 == null) {
        paramArrayOfByte1 = new byte[0];
      }
      byte[] arrayOfByte = t.F;
      long l1 = 0L;
      Object localObject1 = new byte[0];
      Object localObject2 = GetLastLoginInfo();
      paramArrayOfByte3 = (byte[])localObject1;
      if (localObject2 != null)
      {
        long l2 = ((WloginLastLoginInfo)localObject2).mUin;
        localObject2 = GetLocalTicket(((WloginLastLoginInfo)localObject2).mAccount, paramLong1, 64);
        paramArrayOfByte3 = (byte[])localObject1;
        l1 = l2;
        if (localObject2 != null)
        {
          paramArrayOfByte3 = (byte[])localObject1;
          l1 = l2;
          if (((Ticket)localObject2)._sig != null)
          {
            paramArrayOfByte3 = ((Ticket)localObject2)._sig;
            l1 = l2;
          }
        }
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("has uin? ");
      ((StringBuilder)localObject1).append(l1);
      ((StringBuilder)localObject1).append(", a2: ");
      ((StringBuilder)localObject1).append(paramArrayOfByte3.length);
      util.LOGI(((StringBuilder)localObject1).toString());
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("RegSubmitMobile mobile ...");
      ((StringBuilder)localObject1).append(new String(paramArrayOfByte2));
      ((StringBuilder)localObject1).append(" appname: ");
      ((StringBuilder)localObject1).append(new String(arrayOfByte));
      ((StringBuilder)localObject1).append("...");
      util.LOGI(((StringBuilder)localObject1).toString(), "");
      this.mRegStatus.c = new String(paramArrayOfByte2);
      localObject1 = new oicq.wlogin_sdk.a.h();
      localObject2 = new TransReqContext();
      oicq.wlogin_sdk.a.k localk = this.mRegStatus;
      localk.k = paramArrayOfByte2;
      localk.g = paramLong1;
      localk.h = paramLong2;
      ((TransReqContext)localObject2).set_register_req();
      ((TransReqContext)localObject2).set_subcmd(((oicq.wlogin_sdk.a.h)localObject1).a());
      ((TransReqContext)localObject2)._body = ((oicq.wlogin_sdk.a.h)localObject1).a(paramArrayOfByte2, arrayOfByte, paramArrayOfByte4, paramInt1, paramInt2, paramInt3, paramLong1, paramLong2, null, util.generateGuid(this.mContext), util.get_IMSI(this.mContext), t.ad, l1, paramArrayOfByte3, GetGuid(), paramArrayOfByte1, paramWUserSigInfo.extraRegTLVMap, paramMap);
      return RequestTransport(0, 1, null, 0L, oicq.wlogin_sdk.a.k.i, (TransReqContext)localObject2, paramWUserSigInfo);
    }
    return -1017;
  }
  
  private void RequestInit()
  {
    try
    {
      t.d();
      ShareKeyInit();
      AsyncGenRSAKey();
      String str = util.buf_to_string(t.B, t.B.length);
      ByteData.getInstance().processFilterSwitch(true, "com.tencent.mobileqq:msf");
      ByteData.getInstance().init(this.mContext, "1", str, "", "init", "6.0.0.2473");
      ByteData.getInstance().setData("init");
      try
      {
        str = t.m();
        if ((!TextUtils.isEmpty(str)) && (str.endsWith(":MSF")))
        {
          oicq.wlogin_sdk.tools.c.a().a(this.mG);
          oicq.wlogin_sdk.tools.c.a().b();
        }
      }
      catch (Throwable localThrowable)
      {
        util.printThrowable(localThrowable, "RequestInit");
      }
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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("user:");
    ((StringBuilder)localObject).append(paramLong1);
    ((StringBuilder)localObject).append(" appid:");
    ((StringBuilder)localObject).append(paramLong2);
    ((StringBuilder)localObject).append(" Seq:");
    ((StringBuilder)localObject).append(localt.h);
    ((StringBuilder)localObject).append(" RequestReport...");
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramLong1);
    util.LOGI((String)localObject, localStringBuilder.toString());
    paramInt = new ab(localt).a(paramLong1, null, paramArrayOfByte1, paramArrayOfByte2, paramLong2, new WUserSigInfo());
    localt.j();
    paramArrayOfByte1 = new StringBuilder();
    paramArrayOfByte1.append("user:");
    paramArrayOfByte1.append(paramLong1);
    paramArrayOfByte1.append(" appid:");
    paramArrayOfByte1.append(paramLong2);
    paramArrayOfByte1.append(" Seq:");
    paramArrayOfByte1.append(localt.h);
    paramArrayOfByte1.append(" RequestReport ret=");
    paramArrayOfByte1.append(paramInt);
    paramArrayOfByte1 = paramArrayOfByte1.toString();
    paramArrayOfByte2 = new StringBuilder();
    paramArrayOfByte2.append("");
    paramArrayOfByte2.append(paramLong1);
    util.LOGI(paramArrayOfByte1, paramArrayOfByte2.toString());
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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("user:");
    ((StringBuilder)localObject).append(paramLong1);
    ((StringBuilder)localObject).append(" appid:");
    ((StringBuilder)localObject).append(paramLong2);
    ((StringBuilder)localObject).append(" Seq:");
    ((StringBuilder)localObject).append(localt.h);
    ((StringBuilder)localObject).append(" RequestReportError...");
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramLong1);
    util.LOGI((String)localObject, localStringBuilder.toString());
    paramInt1 = new w(localt).a(paramLong1, null, paramArrayOfByte1, paramArrayOfByte2, paramLong2, paramInt2);
    paramArrayOfByte1 = new StringBuilder();
    paramArrayOfByte1.append("user:");
    paramArrayOfByte1.append(paramLong1);
    paramArrayOfByte1.append(" appid:");
    paramArrayOfByte1.append(paramLong2);
    paramArrayOfByte1.append(" Seq:");
    paramArrayOfByte1.append(localt.h);
    paramArrayOfByte1.append(" RequestReportError ret=");
    paramArrayOfByte1.append(paramInt1);
    paramArrayOfByte1 = paramArrayOfByte1.toString();
    paramArrayOfByte2 = new StringBuilder();
    paramArrayOfByte2.append("");
    paramArrayOfByte2.append(paramLong1);
    util.LOGI(paramArrayOfByte1, paramArrayOfByte2.toString());
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
    try
    {
      Pair localPair = oicq.wlogin_sdk.tools.c.a().c();
      if (localPair != null) {
        localEcdhCrypt.setPubKey((String)localPair.first, ((Integer)localPair.second).intValue());
      }
    }
    catch (Throwable localThrowable)
    {
      util.printThrowable(localThrowable, "ShareKeyInit");
    }
    int i = util.getInitKeyTime(this.mContext);
    if (i > 3)
    {
      i = localEcdhCrypt.initShareKeyByDefault();
    }
    else
    {
      util.saveInitKeyTime(this.mContext, i + 1);
      int j = localEcdhCrypt.initShareKey();
      i = j;
      if (j == 0)
      {
        util.saveInitKeyTime(this.mContext, 0);
        i = j;
      }
    }
    util.LOGI("end ShareKeyInit", "");
    this.mG.n = localEcdhCrypt.get_c_pub_key();
    this.mG.p = localEcdhCrypt.get_g_share_key();
    this.mG.r = localEcdhCrypt.get_pub_key_ver();
    return i;
  }
  
  private int VerifySMSVerifyLoginCode(String paramString1, String paramString2, WUserSigInfo paramWUserSigInfo, int paramInt)
  {
    if ((paramString1 != null) && (paramString1.length() != 0) && (paramString2 != null) && (paramString2.length() != 0))
    {
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("user:");
      localStringBuilder.append(localt.g);
      localStringBuilder.append(" code:");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(" Seq:");
      localStringBuilder.append(localt.h);
      localStringBuilder.append(" VerifySMSVerifyLoginCode ...");
      util.LOGI(localStringBuilder.toString(), paramString1);
      localt.g = paramString1;
      localasync_context._last_err_msg = new ErrMsg();
      localasync_context._mpasswd = util.get_mpasswd();
      paramInt = new z(localt).a(paramString2, this.mMiscBitmap, this.mSubSigMap, null, paramWUserSigInfo);
      paramWUserSigInfo = new StringBuilder();
      paramWUserSigInfo.append("user:");
      paramWUserSigInfo.append(paramString1);
      paramWUserSigInfo.append(" code:");
      paramWUserSigInfo.append(paramString2);
      paramWUserSigInfo.append(" Seq:");
      paramWUserSigInfo.append(localt.h);
      paramWUserSigInfo.append(" VerifySMSVerifyLoginAccount ret=");
      if (paramInt > 0) {
        paramString2 = Integer.toHexString(paramInt);
      } else {
        paramString2 = Integer.valueOf(paramInt);
      }
      paramWUserSigInfo.append(paramString2);
      util.LOGI(paramWUserSigInfo.toString(), paramString1);
      return paramInt;
    }
    return -1017;
  }
  
  public static void customizeLogDir(String paramString)
  {
    t.az = paramString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("set log dir ");
    localStringBuilder.append(paramString);
    util.LOGI(localStringBuilder.toString(), "");
  }
  
  private WtloginHelper.A1AndNopicSig getA1AndNopicSigByAccount(String paramString, long paramLong)
  {
    WtloginHelper.A1AndNopicSig localA1AndNopicSig = new WtloginHelper.A1AndNopicSig(null);
    StringBuffer localStringBuffer = new StringBuffer("getA1AndNopicSigByAccount,userAccount=");
    localStringBuffer.append(paramString);
    paramString = getSigInfo(paramString, paramLong);
    if (paramString != null)
    {
      if ((paramString._en_A1 != null) && (paramString._en_A1.length > 0))
      {
        localA1AndNopicSig.a1 = ((byte[])paramString._en_A1.clone());
        localStringBuffer.append(",a1=");
        localStringBuffer.append(localA1AndNopicSig.a1.length);
      }
      else
      {
        localStringBuffer.append(",a1=null");
      }
      if ((paramString._noPicSig != null) && (paramString._noPicSig.length > 0))
      {
        localA1AndNopicSig.noPicSig = ((byte[])paramString._noPicSig.clone());
        localStringBuffer.append(",noPicSig=");
        localStringBuffer.append(localA1AndNopicSig.noPicSig.length);
      }
      else
      {
        localStringBuffer.append(",noPicSig=null");
      }
    }
    else
    {
      localStringBuffer.append(",info == null");
    }
    util.LOGI(localStringBuffer.toString(), "");
    return localA1AndNopicSig;
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getLoginResultField get str ");
      localStringBuilder.append((String)localObject);
      util.LOGI(localStringBuilder.toString(), paramWUserSigInfo.uin);
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getLoginResultField2 get str ");
      localStringBuilder.append((String)localObject);
      util.LOGI(localStringBuilder.toString(), paramWUserSigInfo.uin);
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
  
  private WloginSigInfo getSigInfo(String paramString, long paramLong)
  {
    if (paramString == null) {
      return null;
    }
    long l1;
    if (!util.check_uin_account(paramString).booleanValue())
    {
      long l2 = this.mG.b(paramString);
      l1 = l2;
      if (l2 == 0L) {
        return null;
      }
    }
    else
    {
      l1 = Long.parseLong(paramString);
    }
    return this.mG.a(l1, paramLong);
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
    if ((paramString != null) && (paramWUserSigInfo != null))
    {
      int i = paramInt1 | 0xC0;
      if (paramInt2 == 0)
      {
        new WtloginHelper.HelperThread(this, this, this.mHelperHandler, paramString, paramLong1, i, paramLong2, paramWUserSigInfo, "getStWithQrSig").RunReq(17);
        return -1001;
      }
      t localt = this.mG.a(0L);
      paramWUserSigInfo._seqence = localt.h;
      this.mAysncSeq = localt.h;
      oicq.wlogin_sdk.a.k.A = "";
      Object localObject1 = t.b(localt.h);
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("start getStWithQrSig:user:");
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append(" appid:");
      ((StringBuilder)localObject2).append(paramLong1);
      ((StringBuilder)localObject2).append(" sigMap:0x");
      ((StringBuilder)localObject2).append(Integer.toHexString(i));
      ((StringBuilder)localObject2).append(" subAppid:");
      ((StringBuilder)localObject2).append(paramLong2);
      ((StringBuilder)localObject2).append(" Seq:");
      ((StringBuilder)localObject2).append(localt.h);
      util.LOGI(((StringBuilder)localObject2).toString(), paramString);
      paramInt1 = util.get_saved_network_type(this.mContext);
      t.E = util.get_network_type(this.mContext);
      if (paramInt1 != t.E)
      {
        util.set_net_retry_type(this.mContext, 0);
        util.save_network_type(this.mContext, t.E);
      }
      t.G = util.get_apn_string(this.mContext).getBytes();
      if (!util.check_uin_account(paramString).booleanValue())
      {
        paramWUserSigInfo = new StringBuilder();
        paramWUserSigInfo.append("userAccount ");
        paramWUserSigInfo.append(paramString);
        paramWUserSigInfo.append(" isn't valid");
        util.LOGI(paramWUserSigInfo.toString(), "");
        return -1017;
      }
      long l1 = Long.parseLong(paramString);
      paramWUserSigInfo.uin = paramString;
      localt.g = paramString;
      localt.f = l1;
      ((async_context)localObject1)._sappid = paramLong1;
      ((async_context)localObject1)._appid = paramLong1;
      ((async_context)localObject1)._sub_appid_list = null;
      ((async_context)localObject1)._sub_appid = paramLong2;
      ((async_context)localObject1)._main_sigmap = i;
      ((async_context)localObject1)._login_bitmap = paramWUserSigInfo._login_bitmap;
      ((async_context)localObject1)._last_err_msg = new ErrMsg();
      if ((paramWUserSigInfo._reserveData != null) && (paramWUserSigInfo._reserveData.length > 3))
      {
        localt.i = util.buf_to_int32(paramWUserSigInfo._reserveData, 0);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("MSF SSO SEQ:");
        ((StringBuilder)localObject2).append(localt.i);
        util.LOGI(((StringBuilder)localObject2).toString(), paramString);
      }
      else
      {
        localt.i = 0;
      }
      localObject2 = t.at;
      Object localObject3 = "";
      ((Reporter)localObject2).add_t2(new report_t2("login", new String(t.D), System.currentTimeMillis(), paramLong1, paramLong2, null));
      if ((oicq.wlogin_sdk.code2d.d.q != null) && (oicq.wlogin_sdk.code2d.d.q.length > 0))
      {
        ((async_context)localObject1)._tmp_pwd = oicq.wlogin_sdk.code2d.d.q;
        ((async_context)localObject1)._tmp_no_pic_sig = oicq.wlogin_sdk.code2d.d.r;
        if ((((async_context)localObject1)._tmp_no_pic_sig != null) && (((async_context)localObject1)._tmp_no_pic_sig.length != 0))
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("no pic sig length ");
          ((StringBuilder)localObject2).append(((async_context)localObject1)._tmp_no_pic_sig.length);
          util.LOGI(((StringBuilder)localObject2).toString(), paramString);
        }
        else
        {
          util.LOGI("no pic sig length is 0", paramString);
        }
        ((async_context)localObject1).tgtQR = oicq.wlogin_sdk.code2d.d.s;
        oicq.wlogin_sdk.code2d.d.q = null;
        oicq.wlogin_sdk.code2d.d.r = null;
        oicq.wlogin_sdk.code2d.d.s = null;
      }
      if ((((async_context)localObject1)._tmp_pwd != null) && (((async_context)localObject1)._tmp_pwd.length >= 16))
      {
        ((async_context)localObject1)._tmp_pwd_type = 1;
        if ((paramWUserSigInfo._in_ksid != null) && (paramWUserSigInfo._in_ksid.length > 0)) {
          localObject2 = (byte[])paramWUserSigInfo._in_ksid.clone();
        } else {
          localObject2 = t.ad;
        }
        if (((async_context)localObject1)._tmp_pwd_type != 0)
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("user:");
          ((StringBuilder)localObject3).append(paramString);
          ((StringBuilder)localObject3).append(" login with qrsig");
          util.LOGI(((StringBuilder)localObject3).toString(), paramString);
          localObject3 = new k(localt, this.mContext);
          ((k)localObject3).g();
          paramInt1 = ((k)localObject3).a(paramLong1, paramLong2, localt.f, 0, t.ag, ((async_context)localObject1)._tmp_pwd, ((async_context)localObject1)._tmp_no_pic_sig, this.mMiscBitmap, this.mSubSigMap, null, i, paramLong2, t.z, 0, 0, 1, (byte[])localObject2, paramWUserSigInfo);
        }
        else
        {
          paramInt1 = 0;
        }
        paramInt2 = paramInt1;
        if (paramInt1 == 204) {
          paramInt2 = new p(localt).a(this.mMiscBitmap, this.mSubSigMap, null, paramWUserSigInfo);
        }
        if ((paramInt2 == 0) || (paramInt2 == 160))
        {
          localObject2 = localt.a(l1, paramLong1);
          if (localObject2 == null) {
            paramInt1 = -1004;
          } else {
            paramWUserSigInfo.get_clone((WloginSigInfo)localObject2);
          }
        }
        else
        {
          paramInt1 = paramInt2;
        }
      }
      else
      {
        paramInt1 = -1016;
      }
      localObject2 = GetUserSigInfoTicket(paramWUserSigInfo, 128);
      paramWUserSigInfo = (WUserSigInfo)localObject2;
      if (localObject2 == null) {
        paramWUserSigInfo = new Ticket();
      }
      t.at.commit_t2(localt.f, localt.g, util.format_ret_code(paramInt1), paramInt1);
      if (paramInt1 == 0)
      {
        if ((paramWUserSigInfo._sig != null) && (paramWUserSigInfo._sig.length != 0))
        {
          RequestReport(0, paramWUserSigInfo._sig, paramWUserSigInfo._sig_key, localt.f, ((async_context)localObject1)._appid);
        }
        else
        {
          localObject2 = paramWUserSigInfo;
          paramWUserSigInfo = (WUserSigInfo)localObject1;
          localObject1 = localObject2;
          break label1136;
        }
      }
      else
      {
        localObject3 = paramWUserSigInfo;
        paramInt2 = paramInt1;
        localObject2 = localObject1;
        if ((paramInt2 != 2) && (paramInt2 != 160))
        {
          byte[] arrayOfByte1 = ((Ticket)localObject3)._sig;
          byte[] arrayOfByte2 = ((Ticket)localObject3)._sig_key;
          l1 = localt.f;
          long l2 = ((async_context)localObject2)._appid;
          localObject1 = localObject3;
          paramWUserSigInfo = (WUserSigInfo)localObject2;
          RequestReportError(0, arrayOfByte1, arrayOfByte2, l1, l2, 0);
          break label1136;
        }
      }
      localObject2 = localObject1;
      localObject1 = paramWUserSigInfo;
      paramWUserSigInfo = (WUserSigInfo)localObject2;
      label1136:
      if ((localt.d != null) && (localt.d.get_bitmap() != 0))
      {
        this.mG.d = localt.d;
        RequestReportError(0, ((Ticket)localObject1)._sig, ((Ticket)localObject1)._sig_key, localt.f, paramWUserSigInfo._appid, 1);
      }
      oicq.wlogin_sdk.report.c.a();
      t.b();
      localt.i();
      paramWUserSigInfo = new StringBuilder();
      paramWUserSigInfo.append("end getStWithQrSig user:");
      paramWUserSigInfo.append(paramString);
      paramWUserSigInfo.append(" appid:");
      paramWUserSigInfo.append(paramLong1);
      paramWUserSigInfo.append(" sigMap:0x");
      paramWUserSigInfo.append(Integer.toHexString(i));
      paramWUserSigInfo.append(" subAppid:");
      paramWUserSigInfo.append(paramLong2);
      paramWUserSigInfo.append(" Seq:");
      paramWUserSigInfo.append(localt.h);
      paramWUserSigInfo.append(" ret=");
      paramWUserSigInfo.append(paramInt1);
      paramString = paramWUserSigInfo.toString();
      paramWUserSigInfo = new StringBuilder();
      paramWUserSigInfo.append("");
      paramWUserSigInfo.append(localt.f);
      util.LOGI(paramString, paramWUserSigInfo.toString());
      return paramInt1;
    }
    return -1017;
  }
  
  private int getTicketByGateway(long paramLong1, long paramLong2, int paramInt, WUserSigInfo paramWUserSigInfo, StringBuilder paramStringBuilder, t paramt, async_context paramasync_context)
  {
    paramasync_context._tmp_pwd = MD5.toMD5Byte(paramasync_context._mpasswd.getBytes());
    Object localObject = new k(paramt, this.mContext);
    ((k)localObject).g();
    int i = ((k)localObject).a(paramLong1, paramLong2, paramt.f, 0, t.ag, util.getRequestInitTime(), paramasync_context._tmp_pwd, 4, this.mMiscBitmap, this.mSubSigMap, null, paramInt, paramLong2, t.z, 0, 0, 1, t.ad, paramWUserSigInfo);
    paramStringBuilder.append(",retPasswd =");
    paramStringBuilder.append(i);
    paramInt = i;
    if (i == 204)
    {
      paramInt = new p(paramt).a(this.mMiscBitmap, this.mSubSigMap, null, paramWUserSigInfo);
      paramStringBuilder.append("，devlock = ");
      paramStringBuilder.append(paramInt);
    }
    if (paramInt != 0)
    {
      paramStringBuilder.append(",fail");
      util.LOGI(paramStringBuilder.toString(), "");
      return -2005;
    }
    localObject = paramt.a(paramt.f, paramLong1);
    if (localObject == null)
    {
      paramStringBuilder.append(",info == null");
      util.LOGI(paramStringBuilder.toString(), "");
      return -1004;
    }
    paramWUserSigInfo.get_clone((WloginSigInfo)localObject);
    paramStringBuilder = GetUserSigInfoTicket(paramWUserSigInfo, 128);
    paramWUserSigInfo = paramStringBuilder;
    if (paramStringBuilder == null) {
      paramWUserSigInfo = new Ticket();
    }
    t.at.commit_t2(paramt.f, paramt.g, util.format_ret_code(paramInt), paramInt);
    if (paramInt == 0)
    {
      if ((paramWUserSigInfo._sig != null) && (paramWUserSigInfo._sig.length != 0)) {
        RequestReport(0, paramWUserSigInfo._sig, paramWUserSigInfo._sig_key, paramt.f, paramasync_context._appid);
      }
    }
    else if ((paramInt != 2) && (paramInt != 160)) {
      RequestReportError(0, paramWUserSigInfo._sig, paramWUserSigInfo._sig_key, paramt.f, paramasync_context._appid, 0);
    }
    paramStringBuilder = paramt;
    if ((paramStringBuilder.d != null) && (paramStringBuilder.d.get_bitmap() != 0))
    {
      this.mG.d = paramStringBuilder.d;
      RequestReportError(0, paramWUserSigInfo._sig, paramWUserSigInfo._sig_key, paramStringBuilder.f, paramasync_context._appid, 1);
    }
    oicq.wlogin_sdk.report.c.a();
    t.b();
    paramt.i();
    return 0;
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
  
  private boolean isGateWay(WUserSigInfo paramWUserSigInfo)
  {
    boolean bool;
    if (paramWUserSigInfo.businessType == 2) {
      bool = true;
    } else {
      bool = false;
    }
    paramWUserSigInfo = new StringBuilder();
    paramWUserSigInfo.append("quickLoginByGateway isGateWay = ");
    paramWUserSigInfo.append(bool);
    util.LOGI(paramWUserSigInfo.toString());
    return bool;
  }
  
  private int isPskeyExpired(int paramInt1, String[] paramArrayOfString, Ticket paramTicket, long paramLong, int paramInt2)
  {
    if ((paramInt1 == 1048576) && (paramArrayOfString != null) && (paramArrayOfString.length > 0))
    {
      int i1 = paramArrayOfString.length;
      int k = 0;
      int j;
      for (paramInt1 = 0;; paramInt1 = j)
      {
        int n = 1;
        if (k >= i1) {
          break;
        }
        String str2 = paramArrayOfString[k];
        j = paramInt1;
        if (str2 != null) {
          if (str2.length() == 0)
          {
            j = paramInt1;
          }
          else
          {
            i = str2.indexOf('(');
            int m = str2.indexOf(')');
            Object localObject1;
            if ((i == 0) && (m > 0))
            {
              j = Integer.valueOf(str2.substring(i + 1, m)).intValue();
              if ((j & 0x100000) > 0) {
                i = 1;
              } else {
                i = 0;
              }
              if ((j & 0x8000000) > 0) {
                j = 1;
              } else {
                j = 0;
              }
              localObject1 = str2.substring(m + 1);
            }
            else
            {
              localObject1 = str2;
              j = 0;
              i = 1;
            }
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("isPskeyExpired domain ");
            localStringBuilder.append((String)localObject1);
            localStringBuilder.append(" req_pskey:");
            String str1 = "0";
            Object localObject2;
            if (i != 0) {
              localObject2 = "1";
            } else {
              localObject2 = "0";
            }
            localStringBuilder.append((String)localObject2);
            localStringBuilder.append(" req_pt4t:");
            if (j != 0) {
              localObject2 = "1";
            } else {
              localObject2 = "0";
            }
            localStringBuilder.append((String)localObject2);
            util.LOGI(localStringBuilder.toString(), "");
            if ((i != 0) && ((paramTicket._pskey_map.get(localObject1) == null) || (Ticket.isPskeyExpired(((Long)paramTicket._pskey_expire.get(localObject1)).longValue())))) {
              i = 1;
            } else {
              i = 0;
            }
            if (j != 0)
            {
              m = n;
              if (paramTicket._pt4token_map.get(localObject1) == null) {
                break label388;
              }
              if (Ticket.isPskeyExpired(((Long)paramTicket._pt4token_expire.get(localObject1)).longValue()))
              {
                m = n;
                break label388;
              }
            }
            m = 0;
            label388:
            if (i == 0)
            {
              j = paramInt1;
              if (m == 0) {}
            }
            else
            {
              paramArrayOfString[paramInt1] = str2;
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("PskeyExpired:");
              ((StringBuilder)localObject2).append((String)localObject1);
              ((StringBuilder)localObject2).append("pskey:");
              if (i != 0) {
                localObject1 = "1";
              } else {
                localObject1 = "0";
              }
              ((StringBuilder)localObject2).append((String)localObject1);
              ((StringBuilder)localObject2).append(",pt4t:");
              localObject1 = str1;
              if (m != 0) {
                localObject1 = "1";
              }
              ((StringBuilder)localObject2).append((String)localObject1);
              util.LOGI(((StringBuilder)localObject2).toString(), "");
              j = paramInt1 + 1;
            }
          }
        }
        k += 1;
      }
      int i = paramInt1;
      if (paramInt1 == 0) {
        return 3;
      }
      while (i < paramArrayOfString.length)
      {
        paramTicket = new StringBuilder();
        paramTicket.append("isPskeyExpired domain ");
        paramTicket.append(paramArrayOfString[i]);
        paramTicket.append(" cleared");
        util.LOGI(paramTicket.toString(), "");
        paramArrayOfString[i] = null;
        i += 1;
      }
      if (paramInt2 == 1) {
        return 1;
      }
      RefreshMemorySig();
      return 2;
    }
    return 0;
  }
  
  private void localInit(Context paramContext, boolean paramBoolean)
  {
    this.isForLocal = paramBoolean;
    try
    {
      this.mContext = paramContext.getApplicationContext();
    }
    catch (Throwable localThrowable)
    {
      this.mContext = paramContext;
      util.printThrowable(localThrowable, "");
    }
    this.mG.b(paramContext);
    RequestInit();
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("a1 ");
    localStringBuilder.append(paramWloginSigInfo._en_A1.length);
    util.LOGI(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("a2 ");
    localStringBuilder.append(paramWloginSigInfo._TGT.length);
    util.LOGI(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("skey ");
    localStringBuilder.append(paramWloginSigInfo._sKey.length);
    util.LOGI(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("pskey ");
    localStringBuilder.append(paramWloginSigInfo._psKey.length);
    util.LOGI(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("superkey ");
    localStringBuilder.append(paramWloginSigInfo._superKey.length);
    util.LOGI(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("d2 ");
    localStringBuilder.append(paramWloginSigInfo._D2.length);
    util.LOGI(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("d2key ");
    localStringBuilder.append(paramWloginSigInfo._D2Key.length);
    util.LOGI(localStringBuilder.toString());
  }
  
  private int quickLoginByGateway(long paramLong1, long paramLong2, int paramInt1, WUserSigInfo paramWUserSigInfo, int paramInt2)
  {
    if (paramInt2 == 0)
    {
      new WtloginHelper.HelperThread(this, this, this.mHelperHandler, paramLong1, paramLong2, paramInt1, paramWUserSigInfo, "quickLoginByWeChat").RunReq(19);
      return -1001;
    }
    StringBuilder localStringBuilder = new StringBuilder("quickLoginByGateway ");
    localStringBuilder.append(util.LOG_TAG_GATEWAY_LOGIN_NEW_DOV);
    if (paramWUserSigInfo == null)
    {
      localStringBuilder.append(",userSigInfo == null");
      paramWUserSigInfo = new WUserSigInfo();
    }
    t localt = this.mG.a(0L);
    paramWUserSigInfo._seqence = localt.h;
    paramInt1 |= 0x400C0;
    async_context localasync_context = t.b(localt.h);
    localasync_context._mpasswd = util.get_mpasswd();
    localasync_context._msalt = util.constructSalt();
    localasync_context._sappid = paramLong1;
    localasync_context._appid = paramLong1;
    localasync_context._sub_appid = paramLong2;
    localasync_context._main_sigmap = paramInt1;
    localStringBuilder.append(",seq=");
    localStringBuilder.append(localt.h);
    localStringBuilder.append(",_mpasswd=");
    localStringBuilder.append(localasync_context._mpasswd);
    localStringBuilder.append(",_msalt=");
    localStringBuilder.append(Long.toHexString(localasync_context._msalt));
    localStringBuilder.append(",_appid=");
    localStringBuilder.append(localasync_context._appid);
    localStringBuilder.append(",_sub_appid=");
    localStringBuilder.append(localasync_context._sappid);
    localStringBuilder.append(",_sappid=");
    localStringBuilder.append(localasync_context._sub_appid);
    localStringBuilder.append(",dwMainSigMap=");
    localStringBuilder.append(localasync_context._main_sigmap);
    paramInt2 = new u(localt).a(paramWUserSigInfo);
    localStringBuilder.append(",tlv104=");
    localStringBuilder.append(localasync_context._t104.get_data_len());
    localStringBuilder.append(",ret=");
    localStringBuilder.append(paramInt2);
    if (paramInt2 != 0)
    {
      util.LOGI(localStringBuilder.toString(), "");
      return paramInt2;
    }
    localStringBuilder.append(",uin=");
    localStringBuilder.append(localasync_context._uin);
    paramWUserSigInfo.uin = String.valueOf(localasync_context._uin);
    paramWUserSigInfo.extraLoginTLVMap.put(new Integer(260), localasync_context._t104);
    localasync_context._t104 = new tlv_t104();
    paramInt1 = getTicketByGateway(paramLong1, paramLong2, paramInt1, paramWUserSigInfo, localStringBuilder, localt, localasync_context);
    util.LOGI(localStringBuilder.toString(), "");
    return paramInt1;
  }
  
  public static void setCustomerGuid(Context paramContext, byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("set customer guid ");
    localStringBuilder.append(util.buf_to_string(paramArrayOfByte));
    util.LOGI(localStringBuilder.toString(), "");
    t.al = paramArrayOfByte;
    util.saveGuidToFile(paramContext, paramArrayOfByte);
  }
  
  public static void setExtraLoginTlvValue(WUserSigInfo paramWUserSigInfo, int paramInt, byte[] paramArrayOfByte)
  {
    Integer localInteger = new Integer(paramInt);
    tlv_t localtlv_t = new tlv_t(paramInt);
    localtlv_t.set_data(paramArrayOfByte, paramArrayOfByte.length);
    paramWUserSigInfo.extraLoginTLVMap.put(localInteger, localtlv_t);
    int i = paramArrayOfByte[0];
    paramArrayOfByte = new StringBuilder();
    paramArrayOfByte.append("setExtraLoginTlvValue tag:");
    paramArrayOfByte.append(paramInt);
    paramArrayOfByte.append(" value[0]: ");
    paramArrayOfByte.append(i & 0xFF);
    util.LOGI(paramArrayOfByte.toString(), paramWUserSigInfo.uin);
  }
  
  private static void setExtraProductLoginTlvValue(WUserSigInfo paramWUserSigInfo, int paramInt, byte[] paramArrayOfByte)
  {
    tlv_t localtlv_t = new tlv_t(paramInt);
    localtlv_t.set_data(paramArrayOfByte, paramArrayOfByte.length);
    paramWUserSigInfo._loginExtraProductTLVMap.put(Integer.valueOf(paramInt), localtlv_t);
    int i = paramArrayOfByte[0];
    paramArrayOfByte = new StringBuilder();
    paramArrayOfByte.append("setExtraProductLoginTlvValue tag:");
    paramArrayOfByte.append(paramInt);
    paramArrayOfByte.append(" value[0]: ");
    paramArrayOfByte.append(i & 0xFF);
    util.LOGI(paramArrayOfByte.toString(), paramWUserSigInfo.uin);
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
    t.ay = paramBoolean;
  }
  
  public static void setProductType(int paramInt)
  {
    t.aA = paramInt;
  }
  
  public static void setQimeiListener(QimeiListener paramQimeiListener)
  {
    util.qimeiListener = paramQimeiListener;
  }
  
  public static void setRegisterFlg(int paramInt)
  {
    t.ak = paramInt | t.ak;
  }
  
  public static void setReportListener(ReportListener paramReportListener)
  {
    oicq.wlogin_sdk.report.c.a(paramReportListener);
  }
  
  public static void setSecTransInfo(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    t.aB = paramString1;
    t.aC = paramString2;
    t.aD = paramInt;
    t.aE = paramString3;
  }
  
  private void tlvCommRsp2ErrMsg(TLV_CommRsp paramTLV_CommRsp, ErrMsg paramErrMsg)
  {
    if (paramTLV_CommRsp != null)
    {
      if (paramTLV_CommRsp.get_data_len() == 0) {
        return;
      }
      paramErrMsg.setType(paramTLV_CommRsp.ErrInfoType);
      paramErrMsg.setOtherinfo(new String(paramTLV_CommRsp.ErrInfo));
      paramErrMsg.setTitle(new String(paramTLV_CommRsp.ErrTitle));
      paramErrMsg.setMessage(new String(paramTLV_CommRsp.ErrMsg));
    }
  }
  
  public int AskDevLockSms(String paramString, long paramLong1, long paramLong2, WUserSigInfo paramWUserSigInfo)
  {
    int i = -1017;
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
    if (localTransReqContext._body != null)
    {
      if (localTransReqContext._body.length == 0) {
        return -1017;
      }
      i = RequestTransport(0, 1, paramString, paramLong1, ((oicq.wlogin_sdk.devicelock.d)localObject).Role, localTransReqContext, paramWUserSigInfo);
    }
    return i;
  }
  
  public void CancelRequest()
  {
    this.mG.t = 1;
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
    localObject2 = t.B;
    byte[] arrayOfByte1 = t.F;
    byte[] arrayOfByte2 = "6.0.0.2473".getBytes();
    byte[] arrayOfByte3 = "android".getBytes();
    paramArrayOfByte = paramArrayOfByte.getBytes();
    if (paramString2 == null) {
      paramString2 = null;
    } else {
      paramString2 = paramString2.getBytes();
    }
    localTransReqContext._body = localf.a(l, paramLong1, paramLong2, (byte[])localObject1, (byte[])localObject2, arrayOfByte1, arrayOfByte2, arrayOfByte3, paramArrayOfByte, paramString2);
    if (localTransReqContext._body != null)
    {
      if (localTransReqContext._body.length == 0) {
        return -1017;
      }
      return RequestTransport(0, 1, paramString1, paramLong1, localf.Role, localTransReqContext, paramWUserSigInfo);
    }
    return -1017;
  }
  
  public int CheckDevLockStatus(String paramString, long paramLong1, long paramLong2, WUserSigInfo paramWUserSigInfo)
  {
    int i = -1017;
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
    localTransReqContext._body = locala.a(l, paramLong1, paramLong2, ((WloginSigInfo)localObject)._TGT, t.B, t.F, "6.0.0.2473".getBytes(), t.L, t.K);
    if (localTransReqContext._body != null)
    {
      if (localTransReqContext._body.length == 0) {
        return -1017;
      }
      i = RequestTransport(0, 1, paramString, paramLong1, locala.Role, localTransReqContext, paramWUserSigInfo);
    }
    return i;
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
    return CheckSMSAndGetSt(paramString, paramArrayOfByte, paramWUserSigInfo, (byte[][])null, null, 0);
  }
  
  public int CheckSMSAndGetSt(String paramString, byte[] paramArrayOfByte1, WUserSigInfo paramWUserSigInfo, byte[][] paramArrayOfByte, byte[] paramArrayOfByte2)
  {
    return CheckSMSAndGetSt(paramString, paramArrayOfByte1, paramWUserSigInfo, paramArrayOfByte, paramArrayOfByte2, 0);
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("user:");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" appid:");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(" ClearPSkey ...");
    util.LOGI(localStringBuilder.toString(), paramString);
    if (paramString != null)
    {
      if (paramString.length() <= 0) {
        return;
      }
      int i = 1;
      try
      {
        long l1;
        if (!util.check_uin_account(paramString).booleanValue())
        {
          long l2 = this.mG.b(paramString);
          l1 = l2;
          if (l2 == 0L)
          {
            i = 0;
            l1 = l2;
          }
        }
        else
        {
          l1 = Long.parseLong(paramString);
        }
        if (i != 0) {
          this.mG.d(l1, paramLong);
        }
        return;
      }
      finally {}
    }
  }
  
  public Boolean ClearUserLoginData(String paramString, long paramLong)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("user:");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" appid:");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append(" ClearUserLoginData ...");
    util.LOGI(((StringBuilder)localObject).toString(), paramString);
    localObject = Boolean.valueOf(true);
    if (paramString != null) {
      if (paramString.length() <= 0) {
        return localObject;
      }
    }
    for (;;)
    {
      try
      {
        long l;
        if (!util.check_uin_account(paramString).booleanValue())
        {
          l = this.mG.b(paramString);
          if (l == 0L)
          {
            i = 0;
          }
          else
          {
            this.mG.d(paramString);
            break label174;
          }
        }
        else
        {
          l = Long.parseLong(paramString);
          break label174;
        }
        if (i == 1) {
          this.mG.e(l, paramLong);
        }
        WloginSigInfo._QRPUSHSig = new byte[0];
        WloginSigInfo._LHSig = new byte[0];
        return localObject;
      }
      finally {}
      return localObject;
      label174:
      int i = 1;
    }
  }
  
  public int CloseCode(String paramString, long paramLong, byte[] paramArrayOfByte, int paramInt, List<byte[]> paramList, WUserSigInfo paramWUserSigInfo)
  {
    Object localObject1 = new WloginSimpleInfo();
    if (!GetBasicUserInfo(paramString, (WloginSimpleInfo)localObject1).booleanValue()) {
      return -1003;
    }
    long l = ((WloginSimpleInfo)localObject1)._uin;
    this.mG.k();
    localObject1 = FindUserSig(l, paramLong);
    if (localObject1 == null) {
      return -1004;
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("user:");
    ((StringBuilder)localObject2).append(paramString);
    ((StringBuilder)localObject2).append(" CloseCode ...");
    util.LOGI(((StringBuilder)localObject2).toString(), paramString);
    localObject2 = new oicq.wlogin_sdk.code2d.b();
    TransReqContext localTransReqContext = new TransReqContext();
    localTransReqContext.set_code2d_func_req();
    localTransReqContext.set_subcmd(((oicq.wlogin_sdk.code2d.b)localObject2).get_cmd());
    localTransReqContext.setSTEncryptMethod();
    localTransReqContext.setWtST((WloginSigInfo)localObject1);
    localTransReqContext._body = ((oicq.wlogin_sdk.code2d.b)localObject2).a(l, paramLong, 1L, paramArrayOfByte, ((WloginSigInfo)localObject1)._TGT, t.B, paramInt, paramList, ((WloginSigInfo)localObject1)._en_A1, ((WloginSigInfo)localObject1)._noPicSig, this.mMiscBitmap, 0L);
    return RequestTransport(0, 1, paramString, paramLong, ((oicq.wlogin_sdk.code2d.b)localObject2)._role, localTransReqContext, paramWUserSigInfo);
  }
  
  public int CloseDevLock(String paramString, long paramLong1, long paramLong2, WUserSigInfo paramWUserSigInfo)
  {
    int i = -1017;
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
    localTransReqContext._body = localb.a(l, paramLong1, paramLong2, localWloginSigInfo._TGT, t.B, t.F, "6.0.0.2473".getBytes(), "android".getBytes(), ((String)localObject).getBytes());
    if (localTransReqContext._body != null)
    {
      if (localTransReqContext._body.length == 0) {
        return -1017;
      }
      i = RequestTransport(0, 1, paramString, paramLong1, localb.Role, localTransReqContext, paramWUserSigInfo);
    }
    return i;
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
    if ((localTicket != null) && (localTicket._sig != null) && (localTicket._sig.length > 0) && (localTicket._sig_key != null))
    {
      if (localTicket._sig_key.length <= 0) {
        return null;
      }
      if (t.C != null)
      {
        if (t.C.length <= 0) {
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
        System.arraycopy(localTicket._sig_key, 0, arrayOfByte, i + 2, localTicket._sig_key.length);
        i = localTicket._sig_key.length;
        return cryptor.encrypt(arrayOfByte, 0, arrayOfByte.length, t.C);
      }
    }
    return null;
  }
  
  public List<WloginLoginInfo> GetAllLoginInfo()
  {
    return this.mG.l();
  }
  
  public long GetAppidFromUrl(String paramString)
  {
    long l = -1L;
    if (paramString == null) {
      return -1L;
    }
    int i = paramString.indexOf("f=");
    String str;
    if (i != -1)
    {
      i += 2;
      if (i >= paramString.length()) {
        return -1L;
      }
      str = "";
      while ((i < paramString.length()) && (paramString.charAt(i) != '&'))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append(paramString.charAt(i));
        str = localStringBuilder.toString();
        i += 1;
      }
    }
    try
    {
      l = Long.parseLong(str);
      return l;
    }
    catch (Exception paramString) {}
    return -1L;
  }
  
  public Boolean GetBasicUserInfo(String paramString, WloginSimpleInfo paramWloginSimpleInfo)
  {
    boolean bool = false;
    if (paramString == null) {
      return Boolean.valueOf(false);
    }
    long l1;
    if (!util.check_uin_account(paramString).booleanValue())
    {
      long l2 = this.mG.b(paramString);
      l1 = l2;
      if (l2 == 0L)
      {
        i = 0;
        l1 = l2;
        break label60;
      }
    }
    else
    {
      l1 = Long.parseLong(paramString);
    }
    int i = 1;
    label60:
    int j = i;
    if (i == 1)
    {
      paramString = this.mG.d(l1);
      if (paramString == null)
      {
        j = 0;
      }
      else
      {
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
      }
    }
    if (j == 1) {
      bool = true;
    }
    return Boolean.valueOf(bool);
  }
  
  public Boolean GetBasicUserInfoForQQLoginInQimOnly(WUserSigInfo paramWUserSigInfo, WloginSimpleInfo paramWloginSimpleInfo)
  {
    long l = Long.parseLong(paramWUserSigInfo.uin);
    paramWUserSigInfo = this.mG.d(l);
    boolean bool = false;
    int i;
    if (paramWUserSigInfo == null)
    {
      i = 0;
    }
    else
    {
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
    }
    if (i == 1) {
      bool = true;
    }
    return Boolean.valueOf(bool);
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
    Object localObject2 = t.a(this.mContext);
    if (localObject2 != null) {
      return localObject2;
    }
    Object localObject1 = localObject2;
    if (t.B != null)
    {
      localObject1 = localObject2;
      if (t.B.length > 0)
      {
        localObject1 = new byte[t.B.length];
        System.arraycopy(t.B, 0, localObject1, 0, t.B.length);
      }
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("get guid ");
    ((StringBuilder)localObject2).append(util.buf_to_string((byte[])localObject1));
    util.LOGI(((StringBuilder)localObject2).toString(), "");
    return localObject1;
  }
  
  public WloginLastLoginInfo GetLastLoginInfo()
  {
    Object localObject = this.mG.l();
    if (localObject == null) {
      return null;
    }
    Iterator localIterator = ((List)localObject).iterator();
    localObject = null;
    if (localIterator.hasNext())
    {
      WloginLoginInfo localWloginLoginInfo = (WloginLoginInfo)localIterator.next();
      if (localObject == null) {}
      for (;;)
      {
        localObject = localWloginLoginInfo;
        break;
        if (localWloginLoginInfo.mCreateTime <= ((WloginLoginInfo)localObject).mCreateTime) {
          break;
        }
      }
    }
    if (localObject == null) {
      return null;
    }
    if ((((WloginLoginInfo)localObject).mAccount != null) && (((WloginLoginInfo)localObject).mAccount.length() > 0)) {
      return new WloginLastLoginInfo(((WloginLoginInfo)localObject).mAccount, ((WloginLoginInfo)localObject).mUin);
    }
    return new WloginLastLoginInfo(String.valueOf(((WloginLoginInfo)localObject).mUin), ((WloginLoginInfo)localObject).mUin);
  }
  
  public WUserSigInfo GetLocalSig(String paramString, long paramLong)
  {
    if (paramString == null)
    {
      util.LOGI("userAccount null", "");
      return null;
    }
    WUserSigInfo localWUserSigInfo;
    try
    {
      long l1;
      if (!util.check_uin_account(paramString).booleanValue())
      {
        long l2 = this.mG.b(paramString);
        l1 = l2;
        if (l2 == 0L) {
          return null;
        }
      }
      else
      {
        l1 = Long.parseLong(paramString);
      }
      WloginSigInfo localWloginSigInfo = this.mG.a(l1, paramLong);
      if (localWloginSigInfo != null)
      {
        localWUserSigInfo = new WUserSigInfo();
        try
        {
          localWUserSigInfo.uin = paramString;
          localWUserSigInfo.get_clone(localWloginSigInfo);
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("skey in sigInfo ");
          localStringBuilder.append(util.getMaskBytes(localWloginSigInfo._sKey, 2, 2));
          util.LOGI(localStringBuilder.toString(), paramString);
          return localWUserSigInfo;
        }
        catch (Exception localException1) {}
      }
      else
      {
        return null;
      }
    }
    catch (Exception localException2)
    {
      localWUserSigInfo = null;
      util.printException(localException2, paramString);
    }
    return localWUserSigInfo;
  }
  
  public Ticket GetLocalTicket(String paramString, long paramLong, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GetLocalTicket appid ");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(" type 0x");
    localStringBuilder.append(String.format("%x", new Object[] { Integer.valueOf(paramInt) }));
    util.LOGI(localStringBuilder.toString(), paramString);
    if (paramString == null)
    {
      util.LOGI("userAccount null", "");
      return null;
    }
    return GetUserSigInfoTicket(GetLocalSig(paramString, paramLong), paramInt);
  }
  
  public int GetOpenKeyWithoutPasswd(String paramString, long paramLong1, long paramLong2, int paramInt, WUserSigInfo paramWUserSigInfo)
  {
    long l = this.mOpenAppid;
    byte[][] arrayOfByte = (byte[][])null;
    return GetStWithoutPasswd(paramString, paramLong1, l, -1L, paramInt, paramLong2, null, paramWUserSigInfo, arrayOfByte, arrayOfByte, 0, null);
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
    if ((paramString != null) && (paramString.length > 3))
    {
      int i = 0;
      int k = util.buf_to_int32(paramString, 0);
      int j = 4;
      while (i < k)
      {
        int n = paramString.length;
        int m = j + 1;
        if (n < m) {
          break;
        }
        n = util.buf_to_int8(paramString, j);
        int i1 = paramString.length;
        j = m + n;
        if (i1 < j) {
          break;
        }
        String str1 = new String(paramString, m, n);
        if (paramString.length < j + 2) {
          break;
        }
        m = util.buf_to_int32(paramString, j);
        n = j + 4;
        i1 = paramString.length;
        j = n + m;
        if (i1 < j) {
          break;
        }
        String str2 = new String(paramString, n, m);
        if (str1.equals("pic_reason")) {
          return str2;
        }
        i += 1;
      }
    }
    return "";
  }
  
  public Ticket GetPskey(String paramString, long paramLong, String[] arg4, WtTicketPromise paramWtTicketPromise)
  {
    Bundle localBundle = new Bundle();
    localBundle.putStringArray("domains", ???);
    String str = "";
    int i = 0;
    StringBuilder localStringBuilder;
    while (i < ???.length)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(???[i]);
      localStringBuilder.append(",");
      str = localStringBuilder.toString();
      i += 1;
    }
    synchronized (GET_TICKET_LOCK)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("GetPskey appid ");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(" domains ");
      localStringBuilder.append(str);
      util.LOGI(localStringBuilder.toString(), paramString);
      paramString = GetTicket(paramString, paramLong, 1048576, paramWtTicketPromise, localBundle);
      return paramString;
    }
    for (;;)
    {
      throw paramString;
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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("user:");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" GetStViaSMSVerifyLogin ...");
    util.LOGI(((StringBuilder)localObject).toString(), paramString);
    if (oicq.wlogin_sdk.a.k.y) {
      localObject = oicq.wlogin_sdk.a.k.A;
    } else {
      localObject = "";
    }
    return GetStWithPasswd(paramString, paramLong1, paramInt, paramLong2, null, false, (String)localObject, paramWUserSigInfo, (byte[][])null, true, 0);
  }
  
  public int GetStViaSMSVerifyLogin(String paramString, long paramLong1, long paramLong2, long[] paramArrayOfLong, int paramInt, WUserSigInfo paramWUserSigInfo)
  {
    Object localObject2 = (byte[][])null;
    Object localObject1 = localObject2;
    if (paramArrayOfLong != null)
    {
      localObject1 = localObject2;
      if (paramArrayOfLong.length > 0) {
        localObject1 = (byte[][])Array.newInstance(Byte.TYPE, new int[] { paramArrayOfLong.length, 0 });
      }
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("user:");
    ((StringBuilder)localObject2).append(paramString);
    ((StringBuilder)localObject2).append(" GetStViaSMSVerifyLogin ...");
    util.LOGI(((StringBuilder)localObject2).toString(), paramString);
    if (oicq.wlogin_sdk.a.k.y) {
      localObject2 = oicq.wlogin_sdk.a.k.A;
    } else {
      localObject2 = "";
    }
    return GetStWithPasswd(paramString, paramLong1, paramInt, paramLong2, paramArrayOfLong, false, (String)localObject2, paramWUserSigInfo, (byte[][])localObject1, true, 0);
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
    byte[][] arrayOfByte = (byte[][])null;
    return GetStWithoutPasswd(paramString, paramLong1, paramLong2, -1L, paramInt, paramLong3, null, paramWUserSigInfo, arrayOfByte, arrayOfByte, 0, null);
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
    int i = this.mMainSigMap;
    byte[][] arrayOfByte = (byte[][])null;
    return GetStWithoutPasswd(paramString, paramLong1, paramLong2, -1L, i, 1L, null, paramWUserSigInfo, arrayOfByte, arrayOfByte, 0, null);
  }
  
  public int GetStWithoutPasswd(byte[] paramArrayOfByte, long paramLong, int paramInt, WUserSigInfo paramWUserSigInfo)
  {
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length <= 0) {
        return -1017;
      }
      Object localObject = cryptor.decrypt(paramArrayOfByte, 0, paramArrayOfByte.length, t.C);
      if (localObject != null)
      {
        if (localObject.length <= 0) {
          return -1017;
        }
        if (2 > localObject.length) {
          return -1017;
        }
        int j = util.buf_to_int16((byte[])localObject, 0);
        if (j > 0)
        {
          int i = 2 + j;
          if (i > localObject.length) {
            return -1017;
          }
          paramArrayOfByte = new String((byte[])localObject, 2, j);
          j = i + 8;
          if (j > localObject.length) {
            return -1017;
          }
          long l = util.buf_to_int64((byte[])localObject, i);
          i = j + 2;
          if (i > localObject.length) {
            return -1017;
          }
          int k = util.buf_to_int16((byte[])localObject, j);
          if (k > 0)
          {
            j = i + k;
            if (j > localObject.length) {
              return -1017;
            }
            byte[] arrayOfByte1 = new byte[k];
            System.arraycopy(localObject, i, arrayOfByte1, 0, arrayOfByte1.length);
            i = j + 2;
            if (i > localObject.length) {
              return -1017;
            }
            j = util.buf_to_int16((byte[])localObject, j);
            if (j > 0)
            {
              if (i + j > localObject.length) {
                return -1017;
              }
              byte[] arrayOfByte2 = new byte[j];
              System.arraycopy(localObject, i, arrayOfByte2, 0, arrayOfByte2.length);
              localObject = new byte[3][];
              localObject[0] = new byte[1];
              localObject[0][0] = 2;
              localObject[1] = arrayOfByte1;
              localObject[2] = arrayOfByte2;
              return GetStWithoutPasswd(paramArrayOfByte, l, paramLong, -1L, paramInt, 1L, null, paramWUserSigInfo, (byte[][])null, (byte[][])localObject, 0, null);
            }
          }
        }
      }
    }
    return -1017;
  }
  
  public Ticket GetTicket(String paramString, long paramLong, int paramInt, WtTicketPromise paramWtTicketPromise, Bundle paramBundle)
  {
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("GetTicket ");
    ((StringBuilder)localObject2).append(paramString);
    ((StringBuilder)localObject2).append(", ");
    ((StringBuilder)localObject2).append(paramLong);
    ((StringBuilder)localObject2).append(" sig ");
    ((StringBuilder)localObject2).append(Integer.toHexString(paramInt));
    ((StringBuilder)localObject2).append(" ");
    if (paramBundle == null) {
      localObject1 = "null";
    } else {
      localObject1 = Integer.valueOf(paramBundle.size());
    }
    ((StringBuilder)localObject2).append(localObject1);
    util.LOGI(((StringBuilder)localObject2).toString(), "");
    Object localObject1 = null;
    int j = 2;
    int k;
    label421:
    label425:
    label454:
    do
    {
      localObject2 = GetLocalSig(paramString, paramLong);
      if (localObject2 == null)
      {
        if (j == 1) {
          break;
        }
        RefreshMemorySig();
        i = j - 1;
        localObject2 = localObject1;
      }
      else
      {
        Ticket localTicket = GetUserSigInfoTicket((WUserSigInfo)localObject2, paramInt);
        if ((localTicket != null) && (localTicket._sig != null) && (localTicket._sig.length != 0))
        {
          long l = t.f();
          localObject2 = localObject1;
          if (paramBundle != null)
          {
            localObject2 = localObject1;
            if (paramInt == 1048576) {
              localObject2 = paramBundle.getStringArray("domains");
            }
          }
          k = isPskeyExpired(paramInt, (String[])localObject2, localTicket, l, j);
          if (k != 1) {
            if (k != 2) {}
          }
          for (;;)
          {
            i = j - 1;
            break label454;
            i = j;
            if (k == 3) {
              return localTicket;
            }
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("GetTicket sigType:0x");
            ((StringBuilder)localObject1).append(Integer.toHexString(paramInt));
            ((StringBuilder)localObject1).append(" expires in ");
            ((StringBuilder)localObject1).append((localTicket._expire_time - l) / 60L / 60L);
            ((StringBuilder)localObject1).append("h");
            util.LOGI(((StringBuilder)localObject1).toString(), "");
            if (paramInt == 4096)
            {
              if (true == Ticket.isSkeyExpired(localTicket._expire_time))
              {
                if (i != 1)
                {
                  RefreshMemorySig();
                  break label425;
                }
              }
              else {
                return localTicket;
              }
            }
            else
            {
              if (l < localTicket._expire_time) {
                break;
              }
              if (i != 1) {
                break label421;
              }
            }
            localObject1 = localObject2;
            break label471;
            RefreshMemorySig();
          }
          return localTicket;
        }
        if (j == 1) {
          break;
        }
        RefreshMemorySig();
        i = j - 1;
        localObject2 = localObject1;
      }
      localObject1 = localObject2;
      j = i;
    } while (i > 0);
    localObject1 = localObject2;
    label471:
    int i = 1;
    if (IsNeedLoginWithPasswd(paramString, paramLong).booleanValue())
    {
      paramBundle = new ErrMsg();
      paramBundle.setType(-1004);
      if (paramWtTicketPromise != null) {
        paramWtTicketPromise.Failed(paramBundle);
      }
    }
    else
    {
      localObject2 = new WUserSigInfo();
      if (paramBundle != null) {
        i = paramBundle.getInt("subappid", 1);
      }
      if (localObject1 != null)
      {
        j = 0;
        k = Math.min(20, localObject1.length);
        while (j < k)
        {
          paramBundle = localObject1[j];
          if ((paramBundle != null) && (paramBundle.length() > 0)) {
            ((WUserSigInfo)localObject2)._domains.add(paramBundle);
          }
          j += 1;
        }
      }
      GetStWithoutPasswd(paramString, paramLong, paramLong, i, paramInt, (WUserSigInfo)localObject2, new WtloginHelper.1(this, paramString, paramLong, paramInt, paramWtTicketPromise));
    }
    paramWtTicketPromise = new StringBuilder();
    paramWtTicketPromise.append("get null for sigType:0x");
    paramWtTicketPromise.append(Integer.toHexString(paramInt));
    util.LOGI(paramWtTicketPromise.toString(), paramString);
    return null;
  }
  
  public long GetTimeDifference()
  {
    return t.ae;
  }
  
  public Boolean IsNeedLoginWithPasswd(String paramString, long paramLong)
  {
    boolean bool = true;
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
            i = 1;
            continue;
          }
        }
        else
        {
          l1 = Long.parseLong(paramString);
        }
        Object localObject = this.mG.a(l1, paramLong);
        if ((localObject != null) && (((WloginSigInfo)localObject)._en_A1 != null) && (((WloginSigInfo)localObject)._en_A1.length != 0) && (((WloginSigInfo)localObject)._noPicSig != null) && (((WloginSigInfo)localObject)._noPicSig.length != 0))
        {
          bool = false;
          i = 2;
        }
        else
        {
          if ((localObject == null) || (((WloginSigInfo)localObject)._TGT == null) || (((WloginSigInfo)localObject)._TGT.length == 0)) {
            break label243;
          }
          if (!((WloginSigInfo)localObject).iSExpireA2(t.f())) {
            break label234;
          }
          break label243;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("NeedLoginWithPasswd:");
        ((StringBuilder)localObject).append(bool);
        ((StringBuilder)localObject).append(" appid:");
        ((StringBuilder)localObject).append(paramLong);
        ((StringBuilder)localObject).append(" flag=");
        ((StringBuilder)localObject).append(i);
        util.LOGI(((StringBuilder)localObject).toString(), paramString);
        return Boolean.valueOf(bool);
      }
      finally {}
      label234:
      bool = false;
      int i = 0;
      continue;
      label243:
      i = 3;
    }
  }
  
  public Boolean IsUserHaveA1(String paramString, long paramLong)
  {
    Boolean localBoolean = Boolean.valueOf(false);
    if (paramString == null) {
      return localBoolean;
    }
    long l1;
    if (!util.check_uin_account(paramString).booleanValue())
    {
      long l2 = this.mG.b(paramString);
      l1 = l2;
      if (l2 == 0L)
      {
        localObject = null;
        break label68;
      }
    }
    else
    {
      l1 = Long.parseLong(paramString);
    }
    Object localObject = this.mG.a(l1, paramLong);
    label68:
    if ((localObject != null) && (((WloginSigInfo)localObject)._en_A1 != null) && (((WloginSigInfo)localObject)._en_A1.length > 0))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("userAccount:");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" dwAppid:");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(" IsUserHaveA1 return: not null");
      util.LOGI(((StringBuilder)localObject).toString(), paramString);
      return Boolean.valueOf(true);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("userAccount:");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" dwAppid:");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append(" IsUserHaveA1 return: null");
    util.LOGI(((StringBuilder)localObject).toString(), paramString);
    return localBoolean;
  }
  
  public boolean IsWtLoginUrl(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    int i = paramString.indexOf("?k=");
    if (i != -1)
    {
      i += 3;
      int j = i + 32;
      if (j > paramString.length()) {
        return false;
      }
      paramString = paramString.substring(i, j);
      return util.base64_decode_url(paramString.getBytes(), paramString.length()) != null;
    }
    return false;
  }
  
  public byte[] PickupQRCode(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    if (!paramString.matches(".*[?&]k=([^&$]+).*")) {
      return null;
    }
    paramString = paramString.replaceAll(".*[?&]k=([^&$]+).*", "$1");
    return util.base64_decode_url(paramString.getBytes(), paramString.length());
  }
  
  public Intent PrepareQloginIntent(long paramLong1, long paramLong2, String paramString)
  {
    boolean bool1 = util.isMQQExist(this.mContext);
    Object localObject2 = this.mContext;
    Object localObject1 = "com.tencent.minihd.qq";
    boolean bool2 = util.isPackageExist((Context)localObject2, "com.tencent.minihd.qq");
    if (!bool1)
    {
      if (!bool2) {
        return null;
      }
    }
    else {
      localObject1 = "com.tencent.mobileqq";
    }
    Object localObject3 = util.get_rsa_pubkey(this.mContext);
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("qrsig ");
    localStringBuilder.append(util.buf_to_string(oicq.wlogin_sdk.code2d.d.i));
    util.LOGI(localStringBuilder.toString());
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
  
  public int RefreshSMSData(String paramString, long paramLong, WUserSigInfo paramWUserSigInfo, byte[] paramArrayOfByte)
  {
    WUserSigInfo localWUserSigInfo = paramWUserSigInfo;
    if (paramWUserSigInfo == null) {
      localWUserSigInfo = new WUserSigInfo();
    }
    return RefreshSMSData(paramString, paramLong, localWUserSigInfo, paramArrayOfByte, 0);
  }
  
  public int RefreshSMSVerifyLoginCode(String paramString, WUserSigInfo paramWUserSigInfo)
  {
    return RefreshSMSVerifyLoginCode(paramString, paramWUserSigInfo, 0);
  }
  
  public int RegGetAccount(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, byte[] paramArrayOfByte5, int paramInt, WUserSigInfo paramWUserSigInfo)
  {
    return RegGetAccount(paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3, paramArrayOfByte4, paramArrayOfByte5, null, paramInt, paramWUserSigInfo);
  }
  
  public int RegGetAccount(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, byte[] paramArrayOfByte5, byte[] paramArrayOfByte6, int paramInt, WUserSigInfo paramWUserSigInfo)
  {
    if ((paramArrayOfByte3 != null) && (paramArrayOfByte3.length > 0))
    {
      util.LOGI("RegGetAccount ...", "");
      oicq.wlogin_sdk.a.d locald = new oicq.wlogin_sdk.a.d();
      TransReqContext localTransReqContext = new TransReqContext();
      oicq.wlogin_sdk.a.k localk = this.mRegStatus;
      if (paramArrayOfByte1 != null) {
        localk.j = ((byte[])paramArrayOfByte1.clone());
      } else {
        localk.j = new byte[0];
      }
      if ((paramInt == 4) || (paramInt == 5)) {
        localk.b = "";
      }
      oicq.wlogin_sdk.a.k.y = false;
      oicq.wlogin_sdk.a.k.z = 0L;
      localTransReqContext.set_register_req();
      localTransReqContext.set_subcmd(locald.a());
      localTransReqContext._body = locald.a(localk.e, paramArrayOfByte1, paramArrayOfByte3, paramArrayOfByte4, paramInt, localk.b.getBytes(), paramArrayOfByte2, false, GetGuid(), 0L, t.F, paramArrayOfByte5, t.A, paramArrayOfByte6, paramWUserSigInfo.extraRegTLVMap);
      return RequestTransport(0, 1, null, 0L, oicq.wlogin_sdk.a.k.i, localTransReqContext, paramWUserSigInfo);
    }
    return -1017;
  }
  
  public int RegGetSMSVerifyLoginAccount(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, WUserSigInfo paramWUserSigInfo)
  {
    util.LOGI("RegGetSMSVerifyLoginAccount ...", "");
    oicq.wlogin_sdk.a.d locald = new oicq.wlogin_sdk.a.d();
    TransReqContext localTransReqContext = new TransReqContext();
    oicq.wlogin_sdk.a.k localk = this.mRegStatus;
    if (paramArrayOfByte1 != null) {
      localk.j = ((byte[])paramArrayOfByte1.clone());
    } else {
      localk.j = new byte[0];
    }
    oicq.wlogin_sdk.a.k.y = true;
    oicq.wlogin_sdk.a.k.A = util.get_mpasswd();
    localTransReqContext.set_register_req();
    localTransReqContext.set_subcmd(locald.a());
    localTransReqContext._body = locald.a(localk.e, paramArrayOfByte1, oicq.wlogin_sdk.a.k.A.getBytes(), paramArrayOfByte3, 1, localk.b.getBytes(), paramArrayOfByte2, true, GetGuid(), localk.h, t.F, paramArrayOfByte4, t.A, null, paramWUserSigInfo.extraRegTLVMap);
    return RequestTransport(0, 1, null, 0L, oicq.wlogin_sdk.a.k.i, localTransReqContext, paramWUserSigInfo);
  }
  
  public int RegQueryAccount(int paramInt, byte[] paramArrayOfByte, long paramLong, WUserSigInfo paramWUserSigInfo)
  {
    if (paramArrayOfByte == null) {
      paramArrayOfByte = new byte[0];
    }
    util.LOGI("RegQueryAccount ...", "");
    this.mRegStatus = new oicq.wlogin_sdk.a.k();
    this.mRegStatus.b = new String(paramArrayOfByte);
    oicq.wlogin_sdk.a.e locale = new oicq.wlogin_sdk.a.e();
    TransReqContext localTransReqContext = new TransReqContext();
    oicq.wlogin_sdk.a.k localk = this.mRegStatus;
    localTransReqContext.set_register_req();
    localTransReqContext.set_subcmd(locale.a());
    localTransReqContext._body = locale.a(paramInt, paramArrayOfByte, paramLong);
    return RequestTransport(0, 1, null, 0L, oicq.wlogin_sdk.a.k.i, localTransReqContext, paramWUserSigInfo);
  }
  
  public int RegQueryClientSentMsgStatus(WUserSigInfo paramWUserSigInfo)
  {
    util.LOGI("RegQueryClientSentMsgStatus ...", "");
    oicq.wlogin_sdk.a.f localf = new oicq.wlogin_sdk.a.f();
    TransReqContext localTransReqContext = new TransReqContext();
    oicq.wlogin_sdk.a.k localk = this.mRegStatus;
    localTransReqContext.set_register_req();
    localTransReqContext.set_subcmd(localf.a());
    localTransReqContext._body = localf.b(localk.e, this.mRegStatus.p);
    return RequestTransport(0, 1, null, 0L, oicq.wlogin_sdk.a.k.i, localTransReqContext, paramWUserSigInfo);
  }
  
  public int RegRequestServerResendMsg(WUserSigInfo paramWUserSigInfo)
  {
    util.LOGI("RegRequestServerResendMsg ...", "");
    g localg = new g();
    TransReqContext localTransReqContext = new TransReqContext();
    oicq.wlogin_sdk.a.k localk = this.mRegStatus;
    localTransReqContext.set_register_req();
    localTransReqContext.set_subcmd(localg.a());
    localTransReqContext._body = localg.b(localk.e, null);
    return RequestTransport(0, 1, null, 0L, oicq.wlogin_sdk.a.k.i, localTransReqContext, paramWUserSigInfo);
  }
  
  public int RegSubmitMobile(String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, WUserSigInfo paramWUserSigInfo, Map<String, Object> paramMap)
  {
    if (paramString == null) {
      paramString = new byte[0];
    } else {
      paramString = paramString.getBytes();
    }
    return RegSubmitMobile(paramString, paramArrayOfByte1, null, paramArrayOfByte2, paramInt1, paramInt2, paramInt3, paramLong1, paramLong2, paramWUserSigInfo, paramMap);
  }
  
  public int RegSubmitMobile(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, WUserSigInfo paramWUserSigInfo)
  {
    return RegSubmitMobile(null, paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3, paramInt1, paramInt2, paramInt3, paramLong1, paramLong2, paramWUserSigInfo, null);
  }
  
  public int RegSubmitMsgChk(byte[] paramArrayOfByte, WUserSigInfo paramWUserSigInfo)
  {
    if (paramArrayOfByte == null) {
      return -1017;
    }
    util.LOGI("RegSubmitMsgChk ...", "");
    oicq.wlogin_sdk.a.j localj = new oicq.wlogin_sdk.a.j();
    TransReqContext localTransReqContext = new TransReqContext();
    oicq.wlogin_sdk.a.k localk = this.mRegStatus;
    localTransReqContext.set_register_req();
    localTransReqContext.set_subcmd(localj.a());
    localTransReqContext._body = localj.b(localk.e, paramArrayOfByte);
    return RequestTransport(0, 1, null, 0L, oicq.wlogin_sdk.a.k.i, localTransReqContext, paramWUserSigInfo);
  }
  
  public int RequestTransport(int paramInt1, int paramInt2, String paramString, long paramLong1, long paramLong2, TransReqContext paramTransReqContext, WUserSigInfo paramWUserSigInfo)
  {
    if (paramInt1 == 0)
    {
      new WtloginHelper.HelperThread(this, this, this.mHelperHandler, paramInt2, paramString, paramLong1, paramLong2, paramTransReqContext, paramWUserSigInfo, "RequestTransport").RunReq(9);
      return -1001;
    }
    t localt = this.mG.a(0L);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("encrypt:");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append(" appid:");
    ((StringBuilder)localObject).append(paramLong1);
    ((StringBuilder)localObject).append(" role:");
    ((StringBuilder)localObject).append(paramLong2);
    ((StringBuilder)localObject).append(" Seq:");
    ((StringBuilder)localObject).append(localt.h);
    ((StringBuilder)localObject).append("subcmd=");
    ((StringBuilder)localObject).append(paramTransReqContext._subcmd);
    ((StringBuilder)localObject).append(" RequestTransport...");
    util.LOGI(((StringBuilder)localObject).toString(), paramString);
    localt.g = paramString;
    if (paramInt2 != 0)
    {
      if (paramString == null)
      {
        localt.m = 0;
        paramInt1 = new ab(localt).a(0L, paramTransReqContext, null, null, paramLong1, paramLong2, paramWUserSigInfo);
      }
      else
      {
        localObject = new WloginSimpleInfo();
        if ((paramString != null) && (GetBasicUserInfo(paramString, (WloginSimpleInfo)localObject).booleanValue()))
        {
          WloginSigInfo localWloginSigInfo = localt.a(((WloginSimpleInfo)localObject)._uin, paramLong1);
          if (localWloginSigInfo == null)
          {
            paramInt1 = -1004;
          }
          else
          {
            localt.f = ((WloginSimpleInfo)localObject)._uin;
            paramInt1 = new ab(localt).a(((WloginSimpleInfo)localObject)._uin, paramTransReqContext, localWloginSigInfo._userStSig, localWloginSigInfo._userSt_Key, paramLong1, paramLong2, paramWUserSigInfo);
          }
        }
        else
        {
          paramInt1 = -1003;
        }
      }
    }
    else
    {
      localt.f = 0L;
      paramInt1 = new ab(localt).a(localt.f, paramTransReqContext, null, null, paramLong1, paramLong2, paramWUserSigInfo);
    }
    localt.j();
    paramWUserSigInfo = new StringBuilder();
    paramWUserSigInfo.append("encrypt:");
    paramWUserSigInfo.append(paramInt2);
    paramWUserSigInfo.append(" appid:");
    paramWUserSigInfo.append(paramLong1);
    paramWUserSigInfo.append(" role:");
    paramWUserSigInfo.append(paramLong2);
    paramWUserSigInfo.append(" Seq:");
    paramWUserSigInfo.append(localt.h);
    paramWUserSigInfo.append("subcmd=");
    paramWUserSigInfo.append(paramTransReqContext._subcmd);
    paramWUserSigInfo.append(" RequestTransport ret=");
    paramWUserSigInfo.append(paramInt1);
    util.LOGI(paramWUserSigInfo.toString(), paramString);
    return paramInt1;
  }
  
  public int RequestTransportMsf(int paramInt1, int paramInt2, String paramString, long paramLong1, long paramLong2, TransReqContext paramTransReqContext)
  {
    if (paramInt1 == 0)
    {
      new WtloginHelper.HelperThread(this, this, this.mHelperHandler, paramInt2, paramString, paramLong1, paramLong2, paramTransReqContext, "RequestTransportMsf").RunReq(10);
      return -1001;
    }
    t localt = this.mG.a(0L);
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("user:");
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append(" encrypt:");
    ((StringBuilder)localObject1).append(paramInt2);
    ((StringBuilder)localObject1).append(" appid:");
    ((StringBuilder)localObject1).append(paramLong1);
    ((StringBuilder)localObject1).append(" role:");
    ((StringBuilder)localObject1).append(paramLong2);
    ((StringBuilder)localObject1).append(" Seq:");
    ((StringBuilder)localObject1).append(localt.h);
    ((StringBuilder)localObject1).append(" RequestTransportMsf...");
    util.LOGI(((StringBuilder)localObject1).toString(), paramString);
    localt.g = paramString;
    Object localObject2;
    if (paramInt2 != 0)
    {
      localObject1 = new WloginSimpleInfo();
      if ((paramString != null) && (GetBasicUserInfo(paramString, (WloginSimpleInfo)localObject1).booleanValue()))
      {
        localObject2 = localt.a(((WloginSimpleInfo)localObject1)._uin, paramLong1);
        if (localObject2 != null) {}
      }
    }
    do
    {
      paramInt1 = -1004;
      break;
      localt.f = ((WloginSimpleInfo)localObject1)._uin;
      paramInt1 = new ab(localt).a(((WloginSimpleInfo)localObject1)._uin, paramTransReqContext, ((WloginSigInfo)localObject2)._userStSig, ((WloginSigInfo)localObject2)._userSt_Key, ((WloginSigInfo)localObject2)._TGT, paramLong1, paramLong2, new WUserSigInfo());
      break;
      do
      {
        paramInt1 = -1003;
        break;
        if ((util.check_uin_account(paramString).booleanValue()) && (Long.parseLong(paramString) == 0L))
        {
          localt.f = 0L;
          localObject1 = new ab(localt);
          localObject2 = new WUserSigInfo();
          paramInt1 = ((ab)localObject1).a(0L, paramTransReqContext, null, null, new byte[0], paramLong1, paramLong2, (WUserSigInfo)localObject2);
          break;
        }
        localObject1 = new WloginSimpleInfo();
      } while ((paramString == null) || (!GetBasicUserInfo(paramString, (WloginSimpleInfo)localObject1).booleanValue()));
      localObject2 = localt.a(((WloginSimpleInfo)localObject1)._uin, paramLong1);
    } while (localObject2 == null);
    localt.f = ((WloginSimpleInfo)localObject1)._uin;
    paramInt1 = new ab(localt).a(((WloginSimpleInfo)localObject1)._uin, paramTransReqContext, null, null, ((WloginSigInfo)localObject2)._TGT, paramLong1, paramLong2, new WUserSigInfo());
    localt.j();
    paramTransReqContext = new StringBuilder();
    paramTransReqContext.append("user:");
    paramTransReqContext.append(paramString);
    paramTransReqContext.append(" encrypt:");
    paramTransReqContext.append(paramInt2);
    paramTransReqContext.append(" appid:");
    paramTransReqContext.append(paramLong1);
    paramTransReqContext.append(" role:");
    paramTransReqContext.append(paramLong2);
    paramTransReqContext.append(" Seq:");
    paramTransReqContext.append(localt.h);
    paramTransReqContext.append(" RequestTransportMsf ret=");
    paramTransReqContext.append(paramInt1);
    util.LOGI(paramTransReqContext.toString(), paramString);
    return paramInt1;
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
    if ((str != null) && (paramIntent != null))
    {
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
    util.LOGI("ResolveQloginIntentReserved uin or buff is null", "");
    return null;
  }
  
  public void SetAppClientVersion(int paramInt)
  {
    t.x = paramInt;
  }
  
  public void SetCanWebVerify(int paramInt)
  {
    k.K = paramInt;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SetCanWebVerify old:");
    localStringBuilder.append(k.K);
    localStringBuilder.append(" canWebVerify:");
    localStringBuilder.append(paramInt);
    util.LOGI(localStringBuilder.toString(), "");
  }
  
  public void SetDevlockMobileType(int paramInt)
  {
    r.K = paramInt;
  }
  
  public void SetImgType(int paramInt)
  {
    t.y = paramInt;
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
    t.v = paramInt;
  }
  
  public void SetMsfTransportFlag(int paramInt)
  {
    t localt = this.mG;
    localt.k = paramInt;
    if (paramInt != 0)
    {
      t.ag = new byte[4];
      t.af = 0L;
      localt.l = 45000;
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
      if ((paramString1 != null) && (paramString1.length() != 0)) {
        return 0;
      }
      return -2;
    }
    return -1;
  }
  
  public void SetPicType(int paramInt)
  {
    t.z = paramInt;
  }
  
  public void SetRegDevLockFlag(int paramInt)
  {
    t.A = paramInt;
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
    t.ac = paramBoolean;
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
    localObject1 = new tlv_t400();
    if ((localWloginSigInfo._G != null) && (localWloginSigInfo._G.length > 0) && (localWloginSigInfo._dpwd != null) && (localWloginSigInfo._dpwd.length > 0) && (localWloginSigInfo._randseed != null) && (localWloginSigInfo._randseed.length > 0))
    {
      ((tlv_t400)localObject1).get_tlv_400(localWloginSigInfo._G, l, t.B, localWloginSigInfo._dpwd, paramLong, 1L, localWloginSigInfo._randseed);
      localObject1 = ((tlv_t400)localObject1).get_data();
    }
    else
    {
      localObject1 = new byte[0];
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("user:");
    ((StringBuilder)localObject2).append(paramString);
    ((StringBuilder)localObject2).append(" VerifyCode ...");
    util.LOGI(((StringBuilder)localObject2).toString(), paramString);
    localObject2 = new oicq.wlogin_sdk.code2d.f();
    TransReqContext localTransReqContext = new TransReqContext();
    localTransReqContext.set_code2d_func_req();
    localTransReqContext.set_subcmd(((oicq.wlogin_sdk.code2d.f)localObject2).get_cmd());
    localTransReqContext.setSTEncryptMethod();
    localTransReqContext.setWtST(localWloginSigInfo);
    localTransReqContext._body = ((oicq.wlogin_sdk.code2d.f)localObject2).a(l, paramLong, paramBoolean, paramArrayOfByte, paramArrayOfInt, localWloginSigInfo._TGT, t.B, t.F, paramInt, (byte[])localObject1);
    return RequestTransport(0, 1, paramString, paramLong, ((oicq.wlogin_sdk.code2d.f)localObject2)._role, localTransReqContext, paramWUserSigInfo);
  }
  
  public int VerifySMSVerifyLoginCode(String paramString1, String paramString2, WUserSigInfo paramWUserSigInfo)
  {
    return VerifySMSVerifyLoginCode(paramString1, paramString2, paramWUserSigInfo, 0);
  }
  
  public int cancelCode(String paramString, long paramLong, byte[] paramArrayOfByte, WUserSigInfo paramWUserSigInfo)
  {
    Object localObject1 = new WloginSimpleInfo();
    if (!GetBasicUserInfo(paramString, (WloginSimpleInfo)localObject1).booleanValue()) {
      return -1003;
    }
    long l = ((WloginSimpleInfo)localObject1)._uin;
    this.mG.k();
    localObject1 = FindUserSig(l, paramLong);
    if (localObject1 == null) {
      return -1004;
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("user:");
    ((StringBuilder)localObject2).append(paramString);
    ((StringBuilder)localObject2).append(" CancelCode ...");
    util.LOGI(((StringBuilder)localObject2).toString(), paramString);
    localObject2 = new oicq.wlogin_sdk.code2d.a();
    TransReqContext localTransReqContext = new TransReqContext();
    localTransReqContext.set_code2d_func_req();
    localTransReqContext.set_subcmd(((oicq.wlogin_sdk.code2d.a)localObject2).get_cmd());
    localTransReqContext.setSTEncryptMethod();
    localTransReqContext.setWtST((WloginSigInfo)localObject1);
    localTransReqContext._body = ((oicq.wlogin_sdk.code2d.a)localObject2).a(l, paramLong, paramArrayOfByte, ((WloginSigInfo)localObject1)._TGT);
    return RequestTransport(0, 1, paramString, paramLong, ((oicq.wlogin_sdk.code2d.a)localObject2)._role, localTransReqContext, paramWUserSigInfo);
  }
  
  protected int checkSMSAndGetStForGateWay(t paramt, async_context paramasync_context, String paramString, byte[] paramArrayOfByte1, WUserSigInfo paramWUserSigInfo, byte[] paramArrayOfByte2)
  {
    paramString = new StringBuilder("checkSMSAndGetStForGateWay");
    paramString.append(util.LOG_TAG_GATEWAY_LOGIN_NEW_DOV);
    paramString.append(",seq=");
    paramString.append(paramt.h);
    paramString.append(",_mpasswd=");
    paramString.append(paramasync_context._mpasswd);
    paramString.append(",_msalt=");
    paramString.append(Long.toHexString(paramasync_context._msalt));
    paramString.append(",_appid=");
    paramString.append(paramasync_context._appid);
    paramString.append(",_sub_appid=");
    paramString.append(paramasync_context._sappid);
    paramString.append(",_sappid=");
    paramString.append(paramasync_context._sub_appid);
    paramString.append(",dwMainSigMap=");
    paramString.append(paramasync_context._main_sigmap);
    paramt.f = 0L;
    paramWUserSigInfo.uin = "";
    int i = new o(paramt).b(2).a(paramArrayOfByte1, this.mMiscBitmap, this.mSubSigMap, paramasync_context._sub_appid_list, paramWUserSigInfo, paramArrayOfByte2);
    if (i != 0)
    {
      paramString.append("，request_checksms fail ret = ");
      paramString.append(i);
      util.LOGI(paramString.toString(), "");
      return i;
    }
    long l1 = paramasync_context._sappid;
    long l2 = paramasync_context._sappid;
    i = paramasync_context._main_sigmap;
    paramString.append("，_ui=");
    paramString.append(paramt.f);
    paramWUserSigInfo.uin = String.valueOf(paramt.f);
    i = getTicketByGateway(l1, l2, i, paramWUserSigInfo, paramString, paramt, paramasync_context);
    util.LOGI(paramString.toString(), "");
    return i;
  }
  
  public boolean getHasPassword(long paramLong)
  {
    String str = this.mG.e(paramLong);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getHasPasswd ...");
    ((StringBuilder)localObject).append(String.valueOf(str));
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramLong);
    util.LOGI((String)localObject, localStringBuilder.toString());
    if (str == null) {
      return true;
    }
    localObject = this.mG.c(str);
    if (localObject == null) {
      return true;
    }
    boolean bool = ((UinInfo)localObject).getHasPassword();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getHasPasswd userAccount: ");
    ((StringBuilder)localObject).append(str);
    ((StringBuilder)localObject).append(", uin: ");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append(" hasPasswd: ");
    ((StringBuilder)localObject).append(bool);
    util.LOGI(((StringBuilder)localObject).toString(), "");
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
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("modifyQIMPassword : cmd=");
      ((StringBuilder)localObject).append(paramInt);
      util.LOGI(((StringBuilder)localObject).toString());
      localObject = new TransReqContext();
      ((TransReqContext)localObject).set_register_req();
      ((TransReqContext)localObject).set_subcmd(paramInt);
      ((TransReqContext)localObject)._body = paramArrayOfByte;
      int i = 6084;
      if (paramInt == 1749) {
        i = 5063;
      }
      return RequestTransport(0, 1, null, 16L, i, (TransReqContext)localObject, paramWUserSigInfo);
    }
    return -1017;
  }
  
  public int onQuickLoginActivityResultData(WtloginHelper.QuickLoginParam paramQuickLoginParam, Intent paramIntent)
  {
    return 0;
  }
  
  public int quickLogin(Activity paramActivity, long paramLong1, long paramLong2, String paramString, WtloginHelper.QuickLoginParam paramQuickLoginParam)
  {
    paramActivity = new StringBuilder();
    paramActivity.append("quickLogin start ");
    paramActivity.append(System.currentTimeMillis());
    util.LOGI(paramActivity.toString(), "");
    return 0;
  }
  
  public int quickLoginByGateway(long paramLong1, long paramLong2, int paramInt, WUserSigInfo paramWUserSigInfo)
  {
    return quickLoginByGateway(paramLong1, paramLong2, paramInt, paramWUserSigInfo, 0);
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("quickLoginByWeChat seq:");
    localStringBuilder.append(localt.h);
    util.LOGI(localStringBuilder.toString(), "");
    localasync_context._last_err_msg = new ErrMsg();
    paramQuickLoginParam.sigMap |= 0xC0;
    localasync_context._mpasswd = util.get_mpasswd();
    localasync_context._msalt = util.constructSalt();
    localasync_context._sappid = paramQuickLoginParam.appid;
    localasync_context._appid = paramQuickLoginParam.appid;
    localasync_context._sub_appid = paramQuickLoginParam.subAppid;
    localasync_context._main_sigmap = paramQuickLoginParam.sigMap;
    localasync_context._sub_appid_list = paramQuickLoginParam.dstSubAppidList;
    paramInt = new v(localt).a(paramArrayOfByte1, paramArrayOfByte2, localWUserSigInfo);
    paramArrayOfByte1 = new StringBuilder();
    paramArrayOfByte1.append("quickLoginByWeChat request_login_by_wechat ret");
    paramArrayOfByte1.append(paramInt);
    util.LOGI(paramArrayOfByte1.toString());
    if (paramInt != 0)
    {
      paramArrayOfByte1 = new StringBuilder();
      paramArrayOfByte1.append("quickLoginByWeChat seq ");
      paramArrayOfByte1.append(localt.h);
      paramArrayOfByte1.append(" ret ");
      paramArrayOfByte1.append(paramInt);
      util.LOGI(paramArrayOfByte1.toString());
      return paramInt;
    }
    localasync_context._tmp_pwd = MD5.toMD5Byte(localasync_context._mpasswd.getBytes());
    paramArrayOfByte1 = new k(localt, this.mContext);
    paramArrayOfByte1.g();
    int i = paramArrayOfByte1.a(paramQuickLoginParam.appid, paramQuickLoginParam.subAppid, localt.f, 0, t.ag, util.getRequestInitTime(), localasync_context._tmp_pwd, 4, this.mMiscBitmap, this.mSubSigMap, paramQuickLoginParam.dstSubAppidList, paramQuickLoginParam.sigMap, paramQuickLoginParam.subAppid, t.z, 0, 0, 1, t.ad, localWUserSigInfo);
    paramInt = i;
    if (i == 204)
    {
      paramArrayOfByte1 = new StringBuilder();
      paramArrayOfByte1.append("quickLoginByWeChat seq:");
      paramArrayOfByte1.append(localt.h);
      paramArrayOfByte1.append(" ret:SEC_GUID");
      util.LOGI(paramArrayOfByte1.toString(), "");
      paramInt = new p(localt).a(this.mMiscBitmap, this.mSubSigMap, paramQuickLoginParam.dstSubAppidList, localWUserSigInfo);
    }
    if (paramInt != 0)
    {
      paramArrayOfByte1 = new StringBuilder();
      paramArrayOfByte1.append("quickLoginByWeChat seq:");
      paramArrayOfByte1.append(localt.h);
      paramArrayOfByte1.append(" ret:");
      paramArrayOfByte1.append(paramInt);
      util.LOGI(paramArrayOfByte1.toString(), "");
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
    t.at.commit_t2(localt.f, localt.g, util.format_ret_code(paramInt), paramInt);
    if (paramInt == 0)
    {
      if ((paramArrayOfByte1._sig != null) && (paramArrayOfByte1._sig.length != 0)) {
        RequestReport(0, paramArrayOfByte1._sig, paramArrayOfByte1._sig_key, localt.f, localasync_context._appid);
      }
    }
    else
    {
      paramArrayOfByte2 = paramArrayOfByte1;
      if ((paramInt != 2) && (paramInt != 160)) {
        RequestReportError(0, paramArrayOfByte2._sig, paramArrayOfByte2._sig_key, localt.f, localasync_context._appid, 0);
      }
    }
    if ((localt.d != null) && (localt.d.get_bitmap() != 0))
    {
      this.mG.d = localt.d;
      RequestReportError(0, paramArrayOfByte1._sig, paramArrayOfByte1._sig_key, localt.f, localasync_context._appid, 1);
    }
    oicq.wlogin_sdk.report.c.a();
    t.b();
    localt.i();
    paramArrayOfByte1 = new StringBuilder();
    paramArrayOfByte1.append("quickLoginByWeChat seq:");
    paramArrayOfByte1.append(localt.h);
    paramArrayOfByte1.append(" ret ");
    paramArrayOfByte1.append(paramInt);
    util.LOGI(paramArrayOfByte1.toString(), "");
    return paramInt;
  }
  
  public int quickRegisterCheckAccount(long paramLong1, long paramLong2, int paramInt1, int paramInt2, byte[] paramArrayOfByte, WUserSigInfo paramWUserSigInfo)
  {
    if (paramArrayOfByte != null)
    {
      if (paramWUserSigInfo == null) {
        return -1017;
      }
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("quickRegisterCheckAccount ");
      ((StringBuilder)localObject1).append(paramLong1);
      ((StringBuilder)localObject1).append(" appid ");
      ((StringBuilder)localObject1).append(paramLong2);
      localObject1 = ((StringBuilder)localObject1).toString();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("");
      ((StringBuilder)localObject2).append(paramLong1);
      util.LOGI((String)localObject1, ((StringBuilder)localObject2).toString());
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("");
      ((StringBuilder)localObject1).append(paramLong1);
      localObject1 = GetLocalTicket(((StringBuilder)localObject1).toString(), paramLong2, 64);
      if (localObject1 == null)
      {
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("");
        paramArrayOfByte.append(paramLong1);
        util.LOGI("quickRegisterCheckAccount no key", paramArrayOfByte.toString());
        return -1004;
      }
      if ((((Ticket)localObject1)._sig != null) && (((Ticket)localObject1)._sig.length != 0))
      {
        if ((((Ticket)localObject1)._sig_key != null) && (((Ticket)localObject1)._sig_key.length != 0))
        {
          localObject2 = new oicq.wlogin_sdk.a.a();
          TransReqContext localTransReqContext = new TransReqContext();
          this.mRegStatus.l = ((Ticket)localObject1)._sig_key;
          Object localObject3 = this.mRegStatus;
          ((oicq.wlogin_sdk.a.k)localObject3).g = paramLong2;
          ((oicq.wlogin_sdk.a.k)localObject3).h = paramInt2;
          localTransReqContext.set_register_req();
          localTransReqContext.set_subcmd(((oicq.wlogin_sdk.a.a)localObject2).a());
          localObject3 = FindUserSig(paramLong1, paramLong2);
          localTransReqContext.setSTEncryptMethod();
          localTransReqContext.setWtST((WloginSigInfo)localObject3);
          localTransReqContext._body = ((oicq.wlogin_sdk.a.a)localObject2).a(paramLong1, (int)paramLong2, (byte)8, ((Ticket)localObject1)._sig, ((Ticket)localObject1)._sig_key, (byte)paramInt1, GetGuid(), paramInt2, t.F, paramArrayOfByte, util.generateGuid(this.mContext), util.get_IMSI(this.mContext));
          if (localTransReqContext._body == null)
          {
            paramArrayOfByte = new StringBuilder();
            paramArrayOfByte.append("");
            paramArrayOfByte.append(paramLong1);
            util.LOGI("req_con._body is null", paramArrayOfByte.toString());
            return -1017;
          }
          return RequestTransport(0, 1, null, 0L, oicq.wlogin_sdk.a.k.i, localTransReqContext, paramWUserSigInfo);
        }
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("");
        paramArrayOfByte.append(paramLong1);
        util.LOGI("quickRegisterCheckAccount no key", paramArrayOfByte.toString());
        return -1004;
      }
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("");
      paramArrayOfByte.append(paramLong1);
      util.LOGI("quickRegisterCheckAccount no key", paramArrayOfByte.toString());
      return -1004;
    }
    return -1017;
  }
  
  public int quickRegisterGetAccount(long paramLong1, long paramLong2, int paramInt1, int paramInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, String paramString, WUserSigInfo paramWUserSigInfo)
  {
    if ((paramArrayOfByte2 != null) && (paramArrayOfByte1 != null) && (paramString != null))
    {
      if (paramWUserSigInfo == null) {
        return -1017;
      }
      if (6 > paramString.length()) {
        return -1017;
      }
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("quickRegisterGetAccount ");
      ((StringBuilder)localObject1).append(paramLong1);
      ((StringBuilder)localObject1).append(" appid ");
      ((StringBuilder)localObject1).append(paramLong2);
      localObject1 = ((StringBuilder)localObject1).toString();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("");
      ((StringBuilder)localObject2).append(paramLong1);
      util.LOGI((String)localObject1, ((StringBuilder)localObject2).toString());
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("");
      ((StringBuilder)localObject1).append(paramLong1);
      localObject1 = GetLocalTicket(((StringBuilder)localObject1).toString(), paramLong2, 64);
      if (localObject1 == null)
      {
        paramArrayOfByte1 = new StringBuilder();
        paramArrayOfByte1.append("quickRegisterCheckAccount ");
        paramArrayOfByte1.append(paramLong1);
        paramArrayOfByte1.append(" appid ");
        paramArrayOfByte1.append(paramLong2);
        paramArrayOfByte1.append(" no key");
        paramArrayOfByte1 = paramArrayOfByte1.toString();
        paramArrayOfByte2 = new StringBuilder();
        paramArrayOfByte2.append("");
        paramArrayOfByte2.append(paramLong1);
        util.LOGI(paramArrayOfByte1, paramArrayOfByte2.toString());
        return -1004;
      }
      if ((((Ticket)localObject1)._sig != null) && (((Ticket)localObject1)._sig.length != 0))
      {
        if ((((Ticket)localObject1)._sig_key != null) && (((Ticket)localObject1)._sig_key.length != 0))
        {
          localObject2 = new oicq.wlogin_sdk.a.b();
          TransReqContext localTransReqContext = new TransReqContext();
          this.mRegStatus.l = ((Ticket)localObject1)._sig_key;
          Object localObject3 = this.mRegStatus;
          ((oicq.wlogin_sdk.a.k)localObject3).g = paramLong2;
          ((oicq.wlogin_sdk.a.k)localObject3).h = paramInt2;
          localTransReqContext.set_register_req();
          localTransReqContext.set_subcmd(((oicq.wlogin_sdk.a.b)localObject2).a());
          localObject3 = FindUserSig(paramLong1, paramLong2);
          localTransReqContext.setSTEncryptMethod();
          localTransReqContext.setWtST((WloginSigInfo)localObject3);
          localTransReqContext._body = ((oicq.wlogin_sdk.a.b)localObject2).a(paramLong1, (int)paramLong2, (byte)8, ((Ticket)localObject1)._sig, ((Ticket)localObject1)._sig_key, (byte)paramInt1, paramArrayOfByte2, GetGuid(), paramInt2, t.F, paramArrayOfByte1, util.generateGuid(this.mContext), util.get_IMSI(this.mContext), paramString.getBytes(), this.mRegStatus.e);
          if (localTransReqContext._body == null)
          {
            paramArrayOfByte1 = new StringBuilder();
            paramArrayOfByte1.append("");
            paramArrayOfByte1.append(paramLong1);
            util.LOGI("req_con._body is null", paramArrayOfByte1.toString());
            return -1017;
          }
          return RequestTransport(0, 1, null, 0L, oicq.wlogin_sdk.a.k.i, localTransReqContext, paramWUserSigInfo);
        }
        paramArrayOfByte1 = new StringBuilder();
        paramArrayOfByte1.append("");
        paramArrayOfByte1.append(paramLong1);
        util.LOGI("quickRegisterCheckAccount no key", paramArrayOfByte1.toString());
        return -1004;
      }
      paramArrayOfByte1 = new StringBuilder();
      paramArrayOfByte1.append("");
      paramArrayOfByte1.append(paramLong1);
      util.LOGI("quickRegisterCheckAccount no key", paramArrayOfByte1.toString());
      return -1004;
    }
    return -1017;
  }
  
  public void setBabyQFlg(boolean paramBoolean)
  {
    t.aj = paramBoolean;
  }
  
  public void setCallSource(int paramInt)
  {
    t.ai = paramInt;
  }
  
  public void setForQCall()
  {
    t.ax = true;
    WtloginMsfListener.CLIENT_CLASSNAME = "com.tencent.lightalk.msf.core.auth.WtProvider";
  }
  
  public void setHasPassword(long paramLong, boolean paramBoolean)
  {
    String str = this.mG.e(paramLong);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setHasPasswd ...");
    localStringBuilder.append(String.valueOf(str));
    util.LOGI(localStringBuilder.toString(), "");
    if (str == null) {
      return;
    }
    this.mG.a(str, Long.valueOf(paramLong), paramBoolean);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("setHasPasswd userAccount: ");
    localStringBuilder.append(str);
    localStringBuilder.append(", uin: ");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(" hasPassword:");
    localStringBuilder.append(paramBoolean);
    util.LOGI(localStringBuilder.toString(), "");
  }
  
  public void setMsgType(int paramInt1, int paramInt2, int paramInt3)
  {
    oicq.wlogin_sdk.devicelock.DevlockBase.a.a = paramInt1;
    oicq.wlogin_sdk.devicelock.DevlockBase.a.b = paramInt2;
    oicq.wlogin_sdk.devicelock.DevlockBase.a.c = paramInt3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     oicq.wlogin_sdk.request.WtloginHelper
 * JD-Core Version:    0.7.0.1
 */