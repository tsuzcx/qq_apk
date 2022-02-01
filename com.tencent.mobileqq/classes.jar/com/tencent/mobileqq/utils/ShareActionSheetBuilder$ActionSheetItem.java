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
  public static final int ACTION_ADJUST_FONT_SIZE = 7;
  public static final int ACTION_BARRAGE_CLOSE = 143;
  public static final int ACTION_BARRAGE_OPEN = 142;
  public static final int ACTION_CANCEL_ONLY_SEE_FRIEND = 103;
  public static final int ACTION_CANCEL_PUSH_DISABLE = 167;
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
  public static final int ACTION_FILE_OPEN_WITH_MINIAPP = 166;
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
  public static final int ACTION_REPORT = 11;
  public static final int ACTION_REPORT_DIS_LIKE = 44;
  public static final int ACTION_REPORT_VIDEO_NOT_LIKE = 22;
  public static final int ACTION_REPRINT_BLOG = 101;
  public static final int ACTION_REPRINT_PHOTO = 100;
  public static final int ACTION_RIJ_VIDEO_SETTING = 165;
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
  private static final int[] b = { 2130848055, 2130848056, 2130848015, 2130848016, 2130848021, 2130848022, 2130848007, 2130848008, 2130848004, 2130848005, 2130848061, 2130848062, 2130848044, 2130848045, 2130848051, 2130848052, 2130848025, 2130848026, 2130848027, 2130848028, 2130848087, 2130848088, 2130848034, 2130848035, 2130848019, 2130848020, 2130844779, 2130844781, 2130844784, 2130844783, 2130845858, 2130845859, 2130843695, 2130848089, 2130848090, 2130839218, 2130839480, 2130839515, 2130848029, 2130848030, 2130848011, 2130848012, 2130848013, 2130848014, 2130843696, 2130843706, 2130843691, 2130843697, 2130843693, 2130848057, 2130848058, 2130848452, 2130848685, 2130839223, 2130843679, 2130848107, 2130844266, 2130848040, 2130848041, 2130848023, 2130848024, 2130848017, 2130848018, 2130848104, 2130848105, 2130848000, 2130848069, 2130848070, 2130848073, 2130848074, 2130848001, 2130848002, 2130848075, 2130848076, 2130848049, 2130848050, 2130845687, 2130852790, 2130852791, 2130848038, 2130848039, 2130848047, 2130848048, 2130848071, 2130848072, 2130851501, 2130848108, 2130851500, 2130848046, 2130841060, 2130851811, 2130851812, 2130840471, 2130842105, 2130842106, 2130842115, 2130848043, 2130842116, 2130842117, 2130842118, 2130842119, 2130848112, 2130848088, 2130848079, 2130848080, 2130848053, 2130848054, 2130842107, 2130842108, 2130842111, 2130842112, 2130842109, 2130842110, 2130842113, 2130842114, 2130843688, 2130849773, 2130849770, 2130849768, 2130849767, 2130849766, 2130849759, 2130849760, 2130849757, 2130849758, 2130849771, 2130849761, 2130848067, 2130848068, 2130849769, 2130849772, 2130850344, 2130850345, 2130849756, 2130849763, 2130850348, 2130850343, 2130848077, 2130848078, 2130843688, 2130842818, 2130842816, 2130842820, 2130842821, 2130842828, 2130842834, 2130842824, 2130842825, 2130842830, 2130842831, 2130840472, 2130845612, 2130837689, 2130837690, 2130840463, 2130845608, 2130845621, 2130845622, 2130845610, 2130845611, 2130845613, 2130845614, 2130845577, 2130845578, 2130845573, 2130845574, 2130845579, 2130845580, 2130845606, 2130845607, 2130840563, 2130840564, 2130840559, 2130840560, 2130851499, 2130851498, 2130851487, 2130851486, 2130851491, 2130851490, 2130851483, 2130851482, 2130851489, 2130851488, 2130841783, 2130841784, 2130845054, 2130845053, 2130845052, 2130845051, 2130851488, 2130851479, 2130851478, 2130851493, 2130851492, 2130851481, 2130851480, 2130851495, 2130851494, 2130851485, 2130851484, 2130851477, 2130851476, 2130848067, 2130848068, 2130844689, 2130844688, 2130844691, 2130844690, 2130844693, 2130844692, 2130844697, 2130844696, 2130844699, 2130844698, 2130844687, 2130844686, 2130844695, 2130844694, 2130851239, 2130845248, 2130845247, 2130853459, 2130853460, 2130853457, 2130853458, 2130851335, 2130851336, 2130844296, 2130844295, 2130851497, 2130851496, 2130848110, 2130848111 };
  private static final int[] c;
  private static boolean d = false;
  private IllegalStateException a;
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
    int i = 0;
    Object localObject;
    for (;;)
    {
      localObject = b;
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
          localStringBuilder.append(((Context)localObject).getResources().getResourceEntryName(b[i]));
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
        localHashSet.add(Integer.valueOf(b[i]));
      }
      i += 1;
    }
    Arrays.sort((int[])localObject);
    c = new int[] { 2131916489, 2131916511, 2131916512, 2131916439, 2131916440, 2131916441, 2131916480, 2131916516, 2131916541, 2131916459, 2131916538, 2131916539, 2131916540, 2131916529, 2131916438, 2131916495, 2131916510, 2131916488, 2131916490, 2131916534, 2131916447, 2131916492, 2131916522, 2131916520, 2131916521, 2131916448, 2131916513, 2131916458, 2131916517, 2131916450, 2131916449, 2131916455, 2131916453, 2131916456, 2131916454, 2131916457, 2131916470, 2131916465, 2131916466, 2131916437, 2131916452, 2131916496, 2131916519, 2131916451, 2131916523, 2131896189, 2131916467, 2131916442, 2131916446, 2131916445, 2131916443, 2131916533, 2131916514, 2131916493, 2131916463, 2131916464, 2131916484, 2131916485, 2131916518, 2131916498, 2131916468, 2131916469, 2131895013, 2131895016, 2131895019, 2131895018, 2131894176, 2131892985, 2131916531, 2131916482, 2131916481, 2131916483, 2131916478, 2131916532, 2131916537, 2131916499, 2131916444, 2131916474, 2131916487, 2131916473, 2131916526, 2131916527, 2131916530, 2131916525, 2131916535, 2131916515, 2131916491, 2131916460, 2131916471, 2131916536, 2131916497, 2131916462, 2131916524, 2131892985, 2131916501, 2131916500, 2131916502, 2131916503, 2131916506, 2131916509, 2131916504, 2131916505, 2131916507, 2131916508, 2131916476, 2131916475, 2131916477, 2131896069, 2131916508, 2131916499, 2131916444, 2131916508, 2131916414, 2131916436, 2131916417, 2131916423, 2131916435, 2131916416, 2131916420, 2131916415, 2131916421, 2131916420, 2131916418, 2131916425, 2131916427, 2131916419, 2131916413, 2131916426, 2131916479, 2131916428, 2131916429, 2131916431, 2131916432, 2131916434, 2131916433, 2131916430, 2131916461, 2131916472, 2131915825, 2131915824, 2131894197, 2131916424, 2131916494 };
    localHashSet = new HashSet();
    i = 0;
    for (;;)
    {
      localObject = c;
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
          ((StringBuilder)localObject).append(BaseApplication.getContext().getResources().getResourceEntryName(c[i]));
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
        localHashSet.add(Integer.valueOf(c[i]));
      }
      i += 1;
    }
    Arrays.sort((int[])localObject);
  }
  
  public ShareActionSheetBuilder$ActionSheetItem()
  {
    if (!new java.lang.Throwable().getStackTrace()[1].getClassName().equals(ActionSheetItem.class.getName()))
    {
      this.a = new IllegalStateException("Must use method com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem.build(int) to create me !");
      QLog.e("ShareActionSheetBuilder", 1, "ActionSheetItem: ", this.a);
    }
  }
  
  private static ActionSheetItem A()
  {
    return a(2130849770, 2131916527, "stick");
  }
  
  private static ActionSheetItem B()
  {
    return a(2130849768, 2131916526, "privacy");
  }
  
  private static ActionSheetItem C()
  {
    return a(2130849757, 2131916473, "edit");
  }
  
  private static ActionSheetItem D()
  {
    return a(2130849766, 2131916487, "open_aio");
  }
  
  private static ActionSheetItem E()
  {
    return a(2130849758, 2131916474, "Evernote");
  }
  
  private static ActionSheetItem F()
  {
    int i;
    if (by()) {
      i = 2130850345;
    } else {
      i = 2130850344;
    }
    return a(i, 2131916471, "delete");
  }
  
  private static ActionSheetItem G()
  {
    int i;
    if (by()) {
      i = 2130848052;
    } else {
      i = 2130848051;
    }
    return a(i, 2131894197, "check_profile");
  }
  
  private static ActionSheetItem H()
  {
    int i;
    if (by()) {
      i = 2130851240;
    } else {
      i = 2130851239;
    }
    return a(i, 2131916537, "orignal");
  }
  
  private static ActionSheetItem I()
  {
    return a(2130849772, 2131916532, "unfollow");
  }
  
  private static ActionSheetItem J()
  {
    return a(2130849769, 2131916478, "follow");
  }
  
  private static ActionSheetItem K()
  {
    return a(2130849761, 2131916483, "hide_him");
  }
  
  private static ActionSheetItem L()
  {
    int i;
    if (by()) {
      i = 2130848068;
    } else {
      i = 2130848067;
    }
    return a(i, 2131916482, "hide_this_feed");
  }
  
  private static ActionSheetItem M()
  {
    int i;
    if (by()) {
      i = 2130848068;
    } else {
      i = 2130848067;
    }
    return a(i, 2131916481, "hide_works");
  }
  
  private static ActionSheetItem N()
  {
    return a(2130849771, 2131916531, "collect_cancel");
  }
  
  private static ActionSheetItem O()
  {
    int i;
    if (by()) {
      i = 2130848048;
    } else {
      i = 2130848047;
    }
    return a(i, 2131916466, "colornote_cancel");
  }
  
  private static ActionSheetItem P()
  {
    int i;
    if (by()) {
      i = 2130845578;
    } else {
      i = 2130845577;
    }
    return a(i, 2131916476, "fav_group");
  }
  
  private static ActionSheetItem Q()
  {
    int i;
    if (by()) {
      i = 2130845574;
    } else {
      i = 2130845573;
    }
    return a(i, 2131916475, "fav_detail");
  }
  
  private static ActionSheetItem R()
  {
    int i;
    if (by()) {
      i = 2130845580;
    } else {
      i = 2130845579;
    }
    return a(i, 2131916477, "fav_show_originalurl");
  }
  
  private static ActionSheetItem S()
  {
    int i;
    if (by()) {
      i = 2130842108;
    } else {
      i = 2130842107;
    }
    return a(i, 2131916458, "backtohome");
  }
  
  private static ActionSheetItem T()
  {
    int i;
    if (by()) {
      i = 2130842112;
    } else {
      i = 2130842111;
    }
    return a(i, 2131916517, "restart_applet");
  }
  
  private static ActionSheetItem U()
  {
    int i;
    if (by()) {
      i = 2130842119;
    } else {
      i = 2130842118;
    }
    return a(i, 2131916513, "remove_my");
  }
  
  private static ActionSheetItem V()
  {
    int i;
    if (by()) {
      i = 2130842117;
    } else {
      i = 2130842116;
    }
    return a(i, 2131916448, "add_my");
  }
  
  private static ActionSheetItem W()
  {
    int i;
    if (by()) {
      i = 2130842106;
    } else {
      i = 2130842105;
    }
    return a(i, 2131916443, "about");
  }
  
  private static ActionSheetItem X()
  {
    int i;
    if (by()) {
      i = 2130842110;
    } else {
      i = 2130842109;
    }
    return a(i, 2131916454, "applet_closeperformance");
  }
  
  private static ActionSheetItem Y()
  {
    int i;
    if (by()) {
      i = 2130842110;
    } else {
      i = 2130842109;
    }
    return a(i, 2131916456, "applet_openperformance");
  }
  
  private static ActionSheetItem Z()
  {
    int i;
    if (by()) {
      i = 2130842110;
    } else {
      i = 2130842109;
    }
    return a(i, 2131916453, "applet_closedebug");
  }
  
  private static ActionSheetItem a()
  {
    int i;
    if (QQTheme.isNowThemeIsNight()) {
      i = 2130851496;
    } else {
      i = 2130851497;
    }
    return a(i, 2131916424, "biz_src_kandian_playvideo");
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
    if (by()) {
      i = 2130848043;
    } else {
      i = 2130842115;
    }
    return a(i, 2131916445, "add_desktop");
  }
  
  private static ActionSheetItem aB()
  {
    int i;
    if (by()) {
      i = 2130851336;
    } else {
      i = 2130851335;
    }
    return a(i, 2131916459, "biu");
  }
  
  private static ActionSheetItem aC()
  {
    int i;
    if (by()) {
      i = 2130848035;
    } else {
      i = 2130848034;
    }
    return a(i, 2131916540, "weibo");
  }
  
  private static ActionSheetItem aD()
  {
    int i;
    if (by()) {
      i = 2130848088;
    } else {
      i = 2130848087;
    }
    return a(i, 2131916514, "report");
  }
  
  private static ActionSheetItem aE()
  {
    int i;
    if (by()) {
      i = 2130848080;
    } else {
      i = 2130848079;
    }
    return a(i, 2131916493, "open_barrage");
  }
  
  private static ActionSheetItem aF()
  {
    int i;
    if (by()) {
      i = 2130848054;
    } else {
      i = 2130848053;
    }
    return a(i, 2131916463, "close_barrage");
  }
  
  private static ActionSheetItem aG()
  {
    int i;
    if (by()) {
      i = 2130848028;
    } else {
      i = 2130848027;
    }
    return a(i, 2131916539, "wechat_");
  }
  
  private static ActionSheetItem aH()
  {
    int i;
    if (by()) {
      i = 2130848026;
    } else {
      i = 2130848025;
    }
    return a(i, 2131916538, "wechat");
  }
  
  private static ActionSheetItem aI()
  {
    int i;
    if (by()) {
      i = 2130848045;
    } else {
      i = 2130848044;
    }
    return a(i, 2131916451, "adjust_font");
  }
  
  private static ActionSheetItem aJ()
  {
    int i;
    if (by()) {
      i = 2130848062;
    } else {
      i = 2130848061;
    }
    return a(i, 2131916464, "collect");
  }
  
  private static ActionSheetItem aK()
  {
    int i;
    if (by()) {
      i = 2130848005;
    } else {
      i = 2130848004;
    }
    return a(i, 2131916438, "Qbrowser");
  }
  
  private static ActionSheetItem aL()
  {
    int i;
    if (by()) {
      i = 2130848008;
    } else {
      i = 2130848007;
    }
    return a(i, 2131916529, "browser");
  }
  
  private static ActionSheetItem aM()
  {
    int i;
    if (by()) {
      i = 2130848022;
    } else {
      i = 2130848021;
    }
    return a(i, 2131916440, "Qzone");
  }
  
  private static ActionSheetItem aN()
  {
    int i;
    if (by()) {
      i = 2130848016;
    } else {
      i = 2130848015;
    }
    return a(i, 2131916439, "Qfriend");
  }
  
  private static ActionSheetItem aO()
  {
    int i;
    if (by()) {
      i = 2130848056;
    } else {
      i = 2130848055;
    }
    return a(i, 2131916467, "copy_link");
  }
  
  private static ActionSheetItem aP()
  {
    int i;
    if (by()) {
      i = 2130845612;
    } else {
      i = 2130840472;
    }
    return a(i, 2131916484, "Import_reader");
  }
  
  private static ActionSheetItem aQ()
  {
    int i;
    if (by()) {
      i = 2130837690;
    } else {
      i = 2130837689;
    }
    return a(i, 2131916485, "edit_online");
  }
  
  private static ActionSheetItem aR()
  {
    int i;
    if (by()) {
      i = 2130845608;
    } else {
      i = 2130840463;
    }
    return a(i, 2131916518, "safe_share");
  }
  
  private static ActionSheetItem aS()
  {
    int i;
    if (by()) {
      i = 2130845622;
    } else {
      i = 2130845621;
    }
    return a(i, 2131916498, "print");
  }
  
  private static ActionSheetItem aT()
  {
    int i;
    if (by()) {
      i = 2130845611;
    } else {
      i = 2130845610;
    }
    return a(i, 2131916468, "generate_link");
  }
  
  private static ActionSheetItem aU()
  {
    int i;
    if (by()) {
      i = 2130845607;
    } else {
      i = 2130845606;
    }
    return a(i, 2131896069, "other_app");
  }
  
  private static ActionSheetItem aV()
  {
    int i;
    if (by()) {
      i = 2130845614;
    } else {
      i = 2130845613;
    }
    return a(i, 2131916469, "generate_QRcode");
  }
  
  private static ActionSheetItem aW()
  {
    int i;
    if (by()) {
      i = 2130840560;
    } else {
      i = 2130840559;
    }
    return a(i, 2131916499, "ad_promotion");
  }
  
  private static ActionSheetItem aX()
  {
    int i;
    if (by()) {
      i = 2130840564;
    } else {
      i = 2130840563;
    }
    return a(i, 2131916444, "ad_block");
  }
  
  private static ActionSheetItem aY()
  {
    int i;
    if (by()) {
      i = 2130851498;
    } else {
      i = 2130851499;
    }
    return a(i, 2131916436, "kouling_share");
  }
  
  private static ActionSheetItem aZ()
  {
    int i;
    if (by()) {
      i = 2130851486;
    } else {
      i = 2130851487;
    }
    return a(i, 2131916435, "play_feedback");
  }
  
  private static ActionSheetItem aa()
  {
    int i;
    if (by()) {
      i = 2130842110;
    } else {
      i = 2130842109;
    }
    return a(i, 2131916455, "applet_opendebug");
  }
  
  private static ActionSheetItem ab()
  {
    int i;
    if (by()) {
      i = 2130848072;
    } else {
      i = 2130848071;
    }
    return a(i, 2131916488, "long_screenshot");
  }
  
  private static ActionSheetItem ac()
  {
    int i;
    if (by()) {
      i = 2130848039;
    } else {
      i = 2130848038;
    }
    return a(i, 2131916465, "colornote");
  }
  
  private static ActionSheetItem ad()
  {
    int i;
    if (by()) {
      i = 2130852791;
    } else {
      i = 2130852790;
    }
    return a(i, 2131916534, "url_to_txdoc");
  }
  
  private static ActionSheetItem ae()
  {
    int i;
    if (by()) {
      i = 2130848050;
    } else {
      i = 2130848049;
    }
    return a(i, 2131916522, "search_emotion");
  }
  
  private static ActionSheetItem af()
  {
    int i;
    if (by()) {
      i = 2130848076;
    } else {
      i = 2130848075;
    }
    return a(i, 2131916495, "other_app");
  }
  
  private static ActionSheetItem ag()
  {
    int i;
    if (by()) {
      i = 2130848074;
    } else {
      i = 2130848073;
    }
    return a(i, 2131916520, "scan_appletcode");
  }
  
  private static ActionSheetItem ah()
  {
    int i;
    if (by()) {
      i = 2130848090;
    } else {
      i = 2130848089;
    }
    return a(i, 2131916521, "scan_qrcode");
  }
  
  private static ActionSheetItem ai()
  {
    int i;
    if (by()) {
      i = 2130848070;
    } else {
      i = 2130848069;
    }
    return a(i, 2131916452, "aio_position");
  }
  
  private static ActionSheetItem aj()
  {
    int i;
    if (by()) {
      i = 2130848105;
    } else {
      i = 2130848104;
    }
    return a(i, 2131916496, "pick_words");
  }
  
  private static ActionSheetItem ak()
  {
    int i;
    if (by()) {
      i = 2130848018;
    } else {
      i = 2130848017;
    }
    return a(i, 2131916480, "group_album");
  }
  
  private static ActionSheetItem al()
  {
    int i;
    if (by()) {
      i = 2130848024;
    } else {
      i = 2130848023;
    }
    return a(i, 2131916441, "Qzone_album");
  }
  
  private static ActionSheetItem am()
  {
    int i;
    if (by()) {
      i = 2130848041;
    } else {
      i = 2130848040;
    }
    return a(i, 2131916446, "add_emotion");
  }
  
  private static ActionSheetItem an()
  {
    int i;
    if (by()) {
      i = 2130842114;
    } else {
      i = 2130842113;
    }
    return a(i, 2131916510, "push_setup");
  }
  
  private static ActionSheetItem ao()
  {
    int i;
    if (by()) {
      i = 2130848108;
    } else {
      i = 2130848107;
    }
    return a(i, 2131916533, "uninterested");
  }
  
  private static ActionSheetItem ap()
  {
    int i;
    if (by()) {
      i = 2130848058;
    } else {
      i = 2130848057;
    }
    return a(i, 2131916519, "save");
  }
  
  private static ActionSheetItem aq()
  {
    int i;
    if (by()) {
      i = 2130848046;
    } else {
      i = 2130851500;
    }
    return a(i, 2131916490, "not_care");
  }
  
  private static ActionSheetItem ar()
  {
    by();
    return a(2130843696, 2131892927, "open_aio");
  }
  
  private static ActionSheetItem as()
  {
    by();
    return a(2130843697, 2131916447, "add_friend");
  }
  
  private static ActionSheetItem at()
  {
    by();
    return a(2130843696, 2131916492, "open_aio");
  }
  
  private static ActionSheetItem au()
  {
    int i;
    if (by()) {
      i = 2130848030;
    } else {
      i = 2130848029;
    }
    return a(i, 2131916541, "weiyun");
  }
  
  private static ActionSheetItem av()
  {
    int k;
    int i;
    int j;
    if (QFileAssistantUtils.b())
    {
      k = 2131896189;
      i = 2130848013;
      j = k;
      if (by())
      {
        i = 2130848014;
        j = k;
      }
    }
    else
    {
      k = 2131916523;
      i = 2130848011;
      j = k;
      if (by())
      {
        i = 2130848012;
        j = k;
      }
    }
    return a(i, j, "sent_pc");
  }
  
  private static ActionSheetItem aw()
  {
    int i;
    if (by()) {
      i = 2130848090;
    } else {
      i = 2130848089;
    }
    return a(i, 2131916437, "QRcode");
  }
  
  private static ActionSheetItem ax()
  {
    by();
    return a(2130843695, 2131916442, "Screenshot_share");
  }
  
  private static ActionSheetItem ay()
  {
    by();
    return a(2130845859, 2131916512, "qiyeqq");
  }
  
  private static ActionSheetItem az()
  {
    by();
    return a(2130845858, 2131916511, "qidian");
  }
  
  private static ActionSheetItem b()
  {
    return a(2130844296, 2131915825, "open_viola_barrage");
  }
  
  private static ActionSheetItem ba()
  {
    int i;
    if (by()) {
      i = 2130851490;
    } else {
      i = 2130851491;
    }
    return a(i, 2131916416, "delete_fans");
  }
  
  private static ActionSheetItem bb()
  {
    int i;
    if (by()) {
      i = 2130851482;
    } else {
      i = 2130851483;
    }
    return a(i, 2131892985, "share_more");
  }
  
  private static ActionSheetItem bc()
  {
    int i;
    if (by()) {
      i = 2130851488;
    } else {
      i = 2130851489;
    }
    return a(i, 2131916420, "private_chat");
  }
  
  private static ActionSheetItem bd()
  {
    int i;
    if (by()) {
      i = 2130851488;
    } else {
      i = 2130851489;
    }
    return a(i, 2131916415, "copy_roomid");
  }
  
  private static ActionSheetItem be()
  {
    int i;
    if (by()) {
      i = 2130841784;
    } else {
      i = 2130841783;
    }
    return a(i, 2131916450, "group_app");
  }
  
  private static ActionSheetItem bf()
  {
    int i;
    if (by()) {
      i = 2130841784;
    } else {
      i = 2130841783;
    }
    return a(i, 2131916449, "add_to_group");
  }
  
  private static ActionSheetItem bg()
  {
    int i;
    if (by()) {
      i = 2130845053;
    } else {
      i = 2130845054;
    }
    return a(i, 2131916421, "delete_launch");
  }
  
  private static ActionSheetItem bh()
  {
    int i;
    if (by()) {
      i = 2130845051;
    } else {
      i = 2130845052;
    }
    return a(i, 2131916421, "cancel_push_off");
  }
  
  private static ActionSheetItem bi()
  {
    int i;
    if (by()) {
      i = 2130845248;
    } else {
      i = 2130845247;
    }
    return a(i, 2131916422, "qcircle_private_message");
  }
  
  private static ActionSheetItem bj()
  {
    int i;
    if (by()) {
      i = 2130851492;
    } else {
      i = 2130851493;
    }
    return a(i, 2131916426, "store_manage");
  }
  
  private static ActionSheetItem bk()
  {
    int i;
    if (by()) {
      i = 2130851480;
    } else {
      i = 2130851481;
    }
    return a(i, 2131916418, "fan_group_manage");
  }
  
  private static ActionSheetItem bl()
  {
    int i;
    if (by()) {
      i = 2130851478;
    } else {
      i = 2130851479;
    }
    return a(i, 2131916425, "sharepicture");
  }
  
  private static ActionSheetItem bm()
  {
    int i;
    if (by()) {
      i = 2130851494;
    } else {
      i = 2130851495;
    }
    return a(i, 2131916427, "Sync_zone");
  }
  
  private static ActionSheetItem bn()
  {
    int i;
    if (by()) {
      i = 2130851484;
    } else {
      i = 2130851485;
    }
    return a(i, 2131916419, "orderlist");
  }
  
  private static ActionSheetItem bo()
  {
    int i;
    if (by()) {
      i = 2130851476;
    } else {
      i = 2130851477;
    }
    return a(i, 2131916413, "adding goods");
  }
  
  private static ActionSheetItem bp()
  {
    int i;
    if (by()) {
      i = 2130842114;
    } else {
      i = 2130842113;
    }
    return a(i, 2131916479, "follow_manage");
  }
  
  private static ActionSheetItem bq()
  {
    int i;
    if (by()) {
      i = 2130844686;
    } else {
      i = 2130844687;
    }
    return a(i, 2131916428, "add_to_digest");
  }
  
  private static ActionSheetItem br()
  {
    int i;
    if (by()) {
      i = 2130844694;
    } else {
      i = 2130844695;
    }
    return a(i, 2131916429, "cancel_digest");
  }
  
  private static ActionSheetItem bs()
  {
    int i;
    if (by()) {
      i = 2130844698;
    } else {
      i = 2130844699;
    }
    return a(i, 2131916431, "interest");
  }
  
  private static ActionSheetItem bt()
  {
    int i;
    if (by()) {
      i = 2130844690;
    } else {
      i = 2130844691;
    }
    return a(i, 2131916432, "look_owner");
  }
  
  private static ActionSheetItem bu()
  {
    int i;
    if (by()) {
      i = 2130844692;
    } else {
      i = 2130844693;
    }
    return a(i, 2131916434, "push_topics");
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
    case 134: 
    case 135: 
    case 136: 
    case 139: 
    default: 
      localObject1 = new ActionSheetItem();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("build: notSupportAction = [");
      ((StringBuilder)localObject2).append(paramInt);
      ((StringBuilder)localObject2).append("]");
      QLog.e("ShareActionSheetBuilder", 1, ((StringBuilder)localObject2).toString(), new IllegalArgumentException());
      break;
    case 167: 
      localObject1 = bh();
      break;
    case 166: 
      localObject1 = bx();
      break;
    case 165: 
      localObject1 = a();
      break;
    case 164: 
      localObject1 = c();
      break;
    case 163: 
      localObject1 = b();
      break;
    case 162: 
      localObject1 = bi();
      break;
    case 161: 
      localObject1 = aZ();
      break;
    case 160: 
      localObject1 = bd();
      break;
    case 159: 
      localObject1 = bf();
      break;
    case 158: 
      localObject1 = be();
      break;
    case 157: 
      localObject1 = bj();
      break;
    case 156: 
      localObject1 = bo();
      break;
    case 155: 
      localObject1 = bn();
      break;
    case 154: 
      localObject1 = bm();
      break;
    case 153: 
      localObject1 = bl();
      break;
    case 152: 
      localObject1 = bk();
      break;
    case 151: 
      localObject1 = bw();
      break;
    case 150: 
      localObject1 = bv();
      break;
    case 149: 
      localObject1 = bu();
      break;
    case 148: 
      localObject1 = bt();
      break;
    case 147: 
      localObject1 = bs();
      break;
    case 146: 
      localObject1 = br();
      break;
    case 145: 
      localObject1 = bq();
      break;
    case 144: 
      localObject1 = bp();
      break;
    case 143: 
      localObject1 = aF();
      break;
    case 142: 
      localObject1 = aE();
      break;
    case 141: 
      localObject1 = M();
      break;
    case 140: 
      localObject1 = bg();
      break;
    case 138: 
      localObject1 = bc();
      break;
    case 137: 
      localObject1 = ba();
      break;
    case 133: 
      localObject1 = aY();
      break;
    case 132: 
      localObject1 = aU();
      break;
    case 131: 
      localObject1 = R();
      break;
    case 130: 
      localObject1 = Q();
      break;
    case 129: 
      localObject1 = P();
      break;
    case 128: 
      localObject1 = T();
      break;
    case 125: 
      localObject1 = e();
      break;
    case 124: 
      localObject1 = d();
      break;
    case 123: 
      localObject1 = aV();
      break;
    case 122: 
      localObject1 = aT();
      break;
    case 121: 
      localObject1 = aS();
      break;
    case 120: 
      localObject1 = aR();
      break;
    case 119: 
      localObject1 = aQ();
      break;
    case 118: 
      localObject1 = aP();
      break;
    case 117: 
      localObject1 = o();
      break;
    case 116: 
      localObject1 = n();
      break;
    case 115: 
      localObject1 = m();
      break;
    case 114: 
      localObject1 = l();
      break;
    case 113: 
      localObject1 = k();
      break;
    case 112: 
      localObject1 = j();
      break;
    case 111: 
      localObject1 = i();
      break;
    case 110: 
      localObject1 = h();
      break;
    case 109: 
      localObject1 = g();
      break;
    case 108: 
      localObject1 = f();
      break;
    case 107: 
      localObject1 = p();
      break;
    case 106: 
      localObject1 = q();
      break;
    case 105: 
      localObject1 = r();
      break;
    case 104: 
      localObject1 = s();
      break;
    case 103: 
      localObject1 = t();
      break;
    case 102: 
      localObject1 = u();
      break;
    case 101: 
      localObject1 = v();
      break;
    case 100: 
      localObject1 = w();
      break;
    case 99: 
      localObject1 = x();
      break;
    case 98: 
      localObject1 = y();
      break;
    case 97: 
      localObject1 = z();
      break;
    case 96: 
      localObject1 = A();
      break;
    case 95: 
      localObject1 = B();
      break;
    case 94: 
      localObject1 = C();
      break;
    case 92: 
      localObject1 = D();
      break;
    case 91: 
      localObject1 = E();
      break;
    case 90: 
      localObject1 = aX();
      break;
    case 89: 
      localObject1 = aW();
      break;
    case 88: 
      localObject1 = H();
      break;
    case 87: 
      localObject1 = J();
      break;
    case 86: 
      localObject1 = K();
      break;
    case 85: 
      localObject1 = L();
      break;
    case 84: 
      localObject1 = N();
      break;
    case 82: 
      localObject1 = O();
      break;
    case 81: 
      localObject1 = S();
      break;
    case 80: 
      localObject1 = X();
      break;
    case 79: 
      localObject1 = Y();
      break;
    case 78: 
      localObject1 = W();
      break;
    case 77: 
      localObject1 = U();
      break;
    case 76: 
      localObject1 = V();
      break;
    case 75: 
      localObject1 = Z();
      break;
    case 74: 
      localObject1 = aa();
      break;
    case 73: 
      localObject1 = a(2130851811, 2131916489, "");
      break;
    case 72: 
      localObject1 = a(2130841060, 2131916439, "");
      break;
    case 71: 
      localObject1 = ab();
      break;
    case 70: 
      localObject1 = ac();
      break;
    case 68: 
      localObject1 = ad();
      break;
    case 66: 
      localObject1 = aD();
      break;
    case 65: 
      localObject1 = ae();
      break;
    case 64: 
      localObject1 = af();
      break;
    case 56: 
    case 127: 
      localObject1 = ag();
      break;
    case 55: 
    case 126: 
      localObject1 = ah();
      break;
    case 54: 
      localObject1 = ai();
      break;
    case 52: 
      localObject1 = aj();
      break;
    case 51: 
      localObject1 = ak();
      break;
    case 50: 
      localObject1 = al();
      break;
    case 48: 
      localObject1 = am();
      break;
    case 45: 
    case 83: 
      localObject1 = an();
      break;
    case 44: 
      localObject1 = ao();
      break;
    case 40: 
      localObject1 = F();
      break;
    case 39: 
      localObject1 = ap();
      break;
    case 38: 
      localObject1 = aq();
      break;
    case 37: 
      localObject1 = ar();
      break;
    case 35: 
      localObject1 = as();
      break;
    case 34: 
      localObject1 = a(2130843691, 2131894176, "share_diandian");
      break;
    case 32: 
      localObject1 = I();
      break;
    case 31: 
      localObject1 = bb();
      break;
    case 30: 
      localObject1 = at();
      break;
    case 27: 
      localObject1 = au();
      break;
    case 26: 
      localObject1 = av();
      break;
    case 23: 
      localObject1 = aw();
      break;
    case 22: 
      localObject1 = aZ();
      break;
    case 21: 
      localObject1 = ax();
      break;
    case 20: 
      localObject1 = ay();
      break;
    case 19: 
      localObject1 = az();
      break;
    case 18: 
      localObject1 = a(2130844783, 2131895018, "refresh_troop_app_view");
      break;
    case 17: 
      localObject1 = a(2130844784, 2131895019, "share_troop_app");
      break;
    case 16: 
      localObject1 = a(2130844781, 2131895016, "open_app_detail");
      break;
    case 15: 
      localObject1 = a(2130844779, 2131895013, "add_troop_app");
      break;
    case 14: 
      localObject1 = aA();
      break;
    case 13: 
      localObject1 = aB();
      break;
    case 12: 
      localObject1 = aC();
      break;
    case 11: 
      localObject1 = aD();
      break;
    case 10: 
      localObject1 = aG();
      break;
    case 9: 
      localObject1 = aH();
      break;
    case 8: 
      localObject1 = G();
      break;
    case 7: 
      localObject1 = aI();
      break;
    case 6: 
      localObject1 = aJ();
      break;
    case 5: 
      localObject1 = aK();
      break;
    case 4: 
      localObject1 = aL();
      break;
    case 3: 
      localObject1 = aM();
      break;
    case 2: 
      localObject1 = aN();
      break;
    case 1: 
      localObject1 = aO();
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
  
  public static ActionSheetItem build(int paramInt, boolean paramBoolean)
  {
    d = paramBoolean;
    ActionSheetItem localActionSheetItem = build(paramInt);
    d = false;
    return localActionSheetItem;
  }
  
  private static ActionSheetItem bv()
  {
    int i;
    if (by()) {
      i = 2130844696;
    } else {
      i = 2130844697;
    }
    return a(i, 2131916433, "pull_black");
  }
  
  private static ActionSheetItem bw()
  {
    int i;
    if (by()) {
      i = 2130844688;
    } else {
      i = 2130844689;
    }
    return a(i, 2131916430, "feedback");
  }
  
  private static ActionSheetItem bx()
  {
    int i;
    if (by()) {
      i = 2130848111;
    } else {
      i = 2130848110;
    }
    return a(i, 2131916494, "open_with_miniapp");
  }
  
  private static boolean by()
  {
    return (QQTheme.isNowThemeIsNight()) || (d);
  }
  
  private static ActionSheetItem c()
  {
    return a(2130844295, 2131915824, "close_viola_barrage");
  }
  
  private static ActionSheetItem d()
  {
    int i;
    if (by()) {
      i = 2130853460;
    } else {
      i = 2130853459;
    }
    return a(i, 2131916472, "download");
  }
  
  private static ActionSheetItem e()
  {
    int i;
    if (by()) {
      i = 2130853458;
    } else {
      i = 2130853457;
    }
    return a(i, 2131916461, "carton_detail");
  }
  
  private static ActionSheetItem f()
  {
    int i;
    if (by()) {
      i = 2130842819;
    } else {
      i = 2130842818;
    }
    return a(i, 2131916501, "book_detail");
  }
  
  private static ActionSheetItem g()
  {
    int i;
    if (by()) {
      i = 2130842817;
    } else {
      i = 2130842816;
    }
    return a(i, 2131916500, "add_shelf");
  }
  
  private static ActionSheetItem h()
  {
    int i;
    if (by()) {
      i = 2130842823;
    } else {
      i = 2130842820;
    }
    return a(i, 2131916502, "bookmark");
  }
  
  private static ActionSheetItem i()
  {
    int i;
    if (by()) {
      i = 2130842822;
    } else {
      i = 2130842821;
    }
    return a(i, 2131916503, "bookmark_cancel");
  }
  
  private static ActionSheetItem j()
  {
    int i;
    if (by()) {
      i = 2130842829;
    } else {
      i = 2130842828;
    }
    return a(i, 2131916506, "hide_opinion");
  }
  
  private static ActionSheetItem k()
  {
    int i;
    if (by()) {
      i = 2130842835;
    } else {
      i = 2130842834;
    }
    return a(i, 2131916509, "show_opinion");
  }
  
  private static ActionSheetItem l()
  {
    int i;
    if (by()) {
      i = 2130842827;
    } else {
      i = 2130842824;
    }
    return a(i, 2131916504, "continue_purchase");
  }
  
  private static ActionSheetItem m()
  {
    int i;
    if (by()) {
      i = 2130842826;
    } else {
      i = 2130842825;
    }
    return a(i, 2131916505, "continue_purchase_cancel");
  }
  
  private static ActionSheetItem n()
  {
    int i;
    if (by()) {
      i = 2130842833;
    } else {
      i = 2130842830;
    }
    return a(i, 2131916507, "privacy");
  }
  
  private static ActionSheetItem o()
  {
    int i;
    if (by()) {
      i = 2130842832;
    } else {
      i = 2130842831;
    }
    return a(i, 2131916508, "privacy_cancel");
  }
  
  private static ActionSheetItem p()
  {
    return a(2130850343, 2131916524, "set_background");
  }
  
  private static ActionSheetItem q()
  {
    return a(2130850348, 2131916462, "rec_face");
  }
  
  private static ActionSheetItem r()
  {
    return a(2130849763, 2131916497, "psapp");
  }
  
  private static ActionSheetItem s()
  {
    return a(2130849756, 2131916536, "watch_on_tv");
  }
  
  private static ActionSheetItem t()
  {
    return a(2130849759, 2131916460, "no_only_friend");
  }
  
  private static ActionSheetItem u()
  {
    int i;
    if (by()) {
      i = 2130848078;
    } else {
      i = 2130848077;
    }
    return a(i, 2131916491, "only_friend");
  }
  
  private static ActionSheetItem v()
  {
    return a(2130849760, 2131916515, "reprint_diary");
  }
  
  private static ActionSheetItem w()
  {
    return a(2130849760, 2131916516, "reprint_photo");
  }
  
  private static ActionSheetItem x()
  {
    return a(2130849767, 2131916535, "look_dress");
  }
  
  private static ActionSheetItem y()
  {
    return a(2130849767, 2131916525, "set_card");
  }
  
  private static ActionSheetItem z()
  {
    return a(2130849773, 2131916530, "unstick");
  }
  
  public boolean isValidCreate()
  {
    return this.a == null;
  }
  
  public boolean isValidIcon()
  {
    if (this.iconNeedBg)
    {
      if (Arrays.binarySearch(b, this.icon) >= 0) {
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
      int[] arrayOfInt = c;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem
 * JD-Core Version:    0.7.0.1
 */