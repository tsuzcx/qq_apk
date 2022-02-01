import android.app.Activity;
import android.support.v7.widget.RecyclerView.Adapter;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.ProteusItemView;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.pull2refresh.RecyclerViewWithHeaderFooter;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

public class pud
  extends ptr<Long, BaseArticleInfo>
{
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new pue(this);
  private pub jdField_a_of_type_Pub = new pub();
  private int b = -1;
  
  public pud(Activity paramActivity, RecyclerViewWithHeaderFooter paramRecyclerViewWithHeaderFooter, int paramInt)
  {
    super(paramActivity, paramRecyclerViewWithHeaderFooter, paramInt);
    this.jdField_a_of_type_Pub.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, 3);
  }
  
  private BaseArticleInfo a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return (BaseArticleInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  private void a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    try
    {
      if (!TextUtils.isEmpty(paramBaseArticleInfo.proteusItemsData))
      {
        paramBaseArticleInfo = new JSONObject(paramBaseArticleInfo.proteusItemsData).getString("style_ID");
        if (!TextUtils.isEmpty(paramBaseArticleInfo))
        {
          QLog.d("ReadInJoyDynamicChannelAdapter", 2, new Object[] { "addViewTypeStyleMap, adapterViewType = ", Integer.valueOf(paramInt), ", styleID = ", paramBaseArticleInfo });
          this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), paramBaseArticleInfo);
          return;
        }
        QLog.d("ReadInJoyDynamicChannelAdapter", 2, "addViewTypeStyleMap, styleID is null");
        return;
      }
    }
    catch (JSONException paramBaseArticleInfo)
    {
      QLog.d("ReadInJoyDynamicChannelAdapter", 1, "addViewTypeStyleMap, e", paramBaseArticleInfo);
      return;
    }
    QLog.d("ReadInJoyDynamicChannelAdapter", 2, "addViewTypeStyleMap, proteusItemData is empty");
  }
  
  private void a(ArticleInfo paramArticleInfo)
  {
    qfg localqfg = pvj.a().a();
    ArticleInfo localArticleInfo = paramArticleInfo;
    if (pqw.g(paramArticleInfo))
    {
      localArticleInfo = paramArticleInfo;
      if (!paramArticleInfo.mNewPolymericInfo.a) {
        localArticleInfo = ReadInJoyListViewGroup.a(paramArticleInfo);
      }
    }
    if (localqfg != null) {
      this.b = localqfg.a(localArticleInfo.mArticleContentUrl, String.valueOf(localArticleInfo.innerUniqueID), localArticleInfo.mSubscribeID, 1, null);
    }
    b(localArticleInfo);
  }
  
  private void b(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null)
    {
      QLog.d("ReadInJoyDynamicChannelAdapter", 2, "startWebFastActivity, articleInfo is null.");
      return;
    }
    pqx.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramArticleInfo);
  }
  
  public blij a(ViewGroup paramViewGroup, int paramInt)
  {
    if (this.jdField_a_of_type_Pub.a(paramInt))
    {
      Object localObject = (String)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        paramViewGroup = ptq.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, a(), (String)localObject);
        if ((paramInt == pto.b) && (paramViewGroup != null)) {
          paramViewGroup.setVisibility(8);
        }
        QLog.d("ReadInJoyDynamicChannelAdapter", 2, new Object[] { "onCreateViewHolder, viewType = ", Integer.valueOf(paramInt), ", styleID =", localObject });
        localObject = paramViewGroup;
        if (paramViewGroup == null)
        {
          localObject = new ProteusItemView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext());
          QLog.d("ReadInJoyDynamicChannelAdapter", 2, "proteusItemView is null");
        }
        QLog.d("ReadInJoyDynamicChannelAdapter", 2, new Object[] { "onCreateViewHolder, proteusItemView = ", localObject, ", viewType = ", Integer.valueOf(paramInt) });
        return new puf(this, (View)localObject);
      }
      QLog.d("ReadInJoyDynamicChannelAdapter", 2, "onCreateViewHolder styleID is empty");
    }
    for (;;)
    {
      paramViewGroup = null;
      break;
      if (puc.a(paramInt))
      {
        paramViewGroup = puc.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, paramInt, a());
        break;
      }
      QLog.d("ReadInJoyDynamicChannelAdapter", 1, "onCreateViewHolder not the right type");
    }
  }
  
  public void a(int paramInt, View paramView)
  {
    paramView = (ArticleInfo)a(paramInt);
    if (paramView == null) {
      QLog.d("ReadInJoyDynamicChannelAdapter", 1, "onItemClick articleInfo is null.");
    }
    while (!pqw.a(paramView.mArticleContentUrl, paramView.mChannelID, paramView)) {
      return;
    }
    a(paramView);
  }
  
  public void a(blij paramblij, int paramInt)
  {
    BaseArticleInfo localBaseArticleInfo = a(paramInt);
    int i = paramblij.getItemViewType();
    ProteusItemView localProteusItemView = (ProteusItemView)paramblij.itemView;
    if (localBaseArticleInfo != null)
    {
      if (!this.jdField_a_of_type_Pub.a(i)) {
        break label160;
      }
      if (i != pto.b) {
        break label140;
      }
      localProteusItemView.setVisibility(8);
    }
    for (;;)
    {
      a(Long.valueOf(localBaseArticleInfo.mArticleID), localBaseArticleInfo);
      QLog.d("ReadInJoyDynamicChannelAdapter", 2, new Object[] { "onBindViewHolder, articleInfo = ", localBaseArticleInfo, ", proteusItemView = ", localProteusItemView, ", position = ", Integer.valueOf(paramInt), ", type = ", Integer.valueOf(i) });
      EventCollector.getInstance().onRecyclerBindViewHolder(paramblij, paramInt, getItemId(paramInt));
      return;
      label140:
      this.jdField_a_of_type_Pub.a(localProteusItemView, i, localBaseArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, paramInt);
      continue;
      label160:
      if (puc.a(i)) {
        puc.a(localProteusItemView, i, localBaseArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, paramInt, a());
      } else {
        QLog.d("ReadInJoyDynamicChannelAdapter", 1, "onBindViewHolder not the right type");
      }
    }
  }
  
  public void b()
  {
    qfg localqfg = ((pvp)pkh.a().getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER)).a().a();
    if (localqfg != null) {
      localqfg.b(this.b);
    }
    if (this.jdField_a_of_type_JavaUtilMap != null) {
      this.jdField_a_of_type_JavaUtilMap.clear();
    }
  }
  
  public int getItemViewType(int paramInt)
  {
    BaseArticleInfo localBaseArticleInfo = a(paramInt);
    int i = 0;
    paramInt = i;
    if (localBaseArticleInfo != null)
    {
      if (!this.jdField_a_of_type_Pub.a(localBaseArticleInfo)) {
        break label42;
      }
      paramInt = this.jdField_a_of_type_Pub.a(localBaseArticleInfo);
      a(paramInt, localBaseArticleInfo);
    }
    label42:
    do
    {
      return paramInt;
      if (localBaseArticleInfo.mShowBigPicture) {
        return 2;
      }
      paramInt = i;
    } while (TextUtils.isEmpty(localBaseArticleInfo.mFirstPagePicUrl));
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pud
 * JD-Core Version:    0.7.0.1
 */