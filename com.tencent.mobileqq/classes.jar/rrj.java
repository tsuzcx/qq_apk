import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import java.util.ArrayList;

class rrj
  implements qpy
{
  rrj(rrh paramrrh) {}
  
  public boolean a(View paramView, ArrayList<DislikeInfo> paramArrayList, Object paramObject)
  {
    if (!badq.g(rrd.a(this.a.a)))
    {
      bbmy.a(rrd.a(this.a.a), 1, rrd.a(this.a.a).getString(2131652511), 0).a();
      return false;
    }
    paramView = obz.a();
    ogy.a().a(Long.valueOf(paramView).longValue(), this.a.a.a(paramArrayList));
    bbmy.a(rrd.a(this.a.a), -1, rrd.a(this.a.a).getString(2131633875), 0).b(rrd.a(this.a.a).getResources().getDimensionPixelSize(2131167766));
    rrd.a(this.a.a).dismiss();
    if (rrd.a(this.a.a) != null) {
      rrd.a(this.a.a).a(rrd.a(this.a.a), rrd.e(this.a.a), rrd.a(this.a.a), paramArrayList);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rrj
 * JD-Core Version:    0.7.0.1
 */