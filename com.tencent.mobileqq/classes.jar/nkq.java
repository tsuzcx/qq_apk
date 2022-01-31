import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;

public class nkq
  implements AdapterView.OnItemClickListener
{
  public nkq(AccountDetailActivity paramAccountDetailActivity) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = paramView.getTag();
    if (paramAdapterView == null) {
      return;
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.isShowing()) {
      this.a.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.dismiss();
    }
    paramInt = ((bdmy)paramAdapterView).a.action;
    int i = nrt.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.d, this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail);
    if (paramInt == 11)
    {
      this.a.E();
      paramInt = 7;
      paramView = this.a.d;
      if (!this.a.d()) {
        break label437;
      }
    }
    label437:
    for (paramAdapterView = "02";; paramAdapterView = "01")
    {
      nrt.a(null, paramView, "0X8007CA6", "0X8007CA6", 0, 0, paramAdapterView, paramInt + "", i + "", null);
      return;
      if (paramInt == 2)
      {
        yuq.b(this.a, this.a.a(), this.a.a(), this.a.b());
        paramInt = 1;
        break;
      }
      if (paramInt == 3)
      {
        yuq.a(this.a, this.a.a(), this.a.a(), this.a.b());
        paramInt = 2;
        break;
      }
      if ((paramInt == 9) || (paramInt == 10))
      {
        yuq.a(this.a, this.a.a(), this.a.a(), this.a.b(), paramInt);
        if (paramInt == 9)
        {
          paramInt = 3;
          break;
        }
        paramInt = 4;
        break;
      }
      if (paramInt == 31)
      {
        this.a.D();
        paramInt = 6;
        break;
      }
      if (paramInt == 30)
      {
        this.a.f();
        paramInt = 5;
        break;
      }
      if (paramInt == 32)
      {
        this.a.G();
        paramInt = 8;
        break;
      }
      if (paramInt == 19) {
        bfyh.a(this.a, 6, this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name, this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.summary, this.a.h, "mqqapi://card/show_pslcard?src_type=internal&source=sharecard&version=1&uin=" + this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin, this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin, i, true);
      }
      paramInt = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     nkq
 * JD-Core Version:    0.7.0.1
 */