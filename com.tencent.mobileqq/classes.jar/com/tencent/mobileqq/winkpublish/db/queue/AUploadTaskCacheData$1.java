package com.tencent.mobileqq.winkpublish.db.queue;

import android.database.Cursor;
import android.os.Parcel;
import com.tencent.mobileqq.qcircle.api.db.IDBCacheDataWrapper.DbCreator;
import com.tencent.mobileqq.qcircle.api.db.IDBCacheDataWrapper.Structure;
import com.tencent.mobileqq.winkpublish.IQueueTask;
import com.tencent.qphone.base.util.QLog;

final class AUploadTaskCacheData$1
  implements IDBCacheDataWrapper.DbCreator<AUploadTaskCacheData>
{
  public AUploadTaskCacheData a(Cursor paramCursor)
  {
    int i = paramCursor.getInt(paramCursor.getColumnIndex("type"));
    Object localObject = paramCursor.getBlob(paramCursor.getColumnIndex("publish_data"));
    try
    {
      paramCursor = Parcel.obtain();
      paramCursor.unmarshall((byte[])localObject, 0, localObject.length);
      paramCursor.setDataPosition(0);
      localObject = AUploadTaskCacheData.createQueueTask(i, paramCursor);
      ((IQueueTask)localObject).setTime(System.currentTimeMillis());
      paramCursor.recycle();
      paramCursor = new AUploadTaskCacheData((IQueueTask)localObject);
      return paramCursor;
    }
    catch (Throwable paramCursor)
    {
      QLog.w("QueueTaskCacheData", 1, paramCursor.getMessage());
    }
    return null;
  }
  
  public String sortOrder()
  {
    return null;
  }
  
  public IDBCacheDataWrapper.Structure[] structure()
  {
    return new IDBCacheDataWrapper.Structure[] { new IDBCacheDataWrapper.Structure("client_key", "TEXT UNIQUE"), new IDBCacheDataWrapper.Structure("type", "INTEGER"), new IDBCacheDataWrapper.Structure("publish_data", "BLOB") };
  }
  
  public int version()
  {
    return 8;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.db.queue.AUploadTaskCacheData.1
 * JD-Core Version:    0.7.0.1
 */