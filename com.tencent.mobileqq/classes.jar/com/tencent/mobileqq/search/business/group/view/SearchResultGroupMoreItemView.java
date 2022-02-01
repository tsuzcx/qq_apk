package com.tencent.mobileqq.search.business.group.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.IPublicAcountFetcher;
import com.tencent.mobileqq.search.base.view.ISearchResultGroupView;
import com.tencent.mobileqq.search.base.view.ISearchResultView;
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
    paramViewGroup = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368461);
    if ((paramViewGroup != null) && (paramInt2 > 0)) {
      paramViewGroup.setImageResource(paramInt2);
    }
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369676));
    this.b = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131365536));
    if (paramInt3 == 12)
    {
      paramViewGroup = this.b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131713579));
      localStringBuilder.append(((IPublicAcountFetcher)QRoute.api(IPublicAcountFetcher.class)).getSubscriptName());
      localStringBuilder.append(HardCodeUtil.a(2131713578));
      paramViewGroup.setText(localStringBuilder.toString());
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
  
  public List<ISearchResultView> a()
  {
    return null;
  }
  
  public TextView b()
  {
    return this.jdField_a_of_type_AndroidWidgetTextView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.group.view.SearchResultGroupMoreItemView
 * JD-Core Version:    0.7.0.1
 */