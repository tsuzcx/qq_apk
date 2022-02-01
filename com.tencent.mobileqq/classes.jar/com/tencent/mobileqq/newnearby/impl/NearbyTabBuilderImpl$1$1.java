package com.tencent.mobileqq.newnearby.impl;

import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.newnearby.INearbyResDownloader;
import com.tencent.mobileqq.newnearby.model.TabInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.trpcprotocol.nearby.trpc_nearby_control.nearby_control.nearbyControl.GetTabConfigRsp;
import com.tencent.trpcprotocol.nearby.trpc_nearby_control.nearby_control.nearbyControl.TabConfig;
import java.util.List;

class NearbyTabBuilderImpl$1$1
  implements Runnable
{
  NearbyTabBuilderImpl$1$1(NearbyTabBuilderImpl.1 param1, nearbyControl.GetTabConfigRsp paramGetTabConfigRsp) {}
  
  public void run()
  {
    NearbyTabBuilderImpl.access$000(this.b.c).clear();
    INearbyResDownloader localINearbyResDownloader = (INearbyResDownloader)QRoute.api(INearbyResDownloader.class);
    int j = this.a.tab_config.size();
    int i = 0;
    while (i < j)
    {
      nearbyControl.TabConfig localTabConfig = (nearbyControl.TabConfig)this.a.tab_config.get(i);
      TabInfo localTabInfo = new TabInfo();
      localTabInfo.b = localTabConfig.tab_name.get();
      localTabInfo.c = localTabConfig.tab_type.get();
      localTabInfo.d = ((int)localTabConfig.tab_id.get() - 1);
      if (localTabInfo.c == 4) {
        TabInfo.a = localTabInfo.d;
      }
      if ((this.b.a instanceof NearbyActivity)) {
        ((NearbyActivity)this.b.a).setMsgTabIndex(TabInfo.a);
      }
      localTabInfo.e = localINearbyResDownloader.downloadImg(localTabConfig.tab_icon_selected_webp.get(), localTabInfo.c, true);
      localTabInfo.f = localINearbyResDownloader.downloadImg(localTabConfig.tab_icon_normal_webp.get(), localTabInfo.c, false);
      NearbyTabBuilderImpl.access$000(this.b.c).add(localTabInfo);
      i += 1;
    }
    NearbyTabBuilderImpl.access$100(this.b.c, this.b.a, this.b.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.newnearby.impl.NearbyTabBuilderImpl.1.1
 * JD-Core Version:    0.7.0.1
 */