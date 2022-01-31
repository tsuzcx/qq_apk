package com.tencent.mobileqq.theme.diy;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.theme.ThemeUtil.ThemeInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;

public class ThemeDiyStyleLogic
{
  static final String BUNDLE_KEY_INDEX = "index";
  static final String BUNDLE_KEY_PATH = "path";
  static final String BUNDLE_KEY_THEME_INDEX = "themeIndex";
  static final String BUNDLE_OPERATE_BACK_CODE = "operateBackCode";
  static final String BUNDLE_OPERATE_NEXT = "nextOperate";
  static final String BUNDLE_OPERATE_NOW = "nowOperate";
  static final String DIR_SCREENSHOT = AppConstants.aK + "custom_background/";
  static final String DIR_SCREENSHOT_BG = DIR_SCREENSHOT + "bg/";
  static final String DIR_SCREENSHOT_THEME = DIR_SCREENSHOT + "theme/";
  public static final int OPERATE_CODE_GO_ERROR = 8;
  public static final int OPERATE_CODE_GO_OFF = 6;
  public static final int OPERATE_CODE_GO_ON = 4;
  public static final int OPERATE_CODE_GO_WAIT = 2;
  public static final int OPERATE_CODE_NONE = 0;
  public static final int OPERATE_KEY_DEAL_BG = 14;
  public static final int OPERATE_KEY_DOWN_BG = 13;
  public static final int OPERATE_KEY_PREPARE = 11;
  public static final int OPERATE_KEY_SAVE = 10;
  public static final int OPERATE_KEY_SAVE_SERVER = 16;
  public static final int OPERATE_KEY_SWITCH_THEME = 15;
  public static final int OPERATE_KEY_UPDATE_PAGE = 18;
  static final String RES_MALL_URL = "http://i.gtimg.cn/qqshow/admindata/comdata/";
  public static final String SPLIT_KEY = "__";
  static final String TAG = "ThemeDiyStyleLogic";
  QQAppInterface app;
  Context mContext;
  public HashMap reportMap = new HashMap();
  public ThemeDiyStyleLogic.StyleCallBack saveDealCallBack;
  public int styleState;
  
  public ThemeDiyStyleLogic(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    this.app = paramQQAppInterface;
    this.mContext = paramContext;
  }
  
  public static String getDealFileName(ResData paramResData, int paramInt)
  {
    if (paramResData == null) {
      return null;
    }
    return paramInt + "__" + paramResData.id + "__" + paramResData.name;
  }
  
  public static String getDownFileName(ResData paramResData)
  {
    if (paramResData == null) {
      return "__99__" + System.currentTimeMillis() + ".jpg";
    }
    return "__" + paramResData.id + "__" + paramResData.name;
  }
  
  static ThemeUtil.ThemeInfo getThemeInfoByDensity(Context paramContext, ResSuitData.StyleSuit paramStyleSuit)
  {
    if (paramStyleSuit != null)
    {
      if (paramStyleSuit.themeInfo != null) {
        return paramStyleSuit.themeInfo;
      }
      QLog.d("ThemeDiyStyleLogic", 1, "getThemeInfoByDensity resItem.themeJson == null");
      Object localObject2 = ThemeUtil.getThemeInfo(paramContext, paramStyleSuit.id);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new ThemeUtil.ThemeInfo();
        ((ThemeUtil.ThemeInfo)localObject1).themeId = paramStyleSuit.id;
      }
      ((ThemeUtil.ThemeInfo)localObject1).downloadUrl = DIYThemeUtils.getResData(null, paramStyleSuit, 207, paramStyleSuit.zipUrl).url;
      ((ThemeUtil.ThemeInfo)localObject1).size = paramStyleSuit.zipSize;
      ((ThemeUtil.ThemeInfo)localObject1).isVoiceTheme = false;
      if ("999".equals(paramStyleSuit.id)) {}
      for (localObject2 = "20000000";; localObject2 = paramStyleSuit.zipVersion)
      {
        ((ThemeUtil.ThemeInfo)localObject1).version = ((String)localObject2);
        paramStyleSuit.themeInfo = ((ThemeUtil.ThemeInfo)localObject1);
        ThemeUtil.setThemeInfo(paramContext, (ThemeUtil.ThemeInfo)localObject1);
        return localObject1;
      }
    }
    QLog.e("ThemeDiyStyleLogic", 1, "getThemeInfoByDensity error resItem == null");
    return null;
  }
  
  public static boolean isNeedDealDarkBri(ThemeDIYData paramThemeDIYData, int paramInt)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramThemeDIYData != null) && (paramThemeDIYData.dealInt != 0) && ((paramInt != 0) || (paramThemeDIYData.position != 0)))
    {
      bool1 = bool2;
      if (paramInt != 0)
      {
        bool1 = bool2;
        if (paramThemeDIYData.position != 1) {}
      }
    }
    else
    {
      bool1 = false;
    }
    return bool1;
  }
  
  public int dealDarkBrightness(ThemeDIYData paramThemeDIYData, Bundle paramBundle)
  {
    if ((paramThemeDIYData != null) && (paramThemeDIYData.tryOnBgBigOrgRD != null))
    {
      if (paramThemeDIYData.tryOnBgBigOrgRD.state == 5) {
        return 4;
      }
      if (paramThemeDIYData.tryOnBgBigOrgRD.state == 2)
      {
        if (isNeedDealDarkBri(paramThemeDIYData, paramBundle.getInt("themeIndex")))
        {
          paramThemeDIYData.tryOnBgBigOrgRD.state = 5;
          return 4;
        }
        paramBundle = getDealFileName(paramThemeDIYData.tryOnBgBigOrgRD, paramThemeDIYData.position);
        if (new File(paramThemeDIYData.tryOnBgBigOrgRD.path, paramBundle).exists())
        {
          paramThemeDIYData.tryOnBgBigOrgRD.state = 5;
          return 4;
        }
        String str = paramThemeDIYData.tryOnBgBigOrgRD.path + getDownFileName(paramThemeDIYData.tryOnBgBigOrgRD);
        Bundle localBundle = new Bundle();
        localBundle.putInt("nowOperate", 11);
        new ThemeDiyStyleLogic.DarkBrightnessTask(this.mContext, this.app, str, paramBundle, paramThemeDIYData, localBundle, this.saveDealCallBack).execute(new Object[0]);
      }
      return 2;
    }
    return 8;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.theme.diy.ThemeDiyStyleLogic
 * JD-Core Version:    0.7.0.1
 */