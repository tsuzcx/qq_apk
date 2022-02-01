package com.tencent.mobileqq.richstatus;

import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.richstatus.comment.widget.CommentsView;
import com.tencent.mobileqq.richstatus.comment.widget.LikesView;
import com.tencent.mobileqq.richstatus.sign.BoxShadowLayout;
import com.tencent.mobileqq.richstatus.sign.HistorySignViewHolder;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class SignatureHistoryFragment$DataAdapter
  extends BaseAdapter
{
  private SignatureHistoryFragment$DataAdapter(SignatureHistoryFragment paramSignatureHistoryFragment) {}
  
  public int getCount()
  {
    int i = SignatureHistoryFragment.b(this.a).size();
    if (i == 0) {
      return 1;
    }
    return i + 1;
  }
  
  public Object getItem(int paramInt)
  {
    if (paramInt >= SignatureHistoryFragment.b(this.a).size()) {
      return null;
    }
    return SignatureHistoryFragment.b(this.a).get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return getItemViewType(paramInt);
  }
  
  public int getItemViewType(int paramInt)
  {
    int i = SignatureHistoryFragment.b(this.a).size();
    if (i == 0) {
      return 2;
    }
    if (paramInt < i) {
      return 0;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = getItemViewType(paramInt);
    if (i == 2)
    {
      SignatureHistoryFragment.a(this.a).setLayoutParams(new AbsListView.LayoutParams(this.a.jdField_a_of_type_ComTencentWidgetXListView.getWidth(), this.a.jdField_a_of_type_ComTencentWidgetXListView.getHeight()));
      paramView = SignatureHistoryFragment.a(this.a);
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      if (i == 0)
      {
        localObject2 = (HistorySignItem)SignatureHistoryFragment.b(this.a).get(paramInt);
        if (paramView == null)
        {
          localObject1 = new BoxShadowLayout(this.a.getActivity());
          paramView = this.a.a((View)localObject1);
          localObject1 = new HistorySignViewHolder(this.a.getActivity(), this.a.getActivity().app, (View)localObject1, SignatureHistoryFragment.a(this.a));
          SignatureHistoryFragment.a(this.a).add(localObject1);
          ((HistorySignViewHolder)localObject1).a(this.a);
          ((HistorySignViewHolder)localObject1).a(this.a);
          Object localObject3 = (LinearLayout)((HistorySignViewHolder)localObject1).b();
          ((HistorySignViewHolder)localObject1).c().setOnTouchListener(this.a.jdField_a_of_type_AndroidViewView$OnTouchListener);
          ((HistorySignViewHolder)localObject1).c().setOnClickListener(this.a);
          LayoutInflater.from(this.a.getActivity()).inflate(2131561638, (ViewGroup)localObject3);
          paramView.setTag(localObject1);
          label252:
          ((HistorySignViewHolder)localObject1).jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131364488));
          ((HistorySignViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqRichstatusCommentWidgetCommentsView = ((CommentsView)paramView.findViewById(2131364868));
          ((HistorySignViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqRichstatusCommentWidgetCommentsView.setOnSpanItemClick(new SignatureHistoryFragment.DataAdapter.1(this));
          ((HistorySignViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqRichstatusCommentWidgetCommentsView.setOnItemClickListener(new SignatureHistoryFragment.DataAdapter.2(this, (HistorySignItem)localObject2));
          ((HistorySignViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqRichstatusCommentWidgetCommentsView.setOnItemLongClickListener(new SignatureHistoryFragment.DataAdapter.3(this, (HistorySignItem)localObject2));
          ((HistorySignViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqRichstatusCommentWidgetLikesView = ((LikesView)paramView.findViewById(2131370705));
          ((HistorySignViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqRichstatusCommentWidgetLikesView.setOnItemClickListener(new SignatureHistoryFragment.DataAdapter.4(this));
          paramView.setTag(localObject1);
          paramView.setClickable(true);
          if ((localObject2 == null) || (((HistorySignItem)localObject2).richStatus == null) || (((HistorySignItem)localObject2).richStatus.feedsId == null)) {
            break label675;
          }
          ((HistorySignViewHolder)localObject1).jdField_a_of_type_AndroidWidgetCheckBox.setTag(((HistorySignItem)localObject2).richStatus.feedsId);
          label413:
          if (!SignatureHistoryFragment.b(this.a)) {
            break label689;
          }
          ((HistorySignViewHolder)localObject1).jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
          ((HistorySignViewHolder)localObject1).jdField_a_of_type_AndroidWidgetCheckBox.setOnClickListener(this.a.jdField_a_of_type_AndroidViewView$OnClickListener);
          label447:
          if ((localObject2 == null) || (((HistorySignItem)localObject2).richStatus == null) || (((HistorySignItem)localObject2).richStatus.feedsId == null)) {
            break label714;
          }
          if (!SignatureHistoryFragment.a(this.a).contains(((HistorySignItem)localObject2).richStatus.feedsId)) {
            break label702;
          }
          ((HistorySignViewHolder)localObject1).jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
          label501:
          ((HistorySignViewHolder)localObject1).jdField_a_of_type_Int = paramInt;
          ((HistorySignViewHolder)localObject1).c = SignatureHistoryFragment.a(this.a);
          localObject3 = ((HistorySignItem)localObject2).richStatus;
          ((HistorySignViewHolder)localObject1).b = ((RichStatus)localObject3);
          ((HistorySignViewHolder)localObject1).a((RichStatus)localObject3);
          if (((((HistorySignItem)localObject2).likeItemList == null) || (((HistorySignItem)localObject2).likeItemList.size() <= 0)) && ((((HistorySignItem)localObject2).commentItemList == null) || (((HistorySignItem)localObject2).commentItemList.size() <= 0))) {
            break label726;
          }
          if (((HistorySignViewHolder)localObject1).b() != null)
          {
            ((HistorySignViewHolder)localObject1).b().setVisibility(0);
            ((HistorySignViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqRichstatusCommentWidgetLikesView.a(((HistorySignItem)localObject2).likeItemList, ((HistorySignItem)localObject2).totalLikeNum);
            ((HistorySignViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqRichstatusCommentWidgetCommentsView.a(((HistorySignItem)localObject2).commentItemList);
          }
        }
        for (;;)
        {
          ((HistorySignViewHolder)localObject1).f = SignatureHistoryFragment.a(this.a, ((HistorySignItem)localObject2).likeItemList, SignatureHistoryFragment.b(this.a));
          ((HistorySignViewHolder)localObject1).j();
          break;
          localObject1 = (HistorySignViewHolder)paramView.getTag();
          break label252;
          label675:
          ((HistorySignViewHolder)localObject1).jdField_a_of_type_AndroidWidgetCheckBox.setTag("");
          break label413;
          label689:
          ((HistorySignViewHolder)localObject1).jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
          break label447;
          label702:
          ((HistorySignViewHolder)localObject1).jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
          break label501;
          label714:
          ((HistorySignViewHolder)localObject1).jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
          break label501;
          label726:
          if (((HistorySignViewHolder)localObject1).b() != null) {
            ((HistorySignViewHolder)localObject1).b().setVisibility(8);
          }
        }
      }
      Object localObject1 = paramView;
      if (paramView == null)
      {
        localObject1 = this.a.getActivity().getLayoutInflater().inflate(2131559592, null);
        ((View)localObject1).setBackgroundColor(this.a.getResources().getColor(2131167305));
        paramView = new SignatureHistoryFragment.MoreViewHolder();
        ((View)localObject1).setTag(paramView);
        paramView.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)((View)localObject1).findViewById(2131376854));
        ((View)localObject1).findViewById(2131370717).setVisibility(8);
        paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131371896));
        paramView.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.a.getResources().getColor(2131165357));
      }
      if (SignatureHistoryFragment.a(this.a) == 1)
      {
        SignatureHistoryFragment.a(this.a, 2);
        this.a.a(false, false);
      }
      paramView = (SignatureHistoryFragment.MoreViewHolder)((View)localObject1).getTag();
      Object localObject2 = new AbsListView.LayoutParams(-1, -2);
      if (SignatureHistoryFragment.a(this.a) == 3)
      {
        paramView.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        paramView.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131714070));
        ((AbsListView.LayoutParams)localObject2).height = AIOUtils.a(60.0F, this.a.getResources());
        ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        paramView = (View)localObject1;
      }
      else if (SignatureHistoryFragment.a(this.a) == 2)
      {
        paramView.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        paramView.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131714056));
        ((AbsListView.LayoutParams)localObject2).height = AIOUtils.a(60.0F, this.a.getResources());
        ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        paramView = (View)localObject1;
      }
      else
      {
        if (SignatureHistoryFragment.a(this.a) == 0)
        {
          paramView.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
          paramView.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
          ((AbsListView.LayoutParams)localObject2).height = (ScreenUtil.SCREEN_HIGHT / 4);
          ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        }
        paramView = (View)localObject1;
      }
    }
  }
  
  public int getViewTypeCount()
  {
    return 3;
  }
  
  public boolean isEnabled(int paramInt)
  {
    return 2 != getItemViewType(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.SignatureHistoryFragment.DataAdapter
 * JD-Core Version:    0.7.0.1
 */