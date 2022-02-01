package com.tencent.videocut.utils.diff;

import java.util.Comparator;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "o1", "Lcom/tencent/videocut/utils/diff/ModifiedDiffUtils$Snake;", "kotlin.jvm.PlatformType", "o2", "compare"}, k=3, mv={1, 4, 2})
final class ModifiedDiffUtils$SNAKE_COMPARATOR$1<T>
  implements Comparator<ModifiedDiffUtils.Snake>
{
  public static final 1 a = new 1();
  
  public final int a(ModifiedDiffUtils.Snake paramSnake1, ModifiedDiffUtils.Snake paramSnake2)
  {
    int j = paramSnake1.a() - paramSnake2.a();
    int i = j;
    if (j == 0) {
      i = paramSnake1.b() - paramSnake2.b();
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.utils.diff.ModifiedDiffUtils.SNAKE_COMPARATOR.1
 * JD-Core Version:    0.7.0.1
 */