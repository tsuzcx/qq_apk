package com.tencent.ttpic.videoshelf.ui;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Window;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.ttpic.videoshelf.R.id;
import com.tencent.ttpic.videoshelf.R.layout;
import com.tencent.ttpic.videoshelf.R.style;

public class LoadingDialog
  extends ReportDialog
{
  private final ProgressBar mProgress;
  private final TextView mTip;
  
  public LoadingDialog(Context paramContext)
  {
    super(paramContext, R.style.LoadingDialog);
    getWindow().setFlags(1024, 1024);
    setContentView(LayoutInflater.from(paramContext).inflate(R.layout.dialog_video_shelf_loading, null));
    this.mTip = ((TextView)findViewById(R.id.tip));
    this.mProgress = ((ProgressBar)findViewById(R.id.loadingImage));
  }
  
  public void setIndeterminate(boolean paramBoolean)
  {
    this.mProgress.setIndeterminate(paramBoolean);
  }
  
  public void setProgress(int paramInt)
  {
    this.mProgress.setProgress(paramInt);
  }
  
  public void setTip(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      this.mTip.setVisibility(8);
      return;
    }
    if (this.mTip.getVisibility() != 0) {
      this.mTip.setVisibility(0);
    }
    this.mTip.setText(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.videoshelf.ui.LoadingDialog
 * JD-Core Version:    0.7.0.1
 */