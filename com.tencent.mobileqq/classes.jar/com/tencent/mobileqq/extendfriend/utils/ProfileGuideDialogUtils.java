package com.tencent.mobileqq.extendfriend.utils;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.io.File;

public class ProfileGuideDialogUtils
{
  public static final View.OnTouchListener a = new ProfileGuideDialogUtils.1();
  
  public static Dialog a(Context paramContext)
  {
    Object localObject3 = null;
    View localView1 = LayoutInflater.from(paramContext).inflate(2131561233, null);
    View localView2 = localView1.findViewById(2131375222);
    View localView3 = localView1.findViewById(2131364000);
    ImageView localImageView = (ImageView)localView1.findViewById(2131375226);
    localView2.setOnTouchListener(a);
    localView3.setOnTouchListener(a);
    ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(AIOUtils.a(320.0F, paramContext.getResources()), -2);
    String str = ExtendFriendResourceUtil.a("expand_question_dialog.png");
    Object localObject1 = localObject3;
    if (new File(str).exists()) {}
    try
    {
      localObject1 = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject1).inPreferredConfig = Bitmap.Config.RGB_565;
      localObject1 = ExtendFriendResourceUtil.a(str, (BitmapFactory.Options)localObject1);
      localImageView.setImageBitmap((Bitmap)localObject1);
      localObject1 = new ReportDialog(paramContext, 2131755272);
      ((Dialog)localObject1).addContentView(localView1, localLayoutParams);
      ((Dialog)localObject1).setCanceledOnTouchOutside(false);
      localView2.setOnClickListener(new ProfileGuideDialogUtils.2(paramContext, (Dialog)localObject1));
      localView3.setOnClickListener(new ProfileGuideDialogUtils.3((Dialog)localObject1));
      return localObject1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("ProfileGuideDialogUtils", 1, "createQuestionDialog decode bitmap fail.", localException);
        Object localObject2 = localObject3;
      }
    }
  }
  
  public static Dialog a(Context paramContext, int paramInt, View.OnClickListener paramOnClickListener)
  {
    Object localObject1 = LayoutInflater.from(paramContext).inflate(2131561231, null);
    Object localObject3 = ((View)localObject1).findViewById(2131364000);
    ((View)localObject3).setOnTouchListener(a);
    ((View)localObject3).setOnClickListener(paramOnClickListener);
    ImageView localImageView = (ImageView)((View)localObject1).findViewById(2131368935);
    TextView localTextView = (TextView)((View)localObject1).findViewById(2131380790);
    Button localButton = (Button)((View)localObject1).findViewById(2131364069);
    localButton.setOnClickListener(paramOnClickListener);
    paramOnClickListener = new ViewGroup.LayoutParams(AIOUtils.a(320.0F, paramContext.getResources()), -2);
    ReportDialog localReportDialog = new ReportDialog(paramContext, 2131755272);
    localReportDialog.addContentView((View)localObject1, paramOnClickListener);
    localReportDialog.setCanceledOnTouchOutside(false);
    int i;
    switch (paramInt)
    {
    default: 
      localObject1 = ExtendFriendResourceUtil.a("expand_guide_profile.png");
      paramOnClickListener = HardCodeUtil.a(2131708473);
      localObject3 = HardCodeUtil.a(2131708472);
      i = AIOUtils.a(163.0F, paramContext.getResources());
      paramInt = AIOUtils.a(102.0F, paramContext.getResources());
      paramContext = (Context)localObject3;
      if (!new File((String)localObject1).exists()) {
        break;
      }
    }
    for (;;)
    {
      try
      {
        localObject3 = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject3).inPreferredConfig = Bitmap.Config.RGB_565;
        localObject1 = ExtendFriendResourceUtil.a((String)localObject1, (BitmapFactory.Options)localObject3);
        localImageView.setImageBitmap((Bitmap)localObject1);
        localTextView.setText(paramOnClickListener);
        localButton.setText(paramContext);
        paramContext = localImageView.getLayoutParams();
        paramContext.width = i;
        paramContext.height = paramInt;
        localImageView.setLayoutParams(paramContext);
        return localReportDialog;
      }
      catch (Exception localException)
      {
        QLog.e("ProfileGuideDialogUtils", 1, "showFirstGuide decode bitmap fail.", localException);
      }
      localObject1 = ExtendFriendResourceUtil.a("expand_guide_switch.png");
      paramOnClickListener = HardCodeUtil.a(2131708474);
      localObject3 = HardCodeUtil.a(2131708475);
      i = AIOUtils.a(180.0F, paramContext.getResources());
      paramInt = AIOUtils.a(102.0F, paramContext.getResources());
      paramContext = (Context)localObject3;
      break;
      Object localObject2 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.utils.ProfileGuideDialogUtils
 * JD-Core Version:    0.7.0.1
 */