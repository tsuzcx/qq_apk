package com.tencent.mobileqq.emosm.api.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.VipComicFavorEmoStructMsgInfo;
import com.tencent.mobileqq.emosm.api.IFavroamingDBManagerService;
import com.tencent.mobileqq.emosm.favroaming.IPicDownloadListener;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

class VipComicMqqManagerServiceImpl$1
  extends DownloadListener
{
  VipComicMqqManagerServiceImpl$1(VipComicMqqManagerServiceImpl paramVipComicMqqManagerServiceImpl, File paramFile, CustomEmotionData paramCustomEmotionData, IFavroamingDBManagerService paramIFavroamingDBManagerService, List paramList1, IPicDownloadListener paramIPicDownloadListener, List paramList2, EntityManager paramEntityManager, VipComicFavorEmoStructMsgInfo paramVipComicFavorEmoStructMsgInfo, AtomicInteger paramAtomicInteger1, AtomicInteger paramAtomicInteger2) {}
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    super.onDone(paramDownloadTask);
    if ((paramDownloadTask.e() == 3) && (paramDownloadTask.c == 0) && (this.a.exists()))
    {
      this.b.emoPath = this.a.getAbsolutePath();
      if ("needDownload".equals(this.b.RomaingType)) {
        this.b.RomaingType = "isUpdate";
      }
      if ((QLog.isColorLevel()) && (!TextUtils.isEmpty(this.b.emoPath)))
      {
        paramDownloadTask = SecUtil.getFileMd5(this.b.emoPath);
        if (!this.b.md5.equals(paramDownloadTask))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("init = ");
          localStringBuilder.append(this.b.md5);
          localStringBuilder.append(" , compute = ");
          localStringBuilder.append(paramDownloadTask);
          QLog.i("VipComicMqqManager", 2, localStringBuilder.toString());
        }
      }
      this.c.updateCustomEmotion(this.b);
      this.d.add(this.b);
      VipComicMqqManagerServiceImpl.access$000(this.k, this.e, this.b, true);
    }
    else
    {
      this.f.add(this.b);
      this.c.deleteCustomEmotion(this.b);
      this.g.remove(this.h);
      VipComicMqqManagerServiceImpl.access$000(this.k, this.e, this.b, false);
    }
    this.i.getAndIncrement();
    if (this.i.get() == this.j.get())
    {
      paramDownloadTask = this.e;
      if (paramDownloadTask != null) {
        paramDownloadTask.onDone(this.d, this.f);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.api.impl.VipComicMqqManagerServiceImpl.1
 * JD-Core Version:    0.7.0.1
 */