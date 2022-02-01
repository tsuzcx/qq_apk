package com.tencent.mobileqq.qqexpand.fragment;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.ArrayList;
import java.util.List;

public class ExtendFriendReporter
{
  private final List<String> a = new ArrayList(20);
  private final QQAppInterface b;
  
  public ExtendFriendReporter(QQAppInterface paramQQAppInterface)
  {
    this.b = paramQQAppInterface;
  }
  
  public void a()
  {
    if (this.a.size() > 0) {
      b();
    }
  }
  
  public void a(String paramString)
  {
    this.a.add(paramString);
    if (this.a.size() >= 20) {
      b();
    }
  }
  
  void b()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < this.a.size())
    {
      if (i != 0) {
        localStringBuffer.append("|");
      }
      localStringBuffer.append((String)this.a.get(i));
      i += 1;
    }
    QQAppInterface localQQAppInterface = this.b;
    if (localQQAppInterface != null) {
      ReportController.b(localQQAppInterface, "dc00898", "", "", "0X8009324", "0X8009324", 0, 0, "", "", localStringBuffer.toString(), "");
    }
    this.a.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.fragment.ExtendFriendReporter
 * JD-Core Version:    0.7.0.1
 */