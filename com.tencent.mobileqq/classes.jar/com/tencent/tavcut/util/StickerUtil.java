package com.tencent.tavcut.util;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavcut.bean.SolidData;
import com.tencent.tavcut.bean.TextEditorData;
import com.tencent.tavcut.bean.TextItem;
import com.tencent.tavsticker.exception.StickerInitializationException;
import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.tavsticker.model.TAVStickerMoveLimit;
import com.tencent.tavsticker.model.TAVStickerSolidItem;
import com.tencent.tavsticker.model.TAVStickerTextItem;
import com.tencent.tavsticker.utils.CollectionUtil;
import com.tencent.tavsticker.utils.TimeRangeUtil;
import com.tencent.weseevideo.editor.sticker.model.TAVStickerExKt;
import com.tencent.weseevideo.editor.sticker.music.WSLyricSticker;
import com.tencent.weseevideo.model.effect.StickerModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class StickerUtil
{
  private static final String TAG = StickerUtil.class.getSimpleName();
  private static final int TIME_SCALE = 1000;
  
  private static TAVStickerSolidItem findSolidItemByName(TAVSticker paramTAVSticker, String paramString)
  {
    if (paramTAVSticker == null) {
      return null;
    }
    paramTAVSticker = paramTAVSticker.getStickerSolidItems();
    if (paramTAVSticker == null) {
      return null;
    }
    paramTAVSticker = paramTAVSticker.iterator();
    while (paramTAVSticker.hasNext())
    {
      TAVStickerSolidItem localTAVStickerSolidItem = (TAVStickerSolidItem)paramTAVSticker.next();
      if ((paramString != null) && (paramString.equals(localTAVStickerSolidItem.getLayerName()))) {
        return localTAVStickerSolidItem;
      }
    }
    return null;
  }
  
  @Nullable
  public static TAVSticker genTavSticker(@NonNull StickerModel paramStickerModel)
  {
    try
    {
      TAVSticker localTAVSticker = new TAVSticker().setFilePath(paramStickerModel.getFilePath()).setAssetFilePath(paramStickerModel.getAssetFilePath()).setCenterX(paramStickerModel.getCenterX()).setCenterY(paramStickerModel.getCenterY()).setScale(paramStickerModel.getScale());
      if (paramStickerModel.getDuration() > 0.0F) {}
      for (CMTimeRange localCMTimeRange = new CMTimeRange(new CMTime(paramStickerModel.getStartTime()), new CMTime(paramStickerModel.getDuration()));; localCMTimeRange = null)
      {
        paramStickerModel = localTAVSticker.setTimeRange(localCMTimeRange).setTavStickerMoveLimit(TAVStickerMoveLimit.LIMIT_VERTEX).setMaxScale(paramStickerModel.getMaxScale()).setMinScale(paramStickerModel.getMinScale()).init();
        return paramStickerModel;
      }
      return null;
    }
    catch (StickerInitializationException paramStickerModel)
    {
      Logger.e(paramStickerModel);
    }
  }
  
  public static TextEditorData stickerModel2EditorData(TAVSticker paramTAVSticker)
  {
    int i = 0;
    Object localObject = null;
    if (!CollectionUtil.isEmptyCollection(paramTAVSticker.getStickerTextItems())) {
      localObject = (TAVStickerTextItem)paramTAVSticker.getStickerTextItems().get(0);
    }
    if (localObject == null) {
      localObject = new TAVStickerTextItem();
    }
    for (;;)
    {
      TAVStickerSolidItem localTAVStickerSolidItem = findSolidItemByName(paramTAVSticker, "bgcolor");
      String str1 = paramTAVSticker.getStickerId();
      String str2 = paramTAVSticker.getExtras();
      int j = ((TAVStickerTextItem)localObject).getTextColor();
      String str3 = ((TAVStickerTextItem)localObject).getText();
      String str4 = paramTAVSticker.getFilePath();
      localObject = ((TAVStickerTextItem)localObject).getFontPath();
      if (localTAVStickerSolidItem == null) {}
      for (;;)
      {
        localObject = new TextEditorData(str1, str2, j, str3, str4, (String)localObject, i);
        ((TextEditorData)localObject).setInteractive(String.valueOf(TAVStickerExKt.getStickerInteractive(paramTAVSticker)));
        if ((paramTAVSticker instanceof WSLyricSticker)) {
          ((TextEditorData)localObject).setStickerType("sticker_lyric");
        }
        return localObject;
        i = localTAVStickerSolidItem.getColor();
      }
    }
  }
  
  public static TAVSticker stickerModel2TavSticker(StickerModel paramStickerModel)
  {
    int k = 0;
    Object localObject2 = new CMTimeRange(new CMTime(paramStickerModel.getStartTime(), 1000), new CMTime(((float)paramStickerModel.getEndTime() - paramStickerModel.getStartTime()), 1000));
    Object localObject1 = localObject2;
    if (!TimeRangeUtil.isValidTimeRange((CMTimeRange)localObject2)) {
      localObject1 = null;
    }
    localObject1 = new TAVSticker().setExtras(paramStickerModel.getMaterialId()).setFilePath(paramStickerModel.getFilePath()).setAssetFilePath(paramStickerModel.getAssetFilePath()).setLayerIndex(paramStickerModel.getLayerIndex()).setScale(paramStickerModel.getScale()).setRotate(paramStickerModel.getRotate()).setCenterX(paramStickerModel.getCenterX()).setCenterY(paramStickerModel.getCenterY()).setEditable(paramStickerModel.isEditable()).setMinScale(paramStickerModel.getMinScale()).setMaxScale(paramStickerModel.getMaxScale()).setTimeRange((CMTimeRange)localObject1);
    TAVStickerExKt.setStickerScaleX((TAVSticker)localObject1, paramStickerModel.getScaleX());
    TAVStickerExKt.setStickerScaleY((TAVSticker)localObject1, paramStickerModel.getScaleY());
    TAVStickerExKt.setStickerEnableRotate((TAVSticker)localObject1, paramStickerModel.isEnableRotate());
    TAVStickerExKt.setStickerLockRatio((TAVSticker)localObject1, paramStickerModel.isLockRatio());
    TAVStickerExKt.setStickerScaleMaxX((TAVSticker)localObject1, paramStickerModel.getScaleXMax());
    TAVStickerExKt.setStickerScaleMaxY((TAVSticker)localObject1, paramStickerModel.getScaleYMax());
    TAVStickerExKt.setStickerScaleMinX((TAVSticker)localObject1, paramStickerModel.getScaleXMin());
    TAVStickerExKt.setStickerScaleMinY((TAVSticker)localObject1, paramStickerModel.getScaleYMin());
    TAVStickerExKt.setExtraStickerType((TAVSticker)localObject1, paramStickerModel.getType());
    TAVStickerExKt.setStickerTextPngPath((TAVSticker)localObject1, paramStickerModel.getTextPngPath());
    TAVStickerExKt.setStickerTexturePngPath((TAVSticker)localObject1, paramStickerModel.getTexturePngPath());
    TAVStickerExKt.setStickerInteractive((TAVSticker)localObject1, paramStickerModel.getInteractive());
    if (!TextUtils.isEmpty(paramStickerModel.getUniqueId())) {
      ((TAVSticker)localObject1).setStickerId(paramStickerModel.getUniqueId());
    }
    int j;
    Object localObject3;
    try
    {
      ((TAVSticker)localObject1).init();
      int i = 0;
      for (;;)
      {
        j = k;
        if (i >= paramStickerModel.getTextItems().size()) {
          break label497;
        }
        if (i >= ((TAVSticker)localObject1).getStickerTextItems().size()) {
          break;
        }
        ((TAVStickerTextItem)((TAVSticker)localObject1).getStickerTextItems().get(i)).setText(((TextItem)paramStickerModel.getTextItems().get(i)).getText());
        ((TAVStickerTextItem)((TAVSticker)localObject1).getStickerTextItems().get(i)).setTextColor(((TextItem)paramStickerModel.getTextItems().get(i)).getTextColor());
        localObject2 = ((TextItem)paramStickerModel.getTextItems().get(i)).getFontPath();
        localObject3 = ((TextItem)paramStickerModel.getTextItems().get(i)).getAssetFontPath();
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          ((TAVStickerTextItem)((TAVSticker)localObject1).getStickerTextItems().get(i)).setFontPath((String)localObject2);
        }
        if (!TextUtils.isEmpty((CharSequence)localObject3)) {
          ((TAVStickerTextItem)((TAVSticker)localObject1).getStickerTextItems().get(i)).setAssetFontPath((String)localObject3);
        }
        i += 1;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        continue;
        Logger.w(TAG, "sticker.stickerTextItems is not correct");
      }
    }
    for (;;)
    {
      j += 1;
      label497:
      if (j < paramStickerModel.getSolidItems().size())
      {
        localObject3 = ((TAVSticker)localObject1).getStickerSolidItems();
        if (!CollectionUtil.isEmptyList((List)localObject3)) {
          break label538;
        }
      }
      label538:
      Map localMap;
      do
      {
        ((TAVSticker)localObject1).updateTextData();
        ((TAVSticker)localObject1).updateLayerColor();
        return localObject1;
        localMap = paramStickerModel.getSolidItems();
      } while (CollectionUtil.isEmptyMap(localMap));
      localObject3 = ((List)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        TAVStickerSolidItem localTAVStickerSolidItem = (TAVStickerSolidItem)((Iterator)localObject3).next();
        SolidData localSolidData = (SolidData)localMap.get(localTAVStickerSolidItem.getLayerName());
        if (localSolidData != null) {
          localTAVStickerSolidItem.setColor(localSolidData.getColor());
        }
      }
    }
  }
  
  public static StickerModel tavSticker2StickerModel(TAVSticker paramTAVSticker)
  {
    long l2 = 0L;
    StickerModel localStickerModel = new StickerModel();
    localStickerModel.setUniqueId(paramTAVSticker.getStickerId());
    localStickerModel.setMaterialId(paramTAVSticker.getExtras());
    localStickerModel.setFilePath(paramTAVSticker.getFilePath());
    localStickerModel.setAssetFilePath(paramTAVSticker.getAssetFilePath());
    if (paramTAVSticker.getTimeRange() != null) {}
    ArrayList localArrayList;
    Object localObject2;
    Object localObject3;
    for (long l1 = paramTAVSticker.getTimeRange().getStartUs();; l1 = 0L)
    {
      localStickerModel.setStartTime((float)l1 * 1.0F / 1000.0F);
      l1 = l2;
      if (paramTAVSticker.getTimeRange() != null) {
        l1 = paramTAVSticker.getTimeRange().getEndUs();
      }
      localStickerModel.setEndTime(l1 / 1000L);
      localStickerModel.setLayerIndex(paramTAVSticker.getLayerIndex());
      localStickerModel.setScale(paramTAVSticker.getScale());
      localStickerModel.setRotate(paramTAVSticker.getRotate());
      localStickerModel.setCenterX(paramTAVSticker.getCenterX());
      localStickerModel.setCenterY(paramTAVSticker.getCenterY());
      localStickerModel.setEditable(paramTAVSticker.isEditable());
      localStickerModel.setWidth(paramTAVSticker.getWidth());
      localStickerModel.setHeight(paramTAVSticker.getHeight());
      localStickerModel.setMinScale(paramTAVSticker.getMinScale());
      localStickerModel.setMaxScale(paramTAVSticker.getMaxScale());
      localStickerModel.setType(TAVStickerExKt.getExtraStickerType(paramTAVSticker));
      localStickerModel.setTexturePngPath(TAVStickerExKt.getStickerTexturePngPath(paramTAVSticker));
      localStickerModel.setTextPngPath(TAVStickerExKt.getStickerTextPngPath(paramTAVSticker));
      localStickerModel.setScaleX(TAVStickerExKt.getStickerScaleX(paramTAVSticker));
      localStickerModel.setScaleY(TAVStickerExKt.getStickerScaleY(paramTAVSticker));
      localStickerModel.setScaleXMin(TAVStickerExKt.getStickerScaleMinX(paramTAVSticker));
      localStickerModel.setScaleYMin(TAVStickerExKt.getSticerScaleMinY(paramTAVSticker));
      localStickerModel.setScaleXMax(TAVStickerExKt.getStickerScaleMaxX(paramTAVSticker));
      localStickerModel.setScaleYMax(TAVStickerExKt.getStickerScaleMaxY(paramTAVSticker));
      localStickerModel.setLockRatio(TAVStickerExKt.isLockRatio(paramTAVSticker));
      localStickerModel.setEnableRotate(TAVStickerExKt.isRotateEnable(paramTAVSticker));
      localStickerModel.setInteractive(TAVStickerExKt.getStickerInteractive(paramTAVSticker));
      localArrayList = new ArrayList();
      localObject1 = paramTAVSticker.getStickerTextItems().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (TAVStickerTextItem)((Iterator)localObject1).next();
        localObject3 = new TextItem();
        ((TextItem)localObject3).setFontPath(((TAVStickerTextItem)localObject2).getFontPath());
        ((TextItem)localObject3).setAssetFontPath(((TAVStickerTextItem)localObject2).getAssetFontPath());
        ((TextItem)localObject3).setText(((TAVStickerTextItem)localObject2).getText());
        ((TextItem)localObject3).setTextColor(((TAVStickerTextItem)localObject2).getTextColor());
        localArrayList.add(localObject3);
      }
    }
    Object localObject1 = new HashMap();
    paramTAVSticker = paramTAVSticker.getStickerSolidItems().iterator();
    for (;;)
    {
      if (paramTAVSticker.hasNext())
      {
        localObject2 = (TAVStickerSolidItem)paramTAVSticker.next();
        if (localObject2 != null) {}
      }
      else
      {
        localStickerModel.setTextItems(localArrayList);
        localStickerModel.setSolidItems((Map)localObject1);
        return localStickerModel;
      }
      localObject3 = new SolidData();
      ((SolidData)localObject3).setColor(((TAVStickerSolidItem)localObject2).getColor());
      ((Map)localObject1).put(((TAVStickerSolidItem)localObject2).getLayerName(), localObject3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tavcut.util.StickerUtil
 * JD-Core Version:    0.7.0.1
 */