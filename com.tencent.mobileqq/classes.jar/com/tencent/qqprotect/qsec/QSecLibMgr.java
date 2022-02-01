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
  private Handler jdField_a_of_type_AndroidOsHandler;
  private QSecCbMgr jdField_a_of_type_ComTencentQqprotectQsecQSecCbMgr;
  private QSecDatabaseMgr jdField_a_of_type_ComTencentQqprotectQsecQSecDatabaseMgr;
  private List<QSecLibMgr.LoadedLibInfo> jdField_a_of_type_JavaUtilList;
  private ConcurrentHashMap<Integer, QSecLibMgr.LoadedLibInfo> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private CopyOnWriteArrayList<QSecLibMgr.LibEventListener> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  private boolean jdField_a_of_type_Boolean = false;
  private final int[] jdField_a_of_type_ArrayOfInt = { 0, 1, 2, 2 };
  private final String[] jdField_a_of_type_ArrayOfJavaLangString = { "libhobi.so" };
  private boolean jdField_b_of_type_Boolean = false;
  private final String[] jdField_b_of_type_ArrayOfJavaLangString = { "2.1.3" };
  
  public QSecLibMgr(QSecCbMgr paramQSecCbMgr)
  {
    this.jdField_a_of_type_ComTencentQqprotectQsecQSecCbMgr = paramQSecCbMgr;
    this.jdField_a_of_type_JavaUtilList = new LinkedList();
    this.jdField_a_of_type_ComTencentQqprotectQsecQSecDatabaseMgr = new QSecDatabaseMgr();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_AndroidOsHandler = new QSecLibMgr.QSecHandler(this, ThreadManager.getFileThreadLooper());
    this.jdField_a_of_type_ComTencentQqprotectQsecQSecCbMgr.a(new QSecLibMgr.1(this));
  }
  
  private int a(int paramInt)
  {
    int i = 0;
    for (;;)
    {
      int[] arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
      if (i >= arrayOfInt.length) {
        break;
      }
      if (paramInt == arrayOfInt[(i + 1)]) {
        return i / 4;
      }
      i += 4;
    }
    return -1;
  }
  
  private QSecLibMgr.LoadedLibInfo a(QSecDatabaseMgr.LibEntry paramLibEntry)
  {
    QSecLibMgr.LoadedLibInfo localLoadedLibInfo = new QSecLibMgr.LoadedLibInfo(null);
    localLoadedLibInfo.jdField_a_of_type_Int = paramLibEntry.jdField_a_of_type_Int;
    localLoadedLibInfo.jdField_b_of_type_Int = paramLibEntry.jdField_b_of_type_Int;
    localLoadedLibInfo.c = paramLibEntry.c;
    localLoadedLibInfo.jdField_b_of_type_JavaLangString = paramLibEntry.jdField_b_of_type_JavaLangString;
    localLoadedLibInfo.jdField_a_of_type_JavaLangString = paramLibEntry.jdField_a_of_type_JavaLangString;
    localLoadedLibInfo.e = 4;
    return localLoadedLibInfo;
  }
  
  private String a()
  {
    return BaseApplication.getContext().getApplicationInfo().nativeLibraryDir;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
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
      QLog.d("QQProtect.QSec", 2, String.format("Prepare to unload: %d,%d,%d,%d,%s,%s", new Object[] { Integer.valueOf(paramLoadedLibInfo.jdField_a_of_type_Int), Integer.valueOf(paramLoadedLibInfo.jdField_b_of_type_Int), Integer.valueOf(paramLoadedLibInfo.c), Integer.valueOf(paramLoadedLibInfo.e), paramLoadedLibInfo.jdField_a_of_type_JavaLangString, paramLoadedLibInfo.jdField_b_of_type_JavaLangString }));
    }
    if ((paramLoadedLibInfo.c & 0x1) == 0) {
      return;
    }
    if (paramLoadedLibInfo.e == 1)
    {
      paramLoadedLibInfo.e = 3;
      paramLoadedLibInfo.jdField_a_of_type_ComTencentQqprotectQsecRundownProtection.b();
      int i = QSecFramework.a(3L, paramLoadedLibInfo.jdField_a_of_type_Int, 0L, 0L, null, null, null, null);
      if (QLog.isColorLevel()) {
        QLog.d("QQProtect.QSec", 2, new Object[] { "Unload ret: %d", Integer.valueOf(i) });
      }
      if (i == 0)
      {
        paramLoadedLibInfo.e = 4;
        a(2, paramLoadedLibInfo.jdField_a_of_type_Int);
        return;
      }
      paramLoadedLibInfo.e = 5;
      paramLoadedLibInfo.d = i;
      return;
    }
  }
  
  private void a(QSecLibMgr.LoadedLibInfo paramLoadedLibInfo, String paramString1, String paramString2)
  {
    a(paramLoadedLibInfo);
    if (paramLoadedLibInfo.e == 4)
    {
      if ((paramLoadedLibInfo.jdField_b_of_type_JavaLangString != null) && (!paramLoadedLibInfo.jdField_b_of_type_JavaLangString.equals(paramString2)))
      {
        FileUtils.delete(paramLoadedLibInfo.jdField_b_of_type_JavaLangString);
        paramLoadedLibInfo.jdField_b_of_type_JavaLangString = paramString2;
      }
      if ((paramLoadedLibInfo.jdField_a_of_type_JavaLangString != null) && (!paramLoadedLibInfo.jdField_a_of_type_JavaLangString.equals(paramString1))) {
        paramLoadedLibInfo.jdField_a_of_type_JavaLangString = paramString1;
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
      if (!this.jdField_a_of_type_Boolean) {
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
        Object localObject2 = (QSecLibMgr.LoadedLibInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(((Pair)localObject1).first);
        if (localObject2 == null)
        {
          localObject2 = this.jdField_a_of_type_ComTencentQqprotectQsecQSecDatabaseMgr.a(((Integer)((Pair)localObject1).first).intValue());
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
              this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Integer.valueOf(((QSecLibMgr.LoadedLibInfo)localObject2).jdField_a_of_type_Int));
            }
            d((QSecLibMgr.LoadedLibInfo)localObject2);
          }
        }
        else if ((((Byte)((Pair)localObject1).second).byteValue() == 2) && (((QSecLibMgr.LoadedLibInfo)localObject2).e == 4))
        {
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(((Pair)localObject1).first);
          localObject1 = this.jdField_a_of_type_ComTencentQqprotectQsecQSecDatabaseMgr.a(((Integer)((Pair)localObject1).first).intValue());
          if (localObject1 != null) {
            localLinkedList.add(localObject1);
          }
        }
      }
      if (!localLinkedList.isEmpty()) {
        b(localLinkedList);
      }
      e();
    }
  }
  
  private void b(QSecLibMgr.LoadedLibInfo paramLoadedLibInfo)
  {
    QSecRptHelper localQSecRptHelper = new QSecRptHelper();
    localQSecRptHelper.a(paramLoadedLibInfo.jdField_a_of_type_Int).a(paramLoadedLibInfo.jdField_a_of_type_JavaLangString).a(paramLoadedLibInfo.d);
    QSecRptController.b(localQSecRptHelper.toString(), 104);
  }
  
  private void b(List<QSecDatabaseMgr.LibEntry> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      QSecDatabaseMgr.LibEntry localLibEntry = (QSecDatabaseMgr.LibEntry)paramList.next();
      this.jdField_a_of_type_ComTencentQqprotectQsecQSecDatabaseMgr.a(localLibEntry.jdField_a_of_type_Int, false);
      if (localLibEntry.jdField_b_of_type_JavaLangString != null)
      {
        int i = a(localLibEntry.jdField_a_of_type_Int);
        if (i != -1)
        {
          Object localObject = new StringBuilder();
          ((StringBuilder)localObject).append(a());
          ((StringBuilder)localObject).append(File.separator);
          ((StringBuilder)localObject).append(this.jdField_a_of_type_ArrayOfJavaLangString[this.jdField_a_of_type_ArrayOfInt[i]]);
          localObject = ((StringBuilder)localObject).toString();
          if (localLibEntry.jdField_b_of_type_JavaLangString.equals(localObject)) {}
        }
        else
        {
          FileUtils.delete(localLibEntry.jdField_b_of_type_JavaLangString);
        }
      }
    }
    this.jdField_a_of_type_ComTencentQqprotectQsecQSecDatabaseMgr.a();
  }
  
  private void c()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = true;
      return;
    }
    this.jdField_b_of_type_Boolean = false;
    new QSecLibMgr.QSecSFUReader(new QSecLibMgr.2(this)).a(1);
  }
  
  private void c(QSecLibMgr.LibEventListener paramLibEventListener)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
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
    int j = paramLoadedLibInfo.jdField_a_of_type_Int;
    String str = paramLoadedLibInfo.jdField_a_of_type_JavaLangString;
    int i = 1;
    new CrashProtector(String.format("Lib%d_%s", new Object[] { Integer.valueOf(j), str }), 43200000L).a((CrashProtector.IProtectedMethod)localObject);
    if (QLog.isColorLevel())
    {
      if (paramLoadedLibInfo.jdField_b_of_type_JavaLangString == null) {
        localObject = "null";
      } else {
        localObject = paramLoadedLibInfo.jdField_b_of_type_JavaLangString;
      }
      QLog.d("QQProtect.QSec", 2, String.format("load: %s ver: %s error: %08X", new Object[] { localObject, QPMiscUtils.a(paramLoadedLibInfo.f), Integer.valueOf(paramLoadedLibInfo.d) }));
    }
    if (paramLoadedLibInfo.d != 0) {
      i = 4;
    }
    paramLoadedLibInfo.e = i;
  }
  
  private void d()
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
      int i;
      label62:
      l1 = 28800000L;
    }
    try
    {
      i = Integer.parseInt(((QQAppInterface)localObject1).getCurrentAccountUin());
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
    i = 0;
    localObject2 = this.jdField_a_of_type_JavaUtilList.iterator();
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
        localObject1 = localLoadedLibInfo.jdField_a_of_type_JavaLangString;
        if (localLoadedLibInfo.f != 0) {
          localObject1 = QPMiscUtils.a(localLoadedLibInfo.f);
        }
        i ^= 0x12345678;
        String str1 = String.format("Lib%d_%d_%s", new Object[] { Integer.valueOf(localLoadedLibInfo.jdField_a_of_type_Int), Integer.valueOf(i), localObject1 });
        String str2 = String.format("Lib%d_%d_%s_lpt", new Object[] { Integer.valueOf(localLoadedLibInfo.jdField_a_of_type_Int), Integer.valueOf(i), localObject1 });
        int j = localSharedPreferences.getInt(str1, -1);
        l2 = localSharedPreferences.getLong(str2, 0L);
        l2 = new Date().getTime() - l2;
        if ((l2 < 28800000L) && (localLoadedLibInfo.d == j))
        {
          if (!QLog.isColorLevel()) {
            break label505;
          }
          QLog.d("QQProtect.QSec", 2, String.format("Ignore rp for: %d,%08X,%s", new Object[] { Integer.valueOf(localLoadedLibInfo.jdField_a_of_type_Int), Integer.valueOf(localLoadedLibInfo.d), localObject1 }));
          break label505;
        }
        if (QLog.isColorLevel()) {
          QLog.d("QQProtect.QSec", 2, String.format("Rp: %d,%d,%s", new Object[] { Integer.valueOf(localLoadedLibInfo.jdField_a_of_type_Int), Integer.valueOf(localLoadedLibInfo.d), localObject1 }));
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
  
  private void d(QSecLibMgr.LoadedLibInfo paramLoadedLibInfo)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramLoadedLibInfo);
  }
  
  private void e()
  {
    Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
    localHandler.sendMessage(localHandler.obtainMessage(4));
  }
  
  private void e(QSecLibMgr.LoadedLibInfo paramLoadedLibInfo)
  {
    c(paramLoadedLibInfo);
    if (paramLoadedLibInfo.d == 0)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramLoadedLibInfo.jdField_a_of_type_Int), paramLoadedLibInfo);
      a(1, paramLoadedLibInfo.jdField_a_of_type_Int);
    }
    d(paramLoadedLibInfo);
  }
  
  private void f()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentQqprotectQsecQSecDatabaseMgr.a();
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
        byte b1 = this.jdField_a_of_type_ComTencentQqprotectQsecQSecCbMgr.a(((QSecDatabaseMgr.LibEntry)localObject2).jdField_a_of_type_Int);
        int i;
        if (QLog.isColorLevel())
        {
          i = ((QSecDatabaseMgr.LibEntry)localObject2).jdField_a_of_type_Int;
          int j = ((QSecDatabaseMgr.LibEntry)localObject2).jdField_b_of_type_Int;
          int k = ((QSecDatabaseMgr.LibEntry)localObject2).c;
          String str = ((QSecDatabaseMgr.LibEntry)localObject2).jdField_a_of_type_JavaLangString;
          if (((QSecDatabaseMgr.LibEntry)localObject2).jdField_b_of_type_JavaLangString == null) {
            localObject1 = "null";
          } else {
            localObject1 = ((QSecDatabaseMgr.LibEntry)localObject2).jdField_b_of_type_JavaLangString;
          }
          QLog.d("QQProtect.QSec", 2, String.format("%d,%d,%d,%s,%s,%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), str, localObject1, Byte.valueOf(b1) }));
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
              i = a(((QSecLibMgr.LoadedLibInfo)localObject1).jdField_a_of_type_Int);
              if (i != -1)
              {
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append(a());
                ((StringBuilder)localObject2).append(File.separator);
                ((StringBuilder)localObject2).append(this.jdField_a_of_type_ArrayOfJavaLangString[this.jdField_a_of_type_ArrayOfInt[i]]);
                localObject2 = ((StringBuilder)localObject2).toString();
                if ((((QSecLibMgr.LoadedLibInfo)localObject1).jdField_b_of_type_JavaLangString == null) || (!((String)localObject2).equals(((QSecLibMgr.LoadedLibInfo)localObject1).jdField_b_of_type_JavaLangString)))
                {
                  ((QSecLibMgr.LoadedLibInfo)localObject1).jdField_b_of_type_JavaLangString = ((String)localObject2);
                  localObject2 = this.jdField_a_of_type_ArrayOfInt;
                  ((QSecLibMgr.LoadedLibInfo)localObject1).jdField_b_of_type_Int = localObject2[(i + 2)];
                  ((QSecLibMgr.LoadedLibInfo)localObject1).c = localObject2[(i + 3)];
                  ((QSecLibMgr.LoadedLibInfo)localObject1).jdField_a_of_type_JavaLangString = this.jdField_b_of_type_ArrayOfJavaLangString[localObject2[i]];
                  ((QSecLibMgr.LoadedLibInfo)localObject1).f = 0;
                  e((QSecLibMgr.LoadedLibInfo)localObject1);
                }
              }
            }
          }
          else if (-1 == b1)
          {
            i = a(((QSecDatabaseMgr.LibEntry)localObject2).jdField_a_of_type_Int);
            if (i != -1)
            {
              localObject1 = a((QSecDatabaseMgr.LibEntry)localObject2);
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append(a());
              ((StringBuilder)localObject2).append(File.separator);
              ((StringBuilder)localObject2).append(this.jdField_a_of_type_ArrayOfJavaLangString[this.jdField_a_of_type_ArrayOfInt[i]]);
              ((QSecLibMgr.LoadedLibInfo)localObject1).jdField_b_of_type_JavaLangString = ((StringBuilder)localObject2).toString();
              e((QSecLibMgr.LoadedLibInfo)localObject1);
            }
          }
        }
      }
      if (!localLinkedList.isEmpty()) {
        b(localLinkedList);
      }
      e();
    }
  }
  
  private void g()
  {
    new QSecLibMgr.QSecSFUReader(new QSecLibMgr.SFUVisitor(this, null)).a(1);
  }
  
  private void h()
  {
    int i = 0;
    int j = 0;
    for (;;)
    {
      Object localObject1 = this.jdField_a_of_type_ArrayOfInt;
      if (i >= localObject1.length) {
        break;
      }
      int k = localObject1[(i + 1)];
      if (this.jdField_a_of_type_ComTencentQqprotectQsecQSecDatabaseMgr.a(k) == null)
      {
        localObject1 = new QSecDatabaseMgr.LibEntry();
        ((QSecDatabaseMgr.LibEntry)localObject1).jdField_a_of_type_Int = k;
        Object localObject2 = this.jdField_a_of_type_ArrayOfInt;
        ((QSecDatabaseMgr.LibEntry)localObject1).jdField_b_of_type_Int = localObject2[(i + 2)];
        ((QSecDatabaseMgr.LibEntry)localObject1).c = localObject2[(i + 3)];
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(a());
        ((StringBuilder)localObject2).append(File.separator);
        ((StringBuilder)localObject2).append(this.jdField_a_of_type_ArrayOfJavaLangString[this.jdField_a_of_type_ArrayOfInt[i]]);
        ((QSecDatabaseMgr.LibEntry)localObject1).jdField_b_of_type_JavaLangString = ((StringBuilder)localObject2).toString();
        ((QSecDatabaseMgr.LibEntry)localObject1).jdField_a_of_type_JavaLangString = this.jdField_b_of_type_ArrayOfJavaLangString[this.jdField_a_of_type_ArrayOfInt[i]];
        if (QLog.isColorLevel()) {
          QLog.d("QQProtect.QSec", 2, String.format("Add buildin: %d,%d,%d,%s", new Object[] { Integer.valueOf(((QSecDatabaseMgr.LibEntry)localObject1).jdField_a_of_type_Int), Integer.valueOf(((QSecDatabaseMgr.LibEntry)localObject1).jdField_b_of_type_Int), Integer.valueOf(((QSecDatabaseMgr.LibEntry)localObject1).c), ((QSecDatabaseMgr.LibEntry)localObject1).jdField_b_of_type_JavaLangString }));
        }
        this.jdField_a_of_type_ComTencentQqprotectQsecQSecDatabaseMgr.a((QSecDatabaseMgr.LibEntry)localObject1, false);
        j = 1;
      }
      i += 4;
    }
    if (j != 0) {
      this.jdField_a_of_type_ComTencentQqprotectQsecQSecDatabaseMgr.a();
    }
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    h();
    g();
    f();
    if (this.jdField_b_of_type_Boolean) {
      a();
    }
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3, Object[] paramArrayOfObject1, Object[] paramArrayOfObject2)
  {
    QSecLibMgr.LoadedLibInfo localLoadedLibInfo = (QSecLibMgr.LoadedLibInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt1));
    int i = 7;
    if (localLoadedLibInfo == null) {
      if (this.jdField_a_of_type_ComTencentQqprotectQsecQSecDatabaseMgr.a(paramInt1) == null) {
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
      else if (localLoadedLibInfo.jdField_a_of_type_Int != paramInt1)
      {
        paramInt2 = 5;
      }
      else
      {
        int j = this.jdField_a_of_type_ComTencentQqprotectQsecQSecCbMgr.a(paramInt1);
        if ((1 != j) && ((j != -1) || (a(paramInt1) == -1)))
        {
          paramInt2 = 6;
        }
        else
        {
          if (localLoadedLibInfo.e != 1) {}
          while (!localLoadedLibInfo.jdField_a_of_type_ComTencentQqprotectQsecRundownProtection.a())
          {
            paramInt2 = i;
            break;
          }
          paramInt2 = QSecFramework.a(4L, localLoadedLibInfo.jdField_a_of_type_Int, paramInt2, paramInt3, null, null, paramArrayOfObject1, paramArrayOfObject2);
          localLoadedLibInfo.jdField_a_of_type_ComTencentQqprotectQsecRundownProtection.a();
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
    Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
    localHandler.sendMessage(localHandler.obtainMessage(1));
  }
  
  public void a(QSecLibMgr.LibEventListener paramLibEventListener)
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(paramLibEventListener);
    Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
    localHandler.sendMessage(localHandler.obtainMessage(5, paramLibEventListener));
  }
  
  public void b()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
      localHandler.sendMessage(localHandler.obtainMessage(3));
    }
  }
  
  public void b(QSecLibMgr.LibEventListener paramLibEventListener)
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(paramLibEventListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqprotect.qsec.QSecLibMgr
 * JD-Core Version:    0.7.0.1
 */