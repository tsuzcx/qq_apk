import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyModelImpl;
import com.tencent.biz.pubaccount.readinjoy.rebuild.CellFactory;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.CmpCtxt;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentPolymericView;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.PolymericInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import java.util.List;

public class lzz
  extends BaseAdapter
{
  private lzz(ComponentPolymericView paramComponentPolymericView) {}
  
  public int getCount()
  {
    return ComponentPolymericView.a(this.a).size();
  }
  
  public Object getItem(int paramInt)
  {
    return ComponentPolymericView.a(this.a).get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return ((BaseArticleInfo)ComponentPolymericView.a(this.a).get(paramInt)).mRecommendSeq;
  }
  
  public int getItemViewType(int paramInt)
  {
    BaseArticleInfo localBaseArticleInfo = (BaseArticleInfo)ComponentPolymericView.a(this.a).get(paramInt);
    if (localBaseArticleInfo.mPolymericInfo != null) {}
    switch (localBaseArticleInfo.mPolymericInfo.a)
    {
    default: 
      if (ReadInJoyUtils.a(localBaseArticleInfo)) {
        return 51;
      }
      break;
    case 9: 
      return 67;
    case 11: 
      return 69;
    case 10: 
      return 68;
    }
    if (ReadInJoyUtils.b(localBaseArticleInfo)) {
      return 52;
    }
    if (localBaseArticleInfo.mSinglePicture != null) {
      return 50;
    }
    return 50;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = (BaseArticleInfo)ComponentPolymericView.a(this.a).get(paramInt);
    Object localObject = ComponentPolymericView.a(this.a);
    ArticleInfo localArticleInfo = (ArticleInfo)paramViewGroup;
    int j = getItemViewType(paramInt);
    int k = (int)paramViewGroup.mChannelID;
    if (paramViewGroup.mChannelID == 3L) {}
    for (int i = 1;; i = 0)
    {
      localObject = new ReadInJoyModelImpl((Context)localObject, localArticleInfo, j, k, i, paramInt, false, getCount(), null, ComponentPolymericView.a(this.a).a.a());
      paramView = CellFactory.a(paramInt, localObject, getItemViewType(paramInt), paramView, ComponentPolymericView.a(this.a), ComponentPolymericView.a(this.a).a.a(), ComponentPolymericView.a(this.a).a.a().a());
      if (paramView != null)
      {
        paramView.setTag(2131362079, localObject);
        ComponentPolymericView.a(this.a).a.a().a(paramViewGroup, (IReadInJoyModel)localObject, System.currentTimeMillis(), paramInt);
      }
      return paramView;
    }
  }
  
  public int getViewTypeCount()
  {
    return 6;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lzz
 * JD-Core Version:    0.7.0.1
 */