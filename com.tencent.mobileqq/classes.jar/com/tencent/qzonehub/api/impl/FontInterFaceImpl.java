package com.tencent.qzonehub.api.impl;

import com.tencent.qzonehub.api.IFontInterface;
import com.tencent.qzonehub.api.IFullTypeResult;
import com.tencent.qzonehub.api.ITrueTypeResult;
import com.tencent.qzonehub.api.font.FontInterface;

public class FontInterFaceImpl
  implements IFontInterface
{
  public String getFullTypeFont(int paramInt, String paramString1, String paramString2, IFullTypeResult paramIFullTypeResult)
  {
    return FontInterface.a(paramInt, paramString1, paramString2, new FontInterFaceImpl.1(this, paramIFullTypeResult));
  }
  
  public String getTrueTypeFont(int paramInt, String paramString1, String paramString2, boolean paramBoolean, ITrueTypeResult paramITrueTypeResult)
  {
    return FontInterface.a(paramInt, paramString1, paramString2, paramBoolean, new FontInterFaceImpl.2(this, paramITrueTypeResult));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qzonehub.api.impl.FontInterFaceImpl
 * JD-Core Version:    0.7.0.1
 */