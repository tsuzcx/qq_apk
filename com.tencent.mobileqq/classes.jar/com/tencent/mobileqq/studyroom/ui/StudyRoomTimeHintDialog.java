package com.tencent.mobileqq.studyroom.ui;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.studyroom.api.impl.StudyRoomReporterImpl;

public class StudyRoomTimeHintDialog
  extends Dialog
{
  private String a;
  private String b;
  private String c;
  private int d;
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().setBackgroundDrawable(new ColorDrawable(0));
    setCanceledOnTouchOutside(false);
    setContentView(2131624717);
    ((ImageView)findViewById(2131437736)).setImageResource(this.d);
    ((TextView)findViewById(2131447463)).setText(this.a);
    ((TextView)findViewById(2131446539)).setText(this.b);
    ((TextView)findViewById(2131431322)).setText(this.c);
    ((TextView)findViewById(2131431227)).setOnClickListener(new StudyRoomTimeHintDialog.1(this));
  }
  
  public void show()
  {
    super.show();
    Bundle localBundle = new Bundle();
    localBundle.putString("action", "exposure");
    localBundle.putString("page", "unopen_page");
    localBundle.putString("module", "all_modules");
    StudyRoomReporterImpl.report(localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.studyroom.ui.StudyRoomTimeHintDialog
 * JD-Core Version:    0.7.0.1
 */