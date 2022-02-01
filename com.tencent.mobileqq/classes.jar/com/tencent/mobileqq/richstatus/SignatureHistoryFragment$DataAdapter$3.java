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

class SignatureHistoryFragment$DataAdapter$3
  implements CommentsView.OnItemLongClickListener
{
  SignatureHistoryFragment$DataAdapter$3(SignatureHistoryFragment.DataAdapter paramDataAdapter, HistorySignItem paramHistorySignItem) {}
  
  public void a(int paramInt, View paramView)
  {
    if (SignatureHistoryFragment.b(this.jdField_a_of_type_ComTencentMobileqqRichstatusSignatureHistoryFragment$DataAdapter.a)) {}
    Object localObject;
    User localUser;
    do
    {
      do
      {
        return;
        localObject = this.jdField_a_of_type_ComTencentMobileqqRichstatusHistorySignItem.commentItemList;
      } while ((localObject == null) || (((List)localObject).size() <= paramInt));
      localObject = (CommentItem)((List)localObject).get(paramInt);
      localUser = ((CommentItem)localObject).user;
    } while ((localUser == null) || (TextUtils.isEmpty(localUser.a)));
    paramView.setSelected(true);
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    SignatureHistoryFragment.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusSignatureHistoryFragment$DataAdapter.a, (CommentItem)localObject);
    localQQCustomMenu.a(2131365448, this.jdField_a_of_type_ComTencentMobileqqRichstatusSignatureHistoryFragment$DataAdapter.a.getString(2131691372), 0);
    if ((localUser.a.equals(SignatureHistoryFragment.b(this.jdField_a_of_type_ComTencentMobileqqRichstatusSignatureHistoryFragment$DataAdapter.a))) || (Utils.a(SignatureHistoryFragment.b(this.jdField_a_of_type_ComTencentMobileqqRichstatusSignatureHistoryFragment$DataAdapter.a), SignatureHistoryFragment.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusSignatureHistoryFragment$DataAdapter.a)))) {
      localQQCustomMenu.a(2131365636, this.jdField_a_of_type_ComTencentMobileqqRichstatusSignatureHistoryFragment$DataAdapter.a.getString(2131692673), 0);
    }
    BubbleContextMenu.a(paramView, localQQCustomMenu, this.jdField_a_of_type_ComTencentMobileqqRichstatusSignatureHistoryFragment$DataAdapter.a, new SignatureHistoryFragment.DataAdapter.3.1(this, paramView));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.SignatureHistoryFragment.DataAdapter.3
 * JD-Core Version:    0.7.0.1
 */