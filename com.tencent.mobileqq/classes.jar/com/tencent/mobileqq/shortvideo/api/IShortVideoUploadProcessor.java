package com.tencent.mobileqq.shortvideo.api;

import com.tencent.mobileqq.qroute.QRouteApi;

public abstract interface IShortVideoUploadProcessor
  extends QRouteApi
{
  public static final int SWITCH_DEFAULT = 1;
  public static final int SWITCH_PRE_UPLOAD = 3;
  public static final int SWITCH_REQ_AVOID = 2;
  
  public abstract boolean isBDHSuccess();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.api.IShortVideoUploadProcessor
 * JD-Core Version:    0.7.0.1
 */