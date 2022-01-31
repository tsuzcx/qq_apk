package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.view.View;
import apuc;
import apzb;

public class SystemAndEmojiEmoticonPanelWithActionBar
  extends SystemAndEmojiEmoticonPanel
{
  protected View a;
  public apuc a;
  
  public SystemAndEmojiEmoticonPanelWithActionBar(Context paramContext, apuc paramapuc)
  {
    super(paramContext, paramapuc);
  }
  
  protected int a()
  {
    return 2131559070;
  }
  
  protected void a(Context paramContext, apuc paramapuc)
  {
    super.a(paramContext, paramapuc);
    this.jdField_a_of_type_Apuc = paramapuc;
    this.jdField_a_of_type_AndroidViewView = findViewById(2131376395);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(new apzb(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonPanelWithActionBar
 * JD-Core Version:    0.7.0.1
 */