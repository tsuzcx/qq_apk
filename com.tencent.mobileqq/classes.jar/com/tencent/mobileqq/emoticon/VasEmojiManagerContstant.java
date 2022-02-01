package com.tencent.mobileqq.emoticon;

import com.tencent.mobileqq.emoticonview.EmotionPanelConstans;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class VasEmojiManagerContstant
{
  public static final String PARAMS_DOWNLOAD_START = "vas_download_start";
  public static HashMap<String, MagicTip> sMagicTips = new HashMap();
  
  public static void delete(String paramString)
  {
    paramString = getEpId(paramString);
    VasUpdateUtil.a(new File(EmotionPanelConstans.emoticonPackageFolderPath.replace("[epId]", paramString)));
  }
  
  public static String getEpId(String paramString)
  {
    return paramString.substring(23, paramString.indexOf('.', 23));
  }
  
  public static String getSavePath(String paramString)
  {
    paramString = getEpId(paramString);
    return EmotionPanelConstans.H5MagicZipPath.replace("[epId]", paramString);
  }
  
  public static void setMagicTips(JSONArray paramJSONArray)
  {
    HashMap localHashMap = new HashMap();
    if ((paramJSONArray != null) && (paramJSONArray.length() > 0))
    {
      int i = paramJSONArray.length();
      while (i >= 0)
      {
        JSONObject localJSONObject = (JSONObject)paramJSONArray.opt(i);
        if (localJSONObject != null) {
          try
          {
            String str = localJSONObject.getString("id");
            MagicTip localMagicTip = new MagicTip();
            localMagicTip.leftText = localJSONObject.getString("leftText");
            localMagicTip.linkText = localJSONObject.getString("linkText");
            localMagicTip.type = localJSONObject.getString("type");
            localHashMap.put(str, localMagicTip);
          }
          catch (JSONException localJSONException)
          {
            QLog.e("VasEmojiManager", 1, "setMagicTips: ", localJSONException);
          }
        }
        i -= 1;
      }
    }
    sMagicTips = localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.VasEmojiManagerContstant
 * JD-Core Version:    0.7.0.1
 */