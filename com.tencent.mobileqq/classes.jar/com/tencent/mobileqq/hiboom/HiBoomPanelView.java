package com.tencent.mobileqq.hiboom;

import aepi;
import alud;
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
import assf;
import assg;
import asso;
import assp;
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
  public asso a;
  public BaseChatPie a;
  
  static
  {
    jdField_a_of_type_JavaLangString = alud.a(2131705869);
    Resources localResources = BaseApplicationImpl.sApplication.getResources();
    b = localResources.getDisplayMetrics().widthPixels / 4;
    jdField_a_of_type_Int = b;
    c = aepi.a(2.0F, localResources);
    d = aepi.a(11.0F, localResources);
  }
  
  public HiBoomPanelView(Context arg1, BaseChatPie paramBaseChatPie)
  {
    super(???);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = null;
    this.jdField_a_of_type_Asso = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
    setClipToPadding(false);
    b();
    paramBaseChatPie = (assg)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(219);
    synchronized (paramBaseChatPie.jdField_a_of_type_JavaLangObject)
    {
      paramBaseChatPie.jdField_a_of_type_AndroidOsHandler = this.jdField_a_of_type_AndroidOsHandler;
      return;
    }
  }
  
  assp a(int paramInt)
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
        if ((localObject instanceof assp))
        {
          localObject = (assp)localObject;
          if (this.jdField_a_of_type_Asso.a(((assp)localObject).jdField_a_of_type_Int) == paramInt) {
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
    assg localassg = (assg)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(219);
    if (!localassg.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      localassg.b();
      return;
    }
    this.jdField_a_of_type_Asso.a(localassg.jdField_a_of_type_JavaUtilVector, localassg.b, localassg.jdField_c_of_type_JavaUtilVector);
  }
  
  public void a(assp paramassp, int paramInt)
  {
    if (!paramassp.jdField_a_of_type_Boolean) {
      return;
    }
    if (paramInt == -1)
    {
      paramassp.itemView.setContentDescription(alud.a(2131705872));
      paramassp.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      paramassp.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      paramassp.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView.setVisibility(8);
      paramassp.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      paramassp.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView.setVisibility(8);
      paramassp.b.setVisibility(0);
      paramassp.b.setImageResource(2130846699);
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getBoolean("hiboom_red_dot_show", false))
      {
        paramassp.c.setVisibility(0);
        return;
      }
      paramassp.c.setVisibility(8);
      return;
    }
    paramassp.b.setVisibility(8);
    paramassp.c.setVisibility(8);
    Object localObject = (assg)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(219);
    if (assg.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      paramassp.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      assf localassf = ((assg)localObject).a(paramInt);
      if (((assg)localObject).b.contains(Integer.valueOf(paramInt)))
      {
        paramassp.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView.jdField_a_of_type_Boolean = false;
        paramassp.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        paramassp.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130846705);
        paramassp.jdField_a_of_type_AndroidWidgetTextView.setText(alud.a(2131705868));
      }
      while (localassf.jdField_a_of_type_Boolean)
      {
        paramassp.itemView.setContentDescription(localassf.jdField_a_of_type_JavaLangString + alud.a(2131705867));
        paramassp.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView.setVisibility(8);
        paramassp.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        paramassp.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView.setVisibility(0);
        paramassp.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView.setHiBoom(localassf.jdField_a_of_type_Int, 0, assg.jdField_a_of_type_Asrz);
        String str = assg.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString());
        localObject = str;
        if (TextUtils.isEmpty(str)) {
          localObject = localassf.jdField_a_of_type_JavaLangString;
        }
        paramassp.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView.setText((CharSequence)localObject);
        return;
        if (((assg)localObject).jdField_c_of_type_JavaUtilVector.contains(Integer.valueOf(paramInt)))
        {
          paramassp.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView.jdField_a_of_type_Boolean = false;
          paramassp.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          paramassp.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130846704);
          paramassp.jdField_a_of_type_AndroidWidgetTextView.setText(alud.a(2131705870));
        }
        else
        {
          paramassp.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView.jdField_a_of_type_Boolean = true;
          paramassp.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        }
      }
      paramassp.itemView.setContentDescription(alud.a(2131705871));
      paramassp.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView.setVisibility(0);
      paramassp.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      paramassp.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView.setVisibility(8);
      if (localassf.jdField_a_of_type_AndroidGraphicsBitmap != null) {
        paramassp.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localassf.jdField_a_of_type_AndroidGraphicsBitmap);
      }
      while (localassf.b)
      {
        paramassp.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView.a();
        paramassp.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView.setProgress(localassf.c);
        return;
        paramassp.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846700);
      }
      paramassp.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView.b();
      return;
    }
    paramassp.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    paramassp.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView.setVisibility(8);
    paramassp.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    paramassp.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView.setVisibility(8);
  }
  
  public void a(boolean paramBoolean)
  {
    assg localassg = (assg)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(219);
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("HiBoomFont.HiBoomPanelView", 2, "hiboom panel visible");
      }
      synchronized (localassg.jdField_a_of_type_JavaLangObject)
      {
        localassg.jdField_a_of_type_AndroidOsHandler = this.jdField_a_of_type_AndroidOsHandler;
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
    this.jdField_a_of_type_Asso = new asso(this);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Asso);
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
      assp localassp = a(paramMessage.arg1);
      if (localassp != null)
      {
        localassp.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView.setProgress(paramMessage.arg2);
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