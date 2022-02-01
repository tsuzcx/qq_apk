import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeAwesomeCommentView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class qvu
  implements View.OnClickListener
{
  public qvu(NativeAwesomeCommentView paramNativeAwesomeCommentView, roq paramroq) {}
  
  public void onClick(View paramView)
  {
    if (NativeAwesomeCommentView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeAwesomeCommentView)) {
      NativeAwesomeCommentView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeAwesomeCommentView, false);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.jdField_a_of_type_Roq != null)
      {
        pqx.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeAwesomeCommentView.getContext(), this.jdField_a_of_type_Roq.a, this.jdField_a_of_type_Roq.c);
        roq.a(NativeAwesomeCommentView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeAwesomeCommentView).a, "0X8009B77");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qvu
 * JD-Core Version:    0.7.0.1
 */