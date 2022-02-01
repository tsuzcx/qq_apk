package com.tencent.mobileqq.hiboom;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.v7.widget.GridLayoutManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anvx;
import avkg;
import avkh;
import avkp;
import avkq;
import avla;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicBoolean;

public class HiBoomPanelView
  extends RichTextPanelView
  implements Handler.Callback
{
  public static int a;
  public static final String a;
  public static int b;
  public static int c;
  public static int d;
  public Handler a;
  GridLayoutManager jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager;
  public avkp a;
  avla jdField_a_of_type_Avla;
  public BaseChatPie a;
  RichTextPanelRecyclerView jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanelRecyclerView;
  
  static
  {
    jdField_a_of_type_JavaLangString = anvx.a(2131704958);
    Resources localResources = BaseApplicationImpl.sApplication.getResources();
    b = localResources.getDisplayMetrics().widthPixels / 4;
    jdField_a_of_type_Int = b;
    c = AIOUtils.dp2px(2.0F, localResources);
    d = AIOUtils.dp2px(11.0F, localResources);
  }
  
  public HiBoomPanelView(Context arg1, BaseChatPie paramBaseChatPie, avla paramavla)
  {
    super(???);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = null;
    this.jdField_a_of_type_Avkp = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
    setClipToPadding(false);
    this.jdField_a_of_type_Avla = paramavla;
    b();
    paramBaseChatPie = (avkh)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getManager(QQManagerFactory.HIBOOM_MANAGER);
    synchronized (paramBaseChatPie.jdField_a_of_type_JavaLangObject)
    {
      paramBaseChatPie.jdField_a_of_type_AndroidOsHandler = this.jdField_a_of_type_AndroidOsHandler;
      return;
    }
  }
  
  avkq a(int paramInt)
  {
    int j = this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager.findFirstVisibleItemPosition();
    int k = this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager.findLastVisibleItemPosition();
    int i = j;
    while (i <= k)
    {
      Object localObject = this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager.getChildAt(i - j);
      if (localObject != null)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanelRecyclerView.getChildViewHolder((View)localObject);
        if ((localObject instanceof avkq))
        {
          localObject = (avkq)localObject;
          if (this.jdField_a_of_type_Avkp.a(((avkq)localObject).jdField_a_of_type_Int) == paramInt) {
            return localObject;
          }
        }
      }
      i += 1;
    }
    return null;
  }
  
  public String a()
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    avkh localavkh = (avkh)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getManager(QQManagerFactory.HIBOOM_MANAGER);
    if (!localavkh.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      localavkh.b();
      return;
    }
    this.jdField_a_of_type_Avkp.a(localavkh.jdField_a_of_type_JavaUtilVector, localavkh.b, localavkh.jdField_c_of_type_JavaUtilVector);
  }
  
  public void a(avkq paramavkq, int paramInt)
  {
    if (!paramavkq.jdField_a_of_type_Boolean) {
      return;
    }
    if (paramInt == -1)
    {
      paramavkq.itemView.setContentDescription(anvx.a(2131704961));
      paramavkq.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      paramavkq.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      paramavkq.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView.setVisibility(8);
      paramavkq.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      paramavkq.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView.setVisibility(8);
      paramavkq.b.setVisibility(0);
      paramavkq.b.setImageResource(2130847170);
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getPreferences().getBoolean("hiboom_red_dot_show", false))
      {
        paramavkq.c.setVisibility(0);
        return;
      }
      paramavkq.c.setVisibility(8);
      return;
    }
    paramavkq.b.setVisibility(8);
    paramavkq.c.setVisibility(8);
    Object localObject = (avkh)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getManager(QQManagerFactory.HIBOOM_MANAGER);
    if (avkh.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      paramavkq.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      avkg localavkg = ((avkh)localObject).a(paramInt);
      if (((avkh)localObject).b.contains(Integer.valueOf(paramInt)))
      {
        paramavkq.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView.jdField_a_of_type_Boolean = false;
        paramavkq.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        paramavkq.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130847176);
        paramavkq.jdField_a_of_type_AndroidWidgetTextView.setText(anvx.a(2131704957));
      }
      while (localavkg.jdField_a_of_type_Boolean)
      {
        paramavkq.itemView.setContentDescription(localavkg.jdField_a_of_type_JavaLangString + anvx.a(2131704956));
        paramavkq.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView.setVisibility(8);
        paramavkq.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        paramavkq.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView.setVisibility(0);
        paramavkq.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView.setHiBoom(localavkg.jdField_a_of_type_Int, 0, avkh.jdField_a_of_type_Avka);
        String str = avkh.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.input.getText().toString());
        localObject = str;
        if (TextUtils.isEmpty(str)) {
          localObject = localavkg.jdField_a_of_type_JavaLangString;
        }
        paramavkq.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView.setText((CharSequence)localObject);
        return;
        if (((avkh)localObject).jdField_c_of_type_JavaUtilVector.contains(Integer.valueOf(paramInt)))
        {
          paramavkq.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView.jdField_a_of_type_Boolean = false;
          paramavkq.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          paramavkq.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130847175);
          paramavkq.jdField_a_of_type_AndroidWidgetTextView.setText(anvx.a(2131704959));
        }
        else
        {
          paramavkq.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView.jdField_a_of_type_Boolean = true;
          paramavkq.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        }
      }
      paramavkq.itemView.setContentDescription(anvx.a(2131704960));
      paramavkq.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView.setVisibility(0);
      paramavkq.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      paramavkq.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView.setVisibility(8);
      if (localavkg.jdField_a_of_type_AndroidGraphicsBitmap != null) {
        paramavkq.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localavkg.jdField_a_of_type_AndroidGraphicsBitmap);
      }
      while (localavkg.b)
      {
        paramavkq.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView.a();
        paramavkq.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView.setProgress(localavkg.c);
        return;
        paramavkq.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130847171);
      }
      paramavkq.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView.b();
      return;
    }
    paramavkq.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    paramavkq.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView.setVisibility(8);
    paramavkq.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    paramavkq.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView.setVisibility(8);
  }
  
  public void a(boolean paramBoolean)
  {
    avkh localavkh = (avkh)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getManager(QQManagerFactory.HIBOOM_MANAGER);
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("HiBoomFont.HiBoomPanelView", 2, "hiboom panel visible");
      }
      synchronized (localavkh.jdField_a_of_type_JavaLangObject)
      {
        localavkh.jdField_a_of_type_AndroidOsHandler = this.jdField_a_of_type_AndroidOsHandler;
        a();
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("HiBoomFont.HiBoomPanelView", 2, "hiboom panel gone");
    }
    synchronized (localObject1.jdField_a_of_type_JavaLangObject)
    {
      localObject1.jdField_a_of_type_AndroidOsHandler = null;
      return;
    }
  }
  
  @TargetApi(9)
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanelRecyclerView = new RichTextPanelRecyclerView(getContext());
    this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanelRecyclerView.setOverScrollMode(2);
    this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager = new GridLayoutManager(getContext(), 4);
    this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanelRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    addView(this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanelRecyclerView, localLayoutParams);
    this.jdField_a_of_type_Avkp = new avkp(this);
    this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanelRecyclerView.setAdapter(this.jdField_a_of_type_Avkp);
    this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanelRecyclerView.setPanelExtendHelper(this.jdField_a_of_type_Avla);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      a();
      continue;
      avkq localavkq = a(paramMessage.arg1);
      if (localavkq != null)
      {
        localavkq.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView.setProgress(paramMessage.arg2);
        continue;
        int i = paramMessage.arg1;
        paramMessage = a(i);
        if (paramMessage != null) {
          a(paramMessage, i);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.HiBoomPanelView
 * JD-Core Version:    0.7.0.1
 */