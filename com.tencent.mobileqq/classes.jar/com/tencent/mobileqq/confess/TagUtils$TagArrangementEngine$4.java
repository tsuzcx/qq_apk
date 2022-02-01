package com.tencent.mobileqq.confess;

import java.util.ArrayList;
import java.util.Comparator;

class TagUtils$TagArrangementEngine$4
  implements Comparator<TagUtils.TagOriginal>
{
  TagUtils$TagArrangementEngine$4(TagUtils.TagArrangementEngine paramTagArrangementEngine, boolean paramBoolean, ArrayList paramArrayList) {}
  
  public int a(TagUtils.TagOriginal paramTagOriginal1, TagUtils.TagOriginal paramTagOriginal2)
  {
    int j = paramTagOriginal1.b;
    int k = paramTagOriginal2.b;
    int i = 1;
    if (j > k) {
      return 1;
    }
    if (paramTagOriginal1.b < paramTagOriginal2.b) {
      return -1;
    }
    if ((paramTagOriginal1.c) && (!paramTagOriginal2.c))
    {
      if (this.a) {
        i = -1;
      }
      return i;
    }
    if ((!paramTagOriginal1.c) && (paramTagOriginal2.c))
    {
      if (this.a) {
        return 1;
      }
      return -1;
    }
    if ((this.b.size() > 3) && (Math.abs(paramTagOriginal1.e - paramTagOriginal2.e) > 3.0F)) {
      return Float.compare(paramTagOriginal1.e, paramTagOriginal2.e);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.confess.TagUtils.TagArrangementEngine.4
 * JD-Core Version:    0.7.0.1
 */