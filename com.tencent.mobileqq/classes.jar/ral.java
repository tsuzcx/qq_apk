import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

final class ral
  implements rat
{
  ral(ram paramram) {}
  
  public void a(int paramInt, String paramString, HashMap<Integer, rau> paramHashMap, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoExtractFrame", 2, "执行结果，onResult code = " + paramInt);
    }
    try
    {
      int i = raj.a().optInt("KEY_LOCAL_RESULT_SUCC_COUNT", 0);
      raj.a().put("KEY_LOCAL_RESULT_SUCC_COUNT", i + 1);
      bjxj.a("kandian_video_extract_frame_local_result", raj.a().toString());
      label66:
      raj.a(System.currentTimeMillis() - raj.a());
      raj.b(paramLong);
      raj.a(BaseApplication.getContext(), this.a, paramInt, paramString, paramHashMap);
      if (!raj.a().compareAndSet(false, true)) {
        if (QLog.isColorLevel()) {
          QLog.d("VideoExtractFrame", 2, "任务已销毁，直接返回");
        }
      }
      while (raj.a() == null) {
        return;
      }
      raj.a().b();
      raj.a(null);
      return;
    }
    catch (Exception localException)
    {
      break label66;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ral
 * JD-Core Version:    0.7.0.1
 */