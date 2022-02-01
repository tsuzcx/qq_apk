package com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.PointF;
import com.tencent.qqmini.proxyimpl.tavkitplugin.TavObjPool;
import com.tencent.qqmini.proxyimpl.tavkitplugin.WeishiPlugin;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppFileManager;
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
import org.jetbrains.annotations.Nullable;
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
  
  static TAVStickerTextItem a(JSONObject paramJSONObject, ArrayList<TAVStickerTextItem> paramArrayList)
  {
    TAVStickerTextItem localTAVStickerTextItem = (TAVStickerTextItem)c(paramJSONObject, paramArrayList);
    paramArrayList = localTAVStickerTextItem;
    if (localTAVStickerTextItem == null) {
      paramArrayList = new TAVStickerTextItem();
    }
    paramArrayList.setText(paramJSONObject.getString("text"));
    paramArrayList.setTextColor(b(paramJSONObject.getJSONArray("textColor")).a());
    paramArrayList.setFontPath(paramJSONObject.getString("font"));
    return paramArrayList;
  }
  
  static Object a(JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.getString("identifier");
    return TavObjPool.a().a(paramJSONObject);
  }
  
  static <E> List<E> a(JSONArray paramJSONArray, ObjConvector.JsonToObjConvector<E> paramJsonToObjConvector)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramJSONArray.length())
    {
      Object localObject = paramJsonToObjConvector.b(paramJSONArray.getJSONObject(i));
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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("fromChannels() called with: channels = [");
    ((StringBuilder)localObject).append(paramList);
    ((StringBuilder)localObject).append("]");
    Logger.d("ObjConvector", ((StringBuilder)localObject).toString());
    localObject = new JSONArray();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      JSONArray localJSONArray = b((List)paramList.next());
      if (localJSONArray.length() > 0) {
        ((JSONArray)localObject).put(localJSONArray);
      }
    }
    return localObject;
  }
  
  @NotNull
  static <E> JSONArray a(List<E> paramList, ObjConvector.ObjToJsonConvector<E> paramObjToJsonConvector)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("fromChannel() called with: list = [");
    ((StringBuilder)localObject).append(paramList);
    ((StringBuilder)localObject).append("]");
    Logger.d("ObjConvector", ((StringBuilder)localObject).toString());
    localObject = new JSONArray();
    if (paramList == null) {
      return localObject;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      ((JSONArray)localObject).put(paramObjToJsonConvector.a(paramList.next()));
    }
    return localObject;
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
    localJSONObject.put("identifier", System.identityHashCode(paramPagAudioItem));
    localJSONObject.put("filePath", paramPagAudioItem.a());
    localJSONObject.put("startTime", a(paramPagAudioItem.b()));
    localJSONObject.put("dataList", a(paramPagAudioItem.c(), new ObjConvector.1()));
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
    if (paramTAVStickerImageItem == null) {
      return localJSONObject;
    }
    localJSONObject.put("identifier", System.identityHashCode(paramTAVStickerImageItem));
    localJSONObject.put("layerName", paramTAVStickerImageItem.getLayerName());
    localJSONObject.put("layerInfo", a(paramTAVStickerImageItem.getLayerInfo()));
    paramTAVStickerImageItem = paramTAVStickerImageItem.getBitmap();
    if (paramTAVStickerImageItem != null) {
      localJSONObject.put("image", a(paramTAVStickerImageItem, TavObjPool.a().a(paramTAVStickerImageItem)));
    }
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
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
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
    localJSONObject.put("identifier", System.identityHashCode(paramTAVStickerLayerInfo));
    localJSONObject.put("layerIndex", paramTAVStickerLayerInfo.getLayerIndex());
    localJSONObject.put("timeRange", a(paramTAVStickerLayerInfo.getTimeRange()));
    localJSONObject.put("type", paramTAVStickerLayerInfo.getLayerType().name());
    if ((paramTAVStickerLayerInfo instanceof TavStickerLayerInfoWrapper))
    {
      TavStickerLayerInfoWrapper localTavStickerLayerInfoWrapper = (TavStickerLayerInfoWrapper)paramTAVStickerLayerInfo;
      localJSONObject.put("sourceDuration", a(localTavStickerLayerInfoWrapper.a()));
      localJSONObject.put("layerSize", a(localTavStickerLayerInfoWrapper.b()));
    }
    localJSONObject.put("timeEffects", a(paramTAVStickerLayerInfo.getTimeEffects(), new ObjConvector.2()));
    localJSONObject.put("imageEffects", a(paramTAVStickerLayerInfo.getImageEffects(), new ObjConvector.3()));
    localJSONObject.put("dataList", a(paramTAVStickerLayerInfo.getUserDataList(), new ObjConvector.4()));
    return localJSONObject;
  }
  
  static JSONObject a(TAVStickerTextItem paramTAVStickerTextItem)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramTAVStickerTextItem == null) {
      return localJSONObject;
    }
    localJSONObject.put("identifier", System.identityHashCode(paramTAVStickerTextItem));
    localJSONObject.put("layerName", paramTAVStickerTextItem.getLayerName());
    localJSONObject.put("layerInfo", a(paramTAVStickerTextItem.getLayerInfo()));
    localJSONObject.put("text", paramTAVStickerTextItem.getText());
    localJSONObject.put("textColor", a(new TavColor(paramTAVStickerTextItem.getTextColor())));
    localJSONObject.put("font", paramTAVStickerTextItem.getFontPath());
    return localJSONObject;
  }
  
  static JSONObject a(Object paramObject, String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramObject != null)
    {
      localJSONObject.put("identifier", paramString);
      localJSONObject.put("className", paramObject.getClass().getSimpleName());
    }
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
  
  static TavColor b(JSONArray paramJSONArray)
  {
    return new TavColor(paramJSONArray.getInt(0), paramJSONArray.getInt(1), paramJSONArray.getInt(2), paramJSONArray.getInt(3));
  }
  
  static CMTime b(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("value");
    int j = paramJSONObject.getInt("timeScale");
    return new CMTime(i, j);
  }
  
  static TAVStickerImageItem b(JSONObject paramJSONObject, ArrayList<TAVStickerImageItem> paramArrayList)
  {
    TAVStickerImageItem localTAVStickerImageItem = (TAVStickerImageItem)c(paramJSONObject, paramArrayList);
    paramArrayList = localTAVStickerImageItem;
    if (localTAVStickerImageItem == null) {
      paramArrayList = new TAVStickerImageItem();
    }
    if (paramJSONObject.has("image"))
    {
      paramJSONObject = a(paramJSONObject.getJSONObject("image"));
      if ((paramJSONObject instanceof Bitmap))
      {
        paramArrayList.setBitmap((Bitmap)paramJSONObject);
        return paramArrayList;
      }
    }
    else if (paramJSONObject.has("imagePath"))
    {
      paramJSONObject = paramJSONObject.getString("imagePath");
      if (WeishiPlugin.a != null) {
        paramArrayList.setBitmap(BitmapFactory.decodeFile(WeishiPlugin.a.getAbsolutePath(paramJSONObject)));
      }
    }
    return paramArrayList;
  }
  
  @NotNull
  static JSONArray b(List<? extends TAVClip> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fromChannel() called with: channel = [");
    localStringBuilder.append(paramList);
    localStringBuilder.append("]");
    Logger.d("ObjConvector", localStringBuilder.toString());
    return c(paramList);
  }
  
  static CMTimeRange c(JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = paramJSONObject.getJSONObject("start");
    paramJSONObject = paramJSONObject.getJSONObject("duration");
    return new CMTimeRange(b(localJSONObject), b(paramJSONObject));
  }
  
  @Nullable
  private static <E> E c(JSONObject paramJSONObject, ArrayList<E> paramArrayList)
  {
    if (paramArrayList != null)
    {
      if (!paramJSONObject.has("identifier")) {
        return null;
      }
      long l = paramJSONObject.getLong("identifier");
      paramJSONObject = paramArrayList.iterator();
      while (paramJSONObject.hasNext())
      {
        paramArrayList = paramJSONObject.next();
        if (l == System.identityHashCode(paramArrayList)) {
          return paramArrayList;
        }
      }
    }
    return null;
  }
  
  @NotNull
  static List<List<TAVClip>> c(JSONArray paramJSONArray)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("toChannels() called with: jsonArray = [");
    ((StringBuilder)localObject).append(paramJSONArray);
    ((StringBuilder)localObject).append("]");
    Logger.d("ObjConvector", ((StringBuilder)localObject).toString());
    localObject = new ArrayList();
    int i = 0;
    while (i < paramJSONArray.length())
    {
      List localList = d(paramJSONArray.getJSONArray(i));
      if (!localList.isEmpty()) {
        ((List)localObject).add(localList);
      }
      i += 1;
    }
    return localObject;
  }
  
  @NotNull
  static JSONArray c(List paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fromChannel() called with: list = [");
    localStringBuilder.append(paramList);
    localStringBuilder.append("]");
    Logger.d("ObjConvector", localStringBuilder.toString());
    return a(paramList, new ObjConvector.8());
  }
  
  static CGSize d(JSONObject paramJSONObject)
  {
    double d1 = paramJSONObject.getDouble("width");
    double d2 = paramJSONObject.getDouble("height");
    return new CGSize((float)d1, (float)d2);
  }
  
  @NotNull
  static List<TAVClip> d(JSONArray paramJSONArray)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("toChannel() called with: channel = [");
    localStringBuilder.append(paramJSONArray);
    localStringBuilder.append("]");
    Logger.d("ObjConvector", localStringBuilder.toString());
    return a(paramJSONArray, TAVClip.class);
  }
  
  static PointF e(JSONObject paramJSONObject)
  {
    double d1 = paramJSONObject.getDouble("x");
    double d2 = paramJSONObject.getDouble("y");
    return new PointF((float)d1, (float)d2);
  }
  
  static CGRect f(JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = paramJSONObject.getJSONObject("position");
    paramJSONObject = paramJSONObject.getJSONObject("size");
    return new CGRect(e(localJSONObject), d(paramJSONObject));
  }
  
  static TAVStickerLayerInfo.TAVStickerTimeEffect g(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("reversed");
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    JSONObject localJSONObject = paramJSONObject.getJSONObject("timeRange");
    return new TAVStickerLayerInfo.TAVStickerTimeEffect(c(paramJSONObject.getJSONObject("sourceRange")), c(localJSONObject), bool);
  }
  
  static TAVStickerLayerInfo.TAVStickerImageEffect h(JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = paramJSONObject.getJSONObject("timeRange");
    String str = paramJSONObject.getString("name");
    paramJSONObject = paramJSONObject.getString("effectID");
    return new TAVStickerLayerInfo.TAVStickerImageEffect(c(localJSONObject), paramJSONObject, str);
  }
  
  static TAVStickerLayerInfo.TAVStickerUserData i(JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = paramJSONObject.getJSONObject("timeRange");
    paramJSONObject = paramJSONObject.getString("data");
    return new TAVStickerLayerInfo.TAVStickerUserData(c(localJSONObject), paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy.ObjConvector
 * JD-Core Version:    0.7.0.1
 */