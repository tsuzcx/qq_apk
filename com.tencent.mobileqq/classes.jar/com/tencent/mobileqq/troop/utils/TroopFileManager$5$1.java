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
    synchronized (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager$5.a)
    {
      m = this.jdField_a_of_type_AndroidOsBundle.getInt("reqFor");
      boolean bool = this.jdField_a_of_type_AndroidOsBundle.getBoolean("isFirstPage");
      Object localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("parentFileId");
      long l = this.jdField_a_of_type_AndroidOsBundle.getLong("uin_filter");
      Object localObject5 = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager$5.a.d;
      localObject7 = new StringBuilder();
      ((StringBuilder)localObject7).append((String)localObject1);
      ((StringBuilder)localObject7).append(l);
      TroopFileManager.FileManagerStatus localFileManagerStatus = (TroopFileManager.FileManagerStatus)((Map)localObject5).get(((StringBuilder)localObject7).toString());
      if (localFileManagerStatus == null) {
        return;
      }
      if (m == 1) {
        localObject5 = localObject1;
      }
      for (;;)
      {
        try
        {
          i = this.jdField_a_of_type_Int;
          if (i == -1000)
          {
            if (this.jdField_a_of_type_Boolean) {
              continue;
            }
            if (QLog.isDevelopLevel())
            {
              localObject5 = new StringBuilder();
              ((StringBuilder)localObject5).append("onRspFileListV2 failed, req for:");
              ((StringBuilder)localObject5).append(m);
              QLog.d("TroopFileManager", 4, ((StringBuilder)localObject5).toString());
              continue;
              localFileManagerStatus.jdField_b_of_type_Boolean = false;
              this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager$5.a.a(null, false, (String)localObject1, l);
              continue;
              localFileManagerStatus.jdField_a_of_type_Long = 0L;
              this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager$5.a.a(null, false, (String)localObject1, l);
              continue;
              if (localFileManagerStatus.jdField_a_of_type_JavaUtilList != null) {
                if ((localFileManagerStatus.jdField_a_of_type_JavaUtilList.size() < 15) && (!localFileManagerStatus.jdField_a_of_type_Boolean) && (localFileManagerStatus.d <= 3))
                {
                  localFileManagerStatus.d += 1;
                  localFileManagerStatus.jdField_b_of_type_Boolean = false;
                  this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager$5.a.b((String)localObject1, l);
                }
                else
                {
                  localFileManagerStatus.jdField_b_of_type_Boolean = false;
                  localFileManagerStatus.d = 0;
                  this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager$5.a.a(localFileManagerStatus.jdField_a_of_type_JavaUtilList, localFileManagerStatus.jdField_a_of_type_Boolean, (String)localObject1, l);
                  continue;
                  if (localFileManagerStatus.jdField_a_of_type_JavaUtilList != null) {
                    if ((localFileManagerStatus.jdField_a_of_type_JavaUtilList.size() < 15) && (!localFileManagerStatus.jdField_a_of_type_Boolean) && (localFileManagerStatus.d <= 3))
                    {
                      localFileManagerStatus.d += 1;
                      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager$5.a.b((String)localObject1, l);
                    }
                    else
                    {
                      localFileManagerStatus.d = 0;
                      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager$5.a.a(localFileManagerStatus.jdField_a_of_type_JavaUtilList, localFileManagerStatus.jdField_a_of_type_Boolean, (String)localObject1, l);
                    }
                  }
                }
              }
            }
          }
          else
          {
            localObject5 = localObject1;
            localFileManagerStatus.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro = this.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro;
            localObject5 = localObject1;
            if (this.jdField_a_of_type_Boolean)
            {
              localObject5 = localObject1;
              if (this.jdField_a_of_type_JavaUtilList != null)
              {
                localObject5 = localObject1;
                localFileManagerStatus.jdField_a_of_type_Boolean = this.jdField_b_of_type_Boolean;
                localObject5 = localObject1;
                localFileManagerStatus.jdField_b_of_type_Int = this.jdField_b_of_type_Int;
                if (!bool) {
                  continue;
                }
                localObject5 = localObject1;
                localFileManagerStatus.jdField_a_of_type_Int = this.c;
                localObject5 = localObject1;
                localObject7 = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager$5.a.a();
                localObject5 = localObject1;
                localFileManagerStatus.jdField_a_of_type_JavaUtilList.clear();
                localObject5 = localObject1;
                localFileManagerStatus.jdField_a_of_type_JavaUtilMap.clear();
                localObject5 = localObject1;
                localObject7 = ((Collection)localObject7).iterator();
                localObject5 = localObject1;
                if (!((Iterator)localObject7).hasNext()) {
                  continue;
                }
                localObject5 = localObject1;
                ??? = (TroopFileInfo)((Iterator)localObject7).next();
                localObject5 = localObject1;
                this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager$5.a.b.put(((TroopFileInfo)???).jdField_a_of_type_JavaUtilUUID, ???);
                localObject5 = localObject1;
                this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager$5.a.c.put(((TroopFileInfo)???).b, ???);
                continue;
                localObject5 = localObject1;
                localFileManagerStatus.jdField_a_of_type_Boolean = this.jdField_b_of_type_Boolean;
                localObject5 = localObject1;
                localObject9 = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager$5.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager.a();
                localObject5 = localObject1;
                localObject10 = this.jdField_a_of_type_JavaUtilList.iterator();
                localObject5 = localObject1;
                if (((Iterator)localObject10).hasNext())
                {
                  localObject5 = localObject1;
                  localObject7 = (TroopFileInfo)((Iterator)localObject10).next();
                  localObject5 = localObject1;
                  if (((TroopFileInfo)localObject7).jdField_d_of_type_Boolean)
                  {
                    localObject5 = localObject1;
                    if (((TroopFileInfo)localObject7).b == null) {
                      continue;
                    }
                    localObject5 = localObject1;
                    ??? = (TroopFileInfo)this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager$5.a.c.get(((TroopFileInfo)localObject7).b);
                    if (??? == null)
                    {
                      localObject5 = localObject1;
                      ((TroopFileInfo)localObject7).jdField_a_of_type_JavaUtilUUID = UUID.randomUUID();
                      localObject5 = localObject1;
                      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager$5.a.c.put(((TroopFileInfo)localObject7).b, localObject7);
                      localObject5 = localObject1;
                      localObject11 = ((List)localObject9).iterator();
                      ??? = localObject7;
                      localObject5 = localObject1;
                      if (((Iterator)localObject11).hasNext())
                      {
                        localObject5 = localObject1;
                        ??? = (TroopFileStatusInfo)((Iterator)localObject11).next();
                        localObject5 = localObject1;
                        if (!((TroopFileInfo)localObject7).b.equals(((TroopFileStatusInfo)???).i)) {
                          continue;
                        }
                        localObject5 = localObject1;
                        TroopFileInfo localTroopFileInfo = new TroopFileInfo();
                        localObject5 = localObject1;
                        localTroopFileInfo.jdField_a_of_type_JavaUtilUUID = ((TroopFileStatusInfo)???).jdField_a_of_type_JavaUtilUUID;
                        localObject5 = localObject1;
                        localTroopFileInfo.b = ((TroopFileStatusInfo)???).e;
                        localObject5 = localObject1;
                        localTroopFileInfo.g = ((TroopFileStatusInfo)???).i;
                        localObject5 = localObject1;
                        localTroopFileInfo.a((TroopFileStatusInfo)???, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager$5.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
                    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager$5.a.b.put(((TroopFileInfo)???).jdField_a_of_type_JavaUtilUUID, ???);
                    localObject5 = localObject1;
                    if (localFileManagerStatus.jdField_a_of_type_JavaUtilMap.get(((TroopFileInfo)???).b) == null)
                    {
                      localObject5 = localObject1;
                      localFileManagerStatus.jdField_a_of_type_JavaUtilList.add(???);
                      localObject5 = localObject1;
                      localFileManagerStatus.jdField_a_of_type_JavaUtilMap.put(((TroopFileInfo)???).b, ???);
                    }
                    localObject5 = localObject1;
                    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager$5.a.c.put(((TroopFileInfo)???).b, ???);
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
                    ((StringBuilder)???).append(((TroopFileInfo)localObject7).jdField_c_of_type_JavaLangString);
                    localObject5 = localObject1;
                    ((StringBuilder)???).append(", filePath = ");
                    localObject5 = localObject1;
                    ((StringBuilder)???).append(((TroopFileInfo)localObject7).b);
                    localObject5 = localObject1;
                    ((StringBuilder)???).append(", sha = ");
                    localObject5 = localObject1;
                    ((StringBuilder)???).append(((TroopFileInfo)localObject7).jdField_d_of_type_JavaLangString);
                    localObject5 = localObject1;
                    QLog.e("TroopFileManager", 2, ((StringBuilder)???).toString());
                  }
                  localObject5 = localObject1;
                  ??? = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager$5.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager.a(((TroopFileInfo)localObject7).b);
                  if (??? == null)
                  {
                    localObject5 = localObject1;
                    ((TroopFileInfo)localObject7).jdField_a_of_type_JavaUtilUUID = UUID.randomUUID();
                  }
                }
              }
            }
          }
        }
        finally
        {
          int i;
          Object localObject9;
          Object localObject10;
          Object localObject11;
          int n;
          int i1;
          int k;
          int j;
          Object localObject6;
          continue;
          if (m == 1) {
            continue;
          }
          if (m == 3) {
            continue;
          }
          continue;
        }
        try
        {
          ((TroopFileInfo)localObject7).jdField_d_of_type_Long = ((TroopFileInfo)localObject7).jdField_c_of_type_Long;
          continue;
          ((TroopFileInfo)localObject7).jdField_a_of_type_JavaUtilUUID = ((TroopFileStatusInfo)???).jdField_a_of_type_JavaUtilUUID;
          ((TroopFileInfo)localObject7).a((TroopFileStatusInfo)???, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager$5.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          if (((TroopFileInfo)localObject7).e == 9)
          {
            localObject5 = (TroopFileInfo)this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager$5.a.c.get(((TroopFileStatusInfo)???).i);
            if (localObject5 != null) {
              ((TroopFileInfo)localObject5).a((TroopFileInfo)localObject7);
            }
          }
          if ((((TroopFileInfo)localObject7).e == 1) || (((TroopFileInfo)localObject7).e == 3) || (((TroopFileInfo)localObject7).e == 2) || (((TroopFileInfo)localObject7).e == 12)) {
            continue;
          }
          localObject5 = (TroopFileInfo)this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager$5.a.c.get(((TroopFileInfo)localObject7).b);
          if (localObject5 == null) {
            continue;
          }
          ((TroopFileInfo)localObject5).b((TroopFileInfo)localObject7);
          ((TroopFileInfo)localObject5).a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager$5.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager$5.a.jdField_a_of_type_Long);
          this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager$5.a.b.put(((TroopFileInfo)localObject5).jdField_a_of_type_JavaUtilUUID, localObject5);
          if (localFileManagerStatus.jdField_a_of_type_JavaUtilMap.get(((TroopFileInfo)localObject5).b) == null)
          {
            localFileManagerStatus.jdField_a_of_type_JavaUtilList.add(localObject5);
            localFileManagerStatus.jdField_a_of_type_JavaUtilMap.put(((TroopFileInfo)localObject5).b, localObject5);
          }
          this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager$5.a.c.put(((TroopFileInfo)localObject5).b, localObject5);
        }
        finally
        {
          localObject3 = finally;
          continue;
          if (m == 1) {
            continue;
          }
          if (m == 3) {
            continue;
          }
          continue;
          if (m == 1) {
            continue;
          }
          if (m == 3) {
            continue;
          }
        }
      }
      localObject5 = localObject1;
      if (!"/".equals(localObject5))
      {
        localObject7 = (TroopFileInfo)this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager$5.a.c.get(localObject5);
        if (localObject7 != null)
        {
          ??? = ((TroopFileInfo)localObject7).jdField_a_of_type_JavaUtilMap.keySet();
          localObject9 = new ArrayList();
          ??? = ((Set)???).iterator();
          while (((Iterator)???).hasNext()) {
            ((List)localObject9).add((String)((Iterator)???).next());
          }
          n = localFileManagerStatus.jdField_a_of_type_JavaUtilList.size();
          synchronized (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager$5.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager)
          {
            localObject9 = ((List)localObject9).iterator();
            if (((Iterator)localObject9).hasNext())
            {
              localObject10 = (String)((Iterator)localObject9).next();
              localObject10 = (TroopFileInfo)((TroopFileInfo)localObject7).jdField_a_of_type_JavaUtilMap.get(localObject10);
              if (localObject10 == null) {
                break label3081;
              }
              if (n <= 0) {
                break label3076;
              }
              localObject11 = localFileManagerStatus.jdField_a_of_type_JavaUtilList;
              i = n - 1;
              if (((List)localObject11).get(i) == null) {
                break label3076;
              }
              i1 = ((TroopFileInfo)localFileManagerStatus.jdField_a_of_type_JavaUtilList.get(i)).a();
              if (((TroopFileInfo)localObject10).a() < i1) {
                break label3071;
              }
              k = 0;
              i = 0;
              j = i;
              if (k < n)
              {
                j = i;
                if (localObject10 == null) {
                  break label3062;
                }
                j = i;
                if (((TroopFileInfo)localObject10).b == null) {
                  break label3062;
                }
                j = i;
                if (localFileManagerStatus.jdField_a_of_type_JavaUtilList.get(k) == null) {
                  break label3062;
                }
                j = i;
                if (!((TroopFileInfo)localObject10).b.equals(((TroopFileInfo)localFileManagerStatus.jdField_a_of_type_JavaUtilList.get(k)).b)) {
                  break label3062;
                }
                j = 1;
                break label3062;
              }
              i = j;
              if (((TroopFileInfo)localObject10).a() <= i1)
              {
                i = j;
                if (!this.jdField_b_of_type_Boolean) {
                  i = 1;
                }
              }
              if (i != 0) {
                break label3081;
              }
              ((TroopFileInfo)localObject7).jdField_a_of_type_JavaUtilMap.remove(((TroopFileInfo)localObject10).b);
              this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager$5.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager.a(((TroopFileInfo)localObject10).jdField_a_of_type_JavaUtilUUID, true);
              break label3081;
            }
            this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager$5.a.d((TroopFileInfo)localObject7);
          }
        }
      }
      if (!this.jdField_a_of_type_Boolean) {
        if (QLog.isDevelopLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("onRspFileListV2 failed, req for:");
          ((StringBuilder)localObject1).append(m);
          QLog.d("TroopFileManager", 4, ((StringBuilder)localObject1).toString());
          break label3084;
          localFileManagerStatus.jdField_b_of_type_Boolean = false;
          this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager$5.a.a(null, false, str, l);
          break label2333;
          localFileManagerStatus.jdField_a_of_type_Long = 0L;
          this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager$5.a.a(null, false, str, l);
          break label2333;
          if (localFileManagerStatus.jdField_a_of_type_JavaUtilList != null) {
            if ((localFileManagerStatus.jdField_a_of_type_JavaUtilList.size() < 15) && (!localFileManagerStatus.jdField_a_of_type_Boolean) && (localFileManagerStatus.d <= 3))
            {
              localFileManagerStatus.d += 1;
              localFileManagerStatus.jdField_b_of_type_Boolean = false;
              this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager$5.a.b(str, l);
            }
            else
            {
              localFileManagerStatus.jdField_b_of_type_Boolean = false;
              localFileManagerStatus.d = 0;
              this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager$5.a.a(localFileManagerStatus.jdField_a_of_type_JavaUtilList, localFileManagerStatus.jdField_a_of_type_Boolean, str, l);
              break label2333;
              if (localFileManagerStatus.jdField_a_of_type_JavaUtilList != null) {
                if ((localFileManagerStatus.jdField_a_of_type_JavaUtilList.size() < 15) && (!localFileManagerStatus.jdField_a_of_type_Boolean) && (localFileManagerStatus.d <= 3))
                {
                  localFileManagerStatus.d += 1;
                  this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager$5.a.b(str, l);
                }
                else
                {
                  localFileManagerStatus.d = 0;
                  this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager$5.a.a(localFileManagerStatus.jdField_a_of_type_JavaUtilList, localFileManagerStatus.jdField_a_of_type_Boolean, str, l);
                }
              }
            }
          }
          return;
          if (this.jdField_a_of_type_Boolean) {
            break label3138;
          }
          if (!QLog.isDevelopLevel()) {
            break label3123;
          }
          localObject6 = new StringBuilder();
          ((StringBuilder)localObject6).append("onRspFileListV2 failed, req for:");
          ((StringBuilder)localObject6).append(m);
          QLog.d("TroopFileManager", 4, ((StringBuilder)localObject6).toString());
          break label3123;
          localFileManagerStatus.jdField_b_of_type_Boolean = false;
          this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager$5.a.a(null, false, (String)localObject1, l);
          break label2654;
          localFileManagerStatus.jdField_a_of_type_Long = 0L;
          this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager$5.a.a(null, false, (String)localObject1, l);
          break label2654;
          if (localFileManagerStatus.jdField_a_of_type_JavaUtilList != null) {
            if ((localFileManagerStatus.jdField_a_of_type_JavaUtilList.size() < 15) && (!localFileManagerStatus.jdField_a_of_type_Boolean) && (localFileManagerStatus.d <= 3))
            {
              localFileManagerStatus.d += 1;
              localFileManagerStatus.jdField_b_of_type_Boolean = false;
              this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager$5.a.b((String)localObject1, l);
            }
            else
            {
              localFileManagerStatus.jdField_b_of_type_Boolean = false;
              localFileManagerStatus.d = 0;
              this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager$5.a.a(localFileManagerStatus.jdField_a_of_type_JavaUtilList, localFileManagerStatus.jdField_a_of_type_Boolean, (String)localObject1, l);
              break label2654;
              if (localFileManagerStatus.jdField_a_of_type_JavaUtilList != null) {
                if ((localFileManagerStatus.jdField_a_of_type_JavaUtilList.size() < 15) && (!localFileManagerStatus.jdField_a_of_type_Boolean) && (localFileManagerStatus.d <= 3))
                {
                  localFileManagerStatus.d += 1;
                  this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager$5.a.b((String)localObject1, l);
                }
                else
                {
                  localFileManagerStatus.d = 0;
                  this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager$5.a.a(localFileManagerStatus.jdField_a_of_type_JavaUtilList, localFileManagerStatus.jdField_a_of_type_Boolean, (String)localObject1, l);
                }
              }
            }
          }
          return;
          if (!this.jdField_a_of_type_Boolean)
          {
            if (!QLog.isDevelopLevel()) {
              break label3158;
            }
            localObject7 = new StringBuilder();
            ((StringBuilder)localObject7).append("onRspFileListV2 failed, req for:");
            ((StringBuilder)localObject7).append(m);
            QLog.d("TroopFileManager", 4, ((StringBuilder)localObject7).toString());
            break label3158;
            localFileManagerStatus.jdField_b_of_type_Boolean = false;
            this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager$5.a.a(null, false, (String)localObject6, l);
            break label2987;
            localFileManagerStatus.jdField_a_of_type_Long = 0L;
            this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager$5.a.a(null, false, (String)localObject6, l);
          }
          else if (m != 1)
          {
            if ((m == 3) && (localFileManagerStatus.jdField_a_of_type_JavaUtilList != null)) {
              if ((localFileManagerStatus.jdField_a_of_type_JavaUtilList.size() < 15) && (!localFileManagerStatus.jdField_a_of_type_Boolean) && (localFileManagerStatus.d <= 3))
              {
                localFileManagerStatus.d += 1;
                localFileManagerStatus.jdField_b_of_type_Boolean = false;
                this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager$5.a.b((String)localObject6, l);
              }
              else
              {
                localFileManagerStatus.jdField_b_of_type_Boolean = false;
                localFileManagerStatus.d = 0;
                this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager$5.a.a(localFileManagerStatus.jdField_a_of_type_JavaUtilList, localFileManagerStatus.jdField_a_of_type_Boolean, (String)localObject6, l);
              }
            }
          }
          else if (localFileManagerStatus.jdField_a_of_type_JavaUtilList != null)
          {
            if ((localFileManagerStatus.jdField_a_of_type_JavaUtilList.size() < 15) && (!localFileManagerStatus.jdField_a_of_type_Boolean) && (localFileManagerStatus.d <= 3))
            {
              localFileManagerStatus.d += 1;
              this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager$5.a.b((String)localObject6, l);
            }
            else
            {
              localFileManagerStatus.d = 0;
              this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager$5.a.a(localFileManagerStatus.jdField_a_of_type_JavaUtilList, localFileManagerStatus.jdField_a_of_type_Boolean, (String)localObject6, l);
            }
          }
          throw ((Throwable)localObject1);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopFileManager.5.1
 * JD-Core Version:    0.7.0.1
 */