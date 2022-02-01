import android.app.Activity;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.ad.utils.ReadInJoySocialSmallAdUtils.1;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

public class oqp
{
  public static long a;
  public static GdtHandler.Params a;
  public static ArrayList<oqq> a;
  private static ArrayBlockingQueue<AdvertisementInfo> a;
  public static AtomicBoolean a;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    jdField_a_of_type_JavaUtilConcurrentArrayBlockingQueue = new ArrayBlockingQueue(10);
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    jdField_a_of_type_Long = -2147483648L;
  }
  
  public static AdvertisementInfo a()
  {
    AdvertisementInfo localAdvertisementInfo = (AdvertisementInfo)jdField_a_of_type_JavaUtilConcurrentArrayBlockingQueue.poll();
    if (jdField_a_of_type_JavaUtilConcurrentArrayBlockingQueue.size() < 1) {
      b();
    }
    return localAdvertisementInfo;
  }
  
  public static void a()
  {
    ubb.a(0, jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params, jdField_a_of_type_Long);
    jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params = null;
    jdField_a_of_type_Long = -2147483648L;
  }
  
  public static void a(AdvertisementInfo paramAdvertisementInfo)
  {
    jdField_a_of_type_JavaUtilConcurrentArrayBlockingQueue.offer(paramAdvertisementInfo);
  }
  
  public static void a(BaseArticleInfo paramBaseArticleInfo, TemplateBean paramTemplateBean, int paramInt)
  {
    if ((paramBaseArticleInfo == null) || (paramBaseArticleInfo.mChannelID != 0L)) {}
    do
    {
      do
      {
        do
        {
          return;
        } while ((paramTemplateBean == null) || (TextUtils.isEmpty(paramTemplateBean.getStyleName())) || ((!paramTemplateBean.getStyleName().equals("ReadInjoy_biu_cell")) && (!paramTemplateBean.getStyleName().equals("ReadInjoy_biu_small_pgc_cell")) && (!paramTemplateBean.getStyleName().equals("RIJ_biu_small_single_img_cell"))) || (a(paramInt)));
        paramTemplateBean = paramTemplateBean.getViewDataBinding();
      } while (paramTemplateBean == null);
      paramTemplateBean.remove("id_ad_biu_small_image_ugc");
      paramTemplateBean.remove("id_ad_biu_small_image_pgc");
      paramBaseArticleInfo = paramBaseArticleInfo.mSocialFeedInfo;
    } while (paramBaseArticleInfo == null);
    paramBaseArticleInfo.jdField_a_of_type_Boolean = true;
  }
  
  public static void a(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject, int paramInt)
  {
    if ((paramJSONObject == null) || (paramBaseArticleInfo == null) || (paramBaseArticleInfo.mChannelID != 0L)) {}
    do
    {
      return;
      if (jdField_a_of_type_JavaUtilConcurrentArrayBlockingQueue.size() < 1)
      {
        b();
        return;
      }
    } while ((paramBaseArticleInfo.mSocialFeedInfo == null) || (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Boolean) || (paramJSONObject.has("id_ad_biu_small_image_ugc")) || (paramJSONObject.has("id_ad_biu_small_image_pgc")));
    AdvertisementInfo localAdvertisementInfo1 = null;
    if (paramBaseArticleInfo.mSocialFeedInfo != null) {
      localAdvertisementInfo1 = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
    }
    AdvertisementInfo localAdvertisementInfo2;
    if (paramInt == 1)
    {
      localAdvertisementInfo2 = localAdvertisementInfo1;
      if (localAdvertisementInfo1 != null) {}
    }
    for (;;)
    {
      try
      {
        localAdvertisementInfo2 = a();
        qcd.b(localAdvertisementInfo2, paramJSONObject);
        if (localAdvertisementInfo2 == null) {
          break;
        }
        paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = localAdvertisementInfo2;
        return;
      }
      catch (Exception paramBaseArticleInfo)
      {
        paramBaseArticleInfo.printStackTrace();
        return;
      }
      localAdvertisementInfo2 = localAdvertisementInfo1;
      if (paramInt == 2)
      {
        localAdvertisementInfo2 = localAdvertisementInfo1;
        if (localAdvertisementInfo1 == null) {
          localAdvertisementInfo2 = a();
        }
        qcd.a(localAdvertisementInfo2, paramJSONObject);
      }
    }
  }
  
  public static void a(pxk parampxk, ViewBase paramViewBase, Container paramContainer, int paramInt)
  {
    if ((parampxk != null) && (parampxk.a() != null) && (parampxk.a().mSocialFeedInfo != null) && (parampxk.a().mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null))
    {
      paramViewBase = paramViewBase.findViewBaseByName("id_view_AdDownloadView");
      if ((paramViewBase instanceof osm)) {
        ((osm)paramViewBase).a(new pya(paramContainer.getContext(), parampxk.a().mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, parampxk.a(), parampxk.e(), parampxk.f(), parampxk.h(), false, parampxk.g(), parampxk.b(), parampxk.a()), true);
      }
    }
  }
  
  private static boolean a(int paramInt)
  {
    AdvertisementInfo localAdvertisementInfo = pmh.a().c(0, paramInt);
    if (localAdvertisementInfo == null) {
      return true;
    }
    return a(localAdvertisementInfo.mAdKdPos, paramInt, localAdvertisementInfo.getNextAdPosition());
  }
  
  private static boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (jdField_a_of_type_JavaUtilArrayList.size() == 0)
    {
      if ((paramInt2 - paramInt1 > 1) && (paramInt3 - paramInt2 > 1)) {
        return true;
      }
      localObject = new oqq();
      ((oqq)localObject).b = 1;
      ((oqq)localObject).a = 1;
      return a((oqq)localObject, paramInt1, paramInt2, paramInt3);
    }
    Object localObject = jdField_a_of_type_JavaUtilArrayList.iterator();
    for (boolean bool = true; ((Iterator)localObject).hasNext(); bool = a((oqq)((Iterator)localObject).next(), paramInt1, paramInt2, paramInt3) & bool) {}
    return bool;
  }
  
  public static boolean a(Activity paramActivity, int paramInt, BaseArticleInfo paramBaseArticleInfo, snh paramsnh, pxk parampxk, aobu paramaobu, Container paramContainer, ViewBase paramViewBase)
  {
    boolean bool = false;
    if (paramInt == 1182) {
      bool = true;
    }
    int i = 1000;
    if (paramInt == 1183)
    {
      bool = true;
      i = 4;
    }
    if (paramInt == 1184)
    {
      bool = true;
      i = 1;
    }
    if (paramInt == 1185)
    {
      bool = true;
      i = 3;
    }
    if (paramInt == 1186)
    {
      bool = true;
      i = 1;
    }
    if (paramInt == 1087)
    {
      bool = true;
      i = 5;
    }
    if (paramInt == 1088)
    {
      bool = true;
      i = 4;
    }
    if (paramInt == 1187)
    {
      bool = true;
      i = 8;
    }
    for (;;)
    {
      if (bool)
      {
        if (paramInt != 1186) {
          break label188;
        }
        if ((parampxk == null) || (paramBaseArticleInfo == null) || (paramBaseArticleInfo.mSocialFeedInfo == null) || (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo == null)) {
          return true;
        }
        paramActivity = new qtg(paramActivity, paramaobu, paramsnh);
        paramActivity.a(parampxk);
        paramActivity.a(paramContainer);
        paramActivity.a(paramViewBase.getNativeView());
      }
      for (;;)
      {
        return bool;
        label188:
        if ((paramBaseArticleInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null))
        {
          paramBaseArticleInfo = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
          paramBaseArticleInfo.mChannelID = 0L;
          paramBaseArticleInfo.setClickPos(i);
          jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params = ubb.a(paramActivity, paramBaseArticleInfo, paramsnh, 0, true, null);
          jdField_a_of_type_Long = SystemClock.elapsedRealtime();
          paramBaseArticleInfo.setClickPos(i);
          ubb.a(paramActivity, paramBaseArticleInfo, paramsnh, 0, true, null);
        }
      }
    }
  }
  
  public static boolean a(AdvertisementInfo paramAdvertisementInfo)
  {
    try
    {
      Object localObject = new JSONObject(paramAdvertisementInfo.mAdExtInfo);
      if (((JSONObject)localObject).optInt("social_card_flag") == 1)
      {
        paramAdvertisementInfo.mChannelID = 0L;
        a(paramAdvertisementInfo);
        paramAdvertisementInfo = ((JSONObject)localObject).optJSONArray("social_card_ad_strategy");
        if ((paramAdvertisementInfo != null) && (paramAdvertisementInfo.length() > 0))
        {
          jdField_a_of_type_JavaUtilArrayList.clear();
          int i = 0;
          while (i < paramAdvertisementInfo.length())
          {
            localObject = paramAdvertisementInfo.get(i);
            if ((localObject instanceof JSONObject))
            {
              int j = ((JSONObject)localObject).optInt("A");
              int k = ((JSONObject)localObject).optInt("B");
              localObject = new oqq();
              ((oqq)localObject).a = j;
              ((oqq)localObject).b = k;
              jdField_a_of_type_JavaUtilArrayList.add(localObject);
            }
            i += 1;
          }
        }
      }
      else
      {
        return false;
      }
    }
    catch (Exception paramAdvertisementInfo)
    {
      paramAdvertisementInfo.printStackTrace();
    }
    return true;
  }
  
  public static boolean a(BaseArticleInfo paramBaseArticleInfo)
  {
    return (paramBaseArticleInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null);
  }
  
  private static boolean a(oqq paramoqq, int paramInt1, int paramInt2, int paramInt3)
  {
    return (paramInt2 - paramInt1 > paramoqq.a) && (paramInt3 - paramInt2 > paramoqq.b);
  }
  
  public static boolean a(pxk parampxk)
  {
    if (parampxk == null) {
      return false;
    }
    return a(parampxk.a());
  }
  
  public static void b()
  {
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true);
    nwv localnwv = new nwv();
    localnwv.g = 1;
    ThreadManager.executeOnSubThread(new ReadInJoySocialSmallAdUtils.1(localnwv));
  }
  
  public static boolean b(AdvertisementInfo paramAdvertisementInfo)
  {
    try
    {
      int i = new JSONObject(paramAdvertisementInfo.mAdExtInfo).optInt("social_card_flag");
      return i == 1;
    }
    catch (Exception paramAdvertisementInfo)
    {
      paramAdvertisementInfo.printStackTrace();
    }
    return false;
  }
  
  public static void c()
  {
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(true, false);
    jdField_a_of_type_JavaUtilConcurrentArrayBlockingQueue.clear();
    jdField_a_of_type_JavaUtilArrayList.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oqp
 * JD-Core Version:    0.7.0.1
 */