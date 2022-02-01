package com.tencent.mobileqq.qwallet.hb.grap.draw.impl;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qqpay.ui.R.drawable;
import com.tencent.mobileqq.qqpay.ui.R.string;
import com.tencent.mobileqq.qwallet.impl.QWalletTools;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ChooseItemView
  extends FrameLayout
{
  private static int jdField_a_of_type_Int = 13;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(getContext());
  ChooseItemView.MyRecycleViewAdapter jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplChooseItemView$MyRecycleViewAdapter;
  public ChooseItemView.OnVisibilityChangeListener a;
  private String jdField_a_of_type_JavaLangString;
  private List<String> jdField_a_of_type_JavaUtilList = new LinkedList();
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = 4;
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener;
  private int jdField_c_of_type_Int = 0;
  private View.OnClickListener jdField_c_of_type_AndroidViewView$OnClickListener = new ChooseItemView.3(this);
  private int d = 0;
  
  public ChooseItemView(Context paramContext, View.OnClickListener paramOnClickListener)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(1);
    addView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    paramContext = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    paramContext.width = -1;
    paramContext.height = -2;
    setOnClickListener(paramOnClickListener);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnTouchListener(new ChooseItemView.1(this));
  }
  
  private Paint a()
  {
    if (this.jdField_a_of_type_AndroidGraphicsPaint == null)
    {
      TextView localTextView = new TextView(getContext());
      localTextView.setTextSize(1, jdField_a_of_type_Int);
      this.jdField_a_of_type_AndroidGraphicsPaint = localTextView.getPaint();
    }
    return this.jdField_a_of_type_AndroidGraphicsPaint;
  }
  
  private List<List<ChooseItemView.ItemInfo>> a()
  {
    LinkedList localLinkedList2 = new LinkedList();
    int k = this.jdField_a_of_type_AndroidWidgetLinearLayout.getWidth();
    LinkedList localLinkedList1 = new LinkedList();
    int j = 0;
    int i = 0;
    for (;;)
    {
      int m = this.jdField_a_of_type_JavaUtilList.size();
      boolean bool = true;
      if ((j >= m) || (!a(localLinkedList2.size() + 1))) {
        break;
      }
      String str = (String)this.jdField_a_of_type_JavaUtilList.get(j);
      if (j >= this.jdField_c_of_type_Int) {
        bool = false;
      }
      ChooseItemView.ItemInfo localItemInfo = new ChooseItemView.ItemInfo(str, bool, false);
      float f1 = a().measureText(str) + DisplayUtil.a(getContext(), 26.0F);
      float f2 = i;
      if (f2 + f1 + DisplayUtil.a(getContext(), 12.0F) * 2 <= k)
      {
        localLinkedList1.add(localItemInfo);
        i = (int)(f2 + (f1 + DisplayUtil.a(getContext(), 12.0F)));
      }
      else
      {
        localLinkedList2.add(localLinkedList1);
        localLinkedList1 = new LinkedList();
        localLinkedList1.add(localItemInfo);
        i = (int)f1 + DisplayUtil.a(getContext(), 12.0F);
      }
      j += 1;
    }
    if (a(localLinkedList2.size() + 1)) {
      localLinkedList2.add(localLinkedList1);
    }
    return localLinkedList2;
  }
  
  private void a(View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2, ChooseItemView.OnVisibilityChangeListener paramOnVisibilityChangeListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new ChooseItemView.4(this, paramOnClickListener1);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = paramOnClickListener2;
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplChooseItemView$OnVisibilityChangeListener = paramOnVisibilityChangeListener;
  }
  
  private boolean a(int paramInt)
  {
    if (this.d == 1) {
      return true;
    }
    return paramInt <= this.jdField_b_of_type_Int;
  }
  
  private void c()
  {
    QLog.i("ChooseItemView", 2, "updatePageInner....");
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setPadding(DisplayUtil.a(getContext(), 8.0F), 0, this.jdField_a_of_type_AndroidWidgetLinearLayout.getPaddingRight(), DisplayUtil.a(getContext(), 10.0F));
    d();
    Object localObject = new RecyclerView(getContext());
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplChooseItemView$MyRecycleViewAdapter = new ChooseItemView.MyRecycleViewAdapter(a(), this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplChooseItemView$MyRecycleViewAdapter.a(this.jdField_a_of_type_JavaLangString);
    ((RecyclerView)localObject).setAdapter(this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplChooseItemView$MyRecycleViewAdapter);
    ((RecyclerView)localObject).setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
    localObject = (LinearLayout.LayoutParams)((RecyclerView)localObject).getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).width = -1;
    ((LinearLayout.LayoutParams)localObject).height = -1;
  }
  
  private void d()
  {
    if (this.d == 0)
    {
      TextView localTextView = new TextView(getContext());
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localTextView);
      Object localObject = (LinearLayout.LayoutParams)localTextView.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).height = -2;
      ((LinearLayout.LayoutParams)localObject).width = -2;
      ((LinearLayout.LayoutParams)localObject).gravity = 5;
      localObject = getContext().getResources().getDrawable(R.drawable.p);
      ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getIntrinsicWidth(), ((Drawable)localObject).getIntrinsicHeight());
      localTextView.setCompoundDrawables((Drawable)localObject, null, null, null);
      localTextView.setCompoundDrawablePadding(DisplayUtil.a(getContext(), 7.0F));
      localTextView.setPadding(DisplayUtil.a(getContext(), 5.0F), 0, DisplayUtil.a(getContext(), 20.0F), DisplayUtil.a(getContext(), 10.0F));
      localTextView.setText(HardCodeUtil.a(R.string.an));
      localTextView.setTextColor(-1694379);
      localTextView.setTextSize(1, 14.0F);
      localTextView.setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
      QWalletTools.a(localTextView, 0.6F);
    }
  }
  
  public void a()
  {
    setVisibility(8);
  }
  
  public void a(String paramString)
  {
    if (getVisibility() == 0)
    {
      a();
      return;
    }
    a(paramString, false);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (!a()) {
      return;
    }
    this.jdField_a_of_type_JavaLangString = paramString;
    setVisibility(0);
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidWidgetLinearLayout.post(new ChooseItemView.2(this));
    QLog.i("ChooseItemView", 2, "show....");
  }
  
  public void a(List<String> paramList, boolean paramBoolean, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2, ChooseItemView.OnVisibilityChangeListener paramOnVisibilityChangeListener)
  {
    if ((paramList != null) && (paramList.size() > 0)) {
      try
      {
        this.jdField_a_of_type_JavaUtilList.clear();
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          String str = (String)paramList.next();
          if (!TextUtils.isEmpty(str)) {
            this.jdField_a_of_type_JavaUtilList.add(str);
          }
        }
        return;
      }
      catch (Throwable paramList)
      {
        paramList.printStackTrace();
        if (paramBoolean)
        {
          paramList = this.jdField_a_of_type_JavaUtilList;
          if ((paramList != null) && (paramList.size() > 1)) {
            Collections.shuffle(this.jdField_a_of_type_JavaUtilList);
          }
        }
        a(paramOnClickListener1, paramOnClickListener2, paramOnVisibilityChangeListener);
      }
    }
  }
  
  public boolean a()
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    return (localList != null) && (localList.size() > 0);
  }
  
  public void b()
  {
    a("", true);
  }
  
  public void setIsShow(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setMaxLines(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    if (this.jdField_b_of_type_Int <= 0) {
      this.jdField_b_of_type_Int = 4;
    }
  }
  
  public void setRecommendCnt(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void setStyle(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void setTextSizeInDp(int paramInt)
  {
    if (paramInt > 0) {
      jdField_a_of_type_Int = paramInt;
    }
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    ChooseItemView.OnVisibilityChangeListener localOnVisibilityChangeListener = this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplChooseItemView$OnVisibilityChangeListener;
    if (localOnVisibilityChangeListener != null) {
      localOnVisibilityChangeListener.a(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.grap.draw.impl.ChooseItemView
 * JD-Core Version:    0.7.0.1
 */