package com.tencent.mobileqq.profilecard.template;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;

public abstract interface IDiyMoreInfoManager
{
  public abstract <V extends View> V getPhotoWallDiyView(ProfileCardInfo paramProfileCardInfo);
  
  public abstract <T extends View> T getQZoneDiyView(String paramString);
  
  public abstract void initDiyTemplate(QBaseActivity paramQBaseActivity, ProfileCardInfo paramProfileCardInfo);
  
  public abstract boolean isDiy();
  
  public abstract void updateAccountInfoForDeepDiy(View paramView);
  
  public abstract void updateBaseInfoForDeepDiy(View paramView);
  
  public abstract void updateItemThemeForDIYTemplate(TextView paramTextView, View paramView1, ImageView paramImageView, View paramView2, View paramView3, View paramView4);
  
  public abstract void updateLevelForDeepDiy(View paramView);
  
  public abstract void updateMetalForDeepDiy(View paramView);
  
  public abstract void updatePhotoWallForDeepDiy(View paramView);
  
  public abstract void updateQzoneForDeepDiy(View paramView);
  
  public abstract void updateSignForDeepDiy(View paramView);
  
  public abstract void updateTroopMemInfoForDeepDiy(View paramView);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.template.IDiyMoreInfoManager
 * JD-Core Version:    0.7.0.1
 */