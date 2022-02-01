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
    if (SignatureHistoryFragment.k(this.b)) {
      return;
    }
    Object localObject1 = this.a.commentItemList;
    if ((localObject1 != null) && (((List)localObject1).size() > paramInt))
    {
      localObject1 = (CommentItem)((List)localObject1).get(paramInt);
      Object localObject2 = ((CommentItem)localObject1).user;
      if ((localObject2 != null) && (!TextUtils.isEmpty(((User)localObject2).a)))
      {
        if (((User)localObject2).a.equals(SignatureHistoryFragment.h(this.b)))
        {
          paramView = this.b;
          SignatureHistoryFragment.a(paramView, (CommentItem)localObject1, SignatureHistoryFragment.h(paramView));
          return;
        }
        SignatureHistoryFragment.l(this.b).setVisibility(0);
        SignatureHistoryFragment.m(this.b).setVisibility(0);
        SignatureHistoryFragment.a(this.b).requestFocus();
        SignatureHistoryFragment.a(this.b).setHint(String.format(this.b.getString(2131886531), new Object[] { this.b.a(((User)localObject2).a) }));
        SignatureHistoryFragment.a(this.b, true);
        paramInt = SignatureHistoryFragment.b(this.b, paramView);
        int i = paramView.getHeight();
        localObject2 = this.b;
        ((SignatureHistoryFragment)localObject2).c = paramView;
        SignatureHistoryFragment.d((SignatureHistoryFragment)localObject2).postDelayed(new SignatureHistoryFragment.12.1(this, paramInt, i), 200L);
        SignatureHistoryFragment.a(this.b, new CommentItem());
        SignatureHistoryFragment.n(this.b).targetId = ((CommentItem)localObject1).id;
        SignatureHistoryFragment.n(this.b).feedId = ((CommentItem)localObject1).feedId;
        SignatureHistoryFragment.n(this.b).toReplyUser = ((CommentItem)localObject1).user;
        SignatureHistoryFragment.n(this.b).user = new User(SignatureHistoryFragment.h(this.b), this.b.d.b(Long.valueOf(SignatureHistoryFragment.h(this.b)).longValue()));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.SignatureHistoryFragment.12
 * JD-Core Version:    0.7.0.1
 */