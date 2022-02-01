package com.tencent.mobileqq.leba.entity;

import java.util.ArrayList;
import java.util.List;

public class LebaShowData
{
  public final List<LebaViewItem> a = new ArrayList();
  public final List<LebaViewItem> b = new ArrayList();
  
  public void a(LebaViewItem paramLebaViewItem)
  {
    if (paramLebaViewItem == null) {
      return;
    }
    this.b.add(paramLebaViewItem);
    paramLebaViewItem.b();
  }
  
  public void a(LebaViewItem paramLebaViewItem, int paramInt)
  {
    if (paramLebaViewItem == null) {
      return;
    }
    if (this.a.size() < paramInt)
    {
      this.a.add(paramLebaViewItem);
      paramLebaViewItem.a();
      return;
    }
    this.b.add(paramLebaViewItem);
    paramLebaViewItem.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.entity.LebaShowData
 * JD-Core Version:    0.7.0.1
 */