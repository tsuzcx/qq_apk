package com.tencent.mobileqq.search.searchengine;

import aibb;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Comparator;
import java.util.Set;

public class PhoneContactMultiBindSearchEngine
  extends ContactSearchEngine
{
  public final aibb a;
  
  public PhoneContactMultiBindSearchEngine(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, String paramString, Set paramSet)
  {
    super(paramQQAppInterface, paramInt1, paramInt2, paramString, paramSet);
    this.a = new aibb(paramQQAppInterface);
  }
  
  public Comparator a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.searchengine.PhoneContactMultiBindSearchEngine
 * JD-Core Version:    0.7.0.1
 */