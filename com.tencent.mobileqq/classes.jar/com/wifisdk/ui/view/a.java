package com.wifisdk.ui.view;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.wifisdk.ui.api.RProxy.id;
import com.wifisdk.ui.api.RProxy.layout;
import com.wifisdk.ui.api.RProxy.string;
import java.util.List;
import wf7.fm;
import wf7.fm.a;
import wf7.fq;
import wf7.hc.b;
import wf7.hk;
import wf7.hl;
import wf7.hn;
import wf7.hr;
import wf7.ht;
import wf7.hu;
import wf7.hv;

public class a
  implements AdapterView.OnItemClickListener
{
  private static final String TAG = "a";
  private Context mContext;
  private hc.b sJ;
  private d tY;
  private WifiCommonView tq;
  private ProgressBar uA;
  private TextView uB;
  private View.OnClickListener uC;
  private Handler uD;
  private TextView uE;
  private LinearLayout uF;
  private TextView uG;
  private ListView uH;
  private e uI;
  private int uJ;
  private View uK;
  private RelativeLayout uL;
  private ImageView uM;
  private TextView uN;
  private TextView uO;
  private TextView uP;
  private int uQ = 0;
  private boolean uR;
  private ViewGroup uS;
  private a.a uT;
  private hu uw;
  private ht ux;
  private ViewGroup uy;
  private TextView uz;
  
  public a(Context paramContext, a.a parama)
  {
    this.mContext = paramContext;
    this.uS = ((ViewGroup)LayoutInflater.from(this.mContext).inflate(RProxy.layout.wifi_sdk_activity_main_full, null));
    this.uT = parama;
  }
  
  private void a(hr paramhr, boolean paramBoolean)
  {
    if (hl.fp())
    {
      hl.a(fq.cr(), paramhr.ssid, paramhr.security, null);
      if (paramBoolean) {
        hk.az(398630);
      }
    }
    else
    {
      hv.fD().a(this.mContext, 2);
    }
  }
  
  private void fI()
  {
    Object localObject = fm.dL().dO();
    if (localObject != null) {
      localObject = ((fm.a)localObject).qu;
    } else {
      localObject = null;
    }
    int i = hl.i("com.tencent.wifimanager", (String)localObject);
    if (this.uQ == i) {
      return;
    }
    if (i == 3)
    {
      this.uy.setVisibility(8);
      this.uy.setOnClickListener(null);
      this.uG.setVisibility(8);
      this.uG.setOnClickListener(null);
    }
    else
    {
      if (this.uC == null) {
        this.uC = new a.5(this);
      }
      this.uy.setVisibility(0);
      this.uy.setOnClickListener(this.uC);
      if (i == 2)
      {
        this.uz.setVisibility(0);
        this.uA.setVisibility(8);
        this.uB.setVisibility(8);
        this.uG.setVisibility(8);
        this.uG.setOnClickListener(null);
        this.uz.setText(RProxy.string.tmsdk_wifi_banner_btn_install);
        hk.az(398523);
      }
      else
      {
        if (this.sJ == null) {
          this.sJ = fJ();
        }
        hv.fD().a(this.sJ);
        this.uz.setText(RProxy.string.tmsdk_wifi_banner_btn_no_wifi);
        this.uG.setVisibility(0);
        this.uG.setOnClickListener(this.uC);
        hk.az(398521);
      }
    }
    this.uQ = i;
  }
  
  private hc.b fJ()
  {
    return new a.6(this);
  }
  
  private boolean fM()
  {
    return (this.uR) || (this.tq.fQ());
  }
  
  public void aD(int paramInt)
  {
    if (paramInt == this.uJ) {
      return;
    }
    this.uD.post(new a.4(this, paramInt));
  }
  
  public void b(List<hn> paramList, boolean paramBoolean)
  {
    this.uD.post(new a.2(this, paramList, paramBoolean));
  }
  
  public void fH()
  {
    this.uD.post(new a.3(this));
  }
  
  public hu fK()
  {
    return this.uw;
  }
  
  public ht fL()
  {
    return this.ux;
  }
  
  public View getContentView()
  {
    return this.uS;
  }
  
  public void onBackPressed()
  {
    if (!fM()) {
      hk.az(500179);
    }
  }
  
  public void onCreate()
  {
    this.uD = new Handler(Looper.getMainLooper());
    this.uS.findViewById(RProxy.id.tmsdk_wifi_title_back_text).setOnClickListener(new a.1(this));
    this.uy = ((ViewGroup)this.uS.findViewById(RProxy.id.tmsdk_wifi_bottom_banner));
    this.uy.setVisibility(8);
    this.uz = ((TextView)this.uy.findViewById(RProxy.id.tmsdk_wifi_banner_button));
    this.uA = ((ProgressBar)this.uy.findViewById(RProxy.id.tmsdk_wifi_banner_progress));
    this.uA.setProgress(0);
    this.uB = ((TextView)this.uy.findViewById(RProxy.id.tmsdk_wifi_banner_progress_text));
    this.uE = ((TextView)this.uS.findViewById(RProxy.id.tmsdk_wifi_list_empty_hint));
    this.uL = ((RelativeLayout)this.uS.findViewById(RProxy.id.tmsdk_wifi_permission_layout));
    this.uM = ((ImageView)this.uL.findViewById(RProxy.id.tmsdk_wifi_permission_layout_icon));
    this.uN = ((TextView)this.uL.findViewById(RProxy.id.tmsdk_wifi_permission_layout_title));
    this.uO = ((TextView)this.uL.findViewById(RProxy.id.tmsdk_wifi_permission_layout_des));
    this.uP = ((TextView)this.uL.findViewById(RProxy.id.tmsdk_wifi_permission_layout_btn));
    this.uF = ((LinearLayout)this.uS.findViewById(RProxy.id.tmsdk_wifi_list_layout));
    this.uG = ((TextView)this.uF.findViewById(RProxy.id.tmsdk_wifi_tip));
    this.uH = ((ListView)this.uF.findViewById(RProxy.id.tmsdk_wifi_listview));
    View localView = new View(this.mContext.getApplicationContext());
    localView.setVisibility(8);
    this.uH.addHeaderView(localView);
    this.uI = new e(this.mContext.getApplicationContext());
    this.uH.setAdapter(this.uI);
    this.uH.setOnItemClickListener(this);
    this.uw = new hu(3);
    this.uw.a(this);
    this.tY = new d(this.mContext, this.uH);
    this.ux = new ht();
    this.ux.a(this.tY);
    this.tq = ((WifiCommonView)this.uS.findViewById(RProxy.id.tmsdk_wifi_wifi_disable_layout));
    this.tq.c(this.mContext, 2);
  }
  
  public void onDestroy()
  {
    hv.fD().a(null);
    this.tY.onDestroy();
    this.tq.onDestroy();
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.uR = true;
    Object localObject = (hn)this.uH.getAdapter().getItem(paramInt);
    if ((localObject != null) && (((hn)localObject).tz == 0))
    {
      localObject = (hr)localObject;
      hk.az(500623);
      if (localObject != null) {
        if (((hr)localObject).tI == 1)
        {
          a((hr)localObject, true);
          hk.az(500106);
        }
        else
        {
          a((hr)localObject, false);
          hk.az(398516);
        }
      }
    }
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.wifisdk.ui.view.a
 * JD-Core Version:    0.7.0.1
 */