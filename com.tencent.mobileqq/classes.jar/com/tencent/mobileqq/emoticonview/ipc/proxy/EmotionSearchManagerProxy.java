package com.tencent.mobileqq.emoticonview.ipc.proxy;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.emosm.emosearch.EmotionSearchManager;
import com.tencent.mobileqq.emosm.emosearch.EmotionSearchManager.EmotionSearchTask;
import com.tencent.mobileqq.emosm.emosearch.EmotionSearchManager.IEmotionSearchCallBack;
import com.tencent.qphone.base.util.QLog;

public class EmotionSearchManagerProxy
  extends AbsManagerProxy<EmotionSearchManager>
{
  public static final String TAG = "EmotionSearchManagerProxy";
  
  public EmotionSearchManagerProxy(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface, QQManagerFactory.EMOTION_SEARCH_MANAGER);
  }
  
  public void loadMore()
  {
    if (this.manager != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmotionSearchManagerProxy", 4, "do loadMore.");
      }
      ((EmotionSearchManager)this.manager).a();
    }
  }
  
  public void pushEmotionSearchTask(EmotionSearchManager.EmotionSearchTask paramEmotionSearchTask)
  {
    if (this.manager != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmotionSearchManagerProxy", 4, "do pushEmotionSearchTask.");
      }
      ((EmotionSearchManager)this.manager).a(paramEmotionSearchTask);
    }
  }
  
  public void resetData()
  {
    if (this.manager != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmotionSearchManagerProxy", 4, "do resetData.");
      }
      ((EmotionSearchManager)this.manager).b();
    }
  }
  
  public void setSearchCallBack(EmotionSearchManager.IEmotionSearchCallBack paramIEmotionSearchCallBack)
  {
    if (this.manager != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmotionSearchManagerProxy", 4, "do searchCallBack.");
      }
      ((EmotionSearchManager)this.manager).a(paramIEmotionSearchCallBack);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.ipc.proxy.EmotionSearchManagerProxy
 * JD-Core Version:    0.7.0.1
 */