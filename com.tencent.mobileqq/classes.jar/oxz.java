import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AdapterView;
import com.tencent.widget.ListView;
import java.util.List;

public class oxz
  extends oxx
  implements ntx
{
  private int jdField_a_of_type_Int = -1;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private final String jdField_a_of_type_JavaLangString = "FrameworkHandler";
  private oyb jdField_a_of_type_Oyb = new oyb(this);
  private ppg jdField_a_of_type_Ppg;
  public boolean a;
  public boolean b;
  private boolean c = true;
  
  private void a(int paramInt) {}
  
  private void a(View paramView)
  {
    if (paramView == null) {}
    do
    {
      return;
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366189));
    } while (!(a() instanceof ReadInJoyListViewGroup));
    ntv.a().a(b(), (oxz)((ReadInJoyListViewGroup)a()).a());
  }
  
  private void b(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368509));
    if ((b() == 0) && (bhvy.k()))
    {
      paramView = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      paramView.setMargins(paramView.leftMargin, paramView.topMargin, bbll.a(34.0F), bbll.a(184.0F));
      this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(paramView);
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new oya(this));
  }
  
  private void k()
  {
    if ((!this.jdField_a_of_type_Boolean) && (this.b))
    {
      this.jdField_a_of_type_Boolean = true;
      this.b = false;
      if (b() != ozy.a()) {
        break label100;
      }
      sgu.jdField_a_of_type_Int = 1;
    }
    for (;;)
    {
      sgu.a("KANDIAN_NEW_FEEDS_LIST_VIEW_GROUP_MEASURE_LAYOUT_DRAW", null);
      sgu.a("KANDIAN_FEEDS_STAGE_2_COST", null);
      sgu.a("KANDIAN_FEEDS_COST", null);
      if (b() == 56) {
        sgu.a("video_tab_cost", null);
      }
      if (this.c)
      {
        this.c = false;
        if (b() != ozy.a()) {
          break;
        }
        sgu.a("recommend_tab_cost", null);
      }
      return;
      label100:
      switch (b())
      {
      default: 
        break;
      case 0: 
        sgu.jdField_a_of_type_Int = 1;
        break;
      case 56: 
        sgu.jdField_a_of_type_Int = 2;
        break;
      case 70: 
        sgu.jdField_a_of_type_Int = 3;
      }
    }
    switch (b())
    {
    default: 
      return;
    case 0: 
      sgu.a("recommend_tab_cost", null);
      return;
    case 56: 
      sgu.a("video_tab_cost", null);
      return;
    }
    sgu.a("subscribe_tab_cost", null);
  }
  
  public int a()
  {
    return 2;
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    System.currentTimeMillis();
    int j = a(paramInt).intValue();
    ArticleInfo localArticleInfo1 = (ArticleInfo)a(paramInt);
    ArticleInfo localArticleInfo2 = (ArticleInfo)a(paramInt + 1);
    if (localArticleInfo1 != null) {
      localArticleInfo1.mResolvedFeedType = j;
    }
    paramViewGroup = null;
    this.jdField_a_of_type_Oyb.a();
    if ((ppg.a(localArticleInfo1)) && (this.jdField_a_of_type_Ppg != null)) {
      paramViewGroup = this.jdField_a_of_type_Ppg.a(paramView, localArticleInfo1);
    }
    label209:
    do
    {
      do
      {
        do
        {
          do
          {
            return paramViewGroup;
            if ((j == 123) && (!olo.a(a().a(), j, localArticleInfo1))) {}
            for (int i = 1;; i = 0)
            {
              if ((i != 0) || (!olo.a(j))) {
                break label209;
              }
              l = System.currentTimeMillis();
              paramView = oyb.a(this.jdField_a_of_type_Oyb, paramView, localArticleInfo1, localArticleInfo2, j, paramInt);
              saf.a("FrameworkHandler", String.valueOf(j), "getProteusNormalView", System.currentTimeMillis() - l);
              paramViewGroup = paramView;
              if (localArticleInfo1 == null) {
                break;
              }
              QLog.d("FrameworkHandler", 2, "article is normalProteusView: " + localArticleInfo1.mTitle);
              return paramView;
            }
            if (!oyb.a(this.jdField_a_of_type_Oyb).a(j)) {
              break;
            }
            l = System.currentTimeMillis();
            paramView = oyb.b(this.jdField_a_of_type_Oyb, paramView, localArticleInfo1, localArticleInfo2, j, paramInt);
            saf.a("FrameworkHandler", String.valueOf(j), "getDynamicProteusView", System.currentTimeMillis() - l);
            paramViewGroup = paramView;
          } while (localArticleInfo1 == null);
          QLog.d("FrameworkHandler", 2, "article is dynamicProteusView: " + localArticleInfo1.mTitle);
          return paramView;
          if (j != 38) {
            break;
          }
          l = System.currentTimeMillis();
          paramView = oyb.a(this.jdField_a_of_type_Oyb, paramView, localArticleInfo1, paramInt);
          saf.a("FrameworkHandler", String.valueOf(j), "getArkAppView", System.currentTimeMillis() - l);
          paramViewGroup = paramView;
        } while (localArticleInfo1 == null);
        QLog.d("FrameworkHandler", 2, "article is arkAppView: " + localArticleInfo1.mTitle);
        return paramView;
      } while (!pqn.a(j));
      long l = System.currentTimeMillis();
      paramView = oyb.a(this.jdField_a_of_type_Oyb, paramView, localArticleInfo1, j, paramInt);
      saf.a("FrameworkHandler", String.valueOf(j), "cellRebuildCompleted", System.currentTimeMillis() - l);
      paramViewGroup = paramView;
    } while (localArticleInfo1 == null);
    QLog.d("FrameworkHandler", 2, "article is cellRebuildView: " + localArticleInfo1.mTitle);
    return paramView;
  }
  
  public void a()
  {
    this.c = true;
    odk.b(b());
  }
  
  public void a(View paramView, ListView paramListView)
  {
    a(paramView);
    b(paramView);
    if ((pqg.a.c()) && (ppj.a().a()) && (ppg.a(b()))) {
      this.jdField_a_of_type_Ppg = new ppg(a());
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    super.a(paramAbsListView, paramInt);
    if ((b() == 0) || (oou.c(b()))) {
      osx.a().a.onScrollStateChanged(paramAbsListView, paramInt);
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    a(paramInt1);
    if ((b() == 0) || (oou.c(b()))) {
      osx.a().a.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    ArticleInfo localArticleInfo = (ArticleInfo)a((int)paramLong);
    if ((oou.c(b())) || (b() == 0))
    {
      osx.a().a.a(paramView, (AbsListView)paramAdapterView, localArticleInfo);
      pyn.a().a(paramView, (AbsListView)paramAdapterView, localArticleInfo);
    }
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    }
  }
  
  public void a(List<BaseArticleInfo> paramList)
  {
    this.b = false;
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    this.c = true;
    otl localotl;
    if ((b() == 0) || (oou.c(b())))
    {
      localotl = osx.a().a;
      if (a() == null) {
        break label54;
      }
    }
    label54:
    for (ListView localListView = a().a();; localListView = null)
    {
      localotl.onScrollStateChanged(localListView, 6);
      return;
    }
  }
  
  public boolean a(int paramInt)
  {
    this.jdField_a_of_type_Oyb.a();
    if (oak.a(paramInt)) {}
    while ((!olo.a(paramInt)) && (!oyb.a(this.jdField_a_of_type_Oyb).a(paramInt)) && (38 != paramInt) && (!pqn.a(paramInt))) {
      return false;
    }
    return true;
  }
  
  public void b()
  {
    odk.a(b());
    qiw.a().a();
    otl localotl;
    if ((b() == 0) || (oou.c(b())))
    {
      localotl = osx.a().a;
      if (a() == null) {
        break label59;
      }
    }
    label59:
    for (ListView localListView = a().a();; localListView = null)
    {
      localotl.onScrollStateChanged(localListView, 5);
      return;
    }
  }
  
  public void c()
  {
    super.c();
    QLog.d("FrameworkHandler", 2, "doStart!");
  }
  
  public void d()
  {
    ntv.a().b(b(), this);
    if (this.jdField_a_of_type_Ppg != null) {
      this.jdField_a_of_type_Ppg.a();
    }
  }
  
  public void g()
  {
    k();
    otl localotl;
    if ((b() == 0) || (oou.c(b())))
    {
      localotl = osx.a().a;
      if (a() == null) {
        break label50;
      }
    }
    label50:
    for (ListView localListView = a().a();; localListView = null)
    {
      localotl.a(4, localListView);
      return;
    }
  }
  
  public void h()
  {
    super.h();
    if ((b() == 0) || (oou.c(b()))) {
      osx.a().a.a();
    }
  }
  
  public void i() {}
  
  public void j() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oxz
 * JD-Core Version:    0.7.0.1
 */