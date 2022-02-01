package com.tencent.mobileqq.qwallet.hb.grap.impl;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.qwallet.temp.IQWalletTemp;
import com.qwallet.temp.IQwTemp;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.download.api.IAEResDownload;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletAioBodyReserve;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.dinifly.LottieComposition.Factory;
import com.tencent.mobileqq.qqpay.ui.R.drawable;
import com.tencent.mobileqq.qqpay.ui.R.id;
import com.tencent.mobileqq.qqpay.ui.R.string;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.config.IQWalletConfigService;
import com.tencent.mobileqq.qwallet.hb.aio.QQWalletBaseMsgElem;
import com.tencent.mobileqq.qwallet.hb.aio.passwd.IPasswdRedBagService;
import com.tencent.mobileqq.qwallet.hb.aio.passwd.PasswdRedBagInfo;
import com.tencent.mobileqq.qwallet.hb.emoji.impl.EmojiGifHelper;
import com.tencent.mobileqq.qwallet.impl.QWalletTools;
import com.tencent.mobileqq.qwallet.preload.DownloadParam;
import com.tencent.mobileqq.qwallet.preload.IPreloadServiceAbs;
import com.tencent.mobileqq.qwallet.preload.PreloadStaticApi;
import com.tencent.mobileqq.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QWalletPicHelper;
import java.util.LinkedList;
import java.util.Random;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONObject;

public class RedPacketEmojiFragment
  extends RedPacketPopFragment
{
  public static final String[] a = { HardCodeUtil.a(R.string.ch), HardCodeUtil.a(R.string.cv), HardCodeUtil.a(R.string.cn) };
  public Button b;
  public ImageView c;
  public ImageView d;
  public TextView e;
  public TextView f;
  public TextView g;
  public Button h;
  public View i;
  public ImageView j;
  public ImageView k;
  public int l = 0;
  public String m = "https://i.gtimg.cn/channel/imglib/201906/upload_9c25c90bf492d21e9796f96ddab01809.json";
  public String n;
  public Bundle o;
  public int p = -1;
  private String q;
  private String r = "https://i.gtimg.cn/channel/static/expression/";
  private int s = 0;
  
  private static int a(MessageForQQWalletMsg paramMessageForQQWalletMsg)
  {
    try
    {
      i1 = Integer.parseInt(paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.body.feedId);
    }
    catch (Throwable paramMessageForQQWalletMsg)
    {
      int i1;
      label17:
      int i2;
      break label17;
    }
    i1 = 0;
    if (i1 >= 0)
    {
      i2 = i1;
      if (i1 < 200) {}
    }
    else
    {
      i2 = 0;
    }
    return i2;
  }
  
  private Bundle a(Bundle paramBundle)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putInt("edit_video_type", 10022);
    localBundle.putInt(((IQwTemp)QRoute.api(IQwTemp.class)).ReadInJoyCameraCaptureConstants$KEY_READINJOY_CAPTURE_ABILITY_FLAG(), 3);
    int i1 = this.p;
    return localBundle;
  }
  
  public static void a(BaseQQAppInterface paramBaseQQAppInterface, MessageForQQWalletMsg paramMessageForQQWalletMsg)
  {
    if (paramBaseQQAppInterface != null)
    {
      if (paramMessageForQQWalletMsg == null) {
        return;
      }
      try
      {
        if (paramMessageForQQWalletMsg.messageType == 19)
        {
          if (TextUtils.isEmpty(paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.body.feedId)) {
            return;
          }
          if (a(a(paramMessageForQQWalletMsg)))
          {
            if (QLog.isColorLevel()) {
              QLog.i("RedPacketEmojiFragment", 2, "preload AE_RES_BASE_PACKAGE");
            }
            ((IAEResDownload)QRoute.api(IAEResDownload.class)).requestDownload(AEResInfo.AE_RES_BASE_PACKAGE, null, false);
            return;
          }
          if (QLog.isColorLevel())
          {
            QLog.i("RedPacketEmojiFragment", 2, "preload AE_RES_ADDITIONAL_PACKAGE");
            return;
          }
        }
      }
      catch (Throwable paramBaseQQAppInterface)
      {
        QLog.e("RedPacketEmojiFragment", 1, paramBaseQQAppInterface, new Object[0]);
      }
    }
  }
  
  private void a(String paramString)
  {
    paramString = new StringBuilder(50);
    paramString.append("msgType=19");
    paramString.append("&isOffline=");
    paramString.append(false);
    long l1 = VACDReportUtil.a(null, "qqwallet", "graphb", "pwd.sendByEmoji", paramString.toString(), 0, null, SystemClock.uptimeMillis());
    Object localObject = (IPasswdRedBagService)getQBaseActivity().getAppRuntime().getRuntimeService(IPasswdRedBagService.class, "");
    paramString = ((IPasswdRedBagService)localObject).getPasswdRedBagInfoById(this.J.mQQWalletRedPacketMsg.redPacketId);
    ((IPasswdRedBagService)localObject).setPasswdRedBagOpen(this.J.mQQWalletRedPacketMsg.redPacketId, this.J.frienduin, this.J.istroop);
    QWalletTools.a(getQBaseActivity().getAppRuntime(), this.J);
    ((IPasswdRedBagService)localObject).openPasswdBagByTenpay(this.I, paramString, l1, 262144, "", this.J.mQQWalletRedPacketMsg.elem.v, this.J.fromHBList, null);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("click open passwdredbag, isPasswdRedBagOpen=");
      ((StringBuilder)localObject).append(paramString.f);
      ((StringBuilder)localObject).append(",isPasswdRedBagFinish=");
      ((StringBuilder)localObject).append(paramString.g);
      ((StringBuilder)localObject).append(",isPasswdRedBagOverDue=");
      ((StringBuilder)localObject).append(paramString.a());
      QLog.d("PasswdRedBagSgervice", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  private static boolean a(int paramInt)
  {
    return paramInt >= 100;
  }
  
  public static String c()
  {
    return "{\"v\":\"5.3.1\",\"fr\":30,\"ip\":0,\"op\":30,\"w\":210,\"h\":210,\"nm\":\"“图层 2”轮廓 合成 1\",\"ddd\":0,\"assets\":[],\"layers\":[{\"ddd\":0,\"ind\":1,\"ty\":4,\"nm\":\"“图层 2”轮廓\",\"sr\":1,\"ks\":{\"o\":{\"a\":0,\"k\":100,\"ix\":11},\"r\":{\"a\":0,\"k\":0,\"ix\":10},\"p\":{\"a\":0,\"k\":[106,102,0],\"ix\":2},\"a\":{\"a\":0,\"k\":[87.5,87.5,0],\"ix\":1},\"s\":{\"a\":0,\"k\":[100,100,100],\"ix\":6}},\"ao\":0,\"shapes\":[{\"ty\":\"gr\",\"it\":[{\"ind\":0,\"ty\":\"sh\",\"ix\":1,\"ks\":{\"a\":0,\"k\":{\"i\":[[0,0],[0,0],[0,0]],\"o\":[[0,0],[0,0],[0,0]],\"v\":[[-65.455,80],[-80,80],[-79.868,65.454]],\"c\":false},\"ix\":2},\"nm\":\"路径 1\",\"mn\":\"ADBE Vector Shape - Group\",\"hd\":false},{\"ind\":1,\"ty\":\"sh\",\"ix\":2,\"ks\":{\"a\":0,\"k\":{\"i\":[[0,0],[0,0],[0,0]],\"o\":[[0,0],[0,0],[0,0]],\"v\":[[-79.371,-65.455],[-80,-80],[-65.455,-80]],\"c\":false},\"ix\":2},\"nm\":\"路径 2\",\"mn\":\"ADBE Vector Shape - Group\",\"hd\":false},{\"ind\":2,\"ty\":\"sh\",\"ix\":3,\"ks\":{\"a\":0,\"k\":{\"i\":[[0,0],[0,0],[0,0]],\"o\":[[0,0],[0,0],[0,0]],\"v\":[[65.454,-80],[80,-80],[80,-65.455]],\"c\":false},\"ix\":2},\"nm\":\"路径 3\",\"mn\":\"ADBE Vector Shape - Group\",\"hd\":false},{\"ind\":3,\"ty\":\"sh\",\"ix\":4,\"ks\":{\"a\":0,\"k\":{\"i\":[[0,0],[0,0],[0,0]],\"o\":[[0,0],[0,0],[0,0]],\"v\":[[80,65.454],[80,80],[67.636,80]],\"c\":false},\"ix\":2},\"nm\":\"路径 4\",\"mn\":\"ADBE Vector Shape - Group\",\"hd\":false},{\"ty\":\"mm\",\"mm\":1,\"nm\":\"合并路径 1\",\"mn\":\"ADBE Vector Filter - Merge\",\"hd\":false},{\"ty\":\"st\",\"c\":{\"a\":0,\"k\":[1,0.862999949736,0.675,1],\"ix\":3},\"o\":{\"a\":0,\"k\":100,\"ix\":4},\"w\":{\"a\":0,\"k\":3,\"ix\":5},\"lc\":2,\"lj\":2,\"nm\":\"描边 1\",\"mn\":\"ADBE Vector Graphic - Stroke\",\"hd\":false},{\"ty\":\"tr\",\"p\":{\"a\":0,\"k\":[87.5,87.5],\"ix\":2},\"a\":{\"a\":0,\"k\":[0,0],\"ix\":1},\"s\":{\"a\":1,\"k\":[{\"i\":{\"x\":[0.833,0.833],\"y\":[0.833,0.833]},\"o\":{\"x\":[0.167,0.167],\"y\":[0.167,0.167]},\"n\":[\"0p833_0p833_0p167_0p167\",\"0p833_0p833_0p167_0p167\"],\"t\":0,\"s\":[100,100],\"e\":[110,110]},{\"i\":{\"x\":[0.833,0.833],\"y\":[0.833,0.833]},\"o\":{\"x\":[0.167,0.167],\"y\":[0.167,0.167]},\"n\":[\"0p833_0p833_0p167_0p167\",\"0p833_0p833_0p167_0p167\"],\"t\":10,\"s\":[110,110],\"e\":[108,108]},{\"i\":{\"x\":[0.833,0.833],\"y\":[0.833,0.833]},\"o\":{\"x\":[0.167,0.167],\"y\":[0.167,0.167]},\"n\":[\"0p833_0p833_0p167_0p167\",\"0p833_0p833_0p167_0p167\"],\"t\":15,\"s\":[108,108],\"e\":[110,110]},{\"i\":{\"x\":[0.833,0.833],\"y\":[0.833,0.833]},\"o\":{\"x\":[0.167,0.167],\"y\":[0.167,0.167]},\"n\":[\"0p833_0p833_0p167_0p167\",\"0p833_0p833_0p167_0p167\"],\"t\":20,\"s\":[110,110],\"e\":[100,100]},{\"t\":30}],\"ix\":3},\"r\":{\"a\":0,\"k\":0,\"ix\":6},\"o\":{\"a\":0,\"k\":100,\"ix\":7},\"sk\":{\"a\":0,\"k\":0,\"ix\":4},\"sa\":{\"a\":0,\"k\":0,\"ix\":5},\"nm\":\"变换\"}],\"nm\":\"组 1\",\"np\":6,\"cix\":2,\"ix\":1,\"mn\":\"ADBE Vector Group\",\"hd\":false}],\"ip\":0,\"op\":2700,\"st\":0,\"bm\":0}],\"markers\":[]}";
  }
  
  private void h()
  {
    Object localObject1 = ((IQWalletConfigService)getQBaseActivity().getAppRuntime().getRuntimeService(IQWalletConfigService.class, "")).getString("redPackPanel", "", new String[] { "panelRedPkgList" });
    try
    {
      Object localObject2 = new JSONArray((String)localObject1);
      int i1 = 0;
      while (i1 < ((JSONArray)localObject2).length())
      {
        localObject1 = ((JSONArray)localObject2).optJSONObject(i1);
        if ((localObject1 != null) && (((JSONObject)localObject1).optInt("type") == 8))
        {
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("initConfig emoji id:");
            ((StringBuilder)localObject2).append(this.J.mQQWalletRedPacketMsg.body.feedId);
            ((StringBuilder)localObject2).append("emoji config jo:");
            ((StringBuilder)localObject2).append(((JSONObject)localObject1).toString());
            QLog.i("RedPacketEmojiFragment", 2, ((StringBuilder)localObject2).toString());
          }
          localObject1 = ((JSONObject)localObject1).optJSONObject("params");
          if (localObject1 == null) {
            break;
          }
          this.r = ((JSONObject)localObject1).optString("prefix", "https://i.gtimg.cn/channel/static/expression/");
          this.m = ((JSONObject)localObject1).optString("aEConfig", "https://i.gtimg.cn/channel/imglib/201906/upload_9c25c90bf492d21e9796f96ddab01809.json");
          localObject1 = ((JSONObject)localObject1).getJSONArray("heartList");
          if (localObject1 == null) {
            break;
          }
          i1 = 0;
          while (i1 < ((JSONArray)localObject1).length())
          {
            localObject2 = ((JSONArray)localObject1).optJSONObject(i1);
            if ((localObject2 != null) && (((JSONObject)localObject2).optInt("rId") == Integer.parseInt(this.J.mQQWalletRedPacketMsg.body.feedId)))
            {
              this.q = ((JSONObject)localObject2).optString("md5");
              JSONArray localJSONArray = ((JSONObject)localObject2).optJSONArray("eId");
              if (localJSONArray != null)
              {
                int i2 = localJSONArray.length();
                if (i2 > 0) {
                  this.s = localJSONArray.optInt(new Random().nextInt(i2 + 0) + 0);
                }
              }
              this.p = ((JSONObject)localObject2).optInt("aThreshold", -1);
            }
            i1 += 1;
          }
        }
        i1 += 1;
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  private void i()
  {
    if (QLog.isColorLevel()) {
      QLog.i("RedPacketEmojiFragment", 2, "doLoading");
    }
    int i1 = new Random().nextInt(3);
    this.f.setText(a[(i1 + 0)]);
    Object localObject = getResources().getDrawable(R.drawable.q);
    this.d.setBackgroundDrawable((Drawable)localObject);
    ((Animatable)localObject).start();
    this.b.setVisibility(8);
    this.j.setVisibility(8);
    if (!a(this.l)) {
      return;
    }
    localObject = new LinkedList();
    DownloadParam localDownloadParam = new DownloadParam();
    localDownloadParam.url = this.m;
    localDownloadParam.filePos = 1;
    ((LinkedList)localObject).add(localDownloadParam);
    PreloadStaticApi.a().getResPath(localDownloadParam, new RedPacketEmojiFragment.3(this));
  }
  
  private void j()
  {
    EmojiGifHelper.a().c(hashCode());
  }
  
  protected void a(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.i("RedPacketEmojiFragment", 2, "initUI");
    }
    super.a(paramView);
    ((ViewStub)paramView.findViewById(R.id.cn)).inflate();
    this.b = ((Button)paramView.findViewById(R.id.u));
    this.c = ((ImageView)paramView.findViewById(R.id.ap));
    this.d = ((ImageView)paramView.findViewById(R.id.av));
    this.e = ((TextView)paramView.findViewById(R.id.cV));
    this.f = ((TextView)paramView.findViewById(R.id.cX));
    this.g = ((TextView)paramView.findViewById(R.id.cU));
    this.h = ((Button)paramView.findViewById(R.id.s));
    this.i = paramView.findViewById(R.id.aQ);
    this.j = ((ImageView)paramView.findViewById(R.id.as));
    a(this.j);
    this.k = ((ImageView)paramView.findViewById(R.id.au));
    paramView = c();
    if (!TextUtils.isEmpty(paramView)) {
      LottieComposition.Factory.fromJsonString(paramView, new RedPacketEmojiFragment.1(this));
    }
  }
  
  protected boolean a()
  {
    if (!super.a()) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.i("RedPacketEmojiFragment", 2, "initParams");
    }
    this.G.setBackgroundDrawable(getResources().getDrawable(R.drawable.k));
    String str = ((IQwTemp)QRoute.api(IQwTemp.class)).ContactUtils$getBuddyName(getQBaseActivity().getAppRuntime(), this.J.senderuin, true);
    str = QWalletTools.a(getQBaseActivity(), str, 135.0F, this.F.getPaint());
    TextView localTextView = this.F;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append(HardCodeUtil.a(R.string.cF));
    localTextView.setText(localStringBuilder.toString());
    this.e.setText(this.J.mQQWalletRedPacketMsg.elem.c);
    ReportController.b(getQBaseActivity().getAppRuntime(), "P_CliOper", "Vip_pay_mywallet", "", "211", "phiz.popup.show", 0, 0, "", "", "", "");
    this.o = getArguments().getBundle("KEY_CAMERA_BUNDLE");
    this.b.setOnClickListener(this);
    QWalletTools.a(this.b, 0.3F);
    this.h.setOnClickListener(this);
    this.h.setOnTouchListener(QWalletTools.a(0.7F));
    EmojiGifHelper.a().a(this.I, hashCode());
    h();
    this.l = a(this.J);
    i();
    AccessibilityUtil.a(this.b, HardCodeUtil.a(R.string.cz));
    return true;
  }
  
  public void d()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.r);
    ((StringBuilder)localObject).append(this.J.mQQWalletRedPacketMsg.body.feedId);
    ((StringBuilder)localObject).append(".png");
    localObject = ((StringBuilder)localObject).toString();
    Drawable localDrawable = URLDrawableHelperConstants.a;
    localObject = QWalletPicHelper.getNetDrawableForQWallet((String)localObject, localDrawable, localDrawable, this.q);
    this.c.setBackgroundDrawable((Drawable)localObject);
    if (localObject != null)
    {
      ((URLDrawable)localObject).setURLDrawableListener(new RedPacketEmojiFragment.2(this));
      if (((URLDrawable)localObject).getStatus() == 1)
      {
        g();
        return;
      }
      if ((((URLDrawable)localObject).getStatus() != 1) && (((URLDrawable)localObject).getStatus() != 0)) {
        ((URLDrawable)localObject).restartDownload();
      }
    }
    else
    {
      e();
    }
  }
  
  public void e()
  {
    this.g.setVisibility(0);
    this.h.setVisibility(0);
    this.i.setVisibility(8);
  }
  
  public void f()
  {
    this.g.setVisibility(8);
    this.h.setVisibility(8);
    this.i.setVisibility(0);
    i();
  }
  
  public void g()
  {
    this.f.setText(HardCodeUtil.a(R.string.cd));
    this.d.setVisibility(8);
    this.b.setVisibility(0);
    this.j.setVisibility(0);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 1) && (paramInt2 == -1))
    {
      a("sss");
      j();
      getQBaseActivity().finish();
    }
  }
  
  public boolean onBackEvent()
  {
    ReportController.b(getQBaseActivity().getAppRuntime(), "P_CliOper", "Vip_pay_mywallet", "", "211", "phiz.popup.back", 0, 0, "", "", "", "");
    EmojiGifHelper.a().a(hashCode());
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    int i1 = paramView.getId();
    if (i1 == R.id.u)
    {
      ReportController.b(getQBaseActivity().getAppRuntime(), "P_CliOper", "Vip_pay_mywallet", "", "211", "phiz.popup.click", 0, 0, "", "", "", "");
      ((IQWalletTemp)QRoute.api(IQWalletTemp.class)).openCamera(getQBaseActivity(), a(this.o), 1);
      return;
    }
    if (i1 == R.id.s) {
      f();
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    b(this.j);
    b(this.k);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.grap.impl.RedPacketEmojiFragment
 * JD-Core Version:    0.7.0.1
 */