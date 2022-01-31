import com.tencent.biz.pubaccount.readinjoy.engine.KandianSubscribeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianSubscribeManager.2.1;
import com.tencent.mobileqq.app.ThreadManager;

public class ose
  extends akav
{
  public ose(KandianSubscribeManager paramKandianSubscribeManager) {}
  
  protected void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    ThreadManager.executeOnSubThread(new KandianSubscribeManager.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ose
 * JD-Core Version:    0.7.0.1
 */