import com.tencent.biz.pubaccount.AccountDetail.view.AccountDetailXListView;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.qphone.base.util.QLog;

public class nvz
  extends amyh
{
  public nvz(AccountDetailActivity paramAccountDetailActivity) {}
  
  void a()
  {
    if (this.a.jdField_j_of_type_Boolean) {
      this.a.G();
    }
    this.a.jdField_j_of_type_Boolean = true;
  }
  
  public void onDynamicListGet(boolean paramBoolean, int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    super.onDynamicListGet(paramBoolean, paramInt);
    if (this.a.jdField_a_of_type_Nst == null) {
      return;
    }
    this.a.q = true;
    if (paramInt == 0)
    {
      ntn localntn = ntx.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.a.e);
      if (localntn != null)
      {
        this.a.jdField_a_of_type_Nst.a(localntn.b(), localntn.a);
        this.a.jdField_a_of_type_Nst.a(localntn.b());
      }
    }
    if (paramBoolean) {
      if (this.a.jdField_a_of_type_Nst.a() == 0)
      {
        paramBoolean = bool1;
        if (paramBoolean) {
          this.a.v();
        }
        this.a.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.b(paramBoolean);
        bool1 = paramBoolean;
        if (QLog.isColorLevel())
        {
          QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "onDynamicListGet: --hasMoreData=" + paramBoolean);
          bool1 = paramBoolean;
        }
        label172:
        if (paramInt != 1) {
          break label246;
        }
      }
    }
    for (this.a.l = AccountDetailActivity.jdField_j_of_type_Int;; this.a.l = AccountDetailActivity.k) {
      label246:
      do
      {
        this.a.jdField_a_of_type_Nst.b(this.a.l);
        this.a.jdField_a_of_type_Nst.notifyDataSetChanged();
        return;
        paramBoolean = true;
        break;
        this.a.jdField_a_of_type_Nst.notifyDataSetChanged();
        this.a.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.b();
        bool1 = bool2;
        break label172;
      } while ((paramInt != 4) && ((paramInt != 0) || (bool1)));
    }
  }
  
  public void onFollowPublicAccount(boolean paramBoolean, String paramString)
  {
    super.onFollowPublicAccount(paramBoolean, paramString);
    a();
  }
  
  public void onUnfollowPublicAccount(int paramInt, PublicAccountInfo paramPublicAccountInfo)
  {
    super.onUnfollowPublicAccount(paramInt, paramPublicAccountInfo);
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nvz
 * JD-Core Version:    0.7.0.1
 */