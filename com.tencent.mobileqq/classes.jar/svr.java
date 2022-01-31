import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;

class svr
  implements rse
{
  svr(svp paramsvp) {}
  
  public boolean a(View paramView, ArrayList<DislikeInfo> paramArrayList, Object paramObject)
  {
    if (!bdee.g(svl.a(this.a.a)))
    {
      QQToast.a(svl.a(this.a.a), 1, svl.a(this.a.a).getString(2131718724), 0).a();
      return false;
    }
    paramView = ors.a();
    owy.a().a(Long.valueOf(paramView).longValue(), this.a.a.a(paramArrayList));
    QQToast.a(svl.a(this.a.a), -1, svl.a(this.a.a).getString(2131700042), 0).b(svl.a(this.a.a).getResources().getDimensionPixelSize(2131298914));
    svl.a(this.a.a).dismiss();
    if (svl.a(this.a.a) != null) {
      svl.a(this.a.a).a(svl.a(this.a.a), svl.e(this.a.a), svl.a(this.a.a), paramArrayList);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     svr
 * JD-Core Version:    0.7.0.1
 */