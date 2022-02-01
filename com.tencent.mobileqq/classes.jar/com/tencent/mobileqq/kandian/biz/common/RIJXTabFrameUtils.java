package com.tencent.mobileqq.kandian.biz.common;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.kandian.biz.common.api.IRIJXTabFrameUtils;
import com.tencent.mobileqq.kandian.biz.tab.ReadinjoyTabFrame;
import com.tencent.mobileqq.kandian.biz.xtab.RIJXTabFrame;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TabChannelCoverInfo;
import com.tencent.mobileqq.kandian.repo.tab.KandianFrameStatus;
import com.tencent.mobileqq.kandian.repo.xtab.api.IRIJXTabConfigHandler;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/common/RIJXTabFrameUtils;", "Lcom/tencent/mobileqq/kandian/biz/common/api/IRIJXTabFrameUtils;", "()V", "pTabFrame", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/app/Frame;", "getPTabFrame", "()Ljava/lang/Class;", "addFragment2Info", "", "tabChannelCoverInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/TabChannelCoverInfo;", "BaseFragment", "Lcom/tencent/mobileqq/app/QBaseFragment;", "createTabChannelCoverInfo", "channelID", "", "channelName", "", "jumpUrl", "isImmersive", "", "createTabFrame", "className", "frameFragment", "Lcom/tencent/mobileqq/app/FrameFragment;", "getAladdinConfigChannel", "", "getChannelBarMarginTop", "getChannelCoverList", "getChannelPaddingTop", "", "getDefaultConfigChannel", "", "getPreFrameClass", "kandianFrameStatus", "Lcom/tencent/mobileqq/kandian/repo/tab/KandianFrameStatus;", "getTabFrame", "isKandianTabFrame", "frame", "isNowInKanDianTab", "onTabClickSelf", "updateFrameStatus", "isShowKandianTab", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJXTabFrameUtils
  implements IRIJXTabFrameUtils
{
  public static final RIJXTabFrameUtils INSTANCE = new RIJXTabFrameUtils();
  
  private final TabChannelCoverInfo createTabChannelCoverInfo(int paramInt, String paramString1, String paramString2, boolean paramBoolean)
  {
    TabChannelCoverInfo localTabChannelCoverInfo = new TabChannelCoverInfo();
    localTabChannelCoverInfo.mChannelCoverId = paramInt;
    localTabChannelCoverInfo.mChannelCoverName = paramString1;
    localTabChannelCoverInfo.mChannelJumpUrl = paramString2;
    localTabChannelCoverInfo.isImmersive = paramBoolean;
    localTabChannelCoverInfo.isXTabMode = true;
    return localTabChannelCoverInfo;
  }
  
  private final List<TabChannelCoverInfo> getAladdinConfigChannel()
  {
    return ((IRIJXTabConfigHandler)QRoute.api(IRIJXTabConfigHandler.class)).getTabList();
  }
  
  @JvmStatic
  @NotNull
  public static final List<TabChannelCoverInfo> getChannelCoverList()
  {
    List localList = INSTANCE.getAladdinConfigChannel();
    if ((((Collection)localList).isEmpty() ^ true)) {
      return localList;
    }
    localList = INSTANCE.getDefaultConfigChannel();
    QLog.d("ReadInJoyHelper", 1, "getChannelCoverList, use default config!");
    return localList;
  }
  
  private final float getChannelPaddingTop(boolean paramBoolean)
  {
    float f1 = 0.0F;
    if (paramBoolean) {
      return 0.0F;
    }
    Object localObject = BaseApplicationImpl.getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "BaseApplicationImpl.getContext()");
    localObject = (Context)localObject;
    float f2 = getChannelBarMarginTop();
    localObject = ((Context)localObject).getResources();
    if (localObject != null) {
      f1 = ((Resources)localObject).getDimension(2131298876);
    }
    return f2 + f1;
  }
  
  private final List<TabChannelCoverInfo> getDefaultConfigChannel()
  {
    List localList = (List)new ArrayList();
    localList.add(createTabChannelCoverInfo$default(this, 0, "推荐", null, false, 12, null));
    localList.add(createTabChannelCoverInfo$default(this, 41726, "视频", null, true, 4, null));
    localList.add(createTabChannelCoverInfo$default(this, 41655, "好友", "https://viola.qq.com/channel/kd_feeds_new.js?_rij_violaUrl=1&v_tid=11&v_bid=3704&v_bundleName=kd_feeds_new&channelID=41655&srcID=1&key=friend", false, 8, null));
    localList.add(createTabChannelCoverInfo$default(this, 70, "关注", "https://viola.qq.com/channel/kd_feeds_new.js?_rij_violaUrl=1&v_tid=48&v_bid=4441&v_bundleName=followPage", false, 8, null));
    return localList;
  }
  
  public final void addFragment2Info(@NotNull TabChannelCoverInfo paramTabChannelCoverInfo, @Nullable QBaseFragment paramQBaseFragment)
  {
    Intrinsics.checkParameterIsNotNull(paramTabChannelCoverInfo, "tabChannelCoverInfo");
    if ((paramQBaseFragment != null) && (paramTabChannelCoverInfo.isXTabMode))
    {
      Bundle localBundle2 = paramQBaseFragment.getArguments();
      Bundle localBundle1 = localBundle2;
      if (localBundle2 == null) {
        localBundle1 = new Bundle();
      }
      localBundle1.putInt("channel_padding_top", (int)INSTANCE.getChannelPaddingTop(paramTabChannelCoverInfo.isImmersive));
      localBundle1.putBoolean("is_xtab_mode", true);
      paramQBaseFragment.setArguments(localBundle1);
    }
  }
  
  @Nullable
  public final Frame createTabFrame(@Nullable String paramString, @Nullable FrameFragment paramFrameFragment)
  {
    Object localObject = (Frame)null;
    if (!TextUtils.isEmpty((CharSequence)paramString))
    {
      if (StringsKt.equals(paramString, RIJXTabFrame.class.getName(), true)) {
        paramString = (Frame)new RIJXTabFrame(paramFrameFragment);
      } else {
        paramString = (Frame)new ReadinjoyTabFrame(paramFrameFragment);
      }
      localObject = paramString;
    }
    return localObject;
  }
  
  public final int getChannelBarMarginTop()
  {
    int j = ImmersiveUtils.getStatusBarHeight((Context)BaseApplicationImpl.getContext());
    int i = j;
    if (j <= 0) {
      i = ImmersiveUtils.dpToPx(44.0F);
    }
    return i;
  }
  
  @NotNull
  public final Class<? extends Frame> getPTabFrame()
  {
    if (((IRIJXTabConfigHandler)QRoute.api(IRIJXTabConfigHandler.class)).isXTabMode()) {
      return RIJXTabFrame.class;
    }
    return ReadinjoyTabFrame.class;
  }
  
  @NotNull
  public Class<? extends Frame> getPreFrameClass(@NotNull KandianFrameStatus paramKandianFrameStatus)
  {
    Intrinsics.checkParameterIsNotNull(paramKandianFrameStatus, "kandianFrameStatus");
    paramKandianFrameStatus = paramKandianFrameStatus.a();
    if (paramKandianFrameStatus != null) {
      return paramKandianFrameStatus;
    }
    return ReadinjoyTabFrame.class;
  }
  
  @NotNull
  public Class<? extends Frame> getTabFrame()
  {
    return getPTabFrame();
  }
  
  public boolean isKandianTabFrame(@Nullable Frame paramFrame)
  {
    return (paramFrame != null) && (((paramFrame instanceof RIJXTabFrame)) || ((paramFrame instanceof ReadinjoyTabFrame)));
  }
  
  public boolean isKandianTabFrame(@Nullable String paramString)
  {
    boolean bool2 = TextUtils.isEmpty((CharSequence)paramString);
    boolean bool1 = true;
    if (!bool2)
    {
      if (StringsKt.equals(paramString, ReadinjoyTabFrame.class.getName(), true)) {
        return bool1;
      }
      if (StringsKt.equals(paramString, RIJXTabFrame.class.getName(), true)) {
        return true;
      }
    }
    bool1 = false;
    return bool1;
  }
  
  public boolean isNowInKanDianTab()
  {
    return RIJTabFrameBase.a.a();
  }
  
  public void onTabClickSelf(@Nullable Frame paramFrame)
  {
    if ((paramFrame instanceof RIJTabFrameBase)) {
      ((RIJTabFrameBase)paramFrame).at_();
    }
  }
  
  public void updateFrameStatus(@NotNull KandianFrameStatus paramKandianFrameStatus, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramKandianFrameStatus, "kandianFrameStatus");
    paramKandianFrameStatus.a(paramBoolean);
    paramKandianFrameStatus.a(getPTabFrame());
    paramKandianFrameStatus.b(((IRIJXTabConfigHandler)QRoute.api(IRIJXTabConfigHandler.class)).isXTabMode());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.RIJXTabFrameUtils
 * JD-Core Version:    0.7.0.1
 */