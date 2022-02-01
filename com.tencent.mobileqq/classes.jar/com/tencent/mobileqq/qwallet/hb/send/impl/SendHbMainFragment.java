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
  public static final String a;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private HbInfo.BundleInfo jdField_a_of_type_ComTencentMobileqqQwalletHbHbInfo$BundleInfo = new HbInfo.BundleInfo();
  private ViewPagerTabLayout jdField_a_of_type_ComTencentMobileqqQwalletHbSendViewImplViewPagerTabLayout;
  private List<SendHbMainFragment.HbHolder> jdField_a_of_type_JavaUtilList = new ArrayList();
  private String b;
  
  static
  {
    jdField_a_of_type_JavaLangString = HardCodeUtil.a(R.string.cJ);
  }
  
  private BaseHbFragment a(PanelData paramPanelData, Bundle paramBundle, boolean paramBoolean)
  {
    Bundle localBundle = new Bundle(paramBundle);
    int i = paramPanelData.jdField_a_of_type_Int;
    localBundle.putString("panel_name", paramPanelData.b);
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
            if ((!paramBoolean) && (!HbInfo.e.contains(this.b))) {
              break;
            }
            paramBundle = new ExclusiveHbFragment();
            break;
          case 10: 
            if ((!paramBoolean) && (!RedPacketManagerImpl.verifyDrawHbParams(paramPanelData))) {
              break;
            }
            paramBundle = new DrawHbFragment();
            localBundle.putString("skinId", paramPanelData.jdField_a_of_type_OrgJsonJSONObject.optString("skinId"));
            localBundle.putString("drawParam", paramPanelData.jdField_a_of_type_OrgJsonJSONObject.optString("subjects"));
            localBundle.putString("recommend", paramPanelData.jdField_a_of_type_OrgJsonJSONObject.optString("recommend"));
            localBundle.putString("modelList", paramPanelData.jdField_a_of_type_OrgJsonJSONObject.optString("modelList"));
            break;
          case 9: 
            localObject = new WordChainHbFragment();
            paramBundle = (Bundle)localObject;
            if (paramPanelData.jdField_a_of_type_OrgJsonJSONObject == null) {
              break;
            }
            localBundle.putString("skinId", paramPanelData.jdField_a_of_type_OrgJsonJSONObject.optString("skinId"));
            paramBundle = (Bundle)localObject;
            break;
          case 8: 
            if ((!paramBoolean) && (!RedPacketManagerImpl.verifyEmojiHbParams(paramPanelData))) {
              break;
            }
            localObject = new EmojiFragment();
            localBundle.putString("prefix", paramPanelData.jdField_a_of_type_OrgJsonJSONObject.optString("prefix"));
            JSONArray localJSONArray = paramPanelData.jdField_a_of_type_OrgJsonJSONObject.optJSONArray("heartList");
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
            if (paramPanelData.jdField_a_of_type_OrgJsonJSONObject == null) {
              break;
            }
            localBundle.putString("pick_entry", paramPanelData.jdField_a_of_type_OrgJsonJSONObject.optString("pick_entry", "https://h5.qianbao.qq.com/ktvredpacket"));
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
        else if ((paramBoolean) || (!HbInfo.f.contains(this.b)))
        {
          paramBundle = new LingHbFragment();
        }
      }
      else if ((paramBoolean) || (HbInfo.d.contains(this.b)))
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
    if ((paramPanelData != null) && (!TextUtils.isEmpty(paramPanelData.b)))
    {
      int i = paramPanelData.b.indexOf(jdField_a_of_type_JavaLangString);
      if (i != -1) {
        paramPanelData = paramPanelData.b.substring(0, i);
      } else {
        paramPanelData = paramPanelData.b;
      }
    }
    else
    {
      paramPanelData = "";
    }
    Object localObject = paramPanelData;
    if (TextUtils.isEmpty(paramPanelData)) {
      localObject = jdField_a_of_type_JavaLangString;
    }
    return localObject;
  }
  
  private void a(View paramView)
  {
    paramView = (TipsBar)paramView.findViewById(R.id.aa);
    paramView.setVisibility(8);
    try
    {
      Object localObject1 = QWalletTools.a();
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
            paramView.setTipsIcon(getResources().getDrawable(R.drawable.jdField_a_of_type_Int));
            if (paramView.b() != null) {
              paramView.b().setVisibility(0);
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
    HbInfo.a(paramBundle, this.jdField_a_of_type_ComTencentMobileqqQwalletHbHbInfo$BundleInfo);
    this.b = this.jdField_a_of_type_ComTencentMobileqqQwalletHbHbInfo$BundleInfo.recv_type;
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(R.id.aA));
    b(paramView);
    a(paramView, paramBundle.getString("hbTitle", getString(R.string.F)));
    if (!a(paramBundle))
    {
      QLog.i("SendHbMainFragment", 1, "initHbData failed...");
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplSendHbActivity, HardCodeUtil.a(R.string.cG), 0).a();
      this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplSendHbActivity.finish();
      return;
    }
    paramBundle = (ViewPager)paramView.findViewById(R.id.cI);
    paramBundle.setOffscreenPageLimit(1);
    paramBundle.setAdapter(new SendHbMainFragment.3(this, getChildFragmentManager()));
    paramBundle.setCurrentItem(a(c()), false);
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendViewImplViewPagerTabLayout = ((ViewPagerTabLayout)paramView.findViewById(R.id.cc));
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendViewImplViewPagerTabLayout.setBoldStyle(1);
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendViewImplViewPagerTabLayout.setScrollOnTabClick(false);
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendViewImplViewPagerTabLayout.setViewPager(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendViewImplViewPagerTabLayout.post(new SendHbMainFragment.4(this));
    a(paramView);
  }
  
  private boolean a(Bundle paramBundle)
  {
    int i = paramBundle.getInt("tabMask", 0);
    boolean bool = paramBundle.getBoolean("isFromPanel");
    this.jdField_a_of_type_JavaUtilList.clear();
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
        localObject1 = new SendHbMainFragment.HbHolder(1, HardCodeUtil.a(R.string.cH), (BaseHbFragment)localObject2);
        this.jdField_a_of_type_JavaUtilList.add(localObject1);
      }
      if ((i & 0x1) == 1)
      {
        paramBundle = new Bundle(paramBundle);
        paramBundle.putString("bus_type", "1");
        localObject1 = new UsualHbFragment();
        ((UsualHbFragment)localObject1).setArguments(paramBundle);
        paramBundle = new SendHbMainFragment.HbHolder(0, HardCodeUtil.a(R.string.cI), (BaseHbFragment)localObject1);
        this.jdField_a_of_type_JavaUtilList.add(paramBundle);
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
            if (!TextUtils.isEmpty(((PanelData)localObject2).b))
            {
              BaseHbFragment localBaseHbFragment = a((PanelData)localObject2, paramBundle, bool);
              if (localBaseHbFragment != null) {
                this.jdField_a_of_type_JavaUtilList.add(new SendHbMainFragment.HbHolder(((PanelData)localObject2).jdField_a_of_type_Int, a((PanelData)localObject2), localBaseHbFragment));
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
    return this.jdField_a_of_type_JavaUtilList.isEmpty() ^ true;
  }
  
  private void b(View paramView)
  {
    try
    {
      int i = ImmersiveUtils.isSupporImmersive();
      int j = ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplSendHbActivity);
      if (i == 1)
      {
        paramView = paramView.findViewById(R.id.cJ);
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
  
  private int c()
  {
    return HbBusiUtils.a(this.jdField_a_of_type_Int, QwUtils.a(this.jdField_a_of_type_AndroidOsBundle.getString("bus_type"), 2));
  }
  
  public int a(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      SendHbMainFragment.HbHolder localHbHolder = (SendHbMainFragment.HbHolder)((Iterator)localObject).next();
      if (localHbHolder.jdField_a_of_type_Int == paramInt)
      {
        i = this.jdField_a_of_type_JavaUtilList.indexOf(localHbHolder);
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
  
  public BaseHbFragment a()
  {
    try
    {
      BaseHbFragment localBaseHbFragment = ((SendHbMainFragment.HbHolder)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendViewImplViewPagerTabLayout.a())).jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplBaseHbFragment;
      return localBaseHbFragment;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("SendHbMainFragment", 1, localThrowable, new Object[0]);
    }
    return null;
  }
  
  public void a(View paramView, String paramString)
  {
    paramView.findViewById(R.id.av).setVisibility(4);
    ((TextView)paramView.findViewById(R.id.aw)).setText(paramString);
    paramView.findViewById(R.id.at).setOnClickListener(this);
    paramView.findViewById(R.id.bK).setBackgroundColor(this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplSendHbActivity.getResources().getColor(R.color.g));
    paramView = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[] { Color.parseColor("#FF6D6D"), Color.parseColor("#FF2151") });
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(paramView);
  }
  
  public int b()
  {
    try
    {
      int i = ((SendHbMainFragment.HbHolder)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendViewImplViewPagerTabLayout.a())).jdField_a_of_type_Int;
      return i;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("SendHbMainFragment", 1, localThrowable, new Object[0]);
    }
    return 1;
  }
  
  public void b()
  {
    int i = b();
    switch (i)
    {
    default: 
      break;
    case 11: 
      this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplSendHbActivity.addHbUploadData("only.wrappacket.back");
      break;
    case 10: 
      this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplSendHbActivity.addHbUploadData("draw.wrappacket.back");
      break;
    case 9: 
      this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplSendHbActivity.addHbUploadData("idiom.wrappacket.back");
      break;
    case 8: 
      this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplSendHbActivity.addHbUploadData("phiz.wrappacket.back");
      break;
    case 7: 
      this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplSendHbActivity.addHbUploadData("ksong.wrappacket.back");
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reportHbBack,curType:");
      localStringBuilder.append(i);
      QLog.i("SendHbMainFragment", 2, localStringBuilder.toString());
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    BaseHbFragment localBaseHbFragment = a();
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
    if (paramView.getId() == R.id.at)
    {
      b();
      this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplSendHbActivity.cancelCallBack();
      this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplSendHbActivity.finish();
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    paramLayoutInflater = paramLayoutInflater.inflate(R.layout.n, null);
    a(paramLayoutInflater, getArguments());
    return paramLayoutInflater;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.impl.SendHbMainFragment
 * JD-Core Version:    0.7.0.1
 */