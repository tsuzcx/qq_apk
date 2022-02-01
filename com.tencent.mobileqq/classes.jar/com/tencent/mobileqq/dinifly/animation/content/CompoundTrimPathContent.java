package com.tencent.mobileqq.dinifly.animation.content;

import android.graphics.Path;
import com.tencent.mobileqq.dinifly.utils.Utils;
import java.util.ArrayList;
import java.util.List;

public class CompoundTrimPathContent
{
  private List<TrimPathContent> contents = new ArrayList();
  
  void addTrimPath(TrimPathContent paramTrimPathContent)
  {
    this.contents.add(paramTrimPathContent);
  }
  
  public void apply(Path paramPath)
  {
    int i = this.contents.size() - 1;
    while (i >= 0)
    {
      Utils.applyTrimPathIfNeeded(paramPath, (TrimPathContent)this.contents.get(i));
      i -= 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.animation.content.CompoundTrimPathContent
 * JD-Core Version:    0.7.0.1
 */