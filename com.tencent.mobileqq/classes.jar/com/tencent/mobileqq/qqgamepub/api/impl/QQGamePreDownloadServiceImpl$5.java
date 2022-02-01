package com.tencent.mobileqq.qqgamepub.api.impl;

import android.text.TextUtils;
import com.tencent.commonsdk.util.MD5Coding;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qqgamepub.api.IQQGameResService;
import com.tencent.mobileqq.qqgamepub.data.DownloadParam;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

class QQGamePreDownloadServiceImpl$5
  extends DownloadListener
{
  QQGamePreDownloadServiceImpl$5(QQGamePreDownloadServiceImpl paramQQGamePreDownloadServiceImpl, DownloadParam paramDownloadParam, String paramString) {}
  
  public void onDoneFile(DownloadTask paramDownloadTask)
  {
    super.onDoneFile(paramDownloadTask);
    if ((paramDownloadTask != null) && (paramDownloadTask.g != null) && (!TextUtils.isEmpty(paramDownloadTask.b)))
    {
      Object localObject = (File)paramDownloadTask.g.get(paramDownloadTask.b);
      if ((localObject != null) && (((File)localObject).exists())) {
        try
        {
          JSONArray localJSONArray = new JSONObject(FileUtils.readFileContent((File)localObject)).optJSONObject("preload").optJSONArray("bids");
          this.c.preloadH5Res(localJSONArray);
          localObject = MD5Coding.encodeFile2HexStr(((File)localObject).getAbsolutePath());
          ((IQQGameResService)QRoute.api(IQQGameResService.class)).updateResInfo(paramDownloadTask.b, (String)localObject, NetConnInfoCenter.getServerTimeMillis(), this.a.filePos);
        }
        catch (Exception localException)
        {
          QLog.e("QQGamePub_QQGamePreDownloadServiceImpl", 1, localException, new Object[0]);
        }
      }
    }
    if (paramDownloadTask != null) {
      QQGamePreDownloadServiceImpl.reportSceneDownloadResult(this.b, paramDownloadTask.c, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.api.impl.QQGamePreDownloadServiceImpl.5
 * JD-Core Version:    0.7.0.1
 */