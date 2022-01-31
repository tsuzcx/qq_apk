import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager;
import com.tencent.biz.pubaccount.readinjoy.redpacket.widget.RIJRedPacketProgressView;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;

class ryc
  implements View.OnClickListener
{
  ryc(ryb paramryb) {}
  
  public void onClick(View paramView)
  {
    RIJRedPacketManager.a().a(this.a.a, 2, 0, 0);
    FastWebActivity.a(this.a.a).b(2, FastWebActivity.a(this.a.a), FastWebActivity.a(this.a.a).innerUniqueID);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ryc
 * JD-Core Version:    0.7.0.1
 */