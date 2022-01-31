import com.tencent.biz.pubaccount.AccountDetail.adapter.AccountDetailBaseAdapter;
import com.tencent.biz.pubaccount.AccountDetail.model.AccountDetailVideoManager;
import com.tencent.biz.pubaccount.AccountDetail.view.AccountDetailXListView;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ImageManager;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;

public class kpr
  implements AbsListView.OnScrollListener
{
  int jdField_a_of_type_Int;
  int b = (int)(2.0F * this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailAdapterAccountDetailBaseAdapter.jdField_a_of_type_Float);
  
  public kpr(AccountDetailBaseAdapter paramAccountDetailBaseAdapter) {}
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0)
    {
      ImageManager.a().c();
      if (!this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailAdapterAccountDetailBaseAdapter.e) {
        break label89;
      }
      AccountDetailBaseAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailAdapterAccountDetailBaseAdapter, paramAbsListView.getLastVisiblePosition(), AccountDetailBaseAdapter.d());
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailAdapterAccountDetailBaseAdapter.getCount() - paramAbsListView.getLastVisiblePosition() < AccountDetailBaseAdapter.e()) && (this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailAdapterAccountDetailBaseAdapter.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.a)) {
        AccountDetailBaseAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailAdapterAccountDetailBaseAdapter);
      }
      if ((paramAbsListView instanceof AccountDetailXListView)) {
        ((AccountDetailXListView)paramAbsListView).a(paramAbsListView, paramInt);
      }
      return;
      label89:
      AccountDetailBaseAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailAdapterAccountDetailBaseAdapter, paramAbsListView.getFirstVisiblePosition() - AccountDetailBaseAdapter.d(), AccountDetailBaseAdapter.d());
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailAdapterAccountDetailBaseAdapter.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.getFirstVisiblePosition() == 0)
    {
      paramInt1 = -this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailAdapterAccountDetailBaseAdapter.b();
      paramAbsListView = this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailAdapterAccountDetailBaseAdapter.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.getChildAt(0);
      if (this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailAdapterAccountDetailBaseAdapter.c) {
        if (this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailAdapterAccountDetailBaseAdapter.b)
        {
          paramInt2 = (int)(paramInt1 - 262.0F * this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailAdapterAccountDetailBaseAdapter.jdField_a_of_type_Float);
          this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailAdapterAccountDetailBaseAdapter.b(paramInt2, paramAbsListView);
          if ((this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailAdapterAccountDetailBaseAdapter.jdField_a_of_type_ComTencentBizPubaccountAccountDetailModelAccountDetailVideoManager != null) && (paramInt1 != 0))
          {
            if (paramInt1 >= this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailAdapterAccountDetailBaseAdapter.o - 75.0F * this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailAdapterAccountDetailBaseAdapter.jdField_a_of_type_Float) {
              break label224;
            }
            this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailAdapterAccountDetailBaseAdapter.jdField_a_of_type_ComTencentBizPubaccountAccountDetailModelAccountDetailVideoManager.a(false);
          }
          label128:
          paramInt2 = this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailAdapterAccountDetailBaseAdapter.b();
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
    for (this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailAdapterAccountDetailBaseAdapter.e = true;; this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailAdapterAccountDetailBaseAdapter.e = false)
    {
      this.jdField_a_of_type_Int = paramInt2;
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailAdapterAccountDetailBaseAdapter.c(paramInt1, paramAbsListView);
      break;
      if ((this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailAdapterAccountDetailBaseAdapter.jdField_a_of_type_ComTencentMobileqqDataAccountDetail == null) && (this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailAdapterAccountDetailBaseAdapter.jdField_a_of_type_ComTencentMobileqqDataEqqDetail == null)) {
        break;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailAdapterAccountDetailBaseAdapter.a(paramInt1, paramAbsListView);
      break;
      label224:
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailAdapterAccountDetailBaseAdapter.jdField_a_of_type_ComTencentBizPubaccountAccountDetailModelAccountDetailVideoManager.a();
      break label128;
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailAdapterAccountDetailBaseAdapter.c();
      if (this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailAdapterAccountDetailBaseAdapter.jdField_a_of_type_ComTencentBizPubaccountAccountDetailModelAccountDetailVideoManager == null) {
        break label128;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailAdapterAccountDetailBaseAdapter.jdField_a_of_type_ComTencentBizPubaccountAccountDetailModelAccountDetailVideoManager.a();
      break label128;
      paramInt1 = 0;
      break label154;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kpr
 * JD-Core Version:    0.7.0.1
 */