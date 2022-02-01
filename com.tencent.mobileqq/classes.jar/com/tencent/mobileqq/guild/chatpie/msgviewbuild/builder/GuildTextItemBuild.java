package com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint.FontMetrics;
import android.text.ClipboardManager;
import android.text.Layout.Alignment;
import android.text.Spannable.Factory;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.etrump.mixlayout.ETTextView;
import com.etrump.mixlayout.VasShieldFont;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.ecommerce.ECommerceDataReportUtil;
import com.tencent.mobileqq.activity.aio.item.MessageFoldable;
import com.tencent.mobileqq.activity.selectable.AIOSelectableDelegateImpl;
import com.tencent.mobileqq.activity.selectable.AIOSelectableDelegateProxy;
import com.tencent.mobileqq.activity.selectable.SelectableComponent;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForLongTextMsg;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.guild.chatpie.msgviewbuild.baseview.GuildMsgItemLayout;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.qphone.base.util.QLog;

public class GuildTextItemBuild
  extends BaseGuildMsgViewBuild
{
  protected View.OnClickListener a = new GuildTextItemBuild.3(this);
  
  public GuildTextItemBuild(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  private void a(ChatMessage paramChatMessage, String paramString)
  {
    paramChatMessage = a(paramChatMessage, paramString, AIOSelectableDelegateImpl.a());
    if (paramChatMessage != null) {
      try
      {
        ((ClipboardManager)this.b.getSystemService("clipboard")).setText(paramChatMessage);
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("Copy message, msg=");
          paramString.append(paramChatMessage);
          QLog.d("GuildTextItemBuild", 2, paramString.toString());
          return;
        }
      }
      catch (Exception paramChatMessage)
      {
        QLog.e("GuildTextItemBuild", 2, paramChatMessage.toString());
      }
    }
  }
  
  @NonNull
  protected View a(ChatMessage paramChatMessage, BaseGuildMsgViewBuild.ViewHolder paramViewHolder, View paramView, GuildMsgItemLayout paramGuildMsgItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    Context localContext = paramGuildMsgItemLayout.getContext();
    Object localObject = paramViewHolder.j;
    if ((paramViewHolder instanceof GuildTextItemBuild.Holder))
    {
      paramView = (GuildTextItemBuild.Holder)paramViewHolder;
      paramViewHolder = (BaseGuildMsgViewBuild.ViewHolder)localObject;
    }
    else
    {
      paramViewHolder = (GuildTextItemBuild.Holder)a();
      paramViewHolder.k = ((GuildMsgItemLayout)paramView);
      paramView.setTag(paramViewHolder);
      localObject = null;
      paramView = paramViewHolder;
      paramViewHolder = (BaseGuildMsgViewBuild.ViewHolder)localObject;
    }
    localObject = paramViewHolder;
    if (paramViewHolder == null)
    {
      localObject = new ETTextView(localContext);
      com.tencent.mobileqq.text.TextUtils.fixTextViewANRForAnd10((TextView)localObject);
      ((ETTextView)localObject).setTextColor(localContext.getResources().getColorStateList(j()));
      ((ETTextView)localObject).setLinkTextColor(localContext.getResources().getColorStateList(k()));
      if (AppSetting.e) {
        ((ETTextView)localObject).setAutoLinkMask(3);
      } else {
        ((ETTextView)localObject).setAutoLinkMask(0);
      }
      ((ETTextView)localObject).setSpannableFactory(QQText.SPANNABLE_FACTORY);
      ((ETTextView)localObject).setMovementMethod(LinkMovementMethod.getInstance());
      ((ETTextView)localObject).setId(2131430581);
      paramView.i = ((TextView)localObject);
      paramView.n = new AIOSelectableDelegateProxy();
      paramView.n.a((SelectableComponent)localObject);
      paramView.n.a(paramGuildMsgItemLayout, paramGuildMsgItemLayout);
      paramView.i.setTextSize(16.666666F);
    }
    ((ETTextView)paramView.i).setFont(0, paramChatMessage.uniseq);
    paramView.i.setTypeface(null);
    ((ETTextView)paramView.i).setShadowLayer(0.0F, 0.0F, 0.0F, 0);
    ((ETTextView)paramView.i).setStrokeColor(false, 0);
    ((ETTextView)paramView.i).mMagicFont = false;
    ((ETTextView)paramView.i).setCacheMeasureResult(true);
    paramView.i.setTypeface(VasShieldFont.a(paramChatMessage));
    if (!android.text.TextUtils.isEmpty(paramChatMessage.getExtInfoFromExtStr("sens_msg_ctrl_info")))
    {
      paramViewHolder = ((ETTextView)paramView.i).getETLayout();
      if (paramViewHolder != null) {
        paramViewHolder.b = (paramChatMessage.uniseq + 1L);
      }
    }
    paramView.i.setGravity(16);
    paramView.i.setPadding(0, 0, 0, 0);
    paramView.i.setIncludeFontPadding(false);
    paramView.o = paramChatMessage.uniseq;
    a(paramChatMessage, paramView, localContext);
    paramView.i.setOnTouchListener(paramOnLongClickAndTouchListener);
    paramView.i.setOnLongClickListener(paramOnLongClickAndTouchListener);
    paramView.p = paramOnLongClickAndTouchListener;
    paramView.i.setOnClickListener(this.a);
    if (paramView.n != null) {
      paramView.n.b(paramChatMessage);
    }
    return localObject;
  }
  
  @RequiresApi(api=23)
  protected RelativeLayout.LayoutParams a(BaseGuildMsgViewBuild.ViewHolder paramViewHolder, View paramView, GuildMsgItemLayout paramGuildMsgItemLayout)
  {
    paramViewHolder = super.a(paramViewHolder, paramView, paramGuildMsgItemLayout);
    if (!(paramView instanceof ETTextView)) {
      return paramViewHolder;
    }
    paramGuildMsgItemLayout = (ETTextView)paramView;
    paramView = paramGuildMsgItemLayout.getPaint();
    paramGuildMsgItemLayout = new StaticLayout(paramGuildMsgItemLayout.getText(), paramView, GuildMsgItemLayout.o, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false);
    float f1 = paramGuildMsgItemLayout.getLineWidth(paramGuildMsgItemLayout.getLineCount() - 1);
    paramView = paramView.getFontMetrics();
    float f2 = (paramView.descent - paramView.ascent) / 2.0F;
    float f3 = paramView.leading;
    float f4 = ViewUtils.dpToPx(8.0F);
    if (ViewUtils.dpToPx(16.0F) + f1 >= GuildMsgItemLayout.o) {
      return paramViewHolder;
    }
    paramViewHolder.leftMargin = ((int)f1 + ViewUtils.dpToPx(2.0F));
    paramViewHolder.bottomMargin = ((int)(f2 + f3 - f4 + 0.0F));
    paramViewHolder.addRule(3, 0);
    paramViewHolder.addRule(8, 2131430578);
    return paramViewHolder;
  }
  
  protected BaseGuildMsgViewBuild.ViewHolder a()
  {
    return new GuildTextItemBuild.Holder();
  }
  
  public QQCustomMenu a(QQCustomMenu paramQQCustomMenu, ChatMessage paramChatMessage)
  {
    paramQQCustomMenu.a(2131431492, this.b.getString(2131888241), 2130840746);
    return paramQQCustomMenu;
  }
  
  protected String a(ChatMessage paramChatMessage, GuildTextItemBuild.Holder paramHolder, Context paramContext)
  {
    if ((paramChatMessage instanceof MessageForText))
    {
      MessageForText localMessageForText = (MessageForText)paramChatMessage;
      if (!android.text.TextUtils.isEmpty(localMessageForText.sb))
      {
        CharSequence localCharSequence;
        if (!android.text.TextUtils.isEmpty(localMessageForText.sb2)) {
          localCharSequence = localMessageForText.sb2;
        } else {
          localCharSequence = localMessageForText.sb;
        }
        a(paramChatMessage, localCharSequence, paramHolder, paramContext);
        return localMessageForText.sb.toString();
      }
      paramHolder.i.setText("");
      if (QLog.isColorLevel())
      {
        paramHolder = new StringBuilder();
        paramHolder.append("textitem text.sb is null");
        paramHolder.append(paramChatMessage.msgtype);
        QLog.d("GuildTextItemBuild", 2, paramHolder.toString());
      }
    }
    return "";
  }
  
  String a(ChatMessage paramChatMessage, String paramString, AIOSelectableDelegateImpl paramAIOSelectableDelegateImpl)
  {
    if (paramChatMessage.msg != null)
    {
      ECommerceDataReportUtil.a(this.g, paramChatMessage, 2);
      if (paramChatMessage.isMultiMsg)
      {
        ReportController.b(this.g, "dc00898", "", "", "0X8009AB7", "0X8009AB7", 0, 0, "", "", "", "");
        int i;
        if ((paramChatMessage instanceof MessageForLongTextMsg)) {
          i = 2;
        } else {
          i = 1;
        }
        paramString = this.g;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(i);
        ReportController.b(paramString, "dc00898", "", "", "0X8009D65", "0X8009D65", i, 0, localStringBuilder.toString(), "", "", "");
      }
      ReportController.b(this.g, "CliOper", "", "", "0X800644A", "0X800644A", 0, 0, "1", "", "", "");
      if (paramAIOSelectableDelegateImpl.l())
      {
        paramAIOSelectableDelegateImpl = paramAIOSelectableDelegateImpl.d();
        paramString = paramAIOSelectableDelegateImpl;
        if ((paramChatMessage instanceof MessageForText))
        {
          paramString = paramAIOSelectableDelegateImpl;
          if (MessageFoldable.a(paramChatMessage)) {
            return ((MessageForText)paramChatMessage).sb.toString();
          }
        }
      }
      else
      {
        paramString = paramChatMessage.msg;
      }
      return paramString;
    }
    return null;
  }
  
  protected void a(ChatMessage paramChatMessage, CharSequence paramCharSequence, GuildTextItemBuild.Holder paramHolder, Context paramContext)
  {
    GuildBuilderUtils.a(paramChatMessage, paramCharSequence, paramHolder.i, paramContext, m(), l());
    if (AppSetting.e)
    {
      paramChatMessage = com.tencent.mobileqq.text.TextUtils.emoticonToTextForTalkBack(paramChatMessage.msg);
      paramCharSequence = Spannable.Factory.getInstance().newSpannable(paramChatMessage);
      if (Linkify.addLinks(paramCharSequence, 15))
      {
        paramHolder.i.setContentDescription(paramCharSequence);
        return;
      }
      paramHolder.i.setContentDescription(paramChatMessage);
    }
  }
  
  public void b()
  {
    super.b();
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
    paramView = AIOUtils.a(paramView);
    String str1 = this.b.getString(2131886574);
    String str2 = this.b.getString(2131886575);
    if (paramView.isSendFromLocal()) {
      DialogUtil.a(this.b, 230, str1, str2, new GuildTextItemBuild.1(this, paramView), new GuildTextItemBuild.2(this)).show();
    }
    return true;
  }
  
  protected String b_(ChatMessage paramChatMessage)
  {
    if ((paramChatMessage instanceof MessageForText))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131912174));
      localStringBuilder.append(com.tencent.mobileqq.text.TextUtils.emoticonToTextForTalkBack(paramChatMessage.msg));
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(HardCodeUtil.a(2131912172));
    localStringBuilder.append(paramChatMessage.msg);
    return localStringBuilder.toString();
  }
  
  protected int j()
  {
    if (d()) {
      return 2131166220;
    }
    return 2131166191;
  }
  
  protected int k()
  {
    d();
    return 2131168008;
  }
  
  protected int l()
  {
    if (d()) {
      return 2131166212;
    }
    return GuildBuilderUtils.a();
  }
  
  protected int m()
  {
    if (d()) {
      return 2131166211;
    }
    return GuildBuilderUtils.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder.GuildTextItemBuild
 * JD-Core Version:    0.7.0.1
 */