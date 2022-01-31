import com.tencent.biz.pubaccount.AccountDetail.view.AccountDetailXListView;
import com.tencent.widget.AbsListView;

class mtl
  implements begh
{
  int jdField_a_of_type_Int;
  int b = (int)(2.0F * this.jdField_a_of_type_Mtc.jdField_a_of_type_Float);
  
  mtl(mtc parammtc) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_Mtc.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.getFirstVisiblePosition() == 0)
    {
      paramInt1 = -this.jdField_a_of_type_Mtc.b();
      paramAbsListView = this.jdField_a_of_type_Mtc.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.getChildAt(0);
      if (this.jdField_a_of_type_Mtc.c) {
        if (this.jdField_a_of_type_Mtc.b)
        {
          paramInt2 = (int)(paramInt1 - 262.0F * this.jdField_a_of_type_Mtc.jdField_a_of_type_Float);
          this.jdField_a_of_type_Mtc.b(paramInt2, paramAbsListView);
          if ((this.jdField_a_of_type_Mtc.jdField_a_of_type_Mui != null) && (paramInt1 != 0))
          {
            if (paramInt1 >= this.jdField_a_of_type_Mtc.o - 75.0F * this.jdField_a_of_type_Mtc.jdField_a_of_type_Float) {
              break label224;
            }
            this.jdField_a_of_type_Mtc.jdField_a_of_type_Mui.a(false);
          }
          label128:
          paramInt2 = this.jdField_a_of_type_Mtc.b();
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
    for (this.jdField_a_of_type_Mtc.e = true;; this.jdField_a_of_type_Mtc.e = false)
    {
      this.jdField_a_of_type_Int = paramInt2;
      return;
      this.jdField_a_of_type_Mtc.c(paramInt1, paramAbsListView);
      break;
      if ((this.jdField_a_of_type_Mtc.jdField_a_of_type_ComTencentMobileqqDataAccountDetail == null) && (this.jdField_a_of_type_Mtc.jdField_a_of_type_ComTencentMobileqqDataEqqDetail == null)) {
        break;
      }
      this.jdField_a_of_type_Mtc.a(paramInt1, paramAbsListView);
      break;
      label224:
      this.jdField_a_of_type_Mtc.jdField_a_of_type_Mui.a();
      break label128;
      this.jdField_a_of_type_Mtc.c();
      if (this.jdField_a_of_type_Mtc.jdField_a_of_type_Mui == null) {
        break label128;
      }
      this.jdField_a_of_type_Mtc.jdField_a_of_type_Mui.a();
      break label128;
      paramInt1 = 0;
      break label154;
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0)
    {
      rcv.a().c();
      if (!this.jdField_a_of_type_Mtc.e) {
        break label89;
      }
      mtc.a(this.jdField_a_of_type_Mtc, paramAbsListView.getLastVisiblePosition(), mtc.d());
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Mtc.getCount() - paramAbsListView.getLastVisiblePosition() < mtc.e()) && (this.jdField_a_of_type_Mtc.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.a)) {
        mtc.a(this.jdField_a_of_type_Mtc);
      }
      if ((paramAbsListView instanceof AccountDetailXListView)) {
        ((AccountDetailXListView)paramAbsListView).onScrollStateChanged(paramAbsListView, paramInt);
      }
      return;
      label89:
      mtc.a(this.jdField_a_of_type_Mtc, paramAbsListView.getFirstVisiblePosition() - mtc.d(), mtc.d());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mtl
 * JD-Core Version:    0.7.0.1
 */