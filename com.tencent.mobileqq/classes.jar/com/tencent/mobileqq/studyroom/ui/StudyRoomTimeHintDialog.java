package com.tencent.mobileqq.studyroom.ui;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.studyroom.utils.StudyRoomReporter;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class StudyRoomTimeHintDialog
  extends ReportDialog
{
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  private String c;
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().setBackgroundDrawable(new ColorDrawable(0));
    setCanceledOnTouchOutside(false);
    setContentView(2131559165);
    ((ImageView)findViewById(2131370833)).setImageResource(this.jdField_a_of_type_Int);
    ((TextView)findViewById(2131379432)).setText(this.jdField_a_of_type_JavaLangString);
    ((TextView)findViewById(2131378646)).setText(this.b);
    ((TextView)findViewById(2131365294)).setText(this.c);
    ((TextView)findViewById(2131365207)).setOnClickListener(new StudyRoomTimeHintDialog.1(this));
  }
  
  public void show()
  {
    super.show();
    Bundle localBundle = new Bundle();
    localBundle.putString("action", "exposure");
    localBundle.putString("page", "unopen_page");
    localBundle.putString("module", "all_modules");
    StudyRoomReporter.a(localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.studyroom.ui.StudyRoomTimeHintDialog
 * JD-Core Version:    0.7.0.1
 */