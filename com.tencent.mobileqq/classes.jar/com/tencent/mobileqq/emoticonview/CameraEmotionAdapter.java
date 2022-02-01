package com.tencent.mobileqq.emoticonview;

import amtj;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import bcef;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.List;

public class CameraEmotionAdapter
  extends BaseEmotionAdapter
{
  public static final int CONTENT_HEIGHT = 61;
  public static final int ERROR_ICON_HEIGHT_OFFSET = 5;
  public static final int GUIDE_HEIGHT = 199;
  public static final int GUIDE_IMG_HEIGHT = 127;
  public static final int GUIDE_IMG_WIDTH = 161;
  public static final int IMG_HEIGHT = 56;
  public static final String TAG = "CameraEmotionAdapter";
  BaseChatPie mBaseChatPie;
  private Drawable mCameraPanelFailedDrawable = BaseApplication.getContext().getResources().getDrawable(2130838047);
  public EmoticonPanelLinearLayout.OnClickListener mInterceptListener = new CameraEmotionAdapter.1(this);
  
  public CameraEmotionAdapter(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2, int paramInt3, EmoticonCallback paramEmoticonCallback, BaseChatPie paramBaseChatPie)
  {
    super(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonCallback);
    this.mBaseChatPie = paramBaseChatPie;
  }
  
  private RelativeLayout getCameraEmoView()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CameraEmotionAdapter", 2, "getCameraEmoView");
    }
    RelativeLayout localRelativeLayout = new RelativeLayout(this.mContext);
    localRelativeLayout.setLayoutParams(new LinearLayout.LayoutParams(this.widthPixels / this.columnNum, (int)(61.0F * this.density)));
    Object localObject = new URLImageView(this.mContext);
    ((URLImageView)localObject).setId(2131365977);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams((int)(this.density * 56.0F), (int)(this.density * 56.0F));
    localLayoutParams.addRule(13, -1);
    localLayoutParams.addRule(12, -1);
    localLayoutParams.setMargins(0, 0, 0, (int)(5.0F * this.density));
    ((URLImageView)localObject).setScaleType(ImageView.ScaleType.FIT_XY);
    ((URLImageView)localObject).setAdjustViewBounds(false);
    localRelativeLayout.addView((View)localObject, localLayoutParams);
    localObject = new ImageView(this.mContext);
    ((ImageView)localObject).setId(2131365978);
    localLayoutParams = new RelativeLayout.LayoutParams((int)(this.density * 56.0F), (int)(this.density * 56.0F));
    localLayoutParams.addRule(13, -1);
    localLayoutParams.addRule(12, -1);
    localLayoutParams.setMargins(0, 0, 0, (int)(5.0F * this.density));
    ((ImageView)localObject).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    ((ImageView)localObject).setAdjustViewBounds(false);
    ((ImageView)localObject).setVisibility(8);
    localRelativeLayout.addView((View)localObject, localLayoutParams);
    localObject = new ImageView(this.mContext);
    ((ImageView)localObject).setId(2131365983);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    ((ImageView)localObject).setBackgroundResource(2130838021);
    localLayoutParams.addRule(7, 2131365977);
    localLayoutParams.addRule(8, 2131365977);
    localLayoutParams.setMargins(0, 0, (int)(-5.0F * this.density), (int)(-5.0F * this.density));
    localRelativeLayout.addView((View)localObject, localLayoutParams);
    ((ImageView)localObject).setVisibility(8);
    if (AppSetting.c) {
      localRelativeLayout.setFocusable(true);
    }
    return localRelativeLayout;
  }
  
  private RelativeLayout getGuideView()
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(this.mContext);
    localRelativeLayout.setLayoutParams(new LinearLayout.LayoutParams(this.widthPixels / this.columnNum * (this.columnNum - 2), (int)(199.0F * this.density)));
    Object localObject = new URLImageView(this.mContext);
    ((URLImageView)localObject).setId(2131365977);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams((int)(161.0F * this.density), (int)(127.0F * this.density));
    localLayoutParams.addRule(13, -1);
    ((URLImageView)localObject).setScaleType(ImageView.ScaleType.FIT_XY);
    ((URLImageView)localObject).setAdjustViewBounds(false);
    localRelativeLayout.addView((View)localObject, localLayoutParams);
    localObject = new TextView(this.mContext);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    ((TextView)localObject).setText(amtj.a(2131700456));
    ((TextView)localObject).setTextSize(ViewUtils.dpToPx(12.0F));
    ((TextView)localObject).setTextColor(-8947849);
    localLayoutParams.addRule(14, -1);
    localLayoutParams.addRule(3, 2131365977);
    return localRelativeLayout;
  }
  
  private void updateEmoticonDrawable(URLImageView paramURLImageView, ImageView paramImageView)
  {
    URLDrawable localURLDrawable = (URLDrawable)paramURLImageView.getBackground();
    if (localURLDrawable.getStatus() == 0)
    {
      paramURLImageView.setVisibility(8);
      paramImageView.setVisibility(0);
      if (!localURLDrawable.isDownloadStarted()) {
        localURLDrawable.startDownload();
      }
      if (!(paramImageView.getDrawable() instanceof Animatable)) {
        paramImageView.setImageDrawable((Drawable)BaseApplication.getContext().getResources().getDrawable(2130839445));
      }
      paramURLImageView = (Animatable)paramImageView.getDrawable();
      if (!paramURLImageView.isRunning()) {
        paramURLImageView.start();
      }
      return;
    }
    if ((localURLDrawable.getStatus() == 2) || (localURLDrawable.getStatus() == 3))
    {
      paramURLImageView.setVisibility(8);
      paramImageView.setVisibility(0);
      if ((paramImageView.getDrawable() instanceof Animatable)) {
        ((Animatable)paramImageView.getDrawable()).stop();
      }
      paramImageView.setImageDrawable(this.mCameraPanelFailedDrawable);
      return;
    }
    paramURLImageView.setVisibility(0);
    paramImageView.setVisibility(8);
  }
  
  private void updateUI(View paramView, EmotionPanelData paramEmotionPanelData)
  {
    if ((paramView == null) || (!(paramEmotionPanelData instanceof CameraEmoticonInfo))) {
      QLog.e("CameraEmotionAdapter", 1, "emotionInfo or contentView = null");
    }
    for (;;)
    {
      return;
      Object localObject = (URLImageView)paramView.findViewById(2131365977);
      CameraEmoticonInfo localCameraEmoticonInfo = (CameraEmoticonInfo)paramEmotionPanelData;
      paramView.setTag(localCameraEmoticonInfo);
      paramView.setVisibility(0);
      if ((QLog.isColorLevel()) && (!StringUtil.isEmpty(localCameraEmoticonInfo.action))) {
        QLog.d("CameraEmotionAdapter", 2, "updateUI info = " + localCameraEmoticonInfo.action);
      }
      if (((URLImageView)localObject).getTag(2131380831) != paramEmotionPanelData)
      {
        ((URLImageView)localObject).setTag(2131380831, paramEmotionPanelData);
        paramEmotionPanelData = (ImageView)paramView.findViewById(2131365978);
        paramView = (ImageView)paramView.findViewById(2131365983);
        ((URLImageView)localObject).setVisibility(0);
        ((URLImageView)localObject).setURLDrawableDownListener(null);
        if ("cameraEdit".equals(localCameraEmoticonInfo.action))
        {
          ((URLImageView)localObject).setImageDrawable(null);
          ((URLImageView)localObject).setBackgroundResource(2130847027);
          paramEmotionPanelData.setVisibility(4);
          paramView.setVisibility(4);
          if (AppSetting.c) {
            ((URLImageView)localObject).setContentDescription(amtj.a(2131700457));
          }
        }
        else if ("cameraJump".equals(localCameraEmoticonInfo.action))
        {
          ((URLImageView)localObject).setImageDrawable(null);
          ((URLImageView)localObject).setBackgroundResource(2130838025);
          paramEmotionPanelData.setVisibility(4);
          paramView.setVisibility(4);
          if (AppSetting.c) {
            ((URLImageView)localObject).setContentDescription(amtj.a(2131700454));
          }
        }
        else
        {
          Drawable localDrawable = localCameraEmoticonInfo.getDrawable(this.mContext, this.density);
          ((URLImageView)localObject).setBackgroundDrawable(localDrawable);
          if (localCameraEmoticonInfo.roamingType.equals("needUpload"))
          {
            ((URLImageView)localObject).setImageDrawable(new ColorDrawable(-419430401));
            localObject = (Animatable)BaseApplication.getContext().getResources().getDrawable(2130839445);
            paramEmotionPanelData.setImageDrawable((Drawable)localObject);
            ((Animatable)localObject).start();
            paramEmotionPanelData.setVisibility(0);
            paramView.setVisibility(4);
          }
          while (!TextUtils.isEmpty(localCameraEmoticonInfo.eId))
          {
            bcef.b(this.app, "dc00898", "", "", "0X800A370", "0X800A370", 0, 0, "", "", localCameraEmoticonInfo.eId, "");
            return;
            if (localCameraEmoticonInfo.roamingType.equals("failed"))
            {
              ((URLImageView)localObject).setImageDrawable(new ColorDrawable(-419430401));
              paramEmotionPanelData.setVisibility(4);
              paramView.setVisibility(0);
            }
            else
            {
              ((URLImageView)localObject).setImageDrawable(null);
              paramEmotionPanelData.setVisibility(4);
              paramView.setVisibility(4);
              if ((localDrawable instanceof URLDrawable))
              {
                ((URLImageView)localObject).setURLDrawableDownListener(new CameraEmotionAdapter.2(this, localCameraEmoticonInfo, (URLImageView)localObject, paramEmotionPanelData));
                updateEmoticonDrawable((URLImageView)localObject, paramEmotionPanelData);
              }
            }
          }
        }
      }
    }
  }
  
  public View getEmotionView(BaseEmotionAdapter.ViewHolder paramViewHolder, int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int j = 0;
    boolean bool;
    if (QLog.isColorLevel())
    {
      paramViewGroup = new StringBuilder().append("getEmotionView position = ").append(paramInt).append(" convertView NULL is ");
      if (paramView == null)
      {
        bool = true;
        QLog.d("CameraEmotionAdapter", 2, bool);
      }
    }
    else
    {
      paramViewGroup = (CameraEmotionAdapter.CameraEmotionViewHolder)paramViewHolder;
      if (paramView != null) {
        break label409;
      }
      if (QLog.isColorLevel()) {
        QLog.d("CameraEmotionAdapter", 2, "getEmotionView position = " + paramInt + "; view from inflater");
      }
      paramViewHolder = new EmoticonPanelLinearLayout(this.mContext, this.mBaseChatPie, -1);
      paramViewHolder.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
      paramViewHolder.setOrientation(0);
      if (paramInt != 0) {
        break label217;
      }
    }
    label217:
    for (int i = 16;; i = 14)
    {
      paramViewHolder.setPadding(0, (int)(i * this.density), 0, 0);
      i = 0;
      while (i < this.columnNum)
      {
        paramView = getCameraEmoView();
        paramView.setVisibility(8);
        paramView.setFocusable(true);
        paramView.setFocusableInTouchMode(true);
        paramViewHolder.addView(paramView);
        i += 1;
      }
      bool = false;
      break;
    }
    paramViewHolder.mClickListener = this.mInterceptListener;
    ((EmoticonPanelLinearLayout)paramViewHolder).setCallBack(this.callback);
    paramView = (ViewGroup)paramViewHolder;
    paramViewGroup.contentViews = new RelativeLayout[this.columnNum];
    i = 0;
    while (i < this.columnNum)
    {
      paramViewGroup.contentViews[i] = ((RelativeLayout)paramView.getChildAt(i));
      i += 1;
    }
    paramViewHolder.setTag(paramViewGroup);
    i = j;
    for (;;)
    {
      if (i < this.columnNum)
      {
        j = this.columnNum * paramInt + i;
        if (j > this.data.size() - 1)
        {
          paramViewGroup.contentViews[i].setTag(null);
          paramViewGroup.contentViews[i].setVisibility(8);
        }
        for (;;)
        {
          i += 1;
          break;
          updateUI(paramViewGroup.contentViews[i], (EmotionPanelData)this.data.get(j));
        }
      }
      return paramViewHolder;
      label409:
      paramViewHolder = paramView;
      i = j;
    }
  }
  
  public BaseEmotionAdapter.ViewHolder newHolder()
  {
    return new CameraEmotionAdapter.CameraEmotionViewHolder();
  }
  
  public void refreshPanelData()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CameraEmotionAdapter", 2, "refreshPanelData");
    }
    EmotionPanelDataBuilder localEmotionPanelDataBuilder = EmotionPanelDataBuilder.getInstance();
    QQAppInterface localQQAppInterface = this.app;
    int j = this.panelType;
    if (this.mBaseChatPie != null) {}
    for (int i = this.mBaseChatPie.getSessionInfo().curType;; i = -1)
    {
      localEmotionPanelDataBuilder.AsyncGetEmotionPanelData(localQQAppInterface, j, null, -1, i, false, new CameraEmotionAdapter.3(this));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.CameraEmotionAdapter
 * JD-Core Version:    0.7.0.1
 */