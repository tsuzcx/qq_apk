package dov.com.qq.im.capture.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import anqf;
import anqg;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import dov.com.tencent.biz.qqstory.takevideo.doodle.util.GestureHelper.ZoomItem;
import dov.com.tencent.biz.qqstory.takevideo.multivideo.SegmentPicker;
import dov.com.tencent.biz.qqstory.takevideo.multivideo.SegmentPicker.SegmentPickerListener;
import java.lang.ref.WeakReference;
import java.util.List;

public class VideoSegmentPickerProviderView
  extends ProviderView
  implements SegmentPicker.SegmentPickerListener
{
  private long jdField_a_of_type_Long;
  private GestureHelper.ZoomItem jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem;
  private SegmentPicker jdField_a_of_type_DovComTencentBizQqstoryTakevideoMultivideoSegmentPicker;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  private long b;
  
  public VideoSegmentPickerProviderView(Context paramContext)
  {
    super(paramContext);
  }
  
  private void b(List paramList)
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMultivideoSegmentPicker != null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMultivideoSegmentPicker.setRanges(paramList);
    }
  }
  
  protected int a()
  {
    return 2130970144;
  }
  
  public void a(long paramLong)
  {
    VideoSegmentPickerProviderView.VideoSegmentPickerListener localVideoSegmentPickerListener = null;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      localVideoSegmentPickerListener = (VideoSegmentPickerProviderView.VideoSegmentPickerListener)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    if (localVideoSegmentPickerListener != null) {
      localVideoSegmentPickerListener.a(paramLong);
    }
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    if (this.jdField_a_of_type_AndroidViewView == null) {
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(2130970144, this, false);
    }
    a(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMultivideoSegmentPicker = ((SegmentPicker)this.jdField_a_of_type_AndroidViewView.findViewById(2131369209));
    this.jdField_a_of_type_AndroidViewView.findViewById(2131369210).setOnClickListener(new anqf(this));
    this.jdField_a_of_type_AndroidViewView.findViewById(2131369211).setOnClickListener(new anqg(this));
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      paramBundle = (VideoSegmentPickerProviderView.VideoSegmentPickerListener)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (paramBundle != null) {
        paramBundle.a();
      }
    }
  }
  
  public void a(List paramList)
  {
    VideoSegmentPickerProviderView.VideoSegmentPickerListener localVideoSegmentPickerListener = null;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      localVideoSegmentPickerListener = (VideoSegmentPickerProviderView.VideoSegmentPickerListener)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    if (localVideoSegmentPickerListener != null) {
      localVideoSegmentPickerListener.a(paramList);
    }
  }
  
  public void b(long paramLong)
  {
    VideoSegmentPickerProviderView.VideoSegmentPickerListener localVideoSegmentPickerListener = null;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      localVideoSegmentPickerListener = (VideoSegmentPickerProviderView.VideoSegmentPickerListener)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    if (localVideoSegmentPickerListener != null) {
      localVideoSegmentPickerListener.b(paramLong);
    }
  }
  
  public void c()
  {
    super.c();
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMultivideoSegmentPicker != null)
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMultivideoSegmentPicker.a();
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMultivideoSegmentPicker = null;
    }
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem = null;
  }
  
  public void g()
  {
    super.g();
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMultivideoSegmentPicker != null)
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMultivideoSegmentPicker.a();
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMultivideoSegmentPicker = null;
    }
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem = null;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public void setItems(GestureHelper.ZoomItem paramZoomItem)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem = paramZoomItem;
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem != null)
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem.a.a(this.jdField_a_of_type_Long - this.b);
      b(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem.a.a());
    }
  }
  
  public void setListener(VideoSegmentPickerProviderView.VideoSegmentPickerListener paramVideoSegmentPickerListener)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramVideoSegmentPickerListener);
  }
  
  public void setPlayMode(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMultivideoSegmentPicker != null) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMultivideoSegmentPicker.a(false);
      }
      break;
    }
    do
    {
      return;
    } while (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMultivideoSegmentPicker == null);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMultivideoSegmentPicker.a(true);
  }
  
  public void setVideo(String paramString, long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    this.jdField_a_of_type_Long = paramLong2;
    this.b = paramLong1;
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMultivideoSegmentPicker != null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMultivideoSegmentPicker.a(paramString, this.b, this.jdField_a_of_type_Long, paramInt3, paramInt1, paramInt2, paramBoolean, this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.view.VideoSegmentPickerProviderView
 * JD-Core Version:    0.7.0.1
 */