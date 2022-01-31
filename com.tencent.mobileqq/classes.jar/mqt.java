import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.CommonBottomData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.item.BaseItemViewHolder;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.item.SimpleViewCreator;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.ReportUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.util.DisplayUtil;

public class mqt
  extends BaseItemViewHolder
  implements View.OnClickListener
{
  private View b = this.jdField_a_of_type_AndroidViewView.findViewById(2131367118);
  private View c = this.jdField_a_of_type_AndroidViewView.findViewById(2131367119);
  private View d = this.jdField_a_of_type_AndroidViewView.findViewById(2131367117);
  
  public mqt(SimpleViewCreator paramSimpleViewCreator, View paramView, BaseData paramBaseData)
  {
    super(paramView, paramBaseData);
    this.d.setOnClickListener(this);
  }
  
  public void b(BaseData paramBaseData1, BaseData paramBaseData2, boolean paramBoolean)
  {
    int i = 0;
    paramBaseData1 = (CommonBottomData)paramBaseData2;
    if ((paramBaseData1.d == 14) && (paramBaseData1.b))
    {
      this.d.setVisibility(0);
      if (!paramBaseData1.a) {
        break label148;
      }
      this.c.setVisibility(0);
      if (paramBaseData2.d != 14) {
        break label123;
      }
      this.c.getLayoutParams().height = DisplayUtil.a(this.c.getContext(), 6.0F);
      label78:
      paramBaseData1 = (LinearLayout.LayoutParams)this.b.getLayoutParams();
      if (paramBaseData2.d != 14) {
        break label160;
      }
    }
    for (;;)
    {
      paramBaseData1.rightMargin = i;
      paramBaseData1.leftMargin = i;
      return;
      this.d.setVisibility(8);
      break;
      label123:
      this.c.getLayoutParams().height = DisplayUtil.a(this.c.getContext(), 40.0F);
      break label78;
      label148:
      this.c.setVisibility(8);
      break label78;
      label160:
      i = DisplayUtil.a(this.b.getContext(), 12.0F);
    }
  }
  
  public void onClick(View paramView)
  {
    ArticleInfo localArticleInfo;
    int i;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData.d == 14)
    {
      paramView = (BaseActivity)this.jdField_a_of_type_AndroidViewView.getContext();
      if ((paramView != null) && ((paramView instanceof FastWebActivity))) {
        ((FastWebActivity)paramView).a();
      }
      localArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
      i = (int)localArticleInfo.mChannelID;
      if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.c()) {
        break label84;
      }
    }
    label84:
    for (paramView = "2";; paramView = "1")
    {
      ReportUtil.a(localArticleInfo, "0X800900A", ReadInJoyUtils.a(localArticleInfo, i, paramView));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mqt
 * JD-Core Version:    0.7.0.1
 */