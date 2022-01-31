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

public class nyr
  implements nyi
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
    ocg localocg = new ocg();
    localocg.i().b("wording", "" + odk.a());
    nvx.a(paramString, paramArticleInfo, localocg);
  }
  
  public View a(ViewGroup paramViewGroup, View paramView, Context paramContext, nwx paramnwx)
  {
    if (!a(paramnwx)) {
      return paramView;
    }
    if ((!TextUtils.isEmpty(paramnwx.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID)) && (!this.jdField_a_of_type_JavaUtilSet.contains(paramnwx.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID)))
    {
      a("0X8009FE9", paramnwx.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      this.jdField_a_of_type_JavaUtilSet.add(paramnwx.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID);
    }
    this.jdField_a_of_type_Boolean = true;
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramViewGroup.getLayoutParams();
    if (localLayoutParams.bottomMargin >= 0) {
      localLayoutParams.setMargins(localLayoutParams.leftMargin, localLayoutParams.topMargin, localLayoutParams.rightMargin, paramViewGroup.getContext().getResources().getDimensionPixelOffset(2131167506));
    }
    paramViewGroup.setLayoutParams(localLayoutParams);
    if (paramView != null) {}
    for (;;)
    {
      paramView.setOnClickListener(new nys(this, paramnwx, paramContext));
      return paramView;
      paramView = LayoutInflater.from(paramContext).inflate(2131494480, null);
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
      localLayoutParams.setMargins(localLayoutParams.leftMargin, localLayoutParams.topMargin, localLayoutParams.rightMargin, paramViewGroup.getContext().getResources().getDimensionPixelOffset(2131167504));
    }
    paramViewGroup.setLayoutParams(localLayoutParams);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(List<nwx> paramList)
  {
    int i = this.jdField_b_of_type_Int;
    if ((!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && (i > this.jdField_a_of_type_Int) && (paramList != null))
    {
      nwx localnwx = new nwx(6, null, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext()) {
        if (((nwx)localIterator.next()).jdField_a_of_type_Int == 6) {
          localIterator.remove();
        }
      }
      paramList.add(localnwx);
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, "addGuidePager : " + i + "  articleInfo :" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      return true;
    }
    return false;
  }
  
  public boolean a(nwx paramnwx)
  {
    return (paramnwx != null) && (paramnwx.jdField_a_of_type_Int == 6);
  }
  
  public void onCommentCreate(boolean paramBoolean, nwx paramnwx, List<nwx> paramList, int paramInt) {}
  
  public void onCommentCreate(boolean paramBoolean1, nwx paramnwx, boolean paramBoolean2, List<nwx> paramList, int paramInt) {}
  
  public void onCommentDelete(int paramInt1, boolean paramBoolean, nwx paramnwx, int paramInt2) {}
  
  public void onCommentLikeOrDislike(boolean paramBoolean, String paramString, int paramInt1, int paramInt2) {}
  
  public void onCommentListLoad(int paramInt1, boolean paramBoolean1, List<nwx> paramList, boolean paramBoolean2, int paramInt2, int paramInt3)
  {
    this.jdField_b_of_type_Int = 1;
    a(paramList);
  }
  
  public void onCommentLoadMore(int paramInt1, boolean paramBoolean1, List<nwx> paramList, boolean paramBoolean2, int paramInt2)
  {
    this.jdField_b_of_type_Int += 1;
    a(paramList);
  }
  
  public void onCommentReply(boolean paramBoolean, nwx paramnwx) {}
  
  public void onCommentStateError(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     nyr
 * JD-Core Version:    0.7.0.1
 */