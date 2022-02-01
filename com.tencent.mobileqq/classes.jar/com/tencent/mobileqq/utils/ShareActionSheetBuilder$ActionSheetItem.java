package com.tencent.mobileqq.utils;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.fileassistant.util.QFileAssistantUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ThemeImageWrapper;
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
  private static final int[] jdField_a_of_type_ArrayOfInt;
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
    int j = 0;
    jdField_a_of_type_ArrayOfInt = new int[] { 2130846662, 2130846663, 2130846622, 2130846623, 2130846628, 2130846629, 2130846614, 2130846615, 2130846611, 2130846612, 2130846668, 2130846669, 2130846651, 2130846652, 2130846658, 2130846659, 2130846632, 2130846633, 2130846634, 2130846635, 2130846694, 2130846695, 2130846641, 2130846642, 2130846626, 2130846627, 2130843905, 2130843907, 2130843910, 2130843909, 2130844579, 2130844580, 2130842842, 2130846696, 2130846697, 2130839211, 2130839444, 2130839477, 2130846636, 2130846637, 2130846618, 2130846619, 2130846620, 2130846621, 2130842843, 2130842853, 2130842838, 2130842844, 2130842840, 2130846664, 2130846665, 2130847022, 2130847265, 2130839216, 2130842826, 2130846714, 2130843400, 2130846647, 2130846648, 2130846630, 2130846631, 2130846624, 2130846625, 2130846711, 2130846712, 2130846607, 2130846676, 2130846677, 2130846680, 2130846608, 2130846609, 2130846682, 2130846683, 2130846656, 2130846657, 2130844464, 2130850998, 2130850999, 2130846645, 2130846646, 2130846654, 2130846655, 2130846678, 2130846679, 2130849898, 2130846715, 2130849897, 2130846653, 2130840452, 2130850117, 2130850118, 2130840307, 2130841433, 2130841434, 2130841443, 2130846650, 2130841444, 2130841445, 2130841446, 2130841447, 2130846717, 2130846695, 2130846686, 2130846687, 2130846660, 2130846661, 2130841435, 2130841436, 2130841439, 2130841440, 2130841437, 2130841438, 2130841441, 2130841442, 2130842835, 2130848238, 2130848235, 2130848233, 2130848232, 2130848231, 2130848224, 2130848225, 2130848222, 2130848223, 2130848236, 2130848226, 2130846674, 2130846675, 2130848234, 2130848237, 2130848799, 2130848221, 2130848228, 2130848802, 2130848798, 2130846684, 2130846685, 2130842835, 2130842003, 2130842001, 2130842005, 2130842006, 2130842013, 2130842019, 2130842009, 2130842010, 2130842015, 2130842016, 2130840308, 2130844389, 2130837578, 2130837579, 2130840299, 2130844385, 2130844398, 2130844399, 2130844387, 2130844388, 2130844390, 2130844391, 2130844354, 2130844355, 2130844350, 2130844351, 2130844356, 2130844357, 2130844383, 2130844384, 2130840375, 2130840376, 2130840371, 2130840372, 2130849876, 2130849875, 2130849890, 2130849889, 2130849872, 2130849871, 2130849896, 2130849895, 2130849884, 2130849883, 2130849888, 2130849887, 2130849880, 2130849879, 2130849886, 2130849885, 2130841117, 2130841118, 2130844194, 2130844195, 2130849885, 2130849874, 2130849873, 2130849892, 2130849891, 2130849878, 2130849877, 2130849894, 2130849893, 2130849882, 2130849881, 2130849870, 2130849869, 2130846674, 2130846675, 2130843815, 2130843814, 2130843817, 2130843816, 2130843819, 2130843818, 2130843823, 2130843822, 2130843825, 2130843824, 2130843813, 2130843812, 2130843821, 2130843820, 2130849658, 2130844233, 2130844232, 2130851290, 2130851291, 2130851288, 2130851289, 2130849733, 2130849734, 2130843428, 2130843427 };
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
    b = new int[] { 2131719237, 2131719258, 2131719259, 2131719187, 2131719188, 2131719189, 2131719228, 2131719263, 2131719288, 2131719207, 2131719285, 2131719286, 2131719287, 2131719276, 2131719186, 2131719242, 2131719257, 2131719236, 2131719238, 2131719281, 2131719195, 2131719240, 2131719269, 2131719267, 2131719268, 2131719196, 2131719260, 2131719206, 2131719264, 2131719198, 2131719197, 2131719203, 2131719201, 2131719204, 2131719202, 2131719205, 2131719218, 2131719213, 2131719214, 2131719185, 2131719200, 2131719243, 2131719266, 2131719199, 2131719270, 2131698224, 2131719215, 2131719190, 2131719194, 2131719193, 2131719191, 2131719280, 2131719261, 2131719241, 2131719211, 2131719212, 2131719232, 2131719233, 2131719265, 2131719245, 2131719216, 2131719217, 2131697221, 2131697224, 2131697227, 2131697226, 2131696385, 2131695255, 2131719278, 2131719230, 2131719229, 2131719231, 2131719226, 2131719279, 2131719284, 2131719246, 2131719192, 2131719222, 2131719235, 2131719221, 2131719273, 2131719274, 2131719277, 2131719272, 2131719282, 2131719262, 2131719239, 2131719208, 2131719219, 2131719283, 2131719244, 2131719210, 2131719271, 2131695255, 2131719248, 2131719247, 2131719249, 2131719250, 2131719253, 2131719256, 2131719251, 2131719252, 2131719254, 2131719255, 2131719224, 2131719223, 2131719225, 2131698156, 2131719255, 2131719246, 2131719192, 2131719255, 2131719163, 2131719184, 2131719166, 2131719172, 2131719183, 2131719165, 2131719169, 2131719164, 2131719170, 2131719169, 2131719167, 2131719173, 2131719175, 2131719168, 2131719162, 2131719174, 2131719227, 2131719176, 2131719177, 2131719179, 2131719180, 2131719182, 2131719181, 2131719178, 2131719209, 2131719220, 2131718615, 2131718614, 2131696406 };
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
    return a(2130848233, 2131719273, "privacy");
  }
  
  private static ActionSheetItem B()
  {
    return a(2130848222, 2131719221, "edit");
  }
  
  private static ActionSheetItem C()
  {
    return a(2130848231, 2131719235, "open_aio");
  }
  
  private static ActionSheetItem D()
  {
    return a(2130848223, 2131719222, "Evernote");
  }
  
  private static ActionSheetItem E()
  {
    return a(2130848799, 2131719219, "delete");
  }
  
  private static ActionSheetItem F()
  {
    int i = 2130846658;
    if (ThemeImageWrapper.isNightMode()) {
      i = 2130846659;
    }
    return a(i, 2131696406, "check_profile");
  }
  
  private static ActionSheetItem G()
  {
    int i = 2130849658;
    if (ThemeImageWrapper.isNightMode()) {
      i = 2130849659;
    }
    return a(i, 2131719284, "orignal");
  }
  
  private static ActionSheetItem H()
  {
    return a(2130848237, 2131719279, "unfollow");
  }
  
  private static ActionSheetItem I()
  {
    return a(2130848234, 2131719226, "follow");
  }
  
  private static ActionSheetItem J()
  {
    return a(2130848226, 2131719231, "hide_him");
  }
  
  private static ActionSheetItem K()
  {
    int i = 2130846674;
    if (ThemeImageWrapper.isNightMode()) {
      i = 2130846675;
    }
    return a(i, 2131719230, "hide_this_feed");
  }
  
  private static ActionSheetItem L()
  {
    int i = 2130846674;
    if (ThemeImageWrapper.isNightMode()) {
      i = 2130846675;
    }
    return a(i, 2131719229, "hide_works");
  }
  
  private static ActionSheetItem M()
  {
    return a(2130848236, 2131719278, "collect_cancel");
  }
  
  private static ActionSheetItem N()
  {
    int i = 2130846654;
    if (ThemeImageWrapper.isNightMode()) {
      i = 2130846655;
    }
    return a(i, 2131719214, "colornote_cancel");
  }
  
  private static ActionSheetItem O()
  {
    int i = 2130844354;
    if (ThemeImageWrapper.isNightMode()) {
      i = 2130844355;
    }
    return a(i, 2131719224, "fav_group");
  }
  
  private static ActionSheetItem P()
  {
    int i = 2130844350;
    if (ThemeImageWrapper.isNightMode()) {
      i = 2130844351;
    }
    return a(i, 2131719223, "fav_detail");
  }
  
  private static ActionSheetItem Q()
  {
    int i = 2130844356;
    if (ThemeImageWrapper.isNightMode()) {
      i = 2130844357;
    }
    return a(i, 2131719225, "fav_show_originalurl");
  }
  
  private static ActionSheetItem R()
  {
    int i = 2130841435;
    if (ThemeImageWrapper.isNightMode()) {
      i = 2130841436;
    }
    return a(i, 2131719206, "backtohome");
  }
  
  private static ActionSheetItem S()
  {
    int i = 2130841439;
    if (ThemeImageWrapper.isNightMode()) {
      i = 2130841440;
    }
    return a(i, 2131719264, "restart_applet");
  }
  
  private static ActionSheetItem T()
  {
    int i = 2130841446;
    if (ThemeImageWrapper.isNightMode()) {
      i = 2130841447;
    }
    return a(i, 2131719260, "remove_my");
  }
  
  private static ActionSheetItem U()
  {
    int i = 2130841444;
    if (ThemeImageWrapper.isNightMode()) {
      i = 2130841445;
    }
    return a(i, 2131719196, "add_my");
  }
  
  private static ActionSheetItem V()
  {
    int i = 2130841433;
    if (ThemeImageWrapper.isNightMode()) {
      i = 2130841434;
    }
    return a(i, 2131719191, "about");
  }
  
  private static ActionSheetItem W()
  {
    int i = 2130841437;
    if (ThemeImageWrapper.isNightMode()) {
      i = 2130841438;
    }
    return a(i, 2131719202, "applet_closeperformance");
  }
  
  private static ActionSheetItem X()
  {
    int i = 2130841437;
    if (ThemeImageWrapper.isNightMode()) {
      i = 2130841438;
    }
    return a(i, 2131719204, "applet_openperformance");
  }
  
  private static ActionSheetItem Y()
  {
    int i = 2130841437;
    if (ThemeImageWrapper.isNightMode()) {
      i = 2130841438;
    }
    return a(i, 2131719201, "applet_closedebug");
  }
  
  private static ActionSheetItem Z()
  {
    int i = 2130841437;
    if (ThemeImageWrapper.isNightMode()) {
      i = 2130841438;
    }
    return a(i, 2131719203, "applet_opendebug");
  }
  
  private static ActionSheetItem a()
  {
    return a(2130843428, 2131718615, "open_viola_barrage");
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
    int i = 2130849733;
    if (ThemeImageWrapper.isNightMode()) {
      i = 2130849734;
    }
    return a(i, 2131719207, "biu");
  }
  
  private static ActionSheetItem aB()
  {
    int i = 2130846641;
    if (ThemeImageWrapper.isNightMode()) {
      i = 2130846642;
    }
    return a(i, 2131719287, "weibo");
  }
  
  private static ActionSheetItem aC()
  {
    int i = 2130846694;
    if (ThemeImageWrapper.isNightMode()) {
      i = 2130846695;
    }
    return a(i, 2131719261, "report");
  }
  
  private static ActionSheetItem aD()
  {
    int i = 2130846686;
    if (ThemeImageWrapper.isNightMode()) {
      i = 2130846687;
    }
    return a(i, 2131719241, "open_barrage");
  }
  
  private static ActionSheetItem aE()
  {
    int i = 2130846660;
    if (ThemeImageWrapper.isNightMode()) {
      i = 2130846661;
    }
    return a(i, 2131719211, "close_barrage");
  }
  
  private static ActionSheetItem aF()
  {
    int i = 2130846634;
    if (ThemeImageWrapper.isNightMode()) {
      i = 2130846635;
    }
    return a(i, 2131719286, "wechat_");
  }
  
  private static ActionSheetItem aG()
  {
    int i = 2130846632;
    if (ThemeImageWrapper.isNightMode()) {
      i = 2130846633;
    }
    return a(i, 2131719285, "wechat");
  }
  
  private static ActionSheetItem aH()
  {
    int i = 2130846651;
    if (ThemeImageWrapper.isNightMode()) {
      i = 2130846652;
    }
    return a(i, 2131719199, "adjust_font");
  }
  
  private static ActionSheetItem aI()
  {
    int i = 2130846668;
    if (ThemeImageWrapper.isNightMode()) {
      i = 2130846669;
    }
    return a(i, 2131719212, "collect");
  }
  
  private static ActionSheetItem aJ()
  {
    int i = 2130846611;
    if (ThemeImageWrapper.isNightMode()) {
      i = 2130846612;
    }
    return a(i, 2131719186, "Qbrowser");
  }
  
  private static ActionSheetItem aK()
  {
    int i = 2130846614;
    if (ThemeImageWrapper.isNightMode()) {
      i = 2130846615;
    }
    return a(i, 2131719276, "browser");
  }
  
  private static ActionSheetItem aL()
  {
    int i = 2130846628;
    if (ThemeImageWrapper.isNightMode()) {
      i = 2130846629;
    }
    return a(i, 2131719188, "Qzone");
  }
  
  private static ActionSheetItem aM()
  {
    int i = 2130846622;
    if (ThemeImageWrapper.isNightMode()) {
      i = 2130846623;
    }
    return a(i, 2131719187, "Qfriend");
  }
  
  private static ActionSheetItem aN()
  {
    int i = 2130846662;
    if (ThemeImageWrapper.isNightMode()) {
      i = 2130846663;
    }
    return a(i, 2131719215, "copy_link");
  }
  
  private static ActionSheetItem aO()
  {
    int i = 2130840308;
    if (ThemeImageWrapper.isNightMode()) {
      i = 2130844389;
    }
    return a(i, 2131719232, "Import_reader");
  }
  
  private static ActionSheetItem aP()
  {
    int i = 2130837578;
    if (ThemeImageWrapper.isNightMode()) {
      i = 2130837579;
    }
    return a(i, 2131719233, "edit_online");
  }
  
  private static ActionSheetItem aQ()
  {
    int i = 2130840299;
    if (ThemeImageWrapper.isNightMode()) {
      i = 2130844385;
    }
    return a(i, 2131719265, "safe_share");
  }
  
  private static ActionSheetItem aR()
  {
    int i = 2130844398;
    if (ThemeImageWrapper.isNightMode()) {
      i = 2130844399;
    }
    return a(i, 2131719245, "print");
  }
  
  private static ActionSheetItem aS()
  {
    int i = 2130844387;
    if (ThemeImageWrapper.isNightMode()) {
      i = 2130844388;
    }
    return a(i, 2131719216, "generate_link");
  }
  
  private static ActionSheetItem aT()
  {
    int i = 2130844383;
    if (ThemeImageWrapper.isNightMode()) {
      i = 2130844384;
    }
    return a(i, 2131698156, "other_app");
  }
  
  private static ActionSheetItem aU()
  {
    int i = 2130844390;
    if (ThemeImageWrapper.isNightMode()) {
      i = 2130844391;
    }
    return a(i, 2131719217, "generate_QRcode");
  }
  
  private static ActionSheetItem aV()
  {
    int i = 2130840371;
    if (ThemeImageWrapper.isNightMode()) {
      i = 2130840372;
    }
    return a(i, 2131719246, "ad_promotion");
  }
  
  private static ActionSheetItem aW()
  {
    int i = 2130840375;
    if (ThemeImageWrapper.isNightMode()) {
      i = 2130840376;
    }
    return a(i, 2131719192, "ad_block");
  }
  
  private static ActionSheetItem aX()
  {
    if (ThemeImageWrapper.isNightMode()) {}
    for (int i = 2130849871;; i = 2130849872) {
      return a(i, 2131719163, "addto_section");
    }
  }
  
  private static ActionSheetItem aY()
  {
    if (ThemeImageWrapper.isNightMode()) {}
    for (int i = 2130849889;; i = 2130849890) {
      return a(i, 2131719172, "delete_section");
    }
  }
  
  private static ActionSheetItem aZ()
  {
    if (ThemeImageWrapper.isNightMode()) {}
    for (int i = 2130849875;; i = 2130849876) {
      return a(i, 2131719166, "delete_from_section");
    }
  }
  
  private static ActionSheetItem aa()
  {
    int i = 2130846678;
    if (ThemeImageWrapper.isNightMode()) {
      i = 2130846679;
    }
    return a(i, 2131719236, "long_screenshot");
  }
  
  private static ActionSheetItem ab()
  {
    int i = 2130846645;
    if (ThemeImageWrapper.isNightMode()) {
      i = 2130846646;
    }
    return a(i, 2131719213, "colornote");
  }
  
  private static ActionSheetItem ac()
  {
    int i = 2130850998;
    if (ThemeImageWrapper.isNightMode()) {
      i = 2130850999;
    }
    return a(i, 2131719281, "url_to_txdoc");
  }
  
  private static ActionSheetItem ad()
  {
    int i = 2130846656;
    if (ThemeImageWrapper.isNightMode()) {
      i = 2130846657;
    }
    return a(i, 2131719269, "search_emotion");
  }
  
  private static ActionSheetItem ae()
  {
    int i = 2130846682;
    if (ThemeImageWrapper.isNightMode()) {
      i = 2130846683;
    }
    return a(i, 2131719242, "other_app");
  }
  
  private static ActionSheetItem af()
  {
    int i = 2130846680;
    if (ThemeImageWrapper.isNightMode()) {
      i = 2130846681;
    }
    return a(i, 2131719267, "scan_appletcode");
  }
  
  private static ActionSheetItem ag()
  {
    int i = 2130846696;
    if (ThemeImageWrapper.isNightMode()) {
      i = 2130846697;
    }
    return a(i, 2131719268, "scan_qrcode");
  }
  
  private static ActionSheetItem ah()
  {
    int i = 2130846676;
    if (ThemeImageWrapper.isNightMode()) {
      i = 2130846677;
    }
    return a(i, 2131719200, "aio_position");
  }
  
  private static ActionSheetItem ai()
  {
    int i = 2130846711;
    if (ThemeImageWrapper.isNightMode()) {
      i = 2130846712;
    }
    return a(i, 2131719243, "pick_words");
  }
  
  private static ActionSheetItem aj()
  {
    int i = 2130846624;
    if (ThemeImageWrapper.isNightMode()) {
      i = 2130846625;
    }
    return a(i, 2131719228, "group_album");
  }
  
  private static ActionSheetItem ak()
  {
    int i = 2130846630;
    if (ThemeImageWrapper.isNightMode()) {
      i = 2130846631;
    }
    return a(i, 2131719189, "Qzone_album");
  }
  
  private static ActionSheetItem al()
  {
    int i = 2130846647;
    if (ThemeImageWrapper.isNightMode()) {
      i = 2130846648;
    }
    return a(i, 2131719194, "add_emotion");
  }
  
  private static ActionSheetItem am()
  {
    int i = 2130841441;
    if (ThemeImageWrapper.isNightMode()) {
      i = 2130841442;
    }
    return a(i, 2131719257, "push_setup");
  }
  
  private static ActionSheetItem an()
  {
    int i = 2130846714;
    if (ThemeImageWrapper.isNightMode()) {
      i = 2130846715;
    }
    return a(i, 2131719280, "uninterested");
  }
  
  private static ActionSheetItem ao()
  {
    int i = 2130846664;
    if (ThemeImageWrapper.isNightMode()) {
      i = 2130846665;
    }
    return a(i, 2131719266, "save");
  }
  
  private static ActionSheetItem ap()
  {
    int i = 2130849897;
    if (ThemeImageWrapper.isNightMode()) {
      i = 2130846653;
    }
    return a(i, 2131719238, "not_care");
  }
  
  private static ActionSheetItem aq()
  {
    if (ThemeImageWrapper.isNightMode()) {}
    return a(2130842843, 2131695202, "open_aio");
  }
  
  private static ActionSheetItem ar()
  {
    if (ThemeImageWrapper.isNightMode()) {}
    return a(2130842844, 2131719195, "add_friend");
  }
  
  private static ActionSheetItem as()
  {
    if (ThemeImageWrapper.isNightMode()) {}
    return a(2130842843, 2131719240, "open_aio");
  }
  
  private static ActionSheetItem at()
  {
    int i = 2130846636;
    if (ThemeImageWrapper.isNightMode()) {
      i = 2130846637;
    }
    return a(i, 2131719288, "weiyun");
  }
  
  private static ActionSheetItem au()
  {
    int k;
    int i;
    int j;
    if (QFileAssistantUtils.a())
    {
      k = 2131698224;
      i = 2130846620;
      j = k;
      if (ThemeImageWrapper.isNightMode())
      {
        i = 2130846621;
        j = k;
      }
    }
    for (;;)
    {
      return a(i, j, "sent_pc");
      k = 2131719270;
      i = 2130846618;
      j = k;
      if (ThemeImageWrapper.isNightMode())
      {
        i = 2130846619;
        j = k;
      }
    }
  }
  
  private static ActionSheetItem av()
  {
    int i = 2130846696;
    if (ThemeImageWrapper.isNightMode()) {
      i = 2130846697;
    }
    return a(i, 2131719185, "QRcode");
  }
  
  private static ActionSheetItem aw()
  {
    if (ThemeImageWrapper.isNightMode()) {}
    return a(2130842842, 2131719190, "Screenshot_share");
  }
  
  private static ActionSheetItem ax()
  {
    if (ThemeImageWrapper.isNightMode()) {}
    return a(2130844580, 2131719259, "qiyeqq");
  }
  
  private static ActionSheetItem ay()
  {
    if (ThemeImageWrapper.isNightMode()) {}
    return a(2130844579, 2131719258, "qidian");
  }
  
  private static ActionSheetItem az()
  {
    int i = 2130841443;
    if (ThemeImageWrapper.isNightMode()) {
      i = 2130846650;
    }
    return a(i, 2131719193, "add_desktop");
  }
  
  private static ActionSheetItem b()
  {
    return a(2130843427, 2131718614, "close_viola_barrage");
  }
  
  private static ActionSheetItem ba()
  {
    if (ThemeImageWrapper.isNightMode()) {}
    for (int i = 2130849895;; i = 2130849896) {
      return a(i, 2131719184, "kouling_share");
    }
  }
  
  private static ActionSheetItem bb()
  {
    if (ThemeImageWrapper.isNightMode()) {}
    for (int i = 2130849883;; i = 2130849884) {
      return a(i, 2131719183, "play_feedback");
    }
  }
  
  private static ActionSheetItem bc()
  {
    if (ThemeImageWrapper.isNightMode()) {}
    for (int i = 2130849887;; i = 2130849888) {
      return a(i, 2131719165, "delete_fans");
    }
  }
  
  private static ActionSheetItem bd()
  {
    if (ThemeImageWrapper.isNightMode()) {}
    for (int i = 2130849879;; i = 2130849880) {
      return a(i, 2131695255, "share_more");
    }
  }
  
  private static ActionSheetItem be()
  {
    if (ThemeImageWrapper.isNightMode()) {}
    for (int i = 2130849885;; i = 2130849886) {
      return a(i, 2131719169, "private_chat");
    }
  }
  
  private static ActionSheetItem bf()
  {
    if (ThemeImageWrapper.isNightMode()) {}
    for (int i = 2130849885;; i = 2130849886) {
      return a(i, 2131719164, "copy_roomid");
    }
  }
  
  private static ActionSheetItem bg()
  {
    if (ThemeImageWrapper.isNightMode()) {}
    for (int i = 2130841118;; i = 2130841117) {
      return a(i, 2131719198, "group_app");
    }
  }
  
  private static ActionSheetItem bh()
  {
    if (ThemeImageWrapper.isNightMode()) {}
    for (int i = 2130841118;; i = 2130841117) {
      return a(i, 2131719197, "add_to_group");
    }
  }
  
  private static ActionSheetItem bi()
  {
    if (ThemeImageWrapper.isNightMode()) {}
    for (int i = 2130844195;; i = 2130844194) {
      return a(i, 2131719170, "delete_launch");
    }
  }
  
  private static ActionSheetItem bj()
  {
    if (ThemeImageWrapper.isNightMode()) {}
    for (int i = 2130844233;; i = 2130844232) {
      return a(i, 2131719171, "qcircle_private_message");
    }
  }
  
  private static ActionSheetItem bk()
  {
    if (ThemeImageWrapper.isNightMode()) {}
    for (int i = 2130849891;; i = 2130849892) {
      return a(i, 2131719174, "store_manage");
    }
  }
  
  private static ActionSheetItem bl()
  {
    if (ThemeImageWrapper.isNightMode()) {}
    for (int i = 2130849877;; i = 2130849878) {
      return a(i, 2131719167, "fan_group_manage");
    }
  }
  
  private static ActionSheetItem bm()
  {
    if (ThemeImageWrapper.isNightMode()) {}
    for (int i = 2130849873;; i = 2130849874) {
      return a(i, 2131719173, "sharepicture");
    }
  }
  
  private static ActionSheetItem bn()
  {
    if (ThemeImageWrapper.isNightMode()) {}
    for (int i = 2130849893;; i = 2130849894) {
      return a(i, 2131719175, "Sync_zone");
    }
  }
  
  private static ActionSheetItem bo()
  {
    if (ThemeImageWrapper.isNightMode()) {}
    for (int i = 2130849881;; i = 2130849882) {
      return a(i, 2131719168, "orderlist");
    }
  }
  
  private static ActionSheetItem bp()
  {
    if (ThemeImageWrapper.isNightMode()) {}
    for (int i = 2130849869;; i = 2130849870) {
      return a(i, 2131719162, "adding goods");
    }
  }
  
  private static ActionSheetItem bq()
  {
    if (ThemeImageWrapper.isNightMode()) {}
    for (int i = 2130841442;; i = 2130841441) {
      return a(i, 2131719227, "follow_manage");
    }
  }
  
  private static ActionSheetItem br()
  {
    if (ThemeImageWrapper.isNightMode()) {}
    for (int i = 2130843812;; i = 2130843813) {
      return a(i, 2131719176, "add_to_digest");
    }
  }
  
  private static ActionSheetItem bs()
  {
    if (ThemeImageWrapper.isNightMode()) {}
    for (int i = 2130843820;; i = 2130843821) {
      return a(i, 2131719177, "cancel_digest");
    }
  }
  
  private static ActionSheetItem bt()
  {
    if (ThemeImageWrapper.isNightMode()) {}
    for (int i = 2130843824;; i = 2130843825) {
      return a(i, 2131719179, "interest");
    }
  }
  
  private static ActionSheetItem bu()
  {
    if (ThemeImageWrapper.isNightMode()) {}
    for (int i = 2130843816;; i = 2130843817) {
      return a(i, 2131719180, "look_owner");
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
      localActionSheetItem1 = aN();
      continue;
      localActionSheetItem1 = aM();
      continue;
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
      localActionSheetItem1 = F();
      continue;
      localActionSheetItem1 = aG();
      continue;
      localActionSheetItem1 = aF();
      continue;
      localActionSheetItem1 = aC();
      continue;
      localActionSheetItem1 = aD();
      continue;
      localActionSheetItem1 = aE();
      continue;
      localActionSheetItem1 = aB();
      continue;
      localActionSheetItem1 = aA();
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
      localActionSheetItem1 = aC();
      continue;
      localActionSheetItem1 = ac();
      continue;
      localActionSheetItem1 = ab();
      continue;
      localActionSheetItem1 = aa();
      continue;
      localActionSheetItem1 = a(2130840452, 2131719187, "");
      continue;
      localActionSheetItem1 = a(2130850117, 2131719237, "");
      continue;
      localActionSheetItem1 = Z();
      continue;
      localActionSheetItem1 = Y();
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
      localActionSheetItem1 = R();
      continue;
      localActionSheetItem1 = N();
      continue;
      localActionSheetItem1 = O();
      continue;
      localActionSheetItem1 = P();
      continue;
      localActionSheetItem1 = Q();
      continue;
      localActionSheetItem1 = aO();
      continue;
      localActionSheetItem1 = aP();
      continue;
      localActionSheetItem1 = aQ();
      continue;
      localActionSheetItem1 = aR();
      continue;
      localActionSheetItem1 = aS();
      continue;
      localActionSheetItem1 = aU();
      continue;
      localActionSheetItem1 = a(2130843905, 2131697221, "add_troop_app");
      continue;
      localActionSheetItem1 = a(2130843907, 2131697224, "open_app_detail");
      continue;
      localActionSheetItem1 = a(2130843910, 2131697227, "share_troop_app");
      continue;
      localActionSheetItem1 = a(2130843909, 2131697226, "refresh_troop_app_view");
      continue;
      localActionSheetItem1 = a(2130842838, 2131696385, "share_diandian");
      continue;
      localActionSheetItem1 = bd();
      continue;
      localActionSheetItem1 = M();
      continue;
      localActionSheetItem1 = K();
      continue;
      localActionSheetItem1 = L();
      continue;
      localActionSheetItem1 = J();
      continue;
      localActionSheetItem1 = I();
      continue;
      localActionSheetItem1 = H();
      continue;
      localActionSheetItem1 = G();
      continue;
      localActionSheetItem1 = E();
      continue;
      localActionSheetItem1 = D();
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
      localActionSheetItem1 = m();
      continue;
      localActionSheetItem1 = n();
      continue;
      localActionSheetItem1 = S();
      continue;
      localActionSheetItem1 = aT();
      continue;
      localActionSheetItem1 = aW();
      continue;
      localActionSheetItem1 = aV();
      continue;
      localActionSheetItem1 = aX();
      continue;
      localActionSheetItem1 = aY();
      continue;
      localActionSheetItem1 = aZ();
      continue;
      localActionSheetItem1 = ba();
      continue;
      localActionSheetItem1 = bb();
      continue;
      localActionSheetItem1 = bc();
      continue;
      localActionSheetItem1 = be();
      continue;
      localActionSheetItem1 = bf();
      continue;
      localActionSheetItem1 = bg();
      continue;
      localActionSheetItem1 = bh();
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
      localActionSheetItem1 = bw();
      continue;
      localActionSheetItem1 = bx();
      continue;
      localActionSheetItem1 = bi();
      continue;
      localActionSheetItem1 = bb();
      continue;
      localActionSheetItem1 = bj();
      continue;
      localActionSheetItem1 = a();
      continue;
      localActionSheetItem1 = b();
    }
  }
  
  private static ActionSheetItem bv()
  {
    if (ThemeImageWrapper.isNightMode()) {}
    for (int i = 2130843818;; i = 2130843819) {
      return a(i, 2131719182, "push_topics");
    }
  }
  
  private static ActionSheetItem bw()
  {
    if (ThemeImageWrapper.isNightMode()) {}
    for (int i = 2130843822;; i = 2130843823) {
      return a(i, 2131719181, "pull_black");
    }
  }
  
  private static ActionSheetItem bx()
  {
    if (ThemeImageWrapper.isNightMode()) {}
    for (int i = 2130843814;; i = 2130843815) {
      return a(i, 2131719178, "feedback");
    }
  }
  
  private static ActionSheetItem c()
  {
    int i = 2130851290;
    if (ThemeImageWrapper.isNightMode()) {
      i = 2130851291;
    }
    return a(i, 2131719220, "download");
  }
  
  private static ActionSheetItem d()
  {
    int i = 2130851288;
    if (ThemeImageWrapper.isNightMode()) {
      i = 2130851289;
    }
    return a(i, 2131719209, "carton_detail");
  }
  
  private static ActionSheetItem e()
  {
    int i = 2130842003;
    if (ThemeImageWrapper.isNightMode()) {
      i = 2130842004;
    }
    return a(i, 2131719248, "book_detail");
  }
  
  private static ActionSheetItem f()
  {
    int i = 2130842001;
    if (ThemeImageWrapper.isNightMode()) {
      i = 2130842002;
    }
    return a(i, 2131719247, "add_shelf");
  }
  
  private static ActionSheetItem g()
  {
    int i = 2130842005;
    if (ThemeImageWrapper.isNightMode()) {
      i = 2130842008;
    }
    return a(i, 2131719249, "bookmark");
  }
  
  private static ActionSheetItem h()
  {
    int i = 2130842006;
    if (ThemeImageWrapper.isNightMode()) {
      i = 2130842007;
    }
    return a(i, 2131719250, "bookmark_cancel");
  }
  
  private static ActionSheetItem i()
  {
    int i = 2130842013;
    if (ThemeImageWrapper.isNightMode()) {
      i = 2130842014;
    }
    return a(i, 2131719253, "hide_opinion");
  }
  
  private static ActionSheetItem j()
  {
    int i = 2130842019;
    if (ThemeImageWrapper.isNightMode()) {
      i = 2130842020;
    }
    return a(i, 2131719256, "show_opinion");
  }
  
  private static ActionSheetItem k()
  {
    int i = 2130842009;
    if (ThemeImageWrapper.isNightMode()) {
      i = 2130842012;
    }
    return a(i, 2131719251, "continue_purchase");
  }
  
  private static ActionSheetItem l()
  {
    int i = 2130842010;
    if (ThemeImageWrapper.isNightMode()) {
      i = 2130842011;
    }
    return a(i, 2131719252, "continue_purchase_cancel");
  }
  
  private static ActionSheetItem m()
  {
    int i = 2130842015;
    if (ThemeImageWrapper.isNightMode()) {
      i = 2130842018;
    }
    return a(i, 2131719254, "privacy");
  }
  
  private static ActionSheetItem n()
  {
    int i = 2130842016;
    if (ThemeImageWrapper.isNightMode()) {
      i = 2130842017;
    }
    return a(i, 2131719255, "privacy_cancel");
  }
  
  private static ActionSheetItem o()
  {
    return a(2130848798, 2131719271, "set_background");
  }
  
  private static ActionSheetItem p()
  {
    return a(2130848802, 2131719210, "rec_face");
  }
  
  private static ActionSheetItem q()
  {
    return a(2130848228, 2131719244, "psapp");
  }
  
  private static ActionSheetItem r()
  {
    return a(2130848221, 2131719283, "watch_on_tv");
  }
  
  private static ActionSheetItem s()
  {
    return a(2130848224, 2131719208, "no_only_friend");
  }
  
  private static ActionSheetItem t()
  {
    int i = 2130846684;
    if (ThemeImageWrapper.isNightMode()) {
      i = 2130846685;
    }
    return a(i, 2131719239, "only_friend");
  }
  
  private static ActionSheetItem u()
  {
    return a(2130848225, 2131719262, "reprint_diary");
  }
  
  private static ActionSheetItem v()
  {
    return a(2130848225, 2131719263, "reprint_photo");
  }
  
  private static ActionSheetItem w()
  {
    return a(2130848232, 2131719282, "look_dress");
  }
  
  private static ActionSheetItem x()
  {
    return a(2130848232, 2131719272, "set_card");
  }
  
  private static ActionSheetItem y()
  {
    return a(2130848238, 2131719277, "unstick");
  }
  
  private static ActionSheetItem z()
  {
    return a(2130848235, 2131719274, "stick");
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