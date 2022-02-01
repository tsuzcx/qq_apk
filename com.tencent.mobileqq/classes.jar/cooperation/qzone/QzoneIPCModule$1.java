package cooperation.qzone;

import com.tencent.mobileqq.mini.api.IPrePullListener;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class QzoneIPCModule$1
  implements IPrePullListener
{
  QzoneIPCModule$1(QzoneIPCModule paramQzoneIPCModule) {}
  
  public void onPrePullCallback(boolean paramBoolean, JSONObject paramJSONObject)
  {
    QLog.d("QzoneIPCModule", 4, String.format("after preload For QQ MINI Program %b", new Object[] { Boolean.valueOf(paramBoolean) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.QzoneIPCModule.1
 * JD-Core Version:    0.7.0.1
 */