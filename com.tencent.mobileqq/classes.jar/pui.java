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

public class pui
  extends puq
  implements View.OnClickListener, puj
{
  View a;
  public ImageView a;
  public TextView a;
  public KandianUrlImageView a;
  public VideoViewGroup a;
  public sey a;
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
  
  public pui(Context paramContext, puf parampuf)
  {
    super(paramContext, parampuf);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public View a(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560349, paramViewGroup, false);
    this.jdField_a_of_type_AndroidViewView = paramViewGroup.findViewById(2131376788);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131378776));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131372651));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131365742));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramViewGroup.findViewById(2131368246));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup = ((VideoViewGroup)paramViewGroup.findViewById(2131380694));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131372005));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131372006));
    this.e = ((TextView)paramViewGroup.findViewById(2131369482));
    this.jdField_b_of_type_AndroidViewView = paramViewGroup.findViewById(2131378831);
    this.jdField_c_of_type_AndroidViewView = paramViewGroup.findViewById(2131378858);
    this.jdField_d_of_type_AndroidViewView = paramViewGroup.findViewById(2131363569);
    this.f = ((TextView)paramViewGroup.findViewById(2131366542));
    this.g = ((TextView)paramViewGroup.findViewById(2131366527));
    this.h = ((TextView)paramViewGroup.findViewById(2131364760));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131380227));
    this.i = ((TextView)paramViewGroup.findViewById(2131366540));
    this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramViewGroup.findViewById(2131366543));
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramViewGroup.findViewById(2131369121));
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
  
  public sey a()
  {
    return this.jdField_a_of_type_Sey;
  }
  
  public boolean a(View paramView)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (!ryx.a(puf.a(this.jdField_a_of_type_Puf, paramView))) {}
    int j;
    float f1;
    do
    {
      do
      {
        return false;
        j = ryx.f();
      } while (j == 0);
      f1 = pgk.a(paramView);
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "BigImgVideoItemViewHolder() canAutoPlay percent:" + f1);
      }
      if (j == 1)
      {
        if ((rvr.a().e()) && (f1 >= 70.0F)) {}
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
    puf.a(paramView);
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject1 = puf.a(this.jdField_a_of_type_Puf, paramView);
      if (localObject1 != null)
      {
        if ((ryx.g() == 1) && (this.jdField_a_of_type_Puf.a().a() != null))
        {
          localObject2 = this.jdField_a_of_type_Puf.a().a();
          if ((localObject2 != null) && (((seu)localObject2).a() != null))
          {
            ((seu)localObject2).a().c(paramView);
            continue;
          }
        }
        Object localObject2 = puf.a(paramView);
        if (localObject2 != null) {
          if (pha.a(paramView.getContext(), (BaseArticleInfo)localObject1))
          {
            this.jdField_a_of_type_Puf.a().b(((puj)localObject2).a(), (BaseArticleInfo)localObject1);
            pha.a(paramView.getContext(), (BaseArticleInfo)localObject1, pha.i(((BaseArticleInfo)localObject1).getInnerUniqueID()));
          }
          else if (ryx.b(this.jdField_a_of_type_Puf.a(), (BaseArticleInfo)localObject1))
          {
            this.jdField_a_of_type_Puf.a().b(((puj)localObject2).a(), (BaseArticleInfo)localObject1);
          }
          else if (localObject2 != null)
          {
            this.jdField_a_of_type_Puf.a().a(((puj)localObject2).a(), (BaseArticleInfo)localObject1, false, true);
            continue;
            localObject1 = puf.a(paramView);
            if (localObject1 != null)
            {
              localObject2 = this.jdField_a_of_type_Puf.a().b(this.jdField_a_of_type_Int);
              if (pha.a(paramView.getContext(), (BaseArticleInfo)localObject2))
              {
                this.jdField_a_of_type_Puf.a().b(((puj)localObject1).a(), (BaseArticleInfo)localObject2);
                pha.a(paramView.getContext(), (BaseArticleInfo)localObject2, pha.i(((BaseArticleInfo)localObject2).getInnerUniqueID()));
              }
              else if (ryx.b(this.jdField_a_of_type_Puf.a(), (BaseArticleInfo)localObject2))
              {
                this.jdField_a_of_type_Puf.a().b(((puj)localObject1).a(), (BaseArticleInfo)localObject2);
              }
              else if (localObject1 != null)
              {
                this.jdField_a_of_type_Puf.a().a(((puj)localObject1).a(), (BaseArticleInfo)localObject2, false, true);
                continue;
                localObject1 = this.jdField_a_of_type_Puf.a().b(this.jdField_a_of_type_Int);
                if ((localObject1 != null) && (((BaseArticleInfo)localObject1).familyCommentInfo != null))
                {
                  pha.a(this.jdField_a_of_type_AndroidContentContext, (BaseArticleInfo)localObject1, ((BaseArticleInfo)localObject1).familyCommentInfo.b);
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
 * Qualified Name:     pui
 * JD-Core Version:    0.7.0.1
 */