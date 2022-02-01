package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.util.SparseArray;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.video.playfeeds.GameAdComData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdvertisementSoftInfo;
import com.tencent.mobileqq.kandian.ad.api.IRIJVideoAdService;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.UGDownloadInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo.ECommerceEntranceInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo.TopBarInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.viewholder.BaseVideoItemHolder;
import com.tencent.mobileqq.kandian.repo.video.entity.VideoColumnInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.ObjectRef;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/playfeeds/VideoFeedsDiversionHandler;", "", "()V", "columnBarPriority", "", "gameAdPriority", "goodsSoftAdPriority", "normalSoftAdPriority", "shuntBarPriority", "strongShuntBarPriority", "topbarPriority", "ugBarPriority", "clearFooterDiversion", "", "videoInfo", "Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/entity/VideoInfo;", "clearHeaderDiversion", "handleDiversionPriority", "holder", "Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/viewholder/BaseVideoItemHolder;", "isSoftAdWhiteList", "", "sourceId", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class VideoFeedsDiversionHandler
{
  public static final VideoFeedsDiversionHandler a = new VideoFeedsDiversionHandler();
  private static final int b;
  private static final int c;
  private static final int d;
  private static final int e;
  private static final int f;
  private static final int g;
  private static final int h;
  private static final int i;
  
  static
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(362);
    b = localAladdinConfig.getIntegerFromString("up_kol_goods_soft_ad", 0);
    c = localAladdinConfig.getIntegerFromString("up_kd_shunt_bar", 1);
    d = localAladdinConfig.getIntegerFromString("up_topbar", 2);
    e = localAladdinConfig.getIntegerFromString("up_not_kol_soft_ad", 3);
    f = localAladdinConfig.getIntegerFromString("up_game_ad", 4);
    g = localAladdinConfig.getIntegerFromString("ug_bar", 5);
    h = localAladdinConfig.getIntegerFromString("bigBubble", 0);
    i = localAladdinConfig.getIntegerFromString("column_bar", 1);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("config=");
      localStringBuilder.append(localAladdinConfig);
      localStringBuilder.append(' ');
      QLog.d("VideoFeedsDiversionHandler", 2, localStringBuilder.toString());
    }
  }
  
  private final boolean a(int paramInt)
  {
    Object localObject = Aladdin.getConfig(407).getString("soft_ad_source_id_list", "3,7,8,9");
    Intrinsics.checkExpressionValueIsNotNull(localObject, "config.getString(\"soft_a…ource_id_list\",\"3,7,8,9\")");
    localObject = StringsKt.split$default((CharSequence)localObject, new String[] { "," }, false, 0, 6, null);
    try
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        int j = Integer.parseInt((String)((Iterator)localObject).next());
        if (j == paramInt) {
          return true;
        }
      }
      return false;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return false;
  }
  
  private final void b(VideoInfo paramVideoInfo)
  {
    Object localObject = ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(paramVideoInfo);
    if (localObject != null) {
      ((AdvertisementInfo)localObject).mAdvertisementSoftInfo = ((AdvertisementSoftInfo)null);
    }
    if (localObject != null) {
      ((AdvertisementInfo)localObject).gameAdComData = ((GameAdComData)null);
    }
    ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).setAdvertisementInfo(paramVideoInfo, null);
    paramVideoInfo.aD = ((VideoInfo.TopBarInfo)null);
    localObject = paramVideoInfo.aG;
    if ((localObject != null) && (((VideoInfo.ECommerceEntranceInfo)localObject).o == 0)) {
      paramVideoInfo.aG = ((VideoInfo.ECommerceEntranceInfo)null);
    }
    localObject = (UGDownloadInfo)null;
    paramVideoInfo.az = ((UGDownloadInfo)localObject);
    paramVideoInfo.aA = ((UGDownloadInfo)localObject);
  }
  
  private final void c(VideoInfo paramVideoInfo)
  {
    VideoInfo.ECommerceEntranceInfo localECommerceEntranceInfo = paramVideoInfo.aG;
    if ((localECommerceEntranceInfo != null) && (localECommerceEntranceInfo.o == 1)) {
      paramVideoInfo.aG = ((VideoInfo.ECommerceEntranceInfo)null);
    }
    paramVideoInfo.ay = ((VideoColumnInfo)null);
  }
  
  public final void a(@NotNull VideoInfo paramVideoInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "videoInfo");
    if (!ReadInJoyHelper.b()) {
      return;
    }
    SparseArray localSparseArray = new SparseArray();
    Ref.ObjectRef localObjectRef = new Ref.ObjectRef();
    localObjectRef.element = ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(paramVideoInfo);
    Object localObject;
    if ((AdvertisementInfo)localObjectRef.element != null) {
      if (((AdvertisementInfo)localObjectRef.element).mAdvertisementSoftInfo != null)
      {
        int j;
        if (a(((AdvertisementInfo)localObjectRef.element).mAdvertisementSoftInfo.o)) {
          j = b;
        } else {
          j = e;
        }
        localSparseArray.put(j, new VideoFeedsDiversionHandler.handleDiversionPriority.2(localObjectRef, paramVideoInfo));
      }
      else
      {
        localObject = (AdvertisementInfo)localObjectRef.element;
        if (localObject != null) {
          localObject = ((AdvertisementInfo)localObject).gameAdComData;
        } else {
          localObject = null;
        }
        if (localObject != null) {
          localSparseArray.put(f, new VideoFeedsDiversionHandler.handleDiversionPriority.3(localObjectRef, paramVideoInfo));
        }
      }
    }
    if ((paramVideoInfo.aG != null) && (paramVideoInfo.aG.o == 0)) {
      localSparseArray.put(c, new VideoFeedsDiversionHandler.handleDiversionPriority.4(paramVideoInfo));
    }
    if ((paramVideoInfo.az != null) || (paramVideoInfo.aA != null)) {
      localSparseArray.put(g, new VideoFeedsDiversionHandler.handleDiversionPriority.5(paramVideoInfo));
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleHeaderDiversionPriority: videoInfo.title=");
      ((StringBuilder)localObject).append(paramVideoInfo.g);
      ((StringBuilder)localObject).append(", array=");
      ((StringBuilder)localObject).append(localSparseArray);
      QLog.d("VideoFeedsDiversionHandler", 2, ((StringBuilder)localObject).toString());
    }
    if (localSparseArray.size() > 0)
    {
      localObject = (Function0)localSparseArray.get(localSparseArray.keyAt(0));
      if (localObject != null) {
        localObject = (Unit)((Function0)localObject).invoke();
      }
    }
    localSparseArray.clear();
    if ((paramVideoInfo.aG != null) && (paramVideoInfo.aG.o == 1)) {
      localSparseArray.put(h, new VideoFeedsDiversionHandler.handleDiversionPriority.6(paramVideoInfo));
    }
    if (paramVideoInfo.ay != null) {
      localSparseArray.put(i, new VideoFeedsDiversionHandler.handleDiversionPriority.7(paramVideoInfo));
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleBottomDiversionPriority: videoInfo.title=");
      ((StringBuilder)localObject).append(paramVideoInfo.g);
      ((StringBuilder)localObject).append(", array=");
      ((StringBuilder)localObject).append(localSparseArray);
      QLog.d("VideoFeedsDiversionHandler", 2, ((StringBuilder)localObject).toString());
    }
    if (localSparseArray.size() > 0)
    {
      paramVideoInfo = (Function0)localSparseArray.get(localSparseArray.keyAt(0));
      if (paramVideoInfo != null) {
        paramVideoInfo = (Unit)paramVideoInfo.invoke();
      }
    }
  }
  
  public final void a(@NotNull BaseVideoItemHolder paramBaseVideoItemHolder)
  {
    Intrinsics.checkParameterIsNotNull(paramBaseVideoItemHolder, "holder");
    paramBaseVideoItemHolder = paramBaseVideoItemHolder.az;
    if (paramBaseVideoItemHolder != null)
    {
      paramBaseVideoItemHolder = paramBaseVideoItemHolder.c;
      if ((paramBaseVideoItemHolder != null) && ((paramBaseVideoItemHolder instanceof VideoInfo))) {
        a.a(paramBaseVideoItemHolder);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsDiversionHandler
 * JD-Core Version:    0.7.0.1
 */