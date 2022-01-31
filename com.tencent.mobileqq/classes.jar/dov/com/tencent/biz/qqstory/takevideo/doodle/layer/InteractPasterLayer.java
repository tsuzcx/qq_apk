package dov.com.tencent.biz.qqstory.takevideo.doodle.layer;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.utils.UIUtils;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;

public class InteractPasterLayer
  extends VoteLayer
{
  public InteractPasterLayer(DoodleView paramDoodleView)
  {
    super(paramDoodleView);
  }
  
  public String a()
  {
    return "InteractPasterLayer";
  }
  
  public void a(@NonNull Bitmap paramBitmap, @NonNull Rect[] paramArrayOfRect, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerVoteLayer$VoteItem == null)
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerVoteLayer$VoteItem = new InteractPasterLayer.InteractItem(this, paramBitmap, new PointF(UIUtils.a(this.jdField_a_of_type_AndroidContentContext) / 2, UIUtils.b(this.jdField_a_of_type_AndroidContentContext) / 2), paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramBitmap.getWidth(), paramBitmap.getHeight(), true);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerVoteLayer$VoteItem.jdField_a_of_type_ArrayOfAndroidGraphicsRect = paramArrayOfRect;
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = 1;
      super.k();
      return;
      if (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerVoteLayer$VoteItem.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerVoteLayer$VoteItem.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      }
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerVoteLayer$VoteItem.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerVoteLayer$VoteItem.u = paramBitmap.getWidth();
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerVoteLayer$VoteItem.v = paramBitmap.getHeight();
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerVoteLayer$VoteItem.jdField_a_of_type_ArrayOfAndroidGraphicsRect = paramArrayOfRect;
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerVoteLayer$VoteItem.q = paramFloat1;
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerVoteLayer$VoteItem.r = paramFloat2;
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerVoteLayer$VoteItem.s = paramFloat3;
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerVoteLayer$VoteItem.t = paramFloat4;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.layer.InteractPasterLayer
 * JD-Core Version:    0.7.0.1
 */