import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.presenter.ReadInJoyHeaderPresenter;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class lss
  implements Runnable
{
  lss(lsr paramlsr) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.a.jdField_a_of_type_JavaUtilArrayList.size())
    {
      localArrayList.add(((IReadInJoyModel)this.a.jdField_a_of_type_JavaUtilArrayList.get(i)).a());
      i += 1;
    }
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("headerUninterestConfirm,");
      if (this.a.b != null) {
        break label139;
      }
    }
    label139:
    for (String str = "null";; str = this.a.b.toString())
    {
      QLog.d("ReadInJoyHeaderPresenter", 2, str);
      ReadInJoyHeaderPresenter.a(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyPresenterReadInJoyHeaderPresenter).a(this.a.jdField_a_of_type_Int, localArrayList, this.a.b, this.a.jdField_a_of_type_JavaLangObject);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lss
 * JD-Core Version:    0.7.0.1
 */