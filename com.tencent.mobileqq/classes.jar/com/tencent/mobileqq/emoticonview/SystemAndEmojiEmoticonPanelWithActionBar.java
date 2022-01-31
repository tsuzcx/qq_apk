package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.view.View;
import anhs;
import anmg;

public class SystemAndEmojiEmoticonPanelWithActionBar
  extends SystemAndEmojiEmoticonPanel
{
  protected View a;
  public anhs a;
  
  public SystemAndEmojiEmoticonPanelWithActionBar(Context paramContext, anhs paramanhs)
  {
    super(paramContext, paramanhs);
  }
  
  protected int a()
  {
    return 2131493469;
  }
  
  protected void a(Context paramContext, anhs paramanhs)
  {
    super.a(paramContext, paramanhs);
    this.jdField_a_of_type_Anhs = paramanhs;
    this.jdField_a_of_type_AndroidViewView = findViewById(2131310076);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(new anmg(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonPanelWithActionBar
 * JD-Core Version:    0.7.0.1
 */