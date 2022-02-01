package com.tencent.mobileqq.guild.chatpie.msgviewbuild.baseview.nickitem;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.guild.chatpie.Util.GuildTimeFormatterUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import mqq.app.AppRuntime;

public class NickLayoutTimeStampItem
  extends AbsGuildNickLayoutItem
{
  private TextView c;
  
  public NickLayoutTimeStampItem(Context paramContext, AppRuntime paramAppRuntime)
  {
    super(paramContext, paramAppRuntime);
  }
  
  public View a()
  {
    if (this.c == null)
    {
      this.c = new TextView(this.a);
      this.c.setId(2131430610);
      this.c.setTextSize(12.0F);
      this.c.setSingleLine();
      this.c.setTextColor(c());
    }
    return this.c;
  }
  
  public void a(AbsGuildNickLayoutItem.Data paramData)
  {
    paramData = GuildTimeFormatterUtils.a(this.a, paramData.b.time * 1000L);
    this.c.setText(paramData);
  }
  
  public ViewGroup.LayoutParams b()
  {
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.leftMargin = ViewUtils.dpToPx(8.0F);
    return localLayoutParams;
  }
  
  protected int c()
  {
    return Color.parseColor("#999999");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.msgviewbuild.baseview.nickitem.NickLayoutTimeStampItem
 * JD-Core Version:    0.7.0.1
 */