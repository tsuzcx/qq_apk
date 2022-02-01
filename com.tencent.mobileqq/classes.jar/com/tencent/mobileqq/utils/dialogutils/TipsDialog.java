package com.tencent.mobileqq.utils.dialogutils;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class TipsDialog
  extends ReportDialog
{
  protected Context a;
  private String b;
  private String c;
  private String d;
  
  public TipsDialog(@NonNull Context paramContext)
  {
    super(paramContext, 2131952084);
    this.a = paramContext;
    setCanceledOnTouchOutside(true);
  }
  
  public TipsDialog a(String paramString)
  {
    this.b = paramString;
    return this;
  }
  
  public TipsDialog b(String paramString)
  {
    this.c = paramString;
    return this;
  }
  
  public TipsDialog c(String paramString)
  {
    this.d = paramString;
    return this;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = LayoutInflater.from(this.a).inflate(2131629535, null);
    setContentView(paramBundle);
    Object localObject = (TextView)paramBundle.findViewById(2131434213);
    ((TextView)localObject).setOnClickListener(new TipsDialog.1(this));
    String str = this.d;
    if (str != null) {
      ((TextView)localObject).setText(str);
    }
    localObject = (TextView)paramBundle.findViewById(2131447463);
    str = this.b;
    if (str != null) {
      ((TextView)localObject).setText(str);
    }
    paramBundle = (TextView)paramBundle.findViewById(2131431769);
    localObject = this.c;
    if (localObject != null) {
      paramBundle.setText((CharSequence)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.dialogutils.TipsDialog
 * JD-Core Version:    0.7.0.1
 */