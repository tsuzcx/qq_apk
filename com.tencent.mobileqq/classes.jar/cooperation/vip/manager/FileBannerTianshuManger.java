package cooperation.vip.manager;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.RelativeLayout;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback;
import com.tencent.mobileqq.tianshu.data.TianShuReportData;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.mobileqq.utils.ViewUtils;
import cooperation.qzone.util.QZLog;
import cooperation.vip.pb.TianShuAccess.AdItem;
import cooperation.vip.pb.TianShuAccess.AdPlacementInfo;
import cooperation.vip.pb.TianShuAccess.GetAdsRsp;
import cooperation.vip.pb.TianShuAccess.MapEntry;
import cooperation.vip.pb.TianShuAccess.RspEntry;
import cooperation.vip.tianshu.TianShuManager;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.util.WeakReference;

public class FileBannerTianshuManger
{
  public static int a = 488;
  protected View a;
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  protected RelativeLayout a;
  protected URLImageView a;
  TianShuGetAdvCallback jdField_a_of_type_ComTencentMobileqqTianshuDataTianShuGetAdvCallback = new FileBannerTianshuManger.2(this);
  public TianShuAccess.AdItem a;
  public String a;
  public WeakReference<Activity> a;
  public int b;
  protected View b;
  public String b;
  
  public FileBannerTianshuManger(Activity paramActivity, View paramView, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_CooperationVipPbTianShuAccess$AdItem = null;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramActivity);
    this.jdField_b_of_type_AndroidViewView = paramView;
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public int a()
  {
    return ViewUtils.a();
  }
  
  public void a()
  {
    ThreadManagerV2.excute(new FileBannerTianshuManger.1(this), 16, null, true);
  }
  
  public void a(TianShuAccess.AdItem paramAdItem, int paramInt)
  {
    if (paramAdItem == null)
    {
      QZLog.e("FileBannerTianshuManger", "item is  null");
      return;
    }
    int i = paramAdItem.iAdId.get();
    paramAdItem = paramAdItem.traceinfo.get();
    if (TextUtils.isEmpty(paramAdItem))
    {
      QZLog.e("FileBannerTianshuManger", "rtraceInfo is  null");
      return;
    }
    TianShuReportData localTianShuReportData = new TianShuReportData();
    long l = NetConnInfoCenter.getServerTimeMillis() / 1000L;
    localTianShuReportData.jdField_a_of_type_Int = 1;
    localTianShuReportData.jdField_e_of_type_JavaLangString = "tianshu.99";
    localTianShuReportData.jdField_f_of_type_JavaLangString = "tianshu.99";
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(i);
    localStringBuilder.append("");
    localTianShuReportData.g = localStringBuilder.toString();
    localTianShuReportData.h = "";
    localTianShuReportData.jdField_a_of_type_Long = l;
    localTianShuReportData.d = paramInt;
    localTianShuReportData.jdField_e_of_type_Int = 1;
    localTianShuReportData.jdField_f_of_type_Int = 1;
    localTianShuReportData.l = paramAdItem;
    TianShuManager.getInstance().report(localTianShuReportData);
    paramAdItem = new StringBuilder();
    paramAdItem.append("report appid");
    paramAdItem.append(i);
    paramAdItem.append("actionid");
    paramAdItem.append(paramInt);
    QZLog.i("FileBannerTianshuManger", paramAdItem.toString());
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Object localObject1 = this.jdField_a_of_type_MqqUtilWeakReference;
      if (localObject1 != null)
      {
        if (((WeakReference)localObject1).get() == null) {
          return;
        }
        try
        {
          Object localObject2 = (Activity)this.jdField_a_of_type_MqqUtilWeakReference.get();
          localObject1 = localObject2;
          if ((localObject2 instanceof BasePluginActivity)) {
            localObject1 = ((BasePluginActivity)localObject2).getOutActivity();
          }
          if ((!paramString.startsWith("http")) && (!paramString.startsWith("https")))
          {
            localObject2 = new Intent((Context)localObject1, JumpActivity.class);
            ((Intent)localObject2).setData(Uri.parse(paramString));
            ((Context)localObject1).startActivity((Intent)localObject2);
            a(this.jdField_a_of_type_CooperationVipPbTianShuAccess$AdItem, 102);
            if (this.jdField_b_of_type_Int == 1) {
              a(this.jdField_a_of_type_CooperationVipPbTianShuAccess$AdItem, 138);
            }
          }
          else
          {
            localObject2 = new Intent((Context)localObject1, QQBrowserActivity.class);
            ((Intent)localObject2).putExtra("url", paramString);
            ((Intent)localObject2).putExtra("big_brother_source_key", "biz_src_jc_vip");
            ((Context)localObject1).startActivity((Intent)localObject2);
            a(this.jdField_a_of_type_CooperationVipPbTianShuAccess$AdItem, 102);
            if (this.jdField_b_of_type_Int == 1)
            {
              a(this.jdField_a_of_type_CooperationVipPbTianShuAccess$AdItem, 138);
              return;
            }
          }
        }
        catch (Exception paramString)
        {
          QZLog.e("FileBannerTianshuManger", paramString.toString());
        }
      }
    }
  }
  
  public void a(String paramString, URLDrawable paramURLDrawable)
  {
    try
    {
      if ((this.jdField_a_of_type_MqqUtilWeakReference != null) && (this.jdField_a_of_type_MqqUtilWeakReference.get() != null))
      {
        ((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get()).runOnUiThread(new FileBannerTianshuManger.4(this, paramURLDrawable, paramString));
        return;
      }
      QZLog.i("FileBannerTianshuManger", "showFileBanner activity is null ");
      return;
    }
    catch (Exception paramString)
    {
      QZLog.e("FileBannerTianshuManger", paramString.toString());
    }
  }
  
  public void a(boolean paramBoolean, TianShuAccess.GetAdsRsp paramGetAdsRsp)
  {
    Object localObject1;
    if (QZLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onGetAdvs isSucc:");
      ((StringBuilder)localObject1).append(paramBoolean);
      QZLog.i("FileBannerTianshuManger", ((StringBuilder)localObject1).toString());
    }
    if (paramBoolean)
    {
      if (paramGetAdsRsp == null) {
        return;
      }
      if (paramGetAdsRsp.mapAds.has()) {
        paramGetAdsRsp = paramGetAdsRsp.mapAds.get();
      } else {
        paramGetAdsRsp = null;
      }
      if (paramGetAdsRsp == null)
      {
        QZLog.e("FileBannerTianshuManger", "rspEntries == null");
        return;
      }
      localObject1 = new HashMap();
      paramGetAdsRsp = paramGetAdsRsp.iterator();
      Object localObject2;
      while (paramGetAdsRsp.hasNext())
      {
        localObject2 = (TianShuAccess.RspEntry)paramGetAdsRsp.next();
        if ((localObject2 != null) && (((TianShuAccess.RspEntry)localObject2).key.has())) {
          ((Map)localObject1).put(Integer.valueOf(((TianShuAccess.RspEntry)localObject2).key.get()), localObject2);
        }
      }
      localObject1 = (TianShuAccess.RspEntry)((Map)localObject1).get(Integer.valueOf(jdField_a_of_type_Int));
      if ((localObject1 != null) && (((TianShuAccess.RspEntry)localObject1).value != null) && (((TianShuAccess.RspEntry)localObject1).value.lst.size() != 0) && (((TianShuAccess.RspEntry)localObject1).value.lst.get(0) != null) && (((TianShuAccess.AdItem)((TianShuAccess.RspEntry)localObject1).value.lst.get(0)).argList != null) && (((TianShuAccess.AdItem)((TianShuAccess.RspEntry)localObject1).value.lst.get(0)).argList.get() != null))
      {
        localObject2 = ((TianShuAccess.AdItem)((TianShuAccess.RspEntry)localObject1).value.lst.get(0)).argList.get();
        paramGetAdsRsp = new HashMap();
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          Object localObject3 = (TianShuAccess.MapEntry)((Iterator)localObject2).next();
          String str = ((TianShuAccess.MapEntry)localObject3).key.get();
          localObject3 = ((TianShuAccess.MapEntry)localObject3).value.get();
          if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty((CharSequence)localObject3))) {
            paramGetAdsRsp.put(str, localObject3);
          }
        }
        localObject1 = (TianShuAccess.AdItem)((TianShuAccess.RspEntry)localObject1).value.lst.get(0);
        this.jdField_b_of_type_JavaLangString = ((String)paramGetAdsRsp.get("pic"));
        this.jdField_a_of_type_JavaLangString = ((String)paramGetAdsRsp.get("url"));
        this.jdField_a_of_type_CooperationVipPbTianShuAccess$AdItem = ((TianShuAccess.AdItem)localObject1);
        b();
        return;
      }
      QZLog.e("FileBannerTianshuManger", "data is error");
    }
  }
  
  public int b()
  {
    return (int)(a() * 0.1449275F);
  }
  
  public void b()
  {
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {}
    try
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      URLDrawable localURLDrawable = URLDrawable.getDrawable(this.jdField_b_of_type_JavaLangString, localURLDrawableOptions);
      localURLDrawableOptions.mLoadingDrawable = URLDrawableHelperConstants.a;
      localURLDrawableOptions.mFailedDrawable = URLDrawableHelperConstants.a;
      localURLDrawableOptions.mRequestWidth = a();
      localURLDrawableOptions.mRequestHeight = b();
      if (localURLDrawable.getStatus() == 1)
      {
        QZLog.i("FileBannerTianshuManger", "showFileBanner URLDrawable success ");
        a(this.jdField_a_of_type_JavaLangString, localURLDrawable);
        a(this.jdField_a_of_type_CooperationVipPbTianShuAccess$AdItem, 101);
        if (this.jdField_b_of_type_Int != 1) {
          break label148;
        }
        a(this.jdField_a_of_type_CooperationVipPbTianShuAccess$AdItem, 137);
        return;
      }
      localURLDrawable.setURLDrawableListener(new FileBannerTianshuManger.3(this));
      localURLDrawable.startDownload();
      return;
    }
    catch (Exception localException)
    {
      label125:
      break label125;
    }
    QZLog.e("FileBannerTianshuManger", "onGetAdvs pic erro");
    return;
    if (QZLog.isColorLevel()) {
      QZLog.i("FileBannerTianshuManger", "onGetAdvs pic url is null");
    }
    label148:
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.vip.manager.FileBannerTianshuManger
 * JD-Core Version:    0.7.0.1
 */