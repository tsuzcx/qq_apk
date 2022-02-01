package com.tencent.qqmini.sdk.widget;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqmini.sdk.R.id;
import com.tencent.qqmini.sdk.R.layout;
import com.tencent.qqmini.sdk.R.style;

public class MiniProgressDialog
  extends ReportDialog
{
  private Animatable frameAnimation;
  private LinearLayout mBackground;
  private MiniProgressDialog.Callback mCallback;
  String mContentDescription;
  private Context mContext;
  private float mDensity;
  private int mGravity = 48;
  private int mHeightParams = -2;
  private ImageView mImageShow = null;
  private LayoutInflater mInflater;
  private TextView mMsgTextView;
  private int mOffsetY = 0;
  private ImageView mProgressImg = null;
  private View mRootView;
  
  public MiniProgressDialog(Context paramContext)
  {
    this(paramContext, 0);
  }
  
  public MiniProgressDialog(Context paramContext, int paramInt)
  {
    this(paramContext, paramInt, R.layout.mini_sdk_progress_dialog, 48);
  }
  
  public MiniProgressDialog(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramContext, R.style.mini_sdk_QQProgressDialog);
    this.mContext = paramContext;
    this.mInflater = LayoutInflater.from(paramContext);
    this.mDensity = this.mContext.getResources().getDisplayMetrics().density;
    this.mRootView = this.mInflater.inflate(paramInt2, null);
    this.mBackground = ((LinearLayout)this.mRootView.findViewById(R.id.bk));
    this.mMsgTextView = ((TextView)this.mRootView.findViewById(R.id.msgTextView));
    this.mOffsetY = paramInt1;
    this.mGravity = paramInt3;
    this.mImageShow = ((ImageView)this.mRootView.findViewById(R.id.tipsimage_show));
    this.mProgressImg = ((ImageView)this.mRootView.findViewById(R.id.tipsprogerss_show));
    this.frameAnimation = ((Animatable)this.mProgressImg.getDrawable());
  }
  
  /* Error */
  public void dismiss()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 142	android/app/Dialog:dismiss	()V
    //   4: return
    //   5: astore_1
    //   6: aload_1
    //   7: athrow
    //   8: astore_1
    //   9: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	10	0	this	MiniProgressDialog
    //   5	2	1	localObject	java.lang.Object
    //   8	1	1	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   0	4	5	finally
    //   0	4	8	java/lang/Exception
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    if (TextUtils.isEmpty(this.mContentDescription)) {
      return super.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent);
    }
    return true;
  }
  
  public void onBackPressed()
  {
    super.onBackPressed();
    MiniProgressDialog.Callback localCallback = this.mCallback;
    if (localCallback != null) {
      localCallback.onBackPressed();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getWindow();
    paramBundle.setContentView(this.mRootView);
    WindowManager.LayoutParams localLayoutParams = paramBundle.getAttributes();
    localLayoutParams.width = -1;
    localLayoutParams.height = this.mHeightParams;
    localLayoutParams.gravity = this.mGravity;
    localLayoutParams.y += this.mOffsetY;
    paramBundle.setAttributes(localLayoutParams);
    setCanceledOnTouchOutside(false);
  }
  
  protected void onStart()
  {
    this.mProgressImg.postDelayed(new MiniProgressDialog.1(this), 50L);
    super.onStart();
  }
  
  protected void onStop()
  {
    if (this.frameAnimation.isRunning()) {
      this.frameAnimation.stop();
    }
    super.onStop();
  }
  
  public void setBackAndSearchFilter(boolean paramBoolean)
  {
    setOnKeyListener(new MiniProgressDialog.2(this, paramBoolean));
  }
  
  public void setBackground(Drawable paramDrawable)
  {
    this.mBackground.setBackgroundDrawable(paramDrawable);
  }
  
  public void setCallback(MiniProgressDialog.Callback paramCallback)
  {
    this.mCallback = paramCallback;
  }
  
  public void setContentDescription(String paramString)
  {
    this.mContentDescription = paramString;
  }
  
  public void setGravity(int paramInt)
  {
    this.mGravity = paramInt;
  }
  
  public void setHeightParams(int paramInt)
  {
    this.mHeightParams = paramInt;
  }
  
  public void setMessage(int paramInt)
  {
    this.mMsgTextView.setText(paramInt);
  }
  
  public void setMessage(String paramString)
  {
    this.mMsgTextView.setText(paramString);
  }
  
  public void setOffsetY(int paramInt)
  {
    this.mOffsetY = paramInt;
  }
  
  public void setProgressBackground(@DrawableRes int paramInt)
  {
    this.mProgressImg.setImageResource(paramInt);
  }
  
  public void setTipImageView(int paramInt)
  {
    ImageView localImageView = this.mImageShow;
    if (localImageView == null) {
      return;
    }
    localImageView.setVisibility(0);
    this.mImageShow.setImageResource(paramInt);
  }
  
  public void setTipImageView(Bitmap paramBitmap)
  {
    ImageView localImageView = this.mImageShow;
    if (localImageView == null) {
      return;
    }
    localImageView.setVisibility(0);
    this.mImageShow.setImageBitmap(paramBitmap);
  }
  
  public void showProgerss(boolean paramBoolean)
  {
    if (this.mProgressImg == null) {
      return;
    }
    if (paramBoolean)
    {
      if (!this.frameAnimation.isRunning()) {
        this.frameAnimation.start();
      }
      this.mProgressImg.setVisibility(0);
      return;
    }
    if (this.frameAnimation.isRunning()) {
      this.frameAnimation.stop();
    }
    this.mProgressImg.setVisibility(8);
  }
  
  public void showTip(boolean paramBoolean)
  {
    View localView = this.mRootView;
    if (localView != null)
    {
      if (paramBoolean)
      {
        localView.setVisibility(0);
        return;
      }
      localView.setVisibility(8);
    }
  }
  
  public void showTipImageView(boolean paramBoolean)
  {
    ImageView localImageView = this.mImageShow;
    if (localImageView == null) {
      return;
    }
    if (paramBoolean)
    {
      localImageView.setVisibility(0);
      return;
    }
    localImageView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.widget.MiniProgressDialog
 * JD-Core Version:    0.7.0.1
 */