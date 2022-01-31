import android.app.Activity;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianMsgBoxRedPntInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyHeadImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

public class rgp
  implements rgr
{
  private static Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private static Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  private int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private KandianMsgBoxRedPntInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo;
  private ReadInJoyHeadImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView;
  private View jdField_b_of_type_AndroidViewView;
  
  public rgp(Activity paramActivity, View paramView)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidViewView = paramView;
    c();
  }
  
  private void c()
  {
    jdField_a_of_type_AndroidGraphicsDrawableDrawable = new BitmapDrawable(BitmapFactory.decodeResource(BaseApplicationImpl.getApplication().getResources(), 2130841276));
    jdField_b_of_type_AndroidGraphicsDrawableDrawable = new BitmapDrawable(BitmapFactory.decodeResource(BaseApplicationImpl.getApplication().getResources(), 2130841277));
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView = ((ReadInJoyHeadImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367679));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setRound(true);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.a(jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364691));
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131376312);
    ImageView localImageView = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362806);
    if (localImageView.getDrawable() != null) {
      localImageView.setColorFilter(this.jdField_a_of_type_AndroidViewView.getResources().getColor(2131165275), PorterDuff.Mode.SRC_IN);
    }
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(new rgq(this));
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo != null))
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      nol.a(null, "", "0X800824A", "0X800824A", 0, 0, "", "", "", onh.d(), false);
    }
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public void a(KandianMsgBoxRedPntInfo paramKandianMsgBoxRedPntInfo)
  {
    if ((paramKandianMsgBoxRedPntInfo == null) || (paramKandianMsgBoxRedPntInfo.equals(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo)))
    {
      QLog.d("ReadinjoySocialMsgTips", 2, "210 msgInfo is null ! " + paramKandianMsgBoxRedPntInfo);
      return;
    }
    QLog.d("ReadinjoySocialMsgTips", 2, "set msg info , count : " + paramKandianMsgBoxRedPntInfo.mMsgCnt + ", uin : " + paramKandianMsgBoxRedPntInfo.mUin + ", seq : " + paramKandianMsgBoxRedPntInfo.mSeq);
    this.jdField_a_of_type_Int += 1;
    if (this.jdField_a_of_type_Int % 2 == 0)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.a(jdField_b_of_type_AndroidGraphicsDrawableDrawable);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo = paramKandianMsgBoxRedPntInfo;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo.mMsgType != 2) {
        break label274;
      }
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo.mIconUrl)) {
        break label228;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.a(onh.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo.mIconUrl));
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(bhvy.b(paramKandianMsgBoxRedPntInfo.mMsgCnt) + ajya.a(2131712783));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo.canDoAnimation = false;
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.a(jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      break;
      label228:
      Animatable localAnimatable = (Animatable)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.getResources().getDrawable(2130842370);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setImageDrawable((Drawable)localAnimatable);
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo.canDoAnimation)
      {
        localAnimatable.start();
        continue;
        label274:
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo.mIconUrl)) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.a(onh.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo.mIconUrl));
        } else if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo.mUin > 0L) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setHeadImgByUin(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo.mUin);
        }
      }
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidAppActivity = null;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView = null;
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_a_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rgp
 * JD-Core Version:    0.7.0.1
 */