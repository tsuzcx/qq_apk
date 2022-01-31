package com.tencent.mobileqq.mini.entry.desktop;

import ahfx;
import ajya;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import axmv;
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
    this.keywordTv = ((TextView)paramView.findViewById(2131370249));
    this.container = paramView.findViewById(2131370248);
    this.container.setPadding(0, 0, 0, 0);
    paramView.setOnClickListener(new MiniAppDesktopAdapter.SearchViewHolder.1(this, paramWeakReference));
  }
  
  public void update(DesktopSearchInfo paramDesktopSearchInfo)
  {
    AppInterface localAppInterface = MiniAppUtils.getAppInterface();
    Object localObject1;
    if (localAppInterface != null)
    {
      localObject1 = (ahfx)localAppInterface.getManager(342);
      if ((localObject1 == null) || (!((ahfx)localObject1).h())) {
        break label312;
      }
      DesktopDataManager localDesktopDataManager = (DesktopDataManager)localAppInterface.getManager(336);
      Object localObject2 = ((ahfx)localObject1).a();
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
          break label448;
        }
      }
    }
    label312:
    label448:
    for (paramDesktopSearchInfo = this.keywordTv.getText().toString();; paramDesktopSearchInfo = ajya.a(2131706807))
    {
      if (localAppInterface != null) {
        ((MiniAppExposureManager)localAppInterface.getManager(322)).putReportDataToMap("search", new MiniAppExposureManager.CardModuleExposureData("desktop", "search", "expo_search", paramDesktopSearchInfo));
      }
      return;
      if ((ThemeUtil.isDefaultTheme()) || (ThemeUtil.isGoldenTheme()) || (DisplayUtil.isWhiteModeTheme()) || (axmv.b(ThemeUtil.getCurrentThemeId()))) {
        this.container.setBackgroundResource(2130840657);
      }
      for (;;)
      {
        localObject1 = BaseApplicationImpl.getContext().getResources().getDrawable(2130849236);
        ((Drawable)localObject1).setBounds(0, 0, ((Drawable)localObject1).getMinimumWidth(), ((Drawable)localObject1).getMinimumHeight());
        this.keywordTv.setCompoundDrawables((Drawable)localObject1, null, null, null);
        this.keywordTv.setTextColor(BaseApplicationImpl.getContext().getResources().getColor(2131166944));
        break;
        this.container.setBackgroundResource(2130849240);
      }
      this.keywordTv.setText(ajya.a(2131706799));
      break label253;
      this.keywordTv.setText(ajya.a(2131706802));
      break label253;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.MiniAppDesktopAdapter.SearchViewHolder
 * JD-Core Version:    0.7.0.1
 */