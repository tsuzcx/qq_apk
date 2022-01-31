package com.tencent.mobileqq.olympic.activity;

import aciy;
import akkc;
import akki;
import akkm;
import android.graphics.Bitmap;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import atib;
import atic;
import atid;
import awqx;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.ref.WeakReference;
import mez;
import mqq.os.MqqHandler;

public class PromotionEntry
{
  public static final String a;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private atid jdField_a_of_type_Atid;
  private PromotionEntry.UpdateOperateBtnStatusRunnable jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionEntry$UpdateOperateBtnStatusRunnable;
  public boolean a;
  private boolean b = true;
  
  static
  {
    jdField_a_of_type_JavaLangString = akkm.jdField_a_of_type_JavaLangString;
  }
  
  public PromotionEntry(atid paramatid)
  {
    this.jdField_a_of_type_Atid = paramatid;
  }
  
  private void a(String paramString, akkc paramakkc, boolean paramBoolean)
  {
    String str = jdField_a_of_type_JavaLangString;
    paramString = new StringBuilder().append("updateOperateBtnStatus[").append(paramString).append("], visible[").append(paramBoolean).append("], mIsWorldCupMode[").append(this.jdField_a_of_type_Atid.c()).append("], mEnterTransferDoorModeByClickEntry[").append(this.jdField_a_of_type_Boolean).append("], operateBtn[");
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
    if (paramakkc != null) {
      this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionEntry$UpdateOperateBtnStatusRunnable.jdField_a_of_type_Akkc = paramakkc;
    }
    this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionEntry$UpdateOperateBtnStatusRunnable.jdField_a_of_type_Boolean = paramBoolean;
    PromotionEntry.UpdateOperateBtnStatusRunnable.a(this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionEntry$UpdateOperateBtnStatusRunnable, new WeakReference(this.jdField_a_of_type_AndroidWidgetImageView));
    ThreadManager.getUIHandler().removeCallbacks(this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionEntry$UpdateOperateBtnStatusRunnable);
    if (paramBoolean)
    {
      if (this.b)
      {
        awqx.b(null, "CliOper", "", "", "0X8009C6A", "0X8009C6A", 0, 0, paramakkc.jdField_a_of_type_JavaLangString, "0", "0", "");
        this.b = false;
      }
      ThreadManager.getUIHandler().postDelayed(this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionEntry$UpdateOperateBtnStatusRunnable, 500L);
      return;
    }
    ThreadManager.getUIHandler().post(this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionEntry$UpdateOperateBtnStatusRunnable);
  }
  
  public void a(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_Atid = null;
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
  
  public void a(AppInterface paramAppInterface, akkc paramakkc)
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      return;
    }
    paramAppInterface = this.jdField_a_of_type_Atid.a();
    ImageView localImageView = new ImageView(paramAppInterface.getContext());
    Object localObject = akki.a(paramakkc) + "entry.png";
    localObject = mez.a(localImageView.getResources(), (String)localObject);
    if (localObject != null) {
      localImageView.setImageBitmap((Bitmap)localObject);
    }
    localObject = new RelativeLayout.LayoutParams(aciy.a(217.0F, localImageView.getResources()), aciy.a(47.0F, localImageView.getResources()));
    ((RelativeLayout.LayoutParams)localObject).addRule(10, -1);
    ((RelativeLayout.LayoutParams)localObject).addRule(13);
    int j = ImmersiveUtils.b();
    int i = j;
    if (ImmersiveUtils.isSupporImmersive() != 1) {
      i = j - ImmersiveUtils.getStatusBarHeight(paramAppInterface.getContext());
    }
    ((RelativeLayout.LayoutParams)localObject).topMargin = ((int)(i * 23 / 200.0F));
    localImageView.setClickable(true);
    localImageView.setOnTouchListener(new atib(this));
    localImageView.setOnClickListener(new atic(this, paramakkc));
    localImageView.setVisibility(8);
    paramAppInterface.addView(localImageView, (ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_AndroidWidgetImageView = localImageView;
    if (this.jdField_a_of_type_Atid.c())
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "reallyCreateOperateEntry, 已经在穿越门模式了");
      return;
    }
    a("reallyCreateOperateEntry", paramakkc, true);
  }
  
  public void a(boolean paramBoolean)
  {
    a("showEntry", null, paramBoolean);
  }
  
  public void a(boolean paramBoolean, akkc paramakkc)
  {
    a("operateBtnOnClick", paramakkc, paramBoolean);
    this.jdField_a_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.olympic.activity.PromotionEntry
 * JD-Core Version:    0.7.0.1
 */