package dov.com.qq.im.capture.view;

import android.content.Context;
import android.os.Bundle;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import bhqu;
import bhqv;
import bhqw;
import birb;
import bitc;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import dov.com.tencent.biz.qqstory.takevideo.multivideo.SegmentPicker;
import java.lang.ref.WeakReference;
import java.util.List;
import vms;

public class VideoSegmentPickerProviderView
  extends ProviderView
  implements bitc
{
  private long jdField_a_of_type_Long;
  private birb jdField_a_of_type_Birb;
  private SegmentPicker jdField_a_of_type_DovComTencentBizQqstoryTakevideoMultivideoSegmentPicker;
  private WeakReference<bhqw> jdField_a_of_type_JavaLangRefWeakReference;
  private long b;
  
  public VideoSegmentPickerProviderView(Context paramContext)
  {
    super(paramContext);
  }
  
  private void b(List<Pair<Long, Long>> paramList)
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMultivideoSegmentPicker != null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMultivideoSegmentPicker.setRanges(paramList);
    }
  }
  
  protected int a()
  {
    return 2131495002;
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMultivideoSegmentPicker != null)
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMultivideoSegmentPicker.a();
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMultivideoSegmentPicker = null;
    }
    this.jdField_a_of_type_Birb = null;
  }
  
  public void a(long paramLong)
  {
    bhqw localbhqw = null;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      localbhqw = (bhqw)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    if (localbhqw != null) {
      localbhqw.a(paramLong);
    }
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    if (this.jdField_a_of_type_AndroidViewView == null) {
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(2131495002, this, false);
    }
    a(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMultivideoSegmentPicker = ((SegmentPicker)this.jdField_a_of_type_AndroidViewView.findViewById(2131299945));
    this.jdField_a_of_type_AndroidViewView.findViewById(2131298143).setOnClickListener(new bhqu(this));
    this.jdField_a_of_type_AndroidViewView.findViewById(2131298144).setOnClickListener(new bhqv(this));
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      paramBundle = (bhqw)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (paramBundle != null) {
        paramBundle.a();
      }
    }
  }
  
  public void a(List<Long> paramList)
  {
    bhqw localbhqw = null;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      localbhqw = (bhqw)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    if (localbhqw != null) {
      localbhqw.a(paramList);
    }
  }
  
  public int b()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.findViewById(2131311370).getLayoutParams();
    int i = vms.a(getContext(), 22.0F);
    return localLayoutParams.topMargin + i;
  }
  
  public void b()
  {
    super.b();
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMultivideoSegmentPicker != null)
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMultivideoSegmentPicker.a();
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMultivideoSegmentPicker = null;
    }
    this.jdField_a_of_type_Birb = null;
  }
  
  public void b(long paramLong)
  {
    bhqw localbhqw = null;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      localbhqw = (bhqw)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    if (localbhqw != null) {
      localbhqw.b(paramLong);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public void setItems(birb parambirb)
  {
    this.jdField_a_of_type_Birb = parambirb;
    if (this.jdField_a_of_type_Birb != null)
    {
      this.jdField_a_of_type_Birb.a.changeNormalMode(this.jdField_a_of_type_Long - this.b);
      b(this.jdField_a_of_type_Birb.a.getSegmentList());
    }
  }
  
  public void setListener(bhqw parambhqw)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambhqw);
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
  
  public void setVideo(String paramString, long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_Long = paramLong2;
    this.b = paramLong1;
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMultivideoSegmentPicker != null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMultivideoSegmentPicker.a(paramString, this.b, this.jdField_a_of_type_Long, paramInt3, paramInt1, paramInt2, paramBoolean1, this, paramBoolean2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.view.VideoSegmentPickerProviderView
 * JD-Core Version:    0.7.0.1
 */