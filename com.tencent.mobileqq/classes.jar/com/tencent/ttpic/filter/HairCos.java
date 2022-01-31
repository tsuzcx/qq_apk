package com.tencent.ttpic.filter;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.opengl.GLES20;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.openapi.PTDetectInfo;
import com.tencent.ttpic.openapi.PTHairAttr;
import com.tencent.ttpic.openapi.model.StickerItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HairCos
{
  private String darkLUTName = "dark.png";
  private String hairMaskName = "hairmask.png";
  private String lightLUTName = "light.png";
  private VideoFilterBase mCopyFilter = new VideoFilterBase(BaseFilter.getFragmentShader(0));
  private HairDecolor mDarkLUT;
  private List<HairSticker> mItemList = new ArrayList();
  private List<HairDecolor> mLUTList = new ArrayList();
  private HairDecolor mLightLUT;
  private int[] mTextureTmp = new int[1];
  private Frame maskFrame = new Frame();
  private List<Boolean> needCropList = new ArrayList();
  
  public HairCos(List<StickerItem> paramList, String paramString)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      StickerItem localStickerItem = (StickerItem)paramList.next();
      if (!localStickerItem.hairLutName.equals(""))
      {
        this.mLUTList.add(new HairDecolor(localStickerItem, paramString, this.hairMaskName, 2.0F - localStickerItem.hairMaskType.intValue()));
      }
      else
      {
        List localList = this.needCropList;
        if (localStickerItem.needCrop == 1) {}
        for (boolean bool = true;; bool = false)
        {
          localList.add(Boolean.valueOf(bool));
          this.mItemList.add(new HairSticker(localStickerItem, paramString + "/" + this.hairMaskName, 2.0F - localStickerItem.hairMaskType.intValue()));
          break;
        }
      }
    }
    this.mDarkLUT = new HairDecolor(paramString, this.darkLUTName);
    this.mLightLUT = new HairDecolor(paramString, this.lightLUTName);
  }
  
  public void ApplyGLSLFilter()
  {
    Iterator localIterator = this.mLUTList.iterator();
    while (localIterator.hasNext()) {
      ((HairDecolor)localIterator.next()).ApplyGLSLFilter();
    }
    this.mDarkLUT.ApplyGLSLFilter();
    this.mLightLUT.ApplyGLSLFilter();
    this.mCopyFilter.ApplyGLSLFilter();
    localIterator = this.mItemList.iterator();
    while (localIterator.hasNext()) {
      ((HairSticker)localIterator.next()).ApplyGLSLFilter();
    }
    GLES20.glGenTextures(this.mTextureTmp.length, this.mTextureTmp, 0);
  }
  
  public void clearGLSLSelf()
  {
    Iterator localIterator = this.mLUTList.iterator();
    while (localIterator.hasNext()) {
      ((HairDecolor)localIterator.next()).clearGLSLSelf();
    }
    this.mCopyFilter.clearGLSLSelf();
    this.mDarkLUT.clearGLSLSelf();
    this.mLightLUT.clearGLSLSelf();
    localIterator = this.mItemList.iterator();
    while (localIterator.hasNext()) {
      ((HairSticker)localIterator.next()).clearGLSLSelf();
    }
    this.maskFrame.clear();
    GLES20.glDeleteTextures(this.mTextureTmp.length, this.mTextureTmp, 0);
  }
  
  public List<HairSticker> getmItemList()
  {
    return this.mItemList;
  }
  
  public List<HairDecolor> getmLUTList()
  {
    return this.mLUTList;
  }
  
  public Frame render(Frame paramFrame, PTHairAttr paramPTHairAttr, PTDetectInfo paramPTDetectInfo, int paramInt)
  {
    Object localObject = paramPTHairAttr.getMaskFrame();
    PointF[] arrayOfPointF;
    float f3;
    float f2;
    float f1;
    label98:
    float f4;
    float f5;
    float f6;
    float f7;
    float f8;
    float f9;
    float f10;
    float f11;
    float f12;
    float f13;
    float f14;
    float f15;
    float f16;
    float f17;
    float f18;
    float f19;
    float f20;
    float f21;
    float f22;
    float f23;
    float f24;
    int j;
    if (localObject == null)
    {
      localObject = paramPTHairAttr.getMaskBitmap();
      GlUtil.loadTexture(this.mTextureTmp[0], (Bitmap)localObject);
      this.mCopyFilter.RenderProcess(this.mTextureTmp[0], ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight(), -1, 0.0D, this.maskFrame);
      localObject = paramPTHairAttr.getHairRect();
      arrayOfPointF = paramPTHairAttr.getMaskYYAnchor();
      f3 = paramPTHairAttr.getMaterialCrop();
      f2 = 0.0F;
      f1 = 0.0F;
      if (f3 <= 1.0F) {
        break label476;
      }
      f1 = (1.0F - 1.0F / f3) / 2.0F;
      f3 = arrayOfPointF[4].x;
      f4 = arrayOfPointF[5].x;
      f5 = arrayOfPointF[5].y;
      f6 = arrayOfPointF[6].x;
      f7 = arrayOfPointF[6].y;
      f8 = arrayOfPointF[7].x;
      f9 = arrayOfPointF[6].x;
      f10 = arrayOfPointF[6].y;
      f11 = arrayOfPointF[5].x;
      f12 = arrayOfPointF[5].y;
      f13 = arrayOfPointF[4].x;
      f14 = arrayOfPointF[4].x;
      f15 = arrayOfPointF[5].x;
      f16 = arrayOfPointF[5].y;
      f17 = arrayOfPointF[6].x;
      f18 = arrayOfPointF[6].y;
      f19 = arrayOfPointF[7].x;
      f20 = arrayOfPointF[6].x;
      f21 = arrayOfPointF[6].y;
      f22 = arrayOfPointF[5].x;
      f23 = arrayOfPointF[5].y;
      f24 = arrayOfPointF[4].x;
      i = paramPTHairAttr.getHairBright();
      j = paramPTHairAttr.getFaceBright();
      if (i >= 60) {
        break label487;
      }
      this.mDarkLUT.updateAlpha(Math.min(Math.max((j - 200) / 500.0F - (i - 60) / 25.0F, 0.0F), 1.0F));
      paramPTHairAttr = this.mDarkLUT.render(paramFrame, (PointF[])localObject, arrayOfPointF, this.maskFrame.getTextureId());
    }
    for (;;)
    {
      i = 0;
      while (i < this.mLUTList.size())
      {
        paramFrame = (HairDecolor)this.mLUTList.get(i);
        paramFrame.updateActionTriggered(paramPTDetectInfo, paramInt);
        paramPTHairAttr = paramFrame.render(paramPTHairAttr, (PointF[])localObject, arrayOfPointF, this.maskFrame.getTextureId());
        i += 1;
      }
      this.mCopyFilter.RenderProcess(((Frame)localObject).getTextureId(), ((Frame)localObject).width, ((Frame)localObject).height, -1, 0.0D, this.maskFrame);
      break;
      label476:
      f2 = (1.0F - f3) / 2.0F;
      break label98;
      label487:
      paramPTHairAttr = paramFrame;
      if (i > 90) {
        if (j - i < 0)
        {
          this.mLightLUT.updateAlpha(1.0F);
          paramPTHairAttr = this.mLightLUT.render(paramFrame, (PointF[])localObject, arrayOfPointF, this.maskFrame.getTextureId());
        }
        else
        {
          paramPTHairAttr = this.mLightLUT;
          float f25 = (200 - j) / 200.0F;
          paramPTHairAttr.updateAlpha(Math.min(Math.max((i - 90) / 25.0F + f25, 0.0F), 1.0F));
          paramPTHairAttr = this.mLightLUT.render(paramFrame, (PointF[])localObject, arrayOfPointF, this.maskFrame.getTextureId());
        }
      }
    }
    int i = 0;
    paramFrame = paramPTHairAttr;
    if (i < this.mItemList.size())
    {
      paramPTHairAttr = (HairSticker)this.mItemList.get(i);
      paramPTHairAttr.updatePreview(paramPTDetectInfo, paramInt);
      if (((Boolean)this.needCropList.get(i)).booleanValue()) {
        j = this.maskFrame.getTextureId();
      }
      for (paramFrame = paramPTHairAttr.render(paramFrame, (PointF[])localObject, arrayOfPointF, new float[] { f14 * (1.0F - 2.0F * f2) + f2, f1, f15 * (1.0F - 2.0F * f2) + f2, f16 * (1.0F - 2.0F * f1) + f1, f2, f1, f17 * (1.0F - 2.0F * f2) + f2, f18 * (1.0F - 2.0F * f1) + f1, f2, 1.0F - f1, f19 * (1.0F - 2.0F * f2) + f2, 1.0F - f1, 1.0F - f2, 1.0F - f1, f20 * (1.0F - 2.0F * f2) + f2, f21 * (1.0F - 2.0F * f1) + f1, 1.0F - f2, f1, f22 * (1.0F - 2.0F * f2) + f2, f23 * (1.0F - 2.0F * f1) + f1, f2 + f24 * (1.0F - 2.0F * f2), f1 }, j);; paramFrame = paramPTHairAttr.render(paramFrame, (PointF[])localObject, arrayOfPointF, new float[] { f3, 0.0F, f4, f5, 0.0F, 0.0F, f6, f7, 0.0F, 1.0F, f8, 1.0F, 1.0F, 1.0F, f9, f10, 1.0F, 0.0F, f11, f12, f13, 0.0F }, j))
      {
        i += 1;
        break;
        j = this.maskFrame.getTextureId();
      }
    }
    return paramFrame;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.filter.HairCos
 * JD-Core Version:    0.7.0.1
 */