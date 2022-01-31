import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.biz.now.PluginRecordHelper;
import com.tencent.biz.now.PluginRecordHelper.cigHelperCallback;

public class kqn
  extends Handler
{
  public kqn(PluginRecordHelper paramPluginRecordHelper) {}
  
  public void handleMessage(Message paramMessage)
  {
    if ((paramMessage.what == 1001) && (this.a.jdField_a_of_type_ComTencentBizNowPluginRecordHelper$cigHelperCallback != null))
    {
      paramMessage = this.a.jdField_a_of_type_ComTencentBizNowPluginRecordHelper$cigHelperCallback;
      if (TextUtils.isEmpty(this.a.b)) {
        break label65;
      }
    }
    label65:
    for (boolean bool = true;; bool = false)
    {
      paramMessage.a(bool, this.a.c, this.a.jdField_a_of_type_Long);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kqn
 * JD-Core Version:    0.7.0.1
 */