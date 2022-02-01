package dov.com.tencent.mobileqq.richmedia.mediacodec.widget;

import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWVideoDecoder;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.mobileqq.shortvideo.filter.QQTransferFilter;
import com.tencent.mobileqq.shortvideo.videotransfer.TransferData;
import java.util.List;

class VideoFilterPlayView$4
  implements Runnable
{
  VideoFilterPlayView$4(VideoFilterPlayView paramVideoFilterPlayView, TransferData paramTransferData) {}
  
  public void run()
  {
    if (VideoFilterPlayView.a(this.this$0) != null)
    {
      if (!VideoFilterPlayView.a(this.this$0).hasQQFilter(160)) {
        VideoFilterPlayView.a(this.this$0).pushChainBasedStackTopChain(160, null);
      }
      Object localObject = VideoFilterPlayView.a(this.this$0).getQQFilters(160);
      if ((localObject != null) && (((List)localObject).size() > 0) && ((((List)localObject).get(0) instanceof QQTransferFilter)))
      {
        localObject = (QQTransferFilter)((List)localObject).get(0);
        ((QQTransferFilter)localObject).setTransferData(this.a);
        ((QQTransferFilter)localObject).setSpeedRate(HWVideoDecoder.getSpeedRate(this.this$0.a()));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.mediacodec.widget.VideoFilterPlayView.4
 * JD-Core Version:    0.7.0.1
 */