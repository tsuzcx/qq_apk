package com.tencent.mobileqq.richstatus;

import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.app.SignatureHandler;
import com.tencent.mobileqq.richstatus.comment.bean.CommentItem;
import com.tencent.mobileqq.richstatus.comment.bean.User;
import com.tencent.mobileqq.richstatus.comment.widget.CommentsView.OnItemClickListener;
import java.util.List;

class SignatureHistoryFragment$DataAdapter$2
  implements CommentsView.OnItemClickListener
{
  SignatureHistoryFragment$DataAdapter$2(SignatureHistoryFragment.DataAdapter paramDataAdapter, HistorySignItem paramHistorySignItem) {}
  
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
    if (localUser.a.equals(SignatureHistoryFragment.b(this.jdField_a_of_type_ComTencentMobileqqRichstatusSignatureHistoryFragment$DataAdapter.a)))
    {
      SignatureHistoryFragment.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusSignatureHistoryFragment$DataAdapter.a, (CommentItem)localObject, SignatureHistoryFragment.b(this.jdField_a_of_type_ComTencentMobileqqRichstatusSignatureHistoryFragment$DataAdapter.a));
      return;
    }
    SignatureHistoryFragment.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusSignatureHistoryFragment$DataAdapter.a).setVisibility(0);
    SignatureHistoryFragment.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusSignatureHistoryFragment$DataAdapter.a).setVisibility(0);
    SignatureHistoryFragment.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusSignatureHistoryFragment$DataAdapter.a).requestFocus();
    SignatureHistoryFragment.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusSignatureHistoryFragment$DataAdapter.a).setHint(String.format(this.jdField_a_of_type_ComTencentMobileqqRichstatusSignatureHistoryFragment$DataAdapter.a.getString(2131689975), new Object[] { this.jdField_a_of_type_ComTencentMobileqqRichstatusSignatureHistoryFragment$DataAdapter.a.a(localUser.a) }));
    SignatureHistoryFragment.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusSignatureHistoryFragment$DataAdapter.a, true);
    paramInt = SignatureHistoryFragment.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusSignatureHistoryFragment$DataAdapter.a, paramView);
    int i = paramView.getHeight();
    this.jdField_a_of_type_ComTencentMobileqqRichstatusSignatureHistoryFragment$DataAdapter.a.jdField_a_of_type_AndroidViewView = paramView;
    SignatureHistoryFragment.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusSignatureHistoryFragment$DataAdapter.a).postDelayed(new SignatureHistoryFragment.DataAdapter.2.1(this, paramInt, i), 200L);
    SignatureHistoryFragment.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusSignatureHistoryFragment$DataAdapter.a, new CommentItem());
    SignatureHistoryFragment.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusSignatureHistoryFragment$DataAdapter.a).targetId = ((CommentItem)localObject).id;
    SignatureHistoryFragment.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusSignatureHistoryFragment$DataAdapter.a).feedId = ((CommentItem)localObject).feedId;
    SignatureHistoryFragment.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusSignatureHistoryFragment$DataAdapter.a).toReplyUser = ((CommentItem)localObject).user;
    SignatureHistoryFragment.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusSignatureHistoryFragment$DataAdapter.a).user = new User(SignatureHistoryFragment.b(this.jdField_a_of_type_ComTencentMobileqqRichstatusSignatureHistoryFragment$DataAdapter.a), this.jdField_a_of_type_ComTencentMobileqqRichstatusSignatureHistoryFragment$DataAdapter.a.jdField_a_of_type_ComTencentMobileqqAppSignatureHandler.a(Long.valueOf(SignatureHistoryFragment.b(this.jdField_a_of_type_ComTencentMobileqqRichstatusSignatureHistoryFragment$DataAdapter.a)).longValue()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.SignatureHistoryFragment.DataAdapter.2
 * JD-Core Version:    0.7.0.1
 */