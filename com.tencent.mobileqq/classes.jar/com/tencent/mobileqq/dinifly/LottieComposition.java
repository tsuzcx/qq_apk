package com.tencent.mobileqq.dinifly;

import android.graphics.Rect;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import com.tencent.mobileqq.dinifly.model.Font;
import com.tencent.mobileqq.dinifly.model.FontCharacter;
import com.tencent.mobileqq.dinifly.model.Marker;
import com.tencent.mobileqq.dinifly.model.layer.CompositionLayer;
import com.tencent.mobileqq.dinifly.model.layer.Layer;
import com.tencent.mobileqq.dinifly.utils.Logger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class LottieComposition
{
  private Rect bounds;
  private SparseArrayCompat<FontCharacter> characters;
  public CompositionLayer compositionLayer;
  private float endFrame;
  private Map<String, Font> fonts;
  private float frameRate;
  private boolean hasDashPattern;
  public Map<String, LottieImageAsset> images;
  public LayerInfo layerInfo = new LayerInfo();
  private LongSparseArray<Layer> layerMap;
  private List<Layer> layers;
  private List<Marker> markers;
  private int maskAndMatteCount = 0;
  private final PerformanceTracker performanceTracker = new PerformanceTracker();
  private Map<String, List<Layer>> precomps;
  private float startFrame;
  private final HashSet<String> warnings = new HashSet();
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
  public void addWarning(String paramString)
  {
    Logger.warning(paramString);
    this.warnings.add(paramString);
  }
  
  public Rect getBounds()
  {
    return this.bounds;
  }
  
  public SparseArrayCompat<FontCharacter> getCharacters()
  {
    return this.characters;
  }
  
  public long getDuration()
  {
    return (getDurationFrames() / this.frameRate * 1000.0F);
  }
  
  public float getDurationFrames()
  {
    return this.endFrame - this.startFrame;
  }
  
  public float getEndFrame()
  {
    return this.endFrame;
  }
  
  public Map<String, Font> getFonts()
  {
    return this.fonts;
  }
  
  public float getFrameRate()
  {
    return this.frameRate;
  }
  
  public Map<String, LottieImageAsset> getImages()
  {
    return this.images;
  }
  
  public List<Layer> getLayers()
  {
    return this.layers;
  }
  
  @Nullable
  public Marker getMarker(String paramString)
  {
    int j = this.markers.size();
    int i = 0;
    while (i < j)
    {
      Marker localMarker = (Marker)this.markers.get(i);
      if (localMarker.matchesName(paramString)) {
        return localMarker;
      }
      i += 1;
    }
    return null;
  }
  
  public List<Marker> getMarkers()
  {
    return this.markers;
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
  public int getMaskAndMatteCount()
  {
    return this.maskAndMatteCount;
  }
  
  public PerformanceTracker getPerformanceTracker()
  {
    return this.performanceTracker;
  }
  
  @Nullable
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
  public List<Layer> getPrecomps(String paramString)
  {
    return (List)this.precomps.get(paramString);
  }
  
  public float getStartFrame()
  {
    return this.startFrame;
  }
  
  public ArrayList<String> getWarnings()
  {
    HashSet localHashSet = this.warnings;
    return new ArrayList(Arrays.asList(localHashSet.toArray(new String[localHashSet.size()])));
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
  public boolean hasDashPattern()
  {
    return this.hasDashPattern;
  }
  
  public boolean hasImages()
  {
    return this.images.isEmpty() ^ true;
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
  public void incrementMatteOrMaskCount(int paramInt)
  {
    this.maskAndMatteCount += paramInt;
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
  public void init(Rect paramRect, float paramFloat1, float paramFloat2, float paramFloat3, List<Layer> paramList, LongSparseArray<Layer> paramLongSparseArray, Map<String, List<Layer>> paramMap, Map<String, LottieImageAsset> paramMap1, SparseArrayCompat<FontCharacter> paramSparseArrayCompat, Map<String, Font> paramMap2, List<Marker> paramList1)
  {
    this.bounds = paramRect;
    this.startFrame = paramFloat1;
    this.endFrame = paramFloat2;
    this.frameRate = paramFloat3;
    this.layers = paramList;
    this.layerMap = paramLongSparseArray;
    this.precomps = paramMap;
    this.images = paramMap1;
    this.characters = paramSparseArrayCompat;
    this.fonts = paramMap2;
    this.markers = paramList1;
  }
  
  @RequiresApi(api=16)
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
  public Layer layerModelForId(long paramLong)
  {
    return (Layer)this.layerMap.get(paramLong);
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
  public void setHasDashPattern(boolean paramBoolean)
  {
    this.hasDashPattern = paramBoolean;
  }
  
  public void setPerformanceTrackingEnabled(boolean paramBoolean)
  {
    this.performanceTracker.setEnabled(paramBoolean);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("LottieComposition:\n");
    Iterator localIterator = this.layers.iterator();
    while (localIterator.hasNext()) {
      localStringBuilder.append(((Layer)localIterator.next()).toString("\t"));
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.LottieComposition
 * JD-Core Version:    0.7.0.1
 */