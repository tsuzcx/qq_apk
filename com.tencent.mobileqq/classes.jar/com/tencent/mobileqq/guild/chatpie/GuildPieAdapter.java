package com.tencent.mobileqq.guild.chatpie;

import android.content.Context;
import android.support.v4.util.ArraySet;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.ChatItemBuilder;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForTroopUnreadTips;
import com.tencent.mobileqq.guild.message.api.IMessageRecordForGuildWelcome;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

public class GuildPieAdapter
  extends ChatAdapter1
{
  public GuildMsgItemBuildFactory r;
  private int s = 0;
  
  public GuildPieAdapter(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner, BaseChatPie paramBaseChatPie)
  {
    super(paramQQAppInterface, paramContext, paramSessionInfo, paramAIOAnimationConatiner, paramBaseChatPie);
    this.r = new GuildMsgItemBuildFactory(paramContext, paramQQAppInterface, paramSessionInfo, paramAIOAnimationConatiner, paramBaseChatPie);
    this.f = new GuildPieAdapter.GuildBubbleOnlongClickListener(this);
  }
  
  private View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramInt >= this.a.size()) {
      return paramView;
    }
    ChatMessage localChatMessage = (ChatMessage)this.a.get(paramInt);
    a(paramInt, paramViewGroup, localChatMessage);
    paramView = this.r.a(localChatMessage, this).a(paramInt, getCount(), localChatMessage, paramView, paramViewGroup, this.f);
    if (paramView != null) {
      paramView.setTag(2131430591, localChatMessage);
    }
    return paramView;
  }
  
  private void a(ChatMessage paramChatMessage1, ChatMessage paramChatMessage2)
  {
    if (paramChatMessage1 != null)
    {
      if (paramChatMessage2 == null) {
        return;
      }
      if ((paramChatMessage1 instanceof MessageForTroopUnreadTips)) {
        paramChatMessage2.setIsNeedCombine(false);
      }
      if ((paramChatMessage1 instanceof IMessageRecordForGuildWelcome))
      {
        paramChatMessage2.mNeedTimeStamp = true;
        paramChatMessage2.setIsNeedCombine(false);
      }
    }
  }
  
  private boolean a(long paramLong1, long paramLong2)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramLong1 * 1000L);
    int i = localCalendar.get(6);
    int j = localCalendar.get(1);
    localCalendar.setTimeInMillis(paramLong2 * 1000L);
    int k = localCalendar.get(6);
    int m = localCalendar.get(1);
    return (i == k) && (j == m);
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    if (TextUtils.equals(paramString1, paramString2)) {
      return true;
    }
    String str = ((IGPSService)this.b.getRuntimeService(IGPSService.class, "")).getSelfTinyId();
    if (TextUtils.equals(paramString2, this.b.getCurrentUin())) {
      return a(paramString1, str);
    }
    if (TextUtils.equals(paramString1, this.b.getCurrentUin())) {
      return a(str, paramString2);
    }
    return false;
  }
  
  private boolean i()
  {
    return this.k instanceof GuildChatPie;
  }
  
  private boolean j()
  {
    return ((GuildChatContext)this.k.bv()).W();
  }
  
  protected void a(int paramInt, ViewGroup paramViewGroup, ChatMessage paramChatMessage)
  {
    boolean bool2 = false;
    if (paramInt > 0)
    {
      paramViewGroup = (ChatMessage)this.a.get(paramInt - 1);
      paramChatMessage.mNeedTimeStamp = (a(paramViewGroup.time, paramChatMessage.time) ^ true);
      boolean bool1 = bool2;
      if (!j())
      {
        bool1 = bool2;
        if (a(paramViewGroup.senderuin, paramChatMessage.senderuin))
        {
          bool1 = bool2;
          if (paramChatMessage.time - paramViewGroup.time <= 30L)
          {
            bool1 = bool2;
            if (!paramChatMessage.mNeedTimeStamp) {
              bool1 = true;
            }
          }
        }
      }
      paramChatMessage.setIsNeedCombine(bool1);
      a(paramViewGroup, paramChatMessage);
      return;
    }
    paramChatMessage.setIsNeedCombine(false);
  }
  
  public void a(View paramView, ChatMessage paramChatMessage, int paramInt)
  {
    ChatItemBuilder localChatItemBuilder = this.r.a(paramChatMessage, this);
    if (localChatItemBuilder != null) {
      localChatItemBuilder.a(paramView, paramChatMessage, paramInt);
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (this.j == null) {
        return;
      }
      int i = this.j.getChildCount() - 1;
      while (i >= 0)
      {
        View localView = this.j.getChildAt(i);
        ChatMessage localChatMessage = (ChatMessage)localView.getTag(2131430591);
        if ((localChatMessage != null) && (paramString.equals(localChatMessage.senderuin)))
        {
          ChatItemBuilder localChatItemBuilder = this.r.a(localChatMessage, this);
          if (localChatItemBuilder != null) {
            localChatItemBuilder.a(localView, localChatMessage, paramInt);
          }
        }
        i -= 1;
      }
    }
  }
  
  public void a(List<ChatMessage> paramList, CharSequence paramCharSequence, int paramInt)
  {
    paramCharSequence = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ChatMessage localChatMessage = (ChatMessage)paramList.next();
      if (!c(localChatMessage)) {
        paramCharSequence.add(localChatMessage);
      }
    }
    if (paramCharSequence.size() > 0)
    {
      paramList = (ChatMessage)paramCharSequence.get(paramCharSequence.size() - 1);
      if (GuildMsgItemBuildFactory.a(this.b, paramList) == GuildMsgItemBuildFactory.k) {
        paramCharSequence.remove(paramCharSequence.size() - 1);
      }
    }
    b(paramCharSequence);
    this.a = paramCharSequence;
    if (this.a.size() > 0) {
      this.n.add(Long.valueOf(((ChatMessage)this.a.get(0)).uniseq));
    }
    super.notifyDataSetChanged();
  }
  
  protected void b(List<ChatMessage> paramList) {}
  
  protected boolean c(ChatMessage paramChatMessage)
  {
    return GuildMsgItemBuildFactory.a(this.b, paramChatMessage) == GuildMsgItemBuildFactory.a;
  }
  
  public void d()
  {
    GuildMsgItemBuildFactory localGuildMsgItemBuildFactory = this.r;
    if (localGuildMsgItemBuildFactory != null) {
      localGuildMsgItemBuildFactory.a();
    }
    this.i.setDecodeTaskCompletionListener(null);
    this.i.destory();
  }
  
  public int getItemViewType(int paramInt)
  {
    int i = paramInt;
    if (paramInt > this.a.size() - 1) {
      i = this.a.size() - 1;
    }
    paramInt = i;
    if (i < 0) {
      paramInt = 0;
    }
    ChatMessage localChatMessage = (ChatMessage)this.a.get(paramInt);
    if (localChatMessage != null) {
      localChatMessage.parse();
    }
    return GuildMsgItemBuildFactory.a(this.b, localChatMessage);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if ((this.a != null) && (!this.a.isEmpty()))
    {
      if (!i()) {
        return super.getView(paramInt, paramView, paramViewGroup);
      }
      return a(paramInt, paramView, paramViewGroup);
    }
    paramView = new StringBuilder();
    paramView.append("list is null position is ");
    paramView.append(paramInt);
    QLog.e("GuildPieAdapter", 1, paramView.toString());
    return null;
  }
  
  public int getViewTypeCount()
  {
    return GuildMsgItemBuildFactory.q;
  }
  
  public String h()
  {
    return ((GuildChatContext)this.k.bv()).T();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.GuildPieAdapter
 * JD-Core Version:    0.7.0.1
 */