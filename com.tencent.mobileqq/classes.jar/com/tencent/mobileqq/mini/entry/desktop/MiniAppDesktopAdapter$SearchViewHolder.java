package com.tencent.mobileqq.mini.entry.desktop;

import alud;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import azmk;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.entry.MiniAppExposureManager;
import com.tencent.mobileqq.mini.entry.MiniAppExposureManager.CardModuleExposureData;
import com.tencent.mobileqq.mini.entry.MiniAppExposureManager.TianShuExposureData;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
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
    this.keywordTv = ((TextView)paramView.findViewById(2131370542));
    this.container = paramView.findViewById(2131370538);
    this.container.setPadding(0, 0, 0, 0);
    paramView.setOnClickListener(new MiniAppDesktopAdapter.SearchViewHolder.1(this, paramWeakReference));
  }
  
  public void update(DesktopSearchInfo paramDesktopSearchInfo)
  {
    Object localObject2 = MiniAppUtils.getAppInterface();
    if (localObject2 != null)
    {
      if ((ThemeUtil.isDefaultTheme()) || (ThemeUtil.isGoldenTheme()) || (DisplayUtil.isWhiteModeTheme()) || (azmk.b(ThemeUtil.getCurrentThemeId())))
      {
        this.container.setBackgroundResource(2130840761);
        localObject1 = BaseApplicationImpl.getContext().getResources().getDrawable(2130849740);
        ((Drawable)localObject1).setBounds(0, 0, ((Drawable)localObject1).getMinimumWidth(), ((Drawable)localObject1).getMinimumHeight());
        this.keywordTv.setCompoundDrawables((Drawable)localObject1, null, null, null);
        this.keywordTv.setTextColor(BaseApplicationImpl.getContext().getResources().getColor(2131166994));
      }
    }
    else
    {
      this.container.setPadding(0, 0, 0, 0);
      this.searchInfo = paramDesktopSearchInfo;
      if ((paramDesktopSearchInfo == null) || (paramDesktopSearchInfo.keyword == null) || (paramDesktopSearchInfo.keyword.size() <= 0)) {
        break label304;
      }
      localObject1 = (String)paramDesktopSearchInfo.keyword.get(0);
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label289;
      }
      this.keywordTv.setText((CharSequence)localObject1);
      label167:
      if (this.keywordTv.getText() == null) {
        break label319;
      }
    }
    label289:
    label304:
    label319:
    for (Object localObject1 = this.keywordTv.getText().toString();; localObject1 = alud.a(2131707191))
    {
      if (localObject2 != null)
      {
        localObject2 = (MiniAppExposureManager)((AppInterface)localObject2).getManager(322);
        ((MiniAppExposureManager)localObject2).putReportDataToMap("search", new MiniAppExposureManager.CardModuleExposureData("desktop", "search", "expo_search", (String)localObject1));
        if ((paramDesktopSearchInfo != null) && (paramDesktopSearchInfo.mAppInfo != null) && (paramDesktopSearchInfo.mAppInfo.tianshuAdId > 0))
        {
          paramDesktopSearchInfo = String.valueOf(paramDesktopSearchInfo.mAppInfo.tianshuAdId);
          ((MiniAppExposureManager)localObject2).putReportDataToMap(paramDesktopSearchInfo, new MiniAppExposureManager.TianShuExposureData("tianshu.78", "tianshu.78", paramDesktopSearchInfo, 101));
        }
      }
      return;
      this.container.setBackgroundResource(2130849744);
      break;
      this.keywordTv.setText(alud.a(2131707183));
      break label167;
      this.keywordTv.setText(alud.a(2131707186));
      break label167;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.MiniAppDesktopAdapter.SearchViewHolder
 * JD-Core Version:    0.7.0.1
 */