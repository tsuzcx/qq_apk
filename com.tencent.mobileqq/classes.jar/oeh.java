import android.app.Activity;
import android.os.SystemClock;
import com.tencent.biz.pubaccount.readinjoy.ad.utils.ReadInJoyPatchAdUtils.1;
import com.tencent.biz.pubaccount.readinjoy.ad.utils.ReadInJoyPatchAdUtils.2;
import com.tencent.biz.pubaccount.readinjoy.ad.view.ReadInJoyPatchAdView;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

public class oeh
{
  public static int a;
  public static long a;
  public static String a;
  public static boolean a;
  public static int b;
  public static long b;
  public static boolean b;
  public static boolean c;
  
  static
  {
    jdField_a_of_type_JavaLangString = "ReadInJoyPatchAdUtils";
    jdField_b_of_type_Int = 3;
  }
  
  public static int a(JSONObject paramJSONObject)
  {
    return paramJSONObject.optInt("patchAdDisplaySeconds");
  }
  
  public static AdvertisementInfo a(int paramInt)
  {
    ArrayBlockingQueue localArrayBlockingQueue2;
    ArrayBlockingQueue localArrayBlockingQueue1;
    if (paramInt == 1)
    {
      localArrayBlockingQueue2 = owy.a().a().a();
      localArrayBlockingQueue1 = localArrayBlockingQueue2;
      if (localArrayBlockingQueue2.size() <= 2)
      {
        a(1);
        localArrayBlockingQueue1 = localArrayBlockingQueue2;
      }
      if (localArrayBlockingQueue1 != null) {
        break label66;
      }
    }
    label66:
    while (localArrayBlockingQueue1.size() <= 0)
    {
      return null;
      localArrayBlockingQueue2 = owy.a().a().b();
      localArrayBlockingQueue1 = localArrayBlockingQueue2;
      if (localArrayBlockingQueue2.size() > 2) {
        break;
      }
      a(2);
      localArrayBlockingQueue1 = localArrayBlockingQueue2;
      break;
    }
    return (AdvertisementInfo)localArrayBlockingQueue1.poll();
  }
  
  public static void a()
  {
    jdField_a_of_type_Long = jdField_b_of_type_Long;
    jdField_b_of_type_Long = SystemClock.elapsedRealtime();
  }
  
  public static void a(int paramInt)
  {
    nnv localnnv = new nnv();
    localnnv.d = 1;
    if (paramInt == 1)
    {
      localnnv.e = 3;
      localnnv.f = 0;
    }
    for (;;)
    {
      ThreadManager.executeOnSubThread(new ReadInJoyPatchAdUtils.2(localnnv));
      return;
      localnnv.f = 3;
      localnnv.e = 0;
    }
  }
  
  public static void a(Activity paramActivity, rkp paramrkp, rjg paramrjg, rja paramrja, rkv paramrkv, oej paramoej)
  {
    ReadInJoyPatchAdView localReadInJoyPatchAdView = paramrkp.a();
    if (localReadInJoyPatchAdView == null) {
      return;
    }
    localReadInJoyPatchAdView.setOnPatchAdListener(new oei(localReadInJoyPatchAdView, paramActivity, paramrkp, paramrjg, paramrkv, paramrja, paramoej));
  }
  
  public static void a(rjk paramrjk, int paramInt1, int paramInt2)
  {
    if (paramInt1 == 1)
    {
      paramrjk.a.patchStatus.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(paramInt2);
      return;
    }
    paramrjk.a.patchStatus.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(paramInt2);
  }
  
  public static void a(rjk paramrjk, rkp paramrkp, boolean paramBoolean, oej paramoej)
  {
    int j = 0;
    rkp localrkp = null;
    if (!b(paramrjk, paramrkp)) {}
    for (int i = 0;; i = 1)
    {
      if (i != 0) {
        if (paramBoolean)
        {
          paramrkp = paramrkp.a().a;
          localrkp = paramrkp;
          if (paramrkp != null) {
            break label71;
          }
          i = j;
        }
      }
      for (;;)
      {
        if ((i != 0) && (paramoej != null)) {
          paramoej.a(paramrjk, paramrkp);
        }
        return;
        paramrkp = a(1);
        break;
        label71:
        paramrkp = localrkp;
      }
    }
  }
  
  public static void a(rjk paramrjk, rkp paramrkp, boolean paramBoolean1, boolean paramBoolean2, rkv paramrkv, rja paramrja, oej paramoej)
  {
    int j = 1;
    Object localObject = null;
    if (!a(paramrjk, paramrkp)) {
      j = 0;
    }
    int i = j;
    if (paramBoolean1)
    {
      i = j;
      if (c) {
        i = 0;
      }
    }
    j = i;
    AdvertisementInfo localAdvertisementInfo;
    if (i != 0)
    {
      if (!paramBoolean2) {
        break label116;
      }
      localAdvertisementInfo = paramrkp.a().a;
      if ((localAdvertisementInfo != null) && (localAdvertisementInfo.mAdExtInfo != null))
      {
        localObject = localAdvertisementInfo;
        j = i;
        if (a(localAdvertisementInfo.mAdExtInfo, 2)) {}
      }
      else
      {
        j = 0;
        localObject = localAdvertisementInfo;
      }
    }
    if (j != 0) {
      paramoej.b(paramrjk, localObject);
    }
    label116:
    while (paramrkv == null)
    {
      return;
      localAdvertisementInfo = a(2);
      break;
    }
    paramrkv.a(paramrkp.a());
    paramrja.c();
  }
  
  public static void a(rkp paramrkp)
  {
    if (paramrkp.a() != null)
    {
      paramrkp.a().setVisibility(8);
      paramrkp.a().a();
    }
  }
  
  public static boolean a(BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramBaseArticleInfo == null) {}
    while ((!paramBaseArticleInfo.patchStatus.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) || (paramBaseArticleInfo.patchStatus.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 3) || (paramBaseArticleInfo.patchStatus.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 0)) {
      return false;
    }
    return true;
  }
  
  public static boolean a(String paramString, int paramInt)
  {
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString == null) {
        return false;
      }
    }
    catch (Exception paramString)
    {
      do
      {
        do
        {
          for (;;)
          {
            paramString.printStackTrace();
            paramString = null;
          }
        } while (paramString.optInt("patchAdType") != paramInt);
        paramInt = paramString.optInt("patchAdLimitMinutes");
      } while (SystemClock.elapsedRealtime() - jdField_b_of_type_Long < paramInt * 60000);
    }
    return true;
  }
  
  public static boolean a(rjk paramrjk)
  {
    if ((paramrjk == null) || (paramrjk.a == null)) {}
    while (paramrjk.jdField_b_of_type_Long != 56L) {
      return false;
    }
    return true;
  }
  
  public static boolean a(rjk paramrjk, rkp paramrkp)
  {
    int i = paramrjk.a.patchStatus.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
    if ((i != 0) && (i != 2)) {
      return false;
    }
    return c(paramrjk, paramrkp);
  }
  
  public static boolean a(rkp paramrkp)
  {
    if ((paramrkp == null) || (paramrkp.a() == null)) {}
    while ((paramrkp.a() == null) || (paramrkp.a().getVisibility() != 0)) {
      return false;
    }
    return true;
  }
  
  public static void b()
  {
    jdField_b_of_type_Long = jdField_a_of_type_Long;
  }
  
  public static boolean b(BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramBaseArticleInfo == null) {}
    while ((!paramBaseArticleInfo.patchStatus.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) || (paramBaseArticleInfo.patchStatus.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 3)) {
      return false;
    }
    return true;
  }
  
  public static boolean b(rjk paramrjk, rkp paramrkp)
  {
    int i = paramrjk.a.patchStatus.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
    if ((i != 0) && (i != 2)) {
      return false;
    }
    return c(paramrjk, paramrkp);
  }
  
  public static void c()
  {
    Object localObject = owy.a().a().b();
    ArrayBlockingQueue localArrayBlockingQueue = owy.a().a().a();
    if ((((ArrayBlockingQueue)localObject).size() <= 2) || (localArrayBlockingQueue.size() <= 2))
    {
      localObject = new nnv();
      ((nnv)localObject).d = 1;
      ((nnv)localObject).e = 3;
      ((nnv)localObject).f = 3;
      ThreadManager.executeOnSubThread(new ReadInJoyPatchAdUtils.1((nnv)localObject));
    }
  }
  
  public static boolean c(BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramBaseArticleInfo == null) {}
    while ((paramBaseArticleInfo.patchStatus.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) || (paramBaseArticleInfo.patchStatus.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 2) || (paramBaseArticleInfo.patchStatus.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 0)) {
      return false;
    }
    return true;
  }
  
  private static boolean c(rjk paramrjk, rkp paramrkp)
  {
    if (paramrjk.jdField_b_of_type_Int <= 30) {}
    while ((paramrjk.a.mChannelID != 56L) || (paramrjk.jdField_b_of_type_Boolean) || ((paramrkp != null) && (paramrkp.a()))) {
      return false;
    }
    return true;
  }
  
  public static boolean d(BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramBaseArticleInfo == null) {}
    while ((paramBaseArticleInfo.patchStatus.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) || (paramBaseArticleInfo.patchStatus.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 2)) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     oeh
 * JD-Core Version:    0.7.0.1
 */