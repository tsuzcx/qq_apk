package com.tencent.mobileqq.nearby.profilecard;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.nearby.interestTag.InterestTagInfo;
import com.tencent.widget.HorizontalListView;
import java.security.InvalidParameterException;
import java.util.List;

public class SavorTagImg
  extends LinearLayout
  implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener
{
  static final int[] a = { 60, 60, 60 };
  static final int[] b = { 85, 60, 60 };
  TextView c;
  HorizontalListView d;
  String e;
  int f;
  OnTagClickListener g;
  boolean h = true;
  
  public SavorTagImg(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SavorTagImg(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
  }
  
  private void a(View paramView, int paramInt)
  {
    if (this.g != null)
    {
      Object localObject = (SavorImgTagAdapter)this.d.getAdapter();
      if (localObject != null)
      {
        localObject = (InterestTagInfo)((SavorImgTagAdapter)localObject).getItem(paramInt);
        if (localObject != null) {
          this.g.a(paramView, this.f, (InterestTagInfo)localObject);
        }
      }
    }
  }
  
  private void b()
  {
    removeAllViews();
    getResources().getDimensionPixelSize(2131297678);
    int i = getResources().getDimensionPixelSize(2131297679);
    setOrientation(1);
    this.c = ((TextView)LayoutInflater.from(getContext()).inflate(2131627589, null));
    LinearLayout.LayoutParams localLayoutParams = generateDefaultLayoutParams();
    localLayoutParams.width = -1;
    localLayoutParams.height = -2;
    localLayoutParams.topMargin = i;
    localLayoutParams.bottomMargin = i;
    addView(this.c, localLayoutParams);
  }
  
  @TargetApi(9)
  public void a(String paramString, int paramInt, List<InterestTagInfo> paramList, OnTagClickListener paramOnTagClickListener)
  {
    if (this.d == null)
    {
      this.e = paramString;
      this.f = paramInt;
      this.g = paramOnTagClickListener;
      if (paramInt != 5)
      {
        if (paramInt == 6) {
          break label52;
        }
        if (paramInt == 7) {}
      }
      else
      {
        i = 0;
        break label55;
      }
      int i = 2;
      break label55;
      label52:
      i = 1;
      label55:
      paramString = getResources();
      float f1 = paramString.getDisplayMetrics().density;
      int k = (int)(a[i] * f1);
      int j = (int)(b[i] * f1);
      if ((paramInt == 10) || (paramInt == 9) || (paramInt == 11)) {
        j = (int)(a[i] * f1);
      }
      i = paramString.getDimensionPixelSize(2131299662);
      int m = paramString.getDimensionPixelSize(2131297679);
      paramString = new GradientDrawable();
      if (this.f == 7)
      {
        paramString.setColor(getResources().getColor(2131166580));
        paramString.setCornerRadius(f1 * 10.0F);
        paramString.setShape(0);
        int n = getResources().getDimensionPixelSize(2131298113);
        paramString.setSize(n, n);
      }
      else
      {
        paramString.setColor(getResources().getColor(2131166580));
        paramString.setShape(0);
        paramString.setSize(k, j);
      }
      paramString = new SavorImgTagAdapter(getContext(), paramString, k, j, paramInt);
      paramString.a(0 - i);
      this.d = new HorizontalListView(getContext());
      this.d.setDividerWidth(i);
      paramOnTagClickListener = generateDefaultLayoutParams();
      paramOnTagClickListener.width = -1;
      paramOnTagClickListener.height = paramString.a();
      paramOnTagClickListener.bottomMargin = m;
      addView(this.d, paramOnTagClickListener);
      this.d.setAdapter(paramString);
      if (this.g != null)
      {
        this.d.setOnItemLongClickListener(this);
        this.d.setOnItemClickListener(this);
      }
      else
      {
        this.d.setTransTouchStateToParent(true);
      }
      if (Build.VERSION.SDK_INT >= 9) {
        this.d.setOverScrollMode(0);
      }
      a(paramList);
      return;
    }
    throw new InvalidParameterException("SavorTagImg can not init twice");
  }
  
  public void a(List<InterestTagInfo> paramList)
  {
    Object localObject = this.d;
    if (localObject != null)
    {
      localObject = (SavorImgTagAdapter)((HorizontalListView)localObject).getAdapter();
      if (localObject == null) {
        return;
      }
      ((SavorImgTagAdapter)localObject).a(paramList);
      int i;
      if (paramList == null) {
        i = 0;
      } else {
        i = paramList.size();
      }
      if (i > 0)
      {
        paramList = new StringBuilder(this.e);
        paramList.append('(');
        paramList.append(i);
        paramList.append(')');
        this.c.setText(paramList.toString());
        this.d.setVisibility(0);
        return;
      }
      this.c.setText(this.e);
      this.d.setVisibility(8);
      return;
    }
    throw new InvalidParameterException("can not updateData before init");
  }
  
  public boolean a()
  {
    if (this.d != null)
    {
      Rect localRect = new Rect();
      if (this.d.getGlobalVisibleRect(localRect))
      {
        double d1 = localRect.bottom - localRect.top;
        double d2 = this.d.getMeasuredHeight();
        Double.isNaN(d2);
        if (d1 >= d2 * 0.5D) {
          return true;
        }
      }
    }
    return false;
  }
  
  public String getContentsDesc()
  {
    if (this.d != null)
    {
      if (this.e == null) {
        return "";
      }
      StringBuilder localStringBuilder = new StringBuilder(HardCodeUtil.a(2131910979));
      ListAdapter localListAdapter = this.d.getAdapter();
      if (localListAdapter == null) {
        return "";
      }
      localStringBuilder.append(this.e);
      localStringBuilder.append(localListAdapter.getCount());
      localStringBuilder.append("个");
      int i = 0;
      while (i < localListAdapter.getCount())
      {
        localStringBuilder.append(",");
        Object localObject = (InterestTagInfo)localListAdapter.getItem(i);
        if (localObject != null) {
          localObject = ((InterestTagInfo)localObject).tagName;
        } else {
          localObject = "";
        }
        localStringBuilder.append((String)localObject);
        i += 1;
      }
      return localStringBuilder.toString();
    }
    return "";
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((getContext() instanceof NearbyPeopleProfileActivity)) {
      ((NearbyPeopleProfileActivity)getContext()).setInterceptTouchFlag(false);
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    a(paramView, paramInt);
  }
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    a(paramView, paramInt);
    return true;
  }
  
  public void setRightArrowVisible(boolean paramBoolean)
  {
    if (paramBoolean == this.h) {
      return;
    }
    this.h = paramBoolean;
    if (this.h)
    {
      this.c.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130839446, 0);
      return;
    }
    this.c.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
  }
  
  public void setTitleTextColor(int paramInt)
  {
    this.c.setTextColor(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.SavorTagImg
 * JD-Core Version:    0.7.0.1
 */