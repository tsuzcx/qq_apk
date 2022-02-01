package com.tencent.mobileqq.qcircle.api;

import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IQCircleIPCApi
  extends QRouteApi
{
  public static final String ACTION_CLUSTERING_LOCAL_PHOTO = "action_clustering_local_photo";
  public static final String ACTION_CLUSTERING_LOCAL_PHOTO_OPEN = "action_open_clustering_local_photo";
  public static final String MODULE_NAME = "qCircleIpcModule";
  
  public abstract QIPCModule getIPCModule();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.IQCircleIPCApi
 * JD-Core Version:    0.7.0.1
 */