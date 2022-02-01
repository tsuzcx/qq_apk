package cooperation.vip.ad;

import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.recent.bannerprocessor.RenewalsBannerProcessor;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.redtouch.VipBannerInfo;
import com.tencent.mobileqq.tianshu.data.TianShuAdPosItemData;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.pb.TianShuAccess.AdItem;
import cooperation.vip.pb.TianShuAccess.AdPlacementInfo;
import cooperation.vip.pb.TianShuAccess.GetAdsRsp;
import cooperation.vip.pb.TianShuAccess.MapEntry;
import cooperation.vip.pb.TianShuAccess.RspEntry;
import cooperation.vip.tianshu.TianShuManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class TianshuRenewalsBarManager
{
  private Conversation a;
  
  public TianshuRenewalsBarManager(Conversation paramConversation)
  {
    this.a = paramConversation;
  }
  
  private static List<TianShuAdPosItemData> a()
  {
    ArrayList localArrayList = new ArrayList();
    TianShuAdPosItemData localTianShuAdPosItemData = new TianShuAdPosItemData();
    localTianShuAdPosItemData.b = 1;
    localTianShuAdPosItemData.a = 596;
    localArrayList.add(localTianShuAdPosItemData);
    return localArrayList;
  }
  
  private static void a(Resources paramResources, TextView paramTextView, FrameLayout paramFrameLayout, URLImageView paramURLImageView)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      paramFrameLayout.setBackground(paramResources.getDrawable(2130839393));
    }
    paramURLImageView.setVisibility(8);
    paramTextView.setTextColor(paramResources.getColorStateList(2131167063));
  }
  
  public static void a(BaseActivity paramBaseActivity, View paramView, VipBannerInfo paramVipBannerInfo, boolean paramBoolean)
  {
    if (a(paramBaseActivity, paramView, paramVipBannerInfo)) {
      return;
    }
    Object localObject1 = (TextView)paramView.findViewById(2131376410);
    Object localObject2 = paramVipBannerInfo.c;
    if ((localObject1 != null) && (!TextUtils.isEmpty((CharSequence)localObject2))) {
      ((TextView)localObject1).setText((CharSequence)localObject2);
    }
    localObject1 = (URLImageView)paramView.findViewById(2131376409);
    if ((localObject1 != null) && (!TextUtils.isEmpty(paramVipBannerInfo.e)))
    {
      localObject2 = URLDrawable.getDrawable(paramVipBannerInfo.e);
      if (localObject2 != null) {
        ((URLImageView)localObject1).setImageDrawable((Drawable)localObject2);
      }
    }
    localObject1 = (TextView)paramView.findViewById(2131376406);
    if ((localObject1 != null) && (!TextUtils.isEmpty(paramVipBannerInfo.f))) {
      ((TextView)localObject1).setText(paramVipBannerInfo.f);
    }
    paramView.setVisibility(0);
    TianshuReportUtils.a(paramVipBannerInfo.a, 101);
    localObject1 = new TianshuRenewalsBarManager.1(paramVipBannerInfo);
    localObject2 = new TianshuRenewalsBarManager.2(paramVipBannerInfo, paramBaseActivity);
    FrameLayout localFrameLayout = (FrameLayout)paramView.findViewById(2131376404);
    if (localFrameLayout != null) {
      localFrameLayout.setOnClickListener((View.OnClickListener)localObject2);
    }
    localObject2 = (Button)paramView.findViewById(2131376408);
    if (localObject2 != null) {
      ((Button)localObject2).setOnClickListener((View.OnClickListener)localObject1);
    }
    b(paramBaseActivity, paramView, paramVipBannerInfo, paramBoolean);
  }
  
  private static void a(VipBannerInfo paramVipBannerInfo, Resources paramResources, TextView paramTextView, URLImageView paramURLImageView)
  {
    URLDrawable localURLDrawable = URLDrawable.getDrawable(paramVipBannerInfo.g);
    if (localURLDrawable != null)
    {
      paramURLImageView.setImageDrawable(localURLDrawable);
      paramURLImageView.setVisibility(0);
    }
    if (!TextUtils.isEmpty(paramVipBannerInfo.i)) {
      try
      {
        paramTextView.setTextColor(Color.parseColor(paramVipBannerInfo.i));
        return;
      }
      catch (Exception paramVipBannerInfo)
      {
        QLog.e("TianshuRenewalsBarManager", 1, paramVipBannerInfo, new Object[0]);
        return;
      }
    }
    paramTextView.setTextColor(paramResources.getColorStateList(2131167063));
  }
  
  private static void a(VipBannerInfo paramVipBannerInfo, QQAppInterface paramQQAppInterface, View paramView)
  {
    if ((paramQQAppInterface != null) && (paramView != null))
    {
      if (paramVipBannerInfo == null) {
        return;
      }
      URLImageView localURLImageView = (URLImageView)paramView.findViewById(2131376407);
      paramView = (TextView)paramView.findViewById(2131376406);
      if (localURLImageView != null)
      {
        if (paramView == null) {
          return;
        }
        localURLImageView.setVisibility(8);
        if (ThemeUtil.isInNightMode(paramQQAppInterface))
        {
          paramVipBannerInfo = "#FDC256";
        }
        else
        {
          if (!TextUtils.isEmpty(paramVipBannerInfo.h))
          {
            paramQQAppInterface = URLDrawable.getDrawable(paramVipBannerInfo.h);
            if (paramQQAppInterface != null)
            {
              localURLImageView.setImageDrawable(paramQQAppInterface);
              localURLImageView.setVisibility(0);
            }
          }
          if (!TextUtils.isEmpty(paramVipBannerInfo.j)) {
            paramVipBannerInfo = paramVipBannerInfo.j;
          } else {
            paramVipBannerInfo = "#4B94EA";
          }
        }
        if (!TextUtils.isEmpty(paramVipBannerInfo)) {
          try
          {
            paramView.setTextColor(Color.parseColor(paramVipBannerInfo));
            return;
          }
          catch (Exception paramVipBannerInfo)
          {
            QLog.e("TianshuRenewalsBarManager", 1, paramVipBannerInfo, new Object[0]);
          }
        }
      }
    }
  }
  
  private static void a(VipBannerInfo paramVipBannerInfo, boolean paramBoolean, QQAppInterface paramQQAppInterface, Resources paramResources, View paramView)
  {
    if ((paramQQAppInterface != null) && (paramVipBannerInfo != null) && (paramResources != null))
    {
      if (paramView == null) {
        return;
      }
      TextView localTextView = (TextView)paramView.findViewById(2131376410);
      FrameLayout localFrameLayout = (FrameLayout)paramView.findViewById(2131376404);
      paramView = (URLImageView)paramView.findViewById(2131376405);
      if ((localTextView != null) && (localFrameLayout != null))
      {
        if (paramView == null) {
          return;
        }
        if (ThemeUtil.isInNightMode(paramQQAppInterface))
        {
          a(paramResources, localTextView, localFrameLayout, paramView);
          return;
        }
        if (!TextUtils.isEmpty(paramVipBannerInfo.g))
        {
          a(paramVipBannerInfo, paramResources, localTextView, paramView);
          return;
        }
        a(paramBoolean, paramResources, localTextView, localFrameLayout, paramView);
      }
    }
  }
  
  private void a(TianShuAccess.GetAdsRsp paramGetAdsRsp, String paramString)
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      if (((Conversation)localObject).a == null) {
        return;
      }
      int i;
      if (BannerManager.a().a(RenewalsBannerProcessor.a) == 2) {
        i = 1;
      } else {
        i = 0;
      }
      if ((i != 0) && ("tianshu_req_renewals_type_pull_down".equals(paramString)))
      {
        BannerManager.a().b(RenewalsBannerProcessor.a, 2001);
        return;
      }
      if (paramGetAdsRsp.mapAds.has()) {
        paramGetAdsRsp = paramGetAdsRsp.mapAds.get();
      } else {
        paramGetAdsRsp = null;
      }
      if (paramGetAdsRsp == null) {
        return;
      }
      paramString = new HashMap();
      paramGetAdsRsp = paramGetAdsRsp.iterator();
      while (paramGetAdsRsp.hasNext())
      {
        localObject = (TianShuAccess.RspEntry)paramGetAdsRsp.next();
        if ((localObject != null) && (((TianShuAccess.RspEntry)localObject).key.has())) {
          paramString.put(Integer.valueOf(((TianShuAccess.RspEntry)localObject).key.get()), localObject);
        }
      }
      a((TianShuAccess.RspEntry)paramString.get(Integer.valueOf(596)));
    }
  }
  
  private void a(TianShuAccess.RspEntry paramRspEntry)
  {
    if ((paramRspEntry != null) && (paramRspEntry.value != null))
    {
      if (paramRspEntry.value.lst.size() < 1) {
        return;
      }
      paramRspEntry = (TianShuAccess.AdItem)paramRspEntry.value.lst.get(0);
      if (paramRspEntry == null) {
        return;
      }
      a(this.a, paramRspEntry);
    }
  }
  
  private static void a(boolean paramBoolean, Resources paramResources, TextView paramTextView, FrameLayout paramFrameLayout, URLImageView paramURLImageView)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      if ((paramBoolean) && ((ThemeUtil.isDefaultTheme()) || (ThemeUtil.isSimpleDayTheme(false)))) {
        paramFrameLayout.setBackground(paramResources.getDrawable(2130839394));
      } else {
        paramFrameLayout.setBackground(paramResources.getDrawable(2130839393));
      }
    }
    paramURLImageView.setVisibility(8);
    paramTextView.setTextColor(paramResources.getColorStateList(2131167063));
  }
  
  private static boolean a(BaseActivity paramBaseActivity, View paramView, VipBannerInfo paramVipBannerInfo)
  {
    return (paramBaseActivity == null) || (paramView == null) || (paramVipBannerInfo == null);
  }
  
  public static void b(BaseActivity paramBaseActivity, View paramView, VipBannerInfo paramVipBannerInfo, boolean paramBoolean)
  {
    if ((paramView != null) && (paramVipBannerInfo != null))
    {
      if (paramBaseActivity == null) {
        return;
      }
      if (paramView.getVisibility() != 0) {
        return;
      }
      QQAppInterface localQQAppInterface = (QQAppInterface)paramBaseActivity.getAppRuntime();
      a(paramVipBannerInfo, paramBoolean, localQQAppInterface, paramBaseActivity.getResources(), paramView);
      a(paramVipBannerInfo, localQQAppInterface, paramView);
    }
  }
  
  public void a()
  {
    this.a = null;
  }
  
  public void a(Conversation paramConversation, TianShuAccess.AdItem paramAdItem)
  {
    if (paramAdItem != null)
    {
      if (paramAdItem.argList.size() < 1) {
        return;
      }
      paramConversation = new HashMap();
      Object localObject1 = paramAdItem.argList.get().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (TianShuAccess.MapEntry)((Iterator)localObject1).next();
        paramConversation.put(((TianShuAccess.MapEntry)localObject2).key.get(), ((TianShuAccess.MapEntry)localObject2).value.get());
      }
      localObject1 = new VipBannerInfo();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramAdItem.iAdId.get());
      ((StringBuilder)localObject2).append("");
      ((VipBannerInfo)localObject1).a = ((StringBuilder)localObject2).toString();
      ((VipBannerInfo)localObject1).b = paramAdItem.traceinfo.get();
      ((VipBannerInfo)localObject1).c = ((String)paramConversation.get("text_content"));
      ((VipBannerInfo)localObject1).d = ((String)paramConversation.get("url"));
      ((VipBannerInfo)localObject1).e = ((String)paramConversation.get("pic_icon"));
      ((VipBannerInfo)localObject1).k = ((String)paramConversation.get("url_type"));
      ((VipBannerInfo)localObject1).f = ((String)paramConversation.get("text_button"));
      ((VipBannerInfo)localObject1).g = ((String)paramConversation.get("pic_bg"));
      ((VipBannerInfo)localObject1).h = ((String)paramConversation.get("pic_button"));
      ((VipBannerInfo)localObject1).i = ((String)paramConversation.get("color_content"));
      ((VipBannerInfo)localObject1).j = ((String)paramConversation.get("color_button"));
      if ((!TextUtils.isEmpty(((VipBannerInfo)localObject1).c)) && (!TextUtils.isEmpty(((VipBannerInfo)localObject1).d)) && (!TextUtils.isEmpty(((VipBannerInfo)localObject1).f)) && (!TextUtils.isEmpty(((VipBannerInfo)localObject1).e)))
      {
        paramConversation = Message.obtain();
        paramConversation.what = 2000;
        paramConversation.obj = localObject1;
        BannerManager.a().b(RenewalsBannerProcessor.a, paramConversation);
      }
    }
  }
  
  public void a(String paramString)
  {
    TianShuManager.getInstance().requestAdv(a(), new TianshuRenewalsBarManager.TianshuGetRenewalsBarCallback(this, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.vip.ad.TianshuRenewalsBarManager
 * JD-Core Version:    0.7.0.1
 */