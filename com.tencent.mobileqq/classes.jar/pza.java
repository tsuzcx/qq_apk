import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class pza
  implements View.OnClickListener
{
  pza(pyz parampyz, pvc parampvc, soh paramsoh) {}
  
  public void onClick(View paramView)
  {
    if (pyz.a(this.jdField_a_of_type_Pyz) == null) {
      pyz.a(this.jdField_a_of_type_Pyz, new bjrb(pyz.a(this.jdField_a_of_type_Pyz)));
    }
    pyz.a(this.jdField_a_of_type_Pyz).a((pwe)this.jdField_a_of_type_Pvc, this.jdField_a_of_type_Pvc.a().mDislikeInfos);
    pyz.a(this.jdField_a_of_type_Pyz).a(paramView, new pzb(this));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pza
 * JD-Core Version:    0.7.0.1
 */