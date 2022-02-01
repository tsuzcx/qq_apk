package dov.com.tencent.biz.qqstory.takevideo.multivideo;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Pair;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import java.lang.ref.WeakReference;
import java.util.List;

public class SegmentPicker
  extends RelativeLayout
  implements SegmentRangeView.SegmentRangeViewListener
{
  private SegmentRangeView jdField_a_of_type_DovComTencentBizQqstoryTakevideoMultivideoSegmentRangeView;
  private WeakReference<SegmentPicker.SegmentPickerListener> jdField_a_of_type_JavaLangRefWeakReference;
  
  public SegmentPicker(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SegmentPicker(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SegmentPicker(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMultivideoSegmentRangeView = new SegmentRangeView(paramContext, null);
    paramContext = new RelativeLayout.LayoutParams(-1, -1);
    addView(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMultivideoSegmentRangeView, paramContext);
  }
  
  public void a(long paramLong)
  {
    SegmentPicker.SegmentPickerListener localSegmentPickerListener = null;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      localSegmentPickerListener = (SegmentPicker.SegmentPickerListener)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    if (localSegmentPickerListener != null) {
      localSegmentPickerListener.a(paramLong);
    }
  }
  
  public void a(List<Long> paramList)
  {
    SegmentPicker.SegmentPickerListener localSegmentPickerListener = null;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      localSegmentPickerListener = (SegmentPicker.SegmentPickerListener)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    if (localSegmentPickerListener != null) {
      localSegmentPickerListener.a(paramList);
    }
  }
  
  public void b(long paramLong)
  {
    SegmentPicker.SegmentPickerListener localSegmentPickerListener = null;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      localSegmentPickerListener = (SegmentPicker.SegmentPickerListener)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    if (localSegmentPickerListener != null) {
      localSegmentPickerListener.b(paramLong);
    }
  }
  
  public void setRanges(List<Pair<Long, Long>> paramList)
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMultivideoSegmentRangeView != null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMultivideoSegmentRangeView.setRanges(paramList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.multivideo.SegmentPicker
 * JD-Core Version:    0.7.0.1
 */