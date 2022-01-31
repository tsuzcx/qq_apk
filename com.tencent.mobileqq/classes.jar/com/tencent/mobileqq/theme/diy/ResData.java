package com.tencent.mobileqq.theme.diy;

public class ResData
{
  static final String BUNDLE_KEY_INDEX = "index";
  static final String BUNDLE_KEY_TYPE = "type";
  static final int RES_DATA_STATE_DEALED = 5;
  static final int RES_DATA_STATE_DEALING = 4;
  static final int RES_DATA_STATE_ERROR = -1;
  static final int RES_DATA_STATE_INIT = 0;
  static final int RES_DATA_STATE_LOADED = 2;
  static final int RES_DATA_STATE_LOADING = 1;
  static final int RES_DATA_STATE_OK = 2;
  public static final int RES_LOADING_TYPE_AIO = 3;
  public static final int RES_LOADING_TYPE_MSG = 2;
  public static final int RES_LOADING_TYPE_SETTING = 1;
  static final int RES_TYPE_JSON_BG = 100;
  static final int RES_TYPE_JSON_STYLE = 200;
  static final int RES_TYPE_PIC_JPG_BG_BIG = 116;
  static final int RES_TYPE_PIC_JPG_BG_BIG_ORG = 115;
  static final int RES_TYPE_PIC_JPG_BG_CUSTOM = 120;
  static final int RES_TYPE_PIC_JPG_BG_CUSTOM_ORG = 121;
  static final int RES_TYPE_PIC_JPG_BG_PREVIEW = 110;
  static final int RES_TYPE_PIC_JPG_BG_THUM = 117;
  static final int RES_TYPE_PIC_JPG_STYLE_THUM = 202;
  static final int RES_TYPE_PIC_PNG_STYLE_SHOT = 201;
  static final int RES_TYPE_ZIP_STYLE = 207;
  String dealThemeID;
  String dealedName;
  int from;
  public String id;
  int index;
  public int loadingType;
  String name;
  public String path;
  int resID;
  int state;
  public int type;
  public String url;
  
  public ResData() {}
  
  public ResData(String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.name = paramString1;
    this.id = paramString2;
    this.index = paramInt1;
    this.path = paramString3;
    this.url = paramString4;
    this.state = paramInt2;
    this.type = paramInt3;
    this.from = paramInt5;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.theme.diy.ResData
 * JD-Core Version:    0.7.0.1
 */