import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ptg
  implements View.OnClickListener
{
  ptg(ptf paramptf, ppu paramppu, skg paramskg) {}
  
  public void onClick(View paramView)
  {
    if (ptf.a(this.jdField_a_of_type_Ptf) == null) {
      ptf.a(this.jdField_a_of_type_Ptf, new blmm(ptf.a(this.jdField_a_of_type_Ptf)));
    }
    ptf.a(this.jdField_a_of_type_Ptf).a((pqk)this.jdField_a_of_type_Ppu, this.jdField_a_of_type_Ppu.a().mDislikeInfos);
    ptf.a(this.jdField_a_of_type_Ptf).a(paramView, new pth(this));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ptg
 * JD-Core Version:    0.7.0.1
 */