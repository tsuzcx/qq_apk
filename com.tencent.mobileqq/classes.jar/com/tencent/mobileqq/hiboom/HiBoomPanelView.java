package com.tencent.mobileqq.hiboom;

import actj;
import ajya;
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
import aqxi;
import aqxj;
import aqxr;
import aqxs;
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
  public aqxr a;
  public BaseChatPie a;
  
  static
  {
    jdField_a_of_type_JavaLangString = ajya.a(2131705485);
    Resources localResources = BaseApplicationImpl.sApplication.getResources();
    b = localResources.getDisplayMetrics().widthPixels / 4;
    jdField_a_of_type_Int = b;
    c = actj.a(2.0F, localResources);
    d = actj.a(11.0F, localResources);
  }
  
  public HiBoomPanelView(Context arg1, BaseChatPie paramBaseChatPie)
  {
    super(???);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = null;
    this.jdField_a_of_type_Aqxr = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
    setClipToPadding(false);
    b();
    paramBaseChatPie = (aqxj)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(219);
    synchronized (paramBaseChatPie.jdField_a_of_type_JavaLangObject)
    {
      paramBaseChatPie.jdField_a_of_type_AndroidOsHandler = this.jdField_a_of_type_AndroidOsHandler;
      return;
    }
  }
  
  aqxs a(int paramInt)
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
        if ((localObject instanceof aqxs))
        {
          localObject = (aqxs)localObject;
          if (this.jdField_a_of_type_Aqxr.a(((aqxs)localObject).jdField_a_of_type_Int) == paramInt) {
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
    aqxj localaqxj = (aqxj)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(219);
    if (!localaqxj.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      localaqxj.b();
      return;
    }
    this.jdField_a_of_type_Aqxr.a(localaqxj.jdField_a_of_type_JavaUtilVector, localaqxj.b, localaqxj.jdField_c_of_type_JavaUtilVector);
  }
  
  public void a(aqxs paramaqxs, int paramInt)
  {
    if (!paramaqxs.jdField_a_of_type_Boolean) {
      return;
    }
    if (paramInt == -1)
    {
      paramaqxs.itemView.setContentDescription(ajya.a(2131705488));
      paramaqxs.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      paramaqxs.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      paramaqxs.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView.setVisibility(8);
      paramaqxs.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      paramaqxs.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView.setVisibility(8);
      paramaqxs.b.setVisibility(0);
      paramaqxs.b.setImageResource(2130846247);
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getBoolean("hiboom_red_dot_show", false))
      {
        paramaqxs.c.setVisibility(0);
        return;
      }
      paramaqxs.c.setVisibility(8);
      return;
    }
    paramaqxs.b.setVisibility(8);
    paramaqxs.c.setVisibility(8);
    Object localObject = (aqxj)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(219);
    if (aqxj.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      paramaqxs.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      aqxi localaqxi = ((aqxj)localObject).a(paramInt);
      if (((aqxj)localObject).b.contains(Integer.valueOf(paramInt)))
      {
        paramaqxs.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView.jdField_a_of_type_Boolean = false;
        paramaqxs.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        paramaqxs.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130846253);
        paramaqxs.jdField_a_of_type_AndroidWidgetTextView.setText(ajya.a(2131705484));
      }
      while (localaqxi.jdField_a_of_type_Boolean)
      {
        paramaqxs.itemView.setContentDescription(localaqxi.jdField_a_of_type_JavaLangString + ajya.a(2131705483));
        paramaqxs.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView.setVisibility(8);
        paramaqxs.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        paramaqxs.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView.setVisibility(0);
        paramaqxs.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView.setHiBoom(localaqxi.jdField_a_of_type_Int, 0, aqxj.jdField_a_of_type_Aqxc);
        String str = aqxj.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString());
        localObject = str;
        if (TextUtils.isEmpty(str)) {
          localObject = localaqxi.jdField_a_of_type_JavaLangString;
        }
        paramaqxs.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView.setText((CharSequence)localObject);
        return;
        if (((aqxj)localObject).jdField_c_of_type_JavaUtilVector.contains(Integer.valueOf(paramInt)))
        {
          paramaqxs.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView.jdField_a_of_type_Boolean = false;
          paramaqxs.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          paramaqxs.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130846252);
          paramaqxs.jdField_a_of_type_AndroidWidgetTextView.setText(ajya.a(2131705486));
        }
        else
        {
          paramaqxs.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView.jdField_a_of_type_Boolean = true;
          paramaqxs.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        }
      }
      paramaqxs.itemView.setContentDescription(ajya.a(2131705487));
      paramaqxs.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView.setVisibility(0);
      paramaqxs.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      paramaqxs.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView.setVisibility(8);
      if (localaqxi.jdField_a_of_type_AndroidGraphicsBitmap != null) {
        paramaqxs.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localaqxi.jdField_a_of_type_AndroidGraphicsBitmap);
      }
      while (localaqxi.b)
      {
        paramaqxs.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView.a();
        paramaqxs.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView.setProgress(localaqxi.c);
        return;
        paramaqxs.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846248);
      }
      paramaqxs.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView.b();
      return;
    }
    paramaqxs.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    paramaqxs.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView.setVisibility(8);
    paramaqxs.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    paramaqxs.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView.setVisibility(8);
  }
  
  public void a(boolean paramBoolean)
  {
    aqxj localaqxj = (aqxj)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(219);
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("HiBoomFont.HiBoomPanelView", 2, "hiboom panel visible");
      }
      synchronized (localaqxj.jdField_a_of_type_JavaLangObject)
      {
        localaqxj.jdField_a_of_type_AndroidOsHandler = this.jdField_a_of_type_AndroidOsHandler;
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
    this.jdField_a_of_type_Aqxr = new aqxr(this);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Aqxr);
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
      aqxs localaqxs = a(paramMessage.arg1);
      if (localaqxs != null)
      {
        localaqxs.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView.setProgress(paramMessage.arg2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.HiBoomPanelView
 * JD-Core Version:    0.7.0.1
 */