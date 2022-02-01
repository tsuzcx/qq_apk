package com.tencent.mobileqq.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.fileassistant.util.QFileAssistantUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ShareActionSheetBuilder$ActionSheetItem
{
  public static final int ACTION_ADBLOCK = 90;
  public static final int ACTION_ADD_COLOR_NOTE = 70;
  public static final int ACTION_ADD_FAVORITER = 6;
  public static final int ACTION_ADD_FRIEND = 35;
  public static final int ACTION_ADD_GOODS = 156;
  public static final int ACTION_ADD_MINIAPP_TO_CURRENT_TROOP = 159;
  public static final int ACTION_ADD_SHORTCUT = 14;
  public static final int ACTION_ADD_TROOP_APP = 15;
  public static final int ACTION_ADD_VIDEO_TO_TOPIC = 134;
  public static final int ACTION_ADJUST_FONT_SIZE = 7;
  public static final int ACTION_BARRAGE_CLOSE = 143;
  public static final int ACTION_BARRAGE_OPEN = 142;
  public static final int ACTION_CANCEL_ONLY_SEE_FRIEND = 103;
  public static final int ACTION_CARTON_DETAIL = 125;
  public static final int ACTION_CHANNEL_FACE2FACE_SHARE_TROOP = 24;
  public static final int ACTION_CHANNEL_QR_CODE = 23;
  public static final int ACTION_CHOOSE_FACE = 106;
  public static final int ACTION_CLOSE_BARRAGE = 164;
  public static final int ACTION_COLORNOTE_UPCOMING = 139;
  public static final int ACTION_COMIC_SWITCH_SECRET_MODE_ = 33;
  public static final int ACTION_COPYLINK = 1;
  public static final int ACTION_COPY_AVGAME_ROOM_ID = 160;
  public static final int ACTION_DELETE = 40;
  public static final int ACTION_DELETE_FANS = 137;
  public static final int ACTION_DELETE_HAS_PUSH = 140;
  public static final int ACTION_DIRECT_SEND_TO_FRIEND = 41;
  public static final int ACTION_DIRECT_SEND_TO_STORY = 42;
  public static final int ACTION_DOWNLOAD = 124;
  public static final int ACTION_EDIT = 94;
  public static final int ACTION_EXPORT_TENCENT_DOCS = 68;
  public static final int ACTION_FAN_GROUP_MANAGER = 152;
  public static final int ACTION_FAV_DETAIL = 130;
  public static final int ACTION_FAV_GROUP = 129;
  public static final int ACTION_FILE_CREATE_LINK = 122;
  public static final int ACTION_FILE_CREATE_QR = 123;
  public static final int ACTION_FILE_IMPORT_READER = 118;
  public static final int ACTION_FILE_IMPORT_TXDOC = 119;
  public static final int ACTION_FILE_PRINT = 121;
  public static final int ACTION_FILE_SAFE_FORWARD = 120;
  public static final int ACTION_FOLLOW = 87;
  public static final int ACTION_FOLLOW_MANAGE = 144;
  public static final int ACTION_GALLERY_EMOTION_LIST = 65;
  public static final int ACTION_GALLERY_FILE_FORWARD_TO_PC = 67;
  public static final int ACTION_GALLERY_PIC_ADD_TO_EMO = 48;
  public static final int ACTION_GALLERY_PIC_FAVORITE = 57;
  public static final int ACTION_GALLERY_PIC_FORWARD_TO_FRIEND = 49;
  public static final int ACTION_GALLERY_PIC_FORWARD_TO_GROUP_ALBUM = 51;
  public static final int ACTION_GALLERY_PIC_FORWARD_TO_QZONE_ALBUM = 50;
  public static final int ACTION_GALLERY_PIC_LOCATE_TO_CHAT_POS = 54;
  public static final int ACTION_GALLERY_PIC_OCR = 52;
  public static final int ACTION_GALLERY_PIC_RECO_MINI = 56;
  public static final int ACTION_GALLERY_PIC_RECO_QR = 55;
  public static final int ACTION_GALLERY_PIC_REPORT = 66;
  public static final int ACTION_GALLERY_PIC_SAVE = 53;
  public static final int ACTION_GALLERY_PIC_SHARE_WEIYUN = 58;
  public static final int ACTION_GALLERY_SHARE_TO_WX = 69;
  public static final int ACTION_GALLERY_SHORTVIDEO_FAVORITE = 63;
  public static final int ACTION_GALLERY_SHORTVIDEO_FORWARD_TO_FRIEND = 59;
  public static final int ACTION_GALLERY_SHORTVIDEO_FORWARD_TO_QZONE = 60;
  public static final int ACTION_GALLERY_SHORTVIDEO_LOCATE_TO_CHAT_POS = 62;
  public static final int ACTION_GALLERY_SHORTVIDEO_OPEN_BY_OTHER_APP = 64;
  public static final int ACTION_GALLERY_SHORTVIDEO_SAVE = 61;
  public static final int ACTION_GALLERY_VIDEO_MINICODE = 127;
  public static final int ACTION_GALLERY_VIDEO_QRCODE = 126;
  public static final int ACTION_GO_FRIEND_AIO = 37;
  public static final int ACTION_GO_SUBSCRIPT_AIO = 30;
  public static final int ACTION_HIDE_FEED = 85;
  public static final int ACTION_HIDE_HIM = 86;
  public static final int ACTION_HIDE_THIS_WORK = 141;
  public static final int ACTION_LAUNCH_CHAT = 92;
  public static final int ACTION_MINIAPP_ABOUT = 78;
  public static final int ACTION_MINIAPP_ADD_TO_MINE = 76;
  public static final int ACTION_MINIAPP_BACK_HOMEPAGE = 81;
  public static final int ACTION_MINIAPP_DEBUG_OFF = 75;
  public static final int ACTION_MINIAPP_DEBUG_ON = 74;
  public static final int ACTION_MINIAPP_PERFORMANCE_OFF = 80;
  public static final int ACTION_MINIAPP_PERFORMANCE_ON = 79;
  public static final int ACTION_MINIAPP_REMOVE_FROM_MINE = 77;
  public static final int ACTION_MINIAPP_RESTART_MINIAPP = 128;
  public static final int ACTION_NOT_CARE = 38;
  public static final int ACTION_ONLY_SEE_FRIEND = 102;
  public static final int ACTION_OPEN_APP_DETAIL = 16;
  public static final int ACTION_OPEN_BARRAGE = 163;
  public static final int ACTION_OPEN_FILE_WITHOUT_DEFAULT_APP = 132;
  public static final int ACTION_OPEN_IN_QQ_BROWSER = 5;
  public static final int ACTION_OPEN_IN_SYS_BROWSER = 4;
  public static final int ACTION_OPEN_WEISHI_ACCOUNT = 45;
  public static final int ACTION_ORDER_LIST = 155;
  public static final int ACTION_PA_REPORT = 36;
  public static final int ACTION_PITU = 105;
  public static final int ACTION_PRIVATE_MESSAGE = 138;
  public static final int ACTION_PROMOTION = 89;
  public static final int ACTION_PUPU_ADD_SHELF = 109;
  public static final int ACTION_PUPU_BOOKMARK = 110;
  public static final int ACTION_PUPU_BOOKMARK_CANCEL = 111;
  public static final int ACTION_PUPU_BOOK_DETAIL = 108;
  public static final int ACTION_PUPU_CONTINUE_PURCHASE = 114;
  public static final int ACTION_PUPU_CONTINUE_PURCHASE_CANCEL = 115;
  public static final int ACTION_PUPU_HIDE_OPINION = 112;
  public static final int ACTION_PUPU_PRIVACY = 116;
  public static final int ACTION_PUPU_PRIVACY_CANCEL = 117;
  public static final int ACTION_PUPU_SHOW_OPINION = 113;
  public static final int ACTION_QCIRCLE_PRIVATE_MESSAGE = 162;
  public static final int ACTION_REFRESH_TROOP_APP_VIEW = 18;
  public static final int ACTION_REMOVE_COLOR_NOTE = 82;
  public static final int ACTION_REMOVE_FAVORITE = 84;
  public static final int ACTION_REMOVE_VIDEO_FROM_TOPIC = 136;
  public static final int ACTION_REPORT = 11;
  public static final int ACTION_REPORT_DIS_LIKE = 44;
  public static final int ACTION_REPORT_VIDEO_NOT_LIKE = 22;
  public static final int ACTION_REPRINT_BLOG = 101;
  public static final int ACTION_REPRINT_PHOTO = 100;
  public static final int ACTION_RIJ_DELETE_TOPIC = 135;
  public static final int ACTION_RIJ_WATCH_WORD = 133;
  public static final int ACTION_SAVE = 39;
  public static final int ACTION_SAVE_PIC = 43;
  public static final int ACTION_SAVE_TO_PICTURE = 47;
  public static final int ACTION_SCREEN_LONG_SHOT = 71;
  public static final int ACTION_SEND_TO_CLIPBOARD = 28;
  public static final int ACTION_SEND_TO_DIANDIAN = 34;
  public static final int ACTION_SEND_TO_EVERNOTE = 91;
  public static final int ACTION_SEND_TO_FRIEND = 2;
  public static final int ACTION_SEND_TO_MAIL = 25;
  public static final int ACTION_SEND_TO_MORE_FRIEND = 73;
  public static final int ACTION_SEND_TO_PC = 26;
  public static final int ACTION_SEND_TO_QIDIAN = 19;
  public static final int ACTION_SEND_TO_QIYEQQ = 20;
  public static final int ACTION_SEND_TO_QZONE = 3;
  public static final int ACTION_SEND_TO_READINJOY = 13;
  public static final int ACTION_SEND_TO_SINA = 12;
  public static final int ACTION_SEND_TO_SPECIFIED_FRIEND = 72;
  public static final int ACTION_SEND_TO_STORY_DISCOVER = 29;
  public static final int ACTION_SEND_TO_WECHAT = 9;
  public static final int ACTION_SEND_TO_WECHAT_CIRCLE = 10;
  public static final int ACTION_SEND_TO_WEIYUN = 27;
  public static final int ACTION_SETTING = 83;
  public static final int ACTION_SET_BACKGROUND = 107;
  public static final int ACTION_SET_DRESS = 98;
  public static final int ACTION_SET_MINIAPP_TO_TROOP = 158;
  public static final int ACTION_SET_PRIVATE = 95;
  public static final int ACTION_SET_TOP = 96;
  public static final int ACTION_SHARE_PICTURE = 153;
  public static final int ACTION_SHARE_TROOP_APP = 17;
  public static final int ACTION_SHOW_MORE_INFO = 31;
  public static final int ACTION_SHOW_ORIGINALURL = 131;
  public static final int ACTION_STORE_MANAGER = 157;
  public static final int ACTION_SYNC_QZONE = 154;
  public static final int ACTION_TAKE_SCREEN_SHOT = 21;
  public static final int ACTION_TRIBE_ADD_TO_DIGEST = 145;
  public static final int ACTION_TRIBE_CANCEL_DIGEST = 146;
  public static final int ACTION_TRIBE_FEEDBACK = 151;
  public static final int ACTION_TRIBE_INTEREST = 147;
  public static final int ACTION_TRIBE_LOOK_OWNER = 148;
  public static final int ACTION_TRIBE_PULL_BLACK = 150;
  public static final int ACTION_TRIBE_PUSH_TOPIC = 149;
  public static final int ACTION_UNFOLLOW = 32;
  public static final int ACTION_UN_SET_TOP = 97;
  public static final int ACTION_VIDEO_PLAY_FEEDBACK = 161;
  public static final int ACTION_VIEW_DRESS = 99;
  public static final int ACTION_VIEW_PUB_ACCOUNT = 8;
  public static final int ACTION_WATCH_ON_TV = 104;
  public static final int ACTION_WATCH_ORIGINAL_VIDEO = 88;
  private static final int[] jdField_a_of_type_ArrayOfInt = { 2130846542, 2130846543, 2130846502, 2130846503, 2130846508, 2130846509, 2130846494, 2130846495, 2130846491, 2130846492, 2130846548, 2130846549, 2130846531, 2130846532, 2130846538, 2130846539, 2130846512, 2130846513, 2130846514, 2130846515, 2130846574, 2130846575, 2130846521, 2130846522, 2130846506, 2130846507, 2130843825, 2130843827, 2130843830, 2130843829, 2130844485, 2130844486, 2130842742, 2130846576, 2130846577, 2130839064, 2130839300, 2130839333, 2130846516, 2130846517, 2130846498, 2130846499, 2130846500, 2130846501, 2130842743, 2130842753, 2130842738, 2130842744, 2130842740, 2130846544, 2130846545, 2130846900, 2130847133, 2130839069, 2130842726, 2130846594, 2130843312, 2130846527, 2130846528, 2130846510, 2130846511, 2130846504, 2130846505, 2130846591, 2130846592, 2130846487, 2130846556, 2130846557, 2130846560, 2130846488, 2130846489, 2130846562, 2130846563, 2130846536, 2130846537, 2130844370, 2130850938, 2130850939, 2130846525, 2130846526, 2130846534, 2130846535, 2130846558, 2130846559, 2130849796, 2130846595, 2130849795, 2130846533, 2130840321, 2130850043, 2130850044, 2130840166, 2130841314, 2130841315, 2130841324, 2130846530, 2130841325, 2130841326, 2130841327, 2130841328, 2130846597, 2130846575, 2130846566, 2130846567, 2130846540, 2130846541, 2130841316, 2130841317, 2130841320, 2130841321, 2130841318, 2130841319, 2130841322, 2130841323, 2130842735, 2130848109, 2130848106, 2130848104, 2130848103, 2130848102, 2130848095, 2130848096, 2130848093, 2130848094, 2130848107, 2130848097, 2130846554, 2130846555, 2130848105, 2130848108, 2130848679, 2130848092, 2130848099, 2130848682, 2130848678, 2130846564, 2130846565, 2130842735, 2130841900, 2130841898, 2130841902, 2130841903, 2130841910, 2130841916, 2130841906, 2130841907, 2130841912, 2130841913, 2130840167, 2130844295, 2130837665, 2130837666, 2130840158, 2130844291, 2130844304, 2130844305, 2130844293, 2130844294, 2130844296, 2130844297, 2130844260, 2130844261, 2130844256, 2130844257, 2130844262, 2130844263, 2130844289, 2130844290, 2130840245, 2130840246, 2130840241, 2130840242, 2130849774, 2130849773, 2130849788, 2130849787, 2130849770, 2130849769, 2130849794, 2130849793, 2130849782, 2130849781, 2130849786, 2130849785, 2130849778, 2130849777, 2130849784, 2130849783, 2130840992, 2130840993, 2130844097, 2130844098, 2130849783, 2130849772, 2130849771, 2130849790, 2130849789, 2130849776, 2130849775, 2130849792, 2130849791, 2130849780, 2130849779, 2130849768, 2130849767, 2130846554, 2130846555, 2130843735, 2130843734, 2130843737, 2130843736, 2130843739, 2130843738, 2130843743, 2130843742, 2130843745, 2130843744, 2130843733, 2130843732, 2130843741, 2130843740, 2130849555, 2130844137, 2130844136, 2130851203, 2130851204, 2130851201, 2130851202, 2130849630, 2130849631, 2130843342, 2130843341 };
  private static final int[] b;
  private IllegalStateException jdField_a_of_type_JavaLangIllegalStateException;
  public int action = 0;
  public String argus = null;
  public boolean enable = true;
  public int firstLineCount;
  public int icon = 0;
  public Drawable iconDrawable = null;
  public boolean iconNeedBg = true;
  public int id;
  public String label = null;
  public View.OnClickListener listener;
  public String reportID;
  public String uin;
  public int uinType;
  public int visibility = 0;
  
  static
  {
    HashSet localHashSet = new HashSet();
    int j = 0;
    int i = 0;
    Object localObject;
    for (;;)
    {
      localObject = jdField_a_of_type_ArrayOfInt;
      if (i >= localObject.length) {
        break;
      }
      if (localHashSet.contains(Integer.valueOf(localObject[i])))
      {
        localObject = BaseApplication.getContext();
        if (localObject != null)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("static initializer() called duplicated icon ");
          localStringBuilder.append(i);
          localStringBuilder.append(", ");
          localStringBuilder.append(((Context)localObject).getResources().getResourceEntryName(jdField_a_of_type_ArrayOfInt[i]));
          QLog.e("ShareActionSheetBuilder", 1, localStringBuilder.toString());
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("static initializer() called duplicated icon ");
          ((StringBuilder)localObject).append(i);
          QLog.e("ShareActionSheetBuilder", 1, ((StringBuilder)localObject).toString());
        }
      }
      else
      {
        localHashSet.add(Integer.valueOf(jdField_a_of_type_ArrayOfInt[i]));
      }
      i += 1;
    }
    Arrays.sort((int[])localObject);
    b = new int[] { 2131718955, 2131718976, 2131718977, 2131718905, 2131718906, 2131718907, 2131718946, 2131718981, 2131719006, 2131718925, 2131719003, 2131719004, 2131719005, 2131718994, 2131718904, 2131718960, 2131718975, 2131718954, 2131718956, 2131718999, 2131718913, 2131718958, 2131718987, 2131718985, 2131718986, 2131718914, 2131718978, 2131718924, 2131718982, 2131718916, 2131718915, 2131718921, 2131718919, 2131718922, 2131718920, 2131718923, 2131718936, 2131718931, 2131718932, 2131718903, 2131718918, 2131718961, 2131718984, 2131718917, 2131718988, 2131698288, 2131718933, 2131718908, 2131718912, 2131718911, 2131718909, 2131718998, 2131718979, 2131718959, 2131718929, 2131718930, 2131718950, 2131718951, 2131718983, 2131718963, 2131718934, 2131718935, 2131697240, 2131697243, 2131697246, 2131697245, 2131696404, 2131695251, 2131718996, 2131718948, 2131718947, 2131718949, 2131718944, 2131718997, 2131719002, 2131718964, 2131718910, 2131718940, 2131718953, 2131718939, 2131718991, 2131718992, 2131718995, 2131718990, 2131719000, 2131718980, 2131718957, 2131718926, 2131718937, 2131719001, 2131718962, 2131718928, 2131718989, 2131695251, 2131718966, 2131718965, 2131718967, 2131718968, 2131718971, 2131718974, 2131718969, 2131718970, 2131718972, 2131718973, 2131718942, 2131718941, 2131718943, 2131698168, 2131718973, 2131718964, 2131718910, 2131718973, 2131718881, 2131718902, 2131718884, 2131718890, 2131718901, 2131718883, 2131718887, 2131718882, 2131718888, 2131718887, 2131718885, 2131718891, 2131718893, 2131718886, 2131718880, 2131718892, 2131718945, 2131718894, 2131718895, 2131718897, 2131718898, 2131718900, 2131718899, 2131718896, 2131718927, 2131718938, 2131718333, 2131718332, 2131696425 };
    localHashSet = new HashSet();
    i = j;
    for (;;)
    {
      localObject = b;
      if (i >= localObject.length) {
        break;
      }
      if (localHashSet.contains(Integer.valueOf(localObject[i])))
      {
        if (BaseApplication.getContext() != null)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("static initializer() called duplicated label ");
          ((StringBuilder)localObject).append(i);
          ((StringBuilder)localObject).append(", ");
          ((StringBuilder)localObject).append(BaseApplication.getContext().getResources().getResourceEntryName(b[i]));
          QLog.e("ShareActionSheetBuilder", 1, ((StringBuilder)localObject).toString());
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("static initializer() called duplicated label ");
          ((StringBuilder)localObject).append(i);
          ((StringBuilder)localObject).append(", ");
          QLog.e("ShareActionSheetBuilder", 1, ((StringBuilder)localObject).toString());
        }
      }
      else {
        localHashSet.add(Integer.valueOf(b[i]));
      }
      i += 1;
    }
    Arrays.sort((int[])localObject);
  }
  
  public ShareActionSheetBuilder$ActionSheetItem()
  {
    if (!new java.lang.Throwable().getStackTrace()[1].getClassName().equals(ActionSheetItem.class.getName()))
    {
      this.jdField_a_of_type_JavaLangIllegalStateException = new IllegalStateException("Must use method com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem.build(int) to create me !");
      QLog.e("ShareActionSheetBuilder", 1, "ActionSheetItem: ", this.jdField_a_of_type_JavaLangIllegalStateException);
    }
  }
  
  private static ActionSheetItem A()
  {
    return a(2130848104, 2131718991, "privacy");
  }
  
  private static ActionSheetItem B()
  {
    return a(2130848093, 2131718939, "edit");
  }
  
  private static ActionSheetItem C()
  {
    return a(2130848102, 2131718953, "open_aio");
  }
  
  private static ActionSheetItem D()
  {
    return a(2130848094, 2131718940, "Evernote");
  }
  
  private static ActionSheetItem E()
  {
    return a(2130848679, 2131718937, "delete");
  }
  
  private static ActionSheetItem F()
  {
    int i;
    if (QQTheme.a()) {
      i = 2130846539;
    } else {
      i = 2130846538;
    }
    return a(i, 2131696425, "check_profile");
  }
  
  private static ActionSheetItem G()
  {
    int i;
    if (QQTheme.a()) {
      i = 2130849556;
    } else {
      i = 2130849555;
    }
    return a(i, 2131719002, "orignal");
  }
  
  private static ActionSheetItem H()
  {
    return a(2130848108, 2131718997, "unfollow");
  }
  
  private static ActionSheetItem I()
  {
    return a(2130848105, 2131718944, "follow");
  }
  
  private static ActionSheetItem J()
  {
    return a(2130848097, 2131718949, "hide_him");
  }
  
  private static ActionSheetItem K()
  {
    int i;
    if (QQTheme.a()) {
      i = 2130846555;
    } else {
      i = 2130846554;
    }
    return a(i, 2131718948, "hide_this_feed");
  }
  
  private static ActionSheetItem L()
  {
    int i;
    if (QQTheme.a()) {
      i = 2130846555;
    } else {
      i = 2130846554;
    }
    return a(i, 2131718947, "hide_works");
  }
  
  private static ActionSheetItem M()
  {
    return a(2130848107, 2131718996, "collect_cancel");
  }
  
  private static ActionSheetItem N()
  {
    int i;
    if (QQTheme.a()) {
      i = 2130846535;
    } else {
      i = 2130846534;
    }
    return a(i, 2131718932, "colornote_cancel");
  }
  
  private static ActionSheetItem O()
  {
    int i;
    if (QQTheme.a()) {
      i = 2130844261;
    } else {
      i = 2130844260;
    }
    return a(i, 2131718942, "fav_group");
  }
  
  private static ActionSheetItem P()
  {
    int i;
    if (QQTheme.a()) {
      i = 2130844257;
    } else {
      i = 2130844256;
    }
    return a(i, 2131718941, "fav_detail");
  }
  
  private static ActionSheetItem Q()
  {
    int i;
    if (QQTheme.a()) {
      i = 2130844263;
    } else {
      i = 2130844262;
    }
    return a(i, 2131718943, "fav_show_originalurl");
  }
  
  private static ActionSheetItem R()
  {
    int i;
    if (QQTheme.a()) {
      i = 2130841317;
    } else {
      i = 2130841316;
    }
    return a(i, 2131718924, "backtohome");
  }
  
  private static ActionSheetItem S()
  {
    int i;
    if (QQTheme.a()) {
      i = 2130841321;
    } else {
      i = 2130841320;
    }
    return a(i, 2131718982, "restart_applet");
  }
  
  private static ActionSheetItem T()
  {
    int i;
    if (QQTheme.a()) {
      i = 2130841328;
    } else {
      i = 2130841327;
    }
    return a(i, 2131718978, "remove_my");
  }
  
  private static ActionSheetItem U()
  {
    int i;
    if (QQTheme.a()) {
      i = 2130841326;
    } else {
      i = 2130841325;
    }
    return a(i, 2131718914, "add_my");
  }
  
  private static ActionSheetItem V()
  {
    int i;
    if (QQTheme.a()) {
      i = 2130841315;
    } else {
      i = 2130841314;
    }
    return a(i, 2131718909, "about");
  }
  
  private static ActionSheetItem W()
  {
    int i;
    if (QQTheme.a()) {
      i = 2130841319;
    } else {
      i = 2130841318;
    }
    return a(i, 2131718920, "applet_closeperformance");
  }
  
  private static ActionSheetItem X()
  {
    int i;
    if (QQTheme.a()) {
      i = 2130841319;
    } else {
      i = 2130841318;
    }
    return a(i, 2131718922, "applet_openperformance");
  }
  
  private static ActionSheetItem Y()
  {
    int i;
    if (QQTheme.a()) {
      i = 2130841319;
    } else {
      i = 2130841318;
    }
    return a(i, 2131718919, "applet_closedebug");
  }
  
  private static ActionSheetItem Z()
  {
    int i;
    if (QQTheme.a()) {
      i = 2130841319;
    } else {
      i = 2130841318;
    }
    return a(i, 2131718921, "applet_opendebug");
  }
  
  private static ActionSheetItem a()
  {
    return a(2130843342, 2131718333, "open_viola_barrage");
  }
  
  private static ActionSheetItem a(int paramInt1, int paramInt2, String paramString)
  {
    return a(paramInt1, paramInt2, paramString, BaseApplication.getContext().getResources());
  }
  
  private static ActionSheetItem a(int paramInt1, int paramInt2, String paramString, Resources paramResources)
  {
    ActionSheetItem localActionSheetItem = new ActionSheetItem();
    localActionSheetItem.icon = paramInt1;
    localActionSheetItem.label = paramResources.getString(paramInt2);
    localActionSheetItem.reportID = paramString;
    return localActionSheetItem;
  }
  
  private static ActionSheetItem aA()
  {
    int i;
    if (QQTheme.a()) {
      i = 2130849631;
    } else {
      i = 2130849630;
    }
    return a(i, 2131718925, "biu");
  }
  
  private static ActionSheetItem aB()
  {
    int i;
    if (QQTheme.a()) {
      i = 2130846522;
    } else {
      i = 2130846521;
    }
    return a(i, 2131719005, "weibo");
  }
  
  private static ActionSheetItem aC()
  {
    int i;
    if (QQTheme.a()) {
      i = 2130846575;
    } else {
      i = 2130846574;
    }
    return a(i, 2131718979, "report");
  }
  
  private static ActionSheetItem aD()
  {
    int i;
    if (QQTheme.a()) {
      i = 2130846567;
    } else {
      i = 2130846566;
    }
    return a(i, 2131718959, "open_barrage");
  }
  
  private static ActionSheetItem aE()
  {
    int i;
    if (QQTheme.a()) {
      i = 2130846541;
    } else {
      i = 2130846540;
    }
    return a(i, 2131718929, "close_barrage");
  }
  
  private static ActionSheetItem aF()
  {
    int i;
    if (QQTheme.a()) {
      i = 2130846515;
    } else {
      i = 2130846514;
    }
    return a(i, 2131719004, "wechat_");
  }
  
  private static ActionSheetItem aG()
  {
    int i;
    if (QQTheme.a()) {
      i = 2130846513;
    } else {
      i = 2130846512;
    }
    return a(i, 2131719003, "wechat");
  }
  
  private static ActionSheetItem aH()
  {
    int i;
    if (QQTheme.a()) {
      i = 2130846532;
    } else {
      i = 2130846531;
    }
    return a(i, 2131718917, "adjust_font");
  }
  
  private static ActionSheetItem aI()
  {
    int i;
    if (QQTheme.a()) {
      i = 2130846549;
    } else {
      i = 2130846548;
    }
    return a(i, 2131718930, "collect");
  }
  
  private static ActionSheetItem aJ()
  {
    int i;
    if (QQTheme.a()) {
      i = 2130846492;
    } else {
      i = 2130846491;
    }
    return a(i, 2131718904, "Qbrowser");
  }
  
  private static ActionSheetItem aK()
  {
    int i;
    if (QQTheme.a()) {
      i = 2130846495;
    } else {
      i = 2130846494;
    }
    return a(i, 2131718994, "browser");
  }
  
  private static ActionSheetItem aL()
  {
    int i;
    if (QQTheme.a()) {
      i = 2130846509;
    } else {
      i = 2130846508;
    }
    return a(i, 2131718906, "Qzone");
  }
  
  private static ActionSheetItem aM()
  {
    int i;
    if (QQTheme.a()) {
      i = 2130846503;
    } else {
      i = 2130846502;
    }
    return a(i, 2131718905, "Qfriend");
  }
  
  private static ActionSheetItem aN()
  {
    int i;
    if (QQTheme.a()) {
      i = 2130846543;
    } else {
      i = 2130846542;
    }
    return a(i, 2131718933, "copy_link");
  }
  
  private static ActionSheetItem aO()
  {
    int i;
    if (QQTheme.a()) {
      i = 2130844295;
    } else {
      i = 2130840167;
    }
    return a(i, 2131718950, "Import_reader");
  }
  
  private static ActionSheetItem aP()
  {
    int i;
    if (QQTheme.a()) {
      i = 2130837666;
    } else {
      i = 2130837665;
    }
    return a(i, 2131718951, "edit_online");
  }
  
  private static ActionSheetItem aQ()
  {
    int i;
    if (QQTheme.a()) {
      i = 2130844291;
    } else {
      i = 2130840158;
    }
    return a(i, 2131718983, "safe_share");
  }
  
  private static ActionSheetItem aR()
  {
    int i;
    if (QQTheme.a()) {
      i = 2130844305;
    } else {
      i = 2130844304;
    }
    return a(i, 2131718963, "print");
  }
  
  private static ActionSheetItem aS()
  {
    int i;
    if (QQTheme.a()) {
      i = 2130844294;
    } else {
      i = 2130844293;
    }
    return a(i, 2131718934, "generate_link");
  }
  
  private static ActionSheetItem aT()
  {
    int i;
    if (QQTheme.a()) {
      i = 2130844290;
    } else {
      i = 2130844289;
    }
    return a(i, 2131698168, "other_app");
  }
  
  private static ActionSheetItem aU()
  {
    int i;
    if (QQTheme.a()) {
      i = 2130844297;
    } else {
      i = 2130844296;
    }
    return a(i, 2131718935, "generate_QRcode");
  }
  
  private static ActionSheetItem aV()
  {
    int i;
    if (QQTheme.a()) {
      i = 2130840242;
    } else {
      i = 2130840241;
    }
    return a(i, 2131718964, "ad_promotion");
  }
  
  private static ActionSheetItem aW()
  {
    int i;
    if (QQTheme.a()) {
      i = 2130840246;
    } else {
      i = 2130840245;
    }
    return a(i, 2131718910, "ad_block");
  }
  
  private static ActionSheetItem aX()
  {
    int i;
    if (QQTheme.a()) {
      i = 2130849769;
    } else {
      i = 2130849770;
    }
    return a(i, 2131718881, "addto_section");
  }
  
  private static ActionSheetItem aY()
  {
    int i;
    if (QQTheme.a()) {
      i = 2130849787;
    } else {
      i = 2130849788;
    }
    return a(i, 2131718890, "delete_section");
  }
  
  private static ActionSheetItem aZ()
  {
    int i;
    if (QQTheme.a()) {
      i = 2130849773;
    } else {
      i = 2130849774;
    }
    return a(i, 2131718884, "delete_from_section");
  }
  
  private static ActionSheetItem aa()
  {
    int i;
    if (QQTheme.a()) {
      i = 2130846559;
    } else {
      i = 2130846558;
    }
    return a(i, 2131718954, "long_screenshot");
  }
  
  private static ActionSheetItem ab()
  {
    int i;
    if (QQTheme.a()) {
      i = 2130846526;
    } else {
      i = 2130846525;
    }
    return a(i, 2131718931, "colornote");
  }
  
  private static ActionSheetItem ac()
  {
    int i;
    if (QQTheme.a()) {
      i = 2130850939;
    } else {
      i = 2130850938;
    }
    return a(i, 2131718999, "url_to_txdoc");
  }
  
  private static ActionSheetItem ad()
  {
    int i;
    if (QQTheme.a()) {
      i = 2130846537;
    } else {
      i = 2130846536;
    }
    return a(i, 2131718987, "search_emotion");
  }
  
  private static ActionSheetItem ae()
  {
    int i;
    if (QQTheme.a()) {
      i = 2130846563;
    } else {
      i = 2130846562;
    }
    return a(i, 2131718960, "other_app");
  }
  
  private static ActionSheetItem af()
  {
    int i;
    if (QQTheme.a()) {
      i = 2130846561;
    } else {
      i = 2130846560;
    }
    return a(i, 2131718985, "scan_appletcode");
  }
  
  private static ActionSheetItem ag()
  {
    int i;
    if (QQTheme.a()) {
      i = 2130846577;
    } else {
      i = 2130846576;
    }
    return a(i, 2131718986, "scan_qrcode");
  }
  
  private static ActionSheetItem ah()
  {
    int i;
    if (QQTheme.a()) {
      i = 2130846557;
    } else {
      i = 2130846556;
    }
    return a(i, 2131718918, "aio_position");
  }
  
  private static ActionSheetItem ai()
  {
    int i;
    if (QQTheme.a()) {
      i = 2130846592;
    } else {
      i = 2130846591;
    }
    return a(i, 2131718961, "pick_words");
  }
  
  private static ActionSheetItem aj()
  {
    int i;
    if (QQTheme.a()) {
      i = 2130846505;
    } else {
      i = 2130846504;
    }
    return a(i, 2131718946, "group_album");
  }
  
  private static ActionSheetItem ak()
  {
    int i;
    if (QQTheme.a()) {
      i = 2130846511;
    } else {
      i = 2130846510;
    }
    return a(i, 2131718907, "Qzone_album");
  }
  
  private static ActionSheetItem al()
  {
    int i;
    if (QQTheme.a()) {
      i = 2130846528;
    } else {
      i = 2130846527;
    }
    return a(i, 2131718912, "add_emotion");
  }
  
  private static ActionSheetItem am()
  {
    int i;
    if (QQTheme.a()) {
      i = 2130841323;
    } else {
      i = 2130841322;
    }
    return a(i, 2131718975, "push_setup");
  }
  
  private static ActionSheetItem an()
  {
    int i;
    if (QQTheme.a()) {
      i = 2130846595;
    } else {
      i = 2130846594;
    }
    return a(i, 2131718998, "uninterested");
  }
  
  private static ActionSheetItem ao()
  {
    int i;
    if (QQTheme.a()) {
      i = 2130846545;
    } else {
      i = 2130846544;
    }
    return a(i, 2131718984, "save");
  }
  
  private static ActionSheetItem ap()
  {
    int i;
    if (QQTheme.a()) {
      i = 2130846533;
    } else {
      i = 2130849795;
    }
    return a(i, 2131718956, "not_care");
  }
  
  private static ActionSheetItem aq()
  {
    QQTheme.a();
    return a(2130842743, 2131695194, "open_aio");
  }
  
  private static ActionSheetItem ar()
  {
    QQTheme.a();
    return a(2130842744, 2131718913, "add_friend");
  }
  
  private static ActionSheetItem as()
  {
    QQTheme.a();
    return a(2130842743, 2131718958, "open_aio");
  }
  
  private static ActionSheetItem at()
  {
    int i;
    if (QQTheme.a()) {
      i = 2130846517;
    } else {
      i = 2130846516;
    }
    return a(i, 2131719006, "weiyun");
  }
  
  private static ActionSheetItem au()
  {
    int k;
    int i;
    int j;
    if (QFileAssistantUtils.a())
    {
      k = 2131698288;
      i = 2130846500;
      j = k;
      if (QQTheme.a())
      {
        i = 2130846501;
        j = k;
      }
    }
    else
    {
      k = 2131718988;
      i = 2130846498;
      j = k;
      if (QQTheme.a())
      {
        i = 2130846499;
        j = k;
      }
    }
    return a(i, j, "sent_pc");
  }
  
  private static ActionSheetItem av()
  {
    int i;
    if (QQTheme.a()) {
      i = 2130846577;
    } else {
      i = 2130846576;
    }
    return a(i, 2131718903, "QRcode");
  }
  
  private static ActionSheetItem aw()
  {
    QQTheme.a();
    return a(2130842742, 2131718908, "Screenshot_share");
  }
  
  private static ActionSheetItem ax()
  {
    QQTheme.a();
    return a(2130844486, 2131718977, "qiyeqq");
  }
  
  private static ActionSheetItem ay()
  {
    QQTheme.a();
    return a(2130844485, 2131718976, "qidian");
  }
  
  private static ActionSheetItem az()
  {
    int i;
    if (QQTheme.a()) {
      i = 2130846530;
    } else {
      i = 2130841324;
    }
    return a(i, 2131718911, "add_desktop");
  }
  
  private static ActionSheetItem b()
  {
    return a(2130843341, 2131718332, "close_viola_barrage");
  }
  
  private static ActionSheetItem ba()
  {
    int i;
    if (QQTheme.a()) {
      i = 2130849793;
    } else {
      i = 2130849794;
    }
    return a(i, 2131718902, "kouling_share");
  }
  
  private static ActionSheetItem bb()
  {
    int i;
    if (QQTheme.a()) {
      i = 2130849781;
    } else {
      i = 2130849782;
    }
    return a(i, 2131718901, "play_feedback");
  }
  
  private static ActionSheetItem bc()
  {
    int i;
    if (QQTheme.a()) {
      i = 2130849785;
    } else {
      i = 2130849786;
    }
    return a(i, 2131718883, "delete_fans");
  }
  
  private static ActionSheetItem bd()
  {
    int i;
    if (QQTheme.a()) {
      i = 2130849777;
    } else {
      i = 2130849778;
    }
    return a(i, 2131695251, "share_more");
  }
  
  private static ActionSheetItem be()
  {
    int i;
    if (QQTheme.a()) {
      i = 2130849783;
    } else {
      i = 2130849784;
    }
    return a(i, 2131718887, "private_chat");
  }
  
  private static ActionSheetItem bf()
  {
    int i;
    if (QQTheme.a()) {
      i = 2130849783;
    } else {
      i = 2130849784;
    }
    return a(i, 2131718882, "copy_roomid");
  }
  
  private static ActionSheetItem bg()
  {
    int i;
    if (QQTheme.a()) {
      i = 2130840993;
    } else {
      i = 2130840992;
    }
    return a(i, 2131718916, "group_app");
  }
  
  private static ActionSheetItem bh()
  {
    int i;
    if (QQTheme.a()) {
      i = 2130840993;
    } else {
      i = 2130840992;
    }
    return a(i, 2131718915, "add_to_group");
  }
  
  private static ActionSheetItem bi()
  {
    int i;
    if (QQTheme.a()) {
      i = 2130844098;
    } else {
      i = 2130844097;
    }
    return a(i, 2131718888, "delete_launch");
  }
  
  private static ActionSheetItem bj()
  {
    int i;
    if (QQTheme.a()) {
      i = 2130844137;
    } else {
      i = 2130844136;
    }
    return a(i, 2131718889, "qcircle_private_message");
  }
  
  private static ActionSheetItem bk()
  {
    int i;
    if (QQTheme.a()) {
      i = 2130849789;
    } else {
      i = 2130849790;
    }
    return a(i, 2131718892, "store_manage");
  }
  
  private static ActionSheetItem bl()
  {
    int i;
    if (QQTheme.a()) {
      i = 2130849775;
    } else {
      i = 2130849776;
    }
    return a(i, 2131718885, "fan_group_manage");
  }
  
  private static ActionSheetItem bm()
  {
    int i;
    if (QQTheme.a()) {
      i = 2130849771;
    } else {
      i = 2130849772;
    }
    return a(i, 2131718891, "sharepicture");
  }
  
  private static ActionSheetItem bn()
  {
    int i;
    if (QQTheme.a()) {
      i = 2130849791;
    } else {
      i = 2130849792;
    }
    return a(i, 2131718893, "Sync_zone");
  }
  
  private static ActionSheetItem bo()
  {
    int i;
    if (QQTheme.a()) {
      i = 2130849779;
    } else {
      i = 2130849780;
    }
    return a(i, 2131718886, "orderlist");
  }
  
  private static ActionSheetItem bp()
  {
    int i;
    if (QQTheme.a()) {
      i = 2130849767;
    } else {
      i = 2130849768;
    }
    return a(i, 2131718880, "adding goods");
  }
  
  private static ActionSheetItem bq()
  {
    int i;
    if (QQTheme.a()) {
      i = 2130841323;
    } else {
      i = 2130841322;
    }
    return a(i, 2131718945, "follow_manage");
  }
  
  private static ActionSheetItem br()
  {
    int i;
    if (QQTheme.a()) {
      i = 2130843732;
    } else {
      i = 2130843733;
    }
    return a(i, 2131718894, "add_to_digest");
  }
  
  private static ActionSheetItem bs()
  {
    int i;
    if (QQTheme.a()) {
      i = 2130843740;
    } else {
      i = 2130843741;
    }
    return a(i, 2131718895, "cancel_digest");
  }
  
  private static ActionSheetItem bt()
  {
    int i;
    if (QQTheme.a()) {
      i = 2130843744;
    } else {
      i = 2130843745;
    }
    return a(i, 2131718897, "interest");
  }
  
  private static ActionSheetItem bu()
  {
    int i;
    if (QQTheme.a()) {
      i = 2130843736;
    } else {
      i = 2130843737;
    }
    return a(i, 2131718898, "look_owner");
  }
  
  public static ActionSheetItem build(int paramInt)
  {
    Object localObject1;
    switch (paramInt)
    {
    case 24: 
    case 25: 
    case 28: 
    case 29: 
    case 33: 
    case 36: 
    case 41: 
    case 42: 
    case 43: 
    case 46: 
    case 47: 
    case 49: 
    case 53: 
    case 57: 
    case 58: 
    case 59: 
    case 60: 
    case 61: 
    case 62: 
    case 63: 
    case 67: 
    case 69: 
    case 93: 
    case 139: 
    default: 
      localObject1 = new ActionSheetItem();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("build: notSupportAction = [");
      ((StringBuilder)localObject2).append(paramInt);
      ((StringBuilder)localObject2).append("]");
      QLog.e("ShareActionSheetBuilder", 1, ((StringBuilder)localObject2).toString(), new IllegalArgumentException());
      break;
    case 164: 
      localObject1 = b();
      break;
    case 163: 
      localObject1 = a();
      break;
    case 162: 
      localObject1 = bj();
      break;
    case 161: 
      localObject1 = bb();
      break;
    case 160: 
      localObject1 = bf();
      break;
    case 159: 
      localObject1 = bh();
      break;
    case 158: 
      localObject1 = bg();
      break;
    case 157: 
      localObject1 = bk();
      break;
    case 156: 
      localObject1 = bp();
      break;
    case 155: 
      localObject1 = bo();
      break;
    case 154: 
      localObject1 = bn();
      break;
    case 153: 
      localObject1 = bm();
      break;
    case 152: 
      localObject1 = bl();
      break;
    case 151: 
      localObject1 = bx();
      break;
    case 150: 
      localObject1 = bw();
      break;
    case 149: 
      localObject1 = bv();
      break;
    case 148: 
      localObject1 = bu();
      break;
    case 147: 
      localObject1 = bt();
      break;
    case 146: 
      localObject1 = bs();
      break;
    case 145: 
      localObject1 = br();
      break;
    case 144: 
      localObject1 = bq();
      break;
    case 143: 
      localObject1 = aE();
      break;
    case 142: 
      localObject1 = aD();
      break;
    case 141: 
      localObject1 = L();
      break;
    case 140: 
      localObject1 = bi();
      break;
    case 138: 
      localObject1 = be();
      break;
    case 137: 
      localObject1 = bc();
      break;
    case 136: 
      localObject1 = aY();
      break;
    case 135: 
      localObject1 = aZ();
      break;
    case 134: 
      localObject1 = aX();
      break;
    case 133: 
      localObject1 = ba();
      break;
    case 132: 
      localObject1 = aT();
      break;
    case 131: 
      localObject1 = Q();
      break;
    case 130: 
      localObject1 = P();
      break;
    case 129: 
      localObject1 = O();
      break;
    case 128: 
      localObject1 = S();
      break;
    case 125: 
      localObject1 = d();
      break;
    case 124: 
      localObject1 = c();
      break;
    case 123: 
      localObject1 = aU();
      break;
    case 122: 
      localObject1 = aS();
      break;
    case 121: 
      localObject1 = aR();
      break;
    case 120: 
      localObject1 = aQ();
      break;
    case 119: 
      localObject1 = aP();
      break;
    case 118: 
      localObject1 = aO();
      break;
    case 117: 
      localObject1 = n();
      break;
    case 116: 
      localObject1 = m();
      break;
    case 115: 
      localObject1 = l();
      break;
    case 114: 
      localObject1 = k();
      break;
    case 113: 
      localObject1 = j();
      break;
    case 112: 
      localObject1 = i();
      break;
    case 111: 
      localObject1 = h();
      break;
    case 110: 
      localObject1 = g();
      break;
    case 109: 
      localObject1 = f();
      break;
    case 108: 
      localObject1 = e();
      break;
    case 107: 
      localObject1 = o();
      break;
    case 106: 
      localObject1 = p();
      break;
    case 105: 
      localObject1 = q();
      break;
    case 104: 
      localObject1 = r();
      break;
    case 103: 
      localObject1 = s();
      break;
    case 102: 
      localObject1 = t();
      break;
    case 101: 
      localObject1 = u();
      break;
    case 100: 
      localObject1 = v();
      break;
    case 99: 
      localObject1 = w();
      break;
    case 98: 
      localObject1 = x();
      break;
    case 97: 
      localObject1 = y();
      break;
    case 96: 
      localObject1 = z();
      break;
    case 95: 
      localObject1 = A();
      break;
    case 94: 
      localObject1 = B();
      break;
    case 92: 
      localObject1 = C();
      break;
    case 91: 
      localObject1 = D();
      break;
    case 90: 
      localObject1 = aW();
      break;
    case 89: 
      localObject1 = aV();
      break;
    case 88: 
      localObject1 = G();
      break;
    case 87: 
      localObject1 = I();
      break;
    case 86: 
      localObject1 = J();
      break;
    case 85: 
      localObject1 = K();
      break;
    case 84: 
      localObject1 = M();
      break;
    case 82: 
      localObject1 = N();
      break;
    case 81: 
      localObject1 = R();
      break;
    case 80: 
      localObject1 = W();
      break;
    case 79: 
      localObject1 = X();
      break;
    case 78: 
      localObject1 = V();
      break;
    case 77: 
      localObject1 = T();
      break;
    case 76: 
      localObject1 = U();
      break;
    case 75: 
      localObject1 = Y();
      break;
    case 74: 
      localObject1 = Z();
      break;
    case 73: 
      localObject1 = a(2130850043, 2131718955, "");
      break;
    case 72: 
      localObject1 = a(2130840321, 2131718905, "");
      break;
    case 71: 
      localObject1 = aa();
      break;
    case 70: 
      localObject1 = ab();
      break;
    case 68: 
      localObject1 = ac();
      break;
    case 66: 
      localObject1 = aC();
      break;
    case 65: 
      localObject1 = ad();
      break;
    case 64: 
      localObject1 = ae();
      break;
    case 56: 
    case 127: 
      localObject1 = af();
      break;
    case 55: 
    case 126: 
      localObject1 = ag();
      break;
    case 54: 
      localObject1 = ah();
      break;
    case 52: 
      localObject1 = ai();
      break;
    case 51: 
      localObject1 = aj();
      break;
    case 50: 
      localObject1 = ak();
      break;
    case 48: 
      localObject1 = al();
      break;
    case 45: 
    case 83: 
      localObject1 = am();
      break;
    case 44: 
      localObject1 = an();
      break;
    case 40: 
      localObject1 = E();
      break;
    case 39: 
      localObject1 = ao();
      break;
    case 38: 
      localObject1 = ap();
      break;
    case 37: 
      localObject1 = aq();
      break;
    case 35: 
      localObject1 = ar();
      break;
    case 34: 
      localObject1 = a(2130842738, 2131696404, "share_diandian");
      break;
    case 32: 
      localObject1 = H();
      break;
    case 31: 
      localObject1 = bd();
      break;
    case 30: 
      localObject1 = as();
      break;
    case 27: 
      localObject1 = at();
      break;
    case 26: 
      localObject1 = au();
      break;
    case 23: 
      localObject1 = av();
      break;
    case 22: 
      localObject1 = bb();
      break;
    case 21: 
      localObject1 = aw();
      break;
    case 20: 
      localObject1 = ax();
      break;
    case 19: 
      localObject1 = ay();
      break;
    case 18: 
      localObject1 = a(2130843829, 2131697245, "refresh_troop_app_view");
      break;
    case 17: 
      localObject1 = a(2130843830, 2131697246, "share_troop_app");
      break;
    case 16: 
      localObject1 = a(2130843827, 2131697243, "open_app_detail");
      break;
    case 15: 
      localObject1 = a(2130843825, 2131697240, "add_troop_app");
      break;
    case 14: 
      localObject1 = az();
      break;
    case 13: 
      localObject1 = aA();
      break;
    case 12: 
      localObject1 = aB();
      break;
    case 11: 
      localObject1 = aC();
      break;
    case 10: 
      localObject1 = aF();
      break;
    case 9: 
      localObject1 = aG();
      break;
    case 8: 
      localObject1 = F();
      break;
    case 7: 
      localObject1 = aH();
      break;
    case 6: 
      localObject1 = aI();
      break;
    case 5: 
      localObject1 = aJ();
      break;
    case 4: 
      localObject1 = aK();
      break;
    case 3: 
      localObject1 = aL();
      break;
    case 2: 
      localObject1 = aM();
      break;
    case 1: 
      localObject1 = aN();
    }
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = new ActionSheetItem();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("build: notSupportAction = [");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append("]");
      QLog.e("ShareActionSheetBuilder", 1, ((StringBuilder)localObject1).toString(), new IllegalArgumentException());
    }
    ((ActionSheetItem)localObject2).action = paramInt;
    return localObject2;
  }
  
  private static ActionSheetItem bv()
  {
    int i;
    if (QQTheme.a()) {
      i = 2130843738;
    } else {
      i = 2130843739;
    }
    return a(i, 2131718900, "push_topics");
  }
  
  private static ActionSheetItem bw()
  {
    int i;
    if (QQTheme.a()) {
      i = 2130843742;
    } else {
      i = 2130843743;
    }
    return a(i, 2131718899, "pull_black");
  }
  
  private static ActionSheetItem bx()
  {
    int i;
    if (QQTheme.a()) {
      i = 2130843734;
    } else {
      i = 2130843735;
    }
    return a(i, 2131718896, "feedback");
  }
  
  private static ActionSheetItem c()
  {
    int i;
    if (QQTheme.a()) {
      i = 2130851204;
    } else {
      i = 2130851203;
    }
    return a(i, 2131718938, "download");
  }
  
  private static ActionSheetItem d()
  {
    int i;
    if (QQTheme.a()) {
      i = 2130851202;
    } else {
      i = 2130851201;
    }
    return a(i, 2131718927, "carton_detail");
  }
  
  private static ActionSheetItem e()
  {
    int i;
    if (QQTheme.a()) {
      i = 2130841901;
    } else {
      i = 2130841900;
    }
    return a(i, 2131718966, "book_detail");
  }
  
  private static ActionSheetItem f()
  {
    int i;
    if (QQTheme.a()) {
      i = 2130841899;
    } else {
      i = 2130841898;
    }
    return a(i, 2131718965, "add_shelf");
  }
  
  private static ActionSheetItem g()
  {
    int i;
    if (QQTheme.a()) {
      i = 2130841905;
    } else {
      i = 2130841902;
    }
    return a(i, 2131718967, "bookmark");
  }
  
  private static ActionSheetItem h()
  {
    int i;
    if (QQTheme.a()) {
      i = 2130841904;
    } else {
      i = 2130841903;
    }
    return a(i, 2131718968, "bookmark_cancel");
  }
  
  private static ActionSheetItem i()
  {
    int i;
    if (QQTheme.a()) {
      i = 2130841911;
    } else {
      i = 2130841910;
    }
    return a(i, 2131718971, "hide_opinion");
  }
  
  private static ActionSheetItem j()
  {
    int i;
    if (QQTheme.a()) {
      i = 2130841917;
    } else {
      i = 2130841916;
    }
    return a(i, 2131718974, "show_opinion");
  }
  
  private static ActionSheetItem k()
  {
    int i;
    if (QQTheme.a()) {
      i = 2130841909;
    } else {
      i = 2130841906;
    }
    return a(i, 2131718969, "continue_purchase");
  }
  
  private static ActionSheetItem l()
  {
    int i;
    if (QQTheme.a()) {
      i = 2130841908;
    } else {
      i = 2130841907;
    }
    return a(i, 2131718970, "continue_purchase_cancel");
  }
  
  private static ActionSheetItem m()
  {
    int i;
    if (QQTheme.a()) {
      i = 2130841915;
    } else {
      i = 2130841912;
    }
    return a(i, 2131718972, "privacy");
  }
  
  private static ActionSheetItem n()
  {
    int i;
    if (QQTheme.a()) {
      i = 2130841914;
    } else {
      i = 2130841913;
    }
    return a(i, 2131718973, "privacy_cancel");
  }
  
  private static ActionSheetItem o()
  {
    return a(2130848678, 2131718989, "set_background");
  }
  
  private static ActionSheetItem p()
  {
    return a(2130848682, 2131718928, "rec_face");
  }
  
  private static ActionSheetItem q()
  {
    return a(2130848099, 2131718962, "psapp");
  }
  
  private static ActionSheetItem r()
  {
    return a(2130848092, 2131719001, "watch_on_tv");
  }
  
  private static ActionSheetItem s()
  {
    return a(2130848095, 2131718926, "no_only_friend");
  }
  
  private static ActionSheetItem t()
  {
    int i;
    if (QQTheme.a()) {
      i = 2130846565;
    } else {
      i = 2130846564;
    }
    return a(i, 2131718957, "only_friend");
  }
  
  private static ActionSheetItem u()
  {
    return a(2130848096, 2131718980, "reprint_diary");
  }
  
  private static ActionSheetItem v()
  {
    return a(2130848096, 2131718981, "reprint_photo");
  }
  
  private static ActionSheetItem w()
  {
    return a(2130848103, 2131719000, "look_dress");
  }
  
  private static ActionSheetItem x()
  {
    return a(2130848103, 2131718990, "set_card");
  }
  
  private static ActionSheetItem y()
  {
    return a(2130848109, 2131718995, "unstick");
  }
  
  private static ActionSheetItem z()
  {
    return a(2130848106, 2131718992, "stick");
  }
  
  public boolean isValidCreate()
  {
    return this.jdField_a_of_type_JavaLangIllegalStateException == null;
  }
  
  public boolean isValidIcon()
  {
    if (this.iconNeedBg)
    {
      if (Arrays.binarySearch(jdField_a_of_type_ArrayOfInt, this.icon) >= 0) {
        return true;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.label);
        localStringBuilder.append(" is in invalid icon ");
        localStringBuilder.append(this);
        QLog.d("ShareActionSheetBuilder", 2, localStringBuilder.toString());
      }
    }
    return false;
  }
  
  public boolean isValidLabel()
  {
    Resources localResources = BaseApplication.getContext().getResources();
    int i = 0;
    for (;;)
    {
      int[] arrayOfInt = b;
      if (i >= arrayOfInt.length) {
        break;
      }
      if (TextUtils.equals(this.label, localResources.getString(arrayOfInt[i]))) {
        return true;
      }
      i += 1;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem
 * JD-Core Version:    0.7.0.1
 */