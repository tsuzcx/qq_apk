package com.tencent.mobileqq.filemanager.activity.delDownloadFile;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.adapter.DelDownloadHolder;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileBaseExpandableListAdapter.IQfileViewBinder;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileBaseExpandableListAdapter.QfileGroupTag;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileLocalImageExpandableListAdapter;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.widget.EllipsizingTextView;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.LinkedHashMap;
import java.util.List;

public class QFileDelDownloadAdapter
  extends QfileLocalImageExpandableListAdapter
  implements View.OnClickListener
{
  LinkedHashMap<String, List<FileInfo>> i = null;
  int j = -1;
  
  public QFileDelDownloadAdapter(BaseFileAssistantActivity paramBaseFileAssistantActivity, Object paramObject, int paramInt)
  {
    super(paramBaseFileAssistantActivity, paramObject, null, null, null, null, null);
    this.i = ((LinkedHashMap)paramObject);
    this.j = paramInt;
  }
  
  protected int a()
  {
    return 4;
  }
  
  protected View a(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = getChild(paramInt1, paramInt2);
    Object localObject1;
    if (paramViewGroup != null) {
      localObject1 = (FileInfo)paramViewGroup;
    } else {
      localObject1 = null;
    }
    if (localObject1 == null) {
      return null;
    }
    if (paramView == null) {
      paramViewGroup = paramView;
    }
    try
    {
      paramView = this.c.inflate(2131627053, null);
      paramViewGroup = paramView;
      DelDownloadHolder localDelDownloadHolder = new DelDownloadHolder();
      paramViewGroup = paramView;
      localDelDownloadHolder.a = ((AsyncImageView)paramView.findViewById(2131435357));
      paramViewGroup = paramView;
      localDelDownloadHolder.b = ((ImageView)paramView.findViewById(2131435382));
      paramViewGroup = paramView;
      localDelDownloadHolder.c = ((ImageView)paramView.findViewById(2131435377));
      paramViewGroup = paramView;
      localDelDownloadHolder.d = ((EllipsizingTextView)paramView.findViewById(2131433114));
      paramViewGroup = paramView;
      localDelDownloadHolder.f = ((TextView)paramView.findViewById(2131433117));
      paramViewGroup = paramView;
      localDelDownloadHolder.e = ((FrameLayout)paramView.findViewById(2131430794));
      paramViewGroup = paramView;
      paramView.setTag(localDelDownloadHolder);
      break label209;
      paramViewGroup = paramView;
      localDelDownloadHolder = (DelDownloadHolder)paramView.getTag();
      label209:
      paramViewGroup = paramView;
      ((FileInfo)localObject1).a((String)getGroup(paramInt1));
      paramViewGroup = paramView;
      localDelDownloadHolder.g = ((FileInfo)localObject1);
      paramViewGroup = paramView;
      localDelDownloadHolder.h = paramInt2;
      paramViewGroup = paramView;
      localDelDownloadHolder.i = paramInt1;
      paramViewGroup = paramView;
      localDelDownloadHolder.a.setAdjustViewBounds(false);
      paramViewGroup = paramView;
      localDelDownloadHolder.a.setScaleType(ImageView.ScaleType.CENTER_CROP);
      paramViewGroup = paramView;
      localDelDownloadHolder.a.setDefaultImage(2130849738);
      paramViewGroup = paramView;
      localDelDownloadHolder.a.setAsyncClipSize(this.d, this.d);
      paramViewGroup = paramView;
      if (!((FileInfo)localObject1).h())
      {
        paramViewGroup = paramView;
        localDelDownloadHolder.d.setText(((FileInfo)localObject1).e());
        paramViewGroup = paramView;
        localDelDownloadHolder.d.setMaxLines(2);
      }
      else
      {
        paramViewGroup = paramView;
        localDelDownloadHolder.d.setText(null);
      }
      paramViewGroup = paramView;
      localDelDownloadHolder.f.setText(FileUtil.a(((FileInfo)localObject1).f()));
      paramViewGroup = paramView;
      paramView.setOnClickListener(this);
      paramViewGroup = paramView;
      localDelDownloadHolder.e.setOnClickListener(this);
      paramViewGroup = paramView;
      localDelDownloadHolder.e.setTag(localDelDownloadHolder);
      paramViewGroup = paramView;
      if (this.f != null)
      {
        paramViewGroup = paramView;
        localObject2 = this.f.a((FileInfo)localObject1);
        paramViewGroup = paramView;
        if (FileUtils.fileExistsAndNotEmpty((String)localObject2))
        {
          paramViewGroup = paramView;
          localDelDownloadHolder.a.setAsyncImage((String)localObject2);
        }
      }
      paramViewGroup = paramView;
      Object localObject2 = new StringBuilder();
      paramViewGroup = paramView;
      ((StringBuilder)localObject2).append(this.b.getString(2131889359));
      paramViewGroup = paramView;
      ((StringBuilder)localObject2).append(((FileInfo)localObject1).e());
      paramViewGroup = paramView;
      localObject2 = ((StringBuilder)localObject2).toString();
      paramViewGroup = paramView;
      localDelDownloadHolder.b.setVisibility(0);
      paramViewGroup = paramView;
      if (FMDataCache.a((FileInfo)localObject1))
      {
        paramViewGroup = paramView;
        localObject1 = new StringBuilder();
        paramViewGroup = paramView;
        ((StringBuilder)localObject1).append((String)localObject2);
        paramViewGroup = paramView;
        ((StringBuilder)localObject1).append(this.b.getString(2131889360));
        paramViewGroup = paramView;
        localObject1 = ((StringBuilder)localObject1).toString();
        paramViewGroup = paramView;
        localDelDownloadHolder.b.setImageResource(2130841341);
        paramViewGroup = paramView;
        paramView.setBackgroundColor(this.b.getResources().getColor(2131168464));
        paramViewGroup = paramView;
        localDelDownloadHolder.c.setVisibility(0);
        paramViewGroup = paramView;
        paramView.setOnLongClickListener(null);
      }
      else
      {
        paramViewGroup = paramView;
        localDelDownloadHolder.c.setVisibility(4);
        paramViewGroup = paramView;
        localDelDownloadHolder.b.setImageResource(2130847332);
        localObject1 = localObject2;
      }
      paramViewGroup = paramView;
      localDelDownloadHolder.a.setContentDescription((CharSequence)localObject1);
      return paramView;
    }
    catch (Exception paramView)
    {
      paramView.printStackTrace();
      QLog.e("#######", 1, paramView.toString());
    }
    return paramViewGroup;
  }
  
  public void configHeaderView(View paramView, int paramInt)
  {
    super.configHeaderView(paramView, paramInt);
    QfileBaseExpandableListAdapter.QfileGroupTag localQfileGroupTag = (QfileBaseExpandableListAdapter.QfileGroupTag)paramView.getTag();
    if (localQfileGroupTag != null)
    {
      if (this.b.L() == 1)
      {
        localQfileGroupTag.c.setVisibility(8);
        paramView.setEnabled(false);
        return;
      }
      paramView.setEnabled(true);
      localQfileGroupTag.c.setVisibility(0);
    }
  }
  
  public View getGroupView(int paramInt, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = super.getGroupView(paramInt, paramBoolean, paramView, paramViewGroup);
    if (paramViewGroup != null) {
      paramView = (QfileBaseExpandableListAdapter.QfileGroupTag)paramViewGroup.getTag();
    } else {
      paramView = null;
    }
    if (paramView != null)
    {
      if (this.b.L() == 1)
      {
        paramView.c.setVisibility(8);
        paramViewGroup.setEnabled(false);
        onGroupExpanded(0);
        return paramViewGroup;
      }
      paramViewGroup.setEnabled(true);
      paramView.c.setVisibility(0);
    }
    return paramViewGroup;
  }
  
  public void onClick(View paramView)
  {
    int k = paramView.getId();
    DelDownloadHolder localDelDownloadHolder = (DelDownloadHolder)paramView.getTag();
    if (k == 2131430794)
    {
      if (FMDataCache.a(localDelDownloadHolder.g))
      {
        FMDataCache.c(localDelDownloadHolder.g);
        localDelDownloadHolder.b.setSelected(false);
        localDelDownloadHolder.b.setImageResource(2130847332);
        localDelDownloadHolder.c.setVisibility(4);
        if (this.f != null) {
          this.f.a(localDelDownloadHolder.g, false);
        }
      }
      else
      {
        FMDataCache.b(localDelDownloadHolder.g);
        localDelDownloadHolder.b.setSelected(true);
        localDelDownloadHolder.b.setImageResource(2130841341);
        localDelDownloadHolder.c.setVisibility(0);
        if (this.f != null) {
          this.f.a(localDelDownloadHolder.g, true);
        }
      }
      this.b.B();
    }
    else if (this.f != null)
    {
      ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).openFileBrowserByFileInfo(this.a, localDelDownloadHolder.g, this.j, this.f.a(localDelDownloadHolder.g), paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.delDownloadFile.QFileDelDownloadAdapter
 * JD-Core Version:    0.7.0.1
 */