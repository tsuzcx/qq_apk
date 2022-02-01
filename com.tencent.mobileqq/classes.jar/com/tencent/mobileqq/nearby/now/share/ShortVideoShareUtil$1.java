package com.tencent.mobileqq.nearby.now.share;

import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener;
import com.tencent.qphone.base.util.QLog;

final class ShortVideoShareUtil$1
  implements ShareActionSheet.OnItemClickListener
{
  ShortVideoShareUtil$1(BaseActivity paramBaseActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, QQAppInterface paramQQAppInterface) {}
  
  public void onItemClick(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, ShareActionSheet paramShareActionSheet)
  {
    int i = paramActionSheetItem.action;
    paramShareActionSheet.dismiss();
    if (i != 2) {
      if (i != 3)
      {
        if (i != 9)
        {
          if (i != 10)
          {
            if (i != 72)
            {
              if (i != 73)
              {
                paramActionSheetItem = new StringBuilder();
                paramActionSheetItem.append("handleShareChatItemClick with invalid case:");
                paramActionSheetItem.append(i);
                QLog.e("ShortVideoShareUtil", 1, paramActionSheetItem.toString());
              }
            }
            else {
              ShortVideoShareUtil.a(this.a, this.b, this.c, this.d, this.e, this.f, false, paramActionSheetItem.uinType, paramActionSheetItem.uin);
            }
          }
          else {
            ShortVideoShareUtil.b(this.a, this.b, this.c, this.d, this.e, this.g, new ShortVideoShareUtil.1.2(this));
          }
        }
        else {
          ShortVideoShareUtil.a(this.a, this.b, this.c, this.d, this.e, this.g, new ShortVideoShareUtil.1.1(this));
        }
      }
      else
      {
        ShortVideoShareUtil.a(this.a, this.b, this.c, this.d, this.e, this.f);
        return;
      }
    }
    ShortVideoShareUtil.a(this.a, this.b, this.c, this.d, this.e, this.f, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.share.ShortVideoShareUtil.1
 * JD-Core Version:    0.7.0.1
 */