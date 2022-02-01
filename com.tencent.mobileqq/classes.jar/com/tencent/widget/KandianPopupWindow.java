package com.tencent.widget;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.IBinder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.kandian.repo.dislike.DislikeInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class KandianPopupWindow
  extends PopupWindow
  implements View.OnClickListener
{
  protected int a;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private View jdField_a_of_type_AndroidViewView;
  protected Button a;
  protected ImageView a;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  protected KandianPopupWindow.OnComplainListener a;
  protected KandianPopupWindow.OnUninterestConfirmListener a;
  protected ArrayList<DislikeInfo> a;
  protected boolean a;
  protected int[] a;
  private View[] jdField_a_of_type_ArrayOfAndroidViewView;
  private Button[] jdField_a_of_type_ArrayOfAndroidWidgetButton;
  private int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
  private Button jdField_b_of_type_AndroidWidgetButton;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  protected ArrayList<DislikeInfo> b;
  private boolean jdField_b_of_type_Boolean;
  protected int[] b;
  private int jdField_c_of_type_Int;
  private View jdField_c_of_type_AndroidViewView;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private boolean jdField_c_of_type_Boolean;
  private int d;
  private int e;
  
  public KandianPopupWindow(Activity paramActivity)
  {
    super(paramActivity);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ArrayOfInt = new int[] { 2131380187, 2131380188, 2131380189, 2131380190 };
    this.jdField_b_of_type_ArrayOfInt = new int[] { 2131380192, 2131380193, 2131380194, 2131380195, 2131380196, 2131380197, 2131380198, 2131380199 };
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidAppActivity.getString(2131699883));
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
  }
  
  private void e()
  {
    d();
    int j = this.jdField_a_of_type_JavaUtilArrayList.size();
    Button[] arrayOfButton = this.jdField_a_of_type_ArrayOfAndroidWidgetButton;
    int i = j;
    if (j >= arrayOfButton.length) {
      i = arrayOfButton.length;
    }
    j = 0;
    while (j < i)
    {
      if (TextUtils.isEmpty(((DislikeInfo)this.jdField_a_of_type_JavaUtilArrayList.get(j)).a))
      {
        this.jdField_a_of_type_ArrayOfAndroidWidgetButton[j].setVisibility(8);
      }
      else
      {
        this.jdField_a_of_type_ArrayOfAndroidWidgetButton[j].setVisibility(0);
        this.jdField_a_of_type_ArrayOfAndroidWidgetButton[j].setText(((DislikeInfo)this.jdField_a_of_type_JavaUtilArrayList.get(j)).a);
      }
      this.jdField_a_of_type_ArrayOfAndroidWidgetButton[j].setSelected(false);
      j += 1;
    }
    j = i;
    int k;
    for (;;)
    {
      arrayOfButton = this.jdField_a_of_type_ArrayOfAndroidWidgetButton;
      int m = arrayOfButton.length;
      k = 1;
      if (j >= m) {
        break;
      }
      if ((j == i) && (i % 2 == 1)) {
        arrayOfButton[j].setVisibility(4);
      } else {
        this.jdField_a_of_type_ArrayOfAndroidWidgetButton[j].setVisibility(8);
      }
      this.jdField_a_of_type_ArrayOfAndroidWidgetButton[j].setSelected(false);
      j += 1;
    }
    for (;;)
    {
      arrayOfButton = this.jdField_a_of_type_ArrayOfAndroidWidgetButton;
      if (k >= arrayOfButton.length) {
        break;
      }
      if (arrayOfButton[k].getVisibility() == 8) {
        this.jdField_a_of_type_ArrayOfAndroidViewView[(k / 2)].setVisibility(8);
      } else {
        this.jdField_a_of_type_ArrayOfAndroidViewView[(k / 2)].setVisibility(0);
      }
      k += 2;
    }
  }
  
  private void f()
  {
    this.jdField_a_of_type_AndroidViewView.measure(0, 0);
    this.jdField_c_of_type_Int = this.jdField_a_of_type_AndroidViewView.getMeasuredHeight();
  }
  
  public void a()
  {
    this.d = ((int)DeviceInfoUtil.i());
    this.e = ((int)DeviceInfoUtil.j());
    this.jdField_a_of_type_AndroidViewView = ((LayoutInflater)this.jdField_a_of_type_AndroidAppActivity.getSystemService("layout_inflater")).inflate(2131560095, null);
    setContentView(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131380191));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131380183));
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131380185);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380200));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131380182));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380186));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131380184));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380203));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380202));
    this.jdField_a_of_type_ArrayOfAndroidViewView = new View[this.jdField_a_of_type_ArrayOfInt.length];
    int i = 0;
    int[] arrayOfInt;
    for (;;)
    {
      arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
      if (i >= arrayOfInt.length) {
        break;
      }
      this.jdField_a_of_type_ArrayOfAndroidViewView[i] = this.jdField_a_of_type_AndroidViewView.findViewById(arrayOfInt[i]);
      i += 1;
    }
    this.jdField_a_of_type_ArrayOfAndroidWidgetButton = new Button[this.jdField_b_of_type_ArrayOfInt.length];
    i = 0;
    for (;;)
    {
      arrayOfInt = this.jdField_b_of_type_ArrayOfInt;
      if (i >= arrayOfInt.length) {
        break;
      }
      this.jdField_a_of_type_ArrayOfAndroidWidgetButton[i] = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(arrayOfInt[i]));
      this.jdField_a_of_type_ArrayOfAndroidWidgetButton[i].setOnClickListener(this);
      i += 1;
    }
    setHeight(-2);
    setBackgroundDrawable(new ColorDrawable(0));
    setOnDismissListener(new KandianPopupWindow.1(this));
    setTouchable(true);
    setFocusable(true);
    setOutsideTouchable(false);
    this.jdField_b_of_type_Boolean = true;
  }
  
  protected void a(IBinder paramIBinder)
  {
    WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams();
    localLayoutParams.width = -1;
    localLayoutParams.height = -1;
    localLayoutParams.format = -3;
    localLayoutParams.type = 1000;
    localLayoutParams.token = paramIBinder;
    localLayoutParams.windowAnimations = 16973828;
    this.jdField_c_of_type_AndroidViewView = new View(this.jdField_a_of_type_AndroidAppActivity.getApplicationContext());
    this.jdField_c_of_type_AndroidViewView.setBackgroundColor(-1895825408);
    this.jdField_c_of_type_AndroidViewView.setFitsSystemWindows(false);
    this.jdField_c_of_type_AndroidViewView.setOnKeyListener(new KandianPopupWindow.2(this));
    this.jdField_a_of_type_AndroidAppActivity.getWindowManager().addView(this.jdField_c_of_type_AndroidViewView, localLayoutParams);
  }
  
  public void a(View paramView, KandianPopupWindow.OnUninterestConfirmListener paramOnUninterestConfirmListener)
  {
    this.jdField_a_of_type_ComTencentWidgetKandianPopupWindow$OnUninterestConfirmListener = paramOnUninterestConfirmListener;
    a(paramView.getWindowToken());
    paramOnUninterestConfirmListener = new int[2];
    paramView.getLocationOnScreen(paramOnUninterestConfirmListener);
    if (!this.jdField_c_of_type_Boolean)
    {
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("DeviceInfoUtil.getWidth() = ");
        localStringBuilder.append(this.d);
        localStringBuilder.append(", DeviceInfoUtil.getHeight() = ");
        localStringBuilder.append(this.e);
        QLog.d("KandianPopupWindow", 2, localStringBuilder.toString());
      }
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("popupWidth = ");
        localStringBuilder.append(this.jdField_b_of_type_Int);
        localStringBuilder.append(", popupHeight = ");
        localStringBuilder.append(this.jdField_c_of_type_Int);
        QLog.d("KandianPopupWindow", 2, localStringBuilder.toString());
      }
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("x = ");
        localStringBuilder.append(paramOnUninterestConfirmListener[0]);
        localStringBuilder.append(", y = ");
        localStringBuilder.append(paramOnUninterestConfirmListener[1]);
        QLog.d("KandianPopupWindow", 2, localStringBuilder.toString());
      }
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("parent.getWidth() = ");
        localStringBuilder.append(paramView.getWidth());
        localStringBuilder.append(", parent.getHeight() = ");
        localStringBuilder.append(paramView.getHeight());
        QLog.d("KandianPopupWindow", 2, localStringBuilder.toString());
      }
      int j = this.e;
      int k = paramOnUninterestConfirmListener[1];
      int m = paramView.getHeight();
      int i = paramOnUninterestConfirmListener[1];
      i = (int)this.jdField_a_of_type_AndroidAppActivity.getResources().getDimension(2131298867);
      int n = this.jdField_b_of_type_Int - paramOnUninterestConfirmListener[0] - paramView.getWidth() / 2 + i;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("marginRight = ");
        localStringBuilder.append(n);
        QLog.d("KandianPopupWindow", 2, localStringBuilder.toString());
      }
      double d1;
      double d2;
      if (j - (k + m) > this.jdField_c_of_type_Int)
      {
        d1 = n;
        d2 = this.jdField_b_of_type_Int;
        Double.isNaN(d2);
        if (d1 > d2 * 0.1D) {
          setAnimationStyle(2131755041);
        } else {
          setAnimationStyle(2131755040);
        }
        this.jdField_b_of_type_AndroidWidgetImageView.setPadding(0, 0, n, 0);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
        j = paramOnUninterestConfirmListener[1] + paramView.getHeight() / 2 + AIOUtils.b(9.5F, this.jdField_a_of_type_AndroidAppActivity.getResources());
        showAtLocation(paramView, 0, i, j);
        if (QLog.isColorLevel())
        {
          paramView = new StringBuilder();
          paramView.append("show x = ");
          paramView.append(i);
          paramView.append(", show y = ");
          paramView.append(j);
          QLog.d("KandianPopupWindow", 2, paramView.toString());
        }
      }
      else
      {
        d1 = n;
        d2 = this.jdField_b_of_type_Int;
        Double.isNaN(d2);
        if (d1 > d2 * 0.1D) {
          setAnimationStyle(2131755044);
        } else {
          setAnimationStyle(2131755043);
        }
        this.jdField_c_of_type_AndroidWidgetImageView.setPadding(0, 0, n, 0);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
        j = paramOnUninterestConfirmListener[1] + paramView.getHeight() / 2 - AIOUtils.b(9.5F, this.jdField_a_of_type_AndroidAppActivity.getResources()) - this.jdField_c_of_type_Int;
        showAtLocation(paramView, 0, i, j);
        if (QLog.isColorLevel())
        {
          paramView = new StringBuilder();
          paramView.append("show x = ");
          paramView.append(i);
          paramView.append(", show y = ");
          paramView.append(j);
          QLog.d("KandianPopupWindow", 2, paramView.toString());
        }
      }
    }
    else
    {
      setAnimationStyle(2131755042);
      showAtLocation(paramView, 0, paramOnUninterestConfirmListener[0] + paramView.getWidth() / 2 - AIOUtils.b(10.5F, this.jdField_a_of_type_AndroidAppActivity.getResources()) - (int)this.jdField_a_of_type_AndroidAppActivity.getResources().getDimension(2131298868), paramOnUninterestConfirmListener[1] + paramView.getHeight() / 2 - this.jdField_c_of_type_Int / 2);
    }
    ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).setIsShowPopup(true);
  }
  
  public void a(KandianPopupWindow.OnComplainListener paramOnComplainListener)
  {
    this.jdField_a_of_type_ComTencentWidgetKandianPopupWindow$OnComplainListener = paramOnComplainListener;
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public boolean a(int paramInt, ArrayList<DislikeInfo> paramArrayList)
  {
    if (paramInt == -1) {
      return false;
    }
    this.jdField_a_of_type_Int = paramInt;
    ArrayList localArrayList = this.jdField_b_of_type_JavaUtilArrayList;
    if (localArrayList == null) {
      this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    } else {
      localArrayList.clear();
    }
    if ((paramArrayList != null) && (paramArrayList.size() != 0))
    {
      this.jdField_c_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_b_of_type_Int = ((int)(this.d - this.jdField_a_of_type_AndroidAppActivity.getResources().getDimension(2131298867) * 2.0F));
      setWidth(this.jdField_b_of_type_Int);
      localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
      if (localArrayList == null) {
        this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      } else {
        localArrayList.clear();
      }
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
      e();
    }
    else
    {
      this.jdField_c_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_b_of_type_Int = ((int)this.jdField_a_of_type_AndroidAppActivity.getResources().getDimension(2131298868));
      setWidth(this.jdField_b_of_type_Int);
    }
    f();
    return true;
  }
  
  public void b()
  {
    Object localObject = this.jdField_b_of_type_AndroidWidgetRelativeLayout;
    if (localObject != null) {
      ((RelativeLayout)localObject).setVisibility(0);
    }
    localObject = this.jdField_b_of_type_AndroidViewView;
    if (localObject != null) {
      ((View)localObject).setBackgroundResource(2130843158);
    }
    localObject = this.jdField_c_of_type_AndroidWidgetImageView;
    if (localObject != null)
    {
      ((ImageView)localObject).setImageResource(2130843168);
      if (RelativeLayout.LayoutParams.class.isInstance(this.jdField_c_of_type_AndroidWidgetImageView.getLayoutParams()))
      {
        localObject = (RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidWidgetImageView.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).addRule(3, 2131380184);
        this.jdField_c_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
  }
  
  protected void c()
  {
    if (this.jdField_c_of_type_AndroidViewView != null)
    {
      this.jdField_a_of_type_AndroidAppActivity.getWindowManager().removeView(this.jdField_c_of_type_AndroidViewView);
      this.jdField_c_of_type_AndroidViewView = null;
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject;
    switch (paramView.getId())
    {
    default: 
      i = 0;
      break;
    case 2131380184: 
      localObject = this.jdField_a_of_type_ComTencentWidgetKandianPopupWindow$OnComplainListener;
      if (localObject != null) {
        ((KandianPopupWindow.OnComplainListener)localObject).a();
      }
      dismiss();
      break;
    case 2131380182: 
    case 2131380183: 
      localObject = this.jdField_a_of_type_ComTencentWidgetKandianPopupWindow$OnUninterestConfirmListener;
      if (localObject != null) {
        ((KandianPopupWindow.OnUninterestConfirmListener)localObject).a(paramView, this.jdField_a_of_type_Int, this.jdField_b_of_type_JavaUtilArrayList, null);
      }
      dismiss();
      break;
    }
    while (i < this.jdField_b_of_type_ArrayOfInt.length)
    {
      if (paramView.getId() == this.jdField_b_of_type_ArrayOfInt[i]) {
        break label131;
      }
      i += 1;
    }
    int i = -1;
    label131:
    if (i != -1)
    {
      if (this.jdField_a_of_type_ArrayOfAndroidWidgetButton[i].isSelected())
      {
        this.jdField_a_of_type_ArrayOfAndroidWidgetButton[i].setSelected(false);
        this.jdField_b_of_type_JavaUtilArrayList.remove(this.jdField_a_of_type_JavaUtilArrayList.get(i));
      }
      else
      {
        if (!this.jdField_a_of_type_Boolean)
        {
          localObject = this.jdField_a_of_type_ArrayOfAndroidWidgetButton;
          int k = localObject.length;
          int j = 0;
          while (j < k)
          {
            localObject[j].setSelected(false);
            j += 1;
          }
          this.jdField_b_of_type_JavaUtilArrayList.clear();
        }
        this.jdField_a_of_type_ArrayOfAndroidWidgetButton[i].setSelected(true);
        this.jdField_b_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_JavaUtilArrayList.get(i));
      }
      if (this.jdField_b_of_type_JavaUtilArrayList.size() == 0)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidAppActivity.getString(2131699883));
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      }
      else
      {
        if (this.jdField_a_of_type_Boolean) {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(String.format(this.jdField_a_of_type_AndroidAppActivity.getString(2131699884), new Object[] { Integer.valueOf(this.jdField_b_of_type_JavaUtilArrayList.size()) }));
        }
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.KandianPopupWindow
 * JD-Core Version:    0.7.0.1
 */