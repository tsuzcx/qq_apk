package com.tencent.mobileqq.teamworkforgroup;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.teamwork.PadInfo;
import com.tencent.mobileqq.teamwork.TeamWorkUtils;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troop.widget.SingleLineHotwordTextView;
import com.tencent.mobileqq.utils.ContactUtils;
import java.util.ArrayList;
import java.util.List;

public class TeamWorkItemBuilder
  extends BaseMenuCloudFileItemBuilder
{
  private Context b;
  
  public TeamWorkItemBuilder(QQAppInterface paramQQAppInterface, Context paramContext, BaseAdapter paramBaseAdapter, int paramInt)
  {
    super(paramQQAppInterface, paramContext, paramBaseAdapter, paramInt);
    this.jdField_b_of_type_AndroidContentContext = paramContext;
  }
  
  private String a(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(paramString1)) {
      paramString1 = HardCodeUtil.a(2131714646);
    }
    String str;
    do
    {
      return paramString1;
      str = ContactUtils.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, true);
      if ((str != null) && (!str.equals(paramString1))) {
        break;
      }
      paramString1 = paramString2;
    } while (!TextUtils.isEmpty(paramString2));
    return str;
  }
  
  public List<MenuItem> a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(c);
    localArrayList.add(jdField_b_of_type_ComTencentMobileqqTeamworkforgroupMenuItem);
    return localArrayList;
  }
  
  public List<MenuItem> a(ICloudFile paramICloudFile)
  {
    ArrayList localArrayList = new ArrayList();
    boolean bool;
    int i;
    if ((paramICloudFile instanceof GPadInfo))
    {
      paramICloudFile = (GPadInfo)paramICloudFile;
      if ((this.jdField_b_of_type_AndroidContentContext == null) || (!(this.jdField_b_of_type_AndroidContentContext instanceof GroupTeamWorkListActivity))) {
        break label142;
      }
      bool = TroopUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((GroupTeamWorkListActivity)this.jdField_b_of_type_AndroidContentContext).a, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      if (paramICloudFile.creatorUin != this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin()) {
        break label137;
      }
      i = 1;
    }
    for (;;)
    {
      if ((i != 0) && (BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4).getBoolean("TIMDocLimitSettingFlag", false))) {}
      localArrayList.add(c);
      if ((i != 0) || (bool)) {
        localArrayList.add(jdField_b_of_type_ComTencentMobileqqTeamworkforgroupMenuItem);
      }
      return localArrayList;
      label137:
      i = 0;
      continue;
      label142:
      i = 0;
      bool = false;
    }
  }
  
  public View b(int paramInt1, ICloudFile paramICloudFile, View paramView, ViewGroup paramViewGroup, boolean paramBoolean1, boolean paramBoolean2, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, boolean paramBoolean3, int paramInt2)
  {
    View localView;
    PadInfo localPadInfo;
    label151:
    long l;
    label271:
    label295:
    Object localObject;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131563091, paramViewGroup, false);
      paramViewGroup = new TeamWorkItemBuilder.Holder(this, null);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131364845));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqTroopWidgetSingleLineHotwordTextView = ((SingleLineHotwordTextView)localView.findViewById(2131364847));
      paramViewGroup.c = ((TextView)localView.findViewById(2131364848));
      paramViewGroup.b = ((TextView)localView.findViewById(2131364864));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131364865));
      paramViewGroup.jdField_a_of_type_AndroidViewView = localView.findViewById(2131364849);
      localView.setTag(paramViewGroup);
      localPadInfo = (PadInfo)paramICloudFile;
      if (localPadInfo.type != 1) {
        break label494;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130850995);
      if (((localPadInfo instanceof GPadInfo)) && (((GPadInfo)localPadInfo).searchKeyWordList.size() > 0))
      {
        paramView = (ArrayList)((GPadInfo)localPadInfo).searchKeyWordList;
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqTroopWidgetSingleLineHotwordTextView.setHotwords(paramView);
      }
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqTroopWidgetSingleLineHotwordTextView.setText(localPadInfo.title);
      paramInt2 = localPadInfo.type_list;
      if ((paramInt2 != 1) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals("" + localPadInfo.creatorUin))) {
        break label531;
      }
      paramView = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131719788);
      paramViewGroup.c.setText(paramView);
      if (!(localPadInfo instanceof GPadInfo)) {
        break label659;
      }
      l = localPadInfo.lastEditTime;
      localObject = null;
      paramView = localObject;
      if (l > 0L)
      {
        if (l != localPadInfo.lastEditTime) {
          break label677;
        }
        paramView = a("" + localPadInfo.lastEditorUin, localPadInfo.lastEditorNick);
        paramView = String.format(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131719829), new Object[] { paramView });
      }
      label376:
      if (paramView == null) {
        break label768;
      }
      paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(0);
      paramViewGroup.b.setText(paramView);
      paramView = TeamWorkUtils.a(l);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(paramView);
      label413:
      if (this.jdField_b_of_type_Int != 1) {
        break label842;
      }
      if (localPadInfo.type_list != 4) {
        break label812;
      }
      if (!localPadInfo.pinInAllList) {
        break label801;
      }
      localView.setBackgroundResource(2130839645);
    }
    for (;;)
    {
      localView.setOnClickListener(paramOnClickListener);
      localView.setOnLongClickListener(paramOnLongClickListener);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupICloudFile = paramICloudFile;
      localView.setTag(-1, Integer.valueOf(paramInt1));
      return localView;
      paramViewGroup = (TeamWorkItemBuilder.Holder)paramView.getTag();
      localView = paramView;
      break;
      label494:
      if (localPadInfo.type == 3)
      {
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130850996);
        break label151;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130851003);
      break label151;
      label531:
      if (paramInt2 == 3)
      {
        paramView = a("" + localPadInfo.creatorUin, localPadInfo.shardNick);
        paramView = String.format(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131719830), new Object[] { paramView });
        break label271;
      }
      paramView = a("" + localPadInfo.creatorUin, localPadInfo.creatorNick);
      paramView = String.format(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131719828), new Object[] { paramView });
      break label271;
      label659:
      l = Math.max(localPadInfo.lastEditTime, localPadInfo.currentUserBrowseTime);
      break label295;
      label677:
      if (l == 0L)
      {
        paramView = HardCodeUtil.a(2131714651);
        paramView = String.format(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131719827), new Object[] { paramView });
        break label376;
      }
      paramView = localObject;
      if (l != localPadInfo.currentUserBrowseTime) {
        break label376;
      }
      paramView = HardCodeUtil.a(2131714630);
      paramView = String.format(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131719831), new Object[] { paramView });
      break label376;
      label768:
      paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
      paramViewGroup.b.setText("");
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText("");
      break label413;
      label801:
      localView.setBackgroundResource(2130839644);
      continue;
      label812:
      if (localPadInfo.pinedFlag)
      {
        localView.setBackgroundResource(2130839645);
      }
      else
      {
        localView.setBackgroundResource(2130839644);
        continue;
        label842:
        localView.setBackgroundResource(2130839644);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.teamworkforgroup.TeamWorkItemBuilder
 * JD-Core Version:    0.7.0.1
 */