package com.tencent.open.agent.authority;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.open.agent.AuthorityControlAppDetailsFragment;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.open.model.AppInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AuthorityControlAdapter
  extends BaseAdapter
  implements View.OnClickListener
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private final IphoneTitleBarFragment jdField_a_of_type_ComTencentMobileqqFragmentIphoneTitleBarFragment;
  @NonNull
  private List<AppInfo> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private List<Integer> b;
  
  public AuthorityControlAdapter(IphoneTitleBarFragment paramIphoneTitleBarFragment, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqFragmentIphoneTitleBarFragment = paramIphoneTitleBarFragment;
    this.jdField_a_of_type_AndroidAppActivity = paramIphoneTitleBarFragment.getBaseActivity();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.b = new ArrayList();
  }
  
  private void a(int paramInt, View paramView, AuthorityControlAdapter.ViewHolder paramViewHolder)
  {
    paramViewHolder.jdField_a_of_type_Int = paramInt;
    paramViewHolder.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    AppInfo localAppInfo = (AppInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    String str = localAppInfo.b();
    paramView = str;
    if (str == null) {
      paramView = "";
    }
    paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramView.trim());
    paramViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(localAppInfo.a());
    paramViewHolder.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
    a(paramViewHolder, localAppInfo);
  }
  
  private void a(View paramView)
  {
    AuthorityControlAdapter.ViewHolder localViewHolder = (AuthorityControlAdapter.ViewHolder)paramView.getTag();
    if (this.jdField_a_of_type_Boolean)
    {
      paramView = (CheckBox)paramView.findViewById(2131371604);
      boolean bool = paramView.isChecked() ^ true;
      paramView.setChecked(bool);
      if (paramView.isChecked())
      {
        this.b.add(Integer.valueOf(localViewHolder.jdField_a_of_type_Int));
      }
      else
      {
        int i = localViewHolder.jdField_a_of_type_Int;
        this.b.remove(Integer.valueOf(i));
      }
      if (this.b.size() > 0) {
        this.jdField_a_of_type_ComTencentMobileqqFragmentIphoneTitleBarFragment.rightViewText.setEnabled(true);
      } else {
        this.jdField_a_of_type_ComTencentMobileqqFragmentIphoneTitleBarFragment.rightViewText.setEnabled(false);
      }
      paramView = (AppInfo)this.jdField_a_of_type_JavaUtilList.get(localViewHolder.jdField_a_of_type_Int);
      if (paramView != null) {
        paramView.a(bool);
      }
      if (QLog.isColorLevel())
      {
        paramView = new StringBuilder();
        paramView.append("onLayoutAppItemClick: invoked.  mCheckedPositions: ");
        paramView.append(this.b);
        QLog.i("AuthorityControlAdapter", 2, paramView.toString());
      }
    }
    else
    {
      paramView = (AppInfo)this.jdField_a_of_type_JavaUtilList.get(localViewHolder.jdField_a_of_type_Int);
      AuthorityControlAppDetailsFragment.a(this.jdField_a_of_type_AndroidAppActivity, paramView);
      AuthorityUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800B92F", new String[] { "", "", paramView.b(), "" });
    }
  }
  
  private void a(AuthorityControlAdapter.ViewHolder paramViewHolder)
  {
    paramViewHolder.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
    paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
  }
  
  private void a(AuthorityControlAdapter.ViewHolder paramViewHolder, View paramView)
  {
    paramViewHolder.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131369751);
    paramViewHolder.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131371604));
    paramViewHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368187));
    paramViewHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362852));
    paramViewHolder.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362862));
    paramViewHolder.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131362842));
    paramViewHolder.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131370702);
  }
  
  private void a(AuthorityControlAdapter.ViewHolder paramViewHolder, AppInfo paramAppInfo)
  {
    Object localObject1 = paramAppInfo.c();
    Object localObject2 = this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130838632);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    if (ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null)) {
      paramViewHolder.jdField_a_of_type_AndroidViewView.setVisibility(0);
    } else {
      paramViewHolder.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject2);
    localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject2);
    localObject2 = paramViewHolder.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
    localURLDrawableOptions.mRequestHeight = ((ViewGroup.LayoutParams)localObject2).height;
    localURLDrawableOptions.mRequestWidth = ((ViewGroup.LayoutParams)localObject2).width;
    try
    {
      localObject1 = URLDrawable.getDrawable((String)localObject1, localURLDrawableOptions);
      ((URLDrawable)localObject1).setTag(URLDrawableDecodeHandler.b(((ViewGroup.LayoutParams)localObject2).width, ((ViewGroup.LayoutParams)localObject2).height, UIUtils.a(this.jdField_a_of_type_AndroidAppActivity, 6.0F)));
      ((URLDrawable)localObject1).setDecodeHandler(URLDrawableDecodeHandler.i);
      paramViewHolder.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
      label148:
      paramViewHolder.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(paramAppInfo.a());
      return;
    }
    catch (Throwable localThrowable)
    {
      break label148;
    }
  }
  
  private void b(AuthorityControlAdapter.ViewHolder paramViewHolder)
  {
    paramViewHolder.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
    paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  @NonNull
  public List<AppInfo> a()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      int i = ((Integer)localIterator.next()).intValue();
      if ((i < this.jdField_a_of_type_JavaUtilList.size()) && (i >= 0)) {
        localArrayList.add((AppInfo)this.jdField_a_of_type_JavaUtilList.get(i));
      }
    }
    return localArrayList;
  }
  
  public void a()
  {
    this.b.clear();
    notifyDataSetChanged();
  }
  
  public void a(@NonNull List<AppInfo> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = true;
    this.b.clear();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((AppInfo)localIterator.next()).a(false);
    }
    notifyDataSetChanged();
  }
  
  public void b(List<AppInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator1 = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator1.hasNext())
    {
      AppInfo localAppInfo1 = (AppInfo)localIterator1.next();
      int j = 1;
      Iterator localIterator2 = paramList.iterator();
      AppInfo localAppInfo2;
      do
      {
        i = j;
        if (!localIterator2.hasNext()) {
          break;
        }
        localAppInfo2 = (AppInfo)localIterator2.next();
      } while (localAppInfo1.a() != localAppInfo2.a());
      int i = 0;
      if (i != 0) {
        localArrayList.add(localAppInfo1);
      }
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(localArrayList);
  }
  
  public void c()
  {
    this.jdField_a_of_type_Boolean = false;
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (paramView == null)
    {
      paramView = new AuthorityControlAdapter.ViewHolder(null);
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131558648, null);
      a(paramView, localView);
      localView.setTag(paramView);
    }
    else
    {
      AuthorityControlAdapter.ViewHolder localViewHolder = (AuthorityControlAdapter.ViewHolder)paramView.getTag();
      localView = paramView;
      paramView = localViewHolder;
    }
    a(paramInt, localView, paramView);
    if (this.jdField_a_of_type_Boolean) {
      b(paramView);
    } else {
      a(paramView);
    }
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131369751) {
      a(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.authority.AuthorityControlAdapter
 * JD-Core Version:    0.7.0.1
 */