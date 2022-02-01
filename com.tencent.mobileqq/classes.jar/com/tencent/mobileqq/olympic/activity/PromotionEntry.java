package com.tencent.mobileqq.olympic.activity;

import android.graphics.Bitmap;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import apcn;
import apct;
import apcx;
import ayxt;
import ayxu;
import ayxv;
import bdla;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;
import mqx;

public class PromotionEntry
{
  public static final String a;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private ayxv jdField_a_of_type_Ayxv;
  private PromotionEntry.UpdateOperateBtnStatusRunnable jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionEntry$UpdateOperateBtnStatusRunnable;
  public boolean a;
  private boolean b = true;
  
  static
  {
    jdField_a_of_type_JavaLangString = apcx.jdField_a_of_type_JavaLangString;
  }
  
  public PromotionEntry(ayxv paramayxv)
  {
    this.jdField_a_of_type_Ayxv = paramayxv;
  }
  
  private void a(String paramString, apcn paramapcn, boolean paramBoolean)
  {
    String str = jdField_a_of_type_JavaLangString;
    paramString = new StringBuilder().append("updateOperateBtnStatus[").append(paramString).append("], visible[").append(paramBoolean).append("], mIsWorldCupMode[").append(this.jdField_a_of_type_Ayxv.d()).append("], mEnterTransferDoorModeByClickEntry[").append(this.jdField_a_of_type_Boolean).append("], operateBtn[");
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
    if (paramapcn != null) {
      this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionEntry$UpdateOperateBtnStatusRunnable.jdField_a_of_type_Apcn = paramapcn;
    }
    this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionEntry$UpdateOperateBtnStatusRunnable.jdField_a_of_type_Boolean = paramBoolean;
    PromotionEntry.UpdateOperateBtnStatusRunnable.a(this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionEntry$UpdateOperateBtnStatusRunnable, new WeakReference(this.jdField_a_of_type_AndroidWidgetImageView));
    ThreadManager.getUIHandler().removeCallbacks(this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionEntry$UpdateOperateBtnStatusRunnable);
    if (paramBoolean)
    {
      if (this.b) {
        if (paramapcn == null) {
          break label240;
        }
      }
      label240:
      for (paramString = paramapcn.jdField_a_of_type_JavaLangString;; paramString = "0")
      {
        bdla.b(null, "CliOper", "", "", "0X8009C6A", "0X8009C6A", 0, 0, paramString, "0", "0", "");
        this.b = false;
        ThreadManager.getUIHandler().postDelayed(this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionEntry$UpdateOperateBtnStatusRunnable, 500L);
        return;
      }
    }
    ThreadManager.getUIHandler().post(this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionEntry$UpdateOperateBtnStatusRunnable);
  }
  
  public void a(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_Ayxv = null;
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
  
  public void a(AppInterface paramAppInterface, apcn paramapcn)
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      return;
    }
    paramAppInterface = this.jdField_a_of_type_Ayxv.a();
    ImageView localImageView = new ImageView(paramAppInterface.getContext());
    Object localObject = apct.a(paramapcn) + "entry.png";
    localObject = mqx.a(localImageView.getResources(), (String)localObject);
    if (localObject != null) {
      localImageView.setImageBitmap((Bitmap)localObject);
    }
    localObject = new RelativeLayout.LayoutParams(AIOUtils.dp2px(217.0F, localImageView.getResources()), AIOUtils.dp2px(47.0F, localImageView.getResources()));
    ((RelativeLayout.LayoutParams)localObject).addRule(10, -1);
    ((RelativeLayout.LayoutParams)localObject).addRule(13);
    int j = ImmersiveUtils.b();
    int i = j;
    if (ImmersiveUtils.isSupporImmersive() != 1) {
      i = j - ImmersiveUtils.getStatusBarHeight(paramAppInterface.getContext());
    }
    ((RelativeLayout.LayoutParams)localObject).topMargin = ((int)(i * 23 / 200.0F));
    localImageView.setClickable(true);
    localImageView.setOnTouchListener(new ayxt(this));
    localImageView.setOnClickListener(new ayxu(this, paramapcn));
    localImageView.setVisibility(8);
    paramAppInterface.addView(localImageView, (ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_AndroidWidgetImageView = localImageView;
    if (this.jdField_a_of_type_Ayxv.d())
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "reallyCreateOperateEntry, 已经在穿越门模式了");
      return;
    }
    a("reallyCreateOperateEntry", paramapcn, true);
  }
  
  public void a(boolean paramBoolean)
  {
    a("showEntry", null, paramBoolean);
  }
  
  public void a(boolean paramBoolean, apcn paramapcn)
  {
    a("operateBtnOnClick", paramapcn, paramBoolean);
    this.jdField_a_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.olympic.activity.PromotionEntry
 * JD-Core Version:    0.7.0.1
 */