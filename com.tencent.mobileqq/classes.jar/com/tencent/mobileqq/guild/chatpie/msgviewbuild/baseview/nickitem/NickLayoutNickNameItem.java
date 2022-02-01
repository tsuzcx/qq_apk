package com.tencent.mobileqq.guild.chatpie.msgviewbuild.baseview.nickitem;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint.Style;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.guild.chatpie.Util.GuildNameUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class NickLayoutNickNameItem
  extends AbsGuildNickLayoutItem
{
  TextView c;
  
  public NickLayoutNickNameItem(Context paramContext, AppRuntime paramAppRuntime)
  {
    super(paramContext, paramAppRuntime);
  }
  
  private String a(ChatMessage paramChatMessage, String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramChatMessage == null) {
        return paramString;
      }
      paramChatMessage = paramChatMessage.getExtInfoFromExtStr("GUILD_MSG_GAME_NICK");
      if (!TextUtils.isEmpty(paramChatMessage))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append("(");
        localStringBuilder.append(paramChatMessage);
        localStringBuilder.append(")");
        return localStringBuilder.toString();
      }
    }
    return paramString;
  }
  
  public View a()
  {
    this.c = new TextView(this.a);
    this.c.setId(2131430595);
    this.c.setTextSize(13.0F);
    this.c.setEllipsize(TextUtils.TruncateAt.END);
    this.c.setIncludeFontPadding(false);
    this.c.getPaint().setStyle(Paint.Style.FILL_AND_STROKE);
    this.c.getPaint().setStrokeWidth(1.0F);
    this.c.setSingleLine();
    this.c.setTextColor(this.a.getResources().getColorStateList(c()));
    return this.c;
  }
  
  public void a(AbsGuildNickLayoutItem.Data paramData)
  {
    if (paramData != null)
    {
      if (paramData.b == null) {
        return;
      }
      String str = paramData.b.getExtInfoFromExtStr("GUILD_ID");
      Object localObject = paramData.b.senderuin;
      str = GuildNameUtil.a(this.b, str, (String)localObject);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("nickName:");
        ((StringBuilder)localObject).append(str);
        QLog.i("NickLayoutNickNameItem", 2, ((StringBuilder)localObject).toString());
      }
      paramData = a(paramData.b, str);
      this.c.setText(paramData);
    }
  }
  
  public ViewGroup.LayoutParams b()
  {
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.weight = 1.0F;
    return localLayoutParams;
  }
  
  protected int c()
  {
    return 2131166189;
  }
  
  public String d()
  {
    TextView localTextView = this.c;
    if (localTextView != null) {
      return (String)localTextView.getText();
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.msgviewbuild.baseview.nickitem.NickLayoutNickNameItem
 * JD-Core Version:    0.7.0.1
 */