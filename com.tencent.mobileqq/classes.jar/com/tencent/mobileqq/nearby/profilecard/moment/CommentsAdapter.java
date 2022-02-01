package com.tencent.mobileqq.nearby.profilecard.moment;

import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.nearby.profilecard.moment.data.CommentInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CommentsAdapter
  extends BaseAdapter
{
  private List<CommentInfo> a = new ArrayList();
  private CommentsAdapter.CommentsItemClickListener b;
  private int c;
  
  public void a(CommentsAdapter.CommentsItemClickListener paramCommentsItemClickListener)
  {
    this.b = paramCommentsItemClickListener;
  }
  
  public void a(List<CommentInfo> paramList)
  {
    this.a.clear();
    this.a.addAll(paramList);
  }
  
  public int getCount()
  {
    return this.a.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.a.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = LayoutInflater.from(paramViewGroup.getContext());
    int j = 0;
    TextView localTextView = (TextView)paramView.inflate(2131627577, paramViewGroup, false);
    CommentInfo localCommentInfo = (CommentInfo)this.a.get(paramInt);
    Object localObject = localCommentInfo.b;
    paramView = (View)localObject;
    if (localObject != null)
    {
      paramView = (View)localObject;
      if (((String)localObject).length() > 9)
      {
        paramView = new StringBuilder();
        paramView.append(((String)localObject).substring(0, 8));
        paramView.append("...");
        paramView = paramView.toString();
      }
    }
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramView);
    localSpannableStringBuilder.setSpan(new StyleSpan(1), 0, localSpannableStringBuilder.length(), 33);
    localObject = localCommentInfo.c;
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localSpannableStringBuilder.append(" 回复 ");
      paramView = (View)localObject;
      if (((String)localObject).length() > 9)
      {
        paramView = new StringBuilder();
        paramView.append(((String)localObject).substring(0, 8));
        paramView.append("...");
        paramView = paramView.toString();
      }
      localSpannableStringBuilder.append(paramView);
      localSpannableStringBuilder.setSpan(new StyleSpan(1), localSpannableStringBuilder.length() - paramView.length(), localSpannableStringBuilder.length(), 33);
    }
    localSpannableStringBuilder.append("：").append(localCommentInfo.d);
    paramView = localTextView.getPaint();
    localObject = new ArrayList();
    if (this.c == 0) {
      this.c = (UIUtils.b(localTextView.getContext()) - UIUtils.a(localTextView.getContext(), 85.0F));
    }
    int i = 0;
    paramInt = j;
    while (paramInt < localSpannableStringBuilder.length())
    {
      j = i;
      if (paramView.measureText(localSpannableStringBuilder.subSequence(i, paramInt).toString()) > this.c)
      {
        ((List)localObject).add(Integer.valueOf(paramInt - 1));
        j = paramInt;
      }
      paramInt += 1;
      i = j;
    }
    paramView = ((List)localObject).iterator();
    while (paramView.hasNext())
    {
      localObject = (Integer)paramView.next();
      if (((Integer)localObject).intValue() < localSpannableStringBuilder.length() - 1) {
        localSpannableStringBuilder.insert(((Integer)localObject).intValue(), "\n");
      }
    }
    localTextView.setText(localSpannableStringBuilder);
    localTextView.setMovementMethod(LinkMovementMethod.getInstance());
    localTextView.setOnClickListener(new CommentsAdapter.1(this, paramViewGroup));
    return localTextView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.moment.CommentsAdapter
 * JD-Core Version:    0.7.0.1
 */