package dov.com.tencent.biz.qqstory.takevideo.multivideo;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import bite;
import bitf;
import java.lang.ref.WeakReference;
import java.util.List;

public class VideoCoverSegmentPicker
  extends RelativeLayout
  implements bitf
{
  private VideoCoverSegmentRangeView jdField_a_of_type_DovComTencentBizQqstoryTakevideoMultivideoVideoCoverSegmentRangeView;
  private WeakReference<bite> jdField_a_of_type_JavaLangRefWeakReference;
  
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
    bite localbite = null;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      localbite = (bite)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    if (localbite != null) {
      localbite.a(paramLong);
    }
  }
  
  public void a(List<Long> paramList)
  {
    bite localbite = null;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      localbite = (bite)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    if (localbite != null) {
      localbite.a(paramList);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMultivideoVideoCoverSegmentRangeView != null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMultivideoVideoCoverSegmentRangeView.a(paramBoolean);
    }
  }
  
  public boolean a(String paramString, long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, bite parambite, boolean paramBoolean2)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambite);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.multivideo.VideoCoverSegmentPicker
 * JD-Core Version:    0.7.0.1
 */