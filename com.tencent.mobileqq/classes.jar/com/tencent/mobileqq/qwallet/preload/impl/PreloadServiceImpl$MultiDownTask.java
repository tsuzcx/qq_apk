package com.tencent.mobileqq.qwallet.preload.impl;

import com.tencent.mobileqq.qwallet.preload.DownloadParam;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.OnGetPathsListener;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.PathResult;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

class PreloadServiceImpl$MultiDownTask
{
  int jdField_a_of_type_Int = 0;
  IPreloadService.OnGetPathsListener jdField_a_of_type_ComTencentMobileqqQwalletPreloadIPreloadService$OnGetPathsListener;
  HashMap<String, IPreloadService.PathResult> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  List<DownloadParam> jdField_a_of_type_JavaUtilList;
  boolean jdField_a_of_type_Boolean = false;
  
  public PreloadServiceImpl$MultiDownTask(List<DownloadParam> paramList, IPreloadService.OnGetPathsListener paramOnGetPathsListener)
  {
    this.jdField_a_of_type_JavaUtilList = paramOnGetPathsListener;
    Object localObject;
    this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadIPreloadService$OnGetPathsListener = localObject;
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      DownloadParam localDownloadParam = (DownloadParam)localIterator.next();
      this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplPreloadServiceImpl.getResPath(localDownloadParam, new PreloadServiceImpl.MultiDownTask.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.preload.impl.PreloadServiceImpl.MultiDownTask
 * JD-Core Version:    0.7.0.1
 */