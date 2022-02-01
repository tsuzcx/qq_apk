package dov.com.qq.im.ae.biz.qcircle.widget;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback;

class AECircleVideoPreviewItemView$1
  implements VideoPlayerCallback
{
  AECircleVideoPreviewItemView$1(AECircleVideoPreviewItemView paramAECircleVideoPreviewItemView, LocalMediaInfo paramLocalMediaInfo) {}
  
  public void onCapFrame(long paramLong, boolean paramBoolean, int paramInt1, int paramInt2, Bitmap paramBitmap) {}
  
  public void onDownloadComplete(long paramLong) {}
  
  public void onDownloadProgress(long paramLong1, long paramLong2) {}
  
  public void onFirstFrameRendered(long paramLong) {}
  
  public void onLoopBack(long paramLong1, long paramLong2) {}
  
  public void onPlayError(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString) {}
  
  public void onPlayProgress(long paramLong1, long paramLong2)
  {
    if (AECircleVideoPreviewItemView.a(this.jdField_a_of_type_DovComQqImAeBizQcircleWidgetAECircleVideoPreviewItemView) != null)
    {
      int i = (int)(AECircleVideoPreviewItemView.a(this.jdField_a_of_type_DovComQqImAeBizQcircleWidgetAECircleVideoPreviewItemView).getMax() * ((float)paramLong2 / (float)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration));
      if (i >= AECircleVideoPreviewItemView.a(this.jdField_a_of_type_DovComQqImAeBizQcircleWidgetAECircleVideoPreviewItemView))
      {
        AECircleVideoPreviewItemView.a(this.jdField_a_of_type_DovComQqImAeBizQcircleWidgetAECircleVideoPreviewItemView).setProgress(i);
        AECircleVideoPreviewItemView.a(this.jdField_a_of_type_DovComQqImAeBizQcircleWidgetAECircleVideoPreviewItemView, -1);
      }
    }
    if (AECircleVideoPreviewItemView.a(this.jdField_a_of_type_DovComQqImAeBizQcircleWidgetAECircleVideoPreviewItemView) != null) {
      AECircleVideoPreviewItemView.a(this.jdField_a_of_type_DovComQqImAeBizQcircleWidgetAECircleVideoPreviewItemView).setText(AECircleVideoPreviewItemView.a(this.jdField_a_of_type_DovComQqImAeBizQcircleWidgetAECircleVideoPreviewItemView, paramLong2));
    }
  }
  
  public void onStateChange(long paramLong, int paramInt)
  {
    if (paramInt == 4)
    {
      AECircleVideoPreviewItemView.a(this.jdField_a_of_type_DovComQqImAeBizQcircleWidgetAECircleVideoPreviewItemView).setVisibility(8);
      AECircleVideoPreviewItemView.b(this.jdField_a_of_type_DovComQqImAeBizQcircleWidgetAECircleVideoPreviewItemView).setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.biz.qcircle.widget.AECircleVideoPreviewItemView.1
 * JD-Core Version:    0.7.0.1
 */