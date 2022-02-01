import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.video.click.RIJVideoHandleClick.10.1;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.mobileqq.app.ThreadManager;

public class psg
  implements pnq
{
  psg(psf parampsf) {}
  
  public void onClick(View paramView)
  {
    sxh localsxh = (sxh)paramView.getTag();
    BaseArticleInfo localBaseArticleInfo = psf.a(this.a).a(localsxh.jdField_a_of_type_Int);
    if (localBaseArticleInfo == null) {
      return;
    }
    psf.a(this.a).a().a().a(localsxh.jdField_a_of_type_Spk, localBaseArticleInfo, true, true);
    ThreadManager.executeOnSubThread(new RIJVideoHandleClick.10.1(this, localBaseArticleInfo));
    qdc.a(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     psg
 * JD-Core Version:    0.7.0.1
 */