package com.tencent.mobileqq.search;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.manager.Manager;

public class SearchWebHistoryManager
  implements Manager
{
  public static final String a = HardCodeUtil.a(2131911142);
  public static final String b = HardCodeUtil.a(2131911141);
  public static final String c = HardCodeUtil.a(2131911140);
  public static final String d = HardCodeUtil.a(2131911143);
  int e = -1;
  QQAppInterface f;
  
  public SearchWebHistoryManager(QQAppInterface paramQQAppInterface) {}
  
  public void onDestroy()
  {
    this.f = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.SearchWebHistoryManager
 * JD-Core Version:    0.7.0.1
 */