import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.33;
import com.tencent.common.app.BaseApplicationImpl;

class ryy
  implements View.OnClickListener
{
  ryy(ryx paramryx) {}
  
  public void onClick(View paramView)
  {
    RIJRedPacketManager.a().a(this.a.a.this$0, 5, FastWebActivity.c(this.a.a.this$0), FastWebActivity.a(this.a.a.this$0).innerUniqueID, new ryz(this), false, null);
    paramView = new orz();
    orz localorz = paramView.a("rowkey", FastWebActivity.a(this.a.a.this$0).innerUniqueID).a("content_type", Integer.valueOf(2));
    if (bdee.h(BaseApplicationImpl.getContext())) {}
    for (int i = 2;; i = 1)
    {
      localorz.a("network_type", Integer.valueOf(i)).a("os", Integer.valueOf(1)).a("imei", ors.f());
      nrt.a("0X800ABBA", paramView.a());
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ryy
 * JD-Core Version:    0.7.0.1
 */