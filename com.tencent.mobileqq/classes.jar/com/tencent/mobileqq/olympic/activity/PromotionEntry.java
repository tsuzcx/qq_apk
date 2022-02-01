package com.tencent.mobileqq.olympic.activity;

import afur;
import android.graphics.Bitmap;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import aosj;
import aosp;
import aost;
import aylh;
import ayli;
import aylj;
import bcst;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.ref.WeakReference;
import mpu;
import mqq.os.MqqHandler;

public class PromotionEntry
{
  public static final String a;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private aylj jdField_a_of_type_Aylj;
  private PromotionEntry.UpdateOperateBtnStatusRunnable jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionEntry$UpdateOperateBtnStatusRunnable;
  public boolean a;
  private boolean b = true;
  
  static
  {
    jdField_a_of_type_JavaLangString = aost.jdField_a_of_type_JavaLangString;
  }
  
  public PromotionEntry(aylj paramaylj)
  {
    this.jdField_a_of_type_Aylj = paramaylj;
  }
  
  private void a(String paramString, aosj paramaosj, boolean paramBoolean)
  {
    String str = jdField_a_of_type_JavaLangString;
    paramString = new StringBuilder().append("updateOperateBtnStatus[").append(paramString).append("], visible[").append(paramBoolean).append("], mIsWorldCupMode[").append(this.jdField_a_of_type_Aylj.c()).append("], mEnterTransferDoorModeByClickEntry[").append(this.jdField_a_of_type_Boolean).append("], operateBtn[");
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
    if (paramaosj != null) {
      this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionEntry$UpdateOperateBtnStatusRunnable.jdField_a_of_type_Aosj = paramaosj;
    }
    this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionEntry$UpdateOperateBtnStatusRunnable.jdField_a_of_type_Boolean = paramBoolean;
    PromotionEntry.UpdateOperateBtnStatusRunnable.a(this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionEntry$UpdateOperateBtnStatusRunnable, new WeakReference(this.jdField_a_of_type_AndroidWidgetImageView));
    ThreadManager.getUIHandler().removeCallbacks(this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionEntry$UpdateOperateBtnStatusRunnable);
    if (paramBoolean)
    {
      if (this.b)
      {
        bcst.b(null, "CliOper", "", "", "0X8009C6A", "0X8009C6A", 0, 0, paramaosj.jdField_a_of_type_JavaLangString, "0", "0", "");
        this.b = false;
      }
      ThreadManager.getUIHandler().postDelayed(this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionEntry$UpdateOperateBtnStatusRunnable, 500L);
      return;
    }
    ThreadManager.getUIHandler().post(this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionEntry$UpdateOperateBtnStatusRunnable);
  }
  
  public void a(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_Aylj = null;
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
  
  public void a(AppInterface paramAppInterface, aosj paramaosj)
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      return;
    }
    paramAppInterface = this.jdField_a_of_type_Aylj.a();
    ImageView localImageView = new ImageView(paramAppInterface.getContext());
    Object localObject = aosp.a(paramaosj) + "entry.png";
    localObject = mpu.a(localImageView.getResources(), (String)localObject);
    if (localObject != null) {
      localImageView.setImageBitmap((Bitmap)localObject);
    }
    localObject = new RelativeLayout.LayoutParams(afur.a(217.0F, localImageView.getResources()), afur.a(47.0F, localImageView.getResources()));
    ((RelativeLayout.LayoutParams)localObject).addRule(10, -1);
    ((RelativeLayout.LayoutParams)localObject).addRule(13);
    int j = ImmersiveUtils.b();
    int i = j;
    if (ImmersiveUtils.isSupporImmersive() != 1) {
      i = j - ImmersiveUtils.getStatusBarHeight(paramAppInterface.getContext());
    }
    ((RelativeLayout.LayoutParams)localObject).topMargin = ((int)(i * 23 / 200.0F));
    localImageView.setClickable(true);
    localImageView.setOnTouchListener(new aylh(this));
    localImageView.setOnClickListener(new ayli(this, paramaosj));
    localImageView.setVisibility(8);
    paramAppInterface.addView(localImageView, (ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_AndroidWidgetImageView = localImageView;
    if (this.jdField_a_of_type_Aylj.c())
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "reallyCreateOperateEntry, 已经在穿越门模式了");
      return;
    }
    a("reallyCreateOperateEntry", paramaosj, true);
  }
  
  public void a(boolean paramBoolean)
  {
    a("showEntry", null, paramBoolean);
  }
  
  public void a(boolean paramBoolean, aosj paramaosj)
  {
    a("operateBtnOnClick", paramaosj, paramBoolean);
    this.jdField_a_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.olympic.activity.PromotionEntry
 * JD-Core Version:    0.7.0.1
 */