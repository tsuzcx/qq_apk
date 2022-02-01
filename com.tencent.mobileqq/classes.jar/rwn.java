import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

final class rwn
  implements rwv
{
  rwn(rwo paramrwo) {}
  
  public void a(int paramInt, String paramString, HashMap<Integer, rww> paramHashMap, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoExtractFrame", 2, "执行结果，onResult code = " + paramInt);
    }
    try
    {
      int i = rwl.a().optInt("KEY_LOCAL_RESULT_SUCC_COUNT", 0);
      rwl.a().put("KEY_LOCAL_RESULT_SUCC_COUNT", i + 1);
      bmqa.a("kandian_video_extract_frame_local_result", rwl.a().toString());
      label66:
      rwl.a(System.currentTimeMillis() - rwl.a());
      rwl.b(paramLong);
      rwl.a(BaseApplication.getContext(), this.a, paramInt, paramString, paramHashMap);
      if (!rwl.a().compareAndSet(false, true)) {
        if (QLog.isColorLevel()) {
          QLog.d("VideoExtractFrame", 2, "任务已销毁，直接返回");
        }
      }
      while (rwl.a() == null) {
        return;
      }
      rwl.a().b();
      rwl.a(null);
      return;
    }
    catch (Exception localException)
    {
      break label66;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rwn
 * JD-Core Version:    0.7.0.1
 */