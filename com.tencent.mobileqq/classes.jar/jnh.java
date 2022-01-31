import com.tencent.av.redpacket.AVRedPacketManager;
import com.tencent.av.redpacket.AVRedPacketMusicPlayer;

public class jnh
  implements Runnable
{
  public jnh(AVRedPacketManager paramAVRedPacketManager) {}
  
  public void run()
  {
    AVRedPacketManager.a(this.a, this.a.g);
    long l = System.currentTimeMillis();
    this.a.a.a(new jni(this, l));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     jnh
 * JD-Core Version:    0.7.0.1
 */