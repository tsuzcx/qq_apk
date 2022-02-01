package com.tencent.mobileqq.troop.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.aio.audiopanel.CommonRecordSoundPanel;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.troop.data.AudioInfo;
import com.tencent.mobileqq.troop.utils.TroopBarUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class AudioRecordFragment$2
  extends Handler
{
  AudioRecordFragment$2(AudioRecordFragment paramAudioRecordFragment) {}
  
  public void handleMessage(Message paramMessage)
  {
    if ((this.a.getBaseActivity() != null) && (!this.a.isDetached()))
    {
      int i = paramMessage.what;
      if (i != 3)
      {
        if (i != 102)
        {
          if (i != 103) {
            return;
          }
          if ((this.a.h != null) && (this.a.h.equals("publish")) && (this.a.j != null)) {
            TroopBarUtils.a("pub_page", "preview_record", this.a.j, this.a.k, "", "");
          }
        }
        else
        {
          paramMessage = paramMessage.obj.toString();
          Object localObject = new File(paramMessage);
          long l;
          if (((File)localObject).exists()) {
            l = ((File)localObject).length();
          } else {
            l = 0L;
          }
          localObject = this.a;
          ((AudioRecordFragment)localObject).f = new AudioInfo(paramMessage, (int)((AudioRecordFragment)localObject).a.getRecordTime(), l);
          this.a.a.setVisibility(8);
          paramMessage = new Intent();
          paramMessage.putExtra("audio_info", this.a.f);
          this.a.getBaseActivity().setResult(-1, paramMessage);
          this.a.getBaseActivity().finish();
        }
      }
      else if (QLog.isColorLevel()) {
        QLog.d("AIOAudioPanel", 2, "RECORD_TO_START =============");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "handleMessage,fragment is in a invalid state, return");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.AudioRecordFragment.2
 * JD-Core Version:    0.7.0.1
 */