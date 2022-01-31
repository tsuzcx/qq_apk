package com.tencent.mobileqq.dinifly;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.v4.util.LongSparseArray;
import android.support.v4.util.MQLruCache;
import android.support.v4.util.SparseArrayCompat;
import android.util.DisplayMetrics;
import android.util.Log;
import com.tencent.mobileqq.dinifly.model.FileCompositionLoader;
import com.tencent.mobileqq.dinifly.model.Font;
import com.tencent.mobileqq.dinifly.model.Font.Factory;
import com.tencent.mobileqq.dinifly.model.FontCharacter;
import com.tencent.mobileqq.dinifly.model.FontCharacter.Factory;
import com.tencent.mobileqq.dinifly.model.JsonCompositionLoader;
import com.tencent.mobileqq.dinifly.model.layer.CompositionLayer;
import com.tencent.mobileqq.dinifly.model.layer.Layer;
import com.tencent.mobileqq.dinifly.model.layer.Layer.Factory;
import com.tencent.mobileqq.dinifly.utils.Utils;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class LottieComposition
{
  private final Rect bounds;
  private final SparseArrayCompat<FontCharacter> characters = new SparseArrayCompat();
  public CompositionLayer compositionLayer;
  private final float dpScale;
  private final long endFrame;
  private final Map<String, Font> fonts = new HashMap();
  private final float frameRate;
  private final Map<String, LottieImageAsset> images = new HashMap();
  public LayerInfo layerInfo = new LayerInfo();
  private final LongSparseArray<Layer> layerMap = new LongSparseArray();
  private final List<Layer> layers = new ArrayList();
  private final int majorVersion;
  private final int minorVersion;
  private final int patchVersion;
  private final PerformanceTracker performanceTracker = new PerformanceTracker();
  private final Map<String, List<Layer>> precomps = new HashMap();
  private final long startFrame;
  private final HashSet<String> warnings = new HashSet();
  
  private LottieComposition(Rect paramRect, long paramLong1, long paramLong2, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, int paramInt3)
  {
    this.bounds = paramRect;
    this.startFrame = paramLong1;
    this.endFrame = paramLong2;
    this.frameRate = paramFloat1;
    this.dpScale = paramFloat2;
    this.majorVersion = paramInt1;
    this.minorVersion = paramInt2;
    this.patchVersion = paramInt3;
    if (!Utils.isAtLeastVersion(this, 4, 5, 0)) {
      addWarning("Lottie only supports bodymovin >= 4.5.0");
    }
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY})
  public void addWarning(String paramString)
  {
    Log.w("LOTTIE", paramString);
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
  
  public float getDpScale()
  {
    return this.dpScale;
  }
  
  public long getDuration()
  {
    return ((float)(this.endFrame - this.startFrame) / this.frameRate * 1000.0F);
  }
  
  public float getDurationFrames()
  {
    return (float)getDuration() * this.frameRate / 1000.0F;
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY})
  public long getEndFrame()
  {
    return this.endFrame;
  }
  
  public Map<String, Font> getFonts()
  {
    return this.fonts;
  }
  
  Map<String, LottieImageAsset> getImages()
  {
    return this.images;
  }
  
  public List<Layer> getLayers()
  {
    return this.layers;
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY})
  public int getMajorVersion()
  {
    return this.majorVersion;
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY})
  public int getMinorVersion()
  {
    return this.minorVersion;
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY})
  public int getPatchVersion()
  {
    return this.patchVersion;
  }
  
  public PerformanceTracker getPerformanceTracker()
  {
    return this.performanceTracker;
  }
  
  @Nullable
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY})
  public List<Layer> getPrecomps(String paramString)
  {
    return (List)this.precomps.get(paramString);
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY})
  public long getStartFrame()
  {
    return this.startFrame;
  }
  
  public ArrayList<String> getWarnings()
  {
    return new ArrayList(Arrays.asList(this.warnings.toArray(new String[this.warnings.size()])));
  }
  
  public boolean hasImages()
  {
    return !this.images.isEmpty();
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY})
  public Layer layerModelForId(long paramLong)
  {
    return (Layer)this.layerMap.get(paramLong);
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
  
  public static class Factory
  {
    public static final String KEY_CACHE_PREFIX = "key";
    public static final String KEY_PATH_PREFIX = "path";
    
    private static void addLayer(List<Layer> paramList, LongSparseArray<Layer> paramLongSparseArray, Layer paramLayer)
    {
      paramList.add(paramLayer);
      paramLongSparseArray.put(paramLayer.getId(), paramLayer);
    }
    
    public static Cancellable fromAssetFileName(Context paramContext, String paramString, OnCompositionLoadedListener paramOnCompositionLoadedListener)
    {
      try
      {
        InputStream localInputStream = paramContext.getAssets().open(paramString);
        return fromInputStream(paramContext, localInputStream, paramOnCompositionLoadedListener);
      }
      catch (IOException paramContext)
      {
        throw new IllegalStateException("Unable to find file " + paramString, paramContext);
      }
    }
    
    public static LottieComposition fromFileSync(Context paramContext, String paramString)
    {
      try
      {
        InputStream localInputStream = paramContext.getAssets().open(paramString);
        return fromInputStream(paramContext.getResources(), localInputStream, null);
      }
      catch (IOException paramContext)
      {
        throw new IllegalStateException("Unable to find file " + paramString, paramContext);
      }
    }
    
    public static Cancellable fromInputStream(Context paramContext, InputStream paramInputStream, OnCompositionLoadedListener paramOnCompositionLoadedListener)
    {
      paramContext = new FileCompositionLoader(paramContext.getResources(), paramOnCompositionLoadedListener, null, null);
      paramContext.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new InputStream[] { paramInputStream });
      return paramContext;
    }
    
    @Nullable
    public static LottieComposition fromInputStream(Resources paramResources, InputStream paramInputStream, Bundle paramBundle)
    {
      try
      {
        byte[] arrayOfByte = new byte[paramInputStream.available()];
        paramInputStream.read(arrayOfByte);
        paramResources = fromJsonSync(paramResources, new JSONObject(new String(arrayOfByte, "UTF-8")), paramBundle);
        return paramResources;
      }
      catch (OutOfMemoryError paramResources)
      {
        Log.e("LottieComposition", "parse json error.", paramResources);
        return null;
      }
      catch (Exception paramResources)
      {
        for (;;)
        {
          Log.e("LottieComposition", "parse json error.", paramResources);
          Utils.closeQuietly(paramInputStream);
        }
      }
      finally
      {
        Utils.closeQuietly(paramInputStream);
      }
    }
    
    public static Cancellable fromInputStreamWithCacheBitmap(Context paramContext, InputStream paramInputStream, LottieDrawable paramLottieDrawable, OnCompositionLoadedListener paramOnCompositionLoadedListener, Bundle paramBundle, MQLruCache<String, Object> paramMQLruCache)
    {
      if (LottieImageAsset.sImageCache == null) {
        LottieImageAsset.sImageCache = paramMQLruCache;
      }
      paramContext = new FileCompositionLoader(paramContext.getResources(), paramOnCompositionLoadedListener, paramBundle, paramLottieDrawable);
      paramContext.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new InputStream[] { paramInputStream });
      return paramContext;
    }
    
    public static Cancellable fromInputStreamWithCacheBitmap(Context paramContext, InputStream paramInputStream, OnCompositionLoadedListener paramOnCompositionLoadedListener, Bundle paramBundle, MQLruCache<String, Object> paramMQLruCache)
    {
      if (LottieImageAsset.sImageCache == null) {
        LottieImageAsset.sImageCache = paramMQLruCache;
      }
      paramContext = new FileCompositionLoader(paramContext.getResources(), paramOnCompositionLoadedListener, paramBundle, null);
      paramContext.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new InputStream[] { paramInputStream });
      return paramContext;
    }
    
    public static Cancellable fromJson(Resources paramResources, JSONObject paramJSONObject, OnCompositionLoadedListener paramOnCompositionLoadedListener)
    {
      paramResources = new JsonCompositionLoader(paramResources, paramOnCompositionLoadedListener);
      paramResources.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new JSONObject[] { paramJSONObject });
      return paramResources;
    }
    
    public static LottieComposition fromJsonSync(Resources paramResources, JSONObject paramJSONObject, Bundle paramBundle)
    {
      Object localObject2 = null;
      float f1 = paramResources.getDisplayMetrics().density;
      int i = paramJSONObject.optInt("w", -1);
      int j = paramJSONObject.optInt("h", -1);
      Object localObject1 = localObject2;
      if (i != -1)
      {
        localObject1 = localObject2;
        if (j != -1) {
          localObject1 = new Rect(0, 0, (int)(i * f1), (int)(j * f1));
        }
      }
      long l1 = paramJSONObject.optLong("ip", 0L);
      long l2 = paramJSONObject.optLong("op", 0L);
      float f2 = (float)paramJSONObject.optDouble("fr", 0.0D);
      localObject2 = paramJSONObject.optString("v").split("[.]");
      localObject1 = new LottieComposition((Rect)localObject1, l1, l2, f2, f1, Integer.parseInt(localObject2[0]), Integer.parseInt(localObject2[1]), Integer.parseInt(localObject2[2]), null);
      localObject2 = paramJSONObject.optJSONArray("assets");
      parseImages((JSONArray)localObject2, (LottieComposition)localObject1, paramResources, paramBundle);
      parsePrecomps((JSONArray)localObject2, (LottieComposition)localObject1);
      parseFonts(paramJSONObject.optJSONObject("fonts"), (LottieComposition)localObject1);
      parseChars(paramJSONObject.optJSONArray("chars"), (LottieComposition)localObject1);
      parseLayers(paramJSONObject, (LottieComposition)localObject1);
      return localObject1;
    }
    
    private static void parseChars(@Nullable JSONArray paramJSONArray, LottieComposition paramLottieComposition)
    {
      if (paramJSONArray == null) {}
      for (;;)
      {
        return;
        int j = paramJSONArray.length();
        int i = 0;
        while (i < j)
        {
          FontCharacter localFontCharacter = FontCharacter.Factory.newInstance(paramJSONArray.optJSONObject(i), paramLottieComposition);
          paramLottieComposition.characters.put(localFontCharacter.hashCode(), localFontCharacter);
          i += 1;
        }
      }
    }
    
    private static void parseFonts(@Nullable JSONObject paramJSONObject, LottieComposition paramLottieComposition)
    {
      if (paramJSONObject == null) {}
      for (;;)
      {
        return;
        paramJSONObject = paramJSONObject.optJSONArray("list");
        if (paramJSONObject != null)
        {
          int j = paramJSONObject.length();
          int i = 0;
          while (i < j)
          {
            Font localFont = Font.Factory.newInstance(paramJSONObject.optJSONObject(i));
            paramLottieComposition.fonts.put(localFont.getName(), localFont);
            i += 1;
          }
        }
      }
    }
    
    private static void parseImages(@Nullable JSONArray paramJSONArray, LottieComposition paramLottieComposition, Resources paramResources, Bundle paramBundle)
    {
      if (paramJSONArray == null) {
        return;
      }
      paramLottieComposition.layerInfo.bitmapSize = 0L;
      int j = paramJSONArray.length();
      int i = 0;
      label22:
      Object localObject;
      if (i < j)
      {
        localObject = paramJSONArray.optJSONObject(i);
        if (((JSONObject)localObject).has("p")) {
          break label57;
        }
      }
      for (;;)
      {
        i += 1;
        break label22;
        break;
        label57:
        localObject = LottieImageAsset.Factory.newInstance(paramResources, (JSONObject)localObject, paramBundle);
        paramLottieComposition.images.put(((LottieImageAsset)localObject).getId(), localObject);
        LayerInfo localLayerInfo = paramLottieComposition.layerInfo;
        localLayerInfo.bitmapSize += ((LottieImageAsset)localObject).size;
      }
    }
    
    private static void parseLayers(JSONObject paramJSONObject, LottieComposition paramLottieComposition)
    {
      paramJSONObject = paramJSONObject.optJSONArray("layers");
      if (paramJSONObject == null) {}
      int j;
      do
      {
        return;
        int m = paramJSONObject.length();
        j = 0;
        int i = 0;
        while (i < m)
        {
          Layer localLayer = Layer.Factory.newInstance(paramJSONObject.optJSONObject(i), paramLottieComposition);
          int k = j;
          if (localLayer.getLayerType() == 2) {
            k = j + 1;
          }
          addLayer(paramLottieComposition.layers, paramLottieComposition.layerMap, localLayer);
          i += 1;
          j = k;
        }
      } while (j <= 4);
      paramLottieComposition.addWarning("You have " + j + " images. Lottie should primarily be " + "used with shapes. If you are using Adobe Illustrator, convert the Illustrator layers" + " to shape layers.");
    }
    
    private static void parsePrecomps(@Nullable JSONArray paramJSONArray, LottieComposition paramLottieComposition)
    {
      if (paramJSONArray == null) {
        return;
      }
      int k = paramJSONArray.length();
      int i = 0;
      label13:
      Object localObject;
      JSONArray localJSONArray;
      if (i < k)
      {
        localObject = paramJSONArray.optJSONObject(i);
        localJSONArray = ((JSONObject)localObject).optJSONArray("layers");
        if (localJSONArray != null) {
          break label48;
        }
      }
      for (;;)
      {
        i += 1;
        break label13;
        break;
        label48:
        ArrayList localArrayList = new ArrayList(localJSONArray.length());
        LongSparseArray localLongSparseArray = new LongSparseArray();
        int j = 0;
        while (j < localJSONArray.length())
        {
          Layer localLayer = Layer.Factory.newInstance(localJSONArray.optJSONObject(j), paramLottieComposition);
          localLongSparseArray.put(localLayer.getId(), localLayer);
          localArrayList.add(localLayer);
          j += 1;
        }
        localObject = ((JSONObject)localObject).optString("id");
        paramLottieComposition.precomps.put(localObject, localArrayList);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.LottieComposition
 * JD-Core Version:    0.7.0.1
 */