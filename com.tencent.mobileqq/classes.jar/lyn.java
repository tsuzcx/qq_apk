import android.content.Context;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;

class lyn
  implements ShareActionSheet.OnItemClickListener
{
  long jdField_a_of_type_Long = 0L;
  Context jdField_a_of_type_AndroidContentContext;
  
  public lyn(lyh paramlyh, Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public void onItemClick(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, ShareActionSheet paramShareActionSheet)
  {
    paramShareActionSheet = this.jdField_a_of_type_AndroidContentContext;
    if (this.jdField_a_of_type_AndroidContentContext == null) {}
    do
    {
      return;
      if (this.jdField_a_of_type_Lyh.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet != null) {
        this.jdField_a_of_type_Lyh.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.dismiss();
      }
    } while (this.jdField_a_of_type_Lyh.jdField_a_of_type_Lym == null);
    int i;
    int j;
    switch (paramActionSheetItem.action)
    {
    default: 
      return;
    case 1: 
      i = 4;
      this.jdField_a_of_type_Lyh.jdField_a_of_type_Int = i;
      if ((i == 2) || (i == 3)) {
        if (!WXShareHelper.getInstance().isWXinstalled()) {
          j = 2131719722;
        }
      }
      break;
    }
    for (;;)
    {
      if (j != -1)
      {
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getString(j), 0).a();
        this.jdField_a_of_type_Lyh.a(this.jdField_a_of_type_Lyh.jdField_a_of_type_Int, this.jdField_a_of_type_Lyh.b, 3);
        return;
        i = 0;
        break;
        i = 72;
        break;
        i = 73;
        break;
        i = 1;
        break;
        i = 3;
        break;
        i = 2;
        break;
        i = 5;
        break;
        i = 7;
        break;
        i = 26;
        break;
        i = 6;
        break;
        if (WXShareHelper.getInstance().isWXsupportApi()) {
          break label414;
        }
        j = 2131719723;
        continue;
      }
      QLog.w("ShareChat", 1, "onItemClick, mChoosedChannel[" + this.jdField_a_of_type_Lyh.jdField_a_of_type_Int + "], position[], id[" + i + "], seq[" + this.jdField_a_of_type_Long + "], mChoosedLinkType[" + this.jdField_a_of_type_Lyh.b + "]");
      if (this.jdField_a_of_type_Lyh.b == -1)
      {
        this.jdField_a_of_type_Lyh.c(this.jdField_a_of_type_Long, paramShareActionSheet, paramActionSheetItem);
        return;
      }
      this.jdField_a_of_type_Lyh.a(this.jdField_a_of_type_Long, paramShareActionSheet, paramActionSheetItem);
      return;
      label414:
      j = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lyn
 * JD-Core Version:    0.7.0.1
 */