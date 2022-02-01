package com.tencent.mobileqq.troop.redpoint;

import android.view.View;
import java.util.List;
import mqq.app.AppRuntime;

public class CleanRedPointUIComponent
{
  private String a;
  private String b;
  private AppRuntime c;
  private View d;
  private OnHandleClickEvent e;
  private List<Integer> f;
  
  public CleanRedPointUIComponent(RedPointUIData paramRedPointUIData)
  {
    if (paramRedPointUIData != null)
    {
      this.c = paramRedPointUIData.g;
      this.a = paramRedPointUIData.a;
      this.b = paramRedPointUIData.b;
      this.e = paramRedPointUIData.h;
      this.d = paramRedPointUIData.d;
      this.f = paramRedPointUIData.f;
    }
    b();
  }
  
  private void b()
  {
    View localView = this.d;
    if (localView != null) {
      localView.setOnClickListener(new CleanRedPointUIComponent.1(this));
    }
  }
  
  public void a()
  {
    Object localObject = this.d;
    if (localObject != null) {
      ((View)localObject).setOnClickListener(null);
    }
    localObject = this.f;
    if (localObject != null) {
      ((List)localObject).clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.redpoint.CleanRedPointUIComponent
 * JD-Core Version:    0.7.0.1
 */