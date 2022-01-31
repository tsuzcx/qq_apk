import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.UrlJumpInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.view.KanDianUrlRoundCornerImageView;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.biz.pubaccount.readinjoy.view.VideoViewGroup;
import com.tencent.qphone.base.util.QLog;

public class oyj
  extends oyp
  implements View.OnClickListener, oyi
{
  public View a;
  public ViewGroup a;
  public ImageView a;
  public RelativeLayout a;
  public TextView a;
  public KanDianUrlRoundCornerImageView a;
  public KandianUrlImageView a;
  public VideoViewGroup a;
  public qtv a;
  public View b;
  public ViewGroup b;
  public ImageView b;
  public TextView b;
  public KandianUrlImageView b;
  public TextView c;
  public KandianUrlImageView c;
  public TextView d;
  public TextView e;
  public TextView f;
  public TextView g;
  public TextView h;
  public TextView i;
  
  public oyj(Context paramContext, oye paramoye)
  {
    super(paramContext, paramoye);
  }
  
  private void a(View paramView)
  {
    BaseArticleInfo localBaseArticleInfo = oye.a(this.jdField_a_of_type_Oye, paramView);
    if ((localBaseArticleInfo != null) && (this.jdField_a_of_type_Oye != null) && (localBaseArticleInfo.mVideoColumnInfo != null) && (localBaseArticleInfo.mVideoColumnInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo != null) && (localBaseArticleInfo.mVideoColumnInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.jdField_a_of_type_Int != 3))
    {
      qoi.a(this.jdField_a_of_type_Oye.a(), localBaseArticleInfo.mVideoColumnInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo);
      if (localBaseArticleInfo.mVideoColumnInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo != null) {
        break label126;
      }
    }
    label126:
    for (paramView = null;; paramView = localBaseArticleInfo.mVideoColumnInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.e)
    {
      oye.a(this.jdField_a_of_type_Oye, localBaseArticleInfo, localBaseArticleInfo.mVideoColumnInfo, 1, paramView);
      return;
      paramView = oye.a(paramView);
      if (paramView == null) {
        break;
      }
      this.jdField_a_of_type_Oye.a().a(paramView.a(), localBaseArticleInfo, false, false);
      break;
    }
  }
  
  private void b(View paramView)
  {
    BaseArticleInfo localBaseArticleInfo = oye.a(this.jdField_a_of_type_Oye, paramView);
    if ((localBaseArticleInfo != null) && (this.jdField_a_of_type_Oye != null) && (localBaseArticleInfo.mVideoColumnInfo != null))
    {
      qoi.a(this.jdField_a_of_type_Oye.a(), localBaseArticleInfo.mVideoColumnInfo.jdField_c_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo);
      qoi.a(onh.a(), localBaseArticleInfo.mVideoColumnInfo.jdField_a_of_type_Int);
      localBaseArticleInfo.mVideoColumnInfo.jdField_a_of_type_Boolean = true;
      VideoColumnInfo localVideoColumnInfo = localBaseArticleInfo.mVideoColumnInfo;
      localVideoColumnInfo.jdField_c_of_type_Int += 1;
      osg.a().a((ArticleInfo)localBaseArticleInfo);
      paramView.setVisibility(8);
      if (localBaseArticleInfo.mVideoColumnInfo.jdField_c_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo != null) {
        break label123;
      }
    }
    label123:
    for (paramView = null;; paramView = localBaseArticleInfo.mVideoColumnInfo.jdField_c_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.e)
    {
      oye.a(this.jdField_a_of_type_Oye, localBaseArticleInfo, localBaseArticleInfo.mVideoColumnInfo, 2, paramView);
      return;
    }
  }
  
  private void c(View paramView)
  {
    BaseArticleInfo localBaseArticleInfo = oye.a(this.jdField_a_of_type_Oye, paramView);
    if ((localBaseArticleInfo != null) && (this.jdField_a_of_type_Oye != null) && (localBaseArticleInfo.mVideoColumnInfo != null) && (localBaseArticleInfo.mVideoColumnInfo.b != null) && (localBaseArticleInfo.mVideoColumnInfo.b.jdField_a_of_type_Int != 3))
    {
      qoi.a(this.jdField_a_of_type_Oye.a(), localBaseArticleInfo.mVideoColumnInfo.b);
      if (localBaseArticleInfo.mVideoColumnInfo.b != null) {
        break label126;
      }
    }
    label126:
    for (paramView = null;; paramView = localBaseArticleInfo.mVideoColumnInfo.b.e)
    {
      oye.a(this.jdField_a_of_type_Oye, localBaseArticleInfo, localBaseArticleInfo.mVideoColumnInfo, 3, paramView);
      return;
      paramView = oye.a(paramView);
      if (paramView == null) {
        break;
      }
      this.jdField_a_of_type_Oye.a().a(paramView.a(), localBaseArticleInfo, false, false);
      break;
    }
  }
  
  private void d(View paramView)
  {
    BaseArticleInfo localBaseArticleInfo = oye.a(this.jdField_a_of_type_Oye, paramView);
    if ((localBaseArticleInfo != null) && (this.jdField_a_of_type_Oye != null) && (localBaseArticleInfo.mVideoColumnInfo != null))
    {
      qoi.a(this.jdField_a_of_type_Oye.a(), localBaseArticleInfo.mVideoColumnInfo.d);
      if (localBaseArticleInfo.mVideoColumnInfo.d != null) {
        break label71;
      }
    }
    label71:
    for (paramView = null;; paramView = localBaseArticleInfo.mVideoColumnInfo.d.e)
    {
      oye.a(this.jdField_a_of_type_Oye, localBaseArticleInfo, localBaseArticleInfo.mVideoColumnInfo, 4, paramView);
      return;
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public View a(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560097, paramViewGroup, false);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramViewGroup.findViewById(2131367445));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramViewGroup.findViewById(2131367446));
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramViewGroup.findViewById(2131364419));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131364421));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131364420));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131376661));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramViewGroup.findViewById(2131364700));
    this.d = ((TextView)paramViewGroup.findViewById(2131377350));
    this.e = ((TextView)paramViewGroup.findViewById(2131371742));
    this.f = ((TextView)paramViewGroup.findViewById(2131365420));
    this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramViewGroup.findViewById(2131367776));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup = ((VideoViewGroup)paramViewGroup.findViewById(2131379015));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131371103));
    this.g = ((TextView)paramViewGroup.findViewById(2131371104));
    this.h = ((TextView)paramViewGroup.findViewById(2131368849));
    this.jdField_a_of_type_AndroidViewView = paramViewGroup.findViewById(2131377400);
    this.jdField_b_of_type_AndroidViewView = paramViewGroup.findViewById(2131377425);
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)paramViewGroup.findViewById(2131362659));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView = ((KanDianUrlRoundCornerImageView)paramViewGroup.findViewById(2131364417));
    this.i = ((TextView)paramViewGroup.findViewById(2131364418));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131378625));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewViewGroup.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView.setOnClickListener(this);
    this.i.setOnClickListener(this);
    this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup.setOnClickListener(this);
    paramViewGroup.setTag(this);
    return paramViewGroup;
  }
  
  public qtv a()
  {
    return this.jdField_a_of_type_Qtv;
  }
  
  public boolean a(View paramView)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (!qoi.a(oye.a(this.jdField_a_of_type_Oye, paramView))) {}
    int j;
    float f1;
    do
    {
      do
      {
        return false;
        j = qoi.a();
      } while (j == 0);
      f1 = omr.a(paramView);
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "VideoColumnItemViewHolder() canAutoPlay percent:" + f1);
      }
      if (j == 1)
      {
        if ((qkr.a().f()) && (f1 >= 70.0F)) {}
        for (;;)
        {
          return bool1;
          bool1 = false;
        }
      }
    } while (j != 2);
    if (f1 >= 70.0F) {}
    for (bool1 = bool2;; bool1 = false) {
      return bool1;
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      a(paramView);
      return;
    case 2131376661: 
      b(paramView);
      return;
    case 2131367445: 
      a(paramView);
      return;
    case 2131367776: 
    case 2131379015: 
      c(paramView);
      return;
    }
    d(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oyj
 * JD-Core Version:    0.7.0.1
 */