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

class SignatureHistoryFragment$12
  implements CommentsView.OnItemClickListener
{
  SignatureHistoryFragment$12(SignatureHistoryFragment paramSignatureHistoryFragment, HistorySignItem paramHistorySignItem) {}
  
  public void a(int paramInt, View paramView)
  {
    if (SignatureHistoryFragment.b(this.jdField_a_of_type_ComTencentMobileqqRichstatusSignatureHistoryFragment)) {
      return;
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqRichstatusHistorySignItem.commentItemList;
    if ((localObject1 != null) && (((List)localObject1).size() > paramInt))
    {
      localObject1 = (CommentItem)((List)localObject1).get(paramInt);
      Object localObject2 = ((CommentItem)localObject1).user;
      if ((localObject2 != null) && (!TextUtils.isEmpty(((User)localObject2).a)))
      {
        if (((User)localObject2).a.equals(SignatureHistoryFragment.b(this.jdField_a_of_type_ComTencentMobileqqRichstatusSignatureHistoryFragment)))
        {
          paramView = this.jdField_a_of_type_ComTencentMobileqqRichstatusSignatureHistoryFragment;
          SignatureHistoryFragment.a(paramView, (CommentItem)localObject1, SignatureHistoryFragment.b(paramView));
          return;
        }
        SignatureHistoryFragment.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusSignatureHistoryFragment).setVisibility(0);
        SignatureHistoryFragment.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusSignatureHistoryFragment).setVisibility(0);
        SignatureHistoryFragment.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusSignatureHistoryFragment).requestFocus();
        SignatureHistoryFragment.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusSignatureHistoryFragment).setHint(String.format(this.jdField_a_of_type_ComTencentMobileqqRichstatusSignatureHistoryFragment.getString(2131689890), new Object[] { this.jdField_a_of_type_ComTencentMobileqqRichstatusSignatureHistoryFragment.a(((User)localObject2).a) }));
        SignatureHistoryFragment.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusSignatureHistoryFragment, true);
        paramInt = SignatureHistoryFragment.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusSignatureHistoryFragment, paramView);
        int i = paramView.getHeight();
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqRichstatusSignatureHistoryFragment;
        ((SignatureHistoryFragment)localObject2).jdField_a_of_type_AndroidViewView = paramView;
        SignatureHistoryFragment.a((SignatureHistoryFragment)localObject2).postDelayed(new SignatureHistoryFragment.12.1(this, paramInt, i), 200L);
        SignatureHistoryFragment.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusSignatureHistoryFragment, new CommentItem());
        SignatureHistoryFragment.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusSignatureHistoryFragment).targetId = ((CommentItem)localObject1).id;
        SignatureHistoryFragment.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusSignatureHistoryFragment).feedId = ((CommentItem)localObject1).feedId;
        SignatureHistoryFragment.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusSignatureHistoryFragment).toReplyUser = ((CommentItem)localObject1).user;
        SignatureHistoryFragment.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusSignatureHistoryFragment).user = new User(SignatureHistoryFragment.b(this.jdField_a_of_type_ComTencentMobileqqRichstatusSignatureHistoryFragment), this.jdField_a_of_type_ComTencentMobileqqRichstatusSignatureHistoryFragment.jdField_a_of_type_ComTencentMobileqqAppSignatureHandler.a(Long.valueOf(SignatureHistoryFragment.b(this.jdField_a_of_type_ComTencentMobileqqRichstatusSignatureHistoryFragment)).longValue()));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.SignatureHistoryFragment.12
 * JD-Core Version:    0.7.0.1
 */