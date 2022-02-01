package com.tencent.mobileqq.qqexpand.utils;

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
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.io.File;

public class ProfileGuideDialogUtils
{
  public static final View.OnTouchListener a = new ProfileGuideDialogUtils.1();
  
  public static Dialog a(Context paramContext)
  {
    Object localObject1 = LayoutInflater.from(paramContext);
    Object localObject3 = null;
    View localView1 = ((LayoutInflater)localObject1).inflate(2131627402, null);
    View localView2 = localView1.findViewById(2131442926);
    View localView3 = localView1.findViewById(2131429883);
    ImageView localImageView = (ImageView)localView1.findViewById(2131442930);
    localView2.setOnTouchListener(a);
    localView3.setOnTouchListener(a);
    ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(DisplayUtil.a(paramContext, 320.0F), -2);
    String str = ExpandResourceUtil.a("expand_question_dialog.png");
    localObject1 = localObject3;
    if (new File(str).exists()) {
      try
      {
        localObject1 = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject1).inPreferredConfig = Bitmap.Config.RGB_565;
        localObject1 = ExpandResourceUtil.a(str, (BitmapFactory.Options)localObject1);
      }
      catch (Exception localException)
      {
        QLog.e("ProfileGuideDialogUtils", 1, "createQuestionDialog decode bitmap fail.", localException);
        localObject2 = localObject3;
      }
    }
    localImageView.setImageBitmap((Bitmap)localObject2);
    Object localObject2 = new ReportDialog(paramContext, 2131952232);
    ((Dialog)localObject2).addContentView(localView1, localLayoutParams);
    ((Dialog)localObject2).setCanceledOnTouchOutside(false);
    localView2.setOnClickListener(new ProfileGuideDialogUtils.2(paramContext, (Dialog)localObject2));
    localView3.setOnClickListener(new ProfileGuideDialogUtils.3((Dialog)localObject2));
    return localObject2;
  }
  
  public static Dialog a(Context paramContext, int paramInt, View.OnClickListener paramOnClickListener)
  {
    Object localObject1 = LayoutInflater.from(paramContext);
    TextView localTextView = null;
    View localView = ((LayoutInflater)localObject1).inflate(2131627401, null);
    localObject1 = localView.findViewById(2131429883);
    ((View)localObject1).setOnTouchListener(a);
    ((View)localObject1).setOnClickListener(paramOnClickListener);
    Button localButton = (Button)localView.findViewById(2131429947);
    localButton.setOnClickListener(paramOnClickListener);
    paramOnClickListener = new ViewGroup.LayoutParams(DisplayUtil.a(paramContext, 320.0F), -2);
    ReportDialog localReportDialog = new ReportDialog(paramContext, 2131952232);
    localReportDialog.addContentView(localView, paramOnClickListener);
    localReportDialog.setCanceledOnTouchOutside(false);
    int i;
    if (paramInt != 2)
    {
      localObject1 = ExpandResourceUtil.a("expand_guide_profile.png");
      localObject2 = HardCodeUtil.a(2131906265);
      paramOnClickListener = HardCodeUtil.a(2131906264);
      paramInt = DisplayUtil.a(paramContext, 163.0F);
      i = DisplayUtil.a(paramContext, 102.0F);
      paramContext = (Context)localObject2;
    }
    else
    {
      localObject1 = ExpandResourceUtil.a("expand_guide_switch.png");
      localObject2 = HardCodeUtil.a(2131906266);
      paramOnClickListener = HardCodeUtil.a(2131906267);
      paramInt = DisplayUtil.a(paramContext, 180.0F);
      i = DisplayUtil.a(paramContext, 102.0F);
      paramContext = (Context)localObject2;
    }
    Object localObject2 = localTextView;
    if (new File((String)localObject1).exists()) {
      try
      {
        localObject2 = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject2).inPreferredConfig = Bitmap.Config.RGB_565;
        localObject2 = ExpandResourceUtil.a((String)localObject1, (BitmapFactory.Options)localObject2);
      }
      catch (Exception localException)
      {
        QLog.e("ProfileGuideDialogUtils", 1, "showFirstGuide decode bitmap fail.", localException);
        localObject2 = localTextView;
      }
    }
    ImageView localImageView = (ImageView)localView.findViewById(2131435569);
    localTextView = (TextView)localView.findViewById(2131448960);
    localImageView.setImageBitmap((Bitmap)localObject2);
    localTextView.setText(paramContext);
    localButton.setText(paramOnClickListener);
    paramContext = localImageView.getLayoutParams();
    paramContext.width = paramInt;
    paramContext.height = i;
    localImageView.setLayoutParams(paramContext);
    return localReportDialog;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.utils.ProfileGuideDialogUtils
 * JD-Core Version:    0.7.0.1
 */