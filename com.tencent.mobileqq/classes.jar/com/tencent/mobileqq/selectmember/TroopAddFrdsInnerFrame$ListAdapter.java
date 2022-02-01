package com.tencent.mobileqq.selectmember;

import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.adapter.CharDividedFacePreloadBaseAdapter;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.profilecard.api.IProfileCardApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.ISearchPieceFetcher;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.selectmember.util.CommonUtils;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

class TroopAddFrdsInnerFrame$ListAdapter
  extends CharDividedFacePreloadBaseAdapter
  implements View.OnClickListener
{
  public List<ResultRecord> a;
  boolean jdField_a_of_type_Boolean = false;
  
  public TroopAddFrdsInnerFrame$ListAdapter(TroopAddFrdsInnerFrame paramTroopAddFrdsInnerFrame)
  {
    super(paramTroopAddFrdsInnerFrame.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity, paramTroopAddFrdsInnerFrame.jdField_a_of_type_ComTencentCommonAppAppInterface, paramTroopAddFrdsInnerFrame.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView, true);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    paramTroopAddFrdsInnerFrame.b = paramTroopAddFrdsInnerFrame.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.getResources().getDimensionPixelOffset(2131298219);
    paramTroopAddFrdsInnerFrame.c = paramTroopAddFrdsInnerFrame.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.getResources().getDimensionPixelOffset(2131298220);
  }
  
  private boolean a(TroopMemberInfo paramTroopMemberInfo)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      ResultRecord localResultRecord = (ResultRecord)this.jdField_a_of_type_JavaUtilList.get(i);
      if (TextUtils.equals(paramTroopMemberInfo.memberuin, localResultRecord.uin)) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ArrayOfJavaLangString.length > 0) {
      return 2131559309;
    }
    return 0;
  }
  
  public int a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ArrayOfJavaLangString != null)
    {
      int i = 0;
      while (i < this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ArrayOfJavaLangString.length)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ArrayOfJavaLangString[i].equals(paramString)) {
          break label52;
        }
        i += 1;
      }
      i = -1;
      label52:
      if (i >= 0) {
        return this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ArrayOfInt[i];
      }
    }
    return -1;
  }
  
  public void a(View paramView, int paramInt)
  {
    Arrays.binarySearch(this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ArrayOfInt, paramInt);
  }
  
  public void a(ResultRecord paramResultRecord, boolean paramBoolean)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      ResultRecord localResultRecord = (ResultRecord)this.jdField_a_of_type_JavaUtilList.get(i);
      if (TextUtils.equals(paramResultRecord.uin, localResultRecord.uin)) {
        break label57;
      }
      i += 1;
    }
    i = -1;
    label57:
    if (paramBoolean)
    {
      if (i == -1)
      {
        this.jdField_a_of_type_JavaUtilList.add(paramResultRecord);
        notifyDataSetChanged();
      }
    }
    else if (i != -1)
    {
      this.jdField_a_of_type_JavaUtilList.remove(i);
      notifyDataSetChanged();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    notifyDataSetChanged();
  }
  
  public boolean a(int paramInt)
  {
    return Arrays.binarySearch(this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ArrayOfInt, paramInt) >= 0;
  }
  
  public int getCount()
  {
    int[] arrayOfInt = this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ArrayOfInt;
    int i = 0;
    if (arrayOfInt != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_JavaUtilMap == null) {
        return 0;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ArrayOfInt.length == 0) {
        return 0;
      }
      i = this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ArrayOfInt[(this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ArrayOfInt.length - 1)] + ((List)this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_JavaUtilMap.get(this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ArrayOfJavaLangString[(this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ArrayOfJavaLangString.length - 1)])).size() + 1;
    }
    return i;
  }
  
  public Object getItem(int paramInt)
  {
    int i = Arrays.binarySearch(this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ArrayOfInt, paramInt);
    if (i >= 0) {
      return null;
    }
    i = -(i + 1) - 1;
    return (TroopMemberInfo)((List)this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_JavaUtilMap.get(this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ArrayOfJavaLangString[i])).get(paramInt - this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ArrayOfInt[i] - 1);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = Arrays.binarySearch(this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ArrayOfInt, paramInt);
    boolean bool2 = true;
    int j = 0;
    View localView = paramView;
    Object localObject1;
    RelativeLayout.LayoutParams localLayoutParams;
    if (paramView == null)
    {
      localView = this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561026, paramViewGroup, false);
      paramView = new TroopAddFrdsInnerFrame.AddFrdHolder();
      paramView.jdField_a_of_type_AndroidViewView = localView.findViewById(2131376483);
      paramView.jdField_a_of_type_AndroidViewView.setId(2131379179);
      localObject1 = localView.findViewById(2131378196);
      localLayoutParams = (RelativeLayout.LayoutParams)((View)localObject1).getLayoutParams();
      localLayoutParams.addRule(0, 2131379179);
      localLayoutParams.rightMargin = CommonUtils.a(10.0F, this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopAddFrdsInnerFrame.getResources());
      ((View)localObject1).setLayoutParams(localLayoutParams);
      paramView.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131361799));
      paramView.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131376487));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131371877));
      paramView.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131377726));
      paramView.jdField_a_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131376477));
      paramView.d = ((TextView)localView.findViewById(2131376485));
      paramView.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)localView.findViewById(2131364609));
      paramView.e = ((TextView)localView.findViewById(2131379732));
      paramView.jdField_b_of_type_AndroidViewView = localView.findViewById(2131374200);
      paramView.e.setFocusableInTouchMode(false);
      paramView.jdField_b_of_type_AndroidViewView.setFocusableInTouchMode(false);
      paramView.e.setFocusable(false);
      paramView.jdField_b_of_type_AndroidViewView.setFocusable(false);
      paramView.jdField_a_of_type_AndroidViewView.setDuplicateParentStateEnabled(false);
      paramView.jdField_a_of_type_AndroidWidgetButton.setDuplicateParentStateEnabled(true);
      paramView.d.setDuplicateParentStateEnabled(false);
      paramView.jdField_a_of_type_AndroidWidgetButton.setClickable(false);
      paramView.jdField_b_of_type_AndroidWidgetTextView.setPadding(0, CommonUtils.a(2.0F, this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopAddFrdsInnerFrame.getResources()), 0, 0);
      if ((TroopAddFrdsInnerFrame.a(this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopAddFrdsInnerFrame) != null) && (TroopAddFrdsInnerFrame.a(this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopAddFrdsInnerFrame).getVisibility() == 0)) {
        localView.findViewById(2131379179).setPadding(0, 0, this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopAddFrdsInnerFrame.b, 0);
      } else {
        localView.findViewById(2131379179).setPadding(0, 0, this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopAddFrdsInnerFrame.c, 0);
      }
      localView.setTag(paramView);
    }
    TroopAddFrdsInnerFrame.AddFrdHolder localAddFrdHolder = (TroopAddFrdsInnerFrame.AddFrdHolder)localView.getTag();
    if (i < 0)
    {
      i = -(i + 1) - 1;
      Object localObject2 = (TroopMemberInfo)((List)this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_JavaUtilMap.get(this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ArrayOfJavaLangString[i])).get(paramInt - this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ArrayOfInt[i] - 1);
      localAddFrdHolder.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo = ((TroopMemberInfo)localObject2);
      if (this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.isResultListContainFriend(((TroopMemberInfo)localObject2).memberuin)) {
        localAddFrdHolder.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
      } else {
        localAddFrdHolder.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
      }
      boolean bool1 = AppSetting.d;
      localLayoutParams = null;
      if (bool1)
      {
        paramView = new StringBuilder(256);
        paramView.append("群成员");
      }
      else
      {
        paramView = null;
      }
      localAddFrdHolder.jdField_b_of_type_AndroidViewView.setVisibility(0);
      localAddFrdHolder.e.setVisibility(8);
      localAddFrdHolder.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(a(((TroopMemberInfo)localObject2).memberuin));
      Object localObject3 = CommonUtils.a(this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ComTencentCommonAppAppInterface, ((TroopMemberInfo)localObject2).troopuin, ((TroopMemberInfo)localObject2).memberuin);
      localObject1 = localObject3;
      if (!TextUtils.isEmpty(((TroopMemberInfo)localObject2).recommendRemark))
      {
        localObject1 = localObject3;
        if (!TextUtils.equals(((TroopMemberInfo)localObject2).recommendRemark, ((TroopMemberInfo)localObject2).memberuin))
        {
          localObject1 = localObject3;
          if (!TextUtils.equals(((TroopMemberInfo)localObject2).recommendRemark, (CharSequence)localObject3))
          {
            localObject1 = localObject3;
            if (!SearchUtils.a(this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ComTencentCommonAppAppInterface, ((TroopMemberInfo)localObject2).memberuin))
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append((String)localObject3);
              ((StringBuilder)localObject1).append(" (");
              ((StringBuilder)localObject1).append(((TroopMemberInfo)localObject2).recommendRemark);
              ((StringBuilder)localObject1).append(")");
              localObject1 = ((StringBuilder)localObject1).toString();
            }
          }
        }
      }
      localAddFrdHolder.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      localAddFrdHolder.jdField_a_of_type_JavaLangString = ((TroopMemberInfo)localObject2).memberuin;
      localAddFrdHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      if (AppSetting.d) {
        paramView.append((String)localObject1);
      }
      if (((TroopMemberInfo)localObject2).commonFrdCnt > 0)
      {
        localAddFrdHolder.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopAddFrdsInnerFrame.getResources().getString(2131689691, new Object[] { Integer.valueOf(((TroopMemberInfo)localObject2).commonFrdCnt) }));
        localAddFrdHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        if (AppSetting.d) {
          paramView.append(localAddFrdHolder.jdField_b_of_type_AndroidWidgetTextView.getText());
        }
      }
      else
      {
        localAddFrdHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      if (!this.jdField_a_of_type_Boolean) {
        localAddFrdHolder.jdField_b_of_type_AndroidViewView.setEnabled(true);
      }
      if (((TroopMemberInfo)localObject2).addState == 1) {
        i = TroopAddFrdsInnerFrame.a(this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopAddFrdsInnerFrame, ((TroopMemberInfo)localObject2).memberuin);
      } else {
        i = ((TroopMemberInfo)localObject2).addState;
      }
      if (i == 4)
      {
        localAddFrdHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        localAddFrdHolder.d.setVisibility(0);
        localAddFrdHolder.d.setText(HardCodeUtil.a(2131714933));
        if (this.jdField_a_of_type_Boolean)
        {
          localAddFrdHolder.jdField_b_of_type_AndroidViewView.setEnabled(false);
          localAddFrdHolder.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(false);
          localAddFrdHolder.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
        }
        if (AppSetting.d) {
          localAddFrdHolder.d.setContentDescription(HardCodeUtil.a(2131714935));
        }
      }
      else
      {
        if (i != 3) {
          break label1114;
        }
        localAddFrdHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        localAddFrdHolder.d.setVisibility(0);
        localAddFrdHolder.d.setText(HardCodeUtil.a(2131714931));
        if (this.jdField_a_of_type_Boolean)
        {
          localAddFrdHolder.jdField_b_of_type_AndroidViewView.setEnabled(false);
          localAddFrdHolder.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(false);
          localAddFrdHolder.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
        }
        if (AppSetting.d) {
          localAddFrdHolder.d.setContentDescription(HardCodeUtil.a(2131714930));
        }
      }
      bool1 = false;
      break label1240;
      label1114:
      if (this.jdField_a_of_type_Boolean)
      {
        localAddFrdHolder.jdField_b_of_type_AndroidViewView.setEnabled(true);
        localAddFrdHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        localAddFrdHolder.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(true);
        localAddFrdHolder.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(a((TroopMemberInfo)localObject2));
        localAddFrdHolder.jdField_a_of_type_AndroidWidgetCheckBox.setTag(localAddFrdHolder);
        bool1 = false;
      }
      else
      {
        localAddFrdHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        localAddFrdHolder.jdField_a_of_type_AndroidWidgetButton.setText(HardCodeUtil.a(2131689589));
        bool1 = bool2;
        if (AppSetting.d)
        {
          localAddFrdHolder.jdField_a_of_type_AndroidWidgetButton.setContentDescription(HardCodeUtil.a(2131689589));
          bool1 = bool2;
        }
      }
      localAddFrdHolder.d.setVisibility(8);
      label1240:
      localObject3 = localAddFrdHolder.jdField_a_of_type_AndroidViewView;
      if (bool1) {
        localObject1 = localObject2;
      } else {
        localObject1 = null;
      }
      ((View)localObject3).setTag(localObject1);
      localObject2 = localAddFrdHolder.jdField_a_of_type_AndroidViewView;
      localObject1 = localLayoutParams;
      if (bool1) {
        localObject1 = this;
      }
      ((View)localObject2).setOnClickListener((View.OnClickListener)localObject1);
      localAddFrdHolder.jdField_a_of_type_AndroidViewView.setClickable(bool1);
      localObject1 = localAddFrdHolder.jdField_a_of_type_AndroidWidgetCheckBox;
      if (this.jdField_a_of_type_Boolean) {
        i = j;
      } else {
        i = 8;
      }
      ((CheckBox)localObject1).setVisibility(i);
      localAddFrdHolder.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
      localAddFrdHolder.jdField_b_of_type_AndroidViewView.setTag(localAddFrdHolder);
      if (AppSetting.d) {
        localView.setContentDescription(paramView.toString());
      }
    }
    else
    {
      localAddFrdHolder.jdField_b_of_type_AndroidViewView.setVisibility(8);
      if (this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopAddFrdsInnerFrame.f == TroopAddFrdsInnerFrame.d)
      {
        localAddFrdHolder.e.setVisibility(0);
        paramView = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ArrayOfJavaLangString[i]);
        localAddFrdHolder.e.setText(paramView);
        localAddFrdHolder.e.setContentDescription(String.format(this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.getString(2131691806), new Object[] { paramView.toLowerCase() }));
      }
      else
      {
        localAddFrdHolder.e.setVisibility(8);
        localView.setBackgroundResource(0);
      }
    }
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
  
  public void onClick(View paramView)
  {
    Object localObject1 = paramView.getTag();
    if (localObject1 != null)
    {
      int i = paramView.getId();
      if (i == 2131379179)
      {
        localObject1 = (TroopMemberInfo)localObject1;
        TroopAddFrdsInnerFrame.a(this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity, (TroopMemberInfo)localObject1, TroopAddFrdsInnerFrame.b(this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopAddFrdsInnerFrame), false);
      }
      else if (i == 2131374200)
      {
        Object localObject2;
        if (this.jdField_a_of_type_Boolean)
        {
          localObject1 = (TroopAddFrdsInnerFrame.AddFrdHolder)localObject1;
          boolean bool = a(((TroopAddFrdsInnerFrame.AddFrdHolder)localObject1).jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo);
          localObject2 = new ResultRecord();
          ((ResultRecord)localObject2).uin = ((TroopAddFrdsInnerFrame.AddFrdHolder)localObject1).jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.memberuin;
          ArrayList localArrayList = new ArrayList(1);
          localArrayList.add(localObject2);
          if (!bool)
          {
            this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.addFriendResults(localArrayList, false);
          }
          else
          {
            this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.removeFriendFromResultList(((TroopAddFrdsInnerFrame.AddFrdHolder)localObject1).jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.memberuin);
            this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.updateMultiAddState((ResultRecord)localObject2, false);
            this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mSelectedAndSearchBar.a(false);
            this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.setupDoneBtn();
          }
          notifyDataSetChanged();
        }
        else
        {
          localObject1 = ((TroopAddFrdsInnerFrame.AddFrdHolder)localObject1).jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo;
          localObject2 = ((IProfileCardApi)QRoute.api(IProfileCardApi.class)).getProfileCardIntentOnly(this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity, null);
          ((Intent)localObject2).putExtra("troopUin", ((TroopMemberInfo)localObject1).troopuin);
          ((Intent)localObject2).putExtra("memberUin", ((TroopMemberInfo)localObject1).memberuin);
          ((Intent)localObject2).putExtra("fromFlag", 1);
          ((Intent)localObject2).putExtra("selfSet_leftViewText", this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.getString(2131719952));
          ((Intent)localObject2).putExtra("custom_leftbackbutton_name", this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.getString(2131690706));
          ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).joinFriendProfileIntentWithTroopMemberCardIntent(this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity, this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ComTencentCommonAppAppInterface, (Intent)localObject2, 9);
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.TroopAddFrdsInnerFrame.ListAdapter
 * JD-Core Version:    0.7.0.1
 */