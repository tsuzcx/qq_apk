package com.tencent.mobileqq.filemanager.data.search;

import android.content.res.Resources;
import android.os.Bundle;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseFragment;
import com.tencent.mobileqq.filemanager.data.search.searchtype.IQFileSearchTypeController;
import com.tencent.mobileqq.filemanager.widget.SearchFileFlowLayout;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.util.Iterator;
import java.util.List;

public class SearchTypeFragment
  extends BaseFragment
  implements View.OnClickListener
{
  public List<Integer> a;
  public int b;
  public String c;
  private SearchFileFlowLayout d;
  private SparseIntArray e = new SparseIntArray();
  private SparseIntArray f = new SparseIntArray();
  private View g;
  private IQFileSearchTypeController h;
  
  public View a(int paramInt1, int paramInt2, int paramInt3)
  {
    FrameLayout localFrameLayout = (FrameLayout)LayoutInflater.from(getActivity()).inflate(2131627067, (ViewGroup)this.g, false);
    LinearLayout localLinearLayout = (LinearLayout)localFrameLayout.findViewById(2131437550);
    TextView localTextView = (TextView)localFrameLayout.findViewById(2131448727);
    ((ImageView)localFrameLayout.findViewById(2131436559)).setImageDrawable(getResources().getDrawable(this.e.get(paramInt1)));
    localTextView.setText(this.f.get(paramInt1));
    localLinearLayout.setTag(Integer.valueOf(paramInt1));
    localLinearLayout.setOnClickListener(this);
    ((FrameLayout.LayoutParams)localFrameLayout.getLayoutParams()).width = (paramInt2 / paramInt3);
    return localFrameLayout;
  }
  
  public void a(IQFileSearchTypeController paramIQFileSearchTypeController)
  {
    this.h = paramIQFileSearchTypeController;
  }
  
  public void a(List<Integer> paramList, int paramInt)
  {
    Object localObject = this.d;
    if ((localObject != null) && (paramList != null))
    {
      ((SearchFileFlowLayout)localObject).setMaxNumInLineAndAlignMode(0, paramInt);
      int i = this.d.getMeasuredWidth();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject = (FrameLayout)a(((Integer)paramList.next()).intValue(), i, paramInt);
        this.d.addView((View)localObject);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    Integer localInteger = (Integer)paramView.getTag();
    IQFileSearchTypeController localIQFileSearchTypeController = this.h;
    if (localIQFileSearchTypeController != null) {
      localIQFileSearchTypeController.a(localInteger.intValue());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.e.put(13, 2130844935);
    this.e.put(3, 2130845745);
    this.e.put(2, 2130845749);
    this.e.put(0, 2130845748);
    this.e.put(1, 2130845746);
    this.e.put(11, 2130845747);
    this.f.put(13, 2131895139);
    this.f.put(3, 2131895137);
    this.f.put(2, 2131895142);
    this.f.put(0, 2131895138);
    this.f.put(1, 2131895140);
    this.f.put(11, 2131895141);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.g = paramLayoutInflater.inflate(2131627065, paramViewGroup, false);
    this.d = ((SearchFileFlowLayout)this.g.findViewById(2131433292));
    this.d.post(new SearchTypeFragment.1(this));
    paramLayoutInflater = this.g;
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.SearchTypeFragment
 * JD-Core Version:    0.7.0.1
 */