package com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.ecshop.ad.api.IEcshopAdApi;
import com.tencent.mobileqq.ecshop.temp.api.impl.EcshopMessageApiImpl;
import com.tencent.mobileqq.guild.chatpie.msgviewbuild.baseview.GuildMsgItemLayout;
import com.tencent.mobileqq.qqgamepub.api.IGameShareUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;

public class GuildStructingMsgItemBuilder
  extends BaseGuildMsgViewBuild
{
  private void a(View paramView, AbsStructMsg paramAbsStructMsg)
  {
    if (paramAbsStructMsg.mMsgServiceID == 35)
    {
      paramView = (BaseBubbleBuilder.ViewHolder)paramView.getTag();
      paramView.h.setPadding(paramView.h.getPaddingLeft(), 0, paramView.h.getPaddingRight(), 0);
    }
  }
  
  private void a(GuildStructingMsgItemBuilder.GuildStructingMsgViewHolder paramGuildStructingMsgViewHolder, GuildMsgItemLayout paramGuildMsgItemLayout, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramGuildMsgItemLayout.setHeadIconVisible(8);
      paramGuildStructingMsgViewHolder.j.setBackgroundResource(2130853309);
      int i = paramGuildStructingMsgViewHolder.a.getPaddingLeft();
      int j = paramGuildStructingMsgViewHolder.a.getPaddingLeft();
      paramGuildStructingMsgViewHolder.a.setPadding(0, i, 0, j);
      return;
    }
    paramGuildMsgItemLayout.setHeadIconVisible(0);
  }
  
  private void a(GuildStructingMsgItemBuilder.GuildStructingMsgViewHolder paramGuildStructingMsgViewHolder, GuildMsgItemLayout paramGuildMsgItemLayout, boolean paramBoolean1, AbsStructMsg paramAbsStructMsg, Resources paramResources, boolean paramBoolean2)
  {
    Object localObject2 = paramGuildStructingMsgViewHolder.b;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new RelativeLayout(this.b);
      paramGuildStructingMsgViewHolder.b = ((RelativeLayout)localObject1);
      ((RelativeLayout)localObject1).setId(2131446456);
      paramGuildMsgItemLayout.addView((View)localObject1);
    }
    Object localObject3 = (RelativeLayout.LayoutParams)((RelativeLayout)localObject1).getLayoutParams();
    localObject2 = localObject3;
    if (localObject3 == null) {
      localObject2 = new RelativeLayout.LayoutParams(-2, -2);
    }
    ((RelativeLayout.LayoutParams)localObject2).topMargin = AIOUtils.b(-2.0F, paramResources);
    if (paramBoolean2)
    {
      ((RelativeLayout.LayoutParams)localObject2).leftMargin = AIOUtils.b(0.0F, paramResources);
    }
    else
    {
      ((RelativeLayout.LayoutParams)localObject2).leftMargin = AIOUtils.b(10.0F, paramResources);
      if (a(paramBoolean1, paramAbsStructMsg)) {
        ((RelativeLayout.LayoutParams)localObject2).leftMargin += AIOUtils.b(18.0F, paramResources);
      }
    }
    ((RelativeLayout.LayoutParams)localObject2).addRule(5, 2131430578);
    ((RelativeLayout.LayoutParams)localObject2).addRule(3, 2131430578);
    ((RelativeLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    localObject3 = ((RelativeLayout)localObject1).getChildAt(0);
    localObject2 = localObject3;
    if (localObject3 != null)
    {
      localObject2 = localObject3;
      if (paramGuildStructingMsgViewHolder.a != null)
      {
        Object localObject4 = paramGuildStructingMsgViewHolder.a.getChildAt(0);
        localObject2 = localObject3;
        if (localObject4 != null)
        {
          localObject4 = ((View)localObject4).getTag(2131446476);
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("bindviwfor structmsg tag:");
            ((StringBuilder)localObject2).append(localObject4);
            QLog.d("structMsg", 2, ((StringBuilder)localObject2).toString());
          }
          if (localObject4 != null)
          {
            localObject2 = localObject3;
            if (localObject4.getClass() == paramAbsStructMsg.getClass()) {}
          }
          else
          {
            localObject2 = null;
          }
        }
      }
    }
    ((RelativeLayout)localObject1).removeAllViews();
    ((RelativeLayout)localObject1).setBackgroundDrawable(null);
    localObject2 = paramAbsStructMsg.getSourceView(this.b, (View)localObject2);
    if (localObject2 != null)
    {
      ((View)localObject2).setId(2131446457);
      ((RelativeLayout)localObject1).addView((View)localObject2);
      if (ThemeUtil.isInNightMode(this.g))
      {
        paramGuildStructingMsgViewHolder = new View(this.b);
        paramGuildMsgItemLayout = new RelativeLayout.LayoutParams(-2, -2);
        paramGuildMsgItemLayout.addRule(6, 2131446457);
        paramGuildMsgItemLayout.addRule(5, 2131446457);
        paramGuildMsgItemLayout.addRule(7, 2131446457);
        paramGuildMsgItemLayout.addRule(8, 2131446457);
        paramGuildStructingMsgViewHolder.setBackgroundResource(2130837953);
        ((RelativeLayout)localObject1).addView(paramGuildStructingMsgViewHolder, paramGuildMsgItemLayout);
      }
    }
    else
    {
      paramGuildMsgItemLayout.removeView((View)localObject1);
      paramGuildStructingMsgViewHolder.b = null;
    }
    a(paramAbsStructMsg, (RelativeLayout)localObject1);
    ((IGameShareUtil)QRoute.api(IGameShareUtil.class)).tryHandleAioSource((View)localObject2, (RelativeLayout)localObject1, paramBoolean1, paramResources, this.b, paramAbsStructMsg);
  }
  
  private void a(AbsStructMsg paramAbsStructMsg)
  {
    if ((this.c != null) && (this.c.a != 1008) && (paramAbsStructMsg.hasFlag(4))) {
      paramAbsStructMsg.addFlag(1);
    }
  }
  
  private void a(AbsStructMsg paramAbsStructMsg, RelativeLayout paramRelativeLayout)
  {
    paramRelativeLayout.setVisibility(0);
    if ((paramAbsStructMsg.mMsgUrl != null) && ((paramAbsStructMsg.mMsgUrl.startsWith("https://3gimg.qq.com/wap30/infoopstatic")) || (paramAbsStructMsg.mMsgUrl.startsWith("https://viola.qq.com/js/redpackIndex.js"))) && ("1".equals(Uri.parse(paramAbsStructMsg.mMsgUrl).getQueryParameter("hidesource")))) {
      paramRelativeLayout.setVisibility(8);
    }
  }
  
  private boolean a(boolean paramBoolean, AbsStructMsg paramAbsStructMsg)
  {
    return (paramBoolean) && ((paramAbsStructMsg.mMsgServiceID == 83) || (paramAbsStructMsg.mMsgServiceID == 108) || (paramAbsStructMsg.mMsgServiceID == 114) || (paramAbsStructMsg.mMsgServiceID == 116) || (paramAbsStructMsg.mMsgServiceID == 151) || (paramAbsStructMsg.mMsgServiceID == 156)) && (!TextUtils.isEmpty(paramAbsStructMsg.mMsgActionData));
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    MessageForStructing localMessageForStructing = (MessageForStructing)paramChatMessage;
    AbsStructMsg localAbsStructMsg = localMessageForStructing.structingMsg;
    if (localAbsStructMsg == null) {
      return paramView;
    }
    localAbsStructMsg.message = localMessageForStructing;
    if (("3046055438".equals(this.c.b)) && ((localAbsStructMsg instanceof StructMsgForGeneralShare))) {
      EcshopMessageApiImpl.handlePubTailMsg(localMessageForStructing);
    }
    paramView = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramOnLongClickAndTouchListener);
    a(paramView, localAbsStructMsg);
    paramViewGroup = (GuildStructingMsgItemBuilder.GuildStructingMsgViewHolder)paramView.getTag();
    if (paramViewGroup == null) {
      return paramView;
    }
    paramOnLongClickAndTouchListener = paramViewGroup.k;
    a(localAbsStructMsg);
    Resources localResources = this.b.getResources();
    boolean bool = a(localMessageForStructing);
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getView:position:");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("hasHead");
      localStringBuilder.append(bool);
      QLog.d("GuildStructingMsgItemBuilder", 4, localStringBuilder.toString());
    }
    a(paramViewGroup, paramOnLongClickAndTouchListener, bool);
    a(paramViewGroup, paramOnLongClickAndTouchListener, localMessageForStructing.isSend(), localAbsStructMsg, localResources, bool);
    paramView.requestLayout();
    ((IEcshopAdApi)QRoute.api(IEcshopAdApi.class)).bindViewForGdtReport(this.g, paramChatMessage, paramView);
    return paramView;
  }
  
  @NonNull
  protected View a(ChatMessage paramChatMessage, BaseGuildMsgViewBuild.ViewHolder paramViewHolder, View paramView, GuildMsgItemLayout paramGuildMsgItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    return null;
  }
  
  protected boolean a(MessageForStructing paramMessageForStructing)
  {
    paramMessageForStructing = paramMessageForStructing.structingMsg;
    boolean bool2 = paramMessageForStructing.hasFlag(4);
    boolean bool1 = bool2;
    if ((paramMessageForStructing instanceof AbsShareMsg))
    {
      bool1 = bool2;
      if (((AbsShareMsg)paramMessageForStructing).mMsgException) {
        bool1 = true;
      }
    }
    if ((paramMessageForStructing.mMsgServiceID == 76) || (paramMessageForStructing.mMsgServiceID == 91)) {
      bool1 = true;
    }
    return bool1;
  }
  
  protected String b_(ChatMessage paramChatMessage)
  {
    return null;
  }
  
  protected GuildStructingMsgItemBuilder.GuildStructingMsgViewHolder c()
  {
    return new GuildStructingMsgItemBuilder.GuildStructingMsgViewHolder();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder.GuildStructingMsgItemBuilder
 * JD-Core Version:    0.7.0.1
 */