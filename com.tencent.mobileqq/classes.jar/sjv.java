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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class sjv
  extends skb
  implements View.OnClickListener, psk
{
  View a;
  public ImageView a;
  public TextView a;
  public KandianUrlImageView a;
  public VideoViewGroup a;
  public sdg a;
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
  
  public sjv(Context paramContext, psf parampsf)
  {
    super(paramContext, parampsf);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public View a(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560369, paramViewGroup, false);
    this.jdField_a_of_type_AndroidViewView = paramViewGroup.findViewById(2131376679);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131378707));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131372730));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131365817));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramViewGroup.findViewById(2131368344));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup = ((VideoViewGroup)paramViewGroup.findViewById(2131380598));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131372084));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131372085));
    this.e = ((TextView)paramViewGroup.findViewById(2131369565));
    this.jdField_b_of_type_AndroidViewView = paramViewGroup.findViewById(2131378762);
    this.jdField_c_of_type_AndroidViewView = paramViewGroup.findViewById(2131378789);
    this.jdField_d_of_type_AndroidViewView = paramViewGroup.findViewById(2131363622);
    this.f = ((TextView)paramViewGroup.findViewById(2131366618));
    this.g = ((TextView)paramViewGroup.findViewById(2131366603));
    this.h = ((TextView)paramViewGroup.findViewById(2131364837));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131380137));
    this.i = ((TextView)paramViewGroup.findViewById(2131366616));
    this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramViewGroup.findViewById(2131366619));
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramViewGroup.findViewById(2131369233));
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
  
  public sdg a()
  {
    return this.jdField_a_of_type_Sdg;
  }
  
  public boolean a(View paramView)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (!rwv.a(a(paramView))) {}
    int j;
    float f1;
    do
    {
      do
      {
        return false;
        j = rwv.f();
      } while (j == 0);
      f1 = pai.a(paramView);
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "BigImgVideoItemViewHolder() canAutoPlay percent:" + f1);
      }
      if (j == 1)
      {
        if ((rtp.a().e()) && (f1 >= 70.0F)) {}
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
    psf.a(paramView);
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
        if ((rwv.g() == 1) && (this.jdField_a_of_type_Psf.a().a() != null))
        {
          localObject2 = this.jdField_a_of_type_Psf.a().a();
          if ((localObject2 != null) && (((sdc)localObject2).a() != null))
          {
            ((sdc)localObject2).a().c(paramView);
            continue;
          }
        }
        Object localObject2 = a(paramView);
        if (localObject2 != null) {
          if (pay.a(paramView.getContext(), (BaseArticleInfo)localObject1))
          {
            this.jdField_a_of_type_Psf.a(((psk)localObject2).a(), (BaseArticleInfo)localObject1);
            pay.a(paramView.getContext(), (BaseArticleInfo)localObject1, pay.i(((BaseArticleInfo)localObject1).getInnerUniqueID()));
          }
          else if (rwv.b(this.jdField_a_of_type_Psf.a(), (BaseArticleInfo)localObject1))
          {
            this.jdField_a_of_type_Psf.a(((psk)localObject2).a(), (BaseArticleInfo)localObject1);
          }
          else if (localObject2 != null)
          {
            this.jdField_a_of_type_Psf.a().a(((psk)localObject2).a(), (BaseArticleInfo)localObject1, false, true);
            continue;
            localObject1 = a(paramView);
            if (localObject1 != null)
            {
              localObject2 = this.jdField_a_of_type_Psf.a().b(this.jdField_a_of_type_Int);
              if (pay.a(paramView.getContext(), (BaseArticleInfo)localObject2))
              {
                this.jdField_a_of_type_Psf.a(((psk)localObject1).a(), (BaseArticleInfo)localObject2);
                pay.a(paramView.getContext(), (BaseArticleInfo)localObject2, pay.i(((BaseArticleInfo)localObject2).getInnerUniqueID()));
              }
              else if (rwv.b(this.jdField_a_of_type_Psf.a(), (BaseArticleInfo)localObject2))
              {
                this.jdField_a_of_type_Psf.a(((psk)localObject1).a(), (BaseArticleInfo)localObject2);
              }
              else if (localObject1 != null)
              {
                this.jdField_a_of_type_Psf.a().a(((psk)localObject1).a(), (BaseArticleInfo)localObject2, false, true);
                continue;
                localObject1 = this.jdField_a_of_type_Psf.a().b(this.jdField_a_of_type_Int);
                if ((localObject1 != null) && (((BaseArticleInfo)localObject1).familyCommentInfo != null))
                {
                  pay.a(this.jdField_a_of_type_AndroidContentContext, (BaseArticleInfo)localObject1, ((BaseArticleInfo)localObject1).familyCommentInfo.b);
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
 * Qualified Name:     sjv
 * JD-Core Version:    0.7.0.1
 */