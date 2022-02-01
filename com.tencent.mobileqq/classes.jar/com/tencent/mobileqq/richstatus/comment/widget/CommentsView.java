package com.tencent.mobileqq.richstatus.comment.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.OnHierarchyChangeListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.R.styleable;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.richstatus.comment.bean.CommentItem;
import com.tencent.mobileqq.richstatus.comment.bean.User;
import com.tencent.mobileqq.richstatus.comment.spannable.CommentMovementMethod;
import com.tencent.mobileqq.richstatus.comment.utils.SimpleWeakObjectPool;
import com.tencent.mobileqq.text.QQText;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class CommentsView
  extends LinearLayout
  implements ViewGroup.OnHierarchyChangeListener
{
  private int a;
  private int b;
  private int c;
  private LayoutInflater d;
  private List<CommentItem> e;
  private SimpleWeakObjectPool<View> f;
  private CommentsView.OnSpanItemClick g;
  private CommentsView.OnItemClickListener h;
  private CommentsView.OnItemLongClickListener i;
  
  public CommentsView(Context paramContext)
  {
    super(paramContext);
    b();
  }
  
  public CommentsView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
    a(paramAttributeSet);
  }
  
  public CommentsView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b();
    a(paramAttributeSet);
  }
  
  private SpannableString a(String paramString1, String paramString2)
  {
    paramString1 = new SpannableString(paramString1);
    paramString1.setSpan(new CommentsView.3(this, this.a, paramString2), 0, paramString1.length(), 33);
    return paramString1;
  }
  
  private View a(int paramInt)
  {
    View localView2 = (View)this.f.a();
    View localView1 = localView2;
    if (localView2 == null)
    {
      if (this.d == null) {
        this.d = LayoutInflater.from(getContext());
      }
      localView1 = this.d.inflate(2131628469, null, false);
    }
    a(localView1, paramInt);
    return localView1;
  }
  
  private void a(View paramView, int paramInt)
  {
    TextView localTextView = (TextView)paramView;
    int j = this.b;
    CommentMovementMethod localCommentMovementMethod = new CommentMovementMethod(j, j);
    CommentItem localCommentItem = (CommentItem)this.e.get(paramInt);
    if (localCommentItem != null)
    {
      if (localCommentItem.user == null) {
        return;
      }
      String str2 = localCommentItem.user.b;
      paramView = localCommentItem.toReplyUser;
      String str1 = "";
      if (paramView != null) {
        paramView = localCommentItem.toReplyUser.b;
      } else {
        paramView = "";
      }
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
      localSpannableStringBuilder.append(a(str2, localCommentItem.user.a));
      if (!TextUtils.isEmpty(paramView))
      {
        localSpannableStringBuilder.append(" ");
        localSpannableStringBuilder.append(getContext().getString(2131915689));
        localSpannableStringBuilder.append(" ");
        if (localCommentItem.toReplyUser != null) {
          str1 = localCommentItem.toReplyUser.a;
        }
        localSpannableStringBuilder.append(a(paramView, str1));
      }
      localSpannableStringBuilder.append(": ");
      paramView = localCommentItem.content;
      if (!TextUtils.isEmpty(paramView)) {
        localSpannableStringBuilder.append(paramView);
      }
      localTextView.setText(new QQText(localSpannableStringBuilder, 3, 16));
      localTextView.setTextColor(this.c);
      localTextView.setMovementMethod(localCommentMovementMethod);
      localTextView.setOnClickListener(new CommentsView.1(this, localCommentMovementMethod, paramInt));
      localTextView.setOnLongClickListener(new CommentsView.2(this, localCommentMovementMethod, paramInt));
    }
  }
  
  private void b()
  {
    this.f = new SimpleWeakObjectPool();
    setOnHierarchyChangeListener(this);
    this.c = getResources().getColor(2131168264);
  }
  
  public void a()
  {
    Object localObject = this.e;
    if ((localObject != null) && (((List)localObject).size() != 0))
    {
      int j = 0;
      setVisibility(0);
      localObject = new LinearLayout.LayoutParams(-1, -2);
      ((LinearLayout.LayoutParams)localObject).topMargin = AIOUtils.b(2.0F, getResources());
      while (j < this.e.size())
      {
        if (getChildCount() > j)
        {
          a(getChildAt(j), j);
        }
        else
        {
          View localView = a(j);
          if (localView == null)
          {
            QLog.e("CommentsView", 1, "listView item layout is null, please check getView()...");
            return;
          }
          addView(localView, j, (ViewGroup.LayoutParams)localObject);
        }
        j += 1;
      }
      if (getChildCount() > this.e.size()) {
        removeViews(this.e.size(), getChildCount() - this.e.size());
      }
      return;
    }
    setVisibility(8);
  }
  
  protected void a(AttributeSet paramAttributeSet)
  {
    paramAttributeSet = getContext().getTheme().obtainStyledAttributes(paramAttributeSet, R.styleable.CommentsView, 0, 0);
    try
    {
      this.a = paramAttributeSet.getColor(0, getResources().getColor(2131167338));
      this.b = paramAttributeSet.getColor(1, getResources().getColor(2131167910));
      return;
    }
    finally
    {
      paramAttributeSet.recycle();
    }
  }
  
  public void a(List<CommentItem> paramList)
  {
    Object localObject = paramList;
    if (paramList == null) {
      localObject = new ArrayList();
    }
    this.e = ((List)localObject);
    a();
  }
  
  public CommentsView.OnItemClickListener getOnItemClickListener()
  {
    return this.h;
  }
  
  public CommentsView.OnItemLongClickListener getOnItemLongClickListener()
  {
    return this.i;
  }
  
  public CommentsView.OnSpanItemClick getOnSpanItemClick()
  {
    return this.g;
  }
  
  public void onChildViewAdded(View paramView1, View paramView2)
  {
    EventCollector.getInstance().onChildViewAdded(paramView1, paramView2);
  }
  
  public void onChildViewRemoved(View paramView1, View paramView2)
  {
    EventCollector.getInstance().onChildViewRemoved(paramView1, paramView2);
    this.f.a(paramView2);
  }
  
  public void setItemColor(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void setNormalTextColor(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void setOnItemClickListener(CommentsView.OnItemClickListener paramOnItemClickListener)
  {
    this.h = paramOnItemClickListener;
  }
  
  public void setOnItemLongClickListener(CommentsView.OnItemLongClickListener paramOnItemLongClickListener)
  {
    this.i = paramOnItemLongClickListener;
  }
  
  public void setOnSpanItemClick(CommentsView.OnSpanItemClick paramOnSpanItemClick)
  {
    this.g = paramOnSpanItemClick;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.comment.widget.CommentsView
 * JD-Core Version:    0.7.0.1
 */