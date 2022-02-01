package com.tencent.mobileqq.theme;

import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;

public class ThemeConstants
{
  public static final int ANIMATE_BG_AIO = 3;
  public static final int ANIMATE_BG_CONVERSATION = 2;
  public static final int ANIMATE_BG_DRAWER = 1;
  public static final int ANIMATE_TAB_CALL = 13;
  public static final int ANIMATE_TAB_CONTACTS = 12;
  public static final int ANIMATE_TAB_CONVERSATION = 11;
  public static final int ANIMATE_TAB_FLASH_SHOW = 18;
  public static final int ANIMATE_TAB_GUILD = 19;
  public static final int ANIMATE_TAB_LEBA = 14;
  public static final int ANIMATE_TAB_NOW = 15;
  public static final int ANIMATE_TAB_QCIRCLE = 17;
  public static final int ANIMATE_TAB_SEE = 16;
  public static final String BUNDLE_KEY_DYNAMIC_ENABLE = "dynamic_enable";
  public static final String BUNDLE_KEY_DYNAMIC_SWITCH = "dynamic_switch";
  public static final String BUNDLE_KEY_DYNAMIC_WEBVIEW_ENABLE = "dynamic_webview_enable";
  public static final String BUNDLE_KEY_MESSAGE = "message";
  public static final String BUNDLE_KEY_PAGE_AIO = "pageAIO";
  public static final String BUNDLE_KEY_PAGE_DRAWER = "pageDrawer";
  public static final String BUNDLE_KEY_PAGE_DYNAMIC = "pageDynamic";
  public static final String BUNDLE_KEY_PAGE_FRIEND = "pageFriend";
  public static final String BUNDLE_KEY_PAGE_MESSAGE = "pageMessage";
  public static final String BUNDLE_KEY_RESULT_INT = "result_int";
  public static final String BUNDLE_KEY_SERVER_AFTER_DOWNLOAD = "server_after_download";
  public static final String BUNDLE_KEY_SERVER_WITH_UNZIP = "server_with_unzip";
  public static final String CMD_THEME_AUTH = "AuthSvr.ThemeAuth";
  public static final String DEFAULT_THEME_ID = "1000";
  public static final String DIY_ASSETS_NAME = "999_540";
  public static final int DIY_STYLE_END = 1000000;
  public static final int DIY_STYLE_START = 5000;
  public static final String DIY_THEME_ID = "999";
  public static final String DIY_THEME_VERSION = "20000000";
  public static final int FEETYPE_FREE = 1;
  public static final int FEETYPE_SVIP = 5;
  public static final int FEETYPE_VIP = 4;
  public static final String KEY_SIMPLE_NO_NIGHT_UI_828 = "key_simple_no_night_ui_828";
  public static final String KEY_SIMPLE_NO_NIGHT_UI_NEW = "key_simple_no_night_ui_new";
  public static final String KEY_SIMPLE_SHOULD_SHOW_SWITCH_DIALOG = "key_simple_should_show_switch_dialog";
  public static final String KEY_SIMPLE_UI_PREF = "key_simple_ui_pref";
  public static final String KEY_SIMPLE_UI_PREF_828 = "key_simple_ui_pref_828";
  public static final String KEY_SIMPLE_UI_PREF_NEW = "key_simple_ui_pref_new";
  public static final String KEY_SIMPLE_UI_SWITCH = "key_simple_ui_switch";
  public static final String LOCAL_THEME_ID = "900";
  public static final ColorFilter NIGHTMODE_COLORFILTER = new PorterDuffColorFilter(NIGHTMODE_MASKCOLOR, PorterDuff.Mode.SRC_ATOP);
  public static final int NIGHTMODE_MASKCOLOR;
  public static final String OLD_ENGINE_PATH = "oldEnginePath";
  public static final String PKG_SUFFIX = ".zip";
  public static final String SOUND_THEME_TYPE = "1";
  public static final String SP_KEY_AUTH_TIME = "authTime";
  public static final String SP_KEY_CLEAN_LIST = "cleanList";
  public static final String START_DOWNLOAD_RESULT = "StartDownloadResult";
  public static final String THEME_ANIMATION_AIO_VIDEO = "qq_skin_aio.mp4";
  public static final String THEME_ANIMATION_CONVERSATION_VIDEO = "qq_skin_conversation.mp4";
  public static final String THEME_ANIMATION_DRAWER_CONVERSATION_VIDEO = "qq_skin_drawer_conversation.mp4";
  public static final String THEME_ANIMATION_DRAWER_VIDEO = "qq_skin_drawer.mp4";
  public static final String THEME_DEBUG_KEY = "ThemeDebugKeyLog:";
  public static final String[] THEME_DEFAULT_IDS = { "999", "1000", "1103", "2971", "2921", "3064", "3063", "3066", "3065", "3067" };
  public static final String THEME_DIY_BG_FEETYPE_SUFFIX = "_feetype";
  public static final String THEME_DIY_BG_FROM_SUFFIX = "_from";
  public static final String THEME_DIY_BG_ID_SUFFIX = "_id";
  public static final String THEME_DIY_BG_NAME_SUFFIX = "_name";
  public static final String THEME_DIY_BG_THUM_SUFFIX = "_thum";
  public static final String THEME_DIY_BG_URL_SUFFIX = "_url";
  public static final String THEME_ERROR_ID_LIST = "listOfErrorThemeSrc";
  public static final String THEME_ID = "themeId";
  public static final String THEME_ID_DAYMODE = "xxxx";
  public static final String THEME_ID_DAYMODE_SIMPLEUI_BLUE = "3491";
  public static final String THEME_ID_DAYMODE_SIMPLEUI_GRREEN = "3063";
  public static final String THEME_ID_DAYMODE_SIMPLEUI_PURPLE = "3065";
  public static final String THEME_ID_DAYMODE_SIMPLEUI_RED = "3067";
  public static final String THEME_ID_DAYMODE_SIMPLEUI_T_RED = "3066";
  public static final String THEME_ID_DAYMODE_SIMPLEUI_YELLOW = "3064";
  public static final String THEME_ID_DAYMODE_SIMPLE_GRAY = "2921";
  public static final String THEME_ID_DAYMODE_SIMPLE_WHITE = "2971";
  public static final String THEME_ID_GOLDEN = "2101";
  public static final String THEME_ID_LOCAL_SIMPLE = "1001";
  public static final String THEME_ID_NIGHTMODE = "1103";
  public static final String THEME_ID_NIGHTMODE_SIMPLE = "2920";
  public static final String THEME_ID_WHITEMODE = "2105";
  public static final String THEME_ISVOICE = "isVoiceTheme";
  public static final String THEME_KEY_CURRENT_THEME_ID = "currentThemeId_6.3.5";
  public static final String THEME_KEY_CURRENT_THEME_VERSION = "currentThemeVersion";
  public static final String THEME_KEY_USER_DOWNLOAD = "userDownloadTheme";
  public static final String THEME_KEY_USER_SWITCH_TIMES = "user_switch_theme_times";
  public static final String THEME_MSSAGE_VOICE_NAME = "message.mp3";
  public static final String THEME_ORIENTATION_HORIZONTAL = "horizontal";
  public static final String THEME_PATH = "themePath";
  public static final String THEME_SET_TIME_KEY = "themeSetTimeKey";
  public static final String THEME_SHARED_PREFERENCES = "userThemeSharedPreferences";
  public static final String THEME_SIZE = "size";
  public static final String THEME_SP_KEY_VERSION = "themeSpVersion";
  public static final String THEME_SP_SEPARATOR = ",";
  public static final int THEME_SP_VERSION_1 = 1;
  public static final String THEME_STATUS = "themeStatus";
  public static final String THEME_STATUS_COMPLETE = "5";
  public static final String THEME_STATUS_DOWNLOAD_END = "3";
  public static final String THEME_STATUS_DOWNLOAD_NONE = "1";
  public static final String THEME_STATUS_DOWNLOAD_PAUSE = "4";
  public static final String THEME_STATUS_DOWNLOAD_PROGRESS = "2";
  public static final String THEME_TYPE = "themeType";
  public static final String THEME_TYPE_ANIMATE = "animation";
  public static final int THEME_TYPE_FROM_SERVER = 1;
  public static final String THEME_URL = "url";
  public static final String THEME_VERSION = "version";
  public static final String THEME_VOICE_BASE_HOME = "voice";
  public static final String THEME_VOICE_SETTING = "theme_voice_setting_";
  public static final String WEEK_KEY_INDEX = "themeIndex";
  public static final String WEEK_KEY_SERIES_ID = "seriesID";
  public static final String WEEK_KEY_THEME_ARRAY = "themeArray";
  public static final String WEEK_KEY_THEME_LENGTH = "themeLength";
  public static final String WEEK_KEY_THEME_START_TIME = "startTime";
  public static final int ZIP_VERSION = 20000000;
  public static final int ZIP_VERSION_OLD = 200;
  public static final String ZIP_VERSION_STR = "20000000";
  
  static
  {
    NIGHTMODE_MASKCOLOR = Color.parseColor("#4d000000");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.theme.ThemeConstants
 * JD-Core Version:    0.7.0.1
 */