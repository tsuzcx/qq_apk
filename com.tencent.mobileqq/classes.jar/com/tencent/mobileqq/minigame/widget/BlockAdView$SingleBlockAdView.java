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
    this.mLayoutInflater.inflate(2131559401, this, true);
    this.mIconView = ((ImageView)findViewById(2131371250));
    this.mNameView = ((TextView)findViewById(2131371251));
    this.mAdIconView = ((ImageView)findViewById(2131371249));
  }
  
  public void setData(MiniAppInfo paramMiniAppInfo, GdtAd paramGdtAd, int paramInt)
  {
    if ((paramMiniAppInfo != null) && (!TextUtils.isEmpty(paramMiniAppInfo.iconUrl)))
    {
      if (TextUtils.isEmpty(paramMiniAppInfo.name)) {
        return;
      }
      int i = 0;
      boolean bool;
      if (paramInt < 3) {
        bool = true;
      } else {
        bool = false;
      }
      this.mShowAdIcon = bool;
      Object localObject = this.mIconView;
      if (localObject != null) {
        ((ImageView)localObject).setImageDrawable(MiniAppUtils.getIcon(this.mContext, paramMiniAppInfo.iconUrl, true, 6));
      }
      localObject = this.mNameView;
      if (localObject != null) {
        ((TextView)localObject).setText(paramMiniAppInfo.name);
      }
      paramMiniAppInfo = this.mAdIconView;
      if (paramMiniAppInfo != null)
      {
        if (this.mShowAdIcon) {
          paramInt = i;
        } else {
          paramInt = 8;
        }
        paramMiniAppInfo.setVisibility(paramInt);
      }
      setOnClickListener(new BlockAdView.SingleBlockAdView.1(this, paramGdtAd));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.widget.BlockAdView.SingleBlockAdView
 * JD-Core Version:    0.7.0.1
 */