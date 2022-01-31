import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentPolymericView;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.json.JSONObject;

public class pye
  extends BaseAdapter
{
  private pye(ComponentPolymericView paramComponentPolymericView) {}
  
  public int getCount()
  {
    if (ComponentPolymericView.a(this.a) != null) {
      return ComponentPolymericView.a(this.a).size();
    }
    return 0;
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
    if (onh.s(localBaseArticleInfo))
    {
      switch (localBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_Int)
      {
      default: 
        if (onh.c(localBaseArticleInfo)) {
          return 51;
        }
        break;
      case 9: 
        return 67;
      case 11: 
        return 69;
      case 10: 
        return 68;
      case 12: 
        return 98;
      case 13: 
        return 97;
      }
      if (onh.e(localBaseArticleInfo)) {
        return 52;
      }
      if (localBaseArticleInfo.mSinglePicture != null) {
        return 50;
      }
    }
    else
    {
      if (localBaseArticleInfo.mPolymericInfo != null) {}
      switch (localBaseArticleInfo.mPolymericInfo.jdField_a_of_type_Int)
      {
      default: 
        if (onh.a(localBaseArticleInfo)) {
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
      if (onh.e(localBaseArticleInfo)) {
        return 52;
      }
      if (localBaseArticleInfo.mSinglePicture != null) {
        return 50;
      }
    }
    return 50;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = (BaseArticleInfo)ComponentPolymericView.a(this.a).get(paramInt);
    Object localObject1 = ComponentPolymericView.a(this.a);
    Object localObject2 = (ArticleInfo)paramViewGroup;
    int j = getItemViewType(paramInt);
    int k = (int)paramViewGroup.mChannelID;
    int i;
    if (paramViewGroup.mChannelID == 3L)
    {
      i = 1;
      localObject2 = new pbf((Context)localObject1, (ArticleInfo)localObject2, j, k, i, paramInt, false, getCount(), null, ComponentPolymericView.a(this.a).a.a());
      localObject1 = pqn.a(paramInt, localObject2, getItemViewType(paramInt), paramView, ComponentPolymericView.a(this.a), ComponentPolymericView.a(this.a).a.a(), ComponentPolymericView.a(this.a).a.a().a());
      if (localObject1 != null)
      {
        ((View)localObject1).setTag(2131379213, localObject2);
        ComponentPolymericView.a(this.a).a.a().a(paramViewGroup, (pau)localObject2, System.currentTimeMillis(), paramInt);
      }
      if (QLog.isColorLevel()) {
        QLog.d("PolymericSmallVideo", 2, "ComponentPolymericView getView position:" + paramInt + " count:" + getCount());
      }
      if (ComponentPolymericView.a(this.a)[paramInt] == null) {
        ComponentPolymericView.a(this.a)[paramInt] = Boolean.valueOf(false);
      }
      if (((onh.o(paramViewGroup)) || (onh.p(paramViewGroup))) && (!ComponentPolymericView.a(this.a)[paramInt].booleanValue())) {
        localObject2 = new JSONObject();
      }
    }
    for (;;)
    {
      try
      {
        localObject3 = (qbo)paramViewGroup.mNewPolymericInfo.jdField_a_of_type_JavaUtilList.get(0);
        ((JSONObject)localObject2).put("channel_id", paramViewGroup.mChannelID);
        if (((qbo)localObject3).jdField_a_of_type_Qbp == null) {
          continue;
        }
        paramView = ((qbo)localObject3).jdField_a_of_type_Qbp.a;
        ((JSONObject)localObject2).put("rowkey", paramView);
        if (((qbo)localObject3).jdField_a_of_type_Qbq == null) {
          continue;
        }
        i = ((qbo)localObject3).jdField_a_of_type_Qbq.b;
        ((JSONObject)localObject2).put("topicid", i);
      }
      catch (Exception paramView)
      {
        Object localObject3;
        paramView.printStackTrace();
        continue;
        paramView = "2";
        continue;
      }
      localObject3 = paramViewGroup.mFeedId + "";
      if (!onh.o(paramViewGroup)) {
        continue;
      }
      paramView = "1";
      nol.a(null, "CliOper", "", "", "0X8009829", "0X8009829", 0, 0, (String)localObject3, paramView, paramViewGroup.mStrategyId + "", ((JSONObject)localObject2).toString(), false);
      ComponentPolymericView.a(this.a)[paramInt] = Boolean.valueOf(true);
      if ((onh.i(paramViewGroup)) && (paramViewGroup.mPolymericInfo != null)) {
        paramViewGroup.mPolymericInfo.f = paramInt;
      }
      return localObject1;
      i = 0;
      break;
      paramView = Integer.valueOf(0);
      continue;
      i = 0;
    }
  }
  
  public int getViewTypeCount()
  {
    return 15;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pye
 * JD-Core Version:    0.7.0.1
 */