package com.tencent.mobileqq.guild.mainframe.helper;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.guild.mainframe.GuildMainViewContext;
import com.tencent.mobileqq.guild.mainframe.GuildMainViewLifeCycle;
import java.util.HashMap;

public class ChannelSelectHelper
  extends GuildMainViewLifeCycle
{
  private final String b = "GuildLeftBarSelHelper";
  private HashMap<String, String> c = new HashMap();
  private HashMap<String, String> d = new HashMap();
  
  public ChannelSelectHelper(GuildMainViewContext paramGuildMainViewContext)
  {
    super(paramGuildMainViewContext);
  }
  
  @Nullable
  public String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return (String)this.c.get(paramString);
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return false;
    }
    this.c.put(paramString1, paramString2);
    this.d.clear();
    return true;
  }
  
  @Nullable
  public String b(String paramString)
  {
    if (this.d.containsKey(paramString)) {
      return (String)this.d.remove(paramString);
    }
    return null;
  }
  
  public boolean b(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      this.d.put(paramString1, paramString2);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.helper.ChannelSelectHelper
 * JD-Core Version:    0.7.0.1
 */