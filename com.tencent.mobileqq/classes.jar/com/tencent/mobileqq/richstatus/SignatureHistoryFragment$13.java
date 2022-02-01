package com.tencent.mobileqq.richstatus;

import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.richstatus.comment.bean.CommentItem;
import com.tencent.mobileqq.richstatus.comment.bean.User;
import com.tencent.mobileqq.richstatus.comment.widget.CommentsView.OnItemLongClickListener;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.BubbleContextMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import java.util.List;

class SignatureHistoryFragment$13
  implements CommentsView.OnItemLongClickListener
{
  SignatureHistoryFragment$13(SignatureHistoryFragment paramSignatureHistoryFragment, HistorySignItem paramHistorySignItem) {}
  
  public void a(int paramInt, View paramView)
  {
    if (SignatureHistoryFragment.b(this.jdField_a_of_type_ComTencentMobileqqRichstatusSignatureHistoryFragment)) {
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqRichstatusHistorySignItem.commentItemList;
    if ((localObject != null) && (((List)localObject).size() > paramInt))
    {
      localObject = (CommentItem)((List)localObject).get(paramInt);
      User localUser = ((CommentItem)localObject).user;
      if ((localUser != null) && (!TextUtils.isEmpty(localUser.a)))
      {
        paramView.setSelected(true);
        QQCustomMenu localQQCustomMenu = new QQCustomMenu();
        SignatureHistoryFragment.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusSignatureHistoryFragment, (CommentItem)localObject);
        localQQCustomMenu.a(2131365311, this.jdField_a_of_type_ComTencentMobileqqRichstatusSignatureHistoryFragment.getString(2131691294), 0);
        if ((localUser.a.equals(SignatureHistoryFragment.b(this.jdField_a_of_type_ComTencentMobileqqRichstatusSignatureHistoryFragment))) || (Utils.a(SignatureHistoryFragment.b(this.jdField_a_of_type_ComTencentMobileqqRichstatusSignatureHistoryFragment), SignatureHistoryFragment.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusSignatureHistoryFragment)))) {
          localQQCustomMenu.a(2131365480, this.jdField_a_of_type_ComTencentMobileqqRichstatusSignatureHistoryFragment.getString(2131692630), 0);
        }
        BubbleContextMenu.a(paramView, localQQCustomMenu, this.jdField_a_of_type_ComTencentMobileqqRichstatusSignatureHistoryFragment, new SignatureHistoryFragment.13.1(this, paramView));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.SignatureHistoryFragment.13
 * JD-Core Version:    0.7.0.1
 */