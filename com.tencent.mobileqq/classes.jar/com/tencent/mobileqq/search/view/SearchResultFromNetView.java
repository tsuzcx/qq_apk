package com.tencent.mobileqq.search.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.search.base.view.SearchResultView;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.troop.widget.TroopActiveLayout;
import com.tencent.mobileqq.troop.widget.TroopLabelLayout;
import com.tencent.mobileqq.widget.FolderTextView;
import com.tencent.widget.ThemeImageView;
import com.tencent.widget.ThemeImageWrapper;

public class SearchResultFromNetView
  extends SearchResultView
{
  private View jdField_a_of_type_AndroidViewView;
  public Button a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private TroopActiveLayout jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopActiveLayout;
  private TroopLabelLayout jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout;
  private FolderTextView jdField_a_of_type_ComTencentMobileqqWidgetFolderTextView;
  private int jdField_b_of_type_Int;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private TroopLabelLayout jdField_b_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout;
  public ImageView c;
  private TextView c;
  private View d;
  public ImageView d;
  private View jdField_e_of_type_AndroidViewView;
  private ImageView jdField_e_of_type_AndroidWidgetImageView;
  
  public SearchResultFromNetView(ViewGroup paramViewGroup, int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    paramInt = this.jdField_b_of_type_Int;
    if (paramInt != 3)
    {
      if (paramInt != 268435456)
      {
        if (paramInt != 1001)
        {
          if (paramInt != 1002) {
            this.jdField_a_of_type_Int = 2131559831;
          } else {
            this.jdField_a_of_type_Int = 2131561239;
          }
        }
        else {
          this.jdField_a_of_type_Int = 2131561238;
        }
      }
      else {
        this.jdField_a_of_type_Int = 2131559797;
      }
    }
    else {
      this.jdField_a_of_type_Int = 2131560448;
    }
    paramViewGroup.getResources();
    LinearLayout localLinearLayout = new LinearLayout(paramViewGroup.getContext());
    localLinearLayout.setOrientation(1);
    localLinearLayout.addView(LayoutInflater.from(paramViewGroup.getContext()).inflate(this.jdField_a_of_type_Int, null, false), new LinearLayout.LayoutParams(-1, -2));
    localLinearLayout.setClickable(true);
    localLinearLayout.setFocusable(true);
    this.jdField_b_of_type_AndroidViewView = localLinearLayout;
    a();
  }
  
  public View a(String paramString)
  {
    if ("ActiveEntitySearchResultPresenter_add_troop".equals(paramString)) {
      return this.jdField_a_of_type_AndroidViewView;
    }
    if ("ActiveEntitySearchResultPresenter_pay_troop".equals(paramString)) {
      return this.jdField_d_of_type_AndroidViewView;
    }
    if ("ActiveEntitySearchResultPresenter_hot_troop".equals(paramString)) {
      return this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopActiveLayout;
    }
    if ("ActiveEntitySearchResultPresenter_expand_desc".equals(paramString)) {
      return this.jdField_a_of_type_ComTencentMobileqqWidgetFolderTextView;
    }
    return super.a(paramString);
  }
  
  public TroopLabelLayout a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout;
  }
  
  protected void a()
  {
    super.a();
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131368343));
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131365295));
    int i = this.jdField_b_of_type_Int;
    if (i != 1001)
    {
      if (i == 1002)
      {
        this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131379177));
        this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131379139));
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout = ((TroopLabelLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131379273));
        if (this.d != null)
        {
          localObject = this.d;
          int j = ScreenUtil.SCREEN_WIDTH - ScreenUtil.dip2px(187.0F);
          i = j;
          if (j <= 0) {
            i = ScreenUtil.dip2px(220.0F);
          }
          ((TextView)localObject).setMaxWidth(i);
        }
      }
    }
    else
    {
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_b_of_type_AndroidViewView.findViewById(2131376477));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131376485));
      this.jdField_b_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout = ((TroopLabelLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131379273));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131370723));
      this.jdField_e_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131379859);
    }
    this.jdField_a_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131365211);
    Object localObject = this.jdField_a_of_type_AndroidViewView;
    if (localObject != null) {
      ((View)localObject).setTag("ActiveEntitySearchResultPresenter_add_troop");
    }
    this.jdField_d_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131373070);
    localObject = this.jdField_d_of_type_AndroidViewView;
    if (localObject != null)
    {
      ((View)localObject).setTag("ActiveEntitySearchResultPresenter_pay_troop");
      localObject = this.jdField_d_of_type_AndroidViewView;
      if ((localObject instanceof ThemeImageView)) {
        ((ThemeImageView)localObject).setMaskShape(ThemeImageWrapper.MODE_OTHER);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopActiveLayout = ((TroopActiveLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131362024));
    localObject = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopActiveLayout;
    if (localObject != null) {
      ((TroopActiveLayout)localObject).setTag("ActiveEntitySearchResultPresenter_hot_troop");
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetFolderTextView = ((FolderTextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131367054));
    localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetFolderTextView;
    if (localObject != null) {
      ((FolderTextView)localObject).setTag("ActiveEntitySearchResultPresenter_expand_desc");
    }
  }
  
  public View b()
  {
    return this.jdField_e_of_type_AndroidViewView;
  }
  
  public TroopLabelLayout b()
  {
    return this.jdField_b_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout;
  }
  
  public ImageView c()
  {
    return this.jdField_e_of_type_AndroidWidgetImageView;
  }
  
  public TextView e()
  {
    return this.jdField_a_of_type_AndroidWidgetTextView;
  }
  
  public TextView f()
  {
    return this.jdField_a_of_type_AndroidWidgetButton;
  }
  
  public TextView g()
  {
    return this.jdField_b_of_type_AndroidWidgetTextView;
  }
  
  public TextView h()
  {
    return this.jdField_c_of_type_AndroidWidgetTextView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.view.SearchResultFromNetView
 * JD-Core Version:    0.7.0.1
 */