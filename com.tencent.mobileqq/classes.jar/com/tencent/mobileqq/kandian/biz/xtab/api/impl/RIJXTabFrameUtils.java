package com.tencent.mobileqq.kandian.biz.xtab.api.impl;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.biz.common.RIJTabFrameBase;
import com.tencent.mobileqq.kandian.biz.common.RIJTabFrameBase.Companion;
import com.tencent.mobileqq.kandian.biz.tab.ReadinjoyTabFrame;
import com.tencent.mobileqq.kandian.biz.xtab.RIJXTabFrame;
import com.tencent.mobileqq.kandian.biz.xtab.api.IRIJXTabFrameUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TabChannelCoverInfo;
import com.tencent.mobileqq.kandian.repo.tab.KandianFrameStatus;
import com.tencent.mobileqq.kandian.repo.xtab.api.impl.RIJXTabConfigHandler;
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
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/xtab/api/impl/RIJXTabFrameUtils;", "Lcom/tencent/mobileqq/kandian/biz/xtab/api/IRIJXTabFrameUtils;", "()V", "TAG", "", "pTabFrame", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/app/Frame;", "getPTabFrame", "()Ljava/lang/Class;", "addCommonInfoForViola", "", "bundle", "Landroid/os/Bundle;", "tabChannelCoverInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/TabChannelCoverInfo;", "addFragment2Info", "BaseFragment", "Lcom/tencent/mobileqq/app/QBaseFragment;", "createTabChannelCoverInfo", "channelID", "", "channelName", "jumpUrl", "isImmersive", "", "getAladdinConfigChannel", "", "getChannelBarMarginTop", "getChannelCoverList", "getChannelPaddingTop", "", "getDefaultConfigChannel", "", "getPreFrameClass", "kandianFrameStatus", "Lcom/tencent/mobileqq/kandian/repo/tab/KandianFrameStatus;", "getTabFrame", "isIconTab", "isKandianTabFrame", "frame", "className", "isNowInKanDianTab", "onTabClickSelf", "updateFeedsStyleUserSetting", "type", "updateFrameStatus", "isShowKandianTab", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJXTabFrameUtils
  implements IRIJXTabFrameUtils
{
  public static final RIJXTabFrameUtils INSTANCE = new RIJXTabFrameUtils();
  @NotNull
  public static final String TAG = "RIJXTabFrameUtils";
  
  private final void addCommonInfoForViola(Bundle paramBundle, TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    Object localObject = paramBundle.getString("param", "");
    try
    {
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        localObject = new JSONObject();
      } else {
        localObject = new JSONObject((String)localObject);
      }
      ((JSONObject)localObject).put("channel_icon", isIconTab(paramTabChannelCoverInfo.isIconTab));
      paramBundle.putString("param", ((JSONObject)localObject).toString());
      return;
    }
    catch (Exception paramBundle)
    {
      paramTabChannelCoverInfo = new StringBuilder();
      paramTabChannelCoverInfo.append("addCommonInfoForViola error! msg=");
      paramTabChannelCoverInfo.append(paramBundle);
      QLog.d("ReadInJoyHelper", 1, paramTabChannelCoverInfo.toString());
    }
  }
  
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
    return RIJXTabConfigHandler.INSTANCE.getTabList();
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
      f1 = ((Resources)localObject).getDimension(2131299593);
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
  
  private final Class<? extends Frame> getPTabFrame()
  {
    if (RIJXTabConfigHandler.INSTANCE.isXTabMode()) {
      return RIJXTabFrame.class;
    }
    return ReadinjoyTabFrame.class;
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
      INSTANCE.addCommonInfoForViola(localBundle1, paramTabChannelCoverInfo);
      paramQBaseFragment.setArguments(localBundle1);
    }
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
  public Class<? extends Frame> getPreFrameClass(@NotNull KandianFrameStatus paramKandianFrameStatus)
  {
    Intrinsics.checkParameterIsNotNull(paramKandianFrameStatus, "kandianFrameStatus");
    paramKandianFrameStatus = paramKandianFrameStatus.c();
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
  
  public final int isIconTab(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 2;
    }
    return 1;
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
    return RIJTabFrameBase.d.a();
  }
  
  public void onTabClickSelf(@Nullable Frame paramFrame)
  {
    if ((paramFrame instanceof RIJTabFrameBase)) {
      ((RIJTabFrameBase)paramFrame).e();
    }
  }
  
  public final void updateFeedsStyleUserSetting(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[updateFeedsStyleUserSetting] type = ");
    ((StringBuilder)localObject).append(paramInt);
    localObject = ((StringBuilder)localObject).toString();
    Boolean localBoolean = Boolean.valueOf(true);
    QLog.i("RIJXTabFrameUtils", 1, (String)localObject);
    if (paramInt != 1)
    {
      if (paramInt != 3)
      {
        if (paramInt != 4)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("[updateFeedsStyleUserSetting] type = ");
          ((StringBuilder)localObject).append(paramInt);
          ((StringBuilder)localObject).append(", do not handle it.");
          QLog.i("RIJXTabFrameUtils", 1, ((StringBuilder)localObject).toString());
          return;
        }
        RIJSPUtils.a("rij_user_setting_has_set_sp_key", localBoolean);
        RIJSPUtils.a("rij_user_setting_channel_id_sp_key", Integer.valueOf(0));
        RIJSPUtils.a("rij_user_setting_feeds_style_type_sp_key", Integer.valueOf(4));
        return;
      }
      RIJSPUtils.a("rij_user_setting_has_set_sp_key", localBoolean);
      RIJSPUtils.a("rij_user_setting_channel_id_sp_key", Integer.valueOf(41726));
      RIJSPUtils.a("rij_user_setting_feeds_style_type_sp_key", Integer.valueOf(3));
      return;
    }
    RIJSPUtils.a("rij_user_setting_has_set_sp_key", localBoolean);
    RIJSPUtils.a("rij_user_setting_channel_id_sp_key", Integer.valueOf(0));
    RIJSPUtils.a("rij_user_setting_feeds_style_type_sp_key", Integer.valueOf(1));
  }
  
  public void updateFrameStatus(@NotNull KandianFrameStatus paramKandianFrameStatus, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramKandianFrameStatus, "kandianFrameStatus");
    paramKandianFrameStatus.a(paramBoolean);
    paramKandianFrameStatus.a(getPTabFrame());
    paramKandianFrameStatus.b(RIJXTabConfigHandler.INSTANCE.isXTabMode());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.xtab.api.impl.RIJXTabFrameUtils
 * JD-Core Version:    0.7.0.1
 */