package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.view.View;
import anyg;
import aocv;

public class SystemAndEmojiEmoticonPanelWithActionBar
  extends SystemAndEmojiEmoticonPanel
{
  protected View a;
  public anyg a;
  
  public SystemAndEmojiEmoticonPanelWithActionBar(Context paramContext, anyg paramanyg)
  {
    super(paramContext, paramanyg);
  }
  
  protected int a()
  {
    return 2131559032;
  }
  
  protected void a(Context paramContext, anyg paramanyg)
  {
    super.a(paramContext, paramanyg);
    this.jdField_a_of_type_Anyg = paramanyg;
    this.jdField_a_of_type_AndroidViewView = findViewById(2131375842);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(new aocv(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonPanelWithActionBar
 * JD-Core Version:    0.7.0.1
 */