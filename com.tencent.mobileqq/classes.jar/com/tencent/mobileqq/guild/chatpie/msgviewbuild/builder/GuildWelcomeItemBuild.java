package com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.guild.api.IGuildInfoUtilsApi;
import com.tencent.mobileqq.guild.message.api.IMessageRecordForGuildWelcome;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import java.lang.ref.WeakReference;

public class GuildWelcomeItemBuild
  extends AbstractChatItemBuilder
{
  public GuildWelcomeItemBuild(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  private void a(ChatMessage paramChatMessage, GuildWelcomeItemBuild.Holder paramHolder)
  {
    IMessageRecordForGuildWelcome localIMessageRecordForGuildWelcome = (IMessageRecordForGuildWelcome)paramChatMessage;
    IGProGuildInfo localIGProGuildInfo = ((IGPSService)this.a.getRuntimeService(IGPSService.class, "")).getGuildInfo(localIMessageRecordForGuildWelcome.getGuildUin());
    paramHolder.d.setText(b(paramChatMessage));
    paramHolder.e.setText(c(paramChatMessage));
    if (localIMessageRecordForGuildWelcome.getWelcomeType() == 1)
    {
      paramHolder.f.setVisibility(0);
      paramHolder.f.setOnClickListener(new -..Lambda.GuildWelcomeItemBuild.JrDMmyfyGoYrUvENLTmmpmoEQkU(localIGProGuildInfo));
      return;
    }
    paramHolder.f.setVisibility(8);
  }
  
  private CharSequence b(ChatMessage paramChatMessage)
  {
    if (!(paramChatMessage instanceof IMessageRecordForGuildWelcome)) {
      return "";
    }
    paramChatMessage = (IMessageRecordForGuildWelcome)paramChatMessage;
    int i = paramChatMessage.getWelcomeType();
    if (i != 1)
    {
      if ((i != 2) && (i != 3) && (i != 4)) {
        return "";
      }
      paramChatMessage = ((IGPSService)this.a.getRuntimeService(IGPSService.class, "")).getChannelInfo(paramChatMessage.getChannelUin());
      if (paramChatMessage != null) {
        paramChatMessage = paramChatMessage.getChannelName();
      } else {
        paramChatMessage = this.c.getString(2131887708);
      }
      String str = this.c.getString(2131890636);
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
      localSpannableStringBuilder.append(str).append(" ").append(paramChatMessage);
      localSpannableStringBuilder.setSpan(new StyleSpan(1), 0, localSpannableStringBuilder.length(), 18);
      return localSpannableStringBuilder;
    }
    return this.c.getString(2131890366);
  }
  
  private CharSequence c(ChatMessage paramChatMessage)
  {
    if (!(paramChatMessage instanceof IMessageRecordForGuildWelcome)) {
      return "";
    }
    int i = ((IMessageRecordForGuildWelcome)paramChatMessage).getWelcomeType();
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4) {
            return "";
          }
          return (String)this.c.getText(2131890388);
        }
        return (String)this.c.getText(2131890399);
      }
      return (String)this.c.getText(2131890365);
    }
    return (String)this.c.getText(2131890368);
  }
  
  protected View a(MessageRecord paramMessageRecord, AbstractChatItemBuilder.ViewHolder paramViewHolder, View paramView, LinearLayout paramLinearLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramOnLongClickAndTouchListener = paramLinearLayout.getContext();
    paramLinearLayout = (GuildWelcomeItemBuild.Holder)paramViewHolder;
    paramViewHolder = paramView;
    if (paramView == null)
    {
      paramViewHolder = LayoutInflater.from(paramOnLongClickAndTouchListener).inflate(2131625132, null);
      paramLinearLayout.d = ((TextView)paramViewHolder.findViewById(2131434767));
      paramLinearLayout.e = ((TextView)paramViewHolder.findViewById(2131434766));
      paramLinearLayout.f = ((Button)paramViewHolder.findViewById(2131434728));
      paramLinearLayout.g = paramViewHolder.findViewById(2131434764);
      paramLinearLayout.h = paramViewHolder.findViewById(2131434765);
      paramLinearLayout.i = ((TextView)paramViewHolder.findViewById(2131434763));
    }
    paramView = (ChatMessage)paramMessageRecord;
    a(paramView, paramLinearLayout);
    a((IMessageRecordForGuildWelcome)paramMessageRecord, paramLinearLayout);
    if (AppSetting.e)
    {
      paramMessageRecord = new StringBuilder();
      paramMessageRecord.append(b(paramView).toString());
      paramMessageRecord.append(c(paramView).toString());
      paramViewHolder.setContentDescription(paramMessageRecord.toString());
    }
    return paramViewHolder;
  }
  
  protected AbstractChatItemBuilder.ViewHolder a()
  {
    return new GuildWelcomeItemBuild.Holder();
  }
  
  void a(IMessageRecordForGuildWelcome paramIMessageRecordForGuildWelcome, GuildWelcomeItemBuild.Holder paramHolder)
  {
    if (paramIMessageRecordForGuildWelcome.getWelcomeType() != 2) {
      return;
    }
    Object localObject = paramIMessageRecordForGuildWelcome.getGuildUin();
    if (!((IGuildInfoUtilsApi)QRoute.api(IGuildInfoUtilsApi.class)).isCreatorOrAdmin(this.a, (String)localObject)) {
      return;
    }
    localObject = paramIMessageRecordForGuildWelcome.getChannelUin();
    paramIMessageRecordForGuildWelcome = (IGPSService)this.a.getRuntimeService(IGPSService.class, "");
    localObject = paramIMessageRecordForGuildWelcome.getChannelInfo((String)localObject);
    int i = ((IGProChannelInfo)localObject).getVisibleType();
    if (i == 0)
    {
      paramHolder.g.setVisibility(8);
      paramHolder.h.setVisibility(8);
      return;
    }
    paramHolder.g.setVisibility(0);
    paramHolder.h.setVisibility(0);
    paramHolder.h.setOnClickListener(new -..Lambda.GuildWelcomeItemBuild.oRsgGClILgiJSlE1zxSqjqBZ_Rc((IGProChannelInfo)localObject));
    if (i == 1)
    {
      paramIMessageRecordForGuildWelcome = paramHolder.i.getContext();
      paramHolder.i.setText(paramIMessageRecordForGuildWelcome.getString(2131890637));
      return;
    }
    paramHolder.i.setText("");
    paramIMessageRecordForGuildWelcome.getVisibleMemberCount(((IGProChannelInfo)localObject).getGuildId(), ((IGProChannelInfo)localObject).getChannelUin(), new -..Lambda.GuildWelcomeItemBuild.beHLofFIxqt-ey_vNpwK4XMV-H4(new WeakReference(paramHolder.i)));
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    return new QQCustomMenuItem[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder.GuildWelcomeItemBuild
 * JD-Core Version:    0.7.0.1
 */