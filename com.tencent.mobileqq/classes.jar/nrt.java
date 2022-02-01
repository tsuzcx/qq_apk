import com.tencent.biz.pubaccount.AccountDetail.view.AccountDetailXListView;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.widget.AbsListView;

class nrt
  implements blih
{
  int jdField_a_of_type_Int;
  int b = (int)(2.0F * this.jdField_a_of_type_Nrk.jdField_a_of_type_Float);
  
  nrt(nrk paramnrk) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_Nrk.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.getFirstVisiblePosition() == 0)
    {
      if ((this.jdField_a_of_type_Nrk.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null) && (this.jdField_a_of_type_Nrk.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.protocolVersion == 0))
      {
        paramInt1 = -this.jdField_a_of_type_Nrk.b();
        paramAbsListView = this.jdField_a_of_type_Nrk.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.getChildAt(0);
        if (!this.jdField_a_of_type_Nrk.c) {
          break label215;
        }
        if (!this.jdField_a_of_type_Nrk.b) {
          break label203;
        }
        paramInt2 = (int)(paramInt1 - 262.0F * this.jdField_a_of_type_Nrk.jdField_a_of_type_Float);
        this.jdField_a_of_type_Nrk.b(paramInt2, paramAbsListView);
        if ((this.jdField_a_of_type_Nrk.jdField_a_of_type_Nsr != null) && (paramInt1 != 0))
        {
          if (paramInt1 >= this.jdField_a_of_type_Nrk.q - 75.0F * this.jdField_a_of_type_Nrk.jdField_a_of_type_Float) {
            break label247;
          }
          this.jdField_a_of_type_Nrk.jdField_a_of_type_Nsr.a(false);
        }
      }
      label151:
      paramInt2 = this.jdField_a_of_type_Nrk.b();
      if (Math.abs(this.jdField_a_of_type_Int - paramInt2) <= this.b) {
        break label290;
      }
      paramInt1 = 1;
      label177:
      if (paramInt1 != 0) {
        if (this.jdField_a_of_type_Int <= paramInt2) {
          break label295;
        }
      }
    }
    label290:
    label295:
    for (this.jdField_a_of_type_Nrk.e = true;; this.jdField_a_of_type_Nrk.e = false)
    {
      this.jdField_a_of_type_Int = paramInt2;
      return;
      label203:
      this.jdField_a_of_type_Nrk.c(paramInt1, paramAbsListView);
      break;
      label215:
      if ((this.jdField_a_of_type_Nrk.jdField_a_of_type_ComTencentMobileqqDataAccountDetail == null) && (this.jdField_a_of_type_Nrk.jdField_a_of_type_ComTencentMobileqqDataEqqDetail == null)) {
        break;
      }
      this.jdField_a_of_type_Nrk.a(paramInt1, paramAbsListView);
      break;
      label247:
      this.jdField_a_of_type_Nrk.jdField_a_of_type_Nsr.a();
      break label151;
      this.jdField_a_of_type_Nrk.c();
      if (this.jdField_a_of_type_Nrk.jdField_a_of_type_Nsr == null) {
        break label151;
      }
      this.jdField_a_of_type_Nrk.jdField_a_of_type_Nsr.a();
      break label151;
      paramInt1 = 0;
      break label177;
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0)
    {
      sun.a().c();
      if (!this.jdField_a_of_type_Nrk.e) {
        break label89;
      }
      nrk.a(this.jdField_a_of_type_Nrk, paramAbsListView.getLastVisiblePosition(), nrk.d());
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Nrk.getCount() - paramAbsListView.getLastVisiblePosition() < nrk.e()) && (this.jdField_a_of_type_Nrk.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.a)) {
        nrk.a(this.jdField_a_of_type_Nrk);
      }
      if ((paramAbsListView instanceof AccountDetailXListView)) {
        ((AccountDetailXListView)paramAbsListView).onScrollStateChanged(paramAbsListView, paramInt);
      }
      return;
      label89:
      nrk.a(this.jdField_a_of_type_Nrk, paramAbsListView.getFirstVisiblePosition() - nrk.d(), nrk.d());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nrt
 * JD-Core Version:    0.7.0.1
 */