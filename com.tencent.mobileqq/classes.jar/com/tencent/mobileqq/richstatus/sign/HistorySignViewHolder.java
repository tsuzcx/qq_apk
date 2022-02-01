package com.tencent.mobileqq.richstatus.sign;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.comment.widget.CommentsView;
import com.tencent.mobileqq.richstatus.comment.widget.LikesView;

public class HistorySignViewHolder
  extends BaseSignViewHolder
{
  QQAppInterface a;
  public int b;
  public RichStatus c;
  public CheckBox d;
  public CommentsView e;
  public LikesView f;
  
  public HistorySignViewHolder(Context paramContext, AppInterface paramAppInterface, View paramView, String paramString)
  {
    super(paramContext, paramAppInterface, paramView, paramString);
    this.a = ((QQAppInterface)paramAppInterface);
    this.u = 1;
  }
  
  public View a(RichStatus paramRichStatus)
  {
    return super.a(paramRichStatus);
  }
  
  protected void a()
  {
    super.a();
    this.j.setMinimumHeight(0);
  }
  
  protected void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    Object localObject = this.e;
    int i;
    if (localObject != null)
    {
      if (paramBoolean) {
        i = N[14];
      } else {
        i = N[16];
      }
      ((CommentsView)localObject).setNormalTextColor(i);
      localObject = this.e;
      if (paramBoolean) {
        i = N[13];
      } else {
        i = N[15];
      }
      ((CommentsView)localObject).setItemColor(i);
    }
    localObject = this.f;
    if (localObject != null)
    {
      if (paramBoolean) {
        i = N[14];
      } else {
        i = N[15];
      }
      ((LikesView)localObject).setNormalTextColor(i);
      localObject = this.f;
      if (paramBoolean) {
        i = N[13];
      } else {
        i = N[15];
      }
      ((LikesView)localObject).setItemColor(i);
      localObject = this.f.getLikeSpanDrawable();
      if ((this.v != null) && (localObject != null))
      {
        LikesView localLikesView = this.f;
        if (paramBoolean) {
          localObject = this.v.getResources().getDrawable(2130849332);
        } else {
          localObject = this.v.getResources().getDrawable(2130849333);
        }
        localLikesView.setLikSpanDrawable((Drawable)localObject);
      }
    }
  }
  
  protected boolean o()
  {
    return true;
  }
  
  protected boolean p()
  {
    return false;
  }
  
  protected int q()
  {
    return N[12];
  }
  
  protected void s() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.sign.HistorySignViewHolder
 * JD-Core Version:    0.7.0.1
 */