package com.tencent.weseevideo.composition;

import android.graphics.RectF;
import com.tencent.weseevideo.composition.interfaces.OnNodeRenderListener;
import com.tencent.weseevideo.model.template.light.LightTemplate;
import java.util.HashMap;
import org.light.MovieController;

class VideoRenderChainManager$4
  implements OnNodeRenderListener
{
  VideoRenderChainManager$4(VideoRenderChainManager paramVideoRenderChainManager) {}
  
  public void a()
  {
    if (VideoRenderChainManager.access$200(this.a) != null)
    {
      RectF localRectF = VideoRenderChainManager.access$200(this.a).getMovieController().getBoundsByKey("hongbao");
      if (!localRectF.isEmpty()) {
        VideoRenderChainManager.access$200(this.a).getBoundsRect().put("hongbao", localRectF);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weseevideo.composition.VideoRenderChainManager.4
 * JD-Core Version:    0.7.0.1
 */