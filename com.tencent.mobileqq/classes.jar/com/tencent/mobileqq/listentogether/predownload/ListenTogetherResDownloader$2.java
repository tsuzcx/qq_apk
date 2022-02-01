package com.tencent.mobileqq.listentogether.predownload;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.listentogether.data.MusicInfo;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.os.MqqHandler;

class ListenTogetherResDownloader$2
  implements INetEngineListener
{
  ListenTogetherResDownloader$2(ListenTogetherResDownloader paramListenTogetherResDownloader) {}
  
  public void onResp(NetResp paramNetResp)
  {
    boolean bool;
    if (paramNetResp.mResult == 0) {
      bool = true;
    } else {
      bool = false;
    }
    Object localObject1 = (HttpNetReq)paramNetResp.mReq;
    File localFile = new File(((HttpNetReq)localObject1).mOutPath);
    int i = paramNetResp.mErrCode;
    String str;
    if (paramNetResp.mErrDesc == null) {
      str = "0";
    } else {
      str = paramNetResp.mErrDesc;
    }
    Object localObject2 = (Object[])((HttpNetReq)localObject1).getUserData();
    localObject1 = (MusicInfo)localObject2[0];
    localObject2 = (ListenTogetherResDownloader.MusicReqInfo)localObject2[1];
    if (bool)
    {
      ((ListenTogetherResDownloader.MusicReqInfo)localObject2).a = 2;
      this.a.a(((MusicInfo)localObject1).a);
    }
    else
    {
      if (localFile.exists()) {
        localFile.delete();
      }
      ((ListenTogetherResDownloader.MusicReqInfo)localObject2).a = 3;
      ListenTogetherResDownloader.a(this.a, (MusicInfo)localObject1);
    }
    ThreadManager.getSubThreadHandler().post(new ListenTogetherResDownloader.2.1(this, paramNetResp, bool, (MusicInfo)localObject1));
    if (QLog.isColorLevel()) {
      QLog.d("ListenTogether.downloader", 2, String.format("onResp, errCode: %s, errDesc: %s, musicReqInfo: %s", new Object[] { Integer.valueOf(i), str, localObject2 }));
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.predownload.ListenTogetherResDownloader.2
 * JD-Core Version:    0.7.0.1
 */