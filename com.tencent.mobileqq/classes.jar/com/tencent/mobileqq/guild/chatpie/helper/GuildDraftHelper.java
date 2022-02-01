package com.tencent.mobileqq.guild.chatpie.helper;

import android.text.Editable;
import android.text.Spanned;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.input.AIOInput;
import com.tencent.mobileqq.activity.aio.coreui.input.EditTextUI;
import com.tencent.mobileqq.activity.aio.coreui.input.InputUIContainer;
import com.tencent.mobileqq.activity.aio.helper.AIODraftHelper;
import com.tencent.mobileqq.activity.aio.helper.FullScreenInputHelper;
import com.tencent.mobileqq.activity.aio.rebuild.GameRoomChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.SaveTextDraftJob;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.DraftTextInfo;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.flashchat.RichTextChatManager;
import com.tencent.mobileqq.guild.chatpie.GuildChatContext;
import com.tencent.mobileqq.guild.chatpie.GuildLiveChannelChatPie;
import com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.text.AtTroopMemberSpan;
import com.tencent.mobileqq.vas.ColorNickManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class GuildDraftHelper
  extends AIODraftHelper
{
  public GuildDraftHelper(BaseChatPie paramBaseChatPie)
  {
    super(paramBaseChatPie);
  }
  
  protected void a()
  {
    if (((GuildChatContext)this.c.bv()).af())
    {
      Fragment localFragment = this.b.b().getSupportFragmentManager().findFragmentByTag(MainFragment.class.getName());
      if (((localFragment instanceof MainFragment)) && (((IGuildMainFrameApi)QRoute.api(IGuildMainFrameApi.class)).getAttachContainerProgress((MainFragment)localFragment) == 1000))
      {
        if (QLog.isColorLevel()) {
          QLog.i("GuildDraftHelper", 2, "checkShowInputPanel false");
        }
        return;
      }
    }
    super.a();
  }
  
  protected void a(BaseSessionInfo paramBaseSessionInfo, Spanned paramSpanned, QQAppInterface paramQQAppInterface, String paramString1, MessageForReplyText.SourceMsgInfo paramSourceMsgInfo, String paramString2)
  {
    Object localObject1 = this.b.p().d().f();
    if (localObject1 == null) {
      return;
    }
    paramSpanned = new ArrayList();
    Object localObject2 = AtTroopMemberSpan.b(((EditTextUI)localObject1).c(), paramSpanned);
    if (paramSpanned.size() > 0) {
      paramSpanned = AtTroopMemberSpan.a(paramSpanned);
    } else {
      paramSpanned = paramString2;
    }
    FullScreenInputHelper localFullScreenInputHelper = (FullScreenInputHelper)this.b.a(24);
    paramString2 = localFullScreenInputHelper.a((Spanned)localObject2);
    localObject2 = localFullScreenInputHelper.b((CharSequence)localObject2);
    localObject1 = ((EditTextUI)localObject1).c(2131441550);
    ThreadManager.post(new SaveTextDraftJob(this.c, new SessionInfo(paramBaseSessionInfo), paramString2, (CharSequence)localObject2, paramQQAppInterface, paramString1, paramSourceMsgInfo, localObject1, paramSpanned), 8, null, false);
  }
  
  public void a(DraftTextInfo paramDraftTextInfo)
  {
    XEditTextEx localXEditTextEx = this.c.Y;
    String str2 = "";
    String str1;
    if (paramDraftTextInfo != null) {
      str1 = paramDraftTextInfo.text;
    } else {
      str1 = "";
    }
    this.e = str1;
    GuildReplyHelper localGuildReplyHelper = (GuildReplyHelper)this.b.a(119);
    if ((paramDraftTextInfo != null) && (paramDraftTextInfo.sourceMsgSeq != 0L))
    {
      localGuildReplyHelper.a(paramDraftTextInfo);
      localGuildReplyHelper.a(this.a.getCurrentUin());
    }
    boolean bool;
    if (this.e != null) {
      bool = true;
    } else {
      bool = false;
    }
    this.f = bool;
    if ((paramDraftTextInfo != null) && (paramDraftTextInfo.mixedMsgInfoHtml != null))
    {
      ((FullScreenInputHelper)this.b.a(24)).a(paramDraftTextInfo.mixedMsgInfoHtml);
    }
    else
    {
      Editable localEditable = localXEditTextEx.getEditableText();
      int i = localXEditTextEx.getText().length();
      if (this.e == null) {
        str1 = str2;
      } else {
        str1 = this.e;
      }
      localEditable.insert(i, str1);
    }
    ColorNickManager.a(paramDraftTextInfo, localXEditTextEx, this.e, this.a, this.c.aX(), this.b.O().b, this.c instanceof GuildLiveChannelChatPie);
    paramDraftTextInfo = localGuildReplyHelper.a();
    if ((!TextUtils.isEmpty(this.e)) && (paramDraftTextInfo == null) && (!(this.c instanceof GameRoomChatPie)) && (RichTextChatManager.a(this.a).c(this.a))) {
      this.c.j().postDelayed(new GuildDraftHelper.1(this), 100L);
    }
    localXEditTextEx.setSelection(localXEditTextEx.getText().toString().length());
    this.d = false;
  }
  
  @NonNull
  public String getTag()
  {
    return "GuildDraftHelper";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.helper.GuildDraftHelper
 * JD-Core Version:    0.7.0.1
 */