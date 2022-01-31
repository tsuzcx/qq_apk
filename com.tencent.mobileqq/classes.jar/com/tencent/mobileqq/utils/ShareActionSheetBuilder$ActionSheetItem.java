package com.tencent.mobileqq.utils;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import bibv;
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
  public static final int ACTION_ADD_SHORTCUT = 14;
  public static final int ACTION_ADD_TROOP_APP = 15;
  public static final int ACTION_ADJUST_FONT_SIZE = 7;
  public static final int ACTION_CANCEL_ONLY_SEE_FRIEND = 103;
  public static final int ACTION_CARTON_DETAIL = 125;
  public static final int ACTION_CHANNEL_FACE2FACE_SHARE_TROOP = 24;
  public static final int ACTION_CHANNEL_QR_CODE = 23;
  public static final int ACTION_CHOOSE_FACE = 106;
  public static final int ACTION_COMIC_SWITCH_SECRET_MODE_ = 33;
  public static final int ACTION_COPYLINK = 1;
  public static final int ACTION_DELETE = 40;
  public static final int ACTION_DIRECT_SEND_TO_FRIEND = 41;
  public static final int ACTION_DIRECT_SEND_TO_STORY = 42;
  public static final int ACTION_DOWNLOAD = 124;
  public static final int ACTION_EDIT = 94;
  public static final int ACTION_EXPORT_TENCENT_DOCS = 68;
  public static final int ACTION_FILE_CREATE_LINK = 122;
  public static final int ACTION_FILE_CREATE_QR = 123;
  public static final int ACTION_FILE_IMPORT_READER = 118;
  public static final int ACTION_FILE_IMPORT_TXDOC = 119;
  public static final int ACTION_FILE_PRINT = 121;
  public static final int ACTION_FILE_SAFE_FORWARD = 120;
  public static final int ACTION_FOLLOW = 87;
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
  public static final int ACTION_OPEN_IN_QQ_BROWSER = 5;
  public static final int ACTION_OPEN_IN_SYS_BROWSER = 4;
  public static final int ACTION_OPEN_WEISHI_ACCOUNT = 45;
  public static final int ACTION_PA_REPORT = 36;
  public static final int ACTION_PITU = 105;
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
  public static final int ACTION_REFRESH_TROOP_APP_VIEW = 18;
  public static final int ACTION_REMOVE_COLOR_NOTE = 82;
  public static final int ACTION_REMOVE_FAVORITE = 84;
  public static final int ACTION_REPORT = 11;
  public static final int ACTION_REPORT_DIS_LIKE = 44;
  public static final int ACTION_REPORT_VIDEO_NOT_LIKE = 22;
  public static final int ACTION_REPRINT_BLOG = 101;
  public static final int ACTION_REPRINT_PHOTO = 100;
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
  public static final int ACTION_SET_PRIVATE = 95;
  public static final int ACTION_SET_TOP = 96;
  public static final int ACTION_SHARE_TROOP_APP = 17;
  public static final int ACTION_SHOW_MORE_INFO = 31;
  public static final int ACTION_TAKE_SCREEN_SHOT = 21;
  public static final int ACTION_UNFOLLOW = 32;
  public static final int ACTION_UN_SET_TOP = 97;
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
    jdField_a_of_type_ArrayOfInt = new int[] { 2130845851, 2130845852, 2130845813, 2130845814, 2130845819, 2130845820, 2130845807, 2130845808, 2130845804, 2130845805, 2130845857, 2130845858, 2130845842, 2130845843, 2130845849, 2130845850, 2130845823, 2130845824, 2130845825, 2130845826, 2130845881, 2130845882, 2130845832, 2130845833, 2130845817, 2130845818, 2130843255, 2130843257, 2130843260, 2130843259, 2130844026, 2130844027, 2130842298, 2130845883, 2130845884, 2130838914, 2130839128, 2130839161, 2130845827, 2130845828, 2130845811, 2130845812, 2130842299, 2130842309, 2130842294, 2130842300, 2130842296, 2130845853, 2130845854, 2130846219, 2130846463, 2130838919, 2130842282, 2130845900, 2130842778, 2130845838, 2130845839, 2130845821, 2130845822, 2130845815, 2130845816, 2130845897, 2130845898, 2130845800, 2130845865, 2130845866, 2130845869, 2130845801, 2130845802, 2130845871, 2130845872, 2130845847, 2130845848, 2130843917, 2130849939, 2130849940, 2130845836, 2130845837, 2130845845, 2130845846, 2130845867, 2130845868, 2130840085, 2130849151, 2130849152, 2130839741, 2130840991, 2130840992, 2130841003, 2130845841, 2130841004, 2130841005, 2130841006, 2130841007, 2130845903, 2130845882, 2130840993, 2130840994, 2130840998, 2130840999, 2130840995, 2130840996, 2130841001, 2130841002, 2130842291, 2130847402, 2130847399, 2130847397, 2130847396, 2130847395, 2130847388, 2130847389, 2130847386, 2130847387, 2130847400, 2130847390, 2130847398, 2130847401, 2130847945, 2130847385, 2130847392, 2130847948, 2130847944, 2130845873, 2130845874, 2130842291, 2130841478, 2130841476, 2130841480, 2130841481, 2130841488, 2130841494, 2130841484, 2130841485, 2130841490, 2130841491, 2130839742, 2130843845, 2130837566, 2130837567, 2130839733, 2130843841, 2130843854, 2130843855, 2130843843, 2130843844, 2130843846, 2130843847 };
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
    b = new int[] { 2131719978, 2131719998, 2131719999, 2131719937, 2131719938, 2131719939, 2131719970, 2131720003, 2131720028, 2131719975, 2131720025, 2131720026, 2131720027, 2131720016, 2131719936, 2131719982, 2131719997, 2131719977, 2131719979, 2131720021, 2131719945, 2131719981, 2131720009, 2131720007, 2131720008, 2131719946, 2131720000, 2131719954, 2131720004, 2131719951, 2131719949, 2131719952, 2131719950, 2131719953, 2131719964, 2131719959, 2131719960, 2131719935, 2131719948, 2131719983, 2131720006, 2131719947, 2131720010, 2131719961, 2131719940, 2131719944, 2131719943, 2131719941, 2131720020, 2131720001, 2131719958, 2131719973, 2131719974, 2131720005, 2131719985, 2131719962, 2131719963, 2131697674, 2131697677, 2131697680, 2131697679, 2131696878, 2131695767, 2131720018, 2131719971, 2131719972, 2131719969, 2131720019, 2131720024, 2131719986, 2131719942, 2131719968, 2131719976, 2131719967, 2131720013, 2131720014, 2131720017, 2131720012, 2131720022, 2131720002, 2131719980, 2131719955, 2131719965, 2131720023, 2131719984, 2131719957, 2131720011, 2131695767, 2131719988, 2131719987, 2131719989, 2131719990, 2131719993, 2131719996, 2131719991, 2131719992, 2131719994, 2131719995 };
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
    return a(2130847395, 2131719976, "open_aio");
  }
  
  private static ActionSheetItem B()
  {
    return a(2130847387, 2131719968, "Evernote");
  }
  
  private static ActionSheetItem C()
  {
    return a(2130847945, 2131719965, "delete");
  }
  
  private static ActionSheetItem D()
  {
    int i = 2130845849;
    if (bibv.a()) {
      i = 2130845850;
    }
    return a(i, 2131696898, "check_profile");
  }
  
  private static ActionSheetItem E()
  {
    int i = 2130848778;
    if (bibv.a()) {
      i = 2130848779;
    }
    return a(i, 2131720024, "orignal");
  }
  
  private static ActionSheetItem F()
  {
    return a(2130847401, 2131720019, "unfollow");
  }
  
  private static ActionSheetItem G()
  {
    return a(2130847398, 2131719969, "follow");
  }
  
  private static ActionSheetItem H()
  {
    return a(2130847390, 2131719972, "hide_him");
  }
  
  private static ActionSheetItem I()
  {
    int i = 2130845863;
    if (bibv.a()) {
      i = 2130845864;
    }
    return a(i, 2131719971, "hide_this_feed");
  }
  
  private static ActionSheetItem J()
  {
    return a(2130847400, 2131720018, "collect_cancel");
  }
  
  private static ActionSheetItem K()
  {
    int i = 2130845845;
    if (bibv.a()) {
      i = 2130845846;
    }
    return a(i, 2131719960, "colornote_cancel");
  }
  
  private static ActionSheetItem L()
  {
    int i = 2130840993;
    if (bibv.a()) {
      i = 2130840994;
    }
    return a(i, 2131719954, "backtohome");
  }
  
  private static ActionSheetItem M()
  {
    int i = 2130840998;
    if (bibv.a()) {
      i = 2130840999;
    }
    return a(i, 2131720004, "restart_applet");
  }
  
  private static ActionSheetItem N()
  {
    int i = 2130841006;
    if (bibv.a()) {
      i = 2130841007;
    }
    return a(i, 2131720000, "remove_my");
  }
  
  private static ActionSheetItem O()
  {
    int i = 2130841004;
    if (bibv.a()) {
      i = 2130841005;
    }
    return a(i, 2131719946, "add_my");
  }
  
  private static ActionSheetItem P()
  {
    int i = 2130840991;
    if (bibv.a()) {
      i = 2130840992;
    }
    return a(i, 2131719941, "about");
  }
  
  private static ActionSheetItem Q()
  {
    int i = 2130840995;
    if (bibv.a()) {
      i = 2130840996;
    }
    return a(i, 2131719950, "applet_closeperformance");
  }
  
  private static ActionSheetItem R()
  {
    int i = 2130840995;
    if (bibv.a()) {
      i = 2130840996;
    }
    return a(i, 2131719952, "applet_openperformance");
  }
  
  private static ActionSheetItem S()
  {
    int i = 2130840995;
    if (bibv.a()) {
      i = 2130840996;
    }
    return a(i, 2131719949, "applet_closedebug");
  }
  
  private static ActionSheetItem T()
  {
    int i = 2130840995;
    if (bibv.a()) {
      i = 2130840996;
    }
    return a(i, 2131719951, "applet_opendebug");
  }
  
  private static ActionSheetItem U()
  {
    int i = 2130845867;
    if (bibv.a()) {
      i = 2130845868;
    }
    return a(i, 2131719977, "long_screenshot");
  }
  
  private static ActionSheetItem V()
  {
    int i = 2130845836;
    if (bibv.a()) {
      i = 2130845837;
    }
    return a(i, 2131719959, "colornote");
  }
  
  private static ActionSheetItem W()
  {
    int i = 2130849939;
    if (bibv.a()) {
      i = 2130849940;
    }
    return a(i, 2131720021, "url_to_txdoc");
  }
  
  private static ActionSheetItem X()
  {
    int i = 2130845847;
    if (bibv.a()) {
      i = 2130845848;
    }
    return a(i, 2131720009, "search_emotion");
  }
  
  private static ActionSheetItem Y()
  {
    int i = 2130845871;
    if (bibv.a()) {
      i = 2130845872;
    }
    return a(i, 2131719982, "other_app");
  }
  
  private static ActionSheetItem Z()
  {
    int i = 2130845869;
    if (bibv.a()) {
      i = 2130845870;
    }
    return a(i, 2131720007, "scan_appletcode");
  }
  
  private static ActionSheetItem a()
  {
    int i = 2130850174;
    if (bibv.a()) {
      i = 2130850175;
    }
    return a(i, 2131719966, "download");
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
    int i = 2130845857;
    if (bibv.a()) {
      i = 2130845858;
    }
    return a(i, 2131719958, "collect");
  }
  
  private static ActionSheetItem aB()
  {
    int i = 2130845804;
    if (bibv.a()) {
      i = 2130845805;
    }
    return a(i, 2131719936, "Qbrowser");
  }
  
  private static ActionSheetItem aC()
  {
    int i = 2130845807;
    if (bibv.a()) {
      i = 2130845808;
    }
    return a(i, 2131720016, "browser");
  }
  
  private static ActionSheetItem aD()
  {
    int i = 2130845819;
    if (bibv.a()) {
      i = 2130845820;
    }
    return a(i, 2131719938, "Qzone");
  }
  
  private static ActionSheetItem aE()
  {
    int i = 2130845813;
    if (bibv.a()) {
      i = 2130845814;
    }
    return a(i, 2131719937, "Qfriend");
  }
  
  private static ActionSheetItem aF()
  {
    int i = 2130845851;
    if (bibv.a()) {
      i = 2130845852;
    }
    return a(i, 2131719961, "copy_link");
  }
  
  private static ActionSheetItem aG()
  {
    int i = 2130839742;
    if (bibv.a()) {
      i = 2130843845;
    }
    return a(i, 2131719973, "Import_reader");
  }
  
  private static ActionSheetItem aH()
  {
    int i = 2130837566;
    if (bibv.a()) {
      i = 2130837567;
    }
    return a(i, 2131719974, "edit_online");
  }
  
  private static ActionSheetItem aI()
  {
    int i = 2130839733;
    if (bibv.a()) {
      i = 2130843841;
    }
    return a(i, 2131720005, "safe_share");
  }
  
  private static ActionSheetItem aJ()
  {
    int i = 2130843854;
    if (bibv.a()) {
      i = 2130843855;
    }
    return a(i, 2131719985, "print");
  }
  
  private static ActionSheetItem aK()
  {
    int i = 2130843843;
    if (bibv.a()) {
      i = 2130843844;
    }
    return a(i, 2131719962, "generate_link");
  }
  
  private static ActionSheetItem aL()
  {
    int i = 2130843846;
    if (bibv.a()) {
      i = 2130843847;
    }
    return a(i, 2131719963, "generate_QRcode");
  }
  
  private static ActionSheetItem aa()
  {
    int i = 2130845883;
    if (bibv.a()) {
      i = 2130845884;
    }
    return a(i, 2131720008, "scan_qrcode");
  }
  
  private static ActionSheetItem ab()
  {
    int i = 2130845865;
    if (bibv.a()) {
      i = 2130845866;
    }
    return a(i, 2131719948, "aio_position");
  }
  
  private static ActionSheetItem ac()
  {
    int i = 2130845897;
    if (bibv.a()) {
      i = 2130845898;
    }
    return a(i, 2131719983, "pick_words");
  }
  
  private static ActionSheetItem ad()
  {
    int i = 2130845815;
    if (bibv.a()) {
      i = 2130845816;
    }
    return a(i, 2131719970, "group_album");
  }
  
  private static ActionSheetItem ae()
  {
    int i = 2130845821;
    if (bibv.a()) {
      i = 2130845822;
    }
    return a(i, 2131719939, "Qzone_album");
  }
  
  private static ActionSheetItem af()
  {
    int i = 2130845838;
    if (bibv.a()) {
      i = 2130845839;
    }
    return a(i, 2131719944, "add_emotion");
  }
  
  private static ActionSheetItem ag()
  {
    int i = 2130841001;
    if (bibv.a()) {
      i = 2130841002;
    }
    return a(i, 2131719997, "push_setup");
  }
  
  private static ActionSheetItem ah()
  {
    int i = 2130845900;
    if (bibv.a()) {
      i = 2130845901;
    }
    return a(i, 2131720020, "uninterested");
  }
  
  private static ActionSheetItem ai()
  {
    int i = 2130845853;
    if (bibv.a()) {
      i = 2130845854;
    }
    return a(i, 2131720006, "save");
  }
  
  private static ActionSheetItem aj()
  {
    if (bibv.a()) {}
    return a(2130842296, 2131719979, "not_care");
  }
  
  private static ActionSheetItem ak()
  {
    if (bibv.a()) {}
    return a(2130842299, 2131695706, "open_aio");
  }
  
  private static ActionSheetItem al()
  {
    if (bibv.a()) {}
    return a(2130842300, 2131719945, "add_friend");
  }
  
  private static ActionSheetItem am()
  {
    if (bibv.a()) {}
    return a(2130842299, 2131719981, "open_aio");
  }
  
  private static ActionSheetItem an()
  {
    int i = 2130845827;
    if (bibv.a()) {
      i = 2130845828;
    }
    return a(i, 2131720028, "weiyun");
  }
  
  private static ActionSheetItem ao()
  {
    int i = 2130845811;
    if (bibv.a()) {
      i = 2130845812;
    }
    return a(i, 2131720010, "sent_pc");
  }
  
  private static ActionSheetItem ap()
  {
    int i = 2130845883;
    if (bibv.a()) {
      i = 2130845884;
    }
    return a(i, 2131719935, "QRcode");
  }
  
  private static ActionSheetItem aq()
  {
    if (bibv.a()) {}
    return a(2130842298, 2131719940, "Screenshot_share");
  }
  
  private static ActionSheetItem ar()
  {
    if (bibv.a()) {}
    return a(2130844027, 2131719999, "qiyeqq");
  }
  
  private static ActionSheetItem as()
  {
    if (bibv.a()) {}
    return a(2130844026, 2131719998, "qidian");
  }
  
  private static ActionSheetItem at()
  {
    int i = 2130841003;
    if (bibv.a()) {
      i = 2130845841;
    }
    return a(i, 2131719943, "add_desktop");
  }
  
  private static ActionSheetItem au()
  {
    int i = 2130845817;
    if (bibv.a()) {
      i = 2130845818;
    }
    return a(i, 2131719975, "kandian");
  }
  
  private static ActionSheetItem av()
  {
    int i = 2130845832;
    if (bibv.a()) {
      i = 2130845833;
    }
    return a(i, 2131720027, "weibo");
  }
  
  private static ActionSheetItem aw()
  {
    int i = 2130845881;
    if (bibv.a()) {
      i = 2130845882;
    }
    return a(i, 2131720001, "report");
  }
  
  private static ActionSheetItem ax()
  {
    int i = 2130845825;
    if (bibv.a()) {
      i = 2130845826;
    }
    return a(i, 2131720026, "wechat_");
  }
  
  private static ActionSheetItem ay()
  {
    int i = 2130845823;
    if (bibv.a()) {
      i = 2130845824;
    }
    return a(i, 2131720025, "wechat");
  }
  
  private static ActionSheetItem az()
  {
    int i = 2130845842;
    if (bibv.a()) {
      i = 2130845843;
    }
    return a(i, 2131719947, "adjust_font");
  }
  
  private static ActionSheetItem b()
  {
    int i = 2130850172;
    if (bibv.a()) {
      i = 2130850173;
    }
    return a(i, 2131719956, "carton_detail");
  }
  
  public static ActionSheetItem build(int paramInt)
  {
    ActionSheetItem localActionSheetItem1;
    switch (paramInt)
    {
    case 22: 
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
    case 89: 
    case 90: 
    case 93: 
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
      localActionSheetItem1 = aF();
      continue;
      localActionSheetItem1 = aE();
      continue;
      localActionSheetItem1 = aD();
      continue;
      localActionSheetItem1 = aC();
      continue;
      localActionSheetItem1 = aB();
      continue;
      localActionSheetItem1 = aA();
      continue;
      localActionSheetItem1 = az();
      continue;
      localActionSheetItem1 = D();
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
      localActionSheetItem1 = aa();
      continue;
      localActionSheetItem1 = Z();
      continue;
      localActionSheetItem1 = Y();
      continue;
      localActionSheetItem1 = X();
      continue;
      localActionSheetItem1 = aw();
      continue;
      localActionSheetItem1 = W();
      continue;
      localActionSheetItem1 = V();
      continue;
      localActionSheetItem1 = U();
      continue;
      localActionSheetItem1 = a(2130840085, 2131719937, "");
      continue;
      localActionSheetItem1 = a(2130849151, 2131719978, "");
      continue;
      localActionSheetItem1 = T();
      continue;
      localActionSheetItem1 = S();
      continue;
      localActionSheetItem1 = R();
      continue;
      localActionSheetItem1 = Q();
      continue;
      localActionSheetItem1 = P();
      continue;
      localActionSheetItem1 = O();
      continue;
      localActionSheetItem1 = N();
      continue;
      localActionSheetItem1 = L();
      continue;
      localActionSheetItem1 = K();
      continue;
      localActionSheetItem1 = aG();
      continue;
      localActionSheetItem1 = aH();
      continue;
      localActionSheetItem1 = aI();
      continue;
      localActionSheetItem1 = aJ();
      continue;
      localActionSheetItem1 = aK();
      continue;
      localActionSheetItem1 = aL();
      continue;
      localActionSheetItem1 = a(2130843255, 2131697674, "add_troop_app");
      continue;
      localActionSheetItem1 = a(2130843257, 2131697677, "open_app_detail");
      continue;
      localActionSheetItem1 = a(2130843260, 2131697680, "share_troop_app");
      continue;
      localActionSheetItem1 = a(2130843259, 2131697679, "refresh_troop_app_view");
      continue;
      localActionSheetItem1 = a(2130842294, 2131696878, "share_diandian");
      continue;
      localActionSheetItem1 = a(2130842291, 2131695767, "share_more");
      continue;
      localActionSheetItem1 = J();
      continue;
      localActionSheetItem1 = I();
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
      localActionSheetItem1 = M();
    }
  }
  
  private static ActionSheetItem c()
  {
    int i = 2130841478;
    if (bibv.a()) {
      i = 2130841479;
    }
    return a(i, 2131719988, "book_detail");
  }
  
  private static ActionSheetItem d()
  {
    int i = 2130841476;
    if (bibv.a()) {
      i = 2130841477;
    }
    return a(i, 2131719987, "add_shelf");
  }
  
  private static ActionSheetItem e()
  {
    int i = 2130841480;
    if (bibv.a()) {
      i = 2130841483;
    }
    return a(i, 2131719989, "bookmark");
  }
  
  private static ActionSheetItem f()
  {
    int i = 2130841481;
    if (bibv.a()) {
      i = 2130841482;
    }
    return a(i, 2131719990, "bookmark_cancel");
  }
  
  private static ActionSheetItem g()
  {
    int i = 2130841488;
    if (bibv.a()) {
      i = 2130841489;
    }
    return a(i, 2131719993, "hide_opinion");
  }
  
  private static ActionSheetItem h()
  {
    int i = 2130841494;
    if (bibv.a()) {
      i = 2130841495;
    }
    return a(i, 2131719996, "show_opinion");
  }
  
  private static ActionSheetItem i()
  {
    int i = 2130841484;
    if (bibv.a()) {
      i = 2130841487;
    }
    return a(i, 2131719991, "continue_purchase");
  }
  
  private static ActionSheetItem j()
  {
    int i = 2130841485;
    if (bibv.a()) {
      i = 2130841486;
    }
    return a(i, 2131719992, "continue_purchase_cancel");
  }
  
  private static ActionSheetItem k()
  {
    int i = 2130841490;
    if (bibv.a()) {
      i = 2130841493;
    }
    return a(i, 2131719994, "privacy");
  }
  
  private static ActionSheetItem l()
  {
    int i = 2130841491;
    if (bibv.a()) {
      i = 2130841492;
    }
    return a(i, 2131719995, "privacy_cancel");
  }
  
  private static ActionSheetItem m()
  {
    return a(2130847944, 2131720011, "set_background");
  }
  
  private static ActionSheetItem n()
  {
    return a(2130847948, 2131719957, "rec_face");
  }
  
  private static ActionSheetItem o()
  {
    return a(2130847392, 2131719984, "psapp");
  }
  
  private static ActionSheetItem p()
  {
    return a(2130847385, 2131720023, "watch_on_tv");
  }
  
  private static ActionSheetItem q()
  {
    return a(2130847388, 2131719955, "no_only_friend");
  }
  
  private static ActionSheetItem r()
  {
    int i = 2130845873;
    if (bibv.a()) {
      i = 2130845874;
    }
    return a(i, 2131719980, "only_friend");
  }
  
  private static ActionSheetItem s()
  {
    return a(2130847389, 2131720002, "reprint_diary");
  }
  
  private static ActionSheetItem t()
  {
    return a(2130847389, 2131720003, "reprint_photo");
  }
  
  private static ActionSheetItem u()
  {
    return a(2130847396, 2131720022, "look_dress");
  }
  
  private static ActionSheetItem v()
  {
    return a(2130847396, 2131720012, "set_card");
  }
  
  private static ActionSheetItem w()
  {
    return a(2130847402, 2131720017, "unstick");
  }
  
  private static ActionSheetItem x()
  {
    return a(2130847399, 2131720014, "stick");
  }
  
  private static ActionSheetItem y()
  {
    return a(2130847397, 2131720013, "privacy");
  }
  
  private static ActionSheetItem z()
  {
    return a(2130847386, 2131719967, "edit");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem
 * JD-Core Version:    0.7.0.1
 */