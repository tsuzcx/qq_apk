package com.tencent.mobileqq.emoticonview;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.AIODepend.IPanelInteractionListener;
import com.tencent.mobileqq.core.QQEmotionPanelManager;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticonview.api.IBigEmotionService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.MqqWeakReferenceHandler;
import java.util.List;
import mqq.os.MqqHandler;

public class EmotionCompleteInvalidAdapter
  extends EmotionNeedDownloadAdapter
  implements Handler.Callback, View.OnClickListener
{
  private static final int MSG_PAYBACK = 100;
  public static final String TAG = "EmotionCompleteInvalidAdapter";
  public static final int TYPE_SVIP = 2;
  public static final int TYPE_VIP = 1;
  protected int contentHight;
  protected int emotionFeeType;
  protected EmoticonPackage emotionPkg;
  private boolean isSmallEmotion;
  private MqqHandler mUiHandler = new MqqWeakReferenceHandler(Looper.getMainLooper(), this, true);
  protected LinearLayout maskLayout;
  protected Button openBtn;
  
  public EmotionCompleteInvalidAdapter(IEmoticonMainPanelApp paramIEmoticonMainPanelApp, Context paramContext, int paramInt1, int paramInt2, int paramInt3, EmoticonPackage paramEmoticonPackage, EmoticonCallback paramEmoticonCallback)
  {
    super(paramIEmoticonMainPanelApp, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonCallback);
    this.emotionPkg = paramEmoticonPackage;
    if (paramEmoticonPackage.jobType == 4) {}
    for (boolean bool = true;; bool = false)
    {
      this.isSmallEmotion = bool;
      if (paramEmoticonPackage.mobileFeetype != 4) {
        break;
      }
      this.emotionFeeType = 1;
      return;
    }
    this.emotionFeeType = 2;
  }
  
  private LinearLayout getMaskLayout(EmotionCompleteInvalidAdapter.EmotionCompletedInvalidViewHolder paramEmotionCompletedInvalidViewHolder)
  {
    LinearLayout localLinearLayout = new LinearLayout(this.mContext);
    localLinearLayout.setOrientation(1);
    localLinearLayout.setBackgroundColor(-16777216);
    localLinearLayout.getBackground().setAlpha(178);
    localLinearLayout.setGravity(16);
    localLinearLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, this.contentHight));
    TextView localTextView = new TextView(this.mContext);
    Object localObject = new LinearLayout.LayoutParams(-2, -2);
    ((LinearLayout.LayoutParams)localObject).gravity = 1;
    localTextView.setGravity(1);
    localLinearLayout.addView(localTextView, (ViewGroup.LayoutParams)localObject);
    localObject = new Button(this.mContext);
    ((Button)localObject).setId(2131365519);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, (int)(25.0F * this.density));
    ((Button)localObject).setGravity(17);
    localLayoutParams.topMargin = ((int)(10.0F * this.density));
    localLayoutParams.gravity = 1;
    ((Button)localObject).setBackgroundDrawable(this.mContext.getResources().getDrawable(2130846563));
    ((Button)localObject).setTextColor(-14894864);
    ((Button)localObject).setPadding((int)(this.density * 30.0F), 0, (int)(this.density * 30.0F), 0);
    localLinearLayout.addView((View)localObject, localLayoutParams);
    paramEmotionCompletedInvalidViewHolder.maskLayout = localLinearLayout;
    paramEmotionCompletedInvalidViewHolder.tips = localTextView;
    paramEmotionCompletedInvalidViewHolder.downloadBtn = ((Button)localObject);
    return localLinearLayout;
  }
  
  private void initContentHeight()
  {
    if ((this.contentHight == 0) && (QQEmotionPanelManager.a().a() != null))
    {
      if (getCurrentListView() == null) {
        break label71;
      }
      this.contentHight = getCurrentListView().getHeight();
      if (this.contentHight == 0) {
        this.contentHight = (QQEmotionPanelManager.a().a().getExternalPanelheight() - (int)this.mContext.getResources().getDimension(2131296984));
      }
    }
    return;
    label71:
    this.contentHight = (QQEmotionPanelManager.a().a().getExternalPanelheight() - (int)this.mContext.getResources().getDimension(2131296984));
  }
  
  private void updateUI(View paramView, EmotionPanelData paramEmotionPanelData)
  {
    if ((paramView == null) || (paramEmotionPanelData == null))
    {
      QLog.e("EmotionCompleteInvalidAdapter", 1, "updateUI contentView or info = null");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("EmotionCompleteInvalidAdapter", 2, "updateUI");
    }
    if (this.isSmallEmotion)
    {
      paramView.setVisibility(0);
      if (!(paramEmotionPanelData instanceof EmoticonInfo)) {
        break label107;
      }
    }
    label107:
    for (paramEmotionPanelData = (EmoticonInfo)paramEmotionPanelData;; paramEmotionPanelData = null)
    {
      if (paramEmotionPanelData == null)
      {
        QLog.e("EmotionCompleteInvalidAdapter", 1, "updateUI emotionInfo = null");
        return;
      }
      paramView = (URLImageView)paramView.findViewById(2131378813);
      paramView.setImageDrawable(paramEmotionPanelData.getDrawable(this.mContext, this.density));
      paramView.setVisibility(0);
      return;
      super.updateBigEmotionContentViewData(paramView, paramEmotionPanelData);
      return;
    }
  }
  
  public int getCount()
  {
    return 1;
  }
  
  public EmoticonPackage getEmoticonPackage()
  {
    return this.emotionPkg;
  }
  
  public View getEmotionView(BaseEmotionAdapter.ViewHolder paramViewHolder, int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject = (EmotionCompleteInvalidAdapter.EmotionCompletedInvalidViewHolder)paramViewHolder;
    paramViewGroup = paramView;
    label109:
    int i;
    label294:
    int j;
    label341:
    int m;
    int n;
    if (paramView == null)
    {
      initContentHeight();
      paramViewGroup = new FrameLayout(this.mContext);
      LinearLayout localLinearLayout = getMaskLayout((EmotionCompleteInvalidAdapter.EmotionCompletedInvalidViewHolder)localObject);
      if (!this.isSmallEmotion) {
        break label413;
      }
      paramView = EmotionPanelViewPool.getInstance().getView(11);
      if (paramView == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("EmotionCompleteInvalidAdapter", 2, "getEmotionView smallemotion view from inflater");
        }
        paramViewHolder = new EmotionInvalidPanelLinearLayout(this.mContext, this.emotionPkg, 7, this.columnNum);
        if (!this.isSmallEmotion) {
          break label533;
        }
        recycleView(11, paramViewHolder);
        paramViewGroup.addView(paramViewHolder, new FrameLayout.LayoutParams(-1, this.contentHight));
        paramViewGroup.addView(localLinearLayout);
        ((EmotionCompleteInvalidAdapter.EmotionCompletedInvalidViewHolder)localObject).panelLiearlayout = ((EmotionInvalidPanelLinearLayout)paramViewHolder);
        paramViewGroup.setTag(localObject);
      }
    }
    else
    {
      this.openBtn = ((EmotionCompleteInvalidAdapter.EmotionCompletedInvalidViewHolder)localObject).downloadBtn;
      this.maskLayout = ((EmotionCompleteInvalidAdapter.EmotionCompletedInvalidViewHolder)localObject).maskLayout;
      paramView = this.mContext.getString(2131699632);
      paramViewHolder = this.mContext.getString(2131699649);
      if (this.emotionFeeType == 2) {
        paramViewHolder = this.mContext.getString(2131699639);
      }
      paramViewHolder = this.mContext.getString(2131699641) + paramViewHolder + "专享,\n开通" + paramViewHolder + this.mContext.getString(2131699650);
      if (this.emotionPkg.mobileFeetype != 6) {
        break label543;
      }
      paramViewHolder = this.mContext.getString(2131699616);
      paramView = this.mContext.getString(2131699646);
      ((EmotionCompleteInvalidAdapter.EmotionCompletedInvalidViewHolder)localObject).tips.setText(paramViewHolder);
      ((EmotionCompleteInvalidAdapter.EmotionCompletedInvalidViewHolder)localObject).downloadBtn.setText(paramView);
      ((EmotionCompleteInvalidAdapter.EmotionCompletedInvalidViewHolder)localObject).downloadBtn.setOnClickListener(this);
      i = 0;
      paramInt = 0;
      paramViewHolder = ((EmotionCompleteInvalidAdapter.EmotionCompletedInvalidViewHolder)localObject).panelLiearlayout;
      int i1 = paramViewHolder.getChildCount();
      j = 0;
      if (j >= i1) {
        break label715;
      }
      paramView = (LinearLayout)paramViewHolder.getChildAt(j);
      if (paramInt == 0) {
        break label615;
      }
      paramView.setVisibility(8);
      m = i;
      n = paramInt;
    }
    label413:
    label543:
    label615:
    int i2;
    label533:
    int k;
    do
    {
      j += 1;
      paramInt = n;
      i = m;
      break label341;
      paramViewHolder = paramView;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("EmotionCompleteInvalidAdapter", 2, "getEmotionView smallemotion view from cache");
      paramViewHolder = paramView;
      break;
      paramView = EmotionPanelViewPool.getInstance().getView(10);
      if (paramView == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("EmotionCompleteInvalidAdapter", 2, "getEmotionView positon = " + paramInt + ";bigemotion view from inflater");
        }
        paramViewHolder = new EmotionInvalidPanelLinearLayout(this.mContext, this.emotionPkg, 4, this.columnNum);
        break;
      }
      paramViewHolder = paramView;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("EmotionCompleteInvalidAdapter", 2, "getEmotionView positon = " + paramInt + ";bigemotion view from cache");
      paramViewHolder = paramView;
      break;
      recycleView(10, paramViewHolder);
      break label109;
      if (this.emotionPkg.mobileFeetype == 2)
      {
        paramViewHolder = this.mContext.getString(2131699607);
        paramView = this.mContext.getString(2131699646);
        break label294;
      }
      if (this.emotionPkg.mobileFeetype != 3) {
        break label294;
      }
      paramViewHolder = this.mContext.getString(2131699629);
      paramView = this.mContext.getString(2131699646);
      break label294;
      i2 = paramView.getChildCount();
      k = 0;
      n = paramInt;
      m = i;
    } while (k >= i2);
    localObject = paramView.getChildAt(k);
    if (i > this.data.size() - 1)
    {
      ((View)localObject).setVisibility(8);
      paramInt = 1;
    }
    for (;;)
    {
      k += 1;
      break;
      ((View)localObject).setVisibility(0);
      updateUI((View)localObject, (EmotionPanelData)this.data.get(i));
      i += 1;
    }
    label715:
    return paramViewGroup;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      if (this.maskLayout != null) {
        this.maskLayout.setVisibility(8);
      }
      ((IBigEmotionService)QRoute.api(IBigEmotionService.class)).sendPayBackMessage(this.app);
    }
  }
  
  public BaseEmotionAdapter.ViewHolder newHolder()
  {
    return new EmotionCompleteInvalidAdapter.EmotionCompletedInvalidViewHolder();
  }
  
  public void onClick(View paramView)
  {
    boolean bool = true;
    if (paramView.getId() == 2131365519)
    {
      if (this.emotionPkg != null) {
        break label35;
      }
      QLog.e("EmotionCompleteInvalidAdapter", 1, "onClick EP = NULL");
    }
    label35:
    do
    {
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if ((this.emotionPkg.mobileFeetype != 4) && (this.emotionPkg.mobileFeetype != 5)) {
          break;
        }
        String str2 = "mvip.gexinghua.android.sbp_" + this.emotionPkg.epId;
        String str1 = "!vip";
        if (this.emotionPkg.mobileFeetype == 5) {
          str1 = "!svip";
        }
        str1 = "https://mc.vip.qq.com/qqwallet/index?aid=" + str2 + "&type=" + str1 + "&send=0&return_url=jsbridge://qw_charge/emojiPayResultOk";
        if ((this.mContext instanceof Activity)) {
          ((IBigEmotionService)QRoute.api(IBigEmotionService.class)).startActivityForResult((Activity)this.mContext, str1, 4813);
        }
        if (!this.isSmallEmotion) {
          ReportController.b(this.app.getQQAppInterface(), "CliOper", "", "", "ep_mall", "0X80057B3", 0, 0, this.emotionPkg.epId, "", "", "");
        }
      }
    } while (this.emotionPkg.valid);
    if (this.emotionPkg.jobType == 4) {}
    for (;;)
    {
      ((IBigEmotionService)QRoute.api(IBigEmotionService.class)).openEmojiDetailPage(this.mContext, this.app, this.app.getAccount(), 0, String.valueOf(this.emotionPkg.epId), false, null, bool);
      break;
      bool = false;
    }
  }
  
  public void payBack(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionCompleteInvalidAdapter", 2, "payBack");
    }
    if (18 == paramInt) {
      this.mUiHandler.sendEmptyMessage(100);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmotionCompleteInvalidAdapter
 * JD-Core Version:    0.7.0.1
 */