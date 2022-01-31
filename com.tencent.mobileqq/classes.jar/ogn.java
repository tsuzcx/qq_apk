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
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.util.Iterator;
import java.util.List;

public class ogn
  extends ohs
  implements oha
{
  public static int a;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private ReadInJoyCommentListFragment jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment;
  private ogo jdField_a_of_type_Ogo;
  private ohh jdField_a_of_type_Ohh;
  private ojp jdField_a_of_type_Ojp;
  public int b;
  private int d;
  private int e = -1;
  private int f = -1;
  
  static
  {
    jdField_a_of_type_Int = 0;
  }
  
  public ogn(FragmentActivity paramFragmentActivity, ReadInJoyCommentListFragment paramReadInJoyCommentListFragment, ReadInJoyCommentListView paramReadInJoyCommentListView, int paramInt)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramFragmentActivity);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramFragmentActivity;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment = paramReadInJoyCommentListFragment;
    this.jdField_a_of_type_Ohh = paramReadInJoyCommentListFragment;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView = paramReadInJoyCommentListView;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setRefreshCallback(this);
    this.d = paramInt;
    jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Oft = new oft();
    this.jdField_a_of_type_Oft.a(a());
    this.jdField_a_of_type_Ogk = new ogk(paramReadInJoyCommentListView, this.jdField_a_of_type_JavaUtilList, this);
    paramReadInJoyCommentListView.setOnScrollListener(this.jdField_a_of_type_Bfos);
  }
  
  public ogn(FastWebActivity paramFastWebActivity, ReadInJoyCommentListView paramReadInJoyCommentListView, int paramInt)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramFastWebActivity);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramFastWebActivity;
    this.jdField_a_of_type_Ohh = paramFastWebActivity;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView = paramReadInJoyCommentListView;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setRefreshCallback(this);
    this.d = paramInt;
    jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Oft = new oft();
    this.jdField_a_of_type_Oft.a(a());
    this.jdField_a_of_type_Ogk = new ogk(paramReadInJoyCommentListView, this.jdField_a_of_type_JavaUtilList, this);
    paramReadInJoyCommentListView.setOnScrollListener(this.jdField_a_of_type_Bfos);
  }
  
  private void a(List<oif> paramList)
  {
    if (this.jdField_a_of_type_Oil.a() == null) {}
    for (;;)
    {
      return;
      Object localObject = this.jdField_a_of_type_Oil.a();
      if ((((ojo)localObject).jdField_a_of_type_Boolean) && (((ojo)localObject).b != null) && (paramList != null))
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          localObject = (oif)paramList.next();
          if ((localObject != null) && (((oif)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData != null) && (((oif)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.isAnchor)) {
            ((oif)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.isAnchor = false;
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
  
  private void b(int paramInt)
  {
    if (this.jdField_a_of_type_Ohh != null) {
      this.jdField_a_of_type_Ohh.b(paramInt);
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
      oif localoif = (oif)this.jdField_a_of_type_JavaUtilList.get(i);
      j = i;
      if (localoif.jdField_a_of_type_Int == 2) {
        break;
      }
      j = i;
      if (localoif.jdField_a_of_type_Int == 1) {
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
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext = new pol();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.setCurActivity(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.setContext(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      olo.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, "comment_feeds");
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext;
  }
  
  ohg a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment != null) {
      return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment.a();
    }
    return null;
  }
  
  public oif a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()) && (paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return (oif)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public oil a()
  {
    return this.jdField_a_of_type_Oil;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Oil != null)
    {
      this.jdField_a_of_type_Oil.a(this.c, 1);
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
    this.jdField_a_of_type_Oil = oil.a(paramArticleInfo, paramInt2);
    String str;
    if (this.jdField_a_of_type_Oil != null)
    {
      this.jdField_a_of_type_Oil.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData);
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment.a())) {
        this.jdField_a_of_type_Oil.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment.b(), paramInt1);
      }
      this.jdField_a_of_type_Ohc = new ohc(this, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, paramInt2);
      this.jdField_a_of_type_Oil.a(this);
      if ((paramAnchorData != null) && (!TextUtils.isEmpty(paramAnchorData.jdField_a_of_type_JavaLangString)))
      {
        paramArticleInfo = paramAnchorData.jdField_a_of_type_JavaLangString;
        str = paramAnchorData.b;
        if (paramAnchorData.jdField_a_of_type_Boolean) {
          break label261;
        }
      }
    }
    label261:
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramArticleInfo = new ojo(paramArticleInfo, str, paramBoolean, paramAnchorData.jdField_a_of_type_Boolean);
      this.jdField_a_of_type_Oil.a(paramArticleInfo);
      this.jdField_a_of_type_Oil.a(paramInt1, 1);
      this.jdField_a_of_type_JavaUtilList.clear();
      notifyDataSetChanged();
      return;
    }
  }
  
  public void a(ListView paramListView)
  {
    if (this.jdField_a_of_type_Oil != null)
    {
      this.jdField_a_of_type_Oil.b(this.c);
      QLog.d("ReadInJoyCommentListAdapter", 2, "startLoadMore | feedsType " + this.c);
    }
    if (this.jdField_a_of_type_Ohc != null) {
      this.jdField_a_of_type_Ohc.c();
    }
  }
  
  public void a(ogo paramogo)
  {
    this.jdField_a_of_type_Ogo = paramogo;
  }
  
  public void a(oif paramoif)
  {
    super.a(paramoif);
    if (this.jdField_a_of_type_Ohc != null) {
      this.jdField_a_of_type_Ohc.a(1, paramoif);
    }
  }
  
  public void a(oif paramoif, SubCommentData paramSubCommentData)
  {
    if ((this.jdField_a_of_type_Ohh != null) && (paramoif != null) && (paramoif.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) && (paramoif.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData != null))
    {
      String str = null;
      if (paramSubCommentData != null) {
        str = paramSubCommentData.commentId;
      }
      this.jdField_a_of_type_Ohh.a(true, paramoif.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.commentId, str);
      if (this.jdField_a_of_type_Ohc != null) {
        this.jdField_a_of_type_Ohc.a(paramoif, paramSubCommentData);
      }
    }
  }
  
  public void a(ojp paramojp)
  {
    this.jdField_a_of_type_Ojp = paramojp;
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
    if (this.jdField_a_of_type_Oil != null) {
      this.jdField_a_of_type_Oil.a(this);
    }
    if ((this.jdField_a_of_type_Ohc != null) && (jdField_a_of_type_Int != 1)) {
      this.jdField_a_of_type_Ohc.a(l, 2);
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
    int i = getItemViewType(paramInt);
    if (i == 6)
    {
      paramViewGroup = this.jdField_a_of_type_Oil.a().a(paramViewGroup, paramView, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, a(paramInt));
      return paramViewGroup;
    }
    if (oft.a(a(paramInt)))
    {
      paramViewGroup = this.jdField_a_of_type_Oft.a(a(paramInt));
      if (paramView != null) {
        break label271;
      }
      paramView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getViewFactory().inflate(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, paramViewGroup);
    }
    label271:
    for (;;)
    {
      oft.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, (Container)paramView, paramViewGroup, this, paramInt, i, true);
      if (this.jdField_a_of_type_Ohc != null) {
        this.jdField_a_of_type_Ohc.c(paramInt);
      }
      if (this.jdField_a_of_type_Oia != null) {
        this.jdField_a_of_type_Oia.a(paramInt, paramView);
      }
      paramViewGroup = paramView;
      if (paramView != null) {
        break;
      }
      QLog.d("ReadInJoyCommentListAdapter", 2, "comment convertview is null position " + paramInt + " viewtype " + i + "\n commentItem: " + a(paramInt).jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData);
      return paramView;
      paramViewGroup = ofa.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, a(paramInt), i, true, this);
      if (paramView == null)
      {
        bfwu.a("ReadInJoyCommentAdapter.create convertView");
        paramView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getViewFactory().inflate(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, paramViewGroup);
        bfwu.a();
      }
      for (;;)
      {
        ofa.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, (Container)paramView, paramViewGroup, this, paramInt, i, true);
        break;
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
    if ((localListAdapter instanceof bfsi)) {
      localObject = ((bfsi)localListAdapter).getWrappedAdapter();
    }
    if ((localObject instanceof rjp))
    {
      localObject = ((rjp)localObject).a().iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localListAdapter = (ListAdapter)((Iterator)localObject).next();
      } while (!(localListAdapter instanceof rjt));
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
  
  public void onCommentCreate(boolean paramBoolean, oif paramoif, List<oif> paramList, int paramInt)
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
      b(4);
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
      if (this.jdField_a_of_type_Ogo != null) {
        this.jdField_a_of_type_Ogo.a(this.jdField_a_of_type_Oil.a(paramInt));
      }
      paramList = a().getIntent().getBundleExtra("bundle");
    } while (paramList == null);
    BaseCommentData localBaseCommentData = paramoif.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
    paramoif = "";
    if ((localBaseCommentData instanceof SubCommentData)) {
      paramoif = ((SubCommentData)localBaseCommentData).parentCommentId;
    }
    osj.a().a(true, localBaseCommentData.rowKey, localBaseCommentData.commentId, localBaseCommentData.commentContent, localBaseCommentData.level, "onCommentSend", paramList.getInt("seq"), paramoif);
    return;
    bcql.a(BaseApplication.getContext(), 1, ajya.a(2131712795), 0).a();
  }
  
  public void onCommentCreate(boolean paramBoolean1, oif paramoif, boolean paramBoolean2, List<oif> paramList, int paramInt)
  {
    if (!c(paramInt))
    {
      QLog.d("ReadInJoyCommentListAdapter", 1, "onCommentCreate | wrong feedstype , currentFeedsType " + this.c + ", feedsType " + paramInt);
      return;
    }
    a(paramBoolean2);
    onCommentCreate(paramBoolean1, paramoif, paramList, paramInt);
  }
  
  public void onCommentDelete(int paramInt1, boolean paramBoolean, oif paramoif, int paramInt2)
  {
    if ((!paramBoolean) || (this.jdField_a_of_type_Oil == null)) {
      return;
    }
    if (!a(paramInt2))
    {
      QLog.d("ReadInJoyCommentListAdapter", 1, "onCommentDelete | wrong feedstype , currentFeedsType " + this.c + ", feedsType " + paramInt2);
      return;
    }
    if (paramInt1 == 1)
    {
      paramoif = this.jdField_a_of_type_Oil.a(paramInt2);
      if ((paramoif != null) && (this.jdField_a_of_type_JavaUtilList != null))
      {
        this.jdField_a_of_type_JavaUtilList.clear();
        this.jdField_a_of_type_JavaUtilList.addAll(paramoif);
        notifyDataSetChanged();
      }
    }
    for (;;)
    {
      if (getCount() <= 0) {
        b(2);
      }
      if (this.jdField_a_of_type_Ogo == null) {
        break;
      }
      this.jdField_a_of_type_Ogo.a(this.jdField_a_of_type_Oil.a(paramInt2));
      return;
      if ((paramInt1 == 2) && (this.jdField_a_of_type_JavaUtilList != null))
      {
        paramInt1 = 0;
        if (paramInt1 < this.jdField_a_of_type_JavaUtilList.size())
        {
          oif localoif = (oif)this.jdField_a_of_type_JavaUtilList.get(paramInt1);
          if ((localoif == null) || (localoif.jdField_a_of_type_Int != 0)) {}
          for (;;)
          {
            paramInt1 += 1;
            break;
            if ((paramoif != null) && (paramoif.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData != null) && (localoif.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData != null) && (TextUtils.equals(localoif.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.commentId, ((SubCommentData)paramoif.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData).parentCommentId))) {
              localoif.a();
            }
          }
        }
        notifyDataSetChanged();
      }
    }
  }
  
  public void onCommentLikeOrDislike(boolean paramBoolean, String paramString, int paramInt1, int paramInt2) {}
  
  public void onCommentListLoad(int paramInt1, boolean paramBoolean1, List<oif> paramList, boolean paramBoolean2, int paramInt2, int paramInt3)
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
      b(3);
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.a(paramBoolean2);
    }
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramList != null) && (!paramList.isEmpty()))
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
      b(4);
      a(paramList);
    }
    for (;;)
    {
      notifyDataSetChanged();
      if (this.jdField_a_of_type_Ojp != null) {
        this.jdField_a_of_type_Ojp.onCommentListLoad(paramInt1, paramBoolean1, paramList, paramBoolean2, paramInt2, paramInt3);
      }
      if (this.jdField_a_of_type_Ogo == null) {
        break;
      }
      long l = this.jdField_a_of_type_Oil.a(this.c);
      this.jdField_a_of_type_Ogo.a(l);
      QLog.d("ReadInJoyCommentListAdapter", 2, "onCommentListLoad | mCommentNumChangedListener onUpdate feedsType " + this.c + " count : " + l);
      return;
      b(2);
    }
  }
  
  public void onCommentLoadMore(int paramInt1, boolean paramBoolean1, List<oif> paramList, boolean paramBoolean2, int paramInt2)
  {
    if (paramInt1 != 1) {}
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
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.a(paramBoolean2);
      notifyDataSetChanged();
      return;
    } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView == null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.a(paramBoolean2);
  }
  
  public void onCommentReply(boolean paramBoolean, oif paramoif)
  {
    if (paramoif == null) {}
    Object localObject;
    do
    {
      return;
      if (!paramBoolean) {
        break;
      }
      bcql.a(BaseApplication.getContext(), 2, ajya.a(2131713132), 0).a();
      if (this.jdField_a_of_type_JavaUtilList != null)
      {
        int i = 0;
        if (i < this.jdField_a_of_type_JavaUtilList.size())
        {
          localObject = (oif)this.jdField_a_of_type_JavaUtilList.get(i);
          if ((localObject == null) || (((oif)localObject).jdField_a_of_type_Int != 0) || (((oif)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData == null)) {}
          for (;;)
          {
            i += 1;
            break;
            if (TextUtils.equals(((oif)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.commentId, ((SubCommentData)paramoif.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData).parentCommentId)) {
              ((oif)localObject).a();
            }
          }
        }
        notifyDataSetChanged();
      }
      if (this.jdField_a_of_type_Ogo != null) {
        this.jdField_a_of_type_Ogo.a(this.jdField_a_of_type_Oil.a(this.c));
      }
      localObject = a().getIntent().getBundleExtra("bundle");
    } while (localObject == null);
    BaseCommentData localBaseCommentData = paramoif.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
    paramoif = "";
    if ((localBaseCommentData instanceof SubCommentData)) {
      paramoif = ((SubCommentData)localBaseCommentData).parentCommentId;
    }
    osj.a().a(true, localBaseCommentData.rowKey, localBaseCommentData.commentId, localBaseCommentData.commentContent, localBaseCommentData.level, "onCommentSend", ((Bundle)localObject).getInt("seq"), paramoif);
    return;
    bcql.a(BaseApplication.getContext(), 1, ajya.a(2131712895), 0).a();
  }
  
  public void onCommentStateError(int paramInt)
  {
    if (this.jdField_a_of_type_Ojp != null) {
      this.jdField_a_of_type_Ojp.onCommentStateError(paramInt);
    }
    while (paramInt != 1001) {
      return;
    }
    wij.a(1, 2131718368);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ogn
 * JD-Core Version:    0.7.0.1
 */