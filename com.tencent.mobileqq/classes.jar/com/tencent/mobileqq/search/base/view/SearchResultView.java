package com.tencent.mobileqq.search.base.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.widget.ThemeImageView;
import com.tencent.widget.ThemeURLImageView;

public class SearchResultView
  implements ISearchResultView
{
  public int a;
  protected ImageView a;
  protected View b;
  protected ImageView b;
  protected View c;
  protected TextView d;
  protected TextView e;
  protected TextView f;
  protected TextView g;
  
  protected SearchResultView() {}
  
  public SearchResultView(View paramView)
  {
    this.jdField_b_of_type_AndroidViewView = paramView;
    a();
  }
  
  public SearchResultView(ViewGroup paramViewGroup, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    LayoutInflater localLayoutInflater = LayoutInflater.from(paramViewGroup.getContext());
    if (a(paramInt)) {
      this.jdField_b_of_type_AndroidViewView = localLayoutInflater.inflate(paramInt, null, false);
    } else {
      this.jdField_b_of_type_AndroidViewView = localLayoutInflater.inflate(paramInt, paramViewGroup, false);
    }
    a();
  }
  
  public View a()
  {
    return this.jdField_b_of_type_AndroidViewView;
  }
  
  public View a(int paramInt)
  {
    if ((paramInt != 2131559800) && (paramInt != 2131559793) && (paramInt != 2131559832) && (paramInt != 2131559817)) {
      return this.jdField_b_of_type_AndroidViewView;
    }
    return this.jdField_b_of_type_AndroidViewView.findViewById(2131377081);
  }
  
  public View a(String paramString)
  {
    return null;
  }
  
  public ImageView a()
  {
    return this.jdField_b_of_type_AndroidWidgetImageView;
  }
  
  public TextView a()
  {
    return this.d;
  }
  
  protected void a()
  {
    Object localObject = this.jdField_b_of_type_AndroidViewView.findViewById(2131378784);
    if (localObject != null)
    {
      this.d = ((TextView)localObject);
      this.d.setEditableFactory(QQTextBuilder.EMOCTATION_FACORY);
    }
    localObject = this.jdField_b_of_type_AndroidViewView.findViewById(2131378039);
    if (localObject != null) {
      this.e = ((TextView)localObject);
    }
    localObject = this.jdField_b_of_type_AndroidViewView.findViewById(2131365536);
    if (localObject != null) {
      this.f = ((TextView)localObject);
    }
    localObject = this.jdField_b_of_type_AndroidViewView.findViewById(2131366816);
    if (localObject != null) {
      this.g = ((TextView)localObject);
    }
    localObject = this.jdField_b_of_type_AndroidViewView.findViewById(2131368461);
    if (localObject != null) {
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localObject);
    }
    localObject = this.jdField_a_of_type_AndroidWidgetImageView;
    if ((localObject instanceof ThemeImageView)) {
      ((ThemeImageView)localObject).setSupportMaskView(false);
    } else if ((localObject instanceof ThemeURLImageView)) {
      ((ThemeURLImageView)localObject).setSupportMaskView(false);
    }
    localObject = this.jdField_b_of_type_AndroidViewView.findViewById(2131376548);
    if (localObject != null) {
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localObject);
    }
    this.c = this.jdField_b_of_type_AndroidViewView.findViewById(2131365776);
    b();
  }
  
  public boolean a(int paramInt)
  {
    return (paramInt != 2131562791) && (paramInt != 2131561031) && (paramInt != 2131562790);
  }
  
  public ImageView b()
  {
    return this.jdField_a_of_type_AndroidWidgetImageView;
  }
  
  public TextView b()
  {
    return this.e;
  }
  
  public void b()
  {
    a(this.jdField_a_of_type_Int);
  }
  
  public TextView c()
  {
    return this.f;
  }
  
  public TextView d()
  {
    return this.g;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.base.view.SearchResultView
 * JD-Core Version:    0.7.0.1
 */