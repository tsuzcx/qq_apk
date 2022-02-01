package com.tencent.mobileqq.qqgamepub.hippy.view;

import android.app.Activity;
import android.content.Context;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.qqgamepub.data.QQGameMsgInfo;
import com.tencent.mobileqq.qqgamepub.hippy.fragment.GamePubAccountHippyFragment;
import com.tencent.mobileqq.qqgamepub.utils.GamePubAccountHelper;
import com.tencent.mobileqq.qqgamepub.utils.QQGameUIHelper;
import com.tencent.mobileqq.qqgamepub.view.IHeaderView;
import com.tencent.mobileqq.qqgamepub.view.MoreMsgHeaderView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class GamePubAccountHeadAdapter
  extends PagerAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private GamePubAccountHippyFragment jdField_a_of_type_ComTencentMobileqqQqgamepubHippyFragmentGamePubAccountHippyFragment;
  private List<IHeaderView> jdField_a_of_type_JavaUtilList;
  private List<QQGameMsgInfo> b;
  
  public GamePubAccountHeadAdapter(List<IHeaderView> paramList, List<QQGameMsgInfo> paramList1, Context paramContext, GamePubAccountHippyFragment paramGamePubAccountHippyFragment)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqQqgamepubHippyFragmentGamePubAccountHippyFragment = paramGamePubAccountHippyFragment;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    this.b = new ArrayList();
    this.b.addAll(paramList1);
  }
  
  public View a()
  {
    View localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559147, null, false);
    ((ImageView)localView.findViewById(2131366220)).setImageDrawable(URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/gameCenter/gameCenter_no_message@2x.png"));
    return localView;
  }
  
  public void a(List<IHeaderView> paramList, List<QQGameMsgInfo> paramList1)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    this.b.clear();
    this.b.addAll(paramList1);
    notifyDataSetChanged();
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)paramObject);
  }
  
  public int getCount()
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if ((localList != null) && (localList.size() > 1)) {
      return this.jdField_a_of_type_JavaUtilList.size();
    }
    return 1;
  }
  
  public int getItemPosition(Object paramObject)
  {
    return -2;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    Object localObject1 = this.b;
    if ((localObject1 != null) && (((List)localObject1).size() != 0))
    {
      int i = this.b.size();
      TextView localTextView = null;
      if (paramInt < i) {
        localObject1 = (QQGameMsgInfo)this.b.get(paramInt);
      } else {
        localObject1 = null;
      }
      IHeaderView localIHeaderView;
      if (paramInt < this.jdField_a_of_type_JavaUtilList.size()) {
        localIHeaderView = (IHeaderView)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      } else {
        localIHeaderView = null;
      }
      if (localIHeaderView == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQGamePub_GamePubAccountHeadAdapt", 2, "headerView = null");
        }
        return null;
      }
      if (((localIHeaderView instanceof MoreMsgHeaderView)) && (paramInt != this.b.size())) {
        return null;
      }
      Object localObject2;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("headerView = ");
        ((StringBuilder)localObject2).append(localIHeaderView.getClass().getSimpleName());
        QLog.d("QQGamePub_GamePubAccountHeadAdapt", 2, ((StringBuilder)localObject2).toString());
      }
      RelativeLayout localRelativeLayout = new RelativeLayout(paramViewGroup.getContext());
      View localView = (View)localIHeaderView;
      if (localView.getParent() != null) {
        ((ViewGroup)localView.getParent()).removeView(localView);
      }
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams.addRule(13, localView.getId());
      if (localObject1 != null)
      {
        localObject2 = QQGameUIHelper.a((QQGameMsgInfo)localObject1, this.jdField_a_of_type_AndroidContentContext);
        localTextView = (TextView)((Pair)localObject2).first;
        localObject2 = (RelativeLayout.LayoutParams)((Pair)localObject2).second;
      }
      else
      {
        localObject2 = null;
      }
      localRelativeLayout.addView(localView, localLayoutParams);
      if ((localTextView != null) && (localObject2 != null)) {
        localRelativeLayout.addView(localTextView, (ViewGroup.LayoutParams)localObject2);
      }
      paramViewGroup.addView(localRelativeLayout, localLayoutParams);
      if (localObject1 != null)
      {
        localIHeaderView.a((QQGameMsgInfo)localObject1, (Activity)this.jdField_a_of_type_AndroidContentContext, paramInt, GamePubAccountHelper.a());
        this.jdField_a_of_type_ComTencentMobileqqQqgamepubHippyFragmentGamePubAccountHippyFragment.a(paramInt, localIHeaderView);
        return localRelativeLayout;
      }
      localIHeaderView.a(new QQGameMsgInfo(), (Activity)this.jdField_a_of_type_AndroidContentContext, paramInt, GamePubAccountHelper.a());
      return localRelativeLayout;
    }
    localObject1 = a();
    paramViewGroup.addView((View)localObject1);
    return localObject1;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.hippy.view.GamePubAccountHeadAdapter
 * JD-Core Version:    0.7.0.1
 */