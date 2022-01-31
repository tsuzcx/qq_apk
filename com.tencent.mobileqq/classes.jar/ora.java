import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.ProteusItemView;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.pull2refresh.RecyclerViewWithHeaderFooter;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

public class ora
  extends oqo<Long, BaseArticleInfo>
{
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new orb(this);
  private oqy jdField_a_of_type_Oqy = new oqy();
  private int b;
  public final String b;
  
  public ora(Activity paramActivity, RecyclerViewWithHeaderFooter paramRecyclerViewWithHeaderFooter, int paramInt)
  {
    super(paramActivity, paramRecyclerViewWithHeaderFooter, paramInt);
    this.jdField_b_of_type_JavaLangString = "ReadInJoyDynamicChannelAdapter";
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_Oqy.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, 3);
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
    paf localpaf = osg.a().a();
    ArticleInfo localArticleInfo = paramArticleInfo;
    if (onh.s(paramArticleInfo))
    {
      localArticleInfo = paramArticleInfo;
      if (!paramArticleInfo.mNewPolymericInfo.a) {
        localArticleInfo = ReadInJoyListViewGroup.a(paramArticleInfo);
      }
    }
    if (localpaf != null) {
      this.jdField_b_of_type_Int = localpaf.a(localArticleInfo.mArticleContentUrl, String.valueOf(localArticleInfo.innerUniqueID), localArticleInfo.mSubscribeID, 1, null);
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
    onh.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramArticleInfo);
  }
  
  public bfzf a(ViewGroup paramViewGroup, int paramInt)
  {
    if (this.jdField_a_of_type_Oqy.a(paramInt))
    {
      Object localObject = (String)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        paramViewGroup = oqn.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, a(), (String)localObject);
        if ((paramInt == oql.jdField_b_of_type_Int) && (paramViewGroup != null)) {
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
        return new orc(this, (View)localObject);
      }
      QLog.d("ReadInJoyDynamicChannelAdapter", 2, "onCreateViewHolder styleID is empty");
    }
    for (;;)
    {
      paramViewGroup = null;
      break;
      if (oqz.a(paramInt))
      {
        paramViewGroup = oqz.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, paramInt, a());
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
    while (!onh.a(paramView.mArticleContentUrl, paramView.mChannelID, paramView)) {
      return;
    }
    a(paramView);
  }
  
  public void a(bfzf parambfzf, int paramInt)
  {
    BaseArticleInfo localBaseArticleInfo = a(paramInt);
    int i = parambfzf.getItemViewType();
    parambfzf = (ProteusItemView)parambfzf.itemView;
    if (localBaseArticleInfo != null)
    {
      if (!this.jdField_a_of_type_Oqy.a(i)) {
        break label143;
      }
      if (i != oql.jdField_b_of_type_Int) {
        break label124;
      }
      parambfzf.setVisibility(8);
    }
    for (;;)
    {
      a(Long.valueOf(localBaseArticleInfo.mArticleID), localBaseArticleInfo);
      QLog.d("ReadInJoyDynamicChannelAdapter", 2, new Object[] { "onBindViewHolder, articleInfo = ", localBaseArticleInfo, ", proteusItemView = ", parambfzf, ", position = ", Integer.valueOf(paramInt), ", type = ", Integer.valueOf(i) });
      return;
      label124:
      this.jdField_a_of_type_Oqy.a(parambfzf, i, localBaseArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, paramInt);
      continue;
      label143:
      if (oqz.a(i)) {
        oqz.a(parambfzf, i, localBaseArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, paramInt, a());
      } else {
        QLog.d("ReadInJoyDynamicChannelAdapter", 1, "onBindViewHolder not the right type");
      }
    }
  }
  
  public void b()
  {
    paf localpaf = ((osl)onh.a().getManager(163)).a().a();
    if (localpaf != null) {
      localpaf.b(this.jdField_b_of_type_Int);
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
      if (!this.jdField_a_of_type_Oqy.a(localBaseArticleInfo)) {
        break label42;
      }
      paramInt = this.jdField_a_of_type_Oqy.a(localBaseArticleInfo);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ora
 * JD-Core Version:    0.7.0.1
 */