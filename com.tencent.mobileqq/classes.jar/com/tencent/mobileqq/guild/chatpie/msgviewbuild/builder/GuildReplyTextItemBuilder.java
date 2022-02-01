package com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint.Style;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.etrump.mixlayout.ETLayout;
import com.etrump.mixlayout.ETTextView;
import com.etrump.mixlayout.VasShieldFont;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.item.ChatThumbView;
import com.tencent.mobileqq.activity.aio.item.ReplyTextItemBuilder;
import com.tencent.mobileqq.activity.aio.item.ReplyTextItemBuilder.SourceMessagePulledCallBack;
import com.tencent.mobileqq.activity.selectable.AIOSelectableDelegateProxy;
import com.tencent.mobileqq.activity.selectable.SelectableComponent;
import com.tencent.mobileqq.activity.selectable.SelectableLinearLayout;
import com.tencent.mobileqq.adapter.ChatHistoryStructAdapter;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ark.api.IArkMsgReplyMgr;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.HasSourceMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForLongTextMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageForVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.chatpie.GuildMsgItemBuildFactory;
import com.tencent.mobileqq.guild.chatpie.Util.GuildTimeFormatterUtils;
import com.tencent.mobileqq.guild.chatpie.msgviewbuild.baseview.GuildMsgItemLayout;
import com.tencent.mobileqq.pic.api.IPicFlash;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.mobileqq.text.ColorNickText;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.ColorNickManager;
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class GuildReplyTextItemBuilder
  extends GuildTextItemBuild
{
  public GuildReplyTextItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.a = new GuildReplyItemClickListener(this);
  }
  
  public static ViewGroup a(Context paramContext, ViewGroup paramViewGroup)
  {
    Object localObject = (TextView)paramViewGroup.findViewById(2131439121);
    ((TextView)localObject).setAlpha(0.35F);
    ((TextView)localObject).setEditableFactory(QQTextBuilder.EMOCTATION_FACORY);
    ((TextView)localObject).setSpannableFactory(QQText.SPANNABLE_FACTORY);
    localObject = (TextView)paramViewGroup.findViewById(2131447354);
    ((TextView)localObject).setAlpha(0.35F);
    ((TextView)localObject).setEditableFactory(QQTextBuilder.EMOCTATION_FACORY);
    ((TextView)localObject).setSpannableFactory(QQText.SPANNABLE_FACTORY);
    ((ImageView)paramViewGroup.findViewById(2131436449)).setColorFilter(null);
    localObject = (ETTextView)paramViewGroup.findViewById(2131438908);
    ((ETTextView)localObject).setAlpha(0.35F);
    ((ETTextView)localObject).setEditableFactory(QQTextBuilder.EMOCTATION_FACORY);
    ((ETTextView)localObject).setSpannableFactory(QQText.SPANNABLE_FACTORY);
    ((ETTextView)localObject).setMaxLines(2);
    ((ETTextView)localObject).setEllipsize(TextUtils.TruncateAt.END);
    ((ETTextView)localObject).setLineSpacing(AIOUtils.b(2.0F, paramContext.getResources()), 1.0F);
    localObject = (ETTextView)paramViewGroup.findViewById(2131438922);
    ((ETTextView)localObject).setTextSize(16.666666F);
    ((ETTextView)localObject).setEditableFactory(QQTextBuilder.EMOCTATION_FACORY);
    ((ETTextView)localObject).setSpannableFactory(QQText.SPANNABLE_FACTORY);
    ((ETTextView)localObject).setMaxLines(2);
    ((ETTextView)localObject).setEllipsize(TextUtils.TruncateAt.END);
    ((ETTextView)localObject).setLineSpacing(AIOUtils.b(2.0F, paramContext.getResources()), 1.0F);
    return paramViewGroup;
  }
  
  private static GuildReplyTextItemBuilder.MixedMessageInfo a(MessageForMixedMsg paramMessageForMixedMsg)
  {
    int m = 0;
    Object localObject2 = "";
    int j = 0;
    boolean bool1 = false;
    Object localObject3 = null;
    int n = 0;
    Object localObject1;
    Object localObject4;
    int i;
    boolean bool2;
    for (;;)
    {
      localObject1 = localObject3;
      localObject4 = localObject2;
      i = j;
      bool2 = bool1;
      if (m >= paramMessageForMixedMsg.msgElemList.size()) {
        break;
      }
      int k;
      if (!(paramMessageForMixedMsg.msgElemList.get(m) instanceof MessageForText))
      {
        k = n;
        localObject4 = localObject2;
        i = j;
        if (!(paramMessageForMixedMsg.msgElemList.get(m) instanceof MessageForReplyText)) {}
      }
      else
      {
        k = n;
        localObject4 = localObject2;
        i = j;
        if (n == 0)
        {
          if ((paramMessageForMixedMsg.msgElemList.get(m) instanceof MessageForText))
          {
            localObject4 = (MessageForText)paramMessageForMixedMsg.msgElemList.get(m);
            if (((MessageForText)localObject4).sb != null)
            {
              localObject1 = ((MessageForText)localObject4).sb.toString();
            }
            else
            {
              localObject1 = localObject2;
              if (((MessageForText)localObject4).msg != null) {
                localObject1 = ((MessageForText)localObject4).msg;
              }
            }
          }
          else
          {
            localObject1 = localObject2;
            if ((paramMessageForMixedMsg.msgElemList.get(m) instanceof MessageForReplyText))
            {
              localObject1 = localObject2;
              if (((MessageForReplyText)paramMessageForMixedMsg.msgElemList.get(m)).sb != null)
              {
                localObject4 = (MessageForReplyText)paramMessageForMixedMsg.msgElemList.get(m);
                if (((MessageForReplyText)localObject4).sb != null)
                {
                  localObject1 = ((MessageForReplyText)localObject4).sb.toString();
                }
                else
                {
                  localObject1 = localObject2;
                  if (((MessageForReplyText)localObject4).msg != null) {
                    localObject1 = ((MessageForReplyText)localObject4).msg;
                  }
                }
              }
            }
          }
          k = n;
          localObject4 = localObject1;
          i = j;
          if (!android.text.TextUtils.isEmpty((CharSequence)localObject1))
          {
            k = n;
            localObject4 = localObject1;
            i = j;
            if (!((String)localObject1).equals("\n")) {
              if (bool1)
              {
                k = 1;
                i = 2;
                localObject4 = localObject1;
              }
              else
              {
                k = 1;
                i = 1;
                localObject4 = localObject1;
              }
            }
          }
        }
      }
      localObject1 = localObject3;
      bool2 = bool1;
      if ((paramMessageForMixedMsg.msgElemList.get(m) instanceof MessageForPic))
      {
        localObject1 = localObject3;
        bool2 = bool1;
        if (!bool1)
        {
          localObject1 = (MessageForPic)paramMessageForMixedMsg.msgElemList.get(m);
          MessageForMixedMsg.copyBaseInfoFromMixedToPic((MessageForPic)localObject1, paramMessageForMixedMsg);
          if (k != 0)
          {
            bool2 = true;
            break;
          }
          bool2 = true;
        }
      }
      m += 1;
      n = k;
      localObject3 = localObject1;
      localObject2 = localObject4;
      j = i;
      bool1 = bool2;
    }
    return new GuildReplyTextItemBuilder.MixedMessageInfo((MessageForPic)localObject1, (String)localObject4, i, bool2);
  }
  
  public static final void a(Context paramContext, QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, MessageForReplyText.SourceMsgInfo paramSourceMsgInfo, String paramString, int paramInt, MessageRecord paramMessageRecord, boolean paramBoolean, SessionInfo paramSessionInfo)
  {
    if (((paramMessageRecord instanceof MessageForReplyText)) && (QLog.isColorLevel()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setReplySourceViewGroup ReplyItemBuilder reply:");
      localStringBuilder.append(paramMessageRecord);
      localStringBuilder.append(" sourceMsg=");
      localStringBuilder.append(((MessageForReplyText)paramMessageRecord).getSourceMessage());
      QLog.d("GuildReplyTextItemBuilder", 2, localStringBuilder.toString());
    }
    a(paramQQAppInterface, paramViewGroup, paramSourceMsgInfo, paramSessionInfo.c);
    b(paramContext, paramQQAppInterface, paramViewGroup, paramSourceMsgInfo, paramString, paramInt, paramMessageRecord, paramBoolean, paramSessionInfo);
  }
  
  protected static void a(Context paramContext, QQAppInterface paramQQAppInterface, ChatThumbView paramChatThumbView, MessageRecord paramMessageRecord, ReplyTextItemBuilder.SourceMessagePulledCallBack paramSourceMessagePulledCallBack)
  {
    ThreadManager.post(new GuildReplyTextItemBuilder.3(paramMessageRecord, paramQQAppInterface, paramSourceMessagePulledCallBack, paramContext, paramChatThumbView), 8, null, true);
  }
  
  protected static void a(Context paramContext, QQAppInterface paramQQAppInterface, BubbleImageView paramBubbleImageView, MessageRecord paramMessageRecord, MessageForReplyText.SourceMsgInfo paramSourceMsgInfo, ETTextView paramETTextView1, ETTextView paramETTextView2, int paramInt, String paramString)
  {
    b(paramContext, paramQQAppInterface, paramBubbleImageView, paramMessageRecord, new GuildReplyTextItemBuilder.2(paramSourceMsgInfo, paramBubbleImageView, paramETTextView2, paramETTextView1, paramInt, paramString, paramMessageRecord));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, TextView paramTextView, MessageRecord paramMessageRecord, String paramString)
  {
    int i;
    if ((paramMessageRecord instanceof MessageForStructing))
    {
      if (ChatHistoryStructAdapter.a(paramMessageRecord))
      {
        if (Build.VERSION.SDK_INT >= 21) {
          paramString = paramContext.getDrawable(2130845682);
        } else {
          paramString = paramContext.getResources().getDrawable(2130845682);
        }
        paramMessageRecord = (MessageForStructing)paramMessageRecord;
        paramQQAppInterface = paramString;
        if (paramMessageRecord.structingMsg == null) {
          break label442;
        }
        paramMessageRecord = paramMessageRecord.structingMsg.mMsgUrl;
        paramQQAppInterface = ((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).getTDDocFileThumbUrl(paramMessageRecord);
        i = AIOUtils.b(15.0F, paramContext.getResources());
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mLoadingDrawable = paramString;
        localURLDrawableOptions.mFailedDrawable = paramString;
        localURLDrawableOptions.mRequestWidth = i;
        localURLDrawableOptions.mRequestHeight = i;
        localURLDrawableOptions.mUseAutoScaleParams = false;
        if (!android.text.TextUtils.isEmpty(paramQQAppInterface))
        {
          paramQQAppInterface = URLDrawable.getDrawable(paramQQAppInterface, localURLDrawableOptions);
          paramQQAppInterface.setBounds(0, 0, i, i);
          break label442;
        }
        paramQQAppInterface = paramString;
        if (android.text.TextUtils.isEmpty(paramMessageRecord)) {
          break label442;
        }
        paramQQAppInterface = paramString;
        if (!paramMessageRecord.contains("docs.qq.com/desktop/m")) {
          break label442;
        }
        paramQQAppInterface = URLDrawable.getDrawable("https://docs.qq.com/desktop/favicon.ico", localURLDrawableOptions);
        paramQQAppInterface.setBounds(0, 0, i, i);
        break label442;
      }
    }
    else if ((paramMessageRecord instanceof MessageForArkApp))
    {
      try
      {
        paramMessageRecord = ((MessageForArkApp)paramMessageRecord).ark_app_message;
        if ((paramMessageRecord == null) || (!((IArkMsgReplyMgr)QRoute.api(IArkMsgReplyMgr.class)).canReply(paramMessageRecord.appName, paramMessageRecord.appView))) {
          break label440;
        }
        if (Build.VERSION.SDK_INT >= 21) {
          paramQQAppInterface = paramContext.getDrawable(2130845682);
        } else {
          paramQQAppInterface = paramContext.getResources().getDrawable(2130845682);
        }
        paramMessageRecord = (String)((IArkMsgReplyMgr)QRoute.api(IArkMsgReplyMgr.class)).getReplyConfigFromMsg(new JSONObject(paramMessageRecord.toAppXml())).get("kArkMsgReplyIcon");
        i = AIOUtils.b(15.0F, paramContext.getResources());
        paramString = URLDrawable.URLDrawableOptions.obtain();
        paramString.mLoadingDrawable = paramQQAppInterface;
        paramString.mFailedDrawable = paramQQAppInterface;
        paramString.mRequestWidth = i;
        paramString.mRequestHeight = i;
        paramString.mUseAutoScaleParams = false;
        if (android.text.TextUtils.isEmpty(paramMessageRecord)) {
          break label437;
        }
        paramQQAppInterface = URLDrawable.getDrawable(paramMessageRecord, paramString);
        try
        {
          paramQQAppInterface.setBounds(0, 0, i, i);
        }
        catch (Exception paramMessageRecord) {}
        paramString = new StringBuilder();
      }
      catch (Exception paramMessageRecord)
      {
        paramQQAppInterface = null;
      }
      paramString.append("handle MessageForArkApp error!");
      paramString.append(paramMessageRecord.getMessage());
      QLog.e("GuildReplyTextItemBuilder", 1, paramString.toString());
      label437:
      break label442;
    }
    label440:
    paramQQAppInterface = null;
    label442:
    if (paramQQAppInterface != null)
    {
      i = AIOUtils.b(15.0F, paramContext.getResources());
      int j = AIOUtils.b(4.0F, paramContext.getResources());
      paramQQAppInterface.setBounds(0, 0, i, i);
      paramTextView.setCompoundDrawables(paramQQAppInterface, null, null, null);
      paramTextView.setGravity(16);
      paramTextView.setCompoundDrawablePadding(j);
      paramTextView.setPadding(0, 0, 0, 0);
      paramTextView.invalidate();
      paramTextView.setMaxLines(1);
      paramTextView.setIncludeFontPadding(false);
      paramTextView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
      return;
    }
    paramTextView.setCompoundDrawables(null, null, null, null);
    paramTextView.setPadding(0, 0, 0, 0);
    paramTextView.setCompoundDrawablePadding(0);
    paramTextView.setMaxLines(2);
    paramTextView.setEllipsize(TextUtils.TruncateAt.END);
  }
  
  private static void a(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, MessageForReplyText.SourceMsgInfo paramSourceMsgInfo, String paramString)
  {
    paramViewGroup = (TextView)paramViewGroup.findViewById(2131439121);
    paramViewGroup.getPaint().setStyle(Paint.Style.FILL_AND_STROKE);
    paramViewGroup.getPaint().setStrokeWidth(1.0F);
    Object localObject = paramViewGroup.getTag(2131446810);
    if ((localObject != null) && (((Long)localObject).longValue() == paramSourceMsgInfo.mSourceMsgSenderUin))
    {
      paramViewGroup.setText(new ColorNickText((String)paramViewGroup.getTag(2131446809), 16).b());
      paramQQAppInterface = new LinearLayout.LayoutParams(0, -2, 1.0F);
      paramQQAppInterface.gravity = 19;
      paramViewGroup.setLayoutParams(paramQQAppInterface);
      return;
    }
    ThreadManager.excute(new GuildReplyTextItemBuilder.5(paramQQAppInterface, paramString, paramSourceMsgInfo, paramViewGroup), 64, null, true);
  }
  
  public static ViewGroup b(Context paramContext)
  {
    return a(paramContext, (ViewGroup)LayoutInflater.from(paramContext).inflate(2131625121, null));
  }
  
  private static void b(Context paramContext, QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, MessageForReplyText.SourceMsgInfo paramSourceMsgInfo, String paramString, int paramInt, MessageRecord paramMessageRecord, boolean paramBoolean, SessionInfo paramSessionInfo)
  {
    int i;
    if ((!paramBoolean) && (!ReplyTextItemBuilder.a(paramSourceMsgInfo.mSourceMsgText))) {
      i = 0;
    } else {
      i = 1;
    }
    Object localObject1 = ReplyTextItemBuilder.a(paramQQAppInterface, paramString, paramInt, paramMessageRecord, paramSourceMsgInfo);
    if (paramSourceMsgInfo.mSourceSummaryFlag == 1)
    {
      paramSessionInfo = paramSourceMsgInfo.mSourceMsgText;
      if ((localObject1 instanceof MessageForPic))
      {
        paramString = paramSessionInfo;
        if (((IPicFlash)QRoute.api(IPicFlash.class)).isFlashPicMsg((MessageRecord)localObject1))
        {
          if (paramSessionInfo != null)
          {
            paramInt = paramSessionInfo.indexOf('[');
            if (paramInt >= 0)
            {
              j = paramSessionInfo.indexOf(']');
              if (j > paramInt)
              {
                paramString = paramSessionInfo.substring(paramInt, j + 1);
                break label144;
              }
            }
          }
          paramString = HardCodeUtil.a(2131910881);
        }
        label144:
        paramInt = 0;
      }
      else
      {
        paramString = paramSessionInfo;
        paramInt = 1;
      }
    }
    else
    {
      if (((localObject1 instanceof MessageForPic)) && (i != 0) && ((paramMessageRecord instanceof HasSourceMessage))) {
        paramInt = 0;
      } else {
        paramInt = 1;
      }
      paramString = ReplyTextItemBuilder.a(paramQQAppInterface, paramSourceMsgInfo, paramMessageRecord, paramSourceMsgInfo.mSourceMsgText, (MessageRecord)localObject1);
    }
    paramSessionInfo = (SessionInfo)localObject1;
    if ((paramMessageRecord instanceof MessageForReplyText))
    {
      localObject2 = (MessageForReplyText)paramMessageRecord;
      paramSessionInfo = (SessionInfo)localObject1;
      if (((MessageForReplyText)localObject2).getSourceMessage() != null) {
        paramSessionInfo = ((MessageForReplyText)localObject2).getSourceMessage();
      }
    }
    localObject1 = paramViewGroup.findViewById(2131435246);
    if (localObject1 != null) {
      ((View)localObject1).setVisibility(8);
    }
    localObject1 = (BubbleImageView)paramViewGroup.findViewById(2131447325);
    ((BubbleImageView)localObject1).setRadius(0.0F);
    ((BubbleImageView)localObject1).setAdjustViewBounds(true);
    ((BubbleImageView)localObject1).c(false);
    ((BubbleImageView)localObject1).setShowEdge(false);
    ((BubbleImageView)localObject1).setContentDescription(HardCodeUtil.a(2131910879));
    int j = Build.VERSION.SDK_INT;
    if ((j == 19) || (j == 18)) {
      ((BubbleImageView)localObject1).w = true;
    }
    if (((BubbleImageView)localObject1).getDrawable() == null) {
      ReplyTextItemBuilder.a((ChatThumbView)localObject1, paramContext, paramSourceMsgInfo);
    }
    if (((BubbleImageView)localObject1).getTag() != paramMessageRecord)
    {
      ((BubbleImageView)localObject1).setTag(paramMessageRecord);
      ((BubbleImageView)localObject1).setVisibility(8);
    }
    Object localObject2 = (ETTextView)paramViewGroup.findViewById(2131438922);
    paramViewGroup = (ETTextView)paramViewGroup.findViewById(2131438908);
    a(paramQQAppInterface, paramContext, paramViewGroup, paramSessionInfo, paramString);
    if (paramSessionInfo != null)
    {
      b(paramSessionInfo, paramSourceMsgInfo, (BubbleImageView)localObject1, paramViewGroup, (ETTextView)localObject2, paramInt, paramString, paramMessageRecord, paramContext, paramQQAppInterface, null);
      return;
    }
    if ((i == 0) && (!ReplyTextItemBuilder.a(paramString)) && (paramSourceMsgInfo.mSourceSummaryFlag == 1))
    {
      ((BubbleImageView)localObject1).setVisibility(8);
      b(paramViewGroup, (TextView)localObject2, paramInt, paramString, null);
      a(paramContext, paramQQAppInterface, (BubbleImageView)localObject1, paramMessageRecord, paramSourceMsgInfo, (ETTextView)localObject2, paramViewGroup, paramInt, paramString);
      return;
    }
    a(paramContext, paramQQAppInterface, (ChatThumbView)localObject1, paramMessageRecord, new GuildReplyTextItemBuilder.1(paramViewGroup, (ETTextView)localObject2, paramSourceMsgInfo, (BubbleImageView)localObject1, paramInt, paramString, paramMessageRecord));
  }
  
  private static void b(Context paramContext, QQAppInterface paramQQAppInterface, ChatThumbView paramChatThumbView, MessageRecord paramMessageRecord, ReplyTextItemBuilder.SourceMessagePulledCallBack paramSourceMessagePulledCallBack)
  {
    ThreadManager.post(new GuildReplyTextItemBuilder.4(paramMessageRecord, paramQQAppInterface, paramSourceMessagePulledCallBack, paramContext, paramChatThumbView), 8, null, true);
  }
  
  private static void b(TextView paramTextView1, TextView paramTextView2, int paramInt, String paramString, MessageRecord paramMessageRecord)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    paramString = ColorNickManager.a(str, paramMessageRecord, ChatTextSizeSettingActivity.b() - 2, 7);
    if (paramInt != 0)
    {
      if (paramInt != 2)
      {
        paramTextView1.setVisibility(0);
        paramTextView1.setText(paramString);
        if (AppSetting.e) {
          paramTextView1.setContentDescription(com.tencent.mobileqq.text.TextUtils.emoticonToTextForTalkBack(str));
        }
        paramTextView2.setVisibility(8);
        return;
      }
      paramTextView2.setVisibility(0);
      paramTextView2.setText(paramString);
      if (AppSetting.e) {
        paramTextView2.setContentDescription(com.tencent.mobileqq.text.TextUtils.emoticonToTextForTalkBack(str));
      }
      paramTextView1.setVisibility(8);
      return;
    }
    paramTextView1.setVisibility(8);
    paramTextView2.setVisibility(8);
  }
  
  private static void b(MessageRecord paramMessageRecord1, MessageForReplyText.SourceMsgInfo paramSourceMsgInfo, BubbleImageView paramBubbleImageView, ETTextView paramETTextView1, ETTextView paramETTextView2, int paramInt, String paramString1, MessageRecord paramMessageRecord2, Context paramContext, QQAppInterface paramQQAppInterface, String paramString2)
  {
    boolean bool2 = paramMessageRecord1 instanceof MessageForPic;
    boolean bool1 = true;
    if (bool2)
    {
      if (!((IPicFlash)QRoute.api(IPicFlash.class)).isFlashPicMsg(paramMessageRecord1)) {
        break label54;
      }
      paramSourceMsgInfo = paramString1;
      paramInt = 1;
    }
    label54:
    label329:
    for (;;)
    {
      paramString1 = null;
      bool1 = false;
      break;
      if ((paramMessageRecord1 instanceof MessageForShortVideo))
      {
        paramSourceMsgInfo = paramString1;
        paramString1 = paramMessageRecord1;
        paramInt = 0;
        break;
      }
      if ((paramMessageRecord1 instanceof MessageForMixedMsg))
      {
        Object localObject = (MessageForMixedMsg)paramMessageRecord1;
        paramString1 = a((MessageForMixedMsg)localObject);
        bool1 = paramString1.d;
        ((MessageForMixedMsg)localObject).getPicMsgList();
        paramInt = paramString1.c;
        localObject = paramString1.a;
        if (paramString1.b == null) {
          paramString1 = "";
        } else {
          paramString1 = paramString1.b.trim();
        }
        if (!android.text.TextUtils.isEmpty(paramString2)) {
          paramString1 = paramString2;
        }
        if (paramSourceMsgInfo.mSourceSummaryFlag != 1) {
          paramString1 = paramSourceMsgInfo.mSourceMsgText;
        }
        paramSourceMsgInfo = paramString1;
        paramString1 = (String)localObject;
        break;
      }
      if ((paramMessageRecord1 instanceof MessageForLongMsg))
      {
        if (paramMessageRecord1.msgtype == -1036)
        {
          paramSourceMsgInfo = (MessageForMixedMsg)((MessageForLongMsg)paramMessageRecord1).rebuildLongMsg();
          if (paramSourceMsgInfo != null)
          {
            paramString2 = a(paramSourceMsgInfo);
            bool1 = paramString2.d;
            paramSourceMsgInfo.getPicMsgList();
            paramInt = paramString2.c;
            paramString1 = paramString2.a;
            paramSourceMsgInfo = paramString2.b;
          }
          else
          {
            paramSourceMsgInfo = paramString1;
            paramString1 = null;
            bool1 = false;
          }
          break;
        }
      }
      else if ((paramMessageRecord1 instanceof MessageForLongTextMsg))
      {
        paramString2 = (MessageForLongTextMsg)paramMessageRecord1;
        if (paramString2 != null) {
          paramString2 = paramString2.sb;
        } else {
          paramString2 = null;
        }
        if ((paramString2 != null) && (!paramSourceMsgInfo.mSourceMsgText.equals(paramString2.toString())))
        {
          paramSourceMsgInfo = paramString2.toString();
          break label329;
        }
      }
      paramSourceMsgInfo = paramString1;
    }
    if (bool1)
    {
      paramBubbleImageView.setVisibility(0);
      paramBubbleImageView.setTag(2131430593, null);
      paramString2 = (ViewGroup)paramBubbleImageView.getParent();
      if (paramString2 != null) {
        paramString2.setVisibility(0);
      }
      paramBubbleImageView.setVisibility(0);
      ReplyTextItemBuilder.a(paramContext, paramQQAppInterface, paramBubbleImageView, paramMessageRecord2, paramString1);
    }
    else
    {
      paramBubbleImageView.setVisibility(8);
    }
    b(paramETTextView1, paramETTextView2, paramInt, paramSourceMsgInfo, paramMessageRecord1);
    a(paramQQAppInterface, paramContext, paramETTextView1, paramMessageRecord1, paramSourceMsgInfo);
    paramMessageRecord1 = AIOUtils.b(paramETTextView1);
    if ((paramMessageRecord1 instanceof GuildReplyTextItemBuilder.ReplyHolder)) {
      ((GuildReplyTextItemBuilder.ReplyHolder)paramMessageRecord1).g = paramBubbleImageView;
    }
  }
  
  private static boolean b(MessageRecord paramMessageRecord)
  {
    return ((paramMessageRecord instanceof MessageForPic)) || ((paramMessageRecord instanceof MessageForFile)) || ((paramMessageRecord instanceof MessageForLongMsg)) || ((paramMessageRecord instanceof MessageForMixedMsg)) || ((paramMessageRecord instanceof MessageForShortVideo)) || ((paramMessageRecord instanceof MessageForStructing)) || ((paramMessageRecord instanceof MessageForTroopFile)) || ((paramMessageRecord instanceof MessageForVideo));
  }
  
  protected View a(Context paramContext, GuildReplyTextItemBuilder.ReplyHolder paramReplyHolder, MessageForReplyText paramMessageForReplyText)
  {
    paramMessageForReplyText = new SelectableLinearLayout(paramContext);
    paramMessageForReplyText.setOrientation(1);
    Object localObject = a(paramContext);
    paramReplyHolder.a = ((ViewGroup)localObject);
    ((ViewGroup)localObject).setId(2131430607);
    paramReplyHolder.b = ((TextView)((ViewGroup)localObject).findViewById(2131439121));
    paramReplyHolder.c = ((TextView)((ViewGroup)localObject).findViewById(2131447354));
    paramReplyHolder.e = ((ETTextView)((ViewGroup)localObject).findViewById(2131438908));
    paramReplyHolder.f = ((ETTextView)((ViewGroup)localObject).findViewById(2131438922));
    paramReplyHolder.d = ((ImageView)((ViewGroup)localObject).findViewById(2131436449));
    paramReplyHolder.d.setContentDescription(HardCodeUtil.a(2131910887));
    ((IGuildDTReportApi)QRoute.api(IGuildDTReportApi.class)).setElementExposureAndClickParams(paramReplyHolder.d, "em_aio_reply_message_position", null);
    paramReplyHolder.g = ((BubbleImageView)((ViewGroup)localObject).findViewById(2131447325));
    localObject = c();
    paramMessageForReplyText.setPadding(0, 0, 0, 0);
    ((LinearLayout.LayoutParams)localObject).topMargin = ViewUtils.dpToPx(4.666667F);
    paramMessageForReplyText.addView(paramReplyHolder.a, (ViewGroup.LayoutParams)localObject);
    localObject = new ETTextView(paramContext);
    com.tencent.mobileqq.text.TextUtils.fixTextViewANRForAnd10((TextView)localObject);
    ((ETTextView)localObject).setTextSize(16.666666F);
    ((ETTextView)localObject).setTextColor(paramContext.getResources().getColorStateList(i()));
    ((ETTextView)localObject).setEditableFactory(QQTextBuilder.EMOCTATION_FACORY);
    ((ETTextView)localObject).setSpannableFactory(QQText.SPANNABLE_FACTORY);
    ((ETTextView)localObject).setMovementMethod(LinkMovementMethod.getInstance());
    ((ETTextView)localObject).setIncludeFontPadding(false);
    ((ETTextView)localObject).setId(2131430581);
    paramReplyHolder.i = ((TextView)localObject);
    localObject = h();
    ((LinearLayout.LayoutParams)localObject).topMargin = AIOUtils.b(6.266666F, paramContext.getResources());
    paramMessageForReplyText.addView(paramReplyHolder.i, (ViewGroup.LayoutParams)localObject);
    return paramMessageForReplyText;
  }
  
  @NonNull
  protected View a(ChatMessage paramChatMessage, BaseGuildMsgViewBuild.ViewHolder paramViewHolder, View paramView, GuildMsgItemLayout paramGuildMsgItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramViewHolder = (GuildReplyTextItemBuilder.ReplyHolder)paramViewHolder;
    MessageForReplyText localMessageForReplyText = (MessageForReplyText)paramChatMessage;
    paramGuildMsgItemLayout = paramGuildMsgItemLayout.getContext();
    if (QLog.isColorLevel())
    {
      paramChatMessage = new StringBuilder();
      paramChatMessage.append("reply type is");
      paramChatMessage.append(localMessageForReplyText.mSourceMsgInfo.mType);
      QLog.d("GuildReplyTextItemBuilder", 2, paramChatMessage.toString());
    }
    paramChatMessage = paramView;
    if (paramView == null) {
      paramChatMessage = a(paramGuildMsgItemLayout, paramViewHolder, localMessageForReplyText);
    }
    boolean bool;
    if (localMessageForReplyText.mSourceMsgInfo.oriMsgType == 1) {
      bool = true;
    } else {
      bool = false;
    }
    a(paramChatMessage, paramViewHolder, paramOnLongClickAndTouchListener, localMessageForReplyText, bool);
    if (paramChatMessage != null) {
      paramChatMessage.setTag(paramViewHolder);
    }
    return paramChatMessage;
  }
  
  protected ViewGroup a(Context paramContext)
  {
    return b(paramContext);
  }
  
  protected BaseGuildMsgViewBuild.ViewHolder a()
  {
    return new GuildReplyTextItemBuilder.ReplyHolder(this);
  }
  
  protected String a(ChatMessage paramChatMessage, GuildTextItemBuild.Holder paramHolder, Context paramContext)
  {
    if ((paramChatMessage instanceof MessageForReplyText))
    {
      MessageForReplyText localMessageForReplyText = (MessageForReplyText)paramChatMessage;
      if (!android.text.TextUtils.isEmpty(localMessageForReplyText.sb))
      {
        a(paramChatMessage, localMessageForReplyText.sb, paramHolder, paramContext);
        return localMessageForReplyText.sb.toString();
      }
      paramHolder.i.setText("");
      if (QLog.isColorLevel())
      {
        paramHolder = new StringBuilder();
        paramHolder.append("textitem text.sb is null");
        paramHolder.append(paramChatMessage.msgtype);
        QLog.d("GuildReplyTextItemBuilder", 2, paramHolder.toString());
      }
    }
    return "";
  }
  
  protected void a(View paramView, GuildReplyTextItemBuilder.ReplyHolder paramReplyHolder, OnLongClickAndTouchListener paramOnLongClickAndTouchListener, MessageForReplyText paramMessageForReplyText, boolean paramBoolean)
  {
    if (paramMessageForReplyText.getSourceMsgInfo() != null) {
      localObject = Long.toString(paramMessageForReplyText.getSourceMsgInfo().mSourceMsgSenderUin);
    } else {
      localObject = "";
    }
    Object localObject = VasShieldFont.a((String)localObject);
    paramReplyHolder.b.setTypeface((Typeface)localObject);
    paramReplyHolder.b.setTextSize(13.0F);
    paramReplyHolder.b.setIncludeFontPadding(false);
    paramReplyHolder.b.getPaint().setStyle(Paint.Style.FILL_AND_STROKE);
    paramReplyHolder.e.setTypeface((Typeface)localObject);
    paramReplyHolder.f.setTypeface((Typeface)localObject);
    if (!android.text.TextUtils.isEmpty(paramMessageForReplyText.getExtInfoFromExtStr("sens_msg_ctrl_info")))
    {
      localObject = ((ETTextView)paramReplyHolder.i).getETLayout();
      if (localObject != null) {
        ((ETLayout)localObject).b = (paramMessageForReplyText.uniseq + 1L);
      }
    }
    localObject = GuildTimeFormatterUtils.a(this.b, paramMessageForReplyText.getSourceMsgInfo().mSourceMsgTime * 1000L);
    paramReplyHolder.c.setText((CharSequence)localObject);
    paramReplyHolder.c.setTextColor(Color.parseColor("#8D9AAD"));
    paramReplyHolder.c.setTextSize(12.0F);
    ((ETTextView)paramReplyHolder.i).setFont(0, paramMessageForReplyText.uniseq);
    paramReplyHolder.i.setTextSize(16.666666F);
    paramReplyHolder.i.setText(paramMessageForReplyText.sb);
    if (AppSetting.e) {
      paramReplyHolder.i.setContentDescription(com.tencent.mobileqq.text.TextUtils.emoticonToTextForTalkBack(paramMessageForReplyText.sb.toString()));
    }
    a(paramMessageForReplyText, paramReplyHolder, paramView.getContext());
    a(this.b, this.g, paramReplyHolder.a, paramMessageForReplyText.mSourceMsgInfo, paramMessageForReplyText.frienduin, paramMessageForReplyText.istroop, paramMessageForReplyText, paramBoolean, this.c);
    paramReplyHolder.a.setOnClickListener(this.a);
    paramReplyHolder.e.setOnClickListener(this.a);
    paramReplyHolder.d.setOnClickListener(this.a);
    paramReplyHolder.g.setOnClickListener(this.a);
    paramView.setOnTouchListener(paramOnLongClickAndTouchListener);
    paramView.setOnLongClickListener(paramOnLongClickAndTouchListener);
    paramReplyHolder.a.setOnTouchListener(paramOnLongClickAndTouchListener);
    paramReplyHolder.a.setOnLongClickListener(paramOnLongClickAndTouchListener);
    paramReplyHolder.i.setOnTouchListener(paramOnLongClickAndTouchListener);
    paramReplyHolder.i.setOnLongClickListener(paramOnLongClickAndTouchListener);
    if (paramReplyHolder.n == null) {
      paramReplyHolder.n = new AIOSelectableDelegateProxy();
    }
    if ((paramView instanceof SelectableComponent))
    {
      paramReplyHolder.n.a((SelectableComponent)paramView);
      paramReplyHolder.n.a(paramReplyHolder.k, paramReplyHolder.k);
    }
    paramReplyHolder.n.b(paramMessageForReplyText);
  }
  
  public boolean a(BaseGuildMsgViewBuild.ViewHolder paramViewHolder)
  {
    return paramViewHolder instanceof GuildReplyTextItemBuilder.ReplyHolder;
  }
  
  protected View b(ChatMessage paramChatMessage, BaseGuildMsgViewBuild.ViewHolder paramViewHolder, View paramView, GuildMsgItemLayout paramGuildMsgItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramViewHolder = a(paramChatMessage, paramViewHolder, paramView, paramGuildMsgItemLayout, paramOnLongClickAndTouchListener);
    paramView = new RelativeLayout.LayoutParams(-1, -1);
    paramGuildMsgItemLayout.setContentView(paramViewHolder, paramChatMessage.isNeedCombine(), GuildMsgItemBuildFactory.a(this.g, paramChatMessage), paramView);
    return paramViewHolder;
  }
  
  protected LinearLayout.LayoutParams c()
  {
    return new LinearLayout.LayoutParams(-1, -1);
  }
  
  protected LinearLayout.LayoutParams h()
  {
    return new LinearLayout.LayoutParams(-1, -2);
  }
  
  protected int i()
  {
    if (d()) {
      return 2131166220;
    }
    return 2131166191;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder.GuildReplyTextItemBuilder
 * JD-Core Version:    0.7.0.1
 */