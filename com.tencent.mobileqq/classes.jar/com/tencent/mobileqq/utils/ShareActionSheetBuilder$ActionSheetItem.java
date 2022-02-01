package com.tencent.mobileqq.utils;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import bkpg;
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
    jdField_a_of_type_ArrayOfInt = new int[] { 2130846288, 2130846289, 2130846248, 2130846249, 2130846254, 2130846255, 2130846242, 2130846243, 2130846239, 2130846240, 2130846294, 2130846295, 2130846277, 2130846278, 2130846284, 2130846285, 2130846258, 2130846259, 2130846260, 2130846261, 2130846320, 2130846321, 2130846267, 2130846268, 2130846252, 2130846253, 2130843616, 2130843618, 2130843621, 2130843620, 2130844423, 2130844424, 2130842608, 2130846322, 2130846323, 2130839080, 2130839303, 2130839336, 2130846262, 2130846263, 2130846246, 2130846247, 2130842609, 2130842619, 2130842604, 2130842610, 2130842606, 2130846290, 2130846291, 2130846658, 2130846901, 2130839085, 2130842592, 2130846339, 2130843120, 2130846273, 2130846274, 2130846256, 2130846257, 2130846250, 2130846251, 2130846336, 2130846337, 2130846235, 2130846302, 2130846303, 2130846306, 2130846236, 2130846237, 2130846308, 2130846309, 2130846282, 2130846283, 2130844308, 2130850531, 2130850532, 2130846271, 2130846272, 2130846280, 2130846281, 2130846304, 2130846305, 2130849507, 2130846340, 2130849506, 2130846279, 2130840264, 2130849700, 2130849701, 2130840147, 2130841241, 2130841242, 2130841253, 2130846276, 2130841254, 2130841255, 2130841256, 2130841257, 2130846342, 2130846321, 2130846312, 2130846313, 2130846286, 2130846287, 2130841243, 2130841244, 2130841248, 2130841249, 2130841245, 2130841246, 2130841251, 2130841252, 2130842601, 2130847861, 2130847858, 2130847856, 2130847855, 2130847854, 2130847847, 2130847848, 2130847845, 2130847846, 2130847859, 2130847849, 2130846300, 2130846301, 2130847857, 2130847860, 2130848421, 2130847844, 2130847851, 2130848424, 2130848420, 2130846310, 2130846311, 2130842601, 2130841793, 2130841791, 2130841795, 2130841796, 2130841803, 2130841809, 2130841799, 2130841800, 2130841805, 2130841806, 2130840148, 2130844233, 2130837578, 2130837579, 2130840139, 2130844229, 2130844242, 2130844243, 2130844231, 2130844232, 2130844234, 2130844235, 2130844206, 2130844207, 2130844202, 2130844203, 2130844208, 2130844209, 2130844227, 2130844228, 2130840190, 2130840191, 2130840186, 2130840187, 2130849485, 2130849484, 2130849499, 2130849498, 2130849481, 2130849480, 2130849505, 2130849504, 2130849493, 2130849492, 2130849497, 2130849496, 2130849489, 2130849488, 2130849495, 2130849494, 2130840901, 2130840902, 2130843910, 2130843911, 2130849494, 2130849483, 2130849482, 2130849501, 2130849500, 2130849487, 2130849486, 2130849503, 2130849502, 2130849491, 2130849490, 2130849479, 2130849478, 2130846300, 2130846301, 2130843527, 2130843526, 2130843529, 2130843528, 2130843531, 2130843530, 2130843535, 2130843534, 2130843537, 2130843536, 2130843525, 2130843524, 2130843533, 2130843532, 2130849256, 2130844033, 2130844032 };
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
    b = new int[] { 2131717953, 2131717974, 2131717975, 2131717904, 2131717905, 2131717906, 2131717944, 2131717979, 2131718004, 2131717950, 2131718001, 2131718002, 2131718003, 2131717992, 2131717903, 2131717958, 2131717973, 2131717952, 2131717954, 2131717997, 2131717912, 2131717956, 2131717985, 2131717983, 2131717984, 2131717913, 2131717976, 2131717923, 2131717980, 2131717915, 2131717914, 2131717920, 2131717918, 2131717921, 2131717919, 2131717922, 2131717934, 2131717929, 2131717930, 2131717902, 2131717917, 2131717959, 2131717982, 2131717916, 2131717986, 2131717931, 2131717907, 2131717911, 2131717910, 2131717908, 2131717996, 2131717977, 2131717957, 2131717927, 2131717928, 2131717948, 2131717949, 2131717981, 2131717961, 2131717932, 2131717933, 2131696516, 2131696519, 2131696522, 2131696521, 2131695700, 2131694650, 2131717994, 2131717946, 2131717945, 2131717947, 2131717942, 2131717995, 2131718000, 2131717962, 2131717909, 2131717938, 2131717951, 2131717937, 2131717989, 2131717990, 2131717993, 2131717988, 2131717998, 2131717978, 2131717955, 2131717924, 2131717935, 2131717999, 2131717960, 2131717926, 2131717987, 2131694650, 2131717964, 2131717963, 2131717965, 2131717966, 2131717969, 2131717972, 2131717967, 2131717968, 2131717970, 2131717971, 2131717940, 2131717939, 2131717941, 2131697393, 2131717971, 2131717962, 2131717909, 2131717971, 2131717880, 2131717901, 2131717883, 2131717889, 2131717900, 2131717882, 2131717886, 2131717881, 2131717887, 2131717886, 2131717884, 2131717890, 2131717892, 2131717885, 2131717879, 2131717891, 2131717943, 2131717893, 2131717894, 2131717896, 2131717897, 2131717899, 2131717898, 2131717895 };
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
    return a(2130847854, 2131717951, "open_aio");
  }
  
  private static ActionSheetItem B()
  {
    return a(2130847846, 2131717938, "Evernote");
  }
  
  private static ActionSheetItem C()
  {
    return a(2130848421, 2131717935, "delete");
  }
  
  private static ActionSheetItem D()
  {
    int i = 2130846284;
    if (bkpg.a()) {
      i = 2130846285;
    }
    return a(i, 2131695720, "check_profile");
  }
  
  private static ActionSheetItem E()
  {
    int i = 2130849256;
    if (bkpg.a()) {
      i = 2130849257;
    }
    return a(i, 2131718000, "orignal");
  }
  
  private static ActionSheetItem F()
  {
    return a(2130847860, 2131717995, "unfollow");
  }
  
  private static ActionSheetItem G()
  {
    return a(2130847857, 2131717942, "follow");
  }
  
  private static ActionSheetItem H()
  {
    return a(2130847849, 2131717947, "hide_him");
  }
  
  private static ActionSheetItem I()
  {
    int i = 2130846300;
    if (bkpg.a()) {
      i = 2130846301;
    }
    return a(i, 2131717946, "hide_this_feed");
  }
  
  private static ActionSheetItem J()
  {
    int i = 2130846300;
    if (bkpg.a()) {
      i = 2130846301;
    }
    return a(i, 2131717945, "hide_works");
  }
  
  private static ActionSheetItem K()
  {
    return a(2130847859, 2131717994, "collect_cancel");
  }
  
  private static ActionSheetItem L()
  {
    int i = 2130846280;
    if (bkpg.a()) {
      i = 2130846281;
    }
    return a(i, 2131717930, "colornote_cancel");
  }
  
  private static ActionSheetItem M()
  {
    int i = 2130844206;
    if (bkpg.a()) {
      i = 2130844207;
    }
    return a(i, 2131717940, "fav_group");
  }
  
  private static ActionSheetItem N()
  {
    int i = 2130844202;
    if (bkpg.a()) {
      i = 2130844203;
    }
    return a(i, 2131717939, "fav_detail");
  }
  
  private static ActionSheetItem O()
  {
    int i = 2130844208;
    if (bkpg.a()) {
      i = 2130844209;
    }
    return a(i, 2131717941, "fav_show_originalurl");
  }
  
  private static ActionSheetItem P()
  {
    int i = 2130841243;
    if (bkpg.a()) {
      i = 2130841244;
    }
    return a(i, 2131717923, "backtohome");
  }
  
  private static ActionSheetItem Q()
  {
    int i = 2130841248;
    if (bkpg.a()) {
      i = 2130841249;
    }
    return a(i, 2131717980, "restart_applet");
  }
  
  private static ActionSheetItem R()
  {
    int i = 2130841256;
    if (bkpg.a()) {
      i = 2130841257;
    }
    return a(i, 2131717976, "remove_my");
  }
  
  private static ActionSheetItem S()
  {
    int i = 2130841254;
    if (bkpg.a()) {
      i = 2130841255;
    }
    return a(i, 2131717913, "add_my");
  }
  
  private static ActionSheetItem T()
  {
    int i = 2130841241;
    if (bkpg.a()) {
      i = 2130841242;
    }
    return a(i, 2131717908, "about");
  }
  
  private static ActionSheetItem U()
  {
    int i = 2130841245;
    if (bkpg.a()) {
      i = 2130841246;
    }
    return a(i, 2131717919, "applet_closeperformance");
  }
  
  private static ActionSheetItem V()
  {
    int i = 2130841245;
    if (bkpg.a()) {
      i = 2130841246;
    }
    return a(i, 2131717921, "applet_openperformance");
  }
  
  private static ActionSheetItem W()
  {
    int i = 2130841245;
    if (bkpg.a()) {
      i = 2130841246;
    }
    return a(i, 2131717918, "applet_closedebug");
  }
  
  private static ActionSheetItem X()
  {
    int i = 2130841245;
    if (bkpg.a()) {
      i = 2130841246;
    }
    return a(i, 2131717920, "applet_opendebug");
  }
  
  private static ActionSheetItem Y()
  {
    int i = 2130846304;
    if (bkpg.a()) {
      i = 2130846305;
    }
    return a(i, 2131717952, "long_screenshot");
  }
  
  private static ActionSheetItem Z()
  {
    int i = 2130846271;
    if (bkpg.a()) {
      i = 2130846272;
    }
    return a(i, 2131717929, "colornote");
  }
  
  private static ActionSheetItem a()
  {
    int i = 2130850770;
    if (bkpg.a()) {
      i = 2130850771;
    }
    return a(i, 2131717936, "download");
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
    int i = 2130846320;
    if (bkpg.a()) {
      i = 2130846321;
    }
    return a(i, 2131717977, "report");
  }
  
  private static ActionSheetItem aB()
  {
    int i = 2130846286;
    if (bkpg.a()) {
      i = 2130846287;
    }
    return a(i, 2131717957, "open_barrage");
  }
  
  private static ActionSheetItem aC()
  {
    int i = 2130846312;
    if (bkpg.a()) {
      i = 2130846313;
    }
    return a(i, 2131717927, "close_barrage");
  }
  
  private static ActionSheetItem aD()
  {
    int i = 2130846260;
    if (bkpg.a()) {
      i = 2130846261;
    }
    return a(i, 2131718002, "wechat_");
  }
  
  private static ActionSheetItem aE()
  {
    int i = 2130846258;
    if (bkpg.a()) {
      i = 2130846259;
    }
    return a(i, 2131718001, "wechat");
  }
  
  private static ActionSheetItem aF()
  {
    int i = 2130846277;
    if (bkpg.a()) {
      i = 2130846278;
    }
    return a(i, 2131717916, "adjust_font");
  }
  
  private static ActionSheetItem aG()
  {
    int i = 2130846294;
    if (bkpg.a()) {
      i = 2130846295;
    }
    return a(i, 2131717928, "collect");
  }
  
  private static ActionSheetItem aH()
  {
    int i = 2130846239;
    if (bkpg.a()) {
      i = 2130846240;
    }
    return a(i, 2131717903, "Qbrowser");
  }
  
  private static ActionSheetItem aI()
  {
    int i = 2130846242;
    if (bkpg.a()) {
      i = 2130846243;
    }
    return a(i, 2131717992, "browser");
  }
  
  private static ActionSheetItem aJ()
  {
    int i = 2130846254;
    if (bkpg.a()) {
      i = 2130846255;
    }
    return a(i, 2131717905, "Qzone");
  }
  
  private static ActionSheetItem aK()
  {
    int i = 2130846248;
    if (bkpg.a()) {
      i = 2130846249;
    }
    return a(i, 2131717904, "Qfriend");
  }
  
  private static ActionSheetItem aL()
  {
    int i = 2130846288;
    if (bkpg.a()) {
      i = 2130846289;
    }
    return a(i, 2131717931, "copy_link");
  }
  
  private static ActionSheetItem aM()
  {
    int i = 2130840148;
    if (bkpg.a()) {
      i = 2130844233;
    }
    return a(i, 2131717948, "Import_reader");
  }
  
  private static ActionSheetItem aN()
  {
    int i = 2130837578;
    if (bkpg.a()) {
      i = 2130837579;
    }
    return a(i, 2131717949, "edit_online");
  }
  
  private static ActionSheetItem aO()
  {
    int i = 2130840139;
    if (bkpg.a()) {
      i = 2130844229;
    }
    return a(i, 2131717981, "safe_share");
  }
  
  private static ActionSheetItem aP()
  {
    int i = 2130844242;
    if (bkpg.a()) {
      i = 2130844243;
    }
    return a(i, 2131717961, "print");
  }
  
  private static ActionSheetItem aQ()
  {
    int i = 2130844231;
    if (bkpg.a()) {
      i = 2130844232;
    }
    return a(i, 2131717932, "generate_link");
  }
  
  private static ActionSheetItem aR()
  {
    int i = 2130844227;
    if (bkpg.a()) {
      i = 2130844228;
    }
    return a(i, 2131697393, "other_app");
  }
  
  private static ActionSheetItem aS()
  {
    int i = 2130844234;
    if (bkpg.a()) {
      i = 2130844235;
    }
    return a(i, 2131717933, "generate_QRcode");
  }
  
  private static ActionSheetItem aT()
  {
    int i = 2130840186;
    if (bkpg.a()) {
      i = 2130840187;
    }
    return a(i, 2131717962, "ad_promotion");
  }
  
  private static ActionSheetItem aU()
  {
    int i = 2130840190;
    if (bkpg.a()) {
      i = 2130840191;
    }
    return a(i, 2131717909, "ad_block");
  }
  
  private static ActionSheetItem aV()
  {
    if (bkpg.a()) {}
    for (int i = 2130849480;; i = 2130849481) {
      return a(i, 2131717880, "addto_section");
    }
  }
  
  private static ActionSheetItem aW()
  {
    if (bkpg.a()) {}
    for (int i = 2130849498;; i = 2130849499) {
      return a(i, 2131717889, "delete_section");
    }
  }
  
  private static ActionSheetItem aX()
  {
    if (bkpg.a()) {}
    for (int i = 2130849484;; i = 2130849485) {
      return a(i, 2131717883, "delete_from_section");
    }
  }
  
  private static ActionSheetItem aY()
  {
    if (bkpg.a()) {}
    for (int i = 2130849504;; i = 2130849505) {
      return a(i, 2131717901, "kouling_share");
    }
  }
  
  private static ActionSheetItem aZ()
  {
    if (bkpg.a()) {}
    for (int i = 2130849492;; i = 2130849493) {
      return a(i, 2131717900, "play_feedback");
    }
  }
  
  private static ActionSheetItem aa()
  {
    int i = 2130850531;
    if (bkpg.a()) {
      i = 2130850532;
    }
    return a(i, 2131717997, "url_to_txdoc");
  }
  
  private static ActionSheetItem ab()
  {
    int i = 2130846282;
    if (bkpg.a()) {
      i = 2130846283;
    }
    return a(i, 2131717985, "search_emotion");
  }
  
  private static ActionSheetItem ac()
  {
    int i = 2130846308;
    if (bkpg.a()) {
      i = 2130846309;
    }
    return a(i, 2131717958, "other_app");
  }
  
  private static ActionSheetItem ad()
  {
    int i = 2130846306;
    if (bkpg.a()) {
      i = 2130846307;
    }
    return a(i, 2131717983, "scan_appletcode");
  }
  
  private static ActionSheetItem ae()
  {
    int i = 2130846322;
    if (bkpg.a()) {
      i = 2130846323;
    }
    return a(i, 2131717984, "scan_qrcode");
  }
  
  private static ActionSheetItem af()
  {
    int i = 2130846302;
    if (bkpg.a()) {
      i = 2130846303;
    }
    return a(i, 2131717917, "aio_position");
  }
  
  private static ActionSheetItem ag()
  {
    int i = 2130846336;
    if (bkpg.a()) {
      i = 2130846337;
    }
    return a(i, 2131717959, "pick_words");
  }
  
  private static ActionSheetItem ah()
  {
    int i = 2130846250;
    if (bkpg.a()) {
      i = 2130846251;
    }
    return a(i, 2131717944, "group_album");
  }
  
  private static ActionSheetItem ai()
  {
    int i = 2130846256;
    if (bkpg.a()) {
      i = 2130846257;
    }
    return a(i, 2131717906, "Qzone_album");
  }
  
  private static ActionSheetItem aj()
  {
    int i = 2130846273;
    if (bkpg.a()) {
      i = 2130846274;
    }
    return a(i, 2131717911, "add_emotion");
  }
  
  private static ActionSheetItem ak()
  {
    int i = 2130841251;
    if (bkpg.a()) {
      i = 2130841252;
    }
    return a(i, 2131717973, "push_setup");
  }
  
  private static ActionSheetItem al()
  {
    int i = 2130846339;
    if (bkpg.a()) {
      i = 2130846340;
    }
    return a(i, 2131717996, "uninterested");
  }
  
  private static ActionSheetItem am()
  {
    int i = 2130846290;
    if (bkpg.a()) {
      i = 2130846291;
    }
    return a(i, 2131717982, "save");
  }
  
  private static ActionSheetItem an()
  {
    int i = 2130849506;
    if (bkpg.a()) {
      i = 2130846279;
    }
    return a(i, 2131717954, "not_care");
  }
  
  private static ActionSheetItem ao()
  {
    if (bkpg.a()) {}
    return a(2130842609, 2131694598, "open_aio");
  }
  
  private static ActionSheetItem ap()
  {
    if (bkpg.a()) {}
    return a(2130842610, 2131717912, "add_friend");
  }
  
  private static ActionSheetItem aq()
  {
    if (bkpg.a()) {}
    return a(2130842609, 2131717956, "open_aio");
  }
  
  private static ActionSheetItem ar()
  {
    int i = 2130846262;
    if (bkpg.a()) {
      i = 2130846263;
    }
    return a(i, 2131718004, "weiyun");
  }
  
  private static ActionSheetItem as()
  {
    int i = 2130846246;
    if (bkpg.a()) {
      i = 2130846247;
    }
    return a(i, 2131717986, "sent_pc");
  }
  
  private static ActionSheetItem at()
  {
    int i = 2130846322;
    if (bkpg.a()) {
      i = 2130846323;
    }
    return a(i, 2131717902, "QRcode");
  }
  
  private static ActionSheetItem au()
  {
    if (bkpg.a()) {}
    return a(2130842608, 2131717907, "Screenshot_share");
  }
  
  private static ActionSheetItem av()
  {
    if (bkpg.a()) {}
    return a(2130844424, 2131717975, "qiyeqq");
  }
  
  private static ActionSheetItem aw()
  {
    if (bkpg.a()) {}
    return a(2130844423, 2131717974, "qidian");
  }
  
  private static ActionSheetItem ax()
  {
    int i = 2130841253;
    if (bkpg.a()) {
      i = 2130846276;
    }
    return a(i, 2131717910, "add_desktop");
  }
  
  private static ActionSheetItem ay()
  {
    int i = 2130846252;
    if (bkpg.a()) {
      i = 2130846253;
    }
    return a(i, 2131717950, "kandian");
  }
  
  private static ActionSheetItem az()
  {
    int i = 2130846267;
    if (bkpg.a()) {
      i = 2130846268;
    }
    return a(i, 2131718003, "weibo");
  }
  
  private static ActionSheetItem b()
  {
    int i = 2130850768;
    if (bkpg.a()) {
      i = 2130850769;
    }
    return a(i, 2131717925, "carton_detail");
  }
  
  private static ActionSheetItem ba()
  {
    if (bkpg.a()) {}
    for (int i = 2130849496;; i = 2130849497) {
      return a(i, 2131717882, "delete_fans");
    }
  }
  
  private static ActionSheetItem bb()
  {
    if (bkpg.a()) {}
    for (int i = 2130849488;; i = 2130849489) {
      return a(i, 2131694650, "share_more");
    }
  }
  
  private static ActionSheetItem bc()
  {
    if (bkpg.a()) {}
    for (int i = 2130849494;; i = 2130849495) {
      return a(i, 2131717886, "private_chat");
    }
  }
  
  private static ActionSheetItem bd()
  {
    if (bkpg.a()) {}
    for (int i = 2130849494;; i = 2130849495) {
      return a(i, 2131717881, "copy_roomid");
    }
  }
  
  private static ActionSheetItem be()
  {
    if (bkpg.a()) {}
    for (int i = 2130840902;; i = 2130840901) {
      return a(i, 2131717915, "group_app");
    }
  }
  
  private static ActionSheetItem bf()
  {
    if (bkpg.a()) {}
    for (int i = 2130840902;; i = 2130840901) {
      return a(i, 2131717914, "add_to_group");
    }
  }
  
  private static ActionSheetItem bg()
  {
    if (bkpg.a()) {}
    for (int i = 2130843911;; i = 2130843910) {
      return a(i, 2131717887, "delete_launch");
    }
  }
  
  private static ActionSheetItem bh()
  {
    if (bkpg.a()) {}
    for (int i = 2130844033;; i = 2130844032) {
      return a(i, 2131717888, "qcircle_private_message");
    }
  }
  
  private static ActionSheetItem bi()
  {
    if (bkpg.a()) {}
    for (int i = 2130849500;; i = 2130849501) {
      return a(i, 2131717891, "store_manage");
    }
  }
  
  private static ActionSheetItem bj()
  {
    if (bkpg.a()) {}
    for (int i = 2130849486;; i = 2130849487) {
      return a(i, 2131717884, "fan_group_manage");
    }
  }
  
  private static ActionSheetItem bk()
  {
    if (bkpg.a()) {}
    for (int i = 2130849482;; i = 2130849483) {
      return a(i, 2131717890, "sharepicture");
    }
  }
  
  private static ActionSheetItem bl()
  {
    if (bkpg.a()) {}
    for (int i = 2130849502;; i = 2130849503) {
      return a(i, 2131717892, "Sync_zone");
    }
  }
  
  private static ActionSheetItem bm()
  {
    if (bkpg.a()) {}
    for (int i = 2130849490;; i = 2130849491) {
      return a(i, 2131717885, "orderlist");
    }
  }
  
  private static ActionSheetItem bn()
  {
    if (bkpg.a()) {}
    for (int i = 2130849478;; i = 2130849479) {
      return a(i, 2131717879, "adding goods");
    }
  }
  
  private static ActionSheetItem bo()
  {
    if (bkpg.a()) {}
    for (int i = 2130841252;; i = 2130841251) {
      return a(i, 2131717943, "follow_manage");
    }
  }
  
  private static ActionSheetItem bp()
  {
    if (bkpg.a()) {}
    for (int i = 2130843524;; i = 2130843525) {
      return a(i, 2131717893, "add_to_digest");
    }
  }
  
  private static ActionSheetItem bq()
  {
    if (bkpg.a()) {}
    for (int i = 2130843532;; i = 2130843533) {
      return a(i, 2131717894, "cancel_digest");
    }
  }
  
  private static ActionSheetItem br()
  {
    if (bkpg.a()) {}
    for (int i = 2130843536;; i = 2130843537) {
      return a(i, 2131717896, "interest");
    }
  }
  
  private static ActionSheetItem bs()
  {
    if (bkpg.a()) {}
    for (int i = 2130843528;; i = 2130843529) {
      return a(i, 2131717897, "look_owner");
    }
  }
  
  private static ActionSheetItem bt()
  {
    if (bkpg.a()) {}
    for (int i = 2130843530;; i = 2130843531) {
      return a(i, 2131717899, "push_topics");
    }
  }
  
  private static ActionSheetItem bu()
  {
    if (bkpg.a()) {}
    for (int i = 2130843534;; i = 2130843535) {
      return a(i, 2131717898, "pull_black");
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
      localActionSheetItem1 = a(2130840264, 2131717904, "");
      continue;
      localActionSheetItem1 = a(2130849700, 2131717953, "");
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
      localActionSheetItem1 = a(2130843616, 2131696516, "add_troop_app");
      continue;
      localActionSheetItem1 = a(2130843618, 2131696519, "open_app_detail");
      continue;
      localActionSheetItem1 = a(2130843621, 2131696522, "share_troop_app");
      continue;
      localActionSheetItem1 = a(2130843620, 2131696521, "refresh_troop_app_view");
      continue;
      localActionSheetItem1 = a(2130842604, 2131695700, "share_diandian");
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
    if (bkpg.a()) {}
    for (int i = 2130843526;; i = 2130843527) {
      return a(i, 2131717895, "feedback");
    }
  }
  
  private static ActionSheetItem c()
  {
    int i = 2130841793;
    if (bkpg.a()) {
      i = 2130841794;
    }
    return a(i, 2131717964, "book_detail");
  }
  
  private static ActionSheetItem d()
  {
    int i = 2130841791;
    if (bkpg.a()) {
      i = 2130841792;
    }
    return a(i, 2131717963, "add_shelf");
  }
  
  private static ActionSheetItem e()
  {
    int i = 2130841795;
    if (bkpg.a()) {
      i = 2130841798;
    }
    return a(i, 2131717965, "bookmark");
  }
  
  private static ActionSheetItem f()
  {
    int i = 2130841796;
    if (bkpg.a()) {
      i = 2130841797;
    }
    return a(i, 2131717966, "bookmark_cancel");
  }
  
  private static ActionSheetItem g()
  {
    int i = 2130841803;
    if (bkpg.a()) {
      i = 2130841804;
    }
    return a(i, 2131717969, "hide_opinion");
  }
  
  private static ActionSheetItem h()
  {
    int i = 2130841809;
    if (bkpg.a()) {
      i = 2130841810;
    }
    return a(i, 2131717972, "show_opinion");
  }
  
  private static ActionSheetItem i()
  {
    int i = 2130841799;
    if (bkpg.a()) {
      i = 2130841802;
    }
    return a(i, 2131717967, "continue_purchase");
  }
  
  private static ActionSheetItem j()
  {
    int i = 2130841800;
    if (bkpg.a()) {
      i = 2130841801;
    }
    return a(i, 2131717968, "continue_purchase_cancel");
  }
  
  private static ActionSheetItem k()
  {
    int i = 2130841805;
    if (bkpg.a()) {
      i = 2130841808;
    }
    return a(i, 2131717970, "privacy");
  }
  
  private static ActionSheetItem l()
  {
    int i = 2130841806;
    if (bkpg.a()) {
      i = 2130841807;
    }
    return a(i, 2131717971, "privacy_cancel");
  }
  
  private static ActionSheetItem m()
  {
    return a(2130848420, 2131717987, "set_background");
  }
  
  private static ActionSheetItem n()
  {
    return a(2130848424, 2131717926, "rec_face");
  }
  
  private static ActionSheetItem o()
  {
    return a(2130847851, 2131717960, "psapp");
  }
  
  private static ActionSheetItem p()
  {
    return a(2130847844, 2131717999, "watch_on_tv");
  }
  
  private static ActionSheetItem q()
  {
    return a(2130847847, 2131717924, "no_only_friend");
  }
  
  private static ActionSheetItem r()
  {
    int i = 2130846310;
    if (bkpg.a()) {
      i = 2130846311;
    }
    return a(i, 2131717955, "only_friend");
  }
  
  private static ActionSheetItem s()
  {
    return a(2130847848, 2131717978, "reprint_diary");
  }
  
  private static ActionSheetItem t()
  {
    return a(2130847848, 2131717979, "reprint_photo");
  }
  
  private static ActionSheetItem u()
  {
    return a(2130847855, 2131717998, "look_dress");
  }
  
  private static ActionSheetItem v()
  {
    return a(2130847855, 2131717988, "set_card");
  }
  
  private static ActionSheetItem w()
  {
    return a(2130847861, 2131717993, "unstick");
  }
  
  private static ActionSheetItem x()
  {
    return a(2130847858, 2131717990, "stick");
  }
  
  private static ActionSheetItem y()
  {
    return a(2130847856, 2131717989, "privacy");
  }
  
  private static ActionSheetItem z()
  {
    return a(2130847845, 2131717937, "edit");
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