package com.tencent.mobileqq.emoticonview.ipc.proxy;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.emosm.api.IEmotionSearchManagerService;
import com.tencent.mobileqq.emosm.api.IEmotionSearchManagerService.EmotionSearchTask;
import com.tencent.mobileqq.emosm.api.IEmotionSearchManagerService.IEmotionSearchCallBack;
import com.tencent.qphone.base.util.QLog;

public class EmotionSearchManagerServiceProxy
  extends AbsEmoRuntimeServiceProxy<IEmotionSearchManagerService>
{
  public static final String TAG = "EmotionSearchManagerServiceProxy";
  
  public EmotionSearchManagerServiceProxy(BaseQQAppInterface paramBaseQQAppInterface)
  {
    super(paramBaseQQAppInterface, IEmotionSearchManagerService.class);
  }
  
  public void loadMore()
  {
    if (this.manager != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmotionSearchManagerServiceProxy", 4, "do loadMore.");
      }
      ((IEmotionSearchManagerService)this.manager).loadMore();
    }
  }
  
  public void pushEmotionSearchTask(IEmotionSearchManagerService.EmotionSearchTask paramEmotionSearchTask)
  {
    if (this.manager != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmotionSearchManagerServiceProxy", 4, "do pushEmotionSearchTask.");
      }
      ((IEmotionSearchManagerService)this.manager).pushEmotionSearchTask(paramEmotionSearchTask);
    }
  }
  
  public void resetData()
  {
    if (this.manager != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmotionSearchManagerServiceProxy", 4, "do resetData.");
      }
      ((IEmotionSearchManagerService)this.manager).resetData();
    }
  }
  
  public void setSearchCallBack(IEmotionSearchManagerService.IEmotionSearchCallBack paramIEmotionSearchCallBack)
  {
    if (this.manager != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmotionSearchManagerServiceProxy", 4, "do searchCallBack.");
      }
      ((IEmotionSearchManagerService)this.manager).setSearchCallBack(paramIEmotionSearchCallBack);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.ipc.proxy.EmotionSearchManagerServiceProxy
 * JD-Core Version:    0.7.0.1
 */