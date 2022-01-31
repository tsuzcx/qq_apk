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

public class slw
  extends slv
{
  private static String jdField_b_of_type_JavaLangString = "";
  private static String c = "";
  public long a;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private String jdField_a_of_type_JavaLangString = "";
  private WeakReference<WSRecommendFragment> jdField_a_of_type_MqqUtilWeakReference;
  private boolean jdField_a_of_type_Boolean;
  private boolean jdField_b_of_type_Boolean;
  
  public slw(WSRecommendFragment paramWSRecommendFragment)
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
    snb.b("WSRecommendFragmentPresenter", "doPlanRedDotPreload");
    a(true, true);
  }
  
  public static void a(String paramString, int paramInt, byte paramByte1, byte paramByte2, WSRedDotPushMsg paramWSRedDotPushMsg, List<stSimpleMetaFeed> paramList, slh paramslh)
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
    paramString = new sls(new smv(paramString, paramByte1, paramByte2, localArrayList, paramInt, jdField_b_of_type_JavaLangString, "", c, paramList), null, paramslh, 1001);
    sll.a().a(paramString);
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    snb.b("WSRecommendFragmentPresenter", "doPlanDefaultLoad");
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
      arrayOfByte = bbdx.a(((otm)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(274)).b());
    } while (arrayOfByte == null);
    snb.a("weishi-report", "load map passback length:" + arrayOfByte.length);
    snb.b("weishi-report", "load map passback:" + snf.a(arrayOfByte));
    paramArrayList.map_pass_back.put(Integer.valueOf(1), arrayOfByte);
  }
  
  private void a(sls paramsls, boolean paramBoolean, long paramLong)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_Long = (System.currentTimeMillis() - paramLong);
      smp.a(302, new Object[] { Integer.valueOf(paramsls.jdField_a_of_type_Int), Long.valueOf(this.jdField_a_of_type_Long) });
    }
  }
  
  private void a(sls paramsls, boolean paramBoolean1, long paramLong, boolean paramBoolean2, boolean paramBoolean3)
  {
    boolean bool = true;
    snb.b("WSRecommendFragmentPresenter", "onTaskResponse-resultCode:" + paramsls.b + " | resultBean:" + paramsls.jdField_a_of_type_JavaLangObject + " | thread" + Thread.currentThread().getName());
    this.jdField_b_of_type_Boolean = true;
    WSRecommendFragment localWSRecommendFragment = null;
    if (this.jdField_a_of_type_MqqUtilWeakReference != null) {
      localWSRecommendFragment = (WSRecommendFragment)this.jdField_a_of_type_MqqUtilWeakReference.get();
    }
    if ((localWSRecommendFragment == null) || (localWSRecommendFragment.getActivity().isFinishing())) {
      return;
    }
    if (paramsls.a())
    {
      if (((paramsls.jdField_a_of_type_JavaLangObject instanceof stSimpleGetFeedListRsp)) && (((stSimpleGetFeedListRsp)paramsls.jdField_a_of_type_JavaLangObject).feeds != null) && (((stSimpleGetFeedListRsp)paramsls.jdField_a_of_type_JavaLangObject).feeds.size() > 0))
      {
        sli localsli = paramsls.jdField_a_of_type_Sli;
        stSimpleGetFeedListRsp localstSimpleGetFeedListRsp = (stSimpleGetFeedListRsp)paramsls.jdField_a_of_type_JavaLangObject;
        if (paramBoolean1)
        {
          sjy.a().a(localstSimpleGetFeedListRsp.config);
          this.jdField_a_of_type_Long = (System.currentTimeMillis() - paramLong);
          snb.b("weishi-report", "请求瀑布流耗时：" + this.jdField_a_of_type_Long + "毫秒");
          smr.a().b(true, this.jdField_a_of_type_Long);
        }
        this.jdField_a_of_type_JavaLangString = ((stSimpleGetFeedListRsp)paramsls.jdField_a_of_type_JavaLangObject).attach_info;
        paramsls = localstSimpleGetFeedListRsp.feeds;
        a(paramsls);
        b(paramsls);
        snb.b("WSRecommendFragmentPresenter", "size=" + paramsls.size());
        stSimpleMetaFeed localstSimpleMetaFeed = a(paramsls);
        snb.b("WSRecommendFragmentPresenter", "lastfeed desc:" + localstSimpleMetaFeed.feed_desc + ",videoUrl:" + localstSimpleMetaFeed.video_url);
        if ((localWSRecommendFragment.getActivity() != null) && (!localWSRecommendFragment.getActivity().isFinishing()))
        {
          QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
          if (localQQAppInterface != null) {
            ((otm)localQQAppInterface.getManager(274)).a(localstSimpleMetaFeed);
          }
        }
        d(localstSimpleGetFeedListRsp.session);
        if (!localstSimpleGetFeedListRsp.is_finished) {}
        for (;;)
        {
          localWSRecommendFragment.a(paramsls, localsli, paramBoolean1, paramBoolean2, bool, paramBoolean3);
          return;
          bool = false;
        }
      }
      localWSRecommendFragment.a(paramsls.b, ajya.a(2131717020), paramBoolean1, paramBoolean2);
      a(paramsls, paramBoolean1, paramLong);
      return;
    }
    localWSRecommendFragment.a(paramsls.jdField_a_of_type_Int, paramsls.jdField_a_of_type_JavaLangString, paramBoolean1, paramBoolean2);
    a(paramsls, paramBoolean1, paramLong);
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    snb.d("WSRecommendFragmentPresenter", "getCacheData");
    sjv.a().a(new sly(this, paramBoolean1, paramBoolean2));
  }
  
  private void b(ArrayList<stSimpleMetaFeed> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        stSimpleMetaFeed localstSimpleMetaFeed = (stSimpleMetaFeed)paramArrayList.next();
        localstSimpleMetaFeed.feed_desc = snf.a(localstSimpleMetaFeed.feed_desc);
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
      yxp.d("WSRecommendFragmentPresenter", "onResult", paramJSONObject1);
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
        yxp.d("WSRecommendFragmentPresenter", "setGdtArgs", paramString);
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
    paramString = new sls(new smt(paramString), this.jdField_a_of_type_AndroidOsHandler, new slx(this), 2001);
    sll.a().a(paramString);
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
        snb.d("WSAioLog", "rowKey:" + str1 + ", magActionData:" + paramString);
        localObject2 = snf.a();
        str2 = snf.jdField_a_of_type_JavaLangString;
        localObject1 = str2;
        if (localObject2 != null)
        {
          localObject1 = str2;
          if (TextUtils.isEmpty(str2)) {
            localObject1 = ((otm)localObject2).c();
          }
        }
        snb.a("WSAioLog", "getFeedList lastFeedId:" + (String)localObject1);
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          localArrayList.add(localObject1);
        }
        localObject1 = paramString;
      }
    }
    if (paramBoolean1) {
      this.jdField_a_of_type_JavaLangString = "";
    }
    snb.a("WSAioLog", "getFeedList isFirstFromService:" + paramBoolean2 + ", contentFeedIds:" + localArrayList);
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
      paramString = new sls(new smv(paramString, b1, (byte)i, localArrayList, 1, jdField_b_of_type_JavaLangString, str1, c, (String)localObject1), this.jdField_a_of_type_AndroidOsHandler, new slz(this, paramBoolean2, l, paramBoolean1, paramBoolean3), 1001);
      sll.a().a(paramString);
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
    otm localotm = snf.a();
    if (localotm != null) {
      bool = snf.a(localotm);
    }
    snb.b("WSRecommendFragmentPresenter", "isFromWeiShiPush = " + bool);
    if ((bool) && (sjv.a().a()) && (sjv.a().a() >= 8) && (sjv.a().b()))
    {
      a();
      return;
    }
    a(paramString, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     slw
 * JD-Core Version:    0.7.0.1
 */