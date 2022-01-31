package com.tencent.mobileqq.theme.diy;

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
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.ChatBackground;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.app.ThemeHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.drawable.ChatBackgroundDrawable;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.theme.ThemeDownloader;
import com.tencent.mobileqq.theme.ThemeDownloader.ThemeDownloadListener;
import com.tencent.mobileqq.theme.ThemeDownloader.ThemeUnzipListener;
import com.tencent.mobileqq.theme.ThemeReporter;
import com.tencent.mobileqq.theme.ThemeSwitchManager;
import com.tencent.mobileqq.theme.ThemeSwitchManager.ThemeSwitchListener;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.theme.ThemeUtil.ThemeInfo;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.CallBacker;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.TabBarView;
import com.tencent.mobileqq.widget.TabBarView.OnTabChangeListener;
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
  implements DialogInterface.OnClickListener, View.OnClickListener, ScrollLayout.OnScreenChangeListener
{
  static final int BG_DEFAULT_POSITION = 1;
  static final int BG_UPLOAD_POSITION = 0;
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
  QQCustomDialog exitDialog;
  ResSuitData initStyleRSD;
  boolean isBigScreenType;
  boolean isDIYThemeBefore;
  boolean isNotifyBack = true;
  boolean isVip;
  String local_FilesDir;
  String local_User_FilesDir;
  ThemeDiyBgAdapter mAdapter;
  ArrayList mBgSuits = new ArrayList();
  SystemBarCompact mCompactBackup;
  Context mContext;
  int mCurrentPageIndex;
  Bundle mDialogData;
  Handler mHandler = new ThemeDIYActivity.14(this, Looper.getMainLooper());
  AtomicBoolean mIsSaving = new AtomicBoolean(false);
  AtomicBoolean mIsUserClickTab = new AtomicBoolean(true);
  PageView mPageView;
  HorizontalListView mResHListView;
  AtomicBoolean mRunFirstTime = new AtomicBoolean(false);
  int mSaveToServerStatus;
  ScrollLayout mScrollLayout;
  int mStyleSaveStatus;
  int mStyleSetStatus;
  ArrayList mStyleSuits = new ArrayList();
  ThemeDownloader.ThemeDownloadListener mThemeDownloadListener = new ThemeDIYActivity.7(this);
  ThemeDownloader.ThemeUnzipListener mThemeUnzipListener = new ThemeDIYActivity.8(this);
  TabBarView.OnTabChangeListener mTypeTabChangeListener = new ThemeDIYActivity.2(this);
  boolean mUpdateUIPicAfterSaved;
  ResSuitData.BgSuit mUploadBgRSD;
  String mUserThemeId;
  String mUserVersion;
  View mblurbgView;
  PageIndicator pageIndicator;
  QQProgressDialog progessDialog;
  DownloadListener resDownloadListener = new ThemeDIYActivity.13(this);
  AdapterView.OnItemClickListener resItemClickListener = new ThemeDIYActivity.15(this);
  ThemeDiyStyleLogic.StyleCallBack saveStyleCallback = new ThemeDIYActivity.10(this);
  final ThemeDIYData[] showData = { new ThemeDIYData(2130843184, "theme_bg_setting_path", 2131493148, "theme_bg_setting_path_png", -50, 0), new ThemeDIYData(2130844108, "theme_bg_message_path", 2131493147, "theme_bg_message_path_png", 50, 1), new ThemeDIYData(2130845689, "theme_bg_aio_path", 0, "theme_bg_aio_path", 0, 2) };
  HorizontalListView styleResHListView;
  ThemeDiyStyleLogic themeDiyStyleLogic;
  ThemeSwitchManager.ThemeSwitchListener themeSwitchListener = new ThemeDIYActivity.9(this);
  ThemeSwitchManager themeSwitchManager;
  ResSuitData tryOnStyleRSD;
  ResSuitData usedStyleRSD;
  
  void backgroundSave()
  {
    int i;
    synchronized (this.showData)
    {
      this.mIsSaving.set(true);
      this.mUpdateUIPicAfterSaved = false;
      i = 0;
      if (i >= this.showData.length) {
        break label688;
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
          break label2430;
        }
        QLog.d("ThemeDIYActivity", 2, "backgroundSave bg save ok:, pageIndex:" + i);
      }
    }
    Object localObject3;
    Object localObject2;
    label688:
    label870:
    String str2;
    label1397:
    label1662:
    boolean bool2;
    label1410:
    label1445:
    label1580:
    label1597:
    label1626:
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
            break label2430;
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
            break label2430;
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
                localThemeDIYData2.tryOnBgBigOrgRD.state = 1;
                localObject2 = new Bundle();
                ((Bundle)localObject2).putInt("index", i);
                ((Bundle)localObject2).putInt("type", 115);
                ((Bundle)localObject2).putInt("nextOperate", 10);
                localObject3 = new DownloadTask(localThemeDIYData2.tryOnBgBigOrgRD.url, (File)localObject3);
                ((DownloaderFactory)this.app.getManager(46)).a(1).a((DownloadTask)localObject3, this.resDownloadListener, (Bundle)localObject2);
                continue;
                Bundle localBundle;
                ThemeHandler localThemeHandler;
                ThemeUtil.ThemeInfo localThemeInfo;
                if ((this.tryOnStyleRSD != null) && (2 == this.mStyleSetStatus)) {
                  if (this.mStyleSaveStatus == 3)
                  {
                    localObject2 = ThemeDiyStyleLogic.getThemeInfoByDensity(this.mContext, (ResSuitData.StyleSuit)this.tryOnStyleRSD);
                    if (localObject2 == null)
                    {
                      QLog.e("ThemeDIYActivity", 1, "backgroundSave, themeInfo=null, oldThemeID:" + this.mUserThemeId + ", tryOnStyleRSD.id:" + this.tryOnStyleRSD.id);
                      this.mHandler.sendMessage(Message.obtain(this.mHandler, 25, "风格数据错误" + this.tryOnStyleRSD.id));
                      return;
                    }
                    if (QLog.isColorLevel())
                    {
                      localObject3 = new StringBuilder().append("backgroundSave, deal style, oldThemeID:").append(this.mUserThemeId).append(", newID:");
                      if (localObject2 == null) {
                        break label2444;
                      }
                      localObject1 = ((ThemeUtil.ThemeInfo)localObject2).themeId;
                      QLog.d("ThemeDIYActivity", 2, (String)localObject1);
                    }
                    this.mStyleSaveStatus = 4;
                    if ((this.mUserThemeId == null) || (!this.mUserThemeId.equals(((ThemeUtil.ThemeInfo)localObject2).themeId)))
                    {
                      localObject1 = new Bundle();
                      ThemeReporter.a(this.app, "theme_detail", "201", 153, NetworkUtil.a(null), 7, ((ThemeUtil.ThemeInfo)localObject2).themeId, ((ThemeUtil.ThemeInfo)localObject2).version, ThemeReporter.a, "");
                      ((Bundle)localObject1).putString("url", ((ThemeUtil.ThemeInfo)localObject2).downloadUrl);
                      ((Bundle)localObject1).putString("themeId", ((ThemeUtil.ThemeInfo)localObject2).themeId);
                      ((Bundle)localObject1).putString("version", ((ThemeUtil.ThemeInfo)localObject2).version);
                      ((Bundle)localObject1).putLong("size", ((ThemeUtil.ThemeInfo)localObject2).size);
                      ((Bundle)localObject1).putBoolean("isVoiceTheme", false);
                      ((Bundle)localObject1).putInt("net_type", 1);
                      ((ThemeSwitchManager)this.app.getManager(184)).a(((ThemeUtil.ThemeInfo)localObject2).themeId, true, false);
                      i = new ThemeDownloader(this.app, "203").a(this.mContext, (Bundle)localObject1, this.mThemeDownloadListener);
                      if (QLog.isColorLevel()) {
                        QLog.d("ThemeDIYActivity", 2, "backgroundSave, downloadTheme opCode:" + i + ", id:" + ((ThemeUtil.ThemeInfo)localObject2).themeId + ", size:" + ((ThemeUtil.ThemeInfo)localObject2).size + ", url:" + ((ThemeUtil.ThemeInfo)localObject2).downloadUrl);
                      }
                      ReportController.b(this.app, "CliOper", "", this.app.getCurrentAccountUin(), "theme_mall", "diy_stylesuccess", 0, 0, "", ((ThemeUtil.ThemeInfo)localObject2).themeId, "", "");
                    }
                  }
                  else
                  {
                    if (this.mStyleSaveStatus != 6) {
                      break label2460;
                    }
                    if (QLog.isColorLevel()) {
                      QLog.d("ThemeDIYActivity", 2, "backgroundSave mStyleSaveStatus ok , mSaveToServerStatus:" + this.mSaveToServerStatus);
                    }
                    if (3 != this.mSaveToServerStatus) {
                      break label2460;
                    }
                    this.mSaveToServerStatus = 4;
                    localBundle = new Bundle();
                    localBundle.putInt("nowOperate", 16);
                    localBundle.putInt("nextOperate", 10);
                    localThemeHandler = (ThemeHandler)this.app.a(14);
                    localThemeInfo = ThemeDiyStyleLogic.getThemeInfoByDensity(this.mContext, (ResSuitData.StyleSuit)this.tryOnStyleRSD);
                    localObject1 = this.mUserThemeId;
                    str2 = this.mUserVersion;
                    localObject2 = localObject1;
                    localObject3 = str2;
                    if (this.tryOnStyleRSD != null)
                    {
                      if (localThemeInfo != null) {
                        break label1580;
                      }
                      QLog.e("ThemeDIYActivity", 1, "backgroundSave, mSaveToServerStatus themeInfo=null, oldThemeID:" + this.mUserThemeId + ", tryOnStyleRSD.id:" + this.tryOnStyleRSD.id);
                      localObject3 = str2;
                      localObject2 = localObject1;
                    }
                    localBundle.putString("key_from", "201");
                    i = 0;
                    if (i >= this.showData.length) {
                      break label1662;
                    }
                    if (this.showData[i].tryOnBgRSD == null) {
                      break label1597;
                    }
                  }
                }
                for (localObject1 = this.showData[i].tryOnBgRSD.id;; localObject1 = this.showData[i].usedBgRSD.id)
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("ThemeDIYActivity", 2, "backgroundSave, bg save : index = " + i + ",id=" + (String)localObject1);
                  }
                  if (i != 0) {
                    break label1626;
                  }
                  localBundle.putString("pageDrawer", (String)localObject1);
                  break label2437;
                  this.mStyleSaveStatus = 6;
                  ReportController.b(this.app, "CliOper", "", this.app.getCurrentAccountUin(), "theme_mall", "diy_stylesuccess", 0, 0, "", ((ThemeUtil.ThemeInfo)localObject2).themeId, "", "");
                  if (!QLog.isColorLevel()) {
                    break;
                  }
                  QLog.d("ThemeDIYActivity", 2, "backgroundSave, style ready!");
                  break;
                  this.mStyleSaveStatus = 6;
                  break;
                  localObject2 = localThemeInfo.themeId;
                  localObject3 = localThemeInfo.version;
                  break label1397;
                  if (this.showData[i].usedBgRSD == null) {
                    break label2452;
                  }
                }
                if (1 == i)
                {
                  localBundle.putString("pageMessage", (String)localObject1);
                  break label2437;
                }
                if (2 != i) {
                  break label2437;
                }
                localBundle.putString("pageAIO", (String)localObject1);
                break label2437;
                if (QLog.isColorLevel()) {
                  QLog.d("ThemeDIYActivity", 2, "backgroundSave to save server2.");
                }
                localThemeHandler.a((String)localObject2, (String)localObject3, null, localBundle, this.saveStyleCallback);
                break label2460;
                label1696:
                bool1 = bool2;
                if (i < this.showData.length)
                {
                  if (6 == this.showData[i].mSaveStatus) {
                    break label2472;
                  }
                  if (!QLog.isColorLevel()) {
                    break label2467;
                  }
                  QLog.d("ThemeDIYActivity", 2, "backgroundSave, bg status: iR = " + this.showData[i].mSaveStatus);
                  break label2467;
                }
                label1764:
                if (QLog.isColorLevel()) {
                  QLog.d("ThemeDIYActivity", 2, "backgroundSave, mSaveStatus:isReady=" + bool1 + ", not iR:" + i + ", theme:" + this.mStyleSaveStatus + ", server:" + this.mSaveToServerStatus);
                }
                if ((bool1) && (6 == this.mStyleSaveStatus) && (6 == this.mSaveToServerStatus))
                {
                  i = 0;
                  label1856:
                  if (i < this.showData.length)
                  {
                    localObject2 = this.showData[i];
                    if (2 == ((ThemeDIYData)localObject2).mSetStatus) {
                      if ((((ThemeDIYData)localObject2).tryOnBgRSD != null) && (!"100".equals(((ThemeDIYData)localObject2).tryOnBgRSD.id)))
                      {
                        localObject3 = this.app;
                        str2 = this.app.getCurrentAccountUin();
                        if (!"99".equals(((ThemeDIYData)localObject2).tryOnBgRSD.id)) {
                          break label2479;
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
    label2342:
    label2348:
    label2430:
    String str1;
    label2437:
    label2444:
    label2452:
    label2460:
    label2467:
    label2472:
    label2479:
    for (Object localObject1 = "diy_photosuccess";; str1 = "diy_yangtusuccess")
    {
      ReportController.b((QQAppInterface)localObject3, "CliOper", "", str2, "theme_mall", (String)localObject1, 0, 0, String.valueOf(((ThemeDIYData)localObject2).position), String.valueOf(((ThemeDIYData)localObject2).tryOnBgRSD.id), String.valueOf(((ThemeDIYData)localObject2).tryOnBgRSD.from), "");
      setSpThemeBackground((ThemeDIYData)localObject2);
      ((ThemeDIYData)localObject2).usedBgRSD = ((ThemeDIYData)localObject2).tryOnBgRSD;
      ((ThemeDIYData)localObject2).mSetStatus = 0;
      i += 1;
      break label1856;
      this.mStyleSetStatus = 0;
      this.mHandler.removeMessages(24);
      ReportController.b(this.app, "CliOper", "", this.app.getCurrentAccountUin(), "theme_mall", "diy_savesuccess", 0, 0, "", "", "", "");
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
          break label2342;
        }
        this.themeSwitchManager.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
        this.themeSwitchManager.a(this.themeSwitchListener, true, false);
        this.themeSwitchManager.a(this.app, this, (ThemeUtil.ThemeInfo)localObject1, false, false, "201");
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
          break label2348;
        }
      }
      i += 1;
      break;
      i += 1;
      break label1410;
      str1 = "null";
      break label870;
      str1 = "100";
      break label1445;
      bool2 = true;
      i = 0;
      break label1696;
      bool1 = false;
      break label1764;
      i += 1;
      break label1696;
    }
  }
  
  public void blurBg(ResData paramResData, Drawable paramDrawable, int paramInt, boolean paramBoolean)
  {
    ThreadManager.post(new ThemeDIYActivity.16(this, paramDrawable, paramResData, paramInt, paramBoolean), 8, null, true);
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
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
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
            ReportController.b(this.app, "CliOper", "", this.app.getCurrentAccountUin(), "theme_mall", "Join_nontop", 0, 1, "", "", "", "");
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
    super.setContentViewNoTitle(2130971589);
    this.mblurbgView = super.findViewById(2131375059);
    paramBundle = (TextView)super.findViewById(2131363227);
    Object localObject = (TextView)super.findViewById(2131364614);
    paramBundle.setOnClickListener(this);
    ((TextView)localObject).setOnClickListener(this);
    ReportController.b(this.app, "CliOper", "", this.app.getCurrentAccountUin(), "theme_mall", "enter_diy2", 0, 0, "", "", "", "");
    this.themeSwitchManager = ((ThemeSwitchManager)this.app.getManager(184));
    this.themeSwitchManager.jdField_a_of_type_ComTencentMobileqqThemeDiyThemeDiyStyleLogic$StyleCallBack = this.saveStyleCallback;
    int j = this.mContext.getResources().getDisplayMetrics().heightPixels;
    int k = this.mContext.getResources().getDisplayMetrics().widthPixels;
    if (Math.min(j, k) > 640)
    {
      bool = true;
      this.isBigScreenType = bool;
      this.local_FilesDir = (AppConstants.aJ + "custom_background/");
      paramBundle = new File(this.local_FilesDir);
      if (!paramBundle.exists()) {
        paramBundle.mkdirs();
      }
      this.local_User_FilesDir = (AppConstants.aJ + this.app.getAccount() + "/" + "custom_background/");
      this.isDIYThemeBefore = ThemeUtil.getIsDIYTheme(null);
      if (((SVIPHandler)this.app.a(13)).j() < 1) {
        break label519;
      }
    }
    int i;
    label519:
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
        break label525;
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
    label525:
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
      StatisticCollector.a(this.mContext).a(this.app.getAccount(), "ThemeDIYActivityRun", true, 1L, 0L, paramBundle, "", false);
      this.mScrollLayout = ((ScrollLayout)super.findViewById(2131375063));
      this.mScrollLayout.setOnScreenChangeListener(this);
      paramBundle = new ResSuitData.StyleSuit();
      this.mStyleSuits.add(paramBundle);
      paramBundle.id = "999";
      paramBundle.name = "默认";
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
      this.mUploadBgRSD.resID = 2130843222;
      this.mUploadBgRSD.name = "上传";
      ApngImage.playByTag(0);
      k = (int)(Math.max(j, k) - DisplayUtils.a(this.mContext, 305));
      int m = k * 322 / 572;
      LayoutInflater localLayoutInflater = LayoutInflater.from(this.mContext);
      ResData localResData = new ResData();
      SharedPreferences localSharedPreferences = this.mContext.getSharedPreferences("theme_background_path_" + this.app.getAccount(), 0);
      j = 0;
      if (j < this.showData.length)
      {
        PageView localPageView = (PageView)localLayoutInflater.inflate(2130971590, null);
        localPageView.init(this.showData[j], j, m, k, null);
        if (j == 0) {
          this.mPageView = localPageView;
        }
        paramBundle = new ResSuitData.BgSuit(null);
        paramBundle.id = "100";
        paramBundle.resID = this.showData[j].themeBgID;
        paramBundle.name = "默认";
        this.showData[j].defaultBgRSD = paramBundle;
        ThemeBackground localThemeBackground = new ThemeBackground();
        localThemeBackground.isDecodeInDiy = true;
        label1128:
        ResSuitData.BgSuit localBgSuit;
        if (2 == j)
        {
          localThemeBackground.path = ((ChatBackgroundManager)this.app.getManager(62)).b(null);
          if (!"null".equals(localThemeBackground.path)) {
            localThemeBackground.img = getLocalDrawable(localThemeBackground.path);
          }
          i = 0;
          if ((TextUtils.isEmpty(localThemeBackground.path)) || ("null".equals(localThemeBackground.path))) {
            break label1705;
          }
          localBgSuit = new ResSuitData.BgSuit(null);
          localObject = localThemeBackground.path.substring(localThemeBackground.path.lastIndexOf(File.separator) + 1);
          if (localThemeBackground.path.indexOf(AppConstants.bF) < 0) {
            break label1685;
          }
          paramBundle = (Bundle)localObject;
          if (((String)localObject).indexOf(".") > 0) {
            paramBundle = ((String)localObject).substring(0, ((String)localObject).indexOf("."));
          }
          localBgSuit.resData = new ResData();
          localBgSuit.resData.path = localThemeBackground.path;
          localBgSuit.resData.id = paramBundle;
          localBgSuit.resData.url = localSharedPreferences.getString(this.showData[j].orgSpKey + "_url", "");
          localBgSuit.feeType = localSharedPreferences.getInt(this.showData[j].orgSpKey + "_feetype", 1);
          localObject = localBgSuit.resData;
          String str = localSharedPreferences.getString(this.showData[j].orgSpKey + "_name", paramBundle);
          ((ResData)localObject).name = str;
          localBgSuit.name = str;
          this.showData[j].initBgRSD = localBgSuit;
          label1420:
          if (!TextUtils.isEmpty(paramBundle)) {
            break label1699;
          }
          localObject = "0";
          label1432:
          localBgSuit.id = ((String)localObject);
          this.showData[j].usedBgRSD = localBgSuit;
          if (j == 0)
          {
            localResData.path = localThemeBackground.path;
            localResData.id = paramBundle;
          }
          label1470:
          if (i != 0) {
            ThreadManager.post(new ThemeDIYActivity.1(this, this.showData[j].orgSpKey, localThemeBackground, j), 8, null, true);
          }
          localPageView.showPic(this.showData[j].usedBgRSD, null, false, localThemeBackground.img);
          paramBundle = new ThemeDIYActivity.ViewHolder();
          paramBundle.id = j;
          paramBundle.scaleView = localPageView.findViewById(2131375064);
          localPageView.setTag(paramBundle);
          if (j != 0) {
            break label1764;
          }
          this.mScrollLayout.changeAlpha(localPageView, false, 800);
          if (!"100".equals(this.showData[j].usedBgRSD.id)) {
            break label1740;
          }
          blurBg(localResData, this.mPageView.bgDrawable, 1, false);
        }
        for (;;)
        {
          this.mScrollLayout.addView(localPageView);
          j += 1;
          break;
          if (!this.isDIYThemeBefore) {
            break label2177;
          }
          localThemeBackground.path = localSharedPreferences.getString(this.showData[j].orgSpKey, "null");
          if ((TextUtils.isEmpty(localThemeBackground.path)) || ("null".equals(localThemeBackground.path))) {
            break label2177;
          }
          i = 1;
          break label1128;
          label1685:
          localBgSuit.aioImg = ((String)localObject);
          paramBundle = "99";
          break label1420;
          label1699:
          localObject = paramBundle;
          break label1432;
          label1705:
          this.showData[j].usedBgRSD = paramBundle;
          if (j != 0) {
            break label1470;
          }
          localResData.id = paramBundle.id;
          localResData.resID = paramBundle.resID;
          break label1470;
          label1740:
          if (localThemeBackground.img != null)
          {
            blurBg(localResData, localThemeBackground.img, 1, true);
            continue;
            label1764:
            this.mScrollLayout.changeAlpha(localPageView, true, 800);
          }
        }
      }
      this.pageIndicator = ((PageIndicator)super.findViewById(2131363249));
      this.pageIndicator.bindScrollViewGroup(this.mScrollLayout);
      this.dataLoad = new ThemeDIYActivity.DataLoading(this);
      this.dataLoad.bindScrollViewGroup(this.mScrollLayout);
      paramBundle = (TabBarView)super.findViewById(2131375060);
      paramBundle.setUnderLineHeight(DisplayUtil.a(this, 4.0F));
      paramBundle.setTabTextSize(16);
      paramBundle.setUnselectColor(-8882056);
      paramBundle.setSelectColor(super.getResources().getColor(2131492970));
      paramBundle.setUnselectColor(super.getResources().getColor(2131492970));
      paramBundle.a.setColor(super.getResources().getColor(2131493149));
      paramBundle.a("");
      paramBundle.a("背景");
      paramBundle.a("");
      paramBundle.a("风格");
      paramBundle.a("");
      paramBundle.setSelectedTab(1, false);
      paramBundle.setOnTabChangeListener(this.mTypeTabChangeListener);
      paramBundle.setBackgroundDrawable(super.getResources().getDrawable(2130844108));
      this.mResHListView = ((HorizontalListView)super.findViewById(2131375061));
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
      ThemeReporter.a(this.app, "theme_detail", "201", 150, NetworkUtil.a(null), 1, this.mUserThemeId, ThemeUtil.getUserCurrentThemeVersion(this.app), "2", "");
      this.mCompactBackup = this.mSystemBarComp;
      this.mSystemBarComp = null;
      new SystemBarCompact(this, true, -5986905).init();
      return true;
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        continue;
        label2177:
        i = 0;
      }
    }
  }
  
  protected void doOnDestroy()
  {
    this.mSystemBarComp = this.mCompactBackup;
    this.mHandler.removeMessages(24);
    this.themeSwitchManager.jdField_a_of_type_ComTencentMobileqqThemeDiyThemeDiyStyleLogic$StyleCallBack = null;
    if (this.app != null) {
      ((VasQuickUpdateManager)this.app.getManager(183)).b(this.callBacker);
    }
    super.doOnDestroy();
  }
  
  protected void doOnNewIntent(Intent paramIntent)
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
      paramString = BitmapManager.a(paramString, new BitmapFactory.Options());
      if (paramString != null) {
        return new ChatBackgroundDrawable(this.mContext.getResources(), paramString);
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
  
  protected boolean isWrapContent()
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
  
  protected boolean onBackEvent()
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
      ReportController.b(this.app, "CliOper", "", this.app.getCurrentAccountUin(), "theme_mall", "diy_out", 0, 0, "", "", "", "");
      if (isNeedSave()) {
        try
        {
          this.exitDialog = DialogUtil.b(this.mContext, 230, super.getResources().getString(2131433248), "你的自定义主题还未保存，是否保存？", 2131433502, 2131434541, new ThemeDIYActivity.11(this), new ThemeDIYActivity.12(this));
          this.exitDialog.show();
          return true;
        }
        catch (Exception localException)
        {
          QLog.e("ThemeDIYActivity", 1, localException.getMessage());
        }
      }
      ReportController.b(this.app, "CliOper", "", this.app.getCurrentAccountUin(), "theme_mall", "diy_outsuccess", 0, 1, "0", "", "", "");
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
        break label379;
      }
      str = "LTMCLUB";
      localObject = "QQ会员";
      paramDialogInterface = "1450000515";
      paramInt = i;
      if (2 == j)
      {
        str = "CJCLUBT";
        localObject = "超级会员";
        paramDialogInterface = "1450000516";
        paramInt = 2;
      }
      gotoOpenQQVip(3, (String)localObject, str, paramDialogInterface);
    }
    for (;;)
    {
      ReportController.b(this.app, "CliOper", "", this.app.getCurrentAccountUin(), "theme_mall", "diy_save_tips", 0, 0, String.valueOf(paramInt), "", "", "");
      return;
      if (5 == j)
      {
        localObject = this.app;
        str = this.app.getCurrentAccountUin();
        if (paramInt == 1) {}
        for (paramDialogInterface = "diy_check";; paramDialogInterface = "diy_check_no")
        {
          ReportController.b((QQAppInterface)localObject, "CliOper", "", str, "theme_mall", paramDialogInterface, 0, 1, "", "", "", "");
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
      label379:
      paramInt = 0;
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131363227: 
      onBackEvent();
      return;
    }
    saveOperate(true);
    ReportController.b(this.app, "CliOper", "", this.app.getCurrentAccountUin(), "theme_mall", "diy_save", 0, 0, "", "", "", "");
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
      i = super.getResources().getColor(2131494247);
      this.mSystemBarComp.setStatusColor(i);
      this.mSystemBarComp.setStatusBarColor(i);
    }
    setProgessDialog(false, 0);
    setListItemStatus(this.styleResHListView, this.tryOnStyleRSD, this.usedStyleRSD, null);
    setListItemStatus(this.bgResHListView, this.mPageView.mData.tryOnBgRSD, this.mPageView.mData.usedBgRSD, null);
    this.themeSwitchManager.b();
    if (QLog.isColorLevel()) {
      QLog.d("ThemeDIYActivity", 2, "onPostThemeChanged mIsSaving=" + this.mIsSaving.get());
    }
    if (this.mIsSaving.get()) {
      showTips(5, 0, null, "DIY主题设置成功，快去看看效果吧！", null, "查看效果", null);
    }
    this.mIsSaving.set(false);
    this.isDIYThemeBefore = true;
    this.mAdapter.isDIYThemeBefore = this.isDIYThemeBefore;
    this.mUserThemeId = ThemeUtil.getCurrentThemeId();
  }
  
  public void onScreenChange(int paramInt)
  {
    ReportController.b(this.app, "CliOper", "", this.app.getCurrentAccountUin(), "theme_mall", "skim_page2", 0, 0, String.valueOf(paramInt), "", "", "");
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
        paramObject = "自定义主题保存服务器错误";
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
        QQToast.a(this.mContext, 2131434103, 3000).b(this.mContext.getResources().getDimensionPixelSize(2131558448));
        return;
        i = 4;
        paramObject = localObject;
        localObject = str1;
        continue;
        if (!TextUtils.isEmpty(str1)) {
          break label428;
        }
        localObject = "立即开通";
        i = 1;
        paramObject = "自定义主题是QQ会员专享特权，开通会员立享特权！";
        continue;
        paramObject = localObject;
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          paramObject = "你选择的资源为超级会员专享，开通即可使用";
        }
        if (TextUtils.isEmpty(str1))
        {
          localObject = "立即开通";
          i = 2;
        }
      }
      else
      {
        ReportController.b(this.app, "CliOper", "", this.app.getCurrentAccountUin(), "theme_mall", "diy_save_tips", 0, 0, "0", "", "", "");
        QLog.e("ThemeDIYActivity", 1, "saveOperate fail, ret=" + j + ", msg=" + paramObject);
        if ((!TextUtils.isEmpty(str2)) && (TextUtils.isEmpty((CharSequence)localObject))) {
          localObject = "了解详情";
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
      label428:
      i = 1;
      paramObject = "自定义主题是QQ会员专享特权，开通会员立享特权！";
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
    label388:
    if (paramBoolean)
    {
      try
      {
        if (this.mIsSaving.get()) {
          return;
        }
        if ((this.isDIYThemeBefore) && (!isNeedSave()))
        {
          this.mHandler.sendMessage(Message.obtain(this.mHandler, 27, "没有任何操作，无需保存"));
          return;
        }
      }
      finally {}
      this.mHandler.removeMessages(24);
      int j = NetworkUtil.a(this.mContext);
      if (j == 1) {
        break label568;
      }
      if (j != 4) {
        break label575;
      }
      break label568;
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
      setProgessDialog(true, 2131434102);
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
        break label388;
        label568:
        i = 40000;
        break;
        label575:
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
        this.progessDialog = new QQProgressDialog(this.mContext, getTitleBarHeight());
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
  
  void setSpThemeBackground(ThemeDIYData paramThemeDIYData)
  {
    String str;
    if ((paramThemeDIYData.tryOnBgBigOrgRD == null) || (paramThemeDIYData.tryOnBgBigRD == null) || ("100".equals(paramThemeDIYData.tryOnBgBigOrgRD.id))) {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder().append("setSpThemeBackground sData.tryOnBgBigOrgRD=").append(paramThemeDIYData.tryOnBgBigOrgRD).append(", sData.tryOnBgBigRD=").append(paramThemeDIYData.tryOnBgBigRD).append(", id=");
        if (paramThemeDIYData.tryOnBgBigOrgRD == null)
        {
          str = "-";
          QLog.d("ThemeDIYActivity", 2, str + ", pageIndex:" + paramThemeDIYData.position);
        }
      }
      else
      {
        ThemeBackground.clear(this.mContext, paramThemeDIYData.orgSpKey, this.app.getAccount());
        if (!paramThemeDIYData.orgSpKey.equals(paramThemeDIYData.dealSpkey)) {
          ThemeBackground.clear(this.mContext, paramThemeDIYData.dealSpkey, this.app.getAccount());
        }
        if (paramThemeDIYData.position == 2) {
          ChatBackground.a(this.mContext, this.app.getAccount(), null, "null");
        }
      }
    }
    label390:
    label395:
    label439:
    for (;;)
    {
      return;
      str = paramThemeDIYData.tryOnBgBigOrgRD.id;
      break;
      int i;
      if (paramThemeDIYData.tryOnBgRSD != null)
      {
        str = paramThemeDIYData.tryOnBgRSD.name;
        if (paramThemeDIYData.tryOnBgRSD == null) {
          break label390;
        }
        i = paramThemeDIYData.tryOnBgRSD.feeType;
        label234:
        ThemeBackground.setThemeBackgroundPic(this.mContext, paramThemeDIYData.orgSpKey, this.app.getAccount(), paramThemeDIYData.tryOnBgBigOrgRD.path, paramThemeDIYData.tryOnBgBigOrgRD.url, paramThemeDIYData.tryOnBgBigOrgRD.id, str, i, null, true);
        if (!paramThemeDIYData.orgSpKey.equals(paramThemeDIYData.dealSpkey))
        {
          if ((paramThemeDIYData.tryOnBgBigRD == null) || (paramThemeDIYData.tryOnBgBigRD.state != 5)) {
            break label395;
          }
          ThemeBackground.setThemeBackgroundPic(this.mContext, paramThemeDIYData.dealSpkey, this.app.getAccount(), paramThemeDIYData.tryOnBgBigRD.path, paramThemeDIYData.tryOnBgBigOrgRD.url, paramThemeDIYData.tryOnBgBigOrgRD.id, str, i, null, true);
        }
      }
      for (;;)
      {
        if (paramThemeDIYData.position != 2) {
          break label439;
        }
        ChatBackground.a(this.mContext, this.app.getAccount(), null, paramThemeDIYData.tryOnBgBigOrgRD.path);
        return;
        str = "";
        break;
        i = 1;
        break label234;
        ThemeBackground.setThemeBackgroundPic(this.mContext, paramThemeDIYData.dealSpkey, this.app.getAccount(), paramThemeDIYData.tryOnBgBigOrgRD.path, paramThemeDIYData.tryOnBgBigOrgRD.url, paramThemeDIYData.tryOnBgBigOrgRD.id, str, i, null, true);
      }
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
      paramString1 = "温馨提示";
    }
    for (;;)
    {
      if (TextUtils.isEmpty(paramString2)) {
        paramString2 = "保存失败，网速不给力哦，请重试";
      }
      for (;;)
      {
        if (TextUtils.isEmpty(paramString3)) {
          paramString3 = "取消";
        }
        for (;;)
        {
          if (TextUtils.isEmpty(paramString4)) {
            paramString4 = "确定";
          }
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("ThemeDIYActivity", 1, "showTips content=" + paramString2 + ", title=" + paramString1);
            }
            paramString1 = DialogUtil.a(this.mContext, 0, paramString1, paramString2, paramString3, paramString4, this, this);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.theme.diy.ThemeDIYActivity
 * JD-Core Version:    0.7.0.1
 */