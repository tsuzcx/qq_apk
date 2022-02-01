import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class qav
  implements View.OnClickListener
{
  qav(qau paramqau, pxk parampxk, stc paramstc) {}
  
  public void onClick(View paramView)
  {
    if (qau.a(this.jdField_a_of_type_Qau) == null) {
      qau.a(this.jdField_a_of_type_Qau, new bklj(qau.a(this.jdField_a_of_type_Qau)));
    }
    qau.a(this.jdField_a_of_type_Qau).a((pya)this.jdField_a_of_type_Pxk, this.jdField_a_of_type_Pxk.a().mDislikeInfos);
    qau.a(this.jdField_a_of_type_Qau).a(paramView, new qaw(this));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qav
 * JD-Core Version:    0.7.0.1
 */