package cooperation.qzone.panorama.util;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import cooperation.qzone.panorama.model.CylinderModel;
import cooperation.qzone.panorama.model.ShapeModel;
import cooperation.qzone.panorama.model.ShapeModel.OnRotateListener;
import cooperation.qzone.panorama.model.SphereModel;
import cooperation.qzone.panorama.piece.PanoramaPieceManager;
import java.util.HashMap;

public class PanoramaConfig$Builder
{
  private boolean isNeedPieceLoad;
  private boolean isOpenGyroscopeSensor;
  private boolean isOpenTouchMove;
  private boolean isShowGuideAnimate;
  private boolean isShowLoadingProgress;
  private boolean isShowPanoramaBall;
  private boolean isTextureChange;
  private int modeType;
  private String originalUrl;
  private HashMap<String, String> panoramaExtra;
  private PanoramaPieceManager panoramaPieceManager;
  private int panoramaType;
  private int renderMode = 1;
  private ShapeModel shapeModel;
  private int showType = 0;
  private String smallUrl;
  private Drawable textureDrawable;
  private String thumbUrl;
  
  public PanoramaConfig$Builder(int paramInt)
  {
    this.modeType = paramInt;
    if (paramInt == 0)
    {
      this.isNeedPieceLoad = false;
      this.shapeModel = new SphereModel(this.isNeedPieceLoad);
    }
    while (paramInt != 2) {
      return;
    }
    this.isNeedPieceLoad = true;
    this.shapeModel = new CylinderModel(this.isNeedPieceLoad);
  }
  
  public int getModeType()
  {
    return this.modeType;
  }
  
  public String getOriginalUrl()
  {
    return this.originalUrl;
  }
  
  public String getPanoramaExtraValue(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.panoramaExtra == null)) {
      return null;
    }
    return (String)this.panoramaExtra.get(paramString);
  }
  
  public PanoramaPieceManager getPanoramaPieceManager()
  {
    return this.panoramaPieceManager;
  }
  
  public int getPanoramaType()
  {
    return this.panoramaType;
  }
  
  public int getRenderMode()
  {
    return this.renderMode;
  }
  
  public ShapeModel getShapeModel()
  {
    return this.shapeModel;
  }
  
  public int getShowType()
  {
    return this.showType;
  }
  
  public String getSmallUrl()
  {
    return this.smallUrl;
  }
  
  public Drawable getTextureDrawable()
  {
    this.isTextureChange = false;
    return this.textureDrawable;
  }
  
  public String getThumbUrl()
  {
    return this.thumbUrl;
  }
  
  public boolean isNeedPieceLoad()
  {
    return this.isNeedPieceLoad;
  }
  
  public boolean isOpenGyroscopeSensor()
  {
    return this.isOpenGyroscopeSensor;
  }
  
  public boolean isOpenTouchMove()
  {
    return this.isOpenTouchMove;
  }
  
  public boolean isShowGuideAnimate()
  {
    return this.isShowGuideAnimate;
  }
  
  public boolean isShowLoadingProgress()
  {
    return this.isShowLoadingProgress;
  }
  
  public boolean isShowPanoramaBall()
  {
    return this.isShowPanoramaBall;
  }
  
  public boolean isTextureChange()
  {
    return this.isTextureChange;
  }
  
  public Builder setModeType(int paramInt)
  {
    this.modeType = paramInt;
    return this;
  }
  
  public Builder setOnRotateListener(ShapeModel.OnRotateListener paramOnRotateListener)
  {
    if ((this.shapeModel != null) && (paramOnRotateListener != null)) {
      this.shapeModel.setOnRotateListener(paramOnRotateListener);
    }
    return this;
  }
  
  public Builder setOpenGyroscopeSensor(boolean paramBoolean)
  {
    this.isOpenGyroscopeSensor = paramBoolean;
    return this;
  }
  
  public Builder setOpenTouchMove(boolean paramBoolean)
  {
    this.isOpenTouchMove = paramBoolean;
    return this;
  }
  
  public Builder setOriginalUrl(String paramString)
  {
    this.originalUrl = paramString;
    return this;
  }
  
  public Builder setPanoramaExtra(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return this;
    }
    if (this.panoramaExtra == null) {
      this.panoramaExtra = new HashMap();
    }
    this.panoramaExtra.put(paramString1, paramString2);
    return this;
  }
  
  public void setPanoramaPieceManager(PanoramaPieceManager paramPanoramaPieceManager)
  {
    this.panoramaPieceManager = paramPanoramaPieceManager;
    if (this.shapeModel != null) {
      this.shapeModel.setPanoramaTouchListener(paramPanoramaPieceManager);
    }
  }
  
  public Builder setPanoramaType(int paramInt)
  {
    this.panoramaType = paramInt;
    return this;
  }
  
  public Builder setRenderMode(int paramInt)
  {
    this.renderMode = paramInt;
    return this;
  }
  
  public Builder setShowGuideAnimate(boolean paramBoolean)
  {
    this.isShowGuideAnimate = paramBoolean;
    return this;
  }
  
  public Builder setShowLoadingProgress(boolean paramBoolean)
  {
    this.isShowLoadingProgress = paramBoolean;
    return this;
  }
  
  public Builder setShowPanoramaBall(boolean paramBoolean)
  {
    this.isShowPanoramaBall = paramBoolean;
    return this;
  }
  
  public Builder setShowType(int paramInt)
  {
    this.showType = paramInt;
    if (this.shapeModel != null) {
      this.shapeModel.setShowType(paramInt);
    }
    return this;
  }
  
  public Builder setSmallUrl(String paramString)
  {
    this.smallUrl = paramString;
    return this;
  }
  
  public void setTextureChange(boolean paramBoolean)
  {
    this.isTextureChange = paramBoolean;
  }
  
  public Builder setTextureDrawable(Drawable paramDrawable)
  {
    this.textureDrawable = paramDrawable;
    this.isTextureChange = true;
    if ((paramDrawable != null) && (this.shapeModel != null)) {
      this.shapeModel.setImageSize(paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight());
    }
    return this;
  }
  
  public Builder setThumbUrl(String paramString)
  {
    this.thumbUrl = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.panorama.util.PanoramaConfig.Builder
 * JD-Core Version:    0.7.0.1
 */