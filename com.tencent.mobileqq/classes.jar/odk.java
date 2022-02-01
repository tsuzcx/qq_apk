import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItemViewHolder;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class odk
  implements AdapterView.OnItemClickListener
{
  public odk(AccountDetailActivity paramAccountDetailActivity) {}
  
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
    int i = ((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject).sheetItem.action;
    int j = olh.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.e, this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail);
    label168:
    label171:
    String str;
    switch (i)
    {
    default: 
      i = 0;
      str = this.a.e;
      if (!this.a.d()) {
        break;
      }
    }
    for (localObject = "02";; localObject = "01")
    {
      olh.a(null, str, "0X8007CA6", "0X8007CA6", 0, 0, (String)localObject, i + "", j + "", null);
      break;
      aahr.b(this.a, this.a.a(), this.a.a(), this.a.b());
      i = 1;
      break label171;
      aahr.a(this.a, this.a.a(), this.a.a(), this.a.b());
      i = 2;
      break label171;
      aahr.a(this.a, this.a.a(), this.a.a(), this.a.b(), i);
      i = 3;
      break label171;
      aahr.a(this.a, this.a.a(), this.a.a(), this.a.b(), i);
      i = 4;
      break label171;
      this.a.f();
      i = 5;
      break label171;
      this.a.E();
      i = 6;
      break label171;
      this.a.F();
      i = 7;
      break label171;
      this.a.H();
      i = 8;
      break label171;
      bjxa.a(this.a, 6, this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name, this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.summary, this.a.i, "mqqapi://card/show_pslcard?src_type=internal&source=sharecard&version=1&uin=" + this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin, this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin, j, true);
      break label168;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     odk
 * JD-Core Version:    0.7.0.1
 */