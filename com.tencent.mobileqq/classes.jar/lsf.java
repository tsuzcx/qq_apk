import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyModelImpl;
import com.tencent.biz.pubaccount.readinjoy.presenter.ReadInJoyHeaderPresenter;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyView;
import com.tencent.widget.KandianPopupWindow;

public class lsf
  implements View.OnClickListener
{
  public lsf(ReadInJoyHeaderPresenter paramReadInJoyHeaderPresenter, IReadInJoyModel paramIReadInJoyModel, ReadInJoyView paramReadInJoyView) {}
  
  public void onClick(View paramView)
  {
    if (!ReadInJoyHeaderPresenter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyPresenterReadInJoyHeaderPresenter).a()) {
      ReadInJoyHeaderPresenter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyPresenterReadInJoyHeaderPresenter).a();
    }
    if (ReadInJoyHeaderPresenter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyPresenterReadInJoyHeaderPresenter).a(((ReadInJoyModelImpl)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel).b, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.a().mDislikeInfos)) {
      ReadInJoyHeaderPresenter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyPresenterReadInJoyHeaderPresenter).a(paramView, new lsg(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lsf
 * JD-Core Version:    0.7.0.1
 */