package com.tencent.mobileqq.mini.widget;

import android.app.Activity;
import android.app.Dialog;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.RoundRectURLImageView;

public class LaunchConfirmDialogWrapper
{
  private final View mContentView;
  private final Dialog mDialog;
  
  private LaunchConfirmDialogWrapper(@NonNull Activity paramActivity, String paramString, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2)
  {
    this.mContentView = LayoutInflater.from(paramActivity).inflate(2030305280, null);
    this.mDialog = ActionSheetHelper.a(paramActivity, this.mContentView);
    initIconView(paramString);
    bindCloseableBtnListener(2030239745, paramOnClickListener1);
    bindCloseableBtnListener(2030239744, paramOnClickListener2);
  }
  
  private void bindCloseableBtnListener(@IdRes int paramInt, View.OnClickListener paramOnClickListener)
  {
    ((Button)this.mContentView.findViewById(paramInt)).setOnClickListener(new LaunchConfirmDialogWrapper.1(this, paramOnClickListener));
  }
  
  private void initIconView(String paramString)
  {
    RoundRectURLImageView localRoundRectURLImageView = (RoundRectURLImageView)this.mContentView.findViewById(2030239755);
    localRoundRectURLImageView.setRadius(ViewUtils.a(5.0F));
    if (!TextUtils.isEmpty(paramString)) {
      localRoundRectURLImageView.setImageDrawable(URLDrawable.getDrawable(paramString, null));
    }
  }
  
  public void hide()
  {
    this.mDialog.hide();
  }
  
  public void show()
  {
    this.mDialog.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.LaunchConfirmDialogWrapper
 * JD-Core Version:    0.7.0.1
 */