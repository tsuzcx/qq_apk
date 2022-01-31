import android.hardware.SensorManager;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.activity.ChatHistory.PlayingPttHistoryInfo;
import com.tencent.mobileqq.activity.aio.AudioPlayer;
import com.tencent.mobileqq.activity.aio.AudioPlayer.AudioPlayerListener;

public class rwe
  implements AudioPlayer.AudioPlayerListener
{
  public rwe(ChatHistory paramChatHistory) {}
  
  public void a(AudioPlayer paramAudioPlayer)
  {
    this.a.p();
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$PlayingPttHistoryInfo != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$PlayingPttHistoryInfo.d();
    }
    this.a.setVolumeControlStream(3);
    this.a.jdField_a_of_type_AndroidHardwareSensorManager.unregisterListener(this.a);
  }
  
  public void a(AudioPlayer paramAudioPlayer, int paramInt)
  {
    this.a.b(2131433866);
    this.a.setVolumeControlStream(3);
    this.a.jdField_a_of_type_AndroidHardwareSensorManager.unregisterListener(this.a);
  }
  
  public void b(AudioPlayer paramAudioPlayer, int paramInt)
  {
    this.a.setVolumeControlStream(paramInt);
  }
  
  public void c(AudioPlayer paramAudioPlayer, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rwe
 * JD-Core Version:    0.7.0.1
 */