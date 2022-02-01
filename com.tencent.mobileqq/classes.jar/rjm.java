import android.text.TextUtils;
import android.view.View;
import android.widget.Adapter;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.report.UserActionCollector.1;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.util.WeakReference;

public class rjm
{
  public static double a;
  public static int a;
  public static String a;
  private static volatile rjm jdField_a_of_type_Rjm;
  public static int b;
  public static String b;
  public static int c;
  public static int d;
  public static int e;
  public static int f;
  public static int g;
  public long a;
  private ArrayList<Integer> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public HashMap<String, Long> a;
  public List<rjn> a;
  private WeakReference<AbsListView> jdField_a_of_type_MqqUtilWeakReference;
  public rjq a;
  public boolean a;
  public int[] a;
  public long b;
  private HashMap<String, Integer> jdField_b_of_type_JavaUtilHashMap = new HashMap();
  public List<rjp> b;
  private boolean jdField_b_of_type_Boolean;
  private int[] jdField_b_of_type_ArrayOfInt;
  public long c;
  private String c;
  private long d;
  private long e;
  private long f;
  private long g;
  public int h;
  public int i;
  private int j;
  
  static
  {
    jdField_a_of_type_Double = 0.5D;
    jdField_a_of_type_Int = 5;
    jdField_b_of_type_Int = 20;
    jdField_c_of_type_Int = 10;
    jdField_a_of_type_JavaLangString = "sp_mix_feature_click_info";
    jdField_b_of_type_JavaLangString = "sp_mix_feature_scroll_info";
    jdField_d_of_type_Int = 1;
    jdField_e_of_type_Int = 2;
    jdField_f_of_type_Int = 3;
    jdField_g_of_type_Int = 4;
  }
  
  private rjm()
  {
    this.jdField_a_of_type_Rjq = new rjq(this);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_g_of_type_Long = -1L;
    this.jdField_a_of_type_ArrayOfInt = new int[2];
    if (Aladdin.getConfig(234).getIntegerFromString("fbs_enable", 0) == 1) {}
    for (;;)
    {
      this.jdField_b_of_type_Boolean = bool;
      if (this.jdField_b_of_type_Boolean) {
        break;
      }
      return;
      bool = false;
    }
    try
    {
      String str = (String)bmhv.a(jdField_a_of_type_JavaLangString, "");
      Object localObject2;
      if (!TextUtils.isEmpty(str))
      {
        localObject1 = str.split("_");
        int m = localObject1.length;
        while (k < m)
        {
          localObject2 = localObject1[k];
          this.jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf((String)localObject2));
          k += 1;
        }
      }
      Object localObject1 = (String)bmhv.a(jdField_b_of_type_JavaLangString, "");
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (((String)localObject1).split("_").length == 4))
      {
        localObject2 = ((String)localObject1).split("_");
        this.jdField_b_of_type_ArrayOfInt = new int[4];
        this.jdField_b_of_type_ArrayOfInt[0] = Integer.valueOf(localObject2[0]).intValue();
        this.jdField_b_of_type_ArrayOfInt[1] = Integer.valueOf(localObject2[1]).intValue();
        this.jdField_b_of_type_ArrayOfInt[2] = Integer.valueOf(localObject2[2]).intValue();
        this.jdField_b_of_type_ArrayOfInt[3] = Integer.valueOf(localObject2[3]).intValue();
      }
      QLog.d("UserActionCollector", 1, "clickStr : " + str + ", scrollStr : " + (String)localObject1);
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      localNumberFormatException.printStackTrace();
      bmhv.a(jdField_a_of_type_JavaLangString, "");
      bmhv.a(jdField_b_of_type_JavaLangString, "");
    }
  }
  
  private int a(View paramView, int paramInt)
  {
    int k = paramView.getHeight();
    double d1 = paramView.getTop();
    k = (int)(k * jdField_a_of_type_Double + d1);
    if (k <= paramInt)
    {
      paramInt = k;
      if (k > 0) {}
    }
    else
    {
      paramInt = -1;
    }
    return paramInt;
  }
  
  private Object a(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramAbsListView == null) || (paramInt < 0) || (paramAbsListView.getAdapter() == null)) {}
    do
    {
      return null;
      paramAbsListView = paramAbsListView.getAdapter();
    } while (paramInt >= paramAbsListView.getCount());
    try
    {
      paramAbsListView = paramAbsListView.getItem(paramInt);
      return paramAbsListView;
    }
    catch (Exception paramAbsListView)
    {
      paramAbsListView.printStackTrace();
    }
    return null;
  }
  
  private String a(BaseArticleInfo paramBaseArticleInfo)
  {
    String str2 = paramBaseArticleInfo.innerUniqueID;
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "AD_" + paramBaseArticleInfo.mTitle;
    }
    return str1;
  }
  
  public static rjm a()
  {
    if (jdField_a_of_type_Rjm == null) {}
    try
    {
      if (jdField_a_of_type_Rjm == null) {
        jdField_a_of_type_Rjm = new rjm();
      }
      return jdField_a_of_type_Rjm;
    }
    finally {}
  }
  
  private void a(AbsListView paramAbsListView, boolean paramBoolean)
  {
    if (paramAbsListView == null) {
      return;
    }
    int n = paramAbsListView.getFirstVisiblePosition();
    if (this.jdField_g_of_type_Long != -1L) {}
    Object localObject1;
    View localView;
    for (long l1 = System.currentTimeMillis() - this.jdField_g_of_type_Long;; l1 = System.currentTimeMillis() - this.jdField_a_of_type_Long)
    {
      int k = 0;
      for (;;)
      {
        if (k >= paramAbsListView.getChildCount()) {
          break label527;
        }
        localObject1 = a(paramAbsListView, n + k);
        localView = paramAbsListView.getChildAt(k);
        if (((localObject1 instanceof BaseArticleInfo)) && (localView != null)) {
          break;
        }
        k += 1;
      }
    }
    int i1 = a(localView, paramAbsListView.getHeight());
    Object localObject2 = (BaseArticleInfo)localObject1;
    String str = a((BaseArticleInfo)localObject2);
    long l3;
    if (this.jdField_b_of_type_JavaUtilHashMap.containsKey(str))
    {
      localObject1 = (rjn)this.jdField_a_of_type_JavaUtilList.get(((Integer)this.jdField_b_of_type_JavaUtilHashMap.get(str)).intValue());
      l3 = ((rjn)localObject1).jdField_b_of_type_Long;
      if (i1 <= 0) {
        break label521;
      }
    }
    label521:
    for (long l2 = l1;; l2 = 0L)
    {
      ((rjn)localObject1).jdField_b_of_type_Long = (l2 + l3);
      localObject2 = a(localView);
      if ((localObject2 != null) && (localObject2[1] - localObject2[0] >= localView.getHeight() * jdField_a_of_type_Double)) {
        ((rjn)localObject1).jdField_c_of_type_Long += l1;
      }
      ((rjn)localObject1).jdField_c_of_type_Boolean = this.jdField_a_of_type_JavaUtilHashMap.containsKey(str);
      if (!paramBoolean) {
        break;
      }
      ((rjn)localObject1).jdField_b_of_type_Boolean = true;
      break;
      localObject1 = new rjn(this);
      ((rjn)localObject1).jdField_a_of_type_JavaLangString = str;
      ((rjn)localObject1).jdField_a_of_type_Int = pqw.a((BaseArticleInfo)localObject2);
      int m;
      label305:
      boolean bool;
      if (TextUtils.isEmpty(((BaseArticleInfo)localObject2).mTitle))
      {
        m = 0;
        ((rjn)localObject1).jdField_b_of_type_Int = m;
        if (this.jdField_g_of_type_Long != -1L) {
          break label504;
        }
        bool = true;
        label326:
        ((rjn)localObject1).jdField_a_of_type_Boolean = bool;
        ((rjn)localObject1).jdField_c_of_type_Int = localView.getHeight();
        ((rjn)localObject1).jdField_b_of_type_JavaLangString = ((BaseArticleInfo)localObject2).mRecommentdReason;
        m = this.j;
        this.j = (m + 1);
        ((rjn)localObject1).jdField_d_of_type_Int = m;
        localObject2 = pkk.a().a();
        if ((localObject2 == null) || (localObject2.length != 4)) {
          break label510;
        }
      }
      label504:
      label510:
      for (((rjn)localObject1).jdField_c_of_type_JavaLangString = (localObject2[0] + "_" + localObject2[1] + "_" + localObject2[2] + "_" + localObject2[3]);; ((rjn)localObject1).jdField_c_of_type_JavaLangString = "NULL")
      {
        this.jdField_a_of_type_JavaUtilList.add(localObject1);
        this.jdField_b_of_type_JavaUtilHashMap.put(str, Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size() - 1));
        break;
        m = ((BaseArticleInfo)localObject2).mTitle.length();
        break label305;
        bool = false;
        break label326;
      }
    }
    label527:
    this.jdField_g_of_type_Long = System.currentTimeMillis();
  }
  
  private int[] a(View paramView)
  {
    int[] arrayOfInt = a();
    int k;
    if (paramView.getTop() < 0)
    {
      k = 0;
      if (paramView.getBottom() <= this.i) {
        break label57;
      }
    }
    label57:
    for (int m = this.i;; m = paramView.getBottom())
    {
      if ((m > arrayOfInt[0]) && (arrayOfInt[1] > k)) {
        break label65;
      }
      return null;
      k = paramView.getTop();
      break;
    }
    label65:
    return new int[] { Math.max(k, arrayOfInt[0]), Math.min(m, arrayOfInt[1]) };
  }
  
  private void e()
  {
    int k = 0;
    String str;
    if (this.jdField_b_of_type_ArrayOfInt != null)
    {
      str = this.jdField_b_of_type_ArrayOfInt[0] + "_" + this.jdField_b_of_type_ArrayOfInt[1] + "_" + this.jdField_b_of_type_ArrayOfInt[2] + "_" + this.jdField_b_of_type_ArrayOfInt[3];
      bmhv.a(jdField_b_of_type_JavaLangString, str);
    }
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList.size() > jdField_b_of_type_Int) {
        k = this.jdField_a_of_type_JavaUtilArrayList.size() - jdField_b_of_type_Int;
      }
      str = TextUtils.join("_", this.jdField_a_of_type_JavaUtilArrayList.subList(k, this.jdField_a_of_type_JavaUtilArrayList.size()));
      bmhv.a(jdField_a_of_type_JavaLangString, str);
    }
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_Rjq.jdField_a_of_type_Long == 0L) {
      return this.jdField_e_of_type_Long;
    }
    return this.jdField_a_of_type_Rjq.jdField_a_of_type_Long - this.jdField_a_of_type_Long;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Long == 0L) || (this.jdField_f_of_type_Long == 0L) || (!this.jdField_b_of_type_Boolean)) {
      return;
    }
    long l = System.currentTimeMillis() - this.jdField_f_of_type_Long;
    this.jdField_e_of_type_Long += l;
    if ((this.jdField_d_of_type_Long != 0L) && (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) && (this.jdField_b_of_type_JavaUtilHashMap.containsKey(this.jdField_c_of_type_JavaLangString)))
    {
      int k = ((Integer)this.jdField_b_of_type_JavaUtilHashMap.get(this.jdField_c_of_type_JavaLangString)).intValue();
      rjn localrjn = (rjn)this.jdField_a_of_type_JavaUtilList.get(k);
      localrjn.jdField_a_of_type_Long = (l + localrjn.jdField_a_of_type_Long);
      this.jdField_d_of_type_Long = 0L;
      this.jdField_c_of_type_JavaLangString = null;
    }
    this.jdField_f_of_type_Long = 0L;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (!this.jdField_b_of_type_Boolean) {
      return;
    }
    QLog.d("UserActionCollector", 1, "enterBusiness, from : " + paramInt1 + ", scene : " + paramInt2);
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.h = paramInt1;
    this.jdField_b_of_type_Long = paramInt2;
    pkk.a().a();
  }
  
  public void a(View paramView, AbsListView paramAbsListView, BaseArticleInfo paramBaseArticleInfo)
  {
    if ((this.jdField_a_of_type_Long == 0L) || (paramBaseArticleInfo == null) || (!this.jdField_b_of_type_Boolean)) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    paramView = a(paramBaseArticleInfo);
    if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramView)) {
      this.jdField_a_of_type_JavaUtilHashMap.put(paramView, Long.valueOf(0L));
    }
    paramBaseArticleInfo = new float[2];
    paramBaseArticleInfo[0] = ((ReadInJoyXListView)paramAbsListView).b[0];
    paramBaseArticleInfo[1] = (((ReadInJoyXListView)paramAbsListView).b[1] - paramAbsListView.getPaddingTop());
    paramAbsListView = new rjp(this);
    paramAbsListView.jdField_b_of_type_JavaLangString = ((int)paramBaseArticleInfo[0] + "_" + (int)paramBaseArticleInfo[1]);
    this.jdField_b_of_type_JavaUtilList.add(paramAbsListView);
    if (paramBaseArticleInfo[1] > 0.0F) {
      this.jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf((int)paramBaseArticleInfo[1]));
    }
    this.jdField_c_of_type_JavaLangString = paramView;
    this.jdField_d_of_type_Long = System.currentTimeMillis();
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramAbsListView == null) || ((this.jdField_a_of_type_MqqUtilWeakReference != null) && (paramAbsListView == this.jdField_a_of_type_MqqUtilWeakReference.get())) || (!this.jdField_b_of_type_Boolean)) {
      return;
    }
    QLog.d("UserActionCollector", 1, "register listview : " + paramAbsListView);
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramAbsListView);
    this.i = ScreenUtil.getInstantScreenHeight(paramAbsListView.getContext());
    ((ReadInJoyXListView)paramAbsListView).a(this.jdField_a_of_type_Rjq);
    paramAbsListView.post(new UserActionCollector.1(this, paramInt, paramAbsListView));
  }
  
  public int[] a()
  {
    if ((this.jdField_g_of_type_Long == 0L) || (this.jdField_a_of_type_ArrayOfInt == null)) {
      return new int[] { 0, (int)(this.i * 2 / 3.0F) };
    }
    return this.jdField_a_of_type_ArrayOfInt;
  }
  
  public long b()
  {
    if (this.jdField_a_of_type_Rjq.jdField_b_of_type_Long == 0L) {
      return this.jdField_e_of_type_Long;
    }
    return this.jdField_c_of_type_Long - this.jdField_a_of_type_Rjq.jdField_b_of_type_Long;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Long == 0L) || (!this.jdField_b_of_type_Boolean)) {
      return;
    }
    this.jdField_f_of_type_Long = System.currentTimeMillis();
    if (this.jdField_a_of_type_MqqUtilWeakReference != null) {}
    for (AbsListView localAbsListView = (AbsListView)this.jdField_a_of_type_MqqUtilWeakReference.get();; localAbsListView = null)
    {
      a(localAbsListView, false);
      return;
    }
  }
  
  public long c()
  {
    return this.jdField_e_of_type_Long;
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_Long == 0L) || (this.jdField_a_of_type_MqqUtilWeakReference == null) || (!this.jdField_b_of_type_Boolean)) {
      return;
    }
    QLog.d("UserActionCollector", 1, "exitBusiness !");
    pkk.a().b();
    this.jdField_c_of_type_Long = System.currentTimeMillis();
    this.jdField_e_of_type_Long = (this.jdField_c_of_type_Long - this.jdField_a_of_type_Long - this.jdField_e_of_type_Long);
    a((AbsListView)this.jdField_a_of_type_MqqUtilWeakReference.get(), true);
    new qia(null, null, null, qxn.a(), null).a(this, BaseApplication.getContext());
    e();
    this.jdField_a_of_type_MqqUtilWeakReference = null;
    jdField_a_of_type_Rjm = null;
  }
  
  public void d()
  {
    float f1 = 0.0F;
    this.jdField_a_of_type_ArrayOfInt = new int[2];
    int k;
    int m;
    int n;
    int[] arrayOfInt;
    if (this.jdField_a_of_type_JavaUtilArrayList.size() < jdField_a_of_type_Int)
    {
      if (this.jdField_b_of_type_ArrayOfInt == null)
      {
        this.jdField_a_of_type_ArrayOfInt[0] = 0;
        this.jdField_a_of_type_ArrayOfInt[1] = ((int)(this.i * 2 / 3.0F));
        k = 0;
        QLog.d("UserActionCollector", 1, "listViewHeight : " + this.i + ", az[0] : " + this.jdField_a_of_type_ArrayOfInt[0] + ", az[1] : " + this.jdField_a_of_type_ArrayOfInt[1] + ", rule : " + k);
        return;
      }
      k = (int)(Math.min(this.jdField_b_of_type_ArrayOfInt[1], this.jdField_b_of_type_ArrayOfInt[3]) - this.i / 8.0F);
      m = (int)(Math.max(this.jdField_b_of_type_ArrayOfInt[1], this.jdField_b_of_type_ArrayOfInt[3]) + this.i / 8.0F);
      n = (k + m) / 2;
      if (m - k > this.i / 2.0F)
      {
        arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
        if (n - this.i / 4.0F < 0.0F)
        {
          label228:
          arrayOfInt[0] = ((int)f1);
          arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
          if (n + this.i / 4.0F <= this.i) {
            break label296;
          }
          f1 = this.i;
          label268:
          arrayOfInt[1] = ((int)f1);
        }
      }
      for (;;)
      {
        k = 1;
        break;
        f1 = n - this.i / 4.0F;
        break label228;
        label296:
        f1 = n + this.i / 4.0F;
        break label268;
        this.jdField_a_of_type_ArrayOfInt[0] = k;
        this.jdField_a_of_type_ArrayOfInt[1] = m;
      }
    }
    label348:
    int i1;
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > jdField_b_of_type_Int)
    {
      n = jdField_b_of_type_Int;
      arrayOfInt = new int[jdField_c_of_type_Int];
      i1 = (int)(this.i * 1.0F / jdField_c_of_type_Int + 0.5F);
      if (i1 > 0) {
        break label616;
      }
      i1 = 1;
    }
    label398:
    label605:
    label616:
    for (;;)
    {
      int i5 = this.jdField_a_of_type_JavaUtilArrayList.size();
      int i2 = 0;
      m = 0;
      k = 0;
      int i3;
      if (i2 < n)
      {
        i3 = ((Integer)this.jdField_a_of_type_JavaUtilArrayList.get(i5 - 1 - i2)).intValue() / i1 % jdField_c_of_type_Int;
        int i4 = arrayOfInt[i3] + 1;
        arrayOfInt[i3] = i4;
        if (i4 <= k) {
          break label605;
        }
        m = i4;
        k = i3;
      }
      for (;;)
      {
        i3 = i2 + 1;
        i2 = m;
        m = k;
        k = i2;
        i2 = i3;
        break label398;
        n = this.jdField_a_of_type_JavaUtilArrayList.size();
        break label348;
        k = (m + 1) * i1 + i1 / 2;
        this.jdField_a_of_type_ArrayOfInt[0] = (k - this.i / 4);
        if (this.jdField_a_of_type_ArrayOfInt[0] < 0) {
          this.jdField_a_of_type_ArrayOfInt[0] = 0;
        }
        this.jdField_a_of_type_ArrayOfInt[1] = (this.i / 4 + k);
        if (this.jdField_a_of_type_ArrayOfInt[1] > this.i) {
          this.jdField_a_of_type_ArrayOfInt[1] = this.i;
        }
        QLog.d("UserActionCollector", 1, "calculate az, centerY : " + k);
        k = 2;
        break;
        i3 = k;
        k = m;
        m = i3;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rjm
 * JD-Core Version:    0.7.0.1
 */