package com.tencent.mobileqq.nearby.now.view;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.now.model.Comments.Comment;
import com.tencent.mobileqq.nearby.now.view.presenter.impl.CommentsPresenter;
import com.tencent.mobileqq.statistics.ReportController;

class ShortVideoCommentsView$9
  implements View.OnClickListener
{
  ShortVideoCommentsView$9(ShortVideoCommentsView paramShortVideoCommentsView) {}
  
  public void onClick(View paramView)
  {
    String str = ShortVideoCommentsView.access$400(this.a).getText().toString();
    if (str.equals(""))
    {
      paramView = this.a;
      paramView.showToast(paramView.getContext().getResources().getString(2131894150));
      return;
    }
    if (str.length() > 140)
    {
      paramView = this.a;
      paramView.showToast(paramView.getContext().getResources().getString(2131894151));
      return;
    }
    Comments.Comment localComment = new Comments.Comment();
    localComment.f = Long.parseLong(this.a.app.getCurrentAccountUin());
    localComment.g = "";
    paramView = BaseApplicationImpl.getApplication();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("self_info");
    ((StringBuilder)localObject).append(this.a.app.getCurrentAccountUin());
    localObject = paramView.getSharedPreferences(((StringBuilder)localObject).toString(), 4).getString("nick", "");
    paramView = (View)localObject;
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      paramView = this.a.app.getCurrentNickname();
    }
    localComment.e = paramView;
    localComment.b = str;
    localComment.c = (System.currentTimeMillis() / 1000L);
    localComment.o = ShortVideoCommentsView.access$700(this.a);
    if ((ShortVideoCommentsView.access$800(this.a) != null) && ((ShortVideoCommentsView.access$800(this.a).f > 0L) || (ShortVideoCommentsView.access$800(this.a).i > 0L)))
    {
      localComment.l = ShortVideoCommentsView.access$800(this.a).g;
      localComment.j = ShortVideoCommentsView.access$800(this.a).e;
      localComment.k = ShortVideoCommentsView.access$800(this.a).f;
      localComment.n = ShortVideoCommentsView.access$800(this.a).i;
      localComment.m = ShortVideoCommentsView.access$800(this.a).h;
    }
    ShortVideoCommentsView.access$900(this.a).a(localComment);
    ShortVideoCommentsView.access$1000(this.a, localComment);
    ReportController.b(this.a.app, "dc00899", "grp_lbs", "", "new_thing", "clk_reply", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.ShortVideoCommentsView.9
 * JD-Core Version:    0.7.0.1
 */