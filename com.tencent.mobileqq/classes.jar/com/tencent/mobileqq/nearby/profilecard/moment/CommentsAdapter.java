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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CommentsAdapter
  extends BaseAdapter
{
  private int jdField_a_of_type_Int;
  private CommentsAdapter.CommentsItemClickListener jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentCommentsAdapter$CommentsItemClickListener;
  private List<CommentInfo> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public void a(CommentsAdapter.CommentsItemClickListener paramCommentsItemClickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentCommentsAdapter$CommentsItemClickListener = paramCommentsItemClickListener;
  }
  
  public void a(List<CommentInfo> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int j = 0;
    TextView localTextView = (TextView)LayoutInflater.from(paramViewGroup.getContext()).inflate(2131561384, paramViewGroup, false);
    CommentInfo localCommentInfo = (CommentInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    Object localObject2 = localCommentInfo.a;
    Object localObject1 = localObject2;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (((String)localObject2).length() > 9) {
        localObject1 = ((String)localObject2).substring(0, 8) + "...";
      }
    }
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder((CharSequence)localObject1);
    localSpannableStringBuilder.setSpan(new StyleSpan(1), 0, localSpannableStringBuilder.length(), 33);
    localObject2 = localCommentInfo.b;
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      localSpannableStringBuilder.append(" 回复 ");
      localObject1 = localObject2;
      if (((String)localObject2).length() > 9) {
        localObject1 = ((String)localObject2).substring(0, 8) + "...";
      }
      localSpannableStringBuilder.append((CharSequence)localObject1);
      localSpannableStringBuilder.setSpan(new StyleSpan(1), localSpannableStringBuilder.length() - ((String)localObject1).length(), localSpannableStringBuilder.length(), 33);
    }
    localSpannableStringBuilder.append("：").append(localCommentInfo.c);
    localObject1 = localTextView.getPaint();
    localObject2 = new ArrayList();
    if (this.jdField_a_of_type_Int == 0) {
      this.jdField_a_of_type_Int = (UIUtils.a(localTextView.getContext()) - UIUtils.a(localTextView.getContext(), 85.0F));
    }
    int i = 0;
    while (i < localSpannableStringBuilder.length())
    {
      int k = j;
      if (((TextPaint)localObject1).measureText(localSpannableStringBuilder.subSequence(j, i).toString()) > this.jdField_a_of_type_Int)
      {
        ((List)localObject2).add(Integer.valueOf(i - 1));
        k = i;
      }
      i += 1;
      j = k;
    }
    localObject1 = ((List)localObject2).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Integer)((Iterator)localObject1).next();
      if (((Integer)localObject2).intValue() < localSpannableStringBuilder.length() - 1) {
        localSpannableStringBuilder.insert(((Integer)localObject2).intValue(), "\n");
      }
    }
    localTextView.setText(localSpannableStringBuilder);
    localTextView.setMovementMethod(LinkMovementMethod.getInstance());
    localTextView.setOnClickListener(new CommentsAdapter.1(this, paramViewGroup));
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return localTextView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.moment.CommentsAdapter
 * JD-Core Version:    0.7.0.1
 */