package dov.com.tencent.biz.qqstory.takevideo.multivideo;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import bqtg;
import bqth;
import java.lang.ref.WeakReference;
import java.util.List;

public class VideoCoverSegmentPicker
  extends RelativeLayout
  implements bqth
{
  private VideoCoverSegmentRangeView jdField_a_of_type_DovComTencentBizQqstoryTakevideoMultivideoVideoCoverSegmentRangeView;
  private WeakReference<bqtg> jdField_a_of_type_JavaLangRefWeakReference;
  
  public VideoCoverSegmentPicker(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public VideoCoverSegmentPicker(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public VideoCoverSegmentPicker(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMultivideoVideoCoverSegmentRangeView = new VideoCoverSegmentRangeView(paramContext, null);
    paramContext = new RelativeLayout.LayoutParams(-1, -1);
    addView(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMultivideoVideoCoverSegmentRangeView, paramContext);
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMultivideoVideoCoverSegmentRangeView != null)
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMultivideoVideoCoverSegmentRangeView.a();
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMultivideoVideoCoverSegmentRangeView = null;
    }
  }
  
  public void a(long paramLong)
  {
    bqtg localbqtg = null;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      localbqtg = (bqtg)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    if (localbqtg != null) {
      localbqtg.a(paramLong);
    }
  }
  
  public void a(List<Long> paramList)
  {
    bqtg localbqtg = null;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      localbqtg = (bqtg)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    if (localbqtg != null) {
      localbqtg.a(paramList);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMultivideoVideoCoverSegmentRangeView != null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMultivideoVideoCoverSegmentRangeView.a(paramBoolean);
    }
  }
  
  public boolean a(String paramString, long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, bqtg parambqtg, boolean paramBoolean2)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambqtg);
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMultivideoVideoCoverSegmentRangeView != null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMultivideoVideoCoverSegmentRangeView.a(paramString, paramLong1, paramLong2, paramInt1, paramInt2, paramInt3, paramBoolean1, this, paramBoolean2);
    }
    return true;
  }
  
  public void setCoverFrameTime(long paramLong)
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMultivideoVideoCoverSegmentRangeView != null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMultivideoVideoCoverSegmentRangeView.setCoverFrameTime(paramLong);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.multivideo.VideoCoverSegmentPicker
 * JD-Core Version:    0.7.0.1
 */