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

public class omx
  extends ond
  implements View.OnClickListener, omw
{
  public View a;
  public ViewGroup a;
  public ImageView a;
  public RelativeLayout a;
  public TextView a;
  public KanDianUrlRoundCornerImageView a;
  public KandianUrlImageView a;
  public VideoViewGroup a;
  public qht a;
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
  
  public omx(Context paramContext, oms paramoms)
  {
    super(paramContext, paramoms);
  }
  
  private void a(View paramView)
  {
    BaseArticleInfo localBaseArticleInfo = oms.a(this.jdField_a_of_type_Oms, paramView);
    if ((localBaseArticleInfo != null) && (this.jdField_a_of_type_Oms != null) && (localBaseArticleInfo.mVideoColumnInfo != null) && (localBaseArticleInfo.mVideoColumnInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo != null) && (localBaseArticleInfo.mVideoColumnInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.jdField_a_of_type_Int != 3))
    {
      qcn.a(this.jdField_a_of_type_Oms.a(), localBaseArticleInfo.mVideoColumnInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo);
      if (localBaseArticleInfo.mVideoColumnInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo != null) {
        break label126;
      }
    }
    label126:
    for (paramView = null;; paramView = localBaseArticleInfo.mVideoColumnInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.e)
    {
      oms.a(this.jdField_a_of_type_Oms, localBaseArticleInfo, localBaseArticleInfo.mVideoColumnInfo, 1, paramView);
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
    if ((localBaseArticleInfo != null) && (this.jdField_a_of_type_Oms != null) && (localBaseArticleInfo.mVideoColumnInfo != null))
    {
      qcn.a(this.jdField_a_of_type_Oms.a(), localBaseArticleInfo.mVideoColumnInfo.jdField_c_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo);
      qcn.a(obz.a(), localBaseArticleInfo.mVideoColumnInfo.jdField_a_of_type_Int);
      localBaseArticleInfo.mVideoColumnInfo.jdField_a_of_type_Boolean = true;
      VideoColumnInfo localVideoColumnInfo = localBaseArticleInfo.mVideoColumnInfo;
      localVideoColumnInfo.jdField_c_of_type_Int += 1;
      ogy.a().a((ArticleInfo)localBaseArticleInfo);
      paramView.setVisibility(8);
      if (localBaseArticleInfo.mVideoColumnInfo.jdField_c_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo != null) {
        break label123;
      }
    }
    label123:
    for (paramView = null;; paramView = localBaseArticleInfo.mVideoColumnInfo.jdField_c_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.e)
    {
      oms.a(this.jdField_a_of_type_Oms, localBaseArticleInfo, localBaseArticleInfo.mVideoColumnInfo, 2, paramView);
      return;
    }
  }
  
  private void c(View paramView)
  {
    BaseArticleInfo localBaseArticleInfo = oms.a(this.jdField_a_of_type_Oms, paramView);
    if ((localBaseArticleInfo != null) && (this.jdField_a_of_type_Oms != null) && (localBaseArticleInfo.mVideoColumnInfo != null) && (localBaseArticleInfo.mVideoColumnInfo.b != null) && (localBaseArticleInfo.mVideoColumnInfo.b.jdField_a_of_type_Int != 3))
    {
      qcn.a(this.jdField_a_of_type_Oms.a(), localBaseArticleInfo.mVideoColumnInfo.b);
      if (localBaseArticleInfo.mVideoColumnInfo.b != null) {
        break label126;
      }
    }
    label126:
    for (paramView = null;; paramView = localBaseArticleInfo.mVideoColumnInfo.b.e)
    {
      oms.a(this.jdField_a_of_type_Oms, localBaseArticleInfo, localBaseArticleInfo.mVideoColumnInfo, 3, paramView);
      return;
      paramView = oms.a(paramView);
      if (paramView == null) {
        break;
      }
      this.jdField_a_of_type_Oms.a().a(paramView.a(), localBaseArticleInfo, false, false);
      break;
    }
  }
  
  private void d(View paramView)
  {
    BaseArticleInfo localBaseArticleInfo = oms.a(this.jdField_a_of_type_Oms, paramView);
    if ((localBaseArticleInfo != null) && (this.jdField_a_of_type_Oms != null) && (localBaseArticleInfo.mVideoColumnInfo != null))
    {
      qcn.a(this.jdField_a_of_type_Oms.a(), localBaseArticleInfo.mVideoColumnInfo.d);
      if (localBaseArticleInfo.mVideoColumnInfo.d != null) {
        break label71;
      }
    }
    label71:
    for (paramView = null;; paramView = localBaseArticleInfo.mVideoColumnInfo.d.e)
    {
      oms.a(this.jdField_a_of_type_Oms, localBaseArticleInfo, localBaseArticleInfo.mVideoColumnInfo, 4, paramView);
      return;
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public View a(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131494525, paramViewGroup, false);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramViewGroup.findViewById(2131301833));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramViewGroup.findViewById(2131301834));
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramViewGroup.findViewById(2131298860));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131298862));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131298861));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131310852));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramViewGroup.findViewById(2131299141));
    this.d = ((TextView)paramViewGroup.findViewById(2131311534));
    this.e = ((TextView)paramViewGroup.findViewById(2131306045));
    this.f = ((TextView)paramViewGroup.findViewById(2131299841));
    this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramViewGroup.findViewById(2131302158));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup = ((VideoViewGroup)paramViewGroup.findViewById(2131313175));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131305410));
    this.g = ((TextView)paramViewGroup.findViewById(2131305411));
    this.h = ((TextView)paramViewGroup.findViewById(2131303181));
    this.jdField_a_of_type_AndroidViewView = paramViewGroup.findViewById(2131311586);
    this.jdField_b_of_type_AndroidViewView = paramViewGroup.findViewById(2131311612);
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)paramViewGroup.findViewById(2131297120));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView = ((KanDianUrlRoundCornerImageView)paramViewGroup.findViewById(2131298858));
    this.i = ((TextView)paramViewGroup.findViewById(2131298859));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131312796));
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
  
  public qht a()
  {
    return this.jdField_a_of_type_Qht;
  }
  
  public boolean a(View paramView)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (!qcn.a(oms.a(this.jdField_a_of_type_Oms, paramView))) {}
    int j;
    float f1;
    do
    {
      do
      {
        return false;
        j = qcn.a();
      } while (j == 0);
      f1 = obj.a(paramView);
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "VideoColumnItemViewHolder() canAutoPlay percent:" + f1);
      }
      if (j == 1)
      {
        if ((pyu.a().f()) && (f1 >= 70.0F)) {}
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
    case 2131310852: 
      b(paramView);
      return;
    case 2131301833: 
      a(paramView);
      return;
    case 2131302158: 
    case 2131313175: 
      c(paramView);
      return;
    }
    d(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     omx
 * JD-Core Version:    0.7.0.1
 */