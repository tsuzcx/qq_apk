package com.tencent.mobileqq.qwallet.preload.impl;

import com.tencent.mobileqq.qwallet.preload.DownloadParam;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.OnGetPathsListener;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.PathResult;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

class PreloadServiceImpl$MultiDownTask
{
  List<DownloadParam> a;
  IPreloadService.OnGetPathsListener b;
  HashMap<String, IPreloadService.PathResult> c = new HashMap();
  boolean d = false;
  int e = 0;
  
  public PreloadServiceImpl$MultiDownTask(List<DownloadParam> paramList, IPreloadService.OnGetPathsListener paramOnGetPathsListener)
  {
    this.a = paramOnGetPathsListener;
    Object localObject;
    this.b = localObject;
  }
  
  public void a()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      DownloadParam localDownloadParam = (DownloadParam)localIterator.next();
      this.f.getResPath(localDownloadParam, new PreloadServiceImpl.MultiDownTask.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.preload.impl.PreloadServiceImpl.MultiDownTask
 * JD-Core Version:    0.7.0.1
 */