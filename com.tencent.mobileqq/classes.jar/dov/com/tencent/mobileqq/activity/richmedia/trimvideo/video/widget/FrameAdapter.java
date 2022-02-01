package dov.com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget;

import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

public class FrameAdapter
{
  private FrameAdapter.DataSetChangeListener jdField_a_of_type_DovComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFrameAdapter$DataSetChangeListener;
  private ConcurrentHashMap<Integer, FramesProcessor.Frame> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  
  public FramesProcessor.Frame a(int paramInt)
  {
    return (FramesProcessor.Frame)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
  }
  
  public void a(FramesProcessor.Frame paramFrame)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FrameAdapter", 2, "addFrame, index=" + paramFrame.a);
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.putIfAbsent(Integer.valueOf(paramFrame.a), paramFrame);
    if (this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFrameAdapter$DataSetChangeListener != null) {
      this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFrameAdapter$DataSetChangeListener.a();
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() == 0;
  }
  
  public boolean a(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Integer.valueOf(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.FrameAdapter
 * JD-Core Version:    0.7.0.1
 */