package com.tencent.mobileqq.vas.adv.qzone.logic;

import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.vas.adv.common.data.AlumBasicData;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/adv/qzone/logic/IAlbumRecommendAdvController;", "", "getView", "Landroid/view/View;", "hideAdView", "", "initAndRenderData", "advData", "Lcom/tencent/mobileqq/vas/adv/common/data/AlumBasicData;", "onDestroy", "onPause", "onResume", "setOutActivity", "activity", "Landroid/app/Activity;", "vas-adv-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IAlbumRecommendAdvController
{
  @NotNull
  public abstract View getView();
  
  public abstract void hideAdView();
  
  public abstract void initAndRenderData(@NotNull AlumBasicData paramAlumBasicData);
  
  public abstract void onDestroy();
  
  public abstract void onPause();
  
  public abstract void onResume();
  
  public abstract void setOutActivity(@NotNull Activity paramActivity);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adv.qzone.logic.IAlbumRecommendAdvController
 * JD-Core Version:    0.7.0.1
 */