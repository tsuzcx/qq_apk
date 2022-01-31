import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.app.VideoObserver;
import com.tencent.av.ui.redbag.AVRedBagConfig;
import com.tencent.mobileqq.app.ThreadManager;

public class kga
  extends VideoObserver
{
  public kga(AVRedBagConfig paramAVRedBagConfig) {}
  
  protected void a()
  {
    ThreadManager.post(new kgb(this), 10, null, true);
    this.a.a.b(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     kga
 * JD-Core Version:    0.7.0.1
 */