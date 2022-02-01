package com.tencent.mobileqq.guild.chatpie.helper;

import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.guild.chatpie.GuildChatContext;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.qphone.base.util.QLog;

public class GuildLiveChannelInputBarHelper
  extends GuildInputBarHelper
{
  private int i;
  private int j;
  private String k;
  
  public GuildLiveChannelInputBarHelper(GuildChatContext paramGuildChatContext)
  {
    super(paramGuildChatContext);
  }
  
  protected int A()
  {
    return 2131166214;
  }
  
  protected int C()
  {
    return 2130840901;
  }
  
  protected void D() {}
  
  public int E()
  {
    return this.i;
  }
  
  protected int a(Resources paramResources)
  {
    return paramResources.getColor(2131166234);
  }
  
  protected String a(IGProChannelInfo paramIGProChannelInfo)
  {
    String str;
    if (TextUtils.isEmpty(this.k)) {
      str = paramIGProChannelInfo.getLiveRoomName();
    } else {
      str = this.k;
    }
    if (TextUtils.isEmpty(str)) {
      return super.a(paramIGProChannelInfo);
    }
    return str;
  }
  
  public void a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateInputHintTheme themeName = ");
    localStringBuilder.append(paramString);
    QLog.d("GuildLiveChannelInputBa", 4, localStringBuilder.toString());
    this.k = paramString;
    x();
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    this.i = paramInt1;
    this.j = paramInt2;
  }
  
  protected int d()
  {
    return 2131890419;
  }
  
  public String getTag()
  {
    return "GuildLiveChannelInputBa";
  }
  
  protected int h()
  {
    return 0;
  }
  
  protected int i()
  {
    return 2131166213;
  }
  
  protected int l()
  {
    return E();
  }
  
  protected int m()
  {
    return E();
  }
  
  protected int o()
  {
    return this.j;
  }
  
  protected boolean p()
  {
    return true;
  }
  
  protected int q()
  {
    return 2130840902;
  }
  
  protected int r()
  {
    return 2130840902;
  }
  
  protected int u()
  {
    return this.b.getColor(2131166219);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.helper.GuildLiveChannelInputBarHelper
 * JD-Core Version:    0.7.0.1
 */