package com.tencent.mobileqq.kandian.repo.feeds.entity;

import android.text.TextUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import tencent.im.oidb.cmd0xbc9.oidb_cmd0xbc9.DynamicBannerItem;

public class TopBannerInfo$DynamicItem
{
  public String a;
  
  public static List<DynamicItem> a(oidb_cmd0xbc9.DynamicBannerItem paramDynamicBannerItem)
  {
    ArrayList localArrayList = new ArrayList();
    if (!paramDynamicBannerItem.bytes_dynamic_json.has()) {
      return localArrayList;
    }
    Object localObject1 = paramDynamicBannerItem.bytes_dynamic_json.get().toStringUtf8();
    try
    {
      localObject2 = new JSONArray((String)localObject1);
      int i = 0;
      while (i < ((JSONArray)localObject2).length())
      {
        DynamicItem localDynamicItem = new DynamicItem();
        localDynamicItem.a = ((JSONArray)localObject2).get(i).toString();
        localArrayList.add(localDynamicItem);
        i += 1;
      }
    }
    catch (Exception localException)
    {
      Object localObject2;
      label91:
      break label91;
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("");
    ((StringBuilder)localObject2).append((String)localObject1);
    QLog.d("TopBannerInfo", 4, ((StringBuilder)localObject2).toString());
    localObject1 = new DynamicItem();
    ((DynamicItem)localObject1).a = paramDynamicBannerItem.bytes_dynamic_json.get().toStringUtf8();
    localArrayList.add(localObject1);
    return localArrayList;
  }
  
  public oidb_cmd0xbc9.DynamicBannerItem a()
  {
    oidb_cmd0xbc9.DynamicBannerItem localDynamicBannerItem = new oidb_cmd0xbc9.DynamicBannerItem();
    if (!TextUtils.isEmpty(this.a)) {
      localDynamicBannerItem.bytes_dynamic_json.set(ByteStringMicro.copyFromUtf8(this.a));
    }
    return localDynamicBannerItem;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.entity.TopBannerInfo.DynamicItem
 * JD-Core Version:    0.7.0.1
 */