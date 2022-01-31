import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.struct.Kandian210Msg0xeeInfo;
import com.tencent.biz.pubaccount.readinjoy.view.appinpush.KandianAppInPush;

public class llw
  implements Runnable
{
  public llw(KandianMergeManager paramKandianMergeManager) {}
  
  public void run()
  {
    if ((KandianMergeManager.a(this.a) != null) && (this.a.i()))
    {
      Kandian210Msg0xeeInfo localKandian210Msg0xeeInfo = KandianMergeManager.a(this.a);
      KandianMergeManager.a(this.a, null);
      Kandian210Msg0xeeInfo.removeKandian210Msg0xeeInfoFromSp();
      KandianAppInPush.a().a(localKandian210Msg0xeeInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     llw
 * JD-Core Version:    0.7.0.1
 */