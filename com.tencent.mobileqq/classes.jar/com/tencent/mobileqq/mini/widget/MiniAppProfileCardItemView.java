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
    this.mLayoutInflater.inflate(2131561352, this, true);
    this.mIconView = ((ImageView)findViewById(2131371130));
    this.mNameView = ((TextView)findViewById(2131371131));
    this.mGapView = findViewById(2131371127);
  }
  
  public void setData(MiniAppInfo paramMiniAppInfo, int paramInt)
  {
    if ((paramMiniAppInfo != null) && (!TextUtils.isEmpty(paramMiniAppInfo.iconUrl)) && (!TextUtils.isEmpty(paramMiniAppInfo.name)))
    {
      if (TextUtils.isEmpty(paramMiniAppInfo.appId)) {
        return;
      }
      Object localObject = this.mGapView;
      if (localObject != null) {
        if (paramInt == 0) {
          ((View)localObject).setVisibility(8);
        } else {
          ((View)localObject).setVisibility(0);
        }
      }
      localObject = this.mIconView;
      if (localObject != null) {
        ((ImageView)localObject).setImageDrawable(MiniAppUtils.getIcon(this.mContext, paramMiniAppInfo.iconUrl, true));
      }
      localObject = this.mNameView;
      if (localObject != null) {
        ((TextView)localObject).setText(paramMiniAppInfo.name);
      }
      this.mAppid = paramMiniAppInfo.appId;
      setOnClickListener(new MiniAppProfileCardItemView.1(this));
    }
  }
  
  public void setTextColor(int paramInt)
  {
    TextView localTextView = this.mNameView;
    if (localTextView != null) {
      localTextView.setTextColor(paramInt);
    }
  }
  
  public void setTextColor(ColorStateList paramColorStateList)
  {
    TextView localTextView = this.mNameView;
    if (localTextView != null) {
      localTextView.setTextColor(paramColorStateList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.MiniAppProfileCardItemView
 * JD-Core Version:    0.7.0.1
 */