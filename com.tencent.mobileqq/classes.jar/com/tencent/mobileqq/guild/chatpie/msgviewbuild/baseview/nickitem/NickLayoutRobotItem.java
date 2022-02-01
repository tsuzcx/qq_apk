package com.tencent.mobileqq.guild.chatpie.msgviewbuild.baseview.nickitem;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.utils.ViewUtils;
import mqq.app.AppRuntime;

public class NickLayoutRobotItem
  extends AbsGuildNickLayoutItem
{
  protected TextView c;
  
  public NickLayoutRobotItem(Context paramContext, AppRuntime paramAppRuntime)
  {
    super(paramContext, paramAppRuntime);
  }
  
  @RequiresApi(api=16)
  public View a()
  {
    this.c = ((TextView)LayoutInflater.from(this.a).inflate(2131624982, null));
    return this.c;
  }
  
  public void a(AbsGuildNickLayoutItem.Data paramData)
  {
    paramData = paramData.b.getExtInfoFromExtStr("GUILD_MSG_FROME_APPID");
    TextView localTextView = this.c;
    int i;
    if (TextUtils.equals("3161", paramData)) {
      i = 0;
    } else {
      i = 8;
    }
    localTextView.setVisibility(i);
  }
  
  public ViewGroup.LayoutParams b()
  {
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, ViewUtils.dpToPx(16.0F));
    localLayoutParams.leftMargin = ViewUtils.dpToPx(4.0F);
    localLayoutParams.gravity = 16;
    return localLayoutParams;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.msgviewbuild.baseview.nickitem.NickLayoutRobotItem
 * JD-Core Version:    0.7.0.1
 */