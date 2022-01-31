package com.tencent.tavsticker.model;

import android.graphics.RectF;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavsticker.TAVStickerHelper;
import com.tencent.tavsticker.core.ITAVStickerProgressHandler;
import com.tencent.tavsticker.core.ITAVStickerRenderer;
import com.tencent.tavsticker.core.TAVPAGFileManager;
import com.tencent.tavsticker.core.TAVStickerFakeParser;
import com.tencent.tavsticker.exception.StickerInitializationException;
import com.tencent.tavsticker.utils.CollectionUtil;
import com.tencent.tavsticker.utils.TAVStickerUtil;
import com.tencent.tavsticker.utils.TimeRangeUtil;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import org.libpag.PAGComposition;
import org.libpag.PAGFile;
import org.libpag.PAGImage;
import org.libpag.PAGLayer;
import org.libpag.PAGMarker;
import org.libpag.PAGRenderer;
import org.libpag.PAGText;

public class TAVSticker
  implements Cloneable
{
  private static final String TAG = TAVSticker.class.getSimpleName();
  private String assetFilePath = "";
  private boolean autoPlay = true;
  private float centerX = 0.0F;
  private float centerY = 0.0F;
  private boolean editable = true;
  private Bundle extraBundle = new Bundle(1);
  private String extras = "";
  private String filePath = "";
  private ArrayList<TAVStickerImageItem> imageList = null;
  private boolean isInit = false;
  private boolean isShowDefaultBorder = false;
  private int layerIndex = -1;
  private TAVStickerMode mMode = TAVStickerMode.DEFAULT;
  private float maxScale = 0.0F;
  private float minScale = 0.0F;
  private RectF moveRect = null;
  private PAGFile pagFile = null;
  private PAGRenderer pagRenderer = null;
  private ITAVStickerProgressHandler progressHandler;
  private ArrayList<ITAVStickerRenderer> rendererList = null;
  private float rotate = 0.0F;
  private float scale = 0.5F;
  private ArrayList<TAVStickerShapeItem> shapeList = null;
  private String stickerId = "";
  private int strokeColor = -16711936;
  private int strokeWidth = 0;
  private TAVStickerMoveLimit tavStickerMoveLimit = TAVStickerMoveLimit.LIMIT_CENTER_POINT;
  private ArrayList<TAVStickerTextItem> textList = null;
  private CMTimeRange timeRange = null;
  private String uniqueId = "";
  
  private List<PAGText> getPAGTextListFromFile()
  {
    if (this.pagFile != null)
    {
      int j = this.pagFile.numTexts();
      if (j > 0)
      {
        ArrayList localArrayList = new ArrayList();
        int i = 0;
        for (;;)
        {
          localObject = localArrayList;
          if (i >= j) {
            break;
          }
          localObject = this.pagFile.getTextData(i);
          if (localObject != null) {
            localArrayList.add(localObject);
          }
          i += 1;
        }
      }
    }
    Object localObject = null;
    return localObject;
  }
  
  private ArrayList<PAGLayer> layersInComposition(PAGComposition paramPAGComposition, int paramInt)
  {
    if (paramPAGComposition != null)
    {
      ArrayList localArrayList = new ArrayList();
      int j = paramPAGComposition.numLayers();
      int i = 0;
      if (i < j)
      {
        Object localObject = paramPAGComposition.getLayerAt(i);
        if (localObject != null)
        {
          if (6 != ((PAGLayer)localObject).layerType()) {
            break label97;
          }
          if ((localObject instanceof PAGComposition))
          {
            localObject = layersInComposition((PAGComposition)localObject, paramInt);
            if (!CollectionUtil.isEmptyList((List)localObject)) {
              localArrayList.addAll(localArrayList.size(), (Collection)localObject);
            }
          }
        }
        for (;;)
        {
          i += 1;
          break;
          label97:
          if (paramInt == ((PAGLayer)localObject).layerType()) {
            localArrayList.add(localObject);
          }
        }
      }
      Collections.sort(localArrayList, new TAVSticker.1(this));
      return localArrayList;
    }
    return null;
  }
  
  private ArrayList<TAVStickerImageItem> readAllImageData()
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = layersInComposition(this.pagRenderer.getRootComposition(), 5);
    if (!CollectionUtil.isEmptyList(localArrayList2))
    {
      int j = localArrayList2.size();
      int i = 0;
      while (i < j)
      {
        Object localObject = (PAGLayer)localArrayList2.get(i);
        if (localObject != null)
        {
          localObject = new TAVStickerImageItem((PAGLayer)localObject);
          if (-1 == ((TAVStickerImageItem)localObject).getLayerIndex()) {
            ((TAVStickerImageItem)localObject).setLayerIndex(i);
          }
          localArrayList1.add(localObject);
        }
        i += 1;
      }
    }
    return localArrayList1;
  }
  
  private ArrayList<TAVStickerShapeItem> readAllShapeData()
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = layersInComposition(this.pagRenderer.getRootComposition(), 4);
    if (!CollectionUtil.isEmptyList(localArrayList2))
    {
      int j = localArrayList2.size();
      int i = 0;
      while (i < j)
      {
        Object localObject = (PAGLayer)localArrayList2.get(i);
        if (localObject != null)
        {
          localObject = new TAVStickerShapeItem((PAGLayer)localObject);
          if (-1 == ((TAVStickerShapeItem)localObject).getLayerIndex()) {
            ((TAVStickerShapeItem)localObject).setLayerIndex(i);
          }
          localArrayList1.add(localObject);
        }
        i += 1;
      }
    }
    return localArrayList1;
  }
  
  private ArrayList<TAVStickerTextItem> readAllTextData()
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = layersInComposition(this.pagRenderer.getRootComposition(), 3);
    List localList = getPAGTextListFromFile();
    if ((!CollectionUtil.isEmptyList(localArrayList2)) && (!CollectionUtil.isEmptyList(localList)))
    {
      int j = localArrayList2.size();
      int k = localList.size();
      int i = 0;
      while (i < j)
      {
        Object localObject = (PAGLayer)localArrayList2.get(i);
        if (localObject != null)
        {
          localObject = new TAVStickerTextItem((PAGLayer)localObject);
          if (i < k)
          {
            PAGText localPAGText = (PAGText)localList.get(i);
            if (localPAGText != null)
            {
              if (-1 == ((TAVStickerTextItem)localObject).getLayerIndex()) {
                ((TAVStickerTextItem)localObject).setLayerIndex(i);
              }
              if (!TextUtils.isEmpty(localPAGText.text)) {
                ((TAVStickerTextItem)localObject).setText(localPAGText.text);
              }
              if (!TextUtils.isEmpty(localPAGText.text)) {
                ((TAVStickerTextItem)localObject).setDefaultText(localPAGText.text);
              }
              ((TAVStickerTextItem)localObject).setDefaultColor(localPAGText.fillColor);
              if (((TAVStickerTextItem)localObject).getTextColor() == 0) {
                ((TAVStickerTextItem)localObject).setTextColor(localPAGText.fillColor);
              }
              if (!TextUtils.isEmpty(localPAGText.fontFamily)) {
                ((TAVStickerTextItem)localObject).setFontFamily(localPAGText.fontFamily);
              }
              if (!TextUtils.isEmpty(localPAGText.fontStyle)) {
                ((TAVStickerTextItem)localObject).setFontStyle(localPAGText.fontStyle);
              }
            }
          }
          localArrayList1.add(localObject);
        }
        i += 1;
      }
    }
    return localArrayList1;
  }
  
  public TAVSticker clone()
  {
    TAVSticker localTAVSticker = new TAVSticker();
    localTAVSticker.isInit = this.isInit;
    localTAVSticker.filePath = this.filePath;
    localTAVSticker.assetFilePath = this.assetFilePath;
    localTAVSticker.uniqueId = UUID.randomUUID().toString();
    localTAVSticker.stickerId = this.stickerId;
    localTAVSticker.layerIndex = this.layerIndex;
    localTAVSticker.pagFile = this.pagFile;
    localTAVSticker.pagRenderer = this.pagRenderer;
    localTAVSticker.textList = this.textList;
    localTAVSticker.rendererList = this.rendererList;
    localTAVSticker.imageList = this.imageList;
    localTAVSticker.timeRange = this.timeRange;
    localTAVSticker.progressHandler = this.progressHandler;
    localTAVSticker.strokeColor = this.strokeColor;
    localTAVSticker.strokeWidth = this.strokeWidth;
    localTAVSticker.isShowDefaultBorder = this.isShowDefaultBorder;
    localTAVSticker.scale = this.scale;
    localTAVSticker.minScale = this.minScale;
    localTAVSticker.maxScale = this.maxScale;
    localTAVSticker.rotate = this.rotate;
    localTAVSticker.centerX = this.centerX;
    localTAVSticker.centerY = this.centerY;
    localTAVSticker.tavStickerMoveLimit = this.tavStickerMoveLimit;
    localTAVSticker.moveRect = this.moveRect;
    localTAVSticker.editable = this.editable;
    localTAVSticker.mMode = this.mMode;
    localTAVSticker.autoPlay = this.autoPlay;
    localTAVSticker.extras = this.extras;
    localTAVSticker.extraBundle = this.extraBundle;
    return localTAVSticker;
  }
  
  public double computeProgress(long paramLong)
  {
    double d2 = 0.0D;
    double d1;
    if (this.progressHandler != null) {
      d1 = this.progressHandler.computeProgress(this, paramLong);
    }
    long l;
    do
    {
      do
      {
        do
        {
          return d1;
          if (this.timeRange == null) {
            break;
          }
          d1 = d2;
        } while (!TimeRangeUtil.isInTimeRange(this.timeRange, paramLong));
        paramLong = Math.max(0L, paramLong - this.timeRange.getStartUs() / 1000L);
        l = durationTime() / 1000L;
        d1 = d2;
      } while (l <= 0L);
      return Math.min(1.0D, paramLong % l * 1.0D / l);
      l = durationTime() / 1000L;
      d1 = d2;
    } while (l <= 0L);
    return Math.min(1.0D, paramLong % l * 1.0D / l);
  }
  
  public long durationTime()
  {
    if (this.pagFile != null) {
      return this.pagFile.duration();
    }
    return 0L;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof TAVSticker))
    {
      paramObject = (TAVSticker)paramObject;
      return TextUtils.equals(this.uniqueId, paramObject.uniqueId);
    }
    return super.equals(paramObject);
  }
  
  public String getAssetFilePath()
  {
    return this.assetFilePath;
  }
  
  public ByteBuffer getAudioData()
  {
    if (this.pagRenderer != null)
    {
      Object localObject = this.pagRenderer.getRootComposition();
      if (localObject != null)
      {
        localObject = ((PAGComposition)localObject).audioBytes();
        if (localObject != null) {
          ((ByteBuffer)localObject).rewind();
        }
        return localObject;
      }
    }
    return null;
  }
  
  public float getAudioStartTime()
  {
    if (this.pagRenderer != null)
    {
      PAGComposition localPAGComposition = this.pagRenderer.getRootComposition();
      if (localPAGComposition != null) {
        return TAVStickerUtil.microsecond2Seconds(localPAGComposition.audioStartTime());
      }
    }
    return 0.0F;
  }
  
  public List<TAVStickerLayerInfo.TAVStickerUserData> getAudioUserDatas()
  {
    if (this.pagRenderer != null)
    {
      localObject = this.pagRenderer.getRootComposition();
      if (localObject != null)
      {
        ArrayList localArrayList = new ArrayList();
        PAGMarker[] arrayOfPAGMarker = ((PAGComposition)localObject).audioMarkers();
        localObject = localArrayList;
        if (arrayOfPAGMarker == null) {
          return localObject;
        }
        localObject = localArrayList;
        if (arrayOfPAGMarker.length <= 0) {
          return localObject;
        }
        int j = arrayOfPAGMarker.length;
        int i = 0;
        for (;;)
        {
          localObject = localArrayList;
          if (i >= j) {
            break;
          }
          localObject = arrayOfPAGMarker[i];
          if (localObject != null) {
            localArrayList.add(new TAVStickerLayerInfo.TAVStickerUserData(new CMTimeRange(new CMTime(TAVStickerUtil.microsecond2Seconds(((PAGMarker)localObject).mStartTime)), new CMTime(TAVStickerUtil.microsecond2Seconds(((PAGMarker)localObject).mDuration))), ((PAGMarker)localObject).mComment));
          }
          i += 1;
        }
      }
    }
    Object localObject = new ArrayList();
    return localObject;
  }
  
  public float getCenterX()
  {
    return this.centerX;
  }
  
  public float getCenterY()
  {
    return this.centerY;
  }
  
  @NonNull
  public Bundle getExtraBundle()
  {
    return this.extraBundle;
  }
  
  public String getExtras()
  {
    return this.extras;
  }
  
  public String getFilePath()
  {
    return this.filePath;
  }
  
  public int getHeight()
  {
    if (this.pagFile != null) {
      return this.pagFile.height();
    }
    return 0;
  }
  
  public int getLayerIndex()
  {
    return this.layerIndex;
  }
  
  public float getMaxScale()
  {
    return this.maxScale;
  }
  
  public float getMinScale()
  {
    return this.minScale;
  }
  
  public TAVStickerMode getMode()
  {
    return this.mMode;
  }
  
  public RectF getMoveRect()
  {
    return this.moveRect;
  }
  
  public PAGFile getPagFile()
  {
    return this.pagFile;
  }
  
  public float getRotate()
  {
    return this.rotate;
  }
  
  public float getScale()
  {
    return this.scale;
  }
  
  public String getStickerId()
  {
    return this.stickerId;
  }
  
  public ArrayList<TAVStickerImageItem> getStickerImageItems()
  {
    if (this.imageList == null)
    {
      this.imageList = new ArrayList();
      this.imageList.addAll(readAllImageData());
    }
    return this.imageList;
  }
  
  public List<TAVStickerLayerInfo> getStickerLayerInfos()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = getStickerImageItems();
    Object localObject2;
    if (!CollectionUtil.isEmptyList((List)localObject1))
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (TAVStickerImageItem)((Iterator)localObject1).next();
        if (localObject2 != null)
        {
          localObject2 = ((TAVStickerImageItem)localObject2).getLayerInfo();
          if (localObject2 != null) {
            localArrayList.add(localObject2);
          }
        }
      }
    }
    localObject1 = getStickerTextItems();
    if (!CollectionUtil.isEmptyList((List)localObject1))
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (TAVStickerTextItem)((Iterator)localObject1).next();
        if (localObject2 != null)
        {
          localObject2 = ((TAVStickerTextItem)localObject2).getLayerInfo();
          if (localObject2 != null) {
            localArrayList.add(localObject2);
          }
        }
      }
    }
    if (!CollectionUtil.isEmptyList(localArrayList)) {
      Collections.sort(localArrayList, new TAVSticker.2(this));
    }
    return localArrayList;
  }
  
  @Deprecated
  public List<TAVStickerLayerInfo> getStickerLayerInfosFake()
  {
    return TAVStickerFakeParser.fakeDataFromJson();
  }
  
  public TAVStickerMoveLimit getStickerMoveLimit()
  {
    return this.tavStickerMoveLimit;
  }
  
  public ArrayList<TAVStickerShapeItem> getStickerShapeItem()
  {
    if (this.shapeList == null)
    {
      this.shapeList = new ArrayList();
      this.shapeList.addAll(readAllShapeData());
    }
    return this.shapeList;
  }
  
  public ArrayList<TAVStickerTextItem> getStickerTextItems()
  {
    if (this.textList == null)
    {
      this.textList = new ArrayList();
      this.textList.addAll(readAllTextData());
    }
    return this.textList;
  }
  
  public int getStrokeColor()
  {
    return this.strokeColor;
  }
  
  public int getStrokeWidth()
  {
    return this.strokeWidth;
  }
  
  public TAVStickerImageItem getTavStickerImageItem(int paramInt)
  {
    Object localObject = getStickerImageItems();
    if (!CollectionUtil.isEmptyList((List)localObject))
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        TAVStickerImageItem localTAVStickerImageItem = (TAVStickerImageItem)((Iterator)localObject).next();
        if ((localTAVStickerImageItem != null) && (paramInt == localTAVStickerImageItem.getLayerIndex())) {
          return localTAVStickerImageItem;
        }
      }
    }
    return null;
  }
  
  public TAVStickerImageItem getTavStickerImageItem(String paramString)
  {
    Object localObject = getStickerImageItems();
    if (!CollectionUtil.isEmptyList((List)localObject))
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        TAVStickerImageItem localTAVStickerImageItem = (TAVStickerImageItem)((Iterator)localObject).next();
        if ((localTAVStickerImageItem != null) && (!TextUtils.isEmpty(paramString)) && (paramString.equals(localTAVStickerImageItem.getLayerName()))) {
          return localTAVStickerImageItem;
        }
      }
    }
    return null;
  }
  
  public TAVStickerTextItem getTavStickerTextItem(int paramInt)
  {
    Object localObject = getStickerTextItems();
    if (!CollectionUtil.isEmptyList((List)localObject))
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        TAVStickerTextItem localTAVStickerTextItem = (TAVStickerTextItem)((Iterator)localObject).next();
        if ((localTAVStickerTextItem != null) && (paramInt == localTAVStickerTextItem.getLayerIndex())) {
          return localTAVStickerTextItem;
        }
      }
    }
    return null;
  }
  
  public TAVStickerTextItem getTavStickerTextItem(String paramString)
  {
    Object localObject = getStickerTextItems();
    if (!CollectionUtil.isEmptyList((List)localObject))
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        TAVStickerTextItem localTAVStickerTextItem = (TAVStickerTextItem)((Iterator)localObject).next();
        if ((localTAVStickerTextItem != null) && (!TextUtils.isEmpty(paramString)) && (paramString.equals(localTAVStickerTextItem.getLayerName()))) {
          return localTAVStickerTextItem;
        }
      }
    }
    return null;
  }
  
  public CMTimeRange getTimeRange()
  {
    return this.timeRange;
  }
  
  public String getUniqueId()
  {
    return this.uniqueId;
  }
  
  public int getWidth()
  {
    if (this.pagFile != null) {
      return this.pagFile.width();
    }
    return 0;
  }
  
  public int hashCode()
  {
    if (!TextUtils.isEmpty(this.uniqueId)) {
      return this.uniqueId.hashCode();
    }
    return super.hashCode();
  }
  
  public TAVSticker init()
  {
    if (!this.isInit)
    {
      if (!TextUtils.isEmpty(this.filePath)) {
        this.pagFile = TAVPAGFileManager.getInstance().getPAGFileFromPath(this.filePath);
      }
      while (this.pagFile == null)
      {
        throw new StickerInitializationException("<init> can not initialization TAVSticker, please check the pag file path is correct! Please make sure to use the legal pag file!");
        if (!TextUtils.isEmpty(this.assetFilePath)) {
          this.pagFile = TAVPAGFileManager.getInstance().getPAGFileFromAsset(TAVStickerHelper.getContext(), this.assetFilePath);
        }
      }
      this.uniqueId = UUID.randomUUID().toString();
      if (TextUtils.isEmpty(this.stickerId)) {
        this.stickerId = this.uniqueId;
      }
      this.rendererList = new ArrayList();
      this.pagRenderer.setFile(this.pagFile);
      updateTextData();
      updateImageData();
      this.isInit = true;
    }
    return this;
  }
  
  public boolean isAutoPlay()
  {
    return this.autoPlay;
  }
  
  public boolean isEditable()
  {
    return this.editable;
  }
  
  public boolean isShowDefaultBorder()
  {
    return this.isShowDefaultBorder;
  }
  
  public void registerRenderer(ITAVStickerRenderer paramITAVStickerRenderer)
  {
    if ((paramITAVStickerRenderer != null) && (this.rendererList != null) && (!this.rendererList.contains(paramITAVStickerRenderer))) {
      this.rendererList.add(paramITAVStickerRenderer);
    }
    updateTextData();
    updateImageData();
  }
  
  public TAVSticker setAssetFilePath(String paramString)
  {
    this.assetFilePath = paramString;
    return this;
  }
  
  public TAVSticker setAutoPlay(boolean paramBoolean)
  {
    this.autoPlay = paramBoolean;
    return this;
  }
  
  public TAVSticker setCenterX(float paramFloat)
  {
    this.centerX = paramFloat;
    return this;
  }
  
  public TAVSticker setCenterY(float paramFloat)
  {
    this.centerY = paramFloat;
    return this;
  }
  
  public TAVSticker setEditable(boolean paramBoolean)
  {
    this.editable = paramBoolean;
    return this;
  }
  
  public TAVSticker setExtras(String paramString)
  {
    this.extras = paramString;
    return this;
  }
  
  public TAVSticker setFilePath(String paramString)
  {
    this.filePath = paramString;
    return this;
  }
  
  public TAVSticker setLayerIndex(int paramInt)
  {
    this.layerIndex = paramInt;
    return this;
  }
  
  public TAVSticker setMaxScale(float paramFloat)
  {
    this.maxScale = paramFloat;
    return this;
  }
  
  public TAVSticker setMinScale(float paramFloat)
  {
    this.minScale = paramFloat;
    return this;
  }
  
  public TAVSticker setMode(TAVStickerMode paramTAVStickerMode)
  {
    if (paramTAVStickerMode != null) {
      this.mMode = paramTAVStickerMode;
    }
    return this;
  }
  
  public TAVSticker setMoveRect(RectF paramRectF)
  {
    this.moveRect = paramRectF;
    return this;
  }
  
  public TAVSticker setProgressHandler(ITAVStickerProgressHandler paramITAVStickerProgressHandler)
  {
    this.progressHandler = paramITAVStickerProgressHandler;
    return this;
  }
  
  public TAVSticker setRotate(float paramFloat)
  {
    this.rotate = paramFloat;
    return this;
  }
  
  public TAVSticker setScale(float paramFloat)
  {
    this.scale = paramFloat;
    return this;
  }
  
  public TAVSticker setStickerId(String paramString)
  {
    this.stickerId = paramString;
    return this;
  }
  
  public TAVSticker setStrokeColor(int paramInt)
  {
    this.strokeColor = paramInt;
    return this;
  }
  
  public TAVSticker setStrokeWidth(int paramInt)
  {
    this.strokeWidth = paramInt;
    return this;
  }
  
  public TAVSticker setTavStickerMoveLimit(TAVStickerMoveLimit paramTAVStickerMoveLimit)
  {
    this.tavStickerMoveLimit = paramTAVStickerMoveLimit;
    return this;
  }
  
  public TAVSticker setTimeRange(CMTimeRange paramCMTimeRange)
  {
    this.timeRange = paramCMTimeRange;
    return this;
  }
  
  public TAVSticker showDefaultBorder(boolean paramBoolean)
  {
    this.isShowDefaultBorder = paramBoolean;
    return this;
  }
  
  public String toString()
  {
    return "TAVSticker {filePath : " + this.filePath + ", uniqueId : " + this.uniqueId + "}";
  }
  
  public void unregisterRenderer(ITAVStickerRenderer paramITAVStickerRenderer)
  {
    if (this.rendererList != null) {
      this.rendererList.remove(paramITAVStickerRenderer);
    }
  }
  
  public void updateImageData()
  {
    if ((this.pagFile == null) || (this.pagFile.numImages() <= 0) || (CollectionUtil.isEmptyList(this.imageList))) {}
    for (;;)
    {
      return;
      int j = this.pagFile.numImages();
      ArrayList localArrayList = getStickerImageItems();
      int i = 0;
      while ((i < j) && (i < localArrayList.size()))
      {
        TAVStickerImageItem localTAVStickerImageItem = (TAVStickerImageItem)localArrayList.get(i);
        if ((localTAVStickerImageItem != null) && (!CollectionUtil.isEmptyList(this.rendererList)))
        {
          Iterator localIterator = this.rendererList.iterator();
          while (localIterator.hasNext())
          {
            ITAVStickerRenderer localITAVStickerRenderer = (ITAVStickerRenderer)localIterator.next();
            if ((localITAVStickerRenderer != null) && (localTAVStickerImageItem.getBitmap() != null)) {
              localITAVStickerRenderer.setImageData(i, PAGImage.FromBitmap(localTAVStickerImageItem.getBitmap()));
            }
          }
        }
        i += 1;
      }
    }
  }
  
  public void updateTextData()
  {
    if (CollectionUtil.isEmptyList(this.rendererList)) {}
    for (;;)
    {
      return;
      List localList = getPAGTextListFromFile();
      if (!CollectionUtil.isEmptyList(localList))
      {
        int j = localList.size();
        int i = 0;
        while ((i < j) && (i < getStickerTextItems().size()))
        {
          PAGText localPAGText = (PAGText)localList.get(i);
          Object localObject = (TAVStickerTextItem)getStickerTextItems().get(i);
          if ((localPAGText != null) && (localObject != null))
          {
            if (!TextUtils.isEmpty(((TAVStickerTextItem)localObject).getText())) {}
            for (localPAGText.text = ((TAVStickerTextItem)localObject).getText();; localPAGText.text = "")
            {
              if (((TAVStickerTextItem)localObject).getTextColor() != 0) {
                localPAGText.fillColor = ((TAVStickerTextItem)localObject).getTextColor();
              }
              if (!TextUtils.isEmpty(((TAVStickerTextItem)localObject).getFontFamily())) {
                localPAGText.fontFamily = ((TAVStickerTextItem)localObject).getFontFamily();
              }
              if (!TextUtils.isEmpty(((TAVStickerTextItem)localObject).getFontStyle())) {
                localPAGText.fontStyle = ((TAVStickerTextItem)localObject).getFontStyle();
              }
              if (CollectionUtil.isEmptyList(this.rendererList)) {
                break;
              }
              localObject = this.rendererList.iterator();
              while (((Iterator)localObject).hasNext())
              {
                ITAVStickerRenderer localITAVStickerRenderer = (ITAVStickerRenderer)((Iterator)localObject).next();
                if (localITAVStickerRenderer != null) {
                  localITAVStickerRenderer.setTextData(i, localPAGText);
                }
              }
            }
          }
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tavsticker.model.TAVSticker
 * JD-Core Version:    0.7.0.1
 */