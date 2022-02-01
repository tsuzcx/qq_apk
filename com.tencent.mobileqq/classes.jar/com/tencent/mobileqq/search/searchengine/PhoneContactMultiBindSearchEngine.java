package com.tencent.mobileqq.search.searchengine;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.model.IContactSearchModel;
import java.util.Comparator;
import java.util.Set;

public class PhoneContactMultiBindSearchEngine
  extends ContactSearchEngine
{
  public final PhoneContactMultiBindSearchEngine.PinyinCharComparator a;
  
  public PhoneContactMultiBindSearchEngine(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, String paramString, Set<String> paramSet)
  {
    super(paramQQAppInterface, paramInt1, paramInt2, paramString, paramSet);
    this.a = new PhoneContactMultiBindSearchEngine.PinyinCharComparator(paramQQAppInterface);
  }
  
  public Comparator<IContactSearchModel> a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.searchengine.PhoneContactMultiBindSearchEngine
 * JD-Core Version:    0.7.0.1
 */