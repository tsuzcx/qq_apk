package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import java.util.ArrayList;

public class AnimationView
  extends RoundImageView
{
  protected AnimationView.AnimationInfo a;
  protected AnimationView.MyAnimationListener a;
  protected AnimationView.Player a;
  
  public AnimationView(Context paramContext)
  {
    super(paramContext);
  }
  
  public AnimationView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public AnimationView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public AnimationView.AnimationInfo getAnimationFromInfo()
  {
    return this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView$AnimationInfo;
  }
  
  public AnimationView.Player getPlayer()
  {
    return this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView$Player;
  }
  
  public void pause()
  {
    AnimationView.Player localPlayer = this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView$Player;
    if (localPlayer == null) {
      return;
    }
    localPlayer.pause();
  }
  
  public void play()
  {
    AnimationView.Player localPlayer = this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView$Player;
    if (localPlayer == null) {
      return;
    }
    localPlayer.play();
  }
  
  public void resume()
  {
    AnimationView.Player localPlayer = this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView$Player;
    if (localPlayer == null) {
      return;
    }
    localPlayer.resume();
  }
  
  public void setAnimationFromBitmaps(ArrayList<Bitmap> paramArrayList, int paramInt1, int paramInt2)
  {
    if (paramArrayList != null)
    {
      if (paramArrayList.size() <= 0) {
        return;
      }
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < paramArrayList.size())
      {
        localArrayList.add(new BitmapDrawable(getResources(), (Bitmap)paramArrayList.get(i)));
        i += 1;
      }
      setAnimationFromDrawabs(localArrayList, paramInt1, paramInt2);
    }
  }
  
  public void setAnimationFromDrawabs(ArrayList<Drawable> paramArrayList, int paramInt1, int paramInt2)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      if (paramInt1 <= 0) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView$AnimationInfo = AnimationView.AnimationInfo.loadFromFrames(paramArrayList, paramInt1, paramInt2);
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView$Player == null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView$Player = new AnimationView.Player(this);
      }
    }
  }
  
  public void setAnimationFromDrawabs(Drawable[] paramArrayOfDrawable, int paramInt1, int paramInt2)
  {
    if ((paramArrayOfDrawable != null) && (paramArrayOfDrawable.length > 0))
    {
      if (paramInt1 <= 0) {
        return;
      }
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < paramArrayOfDrawable.length)
      {
        localArrayList.add(paramArrayOfDrawable[i]);
        i += 1;
      }
      setAnimationFromDrawabs(localArrayList, paramInt1, paramInt2);
    }
  }
  
  public void setAnimationFromInfo(AnimationView.AnimationInfo paramAnimationInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView$AnimationInfo = paramAnimationInfo;
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView$Player == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView$Player = new AnimationView.Player(this);
    }
  }
  
  public void setAnimationListener(AnimationView.MyAnimationListener paramMyAnimationListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView$MyAnimationListener = paramMyAnimationListener;
  }
  
  public void setPlayer(AnimationView.Player paramPlayer)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView$Player = paramPlayer;
  }
  
  public void stop()
  {
    AnimationView.Player localPlayer = this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView$Player;
    if (localPlayer == null) {
      return;
    }
    localPlayer.stop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.AnimationView
 * JD-Core Version:    0.7.0.1
 */