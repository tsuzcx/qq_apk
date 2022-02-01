package com.tencent.qqlive.module.videoreport.storage.database;

import com.tencent.qqlive.module.videoreport.storage.annotation.AnnotationProcessor;
import com.tencent.qqlive.module.videoreport.storage.util.Condition;
import java.util.List;

class DatabaseStorage$1
  implements Condition<T>
{
  DatabaseStorage$1(DatabaseStorage paramDatabaseStorage, List paramList) {}
  
  public boolean satisfy(T paramT)
  {
    paramT = DatabaseStorage.access$000(this.b).getObjectId(paramT);
    return this.a.contains(paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.storage.database.DatabaseStorage.1
 * JD-Core Version:    0.7.0.1
 */