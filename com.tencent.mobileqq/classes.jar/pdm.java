import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.biz.pubaccount.readinjoy.view.VideoViewGroup;
import com.tencent.qphone.base.util.QLog;

public class pdm
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
  public KandianUrlImageView c;
  public View d;
  public TextView d;
  public TextView e;
  public TextView f;
  public TextView g;
  public TextView h;
  public TextView i;
  
  public pdm(Context paramContext, pdj parampdj)
  {
    super(paramContext, parampdj);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public View a(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560196, paramViewGroup, false);
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
    this.f = ((TextView)paramViewGroup.findViewById(2131366288));
    this.g = ((TextView)paramViewGroup.findViewById(2131366273));
    this.h = ((TextView)paramViewGroup.findViewById(2131364544));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131379300));
    this.i = ((TextView)paramViewGroup.findViewById(2131366286));
    this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramViewGroup.findViewById(2131366289));
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramViewGroup.findViewById(2131368776));
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setTag(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup.setTag(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup.setOnClickListener(this);
    this.jdField_d_of_type_AndroidViewView.setTag(this);
    this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
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
    int j;
    float f1;
    do
    {
      do
      {
        return false;
        j = rdm.b();
      } while (j == 0);
      f1 = orc.a(paramView);
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "BigImgVideoItemViewHolder() canAutoPlay percent:" + f1);
      }
      if (j == 1)
      {
        if ((qzy.a().f()) && (f1 >= 70.0F)) {}
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
    }
    do
    {
      Object localObject1;
      Object localObject2;
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                localObject1 = pdj.a(this.jdField_a_of_type_Pdj, paramView);
              } while (localObject1 == null);
              if ((rdm.c() == 1) && (this.jdField_a_of_type_Pdj.a().a() != null))
              {
                localObject2 = this.jdField_a_of_type_Pdj.a().a();
                if ((localObject2 != null) && (((rjg)localObject2).a() != null))
                {
                  ((rjg)localObject2).a().c(paramView);
                  return;
                }
              }
              localObject2 = pdj.a(paramView);
            } while (localObject2 == null);
            if (ors.a(paramView.getContext(), (BaseArticleInfo)localObject1))
            {
              this.jdField_a_of_type_Pdj.a().b(((pdn)localObject2).a(), (BaseArticleInfo)localObject1);
              ors.a(paramView.getContext(), (BaseArticleInfo)localObject1, ors.i(((BaseArticleInfo)localObject1).getInnerUniqueID()));
              return;
            }
            if (rdm.b(this.jdField_a_of_type_Pdj.a(), (BaseArticleInfo)localObject1))
            {
              this.jdField_a_of_type_Pdj.a().b(((pdn)localObject2).a(), (BaseArticleInfo)localObject1);
              return;
            }
          } while (localObject2 == null);
          this.jdField_a_of_type_Pdj.a().a(((pdn)localObject2).a(), (BaseArticleInfo)localObject1, false, true);
          return;
          localObject1 = pdj.a(paramView);
        } while (localObject1 == null);
        localObject2 = this.jdField_a_of_type_Pdj.a().b(this.jdField_a_of_type_Int);
        if (ors.a(paramView.getContext(), (BaseArticleInfo)localObject2))
        {
          this.jdField_a_of_type_Pdj.a().b(((pdn)localObject1).a(), (BaseArticleInfo)localObject2);
          ors.a(paramView.getContext(), (BaseArticleInfo)localObject2, ors.i(((BaseArticleInfo)localObject2).getInnerUniqueID()));
          return;
        }
        if (rdm.b(this.jdField_a_of_type_Pdj.a(), (BaseArticleInfo)localObject2))
        {
          this.jdField_a_of_type_Pdj.a().b(((pdn)localObject1).a(), (BaseArticleInfo)localObject2);
          return;
        }
      } while (localObject1 == null);
      this.jdField_a_of_type_Pdj.a().a(((pdn)localObject1).a(), (BaseArticleInfo)localObject2, false, true);
      return;
      paramView = this.jdField_a_of_type_Pdj.a().b(this.jdField_a_of_type_Int);
    } while ((paramView == null) || (paramView.familyCommentInfo == null));
    ors.a(this.jdField_a_of_type_AndroidContentContext, paramView, paramView.familyCommentInfo.b);
    QLog.d("ReadInJoyBaseAdapter", 2, "familyJumpUrl " + paramView.familyCommentInfo.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pdm
 * JD-Core Version:    0.7.0.1
 */