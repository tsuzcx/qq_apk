package com.tencent.mobileqq.utils;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import bjuk;
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
  private static final boolean ENABLE_CHECK_CREATE = true;
  private static final int[] ICON_LIST;
  private static final int[] LABEL_LIST;
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
  private IllegalStateException mPendingException;
  public String reportID;
  public String uin;
  public int uinType;
  public int visibility = 0;
  
  static
  {
    int j = 0;
    ICON_LIST = new int[] { 2130846213, 2130846214, 2130846173, 2130846174, 2130846179, 2130846180, 2130846167, 2130846168, 2130846164, 2130846165, 2130846219, 2130846220, 2130846202, 2130846203, 2130846209, 2130846210, 2130846183, 2130846184, 2130846185, 2130846186, 2130846245, 2130846246, 2130846192, 2130846193, 2130846177, 2130846178, 2130843696, 2130843698, 2130843701, 2130843700, 2130844322, 2130844323, 2130842666, 2130846247, 2130846248, 2130839123, 2130839346, 2130839379, 2130846187, 2130846188, 2130846171, 2130846172, 2130842667, 2130842677, 2130842662, 2130842668, 2130842664, 2130846215, 2130846216, 2130846583, 2130846826, 2130839128, 2130842650, 2130846264, 2130843202, 2130846198, 2130846199, 2130846181, 2130846182, 2130846175, 2130846176, 2130846261, 2130846262, 2130846160, 2130846227, 2130846228, 2130846231, 2130846161, 2130846162, 2130846233, 2130846234, 2130846207, 2130846208, 2130844207, 2130850469, 2130850470, 2130846196, 2130846197, 2130846205, 2130846206, 2130846229, 2130846230, 2130849427, 2130846265, 2130849426, 2130846204, 2130840312, 2130849628, 2130849629, 2130840193, 2130841287, 2130841288, 2130841299, 2130846201, 2130841300, 2130841301, 2130841302, 2130841303, 2130846267, 2130846246, 2130846237, 2130846238, 2130846211, 2130846212, 2130841289, 2130841290, 2130841294, 2130841295, 2130841291, 2130841292, 2130841297, 2130841298, 2130842659, 2130847790, 2130847787, 2130847785, 2130847784, 2130847783, 2130847776, 2130847777, 2130847774, 2130847775, 2130847788, 2130847778, 2130846225, 2130846226, 2130847786, 2130847789, 2130848351, 2130847773, 2130847780, 2130848354, 2130848350, 2130846235, 2130846236, 2130842659, 2130841847, 2130841845, 2130841849, 2130841850, 2130841857, 2130841863, 2130841853, 2130841854, 2130841859, 2130841860, 2130840194, 2130844132, 2130837578, 2130837579, 2130840185, 2130844128, 2130844141, 2130844142, 2130844130, 2130844131, 2130844133, 2130844134, 2130844105, 2130844106, 2130844101, 2130844102, 2130844107, 2130844108, 2130844126, 2130844127, 2130840236, 2130840237, 2130840232, 2130840233, 2130849405, 2130849404, 2130849419, 2130849418, 2130849401, 2130849400, 2130849425, 2130849424, 2130849413, 2130849412, 2130849417, 2130849416, 2130849409, 2130849408, 2130849415, 2130849414, 2130840946, 2130840947, 2130843979, 2130843980, 2130849414, 2130849403, 2130849402, 2130849421, 2130849420, 2130849407, 2130849406, 2130849423, 2130849422, 2130849411, 2130849410, 2130849399, 2130849398, 2130846225, 2130846226, 2130843607, 2130843606, 2130843609, 2130843608, 2130843611, 2130843610, 2130843615, 2130843614, 2130843617, 2130843616, 2130843605, 2130843604, 2130843613, 2130843612, 2130849186, 2130844000, 2130843999, 2130850719, 2130850720, 2130850717, 2130850718 };
    HashSet localHashSet = new HashSet();
    int i = 0;
    if (i < ICON_LIST.length)
    {
      if (localHashSet.contains(Integer.valueOf(ICON_LIST[i]))) {
        QLog.e("ShareActionSheetBuilder", 1, "static initializer() called duplicated icon " + i + ", " + BaseApplicationImpl.getApplication().getResources().getResourceEntryName(ICON_LIST[i]));
      }
      for (;;)
      {
        i += 1;
        break;
        localHashSet.add(Integer.valueOf(ICON_LIST[i]));
      }
    }
    Arrays.sort(ICON_LIST);
    LABEL_LIST = new int[] { 2131718326, 2131718347, 2131718348, 2131718277, 2131718278, 2131718279, 2131718317, 2131718352, 2131718377, 2131718323, 2131718374, 2131718375, 2131718376, 2131718365, 2131718276, 2131718331, 2131718346, 2131718325, 2131718327, 2131718370, 2131718285, 2131718329, 2131718358, 2131718356, 2131718357, 2131718286, 2131718349, 2131718296, 2131718353, 2131718288, 2131718287, 2131718293, 2131718291, 2131718294, 2131718292, 2131718295, 2131718307, 2131718302, 2131718303, 2131718275, 2131718290, 2131718332, 2131718355, 2131718289, 2131718359, 2131718304, 2131718280, 2131718284, 2131718283, 2131718281, 2131718369, 2131718350, 2131718330, 2131718300, 2131718301, 2131718321, 2131718322, 2131718354, 2131718334, 2131718305, 2131718306, 2131696700, 2131696703, 2131696706, 2131696705, 2131695883, 2131694808, 2131718367, 2131718319, 2131718318, 2131718320, 2131718315, 2131718368, 2131718373, 2131718335, 2131718282, 2131718311, 2131718324, 2131718310, 2131718362, 2131718363, 2131718366, 2131718361, 2131718371, 2131718351, 2131718328, 2131718297, 2131718308, 2131718372, 2131718333, 2131718299, 2131718360, 2131694808, 2131718337, 2131718336, 2131718338, 2131718339, 2131718342, 2131718345, 2131718340, 2131718341, 2131718343, 2131718344, 2131718313, 2131718312, 2131718314, 2131697619, 2131718344, 2131718335, 2131718282, 2131718344, 2131718253, 2131718274, 2131718256, 2131718262, 2131718273, 2131718255, 2131718259, 2131718254, 2131718260, 2131718259, 2131718257, 2131718263, 2131718265, 2131718258, 2131718252, 2131718264, 2131718316, 2131718266, 2131718267, 2131718269, 2131718270, 2131718272, 2131718271, 2131718268, 2131718298, 2131718309 };
    localHashSet = new HashSet();
    i = j;
    if (i < LABEL_LIST.length)
    {
      if (localHashSet.contains(Integer.valueOf(LABEL_LIST[i]))) {
        QLog.e("ShareActionSheetBuilder", 1, "static initializer() called duplicated label " + i + ", " + BaseApplicationImpl.getApplication().getResources().getResourceEntryName(LABEL_LIST[i]));
      }
      for (;;)
      {
        i += 1;
        break;
        localHashSet.add(Integer.valueOf(LABEL_LIST[i]));
      }
    }
    Arrays.sort(LABEL_LIST);
  }
  
  public ShareActionSheetBuilder$ActionSheetItem()
  {
    if (!new java.lang.Throwable().getStackTrace()[1].getClassName().equals(ActionSheetItem.class.getName()))
    {
      this.mPendingException = new IllegalStateException("Must use method com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem.build(int) to create me !");
      QLog.e("ShareActionSheetBuilder", 1, "ActionSheetItem: ", this.mPendingException);
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
      localActionSheetItem1 = buildCopy();
      continue;
      localActionSheetItem1 = buildSendToFriend();
      continue;
      localActionSheetItem1 = buildSendToQZone();
      continue;
      localActionSheetItem1 = buildBrowser();
      continue;
      localActionSheetItem1 = buildQQBrowser();
      continue;
      localActionSheetItem1 = buildFavorite();
      continue;
      localActionSheetItem1 = buildAdjustFont();
      continue;
      localActionSheetItem1 = buildCheckProfile();
      continue;
      localActionSheetItem1 = buildSendToWeChat();
      continue;
      localActionSheetItem1 = buildSendToWeChatCircle();
      continue;
      localActionSheetItem1 = buildReport();
      continue;
      localActionSheetItem1 = buildBarrageSwitchOpen();
      continue;
      localActionSheetItem1 = buildBarrageSwitchClose();
      continue;
      localActionSheetItem1 = buildSendToWeibo();
      continue;
      localActionSheetItem1 = buildKandian();
      continue;
      localActionSheetItem1 = buildAddShortCut();
      continue;
      localActionSheetItem1 = buildQidian();
      continue;
      localActionSheetItem1 = buildQiyeQQ();
      continue;
      localActionSheetItem1 = buildScreenshot();
      continue;
      localActionSheetItem1 = buildQRCode();
      continue;
      localActionSheetItem1 = buildMyComputer();
      continue;
      localActionSheetItem1 = buildSendToWeiYun();
      continue;
      localActionSheetItem1 = buildOpenAio();
      continue;
      localActionSheetItem1 = buildAddFriend();
      continue;
      localActionSheetItem1 = buildGotoFriendAio();
      continue;
      localActionSheetItem1 = buildNotCare();
      continue;
      localActionSheetItem1 = buildSave();
      continue;
      localActionSheetItem1 = buildNotInterested();
      continue;
      localActionSheetItem1 = buildPushSetup();
      continue;
      localActionSheetItem1 = buildAddEmoji();
      continue;
      localActionSheetItem1 = buildQZoneAlbum();
      continue;
      localActionSheetItem1 = buildGroupAlbum();
      continue;
      localActionSheetItem1 = buildExtractWords();
      continue;
      localActionSheetItem1 = buildAioLocation();
      continue;
      localActionSheetItem1 = buildScanQRCode();
      continue;
      localActionSheetItem1 = buildScanMiniAppCode();
      continue;
      localActionSheetItem1 = buildOtherApp();
      continue;
      localActionSheetItem1 = buildViewEmoji();
      continue;
      localActionSheetItem1 = buildReport();
      continue;
      localActionSheetItem1 = buildExportTencentDocs();
      continue;
      localActionSheetItem1 = buildAddColorNote();
      continue;
      localActionSheetItem1 = buildLongscreenshot();
      continue;
      localActionSheetItem1 = build(2130840312, 2131718277, "");
      continue;
      localActionSheetItem1 = build(2130849628, 2131718326, "");
      continue;
      localActionSheetItem1 = buildOpenMiniAppDebug();
      continue;
      localActionSheetItem1 = buildCloseMiniAppDebug();
      continue;
      localActionSheetItem1 = buildMiniAppOpenPerformance();
      continue;
      localActionSheetItem1 = buildMiniAppClosePerformance();
      continue;
      localActionSheetItem1 = buildAbout();
      continue;
      localActionSheetItem1 = buildAddToMy();
      continue;
      localActionSheetItem1 = buildRemoveFromMy();
      continue;
      localActionSheetItem1 = buildBackToHome();
      continue;
      localActionSheetItem1 = buildRemoveColorNote();
      continue;
      localActionSheetItem1 = buildFavGroup();
      continue;
      localActionSheetItem1 = buildFavDetail();
      continue;
      localActionSheetItem1 = buildFavOriginalUrl();
      continue;
      localActionSheetItem1 = buildImportReader();
      continue;
      localActionSheetItem1 = buildImportTXdoc();
      continue;
      localActionSheetItem1 = buildSafeForward();
      continue;
      localActionSheetItem1 = buildPrint();
      continue;
      localActionSheetItem1 = buildCreateLink();
      continue;
      localActionSheetItem1 = buildCreateQr();
      continue;
      localActionSheetItem1 = build(2130843696, 2131696700, "add_troop_app");
      continue;
      localActionSheetItem1 = build(2130843698, 2131696703, "open_app_detail");
      continue;
      localActionSheetItem1 = build(2130843701, 2131696706, "share_troop_app");
      continue;
      localActionSheetItem1 = build(2130843700, 2131696705, "refresh_troop_app_view");
      continue;
      localActionSheetItem1 = build(2130842662, 2131695883, "share_diandian");
      continue;
      localActionSheetItem1 = buildMoreInfo();
      continue;
      localActionSheetItem1 = buildRemoveFavorite();
      continue;
      localActionSheetItem1 = buildHideFeed();
      continue;
      localActionSheetItem1 = buildHideThisWork();
      continue;
      localActionSheetItem1 = buildHideHim();
      continue;
      localActionSheetItem1 = buildFollow();
      continue;
      localActionSheetItem1 = buildUnFollow();
      continue;
      localActionSheetItem1 = buildWatchOriginalVideo();
      continue;
      localActionSheetItem1 = buildDelete();
      continue;
      localActionSheetItem1 = buildSendToEvernote();
      continue;
      localActionSheetItem1 = buildLaunchChat();
      continue;
      localActionSheetItem1 = buildEdit();
      continue;
      localActionSheetItem1 = buildSetPrivate();
      continue;
      localActionSheetItem1 = buildSetTop();
      continue;
      localActionSheetItem1 = buildUnSetTop();
      continue;
      localActionSheetItem1 = buildSetDress();
      continue;
      localActionSheetItem1 = buildViewDress();
      continue;
      localActionSheetItem1 = buildReprintPhoto();
      continue;
      localActionSheetItem1 = buildReprintBlog();
      continue;
      localActionSheetItem1 = buildOnlySeeFriend();
      continue;
      localActionSheetItem1 = buildCancelOnlySeeFriend();
      continue;
      localActionSheetItem1 = buildWatchOnTV();
      continue;
      localActionSheetItem1 = buildPitu();
      continue;
      localActionSheetItem1 = buildChooseFace();
      continue;
      localActionSheetItem1 = buildSetBackground();
      continue;
      localActionSheetItem1 = buildDownload();
      continue;
      localActionSheetItem1 = buildCartonDetail();
      continue;
      localActionSheetItem1 = buildBookDetail();
      continue;
      localActionSheetItem1 = buildAddShelf();
      continue;
      localActionSheetItem1 = buildBookmark();
      continue;
      localActionSheetItem1 = buildBookmarkCancel();
      continue;
      localActionSheetItem1 = buildHideOpinion();
      continue;
      localActionSheetItem1 = buildShowOpinion();
      continue;
      localActionSheetItem1 = buildContinuePurchase();
      continue;
      localActionSheetItem1 = buildContinuePurchaseCancel();
      continue;
      localActionSheetItem1 = buildPrivacy();
      continue;
      localActionSheetItem1 = buildPrivacyCancel();
      continue;
      localActionSheetItem1 = buildRestartMiniApp();
      continue;
      localActionSheetItem1 = buildOpenFileWithoutDefaultApp();
      continue;
      localActionSheetItem1 = buildAdBlock();
      continue;
      localActionSheetItem1 = buildAdPromotion();
      continue;
      localActionSheetItem1 = buildAddVideoToTopic();
      continue;
      localActionSheetItem1 = buildRemoveVideoFromTopic();
      continue;
      localActionSheetItem1 = buildDeleteTopic();
      continue;
      localActionSheetItem1 = buildCreateWatchWord();
      continue;
      localActionSheetItem1 = buildVideoFeedback();
      continue;
      localActionSheetItem1 = buildDeleteFans();
      continue;
      localActionSheetItem1 = buildPrivateMessage();
      continue;
      localActionSheetItem1 = buildRoomId();
      continue;
      localActionSheetItem1 = buildMiniAppToTroop();
      continue;
      localActionSheetItem1 = buildMiniAppToCurrentTroop();
      continue;
      localActionSheetItem1 = buildShopManager();
      continue;
      localActionSheetItem1 = buildGroupManager();
      continue;
      localActionSheetItem1 = buildSharePicture();
      continue;
      localActionSheetItem1 = buildSyncQzone();
      continue;
      localActionSheetItem1 = buildOrderList();
      continue;
      localActionSheetItem1 = buildAddGoods();
      continue;
      localActionSheetItem1 = buildFollowManage();
      continue;
      localActionSheetItem1 = buildTribeAddToDigest();
      continue;
      localActionSheetItem1 = buildTribeCancelDigest();
      continue;
      localActionSheetItem1 = buildTribeInterest();
      continue;
      localActionSheetItem1 = buildTribeLookOwner();
      continue;
      localActionSheetItem1 = buildTribePushTopic();
      continue;
      localActionSheetItem1 = buildTribePullBlack();
      continue;
      localActionSheetItem1 = buildTribeFeedback();
      continue;
      localActionSheetItem1 = buildDeleteHasPush();
      continue;
      localActionSheetItem1 = buildVideoFeedback();
      continue;
      localActionSheetItem1 = buildQcirclePrivateMessage();
    }
  }
  
  private static ActionSheetItem build(int paramInt1, int paramInt2, String paramString)
  {
    return build(paramInt1, paramInt2, paramString, BaseApplicationImpl.getApplication().getResources());
  }
  
  private static ActionSheetItem build(int paramInt1, int paramInt2, String paramString, Resources paramResources)
  {
    ActionSheetItem localActionSheetItem = new ActionSheetItem();
    localActionSheetItem.icon = paramInt1;
    localActionSheetItem.label = paramResources.getString(paramInt2);
    localActionSheetItem.reportID = paramString;
    return localActionSheetItem;
  }
  
  private static ActionSheetItem buildAbout()
  {
    int i = 2130841287;
    if (bjuk.a()) {
      i = 2130841288;
    }
    return build(i, 2131718281, "about");
  }
  
  private static ActionSheetItem buildAdBlock()
  {
    int i = 2130840236;
    if (bjuk.a()) {
      i = 2130840237;
    }
    return build(i, 2131718282, "ad_block");
  }
  
  private static ActionSheetItem buildAdPromotion()
  {
    int i = 2130840232;
    if (bjuk.a()) {
      i = 2130840233;
    }
    return build(i, 2131718335, "ad_promotion");
  }
  
  private static ActionSheetItem buildAddColorNote()
  {
    int i = 2130846196;
    if (bjuk.a()) {
      i = 2130846197;
    }
    return build(i, 2131718302, "colornote");
  }
  
  private static ActionSheetItem buildAddEmoji()
  {
    int i = 2130846198;
    if (bjuk.a()) {
      i = 2130846199;
    }
    return build(i, 2131718284, "add_emotion");
  }
  
  private static ActionSheetItem buildAddFriend()
  {
    if (bjuk.a()) {}
    return build(2130842668, 2131718285, "add_friend");
  }
  
  private static ActionSheetItem buildAddGoods()
  {
    if (bjuk.a()) {}
    for (int i = 2130849398;; i = 2130849399) {
      return build(i, 2131718252, "adding goods");
    }
  }
  
  private static ActionSheetItem buildAddShelf()
  {
    int i = 2130841845;
    if (bjuk.a()) {
      i = 2130841846;
    }
    return build(i, 2131718336, "add_shelf");
  }
  
  private static ActionSheetItem buildAddShortCut()
  {
    int i = 2130841299;
    if (bjuk.a()) {
      i = 2130846201;
    }
    return build(i, 2131718283, "add_desktop");
  }
  
  private static ActionSheetItem buildAddToMy()
  {
    int i = 2130841300;
    if (bjuk.a()) {
      i = 2130841301;
    }
    return build(i, 2131718286, "add_my");
  }
  
  private static ActionSheetItem buildAddVideoToTopic()
  {
    if (bjuk.a()) {}
    for (int i = 2130849400;; i = 2130849401) {
      return build(i, 2131718253, "addto_section");
    }
  }
  
  private static ActionSheetItem buildAdjustFont()
  {
    int i = 2130846202;
    if (bjuk.a()) {
      i = 2130846203;
    }
    return build(i, 2131718289, "adjust_font");
  }
  
  private static ActionSheetItem buildAioLocation()
  {
    int i = 2130846227;
    if (bjuk.a()) {
      i = 2130846228;
    }
    return build(i, 2131718290, "aio_position");
  }
  
  private static ActionSheetItem buildBackToHome()
  {
    int i = 2130841289;
    if (bjuk.a()) {
      i = 2130841290;
    }
    return build(i, 2131718296, "backtohome");
  }
  
  private static ActionSheetItem buildBarrageSwitchClose()
  {
    int i = 2130846237;
    if (bjuk.a()) {
      i = 2130846238;
    }
    return build(i, 2131718300, "close_barrage");
  }
  
  private static ActionSheetItem buildBarrageSwitchOpen()
  {
    int i = 2130846211;
    if (bjuk.a()) {
      i = 2130846212;
    }
    return build(i, 2131718330, "open_barrage");
  }
  
  private static ActionSheetItem buildBookDetail()
  {
    int i = 2130841847;
    if (bjuk.a()) {
      i = 2130841848;
    }
    return build(i, 2131718337, "book_detail");
  }
  
  private static ActionSheetItem buildBookmark()
  {
    int i = 2130841849;
    if (bjuk.a()) {
      i = 2130841852;
    }
    return build(i, 2131718338, "bookmark");
  }
  
  private static ActionSheetItem buildBookmarkCancel()
  {
    int i = 2130841850;
    if (bjuk.a()) {
      i = 2130841851;
    }
    return build(i, 2131718339, "bookmark_cancel");
  }
  
  private static ActionSheetItem buildBrowser()
  {
    int i = 2130846167;
    if (bjuk.a()) {
      i = 2130846168;
    }
    return build(i, 2131718365, "browser");
  }
  
  private static ActionSheetItem buildCancelOnlySeeFriend()
  {
    return build(2130847776, 2131718297, "no_only_friend");
  }
  
  private static ActionSheetItem buildCartonDetail()
  {
    int i = 2130850717;
    if (bjuk.a()) {
      i = 2130850718;
    }
    return build(i, 2131718298, "carton_detail");
  }
  
  private static ActionSheetItem buildCheckProfile()
  {
    int i = 2130846209;
    if (bjuk.a()) {
      i = 2130846210;
    }
    return build(i, 2131695903, "check_profile");
  }
  
  private static ActionSheetItem buildChooseFace()
  {
    return build(2130848354, 2131718299, "rec_face");
  }
  
  private static ActionSheetItem buildCloseMiniAppDebug()
  {
    int i = 2130841291;
    if (bjuk.a()) {
      i = 2130841292;
    }
    return build(i, 2131718291, "applet_closedebug");
  }
  
  private static ActionSheetItem buildContinuePurchase()
  {
    int i = 2130841853;
    if (bjuk.a()) {
      i = 2130841856;
    }
    return build(i, 2131718340, "continue_purchase");
  }
  
  private static ActionSheetItem buildContinuePurchaseCancel()
  {
    int i = 2130841854;
    if (bjuk.a()) {
      i = 2130841855;
    }
    return build(i, 2131718341, "continue_purchase_cancel");
  }
  
  private static ActionSheetItem buildCopy()
  {
    int i = 2130846213;
    if (bjuk.a()) {
      i = 2130846214;
    }
    return build(i, 2131718304, "copy_link");
  }
  
  private static ActionSheetItem buildCreateLink()
  {
    int i = 2130844130;
    if (bjuk.a()) {
      i = 2130844131;
    }
    return build(i, 2131718305, "generate_link");
  }
  
  private static ActionSheetItem buildCreateQr()
  {
    int i = 2130844133;
    if (bjuk.a()) {
      i = 2130844134;
    }
    return build(i, 2131718306, "generate_QRcode");
  }
  
  private static ActionSheetItem buildCreateWatchWord()
  {
    if (bjuk.a()) {}
    for (int i = 2130849424;; i = 2130849425) {
      return build(i, 2131718274, "kouling_share");
    }
  }
  
  private static ActionSheetItem buildDelete()
  {
    return build(2130848351, 2131718308, "delete");
  }
  
  private static ActionSheetItem buildDeleteFans()
  {
    if (bjuk.a()) {}
    for (int i = 2130849416;; i = 2130849417) {
      return build(i, 2131718255, "delete_fans");
    }
  }
  
  private static ActionSheetItem buildDeleteHasPush()
  {
    if (bjuk.a()) {}
    for (int i = 2130843980;; i = 2130843979) {
      return build(i, 2131718260, "delete_launch");
    }
  }
  
  private static ActionSheetItem buildDeleteTopic()
  {
    if (bjuk.a()) {}
    for (int i = 2130849404;; i = 2130849405) {
      return build(i, 2131718256, "delete_from_section");
    }
  }
  
  private static ActionSheetItem buildDownload()
  {
    int i = 2130850719;
    if (bjuk.a()) {
      i = 2130850720;
    }
    return build(i, 2131718309, "download");
  }
  
  private static ActionSheetItem buildEdit()
  {
    return build(2130847774, 2131718310, "edit");
  }
  
  private static ActionSheetItem buildExportTencentDocs()
  {
    int i = 2130850469;
    if (bjuk.a()) {
      i = 2130850470;
    }
    return build(i, 2131718370, "url_to_txdoc");
  }
  
  private static ActionSheetItem buildExtractWords()
  {
    int i = 2130846261;
    if (bjuk.a()) {
      i = 2130846262;
    }
    return build(i, 2131718332, "pick_words");
  }
  
  private static ActionSheetItem buildFavDetail()
  {
    int i = 2130844101;
    if (bjuk.a()) {
      i = 2130844102;
    }
    return build(i, 2131718312, "fav_detail");
  }
  
  private static ActionSheetItem buildFavGroup()
  {
    int i = 2130844105;
    if (bjuk.a()) {
      i = 2130844106;
    }
    return build(i, 2131718313, "fav_group");
  }
  
  private static ActionSheetItem buildFavOriginalUrl()
  {
    int i = 2130844107;
    if (bjuk.a()) {
      i = 2130844108;
    }
    return build(i, 2131718314, "fav_show_originalurl");
  }
  
  private static ActionSheetItem buildFavorite()
  {
    int i = 2130846219;
    if (bjuk.a()) {
      i = 2130846220;
    }
    return build(i, 2131718301, "collect");
  }
  
  private static ActionSheetItem buildFollow()
  {
    return build(2130847786, 2131718315, "follow");
  }
  
  private static ActionSheetItem buildFollowManage()
  {
    if (bjuk.a()) {}
    for (int i = 2130841298;; i = 2130841297) {
      return build(i, 2131718316, "follow_manage");
    }
  }
  
  private static ActionSheetItem buildGotoFriendAio()
  {
    if (bjuk.a()) {}
    return build(2130842667, 2131694756, "open_aio");
  }
  
  private static ActionSheetItem buildGroupAlbum()
  {
    int i = 2130846175;
    if (bjuk.a()) {
      i = 2130846176;
    }
    return build(i, 2131718317, "group_album");
  }
  
  private static ActionSheetItem buildGroupManager()
  {
    if (bjuk.a()) {}
    for (int i = 2130849406;; i = 2130849407) {
      return build(i, 2131718257, "fan_group_manage");
    }
  }
  
  private static ActionSheetItem buildHideFeed()
  {
    int i = 2130846225;
    if (bjuk.a()) {
      i = 2130846226;
    }
    return build(i, 2131718319, "hide_this_feed");
  }
  
  private static ActionSheetItem buildHideHim()
  {
    return build(2130847778, 2131718320, "hide_him");
  }
  
  private static ActionSheetItem buildHideOpinion()
  {
    int i = 2130841857;
    if (bjuk.a()) {
      i = 2130841858;
    }
    return build(i, 2131718342, "hide_opinion");
  }
  
  private static ActionSheetItem buildHideThisWork()
  {
    int i = 2130846225;
    if (bjuk.a()) {
      i = 2130846226;
    }
    return build(i, 2131718318, "hide_works");
  }
  
  private static ActionSheetItem buildImportReader()
  {
    int i = 2130840194;
    if (bjuk.a()) {
      i = 2130844132;
    }
    return build(i, 2131718321, "Import_reader");
  }
  
  private static ActionSheetItem buildImportTXdoc()
  {
    int i = 2130837578;
    if (bjuk.a()) {
      i = 2130837579;
    }
    return build(i, 2131718322, "edit_online");
  }
  
  private static ActionSheetItem buildKandian()
  {
    int i = 2130846177;
    if (bjuk.a()) {
      i = 2130846178;
    }
    return build(i, 2131718323, "kandian");
  }
  
  private static ActionSheetItem buildLaunchChat()
  {
    return build(2130847783, 2131718324, "open_aio");
  }
  
  private static ActionSheetItem buildLongscreenshot()
  {
    int i = 2130846229;
    if (bjuk.a()) {
      i = 2130846230;
    }
    return build(i, 2131718325, "long_screenshot");
  }
  
  private static ActionSheetItem buildMiniAppClosePerformance()
  {
    int i = 2130841291;
    if (bjuk.a()) {
      i = 2130841292;
    }
    return build(i, 2131718292, "applet_closeperformance");
  }
  
  private static ActionSheetItem buildMiniAppOpenPerformance()
  {
    int i = 2130841291;
    if (bjuk.a()) {
      i = 2130841292;
    }
    return build(i, 2131718294, "applet_openperformance");
  }
  
  private static ActionSheetItem buildMiniAppToCurrentTroop()
  {
    if (bjuk.a()) {}
    for (int i = 2130840947;; i = 2130840946) {
      return build(i, 2131718287, "add_to_group");
    }
  }
  
  private static ActionSheetItem buildMiniAppToTroop()
  {
    if (bjuk.a()) {}
    for (int i = 2130840947;; i = 2130840946) {
      return build(i, 2131718288, "group_app");
    }
  }
  
  private static ActionSheetItem buildMoreInfo()
  {
    if (bjuk.a()) {}
    for (int i = 2130849408;; i = 2130849409) {
      return build(i, 2131694808, "share_more");
    }
  }
  
  private static ActionSheetItem buildMyComputer()
  {
    int i = 2130846171;
    if (bjuk.a()) {
      i = 2130846172;
    }
    return build(i, 2131718359, "sent_pc");
  }
  
  private static ActionSheetItem buildNotCare()
  {
    int i = 2130849426;
    if (bjuk.a()) {
      i = 2130846204;
    }
    return build(i, 2131718327, "not_care");
  }
  
  private static ActionSheetItem buildNotInterested()
  {
    int i = 2130846264;
    if (bjuk.a()) {
      i = 2130846265;
    }
    return build(i, 2131718369, "uninterested");
  }
  
  private static ActionSheetItem buildOnlySeeFriend()
  {
    int i = 2130846235;
    if (bjuk.a()) {
      i = 2130846236;
    }
    return build(i, 2131718328, "only_friend");
  }
  
  private static ActionSheetItem buildOpenAio()
  {
    if (bjuk.a()) {}
    return build(2130842667, 2131718329, "open_aio");
  }
  
  private static ActionSheetItem buildOpenFileWithoutDefaultApp()
  {
    int i = 2130844126;
    if (bjuk.a()) {
      i = 2130844127;
    }
    return build(i, 2131697619, "other_app");
  }
  
  private static ActionSheetItem buildOpenMiniAppDebug()
  {
    int i = 2130841291;
    if (bjuk.a()) {
      i = 2130841292;
    }
    return build(i, 2131718293, "applet_opendebug");
  }
  
  private static ActionSheetItem buildOrderList()
  {
    if (bjuk.a()) {}
    for (int i = 2130849410;; i = 2130849411) {
      return build(i, 2131718258, "orderlist");
    }
  }
  
  private static ActionSheetItem buildOtherApp()
  {
    int i = 2130846233;
    if (bjuk.a()) {
      i = 2130846234;
    }
    return build(i, 2131718331, "other_app");
  }
  
  private static ActionSheetItem buildPitu()
  {
    return build(2130847780, 2131718333, "psapp");
  }
  
  private static ActionSheetItem buildPrint()
  {
    int i = 2130844141;
    if (bjuk.a()) {
      i = 2130844142;
    }
    return build(i, 2131718334, "print");
  }
  
  private static ActionSheetItem buildPrivacy()
  {
    int i = 2130841859;
    if (bjuk.a()) {
      i = 2130841862;
    }
    return build(i, 2131718343, "privacy");
  }
  
  private static ActionSheetItem buildPrivacyCancel()
  {
    int i = 2130841860;
    if (bjuk.a()) {
      i = 2130841861;
    }
    return build(i, 2131718344, "privacy_cancel");
  }
  
  private static ActionSheetItem buildPrivateMessage()
  {
    if (bjuk.a()) {}
    for (int i = 2130849414;; i = 2130849415) {
      return build(i, 2131718259, "private_chat");
    }
  }
  
  private static ActionSheetItem buildPushSetup()
  {
    int i = 2130841297;
    if (bjuk.a()) {
      i = 2130841298;
    }
    return build(i, 2131718346, "push_setup");
  }
  
  private static ActionSheetItem buildQQBrowser()
  {
    int i = 2130846164;
    if (bjuk.a()) {
      i = 2130846165;
    }
    return build(i, 2131718276, "Qbrowser");
  }
  
  private static ActionSheetItem buildQRCode()
  {
    int i = 2130846247;
    if (bjuk.a()) {
      i = 2130846248;
    }
    return build(i, 2131718275, "QRcode");
  }
  
  private static ActionSheetItem buildQZoneAlbum()
  {
    int i = 2130846181;
    if (bjuk.a()) {
      i = 2130846182;
    }
    return build(i, 2131718279, "Qzone_album");
  }
  
  private static ActionSheetItem buildQcirclePrivateMessage()
  {
    if (bjuk.a()) {}
    for (int i = 2130844000;; i = 2130843999) {
      return build(i, 2131718261, "qcircle_private_message");
    }
  }
  
  private static ActionSheetItem buildQidian()
  {
    if (bjuk.a()) {}
    return build(2130844322, 2131718347, "qidian");
  }
  
  private static ActionSheetItem buildQiyeQQ()
  {
    if (bjuk.a()) {}
    return build(2130844323, 2131718348, "qiyeqq");
  }
  
  private static ActionSheetItem buildRemoveColorNote()
  {
    int i = 2130846205;
    if (bjuk.a()) {
      i = 2130846206;
    }
    return build(i, 2131718303, "colornote_cancel");
  }
  
  private static ActionSheetItem buildRemoveFavorite()
  {
    return build(2130847788, 2131718367, "collect_cancel");
  }
  
  private static ActionSheetItem buildRemoveFromMy()
  {
    int i = 2130841302;
    if (bjuk.a()) {
      i = 2130841303;
    }
    return build(i, 2131718349, "remove_my");
  }
  
  private static ActionSheetItem buildRemoveVideoFromTopic()
  {
    if (bjuk.a()) {}
    for (int i = 2130849418;; i = 2130849419) {
      return build(i, 2131718262, "delete_section");
    }
  }
  
  private static ActionSheetItem buildReport()
  {
    int i = 2130846245;
    if (bjuk.a()) {
      i = 2130846246;
    }
    return build(i, 2131718350, "report");
  }
  
  private static ActionSheetItem buildReprintBlog()
  {
    return build(2130847777, 2131718351, "reprint_diary");
  }
  
  private static ActionSheetItem buildReprintPhoto()
  {
    return build(2130847777, 2131718352, "reprint_photo");
  }
  
  private static ActionSheetItem buildRestartMiniApp()
  {
    int i = 2130841294;
    if (bjuk.a()) {
      i = 2130841295;
    }
    return build(i, 2131718353, "restart_applet");
  }
  
  private static ActionSheetItem buildRoomId()
  {
    if (bjuk.a()) {}
    for (int i = 2130849414;; i = 2130849415) {
      return build(i, 2131718254, "copy_roomid");
    }
  }
  
  private static ActionSheetItem buildSafeForward()
  {
    int i = 2130840185;
    if (bjuk.a()) {
      i = 2130844128;
    }
    return build(i, 2131718354, "safe_share");
  }
  
  private static ActionSheetItem buildSave()
  {
    int i = 2130846215;
    if (bjuk.a()) {
      i = 2130846216;
    }
    return build(i, 2131718355, "save");
  }
  
  private static ActionSheetItem buildScanMiniAppCode()
  {
    int i = 2130846231;
    if (bjuk.a()) {
      i = 2130846232;
    }
    return build(i, 2131718356, "scan_appletcode");
  }
  
  private static ActionSheetItem buildScanQRCode()
  {
    int i = 2130846247;
    if (bjuk.a()) {
      i = 2130846248;
    }
    return build(i, 2131718357, "scan_qrcode");
  }
  
  private static ActionSheetItem buildScreenshot()
  {
    if (bjuk.a()) {}
    return build(2130842666, 2131718280, "Screenshot_share");
  }
  
  private static ActionSheetItem buildSendToEvernote()
  {
    return build(2130847775, 2131718311, "Evernote");
  }
  
  private static ActionSheetItem buildSendToFriend()
  {
    int i = 2130846173;
    if (bjuk.a()) {
      i = 2130846174;
    }
    return build(i, 2131718277, "Qfriend");
  }
  
  private static ActionSheetItem buildSendToQZone()
  {
    int i = 2130846179;
    if (bjuk.a()) {
      i = 2130846180;
    }
    return build(i, 2131718278, "Qzone");
  }
  
  private static ActionSheetItem buildSendToWeChat()
  {
    int i = 2130846183;
    if (bjuk.a()) {
      i = 2130846184;
    }
    return build(i, 2131718374, "wechat");
  }
  
  private static ActionSheetItem buildSendToWeChatCircle()
  {
    int i = 2130846185;
    if (bjuk.a()) {
      i = 2130846186;
    }
    return build(i, 2131718375, "wechat_");
  }
  
  private static ActionSheetItem buildSendToWeiYun()
  {
    int i = 2130846187;
    if (bjuk.a()) {
      i = 2130846188;
    }
    return build(i, 2131718377, "weiyun");
  }
  
  private static ActionSheetItem buildSendToWeibo()
  {
    int i = 2130846192;
    if (bjuk.a()) {
      i = 2130846193;
    }
    return build(i, 2131718376, "weibo");
  }
  
  private static ActionSheetItem buildSetBackground()
  {
    return build(2130848350, 2131718360, "set_background");
  }
  
  private static ActionSheetItem buildSetDress()
  {
    return build(2130847784, 2131718361, "set_card");
  }
  
  private static ActionSheetItem buildSetPrivate()
  {
    return build(2130847785, 2131718362, "privacy");
  }
  
  private static ActionSheetItem buildSetTop()
  {
    return build(2130847787, 2131718363, "stick");
  }
  
  private static ActionSheetItem buildSharePicture()
  {
    if (bjuk.a()) {}
    for (int i = 2130849402;; i = 2130849403) {
      return build(i, 2131718263, "sharepicture");
    }
  }
  
  private static ActionSheetItem buildShopManager()
  {
    if (bjuk.a()) {}
    for (int i = 2130849420;; i = 2130849421) {
      return build(i, 2131718264, "store_manage");
    }
  }
  
  private static ActionSheetItem buildShowOpinion()
  {
    int i = 2130841863;
    if (bjuk.a()) {
      i = 2130841864;
    }
    return build(i, 2131718345, "show_opinion");
  }
  
  private static ActionSheetItem buildSyncQzone()
  {
    if (bjuk.a()) {}
    for (int i = 2130849422;; i = 2130849423) {
      return build(i, 2131718265, "Sync_zone");
    }
  }
  
  private static ActionSheetItem buildTribeAddToDigest()
  {
    if (bjuk.a()) {}
    for (int i = 2130843604;; i = 2130843605) {
      return build(i, 2131718266, "add_to_digest");
    }
  }
  
  private static ActionSheetItem buildTribeCancelDigest()
  {
    if (bjuk.a()) {}
    for (int i = 2130843612;; i = 2130843613) {
      return build(i, 2131718267, "cancel_digest");
    }
  }
  
  private static ActionSheetItem buildTribeFeedback()
  {
    if (bjuk.a()) {}
    for (int i = 2130843606;; i = 2130843607) {
      return build(i, 2131718268, "feedback");
    }
  }
  
  private static ActionSheetItem buildTribeInterest()
  {
    if (bjuk.a()) {}
    for (int i = 2130843616;; i = 2130843617) {
      return build(i, 2131718269, "interest");
    }
  }
  
  private static ActionSheetItem buildTribeLookOwner()
  {
    if (bjuk.a()) {}
    for (int i = 2130843608;; i = 2130843609) {
      return build(i, 2131718270, "look_owner");
    }
  }
  
  private static ActionSheetItem buildTribePullBlack()
  {
    if (bjuk.a()) {}
    for (int i = 2130843614;; i = 2130843615) {
      return build(i, 2131718271, "pull_black");
    }
  }
  
  private static ActionSheetItem buildTribePushTopic()
  {
    if (bjuk.a()) {}
    for (int i = 2130843610;; i = 2130843611) {
      return build(i, 2131718272, "push_topics");
    }
  }
  
  private static ActionSheetItem buildUnFollow()
  {
    return build(2130847789, 2131718368, "unfollow");
  }
  
  private static ActionSheetItem buildUnSetTop()
  {
    return build(2130847790, 2131718366, "unstick");
  }
  
  private static ActionSheetItem buildVideoFeedback()
  {
    if (bjuk.a()) {}
    for (int i = 2130849412;; i = 2130849413) {
      return build(i, 2131718273, "play_feedback");
    }
  }
  
  private static ActionSheetItem buildViewDress()
  {
    return build(2130847784, 2131718371, "look_dress");
  }
  
  private static ActionSheetItem buildViewEmoji()
  {
    int i = 2130846207;
    if (bjuk.a()) {
      i = 2130846208;
    }
    return build(i, 2131718358, "search_emotion");
  }
  
  private static ActionSheetItem buildWatchOnTV()
  {
    return build(2130847773, 2131718372, "watch_on_tv");
  }
  
  private static ActionSheetItem buildWatchOriginalVideo()
  {
    int i = 2130849186;
    if (bjuk.a()) {
      i = 2130849187;
    }
    return build(i, 2131718373, "orignal");
  }
  
  public boolean isValidCreate()
  {
    return this.mPendingException == null;
  }
  
  public boolean isValidIcon()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.iconNeedBg)
    {
      if (Arrays.binarySearch(ICON_LIST, this.icon) < 0) {
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
      if (i < LABEL_LIST.length)
      {
        if (TextUtils.equals(this.label, localResources.getString(LABEL_LIST[i]))) {
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