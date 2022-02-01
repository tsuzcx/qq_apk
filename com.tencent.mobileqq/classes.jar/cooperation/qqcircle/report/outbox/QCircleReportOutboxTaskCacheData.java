package cooperation.qqcircle.report.outbox;

import android.content.ContentValues;
import android.os.Parcel;
import com.tencent.mobileqq.qcircle.api.db.DbCacheData;
import com.tencent.mobileqq.qcircle.api.db.IDBCacheDataWrapper.DbCreator;
import com.tencent.mobileqq.qcircle.api.db.util.ParcelableWrapper;

public class QCircleReportOutboxTaskCacheData
  extends DbCacheData
{
  public static final IDBCacheDataWrapper.DbCreator<QCircleReportOutboxTaskCacheData> DB_CREATOR = new QCircleReportOutboxTaskCacheData.1();
  private static final int VERSION = 1;
  private QCircleReportOutboxTask mTask;
  
  public QCircleReportOutboxTaskCacheData(QCircleReportOutboxTask paramQCircleReportOutboxTask)
  {
    this.mTask = paramQCircleReportOutboxTask;
  }
  
  public static QCircleReportOutboxTask createQueueTask(Parcel paramParcel)
  {
    return (QCircleReportOutboxTask)ParcelableWrapper.createDataFromParcel(paramParcel);
  }
  
  public QCircleReportOutboxTask getQueueTask()
  {
    return this.mTask;
  }
  
  public void writeTo(ContentValues paramContentValues)
  {
    Object localObject = this.mTask;
    if (localObject != null)
    {
      paramContentValues.put("cache_key", ((QCircleReportOutboxTask)localObject).getCacheKey());
      localObject = Parcel.obtain();
      ((Parcel)localObject).setDataPosition(0);
      ParcelableWrapper.writeDataToParcel((Parcel)localObject, 0, this.mTask);
      byte[] arrayOfByte = ((Parcel)localObject).marshall();
      ((Parcel)localObject).recycle();
      paramContentValues.put("save_data", arrayOfByte);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.qqcircle.report.outbox.QCircleReportOutboxTaskCacheData
 * JD-Core Version:    0.7.0.1
 */