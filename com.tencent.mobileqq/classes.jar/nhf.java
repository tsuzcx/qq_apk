import com.tencent.biz.pubaccount.AccountDetail.view.AccountDetailXListView;
import com.tencent.widget.AbsListView;

class nhf
  implements bhpo
{
  int jdField_a_of_type_Int;
  int b = (int)(2.0F * this.jdField_a_of_type_Ngw.jdField_a_of_type_Float);
  
  nhf(ngw paramngw) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_Ngw.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.getFirstVisiblePosition() == 0)
    {
      paramInt1 = -this.jdField_a_of_type_Ngw.b();
      paramAbsListView = this.jdField_a_of_type_Ngw.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.getChildAt(0);
      if (this.jdField_a_of_type_Ngw.c) {
        if (this.jdField_a_of_type_Ngw.b)
        {
          paramInt2 = (int)(paramInt1 - 262.0F * this.jdField_a_of_type_Ngw.jdField_a_of_type_Float);
          this.jdField_a_of_type_Ngw.b(paramInt2, paramAbsListView);
          if ((this.jdField_a_of_type_Ngw.jdField_a_of_type_Nic != null) && (paramInt1 != 0))
          {
            if (paramInt1 >= this.jdField_a_of_type_Ngw.o - 75.0F * this.jdField_a_of_type_Ngw.jdField_a_of_type_Float) {
              break label224;
            }
            this.jdField_a_of_type_Ngw.jdField_a_of_type_Nic.a(false);
          }
          label128:
          paramInt2 = this.jdField_a_of_type_Ngw.b();
          if (Math.abs(this.jdField_a_of_type_Int - paramInt2) <= this.b) {
            break label267;
          }
          paramInt1 = 1;
          label154:
          if (paramInt1 != 0) {
            if (this.jdField_a_of_type_Int <= paramInt2) {
              break label272;
            }
          }
        }
      }
    }
    label267:
    label272:
    for (this.jdField_a_of_type_Ngw.e = true;; this.jdField_a_of_type_Ngw.e = false)
    {
      this.jdField_a_of_type_Int = paramInt2;
      return;
      this.jdField_a_of_type_Ngw.c(paramInt1, paramAbsListView);
      break;
      if ((this.jdField_a_of_type_Ngw.jdField_a_of_type_ComTencentMobileqqDataAccountDetail == null) && (this.jdField_a_of_type_Ngw.jdField_a_of_type_ComTencentMobileqqDataEqqDetail == null)) {
        break;
      }
      this.jdField_a_of_type_Ngw.a(paramInt1, paramAbsListView);
      break;
      label224:
      this.jdField_a_of_type_Ngw.jdField_a_of_type_Nic.a();
      break label128;
      this.jdField_a_of_type_Ngw.c();
      if (this.jdField_a_of_type_Ngw.jdField_a_of_type_Nic == null) {
        break label128;
      }
      this.jdField_a_of_type_Ngw.jdField_a_of_type_Nic.a();
      break label128;
      paramInt1 = 0;
      break label154;
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0)
    {
      sff.a().c();
      if (!this.jdField_a_of_type_Ngw.e) {
        break label89;
      }
      ngw.a(this.jdField_a_of_type_Ngw, paramAbsListView.getLastVisiblePosition(), ngw.d());
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Ngw.getCount() - paramAbsListView.getLastVisiblePosition() < ngw.e()) && (this.jdField_a_of_type_Ngw.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.a)) {
        ngw.a(this.jdField_a_of_type_Ngw);
      }
      if ((paramAbsListView instanceof AccountDetailXListView)) {
        ((AccountDetailXListView)paramAbsListView).onScrollStateChanged(paramAbsListView, paramInt);
      }
      return;
      label89:
      ngw.a(this.jdField_a_of_type_Ngw, paramAbsListView.getFirstVisiblePosition() - ngw.d(), ngw.d());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     nhf
 * JD-Core Version:    0.7.0.1
 */