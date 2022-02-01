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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class pmx
  extends pnd
  implements View.OnClickListener, pmw
{
  public View a;
  public ViewGroup a;
  public ImageView a;
  public RelativeLayout a;
  public TextView a;
  public KanDianUrlRoundCornerImageView a;
  public KandianUrlImageView a;
  public VideoViewGroup a;
  public rwc a;
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
  
  public pmx(Context paramContext, pms parampms)
  {
    super(paramContext, parampms);
  }
  
  private void a(View paramView)
  {
    BaseArticleInfo localBaseArticleInfo = pms.a(this.jdField_a_of_type_Pms, paramView);
    if ((localBaseArticleInfo != null) && (this.jdField_a_of_type_Pms != null) && (localBaseArticleInfo.mVideoColumnInfo != null) && (localBaseArticleInfo.mVideoColumnInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo != null) && (localBaseArticleInfo.mVideoColumnInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.jdField_a_of_type_Int != 3))
    {
      rpt.a(this.jdField_a_of_type_Pms.a(), localBaseArticleInfo.mVideoColumnInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo);
      if (localBaseArticleInfo.mVideoColumnInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo != null) {
        break label126;
      }
    }
    label126:
    for (paramView = null;; paramView = localBaseArticleInfo.mVideoColumnInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.e)
    {
      pms.a(this.jdField_a_of_type_Pms, localBaseArticleInfo, localBaseArticleInfo.mVideoColumnInfo, 1, paramView);
      return;
      paramView = pms.a(paramView);
      if (paramView == null) {
        break;
      }
      this.jdField_a_of_type_Pms.a().a(paramView.a(), localBaseArticleInfo, false, false);
      break;
    }
  }
  
  private void b(View paramView)
  {
    BaseArticleInfo localBaseArticleInfo = pms.a(this.jdField_a_of_type_Pms, paramView);
    if ((localBaseArticleInfo != null) && (this.jdField_a_of_type_Pms != null) && (localBaseArticleInfo.mVideoColumnInfo != null))
    {
      rpt.a(this.jdField_a_of_type_Pms.a(), localBaseArticleInfo.mVideoColumnInfo.jdField_c_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo);
      rpt.a(ozs.a(), localBaseArticleInfo.mVideoColumnInfo.jdField_a_of_type_Int, true, localBaseArticleInfo.mVideoColumnInfo.jdField_c_of_type_JavaLangString);
      localBaseArticleInfo.mVideoColumnInfo.jdField_a_of_type_Boolean = true;
      VideoColumnInfo localVideoColumnInfo = localBaseArticleInfo.mVideoColumnInfo;
      localVideoColumnInfo.jdField_c_of_type_Int += 1;
      pfa.a().b((ArticleInfo)localBaseArticleInfo);
      paramView.setVisibility(8);
      if (localBaseArticleInfo.mVideoColumnInfo.jdField_c_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo != null) {
        break label131;
      }
    }
    label131:
    for (paramView = null;; paramView = localBaseArticleInfo.mVideoColumnInfo.jdField_c_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.e)
    {
      pms.a(this.jdField_a_of_type_Pms, localBaseArticleInfo, localBaseArticleInfo.mVideoColumnInfo, 2, paramView);
      return;
    }
  }
  
  private void c(View paramView)
  {
    BaseArticleInfo localBaseArticleInfo = pms.a(this.jdField_a_of_type_Pms, paramView);
    if ((localBaseArticleInfo != null) && (this.jdField_a_of_type_Pms != null) && (localBaseArticleInfo.mVideoColumnInfo != null) && (localBaseArticleInfo.mVideoColumnInfo.b != null) && (localBaseArticleInfo.mVideoColumnInfo.b.jdField_a_of_type_Int != 3))
    {
      rpt.a(this.jdField_a_of_type_Pms.a(), localBaseArticleInfo.mVideoColumnInfo.b);
      if (localBaseArticleInfo.mVideoColumnInfo.b != null) {
        break label126;
      }
    }
    label126:
    for (paramView = null;; paramView = localBaseArticleInfo.mVideoColumnInfo.b.e)
    {
      pms.a(this.jdField_a_of_type_Pms, localBaseArticleInfo, localBaseArticleInfo.mVideoColumnInfo, 3, paramView);
      return;
      paramView = pms.a(paramView);
      if (paramView == null) {
        break;
      }
      this.jdField_a_of_type_Pms.a().a(paramView.a(), localBaseArticleInfo, false, false);
      break;
    }
  }
  
  private void d(View paramView)
  {
    BaseArticleInfo localBaseArticleInfo = pms.a(this.jdField_a_of_type_Pms, paramView);
    if ((localBaseArticleInfo != null) && (this.jdField_a_of_type_Pms != null) && (localBaseArticleInfo.mVideoColumnInfo != null))
    {
      rpt.a(this.jdField_a_of_type_Pms.a(), localBaseArticleInfo.mVideoColumnInfo.d);
      if (localBaseArticleInfo.mVideoColumnInfo.d != null) {
        break label71;
      }
    }
    label71:
    for (paramView = null;; paramView = localBaseArticleInfo.mVideoColumnInfo.d.e)
    {
      pms.a(this.jdField_a_of_type_Pms, localBaseArticleInfo, localBaseArticleInfo.mVideoColumnInfo, 4, paramView);
      return;
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public View a(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560363, paramViewGroup, false);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramViewGroup.findViewById(2131367963));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramViewGroup.findViewById(2131367964));
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramViewGroup.findViewById(2131364752));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131364755));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131364753));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131378191));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramViewGroup.findViewById(2131365055));
    this.d = ((TextView)paramViewGroup.findViewById(2131378936));
    this.e = ((TextView)paramViewGroup.findViewById(2131372762));
    this.f = ((TextView)paramViewGroup.findViewById(2131365785));
    this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramViewGroup.findViewById(2131368320));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup = ((VideoViewGroup)paramViewGroup.findViewById(2131380872));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131372119));
    this.g = ((TextView)paramViewGroup.findViewById(2131372120));
    this.h = ((TextView)paramViewGroup.findViewById(2131369574));
    this.jdField_a_of_type_AndroidViewView = paramViewGroup.findViewById(2131378993);
    this.jdField_b_of_type_AndroidViewView = paramViewGroup.findViewById(2131379020);
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)paramViewGroup.findViewById(2131362814));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView = ((KanDianUrlRoundCornerImageView)paramViewGroup.findViewById(2131364748));
    this.i = ((TextView)paramViewGroup.findViewById(2131364749));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131380413));
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
  
  public rwc a()
  {
    return this.jdField_a_of_type_Rwc;
  }
  
  public boolean a(View paramView)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (!rpt.a(pms.a(this.jdField_a_of_type_Pms, paramView))) {}
    int j;
    float f1;
    do
    {
      do
      {
        return false;
        j = rpt.d();
      } while (j == 0);
      f1 = ozc.a(paramView);
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "VideoColumnItemViewHolder() canAutoPlay percent:" + f1);
      }
      if (j == 1)
      {
        if ((rmn.a().e()) && (f1 >= 70.0F)) {}
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
    pms.a(paramView);
    switch (paramView.getId())
    {
    default: 
      a(paramView);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      b(paramView);
      continue;
      a(paramView);
      continue;
      c(paramView);
      continue;
      d(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pmx
 * JD-Core Version:    0.7.0.1
 */