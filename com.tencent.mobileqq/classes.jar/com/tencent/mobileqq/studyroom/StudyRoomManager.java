package com.tencent.mobileqq.studyroom;

import android.content.Context;
import java.util.HashMap;
import mqq.manager.Manager;

public abstract class StudyRoomManager
  implements Manager
{
  public abstract void a(Context paramContext);
  
  public abstract void a(Context paramContext, String paramString, HashMap<String, String> paramHashMap);
  
  public abstract void a(StudyRoomManager.TroopStudyMemberChangeObserver paramTroopStudyMemberChangeObserver);
  
  public abstract void a(String paramString);
  
  public abstract void a(byte[] paramArrayOfByte, String paramString);
  
  public abstract int b(String paramString);
  
  public abstract void b(StudyRoomManager.TroopStudyMemberChangeObserver paramTroopStudyMemberChangeObserver);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.studyroom.StudyRoomManager
 * JD-Core Version:    0.7.0.1
 */