package com.tencent.mobileqq.filemanager.activity.cloudfile;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileBaseExpandableListAdapter;
import com.tencent.mobileqq.filemanager.api.IQQFileDataCenter;
import com.tencent.mobileqq.filemanager.api.IQQFileEngine;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.CircleFileStateView;
import java.util.LinkedHashMap;
import java.util.List;

public class QfileCloudFileBaseExpandableListAdapter
  extends QfileBaseExpandableListAdapter
{
  private Context a;
  private BaseFileAssistantActivity b;
  private LayoutInflater c;
  private View.OnClickListener d;
  private View.OnClickListener i;
  private View.OnLongClickListener j;
  private View.OnClickListener k;
  
  public QfileCloudFileBaseExpandableListAdapter(Context paramContext, LinkedHashMap<String, List<WeiYunFileInfo>> paramLinkedHashMap, BaseFileAssistantActivity paramBaseFileAssistantActivity, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2, View.OnLongClickListener paramOnLongClickListener, View.OnClickListener paramOnClickListener3)
  {
    super(paramContext, paramLinkedHashMap);
    this.d = paramOnClickListener1;
    this.i = paramOnClickListener2;
    this.j = paramOnLongClickListener;
    this.k = paramOnClickListener3;
    this.a = paramContext;
    this.b = paramBaseFileAssistantActivity;
    this.c = LayoutInflater.from(this.a);
  }
  
  private String a(WeiYunFileInfo paramWeiYunFileInfo)
  {
    return FileUtil.a(paramWeiYunFileInfo.d);
  }
  
  private String a(String paramString1, String paramString2)
  {
    if (paramString2 != null)
    {
      if (paramString2.equalsIgnoreCase("")) {
        return "";
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append(paramString2);
      return localStringBuilder.toString();
    }
    return "";
  }
  
  private void a(AsyncImageView paramAsyncImageView, String paramString)
  {
    paramAsyncImageView.setDefaultImage(2130845680);
    paramAsyncImageView.setAsyncImage(paramString);
  }
  
  public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    WeiYunFileInfo localWeiYunFileInfo = (WeiYunFileInfo)getChild(paramInt1, paramInt2);
    if (localWeiYunFileInfo == null) {
      return paramView;
    }
    View localView;
    if (paramView == null) {
      localView = paramView;
    }
    try
    {
      Object localObject1 = new QfileCloudFileBaseExpandableListAdapter.CloudItemHolder(this);
      localView = paramView;
      paramView = this.c.inflate(2131627036, paramViewGroup, false);
      localView = paramView;
      ((QfileCloudFileBaseExpandableListAdapter.CloudItemHolder)localObject1).c = ((RelativeLayout)paramView.findViewById(2131444373));
      localView = paramView;
      ((QfileCloudFileBaseExpandableListAdapter.CloudItemHolder)localObject1).c.setOnClickListener(this.i);
      localView = paramView;
      ((QfileCloudFileBaseExpandableListAdapter.CloudItemHolder)localObject1).c.setOnLongClickListener(this.j);
      localView = paramView;
      ((QfileCloudFileBaseExpandableListAdapter.CloudItemHolder)localObject1).c.setTag(localObject1);
      localView = paramView;
      ((QfileCloudFileBaseExpandableListAdapter.CloudItemHolder)localObject1).d = ((CircleFileStateView)paramView.findViewById(2131427503));
      localView = paramView;
      ((QfileCloudFileBaseExpandableListAdapter.CloudItemHolder)localObject1).f = ((CheckBox)paramView.findViewById(2131433116));
      localView = paramView;
      ((QfileCloudFileBaseExpandableListAdapter.CloudItemHolder)localObject1).g = ((AsyncImageView)paramView.findViewById(2131433103));
      localView = paramView;
      ((QfileCloudFileBaseExpandableListAdapter.CloudItemHolder)localObject1).g.setOnClickListener(this.i);
      localView = paramView;
      ((QfileCloudFileBaseExpandableListAdapter.CloudItemHolder)localObject1).g.setTag(localObject1);
      localView = paramView;
      ((QfileCloudFileBaseExpandableListAdapter.CloudItemHolder)localObject1).h = ((TextView)paramView.findViewById(2131433114));
      localView = paramView;
      ((QfileCloudFileBaseExpandableListAdapter.CloudItemHolder)localObject1).h.setGravity(48);
      localView = paramView;
      ((QfileCloudFileBaseExpandableListAdapter.CloudItemHolder)localObject1).h.setMaxLines(2);
      localView = paramView;
      ((QfileCloudFileBaseExpandableListAdapter.CloudItemHolder)localObject1).i = ((TextView)paramView.findViewById(2131433101));
      localView = paramView;
      ((QfileCloudFileBaseExpandableListAdapter.CloudItemHolder)localObject1).j = ((TextView)paramView.findViewById(2131436844));
      localView = paramView;
      int m = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).dp2px(70, this.a.getResources());
      localView = paramView;
      ((QfileCloudFileBaseExpandableListAdapter.CloudItemHolder)localObject1).g.setAsyncClipSize(m, m);
      localView = paramView;
      paramView.setTag(localObject1);
      paramViewGroup = (ViewGroup)localObject1;
      break label368;
      localView = paramView;
      paramViewGroup = (QfileCloudFileBaseExpandableListAdapter.CloudItemHolder)paramView.getTag();
      label368:
      localView = paramView;
      m = QQFileManagerUtil.k(localWeiYunFileInfo.c);
      localView = paramView;
      QQFileManagerUtil.a(paramViewGroup.g, localWeiYunFileInfo.l, m);
      localView = paramView;
      paramViewGroup.b = paramInt1;
      localView = paramView;
      paramViewGroup.a = paramInt2;
      localView = paramView;
      paramViewGroup.k = localWeiYunFileInfo;
      localView = paramView;
      paramViewGroup.d.setOnClickListener(this.k);
      localView = paramView;
      paramViewGroup.d.setState(2);
      localView = paramView;
      paramViewGroup.d.setTag(paramViewGroup);
      localView = paramView;
      paramViewGroup.e = 1;
      localView = paramView;
      if (QQFileManagerUtil.k(localWeiYunFileInfo.c) == 0)
      {
        localView = paramView;
        if (FileUtils.fileExistsAndNotEmpty(localWeiYunFileInfo.l))
        {
          localView = paramView;
          a(paramViewGroup.g, localWeiYunFileInfo.l);
        }
      }
      localView = paramView;
      paramViewGroup.h.setText(localWeiYunFileInfo.c);
      localView = paramView;
      paramViewGroup.i.setText(a(localWeiYunFileInfo));
      localView = paramView;
      localObject1 = this.b.getString(2131889363);
      localView = paramView;
      Object localObject2 = this.b.getString(2131889334);
      localView = paramView;
      Object localObject3 = new StringBuilder();
      localView = paramView;
      ((StringBuilder)localObject3).append(((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).formatNewRefreshTime(localWeiYunFileInfo.e));
      localView = paramView;
      ((StringBuilder)localObject3).append(a((String)localObject2, (String)localObject1));
      localView = paramView;
      localObject1 = ((StringBuilder)localObject3).toString();
      localView = paramView;
      paramViewGroup.j.setText((CharSequence)localObject1);
      localView = paramView;
      localObject3 = this.b.h();
      localView = paramView;
      localObject2 = ((IQQFileEngine)((BaseQQAppInterface)localObject3).getRuntimeService(IQQFileEngine.class)).queryFileEntityByFileId(localWeiYunFileInfo.a);
      if (localObject2 != null)
      {
        localView = paramView;
        paramViewGroup.d.setVisibility(0);
        localView = paramView;
        paramViewGroup.d.setState(1);
        localView = paramView;
        paramViewGroup.d.setProgress((int)(((FileManagerEntity)localObject2).fProgress * 100.0F));
        localView = paramView;
        paramViewGroup.e = 2;
        localView = paramView;
        paramViewGroup.d.a(true);
      }
      else
      {
        localView = paramView;
        paramViewGroup.d.setVisibility(0);
        localView = paramView;
        paramViewGroup.d.a(false);
      }
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localView = paramView;
        localObject2 = ((IQQFileDataCenter)((BaseQQAppInterface)localObject3).getRuntimeService(IQQFileDataCenter.class)).queryByFileIdForMemory(localWeiYunFileInfo.a);
        localObject1 = localObject2;
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          localView = paramView;
          if (!FileUtils.fileExistsAndNotEmpty(((FileManagerEntity)localObject2).getFilePath()))
          {
            localView = paramView;
            ((FileManagerEntity)localObject2).setCloudType(2);
            localView = paramView;
            if (((FileManagerEntity)localObject2).getId() > 0L)
            {
              localView = paramView;
              ((FileManagerEntity)localObject2).nOpType = 5;
            }
            localObject1 = localObject2;
            localView = paramView;
            if (((FileManagerEntity)localObject2).status != 1)
            {
              localView = paramView;
              paramViewGroup.d.setProgress((int)(((FileManagerEntity)localObject2).fProgress * 100.0F));
              localView = paramView;
              paramViewGroup.d.a(true);
              localObject1 = localObject2;
            }
          }
        }
      }
      if (localObject1 != null)
      {
        localView = paramView;
        paramInt1 = ((FileManagerEntity)localObject1).status;
        if (paramInt1 != -1)
        {
          if (paramInt1 != 0) {
            if (paramInt1 != 1)
            {
              if (paramInt1 != 3) {
                break label1119;
              }
            }
            else
            {
              localView = paramView;
              paramViewGroup.d.setVisibility(4);
              localView = paramView;
              paramViewGroup.e = 0;
              break label1119;
            }
          }
          localView = paramView;
          paramViewGroup.d.setVisibility(0);
          localView = paramView;
          paramViewGroup.d.setState(2);
          localView = paramView;
          paramViewGroup.e = 3;
        }
        else
        {
          localView = paramView;
          paramViewGroup.d.setState(2);
          localView = paramView;
          paramViewGroup.d.setVisibility(0);
          localView = paramView;
          paramViewGroup.e = 1;
        }
      }
      label1119:
      localView = paramView;
      if (this.b.D())
      {
        localView = paramView;
        paramViewGroup.d.setVisibility(8);
        localView = paramView;
        paramViewGroup.f.setVisibility(0);
        localView = paramView;
        paramViewGroup.f.setChecked(FMDataCache.a(localWeiYunFileInfo));
      }
      else
      {
        localView = paramView;
        paramViewGroup.f.setVisibility(8);
      }
      localView = paramView;
      localObject1 = (LinearLayout.LayoutParams)paramViewGroup.i.getLayoutParams();
      localView = paramView;
      ((LinearLayout.LayoutParams)localObject1).topMargin = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).dp2px(3, this.a.getResources());
      localView = paramView;
      paramViewGroup.i.setLineSpacing(TypedValue.applyDimension(1, 0.8F, this.a.getResources().getDisplayMetrics()), 1.0F);
      localView = paramView;
      paramViewGroup.i.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localView = paramView;
      paramViewGroup.h.setLineSpacing(TypedValue.applyDimension(1, 0.25F, this.a.getResources().getDisplayMetrics()), 1.0F);
      return paramView;
    }
    catch (Exception paramView)
    {
      paramView.printStackTrace();
    }
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.cloudfile.QfileCloudFileBaseExpandableListAdapter
 * JD-Core Version:    0.7.0.1
 */