package com.tencent.mobileqq.olympic.activity;

import aepi;
import amts;
import amty;
import amuc;
import android.graphics.Bitmap;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import awbp;
import awbq;
import awbr;
import azqs;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;
import msp;

public class PromotionEntry
{
  public static final String a;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private awbr jdField_a_of_type_Awbr;
  private PromotionEntry.UpdateOperateBtnStatusRunnable jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionEntry$UpdateOperateBtnStatusRunnable;
  public boolean a;
  private boolean b = true;
  
  static
  {
    jdField_a_of_type_JavaLangString = amuc.jdField_a_of_type_JavaLangString;
  }
  
  public PromotionEntry(awbr paramawbr)
  {
    this.jdField_a_of_type_Awbr = paramawbr;
  }
  
  private void a(String paramString, amts paramamts, boolean paramBoolean)
  {
    String str = jdField_a_of_type_JavaLangString;
    paramString = new StringBuilder().append("updateOperateBtnStatus[").append(paramString).append("], visible[").append(paramBoolean).append("], mIsWorldCupMode[").append(this.jdField_a_of_type_Awbr.c()).append("], mEnterTransferDoorModeByClickEntry[").append(this.jdField_a_of_type_Boolean).append("], operateBtn[");
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.w(str, 1, bool + "]");
      if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
        break;
      }
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionEntry$UpdateOperateBtnStatusRunnable == null) {
      this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionEntry$UpdateOperateBtnStatusRunnable = new PromotionEntry.UpdateOperateBtnStatusRunnable(null);
    }
    if (paramamts != null) {
      this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionEntry$UpdateOperateBtnStatusRunnable.jdField_a_of_type_Amts = paramamts;
    }
    this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionEntry$UpdateOperateBtnStatusRunnable.jdField_a_of_type_Boolean = paramBoolean;
    PromotionEntry.UpdateOperateBtnStatusRunnable.a(this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionEntry$UpdateOperateBtnStatusRunnable, new WeakReference(this.jdField_a_of_type_AndroidWidgetImageView));
    ThreadManager.getUIHandler().removeCallbacks(this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionEntry$UpdateOperateBtnStatusRunnable);
    if (paramBoolean)
    {
      if (this.b)
      {
        azqs.b(null, "CliOper", "", "", "0X8009C6A", "0X8009C6A", 0, 0, paramamts.jdField_a_of_type_JavaLangString, "0", "0", "");
        this.b = false;
      }
      ThreadManager.getUIHandler().postDelayed(this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionEntry$UpdateOperateBtnStatusRunnable, 500L);
      return;
    }
    ThreadManager.getUIHandler().post(this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionEntry$UpdateOperateBtnStatusRunnable);
  }
  
  public void a(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_Awbr = null;
    this.b = true;
    if (this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionEntry$UpdateOperateBtnStatusRunnable != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionEntry$UpdateOperateBtnStatusRunnable.a();
      this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionEntry$UpdateOperateBtnStatusRunnable = null;
    }
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(null);
      this.jdField_a_of_type_AndroidWidgetImageView = null;
    }
  }
  
  public void a(AppInterface paramAppInterface, amts paramamts)
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      return;
    }
    paramAppInterface = this.jdField_a_of_type_Awbr.a();
    ImageView localImageView = new ImageView(paramAppInterface.getContext());
    Object localObject = amty.a(paramamts) + "entry.png";
    localObject = msp.a(localImageView.getResources(), (String)localObject);
    if (localObject != null) {
      localImageView.setImageBitmap((Bitmap)localObject);
    }
    localObject = new RelativeLayout.LayoutParams(aepi.a(217.0F, localImageView.getResources()), aepi.a(47.0F, localImageView.getResources()));
    ((RelativeLayout.LayoutParams)localObject).addRule(10, -1);
    ((RelativeLayout.LayoutParams)localObject).addRule(13);
    int j = ImmersiveUtils.b();
    int i = j;
    if (ImmersiveUtils.isSupporImmersive() != 1) {
      i = j - ImmersiveUtils.getStatusBarHeight(paramAppInterface.getContext());
    }
    ((RelativeLayout.LayoutParams)localObject).topMargin = ((int)(i * 23 / 200.0F));
    localImageView.setClickable(true);
    localImageView.setOnTouchListener(new awbp(this));
    localImageView.setOnClickListener(new awbq(this, paramamts));
    localImageView.setVisibility(8);
    paramAppInterface.addView(localImageView, (ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_AndroidWidgetImageView = localImageView;
    if (this.jdField_a_of_type_Awbr.c())
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "reallyCreateOperateEntry, 已经在穿越门模式了");
      return;
    }
    a("reallyCreateOperateEntry", paramamts, true);
  }
  
  public void a(boolean paramBoolean)
  {
    a("showEntry", null, paramBoolean);
  }
  
  public void a(boolean paramBoolean, amts paramamts)
  {
    a("operateBtnOnClick", paramamts, paramBoolean);
    this.jdField_a_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.olympic.activity.PromotionEntry
 * JD-Core Version:    0.7.0.1
 */