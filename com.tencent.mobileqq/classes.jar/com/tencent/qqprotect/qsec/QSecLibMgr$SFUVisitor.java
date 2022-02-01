package com.tencent.qqprotect.qsec;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

class QSecLibMgr$SFUVisitor
{
  protected boolean b = false;
  
  private QSecLibMgr$SFUVisitor(QSecLibMgr paramQSecLibMgr) {}
  
  public void a()
  {
    if (this.b) {
      QSecLibMgr.e(this.c).a();
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    QSecDatabaseMgr.LibEntry localLibEntry2 = QSecLibMgr.e(this.c).a(paramInt1);
    if ((localLibEntry2 == null) || (!paramString1.equals(localLibEntry2.e)) || (!paramString2.equals(localLibEntry2.d)) || (paramInt2 != localLibEntry2.b) || (paramInt3 != localLibEntry2.c))
    {
      QSecDatabaseMgr.LibEntry localLibEntry1;
      if (localLibEntry2 == null)
      {
        localLibEntry1 = new QSecDatabaseMgr.LibEntry();
      }
      else
      {
        QSecLibMgr.e(this.c).a(paramInt1, false);
        localLibEntry1 = localLibEntry2;
        if (QLog.isColorLevel())
        {
          QLog.d("QQProtect.QSec", 2, String.format("Database info mismatch for lib: %d", new Object[] { Integer.valueOf(paramInt1) }));
          localLibEntry1 = localLibEntry2;
        }
      }
      localLibEntry1.a = paramInt1;
      localLibEntry1.b = paramInt2;
      localLibEntry1.c = paramInt3;
      localLibEntry1.e = paramString1;
      localLibEntry1.d = paramString2;
      if (QLog.isColorLevel()) {
        QLog.d("QQProtect.QSec", 2, String.format("Add lost lib: %d,%d,%d,%s", new Object[] { Integer.valueOf(localLibEntry1.a), Integer.valueOf(localLibEntry1.b), Integer.valueOf(localLibEntry1.c), localLibEntry1.e }));
      }
      QSecLibMgr.e(this.c).a(localLibEntry1, false);
      this.b = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqprotect.qsec.QSecLibMgr.SFUVisitor
 * JD-Core Version:    0.7.0.1
 */