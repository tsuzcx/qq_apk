package com.tencent.mobileqq.shortvideo.common;

import java.util.ArrayList;
import java.util.Iterator;

public class Observable
{
  private Observable.TCHashMap<Integer, Observer> a;
  protected String a;
  
  public Observable()
  {
    this.jdField_a_of_type_JavaLangString = getClass().getSimpleName();
    this.jdField_a_of_type_ComTencentMobileqqShortvideoCommonObservable$TCHashMap = new Observable.TCHashMap(this);
  }
  
  public void a(int paramInt)
  {
    try
    {
      ArrayList localArrayList = this.jdField_a_of_type_ComTencentMobileqqShortvideoCommonObservable$TCHashMap.a(Integer.valueOf(paramInt));
      if (localArrayList != null) {
        localArrayList.clear();
      }
      return;
    }
    finally {}
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    try
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqShortvideoCommonObservable$TCHashMap.a(Integer.valueOf(paramInt));
      if ((localObject != null) && (!((ArrayList)localObject).isEmpty()))
      {
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          Observer localObserver = (Observer)((Iterator)localObject).next();
          if (localObserver != null) {
            localObserver.notify(this, paramInt, paramVarArgs);
          }
        }
      }
      return;
    }
    finally {}
  }
  
  public void a(Observer paramObserver)
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoCommonObservable$TCHashMap.a(paramObserver);
      return;
    }
    finally
    {
      paramObserver = finally;
      throw paramObserver;
    }
  }
  
  public void a(Observer paramObserver, int... paramVarArgs)
  {
    try
    {
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        int k = paramVarArgs[i];
        this.jdField_a_of_type_ComTencentMobileqqShortvideoCommonObservable$TCHashMap.a(Integer.valueOf(k), paramObserver);
        i += 1;
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.common.Observable
 * JD-Core Version:    0.7.0.1
 */