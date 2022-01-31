import android.os.Handler;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.FusionBiuInfo;

class oyn
  implements View.OnAttachStateChangeListener
{
  oyn(oyl paramoyl, ohe paramohe) {}
  
  public void onViewAttachedToWindow(View paramView)
  {
    ohb.a().a(this.jdField_a_of_type_Ohe);
    if ((oyl.a(this.jdField_a_of_type_Oyl) != null) && (oyl.a(this.jdField_a_of_type_Oyl).fusionBiuInfo != null) && (!oyl.a(this.jdField_a_of_type_Oyl).fusionBiuInfo.b) && (oyl.a(this.jdField_a_of_type_Oyl) == 1) && (!oyl.a(this.jdField_a_of_type_Oyl)) && (qzk.a().a()))
    {
      ohb.a().e();
      oyl.a(this.jdField_a_of_type_Oyl, true);
    }
  }
  
  public void onViewDetachedFromWindow(View paramView)
  {
    ohb.a().b(this.jdField_a_of_type_Ohe);
    oyl.a(this.jdField_a_of_type_Oyl).removeCallbacksAndMessages(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oyn
 * JD-Core Version:    0.7.0.1
 */