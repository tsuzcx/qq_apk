package com.tencent.weseevideo.model.template.light;

import android.graphics.RectF;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import android.text.TextUtils;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tavcut.util.Logger;
import com.tencent.weseevideo.model.template.movie.MovieSegmentModel;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.light.LightAsset;
import org.light.LightEngine;
import org.light.MovieController;

public class LightTemplate
  implements Serializable
{
  private static final String TAG = "LightTemplate";
  private boolean isNoDurationLimitTemplate = false;
  private HashMap<String, RectF> mBoundsRect = new HashMap();
  private long mDuration = 0L;
  private String mFilePath;
  private LightAsset mLightAsset;
  private LightEngine mLightEngine;
  private MovieController mMovieController;
  private boolean mNeedCycleFill = false;
  private ArrayList<MovieSegmentModel> mSegmentModels = new ArrayList();
  private CGSize renderSize = new CGSize(720.0F, 1280.0F);
  private TextureInfo textureInfo;
  
  public LightTemplate(@NonNull String paramString)
  {
    initData(paramString);
  }
  
  public HashMap<String, RectF> getBoundsRect()
  {
    return this.mBoundsRect;
  }
  
  public long getDuration()
  {
    return this.mDuration;
  }
  
  public String getFilePath()
  {
    return this.mFilePath;
  }
  
  public LightAsset getLightAsset()
  {
    return this.mLightAsset;
  }
  
  @NotNull
  public LightEngine getLightEngine()
  {
    return this.mLightEngine;
  }
  
  public ArrayList<MovieSegmentModel> getLightSegments()
  {
    return this.mSegmentModels;
  }
  
  @NotNull
  public MovieController getMovieController()
  {
    return this.mMovieController;
  }
  
  @NotNull
  public CGSize getRenderSize()
  {
    return this.renderSize;
  }
  
  public List<MovieSegmentModel> getSegments()
  {
    return this.mSegmentModels;
  }
  
  public TextureInfo getTextureInfo()
  {
    return this.textureInfo;
  }
  
  @VisibleForTesting
  protected void initData(@NonNull String paramString)
  {
    this.mFilePath = paramString;
    if (TextUtils.isEmpty(this.mFilePath))
    {
      Logger.e("LightTemplate", "LightTemplate initData failed. template file path is empty!! ");
      return;
    }
    this.mLightAsset = LightAsset.Load(this.mFilePath, 100);
    if (this.mLightAsset == null)
    {
      Logger.e("LightTemplate", "LightAsset.Load return null! mFilePath=" + this.mFilePath);
      return;
    }
    this.renderSize = new CGSize(this.mLightAsset.width(), this.mLightAsset.height());
  }
  
  public boolean isNoDurationLimitTemplate()
  {
    return this.isNoDurationLimitTemplate;
  }
  
  public void setDuration(long paramLong)
  {
    this.mDuration = paramLong;
  }
  
  public void setFilePath(String paramString)
  {
    this.mFilePath = paramString;
  }
  
  public void setLightEngine(LightEngine paramLightEngine)
  {
    this.mLightEngine = paramLightEngine;
  }
  
  public void setLightSegments(ArrayList<MovieSegmentModel> paramArrayList)
  {
    this.mSegmentModels = paramArrayList;
  }
  
  public void setMovieController(MovieController paramMovieController)
  {
    this.mMovieController = paramMovieController;
  }
  
  public void setNoDurationLimitTemplate(boolean paramBoolean)
  {
    this.isNoDurationLimitTemplate = paramBoolean;
  }
  
  public void setRenderSize(CGSize paramCGSize)
  {
    this.renderSize = paramCGSize;
  }
  
  public void setSegments(List<MovieSegmentModel> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      this.mSegmentModels.clear();
      this.mSegmentModels.addAll(paramList);
    }
  }
  
  public void setTextureInfo(TextureInfo paramTextureInfo)
  {
    this.textureInfo = paramTextureInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.weseevideo.model.template.light.LightTemplate
 * JD-Core Version:    0.7.0.1
 */