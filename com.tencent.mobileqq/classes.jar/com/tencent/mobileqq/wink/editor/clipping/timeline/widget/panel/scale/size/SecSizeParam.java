package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.scale.size;

import com.tencent.videocut.utils.TimeUtils;
import java.text.SimpleDateFormat;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/scale/size/SecSizeParam;", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/scale/size/SizeParam;", "unitValue", "", "(F)V", "mSimpleDateFormat", "Ljava/text/SimpleDateFormat;", "getPosition", "timeUs", "getShowStr", "", "", "getTime", "scrollX", "perPx", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class SecSizeParam
  extends SizeParam
{
  private final SimpleDateFormat a = new SimpleDateFormat("mm:ss", Locale.US);
  
  public SecSizeParam(float paramFloat)
  {
    super(paramFloat);
  }
  
  public float a(float paramFloat)
  {
    return TimeUtils.a.b(paramFloat) / a();
  }
  
  public float a(float paramFloat1, float paramFloat2)
  {
    return paramFloat1 / paramFloat2 * TimeUtils.a.a(a());
  }
  
  @NotNull
  public String a(long paramLong)
  {
    String str = this.a.format(Long.valueOf(TimeUtils.a.c(paramLong)));
    Intrinsics.checkExpressionValueIsNotNull(str, "mSimpleDateFormat.format(TimeUtils.usToMs(timeUs))");
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.scale.size.SecSizeParam
 * JD-Core Version:    0.7.0.1
 */