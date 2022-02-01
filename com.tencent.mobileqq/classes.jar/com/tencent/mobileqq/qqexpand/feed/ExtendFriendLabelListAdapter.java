package com.tencent.mobileqq.qqexpand.feed;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.widget.VerticalCenterImageSpan;
import java.util.ArrayList;
import java.util.List;

public class ExtendFriendLabelListAdapter
  extends BaseAdapter
{
  private final Context jdField_a_of_type_AndroidContentContext;
  private final List<LabelInfo> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = false;
  
  public ExtendFriendLabelListAdapter(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private int a(float paramFloat, int paramInt)
  {
    return (Math.min(255, Math.max(0, (int)(paramFloat * 255.0F))) << 24) + (paramInt & 0xFFFFFF);
  }
  
  private ColorStateList a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int[] arrayOfInt1 = { 16842919, 16842910 };
    int[] arrayOfInt2 = { 16842910 };
    return new ColorStateList(new int[][] { arrayOfInt1, { 16842910, 16842908 }, arrayOfInt2, { 16842908 }, { 16842909 }, new int[0] }, new int[] { paramInt2, paramInt3, paramInt1, paramInt3, paramInt4, paramInt1 });
  }
  
  private Drawable a(int paramInt)
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setShape(0);
    localGradientDrawable.setCornerRadius(25.0F);
    localGradientDrawable.setColor(paramInt);
    if (this.jdField_a_of_type_Boolean) {
      localGradientDrawable.setStroke(1, -1);
    }
    return localGradientDrawable;
  }
  
  private Drawable a(int paramInt1, int paramInt2)
  {
    StateListDrawable localStateListDrawable = new StateListDrawable();
    Drawable localDrawable = a(paramInt1);
    localStateListDrawable.addState(new int[] { 16842919 }, localDrawable);
    localDrawable = a(paramInt1);
    localStateListDrawable.addState(new int[] { 16842908 }, localDrawable);
    localDrawable = a(paramInt1);
    localStateListDrawable.addState(new int[] { 16842913 }, localDrawable);
    localDrawable = a(paramInt2);
    localStateListDrawable.addState(new int[0], localDrawable);
    return localStateListDrawable;
  }
  
  private SpannableString a(Drawable paramDrawable)
  {
    SpannableString localSpannableString = new SpannableString(" ");
    int i = AIOUtils.b(11.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    paramDrawable.setBounds(0, 0, i, i);
    localSpannableString.setSpan(new VerticalCenterImageSpan(paramDrawable, 0), 0, 1, 33);
    return localSpannableString;
  }
  
  public LabelInfo a(int paramInt)
  {
    return (LabelInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public void a(List<LabelInfo> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131561083, null, false);
      paramViewGroup = new ExtendFriendLabelListAdapter.ViewHolder(this);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379659));
      paramView.setTag(paramViewGroup);
    }
    else
    {
      paramViewGroup = (ExtendFriendLabelListAdapter.ViewHolder)paramView.getTag();
    }
    LabelInfo localLabelInfo = a(paramInt);
    if (localLabelInfo != null)
    {
      paramViewGroup.jdField_a_of_type_Int = paramInt;
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
      if (localLabelInfo.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
        localSpannableStringBuilder.append(a(localLabelInfo.jdField_a_of_type_AndroidGraphicsDrawableDrawable));
      }
      if (!TextUtils.isEmpty(localLabelInfo.jdField_a_of_type_JavaLangString)) {
        localSpannableStringBuilder.append(localLabelInfo.jdField_a_of_type_JavaLangString);
      }
      TextView localTextView = paramViewGroup.jdField_a_of_type_AndroidWidgetTextView;
      Object localObject = localSpannableStringBuilder;
      if (TextUtils.isEmpty(localSpannableStringBuilder)) {
        localObject = "";
      }
      localTextView.setText((CharSequence)localObject);
      if (TextUtils.isEmpty(localLabelInfo.b))
      {
        paramInt = Color.parseColor("#FF80BF");
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(a(a(0.2F, paramInt), a(0.2F, paramInt)));
      }
      else
      {
        paramInt = Color.parseColor(localLabelInfo.b);
        if (TextUtils.isEmpty(localLabelInfo.c)) {
          paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(a(a(0.2F, paramInt), a(0.2F, paramInt)));
        } else {
          paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(a(Color.parseColor(localLabelInfo.c), Color.parseColor(localLabelInfo.c)));
        }
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setTextColor(a(paramInt, paramInt, paramInt, paramInt));
    }
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.feed.ExtendFriendLabelListAdapter
 * JD-Core Version:    0.7.0.1
 */