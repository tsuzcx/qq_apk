package com.tencent.qav.observer;

public class ObserverDispatcher
  extends FilterableObservable
{
  private static ObserverDispatcher jdField_a_of_type_ComTencentQavObserverObserverDispatcher;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  
  public static ObserverDispatcher a()
  {
    if (jdField_a_of_type_ComTencentQavObserverObserverDispatcher == null) {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        if (jdField_a_of_type_ComTencentQavObserverObserverDispatcher == null) {
          jdField_a_of_type_ComTencentQavObserverObserverDispatcher = new ObserverDispatcher();
        }
      }
    }
    return jdField_a_of_type_ComTencentQavObserverObserverDispatcher;
  }
  
  public void a()
  {
    super.a();
    jdField_a_of_type_ComTencentQavObserverObserverDispatcher = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qav.observer.ObserverDispatcher
 * JD-Core Version:    0.7.0.1
 */