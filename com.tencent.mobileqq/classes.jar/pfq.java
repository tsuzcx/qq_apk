import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;

public class pfq
  implements pfh
{
  private int jdField_a_of_type_Int = 10;
  private ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  private String jdField_a_of_type_JavaLangString;
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  private boolean jdField_a_of_type_Boolean;
  private int b;
  
  private void a(String paramString, ArticleInfo paramArticleInfo)
  {
    pqg localpqg = new pqg();
    localpqg.i().b("wording", "" + plk.a());
    pbq.a(paramString, paramArticleInfo, localpqg);
  }
  
  public View a(ViewGroup paramViewGroup, View paramView, Context paramContext, pdp parampdp)
  {
    if (!a(parampdp)) {
      return paramView;
    }
    if ((!TextUtils.isEmpty(parampdp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID)) && (!this.jdField_a_of_type_JavaUtilSet.contains(parampdp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID)))
    {
      a("0X8009FE9", parampdp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      this.jdField_a_of_type_JavaUtilSet.add(parampdp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID);
    }
    this.jdField_a_of_type_Boolean = true;
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramViewGroup.getLayoutParams();
    if (localLayoutParams.bottomMargin >= 0) {
      localLayoutParams.setMargins(localLayoutParams.leftMargin, localLayoutParams.topMargin, localLayoutParams.rightMargin, paramViewGroup.getContext().getResources().getDimensionPixelOffset(2131298790));
    }
    paramViewGroup.setLayoutParams(localLayoutParams);
    if (paramView != null) {}
    for (;;)
    {
      paramView.setOnClickListener(new pfr(this, parampdp, paramContext));
      return paramView;
      paramView = LayoutInflater.from(paramContext).inflate(2131560358, null);
    }
  }
  
  public void a(int paramInt)
  {
    QLog.d("GuideHelper", 1, "showGuidePagerNum : " + paramInt);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(ArticleInfo paramArticleInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
  }
  
  public void a(String paramString)
  {
    QLog.d("GuideHelper", 1, "extraInfo : " + paramString);
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    try
    {
      this.jdField_a_of_type_JavaLangString = new JSONObject(paramString).getString("app_schema");
      QLog.d("GuideHelper", 1, "scheme : " + this.jdField_a_of_type_JavaLangString);
      return;
    }
    catch (Exception paramString)
    {
      QLog.d("GuideHelper", 1, "setGuideExtraInfo : ", paramString);
    }
  }
  
  public void a(boolean paramBoolean, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.b = 0;
    if (paramViewGroup == null) {
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramViewGroup.getLayoutParams();
    if (!paramBoolean) {
      localLayoutParams.setMargins(localLayoutParams.leftMargin, localLayoutParams.topMargin, localLayoutParams.rightMargin, paramViewGroup.getContext().getResources().getDimensionPixelOffset(2131298788));
    }
    paramViewGroup.setLayoutParams(localLayoutParams);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(List<pdp> paramList)
  {
    int i = this.b;
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (i > this.jdField_a_of_type_Int) && (paramList != null))
    {
      pdp localpdp = new pdp(6, null, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext()) {
        if (((pdp)localIterator.next()).jdField_a_of_type_Int == 6) {
          localIterator.remove();
        }
      }
      paramList.add(localpdp);
      QLog.d("GuideHelper", 1, "addGuidePager : " + i + "  articleInfo :" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      return true;
    }
    return false;
  }
  
  public boolean a(pdp parampdp)
  {
    return (parampdp != null) && (parampdp.jdField_a_of_type_Int == 6);
  }
  
  public void onCommentCreate(boolean paramBoolean, pdp parampdp, List<pdp> paramList, int paramInt) {}
  
  public void onCommentCreate(boolean paramBoolean1, pdp parampdp, boolean paramBoolean2, List<pdp> paramList, int paramInt) {}
  
  public void onCommentDelete(int paramInt1, boolean paramBoolean, pdp parampdp, int paramInt2) {}
  
  public void onCommentLikeOrDislike(boolean paramBoolean, String paramString, int paramInt1, int paramInt2) {}
  
  public void onCommentListLoad(int paramInt1, boolean paramBoolean1, List<pdp> paramList, boolean paramBoolean2, int paramInt2, int paramInt3)
  {
    this.b = 1;
    a(paramList);
  }
  
  public void onCommentLoadMore(int paramInt1, boolean paramBoolean1, List<pdp> paramList, boolean paramBoolean2, int paramInt2)
  {
    this.b += 1;
    a(paramList);
  }
  
  public void onCommentReply(boolean paramBoolean, pdp parampdp) {}
  
  public void onCommentStateError(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pfq
 * JD-Core Version:    0.7.0.1
 */