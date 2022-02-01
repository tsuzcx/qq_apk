import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

final class sha
  implements shi
{
  sha(shb paramshb) {}
  
  public void a(int paramInt, String paramString, HashMap<Integer, shj> paramHashMap, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoExtractFrame", 2, "执行结果，onResult code = " + paramInt);
    }
    try
    {
      int i = sgy.a().optInt("KEY_LOCAL_RESULT_SUCC_COUNT", 0);
      sgy.a().put("KEY_LOCAL_RESULT_SUCC_COUNT", i + 1);
      bmhv.a("kandian_video_extract_frame_local_result", sgy.a().toString());
      label66:
      sgy.a(System.currentTimeMillis() - sgy.a());
      sgy.b(paramLong);
      sgy.a(BaseApplication.getContext(), this.a, paramInt, paramString, paramHashMap);
      if (!sgy.a().compareAndSet(false, true)) {
        if (QLog.isColorLevel()) {
          QLog.d("VideoExtractFrame", 2, "任务已销毁，直接返回");
        }
      }
      while (sgy.a() == null) {
        return;
      }
      sgy.a().b();
      sgy.a(null);
      return;
    }
    catch (Exception localException)
    {
      break label66;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sha
 * JD-Core Version:    0.7.0.1
 */