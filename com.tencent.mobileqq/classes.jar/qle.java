import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

final class qle
  implements qlm
{
  qle(qlf paramqlf) {}
  
  public void a(int paramInt, String paramString, HashMap<Integer, qln> paramHashMap, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoExtractFrame", 2, "执行结果，onResult code = " + paramInt);
    }
    try
    {
      int i = qlc.a().optInt("KEY_LOCAL_RESULT_SUCC_COUNT", 0);
      qlc.a().put("KEY_LOCAL_RESULT_SUCC_COUNT", i + 1);
      bhvy.a("kandian_video_extract_frame_local_result", qlc.a().toString());
      label66:
      qlc.a(System.currentTimeMillis() - qlc.a());
      qlc.b(paramLong);
      qlc.a(BaseApplication.getContext(), this.a, paramInt, paramString, paramHashMap);
      if (!qlc.a().compareAndSet(false, true)) {
        if (QLog.isColorLevel()) {
          QLog.d("VideoExtractFrame", 2, "任务已销毁，直接返回");
        }
      }
      while (qlc.a() == null) {
        return;
      }
      qlc.a().b();
      qlc.a(null);
      return;
    }
    catch (Exception localException)
    {
      break label66;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qle
 * JD-Core Version:    0.7.0.1
 */