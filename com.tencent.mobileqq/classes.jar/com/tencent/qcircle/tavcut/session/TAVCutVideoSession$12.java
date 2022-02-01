package com.tencent.qcircle.tavcut.session;

import android.util.SparseArray;
import com.tencent.qcircle.tavcut.bean.Size;
import com.tencent.qcircle.tavcut.player.MoviePlayer;
import com.tencent.qcircle.tavcut.session.config.SessionConfig;
import com.tencent.qcircle.tavcut.view.TAVCutVideoView;
import com.tencent.qcircle.weseevideo.composition.VideoRenderChainManager;
import com.tencent.qcircle.weseevideo.composition.builder.MediaBuilderListener;
import com.tencent.qcircle.weseevideo.composition.builder.MediaBuilderOutput;
import com.tencent.qcircle.weseevideo.editor.sticker.StickerController;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavkit.composition.TAVComposition;

class TAVCutVideoSession$12
  implements MediaBuilderListener
{
  TAVCutVideoSession$12(TAVCutVideoSession paramTAVCutVideoSession, boolean paramBoolean, StickerController paramStickerController, Runnable paramRunnable) {}
  
  public void buildCompleted(int paramInt, VideoRenderChainManager paramVideoRenderChainManager, MediaBuilderOutput paramMediaBuilderOutput)
  {
    if (paramVideoRenderChainManager == null) {
      return;
    }
    TAVCutVideoSession.access$002(this.this$0, paramMediaBuilderOutput);
    paramMediaBuilderOutput = TAVCutVideoSession.access$400(this.this$0, paramVideoRenderChainManager);
    CGSize localCGSize = TAVCutVideoSession.access$100(this.this$0, paramVideoRenderChainManager, paramMediaBuilderOutput);
    TAVCutVideoSession.access$500(this.this$0, paramVideoRenderChainManager.getComposition());
    this.this$0.renderChainManagers.put(0, paramVideoRenderChainManager);
    this.this$0.tavCompositions.put(0, paramVideoRenderChainManager.getComposition());
    TAVComposition localTAVComposition = paramVideoRenderChainManager.getComposition();
    if (this.this$0.sessionConfig != null) {
      paramMediaBuilderOutput = this.this$0.sessionConfig.getRenderLayoutMode();
    } else {
      paramMediaBuilderOutput = null;
    }
    localTAVComposition.setRenderLayoutMode(paramMediaBuilderOutput);
    if (this.this$0.getPlayer() != null)
    {
      this.this$0.getPlayer().setPlayRange(new CMTimeRange(CMTime.CMTimeZero, paramVideoRenderChainManager.getComposition().getDuration()));
      this.this$0.getPlayer().updateComposition(paramVideoRenderChainManager.getComposition(), this.val$autoPlay);
    }
    if ((this.val$stickerController != null) && (this.this$0.tavCutVideoView != null))
    {
      this.this$0.tavCutVideoView.adjustStickerContainer(new Size((int)localCGSize.width, (int)localCGSize.height));
      this.val$stickerController.setStickerContainer(this.this$0.tavCutVideoView.getStickerContainer());
    }
    paramVideoRenderChainManager = this.val$onRenderChain;
    if (paramVideoRenderChainManager != null) {
      paramVideoRenderChainManager.run();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.tavcut.session.TAVCutVideoSession.12
 * JD-Core Version:    0.7.0.1
 */