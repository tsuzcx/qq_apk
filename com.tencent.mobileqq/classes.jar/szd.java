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

public abstract class szd
  extends aakd
  implements View.OnClickListener, View.OnLongClickListener
{
  public static float a;
  public static int a;
  static qsf jdField_a_of_type_Qsf = new qsf();
  public static int b;
  public static int e;
  public long a;
  protected Activity a;
  protected LayoutInflater a;
  protected ReadInJoyXListView a;
  public GdtHandler.Params a;
  private ArrayList<syr> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private HashMap<Integer, pnq> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  public HashSet<String> a;
  protected Set<Long> a;
  private oil jdField_a_of_type_Oil;
  protected pne a;
  protected pnr a;
  protected pob a;
  public ppg a;
  private ppi jdField_a_of_type_Ppi;
  protected ppk a;
  private pqi jdField_a_of_type_Pqi;
  protected psf a;
  protected sfx a;
  private syr jdField_a_of_type_Syr;
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
  
  public szd(Activity paramActivity, LayoutInflater paramLayoutInflater, int paramInt, ListView paramListView, SparseArray<qcu> paramSparseArray)
  {
    this.jdField_c_of_type_Int = -1;
    this.jdField_a_of_type_Long = -2147483648L;
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
    this.jdField_b_of_type_JavaUtilHashSet = new HashSet();
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidViewLayoutInflater = paramLayoutInflater;
    this.jdField_c_of_type_Int = paramInt;
    paramLayoutInflater = new qxj();
    paramLayoutInflater.setContext(paramActivity);
    paramLayoutInflater.setCurActivity(paramActivity);
    piv.a(paramLayoutInflater, "default_feeds");
    jdField_a_of_type_Qsf.a(paramLayoutInflater);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView = ((ReadInJoyXListView)paramListView);
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_a_of_type_Pob = new pob();
    this.jdField_a_of_type_Pob.a(paramSparseArray, this);
    paramActivity = new ppz();
    paramActivity.a();
    paramSparseArray = new ppr();
    this.jdField_a_of_type_Pne = new pne(new pnh().a(this.jdField_a_of_type_AndroidAppActivity).a(this.jdField_c_of_type_Int).a(this.jdField_a_of_type_Pob.a().a()).a(this.jdField_a_of_type_Pob.a().a()).a(this).a(this.jdField_a_of_type_Pob.a().a()).a(this.jdField_a_of_type_Pob.a().a()).a(this.jdField_a_of_type_Pob.a().a()).a(jdField_a_of_type_Qsf).a(paramActivity).a(paramLayoutInflater).a(paramSparseArray).a(this.jdField_a_of_type_Pob.a().a()));
    this.jdField_a_of_type_Ppk = new ppk(this.jdField_a_of_type_Pne);
    this.jdField_a_of_type_Psf = new psf(this.jdField_a_of_type_Pne);
    this.jdField_a_of_type_Pqi = new pqi(this.jdField_a_of_type_Pne);
    this.jdField_a_of_type_Ppi = new ppi(this);
    this.jdField_a_of_type_Ppg = new ppg(this.jdField_a_of_type_Pne);
    ((ReadInJoyXListView)paramListView).a(this.jdField_a_of_type_Ppg);
    ((ReadInJoyXListView)paramListView).a(this.jdField_a_of_type_Pne.a);
    ((ReadInJoyXListView)paramListView).setOnDrawCompleteListener(this.jdField_a_of_type_Pne.a());
    ((ReadInJoyXListView)paramListView).a(new ppf(this.jdField_a_of_type_Pne));
  }
  
  public static String a(ArticleInfo paramArticleInfo, int paramInt)
  {
    if ((jdField_a_of_type_Qsf != null) && (qsf.a(paramArticleInfo)))
    {
      paramArticleInfo = jdField_a_of_type_Qsf.a(paramArticleInfo);
      QLog.d("ReadInJoyBaseAdapter", 2, "getProteusFamilyCardViewType | dynamic viewType : " + paramArticleInfo);
      return paramArticleInfo;
    }
    paramArticleInfo = String.valueOf(ppe.a(paramArticleInfo, paramInt));
    QLog.d("ReadInJoyBaseAdapter", 2, "getProteusFamilyCardViewType | normal viewType : " + paramArticleInfo);
    return paramArticleInfo;
  }
  
  public static spk a(BaseArticleInfo paramBaseArticleInfo)
  {
    return prt.a(paramBaseArticleInfo);
  }
  
  public static spk a(BaseArticleInfo paramBaseArticleInfo, boolean paramBoolean)
  {
    return prt.a(paramBaseArticleInfo, paramBoolean);
  }
  
  private void a(BaseArticleInfo paramBaseArticleInfo, int paramInt)
  {
    if ((paramBaseArticleInfo != null) && (paramBaseArticleInfo.feedsFirstExposurePos == -1)) {
      paramBaseArticleInfo.feedsFirstExposurePos = paramInt;
    }
    uvs.a(paramBaseArticleInfo, uvs.e, false);
  }
  
  public int a()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public abstract int a(int paramInt);
  
  public long a()
  {
    return this.jdField_a_of_type_Pob.a().a();
  }
  
  public abstract Activity a();
  
  public Bitmap a(long paramLong)
  {
    return null;
  }
  
  public AnimationSet a()
  {
    return new pnz(this.jdField_a_of_type_Pne).a();
  }
  
  public blcn a()
  {
    return this.jdField_a_of_type_Pne.a().a().a(a());
  }
  
  public blct a()
  {
    return this.jdField_a_of_type_Pne.a().a().a(a());
  }
  
  public ArticleInfo a()
  {
    return this.jdField_a_of_type_Pne.a(a());
  }
  
  public abstract BaseArticleInfo a(int paramInt);
  
  public abstract BaseArticleInfo a(int paramInt, long paramLong);
  
  public VafContext a()
  {
    return this.jdField_a_of_type_Pne.a().a();
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
  
  public ArrayList<rot> a()
  {
    return this.jdField_a_of_type_Pne.a().a();
  }
  
  public List<BaseArticleInfo> a()
  {
    return this.jdField_a_of_type_Pne.a();
  }
  
  public oil a()
  {
    return this.jdField_a_of_type_Oil;
  }
  
  public pne a()
  {
    return this.jdField_a_of_type_Pne;
  }
  
  public pnr a()
  {
    return this.jdField_a_of_type_Pnr;
  }
  
  public qsf a()
  {
    return this.jdField_a_of_type_Pne.a().b();
  }
  
  public sfx a()
  {
    return this.jdField_a_of_type_Sfx;
  }
  
  public spg a()
  {
    return this.jdField_a_of_type_Pob.a().a();
  }
  
  public tps a()
  {
    return this.jdField_a_of_type_Pne.a().a().a(a(), this);
  }
  
  public ukg a()
  {
    return this.jdField_a_of_type_Pne.a().a();
  }
  
  public void a()
  {
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_Pne.a();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.b();
    this.jdField_a_of_type_Pne.a().a().a();
    if (this.jdField_c_of_type_Int == 56) {
      sgg.a().a();
    }
    if (this.jdField_a_of_type_Sfx != null) {
      this.jdField_a_of_type_Sfx.d();
    }
    this.jdField_a_of_type_Pob.a().r();
  }
  
  public void a(int paramInt)
  {
    a(paramInt, true);
  }
  
  public void a(int paramInt, Intent paramIntent)
  {
    this.jdField_a_of_type_Pob.a().a(paramInt, paramIntent);
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
    this.jdField_a_of_type_Pne.a(paramInt, paramArrayList, paramArrayList1, paramObject, paramBoolean1, paramBoolean2);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_Pob.a().b(paramInt, paramBoolean);
  }
  
  public void a(long paramLong)
  {
    this.jdField_c_of_type_Long = paramLong;
    this.jdField_a_of_type_Pne.a().a(this.jdField_c_of_type_Long);
  }
  
  public void a(AdvertisementInfo paramAdvertisementInfo)
  {
    if (paramAdvertisementInfo == null) {
      return;
    }
    g();
    this.jdField_a_of_type_Pne.a(paramAdvertisementInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView);
  }
  
  public void a(BaseArticleInfo paramBaseArticleInfo)
  {
    this.jdField_a_of_type_Pne.a().remove(paramBaseArticleInfo);
    notifyDataSetChanged();
    this.jdField_a_of_type_Pne.a().e(true);
  }
  
  public void a(BaseArticleInfo paramBaseArticleInfo1, BaseArticleInfo paramBaseArticleInfo2, boolean paramBoolean)
  {
    this.jdField_a_of_type_Pne.a(paramBaseArticleInfo1, paramBaseArticleInfo2, paramBoolean);
  }
  
  public void a(BaseArticleInfo paramBaseArticleInfo, qfw paramqfw, long paramLong, int paramInt)
  {
    pnj.a(paramBaseArticleInfo, paramqfw, paramLong, paramInt, this.jdField_a_of_type_Pne);
  }
  
  public void a(ReadInJoyBaseListView paramReadInJoyBaseListView)
  {
    this.jdField_a_of_type_Pob.a(paramReadInJoyBaseListView);
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    this.jdField_a_of_type_Pob.a().b(paramAbsListView, paramInt);
  }
  
  public void a(List<BaseArticleInfo> paramList)
  {
    this.jdField_a_of_type_Pne.a(paramList);
    this.jdField_a_of_type_Pob.a(paramList);
  }
  
  public void a(List<ArticleInfo> paramList, int paramInt)
  {
    this.jdField_a_of_type_Pne.a(paramList, paramInt);
  }
  
  public void a(Set<Long> paramSet, Map<Long, rot> paramMap)
  {
    this.jdField_a_of_type_Pne.a().a(paramSet, paramMap);
  }
  
  public void a(oil paramoil)
  {
    this.jdField_a_of_type_Oil = paramoil;
  }
  
  public void a(pnr parampnr)
  {
    this.jdField_a_of_type_Pnr = parampnr;
  }
  
  public void a(pnx parampnx)
  {
    this.jdField_a_of_type_Pne.a().a(parampnx);
  }
  
  public void a(spg paramspg, sge paramsge)
  {
    this.jdField_a_of_type_Pne.a().a(paramspg).a(paramsge).a(this.jdField_a_of_type_Pob.a().a());
    this.jdField_a_of_type_Pob.a().a(paramspg, paramsge);
    paramspg = this.jdField_a_of_type_Pob.a().a();
    if ((uks.a(a())) && (paramspg != null))
    {
      this.jdField_a_of_type_Sfx = new sfx(this.jdField_a_of_type_AndroidAppActivity, this, paramspg, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, a());
      this.jdField_a_of_type_Pob.a().a().a(this.jdField_a_of_type_Sfx);
    }
  }
  
  public void a(spk paramspk)
  {
    if ((this.jdField_a_of_type_Pne.a().a().a(a()) != null) && (this.jdField_a_of_type_Pne.a().a().a(a()).isShowing())) {
      this.jdField_a_of_type_Pne.a().a().a(a()).dismiss();
    }
    if ((this.jdField_a_of_type_Pne.a().a().a(a()) != null) && (this.jdField_a_of_type_Pne.a().a().a(a()).isShowing())) {
      this.jdField_a_of_type_Pne.a().a().a(a()).dismiss();
    }
    this.jdField_a_of_type_Pob.a().a(paramspk);
  }
  
  public void a(spk paramspk, int paramInt)
  {
    this.jdField_a_of_type_Pob.a().a(paramspk, paramInt);
  }
  
  public void a(spk paramspk, BaseArticleInfo paramBaseArticleInfo)
  {
    a(paramspk, paramBaseArticleInfo, false, true);
  }
  
  public void a(spk paramspk, BaseArticleInfo paramBaseArticleInfo, boolean paramBoolean1, boolean paramBoolean2)
  {
    prz.a(paramspk, paramBaseArticleInfo, paramBoolean1, this.jdField_a_of_type_Pne);
  }
  
  public void a(spk paramspk1, spk paramspk2)
  {
    this.jdField_a_of_type_Pob.a().a(paramspk1, paramspk2);
  }
  
  public void a(sxd paramsxd, BaseArticleInfo paramBaseArticleInfo, int paramInt)
  {
    prt.a(paramsxd, paramBaseArticleInfo, this.jdField_a_of_type_Pne, this, this);
  }
  
  public void a(sxe paramsxe, BaseArticleInfo paramBaseArticleInfo, int paramInt)
  {
    prt.a(paramsxe, paramBaseArticleInfo, this.jdField_a_of_type_Pne, this, this);
  }
  
  public void a(sxf paramsxf, BaseArticleInfo paramBaseArticleInfo, int paramInt)
  {
    prt.a(paramsxf, paramBaseArticleInfo, this.jdField_a_of_type_Pne, this, this);
  }
  
  public void a(sxg paramsxg, BaseArticleInfo paramBaseArticleInfo)
  {
    prt.a(paramsxg, paramBaseArticleInfo, this.jdField_a_of_type_Pne, this);
  }
  
  public void a(sxh paramsxh, BaseArticleInfo paramBaseArticleInfo, int paramInt)
  {
    prt.a(paramsxh, paramBaseArticleInfo, this.jdField_a_of_type_Pne, this, this, this.jdField_a_of_type_JavaUtilSet);
  }
  
  public void a(sxn paramsxn, BaseArticleInfo paramBaseArticleInfo, int paramInt)
  {
    prt.a(paramsxn, paramBaseArticleInfo, this.jdField_a_of_type_Pne, this, this);
  }
  
  public void a(syr paramsyr)
  {
    this.jdField_a_of_type_Syr = paramsyr;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setNoteCardLifeCycle(paramsyr);
    }
  }
  
  public void a(ukg paramukg)
  {
    this.jdField_a_of_type_Pne.a().a(paramukg);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Pne.a().c(paramBoolean);
  }
  
  public void a(boolean paramBoolean, ArticleInfo paramArticleInfo1, ArticleInfo paramArticleInfo2, String paramString, Map<String, Object> paramMap)
  {
    psu.a(paramBoolean, paramArticleInfo1, paramArticleInfo2, paramString, paramMap, this.jdField_a_of_type_Pne);
  }
  
  public void a(boolean paramBoolean, BaseArticleInfo paramBaseArticleInfo)
  {
    psu.a(paramBoolean, paramBaseArticleInfo, a(), this.jdField_c_of_type_Int, this.jdField_c_of_type_Long);
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
    return this.jdField_a_of_type_Pne.a(paramInt);
  }
  
  public void b()
  {
    this.jdField_a_of_type_Pob.a().n();
  }
  
  public void b(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void b(BaseArticleInfo paramBaseArticleInfo)
  {
    psu.a(paramBaseArticleInfo, a(), this.jdField_c_of_type_Int);
  }
  
  public void b(AbsListView paramAbsListView, int paramInt)
  {
    this.jdField_a_of_type_Pob.a().c(paramAbsListView, paramInt);
  }
  
  public void b(List<BaseArticleInfo> paramList)
  {
    this.jdField_a_of_type_Pne.b(paramList);
  }
  
  public void b(syr paramsyr)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(paramsyr);
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Pne.a().f(paramBoolean);
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Pne.a().d();
  }
  
  public abstract boolean b(int paramInt, long paramLong);
  
  public void c()
  {
    this.jdField_a_of_type_Pob.a().k();
  }
  
  public void c(syr paramsyr)
  {
    this.jdField_a_of_type_JavaUtilArrayList.remove(paramsyr);
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_a_of_type_Pne.a().g(paramBoolean);
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_Pne.a().b();
  }
  
  public void d()
  {
    int k = 0;
    if (this.jdField_a_of_type_Sfx != null) {
      this.jdField_a_of_type_Sfx.b();
    }
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video_" + this.jdField_c_of_type_Int, 2, "ReadInJoyBaseAdapter doOnResume()");
    }
    if (bmhv.n()) {
      pnj.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getFirstVisiblePosition(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getHeaderViewsCount(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildCount(), this.jdField_a_of_type_Pne);
    }
    this.jdField_a_of_type_Boolean = true;
    if (Build.VERSION.SDK_INT < 21) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setFriction(jdField_a_of_type_Float);
    }
    this.jdField_a_of_type_Ppg.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, 4);
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Pne.a().c(false);
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildCount()) {
        break;
      }
      View localView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildAt(i);
      if (((localView instanceof syp)) && (!((syp)localView).a()))
      {
        ((syp)localView).setIsResume(true);
        ((syp)localView).a();
      }
      i += 1;
    }
    while (j < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      ((syr)this.jdField_a_of_type_JavaUtilArrayList.get(j)).a();
      j += 1;
    }
    if (this.jdField_a_of_type_Syr != null) {
      this.jdField_a_of_type_Syr.a();
    }
    this.jdField_a_of_type_Pqi.a();
    this.jdField_a_of_type_Ppi.a();
  }
  
  public void d(boolean paramBoolean)
  {
    this.jdField_a_of_type_Pne.a().d(paramBoolean);
  }
  
  public boolean d()
  {
    return this.jdField_a_of_type_Pne.a().a();
  }
  
  public void e()
  {
    int k = 0;
    if (this.jdField_a_of_type_Sfx != null) {
      this.jdField_a_of_type_Sfx.c();
    }
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video_" + this.jdField_c_of_type_Int, 2, "ReadInJoyBaseAdapter doOnPause()");
    }
    this.jdField_a_of_type_Boolean = false;
    if ((this.jdField_a_of_type_Pne.a().a().a(a()) != null) && (this.jdField_a_of_type_Pne.a().a().a(a()).isShowing())) {
      this.jdField_a_of_type_Pne.a().a().a(a()).dismiss();
    }
    this.jdField_a_of_type_Ppg.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, 5);
    if ((!bmhv.s()) && (piv.a(this.jdField_a_of_type_Pne.a().a(), "default_feeds")))
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
      if (((localView instanceof syp)) && (((syp)localView).a()))
      {
        ((syp)localView).setIsResume(false);
        ((syp)localView).b();
      }
      i += 1;
    }
    while (j < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      ((syr)this.jdField_a_of_type_JavaUtilArrayList.get(j)).b();
      j += 1;
    }
    if (this.jdField_a_of_type_Syr != null) {
      this.jdField_a_of_type_Syr.b();
    }
    this.jdField_a_of_type_Pqi.b();
    this.jdField_a_of_type_Ppi.b();
  }
  
  public void e(boolean paramBoolean)
  {
    this.jdField_a_of_type_Pob.a().b(paramBoolean);
  }
  
  public boolean e()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public void f()
  {
    this.jdField_a_of_type_Pob.a().o();
  }
  
  public boolean f()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void g()
  {
    if ((this.jdField_a_of_type_Pob.a().a() != null) && (uks.a(this.jdField_c_of_type_Int))) {
      f();
    }
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_Pne.a();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_Pne.a(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return this.jdField_a_of_type_Pne.a(paramInt);
  }
  
  public int getItemViewType(int paramInt)
  {
    int j = a(paramInt);
    int i = j;
    if (this.jdField_a_of_type_Pob.a().a(j, paramInt)) {
      i = 119;
    }
    return i;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    blfz.a("ReadInJoyBaseAdapter.getView");
    System.currentTimeMillis();
    a(b(paramInt), paramInt);
    BaseArticleInfo localBaseArticleInfo = b(paramInt);
    int i = getItemViewType(paramInt);
    Object localObject = this.jdField_a_of_type_Pne.a((ArticleInfo)localBaseArticleInfo, i, paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyBaseAdapter", 2, "getView: " + localBaseArticleInfo + " type= " + i);
    }
    View localView = (View)qda.a(this.jdField_a_of_type_Pob.a(), new sze(this, "onAdapterGetView", i, localBaseArticleInfo, paramInt, paramView, paramViewGroup));
    this.jdField_a_of_type_Pob.a(localView, paramView, localBaseArticleInfo, paramInt);
    if (localView != null)
    {
      pnj.a(localBaseArticleInfo, (qfw)localObject, System.currentTimeMillis(), paramInt, this.jdField_a_of_type_Pne);
      localObject = super.a(localView, paramInt);
      pnj.a((View)localObject, i, localBaseArticleInfo, this.jdField_a_of_type_Pne);
      TextHook.updateFont(paramView);
      blfz.a();
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
    return jdField_a_of_type_Qsf.a() + 147 + qym.a();
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.c(7);
    }
  }
  
  public void i()
  {
    this.jdField_a_of_type_Pne.b();
  }
  
  public boolean isEmpty()
  {
    return this.jdField_a_of_type_Pne.a().isEmpty();
  }
  
  public void j()
  {
    this.jdField_a_of_type_Pob.a().h();
  }
  
  public void notifyDataSetChanged()
  {
    super.notifyDataSetChanged();
    this.jdField_a_of_type_Pob.g();
  }
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_AndroidAppActivity instanceof ReadInJoyFeedsActivity)) {
      ((ReadInJoyFeedsActivity)this.jdField_a_of_type_AndroidAppActivity).b(16);
    }
    pnq localpnq = (pnq)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramView.getId()));
    if (localpnq != null) {
      localpnq.onClick(paramView);
    }
    for (;;)
    {
      this.jdField_a_of_type_Ppk.a(paramView);
      this.jdField_a_of_type_Psf.a(paramView);
      this.jdField_a_of_type_Pob.a().onClick(paramView);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      QLog.e("ReadInJoyBaseAdapter", 1, "onClick, has no click handler for id(" + paramView.getId() + "}");
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    return this.jdField_a_of_type_Psf.a(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     szd
 * JD-Core Version:    0.7.0.1
 */