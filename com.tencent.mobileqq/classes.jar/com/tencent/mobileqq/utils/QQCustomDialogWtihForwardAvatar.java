package com.tencent.mobileqq.utils;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.view.Display;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.WindowManager;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anvx;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class QQCustomDialogWtihForwardAvatar
  extends QQCustomDialog
{
  private static final String TAG = "QQCustomDialogWithForwardAvatar";
  int mImgvHeadWidth;
  RelativeLayout mRlForwardTarget;
  RelativeLayout mRlMultiForwardTarget;
  RelativeLayout mRlTitle;
  TextView mTxvTitle;
  
  public QQCustomDialogWtihForwardAvatar(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    this.mImgvHeadWidth = AIOUtils.dp2px(35.0F, paramContext.getResources());
  }
  
  public void adjustMultiForwardMargins()
  {
    if (this.mRlMultiForwardTarget == null) {
      return;
    }
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.mRlMultiForwardTarget.getLayoutParams();
    localMarginLayoutParams.topMargin = AIOUtils.dp2px(2.0F, getContext().getResources());
    this.mRlMultiForwardTarget.setLayoutParams(localMarginLayoutParams);
  }
  
  public void dismiss()
  {
    if (hasPreViewInDialog())
    {
      removePreviewView();
      return;
    }
    super.dismiss();
  }
  
  public float getElasticScaleRation(Activity paramActivity, float paramFloat)
  {
    Display localDisplay = paramActivity.getWindowManager().getDefaultDisplay();
    float f2 = localDisplay.getWidth();
    int i = paramActivity.getResources().getDimensionPixelSize(2131296897);
    float f1 = paramFloat;
    if (i > f2 * paramFloat)
    {
      f2 = i / localDisplay.getWidth();
      f1 = paramFloat;
      if (f2 > paramFloat)
      {
        f1 = paramFloat;
        if (f2 < 1.0D) {
          f1 = f2;
        }
      }
    }
    return f1;
  }
  
  public void setAvatarTitle(String paramString)
  {
    this.title.setVisibility(8);
    this.mRlTitle.setVisibility(0);
    ((TextView)this.mRlTitle.findViewById(2131380385)).setText(paramString);
  }
  
  @TargetApi(11)
  public void setContentView(int paramInt)
  {
    super.setContentView(paramInt);
    this.mRlTitle = ((RelativeLayout)findViewById(2131376888));
    this.mTxvTitle = ((TextView)this.mRlTitle.findViewById(2131380388));
    this.mRlForwardTarget = ((RelativeLayout)this.mRlTitle.findViewById(2131368112));
    this.mRlMultiForwardTarget = ((RelativeLayout)this.mRlTitle.findViewById(2131368113));
  }
  
  public void showForwardTargetAvatar(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString1, int paramInt, String paramString2, boolean paramBoolean)
  {
    QLog.i("Forward.Dialog", 1, "uin: " + paramString1 + " uinType: " + paramInt + " titleStr: " + paramString2);
    this.mRlTitle.setVisibility(0);
    this.title.setVisibility(8);
    this.mRlMultiForwardTarget.setVisibility(8);
    this.mRlForwardTarget.setVisibility(0);
    this.mTxvTitle.setText(paramString2);
    ImageView localImageView1 = (ImageView)this.mRlTitle.findViewById(2131368764);
    RelativeLayout localRelativeLayout = (RelativeLayout)this.mRlTitle.findViewById(2131379041);
    ImageView localImageView2 = (ImageView)this.mRlTitle.findViewById(2131368762);
    QQCustomDialogWtihForwardAvatar.1 local1 = new QQCustomDialogWtihForwardAvatar.1(this, paramQQAppInterface, paramString2, paramString1, paramInt);
    paramActivity = new QQCustomDialogWtihForwardAvatar.2(this, paramInt, paramQQAppInterface, paramActivity, paramString1, paramString2);
    if ((paramInt == 0) || (paramInt == 1000))
    {
      localImageView1.setImageDrawable(FaceDrawable.getFaceDrawable(paramQQAppInterface, 1, paramString1));
      this.mRlForwardTarget.setOnClickListener(paramActivity);
      this.mRlForwardTarget.setBackgroundResource(2130840193);
      return;
    }
    if (paramInt == 1)
    {
      if (paramBoolean) {}
      for (paramQQAppInterface = FaceDrawable.getFaceDrawable(paramQQAppInterface, 113, paramString1);; paramQQAppInterface = FaceDrawable.getFaceDrawable(paramQQAppInterface, 4, paramString1))
      {
        localImageView1.setImageDrawable(paramQQAppInterface);
        localImageView1.setOnClickListener(local1);
        localRelativeLayout.setOnClickListener(paramActivity);
        localRelativeLayout.setBackgroundResource(2130840193);
        return;
      }
    }
    if (paramInt == 3000)
    {
      localImageView1.setImageDrawable(FaceDrawable.getFaceDrawable(paramQQAppInterface, 101, paramString1));
      localImageView1.setOnClickListener(local1);
      localRelativeLayout.setOnClickListener(paramActivity);
      localRelativeLayout.setBackgroundResource(2130840193);
      return;
    }
    if (paramInt == 1006)
    {
      localImageView1.setImageDrawable(FaceDrawable.getFaceDrawable(paramQQAppInterface, 11, paramString1));
      this.mRlForwardTarget.setOnClickListener(paramActivity);
      this.mRlForwardTarget.setBackgroundResource(2130840193);
      return;
    }
    if (AppConstants.DATALINE_PC_UIN.equals(paramString1))
    {
      localImageView1.setImageResource(2130844186);
      localImageView1.setOnClickListener(local1);
      this.mRlForwardTarget.setOnClickListener(paramActivity);
      this.mRlForwardTarget.setBackgroundResource(2130840193);
      return;
    }
    if (AppConstants.DATALINE_IPAD_UIN.equals(paramString1))
    {
      localImageView1.setImageResource(2130844184);
      localImageView1.setOnClickListener(local1);
      this.mRlForwardTarget.setOnClickListener(paramActivity);
      this.mRlForwardTarget.setBackgroundResource(2130840193);
      return;
    }
    localImageView2.setVisibility(8);
    localImageView1.setImageDrawable(FaceDrawable.getDefaultDrawable(1, 3));
  }
  
  @TargetApi(16)
  public void showForwardTargetAvatar(QQAppInterface paramQQAppInterface, Activity paramActivity, List<ResultRecord> paramList, boolean paramBoolean)
  {
    this.mRlTitle.setVisibility(0);
    this.mRlMultiForwardTarget.setVisibility(0);
    this.title.setVisibility(8);
    this.mRlForwardTarget.setVisibility(8);
    ((TextView)this.mRlTitle.findViewById(2131380385)).setText(anvx.a(2131709650));
    GridView localGridView = (GridView)this.mRlTitle.findViewById(2131367975);
    localGridView.setNumColumns(5);
    localGridView.setHorizontalSpacing((AIOUtils.dp2px(236.0F, getContext().getResources()) - this.mImgvHeadWidth * 5) / 5);
    localGridView.setVerticalSpacing(AIOUtils.dp2px(10.0F, getContext().getResources()));
    Object localObject = (RelativeLayout.LayoutParams)localGridView.getLayoutParams();
    if (Build.VERSION.SDK_INT >= 16) {}
    for (int i = localGridView.getVerticalSpacing();; i = 0)
    {
      if (paramList.size() <= 5) {}
      for (((RelativeLayout.LayoutParams)localObject).height = this.mImgvHeadWidth;; ((RelativeLayout.LayoutParams)localObject).height = (i + this.mImgvHeadWidth * 2))
      {
        localGridView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        localGridView.setFocusable(false);
        localObject = null;
        if (paramBoolean) {
          localObject = new QQCustomDialogWtihForwardAvatar.3(this, paramActivity);
        }
        localGridView.setAdapter(new QQCustomDialogWtihForwardAvatar.ForwardTargetAdapter(this, paramQQAppInterface, getContext(), paramList, (View.OnClickListener)localObject));
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomDialogWtihForwardAvatar
 * JD-Core Version:    0.7.0.1
 */