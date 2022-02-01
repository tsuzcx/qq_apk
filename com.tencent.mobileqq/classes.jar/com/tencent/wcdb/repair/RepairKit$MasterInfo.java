package com.tencent.wcdb.repair;

public class RepairKit$MasterInfo
{
  private long a;
  
  public void a()
  {
    long l = this.a;
    if (l == 0L) {
      return;
    }
    RepairKit.a(l);
    this.a = 0L;
  }
  
  protected void finalize()
  {
    a();
    super.finalize();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.wcdb.repair.RepairKit.MasterInfo
 * JD-Core Version:    0.7.0.1
 */