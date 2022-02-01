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
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.rely.SingleLineHotwordTextView;
import com.tencent.mobileqq.teamwork.PadInfo;
import com.tencent.mobileqq.teamwork.api.IGetExternalInterface;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.List;

public class TeamWorkItemBuilder
  extends BaseMenuCloudFileItemBuilder
{
  private Context b;
  
  public TeamWorkItemBuilder(AppInterface paramAppInterface, Context paramContext, BaseAdapter paramBaseAdapter, int paramInt)
  {
    super(paramAppInterface, paramContext, paramBaseAdapter, paramInt);
    this.jdField_b_of_type_AndroidContentContext = paramContext;
  }
  
  private String a(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin().equals(paramString1)) {
      return HardCodeUtil.a(2131719561);
    }
    String str = null;
    if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof AppInterface)) {
      str = ((IGetExternalInterface)QRoute.api(IGetExternalInterface.class)).getBuddyName(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramString1, true);
    }
    if (((str == null) || (str.equals(paramString1))) && (!TextUtils.isEmpty(paramString2))) {
      return paramString2;
    }
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
    if ((paramICloudFile instanceof GPadInfo))
    {
      paramICloudFile = (GPadInfo)paramICloudFile;
      boolean bool;
      int i;
      if (((IGetExternalInterface)QRoute.api(IGetExternalInterface.class)).isInstanceGroupTeamWorkListActivity(this.jdField_b_of_type_AndroidContentContext))
      {
        if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof AppInterface)) {
          bool = ((IGetExternalInterface)QRoute.api(IGetExternalInterface.class)).isTroopAdmin(this.jdField_a_of_type_ComTencentCommonAppAppInterface, ((IGetExternalInterface)QRoute.api(IGetExternalInterface.class)).getGroupUin(this.jdField_b_of_type_AndroidContentContext), this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
        } else {
          bool = false;
        }
        if (paramICloudFile.creatorUin == this.jdField_a_of_type_ComTencentCommonAppAppInterface.getLongAccountUin()) {
          i = 1;
        } else {
          i = 0;
        }
      }
      else
      {
        i = 0;
        bool = false;
      }
      if (i != 0) {
        BaseApplication.getContext().getSharedPreferences("mobileQQ", 4).getBoolean("TIMDocLimitSettingFlag", false);
      }
      localArrayList.add(c);
      if ((i != 0) || (bool)) {
        localArrayList.add(jdField_b_of_type_ComTencentMobileqqTeamworkforgroupMenuItem);
      }
    }
    return localArrayList;
  }
  
  public View b(int paramInt1, ICloudFile paramICloudFile, View paramView, ViewGroup paramViewGroup, boolean paramBoolean1, boolean paramBoolean2, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, boolean paramBoolean3, int paramInt2)
  {
    Object localObject = null;
    TeamWorkItemBuilder.Holder localHolder;
    if (paramView == null)
    {
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131562918, paramViewGroup, false);
      localHolder = new TeamWorkItemBuilder.Holder(this, null);
      localHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131364731));
      localHolder.jdField_a_of_type_ComTencentMobileqqRelySingleLineHotwordTextView = ((SingleLineHotwordTextView)paramViewGroup.findViewById(2131364733));
      localHolder.c = ((TextView)paramViewGroup.findViewById(2131364734));
      localHolder.b = ((TextView)paramViewGroup.findViewById(2131364750));
      localHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131364751));
      localHolder.jdField_a_of_type_AndroidViewView = paramViewGroup.findViewById(2131364735);
      paramViewGroup.setTag(localHolder);
    }
    else
    {
      localHolder = (TeamWorkItemBuilder.Holder)paramView.getTag();
      paramViewGroup = paramView;
    }
    PadInfo localPadInfo = (PadInfo)paramICloudFile;
    if (localPadInfo.type == 1) {
      localHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130850935);
    } else if (localPadInfo.type == 3) {
      localHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130850936);
    } else {
      localHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130850943);
    }
    paramBoolean1 = localPadInfo instanceof GPadInfo;
    if (paramBoolean1)
    {
      paramView = (GPadInfo)localPadInfo;
      if (paramView.searchKeyWordList.size() > 0)
      {
        paramView = (ArrayList)paramView.searchKeyWordList;
        localHolder.jdField_a_of_type_ComTencentMobileqqRelySingleLineHotwordTextView.setHotwords(paramView);
      }
    }
    localHolder.jdField_a_of_type_ComTencentMobileqqRelySingleLineHotwordTextView.setText(localPadInfo.title);
    paramInt2 = localPadInfo.type_list;
    if (paramInt2 != 1)
    {
      paramView = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(localPadInfo.creatorUin);
      if (!paramView.equals(localStringBuilder.toString()))
      {
        if (paramInt2 == 3)
        {
          paramView = new StringBuilder();
          paramView.append("");
          paramView.append(localPadInfo.creatorUin);
          paramView = a(paramView.toString(), localPadInfo.shardNick);
          paramView = String.format(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131719554), new Object[] { paramView });
          break label481;
        }
        paramView = new StringBuilder();
        paramView.append("");
        paramView.append(localPadInfo.creatorUin);
        paramView = a(paramView.toString(), localPadInfo.creatorNick);
        paramView = String.format(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131719552), new Object[] { paramView });
        break label481;
      }
    }
    paramView = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131719512);
    label481:
    localHolder.c.setText(paramView);
    long l;
    if (paramBoolean1) {
      l = localPadInfo.lastEditTime;
    } else {
      l = Math.max(localPadInfo.lastEditTime, localPadInfo.currentUserBrowseTime);
    }
    paramView = localObject;
    if (l > 0L) {
      if (l == localPadInfo.lastEditTime)
      {
        paramView = new StringBuilder();
        paramView.append("");
        paramView.append(localPadInfo.lastEditorUin);
        paramView = a(paramView.toString(), localPadInfo.lastEditorNick);
        paramView = String.format(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131719553), new Object[] { paramView });
      }
      else if (l == 0L)
      {
        paramView = HardCodeUtil.a(2131719561);
        paramView = String.format(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131719551), new Object[] { paramView });
      }
      else
      {
        paramView = localObject;
        if (l == localPadInfo.currentUserBrowseTime)
        {
          paramView = HardCodeUtil.a(2131719561);
          paramView = String.format(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131719555), new Object[] { paramView });
        }
      }
    }
    if (paramView != null)
    {
      localHolder.jdField_a_of_type_AndroidViewView.setVisibility(0);
      localHolder.b.setText(paramView);
      paramView = ((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).getCloudFileTime(l);
      localHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramView);
    }
    else
    {
      localHolder.jdField_a_of_type_AndroidViewView.setVisibility(8);
      localHolder.b.setText("");
      localHolder.jdField_a_of_type_AndroidWidgetTextView.setText("");
    }
    if (this.jdField_b_of_type_Int == 1)
    {
      if (localPadInfo.type_list == 4)
      {
        if (localPadInfo.pinInAllList) {
          paramViewGroup.setBackgroundResource(2130839503);
        } else {
          paramViewGroup.setBackgroundResource(2130839502);
        }
      }
      else if (localPadInfo.pinedFlag) {
        paramViewGroup.setBackgroundResource(2130839503);
      } else {
        paramViewGroup.setBackgroundResource(2130839502);
      }
    }
    else {
      paramViewGroup.setBackgroundResource(2130839502);
    }
    paramViewGroup.setOnClickListener(paramOnClickListener);
    paramViewGroup.setOnLongClickListener(paramOnLongClickListener);
    localHolder.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupICloudFile = paramICloudFile;
    paramViewGroup.setTag(-1, Integer.valueOf(paramInt1));
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.teamworkforgroup.TeamWorkItemBuilder
 * JD-Core Version:    0.7.0.1
 */