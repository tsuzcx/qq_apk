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

public class pdl
  extends pdu
  implements View.OnClickListener, pdn
{
  View a;
  public ImageView a;
  public TextView a;
  public KandianUrlImageView a;
  public VideoViewGroup a;
  public rjk a;
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
  
  public pdl(Context paramContext, pdj parampdj)
  {
    super(paramContext, parampdj);
  }
  
  private void a(View paramView)
  {
    if ((paramView == null) || (this.jdField_a_of_type_Pdj == null)) {}
    BaseArticleInfo localBaseArticleInfo;
    do
    {
      return;
      localBaseArticleInfo = pdj.a(this.jdField_a_of_type_Pdj, paramView);
    } while (localBaseArticleInfo == null);
    if ((rdm.e() == 1) && (this.jdField_a_of_type_Pdj.a().a() != null))
    {
      rjg localrjg = this.jdField_a_of_type_Pdj.a().a();
      if ((localrjg != null) && (localrjg.a() != null))
      {
        localrjg.a().c(paramView);
        return;
      }
    }
    if ((localBaseArticleInfo != null) && (localBaseArticleInfo.mSimpleVideoColumnInfo != null) && (localBaseArticleInfo.mSimpleVideoColumnInfo.b != null) && (localBaseArticleInfo.mSimpleVideoColumnInfo.b.jdField_a_of_type_Int != 3))
    {
      rdm.a(this.jdField_a_of_type_Pdj.a(), localBaseArticleInfo.mSimpleVideoColumnInfo.b);
      if (localBaseArticleInfo.mSimpleVideoColumnInfo.b != null) {
        break label186;
      }
    }
    label186:
    for (paramView = null;; paramView = localBaseArticleInfo.mSimpleVideoColumnInfo.b.e)
    {
      pdj.a(this.jdField_a_of_type_Pdj, localBaseArticleInfo, localBaseArticleInfo.mSimpleVideoColumnInfo, 1, paramView);
      return;
      paramView = pdj.a(paramView);
      if (paramView == null) {
        break;
      }
      this.jdField_a_of_type_Pdj.a().a(paramView.a(), localBaseArticleInfo, false, false);
      break;
    }
  }
  
  private void b(View paramView)
  {
    BaseArticleInfo localBaseArticleInfo = pdj.a(this.jdField_a_of_type_Pdj, paramView);
    if ((localBaseArticleInfo != null) && (this.jdField_a_of_type_Pdj != null) && (localBaseArticleInfo.mSimpleVideoColumnInfo != null))
    {
      if ((localBaseArticleInfo.mSimpleVideoColumnInfo.a == null) || (localBaseArticleInfo.mSimpleVideoColumnInfo.a.jdField_a_of_type_Int == 3)) {
        break label95;
      }
      rdm.a(this.jdField_a_of_type_Pdj.a(), localBaseArticleInfo.mSimpleVideoColumnInfo.a);
      if (localBaseArticleInfo.mSimpleVideoColumnInfo.a != null) {
        break label126;
      }
    }
    label95:
    label126:
    for (paramView = null;; paramView = localBaseArticleInfo.mSimpleVideoColumnInfo.a.e)
    {
      pdj.a(this.jdField_a_of_type_Pdj, localBaseArticleInfo, localBaseArticleInfo.mSimpleVideoColumnInfo, 2, paramView);
      return;
      paramView = pdj.a(paramView);
      if (paramView == null) {
        break;
      }
      this.jdField_a_of_type_Pdj.a().a(paramView.a(), localBaseArticleInfo, false, false);
      break;
    }
  }
  
  private void c(View paramView)
  {
    BaseArticleInfo localBaseArticleInfo = pdj.a(this.jdField_a_of_type_Pdj, paramView);
    if ((localBaseArticleInfo != null) && (this.jdField_a_of_type_Pdj != null) && (localBaseArticleInfo.mSimpleVideoColumnInfo != null) && (localBaseArticleInfo.mSimpleVideoColumnInfo.d != null))
    {
      rdm.a(this.jdField_a_of_type_Pdj.a(), localBaseArticleInfo.mSimpleVideoColumnInfo.d);
      if (localBaseArticleInfo.mSimpleVideoColumnInfo.d != null) {
        break label81;
      }
    }
    label81:
    for (paramView = null;; paramView = localBaseArticleInfo.mSimpleVideoColumnInfo.d.e)
    {
      pdj.a(this.jdField_a_of_type_Pdj, localBaseArticleInfo, localBaseArticleInfo.mSimpleVideoColumnInfo, 3, paramView);
      return;
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public View a(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560197, paramViewGroup, false);
    this.jdField_a_of_type_AndroidViewView = paramViewGroup.findViewById(2131376034);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131377938));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131372080));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131365506));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramViewGroup.findViewById(2131367921));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup = ((VideoViewGroup)paramViewGroup.findViewById(2131379738));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131371435));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131371436));
    this.e = ((TextView)paramViewGroup.findViewById(2131369096));
    this.jdField_b_of_type_AndroidViewView = paramViewGroup.findViewById(2131377989);
    this.jdField_c_of_type_AndroidViewView = paramViewGroup.findViewById(2131378016);
    this.jdField_d_of_type_AndroidViewView = ((ViewGroup)paramViewGroup.findViewById(2131363376));
    this.f = ((TextView)paramViewGroup.findViewById(2131366275));
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramViewGroup.findViewById(2131366276));
    this.g = ((TextView)paramViewGroup.findViewById(2131366277));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131379300));
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
  
  public rjk a()
  {
    return this.jdField_a_of_type_Rjk;
  }
  
  public boolean a(View paramView)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (!rdm.a(pdj.a(this.jdField_a_of_type_Pdj, paramView))) {}
    int i;
    float f1;
    do
    {
      do
      {
        return false;
        i = rdm.d();
      } while (i == 0);
      f1 = orc.a(paramView);
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "BigImgVideoItemViewHolder() canAutoPlay percent:" + f1);
      }
      if (i == 1)
      {
        if ((qzy.a().f()) && (f1 >= 70.0F)) {}
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
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131367921: 
    case 2131379738: 
      a(paramView);
      return;
    case 2131363376: 
    case 2131376034: 
      b(paramView);
      return;
    }
    c(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pdl
 * JD-Core Version:    0.7.0.1
 */