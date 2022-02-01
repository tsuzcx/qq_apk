package dov.com.qq.im.capture.view;

import amtj;
import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import bbpr;
import bmyv;
import bmyw;
import bmyy;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

@TargetApi(14)
public class ProviderContainerView
  extends FrameLayout
{
  private int jdField_a_of_type_Int;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new bmyv(this);
  private View jdField_a_of_type_AndroidViewView;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private bmyw jdField_a_of_type_Bmyw;
  private bmyy jdField_a_of_type_Bmyy;
  private ProviderView jdField_a_of_type_DovComQqImCaptureViewProviderView;
  private HashMap<Integer, ProviderView> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  public ProviderContainerView(Context paramContext)
  {
    super(paramContext);
    b();
  }
  
  public ProviderContainerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
  }
  
  public ProviderContainerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b();
  }
  
  private void a(ImageView paramImageView, int paramInt)
  {
    paramInt = this.jdField_a_of_type_Bmyy.c(paramInt);
    if (paramInt == 100) {
      paramImageView.setContentDescription(amtj.a(2131708923));
    }
    while (paramInt != 101) {
      return;
    }
    paramImageView.setContentDescription(amtj.a(2131708927));
  }
  
  private void b()
  {
    View localView = LayoutInflater.from(getContext()).inflate(2131560851, null);
    addView(localView);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131368250));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setGravity(0);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)localView.findViewById(2131373066));
  }
  
  private void c(int paramInt)
  {
    if (this.jdField_a_of_type_DovComQqImCaptureViewProviderView != null)
    {
      this.jdField_a_of_type_DovComQqImCaptureViewProviderView.d();
      this.jdField_a_of_type_DovComQqImCaptureViewProviderView.setAlpha(1.0F);
      this.jdField_a_of_type_DovComQqImCaptureViewProviderView.setVisibility(8);
      this.jdField_a_of_type_DovComQqImCaptureViewProviderView = null;
    }
    ProviderView localProviderView;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(this.jdField_a_of_type_Bmyy.c(paramInt)))) {
      localProviderView = (ProviderView)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(this.jdField_a_of_type_Bmyy.c(paramInt)));
    }
    do
    {
      for (;;)
      {
        if (localProviderView != null)
        {
          if (!localProviderView.d) {
            localProviderView.a(null);
          }
          this.jdField_a_of_type_DovComQqImCaptureViewProviderView = localProviderView;
          this.jdField_a_of_type_DovComQqImCaptureViewProviderView.setAlpha(1.0F);
          this.jdField_a_of_type_DovComQqImCaptureViewProviderView.setVisibility(0);
          this.jdField_a_of_type_DovComQqImCaptureViewProviderView.c();
        }
        return;
        int i = this.jdField_a_of_type_Bmyy.c(paramInt);
        localProviderView = this.jdField_a_of_type_Bmyy.a(getContext(), i);
        if (localProviderView == null) {
          break;
        }
        this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(this.jdField_a_of_type_Bmyy.c(paramInt)), localProviderView);
        this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(localProviderView);
      }
    } while (!QLog.isColorLevel());
    QLog.e("ProviderContainerView", 2, "build provider view failed " + paramInt);
  }
  
  public <T extends ProviderView> T a(Class<? extends ProviderView> paramClass)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.values().iterator();
    while (localIterator.hasNext())
    {
      ProviderView localProviderView = (ProviderView)localIterator.next();
      if (paramClass.isInstance(localProviderView)) {
        return localProviderView;
      }
    }
    return null;
  }
  
  public void a()
  {
    if (!this.jdField_a_of_type_JavaUtilHashMap.isEmpty())
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
      while (localIterator.hasNext()) {
        ((ProviderView)((Map.Entry)localIterator.next()).getValue()).a();
      }
    }
  }
  
  public void a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount()))
    {
      if (QLog.isColorLevel()) {
        QLog.e("ProviderContainerView", 2, "doOpenProviderView failed out bounds" + paramInt + " size:" + this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount());
      }
      return;
    }
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setSelected(false);
    }
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(paramInt);
    this.jdField_a_of_type_AndroidViewView.setSelected(true);
    c(paramInt);
  }
  
  @TargetApi(11)
  public void a(int paramInt, List<Integer> paramList)
  {
    this.jdField_a_of_type_Bmyy = new bmyy(paramInt, paramList);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    paramInt = 0;
    while (paramInt < this.jdField_a_of_type_Bmyy.a())
    {
      paramList = new PressScaleImageView(getContext());
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams.weight = 1.0F;
      localLayoutParams.gravity = 16;
      paramList.setTag(Integer.valueOf(paramInt));
      paramList.setId(this.jdField_a_of_type_Bmyy.b(paramInt));
      paramList.setImageResource(this.jdField_a_of_type_Bmyy.a(paramInt));
      paramList.setScaleType(ImageView.ScaleType.CENTER);
      paramList.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      a(paramList, paramInt);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramList, localLayoutParams);
      paramInt += 1;
    }
    paramList = this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
    paramList.height = UIUtils.dip2px(getContext(), 272.0F);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams(paramList);
  }
  
  public void b(int paramInt)
  {
    String str = null;
    if (paramInt == 102) {
      str = "0X800B3D1";
    }
    for (;;)
    {
      if (str != null) {
        bbpr.a(str, this.jdField_a_of_type_Int);
      }
      return;
      if (paramInt == 101) {
        str = "0X800B3CD";
      } else if (paramInt == 100) {
        str = "0X800B3CF";
      }
    }
  }
  
  public void setEditActivityEntrance(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void setProviderContainViewListener(bmyw parambmyw)
  {
    this.jdField_a_of_type_Bmyw = parambmyw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.capture.view.ProviderContainerView
 * JD-Core Version:    0.7.0.1
 */