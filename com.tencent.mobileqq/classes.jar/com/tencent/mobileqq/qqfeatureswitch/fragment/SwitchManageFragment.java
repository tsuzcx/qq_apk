package com.tencent.mobileqq.qqfeatureswitch.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.qqfeatureswitch.FeatureSwitch;
import com.tencent.mobileqq.qqfeatureswitch.SwitchManageAdapter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.List;
import mqq.app.AppRuntime;

public class SwitchManageFragment
  extends QPublicBaseFragment
  implements View.OnClickListener, SwitchManageController.ISwitchManageView
{
  public static String a = "";
  private SwitchManageController b;
  private EditText c;
  private SwitchManageAdapter d;
  
  private void a(View paramView)
  {
    ((TextView)paramView.findViewById(2131448722)).setOnClickListener(this);
    this.c = ((EditText)paramView.findViewById(2131432633));
    this.c.clearFocus();
    Object localObject = paramView.findViewById(2131445043);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((View)localObject).getLayoutParams();
    localLayoutParams.topMargin += ImmersiveUtils.getStatusBarHeight(getActivity());
    ((View)localObject).setLayoutParams(localLayoutParams);
    localObject = (ListView)paramView.findViewById(2131437782);
    this.d = new SwitchManageAdapter(getQBaseActivity());
    ((ListView)localObject).setAdapter(this.d);
    ((TextView)paramView.findViewById(2131436227)).setText(getString(2131889226));
    ((TextView)paramView.findViewById(2131436180)).setOnClickListener(this);
    ((TextView)paramView.findViewById(2131448708)).setOnClickListener(this);
  }
  
  public AppRuntime a()
  {
    return getQBaseActivity().getAppRuntime();
  }
  
  public void a(List<FeatureSwitch> paramList)
  {
    this.d.a(paramList);
    this.d.notifyDataSetChanged();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131448722)
    {
      String str = this.c.getText().toString();
      com.tencent.mobileqq.util.Utils.c = str;
      this.b.a(str);
    }
    else if (paramView.getId() == 2131436180)
    {
      getActivity().finish();
    }
    else if (paramView.getId() == 2131448708)
    {
      this.b.a();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Nullable
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    this.b = new SwitchManageController(this);
    paramLayoutInflater = paramLayoutInflater.inflate(2131629363, paramViewGroup, false);
    a(paramLayoutInflater);
    this.b.b();
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqfeatureswitch.fragment.SwitchManageFragment
 * JD-Core Version:    0.7.0.1
 */