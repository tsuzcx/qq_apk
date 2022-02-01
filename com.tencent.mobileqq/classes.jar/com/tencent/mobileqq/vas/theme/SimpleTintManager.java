package com.tencent.mobileqq.vas.theme;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.text.TextUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.ISkinTint;
import com.tencent.theme.SkinEngine;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

public class SimpleTintManager
  implements ISkinTint
{
  private static final String KEY_COMMON_CONFIG = "commonConfig";
  private static final String KEY_DEFAULT_COLOR = "defaultColor";
  private static final String KEY_DRAWABLE_LIST = "drawableFilterList";
  private static final String KEY_TEXT_PLIST = "textPlist";
  private static final String TAG = "SimpleTintManager";
  private static volatile SimpleTintManager sTintManager;
  protected Map<String, String> mCustomColorMap = new HashMap();
  private int mThemeColor = -1;
  protected String mThemeId;
  protected Map<String, String> mTintDrawableNames = new HashMap();
  
  private SimpleTintManager()
  {
    parseConfig();
  }
  
  public static SimpleTintManager instance()
  {
    if (sTintManager == null) {
      try
      {
        if (sTintManager == null) {
          sTintManager = new SimpleTintManager();
        }
      }
      finally {}
    }
    return sTintManager;
  }
  
  private int parseColor(String paramString)
  {
    return parseColor(paramString, -1);
  }
  
  private int parseColor(String paramString, int paramInt)
  {
    try
    {
      if (paramString.contains(".xml")) {
        return parseXmlColor(paramString, paramInt);
      }
      if (TextUtils.isEmpty(paramString)) {
        return this.mThemeColor;
      }
      int i = Color.parseColor(paramString);
      return i;
    }
    catch (Exception paramString) {}
    return paramInt;
  }
  
  private void parseConfig()
  {
    if (this.mThemeId == null)
    {
      QLog.d("SimpleTintManager", 1, "mThemeId is null, reinit");
      this.mThemeId = QQTheme.getCurrentThemeId();
    }
    Object localObject1 = this.mThemeId;
    if (localObject1 == null)
    {
      QLog.d("SimpleTintManager", 1, "mThemeId is null");
      return;
    }
    if (!QQTheme.isThemeSimpleUI((String)localObject1))
    {
      QLog.d("SimpleTintManager", 1, new Object[] { "not simple ui, mThemeId is : ", this.mThemeId });
      return;
    }
    Object localObject3 = SimpleUIManager.b(BaseApplication.getContext());
    if ("2920".equals(this.mThemeId)) {
      localObject1 = "config_night.json";
    } else {
      localObject1 = "config.json";
    }
    localObject1 = FileUtils.readFileContent(new File((String)localObject3, (String)localObject1));
    label339:
    Object localObject2;
    do
    {
      try
      {
        localObject1 = new JSONObject((String)localObject1);
        localObject3 = ((JSONObject)localObject1).optJSONObject(this.mThemeId);
        this.mThemeColor = parseColor(((JSONObject)localObject3).optString("defaultColor"), -1);
        JSONObject localJSONObject1 = ((JSONObject)localObject3).optJSONObject("textPlist");
        JSONObject localJSONObject2 = ((JSONObject)localObject3).optJSONObject("drawableFilterList");
        parseJSONObject2Map(localJSONObject1, this.mCustomColorMap);
        parseJSONObject2Map(localJSONObject2, this.mTintDrawableNames);
        QLog.d("SimpleTintManager", 1, new Object[] { "color map size : ", Integer.valueOf(this.mCustomColorMap.size()) });
        QLog.d("SimpleTintManager", 1, new Object[] { "drawable map size : ", Integer.valueOf(this.mTintDrawableNames.size()) });
        localObject1 = ((JSONObject)localObject1).optJSONObject(((JSONObject)localObject3).optString("commonConfig"));
        localObject3 = null;
        if (localObject1 == null) {
          break label339;
        }
        localJSONObject1 = ((JSONObject)localObject1).optJSONObject("textPlist");
        localJSONObject2 = ((JSONObject)localObject1).optJSONObject("drawableFilterList");
        localObject3 = new HashMap();
        localObject1 = new HashMap();
        parseJSONObject2Map(localJSONObject1, (Map)localObject3);
        parseJSONObject2Map(localJSONObject2, (Map)localObject1);
      }
      catch (Exception localException)
      {
        QLog.e("SimpleTintManager", 1, "parseConfig error : ", localException);
        SimpleUIManager.a(BaseApplication.getContext());
        return;
      }
      rebuildDataMap((Map)localObject3, this.mCustomColorMap);
      rebuildDataMap((Map)localObject1, this.mTintDrawableNames);
      return;
      while (localObject3 == null)
      {
        return;
        localObject2 = null;
      }
    } while (localObject2 != null);
  }
  
  private void parseJSONObject2Map(JSONObject paramJSONObject, Map<String, String> paramMap)
  {
    if (paramJSONObject != null)
    {
      if (paramMap == null) {
        return;
      }
      Iterator localIterator = paramJSONObject.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        paramMap.put(str, paramJSONObject.optString(str));
      }
    }
  }
  
  private int parseXmlColor(String paramString, int paramInt)
  {
    BaseApplication localBaseApplication = BaseApplication.getContext();
    if (localBaseApplication != null)
    {
      paramString = paramString.replace(".xml", "");
      int i = BaseApplication.getContext().getResources().getIdentifier(paramString, "color", localBaseApplication.getPackageName());
      if (i > 0) {
        return SkinEngine.getInstances().getColor(i);
      }
    }
    return paramInt;
  }
  
  private void rebuildDataMap(Map<String, String> paramMap1, Map<String, String> paramMap2)
  {
    paramMap1 = paramMap1.entrySet().iterator();
    while (paramMap1.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap1.next();
      String str = (String)localEntry.getKey();
      if (!paramMap2.containsKey(str)) {
        paramMap2.put(str, localEntry.getValue());
      }
    }
  }
  
  private void setColors(int[] paramArrayOfInt, int paramInt, Integer paramInteger)
  {
    if ((paramInteger != null) && (paramArrayOfInt != null) && (paramArrayOfInt.length > paramInt)) {
      paramArrayOfInt[paramInt] = paramInteger.intValue();
    }
  }
  
  public void checkSkinEngineInit()
  {
    if ((QQTheme.isNowSimpleUI()) && (!SimpleUIManager.a())) {
      SimpleUIManager.b();
    }
  }
  
  public void clear()
  {
    this.mCustomColorMap.clear();
    this.mTintDrawableNames.clear();
    this.mThemeId = null;
  }
  
  public boolean isTint(String paramString)
  {
    return (this.mTintDrawableNames.containsKey(paramString)) || (this.mCustomColorMap.containsKey(paramString));
  }
  
  public void loadConfig(Resources paramResources, String paramString)
  {
    TintManager.a().clear();
  }
  
  public void setThemeId(String paramString)
  {
    QLog.d("SimpleTintManager", 1, new Object[] { "set theme id : ", paramString });
    clear();
    this.mThemeId = paramString;
    parseConfig();
  }
  
  public void tint(Paint paramPaint, String paramString)
  {
    if (paramPaint != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      if (!isTint(paramString)) {
        return;
      }
      String str = (String)this.mTintDrawableNames.get(paramString);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("tint filename is : ");
      localStringBuilder.append(paramString);
      QLog.d("SimpleTintManager", 1, new Object[] { localStringBuilder.toString(), " color : ", str });
      int i;
      if (TextUtils.isEmpty(str)) {
        i = this.mThemeColor;
      } else {
        i = parseColor(str);
      }
      paramPaint.setColorFilter(new LightingColorFilter(0, i));
    }
  }
  
  public void tintColorState(int[] paramArrayOfInt, int[][] paramArrayOfInt1, String paramString)
  {
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length != 0) && (!this.mCustomColorMap.isEmpty()))
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      if (!this.mCustomColorMap.containsKey(paramString)) {
        return;
      }
      paramArrayOfInt1 = (String)this.mCustomColorMap.get(paramString);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("tint color filename is : ");
      localStringBuilder.append(paramString);
      paramString = localStringBuilder.toString();
      int i = 0;
      QLog.d("SimpleTintManager", 1, new Object[] { paramString, " color : ", paramArrayOfInt1 });
      if (paramArrayOfInt1.contains(","))
      {
        paramArrayOfInt1 = paramArrayOfInt1.split(",");
        while (i < paramArrayOfInt1.length)
        {
          int j;
          if (TextUtils.isEmpty(paramArrayOfInt1[i])) {
            j = this.mThemeColor;
          } else {
            j = parseColor(paramArrayOfInt1[i]);
          }
          setColors(paramArrayOfInt, i, Integer.valueOf(j));
          i += 1;
        }
        return;
      }
      if (TextUtils.isEmpty(paramArrayOfInt1)) {
        i = this.mThemeColor;
      } else {
        i = parseColor(paramArrayOfInt1);
      }
      setColors(paramArrayOfInt, 0, Integer.valueOf(i));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.theme.SimpleTintManager
 * JD-Core Version:    0.7.0.1
 */