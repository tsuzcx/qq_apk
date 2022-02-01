package com.tencent.mobileqq.minigame.manager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;

class GameCloseManager$MiniAppPatitionLineViewItem
{
  private Context context;
  private ImageView imageView;
  private View root;
  
  public GameCloseManager$MiniAppPatitionLineViewItem(Context paramContext)
  {
    this.context = paramContext;
    this.root = LayoutInflater.from(paramContext).inflate(2131559406, null, false);
    this.imageView = ((ImageView)this.root.findViewById(2131371378));
    this.imageView.setImageDrawable(MiniAppUtils.getDrawable("https://sola.gtimg.cn/aoi/sola/20201023111054_uqFoOMu1gx.png", null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.manager.GameCloseManager.MiniAppPatitionLineViewItem
 * JD-Core Version:    0.7.0.1
 */