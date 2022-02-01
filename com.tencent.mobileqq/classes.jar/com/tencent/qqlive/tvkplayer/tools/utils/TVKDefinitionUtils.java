package com.tencent.qqlive.tvkplayer.tools.utils;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TVKDefinitionUtils
{
  private static Map<String, String> mDefNameList = new HashMap();
  private static ArrayList<String> mDefaultDefnList;
  
  static
  {
    mDefNameList.put("fhd", "蓝光  1080P");
    mDefNameList.put("hd", "高清  360P");
    mDefNameList.put("msd", "流畅 180P");
    mDefNameList.put("sd", "标清  270P");
    mDefNameList.put("mp4", "高清  360P");
    mDefNameList.put("shd", "超清  720P");
    mDefaultDefnList = new ArrayList();
    mDefaultDefnList.add("msd");
    mDefaultDefnList.add("hd");
    mDefaultDefnList.add("mp4");
    mDefaultDefnList.add("sd");
    mDefaultDefnList.add("fhd");
    mDefaultDefnList.add("shd");
  }
  
  public static String getDefShowName(String paramString)
  {
    String str = (String)mDefNameList.get(paramString);
    paramString = str;
    if (TextUtils.isEmpty(str)) {
      paramString = "";
    }
    return paramString;
  }
  
  public static ArrayList<String> getDefaultDefList()
  {
    return mDefaultDefnList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.tools.utils.TVKDefinitionUtils
 * JD-Core Version:    0.7.0.1
 */