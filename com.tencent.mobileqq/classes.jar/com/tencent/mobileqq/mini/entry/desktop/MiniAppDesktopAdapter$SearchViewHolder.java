package com.tencent.mobileqq.mini.entry.desktop;

import agtk;
import ajjy;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import awnu;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.entry.MiniAppExposureManager;
import com.tencent.mobileqq.mini.entry.MiniAppExposureManager.CardModuleExposureData;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataManager;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataManager.HongBaoResBuilder;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopSearchInfo;
import com.tencent.mobileqq.mini.util.DisplayUtil;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import java.lang.ref.WeakReference;
import java.util.List;

class MiniAppDesktopAdapter$SearchViewHolder
  extends RecyclerView.ViewHolder
{
  private View container;
  private TextView keywordTv;
  private DesktopSearchInfo searchInfo;
  
  public MiniAppDesktopAdapter$SearchViewHolder(WeakReference<Activity> paramWeakReference, View paramView)
  {
    super(paramView);
    this.keywordTv = ((TextView)paramView.findViewById(2131304568));
    this.container = paramView.findViewById(2131304567);
    this.container.setPadding(0, 0, 0, 0);
    paramView.setOnClickListener(new MiniAppDesktopAdapter.SearchViewHolder.1(this, paramWeakReference));
  }
  
  public void update(DesktopSearchInfo paramDesktopSearchInfo)
  {
    AppInterface localAppInterface = MiniAppUtils.getAppInterface();
    Object localObject1;
    if (localAppInterface != null)
    {
      localObject1 = (agtk)localAppInterface.getManager(342);
      if ((localObject1 == null) || (!((agtk)localObject1).h())) {
        break label322;
      }
      DesktopDataManager localDesktopDataManager = (DesktopDataManager)localAppInterface.getManager(336);
      Object localObject2 = ((agtk)localObject1).a();
      localObject1 = localObject2;
      if (localDesktopDataManager != null)
      {
        localObject1 = localObject2;
        if (localDesktopDataManager.getHongBaoResBuilder() != null) {
          localObject1 = localDesktopDataManager.getHongBaoResBuilder();
        }
      }
      if (localObject1 != null)
      {
        if ((((DesktopDataManager.HongBaoResBuilder)localObject1).getSearchBackgroundResId() != -1) && (this.container != null)) {
          this.container.setBackgroundResource(((DesktopDataManager.HongBaoResBuilder)localObject1).getSearchBackgroundResId());
        }
        if ((((DesktopDataManager.HongBaoResBuilder)localObject1).getSearchIconResId() != -1) && (this.keywordTv != null))
        {
          localObject2 = BaseApplicationImpl.getContext().getResources().getDrawable(((DesktopDataManager.HongBaoResBuilder)localObject1).getSearchIconResId());
          ((Drawable)localObject2).setBounds(0, 0, ((Drawable)localObject2).getMinimumWidth(), ((Drawable)localObject2).getMinimumHeight());
          this.keywordTv.setCompoundDrawables((Drawable)localObject2, null, null, null);
        }
        if ((((DesktopDataManager.HongBaoResBuilder)localObject1).getSearchTitleColor() != 2147483647) && (this.keywordTv != null)) {
          this.keywordTv.setTextColor(((DesktopDataManager.HongBaoResBuilder)localObject1).getSearchTitleColor());
        }
      }
    }
    this.container.setPadding(0, 0, 0, 0);
    this.searchInfo = paramDesktopSearchInfo;
    if ((paramDesktopSearchInfo != null) && (paramDesktopSearchInfo.keyword != null) && (paramDesktopSearchInfo.keyword.size() > 0))
    {
      paramDesktopSearchInfo = (String)paramDesktopSearchInfo.keyword.get(0);
      if (!TextUtils.isEmpty(paramDesktopSearchInfo))
      {
        this.keywordTv.setText(paramDesktopSearchInfo);
        label253:
        if (this.keywordTv.getText() == null) {
          break label458;
        }
      }
    }
    label322:
    label458:
    for (paramDesktopSearchInfo = this.keywordTv.getText().toString();; paramDesktopSearchInfo = ajjy.a(2131641011))
    {
      if (localAppInterface != null)
      {
        localObject1 = (MiniAppExposureManager)localAppInterface.getManager(322);
        paramDesktopSearchInfo = new MiniAppExposureManager.CardModuleExposureData("desktop", "search", "expo_search", paramDesktopSearchInfo);
        if (((MiniAppExposureManager)localObject1).getDesktopPullDownState() != 3) {
          break label467;
        }
        ((MiniAppExposureManager)localObject1).addReportItem(paramDesktopSearchInfo);
      }
      return;
      if ((ThemeUtil.isDefaultTheme()) || (ThemeUtil.isGoldenTheme()) || (DisplayUtil.isWhiteModeTheme()) || (awnu.b(ThemeUtil.getCurrentThemeId()))) {
        this.container.setBackgroundResource(2130840616);
      }
      for (;;)
      {
        localObject1 = BaseApplicationImpl.getContext().getResources().getDrawable(2130848992);
        ((Drawable)localObject1).setBounds(0, 0, ((Drawable)localObject1).getMinimumWidth(), ((Drawable)localObject1).getMinimumHeight());
        this.keywordTv.setCompoundDrawables((Drawable)localObject1, null, null, null);
        this.keywordTv.setTextColor(BaseApplicationImpl.getContext().getResources().getColor(2131101349));
        break;
        this.container.setBackgroundResource(2130848996);
      }
      this.keywordTv.setText(ajjy.a(2131641003));
      break label253;
      this.keywordTv.setText(ajjy.a(2131641006));
      break label253;
    }
    label467:
    ((MiniAppExposureManager)localObject1).putReportDataToMap("search", paramDesktopSearchInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.MiniAppDesktopAdapter.SearchViewHolder
 * JD-Core Version:    0.7.0.1
 */