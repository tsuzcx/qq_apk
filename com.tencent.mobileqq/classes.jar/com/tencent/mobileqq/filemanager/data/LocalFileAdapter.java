package com.tencent.mobileqq.filemanager.data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.activity.LocalFileBrowserActivity;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.widget.EllipsizingTextView;
import com.tencent.mobileqq.widget.CircleFileStateView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class LocalFileAdapter
  extends BaseLocalFileAdapter
{
  private List<FileInfo> a;
  private Context b;
  private LayoutInflater c;
  private LocalFileBrowserActivity d = null;
  private final int e = -1;
  private final int f = 1;
  
  public LocalFileAdapter(Context paramContext, List<FileInfo> paramList, LocalFileBrowserActivity paramLocalFileBrowserActivity)
  {
    super(paramContext);
    this.b = paramContext;
    this.a = paramList;
    this.c = LayoutInflater.from(this.b);
    this.d = paramLocalFileBrowserActivity;
  }
  
  private View a(FileInfo paramFileInfo, ViewGroup paramViewGroup)
  {
    LocalFileAdapter.LocalFileItemHolder localLocalFileItemHolder = new LocalFileAdapter.LocalFileItemHolder(this);
    if (!paramFileInfo.k())
    {
      paramFileInfo = this.c.inflate(2131627036, paramViewGroup, false);
      localLocalFileItemHolder.a = ((RelativeLayout)paramFileInfo);
      localLocalFileItemHolder.a.setOnClickListener(this.d.Z);
      localLocalFileItemHolder.a.setOnLongClickListener(this.d.Y);
      localLocalFileItemHolder.a.setTag(localLocalFileItemHolder);
      localLocalFileItemHolder.b = ((CheckBox)paramFileInfo.findViewById(2131433116));
      localLocalFileItemHolder.c = ((AsyncImageView)paramFileInfo.findViewById(2131433103));
      localLocalFileItemHolder.c.setOnClickListener(this.d.Z);
      localLocalFileItemHolder.c.setTag(localLocalFileItemHolder);
      localLocalFileItemHolder.d = ((ImageView)paramFileInfo.findViewById(2131444785));
      localLocalFileItemHolder.e = ((TextView)paramFileInfo.findViewById(2131433114));
      localLocalFileItemHolder.e.setMaxLines(2);
      localLocalFileItemHolder.f = ((TextView)paramFileInfo.findViewById(2131433117));
      localLocalFileItemHolder.g = ((TextView)paramFileInfo.findViewById(2131433101));
      localLocalFileItemHolder.h = ((TextView)paramFileInfo.findViewById(2131436844));
      localLocalFileItemHolder.i = ((CircleFileStateView)paramFileInfo.findViewById(2131427503));
      localLocalFileItemHolder.i.setOnClickListener(this.d.Z);
    }
    else
    {
      paramFileInfo = this.c.inflate(2131627044, paramViewGroup, false);
      paramFileInfo.setOnClickListener(this.d.Z);
      localLocalFileItemHolder.c = ((AsyncImageView)paramFileInfo.findViewById(2131433129));
      localLocalFileItemHolder.d = ((ImageView)paramFileInfo.findViewById(2131444798));
      localLocalFileItemHolder.e = ((EllipsizingTextView)paramFileInfo.findViewById(2131433133));
    }
    paramFileInfo.setTag(localLocalFileItemHolder);
    return paramFileInfo;
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
    if (((FileInfo)this.a.get(paramInt)).k()) {
      return -1;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    FileInfo localFileInfo = (FileInfo)this.a.get(paramInt);
    View localView1;
    View localView2;
    if (localFileInfo == null)
    {
      localView1 = null;
    }
    else
    {
      localView1 = paramView;
      if (paramView == null) {}
      try
      {
        localView1 = a(localFileInfo, paramViewGroup);
        paramView = localView1;
        LocalFileAdapter.LocalFileItemHolder localLocalFileItemHolder = (LocalFileAdapter.LocalFileItemHolder)localView1.getTag();
        paramView = localView1;
        localLocalFileItemHolder.j = localFileInfo;
        paramView = localView1;
        if (localFileInfo.k())
        {
          paramView = localView1;
          localLocalFileItemHolder.c.setDefaultImage(2130845656);
          paramView = localView1;
          localLocalFileItemHolder.d.setVisibility(0);
          paramView = localView1;
          localLocalFileItemHolder.e.setText(localFileInfo.e());
          paramView = localView1;
          localLocalFileItemHolder.k = paramInt;
        }
        else
        {
          paramView = localView1;
          localLocalFileItemHolder.d.setVisibility(8);
          paramView = localView1;
          QQFileManagerUtil.a(localLocalFileItemHolder.c, localFileInfo.d(), QQFileManagerUtil.k(localFileInfo.d()));
          paramView = localView1;
          localLocalFileItemHolder.e.setText(localFileInfo.e());
          paramView = localView1;
          if (this.d.D())
          {
            paramView = localView1;
            localLocalFileItemHolder.b.setVisibility(0);
            paramView = localView1;
            localLocalFileItemHolder.b.setChecked(FMDataCache.a(localFileInfo));
          }
          else
          {
            paramView = localView1;
            localLocalFileItemHolder.b.setVisibility(8);
          }
          paramView = localView1;
          String str1 = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).formatNewRefreshTime(localFileInfo.g());
          paramView = localView1;
          String str2 = this.d.getString(2131889334);
          paramView = localView1;
          TextView localTextView = localLocalFileItemHolder.g;
          paramView = localView1;
          StringBuilder localStringBuilder = new StringBuilder();
          paramView = localView1;
          localStringBuilder.append(str1);
          paramView = localView1;
          localStringBuilder.append(str2);
          paramView = localView1;
          localStringBuilder.append(FileUtil.a(localFileInfo.f()));
          paramView = localView1;
          localTextView.setText(localStringBuilder.toString());
          paramView = localView1;
          localLocalFileItemHolder.k = paramInt;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        localView2 = paramView;
      }
      paramView = localView2;
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return localView2;
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.LocalFileAdapter
 * JD-Core Version:    0.7.0.1
 */