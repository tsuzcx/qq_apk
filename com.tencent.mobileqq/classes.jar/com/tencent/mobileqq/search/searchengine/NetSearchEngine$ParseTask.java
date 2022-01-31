package com.tencent.mobileqq.search.searchengine;

import aynt;
import ayuh;
import bdqa;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.pb.profilecard.SummaryCardBusiEntry.comm;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class NetSearchEngine$ParseTask
  implements Runnable
{
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<ayuh> jdField_a_of_type_JavaLangRefWeakReference;
  private ArrayList<byte[]> jdField_a_of_type_JavaUtilArrayList;
  
  public NetSearchEngine$ParseTask(String paramString, ArrayList<byte[]> paramArrayList, ayuh paramayuh)
  {
    this.jdField_a_of_type_JavaLangString = paramArrayList;
    this.jdField_a_of_type_JavaUtilArrayList = paramayuh;
    Object localObject;
    if (localObject != null) {
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(localObject);
    }
  }
  
  private List<aynt> a(String paramString, ArrayList<byte[]> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() <= 0)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(12);
    StringBuilder localStringBuilder = new StringBuilder(paramArrayList.size() * 64);
    int k = paramArrayList.size();
    int i = 0;
    if (i < k)
    {
      Object localObject = (byte[])paramArrayList.get(i);
      int j;
      if (localObject == null)
      {
        j = 0;
        label72:
        if (j > 10) {
          break label94;
        }
      }
      for (;;)
      {
        i += 1;
        break;
        j = localObject.length;
        break label72;
        label94:
        int n = (int)bdqa.a((byte[])localObject, 1);
        int m = (int)bdqa.a((byte[])localObject, 5);
        if ((n > 0) && (n + 9 < j))
        {
          byte[] arrayOfByte = new byte[n];
          bdqa.a(arrayOfByte, 0, (byte[])localObject, 9, n);
          j = n + 9;
          SummaryCardBusiEntry.comm localcomm = new SummaryCardBusiEntry.comm();
          try
          {
            localcomm.mergeFrom(arrayOfByte);
            n = localcomm.result.get();
            if (n != 0) {
              break label278;
            }
            n = localcomm.service.get();
            arrayOfByte = new byte[m];
            bdqa.a(arrayOfByte, 0, (byte[])localObject, j, m);
            localObject = this.this$0.a(paramString, n, localcomm, arrayOfByte);
            if ((localObject == null) || (((List)localObject).size() <= 0)) {
              continue;
            }
            localArrayList.addAll((Collection)localObject);
          }
          catch (Exception localException) {}
          if (QLog.isColorLevel())
          {
            QLog.i("Q.uniteSearch.NetSearchEngine", 2, localException.toString());
            continue;
            label278:
            localStringBuilder.append(" |busi entry, [").append(localcomm.service.get()).append(",").append(n).append(",").append(localcomm.err_msg.get());
          }
        }
      }
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.uniteSearch.NetSearchEngine", 4, localStringBuilder.toString());
    }
    return localArrayList;
  }
  
  public void run()
  {
    List localList = a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilArrayList);
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      ayuh localayuh = (ayuh)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localayuh != null) {
        localayuh.a(localList, 1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.searchengine.NetSearchEngine.ParseTask
 * JD-Core Version:    0.7.0.1
 */