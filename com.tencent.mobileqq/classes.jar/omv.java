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

public class omv
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
  public KandianUrlImageView c;
  public View d;
  public TextView d;
  public TextView e;
  public TextView f;
  public TextView g;
  public TextView h;
  public TextView i;
  
  public omv(Context paramContext, oms paramoms)
  {
    super(paramContext, paramoms);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public View a(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131494523, paramViewGroup, false);
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
    this.f = ((TextView)paramViewGroup.findViewById(2131300596));
    this.g = ((TextView)paramViewGroup.findViewById(2131300581));
    this.h = ((TextView)paramViewGroup.findViewById(2131298911));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131312796));
    this.i = ((TextView)paramViewGroup.findViewById(2131300594));
    this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramViewGroup.findViewById(2131300597));
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramViewGroup.findViewById(2131302937));
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
        j = qcn.b();
      } while (j == 0);
      f1 = obj.a(paramView);
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "BigImgVideoItemViewHolder() canAutoPlay percent:" + f1);
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
                localObject1 = oms.a(this.jdField_a_of_type_Oms, paramView);
              } while (localObject1 == null);
              if ((qcn.c() == 1) && (this.jdField_a_of_type_Oms.a().a() != null))
              {
                localObject2 = this.jdField_a_of_type_Oms.a().a();
                if ((localObject2 != null) && (((qhp)localObject2).a() != null))
                {
                  ((qhp)localObject2).a().c(paramView);
                  return;
                }
              }
              localObject2 = oms.a(paramView);
            } while (localObject2 == null);
            if (obz.a(paramView.getContext(), (BaseArticleInfo)localObject1))
            {
              this.jdField_a_of_type_Oms.a().b(((omw)localObject2).a(), (BaseArticleInfo)localObject1);
              obz.a(paramView.getContext(), (BaseArticleInfo)localObject1, obz.i(((BaseArticleInfo)localObject1).getInnerUniqueID()));
              return;
            }
            if (qcn.b(this.jdField_a_of_type_Oms.a(), (BaseArticleInfo)localObject1))
            {
              this.jdField_a_of_type_Oms.a().b(((omw)localObject2).a(), (BaseArticleInfo)localObject1);
              return;
            }
          } while (localObject2 == null);
          this.jdField_a_of_type_Oms.a().a(((omw)localObject2).a(), (BaseArticleInfo)localObject1, false, true);
          return;
          localObject1 = oms.a(paramView);
        } while (localObject1 == null);
        localObject2 = this.jdField_a_of_type_Oms.a().b(this.jdField_a_of_type_Int);
        if (obz.a(paramView.getContext(), (BaseArticleInfo)localObject2))
        {
          this.jdField_a_of_type_Oms.a().b(((omw)localObject1).a(), (BaseArticleInfo)localObject2);
          obz.a(paramView.getContext(), (BaseArticleInfo)localObject2, obz.i(((BaseArticleInfo)localObject2).getInnerUniqueID()));
          return;
        }
        if (qcn.b(this.jdField_a_of_type_Oms.a(), (BaseArticleInfo)localObject2))
        {
          this.jdField_a_of_type_Oms.a().b(((omw)localObject1).a(), (BaseArticleInfo)localObject2);
          return;
        }
      } while (localObject1 == null);
      this.jdField_a_of_type_Oms.a().a(((omw)localObject1).a(), (BaseArticleInfo)localObject2, false, true);
      return;
      paramView = this.jdField_a_of_type_Oms.a().b(this.jdField_a_of_type_Int);
    } while ((paramView == null) || (paramView.familyCommentInfo == null));
    obz.a(this.jdField_a_of_type_AndroidContentContext, paramView, paramView.familyCommentInfo.b);
    QLog.d("ReadInJoyBaseAdapter", 2, "familyJumpUrl " + paramView.familyCommentInfo.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     omv
 * JD-Core Version:    0.7.0.1
 */