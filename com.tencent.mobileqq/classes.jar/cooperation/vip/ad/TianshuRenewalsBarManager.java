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
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.redtouch.VipBannerInfo;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.tianshu.data.TianShuAdPosItemData;
import com.tencent.mobileqq.tianshu.data.TianShuReportData;
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
    localTianShuAdPosItemData.jdField_a_of_type_Int = 596;
    localArrayList.add(localTianShuAdPosItemData);
    return localArrayList;
  }
  
  public static void a(BaseActivity paramBaseActivity, View paramView, VipBannerInfo paramVipBannerInfo, boolean paramBoolean)
  {
    if (a(paramBaseActivity, paramView, paramVipBannerInfo)) {
      return;
    }
    Object localObject1 = (TextView)paramView.findViewById(2131376920);
    Object localObject2 = paramVipBannerInfo.c;
    if ((localObject1 != null) && (!TextUtils.isEmpty((CharSequence)localObject2))) {
      ((TextView)localObject1).setText((CharSequence)localObject2);
    }
    localObject1 = (URLImageView)paramView.findViewById(2131376919);
    if ((localObject1 != null) && (!TextUtils.isEmpty(paramVipBannerInfo.jdField_e_of_type_JavaLangString)))
    {
      localObject2 = URLDrawable.getDrawable(paramVipBannerInfo.jdField_e_of_type_JavaLangString);
      if (localObject2 != null) {
        ((URLImageView)localObject1).setImageDrawable((Drawable)localObject2);
      }
    }
    localObject1 = (TextView)paramView.findViewById(2131376916);
    if ((localObject1 != null) && (!TextUtils.isEmpty(paramVipBannerInfo.f))) {
      ((TextView)localObject1).setText(paramVipBannerInfo.f);
    }
    paramView.setVisibility(0);
    localObject2 = (QQAppInterface)paramBaseActivity.getAppRuntime();
    a((QQAppInterface)localObject2, 101, paramVipBannerInfo.a, paramVipBannerInfo.b);
    localObject1 = new TianshuRenewalsBarManager.1((QQAppInterface)localObject2, paramVipBannerInfo);
    localObject2 = new TianshuRenewalsBarManager.2(paramVipBannerInfo, paramBaseActivity, (QQAppInterface)localObject2);
    FrameLayout localFrameLayout = (FrameLayout)paramView.findViewById(2131376914);
    if (localFrameLayout != null) {
      localFrameLayout.setOnClickListener((View.OnClickListener)localObject2);
    }
    localObject2 = (Button)paramView.findViewById(2131376918);
    if (localObject2 != null) {
      ((Button)localObject2).setOnClickListener((View.OnClickListener)localObject1);
    }
    b(paramBaseActivity, paramView, paramVipBannerInfo, paramBoolean);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, String paramString1, String paramString2)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    TianShuReportData localTianShuReportData = new TianShuReportData();
    long l = System.currentTimeMillis() / 1000L;
    localTianShuReportData.b = (String.valueOf(paramQQAppInterface.getCurrentAccountUin()) + '_' + l);
    localTianShuReportData.d = paramInt;
    localTianShuReportData.jdField_e_of_type_Int = 1;
    localTianShuReportData.g = String.valueOf(paramString1);
    localTianShuReportData.jdField_a_of_type_Long = l;
    localTianShuReportData.jdField_a_of_type_Int = 1;
    localTianShuReportData.jdField_e_of_type_JavaLangString = "tianshu.47";
    localTianShuReportData.i = "";
    localTianShuReportData.l = paramString2;
    TianShuManager.getInstance().report(localTianShuReportData);
    QLog.d("TianshuRenewalsBarManager", 1, "report actionId :" + paramInt + ", adId :" + paramString1);
  }
  
  private static void a(VipBannerInfo paramVipBannerInfo, QQAppInterface paramQQAppInterface, View paramView)
  {
    if ((paramQQAppInterface == null) || (paramView == null) || (paramVipBannerInfo == null)) {}
    for (;;)
    {
      return;
      URLImageView localURLImageView = (URLImageView)paramView.findViewById(2131376917);
      paramView = (TextView)paramView.findViewById(2131376916);
      if ((localURLImageView != null) && (paramView != null))
      {
        localURLImageView.setVisibility(8);
        if (ThemeUtil.isInNightMode(paramQQAppInterface)) {
          paramVipBannerInfo = "#FDC256";
        }
        while (!TextUtils.isEmpty(paramVipBannerInfo))
        {
          try
          {
            paramView.setTextColor(Color.parseColor(paramVipBannerInfo));
            return;
          }
          catch (Exception paramVipBannerInfo)
          {
            QLog.e("TianshuRenewalsBarManager", 1, paramVipBannerInfo, new Object[0]);
            return;
          }
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
      }
    }
  }
  
  private static void a(VipBannerInfo paramVipBannerInfo, boolean paramBoolean, QQAppInterface paramQQAppInterface, Resources paramResources, View paramView)
  {
    if ((paramQQAppInterface == null) || (paramVipBannerInfo == null) || (paramResources == null) || (paramView == null)) {}
    TextView localTextView;
    FrameLayout localFrameLayout;
    do
    {
      return;
      localTextView = (TextView)paramView.findViewById(2131376920);
      localFrameLayout = (FrameLayout)paramView.findViewById(2131376914);
      paramView = (URLImageView)paramView.findViewById(2131376915);
    } while ((localTextView == null) || (localFrameLayout == null) || (paramView == null));
    if (ThemeUtil.isInNightMode(paramQQAppInterface))
    {
      if (Build.VERSION.SDK_INT >= 16) {
        localFrameLayout.setBackground(paramResources.getDrawable(2130839537));
      }
      paramView.setVisibility(8);
      localTextView.setTextColor(paramResources.getColorStateList(2131167040));
      return;
    }
    if (!TextUtils.isEmpty(paramVipBannerInfo.g))
    {
      paramQQAppInterface = URLDrawable.getDrawable(paramVipBannerInfo.g);
      if (paramQQAppInterface != null)
      {
        paramView.setImageDrawable(paramQQAppInterface);
        paramView.setVisibility(0);
      }
      if (!TextUtils.isEmpty(paramVipBannerInfo.i)) {
        try
        {
          localTextView.setTextColor(Color.parseColor(paramVipBannerInfo.i));
          return;
        }
        catch (Exception paramVipBannerInfo)
        {
          QLog.e("TianshuRenewalsBarManager", 1, paramVipBannerInfo, new Object[0]);
          return;
        }
      }
      localTextView.setTextColor(paramResources.getColorStateList(2131167040));
      return;
    }
    if (Build.VERSION.SDK_INT >= 16)
    {
      if ((!paramBoolean) || ((!ThemeUtil.isDefaultTheme()) && (!ThemeUtil.isSimpleDayTheme(false)))) {
        break label255;
      }
      localFrameLayout.setBackground(paramResources.getDrawable(2130839538));
    }
    for (;;)
    {
      paramView.setVisibility(8);
      localTextView.setTextColor(paramResources.getColorStateList(2131167040));
      return;
      label255:
      localFrameLayout.setBackground(paramResources.getDrawable(2130839537));
    }
  }
  
  private void a(TianShuAccess.GetAdsRsp paramGetAdsRsp, String paramString)
  {
    Object localObject = this.a;
    if ((localObject == null) || (((Conversation)localObject).a == null)) {}
    for (;;)
    {
      return;
      if (BannerManager.a().a(26) == 2) {}
      for (int i = 1; (i != 0) && ("tianshu_req_renewals_type_pull_down".equals(paramString)); i = 0)
      {
        BannerManager.a().b(26, 2001);
        return;
      }
      if (paramGetAdsRsp.mapAds.has()) {}
      for (paramGetAdsRsp = paramGetAdsRsp.mapAds.get(); paramGetAdsRsp != null; paramGetAdsRsp = null)
      {
        paramString = new HashMap();
        paramGetAdsRsp = paramGetAdsRsp.iterator();
        while (paramGetAdsRsp.hasNext())
        {
          localObject = (TianShuAccess.RspEntry)paramGetAdsRsp.next();
          if ((localObject != null) && (((TianShuAccess.RspEntry)localObject).key.has())) {
            paramString.put(Integer.valueOf(((TianShuAccess.RspEntry)localObject).key.get()), localObject);
          }
        }
      }
    }
    a((TianShuAccess.RspEntry)paramString.get(Integer.valueOf(596)));
  }
  
  private void a(TianShuAccess.RspEntry paramRspEntry)
  {
    if ((paramRspEntry == null) || (paramRspEntry.value == null) || (paramRspEntry.value.lst.size() < 1)) {}
    do
    {
      return;
      paramRspEntry = (TianShuAccess.AdItem)paramRspEntry.value.lst.get(0);
    } while (paramRspEntry == null);
    a(this.a, paramRspEntry);
  }
  
  private static boolean a(BaseActivity paramBaseActivity, View paramView, VipBannerInfo paramVipBannerInfo)
  {
    return (paramBaseActivity == null) || (paramView == null) || (paramVipBannerInfo == null);
  }
  
  public static void b(BaseActivity paramBaseActivity, View paramView, VipBannerInfo paramVipBannerInfo, boolean paramBoolean)
  {
    if ((paramView == null) || (paramVipBannerInfo == null) || (paramBaseActivity == null)) {}
    while (paramView.getVisibility() != 0) {
      return;
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)paramBaseActivity.getAppRuntime();
    a(paramVipBannerInfo, paramBoolean, localQQAppInterface, paramBaseActivity.getResources(), paramView);
    a(paramVipBannerInfo, localQQAppInterface, paramView);
  }
  
  public void a()
  {
    this.a = null;
  }
  
  public void a(Conversation paramConversation, TianShuAccess.AdItem paramAdItem)
  {
    if ((paramAdItem == null) || (paramAdItem.argList.size() < 1)) {}
    Object localObject;
    do
    {
      return;
      paramConversation = new HashMap();
      localObject = paramAdItem.argList.get().iterator();
      while (((Iterator)localObject).hasNext())
      {
        TianShuAccess.MapEntry localMapEntry = (TianShuAccess.MapEntry)((Iterator)localObject).next();
        paramConversation.put(localMapEntry.key.get(), localMapEntry.value.get());
      }
      localObject = new VipBannerInfo();
      ((VipBannerInfo)localObject).a = (paramAdItem.iAdId.get() + "");
      ((VipBannerInfo)localObject).b = paramAdItem.traceinfo.get();
      ((VipBannerInfo)localObject).c = ((String)paramConversation.get("text_content"));
      ((VipBannerInfo)localObject).d = ((String)paramConversation.get("url"));
      ((VipBannerInfo)localObject).jdField_e_of_type_JavaLangString = ((String)paramConversation.get("pic_icon"));
      ((VipBannerInfo)localObject).k = ((String)paramConversation.get("url_type"));
      ((VipBannerInfo)localObject).f = ((String)paramConversation.get("text_button"));
      ((VipBannerInfo)localObject).g = ((String)paramConversation.get("pic_bg"));
      ((VipBannerInfo)localObject).h = ((String)paramConversation.get("pic_button"));
      ((VipBannerInfo)localObject).i = ((String)paramConversation.get("color_content"));
      ((VipBannerInfo)localObject).j = ((String)paramConversation.get("color_button"));
    } while ((TextUtils.isEmpty(((VipBannerInfo)localObject).c)) || (TextUtils.isEmpty(((VipBannerInfo)localObject).d)) || (TextUtils.isEmpty(((VipBannerInfo)localObject).f)) || (TextUtils.isEmpty(((VipBannerInfo)localObject).jdField_e_of_type_JavaLangString)));
    paramConversation = Message.obtain();
    paramConversation.what = 2000;
    paramConversation.obj = localObject;
    BannerManager.a().b(26, paramConversation);
  }
  
  public void a(String paramString)
  {
    TianShuManager.getInstance().requestAdv(a(), new TianshuRenewalsBarManager.TianshuGetRenewalsBarCallback(this, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.vip.ad.TianshuRenewalsBarManager
 * JD-Core Version:    0.7.0.1
 */