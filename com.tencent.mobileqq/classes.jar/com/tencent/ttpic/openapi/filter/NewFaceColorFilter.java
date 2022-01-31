package com.tencent.ttpic.openapi.filter;

import com.tencent.filter.TextureResParam;
import com.tencent.filter.ttpic.GPUImageLookupFilter;

public class NewFaceColorFilter
  extends GPUImageLookupFilter
{
  public NewFaceColorFilter()
  {
    addParam(new TextureResParam("inputImageTexture2", "realtimeBeauty/facecolor.png", 33986));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.NewFaceColorFilter
 * JD-Core Version:    0.7.0.1
 */