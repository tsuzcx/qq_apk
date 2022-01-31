package com.tencent.mobileqq.extendfriend.utils;

import acjy;
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
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class ProfileGuideDialogUtils
{
  public static final View.OnTouchListener a = new acjy();
  
  public static Dialog a(Context paramContext, int paramInt, View.OnClickListener paramOnClickListener)
  {
    Object localObject1 = LayoutInflater.from(paramContext).inflate(2130970335, null);
    Object localObject3 = ((View)localObject1).findViewById(2131363264);
    ((View)localObject3).setOnTouchListener(a);
    ((View)localObject3).setOnClickListener(paramOnClickListener);
    ImageView localImageView = (ImageView)((View)localObject1).findViewById(2131369919);
    TextView localTextView = (TextView)((View)localObject1).findViewById(2131362832);
    Button localButton = (Button)((View)localObject1).findViewById(2131370094);
    localButton.setOnClickListener(paramOnClickListener);
    paramOnClickListener = new ViewGroup.LayoutParams(AIOUtils.a(320.0F, paramContext.getResources()), -2);
    Dialog localDialog = new Dialog(paramContext, 2131624727);
    localDialog.addContentView((View)localObject1, paramOnClickListener);
    localDialog.setCanceledOnTouchOutside(false);
    int i;
    switch (paramInt)
    {
    default: 
      localObject1 = ExtendFriendResourceUtil.a("expand_guide_profile.png");
      paramOnClickListener = "填写扩列资料，才可以加好友哦~";
      localObject3 = "去填写";
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
        return localDialog;
      }
      catch (Exception localException)
      {
        QLog.e("ProfileGuideDialogUtils", 1, "showFirstGuide decode bitmap fail.", localException);
      }
      localObject1 = ExtendFriendResourceUtil.a("expand_guide_switch.png");
      paramOnClickListener = "哼，不展示扩列资料卡还想加好友？";
      localObject3 = "去打开";
      i = AIOUtils.a(180.0F, paramContext.getResources());
      paramInt = AIOUtils.a(102.0F, paramContext.getResources());
      paramContext = (Context)localObject3;
      break;
      Object localObject2 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.utils.ProfileGuideDialogUtils
 * JD-Core Version:    0.7.0.1
 */