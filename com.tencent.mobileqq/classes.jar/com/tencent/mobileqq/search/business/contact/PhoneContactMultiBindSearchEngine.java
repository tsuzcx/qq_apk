package com.tencent.mobileqq.search.business.contact;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.search.business.contact.model.IContactSearchModel;
import java.util.Comparator;
import java.util.Set;

public class PhoneContactMultiBindSearchEngine
  extends ContactSearchEngine
{
  public final PhoneContactMultiBindSearchEngine.PinyinCharComparator a;
  
  public PhoneContactMultiBindSearchEngine(AppInterface paramAppInterface, int paramInt1, int paramInt2, String paramString, Set<String> paramSet)
  {
    super(paramAppInterface, paramInt1, paramInt2, paramString, paramSet);
    this.a = new PhoneContactMultiBindSearchEngine.PinyinCharComparator(paramAppInterface);
  }
  
  public Comparator<IContactSearchModel> a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.contact.PhoneContactMultiBindSearchEngine
 * JD-Core Version:    0.7.0.1
 */