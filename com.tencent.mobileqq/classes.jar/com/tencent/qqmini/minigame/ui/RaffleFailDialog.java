package com.tencent.qqmini.minigame.ui;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqmini.minigame.R.id;
import com.tencent.qqmini.minigame.R.layout;
import com.tencent.qqmini.minigame.plugins.RaffleJsPlugin.OnRaffleFailListener;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;

public class RaffleFailDialog
  extends ReportDialog
{
  private boolean canShare = false;
  private boolean canWatchAd = false;
  private ImageView commonImageView;
  private Context context;
  private Drawable failDrawable;
  private ImageView firstImageView;
  private boolean isHorizontal;
  private RaffleJsPlugin.OnRaffleFailListener onRaffleFailListener;
  private ImageView secondImageView;
  private Drawable shareButtonDrawable;
  private Drawable watchAdButtonDrawable;
  
  public RaffleFailDialog(Context paramContext, boolean paramBoolean, RaffleJsPlugin.OnRaffleFailListener paramOnRaffleFailListener)
  {
    super(paramContext);
    this.context = paramContext;
    this.isHorizontal = paramBoolean;
    this.onRaffleFailListener = paramOnRaffleFailListener;
  }
  
  private void initButton()
  {
    if ((this.canShare) && (this.canWatchAd))
    {
      this.commonImageView.setVisibility(8);
      this.firstImageView.setVisibility(0);
      this.secondImageView.setVisibility(0);
      this.firstImageView.setImageDrawable(this.shareButtonDrawable);
      this.secondImageView.setImageDrawable(this.watchAdButtonDrawable);
      setShareEvent(this.firstImageView);
      setWatchAdEvent(this.secondImageView);
      return;
    }
    if (this.canShare)
    {
      this.commonImageView.setVisibility(0);
      this.firstImageView.setVisibility(8);
      this.secondImageView.setVisibility(8);
      this.commonImageView.setImageDrawable(this.shareButtonDrawable);
      setShareEvent(this.commonImageView);
      return;
    }
    if (this.canWatchAd)
    {
      this.commonImageView.setVisibility(0);
      this.firstImageView.setVisibility(8);
      this.secondImageView.setVisibility(8);
      this.commonImageView.setImageDrawable(this.watchAdButtonDrawable);
      setWatchAdEvent(this.commonImageView);
      return;
    }
    this.commonImageView.setVisibility(4);
    this.firstImageView.setVisibility(8);
    this.secondImageView.setVisibility(8);
  }
  
  private void removeClickTemporary(ImageView paramImageView)
  {
    RaffleFailDialog.5 local5 = new RaffleFailDialog.5(this, paramImageView);
    paramImageView.setClickable(false);
    ThreadManager.getUIHandler().postDelayed(local5, 1000L);
  }
  
  private void setShareEvent(ImageView paramImageView)
  {
    paramImageView.setOnClickListener(new RaffleFailDialog.3(this, paramImageView));
  }
  
  private void setWatchAdEvent(ImageView paramImageView)
  {
    paramImageView.setOnClickListener(new RaffleFailDialog.4(this, paramImageView));
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (this.isHorizontal) {
      paramBundle = LayoutInflater.from(this.context).inflate(R.layout.mini_sdk_raffle_fail_dialog_landscape, null);
    } else {
      paramBundle = LayoutInflater.from(this.context).inflate(R.layout.mini_sdk_raffle_fail_dialog, null);
    }
    setCancelable(false);
    if (getWindow() != null)
    {
      getWindow().requestFeature(1);
      getWindow().setBackgroundDrawableResource(17170445);
    }
    ((ImageView)paramBundle.findViewById(R.id.mini_sdk_raffle_fail_image)).setImageDrawable(this.failDrawable);
    this.commonImageView = ((ImageView)paramBundle.findViewById(R.id.mini_sdk_raffle_fail_common_button_image));
    this.firstImageView = ((ImageView)paramBundle.findViewById(R.id.mini_sdk_raffle_fail_fisrt_button_image));
    this.secondImageView = ((ImageView)paramBundle.findViewById(R.id.mini_sdk_raffle_fail_second_button_image));
    Object localObject = (TextView)paramBundle.findViewById(R.id.mini_sdk_raffle_fail_again_text);
    ((TextView)localObject).setOnClickListener(new RaffleFailDialog.1(this, (TextView)localObject));
    localObject = (ImageView)paramBundle.findViewById(R.id.mini_sdk_raffle_fail_close_button);
    ((ImageView)localObject).setOnClickListener(new RaffleFailDialog.2(this, (ImageView)localObject));
    initButton();
    setContentView(paramBundle, new ViewGroup.LayoutParams(-1, -1));
  }
  
  public void setCanShare(boolean paramBoolean)
  {
    this.canShare = paramBoolean;
  }
  
  public void setCanWatchAd(boolean paramBoolean)
  {
    this.canWatchAd = paramBoolean;
  }
  
  public boolean setDrawable(Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3)
  {
    if (paramDrawable1 == null) {
      return false;
    }
    this.failDrawable = paramDrawable1;
    this.shareButtonDrawable = paramDrawable2;
    this.watchAdButtonDrawable = paramDrawable3;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.minigame.ui.RaffleFailDialog
 * JD-Core Version:    0.7.0.1
 */