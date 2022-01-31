import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

final class qlh
  implements qlp
{
  qlh(qli paramqli) {}
  
  public void a(int paramInt, String paramString, HashMap<Integer, qlq> paramHashMap, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoExtractFrame", 2, "执行结果，onResult code = " + paramInt);
    }
    try
    {
      int i = qlf.a().optInt("KEY_LOCAL_RESULT_SUCC_COUNT", 0);
      qlf.a().put("KEY_LOCAL_RESULT_SUCC_COUNT", i + 1);
      bhvh.a("kandian_video_extract_frame_local_result", qlf.a().toString());
      label66:
      qlf.a(System.currentTimeMillis() - qlf.a());
      qlf.b(paramLong);
      qlf.a(BaseApplication.getContext(), this.a, paramInt, paramString, paramHashMap);
      if (!qlf.a().compareAndSet(false, true)) {
        if (QLog.isColorLevel()) {
          QLog.d("VideoExtractFrame", 2, "任务已销毁，直接返回");
        }
      }
      while (qlf.a() == null) {
        return;
      }
      qlf.a().b();
      qlf.a(null);
      return;
    }
    catch (Exception localException)
    {
      break label66;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qlh
 * JD-Core Version:    0.7.0.1
 */