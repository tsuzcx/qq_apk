package com.tencent.mobileqq.intervideo.impl;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.biz.ProtoServlet;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.intervideo.ILoginKeyHelper;
import com.tencent.mobileqq.intervideo.ILoginKeyHelper.AccountInfo;
import com.tencent.mobileqq.intervideo.ILoginKeyHelper.GetLoginKeyListener;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.open.business.base.AppUtil;
import com.tencent.qconn.protofile.fastauthorize.FastAuthorize.AuthorizeRequest;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.NewIntent;
import mqq.manager.TicketManager;
import oicq.wlogin_sdk.request.WFastLoginInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.request.WtloginHelper;

public class LoginKeyHelperImpl
  implements ILoginKeyHelper
{
  boolean isUpdating;
  ILoginKeyHelper.AccountInfo mAccountInfo = new ILoginKeyHelper.AccountInfo();
  long mLastUpdatedTime = 0L;
  List<ILoginKeyHelper.GetLoginKeyListener> mListenerList = new ArrayList();
  WtloginHelper wtloginHelper;
  
  private void notifyResult(String paramString, boolean paramBoolean, int paramInt)
  {
    Iterator localIterator = this.mListenerList.iterator();
    while (localIterator.hasNext())
    {
      ILoginKeyHelper.GetLoginKeyListener localGetLoginKeyListener = (ILoginKeyHelper.GetLoginKeyListener)localIterator.next();
      if (localGetLoginKeyListener != null) {
        localGetLoginKeyListener.onGetKeyComplete(paramString, paramBoolean, paramInt);
      }
    }
    this.mListenerList.clear();
    this.isUpdating = false;
  }
  
  public void cancelRequest()
  {
    WtloginHelper localWtloginHelper = this.wtloginHelper;
    if (localWtloginHelper != null) {
      localWtloginHelper.CancelRequest();
    }
    this.mAccountInfo.d = null;
  }
  
  public void clearAccount()
  {
    this.mAccountInfo = new ILoginKeyHelper.AccountInfo();
  }
  
  public boolean getA1(String paramString1, String paramString2, String paramString3, String paramString4, ILoginKeyHelper.GetLoginKeyListener paramGetLoginKeyListener, boolean paramBoolean, String paramString5)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("开始拉取A1，uin = ");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(" appid = ");
    localStringBuilder.append(paramString4);
    QLog.i("XProxy", 2, localStringBuilder.toString());
    if ((this.mAccountInfo.d != null) && (!paramBoolean) && (System.currentTimeMillis() - this.mLastUpdatedTime < 43200000L))
    {
      if (paramGetLoginKeyListener != null) {
        paramGetLoginKeyListener.onGetKeyComplete(paramString2, true, 0);
      }
      return true;
    }
    if (this.isUpdating)
    {
      this.mListenerList.add(paramGetLoginKeyListener);
      return true;
    }
    this.isUpdating = true;
    if (this.wtloginHelper == null)
    {
      QLog.i("XProxy", 2, "new WtloginHelper");
      this.wtloginHelper = new WtloginHelper(BaseApplicationImpl.getContext());
    }
    if (paramString3.equals("com.tencent.huayang"))
    {
      paramString5 = new byte[16];
      String tmp170_168 = paramString5;
      tmp170_168[0] = -33;
      String tmp175_170 = tmp170_168;
      tmp175_170[1] = 11;
      String tmp180_175 = tmp175_170;
      tmp180_175[2] = -29;
      String tmp185_180 = tmp180_175;
      tmp185_180[3] = -119;
      String tmp190_185 = tmp185_180;
      tmp190_185[4] = 66;
      String tmp195_190 = tmp190_185;
      tmp195_190[5] = 110;
      String tmp200_195 = tmp195_190;
      tmp200_195[6] = 87;
      String tmp206_200 = tmp200_195;
      tmp206_200[7] = 53;
      String tmp212_206 = tmp206_200;
      tmp212_206[8] = -16;
      String tmp218_212 = tmp212_206;
      tmp218_212[9] = -77;
      String tmp224_218 = tmp218_212;
      tmp224_218[10] = -121;
      String tmp230_224 = tmp224_218;
      tmp230_224[11] = -112;
      String tmp236_230 = tmp230_224;
      tmp236_230[12] = 46;
      String tmp242_236 = tmp236_230;
      tmp242_236[13] = 51;
      String tmp248_242 = tmp242_236;
      tmp248_242[14] = -96;
      String tmp254_248 = tmp248_242;
      tmp254_248[15] = 62;
      tmp254_248;
    }
    for (;;)
    {
      break;
      if (paramString3.equals("com.tencent.now"))
      {
        paramString5 = new byte[16];
        String tmp281_279 = paramString5;
        tmp281_279[0] = -51;
        String tmp286_281 = tmp281_279;
        tmp286_281[1] = 50;
        String tmp291_286 = tmp286_281;
        tmp291_286[2] = 114;
        String tmp296_291 = tmp291_286;
        tmp296_291[3] = -105;
        String tmp301_296 = tmp296_291;
        tmp301_296[4] = -54;
        String tmp306_301 = tmp301_296;
        tmp306_301[5] = -19;
        String tmp311_306 = tmp306_301;
        tmp311_306[6] = 112;
        String tmp317_311 = tmp311_306;
        tmp317_311[7] = -124;
        String tmp323_317 = tmp317_311;
        tmp323_317[8] = -125;
        String tmp329_323 = tmp323_317;
        tmp329_323[9] = -52;
        String tmp335_329 = tmp329_323;
        tmp335_329[10] = -72;
        String tmp341_335 = tmp335_329;
        tmp341_335[11] = -101;
        String tmp347_341 = tmp341_335;
        tmp347_341[12] = -27;
        String tmp353_347 = tmp347_341;
        tmp353_347[13] = 33;
        String tmp359_353 = tmp353_347;
        tmp359_353[14] = 65;
        String tmp365_359 = tmp359_353;
        tmp365_359[15] = -128;
        tmp365_359;
      }
      else
      {
        paramString5 = HexUtil.hexStr2Bytes(paramString5);
      }
    }
    this.wtloginHelper.SetListener(new LoginKeyHelperImpl.1(this, paramString2));
    this.mListenerList.add(paramGetLoginKeyListener);
    int i = this.wtloginHelper.GetA1WithA1(paramString1, 16L, 16L, paramString3.getBytes(), 1L, Long.valueOf(paramString4).longValue(), 1L, "5.2".getBytes(), paramString5, new WUserSigInfo(), new WFastLoginInfo());
    if (i != -1001)
    {
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("获取Now结合版A1票据失败，retCode = ");
        paramString1.append(i);
        QLog.i("XProxy", 2, paramString1.toString());
      }
      notifyResult(paramString2, false, i);
    }
    return true;
  }
  
  public void getAccessToken(AppInterface paramAppInterface, String paramString1, Context paramContext, String paramString2, ILoginKeyHelper.GetLoginKeyListener paramGetLoginKeyListener)
  {
    if (!TextUtils.isEmpty(this.mAccountInfo.b))
    {
      if (paramGetLoginKeyListener != null) {
        paramGetLoginKeyListener.onGetKeyComplete(paramString1, true, 0);
      }
      return;
    }
    LoginKeyHelperImpl.2 local2 = new LoginKeyHelperImpl.2(this, paramGetLoginKeyListener, paramString1);
    FastAuthorize.AuthorizeRequest localAuthorizeRequest = new FastAuthorize.AuthorizeRequest();
    localAuthorizeRequest.uin.set(Long.parseLong(paramAppInterface.getCurrentAccountUin()));
    localAuthorizeRequest.client_id.set(Long.parseLong(paramString2));
    localAuthorizeRequest.pf.set("");
    paramString2 = AppUtil.a(paramContext);
    localAuthorizeRequest.qqv.set(paramString2);
    localAuthorizeRequest.sdkp.set("a");
    paramString2 = Build.DISPLAY;
    localAuthorizeRequest.os.set(paramString2);
    paramString2 = ((TicketManager)paramAppInterface.getManager(2)).getSkey(paramAppInterface.getAccount());
    localAuthorizeRequest.skey.set(paramString2);
    if ((paramAppInterface instanceof QQAppInterface)) {
      paramString2 = ((QQAppInterface)paramAppInterface).getvKeyStr();
    } else if ((paramAppInterface instanceof BrowserAppInterface)) {
      paramString2 = ((BrowserAppInterface)paramAppInterface).a();
    } else {
      paramString2 = "";
    }
    String str = paramString2;
    if (paramString2 == null) {
      str = "";
    }
    localAuthorizeRequest.vkey.set(str);
    localAuthorizeRequest.flags.set(7);
    paramContext = new NewIntent(paramContext, ProtoServlet.class);
    localAuthorizeRequest.apk_sign.set("");
    paramContext.putExtra("cmd", "ConnAuthSvr.fast_qq_login");
    try
    {
      paramContext.putExtra("data", localAuthorizeRequest.toByteArray());
    }
    catch (Exception paramString2)
    {
      label288:
      break label288;
    }
    paramGetLoginKeyListener.onGetKeyComplete(paramString1, false, -10001);
    paramContext.setObserver(local2);
    paramAppInterface.startServlet(paramContext);
  }
  
  public ILoginKeyHelper.AccountInfo getAccountInfo()
  {
    return this.mAccountInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.impl.LoginKeyHelperImpl
 * JD-Core Version:    0.7.0.1
 */