import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.video.click.RIJVideoHandleClick.9.1;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.mobileqq.app.ThreadManager;

public class phx
  implements pen
{
  phx(phl paramphl) {}
  
  public void onClick(View paramView)
  {
    sjy localsjy = (sjy)paramView.getTag();
    BaseArticleInfo localBaseArticleInfo = phl.a(this.a).a(localsjy.jdField_a_of_type_Int);
    if (localBaseArticleInfo == null) {
      return;
    }
    phl.a(this.a).a().a().a(localsjy.jdField_a_of_type_Sdg, localBaseArticleInfo, true, true);
    ThreadManager.executeOnSubThread(new RIJVideoHandleClick.9.1(this, localBaseArticleInfo));
    psf.a(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     phx
 * JD-Core Version:    0.7.0.1
 */