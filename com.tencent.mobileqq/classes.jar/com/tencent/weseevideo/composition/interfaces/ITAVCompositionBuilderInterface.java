package com.tencent.weseevideo.composition.interfaces;

import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.weseevideo.model.resource.MediaClipModel;
import java.util.List;

public abstract interface ITAVCompositionBuilderInterface
{
  public abstract TAVComposition buildComposition(List<MediaClipModel> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.weseevideo.composition.interfaces.ITAVCompositionBuilderInterface
 * JD-Core Version:    0.7.0.1
 */