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
  private Handler jdField_a_of_type_AndroidOsHandler;
  private MessageForPic jdField_a_of_type_ComTencentMobileqqDataMessageForPic;
  private WeakReference<EmotionDownGIFCallback.UiCallback> jdField_a_of_type_MqqUtilWeakReference;
  
  public EmotionDownGIFCallback(MessageForPic paramMessageForPic, Handler paramHandler, EmotionDownGIFCallback.UiCallback paramUiCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic = paramMessageForPic;
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramUiCallback);
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt, PicResult paramPicResult)
  {
    if (this.jdField_a_of_type_MqqUtilWeakReference.get() == null) {
      QLog.d("EmotionDownGIFCallback", 1, "onDownload fail, callback is null");
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("EmotionDownGIFCallback", 2, new Object[] { "onDownload ", Integer.valueOf(paramPicResult.jdField_a_of_type_Int) });
      }
      if (paramPicResult.jdField_a_of_type_Int == 0)
      {
        ((EmotionDownGIFCallback.UiCallback)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(true, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic);
        return;
      }
    } while (-1 != paramPicResult.jdField_a_of_type_Int);
    if (paramPicResult.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo != null) {
      QLog.d("EmotionDownGIFCallback", 1, new Object[] { "onDownloadFail errDec:", paramPicResult.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo.b });
    }
    ((EmotionDownGIFCallback.UiCallback)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(false, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic);
  }
  
  public void a(int paramInt, ArrayList<PicResult> paramArrayList) {}
  
  public void a(int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new EmotionDownGIFCallback.2(this, paramInt));
  }
  
  public void a(DownCallBack.DownResult paramDownResult)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new EmotionDownGIFCallback.1(this, paramDownResult));
  }
  
  public void a_(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionDownGIFCallback", 2, new Object[] { "onUpdateProgress:", paramInt + " needRefresh:" + paramBoolean, " picMr:", Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.uniseq) });
    }
    if (this.jdField_a_of_type_MqqUtilWeakReference.get() != null) {
      ((EmotionDownGIFCallback.UiCallback)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(paramInt, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic);
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