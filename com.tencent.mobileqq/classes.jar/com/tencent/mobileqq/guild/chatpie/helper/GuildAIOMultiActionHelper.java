package com.tencent.mobileqq.guild.chatpie.helper;

import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.webviewplugin.NewReportPlugin;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.MsgProxyUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgList;
import com.tencent.mobileqq.activity.aio.coreui.msglist.ListUI;
import com.tencent.mobileqq.activity.aio.helper.ILifeCycleHelper;
import com.tencent.mobileqq.activity.aio.helper.MultiForwardHelper;
import com.tencent.mobileqq.activity.aio.helper.SelectToBottomHelper;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.message.MultiMsgProxy;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForArkFlashChat;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForQQStoryComment;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.guild.chatpie.GuildChatContext;
import com.tencent.mobileqq.jubao.JubaoApiPlugin;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.pic.api.IPicFlash;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.StructMsgForHypertext;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout2;
import com.tencent.mobileqq.structmsg.view.StructMsgItemSummary;
import com.tencent.mobileqq.text.TextUtils;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class GuildAIOMultiActionHelper
  implements View.OnClickListener, ILifeCycleHelper
{
  protected LinearLayout a;
  protected View b;
  private final BaseChatPie c;
  private final QQAppInterface d;
  private final BaseActivity e;
  private final MqqHandler f;
  private final SessionInfo g;
  
  public GuildAIOMultiActionHelper(BaseChatPie paramBaseChatPie)
  {
    this.c = paramBaseChatPie;
    this.d = paramBaseChatPie.d;
    this.e = paramBaseChatPie.aX();
    this.f = paramBaseChatPie.j();
    this.g = paramBaseChatPie.aE();
  }
  
  private void i()
  {
    TextView localTextView = new TextView(this.e);
    localTextView.setId(2131430631);
    if (AppSetting.e) {
      localTextView.setContentDescription(HardCodeUtil.a(2131900435));
    }
    localTextView.setText(HardCodeUtil.a(2131900435));
    localTextView.setTextColor(a(b()));
    localTextView.setTextSize(18.0F);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -1, 1.0F);
    localTextView.setGravity(17);
    localTextView.setLayoutParams(localLayoutParams);
    localTextView.setOnClickListener(this);
    localTextView.setBackgroundResource(c());
    this.a.addView(localTextView);
  }
  
  private boolean j()
  {
    TextView localTextView = new TextView(this.e);
    localTextView.setId(2131430636);
    if (AppSetting.e) {
      localTextView.setContentDescription(this.d.getApplication().getResources().getString(2131891075));
    }
    localTextView.setText(this.d.getApplication().getResources().getString(2131891075));
    localTextView.setTextColor(a(b()));
    localTextView.setTextSize(18.0F);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -1, 1.0F);
    localTextView.setGravity(17);
    localTextView.setLayoutParams(localLayoutParams);
    localTextView.setOnClickListener(this);
    localTextView.setBackgroundResource(c());
    this.a.addView(localTextView);
    return true;
  }
  
  private void k()
  {
    i();
    j();
  }
  
  private void l()
  {
    if (!f())
    {
      DialogUtil.a(this.e, 230).setMessage(this.e.getString(2131892026)).setPositiveButton(17039370, new GuildAIOMultiActionHelper.2(this)).setNegativeButton(17039360, new GuildAIOMultiActionHelper.1(this)).show();
      return;
    }
    if ((!MultiMsgManager.a().i().isEmpty()) && (g())) {
      this.c.a(false, null, false);
    }
  }
  
  private void m()
  {
    String str1 = this.d.getCurrentAccountUin();
    Object localObject2 = MultiMsgManager.a().i();
    int i = ((List)localObject2).size();
    if (i == 0)
    {
      a(this.e.getString(2131886152));
      return;
    }
    if (i > 50)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(this.e.getString(2131886154));
      ((StringBuilder)localObject1).append(50);
      ((StringBuilder)localObject1).append(this.e.getString(2131886155));
      a(((StringBuilder)localObject1).toString());
      return;
    }
    String str2 = MsgProxyUtils.d((MessageRecord)((List)localObject2).get(0));
    Object localObject3 = this.g.b;
    Object localObject1 = ((List)localObject2).iterator();
    while (((Iterator)localObject1).hasNext()) {
      if (!MsgProxyUtils.d((ChatMessage)((Iterator)localObject1).next()).equals(str2))
      {
        a(this.e.getString(2131886153));
        return;
      }
    }
    if (((FriendsManager)this.d.getManager(QQManagerFactory.FRIENDS_MANAGER)).n(str2)) {
      localObject1 = "1";
    } else {
      localObject1 = "0";
    }
    int j = h();
    localObject3 = NewReportPlugin.a((String)localObject3, this.c.F());
    String str3 = NewReportPlugin.a((List)localObject2);
    localObject2 = Base64Util.encodeToString(JubaoApiPlugin.a((List)localObject2).getBytes(), 2);
    String str4 = ((GuildChatContext)this.c.bv()).S();
    NewReportPlugin.a(this.e, str2, (String)localObject1, str4, str1, j, str3, i, (String)localObject2, (Bundle)localObject3);
  }
  
  protected int a(int paramInt)
  {
    return this.d.getApplication().getResources().getColor(paramInt);
  }
  
  public String a(MessageForStructing paramMessageForStructing)
  {
    String str = paramMessageForStructing.getSummaryMsg();
    Object localObject2 = str;
    if ((paramMessageForStructing.structingMsg instanceof StructMsgForGeneralShare))
    {
      localObject2 = (StructMsgForGeneralShare)paramMessageForStructing.structingMsg;
      paramMessageForStructing = ((StructMsgForGeneralShare)localObject2).mContentSummary;
      Object localObject1 = paramMessageForStructing;
      if (paramMessageForStructing == null)
      {
        localObject1 = paramMessageForStructing;
        if (((StructMsgForGeneralShare)localObject2).mStructMsgItemLists != null)
        {
          localObject2 = ((StructMsgForGeneralShare)localObject2).mStructMsgItemLists.iterator();
          do
          {
            do
            {
              localObject1 = paramMessageForStructing;
              if (!((Iterator)localObject2).hasNext()) {
                break;
              }
              localObject1 = (AbsStructMsgElement)((Iterator)localObject2).next();
            } while (!(localObject1 instanceof StructMsgItemLayout2));
            localObject1 = (StructMsgItemLayout2)localObject1;
          } while (((StructMsgItemLayout2)localObject1).ax == null);
          Iterator localIterator = ((StructMsgItemLayout2)localObject1).ax.iterator();
          localObject1 = paramMessageForStructing;
          for (;;)
          {
            paramMessageForStructing = (MessageForStructing)localObject1;
            if (!localIterator.hasNext()) {
              break;
            }
            paramMessageForStructing = (AbsStructMsgElement)localIterator.next();
            if ((paramMessageForStructing instanceof StructMsgItemSummary)) {
              localObject1 = ((StructMsgItemSummary)paramMessageForStructing).aA;
            }
          }
        }
      }
      localObject2 = str;
      if (localObject1 != null)
      {
        paramMessageForStructing = new StringBuilder();
        paramMessageForStructing.append(str);
        paramMessageForStructing.append((String)localObject1);
        localObject2 = paramMessageForStructing.toString();
      }
    }
    return localObject2;
  }
  
  public void a()
  {
    Object localObject = this.a;
    if (localObject != null) {
      ((LinearLayout)localObject).setVisibility(0);
    }
    ((SelectToBottomHelper)this.c.q(40)).b();
    localObject = this.b;
    if (localObject != null)
    {
      ((View)localObject).setVisibility(0);
      this.b.setClickable(true);
    }
  }
  
  public void a(ChatMessage paramChatMessage)
  {
    int i = this.e.getApplicationContext().getResources().getDimensionPixelSize(2131297617);
    int j = this.e.getResources().getDimensionPixelOffset(2131297615);
    paramChatMessage = (RelativeLayout)this.c.aW().findViewById(2131430542);
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie.GuildAIOMultiActionHelper", 2, "createMulti");
    }
    RelativeLayout.LayoutParams localLayoutParams;
    if (this.b == null)
    {
      this.b = new View(this.e);
      localLayoutParams = new RelativeLayout.LayoutParams(-1, i + j);
      localLayoutParams.addRule(12);
      this.b.setLayoutParams(localLayoutParams);
      this.b.setFocusableInTouchMode(true);
      this.b.setFocusable(true);
      this.b.setContentDescription("");
      paramChatMessage.addView(this.b);
    }
    if (this.a == null)
    {
      this.a = new LinearLayout(this.e);
      this.a.setOrientation(0);
      localLayoutParams = new RelativeLayout.LayoutParams(-1, i);
      localLayoutParams.addRule(12);
      this.a.setLayoutParams(localLayoutParams);
      this.a.setBackground(null);
      paramChatMessage.addView(this.a);
    }
    this.a.removeAllViews();
    this.a.setId(2131428033);
    ((SelectToBottomHelper)this.c.q(40)).a(this.a, j, paramChatMessage);
    k();
    this.b.setBackgroundColor(d());
    a();
    paramChatMessage = this.c.bv().e().b();
    paramChatMessage.a(paramChatMessage.q(), paramChatMessage.o(), paramChatMessage.p(), i + j);
  }
  
  protected void a(String paramString)
  {
    BaseActivity localBaseActivity = this.e;
    DialogUtil.a(localBaseActivity, 230, null, paramString, "", localBaseActivity.getString(2131886151), new GuildAIOMultiActionHelper.4(this), null).show();
  }
  
  public void a(String paramString, ArrayList<String> paramArrayList)
  {
    ((IGPSService)this.d.getRuntimeService(IGPSService.class, "")).fetchUserInfo(paramString, paramArrayList, true, new GuildAIOMultiActionHelper.3(this));
  }
  
  public void a(Map<String, String> paramMap, ArrayList<ChatMessage> paramArrayList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramArrayList.size())
    {
      ChatMessage localChatMessage = (ChatMessage)paramArrayList.get(i);
      MessageForStructing localMessageForStructing = null;
      Object localObject2 = null;
      Object localObject1;
      if ((localChatMessage instanceof MessageForText))
      {
        localObject1 = (MessageForText)localChatMessage;
        if (((MessageForText)localObject1).sb != null) {
          localObject2 = ((MessageForText)localObject1).sb.toString();
        } else {
          localObject2 = ((MessageForText)localObject1).msg;
        }
        localObject1 = localObject2;
        if (TextUtils.hasSysEmotion((String)localObject2)) {
          localObject1 = TextUtils.Symbol2FavoriteSymbol((String)localObject2);
        }
      }
      else if ((localChatMessage instanceof MessageForPic))
      {
        localObject1 = HardCodeUtil.a(2131898382);
      }
      else if ((localChatMessage instanceof MessageForShortVideo))
      {
        localObject1 = HardCodeUtil.a(2131898386);
      }
      else if ((!(localChatMessage instanceof MessageForMixedMsg)) && (!(localChatMessage instanceof MessageForLongMsg)))
      {
        if ((localChatMessage instanceof MessageForStructing))
        {
          localMessageForStructing = (MessageForStructing)localChatMessage;
          if (localMessageForStructing.structingMsg != null) {
            if ((localMessageForStructing.structingMsg instanceof StructMsgForHypertext))
            {
              localObject2 = ((StructMsgForHypertext)localMessageForStructing.structingMsg).getSpannableString(false).toString();
            }
            else if (localMessageForStructing.structingMsg.mMsgServiceID == 32)
            {
              localObject2 = a(localMessageForStructing);
            }
            else
            {
              localObject1 = localMessageForStructing.getSummaryMsg();
              localObject2 = localObject1;
              if (localMessageForStructing.structingMsg.mMsgUrl != null)
              {
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append((String)localObject1);
                ((StringBuilder)localObject2).append("\n");
                ((StringBuilder)localObject2).append(localMessageForStructing.structingMsg.mMsgUrl);
                localObject2 = ((StringBuilder)localObject2).toString();
              }
            }
          }
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = HardCodeUtil.a(2131898388);
          }
        }
        else
        {
          localObject1 = localMessageForStructing;
          if ((localChatMessage instanceof MessageForArkFlashChat))
          {
            localObject1 = localMessageForStructing;
            if (localChatMessage.msg != null) {
              localObject1 = localChatMessage.msg;
            }
          }
        }
      }
      else
      {
        localObject1 = MessageForMixedMsg.getTextFromMixedMsg(localChatMessage).toString();
      }
      if (localObject1 != null)
      {
        localObject2 = new SimpleDateFormat("", Locale.SIMPLIFIED_CHINESE);
        ((SimpleDateFormat)localObject2).applyPattern("HH:mm:ss");
        localObject2 = ((SimpleDateFormat)localObject2).format(Long.valueOf(localChatMessage.time * 1000L));
        localStringBuilder.append((String)paramMap.get(localChatMessage.senderuin));
        localStringBuilder.append(" ");
        localStringBuilder.append((String)localObject2);
        localStringBuilder.append("\n");
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append("\n");
        if (i != paramArrayList.size() - 1) {
          localStringBuilder.append("\n");
        }
      }
      i += 1;
    }
    ((ClipboardManager)this.e.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("simple text", localStringBuilder.toString()));
    QQToast.makeText(this.d.getApp(), 2131892028, 0).show(this.c.A());
  }
  
  protected int b()
  {
    return 2131166188;
  }
  
  protected boolean b(ChatMessage paramChatMessage)
  {
    boolean bool = paramChatMessage instanceof MessageForPic;
    if ((bool) && (((IPicFlash)QRoute.api(IPicFlash.class)).isFlashPicMsg(paramChatMessage))) {
      return false;
    }
    if ((!(paramChatMessage instanceof MessageForTroopFile)) && (!(paramChatMessage instanceof MessageForQQStoryComment)))
    {
      if ((paramChatMessage instanceof MessageForArkApp)) {
        return false;
      }
      if ((bool) && (ZhituManager.a((MessageForPic)paramChatMessage))) {
        return false;
      }
      return MultiMsgProxy.a(paramChatMessage);
    }
    return false;
  }
  
  protected int c()
  {
    return 2130840647;
  }
  
  protected int d()
  {
    return -1;
  }
  
  public void e()
  {
    Object localObject = this.a;
    if (localObject != null) {
      ((LinearLayout)localObject).setVisibility(8);
    }
    ((SelectToBottomHelper)this.c.q(40)).a();
    localObject = this.b;
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
  }
  
  public boolean f()
  {
    Iterator localIterator = MultiMsgManager.a().b.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if ((((Boolean)localEntry.getValue()).booleanValue()) && (!b((ChatMessage)localEntry.getKey()))) {
        return false;
      }
    }
    return true;
  }
  
  public boolean g()
  {
    List localList = MultiMsgManager.a().i();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      ChatMessage localChatMessage = (ChatMessage)localIterator.next();
      if (!b(localChatMessage)) {
        localArrayList.add(localChatMessage);
      }
    }
    localList.removeAll(localArrayList);
    if (localList.isEmpty())
    {
      QQToast.makeText(this.d.getApp(), 2131892027, 0).show(this.c.A());
      return false;
    }
    ((MultiForwardHelper)this.c.q(1)).a(localList, 4);
    return true;
  }
  
  public String getTag()
  {
    return "Q.aio.BaseChatPie.GuildAIOMultiActionHelper";
  }
  
  protected int h()
  {
    return 25080;
  }
  
  public int[] interestedIn()
  {
    return new int[0];
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131430631)
    {
      if (i != 2131430636) {
        return;
      }
      if (!UIUtils.d()) {
        m();
      }
    }
    else
    {
      l();
    }
  }
  
  public void onMoveToState(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.helper.GuildAIOMultiActionHelper
 * JD-Core Version:    0.7.0.1
 */