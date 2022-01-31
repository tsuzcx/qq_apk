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

public class oon
  implements ooe
{
  private int jdField_a_of_type_Int = 10;
  private ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  private String jdField_a_of_type_JavaLangString = "GuideHelper";
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  
  private void a(String paramString, ArticleInfo paramArticleInfo)
  {
    orz localorz = new orz();
    localorz.i().b("wording", "" + otd.a());
    olt.a(paramString, paramArticleInfo, localorz);
  }
  
  public View a(ViewGroup paramViewGroup, View paramView, Context paramContext, omt paramomt)
  {
    if (!a(paramomt)) {
      return paramView;
    }
    if ((!TextUtils.isEmpty(paramomt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID)) && (!this.jdField_a_of_type_JavaUtilSet.contains(paramomt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID)))
    {
      a("0X8009FE9", paramomt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      this.jdField_a_of_type_JavaUtilSet.add(paramomt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID);
    }
    this.jdField_a_of_type_Boolean = true;
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramViewGroup.getLayoutParams();
    if (localLayoutParams.bottomMargin >= 0) {
      localLayoutParams.setMargins(localLayoutParams.leftMargin, localLayoutParams.topMargin, localLayoutParams.rightMargin, paramViewGroup.getContext().getResources().getDimensionPixelOffset(2131298626));
    }
    paramViewGroup.setLayoutParams(localLayoutParams);
    if (paramView != null) {}
    for (;;)
    {
      paramView.setOnClickListener(new ooo(this, paramomt, paramContext));
      return paramView;
      paramView = LayoutInflater.from(paramContext).inflate(2131560147, null);
    }
  }
  
  public void a(int paramInt)
  {
    QLog.d(this.jdField_a_of_type_JavaLangString, 1, "showGuidePagerNum : " + paramInt);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(ArticleInfo paramArticleInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
  }
  
  public void a(String paramString)
  {
    QLog.d(this.jdField_a_of_type_JavaLangString, 1, "extraInfo : " + paramString);
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    try
    {
      this.jdField_b_of_type_JavaLangString = new JSONObject(paramString).getString("app_schema");
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, "scheme : " + this.jdField_b_of_type_JavaLangString);
      return;
    }
    catch (Exception paramString)
    {
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, "setGuideExtraInfo : ", paramString);
    }
  }
  
  public void a(boolean paramBoolean, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_b_of_type_Int = 0;
    if (paramViewGroup == null) {
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramViewGroup.getLayoutParams();
    if (!paramBoolean) {
      localLayoutParams.setMargins(localLayoutParams.leftMargin, localLayoutParams.topMargin, localLayoutParams.rightMargin, paramViewGroup.getContext().getResources().getDimensionPixelOffset(2131298624));
    }
    paramViewGroup.setLayoutParams(localLayoutParams);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(List<omt> paramList)
  {
    int i = this.jdField_b_of_type_Int;
    if ((!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && (i > this.jdField_a_of_type_Int) && (paramList != null))
    {
      omt localomt = new omt(6, null, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext()) {
        if (((omt)localIterator.next()).jdField_a_of_type_Int == 6) {
          localIterator.remove();
        }
      }
      paramList.add(localomt);
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, "addGuidePager : " + i + "  articleInfo :" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      return true;
    }
    return false;
  }
  
  public boolean a(omt paramomt)
  {
    return (paramomt != null) && (paramomt.jdField_a_of_type_Int == 6);
  }
  
  public void onCommentCreate(boolean paramBoolean, omt paramomt, List<omt> paramList, int paramInt) {}
  
  public void onCommentCreate(boolean paramBoolean1, omt paramomt, boolean paramBoolean2, List<omt> paramList, int paramInt) {}
  
  public void onCommentDelete(int paramInt1, boolean paramBoolean, omt paramomt, int paramInt2) {}
  
  public void onCommentLikeOrDislike(boolean paramBoolean, String paramString, int paramInt1, int paramInt2) {}
  
  public void onCommentListLoad(int paramInt1, boolean paramBoolean1, List<omt> paramList, boolean paramBoolean2, int paramInt2, int paramInt3)
  {
    this.jdField_b_of_type_Int = 1;
    a(paramList);
  }
  
  public void onCommentLoadMore(int paramInt1, boolean paramBoolean1, List<omt> paramList, boolean paramBoolean2, int paramInt2)
  {
    this.jdField_b_of_type_Int += 1;
    a(paramList);
  }
  
  public void onCommentReply(boolean paramBoolean, omt paramomt) {}
  
  public void onCommentStateError(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     oon
 * JD-Core Version:    0.7.0.1
 */