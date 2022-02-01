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
  private String a;
  private String b;
  private String c;
  
  public TipsDialog(@NonNull Context paramContext)
  {
    super(paramContext, 2131755376);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    setCanceledOnTouchOutside(true);
  }
  
  public TipsDialog a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
  
  public TipsDialog b(String paramString)
  {
    this.b = paramString;
    return this;
  }
  
  public TipsDialog c(String paramString)
  {
    this.c = paramString;
    return this;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131562930, null);
    setContentView(paramBundle);
    Object localObject = (TextView)paramBundle.findViewById(2131367669);
    ((TextView)localObject).setOnClickListener(new TipsDialog.1(this));
    String str = this.c;
    if (str != null) {
      ((TextView)localObject).setText(str);
    }
    localObject = (TextView)paramBundle.findViewById(2131378784);
    str = this.jdField_a_of_type_JavaLangString;
    if (str != null) {
      ((TextView)localObject).setText(str);
    }
    paramBundle = (TextView)paramBundle.findViewById(2131365542);
    localObject = this.b;
    if (localObject != null) {
      paramBundle.setText((CharSequence)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.dialogutils.TipsDialog
 * JD-Core Version:    0.7.0.1
 */