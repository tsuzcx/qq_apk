package com.tencent.mobileqq.selectmember;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.contacts.friend.SimpleTextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.selectmember.util.CommonUtils;
import com.tencent.mobileqq.troop.adapter.contact.GroupTag;
import com.tencent.mobileqq.troop.api.IDiscussionService;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.ExpandableListView;
import com.tencent.widget.ExpandableListView.OnGroupClickListener;
import com.tencent.widget.SingleLineTextView;
import java.util.HashSet;
import java.util.List;

public class TroopDiscussionMemSelectAdapter
  extends TroopListBaseAdapter
  implements ExpandableListView.OnGroupClickListener
{
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private View.OnClickListener b;
  private View.OnClickListener c;
  
  public TroopDiscussionMemSelectAdapter(Context paramContext, AppInterface paramAppInterface, ExpandableListView paramExpandableListView, View.OnClickListener paramOnClickListener)
  {
    super(paramContext, paramAppInterface, paramExpandableListView);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new TroopDiscussionMemSelectAdapter.1(this);
    this.jdField_c_of_type_AndroidViewView$OnClickListener = new TroopDiscussionMemSelectAdapter.2(this);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
  }
  
  private void a(GroupTag paramGroupTag)
  {
    int i;
    if (this.jdField_a_of_type_JavaUtilList.size() == 1) {
      i = 0;
    } else {
      i = paramGroupTag.jdField_a_of_type_Int;
    }
    if (this.jdField_a_of_type_ComTencentWidgetExpandableListView.isGroupExpanded(i))
    {
      this.jdField_a_of_type_ComTencentWidgetExpandableListView.collapseGroup(i);
      this.jdField_a_of_type_JavaUtilHashSet.remove(this.jdField_a_of_type_JavaUtilList.get(i));
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetExpandableListView.expandGroup(i);
    this.jdField_a_of_type_JavaUtilHashSet.add(this.jdField_a_of_type_JavaUtilList.get(i));
  }
  
  private void a(GroupTag paramGroupTag, int paramInt, boolean paramBoolean)
  {
    if (paramGroupTag != null)
    {
      if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size()))
      {
        i = ((Integer)this.jdField_a_of_type_JavaUtilList.get(paramInt)).intValue();
        if (i != 0)
        {
          if (i != 2)
          {
            if (i != 4)
            {
              if (i != 6)
              {
                if (i != 8)
                {
                  if (i == 13)
                  {
                    str = HardCodeUtil.a(2131715074);
                    i = this.g.size();
                    break label213;
                  }
                }
                else
                {
                  str = HardCodeUtil.a(2131715072);
                  i = this.f.size();
                  break label213;
                }
              }
              else
              {
                str = HardCodeUtil.a(2131715070);
                i = this.d.size();
                break label213;
              }
            }
            else
            {
              str = HardCodeUtil.a(2131715073);
              i = this.jdField_c_of_type_JavaUtilList.size();
              break label213;
            }
          }
          else
          {
            str = HardCodeUtil.a(2131715071);
            i = this.e.size();
            break label213;
          }
        }
        else
        {
          str = HardCodeUtil.a(2131715069);
          i = this.jdField_b_of_type_JavaUtilList.size();
          break label213;
        }
      }
      String str = "";
      int i = 0;
      label213:
      Object localObject = paramGroupTag.jdField_a_of_type_JavaLangStringBuilder;
      if (AppSetting.d)
      {
        if (localObject == null) {
          localObject = new StringBuilder(24);
        } else {
          ((StringBuilder)localObject).delete(0, ((StringBuilder)localObject).length());
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append(" 分组");
        ((StringBuilder)localObject).append(localStringBuilder.toString());
      }
      paramGroupTag.jdField_a_of_type_Int = paramInt;
      paramGroupTag.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(str);
      paramGroupTag.b.setVisibility(8);
      paramGroupTag.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      paramGroupTag.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView.setText(String.valueOf(i));
      paramGroupTag.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
      paramGroupTag.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(paramBoolean);
      ViewCompat.setImportantForAccessibility(paramGroupTag.jdField_a_of_type_AndroidWidgetCheckBox, 2);
      ViewCompat.setImportantForAccessibility(paramGroupTag.jdField_a_of_type_ComTencentWidgetSingleLineTextView, 1);
      if (paramBoolean) {
        localObject = "已展开 ";
      } else {
        localObject = "已收起 ";
      }
      paramGroupTag = paramGroupTag.jdField_a_of_type_ComTencentWidgetSingleLineTextView;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(str);
      localStringBuilder.append(String.valueOf(i));
      paramGroupTag.setContentDescription(localStringBuilder.toString());
    }
  }
  
  public void configHeaderView(View paramView, int paramInt)
  {
    if (paramView == null) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilList.size() == 1) {
      return;
    }
    Object localObject;
    if (!(paramView.getTag() instanceof GroupTag))
    {
      localObject = new GroupTag();
      ((GroupTag)localObject).jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131369353));
      ((GroupTag)localObject).jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131367855));
      ((GroupTag)localObject).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setDefaultTextColor(-8355712);
      ((GroupTag)localObject).b = ((SingleLineTextView)paramView.findViewById(2131379843));
      ((GroupTag)localObject).jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView = ((SimpleTextView)paramView.findViewById(2131365107));
      ((GroupTag)localObject).jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView.setDefaultTextColor(1711276032);
      ((GroupTag)localObject).jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131369450));
      paramView.setTag(localObject);
      paramView = (View)localObject;
    }
    else
    {
      paramView = (GroupTag)paramView.getTag();
    }
    if (ThemeUtil.isNowThemeIsDefaultCache(this.jdField_a_of_type_ComTencentCommonAppAppInterface, false))
    {
      paramView.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView.setTextColor(-5196865);
    }
    else
    {
      localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131167142);
      paramView.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView.setTextColor((ColorStateList)localObject);
    }
    a(paramView, paramInt, this.jdField_a_of_type_ComTencentWidgetExpandableListView.isGroupExpanded(paramInt));
  }
  
  public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    if ((paramView != null) && (paramView.getTag() != null))
    {
      paramViewGroup = (TroopDiscussionMemSelectAdapter.TroopViewHolder)paramView.getTag();
    }
    else
    {
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131562827, this.jdField_a_of_type_ComTencentWidgetExpandableListView, false);
      paramViewGroup = new TroopDiscussionMemSelectAdapter.TroopViewHolder(this);
      paramViewGroup.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131366401));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131366423));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379316));
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379302));
      paramViewGroup.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131362975));
      paramView.setTag(paramViewGroup);
    }
    TroopListBaseAdapter.ItemInfo localItemInfo = a(paramInt1, paramInt2);
    if ((localItemInfo != null) && (localItemInfo.jdField_a_of_type_ComTencentMobileqqPersistenceEntity != null))
    {
      Object localObject;
      if ((localItemInfo.jdField_a_of_type_ComTencentMobileqqPersistenceEntity instanceof TroopInfo))
      {
        TroopInfo localTroopInfo = (TroopInfo)localItemInfo.jdField_a_of_type_ComTencentMobileqqPersistenceEntity;
        paramViewGroup.jdField_a_of_type_JavaLangString = localTroopInfo.troopuin;
        paramViewGroup.jdField_c_of_type_Int = 4;
        if (!TextUtils.isEmpty(localTroopInfo.getTroopDisplayName())) {
          localObject = localTroopInfo.getTroopDisplayName();
        } else {
          localObject = localTroopInfo.troopuin;
        }
        paramViewGroup.jdField_a_of_type_JavaLangString = localTroopInfo.troopuin;
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo = localTroopInfo;
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo = null;
        paramViewGroup.jdField_a_of_type_Int = localItemInfo.jdField_a_of_type_Int;
        if ((!localTroopInfo.hasSetTroopName()) && (localTroopInfo.wMemberNumClient > 0))
        {
          paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
          paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(String.format("(%d)", new Object[] { Integer.valueOf(localTroopInfo.wMemberNumClient) }));
        }
        else
        {
          paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        }
        a(paramViewGroup, null);
        paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        return paramView;
      }
      if ((localItemInfo.jdField_a_of_type_ComTencentMobileqqPersistenceEntity instanceof DiscussionInfo))
      {
        localObject = (DiscussionInfo)localItemInfo.jdField_a_of_type_ComTencentMobileqqPersistenceEntity;
        paramViewGroup.jdField_a_of_type_JavaLangString = ((DiscussionInfo)localObject).uin;
        paramViewGroup.jdField_c_of_type_Int = 101;
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(CommonUtils.a(this.jdField_a_of_type_AndroidContentContext, (DiscussionInfo)localObject));
        if (!((DiscussionInfo)localObject).hasRenamed())
        {
          paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
          paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(String.format("(%d)", new Object[] { Integer.valueOf(((IDiscussionService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IDiscussionService.class, "")).getDiscussionMemberNum(((DiscussionInfo)localObject).uin)) }));
        }
        paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        a(paramViewGroup, null);
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo = ((DiscussionInfo)localObject);
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo = null;
        paramViewGroup.jdField_a_of_type_Int = localItemInfo.jdField_a_of_type_Int;
        return paramView;
      }
      if (QLog.isColorLevel())
      {
        paramViewGroup = new StringBuilder();
        paramViewGroup.append("getChildView data:");
        paramViewGroup.append(localItemInfo.jdField_a_of_type_ComTencentMobileqqPersistenceEntity);
        paramViewGroup.append(" groupPosition:");
        paramViewGroup.append(paramInt1);
        paramViewGroup.append(" childPosition:");
        paramViewGroup.append(paramInt2);
        QLog.d("TroopDiscussionMemSelectAdapter", 2, paramViewGroup.toString());
        return paramView;
      }
    }
    else if (QLog.isColorLevel())
    {
      paramViewGroup = new StringBuilder();
      paramViewGroup.append("getChildView itemInfo data null");
      paramViewGroup.append(paramInt1);
      paramViewGroup.append(" childPosition:");
      paramViewGroup.append(paramInt2);
      QLog.d("TroopDiscussionMemSelectAdapter", 2, paramViewGroup.toString());
    }
    return paramView;
  }
  
  public View getGroupView(int paramInt, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558918, paramViewGroup, false);
      paramViewGroup = new GroupTag();
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131367855));
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setDefaultTextColor(-8355712);
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131369353));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView = ((SimpleTextView)paramView.findViewById(2131365107));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView.setDefaultTextColor(1711276032);
      paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131369450));
      paramViewGroup.b = ((SingleLineTextView)paramView.findViewById(2131379843));
      paramView.setTag(paramViewGroup);
    }
    else
    {
      paramViewGroup = (GroupTag)paramView.getTag();
    }
    if (this.jdField_a_of_type_JavaUtilList.size() == 1)
    {
      paramView.setLayoutParams(new AbsListView.LayoutParams(-1, 1));
      return paramView;
    }
    paramView.setLayoutParams(new AbsListView.LayoutParams(-1, this.jdField_a_of_type_Int));
    if (ThemeUtil.isNowThemeIsDefaultCache(this.jdField_a_of_type_ComTencentCommonAppAppInterface, false))
    {
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView.setTextColor(-5196865);
    }
    else
    {
      ColorStateList localColorStateList = this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131167142);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView.setTextColor(localColorStateList);
    }
    a(paramViewGroup, paramInt, paramBoolean);
    paramView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
    return paramView;
  }
  
  public int getHeaderViewLayoutResourceId()
  {
    return 2131558918;
  }
  
  public boolean needHideBackgroundGroup()
  {
    return true;
  }
  
  public boolean onGroupClick(ExpandableListView paramExpandableListView, View paramView, int paramInt, long paramLong)
  {
    paramExpandableListView = paramView.getTag();
    if ((paramExpandableListView instanceof GroupTag)) {
      a((GroupTag)paramExpandableListView);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.TroopDiscussionMemSelectAdapter
 * JD-Core Version:    0.7.0.1
 */