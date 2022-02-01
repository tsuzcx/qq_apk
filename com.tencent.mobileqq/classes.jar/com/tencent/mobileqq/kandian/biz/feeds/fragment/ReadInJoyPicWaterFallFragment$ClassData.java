package com.tencent.mobileqq.kandian.biz.feeds.fragment;

import com.tencent.mobileqq.kandian.biz.channel.ChannelClassificationListView.IClassData;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ChannelCoverInfo;

public class ReadInJoyPicWaterFallFragment$ClassData
  implements ChannelClassificationListView.IClassData
{
  public String a;
  public String b;
  public ChannelCoverInfo c;
  private boolean d = false;
  
  public ReadInJoyPicWaterFallFragment$ClassData(ChannelCoverInfo paramChannelCoverInfo, String paramString1, String paramString2)
  {
    this.c = paramChannelCoverInfo;
    this.a = paramString1;
    this.b = paramString2;
  }
  
  public String a()
  {
    return this.a;
  }
  
  public void a(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public boolean c()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.fragment.ReadInJoyPicWaterFallFragment.ClassData
 * JD-Core Version:    0.7.0.1
 */