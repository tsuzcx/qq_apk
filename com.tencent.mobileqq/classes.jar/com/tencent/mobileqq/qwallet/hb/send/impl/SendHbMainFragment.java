package com.tencent.mobileqq.qwallet.hb.send.impl;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.banner.TipsBar;
import com.tencent.mobileqq.qqpay.ui.R.color;
import com.tencent.mobileqq.qqpay.ui.R.drawable;
import com.tencent.mobileqq.qqpay.ui.R.id;
import com.tencent.mobileqq.qqpay.ui.R.layout;
import com.tencent.mobileqq.qqpay.ui.R.string;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.config.IQWalletConfigService;
import com.tencent.mobileqq.qwallet.hb.HbInfo;
import com.tencent.mobileqq.qwallet.hb.HbInfo.BundleInfo;
import com.tencent.mobileqq.qwallet.hb.IRedPacketManager;
import com.tencent.mobileqq.qwallet.hb.grap.draw.impl.DrawHbFragment;
import com.tencent.mobileqq.qwallet.hb.impl.RedPacketManagerImpl;
import com.tencent.mobileqq.qwallet.hb.send.PanelData;
import com.tencent.mobileqq.qwallet.hb.send.busylogic.impl.HbBusiUtils;
import com.tencent.mobileqq.qwallet.hb.send.view.impl.ViewPagerTabLayout;
import com.tencent.mobileqq.qwallet.impl.QWalletTools;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qwallet.QwUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONObject;

public class SendHbMainFragment
  extends BaseHbFragment
  implements View.OnClickListener
{
  public static final String a = HardCodeUtil.a(R.string.cM);
  private List<SendHbMainFragment.HbHolder> b = new ArrayList();
  private HbInfo.BundleInfo c = new HbInfo.BundleInfo();
  private ImageView d;
  private String l;
  private ViewPagerTabLayout m;
  
  private BaseHbFragment a(PanelData paramPanelData, Bundle paramBundle, boolean paramBoolean)
  {
    Bundle localBundle = new Bundle(paramBundle);
    int i = paramPanelData.b;
    localBundle.putString("panel_name", paramPanelData.c);
    Object localObject = RedPacketManagerImpl.TYPEHBINFOMAP.get(Integer.valueOf(i));
    paramBundle = null;
    if (localObject == null) {
      return null;
    }
    localBundle.putString("channel", String.valueOf(RedPacketManagerImpl.TYPEHBINFOMAP.get(Integer.valueOf(i))));
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 15) {
            if (i == 16) {}
          }
          switch (i)
          {
          default: 
            break;
          case 11: 
            if ((!paramBoolean) && (!HbInfo.e.contains(this.l))) {
              break;
            }
            paramBundle = new ExclusiveHbFragment();
            break;
          case 10: 
            if ((!paramBoolean) && (!RedPacketManagerImpl.verifyDrawHbParams(paramPanelData))) {
              break;
            }
            paramBundle = new DrawHbFragment();
            localBundle.putString("skinId", paramPanelData.h.optString("skinId"));
            localBundle.putString("drawParam", paramPanelData.h.optString("subjects"));
            localBundle.putString("recommend", paramPanelData.h.optString("recommend"));
            localBundle.putString("modelList", paramPanelData.h.optString("modelList"));
            break;
          case 9: 
            localObject = new WordChainHbFragment();
            paramBundle = (Bundle)localObject;
            if (paramPanelData.h == null) {
              break;
            }
            localBundle.putString("skinId", paramPanelData.h.optString("skinId"));
            paramBundle = (Bundle)localObject;
            break;
          case 8: 
            if ((!paramBoolean) && (!RedPacketManagerImpl.verifyEmojiHbParams(paramPanelData))) {
              break;
            }
            localObject = new EmojiFragment();
            localBundle.putString("prefix", paramPanelData.h.optString("prefix"));
            JSONArray localJSONArray = paramPanelData.h.optJSONArray("heartList");
            paramBundle = (Bundle)localObject;
            if (localJSONArray == null) {
              break;
            }
            localBundle.putString("heartList", localJSONArray.toString());
            paramBundle = (Bundle)localObject;
            break;
          case 7: 
            localObject = new KSongFragment();
            paramBundle = (Bundle)localObject;
            if (paramPanelData.h == null) {
              break;
            }
            localBundle.putString("pick_entry", paramPanelData.h.optString("pick_entry", "https://h5.qianbao.qq.com/ktvredpacket"));
            paramBundle = (Bundle)localObject;
            break;
            if ((!paramBoolean) && (!RedPacketManagerImpl.verifyShengpiziHbParams(paramPanelData))) {
              break;
            }
            paramBundle = new ShengpiziHbFragment();
            break;
            if ((!paramBoolean) && (!RedPacketManagerImpl.verifyKuaKuaHbParams(paramPanelData))) {
              break;
            }
            paramBundle = new KuaKuaHbFragment();
            break;
          }
        }
        else if ((paramBoolean) || (!HbInfo.f.contains(this.l)))
        {
          paramBundle = new LingHbFragment();
        }
      }
      else if ((paramBoolean) || (HbInfo.d.contains(this.l)))
      {
        paramBundle = new UsualHbFragment();
        localBundle.putString("bus_type", "2");
      }
    }
    else
    {
      paramBundle = new UsualHbFragment();
      localBundle.putString("bus_type", "1");
    }
    if (paramBundle != null)
    {
      paramBundle.setArguments(localBundle);
      return paramBundle;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("buildHbFragment...fragment is null,panelData:");
      ((StringBuilder)localObject).append(paramPanelData.toString());
      QLog.i("SendHbMainFragment", 2, ((StringBuilder)localObject).toString());
    }
    return paramBundle;
  }
  
  private String a(PanelData paramPanelData)
  {
    if ((paramPanelData != null) && (!TextUtils.isEmpty(paramPanelData.c)))
    {
      int i = paramPanelData.c.indexOf(a);
      if (i != -1) {
        paramPanelData = paramPanelData.c.substring(0, i);
      } else {
        paramPanelData = paramPanelData.c;
      }
    }
    else
    {
      paramPanelData = "";
    }
    Object localObject = paramPanelData;
    if (TextUtils.isEmpty(paramPanelData)) {
      localObject = a;
    }
    return localObject;
  }
  
  private void a(View paramView)
  {
    paramView = (TipsBar)paramView.findViewById(R.id.af);
    paramView.setVisibility(8);
    try
    {
      Object localObject1 = QWalletTools.b();
      if (localObject1 != null)
      {
        localObject1 = (IQWalletConfigService)((BaseQQAppInterface)localObject1).getRuntimeService(IQWalletConfigService.class, "");
        if ((localObject1 != null) && (((IQWalletConfigService)localObject1).getConfigObj("common") != null))
        {
          localObject1 = ((IQWalletConfigService)localObject1).getConfigObj("common");
          if (((JSONObject)localObject1).has("make_hb_bulletin"))
          {
            localObject1 = ((JSONObject)localObject1).getJSONObject("make_hb_bulletin");
            String str1 = ((JSONObject)localObject1).optString("content_text");
            Object localObject2 = ((JSONObject)localObject1).optString("begintime");
            String str2 = ((JSONObject)localObject1).optString("endtime");
            if (TextUtils.isEmpty(str1.trim())) {
              return;
            }
            if (!RedPacketManagerImpl.isBulletinValidDate((String)localObject2, str2))
            {
              if (!QLog.isColorLevel()) {
                return;
              }
              paramView = new StringBuilder();
              paramView.append("isBulletinValidDate:false,start_time:");
              paramView.append((String)localObject2);
              paramView.append(" end_time:");
              paramView.append(str2);
              QLog.w("SendHbMainFragment", 2, paramView.toString());
              return;
            }
            localObject2 = MobileQQ.sMobileQQ.getSharedPreferences("red_packet", 0);
            int i = ((JSONObject)localObject1).optInt("bulletin_id");
            if (i == ((SharedPreferences)localObject2).getInt("red_packet_bulletin", -1)) {
              return;
            }
            paramView.setBarType(2);
            paramView.setTipsIcon(getResources().getDrawable(R.drawable.a));
            if (paramView.getTipsIconView() != null) {
              paramView.getTipsIconView().setVisibility(0);
            }
            paramView.setVisibility(0);
            paramView.setTipsText(str1);
            paramView.setEnabled(true);
            paramView.setOnClickListener(new SendHbMainFragment.1(this, (JSONObject)localObject1));
            paramView.setCloseListener(new SendHbMainFragment.2(this, paramView, (SharedPreferences)localObject2, i));
            return;
          }
        }
      }
    }
    catch (Throwable paramView)
    {
      QLog.e("SendHbMainFragment", 1, paramView, new Object[0]);
    }
    return;
  }
  
  private void a(View paramView, Bundle paramBundle)
  {
    HbInfo.a(paramBundle, this.c);
    this.l = this.c.recv_type;
    this.d = ((ImageView)paramView.findViewById(R.id.aI));
    b(paramView);
    a(paramView, paramBundle.getString("hbTitle", getString(R.string.F)));
    if (!a(paramBundle))
    {
      QLog.i("SendHbMainFragment", 1, "initHbData failed...");
      QQToast.makeText(this.f, HardCodeUtil.a(R.string.cJ), 0).show();
      this.f.finish();
      return;
    }
    paramBundle = (ViewPager)paramView.findViewById(R.id.cZ);
    paramBundle.setOffscreenPageLimit(1);
    paramBundle.setAdapter(new SendHbMainFragment.3(this, getChildFragmentManager()));
    paramBundle.setCurrentItem(a(f()), false);
    this.m = ((ViewPagerTabLayout)paramView.findViewById(R.id.cq));
    this.m.setBoldStyle(1);
    this.m.setScrollOnTabClick(false);
    this.m.setViewPager(paramBundle);
    this.m.post(new SendHbMainFragment.4(this));
    a(paramView);
  }
  
  private boolean a(Bundle paramBundle)
  {
    int i = paramBundle.getInt("tabMask", 0);
    boolean bool = paramBundle.getBoolean("isFromPanel");
    this.b.clear();
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("initHbData... isFromPanel:");
      ((StringBuilder)localObject1).append(bool);
      ((StringBuilder)localObject1).append(" tabMask:");
      ((StringBuilder)localObject1).append(i);
      QLog.i("SendHbMainFragment", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject2;
    if (i != 0)
    {
      if ((i & 0x2) == 2)
      {
        localObject1 = new Bundle(paramBundle);
        ((Bundle)localObject1).putString("bus_type", "2");
        localObject2 = new UsualHbFragment();
        ((UsualHbFragment)localObject2).setArguments((Bundle)localObject1);
        localObject1 = new SendHbMainFragment.HbHolder(1, HardCodeUtil.a(R.string.cK), (BaseHbFragment)localObject2);
        this.b.add(localObject1);
      }
      if ((i & 0x1) == 1)
      {
        paramBundle = new Bundle(paramBundle);
        paramBundle.putString("bus_type", "1");
        localObject1 = new UsualHbFragment();
        ((UsualHbFragment)localObject1).setArguments(paramBundle);
        paramBundle = new SendHbMainFragment.HbHolder(0, HardCodeUtil.a(R.string.cL), (BaseHbFragment)localObject1);
        this.b.add(paramBundle);
      }
    }
    else
    {
      localObject1 = new ArrayList();
      if (bool)
      {
        if ((RedPacketManagerImpl.CURRENT_PANEL_DATA != null) && (RedPacketManagerImpl.CURRENT_PANEL_DATA.size() != 0))
        {
          ((List)localObject1).addAll(RedPacketManagerImpl.CURRENT_PANEL_DATA);
        }
        else
        {
          QLog.e("SendHbMainFragment", 1, "isFromPanel but cacheData isEmpty");
          ((List)localObject1).addAll(((IRedPacketManager)QRoute.api(IRedPacketManager.class)).getPanelList(null));
          bool = false;
        }
      }
      else {
        ((List)localObject1).addAll(((IRedPacketManager)QRoute.api(IRedPacketManager.class)).getPanelList(null));
      }
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (PanelData)((Iterator)localObject1).next();
        if (localObject2 != null) {
          try
          {
            if (!TextUtils.isEmpty(((PanelData)localObject2).c))
            {
              BaseHbFragment localBaseHbFragment = a((PanelData)localObject2, paramBundle, bool);
              if (localBaseHbFragment != null) {
                this.b.add(new SendHbMainFragment.HbHolder(((PanelData)localObject2).b, a((PanelData)localObject2), localBaseHbFragment));
              }
            }
          }
          catch (Throwable localThrowable)
          {
            QLog.e("SendHbMainFragment", 1, localThrowable, new Object[0]);
          }
        }
      }
    }
    return this.b.isEmpty() ^ true;
  }
  
  private void b(View paramView)
  {
    try
    {
      int i = ImmersiveUtils.isSupporImmersive();
      int j = ImmersiveUtils.getStatusBarHeight(this.f);
      if (i == 1)
      {
        paramView = paramView.findViewById(R.id.da);
        paramView.getLayoutParams().height = j;
        paramView.requestLayout();
        if (QLog.isColorLevel())
        {
          paramView = new StringBuilder();
          paramView.append("initImmersive:");
          paramView.append(i);
          paramView.append(" barHeight: ");
          paramView.append(j);
          QLog.i("SendHbMainFragment", 2, paramView.toString());
          return;
        }
      }
    }
    catch (Throwable paramView)
    {
      QLog.e("SendHbMainFragment", 1, paramView, new Object[0]);
    }
  }
  
  private int f()
  {
    return HbBusiUtils.a(this.i, QwUtils.a(this.e.getString("bus_type"), 2));
  }
  
  public int a(int paramInt)
  {
    Object localObject = this.b.iterator();
    while (((Iterator)localObject).hasNext())
    {
      SendHbMainFragment.HbHolder localHbHolder = (SendHbMainFragment.HbHolder)((Iterator)localObject).next();
      if (localHbHolder.a == paramInt)
      {
        i = this.b.indexOf(localHbHolder);
        break label56;
      }
    }
    int i = 0;
    label56:
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("findPositionByType, type:");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" pos:");
      ((StringBuilder)localObject).append(i);
      QLog.i("SendHbMainFragment", 2, ((StringBuilder)localObject).toString());
    }
    return i;
  }
  
  public void a(View paramView, String paramString)
  {
    paramView.findViewById(R.id.aD).setVisibility(4);
    ((TextView)paramView.findViewById(R.id.aE)).setText(paramString);
    paramView.findViewById(R.id.aB).setOnClickListener(this);
    paramView.findViewById(R.id.bW).setBackgroundColor(this.f.getResources().getColor(R.color.g));
    paramView = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[] { Color.parseColor("#FF6D6D"), Color.parseColor("#FF2151") });
    this.d.setBackgroundDrawable(paramView);
  }
  
  public void c()
  {
    int i = e();
    switch (i)
    {
    default: 
      break;
    case 11: 
      this.f.addHbUploadData("only.wrappacket.back");
      break;
    case 10: 
      this.f.addHbUploadData("draw.wrappacket.back");
      break;
    case 9: 
      this.f.addHbUploadData("idiom.wrappacket.back");
      break;
    case 8: 
      this.f.addHbUploadData("phiz.wrappacket.back");
      break;
    case 7: 
      this.f.addHbUploadData("ksong.wrappacket.back");
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reportHbBack,curType:");
      localStringBuilder.append(i);
      QLog.i("SendHbMainFragment", 2, localStringBuilder.toString());
    }
  }
  
  public BaseHbFragment d()
  {
    try
    {
      BaseHbFragment localBaseHbFragment = ((SendHbMainFragment.HbHolder)this.b.get(this.m.getCurrentTab())).c;
      return localBaseHbFragment;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("SendHbMainFragment", 1, localThrowable, new Object[0]);
    }
    return null;
  }
  
  public int e()
  {
    try
    {
      int i = ((SendHbMainFragment.HbHolder)this.b.get(this.m.getCurrentTab())).a;
      return i;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("SendHbMainFragment", 1, localThrowable, new Object[0]);
    }
    return 1;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    BaseHbFragment localBaseHbFragment = d();
    if (localBaseHbFragment != null) {
      localBaseHbFragment.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    if (QLog.isColorLevel())
    {
      paramIntent = new StringBuilder();
      paramIntent.append("onActivityResult, requestCode:");
      paramIntent.append(paramInt1);
      paramIntent.append(" resultCode:");
      paramIntent.append(paramInt2);
      paramIntent.append(" curFragment:");
      paramIntent.append(localBaseHbFragment);
      QLog.i("SendHbMainFragment", 2, paramIntent.toString());
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == R.id.aB)
    {
      c();
      this.f.cancelCallBack();
      this.f.finish();
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    paramLayoutInflater = paramLayoutInflater.inflate(R.layout.q, null);
    a(paramLayoutInflater, getArguments());
    return paramLayoutInflater;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.impl.SendHbMainFragment
 * JD-Core Version:    0.7.0.1
 */