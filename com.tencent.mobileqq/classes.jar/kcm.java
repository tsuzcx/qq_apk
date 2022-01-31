import com.tencent.av.ui.VoiceChangeAdapter;
import com.tencent.av.ui.VoiceChangeAdapter.ICallback;
import com.tencent.av.ui.VoiceChangeData.VoiceInfo;
import com.tencent.av.ui.VoiceChangeItemView1;
import com.tencent.av.ui.VoiceChangeItemView1.ICallback;

public class kcm
  implements VoiceChangeItemView1.ICallback
{
  public kcm(VoiceChangeAdapter paramVoiceChangeAdapter) {}
  
  public void a(VoiceChangeItemView1 paramVoiceChangeItemView1, int paramInt)
  {
    VoiceChangeData.VoiceInfo localVoiceInfo = (VoiceChangeData.VoiceInfo)this.a.getItem(paramInt);
    if ((localVoiceInfo == null) || (localVoiceInfo.a == VoiceChangeAdapter.a(this.a))) {}
    do
    {
      return;
      if (VoiceChangeAdapter.a(this.a) != null) {
        VoiceChangeAdapter.a(this.a).setHighlight(false);
      }
      VoiceChangeAdapter.a(this.a, localVoiceInfo.a);
      VoiceChangeAdapter.a(this.a, paramVoiceChangeItemView1);
      VoiceChangeAdapter.a(this.a).setHighlight(true);
    } while (VoiceChangeAdapter.a(this.a) == null);
    VoiceChangeAdapter.a(this.a).a(VoiceChangeAdapter.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kcm
 * JD-Core Version:    0.7.0.1
 */