package com.tencent.timi.game.ui.widget;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.timi.game.utils.ThreadPool;

public class MenuDialog
  extends ReportDialog
{
  private DialogInterface.OnClickListener a;
  private View b;
  private LinearLayout c;
  private View.OnClickListener d = new MenuDialog.1(this);
  
  private MenuDialog(@NonNull Context paramContext)
  {
    super(paramContext, 2131952979);
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    show();
    this.c.setVisibility(4);
    ThreadPool.a(new MenuDialog.3(this, paramFloat1, paramFloat2));
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().setLayout(-1, -1);
  }
  
  public void setContentView(@NonNull View paramView)
  {
    super.setContentView(paramView);
    this.b = paramView;
    this.b.setOnClickListener(new MenuDialog.2(this));
  }
  
  public void show()
  {
    super.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.ui.widget.MenuDialog
 * JD-Core Version:    0.7.0.1
 */