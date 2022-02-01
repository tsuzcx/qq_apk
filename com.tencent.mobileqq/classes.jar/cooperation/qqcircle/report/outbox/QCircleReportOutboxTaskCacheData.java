package cooperation.qqcircle.report.outbox;

import android.content.ContentValues;
import android.os.Parcel;
import com.tencent.component.app.common.ParcelableWrapper;
import com.tencent.open.component.cache.database.DbCacheData;
import com.tencent.open.component.cache.database.DbCacheData.DbCreator;

public class QCircleReportOutboxTaskCacheData
  extends DbCacheData
{
  public static final DbCacheData.DbCreator<QCircleReportOutboxTaskCacheData> DB_CREATOR = new QCircleReportOutboxTaskCacheData.1();
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
    if (this.mTask != null)
    {
      paramContentValues.put("cache_key", this.mTask.getCacheKey());
      Parcel localParcel = Parcel.obtain();
      localParcel.setDataPosition(0);
      ParcelableWrapper.writeDataToParcel(localParcel, 0, this.mTask);
      byte[] arrayOfByte = localParcel.marshall();
      localParcel.recycle();
      paramContentValues.put("save_data", arrayOfByte);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqcircle.report.outbox.QCircleReportOutboxTaskCacheData
 * JD-Core Version:    0.7.0.1
 */