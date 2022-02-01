package com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder;

import android.content.Context;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout.OnChatMessageCheckedChangeListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.widget.QQToast;

final class BaseGuildMsgViewBuild$1
  implements CompoundButton.OnCheckedChangeListener
{
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    Object localObject = (ChatMessage)paramCompoundButton.getTag();
    if (localObject == null) {
      return;
    }
    if (paramBoolean == MultiMsgManager.a().a((ChatMessage)localObject)) {
      return;
    }
    if (!paramBoolean)
    {
      MultiMsgManager.a().a((ChatMessage)localObject, paramBoolean);
    }
    else
    {
      int i = MultiMsgManager.a().c();
      if (MultiMsgManager.a().a((ChatMessage)localObject, i))
      {
        if (MultiMsgManager.a().e == 7) {
          localObject = paramCompoundButton.getContext().getString(2131896475, new Object[] { Integer.valueOf(i) });
        } else {
          localObject = paramCompoundButton.getContext().getString(2131896474, new Object[] { Integer.valueOf(i) });
        }
        QQToast.makeText(paramCompoundButton.getContext(), (CharSequence)localObject, 0).show(((BaseActivity)paramCompoundButton.getContext()).getTitleBarHeight());
        paramCompoundButton.setChecked(false);
        return;
      }
      MultiMsgManager.a().a((ChatMessage)localObject, paramBoolean);
    }
    if (BaseChatItemLayout.an != null) {
      BaseChatItemLayout.an.a((ChatMessage)localObject, paramCompoundButton, paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder.BaseGuildMsgViewBuild.1
 * JD-Core Version:    0.7.0.1
 */