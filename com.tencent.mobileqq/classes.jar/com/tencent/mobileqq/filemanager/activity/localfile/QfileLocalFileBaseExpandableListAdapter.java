package com.tencent.mobileqq.filemanager.activity.localfile;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils.TruncateAt;
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
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileBaseExpandableListAdapter;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileBaseExpandableListAdapter.IQfileViewBinder;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileBaseExpandableListAdapter.QfileGroupTag;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.CircleFileStateView;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class QfileLocalFileBaseExpandableListAdapter
  extends QfileBaseExpandableListAdapter
{
  private Context a;
  private BaseFileAssistantActivity b;
  private LayoutInflater c;
  private View.OnClickListener d;
  private View.OnClickListener i;
  private View.OnLongClickListener j;
  private View.OnClickListener k;
  private HashMap<Integer, Bitmap> l;
  private boolean m = false;
  private View.OnClickListener n = null;
  
  public QfileLocalFileBaseExpandableListAdapter(Context paramContext, LinkedHashMap<String, List<FileInfo>> paramLinkedHashMap, BaseFileAssistantActivity paramBaseFileAssistantActivity, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2, View.OnLongClickListener paramOnLongClickListener, View.OnClickListener paramOnClickListener3)
  {
    super(paramContext, paramLinkedHashMap);
    if (paramBaseFileAssistantActivity.L() != -1)
    {
      this.m = true;
      a();
    }
    this.l = new HashMap();
    this.d = paramOnClickListener1;
    this.i = paramOnClickListener2;
    this.j = paramOnLongClickListener;
    this.k = paramOnClickListener3;
    this.a = paramContext;
    this.b = paramBaseFileAssistantActivity;
    this.c = LayoutInflater.from(this.a);
  }
  
  private String a(FileInfo paramFileInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).formatNewRefreshTime(paramFileInfo.g()));
    localStringBuilder.append("  ");
    if (this.b.K())
    {
      localStringBuilder.append("来自微信");
      localStringBuilder.append("  ");
    }
    localStringBuilder.append(FileUtil.a(paramFileInfo.f()));
    return localStringBuilder.toString();
  }
  
  private void a()
  {
    if (this.n == null) {
      this.n = new QfileLocalFileBaseExpandableListAdapter.1(this);
    }
  }
  
  private void a(String paramString, int paramInt1, int paramInt2, int paramInt3, QfileLocalFileBaseExpandableListAdapter.LocalItemHolder paramLocalItemHolder)
  {
    int i1 = paramString.hashCode();
    if (this.l.containsKey(Integer.valueOf(i1)) == true)
    {
      paramLocalItemHolder.g.setAsyncClipSize(paramInt2, paramInt3);
      paramLocalItemHolder.g.setImageBitmap((Bitmap)this.l.get(Integer.valueOf(i1)));
      return;
    }
    if (paramInt1 != 0)
    {
      if (paramInt1 != 2)
      {
        if (paramInt1 != 5)
        {
          paramLocalItemHolder.g.setAsyncClipSize(paramInt2, paramInt3);
          paramLocalItemHolder.g.setImageResource(QQFileManagerUtil.d(paramInt1));
          return;
        }
        paramLocalItemHolder.g.setAsyncClipSize(paramInt2, paramInt3);
        paramLocalItemHolder.g.setDefaultImage(2130845642);
        if (FileUtils.fileExistsAndNotEmpty(paramString)) {
          paramLocalItemHolder.g.setApkIconAsyncImage(paramString);
        }
      }
      else
      {
        paramLocalItemHolder.g.setAsyncClipSize(paramInt2, paramInt3);
        paramLocalItemHolder.g.setDefaultImage(2130845756);
        paramLocalItemHolder.g.setAsyncImage(paramString);
      }
    }
    else
    {
      paramLocalItemHolder.g.setAsyncClipSize(paramInt2, paramInt3);
      paramLocalItemHolder.g.setDefaultImage(2130845680);
      paramLocalItemHolder.g.setAsyncImage(paramString);
    }
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
  
  public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    if (QLog.isDevelopLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("groupPosition[");
      ((StringBuilder)localObject1).append(paramInt1);
      ((StringBuilder)localObject1).append("],childPosition[");
      ((StringBuilder)localObject1).append(paramInt2);
      ((StringBuilder)localObject1).append("]");
      QLog.d("QfileLocalFileBaseExpandableListAdapter", 4, ((StringBuilder)localObject1).toString());
    }
    if ((paramInt1 == 5) && (paramInt2 == 0) && (QLog.isDevelopLevel())) {
      QLog.d("QfileLocalFileBaseExpandableListAdapter", 4, "ready crash!");
    }
    FileInfo localFileInfo = (FileInfo)getChild(paramInt1, paramInt2);
    if (paramView == null) {
      localObject1 = paramView;
    }
    try
    {
      localObject2 = new QfileLocalFileBaseExpandableListAdapter.LocalItemHolder(this);
      localObject1 = paramView;
      paramView = this.c.inflate(2131627036, paramViewGroup, false);
      localObject1 = paramView;
      ((QfileLocalFileBaseExpandableListAdapter.LocalItemHolder)localObject2).c = ((RelativeLayout)paramView.findViewById(2131444373));
      localObject1 = paramView;
      ((QfileLocalFileBaseExpandableListAdapter.LocalItemHolder)localObject2).c.setOnClickListener(this.i);
      localObject1 = paramView;
      ((QfileLocalFileBaseExpandableListAdapter.LocalItemHolder)localObject2).c.setOnLongClickListener(this.j);
      localObject1 = paramView;
      ((QfileLocalFileBaseExpandableListAdapter.LocalItemHolder)localObject2).c.setTag(localObject2);
      localObject1 = paramView;
      ((QfileLocalFileBaseExpandableListAdapter.LocalItemHolder)localObject2).d = ((CircleFileStateView)paramView.findViewById(2131427503));
      localObject1 = paramView;
      ((QfileLocalFileBaseExpandableListAdapter.LocalItemHolder)localObject2).f = ((CheckBox)paramView.findViewById(2131433116));
      localObject1 = paramView;
      ((QfileLocalFileBaseExpandableListAdapter.LocalItemHolder)localObject2).g = ((AsyncImageView)paramView.findViewById(2131433103));
      localObject1 = paramView;
      ((QfileLocalFileBaseExpandableListAdapter.LocalItemHolder)localObject2).g.setOnClickListener(this.i);
      localObject1 = paramView;
      ((QfileLocalFileBaseExpandableListAdapter.LocalItemHolder)localObject2).g.setTag(localObject2);
      localObject1 = paramView;
      ((QfileLocalFileBaseExpandableListAdapter.LocalItemHolder)localObject2).h = ((TextView)paramView.findViewById(2131433114));
      localObject1 = paramView;
      ((QfileLocalFileBaseExpandableListAdapter.LocalItemHolder)localObject2).h.setGravity(48);
      localObject1 = paramView;
      ((QfileLocalFileBaseExpandableListAdapter.LocalItemHolder)localObject2).h.setMaxLines(2);
      localObject1 = paramView;
      ((QfileLocalFileBaseExpandableListAdapter.LocalItemHolder)localObject2).i = ((TextView)paramView.findViewById(2131433101));
      localObject1 = paramView;
      int i1 = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).dp2px(70, this.a.getResources());
      localObject1 = paramView;
      ((QfileLocalFileBaseExpandableListAdapter.LocalItemHolder)localObject2).g.setAsyncClipSize(i1, i1);
      localObject1 = paramView;
      paramView.setTag(localObject2);
      paramViewGroup = (ViewGroup)localObject2;
    }
    catch (Exception paramView)
    {
      Object localObject2;
      paramView.printStackTrace();
      return localObject1;
    }
    Object localObject1 = paramView;
    paramViewGroup = (QfileLocalFileBaseExpandableListAdapter.LocalItemHolder)paramView.getTag();
    while (localFileInfo != null)
    {
      localObject1 = paramView;
      paramViewGroup.b = paramInt1;
      localObject1 = paramView;
      paramViewGroup.a = paramInt2;
      localObject1 = paramView;
      localFileInfo.a((String)getGroup(paramInt1));
      localObject1 = paramView;
      paramViewGroup.j = localFileInfo;
      localObject1 = paramView;
      paramViewGroup.d.setOnClickListener(this.k);
      localObject1 = paramView;
      paramViewGroup.d.setTag(paramViewGroup);
      localObject1 = paramView;
      if (this.m)
      {
        localObject1 = paramView;
        paramViewGroup.g.setTag(paramViewGroup);
        localObject1 = paramView;
        paramViewGroup.g.setOnClickListener(this.n);
      }
      localObject1 = paramView;
      paramInt1 = paramViewGroup.g.getHeight();
      localObject1 = paramView;
      paramInt2 = paramViewGroup.g.getWidth();
      localObject1 = paramView;
      localObject2 = localFileInfo.d();
      localObject1 = paramView;
      if (this.f != null)
      {
        localObject1 = paramView;
        localObject2 = this.f.a(localFileInfo);
      }
      localObject1 = paramView;
      a((String)localObject2, QQFileManagerUtil.k((String)localObject2), paramInt2, paramInt1, paramViewGroup);
      localObject1 = paramView;
      paramViewGroup.h.setEllipsize(TextUtils.TruncateAt.MIDDLE);
      localObject1 = paramView;
      localObject2 = localFileInfo.e();
      localObject1 = paramView;
      paramViewGroup.h.setText((CharSequence)localObject2);
      localObject1 = paramView;
      paramViewGroup.h.setVisibility(0);
      localObject1 = paramView;
      paramViewGroup.i.setText(a(localFileInfo));
      localObject1 = paramView;
      paramViewGroup.d.setVisibility(4);
      localObject1 = paramView;
      paramViewGroup.e = 0;
      localObject1 = paramView;
      if (this.b.D())
      {
        localObject1 = paramView;
        paramViewGroup.d.setVisibility(8);
        localObject1 = paramView;
        paramViewGroup.f.setVisibility(8);
        localObject1 = paramView;
        paramViewGroup.f.setVisibility(0);
        localObject1 = paramView;
        paramViewGroup.f.setChecked(FMDataCache.a(localFileInfo));
      }
      else
      {
        localObject1 = paramView;
        paramViewGroup.f.setVisibility(8);
      }
      localObject1 = paramView;
      localObject2 = (LinearLayout.LayoutParams)paramViewGroup.i.getLayoutParams();
      localObject1 = paramView;
      ((LinearLayout.LayoutParams)localObject2).topMargin = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).dp2px(3, this.a.getResources());
      localObject1 = paramView;
      paramViewGroup.i.setLineSpacing(TypedValue.applyDimension(1, 0.8F, this.a.getResources().getDisplayMetrics()), 1.0F);
      localObject1 = paramView;
      paramViewGroup.i.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject1 = paramView;
      paramViewGroup.h.setLineSpacing(TypedValue.applyDimension(1, 0.25F, this.a.getResources().getDisplayMetrics()), 1.0F);
      return paramView;
    }
    return paramView;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileBaseExpandableListAdapter
 * JD-Core Version:    0.7.0.1
 */