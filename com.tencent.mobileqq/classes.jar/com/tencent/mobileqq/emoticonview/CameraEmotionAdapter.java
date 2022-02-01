package com.tencent.mobileqq.emoticonview;

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
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.AIODepend.IPanelInteractionListener;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseAIOContext;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.emoticon.IEmotionPanelDataCallback;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.List;

public class CameraEmotionAdapter
  extends BaseEmotionAdapter
  implements IEmotionPanelDataCallback<EmotionPanelData>
{
  public static final int CONTENT_HEIGHT = 61;
  public static final int ERROR_ICON_HEIGHT_OFFSET = 5;
  public static final int GUIDE_HEIGHT = 199;
  public static final int GUIDE_IMG_HEIGHT = 127;
  public static final int GUIDE_IMG_WIDTH = 161;
  public static final int IMG_HEIGHT = 56;
  public static final String TAG = "CameraEmotionAdapter";
  private BaseAIOContext mAIOContext;
  private Drawable mCameraPanelFailedDrawable = null;
  private IPanelInteractionListener mInteractionListener;
  public IEmoticonPanelLinearLayoutHelper.OnClickListener mInterceptListener = new CameraEmotionAdapter.1(this);
  
  public CameraEmotionAdapter(IEmoticonMainPanelApp paramIEmoticonMainPanelApp, IPanelInteractionListener paramIPanelInteractionListener, Context paramContext, int paramInt1, int paramInt2, int paramInt3, EmoticonCallback paramEmoticonCallback)
  {
    super(paramIEmoticonMainPanelApp, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonCallback);
    this.mInteractionListener = paramIPanelInteractionListener;
    paramIEmoticonMainPanelApp = this.mInteractionListener;
    if (paramIEmoticonMainPanelApp != null) {
      this.mAIOContext = paramIEmoticonMainPanelApp.getAIOContext();
    }
    this.mCameraPanelFailedDrawable = paramContext.getResources().getDrawable(2130847919);
  }
  
  private RelativeLayout getCameraEmoView()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CameraEmotionAdapter", 2, "getCameraEmoView");
    }
    RelativeLayout localRelativeLayout = new RelativeLayout(this.mContext);
    localRelativeLayout.setLayoutParams(new LinearLayout.LayoutParams(this.widthPixels / this.columnNum, (int)(this.density * 61.0F)));
    Object localObject = new URLImageView(this.mContext);
    ((URLImageView)localObject).setId(2131446720);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams((int)(this.density * 56.0F), (int)(this.density * 56.0F));
    localLayoutParams.addRule(13, -1);
    localLayoutParams.addRule(12, -1);
    localLayoutParams.setMargins(0, 0, 0, (int)(this.density * 5.0F));
    ((URLImageView)localObject).setScaleType(ImageView.ScaleType.FIT_XY);
    ((URLImageView)localObject).setAdjustViewBounds(false);
    localRelativeLayout.addView((View)localObject, localLayoutParams);
    localObject = new ImageView(this.mContext);
    ((ImageView)localObject).setId(2131442557);
    localLayoutParams = new RelativeLayout.LayoutParams((int)(this.density * 56.0F), (int)(this.density * 56.0F));
    localLayoutParams.addRule(13, -1);
    localLayoutParams.addRule(12, -1);
    localLayoutParams.setMargins(0, 0, 0, (int)(this.density * 5.0F));
    ((ImageView)localObject).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    ((ImageView)localObject).setAdjustViewBounds(false);
    ((ImageView)localObject).setVisibility(8);
    localRelativeLayout.addView((View)localObject, localLayoutParams);
    localObject = new ImageView(this.mContext);
    ((ImageView)localObject).setId(2131442559);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    ((ImageView)localObject).setBackgroundResource(2130847914);
    localLayoutParams.addRule(7, 2131446720);
    localLayoutParams.addRule(8, 2131446720);
    localLayoutParams.setMargins(0, 0, (int)(this.density * -5.0F), (int)(this.density * -5.0F));
    localRelativeLayout.addView((View)localObject, localLayoutParams);
    ((ImageView)localObject).setVisibility(8);
    if (AppSetting.e) {
      localRelativeLayout.setFocusable(true);
    }
    return localRelativeLayout;
  }
  
  private RelativeLayout getGuideView()
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(this.mContext);
    localRelativeLayout.setLayoutParams(new LinearLayout.LayoutParams(this.widthPixels / this.columnNum * (this.columnNum - 2), (int)(this.density * 199.0F)));
    Object localObject = new URLImageView(this.mContext);
    ((URLImageView)localObject).setId(2131446720);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams((int)(this.density * 161.0F), (int)(this.density * 127.0F));
    localLayoutParams.addRule(13, -1);
    ((URLImageView)localObject).setScaleType(ImageView.ScaleType.FIT_XY);
    ((URLImageView)localObject).setAdjustViewBounds(false);
    localRelativeLayout.addView((View)localObject, localLayoutParams);
    localObject = new TextView(this.mContext);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    ((TextView)localObject).setText(HardCodeUtil.a(2131897749));
    ((TextView)localObject).setTextSize(ViewUtils.dpToPx(12.0F));
    ((TextView)localObject).setTextColor(-8947849);
    localLayoutParams.addRule(14, -1);
    localLayoutParams.addRule(3, 2131446720);
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
        paramImageView.setImageDrawable((Drawable)paramURLImageView.getContext().getResources().getDrawable(2130847934));
      }
      paramURLImageView = (Animatable)paramImageView.getDrawable();
      if (!paramURLImageView.isRunning()) {
        paramURLImageView.start();
      }
    }
    else
    {
      if ((localURLDrawable.getStatus() != 2) && (localURLDrawable.getStatus() != 3))
      {
        paramURLImageView.setVisibility(0);
        paramImageView.setVisibility(8);
        return;
      }
      paramURLImageView.setVisibility(8);
      paramImageView.setVisibility(0);
      if ((paramImageView.getDrawable() instanceof Animatable)) {
        ((Animatable)paramImageView.getDrawable()).stop();
      }
      paramImageView.setImageDrawable(this.mCameraPanelFailedDrawable);
    }
  }
  
  private void updateUI(View paramView, EmotionPanelData paramEmotionPanelData)
  {
    if ((paramView != null) && ((paramEmotionPanelData instanceof CameraEmoticonInfo)))
    {
      Object localObject1 = (URLImageView)paramView.findViewById(2131446720);
      CameraEmoticonInfo localCameraEmoticonInfo = (CameraEmoticonInfo)paramEmotionPanelData;
      paramView.setTag(localCameraEmoticonInfo);
      paramView.setVisibility(0);
      Object localObject2;
      if ((QLog.isColorLevel()) && (!StringUtil.isEmpty(localCameraEmoticonInfo.action)))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("updateUI info = ");
        ((StringBuilder)localObject2).append(localCameraEmoticonInfo.action);
        QLog.d("CameraEmotionAdapter", 2, ((StringBuilder)localObject2).toString());
      }
      if (((URLImageView)localObject1).getTag(2131442565) == paramEmotionPanelData) {
        return;
      }
      ((URLImageView)localObject1).setTag(2131442565, paramEmotionPanelData);
      paramEmotionPanelData = (ImageView)paramView.findViewById(2131442557);
      paramView = (ImageView)paramView.findViewById(2131442559);
      ((URLImageView)localObject1).setVisibility(0);
      ((URLImageView)localObject1).setURLDrawableDownListener(null);
      if ("cameraEdit".equals(localCameraEmoticonInfo.action))
      {
        ((URLImageView)localObject1).setImageDrawable(null);
        ((URLImageView)localObject1).setBackgroundResource(2130847925);
        paramEmotionPanelData.setVisibility(4);
        paramView.setVisibility(4);
        if (AppSetting.e) {
          ((URLImageView)localObject1).setContentDescription(HardCodeUtil.a(2131897750));
        }
      }
      else if ("cameraJump".equals(localCameraEmoticonInfo.action))
      {
        ((URLImageView)localObject1).setImageDrawable(null);
        ((URLImageView)localObject1).setBackgroundResource(2130847915);
        paramEmotionPanelData.setVisibility(4);
        paramView.setVisibility(4);
        if (AppSetting.e) {
          ((URLImageView)localObject1).setContentDescription(HardCodeUtil.a(2131897751));
        }
      }
      else
      {
        localObject2 = localCameraEmoticonInfo.getDrawable(this.mContext, this.density);
        ((URLImageView)localObject1).setBackgroundDrawable((Drawable)localObject2);
        if (localCameraEmoticonInfo.roamingType.equals("needUpload"))
        {
          ((URLImageView)localObject1).setImageDrawable(new ColorDrawable(-419430401));
          localObject1 = (Animatable)this.mContext.getResources().getDrawable(2130847934);
          paramEmotionPanelData.setImageDrawable((Drawable)localObject1);
          ((Animatable)localObject1).start();
          paramEmotionPanelData.setVisibility(0);
          paramView.setVisibility(4);
        }
        else if (localCameraEmoticonInfo.roamingType.equals("failed"))
        {
          ((URLImageView)localObject1).setImageDrawable(new ColorDrawable(-419430401));
          paramEmotionPanelData.setVisibility(4);
          paramView.setVisibility(0);
        }
        else
        {
          ((URLImageView)localObject1).setImageDrawable(null);
          paramEmotionPanelData.setVisibility(4);
          paramView.setVisibility(4);
          if ((localObject2 instanceof URLDrawable))
          {
            ((URLImageView)localObject1).setURLDrawableDownListener(new CameraEmotionAdapter.2(this, localCameraEmoticonInfo, (URLImageView)localObject1, paramEmotionPanelData));
            updateEmoticonDrawable((URLImageView)localObject1, paramEmotionPanelData);
          }
        }
        if (!TextUtils.isEmpty(localCameraEmoticonInfo.eId)) {
          ReportController.b(this.app.getQQAppInterface(), "dc00898", "", "", "0X800A370", "0X800A370", 0, 0, "", "", localCameraEmoticonInfo.eId, "");
        }
      }
      return;
    }
    QLog.e("CameraEmotionAdapter", 1, "emotionInfo or contentView = null");
  }
  
  public void callbackInMainThread(List<EmotionPanelData> paramList)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("refreshPanelData call back dataList = ");
      Object localObject;
      if (paramList == null) {
        localObject = "null";
      } else {
        localObject = Integer.valueOf(paramList.size());
      }
      localStringBuilder.append(localObject);
      QLog.d("CameraEmotionAdapter", 2, localStringBuilder.toString());
    }
    if (paramList != null)
    {
      setData(paramList);
      notifyDataSetChanged();
    }
  }
  
  public View getEmotionView(BaseEmotionAdapter.ViewHolder paramViewHolder, int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    boolean bool = QLog.isColorLevel();
    int j = 0;
    if (bool)
    {
      paramViewGroup = new StringBuilder();
      paramViewGroup.append("getEmotionView position = ");
      paramViewGroup.append(paramInt);
      paramViewGroup.append(" convertView NULL is ");
      if (paramView == null) {
        bool = true;
      } else {
        bool = false;
      }
      paramViewGroup.append(bool);
      QLog.d("CameraEmotionAdapter", 2, paramViewGroup.toString());
    }
    paramViewGroup = (CameraEmotionAdapter.CameraEmotionViewHolder)paramViewHolder;
    int i = j;
    paramViewHolder = paramView;
    if (paramView == null)
    {
      if (QLog.isColorLevel())
      {
        paramViewHolder = new StringBuilder();
        paramViewHolder.append("getEmotionView position = ");
        paramViewHolder.append(paramInt);
        paramViewHolder.append("; view from inflater");
        QLog.d("CameraEmotionAdapter", 2, paramViewHolder.toString());
      }
      paramViewHolder = new EmoticonPanelLinearLayout(this.mContext, new QQEmoticonPanelLinearLayoutHelper(this.mContext, this.mInteractionListener), -1);
      paramViewHolder.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
      paramViewHolder.setOrientation(0);
      if (paramInt == 0) {
        i = 16;
      } else {
        i = 14;
      }
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
      paramViewHolder.setInterceptListener(this.mInterceptListener);
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
    }
    while (i < this.columnNum)
    {
      j = this.columnNum * paramInt + i;
      if (j > this.data.size() - 1)
      {
        paramViewGroup.contentViews[i].setTag(null);
        paramViewGroup.contentViews[i].setVisibility(8);
      }
      else
      {
        updateUI(paramViewGroup.contentViews[i], (EmotionPanelData)this.data.get(j));
      }
      i += 1;
    }
    return paramViewHolder;
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
    IEmoticonMainPanelApp localIEmoticonMainPanelApp = this.app;
    int j = this.panelType;
    BaseAIOContext localBaseAIOContext = this.mAIOContext;
    int i;
    if (localBaseAIOContext != null) {
      i = localBaseAIOContext.O().a;
    } else {
      i = -1;
    }
    localEmotionPanelDataBuilder.asyncGetEmotionPanelData(localIEmoticonMainPanelApp, j, null, -1, i, false, this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.CameraEmotionAdapter
 * JD-Core Version:    0.7.0.1
 */