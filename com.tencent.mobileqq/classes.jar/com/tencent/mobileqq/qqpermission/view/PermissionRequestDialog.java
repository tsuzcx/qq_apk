package com.tencent.mobileqq.qqpermission.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class PermissionRequestDialog
  extends ReportDialog
{
  private ImageView a;
  private TextView b;
  private TextView c;
  private TextView d;
  private Button e;
  private Button f;
  private View.OnClickListener g;
  private View.OnClickListener h;
  
  public PermissionRequestDialog(@NonNull Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    setContentView(2131627622);
    a();
  }
  
  private void a()
  {
    this.a = ((ImageView)findViewById(2131439980));
    this.b = ((TextView)findViewById(2131439981));
    this.c = ((TextView)findViewById(2131439982));
    this.d = ((TextView)findViewById(2131439977));
    this.e = ((Button)findViewById(2131439978));
    this.f = ((Button)findViewById(2131439979));
    this.e.setOnClickListener(new PermissionRequestDialog.1(this));
    this.f.setOnClickListener(new PermissionRequestDialog.2(this));
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.h = paramOnClickListener;
  }
  
  public void a(CharSequence paramCharSequence)
  {
    this.c.setText(paramCharSequence);
  }
  
  public void b(CharSequence paramCharSequence)
  {
    this.d.setText(paramCharSequence);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getWindow();
    paramBundle.setGravity(80);
    WindowManager.LayoutParams localLayoutParams = paramBundle.getAttributes();
    localLayoutParams.width = -1;
    paramBundle.setAttributes(localLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqpermission.view.PermissionRequestDialog
 * JD-Core Version:    0.7.0.1
 */