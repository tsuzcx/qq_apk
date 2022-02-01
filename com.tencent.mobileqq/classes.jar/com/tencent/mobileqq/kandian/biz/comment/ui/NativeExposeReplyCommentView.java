package com.tencent.mobileqq.kandian.biz.comment.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentListAdapter;
import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyLinkMovementMethod;
import com.tencent.mobileqq.kandian.biz.comment.data.CommentViewItem;
import com.tencent.mobileqq.kandian.biz.comment.entity.CommentData;
import com.tencent.mobileqq.kandian.biz.comment.entity.SubCommentData;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import java.util.List;

public class NativeExposeReplyCommentView
  extends FrameLayout
  implements View.OnClickListener, IView
{
  private static String a = "NativeExposeReplyCommentView";
  private Context b;
  private LinearLayout c;
  private TextView d;
  private TextView e;
  private LinearLayout f;
  private TextView g;
  private TextView h;
  private LinearLayout i;
  private TextView j;
  private ReadInJoyCommentListAdapter k;
  private CommentViewItem l;
  private View m;
  private View n;
  
  public NativeExposeReplyCommentView(Context paramContext)
  {
    super(paramContext);
    this.b = paramContext;
    a();
  }
  
  public NativeExposeReplyCommentView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.b = paramContext;
    a();
  }
  
  public NativeExposeReplyCommentView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.b = paramContext;
    a();
  }
  
  private SubCommentData a(CommentViewItem paramCommentViewItem, int paramInt)
  {
    if ((paramCommentViewItem != null) && ((paramCommentViewItem.c instanceof CommentData)))
    {
      paramCommentViewItem = (CommentData)paramCommentViewItem.c;
      if ((paramCommentViewItem.subCommentList != null) && (paramCommentViewItem.subCommentList.size() > paramInt)) {
        return (SubCommentData)paramCommentViewItem.subCommentList.get(paramInt);
      }
    }
    return null;
  }
  
  private void a()
  {
    inflate(this.b, 2131626228, this);
    this.c = ((LinearLayout)findViewById(2131433197));
    this.d = ((TextView)findViewById(2131433209));
    this.e = ((TextView)findViewById(2131433210));
    this.f = ((LinearLayout)findViewById(2131445473));
    this.g = ((TextView)findViewById(2131445480));
    this.h = ((TextView)findViewById(2131445481));
    this.i = ((LinearLayout)findViewById(2131444650));
    this.j = ((TextView)findViewById(2131444649));
    this.m = findViewById(2131433211);
    this.n = findViewById(2131445482);
  }
  
  private void a(int paramInt)
  {
    int i3 = 0;
    int i2 = 4;
    int i1;
    if (paramInt > 1)
    {
      i1 = i3;
      if (paramInt > 2)
      {
        i2 = 0;
        i1 = i3;
      }
    }
    else
    {
      i1 = 4;
    }
    this.m.setVisibility(i1);
    this.n.setVisibility(i2);
  }
  
  private void b()
  {
    if (!(this.l.c instanceof CommentData)) {
      return;
    }
    if (((CommentData)this.l.c).subCommentNum < 3) {
      return;
    }
    LinearLayout localLinearLayout = this.c;
    localLinearLayout.setOnTouchListener(new NativeExposeReplyCommentView.OnCommentTouchListener(this.b, localLinearLayout));
    this.e.setOnTouchListener(new NativeExposeReplyCommentView.OnCommentTouchListener(this.b, this.c));
    localLinearLayout = this.f;
    localLinearLayout.setOnTouchListener(new NativeExposeReplyCommentView.OnCommentTouchListener(this.b, localLinearLayout));
    this.h.setOnTouchListener(new NativeExposeReplyCommentView.OnCommentTouchListener(this.b, this.f));
  }
  
  private void setVIcon(TextView paramTextView)
  {
    Drawable localDrawable = getResources().getDrawable(2130851368);
    localDrawable.setBounds(0, 0, localDrawable.getMinimumWidth(), localDrawable.getMinimumHeight());
    paramTextView.setCompoundDrawables(null, null, localDrawable, null);
  }
  
  public void a(CommentViewItem paramCommentViewItem)
  {
    if (paramCommentViewItem != null)
    {
      if (paramCommentViewItem.c == null) {
        return;
      }
      if (!(paramCommentViewItem.c instanceof CommentData)) {
        return;
      }
      CommentData localCommentData = (CommentData)paramCommentViewItem.c;
      if (!paramCommentViewItem.b())
      {
        setVisibility(8);
        return;
      }
      this.l = paramCommentViewItem;
      setVisibility(0);
      Object localObject = paramCommentViewItem.g;
      this.c.setVisibility(8);
      this.f.setVisibility(8);
      this.f.setOnClickListener(null);
      this.c.setOnClickListener(null);
      int i2 = ((List)localObject).size();
      int i1 = 0;
      while (i1 < i2)
      {
        if (i1 == 0)
        {
          this.d.setText((CharSequence)paramCommentViewItem.g.get(i1));
          this.d.setMovementMethod(ReadInJoyLinkMovementMethod.a());
          this.e.setText((CharSequence)paramCommentViewItem.h.get(i1));
          this.e.setMovementMethod(ReadInJoyLinkMovementMethod.a());
          this.c.setVisibility(0);
          this.e.setOnClickListener(this);
          this.c.setOnClickListener(this);
        }
        else if (i1 == 1)
        {
          this.g.setText((CharSequence)paramCommentViewItem.g.get(i1));
          this.g.setMovementMethod(ReadInJoyLinkMovementMethod.a());
          this.h.setText((CharSequence)paramCommentViewItem.h.get(i1));
          this.h.setMovementMethod(ReadInJoyLinkMovementMethod.a());
          this.f.setVisibility(0);
          this.h.setOnClickListener(this);
          this.f.setOnClickListener(this);
        }
        i1 += 1;
      }
      if (localCommentData.subCommentNum > 2)
      {
        paramCommentViewItem = this.j;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(HardCodeUtil.a(2131904946));
        ((StringBuilder)localObject).append(ReadInJoyHelper.a(localCommentData.subCommentNum, 99989500L, "9999万+", "0"));
        ((StringBuilder)localObject).append(HardCodeUtil.a(2131904945));
        paramCommentViewItem.setText(((StringBuilder)localObject).toString());
        this.i.setVisibility(0);
        this.i.setOnClickListener(this);
      }
      else
      {
        this.i.setVisibility(8);
        this.i.setOnClickListener(null);
      }
      b();
      a(localCommentData.subCommentNum);
    }
  }
  
  public void comLayout(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    onComLayout(true, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public int getComMeasuredHeight()
  {
    return getMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return getMeasuredWidth();
  }
  
  public void measureComponent(int paramInt1, int paramInt2)
  {
    onComMeasure(paramInt1, paramInt2);
  }
  
  public void onClick(View paramView)
  {
    if (this.k != null)
    {
      CommentViewItem localCommentViewItem = this.l;
      if (localCommentViewItem == null) {
        return;
      }
      if (!(localCommentViewItem.c instanceof CommentData)) {
        return;
      }
      switch (paramView.getId())
      {
      default: 
        return;
      case 2131445473: 
      case 2131445481: 
        this.f.setBackgroundResource(2130844021);
        paramView = this.k;
        localCommentViewItem = this.l;
        paramView.a(localCommentViewItem, a(localCommentViewItem, 1), 2);
        return;
      case 2131444650: 
        this.k.a(this.l, null, 1);
        return;
      }
      this.c.setBackgroundResource(2130844021);
      paramView = this.k;
      localCommentViewItem = this.l;
      paramView.a(localCommentViewItem, a(localCommentViewItem, 0), 2);
    }
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    layout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    measure(paramInt1, paramInt2);
  }
  
  public void setAdapter(ReadInJoyCommentListAdapter paramReadInJoyCommentListAdapter)
  {
    this.k = paramReadInJoyCommentListAdapter;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.ui.NativeExposeReplyCommentView
 * JD-Core Version:    0.7.0.1
 */