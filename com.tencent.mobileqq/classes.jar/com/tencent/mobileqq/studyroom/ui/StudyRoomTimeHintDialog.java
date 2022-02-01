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
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  private String c;
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().setBackgroundDrawable(new ColorDrawable(0));
    setCanceledOnTouchOutside(false);
    setContentView(2131559059);
    ((ImageView)findViewById(2131370464)).setImageResource(this.jdField_a_of_type_Int);
    ((TextView)findViewById(2131378784)).setText(this.jdField_a_of_type_JavaLangString);
    ((TextView)findViewById(2131378039)).setText(this.b);
    ((TextView)findViewById(2131365169)).setText(this.c);
    ((TextView)findViewById(2131365086)).setOnClickListener(new StudyRoomTimeHintDialog.1(this));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.studyroom.ui.StudyRoomTimeHintDialog
 * JD-Core Version:    0.7.0.1
 */