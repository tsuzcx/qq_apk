package com.tencent.mobileqq.mini.widget;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import bcuq;
import bdkf;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.qphone.base.util.QLog;

public class AuthDialog
  extends Dialog
{
  private static final String TAG = "AuthDialog";
  TextView mAuthDesc;
  TextView mAuthTitle;
  Bundle mData;
  private boolean mIsConfirm;
  private boolean mIsRefuse;
  TextView mLeftBtn;
  ImageView mMiniAppIcon;
  TextView mMiniAppName;
  TextView mRightBtn;
  ImageView mUserIcon;
  TextView mUserName;
  
  public AuthDialog(@NonNull Context paramContext)
  {
    super(paramContext, 2131755226);
    initView(paramContext);
  }
  
  private URLDrawable getUrlDrawable(String paramString, int paramInt)
  {
    Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject2).mPlayGifImage = false;
    ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = paramInt;
    ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = paramInt;
    Object localObject1 = null;
    try
    {
      localObject2 = URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject2);
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      do
      {
        localException.printStackTrace();
      } while (!QLog.isColorLevel());
      QLog.e("AuthDialog", 2, "getIcon url: " + paramString);
    }
    return localObject1;
    return null;
  }
  
  private void initView(@NonNull Context paramContext)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2131559292, null);
    setContentView(paramContext);
    this.mMiniAppIcon = ((ImageView)paramContext.findViewById(2131370474));
    this.mMiniAppName = ((TextView)paramContext.findViewById(2131370487));
    this.mAuthTitle = ((TextView)paramContext.findViewById(2131362916));
    this.mUserIcon = ((ImageView)paramContext.findViewById(2131379381));
    this.mUserName = ((TextView)paramContext.findViewById(2131379409));
    this.mAuthDesc = ((TextView)paramContext.findViewById(2131362906));
    this.mLeftBtn = ((TextView)paramContext.findViewById(2131369338));
    this.mRightBtn = ((TextView)paramContext.findViewById(2131375754));
    setCanceledOnTouchOutside(true);
    paramContext = getWindow();
    if (paramContext != null) {
      paramContext.setGravity(80);
    }
  }
  
  public void bindData(Bundle paramBundle)
  {
    this.mData = paramBundle;
  }
  
  public Bundle getData()
  {
    return this.mData;
  }
  
  public boolean isConfirm()
  {
    return this.mIsConfirm;
  }
  
  public boolean isRefuse()
  {
    return this.mIsRefuse;
  }
  
  public void setConfirm(boolean paramBoolean)
  {
    this.mIsConfirm = paramBoolean;
  }
  
  public void setRefuse(boolean paramBoolean)
  {
    this.mIsRefuse = paramBoolean;
  }
  
  public void show(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, View.OnClickListener paramOnClickListener1, String paramString8, View.OnClickListener paramOnClickListener2)
  {
    this.mIsConfirm = false;
    this.mIsRefuse = false;
    int i = bdkf.b(26.0F);
    paramString1 = getUrlDrawable(paramString1, i);
    if (paramString1 != null)
    {
      paramString1.setTag(bcuq.b(i, i, bdkf.b(5.0F)));
      paramString1.setDecodeHandler(bcuq.i);
      this.mMiniAppIcon.setImageDrawable(paramString1);
    }
    this.mMiniAppName.setText(paramString2);
    this.mAuthTitle.setText(paramString3);
    if (TextUtils.isEmpty(paramString4))
    {
      this.mUserIcon.setVisibility(8);
      if (!TextUtils.isEmpty(paramString5)) {
        break label219;
      }
      this.mUserName.setVisibility(8);
      label110:
      if (!TextUtils.isEmpty(paramString7)) {
        break label239;
      }
      this.mLeftBtn.setVisibility(8);
      label127:
      if (!TextUtils.isEmpty(paramString8)) {
        break label268;
      }
      this.mRightBtn.setVisibility(8);
      label144:
      if (!TextUtils.isEmpty(paramString6)) {
        break label297;
      }
      this.mAuthDesc.setVisibility(8);
    }
    for (;;)
    {
      show();
      return;
      paramString1 = getUrlDrawable(paramString4, bdkf.b(40.0F));
      if (paramString1 != null)
      {
        paramString1.setTag(bcuq.a(i, i));
        paramString1.setDecodeHandler(bcuq.a);
        this.mUserIcon.setImageDrawable(paramString1);
      }
      this.mUserIcon.setVisibility(0);
      break;
      label219:
      this.mUserName.setText(paramString5);
      this.mUserName.setVisibility(0);
      break label110;
      label239:
      this.mLeftBtn.setText(paramString7);
      this.mLeftBtn.setOnClickListener(paramOnClickListener1);
      this.mLeftBtn.setVisibility(0);
      break label127;
      label268:
      this.mRightBtn.setText(paramString8);
      this.mRightBtn.setOnClickListener(paramOnClickListener2);
      this.mRightBtn.setVisibility(0);
      break label144;
      label297:
      this.mAuthDesc.setVisibility(0);
      this.mAuthDesc.setText(paramString6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.AuthDialog
 * JD-Core Version:    0.7.0.1
 */