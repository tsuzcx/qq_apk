package com.tencent.mobileqq.richstatus.comment.widget;

import actn;
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
import android.view.ViewGroup.OnHierarchyChangeListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import awew;
import awex;
import awez;
import awfa;
import awfb;
import awfc;
import awfd;
import awfe;
import awff;
import ayki;
import com.tencent.mobileqq.R.styleable;
import com.tencent.mobileqq.richstatus.comment.bean.CommentItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class CommentsView
  extends LinearLayout
  implements ViewGroup.OnHierarchyChangeListener
{
  private int jdField_a_of_type_Int;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private awez<View> jdField_a_of_type_Awez;
  private awfd jdField_a_of_type_Awfd;
  private awfe jdField_a_of_type_Awfe;
  private awff jdField_a_of_type_Awff;
  private String jdField_a_of_type_JavaLangString = "CommentsView";
  private List<CommentItem> jdField_a_of_type_JavaUtilList;
  private int b;
  private int c;
  
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
    paramString1.setSpan(new awfc(this, this.jdField_a_of_type_Int, paramString2), 0, paramString1.length(), 33);
    return paramString1;
  }
  
  private View a(int paramInt)
  {
    View localView2 = (View)this.jdField_a_of_type_Awez.a();
    View localView1 = localView2;
    if (localView2 == null)
    {
      if (this.jdField_a_of_type_AndroidViewLayoutInflater == null) {
        this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(getContext());
      }
      localView1 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561643, null, false);
    }
    a(localView1, paramInt);
    return localView1;
  }
  
  private void a(View paramView, int paramInt)
  {
    TextView localTextView = (TextView)paramView;
    awex localawex = new awex(this.b, this.b);
    CommentItem localCommentItem = (CommentItem)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    String str = localCommentItem.user.b;
    paramView = "";
    if (localCommentItem.toReplyUser != null) {
      paramView = localCommentItem.toReplyUser.b;
    }
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    localSpannableStringBuilder.append(a(str, localCommentItem.user.jdField_a_of_type_JavaLangString));
    if (!TextUtils.isEmpty(paramView))
    {
      localSpannableStringBuilder.append(" ");
      localSpannableStringBuilder.append(getContext().getString(2131718717));
      localSpannableStringBuilder.append(" ");
      localSpannableStringBuilder.append(a(paramView, localCommentItem.toReplyUser.jdField_a_of_type_JavaLangString));
    }
    localSpannableStringBuilder.append(": ");
    localSpannableStringBuilder.append(localCommentItem.content);
    localTextView.setText(new ayki(localSpannableStringBuilder, 3, 16));
    localTextView.setTextColor(this.c);
    localTextView.setMovementMethod(localawex);
    localTextView.setOnClickListener(new awfa(this, localawex, paramInt));
    localTextView.setOnLongClickListener(new awfb(this, localawex, paramInt));
  }
  
  private void b()
  {
    this.jdField_a_of_type_Awez = new awez();
    setOnHierarchyChangeListener(this);
    this.c = getResources().getColor(2131167034);
  }
  
  public void a()
  {
    int i = 0;
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0)) {
      setVisibility(8);
    }
    do
    {
      return;
      setVisibility(0);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
      localLayoutParams.topMargin = actn.a(2.0F, getResources());
      if (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        if (getChildCount() > i) {
          a(getChildAt(i), i);
        }
        for (;;)
        {
          i += 1;
          break;
          View localView = a(i);
          if (localView == null)
          {
            QLog.e(this.jdField_a_of_type_JavaLangString, 1, "listView item layout is null, please check getView()...");
            return;
          }
          addView(localView, i, localLayoutParams);
        }
      }
    } while (getChildCount() <= this.jdField_a_of_type_JavaUtilList.size());
    removeViews(this.jdField_a_of_type_JavaUtilList.size(), getChildCount() - this.jdField_a_of_type_JavaUtilList.size());
  }
  
  protected void a(AttributeSet paramAttributeSet)
  {
    paramAttributeSet = getContext().getTheme().obtainStyledAttributes(paramAttributeSet, R.styleable.CommentsView, 0, 0);
    try
    {
      this.jdField_a_of_type_Int = paramAttributeSet.getColor(0, getResources().getColor(2131166323));
      this.b = paramAttributeSet.getColor(1, getResources().getColor(2131166785));
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
    this.jdField_a_of_type_JavaUtilList = ((List)localObject);
    a();
  }
  
  public void onChildViewAdded(View paramView1, View paramView2) {}
  
  public void onChildViewRemoved(View paramView1, View paramView2)
  {
    this.jdField_a_of_type_Awez.a(paramView2);
  }
  
  public void setItemColor(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void setNormalTextColor(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void setOnItemClickListener(awfd paramawfd)
  {
    this.jdField_a_of_type_Awfd = paramawfd;
  }
  
  public void setOnItemLongClickListener(awfe paramawfe)
  {
    this.jdField_a_of_type_Awfe = paramawfe;
  }
  
  public void setOnSpanItemClick(awff paramawff)
  {
    this.jdField_a_of_type_Awff = paramawff;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.comment.widget.CommentsView
 * JD-Core Version:    0.7.0.1
 */