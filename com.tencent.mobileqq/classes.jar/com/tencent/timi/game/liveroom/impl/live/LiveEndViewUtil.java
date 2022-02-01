package com.tencent.timi.game.liveroom.impl.live;

import android.app.Activity;
import android.content.Context;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.IQQLiveUtil;
import com.tencent.mobileqq.qqlive.api.end.IQQLiveEndView;
import com.tencent.mobileqq.qqlive.api.message.IQQLiveFollowMsgService;
import com.tencent.mobileqq.qqlive.callback.EndLiveClickCallback;
import com.tencent.mobileqq.qqlive.callback.follow.IQQLiveCheckFollowCallback;
import com.tencent.mobileqq.qqlive.data.QQLiveEndPageInfo;
import com.tencent.mobileqq.qqlive.data.QQLiveEndRecommendInfo;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomGameInfo;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataRoomInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataUserInfo;
import com.tencent.mobileqq.qqlive.data.record.QQLiveSwitchRoom;
import com.tencent.mobileqq.qqlive.data.room.LiveAnchorInfo;
import com.tencent.mobileqq.qqlive.data.room.realtime.LiveRealTimeInfo;
import com.tencent.mobileqq.qqlive.data.room.realtime.RealTimeData;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.timi.game.api.live.LiveRoomExtraInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/liveroom/impl/live/LiveEndViewUtil;", "", "()V", "anchorCreateLiveEndView", "Lcom/tencent/mobileqq/qqlive/api/end/IQQLiveEndView;", "activity", "Landroid/app/Activity;", "liveSdk", "Lcom/tencent/mobileqq/qqlive/api/IQQLiveSDK;", "anchorRoomInfo", "Lcom/tencent/mobileqq/qqlive/data/anchor/room/QQLiveAnchorRoomInfo;", "liveRealTimeInfo", "Lcom/tencent/mobileqq/qqlive/data/room/realtime/LiveRealTimeInfo;", "callback", "Lcom/tencent/mobileqq/qqlive/callback/EndLiveClickCallback;", "anchorMakeQQLiveEndPageInfo", "Lcom/tencent/mobileqq/qqlive/data/QQLiveEndPageInfo;", "realTimeInfo", "audienceCreateLiveEndView", "roomId", "", "programId", "", "liveUserInfo", "Lcom/tencent/mobileqq/qqlive/data/user/LiveUserInfo;", "liveAnchorInfo", "Lcom/tencent/mobileqq/qqlive/data/room/LiveAnchorInfo;", "extraInfo", "Lcom/tencent/timi/game/api/live/LiveRoomExtraInfo;", "follow", "", "audienceMakeQQLiveEndPageInfo", "selfUid", "anchorInfo", "checkFollowStatus", "", "anchorUid", "Lcom/tencent/mobileqq/qqlive/callback/follow/IQQLiveCheckFollowCallback;", "getRecommendRoomList", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/qqlive/data/QQLiveEndRecommendInfo;", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class LiveEndViewUtil
{
  public static final LiveEndViewUtil a = new LiveEndViewUtil();
  
  private final QQLiveEndPageInfo a(long paramLong1, long paramLong2, String paramString, IQQLiveSDK paramIQQLiveSDK, LiveAnchorInfo paramLiveAnchorInfo, LiveRealTimeInfo paramLiveRealTimeInfo, LiveRoomExtraInfo paramLiveRoomExtraInfo, int paramInt)
  {
    QQLiveEndPageInfo localQQLiveEndPageInfo = new QQLiveEndPageInfo();
    localQQLiveEndPageInfo.roomId = paramLong2;
    if (paramString == null) {
      paramString = "";
    }
    localQQLiveEndPageInfo.programId = paramString;
    localQQLiveEndPageInfo.liveType = 0;
    if (paramLiveRoomExtraInfo != null)
    {
      paramString = String.valueOf(paramLiveRoomExtraInfo.b);
      if (paramString != null) {}
    }
    else
    {
      paramString = "";
    }
    localQQLiveEndPageInfo.liveContent = paramString;
    if (paramLiveRoomExtraInfo != null)
    {
      paramString = String.valueOf(paramLiveRoomExtraInfo.d);
      if (paramString != null) {}
    }
    else
    {
      paramString = "";
    }
    localQQLiveEndPageInfo.liveSource = paramString;
    localQQLiveEndPageInfo.uid = paramLong1;
    if (paramLiveAnchorInfo != null) {
      paramLong1 = paramLiveAnchorInfo.uid;
    } else {
      paramLong1 = 0L;
    }
    localQQLiveEndPageInfo.anchorUid = paramLong1;
    if (paramLiveAnchorInfo != null)
    {
      paramString = paramLiveAnchorInfo.headUrl;
      if (paramString != null) {}
    }
    else
    {
      paramString = "";
    }
    localQQLiveEndPageInfo.headIcon = paramString;
    if (paramLiveAnchorInfo != null)
    {
      paramString = paramLiveAnchorInfo.nickName;
      if (paramString != null) {}
    }
    else
    {
      paramString = "";
    }
    localQQLiveEndPageInfo.nick = paramString;
    if (paramLiveRealTimeInfo != null)
    {
      paramString = paramLiveRealTimeInfo.items;
      if (paramString != null)
      {
        paramString = ((Iterable)paramString).iterator();
        while (paramString.hasNext())
        {
          paramLiveAnchorInfo = (RealTimeData)paramString.next();
          paramLiveRealTimeInfo = paramLiveAnchorInfo.type;
          if (paramLiveRealTimeInfo != null)
          {
            int i = LiveEndViewUtil.WhenMappings.$EnumSwitchMapping$1[paramLiveRealTimeInfo.ordinal()];
            if (i != 1)
            {
              if (i == 2) {
                localQQLiveEndPageInfo.popularity = String.valueOf(paramLiveAnchorInfo.value);
              }
            }
            else {
              localQQLiveEndPageInfo.time = paramLiveAnchorInfo.value;
            }
          }
        }
      }
    }
    localQQLiveEndPageInfo.follow = paramInt;
    localQQLiveEndPageInfo.recommendInfos = a(paramIQQLiveSDK, paramLong2);
    return localQQLiveEndPageInfo;
  }
  
  private final QQLiveEndPageInfo a(IQQLiveSDK paramIQQLiveSDK, QQLiveAnchorRoomInfo paramQQLiveAnchorRoomInfo, LiveRealTimeInfo paramLiveRealTimeInfo)
  {
    QQLiveEndPageInfo localQQLiveEndPageInfo = new QQLiveEndPageInfo();
    long l2 = 0L;
    if (paramQQLiveAnchorRoomInfo != null)
    {
      localObject = paramQQLiveAnchorRoomInfo.roomData;
      if (localObject != null)
      {
        l1 = ((QQLiveAnchorDataRoomInfo)localObject).getRoomId();
        break label40;
      }
    }
    long l1 = 0L;
    label40:
    localQQLiveEndPageInfo.roomId = l1;
    if (paramQQLiveAnchorRoomInfo != null)
    {
      localObject = paramQQLiveAnchorRoomInfo.roomData;
      if (localObject != null)
      {
        localObject = ((QQLiveAnchorDataRoomInfo)localObject).programId;
        if (localObject != null)
        {
          localObject = ((String)localObject).toString();
          if (localObject != null) {
            break label93;
          }
        }
      }
    }
    Object localObject = "";
    label93:
    localQQLiveEndPageInfo.programId = ((String)localObject);
    localQQLiveEndPageInfo.liveType = 0;
    if (paramQQLiveAnchorRoomInfo != null)
    {
      localObject = paramQQLiveAnchorRoomInfo.roomData;
      if (localObject != null)
      {
        localObject = ((QQLiveAnchorDataRoomInfo)localObject).gameInfo;
        if (localObject != null)
        {
          localObject = String.valueOf(((QQLiveAnchorRoomGameInfo)localObject).id);
          if (localObject != null) {
            break label155;
          }
        }
      }
    }
    localObject = "";
    label155:
    localQQLiveEndPageInfo.liveContent = ((String)localObject);
    if (paramIQQLiveSDK != null)
    {
      paramIQQLiveSDK = paramIQQLiveSDK.getAppId();
      if (paramIQQLiveSDK != null) {}
    }
    else
    {
      paramIQQLiveSDK = "";
    }
    localQQLiveEndPageInfo.liveSource = paramIQQLiveSDK;
    if (paramQQLiveAnchorRoomInfo != null)
    {
      paramIQQLiveSDK = paramQQLiveAnchorRoomInfo.userDta;
      if (paramIQQLiveSDK != null)
      {
        l1 = paramIQQLiveSDK.id;
        break label214;
      }
    }
    l1 = 0L;
    label214:
    localQQLiveEndPageInfo.uid = l1;
    l1 = l2;
    if (paramQQLiveAnchorRoomInfo != null)
    {
      paramIQQLiveSDK = paramQQLiveAnchorRoomInfo.userDta;
      l1 = l2;
      if (paramIQQLiveSDK != null) {
        l1 = paramIQQLiveSDK.id;
      }
    }
    localQQLiveEndPageInfo.anchorUid = l1;
    if (paramQQLiveAnchorRoomInfo != null)
    {
      paramIQQLiveSDK = paramQQLiveAnchorRoomInfo.userDta;
      if (paramIQQLiveSDK != null)
      {
        paramIQQLiveSDK = paramIQQLiveSDK.avatarUrl;
        if (paramIQQLiveSDK != null) {
          break label283;
        }
      }
    }
    paramIQQLiveSDK = "";
    label283:
    localQQLiveEndPageInfo.headIcon = paramIQQLiveSDK;
    if (paramQQLiveAnchorRoomInfo != null)
    {
      paramIQQLiveSDK = paramQQLiveAnchorRoomInfo.userDta;
      if (paramIQQLiveSDK != null)
      {
        paramIQQLiveSDK = paramIQQLiveSDK.nickName;
        if (paramIQQLiveSDK != null) {
          break label317;
        }
      }
    }
    paramIQQLiveSDK = "";
    label317:
    localQQLiveEndPageInfo.nick = paramIQQLiveSDK;
    if (paramLiveRealTimeInfo != null)
    {
      paramIQQLiveSDK = paramLiveRealTimeInfo.items;
      if (paramIQQLiveSDK != null)
      {
        paramIQQLiveSDK = ((Iterable)paramIQQLiveSDK).iterator();
        while (paramIQQLiveSDK.hasNext())
        {
          paramQQLiveAnchorRoomInfo = (RealTimeData)paramIQQLiveSDK.next();
          paramLiveRealTimeInfo = paramQQLiveAnchorRoomInfo.type;
          if (paramLiveRealTimeInfo != null)
          {
            int i = LiveEndViewUtil.WhenMappings.$EnumSwitchMapping$0[paramLiveRealTimeInfo.ordinal()];
            if (i != 1)
            {
              if (i == 2) {
                localQQLiveEndPageInfo.popularity = String.valueOf(paramQQLiveAnchorRoomInfo.value);
              }
            }
            else {
              localQQLiveEndPageInfo.time = paramQQLiveAnchorRoomInfo.value;
            }
          }
        }
      }
    }
    localQQLiveEndPageInfo.follow = 0;
    return localQQLiveEndPageInfo;
  }
  
  private final ArrayList<QQLiveEndRecommendInfo> a(IQQLiveSDK paramIQQLiveSDK, long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramIQQLiveSDK != null)
    {
      paramIQQLiveSDK = paramIQQLiveSDK.getFetchRoomList();
      if (paramIQQLiveSDK != null)
      {
        int i;
        if (paramIQQLiveSDK.size() > 0) {
          i = 1;
        } else {
          i = 0;
        }
        if (i == 0) {
          paramIQQLiveSDK = null;
        }
        if (paramIQQLiveSDK != null)
        {
          int j = paramIQQLiveSDK.size();
          i = 0;
          while (i < j)
          {
            if (paramLong == ((QQLiveSwitchRoom)paramIQQLiveSDK.get(i)).roomId) {
              break label108;
            }
            i += 1;
          }
          i = -1;
          label108:
          Object localObject = (List)null;
          if (i == -1) {
            paramIQQLiveSDK = paramIQQLiveSDK.subList(0, RangesKt.coerceAtMost(2, paramIQQLiveSDK.size()));
          } else if (i < paramIQQLiveSDK.size()) {
            paramIQQLiveSDK = paramIQQLiveSDK.subList(i + 1, RangesKt.coerceAtMost(i + 3, paramIQQLiveSDK.size()));
          } else {
            paramIQQLiveSDK = (IQQLiveSDK)localObject;
          }
          if (paramIQQLiveSDK != null)
          {
            if (!(((Collection)paramIQQLiveSDK).isEmpty() ^ true)) {
              paramIQQLiveSDK = null;
            }
            if (paramIQQLiveSDK != null)
            {
              paramIQQLiveSDK = ((Iterable)paramIQQLiveSDK).iterator();
              while (paramIQQLiveSDK.hasNext())
              {
                localObject = (QQLiveSwitchRoom)paramIQQLiveSDK.next();
                QQLiveEndRecommendInfo localQQLiveEndRecommendInfo = new QQLiveEndRecommendInfo();
                localQQLiveEndRecommendInfo.roomId = ((QQLiveSwitchRoom)localObject).roomId;
                localQQLiveEndRecommendInfo.roomBg = ((QQLiveSwitchRoom)localObject).coverUrl;
                localQQLiveEndRecommendInfo.nick = ((QQLiveSwitchRoom)localObject).anchorNick;
                Long localLong = ((QQLiveSwitchRoom)localObject).popularity;
                Intrinsics.checkExpressionValueIsNotNull(localLong, "roomInfo.popularity");
                localQQLiveEndRecommendInfo.popularity = localLong.longValue();
                localQQLiveEndRecommendInfo.roomType = ((QQLiveSwitchRoom)localObject).roomType;
                localQQLiveEndRecommendInfo.roomTitle = ((QQLiveSwitchRoom)localObject).title;
                localQQLiveEndRecommendInfo.videoUrl = ((QQLiveSwitchRoom)localObject).videoUrl;
                localQQLiveEndRecommendInfo.videoId = ((QQLiveSwitchRoom)localObject).videoId;
                localQQLiveEndRecommendInfo.gameId = ((QQLiveSwitchRoom)localObject).gameId;
                localQQLiveEndRecommendInfo.gameTagId = ((QQLiveSwitchRoom)localObject).gameTagId;
                localQQLiveEndRecommendInfo.videoSource = ((QQLiveSwitchRoom)localObject).videoSource;
                localQQLiveEndRecommendInfo.rtmpUrl = ((QQLiveSwitchRoom)localObject).rtmpUrl;
                localQQLiveEndRecommendInfo.traceInfo = ((QQLiveSwitchRoom)localObject).traceInfo;
                localArrayList.add(localQQLiveEndRecommendInfo);
              }
            }
          }
        }
      }
    }
    return localArrayList;
  }
  
  @Nullable
  public final IQQLiveEndView a(@Nullable Activity paramActivity, long paramLong, @Nullable String paramString, @Nullable IQQLiveSDK paramIQQLiveSDK, @Nullable LiveUserInfo paramLiveUserInfo, @Nullable LiveAnchorInfo paramLiveAnchorInfo, @Nullable LiveRealTimeInfo paramLiveRealTimeInfo, @Nullable LiveRoomExtraInfo paramLiveRoomExtraInfo, int paramInt, @Nullable EndLiveClickCallback paramEndLiveClickCallback)
  {
    if (paramActivity != null)
    {
      if (paramIQQLiveSDK == null) {
        return null;
      }
      long l;
      if (paramLiveUserInfo != null) {
        l = paramLiveUserInfo.uid;
      } else {
        l = 0L;
      }
      paramString = a(l, paramLong, paramString, paramIQQLiveSDK, paramLiveAnchorInfo, paramLiveRealTimeInfo, paramLiveRoomExtraInfo, paramInt);
      if (paramString != null) {
        return ((IQQLiveUtil)QRoute.api(IQQLiveUtil.class)).getAudienceEndLiveView((Context)paramActivity, paramIQQLiveSDK, paramString, paramEndLiveClickCallback);
      }
    }
    return null;
  }
  
  @Nullable
  public final IQQLiveEndView a(@Nullable Activity paramActivity, @Nullable IQQLiveSDK paramIQQLiveSDK, @Nullable QQLiveAnchorRoomInfo paramQQLiveAnchorRoomInfo, @Nullable LiveRealTimeInfo paramLiveRealTimeInfo, @Nullable EndLiveClickCallback paramEndLiveClickCallback)
  {
    Activity localActivity;
    if (!(paramActivity instanceof QBaseActivity)) {
      localActivity = null;
    } else {
      localActivity = paramActivity;
    }
    if ((QBaseActivity)localActivity != null)
    {
      if (paramIQQLiveSDK == null) {
        return null;
      }
      paramQQLiveAnchorRoomInfo = a(paramIQQLiveSDK, paramQQLiveAnchorRoomInfo, paramLiveRealTimeInfo);
      if (paramQQLiveAnchorRoomInfo != null) {
        return ((IQQLiveUtil)QRoute.api(IQQLiveUtil.class)).getEndLiveView((QBaseActivity)paramActivity, paramIQQLiveSDK, paramQQLiveAnchorRoomInfo, paramEndLiveClickCallback);
      }
    }
    return null;
  }
  
  public final void a(@Nullable IQQLiveSDK paramIQQLiveSDK, long paramLong, @Nullable IQQLiveCheckFollowCallback paramIQQLiveCheckFollowCallback)
  {
    if (paramIQQLiveSDK != null) {
      paramIQQLiveSDK = paramIQQLiveSDK.getFollowMsgService();
    } else {
      paramIQQLiveSDK = null;
    }
    if (paramIQQLiveSDK != null)
    {
      paramIQQLiveSDK.checkFollowAnchor(paramLong, (IQQLiveCheckFollowCallback)new LiveEndViewUtil.checkFollowStatus.1(paramIQQLiveCheckFollowCallback));
      return;
    }
    if (paramIQQLiveCheckFollowCallback != null) {
      paramIQQLiveCheckFollowCallback.a(-1, "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.live.LiveEndViewUtil
 * JD-Core Version:    0.7.0.1
 */