package dov.com.tencent.biz.qqstory.takevideo.multivideo;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Pair;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import bmvr;
import bmvs;
import java.lang.ref.WeakReference;
import java.util.List;

public class SegmentPicker
  extends RelativeLayout
  implements bmvs
{
  private SegmentRangeView jdField_a_of_type_DovComTencentBizQqstoryTakevideoMultivideoSegmentRangeView;
  private WeakReference<bmvr> jdField_a_of_type_JavaLangRefWeakReference;
  
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
  
  public List<Pair<Long, Long>> a()
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMultivideoSegmentRangeView != null) {
      return this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMultivideoSegmentRangeView.a();
    }
    return null;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMultivideoSegmentRangeView != null)
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMultivideoSegmentRangeView.a();
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMultivideoSegmentRangeView = null;
    }
  }
  
  public void a(long paramLong)
  {
    bmvr localbmvr = null;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      localbmvr = (bmvr)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    if (localbmvr != null) {
      localbmvr.a(paramLong);
    }
  }
  
  public void a(List<Long> paramList)
  {
    bmvr localbmvr = null;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      localbmvr = (bmvr)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    if (localbmvr != null) {
      localbmvr.a(paramList);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMultivideoSegmentRangeView != null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMultivideoSegmentRangeView.a(paramBoolean);
    }
  }
  
  public boolean a(String paramString, long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, bmvr parambmvr, boolean paramBoolean2)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambmvr);
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMultivideoSegmentRangeView != null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMultivideoSegmentRangeView.a(paramString, paramLong1, paramLong2, paramInt1, paramInt2, paramInt3, paramBoolean1, this, paramBoolean2);
    }
    return true;
  }
  
  public void b(long paramLong)
  {
    bmvr localbmvr = null;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      localbmvr = (bmvr)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    if (localbmvr != null) {
      localbmvr.b(paramLong);
    }
  }
  
  public void setRanges(List<Pair<Long, Long>> paramList)
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMultivideoSegmentRangeView != null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMultivideoSegmentRangeView.setRanges(paramList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.multivideo.SegmentPicker
 * JD-Core Version:    0.7.0.1
 */