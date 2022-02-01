package com.tencent.tavcut.render.parser;

import android.util.LruCache;
import com.tencent.tavcut.model.ImageLayerData;
import com.tencent.tavcut.model.LayerMarkData;
import com.tencent.tavcut.model.PagEffectData;
import com.tencent.tavcut.model.TextLayerData;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.libpag.PAGComposition;
import org.libpag.PAGFile;
import org.libpag.PAGLayer;
import org.libpag.PAGMarker;
import org.libpag.PAGRenderer;
import org.libpag.PAGText;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/render/parser/PagEffectParser;", "", "()V", "ASSET_FILE_PATH_PREFIX", "", "CACHE_MAP", "Landroid/util/LruCache;", "Lcom/tencent/tavcut/model/PagEffectData;", "getCACHE_MAP", "()Landroid/util/LruCache;", "CACHE_MAP$delegate", "Lkotlin/Lazy;", "CACHE_SIZE", "", "pagRenderer", "Lorg/libpag/PAGRenderer;", "getPagRenderer", "()Lorg/libpag/PAGRenderer;", "pagRenderer$delegate", "clearCache", "", "exist", "", "path", "getPAGTextList", "", "Lorg/libpag/PAGText;", "pagFile", "Lorg/libpag/PAGFile;", "layersInComposition", "Lorg/libpag/PAGLayer;", "composition", "Lorg/libpag/PAGComposition;", "type", "parse", "filePath", "parseFromAsset", "context", "Landroid/content/Context;", "assetFileName", "parseLayerMark", "Lcom/tencent/tavcut/model/LayerMarkData;", "pagLayer", "parsePagFile", "readAllImageData", "Lcom/tencent/tavcut/model/ImageLayerData;", "pagComposition", "readAllTextData", "Lcom/tencent/tavcut/model/TextLayerData;", "lib_tavcut_release"}, k=1, mv={1, 1, 16})
public final class PagEffectParser
{
  public static final PagEffectParser a = new PagEffectParser();
  private static final Lazy b = LazyKt.lazy((Function0)PagEffectParser.CACHE_MAP.2.INSTANCE);
  private static final Lazy c = LazyKt.lazy((Function0)PagEffectParser.pagRenderer.2.INSTANCE);
  
  private final LruCache<String, PagEffectData> a()
  {
    return (LruCache)b.getValue();
  }
  
  private final PagEffectData a(PAGFile paramPAGFile)
  {
    b().setFile(paramPAGFile);
    Object localObject = b().getRootComposition();
    if (localObject != null)
    {
      List localList = a((PAGComposition)localObject, paramPAGFile);
      localObject = a((PAGComposition)localObject);
      long l = paramPAGFile.duration();
      int i = paramPAGFile.width();
      int j = paramPAGFile.height();
      return new PagEffectData(paramPAGFile.path(), i, j, l, localList, (List)localObject, paramPAGFile.timeStretchMode(), null, 128, null);
    }
    return null;
  }
  
  private final List<ImageLayerData> a(PAGComposition paramPAGComposition)
  {
    if (paramPAGComposition == null) {
      return CollectionsKt.emptyList();
    }
    paramPAGComposition = a(paramPAGComposition, 5);
    Object localObject = (Collection)paramPAGComposition;
    int i;
    if ((localObject != null) && (!((Collection)localObject).isEmpty())) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0) {
      return CollectionsKt.emptyList();
    }
    localObject = (Iterable)paramPAGComposition;
    paramPAGComposition = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      PAGLayer localPAGLayer = (PAGLayer)((Iterator)localObject).next();
      paramPAGComposition.add(new ImageLayerData(localPAGLayer.editableIndex(), localPAGLayer.layerName(), localPAGLayer.layerType(), a.a(localPAGLayer), null, 16, null));
    }
    return (List)paramPAGComposition;
  }
  
  private final List<PAGLayer> a(PAGComposition paramPAGComposition, int paramInt)
  {
    if (paramPAGComposition == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int k = paramPAGComposition.numLayers();
    int i = 0;
    while (i < k)
    {
      Object localObject = paramPAGComposition.getLayerAt(i);
      if (localObject != null) {
        if (6 == ((PAGLayer)localObject).layerType())
        {
          if ((localObject instanceof PAGComposition))
          {
            localObject = a((PAGComposition)localObject, paramInt);
            Collection localCollection = (Collection)localObject;
            int j;
            if ((localCollection != null) && (!localCollection.isEmpty())) {
              j = 0;
            } else {
              j = 1;
            }
            if (j == 0)
            {
              j = localArrayList.size();
              if (localObject == null) {
                Intrinsics.throwNpe();
              }
              localArrayList.addAll(j, localCollection);
            }
          }
        }
        else if (paramInt == ((PAGLayer)localObject).layerType()) {
          localArrayList.add(localObject);
        }
      }
      i += 1;
    }
    return CollectionsKt.sortedWith((Iterable)localArrayList, (Comparator)new PagEffectParser.layersInComposition..inlined.sortedBy.1());
  }
  
  private final List<TextLayerData> a(PAGComposition paramPAGComposition, PAGFile paramPAGFile)
  {
    if (paramPAGComposition == null) {
      return CollectionsKt.emptyList();
    }
    Object localObject = a(paramPAGComposition, 3);
    paramPAGComposition = b(paramPAGFile);
    paramPAGFile = (Collection)localObject;
    int j = 0;
    int k = 1;
    int i;
    if ((paramPAGFile != null) && (!paramPAGFile.isEmpty())) {
      i = 0;
    } else {
      i = 1;
    }
    if (i == 0)
    {
      paramPAGFile = (Collection)paramPAGComposition;
      i = k;
      if (paramPAGFile != null) {
        if (paramPAGFile.isEmpty()) {
          i = k;
        } else {
          i = 0;
        }
      }
      if (i == 0)
      {
        k = ((List)localObject).size();
        int m = paramPAGComposition.size();
        ArrayList localArrayList = new ArrayList();
        i = j;
        paramPAGFile = (PAGFile)localObject;
        while (i < k)
        {
          localObject = (PAGLayer)paramPAGFile.get(i);
          if (i < m)
          {
            PAGText localPAGText = (PAGText)paramPAGComposition.get(i);
            j = ((PAGLayer)localObject).editableIndex();
            String str1 = ((PAGLayer)localObject).layerName();
            int n = ((PAGLayer)localObject).layerType();
            String str2 = localPAGText.text;
            int i1 = localPAGText.fillColor;
            String str3 = localPAGText.fontFamily;
            String str4 = localPAGText.fontStyle;
            boolean bool1 = localPAGText.applyStroke;
            boolean bool2 = localPAGText.applyFill;
            float f1 = localPAGText.baselineShift;
            boolean bool3 = localPAGText.boxText;
            boolean bool4 = localPAGText.fauxItalic;
            boolean bool5 = localPAGText.fauxBold;
            float f2 = localPAGText.fontSize;
            float f3 = localPAGText.strokeWidth;
            int i2 = localPAGText.strokeColor;
            boolean bool6 = localPAGText.strokeOverFill;
            int i3 = localPAGText.justification;
            float f4 = localPAGText.leading;
            float f5 = localPAGText.tracking;
            int i4 = localPAGText.backgroundAlpha;
            int i5 = localPAGText.backgroundColor;
            localArrayList.add(new TextLayerData(Integer.valueOf(j), str1, Integer.valueOf(n), str2, Integer.valueOf(i1), str3, str4, a((PAGLayer)localObject), Boolean.valueOf(bool2), Boolean.valueOf(bool1), Float.valueOf(f1), Boolean.valueOf(bool3), null, Boolean.valueOf(bool5), Boolean.valueOf(bool4), Float.valueOf(f2), Integer.valueOf(i2), Boolean.valueOf(bool6), Float.valueOf(f3), Integer.valueOf(i3), Float.valueOf(f4), Float.valueOf(f5), Integer.valueOf(i5), Integer.valueOf(i4), null, 16781312, null));
          }
          i += 1;
        }
        return (List)localArrayList;
      }
    }
    return CollectionsKt.emptyList();
  }
  
  private final List<LayerMarkData> a(PAGLayer paramPAGLayer)
  {
    paramPAGLayer = paramPAGLayer.markers();
    Intrinsics.checkExpressionValueIsNotNull(paramPAGLayer, "pagLayer.markers()");
    Collection localCollection = (Collection)new ArrayList(paramPAGLayer.length);
    int j = paramPAGLayer.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramPAGLayer[i];
      localCollection.add(new LayerMarkData(localObject.mStartTime, localObject.mDuration, localObject.mComment, null, 8, null));
      i += 1;
    }
    return (List)localCollection;
  }
  
  private final List<PAGText> b(PAGFile paramPAGFile)
  {
    int j = paramPAGFile.numTexts();
    if (j > 0)
    {
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < j)
      {
        PAGText localPAGText = paramPAGFile.getTextData(i);
        if (localPAGText != null) {
          localArrayList.add(localPAGText);
        }
        i += 1;
      }
      return (List)localArrayList;
    }
    return null;
  }
  
  private final PAGRenderer b()
  {
    return (PAGRenderer)c.getValue();
  }
  
  private final boolean b(String paramString)
  {
    CharSequence localCharSequence = (CharSequence)paramString;
    int i;
    if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0) {
      return false;
    }
    return new File(paramString).exists();
  }
  
  @Nullable
  public final PagEffectData a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "filePath");
    if (!b(paramString)) {
      return null;
    }
    Object localObject = (PagEffectData)a().get(paramString);
    if (localObject == null)
    {
      localObject = PAGFile.Load(paramString);
      if (localObject != null)
      {
        localObject = a((PAGFile)localObject);
        if (localObject != null) {
          paramString = (PagEffectData)a.a().put(paramString, localObject);
        }
        return localObject;
      }
      return null;
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.render.parser.PagEffectParser
 * JD-Core Version:    0.7.0.1
 */