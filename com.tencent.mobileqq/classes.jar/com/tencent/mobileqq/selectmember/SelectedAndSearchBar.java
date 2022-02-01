package com.tencent.mobileqq.selectmember;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build.VERSION;
import android.text.Editable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.widget.CustomHorizontalScrollView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SelectedAndSearchBar
  extends RelativeLayout
  implements DecodeTaskCompletionListener
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private IFaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
  private CustomGridView jdField_a_of_type_ComTencentMobileqqSelectmemberCustomGridView;
  private final ResultRecord.DefaultComparator jdField_a_of_type_ComTencentMobileqqSelectmemberResultRecord$DefaultComparator = new ResultRecord.DefaultComparator();
  private SelectedAndSearchBar.GridViewAdapter jdField_a_of_type_ComTencentMobileqqSelectmemberSelectedAndSearchBar$GridViewAdapter;
  private SelectedAndSearchBar.ISelectedAndSearchBarCallback jdField_a_of_type_ComTencentMobileqqSelectmemberSelectedAndSearchBar$ISelectedAndSearchBarCallback;
  private CustomHorizontalScrollView jdField_a_of_type_ComTencentMobileqqWidgetCustomHorizontalScrollView;
  private List<ResultRecord> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private ImageView b;
  
  public SelectedAndSearchBar(Context paramContext)
  {
    super(paramContext);
    e();
    f();
  }
  
  public SelectedAndSearchBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    e();
    f();
  }
  
  public SelectedAndSearchBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    e();
    f();
  }
  
  public static final int a(float paramFloat, Resources paramResources)
  {
    if (paramFloat == 0.0F) {
      return 0;
    }
    return (int)(paramFloat * paramResources.getDisplayMetrics().density + 0.5F);
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(2131562831, this);
    this.jdField_a_of_type_ComTencentMobileqqSelectmemberCustomGridView = ((CustomGridView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377178));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidViewView.findViewById(2131377068));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368721));
    this.b = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377063));
    this.jdField_a_of_type_ComTencentMobileqqWidgetCustomHorizontalScrollView = ((CustomHorizontalScrollView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377006));
    AccessibilityUtil.a(this.jdField_a_of_type_ComTencentMobileqqWidgetCustomHorizontalScrollView, false);
    if (Build.VERSION.SDK_INT >= 9)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetCustomHorizontalScrollView.setOverScrollMode(2);
      this.jdField_a_of_type_ComTencentMobileqqSelectmemberCustomGridView.setOverScrollMode(2);
    }
    this.jdField_a_of_type_ComTencentMobileqqSelectmemberCustomGridView.setOnItemClickListener(new SelectedAndSearchBar.1(this));
    this.jdField_a_of_type_AndroidWidgetEditText.setOnKeyListener(new SelectedAndSearchBar.2(this));
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new SelectedAndSearchBar.3(this));
    this.jdField_a_of_type_AndroidWidgetEditText.setOnFocusChangeListener(new SelectedAndSearchBar.4(this));
  }
  
  private void f()
  {
    this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_AndroidContentContext = getContext();
  }
  
  public Editable a()
  {
    return this.jdField_a_of_type_AndroidWidgetEditText.getText();
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidWidgetEditText.setText("");
  }
  
  public void a(long paramLong)
  {
    int i = a(60.0F, getResources());
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { -i, 0 });
    localValueAnimator.setDuration(paramLong);
    localValueAnimator.addUpdateListener(new SelectedAndSearchBar.7(this, localLayoutParams));
    localValueAnimator.start();
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidWidgetEditText.setOnClickListener(new SelectedAndSearchBar.5(this, paramOnClickListener));
  }
  
  public void a(List<ResultRecord> paramList, IFaceDecoder paramIFaceDecoder, SelectedAndSearchBar.ISelectedAndSearchBarCallback paramISelectedAndSearchBarCallback)
  {
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilList = paramList;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = paramIFaceDecoder;
    this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectedAndSearchBar$ISelectedAndSearchBarCallback = paramISelectedAndSearchBarCallback;
    this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectedAndSearchBar$GridViewAdapter = new SelectedAndSearchBar.GridViewAdapter(this);
    this.jdField_a_of_type_ComTencentMobileqqSelectmemberCustomGridView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectedAndSearchBar$GridViewAdapter);
    this.jdField_a_of_type_ComTencentMobileqqSelectmemberCustomGridView.setSmoothScrollbarEnabled(false);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.setDecodeTaskCompletionListener(this);
  }
  
  public void a(List<ResultRecord> paramList, boolean paramBoolean)
  {
    Collections.sort(paramList, this.jdField_a_of_type_ComTencentMobileqqSelectmemberResultRecord$DefaultComparator);
    this.jdField_a_of_type_JavaUtilList = paramList;
    a(paramBoolean);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqSelectmemberCustomGridView.setNumColumns(this.jdField_a_of_type_JavaUtilList.size());
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_ComTencentMobileqqSelectmemberCustomGridView.getLayoutParams();
    localLayoutParams.width = ((int)((this.jdField_a_of_type_JavaUtilList.size() * 40 + this.jdField_a_of_type_JavaUtilList.size() * 10) * this.jdField_a_of_type_Float));
    this.jdField_a_of_type_ComTencentMobileqqSelectmemberCustomGridView.setLayoutParams(localLayoutParams);
    d();
    if (paramBoolean) {
      postDelayed(new SelectedAndSearchBar.6(this), 200L);
    }
    this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectedAndSearchBar$GridViewAdapter.notifyDataSetChanged();
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_AndroidWidgetEditText.hasFocus();
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidWidgetEditText.clearFocus();
  }
  
  public void b(long paramLong)
  {
    int i = a(60.0F, getResources());
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, -i });
    localValueAnimator.setDuration(paramLong);
    localValueAnimator.addUpdateListener(new SelectedAndSearchBar.8(this, localLayoutParams));
    localValueAnimator.start();
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetCustomHorizontalScrollView.scrollTo(this.jdField_a_of_type_ComTencentMobileqqSelectmemberCustomGridView.getLayoutParams().width, 0);
  }
  
  public void d()
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, (int)(this.jdField_a_of_type_Float * 40.0F));
    float f1 = this.jdField_a_of_type_Float;
    int i = (int)(40.0F * f1);
    int j = (int)(f1 * 10.0F);
    if (this.jdField_a_of_type_JavaUtilList.size() > 0)
    {
      if (this.jdField_a_of_type_JavaUtilList.size() < 5)
      {
        f1 = this.jdField_a_of_type_JavaUtilList.size() * 40 + this.jdField_a_of_type_JavaUtilList.size() * 10;
        float f2 = this.jdField_a_of_type_Float;
        i = (int)(f1 * f2) + (int)(f2 * 10.0F);
      }
      else
      {
        i = (int)(this.jdField_a_of_type_Float * 230.0F);
      }
      this.b.setVisibility(8);
    }
    else
    {
      this.b.setVisibility(0);
    }
    localLayoutParams.addRule(15);
    localLayoutParams.setMargins(i, 0, j, 0);
    this.jdField_a_of_type_AndroidWidgetEditText.setLayoutParams(localLayoutParams);
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqSelectmemberCustomGridView == null) {
      return;
    }
    paramInt1 = 0;
    while (paramInt1 < this.jdField_a_of_type_ComTencentMobileqqSelectmemberCustomGridView.getChildCount())
    {
      View localView = this.jdField_a_of_type_ComTencentMobileqqSelectmemberCustomGridView.getChildAt(paramInt1);
      Object localObject = localView.getTag();
      if ((localObject != null) && ((localObject instanceof ResultRecord)))
      {
        localObject = (ResultRecord)localObject;
        if ((paramString.equals(((ResultRecord)localObject).uin)) && (((ResultRecord)localObject).type == paramInt2)) {
          ((ImageView)localView.findViewById(2131366401)).setBackgroundDrawable(new BitmapDrawable(getResources(), paramBitmap));
        }
      }
      paramInt1 += 1;
    }
  }
  
  public void setIsFrom(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.SelectedAndSearchBar
 * JD-Core Version:    0.7.0.1
 */