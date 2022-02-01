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
import com.tencent.mobileqq.guild.api.IQQGuildService;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class QQCustomDialogWtihForwardAvatar
  extends QQCustomDialog
{
  RelativeLayout A;
  TextView B;
  RelativeLayout C;
  RelativeLayout D;
  int E;
  
  public QQCustomDialogWtihForwardAvatar(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    this.E = AIOUtils.b(35.0F, paramContext.getResources());
  }
  
  public float a(Activity paramActivity, float paramFloat)
  {
    Display localDisplay = paramActivity.getWindowManager().getDefaultDisplay();
    float f1 = localDisplay.getWidth();
    float f2 = paramActivity.getResources().getDimensionPixelSize(2131297276);
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
    this.A.setVisibility(0);
    this.title.setVisibility(8);
    this.D.setVisibility(8);
    this.C.setVisibility(0);
    this.B.setText(paramString2);
    localObject = (ImageView)this.A.findViewById(2131435631);
    RelativeLayout localRelativeLayout = (RelativeLayout)this.A.findViewById(2131447507);
    ImageView localImageView = (ImageView)this.A.findViewById(2131435629);
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
        localRelativeLayout.setBackgroundResource(2130840448);
        return;
      }
      if (paramInt == 3000)
      {
        ((ImageView)localObject).setImageDrawable(FaceDrawable.getFaceDrawable(paramQQAppInterface, 101, paramString1));
        ((ImageView)localObject).setOnClickListener(local1);
        localRelativeLayout.setOnClickListener(paramActivity);
        localRelativeLayout.setBackgroundResource(2130840448);
        return;
      }
      if (paramInt == 1006)
      {
        ((ImageView)localObject).setImageDrawable(FaceDrawable.getFaceDrawable(paramQQAppInterface, 11, paramString1));
        this.C.setOnClickListener(paramActivity);
        this.C.setBackgroundResource(2130840448);
        return;
      }
      if (paramInt == 10014)
      {
        ((ImageView)localObject).setImageDrawable(((IQQGuildService)paramQQAppInterface.getRuntimeService(IQQGuildService.class, "")).getAvatarDrawable(paramString1, 100, null, true));
        localImageView.setVisibility(8);
        this.C.setBackgroundResource(2131168376);
        return;
      }
      if (AppConstants.DATALINE_PC_UIN.equals(paramString1))
      {
        ((ImageView)localObject).setImageResource(2130845599);
        ((ImageView)localObject).setOnClickListener(local1);
        this.C.setOnClickListener(paramActivity);
        this.C.setBackgroundResource(2130840448);
        return;
      }
      if (AppConstants.DATALINE_IPAD_UIN.equals(paramString1))
      {
        ((ImageView)localObject).setImageResource(2130845594);
        ((ImageView)localObject).setOnClickListener(local1);
        this.C.setOnClickListener(paramActivity);
        this.C.setBackgroundResource(2130840448);
        return;
      }
      localImageView.setVisibility(8);
      ((ImageView)localObject).setImageDrawable(FaceDrawable.getDefaultDrawable(1, 3));
      return;
    }
    ((ImageView)localObject).setImageDrawable(FaceDrawable.getFaceDrawable(paramQQAppInterface, 1, paramString1));
    this.C.setOnClickListener(paramActivity);
    this.C.setBackgroundResource(2130840448);
  }
  
  @TargetApi(16)
  public void a(QQAppInterface paramQQAppInterface, Activity paramActivity, List<ResultRecord> paramList, boolean paramBoolean)
  {
    this.A.setVisibility(0);
    this.D.setVisibility(0);
    this.title.setVisibility(8);
    this.C.setVisibility(8);
    ((TextView)this.A.findViewById(2131449004)).setText(HardCodeUtil.a(2131907852));
    GridView localGridView = (GridView)this.A.findViewById(2131434773);
    localGridView.setNumColumns(5);
    localGridView.setHorizontalSpacing((AIOUtils.b(236.0F, getContext().getResources()) - this.E * 5) / 5);
    localGridView.setVerticalSpacing(AIOUtils.b(10.0F, getContext().getResources()));
    Object localObject = (RelativeLayout.LayoutParams)localGridView.getLayoutParams();
    int i;
    if (Build.VERSION.SDK_INT >= 16) {
      i = localGridView.getVerticalSpacing();
    } else {
      i = 0;
    }
    if (paramList.size() <= 5) {
      ((RelativeLayout.LayoutParams)localObject).height = this.E;
    } else {
      ((RelativeLayout.LayoutParams)localObject).height = (this.E * 2 + i);
    }
    localGridView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localGridView.setFocusable(false);
    localObject = null;
    if (paramBoolean) {
      localObject = new QQCustomDialogWtihForwardAvatar.3(this, paramActivity);
    }
    localGridView.setAdapter(new QQCustomDialogWtihForwardAvatar.ForwardTargetAdapter(this, paramQQAppInterface, getContext(), paramList, (View.OnClickListener)localObject));
  }
  
  public void d()
  {
    Object localObject = this.D;
    if (localObject == null) {
      return;
    }
    localObject = (ViewGroup.MarginLayoutParams)((RelativeLayout)localObject).getLayoutParams();
    ((ViewGroup.MarginLayoutParams)localObject).topMargin = AIOUtils.b(2.0F, getContext().getResources());
    this.D.setLayoutParams((ViewGroup.LayoutParams)localObject);
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
  
  public void e(String paramString)
  {
    this.title.setVisibility(8);
    this.A.setVisibility(0);
    ((TextView)this.A.findViewById(2131449004)).setText(paramString);
  }
  
  @TargetApi(11)
  public void setContentView(int paramInt)
  {
    super.setContentView(paramInt);
    this.A = ((RelativeLayout)findViewById(2131445041));
    this.B = ((TextView)this.A.findViewById(2131449007));
    this.C = ((RelativeLayout)this.A.findViewById(2131434935));
    this.D = ((RelativeLayout)this.A.findViewById(2131434936));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomDialogWtihForwardAvatar
 * JD-Core Version:    0.7.0.1
 */