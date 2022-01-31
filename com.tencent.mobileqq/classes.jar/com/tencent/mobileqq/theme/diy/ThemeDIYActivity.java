package com.tencent.mobileqq.theme.diy;

import aeqq;
import alof;
import alud;
import amca;
import amdj;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.BitmapFactory.Options;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;
import apko;
import azqs;
import azri;
import baop;
import baoq;
import baoy;
import bapb;
import bdal;
import bdaq;
import bdgm;
import bdgz;
import bdhb;
import bdin;
import bdjz;
import bead;
import beae;
import beag;
import beaj;
import bety;
import bevu;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatBackgroundInfo;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.theme.ThemeUtil.ThemeInfo;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.CallBacker;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.TabBarView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import com.tencent.widget.immersive.SystemBarCompact;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

public class ThemeDIYActivity
  extends IphoneTitleBarActivity
  implements DialogInterface.OnClickListener, View.OnClickListener, baoy
{
  static final int BG_DEFAULT_POSITION = 1;
  static final int BG_UPLOAD_POSITION = 0;
  public static String[] BUNDLE_PAGE_KEY = { "pageDrawer", "pageMessage", "pageAIO", "pageFriend", "pageDynamic" };
  static final int HANDLER_MSG_CHANGE_BLUR_BG = 20;
  static final int HANDLER_MSG_CHANGE_BLUR_BG_CLONE = 1;
  static final int HANDLER_MSG_OPRATE_SAVE = 22;
  static final int HANDLER_MSG_RES_DATA_CHANGED = 21;
  static final int HANDLER_MSG_RES_STYLE_SHOT_CHANGED = 1;
  static final int HANDLER_MSG_SAVE_TIMEOUT = 24;
  static final int HANDLER_MSG_SET_BLUR_BG = 19;
  static final int HANDLER_MSG_SET_PROGRESS_GONE = 26;
  static final int HANDLER_MSG_SET_PROGRESS_TEXT = 25;
  static final int HANDLER_MSG_SHOW_PAGE_BG_INIT = 29;
  static final int HANDLER_MSG_SHOW_TIPS = 28;
  static final int HANDLER_MSG_SHOW_TOAST = 27;
  static final String KEY_FCID = "fcID";
  static final String KEY_TYPE = "funcType";
  static final String KEY_URL = "url";
  public static final int PAGE_AIO = 2;
  public static final int PAGE_DYNAMIC = 4;
  public static final int PAGE_FRIEND = 3;
  public static final int PAGE_MSG = 1;
  public static final int PAGE_SETTING = 0;
  static final int TAB_POSITION_BG = 1;
  static final int TAB_POSITION_STYLE = 3;
  static final String TAG = "ThemeDIYActivity";
  static final int THEME_DEFAULT_POSITION = 0;
  static final int TYPE_JUMP_MSG = 5;
  static final int TYPE_JUMP_URL = 4;
  static final int TYPE_SVIP = 2;
  static final int TYPE_VIP = 1;
  static boolean isBacked;
  protected String aid = "android:mvip.gxh.android.changevoice_";
  HorizontalListView bgResHListView;
  VasQuickUpdateManager.CallBacker callBacker = new ThemeDIYActivity.3(this);
  ThemeDIYActivity.DataLoading dataLoad;
  bdjz exitDialog;
  ResSuitData initStyleRSD;
  boolean isBigScreenType;
  boolean isDIYThemeBefore;
  boolean isNotifyBack = true;
  boolean isVip;
  ThemeDiyBgAdapter mAdapter;
  ArrayList<ResSuitData> mBgSuits = new ArrayList();
  SystemBarCompact mCompactBackup;
  Context mContext;
  int mCurrentPageIndex;
  Bundle mDialogData;
  Handler mHandler = new ThemeDIYActivity.11(this, Looper.getMainLooper());
  AtomicBoolean mIsSaving = new AtomicBoolean(false);
  AtomicBoolean mIsUserClickTab = new AtomicBoolean(true);
  PageView mPageView;
  HorizontalListView mResHListView;
  AtomicBoolean mRunFirstTime = new AtomicBoolean(false);
  int mSaveToServerStatus;
  ScrollLayout mScrollLayout;
  int mStyleSaveStatus;
  int mStyleSetStatus;
  ArrayList<ResSuitData> mStyleSuits = new ArrayList();
  bevu mTypeTabChangeListener = new ThemeDIYActivity.2(this);
  boolean mUpdateUIPicAfterSaved;
  ResSuitData.BgSuit mUploadBgRSD;
  String mUserThemeId;
  String mUserVersion;
  View mblurbgView;
  PageIndicator pageIndicator;
  bety progessDialog;
  bead resDownloadListener = new ThemeDIYActivity.10(this);
  AdapterView.OnItemClickListener resItemClickListener = new ThemeDIYActivity.12(this);
  bapb saveStyleCallback = new ThemeDIYActivity.7(this);
  final ThemeDIYData[] showData = getDiyData();
  HorizontalListView styleResHListView;
  ThemeDiyStyleLogic themeDiyStyleLogic;
  baoq themeSwitchManager;
  ResSuitData tryOnStyleRSD;
  ResSuitData usedStyleRSD;
  
  public static ThemeDIYData[] getDiyData()
  {
    return new ThemeDIYData[] { new ThemeDIYData(2130845638, "theme_bg_setting_path", 2131166492, "theme_bg_setting_path_png", -50, 0), new ThemeDIYData(2130847003, "theme_bg_message_path", 2131166494, "theme_bg_message_path_png", 50, 1), new ThemeDIYData(2130849473, "theme_bg_aio_path", 0, "theme_bg_aio_path", 0, 2), new ThemeDIYData(2130847003, "theme_bg_friend_path", 2131166494, "theme_bg_friend_path_png", 50, 3), new ThemeDIYData(2130849473, "theme_bg_dynamic_path", 2131166494, "theme_bg_dynamic_path_png", 50, 4) };
  }
  
  public static void setSpThemeBackground(Context paramContext, String paramString, ThemeDIYData paramThemeDIYData)
  {
    if (paramThemeDIYData == null) {
      QLog.e("ThemeDIYActivity", 1, "sData is null");
    }
    for (;;)
    {
      return;
      if ((paramThemeDIYData.tryOnBgBigOrgRD == null) || (paramThemeDIYData.tryOnBgBigRD == null) || ("100".equals(paramThemeDIYData.tryOnBgBigOrgRD.id)))
      {
        StringBuilder localStringBuilder;
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder().append("setSpThemeBackground sData.tryOnBgBigOrgRD=").append(paramThemeDIYData.tryOnBgBigOrgRD).append(", sData.tryOnBgBigRD=").append(paramThemeDIYData.tryOnBgBigRD).append(", id=");
          if (paramThemeDIYData.tryOnBgBigOrgRD != null) {
            break label172;
          }
        }
        label172:
        for (String str = "-";; str = paramThemeDIYData.tryOnBgBigOrgRD.id)
        {
          QLog.d("ThemeDIYActivity", 2, str + ", pageIndex:" + paramThemeDIYData.position);
          ThemeBackground.setThemeBackgroundPic(paramContext, paramThemeDIYData.dealSpkey, paramString, "", "", "", "", 1, null, true);
          if (paramThemeDIYData.position != 2) {
            break;
          }
          aeqq.a(paramContext, paramString, null, "null");
          return;
        }
      }
      ThemeBackground.setThemeBackgroundPic(paramContext, paramThemeDIYData.orgSpKey, paramString, paramThemeDIYData.tryOnBgBigOrgRD.path, paramThemeDIYData.tryOnBgBigOrgRD.url, paramThemeDIYData.tryOnBgBigOrgRD.id, "", 1, null, true);
      if (!paramThemeDIYData.orgSpKey.equals(paramThemeDIYData.dealSpkey))
      {
        if ((paramThemeDIYData.tryOnBgBigRD == null) || (paramThemeDIYData.tryOnBgBigRD.state != 5)) {
          break label309;
        }
        ThemeBackground.setThemeBackgroundPic(paramContext, paramThemeDIYData.dealSpkey, paramString, paramThemeDIYData.tryOnBgBigRD.path, paramThemeDIYData.tryOnBgBigOrgRD.url, paramThemeDIYData.tryOnBgBigOrgRD.id, "", 1, null, true);
      }
      while (paramThemeDIYData.position == 2)
      {
        aeqq.a(paramContext, paramString, null, paramThemeDIYData.tryOnBgBigOrgRD.path);
        return;
        label309:
        ThemeBackground.setThemeBackgroundPic(paramContext, paramThemeDIYData.dealSpkey, paramString, paramThemeDIYData.tryOnBgBigOrgRD.path, paramThemeDIYData.tryOnBgBigOrgRD.url, paramThemeDIYData.tryOnBgBigOrgRD.id, "", 1, null, true);
      }
    }
  }
  
  private void vasDownloadBackground()
  {
    int i = 0;
    if (i < this.showData.length)
    {
      ThemeDIYData localThemeDIYData = this.showData[i];
      if ((localThemeDIYData.tryOnBgRSD == null) || (localThemeDIYData.tryOnBgBigOrgRD == null)) {
        QLog.e("ThemeDIYActivity", 1, "vasDownloadBackground Error null, pageIndex:" + i + ", tryOnBgRSD:" + localThemeDIYData.tryOnBgRSD + ", tryOnBgBigOrgRD:" + localThemeDIYData.tryOnBgBigOrgRD);
      }
      for (;;)
      {
        i += 1;
        break;
        if ((!"100".equals(localThemeDIYData.tryOnBgRSD.id)) && (!"99".equals(localThemeDIYData.tryOnBgRSD.id)))
        {
          localThemeDIYData.tryOnBgBigOrgRD.state = 1;
          ChatBackgroundInfo localChatBackgroundInfo = new ChatBackgroundInfo();
          localChatBackgroundInfo.id = localThemeDIYData.tryOnBgBigOrgRD.id;
          localChatBackgroundInfo.url = localThemeDIYData.tryOnBgBigOrgRD.url;
          localChatBackgroundInfo.name = localThemeDIYData.tryOnBgBigOrgRD.name;
          localChatBackgroundInfo.thumbUrl = localThemeDIYData.tryOnBgRSD.thumbnail;
          ((ChatBackgroundManager)this.app.getManager(63)).a(this.app, localChatBackgroundInfo, null);
          if (QLog.isColorLevel()) {
            QLog.e("ThemeDIYActivity", 2, "vasDownloadBackground download id = " + localChatBackgroundInfo.id + " name =  " + localChatBackgroundInfo.name + " url = " + localChatBackgroundInfo.url);
          }
        }
      }
    }
  }
  
  void backgroundSave()
  {
    int i;
    synchronized (this.showData)
    {
      this.mIsSaving.set(true);
      this.mUpdateUIPicAfterSaved = false;
      i = 0;
      if (i >= this.showData.length) {
        break label679;
      }
      ThemeDIYData localThemeDIYData1 = this.showData[i];
      if (2 != localThemeDIYData1.mSetStatus)
      {
        localThemeDIYData1.mSaveStatus = 6;
        if (QLog.isColorLevel()) {
          QLog.d("ThemeDIYActivity", 2, "backgroundSave bg not change:, pageIndex:" + i);
        }
      }
      else if (6 == localThemeDIYData1.mSaveStatus)
      {
        if (!QLog.isColorLevel()) {
          break label2135;
        }
        QLog.d("ThemeDIYActivity", 2, "backgroundSave bg save ok:, pageIndex:" + i);
      }
    }
    Object localObject3;
    Object localObject2;
    label679:
    label864:
    Object localObject4;
    label1150:
    boolean bool2;
    label1163:
    label1198:
    label1355:
    label1372:
    label1401:
    boolean bool1;
    if ((localThemeDIYData2.tryOnBgRSD == null) || (localThemeDIYData2.tryOnBgBigOrgRD == null))
    {
      QLog.e("ThemeDIYActivity", 1, "backgroundSave bg Error null, pageIndex:" + i + ", tryOnBgRSD:" + localThemeDIYData2.tryOnBgRSD + ", tryOnBgBigOrgRD:" + localThemeDIYData2.tryOnBgBigOrgRD);
      localThemeDIYData2.mSaveStatus = 6;
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("ThemeDIYActivity", 2, "backgroundSave bg diyData.tryOnBgRSD.id:" + localThemeDIYData2.tryOnBgRSD.id + ", pageIndex:" + i);
      }
      if ("100".equals(localThemeDIYData2.tryOnBgRSD.id))
      {
        localThemeDIYData2.mSaveStatus = 6;
        if (QLog.isColorLevel()) {
          QLog.d("ThemeDIYActivity", 2, "backgroundSave bg set DIY_DEFAULT_BG_ID:, pageIndex:" + i);
        }
      }
      else
      {
        if ("99".equals(localThemeDIYData2.tryOnBgRSD.id))
        {
          if (localThemeDIYData2.tryOnBgBigRD == null)
          {
            QLog.e("ThemeDIYActivity", 1, "backgroundSave DIY_UPLOAD_BG_ID bg Error null == tryOnBgBigRD, pageIndex:" + i);
            break label2135;
          }
          if (localThemeDIYData2.tryOnBgBigRD.state == 5) {
            localThemeDIYData2.mSaveStatus = 6;
          }
        }
        for (;;)
        {
          if (QLog.isColorLevel())
          {
            QLog.d("ThemeDIYActivity", 2, "backgroundSave bg diyData.mSaveStatus:" + localThemeDIYData2.mSaveStatus + ", pageIndex:" + i + ", tryOnBgBigOrgRD.state:" + localThemeDIYData2.tryOnBgBigOrgRD.state);
            break label2135;
            if (QLog.isColorLevel())
            {
              QLog.d("ThemeDIYActivity", 2, "backgroundSave DIY_UPLOAD_BG_ID:waiting deal, pageIndex:" + i);
              continue;
              localObject3 = new File(localThemeDIYData2.tryOnBgBigOrgRD.path);
              if (((File)localObject3).exists())
              {
                if ((localThemeDIYData2.tryOnBgBigRD == null) || (localThemeDIYData2.tryOnBgBigRD.state != 5)) {
                  dealBgRes(localThemeDIYData2, localThemeDIYData2.tryOnBgBigOrgRD, 115, true);
                } else {
                  localThemeDIYData2.mSaveStatus = 6;
                }
              }
              else if (localThemeDIYData2.tryOnBgBigOrgRD.state == 0)
              {
                localObject2 = new Bundle();
                ((Bundle)localObject2).putInt("index", i);
                ((Bundle)localObject2).putInt("type", 115);
                ((Bundle)localObject2).putInt("nextOperate", 10);
                localObject3 = new beae(localThemeDIYData2.tryOnBgBigOrgRD.url, (File)localObject3);
                ((beag)this.app.getManager(47)).a(1).a((beae)localObject3, this.resDownloadListener, (Bundle)localObject2);
                continue;
                Bundle localBundle;
                amdj localamdj;
                ThemeUtil.ThemeInfo localThemeInfo;
                if ((this.tryOnStyleRSD != null) && (2 == this.mStyleSetStatus)) {
                  if (this.mStyleSaveStatus == 3)
                  {
                    localObject2 = ThemeDiyStyleLogic.getThemeInfoByDensity(this.mContext, (ResSuitData.StyleSuit)this.tryOnStyleRSD);
                    if (localObject2 == null)
                    {
                      QLog.e("ThemeDIYActivity", 1, "backgroundSave, themeInfo=null, oldThemeID:" + this.mUserThemeId + ", tryOnStyleRSD.id:" + this.tryOnStyleRSD.id);
                      this.mHandler.sendMessage(Message.obtain(this.mHandler, 25, alud.a(2131715294) + this.tryOnStyleRSD.id));
                      return;
                    }
                    if (QLog.isColorLevel())
                    {
                      localObject3 = new StringBuilder().append("backgroundSave, deal style, oldThemeID:").append(this.mUserThemeId).append(", newID:");
                      if (localObject2 == null) {
                        break label2142;
                      }
                      localObject1 = ((ThemeUtil.ThemeInfo)localObject2).themeId;
                      QLog.d("ThemeDIYActivity", 2, (String)localObject1);
                    }
                    this.mStyleSaveStatus = 4;
                    if ((this.mUserThemeId == null) || (!this.mUserThemeId.equals(((ThemeUtil.ThemeInfo)localObject2).themeId))) {
                      azqs.b(this.app, "CliOper", "", this.app.getCurrentAccountUin(), "theme_mall", "diy_stylesuccess", 0, 0, "", ((ThemeUtil.ThemeInfo)localObject2).themeId, "", "");
                    }
                  }
                  else
                  {
                    if (this.mStyleSaveStatus != 6) {
                      break label2158;
                    }
                    if (QLog.isColorLevel()) {
                      QLog.d("ThemeDIYActivity", 2, "backgroundSave mStyleSaveStatus ok , mSaveToServerStatus:" + this.mSaveToServerStatus);
                    }
                    if (3 != this.mSaveToServerStatus) {
                      break label2158;
                    }
                    this.mSaveToServerStatus = 4;
                    localBundle = new Bundle();
                    localBundle.putInt("nowOperate", 16);
                    localBundle.putInt("nextOperate", 10);
                    localamdj = (amdj)this.app.a(14);
                    localThemeInfo = ThemeDiyStyleLogic.getThemeInfoByDensity(this.mContext, (ResSuitData.StyleSuit)this.tryOnStyleRSD);
                    localObject1 = this.mUserThemeId;
                    localObject4 = this.mUserVersion;
                    localObject2 = localObject1;
                    localObject3 = localObject4;
                    if (this.tryOnStyleRSD != null)
                    {
                      if (localThemeInfo != null) {
                        break label1355;
                      }
                      QLog.e("ThemeDIYActivity", 1, "backgroundSave, mSaveToServerStatus themeInfo=null, oldThemeID:" + this.mUserThemeId + ", tryOnStyleRSD.id:" + this.tryOnStyleRSD.id);
                      localObject3 = localObject4;
                      localObject2 = localObject1;
                    }
                    localBundle.putString("key_from", "201");
                    i = 0;
                    if (i >= this.showData.length) {
                      break label1401;
                    }
                    if (this.showData[i].tryOnBgRSD == null) {
                      break label1372;
                    }
                  }
                }
                for (localObject1 = this.showData[i].tryOnBgRSD.id;; localObject1 = this.showData[i].usedBgRSD.id)
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("ThemeDIYActivity", 2, "backgroundSave, bg save : index = " + i + ",id=" + (String)localObject1);
                  }
                  localObject4 = localObject1;
                  if (((String)localObject1).equals("custom")) {
                    localObject4 = "99";
                  }
                  localBundle.putString(BUNDLE_PAGE_KEY[i], (String)localObject4);
                  i += 1;
                  break label1163;
                  this.mStyleSaveStatus = 6;
                  azqs.b(this.app, "CliOper", "", this.app.getCurrentAccountUin(), "theme_mall", "diy_stylesuccess", 0, 0, "", ((ThemeUtil.ThemeInfo)localObject2).themeId, "", "");
                  if (!QLog.isColorLevel()) {
                    break;
                  }
                  QLog.d("ThemeDIYActivity", 2, "backgroundSave, style ready!");
                  break;
                  this.mStyleSaveStatus = 6;
                  break;
                  localObject2 = localThemeInfo.themeId;
                  localObject3 = localThemeInfo.version;
                  break label1150;
                  if (this.showData[i].usedBgRSD == null) {
                    break label2150;
                  }
                }
                if (QLog.isColorLevel()) {
                  QLog.d("ThemeDIYActivity", 2, "backgroundSave to save server2.");
                }
                localamdj.a((String)localObject2, (String)localObject3, null, localBundle, this.saveStyleCallback);
                break label2158;
                label1435:
                bool1 = bool2;
                if (i < this.showData.length)
                {
                  if (6 == this.showData[i].mSaveStatus) {
                    break label2170;
                  }
                  if (!QLog.isColorLevel()) {
                    break label2165;
                  }
                  QLog.d("ThemeDIYActivity", 2, "backgroundSave, bg status: iR = " + this.showData[i].mSaveStatus);
                  break label2165;
                }
                label1503:
                if (QLog.isColorLevel()) {
                  QLog.d("ThemeDIYActivity", 2, "backgroundSave, mSaveStatus:isReady=" + bool1 + ", not iR:" + i + ", theme:" + this.mStyleSaveStatus + ", server:" + this.mSaveToServerStatus);
                }
                if ((bool1) && (6 == this.mStyleSaveStatus) && (6 == this.mSaveToServerStatus))
                {
                  i = 0;
                  label1595:
                  if (i < this.showData.length)
                  {
                    localObject2 = this.showData[i];
                    if (2 == ((ThemeDIYData)localObject2).mSetStatus) {
                      if ((((ThemeDIYData)localObject2).tryOnBgRSD != null) && (!"100".equals(((ThemeDIYData)localObject2).tryOnBgRSD.id)))
                      {
                        localObject3 = this.app;
                        localObject4 = this.app.getCurrentAccountUin();
                        if (!"99".equals(((ThemeDIYData)localObject2).tryOnBgRSD.id)) {
                          break label2177;
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    label2047:
    String str;
    label2177:
    for (Object localObject1 = "diy_photosuccess";; str = "diy_yangtusuccess")
    {
      azqs.b((QQAppInterface)localObject3, "CliOper", "", (String)localObject4, "theme_mall", (String)localObject1, 0, 0, String.valueOf(((ThemeDIYData)localObject2).position), String.valueOf(((ThemeDIYData)localObject2).tryOnBgRSD.id), String.valueOf(((ThemeDIYData)localObject2).tryOnBgRSD.from), "");
      setSpThemeBackground(this.mContext, this.app.getAccount(), (ThemeDIYData)localObject2);
      ((ThemeDIYData)localObject2).usedBgRSD = ((ThemeDIYData)localObject2).tryOnBgRSD;
      ((ThemeDIYData)localObject2).mSetStatus = 0;
      i += 1;
      break label1595;
      this.mStyleSetStatus = 0;
      this.mHandler.removeMessages(24);
      azqs.b(this.app, "CliOper", "", this.app.getCurrentAccountUin(), "theme_mall", "diy_savesuccess", 0, 0, "", "", "", "");
      localObject2 = null;
      localObject1 = localObject2;
      if (this.tryOnStyleRSD != null)
      {
        localObject1 = localObject2;
        if ((this.tryOnStyleRSD instanceof ResSuitData.StyleSuit)) {
          localObject1 = ThemeUtil.getThemeInfo(this.mContext, ((ResSuitData.StyleSuit)this.tryOnStyleRSD).id);
        }
      }
      if (localObject1 == null)
      {
        QLog.e("ThemeDIYActivity", 1, "backgroundSave ok, themeInfo=null, oldThemeID:" + this.mUserThemeId);
        if ((localObject1 == null) || (TextUtils.isEmpty(((ThemeUtil.ThemeInfo)localObject1).themeId)) || (((ThemeUtil.ThemeInfo)localObject1).themeId.equals(this.mUserThemeId))) {
          break label2047;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ThemeDIYActivity", 2, "backgroundSave, isSaveDataOk = true, switchThemeTask.execute(" + ((ThemeUtil.ThemeInfo)localObject1).themeId + ", " + ((ThemeUtil.ThemeInfo)localObject1).version + ");");
        }
      }
      for (;;)
      {
        return;
        QLog.d("ThemeDIYActivity", 1, "backgroundSave ok, themeInfo=null, oldThemeID:" + this.mUserThemeId + ", themeInfo.themeId:" + ((ThemeUtil.ThemeInfo)localObject1).themeId);
        break;
        try
        {
          Thread.sleep(1100L);
          label2053:
          localObject1 = new Intent("com.tencent.qplus.THEME_INVALIDATE");
          ((Intent)localObject1).putExtra("pid", Process.myPid());
          this.mContext.sendBroadcast((Intent)localObject1, "com.tencent.msg.permission.pushnotify");
          this.mUpdateUIPicAfterSaved = true;
          if (QLog.isColorLevel())
          {
            QLog.d("ThemeDIYActivity", 2, "backgroundSave, isSaveDataOk = true, dont change theme.");
            continue;
            if (QLog.isColorLevel()) {
              QLog.d("ThemeDIYActivity", 2, "backgroundSave, waiting status.");
            }
          }
        }
        catch (Exception localException)
        {
          break label2053;
        }
      }
      label2135:
      i += 1;
      break;
      label2142:
      str = "null";
      break label864;
      label2150:
      str = "100";
      break label1198;
      label2158:
      bool2 = true;
      i = 0;
      break label1435;
      label2165:
      bool1 = false;
      break label1503;
      label2170:
      i += 1;
      break label1435;
    }
  }
  
  public void blurBg(ResData paramResData, Drawable paramDrawable, int paramInt, boolean paramBoolean)
  {
    ThreadManager.post(new ThemeDIYActivity.13(this, paramDrawable, paramResData, paramInt, paramBoolean), 8, null, true);
  }
  
  void dealBgRes(ThemeDIYData paramThemeDIYData, ResData paramResData, int paramInt, boolean paramBoolean)
  {
    if (paramResData == null) {
      QLog.e("ThemeDIYActivity", 1, "dealBgRes resData == null");
    }
    label200:
    label222:
    do
    {
      return;
      paramThemeDIYData.tryOnBgBigOrgRD = paramResData;
      if (this.tryOnStyleRSD != null)
      {
        localObject = this.tryOnStyleRSD;
        boolean bool = DIYThemeUtils.isNeedDealDarkBright(paramThemeDIYData, (ResSuitData)localObject, null);
        paramResData.state = 5;
        if (!bool) {
          break label222;
        }
        if (!"99".equals(paramResData.id)) {
          break label200;
        }
      }
      for (Object localObject = DIYThemeUtils.getResData(this.app, this.mUploadBgRSD, 120, paramResData.name);; localObject = DIYThemeUtils.getResData(this.app, paramThemeDIYData.tryOnBgRSD, 116, paramResData.name))
      {
        paramThemeDIYData.tryOnBgBigRD = ((ResData)localObject);
        Bundle localBundle = new Bundle();
        localBundle.putInt("index", paramThemeDIYData.position);
        localBundle.putInt("type", paramInt);
        if (paramBoolean)
        {
          paramThemeDIYData.mSaveStatus = 4;
          localBundle.putInt("nextOperate", 10);
        }
        paramThemeDIYData.tryOnBgBigOrgRD.dealedName = ((ResData)localObject).path;
        new ThemeDiyStyleLogic.DarkBrightnessTask(this.mContext, this.app, paramResData.path, ((ResData)localObject).path, paramThemeDIYData, localBundle, this.saveStyleCallback).execute(new Object[0]);
        return;
        localObject = this.usedStyleRSD;
        break;
      }
      paramThemeDIYData.tryOnBgBigOrgRD.state = 5;
      paramThemeDIYData.tryOnBgBigOrgRD.dealedName = paramResData.path;
      paramThemeDIYData.tryOnBgBigRD = paramResData;
    } while (!paramBoolean);
    paramThemeDIYData.mSaveStatus = 6;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 4) && (paramIntent != null) && ("ThemeDIYBgVIP".equals(paramIntent.getStringExtra("callbackSn"))))
    {
      paramIntent = paramIntent.getStringExtra("result");
      paramInt2 = -1;
    }
    for (int j = -1;; j = paramInt1)
    {
      try
      {
        paramIntent = new JSONObject(paramIntent);
        paramInt1 = j;
        int k;
        localException1.printStackTrace();
      }
      catch (Exception localException1)
      {
        try
        {
          i = Integer.parseInt(paramIntent.getString("resultCode"));
          paramInt1 = j;
          paramInt2 = i;
          j = Integer.parseInt(paramIntent.getString("payState"));
          paramInt1 = j;
          paramInt2 = i;
          k = Integer.parseInt(paramIntent.getString("provideState"));
          paramInt1 = k;
          paramInt2 = i;
          i = paramInt1;
          if ((paramIntent != null) && (paramInt2 == 0) && (j == 0) && (i == 0))
          {
            azqs.b(this.app, "CliOper", "", this.app.getCurrentAccountUin(), "theme_mall", "Join_nontop", 0, 1, "", "", "", "");
            this.isVip = true;
            this.mHandler.removeMessages(22);
            this.mIsSaving.set(false);
            this.mHandler.sendMessage(Message.obtain(this.mHandler, 22, Boolean.valueOf(true)));
          }
          return;
        }
        catch (Exception localException2)
        {
          int i;
          break label216;
        }
        localException1 = localException1;
        paramIntent = null;
        paramInt1 = j;
      }
      label216:
      i = -1;
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.mContext = this;
    this.themeDiyStyleLogic = new ThemeDiyStyleLogic(this.app, this);
    this.themeDiyStyleLogic.saveDealCallBack = this.saveStyleCallback;
    isBacked = false;
    super.setContentViewNoTitle(2131562725);
    this.mblurbgView = super.findViewById(2131363348);
    paramBundle = (TextView)super.findViewById(2131368624);
    Object localObject = (TextView)super.findViewById(2131368632);
    paramBundle.setOnClickListener(this);
    ((TextView)localObject).setOnClickListener(this);
    azqs.b(this.app, "CliOper", "", this.app.getCurrentAccountUin(), "theme_mall", "enter_diy2", 0, 0, "", "", "", "");
    this.themeSwitchManager = ((baoq)this.app.getManager(185));
    this.themeSwitchManager.a = this.saveStyleCallback;
    int j = this.mContext.getResources().getDisplayMetrics().heightPixels;
    int k = this.mContext.getResources().getDisplayMetrics().widthPixels;
    if (Math.min(j, k) > 640)
    {
      bool = true;
      this.isBigScreenType = bool;
      paramBundle = new File(ThemeDiyStyleLogic.getDataDIYDir());
      if (!paramBundle.exists()) {
        paramBundle.mkdirs();
      }
      paramBundle = new File(ThemeDiyStyleLogic.getSdcardDIYDir());
      if (!paramBundle.exists()) {
        paramBundle.mkdirs();
      }
      bdhb.c(ThemeDiyStyleLogic.getSdcardDIYDir() + ".nomedia");
      this.isDIYThemeBefore = ThemeUtil.getIsDIYTheme(null);
      if (((amca)this.app.a(13)).g() < 1) {
        break label498;
      }
    }
    int i;
    label498:
    for (boolean bool = true;; bool = false)
    {
      this.isVip = bool;
      paramBundle = ThemeUtil.getCurrentThemeInfo();
      this.mUserThemeId = paramBundle.getString("themeId");
      this.mUserVersion = paramBundle.getString("version");
      if (TextUtils.isEmpty(this.mUserThemeId))
      {
        this.mUserThemeId = ThemeUtil.getUserCurrentThemeId(this.app);
        this.mUserVersion = ThemeUtil.getUserCurrentThemeVersion(this.app);
      }
      if (TextUtils.isEmpty(this.mUserThemeId))
      {
        this.mUserThemeId = "1000";
        this.mUserVersion = "0";
      }
      if ((this.isVip) && ((this.isDIYThemeBefore) || ("1103".equals(this.mUserThemeId)))) {
        break label504;
      }
      i = 0;
      while (i < this.showData.length)
      {
        ThemeBackground.clear(this.mContext, this.showData[i].orgSpKey, this.app.getCurrentAccountUin());
        ThemeBackground.clear(this.mContext, this.showData[i].dealSpkey, this.app.getCurrentAccountUin());
        i += 1;
      }
      bool = false;
      break;
    }
    label504:
    if (QLog.isColorLevel()) {
      QLog.d("ThemeDIYActivity", 2, "isVip:" + this.isVip + ", isDIYThemeBefore:" + this.isDIYThemeBefore + ", themeShow:" + this.mUserThemeId + ", getUserCurrentThemeId:" + ThemeUtil.getUserCurrentThemeId(this.app));
    }
    try
    {
      paramBundle = new HashMap();
      paramBundle.put("param_vipType", String.valueOf(this.isVip));
      paramBundle.put("param_themeUid", ThemeUtil.getUserCurrentThemeId(this.app));
      paramBundle.put("param_themeid", this.mUserThemeId);
      paramBundle.put("param_isDiy", String.valueOf(this.isDIYThemeBefore));
      azri.a(this.mContext).a(this.app.getAccount(), "ThemeDIYActivityRun", true, 1L, 0L, paramBundle, "", false);
      label674:
      this.mScrollLayout = ((ScrollLayout)super.findViewById(2131361804));
      this.mScrollLayout.setOnScreenChangeListener(this);
      paramBundle = new ResSuitData.StyleSuit();
      this.mStyleSuits.add(paramBundle);
      paramBundle.id = "999";
      paramBundle.name = alud.a(2131715280);
      paramBundle.thumbnail = "a.jpg";
      paramBundle.appStr = "theme";
      paramBundle.typeStr = "diytheme_new";
      paramBundle.setFrontImg = "2a3520aef79e964d7197732a30f7a6a1.png";
      paramBundle.msgFrontImg = "f88ad0bc2bdda4ab29c666bca8fff888.png";
      paramBundle.chatFrontImg = "89abd3472c9f74886512d339de051019.png";
      if ("999".equals(this.mUserThemeId))
      {
        this.tryOnStyleRSD = paramBundle;
        this.usedStyleRSD = paramBundle;
      }
      if (!this.isDIYThemeBefore) {
        this.tryOnStyleRSD = paramBundle;
      }
      this.mUploadBgRSD = new ResSuitData.BgSuit(null);
      this.mUploadBgRSD.id = "99";
      this.mUploadBgRSD.resID = 2130845683;
      this.mUploadBgRSD.name = alud.a(2131715284);
      ApngImage.playByTag(0);
      int m = (int)(Math.max(j, k) - bdgz.a(this.mContext, 305));
      int n = m * 322 / 572;
      LayoutInflater localLayoutInflater = LayoutInflater.from(this.mContext);
      ResData localResData = new ResData();
      SharedPreferences localSharedPreferences = ThemeBackground.getSharedPreferences(this.mContext, this.app.getAccount(), 0);
      i = 0;
      if (i < this.showData.length)
      {
        PageView localPageView = (PageView)localLayoutInflater.inflate(2131562726, null);
        localPageView.init(this.showData[i], i, n, m, null);
        if (i == 0) {
          this.mPageView = localPageView;
        }
        paramBundle = new ResSuitData.BgSuit(null);
        paramBundle.id = "100";
        paramBundle.resID = this.showData[i].themeBgID;
        paramBundle.name = alud.a(2131715286);
        this.showData[i].defaultBgRSD = paramBundle;
        k = 0;
        ThemeBackground localThemeBackground = new ThemeBackground();
        localThemeBackground.isDecodeInDiy = true;
        label1104:
        ResSuitData.BgSuit localBgSuit;
        if (2 == i)
        {
          localThemeBackground.path = ((ChatBackgroundManager)this.app.getManager(63)).b(null);
          j = k;
          if (!"null".equals(localThemeBackground.path))
          {
            localThemeBackground.img = getLocalDrawable(localThemeBackground.path);
            j = k;
          }
          if ((TextUtils.isEmpty(localThemeBackground.path)) || ("null".equals(localThemeBackground.path))) {
            break label1683;
          }
          localBgSuit = new ResSuitData.BgSuit(null);
          localObject = localThemeBackground.path.substring(localThemeBackground.path.lastIndexOf(File.separator) + 1);
          if (localThemeBackground.path.indexOf(alof.cd) < 0) {
            break label1663;
          }
          paramBundle = (ChatBackgroundManager)this.app.getManager(63);
          paramBundle = ChatBackgroundManager.d(localThemeBackground.path);
          localBgSuit.resData = new ResData();
          localBgSuit.resData.path = localThemeBackground.path;
          localBgSuit.resData.id = paramBundle;
          localBgSuit.resData.url = localSharedPreferences.getString(this.showData[i].orgSpKey + "_url", "");
          localBgSuit.feeType = localSharedPreferences.getInt(this.showData[i].orgSpKey + "_feetype", 1);
          localObject = localBgSuit.resData;
          String str = localSharedPreferences.getString(this.showData[i].orgSpKey + "_name", paramBundle);
          ((ResData)localObject).name = str;
          localBgSuit.name = str;
          this.showData[i].initBgRSD = localBgSuit;
          label1389:
          if (!TextUtils.isEmpty(paramBundle)) {
            break label1677;
          }
          localObject = "0";
          label1401:
          localBgSuit.id = ((String)localObject);
          this.showData[i].usedBgRSD = localBgSuit;
          if (i == 0)
          {
            localResData.path = localThemeBackground.path;
            localResData.id = paramBundle;
          }
          label1439:
          if (j != 0) {
            ThreadManager.post(new ThemeDIYActivity.1(this, this.showData[i].orgSpKey, localThemeBackground, i), 8, null, true);
          }
          localPageView.showPic(this.showData[i].usedBgRSD, null, false, localThemeBackground.img);
          paramBundle = new ThemeDIYActivity.ViewHolder();
          paramBundle.id = i;
          paramBundle.scaleView = localPageView.findViewById(2131369279);
          localPageView.setTag(paramBundle);
          if (i != 0) {
            break label1742;
          }
          this.mScrollLayout.changeAlpha(localPageView, false, 800);
          if (!"100".equals(this.showData[i].usedBgRSD.id)) {
            break label1718;
          }
          blurBg(localResData, this.mPageView.bgDrawable, 1, false);
        }
        for (;;)
        {
          this.mScrollLayout.addView(localPageView);
          i += 1;
          break;
          j = k;
          if (!this.isDIYThemeBefore) {
            break label1104;
          }
          localThemeBackground.path = localSharedPreferences.getString(this.showData[i].orgSpKey, "null");
          j = k;
          if (TextUtils.isEmpty(localThemeBackground.path)) {
            break label1104;
          }
          j = k;
          if ("null".equals(localThemeBackground.path)) {
            break label1104;
          }
          j = 1;
          break label1104;
          label1663:
          paramBundle = "99";
          localBgSuit.aioImg = ((String)localObject);
          break label1389;
          label1677:
          localObject = paramBundle;
          break label1401;
          label1683:
          this.showData[i].usedBgRSD = paramBundle;
          if (i != 0) {
            break label1439;
          }
          localResData.id = paramBundle.id;
          localResData.resID = paramBundle.resID;
          break label1439;
          label1718:
          if (localThemeBackground.img != null)
          {
            blurBg(localResData, localThemeBackground.img, 1, true);
            continue;
            label1742:
            this.mScrollLayout.changeAlpha(localPageView, true, 800);
          }
        }
      }
      this.pageIndicator = ((PageIndicator)super.findViewById(2131368230));
      this.pageIndicator.bindScrollViewGroup(this.mScrollLayout);
      this.dataLoad = new ThemeDIYActivity.DataLoading(this);
      this.dataLoad.bindScrollViewGroup(this.mScrollLayout);
      paramBundle = (TabBarView)super.findViewById(2131377028);
      paramBundle.setUnderLineHeight(bdaq.a(this, 4.0F));
      paramBundle.setTabTextSize(16);
      paramBundle.setUnselectColor(-8882056);
      paramBundle.setSelectColor(super.getResources().getColor(2131165307));
      paramBundle.setUnselectColor(super.getResources().getColor(2131165307));
      paramBundle.a.setColor(super.getResources().getColor(2131166495));
      paramBundle.a("");
      paramBundle.a(alud.a(2131715300));
      paramBundle.a("");
      paramBundle.a(alud.a(2131715291));
      paramBundle.a("");
      paramBundle.setSelectedTab(1, false);
      paramBundle.setOnTabChangeListener(this.mTypeTabChangeListener);
      paramBundle.setBackgroundDrawable(super.getResources().getDrawable(2130847003));
      this.mResHListView = ((HorizontalListView)super.findViewById(2131377803));
      this.mAdapter = new ThemeDiyBgAdapter(this);
      this.mAdapter.themeDIYData = this.mPageView.mData;
      this.mAdapter.isDIYThemeBefore = this.isDIYThemeBefore;
      this.mResHListView.setAdapter(this.mAdapter);
      this.mResHListView.setOnItemClickListener(this.resItemClickListener);
      this.mIsUserClickTab.set(false);
      this.mTypeTabChangeListener.onTabSelected(1, 1);
      this.mAdapter.tryOnStyleRSD = this.tryOnStyleRSD;
      this.mAdapter.usedStyleRSD = this.usedStyleRSD;
      loadResJson(100, false);
      loadResJson(200, false);
      baop.a(this.app, "theme_detail", "201", 150, bdin.a(null), 1, this.mUserThemeId, ThemeUtil.getUserCurrentThemeVersion(this.app), "2", "");
      this.mCompactBackup = this.mSystemBarComp;
      this.mSystemBarComp = null;
      new SystemBarCompact(this, true, -5986905).init();
      return true;
    }
    catch (Exception paramBundle)
    {
      break label674;
    }
  }
  
  public void doOnDestroy()
  {
    this.mSystemBarComp = this.mCompactBackup;
    this.mHandler.removeMessages(24);
    this.themeSwitchManager.a = null;
    if (this.app != null) {
      ((VasQuickUpdateManager)this.app.getManager(184)).removeCallBacker(this.callBacker);
    }
    super.doOnDestroy();
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    this.mUpdateUIPicAfterSaved = false;
    if (paramIntent == null) {}
    for (paramIntent = null; !TextUtils.isEmpty(paramIntent); paramIntent = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH"))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ThemeDIYActivity", 2, "doOnNewIntent ok filePath:" + paramIntent);
      }
      Object localObject = paramIntent.substring(paramIntent.lastIndexOf(File.separator) + 1);
      localObject = DIYThemeUtils.getResData(this.app, this.mUploadBgRSD, 121, (String)localObject);
      ((ResData)localObject).path = paramIntent;
      this.mPageView.mData.tryOnBgRSD = this.mUploadBgRSD;
      setListItemStatus(this.bgResHListView, this.mUploadBgRSD, this.mPageView.mData.usedBgRSD, null);
      dealBgRes(this.mPageView.mData, (ResData)localObject, 121, false);
      this.mPageView.showPic(this.mUploadBgRSD, (ResData)localObject, true, null);
      this.mPageView.mData.mSetStatus = 2;
      return;
    }
    QLog.e("ThemeDIYActivity", 1, "doOnNewIntent filePath:" + paramIntent);
  }
  
  Drawable getLocalDrawable(String paramString)
  {
    File localFile = new File(paramString);
    if ((localFile.exists()) && (!ChatBackgroundManager.a(localFile)))
    {
      paramString = bdal.a(paramString, new BitmapFactory.Options());
      if (paramString != null) {
        return new apko(this.mContext.getResources(), paramString);
      }
    }
    return null;
  }
  
  void gotoOpenQQVip(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("userId", this.app.getCurrentAccountUin());
      localJSONObject.put("openMonth", paramInt);
      localJSONObject.put("aid", "mvip.gexinghua.android.theme_diy2");
      localJSONObject.put("offerId", paramString3);
      localJSONObject.put("serviceName", paramString1);
      localJSONObject.put("serviceCode", paramString2);
      PayBridgeActivity.tenpay(this, localJSONObject.toString(), 4, "ThemeDIYBgVIP");
      return;
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  boolean isNeedSave()
  {
    boolean bool = false;
    int i = 0;
    if (i < this.showData.length) {
      if (2 == this.showData[i].mSetStatus) {
        bool = true;
      }
    }
    while (2 != this.mStyleSetStatus)
    {
      return bool;
      i += 1;
      break;
    }
    return true;
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  void loadResJson(int paramInt, boolean paramBoolean)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("loadResJson into ifbg=");
      if (100 != paramInt) {
        break label72;
      }
    }
    label72:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("ThemeDIYActivity", 2, bool + ", ifAfterDownladed:" + paramBoolean);
      ThreadManager.post(new ThemeDIYActivity.4(this, paramInt, paramBoolean), 8, null, true);
      return;
    }
  }
  
  public boolean onBackEvent()
  {
    
    int i;
    if (this.mIsSaving.get()) {
      i = 0;
    }
    for (;;)
    {
      if (i < this.showData.length)
      {
        if (6 != this.showData[i].mSaveStatus) {
          QLog.d("ThemeDIYActivity", 2, "onBackEvent Operate_wait i=" + i);
        }
      }
      else
      {
        if (6 != this.mStyleSaveStatus) {
          QLog.d("ThemeDIYActivity", 2, "onBackEvent Operate_wait deal style.");
        }
        if (6 != this.mSaveToServerStatus) {
          QLog.d("ThemeDIYActivity", 2, "onBackEvent Operate_wait mSaveToServerStatus waiting.");
        }
        this.mIsSaving.set(false);
        if ((this.exitDialog == null) || (!this.exitDialog.isShowing())) {
          break;
        }
        this.exitDialog.dismiss();
        this.exitDialog = null;
        return true;
      }
      i += 1;
    }
    if (this.isNotifyBack)
    {
      azqs.b(this.app, "CliOper", "", this.app.getCurrentAccountUin(), "theme_mall", "diy_out", 0, 0, "", "", "", "");
      if (isNeedSave()) {
        try
        {
          this.exitDialog = bdgm.a(this.mContext, 230, super.getResources().getString(2131720825), alud.a(2131715299), 2131692278, 2131719310, new ThemeDIYActivity.8(this), new ThemeDIYActivity.9(this));
          this.exitDialog.show();
          return true;
        }
        catch (Exception localException)
        {
          QLog.e("ThemeDIYActivity", 1, localException.getMessage());
        }
      }
      azqs.b(this.app, "CliOper", "", this.app.getCurrentAccountUin(), "theme_mall", "diy_outsuccess", 0, 1, "0", "", "", "");
    }
    super.onBackEvent();
    return false;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    int i = 1;
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
    if (this.mDialogData == null) {
      return;
    }
    int j = this.mDialogData.getInt("funcType", 4);
    paramDialogInterface = this.mDialogData.getString("url");
    this.mDialogData.getInt("fcID", 0);
    if (QLog.isColorLevel()) {
      QLog.d("ThemeDIYActivity", 1, "DialogInterface funcType=" + j + ", url:" + paramDialogInterface);
    }
    String str;
    Object localObject;
    if ((1 == j) || (2 == j))
    {
      if (paramInt != 1) {
        break label382;
      }
      str = "LTMCLUB";
      localObject = "QQ会员";
      paramDialogInterface = "1450000515";
      paramInt = i;
      if (2 == j)
      {
        str = "CJCLUBT";
        localObject = alud.a(2131715295);
        paramDialogInterface = "1450000516";
        paramInt = 2;
      }
      gotoOpenQQVip(3, (String)localObject, str, paramDialogInterface);
    }
    for (;;)
    {
      azqs.b(this.app, "CliOper", "", this.app.getCurrentAccountUin(), "theme_mall", "diy_save_tips", 0, 0, String.valueOf(paramInt), "", "", "");
      return;
      if (5 == j)
      {
        localObject = this.app;
        str = this.app.getCurrentAccountUin();
        if (paramInt == 1) {}
        for (paramDialogInterface = "diy_check";; paramDialogInterface = "diy_check_no")
        {
          azqs.b((QQAppInterface)localObject, "CliOper", "", str, "theme_mall", paramDialogInterface, 0, 1, "", "", "", "");
          if (paramInt != 1) {
            break;
          }
          paramDialogInterface = new Intent();
          paramDialogInterface.setClass(this.mContext, SplashActivity.class);
          paramDialogInterface.setFlags(603979776);
          paramDialogInterface.putExtra("main_tab_id", 1);
          this.mContext.startActivity(paramDialogInterface);
          return;
        }
      }
      if ((paramInt != 1) || (TextUtils.isEmpty(paramDialogInterface))) {
        break;
      }
      localObject = new Intent(this.mContext, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", paramDialogInterface);
      ((Intent)localObject).putExtra("isShowAd", false);
      this.mContext.startActivity((Intent)localObject);
      return;
      label382:
      paramInt = 0;
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131368624: 
      onBackEvent();
      return;
    }
    saveOperate(true);
    azqs.b(this.app, "CliOper", "", this.app.getCurrentAccountUin(), "theme_mall", "diy_save", 0, 0, "", "", "", "");
  }
  
  public void onPostThemeChanged()
  {
    int i = 0;
    if (i < this.mScrollLayout.getChildCount())
    {
      Object localObject;
      if (this.mCurrentPageIndex != i)
      {
        localObject = this.mScrollLayout.getChildAt(i);
        if ((localObject != null) && ((((View)localObject).getTag() instanceof ThemeDIYActivity.ViewHolder))) {
          break label51;
        }
      }
      for (;;)
      {
        i += 1;
        break;
        label51:
        localObject = (ThemeDIYActivity.ViewHolder)((View)localObject).getTag();
        ((ThemeDIYActivity.ViewHolder)localObject).scale += 0.01F;
        this.mScrollLayout.changeAlpha(this.mScrollLayout.getChildAt(i), true, 500);
      }
    }
    if ((this.mNeedStatusTrans) && (this.mSystemBarComp != null))
    {
      i = super.getResources().getColor(2131166959);
      this.mSystemBarComp.setStatusColor(i);
      this.mSystemBarComp.setStatusBarColor(i);
    }
    setProgessDialog(false, 0);
    setListItemStatus(this.styleResHListView, this.tryOnStyleRSD, this.usedStyleRSD, null);
    setListItemStatus(this.bgResHListView, this.mPageView.mData.tryOnBgRSD, this.mPageView.mData.usedBgRSD, null);
    this.themeSwitchManager.c();
    if (QLog.isColorLevel()) {
      QLog.d("ThemeDIYActivity", 2, "onPostThemeChanged mIsSaving=" + this.mIsSaving.get());
    }
    if (this.mIsSaving.get()) {
      showTips(5, 0, null, alud.a(2131715287), null, alud.a(2131715281), null);
    }
    this.mIsSaving.set(false);
    this.isDIYThemeBefore = true;
    this.mAdapter.isDIYThemeBefore = this.isDIYThemeBefore;
    this.mUserThemeId = ThemeUtil.getCurrentThemeId();
  }
  
  public void onScreenChange(int paramInt)
  {
    azqs.b(this.app, "CliOper", "", this.app.getCurrentAccountUin(), "theme_mall", "skim_page2", 0, 0, String.valueOf(paramInt), "", "", "");
    if (QLog.isColorLevel()) {
      QLog.d("ThemeDIYActivity", 2, "onScreenChange: pageIndex = " + String.valueOf(paramInt));
    }
    View localView = this.mScrollLayout.getChildAt(paramInt);
    if ((localView == null) || (!(localView instanceof PageView)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ThemeDIYActivity", 2, "onScreenChange: view == null");
      }
      return;
    }
    if ((this.mCurrentPageIndex != paramInt) && (this.bgResHListView != null)) {}
    synchronized (this.mAdapter.mData)
    {
      if ((this.mAdapter.getItem(1) == this.showData[this.mCurrentPageIndex].defaultBgRSD) && (this.showData[this.mCurrentPageIndex].defaultBgRSD != null))
      {
        this.mAdapter.mData.remove(1);
        if (this.mAdapter.mData.size() > 1) {
          this.mAdapter.mData.add(1, this.showData[paramInt].defaultBgRSD);
        }
      }
      else
      {
        setListItemStatus(this.bgResHListView, this.showData[paramInt].tryOnBgRSD, this.showData[paramInt].usedBgRSD, this.showData[paramInt].defaultBgRSD);
        this.mAdapter.themeDIYData = this.showData[paramInt];
        this.mPageView = ((PageView)localView);
        if ((this.bgResHListView != null) && (((this.showData[this.mCurrentPageIndex].initBgRSD == null) && (this.showData[paramInt].initBgRSD != null)) || ((this.showData[this.mCurrentPageIndex].initBgRSD != null) && (this.showData[paramInt].initBgRSD == null)) || ((this.showData[this.mCurrentPageIndex].initBgRSD != null) && (this.showData[paramInt].initBgRSD != null) && (!this.showData[this.mCurrentPageIndex].initBgRSD.id.equals(this.showData[paramInt].initBgRSD.id))))) {
          this.mHandler.sendMessage(Message.obtain(this.mHandler, 21, 0, 0));
        }
        this.mCurrentPageIndex = paramInt;
        this.pageIndicator.generatePageControl(paramInt);
        if ((this.mPageView.bgDrawable != null) && (this.mPageView.needBlur)) {
          break label505;
        }
        this.mHandler.sendMessage(Message.obtain(this.mHandler, 20, this.mPageView.bgDrawable));
        return;
      }
      this.mAdapter.mData.add(this.showData[paramInt].defaultBgRSD);
    }
    label505:
    this.mPageView.needBlur = false;
    blurBg(null, this.mPageView.bgDrawable, 1, true);
  }
  
  public void onUpdate(Object paramObject)
  {
    paramObject = (Bundle)paramObject;
    if (paramObject == null)
    {
      QLog.e("ThemeDIYActivity", 1, "onUpdate data = null");
      return;
    }
    int j = paramObject.getInt("result_int", 0);
    Object localObject = paramObject.getString("message");
    String str2 = paramObject.getString("svr_url");
    String str1 = paramObject.getString("svr_actStr");
    if (QLog.isColorLevel()) {
      QLog.d("ThemeDIYActivity", 2, "saveOperate, ret=" + j + ", msg:" + (String)localObject);
    }
    int i;
    switch (j)
    {
    default: 
      paramObject = localObject;
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        paramObject = alud.a(2131715290);
      }
      paramObject = paramObject + j;
      i = 4;
      localObject = str1;
    }
    while (j != 0)
    {
      this.mIsSaving.set(false);
      this.mHandler.removeMessages(24);
      setProgessDialog(false, 0);
      if (-404 == j)
      {
        QQToast.a(this.mContext, 2131720772, 3000).b(this.mContext.getResources().getDimensionPixelSize(2131298914));
        return;
        i = 4;
        paramObject = localObject;
        localObject = str1;
        continue;
        paramObject = alud.a(2131715282);
        if (!TextUtils.isEmpty(str1)) {
          break label446;
        }
        localObject = alud.a(2131715293);
        i = 1;
        continue;
        paramObject = localObject;
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          paramObject = alud.a(2131715297);
        }
        if (TextUtils.isEmpty(str1))
        {
          localObject = alud.a(2131715279);
          i = 2;
        }
      }
      else
      {
        azqs.b(this.app, "CliOper", "", this.app.getCurrentAccountUin(), "theme_mall", "diy_save_tips", 0, 0, "0", "", "", "");
        QLog.e("ThemeDIYActivity", 1, "saveOperate fail, ret=" + j + ", msg=" + paramObject);
        if ((!TextUtils.isEmpty(str2)) && (TextUtils.isEmpty((CharSequence)localObject))) {
          localObject = alud.a(2131715296);
        }
        for (;;)
        {
          showTips(i, 0, null, paramObject, null, (String)localObject, str2);
          return;
        }
      }
      i = 2;
      localObject = str1;
      continue;
      label446:
      i = 1;
      localObject = str1;
    }
  }
  
  void saveOperate(boolean paramBoolean)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d("ThemeDIYActivity", 2, "saveOperate, isfromUser:" + paramBoolean + ", isVip:" + this.isVip + ", isDIYThemeBefore:" + this.isDIYThemeBefore + ", saving:" + this.mIsSaving.get());
    }
    ThemeDIYData[] arrayOfThemeDIYData = this.showData;
    label391:
    if (paramBoolean)
    {
      try
      {
        if (this.mIsSaving.get()) {
          return;
        }
        if ((this.isDIYThemeBefore) && (!isNeedSave()))
        {
          this.mHandler.sendMessage(Message.obtain(this.mHandler, 27, alud.a(2131715305)));
          return;
        }
      }
      finally {}
      this.mHandler.removeMessages(24);
      int j = bdin.a(this.mContext);
      if (j == 1) {
        break label571;
      }
      if (j != 4) {
        break label578;
      }
      break label571;
      this.mHandler.sendMessageDelayed(Message.obtain(this.mHandler, 24), i);
      if (QLog.isColorLevel()) {
        QLog.d("ThemeDIYActivity", 2, "saveOperate into, isfromUser:" + paramBoolean + ", isVip:" + this.isVip + ", isDIYThemeBefore:" + this.isDIYThemeBefore + ", netType:" + j + ", times:" + i);
      }
      if ((this.mStyleSetStatus != 2) && (this.tryOnStyleRSD != null) && (!this.tryOnStyleRSD.id.equals(this.mUserThemeId))) {
        this.mStyleSetStatus = 2;
      }
      ThemeDIYData localThemeDIYData1 = this.showData[0];
      ThemeDIYData localThemeDIYData2 = this.showData[1];
      ThemeDIYData localThemeDIYData3 = this.showData[2];
      this.mSaveToServerStatus = 3;
      this.mStyleSaveStatus = 3;
      localThemeDIYData3.mSaveStatus = 3;
      localThemeDIYData2.mSaveStatus = 3;
      localThemeDIYData1.mSaveStatus = 3;
      setProgessDialog(true, 2131720771);
      ThreadManager.post(new ThemeDIYActivity.5(this), 8, null, true);
    }
    for (;;)
    {
      if (i < this.showData.length)
      {
        if (6 != this.showData[i].mSaveStatus) {
          if (QLog.isColorLevel()) {
            QLog.d("ThemeDIYActivity", 2, "saveOperate_wait i=" + i);
          }
        }
      }
      else
      {
        if (6 != this.mStyleSaveStatus)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ThemeDIYActivity", 2, "saveOperate_wait deal style.");
          }
          return;
        }
        if ((3 != this.mSaveToServerStatus) && (6 != this.mSaveToServerStatus))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ThemeDIYActivity", 2, "saveOperate_wait mSaveToServerStatus waiting." + this.mSaveToServerStatus);
          }
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ThemeDIYActivity", 2, "saveOperate to backgroundSave.");
        }
        ThreadManager.post(new ThemeDIYActivity.6(this), 8, null, true);
        break label391;
        label571:
        i = 40000;
        break;
        label578:
        i = 60000;
        break;
      }
      i += 1;
    }
  }
  
  void setListItemStatus(HorizontalListView paramHorizontalListView, ResSuitData paramResSuitData1, ResSuitData paramResSuitData2, ResSuitData paramResSuitData3)
  {
    if (paramHorizontalListView == null) {
      return;
    }
    ResSuitData localResSuitData = paramResSuitData2;
    if (this.bgResHListView == paramHorizontalListView)
    {
      localResSuitData = paramResSuitData2;
      if (!this.isDIYThemeBefore) {
        localResSuitData = null;
      }
    }
    int i = 0;
    label32:
    if (i < paramHorizontalListView.getChildCount())
    {
      paramResSuitData2 = paramHorizontalListView.getChildAt(i);
      if (paramResSuitData2 == null) {
        break label128;
      }
      paramResSuitData2 = (ItemView)paramResSuitData2;
      if ((paramResSuitData2 != null) && (paramResSuitData2.resSuitData != null)) {
        break label77;
      }
    }
    label128:
    for (;;)
    {
      i += 1;
      break label32;
      break;
      label77:
      if ((paramResSuitData3 != null) && (paramResSuitData3.id.equals(paramResSuitData2.resSuitData.id)))
      {
        paramResSuitData2.init(paramResSuitData3, paramResSuitData1, localResSuitData, false);
      }
      else
      {
        paramResSuitData2.init(paramResSuitData2.resSuitData, paramResSuitData1, localResSuitData, true);
        continue;
        QLog.e("ThemeDIYActivity", 2, "setListItemStatus view == null");
      }
    }
  }
  
  void setProgessDialog(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      if (this.progessDialog == null)
      {
        this.progessDialog = new bety(this.mContext, getTitleBarHeight());
        this.progessDialog.setCancelable(true);
      }
      this.progessDialog.c(paramInt);
      this.progessDialog.show();
    }
    while ((this.progessDialog == null) || (!this.progessDialog.isShowing())) {
      return;
    }
    this.progessDialog.dismiss();
  }
  
  void setProgressText(String paramString)
  {
    if ((this.progessDialog != null) && (this.progessDialog.isShowing())) {
      this.progessDialog.a(paramString);
    }
  }
  
  boolean showTips(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if (isFinishing()) {
      return false;
    }
    this.mDialogData = new Bundle();
    this.mDialogData.putInt("funcType", paramInt1);
    this.mDialogData.putString("url", paramString5);
    this.mDialogData.putInt("fcID", paramInt2);
    if (TextUtils.isEmpty(paramString1)) {
      paramString1 = alud.a(2131715285);
    }
    for (;;)
    {
      if (TextUtils.isEmpty(paramString2)) {
        paramString2 = alud.a(2131715292);
      }
      for (;;)
      {
        if (TextUtils.isEmpty(paramString3)) {
          paramString3 = alud.a(2131715298);
        }
        for (;;)
        {
          if (TextUtils.isEmpty(paramString4)) {
            paramString4 = alud.a(2131715303);
          }
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("ThemeDIYActivity", 1, "showTips content=" + paramString2 + ", title=" + paramString1);
            }
            paramString1 = bdgm.a(this.mContext, 0, paramString1, paramString2, paramString3, paramString4, this, this);
            if (paramString1 != null)
            {
              paramString1.show();
              return true;
            }
            return false;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.theme.diy.ThemeDIYActivity
 * JD-Core Version:    0.7.0.1
 */