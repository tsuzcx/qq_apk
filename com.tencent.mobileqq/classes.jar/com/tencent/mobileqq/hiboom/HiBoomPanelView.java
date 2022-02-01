package com.tencent.mobileqq.hiboom;

import amtj;
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
import auem;
import auen;
import auev;
import auew;
import aufg;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
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
  public auev a;
  aufg jdField_a_of_type_Aufg;
  public BaseChatPie a;
  RichTextPanelRecyclerView jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanelRecyclerView;
  
  static
  {
    jdField_a_of_type_JavaLangString = amtj.a(2131704607);
    Resources localResources = BaseApplicationImpl.sApplication.getResources();
    b = localResources.getDisplayMetrics().widthPixels / 4;
    jdField_a_of_type_Int = b;
    c = AIOUtils.dp2px(2.0F, localResources);
    d = AIOUtils.dp2px(11.0F, localResources);
  }
  
  public HiBoomPanelView(Context arg1, BaseChatPie paramBaseChatPie, aufg paramaufg)
  {
    super(???);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = null;
    this.jdField_a_of_type_Auev = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
    setClipToPadding(false);
    this.jdField_a_of_type_Aufg = paramaufg;
    b();
    paramBaseChatPie = (auen)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getManager(219);
    synchronized (paramBaseChatPie.jdField_a_of_type_JavaLangObject)
    {
      paramBaseChatPie.jdField_a_of_type_AndroidOsHandler = this.jdField_a_of_type_AndroidOsHandler;
      return;
    }
  }
  
  auew a(int paramInt)
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
        if ((localObject instanceof auew))
        {
          localObject = (auew)localObject;
          if (this.jdField_a_of_type_Auev.a(((auew)localObject).jdField_a_of_type_Int) == paramInt) {
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
    auen localauen = (auen)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getManager(219);
    if (!localauen.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      localauen.b();
      return;
    }
    this.jdField_a_of_type_Auev.a(localauen.jdField_a_of_type_JavaUtilVector, localauen.b, localauen.jdField_c_of_type_JavaUtilVector);
  }
  
  public void a(auew paramauew, int paramInt)
  {
    if (!paramauew.jdField_a_of_type_Boolean) {
      return;
    }
    if (paramInt == -1)
    {
      paramauew.itemView.setContentDescription(amtj.a(2131704610));
      paramauew.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      paramauew.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      paramauew.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView.setVisibility(8);
      paramauew.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      paramauew.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView.setVisibility(8);
      paramauew.b.setVisibility(0);
      paramauew.b.setImageResource(2130847072);
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getPreferences().getBoolean("hiboom_red_dot_show", false))
      {
        paramauew.c.setVisibility(0);
        return;
      }
      paramauew.c.setVisibility(8);
      return;
    }
    paramauew.b.setVisibility(8);
    paramauew.c.setVisibility(8);
    Object localObject = (auen)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getManager(219);
    if (auen.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      paramauew.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      auem localauem = ((auen)localObject).a(paramInt);
      if (((auen)localObject).b.contains(Integer.valueOf(paramInt)))
      {
        paramauew.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView.jdField_a_of_type_Boolean = false;
        paramauew.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        paramauew.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130847078);
        paramauew.jdField_a_of_type_AndroidWidgetTextView.setText(amtj.a(2131704606));
      }
      while (localauem.jdField_a_of_type_Boolean)
      {
        paramauew.itemView.setContentDescription(localauem.jdField_a_of_type_JavaLangString + amtj.a(2131704605));
        paramauew.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView.setVisibility(8);
        paramauew.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        paramauew.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView.setVisibility(0);
        paramauew.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView.setHiBoom(localauem.jdField_a_of_type_Int, 0, auen.jdField_a_of_type_Aueg);
        String str = auen.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.input.getText().toString());
        localObject = str;
        if (TextUtils.isEmpty(str)) {
          localObject = localauem.jdField_a_of_type_JavaLangString;
        }
        paramauew.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView.setText((CharSequence)localObject);
        return;
        if (((auen)localObject).jdField_c_of_type_JavaUtilVector.contains(Integer.valueOf(paramInt)))
        {
          paramauew.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView.jdField_a_of_type_Boolean = false;
          paramauew.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          paramauew.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130847077);
          paramauew.jdField_a_of_type_AndroidWidgetTextView.setText(amtj.a(2131704608));
        }
        else
        {
          paramauew.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView.jdField_a_of_type_Boolean = true;
          paramauew.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        }
      }
      paramauew.itemView.setContentDescription(amtj.a(2131704609));
      paramauew.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView.setVisibility(0);
      paramauew.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      paramauew.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView.setVisibility(8);
      if (localauem.jdField_a_of_type_AndroidGraphicsBitmap != null) {
        paramauew.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localauem.jdField_a_of_type_AndroidGraphicsBitmap);
      }
      while (localauem.b)
      {
        paramauew.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView.a();
        paramauew.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView.setProgress(localauem.c);
        return;
        paramauew.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130847073);
      }
      paramauew.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView.b();
      return;
    }
    paramauew.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    paramauew.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView.setVisibility(8);
    paramauew.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    paramauew.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView.setVisibility(8);
  }
  
  public void a(boolean paramBoolean)
  {
    auen localauen = (auen)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getManager(219);
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("HiBoomFont.HiBoomPanelView", 2, "hiboom panel visible");
      }
      synchronized (localauen.jdField_a_of_type_JavaLangObject)
      {
        localauen.jdField_a_of_type_AndroidOsHandler = this.jdField_a_of_type_AndroidOsHandler;
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
    this.jdField_a_of_type_Auev = new auev(this);
    this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanelRecyclerView.setAdapter(this.jdField_a_of_type_Auev);
    this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanelRecyclerView.setPanelExtendHelper(this.jdField_a_of_type_Aufg);
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
      auew localauew = a(paramMessage.arg1);
      if (localauew != null)
      {
        localauew.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView.setProgress(paramMessage.arg2);
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