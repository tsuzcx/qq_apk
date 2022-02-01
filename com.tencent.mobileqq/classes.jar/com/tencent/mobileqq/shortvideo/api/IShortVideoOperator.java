package com.tencent.mobileqq.shortvideo.api;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.shortvideo.ShortVideoForwardInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoReq;
import com.tencent.mobileqq.shortvideo.ShortVideoUploadInfo;
import com.tencent.mobileqq.shortvideo.UiCallBack;
import java.util.ArrayList;

public abstract interface IShortVideoOperator
{
  public abstract MessageRecord a(ShortVideoForwardInfo paramShortVideoForwardInfo);
  
  public abstract MessageRecord a(ShortVideoUploadInfo paramShortVideoUploadInfo);
  
  public abstract ShortVideoUploadInfo a(Object paramObject, ShortVideoReq paramShortVideoReq);
  
  public abstract void a(BaseQQAppInterface paramBaseQQAppInterface);
  
  public abstract void a(MessageRecord paramMessageRecord);
  
  public abstract void a(ShortVideoReq paramShortVideoReq);
  
  public abstract void a(UiCallBack paramUiCallBack);
  
  public abstract void a(String paramString);
  
  public abstract void a(ArrayList<ShortVideoForwardInfo> paramArrayList);
  
  public abstract ShortVideoForwardInfo b(Object paramObject, ShortVideoReq paramShortVideoReq);
  
  public abstract void b(ShortVideoForwardInfo paramShortVideoForwardInfo);
  
  public abstract void b(ShortVideoUploadInfo paramShortVideoUploadInfo);
  
  public abstract void b(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.api.IShortVideoOperator
 * JD-Core Version:    0.7.0.1
 */