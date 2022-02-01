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
  private static QfavRequestQueue b;
  public boolean a = false;
  private ArrayList<QfavRequestQueue.RequestItem> c = new ArrayList();
  
  public static QfavRequestQueue a()
  {
    if (b == null) {
      try
      {
        if (b == null) {
          b = new QfavRequestQueue();
        }
      }
      finally {}
    }
    return b;
  }
  
  public QfavRequestQueue.RequestItem a(long paramLong)
  {
    synchronized (this.c)
    {
      if (this.c.size() == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QfavRequestQueue", 2, "pop, request list is empty");
        }
        return null;
      }
      Object localObject2 = this.c.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        QfavRequestQueue.RequestItem localRequestItem = (QfavRequestQueue.RequestItem)((Iterator)localObject2).next();
        if (localRequestItem.b == paramLong)
        {
          this.c.remove(localRequestItem);
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("pop, id: ");
            ((StringBuilder)localObject2).append(paramLong);
            ((StringBuilder)localObject2).append("pendingsize:");
            ((StringBuilder)localObject2).append(this.c.size());
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
  
  public boolean b()
  {
    synchronized (this.c)
    {
      boolean bool = this.c.isEmpty();
      return bool;
    }
  }
  
  public byte[] c()
  {
    Object localObject1 = new ArrayList();
    synchronized (this.c)
    {
      if (this.c.isEmpty()) {
        return null;
      }
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext()) {
        ((ArrayList)localObject1).add(((QfavRequestQueue.RequestItem)localIterator.next()).a.getExtras());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqfav.QfavRequestQueue
 * JD-Core Version:    0.7.0.1
 */