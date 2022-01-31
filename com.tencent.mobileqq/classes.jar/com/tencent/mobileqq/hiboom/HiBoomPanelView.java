package com.tencent.mobileqq.hiboom;

import aekt;
import alpo;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import asnw;
import asnx;
import asof;
import asog;
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
  RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  public asof a;
  public BaseChatPie a;
  
  static
  {
    jdField_a_of_type_JavaLangString = alpo.a(2131705857);
    Resources localResources = BaseApplicationImpl.sApplication.getResources();
    b = localResources.getDisplayMetrics().widthPixels / 4;
    jdField_a_of_type_Int = b;
    c = aekt.a(2.0F, localResources);
    d = aekt.a(11.0F, localResources);
  }
  
  public HiBoomPanelView(Context arg1, BaseChatPie paramBaseChatPie)
  {
    super(???);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = null;
    this.jdField_a_of_type_Asof = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
    setClipToPadding(false);
    b();
    paramBaseChatPie = (asnx)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(219);
    synchronized (paramBaseChatPie.jdField_a_of_type_JavaLangObject)
    {
      paramBaseChatPie.jdField_a_of_type_AndroidOsHandler = this.jdField_a_of_type_AndroidOsHandler;
      return;
    }
  }
  
  asog a(int paramInt)
  {
    int j = this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager.findFirstVisibleItemPosition();
    int k = this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager.findLastVisibleItemPosition();
    int i = j;
    while (i <= k)
    {
      Object localObject = this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager.getChildAt(i - j);
      if (localObject != null)
      {
        localObject = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildViewHolder((View)localObject);
        if ((localObject instanceof asog))
        {
          localObject = (asog)localObject;
          if (this.jdField_a_of_type_Asof.a(((asog)localObject).jdField_a_of_type_Int) == paramInt) {
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
    asnx localasnx = (asnx)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(219);
    if (!localasnx.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      localasnx.b();
      return;
    }
    this.jdField_a_of_type_Asof.a(localasnx.jdField_a_of_type_JavaUtilVector, localasnx.b, localasnx.jdField_c_of_type_JavaUtilVector);
  }
  
  public void a(asog paramasog, int paramInt)
  {
    if (!paramasog.jdField_a_of_type_Boolean) {
      return;
    }
    if (paramInt == -1)
    {
      paramasog.itemView.setContentDescription(alpo.a(2131705860));
      paramasog.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      paramasog.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      paramasog.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView.setVisibility(8);
      paramasog.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      paramasog.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView.setVisibility(8);
      paramasog.b.setVisibility(0);
      paramasog.b.setImageResource(2130846626);
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getBoolean("hiboom_red_dot_show", false))
      {
        paramasog.c.setVisibility(0);
        return;
      }
      paramasog.c.setVisibility(8);
      return;
    }
    paramasog.b.setVisibility(8);
    paramasog.c.setVisibility(8);
    Object localObject = (asnx)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(219);
    if (asnx.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      paramasog.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      asnw localasnw = ((asnx)localObject).a(paramInt);
      if (((asnx)localObject).b.contains(Integer.valueOf(paramInt)))
      {
        paramasog.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView.jdField_a_of_type_Boolean = false;
        paramasog.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        paramasog.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130846632);
        paramasog.jdField_a_of_type_AndroidWidgetTextView.setText(alpo.a(2131705856));
      }
      while (localasnw.jdField_a_of_type_Boolean)
      {
        paramasog.itemView.setContentDescription(localasnw.jdField_a_of_type_JavaLangString + alpo.a(2131705855));
        paramasog.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView.setVisibility(8);
        paramasog.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        paramasog.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView.setVisibility(0);
        paramasog.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView.setHiBoom(localasnw.jdField_a_of_type_Int, 0, asnx.jdField_a_of_type_Asnq);
        String str = asnx.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString());
        localObject = str;
        if (TextUtils.isEmpty(str)) {
          localObject = localasnw.jdField_a_of_type_JavaLangString;
        }
        paramasog.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView.setText((CharSequence)localObject);
        return;
        if (((asnx)localObject).jdField_c_of_type_JavaUtilVector.contains(Integer.valueOf(paramInt)))
        {
          paramasog.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView.jdField_a_of_type_Boolean = false;
          paramasog.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          paramasog.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130846631);
          paramasog.jdField_a_of_type_AndroidWidgetTextView.setText(alpo.a(2131705858));
        }
        else
        {
          paramasog.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView.jdField_a_of_type_Boolean = true;
          paramasog.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        }
      }
      paramasog.itemView.setContentDescription(alpo.a(2131705859));
      paramasog.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView.setVisibility(0);
      paramasog.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      paramasog.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView.setVisibility(8);
      if (localasnw.jdField_a_of_type_AndroidGraphicsBitmap != null) {
        paramasog.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localasnw.jdField_a_of_type_AndroidGraphicsBitmap);
      }
      while (localasnw.b)
      {
        paramasog.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView.a();
        paramasog.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView.setProgress(localasnw.c);
        return;
        paramasog.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846627);
      }
      paramasog.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView.b();
      return;
    }
    paramasog.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    paramasog.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView.setVisibility(8);
    paramasog.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    paramasog.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView.setVisibility(8);
  }
  
  public void a(boolean paramBoolean)
  {
    asnx localasnx = (asnx)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(219);
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("HiBoomFont.HiBoomPanelView", 2, "hiboom panel visible");
      }
      synchronized (localasnx.jdField_a_of_type_JavaLangObject)
      {
        localasnx.jdField_a_of_type_AndroidOsHandler = this.jdField_a_of_type_AndroidOsHandler;
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
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = new RecyclerView(getContext());
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setOverScrollMode(2);
    this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager = new GridLayoutManager(getContext(), 4);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    addView(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView, localLayoutParams);
    this.jdField_a_of_type_Asof = new asof(this);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Asof);
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
      asog localasog = a(paramMessage.arg1);
      if (localasog != null)
      {
        localasog.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView.setProgress(paramMessage.arg2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.HiBoomPanelView
 * JD-Core Version:    0.7.0.1
 */