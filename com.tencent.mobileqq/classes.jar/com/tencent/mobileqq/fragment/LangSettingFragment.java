package com.tencent.mobileqq.fragment;

import android.app.Dialog;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.LocaleManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.CustomDialogFactory;
import com.tencent.widget.ActionSheet;
import java.util.Arrays;
import java.util.List;

public class LangSettingFragment
  extends IphoneTitleBarFragment
{
  private static final List<Integer> a = Arrays.asList(new Integer[] { Integer.valueOf(2052), Integer.valueOf(1033) });
  private Dialog b = null;
  private ActionSheet c;
  private int d;
  
  private String a(int paramInt, boolean paramBoolean)
  {
    int j = ((Integer)a.get(0)).intValue();
    int i = j;
    if (paramInt >= 0)
    {
      i = j;
      if (paramInt < a.size()) {
        i = ((Integer)a.get(paramInt)).intValue();
      }
    }
    return LocaleManager.a(i);
  }
  
  private void a(int paramInt)
  {
    if (this.c == null) {
      this.c = ActionSheet.create(getBaseActivity());
    }
    this.c.setMainTitle(String.format(getResources().getString(2131891128), new Object[] { a(paramInt, true) }));
    this.c.addButton(String.format(getResources().getString(2131891127), new Object[] { a(paramInt, true) }));
    this.c.addCancelButton(getResources().getString(2131891126));
    this.c.setOnButtonClickListener(new LangSettingFragment.1(this, paramInt));
    this.c.show();
  }
  
  private void b()
  {
    int j = LocaleManager.d();
    int i = 0;
    if (j == 0)
    {
      this.d = 0;
      return;
    }
    while (i < a.size())
    {
      if (((Integer)a.get(i)).intValue() == j)
      {
        this.d = i;
        return;
      }
      i += 1;
    }
  }
  
  private void b(int paramInt)
  {
    Dialog localDialog = this.b;
    if ((localDialog != null) && (localDialog.isShowing()))
    {
      this.b.dismiss();
      this.b = null;
    }
    this.b = CustomDialogFactory.a(getBaseActivity(), 2131889651, 2131889649, 2131889648, 2131889650, new LangSettingFragment.2(this), new LangSettingFragment.3(this, paramInt));
    if (!getBaseActivity().isFinishing())
    {
      localDialog = this.b;
      if (localDialog != null) {
        localDialog.show();
      }
    }
  }
  
  private void c(int paramInt)
  {
    ThreadManagerV2.executeOnSubThread(new LangSettingFragment.5(this, paramInt, new LangSettingFragment.4(this)));
  }
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    b();
    setTitle(getResources().getString(2131916303));
    ((ListView)this.mContentView.findViewById(2131436842)).setAdapter(new LangSettingFragment.LocaleListAdapter(this));
    paramLayoutInflater = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (paramLayoutInflater != null) {
      ReportController.b(paramLayoutInflater, "dc00898", "", "", "0X800A611", "0X800A5A7", 0, 0, "", "", "", "");
    }
  }
  
  protected int getContentLayoutId()
  {
    return 2131627806;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.LangSettingFragment
 * JD-Core Version:    0.7.0.1
 */