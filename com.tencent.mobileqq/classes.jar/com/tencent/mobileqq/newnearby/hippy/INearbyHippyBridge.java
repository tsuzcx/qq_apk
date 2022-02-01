package com.tencent.mobileqq.newnearby.hippy;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mtt.hippy.modules.Promise;

@QAPI(process={"all"})
public abstract interface INearbyHippyBridge
  extends QRouteApi
{
  public static final int CLICK_EVENT_BACK_TO_TRANS_PAGE = 1;
  public static final int CLICK_EVENT_BACK_TO_WHITE_PAGE = 3;
  public static final int CLICK_EVENT_DEFAULT = 0;
  public static final int CLICK_EVENT_QUIT_NEARBY = 2;
  public static final int THEME_DEFAULT = 0;
  public static final int THEME_TRANS = 2;
  public static final int THEME_WHITE = 1;
  public static final int TITLE_BTN_LEFT = 1;
  public static final int TITLE_BTN_RIGHT = 2;
  
  public abstract void customizeTitleBar(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, Promise paramPromise);
  
  public abstract void exitNearby();
  
  public abstract void hideBottomMask();
  
  public abstract void hideNavigationBar();
  
  public abstract void hideTopMask();
  
  public abstract void nearbySafetyReport(String paramString, int paramInt);
  
  public abstract void onTabChanged(int paramInt, String paramString);
  
  public abstract void openAio(String paramString1, String paramString2);
  
  public abstract void openAppSetting();
  
  public abstract void openBirthdayEditActivity(Promise paramPromise);
  
  public abstract void openHippyByUrl(int paramInt, String paramString);
  
  public abstract void openMqqUrl(String paramString);
  
  public abstract void openProfileCard(String paramString);
  
  public abstract void requestLBS(Promise paramPromise);
  
  public abstract void resetTitleBar(int paramInt);
  
  public abstract void selectAndUploadPicture(int paramInt, Promise paramPromise);
  
  public abstract void setVideoEnterVisibility(boolean paramBoolean);
  
  public abstract void showBeginnerGuide(String paramString);
  
  public abstract void showBottomMask();
  
  public abstract void showNavigationBar();
  
  public abstract void showTopMask();
  
  public abstract void uploadProfilePicture(Promise paramPromise);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.newnearby.hippy.INearbyHippyBridge
 * JD-Core Version:    0.7.0.1
 */