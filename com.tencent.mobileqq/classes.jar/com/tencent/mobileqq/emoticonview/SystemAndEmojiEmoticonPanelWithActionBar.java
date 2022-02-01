package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.view.View;
import arxd;
import ascw;

public class SystemAndEmojiEmoticonPanelWithActionBar
  extends SystemAndEmojiEmoticonPanel
{
  protected View a;
  public arxd a;
  
  public SystemAndEmojiEmoticonPanelWithActionBar(Context paramContext, arxd paramarxd)
  {
    super(paramContext, paramarxd);
  }
  
  protected int a()
  {
    return 2131559139;
  }
  
  protected void a(Context paramContext, arxd paramarxd)
  {
    super.a(paramContext, paramarxd);
    this.jdField_a_of_type_Arxd = paramarxd;
    this.jdField_a_of_type_AndroidViewView = findViewById(2131377184);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(new ascw(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonPanelWithActionBar
 * JD-Core Version:    0.7.0.1
 */