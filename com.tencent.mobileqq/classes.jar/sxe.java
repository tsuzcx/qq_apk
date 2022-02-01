import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.NativeAd.report.JumpMode;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.biz.pubaccount.readinjoy.view.VideoViewGroup;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class sxe
  extends sxl
  implements View.OnClickListener, qdh
{
  View a;
  public ImageView a;
  public TextView a;
  public KandianUrlImageView a;
  public VideoViewGroup a;
  public spk a;
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
  
  public sxe(Context paramContext, qdc paramqdc)
  {
    super(paramContext, paramqdc);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public View a(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560419, paramViewGroup, false);
    this.jdField_a_of_type_AndroidViewView = paramViewGroup.findViewById(2131376947);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131379001));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131372923));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131365915));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramViewGroup.findViewById(2131368501));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup = ((VideoViewGroup)paramViewGroup.findViewById(2131380944));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131372277));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131372278));
    this.e = ((TextView)paramViewGroup.findViewById(2131369734));
    this.jdField_b_of_type_AndroidViewView = paramViewGroup.findViewById(2131379056);
    this.jdField_c_of_type_AndroidViewView = paramViewGroup.findViewById(2131379083);
    this.jdField_d_of_type_AndroidViewView = paramViewGroup.findViewById(2131363691);
    this.f = ((TextView)paramViewGroup.findViewById(2131366729));
    this.g = ((TextView)paramViewGroup.findViewById(2131366714));
    this.h = ((TextView)paramViewGroup.findViewById(2131364924));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131380472));
    this.i = ((TextView)paramViewGroup.findViewById(2131366727));
    this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramViewGroup.findViewById(2131366730));
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramViewGroup.findViewById(2131369396));
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
  
  public spk a()
  {
    return this.jdField_a_of_type_Spk;
  }
  
  public boolean a(View paramView)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (!six.a(a(paramView))) {}
    int j;
    float f1;
    do
    {
      do
      {
        return false;
        j = six.f();
      } while (j == 0);
      f1 = pjr.a(paramView);
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "BigImgVideoItemViewHolder() canAutoPlay percent:" + f1);
      }
      if (j == 1)
      {
        if ((sge.a().e()) && (f1 >= 70.0F)) {}
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
    qdc.a(paramView);
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject1 = a(paramView);
      if (localObject1 != null)
      {
        if ((six.g() == 1) && (this.jdField_a_of_type_Qdc.a().a() != null))
        {
          localObject2 = this.jdField_a_of_type_Qdc.a().a();
          if ((localObject2 != null) && (((spg)localObject2).a() != null))
          {
            ((spg)localObject2).a().c(paramView);
            continue;
          }
        }
        Object localObject2 = a(paramView);
        if (localObject2 != null) {
          if (pqf.a(paramView.getContext(), (BaseArticleInfo)localObject1))
          {
            this.jdField_a_of_type_Qdc.a(((qdh)localObject2).a(), (BaseArticleInfo)localObject1);
            pqx.a(paramView.getContext(), (BaseArticleInfo)localObject1, pqx.b(((BaseArticleInfo)localObject1).getInnerUniqueID()));
          }
          else if (six.a(this.jdField_a_of_type_Qdc.a(), (BaseArticleInfo)localObject1) != JumpMode.FAIL)
          {
            this.jdField_a_of_type_Qdc.a(((qdh)localObject2).a(), (BaseArticleInfo)localObject1);
          }
          else if (localObject2 != null)
          {
            this.jdField_a_of_type_Qdc.a().a(((qdh)localObject2).a(), (BaseArticleInfo)localObject1, false, true);
            continue;
            localObject1 = a(paramView);
            if (localObject1 != null)
            {
              localObject2 = this.jdField_a_of_type_Qdc.a().b(this.jdField_a_of_type_Int);
              if (pqf.a(paramView.getContext(), (BaseArticleInfo)localObject2))
              {
                this.jdField_a_of_type_Qdc.a(((qdh)localObject1).a(), (BaseArticleInfo)localObject2);
                pqx.a(paramView.getContext(), (BaseArticleInfo)localObject2, pqx.b(((BaseArticleInfo)localObject2).getInnerUniqueID()));
              }
              else if (six.a(this.jdField_a_of_type_Qdc.a(), (BaseArticleInfo)localObject2) != JumpMode.FAIL)
              {
                this.jdField_a_of_type_Qdc.a(((qdh)localObject1).a(), (BaseArticleInfo)localObject2);
              }
              else if (localObject1 != null)
              {
                this.jdField_a_of_type_Qdc.a().a(((qdh)localObject1).a(), (BaseArticleInfo)localObject2, false, true);
                continue;
                localObject1 = this.jdField_a_of_type_Qdc.a().b(this.jdField_a_of_type_Int);
                if ((localObject1 != null) && (((BaseArticleInfo)localObject1).familyCommentInfo != null))
                {
                  pqx.a(this.jdField_a_of_type_AndroidContentContext, (BaseArticleInfo)localObject1, ((BaseArticleInfo)localObject1).familyCommentInfo.b);
                  QLog.d("ReadInJoyBaseAdapter", 2, "familyJumpUrl " + ((BaseArticleInfo)localObject1).familyCommentInfo.b);
                }
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sxe
 * JD-Core Version:    0.7.0.1
 */