package com.tencent.mobileqq.utils;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import blqj;
import com.tencent.common.app.BaseApplicationImpl;
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
  private static final int[] jdField_a_of_type_ArrayOfInt;
  private static final int[] b;
  private IllegalStateException jdField_a_of_type_JavaLangIllegalStateException;
  public int action;
  public String argus;
  public boolean enable = true;
  public int firstLineCount;
  public int icon;
  public Drawable iconDrawable;
  public boolean iconNeedBg = true;
  public int id;
  public String label;
  public View.OnClickListener listener;
  public String reportID;
  public String uin;
  public int uinType;
  public int visibility = 0;
  
  static
  {
    int j = 0;
    jdField_a_of_type_ArrayOfInt = new int[] { 2130846305, 2130846306, 2130846265, 2130846266, 2130846271, 2130846272, 2130846259, 2130846260, 2130846256, 2130846257, 2130846311, 2130846312, 2130846294, 2130846295, 2130846301, 2130846302, 2130846275, 2130846276, 2130846277, 2130846278, 2130846337, 2130846338, 2130846284, 2130846285, 2130846269, 2130846270, 2130843634, 2130843636, 2130843639, 2130843638, 2130844437, 2130844438, 2130842621, 2130846339, 2130846340, 2130839088, 2130839311, 2130839344, 2130846279, 2130846280, 2130846263, 2130846264, 2130842622, 2130842632, 2130842617, 2130842623, 2130842619, 2130846307, 2130846308, 2130846675, 2130846918, 2130839093, 2130842605, 2130846356, 2130843140, 2130846290, 2130846291, 2130846273, 2130846274, 2130846267, 2130846268, 2130846353, 2130846354, 2130846252, 2130846319, 2130846320, 2130846323, 2130846253, 2130846254, 2130846325, 2130846326, 2130846299, 2130846300, 2130844322, 2130850544, 2130850545, 2130846288, 2130846289, 2130846297, 2130846298, 2130846321, 2130846322, 2130849515, 2130846357, 2130849514, 2130846296, 2130840274, 2130849711, 2130849712, 2130840156, 2130841251, 2130841252, 2130841263, 2130846293, 2130841264, 2130841265, 2130841266, 2130841267, 2130846359, 2130846338, 2130846329, 2130846330, 2130846303, 2130846304, 2130841253, 2130841254, 2130841258, 2130841259, 2130841255, 2130841256, 2130841261, 2130841262, 2130842614, 2130847880, 2130847877, 2130847875, 2130847874, 2130847873, 2130847866, 2130847867, 2130847864, 2130847865, 2130847878, 2130847868, 2130846317, 2130846318, 2130847876, 2130847879, 2130848440, 2130847863, 2130847870, 2130848443, 2130848439, 2130846327, 2130846328, 2130842614, 2130841805, 2130841803, 2130841807, 2130841808, 2130841815, 2130841821, 2130841811, 2130841812, 2130841817, 2130841818, 2130840157, 2130844247, 2130837578, 2130837579, 2130840148, 2130844243, 2130844256, 2130844257, 2130844245, 2130844246, 2130844248, 2130844249, 2130844220, 2130844221, 2130844216, 2130844217, 2130844222, 2130844223, 2130844241, 2130844242, 2130840199, 2130840200, 2130840195, 2130840196, 2130849493, 2130849492, 2130849507, 2130849506, 2130849489, 2130849488, 2130849513, 2130849512, 2130849501, 2130849500, 2130849505, 2130849504, 2130849497, 2130849496, 2130849503, 2130849502, 2130840911, 2130840912, 2130843932, 2130843933, 2130849502, 2130849491, 2130849490, 2130849509, 2130849508, 2130849495, 2130849494, 2130849511, 2130849510, 2130849499, 2130849498, 2130849487, 2130849486, 2130846317, 2130846318, 2130843545, 2130843544, 2130843547, 2130843546, 2130843549, 2130843548, 2130843553, 2130843552, 2130843555, 2130843554, 2130843543, 2130843542, 2130843551, 2130843550, 2130849275, 2130844053, 2130844052 };
    HashSet localHashSet = new HashSet();
    int i = 0;
    if (i < jdField_a_of_type_ArrayOfInt.length)
    {
      if (localHashSet.contains(Integer.valueOf(jdField_a_of_type_ArrayOfInt[i]))) {
        QLog.e("ShareActionSheetBuilder", 1, "static initializer() called duplicated icon " + i + ", " + BaseApplicationImpl.getApplication().getResources().getResourceEntryName(jdField_a_of_type_ArrayOfInt[i]));
      }
      for (;;)
      {
        i += 1;
        break;
        localHashSet.add(Integer.valueOf(jdField_a_of_type_ArrayOfInt[i]));
      }
    }
    Arrays.sort(jdField_a_of_type_ArrayOfInt);
    b = new int[] { 2131718085, 2131718106, 2131718107, 2131718036, 2131718037, 2131718038, 2131718076, 2131718111, 2131718136, 2131718082, 2131718133, 2131718134, 2131718135, 2131718124, 2131718035, 2131718090, 2131718105, 2131718084, 2131718086, 2131718129, 2131718044, 2131718088, 2131718117, 2131718115, 2131718116, 2131718045, 2131718108, 2131718055, 2131718112, 2131718047, 2131718046, 2131718052, 2131718050, 2131718053, 2131718051, 2131718054, 2131718066, 2131718061, 2131718062, 2131718034, 2131718049, 2131718091, 2131718114, 2131718048, 2131718118, 2131718063, 2131718039, 2131718043, 2131718042, 2131718040, 2131718128, 2131718109, 2131718089, 2131718059, 2131718060, 2131718080, 2131718081, 2131718113, 2131718093, 2131718064, 2131718065, 2131696559, 2131696562, 2131696565, 2131696564, 2131695743, 2131694692, 2131718126, 2131718078, 2131718077, 2131718079, 2131718074, 2131718127, 2131718132, 2131718094, 2131718041, 2131718070, 2131718083, 2131718069, 2131718121, 2131718122, 2131718125, 2131718120, 2131718130, 2131718110, 2131718087, 2131718056, 2131718067, 2131718131, 2131718092, 2131718058, 2131718119, 2131694692, 2131718096, 2131718095, 2131718097, 2131718098, 2131718101, 2131718104, 2131718099, 2131718100, 2131718102, 2131718103, 2131718072, 2131718071, 2131718073, 2131697473, 2131718103, 2131718094, 2131718041, 2131718103, 2131718012, 2131718033, 2131718015, 2131718021, 2131718032, 2131718014, 2131718018, 2131718013, 2131718019, 2131718018, 2131718016, 2131718022, 2131718024, 2131718017, 2131718011, 2131718023, 2131718075, 2131718025, 2131718026, 2131718028, 2131718029, 2131718031, 2131718030, 2131718027 };
    localHashSet = new HashSet();
    i = j;
    if (i < b.length)
    {
      if (localHashSet.contains(Integer.valueOf(b[i]))) {
        QLog.e("ShareActionSheetBuilder", 1, "static initializer() called duplicated label " + i + ", " + BaseApplicationImpl.getApplication().getResources().getResourceEntryName(b[i]));
      }
      for (;;)
      {
        i += 1;
        break;
        localHashSet.add(Integer.valueOf(b[i]));
      }
    }
    Arrays.sort(b);
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
    return a(2130847873, 2131718083, "open_aio");
  }
  
  private static ActionSheetItem B()
  {
    return a(2130847865, 2131718070, "Evernote");
  }
  
  private static ActionSheetItem C()
  {
    return a(2130848440, 2131718067, "delete");
  }
  
  private static ActionSheetItem D()
  {
    int i = 2130846301;
    if (blqj.a()) {
      i = 2130846302;
    }
    return a(i, 2131695763, "check_profile");
  }
  
  private static ActionSheetItem E()
  {
    int i = 2130849275;
    if (blqj.a()) {
      i = 2130849276;
    }
    return a(i, 2131718132, "orignal");
  }
  
  private static ActionSheetItem F()
  {
    return a(2130847879, 2131718127, "unfollow");
  }
  
  private static ActionSheetItem G()
  {
    return a(2130847876, 2131718074, "follow");
  }
  
  private static ActionSheetItem H()
  {
    return a(2130847868, 2131718079, "hide_him");
  }
  
  private static ActionSheetItem I()
  {
    int i = 2130846317;
    if (blqj.a()) {
      i = 2130846318;
    }
    return a(i, 2131718078, "hide_this_feed");
  }
  
  private static ActionSheetItem J()
  {
    int i = 2130846317;
    if (blqj.a()) {
      i = 2130846318;
    }
    return a(i, 2131718077, "hide_works");
  }
  
  private static ActionSheetItem K()
  {
    return a(2130847878, 2131718126, "collect_cancel");
  }
  
  private static ActionSheetItem L()
  {
    int i = 2130846297;
    if (blqj.a()) {
      i = 2130846298;
    }
    return a(i, 2131718062, "colornote_cancel");
  }
  
  private static ActionSheetItem M()
  {
    int i = 2130844220;
    if (blqj.a()) {
      i = 2130844221;
    }
    return a(i, 2131718072, "fav_group");
  }
  
  private static ActionSheetItem N()
  {
    int i = 2130844216;
    if (blqj.a()) {
      i = 2130844217;
    }
    return a(i, 2131718071, "fav_detail");
  }
  
  private static ActionSheetItem O()
  {
    int i = 2130844222;
    if (blqj.a()) {
      i = 2130844223;
    }
    return a(i, 2131718073, "fav_show_originalurl");
  }
  
  private static ActionSheetItem P()
  {
    int i = 2130841253;
    if (blqj.a()) {
      i = 2130841254;
    }
    return a(i, 2131718055, "backtohome");
  }
  
  private static ActionSheetItem Q()
  {
    int i = 2130841258;
    if (blqj.a()) {
      i = 2130841259;
    }
    return a(i, 2131718112, "restart_applet");
  }
  
  private static ActionSheetItem R()
  {
    int i = 2130841266;
    if (blqj.a()) {
      i = 2130841267;
    }
    return a(i, 2131718108, "remove_my");
  }
  
  private static ActionSheetItem S()
  {
    int i = 2130841264;
    if (blqj.a()) {
      i = 2130841265;
    }
    return a(i, 2131718045, "add_my");
  }
  
  private static ActionSheetItem T()
  {
    int i = 2130841251;
    if (blqj.a()) {
      i = 2130841252;
    }
    return a(i, 2131718040, "about");
  }
  
  private static ActionSheetItem U()
  {
    int i = 2130841255;
    if (blqj.a()) {
      i = 2130841256;
    }
    return a(i, 2131718051, "applet_closeperformance");
  }
  
  private static ActionSheetItem V()
  {
    int i = 2130841255;
    if (blqj.a()) {
      i = 2130841256;
    }
    return a(i, 2131718053, "applet_openperformance");
  }
  
  private static ActionSheetItem W()
  {
    int i = 2130841255;
    if (blqj.a()) {
      i = 2130841256;
    }
    return a(i, 2131718050, "applet_closedebug");
  }
  
  private static ActionSheetItem X()
  {
    int i = 2130841255;
    if (blqj.a()) {
      i = 2130841256;
    }
    return a(i, 2131718052, "applet_opendebug");
  }
  
  private static ActionSheetItem Y()
  {
    int i = 2130846321;
    if (blqj.a()) {
      i = 2130846322;
    }
    return a(i, 2131718084, "long_screenshot");
  }
  
  private static ActionSheetItem Z()
  {
    int i = 2130846288;
    if (blqj.a()) {
      i = 2130846289;
    }
    return a(i, 2131718061, "colornote");
  }
  
  private static ActionSheetItem a()
  {
    int i = 2130850789;
    if (blqj.a()) {
      i = 2130850790;
    }
    return a(i, 2131718068, "download");
  }
  
  private static ActionSheetItem a(int paramInt1, int paramInt2, String paramString)
  {
    return a(paramInt1, paramInt2, paramString, BaseApplicationImpl.getApplication().getResources());
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
    int i = 2130846337;
    if (blqj.a()) {
      i = 2130846338;
    }
    return a(i, 2131718109, "report");
  }
  
  private static ActionSheetItem aB()
  {
    int i = 2130846303;
    if (blqj.a()) {
      i = 2130846304;
    }
    return a(i, 2131718089, "open_barrage");
  }
  
  private static ActionSheetItem aC()
  {
    int i = 2130846329;
    if (blqj.a()) {
      i = 2130846330;
    }
    return a(i, 2131718059, "close_barrage");
  }
  
  private static ActionSheetItem aD()
  {
    int i = 2130846277;
    if (blqj.a()) {
      i = 2130846278;
    }
    return a(i, 2131718134, "wechat_");
  }
  
  private static ActionSheetItem aE()
  {
    int i = 2130846275;
    if (blqj.a()) {
      i = 2130846276;
    }
    return a(i, 2131718133, "wechat");
  }
  
  private static ActionSheetItem aF()
  {
    int i = 2130846294;
    if (blqj.a()) {
      i = 2130846295;
    }
    return a(i, 2131718048, "adjust_font");
  }
  
  private static ActionSheetItem aG()
  {
    int i = 2130846311;
    if (blqj.a()) {
      i = 2130846312;
    }
    return a(i, 2131718060, "collect");
  }
  
  private static ActionSheetItem aH()
  {
    int i = 2130846256;
    if (blqj.a()) {
      i = 2130846257;
    }
    return a(i, 2131718035, "Qbrowser");
  }
  
  private static ActionSheetItem aI()
  {
    int i = 2130846259;
    if (blqj.a()) {
      i = 2130846260;
    }
    return a(i, 2131718124, "browser");
  }
  
  private static ActionSheetItem aJ()
  {
    int i = 2130846271;
    if (blqj.a()) {
      i = 2130846272;
    }
    return a(i, 2131718037, "Qzone");
  }
  
  private static ActionSheetItem aK()
  {
    int i = 2130846265;
    if (blqj.a()) {
      i = 2130846266;
    }
    return a(i, 2131718036, "Qfriend");
  }
  
  private static ActionSheetItem aL()
  {
    int i = 2130846305;
    if (blqj.a()) {
      i = 2130846306;
    }
    return a(i, 2131718063, "copy_link");
  }
  
  private static ActionSheetItem aM()
  {
    int i = 2130840157;
    if (blqj.a()) {
      i = 2130844247;
    }
    return a(i, 2131718080, "Import_reader");
  }
  
  private static ActionSheetItem aN()
  {
    int i = 2130837578;
    if (blqj.a()) {
      i = 2130837579;
    }
    return a(i, 2131718081, "edit_online");
  }
  
  private static ActionSheetItem aO()
  {
    int i = 2130840148;
    if (blqj.a()) {
      i = 2130844243;
    }
    return a(i, 2131718113, "safe_share");
  }
  
  private static ActionSheetItem aP()
  {
    int i = 2130844256;
    if (blqj.a()) {
      i = 2130844257;
    }
    return a(i, 2131718093, "print");
  }
  
  private static ActionSheetItem aQ()
  {
    int i = 2130844245;
    if (blqj.a()) {
      i = 2130844246;
    }
    return a(i, 2131718064, "generate_link");
  }
  
  private static ActionSheetItem aR()
  {
    int i = 2130844241;
    if (blqj.a()) {
      i = 2130844242;
    }
    return a(i, 2131697473, "other_app");
  }
  
  private static ActionSheetItem aS()
  {
    int i = 2130844248;
    if (blqj.a()) {
      i = 2130844249;
    }
    return a(i, 2131718065, "generate_QRcode");
  }
  
  private static ActionSheetItem aT()
  {
    int i = 2130840195;
    if (blqj.a()) {
      i = 2130840196;
    }
    return a(i, 2131718094, "ad_promotion");
  }
  
  private static ActionSheetItem aU()
  {
    int i = 2130840199;
    if (blqj.a()) {
      i = 2130840200;
    }
    return a(i, 2131718041, "ad_block");
  }
  
  private static ActionSheetItem aV()
  {
    if (blqj.a()) {}
    for (int i = 2130849488;; i = 2130849489) {
      return a(i, 2131718012, "addto_section");
    }
  }
  
  private static ActionSheetItem aW()
  {
    if (blqj.a()) {}
    for (int i = 2130849506;; i = 2130849507) {
      return a(i, 2131718021, "delete_section");
    }
  }
  
  private static ActionSheetItem aX()
  {
    if (blqj.a()) {}
    for (int i = 2130849492;; i = 2130849493) {
      return a(i, 2131718015, "delete_from_section");
    }
  }
  
  private static ActionSheetItem aY()
  {
    if (blqj.a()) {}
    for (int i = 2130849512;; i = 2130849513) {
      return a(i, 2131718033, "kouling_share");
    }
  }
  
  private static ActionSheetItem aZ()
  {
    if (blqj.a()) {}
    for (int i = 2130849500;; i = 2130849501) {
      return a(i, 2131718032, "play_feedback");
    }
  }
  
  private static ActionSheetItem aa()
  {
    int i = 2130850544;
    if (blqj.a()) {
      i = 2130850545;
    }
    return a(i, 2131718129, "url_to_txdoc");
  }
  
  private static ActionSheetItem ab()
  {
    int i = 2130846299;
    if (blqj.a()) {
      i = 2130846300;
    }
    return a(i, 2131718117, "search_emotion");
  }
  
  private static ActionSheetItem ac()
  {
    int i = 2130846325;
    if (blqj.a()) {
      i = 2130846326;
    }
    return a(i, 2131718090, "other_app");
  }
  
  private static ActionSheetItem ad()
  {
    int i = 2130846323;
    if (blqj.a()) {
      i = 2130846324;
    }
    return a(i, 2131718115, "scan_appletcode");
  }
  
  private static ActionSheetItem ae()
  {
    int i = 2130846339;
    if (blqj.a()) {
      i = 2130846340;
    }
    return a(i, 2131718116, "scan_qrcode");
  }
  
  private static ActionSheetItem af()
  {
    int i = 2130846319;
    if (blqj.a()) {
      i = 2130846320;
    }
    return a(i, 2131718049, "aio_position");
  }
  
  private static ActionSheetItem ag()
  {
    int i = 2130846353;
    if (blqj.a()) {
      i = 2130846354;
    }
    return a(i, 2131718091, "pick_words");
  }
  
  private static ActionSheetItem ah()
  {
    int i = 2130846267;
    if (blqj.a()) {
      i = 2130846268;
    }
    return a(i, 2131718076, "group_album");
  }
  
  private static ActionSheetItem ai()
  {
    int i = 2130846273;
    if (blqj.a()) {
      i = 2130846274;
    }
    return a(i, 2131718038, "Qzone_album");
  }
  
  private static ActionSheetItem aj()
  {
    int i = 2130846290;
    if (blqj.a()) {
      i = 2130846291;
    }
    return a(i, 2131718043, "add_emotion");
  }
  
  private static ActionSheetItem ak()
  {
    int i = 2130841261;
    if (blqj.a()) {
      i = 2130841262;
    }
    return a(i, 2131718105, "push_setup");
  }
  
  private static ActionSheetItem al()
  {
    int i = 2130846356;
    if (blqj.a()) {
      i = 2130846357;
    }
    return a(i, 2131718128, "uninterested");
  }
  
  private static ActionSheetItem am()
  {
    int i = 2130846307;
    if (blqj.a()) {
      i = 2130846308;
    }
    return a(i, 2131718114, "save");
  }
  
  private static ActionSheetItem an()
  {
    int i = 2130849514;
    if (blqj.a()) {
      i = 2130846296;
    }
    return a(i, 2131718086, "not_care");
  }
  
  private static ActionSheetItem ao()
  {
    if (blqj.a()) {}
    return a(2130842622, 2131694640, "open_aio");
  }
  
  private static ActionSheetItem ap()
  {
    if (blqj.a()) {}
    return a(2130842623, 2131718044, "add_friend");
  }
  
  private static ActionSheetItem aq()
  {
    if (blqj.a()) {}
    return a(2130842622, 2131718088, "open_aio");
  }
  
  private static ActionSheetItem ar()
  {
    int i = 2130846279;
    if (blqj.a()) {
      i = 2130846280;
    }
    return a(i, 2131718136, "weiyun");
  }
  
  private static ActionSheetItem as()
  {
    int i = 2130846263;
    if (blqj.a()) {
      i = 2130846264;
    }
    return a(i, 2131718118, "sent_pc");
  }
  
  private static ActionSheetItem at()
  {
    int i = 2130846339;
    if (blqj.a()) {
      i = 2130846340;
    }
    return a(i, 2131718034, "QRcode");
  }
  
  private static ActionSheetItem au()
  {
    if (blqj.a()) {}
    return a(2130842621, 2131718039, "Screenshot_share");
  }
  
  private static ActionSheetItem av()
  {
    if (blqj.a()) {}
    return a(2130844438, 2131718107, "qiyeqq");
  }
  
  private static ActionSheetItem aw()
  {
    if (blqj.a()) {}
    return a(2130844437, 2131718106, "qidian");
  }
  
  private static ActionSheetItem ax()
  {
    int i = 2130841263;
    if (blqj.a()) {
      i = 2130846293;
    }
    return a(i, 2131718042, "add_desktop");
  }
  
  private static ActionSheetItem ay()
  {
    int i = 2130846269;
    if (blqj.a()) {
      i = 2130846270;
    }
    return a(i, 2131718082, "kandian");
  }
  
  private static ActionSheetItem az()
  {
    int i = 2130846284;
    if (blqj.a()) {
      i = 2130846285;
    }
    return a(i, 2131718135, "weibo");
  }
  
  private static ActionSheetItem b()
  {
    int i = 2130850787;
    if (blqj.a()) {
      i = 2130850788;
    }
    return a(i, 2131718057, "carton_detail");
  }
  
  private static ActionSheetItem ba()
  {
    if (blqj.a()) {}
    for (int i = 2130849504;; i = 2130849505) {
      return a(i, 2131718014, "delete_fans");
    }
  }
  
  private static ActionSheetItem bb()
  {
    if (blqj.a()) {}
    for (int i = 2130849496;; i = 2130849497) {
      return a(i, 2131694692, "share_more");
    }
  }
  
  private static ActionSheetItem bc()
  {
    if (blqj.a()) {}
    for (int i = 2130849502;; i = 2130849503) {
      return a(i, 2131718018, "private_chat");
    }
  }
  
  private static ActionSheetItem bd()
  {
    if (blqj.a()) {}
    for (int i = 2130849502;; i = 2130849503) {
      return a(i, 2131718013, "copy_roomid");
    }
  }
  
  private static ActionSheetItem be()
  {
    if (blqj.a()) {}
    for (int i = 2130840912;; i = 2130840911) {
      return a(i, 2131718047, "group_app");
    }
  }
  
  private static ActionSheetItem bf()
  {
    if (blqj.a()) {}
    for (int i = 2130840912;; i = 2130840911) {
      return a(i, 2131718046, "add_to_group");
    }
  }
  
  private static ActionSheetItem bg()
  {
    if (blqj.a()) {}
    for (int i = 2130843933;; i = 2130843932) {
      return a(i, 2131718019, "delete_launch");
    }
  }
  
  private static ActionSheetItem bh()
  {
    if (blqj.a()) {}
    for (int i = 2130844053;; i = 2130844052) {
      return a(i, 2131718020, "qcircle_private_message");
    }
  }
  
  private static ActionSheetItem bi()
  {
    if (blqj.a()) {}
    for (int i = 2130849508;; i = 2130849509) {
      return a(i, 2131718023, "store_manage");
    }
  }
  
  private static ActionSheetItem bj()
  {
    if (blqj.a()) {}
    for (int i = 2130849494;; i = 2130849495) {
      return a(i, 2131718016, "fan_group_manage");
    }
  }
  
  private static ActionSheetItem bk()
  {
    if (blqj.a()) {}
    for (int i = 2130849490;; i = 2130849491) {
      return a(i, 2131718022, "sharepicture");
    }
  }
  
  private static ActionSheetItem bl()
  {
    if (blqj.a()) {}
    for (int i = 2130849510;; i = 2130849511) {
      return a(i, 2131718024, "Sync_zone");
    }
  }
  
  private static ActionSheetItem bm()
  {
    if (blqj.a()) {}
    for (int i = 2130849498;; i = 2130849499) {
      return a(i, 2131718017, "orderlist");
    }
  }
  
  private static ActionSheetItem bn()
  {
    if (blqj.a()) {}
    for (int i = 2130849486;; i = 2130849487) {
      return a(i, 2131718011, "adding goods");
    }
  }
  
  private static ActionSheetItem bo()
  {
    if (blqj.a()) {}
    for (int i = 2130841262;; i = 2130841261) {
      return a(i, 2131718075, "follow_manage");
    }
  }
  
  private static ActionSheetItem bp()
  {
    if (blqj.a()) {}
    for (int i = 2130843542;; i = 2130843543) {
      return a(i, 2131718025, "add_to_digest");
    }
  }
  
  private static ActionSheetItem bq()
  {
    if (blqj.a()) {}
    for (int i = 2130843550;; i = 2130843551) {
      return a(i, 2131718026, "cancel_digest");
    }
  }
  
  private static ActionSheetItem br()
  {
    if (blqj.a()) {}
    for (int i = 2130843554;; i = 2130843555) {
      return a(i, 2131718028, "interest");
    }
  }
  
  private static ActionSheetItem bs()
  {
    if (blqj.a()) {}
    for (int i = 2130843546;; i = 2130843547) {
      return a(i, 2131718029, "look_owner");
    }
  }
  
  private static ActionSheetItem bt()
  {
    if (blqj.a()) {}
    for (int i = 2130843548;; i = 2130843549) {
      return a(i, 2131718031, "push_topics");
    }
  }
  
  private static ActionSheetItem bu()
  {
    if (blqj.a()) {}
    for (int i = 2130843552;; i = 2130843553) {
      return a(i, 2131718030, "pull_black");
    }
  }
  
  public static ActionSheetItem build(int paramInt)
  {
    ActionSheetItem localActionSheetItem1;
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
      localActionSheetItem1 = new ActionSheetItem();
      QLog.e("ShareActionSheetBuilder", 1, "build: notSupportAction = [" + paramInt + "]", new IllegalArgumentException());
    }
    for (;;)
    {
      ActionSheetItem localActionSheetItem2 = localActionSheetItem1;
      if (localActionSheetItem1 == null)
      {
        localActionSheetItem2 = new ActionSheetItem();
        QLog.e("ShareActionSheetBuilder", 1, "build: notSupportAction = [" + paramInt + "]", new IllegalArgumentException());
      }
      localActionSheetItem2.action = paramInt;
      return localActionSheetItem2;
      localActionSheetItem1 = aL();
      continue;
      localActionSheetItem1 = aK();
      continue;
      localActionSheetItem1 = aJ();
      continue;
      localActionSheetItem1 = aI();
      continue;
      localActionSheetItem1 = aH();
      continue;
      localActionSheetItem1 = aG();
      continue;
      localActionSheetItem1 = aF();
      continue;
      localActionSheetItem1 = D();
      continue;
      localActionSheetItem1 = aE();
      continue;
      localActionSheetItem1 = aD();
      continue;
      localActionSheetItem1 = aA();
      continue;
      localActionSheetItem1 = aB();
      continue;
      localActionSheetItem1 = aC();
      continue;
      localActionSheetItem1 = az();
      continue;
      localActionSheetItem1 = ay();
      continue;
      localActionSheetItem1 = ax();
      continue;
      localActionSheetItem1 = aw();
      continue;
      localActionSheetItem1 = av();
      continue;
      localActionSheetItem1 = au();
      continue;
      localActionSheetItem1 = at();
      continue;
      localActionSheetItem1 = as();
      continue;
      localActionSheetItem1 = ar();
      continue;
      localActionSheetItem1 = aq();
      continue;
      localActionSheetItem1 = ap();
      continue;
      localActionSheetItem1 = ao();
      continue;
      localActionSheetItem1 = an();
      continue;
      localActionSheetItem1 = am();
      continue;
      localActionSheetItem1 = al();
      continue;
      localActionSheetItem1 = ak();
      continue;
      localActionSheetItem1 = aj();
      continue;
      localActionSheetItem1 = ai();
      continue;
      localActionSheetItem1 = ah();
      continue;
      localActionSheetItem1 = ag();
      continue;
      localActionSheetItem1 = af();
      continue;
      localActionSheetItem1 = ae();
      continue;
      localActionSheetItem1 = ad();
      continue;
      localActionSheetItem1 = ac();
      continue;
      localActionSheetItem1 = ab();
      continue;
      localActionSheetItem1 = aA();
      continue;
      localActionSheetItem1 = aa();
      continue;
      localActionSheetItem1 = Z();
      continue;
      localActionSheetItem1 = Y();
      continue;
      localActionSheetItem1 = a(2130840274, 2131718036, "");
      continue;
      localActionSheetItem1 = a(2130849711, 2131718085, "");
      continue;
      localActionSheetItem1 = X();
      continue;
      localActionSheetItem1 = W();
      continue;
      localActionSheetItem1 = V();
      continue;
      localActionSheetItem1 = U();
      continue;
      localActionSheetItem1 = T();
      continue;
      localActionSheetItem1 = S();
      continue;
      localActionSheetItem1 = R();
      continue;
      localActionSheetItem1 = P();
      continue;
      localActionSheetItem1 = L();
      continue;
      localActionSheetItem1 = M();
      continue;
      localActionSheetItem1 = N();
      continue;
      localActionSheetItem1 = O();
      continue;
      localActionSheetItem1 = aM();
      continue;
      localActionSheetItem1 = aN();
      continue;
      localActionSheetItem1 = aO();
      continue;
      localActionSheetItem1 = aP();
      continue;
      localActionSheetItem1 = aQ();
      continue;
      localActionSheetItem1 = aS();
      continue;
      localActionSheetItem1 = a(2130843634, 2131696559, "add_troop_app");
      continue;
      localActionSheetItem1 = a(2130843636, 2131696562, "open_app_detail");
      continue;
      localActionSheetItem1 = a(2130843639, 2131696565, "share_troop_app");
      continue;
      localActionSheetItem1 = a(2130843638, 2131696564, "refresh_troop_app_view");
      continue;
      localActionSheetItem1 = a(2130842617, 2131695743, "share_diandian");
      continue;
      localActionSheetItem1 = bb();
      continue;
      localActionSheetItem1 = K();
      continue;
      localActionSheetItem1 = I();
      continue;
      localActionSheetItem1 = J();
      continue;
      localActionSheetItem1 = H();
      continue;
      localActionSheetItem1 = G();
      continue;
      localActionSheetItem1 = F();
      continue;
      localActionSheetItem1 = E();
      continue;
      localActionSheetItem1 = C();
      continue;
      localActionSheetItem1 = B();
      continue;
      localActionSheetItem1 = A();
      continue;
      localActionSheetItem1 = z();
      continue;
      localActionSheetItem1 = y();
      continue;
      localActionSheetItem1 = x();
      continue;
      localActionSheetItem1 = w();
      continue;
      localActionSheetItem1 = v();
      continue;
      localActionSheetItem1 = u();
      continue;
      localActionSheetItem1 = t();
      continue;
      localActionSheetItem1 = s();
      continue;
      localActionSheetItem1 = r();
      continue;
      localActionSheetItem1 = q();
      continue;
      localActionSheetItem1 = p();
      continue;
      localActionSheetItem1 = o();
      continue;
      localActionSheetItem1 = n();
      continue;
      localActionSheetItem1 = m();
      continue;
      localActionSheetItem1 = a();
      continue;
      localActionSheetItem1 = b();
      continue;
      localActionSheetItem1 = c();
      continue;
      localActionSheetItem1 = d();
      continue;
      localActionSheetItem1 = e();
      continue;
      localActionSheetItem1 = f();
      continue;
      localActionSheetItem1 = g();
      continue;
      localActionSheetItem1 = h();
      continue;
      localActionSheetItem1 = i();
      continue;
      localActionSheetItem1 = j();
      continue;
      localActionSheetItem1 = k();
      continue;
      localActionSheetItem1 = l();
      continue;
      localActionSheetItem1 = Q();
      continue;
      localActionSheetItem1 = aR();
      continue;
      localActionSheetItem1 = aU();
      continue;
      localActionSheetItem1 = aT();
      continue;
      localActionSheetItem1 = aV();
      continue;
      localActionSheetItem1 = aW();
      continue;
      localActionSheetItem1 = aX();
      continue;
      localActionSheetItem1 = aY();
      continue;
      localActionSheetItem1 = aZ();
      continue;
      localActionSheetItem1 = ba();
      continue;
      localActionSheetItem1 = bc();
      continue;
      localActionSheetItem1 = bd();
      continue;
      localActionSheetItem1 = be();
      continue;
      localActionSheetItem1 = bf();
      continue;
      localActionSheetItem1 = bi();
      continue;
      localActionSheetItem1 = bj();
      continue;
      localActionSheetItem1 = bk();
      continue;
      localActionSheetItem1 = bl();
      continue;
      localActionSheetItem1 = bm();
      continue;
      localActionSheetItem1 = bn();
      continue;
      localActionSheetItem1 = bo();
      continue;
      localActionSheetItem1 = bp();
      continue;
      localActionSheetItem1 = bq();
      continue;
      localActionSheetItem1 = br();
      continue;
      localActionSheetItem1 = bs();
      continue;
      localActionSheetItem1 = bt();
      continue;
      localActionSheetItem1 = bu();
      continue;
      localActionSheetItem1 = bv();
      continue;
      localActionSheetItem1 = bg();
      continue;
      localActionSheetItem1 = aZ();
      continue;
      localActionSheetItem1 = bh();
    }
  }
  
  private static ActionSheetItem bv()
  {
    if (blqj.a()) {}
    for (int i = 2130843544;; i = 2130843545) {
      return a(i, 2131718027, "feedback");
    }
  }
  
  private static ActionSheetItem c()
  {
    int i = 2130841805;
    if (blqj.a()) {
      i = 2130841806;
    }
    return a(i, 2131718096, "book_detail");
  }
  
  private static ActionSheetItem d()
  {
    int i = 2130841803;
    if (blqj.a()) {
      i = 2130841804;
    }
    return a(i, 2131718095, "add_shelf");
  }
  
  private static ActionSheetItem e()
  {
    int i = 2130841807;
    if (blqj.a()) {
      i = 2130841810;
    }
    return a(i, 2131718097, "bookmark");
  }
  
  private static ActionSheetItem f()
  {
    int i = 2130841808;
    if (blqj.a()) {
      i = 2130841809;
    }
    return a(i, 2131718098, "bookmark_cancel");
  }
  
  private static ActionSheetItem g()
  {
    int i = 2130841815;
    if (blqj.a()) {
      i = 2130841816;
    }
    return a(i, 2131718101, "hide_opinion");
  }
  
  private static ActionSheetItem h()
  {
    int i = 2130841821;
    if (blqj.a()) {
      i = 2130841822;
    }
    return a(i, 2131718104, "show_opinion");
  }
  
  private static ActionSheetItem i()
  {
    int i = 2130841811;
    if (blqj.a()) {
      i = 2130841814;
    }
    return a(i, 2131718099, "continue_purchase");
  }
  
  private static ActionSheetItem j()
  {
    int i = 2130841812;
    if (blqj.a()) {
      i = 2130841813;
    }
    return a(i, 2131718100, "continue_purchase_cancel");
  }
  
  private static ActionSheetItem k()
  {
    int i = 2130841817;
    if (blqj.a()) {
      i = 2130841820;
    }
    return a(i, 2131718102, "privacy");
  }
  
  private static ActionSheetItem l()
  {
    int i = 2130841818;
    if (blqj.a()) {
      i = 2130841819;
    }
    return a(i, 2131718103, "privacy_cancel");
  }
  
  private static ActionSheetItem m()
  {
    return a(2130848439, 2131718119, "set_background");
  }
  
  private static ActionSheetItem n()
  {
    return a(2130848443, 2131718058, "rec_face");
  }
  
  private static ActionSheetItem o()
  {
    return a(2130847870, 2131718092, "psapp");
  }
  
  private static ActionSheetItem p()
  {
    return a(2130847863, 2131718131, "watch_on_tv");
  }
  
  private static ActionSheetItem q()
  {
    return a(2130847866, 2131718056, "no_only_friend");
  }
  
  private static ActionSheetItem r()
  {
    int i = 2130846327;
    if (blqj.a()) {
      i = 2130846328;
    }
    return a(i, 2131718087, "only_friend");
  }
  
  private static ActionSheetItem s()
  {
    return a(2130847867, 2131718110, "reprint_diary");
  }
  
  private static ActionSheetItem t()
  {
    return a(2130847867, 2131718111, "reprint_photo");
  }
  
  private static ActionSheetItem u()
  {
    return a(2130847874, 2131718130, "look_dress");
  }
  
  private static ActionSheetItem v()
  {
    return a(2130847874, 2131718120, "set_card");
  }
  
  private static ActionSheetItem w()
  {
    return a(2130847880, 2131718125, "unstick");
  }
  
  private static ActionSheetItem x()
  {
    return a(2130847877, 2131718122, "stick");
  }
  
  private static ActionSheetItem y()
  {
    return a(2130847875, 2131718121, "privacy");
  }
  
  private static ActionSheetItem z()
  {
    return a(2130847864, 2131718069, "edit");
  }
  
  public boolean isValidCreate()
  {
    return this.jdField_a_of_type_JavaLangIllegalStateException == null;
  }
  
  public boolean isValidIcon()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.iconNeedBg)
    {
      if (Arrays.binarySearch(jdField_a_of_type_ArrayOfInt, this.icon) < 0) {
        break label28;
      }
      bool1 = true;
    }
    label28:
    do
    {
      return bool1;
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.d("ShareActionSheetBuilder", 2, this.label + " is in invalid icon " + this);
    return false;
  }
  
  public boolean isValidLabel()
  {
    boolean bool2 = false;
    Resources localResources = BaseApplicationImpl.getApplication().getResources();
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < b.length)
      {
        if (TextUtils.equals(this.label, localResources.getString(b[i]))) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem
 * JD-Core Version:    0.7.0.1
 */