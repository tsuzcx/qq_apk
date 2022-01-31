import android.app.Activity;
import android.content.Intent;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyChannelWaterFallViewController.2;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyChannelWaterFallViewController.3;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyChannelActivity.SerializableMap;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInjoyXRecyclerView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.Constants.LogoutReason;
import tencent.im.oidb.gallery.galleryFeeds.GalleryFeedsInfo;

public class nwu
  extends nwi
  implements rwc
{
  private long jdField_a_of_type_Long;
  private ArrayList<ChannelCoverInfo> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  protected ore a;
  protected oxe a;
  public pag a;
  boolean jdField_a_of_type_Boolean = false;
  private int b;
  protected boolean b;
  private int c;
  protected boolean c;
  private int jdField_d_of_type_Int = -1;
  private boolean jdField_d_of_type_Boolean;
  private boolean e;
  
  public nwu(int paramInt1, int paramInt2, Activity paramActivity, ozp paramozp)
  {
    super(paramActivity);
    this.jdField_c_of_type_Int = 1;
    this.jdField_a_of_type_Oxe = new nwv(this);
    this.jdField_d_of_type_Int = paramInt2;
    this.jdField_b_of_type_Int = paramInt1;
    this.jdField_a_of_type_Pag = ((pag)paramozp);
    this.jdField_a_of_type_Ore = new ore();
    this.jdField_a_of_type_Ore.jdField_a_of_type_Long = bkbq.a(paramInt1, (QQAppInterface)ors.a());
  }
  
  private int a()
  {
    if (this.jdField_d_of_type_Int != -1) {
      return this.jdField_d_of_type_Int;
    }
    return a().getIntent().getIntExtra("channel_type", 0);
  }
  
  private long a()
  {
    if ((d()) && (a().getIntent().getIntExtra("channel_from", -1) == 4))
    {
      Object localObject = (ReadInJoyChannelActivity.SerializableMap)a().getIntent().getSerializableExtra("channel_map_data");
      if ((localObject != null) && (((ReadInJoyChannelActivity.SerializableMap)localObject).getMap() != null))
      {
        localObject = ((ReadInJoyChannelActivity.SerializableMap)localObject).getMap();
        long l = ((Long)((Map)localObject).get("param_key_ariticle_id")).longValue();
        if (((Integer)((Map)localObject).get("param_key_channel_cover_style")).intValue() == 1) {
          return l;
        }
      }
    }
    return -1L;
  }
  
  private void a(List<BaseArticleInfo> paramList)
  {
    if (paramList == null) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        BaseArticleInfo localBaseArticleInfo = (BaseArticleInfo)paramList.next();
        if (localBaseArticleInfo.mGalleryFeedsInfo == null) {
          paramList.remove();
        } else if ((localBaseArticleInfo.mGalleryFeedsInfo.enum_article_style.get() != 4) && (localBaseArticleInfo.mGalleryFeedsInfo.enum_article_style.get() != 5)) {
          paramList.remove();
        } else if ((localBaseArticleInfo.mGalleryFeedsInfo.enum_article_style.get() == 4) && (localBaseArticleInfo.mJsonPictureList == null)) {
          paramList.remove();
        }
      }
    }
  }
  
  private void a(List<BaseArticleInfo> paramList, int paramInt)
  {
    a(paramList);
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.jdField_a_of_type_Pag.a());
    paramList = peo.a().a(this.jdField_b_of_type_Int, paramList, localArrayList, paramInt);
    this.jdField_a_of_type_Pag.a(paramList);
    this.jdField_a_of_type_Pag.a();
  }
  
  private void a(boolean paramBoolean1, int paramInt1, boolean paramBoolean2, int paramInt2)
  {
    this.jdField_a_of_type_Ore.jdField_a_of_type_Long = System.currentTimeMillis();
    bkbq.a(this.jdField_b_of_type_Int, this.jdField_a_of_type_Ore.jdField_a_of_type_Long, (QQAppInterface)ors.a());
    ArrayList localArrayList = null;
    int j = -1;
    Object localObject = (KandianMergeManager)((BaseActivity)a()).app.getManager(162);
    long l = a();
    ArticleInfo localArticleInfo = (ArticleInfo)this.jdField_a_of_type_Pag.a(0);
    localObject = localArrayList;
    int i = j;
    if (l != -1L)
    {
      localObject = localArrayList;
      i = j;
      if (localArticleInfo != null)
      {
        localObject = localArrayList;
        i = j;
        if (l != localArticleInfo.mArticleID)
        {
          localObject = new ArrayList();
          ((List)localObject).add(Long.valueOf(l));
          i = 6;
        }
      }
    }
    this.jdField_a_of_type_Pag.a(paramBoolean1);
    localArrayList = new ArrayList();
    owy.a().a(this.jdField_b_of_type_Int, (List)localObject, i, true, false, this.jdField_c_of_type_Int, null, -1L, null, a(), 0L, 0L, null, paramInt1, false, null, 0, localArrayList);
    this.jdField_c_of_type_Int += 1;
    if ((a() instanceof ReadInJoyNewFeedsActivity)) {
      a(-2);
    }
    szp.a(paramInt1, this.jdField_b_of_type_Int, a(), paramBoolean2, paramInt2);
  }
  
  private boolean a(boolean paramBoolean)
  {
    if (!b()) {
      return false;
    }
    long l = System.currentTimeMillis();
    boolean bool2 = this.jdField_a_of_type_Pag.a();
    boolean bool3 = nwm.a(this.jdField_b_of_type_Int);
    Object localObject = (KandianMergeManager)((BaseActivity)a()).app.getManager(162);
    boolean bool1;
    if (System.currentTimeMillis() - this.jdField_a_of_type_Ore.d > 300000L)
    {
      bool1 = true;
      boolean bool4 = c();
      if ((bool2) || (bool1) || (bool4)) {
        break label316;
      }
      paramBoolean = false;
      label95:
      QLog.d("ReadInJoyChannelWaterFallViewController_" + this.jdField_b_of_type_Int, 1, String.format("loadFinishedRefresh forceRefresh=%s, isDBCacheEmpty=%s, isLastExitChannelOverTimeLimit=%s, hasChannelMap=%s, hasPushMsg=%s, needForceInsertFresh=%s, hasRed=%s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool2), Boolean.valueOf(bool1), Boolean.valueOf(bool4), Boolean.valueOf(false), Boolean.valueOf(false), Boolean.valueOf(false) }));
      if (!a()) {
        break label326;
      }
      bool1 = nwm.c(this.jdField_b_of_type_Int);
      if ((!bool2) && (!bool1) && (!bool4) && (!bool3)) {
        break label321;
      }
      paramBoolean = true;
      label219:
      QLog.d("ReadInJoyChannelWaterFallViewController", 1, String.format("new channel tab, loadFinishedRefresh forceRefresh=%s, isDBCacheEmpty=%s, isLastExitChannelOverTimeLimit=%s, hasChannelMap=%s, hasPushMsg=%s, needForceInsertFresh=%s, hasRed=%s, isNeedRefreshChannel=%s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool2), Boolean.valueOf(bool1), Boolean.valueOf(bool4), Boolean.valueOf(false), Boolean.valueOf(false), Boolean.valueOf(false), Boolean.valueOf(bool3) }));
      bool1 = paramBoolean;
    }
    for (;;)
    {
      if (!bool1) {
        break label377;
      }
      a(true, 2);
      return true;
      bool1 = false;
      break;
      label316:
      paramBoolean = true;
      break label95;
      label321:
      paramBoolean = false;
      break label219;
      label326:
      bool1 = paramBoolean;
      if (this.jdField_b_of_type_Int != 70)
      {
        bool1 = paramBoolean;
        if (this.jdField_b_of_type_Int != 56)
        {
          bool1 = paramBoolean;
          if (this.jdField_b_of_type_Int != 40677)
          {
            bool1 = paramBoolean;
            if (!otf.c(this.jdField_b_of_type_Int)) {
              bool1 = true;
            }
          }
        }
      }
    }
    label377:
    localObject = this.jdField_a_of_type_Ore;
    if (this.jdField_a_of_type_Ore.jdField_a_of_type_Long == 0L) {}
    for (;;)
    {
      ((ore)localObject).jdField_a_of_type_Long = l;
      if (this.jdField_b_of_type_Int == 0) {}
      return false;
      l = this.jdField_a_of_type_Ore.jdField_a_of_type_Long;
    }
  }
  
  private boolean b()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  private boolean c()
  {
    return false;
  }
  
  private boolean d()
  {
    return this.jdField_b_of_type_Int != 0;
  }
  
  private void n() {}
  
  public Set<Long> a(Integer paramInteger)
  {
    Set localSet = (Set)this.jdField_a_of_type_JavaUtilMap.get(paramInteger);
    Object localObject = localSet;
    if (localSet == null)
    {
      localObject = new HashSet();
      this.jdField_a_of_type_JavaUtilMap.put(paramInteger, localObject);
    }
    return localObject;
  }
  
  public void a()
  {
    super.a();
    oxb.a().a(this.jdField_a_of_type_Oxe);
    this.jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(this.jdField_b_of_type_Int), Boolean.valueOf(true));
    b();
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void a(BaseArticleInfo paramBaseArticleInfo, int paramInt)
  {
    this.jdField_a_of_type_Pag.a();
    this.jdField_a_of_type_Pag.a(paramBaseArticleInfo, paramInt);
    QQToast.a(this.jdField_a_of_type_AndroidAppActivity, -1, this.jdField_a_of_type_AndroidAppActivity.getString(2131700054), 0).b(((BaseActivity)this.jdField_a_of_type_AndroidAppActivity).getTitleBarHeight());
    if (peo.a(paramBaseArticleInfo.mRecommendSeq)) {
      peo.a().a(this.jdField_b_of_type_Int, paramBaseArticleInfo.mRecommendSeq);
    }
    do
    {
      do
      {
        return;
        String str = ors.a();
        DislikeInfo localDislikeInfo = new DislikeInfo();
        localDislikeInfo.a = alud.a(2131713110);
        localDislikeInfo.jdField_c_of_type_Int = 9;
        localDislikeInfo.b = "";
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(localDislikeInfo);
        owy.a().a(Long.valueOf(str).longValue(), ((ArticleInfo)paramBaseArticleInfo).makeDislikeParam(localArrayList));
        owy.a().a(this.jdField_b_of_type_Int, paramBaseArticleInfo);
      } while (paramInt != 0);
      paramBaseArticleInfo = (KandianMergeManager)((QQAppInterface)ors.a()).getManager(162);
    } while (this.jdField_a_of_type_Pag.a().size() > 0);
    owy.a().a(this.jdField_b_of_type_Int, 20, 9223372036854775807L, true);
  }
  
  public void a(ReadInjoyXRecyclerView paramReadInjoyXRecyclerView, int paramInt)
  {
    boolean bool;
    int i;
    if (paramInt == 4)
    {
      bool = true;
      this.jdField_d_of_type_Boolean = bool;
      if (this.jdField_b_of_type_Int != 40830) {
        break label72;
      }
      i = this.jdField_c_of_type_Int;
      this.jdField_c_of_type_Int = (i + 1);
    }
    for (;;)
    {
      owy.a().a(this.jdField_b_of_type_Int, a(), paramInt, 0, i);
      ThreadManager.executeOnSubThread(new ReadInJoyChannelWaterFallViewController.3(this));
      return;
      bool = false;
      break;
      label72:
      i = 1;
    }
  }
  
  public void a(ReadInjoyXRecyclerView paramReadInjoyXRecyclerView, boolean paramBoolean)
  {
    if (otf.c(this.jdField_b_of_type_Int)) {
      opt.a(1);
    }
    int i;
    if ((!ors.a()) || (d()) || (paramBoolean))
    {
      i = 1;
      if (i == 0) {
        break label93;
      }
      i = 3;
      label39:
      if (paramBoolean) {
        break label100;
      }
      oxb.a().a(2, null);
      ReadinjoyTabFrame localReadinjoyTabFrame = ors.a(a());
      if (localReadinjoyTabFrame != null) {
        localReadinjoyTabFrame.a(1);
      }
      ors.b(3);
    }
    for (;;)
    {
      a(true, i, paramBoolean, -paramReadInjoyXRecyclerView.getScrollY());
      return;
      i = 0;
      break;
      label93:
      i = 1001;
      break label39;
      label100:
      oxb.a().a(2, null);
      i = 1;
    }
  }
  
  public void a(Constants.LogoutReason paramLogoutReason) {}
  
  public void a(boolean paramBoolean)
  {
    a(paramBoolean, 0);
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (!this.jdField_b_of_type_Boolean) {}
    do
    {
      return;
      this.jdField_a_of_type_Pag.c();
    } while (!paramBoolean);
    this.jdField_a_of_type_Pag.b();
  }
  
  public boolean a()
  {
    return a() instanceof SplashActivity;
  }
  
  public boolean a(Integer paramInteger)
  {
    paramInteger = (Boolean)this.jdField_b_of_type_JavaUtilMap.get(paramInteger);
    if (paramInteger != null) {
      return paramInteger.booleanValue();
    }
    return false;
  }
  
  public Map<Long, qkk> b(Integer paramInteger)
  {
    Map localMap = (Map)this.jdField_c_of_type_JavaUtilMap.get(paramInteger);
    Object localObject = localMap;
    if (localMap == null)
    {
      localObject = new ConcurrentHashMap();
      this.jdField_c_of_type_JavaUtilMap.put(paramInteger, localObject);
    }
    return localObject;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    super.b();
    if (this.jdField_a_of_type_Pag != null) {
      this.jdField_a_of_type_Pag.a(a(Integer.valueOf(this.jdField_b_of_type_Int)), b(Integer.valueOf(this.jdField_b_of_type_Int)));
    }
    this.jdField_a_of_type_Ore.b = System.currentTimeMillis();
    this.jdField_a_of_type_Ore.d = bkbq.a((QQAppInterface)ors.a(), this.jdField_b_of_type_Int);
    j();
  }
  
  public void c()
  {
    if (!this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      this.jdField_a_of_type_Boolean = false;
      super.c();
    } while (this.jdField_a_of_type_Pag == null);
    this.jdField_a_of_type_Pag.a(b(Integer.valueOf(this.jdField_b_of_type_Int)), a(Integer.valueOf(this.jdField_b_of_type_Int)));
  }
  
  public void d()
  {
    oxb.a().b(this.jdField_a_of_type_Oxe);
    if (this.jdField_a_of_type_Pag != null) {
      this.jdField_a_of_type_Pag.a(b(Integer.valueOf(this.jdField_b_of_type_Int)), a(Integer.valueOf(this.jdField_b_of_type_Int)));
    }
    super.d();
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.jdField_c_of_type_JavaUtilMap.clear();
    this.jdField_b_of_type_JavaUtilMap.clear();
    this.jdField_d_of_type_JavaUtilMap.clear();
  }
  
  public void g()
  {
    super.g();
  }
  
  public void h()
  {
    super.h();
    this.jdField_c_of_type_Boolean = true;
    j();
  }
  
  public void i()
  {
    this.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)owy.a().a(this.jdField_b_of_type_Int));
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)) {
      owy.a().c(this.jdField_b_of_type_Int);
    }
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
      this.jdField_a_of_type_Pag.c(this.jdField_a_of_type_JavaUtilArrayList);
    }
    owy.a().a(this.jdField_b_of_type_Int);
  }
  
  public void j()
  {
    if (!this.jdField_b_of_type_Boolean)
    {
      owy.a().a(this.jdField_b_of_type_Int, 20, 9223372036854775807L, true);
      this.jdField_b_of_type_Boolean = true;
      return;
    }
    QLog.d("ReadInJoyChannelWaterFallViewController", 2, new Object[] { "has loaded article, mChannelID = ", Integer.valueOf(this.jdField_b_of_type_Int) });
  }
  
  public void k()
  {
    if (this.jdField_a_of_type_Pag != null)
    {
      Map localMap1 = a(Integer.valueOf(this.jdField_b_of_type_Int));
      Map localMap2 = szp.a(this.jdField_b_of_type_Int);
      ThreadManager.executeOnSubThread(new ReadInJoyChannelWaterFallViewController.2(this, localMap1, a(Integer.valueOf(this.jdField_b_of_type_Int)), localMap2, ors.e(this.jdField_b_of_type_Int)));
      b(Integer.valueOf(this.jdField_b_of_type_Int)).clear();
      this.jdField_a_of_type_JavaUtilMap.clear();
    }
  }
  
  public void l() {}
  
  public void m() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     nwu
 * JD-Core Version:    0.7.0.1
 */