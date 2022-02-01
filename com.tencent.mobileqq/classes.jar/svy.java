import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.redpacket.widget.RIJRedPacketProgressView;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;

public class svy
  implements qzb
{
  public svy(FastWebActivity paramFastWebActivity) {}
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)FastWebActivity.a(this.a).getLayoutParams();
      int i = zby.b(this.a, 144.0F);
      localLayoutParams.rightMargin = i;
      localLayoutParams.leftMargin = i;
      FastWebActivity.a(this.a).setLayoutParams(localLayoutParams);
      FastWebActivity.a(this.a).setVisibility(0);
      FastWebActivity.a(this.a).setOnClickListener(new svz(this));
      FastWebActivity.a(this.a);
      if (FastWebActivity.b(this.a)) {
        FastWebActivity.a(this.a).setImageResource(2130849519);
      }
      FastWebActivity.a(this.a).a(2, FastWebActivity.a(this.a), this.a.a.innerUniqueID);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     svy
 * JD-Core Version:    0.7.0.1
 */