package cooperation.qzone.widgetai;

import android.app.Activity;
import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;

public abstract interface IPetManagerQQProxy
{
  public abstract void attachActivity(Activity paramActivity, long paramLong, boolean paramBoolean, int paramInt);
  
  public abstract boolean canShowPetCoverRefine(String paramString);
  
  public abstract void checkQuickCommentEmotion(String paramString1, String paramString2, boolean paramBoolean);
  
  public abstract void detachActivity(Activity paramActivity);
  
  public abstract void doOnDestroy();
  
  public abstract void doOnResume();
  
  public abstract void doOnStop();
  
  public abstract void fetchWidgetAIInfoIfNeed(String paramString1, boolean paramBoolean, String paramString2);
  
  public abstract View getCocosView();
  
  public abstract ArrayList<String> getQuickCommentUrlList(String paramString);
  
  public abstract boolean isHardwareSupport();
  
  public abstract boolean isPetQuickCommentEnable();
  
  public abstract boolean isSettingOpen();
  
  public abstract void notifyPetInputPanelBack();
  
  public abstract void notifyPetOnInputPanel(int paramInt);
  
  public abstract void notifyWidgetAIChangeFromH5();
  
  public abstract void notifyWidgetAIQuickCommentSwitchChanged(boolean paramBoolean);
  
  public abstract void playPassivePraise(View paramView, String paramString, long paramLong);
  
  public abstract void playWidgetAIPraise(View paramView, String paramString, long paramLong);
  
  public abstract void preload();
  
  public abstract void restorePetOriPos();
  
  public abstract void sendPetUgcEventReq(int paramInt, String paramString1, long paramLong1, HashMap<String, String> paramHashMap, String paramString2, long paramLong2);
  
  public abstract void setCoverRect(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract void setFloatPetViewVisible(boolean paramBoolean, String paramString1, String paramString2);
  
  public abstract void setFocusPetVisible(boolean paramBoolean, String paramString);
  
  public abstract void setFocusWidgetAIVisible(boolean paramBoolean);
  
  public abstract void setForbidShow(boolean paramBoolean);
  
  public abstract void setHasCoverWidget(boolean paramBoolean);
  
  public abstract void setIsPrivateQuickComment(boolean paramBoolean);
  
  public abstract void setWidgetAIVisibleByTrans(String paramString1, boolean paramBoolean, String paramString2);
  
  public abstract void showQuickComentEmotionList(String paramString, ArrayList<String> paramArrayList);
  
  public abstract void showQuickCommentInFeedArea(int paramInt);
  
  public abstract void startLoading();
  
  public abstract void updateWidgetAISwitchHide(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.widgetai.IPetManagerQQProxy
 * JD-Core Version:    0.7.0.1
 */