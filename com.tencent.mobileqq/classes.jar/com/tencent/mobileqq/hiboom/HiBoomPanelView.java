package com.tencent.mobileqq.hiboom;

import afur;
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
import anni;
import auzj;
import auzk;
import auzs;
import auzt;
import avad;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
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
  public auzs a;
  avad jdField_a_of_type_Avad;
  public BaseChatPie a;
  RichTextPanelRecyclerView jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanelRecyclerView;
  
  static
  {
    jdField_a_of_type_JavaLangString = anni.a(2131704270);
    Resources localResources = BaseApplicationImpl.sApplication.getResources();
    b = localResources.getDisplayMetrics().widthPixels / 4;
    jdField_a_of_type_Int = b;
    c = afur.a(2.0F, localResources);
    d = afur.a(11.0F, localResources);
  }
  
  public HiBoomPanelView(Context arg1, BaseChatPie paramBaseChatPie, avad paramavad)
  {
    super(???);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = null;
    this.jdField_a_of_type_Auzs = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
    setClipToPadding(false);
    this.jdField_a_of_type_Avad = paramavad;
    b();
    paramBaseChatPie = (auzk)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(219);
    synchronized (paramBaseChatPie.jdField_a_of_type_JavaLangObject)
    {
      paramBaseChatPie.jdField_a_of_type_AndroidOsHandler = this.jdField_a_of_type_AndroidOsHandler;
      return;
    }
  }
  
  auzt a(int paramInt)
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
        if ((localObject instanceof auzt))
        {
          localObject = (auzt)localObject;
          if (this.jdField_a_of_type_Auzs.a(((auzt)localObject).jdField_a_of_type_Int) == paramInt) {
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
    auzk localauzk = (auzk)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(219);
    if (!localauzk.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      localauzk.b();
      return;
    }
    this.jdField_a_of_type_Auzs.a(localauzk.jdField_a_of_type_JavaUtilVector, localauzk.b, localauzk.jdField_c_of_type_JavaUtilVector);
  }
  
  public void a(auzt paramauzt, int paramInt)
  {
    if (!paramauzt.jdField_a_of_type_Boolean) {
      return;
    }
    if (paramInt == -1)
    {
      paramauzt.itemView.setContentDescription(anni.a(2131704273));
      paramauzt.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      paramauzt.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      paramauzt.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView.setVisibility(8);
      paramauzt.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      paramauzt.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView.setVisibility(8);
      paramauzt.b.setVisibility(0);
      paramauzt.b.setImageResource(2130847147);
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getBoolean("hiboom_red_dot_show", false))
      {
        paramauzt.c.setVisibility(0);
        return;
      }
      paramauzt.c.setVisibility(8);
      return;
    }
    paramauzt.b.setVisibility(8);
    paramauzt.c.setVisibility(8);
    Object localObject = (auzk)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(219);
    if (auzk.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      paramauzt.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      auzj localauzj = ((auzk)localObject).a(paramInt);
      if (((auzk)localObject).b.contains(Integer.valueOf(paramInt)))
      {
        paramauzt.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView.jdField_a_of_type_Boolean = false;
        paramauzt.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        paramauzt.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130847153);
        paramauzt.jdField_a_of_type_AndroidWidgetTextView.setText(anni.a(2131704269));
      }
      while (localauzj.jdField_a_of_type_Boolean)
      {
        paramauzt.itemView.setContentDescription(localauzj.jdField_a_of_type_JavaLangString + anni.a(2131704268));
        paramauzt.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView.setVisibility(8);
        paramauzt.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        paramauzt.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView.setVisibility(0);
        paramauzt.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView.setHiBoom(localauzj.jdField_a_of_type_Int, 0, auzk.jdField_a_of_type_Auzd);
        String str = auzk.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString());
        localObject = str;
        if (TextUtils.isEmpty(str)) {
          localObject = localauzj.jdField_a_of_type_JavaLangString;
        }
        paramauzt.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView.setText((CharSequence)localObject);
        return;
        if (((auzk)localObject).jdField_c_of_type_JavaUtilVector.contains(Integer.valueOf(paramInt)))
        {
          paramauzt.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView.jdField_a_of_type_Boolean = false;
          paramauzt.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          paramauzt.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130847152);
          paramauzt.jdField_a_of_type_AndroidWidgetTextView.setText(anni.a(2131704271));
        }
        else
        {
          paramauzt.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView.jdField_a_of_type_Boolean = true;
          paramauzt.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        }
      }
      paramauzt.itemView.setContentDescription(anni.a(2131704272));
      paramauzt.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView.setVisibility(0);
      paramauzt.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      paramauzt.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView.setVisibility(8);
      if (localauzj.jdField_a_of_type_AndroidGraphicsBitmap != null) {
        paramauzt.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localauzj.jdField_a_of_type_AndroidGraphicsBitmap);
      }
      while (localauzj.b)
      {
        paramauzt.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView.a();
        paramauzt.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView.setProgress(localauzj.c);
        return;
        paramauzt.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130847148);
      }
      paramauzt.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView.b();
      return;
    }
    paramauzt.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    paramauzt.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView.setVisibility(8);
    paramauzt.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    paramauzt.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView.setVisibility(8);
  }
  
  public void a(boolean paramBoolean)
  {
    auzk localauzk = (auzk)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(219);
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("HiBoomFont.HiBoomPanelView", 2, "hiboom panel visible");
      }
      synchronized (localauzk.jdField_a_of_type_JavaLangObject)
      {
        localauzk.jdField_a_of_type_AndroidOsHandler = this.jdField_a_of_type_AndroidOsHandler;
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
    this.jdField_a_of_type_Auzs = new auzs(this);
    this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanelRecyclerView.setAdapter(this.jdField_a_of_type_Auzs);
    this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanelRecyclerView.setPanelExtendHelper(this.jdField_a_of_type_Avad);
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
      auzt localauzt = a(paramMessage.arg1);
      if (localauzt != null)
      {
        localauzt.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView.setProgress(paramMessage.arg2);
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