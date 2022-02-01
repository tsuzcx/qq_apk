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
  protected static final String TAG = "AnimationView";
  protected AnimationView.AnimationInfo mAnimationInfo;
  protected AnimationView.MyAnimationListener mListener;
  protected AnimationView.Player mPlayer;
  
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
    return this.mAnimationInfo;
  }
  
  public AnimationView.Player getPlayer()
  {
    return this.mPlayer;
  }
  
  public void pause()
  {
    if (this.mPlayer == null) {
      return;
    }
    this.mPlayer.pause();
  }
  
  public void play()
  {
    if (this.mPlayer == null) {
      return;
    }
    this.mPlayer.play();
  }
  
  public void resume()
  {
    if (this.mPlayer == null) {
      return;
    }
    this.mPlayer.resume();
  }
  
  public void setAnimationFromBitmaps(ArrayList<Bitmap> paramArrayList, int paramInt1, int paramInt2)
  {
    if ((paramArrayList == null) || (paramArrayList.size() <= 0)) {
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
  
  public void setAnimationFromDrawabs(ArrayList<Drawable> paramArrayList, int paramInt1, int paramInt2)
  {
    if ((paramArrayList == null) || (paramArrayList.size() <= 0) || (paramInt1 <= 0)) {}
    do
    {
      return;
      this.mAnimationInfo = AnimationView.AnimationInfo.loadFromFrames(paramArrayList, paramInt1, paramInt2);
    } while (this.mPlayer != null);
    this.mPlayer = new AnimationView.Player(this);
  }
  
  public void setAnimationFromDrawabs(Drawable[] paramArrayOfDrawable, int paramInt1, int paramInt2)
  {
    if ((paramArrayOfDrawable == null) || (paramArrayOfDrawable.length <= 0) || (paramInt1 <= 0)) {
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
  
  public void setAnimationFromInfo(AnimationView.AnimationInfo paramAnimationInfo)
  {
    this.mAnimationInfo = paramAnimationInfo;
    if (this.mPlayer == null) {
      this.mPlayer = new AnimationView.Player(this);
    }
  }
  
  public void setAnimationListener(AnimationView.MyAnimationListener paramMyAnimationListener)
  {
    this.mListener = paramMyAnimationListener;
  }
  
  public void setPlayer(AnimationView.Player paramPlayer)
  {
    this.mPlayer = paramPlayer;
  }
  
  public void stop()
  {
    if (this.mPlayer == null) {
      return;
    }
    this.mPlayer.stop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.AnimationView
 * JD-Core Version:    0.7.0.1
 */