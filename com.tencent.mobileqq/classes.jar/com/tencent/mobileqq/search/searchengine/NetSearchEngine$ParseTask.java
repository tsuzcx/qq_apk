package com.tencent.mobileqq.search.searchengine;

import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.search.base.engine.ISearchListener;
import com.tencent.mobileqq.search.model.ISearchResultGroupModel;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.pb.profilecard.SummaryCardBusiEntry.comm;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class NetSearchEngine$ParseTask
  implements Runnable
{
  private ArrayList<byte[]> a;
  private WeakReference<ISearchListener> b;
  private String c;
  
  public NetSearchEngine$ParseTask(String paramString, ArrayList<byte[]> paramArrayList, ISearchListener paramISearchListener)
  {
    this.c = paramArrayList;
    this.a = paramISearchListener;
    Object localObject;
    if (localObject != null) {
      this.b = new WeakReference(localObject);
    }
  }
  
  private List<ISearchResultGroupModel> a(String paramString, ArrayList<byte[]> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      ArrayList localArrayList = new ArrayList(12);
      StringBuilder localStringBuilder = new StringBuilder(paramArrayList.size() * 64);
      int k = paramArrayList.size();
      int i = 0;
      while (i < k)
      {
        Object localObject = (byte[])paramArrayList.get(i);
        int j;
        if (localObject == null) {
          j = 0;
        } else {
          j = localObject.length;
        }
        if (j > 10)
        {
          int i1 = (int)PkgTools.getLongData((byte[])localObject, 1);
          int m = (int)PkgTools.getLongData((byte[])localObject, 5);
          if (i1 > 0)
          {
            int n = 9 + i1;
            if (n < j)
            {
              byte[] arrayOfByte = new byte[i1];
              PkgTools.copyData(arrayOfByte, 0, (byte[])localObject, 9, i1);
              SummaryCardBusiEntry.comm localcomm = new SummaryCardBusiEntry.comm();
              try
              {
                localcomm.mergeFrom(arrayOfByte);
                j = localcomm.result.get();
                if (j == 0)
                {
                  j = localcomm.service.get();
                  arrayOfByte = new byte[m];
                  PkgTools.copyData(arrayOfByte, 0, (byte[])localObject, n, m);
                  localObject = this.this$0.a(paramString, j, localcomm, arrayOfByte);
                  if ((localObject != null) && (((List)localObject).size() > 0)) {
                    localArrayList.addAll((Collection)localObject);
                  }
                }
                else
                {
                  localStringBuilder.append(" |busi entry, [");
                  localStringBuilder.append(localcomm.service.get());
                  localStringBuilder.append(",");
                  localStringBuilder.append(j);
                  localStringBuilder.append(",");
                  localStringBuilder.append(localcomm.err_msg.get());
                }
              }
              catch (Exception localException)
              {
                if (QLog.isColorLevel()) {
                  QLog.i("Q.uniteSearch.NetSearchEngine", 2, localException.toString());
                }
              }
            }
          }
        }
        i += 1;
      }
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.uniteSearch.NetSearchEngine", 4, localStringBuilder.toString());
      }
      return localArrayList;
    }
    return null;
  }
  
  public void run()
  {
    List localList = a(this.c, this.a);
    Object localObject = this.b;
    if (localObject != null)
    {
      localObject = (ISearchListener)((WeakReference)localObject).get();
      if (localObject != null) {
        ((ISearchListener)localObject).a(localList, 1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.searchengine.NetSearchEngine.ParseTask
 * JD-Core Version:    0.7.0.1
 */