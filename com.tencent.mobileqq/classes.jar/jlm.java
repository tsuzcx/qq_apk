import com.tencent.av.redpacket.ui.RedPacketGameEmojiAnimation;
import com.tencent.av.redpacket.ui.RedPacketGameParticleEmoji.OnShowListener;
import com.tencent.qphone.base.util.QLog;

public class jlm
  implements RedPacketGameParticleEmoji.OnShowListener
{
  public jlm(RedPacketGameEmojiAnimation paramRedPacketGameEmojiAnimation) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RedPacketGameEmojiAnimation", 2, "onShow called, needDetectFace set true");
    }
    if (this.a.a != null) {
      this.a.a.c = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jlm
 * JD-Core Version:    0.7.0.1
 */