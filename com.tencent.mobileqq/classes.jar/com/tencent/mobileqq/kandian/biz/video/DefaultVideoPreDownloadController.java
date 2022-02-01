package com.tencent.mobileqq.kandian.biz.video;

import com.tencent.mobileqq.kandian.base.bandwidth.VideoPreloadStrategyConoller;
import com.tencent.mobileqq.kandian.base.video.player.VideoPlayerWrapper;
import com.tencent.mobileqq.kandian.glue.video.VideoPreDownloadMgr.PreDownloadController;
import com.tencent.mobileqq.kandian.glue.video.VideoPreDownloadMgr.VideoPreDownloadParam;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public abstract class DefaultVideoPreDownloadController<T>
  implements VideoPreDownloadMgr.PreDownloadController
{
  protected abstract VideoPreDownloadMgr.VideoPreDownloadParam a(T paramT);
  
  public List<VideoPreDownloadMgr.VideoPreDownloadParam> a(int paramInt, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramInt >= 0)
    {
      List localList = d();
      int i = paramInt;
      if (e()) {
        i = paramInt - 1;
      }
      a(i, paramBoolean, localList, localArrayList);
      b(i, paramBoolean, localList, localArrayList);
    }
    return localArrayList;
  }
  
  protected void a(int paramInt, boolean paramBoolean, List<T> paramList, List<VideoPreDownloadMgr.VideoPreDownloadParam> paramList1)
  {
    int j = paramInt + 1;
    paramList1.size();
    int m = paramList.size();
    int i = 0;
    int k = 0;
    if (j < m)
    {
      m = Math.min(paramInt + VideoPreloadStrategyConoller.a().a(c(), paramInt), paramList.size() - 1);
      paramInt = k;
      for (;;)
      {
        i = paramInt;
        if (j > m) {
          break;
        }
        paramList1.add(a(paramList.get(j)));
        paramInt += 1;
        j += 1;
      }
    }
    if (QLog.isColorLevel())
    {
      paramList = new StringBuilder();
      paramList.append("scroll to next = ");
      paramList.append(paramBoolean);
      paramList.append(" preDownload to forward = ");
      paramList.append(i);
      QLog.d("DefaultVideoPreDownloadController", 2, paramList.toString());
    }
  }
  
  public boolean a()
  {
    return VideoPreloadStrategyConoller.a().a(b());
  }
  
  protected abstract VideoPlayerWrapper b();
  
  protected void b(int paramInt, boolean paramBoolean, List<T> paramList, List<VideoPreDownloadMgr.VideoPreDownloadParam> paramList1)
  {
    int j = paramInt - 1;
    paramList1.size();
    int m = 0;
    int k = 0;
    int i = m;
    if (j >= 0)
    {
      i = m;
      if (j < paramList.size())
      {
        m = Math.max(paramInt - VideoPreloadStrategyConoller.a().b(), 0);
        paramInt = k;
        for (;;)
        {
          i = paramInt;
          if (j < m) {
            break;
          }
          paramList1.add(a(paramList.get(j)));
          paramInt += 1;
          j -= 1;
        }
      }
    }
    if (QLog.isColorLevel())
    {
      paramList = new StringBuilder();
      paramList.append("scroll to next = ");
      paramList.append(paramBoolean);
      paramList.append(" preDownload to backward = ");
      paramList.append(i);
      QLog.d("DefaultVideoPreDownloadController", 2, paramList.toString());
    }
  }
  
  protected abstract String c();
  
  protected abstract List<T> d();
  
  public boolean e()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.DefaultVideoPreDownloadController
 * JD-Core Version:    0.7.0.1
 */