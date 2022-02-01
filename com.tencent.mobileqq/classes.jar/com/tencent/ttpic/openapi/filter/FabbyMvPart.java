package com.tencent.ttpic.openapi.filter;

import android.graphics.PointF;
import android.util.Pair;
import com.tencent.ttpic.fabby.FabbyUtil;
import com.tencent.ttpic.model.GridSettingModel;
import com.tencent.ttpic.model.ShakaEffectItem;
import com.tencent.ttpic.openapi.model.StickerItem;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FabbyMvPart
{
  public List<Pair<Float, Double>> alphaMap = new ArrayList();
  public List<Pair<Float, Double>> anchorXMap = new ArrayList();
  public List<Pair<Float, Double>> anchorYMap = new ArrayList();
  public String audio;
  public float bgFilterAlpha;
  public String bgFilterId;
  public StickerItem bgItem;
  public String bgLutFile;
  public List<Pair<Float, Double>> blurDirectionMap = new ArrayList();
  public List<Pair<Float, Double>> blurRadiusMap = new ArrayList();
  public StickerItem coverItem;
  public List<Pair<Float, Double>> degreeMap = new ArrayList();
  public long duration;
  public int easeCurve = 0;
  public float fgFilterAlpha;
  public String fgFilterId;
  public StickerItem fgItem;
  public String fgLutFile;
  public float filterAlpha;
  public String filterId;
  public List<Pair<Float, Integer>> filterParamMap = new ArrayList();
  public int filterType;
  public List<Pair<Float, Integer>> gridModeMap = new ArrayList();
  public List<Pair<Float, Integer>> gridOrderMap = new ArrayList();
  public List<Pair<Float, GridSettingModel>> gridSettingMap = new ArrayList();
  public List<Pair<Float, Integer>> gridTypeMap = new ArrayList();
  public List<Pair<Float, Double>> isRelativeXMap = new ArrayList();
  public List<Pair<Float, Double>> isRelativeYMap = new ArrayList();
  public String lutFile;
  public int partIndex;
  public List<Pair<Float, Double>> scaleMap = new ArrayList();
  private ShakaEffectItem shakaEffectItem;
  public long transitionDuration;
  public int transitionEase;
  public int transitionFunction;
  public StickerItem transitionItem;
  public int transitionMaskType = 1;
  public List<Pair<Float, Double>> translateXMap = new ArrayList();
  public List<Pair<Float, Double>> translateYMap = new ArrayList();
  public int triggerDelay;
  
  public double getAlpha(float paramFloat)
  {
    return FabbyUtil.getRangeValue(this.easeCurve, paramFloat, this.alphaMap, 1.0D);
  }
  
  public PointF getAnchor(float paramFloat)
  {
    PointF localPointF = new PointF();
    localPointF.x = ((float)FabbyUtil.getRangeValue(this.easeCurve, paramFloat, this.anchorXMap, 0.0D));
    localPointF.y = ((float)FabbyUtil.getRangeValue(this.easeCurve, paramFloat, this.anchorYMap, 0.0D));
    return localPointF;
  }
  
  public PointF getAnchor(float paramFloat, boolean paramBoolean1, boolean paramBoolean2)
  {
    PointF localPointF = getAnchor(paramFloat);
    if (paramBoolean1)
    {
      paramFloat = localPointF.x * 2.0F - 1.0F;
      localPointF.x = paramFloat;
      if (!paramBoolean2) {
        break label59;
      }
    }
    label59:
    for (paramFloat = localPointF.y * 2.0F - 1.0F;; paramFloat = localPointF.y)
    {
      localPointF.y = paramFloat;
      return localPointF;
      paramFloat = localPointF.x;
      break;
    }
  }
  
  public double getBlurAngle(float paramFloat)
  {
    return FabbyUtil.getRangeValue(this.easeCurve, paramFloat, this.blurDirectionMap, 0.0D);
  }
  
  public double getBlurSize(float paramFloat)
  {
    return FabbyUtil.getRangeValue(this.easeCurve, paramFloat, this.blurRadiusMap, 0.0D);
  }
  
  public double getDegree(float paramFloat)
  {
    return FabbyUtil.getRangeValue(this.easeCurve, paramFloat, this.degreeMap, 0.0D);
  }
  
  public int getFilterParam(float paramFloat)
  {
    return FabbyUtil.getDivideValue(paramFloat, this.filterParamMap, 1);
  }
  
  public int getGridMode(float paramFloat)
  {
    return FabbyUtil.getDivideValue(paramFloat, this.gridModeMap, 0);
  }
  
  public int getGridOrder(float paramFloat)
  {
    return FabbyUtil.getDivideValue(paramFloat, this.gridOrderMap, 0);
  }
  
  public GridSettingModel getGridSetting(float paramFloat)
  {
    return FabbyUtil.getGridSetting(paramFloat, this.gridSettingMap, null);
  }
  
  public int getGridType(float paramFloat)
  {
    return FabbyUtil.getDivideValue(paramFloat, this.gridTypeMap, 0);
  }
  
  public double getScale(float paramFloat)
  {
    return FabbyUtil.getRangeValue(this.easeCurve, paramFloat, this.scaleMap, 1.0D);
  }
  
  public ShakaEffectItem getShakaEffectItem()
  {
    return this.shakaEffectItem;
  }
  
  public Map<String, Float> getShakaValueMap(float paramFloat)
  {
    return this.shakaEffectItem.getValueMap(this.easeCurve, paramFloat);
  }
  
  public PointF getTranslate(float paramFloat)
  {
    PointF localPointF = new PointF();
    localPointF.x = ((float)FabbyUtil.getRangeValue(this.easeCurve, paramFloat, this.translateXMap, 0.0D));
    localPointF.y = ((float)FabbyUtil.getRangeValue(this.easeCurve, paramFloat, this.translateYMap, 0.0D));
    return localPointF;
  }
  
  public PointF getTranslate(float paramFloat, boolean paramBoolean1, boolean paramBoolean2)
  {
    PointF localPointF = getTranslate(paramFloat);
    if (paramBoolean1)
    {
      paramFloat = localPointF.x * 2.0F - 1.0F;
      localPointF.x = paramFloat;
      if (!paramBoolean2) {
        break label59;
      }
    }
    label59:
    for (paramFloat = localPointF.y * 2.0F - 1.0F;; paramFloat = localPointF.y)
    {
      localPointF.y = paramFloat;
      return localPointF;
      paramFloat = localPointF.x;
      break;
    }
  }
  
  public boolean isUseScaleHeightY(float paramFloat)
  {
    return FabbyUtil.getRangeValue(this.easeCurve, paramFloat, this.isRelativeYMap, 0.0D) > 0.0D;
  }
  
  public boolean isUseScaleWidthX(float paramFloat)
  {
    return FabbyUtil.getRangeValue(this.easeCurve, paramFloat, this.isRelativeXMap, 0.0D) > 0.0D;
  }
  
  public void setShakaEffectItem(ShakaEffectItem paramShakaEffectItem)
  {
    this.shakaEffectItem = paramShakaEffectItem;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.FabbyMvPart
 * JD-Core Version:    0.7.0.1
 */