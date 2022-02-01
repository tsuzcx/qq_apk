import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.AnimationSet;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseListView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.theme.TextHook;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class slt
  extends zur
  implements View.OnClickListener, View.OnLongClickListener
{
  public static float a;
  public static int a;
  static qgc jdField_a_of_type_Qgc = new qgc();
  public static int b;
  public static int e;
  public long a;
  protected Activity a;
  protected LayoutInflater a;
  protected ReadInJoyXListView a;
  public GdtHandler.Params a;
  private ArrayList<slh> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private HashMap<Integer, pen> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  public HashSet<String> a;
  protected Set<Long> a;
  private oau jdField_a_of_type_Oau;
  protected ped a;
  protected peo a;
  protected pey a;
  public pgd a;
  private pgf jdField_a_of_type_Pgf;
  protected pgg a;
  private pgx jdField_a_of_type_Pgx;
  protected phl a;
  protected rti a;
  private slh jdField_a_of_type_Slh;
  protected boolean a;
  public long b;
  public HashSet<String> b;
  public boolean b;
  protected int c;
  private long jdField_c_of_type_Long = -1L;
  private boolean jdField_c_of_type_Boolean;
  protected int d;
  
  static
  {
    jdField_a_of_type_Int = 20;
    jdField_b_of_type_Int = 250;
    e = 1000;
    jdField_a_of_type_Float = ViewConfiguration.getScrollFriction();
    if (Build.VERSION.SDK_INT < 21) {
      jdField_a_of_type_Float = 0.025F;
    }
  }
  
  public slt(Activity paramActivity, LayoutInflater paramLayoutInflater, int paramInt, ListView paramListView, SparseArray<prx> paramSparseArray)
  {
    this.jdField_c_of_type_Int = -1;
    this.jdField_a_of_type_Long = -2147483648L;
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
    this.jdField_b_of_type_JavaUtilHashSet = new HashSet();
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidViewLayoutInflater = paramLayoutInflater;
    this.jdField_c_of_type_Int = paramInt;
    paramLayoutInflater = new qle();
    paramLayoutInflater.setContext(paramActivity);
    paramLayoutInflater.setCurActivity(paramActivity);
    ozp.a(paramLayoutInflater, "default_feeds");
    jdField_a_of_type_Qgc.a(paramLayoutInflater);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView = ((ReadInJoyXListView)paramListView);
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_a_of_type_Pey = new pey();
    this.jdField_a_of_type_Pey.a(paramSparseArray, this);
    paramActivity = new pgv();
    paramActivity.a();
    paramSparseArray = new pgn();
    this.jdField_a_of_type_Ped = new ped(new peg().a(this.jdField_a_of_type_AndroidAppActivity).a(this.jdField_c_of_type_Int).a(this.jdField_a_of_type_Pey.a().a()).a(this.jdField_a_of_type_Pey.a().a()).a(this).a(this.jdField_a_of_type_Pey.a().a()).a(this.jdField_a_of_type_Pey.a().a()).a(this.jdField_a_of_type_Pey.a().a()).a(jdField_a_of_type_Qgc).a(paramActivity).a(paramLayoutInflater).a(paramSparseArray).a(this.jdField_a_of_type_Pey.a().a()));
    this.jdField_a_of_type_Pgg = new pgg(this.jdField_a_of_type_Ped);
    this.jdField_a_of_type_Phl = new phl(this.jdField_a_of_type_Ped);
    this.jdField_a_of_type_Pgx = new pgx(this.jdField_a_of_type_Ped);
    this.jdField_a_of_type_Pgf = new pgf(this);
    this.jdField_a_of_type_Pgd = new pgd(this.jdField_a_of_type_Ped);
    ((ReadInJoyXListView)paramListView).a(this.jdField_a_of_type_Pgd);
    ((ReadInJoyXListView)paramListView).a(this.jdField_a_of_type_Ped.a);
    ((ReadInJoyXListView)paramListView).setOnDrawCompleteListener(this.jdField_a_of_type_Ped.a());
    ((ReadInJoyXListView)paramListView).a(new pgc(this.jdField_a_of_type_Ped));
  }
  
  public static String a(ArticleInfo paramArticleInfo, int paramInt)
  {
    if ((jdField_a_of_type_Qgc != null) && (qgc.a(paramArticleInfo)))
    {
      paramArticleInfo = jdField_a_of_type_Qgc.a(paramArticleInfo);
      QLog.d("ReadInJoyBaseAdapter", 2, "getProteusFamilyCardViewType | dynamic viewType : " + paramArticleInfo);
      return paramArticleInfo;
    }
    paramArticleInfo = String.valueOf(pgb.a(paramArticleInfo, paramInt));
    QLog.d("ReadInJoyBaseAdapter", 2, "getProteusFamilyCardViewType | normal viewType : " + paramArticleInfo);
    return paramArticleInfo;
  }
  
  public static sdg a(BaseArticleInfo paramBaseArticleInfo)
  {
    return phe.a(paramBaseArticleInfo);
  }
  
  public static sdg a(BaseArticleInfo paramBaseArticleInfo, boolean paramBoolean)
  {
    return phe.a(paramBaseArticleInfo, paramBoolean);
  }
  
  private void a(BaseArticleInfo paramBaseArticleInfo, int paramInt)
  {
    if ((paramBaseArticleInfo != null) && (paramBaseArticleInfo.feedsFirstExposurePos == -1)) {
      paramBaseArticleInfo.feedsFirstExposurePos = paramInt;
    }
    uhv.a(paramBaseArticleInfo, uhv.e, false);
  }
  
  public int a()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public abstract int a(int paramInt);
  
  public long a()
  {
    return this.jdField_a_of_type_Pey.a().a();
  }
  
  public abstract Activity a();
  
  public Bitmap a(long paramLong)
  {
    return null;
  }
  
  public AnimationSet a()
  {
    return new pew(this.jdField_a_of_type_Ped).a();
  }
  
  public bjrb a()
  {
    return this.jdField_a_of_type_Ped.a().a().a(a());
  }
  
  public bjrh a()
  {
    return this.jdField_a_of_type_Ped.a().a().a(a());
  }
  
  public ArticleInfo a()
  {
    return this.jdField_a_of_type_Ped.a(a());
  }
  
  public abstract BaseArticleInfo a(int paramInt);
  
  public abstract BaseArticleInfo a(int paramInt, long paramLong);
  
  public VafContext a()
  {
    return this.jdField_a_of_type_Ped.a().a();
  }
  
  public FaceDecoder a()
  {
    return null;
  }
  
  public ListView a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView;
  }
  
  public String a(long paramLong)
  {
    return null;
  }
  
  public ArrayList<rcn> a()
  {
    return this.jdField_a_of_type_Ped.a().a();
  }
  
  public List<BaseArticleInfo> a()
  {
    return this.jdField_a_of_type_Ped.a();
  }
  
  public oau a()
  {
    return this.jdField_a_of_type_Oau;
  }
  
  public ped a()
  {
    return this.jdField_a_of_type_Ped;
  }
  
  public peo a()
  {
    return this.jdField_a_of_type_Peo;
  }
  
  public qgc a()
  {
    return this.jdField_a_of_type_Ped.a().b();
  }
  
  public rti a()
  {
    return this.jdField_a_of_type_Rti;
  }
  
  public sdc a()
  {
    return this.jdField_a_of_type_Pey.a().a();
  }
  
  public tch a()
  {
    return this.jdField_a_of_type_Ped.a().a().a(a(), this);
  }
  
  public twf a()
  {
    return this.jdField_a_of_type_Ped.a().a();
  }
  
  public void a()
  {
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_Ped.a();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.b();
    this.jdField_a_of_type_Ped.a().a().a();
    if (this.jdField_c_of_type_Int == 56) {
      rtr.a().a();
    }
    if (this.jdField_a_of_type_Rti != null) {
      this.jdField_a_of_type_Rti.d();
    }
    this.jdField_a_of_type_Pey.a().r();
  }
  
  public void a(int paramInt)
  {
    a(paramInt, true);
  }
  
  public void a(int paramInt, Intent paramIntent)
  {
    this.jdField_a_of_type_Pey.a().a(paramInt, paramIntent);
  }
  
  public abstract void a(int paramInt, BaseArticleInfo paramBaseArticleInfo, ArrayList<DislikeInfo> paramArrayList);
  
  public abstract void a(int paramInt, ArrayList<BaseArticleInfo> paramArrayList, ArrayList<DislikeInfo> paramArrayList1);
  
  public void a(int paramInt, ArrayList<BaseArticleInfo> paramArrayList, ArrayList<DislikeInfo> paramArrayList1, Object paramObject)
  {
    a(paramInt, paramArrayList, paramArrayList1, paramObject, false, true);
  }
  
  public void a(int paramInt, ArrayList<BaseArticleInfo> paramArrayList, ArrayList<DislikeInfo> paramArrayList1, Object paramObject, boolean paramBoolean)
  {
    a(paramInt, paramArrayList, paramArrayList1, paramObject, paramBoolean, true);
  }
  
  public void a(int paramInt, ArrayList<BaseArticleInfo> paramArrayList, ArrayList<DislikeInfo> paramArrayList1, Object paramObject, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_Ped.a(paramInt, paramArrayList, paramArrayList1, paramObject, paramBoolean1, paramBoolean2);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_Pey.a().b(paramInt, paramBoolean);
  }
  
  public void a(long paramLong)
  {
    this.jdField_c_of_type_Long = paramLong;
    this.jdField_a_of_type_Ped.a().a(this.jdField_c_of_type_Long);
  }
  
  public void a(AdvertisementInfo paramAdvertisementInfo)
  {
    if (paramAdvertisementInfo == null) {
      return;
    }
    g();
    this.jdField_a_of_type_Ped.a(paramAdvertisementInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView);
  }
  
  public void a(BaseArticleInfo paramBaseArticleInfo)
  {
    this.jdField_a_of_type_Ped.a().remove(paramBaseArticleInfo);
    notifyDataSetChanged();
    this.jdField_a_of_type_Ped.a().e(true);
  }
  
  public void a(BaseArticleInfo paramBaseArticleInfo1, BaseArticleInfo paramBaseArticleInfo2, boolean paramBoolean)
  {
    this.jdField_a_of_type_Ped.a(paramBaseArticleInfo1, paramBaseArticleInfo2, paramBoolean);
  }
  
  public void a(BaseArticleInfo paramBaseArticleInfo, pvc parampvc, long paramLong, int paramInt)
  {
    pei.a(paramBaseArticleInfo, parampvc, paramLong, paramInt, this.jdField_a_of_type_Ped);
  }
  
  public void a(ReadInJoyBaseListView paramReadInJoyBaseListView)
  {
    this.jdField_a_of_type_Pey.a(paramReadInJoyBaseListView);
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    this.jdField_a_of_type_Pey.a().b(paramAbsListView, paramInt);
  }
  
  public void a(List<BaseArticleInfo> paramList)
  {
    this.jdField_a_of_type_Ped.a(paramList);
    this.jdField_a_of_type_Pey.a(paramList);
  }
  
  public void a(List<ArticleInfo> paramList, int paramInt)
  {
    this.jdField_a_of_type_Ped.a(paramList, paramInt);
  }
  
  public void a(Set<Long> paramSet, Map<Long, rcn> paramMap)
  {
    this.jdField_a_of_type_Ped.a().a(paramSet, paramMap);
  }
  
  public void a(oau paramoau)
  {
    this.jdField_a_of_type_Oau = paramoau;
  }
  
  public void a(peo parampeo)
  {
    this.jdField_a_of_type_Peo = parampeo;
  }
  
  public void a(peu parampeu)
  {
    this.jdField_a_of_type_Ped.a().a(parampeu);
  }
  
  public void a(sdc paramsdc, rtp paramrtp)
  {
    this.jdField_a_of_type_Ped.a().a(paramsdc).a(paramrtp).a(this.jdField_a_of_type_Pey.a().a());
    this.jdField_a_of_type_Pey.a().a(paramsdc, paramrtp);
    paramsdc = this.jdField_a_of_type_Pey.a().a();
    if ((twr.a(a())) && (paramsdc != null))
    {
      this.jdField_a_of_type_Rti = new rti(this.jdField_a_of_type_AndroidAppActivity, this, paramsdc, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, a());
      this.jdField_a_of_type_Pey.a().a().a(this.jdField_a_of_type_Rti);
    }
  }
  
  public void a(sdg paramsdg)
  {
    if ((this.jdField_a_of_type_Ped.a().a().a(a()) != null) && (this.jdField_a_of_type_Ped.a().a().a(a()).isShowing())) {
      this.jdField_a_of_type_Ped.a().a().a(a()).dismiss();
    }
    if ((this.jdField_a_of_type_Ped.a().a().a(a()) != null) && (this.jdField_a_of_type_Ped.a().a().a(a()).isShowing())) {
      this.jdField_a_of_type_Ped.a().a().a(a()).dismiss();
    }
    this.jdField_a_of_type_Pey.a().a(paramsdg);
  }
  
  public void a(sdg paramsdg, int paramInt)
  {
    this.jdField_a_of_type_Pey.a().a(paramsdg, paramInt);
  }
  
  public void a(sdg paramsdg, BaseArticleInfo paramBaseArticleInfo)
  {
    a(paramsdg, paramBaseArticleInfo, false, true);
  }
  
  public void a(sdg paramsdg, BaseArticleInfo paramBaseArticleInfo, boolean paramBoolean1, boolean paramBoolean2)
  {
    phk.a(paramsdg, paramBaseArticleInfo, paramBoolean1, this.jdField_a_of_type_Ped);
  }
  
  public void a(sdg paramsdg1, sdg paramsdg2)
  {
    this.jdField_a_of_type_Pey.a().a(paramsdg1, paramsdg2);
  }
  
  public void a(sju paramsju, BaseArticleInfo paramBaseArticleInfo, int paramInt)
  {
    phe.a(paramsju, paramBaseArticleInfo, this.jdField_a_of_type_Ped, this, this);
  }
  
  public void a(sjv paramsjv, BaseArticleInfo paramBaseArticleInfo, int paramInt)
  {
    phe.a(paramsjv, paramBaseArticleInfo, this.jdField_a_of_type_Ped, this, this);
  }
  
  public void a(sjw paramsjw, BaseArticleInfo paramBaseArticleInfo, int paramInt)
  {
    phe.a(paramsjw, paramBaseArticleInfo, this.jdField_a_of_type_Ped, this, this);
  }
  
  public void a(sjx paramsjx, BaseArticleInfo paramBaseArticleInfo)
  {
    phe.a(paramsjx, paramBaseArticleInfo, this.jdField_a_of_type_Ped, this);
  }
  
  public void a(sjy paramsjy, BaseArticleInfo paramBaseArticleInfo, int paramInt)
  {
    phe.a(paramsjy, paramBaseArticleInfo, this.jdField_a_of_type_Ped, this, this, this.jdField_a_of_type_JavaUtilSet);
  }
  
  public void a(skd paramskd, BaseArticleInfo paramBaseArticleInfo, int paramInt)
  {
    phe.a(paramskd, paramBaseArticleInfo, this.jdField_a_of_type_Ped, this, this);
  }
  
  public void a(slh paramslh)
  {
    this.jdField_a_of_type_Slh = paramslh;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setNoteCardLifeCycle(paramslh);
    }
  }
  
  public void a(twf paramtwf)
  {
    this.jdField_a_of_type_Ped.a().a(paramtwf);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Ped.a().c(paramBoolean);
  }
  
  public void a(boolean paramBoolean, ArticleInfo paramArticleInfo1, ArticleInfo paramArticleInfo2, String paramString, Map<String, Object> paramMap)
  {
    phy.a(paramBoolean, paramArticleInfo1, paramArticleInfo2, paramString, paramMap, this.jdField_a_of_type_Ped);
  }
  
  public void a(boolean paramBoolean, BaseArticleInfo paramBaseArticleInfo)
  {
    phy.a(paramBoolean, paramBaseArticleInfo, a(), this.jdField_c_of_type_Int, this.jdField_c_of_type_Long);
  }
  
  public abstract boolean a();
  
  public boolean a(int paramInt)
  {
    return paramInt == 46;
  }
  
  public abstract boolean a(int paramInt, long paramLong);
  
  public int b()
  {
    return this.d;
  }
  
  public BaseArticleInfo b(int paramInt)
  {
    return this.jdField_a_of_type_Ped.a(paramInt);
  }
  
  public void b()
  {
    this.jdField_a_of_type_Pey.a().n();
  }
  
  public void b(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void b(BaseArticleInfo paramBaseArticleInfo)
  {
    phy.a(paramBaseArticleInfo, a(), this.jdField_c_of_type_Int);
  }
  
  public void b(AbsListView paramAbsListView, int paramInt)
  {
    this.jdField_a_of_type_Pey.a().c(paramAbsListView, paramInt);
  }
  
  public void b(List<BaseArticleInfo> paramList)
  {
    this.jdField_a_of_type_Ped.b(paramList);
  }
  
  public void b(slh paramslh)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(paramslh);
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Ped.a().f(paramBoolean);
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Ped.a().d();
  }
  
  public abstract boolean b(int paramInt, long paramLong);
  
  public void c()
  {
    this.jdField_a_of_type_Pey.a().k();
  }
  
  public void c(slh paramslh)
  {
    this.jdField_a_of_type_JavaUtilArrayList.remove(paramslh);
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_a_of_type_Ped.a().g(paramBoolean);
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_Ped.a().b();
  }
  
  public void d()
  {
    int k = 0;
    if (this.jdField_a_of_type_Rti != null) {
      this.jdField_a_of_type_Rti.b();
    }
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video_" + this.jdField_c_of_type_Int, 2, "ReadInJoyBaseAdapter doOnResume()");
    }
    if (bkwm.k()) {
      pei.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getFirstVisiblePosition(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getHeaderViewsCount(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildCount(), this.jdField_a_of_type_Ped);
    }
    this.jdField_a_of_type_Boolean = true;
    if (Build.VERSION.SDK_INT < 21) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setFriction(jdField_a_of_type_Float);
    }
    this.jdField_a_of_type_Pgd.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, 4);
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Ped.a().c(false);
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildCount()) {
        break;
      }
      View localView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildAt(i);
      if (((localView instanceof slf)) && (!((slf)localView).a()))
      {
        ((slf)localView).setIsResume(true);
        ((slf)localView).a();
      }
      i += 1;
    }
    while (j < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      ((slh)this.jdField_a_of_type_JavaUtilArrayList.get(j)).a();
      j += 1;
    }
    if (this.jdField_a_of_type_Slh != null) {
      this.jdField_a_of_type_Slh.a();
    }
    this.jdField_a_of_type_Pgx.a();
    this.jdField_a_of_type_Pgf.a();
  }
  
  public void d(boolean paramBoolean)
  {
    this.jdField_a_of_type_Ped.a().d(paramBoolean);
  }
  
  public boolean d()
  {
    return this.jdField_a_of_type_Ped.a().a();
  }
  
  public void e()
  {
    int k = 0;
    if (this.jdField_a_of_type_Rti != null) {
      this.jdField_a_of_type_Rti.c();
    }
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video_" + this.jdField_c_of_type_Int, 2, "ReadInJoyBaseAdapter doOnPause()");
    }
    this.jdField_a_of_type_Boolean = false;
    if ((this.jdField_a_of_type_Ped.a().a().a(a()) != null) && (this.jdField_a_of_type_Ped.a().a().a(a()).isShowing())) {
      this.jdField_a_of_type_Ped.a().a().a(a()).dismiss();
    }
    this.jdField_a_of_type_Pgd.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, 5);
    if ((!bkwm.p()) && (ozp.a(this.jdField_a_of_type_Ped.a().a(), "default_feeds")))
    {
      QLog.d("ReadInJoyBaseAdapter", 2, "hasRefresh notifyDataSetChanged");
      notifyDataSetChanged();
    }
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildCount()) {
        break;
      }
      View localView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildAt(i);
      if (((localView instanceof slf)) && (((slf)localView).a()))
      {
        ((slf)localView).setIsResume(false);
        ((slf)localView).b();
      }
      i += 1;
    }
    while (j < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      ((slh)this.jdField_a_of_type_JavaUtilArrayList.get(j)).b();
      j += 1;
    }
    if (this.jdField_a_of_type_Slh != null) {
      this.jdField_a_of_type_Slh.b();
    }
    this.jdField_a_of_type_Pgx.b();
    this.jdField_a_of_type_Pgf.b();
  }
  
  public boolean e()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public void f()
  {
    this.jdField_a_of_type_Pey.a().o();
  }
  
  public boolean f()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void g()
  {
    if ((this.jdField_a_of_type_Pey.a().a() != null) && (twr.a(this.jdField_c_of_type_Int))) {
      f();
    }
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_Ped.a();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_Ped.a(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return this.jdField_a_of_type_Ped.a(paramInt);
  }
  
  public int getItemViewType(int paramInt)
  {
    int j = a(paramInt);
    int i = j;
    if (this.jdField_a_of_type_Pey.a().a(j, paramInt)) {
      i = 119;
    }
    return i;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    bjun.a("ReadInJoyBaseAdapter.getView");
    System.currentTimeMillis();
    a(b(paramInt), paramInt);
    BaseArticleInfo localBaseArticleInfo = b(paramInt);
    int i = getItemViewType(paramInt);
    Object localObject = this.jdField_a_of_type_Ped.a((ArticleInfo)localBaseArticleInfo, i, paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyBaseAdapter", 2, "getView: " + localBaseArticleInfo + " type= " + i);
    }
    View localView = (View)psd.a(this.jdField_a_of_type_Pey.a(), new slu(this, "onAdapterGetView", i, localBaseArticleInfo, paramInt, paramView, paramViewGroup));
    this.jdField_a_of_type_Pey.a(localView, paramView, localBaseArticleInfo, paramInt);
    if (localView != null)
    {
      pei.a(localBaseArticleInfo, (pvc)localObject, System.currentTimeMillis(), paramInt, this.jdField_a_of_type_Ped);
      localObject = super.a(localView, paramInt);
      pei.a((View)localObject, i, localBaseArticleInfo, this.jdField_a_of_type_Ped);
      TextHook.updateFont(paramView);
      bjun.a();
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localObject;
      QLog.d("ReadInJoyBaseAdapter", 1, "get view has error, return then convert view， viewType : " + i);
      localObject = paramView;
    }
  }
  
  public int getViewTypeCount()
  {
    return jdField_a_of_type_Qgc.a() + 147 + qmh.a();
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.c(7);
    }
  }
  
  public void i()
  {
    this.jdField_a_of_type_Ped.b();
  }
  
  public boolean isEmpty()
  {
    return this.jdField_a_of_type_Ped.a().isEmpty();
  }
  
  public void j()
  {
    this.jdField_a_of_type_Pey.a().h();
  }
  
  public void notifyDataSetChanged()
  {
    super.notifyDataSetChanged();
    this.jdField_a_of_type_Pey.g();
  }
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_AndroidAppActivity instanceof ReadInJoyFeedsActivity)) {
      ((ReadInJoyFeedsActivity)this.jdField_a_of_type_AndroidAppActivity).b(16);
    }
    pen localpen = (pen)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramView.getId()));
    if (localpen != null) {
      localpen.onClick(paramView);
    }
    for (;;)
    {
      this.jdField_a_of_type_Pgg.a(paramView);
      this.jdField_a_of_type_Phl.a(paramView);
      this.jdField_a_of_type_Pey.a().onClick(paramView);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      QLog.e("ReadInJoyBaseAdapter", 1, "onClick, has no click handler for id(" + paramView.getId() + "}");
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    return this.jdField_a_of_type_Phl.a(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     slt
 * JD-Core Version:    0.7.0.1
 */