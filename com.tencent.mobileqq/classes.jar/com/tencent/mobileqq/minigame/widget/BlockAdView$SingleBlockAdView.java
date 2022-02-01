package com.tencent.mobileqq.minigame.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;

class BlockAdView$SingleBlockAdView
  extends RelativeLayout
{
  private ImageView mAdIconView;
  private String mAppid;
  private Context mContext;
  private ImageView mIconView;
  private LayoutInflater mLayoutInflater;
  private TextView mNameView;
  private boolean mShowAdIcon;
  
  public BlockAdView$SingleBlockAdView(BlockAdView paramBlockAdView, Context paramContext, AttributeSet paramAttributeSet, int paramInt, boolean paramBoolean)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initUI(paramContext);
    this.mShowAdIcon = paramBoolean;
  }
  
  public BlockAdView$SingleBlockAdView(BlockAdView paramBlockAdView, Context paramContext, AttributeSet paramAttributeSet, boolean paramBoolean)
  {
    this(paramBlockAdView, paramContext, paramAttributeSet, 0, paramBoolean);
  }
  
  public BlockAdView$SingleBlockAdView(BlockAdView paramBlockAdView, Context paramContext, boolean paramBoolean)
  {
    this(paramBlockAdView, paramContext, null, 0, paramBoolean);
  }
  
  private void initUI(Context paramContext)
  {
    this.mContext = paramContext;
    this.mLayoutInflater = LayoutInflater.from(paramContext);
    this.mLayoutInflater.inflate(2131559459, this, true);
    this.mIconView = ((ImageView)findViewById(2131371350));
    this.mNameView = ((TextView)findViewById(2131371351));
    this.mAdIconView = ((ImageView)findViewById(2131371349));
  }
  
  public void setData(MiniAppInfo paramMiniAppInfo, GdtAd paramGdtAd, int paramInt)
  {
    int i = 0;
    if ((paramMiniAppInfo == null) || (TextUtils.isEmpty(paramMiniAppInfo.iconUrl)) || (TextUtils.isEmpty(paramMiniAppInfo.name))) {
      return;
    }
    boolean bool;
    if (paramInt < 3)
    {
      bool = true;
      this.mShowAdIcon = bool;
      if (this.mIconView != null) {
        this.mIconView.setImageDrawable(MiniAppUtils.getIcon(this.mContext, paramMiniAppInfo.iconUrl, true, 6));
      }
      if (this.mNameView != null) {
        this.mNameView.setText(paramMiniAppInfo.name);
      }
      if (this.mAdIconView != null)
      {
        paramMiniAppInfo = this.mAdIconView;
        if (!this.mShowAdIcon) {
          break label135;
        }
      }
    }
    label135:
    for (paramInt = i;; paramInt = 8)
    {
      paramMiniAppInfo.setVisibility(paramInt);
      setOnClickListener(new BlockAdView.SingleBlockAdView.1(this, paramGdtAd));
      return;
      bool = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.widget.BlockAdView.SingleBlockAdView
 * JD-Core Version:    0.7.0.1
 */