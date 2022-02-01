package com.tencent.mobileqq.msgbackup.fragment;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.Nullable;
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
import androidx.fragment.app.FragmentActivity;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.widget.DispatchActionMoveScrollView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import java.util.Calendar;

public class MsgBackupDateFragment
  extends QIphoneTitleBarFragment
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = 0L;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  RadioGroup.OnCheckedChangeListener jdField_a_of_type_AndroidWidgetRadioGroup$OnCheckedChangeListener = new MsgBackupDateFragment.3(this);
  private RadioGroup jdField_a_of_type_AndroidWidgetRadioGroup;
  private IphonePickerView jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView;
  private ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  private String jdField_a_of_type_JavaLangString;
  private Calendar jdField_a_of_type_JavaUtilCalendar;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long = 0L;
  View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new MsgBackupDateFragment.1(this);
  RadioGroup.OnCheckedChangeListener jdField_b_of_type_AndroidWidgetRadioGroup$OnCheckedChangeListener = new MsgBackupDateFragment.4(this);
  private RadioGroup jdField_b_of_type_AndroidWidgetRadioGroup;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private String jdField_b_of_type_JavaLangString;
  private Calendar jdField_b_of_type_JavaUtilCalendar;
  private int jdField_c_of_type_Int;
  View.OnClickListener jdField_c_of_type_AndroidViewView$OnClickListener = new MsgBackupDateFragment.2(this);
  private RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout;
  private boolean jdField_c_of_type_Boolean = false;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean = false;
  private int e;
  private int f;
  private int jdField_g_of_type_Int;
  private TextView jdField_g_of_type_AndroidWidgetTextView;
  private int jdField_h_of_type_Int;
  private TextView jdField_h_of_type_AndroidWidgetTextView;
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
  private int u = 0;
  
  private void a(int paramInt)
  {
    Calendar localCalendar;
    if (paramInt == 1)
    {
      this.jdField_a_of_type_JavaLangString = String.format("%d.%d.%d", new Object[] { Integer.valueOf(this.m), Integer.valueOf(this.n), Integer.valueOf(this.o) });
      this.jdField_c_of_type_Boolean = true;
      this.jdField_g_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
      a(this.jdField_g_of_type_AndroidWidgetTextView, this.jdField_a_of_type_JavaLangString);
      localCalendar = Calendar.getInstance();
      localCalendar.set(this.m, this.n - 1, this.o, 0, 0, 0);
      this.jdField_a_of_type_Long = (localCalendar.getTimeInMillis() / 1000L);
      return;
    }
    if (paramInt == 2)
    {
      this.jdField_b_of_type_JavaLangString = String.format("%d.%d.%d", new Object[] { Integer.valueOf(this.m), Integer.valueOf(this.n), Integer.valueOf(this.o) });
      this.jdField_h_of_type_AndroidWidgetTextView.setText(this.jdField_b_of_type_JavaLangString);
      a(this.jdField_h_of_type_AndroidWidgetTextView, this.jdField_b_of_type_JavaLangString);
      this.jdField_d_of_type_Boolean = true;
      localCalendar = Calendar.getInstance();
      localCalendar.set(this.m, this.n - 1, this.o, 23, 59, 59);
      this.jdField_b_of_type_Long = (localCalendar.getTimeInMillis() / 1000L);
      if ((this.jdField_c_of_type_Boolean) && (this.jdField_d_of_type_Boolean)) {
        i_(true);
      }
    }
  }
  
  private void a(View paramView, String paramString)
  {
    if (AppSetting.jdField_d_of_type_Boolean) {
      paramView.setContentDescription(paramString);
    }
  }
  
  private void b(int paramInt)
  {
    Calendar localCalendar1;
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
      }
      else if (localCalendar1.after(this.jdField_a_of_type_JavaUtilCalendar))
      {
        this.jdField_a_of_type_Int = (this.j - this.q);
        this.jdField_b_of_type_Int = (this.k - 1);
        this.jdField_c_of_type_Int = (this.l - 1);
        this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(0, this.jdField_a_of_type_Int);
        this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(1, this.jdField_b_of_type_Int);
        this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(2, this.jdField_c_of_type_Int);
      }
      if (this.jdField_d_of_type_Boolean)
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
    else
    {
      localCalendar1 = Calendar.getInstance();
      localCalendar1.set(1, this.q + this.jdField_d_of_type_Int);
      localCalendar1.set(2, this.e);
      localCalendar1.set(5, this.f + 1);
      if (localCalendar1.before(this.jdField_b_of_type_JavaUtilCalendar))
      {
        this.jdField_d_of_type_Int = 0;
        this.e = (this.r - 1);
        this.f = (this.s - 1);
        this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(0, this.jdField_d_of_type_Int);
        this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(1, this.e);
        this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(2, this.f);
      }
      else if (localCalendar1.after(this.jdField_a_of_type_JavaUtilCalendar))
      {
        this.jdField_d_of_type_Int = (this.j - this.q);
        this.e = (this.k - 1);
        this.f = (this.l - 1);
        this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(0, this.jdField_d_of_type_Int);
        this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(1, this.e);
        this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(2, this.f);
      }
      if (paramInt == 2)
      {
        localCalendar2 = Calendar.getInstance();
        localCalendar2.setTimeInMillis(this.jdField_a_of_type_Long * 1000L);
        if (localCalendar1.before(localCalendar2))
        {
          this.jdField_d_of_type_Int = (localCalendar2.get(1) - this.q);
          this.e = localCalendar2.get(2);
          this.f = (localCalendar2.get(5) - 1);
          this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(0, this.jdField_d_of_type_Int);
          this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(1, this.e);
          this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(2, this.f);
        }
      }
    }
  }
  
  private void c()
  {
    if ((this.jdField_a_of_type_Long != 0L) && (this.jdField_b_of_type_Long != 0L))
    {
      ((RadioButton)this.jdField_a_of_type_AndroidWidgetRadioGroup.findViewById(2131365406)).setChecked(true);
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.setTimeInMillis(this.jdField_a_of_type_Long * 1000L);
      this.jdField_a_of_type_JavaLangString = String.format("%d.%d.%d", new Object[] { Integer.valueOf(localCalendar.get(1)), Integer.valueOf(localCalendar.get(2) + 1), Integer.valueOf(localCalendar.get(5)) });
      this.jdField_g_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
      a(this.jdField_g_of_type_AndroidWidgetTextView, this.jdField_a_of_type_JavaLangString);
      localCalendar.setTimeInMillis(this.jdField_b_of_type_Long * 1000L);
      this.jdField_b_of_type_JavaLangString = String.format("%d.%d.%d", new Object[] { Integer.valueOf(localCalendar.get(1)), Integer.valueOf(localCalendar.get(2) + 1), Integer.valueOf(localCalendar.get(5)) });
      this.jdField_h_of_type_AndroidWidgetTextView.setText(this.jdField_b_of_type_JavaLangString);
      a(this.jdField_h_of_type_AndroidWidgetTextView, this.jdField_b_of_type_JavaLangString);
      i_(true);
    }
    else
    {
      ((RadioButton)this.jdField_a_of_type_AndroidWidgetRadioGroup.findViewById(2131365405)).setChecked(true);
    }
    int i1 = this.p;
    if (i1 == 1)
    {
      this.jdField_b_of_type_AndroidWidgetRadioGroup.check(2131365185);
      return;
    }
    if (i1 == 2) {
      this.jdField_b_of_type_AndroidWidgetRadioGroup.check(2131365186);
    }
  }
  
  private void d()
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
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("startTime = ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Long);
      ((StringBuilder)localObject).append(", endTime = ");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_Long);
      ((StringBuilder)localObject).append(", mCurContentType = ");
      ((StringBuilder)localObject).append(this.p);
      QLog.d("MsgBackup.BackupAndMigrateDateFragment", 2, ((StringBuilder)localObject).toString());
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
    this.jdField_g_of_type_Int = this.jdField_a_of_type_Int;
    this.jdField_h_of_type_Int = this.jdField_b_of_type_Int;
    this.i = this.jdField_c_of_type_Int;
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup.BackupAndMigrateDateFragment", 2, String.format("initData date range: %s-%s-%s to %s-%s-%s", new Object[] { Integer.valueOf(this.q), Integer.valueOf(this.r), Integer.valueOf(this.s), Integer.valueOf(this.j), Integer.valueOf(this.k), Integer.valueOf(this.l) }));
    }
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidWidgetRadioGroup = ((RadioGroup)this.jdField_b_of_type_AndroidViewView.findViewById(2131363362));
    this.jdField_a_of_type_AndroidWidgetRadioGroup.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetRadioGroup$OnCheckedChangeListener);
    this.jdField_b_of_type_AndroidWidgetRadioGroup = ((RadioGroup)this.jdField_b_of_type_AndroidViewView.findViewById(2131363359));
    this.jdField_b_of_type_AndroidWidgetRadioGroup.setOnCheckedChangeListener(this.jdField_b_of_type_AndroidWidgetRadioGroup$OnCheckedChangeListener);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131365416));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131363360));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131365409));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131363361));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.jdField_h_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131365410));
  }
  
  private void f()
  {
    a(getActivity().getString(2131690546));
    c(2131690544, this.jdField_b_of_type_AndroidViewView$OnClickListener);
    a(2131690543, this.jdField_c_of_type_AndroidViewView$OnClickListener);
  }
  
  private void g()
  {
    Object localObject = this.jdField_a_of_type_ComTencentWidgetActionSheet;
    if (localObject != null) {
      ((ActionSheet)localObject).dismiss();
    }
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView = ((IphonePickerView)getActivity().getLayoutInflater().inflate(2131561132, null));
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(new MsgBackupDateFragment.DateAdapter(this, null));
      this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheet.createMenuSheet(getActivity());
      this.jdField_a_of_type_ComTencentWidgetActionSheet.setCloseAutoRead(true);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.setActionContentView(this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView, null);
      localObject = (DispatchActionMoveScrollView)this.jdField_a_of_type_ComTencentWidgetActionSheet.findViewById(2131361999);
      ((DispatchActionMoveScrollView)localObject).jdField_a_of_type_Boolean = true;
      ((DispatchActionMoveScrollView)localObject).setBackgroundResource(17170445);
      if (Build.VERSION.SDK_INT >= 11)
      {
        localObject = this.jdField_a_of_type_ComTencentWidgetActionSheet.getWindow();
        if (localObject != null) {
          ((Window)localObject).setFlags(16777216, 16777216);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setPickListener(new MsgBackupDateFragment.5(this));
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView;
    int i1;
    if (localObject != null)
    {
      localObject = (TextView)((IphonePickerView)localObject).findViewById(2131377144);
      Button localButton = (Button)this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.findViewById(2131378713);
      ((Button)this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.findViewById(2131378714)).setText(HardCodeUtil.a(2131706955));
      localButton.setVisibility(0);
      localButton.setOnClickListener(new MsgBackupDateFragment.6(this));
      i1 = this.u;
      if (i1 == 1)
      {
        ((TextView)localObject).setText(HardCodeUtil.a(2131706943));
        ((TextView)localObject).setVisibility(0);
        ((TextView)localObject).setCompoundDrawables(null, null, null, null);
      }
      else if (i1 == 2)
      {
        ((TextView)localObject).setText(HardCodeUtil.a(2131706944));
        ((TextView)localObject).setVisibility(0);
        ((TextView)localObject).setCompoundDrawables(null, null, null, null);
      }
    }
    if (!this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView;
      if (localObject != null)
      {
        i1 = this.u;
        if (i1 == 1)
        {
          if (this.jdField_c_of_type_Boolean)
          {
            ((IphonePickerView)localObject).setSelection(0, this.jdField_a_of_type_Int);
            this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(1, this.jdField_b_of_type_Int);
            this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(2, this.jdField_c_of_type_Int);
          }
          else
          {
            ((IphonePickerView)localObject).setSelection(0, this.jdField_g_of_type_Int);
            this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(1, this.jdField_h_of_type_Int);
            this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(2, this.i);
          }
        }
        else if (i1 == 2) {
          if (this.jdField_d_of_type_Boolean)
          {
            ((IphonePickerView)localObject).setSelection(0, this.jdField_d_of_type_Int);
            this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(1, this.e);
            this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(2, this.f);
          }
          else
          {
            ((IphonePickerView)localObject).setSelection(0, this.jdField_g_of_type_Int);
            this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(1, this.jdField_h_of_type_Int);
            this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(2, this.i);
          }
        }
      }
    }
    try
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
      return;
    }
    catch (Exception localException) {}
  }
  
  private void h()
  {
    int i1 = this.u;
    if (i1 == 1)
    {
      this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(0);
      this.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(1);
      this.jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(2);
      return;
    }
    if (i1 == 2)
    {
      this.jdField_d_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(0);
      this.e = this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(1);
      this.f = this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(2);
    }
  }
  
  private void i()
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
    this.m = (this.q + this.jdField_d_of_type_Int);
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(this.m, this.e, this.f + 1);
    this.m = localCalendar.get(1);
    this.n = (localCalendar.get(2) + 1);
    this.o = localCalendar.get(5);
  }
  
  protected int a()
  {
    return 2131561437;
  }
  
  public void a()
  {
    if (getActivity() != null)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("date fragment finish called! before is correct date time-------> startTime = ");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_Long);
        ((StringBuilder)localObject).append(", endtime = ");
        ((StringBuilder)localObject).append(this.jdField_b_of_type_Long);
        ((StringBuilder)localObject).append(", contentType = ");
        ((StringBuilder)localObject).append(this.p);
        QLog.d("MsgBackup.BackupAndMigrateDateFragment", 2, ((StringBuilder)localObject).toString());
      }
      long l1 = this.jdField_a_of_type_Long;
      long l2 = this.jdField_b_of_type_Long;
      if (l1 >= l2) {
        this.jdField_a_of_type_Long = l2;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("date fragment finish called! after is correct date time-------> startTime = ");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_Long);
        ((StringBuilder)localObject).append(", endtime = ");
        ((StringBuilder)localObject).append(this.jdField_b_of_type_Long);
        ((StringBuilder)localObject).append(", contentType = ");
        ((StringBuilder)localObject).append(this.p);
        QLog.d("MsgBackup.BackupAndMigrateDateFragment", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = new Intent();
      ((Intent)localObject).putExtra("session_start_time", this.jdField_a_of_type_Long);
      ((Intent)localObject).putExtra("session_end_time", this.jdField_b_of_type_Long);
      ((Intent)localObject).putExtra("session_start_time_str", this.jdField_a_of_type_JavaLangString);
      ((Intent)localObject).putExtra("session_end_time_str", this.jdField_b_of_type_JavaLangString);
      ((Intent)localObject).putExtra("session_content_type", this.p);
      getActivity().setResult(0, (Intent)localObject);
      getActivity().finish();
    }
  }
  
  protected void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    f();
    e();
    d();
    c();
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if ((i1 != 2131365409) && (i1 != 2131363360))
    {
      if (((i1 == 2131363361) || (i1 == 2131365410)) && ((this.jdField_c_of_type_Boolean) || ((this.jdField_a_of_type_Long != 0L) && (this.jdField_a_of_type_JavaLangString != null))))
      {
        this.u = 2;
        g();
      }
    }
    else
    {
      this.u = 1;
      g();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.fragment.MsgBackupDateFragment
 * JD-Core Version:    0.7.0.1
 */