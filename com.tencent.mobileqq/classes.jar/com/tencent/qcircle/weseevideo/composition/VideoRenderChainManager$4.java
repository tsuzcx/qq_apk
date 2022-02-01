package com.tencent.qcircle.weseevideo.composition;

import android.graphics.RectF;
import com.tencent.qcircle.weseevideo.composition.interfaces.OnNodeRenderListener;
import com.tencent.qcircle.weseevideo.model.template.light.LightTemplate;
import java.util.HashMap;
import org.light.MovieController;

class VideoRenderChainManager$4
  implements OnNodeRenderListener
{
  VideoRenderChainManager$4(VideoRenderChainManager paramVideoRenderChainManager) {}
  
  public void onNodeRender()
  {
    if (VideoRenderChainManager.access$200(this.this$0) != null)
    {
      RectF localRectF = VideoRenderChainManager.access$200(this.this$0).getMovieController().getBoundsByKey("hongbao");
      if (!localRectF.isEmpty()) {
        VideoRenderChainManager.access$200(this.this$0).getBoundsRect().put("hongbao", localRectF);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.weseevideo.composition.VideoRenderChainManager.4
 * JD-Core Version:    0.7.0.1
 */