package com.tencent.qqlive.module.videoreport.storage.database;

import java.util.List;

class DbService$1
  implements Runnable
{
  DbService$1(DbService paramDbService, List paramList1, List paramList2) {}
  
  public void run()
  {
    int j = this.a.size();
    int i = 0;
    while (i < j)
    {
      Object localObject = this.a.get(i);
      String str = (String)this.b.get(i);
      this.this$0.insertObject(localObject, str);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.storage.database.DbService.1
 * JD-Core Version:    0.7.0.1
 */