package cooperation.qqfav;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class QfavRequestQueue
{
  private static QfavRequestQueue jdField_a_of_type_CooperationQqfavQfavRequestQueue;
  private ArrayList<QfavRequestQueue.RequestItem> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public boolean a;
  
  private QfavRequestQueue()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public static QfavRequestQueue a()
  {
    if (jdField_a_of_type_CooperationQqfavQfavRequestQueue == null) {
      try
      {
        if (jdField_a_of_type_CooperationQqfavQfavRequestQueue == null) {
          jdField_a_of_type_CooperationQqfavQfavRequestQueue = new QfavRequestQueue();
        }
      }
      finally {}
    }
    return jdField_a_of_type_CooperationQqfavQfavRequestQueue;
  }
  
  public QfavRequestQueue.RequestItem a(long paramLong)
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QfavRequestQueue", 2, "pop, request list is empty");
        }
        return null;
      }
      Object localObject2 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        QfavRequestQueue.RequestItem localRequestItem = (QfavRequestQueue.RequestItem)((Iterator)localObject2).next();
        if (localRequestItem.jdField_a_of_type_Long == paramLong)
        {
          this.jdField_a_of_type_JavaUtilArrayList.remove(localRequestItem);
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("pop, id: ");
            ((StringBuilder)localObject2).append(paramLong);
            ((StringBuilder)localObject2).append("pendingsize:");
            ((StringBuilder)localObject2).append(this.jdField_a_of_type_JavaUtilArrayList.size());
            QLog.d("QfavRequestQueue", 2, ((StringBuilder)localObject2).toString());
          }
          return localRequestItem;
        }
      }
      return null;
    }
    for (;;)
    {
      throw localObject1;
    }
  }
  
  public List<Bundle> a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0))
    {
      Parcel localParcel = Parcel.obtain();
      localParcel.unmarshall(paramArrayOfByte, 0, paramArrayOfByte.length);
      localParcel.setDataPosition(0);
      paramArrayOfByte = (Bundle)Bundle.CREATOR.createFromParcel(localParcel);
      localParcel.recycle();
      return paramArrayOfByte.getParcelableArrayList("pendingData");
    }
    return null;
  }
  
  public boolean a()
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      boolean bool = this.jdField_a_of_type_JavaUtilArrayList.isEmpty();
      return bool;
    }
  }
  
  public byte[] a()
  {
    Object localObject1 = new ArrayList();
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
        return null;
      }
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        ((ArrayList)localObject1).add(((QfavRequestQueue.RequestItem)localIterator.next()).jdField_a_of_type_AndroidContentIntent.getExtras());
      }
      if (((ArrayList)localObject1).isEmpty()) {
        return null;
      }
      ??? = new Bundle();
      ((Bundle)???).putParcelableArrayList("pendingData", (ArrayList)localObject1);
      localObject1 = Parcel.obtain();
      ((Bundle)???).writeToParcel((Parcel)localObject1, 0);
      ??? = ((Parcel)localObject1).marshall();
      ((Parcel)localObject1).recycle();
      return ???;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.qqfav.QfavRequestQueue
 * JD-Core Version:    0.7.0.1
 */