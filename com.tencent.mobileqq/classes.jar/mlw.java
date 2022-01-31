import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.comment.CommentInfo;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyTimeUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.CommentData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.item.BaseItemViewHolder;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.ReportUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.util.FaceDecoder;

public class mlw
  extends BaseItemViewHolder
  implements View.OnClickListener
{
  private static int jdField_a_of_type_Int = Color.parseColor("#07D0B0");
  private static int jdField_b_of_type_Int = Color.parseColor("#9D9D9D");
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private KandianUrlImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
  private FaceDecoder jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder;
  private String jdField_a_of_type_JavaLangString;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private TextView c;
  private TextView d;
  private TextView e;
  private TextView f;
  
  public mlw(View paramView, BaseData paramBaseData, FaceDecoder paramFaceDecoder)
  {
    super(paramView, paramBaseData);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = paramFaceDecoder;
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367060));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367061));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367062));
    this.c = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367064));
    this.d = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367065));
    this.e = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367067));
    this.f = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367068));
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131367063);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
  }
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    if ((TextUtils.equals(paramString, this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView != null) && (paramBitmap != null)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setImageBitmap(paramBitmap);
    }
  }
  
  public void b(BaseData paramBaseData1, BaseData paramBaseData2, boolean paramBoolean)
  {
    paramBaseData1 = ((CommentData)paramBaseData2).a;
    this.jdField_a_of_type_JavaLangString = paramBaseData1.authorUin;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setImageDrawable(SearchUtils.a(this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder, String.valueOf(paramBaseData1.authorUin), 1));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramBaseData1.authorNickName);
    if (paramBaseData1.author_selection == 0)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      if (paramBaseData1.rank == 0) {
        break label227;
      }
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      label81:
      if (TextUtils.isEmpty(paramBaseData1.commentContent)) {
        break label238;
      }
      paramBaseData2 = new QQText(MessageUtils.b(paramBaseData1.commentContent), 7, 16);
      this.c.setText(paramBaseData2);
      label118:
      this.f.setText(paramBaseData1.likeCount + "");
      if (!paramBaseData1.liked) {
        break label257;
      }
      this.f.setCompoundDrawablesWithIntrinsicBounds(2130840673, 0, 0, 0);
      this.f.setTextColor(jdField_a_of_type_Int);
    }
    for (;;)
    {
      this.f.setClickable(false);
      this.d.setText(ReadInJoyTimeUtils.a(paramBaseData1.commentTime, true));
      if (paramBaseData1.sub_comments_total > 0) {
        break label282;
      }
      this.e.setText("回复");
      return;
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      break;
      label227:
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      break label81;
      label238:
      if (paramBaseData1.gift_list == null) {
        break label118;
      }
      this.c.setText("发布了图片");
      break label118;
      label257:
      this.f.setCompoundDrawablesWithIntrinsicBounds(2130840674, 0, 0, 0);
      this.f.setTextColor(jdField_b_of_type_Int);
    }
    label282:
    this.e.setText(paramBaseData1.sub_comments_total + "回复");
  }
  
  public void onClick(View paramView)
  {
    paramView = (BaseActivity)this.jdField_a_of_type_AndroidViewView.getContext();
    if ((paramView != null) && ((paramView instanceof FastWebActivity))) {
      ((FastWebActivity)paramView).a();
    }
    ArticleInfo localArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
    int i = (int)localArticleInfo.mChannelID;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.c()) {}
    for (paramView = "2";; paramView = "1")
    {
      ReportUtil.a(localArticleInfo, "0X8009009", ReadInJoyUtils.a(localArticleInfo, i, paramView));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mlw
 * JD-Core Version:    0.7.0.1
 */