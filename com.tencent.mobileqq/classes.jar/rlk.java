import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;

public class rlk
  extends rkg
  implements View.OnClickListener
{
  public rmy a;
  boolean a;
  
  public rlk(View paramView, BaseData paramBaseData)
  {
    super(paramView, paramBaseData);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Rmy = new rmy();
    if (rlj.a()) {
      paramView.findViewById(2131378209).setVisibility(0);
    }
    paramView.findViewById(2131368652).setOnClickListener(this);
    paramView.findViewById(2131368655).setOnClickListener(this);
    paramView.findViewById(2131368741).setOnClickListener(this);
    paramView.findViewById(2131368740).setOnClickListener(this);
  }
  
  private void a(ArticleInfo paramArticleInfo, int paramInt)
  {
    osg.a().a().a(paramArticleInfo.mArticleContentUrl, paramArticleInfo.innerUniqueID + "", paramArticleInfo.mSubscribeID, paramInt, new rll(this, paramArticleInfo));
  }
  
  private void a(String paramString, ono paramono)
  {
    ArticleInfo localArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData.b;
    if (localArticleInfo == null) {
      return;
    }
    paramono.b("source", "10");
    rno.a(localArticleInfo, paramString, paramono.a());
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      a("0X80095EF", new ono());
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
      this.jdField_a_of_type_AndroidViewView.findViewById(2131378209).setVisibility(8);
      localObject = new ono();
      ((ono)localObject).b("sourceFrom", paramView);
      a("0X80095F0", (ono)localObject);
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
 * Qualified Name:     rlk
 * JD-Core Version:    0.7.0.1
 */