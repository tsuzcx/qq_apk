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
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyResetUtils;
import com.tencent.mobileqq.kandian.biz.config.api.IQQAladdinUtils;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyEntityManagerFactory;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyLogicEngineFactory;
import com.tencent.mobileqq.kandian.repo.aladdin.QQAladdinPrefUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.List;
import java.util.Map;

public class ReadInJoyResetDebugFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener
{
  private void a()
  {
    TextView localTextView = (TextView)this.mContentView.findViewById(2131378634);
    if (localTextView != null)
    {
      StringBuilder localStringBuilder = new StringBuilder("看点相关 manage 系统配置版本号：\n");
      localStringBuilder.append("type=READINJOY_COMMON_CONFIG[");
      localStringBuilder.append(92);
      localStringBuilder.append("], ");
      localStringBuilder.append(SharedPreUtils.K(BaseApplicationImpl.getApplication(), ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAccount()));
      localStringBuilder.append("\n");
      localStringBuilder.append("type=READINJOY_RESET_ALL_CONFIG[");
      localStringBuilder.append(368);
      localStringBuilder.append("], ");
      localStringBuilder.append(SharedPreUtils.L(BaseApplicationImpl.getApplication(), ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAccount()));
      localStringBuilder.append("\n");
      localStringBuilder.append("type=READINJOY_FOLDER_CONFIG_CMD[");
      localStringBuilder.append(72);
      localStringBuilder.append("], ");
      localStringBuilder.append(SharedPreUtils.I(BaseApplicationImpl.getApplication(), ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAccount()));
      localStringBuilder.append("\n");
      localStringBuilder.append("type=READINJOY_FOLDER_SETTING_CMD[");
      localStringBuilder.append(73);
      localStringBuilder.append("], ");
      localStringBuilder.append(SharedPreUtils.x(BaseApplicationImpl.getApplication()));
      localStringBuilder.append("\n");
      localStringBuilder.append(SharedPreUtils.a(BaseApplicationImpl.getApplication(), "readinjoy_search_jump_url_version", ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAccount()));
      localStringBuilder.append("\n");
      localTextView.setText(localStringBuilder.toString());
    }
  }
  
  private void b()
  {
    TextView localTextView = (TextView)this.mContentView.findViewById(2131378628);
    if (localTextView != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("阿拉丁配置内容：\n");
      localStringBuilder.append(QQAladdinPrefUtils.a());
      localTextView.setText(localStringBuilder.toString());
    }
  }
  
  private void c()
  {
    boolean bool = ((Boolean)((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).getReadInJoySpValue("aladdin.redirect_root", Boolean.valueOf(false))).booleanValue();
    ((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).updateReadInJoySpValue("aladdin.redirect_root", Boolean.valueOf(bool ^ true));
  }
  
  private void d()
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
    boolean bool = ((Boolean)((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).getReadInJoySpValue("aladdin.redirect_root", Boolean.valueOf(false))).booleanValue();
    TextView localTextView = (TextView)this.mContentView.findViewById(2131378627);
    if (!bool) {
      localObject1 = localObject2;
    }
    localTextView.setText((CharSequence)localObject1);
  }
  
  private void e()
  {
    int i = SharedPreUtils.L(BaseApplicationImpl.getApplication(), ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAccount());
    int j = ((IReadInJoyResetUtils)QRoute.api(IReadInJoyResetUtils.class)).getLocalResetVersion();
    TextView localTextView = (TextView)this.mContentView.findViewById(2131378637);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Reset配置服务器版本号： ");
    localStringBuilder.append(i);
    localStringBuilder.append(HardCodeUtil.a(2131712816));
    localStringBuilder.append(j);
    localTextView.setText(localStringBuilder.toString());
  }
  
  private void f()
  {
    ((IQQAladdinUtils)QRoute.api(IQQAladdinUtils.class)).maybeGetAllConfigs();
  }
  
  private void g()
  {
    QLog.d("ReadInJoyResetDebugFrag", 2, "showSpInfo: ");
    Object localObject = ((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).getReadInJoySP(true, true);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("account: ");
    localStringBuilder.append(((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAccount());
    localStringBuilder.append("\n");
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).getAll();
      localStringBuilder.append("size: ");
      localStringBuilder.append(((Map)localObject).size());
      localStringBuilder.append("\n");
    }
    ((TextView)this.mContentView.findViewById(2131378639)).setText(localStringBuilder.toString());
  }
  
  private void h()
  {
    try
    {
      Object localObject = ((IReadInJoyLogicEngineFactory)QRoute.api(IReadInJoyLogicEngineFactory.class)).createReadInJoyLogicEngine().a();
      if ((localObject instanceof ReadInJoyEntityManagerFactory))
      {
        localObject = ((ReadInJoyEntityManagerFactory)localObject).a();
        if (((List)localObject).isEmpty())
        {
          ((TextView)this.mContentView.findViewById(2131378630)).setText("no table found");
          return;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("found tables: \n");
        localStringBuilder.append(TextUtils.join("\n", (Iterable)localObject));
        localObject = localStringBuilder.toString();
        ((TextView)this.mContentView.findViewById(2131378630)).setText((CharSequence)localObject);
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("ReadInJoyResetDebugFrag", 2, "clearReadInJoyDatabase: ", localException);
    }
  }
  
  private void i()
  {
    ((TextView)this.mContentView.findViewById(2131378633)).setText(((IReadInJoyResetUtils)QRoute.api(IReadInJoyResetUtils.class)).getLocalFilesPathForDebug());
  }
  
  private void j()
  {
    Achilles.a("com.tencent.reading", true);
  }
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.mContentView.findViewById(2131364178).setOnClickListener(this);
    this.mContentView.findViewById(2131364193).setOnClickListener(this);
    this.mContentView.findViewById(2131364169).setOnClickListener(this);
    this.mContentView.findViewById(2131364191).setOnClickListener(this);
    this.mContentView.findViewById(2131364167).setOnClickListener(this);
    this.mContentView.findViewById(2131364192).setOnClickListener(this);
    this.mContentView.findViewById(2131364168).setOnClickListener(this);
    this.mContentView.findViewById(2131364187).setOnClickListener(this);
    this.mContentView.findViewById(2131364189).setOnClickListener(this);
    this.mContentView.findViewById(2131364188).setOnClickListener(this);
    this.mContentView.findViewById(2131364195).setOnClickListener(this);
    this.mContentView.findViewById(2131364185).setOnClickListener(this);
    a();
    b();
    e();
    d();
  }
  
  protected int getContentLayoutId()
  {
    return 2131560267;
  }
  
  public void onClick(View paramView)
  {
    QLog.d("ReadInJoyResetDebugFrag", 2, "onClick: ");
    int i = paramView.getId();
    if (i != 2131364178)
    {
      if (i != 2131364195)
      {
        switch (i)
        {
        default: 
          switch (i)
          {
          default: 
            switch (i)
            {
            default: 
              return;
            case 2131364193: 
              g();
              return;
            case 2131364192: 
              i();
              return;
            }
            h();
            return;
          case 2131364189: 
            ((IReadInJoyResetUtils)QRoute.api(IReadInJoyResetUtils.class)).resetKandianRelatedManageConfigVersions();
            a();
            Toast.makeText(getBaseActivity(), HardCodeUtil.a(2131712806), 0).show();
            return;
          case 2131364188: 
            ((IReadInJoyResetUtils)QRoute.api(IReadInJoyResetUtils.class)).resetLocalResetConfigVersionForDebug();
            e();
            return;
          case 2131364187: 
            QQAladdinPrefUtils.a();
            b();
            return;
          case 2131364186: 
            SharedPreUtils.p(BaseApplicationImpl.getApplication(), 0, ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAccount());
            ((IReadInJoyResetUtils)QRoute.api(IReadInJoyResetUtils.class)).resetLocalResetConfigVersionForDebug();
            e();
            Toast.makeText(getBaseActivity(), HardCodeUtil.a(2131712996), 0).show();
            return;
          }
          j();
          return;
        case 2131364169: 
          ((IReadInJoyResetUtils)QRoute.api(IReadInJoyResetUtils.class)).clearReadInJoySharedPreferences();
          return;
        case 2131364168: 
          ((IReadInJoyResetUtils)QRoute.api(IReadInJoyResetUtils.class)).clearReadInJoyLocalFiles();
          return;
        }
        ((IReadInJoyResetUtils)QRoute.api(IReadInJoyResetUtils.class)).clearReadInJoyDatabase();
        return;
      }
      c();
      d();
      return;
    }
    f();
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.ReadInJoyResetDebugFragment
 * JD-Core Version:    0.7.0.1
 */