package com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.ClipboardManager;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.TouchDelegate;
import com.tencent.mobileqq.activity.aio.Callback;
import com.tencent.mobileqq.activity.aio.ContextMenuBuilder2;
import com.tencent.mobileqq.activity.aio.FileTransferManager;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.ecommerce.ECommerceDataReportUtil;
import com.tencent.mobileqq.activity.aio.item.ChatThumbView;
import com.tencent.mobileqq.activity.aio.item.PicItemBuilder;
import com.tencent.mobileqq.activity.selectable.AIOSelectableDelegateImpl;
import com.tencent.mobileqq.activity.selectable.AIOSelectableDelegateProxy;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.guild.chatpie.GuildMsgItemBuildFactory;
import com.tencent.mobileqq.guild.chatpie.msgviewbuild.baseview.GuildMsgItemLayout;
import com.tencent.mobileqq.guild.widget.GuildMixedMsgLinearLayout;
import com.tencent.mobileqq.pic.api.ICompressOperator;
import com.tencent.mobileqq.pic.api.IPicPreDownload;
import com.tencent.mobileqq.pic.api.IPicUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.remote.MessageRecordInfo;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.mobileqq.widget.AnimationTextView.OnDoubleClick;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class GuildMixedMsgItemBuilder
  extends BaseGuildMsgViewBuild
  implements BaseBubbleBuilder.TouchDelegate, Callback, ContextMenuBuilder2
{
  protected long a = 0L;
  private ArrayList<String> l;
  private View.OnClickListener m = new GuildReplyItemClickListener(this);
  private AnimationTextView.OnDoubleClick n = new GuildMixedMsgItemBuilder.1(this);
  private long o = 0L;
  private View.OnClickListener p = new GuildMixedMsgItemBuilder.3(this);
  
  public GuildMixedMsgItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  private View a(ChatMessage paramChatMessage, BaseGuildMsgViewBuild.ViewHolder paramViewHolder, View paramView, OnLongClickAndTouchListener paramOnLongClickAndTouchListener, GuildMixedMsgItemBuilder.MixedHolder paramMixedHolder)
  {
    if ((paramChatMessage instanceof MessageForMixedMsg))
    {
      if (MessageRecordInfo.b(paramChatMessage.issend)) {
        localObject1 = "发出";
      } else {
        localObject1 = "发来";
      }
      a(paramViewHolder, (String)localObject1);
      Object localObject1 = (MessageForMixedMsg)paramChatMessage;
      Iterator localIterator = ((MessageForMixedMsg)localObject1).msgElemList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (MessageRecord)localIterator.next();
        if ((localObject2 instanceof MessageForPic))
        {
          a(paramViewHolder, "图片");
          localObject2 = (MessageForPic)localObject2;
          if (((MessageForPic)localObject2).time == 0L) {
            MessageForMixedMsg.copyBaseInfoFromMixedToPic((MessageForPic)localObject2, (MessageForMixedMsg)localObject1);
          }
        }
        else
        {
          a(paramViewHolder, com.tencent.mobileqq.text.TextUtils.emoticonToText(((MessageRecord)localObject2).msg));
        }
      }
      paramViewHolder = a(paramViewHolder, (GuildMixedMsgLinearLayout)paramView, ((MessageForMixedMsg)localObject1).msgElemList, paramOnLongClickAndTouchListener, (MessageRecord)localObject1);
      GuildMixedMsgItemBuilder.MixedHolder.a(paramMixedHolder, paramChatMessage.uniseq);
      return paramViewHolder;
    }
    paramViewHolder = new StringBuilder();
    paramViewHolder.append("getViewByMsgType 不应该有其它的进来 msgtype:");
    paramViewHolder.append(paramChatMessage.msgtype);
    QLog.e("MixedMsgItemBuilder", 1, paramViewHolder.toString());
    return paramView;
  }
  
  private MessageForPic a(FileMsg paramFileMsg, GuildMixedMsgItemBuilder.MixedHolder paramMixedHolder)
  {
    if ((paramMixedHolder.q instanceof MessageForMixedMsg))
    {
      Object localObject = (MessageForMixedMsg)paramMixedHolder.q;
      if ((GuildMixedMsgItemBuilder.MixedHolder.a(paramMixedHolder) != null) && (localObject != null) && (((MessageForMixedMsg)localObject).msgElemList != null))
      {
        paramMixedHolder = ((MessageForMixedMsg)localObject).msgElemList.iterator();
        while (paramMixedHolder.hasNext())
        {
          localObject = (MessageRecord)paramMixedHolder.next();
          if ((localObject != null) && (((MessageRecord)localObject).uniseq == paramFileMsg.uniseq) && ((localObject instanceof MessageForPic)))
          {
            localObject = (MessageForPic)localObject;
            if (((MessageForPic)localObject).subMsgId == paramFileMsg.mSubMsgId) {
              return localObject;
            }
          }
        }
      }
    }
    return null;
  }
  
  private CharSequence a(MessageRecord paramMessageRecord, CharSequence paramCharSequence, boolean paramBoolean)
  {
    if (android.text.TextUtils.isEmpty(paramCharSequence)) {
      return paramCharSequence;
    }
    String str;
    if ((paramCharSequence instanceof QQText)) {
      str = ((QQText)paramCharSequence).mSource;
    } else {
      str = paramCharSequence.toString();
    }
    int i = ChatTextSizeSettingActivity.a();
    if (paramBoolean)
    {
      if (str.startsWith("\n")) {
        return new QQText(str.substring(1), 13, i, paramMessageRecord);
      }
    }
    else if (str.endsWith("\n")) {
      paramCharSequence = new QQText(str.substring(0, str.length() - 1), 13, i, paramMessageRecord);
    }
    return paramCharSequence;
  }
  
  private HashMap<Integer, CharSequence> a(List<MessageRecord> paramList)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("formatTextMessRecordNewLineSymbol, size:");
      ((StringBuilder)localObject1).append(paramList.size());
      QLog.d("MixedMsgItemBuilder", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = new HashMap(paramList.size());
    int i = 0;
    while (i < paramList.size())
    {
      if ((paramList.get(i) instanceof MessageForText))
      {
        localObject2 = (MessageForText)paramList.get(i);
        if (!android.text.TextUtils.isEmpty(((MessageForText)localObject2).sb2)) {
          ((HashMap)localObject1).put(Integer.valueOf(i), ((MessageForText)localObject2).sb2);
        } else {
          ((HashMap)localObject1).put(Integer.valueOf(i), ((MessageForText)localObject2).sb);
        }
      }
      else
      {
        ((HashMap)localObject1).put(Integer.valueOf(i), "");
      }
      i += 1;
    }
    Object localObject2 = new ArrayList();
    i = 0;
    while (i < paramList.size())
    {
      if ((paramList.get(i) instanceof MessageForPic)) {
        ((List)localObject2).add(Integer.valueOf(i));
      }
      i += 1;
    }
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = (Integer)((Iterator)localObject2).next();
      i = ((Integer)localObject3).intValue() - 1;
      int j = ((Integer)localObject3).intValue() + 1;
      if ((i >= 0) && (i < ((HashMap)localObject1).size()))
      {
        localObject3 = (CharSequence)((HashMap)localObject1).get(Integer.valueOf(i));
        ((HashMap)localObject1).put(Integer.valueOf(i), a((MessageRecord)paramList.get(i), (CharSequence)localObject3, false));
      }
      if ((j >= 0) && (j < ((HashMap)localObject1).size()))
      {
        localObject3 = (CharSequence)((HashMap)localObject1).get(Integer.valueOf(j));
        ((HashMap)localObject1).put(Integer.valueOf(j), a((MessageRecord)paramList.get(j), (CharSequence)localObject3, true));
      }
    }
    return localObject1;
  }
  
  private void a(URLDrawable paramURLDrawable)
  {
    if (paramURLDrawable.getStatus() != 1)
    {
      if (this.l == null) {
        this.l = new ArrayList();
      }
      String str = paramURLDrawable.getURL().toString();
      if (str == null) {
        return;
      }
      if (!this.l.contains(str))
      {
        this.l.add(str);
        ThreadManager.executeOnSubThread(new GuildMixedMsgItemBuilder.2(this, str, paramURLDrawable), true);
      }
    }
  }
  
  private void a(ChatMessage paramChatMessage, String paramString)
  {
    ECommerceDataReportUtil.a(this.g, paramChatMessage, 2);
    if (AIOSelectableDelegateImpl.a().l())
    {
      paramChatMessage = AIOSelectableDelegateImpl.a().d();
      int j = 0;
      int i = j;
      if (paramChatMessage != null)
      {
        i = j;
        if (paramChatMessage.length() != AIOSelectableDelegateImpl.a().c()) {
          i = 1;
        }
      }
      if (i == 0) {
        paramChatMessage = AIOSelectableDelegateImpl.a().r();
      }
    }
    else
    {
      paramChatMessage = MessageForMixedMsg.getTextFromMixedMsg(paramChatMessage);
    }
    ((ClipboardManager)this.b.getSystemService("clipboard")).setText(paramChatMessage);
  }
  
  private void a(BaseGuildMsgViewBuild.ViewHolder paramViewHolder, String paramString)
  {
    if (paramViewHolder.r == null) {
      paramViewHolder.r = new StringBuilder();
    }
    if (v) {
      paramViewHolder.r.append(paramString);
    }
  }
  
  @NonNull
  protected View a(ChatMessage paramChatMessage, BaseGuildMsgViewBuild.ViewHolder paramViewHolder, View paramView, GuildMsgItemLayout paramGuildMsgItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramGuildMsgItemLayout = (GuildMixedMsgItemBuilder.MixedHolder)paramViewHolder;
    if (paramGuildMsgItemLayout.r == null) {
      paramGuildMsgItemLayout.r = new StringBuilder();
    }
    if ((!v) && (GuildMixedMsgItemBuilder.MixedHolder.a(paramGuildMsgItemLayout) != null) && (GuildMixedMsgItemBuilder.MixedHolder.b(paramGuildMsgItemLayout) == paramChatMessage.uniseq) && (!paramGuildMsgItemLayout.h)) {
      return paramView;
    }
    paramViewHolder = a(paramChatMessage, paramViewHolder, paramView, paramOnLongClickAndTouchListener, paramGuildMsgItemLayout);
    paramView = FileTransferManager.a(this.g);
    if (paramView != null) {
      paramView.a(paramViewHolder, this);
    }
    if (paramViewHolder != null) {
      paramViewHolder.setTag(paramGuildMsgItemLayout);
    }
    if (paramGuildMsgItemLayout.a != null) {
      paramGuildMsgItemLayout.a.b(paramChatMessage);
    }
    return paramViewHolder;
  }
  
  protected BaseGuildMsgViewBuild.ViewHolder a()
  {
    return new GuildMixedMsgItemBuilder.MixedHolder(this);
  }
  
  public GuildMixedMsgLinearLayout a(BaseGuildMsgViewBuild.ViewHolder paramViewHolder, GuildMixedMsgLinearLayout paramGuildMixedMsgLinearLayout, List<MessageRecord> paramList, OnLongClickAndTouchListener paramOnLongClickAndTouchListener, MessageRecord paramMessageRecord)
  {
    paramMessageRecord = paramOnLongClickAndTouchListener;
    paramList = new ArrayList(paramList);
    int k = 0;
    if (paramGuildMixedMsgLinearLayout == null)
    {
      paramGuildMixedMsgLinearLayout = c();
      paramGuildMixedMsgLinearLayout.setId(2131430578);
      paramGuildMixedMsgLinearLayout.setOrientation(1);
      paramGuildMixedMsgLinearLayout.setFocusable(false);
      paramGuildMixedMsgLinearLayout.setClickable(true);
      paramGuildMixedMsgLinearLayout.setMinimumHeight(AIOUtils.b(44.0F, this.b.getResources()));
      paramGuildMixedMsgLinearLayout.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
      localMixedHolder = (GuildMixedMsgItemBuilder.MixedHolder)paramViewHolder;
      GuildMixedMsgItemBuilder.MixedHolder.a(localMixedHolder, paramGuildMixedMsgLinearLayout);
      localMixedHolder.a = new AIOSelectableDelegateProxy();
      localMixedHolder.a.a(paramGuildMixedMsgLinearLayout);
      localMixedHolder.a.a(paramViewHolder.k, paramViewHolder.k);
    }
    GuildMixedMsgItemBuilder.MixedHolder localMixedHolder = (GuildMixedMsgItemBuilder.MixedHolder)paramViewHolder;
    localMixedHolder.b = -1;
    localMixedHolder.h = false;
    paramGuildMixedMsgLinearLayout.a(paramList, localMixedHolder);
    HashMap localHashMap = a(paramList);
    int i = paramList.size();
    int j = 0;
    paramViewHolder = paramMessageRecord;
    while (j < i)
    {
      MessageRecord localMessageRecord = (MessageRecord)paramList.get(j);
      paramMessageRecord = paramGuildMixedMsgLinearLayout.getChildAt(j);
      if (paramMessageRecord == null)
      {
        if (QLog.isColorLevel())
        {
          paramMessageRecord = new StringBuilder();
          paramMessageRecord.append("getMixedMsgLayout,child is null. size = ");
          paramMessageRecord.append(i);
          paramMessageRecord.append(",i = ");
          paramMessageRecord.append(j);
          QLog.e("MixedMsgItemBuilder", 2, paramMessageRecord.toString());
        }
      }
      else
      {
        Object localObject2;
        Object localObject1;
        Object localObject3;
        if ((localMessageRecord instanceof MessageForReplyText))
        {
          localObject2 = (LinearLayout)paramMessageRecord;
          localObject1 = (ViewGroup)((LinearLayout)localObject2).getChildAt(k);
          localObject2 = (TextView)((LinearLayout)localObject2).getChildAt(1);
          localObject3 = (MessageForReplyText)localMessageRecord;
          ((ViewGroup)localObject1).setId(2131430607);
          ((ViewGroup)localObject1).setOnClickListener(this.m);
          ((ViewGroup)localObject1).setOnTouchListener(paramViewHolder);
          ((ViewGroup)localObject1).setOnLongClickListener(paramViewHolder);
          ((ViewGroup)localObject1).findViewById(2131438908).setOnClickListener(this.m);
          ((ViewGroup)localObject1).findViewById(2131436449).setOnClickListener(this.m);
          ((ViewGroup)localObject1).findViewById(2131447325).setOnClickListener(this.m);
          if (!android.text.TextUtils.isEmpty(((MessageForReplyText)localObject3).sb))
          {
            ((TextView)localObject2).setText(((MessageForReplyText)localObject3).sb);
            ((TextView)localObject2).setVisibility(0);
          }
          else
          {
            ((TextView)localObject2).setVisibility(8);
          }
          GuildReplyTextItemBuilder.a(this.b, this.g, (ViewGroup)localObject1, ((MessageForReplyText)localObject3).mSourceMsgInfo, this.c.b, ((MessageForReplyText)localObject3).istroop, (MessageRecord)localObject3, false, this.c);
          paramViewHolder = ((ViewGroup)localObject1).findViewById(2131447325);
          if (paramViewHolder != null)
          {
            paramViewHolder = paramViewHolder.getTag(2131430593);
            if ((paramViewHolder != null) && ((paramViewHolder instanceof Boolean)))
            {
              bool = ((Boolean)paramViewHolder).booleanValue();
              localMixedHolder.h = bool;
              break label521;
            }
          }
          boolean bool = false;
          label521:
          if (QLog.isColorLevel())
          {
            paramViewHolder = new StringBuilder();
            paramViewHolder.append("getMixedMsgLayout: reply check is need refresh[");
            paramViewHolder.append(bool);
            paramViewHolder.append("]");
            QLog.i("MixedMsgItemBuilder", 1, paramViewHolder.toString());
          }
        }
        else
        {
          if (!(localMessageRecord instanceof MessageForText)) {
            break label616;
          }
          paramViewHolder = (AnimationTextView)paramMessageRecord;
          paramViewHolder.setTextSize(16.666666F);
          com.tencent.mobileqq.text.TextUtils.fixTextViewANRForAnd10(paramViewHolder);
          paramViewHolder.setText((CharSequence)localHashMap.get(Integer.valueOf(j)));
        }
        break label1011;
        label616:
        if ((localMessageRecord instanceof MessageForPic))
        {
          paramViewHolder = (MessageForPic)localMessageRecord;
          localObject1 = (ChatThumbView)paramMessageRecord;
          localObject3 = new int[2];
          tmp644_642 = localObject3;
          tmp644_642[0] = 0;
          tmp648_644 = tmp644_642;
          tmp648_644[1] = 0;
          tmp648_644;
          localObject2 = BaseGuildPicBuilder.a(this.b, paramViewHolder, (ChatThumbView)localObject1, (int[])localObject3, null);
          ((ChatThumbView)localObject1).setTag(2131430592, paramViewHolder);
          ((ChatThumbView)localObject1).setAdjustViewBounds(true);
          ((ChatThumbView)localObject1).setMaxWidth(((com.tencent.mobileqq.guild.pic.api.IGuildPicAIO)QRoute.api(com.tencent.mobileqq.guild.pic.api.IGuildPicAIO.class)).getThumbMaxPx(false)[0]);
          ((ChatThumbView)localObject1).setMaxHeight(((com.tencent.mobileqq.guild.pic.api.IGuildPicAIO)QRoute.api(com.tencent.mobileqq.guild.pic.api.IGuildPicAIO.class)).getThumbMaxPx(false)[1]);
          ((ChatThumbView)localObject1).setImageDrawable((Drawable)localObject2);
          String str = ((URLDrawable)localObject2).getURL().getProtocol();
          URL localURL = URLDrawableHelper.getURL(paramViewHolder, 65537);
          if (PicItemBuilder.a(this.b, ((IPicUtil)QRoute.api(IPicUtil.class)).isDynamicImg(paramViewHolder.imageType), str.equals("chatthumb"), localObject3[0], localObject3[1], localURL))
          {
            ((URLDrawable)localObject2).setWatermarkDrawable(((ICompressOperator)QRoute.api(ICompressOperator.class)).getGifTagBitmap(), AIOUtils.b(6.0F, this.b.getResources()), AIOUtils.b(6.0F, this.b.getResources()));
            ((URLDrawable)localObject2).setWatermarkVisibility(0);
          }
          else
          {
            ((URLDrawable)localObject2).setWatermarkVisibility(4);
          }
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("getMixedMsgLayout,set picmsg, picDrawable ");
            ((StringBuilder)localObject3).append(localObject2);
            ((StringBuilder)localObject3).append(",picMsg = ");
            ((StringBuilder)localObject3).append(paramViewHolder);
            QLog.d("MixedMsgItemBuilder", 2, ((StringBuilder)localObject3).toString());
          }
          ((ChatThumbView)localObject1).setOnClickListener(this.p);
          a((URLDrawable)localObject2);
          if (!paramViewHolder.isSendFromLocal()) {
            ((IPicPreDownload)this.g.getRuntimeService(IPicPreDownload.class, "")).productFromAIO(paramViewHolder, 2);
          }
        }
        else if (QLog.isColorLevel())
        {
          paramViewHolder = new StringBuilder();
          paramViewHolder.append("mixed type not support yet.");
          paramViewHolder.append(localMessageRecord.getClass().getSimpleName());
          QLog.e("MixedMsgItemBuilder", 2, paramViewHolder.toString());
        }
        label1011:
        k = 0;
        paramViewHolder = (LinearLayout.LayoutParams)paramMessageRecord.getLayoutParams();
        if ((localMessageRecord instanceof MessageForPic))
        {
          if (j > 0) {
            if ((paramList.get(j - 1) instanceof MessageForPic)) {
              paramViewHolder.topMargin = AIOUtils.b(4.0F, this.b.getResources());
            } else {
              paramViewHolder.topMargin = AIOUtils.b(0.0F, this.b.getResources());
            }
          }
          if (j == 0) {
            paramViewHolder.topMargin = AIOUtils.b(0.0F, this.b.getResources());
          }
          if (j == paramList.size() - 1) {
            paramViewHolder.bottomMargin = AIOUtils.b(0.0F, this.b.getResources());
          }
        }
        else
        {
          paramViewHolder.topMargin = AIOUtils.b(4.0F, this.b.getResources());
          paramViewHolder.bottomMargin = AIOUtils.b(4.0F, this.b.getResources());
          if (j == 0) {
            paramViewHolder.topMargin = AIOUtils.b(0.0F, this.b.getResources());
          }
          if (j == paramList.size() - 1) {
            paramViewHolder.bottomMargin = AIOUtils.b(0.0F, this.b.getResources());
          }
        }
        paramViewHolder = paramOnLongClickAndTouchListener;
        paramMessageRecord.setOnTouchListener(paramViewHolder);
        paramMessageRecord.setOnLongClickListener(paramViewHolder);
      }
      j += 1;
    }
    paramGuildMixedMsgLinearLayout.setOnTouchListener(paramViewHolder);
    paramGuildMixedMsgLinearLayout.setOnLongClickListener(paramViewHolder);
    return paramGuildMixedMsgLinearLayout;
  }
  
  public QQCustomMenu a(QQCustomMenu paramQQCustomMenu, ChatMessage paramChatMessage)
  {
    paramQQCustomMenu.a(this.b.getString(2131888192));
    int i;
    if (((paramChatMessage instanceof MessageForMixedMsg)) && (!((MessageForMixedMsg)paramChatMessage).canSelectable())) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0) {
      paramQQCustomMenu.a(2131431492, this.b.getString(2131888241), 2130840746);
    }
    return paramQQCustomMenu;
  }
  
  public void a(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if ((i != 1) && (i != 3)) {
      return;
    }
    paramView = paramView.getBackground();
    if (paramView != null)
    {
      paramView.setColorFilter(null);
      paramView.invalidateSelf();
    }
  }
  
  public void a(View paramView, boolean paramBoolean)
  {
    Object localObject = (GuildMixedMsgItemBuilder.MixedHolder)AIOUtils.b(paramView);
    if ((!paramBoolean) && ((paramView instanceof ChatThumbView))) {
      ((ChatThumbView)paramView).a(paramView, true);
    }
    localObject = GuildMixedMsgItemBuilder.MixedHolder.a((GuildMixedMsgItemBuilder.MixedHolder)localObject).getBackground();
    if (localObject != null)
    {
      if (paramBoolean) {
        paramView = null;
      } else {
        paramView = j;
      }
      ((Drawable)localObject).setColorFilter(paramView);
      ((Drawable)localObject).invalidateSelf();
    }
  }
  
  protected boolean a(ChatMessage paramChatMessage)
  {
    boolean bool2 = paramChatMessage.isSendFromLocal();
    boolean bool1 = false;
    if (!bool2) {
      return false;
    }
    if (paramChatMessage.extraflag == 32768) {
      bool1 = true;
    }
    return bool1;
  }
  
  protected View b(ChatMessage paramChatMessage, BaseGuildMsgViewBuild.ViewHolder paramViewHolder, View paramView, GuildMsgItemLayout paramGuildMsgItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramViewHolder = a(paramChatMessage, paramViewHolder, paramView, paramGuildMsgItemLayout, paramOnLongClickAndTouchListener);
    paramView = new RelativeLayout.LayoutParams(-1, -1);
    paramGuildMsgItemLayout.setContentView(paramViewHolder, paramChatMessage.isNeedCombine(), GuildMsgItemBuildFactory.a(this.g, paramChatMessage), paramView);
    return paramViewHolder;
  }
  
  public boolean b(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    QQAppInterface localQQAppInterface = this.g;
    String str = "";
    paramContext = str;
    if (localQQAppInterface != null)
    {
      paramContext = this.g.getCurrentAccountUin();
      if (android.text.TextUtils.isEmpty(paramContext)) {
        paramContext = str;
      }
    }
    if (paramInt != 2131431492)
    {
      if (paramInt != 2131445511) {
        return false;
      }
      AIOSelectableDelegateImpl.a().a(paramChatMessage);
      return true;
    }
    a(paramChatMessage, paramContext);
    return true;
  }
  
  protected boolean b(View paramView)
  {
    paramView = (GuildMixedMsgItemBuilder.MixedHolder)AIOUtils.b(paramView);
    if ((paramView.q instanceof MessageForMixedMsg))
    {
      paramView = (MessageForMixedMsg)paramView.q;
      if (paramView.isSendFromLocal())
      {
        ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.b(this.b, null);
        localActionSheet.addButton(2131886574, 5);
        localActionSheet.addCancelButton(2131887648);
        localActionSheet.setOnButtonClickListener(new GuildMixedMsgItemBuilder.4(this, paramView, localActionSheet));
        localActionSheet.show();
      }
    }
    return true;
  }
  
  protected String b_(ChatMessage paramChatMessage)
  {
    if ((paramChatMessage instanceof MessageForMixedMsg))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      Object localObject;
      if (MessageRecordInfo.b(paramChatMessage.issend)) {
        localObject = "发出";
      } else {
        localObject = "发来";
      }
      localStringBuilder.append((String)localObject);
      paramChatMessage = ((MessageForMixedMsg)paramChatMessage).msgElemList.iterator();
      while (paramChatMessage.hasNext())
      {
        localObject = (MessageRecord)paramChatMessage.next();
        if ((localObject instanceof MessageForPic)) {
          localStringBuilder.append("图片");
        } else {
          localStringBuilder.append(com.tencent.mobileqq.text.TextUtils.emoticonToText(((MessageRecord)localObject).msg));
        }
      }
      return localStringBuilder.toString();
    }
    return "";
  }
  
  protected GuildMixedMsgLinearLayout c()
  {
    return new GuildMixedMsgLinearLayout(this.b);
  }
  
  public void handleMessage(View paramView, FileMsg paramFileMsg, int paramInt1, int paramInt2)
  {
    if (paramInt1 != 2003) {
      return;
    }
    Object localObject1 = (GuildMixedMsgItemBuilder.MixedHolder)AIOUtils.b(paramView);
    paramFileMsg = a(paramFileMsg, (GuildMixedMsgItemBuilder.MixedHolder)localObject1);
    if (paramFileMsg != null)
    {
      paramInt2 = GuildMixedMsgItemBuilder.MixedHolder.a((GuildMixedMsgItemBuilder.MixedHolder)localObject1).getChildCount();
      paramInt1 = 0;
      Object localObject2;
      while (paramInt1 < paramInt2)
      {
        paramView = GuildMixedMsgItemBuilder.MixedHolder.a((GuildMixedMsgItemBuilder.MixedHolder)localObject1).getChildAt(paramInt1);
        if ((paramView instanceof ChatThumbView))
        {
          paramView = (ChatThumbView)paramView;
          localObject2 = paramView.getTag(2131430592);
          if ((localObject2 instanceof MessageForPic))
          {
            localObject2 = (MessageForPic)localObject2;
            if ((((MessageForPic)localObject2).uniseq == paramFileMsg.uniseq) && (((MessageForPic)localObject2).subMsgId == paramFileMsg.subMsgId)) {
              break label130;
            }
          }
        }
        paramInt1 += 1;
      }
      paramView = null;
      label130:
      if (paramView != null)
      {
        localObject1 = new int[2];
        tmp141_139 = localObject1;
        tmp141_139[0] = 0;
        tmp145_141 = tmp141_139;
        tmp145_141[1] = 0;
        tmp145_141;
        localObject2 = BaseGuildPicBuilder.a(this.b, paramFileMsg, paramView, (int[])localObject1, null);
        String str = ((URLDrawable)localObject2).getURL().getProtocol();
        URL localURL = URLDrawableHelper.getURL(paramFileMsg, 65537);
        boolean bool = PicItemBuilder.a(this.b, ((IPicUtil)QRoute.api(IPicUtil.class)).isDynamicImg(paramFileMsg.imageType), str.equals("chatthumb"), localObject1[0], localObject1[1], localURL);
        paramView.setImageDrawable((Drawable)localObject2);
        if (bool)
        {
          ((URLDrawable)localObject2).setWatermarkDrawable(((ICompressOperator)QRoute.api(ICompressOperator.class)).getGifTagBitmap(), AIOUtils.b(6.0F, this.b.getResources()), AIOUtils.b(6.0F, this.b.getResources()));
          ((URLDrawable)localObject2).setWatermarkVisibility(0);
          return;
        }
        ((URLDrawable)localObject2).setWatermarkVisibility(4);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder.GuildMixedMsgItemBuilder
 * JD-Core Version:    0.7.0.1
 */