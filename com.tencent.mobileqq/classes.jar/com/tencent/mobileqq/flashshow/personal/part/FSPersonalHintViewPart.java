package com.tencent.mobileqq.flashshow.personal.part;

import android.view.View;
import com.tencent.mobileqq.flashshow.part.FSBasePart;
import com.tencent.mobileqq.flashshow.personal.widget.FSPersonalFeedHintView;

public class FSPersonalHintViewPart
  extends FSBasePart
{
  private FSPersonalFeedHintView a;
  
  public String a()
  {
    return "FSPersonalFeedPart";
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.a = ((FSPersonalFeedHintView)paramView.findViewById(2131433848));
  }
  
  public void a(String paramString)
  {
    this.a.a(paramString);
  }
  
  public void b(String paramString)
  {
    this.a.b(paramString);
  }
  
  public void d()
  {
    this.a.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.personal.part.FSPersonalHintViewPart
 * JD-Core Version:    0.7.0.1
 */