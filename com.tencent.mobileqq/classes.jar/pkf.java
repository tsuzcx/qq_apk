import android.os.Handler;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.FusionBiuInfo;

class pkf
  implements View.OnAttachStateChangeListener
{
  pkf(pkd parampkd, osp paramosp) {}
  
  public void onViewAttachedToWindow(View paramView)
  {
    osm.a().a(this.jdField_a_of_type_Osp);
    if ((pkd.a(this.jdField_a_of_type_Pkd) != null) && (pkd.a(this.jdField_a_of_type_Pkd).fusionBiuInfo != null) && (!pkd.a(this.jdField_a_of_type_Pkd).fusionBiuInfo.b) && (pkd.a(this.jdField_a_of_type_Pkd) == 1) && (!pkd.a(this.jdField_a_of_type_Pkd)) && (rmc.a().a()))
    {
      osm.a().e();
      pkd.a(this.jdField_a_of_type_Pkd, true);
    }
  }
  
  public void onViewDetachedFromWindow(View paramView)
  {
    osm.a().b(this.jdField_a_of_type_Osp);
    pkd.a(this.jdField_a_of_type_Pkd).removeCallbacksAndMessages(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pkf
 * JD-Core Version:    0.7.0.1
 */