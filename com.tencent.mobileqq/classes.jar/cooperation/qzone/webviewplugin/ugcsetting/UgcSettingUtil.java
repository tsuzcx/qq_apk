package cooperation.qzone.webviewplugin.ugcsetting;

import android.os.Bundle;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

public class UgcSettingUtil
{
  public static final String KEY_ANSWER = "key_answer";
  public static final String KEY_NICKNAMES = "key_nicknames";
  public static final String KEY_PARSE_JSON_STATUS = "key_parse_json_status";
  public static final String KEY_PERMISSION_CODE = "permission_code";
  public static final String KEY_QUESTION = "key_question";
  public static final String KEY_TAG_INFO = "key_selected_tag";
  public static final String KEY_UGC_SETTING_RAW_JSON = "key_setting_raw_json";
  public static final String KEY_UIN_LIST = "uin_list";
  private static final int PERMITION_ALBUM_QUESTION = 5;
  private static final int PERMITION_ALL_PUBLIC = 0;
  private static final int PERMITION_BLACKLIST = 4;
  private static final int PERMITION_FRIENDS_CIRCLE = 6;
  private static final int PERMITION_ONLYSELF = 2;
  private static final int PERMITION_QQFRIEND = 1;
  private static final int PERMITION_WHITELIST = 3;
  public static final int UGCFLAG_ALBUM_QUESTION = 9999;
  public static final int UGCFLAG_ALL_PUBLIC = 1;
  public static final int UGCFLAG_BLACKLIST = 128;
  public static final int UGCFLAG_ONLYSELF = 64;
  public static final int UGCFLAG_QQFRIEND = 4;
  public static final int UGCFLAG_SECONDCIRCLE = 512;
  public static final int UGCFLAG_WHITELIST = 16;
  
  public static String getPrivacyDescriptionForShuoShuo(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 4)
      {
        if (paramInt != 16)
        {
          if (paramInt != 64)
          {
            if (paramInt != 128) {
              return "公开";
            }
            return "指定人";
          }
          return "私密";
        }
        return "指定人";
      }
      return "好友";
    }
    return "公开";
  }
  
  public static String liveUgcSettingToJson(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return "";
    }
    Object localObject = paramBundle.getString("key_setting_raw_json");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      return localObject;
    }
    localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("flag", paramBundle.getInt("permission_flag"));
      ArrayList localArrayList = paramBundle.getStringArrayList("uin_list");
      paramBundle = paramBundle.getStringArrayList("key_nicknames");
      if ((localArrayList != null) && (!localArrayList.isEmpty()))
      {
        if ((paramBundle != null) && (paramBundle.size() == localArrayList.size()))
        {
          JSONObject localJSONObject = new JSONObject();
          int j = localArrayList.size();
          int i = 0;
          while (i < j)
          {
            localJSONObject.put((String)localArrayList.get(i), paramBundle.get(i));
            i += 1;
          }
          ((JSONObject)localObject).put("uinList", localJSONObject);
          return ((JSONObject)localObject).toString();
        }
        return ((JSONObject)localObject).toString();
      }
      paramBundle = ((JSONObject)localObject).toString();
      return paramBundle;
    }
    catch (Exception paramBundle) {}
    return "";
  }
  
  public static Bundle parseJson(Bundle paramBundle, String paramString)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putString("key_setting_raw_json", paramString);
    try
    {
      paramString = new JSONObject(paramString);
      i = paramString.getInt("id");
      switch (i)
      {
      case 6: 
        localBundle.putInt("permission_code", 512);
      }
    }
    catch (Exception paramBundle)
    {
      Object localObject;
      Iterator localIterator;
      localBundle.putInt("permission_code", 1);
      localBundle.putString("key_parse_json_status", paramBundle.getMessage());
      paramBundle.printStackTrace();
      return localBundle;
    }
    localBundle.putInt("permission_code", 9999);
    paramBundle = paramString.optString("question");
    localObject = paramString.optString("answer");
    localBundle.putString("key_question", paramBundle);
    localBundle.putString("key_answer", (String)localObject);
    break label410;
    localBundle.putInt("permission_code", 128);
    break label410;
    localBundle.putInt("permission_code", 16);
    break label410;
    localBundle.putInt("permission_code", 64);
    break label410;
    localBundle.putInt("permission_code", 4);
    break label410;
    localBundle.putInt("permission_code", 1);
    break label410;
    label184:
    paramBundle = "";
    if (paramString.has("msg")) {
      paramBundle = paramString.optString("msg");
    }
    localBundle.putString("key_selected_tag", paramBundle);
    paramBundle = new StringBuilder();
    if (i == 4) {
      paramBundle.append("除了 ");
    }
    paramString = paramString.getJSONObject("uinList");
    localObject = new ArrayList();
    localIterator = paramString.keys();
    for (int i = 1;; i = 0) {
      if (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        ((ArrayList)localObject).add(str);
        if (i == 0) {
          paramBundle.append("、");
        }
        if (paramBundle.length() < 15) {
          paramBundle.append(paramString.getString(str));
        }
      }
      else
      {
        paramString = paramBundle.toString();
        paramBundle = paramString;
        if (paramString.length() > 15)
        {
          paramBundle = new StringBuilder();
          paramBundle.append(paramString.substring(0, 15));
          paramBundle.append("...");
          paramBundle = paramBundle.toString();
        }
        localBundle.putStringArrayList("uin_list", (ArrayList)localObject);
        localBundle.putString("key_nicknames", paramBundle);
        return localBundle;
        label410:
        do
        {
          break;
          if (i == 3) {
            break label184;
          }
        } while (i != 4);
        break label184;
      }
    }
  }
  
  public static Bundle parseLiveJson(Bundle paramBundle, String paramString)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putString("key_setting_raw_json", paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        localBundle.putInt("permission_flag", paramString.getInt("flag"));
        paramBundle = "";
        if (paramString.has("msg")) {
          paramBundle = paramString.optString("msg");
        }
        localBundle.putString("key_selected_tag", paramBundle);
        paramBundle = paramString.getJSONObject("uinList");
        ArrayList localArrayList = new ArrayList();
        paramString = paramBundle.keys();
        i = 1;
        if (paramString.hasNext())
        {
          String str = (String)paramString.next();
          localArrayList.add(str);
          if (i == 0) {
            localStringBuilder.append("、");
          }
          if (localStringBuilder.length() < 15) {
            localStringBuilder.append(paramBundle.getString(str));
          }
        }
        else
        {
          paramString = localStringBuilder.toString();
          paramBundle = paramString;
          if (paramString.length() > 15)
          {
            paramBundle = new StringBuilder();
            paramBundle.append(paramString.substring(0, 15));
            paramBundle.append("...");
            paramBundle = paramBundle.toString();
          }
          localBundle.putStringArrayList("uin_list", localArrayList);
          localBundle.putString("key_nicknames", paramBundle);
          return localBundle;
        }
      }
      catch (Exception paramBundle)
      {
        localBundle.putInt("permission_flag", 1);
        localBundle.putString("key_parse_json_status", paramBundle.getMessage());
        paramBundle.printStackTrace();
        return localBundle;
      }
      int i = 0;
    }
  }
  
  public static String ugcSettingToJson(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return "";
    }
    Object localObject = paramBundle.getString("key_setting_raw_json");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      return localObject;
    }
    int i = 1;
    int k = paramBundle.getInt("permission_code", 1);
    int j = 0;
    if (k != 1)
    {
      if (k == 4) {
        break label109;
      }
      if (k == 16) {
        break label107;
      }
      if (k == 64) {
        break label102;
      }
      if (k == 128) {
        break label97;
      }
      if (k == 512) {
        break label91;
      }
      if (k == 9999) {}
    }
    else
    {
      i = 0;
      break label109;
    }
    i = 5;
    break label109;
    label91:
    i = 6;
    break label109;
    label97:
    i = 4;
    break label109;
    label102:
    i = 2;
    break label109;
    label107:
    i = 3;
    label109:
    localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("id", i);
      if ((i != 3) && (i != 4))
      {
        if (i == 5)
        {
          ((JSONObject)localObject).put("question", paramBundle.getString("key_question"));
          ((JSONObject)localObject).put("answer", paramBundle.getString("key_answer"));
        }
      }
      else
      {
        ArrayList localArrayList = paramBundle.getStringArrayList("uin_list");
        paramBundle = paramBundle.getStringArrayList("key_nicknames");
        if ((localArrayList == null) || (localArrayList.isEmpty())) {
          break label297;
        }
        if ((paramBundle == null) || (paramBundle.size() != localArrayList.size())) {
          break label291;
        }
        JSONObject localJSONObject = new JSONObject();
        k = localArrayList.size();
        i = j;
        while (i < k)
        {
          localJSONObject.put((String)localArrayList.get(i), paramBundle.get(i));
          i += 1;
        }
        ((JSONObject)localObject).put("uinList", localJSONObject);
      }
      return ((JSONObject)localObject).toString();
      label291:
      return ((JSONObject)localObject).toString();
      label297:
      paramBundle = ((JSONObject)localObject).toString();
      return paramBundle;
    }
    catch (Exception paramBundle) {}
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.ugcsetting.UgcSettingUtil
 * JD-Core Version:    0.7.0.1
 */