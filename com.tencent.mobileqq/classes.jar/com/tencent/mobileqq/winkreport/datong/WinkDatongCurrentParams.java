package com.tencent.mobileqq.winkreport.datong;

import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;

public class WinkDatongCurrentParams
{
  public static HashMap<String, Object> params = new HashMap();
  public static HashMap<String, String> paramsForPublish = new HashMap();
  
  static
  {
    params.put("xsj_session_id", WinkNativeSessionManager.g().getSessionId());
    params.put("xsj_camera_session_id", WinkNativeSessionManager.g().getCameraSessionId());
    params.put("xsj_operation_activity_id", "none");
    params.put("xsj_camera_clck_ref_pgid", "none");
    params.put("xsj_template_name", "none");
    params.put("xsj_filter_name", "none");
    params.put("xsj_paste_name", "none");
    params.put("xsj_char_form_name", "none");
    params.put("xsj_char_pattern_name", "none");
    params.put("xsj_char_art_name", "none");
    params.put("xsj_music_id", "none");
    params.put("xsj_music_name", "none");
    HashMap localHashMap = params;
    Integer localInteger = Integer.valueOf(0);
    localHashMap.put("xsj_music_is_default", localInteger);
    params.put("xsj_music_from", "recomd");
    params.put("xsj_music_volume_value", "none");
    params.put("xsj_original_volume_value", "none");
    params.put("xsj_music_is_cut", localInteger);
    params.put("xsj_paitongkuan_type", "none");
    params.put("xsj_paitongkuan_id", "none");
  }
  
  public static Object get(String paramString)
  {
    return params.get(paramString);
  }
  
  public static Map<String, Object> getMap()
  {
    return params;
  }
  
  public static void put(String paramString, Object paramObject)
  {
    params.put(paramString, paramObject);
  }
  
  public static String toJson()
  {
    return new Gson().toJson(params);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkreport.datong.WinkDatongCurrentParams
 * JD-Core Version:    0.7.0.1
 */