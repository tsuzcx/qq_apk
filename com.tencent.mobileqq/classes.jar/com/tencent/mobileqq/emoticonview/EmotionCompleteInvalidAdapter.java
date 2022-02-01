package com.tencent.mobileqq.emoticonview;

import amtj;
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
import bcef;
import bjmp;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
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
  private boolean isSmallEmotion;
  private MqqHandler mUiHandler = new bjmp(Looper.getMainLooper(), this, true);
  protected LinearLayout maskLayout;
  protected Button openBtn;
  
  public EmotionCompleteInvalidAdapter(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2, int paramInt3, EmoticonPackage paramEmoticonPackage, EmoticonCallback paramEmoticonCallback)
  {
    super(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonCallback);
    this.emotionPkg = paramEmoticonPackage;
    this.contentHight = (XPanelContainer.a - (int)paramContext.getResources().getDimension(2131296962));
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
    ((Button)localObject).setId(2131365275);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, (int)(25.0F * this.density));
    ((Button)localObject).setGravity(17);
    localLayoutParams.topMargin = ((int)(10.0F * this.density));
    localLayoutParams.gravity = 1;
    ((Button)localObject).setBackgroundDrawable(this.mContext.getResources().getDrawable(2130839360));
    ((Button)localObject).setTextColor(-14894864);
    ((Button)localObject).setPadding((int)(this.density * 30.0F), 0, (int)(this.density * 30.0F), 0);
    localLinearLayout.addView((View)localObject, localLayoutParams);
    paramEmotionCompletedInvalidViewHolder.maskLayout = localLinearLayout;
    paramEmotionCompletedInvalidViewHolder.tips = localTextView;
    paramEmotionCompletedInvalidViewHolder.downloadBtn = ((Button)localObject);
    return localLinearLayout;
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
      paramView = (URLImageView)paramView.findViewById(2131365977);
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
    label104:
    int i;
    label261:
    int j;
    label308:
    int m;
    int n;
    if (paramView == null)
    {
      paramViewGroup = new FrameLayout(this.mContext);
      LinearLayout localLinearLayout = getMaskLayout((EmotionCompleteInvalidAdapter.EmotionCompletedInvalidViewHolder)localObject);
      if (!this.isSmallEmotion) {
        break label380;
      }
      paramView = EmotionPanelViewPool.getInstance().getView(11);
      if (paramView == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("EmotionCompleteInvalidAdapter", 2, "getEmotionView smallemotion view from inflater");
        }
        paramViewHolder = new EmotionInvalidPanelLinearLayout(this.mContext, this.emotionPkg, 7, this.columnNum);
        if (!this.isSmallEmotion) {
          break label500;
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
      paramView = amtj.a(2131703234);
      paramViewHolder = amtj.a(2131703236);
      if (this.emotionFeeType == 2) {
        paramViewHolder = amtj.a(2131703237);
      }
      paramViewHolder = amtj.a(2131703230) + paramViewHolder + "专享,\n开通" + paramViewHolder + amtj.a(2131703233);
      if (this.emotionPkg.mobileFeetype != 6) {
        break label510;
      }
      paramViewHolder = amtj.a(2131703232);
      paramView = amtj.a(2131703227);
      ((EmotionCompleteInvalidAdapter.EmotionCompletedInvalidViewHolder)localObject).tips.setText(paramViewHolder);
      ((EmotionCompleteInvalidAdapter.EmotionCompletedInvalidViewHolder)localObject).downloadBtn.setText(paramView);
      ((EmotionCompleteInvalidAdapter.EmotionCompletedInvalidViewHolder)localObject).downloadBtn.setOnClickListener(this);
      i = 0;
      paramInt = 0;
      paramViewHolder = ((EmotionCompleteInvalidAdapter.EmotionCompletedInvalidViewHolder)localObject).panelLiearlayout;
      int i1 = paramViewHolder.getChildCount();
      j = 0;
      if (j >= i1) {
        break label666;
      }
      paramView = (LinearLayout)paramViewHolder.getChildAt(j);
      if (paramInt == 0) {
        break label566;
      }
      paramView.setVisibility(8);
      m = i;
      n = paramInt;
    }
    label380:
    label510:
    int i2;
    label500:
    int k;
    label566:
    do
    {
      j += 1;
      paramInt = n;
      i = m;
      break label308;
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
      break label104;
      if (this.emotionPkg.mobileFeetype == 2)
      {
        paramViewHolder = amtj.a(2131703229);
        paramView = amtj.a(2131703231);
        break label261;
      }
      if (this.emotionPkg.mobileFeetype != 3) {
        break label261;
      }
      paramViewHolder = amtj.a(2131703228);
      paramView = amtj.a(2131703235);
      break label261;
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
    label666:
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
      paramMessage = this.app.getHandler(ChatActivity.class);
      if (paramMessage != null) {
        paramMessage.obtainMessage(41).sendToTarget();
      }
    }
  }
  
  public BaseEmotionAdapter.ViewHolder newHolder()
  {
    return new EmotionCompleteInvalidAdapter.EmotionCompletedInvalidViewHolder();
  }
  
  public void onClick(View paramView)
  {
    boolean bool = true;
    if (paramView.getId() == 2131365275)
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
        Object localObject = "mvip.gexinghua.android.sbp_" + this.emotionPkg.epId;
        String str = "!vip";
        if (this.emotionPkg.mobileFeetype == 5) {
          str = "!svip";
        }
        str = "https://mc.vip.qq.com/qqwallet/index?aid=" + (String)localObject + "&type=" + str + "&send=0&return_url=jsbridge://qw_charge/emojiPayResultOk";
        localObject = new Intent(this.mContext, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("url", str);
        if ((this.mContext instanceof Activity)) {
          ((Activity)this.mContext).startActivityForResult((Intent)localObject, 4813);
        }
        if (!this.isSmallEmotion) {
          bcef.b(this.app, "CliOper", "", "", "ep_mall", "0X80057B3", 0, 0, this.emotionPkg.epId, "", "", "");
        }
      }
    } while (this.emotionPkg.valid);
    if (this.emotionPkg.jobType == 4) {}
    for (;;)
    {
      EmojiHomeUiPlugin.openEmojiDetailPage((Activity)this.mContext, this.app.getAccount(), 8, String.valueOf(this.emotionPkg.epId), false, bool);
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