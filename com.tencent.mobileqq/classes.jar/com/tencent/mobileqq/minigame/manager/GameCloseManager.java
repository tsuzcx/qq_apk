package com.tencent.mobileqq.minigame.manager;

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
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import bbdj;
import bbgu;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.util.StorageUtil;
import com.tencent.mobileqq.minigame.ui.GameActivity;
import com.tencent.mobileqq.minigame.utils.GameWnsUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class GameCloseManager
{
  private static final String MINI_BATTLE_GAME_SHOW_ALERT_VIEW_SCENES = GameWnsUtils.getBattleGameShowAlertViewScenes();
  private static final int MINI_GAME_CLOSE_CONFIRM_EXPOSURE_TIMES_THRESHOLD = ;
  private static final String PREF_KEY_MINI_GAME_CLOSE_CONFIRM_EXPOSURE_TIMES = "pref_key_mini_game_close_confirm_exposure_times";
  private static final String TAG = "GameCloseManager";
  
  private static boolean isFromDesktop(int paramInt)
  {
    return (paramInt >= 3001) && (paramInt <= 3010);
  }
  
  private static boolean isInWnsBlackList(int paramInt)
  {
    boolean bool2 = false;
    try
    {
      Object localObject = GameWnsUtils.getExitConfirmAnimationBlackList();
      boolean bool1 = bool2;
      int j;
      int i;
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = ((String)localObject).split(",");
        bool1 = bool2;
        if (localObject != null)
        {
          j = localObject.length;
          i = 0;
        }
      }
      for (;;)
      {
        bool1 = bool2;
        String str;
        if (i < j) {
          str = localObject[i];
        }
        try
        {
          int k = Integer.parseInt(str);
          if (k == paramInt)
          {
            bool1 = true;
            return bool1;
          }
        }
        catch (Exception localException)
        {
          QLog.e("GameCloseManager", 2, "isInWnsBlackList", localException);
          i += 1;
        }
      }
      return false;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("GameCloseManager", 2, "isInWnsBlackList", localThrowable);
    }
  }
  
  private static boolean shouldShowAlertViewForBattleGame(MiniAppConfig paramMiniAppConfig)
  {
    if ((paramMiniAppConfig != null) && (paramMiniAppConfig.config != null) && (paramMiniAppConfig.config.whiteList != null) && (paramMiniAppConfig.launchParam != null))
    {
      QLog.d("GameCloseManager", 2, new Object[] { "shouldShowAlertViewForBattleGame ", " api " + Arrays.toString(paramMiniAppConfig.config.whiteList.toArray()) + " scenes " + MINI_BATTLE_GAME_SHOW_ALERT_VIEW_SCENES });
      Iterator localIterator = paramMiniAppConfig.config.whiteList.iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          Object localObject = (String)localIterator.next();
          if ("showRetainAlterViewType1".equals(localObject)) {
            return true;
          }
          if ((!((String)localObject).startsWith("showRetainAlterViewType")) || (TextUtils.isEmpty(MINI_BATTLE_GAME_SHOW_ALERT_VIEW_SCENES))) {
            continue;
          }
          try
          {
            localObject = new JSONObject(MINI_BATTLE_GAME_SHOW_ALERT_VIEW_SCENES).optJSONArray(((String)localObject).replace("showRetainAlterViewType", ""));
            if (localObject != null)
            {
              int j = ((JSONArray)localObject).length();
              int i = 0;
              while (i < j)
              {
                int k = ((JSONArray)localObject).optInt(i, 0);
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
    if ((paramGameActivity == null) || (paramMiniAppConfig == null)) {}
    while (!shouldShowAlertViewForBattleGame(paramMiniAppConfig)) {
      return false;
    }
    paramGameActivity = bbdj.a(paramGameActivity, 230).setTitle(paramGameActivity.getString(2131720260)).setMessage(paramGameActivity.getString(2131694271)).setNegativeButton(paramGameActivity.getString(2131690596), new GameCloseManager.3()).setPositiveButton(paramGameActivity.getString(2131694270), new GameCloseManager.2(paramOnClickListener));
    paramGameActivity.setCancelable(false);
    paramGameActivity.show();
    return true;
  }
  
  public static boolean showPullDownGuideDialog(GameActivity paramGameActivity, MiniAppConfig paramMiniAppConfig, DialogInterface.OnClickListener paramOnClickListener)
  {
    if ((paramGameActivity == null) || (paramMiniAppConfig == null)) {}
    int i;
    do
    {
      do
      {
        return false;
      } while ((paramMiniAppConfig.launchParam != null) && ((paramMiniAppConfig.launchParam.scene == 2001) || (paramMiniAppConfig.launchParam.scene == 1001) || (MiniAppUtils.isFromPullDownEntry(paramMiniAppConfig)) || (isInWnsBlackList(paramMiniAppConfig.launchParam.scene))));
      i = StorageUtil.getPreference().getInt("pref_key_mini_game_close_confirm_exposure_times", 0);
    } while (i >= MINI_GAME_CLOSE_CONFIRM_EXPOSURE_TIMES_THRESHOLD);
    paramMiniAppConfig = bbdj.a(paramGameActivity, 230);
    Object localObject = new URLImageView(paramGameActivity);
    ((URLImageView)localObject).setImageDrawable(URLDrawable.getDrawable(GameWnsUtils.getGameExitConfirmImageUrl(), true));
    ((URLImageView)localObject).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    ((URLImageView)localObject).setAdjustViewBounds(true);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    if (paramGameActivity.getIsOrientationLandscape())
    {
      localLayoutParams.width = (paramGameActivity.getResources().getDisplayMetrics().heightPixels / 2);
      localLayoutParams.height = ((int)(localLayoutParams.width / 1.05F));
    }
    localLayoutParams.gravity = 1;
    TextView localTextView = new TextView(paramGameActivity);
    localTextView.setText(Html.fromHtml(paramGameActivity.getApplicationContext().getString(2131694268)), TextView.BufferType.SPANNABLE);
    localTextView.setTextColor(Color.parseColor("#02081B"));
    localTextView.setGravity(17);
    localTextView.setTypeface(Typeface.DEFAULT, 1);
    paramGameActivity = new LinearLayout(paramGameActivity);
    paramGameActivity.setOrientation(1);
    paramGameActivity.addView((View)localObject, localLayoutParams);
    paramGameActivity.addView(localTextView, new LinearLayout.LayoutParams(-2, -2));
    localObject = new LinearLayout.LayoutParams(-2, -2);
    ((LinearLayout.LayoutParams)localObject).gravity = 17;
    paramMiniAppConfig.setCancelable(false);
    paramMiniAppConfig.setTitle(null).setMessage(null).addView(paramGameActivity, (LinearLayout.LayoutParams)localObject).setPositiveButton(2131694436, new GameCloseManager.1(paramOnClickListener));
    paramMiniAppConfig.getBtnight().setTypeface(Typeface.DEFAULT, 1);
    paramMiniAppConfig.show();
    StorageUtil.getPreference().edit().putInt("pref_key_mini_game_close_confirm_exposure_times", i + 1).apply();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.manager.GameCloseManager
 * JD-Core Version:    0.7.0.1
 */