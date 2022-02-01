package com.tencent.mobileqq.kandian.biz.dislike;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.kandian.repo.dislike.DislikeInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class ReadInJoyDisLikeDialogView
  extends FrameLayout
  implements View.OnClickListener
{
  private View jdField_a_of_type_AndroidViewView;
  protected Button a;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  protected RelativeLayout a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  protected ReadInJoyDisLikeDialogView.OnComplainListener a;
  protected ReadInJoyDisLikeDialogView.OnUninterestConfirmListener a;
  protected Boolean a;
  protected ArrayList<DislikeInfo> a;
  protected int[] a;
  private View[] jdField_a_of_type_ArrayOfAndroidViewView;
  private Button[] jdField_a_of_type_ArrayOfAndroidWidgetButton;
  private RelativeLayout b;
  protected ArrayList<DislikeInfo> b;
  protected int[] b;
  
  public ReadInJoyDisLikeDialogView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(true);
    this.jdField_a_of_type_ArrayOfInt = new int[] { 2131380192, 2131380193, 2131380194, 2131380195, 2131380196, 2131380197, 2131380198, 2131380199 };
    this.jdField_b_of_type_ArrayOfInt = new int[] { 2131380187, 2131380188, 2131380189, 2131380190 };
    a(paramContext);
  }
  
  private void b()
  {
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
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizDislikeReadInJoyDisLikeDialogView$OnUninterestConfirmListener = null;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizDislikeReadInJoyDisLikeDialogView$OnComplainListener = null;
  }
  
  protected void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(paramContext).inflate(2131560095, this);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131380185));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(getResources().getColor(2131167394));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380203));
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380200));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramContext.getString(2131699883));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131380182));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    paramContext = this.jdField_a_of_type_AndroidWidgetButton;
    int j = 0;
    paramContext.setEnabled(false);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131380184));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(Color.parseColor("#FFF6F7FA"));
    this.jdField_a_of_type_ArrayOfAndroidWidgetButton = new Button[this.jdField_a_of_type_ArrayOfInt.length];
    int i = 0;
    for (;;)
    {
      paramContext = this.jdField_a_of_type_ArrayOfInt;
      if (i >= paramContext.length) {
        break;
      }
      this.jdField_a_of_type_ArrayOfAndroidWidgetButton[i] = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(paramContext[i]));
      this.jdField_a_of_type_ArrayOfAndroidWidgetButton[i].setOnClickListener(this);
      i += 1;
    }
    this.jdField_a_of_type_ArrayOfAndroidViewView = new View[this.jdField_b_of_type_ArrayOfInt.length];
    i = j;
    for (;;)
    {
      paramContext = this.jdField_b_of_type_ArrayOfInt;
      if (i >= paramContext.length) {
        break;
      }
      this.jdField_a_of_type_ArrayOfAndroidViewView[i] = this.jdField_a_of_type_AndroidViewView.findViewById(paramContext[i]);
      i += 1;
    }
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    Object localObject;
    if (i == 2131380182)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizDislikeReadInJoyDisLikeDialogView$OnUninterestConfirmListener;
      if ((localObject == null) || (((ReadInJoyDisLikeDialogView.OnUninterestConfirmListener)localObject).a(paramView, this.jdField_b_of_type_JavaUtilArrayList, null))) {
        a();
      }
    }
    else if (i == 2131380184)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizDislikeReadInJoyDisLikeDialogView$OnComplainListener;
      if (localObject != null) {
        ((ReadInJoyDisLikeDialogView.OnComplainListener)localObject).a();
      }
      a();
    }
    else
    {
      i = 0;
      while (i < this.jdField_a_of_type_ArrayOfInt.length)
      {
        if (paramView.getId() == this.jdField_a_of_type_ArrayOfInt[i]) {
          break label115;
        }
        i += 1;
      }
      i = -1;
      label115:
      if (i != -1)
      {
        if (this.jdField_a_of_type_ArrayOfAndroidWidgetButton[i].isSelected())
        {
          this.jdField_a_of_type_ArrayOfAndroidWidgetButton[i].setSelected(false);
          this.jdField_b_of_type_JavaUtilArrayList.remove(this.jdField_a_of_type_JavaUtilArrayList.get(i));
        }
        else
        {
          if (!this.jdField_a_of_type_JavaLangBoolean.booleanValue())
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
        if (this.jdField_b_of_type_JavaUtilArrayList.size() == 0) {
          this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
        } else {
          this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void setOnComplainListener(ReadInJoyDisLikeDialogView.OnComplainListener paramOnComplainListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizDislikeReadInJoyDisLikeDialogView$OnComplainListener = paramOnComplainListener;
  }
  
  public void setOnUninterestConfirmListener(ReadInJoyDisLikeDialogView.OnUninterestConfirmListener paramOnUninterestConfirmListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizDislikeReadInJoyDisLikeDialogView$OnUninterestConfirmListener = paramOnUninterestConfirmListener;
  }
  
  public void setUninterestData(ArrayList<DislikeInfo> paramArrayList)
  {
    ArrayList localArrayList = this.jdField_b_of_type_JavaUtilArrayList;
    if (localArrayList == null) {
      this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    } else {
      localArrayList.clear();
    }
    localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    if (localArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    } else {
      localArrayList.clear();
    }
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.dislike.ReadInJoyDisLikeDialogView
 * JD-Core Version:    0.7.0.1
 */