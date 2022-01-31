import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import java.util.ArrayList;

class sdy
  implements rcg
{
  sdy(sdw paramsdw) {}
  
  public boolean a(View paramView, ArrayList<DislikeInfo> paramArrayList, Object paramObject)
  {
    if (!bbfj.g(sds.a(this.a.a)))
    {
      bcql.a(sds.a(this.a.a), 1, sds.a(this.a.a).getString(2131718341), 0).a();
      return false;
    }
    paramView = onh.a();
    osg.a().a(Long.valueOf(paramView).longValue(), this.a.a.a(paramArrayList));
    bcql.a(sds.a(this.a.a), -1, sds.a(this.a.a).getString(2131699674), 0).b(sds.a(this.a.a).getResources().getDimensionPixelSize(2131298865));
    sds.a(this.a.a).dismiss();
    if (sds.a(this.a.a) != null) {
      sds.a(this.a.a).a(sds.a(this.a.a), sds.e(this.a.a), sds.a(this.a.a), paramArrayList);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     sdy
 * JD-Core Version:    0.7.0.1
 */