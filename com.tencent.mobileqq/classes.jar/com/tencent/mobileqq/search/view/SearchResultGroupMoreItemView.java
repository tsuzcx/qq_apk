package com.tencent.mobileqq.search.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.util.PublicAccountConfigUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.List;

public class SearchResultGroupMoreItemView
  implements ISearchResultGroupView
{
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private TextView b;
  
  public SearchResultGroupMoreItemView(ViewGroup paramViewGroup, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(paramViewGroup.getContext()).inflate(paramInt1, paramViewGroup, false);
    paramViewGroup = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131361846);
    if ((paramViewGroup != null) && (paramInt2 > 0)) {
      paramViewGroup.setImageResource(paramInt2);
    }
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369923));
    this.b = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131365659));
    if (paramInt3 == 12) {
      this.b.setText("相关" + PublicAccountConfigUtil.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), BaseApplicationImpl.getContext()) + "、文章等");
    }
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public TextView a()
  {
    return null;
  }
  
  public List a()
  {
    return null;
  }
  
  public TextView b()
  {
    return this.jdField_a_of_type_AndroidWidgetTextView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.view.SearchResultGroupMoreItemView
 * JD-Core Version:    0.7.0.1
 */