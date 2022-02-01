package com.tencent.mobileqq.mini.entry.desktop;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.entry.MiniAppExposureManager;
import com.tencent.mobileqq.mini.entry.MiniAppExposureManager.CardModuleExposureData;
import com.tencent.mobileqq.mini.entry.MiniAppExposureManager.TianShuExposureData;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopSearchInfo;
import com.tencent.mobileqq.mini.util.DisplayUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
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
    this.keywordTv = ((TextView)paramView.findViewById(2131438553));
    this.container = paramView.findViewById(2131438546);
    this.container.setPadding(0, 0, 0, 0);
    paramView.setOnClickListener(new MiniAppDesktopAdapter.SearchViewHolder.1(this, paramWeakReference));
  }
  
  public void update(DesktopSearchInfo paramDesktopSearchInfo)
  {
    Object localObject2 = MiniAppUtils.getAppInterface();
    Object localObject1;
    if (localObject2 != null)
    {
      int i = 2130852498;
      if ((ThemeUtil.isDefaultTheme()) || (ThemeUtil.isGoldenTheme()) || (DisplayUtil.isWhiteModeTheme()) || (QQTheme.isThemeSimpleDayUI(ThemeUtil.getCurrentThemeId()))) {
        i = 2130841841;
      }
      int j = i;
      if (paramDesktopSearchInfo != null)
      {
        j = i;
        if (paramDesktopSearchInfo.isSpringFestivalMode)
        {
          if (QLog.isColorLevel()) {
            QLog.i("MiniAppDesktopAdapter", 2, "updateSearchBar, ContainerBg");
          }
          j = 2130852500;
        }
      }
      this.container.setBackgroundResource(j);
      j = 2130852493;
      i = j;
      if (paramDesktopSearchInfo != null)
      {
        i = j;
        if (paramDesktopSearchInfo.isSpringFestivalMode)
        {
          if (QLog.isColorLevel()) {
            QLog.i("MiniAppDesktopAdapter", 2, "updateSearchBar, SearchIconBg");
          }
          i = 2130852496;
        }
      }
      localObject1 = BaseApplicationImpl.getContext().getResources().getDrawable(i);
      ((Drawable)localObject1).setBounds(0, 0, ((Drawable)localObject1).getMinimumWidth(), ((Drawable)localObject1).getMinimumHeight());
      this.keywordTv.setCompoundDrawables((Drawable)localObject1, null, null, null);
      j = BaseApplicationImpl.getContext().getResources().getColor(2131168136);
      i = j;
      if (paramDesktopSearchInfo != null)
      {
        i = j;
        if (paramDesktopSearchInfo.isSpringFestivalMode)
        {
          if (QLog.isColorLevel()) {
            QLog.i("MiniAppDesktopAdapter", 2, "updateSearchBar, textColor:#FFFFFF");
          }
          i = Color.parseColor("#FFFFFF");
        }
      }
      this.keywordTv.setTextColor(i);
    }
    this.container.setPadding(0, 0, 0, 0);
    this.searchInfo = paramDesktopSearchInfo;
    if ((paramDesktopSearchInfo != null) && (paramDesktopSearchInfo.keyword != null) && (paramDesktopSearchInfo.keyword.size() > 0))
    {
      localObject1 = (String)paramDesktopSearchInfo.keyword.get(0);
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        this.keywordTv.setText((CharSequence)localObject1);
      } else {
        this.keywordTv.setText(HardCodeUtil.a(2131904672));
      }
    }
    else
    {
      this.keywordTv.setText(HardCodeUtil.a(2131904675));
    }
    if (this.keywordTv.getText() != null) {
      localObject1 = this.keywordTv.getText().toString();
    } else {
      localObject1 = HardCodeUtil.a(2131904680);
    }
    if (localObject2 != null)
    {
      localObject2 = (MiniAppExposureManager)((AppInterface)localObject2).getManager(QQManagerFactory.MINI_APP_EXPOSURE_MANAGER);
      ((MiniAppExposureManager)localObject2).putReportDataToMap("search", new MiniAppExposureManager.CardModuleExposureData("desktop", "search", "expo_search", (String)localObject1));
      if ((paramDesktopSearchInfo != null) && (paramDesktopSearchInfo.mAppInfo != null) && (paramDesktopSearchInfo.mAppInfo.tianshuAdId > 0))
      {
        paramDesktopSearchInfo = String.valueOf(paramDesktopSearchInfo.mAppInfo.tianshuAdId);
        ((MiniAppExposureManager)localObject2).putReportDataToMap(paramDesktopSearchInfo, new MiniAppExposureManager.TianShuExposureData("tianshu.78", "tianshu.78", paramDesktopSearchInfo, 101));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.MiniAppDesktopAdapter.SearchViewHolder
 * JD-Core Version:    0.7.0.1
 */