package com.tencent.mobileqq.studyroom.shadow;

import com.tencent.mobileqq.intervideo.IVLoggerFactory;
import com.tencent.shadow.core.common.LoggerFactory;

public final class StudyRoomShadowImpl
{
  private static boolean a;
  
  static {}
  
  private static void a()
  {
    if (!a) {}
    try
    {
      LoggerFactory.setILoggerFactory(IVLoggerFactory.a());
      label12:
      a = true;
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      break label12;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.studyroom.shadow.StudyRoomShadowImpl
 * JD-Core Version:    0.7.0.1
 */