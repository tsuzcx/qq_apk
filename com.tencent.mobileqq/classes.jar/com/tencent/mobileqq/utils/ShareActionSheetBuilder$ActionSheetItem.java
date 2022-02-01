package com.tencent.mobileqq.utils;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import blfw;
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
    ICON_LIST = new int[] { 2130846309, 2130846310, 2130846269, 2130846270, 2130846275, 2130846276, 2130846263, 2130846264, 2130846260, 2130846261, 2130846315, 2130846316, 2130846298, 2130846299, 2130846305, 2130846306, 2130846279, 2130846280, 2130846281, 2130846282, 2130846341, 2130846342, 2130846288, 2130846289, 2130846273, 2130846274, 2130843734, 2130843736, 2130843739, 2130843738, 2130844389, 2130844390, 2130842696, 2130846343, 2130846344, 2130839143, 2130839367, 2130839400, 2130846283, 2130846284, 2130846267, 2130846268, 2130842697, 2130842707, 2130842692, 2130842698, 2130842694, 2130846311, 2130846312, 2130846679, 2130846922, 2130839148, 2130842680, 2130846360, 2130843238, 2130846294, 2130846295, 2130846277, 2130846278, 2130846271, 2130846272, 2130846357, 2130846358, 2130846256, 2130846323, 2130846324, 2130846327, 2130846257, 2130846258, 2130846329, 2130846330, 2130846303, 2130846304, 2130844274, 2130850575, 2130850576, 2130846292, 2130846293, 2130846301, 2130846302, 2130846325, 2130846326, 2130849519, 2130846361, 2130849518, 2130846300, 2130840348, 2130849721, 2130849722, 2130840216, 2130841296, 2130841297, 2130841306, 2130846297, 2130841307, 2130841308, 2130841309, 2130841310, 2130846363, 2130846342, 2130846333, 2130846334, 2130846307, 2130846308, 2130841298, 2130841299, 2130841302, 2130841303, 2130841300, 2130841301, 2130841304, 2130841305, 2130842689, 2130847881, 2130847878, 2130847876, 2130847875, 2130847874, 2130847867, 2130847868, 2130847865, 2130847866, 2130847879, 2130847869, 2130846321, 2130846322, 2130847877, 2130847880, 2130848442, 2130847864, 2130847871, 2130848445, 2130848441, 2130846331, 2130846332, 2130842689, 2130841860, 2130841858, 2130841862, 2130841863, 2130841870, 2130841876, 2130841866, 2130841867, 2130841872, 2130841873, 2130840217, 2130844199, 2130837578, 2130837579, 2130840208, 2130844195, 2130844208, 2130844209, 2130844197, 2130844198, 2130844200, 2130844201, 2130844172, 2130844173, 2130844168, 2130844169, 2130844174, 2130844175, 2130844193, 2130844194, 2130840271, 2130840272, 2130840267, 2130840268, 2130849497, 2130849496, 2130849511, 2130849510, 2130849493, 2130849492, 2130849517, 2130849516, 2130849505, 2130849504, 2130849509, 2130849508, 2130849501, 2130849500, 2130849507, 2130849506, 2130840985, 2130840986, 2130844019, 2130844020, 2130849506, 2130849495, 2130849494, 2130849513, 2130849512, 2130849499, 2130849498, 2130849515, 2130849514, 2130849503, 2130849502, 2130849491, 2130849490, 2130846321, 2130846322, 2130843644, 2130843643, 2130843646, 2130843645, 2130843648, 2130843647, 2130843652, 2130843651, 2130843654, 2130843653, 2130843642, 2130843641, 2130843650, 2130843649, 2130849278, 2130844052, 2130844051, 2130850861, 2130850862, 2130850859, 2130850860 };
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
    LABEL_LIST = new int[] { 2131718712, 2131718733, 2131718734, 2131718663, 2131718664, 2131718665, 2131718703, 2131718738, 2131718763, 2131718709, 2131718760, 2131718761, 2131718762, 2131718751, 2131718662, 2131718717, 2131718732, 2131718711, 2131718713, 2131718756, 2131718671, 2131718715, 2131718744, 2131718742, 2131718743, 2131718672, 2131718735, 2131718682, 2131718739, 2131718674, 2131718673, 2131718679, 2131718677, 2131718680, 2131718678, 2131718681, 2131718693, 2131718688, 2131718689, 2131718661, 2131718676, 2131718718, 2131718741, 2131718675, 2131718745, 2131718690, 2131718666, 2131718670, 2131718669, 2131718667, 2131718755, 2131718736, 2131718716, 2131718686, 2131718687, 2131718707, 2131718708, 2131718740, 2131718720, 2131718691, 2131718692, 2131696967, 2131696970, 2131696973, 2131696972, 2131696135, 2131695016, 2131718753, 2131718705, 2131718704, 2131718706, 2131718701, 2131718754, 2131718759, 2131718721, 2131718668, 2131718697, 2131718710, 2131718696, 2131718748, 2131718749, 2131718752, 2131718747, 2131718757, 2131718737, 2131718714, 2131718683, 2131718694, 2131718758, 2131718719, 2131718685, 2131718746, 2131695016, 2131718723, 2131718722, 2131718724, 2131718725, 2131718728, 2131718731, 2131718726, 2131718727, 2131718729, 2131718730, 2131718699, 2131718698, 2131718700, 2131697899, 2131718730, 2131718721, 2131718668, 2131718730, 2131718639, 2131718660, 2131718642, 2131718648, 2131718659, 2131718641, 2131718645, 2131718640, 2131718646, 2131718645, 2131718643, 2131718649, 2131718651, 2131718644, 2131718638, 2131718650, 2131718702, 2131718652, 2131718653, 2131718655, 2131718656, 2131718658, 2131718657, 2131718654, 2131718684, 2131718695 };
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
      localActionSheetItem1 = build(2130840348, 2131718663, "");
      continue;
      localActionSheetItem1 = build(2130849721, 2131718712, "");
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
      localActionSheetItem1 = build(2130843734, 2131696967, "add_troop_app");
      continue;
      localActionSheetItem1 = build(2130843736, 2131696970, "open_app_detail");
      continue;
      localActionSheetItem1 = build(2130843739, 2131696973, "share_troop_app");
      continue;
      localActionSheetItem1 = build(2130843738, 2131696972, "refresh_troop_app_view");
      continue;
      localActionSheetItem1 = build(2130842692, 2131696135, "share_diandian");
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
    int i = 2130841296;
    if (blfw.a()) {
      i = 2130841297;
    }
    return build(i, 2131718667, "about");
  }
  
  private static ActionSheetItem buildAdBlock()
  {
    int i = 2130840271;
    if (blfw.a()) {
      i = 2130840272;
    }
    return build(i, 2131718668, "ad_block");
  }
  
  private static ActionSheetItem buildAdPromotion()
  {
    int i = 2130840267;
    if (blfw.a()) {
      i = 2130840268;
    }
    return build(i, 2131718721, "ad_promotion");
  }
  
  private static ActionSheetItem buildAddColorNote()
  {
    int i = 2130846292;
    if (blfw.a()) {
      i = 2130846293;
    }
    return build(i, 2131718688, "colornote");
  }
  
  private static ActionSheetItem buildAddEmoji()
  {
    int i = 2130846294;
    if (blfw.a()) {
      i = 2130846295;
    }
    return build(i, 2131718670, "add_emotion");
  }
  
  private static ActionSheetItem buildAddFriend()
  {
    if (blfw.a()) {}
    return build(2130842698, 2131718671, "add_friend");
  }
  
  private static ActionSheetItem buildAddGoods()
  {
    if (blfw.a()) {}
    for (int i = 2130849490;; i = 2130849491) {
      return build(i, 2131718638, "adding goods");
    }
  }
  
  private static ActionSheetItem buildAddShelf()
  {
    int i = 2130841858;
    if (blfw.a()) {
      i = 2130841859;
    }
    return build(i, 2131718722, "add_shelf");
  }
  
  private static ActionSheetItem buildAddShortCut()
  {
    int i = 2130841306;
    if (blfw.a()) {
      i = 2130846297;
    }
    return build(i, 2131718669, "add_desktop");
  }
  
  private static ActionSheetItem buildAddToMy()
  {
    int i = 2130841307;
    if (blfw.a()) {
      i = 2130841308;
    }
    return build(i, 2131718672, "add_my");
  }
  
  private static ActionSheetItem buildAddVideoToTopic()
  {
    if (blfw.a()) {}
    for (int i = 2130849492;; i = 2130849493) {
      return build(i, 2131718639, "addto_section");
    }
  }
  
  private static ActionSheetItem buildAdjustFont()
  {
    int i = 2130846298;
    if (blfw.a()) {
      i = 2130846299;
    }
    return build(i, 2131718675, "adjust_font");
  }
  
  private static ActionSheetItem buildAioLocation()
  {
    int i = 2130846323;
    if (blfw.a()) {
      i = 2130846324;
    }
    return build(i, 2131718676, "aio_position");
  }
  
  private static ActionSheetItem buildBackToHome()
  {
    int i = 2130841298;
    if (blfw.a()) {
      i = 2130841299;
    }
    return build(i, 2131718682, "backtohome");
  }
  
  private static ActionSheetItem buildBarrageSwitchClose()
  {
    int i = 2130846307;
    if (blfw.a()) {
      i = 2130846308;
    }
    return build(i, 2131718686, "close_barrage");
  }
  
  private static ActionSheetItem buildBarrageSwitchOpen()
  {
    int i = 2130846333;
    if (blfw.a()) {
      i = 2130846334;
    }
    return build(i, 2131718716, "open_barrage");
  }
  
  private static ActionSheetItem buildBookDetail()
  {
    int i = 2130841860;
    if (blfw.a()) {
      i = 2130841861;
    }
    return build(i, 2131718723, "book_detail");
  }
  
  private static ActionSheetItem buildBookmark()
  {
    int i = 2130841862;
    if (blfw.a()) {
      i = 2130841865;
    }
    return build(i, 2131718724, "bookmark");
  }
  
  private static ActionSheetItem buildBookmarkCancel()
  {
    int i = 2130841863;
    if (blfw.a()) {
      i = 2130841864;
    }
    return build(i, 2131718725, "bookmark_cancel");
  }
  
  private static ActionSheetItem buildBrowser()
  {
    int i = 2130846263;
    if (blfw.a()) {
      i = 2130846264;
    }
    return build(i, 2131718751, "browser");
  }
  
  private static ActionSheetItem buildCancelOnlySeeFriend()
  {
    return build(2130847867, 2131718683, "no_only_friend");
  }
  
  private static ActionSheetItem buildCartonDetail()
  {
    int i = 2130850859;
    if (blfw.a()) {
      i = 2130850860;
    }
    return build(i, 2131718684, "carton_detail");
  }
  
  private static ActionSheetItem buildCheckProfile()
  {
    int i = 2130846305;
    if (blfw.a()) {
      i = 2130846306;
    }
    return build(i, 2131696155, "check_profile");
  }
  
  private static ActionSheetItem buildChooseFace()
  {
    return build(2130848445, 2131718685, "rec_face");
  }
  
  private static ActionSheetItem buildCloseMiniAppDebug()
  {
    int i = 2130841300;
    if (blfw.a()) {
      i = 2130841301;
    }
    return build(i, 2131718677, "applet_closedebug");
  }
  
  private static ActionSheetItem buildContinuePurchase()
  {
    int i = 2130841866;
    if (blfw.a()) {
      i = 2130841869;
    }
    return build(i, 2131718726, "continue_purchase");
  }
  
  private static ActionSheetItem buildContinuePurchaseCancel()
  {
    int i = 2130841867;
    if (blfw.a()) {
      i = 2130841868;
    }
    return build(i, 2131718727, "continue_purchase_cancel");
  }
  
  private static ActionSheetItem buildCopy()
  {
    int i = 2130846309;
    if (blfw.a()) {
      i = 2130846310;
    }
    return build(i, 2131718690, "copy_link");
  }
  
  private static ActionSheetItem buildCreateLink()
  {
    int i = 2130844197;
    if (blfw.a()) {
      i = 2130844198;
    }
    return build(i, 2131718691, "generate_link");
  }
  
  private static ActionSheetItem buildCreateQr()
  {
    int i = 2130844200;
    if (blfw.a()) {
      i = 2130844201;
    }
    return build(i, 2131718692, "generate_QRcode");
  }
  
  private static ActionSheetItem buildCreateWatchWord()
  {
    if (blfw.a()) {}
    for (int i = 2130849516;; i = 2130849517) {
      return build(i, 2131718660, "kouling_share");
    }
  }
  
  private static ActionSheetItem buildDelete()
  {
    return build(2130848442, 2131718694, "delete");
  }
  
  private static ActionSheetItem buildDeleteFans()
  {
    if (blfw.a()) {}
    for (int i = 2130849508;; i = 2130849509) {
      return build(i, 2131718641, "delete_fans");
    }
  }
  
  private static ActionSheetItem buildDeleteHasPush()
  {
    if (blfw.a()) {}
    for (int i = 2130844020;; i = 2130844019) {
      return build(i, 2131718646, "delete_launch");
    }
  }
  
  private static ActionSheetItem buildDeleteTopic()
  {
    if (blfw.a()) {}
    for (int i = 2130849496;; i = 2130849497) {
      return build(i, 2131718642, "delete_from_section");
    }
  }
  
  private static ActionSheetItem buildDownload()
  {
    int i = 2130850861;
    if (blfw.a()) {
      i = 2130850862;
    }
    return build(i, 2131718695, "download");
  }
  
  private static ActionSheetItem buildEdit()
  {
    return build(2130847865, 2131718696, "edit");
  }
  
  private static ActionSheetItem buildExportTencentDocs()
  {
    int i = 2130850575;
    if (blfw.a()) {
      i = 2130850576;
    }
    return build(i, 2131718756, "url_to_txdoc");
  }
  
  private static ActionSheetItem buildExtractWords()
  {
    int i = 2130846357;
    if (blfw.a()) {
      i = 2130846358;
    }
    return build(i, 2131718718, "pick_words");
  }
  
  private static ActionSheetItem buildFavDetail()
  {
    int i = 2130844168;
    if (blfw.a()) {
      i = 2130844169;
    }
    return build(i, 2131718698, "fav_detail");
  }
  
  private static ActionSheetItem buildFavGroup()
  {
    int i = 2130844172;
    if (blfw.a()) {
      i = 2130844173;
    }
    return build(i, 2131718699, "fav_group");
  }
  
  private static ActionSheetItem buildFavOriginalUrl()
  {
    int i = 2130844174;
    if (blfw.a()) {
      i = 2130844175;
    }
    return build(i, 2131718700, "fav_show_originalurl");
  }
  
  private static ActionSheetItem buildFavorite()
  {
    int i = 2130846315;
    if (blfw.a()) {
      i = 2130846316;
    }
    return build(i, 2131718687, "collect");
  }
  
  private static ActionSheetItem buildFollow()
  {
    return build(2130847877, 2131718701, "follow");
  }
  
  private static ActionSheetItem buildFollowManage()
  {
    if (blfw.a()) {}
    for (int i = 2130841305;; i = 2130841304) {
      return build(i, 2131718702, "follow_manage");
    }
  }
  
  private static ActionSheetItem buildGotoFriendAio()
  {
    if (blfw.a()) {}
    return build(2130842697, 2131694963, "open_aio");
  }
  
  private static ActionSheetItem buildGroupAlbum()
  {
    int i = 2130846271;
    if (blfw.a()) {
      i = 2130846272;
    }
    return build(i, 2131718703, "group_album");
  }
  
  private static ActionSheetItem buildGroupManager()
  {
    if (blfw.a()) {}
    for (int i = 2130849498;; i = 2130849499) {
      return build(i, 2131718643, "fan_group_manage");
    }
  }
  
  private static ActionSheetItem buildHideFeed()
  {
    int i = 2130846321;
    if (blfw.a()) {
      i = 2130846322;
    }
    return build(i, 2131718705, "hide_this_feed");
  }
  
  private static ActionSheetItem buildHideHim()
  {
    return build(2130847869, 2131718706, "hide_him");
  }
  
  private static ActionSheetItem buildHideOpinion()
  {
    int i = 2130841870;
    if (blfw.a()) {
      i = 2130841871;
    }
    return build(i, 2131718728, "hide_opinion");
  }
  
  private static ActionSheetItem buildHideThisWork()
  {
    int i = 2130846321;
    if (blfw.a()) {
      i = 2130846322;
    }
    return build(i, 2131718704, "hide_works");
  }
  
  private static ActionSheetItem buildImportReader()
  {
    int i = 2130840217;
    if (blfw.a()) {
      i = 2130844199;
    }
    return build(i, 2131718707, "Import_reader");
  }
  
  private static ActionSheetItem buildImportTXdoc()
  {
    int i = 2130837578;
    if (blfw.a()) {
      i = 2130837579;
    }
    return build(i, 2131718708, "edit_online");
  }
  
  private static ActionSheetItem buildKandian()
  {
    int i = 2130846273;
    if (blfw.a()) {
      i = 2130846274;
    }
    return build(i, 2131718709, "kandian");
  }
  
  private static ActionSheetItem buildLaunchChat()
  {
    return build(2130847874, 2131718710, "open_aio");
  }
  
  private static ActionSheetItem buildLongscreenshot()
  {
    int i = 2130846325;
    if (blfw.a()) {
      i = 2130846326;
    }
    return build(i, 2131718711, "long_screenshot");
  }
  
  private static ActionSheetItem buildMiniAppClosePerformance()
  {
    int i = 2130841300;
    if (blfw.a()) {
      i = 2130841301;
    }
    return build(i, 2131718678, "applet_closeperformance");
  }
  
  private static ActionSheetItem buildMiniAppOpenPerformance()
  {
    int i = 2130841300;
    if (blfw.a()) {
      i = 2130841301;
    }
    return build(i, 2131718680, "applet_openperformance");
  }
  
  private static ActionSheetItem buildMiniAppToCurrentTroop()
  {
    if (blfw.a()) {}
    for (int i = 2130840986;; i = 2130840985) {
      return build(i, 2131718673, "add_to_group");
    }
  }
  
  private static ActionSheetItem buildMiniAppToTroop()
  {
    if (blfw.a()) {}
    for (int i = 2130840986;; i = 2130840985) {
      return build(i, 2131718674, "group_app");
    }
  }
  
  private static ActionSheetItem buildMoreInfo()
  {
    if (blfw.a()) {}
    for (int i = 2130849500;; i = 2130849501) {
      return build(i, 2131695016, "share_more");
    }
  }
  
  private static ActionSheetItem buildMyComputer()
  {
    int i = 2130846267;
    if (blfw.a()) {
      i = 2130846268;
    }
    return build(i, 2131718745, "sent_pc");
  }
  
  private static ActionSheetItem buildNotCare()
  {
    int i = 2130849518;
    if (blfw.a()) {
      i = 2130846300;
    }
    return build(i, 2131718713, "not_care");
  }
  
  private static ActionSheetItem buildNotInterested()
  {
    int i = 2130846360;
    if (blfw.a()) {
      i = 2130846361;
    }
    return build(i, 2131718755, "uninterested");
  }
  
  private static ActionSheetItem buildOnlySeeFriend()
  {
    int i = 2130846331;
    if (blfw.a()) {
      i = 2130846332;
    }
    return build(i, 2131718714, "only_friend");
  }
  
  private static ActionSheetItem buildOpenAio()
  {
    if (blfw.a()) {}
    return build(2130842697, 2131718715, "open_aio");
  }
  
  private static ActionSheetItem buildOpenFileWithoutDefaultApp()
  {
    int i = 2130844193;
    if (blfw.a()) {
      i = 2130844194;
    }
    return build(i, 2131697899, "other_app");
  }
  
  private static ActionSheetItem buildOpenMiniAppDebug()
  {
    int i = 2130841300;
    if (blfw.a()) {
      i = 2130841301;
    }
    return build(i, 2131718679, "applet_opendebug");
  }
  
  private static ActionSheetItem buildOrderList()
  {
    if (blfw.a()) {}
    for (int i = 2130849502;; i = 2130849503) {
      return build(i, 2131718644, "orderlist");
    }
  }
  
  private static ActionSheetItem buildOtherApp()
  {
    int i = 2130846329;
    if (blfw.a()) {
      i = 2130846330;
    }
    return build(i, 2131718717, "other_app");
  }
  
  private static ActionSheetItem buildPitu()
  {
    return build(2130847871, 2131718719, "psapp");
  }
  
  private static ActionSheetItem buildPrint()
  {
    int i = 2130844208;
    if (blfw.a()) {
      i = 2130844209;
    }
    return build(i, 2131718720, "print");
  }
  
  private static ActionSheetItem buildPrivacy()
  {
    int i = 2130841872;
    if (blfw.a()) {
      i = 2130841875;
    }
    return build(i, 2131718729, "privacy");
  }
  
  private static ActionSheetItem buildPrivacyCancel()
  {
    int i = 2130841873;
    if (blfw.a()) {
      i = 2130841874;
    }
    return build(i, 2131718730, "privacy_cancel");
  }
  
  private static ActionSheetItem buildPrivateMessage()
  {
    if (blfw.a()) {}
    for (int i = 2130849506;; i = 2130849507) {
      return build(i, 2131718645, "private_chat");
    }
  }
  
  private static ActionSheetItem buildPushSetup()
  {
    int i = 2130841304;
    if (blfw.a()) {
      i = 2130841305;
    }
    return build(i, 2131718732, "push_setup");
  }
  
  private static ActionSheetItem buildQQBrowser()
  {
    int i = 2130846260;
    if (blfw.a()) {
      i = 2130846261;
    }
    return build(i, 2131718662, "Qbrowser");
  }
  
  private static ActionSheetItem buildQRCode()
  {
    int i = 2130846343;
    if (blfw.a()) {
      i = 2130846344;
    }
    return build(i, 2131718661, "QRcode");
  }
  
  private static ActionSheetItem buildQZoneAlbum()
  {
    int i = 2130846277;
    if (blfw.a()) {
      i = 2130846278;
    }
    return build(i, 2131718665, "Qzone_album");
  }
  
  private static ActionSheetItem buildQcirclePrivateMessage()
  {
    if (blfw.a()) {}
    for (int i = 2130844052;; i = 2130844051) {
      return build(i, 2131718647, "qcircle_private_message");
    }
  }
  
  private static ActionSheetItem buildQidian()
  {
    if (blfw.a()) {}
    return build(2130844389, 2131718733, "qidian");
  }
  
  private static ActionSheetItem buildQiyeQQ()
  {
    if (blfw.a()) {}
    return build(2130844390, 2131718734, "qiyeqq");
  }
  
  private static ActionSheetItem buildRemoveColorNote()
  {
    int i = 2130846301;
    if (blfw.a()) {
      i = 2130846302;
    }
    return build(i, 2131718689, "colornote_cancel");
  }
  
  private static ActionSheetItem buildRemoveFavorite()
  {
    return build(2130847879, 2131718753, "collect_cancel");
  }
  
  private static ActionSheetItem buildRemoveFromMy()
  {
    int i = 2130841309;
    if (blfw.a()) {
      i = 2130841310;
    }
    return build(i, 2131718735, "remove_my");
  }
  
  private static ActionSheetItem buildRemoveVideoFromTopic()
  {
    if (blfw.a()) {}
    for (int i = 2130849510;; i = 2130849511) {
      return build(i, 2131718648, "delete_section");
    }
  }
  
  private static ActionSheetItem buildReport()
  {
    int i = 2130846341;
    if (blfw.a()) {
      i = 2130846342;
    }
    return build(i, 2131718736, "report");
  }
  
  private static ActionSheetItem buildReprintBlog()
  {
    return build(2130847868, 2131718737, "reprint_diary");
  }
  
  private static ActionSheetItem buildReprintPhoto()
  {
    return build(2130847868, 2131718738, "reprint_photo");
  }
  
  private static ActionSheetItem buildRestartMiniApp()
  {
    int i = 2130841302;
    if (blfw.a()) {
      i = 2130841303;
    }
    return build(i, 2131718739, "restart_applet");
  }
  
  private static ActionSheetItem buildRoomId()
  {
    if (blfw.a()) {}
    for (int i = 2130849506;; i = 2130849507) {
      return build(i, 2131718640, "copy_roomid");
    }
  }
  
  private static ActionSheetItem buildSafeForward()
  {
    int i = 2130840208;
    if (blfw.a()) {
      i = 2130844195;
    }
    return build(i, 2131718740, "safe_share");
  }
  
  private static ActionSheetItem buildSave()
  {
    int i = 2130846311;
    if (blfw.a()) {
      i = 2130846312;
    }
    return build(i, 2131718741, "save");
  }
  
  private static ActionSheetItem buildScanMiniAppCode()
  {
    int i = 2130846327;
    if (blfw.a()) {
      i = 2130846328;
    }
    return build(i, 2131718742, "scan_appletcode");
  }
  
  private static ActionSheetItem buildScanQRCode()
  {
    int i = 2130846343;
    if (blfw.a()) {
      i = 2130846344;
    }
    return build(i, 2131718743, "scan_qrcode");
  }
  
  private static ActionSheetItem buildScreenshot()
  {
    if (blfw.a()) {}
    return build(2130842696, 2131718666, "Screenshot_share");
  }
  
  private static ActionSheetItem buildSendToEvernote()
  {
    return build(2130847866, 2131718697, "Evernote");
  }
  
  private static ActionSheetItem buildSendToFriend()
  {
    int i = 2130846269;
    if (blfw.a()) {
      i = 2130846270;
    }
    return build(i, 2131718663, "Qfriend");
  }
  
  private static ActionSheetItem buildSendToQZone()
  {
    int i = 2130846275;
    if (blfw.a()) {
      i = 2130846276;
    }
    return build(i, 2131718664, "Qzone");
  }
  
  private static ActionSheetItem buildSendToWeChat()
  {
    int i = 2130846279;
    if (blfw.a()) {
      i = 2130846280;
    }
    return build(i, 2131718760, "wechat");
  }
  
  private static ActionSheetItem buildSendToWeChatCircle()
  {
    int i = 2130846281;
    if (blfw.a()) {
      i = 2130846282;
    }
    return build(i, 2131718761, "wechat_");
  }
  
  private static ActionSheetItem buildSendToWeiYun()
  {
    int i = 2130846283;
    if (blfw.a()) {
      i = 2130846284;
    }
    return build(i, 2131718763, "weiyun");
  }
  
  private static ActionSheetItem buildSendToWeibo()
  {
    int i = 2130846288;
    if (blfw.a()) {
      i = 2130846289;
    }
    return build(i, 2131718762, "weibo");
  }
  
  private static ActionSheetItem buildSetBackground()
  {
    return build(2130848441, 2131718746, "set_background");
  }
  
  private static ActionSheetItem buildSetDress()
  {
    return build(2130847875, 2131718747, "set_card");
  }
  
  private static ActionSheetItem buildSetPrivate()
  {
    return build(2130847876, 2131718748, "privacy");
  }
  
  private static ActionSheetItem buildSetTop()
  {
    return build(2130847878, 2131718749, "stick");
  }
  
  private static ActionSheetItem buildSharePicture()
  {
    if (blfw.a()) {}
    for (int i = 2130849494;; i = 2130849495) {
      return build(i, 2131718649, "sharepicture");
    }
  }
  
  private static ActionSheetItem buildShopManager()
  {
    if (blfw.a()) {}
    for (int i = 2130849512;; i = 2130849513) {
      return build(i, 2131718650, "store_manage");
    }
  }
  
  private static ActionSheetItem buildShowOpinion()
  {
    int i = 2130841876;
    if (blfw.a()) {
      i = 2130841877;
    }
    return build(i, 2131718731, "show_opinion");
  }
  
  private static ActionSheetItem buildSyncQzone()
  {
    if (blfw.a()) {}
    for (int i = 2130849514;; i = 2130849515) {
      return build(i, 2131718651, "Sync_zone");
    }
  }
  
  private static ActionSheetItem buildTribeAddToDigest()
  {
    if (blfw.a()) {}
    for (int i = 2130843641;; i = 2130843642) {
      return build(i, 2131718652, "add_to_digest");
    }
  }
  
  private static ActionSheetItem buildTribeCancelDigest()
  {
    if (blfw.a()) {}
    for (int i = 2130843649;; i = 2130843650) {
      return build(i, 2131718653, "cancel_digest");
    }
  }
  
  private static ActionSheetItem buildTribeFeedback()
  {
    if (blfw.a()) {}
    for (int i = 2130843643;; i = 2130843644) {
      return build(i, 2131718654, "feedback");
    }
  }
  
  private static ActionSheetItem buildTribeInterest()
  {
    if (blfw.a()) {}
    for (int i = 2130843653;; i = 2130843654) {
      return build(i, 2131718655, "interest");
    }
  }
  
  private static ActionSheetItem buildTribeLookOwner()
  {
    if (blfw.a()) {}
    for (int i = 2130843645;; i = 2130843646) {
      return build(i, 2131718656, "look_owner");
    }
  }
  
  private static ActionSheetItem buildTribePullBlack()
  {
    if (blfw.a()) {}
    for (int i = 2130843651;; i = 2130843652) {
      return build(i, 2131718657, "pull_black");
    }
  }
  
  private static ActionSheetItem buildTribePushTopic()
  {
    if (blfw.a()) {}
    for (int i = 2130843647;; i = 2130843648) {
      return build(i, 2131718658, "push_topics");
    }
  }
  
  private static ActionSheetItem buildUnFollow()
  {
    return build(2130847880, 2131718754, "unfollow");
  }
  
  private static ActionSheetItem buildUnSetTop()
  {
    return build(2130847881, 2131718752, "unstick");
  }
  
  private static ActionSheetItem buildVideoFeedback()
  {
    if (blfw.a()) {}
    for (int i = 2130849504;; i = 2130849505) {
      return build(i, 2131718659, "play_feedback");
    }
  }
  
  private static ActionSheetItem buildViewDress()
  {
    return build(2130847875, 2131718757, "look_dress");
  }
  
  private static ActionSheetItem buildViewEmoji()
  {
    int i = 2130846303;
    if (blfw.a()) {
      i = 2130846304;
    }
    return build(i, 2131718744, "search_emotion");
  }
  
  private static ActionSheetItem buildWatchOnTV()
  {
    return build(2130847864, 2131718758, "watch_on_tv");
  }
  
  private static ActionSheetItem buildWatchOriginalVideo()
  {
    int i = 2130849278;
    if (blfw.a()) {
      i = 2130849279;
    }
    return build(i, 2131718759, "orignal");
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