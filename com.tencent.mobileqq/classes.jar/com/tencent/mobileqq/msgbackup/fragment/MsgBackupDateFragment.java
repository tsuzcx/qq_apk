package com.tencent.mobileqq.msgbackup.fragment;

import ajjy;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import arqg;
import arqh;
import arqi;
import arqj;
import arqk;
import arql;
import arqm;
import begr;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.widget.DispatchActionMoveScrollView;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;

public class MsgBackupDateFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new arqg(this);
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  RadioGroup.OnCheckedChangeListener jdField_a_of_type_AndroidWidgetRadioGroup$OnCheckedChangeListener = new arqi(this);
  private RadioGroup jdField_a_of_type_AndroidWidgetRadioGroup;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private begr jdField_a_of_type_Begr;
  private IphonePickerView jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView;
  private String jdField_a_of_type_JavaLangString;
  private Calendar jdField_a_of_type_JavaUtilCalendar;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new arqh(this);
  RadioGroup.OnCheckedChangeListener jdField_b_of_type_AndroidWidgetRadioGroup$OnCheckedChangeListener = new arqj(this);
  private RadioGroup jdField_b_of_type_AndroidWidgetRadioGroup;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString;
  private Calendar jdField_b_of_type_JavaUtilCalendar;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k;
  private int l;
  private int m;
  private int n;
  private int o;
  private int p = 1;
  private int q;
  private int r;
  private int s;
  private int t;
  private int u;
  
  private void a(int paramInt)
  {
    Calendar localCalendar;
    if (paramInt == 1)
    {
      this.jdField_a_of_type_JavaLangString = String.format("%d.%d.%d", new Object[] { Integer.valueOf(this.m), Integer.valueOf(this.n), Integer.valueOf(this.o) });
      this.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
      a(this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_a_of_type_JavaLangString);
      localCalendar = Calendar.getInstance();
      localCalendar.set(this.m, this.n - 1, this.o, 0, 0, 0);
      this.jdField_a_of_type_Long = (localCalendar.getTimeInMillis() / 1000L);
    }
    do
    {
      do
      {
        return;
      } while (paramInt != 2);
      this.jdField_b_of_type_JavaLangString = String.format("%d.%d.%d", new Object[] { Integer.valueOf(this.m), Integer.valueOf(this.n), Integer.valueOf(this.o) });
      this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_b_of_type_JavaLangString);
      a(this.jdField_b_of_type_AndroidWidgetTextView, this.jdField_b_of_type_JavaLangString);
      this.jdField_c_of_type_Boolean = true;
      localCalendar = Calendar.getInstance();
      localCalendar.set(this.m, this.n - 1, this.o, 23, 59, 59);
      this.jdField_b_of_type_Long = (localCalendar.getTimeInMillis() / 1000L);
    } while ((!this.jdField_b_of_type_Boolean) || (!this.jdField_c_of_type_Boolean));
    setRightButtonEnable(true);
  }
  
  private void a(View paramView, String paramString)
  {
    if (AppSetting.jdField_c_of_type_Boolean) {
      paramView.setContentDescription(paramString);
    }
  }
  
  private void b()
  {
    if ((this.jdField_a_of_type_Long != 0L) && (this.jdField_b_of_type_Long != 0L))
    {
      ((RadioButton)this.jdField_a_of_type_AndroidWidgetRadioGroup.findViewById(2131299346)).setChecked(true);
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.setTimeInMillis(this.jdField_a_of_type_Long * 1000L);
      this.jdField_a_of_type_JavaLangString = String.format("%d.%d.%d", new Object[] { Integer.valueOf(localCalendar.get(1)), Integer.valueOf(localCalendar.get(2) + 1), Integer.valueOf(localCalendar.get(5)) });
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
      a(this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_a_of_type_JavaLangString);
      localCalendar.setTimeInMillis(this.jdField_b_of_type_Long * 1000L);
      this.jdField_b_of_type_JavaLangString = String.format("%d.%d.%d", new Object[] { Integer.valueOf(localCalendar.get(1)), Integer.valueOf(localCalendar.get(2) + 1), Integer.valueOf(localCalendar.get(5)) });
      this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_b_of_type_JavaLangString);
      a(this.jdField_b_of_type_AndroidWidgetTextView, this.jdField_b_of_type_JavaLangString);
      setRightButtonEnable(true);
      if (this.p != 1) {
        break label246;
      }
      this.jdField_b_of_type_AndroidWidgetRadioGroup.check(2131299147);
    }
    label246:
    while (this.p != 2)
    {
      return;
      ((RadioButton)this.jdField_a_of_type_AndroidWidgetRadioGroup.findViewById(2131299345)).setChecked(true);
      break;
    }
    this.jdField_b_of_type_AndroidWidgetRadioGroup.check(2131299148);
  }
  
  private void b(int paramInt)
  {
    Calendar localCalendar1;
    label115:
    Calendar localCalendar2;
    if (paramInt == 1)
    {
      localCalendar1 = Calendar.getInstance();
      localCalendar1.set(1, this.q + this.jdField_a_of_type_Int);
      localCalendar1.set(2, this.jdField_b_of_type_Int);
      localCalendar1.set(5, this.jdField_c_of_type_Int + 1);
      if (localCalendar1.before(this.jdField_b_of_type_JavaUtilCalendar))
      {
        this.jdField_a_of_type_Int = 0;
        this.jdField_b_of_type_Int = (this.r - 1);
        this.jdField_c_of_type_Int = (this.s - 1);
        this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(0, this.jdField_a_of_type_Int);
        this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(1, this.jdField_b_of_type_Int);
        this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(2, this.jdField_c_of_type_Int);
        break label216;
        if (this.jdField_c_of_type_Boolean)
        {
          localCalendar2 = Calendar.getInstance();
          localCalendar2.setTimeInMillis(this.jdField_b_of_type_Long * 1000L);
          if (localCalendar1.after(localCalendar2))
          {
            this.jdField_a_of_type_Int = (localCalendar2.get(1) - this.q);
            this.jdField_b_of_type_Int = localCalendar2.get(2);
            this.jdField_c_of_type_Int = (localCalendar2.get(5) - 1);
            this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(0, this.jdField_a_of_type_Int);
            this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(1, this.jdField_b_of_type_Int);
            this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(2, this.jdField_c_of_type_Int);
          }
        }
      }
    }
    label591:
    for (;;)
    {
      label216:
      return;
      if (!localCalendar1.after(this.jdField_a_of_type_JavaUtilCalendar)) {
        break label115;
      }
      this.jdField_a_of_type_Int = (this.j - this.q);
      this.jdField_b_of_type_Int = (this.k - 1);
      this.jdField_c_of_type_Int = (this.l - 1);
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(0, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(1, this.jdField_b_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(2, this.jdField_c_of_type_Int);
      break label115;
      localCalendar1 = Calendar.getInstance();
      localCalendar1.set(1, this.q + this.d);
      localCalendar1.set(2, this.e);
      localCalendar1.set(5, this.f + 1);
      if (localCalendar1.before(this.jdField_b_of_type_JavaUtilCalendar))
      {
        this.d = 0;
        this.e = (this.r - 1);
        this.f = (this.s - 1);
        this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(0, this.d);
        this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(1, this.e);
        this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(2, this.f);
      }
      for (;;)
      {
        if (paramInt != 2) {
          break label591;
        }
        localCalendar2 = Calendar.getInstance();
        localCalendar2.setTimeInMillis(this.jdField_a_of_type_Long * 1000L);
        if (!localCalendar1.before(localCalendar2)) {
          break;
        }
        this.d = (localCalendar2.get(1) - this.q);
        this.e = localCalendar2.get(2);
        this.f = (localCalendar2.get(5) - 1);
        this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(0, this.d);
        this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(1, this.e);
        this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(2, this.f);
        return;
        if (localCalendar1.after(this.jdField_a_of_type_JavaUtilCalendar))
        {
          this.d = (this.j - this.q);
          this.e = (this.k - 1);
          this.f = (this.l - 1);
          this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(0, this.d);
          this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(1, this.e);
          this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(2, this.f);
        }
      }
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    if (getActivity() != null)
    {
      localObject = getActivity().getIntent();
      if (localObject != null)
      {
        this.jdField_a_of_type_Long = ((Intent)localObject).getLongExtra("session_start_time", 0L);
        this.jdField_b_of_type_Long = ((Intent)localObject).getLongExtra("session_end_time", 0L);
        this.p = ((Intent)localObject).getIntExtra("session_content_type", 1);
        this.t = ((Intent)localObject).getIntExtra("backup_select_from", 0);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup.BackupAndMigrateDateFragment", 2, "startTime = " + this.jdField_a_of_type_Long + ", endTime = " + this.jdField_b_of_type_Long + ", mCurContentType = " + this.p);
    }
    this.jdField_a_of_type_JavaUtilCalendar = Calendar.getInstance();
    this.jdField_a_of_type_JavaUtilCalendar.setTimeInMillis(System.currentTimeMillis());
    this.j = this.jdField_a_of_type_JavaUtilCalendar.get(1);
    this.k = (this.jdField_a_of_type_JavaUtilCalendar.get(2) + 1);
    this.l = this.jdField_a_of_type_JavaUtilCalendar.get(5);
    Object localObject = Calendar.getInstance();
    ((Calendar)localObject).setTimeInMillis(System.currentTimeMillis());
    this.m = ((Calendar)localObject).get(1);
    this.n = (((Calendar)localObject).get(2) + 1);
    this.o = ((Calendar)localObject).get(5);
    this.jdField_b_of_type_JavaUtilCalendar = Calendar.getInstance();
    this.jdField_b_of_type_JavaUtilCalendar.setTimeInMillis(System.currentTimeMillis());
    this.jdField_b_of_type_JavaUtilCalendar.add(1, -30);
    this.jdField_b_of_type_JavaUtilCalendar.add(5, 1);
    this.q = this.jdField_b_of_type_JavaUtilCalendar.get(1);
    this.r = (this.jdField_b_of_type_JavaUtilCalendar.get(2) + 1);
    this.s = this.jdField_b_of_type_JavaUtilCalendar.get(5);
    this.jdField_a_of_type_Int = (this.j - this.q);
    this.jdField_b_of_type_Int = (this.k - 1);
    this.jdField_c_of_type_Int = (this.l - 1);
    this.g = this.jdField_a_of_type_Int;
    this.h = this.jdField_b_of_type_Int;
    this.i = this.jdField_c_of_type_Int;
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup.BackupAndMigrateDateFragment", 2, String.format("initData date range: %s-%s-%s to %s-%s-%s", new Object[] { Integer.valueOf(this.q), Integer.valueOf(this.r), Integer.valueOf(this.s), Integer.valueOf(this.j), Integer.valueOf(this.k), Integer.valueOf(this.l) }));
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidWidgetRadioGroup = ((RadioGroup)this.mContentView.findViewById(2131297471));
    this.jdField_a_of_type_AndroidWidgetRadioGroup.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetRadioGroup$OnCheckedChangeListener);
    this.jdField_b_of_type_AndroidWidgetRadioGroup = ((RadioGroup)this.mContentView.findViewById(2131297468));
    this.jdField_b_of_type_AndroidWidgetRadioGroup.setOnCheckedChangeListener(this.jdField_b_of_type_AndroidWidgetRadioGroup$OnCheckedChangeListener);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.mContentView.findViewById(2131299353));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.mContentView.findViewById(2131297469));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131299349));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.mContentView.findViewById(2131297470));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131299350));
  }
  
  private void e()
  {
    setTitle(getActivity().getString(2131624789));
    setRightButton(2131624787, this.jdField_a_of_type_AndroidViewView$OnClickListener);
    setLeftButton(2131624786, this.jdField_b_of_type_AndroidViewView$OnClickListener);
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_Begr != null) {
      this.jdField_a_of_type_Begr.dismiss();
    }
    Object localObject;
    if (this.jdField_a_of_type_Begr == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView = ((IphonePickerView)getActivity().getLayoutInflater().inflate(2131495228, null));
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(new arqm(this, null));
      this.jdField_a_of_type_Begr = begr.c(getActivity());
      this.jdField_a_of_type_Begr.d(true);
      this.jdField_a_of_type_Begr.a(this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView, null);
      localObject = (DispatchActionMoveScrollView)this.jdField_a_of_type_Begr.findViewById(2131296387);
      ((DispatchActionMoveScrollView)localObject).jdField_a_of_type_Boolean = true;
      ((DispatchActionMoveScrollView)localObject).setBackgroundResource(17170445);
      if (Build.VERSION.SDK_INT >= 11)
      {
        localObject = this.jdField_a_of_type_Begr.getWindow();
        if (localObject != null) {
          ((Window)localObject).setFlags(16777216, 16777216);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setPickListener(new arqk(this));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView != null)
    {
      localObject = (TextView)this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.findViewById(2131310029);
      Button localButton = (Button)this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.findViewById(2131311471);
      ((Button)this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.findViewById(2131311472)).setText(ajjy.a(2131641132));
      localButton.setVisibility(0);
      localButton.setOnClickListener(new arql(this));
      if (this.u == 1)
      {
        ((TextView)localObject).setText(ajjy.a(2131641120));
        ((TextView)localObject).setVisibility(0);
        ((TextView)localObject).setCompoundDrawables(null, null, null, null);
      }
    }
    else if ((!this.jdField_a_of_type_Begr.isShowing()) && (this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView != null))
    {
      if (this.u != 1) {
        break label414;
      }
      if (!this.jdField_b_of_type_Boolean) {
        break label375;
      }
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(0, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(1, this.jdField_b_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(2, this.jdField_c_of_type_Int);
    }
    for (;;)
    {
      label375:
      try
      {
        this.jdField_a_of_type_Begr.show();
        return;
      }
      catch (Exception localException) {}
      if (this.u != 2) {
        break;
      }
      ((TextView)localObject).setText(ajjy.a(2131641121));
      ((TextView)localObject).setVisibility(0);
      ((TextView)localObject).setCompoundDrawables(null, null, null, null);
      break;
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(0, this.g);
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(1, this.h);
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(2, this.i);
      continue;
      label414:
      if (this.u == 2) {
        if (this.jdField_c_of_type_Boolean)
        {
          this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(0, this.d);
          this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(1, this.e);
          this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(2, this.f);
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(0, this.g);
          this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(1, this.h);
          this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(2, this.i);
        }
      }
    }
  }
  
  private void g()
  {
    if (this.u == 1)
    {
      this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(0);
      this.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(1);
      this.jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(2);
    }
    while (this.u != 2) {
      return;
    }
    this.d = this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(0);
    this.e = this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(1);
    this.f = this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(2);
  }
  
  private void h()
  {
    if (this.u == 1)
    {
      this.m = (this.q + this.jdField_a_of_type_Int);
      localCalendar = Calendar.getInstance();
      localCalendar.set(this.m, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int + 1);
      this.m = localCalendar.get(1);
      this.n = (localCalendar.get(2) + 1);
      this.o = localCalendar.get(5);
      return;
    }
    this.m = (this.q + this.d);
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(this.m, this.e, this.f + 1);
    this.m = localCalendar.get(1);
    this.n = (localCalendar.get(2) + 1);
    this.o = localCalendar.get(5);
  }
  
  public void a()
  {
    if (getActivity() != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup.BackupAndMigrateDateFragment", 2, "date fragment finish called! before is correct date time-------> startTime = " + this.jdField_a_of_type_Long + ", endtime = " + this.jdField_b_of_type_Long + ", contentType = " + this.p);
      }
      if (this.jdField_a_of_type_Long >= this.jdField_b_of_type_Long) {
        this.jdField_a_of_type_Long = this.jdField_b_of_type_Long;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup.BackupAndMigrateDateFragment", 2, "date fragment finish called! after is correct date time-------> startTime = " + this.jdField_a_of_type_Long + ", endtime = " + this.jdField_b_of_type_Long + ", contentType = " + this.p);
      }
      Intent localIntent = new Intent();
      localIntent.putExtra("session_start_time", this.jdField_a_of_type_Long);
      localIntent.putExtra("session_end_time", this.jdField_b_of_type_Long);
      localIntent.putExtra("session_start_time_str", this.jdField_a_of_type_JavaLangString);
      localIntent.putExtra("session_end_time_str", this.jdField_b_of_type_JavaLangString);
      localIntent.putExtra("session_content_type", this.p);
      getActivity().setResult(0, localIntent);
      getActivity().finish();
    }
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    e();
    d();
    c();
    b();
  }
  
  public int getContentLayoutId()
  {
    return 2131495482;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
      this.u = 1;
      f();
      return;
    } while ((!this.jdField_b_of_type_Boolean) && ((this.jdField_a_of_type_Long == 0L) || (this.jdField_a_of_type_JavaLangString == null)));
    this.u = 2;
    f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.fragment.MsgBackupDateFragment
 * JD-Core Version:    0.7.0.1
 */