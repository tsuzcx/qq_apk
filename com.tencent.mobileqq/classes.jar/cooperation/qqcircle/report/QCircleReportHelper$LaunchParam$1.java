package cooperation.qqcircle.report;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

final class QCircleReportHelper$LaunchParam$1
  implements Parcelable.Creator<QCircleReportHelper.LaunchParam>
{
  public QCircleReportHelper.LaunchParam createFromParcel(Parcel paramParcel)
  {
    try
    {
      paramParcel = QCircleReportHelper.LaunchParam.wrap(paramParcel.readString(), paramParcel.readString(), paramParcel.readString(), paramParcel.readInt(), paramParcel.readHashMap(HashMap.class.getClassLoader()));
      return paramParcel;
    }
    catch (Throwable paramParcel)
    {
      QLog.e("QCircleReportHelper", 1, paramParcel, new Object[0]);
    }
    return null;
  }
  
  public QCircleReportHelper.LaunchParam[] newArray(int paramInt)
  {
    return new QCircleReportHelper.LaunchParam[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqcircle.report.QCircleReportHelper.LaunchParam.1
 * JD-Core Version:    0.7.0.1
 */