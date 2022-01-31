package com.tencent.mobileqq.hiboom;

import adxp;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SVIPObserver;
import com.tencent.mobileqq.vas.VasH5PayUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class HiBoomPanelView
  extends RelativeLayout
  implements Handler.Callback, View.OnClickListener
{
  public static int a;
  public static int b;
  public static int c;
  public Handler a;
  GridLayoutManager jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager;
  RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = null;
  private SVIPObserver jdField_a_of_type_ComTencentMobileqqAppSVIPObserver = new adxp(this);
  public HiBoomPanelView.HiBoomAdapter a;
  
  static
  {
    Resources localResources = BaseApplicationImpl.sApplication.getResources();
    b = localResources.getDisplayMetrics().widthPixels / 3;
    jdField_a_of_type_Int = b;
    c = AIOUtils.a(2.0F, localResources);
  }
  
  public HiBoomPanelView(Context arg1, BaseChatPie paramBaseChatPie)
  {
    super(???);
    this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomPanelView$HiBoomAdapter = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
    paramBaseChatPie = (HiBoomManager)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.getManager(218);
    synchronized (paramBaseChatPie.jdField_a_of_type_JavaLangObject)
    {
      paramBaseChatPie.jdField_a_of_type_AndroidOsHandler = this.jdField_a_of_type_AndroidOsHandler;
      setClipToPadding(false);
      c();
      a();
      b();
      return;
    }
  }
  
  public void a()
  {
    HiBoomManager localHiBoomManager = (HiBoomManager)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.getManager(218);
    if (!localHiBoomManager.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      localHiBoomManager.a(true, false);
    }
    for (;;)
    {
      if (localHiBoomManager.a()) {
        localHiBoomManager.a(localHiBoomManager.c);
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomPanelView$HiBoomAdapter.a(localHiBoomManager.jdField_a_of_type_JavaUtilVector);
      if (QLog.isColorLevel()) {
        QLog.d("HiBoomFont.HiBoomPanelView", 2, "loadData setList size = " + this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomPanelView$HiBoomAdapter.a.size());
      }
      this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomPanelView$HiBoomAdapter.notifyDataSetChanged();
    }
  }
  
  public void b()
  {
    switch (((HiBoomManager)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.getManager(218)).a())
    {
    default: 
      return;
    case 0: 
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      return;
    case 1: 
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText("开通超级会员解锁嗨爆字体");
      return;
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText("续费超级会员解锁嗨爆字体");
  }
  
  @TargetApi(9)
  public void c()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)LayoutInflater.from(getContext()).inflate(2130969027, this, false));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131364805));
    addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = new RecyclerView(getContext());
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setOverScrollMode(2);
    this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager = new GridLayoutManager(getContext(), 3);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    localLayoutParams.addRule(3, 2131364803);
    addView(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView, localLayoutParams);
    this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomPanelView$HiBoomAdapter = new HiBoomPanelView.HiBoomAdapter(this);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomPanelView$HiBoomAdapter);
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
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    VasH5PayUtil.a(getContext(), "mvip.g.a.zt_high", "CJCLUBT", 3, false, true);
    ((HiBoomManager)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.getManager(218)).b.set(false);
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    paramView = (HiBoomManager)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.getManager(218);
    if (paramInt == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("HiBoomFont.HiBoomPanelView", 2, "hiboom panel visible");
      }
      synchronized (paramView.jdField_a_of_type_JavaLangObject)
      {
        paramView.jdField_a_of_type_AndroidOsHandler = this.jdField_a_of_type_AndroidOsHandler;
        a();
        paramView.a(paramView.b);
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppSVIPObserver);
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("HiBoomFont.HiBoomPanelView", 2, "hiboom panel gone");
    }
    synchronized (paramView.jdField_a_of_type_JavaLangObject)
    {
      paramView.jdField_a_of_type_AndroidOsHandler = null;
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppSVIPObserver);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.HiBoomPanelView
 * JD-Core Version:    0.7.0.1
 */