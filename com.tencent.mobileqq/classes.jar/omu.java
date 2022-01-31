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

public class omu
  extends ond
  implements View.OnClickListener, omw
{
  View a;
  public ImageView a;
  public TextView a;
  public KandianUrlImageView a;
  public VideoViewGroup a;
  public qht a;
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
  
  public omu(Context paramContext, oms paramoms)
  {
    super(paramContext, paramoms);
  }
  
  private void a(View paramView)
  {
    if ((paramView == null) || (this.jdField_a_of_type_Oms == null)) {}
    BaseArticleInfo localBaseArticleInfo;
    do
    {
      return;
      localBaseArticleInfo = oms.a(this.jdField_a_of_type_Oms, paramView);
    } while (localBaseArticleInfo == null);
    if ((qcn.e() == 1) && (this.jdField_a_of_type_Oms.a().a() != null))
    {
      qhp localqhp = this.jdField_a_of_type_Oms.a().a();
      if ((localqhp != null) && (localqhp.a() != null))
      {
        localqhp.a().c(paramView);
        return;
      }
    }
    if ((localBaseArticleInfo != null) && (localBaseArticleInfo.mSimpleVideoColumnInfo != null) && (localBaseArticleInfo.mSimpleVideoColumnInfo.b != null) && (localBaseArticleInfo.mSimpleVideoColumnInfo.b.jdField_a_of_type_Int != 3))
    {
      qcn.a(this.jdField_a_of_type_Oms.a(), localBaseArticleInfo.mSimpleVideoColumnInfo.b);
      if (localBaseArticleInfo.mSimpleVideoColumnInfo.b != null) {
        break label186;
      }
    }
    label186:
    for (paramView = null;; paramView = localBaseArticleInfo.mSimpleVideoColumnInfo.b.e)
    {
      oms.a(this.jdField_a_of_type_Oms, localBaseArticleInfo, localBaseArticleInfo.mSimpleVideoColumnInfo, 1, paramView);
      return;
      paramView = oms.a(paramView);
      if (paramView == null) {
        break;
      }
      this.jdField_a_of_type_Oms.a().a(paramView.a(), localBaseArticleInfo, false, false);
      break;
    }
  }
  
  private void b(View paramView)
  {
    BaseArticleInfo localBaseArticleInfo = oms.a(this.jdField_a_of_type_Oms, paramView);
    if ((localBaseArticleInfo != null) && (this.jdField_a_of_type_Oms != null) && (localBaseArticleInfo.mSimpleVideoColumnInfo != null))
    {
      if ((localBaseArticleInfo.mSimpleVideoColumnInfo.a == null) || (localBaseArticleInfo.mSimpleVideoColumnInfo.a.jdField_a_of_type_Int == 3)) {
        break label95;
      }
      qcn.a(this.jdField_a_of_type_Oms.a(), localBaseArticleInfo.mSimpleVideoColumnInfo.a);
      if (localBaseArticleInfo.mSimpleVideoColumnInfo.a != null) {
        break label126;
      }
    }
    label95:
    label126:
    for (paramView = null;; paramView = localBaseArticleInfo.mSimpleVideoColumnInfo.a.e)
    {
      oms.a(this.jdField_a_of_type_Oms, localBaseArticleInfo, localBaseArticleInfo.mSimpleVideoColumnInfo, 2, paramView);
      return;
      paramView = oms.a(paramView);
      if (paramView == null) {
        break;
      }
      this.jdField_a_of_type_Oms.a().a(paramView.a(), localBaseArticleInfo, false, false);
      break;
    }
  }
  
  private void c(View paramView)
  {
    BaseArticleInfo localBaseArticleInfo = oms.a(this.jdField_a_of_type_Oms, paramView);
    if ((localBaseArticleInfo != null) && (this.jdField_a_of_type_Oms != null) && (localBaseArticleInfo.mSimpleVideoColumnInfo != null) && (localBaseArticleInfo.mSimpleVideoColumnInfo.d != null))
    {
      qcn.a(this.jdField_a_of_type_Oms.a(), localBaseArticleInfo.mSimpleVideoColumnInfo.d);
      if (localBaseArticleInfo.mSimpleVideoColumnInfo.d != null) {
        break label81;
      }
    }
    label81:
    for (paramView = null;; paramView = localBaseArticleInfo.mSimpleVideoColumnInfo.d.e)
    {
      oms.a(this.jdField_a_of_type_Oms, localBaseArticleInfo, localBaseArticleInfo.mSimpleVideoColumnInfo, 3, paramView);
      return;
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public View a(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131494524, paramViewGroup, false);
    this.jdField_a_of_type_AndroidViewView = paramViewGroup.findViewById(2131309736);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131311534));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131306045));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131299841));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramViewGroup.findViewById(2131302158));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup = ((VideoViewGroup)paramViewGroup.findViewById(2131313175));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131305410));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131305411));
    this.e = ((TextView)paramViewGroup.findViewById(2131303181));
    this.jdField_b_of_type_AndroidViewView = paramViewGroup.findViewById(2131311586);
    this.jdField_c_of_type_AndroidViewView = paramViewGroup.findViewById(2131311612);
    this.jdField_d_of_type_AndroidViewView = ((ViewGroup)paramViewGroup.findViewById(2131297792));
    this.f = ((TextView)paramViewGroup.findViewById(2131300583));
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramViewGroup.findViewById(2131300584));
    this.g = ((TextView)paramViewGroup.findViewById(2131300585));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131312796));
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
  
  public qht a()
  {
    return this.jdField_a_of_type_Qht;
  }
  
  public boolean a(View paramView)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (!qcn.a(oms.a(this.jdField_a_of_type_Oms, paramView))) {}
    int i;
    float f1;
    do
    {
      do
      {
        return false;
        i = qcn.d();
      } while (i == 0);
      f1 = obj.a(paramView);
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "BigImgVideoItemViewHolder() canAutoPlay percent:" + f1);
      }
      if (i == 1)
      {
        if ((pyu.a().f()) && (f1 >= 70.0F)) {}
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
    case 2131302158: 
    case 2131313175: 
      a(paramView);
      return;
    case 2131297792: 
    case 2131309736: 
      b(paramView);
      return;
    }
    c(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     omu
 * JD-Core Version:    0.7.0.1
 */