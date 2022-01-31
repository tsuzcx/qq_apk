import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import java.util.ArrayList;

class seb
  implements rcj
{
  seb(sdz paramsdz) {}
  
  public boolean a(View paramView, ArrayList<DislikeInfo> paramArrayList, Object paramObject)
  {
    if (!bbev.g(sdv.a(this.a.a)))
    {
      bcpw.a(sdv.a(this.a.a), 1, sdv.a(this.a.a).getString(2131718330), 0).a();
      return false;
    }
    paramView = onk.a();
    osj.a().a(Long.valueOf(paramView).longValue(), this.a.a.a(paramArrayList));
    bcpw.a(sdv.a(this.a.a), -1, sdv.a(this.a.a).getString(2131699663), 0).b(sdv.a(this.a.a).getResources().getDimensionPixelSize(2131298865));
    sdv.a(this.a.a).dismiss();
    if (sdv.a(this.a.a) != null) {
      sdv.a(this.a.a).a(sdv.a(this.a.a), sdv.e(this.a.a), sdv.a(this.a.a), paramArrayList);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     seb
 * JD-Core Version:    0.7.0.1
 */