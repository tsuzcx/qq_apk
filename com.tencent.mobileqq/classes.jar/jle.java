import com.tencent.av.redpacket.AVRedPacketManager;
import com.tencent.av.redpacket.AVRedPacketMusicPlayer;

public class jle
  implements Runnable
{
  public jle(AVRedPacketManager paramAVRedPacketManager) {}
  
  public void run()
  {
    AVRedPacketManager.a(this.a, this.a.g);
    long l = System.currentTimeMillis();
    this.a.a.a(new jlf(this, l));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jle
 * JD-Core Version:    0.7.0.1
 */