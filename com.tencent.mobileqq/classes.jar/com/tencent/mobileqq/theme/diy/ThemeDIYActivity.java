package com.tencent.mobileqq.theme.diy;

import Override;
import afrb;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
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
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;
import anvx;
import aocy;
import aoei;
import asbf;
import bdla;
import beil;
import beim;
import beiu;
import beix;
import bgyo;
import bhbx;
import bhdj;
import bhdz;
import bhyn;
import bhyo;
import bhyq;
import bhyt;
import bibh;
import bisl;
import biuc;
import bkwb;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatBackgroundInfo;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.theme.ThemeUtil.ThemeInfo;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.CallBacker;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.TabBarView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.HorizontalListView;
import com.tencent.widget.immersive.SystemBarCompact;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ThemeDIYActivity
  extends IphoneTitleBarActivity
  implements DialogInterface.OnClickListener, View.OnClickListener, beiu
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
  QQCustomDialog exitDialog;
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
  biuc mTypeTabChangeListener = new ThemeDIYActivity.2(this);
  boolean mUpdateUIPicAfterSaved;
  ResSuitData.BgSuit mUploadBgRSD;
  String mUserThemeId;
  String mUserVersion;
  View mblurbgView;
  PageIndicator pageIndicator;
  bisl progessDialog;
  bhyn resDownloadListener = new ThemeDIYActivity.10(this);
  AdapterView.OnItemClickListener resItemClickListener = new ThemeDIYActivity.12(this);
  beix saveStyleCallback = new ThemeDIYActivity.7(this);
  final ThemeDIYData[] showData = getDiyData();
  HorizontalListView styleResHListView;
  ThemeDiyStyleLogic themeDiyStyleLogic;
  beim themeSwitchManager;
  ResSuitData tryOnStyleRSD;
  ResSuitData usedStyleRSD;
  
  private void checkFileExists(ThemeDIYData paramThemeDIYData)
  {
    if ((paramThemeDIYData.tryOnBgBigRD == null) || (paramThemeDIYData.tryOnBgBigRD.state != 5))
    {
      dealBgRes(paramThemeDIYData, paramThemeDIYData.tryOnBgBigOrgRD, 115, true);
      return;
    }
    paramThemeDIYData.mSaveStatus = 6;
  }
  
  private void checkThemeBackground(int paramInt, ThemeDIYData paramThemeDIYData)
  {
    if (2 != paramThemeDIYData.mSetStatus) {
      handleItemSetChange(paramInt, paramThemeDIYData);
    }
    for (;;)
    {
      return;
      if (6 == paramThemeDIYData.mSaveStatus)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ThemeDIYActivity", 2, "backgroundSave bg save ok:, pageIndex:" + paramInt);
        }
      }
      else
      {
        if ((paramThemeDIYData.tryOnBgRSD == null) || (paramThemeDIYData.tryOnBgBigOrgRD == null))
        {
          handleTryOnBgRSD(paramInt, paramThemeDIYData);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ThemeDIYActivity", 2, "backgroundSave bg diyData.tryOnBgRSD.id:" + paramThemeDIYData.tryOnBgRSD.id + ", pageIndex:" + paramInt);
        }
        if ("100".equals(paramThemeDIYData.tryOnBgRSD.id))
        {
          handleDiyDefaultBgId(paramInt, paramThemeDIYData);
          return;
        }
        if ("99".equals(paramThemeDIYData.tryOnBgRSD.id))
        {
          if (handleDiyUploadBgId(paramInt, paramThemeDIYData)) {}
        }
        else {
          while (QLog.isColorLevel())
          {
            QLog.d("ThemeDIYActivity", 2, "backgroundSave bg diyData.mSaveStatus:" + paramThemeDIYData.mSaveStatus + ", pageIndex:" + paramInt + ", tryOnBgBigOrgRD.state:" + paramThemeDIYData.tryOnBgBigOrgRD.state);
            return;
            handleOtherId(paramInt, paramThemeDIYData);
          }
        }
      }
    }
  }
  
  private void createDiyDir()
  {
    int j = 0;
    Object localObject = new File(ThemeDiyStyleLogic.getDataDIYDir());
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    localObject = new File(ThemeDiyStyleLogic.getSdcardDIYDir());
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    FileUtils.createFileIfNotExits(ThemeDiyStyleLogic.getSdcardDIYDir() + ".nomedia");
    this.isDIYThemeBefore = ThemeUtil.getIsDIYTheme(null);
    if (((aocy)this.app.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).g() >= 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.isVip = bool;
      localObject = ThemeUtil.getCurrentThemeInfo();
      this.mUserThemeId = ((Bundle)localObject).getString("themeId");
      this.mUserVersion = ((Bundle)localObject).getString("version");
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
      int i = j;
      if (this.isVip)
      {
        if ((this.isDIYThemeBefore) || ("1103".equals(this.mUserThemeId))) {
          break;
        }
        i = j;
      }
      while (i < this.showData.length)
      {
        ThemeBackground.clear(this.mContext, this.showData[i].orgSpKey, this.app.getCurrentAccountUin());
        ThemeBackground.clear(this.mContext, this.showData[i].dealSpkey, this.app.getCurrentAccountUin());
        i += 1;
      }
    }
  }
  
  private boolean dealBG(int paramInt, Bundle paramBundle)
  {
    int i = paramBundle.getInt("index");
    ThemeDIYData localThemeDIYData = this.showData[i];
    if (paramInt == 4)
    {
      localThemeDIYData.mSaveStatus = 6;
      localThemeDIYData.tryOnBgBigOrgRD.state = 5;
      localThemeDIYData.tryOnBgBigRD.state = 5;
      if ((this.mIsSaving.get()) && (paramBundle.getInt("nextOperate") != 10)) {
        paramBundle.putInt("nextOperate", 10);
      }
      if (this.mUpdateUIPicAfterSaved)
      {
        paramBundle = new Intent("com.tencent.qplus.THEME_INVALIDATE");
        paramBundle.putExtra("pid", Process.myPid());
        this.mContext.sendBroadcast(paramBundle, "com.tencent.msg.permission.pushnotify");
        if (QLog.isColorLevel()) {
          QLog.d("ThemeDIYActivity", 2, "pic Save, isSaved = true, change pic.");
        }
      }
    }
    while (paramInt != 8) {
      return false;
    }
    this.mHandler.sendMessage(Message.obtain(this.mHandler, 25, "背景压黑压白错误103"));
    QLog.e("ThemeDIYActivity", 2, "mSaveStyleCallback, OPERATE_KEY_DEAL_BG deal error." + localThemeDIYData.position);
    return true;
  }
  
  private boolean downBG(int paramInt, Bundle paramBundle)
  {
    int i = paramBundle.getInt("index");
    paramBundle = this.showData[i];
    if (QLog.isColorLevel()) {
      QLog.d("ThemeDIYActivity", 2, "mSaveStyleCallback: callback, pageIndex:" + i);
    }
    if (paramInt == 4) {
      dealBgRes(paramBundle, paramBundle.tryOnBgBigOrgRD, 115, true);
    }
    while (paramInt != 8) {
      return false;
    }
    this.mHandler.sendMessage(Message.obtain(this.mHandler, 25, anvx.a(2131714289) + i));
    QLog.e("ThemeDIYActivity", 1, "mSaveStyleCallback, OPERATE_KEY_DOWN_BG Error, pageIndex:" + i);
    return true;
  }
  
  private boolean downloadStyle()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    ThemeUtil.ThemeInfo localThemeInfo;
    if (this.mStyleSaveStatus == 3)
    {
      localThemeInfo = ThemeDiyStyleLogic.getThemeInfoByDensity(this.mContext, (ResSuitData.StyleSuit)this.tryOnStyleRSD);
      if (localThemeInfo != null) {
        break label128;
      }
      QLog.e("ThemeDIYActivity", 1, "backgroundSave, themeInfo=null, oldThemeID:" + this.mUserThemeId + ", tryOnStyleRSD.id:" + this.tryOnStyleRSD.id);
      this.mHandler.sendMessage(Message.obtain(this.mHandler, 25, anvx.a(2131714281) + this.tryOnStyleRSD.id));
      bool1 = true;
    }
    label128:
    label259:
    do
    {
      return bool1;
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("backgroundSave, deal style, oldThemeID:").append(this.mUserThemeId).append(", newID:");
        if (localThemeInfo == null) {
          break label259;
        }
      }
      for (String str = localThemeInfo.themeId;; str = "null")
      {
        QLog.d("ThemeDIYActivity", 2, str);
        this.mStyleSaveStatus = 4;
        if ((this.mUserThemeId != null) && (this.mUserThemeId.equals(localThemeInfo.themeId))) {
          break;
        }
        bdla.b(this.app, "CliOper", "", this.app.getCurrentAccountUin(), "theme_mall", "diy_stylesuccess", 0, 0, "", localThemeInfo.themeId, "", "");
        return false;
      }
      this.mStyleSaveStatus = 6;
      bdla.b(this.app, "CliOper", "", this.app.getCurrentAccountUin(), "theme_mall", "diy_stylesuccess", 0, 0, "", localThemeInfo.themeId, "", "");
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.d("ThemeDIYActivity", 2, "backgroundSave, style ready!");
    return false;
  }
  
  public static ThemeDIYData[] getDiyData()
  {
    return new ThemeDIYData[] { new ThemeDIYData(2130846042, "theme_bg_setting_path", 2131166603, "theme_bg_setting_path_png", -50, 0), new ThemeDIYData(2130847474, "theme_bg_message_path", 2131166605, "theme_bg_message_path_png", 50, 1), new ThemeDIYData(2130850046, "theme_bg_aio_path", 0, "theme_bg_aio_path", 0, 2), new ThemeDIYData(2130847474, "theme_bg_friend_path", 2131166605, "theme_bg_friend_path_png", 50, 3), new ThemeDIYData(2130850046, "theme_bg_dynamic_path", 2131166605, "theme_bg_dynamic_path_png", 50, 4) };
  }
  
  private ArrayList<ResSuitData> getResSuitData(JSONObject paramJSONObject, long paramLong)
  {
    paramJSONObject = paramJSONObject.getJSONArray("data");
    int i = 0;
    if (i < paramJSONObject.length())
    {
      JSONObject localJSONObject = paramJSONObject.getJSONObject(i);
      ResSuitData.BgSuit localBgSuit = new ResSuitData.BgSuit(localJSONObject);
      localBgSuit.from = 2;
      if (localBgSuit.isdecoded) {
        this.mBgSuits.add(localBgSuit);
      }
      for (;;)
      {
        i += 1;
        break;
        QLog.e("ThemeDIYActivity", 2, "loadResJson bgSuit.isdecoded = false, bgObj=" + localJSONObject + ", timeStamp:" + paramLong);
      }
    }
    return this.mBgSuits;
  }
  
  @NotNull
  private String getScid(int paramInt, boolean paramBoolean)
  {
    if (this.mRunFirstTime.compareAndSet(false, true)) {}
    try
    {
      boolean bool = bibh.a(this.app.getApplication(), "ThemeDIYActivity", false);
      long l = bhbx.b();
      QLog.d("ThemeDIYActivity", 2, "loadResJson Err haveSDCard:" + bool + ", availableSpace:" + l);
      if (100 == paramInt)
      {
        String str1 = "diytheme.json";
        if (QLog.isColorLevel()) {
          QLog.d("ThemeDIYActivity", 2, "loadResJson decode scid json: " + str1 + ", ifAfterDownladed:" + paramBoolean);
        }
        return str1;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.d("ThemeDIYActivity", 2, "loadResJson Err2 e:" + localException.getMessage());
        continue;
        String str2 = "diytheme.style.json";
      }
    }
  }
  
  private void goError(int paramInt)
  {
    try
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_vipType", String.valueOf(this.isVip));
      localHashMap.put("param_opType", String.valueOf(paramInt));
      localHashMap.put("param_isDiy", String.valueOf(this.isDIYThemeBefore));
      StatisticCollector.getInstance(this.mContext).collectPerformance(this.app.getAccount(), "ThemeDiyStyleLogicCallback", false, 1L, 0L, localHashMap, "", false);
      return;
    }
    catch (Exception localException) {}
  }
  
  private void goOn(int paramInt, Bundle paramBundle, ResData paramResData)
  {
    if (paramInt == 4) {
      if ((paramBundle != null) && (paramResData != null) && (117 == paramResData.type))
      {
        paramInt = paramBundle.getInt("page_index", -1);
        if (this.mPageView.pageIndex == paramInt) {
          blurBg(paramResData, null, 0, true);
        }
      }
    }
    while (paramInt != 8) {
      return;
    }
    QLog.e("ThemeDIYActivity", 1, "StyleCallBack:save theme false, error type == " + paramInt);
  }
  
  private void handleDiyDefaultBgId(int paramInt, ThemeDIYData paramThemeDIYData)
  {
    paramThemeDIYData.mSaveStatus = 6;
    if (QLog.isColorLevel()) {
      QLog.d("ThemeDIYActivity", 2, "backgroundSave bg set DIY_DEFAULT_BG_ID:, pageIndex:" + paramInt);
    }
  }
  
  private boolean handleDiyUploadBgId(int paramInt, ThemeDIYData paramThemeDIYData)
  {
    if (paramThemeDIYData.tryOnBgBigRD == null)
    {
      QLog.e("ThemeDIYActivity", 1, "backgroundSave DIY_UPLOAD_BG_ID bg Error null == tryOnBgBigRD, pageIndex:" + paramInt);
      return true;
    }
    if (paramThemeDIYData.tryOnBgBigRD.state == 5) {
      paramThemeDIYData.mSaveStatus = 6;
    }
    for (;;)
    {
      return false;
      if (QLog.isColorLevel()) {
        QLog.d("ThemeDIYActivity", 2, "backgroundSave DIY_UPLOAD_BG_ID:waiting deal, pageIndex:" + paramInt);
      }
    }
  }
  
  private void handleItemSetChange(int paramInt, ThemeDIYData paramThemeDIYData)
  {
    paramThemeDIYData.mSaveStatus = 6;
    if (QLog.isColorLevel()) {
      QLog.d("ThemeDIYActivity", 2, "backgroundSave bg not change:, pageIndex:" + paramInt);
    }
  }
  
  private void handleMsgResDataChanged(Message paramMessage)
  {
    if (paramMessage.arg1 == 1) {
      if (this.usedStyleRSD != null)
      {
        paramMessage = this.usedStyleRSD;
        if ((paramMessage != null) || (this.mStyleSuits.size() <= 0)) {
          break label161;
        }
        paramMessage = (ResSuitData)this.mStyleSuits.get(0);
      }
    }
    label161:
    for (;;)
    {
      if (paramMessage != null)
      {
        int i = 0;
        for (;;)
        {
          if (i < this.mScrollLayout.getChildCount())
          {
            ((PageView)this.mScrollLayout.getChildAt(i)).showPic(paramMessage, null, false, null);
            i += 1;
            continue;
            paramMessage = this.tryOnStyleRSD;
            break;
          }
        }
      }
      if (this.bgResHListView != null)
      {
        this.bgResHListView = null;
        this.mIsUserClickTab.set(false);
        this.mTypeTabChangeListener.onTabSelected(1, 1);
      }
      while (this.styleResHListView == null) {
        return;
      }
      this.styleResHListView = null;
      this.mIsUserClickTab.set(false);
      this.mTypeTabChangeListener.onTabSelected(3, 3);
      return;
    }
  }
  
  private void handleMsgSHowPageBgInit(Message paramMessage)
  {
    int i = paramMessage.arg1;
    if ((this.mScrollLayout != null) && (this.mScrollLayout.getChildCount() > i)) {}
    for (Object localObject = this.mScrollLayout.getChildAt(i);; localObject = null)
    {
      if (((localObject instanceof PageView)) && ((paramMessage.obj instanceof ThemeBackground)))
      {
        localObject = (PageView)localObject;
        paramMessage = (ThemeBackground)paramMessage.obj;
        if (paramMessage.img != null)
        {
          ((PageView)localObject).showPic(this.showData[i].usedBgRSD, null, false, paramMessage.img);
          if ((i == 0) && (this.showData[i].usedBgRSD != null))
          {
            localObject = new ResData();
            ((ResData)localObject).id = this.showData[i].usedBgRSD.id;
            ((ResData)localObject).path = paramMessage.path;
            blurBg((ResData)localObject, paramMessage.img, 1, true);
          }
        }
      }
      return;
    }
  }
  
  private void handleMsgSaveTimeOut()
  {
    int i = 0;
    if (i < this.showData.length)
    {
      if (6 != this.showData[i].mSaveStatus)
      {
        if (this.showData[i].tryOnBgBigOrgRD == null) {
          break label125;
        }
        QLog.e("ThemeDIYActivity", 1, "save timeout 0 Page:" + i + ", state:" + this.showData[i].tryOnBgBigOrgRD.state + ", id:" + this.showData[i].tryOnBgBigOrgRD.id);
        this.showData[i].tryOnBgBigOrgRD.state = 0;
      }
      for (;;)
      {
        i += 1;
        break;
        label125:
        QLog.e("ThemeDIYActivity", 1, "save timeout 1 Page:" + i);
      }
    }
    if (6 != this.mStyleSaveStatus) {
      QLog.e("ThemeDIYActivity", 1, "save timeout 3 mStyleSaveStatus:" + this.mStyleSaveStatus);
    }
    if (6 != this.mSaveToServerStatus) {
      QLog.e("ThemeDIYActivity", 1, "save timeout 4 mSaveToServerStatus:" + this.mSaveToServerStatus);
    }
    this.mHandler.removeMessages(24);
    this.mIsSaving.set(false);
    setProgessDialog(false, 0);
    QQToast.a(this.mContext, 2131719327, 3000).b(this.mContext.getResources().getDimensionPixelSize(2131299080));
  }
  
  private void handleMsgSetBlurBg(Message paramMessage)
  {
    paramMessage = (ResData)paramMessage.obj;
    if (paramMessage == null) {
      return;
    }
    Object localObject = this.mContext.getResources().getDrawable(2130847473);
    try
    {
      URL localURL = new URL("themediydownloader", paramMessage.path, paramMessage.url);
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject);
      localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject);
      localURLDrawableOptions.mUseSharpPImage = bkwb.a(BaseApplicationImpl.getApplication());
      localObject = URLDrawable.getDrawable(localURL, localURLDrawableOptions);
      if (((URLDrawable)localObject).getStatus() != 1)
      {
        ((URLDrawable)localObject).addHeader("my_id", paramMessage.id);
        ((URLDrawable)localObject).addHeader("my_uin", this.app.getCurrentUin());
        ((URLDrawable)localObject).addHeader("my_type", "" + paramMessage.type);
        ((URLDrawable)localObject).addHeader("page_index", "" + this.mCurrentPageIndex);
        return;
      }
    }
    catch (MalformedURLException paramMessage)
    {
      QLog.e("ThemeDIYActivity", 1, "HANDLER_MSG_SET_BLUR_BG err:" + paramMessage.getMessage());
      return;
    }
    blurBg(paramMessage, (Drawable)localObject, 0, true);
  }
  
  private void handleOtherId(int paramInt, ThemeDIYData paramThemeDIYData)
  {
    File localFile = new File(paramThemeDIYData.tryOnBgBigOrgRD.path);
    if (localFile.exists()) {
      checkFileExists(paramThemeDIYData);
    }
    while (paramThemeDIYData.tryOnBgBigOrgRD.state != 0) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("index", paramInt);
    localBundle.putInt("type", 115);
    localBundle.putInt("nextOperate", 10);
    paramThemeDIYData = new bhyo(paramThemeDIYData.tryOnBgBigOrgRD.url, localFile);
    ((bhyq)this.app.getManager(QQManagerFactory.DOWNLOADER_FACTORY)).a(1).a(paramThemeDIYData, this.resDownloadListener, localBundle);
  }
  
  private void handleTryOnBgRSD(int paramInt, ThemeDIYData paramThemeDIYData)
  {
    QLog.e("ThemeDIYActivity", 1, "backgroundSave bg Error null, pageIndex:" + paramInt + ", tryOnBgRSD:" + paramThemeDIYData.tryOnBgRSD + ", tryOnBgBigOrgRD:" + paramThemeDIYData.tryOnBgBigOrgRD);
    paramThemeDIYData.mSaveStatus = 6;
  }
  
  private int parseResSuitData(int paramInt, String paramString, JSONObject paramJSONObject, ResSuitData.StyleSuit paramStyleSuit)
  {
    int i;
    if ("999".equals(paramStyleSuit.id))
    {
      this.mStyleSuits.add(0, paramStyleSuit);
      if (this.tryOnStyleRSD == null) {
        this.tryOnStyleRSD = paramStyleSuit;
      }
      i = paramInt;
      if (!TextUtils.isEmpty(this.mUserThemeId))
      {
        i = paramInt;
        if (this.mUserThemeId.equals(paramStyleSuit.id))
        {
          this.initStyleRSD = paramStyleSuit;
          this.usedStyleRSD = paramStyleSuit;
          this.tryOnStyleRSD = paramStyleSuit;
          ThemeDiyBgAdapter localThemeDiyBgAdapter = this.mAdapter;
          this.mAdapter.tryOnStyleRSD = paramStyleSuit;
          localThemeDiyBgAdapter.usedStyleRSD = paramStyleSuit;
          i = 1;
        }
      }
      if (!paramString.equals("m")) {
        break label173;
      }
      paramStyleSuit.zipSize = paramJSONObject.optInt("m_size");
      paramStyleSuit.zipUrl = paramJSONObject.optString("zipm");
      paramStyleSuit.zipVersion = paramJSONObject.optString("m_version");
    }
    label173:
    do
    {
      return i;
      this.mStyleSuits.add(paramStyleSuit);
      break;
      if (paramString.equals("h"))
      {
        paramStyleSuit.zipSize = paramJSONObject.optInt("h_size");
        paramStyleSuit.zipUrl = paramJSONObject.optString("ziph");
        paramStyleSuit.zipVersion = paramJSONObject.optString("h_version");
        return i;
      }
    } while (!paramString.equals("xh"));
    paramStyleSuit.zipSize = paramJSONObject.optInt("xh_size");
    paramStyleSuit.zipUrl = paramJSONObject.optString("zipxh");
    paramStyleSuit.zipVersion = paramJSONObject.optString("xh_version");
    return i;
  }
  
  private void saveServer(int paramInt, Bundle paramBundle)
  {
    if (paramInt == 4)
    {
      this.mSaveToServerStatus = 6;
      return;
    }
    this.mHandler.sendMessage(Message.obtain(this.mHandler, 28, 1, 1, paramBundle));
    StringBuilder localStringBuilder = new StringBuilder().append("StyleCallBack:SAVE_SERVER false, error ret=");
    if (paramBundle != null) {}
    for (paramBundle = paramBundle.getInt("result_int") + "_" + paramBundle.getString("message");; paramBundle = "null Param")
    {
      QLog.e("ThemeDIYActivity", 1, paramBundle);
      return;
    }
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
          afrb.a(paramContext, paramString, null, "null");
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
        afrb.a(paramContext, paramString, null, paramThemeDIYData.tryOnBgBigOrgRD.path);
        return;
        label309:
        ThemeBackground.setThemeBackgroundPic(paramContext, paramThemeDIYData.dealSpkey, paramString, paramThemeDIYData.tryOnBgBigOrgRD.path, paramThemeDIYData.tryOnBgBigOrgRD.url, paramThemeDIYData.tryOnBgBigOrgRD.id, "", 1, null, true);
      }
    }
  }
  
  private void switchTheme(int paramInt)
  {
    if (paramInt == 4)
    {
      this.mUpdateUIPicAfterSaved = true;
      if (QLog.isColorLevel()) {
        QLog.d("ThemeDIYActivity", 2, "StyleCallBack:save theme ok!!");
      }
    }
    while (paramInt != 8) {
      return;
    }
    this.mHandler.sendMessage(Message.obtain(this.mHandler, 26, anvx.a(2131714276)));
    QLog.e("ThemeDIYActivity", 1, "StyleCallBack:save theme false, error type == " + paramInt);
  }
  
  private void themeDiyDataSaveInit()
  {
    if (3 == this.mSaveToServerStatus)
    {
      this.mSaveToServerStatus = 4;
      Bundle localBundle = new Bundle();
      localBundle.putInt("nowOperate", 16);
      localBundle.putInt("nextOperate", 10);
      aoei localaoei = (aoei)this.app.getBusinessHandler(BusinessHandlerFactory.THEME_HANDLER);
      ThemeUtil.ThemeInfo localThemeInfo = ThemeDiyStyleLogic.getThemeInfoByDensity(this.mContext, (ResSuitData.StyleSuit)this.tryOnStyleRSD);
      String str1 = this.mUserThemeId;
      String str4 = this.mUserVersion;
      String str2 = str1;
      String str3 = str4;
      int i;
      if (this.tryOnStyleRSD != null)
      {
        if (localThemeInfo == null)
        {
          QLog.e("ThemeDIYActivity", 1, "backgroundSave, mSaveToServerStatus themeInfo=null, oldThemeID:" + this.mUserThemeId + ", tryOnStyleRSD.id:" + this.tryOnStyleRSD.id);
          str3 = str4;
          str2 = str1;
        }
      }
      else
      {
        localBundle.putString("key_from", "201");
        i = 0;
        label166:
        if (i >= this.showData.length) {
          break label330;
        }
        if (this.showData[i].tryOnBgRSD == null) {
          break label295;
        }
        str1 = this.showData[i].tryOnBgRSD.id;
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ThemeDIYActivity", 2, "backgroundSave, bg save : index = " + i + ",id=" + str1);
        }
        str4 = str1;
        if (str1.equals("custom")) {
          str4 = "99";
        }
        localBundle.putString(BUNDLE_PAGE_KEY[i], str4);
        i += 1;
        break label166;
        str2 = localThemeInfo.themeId;
        str3 = localThemeInfo.version;
        break;
        label295:
        if (this.showData[i].usedBgRSD != null) {
          str1 = this.showData[i].usedBgRSD.id;
        } else {
          str1 = "100";
        }
      }
      label330:
      if (QLog.isColorLevel()) {
        QLog.d("ThemeDIYActivity", 2, "backgroundSave to save server2.");
      }
      localaoei.a(str2, str3, null, localBundle, this.saveStyleCallback);
    }
  }
  
  private void themeSwitch()
  {
    int i = 0;
    if (i < this.showData.length)
    {
      localThemeDIYData = this.showData[i];
      QQAppInterface localQQAppInterface;
      String str;
      if (2 == localThemeDIYData.mSetStatus) {
        if ((localThemeDIYData.tryOnBgRSD != null) && (!"100".equals(localThemeDIYData.tryOnBgRSD.id)))
        {
          localQQAppInterface = this.app;
          str = this.app.getCurrentAccountUin();
          if (!"99".equals(localThemeDIYData.tryOnBgRSD.id)) {
            break label168;
          }
        }
      }
      label168:
      for (localObject = "diy_photosuccess";; localObject = "diy_yangtusuccess")
      {
        bdla.b(localQQAppInterface, "CliOper", "", str, "theme_mall", (String)localObject, 0, 0, String.valueOf(localThemeDIYData.position), String.valueOf(localThemeDIYData.tryOnBgRSD.id), String.valueOf(localThemeDIYData.tryOnBgRSD.from), "");
        setSpThemeBackground(this.mContext, this.app.getAccount(), localThemeDIYData);
        localThemeDIYData.usedBgRSD = localThemeDIYData.tryOnBgRSD;
        localThemeDIYData.mSetStatus = 0;
        i += 1;
        break;
      }
    }
    this.mStyleSetStatus = 0;
    this.mHandler.removeMessages(24);
    bdla.b(this.app, "CliOper", "", this.app.getCurrentAccountUin(), "theme_mall", "diy_savesuccess", 0, 0, "", "", "", "");
    ThemeDIYData localThemeDIYData = null;
    Object localObject = localThemeDIYData;
    if (this.tryOnStyleRSD != null)
    {
      localObject = localThemeDIYData;
      if ((this.tryOnStyleRSD instanceof ResSuitData.StyleSuit)) {
        localObject = ThemeUtil.getThemeInfo(this.mContext, ((ResSuitData.StyleSuit)this.tryOnStyleRSD).id);
      }
    }
    if (localObject == null)
    {
      QLog.e("ThemeDIYActivity", 1, "backgroundSave ok, themeInfo=null, oldThemeID:" + this.mUserThemeId);
      if ((localObject == null) || (TextUtils.isEmpty(((ThemeUtil.ThemeInfo)localObject).themeId)) || (((ThemeUtil.ThemeInfo)localObject).themeId.equals(this.mUserThemeId))) {
        break label431;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ThemeDIYActivity", 2, "backgroundSave, isSaveDataOk = true, switchThemeTask.execute(" + ((ThemeUtil.ThemeInfo)localObject).themeId + ", " + ((ThemeUtil.ThemeInfo)localObject).version + ");");
      }
    }
    for (;;)
    {
      return;
      QLog.d("ThemeDIYActivity", 1, "backgroundSave ok, themeInfo=null, oldThemeID:" + this.mUserThemeId + ", themeInfo.themeId:" + ((ThemeUtil.ThemeInfo)localObject).themeId);
      break;
      try
      {
        label431:
        Thread.sleep(1100L);
        label437:
        localObject = new Intent("com.tencent.qplus.THEME_INVALIDATE");
        ((Intent)localObject).putExtra("pid", Process.myPid());
        this.mContext.sendBroadcast((Intent)localObject, "com.tencent.msg.permission.pushnotify");
        this.mUpdateUIPicAfterSaved = true;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ThemeDIYActivity", 2, "backgroundSave, isSaveDataOk = true, dont change theme.");
        return;
      }
      catch (Exception localException)
      {
        break label437;
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
          ((ChatBackgroundManager)this.app.getManager(QQManagerFactory.CHAT_BACKGROUND_MANAGER)).a(this.app, localChatBackgroundInfo, null);
          if (QLog.isColorLevel()) {
            QLog.e("ThemeDIYActivity", 2, "vasDownloadBackground download id = " + localChatBackgroundInfo.id + " name =  " + localChatBackgroundInfo.name + " url = " + localChatBackgroundInfo.url);
          }
        }
      }
    }
  }
  
  void backgroundSave()
  {
    boolean bool2 = false;
    for (;;)
    {
      int i;
      boolean bool1;
      synchronized (this.showData)
      {
        this.mIsSaving.set(true);
        this.mUpdateUIPicAfterSaved = false;
        i = 0;
        if (i < this.showData.length)
        {
          checkThemeBackground(i, this.showData[i]);
          i += 1;
          continue;
        }
        if ((this.tryOnStyleRSD != null) && (2 == this.mStyleSetStatus))
        {
          if (!downloadStyle()) {}
        }
        else {
          this.mStyleSaveStatus = 6;
        }
        if (this.mStyleSaveStatus != 6) {
          break label339;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ThemeDIYActivity", 2, "backgroundSave mStyleSaveStatus ok , mSaveToServerStatus:" + this.mSaveToServerStatus);
        }
        themeDiyDataSaveInit();
        break label339;
        if (i >= this.showData.length) {
          break label334;
        }
        if (6 != this.showData[i].mSaveStatus)
        {
          bool1 = bool2;
          if (QLog.isColorLevel())
          {
            QLog.d("ThemeDIYActivity", 2, "backgroundSave, bg status: iR = " + this.showData[i].mSaveStatus);
            bool1 = bool2;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ThemeDIYActivity", 2, "backgroundSave, mSaveStatus:isReady=" + bool1 + ", not iR:" + i + ", theme:" + this.mStyleSaveStatus + ", server:" + this.mSaveToServerStatus);
          }
          if ((!bool1) || (6 != this.mStyleSaveStatus) || (6 != this.mSaveToServerStatus)) {
            break label316;
          }
          themeSwitch();
          return;
        }
      }
      i += 1;
      continue;
      label316:
      if (QLog.isColorLevel())
      {
        QLog.d("ThemeDIYActivity", 2, "backgroundSave, waiting status.");
        continue;
        label334:
        bool1 = true;
        continue;
        label339:
        i = 0;
      }
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
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
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
            bdla.b(this.app, "CliOper", "", this.app.getCurrentAccountUin(), "theme_mall", "Join_nontop", 0, 1, "", "", "", "");
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
    super.setContentViewNoTitle(2131562949);
    this.mblurbgView = super.findViewById(2131363660);
    paramBundle = (TextView)super.findViewById(2131369231);
    Object localObject = (TextView)super.findViewById(2131369239);
    paramBundle.setOnClickListener(this);
    ((TextView)localObject).setOnClickListener(this);
    bdla.b(this.app, "CliOper", "", this.app.getCurrentAccountUin(), "theme_mall", "enter_diy2", 0, 0, "", "", "", "");
    this.themeSwitchManager = ((beim)this.app.getManager(QQManagerFactory.THEME_MANAGER));
    this.themeSwitchManager.a = this.saveStyleCallback;
    int i = this.mContext.getResources().getDisplayMetrics().heightPixels;
    int j = this.mContext.getResources().getDisplayMetrics().widthPixels;
    boolean bool;
    if (Math.min(i, j) > 640) {
      bool = true;
    }
    for (;;)
    {
      this.isBigScreenType = bool;
      createDiyDir();
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
        StatisticCollector.getInstance(this.mContext).collectPerformance(this.app.getAccount(), "ThemeDIYActivityRun", true, 1L, 0L, paramBundle, "", false);
        label384:
        this.mScrollLayout = ((ScrollLayout)super.findViewById(2131361806));
        this.mScrollLayout.setOnScreenChangeListener(this);
        paramBundle = new ResSuitData.StyleSuit();
        this.mStyleSuits.add(paramBundle);
        paramBundle.id = "999";
        paramBundle.name = anvx.a(2131714267);
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
        this.mUploadBgRSD.resID = 2130846087;
        this.mUploadBgRSD.name = anvx.a(2131714271);
        ApngImage.playByTag(0);
        int m = (int)(Math.max(i, j) - bhdz.a(this.mContext, 305));
        int n = m * 322 / 572;
        LayoutInflater localLayoutInflater = LayoutInflater.from(this.mContext);
        ResData localResData = new ResData();
        SharedPreferences localSharedPreferences = ThemeBackground.getSharedPreferences(this.mContext, this.app.getAccount(), 0);
        i = 0;
        label636:
        if (i < this.showData.length)
        {
          PageView localPageView = (PageView)localLayoutInflater.inflate(2131562950, null);
          localPageView.init(this.showData[i], i, n, m, null);
          if (i == 0) {
            this.mPageView = localPageView;
          }
          paramBundle = new ResSuitData.BgSuit(null);
          paramBundle.id = "100";
          paramBundle.resID = this.showData[i].themeBgID;
          paramBundle.name = anvx.a(2131714273);
          this.showData[i].defaultBgRSD = paramBundle;
          int k = 0;
          ThemeBackground localThemeBackground = new ThemeBackground();
          localThemeBackground.isDecodeInDiy = true;
          ResSuitData.BgSuit localBgSuit;
          if (2 == i)
          {
            localThemeBackground.path = ((ChatBackgroundManager)this.app.getManager(QQManagerFactory.CHAT_BACKGROUND_MANAGER)).b(null);
            j = k;
            if (!"null".equals(localThemeBackground.path))
            {
              localThemeBackground.img = getLocalDrawable(localThemeBackground.path);
              j = k;
            }
            if ((TextUtils.isEmpty(localThemeBackground.path)) || ("null".equals(localThemeBackground.path))) {
              break label1400;
            }
            localBgSuit = new ResSuitData.BgSuit(null);
            localObject = localThemeBackground.path.substring(localThemeBackground.path.lastIndexOf(File.separator) + 1);
            if (localThemeBackground.path.indexOf(AppConstants.PATH_SYSTEM_BACKGROUND) < 0) {
              break label1380;
            }
            paramBundle = (ChatBackgroundManager)this.app.getManager(QQManagerFactory.CHAT_BACKGROUND_MANAGER);
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
            if (!TextUtils.isEmpty(paramBundle)) {
              break label1394;
            }
            localObject = "0";
            localBgSuit.id = ((String)localObject);
            this.showData[i].usedBgRSD = localBgSuit;
            if (i == 0)
            {
              localResData.path = localThemeBackground.path;
              localResData.id = paramBundle;
            }
            label1150:
            if (j != 0) {
              ThreadManager.post(new ThemeDIYActivity.1(this, this.showData[i].orgSpKey, localThemeBackground, i), 8, null, true);
            }
            localPageView.showPic(this.showData[i].usedBgRSD, null, false, localThemeBackground.img);
            paramBundle = new ThemeDIYActivity.ViewHolder();
            paramBundle.id = i;
            paramBundle.scaleView = localPageView.findViewById(2131369921);
            localPageView.setTag(paramBundle);
            if (i != 0) {
              break label1459;
            }
            this.mScrollLayout.changeAlpha(localPageView, false, 800);
            if (!"100".equals(this.showData[i].usedBgRSD.id)) {
              break label1435;
            }
            blurBg(localResData, this.mPageView.bgDrawable, 1, false);
          }
          for (;;)
          {
            this.mScrollLayout.addView(localPageView);
            i += 1;
            break label636;
            bool = false;
            break;
            j = k;
            if (!this.isDIYThemeBefore) {
              break label814;
            }
            localThemeBackground.path = localSharedPreferences.getString(this.showData[i].orgSpKey, "null");
            j = k;
            if (TextUtils.isEmpty(localThemeBackground.path)) {
              break label814;
            }
            j = k;
            if ("null".equals(localThemeBackground.path)) {
              break label814;
            }
            j = 1;
            break label814;
            paramBundle = "99";
            localBgSuit.aioImg = ((String)localObject);
            break label1100;
            localObject = paramBundle;
            break label1112;
            this.showData[i].usedBgRSD = paramBundle;
            if (i != 0) {
              break label1150;
            }
            localResData.id = paramBundle.id;
            localResData.resID = paramBundle.resID;
            break label1150;
            if (localThemeBackground.img != null)
            {
              blurBg(localResData, localThemeBackground.img, 1, true);
              continue;
              this.mScrollLayout.changeAlpha(localPageView, true, 800);
            }
          }
        }
        label814:
        label1100:
        label1112:
        label1380:
        label1394:
        label1400:
        this.pageIndicator = ((PageIndicator)super.findViewById(2131368814));
        label1435:
        label1459:
        this.pageIndicator.bindScrollViewGroup(this.mScrollLayout);
        this.dataLoad = new ThemeDIYActivity.DataLoading(this);
        this.dataLoad.bindScrollViewGroup(this.mScrollLayout);
        paramBundle = (TabBarView)super.findViewById(2131378035);
        paramBundle.setUnderLineHeight(DisplayUtil.dip2px(this, 4.0F));
        paramBundle.setTabTextSize(16);
        paramBundle.setUnselectColor(-8882056);
        paramBundle.setSelectColor(super.getResources().getColor(2131165357));
        paramBundle.setUnselectColor(super.getResources().getColor(2131165357));
        paramBundle.a.setColor(super.getResources().getColor(2131166606));
        paramBundle.a("");
        paramBundle.a(anvx.a(2131714287));
        paramBundle.a("");
        paramBundle.a(anvx.a(2131714278));
        paramBundle.a("");
        paramBundle.setSelectedTab(1, false);
        paramBundle.setOnTabChangeListener(this.mTypeTabChangeListener);
        paramBundle.setBackgroundDrawable(super.getResources().getDrawable(2130847474));
        this.mResHListView = ((HorizontalListView)super.findViewById(2131378857));
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
        beil.a(this.app, "theme_detail", "201", 150, NetworkUtil.getSystemNetwork(null), 1, this.mUserThemeId, ThemeUtil.getUserCurrentThemeVersion(this.app), "2", "");
        this.mCompactBackup = this.mSystemBarComp;
        this.mSystemBarComp = null;
        new SystemBarCompact(this, true, -5986905).init();
        return true;
      }
      catch (Exception paramBundle)
      {
        break label384;
      }
    }
  }
  
  public void doOnDestroy()
  {
    this.mSystemBarComp = this.mCompactBackup;
    this.mHandler.removeMessages(24);
    this.themeSwitchManager.a = null;
    if (this.app != null) {
      ((VasQuickUpdateManager)this.app.getManager(QQManagerFactory.VAS_QUICKUPDATE_MANAGER)).removeCallBacker(this.callBacker);
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
      paramString = bgyo.a(paramString, new BitmapFactory.Options());
      if (paramString != null) {
        return new asbf(this.mContext.getResources(), paramString);
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
      bdla.b(this.app, "CliOper", "", this.app.getCurrentAccountUin(), "theme_mall", "diy_out", 0, 0, "", "", "", "");
      if (isNeedSave()) {
        try
        {
          this.exitDialog = bhdj.a(this.mContext, 230, super.getResources().getString(2131719347), anvx.a(2131714286), 2131692031, 2131718146, new ThemeDIYActivity.8(this), new ThemeDIYActivity.9(this));
          this.exitDialog.show();
          return true;
        }
        catch (Exception localException)
        {
          QLog.e("ThemeDIYActivity", 1, localException.getMessage());
        }
      }
      bdla.b(this.app, "CliOper", "", this.app.getCurrentAccountUin(), "theme_mall", "diy_outsuccess", 0, 1, "0", "", "", "");
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
        localObject = anvx.a(2131714282);
        paramDialogInterface = "1450000516";
        paramInt = 2;
      }
      gotoOpenQQVip(3, (String)localObject, str, paramDialogInterface);
    }
    for (;;)
    {
      bdla.b(this.app, "CliOper", "", this.app.getCurrentAccountUin(), "theme_mall", "diy_save_tips", 0, 0, String.valueOf(paramInt), "", "", "");
      return;
      if (5 == j)
      {
        localObject = this.app;
        str = this.app.getCurrentAccountUin();
        if (paramInt == 1) {}
        for (paramDialogInterface = "diy_check";; paramDialogInterface = "diy_check_no")
        {
          bdla.b((QQAppInterface)localObject, "CliOper", "", str, "theme_mall", paramDialogInterface, 0, 1, "", "", "", "");
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
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      onBackEvent();
      continue;
      saveOperate(true);
      bdla.b(this.app, "CliOper", "", this.app.getCurrentAccountUin(), "theme_mall", "diy_save", 0, 0, "", "", "", "");
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
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
      i = super.getResources().getColor(2131167084);
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
      showTips(5, 0, null, anvx.a(2131714274), null, anvx.a(2131714268), null);
    }
    this.mIsSaving.set(false);
    this.isDIYThemeBefore = true;
    this.mAdapter.isDIYThemeBefore = this.isDIYThemeBefore;
    this.mUserThemeId = ThemeUtil.getCurrentThemeId();
  }
  
  public void onScreenChange(int paramInt)
  {
    bdla.b(this.app, "CliOper", "", this.app.getCurrentAccountUin(), "theme_mall", "skim_page2", 0, 0, String.valueOf(paramInt), "", "", "");
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
        paramObject = anvx.a(2131714277);
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
        QQToast.a(this.mContext, 2131719327, 3000).b(this.mContext.getResources().getDimensionPixelSize(2131299080));
        return;
        i = 4;
        paramObject = localObject;
        localObject = str1;
        continue;
        paramObject = anvx.a(2131714269);
        if (!TextUtils.isEmpty(str1)) {
          break label446;
        }
        localObject = anvx.a(2131714280);
        i = 1;
        continue;
        paramObject = localObject;
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          paramObject = anvx.a(2131714284);
        }
        if (TextUtils.isEmpty(str1))
        {
          localObject = anvx.a(2131714266);
          i = 2;
        }
      }
      else
      {
        bdla.b(this.app, "CliOper", "", this.app.getCurrentAccountUin(), "theme_mall", "diy_save_tips", 0, 0, "0", "", "", "");
        QLog.e("ThemeDIYActivity", 1, "saveOperate fail, ret=" + j + ", msg=" + paramObject);
        if ((!TextUtils.isEmpty(str2)) && (TextUtils.isEmpty((CharSequence)localObject))) {
          localObject = anvx.a(2131714283);
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
          this.mHandler.sendMessage(Message.obtain(this.mHandler, 27, anvx.a(2131714292)));
          return;
        }
      }
      finally {}
      this.mHandler.removeMessages(24);
      int j = NetworkUtil.getSystemNetwork(this.mContext);
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
      setProgessDialog(true, 2131719326);
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
        this.progessDialog = new bisl(this.mContext, getTitleBarHeight());
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
      paramString1 = anvx.a(2131714272);
    }
    for (;;)
    {
      if (TextUtils.isEmpty(paramString2)) {
        paramString2 = anvx.a(2131714279);
      }
      for (;;)
      {
        if (TextUtils.isEmpty(paramString3)) {
          paramString3 = anvx.a(2131714285);
        }
        for (;;)
        {
          if (TextUtils.isEmpty(paramString4)) {
            paramString4 = anvx.a(2131714290);
          }
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("ThemeDIYActivity", 1, "showTips content=" + paramString2 + ", title=" + paramString1);
            }
            paramString1 = bhdj.a(this.mContext, 0, paramString1, paramString2, paramString3, paramString4, this, this);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.theme.diy.ThemeDIYActivity
 * JD-Core Version:    0.7.0.1
 */