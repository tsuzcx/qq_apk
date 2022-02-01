package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Color;
import android.view.Window;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class ToastStyleDialog
  extends ReportDialog
{
  private TextView a;
  
  public ToastStyleDialog(Context paramContext)
  {
    super(paramContext, 2131952026);
    getWindow().setFlags(16, 16);
    getWindow().setFlags(8, 8);
    getWindow().setGravity(17);
    setContentView(2131627879);
    this.a = ((TextView)findViewById(2131447672));
    if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
      this.a.setTextColor(Color.parseColor("#FF737373"));
    }
    setCancelable(false);
  }
  
  public void a(String paramString)
  {
    this.a.setText(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ToastStyleDialog
 * JD-Core Version:    0.7.0.1
 */