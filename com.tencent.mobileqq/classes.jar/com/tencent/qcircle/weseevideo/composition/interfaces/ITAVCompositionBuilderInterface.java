package com.tencent.qcircle.weseevideo.composition.interfaces;

import com.tencent.qcircle.weseevideo.model.resource.MediaClipModel;
import com.tencent.tavkit.composition.TAVComposition;
import java.util.List;

public abstract interface ITAVCompositionBuilderInterface
{
  public abstract TAVComposition buildComposition(List<MediaClipModel> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.weseevideo.composition.interfaces.ITAVCompositionBuilderInterface
 * JD-Core Version:    0.7.0.1
 */