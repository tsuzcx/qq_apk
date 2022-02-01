package dov.com.qq.im.capture.view;

import android.content.Context;
import android.os.Bundle;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import bpwy;
import bpwz;
import bpxa;
import bqrk;
import bqte;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import dov.com.tencent.biz.qqstory.takevideo.multivideo.SegmentPicker;
import java.lang.ref.WeakReference;
import java.util.List;
import zps;

public class VideoSegmentPickerProviderView
  extends ProviderView
  implements bqte
{
  private long jdField_a_of_type_Long;
  private bqrk jdField_a_of_type_Bqrk;
  private SegmentPicker jdField_a_of_type_DovComTencentBizQqstoryTakevideoMultivideoSegmentPicker;
  private WeakReference<bpxa> jdField_a_of_type_JavaLangRefWeakReference;
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
    return 2131561004;
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
    this.jdField_a_of_type_Bqrk = null;
  }
  
  public void a(long paramLong)
  {
    bpxa localbpxa = null;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      localbpxa = (bpxa)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    if (localbpxa != null) {
      localbpxa.a(paramLong);
    }
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    if (this.jdField_a_of_type_AndroidViewView == null) {
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(2131561004, this, false);
    }
    a(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMultivideoSegmentPicker = ((SegmentPicker)this.jdField_a_of_type_AndroidViewView.findViewById(2131365889));
    this.jdField_a_of_type_AndroidViewView.findViewById(2131363983).setOnClickListener(new bpwy(this));
    this.jdField_a_of_type_AndroidViewView.findViewById(2131363984).setOnClickListener(new bpwz(this));
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      paramBundle = (bpxa)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (paramBundle != null) {
        paramBundle.a();
      }
    }
  }
  
  public void a(List<Long> paramList)
  {
    bpxa localbpxa = null;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      localbpxa = (bpxa)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    if (localbpxa != null) {
      localbpxa.a(paramList);
    }
  }
  
  public int b()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.findViewById(2131378757).getLayoutParams();
    int i = zps.a(getContext(), 22.0F);
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
    this.jdField_a_of_type_Bqrk = null;
  }
  
  public void b(long paramLong)
  {
    bpxa localbpxa = null;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      localbpxa = (bpxa)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    if (localbpxa != null) {
      localbpxa.b(paramLong);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public void setItems(bqrk parambqrk)
  {
    this.jdField_a_of_type_Bqrk = parambqrk;
    if (this.jdField_a_of_type_Bqrk != null)
    {
      this.jdField_a_of_type_Bqrk.a.changeNormalMode(this.jdField_a_of_type_Long - this.b);
      b(this.jdField_a_of_type_Bqrk.a.getSegmentList());
    }
  }
  
  public void setListener(bpxa parambpxa)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambpxa);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.capture.view.VideoSegmentPickerProviderView
 * JD-Core Version:    0.7.0.1
 */