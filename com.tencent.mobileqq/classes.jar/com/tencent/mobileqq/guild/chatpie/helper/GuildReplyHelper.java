package com.tencent.mobileqq.guild.chatpie.helper;

import android.content.res.Resources;
import android.graphics.Color;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.etrump.mixlayout.VasShieldFont;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.helper.ReplyHelper;
import com.tencent.mobileqq.activity.aio.reply.ReplyMsgUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.guild.chatpie.GuildChatContext;
import com.tencent.mobileqq.guild.chatpie.Util.GuildNameUtil;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.replymsg.ForwardMsgManager;
import com.tencent.mobileqq.troop.text.GuildAtTroopMemberSpan;
import com.tencent.mobileqq.troop.text.ReplyedMessageSpan;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.ColorNickManager;
import com.tencent.widget.XEditText;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class GuildReplyHelper
  extends ReplyHelper
{
  protected TextView b;
  protected TextView c;
  protected ImageView d;
  public String e;
  private final QQAppInterface f;
  private final SessionInfo g;
  private final GuildChatContext h;
  private XEditText i;
  private ViewStub j;
  private final View.OnClickListener k = new GuildReplyHelper.4(this);
  
  public GuildReplyHelper(GuildChatContext paramGuildChatContext)
  {
    super(paramGuildChatContext);
    this.h = paramGuildChatContext;
    this.f = paramGuildChatContext.a();
    this.g = ((SessionInfo)paramGuildChatContext.O());
  }
  
  private void b(MessageRecord paramMessageRecord)
  {
    Object localObject = paramMessageRecord.getExtInfoFromExtStr("GUILD_ID");
    paramMessageRecord = paramMessageRecord.senderuin;
    paramMessageRecord = GuildNameUtil.a(this.f, (String)localObject, paramMessageRecord);
    localObject = this.f;
    BaseActivity localBaseActivity = this.h.b();
    String str = this.h.O().b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a.mSourceMsgSenderUin);
    localStringBuilder.append("");
    paramMessageRecord = GuildAtTroopMemberSpan.a((AppRuntime)localObject, localBaseActivity, str, localStringBuilder.toString(), paramMessageRecord, paramMessageRecord, this.h.Q(), this.h.X());
    if (TextUtils.isEmpty(paramMessageRecord)) {
      return;
    }
    this.i.getEditableText().insert(0, paramMessageRecord);
  }
  
  private void e()
  {
    ViewStub localViewStub = this.j;
    if (localViewStub != null) {
      localViewStub.setVisibility(8);
    }
  }
  
  public MessageRecord a(MessageRecord paramMessageRecord)
  {
    Object localObject = paramMessageRecord;
    if (this.a != null)
    {
      localObject = paramMessageRecord;
      if (!TextUtils.isEmpty(this.a.mSourceMsgTroopName)) {
        localObject = ((ForwardMsgManager)this.h.a().getManager(QQManagerFactory.FORWARD_MSG_MANAGER)).b(this.a.getUniSeq());
      }
    }
    paramMessageRecord = (MessageRecord)localObject;
    if (localObject == null)
    {
      paramMessageRecord = (MessageRecord)localObject;
      if (this.a != null) {
        paramMessageRecord = ReplyMsgUtils.c(this.h.a(), this.h.O(), this.a);
      }
    }
    return paramMessageRecord;
  }
  
  public void a(ChatMessage paramChatMessage, int paramInt, long paramLong, String paramString)
  {
    if (paramChatMessage != null)
    {
      if (paramChatMessage.senderuin == null) {
        return;
      }
      paramString = ReplyMsgUtils.a(this.f, paramChatMessage, paramInt, paramLong, paramString);
      if (paramString == null) {
        return;
      }
      a(paramString);
      a(paramChatMessage.senderuin);
      paramString = ((IGPSService)this.f.getRuntimeService(IGPSService.class, "")).getSelfTinyId();
      if (this.a != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.a.mSourceMsgSenderUin);
        localStringBuilder.append("");
        if (!TextUtils.equals(paramString, localStringBuilder.toString())) {
          b(paramChatMessage);
        }
      }
    }
  }
  
  public void a(MessageForReplyText.SourceMsgInfo paramSourceMsgInfo)
  {
    super.a(paramSourceMsgInfo);
    if (paramSourceMsgInfo != null)
    {
      this.e = ReplyedMessageSpan.a(this.a.mSourceMsgSenderUin, this.a.mAtInfoStr);
      return;
    }
    e();
  }
  
  public void a(String paramString)
  {
    if (this.a == null) {
      return;
    }
    if (this.j == null) {
      d();
    }
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    localSpannableStringBuilder.append(ColorNickManager.a(this.a.mSourceMsgText, this.e, ChatTextSizeSettingActivity.a(), null, 7));
    Object localObject = this.f;
    String str = this.h.S();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a.mSourceMsgSenderUin);
    localStringBuilder.append("");
    str = GuildNameUtil.a((AppRuntime)localObject, str, localStringBuilder.toString());
    localObject = str;
    if (!TextUtils.isEmpty(str))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(" :");
      localObject = ((StringBuilder)localObject).toString();
    }
    this.c.setText((CharSequence)localObject);
    this.c.setGravity(16);
    this.c.setTypeface(VasShieldFont.a(paramString));
    this.c.setTextColor(Color.parseColor("#8D9AAD"));
    this.b.setText(localSpannableStringBuilder);
    this.b.setGravity(16);
    this.b.setTextColor(Color.parseColor("#8D9AAD"));
    this.b.setTypeface(VasShieldFont.a(paramString));
    this.j.setVisibility(0);
    this.h.g().postDelayed(new GuildReplyHelper.1(this), 200L);
    this.i.setOnKeyListener(new GuildReplyHelper.2(this));
  }
  
  protected void d()
  {
    this.j = ((ViewStub)this.h.d(2131427971));
    Object localObject = this.j;
    if (localObject == null) {
      return;
    }
    ((ViewStub)localObject).setLayoutResource(2131624111);
    localObject = this.j.inflate();
    this.c = ((TextView)((View)localObject).findViewById(2131439303));
    this.b = ((TextView)((View)localObject).findViewById(2131444648));
    this.b.setOnClickListener(this.k);
    this.d = ((ImageView)((View)localObject).findViewById(2131444641));
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((View)localObject).getLayoutParams();
    if (localLayoutParams != null)
    {
      localLayoutParams.bottomMargin = ViewUtils.dpToPx(10.0F);
      ((View)localObject).setLayoutParams(localLayoutParams);
    }
    this.d.setOnClickListener(new GuildReplyHelper.3(this));
    if (AppSetting.e)
    {
      localObject = this.d;
      ((ImageView)localObject).setContentDescription(((ImageView)localObject).getResources().getString(2131890225));
    }
  }
  
  @NonNull
  public String getTag()
  {
    return "GuildReplyHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 0 };
  }
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt != 0) {
      return;
    }
    this.i = ((XEditText)this.h.d(2131435808));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.helper.GuildReplyHelper
 * JD-Core Version:    0.7.0.1
 */