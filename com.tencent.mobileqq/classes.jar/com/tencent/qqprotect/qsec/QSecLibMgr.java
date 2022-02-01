package com.tencent.qqprotect.qsec;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.os.Handler;
import android.util.Pair;
import com.tencent.component.network.utils.FileUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.common.QPMiscUtils;
import com.tencent.qqprotect.common.QSecRptController;
import com.tencent.qqprotect.common.QSecRptHelper;
import java.io.File;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.MobileQQ;

public class QSecLibMgr
{
  private ConcurrentHashMap<Integer, QSecLibMgr.LoadedLibInfo> a;
  private List<QSecLibMgr.LoadedLibInfo> b;
  private QSecDatabaseMgr c;
  private QSecCbMgr d;
  private Handler e;
  private boolean f = false;
  private boolean g = false;
  private CopyOnWriteArrayList<QSecLibMgr.LibEventListener> h = new CopyOnWriteArrayList();
  private final String[] i = { "libhobi.so" };
  private final String[] j = { "2.1.3" };
  private final int[] k = { 0, 1, 2, 2 };
  
  public QSecLibMgr(QSecCbMgr paramQSecCbMgr)
  {
    this.d = paramQSecCbMgr;
    this.b = new LinkedList();
    this.c = new QSecDatabaseMgr();
    this.a = new ConcurrentHashMap();
    this.e = new QSecLibMgr.QSecHandler(this, ThreadManager.getFileThreadLooper());
    this.d.a(new QSecLibMgr.1(this));
  }
  
  private int a(int paramInt)
  {
    int m = 0;
    for (;;)
    {
      int[] arrayOfInt = this.k;
      if (m >= arrayOfInt.length) {
        break;
      }
      if (paramInt == arrayOfInt[(m + 1)]) {
        return m / 4;
      }
      m += 4;
    }
    return -1;
  }
  
  private QSecLibMgr.LoadedLibInfo a(QSecDatabaseMgr.LibEntry paramLibEntry)
  {
    QSecLibMgr.LoadedLibInfo localLoadedLibInfo = new QSecLibMgr.LoadedLibInfo(null);
    localLoadedLibInfo.a = paramLibEntry.a;
    localLoadedLibInfo.b = paramLibEntry.b;
    localLoadedLibInfo.c = paramLibEntry.c;
    localLoadedLibInfo.h = paramLibEntry.e;
    localLoadedLibInfo.g = paramLibEntry.d;
    localLoadedLibInfo.e = 4;
    return localLoadedLibInfo;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.h.iterator();
    while (localIterator.hasNext())
    {
      QSecLibMgr.LibEventListener localLibEventListener = (QSecLibMgr.LibEventListener)localIterator.next();
      if (QLog.isColorLevel()) {
        QLog.d("QQProtect.QSec", 2, String.format("Notify listener [%d:%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
      }
      localLibEventListener.a(paramInt1, paramInt2);
    }
  }
  
  private void a(QSecLibMgr.LoadedLibInfo paramLoadedLibInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQProtect.QSec", 2, String.format("Prepare to unload: %d,%d,%d,%d,%s,%s", new Object[] { Integer.valueOf(paramLoadedLibInfo.a), Integer.valueOf(paramLoadedLibInfo.b), Integer.valueOf(paramLoadedLibInfo.c), Integer.valueOf(paramLoadedLibInfo.e), paramLoadedLibInfo.g, paramLoadedLibInfo.h }));
    }
    if ((paramLoadedLibInfo.c & 0x1) == 0) {
      return;
    }
    if (paramLoadedLibInfo.e == 1)
    {
      paramLoadedLibInfo.e = 3;
      paramLoadedLibInfo.i.c();
      int m = QSecFramework.a(3L, paramLoadedLibInfo.a, 0L, 0L, null, null, null, null);
      if (QLog.isColorLevel()) {
        QLog.d("QQProtect.QSec", 2, new Object[] { "Unload ret: %d", Integer.valueOf(m) });
      }
      if (m == 0)
      {
        paramLoadedLibInfo.e = 4;
        a(2, paramLoadedLibInfo.a);
        return;
      }
      paramLoadedLibInfo.e = 5;
      paramLoadedLibInfo.d = m;
      return;
    }
  }
  
  private void a(QSecLibMgr.LoadedLibInfo paramLoadedLibInfo, String paramString1, String paramString2)
  {
    a(paramLoadedLibInfo);
    if (paramLoadedLibInfo.e == 4)
    {
      if ((paramLoadedLibInfo.h != null) && (!paramLoadedLibInfo.h.equals(paramString2)))
      {
        FileUtils.delete(paramLoadedLibInfo.h);
        paramLoadedLibInfo.h = paramString2;
      }
      if ((paramLoadedLibInfo.g != null) && (!paramLoadedLibInfo.g.equals(paramString1))) {
        paramLoadedLibInfo.g = paramString1;
      }
      paramLoadedLibInfo.f = 0;
      c(paramLoadedLibInfo);
      d(paramLoadedLibInfo);
    }
  }
  
  private void a(List<Pair<Integer, Byte>> paramList)
  {
    if (paramList != null)
    {
      if (!this.f) {
        return;
      }
      LinkedList localLinkedList = new LinkedList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject1 = (Pair)paramList.next();
        if (QLog.isColorLevel()) {
          QLog.d("QQProtect.QSec", 2, String.format("cb changed: id(%d), cb(%d)", new Object[] { ((Pair)localObject1).first, ((Pair)localObject1).second }));
        }
        Object localObject2 = (QSecLibMgr.LoadedLibInfo)this.a.get(((Pair)localObject1).first);
        if (localObject2 == null)
        {
          localObject2 = this.c.a(((Integer)((Pair)localObject1).first).intValue());
          if (localObject2 != null) {
            if (((Byte)((Pair)localObject1).second).byteValue() == 1) {
              e(a((QSecDatabaseMgr.LibEntry)localObject2));
            } else if (((Byte)((Pair)localObject1).second).byteValue() == 2) {
              localLinkedList.add(localObject2);
            }
          }
        }
        else if (((Byte)((Pair)localObject1).second).byteValue() == 1)
        {
          if (((QSecLibMgr.LoadedLibInfo)localObject2).e == 4)
          {
            c((QSecLibMgr.LoadedLibInfo)localObject2);
            if (((QSecLibMgr.LoadedLibInfo)localObject2).d != 0) {
              this.a.remove(Integer.valueOf(((QSecLibMgr.LoadedLibInfo)localObject2).a));
            }
            d((QSecLibMgr.LoadedLibInfo)localObject2);
          }
        }
        else if ((((Byte)((Pair)localObject1).second).byteValue() == 2) && (((QSecLibMgr.LoadedLibInfo)localObject2).e == 4))
        {
          this.a.remove(((Pair)localObject1).first);
          localObject1 = this.c.a(((Integer)((Pair)localObject1).first).intValue());
          if (localObject1 != null) {
            localLinkedList.add(localObject1);
          }
        }
      }
      if (!localLinkedList.isEmpty()) {
        b(localLinkedList);
      }
      f();
    }
  }
  
  private void b(QSecLibMgr.LoadedLibInfo paramLoadedLibInfo)
  {
    QSecRptHelper localQSecRptHelper = new QSecRptHelper();
    localQSecRptHelper.a(paramLoadedLibInfo.a).a(paramLoadedLibInfo.g).a(paramLoadedLibInfo.d);
    QSecRptController.b(localQSecRptHelper.toString(), 104);
  }
  
  private void b(List<QSecDatabaseMgr.LibEntry> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      QSecDatabaseMgr.LibEntry localLibEntry = (QSecDatabaseMgr.LibEntry)paramList.next();
      this.c.a(localLibEntry.a, false);
      if (localLibEntry.e != null)
      {
        int m = a(localLibEntry.a);
        if (m != -1)
        {
          Object localObject = new StringBuilder();
          ((StringBuilder)localObject).append(c());
          ((StringBuilder)localObject).append(File.separator);
          ((StringBuilder)localObject).append(this.i[this.k[m]]);
          localObject = ((StringBuilder)localObject).toString();
          if (localLibEntry.e.equals(localObject)) {}
        }
        else
        {
          FileUtils.delete(localLibEntry.e);
        }
      }
    }
    this.c.a();
  }
  
  private String c()
  {
    return BaseApplication.getContext().getApplicationInfo().nativeLibraryDir;
  }
  
  private void c(QSecLibMgr.LibEventListener paramLibEventListener)
  {
    Iterator localIterator = this.a.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (((QSecLibMgr.LoadedLibInfo)localEntry.getValue()).e == 1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQProtect.QSec", 2, String.format("Notify listener [%d:%d]", new Object[] { Integer.valueOf(1), localEntry.getKey() }));
        }
        paramLibEventListener.a(1, ((Integer)localEntry.getKey()).intValue());
      }
    }
  }
  
  private void c(QSecLibMgr.LoadedLibInfo paramLoadedLibInfo)
  {
    paramLoadedLibInfo.e = 2;
    Object localObject = new QSecLibMgr.1ProtectedMethodForLoadLib(this);
    ((QSecLibMgr.1ProtectedMethodForLoadLib)localObject).a = paramLoadedLibInfo;
    int n = paramLoadedLibInfo.a;
    String str = paramLoadedLibInfo.g;
    int m = 1;
    new CrashProtector(String.format("Lib%d_%s", new Object[] { Integer.valueOf(n), str }), 43200000L).a((CrashProtector.IProtectedMethod)localObject);
    if (QLog.isColorLevel())
    {
      if (paramLoadedLibInfo.h == null) {
        localObject = "null";
      } else {
        localObject = paramLoadedLibInfo.h;
      }
      QLog.d("QQProtect.QSec", 2, String.format("load: %s ver: %s error: %08X", new Object[] { localObject, QPMiscUtils.b(paramLoadedLibInfo.f), Integer.valueOf(paramLoadedLibInfo.d) }));
    }
    if (paramLoadedLibInfo.d != 0) {
      m = 4;
    }
    paramLoadedLibInfo.e = m;
  }
  
  private void d()
  {
    if (!this.f)
    {
      this.g = true;
      return;
    }
    this.g = false;
    new QSecLibMgr.QSecSFUReader(new QSecLibMgr.2(this)).a(1);
  }
  
  private void d(QSecLibMgr.LoadedLibInfo paramLoadedLibInfo)
  {
    this.b.add(paramLoadedLibInfo);
  }
  
  private void e()
  {
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("QSecSP", 0);
    SharedPreferences.Editor localEditor = localSharedPreferences.edit();
    try
    {
      localObject1 = (QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
      if (localObject1 != null)
      {
        localObject2 = ((QQAppInterface)localObject1).getCurrentAccountUin();
        if (localObject2 == null) {}
      }
    }
    catch (Exception localException2)
    {
      Object localObject1;
      Object localObject2;
      int m;
      label62:
      l1 = 28800000L;
    }
    try
    {
      m = Integer.parseInt(((QQAppInterface)localObject1).getCurrentAccountUin());
    }
    catch (NumberFormatException localNumberFormatException)
    {
      StringBuilder localStringBuilder;
      break label62;
      long l3 = 28800000L - l2;
      l2 = l1;
      if (l1 <= l3) {
        break label406;
      }
      l2 = l3;
      break label406;
    }
    m = 0;
    localObject2 = this.b.iterator();
    l1 = 28800000L;
    for (;;)
    {
      l2 = l1;
      try
      {
        if (!((Iterator)localObject2).hasNext()) {
          break label431;
        }
        QSecLibMgr.LoadedLibInfo localLoadedLibInfo = (QSecLibMgr.LoadedLibInfo)((Iterator)localObject2).next();
        localObject1 = localLoadedLibInfo.g;
        if (localLoadedLibInfo.f != 0) {
          localObject1 = QPMiscUtils.b(localLoadedLibInfo.f);
        }
        m ^= 0x12345678;
        String str1 = String.format("Lib%d_%d_%s", new Object[] { Integer.valueOf(localLoadedLibInfo.a), Integer.valueOf(m), localObject1 });
        String str2 = String.format("Lib%d_%d_%s_lpt", new Object[] { Integer.valueOf(localLoadedLibInfo.a), Integer.valueOf(m), localObject1 });
        int n = localSharedPreferences.getInt(str1, -1);
        l2 = localSharedPreferences.getLong(str2, 0L);
        l2 = new Date().getTime() - l2;
        if ((l2 < 28800000L) && (localLoadedLibInfo.d == n))
        {
          if (!QLog.isColorLevel()) {
            break label505;
          }
          QLog.d("QQProtect.QSec", 2, String.format("Ignore rp for: %d,%08X,%s", new Object[] { Integer.valueOf(localLoadedLibInfo.a), Integer.valueOf(localLoadedLibInfo.d), localObject1 }));
          break label505;
        }
        if (QLog.isColorLevel()) {
          QLog.d("QQProtect.QSec", 2, String.format("Rp: %d,%d,%s", new Object[] { Integer.valueOf(localLoadedLibInfo.a), Integer.valueOf(localLoadedLibInfo.d), localObject1 }));
        }
        localEditor.putInt(str1, localLoadedLibInfo.d);
        localEditor.putLong(str2, new Date().getTime());
        b(localLoadedLibInfo);
        l2 = l1;
        label406:
        l1 = l2;
      }
      catch (Exception localException1) {}
    }
    localException2.printStackTrace();
    l2 = l1;
    label431:
    localEditor.commit();
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("next rp interval: ");
      localStringBuilder.append(l2);
      QLog.d("QQProtect.QSec", 2, localStringBuilder.toString());
    }
    QSecFramework.a().postDelayed(new QSecLibMgr.3(this), l2);
  }
  
  private void e(QSecLibMgr.LoadedLibInfo paramLoadedLibInfo)
  {
    c(paramLoadedLibInfo);
    if (paramLoadedLibInfo.d == 0)
    {
      this.a.put(Integer.valueOf(paramLoadedLibInfo.a), paramLoadedLibInfo);
      a(1, paramLoadedLibInfo.a);
    }
    d(paramLoadedLibInfo);
  }
  
  private void f()
  {
    Handler localHandler = this.e;
    localHandler.sendMessage(localHandler.obtainMessage(4));
  }
  
  private void g()
  {
    Object localObject1 = this.c.b();
    if (localObject1 != null)
    {
      if (((List)localObject1).isEmpty()) {
        return;
      }
      LinkedList localLinkedList = new LinkedList();
      Iterator localIterator = ((List)localObject1).iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (QSecDatabaseMgr.LibEntry)localIterator.next();
        byte b1 = this.d.a(((QSecDatabaseMgr.LibEntry)localObject2).a);
        int m;
        if (QLog.isColorLevel())
        {
          m = ((QSecDatabaseMgr.LibEntry)localObject2).a;
          int n = ((QSecDatabaseMgr.LibEntry)localObject2).b;
          int i1 = ((QSecDatabaseMgr.LibEntry)localObject2).c;
          String str = ((QSecDatabaseMgr.LibEntry)localObject2).d;
          if (((QSecDatabaseMgr.LibEntry)localObject2).e == null) {
            localObject1 = "null";
          } else {
            localObject1 = ((QSecDatabaseMgr.LibEntry)localObject2).e;
          }
          QLog.d("QQProtect.QSec", 2, String.format("%d,%d,%d,%s,%s,%d", new Object[] { Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), str, localObject1, Byte.valueOf(b1) }));
        }
        if (b1 != 0) {
          if (2 == b1)
          {
            localLinkedList.add(localObject2);
          }
          else if (1 == b1)
          {
            localObject1 = a((QSecDatabaseMgr.LibEntry)localObject2);
            e((QSecLibMgr.LoadedLibInfo)localObject1);
            if (((QSecLibMgr.LoadedLibInfo)localObject1).d != 0)
            {
              m = a(((QSecLibMgr.LoadedLibInfo)localObject1).a);
              if (m != -1)
              {
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append(c());
                ((StringBuilder)localObject2).append(File.separator);
                ((StringBuilder)localObject2).append(this.i[this.k[m]]);
                localObject2 = ((StringBuilder)localObject2).toString();
                if ((((QSecLibMgr.LoadedLibInfo)localObject1).h == null) || (!((String)localObject2).equals(((QSecLibMgr.LoadedLibInfo)localObject1).h)))
                {
                  ((QSecLibMgr.LoadedLibInfo)localObject1).h = ((String)localObject2);
                  localObject2 = this.k;
                  ((QSecLibMgr.LoadedLibInfo)localObject1).b = localObject2[(m + 2)];
                  ((QSecLibMgr.LoadedLibInfo)localObject1).c = localObject2[(m + 3)];
                  ((QSecLibMgr.LoadedLibInfo)localObject1).g = this.j[localObject2[m]];
                  ((QSecLibMgr.LoadedLibInfo)localObject1).f = 0;
                  e((QSecLibMgr.LoadedLibInfo)localObject1);
                }
              }
            }
          }
          else if (-1 == b1)
          {
            m = a(((QSecDatabaseMgr.LibEntry)localObject2).a);
            if (m != -1)
            {
              localObject1 = a((QSecDatabaseMgr.LibEntry)localObject2);
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append(c());
              ((StringBuilder)localObject2).append(File.separator);
              ((StringBuilder)localObject2).append(this.i[this.k[m]]);
              ((QSecLibMgr.LoadedLibInfo)localObject1).h = ((StringBuilder)localObject2).toString();
              e((QSecLibMgr.LoadedLibInfo)localObject1);
            }
          }
        }
      }
      if (!localLinkedList.isEmpty()) {
        b(localLinkedList);
      }
      f();
    }
  }
  
  private void h()
  {
    new QSecLibMgr.QSecSFUReader(new QSecLibMgr.SFUVisitor(this, null)).a(1);
  }
  
  private void i()
  {
    int m = 0;
    int n = 0;
    for (;;)
    {
      Object localObject1 = this.k;
      if (m >= localObject1.length) {
        break;
      }
      int i1 = localObject1[(m + 1)];
      if (this.c.a(i1) == null)
      {
        localObject1 = new QSecDatabaseMgr.LibEntry();
        ((QSecDatabaseMgr.LibEntry)localObject1).a = i1;
        Object localObject2 = this.k;
        ((QSecDatabaseMgr.LibEntry)localObject1).b = localObject2[(m + 2)];
        ((QSecDatabaseMgr.LibEntry)localObject1).c = localObject2[(m + 3)];
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(c());
        ((StringBuilder)localObject2).append(File.separator);
        ((StringBuilder)localObject2).append(this.i[this.k[m]]);
        ((QSecDatabaseMgr.LibEntry)localObject1).e = ((StringBuilder)localObject2).toString();
        ((QSecDatabaseMgr.LibEntry)localObject1).d = this.j[this.k[m]];
        if (QLog.isColorLevel()) {
          QLog.d("QQProtect.QSec", 2, String.format("Add buildin: %d,%d,%d,%s", new Object[] { Integer.valueOf(((QSecDatabaseMgr.LibEntry)localObject1).a), Integer.valueOf(((QSecDatabaseMgr.LibEntry)localObject1).b), Integer.valueOf(((QSecDatabaseMgr.LibEntry)localObject1).c), ((QSecDatabaseMgr.LibEntry)localObject1).e }));
        }
        this.c.a((QSecDatabaseMgr.LibEntry)localObject1, false);
        n = 1;
      }
      m += 4;
    }
    if (n != 0) {
      this.c.a();
    }
  }
  
  private void j()
  {
    if (this.f) {
      return;
    }
    this.f = true;
    i();
    h();
    g();
    if (this.g) {
      a();
    }
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3, Object[] paramArrayOfObject1, Object[] paramArrayOfObject2)
  {
    QSecLibMgr.LoadedLibInfo localLoadedLibInfo = (QSecLibMgr.LoadedLibInfo)this.a.get(Integer.valueOf(paramInt1));
    int m = 7;
    if (localLoadedLibInfo == null) {
      if (this.c.a(paramInt1) == null) {
        paramInt2 = 4;
      } else {
        paramInt2 = 17;
      }
    }
    for (;;)
    {
      break;
      if ((paramInt2 != 0) && (paramInt2 != localLoadedLibInfo.f))
      {
        paramInt2 = 32;
      }
      else if (localLoadedLibInfo.a != paramInt1)
      {
        paramInt2 = 5;
      }
      else
      {
        int n = this.d.a(paramInt1);
        if ((1 != n) && ((n != -1) || (a(paramInt1) == -1)))
        {
          paramInt2 = 6;
        }
        else
        {
          if (localLoadedLibInfo.e != 1) {}
          while (!localLoadedLibInfo.i.a())
          {
            paramInt2 = m;
            break;
          }
          paramInt2 = QSecFramework.a(4L, localLoadedLibInfo.a, paramInt2, paramInt3, null, null, paramArrayOfObject1, paramArrayOfObject2);
          localLoadedLibInfo.i.b();
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQProtect.QSec", 2, String.format("dispatch to id: %d, cmd: %d, err: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt3), Integer.valueOf(paramInt2) }));
    }
    return paramInt2;
  }
  
  public void a()
  {
    Handler localHandler = this.e;
    localHandler.sendMessage(localHandler.obtainMessage(1));
  }
  
  public void a(QSecLibMgr.LibEventListener paramLibEventListener)
  {
    this.h.add(paramLibEventListener);
    Handler localHandler = this.e;
    localHandler.sendMessage(localHandler.obtainMessage(5, paramLibEventListener));
  }
  
  public void b()
  {
    if (!this.f)
    {
      Handler localHandler = this.e;
      localHandler.sendMessage(localHandler.obtainMessage(3));
    }
  }
  
  public void b(QSecLibMgr.LibEventListener paramLibEventListener)
  {
    this.h.remove(paramLibEventListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqprotect.qsec.QSecLibMgr
 * JD-Core Version:    0.7.0.1
 */