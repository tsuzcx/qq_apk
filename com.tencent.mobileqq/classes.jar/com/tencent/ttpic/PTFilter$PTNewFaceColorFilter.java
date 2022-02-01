package com.tencent.ttpic;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.TextureResParam;
import com.tencent.ttpic.openapi.filter.NewFaceColorFilter;

public class PTFilter$PTNewFaceColorFilter
  extends PTFilter
{
  public PTFilter$PTNewFaceColorFilter()
  {
    this.mFilter = new NewFaceColorFilter();
  }
  
  public int init()
  {
    int i = super.init();
    new TextureResParam("inputImageTexture2", "sh/facecolor_b.png", 33986).initialParams(this.mFilter.getProgramIds());
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.PTFilter.PTNewFaceColorFilter
 * JD-Core Version:    0.7.0.1
 */