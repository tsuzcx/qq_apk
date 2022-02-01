package com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.qwallet.temp.IQWalletTemp;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.qwallet.QWalletMsgHolder;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.data.QQWalletTransferMsg;
import com.tencent.mobileqq.guild.chatpie.msgviewbuild.baseview.GuildMsgItemLayout;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.hb.IQWalletHbApi;
import com.tencent.mobileqq.qwallet.hb.aio.IQQWalletHbItemApi;
import com.tencent.mobileqq.qwallet.hb.aio.QQWalletBaseMsgElem;
import com.tencent.mobileqq.qwallet.hb.aio.elem.ICustomizeStrategyFactory;
import com.tencent.mobileqq.qwallet.hb.aio.elem.ICustomizeStrategyFactory.OnCustomizeListener;
import com.tencent.mobileqq.qwallet.hb.aio.elem.RedPacketInfo;
import com.tencent.mobileqq.qwallet.hb.aio.viewholder.IFBaseViewHolder;
import com.tencent.mobileqq.qwallet.hb.aio.viewholder.IViewHolderFactory;
import com.tencent.mobileqq.service.message.remote.MessageRecordInfo;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.impl.QWalletHelperDelegate;
import java.util.HashMap;
import java.util.Map;
import mqq.os.MqqHandler;

public class GuildQQWalletMsgItemBuilder
  extends BaseGuildMsgViewBuild
  implements ICustomizeStrategyFactory.OnCustomizeListener
{
  public static Map<MessageForQQWalletMsg, Long> C = new HashMap();
  public static final String a = "GuildQQWalletMsgItemBuilder";
  int A;
  int B;
  private View.OnClickListener D = new GuildQQWalletMsgItemBuilder.2(this);
  protected final int l = 2131443088;
  protected int m;
  protected int n;
  protected int o;
  protected int p;
  protected int q;
  protected int r;
  protected int s;
  protected int t;
  protected String w = "";
  BaseChatPie x = null;
  protected float y;
  IQQWalletHbItemApi z = (IQQWalletHbItemApi)QRoute.api(IQQWalletHbItemApi.class);
  
  public GuildQQWalletMsgItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.w = paramContext.getString(2131914264);
    this.y = paramContext.getResources().getDisplayMetrics().density;
    float f = this.y;
    this.m = ((int)(42.0F * f + 0.5F));
    this.n = ((int)(10.0F * f + 0.5F));
    this.o = ((int)(9.0F * f + 0.5F));
    this.p = ((int)(6.5F * f + 0.5F));
    this.q = ((int)(4.0F * f + 0.5F));
    this.r = ((int)(1.0F * f + 0.5F));
    this.s = ((int)(173.0F * f + 0.5F));
    this.t = ((int)(f * 255.0F + 0.5F));
    paramQQAppInterface = (BaseActivity)paramContext;
    if (paramQQAppInterface.getChatFragment() != null) {
      this.x = paramQQAppInterface.getChatFragment().k();
    }
  }
  
  private TextView a(Context paramContext)
  {
    paramContext = new TextView(paramContext);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.topMargin = this.n;
    localLayoutParams.bottomMargin = this.p;
    int i = this.m;
    int j = this.q;
    localLayoutParams.leftMargin = (i + j);
    localLayoutParams.rightMargin = (i + j);
    localLayoutParams.addRule(3, 2131430578);
    localLayoutParams.addRule(14);
    paramContext.setLayoutParams(localLayoutParams);
    paramContext.setTextColor(-1);
    paramContext.setBackgroundResource(2130846198);
    i = this.o;
    paramContext.setPadding(i, this.q, i, 0);
    paramContext.setClickable(false);
    paramContext.setVisibility(8);
    paramContext.setGravity(16);
    paramContext.setIncludeFontPadding(false);
    paramContext.setLineSpacing(this.q, 1.0F);
    paramContext.setTextSize(12.0F);
    paramContext.setId(2131443088);
    return paramContext;
  }
  
  private void a(GuildQQWalletMsgItemBuilder.QWalletMsgHolderBase paramQWalletMsgHolderBase, QQWalletBaseMsgElem paramQQWalletBaseMsgElem, MessageForQQWalletMsg paramMessageForQQWalletMsg, OnLongClickAndTouchListener paramOnLongClickAndTouchListener, boolean paramBoolean)
  {
    if (paramQQWalletBaseMsgElem != null)
    {
      if (paramMessageForQQWalletMsg == null) {
        return;
      }
      if (QLog.isColorLevel())
      {
        if (paramMessageForQQWalletMsg.mQQWalletRedPacketMsg != null)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(",QQWalletAioBodyReserve=");
          ((StringBuilder)localObject).append(paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.body);
          localObject = ((StringBuilder)localObject).toString();
        }
        else
        {
          localObject = "";
        }
        String str = a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("handleRedPacketLayout holder=");
        localStringBuilder.append(paramQWalletMsgHolderBase);
        localStringBuilder.append(",elem=");
        localStringBuilder.append(paramQQWalletBaseMsgElem);
        localStringBuilder.append(",qqWalletMsg=");
        localStringBuilder.append(paramMessageForQQWalletMsg);
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(",fromItemRefresh=");
        localStringBuilder.append(paramBoolean);
        QLog.d(str, 2, localStringBuilder.toString());
      }
      int i = ((IViewHolderFactory)QRoute.api(IViewHolderFactory.class)).getRedPkgType(paramMessageForQQWalletMsg.messageType);
      if (paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.redChannel == 1000004) {
        i = 16;
      }
      int j = i;
      if (i == 4)
      {
        j = i;
        if (paramQQWalletBaseMsgElem.v > 0) {
          j = 0;
        }
      }
      Object localObject = ((IViewHolderFactory)QRoute.api(IViewHolderFactory.class)).createViewHolder(this.g, this.c, paramQWalletMsgHolderBase, paramQQWalletBaseMsgElem, j, this);
      try
      {
        ((IFBaseViewHolder)localObject).a();
        ((IFBaseViewHolder)localObject).c();
        ((IFBaseViewHolder)localObject).d();
        ((IFBaseViewHolder)localObject).e();
        ((IFBaseViewHolder)localObject).b();
        ((IFBaseViewHolder)localObject).f();
        ((IFBaseViewHolder)localObject).g();
        ((IFBaseViewHolder)localObject).h();
        ((IFBaseViewHolder)localObject).i();
      }
      catch (Throwable localThrowable)
      {
        if (QLog.isColorLevel()) {
          QLog.e(a, 2, "handleRedPacketLayout exception", localThrowable);
        }
      }
      if (paramBoolean) {
        return;
      }
      this.A = paramQQWalletBaseMsgElem.v;
      this.B = paramMessageForQQWalletMsg.messageType;
      paramQWalletMsgHolderBase.c().setOnClickListener(this.D);
      paramQWalletMsgHolderBase.d().setOnLongClickListener(paramOnLongClickAndTouchListener);
      paramQWalletMsgHolderBase.d().setOnTouchListener(paramOnLongClickAndTouchListener);
      paramQWalletMsgHolderBase.d().setTag(paramMessageForQQWalletMsg);
      paramOnLongClickAndTouchListener = ((IQWalletTemp)QRoute.api(IQWalletTemp.class)).createBaseChatPie(this.x);
      this.z.setHbOnClickListener(this.g, paramOnLongClickAndTouchListener, paramQWalletMsgHolderBase.d(), this.c, j, paramQQWalletBaseMsgElem.v, this.w);
      if (j == 1)
      {
        paramQWalletMsgHolderBase = paramQWalletMsgHolderBase.b();
        paramQQWalletBaseMsgElem = new StringBuilder();
        paramQQWalletBaseMsgElem.append(HardCodeUtil.a(2131908782));
        paramQQWalletBaseMsgElem.append(paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.c);
        paramQQWalletBaseMsgElem.append(HardCodeUtil.a(2131908787));
        paramQWalletMsgHolderBase.setContentDescription(paramQQWalletBaseMsgElem.toString());
        return;
      }
      if (j == 2)
      {
        paramQWalletMsgHolderBase = paramQWalletMsgHolderBase.b();
        paramQQWalletBaseMsgElem = new StringBuilder();
        paramQQWalletBaseMsgElem.append(HardCodeUtil.a(2131908789));
        paramQQWalletBaseMsgElem.append(paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.c);
        paramQQWalletBaseMsgElem.append(HardCodeUtil.a(2131908777));
        paramQWalletMsgHolderBase.setContentDescription(paramQQWalletBaseMsgElem.toString());
        return;
      }
      if (j == 8)
      {
        paramQWalletMsgHolderBase = paramQWalletMsgHolderBase.b();
        paramQQWalletBaseMsgElem = new StringBuilder();
        paramQQWalletBaseMsgElem.append("K歌红包:");
        paramQQWalletBaseMsgElem.append(paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.c);
        paramQQWalletBaseMsgElem.append(HardCodeUtil.a(2131908796));
        paramQWalletMsgHolderBase.setContentDescription(paramQQWalletBaseMsgElem.toString());
        return;
      }
      if (j == 9)
      {
        paramQWalletMsgHolderBase = paramQWalletMsgHolderBase.b();
        paramQQWalletBaseMsgElem = new StringBuilder();
        paramQQWalletBaseMsgElem.append(HardCodeUtil.a(2131908779));
        paramQQWalletBaseMsgElem.append(paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.c);
        paramQQWalletBaseMsgElem.append(HardCodeUtil.a(2131908788));
        paramQWalletMsgHolderBase.setContentDescription(paramQQWalletBaseMsgElem.toString());
        return;
      }
      if (j == 10)
      {
        paramQWalletMsgHolderBase = paramQWalletMsgHolderBase.b();
        paramQQWalletBaseMsgElem = new StringBuilder();
        paramQQWalletBaseMsgElem.append(HardCodeUtil.a(2131908795));
        paramQQWalletBaseMsgElem.append(paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.c);
        paramQQWalletBaseMsgElem.append(HardCodeUtil.a(2131908798));
        paramQWalletMsgHolderBase.setContentDescription(paramQQWalletBaseMsgElem.toString());
        return;
      }
      if (j == 11)
      {
        paramQWalletMsgHolderBase = paramQWalletMsgHolderBase.b();
        paramQQWalletBaseMsgElem = new StringBuilder();
        paramQQWalletBaseMsgElem.append(HardCodeUtil.a(2131908785));
        paramQQWalletBaseMsgElem.append(paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.c);
        paramQQWalletBaseMsgElem.append(HardCodeUtil.a(2131908784));
        paramQWalletMsgHolderBase.setContentDescription(paramQQWalletBaseMsgElem.toString());
        return;
      }
      paramQWalletMsgHolderBase = paramQWalletMsgHolderBase.b();
      paramQQWalletBaseMsgElem = new StringBuilder();
      paramQQWalletBaseMsgElem.append(paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.c);
      paramQQWalletBaseMsgElem.append(this.w);
      paramQWalletMsgHolderBase.setContentDescription(paramQQWalletBaseMsgElem.toString());
    }
  }
  
  private void a(QQCustomMenu paramQQCustomMenu)
  {
    int j = paramQQCustomMenu.b();
    int i = 0;
    while (i < j)
    {
      QQCustomMenuItem localQQCustomMenuItem = paramQQCustomMenu.a(i);
      if (localQQCustomMenuItem.b() == 2131431695) {
        localQQCustomMenuItem.a(2130840655);
      }
      i += 1;
    }
  }
  
  @NonNull
  protected View a(ChatMessage paramChatMessage, BaseGuildMsgViewBuild.ViewHolder paramViewHolder, View paramView, GuildMsgItemLayout paramGuildMsgItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramView = (GuildQQWalletMsgItemBuilder.QWalletMsgHolderBase)paramViewHolder;
    if ((paramChatMessage instanceof MessageForQQWalletMsg)) {
      paramViewHolder = (MessageForQQWalletMsg)paramChatMessage;
    } else {
      paramViewHolder = null;
    }
    if (paramViewHolder != null)
    {
      if ((paramViewHolder.mQQWalletTransferMsg == null) && (paramViewHolder.mQQWalletRedPacketMsg == null)) {
        return null;
      }
      if (QWalletHelperDelegate.graphbSpeedEnable) {
        a(paramViewHolder.istroop);
      }
      if ((paramView.b() == null) || ((paramView.b() != null) && (paramView.m() != paramChatMessage.uniseq)))
      {
        IQQWalletHbItemApi localIQQWalletHbItemApi = this.z;
        Context localContext = this.b;
        int i;
        if (this.c == null) {
          i = 0;
        } else {
          i = this.c.a;
        }
        paramView.a(localIQQWalletHbItemApi.createRedPacketBubbleView(paramView, localContext, i));
        paramGuildMsgItemLayout.addView(a(this.b));
      }
      paramView.a(paramChatMessage.uniseq);
      if (paramViewHolder.mQQWalletRedPacketMsg != null)
      {
        paramChatMessage = paramViewHolder.mQQWalletRedPacketMsg.elem;
        if (paramChatMessage == null) {
          return paramView.b();
        }
        a(paramView, paramChatMessage, paramViewHolder, paramOnLongClickAndTouchListener, false);
      }
      else
      {
        paramChatMessage = null;
      }
      paramViewHolder = (TextView)paramGuildMsgItemLayout.findViewById(2131443088);
      if (paramViewHolder != null) {
        if ((paramChatMessage != null) && (!TextUtils.isEmpty(paramChatMessage.g)))
        {
          paramViewHolder.setText(paramChatMessage.g);
          paramViewHolder.setVisibility(0);
        }
        else
        {
          paramViewHolder.setVisibility(8);
        }
      }
      return paramView.b();
    }
    return null;
  }
  
  protected BaseGuildMsgViewBuild.ViewHolder a()
  {
    return new GuildQQWalletMsgItemBuilder.QWalletMsgHolderBase(this);
  }
  
  protected void a(int paramInt)
  {
    ThreadManager.post(new GuildQQWalletMsgItemBuilder.1(this, paramInt), 8, null, true);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if (paramInt != 2131431695)
    {
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    }
    ChatActivityFacade.b(this.b, this.g, paramChatMessage);
  }
  
  public void a(int paramInt, RedPacketInfo paramRedPacketInfo)
  {
    if (paramRedPacketInfo != null) {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 4)
          {
            if (paramInt != 5) {
              return;
            }
            if ((paramRedPacketInfo.skinType == 1) && ((paramRedPacketInfo.background != null) || (paramRedPacketInfo.animInfo != null))) {
              a(paramRedPacketInfo.a);
            }
            if ((paramRedPacketInfo.skinType == 3) && (paramRedPacketInfo.specailBackgroundAnimInfo != null)) {
              a(paramRedPacketInfo.a);
            }
          }
          else if (paramRedPacketInfo.animInfo != null)
          {
            a(paramRedPacketInfo.a);
          }
        }
        else if ((paramRedPacketInfo.a()) || (paramRedPacketInfo.e != null)) {
          a(paramRedPacketInfo.a);
        }
      }
      else if (paramRedPacketInfo.background != null) {
        a(paramRedPacketInfo.a);
      }
    }
  }
  
  public void a(View paramView, ChatMessage paramChatMessage, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateView type=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(",message=");
      localStringBuilder.append(paramChatMessage);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if (paramInt == 888)
    {
      paramView = paramView.getTag();
      if ((paramView instanceof QWalletMsgHolder))
      {
        paramChatMessage = (GuildQQWalletMsgItemBuilder.QWalletMsgHolderBase)paramView;
        if (paramChatMessage.d() != null) {
          paramView = paramChatMessage.d().getTag();
        } else {
          paramView = null;
        }
        if ((paramView instanceof MessageForQQWalletMsg))
        {
          paramView = (MessageForQQWalletMsg)paramView;
          if (paramView.mQQWalletRedPacketMsg != null) {
            a(paramChatMessage, paramView.mQQWalletRedPacketMsg.elem, paramView, null, true);
          }
        }
      }
      return;
    }
    super.a(paramView, paramChatMessage, paramInt);
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord != null) && (this.g != null))
    {
      MqqHandler localMqqHandler = this.g.getHandler(ChatActivity.class);
      if (localMqqHandler != null)
      {
        Message localMessage = new Message();
        localMessage.what = 78;
        localMessage.arg1 = 888;
        Bundle localBundle = new Bundle();
        localBundle.putLong("messageUniseq", paramMessageRecord.uniseq);
        localMessage.setData(localBundle);
        localMqqHandler.sendMessage(localMessage);
      }
    }
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    paramView = AIOUtils.a(paramView);
    a(localQQCustomMenu, this.b, 2131444634, paramView, null);
    ChatActivityFacade.a(localQQCustomMenu, this.b, this.c.a);
    a(localQQCustomMenu);
    a(localQQCustomMenu, this.b, 2131444651, paramView, null);
    return localQQCustomMenu.d();
  }
  
  public void b()
  {
    super.b();
    ((IQWalletHbApi)QRoute.api(IQWalletHbApi.class)).getCustomizeStrategyFactory().b();
    ((IQWalletHbApi)QRoute.api(IQWalletHbApi.class)).voiceRecognizerDestroy();
    C.clear();
  }
  
  protected String b_(ChatMessage paramChatMessage)
  {
    boolean bool = paramChatMessage instanceof MessageForQQWalletMsg;
    QQWalletBaseMsgElem localQQWalletBaseMsgElem = null;
    Object localObject;
    if (bool) {
      localObject = (MessageForQQWalletMsg)paramChatMessage;
    } else {
      localObject = null;
    }
    if ((localObject != null) && ((((MessageForQQWalletMsg)localObject).mQQWalletRedPacketMsg != null) || (((MessageForQQWalletMsg)localObject).mQQWalletTransferMsg != null)))
    {
      if (((MessageForQQWalletMsg)localObject).mQQWalletRedPacketMsg != null) {
        localQQWalletBaseMsgElem = ((MessageForQQWalletMsg)localObject).mQQWalletRedPacketMsg.elem;
      } else if (((MessageForQQWalletMsg)localObject).mQQWalletTransferMsg != null) {
        localQQWalletBaseMsgElem = ((MessageForQQWalletMsg)localObject).mQQWalletTransferMsg.elem;
      }
      if (localQQWalletBaseMsgElem != null)
      {
        localObject = new StringBuilder();
        if (MessageRecordInfo.b(paramChatMessage.issend)) {
          ((StringBuilder)localObject).append("发出");
        } else {
          ((StringBuilder)localObject).append("发来");
        }
        ((StringBuilder)localObject).append(localQQWalletBaseMsgElem.e);
        ((StringBuilder)localObject).append(localQQWalletBaseMsgElem.c);
        ((StringBuilder)localObject).append("按钮");
        return ((StringBuilder)localObject).toString();
      }
      return paramChatMessage.msg;
    }
    return paramChatMessage.msg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder.GuildQQWalletMsgItemBuilder
 * JD-Core Version:    0.7.0.1
 */