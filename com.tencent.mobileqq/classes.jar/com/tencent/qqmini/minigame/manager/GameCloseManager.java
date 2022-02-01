package com.tencent.qqmini.minigame.manager;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.Html;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.qqmini.minigame.R.string;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.DialogUtil;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.utils.StorageUtil;
import com.tencent.qqmini.sdk.utils.MiniAppUtils;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import com.tencent.qqmini.sdk.widget.MiniCustomDialog;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class GameCloseManager
{
  private static final String MINI_BATTLE_GAME_SHOW_ALERT_VIEW_SCENES = WnsConfig.getConfig("qqminiapp", "qqMiniappRetainAlterViewScene", "{\"2\": [\"2072\"],\"3\": [\"1037\"]}");
  private static final int MINI_GAME_CLOSE_CONFIRM_EXPOSURE_TIMES_THRESHOLD = WnsConfig.getConfig("qqminiapp", "mini_game_exit_confirm_animation_expoure_times_threshold", 3);
  private static final String PREF_KEY_MINI_GAME_CLOSE_CONFIRM_EXPOSURE_TIMES = "pref_key_mini_game_close_confirm_exposure_times";
  private static final String TAG = "GameCloseManager";
  
  private static boolean isFromDesktop(int paramInt)
  {
    return (paramInt >= 3001) && (paramInt <= 3010);
  }
  
  private static boolean isInWnsBlackList(int paramInt)
  {
    try
    {
      Object localObject = WnsConfig.getConfig("qqminiapp", "mini_game_exit_confirm_animation_scene_black_list", "");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = ((String)localObject).split(",");
        if (localObject != null)
        {
          int j = localObject.length;
          int i = 0;
          while (i < j)
          {
            String str = localObject[i];
            try
            {
              int k = Integer.parseInt(str);
              if (k == paramInt) {
                return true;
              }
            }
            catch (Exception localException)
            {
              QMLog.e("GameCloseManager", "isInWnsBlackList", localException);
              i += 1;
            }
          }
        }
      }
      return false;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("GameCloseManager", "isInWnsBlackList", localThrowable);
    }
  }
  
  private static boolean shouldShowAlertViewForBattleGame(MiniAppInfo paramMiniAppInfo)
  {
    if ((paramMiniAppInfo != null) && (paramMiniAppInfo.whiteList != null) && (paramMiniAppInfo.launchParam != null))
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("shouldShowAlertViewForBattleGame api ");
      ((StringBuilder)localObject1).append(Arrays.toString(paramMiniAppInfo.whiteList.toArray()));
      ((StringBuilder)localObject1).append(" scenes ");
      ((StringBuilder)localObject1).append(MINI_BATTLE_GAME_SHOW_ALERT_VIEW_SCENES);
      QMLog.d("GameCloseManager", ((StringBuilder)localObject1).toString());
      localObject1 = paramMiniAppInfo.whiteList.iterator();
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
                int m = paramMiniAppInfo.launchParam.scene;
                if (k == m) {
                  return true;
                }
                i += 1;
              }
            }
          }
          catch (Exception localException)
          {
            QMLog.e("GameCloseManager", "shouldShowAlertViewForBattleGame ", localException);
          }
        }
      }
    }
    return false;
  }
  
  public static boolean showAlertViewForBattleGame(IMiniAppContext paramIMiniAppContext, DialogInterface.OnClickListener paramOnClickListener)
  {
    Activity localActivity = paramIMiniAppContext.getAttachedActivity();
    paramIMiniAppContext = paramIMiniAppContext.getMiniAppInfo();
    if (localActivity != null)
    {
      if (paramIMiniAppContext == null) {
        return false;
      }
      if (shouldShowAlertViewForBattleGame(paramIMiniAppContext))
      {
        paramIMiniAppContext = DialogUtil.createCustomDialog(localActivity, 230).setTitle(localActivity.getString(R.string.mini_sdk_tip)).setMessage(localActivity.getString(R.string.mini_sdk_game_leave_battle_game_message)).setNegativeButton(localActivity.getString(R.string.mini_sdk_cancel), new GameCloseManager.3()).setPositiveButton(localActivity.getString(R.string.mini_sdk_game_leave_battle_game), new GameCloseManager.2(paramOnClickListener));
        paramIMiniAppContext.setCancelable(false);
        paramIMiniAppContext.show();
        return true;
      }
    }
    return false;
  }
  
  public static boolean showPullDownGuideDialog(IMiniAppContext paramIMiniAppContext, DialogInterface.OnClickListener paramOnClickListener)
  {
    Object localObject2 = paramIMiniAppContext.getAttachedActivity();
    Object localObject1 = paramIMiniAppContext.getMiniAppInfo();
    if (localObject2 != null)
    {
      if (localObject1 == null) {
        return false;
      }
      if (!QUAUtil.isQQApp()) {
        return false;
      }
      if ((((MiniAppInfo)localObject1).launchParam != null) && ((((MiniAppInfo)localObject1).launchParam.scene == 2001) || (((MiniAppInfo)localObject1).launchParam.scene == 1001) || (MiniAppUtils.isFromPullDownEntry((MiniAppInfo)localObject1)) || (isInWnsBlackList(((MiniAppInfo)localObject1).launchParam.scene)))) {
        return false;
      }
      Object localObject3 = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
      int i = StorageUtil.getPreference().getInt("pref_key_mini_game_close_confirm_exposure_times", 0);
      if (i < MINI_GAME_CLOSE_CONFIRM_EXPOSURE_TIMES_THRESHOLD)
      {
        localObject1 = DialogUtil.createCustomDialog((Context)localObject2, 230);
        ImageView localImageView = new ImageView((Context)localObject2);
        localImageView.setImageDrawable(((MiniAppProxy)localObject3).getDrawable((Context)localObject2, WnsConfig.getConfig("qqminiapp", "mini_game_exit_confirm_animation_image_url", "https://qzonestyle.gtimg.cn/aoi/sola/20191114160727_AqDlaIYOnx.gif"), 0, 0, null));
        localImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        localImageView.setAdjustViewBounds(true);
        localObject3 = new LinearLayout.LayoutParams(-2, -2);
        if (paramIMiniAppContext.isOrientationLandscape())
        {
          ((LinearLayout.LayoutParams)localObject3).width = (((Activity)localObject2).getResources().getDisplayMetrics().heightPixels / 2);
          ((LinearLayout.LayoutParams)localObject3).height = ((int)(((LinearLayout.LayoutParams)localObject3).width / 1.05F));
        }
        ((LinearLayout.LayoutParams)localObject3).gravity = 1;
        paramIMiniAppContext = new TextView((Context)localObject2);
        paramIMiniAppContext.setText(Html.fromHtml(((Activity)localObject2).getApplicationContext().getString(R.string.mini_sdk_game_close_confirm_hint)), TextView.BufferType.SPANNABLE);
        paramIMiniAppContext.setTextColor(Color.parseColor("#02081B"));
        paramIMiniAppContext.setGravity(17);
        paramIMiniAppContext.setTypeface(Typeface.DEFAULT, 1);
        localObject2 = new LinearLayout((Context)localObject2);
        ((LinearLayout)localObject2).setOrientation(1);
        ((LinearLayout)localObject2).addView(localImageView, (ViewGroup.LayoutParams)localObject3);
        ((LinearLayout)localObject2).addView(paramIMiniAppContext, new LinearLayout.LayoutParams(-2, -2));
        paramIMiniAppContext = new LinearLayout.LayoutParams(-2, -2);
        paramIMiniAppContext.gravity = 17;
        ((MiniCustomDialog)localObject1).setCancelable(false);
        ((MiniCustomDialog)localObject1).setTitle(null).setMessage(null).addView((View)localObject2, paramIMiniAppContext).setPositiveButton("我知道了", new GameCloseManager.1(paramOnClickListener));
        ((MiniCustomDialog)localObject1).getBtnight().setTypeface(Typeface.DEFAULT, 1);
        ((MiniCustomDialog)localObject1).show();
        StorageUtil.getPreference().edit().putInt("pref_key_mini_game_close_confirm_exposure_times", i + 1).apply();
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.minigame.manager.GameCloseManager
 * JD-Core Version:    0.7.0.1
 */