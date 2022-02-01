package com.tencent.mobileqq.search.business.contact;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.search.business.contact.model.IContactSearchModel;
import java.util.Comparator;
import java.util.Set;

public class PhoneContactMultiBindSearchEngine
  extends ContactSearchEngine
{
  public final PhoneContactMultiBindSearchEngine.PinyinCharComparator d;
  
  public PhoneContactMultiBindSearchEngine(AppInterface paramAppInterface, int paramInt1, int paramInt2, String paramString, Set<String> paramSet)
  {
    super(paramAppInterface, paramInt1, paramInt2, paramString, paramSet);
    this.d = new PhoneContactMultiBindSearchEngine.PinyinCharComparator(paramAppInterface);
  }
  
  public Comparator<IContactSearchModel> f()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.contact.PhoneContactMultiBindSearchEngine
 * JD-Core Version:    0.7.0.1
 */