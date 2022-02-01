package com.tencent.mobileqq.kandian.biz.xtab;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TabChannelCoverInfo;
import com.tencent.mobileqq.kandian.repo.xtab.api.impl.RIJXTabConfigHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/xtab/KDXTabChannelViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_channelInfo", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/TabChannelCoverInfo;", "account", "", "channelInfo", "Landroidx/lifecycle/LiveData;", "getChannelInfo", "()Landroidx/lifecycle/LiveData;", "changeDefaultTabWithChannelId", "", "replacedChannelId", "", "newChannelId", "isImmersive", "", "list", "enterKDTab", "isChannelExistInList", "channelId", "updateChannel", "updateTabListWithUserSetting", "tabChannelInfoList", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class KDXTabChannelViewModel
  extends ViewModel
{
  public static final KDXTabChannelViewModel.Companion a = new KDXTabChannelViewModel.Companion(null);
  private String b = "0";
  private final MutableLiveData<List<TabChannelCoverInfo>> c = new MutableLiveData(RIJXTabConfigHandler.INSTANCE.getTabList());
  @NotNull
  private final LiveData<List<TabChannelCoverInfo>> d = (LiveData)this.c;
  
  private final List<TabChannelCoverInfo> a(List<? extends TabChannelCoverInfo> paramList)
  {
    Object localObject1 = (Boolean)RIJSPUtils.b("rij_user_setting_has_set_sp_key", Boolean.valueOf(false));
    if (!((Boolean)localObject1).booleanValue())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[updateTabListWithUserSetting] userHasSet = ");
      ((StringBuilder)localObject2).append(localObject1);
      QLog.i("KDXTabChannelViewModel", 1, ((StringBuilder)localObject2).toString());
      return paramList;
    }
    Object localObject2 = RIJSPUtils.b("rij_user_setting_channel_id_sp_key", Integer.valueOf(-1));
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "RIJSPUtils.getReadInJoyS…NG_CHANNEL_ID_SP_KEY, -1)");
    int i = ((Number)localObject2).intValue();
    if (i == -1)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[updateTabListWithUserSetting] userSetChannelId = ");
      ((StringBuilder)localObject1).append(i);
      QLog.i("KDXTabChannelViewModel", 1, ((StringBuilder)localObject1).toString());
      return paramList;
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("[updateTabListWithUserSetting] userHasSet = ");
    ((StringBuilder)localObject2).append(localObject1);
    ((StringBuilder)localObject2).append(", userSetChannelId = ");
    ((StringBuilder)localObject2).append(i);
    QLog.i("KDXTabChannelViewModel", 1, ((StringBuilder)localObject2).toString());
    localObject1 = (List)new ArrayList();
    localObject2 = paramList.iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((List)localObject1).add((TabChannelCoverInfo)((Iterator)localObject2).next());
    }
    boolean bool1 = a(paramList, 0);
    boolean bool2 = a(paramList, 41726);
    if (bool1 == bool2) {
      return localObject1;
    }
    if (((bool1) && (i == 0)) || ((bool2) && (i == 41726))) {
      return localObject1;
    }
    if (i == 0) {
      a(41726, 0, false, paramList);
    }
    if (i == 41726) {
      a(0, 41726, true, paramList);
    }
    return localObject1;
  }
  
  private final void a(int paramInt1, int paramInt2, boolean paramBoolean, List<? extends TabChannelCoverInfo> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      TabChannelCoverInfo localTabChannelCoverInfo = (TabChannelCoverInfo)paramList.next();
      if (localTabChannelCoverInfo.mChannelCoverId == paramInt1)
      {
        localTabChannelCoverInfo.mChannelCoverId = paramInt2;
        localTabChannelCoverInfo.isImmersive = paramBoolean;
        paramList = new StringBuilder();
        paramList.append("[changeDefaultTabWithChannelId] ");
        paramList.append("replacedChannelId = ");
        paramList.append(paramInt1);
        paramList.append(", newChannelId = ");
        paramList.append(paramInt2);
        paramList.append(", isImmersive = ");
        paramList.append(paramBoolean);
        QLog.i("KDXTabChannelViewModel", 1, paramList.toString());
      }
    }
  }
  
  private final boolean a(List<? extends TabChannelCoverInfo> paramList, int paramInt)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      if (((TabChannelCoverInfo)paramList.next()).mChannelCoverId == paramInt) {
        return true;
      }
    }
    return false;
  }
  
  @NotNull
  public final LiveData<List<TabChannelCoverInfo>> a()
  {
    return this.d;
  }
  
  public final void b()
  {
    this.c.setValue(a(RIJXTabConfigHandler.INSTANCE.getTabList()));
  }
  
  public final void c()
  {
    if (!StringsKt.equals(RIJQQAppInterfaceUtil.d(), this.b, true))
    {
      String str = RIJQQAppInterfaceUtil.d();
      Intrinsics.checkExpressionValueIsNotNull(str, "RIJQQAppInterfaceUtil.getAccount()");
      this.b = str;
      b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.xtab.KDXTabChannelViewModel
 * JD-Core Version:    0.7.0.1
 */