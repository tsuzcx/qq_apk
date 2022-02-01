package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.qphone.base.util.QLog;

public abstract class AbsBigEmotionUpdateAdapter
  extends BaseEmotionAdapter
{
  public AbsBigEmotionUpdateAdapter(IEmoticonMainPanelApp paramIEmoticonMainPanelApp, Context paramContext, int paramInt1, int paramInt2, int paramInt3, EmoticonCallback paramEmoticonCallback)
  {
    super(paramIEmoticonMainPanelApp, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonCallback);
  }
  
  public RelativeLayout getBigEmotionContentViewLayout()
  {
    long l = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "getEmotionLayout");
    }
    RelativeLayout localRelativeLayout = new RelativeLayout(this.mContext);
    localRelativeLayout.setLayoutParams(new LinearLayout.LayoutParams(this.widthPixels / this.columnNum, (int)(this.density * 72.0F)));
    Object localObject1 = null;
    try
    {
      localObject2 = new TextView(this.mContext);
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      Object localObject2;
      label79:
      break label79;
    }
    if (localObject1 != null)
    {
      ((TextView)localObject1).setVisibility(8);
      ((TextView)localObject1).setId(2131374392);
      ((TextView)localObject1).setTextColor(this.emoticonTextColor);
      ((TextView)localObject1).setTextSize(11.0F);
      localObject2 = new RelativeLayout.LayoutParams(-1, -2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(12);
      ((RelativeLayout.LayoutParams)localObject2).topMargin = ((int)(this.density * 5.0F));
      ((TextView)localObject1).setGravity(17);
      localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    }
    localObject1 = new URLImageView(this.mContext);
    ((URLImageView)localObject1).setId(2131378202);
    localObject2 = new RelativeLayout.LayoutParams((int)(this.density * 56.0F), (int)(this.density * 56.0F));
    ((RelativeLayout.LayoutParams)localObject2).addRule(13, -1);
    ((RelativeLayout.LayoutParams)localObject2).addRule(2, 2131374392);
    ((RelativeLayout.LayoutParams)localObject2).addRule(14);
    ((URLImageView)localObject1).setVisibility(8);
    ((URLImageView)localObject1).setScaleType(ImageView.ScaleType.FIT_XY);
    ((URLImageView)localObject1).setAdjustViewBounds(false);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject1 = new ImageView(this.mContext);
    ((ImageView)localObject1).setVisibility(8);
    ((ImageView)localObject1).setId(2131374393);
    localObject2 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(7, 2131378202);
    ((RelativeLayout.LayoutParams)localObject2).addRule(8, 2131378202);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    if (AppSetting.d) {
      localRelativeLayout.setFocusable(true);
    }
    if (QLog.isColorLevel())
    {
      localObject1 = TAG;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getEmotionlayout cost = ");
      ((StringBuilder)localObject2).append(System.currentTimeMillis() - l);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    return localRelativeLayout;
  }
  
  public void updateBigEmotionContentViewData(View paramView, EmotionPanelData paramEmotionPanelData)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "updateBigEmotionContentViewData");
    }
    if ((paramView != null) && (paramEmotionPanelData != null))
    {
      paramView.setVisibility(0);
      Object localObject1 = null;
      if ((paramEmotionPanelData instanceof EmoticonInfo)) {
        localObject1 = (EmoticonInfo)paramEmotionPanelData;
      }
      if (localObject1 == null)
      {
        QLog.e(TAG, 1, "emotionInfo = null");
        return;
      }
      paramView.setTag(localObject1);
      paramEmotionPanelData = (URLImageView)paramView.findViewById(2131378202);
      long l = System.currentTimeMillis();
      Object localObject2 = ((EmoticonInfo)localObject1).getDrawable(this.mContext, this.density);
      Object localObject3;
      if (QLog.isColorLevel())
      {
        localObject3 = TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getDrawable cost = ");
        localStringBuilder.append(System.currentTimeMillis() - l);
        QLog.d((String)localObject3, 2, localStringBuilder.toString());
      }
      paramEmotionPanelData.setImageDrawable((Drawable)localObject2);
      paramEmotionPanelData.setVisibility(0);
      if ((localObject1 instanceof PicEmoticonInfo))
      {
        paramEmotionPanelData = (PicEmoticonInfo)localObject1;
        localObject1 = (TextView)paramView.findViewById(2131374392);
        if (paramEmotionPanelData.emoticon != null)
        {
          localObject2 = paramEmotionPanelData.emoticon.name;
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            ((TextView)localObject1).setVisibility(0);
            if (((String)localObject2).length() > 5)
            {
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append(((String)localObject2).substring(0, 4));
              ((StringBuilder)localObject3).append("...");
              ((TextView)localObject1).setText(((StringBuilder)localObject3).toString());
            }
            else
            {
              ((TextView)localObject1).setText((CharSequence)localObject2);
            }
          }
          else
          {
            ((TextView)localObject1).setVisibility(8);
          }
        }
        paramView = (ImageView)paramView.findViewById(2131374393);
        if (paramEmotionPanelData.isSound())
        {
          if (paramEmotionPanelData.isNewSoundType()) {
            paramView.setImageResource(2130846464);
          } else {
            paramView.setImageResource(2130846465);
          }
          paramView.setVisibility(0);
          return;
        }
        paramView.setVisibility(4);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.AbsBigEmotionUpdateAdapter
 * JD-Core Version:    0.7.0.1
 */