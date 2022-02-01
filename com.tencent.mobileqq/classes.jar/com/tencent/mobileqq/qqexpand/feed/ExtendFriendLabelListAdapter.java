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
  private final Context a;
  private boolean b = false;
  private final List<LabelInfo> c = new ArrayList();
  
  public ExtendFriendLabelListAdapter(Context paramContext)
  {
    this.a = paramContext;
  }
  
  private int a(float paramFloat, int paramInt)
  {
    return (Math.min(255, Math.max(0, (int)(paramFloat * 255.0F))) << 24) + (paramInt & 0xFFFFFF);
  }
  
  private ColorStateList a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return new ColorStateList(new int[][] { { 16842919, 16842910 }, { 16842910, 16842908 }, { 16842910 }, { 16842908 }, { 16842909 }, new int[0] }, new int[] { paramInt2, paramInt3, paramInt1, paramInt3, paramInt4, paramInt1 });
  }
  
  private Drawable a(int paramInt1, int paramInt2)
  {
    StateListDrawable localStateListDrawable = new StateListDrawable();
    Drawable localDrawable = b(paramInt1);
    localStateListDrawable.addState(new int[] { 16842919 }, localDrawable);
    localDrawable = b(paramInt1);
    localStateListDrawable.addState(new int[] { 16842908 }, localDrawable);
    localDrawable = b(paramInt1);
    localStateListDrawable.addState(new int[] { 16842913 }, localDrawable);
    localDrawable = b(paramInt2);
    localStateListDrawable.addState(new int[0], localDrawable);
    return localStateListDrawable;
  }
  
  private SpannableString a(Drawable paramDrawable)
  {
    SpannableString localSpannableString = new SpannableString(" ");
    int i = AIOUtils.b(11.0F, this.a.getResources());
    paramDrawable.setBounds(0, 0, i, i);
    localSpannableString.setSpan(new VerticalCenterImageSpan(paramDrawable, 0), 0, 1, 33);
    return localSpannableString;
  }
  
  private Drawable b(int paramInt)
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setShape(0);
    localGradientDrawable.setCornerRadius(25.0F);
    localGradientDrawable.setColor(paramInt);
    if (this.b) {
      localGradientDrawable.setStroke(1, -1);
    }
    return localGradientDrawable;
  }
  
  public LabelInfo a(int paramInt)
  {
    return (LabelInfo)this.c.get(paramInt);
  }
  
  public void a()
  {
    this.c.clear();
  }
  
  public void a(List<LabelInfo> paramList)
  {
    this.c.addAll(paramList);
  }
  
  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public int getCount()
  {
    return this.c.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131627431, null, false);
      paramViewGroup = new ExtendFriendLabelListAdapter.ViewHolder(this);
      paramViewGroup.b = ((TextView)paramView.findViewById(2131448436));
      paramView.setTag(paramViewGroup);
    }
    else
    {
      paramViewGroup = (ExtendFriendLabelListAdapter.ViewHolder)paramView.getTag();
    }
    LabelInfo localLabelInfo = a(paramInt);
    if (localLabelInfo != null)
    {
      paramViewGroup.a = paramInt;
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
      if (localLabelInfo.e != null) {
        localSpannableStringBuilder.append(a(localLabelInfo.e));
      }
      if (!TextUtils.isEmpty(localLabelInfo.b)) {
        localSpannableStringBuilder.append(localLabelInfo.b);
      }
      TextView localTextView = paramViewGroup.b;
      Object localObject = localSpannableStringBuilder;
      if (TextUtils.isEmpty(localSpannableStringBuilder)) {
        localObject = "";
      }
      localTextView.setText((CharSequence)localObject);
      if (TextUtils.isEmpty(localLabelInfo.c))
      {
        paramInt = Color.parseColor("#FF80BF");
        paramViewGroup.b.setBackgroundDrawable(a(a(0.2F, paramInt), a(0.2F, paramInt)));
      }
      else
      {
        paramInt = Color.parseColor(localLabelInfo.c);
        if (TextUtils.isEmpty(localLabelInfo.d)) {
          paramViewGroup.b.setBackgroundDrawable(a(a(0.2F, paramInt), a(0.2F, paramInt)));
        } else {
          paramViewGroup.b.setBackgroundDrawable(a(Color.parseColor(localLabelInfo.d), Color.parseColor(localLabelInfo.d)));
        }
      }
      paramViewGroup.b.setTextColor(a(paramInt, paramInt, paramInt, paramInt));
    }
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.feed.ExtendFriendLabelListAdapter
 * JD-Core Version:    0.7.0.1
 */