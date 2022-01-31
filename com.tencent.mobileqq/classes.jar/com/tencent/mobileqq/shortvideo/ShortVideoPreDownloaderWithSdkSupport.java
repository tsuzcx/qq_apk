package com.tencent.mobileqq.shortvideo;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.FileTransferManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.mediaplayer.api.TVK_ICacheMgr;
import com.tencent.qqlive.mediaplayer.api.TVK_IProxyFactory;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ShortVideoPreDownloaderWithSdkSupport
  extends ShortVideoPreDownloader
{
  private TVK_ICacheMgr jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr;
  private TVK_IProxyFactory jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  
  public ShortVideoPreDownloaderWithSdkSupport(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  ShortVideoReq a()
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      ShortVideoReq localShortVideoReq1 = a(this.jdField_a_of_type_JavaUtilList);
      if (localShortVideoReq1 != null)
      {
        a("getShortVideoRequest", "get a short video request from AIORequests");
        return localShortVideoReq1;
      }
      synchronized (this.b)
      {
        localShortVideoReq1 = a(this.b);
        if (localShortVideoReq1 != null)
        {
          a("getShortVideoRequest", "get a short video request from C2CRequests");
          return localShortVideoReq1;
        }
      }
    }
    synchronized (this.c)
    {
      ShortVideoReq localShortVideoReq2 = a(this.c);
      if (localShortVideoReq2 != null)
      {
        a("getShortVideoRequest", "get a short video request from DiscussionRequests");
        return localShortVideoReq2;
      }
    }
    synchronized (this.d)
    {
      ShortVideoReq localShortVideoReq3 = a(this.d);
      if (localShortVideoReq3 != null)
      {
        a("getShortVideoRequest", "get a short video request from GroupRequests");
        return localShortVideoReq3;
      }
    }
    a("getShortVideoRequest", "cannot get any request");
    return null;
  }
  
  ShortVideoReq a(List paramList)
  {
    int i = paramList.size();
    if (i <= 0) {
      return null;
    }
    ShortVideoReq localShortVideoReq;
    if (TVK_SDKMgr.isInstalled(BaseApplicationImpl.getContext()))
    {
      localShortVideoReq = (ShortVideoReq)paramList.get(i - 1);
      paramList.remove(i - 1);
      a("getRequestBySDKStatus", "sdk installed");
      paramList = localShortVideoReq;
      return paramList;
    }
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      localShortVideoReq = (ShortVideoReq)localIterator.next();
      if (localShortVideoReq.a.a != 0) {
        paramList.remove(localShortVideoReq);
      }
    }
    for (paramList = localShortVideoReq;; paramList = null)
    {
      a("getRequestBySDKStatus", "get a short video request");
      break;
    }
  }
  
  protected void a(ShortVideoReq paramShortVideoReq)
  {
    super.a(paramShortVideoReq);
    if (paramShortVideoReq.a.a == 0)
    {
      FileTransferManager localFileTransferManager = FileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (localFileTransferManager != null)
      {
        paramShortVideoReq = new ShortVideoPreDownloaderWithSdkSupport.PreDownloadHandler(this, paramShortVideoReq);
        this.jdField_a_of_type_JavaUtilArrayList.add(paramShortVideoReq);
        localFileTransferManager.a(paramShortVideoReq.a, paramShortVideoReq);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ShortVideoPreDownloaderWithSdkSupport
 * JD-Core Version:    0.7.0.1
 */