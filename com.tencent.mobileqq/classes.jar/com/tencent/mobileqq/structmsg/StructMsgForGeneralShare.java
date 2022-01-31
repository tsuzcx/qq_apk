package com.tencent.mobileqq.structmsg;

import actj;
import acup;
import acxj;
import aebu;
import afxi;
import aime;
import airx;
import ajya;
import amdj;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.TextView;
import anqz;
import arik;
import askf;
import avpg;
import axlk;
import axqy;
import axuo;
import axup;
import axuq;
import axur;
import axuz;
import axvd;
import axve;
import axvf;
import axvg;
import axvh;
import axvi;
import axvk;
import axvl;
import axvm;
import axwg;
import axwm;
import axws;
import axwu;
import axxb;
import axxf;
import axxh;
import axxi;
import axxj;
import axxu;
import axxv;
import axxw;
import axxz;
import axyc;
import axyf;
import axyg;
import axyh;
import axyi;
import axyj;
import axym;
import axyn;
import axyo;
import axyp;
import axys;
import axyw;
import axyx;
import axzh;
import axzj;
import axzr;
import axzs;
import aykk;
import banb;
import bbbp;
import bbco;
import bbcz;
import bbeg;
import bbex;
import bfnx;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.activity.TroopInviteStatusFragment;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.businessCard.activity.BusinessCardEditActivity;
import com.tencent.mobileqq.businessCard.data.BusinessCard;
import com.tencent.mobileqq.businessCard.data.CardOCRInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.dating.NearbyTransitActivity;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.receipt.ReceiptMessageDetailFragment;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCServer;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.util.WeakReference;
import nqy;
import org.json.JSONException;
import org.json.JSONObject;
import set;
import vzl;

public class StructMsgForGeneralShare
  extends AbsShareMsg
{
  public static final String KEY_PAY_STAT = "order_pay_state_";
  public static final String LOGO_URL_POSTFIX = ".png";
  public static final String LOGO_URL_PREFIX = "http://combo.b.qq.com/mp/api/logo/";
  private static int jdField_a_of_type_Int;
  private static View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new axvh();
  private static String jdField_a_of_type_JavaLangString = "structmsg.StructMsgForGeneralShare";
  public static int clickedItemIndex;
  public static String eventId;
  public static String eventType;
  public static QIPCModule receiptServer;
  public static String remindBrief;
  public static String tips;
  public String animResId;
  public String atMembers;
  public boolean havaPayInfoInit;
  boolean isMultiVideoItem = false;
  public int mClickpositionX;
  public int mClickpositionY;
  WeakReference<Context> mContext = new WeakReference(null);
  WeakReference<LinearLayout> mExpandView = new WeakReference(null);
  public List<String> mHadPaidList = new ArrayList();
  public boolean mIsPAVideoStructMsg;
  public String mPARedPacket = "";
  public String mVipDonateStr = "";
  public String mWarningTips = "";
  public boolean needSendLongMsgWhenFailed;
  public int pobingTemplateId = 2000;
  
  static
  {
    jdField_a_of_type_Int = -3;
    eventId = "";
    remindBrief = "";
    eventType = "";
    tips = "";
  }
  
  public StructMsgForGeneralShare()
  {
    this.mMsgServiceID = 1;
    this.mMsgAction = "web";
  }
  
  public StructMsgForGeneralShare(Bundle paramBundle)
  {
    super(paramBundle);
    this.mContentLayout = 2;
    this.mMsgServiceID = paramBundle.getInt("req_type", 1);
    this.mNeedRound = paramBundle.getString("icon_need_round");
    Object localObject;
    int i;
    label204:
    String str1;
    String str3;
    boolean bool;
    if (this.mSourceName != null)
    {
      if (this.mSourceName.equalsIgnoreCase(ajya.a(2131714605))) {
        this.mMsgServiceID = 54;
      }
    }
    else
    {
      localObject = paramBundle.getString("new_share_service_id");
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (TextUtils.isDigitsOnly((CharSequence)localObject))) {
        i = Integer.parseInt((String)localObject);
      }
      switch (i)
      {
      default: 
        this.mCreateTime = paramBundle.getString("req_create_time");
        str1 = paramBundle.getString("source_puin");
        localObject = str1;
        if (TextUtils.isEmpty(str1)) {
          localObject = "";
        }
        this.source_puin = ((String)localObject);
        this.mSourceUrl = paramBundle.getString("source_url");
        this.rijAlbumActionData = paramBundle.getString("readinjoy_gallery");
        if (TextUtils.isEmpty(this.mSourceUrl)) {
          this.mSourceUrl = paramBundle.getString("struct_share_key_source_url");
        }
        str1 = paramBundle.getString("detail_url");
        String str2 = paramBundle.getString("category");
        str3 = paramBundle.getString("video_url");
        bool = paramBundle.getBoolean("video_url_load", false);
        i = paramBundle.getInt("layout_item", 2);
        if (!TextUtils.isEmpty(str3)) {
          i = 5;
        }
        if (("web".equals(this.mMsgAction)) && ("micro_app".equals(this.mMsg_A_ActionData)))
        {
          localObject = new axyp();
          label367:
          if (TextUtils.isEmpty(str2)) {
            break label531;
          }
          axuq localaxuq = axuz.a(0);
          localaxuq.b(1);
          localaxuq.a(str2);
          addItem(localaxuq);
          if (!TextUtils.isEmpty(str3)) {
            break label498;
          }
          ((axuq)localObject).a(this.mContentCover, this.mContentTitle, this.mContentSummary, 1);
        }
        break;
      }
    }
    for (;;)
    {
      this.needSendLongMsgWhenFailed = paramBundle.getBoolean("need_send_long_msg_when_failed", false);
      addItem((axup)localObject);
      if (this.mMsgAction == null) {
        this.mMsgAction = "web";
      }
      return;
      if (!this.mSourceName.equalsIgnoreCase(ajya.a(2131693701))) {
        break;
      }
      this.mMsgServiceID = 53;
      break;
      this.mMsgServiceID = i;
      break label204;
      localObject = axuz.a(i);
      break label367;
      label498:
      a((axuq)localObject, bool, str1, this.mContentCover, str3, this.mContentTitle, this.mContentSummary, paramBundle);
      ((axuq)localObject).k = 1;
      continue;
      label531:
      if ((this.mMsgServiceID == 118) && (this.mSourceName != null) && (this.mSourceName.equalsIgnoreCase(ajya.a(2131714603))))
      {
        ((axuq)localObject).a(this.mContentCover, this.mContentTitle, 0, this.mNeedRound);
      }
      else if (TextUtils.isEmpty(str3))
      {
        ((axuq)localObject).a(this.mContentCover, this.mContentTitle, this.mContentSummary, 0, this.mNeedRound);
      }
      else
      {
        a((axuq)localObject, bool, str1, this.mContentCover, str3, this.mContentTitle, this.mContentSummary, paramBundle);
        ((axuq)localObject).k = 0;
      }
    }
  }
  
  public StructMsgForGeneralShare(axwg paramaxwg)
  {
    super(paramaxwg);
    this.mWarningTips = paramaxwg.a("warningTipsContent");
    this.mPARedPacket = paramaxwg.a("paRedPacket");
    this.mVipDonateStr = paramaxwg.a("vipDonate");
    eventId = paramaxwg.a("eventId");
    remindBrief = paramaxwg.a("remindBrief");
    eventType = paramaxwg.a("eventType");
    this.animResId = paramaxwg.a("resid");
    tips = paramaxwg.a("tips");
    this.atMembers = paramaxwg.a("atmembers");
  }
  
  public static boolean HandleMiniAppJump(Context paramContext, String paramString)
  {
    if (MiniAppLauncher.isMiniAppUrl(paramString))
    {
      QLog.d(jdField_a_of_type_JavaLangString, 2, " jump to miniApp: " + paramString);
      return MiniAppLauncher.startMiniApp(paramContext, paramString, 1043, null);
    }
    if ((paramString.startsWith("http://q.url.cn/url/Jump")) || (paramString.startsWith("http://q.url.cn/url/Jump"))) {
      try
      {
        paramString = bfnx.b(paramString.substring(paramString.indexOf("?") + 1));
        HashMap localHashMap = new HashMap();
        localHashMap.putAll(paramString);
        if (localHashMap.containsKey("url"))
        {
          paramString = (String)localHashMap.get("url");
          if (MiniAppLauncher.isMiniAppUrl(paramString))
          {
            QLog.d(jdField_a_of_type_JavaLangString, 2, " jump to miniApp: " + paramString);
            boolean bool = MiniAppLauncher.startMiniApp(paramContext, paramString, 1043, null);
            return bool;
          }
        }
      }
      catch (Exception paramContext)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "parse url failed, ", paramContext);
        return false;
      }
    }
    return false;
  }
  
  private static long a(AbsStructMsg paramAbsStructMsg, FragmentActivity paramFragmentActivity)
  {
    long l1 = paramAbsStructMsg.uniseq;
    if ((paramFragmentActivity.getIntent() != null) && (paramFragmentActivity.getIntent().hasExtra("origin_merge_structing_msg_uniseq")))
    {
      long l2 = paramFragmentActivity.getIntent().getLongExtra("origin_merge_structing_msg_uniseq", -1L);
      if (l2 > 0L) {
        return l2;
      }
    }
    return l1;
  }
  
  private void a(Context paramContext, int paramInt, View paramView)
  {
    if (paramView == null) {}
    axup localaxup;
    do
    {
      do
      {
        return;
        if ((paramInt <= 2) && (paramInt - 1 >= 0))
        {
          i = actj.a(12.0F, paramContext.getResources());
          j = paramView.getPaddingBottom();
          int k = paramView.getPaddingLeft();
          int m = paramView.getPaddingRight();
          localaxup = getItemByIndex(paramInt - 1);
          if (((localaxup instanceof axyo)) && (((axyo)localaxup).a.size() == 1) && ((((axyo)localaxup).a.get(0) instanceof axwu)) && (paramInt - 2 >= 0) && ((getItemByIndex(paramInt - 2) instanceof axyg)) && (axyh.a((axuq)getItemByIndex(paramInt - 2), paramInt - 2)))
          {
            paramView.setPadding(k, i, m, j);
            return;
          }
          if (((localaxup instanceof axyg)) && ((axyh.a((axuq)localaxup, paramInt - 1)) || (this.isMultiVideoItem)))
          {
            paramView.setPadding(k, i, m, j);
            return;
          }
        }
      } while (paramInt != getItemCount() - 1);
      localaxup = getItemByIndex(0);
    } while ((!(localaxup instanceof axyg)) || ((!axyh.a((axuq)localaxup, 0)) && (!this.isMultiVideoItem)));
    paramInt = actj.a(12.0F, paramContext.getResources());
    int i = paramView.getPaddingLeft();
    int j = paramView.getPaddingRight();
    paramView.setPadding(i, paramView.getPaddingTop(), j, paramInt);
  }
  
  private void a(View paramView, Resources paramResources, Bundle paramBundle)
  {
    if ((paramView == null) || (paramResources == null)) {
      return;
    }
    Object localObject = paramView.getLayoutParams();
    int i;
    if (localObject == null)
    {
      localObject = new LinearLayout.LayoutParams(BaseChatItemLayout.A, -2);
      if (hasFlag(4))
      {
        ((ViewGroup.LayoutParams)localObject).width = -1;
        if (paramBundle.getInt("accostType") != AbsStructMsg.SOURCE_ACCOUNT_TYPE_PA) {
          break label129;
        }
        i = 1;
        label64:
        if ((i == 0) || (!hasFlag(4))) {
          paramView.setBackgroundResource(2130838130);
        }
      }
      if (this.mMsgServiceID != 76) {
        break label135;
      }
      ((ViewGroup.LayoutParams)localObject).width = -1;
      paramView.setBackgroundDrawable(null);
    }
    for (;;)
    {
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      return;
      ((ViewGroup.LayoutParams)localObject).width = BaseChatItemLayout.A;
      ((ViewGroup.LayoutParams)localObject).height = -2;
      break;
      label129:
      i = 0;
      break label64;
      label135:
      if ((this.mMsgServiceID == 83) || (this.mMsgServiceID == 108) || (this.mMsgServiceID == 151) || (this.mMsgServiceID == 156))
      {
        ((ViewGroup.LayoutParams)localObject).width = (BaseChatItemLayout.A + actj.a(10.0F, paramResources));
        if (!TextUtils.isEmpty(this.mMsgActionData)) {
          ((ViewGroup.LayoutParams)localObject).width += actj.a(18.0F, paramResources);
        }
        paramView.setBackgroundDrawable(null);
      }
      else if ((this.mMsgServiceID == 114) || (this.mMsgServiceID == 116))
      {
        ((ViewGroup.LayoutParams)localObject).width = BaseChatItemLayout.A;
        if (!TextUtils.isEmpty(this.mMsgActionData)) {
          ((ViewGroup.LayoutParams)localObject).width += actj.a(18.0F, paramResources);
        }
        paramView.setBackgroundDrawable(null);
        if (this.mMsgServiceID == 116)
        {
          paramResources = paramView.findViewById(2131364798);
          if (paramResources != null)
          {
            i = paramResources.getHeight();
            int j = ((ViewGroup.LayoutParams)localObject).width;
            if (j > 2.1312D * i)
            {
              i = (int)(j / 1.776D);
              paramBundle = paramResources.getLayoutParams();
              paramBundle.height = i;
              paramResources.setLayoutParams(paramBundle);
            }
          }
        }
        else if (this.mMsgServiceID == 114)
        {
          paramResources = paramView.findViewById(2131364798);
          if (paramResources != null)
          {
            paramBundle = paramResources.getLayoutParams();
            if (axlk.jdField_a_of_type_Int > 1280) {}
            for (paramBundle.height = actj.a(144.0F, paramResources.getResources());; paramBundle.height = actj.a(112.0F, paramResources.getResources()))
            {
              paramResources.setLayoutParams(paramBundle);
              break;
            }
          }
        }
      }
      else if (this.mMsgServiceID == 98)
      {
        ((ViewGroup.LayoutParams)localObject).width = Math.min(BaseChatItemLayout.A + actj.a(10.0F, paramResources), actj.a(206.0F, paramResources));
        paramView.setBackgroundDrawable(null);
      }
      else if (this.mMsgServiceID == 91)
      {
        ((ViewGroup.LayoutParams)localObject).width = -1;
        paramView.setBackgroundResource(2130838130);
      }
      else if (this.mMsgServiceID == 97)
      {
        ((ViewGroup.LayoutParams)localObject).width = -2;
        paramView.setBackgroundDrawable(null);
      }
      else if ((this.mMsgServiceID == 106) || (this.mMsgServiceID == 107))
      {
        ((ViewGroup.LayoutParams)localObject).width = -2;
        paramView.setBackgroundDrawable(null);
      }
    }
  }
  
  private void a(axuq paramaxuq, boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, Bundle paramBundle)
  {
    String str1 = paramBundle.getString("VINFO");
    String str2 = paramBundle.getString("TINFO");
    int i = paramBundle.getInt("PREVIEW_VIDEO_TIME", 0);
    int j = paramBundle.getInt("PREVIEW_START_POSI", 0);
    int k = paramBundle.getInt("PREVIEW_VIDEO_WIDTH", 0);
    int m = paramBundle.getInt("PREVIEW_VIDEO_HEIGHT", 0);
    int n = paramBundle.getInt("FULL_VIDEO_TIME", 0);
    String str3 = paramBundle.getString("ACCOUNT_UIN");
    String str4 = paramBundle.getString("ACCOUNT_NAME");
    String str5 = paramBundle.getString("ARTICLE_ID");
    int i1 = paramBundle.getInt("TYPE", 0);
    int i2 = paramBundle.getInt("VIDEO_FEED_TYPE", 0);
    long l = paramBundle.getLong("VIDEO_FEED_ID", 0L);
    if (set.a(i1)) {}
    for (paramString2 = new axzs(paramString2, i1, str1, str2, paramString5, i, j, k, m, n, str3, str4, str5, i2, l);; paramString2 = new axzs(paramString2, paramString3, paramBoolean))
    {
      paramString2.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg = this;
      paramString2.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.mMsgUrl = paramString1;
      paramaxuq.a(paramString2);
      paramaxuq.a(new StructMsgItemTitle(paramString4));
      return;
    }
  }
  
  public static void dealMsgBeforeClick(StructMsgForGeneralShare paramStructMsgForGeneralShare, ChatMessage paramChatMessage)
  {
    if ((paramStructMsgForGeneralShare == null) || (paramChatMessage == null)) {}
    do
    {
      return;
      if ((paramStructMsgForGeneralShare.mMsgServiceID == 14) && (!TextUtils.isEmpty(paramStructMsgForGeneralShare.mMsg_A_ActionData)) && (!paramStructMsgForGeneralShare.mMsg_A_ActionData.contains("&referee="))) {
        paramStructMsgForGeneralShare.mMsg_A_ActionData = String.format("%s&referee=%s", new Object[] { paramStructMsgForGeneralShare.mMsg_A_ActionData, paramChatMessage.senderuin });
      }
    } while (!QLog.isColorLevel());
    QLog.i(jdField_a_of_type_JavaLangString, 2, String.format("dealMsgBeforeClick service_id:%s, data:%s, frd_uin:%s, sender_uin:%s", new Object[] { Integer.valueOf(paramStructMsgForGeneralShare.mMsgServiceID), paramStructMsgForGeneralShare.mMsg_A_ActionData, paramChatMessage.frienduin, paramChatMessage.senderuin }));
  }
  
  public static String getCoverForChatHistory(axup paramaxup)
  {
    if ((paramaxup instanceof axws)) {
      return ((axws)paramaxup).S;
    }
    return null;
  }
  
  static String getResponseRedirectLocation(String paramString)
  {
    try
    {
      paramString = (HttpURLConnection)new URL(paramString).openConnection();
      paramString.setInstanceFollowRedirects(false);
      paramString.setRequestMethod("GET");
      paramString.setConnectTimeout(3000);
      paramString.connect();
      paramString = paramString.getHeaderField("location");
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "getResponseRedirectLocation  location = " + paramString);
      }
      return paramString;
    }
    catch (MalformedURLException paramString)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "getResponseRedirectLocation  MalformedURLException ", paramString);
        }
        paramString = null;
      }
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "getResponseRedirectLocation  IOException ", paramString);
        }
        paramString = null;
      }
    }
  }
  
  public static String getSummary(axup paramaxup)
  {
    if ((paramaxup instanceof axzj)) {
      return ((axzj)paramaxup).Y;
    }
    return null;
  }
  
  public static String getTitleForChatHistory(axup paramaxup)
  {
    if ((paramaxup instanceof axur)) {
      return ((axur)paramaxup).Y;
    }
    return null;
  }
  
  static boolean handleNearbyPublicAccountMsg(QQAppInterface paramQQAppInterface, Context paramContext, StructMsgForGeneralShare paramStructMsgForGeneralShare)
  {
    bool2 = false;
    bool1 = bool2;
    String str1;
    String str2;
    if (paramStructMsgForGeneralShare.mMsgBrief.contains(ajya.a(2131714601)))
    {
      str1 = getResponseRedirectLocation(paramStructMsgForGeneralShare.mMsgUrl);
      bool1 = bool2;
      if (str1 != null)
      {
        bool1 = bool2;
        if (str1.contains("find_school_mate_guide"))
        {
          int i = str1.indexOf("find_school_mate_guide");
          bool1 = bool2;
          if (i > 0) {
            str2 = str1.substring(i + "find_school_mate_guide".length() + 1);
          }
        }
      }
    }
    try
    {
      str2 = URLDecoder.decode(str2, "UTF-8");
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "handleNearbyPublicAccountMsg find shoolmate msg clicked, url =  " + str1 + ",schema = " + str2);
      }
      paramQQAppInterface = bbex.a(paramQQAppInterface, paramContext, str2);
      bool1 = bool2;
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface.c();
        bool1 = true;
      }
    }
    catch (UnsupportedEncodingException paramQQAppInterface)
    {
      for (;;)
      {
        paramQQAppInterface.printStackTrace();
        bool1 = bool2;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "handleNearbyPublicAccountMsg  result = " + bool1 + ",msg.mMsgBrief = " + paramStructMsgForGeneralShare.mMsgBrief);
    }
    return bool1;
  }
  
  public static void onClickEvent(QQAppInterface paramQQAppInterface, Context paramContext, StructMsgForGeneralShare paramStructMsgForGeneralShare, View paramView, axvm paramaxvm)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    boolean bool4 = false;
    boolean bool3 = false;
    Object localObject1 = paramView.getTag();
    label113:
    Object localObject3;
    if ((localObject1 != null) && ((localObject1 instanceof aebu)))
    {
      localObject1 = ((aebu)localObject1).a;
      paramStructMsgForGeneralShare.uniseq = ((ChatMessage)localObject1).uniseq;
      paramStructMsgForGeneralShare.uin = ((ChatMessage)localObject1).frienduin;
      paramStructMsgForGeneralShare.uinType = ((ChatMessage)localObject1).istroop;
      paramStructMsgForGeneralShare.currentAccountUin = ((ChatMessage)localObject1).selfuin;
      paramStructMsgForGeneralShare.messageVersion = ((ChatMessage)localObject1).versionCode;
      if (!"web".equals(paramStructMsgForGeneralShare.mMsgAction)) {
        break label2293;
      }
      if (!TextUtils.isEmpty(paramStructMsgForGeneralShare.mMsgActionData)) {
        break label438;
      }
      paramView = paramStructMsgForGeneralShare.mMsg_A_ActionData;
      localObject3 = paramStructMsgForGeneralShare.rijAlbumActionData;
      if ((TextUtils.isEmpty(paramView)) || ((paramStructMsgForGeneralShare.mMsgServiceID != 151) && (paramStructMsgForGeneralShare.mMsgServiceID != 156))) {
        break label446;
      }
      paramContext = bbex.a(paramQQAppInterface, paramContext, paramView);
      if (paramContext == null) {
        break label3992;
      }
      paramContext.c();
      bool1 = true;
    }
    for (;;)
    {
      int i;
      label173:
      label209:
      int k;
      label438:
      label446:
      Object localObject4;
      label1034:
      Bundle localBundle;
      String[] arrayOfString2;
      if (bool1)
      {
        i = 1;
        if (paramStructMsgForGeneralShare.mMsgServiceID == 91)
        {
          axqy.b(paramQQAppInterface, "dc00898", "", "", "0X8007758", "0X8007758", 0, 0, "", "", "", "");
          axqy.b(paramQQAppInterface, "P_CliOper", "Pb_account_lifeservice", paramStructMsgForGeneralShare.uin, "0X80055C7", "0X80055C7", 0, i, "" + paramStructMsgForGeneralShare.msgId, paramStructMsgForGeneralShare.templateIDForPortal, "", paramStructMsgForGeneralShare.mMsgUrl);
          paramContext = new StringBuilder().append("MSGID=").append(Long.toString(paramStructMsgForGeneralShare.msgId)).append(";TEPLATEID=").append(paramStructMsgForGeneralShare.templateIDForPortal).append(";ARTICALID=").append("").append(";REFERRER=").append(axup.a(paramStructMsgForGeneralShare.mMsgUrl));
          axqy.b(paramQQAppInterface, "P_CliOper", "Pb_account_lifeservice", paramStructMsgForGeneralShare.uin, "0X8005D49", "0X8005D49", 0, i, paramContext.toString(), "", "", "");
          do
          {
            return;
            if ((localObject1 != null) && ((localObject1 instanceof aime)))
            {
              localObject1 = (ChatMessage)((aime)localObject1).a;
              break;
            }
            if ((localObject1 != null) && ((localObject1 instanceof afxi)))
            {
              localObject1 = (ChatMessage)((afxi)localObject1).a;
              break;
            }
          } while (!(localObject1 instanceof MessageForStructing));
          localObject1 = (MessageForStructing)localObject1;
          break;
          paramView = paramStructMsgForGeneralShare.mMsgActionData;
          break label113;
          if ((!TextUtils.isEmpty((CharSequence)localObject3)) && (((String)localObject3).startsWith("mqqapi://readinjoy/openatlas")))
          {
            paramContext = bbex.a(paramQQAppInterface, paramContext, (String)localObject3);
            if (paramContext != null) {
              paramContext.c();
            }
            for (bool1 = true;; bool1 = false)
            {
              if (QLog.isColorLevel()) {
                QLog.d(jdField_a_of_type_JavaLangString, 2, "handle readinjoy gallery jump rijAlbumActionData = " + (String)localObject3);
              }
              break;
              paramaxvm.a(paramStructMsgForGeneralShare.mMsgUrl);
            }
          }
          if ((!TextUtils.isEmpty(paramView)) && (paramView.startsWith("mqqapi://dating/")))
          {
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "handle dating jump .msg.mMsgUrl = " + paramStructMsgForGeneralShare.mMsgUrl);
            }
            paramView = new Intent(paramContext, QQBrowserActivity.class);
            paramView.putExtra("url", paramStructMsgForGeneralShare.mMsgUrl);
            paramContext.startActivity(paramView);
            bool1 = true;
            continue;
          }
          if ((!TextUtils.isEmpty(paramView)) && ((paramStructMsgForGeneralShare.mMsgServiceID == 65) || (paramStructMsgForGeneralShare.mMsgServiceID == 69)))
          {
            paramaxvm = new Intent(paramContext, NearbyTransitActivity.class);
            paramaxvm.putExtra("action", 1);
            paramaxvm.putExtra("hotnamecode", paramView);
            paramaxvm.putExtra("enter_time", System.currentTimeMillis());
            paramContext.startActivity(paramaxvm);
            bool1 = true;
            continue;
          }
          if ((!TextUtils.isEmpty(paramView)) && (paramView.startsWith("story:")))
          {
            paramContext = bbex.a(paramQQAppInterface, paramContext, paramView.substring("story:".length()));
            if (paramContext != null) {
              paramContext.c();
            }
            for (bool2 = true;; bool2 = false)
            {
              bool1 = bool2;
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d(jdField_a_of_type_JavaLangString + "Q.qqstory.TAG_NOW_ENTRANCE_ACTION_CONFIG", 2, "handle now jump actionData = " + paramView);
              bool1 = bool2;
              break;
              paramaxvm.a(paramStructMsgForGeneralShare.mMsgUrl);
            }
          }
          if (paramStructMsgForGeneralShare.mMsgServiceID == 60)
          {
            paramaxvm.a(paramStructMsgForGeneralShare.mMsgUrl);
            bool1 = false;
            continue;
          }
          if ((!TextUtils.isEmpty(paramStructMsgForGeneralShare.mMsgUrl)) && ((paramStructMsgForGeneralShare.mMsgUrl.startsWith("https://jq.qq.com")) || (paramStructMsgForGeneralShare.mMsgUrl.startsWith("http://jq.qq.com"))))
          {
            paramaxvm.a(paramStructMsgForGeneralShare.mMsgUrl);
            bool1 = false;
            continue;
          }
          if ((!TextUtils.isEmpty(paramStructMsgForGeneralShare.mMsgUrl)) && ((paramStructMsgForGeneralShare.mMsgUrl.startsWith("http://now.qq.com")) || (paramStructMsgForGeneralShare.mMsgUrl.startsWith("https://now.qq.com"))))
          {
            if ((paramStructMsgForGeneralShare.mMsgUrl.contains("http://now.qq.com/huayang/jiaoyou/share.html")) || (paramStructMsgForGeneralShare.mMsgUrl.contains("https://now.qq.com/huayang/jiaoyou/share.html")))
            {
              k = 1;
              if ((!paramStructMsgForGeneralShare.mMsgUrl.contains("http://now.qq.com/h5/index.html")) && (!paramStructMsgForGeneralShare.mMsgUrl.contains("http://now.qq.com/h5/story.html")) && (!paramStructMsgForGeneralShare.mMsgUrl.contains("https://now.qq.com/h5/index.html")) && (!paramStructMsgForGeneralShare.mMsgUrl.contains("https://now.qq.com/h5/story.html")) && (k == 0)) {
                break label1155;
              }
              bool3 = true;
            }
            for (;;)
            {
              if (bool3)
              {
                localObject4 = paramStructMsgForGeneralShare.mMsgUrl.substring(paramStructMsgForGeneralShare.mMsgUrl.indexOf("?") + 1);
                String[] arrayOfString1 = ((String)localObject4).split("&");
                localBundle = new Bundle();
                localBundle.putString("url", paramStructMsgForGeneralShare.mMsgUrl);
                localObject1 = "";
                i = 0;
                localObject3 = "0";
                int m = 0;
                for (;;)
                {
                  if (m < arrayOfString1.length)
                  {
                    arrayOfString2 = arrayOfString1[m].split("=");
                    if (arrayOfString2.length != 2)
                    {
                      paramView = (View)localObject3;
                      label1137:
                      m += 1;
                      localObject3 = paramView;
                      continue;
                      k = 0;
                      break;
                      label1155:
                      bool3 = false;
                      break label1034;
                    }
                    paramView = (View)localObject3;
                  }
                }
              }
            }
          }
        }
      }
      label3986:
      label3989:
      for (;;)
      {
        for (;;)
        {
          for (;;)
          {
            try
            {
              for (;;)
              {
                if ("roomid".equals(arrayOfString2[0])) {
                  paramView = arrayOfString2[1];
                }
                localObject3 = paramView;
                if (!"first".equals(arrayOfString2[0])) {
                  break label3986;
                }
                localObject3 = paramView;
                int j = Integer.parseInt(arrayOfString2[1]);
                i = j;
                localObject3 = localObject1;
                try
                {
                  if ("sharefrom".equals(arrayOfString2[0]))
                  {
                    localObject3 = arrayOfString2[1];
                    localObject1 = localObject3;
                    localBundle.putString("from", (String)localObject3);
                  }
                }
                catch (NumberFormatException localNumberFormatException2) {}
                try
                {
                  if (TextUtils.isEmpty((CharSequence)localObject3)) {
                    break label3989;
                  }
                  j = arik.a((String)localObject3);
                  i = j;
                  j = i;
                  if (i == 0) {
                    j = 2;
                  }
                  i = j;
                  localObject1 = localObject3;
                }
                catch (NumberFormatException localNumberFormatException1)
                {
                  localObject2 = localNumberFormatException2;
                }
              }
              try
              {
                paramView = new StringBuilder((String)localObject4);
                if (!((String)localObject4).contains("first=")) {
                  paramView.append("&first=").append(i);
                }
                paramView.append("&fromid=share_msg_").append((String)localObject1);
                paramView.append("&startsrc=share_msg_").append((String)localObject1);
                if (k != 0) {
                  paramView.append("&msgurl=").append(bbco.encodeToString(paramStructMsgForGeneralShare.mMsgUrl.getBytes(), 0));
                }
                if (0L != Long.parseLong((String)localObject3)) {
                  continue;
                }
                bool1 = paramaxvm.a(paramStructMsgForGeneralShare.mMsgUrl);
                bool2 = bool1;
              }
              catch (NumberFormatException paramContext)
              {
                paramaxvm.a(paramStructMsgForGeneralShare.mMsgUrl);
                continue;
              }
              bool1 = bool2;
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d(jdField_a_of_type_JavaLangString + "Q.qqstory.TAG_NOW_ENTRANCE_ACTION_CONFIG", 2, "handle now jump .msg.mMsgUrl = " + paramStructMsgForGeneralShare.mMsgUrl + "|isUrlInWhileList:" + bool3);
              bool1 = bool2;
            }
            catch (NumberFormatException paramView)
            {
              paramView = localNumberFormatException2;
            }
            paramView = "nowmqqapi://now/openroom?" + paramView.toString();
            localObject1 = new Intent(paramContext, JumpActivity.class);
            ((Intent)localObject1).setData(Uri.parse(paramView));
            ((Intent)localObject1).putExtra("big_brother_source_key", "biz_src_jc_aio");
            paramContext.startActivity((Intent)localObject1);
            continue;
            bool2 = paramaxvm.a(paramStructMsgForGeneralShare.mMsgUrl);
            continue;
            if ((TextUtils.isEmpty(paramStructMsgForGeneralShare.mMsgUrl)) || (!paramStructMsgForGeneralShare.mMsgUrl.startsWith("mqqapi://qsubscribe"))) {
              continue;
            }
            try
            {
              paramView = new Intent(paramContext, JumpActivity.class);
              paramView.setData(Uri.parse(paramStructMsgForGeneralShare.mMsgUrl));
              paramView.putExtra("from", "from_aio");
              paramContext.startActivity(paramView);
              bool1 = bool3;
            }
            catch (Throwable paramContext)
            {
              QLog.e(jdField_a_of_type_JavaLangString, 2, "jump by msg.mMsgUrl error, url =  " + QLog.getStackTraceString(paramContext));
              bool1 = bool3;
            }
          }
          break;
          if ((!TextUtils.isEmpty(paramView)) && (paramView.startsWith("apollo:")))
          {
            paramView = paramStructMsgForGeneralShare.mMsgUrl.split("\\?");
            if ((paramView.length == 2) && (airx.a(paramContext)))
            {
              paramView = paramView[1];
              paramContext.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("mqqapi://cmshow/apollo_action?" + paramView)));
              bool1 = true;
              break;
            }
            bool1 = false;
            continue;
          }
          if (((ChatMessage)localObject1).istroop == 1)
          {
            bool1 = paramaxvm.a(paramStructMsgForGeneralShare.mMsgUrl);
            break;
          }
          if (paramStructMsgForGeneralShare.hasFlag(16))
          {
            paramView = paramStructMsgForGeneralShare.mMsgUrl;
            paramContext = paramView;
            if (paramView != null)
            {
              localObject3 = new StringBuilder().append(paramView);
              if (paramView.indexOf('?') != -1)
              {
                paramContext = "&";
                paramContext = ((StringBuilder)localObject3).append(paramContext).append("f_hbType=");
                if (((ChatMessage)localObject1).istroop != 1) {
                  continue;
                }
                i = 1;
                paramContext = i + "&f_hbUin=" + ((ChatMessage)localObject1).frienduin;
              }
            }
            else
            {
              if (QLog.isDevelopLevel()) {
                QLog.d("PortalManager", 4, paramContext);
              }
              bool1 = paramaxvm.a(paramContext);
              break;
            }
            paramContext = "?";
            continue;
            i = 2;
            continue;
          }
          if ((paramStructMsgForGeneralShare.mMsgServiceID == 53) || (paramStructMsgForGeneralShare.mMsgServiceID == 54)) {
            try
            {
              if (!paramaxvm.c("mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=cooperation.readinjoy.ReadInJoyProxyActivity&url=" + URLEncoder.encode(paramStructMsgForGeneralShare.mMsgUrl) + "&from=" + paramStructMsgForGeneralShare.mMsgServiceID, null))
              {
                bool1 = paramaxvm.a(paramStructMsgForGeneralShare.mMsgUrl);
                break;
              }
              bool1 = true;
            }
            catch (Exception paramContext)
            {
              if (QLog.isColorLevel()) {
                QLog.d(jdField_a_of_type_JavaLangString, 2, "ReadInJoyShareMsg click error, url =  " + paramStructMsgForGeneralShare.mMsgUrl);
              }
              paramContext.printStackTrace();
              bool1 = paramaxvm.a(paramStructMsgForGeneralShare.mMsgUrl);
            }
          }
        }
        if ((paramStructMsgForGeneralShare.mMsgServiceID == 15) && ((!TextUtils.isEmpty(paramStructMsgForGeneralShare.mMsgActionData)) || (!TextUtils.isEmpty(paramStructMsgForGeneralShare.mMsg_I_ActionData))))
        {
          paramaxvm = paramStructMsgForGeneralShare.mMsgActionData;
          paramView = paramaxvm;
          if (TextUtils.isEmpty(paramaxvm)) {
            paramView = paramStructMsgForGeneralShare.mMsg_I_ActionData;
          }
          bool1 = bool3;
          if (TextUtils.isEmpty(paramView)) {
            break;
          }
          paramView = paramView.split(":");
          bool1 = bool3;
          if (paramView.length != 2) {
            break;
          }
          bool1 = bool3;
          if (!"group".equals(paramView[0])) {
            break;
          }
          bool1 = bool3;
          if (TextUtils.isEmpty(paramView[1])) {
            break;
          }
          banb.a(paramContext, TroopInfoActivity.a(paramView[1], 14), 2);
          bool1 = true;
          break;
        }
        bool2 = bool1;
        if (paramStructMsgForGeneralShare.uin.equals("3242766078")) {
          bool2 = handleNearbyPublicAccountMsg(paramQQAppInterface, paramContext, paramStructMsgForGeneralShare);
        }
        bool1 = bool2;
        if (bool2) {
          break;
        }
        bool1 = paramaxvm.a(paramStructMsgForGeneralShare.mMsgUrl);
        break;
        if (paramStructMsgForGeneralShare.mMsgServiceID != 97) {
          break label209;
        }
        axqy.b(paramQQAppInterface, "dc00898", "", "", "0X8007ADA", "0X8007ADA", 0, 0, "", "", "", "");
        break label209;
        label2293:
        if ("plugin".equals(paramStructMsgForGeneralShare.mMsgAction))
        {
          if (paramStructMsgForGeneralShare.mMsgServiceID == 14) {
            dealMsgBeforeClick(paramStructMsgForGeneralShare, (ChatMessage)localObject1);
          }
          if (paramQQAppInterface != null)
          {
            bool1 = paramaxvm.c(paramStructMsgForGeneralShare.mMsgActionData, paramStructMsgForGeneralShare.mMsg_A_ActionData);
            i = 0;
            if (bool1) {
              i = 1;
            }
            axqy.b(paramQQAppInterface, "P_CliOper", "Pb_account_lifeservice", paramStructMsgForGeneralShare.uin, "0X80055C7", "0X80055C7", 0, i, "" + paramStructMsgForGeneralShare.msgId, paramStructMsgForGeneralShare.templateIDForPortal, "", paramStructMsgForGeneralShare.mMsgUrl);
            paramContext = new StringBuilder().append("MSGID=").append(Long.toString(paramStructMsgForGeneralShare.msgId)).append(";TEPLATEID=").append(paramStructMsgForGeneralShare.templateIDForPortal).append(";ARTICALID=").append("").append(";REFERRER=").append(axup.a(paramStructMsgForGeneralShare.mMsgUrl));
            axqy.b(paramQQAppInterface, "P_CliOper", "Pb_account_lifeservice", paramStructMsgForGeneralShare.uin, "0X8005D49", "0X8005D49", 0, i, paramContext.toString(), "", "", "");
            return;
          }
          bool1 = false;
          continue;
        }
        if ("viewMultiMsg".equals(paramStructMsgForGeneralShare.mMsgAction))
        {
          localObject1 = (FragmentActivity)paramContext;
          if (((FragmentActivity)localObject1).getChatFragment() != null)
          {
            i = ((FragmentActivity)localObject1).getChatFragment().a().b();
            localObject3 = ((FragmentActivity)localObject1).getChatFragment().a().a();
            localObject4 = ((FragmentActivity)localObject1).getChatFragment().a().c();
            paramaxvm = new Intent(paramContext, MultiForwardActivity.class);
            paramaxvm.putExtra("chat_subType", 3);
            paramaxvm.putExtra("uin", (String)localObject3);
            paramaxvm.putExtra("uintype", i);
            paramaxvm.putExtra("troop_code", (String)localObject4);
            paramaxvm.putExtra("multi_url", paramStructMsgForGeneralShare.mResid);
            paramaxvm.putExtra("multimsg_uniseq", paramStructMsgForGeneralShare.uniseq);
            paramaxvm.putExtra("origin_merge_structing_msg_uniseq", a(paramStructMsgForGeneralShare, (FragmentActivity)localObject1));
            paramView = (ViewGroup)paramView;
            if (paramView.getChildCount() > 0)
            {
              localObject1 = paramView.getChildAt(0);
              if (ViewGroup.class.isInstance(localObject1))
              {
                paramView = (ViewGroup)localObject1;
                continue;
              }
              if (!TextView.class.isInstance(localObject1)) {
                continue;
              }
              paramaxvm.putExtra("multi_title", ((TextView)localObject1).getText().toString());
            }
            paramContext.startActivity(paramaxvm);
          }
          bool1 = true;
          i = 0;
          if (bool1) {
            i = 1;
          }
          axqy.b(paramQQAppInterface, "P_CliOper", "Pb_account_lifeservice", paramStructMsgForGeneralShare.uin, "0X80055C7", "0X80055C7", 0, i, "" + paramStructMsgForGeneralShare.msgId, paramStructMsgForGeneralShare.templateIDForPortal, "", paramStructMsgForGeneralShare.mMsgUrl);
          paramContext = new StringBuilder().append("MSGID=").append(Long.toString(paramStructMsgForGeneralShare.msgId)).append(";TEPLATEID=").append(paramStructMsgForGeneralShare.templateIDForPortal).append(";ARTICALID=").append("").append(";REFERRER=").append(axup.a(paramStructMsgForGeneralShare.mMsgUrl));
          axqy.b(paramQQAppInterface, "P_CliOper", "Pb_account_lifeservice", paramStructMsgForGeneralShare.uin, "0X8005D49", "0X8005D49", 0, i, paramContext.toString(), "", "", "");
          return;
        }
        if ("viewFlower".equals(paramStructMsgForGeneralShare.mMsgAction))
        {
          paramaxvm.a(paramView, paramStructMsgForGeneralShare.uin);
          bool1 = bool4;
        }
        else
        {
          if ("shareBusinessCard".equals(paramStructMsgForGeneralShare.mMsgAction))
          {
            if (paramStructMsgForGeneralShare.mMsg_A_ActionData != null)
            {
              paramView = paramStructMsgForGeneralShare.mMsg_A_ActionData.split(";");
              if ((paramView != null) && (paramView.length == 3))
              {
                localObject1 = paramView[0].substring("url=".length());
                paramaxvm = paramView[1].substring("name=".length());
                paramView = paramView[2].substring("phone=".length());
                bool1 = bool4;
                if (TextUtils.isEmpty((CharSequence)localObject1)) {
                  continue;
                }
                localObject3 = (amdj)paramQQAppInterface.getManager(112);
                bool1 = bool4;
                if (localObject3 == null) {
                  continue;
                }
                localObject4 = ((amdj)localObject3).c((String)localObject1);
                localObject3 = new Intent(paramContext, BusinessCardEditActivity.class);
                ((Intent)localObject3).putExtra("source_activity", 2);
                if (localObject4 != null)
                {
                  ((Intent)localObject3).putExtra("cur_card_id", ((BusinessCard)localObject4).cardId);
                  if (((BusinessCard)localObject4).cardType == 1)
                  {
                    ((Intent)localObject3).putExtra("mode_type", 3);
                    ((Intent)localObject3).putExtra("is_edit_mode", false);
                    paramContext.startActivity((Intent)localObject3);
                    bool1 = bool4;
                    continue;
                  }
                  ((Intent)localObject3).putExtra("mode_type", 0);
                  continue;
                }
                localObject4 = new CardOCRInfo();
                ((CardOCRInfo)localObject4).jdField_b_of_type_JavaLangString = ((String)localObject1);
                ((CardOCRInfo)localObject4).jdField_a_of_type_JavaLangString = paramaxvm;
                ((CardOCRInfo)localObject4).jdField_b_of_type_JavaUtilList.add(paramView);
                ((Intent)localObject3).putExtra("mode_type", 0);
                ((Intent)localObject3).putExtra("finish_immedia", true);
                ((Intent)localObject3).putExtra("is_edit_mode", false);
                ((Intent)localObject3).putExtra("cur_ocr_info", (Parcelable)localObject4);
                continue;
              }
            }
          }
          else
          {
            if ("viewReceiptMessage".equals(paramStructMsgForGeneralShare.mMsgAction))
            {
              paramView = (FragmentActivity)paramContext;
              if (paramView.getChatFragment() != null)
              {
                paramaxvm = new Intent();
                paramaxvm.putExtra("ReceiptMessageDetailFragment.extra_msg_uni_seq", ((ChatMessage)localObject1).uniseq);
                paramaxvm.putExtra("ReceiptMessageDetailFragment.extra_res_id", paramStructMsgForGeneralShare.mResid);
                paramaxvm.putExtra("ReceiptMessageDetailFragment.extra_msg_session_info", paramView.getChatFragment().a().jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
                paramaxvm.putExtra("ReceiptMessageDetailFragment.extra_shmsgseq", ((ChatMessage)localObject1).shmsgseq);
                paramaxvm.putExtra("ReceiptMessageDetailFragment.extra_sender_uin", ((ChatMessage)localObject1).senderuin);
                paramaxvm.putExtra("ReceiptMessageDetailFragment.extra_msg_seq", ((ChatMessage)localObject1).msgseq);
                paramaxvm.putExtra("ReceiptMessageDetailFragment.extra_msg_uid", ((ChatMessage)localObject1).msgUid);
                paramaxvm.putExtra("ReceiptMessageDetailFragment.extra_msg_time", ((ChatMessage)localObject1).time);
                paramaxvm.putExtra("ReceiptMessageDetailFragment.EXTRA_SESSION_TYPE_FROM_MESSAGE", ((ChatMessage)localObject1).istroop);
                paramaxvm.putExtra("ReceiptMessageDetailFragment.EXTRA_IS_READ", "1".equals(avpg.a((MessageRecord)localObject1)));
                paramView.getChatFragment().a().bd();
                PublicFragmentActivity.a(paramContext, paramaxvm, ReceiptMessageDetailFragment.class);
                i = paramView.getChatFragment().a().jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
                if (i == 0)
                {
                  j = 1;
                  i = -1;
                  paramContext = "";
                  paramView = paramContext;
                  k = i;
                  if (paramStructMsgForGeneralShare.getStructMsgItemLists() == null) {
                    continue;
                  }
                  paramView = paramContext;
                  k = i;
                  if (paramStructMsgForGeneralShare.getStructMsgItemLists().size() <= 0) {
                    continue;
                  }
                  paramaxvm = (axup)paramStructMsgForGeneralShare.getStructMsgItemLists().get(0);
                  paramView = paramContext;
                  k = i;
                  if (!(paramaxvm instanceof axxz)) {
                    continue;
                  }
                  paramaxvm = ((axxz)paramaxvm).a.iterator();
                  paramView = paramContext;
                  k = i;
                  if (!paramaxvm.hasNext()) {
                    continue;
                  }
                  paramView = (axup)paramaxvm.next();
                  k = i;
                  if ("type".equals(paramView.jdField_a_of_type_JavaLangString))
                  {
                    k = i;
                    if ((paramView instanceof axzr)) {
                      i = ((axzr)paramView).k;
                    }
                  }
                }
                switch (i)
                {
                default: 
                  k = i;
                  i = k;
                  continue;
                  if (i == 3000)
                  {
                    j = 2;
                    continue;
                  }
                  j = 3;
                  break;
                case 2: 
                  paramContext = "pic";
                  break;
                case 1: 
                  paramContext = "msg";
                  break;
                case 3: 
                  paramContext = "ptt";
                  break;
                }
                if (k > -1)
                {
                  paramaxvm = ((ChatMessage)localObject1).senderuin;
                  if (!((ChatMessage)localObject1).isSend()) {
                    continue;
                  }
                  paramContext = "1";
                  axqy.b(paramQQAppInterface, "CliOper", "", paramaxvm, "0x80083E9", "0x80083E9", j, 0, paramContext, "", paramView, "");
                }
              }
              bool1 = true;
              continue;
              paramContext = "2";
              continue;
            }
            if (("native".equals(paramStructMsgForGeneralShare.mMsgAction)) && (paramStructMsgForGeneralShare.mMsgServiceID == 128) && (paramStructMsgForGeneralShare.message != null) && (paramStructMsgForGeneralShare.mDatas != null))
            {
              paramaxvm = paramStructMsgForGeneralShare.mDatas.optString("groupcode");
              localObject1 = paramStructMsgForGeneralShare.mDatas.optString("groupname");
              if (paramStructMsgForGeneralShare.message.isSend())
              {
                paramView = paramStructMsgForGeneralShare.message.frienduin;
                TroopInviteStatusFragment.a(paramQQAppInterface, paramContext, paramaxvm, (String)localObject1, paramView, Long.valueOf(paramStructMsgForGeneralShare.mDatas.optString("msgseq")).longValue(), paramStructMsgForGeneralShare.message.senderuin, bbcz.a(paramQQAppInterface, paramStructMsgForGeneralShare.message.senderuin, 0));
                bbbp.a("Grp_AIO", "invite", "send_clk", 0, 0, new String[0]);
                bool1 = true;
                continue;
              }
              paramView = paramStructMsgForGeneralShare.message.selfuin;
              continue;
            }
            bool1 = paramaxvm.a(paramStructMsgForGeneralShare.mMsgAction, paramStructMsgForGeneralShare.mMsgUrl, paramStructMsgForGeneralShare.mMsgActionData, paramStructMsgForGeneralShare.mMsg_A_ActionData);
            continue;
            break label1137;
            break label1137;
            break label1137;
          }
          Object localObject2 = "";
          paramaxvm = "";
          paramView = "";
          continue;
          i = 0;
          break label173;
        }
      }
      label3992:
      bool1 = false;
    }
  }
  
  public static void unRegisterQIPC()
  {
    if (receiptServer != null)
    {
      QIPCServerHelper.getInstance().getServer().unRegisterModule(receiptServer);
      receiptServer = null;
    }
  }
  
  public boolean LayoutEquals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (this == paramObject) {
      bool1 = true;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramObject == null);
      bool1 = bool2;
    } while (getClass() != paramObject.getClass());
    paramObject = (StructMsgForGeneralShare)paramObject;
    return getLayoutStr().equals(paramObject.getLayoutStr());
  }
  
  public View getAdSourceView(Context paramContext, View paramView)
  {
    if (!this.mHasAdSource) {
      localObject1 = null;
    }
    do
    {
      do
      {
        return localObject1;
        localObject1 = paramView;
      } while (paramView != null);
      paramView = new TextView(paramContext);
      localObject1 = paramView;
    } while (new nqy().a(paramContext, this.message, paramView, this.mAdSourceMenu));
    Object localObject1 = paramContext.getResources();
    paramView.setText(this.mAdSourceName);
    paramView.setSingleLine(true);
    paramView.setGravity(17);
    paramView.setEllipsize(TextUtils.TruncateAt.END);
    paramView.setTextColor(Color.rgb(187, 187, 187));
    paramView.setTextSize(2, 12.0F);
    paramView.setBackgroundResource(2130846196);
    if (!TextUtils.isEmpty(this.mSourceIcon)) {}
    Object localObject2 = paramContext.getResources().getDrawable(2130846199);
    ((Drawable)localObject2).setBounds(0, 0, 24, 16);
    paramView.setCompoundDrawables(null, null, (Drawable)localObject2, null);
    int i = vzl.a(paramContext, 6.0F);
    paramView.setPadding(i, 0, i, 0);
    paramView.setCompoundDrawablePadding(vzl.a(paramContext, 2.0F));
    localObject2 = LayoutInflater.from(paramContext).inflate(2131559394, null);
    PopupWindow localPopupWindow = new PopupWindow((View)localObject2, -1, -2, true);
    localPopupWindow.setTouchable(true);
    localPopupWindow.setOutsideTouchable(true);
    paramView.setOnClickListener(new axvi(this, paramContext, (Resources)localObject1, localPopupWindow));
    ((View)localObject2).findViewById(2131364999).setOnClickListener(new axvk(this, localPopupWindow, paramContext));
    ((View)localObject2).findViewById(2131366258).setOnClickListener(new axvl(this, paramContext, localPopupWindow));
    return paramView;
  }
  
  public String getLayoutStr()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if ((this.mMsgServiceID == 83) || (this.mMsgServiceID == 108) || (this.mMsgServiceID == 114) || (this.mMsgServiceID == 116) || (this.mMsgServiceID == 151) || (this.mMsgServiceID == 156)) {
      localStringBuffer.append("StructMsgItemLayoutNew2");
    }
    for (;;)
    {
      localStringBuffer.append(this.mFlag & 0x4);
      return localStringBuffer.toString();
      if (this.mStructMsgItemLists != null)
      {
        Iterator localIterator = this.mStructMsgItemLists.iterator();
        while (localIterator.hasNext()) {
          localStringBuffer.append(((axup)localIterator.next()).a());
        }
      }
    }
  }
  
  public View.OnClickListener getOnClickListener()
  {
    return jdField_a_of_type_AndroidViewView$OnClickListener;
  }
  
  public int getProgress()
  {
    axup localaxup = findXmlNode("progress");
    if ((localaxup != null) && ((localaxup instanceof axzh))) {
      return ((axzh)localaxup).b();
    }
    return -1;
  }
  
  public View getSourceView(Context paramContext, View paramView)
  {
    return super.getSourceView(paramContext, paramView);
  }
  
  @TargetApi(16)
  public View getView(Context paramContext, View paramView, acxj paramacxj, Bundle paramBundle)
  {
    if ((paramView != null) && ((paramView.getTag(2131376582) != null) || (paramView.getTag(2131373585) != null))) {}
    for (Object localObject1 = null;; localObject1 = paramView)
    {
      Object localObject2;
      Object localObject3;
      if (QLog.isColorLevel())
      {
        localObject2 = jdField_a_of_type_JavaLangString;
        localObject3 = new StringBuilder().append("getView convertView=").append(localObject1).append(",mMsg_A_ActionData=").append(this.mMsg_A_ActionData).append(",tag=");
        if (localObject1 == null) {
          break label292;
        }
      }
      int i;
      label292:
      for (paramView = ((View)localObject1).getTag(2131376835);; paramView = null)
      {
        QLog.d((String)localObject2, 2, paramView);
        this.mContext = new WeakReference(paramContext);
        localObject2 = paramBundle;
        if (paramBundle == null) {
          localObject2 = new Bundle();
        }
        ((Bundle)localObject2).putBoolean("hasHeadIcon", hasFlag(4));
        ((Bundle)localObject2).putInt("serviceID", this.mMsgServiceID);
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "getView(): convertView=" + localObject1 + ", args = " + ((Bundle)localObject2).toString());
        }
        i = ((Bundle)localObject2).getInt("longMsgHolderType", -1);
        if ((i != 1) && (i != 2) && (i != 3)) {
          break label304;
        }
        paramView = axyw.a(paramContext, (View)localObject1, paramacxj, (Bundle)localObject2);
        paramView.setId(2131376585);
        paramView.setTag(2131376585, this);
        if ((((Bundle)localObject2).getBoolean("isSubscript", false)) || (!hasFlag(4))) {
          break;
        }
        paramView.setBackgroundResource(2130838130);
        return paramView;
      }
      paramView.setBackgroundDrawable(null);
      return paramView;
      label304:
      if (((Bundle)localObject2).getInt("accostType") == AbsStructMsg.SOURCE_ACCOUNT_TYPE_PA) {}
      for (int j = 1; this.mMsgException; j = 0)
      {
        QLog.d(jdField_a_of_type_JavaLangString, 1, "struct msg has version exception! uin : " + this.uin + " msgVersion : " + this.messageVersion + " version : " + this.mVersion + " msgUniseq" + this.uniseq);
        paramContext = getVersionExceptionView(paramContext, (View)localObject1, paramacxj, (Bundle)localObject2);
        paramContext.setId(2131376585);
        paramContext.setTag(2131376585, this);
        return paramContext;
      }
      if (localObject1 == null)
      {
        paramView = super.getView(paramContext, null, paramacxj, (Bundle)localObject2);
        if (paramView == null) {
          return null;
        }
        paramBundle = null;
        if ((paramView instanceof ViewGroup)) {
          paramBundle = (ViewGroup)paramView;
        }
        if (paramBundle == null) {
          return null;
        }
        if (this.mStructMsgItemLists == null) {
          break label3333;
        }
      }
      label3333:
      for (int k = getItemCount();; k = 0)
      {
        int m;
        if (k > 0)
        {
          m = 0;
          i = 1;
          if (m < k)
          {
            localObject3 = getItemByIndex(m);
            ((axup)localObject3).jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramacxj);
            symbol2CharactorForSmallEmoji((axup)localObject3);
            if ((this.uin != null) && (!this.uin.equalsIgnoreCase(((axup)localObject3).R))) {
              ((axup)localObject3).R = this.uin;
            }
            if (((axup)localObject3).a() == 0)
            {
              if (m == 0) {
                ((axup)localObject3).a(1);
              }
              if (m == k - 1) {
                ((axup)localObject3).a(2);
              }
            }
            if ((localObject3 instanceof axym))
            {
              paramView = ((axup)localObject3).a(paramContext, null, (Bundle)localObject2);
              label615:
              if ((m + 2 < k) && (paramView != null))
              {
                localObject1 = getItemByIndex(m + 2);
                if ((((axuq)localObject1).a.size() != 0) && (paramView != null) && ((((localObject1 instanceof axyo)) && ((((axyo)localObject1).a.get(0) instanceof axyx))) || (((localObject1 instanceof axyc)) && ((((axyc)localObject1).a.get(0) instanceof axwm)))))
                {
                  localObject1 = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
                  if (localObject1 != null)
                  {
                    if (!(localObject3 instanceof axyo)) {
                      break label1773;
                    }
                    if (j == 0) {
                      break label1755;
                    }
                    ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin = actj.a(11.0F, paramContext.getResources());
                    label750:
                    paramView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
                  }
                }
              }
              if ((m + 1 < k) && (paramView != null) && (j != 0) && (((axuq)localObject3).a.size() == 1) && ((((axuq)localObject3).a.get(0) instanceof axwu)))
              {
                localObject1 = getItemByIndex(m + 1);
                if ((((axuq)localObject1).a.size() != 0) && ((localObject1 instanceof axyc)) && ((((axyc)localObject1).a.get(0) instanceof axwm)))
                {
                  paramView.setPadding(2, paramView.getPaddingTop(), 2, paramView.getPaddingBottom());
                  if ((paramView instanceof LinearLayout))
                  {
                    localObject1 = (LinearLayout.LayoutParams)((LinearLayout)paramView).getChildAt(0).getLayoutParams();
                    if (localObject1 != null)
                    {
                      ((LinearLayout.LayoutParams)localObject1).leftMargin = 0;
                      ((LinearLayout.LayoutParams)localObject1).rightMargin = 0;
                    }
                  }
                }
              }
              if (paramView == null) {
                break label1812;
              }
              if ((!TextUtils.isEmpty(((axup)localObject3).c)) || ((localObject3 instanceof axxw)))
              {
                paramView.setTag(localObject3);
                paramView.setClickable(true);
                paramView.setOnClickListener((View.OnClickListener)localObject3);
                paramView.setOnLongClickListener(new axvd(this, paramacxj));
                paramView.setOnTouchListener(new axve(this, paramacxj));
                clickedItemIndex = 0;
              }
              if (paramView.getParent() != null)
              {
                ((ViewGroup)paramView.getParent()).removeView(paramView);
                if (QLog.isColorLevel()) {
                  QLog.e(jdField_a_of_type_JavaLangString, 2, "getView itemView.getParent != null .itemName = ." + localObject3.getClass().getName());
                }
              }
              paramBundle.addView(paramView);
            }
            for (;;)
            {
              m += 1;
              break;
              if ((localObject3 instanceof axyn))
              {
                paramView = ((axup)localObject3).a(paramContext, null, (Bundle)localObject2);
                break label615;
              }
              if ((localObject3 instanceof axxb))
              {
                paramView = ((axup)localObject3).a(paramContext, null, (Bundle)localObject2);
                i = 0;
                break label615;
              }
              if ((localObject3 instanceof axyg))
              {
                if (m + 1 < k) {
                  ((axyg)localObject3).a = true;
                }
                for (this.isMultiVideoItem = true;; this.isMultiVideoItem = false)
                {
                  if (j == 0) {
                    break label1178;
                  }
                  paramView = new axyh((axuq)localObject3, paramContext, m).a(paramContext, null, (Bundle)localObject2);
                  break;
                  ((axyg)localObject3).a = false;
                }
                label1178:
                paramView = ((axup)localObject3).a(paramContext, null, (Bundle)localObject2);
                break label615;
              }
              if ((localObject3 instanceof axyi))
              {
                if (j != 0)
                {
                  paramView = new axyj((axuq)localObject3, paramContext, m).a(paramContext, null, (Bundle)localObject2);
                  break label615;
                }
                paramView = ((axup)localObject3).a(paramContext, null, (Bundle)localObject2);
                break label615;
              }
              if ((localObject3 instanceof axyf))
              {
                localObject1 = ((axup)localObject3).a(paramContext, null, (Bundle)localObject2);
                paramView = (View)localObject1;
                if (j == 0) {
                  break label3324;
                }
                a(paramContext, m, (View)localObject1);
                paramView = (View)localObject1;
                break label615;
              }
              if ((localObject3 instanceof axxf))
              {
                paramView = ((axup)localObject3).a(paramContext, null, (Bundle)localObject2);
                i = 0;
                break label615;
              }
              if ((localObject3 instanceof axxh))
              {
                paramView = ((axup)localObject3).a(paramContext, null, (Bundle)localObject2);
                i = 0;
                break label615;
              }
              if ((localObject3 instanceof axxi))
              {
                if ((this.mMsgServiceID == 83) || (this.mMsgServiceID == 108) || (this.mMsgServiceID == 114) || (this.mMsgServiceID == 116) || (this.mMsgServiceID == 151) || (this.mMsgServiceID == 156))
                {
                  paramView = new axys();
                  paramView.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg = this;
                  paramView.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramacxj);
                  paramView = paramView.a(paramContext, null, (Bundle)localObject2);
                  i = 0;
                  break label615;
                }
                if ((this.mDatas == null) || ((this.message != null) && (!TextUtils.isEmpty(this.message.senderuin)))) {}
                for (;;)
                {
                  try
                  {
                    this.mDatas.put("senderuin", this.message.senderuin);
                    localObject1 = this.mDatas;
                    if (!this.message.isSend()) {
                      continue;
                    }
                    paramView = this.message.frienduin;
                    ((JSONObject)localObject1).put("invitedUin", paramView);
                  }
                  catch (JSONException paramView)
                  {
                    continue;
                    continue;
                    i = 1;
                    continue;
                  }
                  ((Bundle)localObject2).putString("extend-data-json", this.mDatas.toString());
                  localObject1 = ((axup)localObject3).a(paramContext, null, (Bundle)localObject2);
                  paramView = (View)localObject1;
                  if (localObject1 == null) {
                    break label3324;
                  }
                  ((View)localObject1).setTag(jdField_a_of_type_Int, localObject3);
                  paramView = (View)localObject1;
                  break;
                  paramView = this.message.selfuin;
                }
              }
              if ((localObject3 instanceof axxj))
              {
                paramView = ((axup)localObject3).a(paramContext, null, (Bundle)localObject2);
                break label615;
              }
              if ((localObject3 instanceof axxu))
              {
                ((Bundle)localObject2).putString("extraData", this.mExtraData);
                paramView = ((axup)localObject3).a(paramContext, null, (Bundle)localObject2);
                i = 0;
                break label615;
              }
              if ((localObject3 instanceof axxv))
              {
                paramView = ((axup)localObject3).a(paramContext, null, (Bundle)localObject2);
                i = 0;
                break label615;
              }
              if ((localObject3 instanceof axxw))
              {
                paramView = ((axup)localObject3).a(paramContext, null, (Bundle)localObject2);
                i = 0;
                break label615;
              }
              if ((localObject3 instanceof axxz))
              {
                ((axup)localObject3).jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg = this;
                paramView = ((axup)localObject3).a(paramContext, null, (Bundle)localObject2);
                i = 0;
                break label615;
              }
              if ((localObject3 instanceof axyp))
              {
                ((axup)localObject3).jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg = this;
                paramView = ((axup)localObject3).a(paramContext, null, (Bundle)localObject2);
                i = 0;
                break label615;
              }
              paramView = ((axup)localObject3).a(paramContext, null, (Bundle)localObject2);
              break label615;
              label1755:
              ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin = actj.a(16.0F, paramContext.getResources());
              break label750;
              label1773:
              if ((!(localObject3 instanceof axyi)) || (axyj.a((axuq)localObject3, m))) {
                break label750;
              }
              ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin = actj.a(7.5F, paramContext.getResources());
              break label750;
              label1812:
              if (QLog.isDevelopLevel()) {
                QLog.e(jdField_a_of_type_JavaLangString, 4, "Create item view failure by #StructMsgItemViewFactory");
              }
            }
          }
        }
        for (;;)
        {
          if (((j != 0) && (hasFlag(4))) || (this.mMsgServiceID == 91))
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.subscript", 2, "StructMsgForGeneralShare use subscript structmsg bg");
            }
            paramBundle.setBackgroundResource(2130838136);
          }
          a(paramBundle, paramContext.getResources(), (Bundle)localObject2);
          for (paramContext = paramBundle;; paramContext = (Context)localObject1)
          {
            if ((localObject2 != null) && (((Bundle)localObject2).getBoolean("v_crap_ctn", false))) {
              paramContext.getLayoutParams().width = -2;
            }
            if ((localObject2 != null) && (((Bundle)localObject2).getBoolean("is_public_account_video_msg", false)))
            {
              this.mIsPAVideoStructMsg = true;
              if (!this.isMultiVideoItem) {
                paramContext.setBackgroundDrawable(null);
              }
              if (!hasFlag(4)) {
                paramContext.getLayoutParams().width = -2;
              }
            }
            paramContext.setId(2131376585);
            paramContext.setTag(2131376585, this);
            paramView = paramContext;
            if (i != 0) {
              break;
            }
            paramContext.setBackgroundDrawable(null);
            return paramContext;
            m = getItemCount();
            if (m <= 0) {
              break label3318;
            }
            localObject3 = (ViewGroup)localObject1;
            k = 0;
            i = 1;
            if (k < m)
            {
              axup localaxup = getItemByIndex(k);
              localaxup.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramacxj);
              if ((this.uin != null) && (!this.uin.equalsIgnoreCase(localaxup.R))) {
                localaxup.R = this.uin;
              }
              if (localaxup.a() == 0)
              {
                if (k == 0) {
                  localaxup.a(1);
                }
                if (k == m - 1) {
                  localaxup.a(2);
                }
              }
              paramBundle = ((ViewGroup)localObject3).getChildAt(k);
              if ((localaxup instanceof axym))
              {
                paramView = localaxup.a(paramContext, paramBundle, (Bundle)localObject2);
                label2143:
                if (k + 2 < m)
                {
                  paramBundle = getItemByIndex(k + 2);
                  if ((((axuq)paramBundle).a.size() != 0) && (paramView != null) && ((((paramBundle instanceof axyo)) && ((((axyo)paramBundle).a.get(0) instanceof axyx))) || (((paramBundle instanceof axyc)) && ((((axyc)paramBundle).a.get(0) instanceof axwm)))))
                  {
                    paramBundle = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
                    if (paramBundle != null)
                    {
                      if (!(localaxup instanceof axyo)) {
                        break label3194;
                      }
                      if (j == 0) {
                        break label3176;
                      }
                      paramBundle.bottomMargin = actj.a(11.0F, paramContext.getResources());
                      label2274:
                      paramView.setLayoutParams(paramBundle);
                    }
                  }
                }
                if ((k + 1 < m) && (paramView != null) && (((axuq)localaxup).a.size() == 1) && ((((axuq)localaxup).a.get(0) instanceof axwu)))
                {
                  paramBundle = getItemByIndex(k + 1);
                  if ((((axuq)paramBundle).a.size() != 0) && ((paramBundle instanceof axyc)) && ((((axyc)paramBundle).a.get(0) instanceof axwm))) {
                    paramView.setPadding(2, paramView.getPaddingTop(), 2, paramView.getPaddingBottom());
                  }
                }
                if (paramView == null) {
                  break label3233;
                }
                if ((!TextUtils.isEmpty(localaxup.c)) || ((localaxup instanceof axxw)))
                {
                  paramView.setTag(localaxup);
                  paramView.setClickable(true);
                  paramView.setOnClickListener(localaxup);
                  paramView.setOnLongClickListener(new axvf(this, paramacxj));
                  paramView.setOnTouchListener(new axvg(this, paramacxj));
                  clickedItemIndex = 0;
                }
              }
              for (;;)
              {
                k += 1;
                break;
                if ((localaxup instanceof axyn))
                {
                  paramView = localaxup.a(paramContext, paramBundle, (Bundle)localObject2);
                  break label2143;
                }
                if ((localaxup instanceof axxb))
                {
                  paramView = localaxup.a(paramContext, paramBundle, (Bundle)localObject2);
                  i = 0;
                  break label2143;
                }
                if ((localaxup instanceof axyg))
                {
                  if (k + 1 < m) {
                    ((axyg)localaxup).a = true;
                  }
                  for (this.isMultiVideoItem = true;; this.isMultiVideoItem = false)
                  {
                    if (j == 0) {
                      break label2596;
                    }
                    paramView = new axyh((axuq)localaxup, paramContext, k).a(paramContext, paramBundle, (Bundle)localObject2);
                    break;
                    ((axyg)localaxup).a = false;
                  }
                  label2596:
                  paramView = localaxup.a(paramContext, paramBundle, (Bundle)localObject2);
                  break label2143;
                }
                if ((localaxup instanceof axyi))
                {
                  if (j != 0)
                  {
                    paramView = new axyj((axuq)localaxup, paramContext, k).a(paramContext, paramBundle, (Bundle)localObject2);
                    break label2143;
                  }
                  paramView = localaxup.a(paramContext, paramBundle, (Bundle)localObject2);
                  break label2143;
                }
                if ((localaxup instanceof axyf))
                {
                  paramBundle = localaxup.a(paramContext, paramBundle, (Bundle)localObject2);
                  paramView = paramBundle;
                  if (j == 0) {
                    break label3315;
                  }
                  a(paramContext, k, paramBundle);
                  paramView = paramBundle;
                  break label2143;
                }
                if ((localaxup instanceof axxf))
                {
                  paramView = localaxup.a(paramContext, paramBundle, (Bundle)localObject2);
                  i = 0;
                  break label2143;
                }
                if ((localaxup instanceof axxh))
                {
                  paramView = localaxup.a(paramContext, paramBundle, (Bundle)localObject2);
                  i = 0;
                  break label2143;
                }
                if ((localaxup instanceof axxi))
                {
                  if ((this.mMsgServiceID == 83) || (this.mMsgServiceID == 108) || (this.mMsgServiceID == 114) || (this.mMsgServiceID == 116) || (this.mMsgServiceID == 151) || (this.mMsgServiceID == 156))
                  {
                    paramView = new axys();
                    paramView.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg = this;
                    paramView.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramacxj);
                    paramView = paramView.a(paramContext, paramBundle, (Bundle)localObject2);
                    i = 0;
                    break label2143;
                  }
                  if ((this.mDatas == null) || ((this.message != null) && (!TextUtils.isEmpty(this.message.senderuin)))) {}
                  for (;;)
                  {
                    try
                    {
                      this.mDatas.put("senderuin", this.message.senderuin);
                      JSONObject localJSONObject = this.mDatas;
                      if (!this.message.isSend()) {
                        continue;
                      }
                      paramView = this.message.frienduin;
                      localJSONObject.put("invitedUin", paramView);
                    }
                    catch (JSONException paramView)
                    {
                      continue;
                    }
                    ((Bundle)localObject2).putString("extend-data-json", this.mDatas.toString());
                    paramBundle = localaxup.a(paramContext, paramBundle, (Bundle)localObject2);
                    paramView = paramBundle;
                    if (paramBundle == null) {
                      break label3315;
                    }
                    paramBundle.setTag(jdField_a_of_type_Int, localaxup);
                    paramView = paramBundle;
                    break;
                    paramView = this.message.selfuin;
                  }
                }
                if ((localaxup instanceof axxj))
                {
                  paramView = localaxup.a(paramContext, paramBundle, (Bundle)localObject2);
                  break label2143;
                }
                if ((localaxup instanceof axxu))
                {
                  paramView = localaxup.a(paramContext, paramBundle, (Bundle)localObject2);
                  i = 0;
                  break label2143;
                }
                if ((localaxup instanceof axxv))
                {
                  paramView = localaxup.a(paramContext, paramBundle, (Bundle)localObject2);
                  i = 0;
                  break label2143;
                }
                if ((localaxup instanceof axxw))
                {
                  paramView = localaxup.a(paramContext, paramBundle, (Bundle)localObject2);
                  i = 0;
                  break label2143;
                }
                if ((localaxup instanceof axxz))
                {
                  localaxup.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg = this;
                  paramView = localaxup.a(paramContext, paramBundle, (Bundle)localObject2);
                  i = 0;
                  break label2143;
                }
                if ((localaxup instanceof axyp))
                {
                  localaxup.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg = this;
                  paramView = localaxup.a(paramContext, paramBundle, (Bundle)localObject2);
                  i = 0;
                  break label2143;
                }
                paramView = localaxup.a(paramContext, paramBundle, (Bundle)localObject2);
                break label2143;
                label3176:
                paramBundle.bottomMargin = actj.a(16.0F, paramContext.getResources());
                break label2274;
                label3194:
                if ((!(localaxup instanceof axyi)) || (axyj.a((axuq)localaxup, k))) {
                  break label2274;
                }
                paramBundle.bottomMargin = actj.a(7.5F, paramContext.getResources());
                break label2274;
                label3233:
                if (QLog.isDevelopLevel()) {
                  QLog.e(jdField_a_of_type_JavaLangString, 4, "Create item view failure by #StructMsgItemViewFactory");
                }
              }
            }
            if ((j != 0) && (hasFlag(4)))
            {
              if (QLog.isColorLevel()) {
                QLog.d("Q.subscript", 2, "StructMsgForGeneralShare use subscript structmsg bg");
              }
              ((View)localObject1).setBackgroundResource(2130838136);
            }
            a((View)localObject1, paramContext.getResources(), (Bundle)localObject2);
          }
          label3315:
          label3318:
          label3324:
          break label615;
          i = 1;
        }
      }
    }
  }
  
  public void initPay(Context paramContext, MessageRecord paramMessageRecord)
  {
    this.havaPayInfoInit = true;
    if ((paramContext == null) || (this.mStructMsgItemLists == null)) {
      label16:
      return;
    } else {
      paramContext = this.mStructMsgItemLists.iterator();
    }
    for (;;)
    {
      if (!paramContext.hasNext()) {
        break label16;
      }
      Object localObject1 = (axup)paramContext.next();
      if (!(localObject1 instanceof axyc)) {
        break;
      }
      localObject1 = (axyc)localObject1;
      if (((axyc)localObject1).a == null) {
        break;
      }
      localObject1 = ((axyc)localObject1).a.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (axup)((Iterator)localObject1).next();
        if ((localObject2 instanceof axwm))
        {
          localObject2 = (axwm)localObject2;
          if (((axwm)localObject2).b()) {
            ((axwm)localObject2).a(paramMessageRecord.getExtInfoFromExtStr("order_pay_state_" + ((axwm)localObject2).aj), paramMessageRecord, this);
          }
        }
      }
    }
  }
  
  public boolean isPayMessage()
  {
    if (this.mStructMsgItemLists != null)
    {
      axup localaxup;
      do
      {
        Iterator localIterator = this.mStructMsgItemLists.iterator();
        Object localObject;
        while (!((Iterator)localObject).hasNext())
        {
          do
          {
            if (!localIterator.hasNext()) {
              break;
            }
            localObject = (axup)localIterator.next();
          } while (!(localObject instanceof axyc));
          localObject = ((axyc)localObject).a.iterator();
        }
        localaxup = (axup)((Iterator)localObject).next();
      } while ((!(localaxup instanceof axwm)) || (!((axwm)localaxup).b()));
      return true;
    }
    return false;
  }
  
  protected boolean parseContentNode(axwg paramaxwg)
  {
    if (paramaxwg == null) {
      return true;
    }
    Object localObject;
    if ("item".equals(paramaxwg.jdField_b_of_type_JavaLangString)) {
      localObject = paramaxwg.a("layout");
    }
    for (;;)
    {
      try
      {
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          i = Integer.parseInt((String)localObject);
        }
      }
      catch (NumberFormatException paramaxwg)
      {
        int k;
        int j;
        i = 0;
      }
      try
      {
        k = this.mMsgServiceID;
        j = i;
        if (k == 91)
        {
          j = i;
          if (i == 21) {
            j = 25;
          }
        }
        localObject = axuz.a(j);
        if (localObject != null) {
          break;
        }
        return true;
      }
      catch (NumberFormatException paramaxwg)
      {
        break label89;
      }
      int i = 0;
      continue;
      label89:
      if (QLog.isDevelopLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 4, "Item layout value is " + i);
      }
      return false;
      localObject = axuz.a(paramaxwg.jdField_b_of_type_JavaLangString);
    }
    ((axup)localObject).jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg = this;
    if (((axup)localObject).a(paramaxwg))
    {
      addItem((axup)localObject);
      return true;
    }
    return false;
  }
  
  protected void parseMsgAttrubutes(axwg paramaxwg)
  {
    super.parseMsgAttrubutes(paramaxwg);
  }
  
  public void readExternal(ObjectInput paramObjectInput)
  {
    label401:
    int j;
    try
    {
      n = paramObjectInput.readInt();
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "version: " + n);
      }
      this.mVersion = n;
      if (n != 1) {
        break label401;
      }
      this.mMsgTemplateID = paramObjectInput.readInt();
      this.mMsgAction = paramObjectInput.readUTF();
      this.mMsgActionData = paramObjectInput.readUTF();
      this.mMsg_A_ActionData = paramObjectInput.readUTF();
      this.mMsg_I_ActionData = paramObjectInput.readUTF();
      this.mMsgUrl = paramObjectInput.readUTF();
      this.mMsgBrief = paramObjectInput.readUTF();
      this.mContentLayout = paramObjectInput.readInt();
      this.mContentCover = paramObjectInput.readUTF();
      this.mContentTitle = paramObjectInput.readUTF();
      this.mContentSummary = paramObjectInput.readUTF();
      localObject1 = axuz.a(this.mContentLayout);
      ((axuq)localObject1).a(new axws(this.mContentCover));
      ((axuq)localObject1).a(new StructMsgItemTitle(this.mContentTitle));
      ((axuq)localObject1).a(new axzj(this.mContentSummary));
      addItem((axup)localObject1);
      this.mSourceAppid = paramObjectInput.readLong();
      this.mSourceIcon = paramObjectInput.readUTF();
      this.mSourceName = paramObjectInput.readUTF();
      this.mSourceUrl = paramObjectInput.readUTF();
      this.mSourceAction = paramObjectInput.readUTF();
      this.mSourceActionData = paramObjectInput.readUTF();
      this.mSource_A_ActionData = paramObjectInput.readUTF();
      this.mSource_I_ActionData = paramObjectInput.readUTF();
      this.fwFlag = paramObjectInput.readInt();
    }
    catch (IOException paramObjectInput)
    {
      int n;
      Object localObject1;
      int i1;
      int i;
      while ((paramObjectInput.getMessage() != null) && (paramObjectInput.getMessage().equals("structmsg_version_error")))
      {
        this.mMsgException = true;
        return;
        this.mSourceAppid = paramObjectInput.readLong();
        this.mSourceIcon = paramObjectInput.readUTF();
        this.mSourceName = paramObjectInput.readUTF();
        this.mSourceUrl = paramObjectInput.readUTF();
        this.mSourceAction = paramObjectInput.readUTF();
        this.mSourceActionData = paramObjectInput.readUTF();
        this.mSource_A_ActionData = paramObjectInput.readUTF();
        this.mSource_I_ActionData = paramObjectInput.readUTF();
        this.fwFlag = paramObjectInput.readInt();
        this.mFlag = paramObjectInput.readInt();
        this.mResid = paramObjectInput.readUTF();
        this.mFileName = paramObjectInput.readUTF();
        this.mFileSize = paramObjectInput.readLong();
        this.mCommentText = paramObjectInput.readUTF();
        if (n >= 3)
        {
          this.mCompatibleText = paramObjectInput.readUTF();
          this.msgId = paramObjectInput.readLong();
          this.mPromotionType = paramObjectInput.readInt();
          this.mPromotionMsg = paramObjectInput.readUTF();
          this.mPromotionMenus = paramObjectInput.readUTF();
          this.mPromotionMenuDestructiveIndex = paramObjectInput.readInt();
          i = 0;
          while (i < this.mStructMsgItemLists.size())
          {
            localObject1 = (axup)this.mStructMsgItemLists.get(i);
            ((axup)localObject1).jdField_a_of_type_Long = this.msgId;
            ((axup)localObject1).j = this.mPromotionType;
            i += 1;
          }
          if (n >= 4)
          {
            this.dynamicMsgMergeKey = paramObjectInput.readUTF();
            this.dynamicMsgMergeIndex = paramObjectInput.readInt();
            if (n >= 5)
            {
              this.source_puin = paramObjectInput.readUTF();
              if (n >= 6)
              {
                this.mSType = paramObjectInput.readUTF();
                if (n >= 7)
                {
                  this.adverSign = paramObjectInput.readInt();
                  this.adverKey = paramObjectInput.readUTF();
                  this.index = paramObjectInput.readUTF();
                  this.index_name = paramObjectInput.readUTF();
                  this.index_type = paramObjectInput.readUTF();
                  this.rijAlbumActionData = paramObjectInput.readUTF();
                  if (n >= 8)
                  {
                    this.mArticleIds = paramObjectInput.readUTF();
                    this.mOrangeWord = paramObjectInput.readUTF();
                    this.mAlgorithmIds = paramObjectInput.readUTF();
                    this.mStrategyIds = paramObjectInput.readUTF();
                    if (n >= 9)
                    {
                      this.mExtraData = paramObjectInput.readUTF();
                      this.mCreateTime = paramObjectInput.readUTF();
                      this.mTagName = paramObjectInput.readUTF();
                      if (n >= 10)
                      {
                        eventId = paramObjectInput.readUTF();
                        remindBrief = paramObjectInput.readUTF();
                        eventType = paramObjectInput.readUTF();
                        if (n >= 11)
                        {
                          tips = paramObjectInput.readUTF();
                          if (n >= 12)
                          {
                            this.mInnerUniqIds = paramObjectInput.readUTF();
                            if (n >= 13)
                            {
                              this.mSourceThirdName = paramObjectInput.readUTF();
                              this.mQQStoryExtra = paramObjectInput.readUTF();
                              this.mNeedRound = paramObjectInput.readUTF();
                              if (n >= 14)
                              {
                                this.mQidianBulkTaskId = paramObjectInput.readUTF();
                                this.reportEventFolderStatusValue = paramObjectInput.readUTF();
                                if (n >= 15)
                                {
                                  this.forwardType = paramObjectInput.readInt();
                                  this.shareData.readExternal(paramObjectInput);
                                  if ((n >= 16) && (n >= 17))
                                  {
                                    this.mAdSourceName = paramObjectInput.readUTF();
                                    this.mCommonData = paramObjectInput.readUTF();
                                    if (n >= 18)
                                    {
                                      this.animResId = paramObjectInput.readUTF();
                                      this.atMembers = paramObjectInput.readUTF();
                                      if (n >= 19)
                                      {
                                        this.mMergeSeq = paramObjectInput.readUTF();
                                        this.mSortKey = paramObjectInput.readLong();
                                        if (n >= 21)
                                        {
                                          this.mTribeShortVideoExtra = paramObjectInput.readUTF();
                                          if (n >= 22)
                                          {
                                            this.needSendLongMsgWhenFailed = paramObjectInput.readBoolean();
                                            if (n >= 23)
                                            {
                                              this.mTSum = paramObjectInput.readInt();
                                              if (n >= 24)
                                              {
                                                localObject1 = paramObjectInput.readUTF();
                                                bool = TextUtils.isEmpty((CharSequence)localObject1);
                                                if (!bool) {}
                                                for (;;)
                                                {
                                                  try
                                                  {
                                                    this.mDatas = new JSONObject((String)localObject1);
                                                    if (n < 25) {
                                                      break;
                                                    }
                                                    this.mAdSourceMenu = paramObjectInput.readUTF();
                                                    if (n < 27) {
                                                      break;
                                                    }
                                                    this.pobingTemplateId = paramObjectInput.readInt();
                                                  }
                                                  catch (JSONException localJSONException)
                                                  {
                                                    this.mDatas = null;
                                                    continue;
                                                  }
                                                  this.mDatas = null;
                                                }
                                                this.mMsgException = true;
                                                continue;
                                                if (!this.mSourceName.equalsIgnoreCase(ajya.a(2131693701))) {
                                                  break;
                                                }
                                                this.mMsgServiceID = 53;
                                                return;
                                              }
                                            }
                                          }
                                        }
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    if ((!this.mHasSource) && ((!TextUtils.isEmpty(this.mSourceName)) || (!TextUtils.isEmpty(this.mSourceIcon)))) {
      this.mHasSource = true;
    }
    if ((!this.mHasAdSource) && (!TextUtils.isEmpty(this.mAdSourceName))) {
      this.mHasAdSource = true;
    }
    if (this.mSourceName != null) {
      if (this.mSourceName.equalsIgnoreCase(ajya.a(2131714609)))
      {
        this.mMsgServiceID = 54;
        return;
        if (n >= 2)
        {
          this.mMsgTemplateID = paramObjectInput.readInt();
          this.mMsgAction = paramObjectInput.readUTF();
          this.mMsgActionData = paramObjectInput.readUTF();
          this.mMsg_A_ActionData = paramObjectInput.readUTF();
          this.mMsg_I_ActionData = paramObjectInput.readUTF();
          this.mMsgUrl = paramObjectInput.readUTF();
          this.mMsgBrief = paramObjectInput.readUTF();
          i1 = paramObjectInput.readInt();
          j = 0;
          i = 1;
        }
      }
    }
    for (;;)
    {
      int m;
      if (j < i1)
      {
        localObject1 = paramObjectInput.readUTF();
        if ("item".equals(localObject1))
        {
          m = paramObjectInput.readInt();
          if ((m == 2) && ("micro_app".equals(this.mMsg_A_ActionData)))
          {
            localObject1 = new axyp();
            break label1659;
          }
        }
      }
      label1659:
      for (;;)
      {
        if (localObject1 != null)
        {
          ((axup)localObject1).R = this.uin;
          ((axup)localObject1).jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg = this;
          ((axup)localObject1).a(paramObjectInput);
          Object localObject2 = (axuq)localObject1;
          if ((((axuq)localObject2).a.size() != 1) || (!((axup)((axuq)localObject2).a.get(0)).jdField_a_of_type_JavaLangString.equals("hr")))
          {
            ((axup)localObject1).Q = String.valueOf(i);
            i += 1;
            addItem((axup)localObject1);
            ((axup)localObject1).a(this);
            break;
            int k = m;
            if (m == 1)
            {
              k = m;
              if ("viewMultiMsg".equalsIgnoreCase(this.mMsgAction)) {
                k = 30;
              }
            }
            localObject1 = axuz.a(k);
            break label1659;
            localObject2 = axuz.a((String)localObject1);
            localObject1 = localObject2;
            if (localObject2 == null) {
              continue;
            }
            localObject1 = localObject2;
            if (!axuq.class.isInstance(localObject2)) {
              continue;
            }
            paramObjectInput.readInt();
            localObject1 = localObject2;
            continue;
          }
        }
        boolean bool;
        return;
      }
      j += 1;
    }
  }
  
  public void report(Object paramObject)
  {
    axqy.b(null, "dc00898", "", "", "0X800A62F", "0X800A62F", 0, 0, "1", ForwardUtils.b(this.uinType), this.mContentTitle, "");
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, new Object[] { "图文曝光=0X800A62F, type=", "1", ", title=", this.mContentTitle, ", uinType=", ForwardUtils.b(this.uinType) });
    }
  }
  
  public void savePayInfo(Context paramContext, String paramString, int paramInt)
  {
    try
    {
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      if ((this.message != null) && (localAppRuntime != null))
      {
        if (TextUtils.isEmpty(paramString)) {
          return;
        }
        this.message.saveExtInfoToExtStr("order_pay_state_" + paramString, "" + paramInt);
        if ((paramContext instanceof FragmentActivity)) {
          ((FragmentActivity)paramContext).getChatFragment().a().jdField_a_of_type_Acup.notifyDataSetChanged();
        }
        ThreadManager.post(new StructMsgForGeneralShare.6(this, localAppRuntime), 5, null, false);
        return;
      }
    }
    catch (Exception paramContext)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 4, "savePayInfo error " + paramContext.getMessage());
      }
    }
  }
  
  @Deprecated
  public void setProgress(int paramInt)
  {
    axup localaxup = findXmlNode("progress");
    if ((localaxup != null) && ((localaxup instanceof axzh))) {
      ((axzh)localaxup).b(paramInt);
    }
  }
  
  @Deprecated
  public void setSummary(String paramString)
  {
    axup localaxup = findXmlNode("summary");
    if ((localaxup != null) && ((localaxup instanceof axzj))) {
      ((axzj)localaxup).a(paramString);
    }
  }
  
  @Deprecated
  public void setTitle(String paramString)
  {
    axup localaxup = findXmlNode("title");
    if ((localaxup != null) && ((localaxup instanceof StructMsgItemTitle))) {
      ((StructMsgItemTitle)localaxup).a(paramString);
    }
  }
  
  public void symbol2CharactorForSmallEmoji(axup paramaxup)
  {
    if ((paramaxup == null) || (!(paramaxup instanceof axxi))) {}
    label39:
    label183:
    label464:
    label470:
    label474:
    label476:
    label477:
    for (;;)
    {
      return;
      paramaxup = ((axxi)paramaxup).a;
      if ((paramaxup != null) && (paramaxup.size() != 0))
      {
        Object localObject1 = paramaxup.iterator();
        paramaxup = null;
        Object localObject2;
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = (axup)((Iterator)localObject1).next();
          if (!(localObject2 instanceof axzj)) {
            break label476;
          }
          paramaxup = (axzj)localObject2;
        }
        for (;;)
        {
          break label39;
          if (paramaxup == null) {
            break label477;
          }
          localObject2 = paramaxup.b();
          if ((TextUtils.isEmpty((CharSequence)localObject2)) || (this.mContext == null) || (this.mContext.get() == null) || (!(this.mContext.get() instanceof BaseActivity))) {
            break;
          }
          localObject1 = ((FragmentActivity)this.mContext.get()).getChatFragment();
          if (localObject1 != null) {
            localObject1 = ((ChatFragment)localObject1).a();
          }
          for (;;)
          {
            if (localObject1 == null) {
              break label474;
            }
            askf localaskf = (askf)((QQAppInterface)localObject1).getManager(14);
            StringBuilder localStringBuilder = new StringBuilder((String)localObject2);
            int i = 0;
            int j;
            if (i < localStringBuilder.length())
            {
              j = i;
              if ('ÿ' == localStringBuilder.charAt(i))
              {
                j = i;
                if (i + 3 < localStringBuilder.length())
                {
                  localObject1 = new char[4];
                  localObject1[0] = localStringBuilder.charAt(i + 3);
                  localObject1[1] = localStringBuilder.charAt(i + 2);
                  localObject1[2] = localStringBuilder.charAt(i + 1);
                  localObject1[3] = localStringBuilder.charAt(i);
                  j = 0;
                  if (j < 4)
                  {
                    if (localObject1[j] == 'ú') {
                      localObject1[j] = 10;
                    }
                    for (;;)
                    {
                      j += 1;
                      break label272;
                      localObject1 = BaseApplicationImpl.getApplication().getRuntime();
                      if ((localObject1 == null) || (!(localObject1 instanceof QQAppInterface))) {
                        break label470;
                      }
                      localObject1 = (QQAppInterface)localObject1;
                      break;
                      if (localObject1[j] == 'þ') {
                        localObject1[j] = 13;
                      } else if (localObject1[j] == 'ý') {
                        localObject1[j] = 20;
                      }
                    }
                  }
                  localObject1 = anqz.a((char[])localObject1);
                  localObject2 = aykk.c;
                  if (localaskf == null) {
                    break label464;
                  }
                }
              }
            }
            for (localObject1 = localaskf.a(Integer.toString(localObject1[0]), Integer.toString(localObject1[1]));; localObject1 = null)
            {
              if (localObject1 != null) {
                localObject2 = ((Emoticon)localObject1).character;
              }
              localStringBuilder.replace(i, i + 3, (String)localObject2);
              j = i + ((String)localObject2).length();
              i = j + 1;
              break label183;
              if (TextUtils.isEmpty(localStringBuilder)) {
                break;
              }
              paramaxup.a(localStringBuilder.toString());
              return;
            }
            localObject1 = null;
          }
          break;
        }
      }
    }
  }
  
  protected void toContentXml(axuo paramaxuo)
  {
    Iterator localIterator = iterator();
    while (localIterator.hasNext()) {
      ((axup)localIterator.next()).a(paramaxuo);
    }
    if ((this.mMsgServiceID == 128) && (this.mDatas != null))
    {
      paramaxuo.startTag(null, "data");
      paramaxuo.attribute(null, "groupcode", this.mDatas.optString("groupcode"));
      paramaxuo.attribute(null, "groupname", this.mDatas.optString("groupname"));
      paramaxuo.attribute(null, "msgseq", this.mDatas.optString("msgseq"));
      paramaxuo.attribute(null, "msgtype", this.mDatas.optString("msgtype"));
      paramaxuo.endTag(null, "data");
    }
  }
  
  public void unInitPay()
  {
    this.havaPayInfoInit = false;
    this.mHadPaidList = new ArrayList();
  }
  
  public void updateCover(String paramString)
  {
    super.updateCover(paramString);
    Iterator localIterator = this.mStructMsgItemLists.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (axup)localIterator.next();
      if ((localObject instanceof axuq))
      {
        localObject = ((axuq)localObject).a.iterator();
        while (((Iterator)localObject).hasNext())
        {
          axup localaxup = (axup)((Iterator)localObject).next();
          if ((localaxup instanceof axws)) {
            ((axws)localaxup).S = paramString;
          }
        }
      }
    }
  }
  
  public void updateTitleSummaryAndCover(String paramString1, String paramString2, String paramString3)
  {
    super.updateTitleSummaryAndCover(paramString1, paramString2, paramString3);
    Iterator localIterator = this.mStructMsgItemLists.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (axup)localIterator.next();
      if ((localObject instanceof axuq))
      {
        localObject = ((axuq)localObject).a.iterator();
        while (((Iterator)localObject).hasNext())
        {
          axup localaxup = (axup)((Iterator)localObject).next();
          if ((localaxup instanceof StructMsgItemTitle)) {
            ((StructMsgItemTitle)localaxup).Y = paramString1;
          } else if ((localaxup instanceof axzj)) {
            ((axzj)localaxup).Y = paramString2;
          } else if ((localaxup instanceof axws)) {
            ((axws)localaxup).S = paramString3;
          }
        }
      }
    }
  }
  
  public void writeExternal(ObjectOutput paramObjectOutput)
  {
    paramObjectOutput.writeInt(this.mMsgServiceID);
    paramObjectOutput.writeInt(this.mVersion);
    paramObjectOutput.writeInt(this.mMsgTemplateID);
    if (this.mMsgAction == null)
    {
      localObject = "";
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mMsgActionData != null) {
        break label180;
      }
      localObject = "";
      label57:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mMsg_A_ActionData != null) {
        break label188;
      }
      localObject = "";
      label74:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mMsg_I_ActionData != null) {
        break label196;
      }
      localObject = "";
      label91:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mMsgUrl != null) {
        break label204;
      }
      localObject = "";
      label108:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mMsgBrief != null) {
        break label212;
      }
    }
    label180:
    label188:
    label196:
    label204:
    label212:
    for (Object localObject = "";; localObject = this.mMsgBrief)
    {
      paramObjectOutput.writeUTF((String)localObject);
      paramObjectOutput.writeInt(getItemCount());
      localObject = iterator();
      while (((Iterator)localObject).hasNext()) {
        ((axup)((Iterator)localObject).next()).a(paramObjectOutput);
      }
      localObject = this.mMsgAction;
      break;
      localObject = this.mMsgActionData;
      break label57;
      localObject = this.mMsg_A_ActionData;
      break label74;
      localObject = this.mMsg_I_ActionData;
      break label91;
      localObject = this.mMsgUrl;
      break label108;
    }
    paramObjectOutput.writeLong(this.mSourceAppid);
    if (this.mSourceIcon == null)
    {
      localObject = "";
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mSourceName != null) {
        break label1155;
      }
      localObject = "";
      label257:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mSourceUrl != null) {
        break label1163;
      }
      localObject = "";
      label274:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mSourceAction != null) {
        break label1171;
      }
      localObject = "";
      label291:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mSourceActionData != null) {
        break label1179;
      }
      localObject = "";
      label308:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mSource_A_ActionData != null) {
        break label1187;
      }
      localObject = "";
      label325:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mSource_I_ActionData != null) {
        break label1195;
      }
      localObject = "";
      label342:
      paramObjectOutput.writeUTF((String)localObject);
      paramObjectOutput.writeInt(this.fwFlag);
      paramObjectOutput.writeInt(this.mFlag);
      if (this.mResid != null) {
        break label1203;
      }
      localObject = "";
      label379:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mFileName != null) {
        break label1211;
      }
      localObject = "";
      label396:
      paramObjectOutput.writeUTF((String)localObject);
      paramObjectOutput.writeLong(this.mFileSize);
      if (this.mCommentText != null) {
        break label1219;
      }
      localObject = "";
      label423:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mCompatibleText != null) {
        break label1227;
      }
      localObject = "";
      label440:
      paramObjectOutput.writeUTF((String)localObject);
      paramObjectOutput.writeLong(this.msgId);
      paramObjectOutput.writeInt(this.mPromotionType);
      if (this.mPromotionMsg != null) {
        break label1235;
      }
      localObject = "";
      label477:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mPromotionMenus != null) {
        break label1243;
      }
      localObject = "";
      label494:
      paramObjectOutput.writeUTF((String)localObject);
      paramObjectOutput.writeInt(this.mPromotionMenuDestructiveIndex);
      if (this.dynamicMsgMergeKey != null) {
        break label1251;
      }
      localObject = "";
      label521:
      paramObjectOutput.writeUTF((String)localObject);
      paramObjectOutput.writeInt(this.dynamicMsgMergeIndex);
      if (this.source_puin != null) {
        break label1259;
      }
      localObject = "";
      label548:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mSType != null) {
        break label1267;
      }
      localObject = "";
      label565:
      paramObjectOutput.writeUTF((String)localObject);
      paramObjectOutput.writeInt(this.adverSign);
      if (this.adverKey != null) {
        break label1275;
      }
      localObject = "";
      label592:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.index != null) {
        break label1283;
      }
      localObject = "";
      label609:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.index_name != null) {
        break label1291;
      }
      localObject = "";
      label626:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.index_type != null) {
        break label1299;
      }
      localObject = "";
      label643:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.rijAlbumActionData != null) {
        break label1307;
      }
      localObject = "";
      label660:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mArticleIds != null) {
        break label1315;
      }
      localObject = "";
      label677:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mOrangeWord != null) {
        break label1323;
      }
      localObject = "";
      label694:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mAlgorithmIds != null) {
        break label1331;
      }
      localObject = "";
      label711:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mStrategyIds != null) {
        break label1339;
      }
      localObject = "";
      label728:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mExtraData != null) {
        break label1347;
      }
      localObject = "";
      label745:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mCreateTime != null) {
        break label1355;
      }
      localObject = "";
      label762:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mTagName != null) {
        break label1363;
      }
      localObject = "";
      label779:
      paramObjectOutput.writeUTF((String)localObject);
      if (eventId != null) {
        break label1371;
      }
      localObject = "";
      label795:
      paramObjectOutput.writeUTF((String)localObject);
      if (remindBrief != null) {
        break label1378;
      }
      localObject = "";
      label811:
      paramObjectOutput.writeUTF((String)localObject);
      if (eventType != null) {
        break label1385;
      }
      localObject = "";
      label827:
      paramObjectOutput.writeUTF((String)localObject);
      if (tips != null) {
        break label1392;
      }
      localObject = "";
      label843:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mInnerUniqIds != null) {
        break label1399;
      }
      localObject = "";
      label860:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mSourceThirdName != null) {
        break label1407;
      }
      localObject = "";
      label877:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mQQStoryExtra != null) {
        break label1415;
      }
      localObject = "";
      label894:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mNeedRound != null) {
        break label1423;
      }
      localObject = "";
      label911:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mQidianBulkTaskId != null) {
        break label1431;
      }
      localObject = "";
      label928:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.reportEventFolderStatusValue != null) {
        break label1439;
      }
      localObject = "";
      label945:
      paramObjectOutput.writeUTF((String)localObject);
      paramObjectOutput.writeInt(this.forwardType);
      this.shareData.writeExternal(paramObjectOutput);
      if (this.mAdSourceName != null) {
        break label1447;
      }
      localObject = "";
      label980:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mCommonData != null) {
        break label1455;
      }
      localObject = "";
      label997:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.animResId != null) {
        break label1463;
      }
      localObject = "";
      label1014:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.atMembers != null) {
        break label1471;
      }
      localObject = "";
      label1031:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mMergeSeq != null) {
        break label1479;
      }
      localObject = "";
      label1048:
      paramObjectOutput.writeUTF((String)localObject);
      paramObjectOutput.writeLong(this.mSortKey);
      if (this.mTribeShortVideoExtra != null) {
        break label1487;
      }
      localObject = "";
      label1075:
      paramObjectOutput.writeUTF((String)localObject);
      paramObjectOutput.writeBoolean(this.needSendLongMsgWhenFailed);
      paramObjectOutput.writeInt(this.mTSum);
      if (this.mDatas != null) {
        break label1495;
      }
      localObject = "";
      label1112:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mAdSourceMenu != null) {
        break label1506;
      }
    }
    label1155:
    label1163:
    label1171:
    label1179:
    label1187:
    label1195:
    label1203:
    label1211:
    label1219:
    label1227:
    label1235:
    label1243:
    label1506:
    for (localObject = "";; localObject = this.mAdSourceMenu)
    {
      paramObjectOutput.writeUTF((String)localObject);
      paramObjectOutput.writeInt(this.pobingTemplateId);
      return;
      localObject = this.mSourceIcon;
      break;
      localObject = this.mSourceName;
      break label257;
      localObject = this.mSourceUrl;
      break label274;
      localObject = this.mSourceAction;
      break label291;
      localObject = this.mSourceActionData;
      break label308;
      localObject = this.mSource_A_ActionData;
      break label325;
      localObject = this.mSource_I_ActionData;
      break label342;
      localObject = this.mResid;
      break label379;
      localObject = this.mFileName;
      break label396;
      localObject = this.mCommentText;
      break label423;
      localObject = this.mCompatibleText;
      break label440;
      localObject = this.mPromotionMsg;
      break label477;
      localObject = this.mPromotionMenus;
      break label494;
      label1251:
      localObject = this.dynamicMsgMergeKey;
      break label521;
      label1259:
      localObject = this.source_puin;
      break label548;
      label1267:
      localObject = this.mSType;
      break label565;
      label1275:
      localObject = this.adverKey;
      break label592;
      localObject = this.index;
      break label609;
      localObject = this.index_name;
      break label626;
      localObject = this.index_type;
      break label643;
      localObject = this.rijAlbumActionData;
      break label660;
      localObject = this.mArticleIds;
      break label677;
      localObject = this.mOrangeWord;
      break label694;
      localObject = this.mAlgorithmIds;
      break label711;
      localObject = this.mStrategyIds;
      break label728;
      localObject = this.mExtraData;
      break label745;
      localObject = this.mCreateTime;
      break label762;
      localObject = this.mTagName;
      break label779;
      localObject = eventId;
      break label795;
      label1378:
      localObject = remindBrief;
      break label811;
      label1385:
      localObject = eventType;
      break label827;
      label1392:
      localObject = tips;
      break label843;
      label1399:
      localObject = this.mInnerUniqIds;
      break label860;
      label1407:
      localObject = this.mSourceThirdName;
      break label877;
      localObject = this.mQQStoryExtra;
      break label894;
      localObject = this.mNeedRound;
      break label911;
      localObject = this.mQidianBulkTaskId;
      break label928;
      localObject = this.reportEventFolderStatusValue;
      break label945;
      localObject = this.mAdSourceName;
      break label980;
      localObject = this.mCommonData;
      break label997;
      localObject = this.animResId;
      break label1014;
      localObject = this.atMembers;
      break label1031;
      localObject = this.mMergeSeq;
      break label1048;
      localObject = this.mTribeShortVideoExtra;
      break label1075;
      localObject = this.mDatas.toString();
      break label1112;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.StructMsgForGeneralShare
 * JD-Core Version:    0.7.0.1
 */