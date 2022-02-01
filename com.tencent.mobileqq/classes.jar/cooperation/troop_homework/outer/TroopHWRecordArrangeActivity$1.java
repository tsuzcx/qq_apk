package cooperation.troop_homework.outer;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.aio.audiopanel.CommonRecordSoundPanel;
import com.tencent.mobileqq.troop.data.AudioInfo;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

class TroopHWRecordArrangeActivity$1
  extends Handler
{
  TroopHWRecordArrangeActivity$1(TroopHWRecordArrangeActivity paramTroopHWRecordArrangeActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 3)
    {
      if (i != 101)
      {
        if (i != 102) {
          return;
        }
        paramMessage = paramMessage.obj.toString();
        Object localObject = new File(paramMessage);
        long l;
        if (((File)localObject).exists()) {
          l = ((File)localObject).length();
        } else {
          l = 0L;
        }
        localObject = this.a;
        ((TroopHWRecordArrangeActivity)localObject).jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo = new AudioInfo(paramMessage, (int)((TroopHWRecordArrangeActivity)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.a(), l);
        this.a.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.setVisibility(8);
        paramMessage = new JSONObject();
        try
        {
          paramMessage.put("webid", TroopHWRecordArrangeActivity.a(this.a));
          paramMessage.put("type", "record");
          paramMessage.put("state", "stop");
          paramMessage.put("time", Math.round(this.a.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo.duration / 1000.0F));
          paramMessage.put("size", this.a.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo.size);
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
        }
        Intent localIntent = new Intent();
        localIntent.putExtra("jscallback", paramMessage.toString());
        localIntent.putExtra("localPath", this.a.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo.path);
        this.a.setResult(-1, localIntent);
        this.a.finish();
        return;
      }
      this.a.setResult(0);
      this.a.finish();
      return;
    }
    this.a.jdField_a_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.troop_homework.outer.TroopHWRecordArrangeActivity.1
 * JD-Core Version:    0.7.0.1
 */