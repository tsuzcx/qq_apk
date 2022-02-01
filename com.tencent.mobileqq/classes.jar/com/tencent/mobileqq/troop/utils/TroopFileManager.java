package com.tencent.mobileqq.troop.utils;

import android.database.Observable;
import android.os.Handler;
import android.os.Message;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import com.tencent.biz.troop.file.TroopFileProtocol;
import com.tencent.biz.troop.file.protocol.TroopFileDeleteFileObserver;
import com.tencent.biz.troop.file.protocol.TroopFileGetFileListObserver;
import com.tencent.biz.troop.file.protocol.TroopFileReqTransFileObserver;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.troop.data.TroopFileInfo;
import com.tencent.mobileqq.troop.data.TroopFileObserver;
import com.tencent.mobileqq.troop.data.TroopFileSearchByTypeItemData;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.filemanager.TroopFileTransferUtil;
import com.tencent.mobileqq.troop.filemanager.TroopFileTransferUtil.Log;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import mqq.app.MobileQQ;

public class TroopFileManager
  extends Observable<TroopFileObserver>
{
  public static Map<Long, TroopFileManager> a = new HashMap();
  public long b;
  public QQAppInterface c;
  public TroopFileTransferManager d;
  public Map<UUID, TroopFileInfo> e = new HashMap();
  public Map<String, TroopFileInfo> f = new HashMap();
  public ArrayMap<Integer, List<TroopFileSearchByTypeItemData>> g = new ArrayMap();
  public Map<String, TroopFileManager.FileManagerStatus> h = new HashMap();
  public int i;
  public Handler j;
  public int k;
  public String l = "";
  public TroopFileManager.Filter m = new TroopFileManager.NormalFileFilter();
  public TroopFileManager.Filter n = new TroopFileManager.UploadingFileFilter();
  public BizTroopObserver o = new TroopFileManager.2(this);
  private TroopFileDeleteFileObserver q = new TroopFileManager.3(this);
  private TroopFileReqTransFileObserver r = new TroopFileManager.4(this);
  private TroopFileGetFileListObserver s = new TroopFileManager.5(this);
  
  public TroopFileManager(QQAppInterface paramQQAppInterface, long paramLong)
  {
    this.b = paramLong;
    this.c = paramQQAppInterface;
    this.d = TroopFileTransferManager.a(paramQQAppInterface, paramLong);
    Iterator localIterator = this.d.l().iterator();
    while (localIterator.hasNext())
    {
      TroopFileStatusInfo localTroopFileStatusInfo = (TroopFileStatusInfo)localIterator.next();
      TroopFileInfo localTroopFileInfo = new TroopFileInfo();
      localTroopFileInfo.b = localTroopFileStatusInfo.a;
      localTroopFileInfo.a(localTroopFileStatusInfo, this.c);
      this.e.put(localTroopFileInfo.b, localTroopFileInfo);
      if ((localTroopFileInfo.c != null) && (!"/".equals(localTroopFileInfo.c))) {
        this.f.put(localTroopFileInfo.c, localTroopFileInfo);
      }
    }
    this.j = new TroopFileManager.1(this, paramQQAppInterface.getApplication().getMainLooper());
    paramQQAppInterface.addObserver(this.o);
  }
  
  public static TroopFileManager a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    try
    {
      TroopFileManager localTroopFileManager2 = (TroopFileManager)a.get(Long.valueOf(paramLong));
      TroopFileManager localTroopFileManager1;
      if (localTroopFileManager2 != null)
      {
        localTroopFileManager1 = localTroopFileManager2;
        if (localTroopFileManager2.c == paramQQAppInterface) {}
      }
      else
      {
        localTroopFileManager1 = new TroopFileManager(paramQQAppInterface, paramLong);
        a.put(Long.valueOf(paramLong), localTroopFileManager1);
      }
      return localTroopFileManager1;
    }
    finally {}
  }
  
  public static List<TroopFileInfo> a(Collection<TroopFileInfo> paramCollection, TroopFileManager.Filter paramFilter)
  {
    ArrayList localArrayList = new ArrayList();
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      TroopFileInfo localTroopFileInfo = (TroopFileInfo)paramCollection.next();
      if (paramFilter.a(localTroopFileInfo)) {
        localArrayList.add(localTroopFileInfo);
      }
    }
    return localArrayList;
  }
  
  public static void a()
  {
    
    try
    {
      Iterator localIterator = a.values().iterator();
      while (localIterator.hasNext()) {
        ((TroopFileManager)localIterator.next()).e();
      }
      a.clear();
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  private void e()
  {
    try
    {
      this.c.removeObserver(this.o);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public TroopFileInfo a(String paramString)
  {
    try
    {
      if (this.f != null)
      {
        paramString = (TroopFileInfo)this.f.get(paramString);
        return paramString;
      }
      return null;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public TroopFileInfo a(String paramString, long paramLong, int paramInt)
  {
    try
    {
      TroopFileInfo localTroopFileInfo = new TroopFileInfo();
      localTroopFileInfo.b = UUID.randomUUID();
      localTroopFileInfo.d = paramString;
      localTroopFileInfo.e = paramLong;
      localTroopFileInfo.f = paramInt;
      localTroopFileInfo.a((int)NetConnInfoCenter.getServerTime());
      this.e.put(localTroopFileInfo.b, localTroopFileInfo);
      return localTroopFileInfo;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public TroopFileInfo a(String paramString1, String paramString2, long paramLong, int paramInt)
  {
    if (paramString1 == null) {
      return null;
    }
    for (;;)
    {
      try
      {
        Object localObject2 = TroopFileTransferUtil.e(paramString1);
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (((String)localObject2).length() != 0)
          {
            localObject2 = (TroopFileInfo)this.f.get(paramString1);
            if (localObject2 != null)
            {
              this.e.put(((TroopFileInfo)localObject2).b, localObject2);
              return localObject2;
            }
            localObject1 = (TroopFileInfo)this.f.get(localObject1);
            if (localObject1 != null)
            {
              this.e.put(((TroopFileInfo)localObject1).b, localObject1);
              return localObject1;
            }
            if (paramInt == 0) {
              return null;
            }
            localObject1 = new TroopFileInfo();
            localObject2 = this.d.a(paramString1);
            if (localObject2 != null) {
              ((TroopFileInfo)localObject1).b = ((TroopFileStatusInfo)localObject2).a;
            }
            if (((TroopFileInfo)localObject1).b == null) {
              ((TroopFileInfo)localObject1).b = UUID.nameUUIDFromBytes(paramString1.getBytes());
            }
            ((TroopFileInfo)localObject1).c = paramString1;
            ((TroopFileInfo)localObject1).d = paramString2;
            ((TroopFileInfo)localObject1).e = paramLong;
            ((TroopFileInfo)localObject1).f = paramInt;
            if (TextUtils.isEmpty(this.l)) {
              paramString2 = "/";
            } else {
              paramString2 = this.l;
            }
            ((TroopFileInfo)localObject1).o = paramString2;
            this.e.put(((TroopFileInfo)localObject1).b, localObject1);
            this.f.put(paramString1, localObject1);
            return localObject1;
          }
        }
      }
      finally {}
      Object localObject1 = "0";
    }
  }
  
  public TroopFileInfo a(UUID paramUUID)
  {
    try
    {
      paramUUID = (TroopFileInfo)this.e.get(paramUUID);
      return paramUUID;
    }
    finally
    {
      paramUUID = finally;
      throw paramUUID;
    }
  }
  
  public void a(int paramInt)
  {
    Iterator localIterator = this.mObservers.iterator();
    while (localIterator.hasNext()) {
      ((TroopFileObserver)localIterator.next()).a(paramInt);
    }
  }
  
  public final void a(TroopFileInfo paramTroopFileInfo)
  {
    if (paramTroopFileInfo != null) {}
    for (;;)
    {
      try
      {
        int i1 = TroopFileTransferUtil.Log.b;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[");
        if (paramTroopFileInfo.b == null) {
          break label118;
        }
        str = paramTroopFileInfo.b.toString();
        localStringBuilder.append(str);
        localStringBuilder.append("] doDelete2");
        TroopFileTransferUtil.Log.c("TroopFileManager", i1, localStringBuilder.toString());
        this.f.remove(paramTroopFileInfo.c);
        this.e.remove(paramTroopFileInfo.b);
        d(paramTroopFileInfo);
      }
      finally {}
      return;
      label118:
      String str = "null";
    }
  }
  
  public void a(TroopFileInfo paramTroopFileInfo, int paramInt)
  {
    TroopFileError.a(this.c, this.b, paramTroopFileInfo.d, paramTroopFileInfo.p, paramInt);
  }
  
  public final void a(TroopFileInfo paramTroopFileInfo, int paramInt1, int paramInt2)
  {
    if (paramTroopFileInfo != null) {
      try
      {
        if (paramTroopFileInfo.b != null)
        {
          int i1 = TroopFileTransferUtil.Log.b;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("[");
          localStringBuilder.append(paramTroopFileInfo.b.toString());
          localStringBuilder.append("] delete. mFileId:");
          localStringBuilder.append(paramTroopFileInfo.c);
          localStringBuilder.append(" mParentId:");
          localStringBuilder.append(paramTroopFileInfo.o);
          localStringBuilder.append(" uint32_bus_id:");
          localStringBuilder.append(paramTroopFileInfo.f);
          TroopFileTransferUtil.Log.c("TroopFileManager", i1, localStringBuilder.toString());
          if ((paramTroopFileInfo.c != null) && (paramTroopFileInfo.o != null) && (!"".equals(paramTroopFileInfo.c)) && (!"".equals(paramTroopFileInfo.o)))
          {
            i1 = paramTroopFileInfo.f;
            if (i1 == 0) {
              return;
            }
            TroopFileProtocol.a(this.c, this.b, paramTroopFileInfo.f, paramTroopFileInfo.c, paramTroopFileInfo.o, paramInt1, paramInt2, this.q);
            return;
          }
          c(paramTroopFileInfo.b);
          return;
        }
      }
      finally {}
    }
  }
  
  public void a(TroopFileInfo paramTroopFileInfo, String paramString)
  {
    Iterator localIterator = this.mObservers.iterator();
    while (localIterator.hasNext()) {
      ((TroopFileObserver)localIterator.next()).a(paramTroopFileInfo, paramString);
    }
  }
  
  public void a(String paramString, TroopFileInfo paramTroopFileInfo)
  {
    try
    {
      this.f.put(paramString, paramTroopFileInfo);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void a(Collection<TroopFileInfo> paramCollection, boolean paramBoolean, String paramString, long paramLong)
  {
    this.j.obtainMessage(1, new Object[] { paramCollection, Boolean.valueOf(paramBoolean), paramString, Long.valueOf(paramLong) }).sendToTarget();
  }
  
  public void a(List<TroopFileInfo> paramList, boolean paramBoolean, String paramString, long paramLong)
  {
    Iterator localIterator = this.mObservers.iterator();
    while (localIterator.hasNext()) {
      ((TroopFileObserver)localIterator.next()).a(paramList, paramBoolean, paramString, paramLong);
    }
  }
  
  public final boolean a(int paramInt, String paramString, long paramLong)
  {
    try
    {
      Object localObject1 = this.h;
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append(paramLong);
      localObject2 = (TroopFileManager.FileManagerStatus)((Map)localObject1).get(((StringBuilder)localObject2).toString());
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new TroopFileManager.FileManagerStatus(this, paramLong);
        localObject2 = this.h;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append(paramLong);
        ((Map)localObject2).put(localStringBuilder.toString(), localObject1);
      }
      long l1 = System.currentTimeMillis();
      long l2 = ((TroopFileManager.FileManagerStatus)localObject1).j;
      l1 -= l2;
      if ((0L < l1) && (l1 < paramInt * 1000L)) {
        return false;
      }
      ((TroopFileManager.FileManagerStatus)localObject1).j = System.currentTimeMillis();
      TroopFileProtocol.a(this.c, this.b, ((TroopFileManager.FileManagerStatus)localObject1).a, 1, 20, 3, 1, paramString, ((TroopFileManager.FileManagerStatus)localObject1).d, paramLong, 0, ((TroopFileManager.FileManagerStatus)localObject1).f, this.s);
      return true;
    }
    finally {}
  }
  
  public boolean a(TroopFileObserver paramTroopFileObserver)
  {
    return this.mObservers.contains(paramTroopFileObserver);
  }
  
  public final boolean a(String paramString, long paramLong)
  {
    try
    {
      Object localObject = this.h;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(paramLong);
      localObject = (TroopFileManager.FileManagerStatus)((Map)localObject).get(localStringBuilder.toString());
      paramString = (String)localObject;
      if (localObject == null) {
        paramString = new TroopFileManager.FileManagerStatus(this, paramLong);
      }
      boolean bool = paramString.c;
      return bool;
    }
    finally {}
  }
  
  public int b()
  {
    return this.k;
  }
  
  public TroopFileInfo b(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      TroopFileInfo localTroopFileInfo = new TroopFileInfo();
      localTroopFileInfo.b = UUID.randomUUID();
      localTroopFileInfo.t = paramString;
      paramString = new File(paramString);
      localTroopFileInfo.e = paramString.length();
      localTroopFileInfo.d = paramString.getName();
      if (TextUtils.isEmpty(this.l)) {
        paramString = "/";
      } else {
        paramString = this.l;
      }
      localTroopFileInfo.o = paramString;
      this.e.put(localTroopFileInfo.b, localTroopFileInfo);
      return localTroopFileInfo;
    }
    finally {}
  }
  
  public TroopFileInfo b(String paramString1, String paramString2, long paramLong, int paramInt)
  {
    try
    {
      TroopFileInfo localTroopFileInfo = new TroopFileInfo();
      localTroopFileInfo.b = UUID.nameUUIDFromBytes(paramString1.getBytes());
      localTroopFileInfo.c = paramString1;
      localTroopFileInfo.d = paramString2;
      localTroopFileInfo.e = paramLong;
      localTroopFileInfo.f = paramInt;
      localTroopFileInfo.o = "/";
      this.e.put(localTroopFileInfo.b, localTroopFileInfo);
      this.f.put(paramString1, localTroopFileInfo);
      return localTroopFileInfo;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public final void b(TroopFileInfo paramTroopFileInfo)
  {
    try
    {
      a(paramTroopFileInfo, 0, 0);
      return;
    }
    finally
    {
      paramTroopFileInfo = finally;
      throw paramTroopFileInfo;
    }
  }
  
  public final void b(UUID paramUUID)
  {
    if (paramUUID == null) {
      return;
    }
    try
    {
      paramUUID = (TroopFileInfo)this.e.get(paramUUID);
      if ((paramUUID != null) && (paramUUID.v))
      {
        paramUUID.v = false;
        e(paramUUID);
      }
      return;
    }
    finally {}
  }
  
  public final boolean b(String paramString, long paramLong)
  {
    try
    {
      Object localObject1 = this.h;
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append(paramLong);
      localObject2 = (TroopFileManager.FileManagerStatus)((Map)localObject1).get(((StringBuilder)localObject2).toString());
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new TroopFileManager.FileManagerStatus(this, paramLong);
        localObject2 = this.h;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append(paramLong);
        ((Map)localObject2).put(localStringBuilder.toString(), localObject1);
      }
      if ((!((TroopFileManager.FileManagerStatus)localObject1).c) && (!((TroopFileManager.FileManagerStatus)localObject1).e))
      {
        TroopFileProtocol.a(this.c, this.b, ((TroopFileManager.FileManagerStatus)localObject1).a, 3, 20, 3, 1, paramString, ((TroopFileManager.FileManagerStatus)localObject1).d, paramLong, ((TroopFileManager.FileManagerStatus)localObject1).b, ((TroopFileManager.FileManagerStatus)localObject1).f, this.s);
        ((TroopFileManager.FileManagerStatus)localObject1).e = true;
        return true;
      }
      return false;
    }
    finally {}
  }
  
  public TroopFileInfo c(String paramString1, String paramString2, long paramLong, int paramInt)
  {
    try
    {
      paramString1 = a(paramString1, paramString2, paramLong, paramInt);
      return paramString1;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public final List<TroopFileInfo> c()
  {
    try
    {
      List localList = a(this.e.values(), this.n);
      return localList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void c(String paramString)
  {
    try
    {
      int i1 = TroopFileTransferUtil.Log.b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doUploadDelete: filePath:");
      localStringBuilder.append(paramString);
      TroopFileTransferUtil.Log.c("TroopFileManager", i1, localStringBuilder.toString());
      paramString = (TroopFileInfo)this.f.remove(paramString);
      if ((!p) && (paramString == null)) {
        throw new AssertionError();
      }
      if (paramString != null)
      {
        this.e.remove(paramString.b);
        d(paramString);
      }
      return;
    }
    finally {}
  }
  
  public final void c(UUID paramUUID)
  {
    for (;;)
    {
      try
      {
        int i1 = TroopFileTransferUtil.Log.b;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[");
        if (paramUUID != null)
        {
          str = paramUUID.toString();
          localStringBuilder.append(str);
          localStringBuilder.append("] doDelete");
          TroopFileTransferUtil.Log.c("TroopFileManager", i1, localStringBuilder.toString());
          paramUUID = (TroopFileInfo)this.e.remove(paramUUID);
          if (paramUUID == null) {
            return;
          }
          d(paramUUID);
          this.f.remove(paramUUID.c);
          return;
        }
      }
      finally {}
      String str = "null";
    }
  }
  
  public final boolean c(TroopFileInfo paramTroopFileInfo)
  {
    for (;;)
    {
      try
      {
        if ((paramTroopFileInfo.f != 0) && (paramTroopFileInfo.c != null))
        {
          int i1 = TroopFileTransferUtil.Log.b;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("[");
          if (paramTroopFileInfo.b != null)
          {
            str = paramTroopFileInfo.b.toString();
            localStringBuilder.append(str);
            localStringBuilder.append("] transFile. mFileId:");
            localStringBuilder.append(paramTroopFileInfo.c);
            TroopFileTransferUtil.Log.c("TroopFileManager", i1, localStringBuilder.toString());
            TroopFileProtocol.a(this.c, this.b, paramTroopFileInfo, this.r);
            this.i += 1;
            return true;
          }
        }
        else
        {
          return false;
        }
      }
      finally {}
      String str = "null";
    }
  }
  
  public final void d()
  {
    try
    {
      Iterator localIterator = this.e.values().iterator();
      while (localIterator.hasNext()) {
        ((TroopFileInfo)localIterator.next()).v = false;
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void d(TroopFileInfo paramTroopFileInfo)
  {
    this.d.h(paramTroopFileInfo.b);
    this.j.obtainMessage(2, new Object[] { paramTroopFileInfo }).sendToTarget();
  }
  
  public final void d(String paramString)
  {
    try
    {
      int i1 = TroopFileTransferUtil.Log.b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doTroopFileDelete: filePath:");
      localStringBuilder.append(paramString);
      TroopFileTransferUtil.Log.c("TroopFileManager", i1, localStringBuilder.toString());
      paramString = (TroopFileInfo)this.f.remove(paramString);
      if ((!p) && (paramString == null)) {
        throw new AssertionError();
      }
      if (paramString != null)
      {
        this.e.remove(paramString.b);
        d(paramString);
      }
      return;
    }
    finally {}
  }
  
  public void e(TroopFileInfo paramTroopFileInfo)
  {
    this.j.obtainMessage(3, new Object[] { paramTroopFileInfo }).sendToTarget();
  }
  
  public void f(TroopFileInfo paramTroopFileInfo)
  {
    this.j.obtainMessage(6, new Object[] { paramTroopFileInfo }).sendToTarget();
  }
  
  public void g(TroopFileInfo paramTroopFileInfo)
  {
    Iterator localIterator = this.mObservers.iterator();
    while (localIterator.hasNext()) {
      ((TroopFileObserver)localIterator.next()).a(paramTroopFileInfo);
    }
  }
  
  public void h(TroopFileInfo paramTroopFileInfo)
  {
    Iterator localIterator = this.mObservers.iterator();
    while (localIterator.hasNext()) {
      ((TroopFileObserver)localIterator.next()).b(paramTroopFileInfo);
    }
  }
  
  public void i(TroopFileInfo paramTroopFileInfo)
  {
    Iterator localIterator = this.mObservers.iterator();
    while (localIterator.hasNext()) {
      ((TroopFileObserver)localIterator.next()).c(paramTroopFileInfo);
    }
  }
  
  public void j(TroopFileInfo paramTroopFileInfo)
  {
    Iterator localIterator = this.mObservers.iterator();
    while (localIterator.hasNext()) {
      ((TroopFileObserver)localIterator.next()).e(paramTroopFileInfo);
    }
  }
  
  public void k(TroopFileInfo paramTroopFileInfo)
  {
    Iterator localIterator = this.mObservers.iterator();
    while (localIterator.hasNext()) {
      ((TroopFileObserver)localIterator.next()).d(paramTroopFileInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopFileManager
 * JD-Core Version:    0.7.0.1
 */