import com.tencent.avgame.qav.AVGameCameraAssistant;
import com.tencent.avgame.qav.AVGameCameraAssistant.3;
import com.tencent.qphone.base.util.QLog;

public class ngz
  extends myc
{
  public ngz(AVGameCameraAssistant.3 param3) {}
  
  public void a(int paramInt, boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AVGameCameraAssistant", 2, "notifyEvent, id[" + paramInt + "], result[" + paramBoolean + "]");
    }
    if ((paramInt == 1) && (paramBoolean))
    {
      if (AVGameCameraAssistant.a(this.a.this$0) != null) {
        AVGameCameraAssistant.a(this.a.this$0).g();
      }
      AVGameCameraAssistant.a(this.a.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ngz
 * JD-Core Version:    0.7.0.1
 */