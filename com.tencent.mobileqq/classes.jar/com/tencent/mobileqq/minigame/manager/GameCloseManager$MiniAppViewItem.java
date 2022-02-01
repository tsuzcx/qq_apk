package com.tencent.mobileqq.minigame.manager;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
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
    this.root = LayoutInflater.from(paramContext).inflate(2131559405, null, false);
    this.imageView = ((ImageView)this.root.findViewById(2131371377));
    this.buttonView = ((RelativeLayout)this.root.findViewById(2131371373));
    paramContext = this.imageView;
    if ((paramContext instanceof ThemeImageView)) {
      ((ThemeImageView)paramContext).setMaskShape(ThemeImageWrapper.MODE_OTHER);
    }
    this.textView = ((TextView)this.root.findViewById(2131371380));
    this.gap = this.root.findViewById(2131371376);
    this.subtitleView = ((TextView)this.root.findViewById(2131371379));
    this.friendIcon0 = ((ImageView)this.root.findViewById(2131371369));
    this.friendIcon1 = ((ImageView)this.root.findViewById(2131371370));
    this.friendIcon2 = ((ImageView)this.root.findViewById(2131371371));
    this.friendIconList.add(this.friendIcon0);
    this.friendIconList.add(this.friendIcon1);
    this.friendIconList.add(this.friendIcon2);
    this.friendIconLayout = ((RelativeLayout)this.root.findViewById(2131371372));
  }
  
  private void setSubtitleData(Context paramContext, MiniAppInfo paramMiniAppInfo)
  {
    if (paramContext == null) {
      return;
    }
    int j = paramMiniAppInfo.friendNum;
    Object localObject1 = paramMiniAppInfo.users;
    int i;
    if ((j > 0) && (localObject1 != null) && (((List)localObject1).size() >= j))
    {
      Object localObject2 = this.subtitleView;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramMiniAppInfo.friendNum);
      localStringBuilder.append("个好友在玩");
      ((TextView)localObject2).setText(localStringBuilder.toString());
      this.friendIconLayout.setVisibility(0);
      this.gap.setVisibility(0);
      paramMiniAppInfo = paramContext.getResources().getDrawable(2130840321);
      paramContext = URLDrawable.URLDrawableOptions.obtain();
      paramContext.mLoadingDrawable = paramMiniAppInfo;
      paramContext.mFailedDrawable = paramMiniAppInfo;
      i = ViewUtils.a(12.0F);
      paramContext.mRequestHeight = i;
      paramContext.mRequestWidth = i;
      i = 0;
      while (i < j)
      {
        paramMiniAppInfo = (ImageView)this.friendIconList.get(i);
        paramMiniAppInfo.setVisibility(0);
        localObject2 = URLDrawable.getDrawable(((UseUserInfo)((List)localObject1).get(i)).avatar, paramContext);
        ((URLDrawable)localObject2).setTag(URLDrawableDecodeHandler.a(ViewUtils.a(12.0F), ViewUtils.a(12.0F)));
        ((URLDrawable)localObject2).setDecodeHandler(URLDrawableDecodeHandler.n);
        paramMiniAppInfo.setImageDrawable((Drawable)localObject2);
        i += 1;
      }
      if (j < 3) {
        i = 2;
      }
    }
    else
    {
      while (i >= j)
      {
        ((ImageView)this.friendIconList.get(i)).setVisibility(8);
        i -= 1;
        continue;
        this.friendIconLayout.setVisibility(8);
        this.gap.setVisibility(8);
        if (paramMiniAppInfo.userNum >= 10000)
        {
          paramContext = new StringBuilder();
          paramContext.append(paramMiniAppInfo.userNum % 10000);
          paramContext.append("万");
          paramContext = paramContext.toString();
        }
        else if (paramMiniAppInfo.userNum > 0)
        {
          paramContext = new StringBuilder();
          paramContext.append(paramMiniAppInfo.userNum);
          paramContext.append("");
          paramContext = paramContext.toString();
        }
        else
        {
          paramContext = "1";
        }
        paramMiniAppInfo = this.subtitleView;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramContext);
        ((StringBuilder)localObject1).append("人在玩");
        paramMiniAppInfo.setText(((StringBuilder)localObject1).toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.manager.GameCloseManager.MiniAppViewItem
 * JD-Core Version:    0.7.0.1
 */