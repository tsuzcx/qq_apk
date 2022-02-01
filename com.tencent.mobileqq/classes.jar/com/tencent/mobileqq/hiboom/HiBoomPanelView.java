package com.tencent.mobileqq.hiboom;

import agej;
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
import anzj;
import avrk;
import avrl;
import avrt;
import avru;
import avse;
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
  public avrt a;
  avse jdField_a_of_type_Avse;
  public BaseChatPie a;
  RichTextPanelRecyclerView jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanelRecyclerView;
  
  static
  {
    jdField_a_of_type_JavaLangString = anzj.a(2131704377);
    Resources localResources = BaseApplicationImpl.sApplication.getResources();
    b = localResources.getDisplayMetrics().widthPixels / 4;
    jdField_a_of_type_Int = b;
    c = agej.a(2.0F, localResources);
    d = agej.a(11.0F, localResources);
  }
  
  public HiBoomPanelView(Context arg1, BaseChatPie paramBaseChatPie, avse paramavse)
  {
    super(???);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = null;
    this.jdField_a_of_type_Avrt = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
    setClipToPadding(false);
    this.jdField_a_of_type_Avse = paramavse;
    b();
    paramBaseChatPie = (avrl)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(219);
    synchronized (paramBaseChatPie.jdField_a_of_type_JavaLangObject)
    {
      paramBaseChatPie.jdField_a_of_type_AndroidOsHandler = this.jdField_a_of_type_AndroidOsHandler;
      return;
    }
  }
  
  avru a(int paramInt)
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
        if ((localObject instanceof avru))
        {
          localObject = (avru)localObject;
          if (this.jdField_a_of_type_Avrt.a(((avru)localObject).jdField_a_of_type_Int) == paramInt) {
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
    avrl localavrl = (avrl)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(219);
    if (!localavrl.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      localavrl.b();
      return;
    }
    this.jdField_a_of_type_Avrt.a(localavrl.jdField_a_of_type_JavaUtilVector, localavrl.b, localavrl.jdField_c_of_type_JavaUtilVector);
  }
  
  public void a(avru paramavru, int paramInt)
  {
    if (!paramavru.jdField_a_of_type_Boolean) {
      return;
    }
    if (paramInt == -1)
    {
      paramavru.itemView.setContentDescription(anzj.a(2131704380));
      paramavru.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      paramavru.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      paramavru.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView.setVisibility(8);
      paramavru.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      paramavru.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView.setVisibility(8);
      paramavru.b.setVisibility(0);
      paramavru.b.setImageResource(2130847164);
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getBoolean("hiboom_red_dot_show", false))
      {
        paramavru.c.setVisibility(0);
        return;
      }
      paramavru.c.setVisibility(8);
      return;
    }
    paramavru.b.setVisibility(8);
    paramavru.c.setVisibility(8);
    Object localObject = (avrl)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(219);
    if (avrl.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      paramavru.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      avrk localavrk = ((avrl)localObject).a(paramInt);
      if (((avrl)localObject).b.contains(Integer.valueOf(paramInt)))
      {
        paramavru.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView.jdField_a_of_type_Boolean = false;
        paramavru.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        paramavru.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130847170);
        paramavru.jdField_a_of_type_AndroidWidgetTextView.setText(anzj.a(2131704376));
      }
      while (localavrk.jdField_a_of_type_Boolean)
      {
        paramavru.itemView.setContentDescription(localavrk.jdField_a_of_type_JavaLangString + anzj.a(2131704375));
        paramavru.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView.setVisibility(8);
        paramavru.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        paramavru.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView.setVisibility(0);
        paramavru.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView.setHiBoom(localavrk.jdField_a_of_type_Int, 0, avrl.jdField_a_of_type_Avre);
        String str = avrl.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString());
        localObject = str;
        if (TextUtils.isEmpty(str)) {
          localObject = localavrk.jdField_a_of_type_JavaLangString;
        }
        paramavru.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView.setText((CharSequence)localObject);
        return;
        if (((avrl)localObject).jdField_c_of_type_JavaUtilVector.contains(Integer.valueOf(paramInt)))
        {
          paramavru.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView.jdField_a_of_type_Boolean = false;
          paramavru.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          paramavru.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130847169);
          paramavru.jdField_a_of_type_AndroidWidgetTextView.setText(anzj.a(2131704378));
        }
        else
        {
          paramavru.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView.jdField_a_of_type_Boolean = true;
          paramavru.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        }
      }
      paramavru.itemView.setContentDescription(anzj.a(2131704379));
      paramavru.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView.setVisibility(0);
      paramavru.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      paramavru.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView.setVisibility(8);
      if (localavrk.jdField_a_of_type_AndroidGraphicsBitmap != null) {
        paramavru.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localavrk.jdField_a_of_type_AndroidGraphicsBitmap);
      }
      while (localavrk.b)
      {
        paramavru.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView.a();
        paramavru.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView.setProgress(localavrk.c);
        return;
        paramavru.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130847165);
      }
      paramavru.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView.b();
      return;
    }
    paramavru.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    paramavru.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView.setVisibility(8);
    paramavru.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    paramavru.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView.setVisibility(8);
  }
  
  public void a(boolean paramBoolean)
  {
    avrl localavrl = (avrl)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(219);
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("HiBoomFont.HiBoomPanelView", 2, "hiboom panel visible");
      }
      synchronized (localavrl.jdField_a_of_type_JavaLangObject)
      {
        localavrl.jdField_a_of_type_AndroidOsHandler = this.jdField_a_of_type_AndroidOsHandler;
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
    this.jdField_a_of_type_Avrt = new avrt(this);
    this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanelRecyclerView.setAdapter(this.jdField_a_of_type_Avrt);
    this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanelRecyclerView.setPanelExtendHelper(this.jdField_a_of_type_Avse);
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
      avru localavru = a(paramMessage.arg1);
      if (localavru != null)
      {
        localavru.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView.setProgress(paramMessage.arg2);
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