package com.tencent.mobileqq.listentogether.predownload;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;
import com.tencent.mobileqq.listentogether.data.MusicInfo;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.NetResp;
import java.util.HashMap;

class ListenTogetherResDownloader$2$1
  implements Runnable
{
  ListenTogetherResDownloader$2$1(ListenTogetherResDownloader.2 param2, NetResp paramNetResp, boolean paramBoolean, MusicInfo paramMusicInfo) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("errCode", String.valueOf(this.a.mErrCode));
    localHashMap.put("result", String.valueOf(this.a.mResult));
    StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance("", "listen_together_download_quality", this.b, 0L, 0L, localHashMap, "", false);
    ((ListenTogetherManager)ListenTogetherResDownloader.a(this.d.a).getManager(QQManagerFactory.LISTEN_TOGETHER_MANAGER)).a(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.predownload.ListenTogetherResDownloader.2.1
 * JD-Core Version:    0.7.0.1
 */