package com.tencent.mobileqq.kandian.repo.feeds.entity;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0xbc9.oidb_cmd0xbc9.BannerItem;
import tencent.im.oidb.cmd0xbc9.oidb_cmd0xbc9.BannerRoundRspBody;
import tencent.im.oidb.cmd0xbc9.oidb_cmd0xbc9.DynamicBannerItem;
import tencent.im.oidb.cmd0xbc9.oidb_cmd0xbc9.MoreChannelItem;

public class TopBannerInfo
  extends Entity
{
  private static final String TAG = "TopBannerInfo";
  @notColumn
  public final List<TopBannerInfo.DynamicItem> dynamicItems = new ArrayList();
  @notColumn
  public final List<TopBannerInfo.BaseItem> items = new ArrayList();
  public byte[] itemsByte;
  public int mChannelId = -1;
  public String mCookie;
  @notColumn
  public TopBannerInfo.MoreChannelItem moreChannelItem;
  
  public void addDynamicItem(TopBannerInfo.DynamicItem paramDynamicItem)
  {
    this.dynamicItems.add(paramDynamicItem);
  }
  
  public void addItem(TopBannerInfo.BaseItem paramBaseItem)
  {
    this.items.add(paramBaseItem);
  }
  
  public boolean isBothEmpty()
  {
    return (this.items.isEmpty()) && (this.dynamicItems.isEmpty());
  }
  
  public boolean isDynamicItemsEmpty()
  {
    return this.dynamicItems.isEmpty();
  }
  
  public boolean isEmpty()
  {
    return (this.items.isEmpty()) && (this.dynamicItems.isEmpty());
  }
  
  protected void postRead()
  {
    Object localObject1 = this.itemsByte;
    if ((localObject1 != null) && (localObject1.length > 0))
    {
      localObject1 = new oidb_cmd0xbc9.BannerRoundRspBody();
      try
      {
        ((oidb_cmd0xbc9.BannerRoundRspBody)localObject1).mergeFrom(this.itemsByte);
        Iterator localIterator;
        Object localObject2;
        if (((oidb_cmd0xbc9.BannerRoundRspBody)localObject1).rpt_msg_banner_list.has())
        {
          localIterator = ((oidb_cmd0xbc9.BannerRoundRspBody)localObject1).rpt_msg_banner_list.get().iterator();
          while (localIterator.hasNext())
          {
            localObject2 = TopBannerInfo.BaseItem.a((oidb_cmd0xbc9.BannerItem)localIterator.next());
            if (localObject2 != null) {
              this.items.add(localObject2);
            }
          }
        }
        if ((((oidb_cmd0xbc9.BannerRoundRspBody)localObject1).rpt_msg_dynamic_banner_list.has()) && (((oidb_cmd0xbc9.BannerRoundRspBody)localObject1).rpt_msg_dynamic_banner_list.size() > 0))
        {
          localIterator = ((oidb_cmd0xbc9.BannerRoundRspBody)localObject1).rpt_msg_dynamic_banner_list.get().iterator();
          while (localIterator.hasNext())
          {
            localObject2 = TopBannerInfo.DynamicItem.a((oidb_cmd0xbc9.DynamicBannerItem)localIterator.next());
            if (localObject2 != null) {
              this.dynamicItems.addAll((Collection)localObject2);
            }
          }
        }
        if (((oidb_cmd0xbc9.BannerRoundRspBody)localObject1).msg_more_channel_item.has())
        {
          localObject1 = TopBannerInfo.MoreChannelItem.a((oidb_cmd0xbc9.MoreChannelItem)((oidb_cmd0xbc9.BannerRoundRspBody)localObject1).msg_more_channel_item.get());
          if (localObject1 != null)
          {
            this.moreChannelItem = ((TopBannerInfo.MoreChannelItem)localObject1);
            return;
          }
        }
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        this.items.clear();
        QLog.d("TopBannerInfo", 1, "", localInvalidProtocolBufferMicroException);
      }
    }
  }
  
  protected void prewrite()
  {
    if (!isBothEmpty())
    {
      oidb_cmd0xbc9.BannerRoundRspBody localBannerRoundRspBody = new oidb_cmd0xbc9.BannerRoundRspBody();
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.items.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(((TopBannerInfo.BaseItem)localIterator.next()).a());
      }
      localBannerRoundRspBody.rpt_msg_banner_list.addAll(localArrayList);
      localArrayList = new ArrayList();
      localIterator = this.dynamicItems.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(((TopBannerInfo.DynamicItem)localIterator.next()).a());
      }
      if (this.moreChannelItem != null) {
        localBannerRoundRspBody.msg_more_channel_item.set(this.moreChannelItem.a());
      }
      localBannerRoundRspBody.rpt_msg_dynamic_banner_list.addAll(localArrayList);
      this.itemsByte = localBannerRoundRspBody.toByteArray();
    }
  }
  
  public void setMoreChannelItem(TopBannerInfo.MoreChannelItem paramMoreChannelItem)
  {
    this.moreChannelItem = paramMoreChannelItem;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mCookie : ");
    localStringBuilder.append(this.mCookie);
    localStringBuilder.append("  mChannelId: ");
    localStringBuilder.append(this.mChannelId);
    localStringBuilder.append(" items size: ");
    localStringBuilder.append(this.items.size());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.entity.TopBannerInfo
 * JD-Core Version:    0.7.0.1
 */