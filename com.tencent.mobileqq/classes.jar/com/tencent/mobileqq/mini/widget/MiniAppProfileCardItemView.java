package com.tencent.mobileqq.mini.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;

public class MiniAppProfileCardItemView
  extends LinearLayout
{
  private String mAppid;
  private Context mContext;
  private String mEntryPath;
  private View mGapView;
  private ImageView mIconView;
  private LayoutInflater mLayoutInflater;
  private TextView mNameView;
  
  public MiniAppProfileCardItemView(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public MiniAppProfileCardItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public MiniAppProfileCardItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void init(Context paramContext)
  {
    this.mContext = paramContext;
    this.mLayoutInflater = LayoutInflater.from(paramContext);
    this.mLayoutInflater.inflate(2131495414, this, true);
    this.mIconView = ((ImageView)findViewById(2131304530));
    this.mNameView = ((TextView)findViewById(2131304531));
    this.mGapView = findViewById(2131304527);
  }
  
  public void setData(MiniAppInfo paramMiniAppInfo, int paramInt)
  {
    if ((paramMiniAppInfo == null) || (TextUtils.isEmpty(paramMiniAppInfo.iconUrl)) || (TextUtils.isEmpty(paramMiniAppInfo.name)) || (TextUtils.isEmpty(paramMiniAppInfo.appId))) {
      return;
    }
    if (this.mGapView != null)
    {
      if (paramInt != 0) {
        break label120;
      }
      this.mGapView.setVisibility(8);
    }
    for (;;)
    {
      if (this.mIconView != null) {
        this.mIconView.setImageDrawable(MiniAppUtils.getIcon(this.mContext, paramMiniAppInfo.iconUrl, true));
      }
      if (this.mNameView != null) {
        this.mNameView.setText(paramMiniAppInfo.name);
      }
      this.mAppid = paramMiniAppInfo.appId;
      setOnClickListener(new MiniAppProfileCardItemView.1(this));
      return;
      label120:
      this.mGapView.setVisibility(0);
    }
  }
  
  public void setTextColor(int paramInt)
  {
    if (this.mNameView != null) {
      this.mNameView.setTextColor(paramInt);
    }
  }
  
  public void setTextColor(ColorStateList paramColorStateList)
  {
    if (this.mNameView != null) {
      this.mNameView.setTextColor(paramColorStateList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.MiniAppProfileCardItemView
 * JD-Core Version:    0.7.0.1
 */