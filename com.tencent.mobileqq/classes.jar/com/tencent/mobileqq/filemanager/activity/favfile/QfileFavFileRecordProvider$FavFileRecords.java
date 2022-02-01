package com.tencent.mobileqq.filemanager.activity.favfile;

import com.tencent.mobileqq.filemanager.data.FavFileInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class QfileFavFileRecordProvider$FavFileRecords
  extends QfileFavFileRecordProvider.FileRecordGroup
{
  Map<Long, FavFileInfo> a = new HashMap();
  Comparator<FavFileInfo> b = new QfileFavFileRecordProvider.FavFileRecords.1(this);
  
  QfileFavFileRecordProvider$FavFileRecords(QfileFavFileRecordProvider paramQfileFavFileRecordProvider) {}
  
  FavFileInfo a(long paramLong)
  {
    return (FavFileInfo)this.a.get(Long.valueOf(paramLong));
  }
  
  List<FavFileInfo> a(int paramInt)
  {
    if (paramInt == 1) {
      return this.d;
    }
    if (paramInt == 2) {
      return this.e;
    }
    if (paramInt == 3) {
      return this.f;
    }
    if (paramInt == 4) {
      return this.g;
    }
    if (paramInt == 5) {
      return this.h;
    }
    return this.h;
  }
  
  void a()
  {
    this.d.clear();
    this.e.clear();
    this.f.clear();
    this.g.clear();
    this.h.clear();
    this.a.clear();
    String str = QfileFavFileRecordProvider.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(QfileFavFileRecordProvider.b);
    localStringBuilder.append("FavFileRecords clear...");
    QLog.i(str, 1, localStringBuilder.toString());
  }
  
  void a(List<FavFileInfo> paramList, int paramInt)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return;
      }
      ArrayList localArrayList;
      if (paramInt == 1) {
        localArrayList = this.d;
      } else if (paramInt == 2) {
        localArrayList = this.e;
      } else if (paramInt == 3) {
        localArrayList = this.f;
      } else if (paramInt == 4) {
        localArrayList = this.g;
      } else if (paramInt == 5) {
        localArrayList = this.h;
      } else {
        localArrayList = this.h;
      }
      int i = 0;
      Object localObject1 = paramList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (FavFileInfo)((Iterator)localObject1).next();
        if (localObject2 != null)
        {
          if (this.a.containsKey(Long.valueOf(((FavFileInfo)localObject2).a)))
          {
            String str = QfileFavFileRecordProvider.a;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(QfileFavFileRecordProvider.b);
            localStringBuilder.append("addOrUpdateFileRecords favfile is exsited, favid:");
            localStringBuilder.append(((FavFileInfo)localObject2).a);
            QLog.w(str, 1, localStringBuilder.toString());
          }
          localArrayList.add(localObject2);
          this.a.put(Long.valueOf(((FavFileInfo)localObject2).a), localObject2);
          i = 1;
        }
      }
      if (i != 0) {
        Collections.sort(localArrayList, this.b);
      }
      localObject1 = QfileFavFileRecordProvider.a;
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(QfileFavFileRecordProvider.b);
      ((StringBuilder)localObject2).append("addOrUpdateFileRecords recordType:");
      ((StringBuilder)localObject2).append(paramInt);
      ((StringBuilder)localObject2).append(" addsize:");
      ((StringBuilder)localObject2).append(paramList.size());
      ((StringBuilder)localObject2).append(" recordSize:");
      ((StringBuilder)localObject2).append(localArrayList.size());
      QLog.i((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.favfile.QfileFavFileRecordProvider.FavFileRecords
 * JD-Core Version:    0.7.0.1
 */