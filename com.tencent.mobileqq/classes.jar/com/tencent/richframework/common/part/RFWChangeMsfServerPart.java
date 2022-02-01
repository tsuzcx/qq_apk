package com.tencent.richframework.common.part;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.LayoutParams;
import com.google.gson.Gson;
import com.tencent.biz.richframework.config.RFWCommonConfig;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.biz.richframework.part.BlockPart;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.tempapi.api.IQQBaseService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.common.RFWCommonGlobalInfo;
import com.tencent.richframework.common.data.MsfEnv;
import com.tencent.richframework.common.data.MsfServerRsp;
import com.tencent.richframework.common.request.RFWCommonGetRainbowKVConfRequest;
import java.util.ArrayList;
import java.util.Random;
import qqcircle.QQCircleConfig.GetRainbowKVConfRsp;

public class RFWChangeMsfServerPart
  extends BlockPart
  implements View.OnClickListener
{
  private static final Random a = new Random();
  private ImageView b;
  private RadioGroup e;
  private Button f;
  private MsfServerRsp g;
  private String h = RFWCommonGlobalInfo.a();
  private MsfEnv i;
  @SuppressLint({"WrongConstant"})
  private SharedPreferences j = RFWCommonConfig.a();
  
  private RadioButton a(String paramString, boolean paramBoolean)
  {
    RadioButton localRadioButton = new RadioButton(g());
    localRadioButton.setText(paramString);
    localRadioButton.setChecked(paramBoolean);
    localRadioButton.setTextColor(2131167876);
    localRadioButton.setPadding(30, 0, 0, 0);
    return localRadioButton;
  }
  
  private MsfEnv a(int paramInt)
  {
    MsfServerRsp localMsfServerRsp = this.g;
    if ((localMsfServerRsp != null) && (localMsfServerRsp.env_list != null))
    {
      if (this.g.env_list.size() <= 0) {
        return null;
      }
      int k = 0;
      while (k < this.g.env_list.size())
      {
        if (paramInt == ((MsfEnv)this.g.env_list.get(k)).resId) {
          return (MsfEnv)this.g.env_list.get(k);
        }
        k += 1;
      }
    }
    return null;
  }
  
  private void a(MsfEnv paramMsfEnv)
  {
    if (paramMsfEnv == null) {
      return;
    }
    SharedPreferences.Editor localEditor = this.j.edit();
    localEditor.putString("rfw_common_msf_server_id", paramMsfEnv.id);
    localEditor.putString("rfw_common_msf_server_name", paramMsfEnv.name);
    localEditor.apply();
  }
  
  private void a(ArrayList<MsfEnv> paramArrayList)
  {
    this.e.removeAllViews();
    int k = 0;
    while (k < paramArrayList.size())
    {
      MsfEnv localMsfEnv = (MsfEnv)paramArrayList.get(k);
      boolean bool = this.h.equals(localMsfEnv.id);
      localMsfEnv.resId = a.nextInt();
      RadioButton localRadioButton = a(localMsfEnv.name, bool);
      localRadioButton.setId(localMsfEnv.resId);
      localRadioButton.setTag(localMsfEnv);
      this.e.addView(localRadioButton, new RadioGroup.LayoutParams(-1, -2));
      k += 1;
    }
  }
  
  private void a(boolean paramBoolean, QQCircleConfig.GetRainbowKVConfRsp paramGetRainbowKVConfRsp)
  {
    if (paramBoolean) {
      if (paramGetRainbowKVConfRsp.data.get() == null) {
        return;
      }
    }
    try
    {
      this.g = ((MsfServerRsp)new Gson().fromJson(paramGetRainbowKVConfRsp.data.get(), MsfServerRsp.class));
      if ((this.g == null) || (this.g.env_list == null) || (this.g.env_list.size() <= 0)) {
        break label120;
      }
      a(this.g.env_list);
      return;
    }
    catch (Exception localException)
    {
      label83:
      StringBuilder localStringBuilder;
      break label83;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("GetRainbowKVConfRsp json exception!： json is:");
    localStringBuilder.append(paramGetRainbowKVConfRsp.data.get());
    QLog.i("QCircleChangeMsfServerPart", 1, localStringBuilder.toString());
    label120:
  }
  
  private void d()
  {
    this.e.setOnCheckedChangeListener(new RFWChangeMsfServerPart.1(this));
  }
  
  private void e()
  {
    VSNetworkHelper.getInstance().sendRequest(new RFWCommonGetRainbowKVConfRequest("4aa831c0-51c9-4dc9-9ab2-1e99ec9031f0", "trpc.feedcloud.commgateway.CommGateway.TEST", "colorV2.json"), new RFWChangeMsfServerPart.2(this));
  }
  
  private void f()
  {
    if ((!j().onBackEvent()) && (c() != null)) {
      c().finish();
    }
  }
  
  private void l()
  {
    Object localObject = this.i;
    if (localObject == null) {
      return;
    }
    a((MsfEnv)localObject);
    RFWCommonGlobalInfo.a(this.i.id);
    if (this.i.use_test_sso) {
      localObject = "socket://14.18.180.90:60000";
    } else {
      localObject = "";
    }
    ((IQQBaseService)QRoute.api(IQQBaseService.class)).setNewSsoAndRestartApp((String)localObject);
  }
  
  private void m()
  {
    MsfEnv localMsfEnv = this.i;
    if (localMsfEnv == null) {
      return;
    }
    Button localButton = this.f;
    int k;
    if (this.h.equals(localMsfEnv.id)) {
      k = 8;
    } else {
      k = 0;
    }
    localButton.setVisibility(k);
  }
  
  public String a()
  {
    return "QCircleChangeMsfServerPart";
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.b = ((ImageView)paramView.findViewById(2131436618));
    this.b.setOnClickListener(this);
    this.f = ((Button)paramView.findViewById(2131444712));
    this.f.setOnClickListener(this);
    this.e = ((RadioGroup)paramView.findViewById(2131444763));
    d();
    e();
  }
  
  public void onClick(View paramView)
  {
    int k = paramView.getId();
    if (k == 2131436618) {
      f();
    } else if (k == 2131444712) {
      l();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.richframework.common.part.RFWChangeMsfServerPart
 * JD-Core Version:    0.7.0.1
 */