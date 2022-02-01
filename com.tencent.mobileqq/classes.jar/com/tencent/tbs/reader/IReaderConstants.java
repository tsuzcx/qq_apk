package com.tencent.tbs.reader;

public abstract interface IReaderConstants
{
  public static final int FEAT_MASK_DECRYPT = 2;
  public static final int FEAT_MASK_DISPLAY = 512;
  public static final int FEAT_MASK_EDIT = 16;
  public static final int FEAT_MASK_ENTER_EDIT = 8;
  public static final int FEAT_MASK_EXPORT_BMP = 4;
  public static final int FEAT_MASK_FIND_MODE = 1;
  public static final int FEAT_MASK_FITSCREEN = 32;
  public static final int FEAT_MASK_OUTLINE = 256;
  public static final int FEAT_MASK_PASTE = 64;
  public static final int FEAT_MASK_SELECT_TEXT = 128;
  public static final int MENU_TYPE_IMAGE = 200;
  public static final int MENU_TYPE_IMAGE_GETIMAGE = 201;
  public static final int MENU_TYPE_TEXT = 100;
  public static final int MENU_TYPE_TEXT_BROWSE_COPY = 101;
  public static final int MENU_TYPE_TEXT_BROWSE_ENTER_EDIT = 102;
  public static final int MENU_TYPE_TEXT_BROWSE_GETTEXT = 103;
  public static final int MENU_TYPE_TEXT_EDITING_ENTER_SELECT = 111;
  public static final int MENU_TYPE_TEXT_EDITING_PASTE = 112;
  public static final int MENU_TYPE_TEXT_EDIT_SELECT_COPY = 121;
  public static final int MENU_TYPE_TEXT_EDIT_SELECT_GETTEXT = 123;
  public static final int MENU_TYPE_TEXT_EDIT_SELECT_PASTE = 122;
  public static final int READER_CB_ASK_PASSWORD = 3023;
  public static final int READER_CB_CLICK = 3010;
  public static final int READER_CB_DECRYPT_RESULT = 3024;
  public static final int READER_CB_ENTER_EDIT_DONE = 3002;
  public static final int READER_CB_ENTER_FIND_DONE = 3025;
  public static final int READER_CB_EXIT_EDIT_DONE = 3003;
  public static final int READER_CB_EXIT_FIND_DONE = 3026;
  public static final int READER_CB_FEATURE_FLAG = 3019;
  public static final int READER_CB_FILE_MODIFIED = 3006;
  public static final int READER_CB_FILE_OPENED = 3001;
  public static final int READER_CB_FIND_RESULT = 3005;
  public static final int READER_CB_HYPERLINK = 3009;
  public static final int READER_CB_OUTLINE = 3007;
  public static final int READER_CB_PAGE_NUMBER = 3008;
  public static final int READER_CB_QRY_DECRYPT_SUPPORT = 3022;
  public static final int READER_CB_SAVE_DONE = 3004;
  public static final int READER_CB_SCALE_BEGIN = 3014;
  public static final int READER_CB_SCALE_END = 3015;
  public static final int READER_CB_SCROLLING = 3013;
  public static final int READER_CB_SCROLL_BEGIN = 3011;
  public static final int READER_CB_SCROLL_END = 3012;
  public static final int READER_CB_SCROLL_RATIO = 3016;
  public static final int READER_CB_SELECT_IMAGE = 3021;
  public static final int READER_CB_SELECT_TEXT = 3020;
  public static final int READER_MODE_DISPLAY = 4;
  public static final int READER_MODE_EDIT = 3;
  public static final int READER_MODE_FIND = 2;
  public static final int READER_MODE_NORMAL = 1;
  public static final String TBS_READER_FEATURE_CUSTOM = "reader_custom";
  public static final int TBS_READER_TYPE_PLUGIN_ERR = 5025;
  public static final int TBS_READER_TYPE_SDK_CREATE_READER_ERR = 1001;
  public static final int TBS_READER_TYPE_SDK_DOWNLOAD_FILE_ERR = 1004;
  public static final int TBS_READER_TYPE_SDK_DOWNLOAD_FILE_SUCCESS = 1003;
  public static final int TBS_READER_TYPE_SDK_ENTRY_LOAD_ERR = 1000;
  public static final int TBS_READER_TYPE_SDK_OPEN_FILE_ERR = 1101;
  public static final int TBS_READER_TYPE_SDK_OPEN_FILE_SUCCESS = 1100;
  public static final int TBS_READER_TYPE_SDK_SUPPORT_EXT_ERR = 1002;
  public static final int TBS_READER_TYPE_STATUS_UI_OPENED = 0;
  public static final int TBS_READER_TYPE_STATUS_UI_SHUTDOWN = 1;
  public static final String TBS_READER_UI_STYLE = "style";
  public static final int TBS_READER_UI_STYLE_DEFAULT = 0;
  public static final int TBS_READER_UI_STYLE_QQ = 2;
  public static final int TBS_READER_UI_STYLE_WECHAT = 1;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tbs.reader.IReaderConstants
 * JD-Core Version:    0.7.0.1
 */