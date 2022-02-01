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
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class QQCustomDialogWtihForwardAvatar
  extends QQCustomDialog
{
  TextView a;
  RelativeLayout b;
  RelativeLayout c;
  RelativeLayout d;
  int i;
  
  public QQCustomDialogWtihForwardAvatar(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    this.i = AIOUtils.b(35.0F, paramContext.getResources());
  }
  
  public float a(Activity paramActivity, float paramFloat)
  {
    Display localDisplay = paramActivity.getWindowManager().getDefaultDisplay();
    float f1 = localDisplay.getWidth();
    float f2 = paramActivity.getResources().getDimensionPixelSize(2131296897);
    if (f2 > f1 * paramFloat)
    {
      f1 = f2 / localDisplay.getWidth();
      if ((f1 > paramFloat) && (f1 < 1.0D)) {
        return f1;
      }
    }
    return paramFloat;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString1, int paramInt, String paramString2, boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("uin: ");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(" uinType: ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" titleStr: ");
    ((StringBuilder)localObject).append(paramString2);
    QLog.i("Forward.Dialog", 1, ((StringBuilder)localObject).toString());
    this.b.setVisibility(0);
    this.title.setVisibility(8);
    this.d.setVisibility(8);
    this.c.setVisibility(0);
    this.a.setText(paramString2);
    localObject = (ImageView)this.b.findViewById(2131368718);
    RelativeLayout localRelativeLayout = (RelativeLayout)this.b.findViewById(2131378824);
    ImageView localImageView = (ImageView)this.b.findViewById(2131368716);
    QQCustomDialogWtihForwardAvatar.1 local1 = new QQCustomDialogWtihForwardAvatar.1(this, paramQQAppInterface, paramString2, paramString1, paramInt);
    paramActivity = new QQCustomDialogWtihForwardAvatar.2(this, paramInt, paramQQAppInterface, paramActivity, paramString1, paramString2);
    if ((paramInt != 0) && (paramInt != 1000))
    {
      if (paramInt == 1)
      {
        if (paramBoolean) {
          paramQQAppInterface = FaceDrawable.getFaceDrawable(paramQQAppInterface, 113, paramString1);
        } else {
          paramQQAppInterface = FaceDrawable.getFaceDrawable(paramQQAppInterface, 4, paramString1);
        }
        ((ImageView)localObject).setImageDrawable(paramQQAppInterface);
        ((ImageView)localObject).setOnClickListener(local1);
        localRelativeLayout.setOnClickListener(paramActivity);
        localRelativeLayout.setBackgroundResource(2130840143);
        return;
      }
      if (paramInt == 3000)
      {
        ((ImageView)localObject).setImageDrawable(FaceDrawable.getFaceDrawable(paramQQAppInterface, 101, paramString1));
        ((ImageView)localObject).setOnClickListener(local1);
        localRelativeLayout.setOnClickListener(paramActivity);
        localRelativeLayout.setBackgroundResource(2130840143);
        return;
      }
      if (paramInt == 1006)
      {
        ((ImageView)localObject).setImageDrawable(FaceDrawable.getFaceDrawable(paramQQAppInterface, 11, paramString1));
        this.c.setOnClickListener(paramActivity);
        this.c.setBackgroundResource(2130840143);
        return;
      }
      if (AppConstants.DATALINE_PC_UIN.equals(paramString1))
      {
        ((ImageView)localObject).setImageResource(2130844282);
        ((ImageView)localObject).setOnClickListener(local1);
        this.c.setOnClickListener(paramActivity);
        this.c.setBackgroundResource(2130840143);
        return;
      }
      if (AppConstants.DATALINE_IPAD_UIN.equals(paramString1))
      {
        ((ImageView)localObject).setImageResource(2130844277);
        ((ImageView)localObject).setOnClickListener(local1);
        this.c.setOnClickListener(paramActivity);
        this.c.setBackgroundResource(2130840143);
        return;
      }
      localImageView.setVisibility(8);
      ((ImageView)localObject).setImageDrawable(FaceDrawable.getDefaultDrawable(1, 3));
      return;
    }
    ((ImageView)localObject).setImageDrawable(FaceDrawable.getFaceDrawable(paramQQAppInterface, 1, paramString1));
    this.c.setOnClickListener(paramActivity);
    this.c.setBackgroundResource(2130840143);
  }
  
  @TargetApi(16)
  public void a(QQAppInterface paramQQAppInterface, Activity paramActivity, List<ResultRecord> paramList, boolean paramBoolean)
  {
    this.b.setVisibility(0);
    this.d.setVisibility(0);
    this.title.setVisibility(8);
    this.c.setVisibility(8);
    ((TextView)this.b.findViewById(2131380091)).setText(HardCodeUtil.a(2131710147));
    GridView localGridView = (GridView)this.b.findViewById(2131367935);
    localGridView.setNumColumns(5);
    localGridView.setHorizontalSpacing((AIOUtils.b(236.0F, getContext().getResources()) - this.i * 5) / 5);
    localGridView.setVerticalSpacing(AIOUtils.b(10.0F, getContext().getResources()));
    Object localObject = (RelativeLayout.LayoutParams)localGridView.getLayoutParams();
    int j;
    if (Build.VERSION.SDK_INT >= 16) {
      j = localGridView.getVerticalSpacing();
    } else {
      j = 0;
    }
    if (paramList.size() <= 5) {
      ((RelativeLayout.LayoutParams)localObject).height = this.i;
    } else {
      ((RelativeLayout.LayoutParams)localObject).height = (this.i * 2 + j);
    }
    localGridView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localGridView.setFocusable(false);
    localObject = null;
    if (paramBoolean) {
      localObject = new QQCustomDialogWtihForwardAvatar.3(this, paramActivity);
    }
    localGridView.setAdapter(new QQCustomDialogWtihForwardAvatar.ForwardTargetAdapter(this, paramQQAppInterface, getContext(), paramList, (View.OnClickListener)localObject));
  }
  
  public void c()
  {
    Object localObject = this.d;
    if (localObject == null) {
      return;
    }
    localObject = (ViewGroup.MarginLayoutParams)((RelativeLayout)localObject).getLayoutParams();
    ((ViewGroup.MarginLayoutParams)localObject).topMargin = AIOUtils.b(2.0F, getContext().getResources());
    this.d.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  public void c(String paramString)
  {
    this.title.setVisibility(8);
    this.b.setVisibility(0);
    ((TextView)this.b.findViewById(2131380091)).setText(paramString);
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
  
  @TargetApi(11)
  public void setContentView(int paramInt)
  {
    super.setContentView(paramInt);
    this.b = ((RelativeLayout)findViewById(2131376750));
    this.a = ((TextView)this.b.findViewById(2131380094));
    this.c = ((RelativeLayout)this.b.findViewById(2131368083));
    this.d = ((RelativeLayout)this.b.findViewById(2131368084));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomDialogWtihForwardAvatar
 * JD-Core Version:    0.7.0.1
 */