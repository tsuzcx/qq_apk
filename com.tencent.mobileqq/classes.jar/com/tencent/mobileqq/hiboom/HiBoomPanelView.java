package com.tencent.mobileqq.hiboom;

import aciy;
import ajjy;
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
import aqde;
import aqdf;
import aqdn;
import aqdo;
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
  public aqdn a;
  public BaseChatPie a;
  
  static
  {
    jdField_a_of_type_JavaLangString = ajjy.a(2131639689);
    Resources localResources = BaseApplicationImpl.sApplication.getResources();
    b = localResources.getDisplayMetrics().widthPixels / 4;
    jdField_a_of_type_Int = b;
    c = aciy.a(2.0F, localResources);
    d = aciy.a(11.0F, localResources);
  }
  
  public HiBoomPanelView(Context arg1, BaseChatPie paramBaseChatPie)
  {
    super(???);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = null;
    this.jdField_a_of_type_Aqdn = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
    setClipToPadding(false);
    b();
    paramBaseChatPie = (aqdf)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(219);
    synchronized (paramBaseChatPie.jdField_a_of_type_JavaLangObject)
    {
      paramBaseChatPie.jdField_a_of_type_AndroidOsHandler = this.jdField_a_of_type_AndroidOsHandler;
      return;
    }
  }
  
  aqdo a(int paramInt)
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
        if ((localObject instanceof aqdo))
        {
          localObject = (aqdo)localObject;
          if (this.jdField_a_of_type_Aqdn.a(((aqdo)localObject).jdField_a_of_type_Int) == paramInt) {
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
    aqdf localaqdf = (aqdf)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(219);
    if (!localaqdf.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      localaqdf.b();
      return;
    }
    this.jdField_a_of_type_Aqdn.a(localaqdf.jdField_a_of_type_JavaUtilVector, localaqdf.b, localaqdf.jdField_c_of_type_JavaUtilVector);
  }
  
  public void a(aqdo paramaqdo, int paramInt)
  {
    if (!paramaqdo.jdField_a_of_type_Boolean) {
      return;
    }
    if (paramInt == -1)
    {
      paramaqdo.itemView.setContentDescription(ajjy.a(2131639692));
      paramaqdo.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      paramaqdo.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      paramaqdo.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView.setVisibility(8);
      paramaqdo.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      paramaqdo.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView.setVisibility(8);
      paramaqdo.b.setVisibility(0);
      paramaqdo.b.setImageResource(2130846060);
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getBoolean("hiboom_red_dot_show", false))
      {
        paramaqdo.c.setVisibility(0);
        return;
      }
      paramaqdo.c.setVisibility(8);
      return;
    }
    paramaqdo.b.setVisibility(8);
    paramaqdo.c.setVisibility(8);
    Object localObject = (aqdf)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(219);
    if (aqdf.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      paramaqdo.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      aqde localaqde = ((aqdf)localObject).a(paramInt);
      if (((aqdf)localObject).b.contains(Integer.valueOf(paramInt)))
      {
        paramaqdo.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView.jdField_a_of_type_Boolean = false;
        paramaqdo.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        paramaqdo.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130846066);
        paramaqdo.jdField_a_of_type_AndroidWidgetTextView.setText(ajjy.a(2131639688));
      }
      while (localaqde.jdField_a_of_type_Boolean)
      {
        paramaqdo.itemView.setContentDescription(localaqde.jdField_a_of_type_JavaLangString + ajjy.a(2131639687));
        paramaqdo.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView.setVisibility(8);
        paramaqdo.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        paramaqdo.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView.setVisibility(0);
        paramaqdo.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView.setHiBoom(localaqde.jdField_a_of_type_Int, 0, aqdf.jdField_a_of_type_Aqcy);
        String str = aqdf.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString());
        localObject = str;
        if (TextUtils.isEmpty(str)) {
          localObject = localaqde.jdField_a_of_type_JavaLangString;
        }
        paramaqdo.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView.setText((CharSequence)localObject);
        return;
        if (((aqdf)localObject).jdField_c_of_type_JavaUtilVector.contains(Integer.valueOf(paramInt)))
        {
          paramaqdo.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView.jdField_a_of_type_Boolean = false;
          paramaqdo.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          paramaqdo.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130846065);
          paramaqdo.jdField_a_of_type_AndroidWidgetTextView.setText(ajjy.a(2131639690));
        }
        else
        {
          paramaqdo.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView.jdField_a_of_type_Boolean = true;
          paramaqdo.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        }
      }
      paramaqdo.itemView.setContentDescription(ajjy.a(2131639691));
      paramaqdo.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView.setVisibility(0);
      paramaqdo.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      paramaqdo.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView.setVisibility(8);
      if (localaqde.jdField_a_of_type_AndroidGraphicsBitmap != null) {
        paramaqdo.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localaqde.jdField_a_of_type_AndroidGraphicsBitmap);
      }
      while (localaqde.b)
      {
        paramaqdo.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView.a();
        paramaqdo.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView.setProgress(localaqde.c);
        return;
        paramaqdo.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846061);
      }
      paramaqdo.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView.b();
      return;
    }
    paramaqdo.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    paramaqdo.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView.setVisibility(8);
    paramaqdo.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    paramaqdo.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView.setVisibility(8);
  }
  
  public void a(boolean paramBoolean)
  {
    aqdf localaqdf = (aqdf)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(219);
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("HiBoomFont.HiBoomPanelView", 2, "hiboom panel visible");
      }
      synchronized (localaqdf.jdField_a_of_type_JavaLangObject)
      {
        localaqdf.jdField_a_of_type_AndroidOsHandler = this.jdField_a_of_type_AndroidOsHandler;
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
    this.jdField_a_of_type_Aqdn = new aqdn(this);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Aqdn);
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
      aqdo localaqdo = a(paramMessage.arg1);
      if (localaqdo != null)
      {
        localaqdo.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView.setProgress(paramMessage.arg2);
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