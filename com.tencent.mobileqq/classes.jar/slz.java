import UserGrowth.stSimpleGetFeedListRsp;
import UserGrowth.stSimpleMetaFeed;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.WSRecommendFragment;
import com.tencent.biz.pubaccount.weishi_new.presenter.WSRecommendFragmentPresenter.4;
import com.tencent.biz.pubaccount.weishi_new.push.WSRedDotPushMsg;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import cooperation.qzone.LocalMultiProcConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.util.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

public class slz
  extends sly
{
  private static String jdField_b_of_type_JavaLangString = "";
  private static String c = "";
  public long a;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private String jdField_a_of_type_JavaLangString = "";
  private WeakReference<WSRecommendFragment> jdField_a_of_type_MqqUtilWeakReference;
  private boolean jdField_a_of_type_Boolean;
  private boolean jdField_b_of_type_Boolean;
  
  public slz(WSRecommendFragment paramWSRecommendFragment)
  {
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramWSRecommendFragment);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    c("");
  }
  
  private stSimpleMetaFeed a(ArrayList<stSimpleMetaFeed> paramArrayList)
  {
    int i = paramArrayList.size() - 1;
    while (i > 0)
    {
      stSimpleMetaFeed localstSimpleMetaFeed = (stSimpleMetaFeed)paramArrayList.get(i);
      if (!TextUtils.isEmpty(localstSimpleMetaFeed.feed_desc)) {
        return localstSimpleMetaFeed;
      }
      i -= 1;
    }
    return (stSimpleMetaFeed)paramArrayList.get(paramArrayList.size() - 1);
  }
  
  private void a()
  {
    sne.b("WSRecommendFragmentPresenter", "doPlanRedDotPreload");
    a(true, true);
  }
  
  public static void a(String paramString, int paramInt, byte paramByte1, byte paramByte2, WSRedDotPushMsg paramWSRedDotPushMsg, List<stSimpleMetaFeed> paramList, slk paramslk)
  {
    ArrayList localArrayList = new ArrayList();
    String str = "";
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        localArrayList.add(((stSimpleMetaFeed)paramList.next()).id);
      }
    }
    paramList = str;
    if (paramWSRedDotPushMsg != null) {
      paramList = paramWSRedDotPushMsg.mMsgData;
    }
    if (TextUtils.isEmpty(jdField_b_of_type_JavaLangString)) {
      c("");
    }
    paramString = new slv(new smy(paramString, paramByte1, paramByte2, localArrayList, paramInt, jdField_b_of_type_JavaLangString, "", c, paramList), null, paramslk, 1001);
    slo.a().a(paramString);
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    sne.b("WSRecommendFragmentPresenter", "doPlanDefaultLoad");
    a(false, true, false, paramString);
    a(false, paramBoolean);
  }
  
  private void a(ArrayList<stSimpleMetaFeed> paramArrayList)
  {
    if (paramArrayList.size() == 0) {}
    byte[] arrayOfByte;
    do
    {
      do
      {
        return;
        paramArrayList = (stSimpleMetaFeed)paramArrayList.get(0);
      } while ((paramArrayList == null) || (paramArrayList.map_pass_back == null) || (paramArrayList.map_pass_back.size() != 0));
      arrayOfByte = bbdj.a(((otp)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(274)).b());
    } while (arrayOfByte == null);
    sne.a("weishi-report", "load map passback length:" + arrayOfByte.length);
    sne.b("weishi-report", "load map passback:" + sni.a(arrayOfByte));
    paramArrayList.map_pass_back.put(Integer.valueOf(1), arrayOfByte);
  }
  
  private void a(slv paramslv, boolean paramBoolean, long paramLong)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_Long = (System.currentTimeMillis() - paramLong);
      sms.a(302, new Object[] { Integer.valueOf(paramslv.jdField_a_of_type_Int), Long.valueOf(this.jdField_a_of_type_Long) });
    }
  }
  
  private void a(slv paramslv, boolean paramBoolean1, long paramLong, boolean paramBoolean2, boolean paramBoolean3)
  {
    boolean bool = true;
    sne.b("WSRecommendFragmentPresenter", "onTaskResponse-resultCode:" + paramslv.b + " | resultBean:" + paramslv.jdField_a_of_type_JavaLangObject + " | thread" + Thread.currentThread().getName());
    this.jdField_b_of_type_Boolean = true;
    WSRecommendFragment localWSRecommendFragment = null;
    if (this.jdField_a_of_type_MqqUtilWeakReference != null) {
      localWSRecommendFragment = (WSRecommendFragment)this.jdField_a_of_type_MqqUtilWeakReference.get();
    }
    if ((localWSRecommendFragment == null) || (localWSRecommendFragment.getActivity().isFinishing())) {
      return;
    }
    if (paramslv.a())
    {
      if (((paramslv.jdField_a_of_type_JavaLangObject instanceof stSimpleGetFeedListRsp)) && (((stSimpleGetFeedListRsp)paramslv.jdField_a_of_type_JavaLangObject).feeds != null) && (((stSimpleGetFeedListRsp)paramslv.jdField_a_of_type_JavaLangObject).feeds.size() > 0))
      {
        sll localsll = paramslv.jdField_a_of_type_Sll;
        stSimpleGetFeedListRsp localstSimpleGetFeedListRsp = (stSimpleGetFeedListRsp)paramslv.jdField_a_of_type_JavaLangObject;
        if (paramBoolean1)
        {
          skb.a().a(localstSimpleGetFeedListRsp.config);
          this.jdField_a_of_type_Long = (System.currentTimeMillis() - paramLong);
          sne.b("weishi-report", "请求瀑布流耗时：" + this.jdField_a_of_type_Long + "毫秒");
          smu.a().b(true, this.jdField_a_of_type_Long);
        }
        this.jdField_a_of_type_JavaLangString = ((stSimpleGetFeedListRsp)paramslv.jdField_a_of_type_JavaLangObject).attach_info;
        paramslv = localstSimpleGetFeedListRsp.feeds;
        a(paramslv);
        b(paramslv);
        sne.b("WSRecommendFragmentPresenter", "size=" + paramslv.size());
        stSimpleMetaFeed localstSimpleMetaFeed = a(paramslv);
        sne.b("WSRecommendFragmentPresenter", "lastfeed desc:" + localstSimpleMetaFeed.feed_desc + ",videoUrl:" + localstSimpleMetaFeed.video_url);
        if ((localWSRecommendFragment.getActivity() != null) && (!localWSRecommendFragment.getActivity().isFinishing()))
        {
          QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
          if (localQQAppInterface != null) {
            ((otp)localQQAppInterface.getManager(274)).a(localstSimpleMetaFeed);
          }
        }
        d(localstSimpleGetFeedListRsp.session);
        if (!localstSimpleGetFeedListRsp.is_finished) {}
        for (;;)
        {
          localWSRecommendFragment.a(paramslv, localsll, paramBoolean1, paramBoolean2, bool, paramBoolean3);
          return;
          bool = false;
        }
      }
      localWSRecommendFragment.a(paramslv.b, ajyc.a(2131717009), paramBoolean1, paramBoolean2);
      a(paramslv, paramBoolean1, paramLong);
      return;
    }
    localWSRecommendFragment.a(paramslv.jdField_a_of_type_Int, paramslv.jdField_a_of_type_JavaLangString, paramBoolean1, paramBoolean2);
    a(paramslv, paramBoolean1, paramLong);
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    sne.d("WSRecommendFragmentPresenter", "getCacheData");
    sjy.a().a(new smb(this, paramBoolean1, paramBoolean2));
  }
  
  private void b(ArrayList<stSimpleMetaFeed> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        stSimpleMetaFeed localstSimpleMetaFeed = (stSimpleMetaFeed)paramArrayList.next();
        localstSimpleMetaFeed.feed_desc = sni.a(localstSimpleMetaFeed.feed_desc);
      }
    }
  }
  
  private static void b(JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    if ((paramJSONObject1 == null) || (paramJSONObject2 == null)) {
      return;
    }
    try
    {
      paramJSONObject1.put("deep_link_version", 1);
      paramJSONObject2.put("device_info", paramJSONObject1);
      jdField_b_of_type_JavaLangString = paramJSONObject2.toString();
      return;
    }
    catch (JSONException paramJSONObject1)
    {
      yxs.d("WSRecommendFragmentPresenter", "onResult", paramJSONObject1);
    }
  }
  
  public static void c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      try
      {
        paramString = new JSONObject();
        paramString.put("gdt_pageindex", 0);
        jdField_b_of_type_JavaLangString = paramString.toString();
        String str = LocalMultiProcConfig.getString("cache_key_gdt_args", "");
        if (!TextUtils.isEmpty(str))
        {
          b(new JSONObject(str), paramString);
          return;
        }
      }
      catch (JSONException paramString)
      {
        yxs.d("WSRecommendFragmentPresenter", "setGdtArgs", paramString);
      }
    }
    for (;;)
    {
      ThreadManager.executeOnSubThread(new WSRecommendFragmentPresenter.4());
      return;
      jdField_b_of_type_JavaLangString = paramString;
    }
  }
  
  public static void d(String paramString)
  {
    c = paramString;
  }
  
  public void a(String paramString)
  {
    paramString = new slv(new smw(paramString), this.jdField_a_of_type_AndroidOsHandler, new sma(this), 2001);
    slo.a().a(paramString);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    a(paramBoolean1, paramBoolean2, false, paramString);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString)
  {
    long l = System.currentTimeMillis();
    if ((this.jdField_a_of_type_MqqUtilWeakReference == null) || (this.jdField_a_of_type_MqqUtilWeakReference.get() == null)) {
      return;
    }
    WSRecommendFragment localWSRecommendFragment = (WSRecommendFragment)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if ((paramBoolean2) && (!paramBoolean3)) {
      localWSRecommendFragment.a();
    }
    String str2 = "";
    Object localObject2 = "";
    ArrayList localArrayList = new ArrayList();
    String str1 = str2;
    Object localObject1 = localObject2;
    if (paramBoolean2)
    {
      str1 = str2;
      localObject1 = localObject2;
      if (!paramBoolean1)
      {
        str1 = localWSRecommendFragment.a();
        sne.d("WSAioLog", "rowKey:" + str1 + ", magActionData:" + paramString);
        localObject2 = sni.a();
        str2 = sni.jdField_a_of_type_JavaLangString;
        localObject1 = str2;
        if (localObject2 != null)
        {
          localObject1 = str2;
          if (TextUtils.isEmpty(str2)) {
            localObject1 = ((otp)localObject2).c();
          }
        }
        sne.a("WSAioLog", "getFeedList lastFeedId:" + (String)localObject1);
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          localArrayList.add(localObject1);
        }
        localObject1 = paramString;
      }
    }
    if (paramBoolean1) {
      this.jdField_a_of_type_JavaLangString = "";
    }
    sne.a("WSAioLog", "getFeedList isFirstFromService:" + paramBoolean2 + ", contentFeedIds:" + localArrayList);
    paramString = this.jdField_a_of_type_JavaLangString;
    byte b1;
    if (paramBoolean1)
    {
      i = 1;
      b1 = (byte)i;
      if (!paramBoolean2) {
        break label362;
      }
    }
    label362:
    for (int i = 1;; i = 0)
    {
      paramString = new slv(new smy(paramString, b1, (byte)i, localArrayList, 1, jdField_b_of_type_JavaLangString, str1, c, (String)localObject1), this.jdField_a_of_type_AndroidOsHandler, new smc(this, paramBoolean2, l, paramBoolean1, paramBoolean3), 1001);
      slo.a().a(paramString);
      return;
      i = 0;
      break;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b(String paramString)
  {
    boolean bool = false;
    otp localotp = sni.a();
    if (localotp != null) {
      bool = sni.a(localotp);
    }
    sne.b("WSRecommendFragmentPresenter", "isFromWeiShiPush = " + bool);
    if ((bool) && (sjy.a().a()) && (sjy.a().a() >= 8) && (sjy.a().b()))
    {
      a();
      return;
    }
    a(paramString, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     slz
 * JD-Core Version:    0.7.0.1
 */