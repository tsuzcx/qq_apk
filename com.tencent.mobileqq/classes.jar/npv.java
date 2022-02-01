import com.tencent.biz.pubaccount.AccountDetail.view.AccountDetailXListView;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.widget.AbsListView;

class npv
  implements bkhe
{
  int jdField_a_of_type_Int;
  int b = (int)(2.0F * this.jdField_a_of_type_Npm.jdField_a_of_type_Float);
  
  npv(npm paramnpm) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_Npm.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.getFirstVisiblePosition() == 0)
    {
      if ((this.jdField_a_of_type_Npm.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null) && (this.jdField_a_of_type_Npm.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.protocolVersion == 0))
      {
        paramInt1 = -this.jdField_a_of_type_Npm.b();
        paramAbsListView = this.jdField_a_of_type_Npm.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.getChildAt(0);
        if (!this.jdField_a_of_type_Npm.c) {
          break label215;
        }
        if (!this.jdField_a_of_type_Npm.b) {
          break label203;
        }
        paramInt2 = (int)(paramInt1 - 262.0F * this.jdField_a_of_type_Npm.jdField_a_of_type_Float);
        this.jdField_a_of_type_Npm.b(paramInt2, paramAbsListView);
        if ((this.jdField_a_of_type_Npm.jdField_a_of_type_Nqt != null) && (paramInt1 != 0))
        {
          if (paramInt1 >= this.jdField_a_of_type_Npm.q - 75.0F * this.jdField_a_of_type_Npm.jdField_a_of_type_Float) {
            break label247;
          }
          this.jdField_a_of_type_Npm.jdField_a_of_type_Nqt.a(false);
        }
      }
      label151:
      paramInt2 = this.jdField_a_of_type_Npm.b();
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
    for (this.jdField_a_of_type_Npm.e = true;; this.jdField_a_of_type_Npm.e = false)
    {
      this.jdField_a_of_type_Int = paramInt2;
      return;
      label203:
      this.jdField_a_of_type_Npm.c(paramInt1, paramAbsListView);
      break;
      label215:
      if ((this.jdField_a_of_type_Npm.jdField_a_of_type_ComTencentMobileqqDataAccountDetail == null) && (this.jdField_a_of_type_Npm.jdField_a_of_type_ComTencentMobileqqDataEqqDetail == null)) {
        break;
      }
      this.jdField_a_of_type_Npm.a(paramInt1, paramAbsListView);
      break;
      label247:
      this.jdField_a_of_type_Npm.jdField_a_of_type_Nqt.a();
      break label151;
      this.jdField_a_of_type_Npm.c();
      if (this.jdField_a_of_type_Npm.jdField_a_of_type_Nqt == null) {
        break label151;
      }
      this.jdField_a_of_type_Npm.jdField_a_of_type_Nqt.a();
      break label151;
      paramInt1 = 0;
      break label177;
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0)
    {
      tdv.a().c();
      if (!this.jdField_a_of_type_Npm.e) {
        break label89;
      }
      npm.a(this.jdField_a_of_type_Npm, paramAbsListView.getLastVisiblePosition(), npm.d());
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Npm.getCount() - paramAbsListView.getLastVisiblePosition() < npm.e()) && (this.jdField_a_of_type_Npm.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.a)) {
        npm.a(this.jdField_a_of_type_Npm);
      }
      if ((paramAbsListView instanceof AccountDetailXListView)) {
        ((AccountDetailXListView)paramAbsListView).onScrollStateChanged(paramAbsListView, paramInt);
      }
      return;
      label89:
      npm.a(this.jdField_a_of_type_Npm, paramAbsListView.getFirstVisiblePosition() - npm.d(), npm.d());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     npv
 * JD-Core Version:    0.7.0.1
 */