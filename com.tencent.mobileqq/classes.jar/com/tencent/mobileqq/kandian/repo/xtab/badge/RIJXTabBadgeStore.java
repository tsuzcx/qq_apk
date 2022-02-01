package com.tencent.mobileqq.kandian.repo.xtab.badge;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import androidx.annotation.VisibleForTesting;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.ktx.RIJSerializableKtxKt;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TabChannelCoverInfo;
import com.tencent.mobileqq.kandian.repo.tab.RIJXTabRedDotInfo;
import com.tencent.mobileqq.kandian.repo.xtab.api.impl.RIJXTabConfigHandler;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.util.QLog;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/repo/xtab/badge/RIJXTabBadgeStore;", "", "()V", "CHANNEL_ID_UNKNOWN", "", "SP_KEY_GUIDE_BADGE_PREFIX", "", "SP_KEY_KANDIAN_TAB_UNREAD", "SP_KEY_RED_DOT_INFO", "TAG", "badgeInfoMap", "", "Lcom/tencent/mobileqq/kandian/repo/tab/RIJXTabRedDotInfo;", "getBadgeInfoMap", "()Ljava/util/Map;", "badgeInfoMap$delegate", "Lkotlin/Lazy;", "hasKandianTabUnread", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getHasKandianTabUnread", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "hasKandianTabUnread$delegate", "addBadgeMsg", "", "info", "clearAllInvalidateBadgeMsg", "", "clearGuideBadgeFlag", "channelId", "getAllBadgeMsg", "", "getBadgeMsg", "getGuideBadgeShowFlag", "getJumpPriorityChannelId", "getLatestBadgeInfo", "hasChannelBadge", "initCache", "isChannelExists", "loadFormSp", "markBadgeExposed", "markKanidianTabHasRead", "removeBadgeMsg", "userAction", "saveToSP", "setBadgeInfo", "infos", "", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJXTabBadgeStore
{
  public static final RIJXTabBadgeStore a = new RIJXTabBadgeStore();
  private static final Lazy b = LazyKt.lazy((Function0)RIJXTabBadgeStore.badgeInfoMap.2.INSTANCE);
  private static final Lazy c = LazyKt.lazy((Function0)RIJXTabBadgeStore.hasKandianTabUnread.2.INSTANCE);
  
  @JvmStatic
  @Nullable
  public static final RIJXTabRedDotInfo a(int paramInt, boolean paramBoolean)
  {
    RIJXTabRedDotInfo localRIJXTabRedDotInfo = (RIJXTabRedDotInfo)a.g().remove(Integer.valueOf(paramInt));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("removeBadgeMsg --> channelId:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", info:");
    localStringBuilder.append(localRIJXTabRedDotInfo);
    localStringBuilder.append(", userAction:");
    localStringBuilder.append(paramBoolean);
    QLog.d("RIJXTabBadgeStore", 2, localStringBuilder.toString());
    if (localRIJXTabRedDotInfo != null)
    {
      if (paramBoolean)
      {
        a.h().set(false);
        RIJXTabBadgeReporter.b(localRIJXTabRedDotInfo);
        RIJXTabBadgeReporter.a(localRIJXTabRedDotInfo, 1);
      }
      a.j();
    }
    return localRIJXTabRedDotInfo;
  }
  
  @JvmStatic
  public static final boolean a()
  {
    return (a.b()) && (a.h().get());
  }
  
  @JvmStatic
  @Nullable
  public static final RIJXTabRedDotInfo b(int paramInt)
  {
    return (RIJXTabRedDotInfo)a.g().get(Integer.valueOf(paramInt));
  }
  
  private final boolean e(int paramInt)
  {
    Iterator localIterator = ((Iterable)RIJXTabConfigHandler.INSTANCE.getTabList()).iterator();
    while (localIterator.hasNext()) {
      if (((TabChannelCoverInfo)localIterator.next()).mChannelCoverId == paramInt) {
        return true;
      }
    }
    return false;
  }
  
  private final Map<Integer, RIJXTabRedDotInfo> g()
  {
    return (Map)b.getValue();
  }
  
  private final AtomicBoolean h()
  {
    return (AtomicBoolean)c.getValue();
  }
  
  private final void i()
  {
    g().clear();
    SharedPreferences localSharedPreferences = RIJSPUtils.a(RIJQQAppInterfaceUtil.e(), true, false);
    Object localObject1 = localSharedPreferences.getStringSet("kandian_x_tab_red_dot", SetsKt.emptySet());
    if (localObject1 != null)
    {
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = PkgTools.hexToBytes((String)((Iterator)localObject1).next());
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "PkgTools.hexToBytes(it)");
        localObject2 = (RIJXTabRedDotInfo)RIJSerializableKtxKt.a((byte[])localObject2);
        if (localObject2 != null) {
          localObject2 = (RIJXTabRedDotInfo)a.g().put(Integer.valueOf(((RIJXTabRedDotInfo)localObject2).getChannelId()), localObject2);
        }
      }
      f();
      h().set(localSharedPreferences.getBoolean("kandian_tab_unread", false));
    }
  }
  
  private final void j()
  {
    ThreadManager.getSubThreadHandler().post((Runnable)RIJXTabBadgeStore.saveToSP.1.a);
  }
  
  public final void a(int paramInt)
  {
    RIJXTabRedDotInfo localRIJXTabRedDotInfo = (RIJXTabRedDotInfo)g().get(Integer.valueOf(paramInt));
    if (localRIJXTabRedDotInfo != null) {
      localRIJXTabRedDotInfo.setExposureTime(NetConnInfoCenter.getServerTimeMillis());
    }
    j();
  }
  
  public final boolean a(@NotNull RIJXTabRedDotInfo paramRIJXTabRedDotInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramRIJXTabRedDotInfo, "info");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("addBadgeMsg() --> ");
    localStringBuilder.append(paramRIJXTabRedDotInfo);
    QLog.d("RIJXTabBadgeStore", 2, localStringBuilder.toString());
    g().put(Integer.valueOf(paramRIJXTabRedDotInfo.getChannelId()), paramRIJXTabRedDotInfo);
    h().set(true);
    j();
    return true;
  }
  
  public final boolean b()
  {
    return g().isEmpty() ^ true;
  }
  
  public final int c()
  {
    RIJXTabRedDotInfo localRIJXTabRedDotInfo = d();
    if (localRIJXTabRedDotInfo != null)
    {
      if ((localRIJXTabRedDotInfo.getChannelId() != TabChannelCoverInfo.TYPE_CHANNEL_XTAB_KD_COMMUNITY_CONFIG) && (localRIJXTabRedDotInfo.getChannelId() != TabChannelCoverInfo.TYPE_CHANNEL_XTAB_FRIEND_CONFIG))
      {
        if (g().containsKey(Integer.valueOf(localRIJXTabRedDotInfo.getPriorityChannelId()))) {
          return localRIJXTabRedDotInfo.getPriorityChannelId();
        }
        return localRIJXTabRedDotInfo.getChannelId();
      }
      return RIJXTabConfigHandler.INSTANCE.getDefaultEnterTabId();
    }
    return -1;
  }
  
  public final void c(int paramInt)
  {
    SharedPreferences.Editor localEditor = RIJSPUtils.a(RIJQQAppInterfaceUtil.e(), true, false).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("kandian_guide_badge_");
    localStringBuilder.append(paramInt);
    localEditor.putBoolean(localStringBuilder.toString(), false);
    localEditor.apply();
  }
  
  @Nullable
  public final RIJXTabRedDotInfo d()
  {
    if (g().isEmpty()) {
      return null;
    }
    return (RIJXTabRedDotInfo)((Map.Entry)CollectionsKt.last(CollectionsKt.sortedWith((Iterable)g().entrySet(), (Comparator)new RIJXTabBadgeStore.getLatestBadgeInfo..inlined.sortedBy.1()))).getValue();
  }
  
  public final boolean d(int paramInt)
  {
    SharedPreferences localSharedPreferences = RIJSPUtils.a(RIJQQAppInterfaceUtil.e(), true, false);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("kandian_guide_badge_");
    localStringBuilder.append(paramInt);
    return localSharedPreferences.getBoolean(localStringBuilder.toString(), true);
  }
  
  public final void e()
  {
    QLog.d("RIJXTabBadgeStore", 2, "initCache()");
    i();
  }
  
  @VisibleForTesting
  public final void f()
  {
    QLog.d("RIJXTabBadgeStore", 2, "clearAllInvalidateBadgeMsg()");
    int m = RIJXTabConfigHandler.INSTANCE.getRedDotExpireTimeInMin();
    long l1 = NetConnInfoCenter.getServerTimeMillis();
    Object localObject = g();
    Map localMap = (Map)new LinkedHashMap();
    localObject = ((Map)localObject).entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      long l2 = ((RIJXTabRedDotInfo)localEntry.getValue()).getArrivedTime();
      long l3 = m * 60 * 1000;
      int k = 0;
      int i;
      if (l1 - l2 < l3) {
        i = 1;
      } else {
        i = 0;
      }
      boolean bool = a.e(((Number)localEntry.getKey()).intValue());
      if ((i == 0) || (!bool))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("filter invalid red dot(expired:");
        localStringBuilder.append(i ^ 0x1);
        localStringBuilder.append(", tabNotExists:");
        localStringBuilder.append(bool ^ true);
        localStringBuilder.append(") --> ");
        localStringBuilder.append((RIJXTabRedDotInfo)localEntry.getValue());
        QLog.d("RIJXTabBadgeStore", 2, localStringBuilder.toString());
      }
      if (i == 0) {
        RIJXTabBadgeReporter.a((RIJXTabRedDotInfo)localEntry.getValue(), 2);
      }
      int j = k;
      if (i != 0)
      {
        j = k;
        if (bool) {
          j = 1;
        }
      }
      if (j != 0) {
        localMap.put(localEntry.getKey(), localEntry.getValue());
      }
    }
    g().clear();
    g().putAll(localMap);
    j();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.xtab.badge.RIJXTabBadgeStore
 * JD-Core Version:    0.7.0.1
 */