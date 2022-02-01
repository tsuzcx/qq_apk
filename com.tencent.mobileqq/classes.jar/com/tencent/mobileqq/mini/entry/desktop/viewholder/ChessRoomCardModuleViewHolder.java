package com.tencent.mobileqq.mini.entry.desktop.viewholder;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.entry.desktop.GameAppUiItem;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class ChessRoomCardModuleViewHolder
  extends BaseChessRoomModuleViewHolder
{
  private static final int GAME_SIZE_MAX = 4;
  private View mRootView;
  
  public ChessRoomCardModuleViewHolder(View paramView, WeakReference<Activity> paramWeakReference)
  {
    super(paramView, paramWeakReference, 4);
    initView(paramView);
  }
  
  private static Drawable getChressRoomBgIconDrawable(String paramString)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mPlayGifImage = false;
    return URLDrawable.getDrawable(paramString, localURLDrawableOptions);
  }
  
  private void initView(View paramView)
  {
    this.mRootView = paramView.findViewById(2030305327);
    View localView1 = paramView.findViewById(2030305282);
    View localView2 = paramView.findViewById(2030305285);
    View localView3 = paramView.findViewById(2030305288);
    View localView4 = paramView.findViewById(2030305291);
    ImageView localImageView1 = (ImageView)paramView.findViewById(2030305280);
    ImageView localImageView2 = (ImageView)paramView.findViewById(2030305283);
    ImageView localImageView3 = (ImageView)paramView.findViewById(2030305286);
    ImageView localImageView4 = (ImageView)paramView.findViewById(2030305289);
    TextView localTextView1 = (TextView)paramView.findViewById(2030305281);
    TextView localTextView2 = (TextView)paramView.findViewById(2030305284);
    TextView localTextView3 = (TextView)paramView.findViewById(2030305287);
    TextView localTextView4 = (TextView)paramView.findViewById(2030305290);
    paramView = (ImageView)paramView.findViewById(2030305300);
    this.mGameAppUiItems.add(new GameAppUiItem(localView1, localImageView1, localTextView1));
    this.mGameAppUiItems.add(new GameAppUiItem(localView2, localImageView2, localTextView2));
    this.mGameAppUiItems.add(new GameAppUiItem(localView3, localImageView3, localTextView3));
    this.mGameAppUiItems.add(new GameAppUiItem(localView4, localImageView4, localTextView4));
    paramView.setOnClickListener(new ChessRoomCardModuleViewHolder.1(this));
  }
  
  private void report(MiniAppInfo paramMiniAppInfo, String paramString1, String paramString2)
  {
    MiniProgramLpReportDC04239.reportAsync(getMiniAppConfig(paramMiniAppInfo), "desktop", "chess_center", paramString1, "game", paramString2);
  }
  
  public void setData(ArrayList<MiniAppInfo> paramArrayList, MiniAppInfo paramMiniAppInfo, int paramInt, String paramString)
  {
    this.mMoreAppInfo = paramMiniAppInfo;
    this.mChessEntranceTabIndex = paramInt;
    if ((paramArrayList != null) && (paramArrayList.size() != 0))
    {
      this.mRootView.setBackgroundDrawable(getChressRoomBgIconDrawable(paramString));
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
        paramMiniAppInfo = (MiniAppInfo)paramArrayList.get(i);
        if (paramMiniAppInfo != null)
        {
          ((GameAppUiItem)this.mGameAppUiItems.get(i)).appPanel.setVisibility(0);
          ((GameAppUiItem)this.mGameAppUiItems.get(i)).appName.setText(paramMiniAppInfo.name);
          paramString = ((GameAppUiItem)this.mGameAppUiItems.get(i)).appIcon;
          paramString.setImageDrawable(MiniAppUtils.getIcon(BaseApplicationImpl.getContext(), paramMiniAppInfo.iconUrl, true));
          String str = String.valueOf(i + 1);
          paramString.setOnClickListener(new ChessRoomCardModuleViewHolder.2(this, paramMiniAppInfo, str));
          report(paramMiniAppInfo, "expo", str);
        }
        i += 1;
      }
      return;
    }
    this.mRootView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.viewholder.ChessRoomCardModuleViewHolder
 * JD-Core Version:    0.7.0.1
 */