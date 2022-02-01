package com.tencent.mobileqq.olympic;

import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.olympic.torch_transfer.BusinessEntryInfo;
import tencent.im.oidb.olympic.torch_transfer.CityBackPicInfo;
import tencent.im.oidb.olympic.torch_transfer.LightCityInfo;
import tencent.im.oidb.olympic.torch_transfer.TorchLimitInfo;
import tencent.im.oidb.olympic.torch_transfer.TorchPicInfo;
import tencent.im.oidb.olympic.torch_transfer.TorchbearerInfo;
import tencent.im.oidb.olympic.torch_transfer.TorcherRankInfo;

public class TorchInfo
  implements Serializable, Cloneable
{
  public int business_entry_new = 0;
  public int business_entry_seq = 0;
  public ArrayList<TorchInfo.CityInfo> city_list = new ArrayList();
  public long cur_city_id;
  public int delay_time = -1;
  public long id;
  public boolean isOnlyTorcher = false;
  public long ranking;
  public long reach_next_city_num;
  public String torch_pic_md5;
  public String torch_pic_url;
  public int torch_type;
  public long transferLimitTs = 0L;
  public boolean transferOverLimit = false;
  public long transfer_num;
  public long uin;
  
  public TorchInfo() {}
  
  public TorchInfo(torch_transfer.TorchbearerInfo paramTorchbearerInfo)
  {
    if (paramTorchbearerInfo == null) {}
    do
    {
      do
      {
        return;
        if (paramTorchbearerInfo.uint64_uin.has()) {
          this.uin = paramTorchbearerInfo.uint64_uin.get();
        }
        if (paramTorchbearerInfo.uint64_bearer_id.has()) {
          this.id = paramTorchbearerInfo.uint64_bearer_id.get();
        }
        if (paramTorchbearerInfo.uint32_transfer_num.has()) {
          this.transfer_num = paramTorchbearerInfo.uint32_transfer_num.get();
        }
        Object localObject;
        if (paramTorchbearerInfo.msg_light_city_info.has())
        {
          localObject = (torch_transfer.LightCityInfo)paramTorchbearerInfo.msg_light_city_info.get();
          if (((torch_transfer.LightCityInfo)localObject).uint32_cur_city_id.has()) {
            this.cur_city_id = ((torch_transfer.LightCityInfo)localObject).uint32_cur_city_id.get();
          }
          if (((torch_transfer.LightCityInfo)localObject).uint32_next_city_num.has()) {
            this.reach_next_city_num = ((torch_transfer.LightCityInfo)localObject).uint32_next_city_num.get();
          }
        }
        if (paramTorchbearerInfo.msg_pic_info.has())
        {
          localObject = (torch_transfer.TorchPicInfo)paramTorchbearerInfo.msg_pic_info.get();
          if (((torch_transfer.TorchPicInfo)localObject).uint32_business_type.has()) {
            this.torch_type = ((torch_transfer.TorchPicInfo)localObject).uint32_business_type.get();
          }
          if (((torch_transfer.TorchPicInfo)localObject).str_torch_pic_url.has()) {
            this.torch_pic_url = ((torch_transfer.TorchPicInfo)localObject).str_torch_pic_url.get();
          }
          if (((torch_transfer.TorchPicInfo)localObject).str_torch_pic_md5.has()) {
            this.torch_pic_md5 = ((torch_transfer.TorchPicInfo)localObject).str_torch_pic_md5.get();
          }
          if (((torch_transfer.TorchPicInfo)localObject).rpt_city_pic_list.has())
          {
            localObject = ((torch_transfer.TorchPicInfo)localObject).rpt_city_pic_list.get();
            if ((localObject != null) && (((List)localObject).size() > 0)) {
              while (i < ((List)localObject).size())
              {
                torch_transfer.CityBackPicInfo localCityBackPicInfo = (torch_transfer.CityBackPicInfo)((List)localObject).get(i);
                if (localCityBackPicInfo != null)
                {
                  TorchInfo.CityInfo localCityInfo = new TorchInfo.CityInfo();
                  localCityInfo.city_id = localCityBackPicInfo.uint32_city_id.get();
                  localCityInfo.city_name = localCityBackPicInfo.str_city_name.get();
                  localCityInfo.city_pic_id = localCityBackPicInfo.uint64_city_pic_id.get();
                  localCityInfo.city_pic_url = localCityBackPicInfo.str_city_pic_url.get();
                  localCityInfo.city_pic_md5 = localCityBackPicInfo.str_city_pic_md5.get();
                  localCityInfo.cons_pic_url = localCityBackPicInfo.str_cons_pic_url.get();
                  localCityInfo.cons_pic_md5 = localCityBackPicInfo.str_cons_pic_md5.get();
                  this.city_list.add(localCityInfo);
                }
                i += 1;
              }
            }
          }
        }
        if (paramTorchbearerInfo.msg_limit_info.has())
        {
          localObject = (torch_transfer.TorchLimitInfo)paramTorchbearerInfo.msg_limit_info.get();
          if ((((torch_transfer.TorchLimitInfo)localObject).uint32_timestamp.has()) && (((torch_transfer.TorchLimitInfo)localObject).bool_limit.has()))
          {
            i = ((torch_transfer.TorchLimitInfo)localObject).uint32_timestamp.get();
            this.transferLimitTs = Long.valueOf(i + "000").longValue();
            this.transferOverLimit = ((torch_transfer.TorchLimitInfo)localObject).bool_limit.get();
          }
        }
        if (paramTorchbearerInfo.msg_business_entry_info.has())
        {
          localObject = (torch_transfer.BusinessEntryInfo)paramTorchbearerInfo.msg_business_entry_info.get();
          if ((((torch_transfer.BusinessEntryInfo)localObject).uint32_business_entry_seq.has()) && (((torch_transfer.BusinessEntryInfo)localObject).uint32_business_entry_new.has()))
          {
            this.business_entry_seq = ((torch_transfer.BusinessEntryInfo)localObject).uint32_business_entry_seq.get();
            this.business_entry_new = ((torch_transfer.BusinessEntryInfo)localObject).uint32_business_entry_new.get();
          }
        }
      } while (!paramTorchbearerInfo.msg_torcher_rank_info.has());
      paramTorchbearerInfo = (torch_transfer.TorcherRankInfo)paramTorchbearerInfo.msg_torcher_rank_info.get();
      if (paramTorchbearerInfo.bool_only_torcher.has()) {
        this.isOnlyTorcher = paramTorchbearerInfo.bool_only_torcher.get();
      }
    } while (!paramTorchbearerInfo.uint32_rankings.has());
    this.ranking = paramTorchbearerInfo.uint32_rankings.get();
  }
  
  public TorchInfo clone()
  {
    TorchInfo localTorchInfo = new TorchInfo();
    localTorchInfo.uin = this.uin;
    localTorchInfo.id = this.id;
    localTorchInfo.transfer_num = this.transfer_num;
    localTorchInfo.cur_city_id = this.cur_city_id;
    localTorchInfo.reach_next_city_num = this.reach_next_city_num;
    localTorchInfo.torch_type = this.torch_type;
    localTorchInfo.torch_pic_url = this.torch_pic_url;
    localTorchInfo.torch_pic_md5 = this.torch_pic_md5;
    localTorchInfo.transferOverLimit = this.transferOverLimit;
    localTorchInfo.transferLimitTs = this.transferLimitTs;
    localTorchInfo.business_entry_new = this.business_entry_new;
    localTorchInfo.business_entry_seq = this.business_entry_seq;
    localTorchInfo.isOnlyTorcher = this.isOnlyTorcher;
    localTorchInfo.ranking = this.ranking;
    localTorchInfo.delay_time = this.delay_time;
    if (this.city_list != null)
    {
      Iterator localIterator = this.city_list.iterator();
      while (localIterator.hasNext())
      {
        TorchInfo.CityInfo localCityInfo = (TorchInfo.CityInfo)((TorchInfo.CityInfo)localIterator.next()).clone();
        localTorchInfo.city_list.add(localCityInfo);
      }
    }
    return localTorchInfo;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append("{");
    localStringBuilder.append("uin=").append(this.uin).append(",");
    localStringBuilder.append("id=").append(this.id).append(",");
    localStringBuilder.append("transfer_num=").append(this.transfer_num).append(",");
    localStringBuilder.append("cur_city_id=").append(this.cur_city_id).append(",");
    localStringBuilder.append("reach_next_city_num=").append(this.reach_next_city_num).append(",");
    localStringBuilder.append("torch_pic_url=").append(this.torch_pic_url).append(",");
    localStringBuilder.append("torch_pic_md5=").append(this.torch_pic_md5).append(",");
    localStringBuilder.append("torch_type=").append(this.torch_type).append(",[");
    localStringBuilder.append("city_list=").append(this.city_list).append("]");
    localStringBuilder.append("transfer_limitTs=").append(this.transferLimitTs).append(",");
    localStringBuilder.append("transfer_over_limit=").append(this.transferOverLimit).append(",");
    localStringBuilder.append("busi_entry_seq=").append(this.business_entry_seq).append(",");
    localStringBuilder.append("busi_entry_new=").append(this.business_entry_new).append(",");
    localStringBuilder.append("isOnlyTorcher=").append(this.isOnlyTorcher).append(",");
    localStringBuilder.append("ranking=").append(this.ranking);
    localStringBuilder.append(", delay_time=").append(this.delay_time);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.olympic.TorchInfo
 * JD-Core Version:    0.7.0.1
 */