package com.tencent.mobileqq.minigame.manager;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.apkg.CommExtInfo;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.appbrand.ui.AppBrandLaunchUI;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.mobileqq.mini.sdk.MiniAppException;
import com.tencent.mobileqq.mini.util.StorageUtil;
import com.tencent.mobileqq.minigame.ui.GameActivity;
import com.tencent.mobileqq.minigame.ui.GameActivity1;
import com.tencent.mobileqq.minigame.utils.GameWnsUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQCustomDialogForMiniGame;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.util.GsonUtils;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GameCloseManager
{
  private static final String MINI_BATTLE_GAME_SHOW_ALERT_VIEW_SCENES = GameWnsUtils.getBattleGameShowAlertViewScenes();
  private static final int MINI_GAME_DROP_GUIDE_EXPOSURE_TIMES_THRESHOLD;
  private static final int MINI_GAME_RETAIN_CONFIRM_EXPOSURE_TIMES_THRESHOLD = ;
  private static final String PREF_KEY_MINI_GAME_GUIDE_DIALOG_EXPOSURE_TIMES = "pref_key_mini_game_guide_dialog_exposure_times";
  private static final String PREF_KEY_MINI_GAME_RETAIN_CONFIRM_EXPOSURE_TIMES = "pref_key_mini_game_retain_confirm_exposure_times";
  private static final String PREF_KEY_MINI_GAME_RETAIN_CONFIRM_LAST_EXPOSE_TIMESTAMP = "pref_key_mini_game_retain_confirm_last_expose_timestamp";
  private static final int RETAIN_MAX_FRIEND_NUM = 3;
  private static final int RETAIN_RECOMMEND_APP_NUM = 3;
  private static final int SCENE_JUMPING_GAME = 2113;
  private static final String TAG = "GameCloseManager";
  private static ArrayList<GameCloseManager.MiniAppViewItem> miniAppViewItemArrayList = new ArrayList();
  
  static
  {
    MINI_GAME_DROP_GUIDE_EXPOSURE_TIMES_THRESHOLD = GameWnsUtils.getDropGuideShowTimes();
  }
  
  private static boolean checkInterval(Activity paramActivity)
  {
    int i = GameWnsUtils.getRetainConfirmInterval();
    if ((paramActivity instanceof GameActivity1)) {
      l = ((GameActivity1)paramActivity).getStartTime();
    } else {
      l = 0L;
    }
    long l = (System.currentTimeMillis() - l) / 1000L;
    if (l > i)
    {
      paramActivity = new StringBuilder();
      paramActivity.append("showRetainGuideDialog: not show, duration=");
      paramActivity.append(l);
      paramActivity.append(" timeInterval=");
      paramActivity.append(i);
      QLog.i("GameCloseManager", 1, paramActivity.toString());
      return true;
    }
    return false;
  }
  
  private static void doShowDropGuideDialog(Activity paramActivity, MiniAppConfig paramMiniAppConfig, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener)
  {
    Object localObject = QzoneConfig.getInstance().getConfig("qqminiapp", "qqMiniappDropGuideImageUrl", "https://sola.gtimg.cn/aoi/sola/20210226113308_nLvM2BA8VH.png");
    paramActivity = new Dialog(paramActivity, 2131953303);
    paramActivity.setCancelable(false);
    paramActivity.setContentView(2131625368);
    ((ImageView)paramActivity.findViewById(2131438599)).setImageDrawable(MiniAppUtils.getDrawable((String)localObject, null));
    localObject = (TextView)paramActivity.findViewById(2131438600);
    SpannableString localSpannableString = new SpannableString("玩过的小游戏可以在首页\"下拉\"找到哦");
    localSpannableString.setSpan(new ForegroundColorSpan(-16725505), 12, 14, 33);
    ((TextView)localObject).setText(localSpannableString);
    ((Button)paramActivity.findViewById(2131438598)).setOnClickListener(new GameCloseManager.4(paramMiniAppConfig, paramString1, paramString2, paramActivity, paramOnClickListener));
    paramActivity.show();
    MiniProgramLpReportDC04239.reportByDropGuideDialog(paramMiniAppConfig, "xiala_popup", "popup", "click", paramString1, paramString2);
  }
  
  @RequiresApi(api=16)
  private static void doShowRetainDialog(Activity paramActivity, MiniAppConfig paramMiniAppConfig, MiniAppInfo paramMiniAppInfo, String paramString1, ArrayList<MiniAppInfo> paramArrayList, String paramString2, DialogInterface.OnClickListener paramOnClickListener, GameCloseManager.ChangeAllOnClickListener paramChangeAllOnClickListener)
  {
    Object localObject2 = QzoneConfig.getInstance().getConfig("qqminiapp", "qqMiniappRetainChangeAll", "https://sola.gtimg.cn/aoi/sola/20201023212055_vhmnkmRvWb.png");
    Object localObject3 = QzoneConfig.getInstance().getConfig("qqminiapp", "qqMiniappRetainBackgroundUrl", "https://sola.gtimg.cn/aoi/sola/20201026161621_WQxgnG17wP.png");
    Object localObject1 = QzoneConfig.getInstance().getConfig("qqminiapp", "qqMiniappRetainLeftBtnBackgroundUrl", "https://sola.gtimg.cn/aoi/sola/20201026161621_qKiWYA1Hc2.png");
    paramString2 = QzoneConfig.getInstance().getConfig("qqminiapp", "qqMiniappRetainRightBtnBackgroundUrl", "https://sola.gtimg.cn/aoi/sola/20201026161621_z77QU6MeWL.png");
    QQCustomDialogForMiniGame localQQCustomDialogForMiniGame = new QQCustomDialogForMiniGame(paramActivity, 2131953303);
    localQQCustomDialogForMiniGame.setContentView(2131624611);
    localQQCustomDialogForMiniGame.setBodyLayoutNoMargin();
    localQQCustomDialogForMiniGame.setBackground(2130842123);
    View localView = LayoutInflater.from(paramActivity).inflate(2131625370, null, false);
    Object localObject4 = (LinearLayout)localView.findViewById(2131438719);
    ((ImageView)localView.findViewById(2131438718)).setImageDrawable(MiniAppUtils.getDrawable((String)localObject2, null));
    GameCloseManager.ChangeAllOnClickListener.access$002(paramChangeAllOnClickListener, paramActivity);
    paramChangeAllOnClickListener.dialog = localQQCustomDialogForMiniGame;
    paramChangeAllOnClickListener.closeListener = paramOnClickListener;
    ((LinearLayout)localObject4).setOnClickListener(paramChangeAllOnClickListener);
    localView.setBackground(MiniAppUtils.getDrawable((String)localObject3, null));
    localObject2 = new LinearLayout.LayoutParams(ViewUtils.dpToPx(296.0F), ViewUtils.dpToPx(255.0F));
    ((LinearLayout.LayoutParams)localObject2).gravity = 17;
    localObject3 = (LinearLayout)localView.findViewById(2131444458);
    miniAppViewItemArrayList.clear();
    int i = 0;
    paramChangeAllOnClickListener = (GameCloseManager.ChangeAllOnClickListener)localObject1;
    while (i < 3)
    {
      localObject1 = new GameCloseManager.MiniAppViewItem(paramActivity);
      localObject4 = (MiniAppInfo)paramArrayList.get(i);
      ((GameCloseManager.MiniAppViewItem)localObject1).setData((MiniAppInfo)localObject4, new GameCloseManager.1((MiniAppInfo)localObject4, localQQCustomDialogForMiniGame, paramOnClickListener, paramActivity, paramMiniAppConfig));
      miniAppViewItemArrayList.add(localObject1);
      ((LinearLayout)localObject3).addView(GameCloseManager.MiniAppViewItem.access$200((GameCloseManager.MiniAppViewItem)localObject1));
      if (i != 2) {
        ((LinearLayout)localObject3).addView(GameCloseManager.MiniAppPatitionLineViewItem.access$300(new GameCloseManager.MiniAppPatitionLineViewItem(paramActivity)));
      }
      localObject1 = new MiniAppConfig((MiniAppInfo)localObject4);
      localObject4 = new LaunchParam();
      ((LaunchParam)localObject4).scene = 2113;
      ((MiniAppConfig)localObject1).launchParam = ((LaunchParam)localObject4);
      MiniProgramLpReportDC04239.reportAsync((MiniAppConfig)localObject1, "page_view", "expo", "", "");
      i += 1;
    }
    localQQCustomDialogForMiniGame.setCancelable(true);
    localQQCustomDialogForMiniGame.setTitle(null).setMessage(null).addView(localView, (LinearLayout.LayoutParams)localObject2).setNegativeButton(2131891811, new GameCloseManager.3(paramMiniAppInfo, paramOnClickListener, paramActivity, paramMiniAppConfig)).setPositiveButton(2131891812, new GameCloseManager.2(paramMiniAppInfo, paramString1, paramOnClickListener, paramActivity, paramMiniAppConfig));
    localQQCustomDialogForMiniGame.getBtnight().setTypeface(Typeface.DEFAULT, 1);
    localQQCustomDialogForMiniGame.getBtnight().setTextColor(-1);
    localQQCustomDialogForMiniGame.getBtnight().setBackground(MiniAppUtils.getDrawable(paramString2, null));
    localQQCustomDialogForMiniGame.getBtnLeft().setTypeface(Typeface.DEFAULT, 1);
    localQQCustomDialogForMiniGame.getBtnLeft().setTextColor(-1);
    localQQCustomDialogForMiniGame.getBtnLeft().setBackground(MiniAppUtils.getDrawable(paramChangeAllOnClickListener, null));
    paramActivity = (LinearLayout.LayoutParams)localQQCustomDialogForMiniGame.getBtnight().getLayoutParams();
    paramActivity.height = ViewUtils.dpToPx(52.0F);
    localQQCustomDialogForMiniGame.getBtnight().setLayoutParams(paramActivity);
    paramActivity = (LinearLayout.LayoutParams)localQQCustomDialogForMiniGame.getBtnLeft().getLayoutParams();
    paramActivity.height = ViewUtils.dpToPx(52.0F);
    localQQCustomDialogForMiniGame.getBtnLeft().setLayoutParams(paramActivity);
    localQQCustomDialogForMiniGame.show();
    MiniProgramLpReportDC04239.reportAsync(paramMiniAppConfig, "minigame_popup", "popup", "expo", "");
  }
  
  private static int getDropGuideDialogShowTimes()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("pref_key_mini_game_guide_dialog_exposure_times_");
    ((StringBuilder)localObject).append(BaseApplicationImpl.getApplication().getRuntime().getAccount());
    localObject = ((StringBuilder)localObject).toString();
    return StorageUtil.getPreference().getInt((String)localObject, 0);
  }
  
  private static int getRetainDialogShowTimes()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("pref_key_mini_game_retain_confirm_exposure_times_");
    ((StringBuilder)localObject).append(BaseApplicationImpl.getApplication().getRuntime().getAccount());
    localObject = ((StringBuilder)localObject).toString();
    int j = StorageUtil.getPreference().getInt((String)localObject, 0);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("pref_key_mini_game_retain_confirm_last_expose_timestamp_");
    ((StringBuilder)localObject).append(BaseApplicationImpl.getApplication().getRuntime().getAccount());
    localObject = ((StringBuilder)localObject).toString();
    long l = StorageUtil.getPreference().getLong((String)localObject, 0L);
    localObject = Calendar.getInstance();
    ((Calendar)localObject).setTimeInMillis(l);
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(System.currentTimeMillis());
    int k = ((Calendar)localObject).get(6);
    int m = localCalendar.get(6);
    int i = 1;
    if ((k != m) || (((Calendar)localObject).get(1) != localCalendar.get(1))) {
      i = 0;
    }
    if (i == 0) {
      j = 0;
    }
    return j;
  }
  
  private static String getRetainInfoCache(String paramString1, int paramInt, String paramString2)
  {
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("retain_confirm_");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append(str);
    localStringBuilder.append("_");
    localStringBuilder.append(String.valueOf(paramInt));
    localStringBuilder.append("_");
    localStringBuilder.append(paramString2);
    paramString1 = localStringBuilder.toString();
    return StorageUtil.getPreference().getString(paramString1, null);
  }
  
  private static void handleClick(MiniAppInfo paramMiniAppInfo, String paramString, DialogInterface paramDialogInterface, int paramInt, DialogInterface.OnClickListener paramOnClickListener, Activity paramActivity, boolean paramBoolean)
  {
    if (paramBoolean) {
      if (!TextUtils.isEmpty(paramString))
      {
        paramMiniAppInfo = new Intent(paramActivity, AppBrandLaunchUI.class);
        paramMiniAppInfo.putExtra("from", "SchemeJsPlugin");
        paramMiniAppInfo.putExtra("scheme", paramString);
        paramActivity.startActivity(paramMiniAppInfo);
      }
      else
      {
        try
        {
          MiniAppController.launchMiniAppByAppInfo(paramActivity, paramMiniAppInfo, 2113);
        }
        catch (MiniAppException paramMiniAppInfo)
        {
          QLog.e("GameCloseManager", 1, "launch more game error", paramMiniAppInfo);
        }
      }
    }
    paramDialogInterface.dismiss();
    if (paramOnClickListener != null) {
      paramOnClickListener.onClick(paramDialogInterface, paramInt);
    }
  }
  
  public static boolean handleDropGuideDialog(Activity paramActivity, MiniAppConfig paramMiniAppConfig, DialogInterface.OnClickListener paramOnClickListener)
  {
    String str3 = QzoneConfig.getInstance().getConfig("qqminiapp", "qqMiniappDropGuideSceneBlackList", "1001,3001,3002,3003,3007,3009,3010,3013,3015,3022,3024,3026,3027,3028,3029,2086,2103");
    String str4 = QzoneConfig.getInstance().getConfig("qqminiapp", "qqMiniappDropGuideSceneAndViaBlackList", "[{\"scene\":2054,\"via\":\"2054_3\"}]");
    String str5 = QzoneConfig.getInstance().getConfig("qqminiapp", "qqMiniappDropGuideSceneAndModeBlackList", "desktoprecent,main,friendmore,maintj,mainph,mainpk,mainguess,pkdesktop,mainfriend");
    int i;
    if (paramMiniAppConfig.launchParam == null) {
      i = 0;
    } else {
      i = paramMiniAppConfig.launchParam.scene;
    }
    String str1 = paramMiniAppConfig.config.via;
    String str2 = "";
    if (str1 == null) {
      str1 = "";
    } else {
      str1 = paramMiniAppConfig.config.via;
    }
    Object localObject;
    if ((paramMiniAppConfig.launchParam != null) && (!TextUtils.isEmpty(paramMiniAppConfig.launchParam.reportData)))
    {
      localObject = parseModeAndLocation(paramMiniAppConfig.launchParam.reportData);
      str2 = localObject[0];
      localObject = localObject[1];
    }
    else
    {
      localObject = "";
    }
    int j = getDropGuideDialogShowTimes();
    if (j >= MINI_GAME_DROP_GUIDE_EXPOSURE_TIMES_THRESHOLD)
    {
      QLog.i("GameCloseManager", 1, "handleDropGuideDialog: not show, show too many times");
      return false;
    }
    if ((!isInSceneBlackList(i, str3)) && (!isInSceneAndViaBlackList(i, str1, str4)) && (!isInSceneAndModeBlackList(i, str2, str5)))
    {
      doShowDropGuideDialog(paramActivity, paramMiniAppConfig, str2, (String)localObject, paramOnClickListener);
      updateDropGuideDialogShowTimes(j);
      return true;
    }
    QLog.i("GameCloseManager", 1, "handleDropGuideDialog: not show, is in blacklist");
    return false;
  }
  
  public static boolean handleRetainGuideDialog(Activity paramActivity, MiniAppConfig paramMiniAppConfig, DialogInterface.OnClickListener paramOnClickListener)
  {
    boolean bool2 = false;
    String str2;
    int i;
    Object localObject1;
    int j;
    int k;
    boolean bool1;
    int m;
    String str1;
    if (paramMiniAppConfig != null)
    {
      if (paramMiniAppConfig.config == null) {
        return false;
      }
      str2 = paramMiniAppConfig.config.appId;
      if (paramMiniAppConfig.launchParam == null) {
        i = 0;
      } else {
        i = paramMiniAppConfig.launchParam.scene;
      }
      if (paramMiniAppConfig.config.via == null) {
        localObject1 = "";
      } else {
        localObject1 = paramMiniAppConfig.config.via;
      }
      j = paramMiniAppConfig.config.verType;
      if (paramActivity != null)
      {
        if (TextUtils.isEmpty(str2)) {
          return false;
        }
        k = paramActivity.getRequestedOrientation();
        if ((k != 0) && (k != 8) && (k != 6) && (k != 11)) {
          bool1 = false;
        } else {
          bool1 = true;
        }
        if (i == 2113)
        {
          QLog.i("GameCloseManager", 1, "showRetainGuideDialog: not show, scene == 2113");
          return false;
        }
        m = getRetainDialogShowTimes();
        if (m >= MINI_GAME_RETAIN_CONFIRM_EXPOSURE_TIMES_THRESHOLD)
        {
          QLog.i("GameCloseManager", 1, "showRetainGuideDialog: not show, show too many times");
          return false;
        }
        str1 = getRetainInfoCache(str2, i, (String)localObject1);
        if (TextUtils.isEmpty(str1))
        {
          QLog.i("GameCloseManager", 1, "showRetainGuideDialog: not show, no result cache");
          return false;
        }
      }
    }
    for (;;)
    {
      try
      {
        Object localObject2 = new JSONObject(str1);
        MiniAppInfo localMiniAppInfo = parseMoreAppInfo((JSONObject)localObject2);
        if (localMiniAppInfo == null) {
          return false;
        }
        int n = parsePopupType((JSONObject)localObject2);
        if (n == 2)
        {
          QLog.i("GameCloseManager", 1, "showRetainGuideDialog: not show, popupType=INTERFACE.NotPopup");
          return false;
        }
        if ((n == 0) && (checkInterval(paramActivity))) {
          return false;
        }
        ArrayList localArrayList = parseRecommendList((JSONObject)localObject2);
        if (localArrayList != null)
        {
          if (localArrayList.size() < 3) {
            return false;
          }
          if (bool1) {
            break label515;
          }
          str1 = parseBackgroundPic((JSONObject)localObject2);
          String str3 = parseMoreAppLink((JSONObject)localObject2);
          localObject2 = parseCommExtInfo((JSONObject)localObject2);
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("orientation:");
          localStringBuilder.append(k);
          localStringBuilder.append(" isLandscape:");
          localStringBuilder.append(bool1);
          localStringBuilder.append(" searchLeadImgUrl:");
          localStringBuilder.append(str1);
          localStringBuilder.append(" moreAppLink:");
          localStringBuilder.append(str3);
          QLog.i("GameCloseManager", 1, localStringBuilder.toString());
          if (Build.VERSION.SDK_INT >= 16)
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(i);
            localStringBuilder.append("");
            localObject1 = new GameCloseManager.ChangeAllOnClickListener(paramActivity, str2, j, localStringBuilder.toString(), (String)localObject1, paramMiniAppConfig);
            ((GameCloseManager.ChangeAllOnClickListener)localObject1).ext = ((CommExtInfo)localObject2);
            doShowRetainDialog(paramActivity, paramMiniAppConfig, localMiniAppInfo, str3, localArrayList, str1, paramOnClickListener, (GameCloseManager.ChangeAllOnClickListener)localObject1);
          }
          updateRetainDialogShowTimes(m);
          bool2 = true;
        }
        return bool2;
      }
      catch (Exception paramActivity)
      {
        QLog.e("GameCloseManager", 1, "showRetainGuideDialog: not show, parse json error", paramActivity);
      }
      return false;
      label515:
      str1 = null;
    }
  }
  
  private static boolean isInSceneAndModeBlackList(int paramInt, String paramString1, String paramString2)
  {
    int i = 0;
    if (paramInt != 2001) {
      return false;
    }
    ArrayList localArrayList = new ArrayList();
    paramString2 = paramString2.split(",");
    int j = paramString2.length;
    paramInt = i;
    while (paramInt < j)
    {
      CharSequence localCharSequence = paramString2[paramInt];
      if (!TextUtils.isEmpty(localCharSequence)) {
        localArrayList.add(localCharSequence);
      }
      paramInt += 1;
    }
    return localArrayList.contains(paramString1);
  }
  
  private static boolean isInSceneAndViaBlackList(int paramInt, String paramString1, String paramString2)
  {
    try
    {
      paramString2 = new JSONArray(paramString2);
      int i = 0;
      while (i < paramString2.length())
      {
        Object localObject = paramString2.getJSONObject(i);
        int j = ((JSONObject)localObject).getInt("scene");
        localObject = ((JSONObject)localObject).getString("via");
        if ((paramInt == j) && (!TextUtils.isEmpty(paramString1)))
        {
          boolean bool = paramString1.equals(localObject);
          if (bool) {
            return true;
          }
        }
        i += 1;
      }
      return false;
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  private static boolean isInSceneBlackList(int paramInt, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    paramString = paramString.split(",");
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      CharSequence localCharSequence = paramString[i];
      if (!TextUtils.isEmpty(localCharSequence)) {
        localArrayList.add(localCharSequence);
      }
      i += 1;
    }
    return localArrayList.contains(String.valueOf(paramInt));
  }
  
  private static String parseBackgroundPic(JSONObject paramJSONObject)
  {
    return paramJSONObject.optString("backgroundPic");
  }
  
  private static CommExtInfo parseCommExtInfo(JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.optString("ext");
    if (TextUtils.isEmpty(paramJSONObject)) {
      return null;
    }
    return (CommExtInfo)GsonUtils.json2Obj(paramJSONObject, CommExtInfo.class);
  }
  
  private static String[] parseModeAndLocation(String paramString)
  {
    String[] arrayOfString = paramString.split("&");
    int j = arrayOfString.length;
    Object localObject2 = "";
    paramString = (String)localObject2;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      Object localObject1 = localObject2;
      if (str.contains("mode"))
      {
        localObject3 = str.split("=");
        localObject1 = localObject2;
        if (localObject3.length > 1) {
          localObject1 = localObject3[1];
        }
      }
      Object localObject3 = paramString;
      if (str.contains("location"))
      {
        localObject2 = str.split("=");
        localObject3 = paramString;
        if (localObject2.length > 1) {
          localObject3 = localObject2[1];
        }
      }
      i += 1;
      localObject2 = localObject1;
      paramString = (String)localObject3;
    }
    return new String[] { localObject2, paramString };
  }
  
  private static MiniAppInfo parseMoreAppInfo(JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.optString("moreAppInfo");
    if (TextUtils.isEmpty(paramJSONObject))
    {
      QLog.i("GameCloseManager", 1, "showRetainGuideDialog: not show, moreAppStr == null");
      return null;
    }
    return (MiniAppInfo)GsonUtils.json2Obj(paramJSONObject, MiniAppInfo.class);
  }
  
  private static String parseMoreAppLink(JSONObject paramJSONObject)
  {
    return paramJSONObject.optString("jumpLink");
  }
  
  private static int parsePopupType(JSONObject paramJSONObject)
  {
    return paramJSONObject.optInt("popupType");
  }
  
  private static ArrayList<MiniAppInfo> parseRecommendList(JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.optJSONArray("appList");
    if ((paramJSONObject != null) && (paramJSONObject.length() >= 3))
    {
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < 3)
      {
        MiniAppInfo localMiniAppInfo = (MiniAppInfo)GsonUtils.json2Obj(paramJSONObject.getString(i), MiniAppInfo.class);
        if (localMiniAppInfo != null) {
          localArrayList.add(localMiniAppInfo);
        }
        i += 1;
      }
      return localArrayList;
    }
    QLog.i("GameCloseManager", 1, "showRetainGuideDialog: not show, appList is empty or too small");
    return null;
  }
  
  private static boolean shouldShowAlertViewForBattleGame(MiniAppConfig paramMiniAppConfig)
  {
    if ((paramMiniAppConfig != null) && (paramMiniAppConfig.config != null) && (paramMiniAppConfig.config.whiteList != null) && (paramMiniAppConfig.launchParam != null))
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(" api ");
      ((StringBuilder)localObject1).append(Arrays.toString(paramMiniAppConfig.config.whiteList.toArray()));
      ((StringBuilder)localObject1).append(" scenes ");
      ((StringBuilder)localObject1).append(MINI_BATTLE_GAME_SHOW_ALERT_VIEW_SCENES);
      QLog.d("GameCloseManager", 2, new Object[] { "shouldShowAlertViewForBattleGame ", ((StringBuilder)localObject1).toString() });
      localObject1 = paramMiniAppConfig.config.whiteList.iterator();
      for (;;)
      {
        if (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (String)((Iterator)localObject1).next();
          if ("showRetainAlterViewType1".equals(localObject2)) {
            return true;
          }
          if ((!((String)localObject2).startsWith("showRetainAlterViewType")) || (TextUtils.isEmpty(MINI_BATTLE_GAME_SHOW_ALERT_VIEW_SCENES))) {
            continue;
          }
          try
          {
            localObject2 = new JSONObject(MINI_BATTLE_GAME_SHOW_ALERT_VIEW_SCENES).optJSONArray(((String)localObject2).replace("showRetainAlterViewType", ""));
            if (localObject2 != null)
            {
              int j = ((JSONArray)localObject2).length();
              int i = 0;
              while (i < j)
              {
                int k = ((JSONArray)localObject2).optInt(i, 0);
                int m = paramMiniAppConfig.launchParam.scene;
                if (k == m) {
                  return true;
                }
                i += 1;
              }
            }
          }
          catch (Exception localException)
          {
            QLog.e("GameCloseManager", 1, "shouldShowAlertViewForBattleGame ", localException);
          }
        }
      }
    }
    return false;
  }
  
  public static boolean showAlertViewForBattleGame(GameActivity paramGameActivity, MiniAppConfig paramMiniAppConfig, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramGameActivity != null)
    {
      if (paramMiniAppConfig == null) {
        return false;
      }
      if (shouldShowAlertViewForBattleGame(paramMiniAppConfig))
      {
        paramGameActivity = DialogUtil.a(paramGameActivity, 230).setTitle(paramGameActivity.getString(2131917233)).setMessage(paramGameActivity.getString(2131891755)).setNegativeButton(paramGameActivity.getString(2131887648), new GameCloseManager.6()).setPositiveButton(paramGameActivity.getString(2131891754), new GameCloseManager.5(paramOnClickListener));
        paramGameActivity.setCancelable(false);
        paramGameActivity.show();
        return true;
      }
    }
    return false;
  }
  
  private static void updateDropGuideDialogShowTimes(int paramInt)
  {
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("pref_key_mini_game_guide_dialog_exposure_times_");
    ((StringBuilder)localObject).append(str);
    str = ((StringBuilder)localObject).toString();
    localObject = StorageUtil.getPreference().edit();
    ((SharedPreferences.Editor)localObject).putInt(str, paramInt + 1);
    ((SharedPreferences.Editor)localObject).apply();
  }
  
  private static void updateRetainDialogShowTimes(int paramInt)
  {
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("pref_key_mini_game_retain_confirm_exposure_times_");
    ((StringBuilder)localObject1).append(str);
    Object localObject2 = ((StringBuilder)localObject1).toString();
    localObject1 = StorageUtil.getPreference().edit();
    ((SharedPreferences.Editor)localObject1).putInt((String)localObject2, paramInt + 1);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("pref_key_mini_game_retain_confirm_last_expose_timestamp_");
    ((StringBuilder)localObject2).append(str);
    ((SharedPreferences.Editor)localObject1).putLong(((StringBuilder)localObject2).toString(), System.currentTimeMillis());
    ((SharedPreferences.Editor)localObject1).apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.manager.GameCloseManager
 * JD-Core Version:    0.7.0.1
 */