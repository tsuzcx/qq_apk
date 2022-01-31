package dov.com.tencent.biz.qqstory.takevideo.doodle.layer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.NonNull;
import dov.com.tencent.biz.qqstory.takevideo.doodle.util.DisplayUtil;
import dov.com.tencent.biz.qqstory.takevideo.doodle.util.GestureHelper;
import dov.com.tencent.biz.qqstory.takevideo.doodle.util.GestureHelper.ZoomItem;
import dov.com.tencent.biz.qqstory.takevideo.vote.VoteDashItem;

public class VoteLayer$VoteItem
  extends GestureHelper.ZoomItem
{
  @NonNull
  public Bitmap a;
  public VoteDashItem a;
  public boolean a;
  public Rect[] a;
  
  public VoteLayer$VoteItem(VoteLayer paramVoteLayer, @NonNull Bitmap paramBitmap, @NonNull PointF paramPointF, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, boolean paramBoolean)
  {
    super(paramPointF, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramBoolean);
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoVoteVoteDashItem = new VoteDashItem();
  }
  
  public void a(Canvas paramCanvas)
  {
    paramCanvas.save();
    paramCanvas.concat(VoteLayer.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerVoteLayer).a(this));
    paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, -this.u / 2.0F, -this.v / 2.0F, VoteLayer.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerVoteLayer));
    if ((this.j) && (this.jdField_a_of_type_Boolean))
    {
      paramCanvas.translate(-this.u / 2.0F, -this.v / 2.0F);
      Path localPath = new Path();
      Rect[] arrayOfRect = this.jdField_a_of_type_ArrayOfAndroidGraphicsRect;
      int j = arrayOfRect.length;
      int i = 0;
      while (i < j)
      {
        Rect localRect = arrayOfRect[i];
        localPath.reset();
        localPath.addRoundRect(new RectF(localRect.left + 10, localRect.top + 5, localRect.right - 10, localRect.bottom - 5), 4.0F, 4.0F, Path.Direction.CCW);
        paramCanvas.drawPath(localPath, VoteLayer.b(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerVoteLayer));
        i += 1;
      }
    }
    paramCanvas.restore();
    if (this.j) {
      DisplayUtil.a(paramCanvas, VoteLayer.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerVoteLayer), this, -1, 2130842006, 2130842013);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.layer.VoteLayer.VoteItem
 * JD-Core Version:    0.7.0.1
 */