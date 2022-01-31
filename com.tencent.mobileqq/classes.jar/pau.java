import android.content.Context;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import com.tencent.mobileqq.statistics.ReportController;

public class pau
  extends AudioManager
{
  public pau(Context paramContext)
  {
    super(paramContext);
  }
  
  public int requestAudioFocus(AudioManager.OnAudioFocusChangeListener paramOnAudioFocusChangeListener, int paramInt1, int paramInt2)
  {
    try
    {
      paramInt1 = super.requestAudioFocus(paramOnAudioFocusChangeListener, paramInt1, paramInt2);
      return paramInt1;
    }
    catch (NullPointerException paramOnAudioFocusChangeListener)
    {
      ReportController.b(null, "P_CliOper", "BizTechReport", "", "web", "audio_manager_npe", 0, 1, 0, "", "", "", "");
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pau
 * JD-Core Version:    0.7.0.1
 */