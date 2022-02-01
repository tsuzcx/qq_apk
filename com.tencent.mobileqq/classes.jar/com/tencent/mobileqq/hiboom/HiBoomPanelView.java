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
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.HardCodeUtil;
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
  BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = null;
  HiBoomPanelView.HiBoomAdapter jdField_a_of_type_ComTencentMobileqqHiboomHiBoomPanelView$HiBoomAdapter = null;
  RichTextPanelExtendHelper jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanelExtendHelper;
  RichTextPanelRecyclerView jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanelRecyclerView;
  
  static
  {
    jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131705501);
    Resources localResources = BaseApplicationImpl.sApplication.getResources();
    b = localResources.getDisplayMetrics().widthPixels / 4;
    jdField_a_of_type_Int = b;
    c = AIOUtils.a(2.0F, localResources);
    d = AIOUtils.a(11.0F, localResources);
  }
  
  public HiBoomPanelView(Context arg1, BaseChatPie paramBaseChatPie, RichTextPanelExtendHelper paramRichTextPanelExtendHelper)
  {
    super(???);
    this.jdField_a_of_type_AndroidOsHandler = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
    setClipToPadding(false);
    this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanelExtendHelper = paramRichTextPanelExtendHelper;
    b();
    paramBaseChatPie = (HiBoomManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.HIBOOM_MANAGER);
    synchronized (paramBaseChatPie.jdField_a_of_type_JavaLangObject)
    {
      paramBaseChatPie.jdField_a_of_type_AndroidOsHandler = this.jdField_a_of_type_AndroidOsHandler;
      return;
    }
  }
  
  HiBoomPanelView.HiBoomViewHolder a(int paramInt)
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
        if ((localObject instanceof HiBoomPanelView.HiBoomViewHolder))
        {
          localObject = (HiBoomPanelView.HiBoomViewHolder)localObject;
          if (this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomPanelView$HiBoomAdapter.a(((HiBoomPanelView.HiBoomViewHolder)localObject).jdField_a_of_type_Int) == paramInt) {
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
    HiBoomManager localHiBoomManager = (HiBoomManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.HIBOOM_MANAGER);
    if (!localHiBoomManager.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      localHiBoomManager.b();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomPanelView$HiBoomAdapter.a(localHiBoomManager.jdField_a_of_type_JavaUtilVector, localHiBoomManager.b, localHiBoomManager.jdField_c_of_type_JavaUtilVector);
  }
  
  void a(HiBoomPanelView.HiBoomViewHolder paramHiBoomViewHolder, int paramInt)
  {
    if (!paramHiBoomViewHolder.jdField_a_of_type_Boolean) {
      return;
    }
    if (paramInt == -1)
    {
      paramHiBoomViewHolder.itemView.setContentDescription(HardCodeUtil.a(2131705504));
      paramHiBoomViewHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      paramHiBoomViewHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      paramHiBoomViewHolder.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView.setVisibility(8);
      paramHiBoomViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      paramHiBoomViewHolder.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView.setVisibility(8);
      paramHiBoomViewHolder.b.setVisibility(0);
      paramHiBoomViewHolder.b.setImageResource(2130847527);
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getBoolean("hiboom_red_dot_show", false))
      {
        paramHiBoomViewHolder.c.setVisibility(0);
        return;
      }
      paramHiBoomViewHolder.c.setVisibility(8);
      return;
    }
    paramHiBoomViewHolder.b.setVisibility(8);
    paramHiBoomViewHolder.c.setVisibility(8);
    Object localObject = (HiBoomManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.HIBOOM_MANAGER);
    if (HiBoomManager.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      paramHiBoomViewHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      HiBoomItem localHiBoomItem = ((HiBoomManager)localObject).a(paramInt);
      if (((HiBoomManager)localObject).b.contains(Integer.valueOf(paramInt)))
      {
        paramHiBoomViewHolder.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView.jdField_a_of_type_Boolean = false;
        paramHiBoomViewHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        paramHiBoomViewHolder.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130847533);
        paramHiBoomViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131705500));
      }
      while (localHiBoomItem.jdField_a_of_type_Boolean)
      {
        paramHiBoomViewHolder.itemView.setContentDescription(localHiBoomItem.jdField_a_of_type_JavaLangString + HardCodeUtil.a(2131705499));
        paramHiBoomViewHolder.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView.setVisibility(8);
        paramHiBoomViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        paramHiBoomViewHolder.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView.setVisibility(0);
        paramHiBoomViewHolder.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView.setHiBoom(localHiBoomItem.jdField_a_of_type_Int, 0, HiBoomManager.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomFont$HiBoomFontDownloader);
        String str = HiBoomManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString());
        localObject = str;
        if (TextUtils.isEmpty(str)) {
          localObject = localHiBoomItem.jdField_a_of_type_JavaLangString;
        }
        paramHiBoomViewHolder.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView.setText((CharSequence)localObject);
        return;
        if (((HiBoomManager)localObject).jdField_c_of_type_JavaUtilVector.contains(Integer.valueOf(paramInt)))
        {
          paramHiBoomViewHolder.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView.jdField_a_of_type_Boolean = false;
          paramHiBoomViewHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          paramHiBoomViewHolder.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130847532);
          paramHiBoomViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131705502));
        }
        else
        {
          paramHiBoomViewHolder.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView.jdField_a_of_type_Boolean = true;
          paramHiBoomViewHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        }
      }
      paramHiBoomViewHolder.itemView.setContentDescription(HardCodeUtil.a(2131705503));
      paramHiBoomViewHolder.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView.setVisibility(0);
      paramHiBoomViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      paramHiBoomViewHolder.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView.setVisibility(8);
      if (localHiBoomItem.jdField_a_of_type_AndroidGraphicsBitmap != null) {
        paramHiBoomViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localHiBoomItem.jdField_a_of_type_AndroidGraphicsBitmap);
      }
      while (localHiBoomItem.b)
      {
        paramHiBoomViewHolder.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView.a();
        paramHiBoomViewHolder.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView.setProgress(localHiBoomItem.c);
        return;
        paramHiBoomViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130847528);
      }
      paramHiBoomViewHolder.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView.b();
      return;
    }
    paramHiBoomViewHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    paramHiBoomViewHolder.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView.setVisibility(8);
    paramHiBoomViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    paramHiBoomViewHolder.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView.setVisibility(8);
  }
  
  public void a(boolean paramBoolean)
  {
    HiBoomManager localHiBoomManager = (HiBoomManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.HIBOOM_MANAGER);
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("HiBoomFont.HiBoomPanelView", 2, "hiboom panel visible");
      }
      synchronized (localHiBoomManager.jdField_a_of_type_JavaLangObject)
      {
        localHiBoomManager.jdField_a_of_type_AndroidOsHandler = this.jdField_a_of_type_AndroidOsHandler;
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
    this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomPanelView$HiBoomAdapter = new HiBoomPanelView.HiBoomAdapter(this);
    this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanelRecyclerView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomPanelView$HiBoomAdapter);
    this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanelRecyclerView.setPanelExtendHelper(this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanelExtendHelper);
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
      HiBoomPanelView.HiBoomViewHolder localHiBoomViewHolder = a(paramMessage.arg1);
      if (localHiBoomViewHolder != null)
      {
        localHiBoomViewHolder.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView.setProgress(paramMessage.arg2);
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