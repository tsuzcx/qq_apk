package com.tencent.mobileqq.kandian.repo.aladdin.config;

import java.util.ArrayList;

public class AladdinListenerUtils
{
  public static ArrayList<AladdinListener> a = new ArrayList();
  
  public static void a(AladdinListener paramAladdinListener)
  {
    if (!a.contains(paramAladdinListener)) {
      a.add(paramAladdinListener);
    }
  }
  
  public static void b(AladdinListener paramAladdinListener)
  {
    a.remove(paramAladdinListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.aladdin.config.AladdinListenerUtils
 * JD-Core Version:    0.7.0.1
 */