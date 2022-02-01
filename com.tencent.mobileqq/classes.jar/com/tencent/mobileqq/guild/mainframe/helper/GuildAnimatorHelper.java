package com.tencent.mobileqq.guild.mainframe.helper;

import com.tencent.mobileqq.guild.mainframe.GuildMainViewContext;
import com.tencent.mobileqq.guild.mainframe.GuildMainViewLifeCycle;
import java.util.ArrayList;
import java.util.Iterator;

public class GuildAnimatorHelper
  extends GuildMainViewLifeCycle
{
  private ArrayList<GuildAnimatorHelper.AnimatorInfo> b = new ArrayList();
  private GuildAnimatorHelper.AnimatorInfo c;
  
  public GuildAnimatorHelper(GuildMainViewContext paramGuildMainViewContext)
  {
    super(paramGuildMainViewContext);
  }
  
  public GuildAnimatorHelper.AnimatorInfo a(int paramInt, String paramString)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      GuildAnimatorHelper.AnimatorInfo localAnimatorInfo = (GuildAnimatorHelper.AnimatorInfo)localIterator.next();
      if (localAnimatorInfo.equals(new GuildAnimatorHelper.AnimatorInfo(paramInt, paramString))) {
        return localAnimatorInfo;
      }
    }
    return null;
  }
  
  public boolean b(int paramInt, String paramString)
  {
    return this.b.remove(new GuildAnimatorHelper.AnimatorInfo(paramInt, paramString));
  }
  
  public void g()
  {
    i();
    j();
  }
  
  public void i()
  {
    this.b.clear();
  }
  
  public void j()
  {
    this.c = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.helper.GuildAnimatorHelper
 * JD-Core Version:    0.7.0.1
 */