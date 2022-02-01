package com.tencent.mobileqq.qwallet.hb.send.impl;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.qwallet.temp.IFriendsManager;
import com.qwallet.temp.IQWalletTemp;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.qqpay.ui.R.color;
import com.tencent.mobileqq.qqpay.ui.R.drawable;
import com.tencent.mobileqq.qqpay.ui.R.id;
import com.tencent.mobileqq.qqpay.ui.R.layout;
import com.tencent.mobileqq.qqpay.ui.R.string;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.hb.HbInfo;
import com.tencent.mobileqq.qwallet.hb.HbInfo.BundleInfo;
import com.tencent.mobileqq.qwallet.hb.send.busylogic.impl.HbBusiUtils;
import com.tencent.mobileqq.qwallet.hb.send.busylogic.impl.MoneyWatcher;
import com.tencent.mobileqq.qwallet.hb.send.busylogic.impl.SendHbLogic;
import com.tencent.mobileqq.qwallet.impl.QWalletTools;
import com.tencent.mobileqq.qwallet.report.impl.ReportUtils;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.troop.util.api.ITroopDBUtilsApi;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.QwUtils;
import java.util.ArrayList;
import java.util.ArrayList<Ljava.util.ArrayList<Ljava.lang.String;>;>;
import java.util.Iterator;
import java.util.Map;

public class ExclusiveHbFragment
  extends BaseHbFragment
  implements View.OnClickListener
{
  protected TextWatcher a = new ExclusiveHbFragment.1(this);
  private Button b;
  private EditText c;
  private EditText d;
  private HbInfo.BundleInfo l = new HbInfo.BundleInfo();
  private int m;
  private TextView n;
  private LinearLayout o;
  private ArrayList<String> p = new ArrayList();
  private String q;
  private String r;
  private String s = "";
  private int t;
  private long u;
  
  private ArrayList<ArrayList<String>> a(Intent paramIntent)
  {
    if (this.f == null) {
      return null;
    }
    ArrayList localArrayList1 = new ArrayList();
    try
    {
      BaseQQAppInterface localBaseQQAppInterface = (BaseQQAppInterface)this.f.getAppRuntime();
      ArrayList localArrayList2 = new ArrayList();
      ArrayList localArrayList3 = new ArrayList();
      if (paramIntent == null) {
        return localArrayList1;
      }
      Object localObject1 = paramIntent.getParcelableArrayListExtra("result_set");
      if (localObject1 != null)
      {
        paramIntent = (IFriendsManager)localBaseQQAppInterface.getRuntimeService(IFriendsManager.class);
        localObject1 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          ResultRecord localResultRecord = (ResultRecord)((Iterator)localObject1).next();
          if (!TextUtils.isEmpty(localResultRecord.uin))
          {
            localArrayList2.add(localResultRecord.uin);
            if (TextUtils.isEmpty(localResultRecord.name))
            {
              Object localObject2;
              if (this.q.equals("1"))
              {
                localObject2 = paramIntent.findFriendEntityByUin(localResultRecord.uin);
                if (localObject2 != null) {
                  localResultRecord.name = ((Friends)localObject2).getFriendNick();
                }
              }
              else if (this.q.equals("2"))
              {
                localObject2 = ((IQWalletTemp)QRoute.api(IQWalletTemp.class)).DiscussionManager$getDiscussMemberName(localBaseQQAppInterface, this.r, localResultRecord.uin);
                if (localObject2 != null) {
                  localResultRecord.name = ((String)localObject2);
                }
              }
              else if (this.q.equals("3"))
              {
                localObject2 = ((ITroopDBUtilsApi)QRoute.api(ITroopDBUtilsApi.class)).getTroopMemberInfo(localBaseQQAppInterface, this.r, localResultRecord.uin);
                if (localObject2 != null) {
                  if (!TextUtils.isEmpty(((TroopMemberInfo)localObject2).autoremark)) {
                    localResultRecord.name = ((TroopMemberInfo)localObject2).autoremark;
                  } else if (!TextUtils.isEmpty(((TroopMemberInfo)localObject2).troopnick)) {
                    localResultRecord.name = ((TroopMemberInfo)localObject2).troopnick;
                  } else if (!TextUtils.isEmpty(((TroopMemberInfo)localObject2).friendnick)) {
                    localResultRecord.name = ((TroopMemberInfo)localObject2).friendnick;
                  } else {
                    localResultRecord.name = ((TroopMemberInfo)localObject2).memberuin;
                  }
                }
              }
            }
            if (!TextUtils.isEmpty(localResultRecord.name)) {
              localArrayList3.add(localResultRecord.name);
            }
          }
        }
      }
      localArrayList1.add(localArrayList2);
      localArrayList1.add(localArrayList3);
      return localArrayList1;
    }
    catch (Throwable paramIntent)
    {
      QLog.e("ExclusiveHbFragment", 1, paramIntent, new Object[0]);
    }
    return localArrayList1;
  }
  
  private void a(View paramView, Bundle paramBundle)
  {
    HbInfo.a(paramBundle, this.l);
    this.q = this.l.recv_type;
    this.r = paramBundle.getString("recv_uin");
    this.c = ((EditText)paramView.findViewById(R.id.b));
    this.c.addTextChangedListener(this.a);
    paramBundle = this.c;
    paramBundle.addTextChangedListener(new MoneyWatcher(paramBundle));
    this.b = ((Button)paramView.findViewById(R.id.o));
    this.d = ((EditText)paramView.findViewById(R.id.I));
    this.n = ((TextView)paramView.findViewById(R.id.cL));
    this.n.setOnClickListener(this);
    this.o = ((LinearLayout)paramView.findViewById(R.id.aU));
    this.o.setOnClickListener(this);
    this.b.setOnClickListener(this);
    this.d.setHint(HbBusiUtils.a(this.i, this.l, this.f.getConfigLogic(), HardCodeUtil.a(R.string.aP)));
    paramView.findViewById(R.id.aH).setOnClickListener(this);
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder();
      paramView.append("bizParams:");
      paramView.append(this.l.biz_params);
      QLog.i("ExclusiveHbFragment", 2, paramView.toString());
    }
  }
  
  private void a(boolean paramBoolean)
  {
    this.b.setEnabled(paramBoolean);
    if (!paramBoolean) {
      this.b.setText(getString(R.string.I));
    }
  }
  
  private String b(ArrayList<String> paramArrayList)
  {
    if (paramArrayList == null) {
      return "";
    }
    StringBuffer localStringBuffer = new StringBuffer();
    int j = paramArrayList.size();
    int i = 0;
    while (i < j)
    {
      try
      {
        localStringBuffer.append((String)paramArrayList.get(i));
        if (i != j - 1) {
          localStringBuffer.append("|");
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  private void d()
  {
    this.m = 2;
    e();
    h();
  }
  
  private void e()
  {
    int i;
    if (this.m == 1) {
      i = R.drawable.B;
    } else {
      i = R.drawable.A;
    }
    this.n.setCompoundDrawablesWithIntrinsicBounds(0, 0, i, 0);
    Object localObject = this.n;
    if (this.m == 1) {
      i = R.string.H;
    } else {
      i = R.string.G;
    }
    ((TextView)localObject).setText(i);
    TextView localTextView = this.n;
    if (this.m == 1)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(HardCodeUtil.a(R.string.aS));
      i = R.string.H;
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(HardCodeUtil.a(R.string.aK));
      i = R.string.G;
    }
    ((StringBuilder)localObject).append(getString(i));
    localTextView.setContentDescription(((StringBuilder)localObject).toString());
    g();
  }
  
  private void f()
  {
    long l1 = System.currentTimeMillis();
    if (this.u + 1000L > l1) {
      return;
    }
    this.u = l1;
    Map localMap = this.f.getMapPacketExtra();
    try
    {
      Object localObject = b(this.p);
      if ((!this.p.isEmpty()) && (!TextUtils.isEmpty((CharSequence)localObject)))
      {
        localMap.put("grab_uin_list", localObject);
        this.s = String.valueOf(c());
        a(this.l, this.i, this.t, QwUtils.b(this.s), "only.wrappacket.wrap");
        localMap.put("type", String.valueOf(1));
        localMap.put("wishing", HbBusiUtils.a(this.d));
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.m);
        ((StringBuilder)localObject).append("");
        localMap.put("bus_type", ((StringBuilder)localObject).toString());
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.t);
        ((StringBuilder)localObject).append("");
        localMap.put("total_num", ((StringBuilder)localObject).toString());
        localMap.put("total_amount", QwUtils.b(this.s));
        localMap.put("channel", String.valueOf(this.i));
        this.h.a(localMap);
        ReportUtils.a(this.g, "redpack.paybtn.click", null, this.l.panel_name);
        return;
      }
      this.f.showCommonHbToast(HardCodeUtil.a(R.string.aO));
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ExclusiveHbFragment", 1, localException, new Object[0]);
    }
  }
  
  private void g()
  {
    if ((!this.p.isEmpty()) && (!TextUtils.isEmpty(this.c.getText().toString())))
    {
      float f = c();
      if (f <= 0.0F)
      {
        a(false);
        return;
      }
      this.s = String.valueOf(f);
      a(true);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(getString(R.string.I));
      ((StringBuilder)localObject).append(this.s);
      ((StringBuilder)localObject).append(HardCodeUtil.a(R.string.aN));
      localObject = ((StringBuilder)localObject).toString();
      this.b.setText((CharSequence)localObject);
      return;
    }
    a(false);
  }
  
  private void h()
  {
    this.p.clear();
    this.o.removeAllViews();
    this.o.setContentDescription(HardCodeUtil.a(R.string.aL));
    TextView localTextView = new TextView(getActivity());
    localTextView.setText(HardCodeUtil.a(R.string.aM));
    localTextView.setSingleLine();
    localTextView.setTextSize(15.0F);
    localTextView.setTextColor(getActivity().getResources().getColor(R.color.f));
    QWalletTools.a(this.o, 0.6F);
    this.o.addView(localTextView);
    g();
  }
  
  public void a(ArrayList<ArrayList<String>> paramArrayList)
  {
    if (!isDetached())
    {
      if (this.o == null) {
        return;
      }
      Object localObject2 = null;
      int j = 0;
      Object localObject1;
      if ((paramArrayList != null) && (paramArrayList.size() > 1))
      {
        localObject1 = (ArrayList)paramArrayList.get(0);
        localObject2 = (ArrayList)paramArrayList.get(1);
        paramArrayList = (ArrayList<ArrayList<String>>)localObject1;
        localObject1 = localObject2;
      }
      else
      {
        localObject1 = null;
        paramArrayList = (ArrayList<ArrayList<String>>)localObject2;
      }
      if ((paramArrayList != null) && (paramArrayList.size() > 0))
      {
        this.p.clear();
        this.p.addAll(paramArrayList);
        this.o.removeAllViews();
        int k = paramArrayList.size();
        localObject2 = new StringBuffer();
        int i = 0;
        while (i < k)
        {
          try
          {
            String str = (String)paramArrayList.get(i);
            ImageView localImageView = new ImageView(getActivity());
            LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(ViewUtils.dpToPx(32.0F), ViewUtils.dpToPx(32.0F));
            localLayoutParams.setMargins(-ViewUtils.dip2px(5.0F), 0, 0, 0);
            localImageView.setLayoutParams(localLayoutParams);
            localImageView.setImageDrawable(FaceDrawable.getFaceDrawable((BaseQQAppInterface)getQBaseActivity().getAppRuntime(), 1, str));
            this.o.addView(localImageView);
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
          }
          i += 1;
        }
        if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
        {
          i = j;
          while (i < ((ArrayList)localObject1).size())
          {
            if (!TextUtils.isEmpty((CharSequence)((ArrayList)localObject1).get(i))) {
              ((StringBuffer)localObject2).append((String)((ArrayList)localObject1).get(i));
            }
            ((StringBuffer)localObject2).append(" ,");
            i += 1;
          }
        }
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          paramArrayList = this.o;
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(HardCodeUtil.a(R.string.aR));
          ((StringBuilder)localObject1).append(k);
          ((StringBuilder)localObject1).append(HardCodeUtil.a(R.string.aQ));
          ((StringBuilder)localObject1).append(((StringBuffer)localObject2).toString());
          paramArrayList.setContentDescription(((StringBuilder)localObject1).toString());
        }
        g();
        return;
      }
      h();
    }
  }
  
  protected float c()
  {
    this.t = this.p.size();
    float f = QwUtils.a(this.c.getText().toString());
    if (this.m == 1) {
      return this.t * f;
    }
    return f;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 1024) && (paramInt2 == -1) && (paramIntent != null)) {
      a(a(paramIntent));
    }
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == R.id.o)
    {
      this.f.addHbUploadData("only.wrappacket.wrap");
      f();
      return;
    }
    if (i == R.id.cL)
    {
      if (this.m == 1) {
        this.m = 2;
      } else {
        this.m = 1;
      }
      e();
      return;
    }
    if ((i == R.id.aH) || (i == R.id.aU))
    {
      long l1 = System.currentTimeMillis();
      if (this.u + 1200L > l1) {
        return;
      }
      this.u = l1;
      this.f.callForwardPage(this.l.recv_type, this.p);
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    paramLayoutInflater = paramLayoutInflater.inflate(R.layout.l, null);
    a(paramLayoutInflater, getArguments());
    d();
    return paramLayoutInflater;
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    if (paramBoolean)
    {
      QLog.i("ExclusiveHbFragment", 2, "ExclusiveHb enter...");
      if (this.f != null) {
        this.f.addHbUploadData("only.wrappacket.show");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.impl.ExclusiveHbFragment
 * JD-Core Version:    0.7.0.1
 */