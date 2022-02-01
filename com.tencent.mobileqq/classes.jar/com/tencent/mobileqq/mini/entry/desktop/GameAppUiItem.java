package com.tencent.mobileqq.mini.entry.desktop;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class GameAppUiItem
{
  public final ImageView appIcon;
  public final TextView appName;
  public final View appPanel;
  
  public GameAppUiItem(View paramView, ImageView paramImageView, TextView paramTextView)
  {
    this.appPanel = paramView;
    this.appIcon = paramImageView;
    this.appName = paramTextView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.GameAppUiItem
 * JD-Core Version:    0.7.0.1
 */