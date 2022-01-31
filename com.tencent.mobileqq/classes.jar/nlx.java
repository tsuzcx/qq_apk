import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.biz.qqstory.newshare.ui.ActionSheetShareUI;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItemViewHolder;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.widget.ActionSheet;

public class nlx
  implements AdapterView.OnItemClickListener
{
  public nlx(ActionSheetShareUI paramActionSheetShareUI) {}
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (ActionSheetShareUI.a(this.a).a().isShowing()) {
      ActionSheetShareUI.a(this.a).a().dismiss();
    }
    int i = ((ShareActionSheetBuilder.ActionSheetItemViewHolder)paramView.getTag()).a.c;
    if ((i == 9) || (i == 10)) {
      if (!WXShareHelper.a().a()) {
        paramInt = 2131435335;
      }
    }
    for (;;)
    {
      if (paramInt != -1)
      {
        QRUtils.a(1, paramInt);
        return;
        if (!WXShareHelper.a().b()) {
          paramInt = 2131435336;
        }
      }
      else
      {
        this.a.a(i);
        return;
      }
      paramInt = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nlx
 * JD-Core Version:    0.7.0.1
 */