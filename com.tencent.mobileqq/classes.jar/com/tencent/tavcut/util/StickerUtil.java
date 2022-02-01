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
  private static final String TAG = "StickerUtil";
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
    for (;;)
    {
      try
      {
        TAVSticker localTAVSticker = new TAVSticker().setFilePath(paramStickerModel.getFilePath()).setAssetFilePath(paramStickerModel.getAssetFilePath()).setCenterX(paramStickerModel.getCenterX()).setCenterY(paramStickerModel.getCenterY()).setScale(paramStickerModel.getScale());
        if (paramStickerModel.getDuration() > 0.0F)
        {
          localCMTimeRange = new CMTimeRange(new CMTime(paramStickerModel.getStartTime()), new CMTime(paramStickerModel.getDuration()));
          paramStickerModel = localTAVSticker.setTimeRange(localCMTimeRange).setTavStickerMoveLimit(TAVStickerMoveLimit.LIMIT_VERTEX).setMaxScale(paramStickerModel.getMaxScale()).setMinScale(paramStickerModel.getMinScale()).init();
          return paramStickerModel;
        }
      }
      catch (StickerInitializationException paramStickerModel)
      {
        Logger.e(paramStickerModel);
        return null;
      }
      CMTimeRange localCMTimeRange = null;
    }
  }
  
  public static TextEditorData stickerModel2EditorData(TAVSticker paramTAVSticker)
  {
    if (!CollectionUtil.isEmptyCollection(paramTAVSticker.getStickerTextItems())) {
      localObject1 = (TAVStickerTextItem)paramTAVSticker.getStickerTextItems().get(0);
    } else {
      localObject1 = null;
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = new TAVStickerTextItem();
    }
    Object localObject1 = findSolidItemByName(paramTAVSticker, "bgcolor");
    String str1 = paramTAVSticker.getStickerId();
    String str2 = paramTAVSticker.getExtras();
    int j = ((TAVStickerTextItem)localObject2).getTextColor();
    String str3 = ((TAVStickerTextItem)localObject2).getText();
    String str4 = paramTAVSticker.getFilePath();
    localObject2 = ((TAVStickerTextItem)localObject2).getFontPath();
    int i;
    if (localObject1 == null) {
      i = 0;
    } else {
      i = ((TAVStickerSolidItem)localObject1).getColor();
    }
    localObject1 = new TextEditorData(str1, str2, j, str3, str4, (String)localObject2, i);
    ((TextEditorData)localObject1).setInteractive(String.valueOf(TAVStickerExKt.getStickerInteractive(paramTAVSticker)));
    if ((paramTAVSticker instanceof WSLyricSticker)) {
      ((TextEditorData)localObject1).setStickerType("sticker_lyric");
    }
    return localObject1;
  }
  
  public static TAVSticker stickerModel2TavSticker(StickerModel paramStickerModel)
  {
    CMTimeRange localCMTimeRange = new CMTimeRange(new CMTime(paramStickerModel.getStartTime(), 1000), new CMTime(((float)paramStickerModel.getEndTime() - paramStickerModel.getStartTime()), 1000));
    Object localObject1 = localCMTimeRange;
    if (!TimeRangeUtil.isValidTimeRange(localCMTimeRange)) {
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
    try
    {
      ((TAVSticker)localObject1).init();
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    int k = 0;
    int i = 0;
    int j;
    Object localObject2;
    Object localObject3;
    for (;;)
    {
      j = k;
      if (i >= paramStickerModel.getTextItems().size()) {
        break;
      }
      if (i < ((TAVSticker)localObject1).getStickerTextItems().size())
      {
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
      }
      else
      {
        Logger.w(TAG, "sticker.stickerTextItems is not correct");
      }
      i += 1;
    }
    while (j < paramStickerModel.getSolidItems().size())
    {
      localObject3 = ((TAVSticker)localObject1).getStickerSolidItems();
      if (CollectionUtil.isEmptyList((List)localObject3)) {
        break;
      }
      localObject2 = paramStickerModel.getSolidItems();
      if (CollectionUtil.isEmptyMap((Map)localObject2)) {
        break;
      }
      localObject3 = ((List)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        TAVStickerSolidItem localTAVStickerSolidItem = (TAVStickerSolidItem)((Iterator)localObject3).next();
        SolidData localSolidData = (SolidData)((Map)localObject2).get(localTAVStickerSolidItem.getLayerName());
        if (localSolidData != null) {
          localTAVStickerSolidItem.setColor(localSolidData.getColor());
        }
      }
      j += 1;
    }
    ((TAVSticker)localObject1).updateTextData();
    ((TAVSticker)localObject1).updateLayerColor();
    return localObject1;
  }
  
  public static StickerModel tavSticker2StickerModel(TAVSticker paramTAVSticker)
  {
    StickerModel localStickerModel = new StickerModel();
    localStickerModel.setUniqueId(paramTAVSticker.getStickerId());
    localStickerModel.setMaterialId(paramTAVSticker.getExtras());
    localStickerModel.setFilePath(paramTAVSticker.getFilePath());
    localStickerModel.setAssetFilePath(paramTAVSticker.getAssetFilePath());
    Object localObject1 = paramTAVSticker.getTimeRange();
    long l2 = 0L;
    if (localObject1 != null) {
      l1 = paramTAVSticker.getTimeRange().getStartUs();
    } else {
      l1 = 0L;
    }
    localStickerModel.setStartTime((float)l1 * 1.0F / 1000.0F);
    long l1 = l2;
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
    localObject1 = new ArrayList();
    Object localObject2 = paramTAVSticker.getStickerTextItems().iterator();
    Object localObject3;
    Object localObject4;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (TAVStickerTextItem)((Iterator)localObject2).next();
      localObject4 = new TextItem();
      ((TextItem)localObject4).setFontPath(((TAVStickerTextItem)localObject3).getFontPath());
      ((TextItem)localObject4).setAssetFontPath(((TAVStickerTextItem)localObject3).getAssetFontPath());
      ((TextItem)localObject4).setText(((TAVStickerTextItem)localObject3).getText());
      ((TextItem)localObject4).setTextColor(((TAVStickerTextItem)localObject3).getTextColor());
      ((List)localObject1).add(localObject4);
    }
    localObject2 = new HashMap();
    paramTAVSticker = paramTAVSticker.getStickerSolidItems().iterator();
    while (paramTAVSticker.hasNext())
    {
      localObject3 = (TAVStickerSolidItem)paramTAVSticker.next();
      if (localObject3 == null) {
        break;
      }
      localObject4 = new SolidData();
      ((SolidData)localObject4).setColor(((TAVStickerSolidItem)localObject3).getColor());
      ((Map)localObject2).put(((TAVStickerSolidItem)localObject3).getLayerName(), localObject4);
    }
    localStickerModel.setTextItems((List)localObject1);
    localStickerModel.setSolidItems((Map)localObject2);
    return localStickerModel;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavcut.util.StickerUtil
 * JD-Core Version:    0.7.0.1
 */