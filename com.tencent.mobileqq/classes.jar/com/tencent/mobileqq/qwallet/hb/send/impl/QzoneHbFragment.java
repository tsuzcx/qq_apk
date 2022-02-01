package com.tencent.mobileqq.qwallet.hb.send.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.qqpay.ui.R.anim;
import com.tencent.mobileqq.qqpay.ui.R.id;
import com.tencent.mobileqq.qqpay.ui.R.layout;
import com.tencent.mobileqq.qqpay.ui.R.string;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.config.IQWalletConfigService;
import com.tencent.mobileqq.qwallet.hb.send.busylogic.impl.SendHbLogic;
import com.tencent.mobileqq.qwallet.hb.send.view.impl.RollNumberView;
import com.tencent.mobileqq.qwallet.hb.send.view.impl.RollNumberView.OnRollListener;
import com.tencent.mobileqq.qwallet.preload.IPreloadImgApi.OnSingleDownloadCallback;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.QwUtils;
import cooperation.qwallet.plugin.IQWalletHelper;
import java.util.Map;
import java.util.Random;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;

public class QzoneHbFragment
  extends BaseHbFragment
  implements View.OnClickListener, FragmentInterface, RollNumberView.OnRollListener
{
  private String A;
  private View B;
  private RollNumberView C;
  private long D = 0L;
  private boolean E = false;
  private QzoneHbFragment.SendHbHandler F = new QzoneHbFragment.SendHbHandler(this);
  private SharedPreferences G = null;
  private int H = 1;
  protected TextWatcher a = new QzoneHbFragment.1(this);
  IPreloadImgApi.OnSingleDownloadCallback b = new QzoneHbFragment.4(this);
  private View c;
  private ImageView d;
  private TextView l;
  private EditText m;
  private Button n;
  private Button o;
  private JSONArray p = new JSONArray();
  private String q;
  private View r;
  private Animation s;
  private boolean t = false;
  private String u;
  private String v = "1.00";
  private String w;
  private String x;
  private String y;
  private String z;
  
  public static void a(Handler paramHandler, EditText paramEditText)
  {
    if ((paramHandler != null) && (paramEditText != null)) {
      paramHandler.postDelayed(new QzoneHbFragment.8(paramEditText), 100L);
    }
  }
  
  private void a(View paramView)
  {
    if (paramView == null) {
      return;
    }
    this.c = paramView.findViewById(R.id.br);
    this.d = ((ImageView)paramView.findViewById(R.id.bv));
    this.l = ((TextView)paramView.findViewById(R.id.bs));
    this.m = ((EditText)paramView.findViewById(R.id.bp));
    this.n = ((Button)paramView.findViewById(R.id.bq));
    this.o = ((Button)paramView.findViewById(R.id.ce));
    this.B = paramView.findViewById(R.id.bZ);
    this.s = AnimationUtils.loadAnimation(getActivity(), R.anim.a);
    this.r = paramView.findViewById(R.id.T);
    this.C = ((RollNumberView)paramView.findViewById(R.id.bw));
  }
  
  private void e()
  {
    this.n.setOnClickListener(this);
    this.o.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.B.setOnClickListener(this);
    this.C.setLisener(this);
    this.m.addTextChangedListener(this.a);
  }
  
  private void f()
  {
    this.G = getActivity().getPreferences(0);
    try
    {
      this.p.put("1.00");
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    Object localObject = getArguments();
    if (localObject != null)
    {
      this.y = ((Bundle)localObject).getString("recv_name");
      this.z = ((Bundle)localObject).getString("feedsid");
      this.w = ((Bundle)localObject).getString("recv_uin");
      this.A = ((Bundle)localObject).getString("recv_type");
      if ((32768 == this.i) && (!this.A.equals("1"))) {
        this.w = ((Bundle)localObject).getString("grab_uin_list");
      }
      this.x = ((Bundle)localObject).getString("send_uin");
      if (!TextUtils.isEmpty(this.y))
      {
        if (this.y.length() > 8)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(this.y.substring(0, 7));
          ((StringBuilder)localObject).append("...");
          this.y = ((StringBuilder)localObject).toString();
        }
        this.l.setText(this.y);
      }
      this.u = "1.00";
      this.m.setText(this.u);
    }
    this.m.setEnabled(false);
    this.d.setImageDrawable(FaceDrawable.getFaceDrawable(this.g, 1, this.w));
    this.F.postDelayed(new QzoneHbFragment.2(this), 10L);
    this.C.setVisibility(8);
    this.m.setVisibility(0);
  }
  
  private boolean g()
  {
    this.H = ((IQWalletConfigService)this.g.getRuntimeService(IQWalletConfigService.class, "")).getInt("grap_hb_verify", 1, new String[] { "videoRedMinValue" });
    return Integer.valueOf(QwUtils.b(this.u)).intValue() >= this.H;
  }
  
  private boolean h()
  {
    int i = this.m.getText().length();
    String str = this.m.getText().toString();
    if ((i != 0) && (!str.startsWith(".")))
    {
      if (str.endsWith(".")) {
        return false;
      }
      if (TextUtils.isEmpty(str)) {
        return false;
      }
      if (str.indexOf('.') == 0) {
        return false;
      }
      if ((str.indexOf('.') > 0) && (str.indexOf('.') < str.length() - 3))
      {
        str = getString(R.string.J);
        if (str != null) {
          this.f.showQzoneHbToast(str);
        }
        return false;
      }
    }
    try
    {
      double d1 = Double.valueOf(str).doubleValue();
      return d1 > 0.0D;
    }
    catch (Exception localException) {}
    return false;
    return false;
  }
  
  private void i()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if ((isAdded()) && (localFragmentActivity != null)) {
      this.B.getViewTreeObserver().addOnGlobalLayoutListener(new QzoneHbFragment.5(this, localFragmentActivity));
    }
  }
  
  private String j()
  {
    new JSONArray();
    Object localObject1 = this.p;
    if (localObject1 != null)
    {
      int i1 = ((JSONArray)localObject1).length();
      if (i1 > 0)
      {
        Random localRandom = new Random();
        int k = 0;
        int i = k;
        Object localObject2;
        try
        {
          Object localObject4 = this.G.getString("hb_key_rand_amount", "");
          Object localObject3 = null;
          localObject1 = localObject3;
          i = k;
          if (!TextUtils.isEmpty((CharSequence)localObject4))
          {
            i = k;
            localObject4 = new JSONArray((String)localObject4);
            localObject1 = localObject3;
            i = k;
            if (((JSONArray)localObject4).length() == this.p.length()) {
              localObject1 = localObject4;
            }
          }
          localObject3 = localObject1;
          if (localObject1 == null)
          {
            i = k;
            localObject1 = new JSONArray();
            j = 0;
            for (;;)
            {
              localObject3 = localObject1;
              i = k;
              if (j >= this.p.length()) {
                break;
              }
              i = k;
              ((JSONArray)localObject1).put(j, 0);
              j += 1;
            }
          }
          i = k;
          int j = a(localObject3, localRandom.nextInt(i1));
          i = j;
          localObject3.put(j, 1);
          i = j;
          localObject1 = this.G.edit();
          i = j;
          ((SharedPreferences.Editor)localObject1).putString("hb_key_rand_amount", localObject3.toString());
          i = j;
          ((SharedPreferences.Editor)localObject1).commit();
          i = j;
        }
        catch (Exception localException1)
        {
          localException1.printStackTrace();
          localObject2 = this.G.edit();
          ((SharedPreferences.Editor)localObject2).remove("hb_key_rand_amount");
          ((SharedPreferences.Editor)localObject2).commit();
        }
        try
        {
          localObject2 = this.p.get(i).toString();
          return localObject2;
        }
        catch (Exception localException2)
        {
          localException2.printStackTrace();
        }
      }
    }
    return "";
  }
  
  protected int a(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getResources();
      int i = paramContext.getIdentifier("navigation_bar_height", "dimen", "android");
      if (i > 0)
      {
        i = paramContext.getDimensionPixelSize(i);
        return i;
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return 0;
  }
  
  public int a(JSONArray paramJSONArray, int paramInt)
  {
    int j = 0;
    int k = 0;
    int i = j;
    if (paramJSONArray != null)
    {
      i = j;
      if (paramJSONArray.length() > paramInt)
      {
        if (paramInt < 0) {
          return 0;
        }
        i = k;
        try
        {
          int i2 = paramJSONArray.length();
          j = 0;
          while (j < i2)
          {
            int i1 = (paramInt + j) % i2;
            i = k;
            int i3 = paramJSONArray.optInt(i1);
            if (i3 == 0)
            {
              i = i1;
              break label91;
            }
            j += 1;
          }
          i = 0;
          label91:
          if (j == i2)
          {
            j = 0;
            for (;;)
            {
              if (j < i2) {
                try
                {
                  paramJSONArray.put(j, 0);
                  j += 1;
                }
                catch (Exception paramJSONArray)
                {
                  break label146;
                }
              }
            }
          }
          else
          {
            paramInt = i;
          }
          i = paramInt;
          paramJSONArray.put(paramInt, 1);
          return paramInt;
        }
        catch (Exception paramJSONArray)
        {
          label146:
          paramJSONArray.printStackTrace();
        }
      }
    }
    return i;
  }
  
  public void a()
  {
    this.D = System.currentTimeMillis();
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    if (this.i == 32768) {
      paramJSONObject = paramJSONObject.optJSONObject("mk_svideo_hb");
    } else {
      paramJSONObject = paramJSONObject.optJSONObject("mk_qzone_hb");
    }
    if (paramJSONObject == null) {
      return;
    }
    try
    {
      this.q = paramJSONObject.optString("comment");
      this.p = paramJSONObject.optJSONArray("money_array");
      this.u = j();
      if (!TextUtils.isEmpty(this.u)) {
        this.v = this.u;
      }
      paramJSONObject = this.F.obtainMessage();
      paramJSONObject.what = 100;
      this.F.sendMessage(paramJSONObject);
      return;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  public void c()
  {
    if (!isAdded()) {
      return;
    }
    getActivity();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(((IQWalletHelper)QRoute.api(IQWalletHelper.class)).getQWalletInternalPath());
    ((StringBuilder)localObject).append(this.x);
    ((StringBuilder)localObject).append("/hbThemeConfig.cfg");
    localObject = ((StringBuilder)localObject).toString();
    ThreadManager.getFileThreadHandler().post(new QzoneHbFragment.7(this, (String)localObject));
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QzoneHbFragment", 2, "complete---");
    }
    Message localMessage = this.F.obtainMessage();
    localMessage.what = 101;
    this.F.sendMessage(localMessage);
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == R.id.br)
    {
      if (isAdded())
      {
        try
        {
          ((InputMethodManager)getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.r.getWindowToken(), 0);
        }
        catch (Exception paramView)
        {
          paramView.printStackTrace();
        }
        this.f.cancelCallBack();
        this.f.finish();
        this.f.overridePendingTransition(0, 0);
        if (this.i != 32768) {
          this.f.addQZoneHbUploadData(300, "rewardhongbao.wrap.close", 2);
        }
      }
    }
    else
    {
      if (i == R.id.bq)
      {
        if (!this.t)
        {
          this.t = true;
          this.n.setText(HardCodeUtil.a(R.string.ak));
          this.m.setEnabled(true);
          this.m.setFocusable(true);
          this.m.setText("");
          if (this.i != 32768) {
            this.f.addQZoneHbUploadData(300, "rewardhongbao.wrap.custom", 2);
          }
          a(this.F, this.m);
          return;
        }
        this.t = false;
        this.m.setText(this.v);
        this.m.setEnabled(false);
        this.n.setText(HardCodeUtil.a(R.string.bX));
        this.m.setSelection(0);
        return;
      }
      if (i == R.id.ce)
      {
        long l1 = System.currentTimeMillis();
        if ((this.D != 0L) && (System.currentTimeMillis() - this.D < 1000L)) {
          return;
        }
        this.D = l1;
        paramView = this.m;
        if (paramView != null) {
          this.u = paramView.getText().toString();
        }
        paramView = this.f.getMapPacketExtra();
        paramView.put("total_num", "1");
        paramView.put("total_amount", QwUtils.b(this.u));
        paramView.put("wishing", "");
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.i);
        localStringBuilder.append("");
        paramView.put("channel", localStringBuilder.toString());
        paramView.put("feeds_name", this.y);
        paramView.put("feeds_sid", this.z);
        if (this.i == 32768)
        {
          if (!g())
          {
            paramView = new StringBuilder();
            paramView.append(this.H);
            paramView.append("");
            paramView = QwUtils.a(paramView.toString(), 0, true);
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(HardCodeUtil.a(R.string.bZ));
            localStringBuilder.append(paramView);
            localStringBuilder.append(HardCodeUtil.a(R.string.bY));
            paramView = localStringBuilder.toString();
            DialogUtil.a(getActivity(), 230, null, paramView, null, getString(R.string.w), new QzoneHbFragment.3(this), null).show();
            return;
          }
          if (this.A.equals("1"))
          {
            paramView.put("channel", String.valueOf(1));
            paramView.put("bus_type", "1");
          }
          else
          {
            paramView.put("channel", String.valueOf(1024));
          }
          paramView.put("type", String.valueOf(1));
        }
        this.h.a(paramView);
        this.f.overridePendingTransition(0, 0);
        if (this.i != 32768) {
          this.f.addQZoneHbUploadData(300, "rewardhongbao.wrap.send", 2);
        }
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.f.getWindow().setSoftInputMode(32);
    paramLayoutInflater = paramLayoutInflater.inflate(R.layout.r, null);
    a(paramLayoutInflater);
    f();
    e();
    c();
    i();
    if (this.i != 32768) {
      this.f.addQZoneHbUploadData(300, "rewardhongbao.wrap.show", 2);
    }
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    EditText localEditText = this.m;
    if (localEditText != null)
    {
      TextWatcher localTextWatcher = this.a;
      if (localTextWatcher != null)
      {
        localEditText.removeTextChangedListener(localTextWatcher);
        this.a = null;
      }
    }
    super.onDestroyView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.impl.QzoneHbFragment
 * JD-Core Version:    0.7.0.1
 */