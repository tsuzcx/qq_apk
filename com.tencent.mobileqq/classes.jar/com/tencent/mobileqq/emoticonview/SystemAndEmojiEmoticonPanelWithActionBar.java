package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.view.View;
import appt;
import apus;

public class SystemAndEmojiEmoticonPanelWithActionBar
  extends SystemAndEmojiEmoticonPanel
{
  protected View a;
  public appt a;
  
  public SystemAndEmojiEmoticonPanelWithActionBar(Context paramContext, appt paramappt)
  {
    super(paramContext, paramappt);
  }
  
  protected int a()
  {
    return 2131559071;
  }
  
  protected void a(Context paramContext, appt paramappt)
  {
    super.a(paramContext, paramappt);
    this.jdField_a_of_type_Appt = paramappt;
    this.jdField_a_of_type_AndroidViewView = findViewById(2131376341);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(new apus(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonPanelWithActionBar
 * JD-Core Version:    0.7.0.1
 */