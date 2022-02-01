import com.tencent.biz.pubaccount.AccountDetail.view.AccountDetailXListView;
import com.tencent.qphone.base.util.QLog;

class nru
  implements nun
{
  nru(nrk paramnrk) {}
  
  public void a(int paramInt)
  {
    float f;
    if ((this.a.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.getFirstVisiblePosition() == 0) && (this.a.b))
    {
      paramInt = -this.a.b();
      if (QLog.isColorLevel()) {
        QLog.d("AccountDetailBaseAdapter", 2, "onEndScroll scrollY = " + paramInt + " ,isScrollUp = " + this.a.e);
      }
      f = 150.0F * this.a.jdField_a_of_type_Float;
      if (paramInt != 0)
      {
        if (!this.a.e) {
          break label127;
        }
        if (paramInt <= f) {
          break label119;
        }
        this.a.d(paramInt);
      }
    }
    return;
    label119:
    this.a.e();
    return;
    label127:
    if (paramInt > this.a.q - f)
    {
      this.a.d(paramInt);
      return;
    }
    this.a.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nru
 * JD-Core Version:    0.7.0.1
 */