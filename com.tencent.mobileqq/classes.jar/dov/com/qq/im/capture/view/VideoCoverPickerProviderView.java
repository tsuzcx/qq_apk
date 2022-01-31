package dov.com.qq.im.capture.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import bmbw;
import bmbx;
import bmby;
import bnaf;
import dov.com.tencent.biz.qqstory.takevideo.multivideo.VideoCoverSegmentPicker;
import java.lang.ref.WeakReference;
import java.util.List;

public class VideoCoverPickerProviderView
  extends ProviderView
  implements bnaf
{
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long;
  private VideoCoverSegmentPicker jdField_a_of_type_DovComTencentBizQqstoryTakevideoMultivideoVideoCoverSegmentPicker;
  private WeakReference<bmby> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean;
  private long b;
  private long c;
  private long d;
  private long e;
  
  public VideoCoverPickerProviderView(Context paramContext)
  {
    super(paramContext);
  }
  
  protected int a()
  {
    return 2131560768;
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
    bmby localbmby;
    do
    {
      return;
      l = 90L;
      break;
      this.e = paramLong;
      localbmby = null;
      if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
        localbmby = (bmby)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      }
    } while (localbmby == null);
    localbmby.a(paramLong);
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    if (this.jdField_a_of_type_AndroidViewView == null) {
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(2131560768, this, false);
    }
    a(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMultivideoVideoCoverSegmentPicker = ((VideoCoverSegmentPicker)this.jdField_a_of_type_AndroidViewView.findViewById(2131365611));
    setPlayMode(this.jdField_a_of_type_Int);
    paramBundle = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363915);
    ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366375)).setOnClickListener(new bmbw(this));
    paramBundle.setOnClickListener(new bmbx(this));
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      paramBundle = (bmby)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (paramBundle != null) {
        paramBundle.a();
      }
    }
  }
  
  public void a(List<Long> paramList)
  {
    bmby localbmby = null;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      localbmby = (bmby)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    if (localbmby != null) {
      localbmby.a(paramList);
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
  
  public void setListener(bmby parambmby)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambmby);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.capture.view.VideoCoverPickerProviderView
 * JD-Core Version:    0.7.0.1
 */