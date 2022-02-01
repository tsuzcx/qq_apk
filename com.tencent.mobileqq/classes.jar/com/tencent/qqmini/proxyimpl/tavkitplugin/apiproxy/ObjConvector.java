package com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.PointF;
import com.tencent.qqmini.proxyimpl.tavkitplugin.TavObjPool;
import com.tencent.qqmini.proxyimpl.tavkitplugin.WeishiPlugin;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.tav.coremedia.CGRect;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tavkit.composition.TAVClip;
import com.tencent.tavsticker.model.TAVStickerImageItem;
import com.tencent.tavsticker.model.TAVStickerLayerInfo;
import com.tencent.tavsticker.model.TAVStickerLayerInfo.TAVStickerImageEffect;
import com.tencent.tavsticker.model.TAVStickerLayerInfo.TAVStickerTimeEffect;
import com.tencent.tavsticker.model.TAVStickerLayerInfo.TAVStickerUserData;
import com.tencent.tavsticker.model.TAVStickerLayerType;
import com.tencent.tavsticker.model.TAVStickerTextItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class ObjConvector
{
  static Matrix a(JSONArray paramJSONArray)
  {
    float f1 = (float)paramJSONArray.getDouble(0);
    float f2 = (float)paramJSONArray.getDouble(1);
    float f3 = (float)paramJSONArray.getDouble(2);
    float f4 = (float)paramJSONArray.getDouble(3);
    float f5 = (float)paramJSONArray.getDouble(4);
    float f6 = (float)paramJSONArray.getDouble(5);
    paramJSONArray = new Matrix();
    paramJSONArray.setValues(new float[] { f1, f3, f5, f2, f4, f6, 0.0F, 0.0F, 1.0F });
    return paramJSONArray;
  }
  
  static PointF a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("x");
    int j = paramJSONObject.getInt("y");
    return new PointF(i, j);
  }
  
  static TavColor a(JSONArray paramJSONArray)
  {
    return new TavColor(paramJSONArray.getInt(0), paramJSONArray.getInt(1), paramJSONArray.getInt(2), paramJSONArray.getInt(3));
  }
  
  static CGRect a(JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = paramJSONObject.getJSONObject("position");
    paramJSONObject = paramJSONObject.getJSONObject("size");
    return new CGRect(a(localJSONObject), a(paramJSONObject));
  }
  
  static CGSize a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("width");
    int j = paramJSONObject.getInt("height");
    return new CGSize(i, j);
  }
  
  static CMTime a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("value");
    int j = paramJSONObject.getInt("timeScale");
    return new CMTime(i, j);
  }
  
  static CMTimeRange a(JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = paramJSONObject.getJSONObject("start");
    paramJSONObject = paramJSONObject.getJSONObject("duration");
    return new CMTimeRange(a(localJSONObject), a(paramJSONObject));
  }
  
  static TAVStickerImageItem a(JSONObject paramJSONObject)
  {
    TAVStickerImageItem localTAVStickerImageItem = new TAVStickerImageItem();
    if (paramJSONObject.has("image"))
    {
      paramJSONObject = a(paramJSONObject.getJSONObject("image"));
      if ((paramJSONObject instanceof Bitmap)) {
        localTAVStickerImageItem.setBitmap((Bitmap)paramJSONObject);
      }
    }
    do
    {
      do
      {
        return localTAVStickerImageItem;
      } while (!paramJSONObject.has("imagePath"));
      paramJSONObject = paramJSONObject.getString("imagePath");
    } while (WeishiPlugin.a == null);
    localTAVStickerImageItem.setBitmap(BitmapFactory.decodeFile(WeishiPlugin.a.getAbsolutePath(paramJSONObject)));
    return localTAVStickerImageItem;
  }
  
  static TAVStickerLayerInfo.TAVStickerImageEffect a(JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = paramJSONObject.getJSONObject("timeRange");
    String str = paramJSONObject.getString("name");
    paramJSONObject = paramJSONObject.getString("effectID");
    return new TAVStickerLayerInfo.TAVStickerImageEffect(a(localJSONObject), paramJSONObject, str);
  }
  
  static TAVStickerLayerInfo.TAVStickerTimeEffect a(JSONObject paramJSONObject)
  {
    boolean bool = true;
    if (paramJSONObject.getInt("reversed") == 1) {}
    for (;;)
    {
      JSONObject localJSONObject = paramJSONObject.getJSONObject("timeRange");
      return new TAVStickerLayerInfo.TAVStickerTimeEffect(a(paramJSONObject.getJSONObject("sourceRange")), a(localJSONObject), bool);
      bool = false;
    }
  }
  
  static TAVStickerLayerInfo.TAVStickerUserData a(JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = paramJSONObject.getJSONObject("timeRange");
    paramJSONObject = paramJSONObject.getString("data");
    return new TAVStickerLayerInfo.TAVStickerUserData(a(localJSONObject), paramJSONObject);
  }
  
  static TAVStickerTextItem a(JSONObject paramJSONObject)
  {
    TAVStickerTextItem localTAVStickerTextItem = new TAVStickerTextItem();
    localTAVStickerTextItem.setText(paramJSONObject.getString("text"));
    localTAVStickerTextItem.setTextColor(a(paramJSONObject.getJSONArray("textColor")).a());
    localTAVStickerTextItem.setFontPath(paramJSONObject.getString("font"));
    return localTAVStickerTextItem;
  }
  
  static Object a(JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.getString("identifier");
    return TavObjPool.a().a(paramJSONObject);
  }
  
  @NotNull
  static List<List<TAVClip>> a(JSONArray paramJSONArray)
  {
    Logger.d("ObjConvector", "toChannels() called with: jsonArray = [" + paramJSONArray + "]");
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramJSONArray.length())
    {
      List localList = b(paramJSONArray.getJSONArray(i));
      if (!localList.isEmpty()) {
        localArrayList.add(localList);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  static <E> List<E> a(JSONArray paramJSONArray, ObjConvector.JsonToObjConvector<E> paramJsonToObjConvector)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramJSONArray.length())
    {
      Object localObject = paramJsonToObjConvector.a(paramJSONArray.getJSONObject(i));
      if (localObject != null) {
        localArrayList.add(localObject);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  static <E> List<E> a(JSONArray paramJSONArray, Class<E> paramClass)
  {
    return a(paramJSONArray, new ObjConvector.9(paramClass));
  }
  
  static JSONArray a(Matrix paramMatrix)
  {
    JSONArray localJSONArray = new JSONArray();
    if (paramMatrix != null)
    {
      float[] arrayOfFloat = new float[9];
      paramMatrix.getValues(arrayOfFloat);
      localJSONArray.put(arrayOfFloat[0]);
      localJSONArray.put(arrayOfFloat[3]);
      localJSONArray.put(arrayOfFloat[1]);
      localJSONArray.put(arrayOfFloat[4]);
      localJSONArray.put(arrayOfFloat[2]);
      localJSONArray.put(arrayOfFloat[5]);
    }
    return localJSONArray;
  }
  
  static JSONArray a(TavColor paramTavColor)
  {
    JSONArray localJSONArray = new JSONArray();
    if (paramTavColor != null)
    {
      localJSONArray.put(paramTavColor.a);
      localJSONArray.put(paramTavColor.b);
      localJSONArray.put(paramTavColor.c);
      localJSONArray.put(paramTavColor.d);
    }
    return localJSONArray;
  }
  
  @NotNull
  static JSONArray a(List<List<? extends TAVClip>> paramList)
  {
    Logger.d("ObjConvector", "fromChannels() called with: channels = [" + paramList + "]");
    JSONArray localJSONArray1 = new JSONArray();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      JSONArray localJSONArray2 = b((List)paramList.next());
      if (localJSONArray2.length() > 0) {
        localJSONArray1.put(localJSONArray2);
      }
    }
    return localJSONArray1;
  }
  
  @NotNull
  static <E> JSONArray a(List<E> paramList, ObjConvector.ObjToJsonConvector<E> paramObjToJsonConvector)
  {
    Logger.d("ObjConvector", "fromChannel() called with: list = [" + paramList + "]");
    JSONArray localJSONArray = new JSONArray();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localJSONArray.put(paramObjToJsonConvector.a(paramList.next()));
    }
    return localJSONArray;
  }
  
  static JSONObject a(PointF paramPointF)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramPointF != null)
    {
      localJSONObject.put("x", paramPointF.x);
      localJSONObject.put("y", paramPointF.y);
    }
    return localJSONObject;
  }
  
  static JSONObject a(PagAudioItem paramPagAudioItem)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramPagAudioItem == null) {
      return localJSONObject;
    }
    localJSONObject.put("filePath", paramPagAudioItem.a());
    localJSONObject.put("startTime", a(paramPagAudioItem.a()));
    localJSONObject.put("dataList", a(paramPagAudioItem.a(), new ObjConvector.1()));
    return localJSONObject;
  }
  
  static JSONObject a(CGRect paramCGRect)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramCGRect != null)
    {
      localJSONObject.put("position", a(paramCGRect.origin));
      localJSONObject.put("size", a(paramCGRect.size));
    }
    return localJSONObject;
  }
  
  static JSONObject a(CGSize paramCGSize)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramCGSize != null)
    {
      localJSONObject.put("width", paramCGSize.width);
      localJSONObject.put("height", paramCGSize.height);
    }
    return localJSONObject;
  }
  
  static JSONObject a(CMTime paramCMTime)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramCMTime != null)
    {
      localJSONObject.put("value", paramCMTime.value);
      localJSONObject.put("timeScale", paramCMTime.timeScale);
    }
    return localJSONObject;
  }
  
  static JSONObject a(CMTimeRange paramCMTimeRange)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramCMTimeRange != null)
    {
      localJSONObject.put("start", a(paramCMTimeRange.getStart()));
      localJSONObject.put("duration", a(paramCMTimeRange.getDuration()));
    }
    return localJSONObject;
  }
  
  static JSONObject a(TAVStickerImageItem paramTAVStickerImageItem)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramTAVStickerImageItem == null) {}
    do
    {
      return localJSONObject;
      localJSONObject.put("layerName", paramTAVStickerImageItem.getLayerName());
      localJSONObject.put("layerInfo", a(paramTAVStickerImageItem.getLayerInfo()));
      paramTAVStickerImageItem = paramTAVStickerImageItem.getBitmap();
    } while (paramTAVStickerImageItem == null);
    localJSONObject.put("image", a(paramTAVStickerImageItem, TavObjPool.a().a(paramTAVStickerImageItem)));
    return localJSONObject;
  }
  
  static JSONObject a(TAVStickerLayerInfo.TAVStickerImageEffect paramTAVStickerImageEffect)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramTAVStickerImageEffect == null) {
      return localJSONObject;
    }
    localJSONObject.put("timeRange", a(paramTAVStickerImageEffect.getTimeRange()));
    localJSONObject.put("name", paramTAVStickerImageEffect.getName());
    localJSONObject.put("effectID", paramTAVStickerImageEffect.getEffectId());
    return localJSONObject;
  }
  
  static JSONObject a(TAVStickerLayerInfo.TAVStickerTimeEffect paramTAVStickerTimeEffect)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramTAVStickerTimeEffect == null) {
      return localJSONObject;
    }
    if (paramTAVStickerTimeEffect.isReversed()) {}
    for (int i = 1;; i = 0)
    {
      localJSONObject.put("reversed", i);
      localJSONObject.put("timeRange", a(paramTAVStickerTimeEffect.getTimeRange()));
      localJSONObject.put("sourceRange", a(paramTAVStickerTimeEffect.getSourceVideoTimeRange()));
      return localJSONObject;
    }
  }
  
  static JSONObject a(TAVStickerLayerInfo.TAVStickerUserData paramTAVStickerUserData)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramTAVStickerUserData == null) {
      return localJSONObject;
    }
    localJSONObject.put("timeRange", a(paramTAVStickerUserData.getTimeRange()));
    paramTAVStickerUserData = paramTAVStickerUserData.getData();
    try
    {
      localJSONObject.put("data", new JSONObject(paramTAVStickerUserData));
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      Logger.e("ObjConvector", "fromObj: ", localJSONException);
      localJSONObject.put("data", paramTAVStickerUserData);
      localJSONObject.put("errorMsg", "data转换json对象失败，返回原始字符串");
    }
    return localJSONObject;
  }
  
  static JSONObject a(TAVStickerLayerInfo paramTAVStickerLayerInfo)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramTAVStickerLayerInfo == null) {
      return localJSONObject;
    }
    localJSONObject.put("layerIndex", paramTAVStickerLayerInfo.getLayerIndex());
    localJSONObject.put("timeRange", a(paramTAVStickerLayerInfo.getTimeRange()));
    localJSONObject.put("type", paramTAVStickerLayerInfo.getLayerType().name());
    if ((paramTAVStickerLayerInfo instanceof TavStickerLayerInfoWrapper))
    {
      localJSONObject.put("sourceDuration", a(((TavStickerLayerInfoWrapper)paramTAVStickerLayerInfo).a()));
      localJSONObject.put("layerSize", a(((TavStickerLayerInfoWrapper)paramTAVStickerLayerInfo).a()));
    }
    localJSONObject.put("timeEffects", a(paramTAVStickerLayerInfo.getTimeEffects(), new ObjConvector.2()));
    localJSONObject.put("imageEffects", a(paramTAVStickerLayerInfo.getImageEffects(), new ObjConvector.3()));
    localJSONObject.put("dataList", a(paramTAVStickerLayerInfo.getUserDataList(), new ObjConvector.4()));
    return localJSONObject;
  }
  
  static JSONObject a(TAVStickerTextItem paramTAVStickerTextItem)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramTAVStickerTextItem != null)
    {
      localJSONObject.put("layerName", paramTAVStickerTextItem.getLayerName());
      localJSONObject.put("layerInfo", a(paramTAVStickerTextItem.getLayerInfo()));
      localJSONObject.put("text", paramTAVStickerTextItem.getText());
      localJSONObject.put("textColor", a(new TavColor(paramTAVStickerTextItem.getTextColor())));
      localJSONObject.put("font", paramTAVStickerTextItem.getFontPath());
    }
    return localJSONObject;
  }
  
  static JSONObject a(Object paramObject, String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("identifier", paramString);
    localJSONObject.put("className", paramObject.getClass().getSimpleName());
    return localJSONObject;
  }
  
  static JSONObject a(Object paramObject1, String paramString1, String paramString2, Object paramObject2)
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("object", a(paramObject1, TavObjPool.a().a(paramObject1)));
    localJSONObject.put("eventName", paramString1);
    localJSONObject.put(paramString2, paramObject2);
    return localJSONObject;
  }
  
  @NotNull
  static List<TAVClip> b(JSONArray paramJSONArray)
  {
    Logger.d("ObjConvector", "toChannel() called with: channel = [" + paramJSONArray + "]");
    return a(paramJSONArray, TAVClip.class);
  }
  
  @NotNull
  static JSONArray b(List<? extends TAVClip> paramList)
  {
    Logger.d("ObjConvector", "fromChannel() called with: channel = [" + paramList + "]");
    return c(paramList);
  }
  
  @NotNull
  static JSONArray c(List paramList)
  {
    Logger.d("ObjConvector", "fromChannel() called with: list = [" + paramList + "]");
    return a(paramList, new ObjConvector.8());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy.ObjConvector
 * JD-Core Version:    0.7.0.1
 */