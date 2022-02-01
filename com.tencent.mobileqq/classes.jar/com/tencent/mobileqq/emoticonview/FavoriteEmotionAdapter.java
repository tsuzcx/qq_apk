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
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.core.EmotionPanelParamsBuilder;
import com.tencent.mobileqq.core.QQEmotionPanelManager;
import com.tencent.mobileqq.core.SystemEmotionPanelManager;
import com.tencent.mobileqq.emoticon.IEmotionPanelDataCallback;
import com.tencent.mobileqq.emoticonview.api.IFavoriteEmotionService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.List;

public class FavoriteEmotionAdapter
  extends BaseEmotionAdapter
  implements IEmotionPanelDataCallback<EmotionPanelData>
{
  public static final int CONTENT_HEIGHT = 61;
  public static final int ERROR_ICON_HEIGHT_OFFSET = 5;
  public static final int IMG_HEIGHT = 56;
  public static final String TAG = "FavoriteEmotionAdapter";
  private Drawable mFavPanelFailedDrawable = null;
  public IEmoticonPanelLinearLayoutHelper.OnClickListener mInterceptListener = new FavoriteEmotionAdapter.1(this);
  
  public FavoriteEmotionAdapter(IEmoticonMainPanelApp paramIEmoticonMainPanelApp, Context paramContext, int paramInt1, int paramInt2, int paramInt3, EmoticonCallback paramEmoticonCallback)
  {
    super(paramIEmoticonMainPanelApp, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonCallback);
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
    localRelativeLayout.setLayoutParams(new LinearLayout.LayoutParams(this.widthPixels / this.columnNum, (int)(61.0F * this.density)));
    Object localObject = new URLImageView(this.mContext);
    ((URLImageView)localObject).setId(2131378813);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams((int)(this.density * 56.0F), (int)(this.density * 56.0F));
    localLayoutParams.addRule(13, -1);
    localLayoutParams.addRule(12, -1);
    localLayoutParams.setMargins(0, 0, 0, (int)(5.0F * this.density));
    ((URLImageView)localObject).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    ((URLImageView)localObject).setAdjustViewBounds(false);
    localRelativeLayout.addView((View)localObject, localLayoutParams);
    localObject = new URLImageView(this.mContext);
    ((URLImageView)localObject).setId(2131366226);
    localLayoutParams = new RelativeLayout.LayoutParams((int)(this.density * 56.0F), (int)(this.density * 56.0F));
    localLayoutParams.addRule(13, -1);
    localLayoutParams.addRule(12, -1);
    localLayoutParams.setMargins(0, 0, 0, (int)(5.0F * this.density));
    ((URLImageView)localObject).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    ((URLImageView)localObject).setAdjustViewBounds(false);
    localRelativeLayout.addView((View)localObject, localLayoutParams);
    localObject = new URLImageView(this.mContext);
    ((URLImageView)localObject).setId(2131374857);
    localLayoutParams = new RelativeLayout.LayoutParams((int)(this.density * 56.0F), (int)(this.density * 56.0F));
    localLayoutParams.addRule(13, -1);
    localLayoutParams.addRule(12, -1);
    localLayoutParams.setMargins(0, 0, 0, (int)(5.0F * this.density));
    ((URLImageView)localObject).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    ((URLImageView)localObject).setAdjustViewBounds(false);
    ((URLImageView)localObject).setVisibility(8);
    localRelativeLayout.addView((View)localObject, localLayoutParams);
    localObject = new RelativeLayout(this.mContext);
    ((RelativeLayout)localObject).setId(2131366618);
    ((RelativeLayout)localObject).setVisibility(8);
    ((RelativeLayout)localObject).setBackgroundResource(2130850834);
    localLayoutParams = new RelativeLayout.LayoutParams(ViewUtils.a(10.0F), ViewUtils.a(10.0F));
    localLayoutParams.addRule(3, 2131378813);
    localLayoutParams.addRule(7, 2131378813);
    localLayoutParams.addRule(6, 2131378813);
    localLayoutParams.topMargin = (-(int)(4.0F * this.density));
    localLayoutParams.rightMargin = (-(int)(4.0F * this.density));
    localRelativeLayout.addView((View)localObject, localLayoutParams);
    localObject = new ImageView(this.mContext);
    ((ImageView)localObject).setId(2131366249);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    ((ImageView)localObject).setBackgroundResource(2130846564);
    localLayoutParams.addRule(7, 2131378813);
    localLayoutParams.addRule(8, 2131378813);
    localLayoutParams.setMargins(0, 0, (int)(-5.0F * this.density), (int)(-5.0F * this.density));
    localRelativeLayout.addView((View)localObject, localLayoutParams);
    localObject = new ImageView(this.mContext);
    ((ImageView)localObject).setId(2131374859);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(7, 2131378813);
    localLayoutParams.addRule(8, 2131378813);
    localRelativeLayout.addView((View)localObject, localLayoutParams);
    if (AppSetting.d) {
      localRelativeLayout.setFocusable(true);
    }
    return localRelativeLayout;
  }
  
  private String getRoamingType(EmoticonInfo paramEmoticonInfo)
  {
    String str1 = "isUpdate";
    if ((paramEmoticonInfo instanceof FavoriteEmoticonInfo)) {
      str1 = ((FavoriteEmoticonInfo)paramEmoticonInfo).roamingType;
    }
    for (;;)
    {
      String str2 = str1;
      if (TextUtils.isEmpty(str1))
      {
        QLog.e("FavoriteEmotionAdapter", 2, "getRoamingType return null, " + paramEmoticonInfo.toString());
        str2 = "isUpdate";
      }
      return str2;
      if ((paramEmoticonInfo instanceof PicEmoticonInfo)) {
        str1 = ((PicEmoticonInfo)paramEmoticonInfo).roamingType;
      }
    }
  }
  
  private void setRoamingType(EmoticonInfo paramEmoticonInfo, String paramString)
  {
    if ((paramEmoticonInfo instanceof FavoriteEmoticonInfo)) {
      ((FavoriteEmoticonInfo)paramEmoticonInfo).roamingType = paramString;
    }
    while (!(paramEmoticonInfo instanceof PicEmoticonInfo)) {
      return;
    }
    ((PicEmoticonInfo)paramEmoticonInfo).roamingType = paramString;
  }
  
  private void updateEmoticonDrawable(URLImageView paramURLImageView1, URLImageView paramURLImageView2)
  {
    URLDrawable localURLDrawable;
    if ((paramURLImageView1.getDrawable() instanceof URLDrawable))
    {
      localURLDrawable = (URLDrawable)paramURLImageView1.getDrawable();
      if (localURLDrawable.getStatus() != 0) {
        break label103;
      }
      paramURLImageView1.setVisibility(8);
      paramURLImageView2.setVisibility(0);
      if (!localURLDrawable.isDownloadStarted()) {
        localURLDrawable.startDownload();
      }
      if (!(paramURLImageView2.getDrawable() instanceof Animatable)) {
        paramURLImageView2.setImageDrawable((Drawable)BaseApplication.getContext().getResources().getDrawable(2130846582));
      }
      paramURLImageView1 = (Animatable)paramURLImageView2.getDrawable();
      if (!paramURLImageView1.isRunning()) {
        paramURLImageView1.start();
      }
    }
    return;
    label103:
    if ((localURLDrawable.getStatus() == 2) || (localURLDrawable.getStatus() == 3))
    {
      paramURLImageView1.setVisibility(8);
      paramURLImageView2.setVisibility(0);
      if ((paramURLImageView2.getDrawable() instanceof Animatable)) {
        ((Animatable)paramURLImageView2.getDrawable()).stop();
      }
      paramURLImageView2.setImageDrawable(this.mFavPanelFailedDrawable);
      return;
    }
    paramURLImageView1.setVisibility(0);
    paramURLImageView2.setVisibility(8);
  }
  
  private void updateUI(View paramView, EmotionPanelData paramEmotionPanelData)
  {
    if ((paramView == null) || (!(paramEmotionPanelData instanceof EmoticonInfo))) {
      QLog.e("FavoriteEmotionAdapter", 1, "emotionInfo or contentView = null");
    }
    EmoticonInfo localEmoticonInfo;
    Object localObject1;
    do
    {
      return;
      localEmoticonInfo = (EmoticonInfo)paramEmotionPanelData;
      paramView.setTag(localEmoticonInfo);
      paramView.setVisibility(0);
      localObject1 = (RelativeLayout)paramView.findViewById(2131366618);
      if (localObject1 != null) {
        ((RelativeLayout)localObject1).setVisibility(8);
      }
      localObject1 = (URLImageView)paramView.findViewById(2131378813);
    } while (((URLImageView)localObject1).getTag(2131381651) == localEmoticonInfo);
    ((URLImageView)localObject1).setTag(2131381651, paramEmotionPanelData);
    URLImageView localURLImageView = (URLImageView)paramView.findViewById(2131366226);
    paramEmotionPanelData = (URLImageView)paramView.findViewById(2131374857);
    ImageView localImageView = (ImageView)paramView.findViewById(2131366249);
    ((URLImageView)localObject1).setVisibility(0);
    ((URLImageView)localObject1).setURLDrawableDownListener(null);
    Object localObject2 = localEmoticonInfo.action;
    if ("favEdit".equals(localObject2))
    {
      ((URLImageView)localObject1).setImageDrawable(null);
      ((URLImageView)localObject1).setImageResource(2130846571);
      paramEmotionPanelData.setVisibility(8);
      localImageView.setVisibility(8);
      localURLImageView.setVisibility(8);
      if (AppSetting.d) {
        ((URLImageView)localObject1).setContentDescription(this.mContext.getString(2131699617));
      }
      paramView = (ImageView)paramView.findViewById(2131374859);
      if (!(localEmoticonInfo instanceof PicEmoticonInfo)) {
        break label632;
      }
      paramEmotionPanelData = (PicEmoticonInfo)localEmoticonInfo;
      if (!paramEmotionPanelData.isSound()) {
        break label625;
      }
      if (!paramEmotionPanelData.isNewSoundType()) {
        break label615;
      }
      paramView.setImageResource(2130846584);
    }
    for (;;)
    {
      paramView.setVisibility(0);
      return;
      if ("funny_pic".equals(localObject2))
      {
        ((URLImageView)localObject1).setImageDrawable(null);
        ((URLImageView)localObject1).setImageResource(2130846572);
        paramEmotionPanelData.setVisibility(8);
        localImageView.setVisibility(8);
        localURLImageView.setVisibility(8);
        if (!AppSetting.d) {
          break;
        }
        ((URLImageView)localObject1).setContentDescription(this.mContext.getString(2131699643));
        break;
      }
      localObject2 = localEmoticonInfo.getZoomDrawable(this.mContext, this.density, (int)(56.0F * this.density), (int)(56.0F * this.density));
      ((URLImageView)localObject1).setImageDrawable((Drawable)localObject2);
      if (AppSetting.d) {
        ((URLImageView)localObject1).setContentDescription(((IFavoriteEmotionService)QRoute.api(IFavoriteEmotionService.class)).getAccessibilityDescription(this.app, localEmoticonInfo.emoId));
      }
      String str = getRoamingType(localEmoticonInfo);
      if (QLog.isColorLevel()) {
        QLog.i("FavoriteEmotionAdapter", 2, "updateUI: roamingType = " + str);
      }
      if (str.equals("needUpload"))
      {
        localURLImageView.setImageDrawable(new ColorDrawable(-419430401));
        localURLImageView.setVisibility(0);
        localObject1 = (Animatable)BaseApplication.getContext().getResources().getDrawable(2130846582);
        paramEmotionPanelData.setImageDrawable((Drawable)localObject1);
        ((Animatable)localObject1).start();
        paramEmotionPanelData.setVisibility(0);
        localImageView.setVisibility(8);
        break;
      }
      if (str.equals("failed"))
      {
        localURLImageView.setImageDrawable(new ColorDrawable(-419430401));
        paramEmotionPanelData.setVisibility(8);
        localImageView.setVisibility(0);
        localURLImageView.setVisibility(0);
        break;
      }
      paramEmotionPanelData.setVisibility(4);
      localImageView.setVisibility(4);
      localURLImageView.setVisibility(8);
      if (!(localObject2 instanceof URLDrawable)) {
        break;
      }
      ((URLImageView)localObject1).setURLDrawableDownListener(new FavoriteEmotionAdapter.2(this, localEmoticonInfo, (URLImageView)localObject1, paramEmotionPanelData));
      updateEmoticonDrawable((URLImageView)localObject1, paramEmotionPanelData);
      break;
      label615:
      paramView.setImageResource(2130846585);
    }
    label625:
    paramView.setVisibility(8);
    return;
    label632:
    paramView.setVisibility(8);
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
    int j = 0;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("getEmotionView position = ").append(paramInt).append(" convertView is ");
      if (paramView == null)
      {
        paramViewGroup = "null";
        QLog.d("FavoriteEmotionAdapter", 2, paramViewGroup);
      }
    }
    else
    {
      paramViewGroup = (FavoriteEmotionAdapter.FavoriteEmotionViewHolder)paramViewHolder;
      if (paramView != null) {
        break label512;
      }
      paramView = EmotionPanelViewPool.getInstance().getView(this.panelType);
      if (paramView != null) {
        break label350;
      }
      if (QLog.isColorLevel()) {
        QLog.d("FavoriteEmotionAdapter", 2, "getEmotionView position = " + paramInt + "; view from inflater");
      }
      paramViewHolder = new EmoticonPanelLinearLayout(this.mContext, SystemEmotionPanelManager.a().a(this.mContext, true), -1);
      paramViewHolder.setPanelType(3);
      paramViewHolder.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
      paramViewHolder.setOrientation(0);
      if (paramInt != 0) {
        break label248;
      }
      paramViewHolder.setPadding(0, (int)(16.0F * this.density), 0, 0);
    }
    for (;;)
    {
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
      paramViewGroup = paramView.getClass().toString();
      break;
      label248:
      paramViewHolder.setPadding(0, (int)(14.0F * this.density), 0, 0);
    }
    paramViewHolder.setInterceptListener(this.mInterceptListener);
    for (;;)
    {
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
      label350:
      paramViewHolder = paramView;
      if (QLog.isColorLevel())
      {
        QLog.d("FavoriteEmotionAdapter", 2, "getEmotionView position = " + paramInt + "; view from cache");
        paramViewHolder = paramView;
      }
    }
    paramViewHolder.setTag(paramViewGroup);
    int i = j;
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
      if (QLog.isColorLevel()) {}
      return paramViewHolder;
      label512:
      paramViewHolder = paramView;
      i = j;
    }
  }
  
  public BaseEmotionAdapter.ViewHolder newHolder()
  {
    return new FavoriteEmotionAdapter.FavoriteEmotionViewHolder();
  }
  
  public void refreshPanelData()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FavoriteEmotionAdapter", 2, "refreshPanelData");
    }
    ((IFavoriteEmotionService)QRoute.api(IFavoriteEmotionService.class)).asyncGetEmotionPanelData(this.app, this.panelType, null, -1, QQEmotionPanelManager.a().a().a, false, this);
  }
  
  public void setData(List<EmotionPanelData> paramList)
  {
    super.setData(paramList);
    ((IFavoriteEmotionService)QRoute.api(IFavoriteEmotionService.class)).cacheAccessibilityEmotionData(this.app);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.FavoriteEmotionAdapter
 * JD-Core Version:    0.7.0.1
 */