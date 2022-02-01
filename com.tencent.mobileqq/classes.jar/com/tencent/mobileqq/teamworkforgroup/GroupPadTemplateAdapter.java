package com.tencent.mobileqq.teamworkforgroup;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.URLUtil;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class GroupPadTemplateAdapter
  extends BaseAdapter
  implements View.OnClickListener
{
  public static int d = 1;
  public static int e = 2;
  Context a;
  final List<GroupPadTemplateInfo> b = new ArrayList();
  protected View.OnClickListener c;
  private Set<String> f = new HashSet();
  private Set<String> g = new HashSet();
  
  public GroupPadTemplateAdapter(Context paramContext, View.OnClickListener paramOnClickListener)
  {
    this.c = paramOnClickListener;
    this.a = paramContext;
  }
  
  private void a(AsyncImageView paramAsyncImageView, GroupPadTemplateInfo paramGroupPadTemplateInfo)
  {
    if (paramGroupPadTemplateInfo != null)
    {
      Drawable localDrawable = this.a.getResources().getDrawable(2130840628);
      if (!URLUtil.e(paramGroupPadTemplateInfo.mobThumbUrl))
      {
        paramAsyncImageView.setImageDrawable(localDrawable);
        return;
      }
      String str = paramGroupPadTemplateInfo.mobThumbUrl;
      paramGroupPadTemplateInfo = URLDrawable.URLDrawableOptions.obtain();
      paramGroupPadTemplateInfo.mLoadingDrawable = localDrawable;
      paramGroupPadTemplateInfo.mFailedDrawable = localDrawable;
      Object localObject = null;
      try
      {
        paramGroupPadTemplateInfo = URLDrawable.getDrawable(str, paramGroupPadTemplateInfo);
      }
      catch (Exception localException)
      {
        paramGroupPadTemplateInfo = localObject;
        if (QLog.isColorLevel())
        {
          QLog.e("GroupPadTemplateAdapter", 2, localException, new Object[] { "loadThumbImage failed" });
          paramGroupPadTemplateInfo = localObject;
        }
      }
      if (paramGroupPadTemplateInfo != null)
      {
        if ((paramGroupPadTemplateInfo.getStatus() == 2) && (this.g.remove(str))) {
          paramGroupPadTemplateInfo.restartDownload();
        }
        paramGroupPadTemplateInfo.setDownloadListener(new GroupPadTemplateAdapter.1(this, str));
        paramAsyncImageView.setImageDrawable(paramGroupPadTemplateInfo);
        if (QLog.isColorLevel())
        {
          paramAsyncImageView = new StringBuilder();
          paramAsyncImageView.append("loadThumbImage is ok. url: ");
          paramAsyncImageView.append(str);
          QLog.d("GroupPadTemplateAdapter", 2, paramAsyncImageView.toString());
        }
      }
      else
      {
        paramAsyncImageView.setImageDrawable(localDrawable);
      }
    }
    else
    {
      paramAsyncImageView.setImageResource(2130840628);
    }
  }
  
  public GroupPadTemplateInfo a()
  {
    GroupPadTemplateInfo localGroupPadTemplateInfo = new GroupPadTemplateInfo();
    localGroupPadTemplateInfo.docOrSheetType = 1;
    localGroupPadTemplateInfo.templateName = this.a.getString(2131890192);
    return localGroupPadTemplateInfo;
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.c = paramOnClickListener;
  }
  
  public void a(List<GroupPadTemplateInfo> paramList)
  {
    this.b.clear();
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        GroupPadTemplateInfo localGroupPadTemplateInfo = (GroupPadTemplateInfo)paramList.next();
        if ((localGroupPadTemplateInfo != null) && (localGroupPadTemplateInfo.templateID >= 0)) {
          this.b.add(localGroupPadTemplateInfo);
        }
      }
      paramList = a();
      this.b.add(paramList);
    }
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.b.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.b.size())) {
      return this.b.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    GroupPadTemplateInfo localGroupPadTemplateInfo = (GroupPadTemplateInfo)getItem(paramInt);
    if (localGroupPadTemplateInfo != null) {
      return localGroupPadTemplateInfo.templateID;
    }
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    GroupPadTemplateInfo localGroupPadTemplateInfo = (GroupPadTemplateInfo)getItem(paramInt);
    GroupPadTemplateAdapter.GroupPadTemplateItemHolder localGroupPadTemplateItemHolder;
    if (getCount() == paramInt + 1)
    {
      paramView = LayoutInflater.from(this.a).inflate(2131624967, null);
      localGroupPadTemplateItemHolder = new GroupPadTemplateAdapter.GroupPadTemplateItemHolder(this);
      localGroupPadTemplateItemHolder.e = e;
      localGroupPadTemplateItemHolder.b = ((AsyncImageView)paramView.findViewById(2131434446));
      localGroupPadTemplateItemHolder.c = ((TextView)paramView.findViewById(2131434442));
      localGroupPadTemplateItemHolder.d = ((ImageView)paramView.findViewById(2131434440));
      localGroupPadTemplateItemHolder.a = localGroupPadTemplateInfo;
      paramView.setTag(localGroupPadTemplateItemHolder);
      paramView.setOnClickListener(this.c);
    }
    else
    {
      paramView = LayoutInflater.from(this.a).inflate(2131624966, null);
      localGroupPadTemplateItemHolder = new GroupPadTemplateAdapter.GroupPadTemplateItemHolder(this);
      localGroupPadTemplateItemHolder.e = d;
      localGroupPadTemplateItemHolder.b = ((AsyncImageView)paramView.findViewById(2131434445));
      localGroupPadTemplateItemHolder.c = ((TextView)paramView.findViewById(2131434444));
      localGroupPadTemplateItemHolder.d = ((ImageView)paramView.findViewById(2131434439));
      localGroupPadTemplateItemHolder.a = localGroupPadTemplateInfo;
      paramView.setTag(localGroupPadTemplateItemHolder);
      paramView.setOnClickListener(this.c);
    }
    if (localGroupPadTemplateItemHolder.a != null)
    {
      if (localGroupPadTemplateItemHolder.e == d) {
        a(localGroupPadTemplateItemHolder.b, localGroupPadTemplateInfo);
      } else if (localGroupPadTemplateItemHolder.e == e) {
        localGroupPadTemplateItemHolder.b.setImageResource(2130840630);
      }
      localGroupPadTemplateItemHolder.c.setText(localGroupPadTemplateInfo.templateName);
    }
    else
    {
      localGroupPadTemplateItemHolder.b.setImageResource(2130840628);
      localGroupPadTemplateItemHolder.c.setText("");
    }
    if (AppSetting.e) {
      if (localGroupPadTemplateInfo != null) {
        paramView.setContentDescription(localGroupPadTemplateInfo.templateName);
      } else {
        paramView.setContentDescription("");
      }
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
  
  public void onClick(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.teamworkforgroup.GroupPadTemplateAdapter
 * JD-Core Version:    0.7.0.1
 */