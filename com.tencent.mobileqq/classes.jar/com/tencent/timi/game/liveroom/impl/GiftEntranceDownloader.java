package com.tencent.timi.game.liveroom.impl;

import com.tencent.timi.game.sp.TGSharedPreferenceUtil;
import com.tencent.timi.game.utils.Logger;
import com.yolo.esports.download.common.DownloadInfo;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/liveroom/impl/GiftEntranceDownloader;", "", "()V", "GIFT_ENTRANCE_URL", "", "KEY_GIFT_ENTRANCE", "TAG", "downloadTaskListener", "com/tencent/timi/game/liveroom/impl/GiftEntranceDownloader$downloadTaskListener$1", "Lcom/tencent/timi/game/liveroom/impl/GiftEntranceDownloader$downloadTaskListener$1;", "giftEntrancePAGDownloadListenerList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/tencent/timi/game/liveroom/impl/GiftEntranceDownloader$IGiftEntrancePAGDownloadListener;", "addGiftEntrancePAGDownloadListener", "", "listener", "downloadGiftEntrancePAG", "getGiftEntrancePAGPath", "getGiftEntrancePAGSavePath", "handleDownloadComplete", "taskInfo", "Lcom/yolo/esports/download/common/DownloadInfo;", "removeGiftEntrancePAGDownloadListener", "saveGiftEntrancePAGPath", "path", "IGiftEntrancePAGDownloadListener", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class GiftEntranceDownloader
{
  public static final GiftEntranceDownloader a = new GiftEntranceDownloader();
  private static final CopyOnWriteArrayList<GiftEntranceDownloader.IGiftEntrancePAGDownloadListener> b = new CopyOnWriteArrayList();
  private static final GiftEntranceDownloader.downloadTaskListener.1 c = new GiftEntranceDownloader.downloadTaskListener.1();
  
  private final void a(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo != null)
    {
      if (paramDownloadInfo.c() != true) {
        return;
      }
      paramDownloadInfo = paramDownloadInfo.e;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("pag abs file path: ");
      localStringBuilder.append(paramDownloadInfo);
      Logger.b("GiftEntranceDownloader", localStringBuilder.toString());
      Intrinsics.checkExpressionValueIsNotNull(paramDownloadInfo, "absPath");
      a(paramDownloadInfo);
      paramDownloadInfo = ((Iterable)b).iterator();
      while (paramDownloadInfo.hasNext()) {
        ((GiftEntranceDownloader.IGiftEntrancePAGDownloadListener)paramDownloadInfo.next()).a();
      }
    }
  }
  
  private final void a(String paramString)
  {
    TGSharedPreferenceUtil.a("tag_gift_entrance_1", paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.GiftEntranceDownloader
 * JD-Core Version:    0.7.0.1
 */