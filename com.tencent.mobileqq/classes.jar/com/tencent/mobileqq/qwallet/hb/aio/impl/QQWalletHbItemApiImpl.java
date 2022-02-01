package com.tencent.mobileqq.qwallet.hb.aio.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.qwallet.temp.IBaseChatPieProxy;
import com.qwallet.temp.IIndividualRedPacket;
import com.qwallet.temp.IQWalletMsgHolder;
import com.tencent.av.widget.EllipseTextView;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.qqpay.ui.R.drawable;
import com.tencent.mobileqq.qqpay.ui.R.id;
import com.tencent.mobileqq.qqpay.ui.R.string;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.hb.IRedPacketManager;
import com.tencent.mobileqq.qwallet.hb.aio.IQQWalletHbItemApi;
import com.tencent.mobileqq.qwallet.hb.aio.QQWalletBaseMsgElem;
import com.tencent.mobileqq.qwallet.hb.aio.ScrollPlayer;
import com.tencent.mobileqq.qwallet.hb.theme.ThemeRedPkgConfig;
import com.tencent.mobileqq.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.relation.api.IContactUtilsApi;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.widget.AnimationView;
import com.tencent.mobileqq.widget.RoundImageView;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.QwUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

public class QQWalletHbItemApiImpl
  implements IQQWalletHbItemApi
{
  protected static final int chat_icon_container = R.id.bB;
  protected static final int chat_redpacket_anim_bg;
  protected static final int chat_redpacket_background;
  protected static final int chat_redpacket_customize_bg;
  protected static final int chat_redpacket_specify_icon_container = R.id.bE;
  protected static final int chat_redpacket_subtitle = R.id.bx;
  protected static final int chat_redpacket_title = R.id.bw;
  protected static final int graybar_redpacket;
  static long mLastClickedTime;
  public static Map<String, MessageForQQWalletMsg> sMessageForQQWalletMsgMap = new HashMap();
  final String PKGNAME_PAY_BRIDGE = "pay";
  final String PKGNAME_PAY_RED = "red";
  protected int dip10;
  protected int dip11;
  protected int dip115;
  protected int dip138;
  protected int dip15;
  protected int dip160;
  protected int dip17;
  protected int dip23;
  protected int dip240;
  protected int dip40;
  protected int dip8;
  protected int dip90;
  protected boolean isInit = false;
  BaseQQAppInterface mAppInterface;
  IBaseChatPieProxy mBaseChatPie;
  private View.OnClickListener mDrawClickListener = new QQWalletHbItemApiImpl.3(this);
  private View.OnClickListener mEmojiClickListener = new QQWalletHbItemApiImpl.2(this);
  QQWalletHbItemApiImpl.HbItemClickListener mHbItemClickListener;
  private View.OnClickListener mKSONGClickListener = new QQWalletHbItemApiImpl.4(this);
  private View.OnClickListener mKuaKuaClickListener = new QQWalletHbItemApiImpl.8(this);
  private View.OnClickListener mPasswordClickListener = new QQWalletHbItemApiImpl.6(this);
  private View.OnClickListener mPwdVoiceClickListener = new QQWalletHbItemApiImpl.5(this);
  private View.OnClickListener mShengpiziClickListener = new QQWalletHbItemApiImpl.10(this);
  private View.OnClickListener mSolitaireClickListener = new QQWalletHbItemApiImpl.7(this);
  private View.OnClickListener onClickListener = new QQWalletHbItemApiImpl.9(this);
  private String pskey = null;
  BaseSessionInfo sessionInfo;
  
  static
  {
    chat_redpacket_background = R.id.by;
    graybar_redpacket = R.id.bz;
    chat_redpacket_customize_bg = R.id.bA;
    chat_redpacket_anim_bg = R.id.bv;
  }
  
  public static void cleanMessageForQQWalletMsgMap()
  {
    Map localMap = sMessageForQQWalletMsgMap;
    if ((localMap != null) && (!localMap.isEmpty())) {
      sMessageForQQWalletMsgMap.clear();
    }
  }
  
  private RelativeLayout createRedRightLayout(Context paramContext)
  {
    paramContext = new RelativeLayout(paramContext);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(8, chat_redpacket_background);
    localLayoutParams.addRule(1, chat_redpacket_background);
    paramContext.setLayoutParams(localLayoutParams);
    return paramContext;
  }
  
  private boolean doWalletAction(Context paramContext, QQWalletBaseMsgElem paramQQWalletBaseMsgElem, String paramString1, String paramString2, MessageForQQWalletMsg paramMessageForQQWalletMsg, BaseSessionInfo paramBaseSessionInfo)
  {
    Object localObject2 = null;
    String str = null;
    Object localObject3 = null;
    Object localObject1;
    if (paramQQWalletBaseMsgElem != null) {
      localObject1 = paramQQWalletBaseMsgElem.i;
    } else {
      localObject1 = null;
    }
    CharSequence localCharSequence;
    int i;
    if ((paramContext != null) && (!TextUtils.isEmpty((CharSequence)localObject1)) && (paramMessageForQQWalletMsg != null))
    {
      if (paramMessageForQQWalletMsg.mQQWalletRedPacketMsg == null) {
        return false;
      }
      localObject1 = ((String)localObject1).split("\\?");
      localCharSequence = localObject1[0];
      if (TextUtils.isEmpty(localCharSequence)) {
        return false;
      }
      if (localObject1.length > 1) {
        localObject1 = paramMessageForQQWalletMsg.parseUrlParams(localObject1[1]);
      } else {
        localObject1 = new HashMap();
      }
      if (localCharSequence.equals("pay"))
      {
        paramQQWalletBaseMsgElem = (String)((HashMap)localObject1).get("payData");
        paramString1 = (String)((HashMap)localObject1).get("reqCode");
        if (!TextUtils.isEmpty(paramString1))
        {
          if (TextUtils.isEmpty(paramQQWalletBaseMsgElem)) {
            return false;
          }
          paramString2 = new Bundle();
          paramString2.putString("json", paramQQWalletBaseMsgElem);
          paramString2.putString("callbackSn", "0");
          paramQQWalletBaseMsgElem = new Intent(paramContext, PayBridgeActivity.class);
          paramQQWalletBaseMsgElem.putExtras(paramString2);
          paramQQWalletBaseMsgElem.putExtra("pay_requestcode", Integer.valueOf(paramString1).intValue());
        }
        else
        {
          return false;
        }
      }
      else if (localCharSequence.equals("red"))
      {
        str = (String)((HashMap)localObject1).get("id");
        if (TextUtils.isEmpty(str)) {
          return false;
        }
        localObject1 = localObject3;
        if (paramQQWalletBaseMsgElem != null)
        {
          localObject1 = localObject3;
          if (paramQQWalletBaseMsgElem.l > 1)
          {
            localObject1 = ((IRedPacketManager)QRoute.api(IRedPacketManager.class)).getThemeRedPkgConfById(paramQQWalletBaseMsgElem.l);
            if (localObject1 != null)
            {
              localObject1 = ((ThemeRedPkgConfig)localObject1).b;
            }
            else
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("https://i.gtimg.cn/channel/static/socialpay/paneltheme/socialpay_theme_v1_");
              ((StringBuilder)localObject1).append(paramQQWalletBaseMsgElem.l);
              ((StringBuilder)localObject1).append("_bg");
              localObject1 = ((StringBuilder)localObject1).toString();
            }
          }
        }
        localObject2 = QWalletRedPkgUtils.a(this.mAppInterface, paramBaseSessionInfo, paramMessageForQQWalletMsg.istroop);
        i = ((Bundle)localObject2).getInt("groupType");
        localObject2 = ((Bundle)localObject2).getString("name");
        paramQQWalletBaseMsgElem = QWalletRedPkgUtils.a(this.mAppInterface, paramMessageForQQWalletMsg, paramQQWalletBaseMsgElem, paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.redChannel, paramBaseSessionInfo, i, (String)localObject2, str, paramString1, paramString2, "appid#1344242394|bargainor_id#1000030201|channel#msg", "graphb", (String)localObject1);
        paramString2 = (IIndividualRedPacket)this.mAppInterface.getRuntimeService(IIndividualRedPacket.class);
        if ((paramString2 == null) || (paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.envelopeid <= 0)) {}
      }
    }
    for (;;)
    {
      try
      {
        paramString1 = paramQQWalletBaseMsgElem.getJSONObject("extra_data");
        paramString2 = paramString2.getTenpayCombineImg(String.valueOf(paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.envelopeid), paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.envelopeName);
        boolean bool = QLog.isColorLevel();
        if (!bool) {
          continue;
        }
      }
      catch (Exception paramString1)
      {
        continue;
        continue;
      }
      try
      {
        QLog.d("vipBgImage", 2, paramString2);
        paramString1.put("vipBgImage", paramString2);
      }
      catch (Exception paramString1) {}
    }
    paramString2 = new Bundle();
    paramString2.putString("json", paramQQWalletBaseMsgElem.toString());
    paramString2.putString("callbackSn", "0");
    if (localObject1 != null) {
      paramString2.putString("cftImageUrl", (String)localObject1);
    }
    paramQQWalletBaseMsgElem = str;
    paramString1 = paramQQWalletBaseMsgElem;
    if (paramQQWalletBaseMsgElem != null)
    {
      paramString1 = paramQQWalletBaseMsgElem;
      if (paramQQWalletBaseMsgElem.length() > 4)
      {
        paramString1 = new StringBuilder();
        paramString1.append("****");
        paramString1.append(paramQQWalletBaseMsgElem.substring(4));
        paramString1 = paramString1.toString();
      }
    }
    paramQQWalletBaseMsgElem = new StringBuilder();
    paramQQWalletBaseMsgElem.append("groupType=");
    paramQQWalletBaseMsgElem.append(i);
    paramQQWalletBaseMsgElem.append("&msgType=");
    paramQQWalletBaseMsgElem.append(paramMessageForQQWalletMsg.messageType);
    paramQQWalletBaseMsgElem.append("&redId=");
    paramQQWalletBaseMsgElem.append(paramString1);
    paramString2.putLong("vacreport_key_seq", VACDReportUtil.a(null, "qqwallet", "graphb", "open", paramQQWalletBaseMsgElem.toString(), 0, null));
    paramQQWalletBaseMsgElem = new Intent(paramContext, PayBridgeActivity.class);
    paramQQWalletBaseMsgElem.putExtras(paramString2);
    paramQQWalletBaseMsgElem.putExtra("pay_requestcode", 5);
    break label905;
    label781:
    do
    {
      try
      {
        paramQQWalletBaseMsgElem = QQWalletHbItemApiImpl.class.getClassLoader();
        if (paramQQWalletBaseMsgElem == null) {
          return false;
        }
        try
        {
          paramQQWalletBaseMsgElem = paramQQWalletBaseMsgElem.loadClass(localCharSequence);
        }
        catch (Exception paramString1) {}
        if (!QLog.isDevelopLevel()) {
          break label781;
        }
      }
      catch (Exception paramString1) {}
      paramString1.printStackTrace();
      paramQQWalletBaseMsgElem = (QQWalletBaseMsgElem)localObject2;
    } while (!QLog.isColorLevel());
    paramQQWalletBaseMsgElem = new StringBuilder();
    paramQQWalletBaseMsgElem.append("QQWalletMsgItemBuilder failed to find Class : ");
    paramQQWalletBaseMsgElem.append(localCharSequence);
    QLog.d("QQWalletHbItemApi", 2, paramQQWalletBaseMsgElem.toString(), paramString1);
    paramQQWalletBaseMsgElem = str;
    if (paramQQWalletBaseMsgElem == null) {
      return false;
    }
    paramString1 = new Intent(paramContext, paramQQWalletBaseMsgElem);
    paramString2 = ((HashMap)localObject1).entrySet().iterator();
    for (;;)
    {
      paramQQWalletBaseMsgElem = paramString1;
      if (!paramString2.hasNext()) {
        break;
      }
      paramQQWalletBaseMsgElem = (Map.Entry)paramString2.next();
      paramString1.putExtra((String)paramQQWalletBaseMsgElem.getKey(), (String)paramQQWalletBaseMsgElem.getValue());
    }
    try
    {
      label905:
      if (!(paramContext instanceof Activity)) {
        paramQQWalletBaseMsgElem.addFlags(268435456);
      }
      paramContext.startActivity(paramQQWalletBaseMsgElem);
      return true;
    }
    catch (Exception paramContext)
    {
      if (QLog.isDevelopLevel()) {
        paramContext.printStackTrace();
      }
      if (QLog.isColorLevel())
      {
        paramQQWalletBaseMsgElem = new StringBuilder();
        paramQQWalletBaseMsgElem.append("QQWalletMsgItemBuilder failed to startActivity : ");
        paramQQWalletBaseMsgElem.append(localCharSequence);
        QLog.d("QQWalletHbItemApi", 2, paramQQWalletBaseMsgElem.toString(), paramContext);
      }
    }
    return false;
  }
  
  private Map<String, String> genComJmpumpParams(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    if ((paramInt == 12) && (this.pskey != null))
    {
      localHashMap.put("pskey_type", "27");
      localHashMap.put("pskey", this.pskey);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.mAppInterface.getCurrentUin());
      localStringBuilder.append("");
      localHashMap.put("recv_uin", localStringBuilder.toString());
      localHashMap.put("recv_nickname", ((IContactUtilsApi)QRoute.api(IContactUtilsApi.class)).getGrayBarShowName(this.sessionInfo.jdField_a_of_type_JavaLangString, this.mAppInterface.getCurrentUin()));
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(getRecvType(this.mAppInterface, this.sessionInfo));
      localStringBuilder.append("");
      localHashMap.put("recv_group_type", localStringBuilder.toString());
      localHashMap.put("recv_group_id", this.sessionInfo.jdField_a_of_type_JavaLangString);
    }
    return localHashMap;
  }
  
  public static MessageForQQWalletMsg getMessageForQQWalletMsg(String paramString)
  {
    return (MessageForQQWalletMsg)sMessageForQQWalletMsgMap.get(paramString);
  }
  
  private static int getRecvType(BaseQQAppInterface paramBaseQQAppInterface, BaseSessionInfo paramBaseSessionInfo)
  {
    if (paramBaseSessionInfo.jdField_a_of_type_Int == 0) {
      return 1;
    }
    if (paramBaseSessionInfo.jdField_a_of_type_Int == 3000) {
      return 2;
    }
    if (paramBaseSessionInfo.jdField_a_of_type_Int == 1) {
      return 3;
    }
    if (paramBaseSessionInfo.jdField_a_of_type_Int == 1000) {
      return 4;
    }
    if (paramBaseSessionInfo.jdField_a_of_type_Int == 1004) {
      return 5;
    }
    if ((paramBaseSessionInfo.jdField_a_of_type_Int != 1001) && (paramBaseSessionInfo.jdField_a_of_type_Int != 10002) && (paramBaseSessionInfo.jdField_a_of_type_Int != 10004)) {
      return 0;
    }
    return 7;
  }
  
  public static String getWordChainHbAioTips(int paramInt)
  {
    if (paramInt == 0) {
      return HardCodeUtil.a(R.string.bB);
    }
    if (paramInt == 1) {
      return HardCodeUtil.a(R.string.dw);
    }
    if (paramInt == 2) {
      return HardCodeUtil.a(R.string.dx);
    }
    return "";
  }
  
  public TextView createGrayBar(Context paramContext)
  {
    init(paramContext);
    paramContext = new TextView(paramContext);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, this.dip23);
    localLayoutParams.topMargin = this.dip8;
    localLayoutParams.bottomMargin = this.dip15;
    localLayoutParams.addRule(3, chat_redpacket_background);
    localLayoutParams.addRule(5, chat_redpacket_background);
    paramContext.setLayoutParams(localLayoutParams);
    paramContext.setMaxWidth(this.dip160);
    paramContext.setTextColor(-8947849);
    paramContext.setBackgroundResource(R.drawable.D);
    int i = this.dip10;
    paramContext.setPadding(i, 0, i, 0);
    paramContext.setClickable(false);
    paramContext.setVisibility(8);
    paramContext.setGravity(16);
    paramContext.setIncludeFontPadding(false);
    paramContext.setSingleLine();
    paramContext.setTextSize(12.0F);
    paramContext.setId(graybar_redpacket);
    return paramContext;
  }
  
  public RelativeLayout createRedPacketBubbleView(IQWalletMsgHolder paramIQWalletMsgHolder, Context paramContext)
  {
    if ((paramIQWalletMsgHolder != null) && (paramContext != null))
    {
      RelativeLayout localRelativeLayout = createRedPacketWithOutGrayBar(paramIQWalletMsgHolder, paramContext);
      paramContext = createGrayBar(paramContext);
      localRelativeLayout.addView(paramContext);
      paramIQWalletMsgHolder.c(paramContext);
      return localRelativeLayout;
    }
    return null;
  }
  
  public RelativeLayout createRedPacketWithOutGrayBar(IQWalletMsgHolder paramIQWalletMsgHolder, Context paramContext)
  {
    if ((paramIQWalletMsgHolder != null) && (paramContext != null))
    {
      init(paramContext);
      RelativeLayout localRelativeLayout1 = new RelativeLayout(paramContext);
      localRelativeLayout1.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
      localRelativeLayout1.setId(R.id.bs);
      paramIQWalletMsgHolder.b(localRelativeLayout1);
      RelativeLayout localRelativeLayout2 = new RelativeLayout(paramContext);
      Object localObject1 = new RelativeLayout.LayoutParams(this.dip160, this.dip240);
      localRelativeLayout2.setId(chat_redpacket_background);
      localRelativeLayout2.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localObject1 = new RoundImageView(paramContext);
      localRelativeLayout2.addView((View)localObject1);
      ((RoundImageView)localObject1).getLayoutParams().width = this.dip160;
      ((RoundImageView)localObject1).getLayoutParams().height = this.dip240;
      paramIQWalletMsgHolder.c(localRelativeLayout2);
      localObject1 = new RelativeLayout(paramContext);
      Object localObject2 = new RelativeLayout.LayoutParams(this.dip160, this.dip240);
      ((RelativeLayout)localObject1).setBackgroundResource(R.drawable.V);
      ((RelativeLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      ((RelativeLayout)localObject1).setVisibility(8);
      paramIQWalletMsgHolder.d((RelativeLayout)localObject1);
      localObject2 = new LinearLayout(paramContext);
      ((LinearLayout)localObject2).setId(chat_redpacket_specify_icon_container);
      ((LinearLayout)localObject2).setOrientation(0);
      ((LinearLayout)localObject2).setGravity(16);
      RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams1.topMargin = this.dip40;
      localLayoutParams1.addRule(10);
      localLayoutParams1.addRule(14);
      ((LinearLayout)localObject2).setLayoutParams(localLayoutParams1);
      ((LinearLayout)localObject2).setVisibility(8);
      paramIQWalletMsgHolder.a((LinearLayout)localObject2);
      RelativeLayout localRelativeLayout3 = new RelativeLayout(paramContext);
      localRelativeLayout3.setId(chat_icon_container);
      RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams2.addRule(10);
      localLayoutParams2.addRule(14);
      localLayoutParams2.topMargin = this.dip90;
      int i = this.dip17;
      localLayoutParams2.leftMargin = i;
      localLayoutParams2.rightMargin = i;
      localRelativeLayout3.setLayoutParams(localLayoutParams2);
      Object localObject3 = new EllipseTextView(paramContext);
      Object localObject4 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject4).addRule(14);
      ((TextView)localObject3).setTextSize(15.0F);
      ((TextView)localObject3).setTextColor(-1);
      ((TextView)localObject3).setLineSpacing(0.0F, 1.1F);
      ((TextView)localObject3).setId(chat_redpacket_subtitle);
      ((TextView)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
      ((RelativeLayout.LayoutParams)localObject4).topMargin = ScreenUtil.dip2px(5.0F);
      localRelativeLayout3.addView((View)localObject3);
      localObject4 = new EllipseTextView(paramContext);
      RelativeLayout.LayoutParams localLayoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams3.addRule(13);
      ((TextView)localObject4).setTextSize(18.0F);
      ((TextView)localObject4).setTextColor(Color.parseColor("#FBD49D"));
      ((TextView)localObject4).setLineSpacing(0.0F, 1.1F);
      ((TextView)localObject4).setId(chat_redpacket_title);
      ((TextView)localObject4).setLayoutParams(localLayoutParams3);
      ((TextView)localObject4).setGravity(17);
      localLayoutParams3.addRule(3, chat_redpacket_subtitle);
      localRelativeLayout3.addView((View)localObject4);
      paramIQWalletMsgHolder.e(localRelativeLayout3);
      paramIQWalletMsgHolder.b((TextView)localObject4);
      paramIQWalletMsgHolder.a((TextView)localObject3);
      localObject4 = new ImageView(paramContext);
      ((ImageView)localObject4).setId(chat_redpacket_customize_bg);
      ((ImageView)localObject4).setVisibility(8);
      ((ImageView)localObject4).setScaleType(ImageView.ScaleType.CENTER_CROP);
      localLayoutParams3 = new RelativeLayout.LayoutParams(this.dip138, this.dip115);
      i = this.dip11;
      localLayoutParams3.setMargins(i, 0, i, 0);
      localLayoutParams3.addRule(12);
      paramIQWalletMsgHolder.a((ImageView)localObject4);
      RelativeLayout localRelativeLayout4 = new RelativeLayout(paramContext);
      localRelativeLayout4.setVisibility(8);
      RelativeLayout.LayoutParams localLayoutParams4 = new RelativeLayout.LayoutParams(-1, -1);
      paramIQWalletMsgHolder.f(localRelativeLayout4);
      localObject3 = new AnimationView(paramContext);
      ((AnimationView)localObject3).setPlayer(new ScrollPlayer((AnimationView)localObject3));
      ((AnimationView)localObject3).setId(chat_redpacket_anim_bg);
      ((AnimationView)localObject3).setVisibility(8);
      ((AnimationView)localObject3).setScaleType(ImageView.ScaleType.CENTER_CROP);
      RelativeLayout.LayoutParams localLayoutParams5 = new RelativeLayout.LayoutParams(this.dip160, this.dip240);
      localLayoutParams5.addRule(14);
      localLayoutParams5.addRule(12);
      paramIQWalletMsgHolder.a((AnimationView)localObject3);
      localRelativeLayout2.addView((View)localObject4, localLayoutParams3);
      localRelativeLayout2.addView((View)localObject3, localLayoutParams5);
      localRelativeLayout2.addView(localRelativeLayout4, localLayoutParams4);
      localRelativeLayout2.addView(localRelativeLayout3, localLayoutParams2);
      localRelativeLayout2.addView((View)localObject2, localLayoutParams1);
      localRelativeLayout1.addView(localRelativeLayout2);
      localRelativeLayout1.addView((View)localObject1);
      paramContext = new AnimationView(paramContext);
      paramContext.setPlayer(new ScrollPlayer((AnimationView)localObject3));
      paramContext.setId(R.id.bC);
      paramContext.setVisibility(8);
      paramIQWalletMsgHolder.b(paramContext);
      return localRelativeLayout1;
    }
    return null;
  }
  
  public void init(Context paramContext)
  {
    if (!this.isInit) {
      try
      {
        if (!this.isInit)
        {
          float f = paramContext.getResources().getDisplayMetrics().density;
          this.dip15 = ((int)(15.0F * f + 0.5F));
          this.dip10 = ((int)(10.0F * f + 0.5F));
          this.dip8 = ((int)(8.0F * f + 0.5F));
          this.dip23 = ((int)(23.0F * f + 0.5F));
          this.dip40 = ((int)(40.0F * f + 0.5F));
          this.dip90 = ((int)(90.0F * f + 0.5F));
          this.dip17 = ((int)(17.0F * f + 0.5F));
          this.dip138 = ((int)(138.0F * f + 0.5F));
          this.dip115 = ((int)(115.0F * f + 0.5F));
          this.dip11 = ((int)(11.0F * f + 0.5F));
          this.dip160 = ((int)(160.0F * f + 0.5F));
          this.dip240 = ((int)(f * 240.0F + 0.5F));
        }
        return;
      }
      finally {}
    }
  }
  
  public void setHbItemClickListener(QQWalletHbItemApiImpl.HbItemClickListener paramHbItemClickListener)
  {
    this.mHbItemClickListener = paramHbItemClickListener;
  }
  
  public boolean setHbOnClickListener(BaseQQAppInterface paramBaseQQAppInterface, IBaseChatPieProxy paramIBaseChatPieProxy, RelativeLayout paramRelativeLayout, BaseSessionInfo paramBaseSessionInfo, int paramInt1, int paramInt2, String paramString)
  {
    if (paramRelativeLayout == null) {
      return false;
    }
    this.mAppInterface = paramBaseQQAppInterface;
    this.sessionInfo = paramBaseSessionInfo;
    this.mBaseChatPie = paramIBaseChatPieProxy;
    paramIBaseChatPieProxy = (MessageForQQWalletMsg)paramRelativeLayout.getTag();
    if (paramIBaseChatPieProxy == null) {
      return false;
    }
    QwUtils.a(paramBaseQQAppInterface, "tenpay.com", new QQWalletHbItemApiImpl.1(this));
    sMessageForQQWalletMsgMap.put(paramIBaseChatPieProxy.mQQWalletRedPacketMsg.redPacketId, paramIBaseChatPieProxy);
    paramBaseQQAppInterface = new StringBuilder();
    paramBaseQQAppInterface.append("CFT-debug redType = ");
    paramBaseQQAppInterface.append(paramInt1);
    QLog.i("QQWalletHbItemApi", 2, paramBaseQQAppInterface.toString());
    int i = paramInt1;
    if (paramInt1 == 4)
    {
      i = paramInt1;
      if (paramInt2 > 0) {
        i = 0;
      }
    }
    paramRelativeLayout.setTag(R.id.cd, Integer.valueOf(i));
    if (i == 1)
    {
      paramBaseQQAppInterface = new StringBuilder();
      paramBaseQQAppInterface.append(HardCodeUtil.a(R.string.bG));
      paramBaseQQAppInterface.append(paramIBaseChatPieProxy.mQQWalletRedPacketMsg.elem.jdField_a_of_type_JavaLangString);
      paramBaseQQAppInterface.append(HardCodeUtil.a(R.string.bF));
      paramRelativeLayout.setContentDescription(paramBaseQQAppInterface.toString());
      paramRelativeLayout.setOnClickListener(this.mPasswordClickListener);
      return true;
    }
    if (i == 2)
    {
      paramBaseQQAppInterface = new StringBuilder();
      paramBaseQQAppInterface.append(HardCodeUtil.a(R.string.bD));
      paramBaseQQAppInterface.append(paramIBaseChatPieProxy.mQQWalletRedPacketMsg.elem.jdField_a_of_type_JavaLangString);
      paramBaseQQAppInterface.append(HardCodeUtil.a(R.string.bL));
      paramRelativeLayout.setContentDescription(paramBaseQQAppInterface.toString());
      paramRelativeLayout.setOnClickListener(this.mPwdVoiceClickListener);
      return true;
    }
    if (i == 8)
    {
      paramBaseQQAppInterface = new StringBuilder();
      paramBaseQQAppInterface.append("K歌红包:");
      paramBaseQQAppInterface.append(paramIBaseChatPieProxy.mQQWalletRedPacketMsg.elem.jdField_a_of_type_JavaLangString);
      paramBaseQQAppInterface.append(HardCodeUtil.a(R.string.bJ));
      paramRelativeLayout.setContentDescription(paramBaseQQAppInterface.toString());
      paramRelativeLayout.setOnClickListener(this.mKSONGClickListener);
      return true;
    }
    if (i == 9)
    {
      paramBaseQQAppInterface = new StringBuilder();
      paramBaseQQAppInterface.append(HardCodeUtil.a(R.string.bz));
      paramBaseQQAppInterface.append(paramIBaseChatPieProxy.mQQWalletRedPacketMsg.elem.jdField_a_of_type_JavaLangString);
      paramBaseQQAppInterface.append(HardCodeUtil.a(R.string.bH));
      paramRelativeLayout.setContentDescription(paramBaseQQAppInterface.toString());
      paramRelativeLayout.setOnClickListener(this.mEmojiClickListener);
      return true;
    }
    if (i == 10)
    {
      paramBaseQQAppInterface = new StringBuilder();
      paramBaseQQAppInterface.append(HardCodeUtil.a(R.string.bA));
      paramBaseQQAppInterface.append(paramIBaseChatPieProxy.mQQWalletRedPacketMsg.elem.jdField_a_of_type_JavaLangString);
      paramBaseQQAppInterface.append(HardCodeUtil.a(R.string.bC));
      paramRelativeLayout.setContentDescription(paramBaseQQAppInterface.toString());
      paramRelativeLayout.setOnClickListener(this.mSolitaireClickListener);
      return true;
    }
    if (i == 11)
    {
      paramBaseQQAppInterface = new StringBuilder();
      paramBaseQQAppInterface.append(HardCodeUtil.a(R.string.bK));
      paramBaseQQAppInterface.append(paramIBaseChatPieProxy.mQQWalletRedPacketMsg.elem.jdField_a_of_type_JavaLangString);
      paramBaseQQAppInterface.append(HardCodeUtil.a(R.string.bE));
      paramRelativeLayout.setContentDescription(paramBaseQQAppInterface.toString());
      paramRelativeLayout.setOnClickListener(this.mDrawClickListener);
      return true;
    }
    if (i == 14)
    {
      paramBaseQQAppInterface = new StringBuilder();
      paramBaseQQAppInterface.append(HardCodeUtil.a(R.string.bM));
      paramBaseQQAppInterface.append(paramIBaseChatPieProxy.mQQWalletRedPacketMsg.elem.jdField_a_of_type_JavaLangString);
      paramBaseQQAppInterface.append(HardCodeUtil.a(R.string.bN));
      paramRelativeLayout.setContentDescription(paramBaseQQAppInterface.toString());
      paramRelativeLayout.setOnClickListener(this.mKuaKuaClickListener);
      return true;
    }
    if (i == 15)
    {
      paramBaseQQAppInterface = new StringBuilder();
      paramBaseQQAppInterface.append(HardCodeUtil.a(R.string.cK));
      paramBaseQQAppInterface.append(paramIBaseChatPieProxy.mQQWalletRedPacketMsg.elem.jdField_a_of_type_JavaLangString);
      paramBaseQQAppInterface.append(HardCodeUtil.a(R.string.bO));
      paramRelativeLayout.setContentDescription(paramBaseQQAppInterface.toString());
      paramRelativeLayout.setOnClickListener(this.mShengpiziClickListener);
      return true;
    }
    paramBaseQQAppInterface = new StringBuilder();
    paramBaseQQAppInterface.append(paramIBaseChatPieProxy.mQQWalletRedPacketMsg.elem.jdField_a_of_type_JavaLangString);
    paramBaseQQAppInterface.append(paramString);
    paramRelativeLayout.setContentDescription(paramBaseQQAppInterface.toString());
    paramRelativeLayout.setOnClickListener(this.onClickListener);
    return true;
  }
  
  public void setOldHbOnClickListener(RelativeLayout paramRelativeLayout, String paramString)
  {
    if (paramRelativeLayout == null) {
      return;
    }
    paramRelativeLayout.setOnClickListener(this.onClickListener);
    paramRelativeLayout.setContentDescription(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.impl.QQWalletHbItemApiImpl
 * JD-Core Version:    0.7.0.1
 */