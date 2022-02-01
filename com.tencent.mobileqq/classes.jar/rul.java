import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

final class rul
  implements rut
{
  rul(rum paramrum) {}
  
  public void a(int paramInt, String paramString, HashMap<Integer, ruu> paramHashMap, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoExtractFrame", 2, "执行结果，onResult code = " + paramInt);
    }
    try
    {
      int i = ruj.a().optInt("KEY_LOCAL_RESULT_SUCC_COUNT", 0);
      ruj.a().put("KEY_LOCAL_RESULT_SUCC_COUNT", i + 1);
      bkwm.a("kandian_video_extract_frame_local_result", ruj.a().toString());
      label66:
      ruj.a(System.currentTimeMillis() - ruj.a());
      ruj.b(paramLong);
      ruj.a(BaseApplication.getContext(), this.a, paramInt, paramString, paramHashMap);
      if (!ruj.a().compareAndSet(false, true)) {
        if (QLog.isColorLevel()) {
          QLog.d("VideoExtractFrame", 2, "任务已销毁，直接返回");
        }
      }
      while (ruj.a() == null) {
        return;
      }
      ruj.a().b();
      ruj.a(null);
      return;
    }
    catch (Exception localException)
    {
      break label66;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rul
 * JD-Core Version:    0.7.0.1
 */