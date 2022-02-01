package cooperation.qqcircle.report.outbox;

import android.database.Cursor;
import android.os.Parcel;
import com.tencent.biz.richframework.delegate.impl.RFLog;
import com.tencent.mobileqq.qcircle.api.db.IDBCacheDataWrapper.DbCreator;
import com.tencent.mobileqq.qcircle.api.db.IDBCacheDataWrapper.Structure;

final class QCircleReportOutboxTaskCacheData$1
  implements IDBCacheDataWrapper.DbCreator<QCircleReportOutboxTaskCacheData>
{
  public QCircleReportOutboxTaskCacheData createFromCursor(Cursor paramCursor)
  {
    Object localObject = paramCursor.getBlob(paramCursor.getColumnIndex("save_data"));
    try
    {
      paramCursor = Parcel.obtain();
      paramCursor.unmarshall((byte[])localObject, 0, localObject.length);
      paramCursor.setDataPosition(0);
      localObject = QCircleReportOutboxTaskCacheData.createQueueTask(paramCursor);
      ((QCircleReportOutboxTask)localObject).setTime(System.currentTimeMillis());
      paramCursor.recycle();
      paramCursor = new QCircleReportOutboxTaskCacheData((QCircleReportOutboxTask)localObject);
      return paramCursor;
    }
    catch (Throwable paramCursor)
    {
      RFLog.w("QueueTaskCacheData", RFLog.USR, paramCursor.getMessage());
    }
    return null;
  }
  
  public String sortOrder()
  {
    return null;
  }
  
  public IDBCacheDataWrapper.Structure[] structure()
  {
    return new IDBCacheDataWrapper.Structure[] { new IDBCacheDataWrapper.Structure("cache_key", "TEXT UNIQUE"), new IDBCacheDataWrapper.Structure("save_data", "BLOB") };
  }
  
  public int version()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqcircle.report.outbox.QCircleReportOutboxTaskCacheData.1
 * JD-Core Version:    0.7.0.1
 */