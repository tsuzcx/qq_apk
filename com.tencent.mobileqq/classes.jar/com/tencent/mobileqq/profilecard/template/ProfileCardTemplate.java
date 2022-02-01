package com.tencent.mobileqq.profilecard.template;

import android.graphics.Shader.TileMode;
import android.graphics.Typeface;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public class ProfileCardTemplate
{
  public static final int ANIMATION_FADE_IN_OUT = 2;
  public static final int ANIMATION_NONE = 0;
  public static final int ANIMATION_SCROLL = 1;
  public static final String BACKGROUND = "background";
  public static long DEFAULT_PROFILE_CARD_STYLE_ID = 0L;
  public static final HashMap<String, Integer> GRAVITY_MAP;
  public static long PROFILE_CARD_STYLE_DIY = 10000L;
  public static long PROFILE_CARD_STYLE_DIY_TEMPLATE = 22L;
  public static long PROFILE_CARD_STYLE_DIY_TEMPLATE_2 = 23L;
  public static long PROFILE_CARD_STYLE_FRESH = 1L;
  public static long PROFILE_CARD_STYLE_GAME = 5L;
  public static long PROFILE_CARD_STYLE_JANYUE = 4L;
  public static long PROFILE_CARD_STYLE_NEW_V800 = 21L;
  public static long PROFILE_CARD_STYLE_SHOPPING = 9L;
  public static long PROFILE_CARD_STYLE_SIMPLE = 8L;
  public static long PROFILE_CARD_STYLE_SOCIAL = 6L;
  public static long PROFILE_CARD_STYLE_TAG = 7L;
  public static long PROFILE_CARD_STYLE_WZRY_DYNAMIC = 11L;
  public static long PROFILE_CARD_STYLE_WZRY_STATIC = 10L;
  public static final String PROFILE_COMMON_VERSION = "583";
  public static final String QVIP_PROFILE_TEMPLATE_JSON = "qvip_profile_template.json";
  public static final String STYLE = "style";
  public static final HashMap<String, String> STYLE_NAME_MAP = new HashMap();
  public static final HashMap<String, Shader.TileMode> TILE_MODE_MAP;
  public static JSONObject mBlackStyleConfig;
  public static JSONObject mWhiteStyleConfig;
  public static Typeface wzryTTFChn;
  public static Typeface wzryTTFNum;
  public int animation = 0;
  public String auth = "";
  public int customBackgroundAuth = 0;
  public String downloadUrl = "";
  public String frameBlack = "";
  public String frameBlackMax = "";
  public String frameBlackMin = "";
  public String frameBlackSmall = "";
  public String frameWhite = "";
  public String frameWhiteMax = "";
  public String frameWhiteMin = "";
  public String frameWhiteSmall = "";
  public String imageBlack = "";
  public String imageBlackMax = "";
  public String imageBlackMin = "";
  public String imageBlackSmall = "";
  public int imageSize = 0;
  public String imageWhite = "";
  public String imageWhiteMax = "";
  public String imageWhiteMin = "";
  public String imageWhiteSmall = "";
  public boolean isHide = false;
  public int limitefreeBtime;
  public int limitefreeEtime;
  public int limitefreeType;
  public String name = "";
  public int size = 0;
  public long styleId = 0L;
  public int tag = 0;
  public int tagBeginTime = 0;
  public int tagEndTime = 0;
  public ConcurrentHashMap<String, Object> templateAttr = new ConcurrentHashMap();
  public int templateBeginTime = 0;
  public int templateEndTime = 0;
  public String version = "0";
  public String whitelist = "";
  
  static
  {
    GRAVITY_MAP = new HashMap();
    TILE_MODE_MAP = new HashMap();
    GRAVITY_MAP.put("top", Integer.valueOf(48));
    HashMap localHashMap = GRAVITY_MAP;
    Integer localInteger = Integer.valueOf(80);
    localHashMap.put("bottom", localInteger);
    GRAVITY_MAP.put("left", localInteger);
    GRAVITY_MAP.put("right", localInteger);
    GRAVITY_MAP.put("center_vertical", localInteger);
    GRAVITY_MAP.put("fill_vertical", localInteger);
    GRAVITY_MAP.put("center_horizontal", localInteger);
    GRAVITY_MAP.put("fill_horizontal", localInteger);
    GRAVITY_MAP.put("center", localInteger);
    GRAVITY_MAP.put("fill", localInteger);
    GRAVITY_MAP.put("clip_vertical", localInteger);
    GRAVITY_MAP.put("clip_horizontal", localInteger);
    TILE_MODE_MAP.put("clamp", Shader.TileMode.CLAMP);
    TILE_MODE_MAP.put("repeat", Shader.TileMode.REPEAT);
    TILE_MODE_MAP.put("mirror", Shader.TileMode.MIRROR);
    STYLE_NAME_MAP.put(String.valueOf(PROFILE_CARD_STYLE_FRESH), "game");
    STYLE_NAME_MAP.put(String.valueOf(PROFILE_CARD_STYLE_JANYUE), "game");
    STYLE_NAME_MAP.put(String.valueOf(PROFILE_CARD_STYLE_GAME), "game");
    STYLE_NAME_MAP.put(String.valueOf(PROFILE_CARD_STYLE_SOCIAL), "photo");
    STYLE_NAME_MAP.put(String.valueOf(PROFILE_CARD_STYLE_SIMPLE), "simple");
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Field[] arrayOfField = getClass().getFields();
    localStringBuilder.append("ProfileCardTemplate:");
    int j = arrayOfField.length;
    int i = 0;
    while (i < j)
    {
      Field localField = arrayOfField[i];
      if (localField.getModifiers() != 8) {
        try
        {
          Object localObject = localField.get(this);
          localStringBuilder.append(localField.getName());
          localStringBuilder.append('=');
          localStringBuilder.append(localObject);
          localStringBuilder.append(',');
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
      i += 1;
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.template.ProfileCardTemplate
 * JD-Core Version:    0.7.0.1
 */