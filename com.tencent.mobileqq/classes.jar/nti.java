import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class nti
  implements AdapterView.OnItemClickListener
{
  public nti(AccountDetailActivity paramAccountDetailActivity) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject = paramView.getTag();
    if (localObject == null)
    {
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.isShowing()) {
      this.a.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.dismiss();
    }
    int i = ((bgsa)localObject).a.action;
    int j = oat.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.e, this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail);
    label103:
    String str;
    if (i == 11)
    {
      this.a.F();
      i = 7;
      str = this.a.e;
      if (!this.a.d()) {
        break label479;
      }
    }
    label479:
    for (localObject = "02";; localObject = "01")
    {
      oat.a(null, str, "0X8007CA6", "0X8007CA6", 0, 0, (String)localObject, i + "", j + "", null);
      break;
      if (i == 2)
      {
        aarp.b(this.a, this.a.a(), this.a.a(), this.a.b());
        i = 1;
        break label103;
      }
      if (i == 3)
      {
        aarp.a(this.a, this.a.a(), this.a.a(), this.a.b());
        i = 2;
        break label103;
      }
      if ((i == 9) || (i == 10))
      {
        aarp.a(this.a, this.a.a(), this.a.a(), this.a.b(), i);
        if (i == 9)
        {
          i = 3;
          break label103;
        }
        i = 4;
        break label103;
      }
      if (i == 31)
      {
        this.a.E();
        i = 6;
        break label103;
      }
      if (i == 30)
      {
        this.a.f();
        i = 5;
        break label103;
      }
      if (i == 32)
      {
        this.a.H();
        i = 8;
        break label103;
      }
      if (i == 19) {
        bjft.a(this.a, 6, this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name, this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.summary, this.a.i, "mqqapi://card/show_pslcard?src_type=internal&source=sharecard&version=1&uin=" + this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin, this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin, j, true);
      }
      i = 0;
      break label103;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nti
 * JD-Core Version:    0.7.0.1
 */