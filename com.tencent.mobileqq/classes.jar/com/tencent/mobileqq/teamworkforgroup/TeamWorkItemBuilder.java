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
  private Context j;
  
  public TeamWorkItemBuilder(AppInterface paramAppInterface, Context paramContext, BaseAdapter paramBaseAdapter, int paramInt)
  {
    super(paramAppInterface, paramContext, paramBaseAdapter, paramInt);
    this.j = paramContext;
  }
  
  private String a(String paramString1, String paramString2)
  {
    if (this.f.getCurrentAccountUin().equals(paramString1)) {
      return HardCodeUtil.a(2131917124);
    }
    String str = null;
    if ((this.f instanceof AppInterface)) {
      str = ((IGetExternalInterface)QRoute.api(IGetExternalInterface.class)).getBuddyName(this.f, paramString1, true);
    }
    if (((str == null) || (str.equals(paramString1))) && (!TextUtils.isEmpty(paramString2))) {
      return paramString2;
    }
    return str;
  }
  
  public List<MenuItem> a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(d);
    localArrayList.add(c);
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
      if (((IGetExternalInterface)QRoute.api(IGetExternalInterface.class)).isInstanceGroupTeamWorkListActivity(this.j))
      {
        if ((this.f instanceof AppInterface)) {
          bool = ((IGetExternalInterface)QRoute.api(IGetExternalInterface.class)).isTroopAdmin(this.f, ((IGetExternalInterface)QRoute.api(IGetExternalInterface.class)).getGroupUin(this.j), this.f.getCurrentAccountUin());
        } else {
          bool = false;
        }
        if (paramICloudFile.creatorUin == this.f.getLongAccountUin()) {
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
      localArrayList.add(d);
      if ((i != 0) || (bool)) {
        localArrayList.add(c);
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
      paramViewGroup = LayoutInflater.from(this.g).inflate(2131629378, paramViewGroup, false);
      localHolder = new TeamWorkItemBuilder.Holder(this, null);
      localHolder.c = ((ImageView)paramViewGroup.findViewById(2131430839));
      localHolder.d = ((SingleLineHotwordTextView)paramViewGroup.findViewById(2131430841));
      localHolder.g = ((TextView)paramViewGroup.findViewById(2131430842));
      localHolder.f = ((TextView)paramViewGroup.findViewById(2131430858));
      localHolder.e = ((TextView)paramViewGroup.findViewById(2131430859));
      localHolder.h = paramViewGroup.findViewById(2131430843);
      paramViewGroup.setTag(localHolder);
    }
    else
    {
      localHolder = (TeamWorkItemBuilder.Holder)paramView.getTag();
      paramViewGroup = paramView;
    }
    PadInfo localPadInfo = (PadInfo)paramICloudFile;
    if (localPadInfo.type == 1) {
      localHolder.c.setImageResource(2130852787);
    } else if (localPadInfo.type == 3) {
      localHolder.c.setImageResource(2130852788);
    } else {
      localHolder.c.setImageResource(2130852795);
    }
    paramBoolean1 = localPadInfo instanceof GPadInfo;
    if (paramBoolean1)
    {
      paramView = (GPadInfo)localPadInfo;
      if (paramView.searchKeyWordList.size() > 0)
      {
        paramView = (ArrayList)paramView.searchKeyWordList;
        localHolder.d.setHotwords(paramView);
      }
    }
    localHolder.d.setText(localPadInfo.title);
    paramInt2 = localPadInfo.type_list;
    if (paramInt2 != 1)
    {
      paramView = this.f.getCurrentAccountUin();
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
          paramView = String.format(this.g.getResources().getString(2131917117), new Object[] { paramView });
          break label481;
        }
        paramView = new StringBuilder();
        paramView.append("");
        paramView.append(localPadInfo.creatorUin);
        paramView = a(paramView.toString(), localPadInfo.creatorNick);
        paramView = String.format(this.g.getResources().getString(2131917115), new Object[] { paramView });
        break label481;
      }
    }
    paramView = this.g.getResources().getString(2131917075);
    label481:
    localHolder.g.setText(paramView);
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
        paramView = String.format(this.g.getResources().getString(2131917116), new Object[] { paramView });
      }
      else if (l == 0L)
      {
        paramView = HardCodeUtil.a(2131917124);
        paramView = String.format(this.g.getResources().getString(2131917114), new Object[] { paramView });
      }
      else
      {
        paramView = localObject;
        if (l == localPadInfo.currentUserBrowseTime)
        {
          paramView = HardCodeUtil.a(2131917124);
          paramView = String.format(this.g.getResources().getString(2131917118), new Object[] { paramView });
        }
      }
    }
    if (paramView != null)
    {
      localHolder.h.setVisibility(0);
      localHolder.f.setText(paramView);
      paramView = ((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).getCloudFileTime(l);
      localHolder.e.setText(paramView);
    }
    else
    {
      localHolder.h.setVisibility(8);
      localHolder.f.setText("");
      localHolder.e.setText("");
    }
    if (this.i == 1)
    {
      if (localPadInfo.type_list == 4)
      {
        if (localPadInfo.pinInAllList) {
          paramViewGroup.setBackgroundResource(2130839694);
        } else {
          paramViewGroup.setBackgroundResource(2130839693);
        }
      }
      else if (localPadInfo.pinedFlag) {
        paramViewGroup.setBackgroundResource(2130839694);
      } else {
        paramViewGroup.setBackgroundResource(2130839693);
      }
    }
    else {
      paramViewGroup.setBackgroundResource(2130839693);
    }
    paramViewGroup.setOnClickListener(paramOnClickListener);
    paramViewGroup.setOnLongClickListener(paramOnLongClickListener);
    localHolder.a = paramICloudFile;
    paramViewGroup.setTag(-1, Integer.valueOf(paramInt1));
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.teamworkforgroup.TeamWorkItemBuilder
 * JD-Core Version:    0.7.0.1
 */