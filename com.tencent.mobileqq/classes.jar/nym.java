import android.app.Activity;
import android.content.ContextWrapper;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.DecelerateInterpolator;
import android.widget.ListAdapter;
import com.tencent.biz.pubaccount.readinjoy.ad.handlers.AdHandler.3;
import com.tencent.biz.pubaccount.readinjoy.ad.view.ReadInJoyAdVideoGuide;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.ProteusItemView;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseListView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AdapterView;
import com.tencent.widget.ListView;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.List;

public class nym
  extends oya
{
  private static oak jdField_a_of_type_Oak = new oak();
  private float jdField_a_of_type_Float = bbct.d() * 500 / 160.0F;
  private int jdField_a_of_type_Int;
  private SparseArray<View> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(1);
  private DecelerateInterpolator jdField_a_of_type_AndroidViewAnimationDecelerateInterpolator = new DecelerateInterpolator(this.jdField_c_of_type_Float);
  private AdvertisementInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private final String jdField_a_of_type_JavaLangString = "AdHandler";
  private nyp jdField_a_of_type_Nyp = new nyp(this);
  private obs jdField_a_of_type_Obs;
  protected osp a;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float = bbct.d() * 1000 / 160.0F;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private float jdField_c_of_type_Float = 1.5F;
  private int jdField_c_of_type_Int = -1;
  
  public nym()
  {
    this.jdField_a_of_type_Osp = new nyo(this);
  }
  
  private void a(View paramView)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    if (paramView != null)
    {
      localObject2 = paramView.getContext();
      paramView = (View)localObject1;
      for (localObject1 = localObject2;; localObject1 = ((ContextWrapper)localObject1).getBaseContext())
      {
        localObject2 = paramView;
        if (!(localObject1 instanceof ContextWrapper)) {
          break;
        }
        if ((localObject1 instanceof Activity)) {
          paramView = (Activity)localObject1;
        }
      }
    }
    if ((localObject2 != null) && (((Activity)localObject2).getWindow() != null))
    {
      paramView = ((Activity)localObject2).getWindow().getDecorView().findViewById(16908307);
      if (paramView != null) {
        this.jdField_b_of_type_Int = paramView.getMeasuredHeight();
      }
    }
  }
  
  private void a(ArticleInfo paramArticleInfo, long paramLong, View paramView)
  {
    Activity localActivity = a();
    int i = b();
    rao localrao = (rao)a();
    long l;
    AdvertisementInfo localAdvertisementInfo;
    if (AdvertisementInfo.isAdvertisementInfo(paramArticleInfo))
    {
      if (oau.a(i))
      {
        osj.a().a(paramArticleInfo.mArticleID, System.currentTimeMillis());
        if (localrao != null) {
          localrao.notifyDataSetChanged();
        }
      }
      if (localrao != null)
      {
        localrao.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params = sht.a(localActivity, (AdvertisementInfo)paramArticleInfo, localrao, i, false, null);
        if (localrao.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params == null) {
          break label126;
        }
        l = SystemClock.elapsedRealtime();
        localrao.jdField_a_of_type_Long = l;
      }
      if (!(paramArticleInfo instanceof AdvertisementInfo)) {
        break label186;
      }
      localAdvertisementInfo = (AdvertisementInfo)paramArticleInfo;
      if ((paramView instanceof ViewGroup)) {
        break label134;
      }
    }
    label126:
    qtu localqtu;
    label134:
    do
    {
      return;
      l = -2147483648L;
      break;
      localqtu = null;
      if (localrao != null) {
        localqtu = localrao.a();
      }
    } while (((paramView instanceof ProteusItemView)) && (sht.a(paramArticleInfo, ((ProteusItemView)paramView).a().getVirtualView(), (Activity)localActivity, i, localqtu, localAdvertisementInfo)));
    label186:
    if ((onk.a(paramArticleInfo)) && (paramArticleInfo.mFeedType == 2))
    {
      boolean bool = sht.a(paramArticleInfo, localrao);
      sht.a((Activity)localActivity, (AdvertisementInfo)paramArticleInfo, localrao, i, true, oat.b((AdvertisementInfo)paramArticleInfo), new nyc(bool));
      paramView = a();
      if ((paramView != null) && ((paramView instanceof ReadInJoyListViewGroup))) {
        ((ReadInJoyListViewGroup)paramView).a(paramArticleInfo);
      }
    }
    for (;;)
    {
      QZLog.i("AdHandler", 4, "AdHandler processAdClickEvent");
      return;
      if ((AdvertisementInfo.isAppAdvertisementInfo(paramArticleInfo)) && (localrao != null) && (paramLong != -1L))
      {
        int j = localrao.getItemViewType((int)paramLong);
        if ((j == 39) || (j == 116) || (j == 117) || (j == 66) || (j == 115) || (j == 122)) {
          sht.a(localActivity, (AdvertisementInfo)paramArticleInfo, localrao, i, true, oat.b((AdvertisementInfo)paramArticleInfo));
        } else {
          sht.a(localActivity, (AdvertisementInfo)paramArticleInfo, localrao, i, false, null);
        }
      }
      else
      {
        if (localrao == null) {
          break;
        }
        sht.a((Activity)localActivity, paramArticleInfo, localrao, i, null);
      }
    }
  }
  
  private void i()
  {
    int i = b();
    ReadInJoyXListView localReadInJoyXListView = (ReadInJoyXListView)((ReadInJoyListViewGroup)a()).a();
    long l = System.currentTimeMillis();
    if ((oau.a(i)) && (localReadInJoyXListView != null) && (localReadInJoyXListView.getChildCount() > 0))
    {
      i = 0;
      while (i < localReadInJoyXListView.getChildCount())
      {
        View localView = localReadInJoyXListView.getChildAt(i);
        if ((localView.getTag(2131379208) instanceof pbi))
        {
          Object localObject = ((pbi)localView.getTag(2131379208)).a();
          if ((localObject != null) && (AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject)) && ((localView instanceof ProteusItemView)))
          {
            localObject = ((ProteusItemView)localView).a();
            if (localObject != null)
            {
              localObject = ((Container)localObject).getVirtualView().findViewBaseByName("id_view_AdDownloadView");
              if ((localObject != null) && ((localObject instanceof oce))) {
                ((oce)localObject).l();
              }
            }
          }
          localView = localView.findViewById(2131362001);
          if ((localView != null) && ((localView instanceof ReadInJoyAdVideoGuide))) {
            ((ReadInJoyAdVideoGuide)localView).a();
          }
        }
        i += 1;
      }
    }
    sai.a("AdHandler", "refreshADVideoFeedsDownloadState", System.currentTimeMillis() - l);
  }
  
  private void j()
  {
    rao localrao = (rao)a();
    int i = b();
    if (localrao != null)
    {
      sht.a(i, localrao.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params, localrao.jdField_a_of_type_Long);
      localrao.jdField_a_of_type_Long = -2147483648L;
      localrao.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params = null;
    }
  }
  
  public int a()
  {
    return 1;
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = a(paramInt).intValue();
    ArticleInfo localArticleInfo = (ArticleInfo)a(paramInt);
    if (localArticleInfo != null) {
      localArticleInfo.mResolvedFeedType = i;
    }
    paramViewGroup = null;
    nyp.a(this.jdField_a_of_type_Nyp);
    if (oan.a(i)) {
      paramViewGroup = nyp.a(this.jdField_a_of_type_Nyp, paramView, localArticleInfo, i, paramInt);
    }
    for (;;)
    {
      if ((a() != null) && (a().a() != null) && (localArticleInfo != null) && (AdvertisementInfo.isAdvertisementInfo(localArticleInfo)))
      {
        paramView = (AdvertisementInfo)localArticleInfo;
        a().a().a(paramView, a().a());
      }
      return paramViewGroup;
      if (pqq.a(i)) {
        paramViewGroup = nyp.b(this.jdField_a_of_type_Nyp, paramView, localArticleInfo, i, paramInt);
      }
    }
  }
  
  public Boolean a()
  {
    if ((this.jdField_a_of_type_Obs != null) && (this.jdField_a_of_type_Obs.a())) {
      return Boolean.valueOf(true);
    }
    return super.a();
  }
  
  public void a()
  {
    i();
    j();
    if ((a() != null) && (a().a() != null)) {
      a().a().a();
    }
    if (oaw.a().a() == 1) {
      oaw.a().a(true);
    }
  }
  
  public void a(View paramView, ArticleInfo paramArticleInfo, int paramInt)
  {
    a(paramArticleInfo, -1L, paramView);
  }
  
  public void a(View paramView, ListView paramListView)
  {
    this.jdField_a_of_type_Int = b();
    this.jdField_a_of_type_ComTencentWidgetListView = paramListView;
    rap localrap = a();
    oaj localoaj = jdField_a_of_type_Oak.a(this.jdField_a_of_type_Int);
    paramListView = localoaj;
    if (localoaj == null)
    {
      paramListView = new oaj(this.jdField_a_of_type_Int);
      jdField_a_of_type_Oak.a(this.jdField_a_of_type_Int, paramListView);
    }
    localrap.a(paramListView);
    ozj.a().a(this.jdField_a_of_type_Int, localrap);
    osm.a().a(this.jdField_a_of_type_Osp);
    nyp.a(this.jdField_a_of_type_Nyp);
    a(paramView);
  }
  
  public void a(ReadInJoyBaseListView paramReadInJoyBaseListView, int paramInt)
  {
    paramReadInJoyBaseListView = a();
    if (paramReadInJoyBaseListView != null)
    {
      Object localObject = paramReadInJoyBaseListView.a();
      if (localObject != null) {
        ((qkl)localObject).jdField_a_of_type_Boolean = true;
      }
      localObject = paramReadInJoyBaseListView.a();
      if ((localObject != null) && (((qtu)localObject).a() != null))
      {
        qty localqty = ((qtu)localObject).a();
        if ((localqty != null) && (localqty.jdField_b_of_type_Boolean)) {
          ((qtu)localObject).b(11);
        }
      }
      paramReadInJoyBaseListView = paramReadInJoyBaseListView.a();
      if (paramReadInJoyBaseListView != null) {
        paramReadInJoyBaseListView.f();
      }
      if ((this.jdField_a_of_type_Int == 0) && (oaw.a().jdField_a_of_type_Boolean) && (bhvh.i()))
      {
        paramReadInJoyBaseListView = a();
        if ((paramReadInJoyBaseListView != null) && ((paramReadInJoyBaseListView instanceof ReadInJoyListViewGroup)))
        {
          if ((((ReadInJoyListViewGroup)paramReadInJoyBaseListView).f()) || (oaw.a().a().size() <= 0)) {
            break label160;
          }
          oaw.a().b(true);
          if (QLog.isColorLevel()) {
            QLog.d("AdHandler", 2, "setShouldAskSuperMask");
          }
        }
      }
    }
    return;
    label160:
    oaw.a().b(false);
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    b(paramAbsListView, paramInt);
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    c(paramAbsListView, paramInt1 + paramInt2 - 1);
  }
  
  public void a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = a((int)paramLong);
    if ((paramAdapterView != null) && ((paramAdapterView instanceof ArticleInfo)))
    {
      a((ArticleInfo)paramAdapterView, paramLong, paramView);
      oaw.a().a(4);
    }
  }
  
  public void a(boolean paramBoolean1, int paramInt, List<Long> paramList, boolean paramBoolean2)
  {
    if ((paramInt != this.jdField_a_of_type_Int) || (a() == null)) {}
    do
    {
      return;
      paramList = a();
    } while ((paramList == null) || (!(paramList instanceof ReadInJoyListViewGroup)) || (paramInt != 0));
    if ((!((ReadInJoyListViewGroup)paramList).f()) && (oaw.a().jdField_a_of_type_Boolean))
    {
      if (this.jdField_a_of_type_Obs == null) {
        this.jdField_a_of_type_Obs = new obs();
      }
      this.jdField_a_of_type_Obs.a(a(), this.jdField_a_of_type_ComTencentWidgetListView);
    }
    oaw.a().jdField_a_of_type_Boolean = false;
  }
  
  public boolean a(int paramInt)
  {
    nyp.a(this.jdField_a_of_type_Nyp);
    return oan.a(paramInt);
  }
  
  public void b()
  {
    bfsi localbfsi = a().a();
    if ((localbfsi != null) && (localbfsi.isShowing())) {
      localbfsi.dismiss();
    }
    if ((a() != null) && (a().a() != null)) {
      a().a().b(a());
    }
    if (oaw.a().a() == 1) {
      oaw.a().a(false);
    }
  }
  
  public void b(View paramView, ListView paramListView)
  {
    paramView = a();
    if (((paramListView instanceof ReadInJoyXListView)) && (paramView != null)) {
      ((ReadInJoyXListView)paramListView).setRefreshPullDistanceListener(new nyn(this, paramView));
    }
  }
  
  public void b(AbsListView paramAbsListView, int paramInt)
  {
    boolean bool = true;
    if ((paramInt == 1) && (this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.adStrategyType = 0;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = null;
    }
    if (paramInt == 2) {}
    for (;;)
    {
      this.jdField_b_of_type_Boolean = bool;
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = false;
        paramAbsListView.setInterpolator(null);
      }
      if (rap.a() != null)
      {
        paramAbsListView = (nzj)rap.a().getManager(307);
        if (paramAbsListView != null) {
          paramAbsListView.a(paramInt);
        }
      }
      return;
      bool = false;
    }
  }
  
  public void c()
  {
    super.c();
  }
  
  protected void c(AbsListView paramAbsListView, int paramInt)
  {
    if ((!this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_Boolean)) {}
    Object localObject1;
    Object localObject2;
    int j;
    View localView;
    do
    {
      do
      {
        return;
        float f = paramAbsListView.getFlingVelocityY();
        if ((f < this.jdField_a_of_type_Float) || (f > this.jdField_b_of_type_Float))
        {
          this.jdField_c_of_type_Int = paramInt;
          return;
        }
        if ((this.jdField_c_of_type_Int >= paramInt) || (paramInt >= paramAbsListView.getCount() - 1)) {
          break;
        }
        this.jdField_c_of_type_Int = paramInt;
        localObject1 = (ListAdapter)paramAbsListView.getAdapter();
        i = paramInt + 1;
        localObject2 = ((ListAdapter)localObject1).getItem(i);
      } while ((!(localObject2 instanceof BaseArticleInfo)) || (!AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject2)) || (!oat.c((AdvertisementInfo)localObject2)));
      j = ((ListAdapter)localObject1).getItemViewType(i);
      localView = (View)this.jdField_a_of_type_AndroidUtilSparseArray.get(j);
      if (localView != null) {
        break label374;
      }
      localObject1 = ((ListAdapter)localObject1).getView(i, null, paramAbsListView);
      this.jdField_a_of_type_AndroidUtilSparseArray.put(j, localObject1);
      localView = paramAbsListView.getChildAt(paramAbsListView.getLastVisiblePosition() - paramAbsListView.getFirstVisiblePosition());
      if ((localView == null) || (localObject1 == null)) {
        break;
      }
      j = paramAbsListView.getRemainFlingDisY();
    } while (j <= 0);
    int i = localView.getBottom();
    int k = paramAbsListView.getBottom();
    int m = paramAbsListView.getPaddingBottom();
    k = this.jdField_b_of_type_Int + (i - k - m);
    ViewGroup.LayoutParams localLayoutParams = ((View)localObject1).getLayoutParams();
    if (localLayoutParams != null)
    {
      i = localLayoutParams.width;
      label265:
      ((View)localObject1).measure(ViewGroup.getChildMeasureSpec(paramAbsListView.getMeasuredWidthAndState(), paramAbsListView.getPaddingLeft() + paramAbsListView.getPaddingRight(), i), 0);
      i = ((View)localObject1).getMeasuredHeight();
      if ((j > k) && (j < i / 1 + k))
      {
        this.jdField_a_of_type_Boolean = true;
        localObject1 = new AdHandler.3(this, localView, paramAbsListView, j, i);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = ((AdvertisementInfo)localObject2);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.adStrategyType = 1;
        if (Build.VERSION.SDK_INT < 16) {
          break label397;
        }
        paramAbsListView.postOnAnimation((Runnable)localObject1);
      }
    }
    for (;;)
    {
      this.jdField_c_of_type_Int = paramInt;
      return;
      label374:
      localObject1 = ((ListAdapter)localObject1).getView(i, localView, paramAbsListView);
      break;
      i = -1;
      break label265;
      label397:
      paramAbsListView.post((Runnable)localObject1);
    }
  }
  
  public void d()
  {
    ozj.a().b(this.jdField_a_of_type_Int);
    osm.a().b(this.jdField_a_of_type_Osp);
    if ((a() != null) && (a().a() != null)) {
      a().a().b();
    }
    if ((this.jdField_a_of_type_Obs != null) && (this.jdField_a_of_type_Obs.a())) {
      this.jdField_a_of_type_Obs.a();
    }
  }
  
  public void e()
  {
    rap localrap = a();
    if (localrap != null)
    {
      Object localObject = localrap.a();
      if (localObject != null) {
        ((qkl)localObject).jdField_a_of_type_Boolean = false;
      }
      if (rap.a() != null)
      {
        localObject = (nzj)rap.a().getManager(307);
        if (localObject != null)
        {
          ((nzj)localObject).a(localrap, localrap.a());
          if ((a() != null) && (a().a() != null)) {
            a().a().a(localrap, localrap.a());
          }
          ((nzj)localObject).a(localrap, localrap.a(), true);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nym
 * JD-Core Version:    0.7.0.1
 */