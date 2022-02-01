package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.scale.size;

import com.tencent.videocut.utils.TimeUtils;
import java.text.SimpleDateFormat;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/scale/size/FrameSizeParam;", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/scale/size/SizeParam;", "unitValue", "", "(F)V", "mSimpleDateFormat", "Ljava/text/SimpleDateFormat;", "getPosition", "timeUs", "getShowStr", "", "", "getTime", "scrollX", "perPx", "Companion", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class FrameSizeParam
  extends SizeParam
{
  public static final FrameSizeParam.Companion a = new FrameSizeParam.Companion(null);
  private final SimpleDateFormat b = new SimpleDateFormat("mm:ss", Locale.US);
  
  public FrameSizeParam(float paramFloat)
  {
    super(paramFloat);
  }
  
  public float a(float paramFloat)
  {
    long l = TimeUtils.a.b(paramFloat);
    float f = (float)TimeUtils.a.a(l);
    return (float)(l * 30) / a() + (paramFloat - f) / 33333.332F / a();
  }
  
  public float a(float paramFloat1, float paramFloat2)
  {
    return paramFloat1 / paramFloat2 * a() * 1000000.0F / 30;
  }
  
  @NotNull
  public String a(long paramLong)
  {
    int i = MathKt.roundToInt((float)paramLong % 1000000.0F / 33333.332F);
    if ((i != 30) && (i != 0))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(String.valueOf(i));
      ((StringBuilder)localObject).append("f");
      return ((StringBuilder)localObject).toString();
    }
    Object localObject = this.b.format(Long.valueOf(TimeUtils.a.c(paramLong)));
    Intrinsics.checkExpressionValueIsNotNull(localObject, "mSimpleDateFormat.format(TimeUtils.usToMs(timeUs))");
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.scale.size.FrameSizeParam
 * JD-Core Version:    0.7.0.1
 */