package com.tencent.qqprotect.qsec;

import com.tencent.qqprotect.singleupdate.VerifyFileUtil;
import java.io.File;

final class QSecLibMgr$1ProtectedMethodForLoadLib
  implements CrashProtector.IProtectedMethod
{
  public QSecLibMgr.LoadedLibInfo a;
  
  QSecLibMgr$1ProtectedMethodForLoadLib(QSecLibMgr paramQSecLibMgr) {}
  
  public void a()
  {
    if ((this.a.h != null) && (!this.a.h.contains("..")))
    {
      Object localObject = new File(this.a.h);
      if (!((File)localObject).exists())
      {
        this.a.d = 12;
        return;
      }
      this.a.i = new RundownProtection();
      int i;
      if ((this.a.b != 2) && (this.a.b != 1)) {
        i = 0;
      } else {
        i = 1;
      }
      if ((i == 1) && (!VerifyFileUtil.a((File)localObject, null)))
      {
        this.a.d = 10;
        return;
      }
      localObject = new Object[1];
      QSecLibMgr.LoadedLibInfo localLoadedLibInfo = this.a;
      localLoadedLibInfo.d = QSecFramework.a(2L, localLoadedLibInfo.b, this.a.a, 0L, this.a.h, null, null, (Object[])localObject);
      if ((localObject[0] != null) && ((localObject[0] instanceof Integer))) {
        this.a.f = ((Integer)localObject[0]).intValue();
      }
    }
    else
    {
      this.a.d = 15;
    }
  }
  
  public void b()
  {
    this.a.d = 26;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqprotect.qsec.QSecLibMgr.1ProtectedMethodForLoadLib
 * JD-Core Version:    0.7.0.1
 */