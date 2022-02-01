package com.tencent.mobileqq.settings.message;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnShowListener;
import android.content.res.Resources;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.NumberWheelView;
import com.tencent.mobileqq.app.utils.TimeWheelPanel;
import com.tencent.mobileqq.app.utils.TimeWheelPanel.ScrollStateListener;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.FormSwitchSimpleItem;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.VerticalGallery;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;

public class NotifyPushSettingFragment$TimePickDialog
  extends ReportDialog
  implements DialogInterface.OnCancelListener, DialogInterface.OnShowListener, View.OnClickListener, TimeWheelPanel.ScrollStateListener
{
  private Context a;
  private TimeWheelPanel b;
  private View c;
  private TextView d;
  private TextView e;
  private TextView f;
  private QQAppInterface g;
  private FormSwitchSimpleItem h;
  private AtomicBoolean i;
  private CompoundButton.OnCheckedChangeListener j;
  private boolean k = false;
  
  public NotifyPushSettingFragment$TimePickDialog(Context paramContext, QQAppInterface paramQQAppInterface, FormSwitchSimpleItem paramFormSwitchSimpleItem, TextView paramTextView, CompoundButton.OnCheckedChangeListener paramOnCheckedChangeListener)
  {
    super(paramContext, 2131952660);
    requestWindowFeature(1);
    this.g = paramQQAppInterface;
    this.h = paramFormSwitchSimpleItem;
    this.f = paramTextView;
    this.j = paramOnCheckedChangeListener;
    this.a = paramContext;
    this.c = getLayoutInflater().inflate(2131627324, null);
    setContentView(this.c);
    paramContext = getWindow();
    paramQQAppInterface = paramContext.getAttributes();
    paramQQAppInterface.width = -1;
    paramQQAppInterface.height = -2;
    paramQQAppInterface.gravity = 81;
    paramContext.setAttributes(paramQQAppInterface);
    paramContext.setWindowAnimations(2131952661);
    paramContext.setFlags(16777216, 16777216);
    setCancelable(true);
    setCanceledOnTouchOutside(true);
    a();
  }
  
  public static String a(long paramLong, boolean paramBoolean)
  {
    boolean bool = DateFormat.is24HourFormat(BaseApplication.getContext());
    paramLong = System.currentTimeMillis() + paramLong;
    if ((!bool) && (!paramBoolean))
    {
      String str = new SimpleDateFormat("hh:mm").format(new Date(paramLong));
      Object localObject = Calendar.getInstance();
      ((Calendar)localObject).setTimeInMillis(paramLong);
      if (((Calendar)localObject).get(9) == 0)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(HardCodeUtil.a(2131905470));
        ((StringBuilder)localObject).append(str);
        return ((StringBuilder)localObject).toString();
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131905478));
      ((StringBuilder)localObject).append(str);
      return ((StringBuilder)localObject).toString();
    }
    return new SimpleDateFormat("HH:mm").format(new Date(paramLong));
  }
  
  private void a()
  {
    Object localObject = this.c;
    if (localObject == null) {
      return;
    }
    this.b = ((TimeWheelPanel)((View)localObject).findViewById(2131439818));
    this.b.a(0, 24, 60, 0);
    this.b.a(true);
    this.b.setViewVisibility(0, 8);
    this.b.setViewVisibility(3, 0);
    this.b.setScrollerStateListener(this);
    this.d = ((TextView)this.c.findViewById(2131430294));
    this.e = ((TextView)this.c.findViewById(2131431241));
    this.e.setTextColor(getContext().getResources().getColor(2131168049));
    this.d.setClickable(true);
    this.e.setClickable(true);
    this.d.setOnClickListener(this);
    this.e.setOnClickListener(this);
    this.d.setFocusable(true);
    this.e.setFocusable(true);
    this.e.setEnabled(false);
    this.e.setTextColor(getContext().getResources().getColor(2131168291));
    if (this.a != null)
    {
      localObject = HardCodeUtil.a(2131898212);
      String str = HardCodeUtil.a(2131905469);
      this.d.setContentDescription((CharSequence)localObject);
      this.e.setContentDescription(str);
    }
    a(null, null);
    setOnCancelListener(this);
  }
  
  public static String b(long paramLong)
  {
    return a(paramLong, false);
  }
  
  public void a(long paramLong)
  {
    long l = paramLong;
    if ((int)paramLong % 86400 % 3600 % 60 != 0) {
      l = paramLong + 60L;
    }
    Object localObject1 = this.b;
    int m = (int)l;
    ((TimeWheelPanel)localObject1).a = (m / 86400);
    m %= 86400;
    ((TimeWheelPanel)localObject1).b = (m / 3600);
    ((TimeWheelPanel)localObject1).c = (m % 3600 / 60);
    ((TimeWheelPanel)localObject1).setValues(true);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(HardCodeUtil.a(2131905467));
    ((StringBuilder)localObject1).append(b(this.b.getCurrentSeconds() * 1000));
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(HardCodeUtil.a(2131905467));
    ((StringBuilder)localObject2).append(a(this.b.getCurrentSeconds() * 1000, true));
    localObject2 = ((StringBuilder)localObject2).toString();
    this.b.setEndTime((String)localObject1, (String)localObject2);
  }
  
  public void a(NumberWheelView paramNumberWheelView, VerticalGallery paramVerticalGallery)
  {
    if (paramNumberWheelView != null) {
      this.k = true;
    }
    if (this.b.getCurrentSeconds() == 0)
    {
      this.e.setEnabled(false);
      this.e.setTextColor(getContext().getResources().getColor(2131168291));
    }
    else if (this.k)
    {
      this.e.setEnabled(true);
      this.e.setTextColor(getContext().getResources().getColor(2131168416));
    }
    paramNumberWheelView = new StringBuilder();
    paramNumberWheelView.append(HardCodeUtil.a(2131905467));
    paramNumberWheelView.append(b(this.b.getCurrentSeconds() * 1000));
    paramNumberWheelView = paramNumberWheelView.toString();
    paramVerticalGallery = new StringBuilder();
    paramVerticalGallery.append(HardCodeUtil.a(2131905467));
    paramVerticalGallery.append(a(this.b.getCurrentSeconds() * 1000, true));
    paramVerticalGallery = paramVerticalGallery.toString();
    this.b.setEndTime(paramNumberWheelView, paramVerticalGallery);
  }
  
  public void a(AtomicBoolean paramAtomicBoolean)
  {
    this.i = paramAtomicBoolean;
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.b.a(0, 24, 60, 0);
    a(null, null);
  }
  
  public void onClick(View paramView)
  {
    int m = paramView.getId();
    if (m != 2131430294)
    {
      if (m == 2131431241)
      {
        dismiss();
        long l1 = this.b.getCurrentSeconds() / 60;
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append(HardCodeUtil.a(2131905467));
        ((StringBuilder)localObject).append(b(this.b.getCurrentSeconds() * 1000));
        localObject = ((StringBuilder)localObject).toString();
        this.f.setText((CharSequence)localObject);
        this.i.set(true);
        long l2 = NetConnInfoCenter.getServerTime();
        long l3 = this.b.getCurrentSeconds();
        ((CardHandler)this.g.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).a((int)(l2 + l3), "", "not_disturb_from_notify_push_setting_activity");
        this.b.a(0, 24, 60, 0);
        a(null, null);
        localObject = this.g;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(l1);
        localStringBuilder.append("");
        ReportController.b((AppRuntime)localObject, "CliOper", "", "", "0X8009DD2", "0X8009DD2", 0, 1, localStringBuilder.toString(), "0", "", "");
      }
    }
    else
    {
      dismiss();
      onCancel(null);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onShow(DialogInterface paramDialogInterface)
  {
    this.k = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.settings.message.NotifyPushSettingFragment.TimePickDialog
 * JD-Core Version:    0.7.0.1
 */