package com.tencent.mobileqq.minigame.manager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import bjuk;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.widget.ThemeImageView;

class GameCloseManager$MiniAppViewItem
{
  private Context context;
  private ImageView imageView;
  private View root;
  private TextView textView;
  
  public GameCloseManager$MiniAppViewItem(Context paramContext)
  {
    this.context = paramContext;
    this.root = LayoutInflater.from(paramContext).inflate(2131559430, null, false);
    this.imageView = ((ImageView)this.root.findViewById(2131371255));
    if ((this.imageView instanceof ThemeImageView)) {
      ((ThemeImageView)this.imageView).setMaskShape(bjuk.c);
    }
    this.textView = ((TextView)this.root.findViewById(2131371256));
  }
  
  public void setData(MiniAppInfo paramMiniAppInfo, View.OnClickListener paramOnClickListener)
  {
    this.imageView.setImageDrawable(MiniAppUtils.getIcon(this.context, paramMiniAppInfo.iconUrl, true));
    this.textView.setVisibility(0);
    this.textView.setText(paramMiniAppInfo.name);
    this.root.setOnClickListener(paramOnClickListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.manager.GameCloseManager.MiniAppViewItem
 * JD-Core Version:    0.7.0.1
 */