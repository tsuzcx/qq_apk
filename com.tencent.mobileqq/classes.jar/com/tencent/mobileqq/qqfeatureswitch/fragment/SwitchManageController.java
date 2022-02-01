package com.tencent.mobileqq.qqfeatureswitch.fragment;

import java.util.List;

public class SwitchManageController
{
  private SwitchManageController.ISwitchManageView a;
  private SwitchManageModel b;
  
  public SwitchManageController(SwitchManageController.ISwitchManageView paramISwitchManageView)
  {
    this.a = paramISwitchManageView;
    this.b = new SwitchManageModel(this.a.a());
  }
  
  public void a()
  {
    this.b.a();
    b();
  }
  
  public void a(String paramString)
  {
    paramString = this.b.a(paramString);
    this.a.a(paramString);
  }
  
  public void b()
  {
    List localList = this.b.b();
    this.a.a(localList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqfeatureswitch.fragment.SwitchManageController
 * JD-Core Version:    0.7.0.1
 */