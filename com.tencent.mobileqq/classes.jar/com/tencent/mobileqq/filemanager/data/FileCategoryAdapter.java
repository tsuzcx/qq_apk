package com.tencent.mobileqq.filemanager.data;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class FileCategoryAdapter
  extends BaseAdapter
{
  private List<FileCategoryEntity> a;
  private BaseFileAssistantActivity b;
  private LayoutInflater c;
  private View.OnClickListener d;
  
  public FileCategoryAdapter(BaseFileAssistantActivity paramBaseFileAssistantActivity, List<FileCategoryEntity> paramList, View.OnClickListener paramOnClickListener)
  {
    this.b = paramBaseFileAssistantActivity;
    this.a = paramList;
    this.c = LayoutInflater.from(this.b);
    this.d = paramOnClickListener;
  }
  
  public int getCount()
  {
    return this.a.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.a.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (((FileCategoryEntity)this.a.get(paramInt)).a == 0) {
      return 0;
    }
    if (((FileCategoryEntity)this.a.get(paramInt)).a == 3) {
      return 3;
    }
    if (((FileCategoryEntity)this.a.get(paramInt)).a == 2) {
      return 2;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    FileCategoryEntity localFileCategoryEntity = (FileCategoryEntity)this.a.get(paramInt);
    Object localObject1 = null;
    Object localObject2;
    if (localFileCategoryEntity == null)
    {
      localObject2 = paramView;
    }
    else
    {
      Object localObject3;
      if (paramView == null)
      {
        localObject2 = new FileCategoryAdapter.ItemHolder(this);
        paramView = this.c.inflate(localFileCategoryEntity.b, paramViewGroup, false);
        localObject3 = new RedTouch(this.b, paramView).b(30.0F).a();
        ((View)localObject3).setTag(localObject2);
        if ((localFileCategoryEntity.a != 0) && (localFileCategoryEntity.a != 3))
        {
          if (localFileCategoryEntity.a != 1)
          {
            paramView = (View)localObject3;
            localObject1 = localObject2;
            if (localFileCategoryEntity.a != 4) {}
          }
          else
          {
            ((FileCategoryAdapter.ItemHolder)localObject2).i = ((TextView)((View)localObject3).findViewById(2131431997));
            ((FileCategoryAdapter.ItemHolder)localObject2).j = ((TextView)((View)localObject3).findViewById(2131447089));
            paramView = (View)localObject3;
            localObject1 = localObject2;
          }
        }
        else
        {
          ((FileCategoryAdapter.ItemHolder)localObject2).a = ((View)localObject3).findViewById(2131430389);
          ((FileCategoryAdapter.ItemHolder)localObject2).a.setOnClickListener(this.d);
          ((FileCategoryAdapter.ItemHolder)localObject2).b = ((ImageView)((View)localObject3).findViewById(2131430388));
          ((FileCategoryAdapter.ItemHolder)localObject2).c = ((ImageView)((View)localObject3).findViewById(2131444527));
          ((FileCategoryAdapter.ItemHolder)localObject2).e = ((TextView)((View)localObject3).findViewById(2131430390));
          ((FileCategoryAdapter.ItemHolder)localObject2).d = ((TextView)((View)localObject3).findViewById(2131439506));
          ((FileCategoryAdapter.ItemHolder)localObject2).f = ((TextView)((View)localObject3).findViewById(2131446312));
          paramView = (View)localObject3;
          localObject1 = localObject2;
        }
      }
      else
      {
        localObject1 = (FileCategoryAdapter.ItemHolder)paramView.getTag();
      }
      ((FileCategoryAdapter.ItemHolder)localObject1).g = localFileCategoryEntity.g;
      ((FileCategoryAdapter.ItemHolder)localObject1).h = localFileCategoryEntity.k;
      if (localFileCategoryEntity.a == 0)
      {
        if (localFileCategoryEntity.j) {
          ((FileCategoryAdapter.ItemHolder)localObject1).c.setVisibility(0);
        } else {
          ((FileCategoryAdapter.ItemHolder)localObject1).c.setVisibility(8);
        }
        if (localFileCategoryEntity.i)
        {
          ((FileCategoryAdapter.ItemHolder)localObject1).b.setVisibility(0);
          ((FileCategoryAdapter.ItemHolder)localObject1).b.setBackgroundResource(localFileCategoryEntity.c);
        }
        else
        {
          ((FileCategoryAdapter.ItemHolder)localObject1).b.setVisibility(8);
        }
        if (!TextUtils.isEmpty(localFileCategoryEntity.h))
        {
          ((FileCategoryAdapter.ItemHolder)localObject1).f.setText(localFileCategoryEntity.h);
          ((FileCategoryAdapter.ItemHolder)localObject1).f.setVisibility(0);
        }
        else
        {
          ((FileCategoryAdapter.ItemHolder)localObject1).f.setVisibility(8);
        }
        ((FileCategoryAdapter.ItemHolder)localObject1).e.setText(localFileCategoryEntity.d);
        ((FileCategoryAdapter.ItemHolder)localObject1).a.setTag(localObject1);
        if (localFileCategoryEntity.f)
        {
          localObject2 = ((FileCategoryAdapter.ItemHolder)localObject1).d;
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("(");
          ((StringBuilder)localObject3).append(localFileCategoryEntity.e);
          ((StringBuilder)localObject3).append(")");
          ((TextView)localObject2).setText(((StringBuilder)localObject3).toString());
        }
        int i = localFileCategoryEntity.l;
        if (i != 1)
        {
          if (i != 2)
          {
            if (i != 3)
            {
              if (i != 4) {
                ((FileCategoryAdapter.ItemHolder)localObject1).a.setBackgroundResource(2130839622);
              } else {
                ((FileCategoryAdapter.ItemHolder)localObject1).a.setBackgroundResource(2130839629);
              }
            }
            else {
              ((FileCategoryAdapter.ItemHolder)localObject1).a.setBackgroundResource(2130839632);
            }
          }
          else {
            ((FileCategoryAdapter.ItemHolder)localObject1).a.setBackgroundResource(2130839638);
          }
        }
        else {
          ((FileCategoryAdapter.ItemHolder)localObject1).a.setBackgroundResource(2130839622);
        }
        if ((16 != localFileCategoryEntity.g) && (17 != localFileCategoryEntity.g)) {
          if (22 == localFileCategoryEntity.g)
          {
            localObject2 = ((IRedTouchManager)this.b.p.getRuntimeService(IRedTouchManager.class, "")).getAppInfoByPath("100160.100163");
            localObject3 = (RedTouch)paramView;
            ((RedTouch)localObject3).a((BusinessInfoCheckUpdate.AppInfo)localObject2);
            if (((RedTouch)localObject3).h()) {
              ((FileCategoryAdapter.ItemHolder)localObject1).c.setVisibility(4);
            } else {
              ((FileCategoryAdapter.ItemHolder)localObject1).c.setVisibility(8);
            }
          }
          else
          {
            ((RedTouch)paramView).g();
          }
        }
      }
      else if (localFileCategoryEntity.a == 1)
      {
        if (localFileCategoryEntity.f) {
          ((FileCategoryAdapter.ItemHolder)localObject1).j.setText(localFileCategoryEntity.d);
        } else {
          ((FileCategoryAdapter.ItemHolder)localObject1).j.setVisibility(4);
        }
      }
      else if (localFileCategoryEntity.a == 4)
      {
        if (localFileCategoryEntity.f)
        {
          ((FileCategoryAdapter.ItemHolder)localObject1).j.setGravity(17);
          localObject2 = (IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class);
          localObject3 = this.b;
          if (!((IQQFileTempUtils)localObject2).hasShortCut((Activity)localObject3, new String[] { ((BaseFileAssistantActivity)localObject3).getString(2131889351) }))
          {
            localObject2 = QQFileManagerUtil.a(localFileCategoryEntity.d, localFileCategoryEntity.d, null);
            ((FileCategoryAdapter.ItemHolder)localObject1).j.setClickable(true);
            ((FileCategoryAdapter.ItemHolder)localObject1).j.setOnClickListener(this.d);
            ((FileCategoryAdapter.ItemHolder)localObject1).j.setText((CharSequence)localObject2);
            ((FileCategoryAdapter.ItemHolder)localObject1).j.setTag(localObject1);
          }
        }
        else
        {
          ((FileCategoryAdapter.ItemHolder)localObject1).j.setVisibility(4);
        }
      }
      localObject2 = paramView;
      localObject1 = paramView;
    }
    EventCollector.getInstance().onListGetView(paramInt, (View)localObject2, paramViewGroup, getItemId(paramInt));
    return localObject1;
  }
  
  public int getViewTypeCount()
  {
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.FileCategoryAdapter
 * JD-Core Version:    0.7.0.1
 */