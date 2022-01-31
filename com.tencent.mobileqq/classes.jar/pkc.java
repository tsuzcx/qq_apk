import android.os.Handler;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.FusionBiuInfo;

class pkc
  implements View.OnAttachStateChangeListener
{
  pkc(pka parampka, osm paramosm) {}
  
  public void onViewAttachedToWindow(View paramView)
  {
    osj.a().a(this.jdField_a_of_type_Osm);
    if ((pka.a(this.jdField_a_of_type_Pka) != null) && (pka.a(this.jdField_a_of_type_Pka).fusionBiuInfo != null) && (!pka.a(this.jdField_a_of_type_Pka).fusionBiuInfo.b) && (pka.a(this.jdField_a_of_type_Pka) == 1) && (!pka.a(this.jdField_a_of_type_Pka)) && (rlz.a().a()))
    {
      osj.a().e();
      pka.a(this.jdField_a_of_type_Pka, true);
    }
  }
  
  public void onViewDetachedFromWindow(View paramView)
  {
    osj.a().b(this.jdField_a_of_type_Osm);
    pka.a(this.jdField_a_of_type_Pka).removeCallbacksAndMessages(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pkc
 * JD-Core Version:    0.7.0.1
 */