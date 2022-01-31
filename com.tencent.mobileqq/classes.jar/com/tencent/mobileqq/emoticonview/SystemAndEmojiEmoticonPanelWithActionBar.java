package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.view.View;
import anyb;
import aocq;

public class SystemAndEmojiEmoticonPanelWithActionBar
  extends SystemAndEmojiEmoticonPanel
{
  protected View a;
  public anyb a;
  
  public SystemAndEmojiEmoticonPanelWithActionBar(Context paramContext, anyb paramanyb)
  {
    super(paramContext, paramanyb);
  }
  
  protected int a()
  {
    return 2131559032;
  }
  
  protected void a(Context paramContext, anyb paramanyb)
  {
    super.a(paramContext, paramanyb);
    this.jdField_a_of_type_Anyb = paramanyb;
    this.jdField_a_of_type_AndroidViewView = findViewById(2131375840);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(new aocq(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonPanelWithActionBar
 * JD-Core Version:    0.7.0.1
 */