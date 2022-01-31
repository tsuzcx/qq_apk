import android.content.SharedPreferences;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.DoubleVideoCtrlUI;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class jvb
  implements Runnable
{
  public jvb(DoubleVideoCtrlUI paramDoubleVideoCtrlUI) {}
  
  public void run()
  {
    if (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {}
    for (;;)
    {
      return;
      if ((this.a.jdField_a_of_type_ComTencentAvVideoController != null) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a() != null))
      {
        Object localObject = SharedPreUtils.d(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).getString("AvWeakNet_video_ConfigContent", "");
        if (((String)localObject).length() == 0)
        {
          QLog.d(this.a.c, 1, "cannot Read AvWeaknetConfig");
          return;
        }
        try
        {
          localObject = new JSONObject((String)localObject);
          if (((JSONObject)localObject).has("ground_glass_switch_android"))
          {
            if (((JSONObject)localObject).getInt("ground_glass_switch_android") == 1) {
              this.a.jdField_a_of_type_ComTencentAvVideoController.a().aA = true;
            }
            if (((JSONObject)localObject).has("ground_glass_default_interval")) {
              this.a.jdField_a_of_type_ComTencentAvVideoController.a().Q = ((JSONObject)localObject).getInt("ground_glass_default_interval");
            }
            if (((JSONObject)localObject).has("ground_glass_default_timeout_rule")) {
              this.a.jdField_a_of_type_ComTencentAvVideoController.a().R = ((JSONObject)localObject).getInt("ground_glass_default_timeout_rule");
            }
            QLog.d(this.a.c, 1, "AsyncReadDoubleGlassConfig mIsGlassCanUse=" + this.a.jdField_a_of_type_ComTencentAvVideoController.a().aA + ", mCurrentVideoGlassWaitTime=" + this.a.jdField_a_of_type_ComTencentAvVideoController.a().Q + ", mCurrentDefaultTimeOutRule=" + this.a.jdField_a_of_type_ComTencentAvVideoController.a().R);
            if ((this.a.jdField_a_of_type_ComTencentAvVideoController.a().aA) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a().Q > 0))
            {
              DoubleVideoCtrlUI.a(this.a);
              return;
            }
          }
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     jvb
 * JD-Core Version:    0.7.0.1
 */