package com.tencent.mobileqq.search.searchengine;

import ahwk;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Comparator;
import java.util.Set;

public class PhoneContactBinedSearchEngine
  extends ContactSearchEngine
{
  private Comparator a = new ahwk(this);
  
  public PhoneContactBinedSearchEngine(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, String paramString, Set paramSet)
  {
    super(paramQQAppInterface, paramInt1, paramInt2, paramString, paramSet);
  }
  
  public Comparator a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.searchengine.PhoneContactBinedSearchEngine
 * JD-Core Version:    0.7.0.1
 */