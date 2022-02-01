package dov.com.tencent.biz.qqstory.takevideo.multivideo;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Pair;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import bqte;
import bqtf;
import java.lang.ref.WeakReference;
import java.util.List;

public class SegmentPicker
  extends RelativeLayout
  implements bqtf
{
  private SegmentRangeView jdField_a_of_type_DovComTencentBizQqstoryTakevideoMultivideoSegmentRangeView;
  private WeakReference<bqte> jdField_a_of_type_JavaLangRefWeakReference;
  
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
    bqte localbqte = null;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      localbqte = (bqte)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    if (localbqte != null) {
      localbqte.a(paramLong);
    }
  }
  
  public void a(List<Long> paramList)
  {
    bqte localbqte = null;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      localbqte = (bqte)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    if (localbqte != null) {
      localbqte.a(paramList);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMultivideoSegmentRangeView != null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMultivideoSegmentRangeView.a(paramBoolean);
    }
  }
  
  public boolean a(String paramString, long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, bqte parambqte, boolean paramBoolean2)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambqte);
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMultivideoSegmentRangeView != null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMultivideoSegmentRangeView.a(paramString, paramLong1, paramLong2, paramInt1, paramInt2, paramInt3, paramBoolean1, this, paramBoolean2);
    }
    return true;
  }
  
  public void b(long paramLong)
  {
    bqte localbqte = null;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      localbqte = (bqte)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    if (localbqte != null) {
      localbqte.b(paramLong);
    }
  }
  
  public void setRanges(List<Pair<Long, Long>> paramList)
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMultivideoSegmentRangeView != null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMultivideoSegmentRangeView.setRanges(paramList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.multivideo.SegmentPicker
 * JD-Core Version:    0.7.0.1
 */