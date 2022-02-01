import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.PopupWindow;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.Layout.Params;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory;
import java.util.HashSet;
import java.util.Set;

public class pfs
  extends PopupWindow
{
  private int jdField_a_of_type_Int = 0;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  private Container jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer;
  private VafContext jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext;
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  private pfw jdField_a_of_type_Pfw;
  
  public pfs(Activity paramActivity, ArticleInfo paramArticleInfo)
  {
    super(paramActivity);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
    a(a());
    setTouchable(true);
    setFocusable(true);
    setOutsideTouchable(false);
    setInputMethodMode(1);
    setBackgroundDrawable(new ColorDrawable(0));
    a();
  }
  
  private void a(VafContext paramVafContext)
  {
    TemplateBean localTemplateBean = plk.a(paramVafContext);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer = paramVafContext.getViewFactory().inflate(paramVafContext, localTemplateBean);
    if (localTemplateBean != null) {
      piv.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getVirtualView(), localTemplateBean.getViewBean());
    }
    setContentView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer);
    paramVafContext = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getVirtualView().getComLayoutParams();
    setHeight(paramVafContext.mLayoutHeight);
    setWidth(paramVafContext.mLayoutWidth);
  }
  
  public VafContext a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext == null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext = new qxj();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.setCurActivity(this.jdField_a_of_type_AndroidAppActivity);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.setContext(this.jdField_a_of_type_AndroidAppActivity);
      piv.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, "comment_feeds");
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext;
  }
  
  public void a()
  {
    setOnDismissListener(new pft(this));
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer != null) {
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer);
    }
  }
  
  protected void a(float paramFloat)
  {
    WindowManager.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidAppActivity.getWindow().getAttributes();
    localLayoutParams.alpha = paramFloat;
    this.jdField_a_of_type_AndroidAppActivity.getWindow().setAttributes(localLayoutParams);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(View paramView)
  {
    if (isShowing())
    {
      dismiss();
      return;
    }
    this.jdField_a_of_type_JavaUtilSet.add(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID);
    a(0);
    a(1.0F);
    setAnimationStyle(2131755038);
    showAtLocation(paramView, 17, 0, 0);
    paramView = new pqg();
    paramView.i().b("wording", "" + plk.a());
    pbq.a("0X8009FE7", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, paramView);
  }
  
  public void a(ArticleInfo paramArticleInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
  }
  
  public void a(Container paramContainer)
  {
    if (paramContainer == null) {
      return;
    }
    ViewFactory.findClickableViewListener(paramContainer.getVirtualView(), new pfu(this));
  }
  
  public void a(pfw parampfw)
  {
    this.jdField_a_of_type_Pfw = parampfw;
  }
  
  public boolean a(String paramString)
  {
    return this.jdField_a_of_type_JavaUtilSet.contains(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pfs
 * JD-Core Version:    0.7.0.1
 */