package com.tencent.mobileqq.onlinestatus.olympic.helper;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener;
import com.tencent.qphone.base.util.QLog;

class OlympicShareActionSheetHelper$1
  implements ShareActionSheet.OnItemClickListener
{
  OlympicShareActionSheetHelper$1(OlympicShareActionSheetHelper paramOlympicShareActionSheetHelper, OlympicShareHelper.IShareFinishCallback paramIShareFinishCallback) {}
  
  public void onItemClick(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, ShareActionSheet paramShareActionSheet)
  {
    paramShareActionSheet.dismiss();
    paramShareActionSheet = new StringBuilder();
    paramShareActionSheet.append(" showMyQrCodeActionSheet() click item = ");
    paramShareActionSheet.append(paramActionSheetItem.action);
    QLog.d("OlympicShareActionSheetHelper", 2, paramShareActionSheet.toString());
    int i = paramActionSheetItem.action;
    if (i != 2)
    {
      if (i != 3)
      {
        if ((i != 9) && (i != 10))
        {
          if (i != 72) {
            return;
          }
          OlympicShareActionSheetHelper.a(this.b, paramActionSheetItem.uinType, paramActionSheetItem.uin, this.a);
          return;
        }
        OlympicShareActionSheetHelper.a(this.b, paramActionSheetItem.action, this.a);
        return;
      }
      this.b.b(this.a);
      return;
    }
    paramActionSheetItem = this.b;
    OlympicShareActionSheetHelper.a(paramActionSheetItem, paramActionSheetItem.b.getCurrentAccountUin(), this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.olympic.helper.OlympicShareActionSheetHelper.1
 * JD-Core Version:    0.7.0.1
 */