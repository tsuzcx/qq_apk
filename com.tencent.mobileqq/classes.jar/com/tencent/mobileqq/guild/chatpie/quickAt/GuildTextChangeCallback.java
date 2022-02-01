package com.tencent.mobileqq.guild.chatpie.quickAt;

import android.text.Editable;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.coreui.input.IEditTextChangeCallback;
import com.tencent.mobileqq.guild.chatpie.helper.GuildAtHelper;
import com.tencent.mobileqq.guild.chatpie.helper.GuildInputBarHelper;

public class GuildTextChangeCallback
  implements IEditTextChangeCallback
{
  public void a(AIOContext paramAIOContext, CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramAIOContext.O().a == 10014) {
      ((GuildAtHelper)paramAIOContext.a(144)).a(paramCharSequence, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public boolean a(AIOContext paramAIOContext, Editable paramEditable)
  {
    ((GuildInputBarHelper)paramAIOContext.a(145)).a(paramAIOContext, paramEditable);
    return false;
  }
  
  public void b(AIOContext paramAIOContext, CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    BaseSessionInfo localBaseSessionInfo = paramAIOContext.O();
    if ((localBaseSessionInfo.a == 10014) && (localBaseSessionInfo.b != null) && (localBaseSessionInfo.b.length() != 0)) {
      ((GuildAtHelper)paramAIOContext.a(144)).b(paramCharSequence, paramInt1, paramInt2, paramInt3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.quickAt.GuildTextChangeCallback
 * JD-Core Version:    0.7.0.1
 */