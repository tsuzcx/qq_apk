package com.tencent.mobileqq.popanim;

import android.content.res.Resources;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleAnimationView;
import com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleAnimationView.StickerBubbleAnimationCallback;
import com.tencent.mobileqq.apollo.script.api.ISpriteCommFunc;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.popanim.util.PopOutEmoticonUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class PopOutEmoticonReceive
  implements StickerBubbleAnimationView.StickerBubbleAnimationCallback, Runnable
{
  private int jdField_a_of_type_Int;
  private Handler jdField_a_of_type_AndroidOsHandler = ThreadManager.getUIHandlerV2();
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private PopOutAnimConfig jdField_a_of_type_ComTencentMobileqqPopanimPopOutAnimConfig;
  private Runnable jdField_a_of_type_JavaLangRunnable = new PopOutEmoticonReceive.1(this);
  private AppRuntime jdField_a_of_type_MqqAppAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
  private boolean jdField_a_of_type_Boolean;
  private int[] jdField_a_of_type_ArrayOfInt;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  private boolean e;
  
  public PopOutEmoticonReceive(ViewGroup paramViewGroup, PopOutAnimConfig paramPopOutAnimConfig, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    this.jdField_a_of_type_ComTencentMobileqqPopanimPopOutAnimConfig = paramPopOutAnimConfig;
    this.jdField_a_of_type_Int = QQSysFaceUtil.convertToLocal(paramInt1);
    this.jdField_b_of_type_Int = paramInt2;
    this.d = (((ISpriteCommFunc)QRoute.api(ISpriteCommFunc.class)).isSpriteHidden(this.jdField_a_of_type_MqqAppAppRuntime) ^ true);
    PopOutAnimViewHolder.a().a(this, false);
  }
  
  @NonNull
  private int[] a()
  {
    int[] arrayOfInt = this.jdField_a_of_type_ComTencentMobileqqPopanimPopOutAnimConfig.itemCountRecShowAppear;
    if (this.jdField_b_of_type_Int * 80 < 5000) {
      return arrayOfInt;
    }
    int n = arrayOfInt.length;
    int m = 0;
    int j = 0;
    int k;
    for (int i = 0; j < n; i = k)
    {
      k = i;
      if (arrayOfInt[j] <= this.jdField_b_of_type_Int) {
        k = i + 1;
      }
      j += 1;
    }
    arrayOfInt = new int[i];
    n = 62 / i;
    for (j = m; j < i; j = k)
    {
      k = j + 1;
      arrayOfInt[j] = (n * k);
    }
    return arrayOfInt;
  }
  
  private void b()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_ComTencentMobileqqPopanimPopOutAnimConfig.stopShakeAnimation();
    PopOutAnimViewHolder.a().b(this, false);
    if (this.d)
    {
      ((ISpriteCommFunc)QRoute.api(ISpriteCommFunc.class)).showOrHideSprite(this.jdField_a_of_type_MqqAppAppRuntime, "StickerBubble", false);
      this.e = true;
    }
  }
  
  public void a()
  {
    b();
  }
  
  public void a(int paramInt)
  {
    b();
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PopOutEmoticonReceive", 2, "showReceiveAnimationView from runnable");
    }
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    if ((this.d) && (!this.e))
    {
      ((ISpriteCommFunc)QRoute.api(ISpriteCommFunc.class)).showOrHideSprite(this.jdField_a_of_type_MqqAppAppRuntime, "StickerBubble", true);
      this.e = true;
    }
    StickerBubbleAnimationView localStickerBubbleAnimationView = PopOutAnimViewHolder.a().b(this.jdField_a_of_type_AndroidViewViewGroup, this.jdField_a_of_type_ComTencentMobileqqPopanimPopOutAnimConfig.typeface);
    if (!this.jdField_b_of_type_Boolean)
    {
      localStickerBubbleAnimationView.bringToFront();
      this.jdField_b_of_type_Boolean = true;
    }
    this.jdField_c_of_type_Int += 1;
    int i = this.jdField_c_of_type_Int;
    if ((i <= this.jdField_b_of_type_Int) && (i * 80 <= 5000))
    {
      if (i == 2)
      {
        this.jdField_a_of_type_ComTencentMobileqqPopanimPopOutAnimConfig.startShakeAnimation();
        this.jdField_c_of_type_Boolean = false;
      }
      if (this.jdField_a_of_type_ArrayOfInt == null) {
        this.jdField_a_of_type_ArrayOfInt = a();
      }
      i = this.jdField_a_of_type_AndroidViewViewGroup.getResources().getDisplayMetrics().widthPixels;
      boolean bool = PopOutEmoticonUtil.a(this.jdField_c_of_type_Int, this.jdField_a_of_type_ArrayOfInt);
      String str = PopOutEmoticonUtil.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqPopanimPopOutAnimConfig.apngSoLoaded);
      PopOutAnimViewHolder.a();
      localStickerBubbleAnimationView.a(PopOutAnimViewHolder.a(i, str, bool));
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this, 80L);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PopOutEmoticonReceive", 2, "receiver animation sending finished ");
    }
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 3000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.popanim.PopOutEmoticonReceive
 * JD-Core Version:    0.7.0.1
 */