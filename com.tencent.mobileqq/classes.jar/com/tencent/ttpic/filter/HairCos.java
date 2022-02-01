package com.tencent.ttpic.filter;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.opengl.GLES20;
import com.tencent.aekit.openrender.internal.AEFilterI;
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
import java.util.Map;

public class HairCos
  implements AEFilterI
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
  private Map<String, Integer> renderHairItemMaps;
  
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
  
  public Frame RenderProcess(Frame paramFrame)
  {
    return paramFrame;
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
    Object localObject1 = paramPTHairAttr.getMaskFrame();
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
    if (localObject1 == null)
    {
      localObject1 = paramPTHairAttr.getMaskBitmap();
      GlUtil.loadTexture(this.mTextureTmp[0], (Bitmap)localObject1);
      this.mCopyFilter.RenderProcess(this.mTextureTmp[0], ((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight(), -1, 0.0D, this.maskFrame);
      localObject1 = paramPTHairAttr.getHairRect();
      arrayOfPointF = paramPTHairAttr.getMaskYYAnchor();
      f3 = paramPTHairAttr.getMaterialCrop();
      f2 = 0.0F;
      f1 = 0.0F;
      if (f3 <= 1.0F) {
        break label492;
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
        break label503;
      }
      this.mDarkLUT.updateAlpha(Math.min(Math.max((j - 200) / 500.0F - (i - 60) / 25.0F, 0.0F), 1.0F));
      paramPTHairAttr = this.mDarkLUT.render(paramFrame, (PointF[])localObject1, arrayOfPointF, this.maskFrame.getTextureId());
    }
    Object localObject2;
    for (;;)
    {
      i = 0;
      while (i < this.mLUTList.size())
      {
        localObject2 = (HairDecolor)this.mLUTList.get(i);
        paramFrame = paramPTHairAttr;
        if (this.renderHairItemMaps.containsKey(((HairDecolor)localObject2).getItemID())) {
          paramFrame = ((HairDecolor)localObject2).render(paramPTHairAttr, (PointF[])localObject1, arrayOfPointF, this.maskFrame.getTextureId());
        }
        i += 1;
        paramPTHairAttr = paramFrame;
      }
      this.mCopyFilter.RenderProcess(((Frame)localObject1).getTextureId(), ((Frame)localObject1).width, ((Frame)localObject1).height, -1, 0.0D, this.maskFrame);
      break;
      label492:
      f2 = (1.0F - f3) / 2.0F;
      break label98;
      label503:
      paramPTHairAttr = paramFrame;
      if (i > 90) {
        if (j - i < 0)
        {
          this.mLightLUT.updateAlpha(1.0F);
          paramPTHairAttr = this.mLightLUT.render(paramFrame, (PointF[])localObject1, arrayOfPointF, this.maskFrame.getTextureId());
        }
        else
        {
          paramPTHairAttr = this.mLightLUT;
          float f25 = (200 - j) / 200.0F;
          paramPTHairAttr.updateAlpha(Math.min(Math.max((i - 90) / 25.0F + f25, 0.0F), 1.0F));
          paramPTHairAttr = this.mLightLUT.render(paramFrame, (PointF[])localObject1, arrayOfPointF, this.maskFrame.getTextureId());
        }
      }
    }
    int i = 0;
    if (i < this.mItemList.size())
    {
      localObject2 = (HairSticker)this.mItemList.get(i);
      paramFrame = paramPTHairAttr;
      if (this.renderHairItemMaps.containsKey(((HairSticker)localObject2).getItemID()))
      {
        ((HairSticker)localObject2).updatePreview(paramPTDetectInfo, paramInt, ((Integer)this.renderHairItemMaps.get(((HairSticker)localObject2).getItemID())).intValue());
        if (!((Boolean)this.needCropList.get(i)).booleanValue()) {
          break label999;
        }
        j = this.maskFrame.getTextureId();
      }
      for (paramFrame = ((HairSticker)localObject2).render(paramPTHairAttr, (PointF[])localObject1, arrayOfPointF, new float[] { f14 * (1.0F - 2.0F * f2) + f2, f1, f15 * (1.0F - 2.0F * f2) + f2, f16 * (1.0F - 2.0F * f1) + f1, f2, f1, f17 * (1.0F - 2.0F * f2) + f2, f18 * (1.0F - 2.0F * f1) + f1, f2, 1.0F - f1, f19 * (1.0F - 2.0F * f2) + f2, 1.0F - f1, 1.0F - f2, 1.0F - f1, f20 * (1.0F - 2.0F * f2) + f2, f21 * (1.0F - 2.0F * f1) + f1, 1.0F - f2, f1, f22 * (1.0F - 2.0F * f2) + f2, f23 * (1.0F - 2.0F * f1) + f1, f2 + f24 * (1.0F - 2.0F * f2), f1 }, j);; paramFrame = ((HairSticker)localObject2).render(paramPTHairAttr, (PointF[])localObject1, arrayOfPointF, new float[] { f3, 0.0F, f4, f5, 0.0F, 0.0F, f6, f7, 0.0F, 1.0F, f8, 1.0F, 1.0F, 1.0F, f9, f10, 1.0F, 0.0F, f11, f12, f13, 0.0F }, j))
      {
        i += 1;
        paramPTHairAttr = paramFrame;
        break;
        label999:
        j = this.maskFrame.getTextureId();
      }
    }
    return paramPTHairAttr;
  }
  
  public void setRenderHairItemMaps(Map<String, Integer> paramMap)
  {
    this.renderHairItemMaps = paramMap;
  }
  
  public void stopRender()
  {
    int i = 0;
    while (i < this.mItemList.size())
    {
      ((HairSticker)this.mItemList.get(i)).stopRender();
      i += 1;
    }
  }
  
  public void updatePreview(Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.filter.HairCos
 * JD-Core Version:    0.7.0.1
 */