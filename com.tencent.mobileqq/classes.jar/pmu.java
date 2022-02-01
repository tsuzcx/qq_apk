import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.UrlJumpInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.biz.pubaccount.readinjoy.view.VideoViewGroup;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class pmu
  extends pnd
  implements View.OnClickListener, pmw
{
  View a;
  public ImageView a;
  public TextView a;
  public KandianUrlImageView a;
  public VideoViewGroup a;
  public rwc a;
  public View b;
  public ImageView b;
  public TextView b;
  public KandianUrlImageView b;
  public View c;
  public TextView c;
  public View d;
  public TextView d;
  public TextView e;
  public TextView f;
  public TextView g;
  
  public pmu(Context paramContext, pms parampms)
  {
    super(paramContext, parampms);
  }
  
  private void a(View paramView)
  {
    if ((paramView == null) || (this.jdField_a_of_type_Pms == null)) {}
    BaseArticleInfo localBaseArticleInfo;
    do
    {
      return;
      localBaseArticleInfo = pms.a(this.jdField_a_of_type_Pms, paramView);
    } while (localBaseArticleInfo == null);
    if ((rpt.i() == 1) && (this.jdField_a_of_type_Pms.a().a() != null))
    {
      rvy localrvy = this.jdField_a_of_type_Pms.a().a();
      if ((localrvy != null) && (localrvy.a() != null))
      {
        localrvy.a().c(paramView);
        return;
      }
    }
    if ((localBaseArticleInfo != null) && (localBaseArticleInfo.mSimpleVideoColumnInfo != null) && (localBaseArticleInfo.mSimpleVideoColumnInfo.b != null) && (localBaseArticleInfo.mSimpleVideoColumnInfo.b.jdField_a_of_type_Int != 3))
    {
      rpt.a(this.jdField_a_of_type_Pms.a(), localBaseArticleInfo.mSimpleVideoColumnInfo.b);
      if (localBaseArticleInfo.mSimpleVideoColumnInfo.b != null) {
        break label186;
      }
    }
    label186:
    for (paramView = null;; paramView = localBaseArticleInfo.mSimpleVideoColumnInfo.b.e)
    {
      pms.a(this.jdField_a_of_type_Pms, localBaseArticleInfo, localBaseArticleInfo.mSimpleVideoColumnInfo, 1, paramView);
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
    if ((localBaseArticleInfo != null) && (this.jdField_a_of_type_Pms != null) && (localBaseArticleInfo.mSimpleVideoColumnInfo != null))
    {
      if ((localBaseArticleInfo.mSimpleVideoColumnInfo.a == null) || (localBaseArticleInfo.mSimpleVideoColumnInfo.a.jdField_a_of_type_Int == 3)) {
        break label95;
      }
      rpt.a(this.jdField_a_of_type_Pms.a(), localBaseArticleInfo.mSimpleVideoColumnInfo.a);
      if (localBaseArticleInfo.mSimpleVideoColumnInfo.a != null) {
        break label126;
      }
    }
    label95:
    label126:
    for (paramView = null;; paramView = localBaseArticleInfo.mSimpleVideoColumnInfo.a.e)
    {
      pms.a(this.jdField_a_of_type_Pms, localBaseArticleInfo, localBaseArticleInfo.mSimpleVideoColumnInfo, 2, paramView);
      return;
      paramView = pms.a(paramView);
      if (paramView == null) {
        break;
      }
      this.jdField_a_of_type_Pms.a().a(paramView.a(), localBaseArticleInfo, false, false);
      break;
    }
  }
  
  private void c(View paramView)
  {
    BaseArticleInfo localBaseArticleInfo = pms.a(this.jdField_a_of_type_Pms, paramView);
    if ((localBaseArticleInfo != null) && (this.jdField_a_of_type_Pms != null) && (localBaseArticleInfo.mSimpleVideoColumnInfo != null) && (localBaseArticleInfo.mSimpleVideoColumnInfo.d != null))
    {
      rpt.a(this.jdField_a_of_type_Pms.a(), localBaseArticleInfo.mSimpleVideoColumnInfo.d);
      if (localBaseArticleInfo.mSimpleVideoColumnInfo.d != null) {
        break label81;
      }
    }
    label81:
    for (paramView = null;; paramView = localBaseArticleInfo.mSimpleVideoColumnInfo.d.e)
    {
      pms.a(this.jdField_a_of_type_Pms, localBaseArticleInfo, localBaseArticleInfo.mSimpleVideoColumnInfo, 3, paramView);
      return;
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public View a(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560362, paramViewGroup, false);
    this.jdField_a_of_type_AndroidViewView = paramViewGroup.findViewById(2131376925);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131378936));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131372762));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131365785));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramViewGroup.findViewById(2131368320));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup = ((VideoViewGroup)paramViewGroup.findViewById(2131380872));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131372119));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131372120));
    this.e = ((TextView)paramViewGroup.findViewById(2131369574));
    this.jdField_b_of_type_AndroidViewView = paramViewGroup.findViewById(2131378993);
    this.jdField_c_of_type_AndroidViewView = paramViewGroup.findViewById(2131379020);
    this.jdField_d_of_type_AndroidViewView = paramViewGroup.findViewById(2131363593);
    this.f = ((TextView)paramViewGroup.findViewById(2131366578));
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramViewGroup.findViewById(2131366579));
    this.g = ((TextView)paramViewGroup.findViewById(2131366580));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131380413));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setTag(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup.setTag(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup.setOnClickListener(this);
    this.jdField_d_of_type_AndroidViewView.setTag(this);
    this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setTag(this);
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setOnClickListener(this);
    this.g.setTag(this);
    this.g.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView.setTag(this);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
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
    int i;
    float f1;
    do
    {
      do
      {
        return false;
        i = rpt.h();
      } while (i == 0);
      f1 = ozc.a(paramView);
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "BigImgVideoItemViewHolder() canAutoPlay percent:" + f1);
      }
      if (i == 1)
      {
        if ((rmn.a().e()) && (f1 >= 70.0F)) {}
        for (;;)
        {
          return bool1;
          bool1 = false;
        }
      }
    } while (i != 2);
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
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      a(paramView);
      continue;
      b(paramView);
      continue;
      c(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pmu
 * JD-Core Version:    0.7.0.1
 */