package com.tencent.mobileqq.troop.utils;

import android.os.Bundle;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.troop.data.TroopFileInfo;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

class TroopFileManager$5$1
  implements Runnable
{
  TroopFileManager$5$1(TroopFileManager.5 param5, Bundle paramBundle, int paramInt1, ByteStringMicro paramByteStringMicro, boolean paramBoolean1, List paramList, boolean paramBoolean2, int paramInt2, int paramInt3) {}
  
  public void run()
  {
    Object localObject7;
    label2333:
    label2654:
    label3062:
    label3071:
    synchronized (this.i.a)
    {
      n = this.a.getInt("reqFor");
      boolean bool = this.a.getBoolean("isFirstPage");
      Object localObject1 = this.a.getString("parentFileId");
      long l = this.a.getLong("uin_filter");
      Object localObject5 = this.i.a.h;
      localObject7 = new StringBuilder();
      ((StringBuilder)localObject7).append((String)localObject1);
      ((StringBuilder)localObject7).append(l);
      TroopFileManager.FileManagerStatus localFileManagerStatus = (TroopFileManager.FileManagerStatus)((Map)localObject5).get(((StringBuilder)localObject7).toString());
      if (localFileManagerStatus == null) {
        return;
      }
      if (n == 1) {
        localObject5 = localObject1;
      }
      for (;;)
      {
        try
        {
          j = this.b;
          if (j == -1000)
          {
            if (this.d) {
              continue;
            }
            if (QLog.isDevelopLevel())
            {
              localObject5 = new StringBuilder();
              ((StringBuilder)localObject5).append("onRspFileListV2 failed, req for:");
              ((StringBuilder)localObject5).append(n);
              QLog.d("TroopFileManager", 4, ((StringBuilder)localObject5).toString());
              continue;
              localFileManagerStatus.e = false;
              this.i.a.a(null, false, (String)localObject1, l);
              continue;
              localFileManagerStatus.j = 0L;
              this.i.a.a(null, false, (String)localObject1, l);
              continue;
              if (localFileManagerStatus.g != null) {
                if ((localFileManagerStatus.g.size() < 15) && (!localFileManagerStatus.c) && (localFileManagerStatus.i <= 3))
                {
                  localFileManagerStatus.i += 1;
                  localFileManagerStatus.e = false;
                  this.i.a.b((String)localObject1, l);
                }
                else
                {
                  localFileManagerStatus.e = false;
                  localFileManagerStatus.i = 0;
                  this.i.a.a(localFileManagerStatus.g, localFileManagerStatus.c, (String)localObject1, l);
                  continue;
                  if (localFileManagerStatus.g != null) {
                    if ((localFileManagerStatus.g.size() < 15) && (!localFileManagerStatus.c) && (localFileManagerStatus.i <= 3))
                    {
                      localFileManagerStatus.i += 1;
                      this.i.a.b((String)localObject1, l);
                    }
                    else
                    {
                      localFileManagerStatus.i = 0;
                      this.i.a.a(localFileManagerStatus.g, localFileManagerStatus.c, (String)localObject1, l);
                    }
                  }
                }
              }
            }
          }
          else
          {
            localObject5 = localObject1;
            localFileManagerStatus.f = this.c;
            localObject5 = localObject1;
            if (this.d)
            {
              localObject5 = localObject1;
              if (this.e != null)
              {
                localObject5 = localObject1;
                localFileManagerStatus.c = this.f;
                localObject5 = localObject1;
                localFileManagerStatus.b = this.g;
                if (!bool) {
                  continue;
                }
                localObject5 = localObject1;
                localFileManagerStatus.a = this.h;
                localObject5 = localObject1;
                localObject7 = this.i.a.c();
                localObject5 = localObject1;
                localFileManagerStatus.g.clear();
                localObject5 = localObject1;
                localFileManagerStatus.h.clear();
                localObject5 = localObject1;
                localObject7 = ((Collection)localObject7).iterator();
                localObject5 = localObject1;
                if (!((Iterator)localObject7).hasNext()) {
                  continue;
                }
                localObject5 = localObject1;
                ??? = (TroopFileInfo)((Iterator)localObject7).next();
                localObject5 = localObject1;
                this.i.a.e.put(((TroopFileInfo)???).b, ???);
                localObject5 = localObject1;
                this.i.a.f.put(((TroopFileInfo)???).c, ???);
                continue;
                localObject5 = localObject1;
                localFileManagerStatus.c = this.f;
                localObject5 = localObject1;
                localObject9 = this.i.a.d.j();
                localObject5 = localObject1;
                localObject10 = this.e.iterator();
                localObject5 = localObject1;
                if (((Iterator)localObject10).hasNext())
                {
                  localObject5 = localObject1;
                  localObject7 = (TroopFileInfo)((Iterator)localObject10).next();
                  localObject5 = localObject1;
                  if (((TroopFileInfo)localObject7).B)
                  {
                    localObject5 = localObject1;
                    if (((TroopFileInfo)localObject7).c == null) {
                      continue;
                    }
                    localObject5 = localObject1;
                    ??? = (TroopFileInfo)this.i.a.f.get(((TroopFileInfo)localObject7).c);
                    if (??? == null)
                    {
                      localObject5 = localObject1;
                      ((TroopFileInfo)localObject7).b = UUID.randomUUID();
                      localObject5 = localObject1;
                      this.i.a.f.put(((TroopFileInfo)localObject7).c, localObject7);
                      localObject5 = localObject1;
                      localObject11 = ((List)localObject9).iterator();
                      ??? = localObject7;
                      localObject5 = localObject1;
                      if (((Iterator)localObject11).hasNext())
                      {
                        localObject5 = localObject1;
                        ??? = (TroopFileStatusInfo)((Iterator)localObject11).next();
                        localObject5 = localObject1;
                        if (!((TroopFileInfo)localObject7).c.equals(((TroopFileStatusInfo)???).x)) {
                          continue;
                        }
                        localObject5 = localObject1;
                        TroopFileInfo localTroopFileInfo = new TroopFileInfo();
                        localObject5 = localObject1;
                        localTroopFileInfo.b = ((TroopFileStatusInfo)???).a;
                        localObject5 = localObject1;
                        localTroopFileInfo.c = ((TroopFileStatusInfo)???).r;
                        localObject5 = localObject1;
                        localTroopFileInfo.o = ((TroopFileStatusInfo)???).x;
                        localObject5 = localObject1;
                        localTroopFileInfo.a((TroopFileStatusInfo)???, this.i.a.c);
                        localObject5 = localObject1;
                        ((TroopFileInfo)localObject7).a(localTroopFileInfo);
                        continue;
                      }
                    }
                    else
                    {
                      localObject5 = localObject1;
                      ((TroopFileInfo)???).b((TroopFileInfo)localObject7);
                    }
                    localObject5 = localObject1;
                    this.i.a.e.put(((TroopFileInfo)???).b, ???);
                    localObject5 = localObject1;
                    if (localFileManagerStatus.h.get(((TroopFileInfo)???).c) == null)
                    {
                      localObject5 = localObject1;
                      localFileManagerStatus.g.add(???);
                      localObject5 = localObject1;
                      localFileManagerStatus.h.put(((TroopFileInfo)???).c, ???);
                    }
                    localObject5 = localObject1;
                    this.i.a.f.put(((TroopFileInfo)???).c, ???);
                    continue;
                  }
                  localObject5 = localObject1;
                  if (QLog.isColorLevel())
                  {
                    localObject5 = localObject1;
                    ??? = new StringBuilder();
                    localObject5 = localObject1;
                    ((StringBuilder)???).append("onRspFileListV2: fileName = ");
                    localObject5 = localObject1;
                    ((StringBuilder)???).append(((TroopFileInfo)localObject7).d);
                    localObject5 = localObject1;
                    ((StringBuilder)???).append(", filePath = ");
                    localObject5 = localObject1;
                    ((StringBuilder)???).append(((TroopFileInfo)localObject7).c);
                    localObject5 = localObject1;
                    ((StringBuilder)???).append(", sha = ");
                    localObject5 = localObject1;
                    ((StringBuilder)???).append(((TroopFileInfo)localObject7).l);
                    localObject5 = localObject1;
                    QLog.e("TroopFileManager", 2, ((StringBuilder)???).toString());
                  }
                  localObject5 = localObject1;
                  ??? = this.i.a.d.a(((TroopFileInfo)localObject7).c);
                  if (??? == null)
                  {
                    localObject5 = localObject1;
                    ((TroopFileInfo)localObject7).b = UUID.randomUUID();
                  }
                }
              }
            }
          }
        }
        finally
        {
          int j;
          Object localObject9;
          Object localObject10;
          Object localObject11;
          int i1;
          int i2;
          int m;
          int k;
          Object localObject6;
          continue;
          if (n == 1) {
            continue;
          }
          if (n == 3) {
            continue;
          }
          continue;
        }
        try
        {
          ((TroopFileInfo)localObject7).r = ((TroopFileInfo)localObject7).h;
          continue;
          ((TroopFileInfo)localObject7).b = ((TroopFileStatusInfo)???).a;
          ((TroopFileInfo)localObject7).a((TroopFileStatusInfo)???, this.i.a.c);
          if (((TroopFileInfo)localObject7).p == 9)
          {
            localObject5 = (TroopFileInfo)this.i.a.f.get(((TroopFileStatusInfo)???).x);
            if (localObject5 != null) {
              ((TroopFileInfo)localObject5).a((TroopFileInfo)localObject7);
            }
          }
          if ((((TroopFileInfo)localObject7).p == 1) || (((TroopFileInfo)localObject7).p == 3) || (((TroopFileInfo)localObject7).p == 2) || (((TroopFileInfo)localObject7).p == 12)) {
            continue;
          }
          localObject5 = (TroopFileInfo)this.i.a.f.get(((TroopFileInfo)localObject7).c);
          if (localObject5 == null) {
            continue;
          }
          ((TroopFileInfo)localObject5).b((TroopFileInfo)localObject7);
          ((TroopFileInfo)localObject5).c(this.i.a.c, this.i.a.b);
          this.i.a.e.put(((TroopFileInfo)localObject5).b, localObject5);
          if (localFileManagerStatus.h.get(((TroopFileInfo)localObject5).c) == null)
          {
            localFileManagerStatus.g.add(localObject5);
            localFileManagerStatus.h.put(((TroopFileInfo)localObject5).c, localObject5);
          }
          this.i.a.f.put(((TroopFileInfo)localObject5).c, localObject5);
        }
        finally
        {
          localObject3 = finally;
          continue;
          if (n == 1) {
            continue;
          }
          if (n == 3) {
            continue;
          }
          continue;
          if (n == 1) {
            continue;
          }
          if (n == 3) {
            continue;
          }
        }
      }
      localObject5 = localObject1;
      if (!"/".equals(localObject5))
      {
        localObject7 = (TroopFileInfo)this.i.a.f.get(localObject5);
        if (localObject7 != null)
        {
          ??? = ((TroopFileInfo)localObject7).D.keySet();
          localObject9 = new ArrayList();
          ??? = ((Set)???).iterator();
          while (((Iterator)???).hasNext()) {
            ((List)localObject9).add((String)((Iterator)???).next());
          }
          i1 = localFileManagerStatus.g.size();
          synchronized (this.i.a.d)
          {
            localObject9 = ((List)localObject9).iterator();
            if (((Iterator)localObject9).hasNext())
            {
              localObject10 = (String)((Iterator)localObject9).next();
              localObject10 = (TroopFileInfo)((TroopFileInfo)localObject7).D.get(localObject10);
              if (localObject10 == null) {
                break label3081;
              }
              if (i1 <= 0) {
                break label3076;
              }
              localObject11 = localFileManagerStatus.g;
              j = i1 - 1;
              if (((List)localObject11).get(j) == null) {
                break label3076;
              }
              i2 = ((TroopFileInfo)localFileManagerStatus.g.get(j)).d();
              if (((TroopFileInfo)localObject10).d() < i2) {
                break label3071;
              }
              m = 0;
              j = 0;
              k = j;
              if (m < i1)
              {
                k = j;
                if (localObject10 == null) {
                  break label3062;
                }
                k = j;
                if (((TroopFileInfo)localObject10).c == null) {
                  break label3062;
                }
                k = j;
                if (localFileManagerStatus.g.get(m) == null) {
                  break label3062;
                }
                k = j;
                if (!((TroopFileInfo)localObject10).c.equals(((TroopFileInfo)localFileManagerStatus.g.get(m)).c)) {
                  break label3062;
                }
                k = 1;
                break label3062;
              }
              j = k;
              if (((TroopFileInfo)localObject10).d() <= i2)
              {
                j = k;
                if (!this.f) {
                  j = 1;
                }
              }
              if (j != 0) {
                break label3081;
              }
              ((TroopFileInfo)localObject7).D.remove(((TroopFileInfo)localObject10).c);
              this.i.a.d.a(((TroopFileInfo)localObject10).b, true);
              break label3081;
            }
            this.i.a.e((TroopFileInfo)localObject7);
          }
        }
      }
      if (!this.d) {
        if (QLog.isDevelopLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("onRspFileListV2 failed, req for:");
          ((StringBuilder)localObject1).append(n);
          QLog.d("TroopFileManager", 4, ((StringBuilder)localObject1).toString());
          break label3084;
          localFileManagerStatus.e = false;
          this.i.a.a(null, false, str, l);
          break label2333;
          localFileManagerStatus.j = 0L;
          this.i.a.a(null, false, str, l);
          break label2333;
          if (localFileManagerStatus.g != null) {
            if ((localFileManagerStatus.g.size() < 15) && (!localFileManagerStatus.c) && (localFileManagerStatus.i <= 3))
            {
              localFileManagerStatus.i += 1;
              localFileManagerStatus.e = false;
              this.i.a.b(str, l);
            }
            else
            {
              localFileManagerStatus.e = false;
              localFileManagerStatus.i = 0;
              this.i.a.a(localFileManagerStatus.g, localFileManagerStatus.c, str, l);
              break label2333;
              if (localFileManagerStatus.g != null) {
                if ((localFileManagerStatus.g.size() < 15) && (!localFileManagerStatus.c) && (localFileManagerStatus.i <= 3))
                {
                  localFileManagerStatus.i += 1;
                  this.i.a.b(str, l);
                }
                else
                {
                  localFileManagerStatus.i = 0;
                  this.i.a.a(localFileManagerStatus.g, localFileManagerStatus.c, str, l);
                }
              }
            }
          }
          return;
          if (this.d) {
            break label3138;
          }
          if (!QLog.isDevelopLevel()) {
            break label3123;
          }
          localObject6 = new StringBuilder();
          ((StringBuilder)localObject6).append("onRspFileListV2 failed, req for:");
          ((StringBuilder)localObject6).append(n);
          QLog.d("TroopFileManager", 4, ((StringBuilder)localObject6).toString());
          break label3123;
          localFileManagerStatus.e = false;
          this.i.a.a(null, false, (String)localObject1, l);
          break label2654;
          localFileManagerStatus.j = 0L;
          this.i.a.a(null, false, (String)localObject1, l);
          break label2654;
          if (localFileManagerStatus.g != null) {
            if ((localFileManagerStatus.g.size() < 15) && (!localFileManagerStatus.c) && (localFileManagerStatus.i <= 3))
            {
              localFileManagerStatus.i += 1;
              localFileManagerStatus.e = false;
              this.i.a.b((String)localObject1, l);
            }
            else
            {
              localFileManagerStatus.e = false;
              localFileManagerStatus.i = 0;
              this.i.a.a(localFileManagerStatus.g, localFileManagerStatus.c, (String)localObject1, l);
              break label2654;
              if (localFileManagerStatus.g != null) {
                if ((localFileManagerStatus.g.size() < 15) && (!localFileManagerStatus.c) && (localFileManagerStatus.i <= 3))
                {
                  localFileManagerStatus.i += 1;
                  this.i.a.b((String)localObject1, l);
                }
                else
                {
                  localFileManagerStatus.i = 0;
                  this.i.a.a(localFileManagerStatus.g, localFileManagerStatus.c, (String)localObject1, l);
                }
              }
            }
          }
          return;
          if (!this.d)
          {
            if (!QLog.isDevelopLevel()) {
              break label3158;
            }
            localObject7 = new StringBuilder();
            ((StringBuilder)localObject7).append("onRspFileListV2 failed, req for:");
            ((StringBuilder)localObject7).append(n);
            QLog.d("TroopFileManager", 4, ((StringBuilder)localObject7).toString());
            break label3158;
            localFileManagerStatus.e = false;
            this.i.a.a(null, false, (String)localObject6, l);
            break label2987;
            localFileManagerStatus.j = 0L;
            this.i.a.a(null, false, (String)localObject6, l);
          }
          else if (n != 1)
          {
            if ((n == 3) && (localFileManagerStatus.g != null)) {
              if ((localFileManagerStatus.g.size() < 15) && (!localFileManagerStatus.c) && (localFileManagerStatus.i <= 3))
              {
                localFileManagerStatus.i += 1;
                localFileManagerStatus.e = false;
                this.i.a.b((String)localObject6, l);
              }
              else
              {
                localFileManagerStatus.e = false;
                localFileManagerStatus.i = 0;
                this.i.a.a(localFileManagerStatus.g, localFileManagerStatus.c, (String)localObject6, l);
              }
            }
          }
          else if (localFileManagerStatus.g != null)
          {
            if ((localFileManagerStatus.g.size() < 15) && (!localFileManagerStatus.c) && (localFileManagerStatus.i <= 3))
            {
              localFileManagerStatus.i += 1;
              this.i.a.b((String)localObject6, l);
            }
            else
            {
              localFileManagerStatus.i = 0;
              this.i.a.a(localFileManagerStatus.g, localFileManagerStatus.c, (String)localObject6, l);
            }
          }
          throw ((Throwable)localObject1);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopFileManager.5.1
 * JD-Core Version:    0.7.0.1
 */