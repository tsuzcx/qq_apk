package com.tencent.mobileqq.kandian.biz.common;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyEntityManagerFactory;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.repo.aladdin.QQAladdinPrefUtils;
import com.tencent.mobileqq.kandian.repo.aladdin.config.QQAladdinUtils;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.List;
import java.util.Map;

public class ReadInJoyResetDebugFragment
  extends QIphoneTitleBarFragment
  implements View.OnClickListener
{
  private void b()
  {
    TextView localTextView = (TextView)this.t.findViewById(2131447273);
    if (localTextView != null)
    {
      StringBuilder localStringBuilder = new StringBuilder("看点相关 manage 系统配置版本号：\n");
      localStringBuilder.append("type=READINJOY_COMMON_CONFIG[");
      localStringBuilder.append(92);
      localStringBuilder.append("], ");
      localStringBuilder.append(SharedPreUtils.U(BaseApplicationImpl.getApplication(), RIJQQAppInterfaceUtil.d()));
      localStringBuilder.append("\n");
      localStringBuilder.append("type=READINJOY_RESET_ALL_CONFIG[");
      localStringBuilder.append(368);
      localStringBuilder.append("], ");
      localStringBuilder.append(SharedPreUtils.V(BaseApplicationImpl.getApplication(), RIJQQAppInterfaceUtil.d()));
      localStringBuilder.append("\n");
      localStringBuilder.append("type=READINJOY_FOLDER_CONFIG_CMD[");
      localStringBuilder.append(72);
      localStringBuilder.append("], ");
      localStringBuilder.append(SharedPreUtils.S(BaseApplicationImpl.getApplication(), RIJQQAppInterfaceUtil.d()));
      localStringBuilder.append("\n");
      localStringBuilder.append("type=READINJOY_FOLDER_SETTING_CMD[");
      localStringBuilder.append(73);
      localStringBuilder.append("], ");
      localStringBuilder.append(SharedPreUtils.I(BaseApplicationImpl.getApplication()));
      localStringBuilder.append("\n");
      localStringBuilder.append(SharedPreUtils.c(BaseApplicationImpl.getApplication(), "readinjoy_search_jump_url_version", RIJQQAppInterfaceUtil.d()));
      localStringBuilder.append("\n");
      localTextView.setText(localStringBuilder.toString());
    }
  }
  
  private void c()
  {
    TextView localTextView = (TextView)this.t.findViewById(2131447267);
    if (localTextView != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("阿拉丁配置内容：\n");
      localStringBuilder.append(QQAladdinPrefUtils.b());
      localTextView.setText(localStringBuilder.toString());
    }
  }
  
  private void d()
  {
    RIJSPUtils.a("aladdin.redirect_root", Boolean.valueOf(((Boolean)RIJSPUtils.b("aladdin.redirect_root", Boolean.valueOf(false))).booleanValue() ^ true));
  }
  
  private void e()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath());
    ((StringBuilder)localObject1).append(File.separator);
    ((StringBuilder)localObject1).append("aladdin_configs");
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(BaseApplicationImpl.getContext().getFilesDir().getAbsolutePath());
    ((StringBuilder)localObject2).append(File.separator);
    ((StringBuilder)localObject2).append("aladdin_configs");
    localObject2 = ((StringBuilder)localObject2).toString();
    boolean bool = ((Boolean)RIJSPUtils.b("aladdin.redirect_root", Boolean.valueOf(false))).booleanValue();
    TextView localTextView = (TextView)this.t.findViewById(2131447266);
    if (!bool) {
      localObject1 = localObject2;
    }
    localTextView.setText((CharSequence)localObject1);
  }
  
  private void f()
  {
    int i = SharedPreUtils.V(BaseApplicationImpl.getApplication(), RIJQQAppInterfaceUtil.d());
    int j = ReadInJoyResetUtils.a();
    TextView localTextView = (TextView)this.t.findViewById(2131447276);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Reset配置服务器版本号： ");
    localStringBuilder.append(i);
    localStringBuilder.append(HardCodeUtil.a(2131910389));
    localStringBuilder.append(j);
    localTextView.setText(localStringBuilder.toString());
  }
  
  private void g() {}
  
  private void h()
  {
    QLog.d("ReadInJoyResetDebugFrag", 2, "showSpInfo: ");
    Object localObject = RIJSPUtils.a(RIJQQAppInterfaceUtil.e(), true, true);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("account: ");
    localStringBuilder.append(RIJQQAppInterfaceUtil.d());
    localStringBuilder.append("\n");
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).getAll();
      localStringBuilder.append("size: ");
      localStringBuilder.append(((Map)localObject).size());
      localStringBuilder.append("\n");
    }
    ((TextView)this.t.findViewById(2131447278)).setText(localStringBuilder.toString());
  }
  
  private void p()
  {
    try
    {
      Object localObject = ReadInJoyLogicEngine.a().b();
      if ((localObject instanceof ReadInJoyEntityManagerFactory))
      {
        localObject = ((ReadInJoyEntityManagerFactory)localObject).b();
        if (((List)localObject).isEmpty())
        {
          ((TextView)this.t.findViewById(2131447269)).setText("no table found");
          return;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("found tables: \n");
        localStringBuilder.append(TextUtils.join("\n", (Iterable)localObject));
        localObject = localStringBuilder.toString();
        ((TextView)this.t.findViewById(2131447269)).setText((CharSequence)localObject);
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("ReadInJoyResetDebugFrag", 2, "clearReadInJoyDatabase: ", localException);
    }
  }
  
  private void q()
  {
    ((TextView)this.t.findViewById(2131447272)).setText(ReadInJoyResetUtils.h());
  }
  
  private void r()
  {
    Achilles.a("com.tencent.reading", true);
  }
  
  protected int a()
  {
    return 2131626314;
  }
  
  protected void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    this.t.findViewById(2131430160).setOnClickListener(this);
    this.t.findViewById(2131430190).setOnClickListener(this);
    this.t.findViewById(2131430145).setOnClickListener(this);
    this.t.findViewById(2131430188).setOnClickListener(this);
    this.t.findViewById(2131430142).setOnClickListener(this);
    this.t.findViewById(2131430189).setOnClickListener(this);
    this.t.findViewById(2131430143).setOnClickListener(this);
    this.t.findViewById(2131430182).setOnClickListener(this);
    this.t.findViewById(2131430184).setOnClickListener(this);
    this.t.findViewById(2131430183).setOnClickListener(this);
    this.t.findViewById(2131430192).setOnClickListener(this);
    this.t.findViewById(2131430179).setOnClickListener(this);
    b();
    c();
    f();
    e();
  }
  
  public void onClick(View paramView)
  {
    QLog.d("ReadInJoyResetDebugFrag", 2, "onClick: ");
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131430192: 
      d();
      e();
      return;
    case 2131430190: 
      h();
      return;
    case 2131430189: 
      q();
      return;
    case 2131430188: 
      p();
      return;
    case 2131430184: 
      ReadInJoyResetUtils.c();
      b();
      Toast.makeText(getActivity(), HardCodeUtil.a(2131910379), 0).show();
      return;
    case 2131430183: 
      ReadInJoyResetUtils.i();
      f();
      return;
    case 2131430182: 
      QQAladdinPrefUtils.a();
      c();
      return;
    case 2131430181: 
      SharedPreUtils.p(BaseApplicationImpl.getApplication(), 0, RIJQQAppInterfaceUtil.d());
      ReadInJoyResetUtils.i();
      f();
      Toast.makeText(getActivity(), HardCodeUtil.a(2131910560), 0).show();
      return;
    case 2131430179: 
      r();
      return;
    case 2131430160: 
      g();
      c();
      return;
    case 2131430145: 
      ReadInJoyResetUtils.e();
      return;
    case 2131430143: 
      ReadInJoyResetUtils.g();
      return;
    }
    ReadInJoyResetUtils.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.ReadInJoyResetDebugFragment
 * JD-Core Version:    0.7.0.1
 */