package com.tencent.mobileqq.filemanager.fileview;

class LocalTbsViewManager$6
  implements Runnable
{
  LocalTbsViewManager$6(LocalTbsViewManager paramLocalTbsViewManager, int paramInt, LocalTbsViewManager.LocalTbsViewManagerCallback paramLocalTbsViewManagerCallback) {}
  
  public void run()
  {
    int i = this.a;
    if ((i != 12) && (i != 19))
    {
      if (i != 5001)
      {
        if (i != 5002) {
          return;
        }
        this.b.a(false);
        return;
      }
      this.b.a(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileview.LocalTbsViewManager.6
 * JD-Core Version:    0.7.0.1
 */