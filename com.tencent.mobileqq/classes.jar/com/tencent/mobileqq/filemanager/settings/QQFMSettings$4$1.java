package com.tencent.mobileqq.filemanager.settings;

class QQFMSettings$4$1
  implements FMSettingInterface.MoveFileCallback
{
  QQFMSettings$4$1(QQFMSettings.4 param4) {}
  
  public void a()
  {
    synchronized (this.a.this$0)
    {
      QQFMSettings localQQFMSettings = this.a.this$0;
      localQQFMSettings.e += 1;
      ??? = new StringBuilder();
      ((StringBuilder)???).append("onMovedOver,count[");
      ((StringBuilder)???).append(this.a.this$0.e);
      ((StringBuilder)???).append("],total[");
      ((StringBuilder)???).append(this.a.c);
      ((StringBuilder)???).append("]");
      QQFMSettings.a(1, ((StringBuilder)???).toString());
      if (this.a.this$0.e == this.a.c)
      {
        QQFMSettings.a(1, "moveFileToDefaultPath,move over!");
        this.a.d.a();
      }
      return;
    }
  }
  
  public void a(int paramInt)
  {
    synchronized (this.a.this$0)
    {
      QQFMSettings localQQFMSettings = this.a.this$0;
      localQQFMSettings.e += 1;
      ??? = new StringBuilder();
      ((StringBuilder)???).append("onMoveFail,count[");
      ((StringBuilder)???).append(this.a.this$0.e);
      ((StringBuilder)???).append("],total[");
      ((StringBuilder)???).append(this.a.c);
      ((StringBuilder)???).append("]");
      QQFMSettings.a(1, ((StringBuilder)???).toString());
      if (this.a.this$0.e == this.a.c)
      {
        QQFMSettings.a(1, "moveFileToDefaultPath,move over!");
        this.a.d.a(16);
      }
      return;
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    QQFMSettings localQQFMSettings = this.a.this$0;
    localQQFMSettings.c += paramLong1;
    this.a.d.a(this.a.this$0.c, this.a.this$0.d);
  }
  
  public void a(String paramString1, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.settings.QQFMSettings.4.1
 * JD-Core Version:    0.7.0.1
 */