import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListFragment;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListView;
import com.tencent.biz.pubaccount.readinjoy.comment.data.AnchorData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.SubCommentData;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ListView;
import java.util.Iterator;
import java.util.List;

public class orv
  extends otd
  implements osk
{
  public static int a;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private ReadInJoyCommentListFragment jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment;
  private orw jdField_a_of_type_Orw;
  private osr jdField_a_of_type_Osr;
  private ovf jdField_a_of_type_Ovf;
  public int b;
  private int d;
  private int e = -1;
  private int f = -1;
  
  static
  {
    jdField_a_of_type_Int = 0;
  }
  
  public orv(FragmentActivity paramFragmentActivity, ReadInJoyCommentListFragment paramReadInJoyCommentListFragment, ReadInJoyCommentListView paramReadInJoyCommentListView, int paramInt)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramFragmentActivity);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramFragmentActivity;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment = paramReadInJoyCommentListFragment;
    this.jdField_a_of_type_Osr = paramReadInJoyCommentListFragment;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView = paramReadInJoyCommentListView;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setRefreshCallback(this);
    this.d = paramInt;
    jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Orc = new orc();
    this.jdField_a_of_type_Orc.a(a());
    this.jdField_a_of_type_Ors = new ors(paramReadInJoyCommentListView, this.jdField_a_of_type_JavaUtilList, this);
    this.jdField_a_of_type_Sph = new sph(paramFragmentActivity);
    this.jdField_a_of_type_Toa = new toa(paramFragmentActivity, null);
    this.jdField_a_of_type_Nzj = new nzj(paramFragmentActivity);
    paramReadInJoyCommentListView.setOnScrollListener(this.jdField_a_of_type_Blih);
    tpk.a(paramReadInJoyCommentListView, this.jdField_a_of_type_Sph);
  }
  
  public orv(FastWebActivity paramFastWebActivity, ReadInJoyCommentListView paramReadInJoyCommentListView, int paramInt)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramFastWebActivity);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramFastWebActivity;
    this.jdField_a_of_type_Osr = paramFastWebActivity;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView = paramReadInJoyCommentListView;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setRefreshCallback(this);
    this.d = paramInt;
    jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Orc = new orc();
    this.jdField_a_of_type_Orc.a(a());
    this.jdField_a_of_type_Ors = new ors(paramReadInJoyCommentListView, this.jdField_a_of_type_JavaUtilList, this);
    this.jdField_a_of_type_Sph = new sph(paramFastWebActivity);
    this.jdField_a_of_type_Toa = new toa(paramFastWebActivity, null);
    this.jdField_a_of_type_Nzj = new nzj(paramFastWebActivity);
    paramReadInJoyCommentListView.setOnScrollListener(this.jdField_a_of_type_Blih);
    tpk.a(paramReadInJoyCommentListView, this.jdField_a_of_type_Sph);
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_Osr != null) {
      this.jdField_a_of_type_Osr.b(paramInt);
    }
  }
  
  private void a(List<otp> paramList)
  {
    if (this.jdField_a_of_type_Otv.a() == null) {}
    for (;;)
    {
      return;
      Object localObject = this.jdField_a_of_type_Otv.a();
      if ((((ove)localObject).jdField_a_of_type_Boolean) && (((ove)localObject).b != null) && (paramList != null))
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          localObject = (otp)paramList.next();
          if ((localObject != null) && (((otp)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData != null) && (((otp)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.isAnchor)) {
            ((otp)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.isAnchor = false;
          }
        }
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    int i = 0;
    View localView;
    if ((paramBoolean) && (a() != null))
    {
      this.e = a().getFirstVisiblePosition();
      localView = a().getChildAt(0);
      if (localView != null) {
        break label43;
      }
    }
    for (;;)
    {
      this.f = i;
      return;
      label43:
      i = localView.getTop();
    }
  }
  
  private boolean b(int paramInt)
  {
    if ((this.c == 5) && ((paramInt == 3) || (paramInt == 2) || (paramInt == 5))) {
      this.c = paramInt;
    }
    while (this.c == paramInt) {
      return true;
    }
    return false;
  }
  
  private boolean c(int paramInt)
  {
    if ((paramInt == 2) && ((this.c == 2) || (this.c == 3))) {
      QLog.d("ReadInJoyCommentListAdapter", 1, "checkCommentCreateFeedsType");
    }
    while (this.c == paramInt) {
      return true;
    }
    return false;
  }
  
  public int a()
  {
    int j;
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      j = -1;
      return j;
    }
    int i = 0;
    for (;;)
    {
      if (i >= this.jdField_a_of_type_JavaUtilList.size()) {
        break label79;
      }
      otp localotp = (otp)this.jdField_a_of_type_JavaUtilList.get(i);
      j = i;
      if (localotp.jdField_a_of_type_Int == 2) {
        break;
      }
      j = i;
      if (localotp.jdField_a_of_type_Int == 1) {
        break;
      }
      i += 1;
    }
    label79:
    return -1;
  }
  
  LayoutInflater a()
  {
    return this.jdField_a_of_type_AndroidViewLayoutInflater;
  }
  
  public VafContext a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext == null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext = new qfg();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.setCurActivity(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.setContext(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      oyj.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, "comment_feeds");
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext;
  }
  
  osq a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment != null) {
      return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment.a();
    }
    return null;
  }
  
  public otp a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()) && (paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return (otp)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public otv a()
  {
    return this.jdField_a_of_type_Otv;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Otv != null)
    {
      this.jdField_a_of_type_Otv.a(this.c, 1);
      QLog.d("ReadInJoyCommentListAdapter", 2, "reloadData | feedsType " + this.c);
    }
  }
  
  public void a(ArticleInfo paramArticleInfo, AnchorData paramAnchorData, int paramInt)
  {
    QLog.d("ReadInJoyCommentListAdapter", 2, "initArticleCommentInfoModule | articleInfo " + paramArticleInfo + "; anchorData : " + paramAnchorData + "; contentSrc : " + paramInt + " reqFeedsType Default 5 currentFeedsType " + this.c);
    a(paramArticleInfo, paramAnchorData, true, 5, paramInt);
  }
  
  public void a(ArticleInfo paramArticleInfo, AnchorData paramAnchorData, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    QLog.d("ReadInJoyCommentListAdapter", 1, "initArticleCommentInfoModule | reqFeedsType " + paramInt1 + " ; currentFeedsType " + this.c + " ; articleInfo " + paramArticleInfo + "; anchorData : " + paramAnchorData + ";feedsType ：" + paramInt1 + "; contentSrc : " + paramInt2);
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
    this.c = paramInt1;
    this.jdField_a_of_type_Otv = otv.a(paramArticleInfo, paramInt2);
    String str;
    if (this.jdField_a_of_type_Otv != null)
    {
      this.jdField_a_of_type_Otv.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData);
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment.a())) {
        this.jdField_a_of_type_Otv.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment.b(), paramInt1);
      }
      this.jdField_a_of_type_Osm = new osm(this, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, paramInt2);
      this.jdField_a_of_type_Otv.a(this);
      if ((paramAnchorData != null) && (!TextUtils.isEmpty(paramAnchorData.jdField_a_of_type_JavaLangString)))
      {
        paramArticleInfo = paramAnchorData.jdField_a_of_type_JavaLangString;
        str = paramAnchorData.b;
        if (paramAnchorData.jdField_a_of_type_Boolean) {
          break label270;
        }
      }
    }
    label270:
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramArticleInfo = new ove(paramArticleInfo, str, paramBoolean, paramAnchorData.jdField_a_of_type_Boolean);
      this.jdField_a_of_type_Otv.a(paramArticleInfo);
      this.jdField_a_of_type_Otv.a(paramInt1, 1);
      this.jdField_a_of_type_JavaUtilList.clear();
      notifyDataSetChanged();
      tpk.c();
      return;
    }
  }
  
  public void a(ListView paramListView)
  {
    if (this.jdField_a_of_type_Otv != null)
    {
      this.jdField_a_of_type_Otv.b(this.c);
      QLog.d("ReadInJoyCommentListAdapter", 2, "startLoadMore | feedsType " + this.c);
    }
    if (this.jdField_a_of_type_Osm != null) {
      this.jdField_a_of_type_Osm.b();
    }
  }
  
  public void a(orw paramorw)
  {
    this.jdField_a_of_type_Orw = paramorw;
  }
  
  public void a(otp paramotp)
  {
    super.a(paramotp);
    if (this.jdField_a_of_type_Osm != null) {
      this.jdField_a_of_type_Osm.a(1, paramotp);
    }
  }
  
  public void a(otp paramotp, SubCommentData paramSubCommentData, int paramInt)
  {
    if ((this.jdField_a_of_type_Osr != null) && (paramotp != null) && (paramotp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) && (paramotp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData != null))
    {
      String str = null;
      if (paramSubCommentData != null) {
        str = paramSubCommentData.commentId;
      }
      this.jdField_a_of_type_Osr.a(true, paramotp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.commentId, str);
      if (this.jdField_a_of_type_Osm != null) {
        this.jdField_a_of_type_Osm.a(paramotp, paramInt);
      }
    }
  }
  
  public void a(ovf paramovf)
  {
    this.jdField_a_of_type_Ovf = paramovf;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment.b();
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment.c();
    }
  }
  
  public void d()
  {
    long l = 0L;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment != null) {
      l = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment.a();
    }
    if (this.jdField_a_of_type_Otv != null) {
      this.jdField_a_of_type_Otv.a(this);
    }
    if ((this.jdField_a_of_type_Osm != null) && (jdField_a_of_type_Int != 1)) {
      this.jdField_a_of_type_Osm.a(l, 2);
    }
    this.jdField_a_of_type_AndroidViewLayoutInflater = null;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = null;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = null;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment = null;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.setCurActivity(null);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext = null;
    }
    tpk.d();
    if (this.jdField_a_of_type_Toa != null) {
      this.jdField_a_of_type_Toa.b();
    }
    if (this.jdField_a_of_type_Nzj != null) {
      this.jdField_a_of_type_Nzj.a();
    }
    if (this.jdField_a_of_type_Sph != null) {
      this.jdField_a_of_type_Sph.a();
    }
  }
  
  public void e()
  {
    h();
  }
  
  public void f()
  {
    h();
  }
  
  public void g()
  {
    if ((a() != null) && (this.e > -1)) {
      a().setSelectionFromTop(this.e, this.f);
    }
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      return this.jdField_a_of_type_JavaUtilList.size();
    }
    return 0;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext = a();
    Object localObject = paramView;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null)
      {
        localObject = paramView;
        if ((paramView.getTag() instanceof String))
        {
          localObject = paramView;
          if ("non_null_convertview".equalsIgnoreCase((String)paramView.getTag()))
          {
            localObject = null;
            QLog.d("ReadInJoyCommentListAdapter", 1, "getView | first comment reset NonNullView");
          }
        }
      }
    }
    int i = getItemViewType(paramInt);
    if (i == 6)
    {
      paramView = this.jdField_a_of_type_Otv.a().a(paramViewGroup, (View)localObject, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, a(paramInt));
      EventCollector.getInstance().onListGetView(paramInt, (View)localObject, paramViewGroup, getItemId(paramInt));
      return paramView;
    }
    TemplateBean localTemplateBean;
    if (orc.a(a(paramInt)))
    {
      localTemplateBean = this.jdField_a_of_type_Orc.a(a(paramInt));
      if (localObject != null) {
        break label424;
      }
    }
    label421:
    label424:
    for (paramView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getViewFactory().inflate(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, localTemplateBean);; paramView = (View)localObject)
    {
      orc.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, (Container)paramView, localTemplateBean, this, paramInt, i, true);
      localObject = paramView;
      tpk.a(this, a(paramInt), paramInt, (View)localObject);
      if (this.jdField_a_of_type_Osm != null) {
        this.jdField_a_of_type_Osm.c(paramInt);
      }
      if (this.jdField_a_of_type_Otj != null) {
        this.jdField_a_of_type_Otj.a(paramInt, (View)localObject);
      }
      paramView = (View)localObject;
      if (localObject == null)
      {
        localObject = new StringBuilder().append("getView | first comment convertview is null ; position ").append(paramInt).append(" viewtype ").append(i).append("\n commentItem: ");
        if (a(paramInt) != null)
        {
          paramView = a(paramInt).jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
          label298:
          localObject = paramView;
          QLog.d("ReadInJoyCommentListAdapter", 1, (String)localObject);
          paramView = a();
          agej.a("ReadInJoyCommentListAdapter", "first comment convertview is null", new NullPointerException((String)localObject));
        }
      }
      else
      {
        localObject = paramView;
        break;
        paramView = oqy.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, a(paramInt), i, true, this);
        if (localObject != null) {
          break label421;
        }
        blqm.a("ReadInJoyCommentAdapter.create convertView");
        localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getViewFactory().inflate(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, paramView);
        blqm.a();
      }
      for (;;)
      {
        oqy.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, (Container)localObject, paramView, this, paramInt, i, true);
        break;
        paramView = "commentData is null";
        break label298;
      }
    }
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView == null) {
      return;
    }
    int j = a();
    if (this.d != 1)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.smoothScrollBy(0, 0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.smoothScrollToPosition(j);
      QLog.d("ReadInJoyCommentListAdapter", 2, "scrollToComment | contentSrc " + this.d + "; titlePos " + j);
      return;
    }
    ListAdapter localListAdapter = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getAdapter();
    Object localObject = localListAdapter;
    if ((localListAdapter instanceof blmb)) {
      localObject = ((blmb)localListAdapter).getWrappedAdapter();
    }
    if ((localObject instanceof sol))
    {
      localObject = ((sol)localObject).a().iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localListAdapter = (ListAdapter)((Iterator)localObject).next();
      } while (!(localListAdapter instanceof sop));
    }
    for (int i = localListAdapter.getCount();; i = -1)
    {
      QLog.d("ReadInJoyCommentListAdapter", 1, "scrollToComment | articleItemCnt: " + i + " titlePos : " + j);
      if (i != -1) {
        i += j;
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.smoothScrollBy(0, 0);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.smoothScrollToPositionFromTop(i, 0);
        return;
        i = j;
      }
    }
  }
  
  public void onClick(ViewBase paramViewBase) {}
  
  public void onCommentCreate(boolean paramBoolean, otp paramotp, List<otp> paramList, int paramInt)
  {
    if (!c(paramInt)) {
      QLog.d("ReadInJoyCommentListAdapter", 1, "onCommentCreate | wrong feedstype , currentFeedsType " + this.c + ", feedsType " + paramInt);
    }
    do
    {
      return;
      if (!paramBoolean) {
        break;
      }
      this.c = 2;
      int i = 2131717057;
      if (onn.a()) {
        i = 2131717003;
      }
      QQToast.a(BaseApplication.getContext(), 2, i, 0).a();
      a(4);
      if ((paramList != null) && (paramList.size() > 0))
      {
        QLog.d("ReadInJoyCommentListAdapter", 2, "onCommentCreate commentViewItemList size " + paramList.size());
        if (this.jdField_a_of_type_JavaUtilList != null)
        {
          this.jdField_a_of_type_JavaUtilList.clear();
          this.jdField_a_of_type_JavaUtilList.addAll(paramList);
          notifyDataSetChanged();
          e();
        }
      }
      if (this.jdField_a_of_type_Orw != null) {
        this.jdField_a_of_type_Orw.a(this.jdField_a_of_type_Otv.a(paramInt));
      }
      paramList = a().getIntent().getBundleExtra("bundle");
    } while (paramList == null);
    BaseCommentData localBaseCommentData = paramotp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
    paramotp = "";
    if ((localBaseCommentData instanceof SubCommentData)) {
      paramotp = ((SubCommentData)localBaseCommentData).parentCommentId;
    }
    pfd.a().a(true, localBaseCommentData.rowKey, localBaseCommentData.commentId, localBaseCommentData.commentContent, localBaseCommentData.level, "onCommentSend", paramList.getInt("seq"), paramotp);
    return;
    QQToast.a(BaseApplication.getContext(), 1, anzj.a(2131711667), 0).a();
  }
  
  public void onCommentCreate(boolean paramBoolean1, otp paramotp, boolean paramBoolean2, List<otp> paramList, int paramInt)
  {
    if (!c(paramInt))
    {
      QLog.d("ReadInJoyCommentListAdapter", 1, "onCommentCreate | wrong feedstype , currentFeedsType " + this.c + ", feedsType " + paramInt);
      return;
    }
    this.c = 2;
    a(paramBoolean2);
    onCommentCreate(paramBoolean1, paramotp, paramList, paramInt);
  }
  
  public void onCommentDelete(int paramInt1, boolean paramBoolean, otp paramotp, int paramInt2)
  {
    if ((!paramBoolean) || (this.jdField_a_of_type_Otv == null)) {
      return;
    }
    if (!a(paramInt2))
    {
      QLog.d("ReadInJoyCommentListAdapter", 1, "onCommentDelete | wrong feedstype , currentFeedsType " + this.c + ", feedsType " + paramInt2);
      return;
    }
    if (paramInt1 == 1)
    {
      paramotp = this.jdField_a_of_type_Otv.a(paramInt2);
      if ((paramotp != null) && (this.jdField_a_of_type_JavaUtilList != null))
      {
        this.jdField_a_of_type_JavaUtilList.clear();
        this.jdField_a_of_type_JavaUtilList.addAll(paramotp);
        notifyDataSetChanged();
      }
    }
    for (;;)
    {
      if (getCount() <= 0) {
        a(2);
      }
      if (this.jdField_a_of_type_Orw == null) {
        break;
      }
      this.jdField_a_of_type_Orw.a(this.jdField_a_of_type_Otv.a(paramInt2));
      return;
      if ((paramInt1 == 2) && (this.jdField_a_of_type_JavaUtilList != null))
      {
        paramInt1 = 0;
        if (paramInt1 < this.jdField_a_of_type_JavaUtilList.size())
        {
          otp localotp = (otp)this.jdField_a_of_type_JavaUtilList.get(paramInt1);
          if ((localotp == null) || (localotp.jdField_a_of_type_Int != 0)) {}
          for (;;)
          {
            paramInt1 += 1;
            break;
            if ((paramotp != null) && (paramotp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData != null) && (localotp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData != null) && (TextUtils.equals(localotp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.commentId, ((SubCommentData)paramotp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData).parentCommentId))) {
              localotp.a();
            }
          }
        }
        notifyDataSetChanged();
      }
    }
  }
  
  public void onCommentLikeOrDislike(boolean paramBoolean, String paramString, int paramInt1, int paramInt2) {}
  
  public void onCommentListLoad(int paramInt1, boolean paramBoolean1, List<otp> paramList, boolean paramBoolean2, int paramInt2, int paramInt3)
  {
    if (paramInt1 != 1)
    {
      QLog.d("ReadInJoyCommentListAdapter", 1, "onCommentListLoad  | isNot first level Comment");
      return;
    }
    if (!b(paramInt3))
    {
      QLog.d("ReadInJoyCommentListAdapter", 1, "onCommentListLoad | wrong feedstype , currentFeedsType " + this.c + ", feedsType " + paramInt3);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder().append("onCommentListLoad first comments ").append(paramBoolean1).append(" feedsType : ").append(paramInt2).append("\n commentDataListSize ");
    if (paramList != null) {}
    for (int i = paramList.size();; i = 0)
    {
      QLog.d("ReadInJoyCommentListAdapter", 1, i);
      if (paramBoolean1) {
        break;
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.c();
      }
      a(3);
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.a(paramBoolean2);
    }
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramList != null) && (!paramList.isEmpty()))
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
      a(4);
      a(paramList);
    }
    for (;;)
    {
      notifyDataSetChanged();
      if (this.jdField_a_of_type_Ovf != null) {
        this.jdField_a_of_type_Ovf.onCommentListLoad(paramInt1, paramBoolean1, paramList, paramBoolean2, paramInt2, paramInt3);
      }
      if (this.jdField_a_of_type_Orw != null)
      {
        long l = this.jdField_a_of_type_Otv.a(this.c);
        this.jdField_a_of_type_Orw.a(l);
        QLog.d("ReadInJoyCommentListAdapter", 2, "onCommentListLoad | mCommentNumChangedListener onUpdate feedsType " + this.c + " count : " + l);
      }
      if (this.jdField_a_of_type_Sph == null) {
        break;
      }
      tpk.a(this.jdField_a_of_type_Sph, 0, paramList);
      this.jdField_a_of_type_Sph.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView);
      return;
      a(2);
    }
  }
  
  public void onCommentLoadMore(int paramInt1, boolean paramBoolean1, List<otp> paramList, boolean paramBoolean2, int paramInt2)
  {
    if (paramInt1 != 1) {}
    do
    {
      do
      {
        do
        {
          return;
          if (!a(paramInt2))
          {
            QLog.d("ReadInJoyCommentListAdapter", 1, "onCommentLoadMore | wrong feedstype , currentFeedsType " + this.c + ", feedsType " + paramInt2);
            return;
          }
          if (!paramBoolean1) {
            break;
          }
        } while ((this.jdField_a_of_type_JavaUtilList == null) || (paramList == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView == null));
        paramInt1 = this.jdField_a_of_type_JavaUtilList.size();
        this.jdField_a_of_type_JavaUtilList.addAll(paramList);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.a(paramBoolean2);
        notifyDataSetChanged();
      } while (this.jdField_a_of_type_Sph == null);
      tpk.a(this.jdField_a_of_type_Sph, paramInt1, paramList);
      this.jdField_a_of_type_Sph.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView);
      return;
    } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView == null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.a(paramBoolean2);
  }
  
  public void onCommentReply(boolean paramBoolean, otp paramotp)
  {
    if (paramotp == null) {}
    Object localObject;
    do
    {
      return;
      if (!paramBoolean) {
        break;
      }
      QQToast.a(BaseApplication.getContext(), 2, anzj.a(2131712004), 0).a();
      if (this.jdField_a_of_type_JavaUtilList != null)
      {
        int i = 0;
        if (i < this.jdField_a_of_type_JavaUtilList.size())
        {
          localObject = (otp)this.jdField_a_of_type_JavaUtilList.get(i);
          if ((localObject == null) || (((otp)localObject).jdField_a_of_type_Int != 0) || (((otp)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData == null)) {}
          for (;;)
          {
            i += 1;
            break;
            if (TextUtils.equals(((otp)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.commentId, ((SubCommentData)paramotp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData).parentCommentId)) {
              ((otp)localObject).a();
            }
          }
        }
        notifyDataSetChanged();
      }
      if (this.jdField_a_of_type_Orw != null) {
        this.jdField_a_of_type_Orw.a(this.jdField_a_of_type_Otv.a(this.c));
      }
      localObject = a().getIntent().getBundleExtra("bundle");
    } while (localObject == null);
    BaseCommentData localBaseCommentData = paramotp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
    paramotp = "";
    if ((localBaseCommentData instanceof SubCommentData)) {
      paramotp = ((SubCommentData)localBaseCommentData).parentCommentId;
    }
    pfd.a().a(true, localBaseCommentData.rowKey, localBaseCommentData.commentId, localBaseCommentData.commentContent, localBaseCommentData.level, "onCommentSend", ((Bundle)localObject).getInt("seq"), paramotp);
    return;
    QQToast.a(BaseApplication.getContext(), 1, anzj.a(2131711767), 0).a();
  }
  
  public void onCommentStateError(int paramInt)
  {
    if (this.jdField_a_of_type_Ovf != null) {
      this.jdField_a_of_type_Ovf.onCommentStateError(paramInt);
    }
    while (paramInt != 1001) {
      return;
    }
    zyx.a(1, 2131717045);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     orv
 * JD-Core Version:    0.7.0.1
 */