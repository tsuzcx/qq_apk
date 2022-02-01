package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
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
    localRelativeLayout.setLayoutParams(new LinearLayout.LayoutParams(this.widthPixels / this.columnNum, (int)(72.0F * this.density)));
    try
    {
      Object localObject1 = new TextView(this.mContext);
      if (localObject1 != null)
      {
        ((TextView)localObject1).setVisibility(8);
        ((TextView)localObject1).setId(2131374858);
        ((TextView)localObject1).setTextColor(this.emoticonTextColor);
        ((TextView)localObject1).setTextSize(11.0F);
        localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
        localLayoutParams.addRule(12);
        localLayoutParams.topMargin = ((int)(5.0F * this.density));
        ((TextView)localObject1).setGravity(17);
        localRelativeLayout.addView((View)localObject1, localLayoutParams);
      }
      localObject1 = new URLImageView(this.mContext);
      ((URLImageView)localObject1).setId(2131378813);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams((int)(this.density * 56.0F), (int)(this.density * 56.0F));
      localLayoutParams.addRule(13, -1);
      localLayoutParams.addRule(2, 2131374858);
      localLayoutParams.addRule(14);
      ((URLImageView)localObject1).setVisibility(8);
      ((URLImageView)localObject1).setScaleType(ImageView.ScaleType.FIT_XY);
      ((URLImageView)localObject1).setAdjustViewBounds(false);
      localRelativeLayout.addView((View)localObject1, localLayoutParams);
      localObject1 = new ImageView(this.mContext);
      ((ImageView)localObject1).setVisibility(8);
      ((ImageView)localObject1).setId(2131374859);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(7, 2131378813);
      localLayoutParams.addRule(8, 2131378813);
      localRelativeLayout.addView((View)localObject1, localLayoutParams);
      if (AppSetting.d) {
        localRelativeLayout.setFocusable(true);
      }
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "getEmotionlayout cost = " + (System.currentTimeMillis() - l));
      }
      return localRelativeLayout;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject2 = null;
      }
    }
  }
  
  public void updateBigEmotionContentViewData(View paramView, EmotionPanelData paramEmotionPanelData)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "updateBigEmotionContentViewData");
    }
    if ((paramView != null) && (paramEmotionPanelData != null))
    {
      paramView.setVisibility(0);
      localObject1 = null;
      if ((paramEmotionPanelData instanceof EmoticonInfo)) {
        localObject1 = (EmoticonInfo)paramEmotionPanelData;
      }
      if (localObject1 != null) {
        break label59;
      }
      QLog.e(TAG, 1, "emotionInfo = null");
    }
    label59:
    Object localObject2;
    do
    {
      return;
      paramView.setTag(localObject1);
      paramEmotionPanelData = (URLImageView)paramView.findViewById(2131378813);
      long l = System.currentTimeMillis();
      localObject2 = ((EmoticonInfo)localObject1).getDrawable(this.mContext, this.density);
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "getDrawable cost = " + (System.currentTimeMillis() - l));
      }
      paramEmotionPanelData.setImageDrawable((Drawable)localObject2);
      paramEmotionPanelData.setVisibility(0);
    } while (!(localObject1 instanceof PicEmoticonInfo));
    paramEmotionPanelData = (PicEmoticonInfo)localObject1;
    Object localObject1 = (TextView)paramView.findViewById(2131374858);
    if (paramEmotionPanelData.emoticon != null)
    {
      localObject2 = paramEmotionPanelData.emoticon.name;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        break label281;
      }
      ((TextView)localObject1).setVisibility(0);
      if (((String)localObject2).length() > 5) {
        ((TextView)localObject1).setText(((String)localObject2).substring(0, 4) + "...");
      }
    }
    else
    {
      paramView = (ImageView)paramView.findViewById(2131374859);
      if (!paramEmotionPanelData.isSound()) {
        break label300;
      }
      if (!paramEmotionPanelData.isNewSoundType()) {
        break label291;
      }
      paramView.setImageResource(2130846584);
    }
    for (;;)
    {
      paramView.setVisibility(0);
      return;
      ((TextView)localObject1).setText((CharSequence)localObject2);
      break;
      label281:
      ((TextView)localObject1).setVisibility(8);
      break;
      label291:
      paramView.setImageResource(2130846585);
    }
    label300:
    paramView.setVisibility(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.AbsBigEmotionUpdateAdapter
 * JD-Core Version:    0.7.0.1
 */