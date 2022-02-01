package com.tencent.mobileqq.filemanager.util;

final class QQFileManagerUtilImpl$12
  implements Runnable
{
  QQFileManagerUtilImpl$12(String paramString1, QQFileManagerUtil.IThumbResult paramIThumbResult, String paramString2, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    if (FileUtil.b(this.a))
    {
      QQFileManagerUtil.IThumbResult localIThumbResult = this.b;
      if (localIThumbResult != null) {
        localIThumbResult.a(this.a);
      }
      return;
    }
    if (QQFileManagerUtilImpl.a(this.c, this.d, this.e, this.b, this.a)) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.QQFileManagerUtilImpl.12
 * JD-Core Version:    0.7.0.1
 */