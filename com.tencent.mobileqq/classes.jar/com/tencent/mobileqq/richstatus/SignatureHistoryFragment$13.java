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
    if (SignatureHistoryFragment.k(this.b)) {
      return;
    }
    Object localObject = this.a.commentItemList;
    if ((localObject != null) && (((List)localObject).size() > paramInt))
    {
      localObject = (CommentItem)((List)localObject).get(paramInt);
      User localUser = ((CommentItem)localObject).user;
      if ((localUser != null) && (!TextUtils.isEmpty(localUser.a)))
      {
        paramView.setSelected(true);
        QQCustomMenu localQQCustomMenu = new QQCustomMenu();
        SignatureHistoryFragment.a(this.b, (CommentItem)localObject);
        localQQCustomMenu.a(2131431492, this.b.getString(2131888244), 0);
        if ((localUser.a.equals(SignatureHistoryFragment.h(this.b))) || (Utils.a(SignatureHistoryFragment.h(this.b), SignatureHistoryFragment.c(this.b)))) {
          localQQCustomMenu.a(2131431695, this.b.getString(2131889653), 0);
        }
        BubbleContextMenu.a(paramView, localQQCustomMenu, this.b, new SignatureHistoryFragment.13.1(this, paramView));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.SignatureHistoryFragment.13
 * JD-Core Version:    0.7.0.1
 */