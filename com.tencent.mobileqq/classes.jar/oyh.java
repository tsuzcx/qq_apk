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

public class oyh
  extends oyp
  implements View.OnClickListener, oyi
{
  View a;
  public ImageView a;
  public TextView a;
  public KandianUrlImageView a;
  public VideoViewGroup a;
  public qtv a;
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
  
  public oyh(Context paramContext, oye paramoye)
  {
    super(paramContext, paramoye);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public View a(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560095, paramViewGroup, false);
    this.jdField_a_of_type_AndroidViewView = paramViewGroup.findViewById(2131375493);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131377350));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131371742));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131365420));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramViewGroup.findViewById(2131367776));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup = ((VideoViewGroup)paramViewGroup.findViewById(2131379015));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131371103));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131371104));
    this.e = ((TextView)paramViewGroup.findViewById(2131368849));
    this.jdField_b_of_type_AndroidViewView = paramViewGroup.findViewById(2131377400);
    this.jdField_c_of_type_AndroidViewView = paramViewGroup.findViewById(2131377425);
    this.jdField_d_of_type_AndroidViewView = ((ViewGroup)paramViewGroup.findViewById(2131363338));
    this.f = ((TextView)paramViewGroup.findViewById(2131366198));
    this.g = ((TextView)paramViewGroup.findViewById(2131366183));
    this.h = ((TextView)paramViewGroup.findViewById(2131364470));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131378625));
    this.i = ((TextView)paramViewGroup.findViewById(2131366196));
    this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramViewGroup.findViewById(2131366199));
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramViewGroup.findViewById(2131368568));
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
  
  public qtv a()
  {
    return this.jdField_a_of_type_Qtv;
  }
  
  public boolean a(View paramView)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (!qoi.a(oye.a(this.jdField_a_of_type_Oye, paramView))) {}
    int j;
    float f1;
    do
    {
      do
      {
        return false;
        j = qoi.b();
      } while (j == 0);
      f1 = omr.a(paramView);
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "BigImgVideoItemViewHolder() canAutoPlay percent:" + f1);
      }
      if (j == 1)
      {
        if ((qkr.a().f()) && (f1 >= 70.0F)) {}
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
                localObject1 = oye.a(this.jdField_a_of_type_Oye, paramView);
              } while (localObject1 == null);
              if ((qoi.c() == 1) && (this.jdField_a_of_type_Oye.a().a() != null))
              {
                localObject2 = this.jdField_a_of_type_Oye.a().a();
                if ((localObject2 != null) && (((qtr)localObject2).a() != null))
                {
                  ((qtr)localObject2).a().c(paramView);
                  return;
                }
              }
              localObject2 = oye.a(paramView);
            } while (localObject2 == null);
            if (onh.a(paramView.getContext(), (BaseArticleInfo)localObject1))
            {
              this.jdField_a_of_type_Oye.a().b(((oyi)localObject2).a(), (BaseArticleInfo)localObject1);
              onh.a(paramView.getContext(), (BaseArticleInfo)localObject1, onh.i(((BaseArticleInfo)localObject1).getInnerUniqueID()));
              return;
            }
            if (qoi.b(this.jdField_a_of_type_Oye.a(), (BaseArticleInfo)localObject1))
            {
              this.jdField_a_of_type_Oye.a().b(((oyi)localObject2).a(), (BaseArticleInfo)localObject1);
              return;
            }
          } while (localObject2 == null);
          this.jdField_a_of_type_Oye.a().a(((oyi)localObject2).a(), (BaseArticleInfo)localObject1, false, true);
          return;
          localObject1 = oye.a(paramView);
        } while (localObject1 == null);
        localObject2 = this.jdField_a_of_type_Oye.a().b(this.jdField_a_of_type_Int);
        if (onh.a(paramView.getContext(), (BaseArticleInfo)localObject2))
        {
          this.jdField_a_of_type_Oye.a().b(((oyi)localObject1).a(), (BaseArticleInfo)localObject2);
          onh.a(paramView.getContext(), (BaseArticleInfo)localObject2, onh.i(((BaseArticleInfo)localObject2).getInnerUniqueID()));
          return;
        }
        if (qoi.b(this.jdField_a_of_type_Oye.a(), (BaseArticleInfo)localObject2))
        {
          this.jdField_a_of_type_Oye.a().b(((oyi)localObject1).a(), (BaseArticleInfo)localObject2);
          return;
        }
      } while (localObject1 == null);
      this.jdField_a_of_type_Oye.a().a(((oyi)localObject1).a(), (BaseArticleInfo)localObject2, false, true);
      return;
      paramView = this.jdField_a_of_type_Oye.a().b(this.jdField_a_of_type_Int);
    } while ((paramView == null) || (paramView.familyCommentInfo == null));
    onh.a(this.jdField_a_of_type_AndroidContentContext, paramView, paramView.familyCommentInfo.b);
    QLog.d("ReadInJoyBaseAdapter", 2, "familyJumpUrl " + paramView.familyCommentInfo.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oyh
 * JD-Core Version:    0.7.0.1
 */