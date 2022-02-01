package com.tencent.mobileqq.emoticonview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
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
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticonview.api.IBigEmotionService;
import com.tencent.mobileqq.emoticonview.api.IEmosmService;
import com.tencent.mobileqq.emoticonview.ipc.proxy.MqqHandlerProxy;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.widget.XPanelContainer;
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
  protected IPanelInteractionListener interactionListener;
  private boolean isSmallEmotion;
  private MqqHandler mUiHandler = new MqqWeakReferenceHandler(Looper.getMainLooper(), this, true);
  protected LinearLayout maskLayout;
  protected Button openBtn;
  
  public EmotionCompleteInvalidAdapter(IEmoticonMainPanelApp paramIEmoticonMainPanelApp, IPanelInteractionListener paramIPanelInteractionListener, Context paramContext, int paramInt1, int paramInt2, int paramInt3, EmoticonPackage paramEmoticonPackage, EmoticonCallback paramEmoticonCallback)
  {
    super(paramIEmoticonMainPanelApp, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonCallback);
    this.emotionPkg = paramEmoticonPackage;
    this.interactionListener = paramIPanelInteractionListener;
    boolean bool;
    if (paramEmoticonPackage.jobType == 4) {
      bool = true;
    } else {
      bool = false;
    }
    this.isSmallEmotion = bool;
    if (paramEmoticonPackage.mobileFeetype == 4)
    {
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
    ((Button)localObject).setId(2131431558);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, (int)(this.density * 25.0F));
    ((Button)localObject).setGravity(17);
    localLayoutParams.topMargin = ((int)(this.density * 10.0F));
    localLayoutParams.gravity = 1;
    ((Button)localObject).setBackgroundDrawable(this.mContext.getResources().getDrawable(2130847913));
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
    if ((this.contentHight == 0) && (this.interactionListener != null)) {
      if (getCurrentListView() != null)
      {
        this.contentHight = getCurrentListView().getHeight();
        if (this.contentHight == 0) {
          this.contentHight = (XPanelContainer.a - (int)this.mContext.getResources().getDimension(2131297347));
        }
      }
      else
      {
        this.contentHight = (XPanelContainer.a - (int)this.mContext.getResources().getDimension(2131297347));
      }
    }
  }
  
  private void updateUI(View paramView, EmotionPanelData paramEmotionPanelData)
  {
    if ((paramView != null) && (paramEmotionPanelData != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmotionCompleteInvalidAdapter", 2, "updateUI");
      }
      if (this.isSmallEmotion)
      {
        paramView.setVisibility(0);
        EmoticonInfo localEmoticonInfo = null;
        if ((paramEmotionPanelData instanceof EmoticonInfo)) {
          localEmoticonInfo = (EmoticonInfo)paramEmotionPanelData;
        }
        if (localEmoticonInfo == null)
        {
          QLog.e("EmotionCompleteInvalidAdapter", 1, "updateUI emotionInfo = null");
          return;
        }
        paramView = (URLImageView)paramView.findViewById(2131446720);
        paramView.setImageDrawable(localEmoticonInfo.getDrawable(this.mContext, this.density));
        paramView.setVisibility(0);
        return;
      }
      super.updateBigEmotionContentViewData(paramView, paramEmotionPanelData);
      return;
    }
    QLog.e("EmotionCompleteInvalidAdapter", 1, "updateUI contentView or info = null");
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
    Object localObject1 = (EmotionCompleteInvalidAdapter.EmotionCompletedInvalidViewHolder)paramViewHolder;
    paramViewGroup = paramView;
    if (paramView == null)
    {
      initContentHeight();
      paramViewGroup = new FrameLayout(this.mContext);
      localObject2 = getMaskLayout((EmotionCompleteInvalidAdapter.EmotionCompletedInvalidViewHolder)localObject1);
      if (this.isSmallEmotion)
      {
        paramView = EmotionPanelViewPool.getInstance().getView(11);
        if (paramView == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("EmotionCompleteInvalidAdapter", 2, "getEmotionView smallemotion view from inflater");
          }
          paramViewHolder = new EmotionInvalidPanelLinearLayout(this.mContext, this.emotionPkg, 7, this.columnNum);
        }
        else
        {
          paramViewHolder = paramView;
          if (QLog.isColorLevel())
          {
            QLog.d("EmotionCompleteInvalidAdapter", 2, "getEmotionView smallemotion view from cache");
            paramViewHolder = paramView;
          }
        }
      }
      else
      {
        paramViewHolder = EmotionPanelViewPool.getInstance().getView(10);
        if (paramViewHolder == null)
        {
          if (QLog.isColorLevel())
          {
            paramViewHolder = new StringBuilder();
            paramViewHolder.append("getEmotionView positon = ");
            paramViewHolder.append(paramInt);
            paramViewHolder.append(";bigemotion view from inflater");
            QLog.d("EmotionCompleteInvalidAdapter", 2, paramViewHolder.toString());
          }
          paramViewHolder = new EmotionInvalidPanelLinearLayout(this.mContext, this.emotionPkg, 4, this.columnNum);
        }
        else if (QLog.isColorLevel())
        {
          paramView = new StringBuilder();
          paramView.append("getEmotionView positon = ");
          paramView.append(paramInt);
          paramView.append(";bigemotion view from cache");
          QLog.d("EmotionCompleteInvalidAdapter", 2, paramView.toString());
        }
      }
      if (this.isSmallEmotion) {
        recycleView(11, paramViewHolder);
      } else {
        recycleView(10, paramViewHolder);
      }
      paramViewGroup.addView(paramViewHolder, new FrameLayout.LayoutParams(-1, this.contentHight));
      paramViewGroup.addView((View)localObject2);
      ((EmotionCompleteInvalidAdapter.EmotionCompletedInvalidViewHolder)localObject1).panelLiearlayout = ((EmotionInvalidPanelLinearLayout)paramViewHolder);
      paramViewGroup.setTag(localObject1);
    }
    this.openBtn = ((EmotionCompleteInvalidAdapter.EmotionCompletedInvalidViewHolder)localObject1).downloadBtn;
    this.maskLayout = ((EmotionCompleteInvalidAdapter.EmotionCompletedInvalidViewHolder)localObject1).maskLayout;
    paramView = this.mContext.getString(2131897784);
    paramViewHolder = this.mContext.getString(2131897812);
    if (this.emotionFeeType == 2) {
      paramViewHolder = this.mContext.getString(2131897801);
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(this.mContext.getString(2131897803));
    ((StringBuilder)localObject2).append(paramViewHolder);
    ((StringBuilder)localObject2).append("专享,\n开通");
    ((StringBuilder)localObject2).append(paramViewHolder);
    ((StringBuilder)localObject2).append(this.mContext.getString(2131897813));
    paramViewHolder = ((StringBuilder)localObject2).toString();
    if (this.emotionPkg.mobileFeetype == 6)
    {
      paramViewHolder = this.mContext.getString(2131897763);
      paramView = this.mContext.getString(2131897809);
    }
    else if (this.emotionPkg.mobileFeetype == 2)
    {
      paramViewHolder = this.mContext.getString(2131897748);
      paramView = this.mContext.getString(2131897809);
    }
    else if (this.emotionPkg.mobileFeetype == 3)
    {
      paramViewHolder = this.mContext.getString(2131897780);
      paramView = this.mContext.getString(2131897809);
    }
    ((EmotionCompleteInvalidAdapter.EmotionCompletedInvalidViewHolder)localObject1).tips.setText(paramViewHolder);
    ((EmotionCompleteInvalidAdapter.EmotionCompletedInvalidViewHolder)localObject1).downloadBtn.setText(paramView);
    ((EmotionCompleteInvalidAdapter.EmotionCompletedInvalidViewHolder)localObject1).downloadBtn.setOnClickListener(this);
    paramViewHolder = ((EmotionCompleteInvalidAdapter.EmotionCompletedInvalidViewHolder)localObject1).panelLiearlayout;
    int n = paramViewHolder.getChildCount();
    int j = 0;
    paramInt = 0;
    int i = 0;
    while (j < n)
    {
      paramView = (LinearLayout)paramViewHolder.getChildAt(j);
      if (paramInt != 0)
      {
        paramView.setVisibility(8);
      }
      else
      {
        int i1 = paramView.getChildCount();
        int k = paramInt;
        int m = 0;
        paramInt = i;
        i = k;
        k = m;
        while (k < i1)
        {
          localObject1 = paramView.getChildAt(k);
          if (paramInt > this.data.size() - 1)
          {
            ((View)localObject1).setVisibility(8);
            i = 1;
          }
          else
          {
            ((View)localObject1).setVisibility(0);
            updateUI((View)localObject1, (EmotionPanelData)this.data.get(paramInt));
            paramInt += 1;
          }
          k += 1;
        }
        k = i;
        i = paramInt;
        paramInt = k;
      }
      j += 1;
    }
    return paramViewGroup;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 100)
    {
      paramMessage = this.maskLayout;
      if (paramMessage != null) {
        paramMessage.setVisibility(8);
      }
      paramMessage = (MqqHandlerProxy)this.app.getHandler(((IEmosmService)QRoute.api(IEmosmService.class)).getChatActivityClass());
      if (paramMessage != null) {
        paramMessage.sendToTarget(41);
      }
    }
    return true;
  }
  
  public BaseEmotionAdapter.ViewHolder newHolder()
  {
    return new EmotionCompleteInvalidAdapter.EmotionCompletedInvalidViewHolder();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131431558)
    {
      Object localObject1 = this.emotionPkg;
      if (localObject1 == null)
      {
        QLog.e("EmotionCompleteInvalidAdapter", 1, "onClick EP = NULL");
      }
      else if ((((EmoticonPackage)localObject1).mobileFeetype != 4) && (this.emotionPkg.mobileFeetype != 5))
      {
        if (!this.emotionPkg.valid)
        {
          boolean bool;
          if (this.emotionPkg.jobType == 4) {
            bool = true;
          } else {
            bool = false;
          }
          ((IBigEmotionService)QRoute.api(IBigEmotionService.class)).openEmojiDetailPage(this.mContext, this.app, this.app.getAccount(), 0, String.valueOf(this.emotionPkg.epId), false, null, bool);
        }
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("mvip.gexinghua.android.sbp_");
        ((StringBuilder)localObject1).append(this.emotionPkg.epId);
        Object localObject2 = ((StringBuilder)localObject1).toString();
        if (this.emotionPkg.mobileFeetype == 5) {
          localObject1 = "!svip";
        } else {
          localObject1 = "!vip";
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("https://mc.vip.qq.com/qqwallet/index?aid=");
        localStringBuilder.append((String)localObject2);
        localStringBuilder.append("&type=");
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append("&send=0&return_url=jsbridge://qw_charge/emojiPayResultOk");
        localObject1 = localStringBuilder.toString();
        if ((this.mContext instanceof Activity))
        {
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("url", (String)localObject1);
          RouteUtils.a((Activity)this.mContext, (Intent)localObject2, "/base/browser", 4813);
        }
        if (!this.isSmallEmotion) {
          ReportController.b(this.app.getQQAppInterface(), "CliOper", "", "", "ep_mall", "0X80057B3", 0, 0, this.emotionPkg.epId, "", "", "");
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
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