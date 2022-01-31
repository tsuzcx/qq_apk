import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.pts.lite.PTSLiteItemViewBuilder.2;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.pts.core.itemview.PTSItemData;
import com.tencent.pts.core.itemview.PTSItemView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class pvq
{
  private static int jdField_a_of_type_Int = 140;
  private static int jdField_b_of_type_Int = jdField_a_of_type_Int;
  private static HashMap<String, Integer> c = new HashMap();
  private Context jdField_a_of_type_AndroidContentContext;
  private HashMap<String, Integer> jdField_a_of_type_JavaUtilHashMap;
  private List<String> jdField_a_of_type_JavaUtilList;
  private pvs jdField_a_of_type_Pvs;
  private pvt jdField_a_of_type_Pvt;
  private rqj jdField_a_of_type_Rqj;
  private HashMap<String, ArticleInfo> jdField_b_of_type_JavaUtilHashMap;
  
  public pvq(Context paramContext, rqj paramrqj)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Rqj = paramrqj;
    this.jdField_a_of_type_Pvs = new pvs(paramContext);
    this.jdField_b_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    b();
    c();
  }
  
  public static int a()
  {
    if (jdField_b_of_type_Int > jdField_a_of_type_Int) {
      return jdField_b_of_type_Int - jdField_a_of_type_Int + 1;
    }
    return 0;
  }
  
  public static int a(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo == null) || (paramArticleInfo.ptsItemData == null) || (TextUtils.isEmpty(paramArticleInfo.ptsLiteAppName))) {
      return jdField_a_of_type_Int;
    }
    paramArticleInfo = (Integer)c.get(paramArticleInfo.ptsLiteAppName);
    if (paramArticleInfo != null) {
      return paramArticleInfo.intValue();
    }
    return jdField_a_of_type_Int;
  }
  
  private void a(PTSItemData paramPTSItemData)
  {
    ThreadManager.executeOnSubThread(new PTSLiteItemViewBuilder.2(this, paramPTSItemData));
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt >= jdField_a_of_type_Int) && (paramInt <= jdField_b_of_type_Int);
  }
  
  public static boolean a(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {}
    do
    {
      return true;
      if (!b(paramArticleInfo)) {
        break;
      }
    } while (a(paramArticleInfo) == jdField_a_of_type_Int);
    return false;
    return false;
  }
  
  private void b()
  {
    this.jdField_a_of_type_Pvt = new pvv().a(this.jdField_a_of_type_Rqj).a(this.jdField_a_of_type_JavaUtilHashMap).b(this.jdField_b_of_type_JavaUtilHashMap).a();
    this.jdField_a_of_type_Pvs.a(new pvr(this));
  }
  
  public static boolean b(ArticleInfo paramArticleInfo)
  {
    return (paramArticleInfo != null) && (paramArticleInfo.mFeedType == 29) && (!TextUtils.isEmpty(paramArticleInfo.ptsLiteAppName));
  }
  
  private void c()
  {
    c.clear();
    Object localObject = pxa.a().a("default_feeds");
    if (localObject == null)
    {
      QLog.i("PTSLiteItemViewBuilder", 1, "[initViewTypeCount], appNameList is null.");
      return;
    }
    jdField_a_of_type_Int = this.jdField_a_of_type_Rqj.a().a() + 140;
    int i = jdField_a_of_type_Int;
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      int j = i + 1;
      i = j;
      if (!c.containsKey(str))
      {
        c.put(str, Integer.valueOf(j));
        QLog.i("PTSLiteItemViewBuilder", 1, "[initViewTypeCount], appName = " + str + ", viewType = " + j);
        i = j;
      }
    }
    jdField_b_of_type_Int = i;
    QLog.i("PTSLiteItemViewBuilder", 1, "[initViewType], type_pts_lite_gone = " + jdField_a_of_type_Int + ", type_pts_lite_end = " + jdField_b_of_type_Int);
  }
  
  public View a(View paramView, ArticleInfo paramArticleInfo, int paramInt)
  {
    if (paramArticleInfo == null)
    {
      QLog.e("PTSLiteItemViewBuilder", 1, "[getView], articleInfo is null.");
      return paramView;
    }
    View localView = null;
    PTSItemData localPTSItemData = paramArticleInfo.ptsItemData;
    if (localPTSItemData != null)
    {
      localView = this.jdField_a_of_type_Pvs.a(paramView, localPTSItemData);
      this.jdField_a_of_type_JavaUtilHashMap.put(localPTSItemData.getItemID(), Integer.valueOf(paramInt));
      this.jdField_b_of_type_JavaUtilHashMap.put(localPTSItemData.getItemID(), paramArticleInfo);
      a(localPTSItemData);
    }
    paramView = localView;
    if (localView == null)
    {
      paramView = new PTSItemView(this.jdField_a_of_type_AndroidContentContext);
      paramView.setVisibility(8);
      QLog.i("PTSLiteItemViewBuilder", 1, "[getView] hide the itemView, title = " + paramArticleInfo.mTitle);
    }
    paramArticleInfo = paramView.getLayoutParams();
    if (paramArticleInfo != null) {
      paramView.setLayoutParams(new AbsListView.LayoutParams(paramArticleInfo));
    }
    paramView.setTag(2131369009, this.jdField_a_of_type_Rqj.a());
    return paramView;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Pvs.a();
    this.jdField_a_of_type_JavaUtilList.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pvq
 * JD-Core Version:    0.7.0.1
 */