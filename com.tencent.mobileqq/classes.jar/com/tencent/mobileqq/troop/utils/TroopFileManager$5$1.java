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
    int m;
    boolean bool;
    String str;
    long l;
    TroopFileManager.FileManagerStatus localFileManagerStatus;
    synchronized (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager$5.a)
    {
      m = this.jdField_a_of_type_AndroidOsBundle.getInt("reqFor");
      bool = this.jdField_a_of_type_AndroidOsBundle.getBoolean("isFirstPage");
      str = this.jdField_a_of_type_AndroidOsBundle.getString("parentFileId");
      l = this.jdField_a_of_type_AndroidOsBundle.getLong("uin_filter");
      localFileManagerStatus = (TroopFileManager.FileManagerStatus)this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager$5.a.d.get(str + l);
      if (localFileManagerStatus == null) {
        return;
      }
      if (m != 1) {}
    }
    int i;
    try
    {
      i = this.jdField_a_of_type_Int;
      if (i == -1000)
      {
        if (this.jdField_a_of_type_Boolean) {
          break label2763;
        }
        if (!QLog.isDevelopLevel()) {
          break label2731;
        }
        QLog.d("TroopFileManager", 4, "onRspFileListV2 failed, req for:" + m);
        break label2731;
        for (;;)
        {
          return;
          localObject1 = finally;
          throw localObject1;
          localFileManagerStatus.jdField_a_of_type_Long = 0L;
          this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager$5.a.a(null, false, str, l);
          continue;
          localFileManagerStatus.jdField_b_of_type_Boolean = false;
          this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager$5.a.a(null, false, str, l);
          continue;
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
              continue;
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
                }
              }
            }
          }
        }
      }
      localFileManagerStatus.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro = this.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro;
      if (this.jdField_a_of_type_Boolean)
      {
        localObject2 = this.jdField_a_of_type_JavaUtilList;
        if (localObject2 != null) {}
      }
      else
      {
        if (this.jdField_a_of_type_Boolean) {
          break label2827;
        }
        if (!QLog.isDevelopLevel()) {
          break label2795;
        }
        QLog.d("TroopFileManager", 4, "onRspFileListV2 failed, req for:" + m);
        break label2795;
        for (;;)
        {
          label514:
          return;
          localFileManagerStatus.jdField_a_of_type_Long = 0L;
          this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager$5.a.a(null, false, str, l);
          continue;
          localFileManagerStatus.jdField_b_of_type_Boolean = false;
          this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager$5.a.a(null, false, str, l);
          continue;
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
              continue;
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
                }
              }
            }
          }
        }
      }
      localFileManagerStatus.jdField_a_of_type_Boolean = this.jdField_b_of_type_Boolean;
      localFileManagerStatus.jdField_b_of_type_Int = this.jdField_b_of_type_Int;
      if (!bool) {
        break label977;
      }
      localFileManagerStatus.jdField_a_of_type_Int = this.c;
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager$5.a.a();
      localFileManagerStatus.jdField_a_of_type_JavaUtilList.clear();
      localFileManagerStatus.jdField_a_of_type_JavaUtilMap.clear();
      localObject2 = ((Collection)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        ??? = (TroopFileInfo)((Iterator)localObject2).next();
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager$5.a.b.put(((TroopFileInfo)???).jdField_a_of_type_JavaUtilUUID, ???);
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager$5.a.c.put(((TroopFileInfo)???).b, ???);
      }
      if (!QLog.isDevelopLevel()) {
        break label2859;
      }
    }
    finally
    {
      if (this.jdField_a_of_type_Boolean) {
        break label2963;
      }
    }
    QLog.d("TroopFileManager", 4, "onRspFileListV2 failed, req for:" + m);
    for (;;)
    {
      label974:
      throw localObject3;
      label977:
      Object localObject6;
      Object localObject7;
      switch (m)
      {
      case 2: 
      default: 
        localObject6 = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager$5.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager.a();
        localObject7 = this.jdField_a_of_type_JavaUtilList.iterator();
      }
      Object localObject4;
      label1545:
      label1743:
      for (;;)
      {
        if (!((Iterator)localObject7).hasNext()) {
          break label1745;
        }
        localObject4 = (TroopFileInfo)((Iterator)localObject7).next();
        if (((TroopFileInfo)localObject4).jdField_d_of_type_Boolean)
        {
          if (((TroopFileInfo)localObject4).b == null) {
            continue;
          }
          ??? = (TroopFileInfo)this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager$5.a.c.get(((TroopFileInfo)localObject4).b);
          if (??? == null)
          {
            ((TroopFileInfo)localObject4).jdField_a_of_type_JavaUtilUUID = UUID.randomUUID();
            this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager$5.a.c.put(((TroopFileInfo)localObject4).b, localObject4);
            Iterator localIterator = ((List)localObject6).iterator();
            for (;;)
            {
              ??? = localObject4;
              if (!localIterator.hasNext()) {
                break;
              }
              ??? = (TroopFileStatusInfo)localIterator.next();
              if (((TroopFileInfo)localObject4).b.equals(((TroopFileStatusInfo)???).i))
              {
                TroopFileInfo localTroopFileInfo2 = new TroopFileInfo();
                localTroopFileInfo2.jdField_a_of_type_JavaUtilUUID = ((TroopFileStatusInfo)???).jdField_a_of_type_JavaUtilUUID;
                localTroopFileInfo2.b = ((TroopFileStatusInfo)???).e;
                localTroopFileInfo2.g = ((TroopFileStatusInfo)???).i;
                localTroopFileInfo2.a((TroopFileStatusInfo)???, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager$5.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
                ((TroopFileInfo)localObject4).a(localTroopFileInfo2);
              }
            }
            localFileManagerStatus.jdField_a_of_type_Boolean = this.jdField_b_of_type_Boolean;
            break;
          }
          ((TroopFileInfo)???).b((TroopFileInfo)localObject4);
          this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager$5.a.b.put(((TroopFileInfo)???).jdField_a_of_type_JavaUtilUUID, ???);
          if (localFileManagerStatus.jdField_a_of_type_JavaUtilMap.get(((TroopFileInfo)???).b) == null)
          {
            localFileManagerStatus.jdField_a_of_type_JavaUtilList.add(???);
            localFileManagerStatus.jdField_a_of_type_JavaUtilMap.put(((TroopFileInfo)???).b, ???);
          }
          this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager$5.a.c.put(((TroopFileInfo)???).b, ???);
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.e("TroopFileManager", 2, "onRspFileListV2: fileName = " + ((TroopFileInfo)localObject4).jdField_c_of_type_JavaLangString + ", filePath = " + ((TroopFileInfo)localObject4).b + ", sha = " + ((TroopFileInfo)localObject4).jdField_d_of_type_JavaLangString);
        }
        ??? = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager$5.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager.a(((TroopFileInfo)localObject4).b);
        if (??? == null)
        {
          ((TroopFileInfo)localObject4).jdField_a_of_type_JavaUtilUUID = UUID.randomUUID();
          ((TroopFileInfo)localObject4).jdField_d_of_type_Long = ((TroopFileInfo)localObject4).jdField_c_of_type_Long;
        }
        for (;;)
        {
          if ((((TroopFileInfo)localObject4).e == 1) || (((TroopFileInfo)localObject4).e == 3) || (((TroopFileInfo)localObject4).e == 2) || (((TroopFileInfo)localObject4).e == 12)) {
            break label1743;
          }
          ??? = (TroopFileInfo)this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager$5.a.c.get(((TroopFileInfo)localObject4).b);
          if (??? == null) {
            break label2891;
          }
          ((TroopFileInfo)???).b((TroopFileInfo)localObject4);
          localObject4 = ???;
          ((TroopFileInfo)localObject4).a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager$5.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager$5.a.jdField_a_of_type_Long);
          this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager$5.a.b.put(((TroopFileInfo)localObject4).jdField_a_of_type_JavaUtilUUID, localObject4);
          if (localFileManagerStatus.jdField_a_of_type_JavaUtilMap.get(((TroopFileInfo)localObject4).b) == null)
          {
            localFileManagerStatus.jdField_a_of_type_JavaUtilList.add(localObject4);
            localFileManagerStatus.jdField_a_of_type_JavaUtilMap.put(((TroopFileInfo)localObject4).b, localObject4);
          }
          this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager$5.a.c.put(((TroopFileInfo)localObject4).b, localObject4);
          break;
          ((TroopFileInfo)localObject4).jdField_a_of_type_JavaUtilUUID = ((TroopFileStatusInfo)???).jdField_a_of_type_JavaUtilUUID;
          ((TroopFileInfo)localObject4).a((TroopFileStatusInfo)???, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager$5.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          if (((TroopFileInfo)localObject4).e == 9)
          {
            ??? = (TroopFileInfo)this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager$5.a.c.get(((TroopFileStatusInfo)???).i);
            if (??? != null) {
              ((TroopFileInfo)???).a((TroopFileInfo)localObject4);
            }
          }
        }
      }
      label1745:
      int k;
      if (!"/".equals(str))
      {
        localObject4 = (TroopFileInfo)this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager$5.a.c.get(str);
        if (localObject4 != null)
        {
          ??? = ((TroopFileInfo)localObject4).jdField_a_of_type_JavaUtilMap.keySet();
          localObject6 = new ArrayList();
          ??? = ((Set)???).iterator();
          while (((Iterator)???).hasNext()) {
            ((List)localObject6).add((String)((Iterator)???).next());
          }
          int n = localFileManagerStatus.jdField_a_of_type_JavaUtilList.size();
          synchronized (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager$5.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager)
          {
            localObject6 = ((List)localObject6).iterator();
            while (((Iterator)localObject6).hasNext())
            {
              localObject7 = (String)((Iterator)localObject6).next();
              int j = 0;
              i = 0;
              localObject7 = (TroopFileInfo)((TroopFileInfo)localObject4).jdField_a_of_type_JavaUtilMap.get(localObject7);
              if (localObject7 != null)
              {
                if ((n <= 0) || (localFileManagerStatus.jdField_a_of_type_JavaUtilList.get(n - 1) == null)) {
                  break label2726;
                }
                int i1 = ((TroopFileInfo)localFileManagerStatus.jdField_a_of_type_JavaUtilList.get(n - 1)).a();
                if (((TroopFileInfo)localObject7).a() >= i1)
                {
                  k = 0;
                  label1984:
                  j = i;
                  if (k < n)
                  {
                    if ((localObject7 == null) || (((TroopFileInfo)localObject7).b == null) || (localFileManagerStatus.jdField_a_of_type_JavaUtilList.get(k) == null) || (!((TroopFileInfo)localObject7).b.equals(((TroopFileInfo)localFileManagerStatus.jdField_a_of_type_JavaUtilList.get(k)).b))) {
                      break label2723;
                    }
                    i = 1;
                    break label2894;
                  }
                }
                i = j;
                if (((TroopFileInfo)localObject7).a() <= i1)
                {
                  i = j;
                  if (!this.jdField_b_of_type_Boolean) {
                    i = 1;
                  }
                }
                label2075:
                if (i == 0)
                {
                  ((TroopFileInfo)localObject4).jdField_a_of_type_JavaUtilMap.remove(((TroopFileInfo)localObject7).b);
                  this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager$5.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager.a(((TroopFileInfo)localObject7).jdField_a_of_type_JavaUtilUUID, true);
                }
              }
            }
          }
          this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager$5.a.d(localTroopFileInfo1);
        }
      }
      if (!this.jdField_a_of_type_Boolean) {
        if (QLog.isDevelopLevel()) {
          QLog.d("TroopFileManager", 4, "onRspFileListV2 failed, req for:" + m);
        }
      }
      for (;;)
      {
        return;
        localFileManagerStatus.jdField_a_of_type_Long = 0L;
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager$5.a.a(null, false, str, l);
        continue;
        localFileManagerStatus.jdField_b_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager$5.a.a(null, false, str, l);
        continue;
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
            continue;
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
                continue;
                localFileManagerStatus.jdField_a_of_type_Long = 0L;
                this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager$5.a.a(null, false, str, l);
                break label974;
                localFileManagerStatus.jdField_b_of_type_Boolean = false;
                this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager$5.a.a(null, false, str, l);
                break label974;
                if (localFileManagerStatus.jdField_a_of_type_JavaUtilList == null) {
                  break label974;
                }
                if ((localFileManagerStatus.jdField_a_of_type_JavaUtilList.size() < 15) && (!localFileManagerStatus.jdField_a_of_type_Boolean) && (localFileManagerStatus.d <= 3))
                {
                  localFileManagerStatus.d += 1;
                  this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager$5.a.b(str, l);
                  break label974;
                }
                localFileManagerStatus.d = 0;
                this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager$5.a.a(localFileManagerStatus.jdField_a_of_type_JavaUtilList, localFileManagerStatus.jdField_a_of_type_Boolean, str, l);
                break label974;
                if (localFileManagerStatus.jdField_a_of_type_JavaUtilList == null) {
                  break label974;
                }
                if ((localFileManagerStatus.jdField_a_of_type_JavaUtilList.size() < 15) && (!localFileManagerStatus.jdField_a_of_type_Boolean) && (localFileManagerStatus.d <= 3))
                {
                  localFileManagerStatus.d += 1;
                  localFileManagerStatus.jdField_b_of_type_Boolean = false;
                  this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager$5.a.b(str, l);
                  break label974;
                }
                localFileManagerStatus.jdField_b_of_type_Boolean = false;
                localFileManagerStatus.d = 0;
                this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager$5.a.a(localFileManagerStatus.jdField_a_of_type_JavaUtilList, localFileManagerStatus.jdField_a_of_type_Boolean, str, l);
                break label974;
                label2723:
                break label2894;
                label2726:
                i = 0;
                break label2075;
                label2731:
                switch (m)
                {
                }
                break;
                label2763:
                switch (m)
                {
                }
                break;
                label2795:
                switch (m)
                {
                }
                break label514;
                label2827:
                switch (m)
                {
                }
                break label514;
                label2859:
                switch (m)
                {
                }
                break label974;
                label2891:
                break label1545;
                label2894:
                k += 1;
                break label1984;
                switch (m)
                {
                }
                continue;
                switch (m)
                {
                }
              }
            }
          }
        }
      }
      label2963:
      switch (m)
      {
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopFileManager.5.1
 * JD-Core Version:    0.7.0.1
 */