package com.tencent.mobileqq.guild.profilecard.baseprofile.framework.collector;

import android.util.SparseArray;
import com.tencent.mobileqq.guild.data.profilecard.GuildBaseProfileData;
import com.tencent.mobileqq.guild.data.profilecard.GuildProfileData;
import com.tencent.mobileqq.guild.profilecard.audio.GuildProfileAudioComponent;
import com.tencent.mobileqq.guild.profilecard.baseprofile.data.IGuildProfileComponentConst;
import com.tencent.mobileqq.guild.profilecard.baseprofile.framework.component.AbsGuildProfileComponent;
import com.tencent.mobileqq.guild.profilecard.game.GuildProfileGameComponent;
import com.tencent.mobileqq.guild.profilecard.main.GuildProfileHeaderComponent;
import com.tencent.mobileqq.guild.profilecard.manage.GuildProfileLiveManageComponent;
import com.tencent.mobileqq.guild.profilecard.manage.GuildProfileManageComponent;
import com.tencent.mobileqq.utils.ViewUtils;
import java.util.ArrayList;
import java.util.List;

public class GuildProfileComponentCollector
  implements IGuildProfileComponentConst
{
  private static int a(float paramFloat)
  {
    return ViewUtils.dip2px(paramFloat);
  }
  
  public static List<Integer> a(GuildProfileData paramGuildProfileData)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(1000));
    if (paramGuildProfileData.getGuildBaseProfileData().e() == 1) {
      localArrayList.add(Integer.valueOf(1001));
    }
    if (paramGuildProfileData.getGuildBaseProfileData().e() == 2) {
      localArrayList.add(Integer.valueOf(1004));
    }
    localArrayList.add(Integer.valueOf(1003));
    localArrayList.add(Integer.valueOf(1002));
    return localArrayList;
  }
  
  public static SparseArray<Integer> b()
  {
    SparseArray localSparseArray = new SparseArray();
    localSparseArray.put(1000, Integer.valueOf(a(20.0F)));
    localSparseArray.put(1001, Integer.valueOf(a(24.0F)));
    localSparseArray.put(1003, Integer.valueOf(a(12.0F)));
    localSparseArray.put(1004, Integer.valueOf(a(12.0F)));
    return localSparseArray;
  }
  
  public SparseArray<Class<? extends AbsGuildProfileComponent>> a()
  {
    SparseArray localSparseArray = new SparseArray();
    localSparseArray.put(1000, GuildProfileHeaderComponent.class);
    localSparseArray.put(1001, GuildProfileAudioComponent.class);
    localSparseArray.put(1002, GuildProfileManageComponent.class);
    localSparseArray.put(1004, GuildProfileLiveManageComponent.class);
    localSparseArray.put(1003, GuildProfileGameComponent.class);
    return localSparseArray;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.profilecard.baseprofile.framework.collector.GuildProfileComponentCollector
 * JD-Core Version:    0.7.0.1
 */