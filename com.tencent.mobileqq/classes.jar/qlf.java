import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class qlf
  implements View.OnClickListener
{
  qlf(qle paramqle, qfw paramqfw, tbs paramtbs) {}
  
  public void onClick(View paramView)
  {
    if (qle.a(this.jdField_a_of_type_Qle) == null) {
      qle.a(this.jdField_a_of_type_Qle, new blcn(qle.a(this.jdField_a_of_type_Qle)));
    }
    qle.a(this.jdField_a_of_type_Qle).a((qhk)this.jdField_a_of_type_Qfw, this.jdField_a_of_type_Qfw.a().mDislikeInfos);
    qle.a(this.jdField_a_of_type_Qle).a(paramView, new qlg(this));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qlf
 * JD-Core Version:    0.7.0.1
 */