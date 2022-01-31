import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.app.VideoObserver;
import com.tencent.av.ui.redbag.AVRedBagConfig;
import com.tencent.mobileqq.app.ThreadManager;

public class kdv
  extends VideoObserver
{
  public kdv(AVRedBagConfig paramAVRedBagConfig) {}
  
  protected void a()
  {
    ThreadManager.post(new kdw(this), 10, null, true);
    this.a.a.b(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kdv
 * JD-Core Version:    0.7.0.1
 */