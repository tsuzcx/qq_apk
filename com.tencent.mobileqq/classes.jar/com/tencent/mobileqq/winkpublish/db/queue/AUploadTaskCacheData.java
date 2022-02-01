package com.tencent.mobileqq.winkpublish.db.queue;

import android.content.ContentValues;
import android.os.Parcel;
import com.tencent.mobileqq.qcircle.api.db.DbCacheData;
import com.tencent.mobileqq.qcircle.api.db.IDBCacheDataWrapper.DbCreator;
import com.tencent.mobileqq.qcircle.api.db.util.ParcelableWrapper;
import com.tencent.mobileqq.winkpublish.IQueueTask;

public class AUploadTaskCacheData
  extends DbCacheData
{
  public static final IDBCacheDataWrapper.DbCreator<AUploadTaskCacheData> DB_CREATOR = new AUploadTaskCacheData.1();
  private static final int VERSION = 8;
  private IQueueTask mTask;
  
  public AUploadTaskCacheData() {}
  
  public AUploadTaskCacheData(IQueueTask paramIQueueTask)
  {
    this.mTask = paramIQueueTask;
  }
  
  public static IQueueTask createQueueTask(int paramInt, Parcel paramParcel)
  {
    return (IQueueTask)ParcelableWrapper.createDataFromParcel(paramParcel);
  }
  
  public IQueueTask getQueueTask()
  {
    return this.mTask;
  }
  
  public void writeTo(ContentValues paramContentValues)
  {
    Object localObject = this.mTask;
    if (localObject != null)
    {
      paramContentValues.put("client_key", ((IQueueTask)localObject).getCacheKey());
      paramContentValues.put("type", Integer.valueOf(this.mTask.getExactType()));
      localObject = Parcel.obtain();
      ((Parcel)localObject).setDataPosition(0);
      ParcelableWrapper.writeDataToParcel((Parcel)localObject, 0, this.mTask);
      byte[] arrayOfByte = ((Parcel)localObject).marshall();
      ((Parcel)localObject).recycle();
      paramContentValues.put("publish_data", arrayOfByte);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.db.queue.AUploadTaskCacheData
 * JD-Core Version:    0.7.0.1
 */