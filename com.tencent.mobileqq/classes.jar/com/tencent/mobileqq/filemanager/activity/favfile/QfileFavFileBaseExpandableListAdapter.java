package com.tencent.mobileqq.filemanager.activity.favfile;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
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
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.FavFileInfo;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.CircleFileStateView;
import java.util.LinkedHashMap;
import java.util.List;

public class QfileFavFileBaseExpandableListAdapter
  extends QfileBaseExpandableListAdapter
{
  protected BaseFileAssistantActivity a;
  private Context b;
  private LayoutInflater c;
  private View.OnClickListener d;
  private View.OnLongClickListener i;
  private View.OnClickListener j;
  private QfileFavFileBaseExpandableListAdapter.IAdapterCallBack k;
  
  public QfileFavFileBaseExpandableListAdapter(Context paramContext, LinkedHashMap<String, List<FavFileInfo>> paramLinkedHashMap, BaseFileAssistantActivity paramBaseFileAssistantActivity, View.OnClickListener paramOnClickListener1, View.OnLongClickListener paramOnLongClickListener, View.OnClickListener paramOnClickListener2, QfileFavFileBaseExpandableListAdapter.IAdapterCallBack paramIAdapterCallBack)
  {
    super(paramContext, paramLinkedHashMap);
    this.b = paramContext;
    this.a = paramBaseFileAssistantActivity;
    this.c = LayoutInflater.from(this.b);
    this.d = paramOnClickListener1;
    this.i = paramOnLongClickListener;
    this.j = paramOnClickListener2;
    this.k = paramIAdapterCallBack;
  }
  
  private String a(FavFileInfo paramFavFileInfo)
  {
    String str1 = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).formatNewRefreshTime(paramFavFileInfo.g);
    String str2 = FileUtil.a(paramFavFileInfo.f);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str1);
    localStringBuilder.append(" ");
    localStringBuilder.append(paramFavFileInfo.s);
    localStringBuilder.append(" ");
    localStringBuilder.append(str2);
    return localStringBuilder.toString();
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
  
  protected void a(FavFileInfo paramFavFileInfo, AsyncImageView paramAsyncImageView)
  {
    int m = QQFileManagerUtil.k(paramFavFileInfo.d);
    if ((m == 0) || (m == 2))
    {
      String str;
      if (FileUtils.fileExistsAndNotEmpty(paramFavFileInfo.n)) {
        str = paramFavFileInfo.n;
      } else if (FileUtils.fileExistsAndNotEmpty(paramFavFileInfo.m)) {
        str = paramFavFileInfo.m;
      } else if (FileUtils.fileExistsAndNotEmpty(paramFavFileInfo.l)) {
        str = paramFavFileInfo.l;
      } else if (FileUtils.fileExistsAndNotEmpty(paramFavFileInfo.k)) {
        str = paramFavFileInfo.k;
      } else if (FileUtils.fileExistsAndNotEmpty(paramFavFileInfo.j)) {
        str = paramFavFileInfo.j;
      } else {
        str = "";
      }
      if (!TextUtils.isEmpty(str))
      {
        paramAsyncImageView.setAsyncImage(str);
        return;
      }
    }
    QQFileManagerUtil.a(paramAsyncImageView, paramFavFileInfo.h, m);
  }
  
  public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    FavFileInfo localFavFileInfo = (FavFileInfo)getChild(paramInt1, paramInt2);
    if (localFavFileInfo == null) {
      return paramView;
    }
    View localView;
    if (paramView == null) {
      localView = paramView;
    }
    try
    {
      Object localObject = new QfileFavFileBaseExpandableListAdapter.FavFileItemHolder(this);
      localView = paramView;
      paramView = this.c.inflate(2131627036, paramViewGroup, false);
      localView = paramView;
      ((QfileFavFileBaseExpandableListAdapter.FavFileItemHolder)localObject).c = ((RelativeLayout)paramView.findViewById(2131444373));
      localView = paramView;
      ((QfileFavFileBaseExpandableListAdapter.FavFileItemHolder)localObject).c.setOnClickListener(this.d);
      localView = paramView;
      ((QfileFavFileBaseExpandableListAdapter.FavFileItemHolder)localObject).c.setOnLongClickListener(this.i);
      localView = paramView;
      ((QfileFavFileBaseExpandableListAdapter.FavFileItemHolder)localObject).c.setTag(localObject);
      localView = paramView;
      ((QfileFavFileBaseExpandableListAdapter.FavFileItemHolder)localObject).d = ((CircleFileStateView)paramView.findViewById(2131427503));
      localView = paramView;
      ((QfileFavFileBaseExpandableListAdapter.FavFileItemHolder)localObject).f = ((CheckBox)paramView.findViewById(2131433116));
      localView = paramView;
      ((QfileFavFileBaseExpandableListAdapter.FavFileItemHolder)localObject).g = ((AsyncImageView)paramView.findViewById(2131433103));
      localView = paramView;
      ((QfileFavFileBaseExpandableListAdapter.FavFileItemHolder)localObject).g.setOnClickListener(this.d);
      localView = paramView;
      ((QfileFavFileBaseExpandableListAdapter.FavFileItemHolder)localObject).g.setTag(localObject);
      localView = paramView;
      ((QfileFavFileBaseExpandableListAdapter.FavFileItemHolder)localObject).h = ((TextView)paramView.findViewById(2131433114));
      localView = paramView;
      ((QfileFavFileBaseExpandableListAdapter.FavFileItemHolder)localObject).h.setGravity(48);
      localView = paramView;
      ((QfileFavFileBaseExpandableListAdapter.FavFileItemHolder)localObject).h.setMaxLines(2);
      localView = paramView;
      ((QfileFavFileBaseExpandableListAdapter.FavFileItemHolder)localObject).i = ((TextView)paramView.findViewById(2131433101));
      localView = paramView;
      ((QfileFavFileBaseExpandableListAdapter.FavFileItemHolder)localObject).j = ((TextView)paramView.findViewById(2131436844));
      localView = paramView;
      int m = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).dp2px(70, this.b.getResources());
      localView = paramView;
      ((QfileFavFileBaseExpandableListAdapter.FavFileItemHolder)localObject).g.setAsyncClipSize(m, m);
      localView = paramView;
      paramView.setTag(localObject);
      paramViewGroup = (ViewGroup)localObject;
      break label368;
      localView = paramView;
      paramViewGroup = (QfileFavFileBaseExpandableListAdapter.FavFileItemHolder)paramView.getTag();
      label368:
      localView = paramView;
      a(localFavFileInfo, paramViewGroup.g);
      localView = paramView;
      paramViewGroup.b = paramInt1;
      localView = paramView;
      paramViewGroup.a = paramInt2;
      localView = paramView;
      paramViewGroup.k = localFavFileInfo;
      localView = paramView;
      paramViewGroup.d.setOnClickListener(this.j);
      localView = paramView;
      paramViewGroup.d.setState(2);
      localView = paramView;
      paramViewGroup.d.setTag(paramViewGroup);
      localView = paramView;
      paramViewGroup.e = 1;
      localView = paramView;
      paramViewGroup.d.setVisibility(8);
      localView = paramView;
      paramViewGroup.h.setText(localFavFileInfo.d);
      localView = paramView;
      paramViewGroup.i.setText(a(localFavFileInfo));
      localView = paramView;
      localObject = this.a.getString(2131889363);
      localView = paramView;
      String str = this.a.getString(2131889334);
      localView = paramView;
      StringBuilder localStringBuilder = new StringBuilder();
      localView = paramView;
      localStringBuilder.append(((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).formatNewRefreshTime(localFavFileInfo.g));
      localView = paramView;
      localStringBuilder.append(a(str, (String)localObject));
      localView = paramView;
      localObject = localStringBuilder.toString();
      localView = paramView;
      paramViewGroup.j.setText((CharSequence)localObject);
      localView = paramView;
      if (this.a.D())
      {
        localView = paramView;
        paramViewGroup.d.setVisibility(8);
        localView = paramView;
        paramViewGroup.f.setVisibility(0);
        localView = paramView;
        paramViewGroup.f.setChecked(FMDataCache.c(localFavFileInfo));
      }
      else
      {
        localView = paramView;
        paramViewGroup.f.setVisibility(8);
      }
      localView = paramView;
      localObject = (LinearLayout.LayoutParams)paramViewGroup.i.getLayoutParams();
      localView = paramView;
      ((LinearLayout.LayoutParams)localObject).topMargin = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).dp2px(3, this.b.getResources());
      localView = paramView;
      paramViewGroup.i.setLineSpacing(TypedValue.applyDimension(1, 0.8F, this.b.getResources().getDisplayMetrics()), 1.0F);
      localView = paramView;
      paramViewGroup.i.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localView = paramView;
      paramViewGroup.h.setLineSpacing(TypedValue.applyDimension(1, 0.25F, this.b.getResources().getDisplayMetrics()), 1.0F);
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
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.favfile.QfileFavFileBaseExpandableListAdapter
 * JD-Core Version:    0.7.0.1
 */