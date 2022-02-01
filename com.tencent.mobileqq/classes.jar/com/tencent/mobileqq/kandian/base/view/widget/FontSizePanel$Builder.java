package com.tencent.mobileqq.kandian.base.view.widget;

import android.graphics.drawable.BitmapDrawable;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.base.view.api.IFontSizePanelBuilder;
import com.tencent.widget.RangeButtonView;
import com.tencent.widget.RangeButtonView.OnChangeListener;
import com.tencent.widget.RangeButtonView.Title;
import java.util.ArrayList;
import java.util.List;

public class FontSizePanel$Builder
  implements IFontSizePanelBuilder
{
  private int jdField_a_of_type_Int;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private RangeButtonView.OnChangeListener jdField_a_of_type_ComTencentWidgetRangeButtonView$OnChangeListener;
  private List<RangeButtonView.Title> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean = false;
  private List<String> b;
  
  public FontSizePanel$Builder(LayoutInflater paramLayoutInflater)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = paramLayoutInflater;
  }
  
  private float a(float paramFloat)
  {
    float f = TypedValue.applyDimension(1, 16.0F, FontSettingManager.systemMetrics);
    if (paramFloat == 15.0F) {
      return TypedValue.applyDimension(1, 15.0F, FontSettingManager.systemMetrics);
    }
    if (paramFloat == 17.0F) {
      return TypedValue.applyDimension(1, 17.0F, FontSettingManager.systemMetrics);
    }
    if (paramFloat == 18.0F) {
      return TypedValue.applyDimension(1, 18.0F, FontSettingManager.systemMetrics);
    }
    if (paramFloat == 20.0F) {
      f = TypedValue.applyDimension(1, 20.0F, FontSettingManager.systemMetrics);
    }
    return f;
  }
  
  public Builder a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
  
  public Builder a(Object paramObject)
  {
    this.jdField_a_of_type_ComTencentWidgetRangeButtonView$OnChangeListener = ((RangeButtonView.OnChangeListener)paramObject);
    return this;
  }
  
  public Builder a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    return this;
  }
  
  public FontSizePanel a()
  {
    FontSizePanel localFontSizePanel = new FontSizePanel(null);
    Object localObject1 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559104, null);
    FontSizePanel.a(localFontSizePanel, new PopupWindow((View)localObject1, -1, -2));
    FontSizePanel.a(localFontSizePanel).setBackgroundDrawable(new BitmapDrawable());
    FontSizePanel.a(localFontSizePanel).setOutsideTouchable(true);
    localObject1 = (RangeButtonView)((View)localObject1).findViewById(2131367100);
    Object localObject2 = this.jdField_a_of_type_JavaUtilList;
    if ((localObject2 == null) || (((List)localObject2).isEmpty()))
    {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      this.jdField_a_of_type_JavaUtilList.add(new RangeButtonView.Title(HardCodeUtil.a(2131704801), a(15.0F)));
      this.jdField_a_of_type_JavaUtilList.add(new RangeButtonView.Title(HardCodeUtil.a(2131704798), a(16.0F)));
      this.jdField_a_of_type_JavaUtilList.add(new RangeButtonView.Title("", a(17.0F)));
      this.jdField_a_of_type_JavaUtilList.add(new RangeButtonView.Title("", a(18.0F)));
      this.jdField_a_of_type_JavaUtilList.add(new RangeButtonView.Title(HardCodeUtil.a(2131702606), a(20.0F)));
    }
    ((RangeButtonView)localObject1).setTitleData(this.jdField_a_of_type_JavaUtilList);
    FontSizePanel.a(localFontSizePanel, this.jdField_a_of_type_JavaUtilList);
    localObject2 = this.jdField_a_of_type_ComTencentWidgetRangeButtonView$OnChangeListener;
    if (localObject2 != null) {
      ((RangeButtonView)localObject1).setOnChangerListener((RangeButtonView.OnChangeListener)localObject2);
    }
    ((RangeButtonView)localObject1).setThumbPosition(this.jdField_a_of_type_Int);
    localObject2 = this.b;
    if ((localObject2 == null) || (((List)localObject2).isEmpty()))
    {
      this.b = new ArrayList();
      this.b.add(BaseApplicationImpl.getApplication().getString(2131691120));
      this.b.add(BaseApplicationImpl.getApplication().getString(2131691121));
      this.b.add(BaseApplicationImpl.getApplication().getString(2131691122));
      this.b.add(BaseApplicationImpl.getApplication().getString(2131691123));
      this.b.add(BaseApplicationImpl.getApplication().getString(2131691124));
    }
    ((RangeButtonView)localObject1).setContentDescList(this.b);
    FontSizePanel.a(localFontSizePanel, this.jdField_a_of_type_Boolean);
    return localFontSizePanel;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.FontSizePanel.Builder
 * JD-Core Version:    0.7.0.1
 */