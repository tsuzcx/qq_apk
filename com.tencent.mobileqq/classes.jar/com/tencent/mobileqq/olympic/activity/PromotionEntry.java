package com.tencent.mobileqq.olympic.activity;

import android.graphics.Bitmap;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.av.VideoUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.ARPromotionMgr.PromotionConfigInfo.PromotionItem;
import com.tencent.mobileqq.ar.ARPromotionMgr.PromotionPath;
import com.tencent.mobileqq.ar.ARPromotionMgr.PromotionUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

public class PromotionEntry
{
  static final String a = PromotionUtil.a;
  public boolean b = false;
  private ImageView c;
  private PromotionEntry.OnARPromotionEntryListenr d;
  private PromotionEntry.UpdateOperateBtnStatusRunnable e = null;
  private boolean f = true;
  
  public PromotionEntry(PromotionEntry.OnARPromotionEntryListenr paramOnARPromotionEntryListenr)
  {
    this.d = paramOnARPromotionEntryListenr;
  }
  
  private void a(String paramString, PromotionConfigInfo.PromotionItem paramPromotionItem, boolean paramBoolean)
  {
    String str = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateOperateBtnStatus[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("], visible[");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("], mIsWorldCupMode[");
    localStringBuilder.append(this.d.j());
    localStringBuilder.append("], mEnterTransferDoorModeByClickEntry[");
    localStringBuilder.append(this.b);
    localStringBuilder.append("], operateBtn[");
    boolean bool;
    if (this.c != null) {
      bool = true;
    } else {
      bool = false;
    }
    localStringBuilder.append(bool);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    if (this.c == null) {
      return;
    }
    if (this.e == null) {
      this.e = new PromotionEntry.UpdateOperateBtnStatusRunnable(null);
    }
    if (paramPromotionItem != null) {
      this.e.d = paramPromotionItem;
    }
    paramString = this.e;
    paramString.a = paramBoolean;
    PromotionEntry.UpdateOperateBtnStatusRunnable.a(paramString, new WeakReference(this.c));
    ThreadManager.getUIHandler().removeCallbacks(this.e);
    if (paramBoolean)
    {
      if (this.f)
      {
        if (paramPromotionItem != null) {
          paramString = paramPromotionItem.e;
        } else {
          paramString = "0";
        }
        ReportController.b(null, "CliOper", "", "", "0X8009C6A", "0X8009C6A", 0, 0, paramString, "0", "0", "");
        this.f = false;
      }
      ThreadManager.getUIHandler().postDelayed(this.e, 500L);
      return;
    }
    ThreadManager.getUIHandler().post(this.e);
  }
  
  public void a(AppInterface paramAppInterface)
  {
    this.d = null;
    this.f = true;
    paramAppInterface = this.e;
    if (paramAppInterface != null)
    {
      paramAppInterface.a();
      this.e = null;
    }
    paramAppInterface = this.c;
    if (paramAppInterface != null)
    {
      paramAppInterface.setOnClickListener(null);
      this.c = null;
    }
  }
  
  public void a(AppInterface paramAppInterface, PromotionConfigInfo.PromotionItem paramPromotionItem)
  {
    if (this.c != null) {
      return;
    }
    paramAppInterface = this.d.getTopView();
    ImageView localImageView = new ImageView(paramAppInterface.getContext());
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(PromotionPath.a(paramPromotionItem));
    ((StringBuilder)localObject).append("entry.png");
    localObject = ((StringBuilder)localObject).toString();
    localObject = VideoUtils.a(localImageView.getResources(), (String)localObject);
    if (localObject != null) {
      localImageView.setImageBitmap((Bitmap)localObject);
    }
    localObject = new RelativeLayout.LayoutParams(AIOUtils.b(217.0F, localImageView.getResources()), AIOUtils.b(47.0F, localImageView.getResources()));
    ((RelativeLayout.LayoutParams)localObject).addRule(10, -1);
    ((RelativeLayout.LayoutParams)localObject).addRule(13);
    int j = ImmersiveUtils.getScreenHeight();
    int i = j;
    if (ImmersiveUtils.isSupporImmersive() != 1) {
      i = j - ImmersiveUtils.getStatusBarHeight(paramAppInterface.getContext());
    }
    ((RelativeLayout.LayoutParams)localObject).topMargin = ((int)(i * 23 / 200.0F));
    localImageView.setClickable(true);
    localImageView.setOnTouchListener(new PromotionEntry.1(this));
    localImageView.setOnClickListener(new PromotionEntry.2(this, paramPromotionItem));
    localImageView.setVisibility(8);
    paramAppInterface.addView(localImageView, (ViewGroup.LayoutParams)localObject);
    this.c = localImageView;
    if (this.d.j())
    {
      QLog.w(a, 1, "reallyCreateOperateEntry, 已经在穿越门模式了");
      return;
    }
    a("reallyCreateOperateEntry", paramPromotionItem, true);
  }
  
  public void a(boolean paramBoolean)
  {
    a("showEntry", null, paramBoolean);
  }
  
  public void a(boolean paramBoolean, PromotionConfigInfo.PromotionItem paramPromotionItem)
  {
    a("operateBtnOnClick", paramPromotionItem, paramBoolean);
    this.b = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.olympic.activity.PromotionEntry
 * JD-Core Version:    0.7.0.1
 */