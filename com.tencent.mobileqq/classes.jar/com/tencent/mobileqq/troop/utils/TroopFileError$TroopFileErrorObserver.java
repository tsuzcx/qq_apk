package com.tencent.mobileqq.troop.utils;

import android.content.Context;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import java.lang.ref.WeakReference;

public class TroopFileError$TroopFileErrorObserver
  extends BizTroopObserver
{
  int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private TroopFileError.TroopFileErrorFilter jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorFilter;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  
  public TroopFileError$TroopFileErrorObserver(Context paramContext, long paramLong, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Int = 0;
  }
  
  public TroopFileError$TroopFileErrorObserver(Context paramContext, TroopFileError.TroopFileErrorFilter paramTroopFileErrorFilter, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorFilter = paramTroopFileErrorFilter;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Int = 0;
  }
  
  protected void b(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof TroopFileError.SimpleErrorInfo))) {}
    Context localContext;
    do
    {
      return;
      paramObject = (TroopFileError.SimpleErrorInfo)paramObject;
      localContext = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (localContext == null);
    TroopFileError.a(paramObject, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopFileError.TroopFileErrorObserver
 * JD-Core Version:    0.7.0.1
 */