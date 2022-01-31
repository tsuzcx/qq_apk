import com.tencent.biz.pubaccount.AccountDetail.view.AccountDetailXListView;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.qphone.base.util.QLog;

public class mwg
  extends ajpe
{
  public mwg(AccountDetailActivity paramAccountDetailActivity) {}
  
  void a()
  {
    if (this.a.jdField_j_of_type_Boolean) {
      this.a.F();
    }
    this.a.jdField_j_of_type_Boolean = true;
  }
  
  public void a(int paramInt, PublicAccountInfo paramPublicAccountInfo)
  {
    super.a(paramInt, paramPublicAccountInfo);
    a();
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    super.a(paramBoolean, paramInt);
    if (this.a.jdField_a_of_type_Mtc == null) {
      return;
    }
    this.a.r = true;
    if (paramInt == 0)
    {
      mtv localmtv = muf.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.a.d);
      if (localmtv != null)
      {
        this.a.jdField_a_of_type_Mtc.a(localmtv.b(), localmtv.a);
        this.a.jdField_a_of_type_Mtc.a(localmtv.b());
      }
    }
    if (paramBoolean) {
      if (this.a.jdField_a_of_type_Mtc.a() == 0)
      {
        paramBoolean = bool1;
        if (paramBoolean) {
          this.a.u();
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
        this.a.jdField_a_of_type_Mtc.b(this.a.l);
        this.a.jdField_a_of_type_Mtc.notifyDataSetChanged();
        return;
        paramBoolean = true;
        break;
        this.a.jdField_a_of_type_Mtc.notifyDataSetChanged();
        this.a.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.b();
        bool1 = bool2;
        break label172;
      } while ((paramInt != 4) && ((paramInt != 0) || (bool1)));
    }
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    super.a(paramBoolean, paramString);
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mwg
 * JD-Core Version:    0.7.0.1
 */