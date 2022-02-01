package com.tencent.mobileqq.stt.ui;

import android.content.res.Resources;
import android.os.Handler;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.graphics.ColorUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.item.PttItemBuilder.Holder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.stt.shard.AIOSttResult;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class PttSttItemAnimator
{
  public int a;
  volatile SpannableString jdField_a_of_type_AndroidTextSpannableString = new SpannableString("");
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  MessageForPtt jdField_a_of_type_ComTencentMobileqqDataMessageForPtt;
  WeakReference<PttItemBuilder.Holder> jdField_a_of_type_JavaLangRefWeakReference;
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int = 0;
  private boolean jdField_b_of_type_Boolean = true;
  
  public PttSttItemAnimator() {}
  
  public PttSttItemAnimator(QQAppInterface paramQQAppInterface, MessageForPtt paramMessageForPtt, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt = paramMessageForPtt;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private int a()
  {
    int j = BaseApplicationImpl.getContext().getResources().getColor(2131167041);
    Object localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
    int i = j;
    if (localObject != null)
    {
      i = j;
      if (!((WeakReference)localObject).isEnqueued())
      {
        localObject = (PttItemBuilder.Holder)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        i = j;
        if (localObject != null)
        {
          i = j;
          if (((PttItemBuilder.Holder)localObject).jdField_a_of_type_AndroidWidgetTextView != null) {
            i = ((PttItemBuilder.Holder)localObject).jdField_a_of_type_AndroidWidgetTextView.getCurrentTextColor();
          }
        }
      }
    }
    return i;
  }
  
  public static boolean a(MessageForPtt paramMessageForPtt)
  {
    if (paramMessageForPtt == null) {
      return false;
    }
    if (paramMessageForPtt.sttAbility != 3)
    {
      if (!paramMessageForPtt.expandStt) {
        return false;
      }
      return paramMessageForPtt.getSttResult().a();
    }
    return false;
  }
  
  private int b()
  {
    return ColorUtils.setAlphaComponent(a(), 128);
  }
  
  public static boolean b(MessageForPtt paramMessageForPtt)
  {
    if (paramMessageForPtt == null) {
      return true;
    }
    if (paramMessageForPtt.getSttResult().a() == 4) {
      return true;
    }
    return (!StringUtil.a(paramMessageForPtt.sttText)) && (!paramMessageForPtt.getSttResult().a());
  }
  
  private void i()
  {
    WeakReference localWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      ((PttItemBuilder.Holder)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt, a(), this.jdField_a_of_type_Int);
    }
  }
  
  public SpannableString a()
  {
    return this.jdField_a_of_type_AndroidTextSpannableString;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
  }
  
  public void a(Handler paramHandler)
  {
    if (paramHandler == null) {
      return;
    }
    paramHandler.post(new PttSttItemAnimator.1(this));
  }
  
  public void a(PttItemBuilder.Holder paramHolder)
  {
    if (paramHolder != null) {
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramHolder);
    }
  }
  
  void a(String paramString)
  {
    this.jdField_a_of_type_AndroidTextSpannableString = new SpannableString(paramString);
    if (this.jdField_a_of_type_AndroidTextSpannableString.length() > 0) {
      this.jdField_a_of_type_AndroidTextSpannableString.setSpan(new ForegroundColorSpan(a()), 0, this.jdField_a_of_type_AndroidTextSpannableString.length(), 17);
    }
    b();
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  void b()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  void b(String paramString)
  {
    c(paramString);
    c();
  }
  
  public boolean b()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  void c()
  {
    int i = this.jdField_a_of_type_AndroidTextSpannableString.length();
    if (i <= 0) {
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidTextSpannableString.setSpan(new ForegroundColorSpan(a()), 0, i, 17);
      return;
    }
    if (i == 2)
    {
      this.jdField_a_of_type_AndroidTextSpannableString.setSpan(new ForegroundColorSpan(b()), 0, 2, 17);
      return;
    }
    if (i >= 4)
    {
      int j = this.jdField_b_of_type_Int + 2 - 3;
      this.jdField_a_of_type_AndroidTextSpannableString.setSpan(new ForegroundColorSpan(a()), 0, j, 17);
      this.jdField_a_of_type_AndroidTextSpannableString.setSpan(new ForegroundColorSpan(b()), j, i, 17);
    }
  }
  
  void c(String paramString)
  {
    if (paramString == null) {
      return;
    }
    int i = paramString.length();
    if (i <= 0)
    {
      this.jdField_a_of_type_AndroidTextSpannableString = new SpannableString("");
      return;
    }
    int j = this.jdField_b_of_type_Int;
    if (j == 0)
    {
      if (i >= 2)
      {
        this.jdField_a_of_type_AndroidTextSpannableString = new SpannableString(paramString.substring(0, 2));
        this.jdField_b_of_type_Int += 2;
        return;
      }
      this.jdField_a_of_type_AndroidTextSpannableString = new SpannableString("");
      return;
    }
    if (j >= 2)
    {
      if (i - j >= 2)
      {
        this.jdField_a_of_type_AndroidTextSpannableString = new SpannableString(paramString.substring(0, j + 2));
        this.jdField_b_of_type_Int += 2;
        return;
      }
      if (i % 2 != 0) {
        i -= 1;
      }
      this.jdField_a_of_type_AndroidTextSpannableString = new SpannableString(paramString.substring(0, i));
      this.jdField_b_of_type_Int = i;
    }
  }
  
  public void d()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt;
    if ((localObject != null) && (((MessageForPtt)localObject).getSttResult() != null))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.getSttResult().a();
      int i = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.getSttResult().a();
      if (i != 2)
      {
        if (i != 3) {
          return;
        }
        a((String)localObject);
        return;
      }
      b((String)localObject);
      return;
    }
    this.jdField_a_of_type_AndroidTextSpannableString = new SpannableString("");
  }
  
  void e()
  {
    this.jdField_a_of_type_AndroidTextSpannableString = new SpannableString("");
    WeakReference localWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      ((PttItemBuilder.Holder)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt, this.jdField_a_of_type_AndroidTextSpannableString, this.jdField_a_of_type_Int);
    }
  }
  
  public void f()
  {
    this.jdField_b_of_type_Int = 0;
    e();
  }
  
  public void g()
  {
    Object localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
    if ((localObject != null) && (((WeakReference)localObject).get() != null))
    {
      localObject = (PttItemBuilder.Holder)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (((PttItemBuilder.Holder)localObject).jdField_a_of_type_AndroidWidgetProgressBar != null)
      {
        ((PttItemBuilder.Holder)localObject).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        ((PttItemBuilder.Holder)localObject).jdField_a_of_type_AndroidWidgetProgressBar.setIndeterminate(true);
        if (QLog.isColorLevel()) {
          QLog.d("Q.stt_PttSttItemAnimator", 2, "stt repush, progress appear again");
        }
      }
    }
  }
  
  public void h()
  {
    MessageForPtt localMessageForPtt = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt;
    if ((localMessageForPtt != null) && (localMessageForPtt.getSttResult() != null)) {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.getSttResult().c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.stt.ui.PttSttItemAnimator
 * JD-Core Version:    0.7.0.1
 */