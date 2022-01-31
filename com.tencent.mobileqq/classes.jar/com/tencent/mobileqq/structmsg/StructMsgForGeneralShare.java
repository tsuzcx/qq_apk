package com.tencent.mobileqq.structmsg;

import aimi;
import aimj;
import aimk;
import aiml;
import aimm;
import aimp;
import aimq;
import aims;
import aimt;
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
import com.tencent.biz.pubaccount.util.PAVideoStructMsgUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder.StructingMsgViewHolder;
import com.tencent.mobileqq.adapter.ChatHistoryStructAdapter.HistoryStructItemHolder;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.businessCard.BusinessCardManager;
import com.tencent.mobileqq.businessCard.activity.BusinessCardEditActivity;
import com.tencent.mobileqq.businessCard.data.BusinessCard;
import com.tencent.mobileqq.businessCard.data.CardOCRInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.dating.NearbyTransitActivity;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.intervideo.now.NowFromData;
import com.tencent.mobileqq.intervideo.now.NowProxy;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.qipc.QIPCModule;
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
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayoutNew2;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLongMsgHolder;
import com.tencent.mobileqq.structmsg.view.StructMsgItemMore;
import com.tencent.mobileqq.structmsg.view.StructMsgItemProgress;
import com.tencent.mobileqq.structmsg.view.StructMsgItemSummary;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.structmsg.view.StructMsgItemType;
import com.tencent.mobileqq.structmsg.view.StructMsgItemVideo;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.qphone.base.util.QLog;
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
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.util.WeakReference;

public class StructMsgForGeneralShare
  extends AbsShareMsg
{
  public static final String KEY_PAY_STAT = "order_pay_state_";
  public static final String LOGO_URL_POSTFIX = ".png";
  public static final String LOGO_URL_PREFIX = "http://combo.b.qq.com/mp/api/logo/";
  private static int jdField_a_of_type_Int;
  private static View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new aimm();
  private static String jdField_a_of_type_JavaLangString = "structmsg.StructMsgForGeneralShare";
  public static int clickedItemIndex;
  public static String eventId;
  public static String eventType;
  public static QIPCModule receiptServer;
  public static String remindBrief;
  public static String tips;
  public String animResId;
  public String atMembers;
  public String author;
  public long bid;
  public long commentNum;
  public boolean havaPayInfoInit;
  public boolean isFull;
  public boolean isLike;
  boolean isMultiVideoItem = false;
  public long likeNum;
  public int mClickpositionX;
  public int mClickpositionY;
  WeakReference mContext = new WeakReference(null);
  WeakReference mExpandView = new WeakReference(null);
  public List mHadPaidList = new ArrayList();
  public boolean mIsPAVideoStructMsg;
  public String mPARedPacket = "";
  public String mVipDonateStr = "";
  public String mWarningTips = "";
  public long pVersion;
  public String pid;
  
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
  
  StructMsgForGeneralShare(Bundle paramBundle)
  {
    super(paramBundle);
    this.mContentLayout = 2;
    this.mMsgServiceID = paramBundle.getInt("req_type", 1);
    this.mNeedRound = paramBundle.getString("icon_need_round");
    Object localObject;
    int i;
    label196:
    String str2;
    boolean bool;
    AbsStructMsgItem localAbsStructMsgItem1;
    if (this.mSourceName != null)
    {
      if (this.mSourceName.equalsIgnoreCase("订阅号")) {
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
        String str1 = paramBundle.getString("source_puin");
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
        localObject = paramBundle.getString("detail_url");
        str1 = paramBundle.getString("category");
        str2 = paramBundle.getString("video_url");
        bool = paramBundle.getBoolean("video_url_load", false);
        i = paramBundle.getInt("layout_item", 2);
        if (!TextUtils.isEmpty(str2)) {
          i = 5;
        }
        localAbsStructMsgItem1 = StructMsgElementFactory.a(i);
        if (!TextUtils.isEmpty(str1))
        {
          AbsStructMsgItem localAbsStructMsgItem2 = StructMsgElementFactory.a(0);
          localAbsStructMsgItem2.b(1);
          localAbsStructMsgItem2.a(str1);
          addItem(localAbsStructMsgItem2);
          if (TextUtils.isEmpty(str2)) {
            localAbsStructMsgItem1.a(this.mContentCover, this.mContentTitle, this.mContentSummary, 1);
          }
        }
        break;
      }
    }
    for (;;)
    {
      addItem(localAbsStructMsgItem1);
      if (this.mMsgAction == null) {
        this.mMsgAction = "web";
      }
      return;
      if (!this.mSourceName.equalsIgnoreCase("看点")) {
        break;
      }
      this.mMsgServiceID = 53;
      break;
      this.mMsgServiceID = i;
      break label196;
      a(localAbsStructMsgItem1, bool, (String)localObject, this.mContentCover, str2, this.mContentTitle, this.mContentSummary, paramBundle);
      localAbsStructMsgItem1.e = 1;
      continue;
      if ((this.mMsgServiceID == 118) && (this.mSourceName != null) && (this.mSourceName.equalsIgnoreCase("兴趣部落")))
      {
        localAbsStructMsgItem1.a(this.mContentCover, this.mContentTitle, 0, this.mNeedRound);
      }
      else if (TextUtils.isEmpty(str2))
      {
        localAbsStructMsgItem1.a(this.mContentCover, this.mContentTitle, this.mContentSummary, 0, this.mNeedRound);
      }
      else
      {
        a(localAbsStructMsgItem1, bool, (String)localObject, this.mContentCover, str2, this.mContentTitle, this.mContentSummary, paramBundle);
        localAbsStructMsgItem1.e = 0;
      }
    }
  }
  
  StructMsgForGeneralShare(StructMsgNode paramStructMsgNode)
  {
    super(paramStructMsgNode);
    this.mWarningTips = paramStructMsgNode.a("warningTipsContent");
    this.mPARedPacket = paramStructMsgNode.a("paRedPacket");
    this.mVipDonateStr = paramStructMsgNode.a("vipDonate");
    this.pid = paramStructMsgNode.a("pid");
    String str2 = paramStructMsgNode.a("bid");
    String str1 = str2;
    if (str2 == null) {
      str1 = "0";
    }
    this.bid = Long.valueOf(str1).longValue();
    str2 = paramStructMsgNode.a("pVersion");
    str1 = str2;
    if (str2 == null) {
      str1 = "0";
    }
    this.pVersion = Long.valueOf(str1).longValue();
    str1 = paramStructMsgNode.a("isFull");
    if ((str1 != null) && (Boolean.valueOf(str1).booleanValue()))
    {
      bool1 = true;
      this.isFull = bool1;
      str2 = paramStructMsgNode.a("likeNum");
      str1 = str2;
      if (str2 == null) {
        str1 = "0";
      }
      this.likeNum = Long.valueOf(str1).longValue();
      str2 = paramStructMsgNode.a("commentNum");
      str1 = str2;
      if (str2 == null) {
        str1 = "0";
      }
      this.commentNum = Long.valueOf(str1).longValue();
      str1 = paramStructMsgNode.a("isLike");
      if ((str1 == null) || (!Boolean.valueOf(str1).booleanValue())) {
        break label387;
      }
    }
    label387:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.isLike = bool1;
      this.author = paramStructMsgNode.a("author");
      eventId = paramStructMsgNode.a("eventId");
      remindBrief = paramStructMsgNode.a("remindBrief");
      eventType = paramStructMsgNode.a("eventType");
      this.animResId = paramStructMsgNode.a("resid");
      tips = paramStructMsgNode.a("tips");
      this.atMembers = paramStructMsgNode.a("atmembers");
      return;
      bool1 = false;
      break;
    }
  }
  
  private void a(Context paramContext, int paramInt, View paramView)
  {
    if (paramView == null) {}
    AbsStructMsgElement localAbsStructMsgElement;
    do
    {
      do
      {
        return;
        if ((paramInt <= 2) && (paramInt - 1 >= 0))
        {
          i = AIOUtils.a(12.0F, paramContext.getResources());
          j = paramView.getPaddingBottom();
          int k = paramView.getPaddingLeft();
          int m = paramView.getPaddingRight();
          localAbsStructMsgElement = getItemByIndex(paramInt - 1);
          if (((localAbsStructMsgElement instanceof StructMsgItemLayoutDefault)) && (((StructMsgItemLayoutDefault)localAbsStructMsgElement).a.size() == 1) && ((((StructMsgItemLayoutDefault)localAbsStructMsgElement).a.get(0) instanceof StructMsgItemHr)) && (paramInt - 2 >= 0) && ((getItemByIndex(paramInt - 2) instanceof StructMsgItemLayout5)) && (StructMsgItemLayout5Adapter.a((AbsStructMsgItem)getItemByIndex(paramInt - 2), paramInt - 2)))
          {
            paramView.setPadding(k, i, m, j);
            return;
          }
          if (((localAbsStructMsgElement instanceof StructMsgItemLayout5)) && ((StructMsgItemLayout5Adapter.a((AbsStructMsgItem)localAbsStructMsgElement, paramInt - 1)) || (this.isMultiVideoItem)))
          {
            paramView.setPadding(k, i, m, j);
            return;
          }
        }
      } while (paramInt != getItemCount() - 1);
      localAbsStructMsgElement = getItemByIndex(0);
    } while ((!(localAbsStructMsgElement instanceof StructMsgItemLayout5)) || ((!StructMsgItemLayout5Adapter.a((AbsStructMsgItem)localAbsStructMsgElement, 0)) && (!this.isMultiVideoItem)));
    paramInt = AIOUtils.a(12.0F, paramContext.getResources());
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
      localObject = new LinearLayout.LayoutParams(BaseChatItemLayout.e, -2);
      if (hasFlag(4))
      {
        ((ViewGroup.LayoutParams)localObject).width = -1;
        if (paramBundle.getInt("accostType") != AbsStructMsg.SOURCE_ACCOUNT_TYPE_PA) {
          break label147;
        }
        i = 1;
        label64:
        if ((i == 0) || (!hasFlag(4))) {
          paramView.setBackgroundResource(2130837915);
        }
      }
      if (this.mMsgServiceID != 70) {
        break label153;
      }
      if (QLog.isColorLevel()) {
        QLog.d(".troop.troop_topic", 2, "StructMsgForGeneralShare getView mMsgServiceID == STRUCT_TYPE_TROOP_TOPIC.");
      }
      ((ViewGroup.LayoutParams)localObject).width = -1;
      paramView.setBackgroundResource(2130837915);
    }
    for (;;)
    {
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      return;
      ((ViewGroup.LayoutParams)localObject).width = BaseChatItemLayout.e;
      ((ViewGroup.LayoutParams)localObject).height = -2;
      break;
      label147:
      i = 0;
      break label64;
      label153:
      if (this.mMsgServiceID == 76)
      {
        ((ViewGroup.LayoutParams)localObject).width = -1;
        paramView.setBackgroundDrawable(null);
      }
      else if ((this.mMsgServiceID == 83) || (this.mMsgServiceID == 108))
      {
        ((ViewGroup.LayoutParams)localObject).width = (BaseChatItemLayout.e + AIOUtils.a(10.0F, paramResources));
        if (!TextUtils.isEmpty(this.mMsgActionData)) {
          ((ViewGroup.LayoutParams)localObject).width += AIOUtils.a(18.0F, paramResources);
        }
        paramView.setBackgroundDrawable(null);
      }
      else if ((this.mMsgServiceID == 114) || (this.mMsgServiceID == 116))
      {
        ((ViewGroup.LayoutParams)localObject).width = BaseChatItemLayout.e;
        if (!TextUtils.isEmpty(this.mMsgActionData)) {
          ((ViewGroup.LayoutParams)localObject).width += AIOUtils.a(18.0F, paramResources);
        }
        paramView.setBackgroundDrawable(null);
        if (this.mMsgServiceID == 116)
        {
          paramResources = paramView.findViewById(2131364504);
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
          paramResources = paramView.findViewById(2131364504);
          if (paramResources != null)
          {
            paramBundle = paramResources.getLayoutParams();
            if (ScreenUtil.jdField_a_of_type_Int > 1280) {}
            for (paramBundle.height = AIOUtils.a(144.0F, paramResources.getResources());; paramBundle.height = AIOUtils.a(112.0F, paramResources.getResources()))
            {
              paramResources.setLayoutParams(paramBundle);
              break;
            }
          }
        }
      }
      else if (this.mMsgServiceID == 98)
      {
        ((ViewGroup.LayoutParams)localObject).width = Math.min(BaseChatItemLayout.e + AIOUtils.a(10.0F, paramResources), AIOUtils.a(206.0F, paramResources));
        paramView.setBackgroundDrawable(null);
      }
      else if (this.mMsgServiceID == 91)
      {
        ((ViewGroup.LayoutParams)localObject).width = -1;
        paramView.setBackgroundResource(2130837915);
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
    if (PAVideoStructMsgUtil.a(i1)) {}
    for (paramString2 = new StructMsgItemVideo(paramString2, i1, str1, str2, paramString5, i, j, k, m, n, str3, str4, str5);; paramString2 = new StructMsgItemVideo(paramString2, paramString3, paramBoolean))
    {
      paramString2.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg = this;
      paramString2.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.mMsgUrl = paramString1;
      paramAbsStructMsgItem.a(paramString2);
      paramAbsStructMsgItem.a(new StructMsgItemTitle(paramString4));
      return;
    }
  }
  
  public static String getCoverForChatHistory(AbsStructMsgElement paramAbsStructMsgElement)
  {
    if ((paramAbsStructMsgElement instanceof StructMsgItemCover)) {
      return ((StructMsgItemCover)paramAbsStructMsgElement).u;
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
  
  public static String getSummary(AbsStructMsgElement paramAbsStructMsgElement)
  {
    if ((paramAbsStructMsgElement instanceof StructMsgItemSummary)) {
      return ((StructMsgItemSummary)paramAbsStructMsgElement).A;
    }
    return null;
  }
  
  public static String getTitleForChatHistory(AbsStructMsgElement paramAbsStructMsgElement)
  {
    if ((paramAbsStructMsgElement instanceof AbsStructMsgTextElement)) {
      return ((AbsStructMsgTextElement)paramAbsStructMsgElement).A;
    }
    return null;
  }
  
  static boolean handleNearbyPublicAccountMsg(QQAppInterface paramQQAppInterface, Context paramContext, StructMsgForGeneralShare paramStructMsgForGeneralShare)
  {
    bool2 = false;
    bool1 = bool2;
    String str1;
    String str2;
    if (paramStructMsgForGeneralShare.mMsgBrief.contains("找校友"))
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
      paramQQAppInterface = JumpParser.a(paramQQAppInterface, paramContext, str2);
      bool1 = bool2;
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface.b();
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
  
  public static void onClickEvent(QQAppInterface paramQQAppInterface, Context paramContext, StructMsgForGeneralShare paramStructMsgForGeneralShare, View paramView, StructMsgForGeneralShare.GeneralClickHandler paramGeneralClickHandler)
  {
    Object localObject1 = paramView.getTag();
    label101:
    Object localObject2;
    boolean bool1;
    if ((localObject1 != null) && ((localObject1 instanceof StructingMsgItemBuilder.StructingMsgViewHolder)))
    {
      localObject1 = ((StructingMsgItemBuilder.StructingMsgViewHolder)localObject1).a;
      paramStructMsgForGeneralShare.uniseq = ((ChatMessage)localObject1).uniseq;
      paramStructMsgForGeneralShare.uin = ((ChatMessage)localObject1).frienduin;
      paramStructMsgForGeneralShare.uinType = ((ChatMessage)localObject1).istroop;
      paramStructMsgForGeneralShare.currentAccountUin = ((ChatMessage)localObject1).selfuin;
      paramStructMsgForGeneralShare.messageVersion = ((ChatMessage)localObject1).versionCode;
      if (!"web".equals(paramStructMsgForGeneralShare.mMsgAction)) {
        break label1845;
      }
      if (!TextUtils.isEmpty(paramStructMsgForGeneralShare.mMsgActionData)) {
        break label406;
      }
      paramView = paramStructMsgForGeneralShare.mMsg_A_ActionData;
      localObject2 = paramStructMsgForGeneralShare.rijAlbumActionData;
      if ((TextUtils.isEmpty((CharSequence)localObject2)) || (!((String)localObject2).startsWith("mqqapi://readinjoy/openatlas"))) {
        break label430;
      }
      paramContext = JumpParser.a(paramQQAppInterface, paramContext, (String)localObject2);
      if (paramContext == null) {
        break label414;
      }
      paramContext.b();
      bool1 = true;
      label146:
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "handle readinjoy gallery jump rijAlbumActionData = " + (String)localObject2);
      }
    }
    int i;
    label188:
    label224:
    boolean bool2;
    label406:
    label414:
    label430:
    Object localObject3;
    int j;
    Bundle localBundle;
    String[] arrayOfString2;
    label946:
    label979:
    int k;
    for (;;)
    {
      if (bool1)
      {
        i = 1;
        if (paramStructMsgForGeneralShare.mMsgServiceID == 91)
        {
          ReportController.b(paramQQAppInterface, "dc00898", "", "", "0X8007758", "0X8007758", 0, 0, "", "", "", "");
          ReportController.b(paramQQAppInterface, "P_CliOper", "Pb_account_lifeservice", paramStructMsgForGeneralShare.uin, "0X80055C7", "0X80055C7", 0, i, "" + paramStructMsgForGeneralShare.msgId, paramStructMsgForGeneralShare.templateIDForPortal, "", paramStructMsgForGeneralShare.mMsgUrl);
          paramContext = new StringBuilder().append("MSGID=").append(Long.toString(paramStructMsgForGeneralShare.msgId)).append(";TEPLATEID=").append(paramStructMsgForGeneralShare.templateIDForPortal).append(";ARTICALID=").append("").append(";REFERRER=").append(AbsStructMsgElement.a(paramStructMsgForGeneralShare.mMsgUrl));
          ReportController.b(paramQQAppInterface, "P_CliOper", "Pb_account_lifeservice", paramStructMsgForGeneralShare.uin, "0X8005D49", "0X8005D49", 0, i, paramContext.toString(), "", "", "");
          do
          {
            return;
          } while ((localObject1 == null) || (!(localObject1 instanceof ChatHistoryStructAdapter.HistoryStructItemHolder)));
          localObject1 = (ChatMessage)((ChatHistoryStructAdapter.HistoryStructItemHolder)localObject1).a;
          break;
          paramView = paramStructMsgForGeneralShare.mMsgActionData;
          break label101;
          paramGeneralClickHandler.a(paramStructMsgForGeneralShare.mMsgUrl);
          bool1 = false;
          break label146;
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
            paramGeneralClickHandler = new Intent(paramContext, NearbyTransitActivity.class);
            paramGeneralClickHandler.putExtra("action", 1);
            paramGeneralClickHandler.putExtra("hotnamecode", paramView);
            paramGeneralClickHandler.putExtra("enter_time", System.currentTimeMillis());
            paramContext.startActivity(paramGeneralClickHandler);
            bool1 = true;
            continue;
          }
          if ((!TextUtils.isEmpty(paramView)) && (paramView.startsWith("story:")))
          {
            paramContext = JumpParser.a(paramQQAppInterface, paramContext, paramView.substring("story:".length()));
            if (paramContext != null) {
              paramContext.b();
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
              paramGeneralClickHandler.a(paramStructMsgForGeneralShare.mMsgUrl);
            }
          }
          if (paramStructMsgForGeneralShare.mMsgServiceID == 60)
          {
            paramGeneralClickHandler.a(paramStructMsgForGeneralShare.mMsgUrl);
            bool1 = false;
            continue;
          }
          if ((!TextUtils.isEmpty(paramStructMsgForGeneralShare.mMsgUrl)) && ((paramStructMsgForGeneralShare.mMsgUrl.startsWith("http://now.qq.com")) || (paramStructMsgForGeneralShare.mMsgUrl.startsWith("https://now.qq.com"))))
          {
            if ((paramStructMsgForGeneralShare.mMsgUrl.contains("http://now.qq.com/h5/index.html")) || (paramStructMsgForGeneralShare.mMsgUrl.contains("http://now.qq.com/h5/story.html")) || (paramStructMsgForGeneralShare.mMsgUrl.contains("https://now.qq.com/h5/index.html")) || (paramStructMsgForGeneralShare.mMsgUrl.contains("https://now.qq.com/h5/story.html"))) {
              bool2 = true;
            }
            for (;;)
            {
              if (bool2)
              {
                localObject3 = (NowProxy)paramQQAppInterface.getManager(181);
                String[] arrayOfString1 = paramStructMsgForGeneralShare.mMsgUrl.substring(paramStructMsgForGeneralShare.mMsgUrl.indexOf("?") + 1).split("&");
                j = 0;
                localBundle = new Bundle();
                localBundle.putString("url", paramStructMsgForGeneralShare.mMsgUrl);
                int m = 0;
                paramView = "";
                paramContext = "0";
                for (;;)
                {
                  if (m < arrayOfString1.length)
                  {
                    arrayOfString2 = arrayOfString1[m].split("=");
                    if (arrayOfString2.length != 2)
                    {
                      m += 1;
                      continue;
                      bool2 = false;
                      break;
                    }
                    if (!"roomid".equals(arrayOfString2[0])) {
                      break label3278;
                    }
                    paramContext = arrayOfString2[1];
                    i = j;
                    localObject2 = paramView;
                    k = j;
                  }
                }
              }
            }
          }
        }
      }
    }
    label1845:
    label3278:
    label3281:
    for (;;)
    {
      for (;;)
      {
        try
        {
          for (;;)
          {
            if ("first".equals(arrayOfString2[0]))
            {
              localObject2 = paramView;
              k = j;
              i = Integer.parseInt(arrayOfString2[1]);
            }
            localObject2 = paramView;
            k = i;
            if ("bid".equals(arrayOfString2[0]))
            {
              localObject2 = paramView;
              k = i;
              Integer.parseInt(arrayOfString2[1]);
            }
            localObject2 = paramView;
            k = i;
            if ("roomtype".equals(arrayOfString2[0]))
            {
              localObject2 = paramView;
              k = i;
              localBundle.putString("roomtype", arrayOfString2[1]);
            }
            localObject1 = paramView;
            localObject2 = paramView;
            k = i;
            if ("sharefrom".equals(arrayOfString2[0]))
            {
              localObject1 = arrayOfString2[1];
              localObject2 = localObject1;
              k = i;
              localBundle.putString("from", (String)localObject1);
            }
            try
            {
              if ("extras".equals(arrayOfString2[0])) {
                localBundle.putString("extras", arrayOfString2[1]);
              }
              if (TextUtils.isEmpty((CharSequence)localObject1)) {
                break label3281;
              }
              j = NowProxy.a((String)localObject1);
              i = j;
              j = i;
              if (i == 0) {
                j = 2;
              }
              paramView = (View)localObject1;
            }
            catch (NumberFormatException paramView)
            {
              paramView = (View)localObject1;
            }
          }
        }
        catch (NumberFormatException paramView)
        {
          paramView = (View)localObject2;
          i = k;
          continue;
          localObject1 = "";
          paramGeneralClickHandler = "";
          paramView = "";
          continue;
        }
        j = i;
        break label946;
        try
        {
          long l = Long.parseLong(paramContext);
          paramContext = new NowFromData();
          paramContext.jdField_a_of_type_JavaLangString = "now_share";
          paramContext.jdField_b_of_type_JavaLangString = "shareobj";
          if ((0L != l) && (((NowProxy)localObject3).a(null, l, paramContext, j, localBundle))) {
            continue;
          }
          bool1 = paramGeneralClickHandler.a(paramStructMsgForGeneralShare.mMsgUrl);
        }
        catch (NumberFormatException paramContext)
        {
          paramGeneralClickHandler.a(paramStructMsgForGeneralShare.mMsgUrl);
          bool1 = false;
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString + "Q.qqstory.TAG_NOW_ENTRANCE_ACTION_CONFIG", 2, "handle now jump .msg.mMsgUrl = " + paramStructMsgForGeneralShare.mMsgUrl + "|isUrlInWhileList:" + bool2);
        }
        break;
        bool1 = paramGeneralClickHandler.a(paramStructMsgForGeneralShare.mMsgUrl);
        continue;
        if ((!TextUtils.isEmpty(paramView)) && (paramView.startsWith("apollo:")))
        {
          paramView = paramStructMsgForGeneralShare.mMsgUrl.split("\\?");
          if ((paramView.length == 2) && (ApolloManager.a(paramContext)))
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
          bool1 = paramGeneralClickHandler.a(paramStructMsgForGeneralShare.mMsgUrl);
          break;
        }
        if (paramStructMsgForGeneralShare.hasFlag(16))
        {
          paramView = paramStructMsgForGeneralShare.mMsgUrl;
          paramContext = paramView;
          if (paramView != null)
          {
            localObject2 = new StringBuilder().append(paramView);
            if (paramView.indexOf('?') != -1)
            {
              paramContext = "&";
              paramContext = ((StringBuilder)localObject2).append(paramContext).append("f_hbType=");
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
            bool1 = paramGeneralClickHandler.a(paramContext);
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
            if (!paramGeneralClickHandler.c("mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=cooperation.readinjoy.ReadInJoyProxyActivity&url=" + URLEncoder.encode(paramStructMsgForGeneralShare.mMsgUrl) + "&from=" + paramStructMsgForGeneralShare.mMsgServiceID, null))
            {
              bool1 = paramGeneralClickHandler.a(paramStructMsgForGeneralShare.mMsgUrl);
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
            bool1 = paramGeneralClickHandler.a(paramStructMsgForGeneralShare.mMsgUrl);
          }
        }
      }
      if (paramStructMsgForGeneralShare.uin.equals("3242766078"))
      {
        bool1 = handleNearbyPublicAccountMsg(paramQQAppInterface, paramContext, paramStructMsgForGeneralShare);
        if (!bool1)
        {
          bool1 = paramGeneralClickHandler.a(paramStructMsgForGeneralShare.mMsgUrl);
          break;
          if (paramStructMsgForGeneralShare.mMsgServiceID != 97) {
            break label224;
          }
          ReportController.b(paramQQAppInterface, "dc00898", "", "", "0X8007ADA", "0X8007ADA", 0, 0, "", "", "", "");
          break label224;
          if ("plugin".equals(paramStructMsgForGeneralShare.mMsgAction))
          {
            if (paramQQAppInterface != null)
            {
              bool1 = paramGeneralClickHandler.c(paramStructMsgForGeneralShare.mMsgActionData, paramStructMsgForGeneralShare.mMsg_A_ActionData);
              i = 0;
              if (bool1) {
                i = 1;
              }
              ReportController.b(paramQQAppInterface, "P_CliOper", "Pb_account_lifeservice", paramStructMsgForGeneralShare.uin, "0X80055C7", "0X80055C7", 0, i, "" + paramStructMsgForGeneralShare.msgId, paramStructMsgForGeneralShare.templateIDForPortal, "", paramStructMsgForGeneralShare.mMsgUrl);
              paramContext = new StringBuilder().append("MSGID=").append(Long.toString(paramStructMsgForGeneralShare.msgId)).append(";TEPLATEID=").append(paramStructMsgForGeneralShare.templateIDForPortal).append(";ARTICALID=").append("").append(";REFERRER=").append(AbsStructMsgElement.a(paramStructMsgForGeneralShare.mMsgUrl));
              ReportController.b(paramQQAppInterface, "P_CliOper", "Pb_account_lifeservice", paramStructMsgForGeneralShare.uin, "0X8005D49", "0X8005D49", 0, i, paramContext.toString(), "", "", "");
              return;
            }
            bool1 = false;
            continue;
          }
          if ("viewMultiMsg".equals(paramStructMsgForGeneralShare.mMsgAction))
          {
            paramGeneralClickHandler = (FragmentActivity)paramContext;
            if (paramGeneralClickHandler.getChatFragment() != null)
            {
              i = paramGeneralClickHandler.getChatFragment().a().b();
              paramView = paramGeneralClickHandler.getChatFragment().a().a();
              paramGeneralClickHandler = paramGeneralClickHandler.getChatFragment().a().c();
              localObject1 = new Intent(paramContext, MultiForwardActivity.class);
              ((Intent)localObject1).putExtra("chat_subType", 3);
              ((Intent)localObject1).putExtra("uin", paramView);
              ((Intent)localObject1).putExtra("uintype", i);
              ((Intent)localObject1).putExtra("troop_code", paramGeneralClickHandler);
              ((Intent)localObject1).putExtra("multi_url", paramStructMsgForGeneralShare.mResid);
              ((Intent)localObject1).putExtra("multi_uniseq", paramStructMsgForGeneralShare.uniseq);
              ((Intent)localObject1).putExtra("multi_source", paramStructMsgForGeneralShare.mSourceName);
              paramContext.startActivity((Intent)localObject1);
            }
            bool1 = true;
            i = 0;
            if (bool1) {
              i = 1;
            }
            ReportController.b(paramQQAppInterface, "P_CliOper", "Pb_account_lifeservice", paramStructMsgForGeneralShare.uin, "0X80055C7", "0X80055C7", 0, i, "" + paramStructMsgForGeneralShare.msgId, paramStructMsgForGeneralShare.templateIDForPortal, "", paramStructMsgForGeneralShare.mMsgUrl);
            paramContext = new StringBuilder().append("MSGID=").append(Long.toString(paramStructMsgForGeneralShare.msgId)).append(";TEPLATEID=").append(paramStructMsgForGeneralShare.templateIDForPortal).append(";ARTICALID=").append("").append(";REFERRER=").append(AbsStructMsgElement.a(paramStructMsgForGeneralShare.mMsgUrl));
            ReportController.b(paramQQAppInterface, "P_CliOper", "Pb_account_lifeservice", paramStructMsgForGeneralShare.uin, "0X8005D49", "0X8005D49", 0, i, paramContext.toString(), "", "", "");
            return;
          }
          if ("viewFlower".equals(paramStructMsgForGeneralShare.mMsgAction))
          {
            paramGeneralClickHandler.a(paramView, paramStructMsgForGeneralShare.uin);
            bool1 = false;
            continue;
          }
          if ("shareBusinessCard".equals(paramStructMsgForGeneralShare.mMsgAction))
          {
            if (paramStructMsgForGeneralShare.mMsg_A_ActionData != null)
            {
              paramView = paramStructMsgForGeneralShare.mMsg_A_ActionData.split(";");
              if ((paramView != null) && (paramView.length == 3))
              {
                localObject1 = paramView[0].substring("url=".length());
                paramGeneralClickHandler = paramView[1].substring("name=".length());
                paramView = paramView[2].substring("phone=".length());
                if (!TextUtils.isEmpty((CharSequence)localObject1))
                {
                  localObject2 = (BusinessCardManager)paramQQAppInterface.getManager(111);
                  if (localObject2 != null)
                  {
                    localObject3 = ((BusinessCardManager)localObject2).c((String)localObject1);
                    localObject2 = new Intent(paramContext, BusinessCardEditActivity.class);
                    ((Intent)localObject2).putExtra("source_activity", 2);
                    if (localObject3 == null) {
                      continue;
                    }
                    ((Intent)localObject2).putExtra("cur_card_id", ((BusinessCard)localObject3).cardId);
                    if (((BusinessCard)localObject3).cardType != 1) {
                      continue;
                    }
                    ((Intent)localObject2).putExtra("mode_type", 3);
                    ((Intent)localObject2).putExtra("is_edit_mode", false);
                    paramContext.startActivity((Intent)localObject2);
                  }
                }
                bool1 = false;
                continue;
                ((Intent)localObject2).putExtra("mode_type", 0);
                continue;
                localObject3 = new CardOCRInfo();
                ((CardOCRInfo)localObject3).jdField_b_of_type_JavaLangString = ((String)localObject1);
                ((CardOCRInfo)localObject3).jdField_a_of_type_JavaLangString = paramGeneralClickHandler;
                ((CardOCRInfo)localObject3).jdField_b_of_type_JavaUtilList.add(paramView);
                ((Intent)localObject2).putExtra("mode_type", 0);
                ((Intent)localObject2).putExtra("finish_immedia", true);
                ((Intent)localObject2).putExtra("is_edit_mode", false);
                ((Intent)localObject2).putExtra("cur_ocr_info", (Parcelable)localObject3);
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
                paramGeneralClickHandler = new Intent();
                paramGeneralClickHandler.putExtra("ReceiptMessageDetailFragment.extra_msg_uni_seq", ((ChatMessage)localObject1).uniseq);
                paramGeneralClickHandler.putExtra("ReceiptMessageDetailFragment.extra_res_id", paramStructMsgForGeneralShare.mResid);
                paramGeneralClickHandler.putExtra("ReceiptMessageDetailFragment.extra_msg_session_info", paramView.getChatFragment().a().jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
                paramGeneralClickHandler.putExtra("ReceiptMessageDetailFragment.extra_shmsgseq", ((ChatMessage)localObject1).shmsgseq);
                paramGeneralClickHandler.putExtra("ReceiptMessageDetailFragment.extra_sender_uin", ((ChatMessage)localObject1).senderuin);
                paramGeneralClickHandler.putExtra("ReceiptMessageDetailFragment.extra_msg_seq", ((ChatMessage)localObject1).msgseq);
                paramGeneralClickHandler.putExtra("ReceiptMessageDetailFragment.extra_msg_uid", ((ChatMessage)localObject1).msgUid);
                paramGeneralClickHandler.putExtra("ReceiptMessageDetailFragment.extra_msg_time", ((ChatMessage)localObject1).time);
                paramGeneralClickHandler.putExtra("ReceiptMessageDetailFragment.EXTRA_SESSION_TYPE_FROM_MESSAGE", ((ChatMessage)localObject1).istroop);
                paramGeneralClickHandler.putExtra("ReceiptMessageDetailFragment.EXTRA_IS_READ", "1".equals(ReceiptMsgManager.a((MessageRecord)localObject1)));
                paramView.getChatFragment().a().aQ();
                PublicFragmentActivity.a(paramContext, paramGeneralClickHandler, ReceiptMessageDetailFragment.class);
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
                  paramGeneralClickHandler = (AbsStructMsgElement)paramStructMsgForGeneralShare.getStructMsgItemLists().get(0);
                  paramView = paramContext;
                  k = i;
                  if (!(paramGeneralClickHandler instanceof StructMsgItemLayout29)) {
                    continue;
                  }
                  paramGeneralClickHandler = ((StructMsgItemLayout29)paramGeneralClickHandler).a.iterator();
                  paramView = paramContext;
                  k = i;
                  if (!paramGeneralClickHandler.hasNext()) {
                    continue;
                  }
                  paramView = (AbsStructMsgElement)paramGeneralClickHandler.next();
                  k = i;
                  if ("type".equals(paramView.jdField_a_of_type_JavaLangString))
                  {
                    k = i;
                    if ((paramView instanceof StructMsgItemType)) {
                      i = ((StructMsgItemType)paramView).e;
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
                  paramGeneralClickHandler = ((ChatMessage)localObject1).senderuin;
                  if (!((ChatMessage)localObject1).isSend()) {
                    continue;
                  }
                  paramContext = "1";
                  ReportController.b(paramQQAppInterface, "CliOper", "", paramGeneralClickHandler, "0x80083E9", "0x80083E9", j, 0, paramContext, "", paramView, "");
                }
              }
              bool1 = true;
              continue;
              paramContext = "2";
              continue;
            }
            bool1 = paramGeneralClickHandler.a(paramStructMsgForGeneralShare.mMsgAction, paramStructMsgForGeneralShare.mMsgUrl, paramStructMsgForGeneralShare.mMsgActionData, paramStructMsgForGeneralShare.mMsg_A_ActionData);
            continue;
          }
          i = 0;
          break label188;
        }
        break;
      }
      bool1 = false;
      continue;
      break label979;
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
      return localObject1;
      localObject1 = paramView;
    } while (paramView != null);
    paramView = new TextView(paramContext);
    Object localObject1 = paramContext.getResources();
    paramView.setText(this.mAdSourceName);
    paramView.setSingleLine(true);
    paramView.setGravity(17);
    paramView.setEllipsize(TextUtils.TruncateAt.END);
    paramView.setTextColor(Color.rgb(187, 187, 187));
    paramView.setTextSize(2, 12.0F);
    paramView.setBackgroundResource(2130844017);
    if (!TextUtils.isEmpty(this.mSourceIcon)) {}
    Object localObject2 = ((Resources)localObject1).getDrawable(2130844020);
    ((Drawable)localObject2).setBounds(0, 0, 24, 16);
    paramView.setCompoundDrawables(null, null, (Drawable)localObject2, null);
    paramView.setPadding(0, 0, AIOUtils.a(3.0F, (Resources)localObject1), 0);
    localObject2 = LayoutInflater.from(paramContext).inflate(2130969186, null);
    PopupWindow localPopupWindow = new PopupWindow((View)localObject2, -1, -2, true);
    localPopupWindow.setTouchable(true);
    localPopupWindow.setOutsideTouchable(true);
    paramView.setOnClickListener(new aimq(this, paramContext, (Resources)localObject1, localPopupWindow));
    ((View)localObject2).findViewById(2131365552).setOnClickListener(new aims(this, localPopupWindow, paramContext));
    ((View)localObject2).findViewById(2131365553).setOnClickListener(new aimt(this, paramContext, localPopupWindow));
    return paramView;
  }
  
  public String getLayoutStr()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if ((this.mMsgServiceID == 83) || (this.mMsgServiceID == 108) || (this.mMsgServiceID == 114) || (this.mMsgServiceID == 116)) {
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
          localStringBuffer.append(((AbsStructMsgElement)localIterator.next()).a());
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
    AbsStructMsgElement localAbsStructMsgElement = findXmlNode("progress");
    if ((localAbsStructMsgElement != null) && ((localAbsStructMsgElement instanceof StructMsgItemProgress))) {
      return ((StructMsgItemProgress)localAbsStructMsgElement).b();
    }
    return -1;
  }
  
  @TargetApi(16)
  public View getView(Context paramContext, View paramView, OnLongClickAndTouchListener paramOnLongClickAndTouchListener, Bundle paramBundle)
  {
    int j = 1;
    int i = 1;
    this.mContext = new WeakReference(paramContext);
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putBoolean("hasHeadIcon", hasFlag(4));
    localBundle.putInt("serviceID", this.mMsgServiceID);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "getView(): convertView=" + paramView + ", args = " + localBundle.toString());
    }
    int k = localBundle.getInt("longMsgHolderType", -1);
    if ((k == 1) || (k == 2) || (k == 3))
    {
      paramView = StructMsgItemLongMsgHolder.a(paramContext, paramView, paramOnLongClickAndTouchListener, localBundle);
      paramView.setId(2131361855);
      paramView.setTag(2131361855, this);
      if ((!localBundle.getBoolean("isSubscript", false)) && (hasFlag(4)))
      {
        paramView.setBackgroundResource(2130837915);
        return paramView;
      }
      paramView.setBackgroundDrawable(null);
      return paramView;
    }
    if (localBundle.getInt("accostType") == AbsStructMsg.SOURCE_ACCOUNT_TYPE_PA) {}
    for (k = 1; this.mMsgException; k = 0)
    {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "struct msg has version exception! uin : " + this.uin + " msgVersion : " + this.messageVersion + " version : " + this.mVersion + " msgUniseq" + this.uniseq);
      paramContext = getVersionExceptionView(paramContext, paramView, paramOnLongClickAndTouchListener, localBundle);
      paramContext.setId(2131361855);
      paramContext.setTag(2131361855, this);
      return paramContext;
    }
    if (paramView == null)
    {
      paramView = super.getView(paramContext, null, paramOnLongClickAndTouchListener, localBundle);
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
        break label2937;
      }
    }
    label642:
    label1070:
    label1492:
    label1510:
    label2793:
    label2925:
    label2934:
    label2937:
    for (int m = getItemCount();; m = 0)
    {
      int n;
      Object localObject2;
      if (m > 0)
      {
        n = 0;
        j = i;
        if (n < m)
        {
          localObject2 = getItemByIndex(n);
          ((AbsStructMsgElement)localObject2).jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramOnLongClickAndTouchListener);
          symbol2CharactorForSmallEmoji((AbsStructMsgElement)localObject2);
          if ((this.uin != null) && (!this.uin.equalsIgnoreCase(((AbsStructMsgElement)localObject2).t))) {
            ((AbsStructMsgElement)localObject2).t = this.uin;
          }
          if (((AbsStructMsgElement)localObject2).a() == 0)
          {
            if (n == 0) {
              ((AbsStructMsgElement)localObject2).a(1);
            }
            if (n == m - 1) {
              ((AbsStructMsgElement)localObject2).a(2);
            }
          }
          if ((localObject2 instanceof StructMsgItemLayout8)) {
            paramView = ((AbsStructMsgElement)localObject2).a(paramContext, null, localBundle);
          }
        }
      }
      for (;;)
      {
        label507:
        Object localObject1;
        if ((n + 2 < m) && (paramView != null))
        {
          localObject1 = getItemByIndex(n + 2);
          if ((((AbsStructMsgItem)localObject1).a.size() != 0) && (paramView != null) && ((((localObject1 instanceof StructMsgItemLayoutDefault)) && ((((StructMsgItemLayoutDefault)localObject1).a.get(0) instanceof StructMsgItemMore))) || (((localObject1 instanceof StructMsgItemLayout3)) && ((((StructMsgItemLayout3)localObject1).a.get(0) instanceof StructMsgItemButton)))))
          {
            localObject1 = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
            if (localObject1 != null)
            {
              if (!(localObject2 instanceof StructMsgItemLayoutDefault)) {
                break label1510;
              }
              if (k == 0) {
                break label1492;
              }
              ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin = AIOUtils.a(11.0F, paramContext.getResources());
              paramView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
            }
          }
        }
        if ((n + 1 < m) && (paramView != null) && (k != 0) && (((AbsStructMsgItem)localObject2).a.size() == 1) && ((((AbsStructMsgItem)localObject2).a.get(0) instanceof StructMsgItemHr)))
        {
          localObject1 = getItemByIndex(n + 1);
          if ((((AbsStructMsgItem)localObject1).a.size() != 0) && ((localObject1 instanceof StructMsgItemLayout3)) && ((((StructMsgItemLayout3)localObject1).a.get(0) instanceof StructMsgItemButton)))
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
        if (paramView != null)
        {
          if ((!TextUtils.isEmpty(((AbsStructMsgElement)localObject2).c)) || ((localObject2 instanceof StructMsgItemLayout28)))
          {
            paramView.setTag(localObject2);
            paramView.setClickable(true);
            paramView.setOnClickListener((View.OnClickListener)localObject2);
            paramView.setOnLongClickListener(new aimi(this, paramOnLongClickAndTouchListener));
            paramView.setOnTouchListener(new aimj(this, paramOnLongClickAndTouchListener));
            clickedItemIndex = 0;
          }
          if (paramView.getParent() != null)
          {
            ((ViewGroup)paramView.getParent()).removeView(paramView);
            if (QLog.isColorLevel()) {
              QLog.e(jdField_a_of_type_JavaLangString, 2, "getView itemView.getParent != null .itemName = ." + localObject2.getClass().getName());
            }
          }
          paramBundle.addView(paramView);
        }
        for (;;)
        {
          n += 1;
          break;
          if ((localObject2 instanceof StructMsgItemLayout9))
          {
            paramView = ((AbsStructMsgElement)localObject2).a(paramContext, null, localBundle);
            break label507;
          }
          if ((localObject2 instanceof StructMsgItemLayout12))
          {
            paramView = ((AbsStructMsgElement)localObject2).a(paramContext, null, localBundle);
            i = 0;
            break label507;
          }
          if ((localObject2 instanceof StructMsgItemLayout5))
          {
            if (n + 1 < m) {
              ((StructMsgItemLayout5)localObject2).a = true;
            }
            for (this.isMultiVideoItem = true;; this.isMultiVideoItem = false)
            {
              if (k == 0) {
                break label1070;
              }
              paramView = new StructMsgItemLayout5Adapter((AbsStructMsgItem)localObject2, paramContext, n).a(paramContext, null, localBundle);
              break;
              ((StructMsgItemLayout5)localObject2).a = false;
            }
            paramView = ((AbsStructMsgElement)localObject2).a(paramContext, null, localBundle);
            break label507;
          }
          if ((localObject2 instanceof StructMsgItemLayout6))
          {
            if (k != 0)
            {
              paramView = new StructMsgItemLayout6Adapter((AbsStructMsgItem)localObject2, paramContext, n).a(paramContext, null, localBundle);
              break label507;
            }
            paramView = ((AbsStructMsgElement)localObject2).a(paramContext, null, localBundle);
            break label507;
          }
          if ((localObject2 instanceof StructMsgItemLayout4))
          {
            localObject1 = ((AbsStructMsgElement)localObject2).a(paramContext, null, localBundle);
            paramView = (View)localObject1;
            if (k == 0) {
              break label2934;
            }
            a(paramContext, n, (View)localObject1);
            paramView = (View)localObject1;
            break label507;
          }
          if ((localObject2 instanceof StructMsgItemLayout18))
          {
            paramView = ((AbsStructMsgElement)localObject2).a(paramContext, null, localBundle);
            i = 0;
            break label507;
          }
          if ((localObject2 instanceof StructMsgItemLayout19))
          {
            paramView = ((AbsStructMsgElement)localObject2).a(paramContext, null, localBundle);
            i = 0;
            break label507;
          }
          if ((localObject2 instanceof StructMsgItemLayout2))
          {
            if ((this.mMsgServiceID == 83) || (this.mMsgServiceID == 108) || (this.mMsgServiceID == 114) || (this.mMsgServiceID == 116))
            {
              paramView = new StructMsgItemLayoutNew2();
              paramView.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg = this;
              paramView.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramOnLongClickAndTouchListener);
              paramView = paramView.a(paramContext, null, localBundle);
              i = 0;
              break label507;
            }
            localObject1 = ((AbsStructMsgElement)localObject2).a(paramContext, null, localBundle);
            paramView = (View)localObject1;
            if (localObject1 == null) {
              break label2934;
            }
            ((View)localObject1).setTag(jdField_a_of_type_Int, localObject2);
            paramView = (View)localObject1;
            break label507;
          }
          if ((localObject2 instanceof StructMsgItemLayout20))
          {
            paramView = ((AbsStructMsgElement)localObject2).a(paramContext, null, localBundle);
            break label507;
          }
          if ((localObject2 instanceof StructMsgItemLayout26))
          {
            localBundle.putString("extraData", this.mExtraData);
            paramView = ((AbsStructMsgElement)localObject2).a(paramContext, null, localBundle);
            i = 0;
            break label507;
          }
          if ((localObject2 instanceof StructMsgItemLayout27))
          {
            paramView = ((AbsStructMsgElement)localObject2).a(paramContext, null, localBundle);
            i = 0;
            break label507;
          }
          if ((localObject2 instanceof StructMsgItemLayout28))
          {
            paramView = ((AbsStructMsgElement)localObject2).a(paramContext, null, localBundle);
            i = 0;
            break label507;
          }
          if ((localObject2 instanceof StructMsgItemLayout29))
          {
            ((AbsStructMsgElement)localObject2).jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg = this;
            paramView = ((AbsStructMsgElement)localObject2).a(paramContext, null, localBundle);
            i = 0;
            break label507;
          }
          paramView = ((AbsStructMsgElement)localObject2).a(paramContext, null, localBundle);
          break label507;
          ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin = AIOUtils.a(16.0F, paramContext.getResources());
          break label642;
          if ((!(localObject2 instanceof StructMsgItemLayout6)) || (StructMsgItemLayout6Adapter.a((AbsStructMsgItem)localObject2, n))) {
            break label642;
          }
          ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin = AIOUtils.a(7.5F, paramContext.getResources());
          break label642;
          if (QLog.isDevelopLevel()) {
            QLog.e(jdField_a_of_type_JavaLangString, 4, "Create item view failure by #StructMsgItemViewFactory");
          }
        }
        if (((k != 0) && (hasFlag(4))) || (this.mMsgServiceID == 91))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.subscript", 2, "StructMsgForGeneralShare use subscript structmsg bg");
          }
          paramBundle.setBackgroundResource(2130837921);
        }
        a(paramBundle, paramContext.getResources(), localBundle);
        paramContext = paramBundle;
        if ((localBundle != null) && (localBundle.getBoolean("v_crap_ctn", false))) {
          paramContext.getLayoutParams().width = -2;
        }
        if ((localBundle != null) && (localBundle.getBoolean("is_public_account_video_msg", false)))
        {
          this.mIsPAVideoStructMsg = true;
          if (!this.isMultiVideoItem) {
            paramContext.setBackgroundDrawable(null);
          }
          if (!hasFlag(4)) {
            paramContext.getLayoutParams().width = -2;
          }
        }
        paramContext.setId(2131361855);
        paramContext.setTag(2131361855, this);
        paramView = paramContext;
        if (j != 0) {
          break;
        }
        paramContext.setBackgroundDrawable(null);
        return paramContext;
        m = getItemCount();
        if (m > 0)
        {
          localObject2 = (ViewGroup)paramView;
          j = 0;
          i = 1;
          if (j < m)
          {
            AbsStructMsgElement localAbsStructMsgElement = getItemByIndex(j);
            localAbsStructMsgElement.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramOnLongClickAndTouchListener);
            if ((this.uin != null) && (!this.uin.equalsIgnoreCase(localAbsStructMsgElement.t))) {
              localAbsStructMsgElement.t = this.uin;
            }
            if (localAbsStructMsgElement.a() == 0)
            {
              if (j == 0) {
                localAbsStructMsgElement.a(1);
              }
              if (j == m - 1) {
                localAbsStructMsgElement.a(2);
              }
            }
            paramBundle = ((ViewGroup)localObject2).getChildAt(j);
            if ((localAbsStructMsgElement instanceof StructMsgItemLayout8))
            {
              paramBundle = localAbsStructMsgElement.a(paramContext, paramBundle, localBundle);
              if (j + 2 < m)
              {
                localObject1 = getItemByIndex(j + 2);
                if ((((AbsStructMsgItem)localObject1).a.size() != 0) && (paramBundle != null) && ((((localObject1 instanceof StructMsgItemLayoutDefault)) && ((((StructMsgItemLayoutDefault)localObject1).a.get(0) instanceof StructMsgItemMore))) || (((localObject1 instanceof StructMsgItemLayout3)) && ((((StructMsgItemLayout3)localObject1).a.get(0) instanceof StructMsgItemButton)))))
                {
                  localObject1 = (ViewGroup.MarginLayoutParams)paramBundle.getLayoutParams();
                  if (localObject1 != null)
                  {
                    if (!(localAbsStructMsgElement instanceof StructMsgItemLayoutDefault)) {
                      break label2811;
                    }
                    if (k == 0) {
                      break label2793;
                    }
                    ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin = AIOUtils.a(11.0F, paramContext.getResources());
                    paramBundle.setLayoutParams((ViewGroup.LayoutParams)localObject1);
                  }
                }
              }
              if ((j + 1 < m) && (paramBundle != null) && (((AbsStructMsgItem)localAbsStructMsgElement).a.size() == 1) && ((((AbsStructMsgItem)localAbsStructMsgElement).a.get(0) instanceof StructMsgItemHr)))
              {
                localObject1 = getItemByIndex(j + 1);
                if ((((AbsStructMsgItem)localObject1).a.size() != 0) && ((localObject1 instanceof StructMsgItemLayout3)) && ((((StructMsgItemLayout3)localObject1).a.get(0) instanceof StructMsgItemButton))) {
                  paramBundle.setPadding(2, paramBundle.getPaddingTop(), 2, paramBundle.getPaddingBottom());
                }
              }
              if (paramBundle == null) {
                break label2850;
              }
              if ((!TextUtils.isEmpty(localAbsStructMsgElement.c)) || ((localAbsStructMsgElement instanceof StructMsgItemLayout28)))
              {
                paramBundle.setTag(localAbsStructMsgElement);
                paramBundle.setClickable(true);
                paramBundle.setOnClickListener(localAbsStructMsgElement);
                paramBundle.setOnLongClickListener(new aimk(this, paramOnLongClickAndTouchListener));
                paramBundle.setOnTouchListener(new aiml(this, paramOnLongClickAndTouchListener));
                clickedItemIndex = 0;
              }
            }
            for (;;)
            {
              j += 1;
              break;
              if ((localAbsStructMsgElement instanceof StructMsgItemLayout9))
              {
                paramBundle = localAbsStructMsgElement.a(paramContext, paramBundle, localBundle);
                break label1880;
              }
              if ((localAbsStructMsgElement instanceof StructMsgItemLayout12))
              {
                paramBundle = localAbsStructMsgElement.a(paramContext, paramBundle, localBundle);
                i = 0;
                break label1880;
              }
              if ((localAbsStructMsgElement instanceof StructMsgItemLayout5))
              {
                if (j + 1 < m) {
                  ((StructMsgItemLayout5)localAbsStructMsgElement).a = true;
                }
                for (this.isMultiVideoItem = true;; this.isMultiVideoItem = false)
                {
                  if (k == 0) {
                    break label2349;
                  }
                  paramBundle = new StructMsgItemLayout5Adapter((AbsStructMsgItem)localAbsStructMsgElement, paramContext, j).a(paramContext, paramBundle, localBundle);
                  break;
                  ((StructMsgItemLayout5)localAbsStructMsgElement).a = false;
                }
                paramBundle = localAbsStructMsgElement.a(paramContext, paramBundle, localBundle);
                break label1880;
              }
              if ((localAbsStructMsgElement instanceof StructMsgItemLayout6))
              {
                if (k != 0)
                {
                  paramBundle = new StructMsgItemLayout6Adapter((AbsStructMsgItem)localAbsStructMsgElement, paramContext, j).a(paramContext, paramBundle, localBundle);
                  break label1880;
                }
                paramBundle = localAbsStructMsgElement.a(paramContext, paramBundle, localBundle);
                break label1880;
              }
              if ((localAbsStructMsgElement instanceof StructMsgItemLayout4))
              {
                localObject1 = localAbsStructMsgElement.a(paramContext, paramBundle, localBundle);
                paramBundle = (Bundle)localObject1;
                if (k == 0) {
                  break label2925;
                }
                a(paramContext, j, (View)localObject1);
                paramBundle = (Bundle)localObject1;
                break label1880;
              }
              if ((localAbsStructMsgElement instanceof StructMsgItemLayout18))
              {
                paramBundle = localAbsStructMsgElement.a(paramContext, paramBundle, localBundle);
                i = 0;
                break label1880;
              }
              if ((localAbsStructMsgElement instanceof StructMsgItemLayout19))
              {
                paramBundle = localAbsStructMsgElement.a(paramContext, paramBundle, localBundle);
                i = 0;
                break label1880;
              }
              if ((localAbsStructMsgElement instanceof StructMsgItemLayout2))
              {
                if ((this.mMsgServiceID == 83) || (this.mMsgServiceID == 108) || (this.mMsgServiceID == 114) || (this.mMsgServiceID == 116))
                {
                  localObject1 = new StructMsgItemLayoutNew2();
                  ((StructMsgItemLayoutNew2)localObject1).jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg = this;
                  ((StructMsgItemLayoutNew2)localObject1).jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramOnLongClickAndTouchListener);
                  paramBundle = ((StructMsgItemLayoutNew2)localObject1).a(paramContext, paramBundle, localBundle);
                  i = 0;
                  break label1880;
                }
                localObject1 = localAbsStructMsgElement.a(paramContext, paramBundle, localBundle);
                paramBundle = (Bundle)localObject1;
                if (localObject1 == null) {
                  break label2925;
                }
                ((View)localObject1).setTag(jdField_a_of_type_Int, localAbsStructMsgElement);
                paramBundle = (Bundle)localObject1;
                break label1880;
              }
              if ((localAbsStructMsgElement instanceof StructMsgItemLayout20))
              {
                paramBundle = localAbsStructMsgElement.a(paramContext, paramBundle, localBundle);
                break label1880;
              }
              if ((localAbsStructMsgElement instanceof StructMsgItemLayout26))
              {
                paramBundle = localAbsStructMsgElement.a(paramContext, paramBundle, localBundle);
                i = 0;
                break label1880;
              }
              if ((localAbsStructMsgElement instanceof StructMsgItemLayout27))
              {
                paramBundle = localAbsStructMsgElement.a(paramContext, paramBundle, localBundle);
                i = 0;
                break label1880;
              }
              if ((localAbsStructMsgElement instanceof StructMsgItemLayout28))
              {
                paramBundle = localAbsStructMsgElement.a(paramContext, paramBundle, localBundle);
                i = 0;
                break label1880;
              }
              if ((localAbsStructMsgElement instanceof StructMsgItemLayout29))
              {
                localAbsStructMsgElement.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg = this;
                paramBundle = localAbsStructMsgElement.a(paramContext, paramBundle, localBundle);
                i = 0;
                break label1880;
              }
              paramBundle = localAbsStructMsgElement.a(paramContext, paramBundle, localBundle);
              break label1880;
              ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin = AIOUtils.a(16.0F, paramContext.getResources());
              break label2013;
              label2811:
              if ((!(localAbsStructMsgElement instanceof StructMsgItemLayout6)) || (StructMsgItemLayout6Adapter.a((AbsStructMsgItem)localAbsStructMsgElement, j))) {
                break label2013;
              }
              ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin = AIOUtils.a(7.5F, paramContext.getResources());
              break label2013;
              if (QLog.isDevelopLevel()) {
                QLog.e(jdField_a_of_type_JavaLangString, 4, "Create item view failure by #StructMsgItemViewFactory");
              }
            }
          }
        }
        for (;;)
        {
          if ((k != 0) && (hasFlag(4)))
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.subscript", 2, "StructMsgForGeneralShare use subscript structmsg bg");
            }
            paramView.setBackgroundResource(2130837921);
          }
          a(paramView, paramContext.getResources(), localBundle);
          paramContext = paramView;
          j = i;
          break;
          break label1880;
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
      Object localObject1 = (AbsStructMsgElement)paramContext.next();
      if (!(localObject1 instanceof StructMsgItemLayout3)) {
        break;
      }
      localObject1 = (StructMsgItemLayout3)localObject1;
      if (((StructMsgItemLayout3)localObject1).a == null) {
        break;
      }
      localObject1 = ((StructMsgItemLayout3)localObject1).a.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (AbsStructMsgElement)((Iterator)localObject1).next();
        if ((localObject2 instanceof StructMsgItemButton))
        {
          localObject2 = (StructMsgItemButton)localObject2;
          if (((StructMsgItemButton)localObject2).b()) {
            ((StructMsgItemButton)localObject2).a(paramMessageRecord.getExtInfoFromExtStr("order_pay_state_" + ((StructMsgItemButton)localObject2).F), paramMessageRecord, this);
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
          localObject = ((StructMsgItemLayout3)localObject).a.iterator();
        }
        localAbsStructMsgElement = (AbsStructMsgElement)((Iterator)localObject).next();
      } while ((!(localAbsStructMsgElement instanceof StructMsgItemButton)) || (!((StructMsgItemButton)localAbsStructMsgElement).b()));
      return true;
    }
    return false;
  }
  
  protected boolean parseContentNode(StructMsgNode paramStructMsgNode)
  {
    if (paramStructMsgNode == null) {
      return true;
    }
    Object localObject;
    if ("item".equals(paramStructMsgNode.jdField_b_of_type_JavaLangString)) {
      localObject = paramStructMsgNode.a("layout");
    }
    for (;;)
    {
      try
      {
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          i = Integer.parseInt((String)localObject);
        }
      }
      catch (NumberFormatException paramStructMsgNode)
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
        localObject = StructMsgElementFactory.a(j);
        if (localObject != null) {
          break;
        }
        return true;
      }
      catch (NumberFormatException paramStructMsgNode)
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
      localObject = StructMsgElementFactory.a(paramStructMsgNode.jdField_b_of_type_JavaLangString);
    }
    ((AbsStructMsgElement)localObject).jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg = this;
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
    label363:
    int j;
    try
    {
      k = paramObjectInput.readInt();
      this.mVersion = k;
      if (k != 1) {
        break label363;
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
    catch (IOException paramObjectInput)
    {
      int k;
      Object localObject1;
      int m;
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
        if (k >= 3)
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
            localObject1 = (AbsStructMsgElement)this.mStructMsgItemLists.get(i);
            ((AbsStructMsgElement)localObject1).jdField_a_of_type_Long = this.msgId;
            ((AbsStructMsgElement)localObject1).d = this.mPromotionType;
            i += 1;
          }
          if (k >= 4)
          {
            this.dynamicMsgMergeKey = paramObjectInput.readUTF();
            this.dynamicMsgMergeIndex = paramObjectInput.readInt();
            if (k >= 5)
            {
              this.source_puin = paramObjectInput.readUTF();
              if (k >= 6)
              {
                this.mSType = paramObjectInput.readUTF();
                if (k >= 7)
                {
                  this.adverSign = paramObjectInput.readInt();
                  this.adverKey = paramObjectInput.readUTF();
                  this.index = paramObjectInput.readUTF();
                  this.index_name = paramObjectInput.readUTF();
                  this.index_type = paramObjectInput.readUTF();
                  this.bid = paramObjectInput.readLong();
                  this.pid = paramObjectInput.readUTF();
                  this.pVersion = paramObjectInput.readLong();
                  this.isFull = paramObjectInput.readBoolean();
                  this.likeNum = paramObjectInput.readLong();
                  this.commentNum = paramObjectInput.readLong();
                  this.isLike = paramObjectInput.readBoolean();
                  this.author = paramObjectInput.readUTF();
                  this.rijAlbumActionData = paramObjectInput.readUTF();
                  if (k >= 8)
                  {
                    this.mArticleIds = paramObjectInput.readUTF();
                    this.mOrangeWord = paramObjectInput.readUTF();
                    this.mAlgorithmIds = paramObjectInput.readUTF();
                    this.mStrategyIds = paramObjectInput.readUTF();
                    if (k >= 9)
                    {
                      this.mExtraData = paramObjectInput.readUTF();
                      this.mCreateTime = paramObjectInput.readUTF();
                      this.mTagName = paramObjectInput.readUTF();
                      if (k >= 10)
                      {
                        eventId = paramObjectInput.readUTF();
                        remindBrief = paramObjectInput.readUTF();
                        eventType = paramObjectInput.readUTF();
                        if (k >= 11)
                        {
                          tips = paramObjectInput.readUTF();
                          if (k >= 12)
                          {
                            this.mInnerUniqIds = paramObjectInput.readUTF();
                            if (k >= 13)
                            {
                              this.mSourceThirdName = paramObjectInput.readUTF();
                              this.mQQStoryExtra = paramObjectInput.readUTF();
                              this.mNeedRound = paramObjectInput.readUTF();
                              if (k >= 14)
                              {
                                this.mQidianBulkTaskId = paramObjectInput.readUTF();
                                this.reportEventFolderStatusValue = paramObjectInput.readUTF();
                                if (k >= 15)
                                {
                                  this.forwardType = paramObjectInput.readInt();
                                  this.shareData.readExternal(paramObjectInput);
                                  if ((k >= 16) && (k >= 17))
                                  {
                                    this.mAdSourceName = paramObjectInput.readUTF();
                                    this.mCommonData = paramObjectInput.readUTF();
                                    if (k >= 18)
                                    {
                                      this.animResId = paramObjectInput.readUTF();
                                      this.atMembers = paramObjectInput.readUTF();
                                      if (k >= 19)
                                      {
                                        this.mMergeSeq = paramObjectInput.readUTF();
                                        this.mSortKey = paramObjectInput.readLong();
                                        if (k >= 21)
                                        {
                                          this.mTribeShortVideoExtra = paramObjectInput.readUTF();
                                          continue;
                                          this.mMsgException = true;
                                          continue;
                                          if (!this.mSourceName.equalsIgnoreCase("看点")) {
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
    if ((!this.mHasSource) && ((!TextUtils.isEmpty(this.mSourceName)) || (!TextUtils.isEmpty(this.mSourceIcon)))) {
      this.mHasSource = true;
    }
    if ((!this.mHasAdSource) && (!TextUtils.isEmpty(this.mAdSourceName))) {
      this.mHasAdSource = true;
    }
    if (this.mSourceName != null) {
      if (this.mSourceName.equalsIgnoreCase("订阅号"))
      {
        this.mMsgServiceID = 54;
        return;
        if (k >= 2)
        {
          this.mMsgTemplateID = paramObjectInput.readInt();
          this.mMsgAction = paramObjectInput.readUTF();
          this.mMsgActionData = paramObjectInput.readUTF();
          this.mMsg_A_ActionData = paramObjectInput.readUTF();
          this.mMsg_I_ActionData = paramObjectInput.readUTF();
          this.mMsgUrl = paramObjectInput.readUTF();
          this.mMsgBrief = paramObjectInput.readUTF();
          m = paramObjectInput.readInt();
          j = 0;
          i = 1;
        }
      }
    }
    for (;;)
    {
      if (j < m)
      {
        localObject1 = paramObjectInput.readUTF();
        if ("item".equals(localObject1)) {
          localObject1 = StructMsgElementFactory.a(paramObjectInput.readInt());
        }
        for (;;)
        {
          if (localObject1 == null) {
            break label1500;
          }
          ((AbsStructMsgElement)localObject1).t = this.uin;
          ((AbsStructMsgElement)localObject1).jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg = this;
          ((AbsStructMsgElement)localObject1).a(paramObjectInput);
          Object localObject2 = (AbsStructMsgItem)localObject1;
          if ((((AbsStructMsgItem)localObject2).a.size() == 1) && (((AbsStructMsgElement)((AbsStructMsgItem)localObject2).a.get(0)).jdField_a_of_type_JavaLangString.equals("hr"))) {
            break;
          }
          ((AbsStructMsgElement)localObject1).s = String.valueOf(i);
          i += 1;
          addItem((AbsStructMsgElement)localObject1);
          ((AbsStructMsgElement)localObject1).a(this);
          break label1504;
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
      }
      label1500:
      return;
      label1504:
      j += 1;
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
          ((FragmentActivity)paramContext).getChatFragment().a().jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.notifyDataSetChanged();
        }
        ThreadManager.post(new aimp(this, localAppRuntime), 5, null, false);
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
    AbsStructMsgElement localAbsStructMsgElement = findXmlNode("progress");
    if ((localAbsStructMsgElement != null) && ((localAbsStructMsgElement instanceof StructMsgItemProgress))) {
      ((StructMsgItemProgress)localAbsStructMsgElement).b(paramInt);
    }
  }
  
  @Deprecated
  public void setSummary(String paramString)
  {
    AbsStructMsgElement localAbsStructMsgElement = findXmlNode("summary");
    if ((localAbsStructMsgElement != null) && ((localAbsStructMsgElement instanceof StructMsgItemSummary))) {
      ((StructMsgItemSummary)localAbsStructMsgElement).a(paramString);
    }
  }
  
  @Deprecated
  public void setTitle(String paramString)
  {
    AbsStructMsgElement localAbsStructMsgElement = findXmlNode("title");
    if ((localAbsStructMsgElement != null) && ((localAbsStructMsgElement instanceof StructMsgItemTitle))) {
      ((StructMsgItemTitle)localAbsStructMsgElement).a(paramString);
    }
  }
  
  public void symbol2CharactorForSmallEmoji(AbsStructMsgElement paramAbsStructMsgElement)
  {
    if ((paramAbsStructMsgElement == null) || (!(paramAbsStructMsgElement instanceof StructMsgItemLayout2))) {}
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
      paramAbsStructMsgElement = ((StructMsgItemLayout2)paramAbsStructMsgElement).a;
      if ((paramAbsStructMsgElement != null) && (paramAbsStructMsgElement.size() != 0))
      {
        Object localObject1 = paramAbsStructMsgElement.iterator();
        paramAbsStructMsgElement = null;
        Object localObject2;
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = (AbsStructMsgElement)((Iterator)localObject1).next();
          if (!(localObject2 instanceof StructMsgItemSummary)) {
            break label476;
          }
          paramAbsStructMsgElement = (StructMsgItemSummary)localObject2;
        }
        for (;;)
        {
          break label39;
          if (paramAbsStructMsgElement == null) {
            break label477;
          }
          localObject2 = paramAbsStructMsgElement.b();
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
            EmoticonManager localEmoticonManager = (EmoticonManager)((QQAppInterface)localObject1).getManager(13);
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
                  localObject1 = EmosmUtils.a((char[])localObject1);
                  localObject2 = "[小表情]";
                  if (localEmoticonManager == null) {
                    break label464;
                  }
                }
              }
            }
            for (localObject1 = localEmoticonManager.a(Integer.toString(localObject1[0]), Integer.toString(localObject1[1]));; localObject1 = null)
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
              paramAbsStructMsgElement.a(localStringBuilder.toString());
              return;
            }
            localObject1 = null;
          }
          break;
        }
      }
    }
  }
  
  public void toContentXml(AbsStructMsg.XmlSerializerWithFilter paramXmlSerializerWithFilter)
  {
    Iterator localIterator = iterator();
    while (localIterator.hasNext()) {
      ((AbsStructMsgElement)localIterator.next()).a(paramXmlSerializerWithFilter);
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
        localObject = ((AbsStructMsgItem)localObject).a.iterator();
        while (((Iterator)localObject).hasNext())
        {
          AbsStructMsgElement localAbsStructMsgElement = (AbsStructMsgElement)((Iterator)localObject).next();
          if ((localAbsStructMsgElement instanceof StructMsgItemCover)) {
            ((StructMsgItemCover)localAbsStructMsgElement).u = paramString;
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
        localObject = ((AbsStructMsgItem)localObject).a.iterator();
        while (((Iterator)localObject).hasNext())
        {
          AbsStructMsgElement localAbsStructMsgElement = (AbsStructMsgElement)((Iterator)localObject).next();
          if ((localAbsStructMsgElement instanceof StructMsgItemTitle)) {
            ((StructMsgItemTitle)localAbsStructMsgElement).A = paramString1;
          } else if ((localAbsStructMsgElement instanceof StructMsgItemSummary)) {
            ((StructMsgItemSummary)localAbsStructMsgElement).A = paramString2;
          } else if ((localAbsStructMsgElement instanceof StructMsgItemCover)) {
            ((StructMsgItemCover)localAbsStructMsgElement).u = paramString3;
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
        ((AbsStructMsgElement)((Iterator)localObject).next()).a(paramObjectOutput);
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
        break label1185;
      }
      localObject = "";
      label257:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mSourceUrl != null) {
        break label1193;
      }
      localObject = "";
      label274:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mSourceAction != null) {
        break label1201;
      }
      localObject = "";
      label291:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mSourceActionData != null) {
        break label1209;
      }
      localObject = "";
      label308:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mSource_A_ActionData != null) {
        break label1217;
      }
      localObject = "";
      label325:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mSource_I_ActionData != null) {
        break label1225;
      }
      localObject = "";
      label342:
      paramObjectOutput.writeUTF((String)localObject);
      paramObjectOutput.writeInt(this.fwFlag);
      paramObjectOutput.writeInt(this.mFlag);
      if (this.mResid != null) {
        break label1233;
      }
      localObject = "";
      label379:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mFileName != null) {
        break label1241;
      }
      localObject = "";
      label396:
      paramObjectOutput.writeUTF((String)localObject);
      paramObjectOutput.writeLong(this.mFileSize);
      if (this.mCommentText != null) {
        break label1249;
      }
      localObject = "";
      label423:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mCompatibleText != null) {
        break label1257;
      }
      localObject = "";
      label440:
      paramObjectOutput.writeUTF((String)localObject);
      paramObjectOutput.writeLong(this.msgId);
      paramObjectOutput.writeInt(this.mPromotionType);
      if (this.mPromotionMsg != null) {
        break label1265;
      }
      localObject = "";
      label477:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mPromotionMenus != null) {
        break label1273;
      }
      localObject = "";
      label494:
      paramObjectOutput.writeUTF((String)localObject);
      paramObjectOutput.writeInt(this.mPromotionMenuDestructiveIndex);
      if (this.dynamicMsgMergeKey != null) {
        break label1281;
      }
      localObject = "";
      label521:
      paramObjectOutput.writeUTF((String)localObject);
      paramObjectOutput.writeInt(this.dynamicMsgMergeIndex);
      if (this.source_puin != null) {
        break label1289;
      }
      localObject = "";
      label548:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mSType != null) {
        break label1297;
      }
      localObject = "";
      label565:
      paramObjectOutput.writeUTF((String)localObject);
      paramObjectOutput.writeInt(this.adverSign);
      if (this.adverKey != null) {
        break label1305;
      }
      localObject = "";
      label592:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.index != null) {
        break label1313;
      }
      localObject = "";
      label609:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.index_name != null) {
        break label1321;
      }
      localObject = "";
      label626:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.index_type != null) {
        break label1329;
      }
      localObject = "";
      label643:
      paramObjectOutput.writeUTF((String)localObject);
      paramObjectOutput.writeLong(this.bid);
      if (this.pid != null) {
        break label1337;
      }
      localObject = "";
      label670:
      paramObjectOutput.writeUTF((String)localObject);
      paramObjectOutput.writeLong(this.pVersion);
      paramObjectOutput.writeBoolean(this.isFull);
      paramObjectOutput.writeLong(this.likeNum);
      paramObjectOutput.writeLong(this.commentNum);
      paramObjectOutput.writeBoolean(this.isLike);
      if (this.author != null) {
        break label1345;
      }
      localObject = "";
      label737:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.rijAlbumActionData != null) {
        break label1353;
      }
      localObject = "";
      label754:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mArticleIds != null) {
        break label1361;
      }
      localObject = "";
      label771:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mOrangeWord != null) {
        break label1369;
      }
      localObject = "";
      label788:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mAlgorithmIds != null) {
        break label1377;
      }
      localObject = "";
      label805:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mStrategyIds != null) {
        break label1385;
      }
      localObject = "";
      label822:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mExtraData != null) {
        break label1393;
      }
      localObject = "";
      label839:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mCreateTime != null) {
        break label1401;
      }
      localObject = "";
      label856:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mTagName != null) {
        break label1409;
      }
      localObject = "";
      label873:
      paramObjectOutput.writeUTF((String)localObject);
      if (eventId != null) {
        break label1417;
      }
      localObject = "";
      label889:
      paramObjectOutput.writeUTF((String)localObject);
      if (remindBrief != null) {
        break label1424;
      }
      localObject = "";
      label905:
      paramObjectOutput.writeUTF((String)localObject);
      if (eventType != null) {
        break label1431;
      }
      localObject = "";
      label921:
      paramObjectOutput.writeUTF((String)localObject);
      if (tips != null) {
        break label1438;
      }
      localObject = "";
      label937:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mInnerUniqIds != null) {
        break label1445;
      }
      localObject = "";
      label954:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mSourceThirdName != null) {
        break label1453;
      }
      localObject = "";
      label971:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mQQStoryExtra != null) {
        break label1461;
      }
      localObject = "";
      label988:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mNeedRound != null) {
        break label1469;
      }
      localObject = "";
      label1005:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mQidianBulkTaskId != null) {
        break label1477;
      }
      localObject = "";
      label1022:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.reportEventFolderStatusValue != null) {
        break label1485;
      }
      localObject = "";
      label1039:
      paramObjectOutput.writeUTF((String)localObject);
      paramObjectOutput.writeInt(this.forwardType);
      this.shareData.writeExternal(paramObjectOutput);
      if (this.mAdSourceName != null) {
        break label1493;
      }
      localObject = "";
      label1074:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mCommonData != null) {
        break label1501;
      }
      localObject = "";
      label1091:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.animResId != null) {
        break label1509;
      }
      localObject = "";
      label1108:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.atMembers != null) {
        break label1517;
      }
      localObject = "";
      label1125:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mMergeSeq != null) {
        break label1525;
      }
      localObject = "";
      label1142:
      paramObjectOutput.writeUTF((String)localObject);
      paramObjectOutput.writeLong(this.mSortKey);
      if (this.mTribeShortVideoExtra != null) {
        break label1533;
      }
    }
    label1185:
    label1193:
    label1201:
    label1209:
    label1217:
    label1225:
    label1233:
    label1241:
    label1249:
    label1257:
    label1265:
    label1273:
    label1533:
    for (localObject = "";; localObject = this.mTribeShortVideoExtra)
    {
      paramObjectOutput.writeUTF((String)localObject);
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
      localObject = this.dynamicMsgMergeKey;
      break label521;
      localObject = this.source_puin;
      break label548;
      localObject = this.mSType;
      break label565;
      localObject = this.adverKey;
      break label592;
      localObject = this.index;
      break label609;
      localObject = this.index_name;
      break label626;
      localObject = this.index_type;
      break label643;
      localObject = this.pid;
      break label670;
      localObject = this.author;
      break label737;
      localObject = this.rijAlbumActionData;
      break label754;
      localObject = this.mArticleIds;
      break label771;
      localObject = this.mOrangeWord;
      break label788;
      localObject = this.mAlgorithmIds;
      break label805;
      localObject = this.mStrategyIds;
      break label822;
      localObject = this.mExtraData;
      break label839;
      localObject = this.mCreateTime;
      break label856;
      localObject = this.mTagName;
      break label873;
      localObject = eventId;
      break label889;
      localObject = remindBrief;
      break label905;
      localObject = eventType;
      break label921;
      localObject = tips;
      break label937;
      localObject = this.mInnerUniqIds;
      break label954;
      localObject = this.mSourceThirdName;
      break label971;
      localObject = this.mQQStoryExtra;
      break label988;
      localObject = this.mNeedRound;
      break label1005;
      localObject = this.mQidianBulkTaskId;
      break label1022;
      localObject = this.reportEventFolderStatusValue;
      break label1039;
      localObject = this.mAdSourceName;
      break label1074;
      localObject = this.mCommonData;
      break label1091;
      localObject = this.animResId;
      break label1108;
      localObject = this.atMembers;
      break label1125;
      localObject = this.mMergeSeq;
      break label1142;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.StructMsgForGeneralShare
 * JD-Core Version:    0.7.0.1
 */