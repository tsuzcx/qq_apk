package com.tencent.mobileqq.minigame.manager;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.apkg.UseUserInfo;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.widget.ThemeImageView;
import com.tencent.widget.ThemeImageWrapper;
import java.util.ArrayList;
import java.util.List;

class GameCloseManager$MiniAppViewItem
{
  private RelativeLayout buttonView;
  private Context context;
  private ImageView friendIcon0;
  private ImageView friendIcon1;
  private ImageView friendIcon2;
  private RelativeLayout friendIconLayout;
  private ArrayList<ImageView> friendIconList = new ArrayList();
  private View gap;
  private ImageView imageView;
  private View root;
  private TextView subtitleView;
  private TextView textView;
  
  public GameCloseManager$MiniAppViewItem(Context paramContext)
  {
    this.context = paramContext;
    this.root = LayoutInflater.from(paramContext).inflate(2131559529, null, false);
    this.imageView = ((ImageView)this.root.findViewById(2131371751));
    this.buttonView = ((RelativeLayout)this.root.findViewById(2131371747));
    if ((this.imageView instanceof ThemeImageView)) {
      ((ThemeImageView)this.imageView).setMaskShape(ThemeImageWrapper.MODE_OTHER);
    }
    this.textView = ((TextView)this.root.findViewById(2131371754));
    this.gap = this.root.findViewById(2131371750);
    this.subtitleView = ((TextView)this.root.findViewById(2131371753));
    this.friendIcon0 = ((ImageView)this.root.findViewById(2131371743));
    this.friendIcon1 = ((ImageView)this.root.findViewById(2131371744));
    this.friendIcon2 = ((ImageView)this.root.findViewById(2131371745));
    this.friendIconList.add(this.friendIcon0);
    this.friendIconList.add(this.friendIcon1);
    this.friendIconList.add(this.friendIcon2);
    this.friendIconLayout = ((RelativeLayout)this.root.findViewById(2131371746));
  }
  
  private void setSubtitleData(Context paramContext, MiniAppInfo paramMiniAppInfo)
  {
    if (paramContext == null) {}
    for (;;)
    {
      return;
      int j = paramMiniAppInfo.friendNum;
      List localList = paramMiniAppInfo.users;
      if ((j <= 0) || (localList == null) || (localList.size() < j)) {
        break;
      }
      this.subtitleView.setText(paramMiniAppInfo.friendNum + "个好友在玩");
      this.friendIconLayout.setVisibility(0);
      this.gap.setVisibility(0);
      paramMiniAppInfo = paramContext.getResources().getDrawable(2130840452);
      paramContext = URLDrawable.URLDrawableOptions.obtain();
      paramContext.mLoadingDrawable = paramMiniAppInfo;
      paramContext.mFailedDrawable = paramMiniAppInfo;
      int i = ViewUtils.a(12.0F);
      paramContext.mRequestHeight = i;
      paramContext.mRequestWidth = i;
      i = 0;
      while (i < j)
      {
        paramMiniAppInfo = (ImageView)this.friendIconList.get(i);
        paramMiniAppInfo.setVisibility(0);
        URLDrawable localURLDrawable = URLDrawable.getDrawable(((UseUserInfo)localList.get(i)).avatar, paramContext);
        localURLDrawable.setTag(URLDrawableDecodeHandler.a(ViewUtils.a(12.0F), ViewUtils.a(12.0F)));
        localURLDrawable.setDecodeHandler(URLDrawableDecodeHandler.p);
        paramMiniAppInfo.setImageDrawable(localURLDrawable);
        i += 1;
      }
      if (j < 3)
      {
        i = 2;
        while (i >= j)
        {
          ((ImageView)this.friendIconList.get(i)).setVisibility(8);
          i -= 1;
        }
      }
    }
    this.friendIconLayout.setVisibility(8);
    this.gap.setVisibility(8);
    paramContext = "1";
    if (paramMiniAppInfo.userNum >= 10000) {
      paramContext = paramMiniAppInfo.userNum % 10000 + "万";
    }
    for (;;)
    {
      this.subtitleView.setText(paramContext + "人在玩");
      return;
      if (paramMiniAppInfo.userNum > 0) {
        paramContext = paramMiniAppInfo.userNum + "";
      }
    }
  }
  
  public void setData(MiniAppInfo paramMiniAppInfo, View.OnClickListener paramOnClickListener)
  {
    this.imageView.setImageDrawable(MiniAppUtils.getIcon(this.context, paramMiniAppInfo.iconUrl, true));
    this.textView.setVisibility(0);
    this.textView.setText(paramMiniAppInfo.name);
    this.buttonView.setBackgroundDrawable(MiniAppUtils.getDrawable("https://sola.gtimg.cn/aoi/sola/20201026161621_Lp6n61u1Eg.png", null));
    this.root.setOnClickListener(paramOnClickListener);
    setSubtitleData(this.root.getContext(), paramMiniAppInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.manager.GameCloseManager.MiniAppViewItem
 * JD-Core Version:    0.7.0.1
 */