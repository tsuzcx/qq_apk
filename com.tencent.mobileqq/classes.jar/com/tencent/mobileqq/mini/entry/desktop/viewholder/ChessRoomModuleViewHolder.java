package com.tencent.mobileqq.mini.entry.desktop.viewholder;

import NS_COMM.COMM.Entry;
import NS_COMM.COMM.StCommonExt;
import NS_MINI_INTERFACE.INTERFACE.StApiAppInfo;
import NS_MINI_INTERFACE.INTERFACE.StUserAppInfo;
import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.entry.desktop.GameAppUiItem;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ChessRoomModuleViewHolder
  extends BaseChessRoomModuleViewHolder
{
  private static final int GAME_SIZE_MAX = 5;
  private static final String RESERVES2_REPORT_TAB_INFO = "ReportTabInfo";
  
  public ChessRoomModuleViewHolder(View paramView, WeakReference<Activity> paramWeakReference)
  {
    super(paramView, paramWeakReference, 5);
    initView(paramView);
  }
  
  @Nullable
  private String getReportReserves2(@NonNull INTERFACE.StUserAppInfo paramStUserAppInfo)
  {
    if ((paramStUserAppInfo.appInfo != null) && (paramStUserAppInfo.appInfo.extInfo != null) && (paramStUserAppInfo.appInfo.extInfo.mapInfo.get() != null))
    {
      paramStUserAppInfo = paramStUserAppInfo.appInfo.extInfo.mapInfo.get().iterator();
      while (paramStUserAppInfo.hasNext())
      {
        COMM.Entry localEntry = (COMM.Entry)paramStUserAppInfo.next();
        if ("ReportTabInfo".equals(localEntry.key.get())) {
          return localEntry.value.get();
        }
      }
    }
    return null;
  }
  
  private void initView(View paramView)
  {
    View localView1 = paramView.findViewById(2030305282);
    View localView2 = paramView.findViewById(2030305285);
    View localView3 = paramView.findViewById(2030305288);
    View localView4 = paramView.findViewById(2030305291);
    View localView5 = paramView.findViewById(2030305294);
    ImageView localImageView1 = (ImageView)paramView.findViewById(2030305280);
    ImageView localImageView2 = (ImageView)paramView.findViewById(2030305283);
    ImageView localImageView3 = (ImageView)paramView.findViewById(2030305286);
    ImageView localImageView4 = (ImageView)paramView.findViewById(2030305289);
    ImageView localImageView5 = (ImageView)paramView.findViewById(2030305292);
    TextView localTextView1 = (TextView)paramView.findViewById(2030305281);
    TextView localTextView2 = (TextView)paramView.findViewById(2030305284);
    TextView localTextView3 = (TextView)paramView.findViewById(2030305287);
    TextView localTextView4 = (TextView)paramView.findViewById(2030305290);
    TextView localTextView5 = (TextView)paramView.findViewById(2030305293);
    paramView = (ImageView)paramView.findViewById(2030305314);
    this.mGameAppUiItems.add(new GameAppUiItem(localView1, localImageView1, localTextView1));
    this.mGameAppUiItems.add(new GameAppUiItem(localView2, localImageView2, localTextView2));
    this.mGameAppUiItems.add(new GameAppUiItem(localView3, localImageView3, localTextView3));
    this.mGameAppUiItems.add(new GameAppUiItem(localView4, localImageView4, localTextView4));
    this.mGameAppUiItems.add(new GameAppUiItem(localView5, localImageView5, localTextView5));
    paramView.setOnClickListener(new ChessRoomModuleViewHolder.1(this));
  }
  
  private void report(MiniAppInfo paramMiniAppInfo, String paramString1, String paramString2, String paramString3)
  {
    MiniProgramLpReportDC04239.reportAsync(getMiniAppConfig(paramMiniAppInfo), "desktop", "chess_center", paramString1, paramString2, paramString3);
  }
  
  public void setData(ArrayList<INTERFACE.StUserAppInfo> paramArrayList, MiniAppInfo paramMiniAppInfo, int paramInt)
  {
    this.mMoreAppInfo = paramMiniAppInfo;
    this.mChessEntranceTabIndex = paramInt;
    if ((paramArrayList != null) && (paramArrayList.size() != 0))
    {
      MiniProgramLpReportDC04239.reportAsync("desktop", "chess_center", "show", null);
      this.mRootView.setVisibility(0);
      initAppPanelVisibleState();
      int i = paramArrayList.size();
      paramInt = i;
      if (i > this.mGameAppSize) {
        paramInt = this.mGameAppSize;
      }
      i = 0;
      while (i < paramInt)
      {
        paramMiniAppInfo = (INTERFACE.StUserAppInfo)paramArrayList.get(i);
        if ((paramMiniAppInfo != null) && (paramMiniAppInfo.appInfo != null))
        {
          MiniAppInfo localMiniAppInfo = MiniAppInfo.from(paramMiniAppInfo);
          ((GameAppUiItem)this.mGameAppUiItems.get(i)).appPanel.setVisibility(0);
          ((GameAppUiItem)this.mGameAppUiItems.get(i)).appName.setText(localMiniAppInfo.name);
          ImageView localImageView = ((GameAppUiItem)this.mGameAppUiItems.get(i)).appIcon;
          localImageView.setImageDrawable(MiniAppUtils.getIcon(BaseApplicationImpl.getContext(), localMiniAppInfo.iconUrl, true));
          String str1 = String.valueOf(i + 1);
          String str2 = getReportReserves2(paramMiniAppInfo);
          localImageView.setOnClickListener(new ChessRoomModuleViewHolder.2(this, localMiniAppInfo, paramMiniAppInfo, str2, str1));
          report(localMiniAppInfo, "expo", str2, str1);
        }
        i += 1;
      }
      return;
    }
    this.mRootView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.viewholder.ChessRoomModuleViewHolder
 * JD-Core Version:    0.7.0.1
 */