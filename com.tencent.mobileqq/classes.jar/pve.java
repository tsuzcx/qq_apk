import com.tencent.biz.pubaccount.readinjoy.engine.KandianSubscribeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianSubscribeManager.2.1;
import com.tencent.mobileqq.app.ThreadManager;

public class pve
  extends anyz
{
  public pve(KandianSubscribeManager paramKandianSubscribeManager) {}
  
  protected void onGetPAMsgFin(boolean paramBoolean)
  {
    super.onGetPAMsgFin(paramBoolean);
    ThreadManager.executeOnSubThread(new KandianSubscribeManager.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pve
 * JD-Core Version:    0.7.0.1
 */