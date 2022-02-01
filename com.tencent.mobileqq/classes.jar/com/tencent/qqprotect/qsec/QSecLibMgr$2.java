package com.tencent.qqprotect.qsec;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

class QSecLibMgr$2
  extends QSecLibMgr.SFUVisitor
{
  private boolean d = false;
  
  QSecLibMgr$2(QSecLibMgr paramQSecLibMgr)
  {
    super(paramQSecLibMgr, null);
  }
  
  public void a()
  {
    if (this.b) {
      QSecLibMgr.e(this.a).a();
    }
    if (this.d) {
      QSecLibMgr.h(this.a);
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    if ((paramInt4 != 1) && (paramInt4 != 2))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQProtect.QSec", 2, String.format("Invalid mode: %d", new Object[] { Integer.valueOf(paramInt4) }));
      }
      return;
    }
    QSecDatabaseMgr.LibEntry localLibEntry = QSecLibMgr.e(this.a).a(paramInt1);
    if (localLibEntry != null) {
      QSecLibMgr.e(this.a).a(localLibEntry.a, false);
    } else {
      localLibEntry = new QSecDatabaseMgr.LibEntry();
    }
    localLibEntry.a = paramInt1;
    localLibEntry.b = paramInt2;
    localLibEntry.c = paramInt3;
    localLibEntry.e = paramString1;
    localLibEntry.d = paramString2;
    QSecLibMgr.e(this.a).a(localLibEntry, false);
    this.b = true;
    if ((paramInt4 == 1) && (QSecLibMgr.f(this.a).a(paramInt1) == 1))
    {
      this.d = true;
      QSecLibMgr.LoadedLibInfo localLoadedLibInfo = (QSecLibMgr.LoadedLibInfo)QSecLibMgr.g(this.a).get(Integer.valueOf(paramInt1));
      if (localLoadedLibInfo != null)
      {
        QSecLibMgr.a(this.a, localLoadedLibInfo, paramString2, paramString1);
        if (localLoadedLibInfo.d != 0) {
          QSecLibMgr.g(this.a).remove(Integer.valueOf(localLoadedLibInfo.a));
        }
      }
      else
      {
        paramString1 = QSecLibMgr.a(this.a, localLibEntry);
        QSecLibMgr.a(this.a, paramString1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqprotect.qsec.QSecLibMgr.2
 * JD-Core Version:    0.7.0.1
 */