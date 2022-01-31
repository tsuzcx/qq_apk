import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;

public class sbi
  extends sah
  implements View.OnClickListener
{
  public scx a;
  boolean a;
  
  public sbi(View paramView, BaseData paramBaseData)
  {
    super(paramView, paramBaseData);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Scx = new scx();
    if (sbh.a()) {
      paramView.findViewById(2131378831).setVisibility(0);
    }
    paramView.findViewById(2131368876).setOnClickListener(this);
    paramView.findViewById(2131368879).setOnClickListener(this);
    paramView.findViewById(2131368977).setOnClickListener(this);
    paramView.findViewById(2131368976).setOnClickListener(this);
  }
  
  private void a(ArticleInfo paramArticleInfo, int paramInt)
  {
    owy.a().a().a(paramArticleInfo.mArticleContentUrl, paramArticleInfo.innerUniqueID + "", paramArticleInfo.mSubscribeID, paramInt, new sbj(this, paramArticleInfo));
  }
  
  private void a(String paramString, orz paramorz)
  {
    ArticleInfo localArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData.b;
    if (localArticleInfo == null) {
      return;
    }
    paramorz.b("source", "10");
    sdn.a(localArticleInfo, paramString, paramorz.a());
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      a("0X80095EF", new orz());
    }
  }
  
  public void a(BaseData paramBaseData1, BaseData paramBaseData2, boolean paramBoolean) {}
  
  public void onClick(View paramView)
  {
    ArticleInfo localArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData.b;
    if (localArticleInfo == null) {
      return;
    }
    Object localObject = "";
    switch (paramView.getId())
    {
    default: 
      paramView = (View)localObject;
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewView.findViewById(2131378831).setVisibility(8);
      localObject = new orz();
      ((orz)localObject).b("sourceFrom", paramView);
      a("0X80095F0", (orz)localObject);
      return;
      a(localArticleInfo, 2);
      paramView = "1";
      continue;
      a(localArticleInfo, 3);
      paramView = "2";
      continue;
      a(localArticleInfo, 4);
      paramView = "3";
      continue;
      a(localArticleInfo, 5);
      paramView = "4";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     sbi
 * JD-Core Version:    0.7.0.1
 */