package dov.com.qq.im.capture.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import dov.com.tencent.biz.qqstory.takevideo.multivideo.VideoCoverSegmentPicker;
import dov.com.tencent.biz.qqstory.takevideo.multivideo.VideoCoverSegmentPicker.SegmentPickerListener;
import java.lang.ref.WeakReference;
import java.util.List;

public class VideoCoverPickerProviderView
  extends ProviderView
  implements VideoCoverSegmentPicker.SegmentPickerListener
{
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long = 0L;
  private VideoCoverSegmentPicker jdField_a_of_type_DovComTencentBizQqstoryTakevideoMultivideoVideoCoverSegmentPicker;
  private WeakReference<VideoCoverPickerProviderView.PickerListener> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean;
  private long b = 0L;
  private long c = 0L;
  private long d = 0L;
  private long e = 0L;
  
  public VideoCoverPickerProviderView(Context paramContext)
  {
    super(paramContext);
  }
  
  protected int a()
  {
    return 2131561021;
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMultivideoVideoCoverSegmentPicker != null)
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMultivideoVideoCoverSegmentPicker.a();
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMultivideoVideoCoverSegmentPicker = null;
    }
  }
  
  public void a(long paramLong)
  {
    this.d = paramLong;
    long l;
    if (this.jdField_a_of_type_Boolean)
    {
      l = 30L;
      if (Math.abs(paramLong - this.e) >= l) {
        break label38;
      }
    }
    label38:
    VideoCoverPickerProviderView.PickerListener localPickerListener;
    do
    {
      return;
      l = 90L;
      break;
      this.e = paramLong;
      localPickerListener = null;
      if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
        localPickerListener = (VideoCoverPickerProviderView.PickerListener)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      }
    } while (localPickerListener == null);
    localPickerListener.a(paramLong);
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    if (this.jdField_a_of_type_AndroidViewView == null) {
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(2131561021, this, false);
    }
    a(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMultivideoVideoCoverSegmentPicker = ((VideoCoverSegmentPicker)this.jdField_a_of_type_AndroidViewView.findViewById(2131366185));
    setPlayMode(this.jdField_a_of_type_Int);
    paramBundle = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364364);
    ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367002)).setOnClickListener(new VideoCoverPickerProviderView.1(this));
    paramBundle.setOnClickListener(new VideoCoverPickerProviderView.2(this));
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      paramBundle = (VideoCoverPickerProviderView.PickerListener)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (paramBundle != null) {
        paramBundle.a();
      }
    }
  }
  
  public void a(List<Long> paramList)
  {
    VideoCoverPickerProviderView.PickerListener localPickerListener = null;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      localPickerListener = (VideoCoverPickerProviderView.PickerListener)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    if (localPickerListener != null) {
      localPickerListener.a(paramList);
    }
  }
  
  public void b()
  {
    super.b();
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMultivideoVideoCoverSegmentPicker != null)
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMultivideoVideoCoverSegmentPicker.a();
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMultivideoVideoCoverSegmentPicker = null;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public void setCoverFrameTime(long paramLong)
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMultivideoVideoCoverSegmentPicker != null)
    {
      this.e = paramLong;
      this.c = paramLong;
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMultivideoVideoCoverSegmentPicker.setCoverFrameTime(paramLong);
    }
  }
  
  public void setListener(VideoCoverPickerProviderView.PickerListener paramPickerListener)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramPickerListener);
  }
  
  public void setPlayMode(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    switch (paramInt)
    {
    default: 
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMultivideoVideoCoverSegmentPicker != null) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMultivideoVideoCoverSegmentPicker.a(false);
      }
      break;
    }
    do
    {
      return;
    } while (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMultivideoVideoCoverSegmentPicker == null);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMultivideoVideoCoverSegmentPicker.a(true);
  }
  
  public void setUseIFrameVideo(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setVideo(String paramString, long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_Long = paramLong2;
    this.b = paramLong1;
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMultivideoVideoCoverSegmentPicker != null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMultivideoVideoCoverSegmentPicker.a(paramString, this.b, this.jdField_a_of_type_Long, paramInt3, paramInt1, paramInt2, paramBoolean1, this, paramBoolean2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.qq.im.capture.view.VideoCoverPickerProviderView
 * JD-Core Version:    0.7.0.1
 */