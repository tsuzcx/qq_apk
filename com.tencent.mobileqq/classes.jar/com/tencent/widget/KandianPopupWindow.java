package com.tencent.widget;

import amcj;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyChannelActivity;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
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
  public KandianPopupWindow.OnUninterestConfirmListener a;
  protected ArrayList a;
  private boolean jdField_a_of_type_Boolean;
  protected int[] a;
  private View[] jdField_a_of_type_ArrayOfAndroidViewView;
  private Button[] jdField_a_of_type_ArrayOfAndroidWidgetButton;
  private int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
  private Button jdField_b_of_type_AndroidWidgetButton;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  protected ArrayList b;
  private boolean jdField_b_of_type_Boolean;
  protected int[] b;
  private int jdField_c_of_type_Int;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private int d;
  private int e;
  
  public KandianPopupWindow(Activity paramActivity)
  {
    super(paramActivity);
    this.jdField_a_of_type_ArrayOfInt = new int[] { 2131366902, 2131366905, 2131366908, 2131366911 };
    this.jdField_b_of_type_ArrayOfInt = new int[] { 2131366903, 2131366904, 2131366906, 2131366907, 2131366909, 2131366910, 2131366912, 2131366913 };
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  private void a(float paramFloat)
  {
    if ((this.jdField_a_of_type_AndroidAppActivity instanceof ReadInJoyChannelActivity)) {
      return;
    }
    WindowManager.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidAppActivity.getWindow().getAttributes();
    localLayoutParams.alpha = paramFloat;
    this.jdField_a_of_type_AndroidAppActivity.getWindow().setAttributes(localLayoutParams);
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidAppActivity.getString(2131428474));
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
  }
  
  private void c()
  {
    b();
    int i = this.jdField_a_of_type_JavaUtilArrayList.size();
    if (i >= this.jdField_a_of_type_ArrayOfAndroidWidgetButton.length)
    {
      i = this.jdField_a_of_type_ArrayOfAndroidWidgetButton.length;
      j = 0;
      label29:
      if (j >= i) {
        break label121;
      }
      if (!TextUtils.isEmpty(((DislikeInfo)this.jdField_a_of_type_JavaUtilArrayList.get(j)).a)) {
        break label85;
      }
      this.jdField_a_of_type_ArrayOfAndroidWidgetButton[j].setVisibility(8);
    }
    for (;;)
    {
      this.jdField_a_of_type_ArrayOfAndroidWidgetButton[j].setSelected(false);
      j += 1;
      break label29;
      break;
      label85:
      this.jdField_a_of_type_ArrayOfAndroidWidgetButton[j].setVisibility(0);
      this.jdField_a_of_type_ArrayOfAndroidWidgetButton[j].setText(((DislikeInfo)this.jdField_a_of_type_JavaUtilArrayList.get(j)).a);
    }
    label121:
    int j = i;
    if (j < this.jdField_a_of_type_ArrayOfAndroidWidgetButton.length)
    {
      if ((j == i) && (i % 2 == 1)) {
        this.jdField_a_of_type_ArrayOfAndroidWidgetButton[j].setVisibility(4);
      }
      for (;;)
      {
        this.jdField_a_of_type_ArrayOfAndroidWidgetButton[j].setSelected(false);
        j += 1;
        break;
        this.jdField_a_of_type_ArrayOfAndroidWidgetButton[j].setVisibility(8);
      }
    }
    i = 1;
    if (i < this.jdField_a_of_type_ArrayOfAndroidWidgetButton.length)
    {
      if (this.jdField_a_of_type_ArrayOfAndroidWidgetButton[i].getVisibility() == 8) {
        this.jdField_a_of_type_ArrayOfAndroidViewView[(i / 2)].setVisibility(8);
      }
      for (;;)
      {
        i += 2;
        break;
        this.jdField_a_of_type_ArrayOfAndroidViewView[(i / 2)].setVisibility(0);
      }
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidViewView.measure(0, 0);
    this.jdField_c_of_type_Int = this.jdField_a_of_type_AndroidViewView.getMeasuredHeight();
  }
  
  public void a()
  {
    this.d = ((int)DeviceInfoUtil.j());
    this.e = ((int)DeviceInfoUtil.k());
    this.jdField_a_of_type_AndroidViewView = ((LayoutInflater)this.jdField_a_of_type_AndroidAppActivity.getSystemService("layout_inflater")).inflate(2130969549, null);
    setContentView(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131366898));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131366917));
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131366900);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366901));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131366915));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366914));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366899));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366916));
    this.jdField_a_of_type_ArrayOfAndroidViewView = new View[this.jdField_a_of_type_ArrayOfInt.length];
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfInt.length)
    {
      this.jdField_a_of_type_ArrayOfAndroidViewView[i] = this.jdField_a_of_type_AndroidViewView.findViewById(this.jdField_a_of_type_ArrayOfInt[i]);
      i += 1;
    }
    this.jdField_a_of_type_ArrayOfAndroidWidgetButton = new Button[this.jdField_b_of_type_ArrayOfInt.length];
    i = 0;
    while (i < this.jdField_b_of_type_ArrayOfInt.length)
    {
      this.jdField_a_of_type_ArrayOfAndroidWidgetButton[i] = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(this.jdField_b_of_type_ArrayOfInt[i]));
      this.jdField_a_of_type_ArrayOfAndroidWidgetButton[i].setOnClickListener(this);
      i += 1;
    }
    setHeight(-2);
    setBackgroundDrawable(new ColorDrawable(0));
    setOnDismissListener(new amcj(this));
    setTouchable(true);
    setFocusable(true);
    setOutsideTouchable(false);
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(View paramView, KandianPopupWindow.OnUninterestConfirmListener paramOnUninterestConfirmListener)
  {
    this.jdField_a_of_type_ComTencentWidgetKandianPopupWindow$OnUninterestConfirmListener = paramOnUninterestConfirmListener;
    a(0.8F);
    paramOnUninterestConfirmListener = new int[2];
    paramView.getLocationOnScreen(paramOnUninterestConfirmListener);
    int j;
    int i;
    int n;
    if (!this.jdField_b_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("KandianPopupWindow", 2, "DeviceInfoUtil.getWidth() = " + this.d + ", DeviceInfoUtil.getHeight() = " + this.e);
      }
      if (QLog.isColorLevel()) {
        QLog.d("KandianPopupWindow", 2, "popupWidth = " + this.jdField_b_of_type_Int + ", popupHeight = " + this.jdField_c_of_type_Int);
      }
      if (QLog.isColorLevel()) {
        QLog.d("KandianPopupWindow", 2, "x = " + paramOnUninterestConfirmListener[0] + ", y = " + paramOnUninterestConfirmListener[1]);
      }
      if (QLog.isColorLevel()) {
        QLog.d("KandianPopupWindow", 2, "parent.getWidth() = " + paramView.getWidth() + ", parent.getHeight() = " + paramView.getHeight());
      }
      j = this.e;
      int k = paramOnUninterestConfirmListener[1];
      int m = paramView.getHeight();
      i = paramOnUninterestConfirmListener[1];
      i = (int)this.jdField_a_of_type_AndroidAppActivity.getResources().getDimension(2131559702);
      n = this.jdField_b_of_type_Int - paramOnUninterestConfirmListener[0] - paramView.getWidth() / 2 + i;
      if (QLog.isColorLevel()) {
        QLog.d("KandianPopupWindow", 2, "marginRight = " + n);
      }
      if (j - (k + m) > this.jdField_c_of_type_Int) {
        if (n > this.jdField_b_of_type_Int * 0.1D)
        {
          setAnimationStyle(2131624706);
          this.jdField_b_of_type_AndroidWidgetImageView.setPadding(0, 0, n, 0);
          this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
          j = paramOnUninterestConfirmListener[1] + paramView.getHeight() / 2 + AIOUtils.a(9.5F, this.jdField_a_of_type_AndroidAppActivity.getResources());
          showAtLocation(paramView, 0, i, j);
          if (QLog.isColorLevel()) {
            QLog.d("KandianPopupWindow", 2, "show x = " + i + ", show y = " + j);
          }
        }
      }
    }
    for (;;)
    {
      com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils.jdField_a_of_type_Boolean = true;
      return;
      setAnimationStyle(2131624705);
      break;
      if (n > this.jdField_b_of_type_Int * 0.1D) {
        setAnimationStyle(2131624704);
      }
      for (;;)
      {
        this.jdField_c_of_type_AndroidWidgetImageView.setPadding(0, 0, n, 0);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
        j = paramOnUninterestConfirmListener[1] + paramView.getHeight() / 2 - AIOUtils.a(9.5F, this.jdField_a_of_type_AndroidAppActivity.getResources()) - this.jdField_c_of_type_Int;
        showAtLocation(paramView, 0, i, j);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("KandianPopupWindow", 2, "show x = " + i + ", show y = " + j);
        break;
        setAnimationStyle(2131624703);
      }
      setAnimationStyle(2131624707);
      showAtLocation(paramView, 0, paramOnUninterestConfirmListener[0] + paramView.getWidth() / 2 - AIOUtils.a(10.5F, this.jdField_a_of_type_AndroidAppActivity.getResources()) - (int)this.jdField_a_of_type_AndroidAppActivity.getResources().getDimension(2131559701), paramOnUninterestConfirmListener[1] + paramView.getHeight() / 2 - this.jdField_c_of_type_Int / 2);
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(int paramInt, ArrayList paramArrayList)
  {
    if (paramInt == -1) {
      return false;
    }
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_b_of_type_JavaUtilArrayList == null) {
      this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    }
    while ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      this.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_b_of_type_Int = ((int)this.jdField_a_of_type_AndroidAppActivity.getResources().getDimension(2131559701));
      setWidth(this.jdField_b_of_type_Int);
      d();
      return true;
      this.jdField_b_of_type_JavaUtilArrayList.clear();
    }
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
    this.jdField_b_of_type_Int = ((int)(this.d - this.jdField_a_of_type_AndroidAppActivity.getResources().getDimension(2131559702) * 2.0F));
    setWidth(this.jdField_b_of_type_Int);
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
      c();
      break;
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
  }
  
  public void onClick(View paramView)
  {
    int i;
    switch (paramView.getId())
    {
    case 2131366916: 
    default: 
      i = 0;
      label34:
      if (i < this.jdField_b_of_type_ArrayOfInt.length) {
        if (paramView.getId() != this.jdField_b_of_type_ArrayOfInt[i]) {
          break;
        }
      }
      break;
    }
    for (;;)
    {
      if (i != -1)
      {
        if (!this.jdField_a_of_type_ArrayOfAndroidWidgetButton[i].isSelected()) {
          break label174;
        }
        this.jdField_a_of_type_ArrayOfAndroidWidgetButton[i].setSelected(false);
        this.jdField_b_of_type_JavaUtilArrayList.remove(this.jdField_a_of_type_JavaUtilArrayList.get(i));
      }
      for (;;)
      {
        if (this.jdField_b_of_type_JavaUtilArrayList.size() != 0) {
          break label203;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidAppActivity.getString(2131428474));
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
        return;
        if (this.jdField_a_of_type_ComTencentWidgetKandianPopupWindow$OnUninterestConfirmListener != null) {
          this.jdField_a_of_type_ComTencentWidgetKandianPopupWindow$OnUninterestConfirmListener.a(paramView, this.jdField_a_of_type_Int, this.jdField_b_of_type_JavaUtilArrayList, null);
        }
        dismiss();
        break;
        i += 1;
        break label34;
        label174:
        this.jdField_a_of_type_ArrayOfAndroidWidgetButton[i].setSelected(true);
        this.jdField_b_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_JavaUtilArrayList.get(i));
      }
      label203:
      this.jdField_a_of_type_AndroidWidgetTextView.setText(String.format(this.jdField_a_of_type_AndroidAppActivity.getString(2131428475), new Object[] { Integer.valueOf(this.jdField_b_of_type_JavaUtilArrayList.size()) }));
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      return;
      i = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.widget.KandianPopupWindow
 * JD-Core Version:    0.7.0.1
 */