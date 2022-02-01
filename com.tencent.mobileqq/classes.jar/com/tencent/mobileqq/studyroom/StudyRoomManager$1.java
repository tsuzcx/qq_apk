package com.tencent.mobileqq.studyroom;

import com.tencent.mobileqq.app.GuardProcessExitListener;

class StudyRoomManager$1
  extends GuardProcessExitListener
{
  StudyRoomManager$1(StudyRoomManager paramStudyRoomManager) {}
  
  public String a()
  {
    return "com.tencent.mobileqq:live";
  }
  
  /* Error */
  public void a(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 10	com/tencent/mobileqq/studyroom/StudyRoomManager$1:a	Lcom/tencent/mobileqq/studyroom/StudyRoomManager;
    //   4: invokestatic 25	com/tencent/mobileqq/studyroom/StudyRoomManager:a	(Lcom/tencent/mobileqq/studyroom/StudyRoomManager;)Lcom/tencent/shadow/dynamic/host/DynamicPluginManager;
    //   7: ifnull +48 -> 55
    //   10: aload_0
    //   11: getfield 10	com/tencent/mobileqq/studyroom/StudyRoomManager$1:a	Lcom/tencent/mobileqq/studyroom/StudyRoomManager;
    //   14: invokestatic 25	com/tencent/mobileqq/studyroom/StudyRoomManager:a	(Lcom/tencent/mobileqq/studyroom/StudyRoomManager;)Lcom/tencent/shadow/dynamic/host/DynamicPluginManager;
    //   17: invokevirtual 31	com/tencent/shadow/dynamic/host/DynamicPluginManager:getManagerImpl	()Lcom/tencent/shadow/dynamic/host/PluginManager;
    //   20: instanceof 33
    //   23: ifeq +32 -> 55
    //   26: aload_0
    //   27: getfield 10	com/tencent/mobileqq/studyroom/StudyRoomManager$1:a	Lcom/tencent/mobileqq/studyroom/StudyRoomManager;
    //   30: invokestatic 25	com/tencent/mobileqq/studyroom/StudyRoomManager:a	(Lcom/tencent/mobileqq/studyroom/StudyRoomManager;)Lcom/tencent/shadow/dynamic/host/DynamicPluginManager;
    //   33: invokevirtual 31	com/tencent/shadow/dynamic/host/DynamicPluginManager:getManagerImpl	()Lcom/tencent/shadow/dynamic/host/PluginManager;
    //   36: checkcast 33	com/tencent/mobileqq/intervideo/shadow/PluginProcessKiller
    //   39: astore_2
    //   40: aload_2
    //   41: invokeinterface 36 1 0
    //   46: aload_0
    //   47: getfield 10	com/tencent/mobileqq/studyroom/StudyRoomManager$1:a	Lcom/tencent/mobileqq/studyroom/StudyRoomManager;
    //   50: aconst_null
    //   51: invokestatic 39	com/tencent/mobileqq/studyroom/StudyRoomManager:a	(Lcom/tencent/mobileqq/studyroom/StudyRoomManager;Lcom/tencent/shadow/dynamic/host/DynamicPluginManager;)Lcom/tencent/shadow/dynamic/host/DynamicPluginManager;
    //   54: pop
    //   55: return
    //   56: astore_2
    //   57: aload_0
    //   58: getfield 10	com/tencent/mobileqq/studyroom/StudyRoomManager$1:a	Lcom/tencent/mobileqq/studyroom/StudyRoomManager;
    //   61: aconst_null
    //   62: invokestatic 39	com/tencent/mobileqq/studyroom/StudyRoomManager:a	(Lcom/tencent/mobileqq/studyroom/StudyRoomManager;Lcom/tencent/shadow/dynamic/host/DynamicPluginManager;)Lcom/tencent/shadow/dynamic/host/DynamicPluginManager;
    //   65: pop
    //   66: return
    //   67: astore_2
    //   68: aload_0
    //   69: getfield 10	com/tencent/mobileqq/studyroom/StudyRoomManager$1:a	Lcom/tencent/mobileqq/studyroom/StudyRoomManager;
    //   72: aconst_null
    //   73: invokestatic 39	com/tencent/mobileqq/studyroom/StudyRoomManager:a	(Lcom/tencent/mobileqq/studyroom/StudyRoomManager;Lcom/tencent/shadow/dynamic/host/DynamicPluginManager;)Lcom/tencent/shadow/dynamic/host/DynamicPluginManager;
    //   76: pop
    //   77: aload_2
    //   78: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	79	0	this	1
    //   0	79	1	paramBoolean	boolean
    //   39	2	2	localPluginProcessKiller	com.tencent.mobileqq.intervideo.shadow.PluginProcessKiller
    //   56	1	2	localIllegalArgumentException	java.lang.IllegalArgumentException
    //   67	11	2	localObject	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   40	46	56	java/lang/IllegalArgumentException
    //   40	46	67	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.studyroom.StudyRoomManager.1
 * JD-Core Version:    0.7.0.1
 */