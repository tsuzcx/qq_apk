package com.tencent.mobileqq.editor.composite.step;

import android.graphics.Bitmap;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.mobileqq.videocodec.mediacodec.recorder.HWEncodeListener;
import com.tencent.mobileqq.videocodec.mediacodec.recorder.HWVideoRecorder;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class MuiltiImageToVideo$1
  implements HWEncodeListener
{
  public long a;
  
  MuiltiImageToVideo$1(MuiltiImageToVideo paramMuiltiImageToVideo, List paramList, VideoStoryPicToVideo.ConvertListener paramConvertListener, VideoStoryPicToVideo.RetCode paramRetCode) {}
  
  private boolean a()
  {
    int i;
    if (MuiltiImageToVideo.a(this.jdField_a_of_type_ComTencentMobileqqEditorCompositeStepMuiltiImageToVideo).size() == 1)
    {
      i = 0;
    }
    else
    {
      int j = (int)(MuiltiImageToVideo.a(this.jdField_a_of_type_ComTencentMobileqqEditorCompositeStepMuiltiImageToVideo) / (Long.valueOf("2").longValue() * 1000L * 1000000L));
      i = j;
      if (j >= MuiltiImageToVideo.a(this.jdField_a_of_type_ComTencentMobileqqEditorCompositeStepMuiltiImageToVideo).size()) {
        return false;
      }
    }
    long l = MuiltiImageToVideo.c(this.jdField_a_of_type_ComTencentMobileqqEditorCompositeStepMuiltiImageToVideo) * 1000000;
    if ((MuiltiImageToVideo.a(this.jdField_a_of_type_ComTencentMobileqqEditorCompositeStepMuiltiImageToVideo) != null) && (((Integer)MuiltiImageToVideo.a(this.jdField_a_of_type_ComTencentMobileqqEditorCompositeStepMuiltiImageToVideo).get(i)).intValue() > 0) && (MuiltiImageToVideo.a(this.jdField_a_of_type_ComTencentMobileqqEditorCompositeStepMuiltiImageToVideo) < MuiltiImageToVideo.b(this.jdField_a_of_type_ComTencentMobileqqEditorCompositeStepMuiltiImageToVideo) * 1000000L))
    {
      MuiltiImageToVideo.a(this.jdField_a_of_type_ComTencentMobileqqEditorCompositeStepMuiltiImageToVideo).a(3553, ((Integer)MuiltiImageToVideo.a(this.jdField_a_of_type_ComTencentMobileqqEditorCompositeStepMuiltiImageToVideo).get(0)).intValue(), null, null, MuiltiImageToVideo.a(this.jdField_a_of_type_ComTencentMobileqqEditorCompositeStepMuiltiImageToVideo));
      MuiltiImageToVideo localMuiltiImageToVideo = this.jdField_a_of_type_ComTencentMobileqqEditorCompositeStepMuiltiImageToVideo;
      MuiltiImageToVideo.a(localMuiltiImageToVideo, MuiltiImageToVideo.a(localMuiltiImageToVideo) + l);
      return true;
    }
    return false;
  }
  
  public void onEncodeError(int paramInt, Throwable paramThrowable)
  {
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("onEncodeError, code:");
      ((StringBuilder)???).append(paramInt);
      QLog.e("MuiltiImageToVideo", 2, ((StringBuilder)???).toString());
    }
    synchronized (this.jdField_a_of_type_ComTencentMobileqqEditorCompositeStepMuiltiImageToVideo)
    {
      this.jdField_a_of_type_ComTencentMobileqqEditorCompositeStepMuiltiImageToVideo.notifyAll();
      if (this.jdField_a_of_type_ComTencentMobileqqEditorCompositeStepVideoStoryPicToVideo$ConvertListener != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqEditorCompositeStepVideoStoryPicToVideo$RetCode.a(paramThrowable.getMessage());
        this.jdField_a_of_type_ComTencentMobileqqEditorCompositeStepVideoStoryPicToVideo$RetCode.a(943001);
        this.jdField_a_of_type_ComTencentMobileqqEditorCompositeStepVideoStoryPicToVideo$ConvertListener.b(this.jdField_a_of_type_ComTencentMobileqqEditorCompositeStepVideoStoryPicToVideo$RetCode);
      }
      return;
    }
  }
  
  public void onEncodeFinish(String arg1)
  {
    long l = System.currentTimeMillis();
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ???.append("onEncodeStart encode cost: ");
      ???.append(l - this.jdField_a_of_type_Long);
      ???.append(" ms mGpuBlur:");
      ???.append(MuiltiImageToVideo.a(this.jdField_a_of_type_ComTencentMobileqqEditorCompositeStepMuiltiImageToVideo));
      QLog.d("MuiltiImageToVideo", 2, ???.toString());
    }
    ??? = this.jdField_a_of_type_ComTencentMobileqqEditorCompositeStepVideoStoryPicToVideo$ConvertListener;
    if (??? != null) {
      ???.a(this.jdField_a_of_type_ComTencentMobileqqEditorCompositeStepVideoStoryPicToVideo$RetCode);
    }
    if (MuiltiImageToVideo.a(this.jdField_a_of_type_ComTencentMobileqqEditorCompositeStepMuiltiImageToVideo) != null)
    {
      MuiltiImageToVideo.a(this.jdField_a_of_type_ComTencentMobileqqEditorCompositeStepMuiltiImageToVideo).surfaceDestroyed();
      MuiltiImageToVideo.a(this.jdField_a_of_type_ComTencentMobileqqEditorCompositeStepMuiltiImageToVideo, null);
    }
    if (MuiltiImageToVideo.a(this.jdField_a_of_type_ComTencentMobileqqEditorCompositeStepMuiltiImageToVideo) != null)
    {
      MuiltiImageToVideo.a(this.jdField_a_of_type_ComTencentMobileqqEditorCompositeStepMuiltiImageToVideo).c();
      MuiltiImageToVideo.a(this.jdField_a_of_type_ComTencentMobileqqEditorCompositeStepMuiltiImageToVideo, null);
    }
    if (MuiltiImageToVideo.a(this.jdField_a_of_type_ComTencentMobileqqEditorCompositeStepMuiltiImageToVideo) != null) {
      MuiltiImageToVideo.a(this.jdField_a_of_type_ComTencentMobileqqEditorCompositeStepMuiltiImageToVideo).clear();
    }
    synchronized (this.jdField_a_of_type_ComTencentMobileqqEditorCompositeStepMuiltiImageToVideo)
    {
      this.jdField_a_of_type_ComTencentMobileqqEditorCompositeStepMuiltiImageToVideo.notifyAll();
      return;
    }
  }
  
  public void onEncodeFrame()
  {
    QLog.d("MuiltiImageToVideo", 2, "onEncodeFrame() ");
    if ((!a()) && (MuiltiImageToVideo.a(this.jdField_a_of_type_ComTencentMobileqqEditorCompositeStepMuiltiImageToVideo) != null)) {
      MuiltiImageToVideo.a(this.jdField_a_of_type_ComTencentMobileqqEditorCompositeStepMuiltiImageToVideo).b();
    }
  }
  
  public void onEncodeStart()
  {
    long l1 = System.currentTimeMillis();
    Object localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      Bitmap localBitmap = (Bitmap)((Iterator)localObject).next();
      MuiltiImageToVideo localMuiltiImageToVideo;
      int i;
      if (!MuiltiImageToVideo.a(this.jdField_a_of_type_ComTencentMobileqqEditorCompositeStepMuiltiImageToVideo))
      {
        localMuiltiImageToVideo = this.jdField_a_of_type_ComTencentMobileqqEditorCompositeStepMuiltiImageToVideo;
        i = MuiltiImageToVideo.a(localMuiltiImageToVideo, localBitmap, MuiltiImageToVideo.a(localMuiltiImageToVideo), MuiltiImageToVideo.b(this.jdField_a_of_type_ComTencentMobileqqEditorCompositeStepMuiltiImageToVideo));
      }
      else
      {
        localMuiltiImageToVideo = this.jdField_a_of_type_ComTencentMobileqqEditorCompositeStepMuiltiImageToVideo;
        i = MuiltiImageToVideo.b(localMuiltiImageToVideo, localBitmap, MuiltiImageToVideo.a(localMuiltiImageToVideo), MuiltiImageToVideo.b(this.jdField_a_of_type_ComTencentMobileqqEditorCompositeStepMuiltiImageToVideo));
      }
      MuiltiImageToVideo.a(this.jdField_a_of_type_ComTencentMobileqqEditorCompositeStepMuiltiImageToVideo).add(Integer.valueOf(i));
    }
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onEncodeStart preProcess cost: ");
      ((StringBuilder)localObject).append(l2 - l1);
      ((StringBuilder)localObject).append(" ms mGpuBlur:");
      ((StringBuilder)localObject).append(MuiltiImageToVideo.a(this.jdField_a_of_type_ComTencentMobileqqEditorCompositeStepMuiltiImageToVideo));
      QLog.d("MuiltiImageToVideo", 2, ((StringBuilder)localObject).toString());
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.editor.composite.step.MuiltiImageToVideo.1
 * JD-Core Version:    0.7.0.1
 */