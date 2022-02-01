package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.AIODepend.IPanelInteractionListener;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseAIOContext;
import com.tencent.mobileqq.emosm.api.IFavroamingManagerService;
import com.tencent.mobileqq.emoticon.IEmotionPanelDataCallback;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.List;
import mqq.app.AppRuntime;

public class FavoriteEmotionAdapter
  extends BaseEmotionAdapter
  implements View.OnClickListener, IEmotionPanelDataCallback<EmotionPanelData>
{
  public static final int CONTENT_HEIGHT = 61;
  public static final int ERROR_ICON_HEIGHT_OFFSET = 5;
  public static final int IMG_HEIGHT = 56;
  public static final String TAG = "FavoriteEmotionAdapter";
  private BaseAIOContext mAIOContext;
  private Drawable mFavPanelFailedDrawable = null;
  private IPanelInteractionListener mInteractionListener;
  public IEmoticonPanelLinearLayoutHelper.OnClickListener mInterceptListener = new FavoriteEmotionAdapter.1(this);
  
  public FavoriteEmotionAdapter(IEmoticonMainPanelApp paramIEmoticonMainPanelApp, IPanelInteractionListener paramIPanelInteractionListener, Context paramContext, int paramInt1, int paramInt2, int paramInt3, EmoticonCallback paramEmoticonCallback)
  {
    super(paramIEmoticonMainPanelApp, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonCallback);
    this.mInteractionListener = paramIPanelInteractionListener;
    paramIEmoticonMainPanelApp = this.mInteractionListener;
    if (paramIEmoticonMainPanelApp != null) {
      this.mAIOContext = paramIEmoticonMainPanelApp.getAIOContext();
    }
    this.mFavPanelFailedDrawable = BaseApplication.getContext().getResources().getDrawable(2130847919);
  }
  
  private int getEmoId(EmoticonInfo paramEmoticonInfo)
  {
    if ((paramEmoticonInfo instanceof FavoriteEmoticonInfo)) {
      return ((FavoriteEmoticonInfo)paramEmoticonInfo).emoId;
    }
    if ((paramEmoticonInfo instanceof PicEmoticonInfo)) {
      return ((PicEmoticonInfo)paramEmoticonInfo).emoId;
    }
    return 0;
  }
  
  private RelativeLayout getFavouriteView()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FavoriteEmotionAdapter", 2, "getFavouriteView");
    }
    RelativeLayout localRelativeLayout = new RelativeLayout(this.mContext);
    localRelativeLayout.setLayoutParams(new LinearLayout.LayoutParams(this.widthPixels / this.columnNum, (int)(this.density * 61.0F)));
    Object localObject = new URLImageView(this.mContext);
    ((URLImageView)localObject).setId(2131446720);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams((int)(this.density * 56.0F), (int)(this.density * 56.0F));
    localLayoutParams.addRule(13, -1);
    localLayoutParams.addRule(12, -1);
    localLayoutParams.setMargins(0, 0, 0, (int)(this.density * 5.0F));
    ((URLImageView)localObject).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    ((URLImageView)localObject).setAdjustViewBounds(false);
    localRelativeLayout.addView((View)localObject, localLayoutParams);
    localObject = new URLImageView(this.mContext);
    ((URLImageView)localObject).setId(2131432401);
    localLayoutParams = new RelativeLayout.LayoutParams((int)(this.density * 56.0F), (int)(this.density * 56.0F));
    localLayoutParams.addRule(13, -1);
    localLayoutParams.addRule(12, -1);
    localLayoutParams.setMargins(0, 0, 0, (int)(this.density * 5.0F));
    ((URLImageView)localObject).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    ((URLImageView)localObject).setAdjustViewBounds(false);
    localRelativeLayout.addView((View)localObject, localLayoutParams);
    localObject = new URLImageView(this.mContext);
    ((URLImageView)localObject).setId(2131442557);
    localLayoutParams = new RelativeLayout.LayoutParams((int)(this.density * 56.0F), (int)(this.density * 56.0F));
    localLayoutParams.addRule(13, -1);
    localLayoutParams.addRule(12, -1);
    localLayoutParams.setMargins(0, 0, 0, (int)(this.density * 5.0F));
    ((URLImageView)localObject).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    ((URLImageView)localObject).setAdjustViewBounds(false);
    ((URLImageView)localObject).setVisibility(8);
    localRelativeLayout.addView((View)localObject, localLayoutParams);
    localObject = new RelativeLayout(this.mContext);
    ((RelativeLayout)localObject).setId(2131432806);
    ((RelativeLayout)localObject).setVisibility(8);
    ((RelativeLayout)localObject).setBackgroundResource(2130852592);
    localLayoutParams = new RelativeLayout.LayoutParams(ViewUtils.dip2px(10.0F), ViewUtils.dip2px(10.0F));
    localLayoutParams.addRule(3, 2131446720);
    localLayoutParams.addRule(7, 2131446720);
    localLayoutParams.addRule(6, 2131446720);
    localLayoutParams.topMargin = (-(int)(this.density * 4.0F));
    localLayoutParams.rightMargin = (-(int)(this.density * 4.0F));
    localRelativeLayout.addView((View)localObject, localLayoutParams);
    localObject = new ImageView(this.mContext);
    ((ImageView)localObject).setId(2131432423);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    ((ImageView)localObject).setBackgroundResource(2130847914);
    localLayoutParams.addRule(7, 2131446720);
    localLayoutParams.addRule(8, 2131446720);
    localLayoutParams.setMargins(0, 0, (int)(this.density * -5.0F), (int)(this.density * -5.0F));
    localRelativeLayout.addView((View)localObject, localLayoutParams);
    localObject = new ImageView(this.mContext);
    ((ImageView)localObject).setId(2131442559);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(7, 2131446720);
    localLayoutParams.addRule(8, 2131446720);
    localRelativeLayout.addView((View)localObject, localLayoutParams);
    if (AppSetting.e) {
      localRelativeLayout.setFocusable(true);
    }
    return localRelativeLayout;
  }
  
  private String getRoamingType(EmoticonInfo paramEmoticonInfo)
  {
    Object localObject1;
    if ((paramEmoticonInfo instanceof FavoriteEmoticonInfo)) {
      localObject1 = ((FavoriteEmoticonInfo)paramEmoticonInfo).roamingType;
    } else if ((paramEmoticonInfo instanceof PicEmoticonInfo)) {
      localObject1 = ((PicEmoticonInfo)paramEmoticonInfo).roamingType;
    } else {
      localObject1 = "isUpdate";
    }
    Object localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getRoamingType return null, ");
      ((StringBuilder)localObject1).append(paramEmoticonInfo.toString());
      QLog.e("FavoriteEmotionAdapter", 2, ((StringBuilder)localObject1).toString());
      localObject2 = "isUpdate";
    }
    return localObject2;
  }
  
  private void setRoamingType(EmoticonInfo paramEmoticonInfo, String paramString)
  {
    if ((paramEmoticonInfo instanceof FavoriteEmoticonInfo))
    {
      ((FavoriteEmoticonInfo)paramEmoticonInfo).roamingType = paramString;
      return;
    }
    if ((paramEmoticonInfo instanceof PicEmoticonInfo)) {
      ((PicEmoticonInfo)paramEmoticonInfo).roamingType = paramString;
    }
  }
  
  private void updateEmoticonDrawable(URLImageView paramURLImageView1, URLImageView paramURLImageView2)
  {
    if ((paramURLImageView1.getDrawable() instanceof URLDrawable))
    {
      URLDrawable localURLDrawable = (URLDrawable)paramURLImageView1.getDrawable();
      if (localURLDrawable.getStatus() == 0)
      {
        paramURLImageView1.setVisibility(8);
        paramURLImageView2.setVisibility(0);
        if (!localURLDrawable.isDownloadStarted()) {
          localURLDrawable.startDownload();
        }
        if (!(paramURLImageView2.getDrawable() instanceof Animatable)) {
          paramURLImageView2.setImageDrawable((Drawable)BaseApplication.getContext().getResources().getDrawable(2130847934));
        }
        paramURLImageView1 = (Animatable)paramURLImageView2.getDrawable();
        if (!paramURLImageView1.isRunning()) {
          paramURLImageView1.start();
        }
      }
      else
      {
        if ((localURLDrawable.getStatus() != 2) && (localURLDrawable.getStatus() != 3))
        {
          paramURLImageView1.setVisibility(0);
          paramURLImageView2.setVisibility(8);
          return;
        }
        paramURLImageView1.setVisibility(8);
        paramURLImageView2.setVisibility(0);
        if ((paramURLImageView2.getDrawable() instanceof Animatable)) {
          ((Animatable)paramURLImageView2.getDrawable()).stop();
        }
        paramURLImageView2.setImageDrawable(this.mFavPanelFailedDrawable);
      }
    }
  }
  
  private void updateUI(View paramView, EmotionPanelData paramEmotionPanelData)
  {
    if ((paramView != null) && ((paramEmotionPanelData instanceof EmoticonInfo)))
    {
      EmoticonInfo localEmoticonInfo = (EmoticonInfo)paramEmotionPanelData;
      paramView.setTag(localEmoticonInfo);
      paramView.setVisibility(0);
      Object localObject1 = (RelativeLayout)paramView.findViewById(2131432806);
      if (localObject1 != null) {
        ((RelativeLayout)localObject1).setVisibility(8);
      }
      localObject1 = (URLImageView)paramView.findViewById(2131446720);
      if (((URLImageView)localObject1).getTag(2131449867) == localEmoticonInfo) {
        return;
      }
      ((URLImageView)localObject1).setTag(2131449867, paramEmotionPanelData);
      URLImageView localURLImageView = (URLImageView)paramView.findViewById(2131432401);
      paramEmotionPanelData = (URLImageView)paramView.findViewById(2131442557);
      ImageView localImageView = (ImageView)paramView.findViewById(2131432423);
      ((URLImageView)localObject1).setVisibility(0);
      ((URLImageView)localObject1).setURLDrawableDownListener(null);
      Object localObject2 = localEmoticonInfo.action;
      if ("favEdit".equals(localObject2))
      {
        ((URLImageView)localObject1).setImageDrawable(null);
        ((URLImageView)localObject1).setImageResource(2130847923);
        paramEmotionPanelData.setVisibility(8);
        localImageView.setVisibility(8);
        localURLImageView.setVisibility(8);
        if (AppSetting.e) {
          ((URLImageView)localObject1).setContentDescription(this.mContext.getString(2131897767));
        }
      }
      else if ("funny_pic".equals(localObject2))
      {
        ((URLImageView)localObject1).setImageDrawable(null);
        ((URLImageView)localObject1).setImageResource(2130847924);
        paramEmotionPanelData.setVisibility(8);
        localImageView.setVisibility(8);
        localURLImageView.setVisibility(8);
        if (AppSetting.e) {
          ((URLImageView)localObject1).setContentDescription(this.mContext.getString(2131897805));
        }
      }
      else
      {
        localObject2 = localEmoticonInfo.getZoomDrawable(this.mContext, this.density, (int)(this.density * 56.0F), (int)(this.density * 56.0F));
        ((URLImageView)localObject1).setImageDrawable((Drawable)localObject2);
        if (AppSetting.e) {
          ((URLImageView)localObject1).setContentDescription(((IFavroamingManagerService)this.app.getAppRuntime().getRuntimeService(IFavroamingManagerService.class, "")).getAccessibilityDescription(Integer.valueOf(localEmoticonInfo.emoId)));
        }
        String str = getRoamingType(localEmoticonInfo);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("updateUI: roamingType = ");
          localStringBuilder.append(str);
          QLog.i("FavoriteEmotionAdapter", 2, localStringBuilder.toString());
        }
        if (str.equals("needUpload"))
        {
          localURLImageView.setImageDrawable(new ColorDrawable(-419430401));
          localURLImageView.setVisibility(0);
          localObject1 = (Animatable)BaseApplication.getContext().getResources().getDrawable(2130847934);
          paramEmotionPanelData.setImageDrawable((Drawable)localObject1);
          ((Animatable)localObject1).start();
          paramEmotionPanelData.setVisibility(0);
          localImageView.setVisibility(8);
        }
        else if (str.equals("failed"))
        {
          localURLImageView.setImageDrawable(new ColorDrawable(-419430401));
          paramEmotionPanelData.setVisibility(8);
          localImageView.setVisibility(0);
          localURLImageView.setVisibility(0);
        }
        else
        {
          paramEmotionPanelData.setVisibility(4);
          localImageView.setVisibility(4);
          localURLImageView.setVisibility(8);
          if ((localObject2 instanceof URLDrawable))
          {
            ((URLImageView)localObject1).setURLDrawableDownListener(new FavoriteEmotionAdapter.2(this, localEmoticonInfo, (URLImageView)localObject1, paramEmotionPanelData));
            updateEmoticonDrawable((URLImageView)localObject1, paramEmotionPanelData);
          }
        }
      }
      paramView = (ImageView)paramView.findViewById(2131442559);
      if ((localEmoticonInfo instanceof PicEmoticonInfo))
      {
        paramEmotionPanelData = (PicEmoticonInfo)localEmoticonInfo;
        if (paramEmotionPanelData.isSound())
        {
          if (paramEmotionPanelData.isNewSoundType()) {
            paramView.setImageResource(2130847937);
          } else {
            paramView.setImageResource(2130847938);
          }
          paramView.setVisibility(0);
          return;
        }
        paramView.setVisibility(8);
        return;
      }
      paramView.setVisibility(8);
      return;
    }
    QLog.e("FavoriteEmotionAdapter", 1, "emotionInfo or contentView = null");
  }
  
  public void callbackInMainThread(List<EmotionPanelData> paramList)
  {
    if (paramList != null)
    {
      setData(paramList);
      notifyDataSetChanged();
    }
  }
  
  public View getEmotionView(BaseEmotionAdapter.ViewHolder paramViewHolder, int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getEmotionView position = ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" convertView is ");
      if (paramView == null) {
        paramViewGroup = "null";
      } else {
        paramViewGroup = paramView.getClass().toString();
      }
      localStringBuilder.append(paramViewGroup);
      QLog.d("FavoriteEmotionAdapter", 2, localStringBuilder.toString());
    }
    paramViewGroup = (FavoriteEmotionAdapter.FavoriteEmotionViewHolder)paramViewHolder;
    paramViewHolder = paramView;
    if (paramView == null)
    {
      paramView = EmotionPanelViewPool.getInstance().getView(this.panelType);
      if (paramView == null)
      {
        if (QLog.isColorLevel())
        {
          paramViewHolder = new StringBuilder();
          paramViewHolder.append("getEmotionView position = ");
          paramViewHolder.append(paramInt);
          paramViewHolder.append("; view from inflater");
          QLog.d("FavoriteEmotionAdapter", 2, paramViewHolder.toString());
        }
        paramViewHolder = new EmoticonPanelLinearLayout(this.mContext, new QQEmoticonPanelLinearLayoutHelper(this.mContext, this.mInteractionListener), -1);
        paramViewHolder.setPanelType(3);
        paramViewHolder.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        paramViewHolder.setOrientation(0);
        if (paramInt == 0) {
          paramViewHolder.setPadding(0, (int)(this.density * 16.0F), 0, 0);
        } else {
          paramViewHolder.setPadding(0, (int)(this.density * 14.0F), 0, 0);
        }
        i = 0;
        while (i < this.columnNum)
        {
          paramView = getFavouriteView();
          paramView.setVisibility(8);
          paramView.setFocusable(true);
          paramView.setFocusableInTouchMode(true);
          paramViewHolder.addView(paramView);
          i += 1;
        }
        paramViewHolder.setInterceptListener(this.mInterceptListener);
      }
      else
      {
        paramViewHolder = paramView;
        if (QLog.isColorLevel())
        {
          paramViewHolder = new StringBuilder();
          paramViewHolder.append("getEmotionView position = ");
          paramViewHolder.append(paramInt);
          paramViewHolder.append("; view from cache");
          QLog.d("FavoriteEmotionAdapter", 2, paramViewHolder.toString());
          paramViewHolder = paramView;
        }
      }
      ((EmoticonPanelLinearLayout)paramViewHolder).setCallBack(this.callback);
      recycleView(this.panelType, paramViewHolder);
      paramView = (ViewGroup)paramViewHolder;
      paramViewGroup.contentViews = new RelativeLayout[this.columnNum];
      i = 0;
      while (i < this.columnNum)
      {
        paramViewGroup.contentViews[i] = ((RelativeLayout)paramView.getChildAt(i));
        i += 1;
      }
      paramViewHolder.setTag(paramViewGroup);
    }
    int i = 0;
    while (i < this.columnNum)
    {
      int j = this.columnNum * paramInt + i;
      if (j > this.data.size() - 1)
      {
        paramViewGroup.contentViews[i].setTag(null);
        paramViewGroup.contentViews[i].setVisibility(8);
      }
      else
      {
        paramView = paramViewGroup.contentViews[i];
        updateUI(paramView, (EmotionPanelData)this.data.get(j));
        if (this.mAIOContext != null)
        {
          paramView.setOnClickListener(this);
          paramView.setClickable(false);
          EmoticonReportDtHelper.bindFavoriteEmotionView(paramView, j);
        }
      }
      i += 1;
    }
    return paramViewHolder;
  }
  
  public BaseEmotionAdapter.ViewHolder newHolder()
  {
    return new FavoriteEmotionAdapter.FavoriteEmotionViewHolder();
  }
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FavoriteEmotionAdapter", 2, "FavoriteEmotionAdapter itemView onClicked");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void refreshPanelData()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FavoriteEmotionAdapter", 2, "refreshPanelData");
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
  
  public void setData(List<EmotionPanelData> paramList)
  {
    super.setData(paramList);
    ((IFavroamingManagerService)this.app.getAppRuntime().getRuntimeService(IFavroamingManagerService.class, "")).cacheAccessibilityEmotionData();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.FavoriteEmotionAdapter
 * JD-Core Version:    0.7.0.1
 */