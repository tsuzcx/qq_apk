import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;

public class qyv
  extends qxr
  implements View.OnClickListener
{
  public raj a;
  boolean a;
  
  public qyv(View paramView, BaseData paramBaseData)
  {
    super(paramView, paramBaseData);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Raj = new raj();
    if (qyu.a()) {
      paramView.findViewById(2131312380).setVisibility(0);
    }
    paramView.findViewById(2131303017).setOnClickListener(this);
    paramView.findViewById(2131303021).setOnClickListener(this);
    paramView.findViewById(2131303101).setOnClickListener(this);
    paramView.findViewById(2131303100).setOnClickListener(this);
  }
  
  private void a(ArticleInfo paramArticleInfo, int paramInt)
  {
    ogy.a().a().a(paramArticleInfo.mArticleContentUrl, paramArticleInfo.innerUniqueID + "", paramArticleInfo.mSubscribeID, paramInt, new qyw(this, paramArticleInfo));
  }
  
  private void a(String paramString, ocg paramocg)
  {
    ArticleInfo localArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData.b;
    if (localArticleInfo == null) {
      return;
    }
    paramocg.b("source", "10");
    raz.a(localArticleInfo, paramString, paramocg.a());
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      a("0X80095EF", new ocg());
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
      this.jdField_a_of_type_AndroidViewView.findViewById(2131312380).setVisibility(8);
      localObject = new ocg();
      ((ocg)localObject).b("sourceFrom", paramView);
      a("0X80095F0", (ocg)localObject);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qyv
 * JD-Core Version:    0.7.0.1
 */