package com.tencent.weseevideo.composition;

import android.graphics.RectF;
import com.tencent.weseevideo.composition.interfaces.OnNodeRenderListener;
import com.tencent.weseevideo.model.template.light.LightTemplate;
import java.util.HashMap;
import org.light.MovieController;

class VideoRenderChainManager$2
  implements OnNodeRenderListener
{
  VideoRenderChainManager$2(VideoRenderChainManager paramVideoRenderChainManager) {}
  
  public void a()
  {
    if (VideoRenderChainManager.access$100(this.a) != null)
    {
      RectF localRectF = VideoRenderChainManager.access$100(this.a).getMovieController().getBoundsByKey("hongbao");
      if (!localRectF.isEmpty()) {
        VideoRenderChainManager.access$100(this.a).getBoundsRect().put("hongbao", localRectF);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.weseevideo.composition.VideoRenderChainManager.2
 * JD-Core Version:    0.7.0.1
 */