import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

final class pzh
  implements pzp
{
  pzh(pzi parampzi) {}
  
  public void a(int paramInt, String paramString, HashMap<Integer, pzq> paramHashMap, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoExtractFrame", 2, "执行结果，onResult code = " + paramInt);
    }
    try
    {
      int i = pzf.a().optInt("KEY_LOCAL_RESULT_SUCC_COUNT", 0);
      pzf.a().put("KEY_LOCAL_RESULT_SUCC_COUNT", i + 1);
      bgmq.a("kandian_video_extract_frame_local_result", pzf.a().toString());
      label66:
      pzf.a(System.currentTimeMillis() - pzf.a());
      pzf.b(paramLong);
      pzf.a(BaseApplication.getContext(), this.a, paramInt, paramString, paramHashMap);
      if (!pzf.a().compareAndSet(false, true)) {
        if (QLog.isColorLevel()) {
          QLog.d("VideoExtractFrame", 2, "任务已销毁，直接返回");
        }
      }
      while (pzf.a() == null) {
        return;
      }
      pzf.a().b();
      pzf.a(null);
      return;
    }
    catch (Exception localException)
    {
      break label66;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pzh
 * JD-Core Version:    0.7.0.1
 */