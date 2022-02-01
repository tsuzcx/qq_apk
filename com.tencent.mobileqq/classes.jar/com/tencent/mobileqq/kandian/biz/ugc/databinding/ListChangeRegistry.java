package com.tencent.mobileqq.kandian.biz.ugc.databinding;

import android.support.v4.util.Pools.SynchronizedPool;

public class ListChangeRegistry
  extends CallbackRegistry<ObservableList.OnListChangedCallback, ObservableList, ListChangeRegistry.ListChanges>
{
  private static final Pools.SynchronizedPool<ListChangeRegistry.ListChanges> jdField_a_of_type_AndroidSupportV4UtilPools$SynchronizedPool = new Pools.SynchronizedPool(10);
  private static final CallbackRegistry.NotifierCallback<ObservableList.OnListChangedCallback, ObservableList, ListChangeRegistry.ListChanges> jdField_a_of_type_ComTencentMobileqqKandianBizUgcDatabindingCallbackRegistry$NotifierCallback = new ListChangeRegistry.1();
  
  public ListChangeRegistry()
  {
    super(jdField_a_of_type_ComTencentMobileqqKandianBizUgcDatabindingCallbackRegistry$NotifierCallback);
  }
  
  private static ListChangeRegistry.ListChanges a(int paramInt1, int paramInt2, int paramInt3)
  {
    ListChangeRegistry.ListChanges localListChanges2 = (ListChangeRegistry.ListChanges)jdField_a_of_type_AndroidSupportV4UtilPools$SynchronizedPool.acquire();
    ListChangeRegistry.ListChanges localListChanges1 = localListChanges2;
    if (localListChanges2 == null) {
      localListChanges1 = new ListChangeRegistry.ListChanges();
    }
    localListChanges1.a = paramInt1;
    localListChanges1.c = paramInt2;
    localListChanges1.b = paramInt3;
    return localListChanges1;
  }
  
  public void a(ObservableList paramObservableList, int paramInt1, int paramInt2)
  {
    a(paramObservableList, 1, a(paramInt1, 0, paramInt2));
  }
  
  public void a(ObservableList paramObservableList, int paramInt, ListChangeRegistry.ListChanges paramListChanges)
  {
    try
    {
      super.a(paramObservableList, paramInt, paramListChanges);
      if (paramListChanges != null) {
        jdField_a_of_type_AndroidSupportV4UtilPools$SynchronizedPool.release(paramListChanges);
      }
      return;
    }
    finally {}
  }
  
  public void b(ObservableList paramObservableList, int paramInt1, int paramInt2)
  {
    a(paramObservableList, 2, a(paramInt1, 0, paramInt2));
  }
  
  public void c(ObservableList paramObservableList, int paramInt1, int paramInt2)
  {
    a(paramObservableList, 4, a(paramInt1, 0, paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.databinding.ListChangeRegistry
 * JD-Core Version:    0.7.0.1
 */