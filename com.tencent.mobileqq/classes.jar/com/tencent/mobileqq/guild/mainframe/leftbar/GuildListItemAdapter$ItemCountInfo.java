package com.tencent.mobileqq.guild.mainframe.leftbar;

import com.tencent.mobileqq.guild.mainframe.leftbar.itembuilder.GuildListItemBaseBuilder;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class GuildListItemAdapter$ItemCountInfo
{
  private final int[] a = new int[5];
  private int b = 0;
  
  private GuildListItemAdapter$ItemCountInfo(List<GuildListItemBaseBuilder> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (GuildListItemBaseBuilder)paramList.next();
      int i = ((GuildListItemBaseBuilder)localObject).d();
      if ((i >= 0) && (i < 5))
      {
        localObject = this.a;
        localObject[i] += 1;
        this.b += 1;
      }
      else
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Unexpected item: ");
        localStringBuilder.append(localObject);
        QLog.e("GuildListItemAdapter", 1, localStringBuilder.toString());
      }
    }
  }
  
  public static ItemCountInfo a(List<GuildListItemBaseBuilder> paramList)
  {
    return new ItemCountInfo(paramList);
  }
  
  public int a()
  {
    return this.b;
  }
  
  public int a(int paramInt)
  {
    return this.a[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.leftbar.GuildListItemAdapter.ItemCountInfo
 * JD-Core Version:    0.7.0.1
 */