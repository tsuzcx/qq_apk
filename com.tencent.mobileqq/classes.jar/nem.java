import com.tencent.biz.pubaccount.AccountDetail.view.AccountDetailXListView;
import com.tencent.widget.AbsListView;

class nem
  implements bfob
{
  int jdField_a_of_type_Int;
  int b = (int)(2.0F * this.jdField_a_of_type_Ned.jdField_a_of_type_Float);
  
  nem(ned paramned) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_Ned.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.getFirstVisiblePosition() == 0)
    {
      paramInt1 = -this.jdField_a_of_type_Ned.b();
      paramAbsListView = this.jdField_a_of_type_Ned.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.getChildAt(0);
      if (this.jdField_a_of_type_Ned.c) {
        if (this.jdField_a_of_type_Ned.b)
        {
          paramInt2 = (int)(paramInt1 - 262.0F * this.jdField_a_of_type_Ned.jdField_a_of_type_Float);
          this.jdField_a_of_type_Ned.b(paramInt2, paramAbsListView);
          if ((this.jdField_a_of_type_Ned.jdField_a_of_type_Nfj != null) && (paramInt1 != 0))
          {
            if (paramInt1 >= this.jdField_a_of_type_Ned.o - 75.0F * this.jdField_a_of_type_Ned.jdField_a_of_type_Float) {
              break label224;
            }
            this.jdField_a_of_type_Ned.jdField_a_of_type_Nfj.a(false);
          }
          label128:
          paramInt2 = this.jdField_a_of_type_Ned.b();
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
    for (this.jdField_a_of_type_Ned.e = true;; this.jdField_a_of_type_Ned.e = false)
    {
      this.jdField_a_of_type_Int = paramInt2;
      return;
      this.jdField_a_of_type_Ned.c(paramInt1, paramAbsListView);
      break;
      if ((this.jdField_a_of_type_Ned.jdField_a_of_type_ComTencentMobileqqDataAccountDetail == null) && (this.jdField_a_of_type_Ned.jdField_a_of_type_ComTencentMobileqqDataEqqDetail == null)) {
        break;
      }
      this.jdField_a_of_type_Ned.a(paramInt1, paramAbsListView);
      break;
      label224:
      this.jdField_a_of_type_Ned.jdField_a_of_type_Nfj.a();
      break label128;
      this.jdField_a_of_type_Ned.c();
      if (this.jdField_a_of_type_Ned.jdField_a_of_type_Nfj == null) {
        break label128;
      }
      this.jdField_a_of_type_Ned.jdField_a_of_type_Nfj.a();
      break label128;
      paramInt1 = 0;
      break label154;
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0)
    {
      rpj.a().c();
      if (!this.jdField_a_of_type_Ned.e) {
        break label89;
      }
      ned.a(this.jdField_a_of_type_Ned, paramAbsListView.getLastVisiblePosition(), ned.d());
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Ned.getCount() - paramAbsListView.getLastVisiblePosition() < ned.e()) && (this.jdField_a_of_type_Ned.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.a)) {
        ned.a(this.jdField_a_of_type_Ned);
      }
      if ((paramAbsListView instanceof AccountDetailXListView)) {
        ((AccountDetailXListView)paramAbsListView).onScrollStateChanged(paramAbsListView, paramInt);
      }
      return;
      label89:
      ned.a(this.jdField_a_of_type_Ned, paramAbsListView.getFirstVisiblePosition() - ned.d(), ned.d());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nem
 * JD-Core Version:    0.7.0.1
 */