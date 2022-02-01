package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.scale;

import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.scale.size.SizeParam;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/scale/ScaleCalculator$IDataProvider;", "", "getSizeParamList", "", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/scale/size/SizeParam;", "getStartSizeParamIndex", "", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public abstract interface ScaleCalculator$IDataProvider
{
  @NotNull
  public abstract List<SizeParam> a();
  
  public abstract int b();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.scale.ScaleCalculator.IDataProvider
 * JD-Core Version:    0.7.0.1
 */