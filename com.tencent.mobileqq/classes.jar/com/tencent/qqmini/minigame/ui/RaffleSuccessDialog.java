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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqmini.minigame.R.id;
import com.tencent.qqmini.minigame.R.layout;
import com.tencent.qqmini.minigame.R.string;
import com.tencent.qqmini.minigame.R.style;
import com.tencent.qqmini.minigame.plugins.RaffleJsPlugin.OnRaffleSuccessListener;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.utils.DialogUtil;
import com.tencent.qqmini.sdk.core.widget.AppCloseDialog;

public class RaffleSuccessDialog
  extends ReportDialog
{
  private static final long CHANGE_AFTER_RECEIVE_DELAY = 2000L;
  private Drawable afterReceiveDrawable;
  private RelativeLayout afterReceiveLayout;
  private Context context;
  private Drawable goBackMainButtonDrawable;
  private boolean isHorizontal;
  private Drawable logoDrawable;
  private RaffleJsPlugin.OnRaffleSuccessListener onRaffleSuccessListener;
  private Drawable prizeDrawable;
  private RelativeLayout prizeLayout;
  private Button receiveButton;
  private Drawable wishingDrawable;
  
  public RaffleSuccessDialog(Context paramContext, boolean paramBoolean, RaffleJsPlugin.OnRaffleSuccessListener paramOnRaffleSuccessListener)
  {
    super(paramContext);
    this.context = paramContext;
    this.isHorizontal = paramBoolean;
    this.onRaffleSuccessListener = paramOnRaffleSuccessListener;
  }
  
  private void changeAfterReceive()
  {
    ThreadManager.getUIHandler().postDelayed(new RaffleSuccessDialog.6(this), 2000L);
  }
  
  private void forbidReceiveClick()
  {
    ThreadManager.getUIHandler().post(new RaffleSuccessDialog.5(this));
  }
  
  private void removeClickTemporary(ImageView paramImageView)
  {
    RaffleSuccessDialog.7 local7 = new RaffleSuccessDialog.7(this, paramImageView);
    paramImageView.setClickable(false);
    ThreadManager.getUIHandler().postDelayed(local7, 1000L);
  }
  
  private void showHintDialog()
  {
    RaffleSuccessDialog.8 local8 = new RaffleSuccessDialog.8(this);
    RaffleSuccessDialog.9 local9 = new RaffleSuccessDialog.9(this);
    DialogUtil.createCloseAlertDialog(this.context, R.style.mini_sdk_MiniAppCloseDialog, this.context.getString(R.string.mini_sdk_game_raffle_success_close_hint), this.context.getString(R.string.mini_sdk_game_raffle_success_close_left_btn), this.context.getString(R.string.mini_sdk_game_raffle_success_close_right_btn), 100.0F, true, false, true, local8, local9).show();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (this.isHorizontal) {
      paramBundle = LayoutInflater.from(this.context).inflate(R.layout.mini_sdk_raffle_success_dialog_landscape, null);
    } else {
      paramBundle = LayoutInflater.from(this.context).inflate(R.layout.mini_sdk_raffle_success_dialog, null);
    }
    setCancelable(false);
    if (getWindow() != null)
    {
      getWindow().requestFeature(1);
      getWindow().setBackgroundDrawableResource(17170445);
    }
    this.prizeLayout = ((RelativeLayout)paramBundle.findViewById(R.id.mini_sdk_raffle_success_prize_layout));
    this.prizeLayout.setVisibility(0);
    ((ImageView)paramBundle.findViewById(R.id.mini_sdk_raffle_success_logo_image)).setImageDrawable(this.logoDrawable);
    ((ImageView)paramBundle.findViewById(R.id.mini_sdk_raffle_success_wishing_image)).setImageDrawable(this.wishingDrawable);
    ((ImageView)paramBundle.findViewById(R.id.mini_sdk_raffle_success_prize_image)).setImageDrawable(this.prizeDrawable);
    this.receiveButton = ((Button)paramBundle.findViewById(R.id.mini_sdk_raffle_success_receive_button));
    this.receiveButton.setOnClickListener(new RaffleSuccessDialog.1(this));
    ImageView localImageView = (ImageView)paramBundle.findViewById(R.id.mini_sdk_raffle_success_close_button);
    localImageView.setOnClickListener(new RaffleSuccessDialog.2(this, localImageView));
    this.afterReceiveLayout = ((RelativeLayout)paramBundle.findViewById(R.id.mini_sdk_raffle_success_after_receive_layout));
    this.afterReceiveLayout.setVisibility(4);
    ((ImageView)paramBundle.findViewById(R.id.mini_sdk_raffle_success_after_receive_image)).setImageDrawable(this.afterReceiveDrawable);
    localImageView = (ImageView)paramBundle.findViewById(R.id.mini_sdk_raffle_success_go_back_main_image);
    localImageView.setImageDrawable(this.goBackMainButtonDrawable);
    localImageView.setOnClickListener(new RaffleSuccessDialog.3(this));
    ((TextView)paramBundle.findViewById(R.id.mini_sdk_raffle_success_again_text)).setOnClickListener(new RaffleSuccessDialog.4(this));
    setContentView(paramBundle, new ViewGroup.LayoutParams(-1, -1));
  }
  
  public boolean setDrawable(Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3, Drawable paramDrawable4, Drawable paramDrawable5)
  {
    if ((paramDrawable3 != null) && (paramDrawable4 != null))
    {
      this.logoDrawable = paramDrawable1;
      this.wishingDrawable = paramDrawable2;
      this.prizeDrawable = paramDrawable3;
      this.afterReceiveDrawable = paramDrawable4;
      this.goBackMainButtonDrawable = paramDrawable5;
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.minigame.ui.RaffleSuccessDialog
 * JD-Core Version:    0.7.0.1
 */