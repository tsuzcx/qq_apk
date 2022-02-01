package com.tencent.mobileqq.vas.adv.qzone.logic;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.vas.adv.common.data.AlumBasicData;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/adv/qzone/logic/IAdVideoViewController;", "", "getView", "Landroid/view/View;", "initStubView", "", "parentView", "Landroid/view/ViewGroup;", "onDestroy", "onPause", "onResume", "setOutActivity", "activity", "Landroid/app/Activity;", "setVideoDataChanged", "alumBasicData", "Lcom/tencent/mobileqq/vas/adv/common/data/AlumBasicData;", "sceneId", "", "vas-adv-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IAdVideoViewController
{
  @NotNull
  public abstract View getView();
  
  public abstract void initStubView(@NotNull ViewGroup paramViewGroup);
  
  public abstract void onDestroy();
  
  public abstract void onPause();
  
  public abstract void onResume();
  
  public abstract void setOutActivity(@NotNull Activity paramActivity);
  
  public abstract void setVideoDataChanged(@Nullable AlumBasicData paramAlumBasicData, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adv.qzone.logic.IAdVideoViewController
 * JD-Core Version:    0.7.0.1
 */