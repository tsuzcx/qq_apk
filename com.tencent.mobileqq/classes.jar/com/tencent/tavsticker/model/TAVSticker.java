package com.tencent.tavsticker.model;

import android.graphics.RectF;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.tav.coremedia.CGSize;
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
import java.util.TreeSet;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;
import org.libpag.PAGComposition;
import org.libpag.PAGFile;
import org.libpag.PAGImage;
import org.libpag.PAGImageLayer;
import org.libpag.PAGLayer;
import org.libpag.PAGMarker;
import org.libpag.PAGSolidLayer;
import org.libpag.PAGText;

public class TAVSticker
  implements Cloneable
{
  private static final String TAG = "TAVSticker";
  public static final String VIDEO_TRACK = "videoTrack";
  private TAVSticker.TAVStickerAnimationMode animationMode = TAVSticker.TAVStickerAnimationMode.TAVStickerAnimationModeDefault;
  private String assetFilePath = "";
  private float centerX = 0.0F;
  private float centerY = 0.0F;
  private boolean editable = true;
  private Bundle extraBundle = new Bundle(1);
  private String extras = "";
  private String filePath = "";
  private ArrayList<TAVStickerImageItem> imageList = null;
  private boolean isAutoPlay = true;
  private boolean isInit = false;
  private boolean isShowDefaultBorder = false;
  private int layerIndex = -1;
  private float maxScale = 0.0F;
  private float minScale = 0.0F;
  private TAVStickerMode mode = TAVStickerMode.DEFAULT;
  private RectF moveRect = null;
  private PAGFile pagFile = null;
  private ITAVStickerProgressHandler progressHandler;
  private CopyOnWriteArrayList<ITAVStickerRenderer> rendererList = null;
  private float rotate = 0.0F;
  private float scale = 0.5F;
  private int scaleMode = 0;
  private ArrayList<TAVStickerShapeItem> shapeList = null;
  private ArrayList<TAVStickerSolidItem> solidList = null;
  private String stickerId = "";
  private int strokeColor = -16711936;
  private int strokeWidth = 0;
  private TAVStickerMoveLimit tavStickerMoveLimit = TAVStickerMoveLimit.LIMIT_CENTER_POINT;
  private ArrayList<TAVStickerTextItem> textList = null;
  private CMTimeRange timeRange = null;
  private String uniqueId = "";
  
  public static String getLayerValue(@NonNull String paramString)
  {
    try
    {
      String str = new JSONObject(paramString).optString("key");
      return str;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return paramString;
  }
  
  private List<PAGText> getPAGTextListFromFile()
  {
    Object localObject2 = this.pagFile;
    Object localObject1 = null;
    if (localObject2 == null) {
      return null;
    }
    int j = ((PAGFile)localObject2).numTexts();
    if (j > 0)
    {
      localObject2 = new ArrayList();
      int i = 0;
      for (;;)
      {
        localObject1 = localObject2;
        if (i >= j) {
          break;
        }
        localObject1 = this.pagFile.getTextData(i);
        if (localObject1 != null) {
          ((ArrayList)localObject2).add(localObject1);
        }
        i += 1;
      }
    }
    return localObject1;
  }
  
  private ArrayList<PAGLayer> layersInComposition(PAGComposition paramPAGComposition, int paramInt)
  {
    if (paramPAGComposition == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int j = paramPAGComposition.numLayers();
    int i = 0;
    while (i < j)
    {
      Object localObject = paramPAGComposition.getLayerAt(i);
      if (localObject != null) {
        if (6 == ((PAGLayer)localObject).layerType())
        {
          if ((localObject instanceof PAGComposition))
          {
            localObject = layersInComposition((PAGComposition)localObject, paramInt);
            if (!CollectionUtil.isEmptyList((List)localObject)) {
              localArrayList.addAll(localArrayList.size(), (Collection)localObject);
            }
          }
        }
        else if (paramInt == ((PAGLayer)localObject).layerType()) {
          localArrayList.add(localObject);
        }
      }
      i += 1;
    }
    Collections.sort(localArrayList, new TAVSticker.2(this));
    return localArrayList;
  }
  
  private ArrayList<TAVStickerImageItem> readAllImageData()
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = layersInComposition(this.pagFile, 5);
    if (CollectionUtil.isEmptyList(localArrayList2)) {
      return localArrayList1;
    }
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
    return localArrayList1;
  }
  
  private ArrayList<TAVStickerShapeItem> readAllShapeData()
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = layersInComposition(this.pagFile, 4);
    if (CollectionUtil.isEmptyList(localArrayList2)) {
      return localArrayList1;
    }
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
    return localArrayList1;
  }
  
  private ArrayList<TAVStickerTextItem> readAllTextData()
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = layersInComposition(this.pagFile, 3);
    List localList = getPAGTextListFromFile();
    if (!CollectionUtil.isEmptyList(localArrayList2))
    {
      if (CollectionUtil.isEmptyList(localList)) {
        return localArrayList1;
      }
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
            if (localPAGText == null) {
              break label257;
            }
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
          localArrayList1.add(localObject);
        }
        label257:
        i += 1;
      }
    }
    return localArrayList1;
  }
  
  private void removeDuplicatePagLayer(ArrayList<PAGLayer> paramArrayList)
  {
    if (CollectionUtil.isEmptyList(paramArrayList)) {
      return;
    }
    TreeSet localTreeSet = new TreeSet(new TAVSticker.1(this));
    localTreeSet.addAll(paramArrayList);
    paramArrayList.clear();
    paramArrayList.addAll(localTreeSet);
  }
  
  private void setPAGLayerTimeRange()
  {
    if (this.pagFile != null)
    {
      CMTimeRange localCMTimeRange = this.timeRange;
      if ((localCMTimeRange != null) && (localCMTimeRange.isLegal()))
      {
        this.pagFile.setStartTime(this.timeRange.getStartUs());
        this.pagFile.setDuration(this.timeRange.getDurationUs());
      }
    }
  }
  
  public TAVSticker clone()
  {
    TAVSticker localTAVSticker = new TAVSticker();
    localTAVSticker.filePath = this.filePath;
    localTAVSticker.assetFilePath = this.assetFilePath;
    localTAVSticker.uniqueId = UUID.randomUUID().toString();
    localTAVSticker.stickerId = this.stickerId;
    localTAVSticker.layerIndex = this.layerIndex;
    localTAVSticker.pagFile = this.pagFile.copyOriginal();
    localTAVSticker.textList = this.textList;
    localTAVSticker.rendererList = this.rendererList;
    localTAVSticker.imageList = this.imageList;
    localTAVSticker.timeRange = this.timeRange;
    localTAVSticker.progressHandler = this.progressHandler;
    localTAVSticker.strokeColor = this.strokeColor;
    localTAVSticker.strokeWidth = this.strokeWidth;
    localTAVSticker.isShowDefaultBorder = this.isShowDefaultBorder;
    localTAVSticker.scale = this.scale;
    localTAVSticker.scaleMode = this.scaleMode;
    localTAVSticker.minScale = this.minScale;
    localTAVSticker.maxScale = this.maxScale;
    localTAVSticker.rotate = this.rotate;
    localTAVSticker.centerX = this.centerX;
    localTAVSticker.centerY = this.centerY;
    localTAVSticker.tavStickerMoveLimit = this.tavStickerMoveLimit;
    localTAVSticker.moveRect = this.moveRect;
    localTAVSticker.editable = this.editable;
    localTAVSticker.mode = this.mode;
    localTAVSticker.isAutoPlay = this.isAutoPlay;
    localTAVSticker.extras = this.extras;
    localTAVSticker.extraBundle = this.extraBundle;
    return localTAVSticker;
  }
  
  public double computeProgress(long paramLong)
  {
    Object localObject = this.progressHandler;
    if (localObject != null) {
      return ((ITAVStickerProgressHandler)localObject).computeProgress(this, paramLong);
    }
    long l2 = durationTime() / 1000L;
    localObject = this.timeRange;
    long l1 = paramLong;
    if (localObject != null)
    {
      if (!TimeRangeUtil.isInTimeRange((CMTimeRange)localObject, paramLong)) {
        return 0.0D;
      }
      l1 = Math.max(0L, paramLong - this.timeRange.getStartUs() / 1000L);
    }
    if (l2 > 0L)
    {
      if (l1 <= 0L) {
        return 0.0D;
      }
      paramLong = l1 % l2;
      double d1;
      double d2;
      if (paramLong == 0L)
      {
        d1 = 1.0D;
      }
      else
      {
        d1 = paramLong;
        Double.isNaN(d1);
        d2 = l2;
        Double.isNaN(d2);
        d1 = Math.min(1.0D, d1 * 1.0D / d2);
      }
      int i = TAVSticker.4.$SwitchMap$com$tencent$tavsticker$model$TAVSticker$TAVStickerAnimationMode[this.animationMode.ordinal()];
      if (i != 1)
      {
        if (i != 2) {
          return d1;
        }
        localObject = this.timeRange;
        if (localObject == null) {
          return d1;
        }
        d2 = ((CMTimeRange)localObject).getDurationUs();
        Double.isNaN(d2);
        d2 = d2 * 1.0D / 1000.0D;
        if (d2 > l2)
        {
          d1 = l1;
          Double.isNaN(d1);
          return Math.min(1.0D, d1 * 1.0D / d2);
        }
      }
      else
      {
        d1 = l1;
        Double.isNaN(d1);
        d2 = l2;
        Double.isNaN(d2);
        d1 = Math.min(1.0D, d1 * 1.0D / d2);
      }
      return d1;
    }
    return 0.0D;
  }
  
  public long durationTime()
  {
    PAGFile localPAGFile = this.pagFile;
    if (localPAGFile != null) {
      return localPAGFile.duration();
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
  
  public TAVSticker.TAVStickerAnimationMode getAnimationMode()
  {
    return this.animationMode;
  }
  
  public String getAssetFilePath()
  {
    return this.assetFilePath;
  }
  
  public ByteBuffer getAudioData()
  {
    Object localObject = this.pagFile;
    if (localObject == null) {
      return null;
    }
    localObject = ((PAGFile)localObject).audioBytes();
    if (localObject != null) {
      ((ByteBuffer)localObject).rewind();
    }
    return localObject;
  }
  
  public float getAudioStartTime()
  {
    PAGFile localPAGFile = this.pagFile;
    if (localPAGFile != null) {
      return TAVStickerUtil.microsecond2Seconds(localPAGFile.audioStartTime());
    }
    return 0.0F;
  }
  
  public List<TAVStickerLayerInfo.TAVStickerUserData> getAudioUserDatas()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = this.pagFile;
    if (localObject1 == null) {
      return localArrayList;
    }
    localObject1 = ((PAGFile)localObject1).audioMarkers();
    if (localObject1 != null)
    {
      if (localObject1.length <= 0) {
        return localArrayList;
      }
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        Object localObject2 = localObject1[i];
        if (localObject2 != null) {
          localArrayList.add(new TAVStickerLayerInfo.TAVStickerUserData(new CMTimeRange(new CMTime(TAVStickerUtil.microsecond2Seconds(localObject2.mStartTime)), new CMTime(TAVStickerUtil.microsecond2Seconds(localObject2.mDuration))), localObject2.mComment));
        }
        i += 1;
      }
    }
    return localArrayList;
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
    PAGFile localPAGFile = this.pagFile;
    if (localPAGFile != null) {
      return localPAGFile.height();
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
    return this.mode;
  }
  
  public RectF getMoveRect()
  {
    return this.moveRect;
  }
  
  public PAGFile getPagFile()
  {
    return this.pagFile;
  }
  
  public PAGImageLayer getPagImageLayerByName(String paramString, boolean paramBoolean)
  {
    Object localObject = this.pagFile;
    if (localObject == null) {
      return null;
    }
    int k = ((PAGFile)localObject).numImages();
    int i = 0;
    while (i < k)
    {
      localObject = this.pagFile.getLayersByEditableIndex(i, 5);
      if (localObject != null)
      {
        int m = localObject.length;
        int j = 0;
        while (j < m)
        {
          PAGImageLayer localPAGImageLayer = localObject[j];
          if ((localPAGImageLayer instanceof PAGImageLayer))
          {
            localPAGImageLayer = (PAGImageLayer)localPAGImageLayer;
            String str = getLayerValue(localPAGImageLayer.layerName());
            if ((!paramBoolean) || (TextUtils.equals(paramString, str))) {
              return localPAGImageLayer;
            }
          }
          j += 1;
        }
      }
      i += 1;
    }
    return null;
  }
  
  public long getPagSourceDuration(String paramString, boolean paramBoolean)
  {
    paramString = getPagImageLayerByName(paramString, paramBoolean);
    if (paramString != null) {
      return paramString.contentDuration();
    }
    return 0L;
  }
  
  public float getRotate()
  {
    return this.rotate;
  }
  
  public float getScale()
  {
    return this.scale;
  }
  
  public int getScaleMode()
  {
    return this.scaleMode;
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
    localObject1 = getStickerSolidItems();
    if (!CollectionUtil.isEmptyList((List)localObject1))
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (TAVStickerSolidItem)((Iterator)localObject1).next();
        if (localObject2 != null)
        {
          localObject2 = ((TAVStickerSolidItem)localObject2).getLayerInfo();
          if (localObject2 != null) {
            localArrayList.add(localObject2);
          }
        }
      }
    }
    if (!CollectionUtil.isEmptyList(localArrayList)) {
      Collections.sort(localArrayList, new TAVSticker.3(this));
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
  
  public ArrayList<TAVStickerSolidItem> getStickerSolidItems()
  {
    if (this.solidList == null)
    {
      this.solidList = new ArrayList();
      this.solidList.addAll(readAllSolidData());
    }
    return this.solidList;
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
    if (CollectionUtil.isEmptyList((List)localObject)) {
      return null;
    }
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      TAVStickerImageItem localTAVStickerImageItem = (TAVStickerImageItem)((Iterator)localObject).next();
      if ((localTAVStickerImageItem != null) && (paramInt == localTAVStickerImageItem.getLayerIndex())) {
        return localTAVStickerImageItem;
      }
    }
    return null;
  }
  
  public TAVStickerImageItem getTavStickerImageItem(String paramString)
  {
    Object localObject = getStickerImageItems();
    if (CollectionUtil.isEmptyList((List)localObject)) {
      return null;
    }
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      TAVStickerImageItem localTAVStickerImageItem = (TAVStickerImageItem)((Iterator)localObject).next();
      if ((localTAVStickerImageItem != null) && (!TextUtils.isEmpty(paramString)) && (paramString.equals(localTAVStickerImageItem.getLayerName()))) {
        return localTAVStickerImageItem;
      }
    }
    return null;
  }
  
  public TAVStickerSolidItem getTavStickerSolidItem(int paramInt)
  {
    Object localObject = getStickerSolidItems();
    if (!CollectionUtil.isEmptyList((List)localObject))
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        TAVStickerSolidItem localTAVStickerSolidItem = (TAVStickerSolidItem)((Iterator)localObject).next();
        if ((localTAVStickerSolidItem != null) && (paramInt == localTAVStickerSolidItem.getLayerIndex())) {
          return localTAVStickerSolidItem;
        }
      }
    }
    return null;
  }
  
  public TAVStickerTextItem getTavStickerTextItem(int paramInt)
  {
    Object localObject = getStickerTextItems();
    if (CollectionUtil.isEmptyList((List)localObject)) {
      return null;
    }
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      TAVStickerTextItem localTAVStickerTextItem = (TAVStickerTextItem)((Iterator)localObject).next();
      if ((localTAVStickerTextItem != null) && (paramInt == localTAVStickerTextItem.getLayerIndex())) {
        return localTAVStickerTextItem;
      }
    }
    return null;
  }
  
  public TAVStickerTextItem getTavStickerTextItem(String paramString)
  {
    Object localObject = getStickerTextItems();
    if (CollectionUtil.isEmptyList((List)localObject)) {
      return null;
    }
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      TAVStickerTextItem localTAVStickerTextItem = (TAVStickerTextItem)((Iterator)localObject).next();
      if ((localTAVStickerTextItem != null) && (!TextUtils.isEmpty(paramString)) && (paramString.equals(localTAVStickerTextItem.getLayerName()))) {
        return localTAVStickerTextItem;
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
    PAGFile localPAGFile = this.pagFile;
    if (localPAGFile != null) {
      return localPAGFile.width();
    }
    return 0;
  }
  
  public boolean hasVideoTrack(PAGImageLayer paramPAGImageLayer)
  {
    if (paramPAGImageLayer == null) {
      return false;
    }
    paramPAGImageLayer = paramPAGImageLayer.markers();
    if (paramPAGImageLayer != null)
    {
      if (paramPAGImageLayer.length <= 0) {
        return false;
      }
      int j = paramPAGImageLayer.length;
      int i = 0;
      while (i < j)
      {
        String str = paramPAGImageLayer[i].mComment;
        if (!TextUtils.isEmpty(str)) {
          try
          {
            int k = new JSONObject(str).optInt("videoTrack", 0);
            if (1 == k) {
              return true;
            }
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
          }
        }
        i += 1;
      }
    }
    return false;
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
      } else if (!TextUtils.isEmpty(this.assetFilePath)) {
        this.pagFile = TAVPAGFileManager.getInstance().getPAGFileFromAsset(TAVStickerHelper.getContext(), this.assetFilePath);
      }
      if (this.pagFile != null)
      {
        this.uniqueId = UUID.randomUUID().toString();
        if (TextUtils.isEmpty(this.stickerId)) {
          this.stickerId = this.uniqueId;
        }
        this.rendererList = new CopyOnWriteArrayList();
        if (this.timeRange == null) {
          setTimeRange(new CMTimeRange(new CMTime(0L), new CMTime(TAVStickerUtil.microsecond2Seconds(this.pagFile.duration()))));
        }
        setPAGLayerTimeRange();
        updateTextData();
        updateImageData();
        this.isInit = true;
        return this;
      }
      throw new StickerInitializationException("<init> can not initialization TAVSticker, please check the pag file path is correct! Please make sure to use the legal pag file!");
    }
    return this;
  }
  
  public boolean isAutoPlay()
  {
    return this.isAutoPlay;
  }
  
  public boolean isEditable()
  {
    return this.editable;
  }
  
  public boolean isShowDefaultBorder()
  {
    return this.isShowDefaultBorder;
  }
  
  public ArrayList<TAVStickerSolidItem> readAllSolidData()
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = layersInComposition(this.pagFile, 2);
    if (!CollectionUtil.isEmptyList(localArrayList2))
    {
      int j = localArrayList2.size();
      int i = 0;
      while (i < j)
      {
        PAGLayer localPAGLayer = (PAGLayer)localArrayList2.get(i);
        if ((localPAGLayer instanceof PAGSolidLayer)) {
          localArrayList1.add(new TAVStickerSolidItem((PAGSolidLayer)localPAGLayer));
        }
        i += 1;
      }
    }
    return localArrayList1;
  }
  
  public void registerRenderer(ITAVStickerRenderer paramITAVStickerRenderer)
  {
    if (paramITAVStickerRenderer != null)
    {
      CopyOnWriteArrayList localCopyOnWriteArrayList = this.rendererList;
      if ((localCopyOnWriteArrayList != null) && (!localCopyOnWriteArrayList.contains(paramITAVStickerRenderer))) {
        this.rendererList.add(paramITAVStickerRenderer);
      }
    }
    updateTextData();
    updateImageData();
    updateLayerColor();
  }
  
  public void setAnimationMode(TAVSticker.TAVStickerAnimationMode paramTAVStickerAnimationMode)
  {
    this.animationMode = paramTAVStickerAnimationMode;
  }
  
  public TAVSticker setAssetFilePath(String paramString)
  {
    this.assetFilePath = paramString;
    return this;
  }
  
  public TAVSticker setAutoPlay(boolean paramBoolean)
  {
    this.isAutoPlay = paramBoolean;
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
      this.mode = paramTAVStickerMode;
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
  
  public TAVSticker setScaleMode(int paramInt)
  {
    this.scaleMode = paramInt;
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
    setPAGLayerTimeRange();
    return this;
  }
  
  public TAVSticker showDefaultBorder(boolean paramBoolean)
  {
    this.isShowDefaultBorder = paramBoolean;
    return this;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TAVSticker {filePath : ");
    localStringBuilder.append(this.filePath);
    localStringBuilder.append(", uniqueId : ");
    localStringBuilder.append(this.uniqueId);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public void unregisterRenderer(ITAVStickerRenderer paramITAVStickerRenderer)
  {
    CopyOnWriteArrayList localCopyOnWriteArrayList = this.rendererList;
    if (localCopyOnWriteArrayList != null) {
      localCopyOnWriteArrayList.remove(paramITAVStickerRenderer);
    }
  }
  
  public void updateImageData()
  {
    ArrayList localArrayList = getStickerImageItems();
    Object localObject = this.pagFile;
    if ((localObject != null) && (((PAGFile)localObject).numImages() > 0))
    {
      if (CollectionUtil.isEmptyList(localArrayList)) {
        return;
      }
      int i = 0;
      while (i < localArrayList.size())
      {
        localObject = (TAVStickerImageItem)localArrayList.get(i);
        if ((localObject != null) && (((TAVStickerImageItem)localObject).getBitmap() != null))
        {
          this.pagFile.replaceImage(((TAVStickerImageItem)localObject).layerIndex, PAGImage.FromBitmap(((TAVStickerImageItem)localObject).getBitmap()));
          if (!CollectionUtil.isEmptyList(this.rendererList))
          {
            Iterator localIterator = this.rendererList.iterator();
            while (localIterator.hasNext()) {
              ((ITAVStickerRenderer)localIterator.next()).setImageData(((TAVStickerImageItem)localObject).layerIndex, PAGImage.FromBitmap(((TAVStickerImageItem)localObject).getBitmap()));
            }
          }
        }
        i += 1;
      }
    }
  }
  
  public void updateLayerColor()
  {
    getStickerSolidItems();
    if (CollectionUtil.isEmptyList(this.solidList)) {
      return;
    }
    int i = 0;
    while (i < this.solidList.size())
    {
      TAVStickerSolidItem localTAVStickerSolidItem = (TAVStickerSolidItem)this.solidList.get(i);
      if (localTAVStickerSolidItem != null)
      {
        Object localObject = this.pagFile.getLayersByName(localTAVStickerSolidItem.layerName);
        int j = 0;
        while (j < localObject.length)
        {
          if ((localObject[j] instanceof PAGSolidLayer)) {
            ((PAGSolidLayer)localObject[j]).setSolidColor(localTAVStickerSolidItem.getColor());
          }
          j += 1;
        }
        if (!CollectionUtil.isEmptyList(this.rendererList))
        {
          localObject = this.rendererList.iterator();
          while (((Iterator)localObject).hasNext())
          {
            ITAVStickerRenderer localITAVStickerRenderer = (ITAVStickerRenderer)((Iterator)localObject).next();
            if (localITAVStickerRenderer != null) {
              localITAVStickerRenderer.setLayerColor(localTAVStickerSolidItem.getLayerName(), localTAVStickerSolidItem.getColor());
            }
          }
        }
      }
      i += 1;
    }
  }
  
  public void updateTextData()
  {
    List localList = getPAGTextListFromFile();
    if (CollectionUtil.isEmptyList(localList)) {
      return;
    }
    int j = localList.size();
    int i = 0;
    while ((i < j) && (i < getStickerTextItems().size()))
    {
      PAGText localPAGText = (PAGText)localList.get(i);
      Object localObject = (TAVStickerTextItem)getStickerTextItems().get(i);
      if ((localPAGText != null) && (localObject != null))
      {
        if (!TextUtils.isEmpty(((TAVStickerTextItem)localObject).getText())) {
          localPAGText.text = ((TAVStickerTextItem)localObject).getText();
        } else {
          localPAGText.text = "";
        }
        if (((TAVStickerTextItem)localObject).getTextColor() != 0) {
          localPAGText.fillColor = ((TAVStickerTextItem)localObject).getTextColor();
        }
        if (!TextUtils.isEmpty(((TAVStickerTextItem)localObject).getFontFamily())) {
          localPAGText.fontFamily = ((TAVStickerTextItem)localObject).getFontFamily();
        }
        if (!TextUtils.isEmpty(((TAVStickerTextItem)localObject).getFontStyle())) {
          localPAGText.fontStyle = ((TAVStickerTextItem)localObject).getFontStyle();
        }
        if (!CollectionUtil.isEmptyList(this.rendererList))
        {
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
  
  public void updateTransform(CGSize paramCGSize)
  {
    if ((TAVStickerUtil.isValidCGSize(paramCGSize)) && (this.pagFile != null))
    {
      paramCGSize = TAVStickerUtil.getMatrix(this, (int)paramCGSize.width, (int)paramCGSize.height);
      this.pagFile.setMatrix(paramCGSize);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavsticker.model.TAVSticker
 * JD-Core Version:    0.7.0.1
 */