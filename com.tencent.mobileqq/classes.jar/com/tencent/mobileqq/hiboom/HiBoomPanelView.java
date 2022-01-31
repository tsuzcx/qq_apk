package com.tencent.mobileqq.hiboom;

import actn;
import ajyc;
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
import aqxg;
import aqxh;
import aqxp;
import aqxq;
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
  public aqxp a;
  public BaseChatPie a;
  
  static
  {
    jdField_a_of_type_JavaLangString = ajyc.a(2131705474);
    Resources localResources = BaseApplicationImpl.sApplication.getResources();
    b = localResources.getDisplayMetrics().widthPixels / 4;
    jdField_a_of_type_Int = b;
    c = actn.a(2.0F, localResources);
    d = actn.a(11.0F, localResources);
  }
  
  public HiBoomPanelView(Context arg1, BaseChatPie paramBaseChatPie)
  {
    super(???);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = null;
    this.jdField_a_of_type_Aqxp = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
    setClipToPadding(false);
    b();
    paramBaseChatPie = (aqxh)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(219);
    synchronized (paramBaseChatPie.jdField_a_of_type_JavaLangObject)
    {
      paramBaseChatPie.jdField_a_of_type_AndroidOsHandler = this.jdField_a_of_type_AndroidOsHandler;
      return;
    }
  }
  
  aqxq a(int paramInt)
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
        if ((localObject instanceof aqxq))
        {
          localObject = (aqxq)localObject;
          if (this.jdField_a_of_type_Aqxp.a(((aqxq)localObject).jdField_a_of_type_Int) == paramInt) {
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
    aqxh localaqxh = (aqxh)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(219);
    if (!localaqxh.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      localaqxh.b();
      return;
    }
    this.jdField_a_of_type_Aqxp.a(localaqxh.jdField_a_of_type_JavaUtilVector, localaqxh.b, localaqxh.jdField_c_of_type_JavaUtilVector);
  }
  
  public void a(aqxq paramaqxq, int paramInt)
  {
    if (!paramaqxq.jdField_a_of_type_Boolean) {
      return;
    }
    if (paramInt == -1)
    {
      paramaqxq.itemView.setContentDescription(ajyc.a(2131705477));
      paramaqxq.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      paramaqxq.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      paramaqxq.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView.setVisibility(8);
      paramaqxq.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      paramaqxq.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView.setVisibility(8);
      paramaqxq.b.setVisibility(0);
      paramaqxq.b.setImageResource(2130846241);
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getBoolean("hiboom_red_dot_show", false))
      {
        paramaqxq.c.setVisibility(0);
        return;
      }
      paramaqxq.c.setVisibility(8);
      return;
    }
    paramaqxq.b.setVisibility(8);
    paramaqxq.c.setVisibility(8);
    Object localObject = (aqxh)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(219);
    if (aqxh.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      paramaqxq.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      aqxg localaqxg = ((aqxh)localObject).a(paramInt);
      if (((aqxh)localObject).b.contains(Integer.valueOf(paramInt)))
      {
        paramaqxq.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView.jdField_a_of_type_Boolean = false;
        paramaqxq.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        paramaqxq.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130846247);
        paramaqxq.jdField_a_of_type_AndroidWidgetTextView.setText(ajyc.a(2131705473));
      }
      while (localaqxg.jdField_a_of_type_Boolean)
      {
        paramaqxq.itemView.setContentDescription(localaqxg.jdField_a_of_type_JavaLangString + ajyc.a(2131705472));
        paramaqxq.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView.setVisibility(8);
        paramaqxq.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        paramaqxq.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView.setVisibility(0);
        paramaqxq.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView.setHiBoom(localaqxg.jdField_a_of_type_Int, 0, aqxh.jdField_a_of_type_Aqxa);
        String str = aqxh.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString());
        localObject = str;
        if (TextUtils.isEmpty(str)) {
          localObject = localaqxg.jdField_a_of_type_JavaLangString;
        }
        paramaqxq.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView.setText((CharSequence)localObject);
        return;
        if (((aqxh)localObject).jdField_c_of_type_JavaUtilVector.contains(Integer.valueOf(paramInt)))
        {
          paramaqxq.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView.jdField_a_of_type_Boolean = false;
          paramaqxq.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          paramaqxq.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130846246);
          paramaqxq.jdField_a_of_type_AndroidWidgetTextView.setText(ajyc.a(2131705475));
        }
        else
        {
          paramaqxq.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView.jdField_a_of_type_Boolean = true;
          paramaqxq.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        }
      }
      paramaqxq.itemView.setContentDescription(ajyc.a(2131705476));
      paramaqxq.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView.setVisibility(0);
      paramaqxq.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      paramaqxq.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView.setVisibility(8);
      if (localaqxg.jdField_a_of_type_AndroidGraphicsBitmap != null) {
        paramaqxq.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localaqxg.jdField_a_of_type_AndroidGraphicsBitmap);
      }
      while (localaqxg.b)
      {
        paramaqxq.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView.a();
        paramaqxq.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView.setProgress(localaqxg.c);
        return;
        paramaqxq.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846242);
      }
      paramaqxq.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView.b();
      return;
    }
    paramaqxq.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    paramaqxq.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView.setVisibility(8);
    paramaqxq.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    paramaqxq.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView.setVisibility(8);
  }
  
  public void a(boolean paramBoolean)
  {
    aqxh localaqxh = (aqxh)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(219);
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("HiBoomFont.HiBoomPanelView", 2, "hiboom panel visible");
      }
      synchronized (localaqxh.jdField_a_of_type_JavaLangObject)
      {
        localaqxh.jdField_a_of_type_AndroidOsHandler = this.jdField_a_of_type_AndroidOsHandler;
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
    this.jdField_a_of_type_Aqxp = new aqxp(this);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Aqxp);
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
      aqxq localaqxq = a(paramMessage.arg1);
      if (localaqxq != null)
      {
        localaqxq.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView.setProgress(paramMessage.arg2);
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