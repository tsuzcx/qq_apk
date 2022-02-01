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
  private View a;
  private TextView b;
  private TextView c;
  
  public SearchResultGroupMoreItemView(ViewGroup paramViewGroup, int paramInt1, int paramInt2, int paramInt3)
  {
    this.a = LayoutInflater.from(paramViewGroup.getContext()).inflate(paramInt1, paramViewGroup, false);
    paramViewGroup = (ImageView)this.a.findViewById(2131435357);
    if ((paramViewGroup != null) && (paramInt2 > 0)) {
      paramViewGroup.setImageResource(paramInt2);
    }
    this.b = ((TextView)this.a.findViewById(2131436787));
    this.c = ((TextView)this.a.findViewById(2131431757));
    if (paramInt3 == 12)
    {
      paramViewGroup = this.c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131911124));
      localStringBuilder.append(((IPublicAcountFetcher)QRoute.api(IPublicAcountFetcher.class)).getSubscriptName());
      localStringBuilder.append(HardCodeUtil.a(2131911123));
      paramViewGroup.setText(localStringBuilder.toString());
    }
  }
  
  public TextView a()
  {
    return null;
  }
  
  public TextView b()
  {
    return this.b;
  }
  
  public List<ISearchResultView> c()
  {
    return null;
  }
  
  public View h()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.group.view.SearchResultGroupMoreItemView
 * JD-Core Version:    0.7.0.1
 */