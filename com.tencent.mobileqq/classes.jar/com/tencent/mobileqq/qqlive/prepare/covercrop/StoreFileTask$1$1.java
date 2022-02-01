package com.tencent.mobileqq.qqlive.prepare.covercrop;

class StoreFileTask$1$1
  implements Runnable
{
  StoreFileTask$1$1(StoreFileTask.1 param1, String paramString) {}
  
  public void run()
  {
    if (this.b.a != null)
    {
      if (!"oom".equals(this.a))
      {
        String str = this.a;
        if (str != null)
        {
          if ("sdcardfull".equals(str))
          {
            this.b.a.b("SD卡空间不足");
            return;
          }
          this.b.a.a(StoreFileTask.b(this.b.this$0));
          return;
        }
      }
      this.b.a.b("内存不足");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.prepare.covercrop.StoreFileTask.1.1
 * JD-Core Version:    0.7.0.1
 */