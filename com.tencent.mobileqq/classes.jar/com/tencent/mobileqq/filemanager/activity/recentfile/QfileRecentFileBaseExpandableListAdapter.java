package com.tencent.mobileqq.filemanager.activity.recentfile;

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
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileBaseExpandableListAdapter;
import com.tencent.mobileqq.filemanager.activity.adapter.RecentItemHolder;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.CircleFileStateView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

public class QfileRecentFileBaseExpandableListAdapter
  extends QfileBaseExpandableListAdapter
{
  private Context a;
  private BaseFileAssistantActivity b;
  private LayoutInflater c;
  private View.OnClickListener d;
  private View.OnClickListener i;
  private View.OnLongClickListener j;
  private View.OnClickListener k;
  private HashMap<Integer, ArrayList<QfileRecentFileBaseExpandableListAdapter.PosInfo>> l = new HashMap();
  
  public QfileRecentFileBaseExpandableListAdapter(Context paramContext, LinkedHashMap<String, List<FileManagerEntity>> paramLinkedHashMap, BaseFileAssistantActivity paramBaseFileAssistantActivity, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2, View.OnLongClickListener paramOnLongClickListener, View.OnClickListener paramOnClickListener3)
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
  
  private void a(FileManagerEntity paramFileManagerEntity, RecentItemHolder paramRecentItemHolder)
  {
    switch (paramFileManagerEntity.status)
    {
    case 17: 
    default: 
      paramRecentItemHolder.c.setVisibility(4);
      return;
    case 16: 
      paramRecentItemHolder.c.setVisibility(4);
      return;
    case 14: 
    case 15: 
      paramRecentItemHolder.c.setVisibility(4);
      return;
    case 13: 
      paramRecentItemHolder.c.setVisibility(0);
      paramRecentItemHolder.c.setState(2);
      paramRecentItemHolder.d = 1;
      return;
    case 10: 
    case 11: 
      paramRecentItemHolder.c.setVisibility(4);
      return;
    case 9: 
    case 12: 
      paramRecentItemHolder.c.setVisibility(4);
      return;
    case 5: 
    case 6: 
    case 7: 
    case 8: 
      paramRecentItemHolder.c.setVisibility(4);
      return;
    case 4: 
      paramRecentItemHolder.d = 1;
      paramRecentItemHolder.c.setVisibility(0);
      paramRecentItemHolder.c.setState(2);
      return;
    case 3: 
      a(paramFileManagerEntity, paramRecentItemHolder, ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).isFileExists(paramFileManagerEntity.getFilePath()));
      return;
    case 2: 
    case 18: 
      paramRecentItemHolder.c.setVisibility(0);
      paramRecentItemHolder.c.setState(1);
      paramRecentItemHolder.d = 2;
      return;
    case 1: 
      b(paramFileManagerEntity, paramRecentItemHolder, ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).isFileExists(paramFileManagerEntity.getFilePath()));
      return;
    case 0: 
      paramRecentItemHolder.c.setVisibility(0);
      paramRecentItemHolder.d = 3;
      boolean bool = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).isFileExists(paramFileManagerEntity.getFilePath());
      if ((paramFileManagerEntity.bSend) && (bool))
      {
        paramRecentItemHolder.c.setState(3);
        return;
      }
      paramRecentItemHolder.c.setState(2);
      return;
    }
    paramRecentItemHolder.c.setVisibility(0);
    paramRecentItemHolder.d = 1;
    paramRecentItemHolder.c.setState(2);
  }
  
  private void a(FileManagerEntity paramFileManagerEntity, RecentItemHolder paramRecentItemHolder, boolean paramBoolean)
  {
    if ((paramFileManagerEntity.bSend) && (paramBoolean)) {
      paramRecentItemHolder.c.setState(3);
    } else {
      paramRecentItemHolder.c.setState(2);
    }
    paramRecentItemHolder.c.setVisibility(0);
    paramRecentItemHolder.d = 3;
  }
  
  private void b(FileManagerEntity paramFileManagerEntity, RecentItemHolder paramRecentItemHolder, boolean paramBoolean)
  {
    if ((paramFileManagerEntity.getCloudType() != 3) && (paramFileManagerEntity.getCloudType() != 5) && (!paramBoolean))
    {
      paramRecentItemHolder.c.setVisibility(0);
      paramRecentItemHolder.c.setState(2);
      paramRecentItemHolder.d = 1;
      return;
    }
    paramRecentItemHolder.c.setVisibility(4);
  }
  
  public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1;
    Object localObject3;
    Object localObject2;
    if (this.b.D())
    {
      localObject1 = (ArrayList)this.l.get(Integer.valueOf(paramInt1));
      if (localObject1 != null)
      {
        localObject3 = ((ArrayList)localObject1).iterator();
        localObject2 = null;
        for (;;)
        {
          localObject1 = localObject2;
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
          localObject1 = (QfileRecentFileBaseExpandableListAdapter.PosInfo)((Iterator)localObject3).next();
          if (((QfileRecentFileBaseExpandableListAdapter.PosInfo)localObject1).a == paramInt2) {
            localObject2 = (FileManagerEntity)getChild(paramInt1, ((QfileRecentFileBaseExpandableListAdapter.PosInfo)localObject1).b);
          }
        }
      }
      localObject1 = null;
    }
    else
    {
      localObject1 = (FileManagerEntity)getChild(paramInt1, paramInt2);
    }
    if (localObject1 == null) {
      return paramView;
    }
    if (paramView == null) {
      localObject2 = paramView;
    }
    try
    {
      localObject3 = new RecentItemHolder();
      localObject2 = paramView;
      paramView = this.c.inflate(2131627036, paramViewGroup, false);
      localObject2 = paramView;
      ((RecentItemHolder)localObject3).a = ((RelativeLayout)paramView.findViewById(2131444373));
      localObject2 = paramView;
      ((RecentItemHolder)localObject3).a.setOnLongClickListener(this.j);
      localObject2 = paramView;
      ((RecentItemHolder)localObject3).a.setTag(localObject3);
      localObject2 = paramView;
      ((RecentItemHolder)localObject3).b = paramView.findViewById(2131437978);
      localObject2 = paramView;
      ((RecentItemHolder)localObject3).c = ((CircleFileStateView)paramView.findViewById(2131427503));
      localObject2 = paramView;
      ((RecentItemHolder)localObject3).e = ((CheckBox)paramView.findViewById(2131433116));
      localObject2 = paramView;
      ((RecentItemHolder)localObject3).f = ((AsyncImageView)paramView.findViewById(2131433103));
      localObject2 = paramView;
      ((RecentItemHolder)localObject3).f.setTag(localObject3);
      localObject2 = paramView;
      ((RecentItemHolder)localObject3).g = ((TextView)paramView.findViewById(2131433114));
      localObject2 = paramView;
      ((RecentItemHolder)localObject3).g.setGravity(48);
      localObject2 = paramView;
      ((RecentItemHolder)localObject3).g.setMaxLines(2);
      localObject2 = paramView;
      ((RecentItemHolder)localObject3).h = ((TextView)paramView.findViewById(2131433101));
      localObject2 = paramView;
      int m = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).dp2px(70, this.a.getResources());
      localObject2 = paramView;
      ((RecentItemHolder)localObject3).f.setAsyncClipSize(m, m);
      localObject2 = paramView;
      paramView.setTag(localObject3);
      paramViewGroup = (ViewGroup)localObject3;
      break label432;
      localObject2 = paramView;
      paramViewGroup = (RecentItemHolder)paramView.getTag();
      label432:
      localObject2 = paramView;
      QQFileManagerUtil.b(paramViewGroup.f, (FileManagerEntity)localObject1);
      localObject2 = paramView;
      paramViewGroup.j = paramInt1;
      localObject2 = paramView;
      paramViewGroup.k = paramInt2;
      localObject2 = paramView;
      paramViewGroup.a.setVisibility(0);
      localObject2 = paramView;
      if (QQFileManagerUtil.a(this.a, (FileManagerEntity)localObject1))
      {
        localObject2 = paramView;
        paramViewGroup.b.setVisibility(0);
        localObject2 = paramView;
        paramViewGroup.a.setOnClickListener(null);
      }
      else
      {
        localObject2 = paramView;
        paramViewGroup.b.setVisibility(8);
        localObject2 = paramView;
        paramViewGroup.a.setOnClickListener(this.i);
        localObject2 = paramView;
        paramViewGroup.f.setOnClickListener(this.i);
      }
      localObject2 = paramView;
      paramViewGroup.i = localObject1;
      localObject2 = paramView;
      paramViewGroup.c.setOnClickListener(this.k);
      localObject2 = paramView;
      paramViewGroup.c.setTag(paramViewGroup);
      localObject2 = paramView;
      paramViewGroup.c.setProgressRingWidth(3.0F);
      localObject2 = paramView;
      paramViewGroup.g.setText(((FileManagerEntity)localObject1).fileName);
      localObject2 = paramView;
      paramViewGroup.c.setProgress((int)(((FileManagerEntity)localObject1).fProgress * 100.0F));
      localObject2 = paramView;
      if (5 != ((FileManagerEntity)localObject1).cloudType)
      {
        localObject2 = paramView;
        QQFileManagerUtil.j((FileManagerEntity)localObject1);
      }
      localObject2 = paramView;
      paramViewGroup.c.setEnabled(true);
      localObject2 = paramView;
      a((FileManagerEntity)localObject1, paramViewGroup);
      localObject2 = paramView;
      if (this.b.D())
      {
        localObject2 = paramView;
        paramViewGroup.c.setVisibility(8);
        localObject2 = paramView;
        paramViewGroup.e.setVisibility(0);
        localObject2 = paramView;
        paramViewGroup.e.setChecked(FMDataCache.a((FileManagerEntity)localObject1));
      }
      else
      {
        localObject2 = paramView;
        paramViewGroup.e.setVisibility(8);
      }
      localObject2 = paramView;
      if (((FileManagerEntity)localObject1).nFileType == 13)
      {
        localObject2 = paramView;
        paramViewGroup.c.setVisibility(8);
      }
      localObject2 = paramView;
      localObject3 = (LinearLayout.LayoutParams)paramViewGroup.h.getLayoutParams();
      localObject2 = paramView;
      ((LinearLayout.LayoutParams)localObject3).topMargin = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).dp2px(3, this.a.getResources());
      localObject2 = paramView;
      paramViewGroup.h.setLineSpacing(TypedValue.applyDimension(1, 0.8F, this.a.getResources().getDisplayMetrics()), 1.0F);
      localObject2 = paramView;
      paramViewGroup.h.setLayoutParams((ViewGroup.LayoutParams)localObject3);
      localObject2 = paramView;
      paramViewGroup.g.setLineSpacing(TypedValue.applyDimension(1, 0.25F, this.a.getResources().getDisplayMetrics()), 1.0F);
      localObject2 = paramView;
      QQFileManagerUtil.a(paramViewGroup.h, (FileManagerEntity)localObject1);
      return paramView;
    }
    catch (Exception paramView)
    {
      paramView.printStackTrace();
    }
    return localObject2;
  }
  
  public int getChildrenCount(int paramInt)
  {
    Object localObject1 = a(paramInt);
    int n = 0;
    if (localObject1 != null)
    {
      if (!this.l.containsKey(Integer.valueOf(paramInt))) {
        this.l.put(Integer.valueOf(paramInt), new ArrayList());
      }
      localObject1 = (ArrayList)localObject1;
      if (this.b.D())
      {
        ArrayList localArrayList = new ArrayList();
        Iterator localIterator = ((ArrayList)localObject1).iterator();
        int m = 0;
        while (localIterator.hasNext())
        {
          Object localObject2 = (FileManagerEntity)localIterator.next();
          if ((((FileManagerEntity)localObject2).getCloudType() != 0) && ((((FileManagerEntity)localObject2).getCloudType() != 5) || (((FileManagerEntity)localObject2).bSend) || (((FileManagerEntity)localObject2).status == 1)) && (!((FileManagerEntity)localObject2).sendCloudUnsuccessful()))
          {
            localObject2 = new QfileRecentFileBaseExpandableListAdapter.PosInfo(this);
            ((QfileRecentFileBaseExpandableListAdapter.PosInfo)localObject2).a = m;
            ((QfileRecentFileBaseExpandableListAdapter.PosInfo)localObject2).b = (m + n);
            localArrayList.add(localObject2);
            m += 1;
          }
          else
          {
            n += 1;
          }
        }
        this.l.put(Integer.valueOf(paramInt), localArrayList);
        return ((ArrayList)localObject1).size() - n;
      }
      this.l.clear();
      return ((ArrayList)localObject1).size();
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.recentfile.QfileRecentFileBaseExpandableListAdapter
 * JD-Core Version:    0.7.0.1
 */