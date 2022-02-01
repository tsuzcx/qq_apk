package com.tencent.mobileqq.structmsg;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.util.PAVideoStructMsgUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.TroopInviteStatusFragment;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder.StructingMsgViewHolder;
import com.tencent.mobileqq.activity.history.ChatHistoryC2CLinkAdapter.HistoryStructItemHolder;
import com.tencent.mobileqq.adapter.ChatHistoryStructAdapter.HistoryStructItemHolder;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.businessCard.BusinessCardManager;
import com.tencent.mobileqq.businessCard.activity.BusinessCardEditActivity;
import com.tencent.mobileqq.businessCard.data.BusinessCard;
import com.tencent.mobileqq.businessCard.data.CardOCRInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.dating.NearbyTransitActivity;
import com.tencent.mobileqq.ecshop.ad.api.IEcshopAdApi;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.intervideo.now.dynamic.IDynamicNowManagerApi;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.qqgamepub.api.IQQGameHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.receipt.ReceiptMessageDetailFragment;
import com.tencent.mobileqq.receipt.ReceiptMsgManager;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.view.StructMsgItemButton;
import com.tencent.mobileqq.structmsg.view.StructMsgItemCover;
import com.tencent.mobileqq.structmsg.view.StructMsgItemHr;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout12;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout18;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout19;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout2;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout20;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout26;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout27;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout28;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout29;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout3;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout4;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout5;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout5Adapter;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout6;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout6Adapter;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout8;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout9;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayoutDefault;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayoutMicro;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayoutNew2;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLongMsgHolder;
import com.tencent.mobileqq.structmsg.view.StructMsgItemMore;
import com.tencent.mobileqq.structmsg.view.StructMsgItemProgress;
import com.tencent.mobileqq.structmsg.view.StructMsgItemSummary;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.structmsg.view.StructMsgItemType;
import com.tencent.mobileqq.structmsg.view.StructMsgItemVideo;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.troop.utils.TroopInfoUIUtil;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.utils.TroopReportor;
import com.tencent.mobileqq.weather.api.IWeatherCommApi;
import com.tencent.open.sdk.report.SdkShareReporter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;
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
import org.json.JSONException;
import org.json.JSONObject;

public class StructMsgForGeneralShare
  extends AbsShareMsg
{
  public static final String KEY_PAY_STAT = "order_pay_state_";
  public static final String LOGO_URL_POSTFIX = ".png";
  private static String a = "structmsg.StructMsgForGeneralShare";
  private static int b = -3;
  private static View.OnClickListener c = new StructMsgForGeneralShare.5();
  public static int clickedItemIndex = 0;
  public static String eventId = "";
  public static String eventType = "";
  public static QIPCModule receiptServer;
  public static String remindBrief = "";
  public static String tips = "";
  public String animResId;
  public String atMembers;
  public boolean havaPayInfoInit = false;
  boolean isMultiVideoItem;
  int mClickpositionX;
  int mClickpositionY;
  WeakReference<Context> mContext = new WeakReference(null);
  WeakReference<LinearLayout> mExpandView = new WeakReference(null);
  public List<String> mHadPaidList = new ArrayList();
  public boolean mIsPAVideoStructMsg;
  public String mPARedPacket;
  public String mVipDonateStr;
  public String mWarningTips;
  public boolean needSendLongMsgWhenFailed;
  public int pobingTemplateId;
  
  public StructMsgForGeneralShare()
  {
    this.mWarningTips = "";
    this.mPARedPacket = "";
    this.mIsPAVideoStructMsg = false;
    this.mVipDonateStr = "";
    this.isMultiVideoItem = false;
    this.pobingTemplateId = 2000;
    this.needSendLongMsgWhenFailed = false;
    this.mMsgServiceID = 1;
    this.mMsgAction = "web";
  }
  
  StructMsgForGeneralShare(Bundle paramBundle)
  {
    super(paramBundle);
    Object localObject1 = "";
    this.mWarningTips = "";
    this.mPARedPacket = "";
    this.mIsPAVideoStructMsg = false;
    this.mVipDonateStr = "";
    this.isMultiVideoItem = false;
    this.pobingTemplateId = 2000;
    this.needSendLongMsgWhenFailed = false;
    this.mContentLayout = 2;
    this.mMsgServiceID = paramBundle.getInt("req_type", 1);
    this.mNeedRound = paramBundle.getString("icon_need_round");
    if (this.mSourceName != null) {
      if (this.mSourceName.equalsIgnoreCase(HardCodeUtil.a(2131911907))) {
        this.mMsgServiceID = 54;
      } else if (this.mSourceName.equalsIgnoreCase(HardCodeUtil.a(2131891080))) {
        this.mMsgServiceID = 53;
      }
    }
    Object localObject2 = paramBundle.getString("new_share_service_id");
    if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (TextUtils.isDigitsOnly((CharSequence)localObject2)))
    {
      i = Integer.parseInt((String)localObject2);
      if ((i == 83) || (i == 108) || (i == 114) || (i == 116) || (i == 123)) {
        this.mMsgServiceID = i;
      }
    }
    this.mCreateTime = paramBundle.getString("req_create_time");
    localObject2 = paramBundle.getString("source_puin");
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = localObject2;
    }
    this.source_puin = ((String)localObject1);
    this.mSourceUrl = paramBundle.getString("source_url");
    this.rijAlbumActionData = paramBundle.getString("readinjoy_gallery");
    if (TextUtils.isEmpty(this.mSourceUrl)) {
      this.mSourceUrl = paramBundle.getString("struct_share_key_source_url");
    }
    String str1 = paramBundle.getString("detail_url");
    localObject2 = paramBundle.getString("category");
    String str2 = paramBundle.getString("video_url");
    boolean bool = paramBundle.getBoolean("video_url_load", false);
    int i = paramBundle.getInt("layout_item", 2);
    if (!TextUtils.isEmpty(str2)) {
      i = 5;
    }
    if (("web".equals(this.mMsgAction)) && ("micro_app".equals(this.mMsg_A_ActionData))) {
      localObject1 = new StructMsgItemLayoutMicro();
    } else {
      localObject1 = StructMsgElementFactory.a(i);
    }
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      AbsStructMsgItem localAbsStructMsgItem = StructMsgElementFactory.a(0);
      localAbsStructMsgItem.c(1);
      localAbsStructMsgItem.b((String)localObject2);
      addItem(localAbsStructMsgItem);
      if (TextUtils.isEmpty(str2))
      {
        ((AbsStructMsgItem)localObject1).a(this.mContentCover, this.mContentTitle, this.mContentSummary, 1);
      }
      else
      {
        a((AbsStructMsgItem)localObject1, bool, str1, this.mContentCover, str2, this.mContentTitle, this.mContentSummary, paramBundle);
        ((AbsStructMsgItem)localObject1).au = 1;
      }
    }
    for (;;)
    {
      break;
      if ((this.mMsgServiceID == 118) && (this.mSourceName != null) && (this.mSourceName.equalsIgnoreCase(HardCodeUtil.a(2131911905))))
      {
        ((AbsStructMsgItem)localObject1).a(this.mContentCover, this.mContentTitle, 0, this.mNeedRound);
      }
      else if (TextUtils.isEmpty(str2))
      {
        ((AbsStructMsgItem)localObject1).a(this.mContentCover, this.mContentTitle, this.mContentSummary, 0, this.mNeedRound);
      }
      else
      {
        localObject2 = localObject1;
        a((AbsStructMsgItem)localObject2, bool, str1, this.mContentCover, str2, this.mContentTitle, this.mContentSummary, paramBundle);
        ((AbsStructMsgItem)localObject2).au = 0;
      }
    }
    this.needSendLongMsgWhenFailed = paramBundle.getBoolean("need_send_long_msg_when_failed", false);
    addItem((AbsStructMsgElement)localObject1);
    if (this.mMsgAction == null) {
      this.mMsgAction = "web";
    }
  }
  
  StructMsgForGeneralShare(StructMsgNode paramStructMsgNode)
  {
    super(paramStructMsgNode);
    this.mWarningTips = "";
    this.mPARedPacket = "";
    this.mIsPAVideoStructMsg = false;
    this.mVipDonateStr = "";
    this.isMultiVideoItem = false;
    this.pobingTemplateId = 2000;
    this.needSendLongMsgWhenFailed = false;
    this.mWarningTips = paramStructMsgNode.a("warningTipsContent");
    this.mPARedPacket = paramStructMsgNode.a("paRedPacket");
    this.mVipDonateStr = paramStructMsgNode.a("vipDonate");
    eventId = paramStructMsgNode.a("eventId");
    remindBrief = paramStructMsgNode.a("remindBrief");
    eventType = paramStructMsgNode.a("eventType");
    this.animResId = paramStructMsgNode.a("resid");
    tips = paramStructMsgNode.a("tips");
    this.atMembers = paramStructMsgNode.a("atmembers");
  }
  
  public static boolean HandleMiniAppJump(Context paramContext, String paramString)
  {
    Object localObject;
    StringBuilder localStringBuilder;
    if (((IMiniAppService)QRoute.api(IMiniAppService.class)).isMiniAppUrl(paramString))
    {
      localObject = a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(" jump to miniApp: ");
      localStringBuilder.append(paramString);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
      return ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp(paramContext, paramString, 1043, null);
    }
    if ((paramString.startsWith("http://q.url.cn/url/Jump")) || (paramString.startsWith("https://q.url.cn/url/Jump"))) {}
    try
    {
      paramString = URLUtil.b(paramString.substring(paramString.indexOf("?") + 1));
      localObject = new HashMap();
      ((HashMap)localObject).putAll(paramString);
      if (((HashMap)localObject).containsKey("url"))
      {
        paramString = (String)((HashMap)localObject).get("url");
        if (((IMiniAppService)QRoute.api(IMiniAppService.class)).isMiniAppUrl(paramString))
        {
          localObject = a;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(" jump to miniApp: ");
          localStringBuilder.append(paramString);
          QLog.d((String)localObject, 2, localStringBuilder.toString());
          boolean bool = ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp(paramContext, paramString, 1043, null);
          return bool;
        }
      }
      return false;
    }
    catch (Exception paramContext)
    {
      QLog.e(a, 2, "parse url failed, ", paramContext);
    }
    return false;
  }
  
  private static long a(AbsStructMsg paramAbsStructMsg, BaseActivity paramBaseActivity)
  {
    long l1 = paramAbsStructMsg.uniseq;
    if ((paramBaseActivity.getIntent() != null) && (paramBaseActivity.getIntent().hasExtra("origin_merge_structing_msg_uniseq")))
    {
      long l2 = paramBaseActivity.getIntent().getLongExtra("origin_merge_structing_msg_uniseq", -1L);
      if (l2 > 0L) {
        return l2;
      }
    }
    return l1;
  }
  
  private void a(Context paramContext, int paramInt, View paramView)
  {
    if (paramView == null) {
      return;
    }
    int i;
    int j;
    AbsStructMsgElement localAbsStructMsgElement;
    if (paramInt <= 2)
    {
      i = paramInt - 1;
      if (i >= 0)
      {
        j = AIOUtils.b(12.0F, paramContext.getResources());
        int k = paramView.getPaddingBottom();
        int m = paramView.getPaddingLeft();
        int n = paramView.getPaddingRight();
        localAbsStructMsgElement = getItemByIndex(i);
        if ((localAbsStructMsgElement instanceof StructMsgItemLayoutDefault))
        {
          StructMsgItemLayoutDefault localStructMsgItemLayoutDefault = (StructMsgItemLayoutDefault)localAbsStructMsgElement;
          if ((localStructMsgItemLayoutDefault.ax.size() == 1) && ((localStructMsgItemLayoutDefault.ax.get(0) instanceof StructMsgItemHr)))
          {
            int i1 = paramInt - 2;
            if ((i1 >= 0) && ((getItemByIndex(i1) instanceof StructMsgItemLayout5)) && (StructMsgItemLayout5Adapter.a((AbsStructMsgItem)getItemByIndex(i1), i1)))
            {
              paramView.setPadding(m, j, n, k);
              return;
            }
          }
        }
        if (((localAbsStructMsgElement instanceof StructMsgItemLayout5)) && ((StructMsgItemLayout5Adapter.a((AbsStructMsgItem)localAbsStructMsgElement, i)) || (this.isMultiVideoItem)))
        {
          paramView.setPadding(m, j, n, k);
          return;
        }
      }
    }
    if (paramInt == getItemCount() - 1)
    {
      localAbsStructMsgElement = getItemByIndex(0);
      if (((localAbsStructMsgElement instanceof StructMsgItemLayout5)) && ((StructMsgItemLayout5Adapter.a((AbsStructMsgItem)localAbsStructMsgElement, 0)) || (this.isMultiVideoItem)))
      {
        paramInt = AIOUtils.b(12.0F, paramContext.getResources());
        i = paramView.getPaddingLeft();
        j = paramView.getPaddingRight();
        paramView.setPadding(i, paramView.getPaddingTop(), j, paramInt);
      }
    }
  }
  
  private void a(View paramView, Resources paramResources, Bundle paramBundle)
  {
    if (paramView != null)
    {
      if (paramResources == null) {
        return;
      }
      Object localObject = paramView.getLayoutParams();
      if (localObject == null)
      {
        localObject = new LinearLayout.LayoutParams(BaseChatItemLayout.B, -2);
      }
      else
      {
        ((ViewGroup.LayoutParams)localObject).width = BaseChatItemLayout.B;
        ((ViewGroup.LayoutParams)localObject).height = -2;
      }
      int i;
      if (hasFlag(4))
      {
        ((ViewGroup.LayoutParams)localObject).width = -1;
        if (paramBundle.getInt("accostType") == AbsStructMsg.SOURCE_ACCOUNT_TYPE_PA) {
          i = 1;
        } else {
          i = 0;
        }
        if ((i == 0) || (!hasFlag(4))) {
          paramView.setBackgroundResource(2130838312);
        }
      }
      if (this.mMsgServiceID == 76)
      {
        ((ViewGroup.LayoutParams)localObject).width = -1;
        paramView.setBackgroundDrawable(null);
      }
      else if ((this.mMsgServiceID != 83) && (this.mMsgServiceID != 108) && (this.mMsgServiceID != 151) && (this.mMsgServiceID != 156))
      {
        if ((this.mMsgServiceID != 114) && (this.mMsgServiceID != 116))
        {
          if (this.mMsgServiceID == 98)
          {
            ((ViewGroup.LayoutParams)localObject).width = Math.min(BaseChatItemLayout.B + AIOUtils.b(10.0F, paramResources), AIOUtils.b(206.0F, paramResources));
            paramView.setBackgroundDrawable(null);
          }
          else if (this.mMsgServiceID == 91)
          {
            ((ViewGroup.LayoutParams)localObject).width = -1;
            paramView.setBackgroundResource(2130838312);
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
        else
        {
          ((ViewGroup.LayoutParams)localObject).width = BaseChatItemLayout.B;
          if (!TextUtils.isEmpty(this.mMsgActionData)) {
            ((ViewGroup.LayoutParams)localObject).width += AIOUtils.b(18.0F, paramResources);
          }
          paramView.setBackgroundDrawable(null);
          if (this.mMsgServiceID == 116)
          {
            paramResources = paramView.findViewById(2131431458);
            if (paramResources != null)
            {
              i = paramResources.getHeight();
              double d1 = ((ViewGroup.LayoutParams)localObject).width;
              double d2 = i;
              Double.isNaN(d2);
              if (d1 > d2 * 2.1312D)
              {
                Double.isNaN(d1);
                i = (int)(d1 / 1.776D);
                paramBundle = paramResources.getLayoutParams();
                paramBundle.height = i;
                paramResources.setLayoutParams(paramBundle);
              }
            }
          }
          else if (this.mMsgServiceID == 114)
          {
            paramResources = paramView.findViewById(2131431458);
            if (paramResources != null)
            {
              paramBundle = paramResources.getLayoutParams();
              if (ScreenUtil.SCREEN_WIDTH > 1280) {
                paramBundle.height = AIOUtils.b(144.0F, paramResources.getResources());
              } else {
                paramBundle.height = AIOUtils.b(112.0F, paramResources.getResources());
              }
              paramResources.setLayoutParams(paramBundle);
            }
          }
        }
      }
      else
      {
        ((ViewGroup.LayoutParams)localObject).width = (BaseChatItemLayout.B + AIOUtils.b(10.0F, paramResources));
        if (!TextUtils.isEmpty(this.mMsgActionData)) {
          ((ViewGroup.LayoutParams)localObject).width += AIOUtils.b(18.0F, paramResources);
        }
        paramView.setBackgroundDrawable(null);
      }
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
  }
  
  private void a(AbsStructMsgItem paramAbsStructMsgItem, boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, Bundle paramBundle)
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
    if (PAVideoStructMsgUtil.a(i1)) {
      paramString2 = new StructMsgItemVideo(paramString2, i1, str1, str2, paramString5, i, j, k, m, n, str3, str4, str5, i2, l);
    } else {
      paramString2 = new StructMsgItemVideo(paramString2, paramString3, paramBoolean);
    }
    paramString2.as = this;
    paramString2.as.mMsgUrl = paramString1;
    paramAbsStructMsgItem.a(paramString2);
    paramAbsStructMsgItem.a(new StructMsgItemTitle(paramString4));
  }
  
  public static void dealMsgBeforeClick(StructMsgForGeneralShare paramStructMsgForGeneralShare, ChatMessage paramChatMessage)
  {
    if (paramStructMsgForGeneralShare != null)
    {
      if (paramChatMessage == null) {
        return;
      }
      if ((paramStructMsgForGeneralShare.mMsgServiceID == 14) && (!TextUtils.isEmpty(paramStructMsgForGeneralShare.mMsg_A_ActionData)) && (!paramStructMsgForGeneralShare.mMsg_A_ActionData.contains("&referee="))) {
        paramStructMsgForGeneralShare.mMsg_A_ActionData = String.format("%s&referee=%s", new Object[] { paramStructMsgForGeneralShare.mMsg_A_ActionData, paramChatMessage.senderuin });
      }
      if (QLog.isColorLevel()) {
        QLog.i(a, 2, String.format("dealMsgBeforeClick service_id:%s, data:%s, frd_uin:%s, sender_uin:%s", new Object[] { Integer.valueOf(paramStructMsgForGeneralShare.mMsgServiceID), paramStructMsgForGeneralShare.mMsg_A_ActionData, paramChatMessage.frienduin, paramChatMessage.senderuin }));
      }
    }
  }
  
  public static String getCoverForChatHistory(AbsStructMsgElement paramAbsStructMsgElement)
  {
    if ((paramAbsStructMsgElement instanceof StructMsgItemCover)) {
      return ((StructMsgItemCover)paramAbsStructMsgElement).av;
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
    }
    catch (IOException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d(a, 2, "getResponseRedirectLocation  IOException ", paramString);
      }
    }
    catch (MalformedURLException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d(a, 2, "getResponseRedirectLocation  MalformedURLException ", paramString);
      }
    }
    paramString = null;
    if (QLog.isColorLevel())
    {
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getResponseRedirectLocation  location = ");
      localStringBuilder.append(paramString);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    return paramString;
  }
  
  public static String getSummary(AbsStructMsgElement paramAbsStructMsgElement)
  {
    if ((paramAbsStructMsgElement instanceof StructMsgItemSummary)) {
      return ((StructMsgItemSummary)paramAbsStructMsgElement).aA;
    }
    return null;
  }
  
  public static String getTitleForChatHistory(AbsStructMsgElement paramAbsStructMsgElement)
  {
    if ((paramAbsStructMsgElement instanceof AbsStructMsgTextElement)) {
      return ((AbsStructMsgTextElement)paramAbsStructMsgElement).aA;
    }
    return null;
  }
  
  static boolean handleNearbyPublicAccountMsg(QQAppInterface paramQQAppInterface, Context paramContext, StructMsgForGeneralShare paramStructMsgForGeneralShare)
  {
    boolean bool3 = paramStructMsgForGeneralShare.mMsgBrief.contains(HardCodeUtil.a(2131911903));
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      String str1 = getResponseRedirectLocation(paramStructMsgForGeneralShare.mMsgUrl);
      bool1 = bool2;
      if (str1 != null)
      {
        bool1 = bool2;
        if (str1.contains("find_school_mate_guide"))
        {
          int i = str1.indexOf("find_school_mate_guide");
          bool1 = bool2;
          if (i > 0)
          {
            String str2 = str1.substring(i + 22 + 1);
            try
            {
              str2 = URLDecoder.decode(str2, "UTF-8");
              if (QLog.isColorLevel())
              {
                String str3 = a;
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append("handleNearbyPublicAccountMsg find shoolmate msg clicked, url =  ");
                localStringBuilder.append(str1);
                localStringBuilder.append(",schema = ");
                localStringBuilder.append(str2);
                QLog.d(str3, 2, localStringBuilder.toString());
              }
              paramQQAppInterface = JumpParser.a(paramQQAppInterface, paramContext, str2);
              bool1 = bool2;
              if (paramQQAppInterface != null)
              {
                paramQQAppInterface.a();
                bool1 = true;
              }
            }
            catch (UnsupportedEncodingException paramQQAppInterface)
            {
              paramQQAppInterface.printStackTrace();
              bool1 = bool2;
            }
          }
        }
      }
    }
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = a;
      paramContext = new StringBuilder();
      paramContext.append("handleNearbyPublicAccountMsg  result = ");
      paramContext.append(bool1);
      paramContext.append(",msg.mMsgBrief = ");
      paramContext.append(paramStructMsgForGeneralShare.mMsgBrief);
      QLog.d(paramQQAppInterface, 2, paramContext.toString());
    }
    return bool1;
  }
  
  public static void onClickEvent(QQAppInterface paramQQAppInterface, Context paramContext, StructMsgForGeneralShare paramStructMsgForGeneralShare, View paramView, StructMsgForGeneralShare.GeneralClickHandler paramGeneralClickHandler)
  {
    Object localObject1 = paramView.getTag();
    if ((localObject1 != null) && ((localObject1 instanceof StructingMsgItemBuilder.StructingMsgViewHolder)))
    {
      localObject1 = ((StructingMsgItemBuilder.StructingMsgViewHolder)localObject1).q;
    }
    else if ((localObject1 != null) && ((localObject1 instanceof ChatHistoryStructAdapter.HistoryStructItemHolder)))
    {
      localObject1 = (ChatMessage)((ChatHistoryStructAdapter.HistoryStructItemHolder)localObject1).f;
    }
    else if ((localObject1 != null) && ((localObject1 instanceof ChatHistoryC2CLinkAdapter.HistoryStructItemHolder)))
    {
      localObject1 = (ChatMessage)((ChatHistoryC2CLinkAdapter.HistoryStructItemHolder)localObject1).g;
    }
    else
    {
      if (!(localObject1 instanceof MessageForStructing)) {
        break label4515;
      }
      localObject1 = (MessageForStructing)localObject1;
    }
    paramStructMsgForGeneralShare.uniseq = ((ChatMessage)localObject1).uniseq;
    paramStructMsgForGeneralShare.uin = ((ChatMessage)localObject1).frienduin;
    paramStructMsgForGeneralShare.uinType = ((ChatMessage)localObject1).istroop;
    paramStructMsgForGeneralShare.currentAccountUin = ((ChatMessage)localObject1).selfuin;
    paramStructMsgForGeneralShare.messageVersion = ((ChatMessage)localObject1).versionCode;
    boolean bool2 = "web".equals(paramStructMsgForGeneralShare.mMsgAction);
    Object localObject6 = ";ARTICALID=";
    String str1 = ";TEPLATEID=";
    localObject7 = "";
    boolean bool1 = true;
    Object localObject4;
    int j;
    if (bool2)
    {
      paramView = paramStructMsgForGeneralShare.mMsgUrl;
      localObject4 = (IWeatherCommApi)QRoute.api(IWeatherCommApi.class);
      if (((IWeatherCommApi)localObject4).isWeatherArkPageUrl(paramView))
      {
        ((IWeatherCommApi)localObject4).startNewWeatherWebPageActivityByFollowState(paramContext, paramQQAppInterface, 4, paramView);
        return;
      }
      if (TextUtils.isEmpty(paramStructMsgForGeneralShare.mMsgActionData)) {
        paramView = paramStructMsgForGeneralShare.mMsg_A_ActionData;
      } else {
        paramView = paramStructMsgForGeneralShare.mMsgActionData;
      }
      localObject4 = paramStructMsgForGeneralShare.rijAlbumActionData;
      if ((!TextUtils.isEmpty(paramView)) && ((paramStructMsgForGeneralShare.mMsgServiceID == 151) || (paramStructMsgForGeneralShare.mMsgServiceID == 156)))
      {
        paramContext = JumpParser.a(paramQQAppInterface, paramContext, paramView);
        if (paramContext != null)
        {
          paramContext.a();
          bool1 = true;
        }
        else
        {
          bool1 = false;
        }
      }
      for (;;)
      {
        paramContext = ";TEPLATEID=";
        paramView = ";ARTICALID=";
        break label2554;
        if ((!TextUtils.isEmpty((CharSequence)localObject4)) && (((String)localObject4).startsWith("mqqapi://readinjoy/openatlas")))
        {
          paramContext = JumpParser.a(paramQQAppInterface, paramContext, (String)localObject4);
          if (paramContext != null)
          {
            paramContext.a();
            bool2 = true;
          }
          else
          {
            paramGeneralClickHandler.a(paramStructMsgForGeneralShare.mMsgUrl);
            bool2 = false;
          }
          bool1 = bool2;
          if (QLog.isColorLevel())
          {
            paramContext = a;
            paramView = new StringBuilder();
            paramView.append("handle readinjoy gallery jump rijAlbumActionData = ");
            paramView.append((String)localObject4);
            QLog.d(paramContext, 2, paramView.toString());
            bool1 = bool2;
          }
        }
        else if ((!TextUtils.isEmpty(paramView)) && (paramView.startsWith("mqqapi://dating/")))
        {
          if (QLog.isColorLevel())
          {
            paramView = a;
            paramGeneralClickHandler = new StringBuilder();
            paramGeneralClickHandler.append("handle dating jump .msg.mMsgUrl = ");
            paramGeneralClickHandler.append(paramStructMsgForGeneralShare.mMsgUrl);
            QLog.d(paramView, 2, paramGeneralClickHandler.toString());
          }
          paramView = new Intent(paramContext, QQBrowserActivity.class);
          paramView.putExtra("url", paramStructMsgForGeneralShare.mMsgUrl);
          paramContext.startActivity(paramView);
        }
        else if ((!TextUtils.isEmpty(paramView)) && ((paramStructMsgForGeneralShare.mMsgServiceID == 65) || (paramStructMsgForGeneralShare.mMsgServiceID == 69)))
        {
          paramGeneralClickHandler = new Intent(paramContext, NearbyTransitActivity.class);
          paramGeneralClickHandler.putExtra("action", 1);
          paramGeneralClickHandler.putExtra("hotnamecode", paramView);
          paramGeneralClickHandler.putExtra("enter_time", System.currentTimeMillis());
          paramContext.startActivity(paramGeneralClickHandler);
        }
        else
        {
          if ((TextUtils.isEmpty(paramView)) || (!paramView.startsWith("story:"))) {
            break;
          }
          paramContext = JumpParser.a(paramQQAppInterface, paramContext, paramView.substring(6));
          if (paramContext != null)
          {
            paramContext.a();
            bool2 = true;
          }
          else
          {
            paramGeneralClickHandler.a(paramStructMsgForGeneralShare.mMsgUrl);
            bool2 = false;
          }
          bool1 = bool2;
          if (QLog.isColorLevel())
          {
            paramContext = new StringBuilder();
            paramContext.append(a);
            paramContext.append("Q.qqstory.TAG_NOW_ENTRANCE_ACTION_CONFIG");
            paramContext = paramContext.toString();
            paramGeneralClickHandler = new StringBuilder();
            paramGeneralClickHandler.append("handle now jump actionData = ");
            paramGeneralClickHandler.append(paramView);
            QLog.d(paramContext, 2, paramGeneralClickHandler.toString());
            bool1 = bool2;
          }
        }
      }
      if (paramStructMsgForGeneralShare.mMsgServiceID == 60) {
        paramGeneralClickHandler.a(paramStructMsgForGeneralShare.mMsgUrl);
      }
      label1347:
      label1370:
      do
      {
        for (;;)
        {
          paramView = ";ARTICALID=";
          paramContext = ";TEPLATEID=";
          bool1 = false;
          break label2554;
          if ((!TextUtils.isEmpty(paramStructMsgForGeneralShare.mMsgUrl)) && ((paramStructMsgForGeneralShare.mMsgUrl.startsWith("https://jq.qq.com")) || (paramStructMsgForGeneralShare.mMsgUrl.startsWith("http://jq.qq.com"))))
          {
            paramGeneralClickHandler.a(paramStructMsgForGeneralShare.mMsgUrl);
          }
          else
          {
            if ((!TextUtils.isEmpty(paramStructMsgForGeneralShare.mMsgUrl)) && ((paramStructMsgForGeneralShare.mMsgUrl.startsWith("http://now.qq.com")) || (paramStructMsgForGeneralShare.mMsgUrl.startsWith("https://now.qq.com")) || (paramStructMsgForGeneralShare.mMsgUrl.startsWith("https://ilive.qq.com"))))
            {
              int m;
              if ((!paramStructMsgForGeneralShare.mMsgUrl.contains("http://now.qq.com/huayang/jiaoyou/share.html")) && (!paramStructMsgForGeneralShare.mMsgUrl.contains("https://now.qq.com/huayang/jiaoyou/share.html"))) {
                m = 0;
              } else {
                m = 1;
              }
              boolean bool3;
              if ((!paramStructMsgForGeneralShare.mMsgUrl.contains("http://now.qq.com/h5/index.html")) && (!paramStructMsgForGeneralShare.mMsgUrl.contains("http://now.qq.com/h5/story.html")) && (!paramStructMsgForGeneralShare.mMsgUrl.contains("https://now.qq.com/h5/index.html")) && (!paramStructMsgForGeneralShare.mMsgUrl.contains("https://now.qq.com/h5/story.html")) && (!paramStructMsgForGeneralShare.mMsgUrl.contains("https://ilive.qq.com/1014/h5/h5_record_share.html")) && (!paramStructMsgForGeneralShare.mMsgUrl.contains("https://ilive.qq.com/1014/h5/h5_live_share.html")) && (m == 0)) {
                bool3 = false;
              } else {
                bool3 = true;
              }
              if (bool3)
              {
                String str2 = paramStructMsgForGeneralShare.mMsgUrl.substring(paramStructMsgForGeneralShare.mMsgUrl.indexOf("?") + 1);
                String[] arrayOfString1 = str2.split("&");
                Bundle localBundle = new Bundle();
                localBundle.putString("url", paramStructMsgForGeneralShare.mMsgUrl);
                localObject5 = "0";
                paramView = "";
                localObject1 = paramView;
                int n = 0;
                j = 0;
                while (n < arrayOfString1.length)
                {
                  String[] arrayOfString2 = arrayOfString1[n].split("=");
                  int k;
                  Object localObject8;
                  Object localObject9;
                  if (arrayOfString2.length != 2)
                  {
                    i = j;
                    localObject4 = localObject5;
                  }
                  else
                  {
                    localObject4 = localObject5;
                    k = j;
                    localObject8 = localObject5;
                    localObject9 = localObject1;
                  }
                  for (;;)
                  {
                    try
                    {
                      if ("roomid".equals(arrayOfString2[0])) {
                        localObject4 = arrayOfString2[1];
                      }
                      localObject5 = localObject1;
                      k = j;
                      localObject8 = localObject4;
                      localObject9 = localObject1;
                      if ("vid".equals(arrayOfString2[0])) {
                        localObject5 = arrayOfString2[1];
                      }
                      i = j;
                      k = j;
                      localObject8 = localObject4;
                      localObject9 = localObject5;
                      if ("first".equals(arrayOfString2[0]))
                      {
                        k = j;
                        localObject8 = localObject4;
                        localObject9 = localObject5;
                        i = Integer.parseInt(arrayOfString2[1]);
                      }
                      k = i;
                      localObject8 = localObject4;
                      localObject9 = localObject5;
                      if (!"sharefrom".equals(arrayOfString2[0])) {
                        continue;
                      }
                      paramView = arrayOfString2[1];
                      localObject1 = paramView;
                    }
                    catch (NumberFormatException localNumberFormatException1)
                    {
                      continue;
                      continue;
                    }
                    try
                    {
                      localBundle.putString("from", paramView);
                      j = i;
                      localObject1 = paramView;
                      if (!TextUtils.isEmpty(paramView))
                      {
                        localObject1 = paramView;
                        j = ((IDynamicNowManagerApi)QRoute.api(IDynamicNowManagerApi.class)).getFirstByFrom(paramView);
                      }
                      i = j;
                      if (j == 0) {
                        i = 2;
                      }
                      localObject1 = localObject7;
                    }
                    catch (NumberFormatException paramView)
                    {
                      paramView = localNumberFormatException1;
                      localObject2 = localObject5;
                    }
                  }
                  try
                  {
                    if ("fromid".equals(arrayOfString2[0])) {
                      localObject1 = arrayOfString2[1];
                    }
                  }
                  catch (NumberFormatException localNumberFormatException2)
                  {
                    localObject3 = localObject7;
                    break label1347;
                  }
                  localObject7 = localObject1;
                  localObject1 = localObject5;
                  break label1370;
                  localObject1 = localObject9;
                  localObject4 = localObject8;
                  i = k;
                  n += 1;
                  j = i;
                  localObject5 = localObject4;
                }
                for (;;)
                {
                  try
                  {
                    localObject4 = new StringBuilder(str2);
                    if (!str2.contains("first="))
                    {
                      ((StringBuilder)localObject4).append("&first=");
                      ((StringBuilder)localObject4).append(j);
                    }
                    if (!TextUtils.isEmpty(paramView))
                    {
                      ((StringBuilder)localObject4).append("&fromid=share_msg_");
                      ((StringBuilder)localObject4).append(paramView);
                      ((StringBuilder)localObject4).append("&startsrc=share_msg_");
                      ((StringBuilder)localObject4).append(paramView);
                    }
                    else
                    {
                      ((StringBuilder)localObject4).append("&fromid=share_msg_");
                      ((StringBuilder)localObject4).append((String)localObject7);
                      ((StringBuilder)localObject4).append("&startsrc=share_msg_");
                      ((StringBuilder)localObject4).append((String)localObject7);
                    }
                    if (m != 0)
                    {
                      ((StringBuilder)localObject4).append("&msgurl=");
                      ((StringBuilder)localObject4).append(Base64Util.encodeToString(paramStructMsgForGeneralShare.mMsgUrl.getBytes(), 0));
                    }
                    if ((0L == Long.parseLong((String)localObject5)) && (TextUtils.isEmpty((CharSequence)localObject1)))
                    {
                      bool1 = paramGeneralClickHandler.a(paramStructMsgForGeneralShare.mMsgUrl);
                      continue;
                    }
                    paramView = new StringBuilder();
                    paramView.append("nowmqqapi://now/openroom?");
                    paramView.append(((StringBuilder)localObject4).toString());
                    paramView = paramView.toString();
                    localObject1 = new Intent(paramContext, JumpActivity.class);
                    ((Intent)localObject1).setData(Uri.parse(paramView));
                    ((Intent)localObject1).putExtra("big_brother_source_key", "biz_src_jc_aio");
                    paramContext.startActivity((Intent)localObject1);
                    bool2 = false;
                  }
                  catch (NumberFormatException paramContext)
                  {
                    Object localObject2;
                    Object localObject3;
                    continue;
                  }
                  paramGeneralClickHandler.a(paramStructMsgForGeneralShare.mMsgUrl);
                }
              }
              str1 = ";TEPLATEID=";
              localObject6 = ";ARTICALID=";
              bool1 = paramGeneralClickHandler.a(paramStructMsgForGeneralShare.mMsgUrl);
              bool2 = bool1;
              bool1 = bool2;
              paramContext = str1;
              paramView = (View)localObject6;
              if (!QLog.isColorLevel()) {
                break label2554;
              }
              paramContext = new StringBuilder();
              paramContext.append(a);
              paramContext.append("Q.qqstory.TAG_NOW_ENTRANCE_ACTION_CONFIG");
              paramContext = paramContext.toString();
              paramView = new StringBuilder();
              paramView.append("handle now jump .msg.mMsgUrl = ");
              paramView.append(paramStructMsgForGeneralShare.mMsgUrl);
              paramView.append("|isUrlInWhileList:");
              paramView.append(bool3);
              QLog.d(paramContext, 2, paramView.toString());
              bool1 = bool2;
              paramContext = str1;
              paramView = (View)localObject6;
              break label2554;
            }
            localObject4 = ";TEPLATEID=";
            localObject5 = ";ARTICALID=";
            if ((TextUtils.isEmpty(paramStructMsgForGeneralShare.mMsgUrl)) || (!paramStructMsgForGeneralShare.mMsgUrl.startsWith("mqqapi://qsubscribe"))) {
              break;
            }
            try
            {
              paramView = new Intent(paramContext, JumpActivity.class);
              paramView.setData(Uri.parse(paramStructMsgForGeneralShare.mMsgUrl));
              paramView.putExtra("from", "from_aio");
              paramContext.startActivity(paramView);
            }
            catch (Throwable paramContext)
            {
              paramView = a;
              paramGeneralClickHandler = new StringBuilder();
              paramGeneralClickHandler.append("jump by msg.mMsgUrl error, url =  ");
              paramGeneralClickHandler.append(QLog.getStackTraceString(paramContext));
              QLog.e(paramView, 2, paramGeneralClickHandler.toString());
            }
          }
        }
        if ((TextUtils.isEmpty(paramView)) || (!paramView.startsWith("apollo:"))) {
          break;
        }
        paramView = paramStructMsgForGeneralShare.mMsgUrl.split("\\?");
      } while ((paramView.length != 2) || (!((IApolloManagerService)paramQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).isApolloSupport(paramContext)));
      paramView = paramView[1];
      paramGeneralClickHandler = new StringBuilder();
      paramGeneralClickHandler.append("mqqapi://cmshow/apollo_action?");
      paramGeneralClickHandler.append(paramView);
      paramContext.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(paramGeneralClickHandler.toString())));
      for (;;)
      {
        bool1 = true;
        paramContext = (Context)localObject4;
        paramView = (View)localObject5;
        break label2554;
        if (((ChatMessage)localObject1).istroop == 1)
        {
          bool1 = paramGeneralClickHandler.a(paramStructMsgForGeneralShare.mMsgUrl);
          paramContext = (Context)localObject4;
          paramView = (View)localObject5;
        }
        else if (paramStructMsgForGeneralShare.hasFlag(16))
        {
          paramView = paramStructMsgForGeneralShare.mMsgUrl;
          paramContext = paramView;
          if (paramView != null)
          {
            localObject6 = new StringBuilder();
            ((StringBuilder)localObject6).append(paramView);
            if (paramView.indexOf('?') != -1) {
              paramContext = "&";
            } else {
              paramContext = "?";
            }
            ((StringBuilder)localObject6).append(paramContext);
            ((StringBuilder)localObject6).append("f_hbType=");
            if (((ChatMessage)localObject1).istroop == 1) {
              i = 1;
            } else {
              i = 2;
            }
            ((StringBuilder)localObject6).append(i);
            ((StringBuilder)localObject6).append("&f_hbUin=");
            ((StringBuilder)localObject6).append(((ChatMessage)localObject1).frienduin);
            paramContext = ((StringBuilder)localObject6).toString();
          }
          if (QLog.isDevelopLevel()) {
            QLog.d("PortalManager", 4, paramContext);
          }
          bool1 = paramGeneralClickHandler.a(paramContext);
          paramContext = (Context)localObject4;
          paramView = (View)localObject5;
        }
        else
        {
          if ((paramStructMsgForGeneralShare.mMsgServiceID != 53) && (paramStructMsgForGeneralShare.mMsgServiceID != 54))
          {
            if ((paramStructMsgForGeneralShare.mMsgServiceID == 15) && ((!TextUtils.isEmpty(paramStructMsgForGeneralShare.mMsgActionData)) || (!TextUtils.isEmpty(paramStructMsgForGeneralShare.mMsg_I_ActionData))))
            {
              paramGeneralClickHandler = paramStructMsgForGeneralShare.mMsgActionData;
              paramView = paramGeneralClickHandler;
              if (TextUtils.isEmpty(paramGeneralClickHandler)) {
                paramView = paramStructMsgForGeneralShare.mMsg_I_ActionData;
              }
              if (TextUtils.isEmpty(paramView)) {
                break;
              }
              paramView = paramView.split(":");
              if ((paramView.length != 2) || (!"group".equals(paramView[0])) || (TextUtils.isEmpty(paramView[1]))) {
                break;
              }
              TroopUtils.a(paramContext, TroopInfoUIUtil.a(paramView[1], 14), 2);
              continue;
            }
            if (paramStructMsgForGeneralShare.uin.equals("3242766078")) {
              bool2 = handleNearbyPublicAccountMsg(paramQQAppInterface, paramContext, paramStructMsgForGeneralShare);
            } else {
              bool2 = false;
            }
            bool1 = bool2;
            paramContext = (Context)localObject4;
            paramView = (View)localObject5;
            if (bool2) {
              break label2554;
            }
            bool1 = paramGeneralClickHandler.a(paramStructMsgForGeneralShare.mMsgUrl);
            paramContext = (Context)localObject4;
            paramView = (View)localObject5;
            break label2554;
          }
          try
          {
            paramContext = new StringBuilder();
            paramContext.append("mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=cooperation.readinjoy.ReadInJoyProxyActivity&url=");
            paramContext.append(URLEncoder.encode(paramStructMsgForGeneralShare.mMsgUrl));
            paramContext.append("&from=");
            paramContext.append(paramStructMsgForGeneralShare.mMsgServiceID);
            if (!paramGeneralClickHandler.c(paramContext.toString(), null))
            {
              bool1 = paramGeneralClickHandler.a(paramStructMsgForGeneralShare.mMsgUrl);
              paramContext = (Context)localObject4;
              paramView = (View)localObject5;
            }
          }
          catch (Exception paramContext)
          {
            if (QLog.isColorLevel())
            {
              paramView = a;
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("ReadInJoyShareMsg click error, url =  ");
              ((StringBuilder)localObject1).append(paramStructMsgForGeneralShare.mMsgUrl);
              QLog.d(paramView, 2, ((StringBuilder)localObject1).toString());
            }
            paramContext.printStackTrace();
            bool1 = paramGeneralClickHandler.a(paramStructMsgForGeneralShare.mMsgUrl);
            paramView = (View)localObject5;
            paramContext = (Context)localObject4;
          }
        }
      }
      label2554:
      if (bool1) {
        i = 1;
      } else {
        i = 0;
      }
      if (paramStructMsgForGeneralShare.mMsgServiceID == 91) {
        ReportController.b(paramQQAppInterface, "dc00898", "", "", "0X8007758", "0X8007758", 0, 0, "", "", "", "");
      } else if (paramStructMsgForGeneralShare.mMsgServiceID == 97) {
        ReportController.b(paramQQAppInterface, "dc00898", "", "", "0X8007ADA", "0X8007ADA", 0, 0, "", "", "", "");
      }
      paramGeneralClickHandler = "";
      localObject1 = paramStructMsgForGeneralShare.uin;
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append(paramGeneralClickHandler);
      ((StringBuilder)localObject4).append(paramStructMsgForGeneralShare.msgId);
      ReportController.b(paramQQAppInterface, "P_CliOper", "Pb_account_lifeservice", (String)localObject1, "0X80055C7", "0X80055C7", 0, i, ((StringBuilder)localObject4).toString(), paramStructMsgForGeneralShare.templateIDForPortal, "", paramStructMsgForGeneralShare.mMsgUrl);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("MSGID=");
      ((StringBuilder)localObject1).append(Long.toString(paramStructMsgForGeneralShare.msgId));
      ((StringBuilder)localObject1).append(paramContext);
      ((StringBuilder)localObject1).append(paramStructMsgForGeneralShare.templateIDForPortal);
      ((StringBuilder)localObject1).append(paramView);
      ((StringBuilder)localObject1).append(paramGeneralClickHandler);
      ((StringBuilder)localObject1).append(";REFERRER=");
      ((StringBuilder)localObject1).append(AbsStructMsgElement.a(paramStructMsgForGeneralShare.mMsgUrl));
      ReportController.b(paramQQAppInterface, "P_CliOper", "Pb_account_lifeservice", paramStructMsgForGeneralShare.uin, "0X8005D49", "0X8005D49", 0, i, ((StringBuilder)localObject1).toString(), "", "", "");
      return;
    }
    if ("plugin".equals(paramStructMsgForGeneralShare.mMsgAction))
    {
      if (paramStructMsgForGeneralShare.mMsgServiceID == 14) {
        dealMsgBeforeClick(paramStructMsgForGeneralShare, (ChatMessage)localObject1);
      }
      if (paramQQAppInterface != null) {
        bool1 = paramGeneralClickHandler.c(paramStructMsgForGeneralShare.mMsgActionData, paramStructMsgForGeneralShare.mMsg_A_ActionData);
      } else {
        bool1 = false;
      }
      if (bool1) {
        i = 1;
      } else {
        i = 0;
      }
      paramContext = paramStructMsgForGeneralShare.uin;
      paramView = new StringBuilder();
      paramView.append("");
      paramView.append(paramStructMsgForGeneralShare.msgId);
      ReportController.b(paramQQAppInterface, "P_CliOper", "Pb_account_lifeservice", paramContext, "0X80055C7", "0X80055C7", 0, i, paramView.toString(), paramStructMsgForGeneralShare.templateIDForPortal, "", paramStructMsgForGeneralShare.mMsgUrl);
      paramContext = new StringBuilder();
      paramContext.append("MSGID=");
      paramContext.append(Long.toString(paramStructMsgForGeneralShare.msgId));
      paramContext.append(";TEPLATEID=");
      paramContext.append(paramStructMsgForGeneralShare.templateIDForPortal);
      paramContext.append(";ARTICALID=");
      paramContext.append("");
      paramContext.append(";REFERRER=");
      paramContext.append(AbsStructMsgElement.a(paramStructMsgForGeneralShare.mMsgUrl));
      ReportController.b(paramQQAppInterface, "P_CliOper", "Pb_account_lifeservice", paramStructMsgForGeneralShare.uin, "0X8005D49", "0X8005D49", 0, i, paramContext.toString(), "", "", "");
      return;
    }
    if ("viewMultiMsg".equals(paramStructMsgForGeneralShare.mMsgAction))
    {
      localObject1 = (BaseActivity)paramContext;
      if (((BaseActivity)localObject1).getChatFragment() != null)
      {
        i = ((BaseActivity)localObject1).getChatFragment().k().F();
        localObject4 = ((BaseActivity)localObject1).getChatFragment().k().ae();
        localObject5 = ((BaseActivity)localObject1).getChatFragment().k().ag();
        paramGeneralClickHandler = new Intent(paramContext, MultiForwardActivity.class);
        paramGeneralClickHandler.putExtra("chat_subType", 3);
        paramGeneralClickHandler.putExtra("uin", (String)localObject4);
        paramGeneralClickHandler.putExtra("uintype", i);
        paramGeneralClickHandler.putExtra("troop_code", (String)localObject5);
        paramGeneralClickHandler.putExtra("multi_url", paramStructMsgForGeneralShare.mResid);
        paramGeneralClickHandler.putExtra("multimsg_uniseq", paramStructMsgForGeneralShare.uniseq);
        paramGeneralClickHandler.putExtra("origin_merge_structing_msg_uniseq", a(paramStructMsgForGeneralShare, (BaseActivity)localObject1));
        paramView = (ViewGroup)paramView;
        while (paramView.getChildCount() > 0)
        {
          localObject1 = paramView.getChildAt(0);
          if (ViewGroup.class.isInstance(localObject1)) {
            paramView = (ViewGroup)localObject1;
          } else if (TextView.class.isInstance(localObject1)) {
            paramGeneralClickHandler.putExtra("multi_title", ((TextView)localObject1).getText().toString());
          }
        }
        paramContext.startActivity(paramGeneralClickHandler);
      }
      paramContext = "MSGID=";
      bool1 = true;
    }
    else
    {
      if ("viewFlower".equals(paramStructMsgForGeneralShare.mMsgAction)) {
        paramGeneralClickHandler.a(paramView, paramStructMsgForGeneralShare.uin);
      }
      for (;;)
      {
        break;
        if (!"shareBusinessCard".equals(paramStructMsgForGeneralShare.mMsgAction)) {
          break label3658;
        }
        if (paramStructMsgForGeneralShare.mMsg_A_ActionData != null)
        {
          paramView = paramStructMsgForGeneralShare.mMsg_A_ActionData.split(";");
          if ((paramView != null) && (paramView.length == 3))
          {
            localObject1 = paramView[0].substring(4);
            paramGeneralClickHandler = paramView[1].substring(5);
            paramView = paramView[2].substring(6);
            break label3445;
          }
        }
        localObject4 = "";
        paramView = (View)localObject4;
        localObject1 = paramView;
        paramGeneralClickHandler = paramView;
        paramView = (View)localObject4;
        label3445:
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject4 = (BusinessCardManager)paramQQAppInterface.getManager(QQManagerFactory.BUSINESS_CARD_MANAGER);
          if (localObject4 != null)
          {
            localObject5 = ((BusinessCardManager)localObject4).e((String)localObject1);
            localObject4 = new Intent(paramContext, BusinessCardEditActivity.class);
            ((Intent)localObject4).putExtra("source_activity", 2);
            if (localObject5 != null)
            {
              ((Intent)localObject4).putExtra("cur_card_id", ((BusinessCard)localObject5).cardId);
              if (((BusinessCard)localObject5).cardType == 1) {
                ((Intent)localObject4).putExtra("mode_type", 3);
              } else {
                ((Intent)localObject4).putExtra("mode_type", 0);
              }
              ((Intent)localObject4).putExtra("is_edit_mode", false);
            }
            else
            {
              localObject5 = new CardOCRInfo();
              ((CardOCRInfo)localObject5).b = ((String)localObject1);
              ((CardOCRInfo)localObject5).a = paramGeneralClickHandler;
              ((CardOCRInfo)localObject5).d.add(paramView);
              ((Intent)localObject4).putExtra("mode_type", 0);
              ((Intent)localObject4).putExtra("finish_immedia", true);
              ((Intent)localObject4).putExtra("is_edit_mode", false);
              ((Intent)localObject4).putExtra("cur_ocr_info", (Parcelable)localObject5);
            }
            paramContext.startActivity((Intent)localObject4);
          }
        }
      }
      paramContext = "MSGID=";
      bool1 = false;
      break label4323;
      label3658:
      if ("viewReceiptMessage".equals(paramStructMsgForGeneralShare.mMsgAction))
      {
        paramView = (BaseActivity)paramContext;
        if (paramView.getChatFragment() != null)
        {
          paramGeneralClickHandler = new Intent();
          paramGeneralClickHandler.putExtra("ReceiptMessageDetailFragment.extra_msg_uni_seq", ((ChatMessage)localObject1).uniseq);
          paramGeneralClickHandler.putExtra("ReceiptMessageDetailFragment.extra_res_id", paramStructMsgForGeneralShare.mResid);
          paramGeneralClickHandler.putExtra("ReceiptMessageDetailFragment.extra_msg_session_info", paramView.getChatFragment().k().ah);
          paramGeneralClickHandler.putExtra("ReceiptMessageDetailFragment.extra_shmsgseq", ((ChatMessage)localObject1).shmsgseq);
          paramGeneralClickHandler.putExtra("ReceiptMessageDetailFragment.extra_sender_uin", ((ChatMessage)localObject1).senderuin);
          paramGeneralClickHandler.putExtra("ReceiptMessageDetailFragment.extra_msg_seq", ((ChatMessage)localObject1).msgseq);
          paramGeneralClickHandler.putExtra("ReceiptMessageDetailFragment.extra_msg_uid", ((ChatMessage)localObject1).msgUid);
          paramGeneralClickHandler.putExtra("ReceiptMessageDetailFragment.extra_msg_time", ((ChatMessage)localObject1).time);
          paramGeneralClickHandler.putExtra("ReceiptMessageDetailFragment.EXTRA_SESSION_TYPE_FROM_MESSAGE", ((ChatMessage)localObject1).istroop);
          paramGeneralClickHandler.putExtra("ReceiptMessageDetailFragment.EXTRA_IS_READ", "1".equals(ReceiptMsgManager.a((MessageRecord)localObject1)));
          paramView.getChatFragment().k().bk();
          PublicFragmentActivity.a(paramContext, paramGeneralClickHandler, ReceiptMessageDetailFragment.class);
          i = paramView.getChatFragment().k().ah.a;
          if (i == 0) {
            i = 1;
          } else if (i == 3000) {
            i = 2;
          } else {
            i = 3;
          }
          if ((paramStructMsgForGeneralShare.getStructMsgItemLists() != null) && (paramStructMsgForGeneralShare.getStructMsgItemLists().size() > 0))
          {
            paramContext = (AbsStructMsgElement)paramStructMsgForGeneralShare.getStructMsgItemLists().get(0);
            if ((paramContext instanceof StructMsgItemLayout29))
            {
              paramView = ((StructMsgItemLayout29)paramContext).ax.iterator();
              paramContext = "";
              j = -1;
              while (paramView.hasNext())
              {
                paramGeneralClickHandler = (AbsStructMsgElement)paramView.next();
                if (("type".equals(paramGeneralClickHandler.b)) && ((paramGeneralClickHandler instanceof StructMsgItemType)))
                {
                  j = ((StructMsgItemType)paramGeneralClickHandler).au;
                  if (j != 1)
                  {
                    if (j != 2)
                    {
                      if (j == 3) {
                        paramContext = "ptt";
                      }
                    }
                    else {
                      paramContext = "pic";
                    }
                  }
                  else {
                    paramContext = "msg";
                  }
                }
              }
              break label4067;
            }
          }
          paramContext = "";
          j = -1;
          label4067:
          if (j > -1)
          {
            paramGeneralClickHandler = ((ChatMessage)localObject1).senderuin;
            if (((ChatMessage)localObject1).isSend()) {
              paramView = "1";
            } else {
              paramView = "2";
            }
            ReportController.b(paramQQAppInterface, "CliOper", "", paramGeneralClickHandler, "0x80083E9", "0x80083E9", i, 0, paramView, "", paramContext, "");
          }
        }
      }
      for (;;)
      {
        paramContext = "MSGID=";
        bool1 = true;
        break label4323;
        paramView = "MSGID=";
        if ((!"native".equals(paramStructMsgForGeneralShare.mMsgAction)) || (paramStructMsgForGeneralShare.mMsgServiceID != 128) || (paramStructMsgForGeneralShare.message == null) || (paramStructMsgForGeneralShare.mDatas == null)) {
          break;
        }
        paramGeneralClickHandler = paramStructMsgForGeneralShare.mDatas.optString("groupcode");
        localObject1 = paramStructMsgForGeneralShare.mDatas.optString("groupname");
        if (paramStructMsgForGeneralShare.message.isSend()) {
          paramView = paramStructMsgForGeneralShare.message.frienduin;
        } else {
          paramView = paramStructMsgForGeneralShare.message.selfuin;
        }
        TroopInviteStatusFragment.a(paramQQAppInterface, paramContext, paramGeneralClickHandler, (String)localObject1, paramView, Long.valueOf(paramStructMsgForGeneralShare.mDatas.optString("msgseq")).longValue(), paramStructMsgForGeneralShare.message.senderuin, ContactUtils.a(paramQQAppInterface, paramStructMsgForGeneralShare.message.senderuin, 0));
        TroopReportor.a("Grp_AIO", "invite", "send_clk", 0, 0, new String[0]);
      }
      bool1 = paramGeneralClickHandler.a(paramStructMsgForGeneralShare.mMsgAction, paramStructMsgForGeneralShare.mMsgUrl, paramStructMsgForGeneralShare.mMsgActionData, paramStructMsgForGeneralShare.mMsg_A_ActionData);
      paramContext = paramView;
    }
    label4323:
    int i = 1;
    if (!bool1) {
      i = 0;
    }
    paramView = paramStructMsgForGeneralShare.uin;
    paramGeneralClickHandler = new StringBuilder();
    paramGeneralClickHandler.append("");
    paramGeneralClickHandler.append(paramStructMsgForGeneralShare.msgId);
    ReportController.b(paramQQAppInterface, "P_CliOper", "Pb_account_lifeservice", paramView, "0X80055C7", "0X80055C7", 0, i, paramGeneralClickHandler.toString(), paramStructMsgForGeneralShare.templateIDForPortal, "", paramStructMsgForGeneralShare.mMsgUrl);
    paramView = new StringBuilder();
    paramView.append(paramContext);
    paramView.append(Long.toString(paramStructMsgForGeneralShare.msgId));
    paramView.append(";TEPLATEID=");
    paramView.append(paramStructMsgForGeneralShare.templateIDForPortal);
    paramView.append(";ARTICALID=");
    paramView.append("");
    paramView.append(";REFERRER=");
    paramView.append(AbsStructMsgElement.a(paramStructMsgForGeneralShare.mMsgUrl));
    ReportController.b(paramQQAppInterface, "P_CliOper", "Pb_account_lifeservice", paramStructMsgForGeneralShare.uin, "0X8005D49", "0X8005D49", 0, i, paramView.toString(), "", "", "");
    label4515:
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
    if (this == paramObject) {
      return true;
    }
    if (paramObject == null) {
      return false;
    }
    if (getClass() != paramObject.getClass()) {
      return false;
    }
    paramObject = (StructMsgForGeneralShare)paramObject;
    return getLayoutStr().equals(paramObject.getLayoutStr());
  }
  
  public View getAdSourceView(Context paramContext, View paramView)
  {
    if (!this.mHasAdSource) {
      return null;
    }
    View localView = paramView;
    if (paramView == null) {
      localView = ((IEcshopAdApi)QRoute.api(IEcshopAdApi.class)).getAdSourceViewWithName(paramContext, this.message, this.mAdSourceName, this.mAdSourceMenu);
    }
    return localView;
  }
  
  public String getLayoutStr()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    Iterator localIterator;
    if ((this.mMsgServiceID != 83) && (this.mMsgServiceID != 108) && (this.mMsgServiceID != 114) && (this.mMsgServiceID != 116) && (this.mMsgServiceID != 151) && (this.mMsgServiceID != 156))
    {
      if (this.mStructMsgItemLists != null) {
        localIterator = this.mStructMsgItemLists.iterator();
      }
    }
    else {
      while (localIterator.hasNext())
      {
        localStringBuffer.append(((AbsStructMsgElement)localIterator.next()).b());
        continue;
        localStringBuffer.append("StructMsgItemLayoutNew2");
      }
    }
    localStringBuffer.append(this.mFlag & 0x4);
    return localStringBuffer.toString();
  }
  
  public View.OnClickListener getOnClickListener()
  {
    return c;
  }
  
  public int getProgress()
  {
    AbsStructMsgElement localAbsStructMsgElement = findXmlNode("progress");
    if ((localAbsStructMsgElement != null) && ((localAbsStructMsgElement instanceof StructMsgItemProgress))) {
      return ((StructMsgItemProgress)localAbsStructMsgElement).c();
    }
    return -1;
  }
  
  public View getSourceView(Context paramContext, View paramView)
  {
    return super.getSourceView(paramContext, paramView);
  }
  
  @TargetApi(16)
  public View getView(Context paramContext, View paramView, OnLongClickAndTouchListener paramOnLongClickAndTouchListener, Bundle paramBundle)
  {
    Object localObject1 = paramView;
    if (paramView != null) {
      if (paramView.getTag(2131446473) == null)
      {
        localObject1 = paramView;
        if (paramView.getTag(2131443039) == null) {}
      }
      else
      {
        localObject1 = null;
      }
    }
    Object localObject2;
    Object localObject3;
    if (QLog.isColorLevel())
    {
      localObject2 = a;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("getView convertView=");
      ((StringBuilder)localObject3).append(localObject1);
      ((StringBuilder)localObject3).append(",mMsg_A_ActionData=");
      ((StringBuilder)localObject3).append(this.mMsg_A_ActionData);
      ((StringBuilder)localObject3).append(",tag=");
      if (localObject1 != null) {
        paramView = ((View)localObject1).getTag(2131446778);
      } else {
        paramView = null;
      }
      ((StringBuilder)localObject3).append(paramView);
      QLog.d((String)localObject2, 2, ((StringBuilder)localObject3).toString());
    }
    this.mContext = new WeakReference(paramContext);
    if (paramBundle == null) {
      localObject2 = new Bundle();
    } else {
      localObject2 = paramBundle;
    }
    ((Bundle)localObject2).putBoolean("hasHeadIcon", hasFlag(4));
    ((Bundle)localObject2).putInt("serviceID", this.mMsgServiceID);
    if (QLog.isColorLevel())
    {
      paramView = a;
      paramBundle = new StringBuilder();
      paramBundle.append("getView(): convertView=");
      paramBundle.append(localObject1);
      paramBundle.append(", args = ");
      paramBundle.append(((Bundle)localObject2).toString());
      QLog.d(paramView, 2, paramBundle.toString());
    }
    int i = ((Bundle)localObject2).getInt("longMsgHolderType", -1);
    if ((i != 1) && (i != 2) && (i != 3))
    {
      int k;
      if (((Bundle)localObject2).getInt("accostType") == AbsStructMsg.SOURCE_ACCOUNT_TYPE_PA) {
        k = 1;
      } else {
        k = 0;
      }
      if (this.mMsgException)
      {
        paramView = a;
        paramBundle = new StringBuilder();
        paramBundle.append("struct msg has version exception! uin : ");
        paramBundle.append(this.uin);
        paramBundle.append(" msgVersion : ");
        paramBundle.append(this.messageVersion);
        paramBundle.append(" version : ");
        paramBundle.append(this.mVersion);
        paramBundle.append(" msgUniseq");
        paramBundle.append(this.uniseq);
        QLog.d(paramView, 1, paramBundle.toString());
        paramContext = getVersionExceptionView(paramContext, (View)localObject1, paramOnLongClickAndTouchListener, (Bundle)localObject2);
        paramContext.setId(2131446476);
        paramContext.setTag(2131446476, this);
        return paramContext;
      }
      int j;
      int m;
      int n;
      if (localObject1 == null)
      {
        paramView = super.getView(paramContext, null, paramOnLongClickAndTouchListener, (Bundle)localObject2);
        if (paramView == null) {
          return null;
        }
        if ((paramView instanceof ViewGroup)) {
          paramBundle = (ViewGroup)paramView;
        } else {
          paramBundle = null;
        }
        if (paramBundle == null) {
          return null;
        }
        if (this.mStructMsgItemLists != null) {
          j = getItemCount();
        } else {
          j = 0;
        }
        if (j > 0)
        {
          m = 0;
          for (i = 1; m < j; i = n)
          {
            localObject3 = getItemByIndex(m);
            ((AbsStructMsgElement)localObject3).ar = new WeakReference(paramOnLongClickAndTouchListener);
            symbol2CharactorForSmallEmoji((AbsStructMsgElement)localObject3);
            if ((this.uin != null) && (!this.uin.equalsIgnoreCase(((AbsStructMsgElement)localObject3).ap))) {
              ((AbsStructMsgElement)localObject3).ap = this.uin;
            }
            if (((AbsStructMsgElement)localObject3).a() == 0)
            {
              if (m == 0) {
                ((AbsStructMsgElement)localObject3).b(1);
              }
              if (m == j - 1) {
                ((AbsStructMsgElement)localObject3).b(2);
              }
            }
            if ((localObject3 instanceof StructMsgItemLayout8))
            {
              paramView = ((AbsStructMsgElement)localObject3).a(paramContext, null, (Bundle)localObject2);
              n = i;
            }
            else if ((localObject3 instanceof StructMsgItemLayout9))
            {
              paramView = ((AbsStructMsgElement)localObject3).a(paramContext, null, (Bundle)localObject2);
              n = i;
            }
            else
            {
              if ((localObject3 instanceof StructMsgItemLayout12)) {
                paramView = ((AbsStructMsgElement)localObject3).a(paramContext, null, (Bundle)localObject2);
              }
              for (;;)
              {
                n = 0;
                break label1349;
                if ((localObject3 instanceof StructMsgItemLayout5))
                {
                  if (m + 1 < j)
                  {
                    ((StructMsgItemLayout5)localObject3).az = true;
                    this.isMultiVideoItem = true;
                  }
                  else
                  {
                    ((StructMsgItemLayout5)localObject3).az = false;
                    this.isMultiVideoItem = false;
                  }
                  if (k != 0) {
                    paramView = new StructMsgItemLayout5Adapter((AbsStructMsgItem)localObject3, paramContext, m).a(paramContext, null, (Bundle)localObject2);
                  } else {
                    paramView = ((AbsStructMsgElement)localObject3).a(paramContext, null, (Bundle)localObject2);
                  }
                }
                else if ((localObject3 instanceof StructMsgItemLayout6))
                {
                  if (k != 0) {
                    paramView = new StructMsgItemLayout6Adapter((AbsStructMsgItem)localObject3, paramContext, m).a(paramContext, null, (Bundle)localObject2);
                  } else {
                    paramView = ((AbsStructMsgElement)localObject3).a(paramContext, null, (Bundle)localObject2);
                  }
                }
                else
                {
                  if (!(localObject3 instanceof StructMsgItemLayout4)) {
                    break label887;
                  }
                  localObject1 = ((AbsStructMsgElement)localObject3).a(paramContext, null, (Bundle)localObject2);
                  paramView = (View)localObject1;
                  if (k != 0)
                  {
                    a(paramContext, m, (View)localObject1);
                    paramView = (View)localObject1;
                  }
                }
                n = i;
                break label1349;
                label887:
                if ((localObject3 instanceof StructMsgItemLayout18)) {}
                for (paramView = ((AbsStructMsgElement)localObject3).a(paramContext, null, (Bundle)localObject2);; paramView = ((AbsStructMsgElement)localObject3).a(paramContext, null, (Bundle)localObject2))
                {
                  break;
                  if (!(localObject3 instanceof StructMsgItemLayout19)) {
                    break label929;
                  }
                }
                label929:
                if ((!(localObject3 instanceof StructMsgItemLayout2)) || ((this.mMsgServiceID == 83) || (this.mMsgServiceID == 108) || (this.mMsgServiceID == 114) || (this.mMsgServiceID == 116) || (this.mMsgServiceID == 151) || (this.mMsgServiceID == 156) || ((this.mDatas == null) || ((this.message != null) && (!TextUtils.isEmpty(this.message.senderuin)))))) {}
                try
                {
                  this.mDatas.put("senderuin", this.message.senderuin);
                  localObject1 = this.mDatas;
                  if (this.message.isSend()) {
                    paramView = this.message.frienduin;
                  } else {
                    paramView = this.message.selfuin;
                  }
                  ((JSONObject)localObject1).put("invitedUin", paramView);
                }
                catch (JSONException paramView)
                {
                  label1086:
                  Object localObject4;
                  break label1086;
                }
                ((Bundle)localObject2).putString("extend-data-json", this.mDatas.toString());
                localObject1 = ((AbsStructMsgElement)localObject3).a(paramContext, null, (Bundle)localObject2);
                paramView = (View)localObject1;
                n = i;
                if (localObject1 == null) {
                  break label1349;
                }
                ((View)localObject1).setTag(b, localObject3);
                paramView = (View)localObject1;
                n = i;
                break label1349;
                paramView = new StructMsgItemLayoutNew2();
                paramView.as = this;
                paramView.ar = new WeakReference(paramOnLongClickAndTouchListener);
                paramView = paramView.a(paramContext, null, (Bundle)localObject2);
                continue;
                if ((localObject3 instanceof StructMsgItemLayout20))
                {
                  paramView = ((AbsStructMsgElement)localObject3).a(paramContext, null, (Bundle)localObject2);
                  n = i;
                  break label1349;
                }
                if ((localObject3 instanceof StructMsgItemLayout26))
                {
                  ((Bundle)localObject2).putString("extraData", this.mExtraData);
                  paramView = ((AbsStructMsgElement)localObject3).a(paramContext, null, (Bundle)localObject2);
                }
                else if ((localObject3 instanceof StructMsgItemLayout27))
                {
                  paramView = ((AbsStructMsgElement)localObject3).a(paramContext, null, (Bundle)localObject2);
                }
                else if ((localObject3 instanceof StructMsgItemLayout28))
                {
                  paramView = ((AbsStructMsgElement)localObject3).a(paramContext, null, (Bundle)localObject2);
                }
                else if ((localObject3 instanceof StructMsgItemLayout29))
                {
                  ((AbsStructMsgElement)localObject3).as = this;
                  paramView = ((AbsStructMsgElement)localObject3).a(paramContext, null, (Bundle)localObject2);
                }
                else
                {
                  if (!(localObject3 instanceof StructMsgItemLayoutMicro)) {
                    break;
                  }
                  ((AbsStructMsgElement)localObject3).as = this;
                  paramView = ((AbsStructMsgElement)localObject3).a(paramContext, null, (Bundle)localObject2);
                }
              }
              paramView = ((AbsStructMsgElement)localObject3).a(paramContext, null, (Bundle)localObject2);
              n = i;
            }
            label1349:
            i = m + 2;
            if ((i < j) && (paramView != null))
            {
              localObject1 = getItemByIndex(i);
              if ((((AbsStructMsgItem)localObject1).ax.size() != 0) && (paramView != null))
              {
                if ((localObject1 instanceof StructMsgItemLayoutDefault)) {
                  if ((((StructMsgItemLayoutDefault)localObject1).ax.get(0) instanceof StructMsgItemMore)) {
                    break label1447;
                  }
                }
                if (((localObject1 instanceof StructMsgItemLayout3)) && ((((StructMsgItemLayout3)localObject1).ax.get(0) instanceof StructMsgItemButton)))
                {
                  label1447:
                  localObject1 = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
                  if (localObject1 != null)
                  {
                    if ((localObject3 instanceof StructMsgItemLayoutDefault))
                    {
                      if (k != 0) {
                        ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin = AIOUtils.b(11.0F, paramContext.getResources());
                      } else {
                        ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin = AIOUtils.b(16.0F, paramContext.getResources());
                      }
                    }
                    else if (((localObject3 instanceof StructMsgItemLayout6)) && (!StructMsgItemLayout6Adapter.a((AbsStructMsgItem)localObject3, m))) {
                      ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin = AIOUtils.b(7.5F, paramContext.getResources());
                    }
                    paramView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
                  }
                }
              }
            }
            m += 1;
            if ((m < j) && (paramView != null) && (k != 0))
            {
              localObject1 = (AbsStructMsgItem)localObject3;
              if ((((AbsStructMsgItem)localObject1).ax.size() == 1) && ((((AbsStructMsgItem)localObject1).ax.get(0) instanceof StructMsgItemHr)))
              {
                localObject1 = getItemByIndex(m);
                if ((((AbsStructMsgItem)localObject1).ax.size() != 0) && ((localObject1 instanceof StructMsgItemLayout3)) && ((((StructMsgItemLayout3)localObject1).ax.get(0) instanceof StructMsgItemButton)))
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
            }
            if (paramView != null)
            {
              if ((!TextUtils.isEmpty(((AbsStructMsgElement)localObject3).e)) || ((localObject3 instanceof StructMsgItemLayout28)))
              {
                paramView.setTag(localObject3);
                paramView.setClickable(true);
                paramView.setOnClickListener((View.OnClickListener)localObject3);
                paramView.setOnLongClickListener(new StructMsgForGeneralShare.1(this, paramOnLongClickAndTouchListener));
                paramView.setOnTouchListener(new StructMsgForGeneralShare.2(this, paramOnLongClickAndTouchListener));
                clickedItemIndex = 0;
              }
              if (paramView.getParent() != null)
              {
                ((ViewGroup)paramView.getParent()).removeView(paramView);
                if (QLog.isColorLevel())
                {
                  localObject1 = a;
                  localObject4 = new StringBuilder();
                  ((StringBuilder)localObject4).append("getView itemView.getParent != null .itemName = .");
                  ((StringBuilder)localObject4).append(localObject3.getClass().getName());
                  QLog.e((String)localObject1, 2, ((StringBuilder)localObject4).toString());
                }
              }
              paramBundle.addView(paramView);
            }
            else if (QLog.isDevelopLevel())
            {
              QLog.e(a, 4, "Create item view failure by #StructMsgItemViewFactory");
            }
          }
        }
        else
        {
          i = 1;
        }
        if (((k != 0) && (hasFlag(4))) || (this.mMsgServiceID == 91))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.subscript", 2, "StructMsgForGeneralShare use subscript structmsg bg");
          }
          paramBundle.setBackgroundResource(2130838318);
        }
        a(paramBundle, paramContext.getResources(), (Bundle)localObject2);
      }
      else
      {
        n = getItemCount();
        if (n > 0)
        {
          paramBundle = (ViewGroup)localObject1;
          m = 0;
          for (i = 1; m < n; i = j)
          {
            localObject4 = getItemByIndex(m);
            ((AbsStructMsgElement)localObject4).ar = new WeakReference(paramOnLongClickAndTouchListener);
            if ((this.uin != null) && (!this.uin.equalsIgnoreCase(((AbsStructMsgElement)localObject4).ap))) {
              ((AbsStructMsgElement)localObject4).ap = this.uin;
            }
            if (((AbsStructMsgElement)localObject4).a() == 0)
            {
              if (m == 0) {
                ((AbsStructMsgElement)localObject4).b(1);
              }
              if (m == n - 1) {
                ((AbsStructMsgElement)localObject4).b(2);
              }
            }
            localObject3 = paramBundle.getChildAt(m);
            if ((localObject4 instanceof StructMsgItemLayout8)) {}
            for (paramView = ((AbsStructMsgElement)localObject4).a(paramContext, (View)localObject3, (Bundle)localObject2);; paramView = ((AbsStructMsgElement)localObject4).a(paramContext, (View)localObject3, (Bundle)localObject2))
            {
              j = i;
              break label2828;
              if (!(localObject4 instanceof StructMsgItemLayout9)) {
                break;
              }
            }
            if ((localObject4 instanceof StructMsgItemLayout12)) {
              paramView = ((AbsStructMsgElement)localObject4).a(paramContext, (View)localObject3, (Bundle)localObject2);
            }
            for (;;)
            {
              j = 0;
              break label2828;
              if ((localObject4 instanceof StructMsgItemLayout5))
              {
                if (m + 1 < n)
                {
                  ((StructMsgItemLayout5)localObject4).az = true;
                  this.isMultiVideoItem = true;
                }
                else
                {
                  ((StructMsgItemLayout5)localObject4).az = false;
                  this.isMultiVideoItem = false;
                }
                if (k != 0)
                {
                  paramView = new StructMsgItemLayout5Adapter((AbsStructMsgItem)localObject4, paramContext, m).a(paramContext, (View)localObject3, (Bundle)localObject2);
                  j = i;
                  break label2828;
                }
                paramView = ((AbsStructMsgElement)localObject4).a(paramContext, (View)localObject3, (Bundle)localObject2);
                j = i;
                break label2828;
              }
              if ((localObject4 instanceof StructMsgItemLayout6))
              {
                if (k != 0)
                {
                  paramView = new StructMsgItemLayout6Adapter((AbsStructMsgItem)localObject4, paramContext, m).a(paramContext, (View)localObject3, (Bundle)localObject2);
                  j = i;
                  break label2828;
                }
                paramView = ((AbsStructMsgElement)localObject4).a(paramContext, (View)localObject3, (Bundle)localObject2);
                j = i;
                break label2828;
              }
              if ((localObject4 instanceof StructMsgItemLayout4))
              {
                localObject3 = ((AbsStructMsgElement)localObject4).a(paramContext, (View)localObject3, (Bundle)localObject2);
                j = i;
                paramView = (View)localObject3;
                if (k == 0) {
                  break label2828;
                }
                a(paramContext, m, (View)localObject3);
                j = i;
                paramView = (View)localObject3;
                break label2828;
              }
              if ((localObject4 instanceof StructMsgItemLayout18)) {
                paramView = ((AbsStructMsgElement)localObject4).a(paramContext, (View)localObject3, (Bundle)localObject2);
              } else if ((localObject4 instanceof StructMsgItemLayout19)) {
                paramView = ((AbsStructMsgElement)localObject4).a(paramContext, (View)localObject3, (Bundle)localObject2);
              } else if (((localObject4 instanceof StructMsgItemLayout2)) && ((this.mMsgServiceID != 83) && (this.mMsgServiceID != 108) && (this.mMsgServiceID != 114) && (this.mMsgServiceID != 116) && (this.mMsgServiceID != 151) && (this.mMsgServiceID != 156) && ((this.mDatas != null) && ((this.message == null) || (TextUtils.isEmpty(this.message.senderuin)))))) {}
              try
              {
                paramView = this.mDatas;
              }
              catch (JSONException paramView)
              {
                JSONObject localJSONObject;
                label2574:
                break label2574;
              }
              try
              {
                paramView.put("senderuin", this.message.senderuin);
                localJSONObject = this.mDatas;
                if (this.message.isSend()) {
                  paramView = this.message.frienduin;
                } else {
                  paramView = this.message.selfuin;
                }
                localJSONObject.put("invitedUin", paramView);
              }
              catch (JSONException paramView)
              {
                break label2574;
              }
              ((Bundle)localObject2).putString("extend-data-json", this.mDatas.toString());
              localObject3 = ((AbsStructMsgElement)localObject4).a(paramContext, (View)localObject3, (Bundle)localObject2);
              paramView = (View)localObject3;
              if (localObject3 == null) {
                break;
              }
              ((View)localObject3).setTag(b, localObject4);
              paramView = (View)localObject3;
              break;
              paramView = new StructMsgItemLayoutNew2();
              paramView.as = this;
              paramView.ar = new WeakReference(paramOnLongClickAndTouchListener);
              paramView = paramView.a(paramContext, (View)localObject3, (Bundle)localObject2);
            }
            if ((localObject4 instanceof StructMsgItemLayout20)) {}
            for (paramView = ((AbsStructMsgElement)localObject4).a(paramContext, (View)localObject3, (Bundle)localObject2);; paramView = ((AbsStructMsgElement)localObject4).a(paramContext, (View)localObject3, (Bundle)localObject2))
            {
              j = i;
              break label2828;
              if ((localObject4 instanceof StructMsgItemLayout26))
              {
                paramView = ((AbsStructMsgElement)localObject4).a(paramContext, (View)localObject3, (Bundle)localObject2);
                break;
              }
              if ((localObject4 instanceof StructMsgItemLayout27))
              {
                paramView = ((AbsStructMsgElement)localObject4).a(paramContext, (View)localObject3, (Bundle)localObject2);
                break;
              }
              if ((localObject4 instanceof StructMsgItemLayout28))
              {
                paramView = ((AbsStructMsgElement)localObject4).a(paramContext, (View)localObject3, (Bundle)localObject2);
                break;
              }
              if ((localObject4 instanceof StructMsgItemLayout29))
              {
                ((AbsStructMsgElement)localObject4).as = this;
                paramView = ((AbsStructMsgElement)localObject4).a(paramContext, (View)localObject3, (Bundle)localObject2);
                break;
              }
              if ((localObject4 instanceof StructMsgItemLayoutMicro))
              {
                ((AbsStructMsgElement)localObject4).as = this;
                paramView = ((AbsStructMsgElement)localObject4).a(paramContext, (View)localObject3, (Bundle)localObject2);
                break;
              }
            }
            label2828:
            i = m + 2;
            if (i < n)
            {
              localObject3 = getItemByIndex(i);
              if ((((AbsStructMsgItem)localObject3).ax.size() != 0) && (paramView != null))
              {
                if ((localObject3 instanceof StructMsgItemLayoutDefault)) {
                  if ((((StructMsgItemLayoutDefault)localObject3).ax.get(0) instanceof StructMsgItemMore)) {
                    break label2922;
                  }
                }
                if (((localObject3 instanceof StructMsgItemLayout3)) && ((((StructMsgItemLayout3)localObject3).ax.get(0) instanceof StructMsgItemButton)))
                {
                  label2922:
                  localObject3 = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
                  if (localObject3 != null)
                  {
                    if ((localObject4 instanceof StructMsgItemLayoutDefault))
                    {
                      if (k != 0) {
                        ((ViewGroup.MarginLayoutParams)localObject3).bottomMargin = AIOUtils.b(11.0F, paramContext.getResources());
                      } else {
                        ((ViewGroup.MarginLayoutParams)localObject3).bottomMargin = AIOUtils.b(16.0F, paramContext.getResources());
                      }
                    }
                    else if (((localObject4 instanceof StructMsgItemLayout6)) && (!StructMsgItemLayout6Adapter.a((AbsStructMsgItem)localObject4, m))) {
                      ((ViewGroup.MarginLayoutParams)localObject3).bottomMargin = AIOUtils.b(7.5F, paramContext.getResources());
                    }
                    paramView.setLayoutParams((ViewGroup.LayoutParams)localObject3);
                  }
                }
              }
            }
            m += 1;
            if ((m < n) && (paramView != null))
            {
              localObject3 = (AbsStructMsgItem)localObject4;
              if ((((AbsStructMsgItem)localObject3).ax.size() == 1) && ((((AbsStructMsgItem)localObject3).ax.get(0) instanceof StructMsgItemHr)))
              {
                localObject3 = getItemByIndex(m);
                if ((((AbsStructMsgItem)localObject3).ax.size() != 0) && ((localObject3 instanceof StructMsgItemLayout3)) && ((((StructMsgItemLayout3)localObject3).ax.get(0) instanceof StructMsgItemButton))) {
                  paramView.setPadding(2, paramView.getPaddingTop(), 2, paramView.getPaddingBottom());
                }
              }
            }
            if (paramView != null)
            {
              if ((!TextUtils.isEmpty(((AbsStructMsgElement)localObject4).e)) || ((localObject4 instanceof StructMsgItemLayout28)))
              {
                paramView.setTag(localObject4);
                paramView.setClickable(true);
                paramView.setOnClickListener((View.OnClickListener)localObject4);
                paramView.setOnLongClickListener(new StructMsgForGeneralShare.3(this, paramOnLongClickAndTouchListener));
                paramView.setOnTouchListener(new StructMsgForGeneralShare.4(this, paramOnLongClickAndTouchListener));
                clickedItemIndex = 0;
              }
            }
            else if (QLog.isDevelopLevel()) {
              QLog.e(a, 4, "Create item view failure by #StructMsgItemViewFactory");
            }
          }
        }
        else
        {
          i = 1;
        }
        if ((k != 0) && (hasFlag(4)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.subscript", 2, "StructMsgForGeneralShare use subscript structmsg bg");
          }
          ((View)localObject1).setBackgroundResource(2130838318);
        }
        a((View)localObject1, paramContext.getResources(), (Bundle)localObject2);
        paramBundle = (Bundle)localObject1;
      }
      if ((localObject2 != null) && (((Bundle)localObject2).getBoolean("v_crap_ctn", false))) {
        paramBundle.getLayoutParams().width = -2;
      }
      if ((localObject2 != null) && (((Bundle)localObject2).getBoolean("is_public_account_video_msg", false)))
      {
        this.mIsPAVideoStructMsg = true;
        if (!this.isMultiVideoItem) {
          paramBundle.setBackgroundDrawable(null);
        }
        if (!hasFlag(4)) {
          paramBundle.getLayoutParams().width = -2;
        }
      }
      paramBundle.setId(2131446476);
      paramBundle.setTag(2131446476, this);
      if (i == 0) {
        paramBundle.setBackgroundDrawable(null);
      }
      return paramBundle;
    }
    paramContext = StructMsgItemLongMsgHolder.a(paramContext, (View)localObject1, paramOnLongClickAndTouchListener, (Bundle)localObject2);
    paramContext.setId(2131446476);
    paramContext.setTag(2131446476, this);
    if ((!((Bundle)localObject2).getBoolean("isSubscript", false)) && (hasFlag(4)))
    {
      paramContext.setBackgroundResource(2130838312);
      return paramContext;
    }
    paramContext.setBackgroundDrawable(null);
    return paramContext;
  }
  
  public void initPay(Context paramContext, MessageRecord paramMessageRecord)
  {
    this.havaPayInfoInit = true;
    if (paramContext != null)
    {
      if (this.mStructMsgItemLists == null) {
        return;
      }
      paramContext = this.mStructMsgItemLists.iterator();
      while (paramContext.hasNext())
      {
        Object localObject1 = (AbsStructMsgElement)paramContext.next();
        if ((localObject1 instanceof StructMsgItemLayout3))
        {
          localObject1 = (StructMsgItemLayout3)localObject1;
          if (((StructMsgItemLayout3)localObject1).ax != null)
          {
            localObject1 = ((StructMsgItemLayout3)localObject1).ax.iterator();
            while (((Iterator)localObject1).hasNext())
            {
              Object localObject2 = (AbsStructMsgElement)((Iterator)localObject1).next();
              if ((localObject2 instanceof StructMsgItemButton))
              {
                localObject2 = (StructMsgItemButton)localObject2;
                if (((StructMsgItemButton)localObject2).r())
                {
                  StringBuilder localStringBuilder = new StringBuilder();
                  localStringBuilder.append("order_pay_state_");
                  localStringBuilder.append(((StructMsgItemButton)localObject2).aN);
                  ((StructMsgItemButton)localObject2).a(paramMessageRecord.getExtInfoFromExtStr(localStringBuilder.toString()), paramMessageRecord, this);
                }
              }
            }
          }
        }
      }
    }
  }
  
  public boolean isPayMessage()
  {
    if (this.mStructMsgItemLists != null)
    {
      AbsStructMsgElement localAbsStructMsgElement;
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
            localObject = (AbsStructMsgElement)localIterator.next();
          } while (!(localObject instanceof StructMsgItemLayout3));
          localObject = ((StructMsgItemLayout3)localObject).ax.iterator();
        }
        localAbsStructMsgElement = (AbsStructMsgElement)((Iterator)localObject).next();
      } while ((!(localAbsStructMsgElement instanceof StructMsgItemButton)) || (!((StructMsgItemButton)localAbsStructMsgElement).r()));
      return true;
    }
    return false;
  }
  
  protected boolean parseContentNode(StructMsgNode paramStructMsgNode)
  {
    if (paramStructMsgNode == null) {
      return true;
    }
    if ("item".equals(paramStructMsgNode.b)) {
      localObject = paramStructMsgNode.a("layout");
    }
    try
    {
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        i = Integer.parseInt((String)localObject);
      } else {
        i = 0;
      }
    }
    catch (NumberFormatException paramStructMsgNode)
    {
      int i;
      int k;
      int j;
      label82:
      label85:
      break label85;
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
      localObject = StructMsgElementFactory.a(j);
    }
    catch (NumberFormatException paramStructMsgNode)
    {
      break label82;
    }
    break label87;
    i = 0;
    label87:
    if (QLog.isDevelopLevel())
    {
      paramStructMsgNode = a;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Item layout value is ");
      ((StringBuilder)localObject).append(i);
      QLog.d(paramStructMsgNode, 4, ((StringBuilder)localObject).toString());
    }
    return false;
    Object localObject = StructMsgElementFactory.a(paramStructMsgNode.b);
    if (localObject == null) {
      return true;
    }
    ((AbsStructMsgElement)localObject).as = this;
    if (((AbsStructMsgElement)localObject).a(paramStructMsgNode))
    {
      addItem((AbsStructMsgElement)localObject);
      return true;
    }
    return false;
  }
  
  protected void parseMsgAttrubutes(StructMsgNode paramStructMsgNode)
  {
    super.parseMsgAttrubutes(paramStructMsgNode);
  }
  
  public void readExternal(ObjectInput paramObjectInput)
  {
    int i1;
    int k;
    int i;
    int j;
    try
    {
      i1 = paramObjectInput.readInt();
      Object localObject2;
      if (QLog.isColorLevel())
      {
        localObject1 = a;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("version: ");
        ((StringBuilder)localObject2).append(i1);
        QLog.i((String)localObject1, 2, ((StringBuilder)localObject2).toString());
      }
      this.mVersion = i1;
      if (i1 == 1)
      {
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
        localObject1 = StructMsgElementFactory.a(this.mContentLayout);
        ((AbsStructMsgItem)localObject1).a(new StructMsgItemCover(this.mContentCover));
        ((AbsStructMsgItem)localObject1).a(new StructMsgItemTitle(this.mContentTitle));
        ((AbsStructMsgItem)localObject1).a(new StructMsgItemSummary(this.mContentSummary));
        addItem((AbsStructMsgElement)localObject1);
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
      else if (i1 >= 2)
      {
        this.mMsgTemplateID = paramObjectInput.readInt();
        this.mMsgAction = paramObjectInput.readUTF();
        this.mMsgActionData = paramObjectInput.readUTF();
        this.mMsg_A_ActionData = paramObjectInput.readUTF();
        this.mMsg_I_ActionData = paramObjectInput.readUTF();
        this.mMsgUrl = paramObjectInput.readUTF();
        this.mMsgBrief = paramObjectInput.readUTF();
        int i2 = paramObjectInput.readInt();
        int m = 0;
        k = 0;
        i = 1;
        if (k < i2)
        {
          localObject1 = paramObjectInput.readUTF();
          if ("item".equals(localObject1))
          {
            int n = paramObjectInput.readInt();
            if ((n == 2) && ("micro_app".equals(this.mMsg_A_ActionData)))
            {
              localObject1 = new StructMsgItemLayoutMicro();
            }
            else
            {
              j = n;
              if (n == 1)
              {
                j = n;
                if ("viewMultiMsg".equalsIgnoreCase(this.mMsgAction)) {
                  j = 30;
                }
              }
              localObject1 = StructMsgElementFactory.a(j);
            }
          }
          else
          {
            localObject2 = StructMsgElementFactory.a((String)localObject1);
            localObject1 = localObject2;
            if (localObject2 != null)
            {
              localObject1 = localObject2;
              if (AbsStructMsgItem.class.isInstance(localObject2))
              {
                paramObjectInput.readInt();
                localObject1 = localObject2;
              }
            }
          }
          j = i;
          if (localObject1 == null) {
            break label1755;
          }
          ((AbsStructMsgElement)localObject1).ap = this.uin;
          ((AbsStructMsgElement)localObject1).as = this;
          ((AbsStructMsgElement)localObject1).a(paramObjectInput);
          localObject2 = (AbsStructMsgItem)localObject1;
          if (((AbsStructMsgItem)localObject2).ax.size() == 1)
          {
            j = i;
            if (((AbsStructMsgElement)((AbsStructMsgItem)localObject2).ax.get(0)).b.equals("hr")) {}
          }
          else
          {
            ((AbsStructMsgElement)localObject1).an = String.valueOf(i);
            j = i + 1;
          }
          addItem((AbsStructMsgElement)localObject1);
          ((AbsStructMsgElement)localObject1).a(this);
          break label1755;
        }
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
        if (i1 < 3) {
          break label1617;
        }
        this.mCompatibleText = paramObjectInput.readUTF();
        this.msgId = paramObjectInput.readLong();
        this.mPromotionType = paramObjectInput.readInt();
        this.mPromotionMsg = paramObjectInput.readUTF();
        this.mPromotionMenus = paramObjectInput.readUTF();
        this.mPromotionMenuDestructiveIndex = paramObjectInput.readInt();
        i = m;
        while (i < this.mStructMsgItemLists.size())
        {
          localObject1 = (AbsStructMsgElement)this.mStructMsgItemLists.get(i);
          ((AbsStructMsgElement)localObject1).ao = this.msgId;
          ((AbsStructMsgElement)localObject1).aq = this.mPromotionType;
          i += 1;
        }
        label934:
        this.dynamicMsgMergeKey = paramObjectInput.readUTF();
        this.dynamicMsgMergeIndex = paramObjectInput.readInt();
        if (i1 < 5) {
          break label1617;
        }
        this.source_puin = paramObjectInput.readUTF();
        if (i1 < 6) {
          break label1617;
        }
        this.mSType = paramObjectInput.readUTF();
        if (i1 < 7) {
          break label1617;
        }
        this.adverSign = paramObjectInput.readInt();
        this.adverKey = paramObjectInput.readUTF();
        this.index = paramObjectInput.readUTF();
        this.index_name = paramObjectInput.readUTF();
        this.index_type = paramObjectInput.readUTF();
        this.rijAlbumActionData = paramObjectInput.readUTF();
        if (i1 < 8) {
          break label1617;
        }
        this.mArticleIds = paramObjectInput.readUTF();
        this.mOrangeWord = paramObjectInput.readUTF();
        this.mAlgorithmIds = paramObjectInput.readUTF();
        this.mStrategyIds = paramObjectInput.readUTF();
        if (i1 < 9) {
          break label1617;
        }
        this.mExtraData = paramObjectInput.readUTF();
        this.mCreateTime = paramObjectInput.readUTF();
        this.mTagName = paramObjectInput.readUTF();
        if (i1 < 10) {
          break label1617;
        }
        eventId = paramObjectInput.readUTF();
        remindBrief = paramObjectInput.readUTF();
        eventType = paramObjectInput.readUTF();
        if (i1 < 11) {
          break label1617;
        }
        tips = paramObjectInput.readUTF();
        if (i1 < 12) {
          break label1617;
        }
        this.mInnerUniqIds = paramObjectInput.readUTF();
        if (i1 < 13) {
          break label1617;
        }
        this.mSourceThirdName = paramObjectInput.readUTF();
        this.mQQStoryExtra = paramObjectInput.readUTF();
        this.mNeedRound = paramObjectInput.readUTF();
        if (i1 < 14) {
          break label1617;
        }
        this.mQidianBulkTaskId = paramObjectInput.readUTF();
        this.reportEventFolderStatusValue = paramObjectInput.readUTF();
        if (i1 < 15) {
          break label1617;
        }
        this.forwardType = paramObjectInput.readInt();
        this.shareData.readExternal(paramObjectInput);
        if (i1 >= 16) {
          break label1775;
        }
        break label1617;
        label1337:
        this.mAdSourceName = paramObjectInput.readUTF();
        this.mCommonData = paramObjectInput.readUTF();
        if (i1 < 18) {
          break label1617;
        }
        this.animResId = paramObjectInput.readUTF();
        this.atMembers = paramObjectInput.readUTF();
        if (i1 < 19) {
          break label1617;
        }
        this.mMergeSeq = paramObjectInput.readUTF();
        this.mSortKey = paramObjectInput.readLong();
        if (i1 < 21) {
          break label1617;
        }
        this.mTribeShortVideoExtra = paramObjectInput.readUTF();
        if (i1 < 22) {
          break label1617;
        }
        this.needSendLongMsgWhenFailed = paramObjectInput.readBoolean();
        if (i1 < 23) {
          break label1617;
        }
        this.mTSum = paramObjectInput.readInt();
        if (i1 < 24) {
          break label1617;
        }
        localObject1 = paramObjectInput.readUTF();
        boolean bool = TextUtils.isEmpty((CharSequence)localObject1);
        if (bool) {}
      }
    }
    catch (IOException paramObjectInput)
    {
      Object localObject1;
      label1523:
      if ((paramObjectInput.getMessage() != null) && (paramObjectInput.getMessage().equals("structmsg_version_error"))) {
        this.mMsgException = true;
      }
    }
    try
    {
      this.mDatas = new JSONObject((String)localObject1);
    }
    catch (JSONException localJSONException)
    {
      break label1523;
    }
    this.mDatas = null;
    break label1785;
    this.mDatas = null;
    break label1785;
    label1539:
    this.mAdSourceMenu = paramObjectInput.readUTF();
    if (i1 >= 27)
    {
      this.pobingTemplateId = paramObjectInput.readInt();
      if (i1 >= 28)
      {
        this.mQzoneExtraMsg = paramObjectInput.readUTF();
        if (i1 >= 29)
        {
          this.mBirthReminder = paramObjectInput.readUTF();
          break label1617;
          this.mMsgException = true;
        }
      }
    }
    for (;;)
    {
      label1617:
      if ((!this.mHasSource) && ((!TextUtils.isEmpty(this.mSourceName)) || (!TextUtils.isEmpty(this.mSourceIcon)))) {
        this.mHasSource = true;
      }
      if ((!this.mHasAdSource) && (!TextUtils.isEmpty(this.mAdSourceName))) {
        this.mHasAdSource = true;
      }
      if (this.mSourceName != null)
      {
        if (this.mSourceName.equalsIgnoreCase(HardCodeUtil.a(2131911910)))
        {
          this.mMsgServiceID = 54;
          return;
        }
        if (this.mSourceName.equalsIgnoreCase(HardCodeUtil.a(2131891080)))
        {
          this.mMsgServiceID = 53;
          return;
        }
      }
      return;
      label1755:
      k += 1;
      i = j;
      break;
      if (i1 >= 4) {
        break label934;
      }
      continue;
      label1775:
      if (i1 >= 17) {
        break label1337;
      }
      continue;
      label1785:
      if (i1 >= 25) {
        break label1539;
      }
    }
  }
  
  public void report(Object paramObject)
  {
    SdkShareReporter.a("1", this.uinType, this.mContentTitle, this.mSourceAppid);
    if (("2711679534".equals(this.uin)) && (this.message != null))
    {
      paramObject = new StringBuilder();
      paramObject.append(this.message.time);
      paramObject.append("");
      ReportController.b(null, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "public.message.show", 0, 0, paramObject.toString(), "", "", this.mMsgBrief);
      if (!TextUtils.isEmpty(this.mBirthReminder))
      {
        paramObject = new StringBuilder();
        paramObject.append(NetConnInfoCenter.getServerTimeMillis());
        paramObject.append("");
        ReportController.b(null, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "public.birthmessage.show", 0, 0, paramObject.toString(), "", "", "");
      }
    }
    if ((this.mContext.get() != null) && (((IQQGameHelper)QRoute.api(IQQGameHelper.class)).isQQGamePubAccount(this.uin))) {
      ((IQQGameHelper)QRoute.api(IQQGameHelper.class)).reportStructExposure((Context)this.mContext.get(), this.message);
    }
  }
  
  public void savePayInfo(Context paramContext, String paramString, int paramInt)
  {
    try
    {
      localObject = BaseApplicationImpl.getApplication().getRuntime();
      if ((this.message != null) && (localObject != null))
      {
        if (TextUtils.isEmpty(paramString)) {
          return;
        }
        MessageRecord localMessageRecord = this.message;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("order_pay_state_");
        localStringBuilder.append(paramString);
        paramString = localStringBuilder.toString();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(paramInt);
        localMessageRecord.saveExtInfoToExtStr(paramString, localStringBuilder.toString());
        if ((paramContext instanceof BaseActivity)) {
          ((BaseActivity)paramContext).getChatFragment().k().V.notifyDataSetChanged();
        }
        ThreadManager.post(new StructMsgForGeneralShare.6(this, (AppRuntime)localObject), 5, null, false);
        return;
      }
      return;
    }
    catch (Exception paramContext)
    {
      Object localObject;
      if (QLog.isDevelopLevel())
      {
        paramString = a;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("savePayInfo error ");
        ((StringBuilder)localObject).append(paramContext.getMessage());
        QLog.d(paramString, 4, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  @Deprecated
  public void setProgress(int paramInt)
  {
    AbsStructMsgElement localAbsStructMsgElement = findXmlNode("progress");
    if ((localAbsStructMsgElement != null) && ((localAbsStructMsgElement instanceof StructMsgItemProgress))) {
      ((StructMsgItemProgress)localAbsStructMsgElement).c(paramInt);
    }
  }
  
  @Deprecated
  public void setSummary(String paramString)
  {
    AbsStructMsgElement localAbsStructMsgElement = findXmlNode("summary");
    if ((localAbsStructMsgElement != null) && ((localAbsStructMsgElement instanceof StructMsgItemSummary))) {
      ((StructMsgItemSummary)localAbsStructMsgElement).b(paramString);
    }
  }
  
  @Deprecated
  public void setTitle(String paramString)
  {
    AbsStructMsgElement localAbsStructMsgElement = findXmlNode("title");
    if ((localAbsStructMsgElement != null) && ((localAbsStructMsgElement instanceof StructMsgItemTitle))) {
      ((StructMsgItemTitle)localAbsStructMsgElement).b(paramString);
    }
  }
  
  public void symbol2CharactorForSmallEmoji(AbsStructMsgElement paramAbsStructMsgElement)
  {
    if (paramAbsStructMsgElement != null)
    {
      if (!(paramAbsStructMsgElement instanceof StructMsgItemLayout2)) {
        return;
      }
      paramAbsStructMsgElement = ((StructMsgItemLayout2)paramAbsStructMsgElement).ax;
      if (paramAbsStructMsgElement != null)
      {
        if (paramAbsStructMsgElement.size() == 0) {
          return;
        }
        paramAbsStructMsgElement = paramAbsStructMsgElement.iterator();
        StructMsgItemSummary localStructMsgItemSummary = null;
        while (paramAbsStructMsgElement.hasNext())
        {
          localObject = (AbsStructMsgElement)paramAbsStructMsgElement.next();
          if ((localObject instanceof StructMsgItemSummary)) {
            localStructMsgItemSummary = (StructMsgItemSummary)localObject;
          }
        }
        if (localStructMsgItemSummary == null) {
          return;
        }
        Object localObject = localStructMsgItemSummary.e();
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          return;
        }
        paramAbsStructMsgElement = this.mContext;
        if ((paramAbsStructMsgElement != null) && (paramAbsStructMsgElement.get() != null))
        {
          if (!(this.mContext.get() instanceof BaseActivity)) {
            return;
          }
          paramAbsStructMsgElement = ((BaseActivity)this.mContext.get()).getChatFragment();
          if (paramAbsStructMsgElement != null)
          {
            paramAbsStructMsgElement = paramAbsStructMsgElement.j();
          }
          else
          {
            paramAbsStructMsgElement = BaseApplicationImpl.getApplication().getRuntime();
            if ((paramAbsStructMsgElement != null) && ((paramAbsStructMsgElement instanceof QQAppInterface))) {
              paramAbsStructMsgElement = (QQAppInterface)paramAbsStructMsgElement;
            } else {
              paramAbsStructMsgElement = null;
            }
          }
          if (paramAbsStructMsgElement == null) {
            return;
          }
          IEmoticonManagerService localIEmoticonManagerService = (IEmoticonManagerService)paramAbsStructMsgElement.getRuntimeService(IEmoticonManagerService.class);
          StringBuilder localStringBuilder = new StringBuilder((String)localObject);
          int j;
          for (int i = 0; i < localStringBuilder.length(); i = j + 1)
          {
            j = i;
            if ('ÿ' == localStringBuilder.charAt(i))
            {
              int k = i + 3;
              j = i;
              if (k < localStringBuilder.length())
              {
                paramAbsStructMsgElement = new char[4];
                paramAbsStructMsgElement[0] = localStringBuilder.charAt(k);
                paramAbsStructMsgElement[1] = localStringBuilder.charAt(i + 2);
                paramAbsStructMsgElement[2] = localStringBuilder.charAt(i + 1);
                paramAbsStructMsgElement[3] = localStringBuilder.charAt(i);
                j = 0;
                while (j < 4)
                {
                  if (paramAbsStructMsgElement[j] == 'ú') {
                    paramAbsStructMsgElement[j] = 10;
                  } else if (paramAbsStructMsgElement[j] == 'þ') {
                    paramAbsStructMsgElement[j] = 13;
                  } else if (paramAbsStructMsgElement[j] == 'ý') {
                    paramAbsStructMsgElement[j] = 20;
                  }
                  j += 1;
                }
                paramAbsStructMsgElement = EmosmUtils.a(paramAbsStructMsgElement);
                localObject = QQText.SMALL_EMOJI_SYMBOL;
                if (localIEmoticonManagerService != null) {
                  paramAbsStructMsgElement = localIEmoticonManagerService.syncFindEmoticonById(Integer.toString(paramAbsStructMsgElement[0]), Integer.toString(paramAbsStructMsgElement[1]));
                } else {
                  paramAbsStructMsgElement = null;
                }
                if (paramAbsStructMsgElement != null) {
                  localObject = paramAbsStructMsgElement.character;
                }
                localStringBuilder.replace(i, k, (String)localObject);
                j = i + ((String)localObject).length();
              }
            }
          }
          if (!TextUtils.isEmpty(localStringBuilder)) {
            localStructMsgItemSummary.b(localStringBuilder.toString());
          }
        }
      }
    }
  }
  
  protected void toContentXml(AbsStructMsg.XmlSerializerWithFilter paramXmlSerializerWithFilter)
  {
    Iterator localIterator = iterator();
    while (localIterator.hasNext()) {
      ((AbsStructMsgElement)localIterator.next()).a(paramXmlSerializerWithFilter);
    }
    if ((this.mMsgServiceID == 128) && (this.mDatas != null))
    {
      paramXmlSerializerWithFilter.startTag(null, "data");
      paramXmlSerializerWithFilter.attribute(null, "groupcode", this.mDatas.optString("groupcode"));
      paramXmlSerializerWithFilter.attribute(null, "groupname", this.mDatas.optString("groupname"));
      paramXmlSerializerWithFilter.attribute(null, "msgseq", this.mDatas.optString("msgseq"));
      paramXmlSerializerWithFilter.attribute(null, "msgtype", this.mDatas.optString("msgtype"));
      paramXmlSerializerWithFilter.endTag(null, "data");
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
      Object localObject = (AbsStructMsgElement)localIterator.next();
      if ((localObject instanceof AbsStructMsgItem))
      {
        localObject = ((AbsStructMsgItem)localObject).ax.iterator();
        while (((Iterator)localObject).hasNext())
        {
          AbsStructMsgElement localAbsStructMsgElement = (AbsStructMsgElement)((Iterator)localObject).next();
          if ((localAbsStructMsgElement instanceof StructMsgItemCover)) {
            ((StructMsgItemCover)localAbsStructMsgElement).av = paramString;
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
      Object localObject = (AbsStructMsgElement)localIterator.next();
      if ((localObject instanceof AbsStructMsgItem))
      {
        localObject = ((AbsStructMsgItem)localObject).ax.iterator();
        while (((Iterator)localObject).hasNext())
        {
          AbsStructMsgElement localAbsStructMsgElement = (AbsStructMsgElement)((Iterator)localObject).next();
          if ((localAbsStructMsgElement instanceof StructMsgItemTitle)) {
            ((StructMsgItemTitle)localAbsStructMsgElement).aA = paramString1;
          } else if ((localAbsStructMsgElement instanceof StructMsgItemSummary)) {
            ((StructMsgItemSummary)localAbsStructMsgElement).aA = paramString2;
          } else if ((localAbsStructMsgElement instanceof StructMsgItemCover)) {
            ((StructMsgItemCover)localAbsStructMsgElement).av = paramString3;
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
    Object localObject = this.mMsgAction;
    String str1 = "";
    if (localObject == null) {
      localObject = "";
    } else {
      localObject = this.mMsgAction;
    }
    paramObjectOutput.writeUTF((String)localObject);
    if (this.mMsgActionData == null) {
      localObject = "";
    } else {
      localObject = this.mMsgActionData;
    }
    paramObjectOutput.writeUTF((String)localObject);
    if (this.mMsg_A_ActionData == null) {
      localObject = "";
    } else {
      localObject = this.mMsg_A_ActionData;
    }
    paramObjectOutput.writeUTF((String)localObject);
    if (this.mMsg_I_ActionData == null) {
      localObject = "";
    } else {
      localObject = this.mMsg_I_ActionData;
    }
    paramObjectOutput.writeUTF((String)localObject);
    if (this.mMsgUrl == null) {
      localObject = "";
    } else {
      localObject = this.mMsgUrl;
    }
    paramObjectOutput.writeUTF((String)localObject);
    if (this.mMsgBrief == null) {
      localObject = "";
    } else {
      localObject = this.mMsgBrief;
    }
    paramObjectOutput.writeUTF((String)localObject);
    paramObjectOutput.writeInt(getItemCount());
    localObject = iterator();
    while (((Iterator)localObject).hasNext()) {
      ((AbsStructMsgElement)((Iterator)localObject).next()).a(paramObjectOutput);
    }
    paramObjectOutput.writeLong(this.mSourceAppid);
    if (this.mSourceIcon == null) {
      localObject = "";
    } else {
      localObject = this.mSourceIcon;
    }
    paramObjectOutput.writeUTF((String)localObject);
    if (this.mSourceName == null) {
      localObject = "";
    } else {
      localObject = this.mSourceName;
    }
    paramObjectOutput.writeUTF((String)localObject);
    if (this.mSourceUrl == null) {
      localObject = "";
    } else {
      localObject = this.mSourceUrl;
    }
    paramObjectOutput.writeUTF((String)localObject);
    if (this.mSourceAction == null) {
      localObject = "";
    } else {
      localObject = this.mSourceAction;
    }
    paramObjectOutput.writeUTF((String)localObject);
    if (this.mSourceActionData == null) {
      localObject = "";
    } else {
      localObject = this.mSourceActionData;
    }
    paramObjectOutput.writeUTF((String)localObject);
    if (this.mSource_A_ActionData == null) {
      localObject = "";
    } else {
      localObject = this.mSource_A_ActionData;
    }
    paramObjectOutput.writeUTF((String)localObject);
    if (this.mSource_I_ActionData == null) {
      localObject = "";
    } else {
      localObject = this.mSource_I_ActionData;
    }
    paramObjectOutput.writeUTF((String)localObject);
    paramObjectOutput.writeInt(this.fwFlag);
    paramObjectOutput.writeInt(this.mFlag);
    if (this.mResid == null) {
      localObject = "";
    } else {
      localObject = this.mResid;
    }
    paramObjectOutput.writeUTF((String)localObject);
    if (this.mFileName == null) {
      localObject = "";
    } else {
      localObject = this.mFileName;
    }
    paramObjectOutput.writeUTF((String)localObject);
    paramObjectOutput.writeLong(this.mFileSize);
    if (this.mCommentText == null) {
      localObject = "";
    } else {
      localObject = this.mCommentText;
    }
    paramObjectOutput.writeUTF((String)localObject);
    if (this.mCompatibleText == null) {
      localObject = "";
    } else {
      localObject = this.mCompatibleText;
    }
    paramObjectOutput.writeUTF((String)localObject);
    paramObjectOutput.writeLong(this.msgId);
    paramObjectOutput.writeInt(this.mPromotionType);
    if (this.mPromotionMsg == null) {
      localObject = "";
    } else {
      localObject = this.mPromotionMsg;
    }
    paramObjectOutput.writeUTF((String)localObject);
    if (this.mPromotionMenus == null) {
      localObject = "";
    } else {
      localObject = this.mPromotionMenus;
    }
    paramObjectOutput.writeUTF((String)localObject);
    paramObjectOutput.writeInt(this.mPromotionMenuDestructiveIndex);
    if (this.dynamicMsgMergeKey == null) {
      localObject = "";
    } else {
      localObject = this.dynamicMsgMergeKey;
    }
    paramObjectOutput.writeUTF((String)localObject);
    paramObjectOutput.writeInt(this.dynamicMsgMergeIndex);
    if (this.source_puin == null) {
      localObject = "";
    } else {
      localObject = this.source_puin;
    }
    paramObjectOutput.writeUTF((String)localObject);
    if (this.mSType == null) {
      localObject = "";
    } else {
      localObject = this.mSType;
    }
    paramObjectOutput.writeUTF((String)localObject);
    paramObjectOutput.writeInt(this.adverSign);
    if (this.adverKey == null) {
      localObject = "";
    } else {
      localObject = this.adverKey;
    }
    paramObjectOutput.writeUTF((String)localObject);
    if (this.index == null) {
      localObject = "";
    } else {
      localObject = this.index;
    }
    paramObjectOutput.writeUTF((String)localObject);
    if (this.index_name == null) {
      localObject = "";
    } else {
      localObject = this.index_name;
    }
    paramObjectOutput.writeUTF((String)localObject);
    if (this.index_type == null) {
      localObject = "";
    } else {
      localObject = this.index_type;
    }
    paramObjectOutput.writeUTF((String)localObject);
    if (this.rijAlbumActionData == null) {
      localObject = "";
    } else {
      localObject = this.rijAlbumActionData;
    }
    paramObjectOutput.writeUTF((String)localObject);
    if (this.mArticleIds == null) {
      localObject = "";
    } else {
      localObject = this.mArticleIds;
    }
    paramObjectOutput.writeUTF((String)localObject);
    if (this.mOrangeWord == null) {
      localObject = "";
    } else {
      localObject = this.mOrangeWord;
    }
    paramObjectOutput.writeUTF((String)localObject);
    if (this.mAlgorithmIds == null) {
      localObject = "";
    } else {
      localObject = this.mAlgorithmIds;
    }
    paramObjectOutput.writeUTF((String)localObject);
    if (this.mStrategyIds == null) {
      localObject = "";
    } else {
      localObject = this.mStrategyIds;
    }
    paramObjectOutput.writeUTF((String)localObject);
    if (this.mExtraData == null) {
      localObject = "";
    } else {
      localObject = this.mExtraData;
    }
    paramObjectOutput.writeUTF((String)localObject);
    if (this.mCreateTime == null) {
      localObject = "";
    } else {
      localObject = this.mCreateTime;
    }
    paramObjectOutput.writeUTF((String)localObject);
    if (this.mTagName == null) {
      localObject = "";
    } else {
      localObject = this.mTagName;
    }
    paramObjectOutput.writeUTF((String)localObject);
    String str2 = eventId;
    localObject = str2;
    if (str2 == null) {
      localObject = "";
    }
    paramObjectOutput.writeUTF((String)localObject);
    str2 = remindBrief;
    localObject = str2;
    if (str2 == null) {
      localObject = "";
    }
    paramObjectOutput.writeUTF((String)localObject);
    str2 = eventType;
    localObject = str2;
    if (str2 == null) {
      localObject = "";
    }
    paramObjectOutput.writeUTF((String)localObject);
    str2 = tips;
    localObject = str2;
    if (str2 == null) {
      localObject = "";
    }
    paramObjectOutput.writeUTF((String)localObject);
    if (this.mInnerUniqIds == null) {
      localObject = "";
    } else {
      localObject = this.mInnerUniqIds;
    }
    paramObjectOutput.writeUTF((String)localObject);
    if (this.mSourceThirdName == null) {
      localObject = "";
    } else {
      localObject = this.mSourceThirdName;
    }
    paramObjectOutput.writeUTF((String)localObject);
    if (this.mQQStoryExtra == null) {
      localObject = "";
    } else {
      localObject = this.mQQStoryExtra;
    }
    paramObjectOutput.writeUTF((String)localObject);
    if (this.mNeedRound == null) {
      localObject = "";
    } else {
      localObject = this.mNeedRound;
    }
    paramObjectOutput.writeUTF((String)localObject);
    if (this.mQidianBulkTaskId == null) {
      localObject = "";
    } else {
      localObject = this.mQidianBulkTaskId;
    }
    paramObjectOutput.writeUTF((String)localObject);
    if (this.reportEventFolderStatusValue == null) {
      localObject = "";
    } else {
      localObject = this.reportEventFolderStatusValue;
    }
    paramObjectOutput.writeUTF((String)localObject);
    paramObjectOutput.writeInt(this.forwardType);
    this.shareData.writeExternal(paramObjectOutput);
    if (this.mAdSourceName == null) {
      localObject = "";
    } else {
      localObject = this.mAdSourceName;
    }
    paramObjectOutput.writeUTF((String)localObject);
    if (this.mCommonData == null) {
      localObject = "";
    } else {
      localObject = this.mCommonData;
    }
    paramObjectOutput.writeUTF((String)localObject);
    str2 = this.animResId;
    localObject = str2;
    if (str2 == null) {
      localObject = "";
    }
    paramObjectOutput.writeUTF((String)localObject);
    str2 = this.atMembers;
    localObject = str2;
    if (str2 == null) {
      localObject = "";
    }
    paramObjectOutput.writeUTF((String)localObject);
    if (this.mMergeSeq == null) {
      localObject = "";
    } else {
      localObject = this.mMergeSeq;
    }
    paramObjectOutput.writeUTF((String)localObject);
    paramObjectOutput.writeLong(this.mSortKey);
    if (this.mTribeShortVideoExtra == null) {
      localObject = "";
    } else {
      localObject = this.mTribeShortVideoExtra;
    }
    paramObjectOutput.writeUTF((String)localObject);
    paramObjectOutput.writeBoolean(this.needSendLongMsgWhenFailed);
    paramObjectOutput.writeInt(this.mTSum);
    if (this.mDatas == null) {
      localObject = "";
    } else {
      localObject = this.mDatas.toString();
    }
    paramObjectOutput.writeUTF((String)localObject);
    if (this.mAdSourceMenu == null) {
      localObject = "";
    } else {
      localObject = this.mAdSourceMenu;
    }
    paramObjectOutput.writeUTF((String)localObject);
    paramObjectOutput.writeInt(this.pobingTemplateId);
    if (this.mQzoneExtraMsg == null) {
      localObject = "";
    } else {
      localObject = this.mQzoneExtraMsg;
    }
    paramObjectOutput.writeUTF((String)localObject);
    if (this.mBirthReminder == null) {
      localObject = str1;
    } else {
      localObject = this.mBirthReminder;
    }
    paramObjectOutput.writeUTF((String)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.StructMsgForGeneralShare
 * JD-Core Version:    0.7.0.1
 */