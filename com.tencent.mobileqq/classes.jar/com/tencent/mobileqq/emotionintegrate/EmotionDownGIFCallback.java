package com.tencent.mobileqq.emotionintegrate;

import android.os.Handler;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.pic.DownCallBack;
import com.tencent.mobileqq.pic.DownCallBack.DownResult;
import com.tencent.mobileqq.pic.PicInfoInterface.ErrInfo;
import com.tencent.mobileqq.pic.PicResult;
import com.tencent.mobileqq.pic.UiCallBack;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.util.WeakReference;

public class EmotionDownGIFCallback
  implements DownCallBack, UiCallBack
{
  private Handler a;
  private MessageForPic b;
  private WeakReference<EmotionDownGIFCallback.UiCallback> c;
  
  public EmotionDownGIFCallback(MessageForPic paramMessageForPic, Handler paramHandler, EmotionDownGIFCallback.UiCallback paramUiCallback)
  {
    this.b = paramMessageForPic;
    this.a = paramHandler;
    this.c = new WeakReference(paramUiCallback);
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt, PicResult paramPicResult)
  {
    if (this.c.get() == null)
    {
      QLog.d("EmotionDownGIFCallback", 1, "onDownload fail, callback is null");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("EmotionDownGIFCallback", 2, new Object[] { "onDownload ", Integer.valueOf(paramPicResult.a) });
    }
    if (paramPicResult.a == 0)
    {
      ((EmotionDownGIFCallback.UiCallback)this.c.get()).a(true, this.b);
      return;
    }
    if (-1 == paramPicResult.a)
    {
      if (paramPicResult.b != null) {
        QLog.d("EmotionDownGIFCallback", 1, new Object[] { "onDownloadFail errDec:", paramPicResult.b.b });
      }
      ((EmotionDownGIFCallback.UiCallback)this.c.get()).a(false, this.b);
    }
  }
  
  public void a(int paramInt, ArrayList<PicResult> paramArrayList) {}
  
  public void a(int paramInt, boolean paramBoolean)
  {
    this.a.post(new EmotionDownGIFCallback.2(this, paramInt));
  }
  
  public void a(DownCallBack.DownResult paramDownResult)
  {
    this.a.post(new EmotionDownGIFCallback.1(this, paramDownResult));
  }
  
  public void a_(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" needRefresh:");
      localStringBuilder.append(paramBoolean);
      QLog.d("EmotionDownGIFCallback", 2, new Object[] { "onUpdateProgress:", localStringBuilder.toString(), " picMr:", Long.valueOf(this.b.uniseq) });
    }
    if (this.c.get() != null) {
      ((EmotionDownGIFCallback.UiCallback)this.c.get()).a(paramInt, this.b);
    }
  }
  
  public void b(int paramInt, PicResult paramPicResult) {}
  
  public void c(int paramInt, PicResult paramPicResult) {}
  
  public void d(int paramInt, PicResult paramPicResult) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emotionintegrate.EmotionDownGIFCallback
 * JD-Core Version:    0.7.0.1
 */