package com.tencent.mobileqq.troop.troopcard.api;

import android.graphics.Bitmap;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={""})
public abstract interface ITroopGameCardUtilsApi
  extends QRouteApi
{
  public static final String GAME_GRADE_ICON_FILE_NAME_PREFIX = "game_grade_";
  public static final String GAME_GRADE_NUMBER_ICON_FILE_NAME_PREFIX = "game_grade_number_";
  public static final String GAME_GRADE_START_IMAGE_FILE_NAME_PREFIX = "game_grade_star";
  public static final String GAME_MEMBER_GAME_CARD_BG_IMAGE_FILE_NAME = "member_game_card_bg.png";
  public static final String GAME_MEMBER_GAME_CARD_BG_NIGHT_IMAGE_FILE_NAME = "member_game_card_bg_night.png";
  public static final String GAME_SKILLED_LEVEL_ICON_FILE_NAME_PREFIX = "game_hero_skill_level_";
  public static final int GRAY_TIPS_SWITCH_CLOSE_BIZ_ID = 10036;
  public static final int GRAY_TIPS_SWITCH_OPEN_BIZ_ID = 10035;
  public static final String PNG_ENDPIX = ".png";
  
  public abstract void ansyCheckShowMsgGameGradeLevel(String paramString1, String paramString2, ITroopGameCardUtilsApi.ICheckShowMsgGameGradeLevelBack paramICheckShowMsgGameGradeLevelBack);
  
  public abstract String getGameGradeIconPathById(int paramInt);
  
  public abstract String getGameGradeNumberIconPathById(int paramInt);
  
  public abstract String getGameGradeStarImagePathById(int paramInt);
  
  public abstract String getGameSkilledLevelIconPath(int paramInt);
  
  public abstract String getGradeDescById(int paramInt);
  
  public abstract Bitmap getImageBitmap(String paramString);
  
  public abstract String getMajorGradeTagById(int paramInt);
  
  public abstract String getMemberGameCardBgImagePath(boolean paramBoolean);
  
  public abstract String getOccupationTypeText(int paramInt);
  
  public abstract String getSecondaryGradeById(int paramInt);
  
  public abstract String getSelectedEndColorById(int paramInt);
  
  public abstract String getSelectedStartColorById(int paramInt);
  
  public abstract String getSelectedTextColorById(int paramInt);
  
  public abstract String getUnselectedEndColorById(int paramInt);
  
  public abstract String getUnselectedStartColorById(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.api.ITroopGameCardUtilsApi
 * JD-Core Version:    0.7.0.1
 */