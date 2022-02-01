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

public class pmv
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
  public KandianUrlImageView c;
  public View d;
  public TextView d;
  public TextView e;
  public TextView f;
  public TextView g;
  public TextView h;
  public TextView i;
  
  public pmv(Context paramContext, pms parampms)
  {
    super(paramContext, parampms);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public View a(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560361, paramViewGroup, false);
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
    this.f = ((TextView)paramViewGroup.findViewById(2131366591));
    this.g = ((TextView)paramViewGroup.findViewById(2131366576));
    this.h = ((TextView)paramViewGroup.findViewById(2131364807));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131380413));
    this.i = ((TextView)paramViewGroup.findViewById(2131366589));
    this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramViewGroup.findViewById(2131366592));
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramViewGroup.findViewById(2131369211));
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
        j = rpt.f();
      } while (j == 0);
      f1 = ozc.a(paramView);
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "BigImgVideoItemViewHolder() canAutoPlay percent:" + f1);
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
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject1 = pms.a(this.jdField_a_of_type_Pms, paramView);
      if (localObject1 != null)
      {
        if ((rpt.g() == 1) && (this.jdField_a_of_type_Pms.a().a() != null))
        {
          localObject2 = this.jdField_a_of_type_Pms.a().a();
          if ((localObject2 != null) && (((rvy)localObject2).a() != null))
          {
            ((rvy)localObject2).a().c(paramView);
            continue;
          }
        }
        Object localObject2 = pms.a(paramView);
        if (localObject2 != null) {
          if (ozs.a(paramView.getContext(), (BaseArticleInfo)localObject1))
          {
            this.jdField_a_of_type_Pms.a().b(((pmw)localObject2).a(), (BaseArticleInfo)localObject1);
            ozs.a(paramView.getContext(), (BaseArticleInfo)localObject1, ozs.i(((BaseArticleInfo)localObject1).getInnerUniqueID()));
          }
          else if (rpt.b(this.jdField_a_of_type_Pms.a(), (BaseArticleInfo)localObject1))
          {
            this.jdField_a_of_type_Pms.a().b(((pmw)localObject2).a(), (BaseArticleInfo)localObject1);
          }
          else if (localObject2 != null)
          {
            this.jdField_a_of_type_Pms.a().a(((pmw)localObject2).a(), (BaseArticleInfo)localObject1, false, true);
            continue;
            localObject1 = pms.a(paramView);
            if (localObject1 != null)
            {
              localObject2 = this.jdField_a_of_type_Pms.a().b(this.jdField_a_of_type_Int);
              if (ozs.a(paramView.getContext(), (BaseArticleInfo)localObject2))
              {
                this.jdField_a_of_type_Pms.a().b(((pmw)localObject1).a(), (BaseArticleInfo)localObject2);
                ozs.a(paramView.getContext(), (BaseArticleInfo)localObject2, ozs.i(((BaseArticleInfo)localObject2).getInnerUniqueID()));
              }
              else if (rpt.b(this.jdField_a_of_type_Pms.a(), (BaseArticleInfo)localObject2))
              {
                this.jdField_a_of_type_Pms.a().b(((pmw)localObject1).a(), (BaseArticleInfo)localObject2);
              }
              else if (localObject1 != null)
              {
                this.jdField_a_of_type_Pms.a().a(((pmw)localObject1).a(), (BaseArticleInfo)localObject2, false, true);
                continue;
                localObject1 = this.jdField_a_of_type_Pms.a().b(this.jdField_a_of_type_Int);
                if ((localObject1 != null) && (((BaseArticleInfo)localObject1).familyCommentInfo != null))
                {
                  ozs.a(this.jdField_a_of_type_AndroidContentContext, (BaseArticleInfo)localObject1, ((BaseArticleInfo)localObject1).familyCommentInfo.b);
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
 * Qualified Name:     pmv
 * JD-Core Version:    0.7.0.1
 */