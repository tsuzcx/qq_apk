package dov.com.qq.im.capture.view;

import android.content.Context;
import android.os.Bundle;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import bmbz;
import bmca;
import bmcb;
import bmyj;
import bnad;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import dov.com.tencent.biz.qqstory.takevideo.multivideo.SegmentPicker;
import java.lang.ref.WeakReference;
import java.util.List;
import xsm;

public class VideoSegmentPickerProviderView
  extends ProviderView
  implements bnad
{
  private long jdField_a_of_type_Long;
  private bmyj jdField_a_of_type_Bmyj;
  private SegmentPicker jdField_a_of_type_DovComTencentBizQqstoryTakevideoMultivideoSegmentPicker;
  private WeakReference<bmcb> jdField_a_of_type_JavaLangRefWeakReference;
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
    return 2131560769;
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
    this.jdField_a_of_type_Bmyj = null;
  }
  
  public void a(long paramLong)
  {
    bmcb localbmcb = null;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      localbmcb = (bmcb)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    if (localbmcb != null) {
      localbmcb.a(paramLong);
    }
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    if (this.jdField_a_of_type_AndroidViewView == null) {
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(2131560769, this, false);
    }
    a(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMultivideoSegmentPicker = ((SegmentPicker)this.jdField_a_of_type_AndroidViewView.findViewById(2131365611));
    this.jdField_a_of_type_AndroidViewView.findViewById(2131363753).setOnClickListener(new bmbz(this));
    this.jdField_a_of_type_AndroidViewView.findViewById(2131363754).setOnClickListener(new bmca(this));
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      paramBundle = (bmcb)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (paramBundle != null) {
        paramBundle.a();
      }
    }
  }
  
  public void a(List<Long> paramList)
  {
    bmcb localbmcb = null;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      localbmcb = (bmcb)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    if (localbmcb != null) {
      localbmcb.a(paramList);
    }
  }
  
  public int b()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.findViewById(2131377758).getLayoutParams();
    int i = xsm.a(getContext(), 22.0F);
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
    this.jdField_a_of_type_Bmyj = null;
  }
  
  public void b(long paramLong)
  {
    bmcb localbmcb = null;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      localbmcb = (bmcb)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    if (localbmcb != null) {
      localbmcb.b(paramLong);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public void setItems(bmyj parambmyj)
  {
    this.jdField_a_of_type_Bmyj = parambmyj;
    if (this.jdField_a_of_type_Bmyj != null)
    {
      this.jdField_a_of_type_Bmyj.a.changeNormalMode(this.jdField_a_of_type_Long - this.b);
      b(this.jdField_a_of_type_Bmyj.a.getSegmentList());
    }
  }
  
  public void setListener(bmcb parambmcb)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambmcb);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.capture.view.VideoSegmentPickerProviderView
 * JD-Core Version:    0.7.0.1
 */