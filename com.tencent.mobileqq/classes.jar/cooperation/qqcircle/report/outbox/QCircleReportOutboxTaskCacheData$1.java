package cooperation.qqcircle.report.outbox;

import android.database.Cursor;
import android.os.Parcel;
import com.tencent.open.component.cache.database.DbCacheData.DbCreator;
import com.tencent.open.component.cache.database.DbCacheData.Structure;
import com.tencent.qphone.base.util.QLog;

final class QCircleReportOutboxTaskCacheData$1
  implements DbCacheData.DbCreator<QCircleReportOutboxTaskCacheData>
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
      QLog.w("QueueTaskCacheData", 1, paramCursor.getMessage());
    }
    return null;
  }
  
  public String sortOrder()
  {
    return null;
  }
  
  public DbCacheData.Structure[] structure()
  {
    return new DbCacheData.Structure[] { new DbCacheData.Structure("cache_key", "TEXT UNIQUE"), new DbCacheData.Structure("save_data", "BLOB") };
  }
  
  public int version()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqcircle.report.outbox.QCircleReportOutboxTaskCacheData.1
 * JD-Core Version:    0.7.0.1
 */