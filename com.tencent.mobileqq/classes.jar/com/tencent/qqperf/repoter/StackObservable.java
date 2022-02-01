package com.tencent.qqperf.repoter;

import java.util.HashMap;
import java.util.Observable;

public class StackObservable
  extends Observable
{
  private static StackObservable a;
  public HashMap<String, String> a;
  
  public static StackObservable a()
  {
    if (jdField_a_of_type_ComTencentQqperfRepoterStackObservable == null) {
      try
      {
        if (jdField_a_of_type_ComTencentQqperfRepoterStackObservable == null) {
          jdField_a_of_type_ComTencentQqperfRepoterStackObservable = new StackObservable();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentQqperfRepoterStackObservable;
  }
  
  public void a(HashMap<String, String> paramHashMap)
  {
    paramHashMap.put("key_type", "t_held_thread");
    this.jdField_a_of_type_JavaUtilHashMap = paramHashMap;
    setChanged();
    notifyObservers();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqperf.repoter.StackObservable
 * JD-Core Version:    0.7.0.1
 */